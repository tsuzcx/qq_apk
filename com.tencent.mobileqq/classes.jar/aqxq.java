import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.earlydownload.xmldata.MiniScanDecodeSoData;
import com.tencent.mobileqq.earlydownload.xmldata.XmlData;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class aqxq
  extends aqxl
{
  private int a;
  private boolean d;
  
  public aqxq(QQAppInterface paramQQAppInterface)
  {
    super("qq.android.minidecode.so_v8.2.0", paramQQAppInterface);
  }
  
  public int a()
  {
    return 10083;
  }
  
  public Class<? extends XmlData> a()
  {
    return MiniScanDecodeSoData.class;
  }
  
  public String a()
  {
    return "MiniScanDecodeSoData";
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    super.a(paramLong1, paramLong2);
    this.a = ((int)(100L * paramLong1 / paramLong2));
    aoki.a(0, this.a);
    if (QLog.isColorLevel()) {
      QLog.d("MiniRecog.MiniScanDecodeSoDownloadHandler", 2, "download progress: " + this.a);
    }
  }
  
  public void a(XmlData paramXmlData, boolean paramBoolean, int paramInt, String paramString)
  {
    if (!paramBoolean)
    {
      g();
      f();
      aoki.a(0, false);
    }
    super.a(paramXmlData, paramBoolean, paramInt, paramString);
    if (QLog.isColorLevel()) {
      QLog.d("MiniRecog.MiniScanDecodeSoDownloadHandler", 2, "download finish: " + paramBoolean);
    }
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MiniRecog.MiniScanDecodeSoDownloadHandler", 2, "download success: " + paramString);
    }
    int i = aokk.a(paramString);
    if (QLog.isColorLevel()) {
      QLog.d("MiniRecog.MiniScanDecodeSoDownloadHandler", 2, "download success: " + paramString + ",ret = " + i);
    }
    if (i != 0)
    {
      g();
      f();
      aoki.a(0, false);
    }
    for (;;)
    {
      super.a(paramString);
      return;
      aoki.a(0, true);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    Object localObject = a();
    if ((paramBoolean) && ((localObject instanceof MiniScanDecodeSoData)))
    {
      localObject = (MiniScanDecodeSoData)localObject;
      if (QLog.isColorLevel()) {
        QLog.i("MiniRecog.MiniScanDecodeSoDownloadHandler", 2, String.format("restartDownload block_user_download=%b", new Object[] { Boolean.valueOf(((MiniScanDecodeSoData)localObject).block_user_download) }));
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
    QLog.d("MiniRecog.MiniScanDecodeSoDownloadHandler", 2, "restartDownload userClick=" + paramBoolean);
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
    boolean bool = FileUtil.deleteFile(new File(aokk.a()));
    if (QLog.isColorLevel()) {
      QLog.d("MiniRecog.MiniScanDecodeSoDownloadHandler", 2, "deleteUnZipFile ret: " + bool);
    }
  }
  
  public void b(XmlData paramXmlData)
  {
    super.b(paramXmlData);
    if (QLog.isColorLevel()) {
      QLog.d("MiniRecog.MiniScanDecodeSoDownloadHandler", 2, "download begin");
    }
  }
  
  public boolean b()
  {
    if (this.d)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MiniRecog.MiniScanDecodeSoDownloadHandler", 2, "isNetValid2Download by user ");
      }
      return true;
    }
    if (QLog.isColorLevel()) {
      QLog.d("MiniRecog.MiniScanDecodeSoDownloadHandler", 2, "isNetValid2Download by startup ");
    }
    return super.b();
  }
  
  public void e(boolean paramBoolean)
  {
    int i = 0;
    long l1 = aokn.a("report_tag_so_cover", 0L);
    long l2 = System.currentTimeMillis();
    String str;
    if (l2 - l1 > 86400000L)
    {
      str = "";
      XmlData localXmlData = a();
      if ((localXmlData == null) || (!(localXmlData instanceof MiniScanDecodeSoData))) {
        break label107;
      }
      i = ((MiniScanDecodeSoData)localXmlData).Version;
      str = aokk.c("minicode");
      if ((localXmlData.loadState != 1) || (i <= 0) || (TextUtils.isEmpty(str))) {
        break label102;
      }
      paramBoolean = true;
    }
    for (;;)
    {
      aokn.a(paramBoolean, i, str);
      aokn.a("report_tag_so_cover", l2);
      return;
      label102:
      paramBoolean = false;
      continue;
      label107:
      paramBoolean = false;
    }
  }
  
  public boolean e()
  {
    if (!this.d)
    {
      if (BaseActivity.mAppForground) {}
      for (boolean bool = false;; bool = true)
      {
        if (QLog.isColorLevel()) {
          QLog.d("MiniRecog.MiniScanDecodeSoDownloadHandler", 2, "downloadResource later " + bool);
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
    BaseApplicationImpl.sApplication.getSharedPreferences("mini_scan_sp", 4).edit().putInt("minidecode_so_version", b()).apply();
  }
  
  public void g()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MiniRecog.MiniScanDecodeSoDownloadHandler", 2, "restoreState");
    }
    a().loadState = 0;
    a().Version = 0;
    aqxb.a(a(), new String[0]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqxq
 * JD-Core Version:    0.7.0.1
 */