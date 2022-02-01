import android.graphics.Matrix;
import android.graphics.Path;
import java.util.ArrayList;

public class bnlb
  extends bnka
{
  public Path a;
  ArrayList<bnla> a;
  public int b;
  public int c;
  
  public bnlb(Path paramPath, int paramInt1, int paramInt2, int paramInt3)
  {
    super(paramInt1);
    this.jdField_a_of_type_AndroidGraphicsPath = paramPath;
    this.b = paramInt2;
    this.c = paramInt3;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  }
  
  public bnlb(bnka parambnka, float paramFloat)
  {
    super(parambnka.jdField_a_of_type_Int);
    if ((parambnka instanceof bnlb))
    {
      parambnka = (bnlb)parambnka;
      Matrix localMatrix = new Matrix();
      localMatrix.postScale(paramFloat, paramFloat);
      this.jdField_a_of_type_AndroidGraphicsPath = new Path();
      this.jdField_a_of_type_AndroidGraphicsPath.addPath(parambnka.jdField_a_of_type_AndroidGraphicsPath, localMatrix);
      this.jdField_a_of_type_Int = parambnka.jdField_a_of_type_Int;
      this.b = parambnka.b;
      this.c = ((int)(parambnka.c * paramFloat));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnlb
 * JD-Core Version:    0.7.0.1
 */