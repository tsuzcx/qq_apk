import android.graphics.Point;
import com.tencent.mobileqq.profile.PersonalityLabel.tagCloud.TagCloudView;
import java.util.Comparator;
import java.util.Random;

public class aylz
  implements Comparator<aylv>
{
  int jdField_a_of_type_Int;
  Random jdField_a_of_type_JavaUtilRandom;
  int b;
  
  public aylz(TagCloudView paramTagCloudView, Random paramRandom, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_JavaUtilRandom = paramRandom;
    this.jdField_a_of_type_Int = paramInt2;
    this.b = paramInt1;
  }
  
  public int a(aylv paramaylv1, aylv paramaylv2)
  {
    if ((paramaylv1.b.y > this.jdField_a_of_type_Int) || (paramaylv2.b.y > this.jdField_a_of_type_Int)) {
      return -(paramaylv1.b.y - paramaylv2.b.y);
    }
    if ((paramaylv1.b.x > this.b) || (paramaylv2.b.x > this.b)) {
      return -(paramaylv1.b.x - paramaylv2.b.x);
    }
    return this.jdField_a_of_type_JavaUtilRandom.nextInt(3) - 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aylz
 * JD-Core Version:    0.7.0.1
 */