import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import com.tencent.open.appcommon.now.download.local.DownloadNativeApi.1;
import com.tencent.open.downloadnew.DownloadInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class birk
{
  private static birk jdField_a_of_type_Birk;
  private birj jdField_a_of_type_Birj = new birj();
  
  public static birk a()
  {
    if (jdField_a_of_type_Birk == null) {
      jdField_a_of_type_Birk = new birk();
    }
    return jdField_a_of_type_Birk;
  }
  
  private DownloadInfo a(birp parambirp)
  {
    DownloadInfo localDownloadInfo = new DownloadInfo(parambirp.jdField_a_of_type_JavaLangString, parambirp.jdField_b_of_type_JavaLangString);
    localDownloadInfo.jdField_d_of_type_JavaLangString = parambirp.jdField_d_of_type_JavaLangString;
    localDownloadInfo.jdField_b_of_type_Int = parambirp.jdField_a_of_type_Int;
    localDownloadInfo.jdField_b_of_type_Boolean = parambirp.jdField_d_of_type_Boolean;
    localDownloadInfo.jdField_a_of_type_Boolean = parambirp.e;
    localDownloadInfo.f = parambirp.jdField_c_of_type_JavaLangString;
    localDownloadInfo.jdField_a_of_type_Int = parambirp.jdField_c_of_type_Int;
    localDownloadInfo.jdField_c_of_type_Int = parambirp.jdField_b_of_type_Int;
    localDownloadInfo.jdField_d_of_type_Int = 0;
    localDownloadInfo.jdField_c_of_type_Boolean = true;
    return localDownloadInfo;
  }
  
  private boolean a()
  {
    return "com.tencent.mobileqq:tool".equals(biqd.r());
  }
  
  public int a(Activity paramActivity, birp parambirp)
  {
    if (!a()) {
      return 401;
    }
    if (parambirp == null) {
      return 400;
    }
    if ((parambirp.jdField_a_of_type_Boolean) && (!"com.tencent.now".equals(parambirp.jdField_c_of_type_JavaLangString))) {
      return 402;
    }
    DownloadInfo localDownloadInfo = a(parambirp);
    localDownloadInfo.g = 2;
    localDownloadInfo.jdField_c_of_type_Boolean = true;
    if ((nlw.a() != 1) && (paramActivity != null) && (parambirp.f)) {
      a(paramActivity, localDownloadInfo, parambirp);
    }
    for (;;)
    {
      return 200;
      bira.a().a(localDownloadInfo);
      this.jdField_a_of_type_Birj.a(parambirp);
    }
  }
  
  public int a(birp parambirp)
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
      } while (parambirp == null);
      parambirp = a(parambirp);
      parambirp.g = 13;
      parambirp.jdField_c_of_type_Int = 0;
      k = bira.a().a(parambirp);
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
    this.jdField_a_of_type_Birj.a(paramString);
    bira.a().a(paramString);
    return 200;
  }
  
  public int a(String paramString1, String paramString2)
  {
    if (!a()) {
      return 401;
    }
    bira.a().a(paramString1, paramString2);
    return 200;
  }
  
  public int a(List<birp> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      return 400;
    }
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      DownloadInfo localDownloadInfo = a((birp)paramList.next());
      localDownloadInfo.jdField_c_of_type_Int = 0;
      localArrayList.add(localDownloadInfo);
    }
    if (bira.a().a(localArrayList) != 0) {
      return 400;
    }
    return 200;
  }
  
  public void a(Activity paramActivity, DownloadInfo paramDownloadInfo, birp parambirp)
  {
    new Handler(Looper.getMainLooper()).post(new DownloadNativeApi.1(this, paramDownloadInfo, parambirp, paramActivity));
  }
  
  public void a(birn parambirn)
  {
    this.jdField_a_of_type_Birj.a(parambirn);
    bira.a().a(this.jdField_a_of_type_Birj);
  }
  
  public boolean a(String paramString)
  {
    return biub.a(paramString);
  }
  
  public void b(birn parambirn)
  {
    this.jdField_a_of_type_Birj.a();
    this.jdField_a_of_type_Birj.b(parambirn);
    bira.a().b(this.jdField_a_of_type_Birj);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     birk
 * JD-Core Version:    0.7.0.1
 */