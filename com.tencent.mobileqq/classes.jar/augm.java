import android.content.Intent;
import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.mobileqq.filemanager.widget.SendBottomBar;
import java.util.ArrayList;

public class augm
  implements audq
{
  public augm(SendBottomBar paramSendBottomBar) {}
  
  public void onNo() {}
  
  public void onYes()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.addAll(atpm.a());
    Intent localIntent = new Intent();
    localIntent.putParcelableArrayListExtra("sFilesSelected", localArrayList);
    SendBottomBar.a(this.a).setResult(-1, localIntent);
    SendBottomBar.a(this.a).finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     augm
 * JD-Core Version:    0.7.0.1
 */