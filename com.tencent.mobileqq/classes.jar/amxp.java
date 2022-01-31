import android.graphics.Rect;
import android.graphics.RectF;
import com.tencent.mobileqq.ar.DrawView2;
import com.tencent.qphone.base.util.QLog;

public class amxp
{
  public float a;
  public int a;
  public Rect a;
  public RectF a;
  public String a;
  public boolean a;
  public float[] a;
  public String b;
  public boolean b;
  public String c;
  public boolean c;
  public String d;
  public boolean d;
  public String e;
  public boolean e;
  public String f;
  public String g;
  public String h;
  
  public static RectF a(Rect paramRect, float[] paramArrayOfFloat)
  {
    if ((paramRect == null) || (paramArrayOfFloat == null) || (paramArrayOfFloat.length < 180))
    {
      paramRect = null;
      return paramRect;
    }
    paramArrayOfFloat = (float[])paramArrayOfFloat.clone();
    float[] arrayOfFloat1 = new float[2];
    float[] arrayOfFloat2 = new float[2];
    float[] arrayOfFloat3 = new float[2];
    float[] arrayOfFloat4 = new float[2];
    arrayOfFloat1[0] = paramArrayOfFloat[12];
    arrayOfFloat1[1] = paramArrayOfFloat[13];
    arrayOfFloat2[0] = paramArrayOfFloat[28];
    arrayOfFloat2[1] = paramArrayOfFloat[29];
    arrayOfFloat3[0] = paramArrayOfFloat[64];
    arrayOfFloat3[1] = paramArrayOfFloat[65];
    arrayOfFloat4[0] = (arrayOfFloat1[0] + arrayOfFloat2[0] - arrayOfFloat3[0]);
    arrayOfFloat4[1] = (arrayOfFloat1[1] + arrayOfFloat2[1] - arrayOfFloat3[1]);
    float f2 = Math.min(paramRect.left, arrayOfFloat4[0]);
    float f3 = Math.max(paramRect.right, arrayOfFloat4[0]);
    float f4 = Math.min(paramRect.top, arrayOfFloat4[1]);
    float f5 = Math.max(paramRect.bottom, arrayOfFloat4[1]);
    float f1 = DrawView2.c / DrawView2.d;
    float f6 = Math.max(DrawView2.a, DrawView2.b);
    float f7 = Math.min(DrawView2.a, DrawView2.b);
    if (f1 > f7 / f6) {}
    for (f1 = DrawView2.c / f7;; f1 = DrawView2.d / f6)
    {
      float f8 = (f1 * f7 - DrawView2.c) / 2.0F;
      f7 = (f7 * f1 - DrawView2.c) / 2.0F;
      paramArrayOfFloat = new RectF(f2 * f1 - f8, f4 * f1 - (f1 * f6 - DrawView2.d) / 2.0F, f3 * f1 - f7, f5 * f1 - (f1 * f6 - DrawView2.d) / 2.0F);
      paramRect = paramArrayOfFloat;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("DrawView", 2, "mapFaceRect2Screen  result = " + paramArrayOfFloat.toString());
      return paramArrayOfFloat;
    }
  }
  
  public static RectF a(RectF paramRectF)
  {
    float f4 = 40.0F;
    if (paramRectF == null) {
      return null;
    }
    if (QLog.isColorLevel()) {
      QLog.d("DrawView", 2, "faceRect  result = " + paramRectF.toString());
    }
    if ((paramRectF.left == 0.0F) && (paramRectF.top == 0.0F) && (paramRectF.right == 0.0F)) {
      return new RectF(DrawView2.c / 2 - 210, DrawView2.d / 2 - 210, DrawView2.c / 2 + 210, DrawView2.d / 2 + 210);
    }
    float f3 = paramRectF.left;
    float f5 = paramRectF.right;
    float f1 = paramRectF.top;
    float f2 = paramRectF.bottom;
    f3 = (f3 + f5) / 2.0F;
    f2 = (f1 + f2) / 2.0F;
    f1 = f3 * (DrawView2.c / 480);
    f2 *= DrawView2.d / 856;
    float f6 = f1 - 210.0F;
    f3 = f2 - 210.0F;
    float f7 = f1 + 210.0F;
    f5 = f2 + 210.0F;
    if (QLog.isColorLevel()) {
      QLog.d("DrawView", 2, "mapMigObjectRect2Screen1  result = " + f6 + "   ：" + f3 + "  ：" + f7 + "  ：" + f5);
    }
    f2 = f7;
    f1 = f6;
    if (f6 < 40.0F)
    {
      f2 = f7 - f6 + 40.0F;
      f1 = 40.0F;
    }
    if (f3 < 40.0F) {}
    for (f3 = f5 - f3 + 40.0F;; f3 = f5)
    {
      if (f2 > DrawView2.c - 40)
      {
        f6 = DrawView2.c - 40 - (f2 - f1);
        f5 = DrawView2.c - 40;
      }
      for (;;)
      {
        f2 = f3;
        f1 = f4;
        if (f3 > DrawView2.d - 40)
        {
          f1 = DrawView2.d - 40 - (f3 - f4);
          f2 = DrawView2.d - 40;
        }
        if (QLog.isColorLevel()) {
          QLog.d("DrawView", 2, "mapMigObjectRect2Screen1  result = " + f6 + "   ：" + f1 + "  ：" + f5 + "  ：" + f2);
        }
        f4 = f5;
        f3 = f6;
        if ((f6 + f5) / 2.0F < DrawView2.c / 2 - 125)
        {
          f3 = DrawView2.c / 2 - 125 - 210;
          f4 = DrawView2.c / 2 - 125 + 210;
        }
        f6 = f4;
        f5 = f3;
        if ((f3 + f4) / 2.0F > DrawView2.c / 2 + 125)
        {
          f5 = DrawView2.c / 2 + 125 - 210;
          f6 = DrawView2.c / 2 + 125 + 210;
        }
        f4 = f2;
        f3 = f1;
        if ((f1 + f2) / 2.0F < DrawView2.d / 2 - 417)
        {
          f3 = DrawView2.d / 2 - 417 - 210;
          f4 = DrawView2.d / 2 - 417 + 210;
        }
        f2 = f4;
        f1 = f3;
        if ((f3 + f4) / 2.0F > DrawView2.d / 2 + 417)
        {
          f1 = DrawView2.d / 2 + 417 - 210;
          f2 = DrawView2.d / 2 + 417 + 210;
        }
        paramRectF = new RectF(f5, f1, f6, f2);
        if (QLog.isColorLevel()) {
          QLog.d("DrawView", 2, "mapMigObjectRect2Screen3  result = " + paramRectF.toString());
        }
        return paramRectF;
        f5 = f2;
        f6 = f1;
      }
      f4 = f3;
    }
  }
  
  public RectF a()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amxp
 * JD-Core Version:    0.7.0.1
 */