import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.upgrade.UpgradeDetailWrapper;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.open.downloadnew.DownloadListener;
import com.tencent.open.downloadnew.MyAppApi.YYBDownloadListener.1;
import com.tencent.open.downloadnew.MyAppApi.YYBDownloadListener.2;
import com.tencent.tmassistantsdk.internal.openSDK.TMAssistantBaseCallYYB;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;

public class bjoa
  implements DownloadListener
{
  protected bjoa(bjnn parambjnn) {}
  
  public void installSucceed(String paramString1, String paramString2)
  {
    if ((paramString1.equals("1101070898")) && (paramString2.equals("com.tencent.android.qqdownloader")))
    {
      if ((this.a.jdField_a_of_type_Bjob != null) && (this.a.jdField_a_of_type_Bjob.isShowing())) {
        this.a.jdField_a_of_type_Bjob.dismiss();
      }
      bjna.a().b(this.a.jdField_a_of_type_Bjoa);
      this.a.jdField_a_of_type_Bjoa = null;
    }
  }
  
  public void onDownloadCancel(DownloadInfo paramDownloadInfo)
  {
    if ((paramDownloadInfo != null) && (paramDownloadInfo.c.equals("1101070898")))
    {
      bjko.c("MyAppApi", "onDownloadCancel");
      if ((this.a.jdField_a_of_type_Bjob != null) && (this.a.jdField_a_of_type_Bjob.isShowing()) && (this.a.c)) {
        this.a.jdField_a_of_type_Bjob.a(paramDownloadInfo.f, paramDownloadInfo.a());
      }
      bjna.a().b(this.a.jdField_a_of_type_Bjoa);
      this.a.jdField_a_of_type_Bjoa = null;
    }
  }
  
  public void onDownloadError(DownloadInfo paramDownloadInfo, int paramInt1, String paramString, int paramInt2)
  {
    if ((paramDownloadInfo != null) && (paramDownloadInfo.c.equals("1101070898")))
    {
      bjko.c("MyAppApi", "onDownloadError");
      if ((paramDownloadInfo.f != 100) && (paramDownloadInfo.e != 4)) {
        break label46;
      }
      onDownloadFinish(paramDownloadInfo);
    }
    label46:
    while ((this.a.jdField_a_of_type_Bjob == null) || (!this.a.jdField_a_of_type_Bjob.isShowing()) || (!this.a.c)) {
      return;
    }
    this.a.jdField_a_of_type_Bjob.a(paramDownloadInfo.f, paramDownloadInfo.a());
  }
  
  public void onDownloadFinish(DownloadInfo paramDownloadInfo)
  {
    label213:
    long l2;
    long l1;
    if ((paramDownloadInfo != null) && (paramDownloadInfo.c.equals("1101070898")))
    {
      if (!bjnn.a(this.a)) {
        break label384;
      }
      UpgradeDetailWrapper localUpgradeDetailWrapper = bgvx.a().a();
      if ((localUpgradeDetailWrapper != null) && (localUpgradeDetailWrapper.a != null))
      {
        bhhj.a(true);
        bhhj.a(localUpgradeDetailWrapper.a.jdField_a_of_type_Int);
        bgvp.b();
        bjko.c("NewUpgradeDialog", "pre download success state saved!");
      }
      bjko.c("MyAppApi", "onDownloadFinish");
      if ((this.a.jdField_a_of_type_Bjob != null) && (this.a.jdField_a_of_type_Bjob.isShowing()) && (this.a.c)) {
        this.a.jdField_a_of_type_Bjob.a(100, 4);
      }
      bjko.c("MyAppApi", "mInstallParam: " + this.a.jdField_a_of_type_Bjny);
      if (this.a.jdField_a_of_type_Bjny != null)
      {
        if (!this.a.jdField_a_of_type_Bjny.jdField_b_of_type_Boolean) {
          break label411;
        }
        ThreadManager.getSubThreadHandler().postDelayed(new MyAppApi.YYBDownloadListener.1(this, paramDownloadInfo), 500L);
        this.a.jdField_a_of_type_Boolean = true;
        this.a.jdField_b_of_type_Boolean = false;
        l2 = 0L;
        l1 = l2;
        switch (this.a.jdField_a_of_type_Bjny.jdField_a_of_type_Int)
        {
        case 1: 
        default: 
          l1 = this.a.a(this.a.jdField_a_of_type_Bjny.jdField_a_of_type_AndroidOsBundle, this.a.jdField_a_of_type_Bjny.jdField_a_of_type_Boolean, this.a.jdField_a_of_type_Bjny.jdField_b_of_type_Boolean);
        }
      }
    }
    for (;;)
    {
      this.a.jdField_a_of_type_Long = l1;
      this.a.jdField_b_of_type_Long = System.currentTimeMillis();
      bjna.a().b(this.a.jdField_a_of_type_Bjoa);
      this.a.jdField_a_of_type_Bjoa = null;
      if (("ANDROID.QQ.YYBXZGAMECENTER".equals(paramDownloadInfo.h)) || ("ANDROID.QQ.NEWYYBXZGAMECENTER".equals(paramDownloadInfo.h))) {
        abuf.a(null, "765", "205011", paramDownloadInfo.c, "76501", "1", "156");
      }
      return;
      label384:
      bdla.b(null, "dc00898", "", "", "0X8008F7E", "0X8008F7E", 0, 0, "", "", "", "");
      break;
      label411:
      if ((bjlo.a() != 1) || (!bjmt.c())) {
        break label213;
      }
      ThreadManager.getSubThreadHandler().postDelayed(new MyAppApi.YYBDownloadListener.2(this, paramDownloadInfo), 500L);
      this.a.jdField_a_of_type_Boolean = true;
      this.a.jdField_b_of_type_Boolean = false;
      break label213;
      this.a.e = true;
      if (this.a.jdField_a_of_type_ComTencentTmassistantsdkTMAssistantCallYYBParamStruct != null)
      {
        l1 = this.a.a().addDownloadTaskFromAuthorize(this.a.jdField_a_of_type_ComTencentTmassistantsdkTMAssistantCallYYBParamStruct, "2");
      }
      else
      {
        bjko.e("MyAppApi", "CopyAndInstallTask->onPostExecute mLastAuthorizeParam = null");
        l1 = l2;
        continue;
        l1 = this.a.b(this.a.jdField_a_of_type_Bjny.jdField_a_of_type_AndroidOsBundle, this.a.jdField_a_of_type_Bjny.jdField_a_of_type_Boolean, this.a.jdField_a_of_type_Bjny.jdField_b_of_type_Boolean);
        continue;
        l1 = this.a.b(this.a.jdField_a_of_type_Bjny.jdField_a_of_type_AndroidOsBundle);
      }
    }
  }
  
  public void onDownloadPause(DownloadInfo paramDownloadInfo)
  {
    if ((paramDownloadInfo != null) && (paramDownloadInfo.c.equals("1101070898")))
    {
      bjko.c("MyAppApi", "onDownloadPause");
      if ((this.a.jdField_a_of_type_Bjob != null) && (this.a.jdField_a_of_type_Bjob.isShowing()) && (this.a.c)) {
        this.a.jdField_a_of_type_Bjob.a(paramDownloadInfo.f, paramDownloadInfo.a());
      }
    }
  }
  
  public void onDownloadUpdate(List<DownloadInfo> paramList)
  {
    if (paramList != null)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        DownloadInfo localDownloadInfo = (DownloadInfo)paramList.next();
        if (localDownloadInfo.c.equals("1101070898"))
        {
          bjko.c("MyAppApi", "onDownloadUpdate STATE = " + localDownloadInfo.a());
          if ((this.a.jdField_a_of_type_Bjob != null) && (this.a.jdField_a_of_type_Bjob.isShowing()) && (this.a.c)) {
            this.a.jdField_a_of_type_Bjob.a(localDownloadInfo.f, localDownloadInfo.a());
          }
        }
      }
    }
  }
  
  public void onDownloadWait(DownloadInfo paramDownloadInfo)
  {
    if ((paramDownloadInfo != null) && (paramDownloadInfo.c.equals("1101070898")))
    {
      bjko.c("MyAppApi", "onDownloadWait");
      if ((this.a.jdField_a_of_type_Bjob != null) && (this.a.jdField_a_of_type_Bjob.isShowing()) && (this.a.c)) {
        this.a.jdField_a_of_type_Bjob.a(paramDownloadInfo.f, paramDownloadInfo.a());
      }
    }
  }
  
  public void packageReplaced(String paramString1, String paramString2) {}
  
  public void uninstallSucceed(String paramString1, String paramString2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bjoa
 * JD-Core Version:    0.7.0.1
 */