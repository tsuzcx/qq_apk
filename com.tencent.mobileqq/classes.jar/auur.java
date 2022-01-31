import android.graphics.Point;
import com.tencent.mobileqq.profile.PersonalityLabel.tagCloud.TagCloudView;
import java.util.Comparator;
import java.util.Random;

public class auur
  implements Comparator<auun>
{
  int jdField_a_of_type_Int;
  Random jdField_a_of_type_JavaUtilRandom;
  int b;
  
  public auur(TagCloudView paramTagCloudView, Random paramRandom, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_JavaUtilRandom = paramRandom;
    this.jdField_a_of_type_Int = paramInt2;
    this.b = paramInt1;
  }
  
  public int a(auun paramauun1, auun paramauun2)
  {
    if ((paramauun1.b.y > this.jdField_a_of_type_Int) || (paramauun2.b.y > this.jdField_a_of_type_Int)) {
      return -(paramauun1.b.y - paramauun2.b.y);
    }
    if ((paramauun1.b.x > this.b) || (paramauun2.b.x > this.b)) {
      return -(paramauun1.b.x - paramauun2.b.x);
    }
    return this.jdField_a_of_type_JavaUtilRandom.nextInt(3) - 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     auur
 * JD-Core Version:    0.7.0.1
 */