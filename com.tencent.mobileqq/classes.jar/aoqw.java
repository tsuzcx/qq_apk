import android.os.Bundle;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.filemanager.fileviewer.FileBrowserActivity;
import com.tencent.mobileqq.filemanager.fileviewer.FileBrowserActivity.FileColorNoteCallback.1;
import com.tencent.mobileqq.filemanager.fileviewer.FileBrowserActivity.FileColorNoteCallback.2;
import com.tencent.mobileqq.filemanager.fileviewer.FileBrowserActivity.FileColorNoteCallback.3;
import mqq.os.MqqHandler;

public class aoqw
  extends alry
{
  private aoqw(FileBrowserActivity paramFileBrowserActivity) {}
  
  public void onAddColorNote(Bundle paramBundle, boolean paramBoolean)
  {
    if (paramBundle.getInt("color_note_curd_from_type") == 1) {
      awqx.b(null, "dc00898", "", "", "0X800A744", "0X800A744", apdq.c(FileBrowserActivity.a(this.a)), 0, "", "", "", "");
    }
    super.onAddColorNote(paramBundle, paramBoolean);
    ThreadManager.getUIHandler().post(new FileBrowserActivity.FileColorNoteCallback.1(this));
  }
  
  public void onDeleteColorNote(int paramInt, String paramString, boolean paramBoolean)
  {
    super.onDeleteColorNote(paramInt, paramString, paramBoolean);
    ThreadManager.getUIHandler().post(new FileBrowserActivity.FileColorNoteCallback.2(this));
  }
  
  public void onUpdateColorNoteState(int paramInt, String paramString, Bundle paramBundle)
  {
    super.onUpdateColorNoteState(paramInt, paramString, paramBundle);
    ThreadManager.getUIHandler().post(new FileBrowserActivity.FileColorNoteCallback.3(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aoqw
 * JD-Core Version:    0.7.0.1
 */