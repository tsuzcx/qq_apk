package com.tencent.aelight.camera.aeeditor.view.reorder;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.qcircle.weishi.module.edit.widget.playtrack.provider.BaseVideoThumbAssetCache.LRUKey;
import com.tencent.qcircle.weishi.module.edit.widget.playtrack.provider.VideoThumbListener;
import com.tencent.qcircle.weishi.module.edit.widget.playtrack.provider.VideoThumbProviderManager;
import com.tencent.tav.coremedia.CMTime;
import java.util.Iterator;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/aelight/camera/aeeditor/view/reorder/ThumbClipView;", "Landroid/widget/FrameLayout;", "Lcom/tencent/qcircle/weishi/module/edit/widget/playtrack/provider/VideoThumbListener;", "context", "Landroid/content/Context;", "attributeSet", "Landroid/util/AttributeSet;", "defStyleAttrs", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mResourcePath", "", "mSelectedStart", "", "mUuid", "path", "Landroid/graphics/Path;", "radius", "getRadius", "()I", "radius$delegate", "Lkotlin/Lazy;", "thumb1", "Landroid/widget/ImageView;", "createObjTag", "uuid", "index", "dispatchDraw", "", "canvas", "Landroid/graphics/Canvas;", "onAttachedToWindow", "onDetachedFromWindow", "onSizeChanged", "w", "h", "oldw", "oldh", "onThumbGenerated", "tag", "", "startTime", "Lcom/tencent/tav/coremedia/CMTime;", "bitmap", "Landroid/graphics/Bitmap;", "setClipUrl", "selectedStart", "aelight_impl_release"}, k=1, mv={1, 1, 16})
public final class ThumbClipView
  extends FrameLayout
  implements VideoThumbListener
{
  private Path a;
  private final Lazy b = LazyKt.lazy((Function0)ThumbClipView.radius.2.INSTANCE);
  private ImageView c;
  private String d;
  private String e;
  private long f;
  
  @JvmOverloads
  public ThumbClipView(@NotNull Context paramContext)
  {
    this(paramContext, null, 0, 6, null);
  }
  
  @JvmOverloads
  public ThumbClipView(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0, 4, null);
  }
  
  @JvmOverloads
  public ThumbClipView(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    View.inflate(paramContext, 2064056445, (ViewGroup)this);
    this.c = ((ImageView)findViewById(2063991487));
  }
  
  private final String a(String paramString, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append('_');
    localStringBuilder.append(paramInt);
    return localStringBuilder.toString();
  }
  
  private final int getRadius()
  {
    return ((Number)this.b.getValue()).intValue();
  }
  
  protected void dispatchDraw(@Nullable Canvas paramCanvas)
  {
    Path localPath = this.a;
    if ((localPath != null) && (paramCanvas != null)) {
      paramCanvas.clipPath(localPath);
    }
    super.dispatchDraw(paramCanvas);
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    VideoThumbProviderManager.getInstance().registerListener((VideoThumbListener)this);
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    VideoThumbProviderManager.getInstance().unRegisterListener((VideoThumbListener)this);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    this.a = new Path();
    Path localPath = this.a;
    if (localPath != null) {
      localPath.addRoundRect(new RectF(0.0F, 0.0F, getWidth(), getHeight()), getRadius(), getRadius(), Path.Direction.CW);
    }
  }
  
  public void onThumbGenerated(@Nullable Object paramObject, @Nullable CMTime paramCMTime, @Nullable Bitmap paramBitmap)
  {
    Iterator localIterator = ((Iterable)CollectionsKt.listOf(this.c)).iterator();
    while (localIterator.hasNext())
    {
      ImageView localImageView = (ImageView)localIterator.next();
      Bitmap localBitmap = null;
      if (paramBitmap != null)
      {
        if (localImageView != null) {
          paramCMTime = localImageView.getTag();
        } else {
          paramCMTime = null;
        }
        if ((Intrinsics.areEqual(paramObject, paramCMTime)) && (!paramBitmap.isRecycled()))
        {
          post((Runnable)new ThumbClipView.onThumbGenerated..inlined.forEach.lambda.1(localImageView, this, paramBitmap, paramObject));
          continue;
        }
      }
      VideoThumbProviderManager.getInstance().releaseBitmapCacheByKey(new BaseVideoThumbAssetCache.LRUKey(this.e, this.f + 500L));
      String str = this.d;
      paramCMTime = localBitmap;
      if (str != null) {
        paramCMTime = a(str, 0);
      }
      localBitmap = VideoThumbProviderManager.getInstance().getBitmapByTime(this.f + 500L, paramCMTime, this.e);
      if (localImageView != null) {
        localImageView.setTag(paramCMTime);
      }
      if (localImageView != null)
      {
        paramCMTime = getResources();
        Intrinsics.checkExpressionValueIsNotNull(paramCMTime, "resources");
        localImageView.setImageDrawable((Drawable)new SafeBitmapDrawable(paramCMTime, localBitmap));
      }
    }
  }
  
  public final void setClipUrl(@NotNull String paramString1, @NotNull String paramString2, long paramLong)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "uuid");
    Intrinsics.checkParameterIsNotNull(paramString2, "path");
    this.d = paramString1;
    this.e = paramString2;
    this.f = paramLong;
    Iterator localIterator = ((Iterable)CollectionsKt.listOf(this.c)).iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      Object localObject1 = localIterator.next();
      if (i < 0) {
        CollectionsKt.throwIndexOverflow();
      }
      localObject1 = (ImageView)localObject1;
      Object localObject2 = a(paramString1, i);
      Bitmap localBitmap = VideoThumbProviderManager.getInstance().getBitmapByTime(i * 500L + paramLong, localObject2, paramString2);
      if (localObject1 != null) {
        ((ImageView)localObject1).setTag(localObject2);
      }
      if (localObject1 != null)
      {
        localObject2 = getResources();
        Intrinsics.checkExpressionValueIsNotNull(localObject2, "resources");
        ((ImageView)localObject1).setImageDrawable((Drawable)new SafeBitmapDrawable((Resources)localObject2, localBitmap));
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.view.reorder.ThumbClipView
 * JD-Core Version:    0.7.0.1
 */