import android.graphics.Point;
import com.tencent.mobileqq.profile.PersonalityLabel.tagCloud.TagCloudView;
import java.util.Comparator;

public class azqv
  implements Comparator<azqq>
{
  Point jdField_a_of_type_AndroidGraphicsPoint;
  
  public azqv(TagCloudView paramTagCloudView, Point paramPoint)
  {
    this.jdField_a_of_type_AndroidGraphicsPoint = paramPoint;
  }
  
  public int a(azqq paramazqq1, azqq paramazqq2)
  {
    return TagCloudView.a(paramazqq1.a(), this.jdField_a_of_type_AndroidGraphicsPoint) - TagCloudView.a(paramazqq2.a(), this.jdField_a_of_type_AndroidGraphicsPoint);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azqv
 * JD-Core Version:    0.7.0.1
 */