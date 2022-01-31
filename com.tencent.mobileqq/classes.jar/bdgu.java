import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import com.tencent.open.appcommon.now.download.local.DownloadNativeApi.1;
import com.tencent.open.downloadnew.DownloadInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class bdgu
{
  private static bdgu jdField_a_of_type_Bdgu;
  private bdgt jdField_a_of_type_Bdgt = new bdgt();
  
  public static bdgu a()
  {
    if (jdField_a_of_type_Bdgu == null) {
      jdField_a_of_type_Bdgu = new bdgu();
    }
    return jdField_a_of_type_Bdgu;
  }
  
  private DownloadInfo a(bdgz parambdgz)
  {
    DownloadInfo localDownloadInfo = new DownloadInfo(parambdgz.jdField_a_of_type_JavaLangString, parambdgz.jdField_b_of_type_JavaLangString);
    localDownloadInfo.jdField_d_of_type_JavaLangString = parambdgz.jdField_d_of_type_JavaLangString;
    localDownloadInfo.jdField_b_of_type_Int = parambdgz.jdField_a_of_type_Int;
    localDownloadInfo.jdField_b_of_type_Boolean = parambdgz.jdField_d_of_type_Boolean;
    localDownloadInfo.jdField_a_of_type_Boolean = parambdgz.e;
    localDownloadInfo.f = parambdgz.jdField_c_of_type_JavaLangString;
    localDownloadInfo.jdField_a_of_type_Int = parambdgz.jdField_c_of_type_Int;
    localDownloadInfo.jdField_c_of_type_Int = parambdgz.jdField_b_of_type_Int;
    localDownloadInfo.jdField_d_of_type_Int = 0;
    localDownloadInfo.jdField_c_of_type_Boolean = true;
    return localDownloadInfo;
  }
  
  private boolean a()
  {
    return "com.tencent.mobileqq:tool".equals(bdfn.r());
  }
  
  public int a(Activity paramActivity, bdgz parambdgz)
  {
    if (!a()) {
      return 401;
    }
    if (parambdgz == null) {
      return 400;
    }
    if ((parambdgz.jdField_a_of_type_Boolean) && (!"com.tencent.now".equals(parambdgz.jdField_c_of_type_JavaLangString))) {
      return 402;
    }
    DownloadInfo localDownloadInfo = a(parambdgz);
    localDownloadInfo.g = 2;
    localDownloadInfo.jdField_c_of_type_Boolean = true;
    if ((naj.a() != 1) && (paramActivity != null) && (parambdgz.f)) {
      a(paramActivity, localDownloadInfo, parambdgz);
    }
    for (;;)
    {
      return 200;
      bdgk.a().a(localDownloadInfo);
      this.jdField_a_of_type_Bdgt.a(parambdgz);
    }
  }
  
  public int a(bdgz parambdgz)
  {
    int j = -1;
    int i;
    if (!a()) {
      i = 401;
    }
    int k;
    do
    {
      do
      {
        return i;
        i = j;
      } while (parambdgz == null);
      parambdgz = a(parambdgz);
      parambdgz.g = 13;
      parambdgz.jdField_c_of_type_Int = 0;
      k = bdgk.a().a(parambdgz);
      if (k == 1) {
        return 1;
      }
      i = j;
    } while (k != 0);
    return 0;
  }
  
  public int a(String paramString)
  {
    if (!a()) {
      return 401;
    }
    this.jdField_a_of_type_Bdgt.a(paramString);
    bdgk.a().a(paramString);
    return 200;
  }
  
  public int a(String paramString1, String paramString2)
  {
    if (!a()) {
      return 401;
    }
    bdgk.a().a(paramString1, paramString2);
    return 200;
  }
  
  public int a(List<bdgz> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      return 400;
    }
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      DownloadInfo localDownloadInfo = a((bdgz)paramList.next());
      localDownloadInfo.jdField_c_of_type_Int = 0;
      localArrayList.add(localDownloadInfo);
    }
    if (bdgk.a().a(localArrayList) != 0) {
      return 400;
    }
    return 200;
  }
  
  public void a(Activity paramActivity, DownloadInfo paramDownloadInfo, bdgz parambdgz)
  {
    new Handler(Looper.getMainLooper()).post(new DownloadNativeApi.1(this, paramDownloadInfo, parambdgz, paramActivity));
  }
  
  public void a(bdgx parambdgx)
  {
    this.jdField_a_of_type_Bdgt.a(parambdgx);
    bdgk.a().a(this.jdField_a_of_type_Bdgt);
  }
  
  public boolean a(String paramString)
  {
    return bdjl.a(paramString);
  }
  
  public void b(bdgx parambdgx)
  {
    this.jdField_a_of_type_Bdgt.a();
    this.jdField_a_of_type_Bdgt.b(parambdgx);
    bdgk.a().b(this.jdField_a_of_type_Bdgt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bdgu
 * JD-Core Version:    0.7.0.1
 */