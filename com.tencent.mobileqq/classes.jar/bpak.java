import android.graphics.Matrix;
import android.graphics.Path;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class bpak
  extends bozs
{
  public Path a;
  ArrayList<bpas> jdField_a_of_type_JavaUtilArrayList;
  List<Integer> jdField_a_of_type_JavaUtilList;
  public int b;
  List<Integer> b;
  public int c;
  
  public bpak(int paramInt)
  {
    super(paramInt);
    this.jdField_a_of_type_AndroidGraphicsPath = new Path();
    this.jdField_a_of_type_JavaUtilList = new LinkedList();
    this.jdField_b_of_type_JavaUtilList = new LinkedList();
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  }
  
  public bpak(bozs parambozs, float paramFloat)
  {
    super(parambozs.jdField_a_of_type_Int);
    if ((parambozs instanceof bpak))
    {
      parambozs = (bpak)parambozs;
      Matrix localMatrix = new Matrix();
      localMatrix.postScale(paramFloat, paramFloat);
      this.jdField_a_of_type_AndroidGraphicsPath = new Path();
      this.jdField_a_of_type_AndroidGraphicsPath.addPath(parambozs.jdField_a_of_type_AndroidGraphicsPath, localMatrix);
      this.jdField_a_of_type_Int = parambozs.jdField_a_of_type_Int;
      this.jdField_b_of_type_Int = parambozs.jdField_b_of_type_Int;
      this.c = ((int)(parambozs.c * paramFloat));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bpak
 * JD-Core Version:    0.7.0.1
 */