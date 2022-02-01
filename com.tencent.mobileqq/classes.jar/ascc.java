import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.earlydownload.xmldata.MiniScanDecodeSoData;
import com.tencent.mobileqq.earlydownload.xmldata.MiniScanDetectSoData;
import com.tencent.mobileqq.earlydownload.xmldata.XmlData;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class ascc
  extends asbv
{
  private int a;
  private boolean d;
  
  public ascc(QQAppInterface paramQQAppInterface)
  {
    super("qq.android.minidetect.so_v8.2.0", paramQQAppInterface);
  }
  
  public int a()
  {
    return 10083;
  }
  
  public Class<? extends XmlData> a()
  {
    return MiniScanDetectSoData.class;
  }
  
  public String a()
  {
    return "MiniScanDetectSoData";
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    super.a(paramLong1, paramLong2);
    this.a = ((int)(100L * paramLong1 / paramLong2));
    apnj.a(1, this.a);
    if (QLog.isColorLevel()) {
      QLog.d("MiniRecog.MiniScanDetectSoDownloadHandler", 2, "download progress: " + this.a);
    }
  }
  
  public void a(XmlData paramXmlData, boolean paramBoolean, int paramInt, String paramString)
  {
    if (!paramBoolean)
    {
      g();
      f();
      apnj.a(1, false);
    }
    super.a(paramXmlData, paramBoolean, paramInt, paramString);
    if (QLog.isColorLevel()) {
      QLog.d("MiniRecog.MiniScanDetectSoDownloadHandler", 2, "download finish: " + paramBoolean);
    }
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MiniRecog.MiniScanDetectSoDownloadHandler", 2, "download success: " + paramString);
    }
    int i = apnn.a(paramString);
    if (QLog.isColorLevel()) {
      QLog.d("MiniRecog.MiniScanDetectSoDownloadHandler", 2, "download success: " + paramString + ",ret = " + i);
    }
    if (i != 0)
    {
      g();
      f();
      apnj.a(1, false);
    }
    for (;;)
    {
      super.a(paramString);
      return;
      apnj.a(1, true);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    Object localObject = a();
    if ((paramBoolean) && ((localObject instanceof MiniScanDecodeSoData)))
    {
      localObject = (MiniScanDecodeSoData)localObject;
      if (QLog.isColorLevel()) {
        QLog.i("MiniRecog.MiniScanDetectSoDownloadHandler", 2, String.format("restartDownload block_user_download=%b", new Object[] { Boolean.valueOf(((MiniScanDecodeSoData)localObject).block_user_download) }));
      }
      if (!((MiniScanDecodeSoData)localObject).block_user_download) {}
    }
    do
    {
      return;
      if (!this.d) {
        this.d = paramBoolean;
      }
      super.a(paramBoolean);
    } while (!QLog.isColorLevel());
    QLog.d("MiniRecog.MiniScanDetectSoDownloadHandler", 2, "restartDownload userClick=" + paramBoolean);
  }
  
  public boolean a()
  {
    return true;
  }
  
  public String b()
  {
    return "prd";
  }
  
  public void b()
  {
    boolean bool = FileUtil.deleteFile(new File(apnn.a()));
    if (QLog.isColorLevel()) {
      QLog.d("MiniRecog.MiniScanDetectSoDownloadHandler", 2, "deleteUnZipFile ret: " + bool);
    }
  }
  
  public void b(XmlData paramXmlData)
  {
    super.b(paramXmlData);
    if (QLog.isColorLevel()) {
      QLog.d("MiniRecog.MiniScanDetectSoDownloadHandler", 2, "download begin");
    }
  }
  
  public boolean b()
  {
    if (this.d)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MiniRecog.MiniScanDetectSoDownloadHandler", 2, "isNetValid2Download by user ");
      }
      return true;
    }
    if (QLog.isColorLevel()) {
      QLog.d("MiniRecog.MiniScanDetectSoDownloadHandler", 2, "isNetValid2Download by startup ");
    }
    return super.b();
  }
  
  public boolean e()
  {
    if (!this.d)
    {
      if (BaseActivity.mAppForground) {}
      for (boolean bool = false;; bool = true)
      {
        if (QLog.isColorLevel()) {
          QLog.d("MiniRecog.MiniScanDetectSoDownloadHandler", 2, "downloadResource later " + bool);
        }
        if (!bool) {
          break;
        }
        return false;
      }
    }
    return super.e();
  }
  
  public void f()
  {
    BaseApplicationImpl.sApplication.getSharedPreferences("mini_scan_sp", 4).edit().putInt("minidetect_so_version", b()).apply();
  }
  
  public void g()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MiniRecog.MiniScanDetectSoDownloadHandler", 2, "restoreState");
    }
    a().loadState = 0;
    a().Version = 0;
    asbl.a(a(), new String[0]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ascc
 * JD-Core Version:    0.7.0.1
 */