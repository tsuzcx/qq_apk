import android.annotation.SuppressLint;
import android.text.TextUtils;
import com.tencent.qqmini.sdk.log.QMLog;
import com.tencent.qqmini.sdk.manager.InstalledEngine;
import com.tencent.qqmini.sdk.utils.DebugUtil;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

@SuppressLint({"WrongConstant"})
public class bhdy
{
  private static volatile bhdy jdField_a_of_type_Bhdy;
  public static final String[] a;
  private int jdField_a_of_type_Int = 3;
  private InstalledEngine jdField_a_of_type_ComTencentQqminiSdkManagerInstalledEngine;
  private boolean jdField_a_of_type_Boolean;
  
  static
  {
    jdField_a_of_type_ArrayOfJavaLangString = new String[] { "native_lame_mp3", "c++_shared", "saturn", "traeimp-rtmp", "txffmpeg", "liteavsdk" };
  }
  
  public bhdy()
  {
    Iterator localIterator = bgrt.a(this.jdField_a_of_type_Int).iterator();
    while (localIterator.hasNext())
    {
      InstalledEngine localInstalledEngine = (InstalledEngine)localIterator.next();
      if (localInstalledEngine.jdField_a_of_type_Boolean) {
        this.jdField_a_of_type_ComTencentQqminiSdkManagerInstalledEngine = localInstalledEngine;
      }
    }
  }
  
  public static bhdy a()
  {
    if (jdField_a_of_type_Bhdy == null) {}
    try
    {
      if (jdField_a_of_type_Bhdy == null) {
        jdField_a_of_type_Bhdy = new bhdy();
      }
      return jdField_a_of_type_Bhdy;
    }
    finally {}
  }
  
  private String a(InstalledEngine paramInstalledEngine)
  {
    if ((paramInstalledEngine != null) && (paramInstalledEngine.jdField_a_of_type_Boolean)) {
      return paramInstalledEngine.jdField_b_of_type_JavaLangString;
    }
    return null;
  }
  
  public boolean a()
  {
    return a("native_lame_mp3");
  }
  
  protected boolean a(String paramString)
  {
    if ((this.jdField_a_of_type_ComTencentQqminiSdkManagerInstalledEngine == null) || (TextUtils.isEmpty(paramString))) {
      QMLog.e("MiniAppSoLoader", "[MiniEng]load so " + paramString + " from " + this.jdField_a_of_type_ComTencentQqminiSdkManagerInstalledEngine);
    }
    String str2;
    String str1;
    do
    {
      return false;
      str2 = a(this.jdField_a_of_type_ComTencentQqminiSdkManagerInstalledEngine);
      str1 = str2 + File.separator + "lib" + paramString + ".so";
      QMLog.i("MiniAppSoLoader", "[MiniEng]load so " + paramString + " from " + str1);
    } while (TextUtils.isEmpty(str2));
    try
    {
      System.load(str1);
      if (this.jdField_a_of_type_ComTencentQqminiSdkManagerInstalledEngine.jdField_b_of_type_Int == 1) {
        this.jdField_a_of_type_ComTencentQqminiSdkManagerInstalledEngine.jdField_b_of_type_Int = 3;
      }
      QMLog.i("MiniAppSoLoader", "[MiniEng] load " + str1 + " success.");
      return true;
    }
    catch (Throwable paramString)
    {
      QMLog.e("MiniAppSoLoader", "[MiniEng] load " + str1 + " fail: " + DebugUtil.getPrintableStackTrace(paramString), paramString);
      this.jdField_a_of_type_ComTencentQqminiSdkManagerInstalledEngine.jdField_b_of_type_Int = 2;
    }
    return false;
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_Boolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bhdy
 * JD-Core Version:    0.7.0.1
 */