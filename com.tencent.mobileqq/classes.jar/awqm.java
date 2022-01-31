import android.graphics.Point;
import com.tencent.mobileqq.profile.PersonalityLabel.tagCloud.TagCloudView;
import java.util.Comparator;
import java.util.Random;

public class awqm
  implements Comparator<awqi>
{
  int jdField_a_of_type_Int;
  Random jdField_a_of_type_JavaUtilRandom;
  int b;
  
  public awqm(TagCloudView paramTagCloudView, Random paramRandom, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_JavaUtilRandom = paramRandom;
    this.jdField_a_of_type_Int = paramInt2;
    this.b = paramInt1;
  }
  
  public int a(awqi paramawqi1, awqi paramawqi2)
  {
    if ((paramawqi1.b.y > this.jdField_a_of_type_Int) || (paramawqi2.b.y > this.jdField_a_of_type_Int)) {
      return -(paramawqi1.b.y - paramawqi2.b.y);
    }
    if ((paramawqi1.b.x > this.b) || (paramawqi2.b.x > this.b)) {
      return -(paramawqi1.b.x - paramawqi2.b.x);
    }
    return this.jdField_a_of_type_JavaUtilRandom.nextInt(3) - 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     awqm
 * JD-Core Version:    0.7.0.1
 */