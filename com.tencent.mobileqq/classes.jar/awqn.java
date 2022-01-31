import android.graphics.Point;
import com.tencent.mobileqq.profile.PersonalityLabel.tagCloud.TagCloudView;
import java.util.Comparator;

public class awqn
  implements Comparator<awqi>
{
  Point jdField_a_of_type_AndroidGraphicsPoint;
  
  public awqn(TagCloudView paramTagCloudView, Point paramPoint)
  {
    this.jdField_a_of_type_AndroidGraphicsPoint = paramPoint;
  }
  
  public int a(awqi paramawqi1, awqi paramawqi2)
  {
    return TagCloudView.a(paramawqi1.a(), this.jdField_a_of_type_AndroidGraphicsPoint) - TagCloudView.a(paramawqi2.a(), this.jdField_a_of_type_AndroidGraphicsPoint);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     awqn
 * JD-Core Version:    0.7.0.1
 */