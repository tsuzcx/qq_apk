import android.graphics.Point;
import com.tencent.mobileqq.profile.PersonalityLabel.tagCloud.TagCloudView;
import java.util.Comparator;

public class azey
  implements Comparator<azet>
{
  Point jdField_a_of_type_AndroidGraphicsPoint;
  
  public azey(TagCloudView paramTagCloudView, Point paramPoint)
  {
    this.jdField_a_of_type_AndroidGraphicsPoint = paramPoint;
  }
  
  public int a(azet paramazet1, azet paramazet2)
  {
    return TagCloudView.a(paramazet1.a(), this.jdField_a_of_type_AndroidGraphicsPoint) - TagCloudView.a(paramazet2.a(), this.jdField_a_of_type_AndroidGraphicsPoint);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azey
 * JD-Core Version:    0.7.0.1
 */