import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.NewUpgradeDialog.YYBDownloadListener.1;
import com.tencent.mobileqq.utils.NewUpgradeDialog.YYBDownloadListener.2;
import com.tencent.mobileqq.utils.NewUpgradeDialog.YYBDownloadListener.3;
import com.tencent.mobileqq.utils.NewUpgradeDialog.YYBDownloadListener.4;
import com.tencent.mobileqq.utils.NewUpgradeDialog.YYBDownloadListener.5;
import com.tencent.open.downloadnew.DownloadInfo;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;

public class bdek
  implements bfka
{
  private long a;
  private long b;
  
  protected bdek(bdef parambdef) {}
  
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
    bfhg.b("NewUpgradeDialog", bfeh.a(10010, bdef.a(), 3, 400));
    bfef.a().a(22, bfeh.a(10010, bdef.a(), 3, 400));
  }
  
  public void onDownloadCancel(DownloadInfo paramDownloadInfo)
  {
    bfhg.c("NewUpgradeDialog", "onDownloadCancel");
  }
  
  public void onDownloadError(DownloadInfo paramDownloadInfo, int paramInt1, String paramString, int paramInt2)
  {
    if ((paramDownloadInfo != null) && (paramDownloadInfo.c.equals("1101070898")))
    {
      bfhg.c("NewUpgradeDialog", "onDownloadError state = " + paramInt2);
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
    bfhg.c("NewUpgradeDialog", "onDownloadFinish");
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
    bfhg.b("NewUpgradeDialog", bfeh.a(10010, bdef.a(), 3, 700));
    bfef.a().a(20, bfeh.a(10010, bdef.a(), 3, 700));
    ThreadManager.getUIHandler().post(new NewUpgradeDialog.YYBDownloadListener.2(this, paramDownloadInfo));
    if (bdef.b(this.jdField_a_of_type_Bdef))
    {
      bdef.b(this.jdField_a_of_type_Bdef);
      bfhg.c("NewUpgradeDialog", alpo.a(2131707956));
      return;
    }
    bfhg.c("NewUpgradeDialog", alpo.a(2131707964));
  }
  
  public void onDownloadPause(DownloadInfo paramDownloadInfo)
  {
    if ((paramDownloadInfo != null) && (paramDownloadInfo.c.equals("1101070898")))
    {
      bfhg.c("NewUpgradeDialog", "onDownloadPause");
      bfhg.b("NewUpgradeDialog", bfeh.a(10010, bdef.a(), 3, 600));
      bfef.a().a(19, bfeh.a(10010, bdef.a(), 3, 600));
      ThreadManager.getUIHandler().post(new NewUpgradeDialog.YYBDownloadListener.1(this, paramDownloadInfo));
    }
  }
  
  public void onDownloadUpdate(List<DownloadInfo> paramList)
  {
    bfhg.c("NewUpgradeDialog", "onDownloadUpdate");
    if (paramList != null)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        DownloadInfo localDownloadInfo = (DownloadInfo)paramList.next();
        if (localDownloadInfo.c.equals("1101070898"))
        {
          bfhg.c("NewUpgradeDialog", "onDownloadUpdate STATE = " + localDownloadInfo.a());
          ThreadManager.getUIHandler().post(new NewUpgradeDialog.YYBDownloadListener.3(this, localDownloadInfo));
        }
      }
    }
  }
  
  public void onDownloadWait(DownloadInfo paramDownloadInfo)
  {
    if ((paramDownloadInfo != null) && (paramDownloadInfo.c.equals("1101070898"))) {
      bfhg.c("NewUpgradeDialog", "onDownloadWait");
    }
  }
  
  public void packageReplaced(String paramString1, String paramString2) {}
  
  public void uninstallSucceed(String paramString1, String paramString2)
  {
    if ((paramString1.equals("1101070898")) && (paramString2.equals("com.tencent.android.qqdownloader")))
    {
      bdef.a(this.jdField_a_of_type_Bdef, new bdek(this.jdField_a_of_type_Bdef));
      ThreadManager.getUIHandler().post(new NewUpgradeDialog.YYBDownloadListener.5(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdek
 * JD-Core Version:    0.7.0.1
 */