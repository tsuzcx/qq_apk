import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.open.downloadnew.DownloadListener;
import java.util.Iterator;
import java.util.List;

public class bjyh
  implements DownloadListener
{
  protected static bjyh a;
  protected bjyj a;
  
  public static bjyh a()
  {
    try
    {
      if (jdField_a_of_type_Bjyh == null) {
        jdField_a_of_type_Bjyh = new bjyh();
      }
      bjyh localbjyh = jdField_a_of_type_Bjyh;
      return localbjyh;
    }
    finally {}
  }
  
  public void a(Looper paramLooper)
  {
    this.jdField_a_of_type_Bjyj = new bjyj(paramLooper);
  }
  
  protected void a(Message paramMessage)
  {
    if (this.jdField_a_of_type_Bjyj == null) {
      this.jdField_a_of_type_Bjyj = new bjyj();
    }
    this.jdField_a_of_type_Bjyj.sendMessage(paramMessage);
  }
  
  public void installSucceed(String paramString1, String paramString2)
  {
    bjtx.a("NoticeDownloadListener", "onInstallSucceed ,appId" + paramString1);
    paramString1 = bjwq.a().b(paramString2);
    if (paramString1 != null)
    {
      paramString2 = this.jdField_a_of_type_Bjyj.obtainMessage();
      paramString2.what = 6;
      Bundle localBundle = new Bundle();
      localBundle.putString(bjwo.b, paramString1.jdField_c_of_type_JavaLangString);
      paramString2.setData(localBundle);
      a(paramString2);
    }
  }
  
  public void onDownloadCancel(DownloadInfo paramDownloadInfo) {}
  
  public void onDownloadError(DownloadInfo paramDownloadInfo, int paramInt1, String paramString, int paramInt2)
  {
    bjtx.a("NoticeDownloadListener", "onDownloadError ,downloadInfo" + paramDownloadInfo);
    if ((paramDownloadInfo == null) || (paramDownloadInfo.jdField_c_of_type_Int == 1)) {}
    while (paramDownloadInfo.b) {
      return;
    }
    Message localMessage = this.jdField_a_of_type_Bjyj.obtainMessage();
    localMessage.what = -2;
    Bundle localBundle = new Bundle();
    localBundle.putString("appId", paramDownloadInfo.jdField_c_of_type_JavaLangString);
    localMessage.setData(localBundle);
    localMessage.obj = paramString;
    localMessage.arg2 = paramInt2;
    a(localMessage);
  }
  
  public void onDownloadFinish(DownloadInfo paramDownloadInfo)
  {
    bjtx.a("NoticeDownloadListener", "onDownloadFinish ");
    if ((paramDownloadInfo == null) || (paramDownloadInfo.jdField_c_of_type_Int == 1)) {}
    while (paramDownloadInfo.b) {
      return;
    }
    Message localMessage = this.jdField_a_of_type_Bjyj.obtainMessage();
    localMessage.what = 4;
    Bundle localBundle = new Bundle();
    localBundle.putString("appId", paramDownloadInfo.jdField_c_of_type_JavaLangString);
    localMessage.setData(localBundle);
    a(localMessage);
  }
  
  public void onDownloadPause(DownloadInfo paramDownloadInfo)
  {
    if (paramDownloadInfo == null) {}
    do
    {
      return;
      bjtx.a("NoticeDownloadListener", "onDownloadPause " + paramDownloadInfo.jdField_c_of_type_JavaLangString);
    } while ((paramDownloadInfo.jdField_c_of_type_Int == 1) || (paramDownloadInfo.b));
    Message localMessage = this.jdField_a_of_type_Bjyj.obtainMessage();
    localMessage.what = 3;
    Bundle localBundle = new Bundle();
    localBundle.putString("appId", paramDownloadInfo.jdField_c_of_type_JavaLangString);
    localMessage.setData(localBundle);
    a(localMessage);
  }
  
  public void onDownloadUpdate(List<DownloadInfo> paramList)
  {
    bjtx.a("NoticeDownloadListener", "onDownloadUpdate notify enter infos=" + paramList.size());
    paramList = paramList.iterator();
    for (;;)
    {
      DownloadInfo localDownloadInfo;
      if (paramList.hasNext())
      {
        localDownloadInfo = (DownloadInfo)paramList.next();
        if ((localDownloadInfo == null) || (localDownloadInfo.jdField_c_of_type_Int == 1)) {
          continue;
        }
        if (!localDownloadInfo.b) {}
      }
      else
      {
        return;
      }
      Message localMessage = this.jdField_a_of_type_Bjyj.obtainMessage();
      localMessage.what = 2;
      Bundle localBundle = new Bundle();
      localBundle.putString("appId", localDownloadInfo.jdField_c_of_type_JavaLangString);
      localMessage.setData(localBundle);
      a(localMessage);
    }
  }
  
  public void onDownloadWait(DownloadInfo paramDownloadInfo)
  {
    if ((paramDownloadInfo == null) || (paramDownloadInfo.jdField_c_of_type_Int == 1)) {}
    while (paramDownloadInfo.b) {
      return;
    }
    Object localObject2 = new StringBuilder().append("onDownloadWait notify enter info.id=");
    if (paramDownloadInfo == null) {}
    for (Object localObject1 = "";; localObject1 = paramDownloadInfo.jdField_c_of_type_JavaLangString)
    {
      bjtx.a("NoticeDownloadListener", (String)localObject1);
      localObject1 = this.jdField_a_of_type_Bjyj.obtainMessage();
      ((Message)localObject1).what = 20;
      localObject2 = new Bundle();
      ((Bundle)localObject2).putString("appId", paramDownloadInfo.jdField_c_of_type_JavaLangString);
      ((Message)localObject1).setData((Bundle)localObject2);
      a((Message)localObject1);
      return;
    }
  }
  
  public void packageReplaced(String paramString1, String paramString2) {}
  
  public void uninstallSucceed(String paramString1, String paramString2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bjyh
 * JD-Core Version:    0.7.0.1
 */