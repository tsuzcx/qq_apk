import com.tencent.mobileqq.mini.entry.MiniAppPrePullManager.IPrePullListener;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

class bjbl
  implements MiniAppPrePullManager.IPrePullListener
{
  bjbl(bjbk parambjbk) {}
  
  public void onPrePullCallback(boolean paramBoolean, JSONObject paramJSONObject)
  {
    QLog.d("QzoneIPCModule", 4, String.format("after preload For QQ MINI Program %b", new Object[] { Boolean.valueOf(paramBoolean) }));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bjbl
 * JD-Core Version:    0.7.0.1
 */