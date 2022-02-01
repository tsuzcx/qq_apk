import com.tencent.mobileqq.mini.entry.MiniAppPrePullManager.IPrePullListener;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QzoneIPCModule;
import org.json.JSONObject;

public class bmuz
  implements MiniAppPrePullManager.IPrePullListener
{
  public bmuz(QzoneIPCModule paramQzoneIPCModule) {}
  
  public void onPrePullCallback(boolean paramBoolean, JSONObject paramJSONObject)
  {
    QLog.d("QzoneIPCModule", 4, String.format("after preload For QQ MINI Program %b", new Object[] { Boolean.valueOf(paramBoolean) }));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmuz
 * JD-Core Version:    0.7.0.1
 */