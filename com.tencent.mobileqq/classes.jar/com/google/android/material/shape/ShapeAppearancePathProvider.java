package com.google.android.material.shape;

import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.Path.Op;
import android.graphics.PointF;
import android.graphics.RectF;
import android.os.Build.VERSION;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.UiThread;

public class ShapeAppearancePathProvider
{
  private final Path jdField_a_of_type_AndroidGraphicsPath = new Path();
  private final PointF jdField_a_of_type_AndroidGraphicsPointF = new PointF();
  private final ShapePath jdField_a_of_type_ComGoogleAndroidMaterialShapeShapePath = new ShapePath();
  private boolean jdField_a_of_type_Boolean = true;
  private final float[] jdField_a_of_type_ArrayOfFloat = new float[2];
  private final Matrix[] jdField_a_of_type_ArrayOfAndroidGraphicsMatrix = new Matrix[4];
  private final ShapePath[] jdField_a_of_type_ArrayOfComGoogleAndroidMaterialShapeShapePath = new ShapePath[4];
  private final Path jdField_b_of_type_AndroidGraphicsPath = new Path();
  private final float[] jdField_b_of_type_ArrayOfFloat = new float[2];
  private final Matrix[] jdField_b_of_type_ArrayOfAndroidGraphicsMatrix = new Matrix[4];
  private final Path c = new Path();
  private final Path d = new Path();
  
  public ShapeAppearancePathProvider()
  {
    int i = 0;
    while (i < 4)
    {
      this.jdField_a_of_type_ArrayOfComGoogleAndroidMaterialShapeShapePath[i] = new ShapePath();
      this.jdField_a_of_type_ArrayOfAndroidGraphicsMatrix[i] = new Matrix();
      this.jdField_b_of_type_ArrayOfAndroidGraphicsMatrix[i] = new Matrix();
      i += 1;
    }
  }
  
  private float a(int paramInt)
  {
    return (paramInt + 1) * 90;
  }
  
  private float a(@NonNull RectF paramRectF, int paramInt)
  {
    this.jdField_a_of_type_ArrayOfFloat[0] = this.jdField_a_of_type_ArrayOfComGoogleAndroidMaterialShapeShapePath[paramInt].c;
    this.jdField_a_of_type_ArrayOfFloat[1] = this.jdField_a_of_type_ArrayOfComGoogleAndroidMaterialShapeShapePath[paramInt].d;
    this.jdField_a_of_type_ArrayOfAndroidGraphicsMatrix[paramInt].mapPoints(this.jdField_a_of_type_ArrayOfFloat);
    if ((paramInt != 1) && (paramInt != 3)) {
      return Math.abs(paramRectF.centerY() - this.jdField_a_of_type_ArrayOfFloat[1]);
    }
    return Math.abs(paramRectF.centerX() - this.jdField_a_of_type_ArrayOfFloat[0]);
  }
  
  private CornerSize a(int paramInt, @NonNull ShapeAppearanceModel paramShapeAppearanceModel)
  {
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 3) {
          return paramShapeAppearanceModel.b();
        }
        return paramShapeAppearanceModel.a();
      }
      return paramShapeAppearanceModel.d();
    }
    return paramShapeAppearanceModel.c();
  }
  
  private CornerTreatment a(int paramInt, @NonNull ShapeAppearanceModel paramShapeAppearanceModel)
  {
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 3) {
          return paramShapeAppearanceModel.b();
        }
        return paramShapeAppearanceModel.a();
      }
      return paramShapeAppearanceModel.d();
    }
    return paramShapeAppearanceModel.c();
  }
  
  private EdgeTreatment a(int paramInt, @NonNull ShapeAppearanceModel paramShapeAppearanceModel)
  {
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 3) {
          return paramShapeAppearanceModel.c();
        }
        return paramShapeAppearanceModel.b();
      }
      return paramShapeAppearanceModel.a();
    }
    return paramShapeAppearanceModel.d();
  }
  
  @NonNull
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
  @UiThread
  public static ShapeAppearancePathProvider a()
  {
    return ShapeAppearancePathProvider.Lazy.a;
  }
  
  private void a(int paramInt)
  {
    this.jdField_a_of_type_ArrayOfFloat[0] = this.jdField_a_of_type_ArrayOfComGoogleAndroidMaterialShapeShapePath[paramInt].c();
    this.jdField_a_of_type_ArrayOfFloat[1] = this.jdField_a_of_type_ArrayOfComGoogleAndroidMaterialShapeShapePath[paramInt].d();
    this.jdField_a_of_type_ArrayOfAndroidGraphicsMatrix[paramInt].mapPoints(this.jdField_a_of_type_ArrayOfFloat);
    float f = a(paramInt);
    this.jdField_b_of_type_ArrayOfAndroidGraphicsMatrix[paramInt].reset();
    Matrix localMatrix = this.jdField_b_of_type_ArrayOfAndroidGraphicsMatrix[paramInt];
    float[] arrayOfFloat = this.jdField_a_of_type_ArrayOfFloat;
    localMatrix.setTranslate(arrayOfFloat[0], arrayOfFloat[1]);
    this.jdField_b_of_type_ArrayOfAndroidGraphicsMatrix[paramInt].preRotate(f);
  }
  
  private void a(int paramInt, @NonNull RectF paramRectF, @NonNull PointF paramPointF)
  {
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 3)
        {
          paramPointF.set(paramRectF.right, paramRectF.top);
          return;
        }
        paramPointF.set(paramRectF.left, paramRectF.top);
        return;
      }
      paramPointF.set(paramRectF.left, paramRectF.bottom);
      return;
    }
    paramPointF.set(paramRectF.right, paramRectF.bottom);
  }
  
  private void a(@NonNull ShapeAppearancePathProvider.ShapeAppearancePathSpec paramShapeAppearancePathSpec, int paramInt)
  {
    CornerSize localCornerSize = a(paramInt, paramShapeAppearancePathSpec.jdField_a_of_type_ComGoogleAndroidMaterialShapeShapeAppearanceModel);
    a(paramInt, paramShapeAppearancePathSpec.jdField_a_of_type_ComGoogleAndroidMaterialShapeShapeAppearanceModel).a(this.jdField_a_of_type_ArrayOfComGoogleAndroidMaterialShapeShapePath[paramInt], 90.0F, paramShapeAppearancePathSpec.jdField_a_of_type_Float, paramShapeAppearancePathSpec.jdField_a_of_type_AndroidGraphicsRectF, localCornerSize);
    float f = a(paramInt);
    this.jdField_a_of_type_ArrayOfAndroidGraphicsMatrix[paramInt].reset();
    a(paramInt, paramShapeAppearancePathSpec.jdField_a_of_type_AndroidGraphicsRectF, this.jdField_a_of_type_AndroidGraphicsPointF);
    this.jdField_a_of_type_ArrayOfAndroidGraphicsMatrix[paramInt].setTranslate(this.jdField_a_of_type_AndroidGraphicsPointF.x, this.jdField_a_of_type_AndroidGraphicsPointF.y);
    this.jdField_a_of_type_ArrayOfAndroidGraphicsMatrix[paramInt].preRotate(f);
  }
  
  @RequiresApi(19)
  private boolean a(Path paramPath, int paramInt)
  {
    this.d.reset();
    this.jdField_a_of_type_ArrayOfComGoogleAndroidMaterialShapeShapePath[paramInt].a(this.jdField_a_of_type_ArrayOfAndroidGraphicsMatrix[paramInt], this.d);
    RectF localRectF = new RectF();
    boolean bool = true;
    paramPath.computeBounds(localRectF, true);
    this.d.computeBounds(localRectF, true);
    paramPath.op(this.d, Path.Op.INTERSECT);
    paramPath.computeBounds(localRectF, true);
    if (localRectF.isEmpty())
    {
      if ((localRectF.width() > 1.0F) && (localRectF.height() > 1.0F)) {
        return true;
      }
      bool = false;
    }
    return bool;
  }
  
  private void b(@NonNull ShapeAppearancePathProvider.ShapeAppearancePathSpec paramShapeAppearancePathSpec, int paramInt)
  {
    this.jdField_a_of_type_ArrayOfFloat[0] = this.jdField_a_of_type_ArrayOfComGoogleAndroidMaterialShapeShapePath[paramInt].a();
    this.jdField_a_of_type_ArrayOfFloat[1] = this.jdField_a_of_type_ArrayOfComGoogleAndroidMaterialShapeShapePath[paramInt].b();
    this.jdField_a_of_type_ArrayOfAndroidGraphicsMatrix[paramInt].mapPoints(this.jdField_a_of_type_ArrayOfFloat);
    Path localPath;
    float[] arrayOfFloat;
    if (paramInt == 0)
    {
      localPath = paramShapeAppearancePathSpec.jdField_a_of_type_AndroidGraphicsPath;
      arrayOfFloat = this.jdField_a_of_type_ArrayOfFloat;
      localPath.moveTo(arrayOfFloat[0], arrayOfFloat[1]);
    }
    else
    {
      localPath = paramShapeAppearancePathSpec.jdField_a_of_type_AndroidGraphicsPath;
      arrayOfFloat = this.jdField_a_of_type_ArrayOfFloat;
      localPath.lineTo(arrayOfFloat[0], arrayOfFloat[1]);
    }
    this.jdField_a_of_type_ArrayOfComGoogleAndroidMaterialShapeShapePath[paramInt].a(this.jdField_a_of_type_ArrayOfAndroidGraphicsMatrix[paramInt], paramShapeAppearancePathSpec.jdField_a_of_type_AndroidGraphicsPath);
    if (paramShapeAppearancePathSpec.jdField_a_of_type_ComGoogleAndroidMaterialShapeShapeAppearancePathProvider$PathListener != null) {
      paramShapeAppearancePathSpec.jdField_a_of_type_ComGoogleAndroidMaterialShapeShapeAppearancePathProvider$PathListener.a(this.jdField_a_of_type_ArrayOfComGoogleAndroidMaterialShapeShapePath[paramInt], this.jdField_a_of_type_ArrayOfAndroidGraphicsMatrix[paramInt], paramInt);
    }
  }
  
  private void c(@NonNull ShapeAppearancePathProvider.ShapeAppearancePathSpec paramShapeAppearancePathSpec, int paramInt)
  {
    int i = (paramInt + 1) % 4;
    this.jdField_a_of_type_ArrayOfFloat[0] = this.jdField_a_of_type_ArrayOfComGoogleAndroidMaterialShapeShapePath[paramInt].c();
    this.jdField_a_of_type_ArrayOfFloat[1] = this.jdField_a_of_type_ArrayOfComGoogleAndroidMaterialShapeShapePath[paramInt].d();
    this.jdField_a_of_type_ArrayOfAndroidGraphicsMatrix[paramInt].mapPoints(this.jdField_a_of_type_ArrayOfFloat);
    this.jdField_b_of_type_ArrayOfFloat[0] = this.jdField_a_of_type_ArrayOfComGoogleAndroidMaterialShapeShapePath[i].a();
    this.jdField_b_of_type_ArrayOfFloat[1] = this.jdField_a_of_type_ArrayOfComGoogleAndroidMaterialShapeShapePath[i].b();
    this.jdField_a_of_type_ArrayOfAndroidGraphicsMatrix[i].mapPoints(this.jdField_b_of_type_ArrayOfFloat);
    Object localObject = this.jdField_a_of_type_ArrayOfFloat;
    float f1 = localObject[0];
    float[] arrayOfFloat = this.jdField_b_of_type_ArrayOfFloat;
    f1 = Math.max((float)Math.hypot(f1 - arrayOfFloat[0], localObject[1] - arrayOfFloat[1]) - 0.001F, 0.0F);
    float f2 = a(paramShapeAppearancePathSpec.jdField_a_of_type_AndroidGraphicsRectF, paramInt);
    this.jdField_a_of_type_ComGoogleAndroidMaterialShapeShapePath.a(0.0F, 0.0F);
    localObject = a(paramInt, paramShapeAppearancePathSpec.jdField_a_of_type_ComGoogleAndroidMaterialShapeShapeAppearanceModel);
    ((EdgeTreatment)localObject).a(f1, f2, paramShapeAppearancePathSpec.jdField_a_of_type_Float, this.jdField_a_of_type_ComGoogleAndroidMaterialShapeShapePath);
    this.c.reset();
    this.jdField_a_of_type_ComGoogleAndroidMaterialShapeShapePath.a(this.jdField_b_of_type_ArrayOfAndroidGraphicsMatrix[paramInt], this.c);
    if ((this.jdField_a_of_type_Boolean) && (Build.VERSION.SDK_INT >= 19) && ((((EdgeTreatment)localObject).a()) || (a(this.c, paramInt)) || (a(this.c, i))))
    {
      localObject = this.c;
      ((Path)localObject).op((Path)localObject, this.jdField_b_of_type_AndroidGraphicsPath, Path.Op.DIFFERENCE);
      this.jdField_a_of_type_ArrayOfFloat[0] = this.jdField_a_of_type_ComGoogleAndroidMaterialShapeShapePath.a();
      this.jdField_a_of_type_ArrayOfFloat[1] = this.jdField_a_of_type_ComGoogleAndroidMaterialShapeShapePath.b();
      this.jdField_b_of_type_ArrayOfAndroidGraphicsMatrix[paramInt].mapPoints(this.jdField_a_of_type_ArrayOfFloat);
      localObject = this.jdField_a_of_type_AndroidGraphicsPath;
      arrayOfFloat = this.jdField_a_of_type_ArrayOfFloat;
      ((Path)localObject).moveTo(arrayOfFloat[0], arrayOfFloat[1]);
      this.jdField_a_of_type_ComGoogleAndroidMaterialShapeShapePath.a(this.jdField_b_of_type_ArrayOfAndroidGraphicsMatrix[paramInt], this.jdField_a_of_type_AndroidGraphicsPath);
    }
    else
    {
      this.jdField_a_of_type_ComGoogleAndroidMaterialShapeShapePath.a(this.jdField_b_of_type_ArrayOfAndroidGraphicsMatrix[paramInt], paramShapeAppearancePathSpec.jdField_a_of_type_AndroidGraphicsPath);
    }
    if (paramShapeAppearancePathSpec.jdField_a_of_type_ComGoogleAndroidMaterialShapeShapeAppearancePathProvider$PathListener != null) {
      paramShapeAppearancePathSpec.jdField_a_of_type_ComGoogleAndroidMaterialShapeShapeAppearancePathProvider$PathListener.b(this.jdField_a_of_type_ComGoogleAndroidMaterialShapeShapePath, this.jdField_b_of_type_ArrayOfAndroidGraphicsMatrix[paramInt], paramInt);
    }
  }
  
  public void a(ShapeAppearanceModel paramShapeAppearanceModel, float paramFloat, RectF paramRectF, @NonNull Path paramPath)
  {
    a(paramShapeAppearanceModel, paramFloat, paramRectF, null, paramPath);
  }
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
  public void a(ShapeAppearanceModel paramShapeAppearanceModel, float paramFloat, RectF paramRectF, ShapeAppearancePathProvider.PathListener paramPathListener, @NonNull Path paramPath)
  {
    paramPath.rewind();
    this.jdField_a_of_type_AndroidGraphicsPath.rewind();
    this.jdField_b_of_type_AndroidGraphicsPath.rewind();
    this.jdField_b_of_type_AndroidGraphicsPath.addRect(paramRectF, Path.Direction.CW);
    paramShapeAppearanceModel = new ShapeAppearancePathProvider.ShapeAppearancePathSpec(paramShapeAppearanceModel, paramFloat, paramRectF, paramPathListener, paramPath);
    int k = 0;
    int i = 0;
    int j;
    for (;;)
    {
      j = k;
      if (i >= 4) {
        break;
      }
      a(paramShapeAppearanceModel, i);
      a(i);
      i += 1;
    }
    while (j < 4)
    {
      b(paramShapeAppearanceModel, j);
      c(paramShapeAppearanceModel, j);
      j += 1;
    }
    paramPath.close();
    this.jdField_a_of_type_AndroidGraphicsPath.close();
    if ((Build.VERSION.SDK_INT >= 19) && (!this.jdField_a_of_type_AndroidGraphicsPath.isEmpty())) {
      paramPath.op(this.jdField_a_of_type_AndroidGraphicsPath, Path.Op.UNION);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.google.android.material.shape.ShapeAppearancePathProvider
 * JD-Core Version:    0.7.0.1
 */