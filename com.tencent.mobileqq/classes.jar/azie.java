import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class azie
{
  public int a;
  public String a;
  public boolean a;
  public int b;
  public String b;
  public boolean b;
  public int c;
  public String c;
  public int d;
  public String d;
  public int e;
  public String e;
  public String f = "";
  public String g = "";
  public String h;
  public String i;
  public String j;
  public String k;
  public String l = "-1";
  
  public azie(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt1, String paramString5, int paramInt2, String paramString6, int paramInt3, String paramString7, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString8, int paramInt4, String paramString9, String paramString10, int paramInt5, String paramString11)
  {
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_c_of_type_JavaLangString = "";
    this.jdField_d_of_type_JavaLangString = "";
    this.jdField_a_of_type_Int = -1;
    this.jdField_e_of_type_JavaLangString = "";
    this.jdField_b_of_type_Int = -1;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_JavaLangString = paramString2;
    this.jdField_c_of_type_JavaLangString = paramString3;
    this.jdField_d_of_type_JavaLangString = paramString4;
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_e_of_type_JavaLangString = paramString5;
    this.jdField_b_of_type_Int = paramInt2;
    this.f = paramString6;
    this.jdField_c_of_type_Int = paramInt3;
    this.g = paramString7;
    this.jdField_a_of_type_Boolean = paramBoolean1;
    this.jdField_b_of_type_Boolean = paramBoolean3;
    this.h = paramString8;
    this.jdField_d_of_type_Int = paramInt4;
    this.j = paramString9;
    this.k = paramString10;
    this.jdField_e_of_type_Int = paramInt5;
    this.l = paramString11;
  }
  
  private boolean a(String paramString)
  {
    boolean bool = false;
    paramString = bkzh.a(BaseApplicationImpl.getContext(), this.jdField_a_of_type_JavaLangString).getString("splash_union_banner_res_path_" + paramString, "");
    if (!TextUtils.isEmpty(paramString)) {
      bool = a(paramString, false);
    }
    return bool;
  }
  
  public static boolean a(String paramString, boolean paramBoolean)
  {
    boolean bool2 = false;
    try
    {
      paramString = new File(paramString);
      boolean bool1 = bool2;
      if (paramString != null)
      {
        bool1 = bool2;
        if (paramString.exists())
        {
          if (paramBoolean)
          {
            paramBoolean = paramString.getAbsolutePath().endsWith(".splashtemp");
            if (!paramBoolean) {}
          }
          bool1 = true;
        }
      }
      return bool1;
    }
    catch (Exception paramString) {}
    return false;
  }
  
  public boolean a()
  {
    boolean bool2 = false;
    if ((this.jdField_b_of_type_Boolean) && (a(this.h, true))) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      if ((bool1) && (bkzh.a(this.l))) {
        if (!a(this.jdField_b_of_type_JavaLangString)) {
          bool1 = bool2;
        }
      }
      for (;;)
      {
        QLog.i("QSplash@QbossSplashUtil", 1, "adid [" + this.jdField_b_of_type_JavaLangString + "] shouldSplash " + bool1);
        return bool1;
        bkzh.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString);
      }
    }
  }
  
  public boolean b()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (!a(this.h, true))
    {
      bool1 = bool2;
      if (!this.jdField_a_of_type_Boolean)
      {
        bool1 = bool2;
        if (!azid.a(this.jdField_d_of_type_JavaLangString)) {
          bool1 = true;
        }
      }
    }
    QLog.i("QSplash@QbossSplashUtil", 1, "adid [" + this.jdField_b_of_type_JavaLangString + "] shouldRequestRes result = " + bool1);
    return bool1;
  }
  
  public String toString()
  {
    return "SplashADEntry{, mAdID='" + this.jdField_b_of_type_JavaLangString + '\'' + ", mBeginTime='" + this.jdField_c_of_type_JavaLangString + '\'' + ", mEndTime='" + this.jdField_d_of_type_JavaLangString + '\'' + ", mContentType=" + this.jdField_a_of_type_Int + ", mDownloadUrl='" + this.jdField_e_of_type_JavaLangString + '\'' + ", mJumpType=" + this.jdField_b_of_type_Int + ", mJumpH5Url='" + this.f + '\'' + ", mExposureUrl='" + this.g + '\'' + ", mResPath='" + this.h + '\'' + ", mVideoPath='" + this.i + '\'' + ", mShowpriority" + this.jdField_d_of_type_Int + '\'' + ", isLowerDeviceLimit=" + this.jdField_a_of_type_Boolean + '\'' + ", mCanShow=" + this.jdField_b_of_type_Boolean + '\'' + ", mResTraceinfo=" + this.j + '\'' + ", mResMD5=" + this.k + '\'' + ", mShowAdMark=" + this.jdField_e_of_type_Int + ", mBannerType=" + this.l + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     azie
 * JD-Core Version:    0.7.0.1
 */