import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import com.tencent.open.appcommon.now.download.local.DownloadNativeApi.1;
import com.tencent.open.downloadnew.DownloadInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class bdgf
{
  private static bdgf jdField_a_of_type_Bdgf;
  private bdge jdField_a_of_type_Bdge = new bdge();
  
  public static bdgf a()
  {
    if (jdField_a_of_type_Bdgf == null) {
      jdField_a_of_type_Bdgf = new bdgf();
    }
    return jdField_a_of_type_Bdgf;
  }
  
  private DownloadInfo a(bdgk parambdgk)
  {
    DownloadInfo localDownloadInfo = new DownloadInfo(parambdgk.jdField_a_of_type_JavaLangString, parambdgk.jdField_b_of_type_JavaLangString);
    localDownloadInfo.jdField_d_of_type_JavaLangString = parambdgk.jdField_d_of_type_JavaLangString;
    localDownloadInfo.jdField_b_of_type_Int = parambdgk.jdField_a_of_type_Int;
    localDownloadInfo.jdField_b_of_type_Boolean = parambdgk.jdField_d_of_type_Boolean;
    localDownloadInfo.jdField_a_of_type_Boolean = parambdgk.e;
    localDownloadInfo.f = parambdgk.jdField_c_of_type_JavaLangString;
    localDownloadInfo.jdField_a_of_type_Int = parambdgk.jdField_c_of_type_Int;
    localDownloadInfo.jdField_c_of_type_Int = parambdgk.jdField_b_of_type_Int;
    localDownloadInfo.jdField_d_of_type_Int = 0;
    localDownloadInfo.jdField_c_of_type_Boolean = true;
    return localDownloadInfo;
  }
  
  private boolean a()
  {
    return "com.tencent.mobileqq:tool".equals(bdey.r());
  }
  
  public int a(Activity paramActivity, bdgk parambdgk)
  {
    if (!a()) {
      return 401;
    }
    if (parambdgk == null) {
      return 400;
    }
    if ((parambdgk.jdField_a_of_type_Boolean) && (!"com.tencent.now".equals(parambdgk.jdField_c_of_type_JavaLangString))) {
      return 402;
    }
    DownloadInfo localDownloadInfo = a(parambdgk);
    localDownloadInfo.g = 2;
    localDownloadInfo.jdField_c_of_type_Boolean = true;
    if ((nam.a() != 1) && (paramActivity != null) && (parambdgk.f)) {
      a(paramActivity, localDownloadInfo, parambdgk);
    }
    for (;;)
    {
      return 200;
      bdfv.a().a(localDownloadInfo);
      this.jdField_a_of_type_Bdge.a(parambdgk);
    }
  }
  
  public int a(bdgk parambdgk)
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
      } while (parambdgk == null);
      parambdgk = a(parambdgk);
      parambdgk.g = 13;
      parambdgk.jdField_c_of_type_Int = 0;
      k = bdfv.a().a(parambdgk);
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
    this.jdField_a_of_type_Bdge.a(paramString);
    bdfv.a().a(paramString);
    return 200;
  }
  
  public int a(String paramString1, String paramString2)
  {
    if (!a()) {
      return 401;
    }
    bdfv.a().a(paramString1, paramString2);
    return 200;
  }
  
  public int a(List<bdgk> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      return 400;
    }
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      DownloadInfo localDownloadInfo = a((bdgk)paramList.next());
      localDownloadInfo.jdField_c_of_type_Int = 0;
      localArrayList.add(localDownloadInfo);
    }
    if (bdfv.a().a(localArrayList) != 0) {
      return 400;
    }
    return 200;
  }
  
  public void a(Activity paramActivity, DownloadInfo paramDownloadInfo, bdgk parambdgk)
  {
    new Handler(Looper.getMainLooper()).post(new DownloadNativeApi.1(this, paramDownloadInfo, parambdgk, paramActivity));
  }
  
  public void a(bdgi parambdgi)
  {
    this.jdField_a_of_type_Bdge.a(parambdgi);
    bdfv.a().a(this.jdField_a_of_type_Bdge);
  }
  
  public boolean a(String paramString)
  {
    return bdiw.a(paramString);
  }
  
  public void b(bdgi parambdgi)
  {
    this.jdField_a_of_type_Bdge.a();
    this.jdField_a_of_type_Bdge.b(parambdgi);
    bdfv.a().b(this.jdField_a_of_type_Bdge);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bdgf
 * JD-Core Version:    0.7.0.1
 */