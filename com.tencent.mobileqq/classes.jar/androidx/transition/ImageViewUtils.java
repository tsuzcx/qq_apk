package androidx.transition;

import android.annotation.SuppressLint;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import java.lang.reflect.Field;

class ImageViewUtils
{
  private static Field sDrawMatrixField;
  private static boolean sDrawMatrixFieldFetched = false;
  private static boolean sTryHiddenAnimateTransform = true;
  
  static void animateTransform(@NonNull ImageView paramImageView, @Nullable Matrix paramMatrix)
  {
    if (Build.VERSION.SDK_INT >= 29)
    {
      paramImageView.animateTransform(paramMatrix);
      return;
    }
    Matrix localMatrix;
    Object localObject2;
    if (paramMatrix == null)
    {
      paramMatrix = paramImageView.getDrawable();
      if (paramMatrix != null)
      {
        paramMatrix.setBounds(0, 0, paramImageView.getWidth() - paramImageView.getPaddingLeft() - paramImageView.getPaddingRight(), paramImageView.getHeight() - paramImageView.getPaddingTop() - paramImageView.getPaddingBottom());
        paramImageView.invalidate();
      }
    }
    else
    {
      if (Build.VERSION.SDK_INT >= 21)
      {
        hiddenAnimateTransform(paramImageView, paramMatrix);
        return;
      }
      localObject1 = paramImageView.getDrawable();
      if (localObject1 != null)
      {
        ((Drawable)localObject1).setBounds(0, 0, ((Drawable)localObject1).getIntrinsicWidth(), ((Drawable)localObject1).getIntrinsicHeight());
        localMatrix = null;
        localObject1 = null;
        fetchDrawMatrixField();
        localObject2 = sDrawMatrixField;
        if (localObject2 != null) {
          localObject1 = localMatrix;
        }
      }
    }
    try
    {
      localObject2 = (Matrix)((Field)localObject2).get(paramImageView);
      if (localObject2 != null) {}
    }
    catch (IllegalAccessException localIllegalAccessException2)
    {
      label161:
      label167:
      break label167;
    }
    try
    {
      localMatrix = new Matrix();
      localObject1 = localMatrix;
      sDrawMatrixField.set(paramImageView, localMatrix);
      localObject1 = localMatrix;
    }
    catch (IllegalAccessException localIllegalAccessException1)
    {
      break label161;
    }
    Object localObject1 = localObject2;
    if (localObject1 != null) {
      ((Matrix)localObject1).set(paramMatrix);
    }
    paramImageView.invalidate();
  }
  
  private static void fetchDrawMatrixField()
  {
    if (!sDrawMatrixFieldFetched) {}
    try
    {
      sDrawMatrixField = ImageView.class.getDeclaredField("mDrawMatrix");
      sDrawMatrixField.setAccessible(true);
      label23:
      sDrawMatrixFieldFetched = true;
      return;
    }
    catch (NoSuchFieldException localNoSuchFieldException)
    {
      break label23;
    }
  }
  
  @SuppressLint({"NewApi"})
  @RequiresApi(21)
  private static void hiddenAnimateTransform(@NonNull ImageView paramImageView, @Nullable Matrix paramMatrix)
  {
    if (sTryHiddenAnimateTransform) {}
    try
    {
      paramImageView.animateTransform(paramMatrix);
      return;
    }
    catch (NoSuchMethodError paramImageView)
    {
      label12:
      break label12;
    }
    sTryHiddenAnimateTransform = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.transition.ImageViewUtils
 * JD-Core Version:    0.7.0.1
 */