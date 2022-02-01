import android.graphics.Point;
import com.tencent.mobileqq.profile.PersonalityLabel.tagCloud.TagCloudView;
import java.util.Comparator;
import java.util.Random;

public class azqu
  implements Comparator<azqq>
{
  int jdField_a_of_type_Int;
  Random jdField_a_of_type_JavaUtilRandom;
  int b;
  
  public azqu(TagCloudView paramTagCloudView, Random paramRandom, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_JavaUtilRandom = paramRandom;
    this.jdField_a_of_type_Int = paramInt2;
    this.b = paramInt1;
  }
  
  public int a(azqq paramazqq1, azqq paramazqq2)
  {
    if ((paramazqq1.b.y > this.jdField_a_of_type_Int) || (paramazqq2.b.y > this.jdField_a_of_type_Int)) {
      return -(paramazqq1.b.y - paramazqq2.b.y);
    }
    if ((paramazqq1.b.x > this.b) || (paramazqq2.b.x > this.b)) {
      return -(paramazqq1.b.x - paramazqq2.b.x);
    }
    return this.jdField_a_of_type_JavaUtilRandom.nextInt(3) - 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azqu
 * JD-Core Version:    0.7.0.1
 */