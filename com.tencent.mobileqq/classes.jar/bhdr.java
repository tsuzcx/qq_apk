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

public class bhdr
  implements DownloadListener
{
  private long a;
  private long b;
  
  protected bhdr(bhdm parambhdm) {}
  
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
    bjtx.b("NewUpgradeDialog", bjqy.a(10010, bhdm.a(), 3, 400));
    bjqw.a().a(22, bjqy.a(10010, bhdm.a(), 3, 400));
  }
  
  public void onDownloadCancel(DownloadInfo paramDownloadInfo)
  {
    bjtx.c("NewUpgradeDialog", "onDownloadCancel");
  }
  
  public void onDownloadError(DownloadInfo paramDownloadInfo, int paramInt1, String paramString, int paramInt2)
  {
    if ((paramDownloadInfo != null) && (paramDownloadInfo.c.equals("1101070898")))
    {
      bjtx.c("NewUpgradeDialog", "onDownloadError state = " + paramInt2);
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
    bjtx.c("NewUpgradeDialog", "onDownloadFinish");
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
    bjtx.b("NewUpgradeDialog", bjqy.a(10010, bhdm.a(), 3, 700));
    bjqw.a().a(20, bjqy.a(10010, bhdm.a(), 3, 700));
    ThreadManager.getUIHandler().post(new NewUpgradeDialog.YYBDownloadListener.2(this, paramDownloadInfo));
    if (bhdm.b(this.jdField_a_of_type_Bhdm))
    {
      bhdm.b(this.jdField_a_of_type_Bhdm);
      bjtx.c("NewUpgradeDialog", anzj.a(2131706452));
      return;
    }
    bjtx.c("NewUpgradeDialog", anzj.a(2131706460));
  }
  
  public void onDownloadPause(DownloadInfo paramDownloadInfo)
  {
    if ((paramDownloadInfo != null) && (paramDownloadInfo.c.equals("1101070898")))
    {
      bjtx.c("NewUpgradeDialog", "onDownloadPause");
      bjtx.b("NewUpgradeDialog", bjqy.a(10010, bhdm.a(), 3, 600));
      bjqw.a().a(19, bjqy.a(10010, bhdm.a(), 3, 600));
      ThreadManager.getUIHandler().post(new NewUpgradeDialog.YYBDownloadListener.1(this, paramDownloadInfo));
    }
  }
  
  public void onDownloadUpdate(List<DownloadInfo> paramList)
  {
    bjtx.c("NewUpgradeDialog", "onDownloadUpdate");
    if (paramList != null)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        DownloadInfo localDownloadInfo = (DownloadInfo)paramList.next();
        if (localDownloadInfo.c.equals("1101070898"))
        {
          bjtx.c("NewUpgradeDialog", "onDownloadUpdate STATE = " + localDownloadInfo.a());
          ThreadManager.getUIHandler().post(new NewUpgradeDialog.YYBDownloadListener.3(this, localDownloadInfo));
        }
      }
    }
  }
  
  public void onDownloadWait(DownloadInfo paramDownloadInfo)
  {
    if ((paramDownloadInfo != null) && (paramDownloadInfo.c.equals("1101070898"))) {
      bjtx.c("NewUpgradeDialog", "onDownloadWait");
    }
  }
  
  public void packageReplaced(String paramString1, String paramString2) {}
  
  public void uninstallSucceed(String paramString1, String paramString2)
  {
    if ((paramString1.equals("1101070898")) && (paramString2.equals("com.tencent.android.qqdownloader")))
    {
      bhdm.a(this.jdField_a_of_type_Bhdm, new bhdr(this.jdField_a_of_type_Bhdm));
      ThreadManager.getUIHandler().post(new NewUpgradeDialog.YYBDownloadListener.5(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhdr
 * JD-Core Version:    0.7.0.1
 */