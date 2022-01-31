import android.content.Intent;
import android.os.AsyncTask;
import com.tencent.mm.vfs.VFSFile;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.widget.SendBottomBar;
import com.tencent.mobileqq.filemanager.widget.SendBottomBar.6;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.Set;

public class apyf
  extends AsyncTask<Object, Object, Integer>
{
  public apyf(SendBottomBar.6 param6) {}
  
  protected Integer a(Object... paramVarArgs)
  {
    paramVarArgs = apeh.a();
    Iterator localIterator = paramVarArgs.iterator();
    int i = 0;
    VFSFile localVFSFile;
    for (;;)
    {
      FileInfo localFileInfo;
      if (localIterator.hasNext())
      {
        localFileInfo = (FileInfo)localIterator.next();
        if (!localFileInfo.b()) {}
      }
      else
      {
        SendBottomBar.a(this.a.this$0).a(paramVarArgs);
        axty.a().a(true);
        return Integer.valueOf(i);
      }
      if (!SendBottomBar.a(this.a.this$0).a().a(localFileInfo.c())) {
        try
        {
          localVFSFile = new VFSFile(localFileInfo.c());
          if (!localVFSFile.exists()) {
            QLog.e("delDownloadFiles<FileAssistant>", 1, "local file can scan, is not existed? file:" + localFileInfo.c());
          }
        }
        catch (Exception localException)
        {
          QLog.e("delDownloadFiles<FileAssistant>", 1, "del file error:" + localException.toString());
        }
      }
    }
    for (;;)
    {
      break;
      localVFSFile.delete();
      SendBottomBar.a(this.a.this$0, SendBottomBar.a(this.a.this$0) + localException.a());
      i += 1;
    }
  }
  
  protected void a(Integer paramInteger)
  {
    super.onPostExecute(paramInteger);
    this.a.this$0.d();
    paramInteger = new Intent();
    paramInteger.putExtra("extra_delete_total_file_size", SendBottomBar.a(this.a.this$0));
    SendBottomBar.a(this.a.this$0).setResult(-1, paramInteger);
    apeh.b();
    this.a.this$0.a();
    SendBottomBar.a(this.a.this$0).n();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     apyf
 * JD-Core Version:    0.7.0.1
 */