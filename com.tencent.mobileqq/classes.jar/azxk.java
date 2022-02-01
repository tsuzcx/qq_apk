import android.graphics.Point;
import com.tencent.mobileqq.profile.PersonalityLabel.tagCloud.TagCloudView;
import java.util.Comparator;
import java.util.Random;

public class azxk
  implements Comparator<azxg>
{
  int jdField_a_of_type_Int;
  Random jdField_a_of_type_JavaUtilRandom;
  int b;
  
  public azxk(TagCloudView paramTagCloudView, Random paramRandom, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_JavaUtilRandom = paramRandom;
    this.jdField_a_of_type_Int = paramInt2;
    this.b = paramInt1;
  }
  
  public int a(azxg paramazxg1, azxg paramazxg2)
  {
    if ((paramazxg1.b.y > this.jdField_a_of_type_Int) || (paramazxg2.b.y > this.jdField_a_of_type_Int)) {
      return -(paramazxg1.b.y - paramazxg2.b.y);
    }
    if ((paramazxg1.b.x > this.b) || (paramazxg2.b.x > this.b)) {
      return -(paramazxg1.b.x - paramazxg2.b.x);
    }
    return this.jdField_a_of_type_JavaUtilRandom.nextInt(3) - 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azxk
 * JD-Core Version:    0.7.0.1
 */