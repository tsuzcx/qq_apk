import android.graphics.Point;
import com.tencent.mobileqq.profile.PersonalityLabel.tagCloud.TagCloudView;
import java.util.Comparator;
import java.util.Random;

public class atwq
  implements Comparator<atwm>
{
  int jdField_a_of_type_Int;
  Random jdField_a_of_type_JavaUtilRandom;
  int b;
  
  public atwq(TagCloudView paramTagCloudView, Random paramRandom, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_JavaUtilRandom = paramRandom;
    this.jdField_a_of_type_Int = paramInt2;
    this.b = paramInt1;
  }
  
  public int a(atwm paramatwm1, atwm paramatwm2)
  {
    if ((paramatwm1.b.y > this.jdField_a_of_type_Int) || (paramatwm2.b.y > this.jdField_a_of_type_Int)) {
      return -(paramatwm1.b.y - paramatwm2.b.y);
    }
    if ((paramatwm1.b.x > this.b) || (paramatwm2.b.x > this.b)) {
      return -(paramatwm1.b.x - paramatwm2.b.x);
    }
    return this.jdField_a_of_type_JavaUtilRandom.nextInt(3) - 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atwq
 * JD-Core Version:    0.7.0.1
 */