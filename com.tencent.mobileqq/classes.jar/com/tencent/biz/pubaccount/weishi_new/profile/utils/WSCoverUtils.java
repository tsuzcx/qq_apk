package com.tencent.biz.pubaccount.weishi_new.profile.utils;

import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/weishi_new/profile/utils/WSCoverUtils;", "", "()V", "TAG", "", "updateImageViewMatrix", "", "imageView", "Landroid/widget/ImageView;", "qqweishi_impl_release"}, k=1, mv={1, 1, 16})
public final class WSCoverUtils
{
  public static final WSCoverUtils a = new WSCoverUtils();
  
  @JvmStatic
  public static final void a(@NotNull ImageView paramImageView)
  {
    Intrinsics.checkParameterIsNotNull(paramImageView, "imageView");
    if (paramImageView.getScaleType() == ImageView.ScaleType.MATRIX)
    {
      Drawable localDrawable = paramImageView.getDrawable();
      if (localDrawable != null)
      {
        Matrix localMatrix = new Matrix();
        float f1 = paramImageView.getWidth();
        float f3 = paramImageView.getHeight();
        float f2 = localDrawable.getIntrinsicWidth();
        float f4 = localDrawable.getIntrinsicHeight();
        float f5 = 0;
        if ((f1 > f5) && (f3 > f5) && (f2 > f5) && (f4 > f5))
        {
          if (f1 / f3 >= f2 / f4)
          {
            f1 /= f2;
            localMatrix.postScale(f1, f1, 0.0F, 0.0F);
          }
          else
          {
            f3 /= f4;
            localMatrix.postScale(f3, f3, 0.0F, 0.0F);
            localMatrix.postTranslate((f1 - f2 * f3) / 2, 0.0F);
          }
          paramImageView.setImageMatrix(localMatrix);
          return;
        }
        paramImageView = new StringBuilder();
        paramImageView.append("params error. width = ");
        paramImageView.append(f1);
        paramImageView.append(", height = ");
        paramImageView.append(f3);
        paramImageView.append(", dWidth = ");
        paramImageView.append(f2);
        paramImageView.append(", dHeight = ");
        paramImageView.append(f4);
        WSLog.e("CoverUtils", paramImageView.toString());
      }
      return;
    }
    throw ((Throwable)new IllegalArgumentException("imageView scale type is not MATRIX."));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.profile.utils.WSCoverUtils
 * JD-Core Version:    0.7.0.1
 */