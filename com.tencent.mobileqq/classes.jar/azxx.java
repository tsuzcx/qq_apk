import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicLong;

public class azxx
  implements azyd
{
  private final SharedPreferences jdField_a_of_type_AndroidContentSharedPreferences;
  private final File jdField_a_of_type_JavaIoFile;
  private final String jdField_a_of_type_JavaLangString;
  private Future<File> jdField_a_of_type_JavaUtilConcurrentFuture;
  private final AtomicLong jdField_a_of_type_JavaUtilConcurrentAtomicAtomicLong = new AtomicLong(System.currentTimeMillis() - 180000L);
  private final boolean jdField_a_of_type_Boolean;
  private final File jdField_b_of_type_JavaIoFile;
  private final String jdField_b_of_type_JavaLangString;
  private final String c;
  private final String d;
  private final String e;
  
  public azxx(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    this.e = paramString3;
    this.jdField_a_of_type_AndroidContentSharedPreferences = paramContext.getSharedPreferences(String.format("%sShadowCdnPmUpdater", new Object[] { paramString1 }), 0);
    this.jdField_b_of_type_JavaIoFile = new File(new File(paramContext.getFilesDir(), "ShadowCdnPmUpdater"), paramString1);
    this.jdField_b_of_type_JavaIoFile.mkdirs();
    this.jdField_a_of_type_JavaIoFile = new File(this.jdField_b_of_type_JavaIoFile, paramString1 + this.e + "_pm.temp");
    this.jdField_b_of_type_JavaLangString = paramString1;
    this.c = ("pm_name_" + paramString1 + "_" + paramString2 + "_" + this.e);
    this.d = ("wasUpdate_" + paramString1 + "_" + this.e);
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_JavaLangString = "https://down.qq.com/innovate/qq/pm/release/StudyRoomPluginManager.apk";
    if (QLog.isColorLevel()) {
      QLog.i("studyroom.CdnPmUpdater", 2, "use cdnupdater url = " + this.jdField_a_of_type_JavaLangString);
    }
  }
  
  private void a(File paramFile)
  {
    this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putString(this.c, paramFile.getAbsolutePath()).apply();
  }
  
  @SuppressLint({"ApplySharedPref"})
  private void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putBoolean(this.d, paramBoolean).commit();
    if (QLog.isColorLevel()) {
      QLog.i("studyroom.CdnPmUpdater", 2, "setWasUpdating:" + paramBoolean);
    }
  }
  
  private boolean b()
  {
    boolean bool1 = true;
    boolean bool2 = true;
    File localFile = getLatest();
    if (localFile == null) {}
    for (;;)
    {
      return bool2;
      long l = System.currentTimeMillis() - this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicLong.get();
      if (l <= 180000L)
      {
        if (QLog.isColorLevel()) {
          QLog.i("studyroom.CdnPmUpdater", 2, "短时间内不重复检测interval==" + l);
        }
        return false;
      }
      try
      {
        localObject1 = new URL(this.jdField_a_of_type_JavaLangString).openConnection();
        if ((localObject1 instanceof HttpURLConnection)) {
          break label148;
        }
        throw new Error(this.jdField_a_of_type_JavaLangString + alpo.a(2131701842));
      }
      finally
      {
        localObject1 = null;
      }
      label135:
      if (localObject1 != null) {
        ((HttpURLConnection)localObject1).disconnect();
      }
      throw localObject2;
      label148:
      Object localObject1 = (HttpURLConnection)localObject1;
      try
      {
        if (((HttpURLConnection)localObject1).getResponseCode() != 200) {
          throw new Error(alpo.a(2131701844) + 200 + alpo.a(2131701845) + ((HttpURLConnection)localObject1).getResponseCode());
        }
        l = localObject2.length();
        int i = ((HttpURLConnection)localObject1).getContentLength();
        this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicLong.set(System.currentTimeMillis());
        if (l != i) {}
        for (;;)
        {
          bool2 = bool1;
          if (localObject1 == null) {
            break;
          }
          ((HttpURLConnection)localObject1).disconnect();
          return bool1;
          bool1 = false;
        }
        break label135;
      }
      finally {}
    }
  }
  
  private boolean c()
  {
    return this.jdField_a_of_type_AndroidContentSharedPreferences.getBoolean(this.d, false);
  }
  
  public File a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("studyroom.CdnPmUpdater", 2, "start download ");
    }
    File localFile = new File(this.jdField_b_of_type_JavaIoFile, this.jdField_b_of_type_JavaLangString + "_" + Long.valueOf(new StringBuilder().append(System.currentTimeMillis()).append("").toString(), 36) + ".apk");
    CountDownLatch localCountDownLatch = new CountDownLatch(1);
    Exception[] arrayOfException = new Exception[1];
    System.currentTimeMillis();
    azxn localazxn = new azxn();
    localazxn.a(BaseApplicationImpl.getContext());
    localazxn.a(this.jdField_a_of_type_JavaLangString, new azxz(this, localFile, arrayOfException, localCountDownLatch));
    localazxn.a(azxp.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_JavaIoFile.getAbsolutePath()));
    localCountDownLatch.await();
    if (arrayOfException[0] == null)
    {
      localFile.setLastModified(localFile.lastModified() + 1000L);
      a(localFile);
      return localFile;
    }
    throw arrayOfException[0];
  }
  
  public void a()
  {
    File localFile = getLatest();
    if (localFile != null) {
      localFile.delete();
    }
  }
  
  public boolean a()
  {
    return true;
  }
  
  public File getLatest()
  {
    Object localObject = this.jdField_a_of_type_AndroidContentSharedPreferences.getString(this.c, null);
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      localObject = new File((String)localObject);
      if (((File)localObject).exists()) {
        return localObject;
      }
    }
    return null;
  }
  
  public Future<Boolean> isAvailable(File paramFile)
  {
    throw new UnsupportedOperationException(alpo.a(2131701843));
  }
  
  public Future<File> update()
  {
    a(true);
    if (QLog.isColorLevel()) {
      QLog.i("studyroom.CdnPmUpdater", 2, "update");
    }
    if ((this.jdField_a_of_type_JavaUtilConcurrentFuture != null) && (!this.jdField_a_of_type_JavaUtilConcurrentFuture.isDone()))
    {
      if (QLog.isColorLevel()) {
        QLog.i("studyroom.CdnPmUpdater", 2, "上一次update还没结束，返回相同Future");
      }
      return this.jdField_a_of_type_JavaUtilConcurrentFuture;
    }
    this.jdField_a_of_type_JavaUtilConcurrentFuture = alza.a(192).submit(new azxy(this));
    return this.jdField_a_of_type_JavaUtilConcurrentFuture;
  }
  
  public boolean wasUpdating()
  {
    return c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azxx
 * JD-Core Version:    0.7.0.1
 */