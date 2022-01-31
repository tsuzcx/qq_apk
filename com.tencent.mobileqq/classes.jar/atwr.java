import android.graphics.Point;
import com.tencent.mobileqq.profile.PersonalityLabel.tagCloud.TagCloudView;
import java.util.Comparator;

public class atwr
  implements Comparator<atwm>
{
  Point jdField_a_of_type_AndroidGraphicsPoint;
  
  public atwr(TagCloudView paramTagCloudView, Point paramPoint)
  {
    this.jdField_a_of_type_AndroidGraphicsPoint = paramPoint;
  }
  
  public int a(atwm paramatwm1, atwm paramatwm2)
  {
    return TagCloudView.a(paramatwm1.a(), this.jdField_a_of_type_AndroidGraphicsPoint) - TagCloudView.a(paramatwm2.a(), this.jdField_a_of_type_AndroidGraphicsPoint);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atwr
 * JD-Core Version:    0.7.0.1
 */