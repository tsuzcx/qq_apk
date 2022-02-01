import android.graphics.PointF;

public class apli
{
  public int a;
  public String a;
  public boolean a;
  public PointF[] a;
  public int b;
  public int c;
  public int d = -1;
  
  public apli()
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_ArrayOfAndroidGraphicsPointF = new PointF[1000];
    a();
  }
  
  public apli(int paramInt)
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_ArrayOfAndroidGraphicsPointF = new PointF[paramInt];
    a();
  }
  
  public void a()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_JavaLangString = "";
    this.b = 0;
    this.c = 0;
    this.d = -1;
  }
  
  public String toString()
  {
    if (this.b > 0) {}
    for (String str = "(" + (int)this.jdField_a_of_type_ArrayOfAndroidGraphicsPointF[(this.b - 1)].x + "," + (int)this.jdField_a_of_type_ArrayOfAndroidGraphicsPointF[(this.b - 1)].y + ")";; str = "(-1,-1)") {
      return "ARGestureResult{, state = " + this.jdField_a_of_type_Int + ", type = " + this.jdField_a_of_type_JavaLangString + ", pointCnt = " + this.b + ", newPoint(x,y) = " + str + ", mode = " + this.d + '}';
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apli
 * JD-Core Version:    0.7.0.1
 */