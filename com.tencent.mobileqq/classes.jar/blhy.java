import android.graphics.Bitmap;
import android.graphics.PointF;
import android.text.TextUtils;
import com.tencent.aekit.api.standard.AEModule;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.aekit.openrender.internal.FrameBufferCache;
import com.tencent.aekit.openrender.internal.VideoFilterBase;
import com.tencent.ttpic.baseutils.bitmap.BitmapUtils;
import com.tencent.ttpic.baseutils.device.DeviceUtils;
import com.tencent.ttpic.baseutils.io.FileUtils;
import com.tencent.ttpic.baseutils.log.LogUtils;
import com.tencent.ttpic.filter.CFFaceOffFilter;
import com.tencent.ttpic.filter.CFSkinCropFilter;
import com.tencent.ttpic.filter.CFSkinCropFilterV2;
import com.tencent.ttpic.model.SizeI;
import com.tencent.ttpic.openapi.PTFaceAttr;
import com.tencent.ttpic.openapi.PTFaceDetector;
import com.tencent.ttpic.openapi.filter.SimpleGLThread;
import com.tencent.ttpic.openapi.model.CosFunParam;
import com.tencent.ttpic.openapi.model.CrazyFaceDataTemplate;
import com.tencent.ttpic.openapi.model.FaceImageLayer;
import com.tencent.ttpic.openapi.util.CfTemplateParser;
import com.tencent.ttpic.openapi.util.VideoMaterialUtil;
import com.tencent.ttpic.util.AlgoUtils;
import com.tencent.ttpic.util.CosFunUtil;
import com.tencent.ttpic.util.FaceOffUtil;
import com.tencent.view.RendererUtils;
import dov.com.qq.im.ae.play.FaceChangeUtils.2;
import dov.com.qq.im.ae.play.FaceChangeUtils.3;
import dov.com.qq.im.ae.play.FaceChangeUtils.4;
import dov.com.qq.im.ae.play.FaceChangeUtils.5;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public final class blhy
{
  private static SizeI a()
  {
    if (DeviceUtils.hasDeviceHigh(AEModule.getContext())) {
      return new SizeI(1080, 1920);
    }
    if (DeviceUtils.hasDeviceNormal(AEModule.getContext())) {
      return new SizeI(720, 1280);
    }
    return new SizeI(720, 1280);
  }
  
  public static PTFaceAttr a(Bitmap paramBitmap)
  {
    return a(paramBitmap, 0.1666666666666667D);
  }
  
  public static PTFaceAttr a(Bitmap paramBitmap, double paramDouble)
  {
    int i = RendererUtils.createTexture(paramBitmap);
    paramBitmap = new Frame(0, i, paramBitmap.getWidth(), paramBitmap.getHeight());
    PTFaceDetector localPTFaceDetector = new PTFaceDetector();
    localPTFaceDetector.init(true);
    PTFaceAttr localPTFaceAttr = localPTFaceDetector.detectFrame(paramBitmap, System.currentTimeMillis(), 0, false, paramDouble, 0.0F, true, null);
    paramBitmap.clear();
    RendererUtils.clearTexture(i);
    localPTFaceDetector.destroy();
    return localPTFaceAttr;
  }
  
  private static CosFunParam a(int paramInt1, int paramInt2, int paramInt3, List<PointF> paramList, FaceImageLayer paramFaceImageLayer, CrazyFaceDataTemplate paramCrazyFaceDataTemplate)
  {
    CosFunParam localCosFunParam = new CosFunParam();
    Object localObject1 = (PointF)paramList.get(101);
    Object localObject2 = (PointF)paramList.get(99);
    PointF localPointF1 = (PointF)paramList.get(105);
    PointF localPointF2 = (PointF)paramList.get(103);
    int i = (int)AlgoUtils.getDistance((PointF)localObject2, localPointF1);
    int j = (int)AlgoUtils.getDistance((PointF)localObject2, (PointF)localObject1);
    float f1 = ((PointF)localObject2).x / paramInt2;
    float f2 = ((PointF)localObject2).y / paramInt3;
    float f3 = ((PointF)localObject1).x / paramInt2;
    float f4 = ((PointF)localObject1).y / paramInt3;
    float f5 = localPointF2.x / paramInt2;
    float f6 = localPointF2.y / paramInt3;
    float f7 = localPointF1.x / paramInt2;
    float f8 = localPointF1.y / paramInt3;
    localObject1 = new VideoFilterBase("precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\ngl_FragColor = texture2D (inputImageTexture, textureCoordinate);\n}\n");
    ((VideoFilterBase)localObject1).ApplyGLSLFilter();
    ((VideoFilterBase)localObject1).setTexCords(new float[] { f1, f2, f3, f4, f5, f6, f7, f8 });
    localCosFunParam.mFaceTexture = RendererUtils.createTexture();
    localObject2 = FrameBufferCache.getInstance().get(i, j);
    ((VideoFilterBase)localObject1).RenderProcess(paramInt1, i, j, localCosFunParam.mFaceTexture, 0.0D, (Frame)localObject2);
    ((Frame)localObject2).unlock();
    ((VideoFilterBase)localObject1).clearGLSLSelf();
    CosFunUtil.updateFacePoints(paramList);
    localObject1 = FrameBufferCache.getInstance().get(100, 100);
    if (paramFaceImageLayer.getVersion() == 1)
    {
      paramCrazyFaceDataTemplate = new CFSkinCropFilter();
      paramCrazyFaceDataTemplate.setFacePoints(paramList);
      paramCrazyFaceDataTemplate.applyFilterChain(false, i, j);
      paramCrazyFaceDataTemplate.RenderProcess(localCosFunParam.mFaceTexture, 100, 100, -1, 0.0D, (Frame)localObject1);
      localCosFunParam.calSkinParams((Frame)localObject1, paramFaceImageLayer.imageFaceColor);
      paramCrazyFaceDataTemplate.clearGLSLSelf();
    }
    for (;;)
    {
      ((Frame)localObject1).unlock();
      localCosFunParam.mWidth = i;
      localCosFunParam.mHeight = j;
      localCosFunParam.mUserFacePointsList = paramList;
      return localCosFunParam;
      paramCrazyFaceDataTemplate = new CFSkinCropFilterV2(paramCrazyFaceDataTemplate.folderPath);
      paramCrazyFaceDataTemplate.setFacePointsInfo(paramList, i, j, paramFaceImageLayer.faceTriangleID);
      paramCrazyFaceDataTemplate.ApplyGLSLFilter();
      paramCrazyFaceDataTemplate.RenderProcess(localCosFunParam.mFaceTexture, 100, 100, -1, 0.0D, (Frame)localObject1);
      localCosFunParam.calSkinParams((Frame)localObject1, paramFaceImageLayer.imageFaceColor2, paramFaceImageLayer.faceColorRange);
      paramCrazyFaceDataTemplate.clearGLSLSelf();
    }
  }
  
  public static List<PointF> a(List<List<PointF>> paramList, double paramDouble)
  {
    if (paramList.size() == 1)
    {
      paramList = (List)paramList.get(0);
      CosFunUtil.scale(paramList, 1.0D / paramDouble);
      FaceOffUtil.getFullCoords(paramList, 2.0F);
      return paramList;
    }
    int k = -1;
    long l1 = -1L;
    int j = 0;
    int i = 0;
    if (i < paramList.size())
    {
      List localList = (List)paramList.get(i);
      CosFunUtil.scale(localList, 1.0D / paramDouble);
      FaceOffUtil.getFullCoords(localList, 2.0F);
      PointF localPointF1 = (PointF)localList.get(101);
      PointF localPointF2 = (PointF)localList.get(99);
      int m = (int)AlgoUtils.getDistance(localPointF2, (PointF)localList.get(105));
      long l2 = (int)AlgoUtils.getDistance(localPointF2, localPointF1) * m;
      if ((l2 <= l1) && ((l2 != l1) || (m <= k))) {
        break label201;
      }
      k = m;
      l1 = l2;
      j = i;
    }
    label201:
    for (;;)
    {
      i += 1;
      break;
      return (List)paramList.get(j);
    }
  }
  
  public static void a(Bitmap paramBitmap, blic paramblic)
  {
    a(paramBitmap, paramblic, false);
  }
  
  public static void a(Bitmap paramBitmap, blic paramblic, boolean paramBoolean)
  {
    if (paramblic == null) {
      return;
    }
    if ((paramBitmap == null) || (paramBitmap.isRecycled()))
    {
      paramblic.a(-3);
      return;
    }
    a(new FaceChangeUtils.5(paramBitmap, paramblic), paramBoolean, "GLThread-cropFace");
  }
  
  public static void a(Bitmap paramBitmap, List<String> paramList, blhz paramblhz)
  {
    if ((paramBitmap == null) || (paramList == null) || (paramList.isEmpty()))
    {
      LogUtils.e("FaceChangeUtils", "change---null parameters: userFace, materialDir");
      paramblhz.a(new ArrayList());
      return;
    }
    a(new FaceChangeUtils.2(paramList, paramBitmap, paramblhz), false, "GLThread-changeFaceBatch");
  }
  
  public static void a(Runnable paramRunnable, boolean paramBoolean, String paramString)
  {
    if (paramRunnable == null) {
      return;
    }
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = "GLThread-default";
    }
    paramString = new SimpleGLThread(null, str);
    paramRunnable = new FaceChangeUtils.4(paramRunnable, paramString);
    if (paramBoolean)
    {
      paramString.postJobSync(paramRunnable);
      return;
    }
    paramString.postJob(paramRunnable);
  }
  
  public static boolean a(Bitmap paramBitmap)
  {
    PTFaceAttr[] arrayOfPTFaceAttr = new PTFaceAttr[1];
    a(new FaceChangeUtils.3(arrayOfPTFaceAttr, paramBitmap), true, "GLThread-checkHasFaceInPic");
    return (arrayOfPTFaceAttr[0] != null) && (arrayOfPTFaceAttr[0].getAllFacePoints() != null) && (arrayOfPTFaceAttr[0].getAllFacePoints().size() > 0);
  }
  
  private static blia b(Bitmap paramBitmap, String paramString)
  {
    if ((paramBitmap == null) || (paramString == null))
    {
      bljn.d("FaceChangeUtils", "changeFaceInternal---null parameters: userFace, materialDir");
      return blia.a(-1, "null parameters, material=" + paramString);
    }
    Object localObject1 = paramString.split("/");
    localObject1 = localObject1[(localObject1.length - 1)];
    Object localObject2 = CfTemplateParser.parseCrazyFace(FileUtils.getRealPath(paramString), (String)localObject1);
    if (localObject2 == null)
    {
      bljn.d("FaceChangeUtils", "changeFaceInternal---failed to parse CrazyFace: " + paramString);
      return blia.a(-2, "failed to parse material, material=" + paramString);
    }
    localObject1 = a(paramBitmap);
    if ((localObject1 == null) || (((PTFaceAttr)localObject1).getAllFacePoints() == null) || (((PTFaceAttr)localObject1).getAllFacePoints().isEmpty()))
    {
      bljn.d("FaceChangeUtils", "changeFaceInternal---failed to detect face");
      return blia.a(-3, "failed to detect face");
    }
    Object localObject3 = a(((PTFaceAttr)localObject1).getAllFacePoints(), ((PTFaceAttr)localObject1).getFaceDetectScale());
    if (((List)localObject3).isEmpty())
    {
      bljn.d("FaceChangeUtils", "changeFaceInternal---userFacePointsList is empty");
      return blia.a(-4, "no face points");
    }
    localObject1 = ((CrazyFaceDataTemplate)localObject2).faceLayers;
    int j = RendererUtils.createTexture(paramBitmap);
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    Object localObject4;
    while (i < ((List)localObject1).size())
    {
      localObject4 = (FaceImageLayer)((List)localObject1).get(i);
      localArrayList.add(a(j, paramBitmap.getWidth(), paramBitmap.getHeight(), VideoMaterialUtil.copyList((List)localObject3), (FaceImageLayer)localObject4, (CrazyFaceDataTemplate)localObject2));
      i += 1;
    }
    paramBitmap = a();
    localObject3 = ((CrazyFaceDataTemplate)localObject2).getFaceLayer(0);
    i = (int)Math.min(((FaceImageLayer)localObject3).width, paramBitmap.width);
    int k = (int)Math.min(((FaceImageLayer)localObject3).height, paramBitmap.height);
    double d = Math.min(i / ((FaceImageLayer)localObject3).width, k / ((FaceImageLayer)localObject3).height);
    k = (int)(((FaceImageLayer)localObject3).width * d);
    int m = (int)(((FaceImageLayer)localObject3).height * d);
    paramBitmap = FaceOffUtil.getFaceBitmap(((CrazyFaceDataTemplate)localObject2).folderPath + File.separator + ((CrazyFaceDataTemplate)localObject2).getFaceLayer(0).imagePath, paramBitmap.width, paramBitmap.height);
    int n = RendererUtils.createTexture(paramBitmap);
    BitmapUtils.recycle(paramBitmap);
    paramBitmap = new Frame(0, n, paramBitmap.getWidth(), paramBitmap.getHeight());
    localObject2 = new CFFaceOffFilter(paramString);
    ((CFFaceOffFilter)localObject2).updateVideoSize(k, m, d);
    ((CFFaceOffFilter)localObject2).ApplyGLSLFilter();
    localObject3 = new VideoFilterBase("precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\ngl_FragColor = texture2D (inputImageTexture, textureCoordinate);\n}\n");
    ((VideoFilterBase)localObject3).ApplyGLSLFilter();
    i = 0;
    while (i < ((List)localObject1).size())
    {
      paramString = FrameBufferCache.getInstance().get(k, m);
      ((VideoFilterBase)localObject3).RenderProcess(paramBitmap.getTextureId(), k, m, -1, 0.0D, paramString);
      localObject4 = (CosFunParam)localArrayList.get(i);
      FaceImageLayer localFaceImageLayer = (FaceImageLayer)((List)localObject1).get(i);
      ((CFFaceOffFilter)localObject2).setFaceLayer(localFaceImageLayer);
      ((CFFaceOffFilter)localObject2).setUserFaceTex(((CosFunParam)localObject4).mFaceTexture);
      ((CFFaceOffFilter)localObject2).setSkinColorParams((CosFunParam)localObject4);
      ((CFFaceOffFilter)localObject2).setFacePointsInfo(((CosFunParam)localObject4).mUserFacePointsList, ((CosFunParam)localObject4).mWidth, ((CosFunParam)localObject4).mHeight, localFaceImageLayer.faceTriangleID);
      ((CFFaceOffFilter)localObject2).RenderProcess(paramBitmap.getTextureId(), paramString.width, paramString.height, -1, 0.0D, paramString);
      if (!paramBitmap.unlock()) {
        paramBitmap.clear();
      }
      i += 1;
      paramBitmap = paramString;
    }
    ((CFFaceOffFilter)localObject2).clearGLSLSelf();
    ((VideoFilterBase)localObject3).clearGLSLSelf();
    paramString = RendererUtils.saveTexture(paramBitmap);
    if (!paramBitmap.unlock()) {
      paramBitmap.clear();
    }
    RendererUtils.clearTexture(j);
    RendererUtils.clearTexture(n);
    i = 0;
    while (i < ((List)localObject1).size())
    {
      RendererUtils.clearTexture(((CosFunParam)localArrayList.get(i)).mFaceTexture);
      i += 1;
    }
    bljn.b("FaceChangeUtils", "success : + result");
    return blia.a(paramString);
  }
  
  public static PTFaceAttr b(Bitmap paramBitmap)
  {
    return a(paramBitmap, 1.0D);
  }
  
  private static void c(Bitmap paramBitmap, blic paramblic)
  {
    Object localObject1 = a(paramBitmap);
    if ((localObject1 == null) || (((PTFaceAttr)localObject1).getAllFacePoints() == null) || (((PTFaceAttr)localObject1).getAllFacePoints().isEmpty()))
    {
      paramblic.a(-2);
      return;
    }
    Object localObject3 = a(((PTFaceAttr)localObject1).getAllFacePoints(), ((PTFaceAttr)localObject1).getFaceDetectScale());
    localObject1 = (PointF)((List)localObject3).get(101);
    Object localObject2 = (PointF)((List)localObject3).get(99);
    PointF localPointF = (PointF)((List)localObject3).get(105);
    localObject3 = (PointF)((List)localObject3).get(103);
    int i = (int)AlgoUtils.getDistance((PointF)localObject2, localPointF);
    int j = (int)AlgoUtils.getDistance((PointF)localObject2, (PointF)localObject1);
    int k = paramBitmap.getWidth();
    int m = paramBitmap.getHeight();
    float f1 = ((PointF)localObject2).x / k;
    float f2 = ((PointF)localObject2).y / m;
    float f3 = ((PointF)localObject1).x / k;
    float f4 = ((PointF)localObject1).y / m;
    float f5 = ((PointF)localObject3).x / k;
    float f6 = ((PointF)localObject3).y / m;
    float f7 = localPointF.x / k;
    float f8 = localPointF.y / m;
    localObject1 = new VideoFilterBase("precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\ngl_FragColor = texture2D (inputImageTexture, textureCoordinate);\n}\n");
    ((VideoFilterBase)localObject1).ApplyGLSLFilter();
    ((VideoFilterBase)localObject1).setTexCords(new float[] { f1, f2, f3, f4, f5, f6, f7, f8 });
    k = RendererUtils.createTexture(paramBitmap);
    m = RendererUtils.createTexture();
    paramBitmap = FrameBufferCache.getInstance().get(i, j);
    ((VideoFilterBase)localObject1).RenderProcess(k, i, j, m, 0.0D, paramBitmap);
    localObject2 = RendererUtils.saveTexture(m, i, j);
    paramBitmap.unlock();
    ((VideoFilterBase)localObject1).clearGLSLSelf();
    RendererUtils.clearTexture(k);
    RendererUtils.clearTexture(m);
    paramblic.a((Bitmap)localObject2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blhy
 * JD-Core Version:    0.7.0.1
 */