package com.tencent.biz.pubaccount.readinjoyAd.ad.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.tencent.biz.qqstory.utils.BitmapUtils;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.util.BitmapUtil;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoyAd/ad/utils/AdBlurUtils;", "", "()V", "TAG", "", "cropBitmap", "Landroid/graphics/Bitmap;", "bitmap", "cropWidth", "", "cropHeight", "getBitmapFromURL", "imageUrl", "getLargeImgAdBlurBitmap", "context", "Landroid/content/Context;", "originWidth", "originHeight", "blurWidth", "blurHeight", "scale", "", "kandian_ad_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class AdBlurUtils
{
  public static final AdBlurUtils a = new AdBlurUtils();
  private static final String b = "AdBlurUtils";
  
  private final Bitmap a(Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    if (paramBitmap == null) {
      return null;
    }
    paramBitmap.getWidth();
    paramBitmap.getHeight();
    return Bitmap.createBitmap(paramBitmap, (paramBitmap.getWidth() - paramInt1) / 2, (paramBitmap.getHeight() - paramInt2) / 2, paramInt1, paramInt2);
  }
  
  @Nullable
  public final Bitmap a(@Nullable Bitmap paramBitmap, @NotNull Context paramContext, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    if (paramBitmap != null)
    {
      Object localObject1 = b;
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("1:originWidth = ");
      ((StringBuilder)localObject2).append(paramInt1);
      ((StringBuilder)localObject2).append("  originHeight = ");
      ((StringBuilder)localObject2).append(paramInt2);
      ((StringBuilder)localObject2).append("  blurWidth = ");
      ((StringBuilder)localObject2).append(paramInt3);
      ((StringBuilder)localObject2).append("  blurHeight = ");
      ((StringBuilder)localObject2).append(paramInt4);
      ReadInJoyAdLog.a((String)localObject1, ((StringBuilder)localObject2).toString());
      paramBitmap = BitmapUtils.a(paramBitmap, paramInt1, paramInt2, true);
      localObject1 = b;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("2:originBPWidth = ");
      Intrinsics.checkExpressionValueIsNotNull(paramBitmap, "originBP");
      ((StringBuilder)localObject2).append(paramBitmap.getWidth());
      ((StringBuilder)localObject2).append("  originBPHeight = ");
      ((StringBuilder)localObject2).append(paramBitmap.getHeight());
      ReadInJoyAdLog.a((String)localObject1, ((StringBuilder)localObject2).toString());
      paramContext = ImageUtil.a(paramContext, paramBitmap, paramInt3 / paramInt1, 20.0F);
      localObject1 = b;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("3:blurBitmapWidth = ");
      Intrinsics.checkExpressionValueIsNotNull(paramContext, "blurBitmap");
      ((StringBuilder)localObject2).append(paramContext.getWidth());
      ((StringBuilder)localObject2).append("  blurBitmapHeight = ");
      ((StringBuilder)localObject2).append(paramContext.getHeight());
      ReadInJoyAdLog.a((String)localObject1, ((StringBuilder)localObject2).toString());
      paramContext = a.a(paramContext, paramInt3, paramInt4);
      localObject1 = b;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("4:blurBitmapWidth = ");
      Intrinsics.checkExpressionValueIsNotNull(paramContext, "blurBitmap");
      ((StringBuilder)localObject2).append(paramContext.getWidth());
      ((StringBuilder)localObject2).append("  blurBitmapHeight = ");
      ((StringBuilder)localObject2).append(paramContext.getHeight());
      ReadInJoyAdLog.a((String)localObject1, ((StringBuilder)localObject2).toString());
      localObject1 = BitmapUtil.a(paramContext, paramBitmap, (paramInt3 - paramInt1) / 2, 0, 1);
      localObject2 = b;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("5:mergeBitmapWidth = ");
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "mergeBitmap");
      localStringBuilder.append(((Bitmap)localObject1).getWidth());
      localStringBuilder.append("  mergeBitmapHeight = ");
      localStringBuilder.append(((Bitmap)localObject1).getHeight());
      ReadInJoyAdLog.a((String)localObject2, localStringBuilder.toString());
      paramBitmap.recycle();
      paramContext.recycle();
      return localObject1;
    }
    return null;
  }
  
  @Nullable
  public final Bitmap a(@Nullable Bitmap paramBitmap, @NotNull Context paramContext, int paramInt1, int paramInt2, int paramInt3, int paramInt4, float paramFloat)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    if (paramBitmap != null)
    {
      Object localObject1 = b;
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("1:originWidth = ");
      ((StringBuilder)localObject2).append(paramInt1);
      ((StringBuilder)localObject2).append("  originHeight = ");
      ((StringBuilder)localObject2).append(paramInt2);
      ((StringBuilder)localObject2).append("  blurWidth = ");
      ((StringBuilder)localObject2).append(paramInt3);
      ((StringBuilder)localObject2).append("  blurHeight = ");
      ((StringBuilder)localObject2).append(paramInt4);
      ReadInJoyAdLog.a((String)localObject1, ((StringBuilder)localObject2).toString());
      paramBitmap = BitmapUtils.a(paramBitmap, paramInt1, paramInt2, true);
      localObject1 = b;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("2:originBPWidth = ");
      Intrinsics.checkExpressionValueIsNotNull(paramBitmap, "originBP");
      ((StringBuilder)localObject2).append(paramBitmap.getWidth());
      ((StringBuilder)localObject2).append("  originBPHeight = ");
      ((StringBuilder)localObject2).append(paramBitmap.getHeight());
      ReadInJoyAdLog.a((String)localObject1, ((StringBuilder)localObject2).toString());
      paramContext = ImageUtil.a(paramContext, paramBitmap, paramFloat, 20.0F);
      localObject1 = b;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("3:blurBitmapWidth = ");
      Intrinsics.checkExpressionValueIsNotNull(paramContext, "blurBitmap");
      ((StringBuilder)localObject2).append(paramContext.getWidth());
      ((StringBuilder)localObject2).append("  blurBitmapHeight = ");
      ((StringBuilder)localObject2).append(paramContext.getHeight());
      ReadInJoyAdLog.a((String)localObject1, ((StringBuilder)localObject2).toString());
      paramContext = a.a(paramContext, paramInt3, paramInt4);
      localObject1 = b;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("4:blurBitmapWidth = ");
      Intrinsics.checkExpressionValueIsNotNull(paramContext, "blurBitmap");
      ((StringBuilder)localObject2).append(paramContext.getWidth());
      ((StringBuilder)localObject2).append("  blurBitmapHeight = ");
      ((StringBuilder)localObject2).append(paramContext.getHeight());
      ReadInJoyAdLog.a((String)localObject1, ((StringBuilder)localObject2).toString());
      localObject1 = BitmapUtil.a(paramContext, paramBitmap, (paramInt3 - paramInt1) / 2, (paramInt4 - paramInt2) / 2, 1);
      localObject2 = b;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("5:mergeBitmapWidth = ");
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "mergeBitmap");
      localStringBuilder.append(((Bitmap)localObject1).getWidth());
      localStringBuilder.append("  mergeBitmapHeight = ");
      localStringBuilder.append(((Bitmap)localObject1).getHeight());
      ReadInJoyAdLog.a((String)localObject2, localStringBuilder.toString());
      paramBitmap.recycle();
      paramContext.recycle();
      return localObject1;
    }
    return null;
  }
  
  @Nullable
  public final Bitmap a(@Nullable String paramString)
  {
    try
    {
      paramString = new URL(paramString).openConnection();
      if (paramString != null)
      {
        paramString = (HttpURLConnection)paramString;
        paramString.setDoInput(true);
        paramString.connect();
        return BitmapFactory.decodeStream(paramString.getInputStream());
      }
      throw new TypeCastException("null cannot be cast to non-null type java.net.HttpURLConnection");
    }
    catch (OutOfMemoryError paramString)
    {
      paramString.printStackTrace();
      return null;
    }
    catch (IOException paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.utils.AdBlurUtils
 * JD-Core Version:    0.7.0.1
 */