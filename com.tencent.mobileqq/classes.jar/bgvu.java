import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.upgrade.NewUpgradeDialog.YYBDownloadListener.1;
import com.tencent.mobileqq.upgrade.NewUpgradeDialog.YYBDownloadListener.2;
import com.tencent.mobileqq.upgrade.NewUpgradeDialog.YYBDownloadListener.3;
import com.tencent.mobileqq.upgrade.NewUpgradeDialog.YYBDownloadListener.4;
import com.tencent.mobileqq.upgrade.NewUpgradeDialog.YYBDownloadListener.5;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.open.downloadnew.DownloadListener;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;

public class bgvu
  implements DownloadListener
{
  private long a;
  private long b;
  
  protected bgvu(bgvp parambgvp) {}
  
  public void installSucceed(String paramString1, String paramString2)
  {
    long l;
    if ((paramString1.equals("1101070898")) && (paramString2.equals("com.tencent.android.qqdownloader")))
    {
      l = System.currentTimeMillis();
      if (l - this.b >= 1000L) {}
    }
    else
    {
      return;
    }
    this.b = l;
    bjko.b("NewUpgradeDialog", bjhp.a(10010, bgvp.a(), 3, 400));
    bjhn.a().a(22, bjhp.a(10010, bgvp.a(), 3, 400));
  }
  
  public void onDownloadCancel(DownloadInfo paramDownloadInfo)
  {
    bjko.c("NewUpgradeDialog", "onDownloadCancel");
  }
  
  public void onDownloadError(DownloadInfo paramDownloadInfo, int paramInt1, String paramString, int paramInt2)
  {
    if ((paramDownloadInfo != null) && (paramDownloadInfo.c.equals("1101070898")))
    {
      bjko.c("NewUpgradeDialog", "onDownloadError state = " + paramInt2);
      if ((paramDownloadInfo.f == 100) || (paramDownloadInfo.a() == 4)) {
        onDownloadFinish(paramDownloadInfo);
      }
    }
    else
    {
      return;
    }
    ThreadManager.getUIHandler().post(new NewUpgradeDialog.YYBDownloadListener.4(this, paramDownloadInfo));
  }
  
  public void onDownloadFinish(DownloadInfo paramDownloadInfo)
  {
    bjko.c("NewUpgradeDialog", "onDownloadFinish");
    long l;
    if ((paramDownloadInfo != null) && (paramDownloadInfo.c.equals("1101070898")))
    {
      l = System.currentTimeMillis();
      if (l - this.jdField_a_of_type_Long >= 1000L) {}
    }
    else
    {
      return;
    }
    this.jdField_a_of_type_Long = l;
    bjko.b("NewUpgradeDialog", bjhp.a(10010, bgvp.a(), 3, 700));
    bjhn.a().a(20, bjhp.a(10010, bgvp.a(), 3, 700));
    ThreadManager.getUIHandler().post(new NewUpgradeDialog.YYBDownloadListener.2(this, paramDownloadInfo));
    if (bgvp.b(this.jdField_a_of_type_Bgvp))
    {
      bgvp.b(this.jdField_a_of_type_Bgvp);
      bjko.c("NewUpgradeDialog", anvx.a(2131707034));
      return;
    }
    bjko.c("NewUpgradeDialog", anvx.a(2131707042));
  }
  
  public void onDownloadPause(DownloadInfo paramDownloadInfo)
  {
    if ((paramDownloadInfo != null) && (paramDownloadInfo.c.equals("1101070898")))
    {
      bjko.c("NewUpgradeDialog", "onDownloadPause");
      bjko.b("NewUpgradeDialog", bjhp.a(10010, bgvp.a(), 3, 600));
      bjhn.a().a(19, bjhp.a(10010, bgvp.a(), 3, 600));
      ThreadManager.getUIHandler().post(new NewUpgradeDialog.YYBDownloadListener.1(this, paramDownloadInfo));
    }
  }
  
  public void onDownloadUpdate(List<DownloadInfo> paramList)
  {
    bjko.c("NewUpgradeDialog", "onDownloadUpdate");
    if (paramList != null)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        DownloadInfo localDownloadInfo = (DownloadInfo)paramList.next();
        if (localDownloadInfo.c.equals("1101070898"))
        {
          bjko.c("NewUpgradeDialog", "onDownloadUpdate STATE = " + localDownloadInfo.a());
          ThreadManager.getUIHandler().post(new NewUpgradeDialog.YYBDownloadListener.3(this, localDownloadInfo));
        }
      }
    }
  }
  
  public void onDownloadWait(DownloadInfo paramDownloadInfo)
  {
    if ((paramDownloadInfo != null) && (paramDownloadInfo.c.equals("1101070898"))) {
      bjko.c("NewUpgradeDialog", "onDownloadWait");
    }
  }
  
  public void packageReplaced(String paramString1, String paramString2) {}
  
  public void uninstallSucceed(String paramString1, String paramString2)
  {
    if ((paramString1.equals("1101070898")) && (paramString2.equals("com.tencent.android.qqdownloader")))
    {
      bgvp.a(this.jdField_a_of_type_Bgvp, new bgvu(this.jdField_a_of_type_Bgvp));
      ThreadManager.getUIHandler().post(new NewUpgradeDialog.YYBDownloadListener.5(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgvu
 * JD-Core Version:    0.7.0.1
 */