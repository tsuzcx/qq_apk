import android.graphics.Point;
import com.tencent.mobileqq.profile.PersonalityLabel.tagCloud.TagCloudView;
import java.util.Comparator;

public class ayma
  implements Comparator<aylv>
{
  Point jdField_a_of_type_AndroidGraphicsPoint;
  
  public ayma(TagCloudView paramTagCloudView, Point paramPoint)
  {
    this.jdField_a_of_type_AndroidGraphicsPoint = paramPoint;
  }
  
  public int a(aylv paramaylv1, aylv paramaylv2)
  {
    return TagCloudView.a(paramaylv1.a(), this.jdField_a_of_type_AndroidGraphicsPoint) - TagCloudView.a(paramaylv2.a(), this.jdField_a_of_type_AndroidGraphicsPoint);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayma
 * JD-Core Version:    0.7.0.1
 */