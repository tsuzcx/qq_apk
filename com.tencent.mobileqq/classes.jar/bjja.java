import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.open.appcommon.now.download.local.DownloadNativeApi.1;
import com.tencent.open.downloadnew.DownloadInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class bjja
{
  private static bjja jdField_a_of_type_Bjja;
  private bjiz jdField_a_of_type_Bjiz = new bjiz();
  
  public static bjja a()
  {
    if (jdField_a_of_type_Bjja == null) {
      jdField_a_of_type_Bjja = new bjja();
    }
    return jdField_a_of_type_Bjja;
  }
  
  private DownloadInfo a(bjjf parambjjf)
  {
    DownloadInfo localDownloadInfo = new DownloadInfo(parambjjf.jdField_a_of_type_JavaLangString, parambjjf.jdField_b_of_type_JavaLangString);
    localDownloadInfo.jdField_d_of_type_JavaLangString = parambjjf.jdField_d_of_type_JavaLangString;
    localDownloadInfo.jdField_b_of_type_Int = parambjjf.jdField_a_of_type_Int;
    localDownloadInfo.jdField_b_of_type_Boolean = parambjjf.jdField_d_of_type_Boolean;
    localDownloadInfo.jdField_a_of_type_Boolean = parambjjf.e;
    localDownloadInfo.f = parambjjf.jdField_c_of_type_JavaLangString;
    localDownloadInfo.jdField_a_of_type_Int = parambjjf.jdField_c_of_type_Int;
    localDownloadInfo.jdField_c_of_type_Int = parambjjf.jdField_b_of_type_Int;
    localDownloadInfo.jdField_d_of_type_Int = 0;
    localDownloadInfo.jdField_c_of_type_Boolean = true;
    return localDownloadInfo;
  }
  
  private boolean a()
  {
    return "com.tencent.mobileqq:tool".equals(bjht.r());
  }
  
  public int a(Activity paramActivity, bjjf parambjjf)
  {
    if (!a()) {
      return 401;
    }
    if (parambjjf == null) {
      return 400;
    }
    if ((parambjjf.jdField_a_of_type_Boolean) && (!"com.tencent.now".equals(parambjjf.jdField_c_of_type_JavaLangString))) {
      return 402;
    }
    DownloadInfo localDownloadInfo = a(parambjjf);
    localDownloadInfo.g = 2;
    localDownloadInfo.jdField_c_of_type_Boolean = true;
    if ((HttpUtil.getNetWorkType() != 1) && (paramActivity != null) && (parambjjf.f)) {
      a(paramActivity, localDownloadInfo, parambjjf);
    }
    for (;;)
    {
      return 200;
      bjiq.a().a(localDownloadInfo);
      this.jdField_a_of_type_Bjiz.a(parambjjf);
    }
  }
  
  public int a(bjjf parambjjf)
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
      } while (parambjjf == null);
      parambjjf = a(parambjjf);
      parambjjf.g = 13;
      parambjjf.jdField_c_of_type_Int = 0;
      k = bjiq.a().a(parambjjf);
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
    this.jdField_a_of_type_Bjiz.a(paramString);
    bjiq.a().a(paramString);
    return 200;
  }
  
  public int a(String paramString1, String paramString2)
  {
    if (!a()) {
      return 401;
    }
    bjiq.a().a(paramString1, paramString2);
    return 200;
  }
  
  public int a(List<bjjf> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      return 400;
    }
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      DownloadInfo localDownloadInfo = a((bjjf)paramList.next());
      localDownloadInfo.jdField_c_of_type_Int = 0;
      localArrayList.add(localDownloadInfo);
    }
    if (bjiq.a().a(localArrayList) != 0) {
      return 400;
    }
    return 200;
  }
  
  public void a(Activity paramActivity, DownloadInfo paramDownloadInfo, bjjf parambjjf)
  {
    new Handler(Looper.getMainLooper()).post(new DownloadNativeApi.1(this, paramDownloadInfo, parambjjf, paramActivity));
  }
  
  public void a(bjjd parambjjd)
  {
    this.jdField_a_of_type_Bjiz.a(parambjjd);
    bjiq.a().a(this.jdField_a_of_type_Bjiz);
  }
  
  public boolean a(String paramString)
  {
    return bjlo.a(paramString);
  }
  
  public void b(bjjd parambjjd)
  {
    this.jdField_a_of_type_Bjiz.a();
    this.jdField_a_of_type_Bjiz.b(parambjjd);
    bjiq.a().b(this.jdField_a_of_type_Bjiz);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bjja
 * JD-Core Version:    0.7.0.1
 */