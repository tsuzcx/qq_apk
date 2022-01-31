import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import com.tencent.open.downloadnew.DownloadInfo;
import java.util.Iterator;
import java.util.List;

public class bdhy
  implements bdld
{
  protected static bdhy a;
  protected bdhx a;
  
  public static bdhy a()
  {
    try
    {
      if (jdField_a_of_type_Bdhy == null) {
        jdField_a_of_type_Bdhy = new bdhy();
      }
      bdhy localbdhy = jdField_a_of_type_Bdhy;
      return localbdhy;
    }
    finally {}
  }
  
  public void a(Looper paramLooper)
  {
    this.jdField_a_of_type_Bdhx = new bdhx(paramLooper);
  }
  
  protected void a(Message paramMessage)
  {
    if (this.jdField_a_of_type_Bdhx == null) {
      this.jdField_a_of_type_Bdhx = new bdhx();
    }
    this.jdField_a_of_type_Bdhx.sendMessage(paramMessage);
  }
  
  public void installSucceed(String paramString1, String paramString2)
  {
    bdii.a("NoticeListener", "onInstallSucceed ,appId" + paramString1);
    paramString1 = bdle.a().b(paramString2);
    if (paramString1 != null)
    {
      paramString2 = this.jdField_a_of_type_Bdhx.obtainMessage();
      paramString2.what = 6;
      Bundle localBundle = new Bundle();
      localBundle.putString(bdlb.a, paramString1.jdField_b_of_type_JavaLangString);
      paramString2.setData(localBundle);
      a(paramString2);
    }
  }
  
  public void onDownloadCancel(DownloadInfo paramDownloadInfo) {}
  
  public void onDownloadError(DownloadInfo paramDownloadInfo, int paramInt1, String paramString, int paramInt2)
  {
    bdii.a("NoticeListener", "onDownloadError ,downloadInfo" + paramDownloadInfo);
    if ((paramDownloadInfo == null) || (paramDownloadInfo.jdField_c_of_type_Int == 1)) {}
    while (paramDownloadInfo.jdField_b_of_type_Boolean) {
      return;
    }
    Message localMessage = this.jdField_a_of_type_Bdhx.obtainMessage();
    localMessage.what = -2;
    Bundle localBundle = new Bundle();
    localBundle.putString(bdlb.a, paramDownloadInfo.jdField_b_of_type_JavaLangString);
    localMessage.setData(localBundle);
    localMessage.obj = paramString;
    localMessage.arg2 = paramInt2;
    a(localMessage);
  }
  
  public void onDownloadFinish(DownloadInfo paramDownloadInfo)
  {
    bdii.a("NoticeListener", "onDownloadFinish ");
    if ((paramDownloadInfo == null) || (paramDownloadInfo.jdField_c_of_type_Int == 1)) {}
    while (paramDownloadInfo.jdField_b_of_type_Boolean) {
      return;
    }
    Message localMessage = this.jdField_a_of_type_Bdhx.obtainMessage();
    localMessage.what = 4;
    Bundle localBundle = new Bundle();
    localBundle.putString(bdlb.a, paramDownloadInfo.jdField_b_of_type_JavaLangString);
    localMessage.setData(localBundle);
    a(localMessage);
  }
  
  public void onDownloadPause(DownloadInfo paramDownloadInfo)
  {
    if (paramDownloadInfo == null) {}
    do
    {
      return;
      bdii.a("NoticeListener", "onDownloadPause " + paramDownloadInfo.jdField_c_of_type_JavaLangString);
    } while ((paramDownloadInfo.jdField_c_of_type_Int == 1) || (paramDownloadInfo.jdField_b_of_type_Boolean));
    Message localMessage = this.jdField_a_of_type_Bdhx.obtainMessage();
    localMessage.what = 3;
    Bundle localBundle = new Bundle();
    localBundle.putString(bdlb.a, paramDownloadInfo.jdField_b_of_type_JavaLangString);
    localMessage.setData(localBundle);
    a(localMessage);
  }
  
  public void onDownloadUpdate(List<DownloadInfo> paramList)
  {
    bdii.a("NoticeListener", "onDownloadUpdate notify enter infos=" + paramList.size());
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
        if (!localDownloadInfo.jdField_b_of_type_Boolean) {}
      }
      else
      {
        return;
      }
      Message localMessage = this.jdField_a_of_type_Bdhx.obtainMessage();
      localMessage.what = 2;
      Bundle localBundle = new Bundle();
      localBundle.putString(bdlb.a, localDownloadInfo.jdField_b_of_type_JavaLangString);
      localMessage.setData(localBundle);
      a(localMessage);
    }
  }
  
  public void onDownloadWait(DownloadInfo paramDownloadInfo)
  {
    if ((paramDownloadInfo == null) || (paramDownloadInfo.jdField_c_of_type_Int == 1)) {}
    while (paramDownloadInfo.jdField_b_of_type_Boolean) {
      return;
    }
    bdii.a("NoticeListener", "onDownloadWait notify enter info.id=" + paramDownloadInfo.jdField_c_of_type_JavaLangString);
    Message localMessage = this.jdField_a_of_type_Bdhx.obtainMessage();
    localMessage.what = 20;
    Bundle localBundle = new Bundle();
    localBundle.putString(bdlb.a, paramDownloadInfo.jdField_b_of_type_JavaLangString);
    localMessage.setData(localBundle);
    a(localMessage);
  }
  
  public void packageReplaced(String paramString1, String paramString2) {}
  
  public void uninstallSucceed(String paramString1, String paramString2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bdhy
 * JD-Core Version:    0.7.0.1
 */