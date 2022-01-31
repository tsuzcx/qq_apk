import android.graphics.Point;
import com.tencent.mobileqq.profile.PersonalityLabel.tagCloud.TagCloudView;
import java.util.Comparator;
import java.util.Random;

public class awmd
  implements Comparator<awlz>
{
  int jdField_a_of_type_Int;
  Random jdField_a_of_type_JavaUtilRandom;
  int b;
  
  public awmd(TagCloudView paramTagCloudView, Random paramRandom, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_JavaUtilRandom = paramRandom;
    this.jdField_a_of_type_Int = paramInt2;
    this.b = paramInt1;
  }
  
  public int a(awlz paramawlz1, awlz paramawlz2)
  {
    if ((paramawlz1.b.y > this.jdField_a_of_type_Int) || (paramawlz2.b.y > this.jdField_a_of_type_Int)) {
      return -(paramawlz1.b.y - paramawlz2.b.y);
    }
    if ((paramawlz1.b.x > this.b) || (paramawlz2.b.x > this.b)) {
      return -(paramawlz1.b.x - paramawlz2.b.x);
    }
    return this.jdField_a_of_type_JavaUtilRandom.nextInt(3) - 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     awmd
 * JD-Core Version:    0.7.0.1
 */