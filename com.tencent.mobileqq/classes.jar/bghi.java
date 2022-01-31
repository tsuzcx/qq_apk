import android.os.Bundle;
import android.os.SystemClock;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.vas.VasQuickUpdateManager;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCClient;
import java.io.File;

public class bghi
{
  public static long a;
  
  public static String a()
  {
    BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.getApplication();
    return new File(localBaseApplicationImpl.getFilesDir(), "comic_so").getAbsolutePath() + File.separator;
  }
  
  public static void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("VipComicSoHelper", 2, "initComicPlayerSoWithSubProcess");
    }
    Bundle localBundle = new Bundle();
    QIPCClientHelper.getInstance().getClient().callServer("QQComicIPCModule", "getPlayerSo", localBundle, null);
  }
  
  public static void a(QQAppInterface paramQQAppInterface)
  {
    if (AppSetting.b) {
      if (QLog.isColorLevel()) {
        QLog.w("VipComicSoHelper", 2, "download comic qgplayer, the apk is for cup 64, but not supported for now");
      }
    }
    do
    {
      return;
      if (!new File(a() + "libqgplayer_765.so").exists())
      {
        if (QLog.isColorLevel()) {
          QLog.d("VipComicSoHelper", 2, "initComicPlayerSo start download");
        }
        ((VasQuickUpdateManager)paramQQAppInterface.getManager(184)).downloadItem(1004L, VasQuickUpdateManager.SCID_COMIC_PLAYER_SO, "comic");
        try
        {
          a = SystemClock.elapsedRealtime();
          axpw.a(paramQQAppInterface, "sendtdbank|b_sng_qqvip_qqcomic|soDownload", "1|" + a + "|0", true);
          return;
        }
        catch (Throwable paramQQAppInterface)
        {
          paramQQAppInterface.printStackTrace();
          return;
        }
      }
    } while (!QLog.isColorLevel());
    QLog.d("VipComicSoHelper", 2, "initComicPlayerSo has exists");
  }
  
  public static void a(QQAppInterface paramQQAppInterface, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VipComicSoHelper", 2, "onSoDownloadCompleted");
    }
    if (bbkv.a(a() + "libQGamePlayer.zip", a(), "libqgplayer_765.so")) {
      if (QLog.isColorLevel()) {
        QLog.d("VipComicSoHelper", 2, "comic player unCompressSo success");
      }
    }
    for (;;)
    {
      try
      {
        long l1 = SystemClock.elapsedRealtime();
        long l2 = a;
        axpw.a(paramQQAppInterface, "sendtdbank|b_sng_qqvip_qqcomic|soDownload", "2|" + (l1 - l2) + "|" + paramInt, true);
        return;
      }
      catch (Throwable paramQQAppInterface)
      {
        paramQQAppInterface.printStackTrace();
      }
      if (QLog.isColorLevel()) {
        QLog.d("VipComicSoHelper", 2, "comic player unCompressSo failure");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bghi
 * JD-Core Version:    0.7.0.1
 */