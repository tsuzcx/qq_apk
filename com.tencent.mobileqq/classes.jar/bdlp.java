import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.upgrade.UpgradeDetailWrapper;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.open.downloadnew.MyAppApi.YYBDownloadListener.1;
import com.tencent.open.downloadnew.MyAppApi.YYBDownloadListener.2;
import com.tencent.tmassistantsdk.internal.openSDK.TMAssistantBaseCallYYB;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;

public class bdlp
  implements bdko
{
  protected bdlp(bdlc parambdlc) {}
  
  public void installSucceed(String paramString1, String paramString2)
  {
    if ((paramString1.equals("1101070898")) && (paramString2.equals("com.tencent.android.qqdownloader")))
    {
      if ((this.a.jdField_a_of_type_Bdlq != null) && (this.a.jdField_a_of_type_Bdlq.isShowing())) {
        this.a.jdField_a_of_type_Bdlq.dismiss();
      }
      bdkp.a().b(this.a.jdField_a_of_type_Bdlp);
      this.a.jdField_a_of_type_Bdlp = null;
    }
  }
  
  public void onDownloadCancel(DownloadInfo paramDownloadInfo)
  {
    if ((paramDownloadInfo != null) && (paramDownloadInfo.c.equals("1101070898")))
    {
      bdht.c("MyAppApi", "onDownloadCancel");
      if ((this.a.jdField_a_of_type_Bdlq != null) && (this.a.jdField_a_of_type_Bdlq.isShowing()) && (this.a.c)) {
        this.a.jdField_a_of_type_Bdlq.a(paramDownloadInfo.f, paramDownloadInfo.a());
      }
      bdkp.a().b(this.a.jdField_a_of_type_Bdlp);
      this.a.jdField_a_of_type_Bdlp = null;
    }
  }
  
  public void onDownloadError(DownloadInfo paramDownloadInfo, int paramInt1, String paramString, int paramInt2)
  {
    if ((paramDownloadInfo != null) && (paramDownloadInfo.c.equals("1101070898")))
    {
      bdht.c("MyAppApi", "onDownloadError");
      if ((paramDownloadInfo.f != 100) && (paramDownloadInfo.e != 4)) {
        break label46;
      }
      onDownloadFinish(paramDownloadInfo);
    }
    label46:
    while ((this.a.jdField_a_of_type_Bdlq == null) || (!this.a.jdField_a_of_type_Bdlq.isShowing()) || (!this.a.c)) {
      return;
    }
    this.a.jdField_a_of_type_Bdlq.a(paramDownloadInfo.f, paramDownloadInfo.a());
  }
  
  public void onDownloadFinish(DownloadInfo paramDownloadInfo)
  {
    label213:
    long l2;
    long l1;
    if ((paramDownloadInfo != null) && (paramDownloadInfo.c.equals("1101070898")))
    {
      if (!bdlc.a(this.a)) {
        break label384;
      }
      UpgradeDetailWrapper localUpgradeDetailWrapper = akva.a().a();
      if ((localUpgradeDetailWrapper != null) && (localUpgradeDetailWrapper.a != null))
      {
        bbiy.a(true);
        bbiy.a(localUpgradeDetailWrapper.a.jdField_a_of_type_Int);
        bbew.b();
        bdht.c("NewUpgradeDialog", "pre download success state saved!");
      }
      bdht.c("MyAppApi", "onDownloadFinish");
      if ((this.a.jdField_a_of_type_Bdlq != null) && (this.a.jdField_a_of_type_Bdlq.isShowing()) && (this.a.c)) {
        this.a.jdField_a_of_type_Bdlq.a(100, 4);
      }
      bdht.c("MyAppApi", "mInstallParam: " + this.a.jdField_a_of_type_Bdln);
      if (this.a.jdField_a_of_type_Bdln != null)
      {
        if (!this.a.jdField_a_of_type_Bdln.jdField_b_of_type_Boolean) {
          break label411;
        }
        ThreadManager.getSubThreadHandler().postDelayed(new MyAppApi.YYBDownloadListener.1(this, paramDownloadInfo), 500L);
        this.a.jdField_a_of_type_Boolean = true;
        this.a.jdField_b_of_type_Boolean = false;
        l2 = 0L;
        l1 = l2;
        switch (this.a.jdField_a_of_type_Bdln.jdField_a_of_type_Int)
        {
        case 1: 
        default: 
          l1 = this.a.a(this.a.jdField_a_of_type_Bdln.jdField_a_of_type_AndroidOsBundle, this.a.jdField_a_of_type_Bdln.jdField_a_of_type_Boolean, this.a.jdField_a_of_type_Bdln.jdField_b_of_type_Boolean);
        }
      }
    }
    for (;;)
    {
      this.a.jdField_a_of_type_Long = l1;
      this.a.jdField_b_of_type_Long = System.currentTimeMillis();
      bdkp.a().b(this.a.jdField_a_of_type_Bdlp);
      this.a.jdField_a_of_type_Bdlp = null;
      if (("ANDROID.QQ.YYBXZGAMECENTER".equals(paramDownloadInfo.h)) || ("ANDROID.QQ.NEWYYBXZGAMECENTER".equals(paramDownloadInfo.h))) {
        yod.a(null, "765", "205011", paramDownloadInfo.c, "76501", "1", "156");
      }
      return;
      label384:
      axqw.b(null, "dc00898", "", "", "0X8008F7E", "0X8008F7E", 0, 0, "", "", "", "");
      break;
      label411:
      if ((bdiw.a() != 1) || (!bdkh.c())) {
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
        bdht.e("MyAppApi", "CopyAndInstallTask->onPostExecute mLastAuthorizeParam = null");
        l1 = l2;
        continue;
        l1 = this.a.b(this.a.jdField_a_of_type_Bdln.jdField_a_of_type_AndroidOsBundle, this.a.jdField_a_of_type_Bdln.jdField_a_of_type_Boolean, this.a.jdField_a_of_type_Bdln.jdField_b_of_type_Boolean);
        continue;
        l1 = this.a.b(this.a.jdField_a_of_type_Bdln.jdField_a_of_type_AndroidOsBundle);
      }
    }
  }
  
  public void onDownloadPause(DownloadInfo paramDownloadInfo)
  {
    if ((paramDownloadInfo != null) && (paramDownloadInfo.c.equals("1101070898")))
    {
      bdht.c("MyAppApi", "onDownloadPause");
      if ((this.a.jdField_a_of_type_Bdlq != null) && (this.a.jdField_a_of_type_Bdlq.isShowing()) && (this.a.c)) {
        this.a.jdField_a_of_type_Bdlq.a(paramDownloadInfo.f, paramDownloadInfo.a());
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
          bdht.c("MyAppApi", "onDownloadUpdate STATE = " + localDownloadInfo.a());
          if ((this.a.jdField_a_of_type_Bdlq != null) && (this.a.jdField_a_of_type_Bdlq.isShowing()) && (this.a.c)) {
            this.a.jdField_a_of_type_Bdlq.a(localDownloadInfo.f, localDownloadInfo.a());
          }
        }
      }
    }
  }
  
  public void onDownloadWait(DownloadInfo paramDownloadInfo)
  {
    if ((paramDownloadInfo != null) && (paramDownloadInfo.c.equals("1101070898")))
    {
      bdht.c("MyAppApi", "onDownloadWait");
      if ((this.a.jdField_a_of_type_Bdlq != null) && (this.a.jdField_a_of_type_Bdlq.isShowing()) && (this.a.c)) {
        this.a.jdField_a_of_type_Bdlq.a(paramDownloadInfo.f, paramDownloadInfo.a());
      }
    }
  }
  
  public void packageReplaced(String paramString1, String paramString2) {}
  
  public void uninstallSucceed(String paramString1, String paramString2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bdlp
 * JD-Core Version:    0.7.0.1
 */