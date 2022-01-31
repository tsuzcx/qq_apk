import android.graphics.Point;
import com.tencent.mobileqq.profile.PersonalityLabel.tagCloud.TagCloudView;
import java.util.Comparator;

public class awme
  implements Comparator<awlz>
{
  Point jdField_a_of_type_AndroidGraphicsPoint;
  
  public awme(TagCloudView paramTagCloudView, Point paramPoint)
  {
    this.jdField_a_of_type_AndroidGraphicsPoint = paramPoint;
  }
  
  public int a(awlz paramawlz1, awlz paramawlz2)
  {
    return TagCloudView.a(paramawlz1.a(), this.jdField_a_of_type_AndroidGraphicsPoint) - TagCloudView.a(paramawlz2.a(), this.jdField_a_of_type_AndroidGraphicsPoint);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     awme
 * JD-Core Version:    0.7.0.1
 */