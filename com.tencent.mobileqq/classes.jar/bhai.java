import com.tencent.mobileqq.mini.entry.MiniAppPrePullManager.IPrePullListener;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

class bhai
  implements MiniAppPrePullManager.IPrePullListener
{
  bhai(bhah parambhah) {}
  
  public void onPrePullCallback(boolean paramBoolean, JSONObject paramJSONObject)
  {
    QLog.d("QzoneIPCModule", 4, String.format("after preload For QQ MINI Program %b", new Object[] { Boolean.valueOf(paramBoolean) }));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bhai
 * JD-Core Version:    0.7.0.1
 */