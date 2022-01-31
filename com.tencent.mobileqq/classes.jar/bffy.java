import com.tencent.mobileqq.pluginsdk.OnPluginInstallListener.Stub;
import com.tencent.open.applist.QZoneAppListActivity;
import com.tencent.open.applist.QZoneAppListActivity.1.1;

public class bffy
  extends OnPluginInstallListener.Stub
{
  public bffy(QZoneAppListActivity paramQZoneAppListActivity) {}
  
  public void onInstallBegin(String paramString) {}
  
  public void onInstallDownloadProgress(String paramString, int paramInt1, int paramInt2)
  {
    this.a.a(paramInt1 / paramInt2 * 100);
  }
  
  public void onInstallError(String paramString, int paramInt)
  {
    this.a.runOnUiThread(new QZoneAppListActivity.1.1(this));
  }
  
  public void onInstallFinish(String paramString)
  {
    QZoneAppListActivity.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bffy
 * JD-Core Version:    0.7.0.1
 */