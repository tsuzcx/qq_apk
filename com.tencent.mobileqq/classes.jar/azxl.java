import android.graphics.Point;
import com.tencent.mobileqq.profile.PersonalityLabel.tagCloud.TagCloudView;
import java.util.Comparator;

public class azxl
  implements Comparator<azxg>
{
  Point jdField_a_of_type_AndroidGraphicsPoint;
  
  public azxl(TagCloudView paramTagCloudView, Point paramPoint)
  {
    this.jdField_a_of_type_AndroidGraphicsPoint = paramPoint;
  }
  
  public int a(azxg paramazxg1, azxg paramazxg2)
  {
    return TagCloudView.a(paramazxg1.a(), this.jdField_a_of_type_AndroidGraphicsPoint) - TagCloudView.a(paramazxg2.a(), this.jdField_a_of_type_AndroidGraphicsPoint);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azxl
 * JD-Core Version:    0.7.0.1
 */