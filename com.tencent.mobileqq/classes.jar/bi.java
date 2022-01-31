import android.os.Bundle;
import com.dataline.activities.LiteActivity;
import java.util.ArrayList;

public class bi
  implements army
{
  public bi(LiteActivity paramLiteActivity, ArrayList paramArrayList1, ArrayList paramArrayList2) {}
  
  public void a()
  {
    Bundle localBundle;
    if (!this.jdField_a_of_type_JavaUtilArrayList.isEmpty())
    {
      localBundle = new Bundle();
      localBundle.putStringArrayList("PhotoConst.PHOTO_PATHS", this.jdField_a_of_type_JavaUtilArrayList);
      new cd(this.jdField_a_of_type_ComDatalineActivitiesLiteActivity).execute(new Bundle[] { localBundle });
    }
    if (!this.b.isEmpty())
    {
      localBundle = new Bundle();
      localBundle.putStringArrayList("PhotoConst.PHOTO_PATHS", this.b);
      new ce(this.jdField_a_of_type_ComDatalineActivitiesLiteActivity).execute(new Bundle[] { localBundle });
    }
  }
  
  public void b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bi
 * JD-Core Version:    0.7.0.1
 */