import com.qflutter.log.qflutter_log.QflutterLogPlugin.Log;
import com.tencent.qqmini.sdk.log.QMLog;

class bhgs
  implements QflutterLogPlugin.Log
{
  bhgs(bhgo parambhgo) {}
  
  public void d(String paramString)
  {
    QMLog.d("miniapp-TISSUE", paramString);
  }
  
  public void e(String paramString)
  {
    QMLog.e("miniapp-TISSUE", paramString);
  }
  
  public int getLogLevel()
  {
    return 5;
  }
  
  public void i(String paramString)
  {
    QMLog.i("miniapp-TISSUE", paramString);
  }
  
  public void v(String paramString)
  {
    QMLog.d("miniapp-TISSUE", paramString);
  }
  
  public void w(String paramString)
  {
    QMLog.w("miniapp-TISSUE", paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bhgs
 * JD-Core Version:    0.7.0.1
 */