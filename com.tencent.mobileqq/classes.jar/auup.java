import android.graphics.Point;
import com.tencent.mobileqq.profile.PersonalityLabel.tagCloud.TagCloudView;
import java.util.Comparator;
import java.util.Random;

public class auup
  implements Comparator<auul>
{
  int jdField_a_of_type_Int;
  Random jdField_a_of_type_JavaUtilRandom;
  int b;
  
  public auup(TagCloudView paramTagCloudView, Random paramRandom, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_JavaUtilRandom = paramRandom;
    this.jdField_a_of_type_Int = paramInt2;
    this.b = paramInt1;
  }
  
  public int a(auul paramauul1, auul paramauul2)
  {
    if ((paramauul1.b.y > this.jdField_a_of_type_Int) || (paramauul2.b.y > this.jdField_a_of_type_Int)) {
      return -(paramauul1.b.y - paramauul2.b.y);
    }
    if ((paramauul1.b.x > this.b) || (paramauul2.b.x > this.b)) {
      return -(paramauul1.b.x - paramauul2.b.x);
    }
    return this.jdField_a_of_type_JavaUtilRandom.nextInt(3) - 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     auup
 * JD-Core Version:    0.7.0.1
 */