import android.content.Context;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.earlydownload.xmldata.QFlutterEngineData;
import com.tencent.mobileqq.earlydownload.xmldata.XmlData;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class auwt
  extends asdn
{
  private boolean d;
  
  public auwt(QQAppInterface paramQQAppInterface)
  {
    super("qq.android.flutter.engine.v8.3.9", paramQQAppInterface);
  }
  
  public static String e()
  {
    Object localObject = BaseApplicationImpl.sApplication.getFilesDir();
    if (localObject == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("QFlutter.QFlutterEngineDownloader", 2, "getFilesDir is null");
      }
      localObject = "";
    }
    String str;
    do
    {
      return localObject;
      str = localObject + "/pddata/prd/" + "qq.android.flutter.engine.v8.3.9";
      localObject = str;
    } while (!QLog.isColorLevel());
    QLog.i("QFlutter.QFlutterEngineDownloader", 2, "getLibDir ,path = " + str);
    return str;
  }
  
  public int a()
  {
    return 10092;
  }
  
  public Class<? extends XmlData> a()
  {
    return QFlutterEngineData.class;
  }
  
  public String a()
  {
    return QFlutterEngineData.class.getSimpleName();
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    super.a(paramLong1, paramLong2);
    int i = (int)(100L * paramLong1 / paramLong2);
    if (QLog.isColorLevel()) {
      QLog.d("QFlutter.QFlutterEngineDownloader", 2, "download progress: " + i);
    }
    auwu.a(0, paramLong1, paramLong2);
  }
  
  public void a(XmlData paramXmlData, boolean paramBoolean, int paramInt, String paramString)
  {
    super.a(paramXmlData, paramBoolean, paramInt, paramString);
    if (QLog.isColorLevel()) {
      QLog.d("QFlutter.QFlutterEngineDownloader", 2, String.format("onDownloadFinish, result: %s, errCode: %s, filepath: %s", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt), paramString }));
    }
    if (!paramBoolean) {
      auwu.a(0, false);
    }
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QFlutter.QFlutterEngineDownloader", 2, "download success: " + paramString);
    }
    if (auwu.a(paramString, (QFlutterEngineData)a())) {
      auwu.a(0, true);
    }
    for (;;)
    {
      super.a(paramString);
      return;
      f();
      auwu.a(0, false);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QFlutter.QFlutterEngineDownloader", 2, String.format("restartDownload userClick: %s", new Object[] { Boolean.valueOf(paramBoolean) }));
    }
    super.a(paramBoolean);
    if (!this.d) {
      this.d = paramBoolean;
    }
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
    String str = e();
    boolean bool = auog.a(new File(str));
    if (QLog.isColorLevel()) {
      QLog.d("QFlutter.QFlutterEngineDownloader", 2, String.format("delete unzipFile: %s, ret: %s", new Object[] { str, Boolean.valueOf(bool) }));
    }
  }
  
  public void b(XmlData paramXmlData)
  {
    super.b(paramXmlData);
    if (paramXmlData != null) {}
    for (long l = paramXmlData.totalSize;; l = 0L)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QFlutter.QFlutterEngineDownloader", 2, "download begin, totalLen: " + l);
      }
      return;
    }
  }
  
  public boolean b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QFlutter.QFlutterEngineDownloader", 2, String.format("isNetValid2Download mHadRequestedByUser: %s", new Object[] { Boolean.valueOf(this.d) }));
    }
    if (this.d) {
      return true;
    }
    return super.b();
  }
  
  public boolean e()
  {
    QLog.d("QFlutter.QFlutterEngineDownloader", 1, String.format("downloadResource, mHadRequestedByUser = %s", new Object[] { Boolean.valueOf(this.d) }));
    if (!this.d) {
      return false;
    }
    return super.e();
  }
  
  public void f()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QFlutter.QFlutterEngineDownloader", 2, "restoreState");
    }
    a().loadState = 0;
    a().Version = 0;
    asdd.a(a(), new String[0]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     auwt
 * JD-Core Version:    0.7.0.1
 */