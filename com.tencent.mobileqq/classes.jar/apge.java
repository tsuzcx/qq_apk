import android.content.Intent;
import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.mobileqq.filemanager.widget.SendBottomBar;
import java.util.ArrayList;

class apge
  implements apca
{
  apge(apgd paramapgd) {}
  
  public void a()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.addAll(aonm.a());
    Intent localIntent = new Intent();
    localIntent.putParcelableArrayListExtra("sFilesSelected", localArrayList);
    SendBottomBar.a(this.a.a).setResult(-1, localIntent);
    SendBottomBar.a(this.a.a).finish();
  }
  
  public void b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     apge
 * JD-Core Version:    0.7.0.1
 */