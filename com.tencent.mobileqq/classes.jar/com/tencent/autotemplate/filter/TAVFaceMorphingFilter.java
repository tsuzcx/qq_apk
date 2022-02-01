package com.tencent.autotemplate.filter;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.Rect;
import android.util.Pair;
import com.tencent.autotemplate.extra.FaceInfo;
import com.tencent.autotemplate.extra.FrameInfo;
import com.tencent.autotemplate.transition.FaceTransition;
import com.tencent.gradientface.SmartKitGradientFaceEffect;
import com.tencent.gradientface.SmartKitGradientFaceInfo;
import com.tencent.gradientface.SmartKitGradientFaceInput;
import com.tencent.tav.coremedia.CGRect;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tav.coremedia.TextureInfo;
import com.tencent.tav.decoder.RenderContext;
import com.tencent.tavkit.ciimage.CIImage;
import com.tencent.tavkit.ciimage.TAVGLUtils;
import com.tencent.tavkit.composition.TAVClip;
import com.tencent.tavkit.composition.model.TAVVideoCompositionTrack;
import com.tencent.tavkit.composition.model.TAVVideoConfiguration.TAVVideoConfigurationContentMode;
import com.tencent.tavkit.composition.video.ImageCollection;
import com.tencent.tavkit.composition.video.ImageCollection.TrackImagePair;
import com.tencent.tavkit.composition.video.RenderInfo;
import com.tencent.tavkit.composition.video.TAVVideoMixEffect;
import com.tencent.tavkit.utils.BenchUtil;
import com.tencent.tavsticker.utils.CollectionUtil;
import com.tencent.ttpic.openapi.PTFaceAttr;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.jetbrains.annotations.NotNull;

public class TAVFaceMorphingFilter
  extends TAVBaseMixFilter
{
  private static final String TAG = "TAVAutoTemplateExtraFilter";
  private List<FaceTransition> faceTransitions;
  private SmartKitGradientFaceEffect gradientFaceEffect;
  
  public TAVFaceMorphingFilter(@NotNull List<FaceTransition> paramList)
  {
    this.faceTransitions = paramList;
  }
  
  private CIImage faceTransition(SmartKitGradientFaceInfo paramSmartKitGradientFaceInfo1, SmartKitGradientFaceInfo paramSmartKitGradientFaceInfo2, float paramFloat)
  {
    paramSmartKitGradientFaceInfo1 = new SmartKitGradientFaceInput(paramSmartKitGradientFaceInfo1, paramSmartKitGradientFaceInfo2, paramFloat);
    getGradientFaceEffect().setValueForRender("inputGradientFace", paramSmartKitGradientFaceInfo1);
    paramSmartKitGradientFaceInfo1 = getGradientFaceEffect().render();
    return new CIImage(new TextureInfo(((Integer)paramSmartKitGradientFaceInfo1.get("outputGradientFace")).intValue(), 3553, ((Integer)paramSmartKitGradientFaceInfo1.get("outputGradientFaceWidth")).intValue(), ((Integer)paramSmartKitGradientFaceInfo1.get("outputGradientFaceHeight")).intValue(), 0));
  }
  
  private PTFaceAttr getFaceInfo(ImageCollection.TrackImagePair paramTrackImagePair, TextureInfo paramTextureInfo)
  {
    if ((paramTrackImagePair != null) && (paramTrackImagePair.getTrack() != null) && ((paramTrackImagePair.getTrack().getExtraTrackInfo("extra_face_info") instanceof FaceInfo))) {
      return transform((FaceInfo)paramTrackImagePair.getTrack().getExtraTrackInfo("extra_face_info"), paramTextureInfo);
    }
    return null;
  }
  
  private List<PTFaceAttr> getFaceInfos(List<ImageCollection.TrackImagePair> paramList, List<TextureInfo> paramList1)
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < paramList.size())
    {
      localArrayList.add(getFaceInfo((ImageCollection.TrackImagePair)paramList.get(i), (TextureInfo)paramList1.get(i)));
      i += 1;
    }
    return localArrayList;
  }
  
  private Rect getFrameInfo(ImageCollection.TrackImagePair paramTrackImagePair, TextureInfo paramTextureInfo)
  {
    if ((paramTrackImagePair != null) && (paramTrackImagePair.getTrack() != null) && ((paramTrackImagePair.getTrack().getExtraTrackInfo("extra_frame_info") instanceof FrameInfo))) {
      return transform((FrameInfo)paramTrackImagePair.getTrack().getExtraTrackInfo("extra_frame_info"), paramTextureInfo);
    }
    return null;
  }
  
  private List<Rect> getFrameInfos(List<ImageCollection.TrackImagePair> paramList, List<TextureInfo> paramList1)
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < paramList.size())
    {
      localArrayList.add(getFrameInfo((ImageCollection.TrackImagePair)paramList.get(i), (TextureInfo)paramList1.get(i)));
      i += 1;
    }
    return localArrayList;
  }
  
  private SmartKitGradientFaceEffect getGradientFaceEffect()
  {
    if (this.gradientFaceEffect == null)
    {
      this.gradientFaceEffect = new SmartKitGradientFaceEffect();
      this.gradientFaceEffect.prepare();
    }
    return this.gradientFaceEffect;
  }
  
  private float getTransitionProgress()
  {
    CMTimeRange localCMTimeRange = getTransitionTimeRange(this.currentTime);
    if (localCMTimeRange == null) {
      return 0.0F;
    }
    float f2 = (float)(this.currentTime.getTimeUs() - localCMTimeRange.getStartUs()) / (float)localCMTimeRange.getDurationUs();
    if (f2 < 0.0F) {
      return 0.0F;
    }
    float f1 = f2;
    if (f2 > 1.0F) {
      f1 = 1.0F;
    }
    return f1;
  }
  
  private CMTimeRange getTransitionTimeRange(CMTime paramCMTime)
  {
    Iterator localIterator = this.faceTransitions.iterator();
    while (localIterator.hasNext())
    {
      CMTimeRange localCMTimeRange = ((FaceTransition)localIterator.next()).timeRange;
      if (localCMTimeRange.containsTime(paramCMTime)) {
        return localCMTimeRange;
      }
    }
    return null;
  }
  
  private boolean needTransition()
  {
    Iterator localIterator = this.faceTransitions.iterator();
    while (localIterator.hasNext()) {
      if (((FaceTransition)localIterator.next()).timeRange.containsTime(this.currentTime)) {
        return true;
      }
    }
    return false;
  }
  
  private Rect transform(FrameInfo paramFrameInfo, TextureInfo paramTextureInfo)
  {
    Rect localRect = paramFrameInfo.frame;
    float f1 = paramTextureInfo.width / paramFrameInfo.sourceWidth;
    float f2 = paramTextureInfo.height / paramFrameInfo.sourceHeight;
    return new Rect((int)(localRect.left * f1), (int)(localRect.top * f2), (int)(localRect.right * f1), (int)(localRect.bottom * f2));
  }
  
  private PTFaceAttr transform(FaceInfo paramFaceInfo, TextureInfo paramTextureInfo)
  {
    float f = paramFaceInfo.sourceWidth / paramTextureInfo.width;
    paramFaceInfo = paramFaceInfo.faceAttr;
    paramFaceInfo.setFaceDetectScale(f);
    return paramFaceInfo;
  }
  
  public CIImage apply(TAVVideoMixEffect paramTAVVideoMixEffect, ImageCollection paramImageCollection, RenderInfo paramRenderInfo)
  {
    super.apply(paramTAVVideoMixEffect, paramImageCollection, paramRenderInfo);
    List localList = paramImageCollection.getVideoChannelImages();
    CGSize localCGSize = paramRenderInfo.getRenderSize();
    boolean bool = CollectionUtil.isEmptyList(localList);
    paramTAVVideoMixEffect = null;
    paramImageCollection = null;
    if (!bool)
    {
      BenchUtil.benchStart("renderExtraChain");
      paramTAVVideoMixEffect = paramImageCollection;
      if (needTransition())
      {
        paramTAVVideoMixEffect = paramImageCollection;
        if (localList.size() >= 2)
        {
          paramTAVVideoMixEffect = getCachedTextures(localList, paramRenderInfo, localCGSize);
          getFrameInfos(localList, paramTAVVideoMixEffect);
          paramTAVVideoMixEffect = transitionRender(paramTAVVideoMixEffect, getFaceInfos(localList, paramTAVVideoMixEffect), localCGSize);
        }
      }
      BenchUtil.benchEnd("renderExtraChain");
      this.renderContext.makeCurrent();
    }
    return paramTAVVideoMixEffect;
  }
  
  public Pair<CIImage, CGSize> applyContentMode(ImageCollection.TrackImagePair paramTrackImagePair, CGSize paramCGSize, RenderInfo paramRenderInfo)
  {
    paramTrackImagePair = super.applyContentMode(paramTrackImagePair, paramCGSize, paramRenderInfo);
    ((CIImage)paramTrackImagePair.first).applyFlip(false, true);
    return paramTrackImagePair;
  }
  
  public Bitmap debugFaceInfo(PTFaceAttr paramPTFaceAttr, TextureInfo paramTextureInfo)
  {
    paramTextureInfo = TAVGLUtils.saveBitmap(paramTextureInfo);
    Canvas localCanvas = new Canvas(paramTextureInfo);
    Object localObject = (List)paramPTFaceAttr.getAllFacePoints().get(0);
    double d1 = paramPTFaceAttr.getFaceDetectScale();
    paramPTFaceAttr = new Paint();
    paramPTFaceAttr.setColor(Color.parseColor("#ff00ff"));
    paramPTFaceAttr.setAntiAlias(true);
    paramPTFaceAttr.setStrokeWidth(3.0F);
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      PointF localPointF = (PointF)((Iterator)localObject).next();
      double d2 = localPointF.x;
      Double.isNaN(d2);
      float f = (float)(d2 / d1);
      d2 = localPointF.y;
      Double.isNaN(d2);
      localCanvas.drawPoint(f, (float)(d2 / d1), paramPTFaceAttr);
    }
    return paramTextureInfo;
  }
  
  public List<TextureInfo> getCachedTextures(List<ImageCollection.TrackImagePair> paramList, RenderInfo paramRenderInfo, CGSize paramCGSize)
  {
    int j = paramList.size();
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < j)
    {
      Object localObject = (ImageCollection.TrackImagePair)paramList.get(i);
      if (localObject != null)
      {
        localObject = applyContentMode((ImageCollection.TrackImagePair)localObject, paramCGSize, paramRenderInfo);
        localArrayList.add(getCachedTexture((CIImage)((Pair)localObject).first, (CGSize)((Pair)localObject).second, paramRenderInfo));
      }
      i += 1;
    }
    return localArrayList;
  }
  
  public String getReportKey()
  {
    return "TAVAutoTemplateExtraFilter";
  }
  
  public boolean needRender(ImageCollection paramImageCollection, CMTime paramCMTime)
  {
    paramImageCollection = paramImageCollection.getVideoChannelImages();
    if (CollectionUtil.isEmptyList(paramImageCollection)) {
      return false;
    }
    if (getTransitionTimeRange(paramCMTime) == null) {
      return false;
    }
    paramImageCollection = paramImageCollection.iterator();
    while (paramImageCollection.hasNext())
    {
      Object localObject = ((ImageCollection.TrackImagePair)paramImageCollection.next()).getTrack();
      if ((localObject instanceof TAVClip))
      {
        paramCMTime = ((TAVVideoCompositionTrack)localObject).getExtraTrackInfo("extra_face_info");
        localObject = ((TAVVideoCompositionTrack)localObject).getExtraTrackInfo("extra_frame_info");
        if ((paramCMTime == null) || (localObject == null)) {
          return false;
        }
      }
    }
    return true;
  }
  
  public void release()
  {
    super.release();
    SmartKitGradientFaceEffect localSmartKitGradientFaceEffect = this.gradientFaceEffect;
    if (localSmartKitGradientFaceEffect != null)
    {
      localSmartKitGradientFaceEffect.clean();
      this.gradientFaceEffect = null;
    }
  }
  
  public CIImage transitionRender(List<TextureInfo> paramList, List<PTFaceAttr> paramList1, CGSize paramCGSize)
  {
    TextureInfo localTextureInfo = (TextureInfo)paramList.get(0);
    paramList = (TextureInfo)paramList.get(1);
    Object localObject = (PTFaceAttr)paramList1.get(0);
    paramList1 = (PTFaceAttr)paramList1.get(1);
    localObject = new SmartKitGradientFaceInfo(localTextureInfo.textureID, (PTFaceAttr)localObject);
    ((SmartKitGradientFaceInfo)localObject).width = localTextureInfo.width;
    ((SmartKitGradientFaceInfo)localObject).height = localTextureInfo.height;
    paramList1 = new SmartKitGradientFaceInfo(paramList.textureID, paramList1);
    paramList1.width = paramList.width;
    paramList1.height = paramList.height;
    paramList = faceTransition((SmartKitGradientFaceInfo)localObject, paramList1, getTransitionProgress());
    paramList.applyFlip(false, true);
    paramList.applyFillInFrame(new CGRect(new PointF(), paramCGSize), TAVVideoConfiguration.TAVVideoConfigurationContentMode.aspectFill);
    paramList1 = paramList.getSize();
    paramList1.width = paramCGSize.width;
    paramList1.height = paramCGSize.height;
    return paramList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.autotemplate.filter.TAVFaceMorphingFilter
 * JD-Core Version:    0.7.0.1
 */