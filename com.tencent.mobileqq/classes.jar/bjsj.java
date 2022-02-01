import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import com.tencent.open.appcommon.now.download.local.DownloadNativeApi.1;
import com.tencent.open.downloadnew.DownloadInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class bjsj
{
  private static bjsj jdField_a_of_type_Bjsj;
  private bjsi jdField_a_of_type_Bjsi = new bjsi();
  
  public static bjsj a()
  {
    if (jdField_a_of_type_Bjsj == null) {
      jdField_a_of_type_Bjsj = new bjsj();
    }
    return jdField_a_of_type_Bjsj;
  }
  
  private DownloadInfo a(bjso parambjso)
  {
    DownloadInfo localDownloadInfo = new DownloadInfo(parambjso.jdField_a_of_type_JavaLangString, parambjso.jdField_b_of_type_JavaLangString);
    localDownloadInfo.jdField_d_of_type_JavaLangString = parambjso.jdField_d_of_type_JavaLangString;
    localDownloadInfo.jdField_b_of_type_Int = parambjso.jdField_a_of_type_Int;
    localDownloadInfo.jdField_b_of_type_Boolean = parambjso.jdField_d_of_type_Boolean;
    localDownloadInfo.jdField_a_of_type_Boolean = parambjso.e;
    localDownloadInfo.f = parambjso.jdField_c_of_type_JavaLangString;
    localDownloadInfo.jdField_a_of_type_Int = parambjso.jdField_c_of_type_Int;
    localDownloadInfo.jdField_c_of_type_Int = parambjso.jdField_b_of_type_Int;
    localDownloadInfo.jdField_d_of_type_Int = 0;
    localDownloadInfo.jdField_c_of_type_Boolean = true;
    return localDownloadInfo;
  }
  
  private boolean a()
  {
    return "com.tencent.mobileqq:tool".equals(bjrc.r());
  }
  
  public int a(Activity paramActivity, bjso parambjso)
  {
    if (!a()) {
      return 401;
    }
    if (parambjso == null) {
      return 400;
    }
    if ((parambjso.jdField_a_of_type_Boolean) && (!"com.tencent.now".equals(parambjso.jdField_c_of_type_JavaLangString))) {
      return 402;
    }
    DownloadInfo localDownloadInfo = a(parambjso);
    localDownloadInfo.g = 2;
    localDownloadInfo.jdField_c_of_type_Boolean = true;
    if ((nnr.a() != 1) && (paramActivity != null) && (parambjso.f)) {
      a(paramActivity, localDownloadInfo, parambjso);
    }
    for (;;)
    {
      return 200;
      bjrz.a().a(localDownloadInfo);
      this.jdField_a_of_type_Bjsi.a(parambjso);
    }
  }
  
  public int a(bjso parambjso)
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
      } while (parambjso == null);
      parambjso = a(parambjso);
      parambjso.g = 13;
      parambjso.jdField_c_of_type_Int = 0;
      k = bjrz.a().a(parambjso);
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
    this.jdField_a_of_type_Bjsi.a(paramString);
    bjrz.a().a(paramString);
    return 200;
  }
  
  public int a(String paramString1, String paramString2)
  {
    if (!a()) {
      return 401;
    }
    bjrz.a().a(paramString1, paramString2);
    return 200;
  }
  
  public int a(List<bjso> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      return 400;
    }
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      DownloadInfo localDownloadInfo = a((bjso)paramList.next());
      localDownloadInfo.jdField_c_of_type_Int = 0;
      localArrayList.add(localDownloadInfo);
    }
    if (bjrz.a().a(localArrayList) != 0) {
      return 400;
    }
    return 200;
  }
  
  public void a(Activity paramActivity, DownloadInfo paramDownloadInfo, bjso parambjso)
  {
    new Handler(Looper.getMainLooper()).post(new DownloadNativeApi.1(this, paramDownloadInfo, parambjso, paramActivity));
  }
  
  public void a(bjsm parambjsm)
  {
    this.jdField_a_of_type_Bjsi.a(parambjsm);
    bjrz.a().a(this.jdField_a_of_type_Bjsi);
  }
  
  public boolean a(String paramString)
  {
    return bjva.a(paramString);
  }
  
  public void b(bjsm parambjsm)
  {
    this.jdField_a_of_type_Bjsi.a();
    this.jdField_a_of_type_Bjsi.b(parambjsm);
    bjrz.a().b(this.jdField_a_of_type_Bjsi);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bjsj
 * JD-Core Version:    0.7.0.1
 */