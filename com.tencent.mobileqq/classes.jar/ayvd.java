import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.Rect;
import java.util.ArrayList;
import java.util.List;

public class ayvd
  extends ayvb
{
  public float a;
  public Bitmap a;
  public Rect a;
  public String a;
  public float b;
  public boolean b;
  public boolean c;
  public boolean d;
  public int f;
  public int g;
  public int h = -1;
  public int i = -1;
  public int j = -1;
  public int k = -1;
  public int l = -1;
  public int m = -1;
  public int n = -1;
  public int o = -1;
  
  public ayvd(avav paramavav)
  {
    this.jdField_a_of_type_Float = -1.0F;
    this.jdField_b_of_type_Float = -1.0F;
    this.jdField_a_of_type_JavaLangString = paramavav.jdField_a_of_type_JavaLangString;
    this.jdField_a_of_type_AndroidGraphicsRect = new Rect();
    this.jdField_a_of_type_Int = paramavav.a();
    this.h = paramavav.jdField_b_of_type_Int;
    this.j = 0;
    this.m = paramavav.jdField_a_of_type_Int;
    this.jdField_a_of_type_JavaUtilList.clear();
    if (!paramavav.jdField_a_of_type_JavaUtilArrayList.isEmpty()) {
      this.jdField_a_of_type_JavaUtilList.addAll(paramavav.jdField_a_of_type_JavaUtilArrayList);
    }
    paramavav = (Point)this.jdField_a_of_type_JavaUtilList.get(0);
    Point localPoint = (Point)this.jdField_a_of_type_JavaUtilList.get(1);
    if (paramavav.x > localPoint.x) {}
    for (boolean bool = true;; bool = false)
    {
      this.jdField_c_of_type_Boolean = bool;
      return;
    }
  }
  
  public Point a()
  {
    return (Point)this.jdField_a_of_type_JavaUtilList.get(0);
  }
  
  public void a(float paramFloat1, float paramFloat2)
  {
    int i1 = 0;
    while (i1 < this.jdField_a_of_type_JavaUtilList.size())
    {
      Point localPoint = (Point)this.jdField_a_of_type_JavaUtilList.get(i1);
      localPoint = new Point((int)(localPoint.x * paramFloat1), (int)(localPoint.y * paramFloat2));
      this.jdField_b_of_type_Int = Math.max(this.jdField_b_of_type_Int, localPoint.x);
      this.jdField_c_of_type_Int = Math.max(this.jdField_c_of_type_Int, localPoint.y);
      this.d = Math.min(this.d, localPoint.x);
      this.e = Math.min(this.e, localPoint.y);
      if (localPoint.x < 0) {
        localPoint.x = 0;
      }
      if (localPoint.y < 0) {
        localPoint.y = 0;
      }
      this.jdField_a_of_type_JavaUtilList.set(i1, localPoint);
      i1 += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayvd
 * JD-Core Version:    0.7.0.1
 */