import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.component.network.downloader.Downloader.DownloadListener;
import com.tencent.qphone.base.util.BaseApplication;
import common.config.service.QzoneConfig;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.networkedmodule.QzoneModuleManager;
import cooperation.qzone.util.QZLog;
import java.io.File;

public class bjpl
{
  private static bjpl jdField_a_of_type_Bjpl;
  public static File a;
  public static String a;
  public static String b;
  public static String c;
  public static String d;
  public static String e;
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long = QzoneConfig.getInstance().getConfig("PhotoUpload", "PhotoGuideCreateGifSoLength", 38400L);
  private bjby jdField_a_of_type_Bjby;
  public boolean[] a;
  private int jdField_b_of_type_Int = 2;
  private long jdField_b_of_type_Long = QzoneConfig.getInstance().getConfig("PhotoUpload", "PhotoGuideCreateGifSoLength64", 38672);
  private long c;
  private long d;
  private long e;
  private long jdField_f_of_type_Long = QzoneConfig.getInstance().getConfig("PhotoUpload", "PhotoGuideLibCShareSoLength64", 1058904);
  private String jdField_f_of_type_JavaLangString = QzoneConfig.getInstance().getConfig("PhotoUpload", "PhotoGuideCreateGifSo", "https://d3g.qq.com/sngapp/app/update/20181219175050_4961/libandroidndkgif.so");
  private long jdField_g_of_type_Long = QzoneConfig.getInstance().getConfig("PhotoUpload", "PhotoGuideQzoneVisionSoLength", 2422908);
  private String jdField_g_of_type_JavaLangString = QzoneConfig.getInstance().getConfig("PhotoUpload", "PhotoGuideCreateGifSoMD5", "16dd3ecb57fac1a97a60a9cf3891accb");
  private long jdField_h_of_type_Long = QzoneConfig.getInstance().getConfig("PhotoUpload", "PhotoGuideQzoneVisionSoLength64", 3755056);
  private String jdField_h_of_type_JavaLangString = QzoneConfig.getInstance().getConfig("PhotoUpload", "PhotoGuideCreateGifSo64", "https://d3g.qq.com/sngapp/app/update/20200214225316_4688/libandroidndkgif.so");
  private String i = QzoneConfig.getInstance().getConfig("PhotoUpload", "PhotoGuideCreateGifSoMD564", "01468c39f609eef93fcd9224dbe686d3");
  private String j = QzoneConfig.getInstance().getConfig("PhotoUpload", "PhotoGuideCreateBeautySo", "https://d3g.qq.com/sngapp/app/update/20180518104407_5319/libandroidndkbeauty.so");
  private String k = QzoneConfig.getInstance().getConfig("PhotoUpload", "PhotoGuideQzoneVisionSoMD5", "f428bc70e52b7eb3fba4327e123a779b");
  private String l = QzoneConfig.getInstance().getConfig("PhotoUpload", "PhotoGuideQzoneVisionSoMD5", "b186c1e0ee3995717d84fb682afcd7b5");
  private String m = QzoneConfig.getInstance().getConfig("PhotoUpload", "PhotoGuideLibCShareSoMD5", "f507c0f741a32f7a30fa162faa894ebc");
  private String n = QzoneConfig.getInstance().getConfig("PhotoUpload", "PhotoGuideLibCShareSoMD564", "a86a585f5560b0bff890a100fe32792b");
  private String o = QzoneConfig.getInstance().getConfig("PhotoUpload", "PhotoGuideCreateBeautySoMD5", "C6787CBD4DBC4331E8C443A27EFEA03B");
  private final String p = jdField_a_of_type_JavaIoFile.getPath() + "/photoqulatity";
  
  static
  {
    jdField_a_of_type_JavaLangString = "libandroidndkgif.so";
    jdField_b_of_type_JavaLangString = "libdehaze.so";
    jdField_c_of_type_JavaLangString = "libopencv_java3.so";
    jdField_d_of_type_JavaLangString = "libqzone_vision.so";
    jdField_e_of_type_JavaLangString = "libc++_shared.so";
    jdField_a_of_type_JavaIoFile = BaseApplicationImpl.getContext().getDir("qzonealbum", 0);
  }
  
  public bjpl()
  {
    this.jdField_a_of_type_ArrayOfBoolean = new boolean[] { 0, 0, 0 };
    this.jdField_c_of_type_Long = QzoneConfig.getInstance().getConfig("PhotoUpload", "PhotoGuideCreateBeautySoLength", 587284);
    this.jdField_d_of_type_Long = QzoneConfig.getInstance().getConfig("PhotoUpload", "PhotoGuideCreateOpenSoLength", 9161452);
    this.jdField_e_of_type_Long = QzoneConfig.getInstance().getConfig("PhotoUpload", "PhotoGuideLibCShareSoLength", 657000);
  }
  
  public static bjpl a()
  {
    try
    {
      if (jdField_a_of_type_Bjpl == null) {
        jdField_a_of_type_Bjpl = new bjpl();
      }
      bjpl localbjpl = jdField_a_of_type_Bjpl;
      return localbjpl;
    }
    finally {}
  }
  
  private boolean a(String paramString, long paramLong)
  {
    if (a(paramString) == 0L) {}
    while (a(paramString) == paramLong) {
      return true;
    }
    return false;
  }
  
  private static void b(File paramFile1, File paramFile2)
  {
    bjps.a(paramFile1, paramFile2);
  }
  
  public long a(String paramString)
  {
    if (jdField_a_of_type_JavaLangString.equals(paramString)) {
      return this.jdField_a_of_type_Long;
    }
    if (jdField_d_of_type_JavaLangString.equals(paramString)) {
      return this.jdField_g_of_type_Long;
    }
    if (jdField_e_of_type_JavaLangString.equals(paramString)) {
      return this.jdField_e_of_type_Long;
    }
    if (jdField_b_of_type_JavaLangString.equals(paramString)) {
      return this.jdField_c_of_type_Long;
    }
    if (jdField_c_of_type_JavaLangString.equals(paramString)) {
      return this.jdField_d_of_type_Long;
    }
    return 0L;
  }
  
  public String a(String paramString)
  {
    if (jdField_d_of_type_JavaLangString.equals(paramString)) {
      return this.k;
    }
    if (jdField_e_of_type_JavaLangString.equals(paramString)) {
      return this.m;
    }
    if (jdField_a_of_type_JavaLangString.equals(paramString)) {
      return this.jdField_g_of_type_JavaLangString;
    }
    if (jdField_b_of_type_JavaLangString.equals(paramString)) {
      return this.o;
    }
    return "";
  }
  
  public void a()
  {
    a(null);
  }
  
  public void a(Downloader.DownloadListener paramDownloadListener)
  {
    if (this.jdField_a_of_type_ArrayOfBoolean[this.jdField_a_of_type_Int] == 0)
    {
      this.jdField_a_of_type_ArrayOfBoolean[this.jdField_a_of_type_Int] = true;
      a(this.jdField_f_of_type_JavaLangString, jdField_a_of_type_JavaLangString, paramDownloadListener);
    }
    while (paramDownloadListener == null) {
      return;
    }
    paramDownloadListener.onDownloadCanceled("lib is downloading");
  }
  
  public void a(String paramString1, String paramString2, Downloader.DownloadListener paramDownloadListener)
  {
    if (this.jdField_a_of_type_Bjby == null) {
      this.jdField_a_of_type_Bjby = bjby.a();
    }
    boolean bool = LocalMultiProcConfig.getBool(paramString1, false);
    File localFile = new File(jdField_a_of_type_JavaIoFile.getAbsolutePath() + "/" + paramString2);
    if ((bool) && (localFile.exists()) && (a(paramString2, localFile.length())))
    {
      if (paramDownloadListener != null) {
        paramDownloadListener.onDownloadSucceed(null, null);
      }
      if (jdField_a_of_type_JavaLangString.equals(paramString2)) {
        this.jdField_a_of_type_ArrayOfBoolean[this.jdField_a_of_type_Int] = false;
      }
      return;
    }
    paramDownloadListener = new bjpm(this, paramString2, paramDownloadListener, paramString1);
    paramString2 = jdField_a_of_type_JavaIoFile.getAbsolutePath() + "/tmp" + paramString2;
    this.jdField_a_of_type_Bjby.a(paramString1, paramString2, paramDownloadListener);
  }
  
  public boolean a(String paramString, boolean paramBoolean)
  {
    File localFile = new File(b(paramString));
    if (!localFile.exists())
    {
      QZLog.e("AlbumLibDownloaderUtil", 1, new Object[] { "vertifySoIsOK. file not exists. libName=" + paramString });
      return false;
    }
    if (localFile.length() == a(paramString)) {
      if (paramBoolean)
      {
        String str1 = bfhi.a(b(paramString));
        String str2 = a(paramString);
        if ((!TextUtils.isEmpty(str2)) && (!TextUtils.isEmpty(str1)) && (str2.equalsIgnoreCase(str1)))
        {
          LocalMultiProcConfig.putBool(paramString, false);
          return true;
        }
        QZLog.e("AlbumLibDownloaderUtil", 1, new Object[] { "vertifySoIsOK. file md5 check failed. libName=" + paramString + " downloadMD5=" + str1 + " originalMD5=" + str2 });
      }
    }
    for (;;)
    {
      localFile.delete();
      return false;
      return true;
      QZLog.e("AlbumLibDownloaderUtil", 1, new Object[] { "vertifySoIsOK. file length check failed. libName=" + paramString + " file.length()=" + localFile.length() + " expect length=" + a(paramString) });
    }
  }
  
  public String b(String paramString)
  {
    return jdField_a_of_type_JavaIoFile.getAbsolutePath() + "/" + paramString;
  }
  
  public void b()
  {
    QzoneModuleManager.getInstance().downloadModule("pictureMarkerSo.zip", new bjpn(this));
  }
  
  public void b(Downloader.DownloadListener paramDownloadListener)
  {
    a(this.jdField_f_of_type_JavaLangString, jdField_a_of_type_JavaLangString, paramDownloadListener);
  }
  
  public void c()
  {
    QzoneModuleManager.getInstance().downloadModule("libandroidndkbeauty.so", new bjpo(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bjpl
 * JD-Core Version:    0.7.0.1
 */