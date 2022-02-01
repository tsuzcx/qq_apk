import android.view.MotionEvent;

public class bckb
{
  final float jdField_a_of_type_Float;
  final int jdField_a_of_type_Int;
  final long jdField_a_of_type_Long;
  final float[] jdField_a_of_type_ArrayOfFloat;
  final int[] jdField_a_of_type_ArrayOfInt;
  final float jdField_b_of_type_Float;
  final int jdField_b_of_type_Int;
  final float[] jdField_b_of_type_ArrayOfFloat;
  final int c;
  
  public bckb(MotionEvent paramMotionEvent)
  {
    this.jdField_a_of_type_Int = paramMotionEvent.getActionMasked();
    this.jdField_b_of_type_Int = paramMotionEvent.getPointerCount();
    this.jdField_a_of_type_ArrayOfInt = new int[this.jdField_b_of_type_Int];
    this.jdField_a_of_type_ArrayOfFloat = new float[this.jdField_b_of_type_Int];
    this.jdField_b_of_type_ArrayOfFloat = new float[this.jdField_b_of_type_Int];
    int i = 0;
    while (i < this.jdField_b_of_type_Int)
    {
      this.jdField_a_of_type_ArrayOfInt[i] = paramMotionEvent.getPointerId(i);
      this.jdField_a_of_type_ArrayOfFloat[i] = paramMotionEvent.getX(i);
      this.jdField_b_of_type_ArrayOfFloat[i] = paramMotionEvent.getY(i);
      i += 1;
    }
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    i = paramMotionEvent.getActionIndex();
    this.c = paramMotionEvent.getPointerId(i);
    this.jdField_a_of_type_Float = paramMotionEvent.getX(i);
    this.jdField_b_of_type_Float = paramMotionEvent.getY(i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bckb
 * JD-Core Version:    0.7.0.1
 */