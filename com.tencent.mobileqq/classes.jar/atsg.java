import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Shader.TileMode;
import java.util.ArrayList;

public class atsg
{
  public final int a;
  public atsf a;
  public final String a;
  public final ArrayList<atsb> a;
  public final int b;
  public atsf b;
  public final int c;
  private final int d;
  
  public atsg(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4, ArrayList<atsb> paramArrayList)
  {
    this.jdField_a_of_type_Atsf = new atsf();
    this.jdField_b_of_type_Atsf = new atsf();
    this.jdField_a_of_type_Int = paramInt1;
    this.d = paramInt2;
    this.jdField_b_of_type_Int = paramInt3;
    this.c = paramInt4;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
  }
  
  public atsg(String paramString, int paramInt1, int paramInt2, ArrayList<atsb> paramArrayList)
  {
    this.jdField_a_of_type_Atsf = new atsf();
    this.jdField_b_of_type_Atsf = new atsf();
    this.jdField_a_of_type_Int = paramInt1;
    this.d = paramInt2;
    this.jdField_b_of_type_Int = 0;
    this.c = 0;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
  }
  
  public long a()
  {
    if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > 0)) {
      return ((atsb)this.jdField_a_of_type_JavaUtilArrayList.get(0)).jdField_a_of_type_Long;
    }
    return 0L;
  }
  
  public void a(Canvas paramCanvas, int paramInt1, int paramInt2, Paint paramPaint1, Paint paramPaint2)
  {
    a(paramCanvas, paramInt1, paramInt2, paramPaint1, paramPaint2, null, null, 1);
  }
  
  public void a(Canvas paramCanvas, int paramInt1, int paramInt2, Paint paramPaint1, Paint paramPaint2, Bitmap paramBitmap1, Bitmap paramBitmap2, int paramInt3)
  {
    paramInt1 = this.jdField_a_of_type_Int + paramInt1;
    if ((this.jdField_a_of_type_Atsf != null) && (this.jdField_a_of_type_Atsf.a != null) && (!this.jdField_a_of_type_Atsf.a.isRecycled()))
    {
      paramBitmap1 = new Rect(paramInt1 - this.jdField_a_of_type_Atsf.c - this.jdField_a_of_type_Atsf.a.getWidth(), (int)(paramInt2 - paramPaint1.getTextSize()), paramInt1 - this.jdField_a_of_type_Atsf.c, (int)(this.jdField_a_of_type_Atsf.a.getHeight() + paramInt2 - paramPaint1.getTextSize()));
      paramCanvas.drawBitmap(this.jdField_a_of_type_Atsf.a, null, paramBitmap1, null);
    }
    paramCanvas.drawText(this.jdField_a_of_type_JavaLangString, paramInt1 - paramInt3, paramInt2 - paramInt3, paramPaint2);
    paramCanvas.drawText(this.jdField_a_of_type_JavaLangString, paramInt1, paramInt2 - paramInt3, paramPaint2);
    paramCanvas.drawText(this.jdField_a_of_type_JavaLangString, paramInt1 + paramInt3, paramInt2 - paramInt3, paramPaint2);
    paramCanvas.drawText(this.jdField_a_of_type_JavaLangString, paramInt1 + paramInt3, paramInt2, paramPaint2);
    paramCanvas.drawText(this.jdField_a_of_type_JavaLangString, paramInt1 + paramInt3, paramInt2 + paramInt3, paramPaint2);
    paramCanvas.drawText(this.jdField_a_of_type_JavaLangString, paramInt1, paramInt2 + paramInt3, paramPaint2);
    paramCanvas.drawText(this.jdField_a_of_type_JavaLangString, paramInt1 - paramInt3, paramInt2 + paramInt3, paramPaint2);
    paramCanvas.drawText(this.jdField_a_of_type_JavaLangString, paramInt1 - paramInt3, paramInt2, paramPaint2);
    paramCanvas.drawText(this.jdField_a_of_type_JavaLangString, paramInt1, paramInt2, paramPaint1);
  }
  
  public void a(Canvas paramCanvas, int paramInt1, int paramInt2, Paint paramPaint1, Paint paramPaint2, Paint paramPaint3, int paramInt3, float paramFloat1, float paramFloat2, int[] paramArrayOfInt, float[] paramArrayOfFloat)
  {
    int i = this.d;
    paramFloat2 += this.d;
    paramPaint3.setShader(new LinearGradient(paramFloat2, paramInt2, paramFloat2 + paramFloat1, paramInt2, paramArrayOfInt, paramArrayOfFloat, Shader.TileMode.CLAMP));
    if (paramInt3 > 0)
    {
      paramArrayOfInt = (atsb)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt3 - 1);
      paramCanvas.drawText(this.jdField_a_of_type_JavaLangString.substring(0, paramArrayOfInt.jdField_b_of_type_Int), paramInt1 + i, paramInt2, paramPaint2);
    }
    paramPaint2 = (atsb)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt3);
    if (paramInt3 == this.jdField_a_of_type_JavaUtilArrayList.size() - 1) {}
    for (paramPaint2 = this.jdField_a_of_type_JavaLangString.substring(paramPaint2.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString.length());; paramPaint2 = this.jdField_a_of_type_JavaLangString.substring(paramPaint2.jdField_a_of_type_Int, paramPaint2.jdField_b_of_type_Int))
    {
      paramCanvas.drawText(paramPaint2, paramFloat2, paramInt2, paramPaint3);
      if (paramInt3 < this.jdField_a_of_type_JavaUtilArrayList.size() - 1)
      {
        paramPaint2 = (atsb)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt3 + 1);
        paramCanvas.drawText(this.jdField_a_of_type_JavaLangString.substring(paramPaint2.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString.length()), paramFloat2 + paramFloat1, paramInt2, paramPaint1);
      }
      return;
    }
  }
  
  public void a(Canvas paramCanvas, int paramInt1, int paramInt2, Paint paramPaint, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = this.d;; i = this.jdField_a_of_type_Int)
    {
      paramCanvas.drawText(this.jdField_a_of_type_JavaLangString, i + paramInt1, paramInt2, paramPaint);
      return;
    }
  }
  
  public long b()
  {
    if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > 0))
    {
      atsb localatsb = (atsb)this.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_JavaUtilArrayList.size() - 1);
      long l = localatsb.jdField_a_of_type_Long;
      return localatsb.jdField_b_of_type_Long + l;
    }
    return 0L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atsg
 * JD-Core Version:    0.7.0.1
 */