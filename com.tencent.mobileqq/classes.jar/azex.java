import android.graphics.Point;
import com.tencent.mobileqq.profile.PersonalityLabel.tagCloud.TagCloudView;
import java.util.Comparator;
import java.util.Random;

public class azex
  implements Comparator<azet>
{
  int jdField_a_of_type_Int;
  Random jdField_a_of_type_JavaUtilRandom;
  int b;
  
  public azex(TagCloudView paramTagCloudView, Random paramRandom, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_JavaUtilRandom = paramRandom;
    this.jdField_a_of_type_Int = paramInt2;
    this.b = paramInt1;
  }
  
  public int a(azet paramazet1, azet paramazet2)
  {
    if ((paramazet1.b.y > this.jdField_a_of_type_Int) || (paramazet2.b.y > this.jdField_a_of_type_Int)) {
      return -(paramazet1.b.y - paramazet2.b.y);
    }
    if ((paramazet1.b.x > this.b) || (paramazet2.b.x > this.b)) {
      return -(paramazet1.b.x - paramazet2.b.x);
    }
    return this.jdField_a_of_type_JavaUtilRandom.nextInt(3) - 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azex
 * JD-Core Version:    0.7.0.1
 */