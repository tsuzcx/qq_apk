import android.graphics.Point;
import com.tencent.mobileqq.profile.PersonalityLabel.tagCloud.TagCloudView;
import java.util.Comparator;

public class auus
  implements Comparator<auun>
{
  Point jdField_a_of_type_AndroidGraphicsPoint;
  
  public auus(TagCloudView paramTagCloudView, Point paramPoint)
  {
    this.jdField_a_of_type_AndroidGraphicsPoint = paramPoint;
  }
  
  public int a(auun paramauun1, auun paramauun2)
  {
    return TagCloudView.a(paramauun1.a(), this.jdField_a_of_type_AndroidGraphicsPoint) - TagCloudView.a(paramauun2.a(), this.jdField_a_of_type_AndroidGraphicsPoint);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     auus
 * JD-Core Version:    0.7.0.1
 */