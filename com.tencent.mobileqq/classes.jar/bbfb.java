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

public class bbfb
  implements bdko
{
  private long a;
  private long b;
  
  protected bbfb(bbew parambbew) {}
  
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
    bdht.b("NewUpgradeDialog", bdeu.a(10010, bbew.a(), 3, 400));
    bdes.a().a(22, bdeu.a(10010, bbew.a(), 3, 400));
  }
  
  public void onDownloadCancel(DownloadInfo paramDownloadInfo)
  {
    bdht.c("NewUpgradeDialog", "onDownloadCancel");
  }
  
  public void onDownloadError(DownloadInfo paramDownloadInfo, int paramInt1, String paramString, int paramInt2)
  {
    if ((paramDownloadInfo != null) && (paramDownloadInfo.c.equals("1101070898")))
    {
      bdht.c("NewUpgradeDialog", "onDownloadError state = " + paramInt2);
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
    bdht.c("NewUpgradeDialog", "onDownloadFinish");
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
    bdht.b("NewUpgradeDialog", bdeu.a(10010, bbew.a(), 3, 700));
    bdes.a().a(20, bdeu.a(10010, bbew.a(), 3, 700));
    ThreadManager.getUIHandler().post(new NewUpgradeDialog.YYBDownloadListener.2(this, paramDownloadInfo));
    if (bbew.b(this.jdField_a_of_type_Bbew))
    {
      bbew.b(this.jdField_a_of_type_Bbew);
      bdht.c("NewUpgradeDialog", ajyc.a(2131707573));
      return;
    }
    bdht.c("NewUpgradeDialog", ajyc.a(2131707581));
  }
  
  public void onDownloadPause(DownloadInfo paramDownloadInfo)
  {
    if ((paramDownloadInfo != null) && (paramDownloadInfo.c.equals("1101070898")))
    {
      bdht.c("NewUpgradeDialog", "onDownloadPause");
      bdht.b("NewUpgradeDialog", bdeu.a(10010, bbew.a(), 3, 600));
      bdes.a().a(19, bdeu.a(10010, bbew.a(), 3, 600));
      ThreadManager.getUIHandler().post(new NewUpgradeDialog.YYBDownloadListener.1(this, paramDownloadInfo));
    }
  }
  
  public void onDownloadUpdate(List<DownloadInfo> paramList)
  {
    bdht.c("NewUpgradeDialog", "onDownloadUpdate");
    if (paramList != null)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        DownloadInfo localDownloadInfo = (DownloadInfo)paramList.next();
        if (localDownloadInfo.c.equals("1101070898"))
        {
          bdht.c("NewUpgradeDialog", "onDownloadUpdate STATE = " + localDownloadInfo.a());
          ThreadManager.getUIHandler().post(new NewUpgradeDialog.YYBDownloadListener.3(this, localDownloadInfo));
        }
      }
    }
  }
  
  public void onDownloadWait(DownloadInfo paramDownloadInfo)
  {
    if ((paramDownloadInfo != null) && (paramDownloadInfo.c.equals("1101070898"))) {
      bdht.c("NewUpgradeDialog", "onDownloadWait");
    }
  }
  
  public void packageReplaced(String paramString1, String paramString2) {}
  
  public void uninstallSucceed(String paramString1, String paramString2)
  {
    if ((paramString1.equals("1101070898")) && (paramString2.equals("com.tencent.android.qqdownloader")))
    {
      bbew.a(this.jdField_a_of_type_Bbew, new bbfb(this.jdField_a_of_type_Bbew));
      ThreadManager.getUIHandler().post(new NewUpgradeDialog.YYBDownloadListener.5(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbfb
 * JD-Core Version:    0.7.0.1
 */