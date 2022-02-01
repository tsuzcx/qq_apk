import android.graphics.Matrix;
import android.graphics.Path;
import java.util.ArrayList;

public class bpat
  extends bozs
{
  public Path a;
  ArrayList<bpas> a;
  public int b;
  public int c;
  
  public bpat(Path paramPath, int paramInt1, int paramInt2, int paramInt3)
  {
    super(paramInt1);
    this.jdField_a_of_type_AndroidGraphicsPath = paramPath;
    this.b = paramInt2;
    this.c = paramInt3;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  }
  
  public bpat(bozs parambozs, float paramFloat)
  {
    super(parambozs.jdField_a_of_type_Int);
    if ((parambozs instanceof bpat))
    {
      parambozs = (bpat)parambozs;
      Matrix localMatrix = new Matrix();
      localMatrix.postScale(paramFloat, paramFloat);
      this.jdField_a_of_type_AndroidGraphicsPath = new Path();
      this.jdField_a_of_type_AndroidGraphicsPath.addPath(parambozs.jdField_a_of_type_AndroidGraphicsPath, localMatrix);
      this.jdField_a_of_type_Int = parambozs.jdField_a_of_type_Int;
      this.b = parambozs.b;
      this.c = ((int)(parambozs.c * paramFloat));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bpat
 * JD-Core Version:    0.7.0.1
 */