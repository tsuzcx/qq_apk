import android.graphics.Point;
import com.tencent.mobileqq.profile.PersonalityLabel.tagCloud.TagCloudView;
import java.util.Comparator;

public class auuq
  implements Comparator<auul>
{
  Point jdField_a_of_type_AndroidGraphicsPoint;
  
  public auuq(TagCloudView paramTagCloudView, Point paramPoint)
  {
    this.jdField_a_of_type_AndroidGraphicsPoint = paramPoint;
  }
  
  public int a(auul paramauul1, auul paramauul2)
  {
    return TagCloudView.a(paramauul1.a(), this.jdField_a_of_type_AndroidGraphicsPoint) - TagCloudView.a(paramauul2.a(), this.jdField_a_of_type_AndroidGraphicsPoint);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     auuq
 * JD-Core Version:    0.7.0.1
 */