package com.google.android.material.transition.platform;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.Shader.TileMode;
import android.os.Build.VERSION;
import android.view.View;
import androidx.annotation.ColorInt;
import androidx.annotation.FloatRange;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.google.android.material.shape.CornerSize;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.shape.ShapeAppearanceModel.Builder;

@RequiresApi(21)
class TransitionUtils
{
  private static final RectF a = new RectF();
  
  static float a(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    return paramFloat1 + paramFloat3 * (paramFloat2 - paramFloat1);
  }
  
  static float a(float paramFloat1, float paramFloat2, @FloatRange(from=0.0D, to=1.0D) float paramFloat3, @FloatRange(from=0.0D, to=1.0D) float paramFloat4, @FloatRange(from=0.0D, to=1.0D) float paramFloat5)
  {
    return a(paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramFloat5, false);
  }
  
  static float a(float paramFloat1, float paramFloat2, @FloatRange(from=0.0D, to=1.0D) float paramFloat3, @FloatRange(from=0.0D, to=1.0D) float paramFloat4, @FloatRange(from=0.0D) float paramFloat5, boolean paramBoolean)
  {
    if ((paramBoolean) && ((paramFloat5 < 0.0F) || (paramFloat5 > 1.0F))) {
      return a(paramFloat1, paramFloat2, paramFloat5);
    }
    if (paramFloat5 < paramFloat3) {
      return paramFloat1;
    }
    if (paramFloat5 > paramFloat4) {
      return paramFloat2;
    }
    return a(paramFloat1, paramFloat2, (paramFloat5 - paramFloat3) / (paramFloat4 - paramFloat3));
  }
  
  static float a(@NonNull RectF paramRectF)
  {
    return paramRectF.width() * paramRectF.height();
  }
  
  static int a(int paramInt1, int paramInt2, @FloatRange(from=0.0D, to=1.0D) float paramFloat1, @FloatRange(from=0.0D, to=1.0D) float paramFloat2, @FloatRange(from=0.0D, to=1.0D) float paramFloat3)
  {
    if (paramFloat3 < paramFloat1) {
      return paramInt1;
    }
    if (paramFloat3 > paramFloat2) {
      return paramInt2;
    }
    return (int)a(paramInt1, paramInt2, (paramFloat3 - paramFloat1) / (paramFloat2 - paramFloat1));
  }
  
  private static int a(Canvas paramCanvas, Rect paramRect, int paramInt)
  {
    a.set(paramRect);
    if (Build.VERSION.SDK_INT >= 21) {
      return paramCanvas.saveLayerAlpha(a, paramInt);
    }
    return paramCanvas.saveLayerAlpha(a.left, a.top, a.right, a.bottom, paramInt, 31);
  }
  
  static Rect a(View paramView)
  {
    return new Rect(paramView.getLeft(), paramView.getTop(), paramView.getRight(), paramView.getBottom());
  }
  
  static RectF a(View paramView)
  {
    return new RectF(paramView.getLeft(), paramView.getTop(), paramView.getRight(), paramView.getBottom());
  }
  
  static Shader a(@ColorInt int paramInt)
  {
    return new LinearGradient(0.0F, 0.0F, 0.0F, 0.0F, paramInt, paramInt, Shader.TileMode.CLAMP);
  }
  
  static View a(View paramView, @IdRes int paramInt)
  {
    View localView = paramView.findViewById(paramInt);
    if (localView != null) {
      return localView;
    }
    return b(paramView, paramInt);
  }
  
  static ShapeAppearanceModel a(ShapeAppearanceModel paramShapeAppearanceModel, RectF paramRectF)
  {
    return paramShapeAppearanceModel.a(new TransitionUtils.1(paramRectF));
  }
  
  static ShapeAppearanceModel a(ShapeAppearanceModel paramShapeAppearanceModel1, ShapeAppearanceModel paramShapeAppearanceModel2, RectF paramRectF1, RectF paramRectF2, @FloatRange(from=0.0D, to=1.0D) float paramFloat1, @FloatRange(from=0.0D, to=1.0D) float paramFloat2, @FloatRange(from=0.0D, to=1.0D) float paramFloat3)
  {
    if (paramFloat3 < paramFloat1) {
      return paramShapeAppearanceModel1;
    }
    if (paramFloat3 > paramFloat2) {
      return paramShapeAppearanceModel2;
    }
    return a(paramShapeAppearanceModel1, paramShapeAppearanceModel2, paramRectF1, new TransitionUtils.2(paramRectF1, paramRectF2, paramFloat1, paramFloat2, paramFloat3));
  }
  
  static ShapeAppearanceModel a(ShapeAppearanceModel paramShapeAppearanceModel1, ShapeAppearanceModel paramShapeAppearanceModel2, RectF paramRectF, TransitionUtils.CornerSizeBinaryOperator paramCornerSizeBinaryOperator)
  {
    if (a(paramShapeAppearanceModel1, paramRectF)) {
      paramRectF = paramShapeAppearanceModel1;
    } else {
      paramRectF = paramShapeAppearanceModel2;
    }
    return paramRectF.b().b(paramCornerSizeBinaryOperator.a(paramShapeAppearanceModel1.a(), paramShapeAppearanceModel2.a())).c(paramCornerSizeBinaryOperator.a(paramShapeAppearanceModel1.b(), paramShapeAppearanceModel2.b())).e(paramCornerSizeBinaryOperator.a(paramShapeAppearanceModel1.d(), paramShapeAppearanceModel2.d())).d(paramCornerSizeBinaryOperator.a(paramShapeAppearanceModel1.c(), paramShapeAppearanceModel2.c())).a();
  }
  
  @NonNull
  static <T> T a(@Nullable T paramT1, @NonNull T paramT2)
  {
    if (paramT1 != null) {
      return paramT1;
    }
    return paramT2;
  }
  
  static void a(Canvas paramCanvas, Rect paramRect, float paramFloat1, float paramFloat2, float paramFloat3, int paramInt, TransitionUtils.CanvasOperation paramCanvasOperation)
  {
    if (paramInt <= 0) {
      return;
    }
    int i = paramCanvas.save();
    paramCanvas.translate(paramFloat1, paramFloat2);
    paramCanvas.scale(paramFloat3, paramFloat3);
    if (paramInt < 255) {
      a(paramCanvas, paramRect, paramInt);
    }
    paramCanvasOperation.a(paramCanvas);
    paramCanvas.restoreToCount(i);
  }
  
  private static boolean a(ShapeAppearanceModel paramShapeAppearanceModel, RectF paramRectF)
  {
    return (paramShapeAppearanceModel.a().a(paramRectF) != 0.0F) || (paramShapeAppearanceModel.b().a(paramRectF) != 0.0F) || (paramShapeAppearanceModel.c().a(paramRectF) != 0.0F) || (paramShapeAppearanceModel.d().a(paramRectF) != 0.0F);
  }
  
  static RectF b(View paramView)
  {
    int[] arrayOfInt = new int[2];
    paramView.getLocationOnScreen(arrayOfInt);
    int i = arrayOfInt[0];
    int j = arrayOfInt[1];
    int k = paramView.getWidth();
    int m = paramView.getHeight();
    return new RectF(i, j, k + i, m + j);
  }
  
  static View b(View paramView, @IdRes int paramInt)
  {
    String str = paramView.getResources().getResourceName(paramInt);
    while (paramView != null)
    {
      if (paramView.getId() == paramInt) {
        return paramView;
      }
      paramView = paramView.getParent();
      if (!(paramView instanceof View)) {
        break;
      }
      paramView = (View)paramView;
    }
    paramView = new StringBuilder();
    paramView.append(str);
    paramView.append(" is not a valid ancestor");
    paramView = new IllegalArgumentException(paramView.toString());
    for (;;)
    {
      throw paramView;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.google.android.material.transition.platform.TransitionUtils
 * JD-Core Version:    0.7.0.1
 */