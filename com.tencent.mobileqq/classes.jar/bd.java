import android.os.Bundle;
import com.dataline.activities.LiteActivity;
import com.tencent.mobileqq.filemanager.util.FMDialogUtil.FMDialogInterface;
import java.util.ArrayList;

public class bd
  implements FMDialogUtil.FMDialogInterface
{
  public bd(LiteActivity paramLiteActivity, ArrayList paramArrayList1, ArrayList paramArrayList2) {}
  
  public void a()
  {
    Bundle localBundle;
    if (!this.jdField_a_of_type_JavaUtilArrayList.isEmpty())
    {
      localBundle = new Bundle();
      localBundle.putStringArrayList("PhotoConst.PHOTO_PATHS", this.jdField_a_of_type_JavaUtilArrayList);
      new bu(this.jdField_a_of_type_ComDatalineActivitiesLiteActivity).execute(new Bundle[] { localBundle });
    }
    if (!this.b.isEmpty())
    {
      localBundle = new Bundle();
      localBundle.putStringArrayList("PhotoConst.PHOTO_PATHS", this.b);
      new bv(this.jdField_a_of_type_ComDatalineActivitiesLiteActivity).execute(new Bundle[] { localBundle });
    }
  }
  
  public void b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bd
 * JD-Core Version:    0.7.0.1
 */