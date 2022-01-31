import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import java.util.ArrayList;
import java.util.Iterator;

public class amdl
{
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  private ArrayList jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private int b;
  private int c;
  private int d;
  
  public amdl(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.b = paramInt1;
    this.c = paramInt2;
    this.d = paramInt3;
    this.jdField_a_of_type_Int = paramInt4;
    this.jdField_a_of_type_JavaUtilArrayList = a(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public int a()
  {
    return (int)((this.c - this.b) / (this.jdField_a_of_type_Int - 1.0F));
  }
  
  public ArrayList a()
  {
    return this.jdField_a_of_type_JavaUtilArrayList;
  }
  
  public ArrayList a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    ArrayList localArrayList = new ArrayList(paramInt4);
    int j = (int)((paramInt2 - paramInt1) / (paramInt4 - 1.0F));
    int i = 0;
    paramInt2 = paramInt1;
    paramInt1 = i;
    if (paramInt1 < paramInt4)
    {
      if (paramInt1 == 0) {}
      for (i = 0;; i = j)
      {
        Point localPoint = new Point(i + paramInt2, paramInt3);
        localArrayList.add(localPoint);
        paramInt2 = localPoint.x;
        paramInt1 += 1;
        break;
      }
    }
    return localArrayList;
  }
  
  public void a(float paramFloat)
  {
    this.jdField_a_of_type_Float = paramFloat;
  }
  
  public void a(Canvas paramCanvas, Paint paramPaint, amdh paramamdh)
  {
    int i = paramPaint.getColor();
    float f1 = paramPaint.getStrokeWidth();
    paramPaint.setColor(paramamdh.b);
    paramPaint.setStrokeWidth(paramamdh.e);
    paramCanvas.drawLine(this.b, this.d, this.c, this.d, paramPaint);
    paramamdh = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (paramamdh.hasNext())
    {
      Point localPoint = (Point)paramamdh.next();
      float f2 = localPoint.x;
      float f3 = localPoint.y;
      float f4 = this.jdField_a_of_type_Float / 2.0F;
      float f5 = localPoint.x;
      float f6 = localPoint.y;
      paramCanvas.drawLine(f2, f3 - f4, f5, this.jdField_a_of_type_Float / 2.0F + f6, paramPaint);
    }
    paramPaint.setColor(i);
    paramPaint.setStrokeWidth(f1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     amdl
 * JD-Core Version:    0.7.0.1
 */