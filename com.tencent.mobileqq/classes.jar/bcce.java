import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import com.tencent.open.appcommon.now.download.local.DownloadNativeApi.1;
import com.tencent.open.downloadnew.DownloadInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class bcce
{
  private static bcce jdField_a_of_type_Bcce;
  private bccd jdField_a_of_type_Bccd = new bccd();
  
  public static bcce a()
  {
    if (jdField_a_of_type_Bcce == null) {
      jdField_a_of_type_Bcce = new bcce();
    }
    return jdField_a_of_type_Bcce;
  }
  
  private DownloadInfo a(bccj parambccj)
  {
    DownloadInfo localDownloadInfo = new DownloadInfo(parambccj.jdField_a_of_type_JavaLangString, parambccj.jdField_b_of_type_JavaLangString);
    localDownloadInfo.jdField_d_of_type_JavaLangString = parambccj.jdField_d_of_type_JavaLangString;
    localDownloadInfo.jdField_b_of_type_Int = parambccj.jdField_a_of_type_Int;
    localDownloadInfo.jdField_b_of_type_Boolean = parambccj.jdField_d_of_type_Boolean;
    localDownloadInfo.jdField_a_of_type_Boolean = parambccj.e;
    localDownloadInfo.f = parambccj.jdField_c_of_type_JavaLangString;
    localDownloadInfo.jdField_a_of_type_Int = parambccj.jdField_c_of_type_Int;
    localDownloadInfo.jdField_c_of_type_Int = parambccj.jdField_b_of_type_Int;
    localDownloadInfo.jdField_d_of_type_Int = 0;
    localDownloadInfo.jdField_c_of_type_Boolean = true;
    return localDownloadInfo;
  }
  
  private boolean a()
  {
    return "com.tencent.mobileqq:tool".equals(bcax.q());
  }
  
  public int a(Activity paramActivity, bccj parambccj)
  {
    if (!a()) {
      return 401;
    }
    if (parambccj == null) {
      return 400;
    }
    if ((parambccj.jdField_a_of_type_Boolean) && (!"com.tencent.now".equals(parambccj.jdField_c_of_type_JavaLangString))) {
      return 402;
    }
    DownloadInfo localDownloadInfo = a(parambccj);
    localDownloadInfo.g = 2;
    localDownloadInfo.jdField_c_of_type_Boolean = true;
    if ((mpl.a() != 1) && (paramActivity != null) && (parambccj.f)) {
      a(paramActivity, localDownloadInfo, parambccj);
    }
    for (;;)
    {
      return 200;
      bcbu.a().a(localDownloadInfo);
      this.jdField_a_of_type_Bccd.a(parambccj);
    }
  }
  
  public int a(bccj parambccj)
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
      } while (parambccj == null);
      parambccj = a(parambccj);
      parambccj.g = 13;
      parambccj.jdField_c_of_type_Int = 0;
      k = bcbu.a().a(parambccj);
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
    this.jdField_a_of_type_Bccd.a(paramString);
    bcbu.a().a(paramString);
    return 200;
  }
  
  public int a(String paramString1, String paramString2)
  {
    if (!a()) {
      return 401;
    }
    bcbu.a().a(paramString1, paramString2);
    return 200;
  }
  
  public int a(List<bccj> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      return 400;
    }
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      DownloadInfo localDownloadInfo = a((bccj)paramList.next());
      localDownloadInfo.jdField_c_of_type_Int = 0;
      localArrayList.add(localDownloadInfo);
    }
    if (bcbu.a().a(localArrayList) != 0) {
      return 400;
    }
    return 200;
  }
  
  public void a(Activity paramActivity, DownloadInfo paramDownloadInfo, bccj parambccj)
  {
    new Handler(Looper.getMainLooper()).post(new DownloadNativeApi.1(this, paramDownloadInfo, parambccj, paramActivity));
  }
  
  public void a(bcch parambcch)
  {
    this.jdField_a_of_type_Bccd.a(parambcch);
    bcbu.a().a(this.jdField_a_of_type_Bccd);
  }
  
  public boolean a(String paramString)
  {
    return bcev.a(paramString);
  }
  
  public void b(bcch parambcch)
  {
    this.jdField_a_of_type_Bccd.a();
    this.jdField_a_of_type_Bccd.b(parambcch);
    bcbu.a().b(this.jdField_a_of_type_Bccd);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bcce
 * JD-Core Version:    0.7.0.1
 */