import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import com.tencent.open.downloadnew.DownloadInfo;
import java.util.Iterator;
import java.util.List;

public class bfgw
  implements bfka
{
  protected static bfgw a;
  protected bfgv a;
  
  public static bfgw a()
  {
    try
    {
      if (jdField_a_of_type_Bfgw == null) {
        jdField_a_of_type_Bfgw = new bfgw();
      }
      bfgw localbfgw = jdField_a_of_type_Bfgw;
      return localbfgw;
    }
    finally {}
  }
  
  public void a(Looper paramLooper)
  {
    this.jdField_a_of_type_Bfgv = new bfgv(paramLooper);
  }
  
  protected void a(Message paramMessage)
  {
    if (this.jdField_a_of_type_Bfgv == null) {
      this.jdField_a_of_type_Bfgv = new bfgv();
    }
    this.jdField_a_of_type_Bfgv.sendMessage(paramMessage);
  }
  
  public void installSucceed(String paramString1, String paramString2)
  {
    bfhg.a("NoticeListener", "onInstallSucceed ,appId" + paramString1);
    paramString1 = bfkb.a().b(paramString2);
    if (paramString1 != null)
    {
      paramString2 = this.jdField_a_of_type_Bfgv.obtainMessage();
      paramString2.what = 6;
      Bundle localBundle = new Bundle();
      localBundle.putString(bfjy.a, paramString1.jdField_b_of_type_JavaLangString);
      paramString2.setData(localBundle);
      a(paramString2);
    }
  }
  
  public void onDownloadCancel(DownloadInfo paramDownloadInfo) {}
  
  public void onDownloadError(DownloadInfo paramDownloadInfo, int paramInt1, String paramString, int paramInt2)
  {
    bfhg.a("NoticeListener", "onDownloadError ,downloadInfo" + paramDownloadInfo);
    if ((paramDownloadInfo == null) || (paramDownloadInfo.jdField_c_of_type_Int == 1)) {}
    while (paramDownloadInfo.jdField_b_of_type_Boolean) {
      return;
    }
    Message localMessage = this.jdField_a_of_type_Bfgv.obtainMessage();
    localMessage.what = -2;
    Bundle localBundle = new Bundle();
    localBundle.putString(bfjy.a, paramDownloadInfo.jdField_b_of_type_JavaLangString);
    localMessage.setData(localBundle);
    localMessage.obj = paramString;
    localMessage.arg2 = paramInt2;
    a(localMessage);
  }
  
  public void onDownloadFinish(DownloadInfo paramDownloadInfo)
  {
    bfhg.a("NoticeListener", "onDownloadFinish ");
    if ((paramDownloadInfo == null) || (paramDownloadInfo.jdField_c_of_type_Int == 1)) {}
    while (paramDownloadInfo.jdField_b_of_type_Boolean) {
      return;
    }
    Message localMessage = this.jdField_a_of_type_Bfgv.obtainMessage();
    localMessage.what = 4;
    Bundle localBundle = new Bundle();
    localBundle.putString(bfjy.a, paramDownloadInfo.jdField_b_of_type_JavaLangString);
    localMessage.setData(localBundle);
    a(localMessage);
  }
  
  public void onDownloadPause(DownloadInfo paramDownloadInfo)
  {
    if (paramDownloadInfo == null) {}
    do
    {
      return;
      bfhg.a("NoticeListener", "onDownloadPause " + paramDownloadInfo.jdField_c_of_type_JavaLangString);
    } while ((paramDownloadInfo.jdField_c_of_type_Int == 1) || (paramDownloadInfo.jdField_b_of_type_Boolean));
    Message localMessage = this.jdField_a_of_type_Bfgv.obtainMessage();
    localMessage.what = 3;
    Bundle localBundle = new Bundle();
    localBundle.putString(bfjy.a, paramDownloadInfo.jdField_b_of_type_JavaLangString);
    localMessage.setData(localBundle);
    a(localMessage);
  }
  
  public void onDownloadUpdate(List<DownloadInfo> paramList)
  {
    bfhg.a("NoticeListener", "onDownloadUpdate notify enter infos=" + paramList.size());
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
      Message localMessage = this.jdField_a_of_type_Bfgv.obtainMessage();
      localMessage.what = 2;
      Bundle localBundle = new Bundle();
      localBundle.putString(bfjy.a, localDownloadInfo.jdField_b_of_type_JavaLangString);
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
    bfhg.a("NoticeListener", "onDownloadWait notify enter info.id=" + paramDownloadInfo.jdField_c_of_type_JavaLangString);
    Message localMessage = this.jdField_a_of_type_Bfgv.obtainMessage();
    localMessage.what = 20;
    Bundle localBundle = new Bundle();
    localBundle.putString(bfjy.a, paramDownloadInfo.jdField_b_of_type_JavaLangString);
    localMessage.setData(localBundle);
    a(localMessage);
  }
  
  public void packageReplaced(String paramString1, String paramString2) {}
  
  public void uninstallSucceed(String paramString1, String paramString2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bfgw
 * JD-Core Version:    0.7.0.1
 */