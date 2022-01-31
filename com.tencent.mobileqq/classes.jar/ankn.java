import android.os.Handler;
import android.os.Message;
import cooperation.qzone.webviewplugin.QzoneDynamicAlbumPlugin;
import java.util.ArrayList;
import java.util.List;

public class ankn
  extends Handler
{
  public ankn(QzoneDynamicAlbumPlugin paramQzoneDynamicAlbumPlugin) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      return;
    } while ((paramMessage.obj == null) || (!(paramMessage.obj instanceof String[])));
    ArrayList localArrayList = new ArrayList();
    String[] arrayOfString = (String[])paramMessage.obj;
    localArrayList.add(QzoneDynamicAlbumPlugin.a(this.a, arrayOfString));
    this.a.a(localArrayList, paramMessage.arg1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ankn
 * JD-Core Version:    0.7.0.1
 */