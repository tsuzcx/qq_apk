import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import com.tencent.open.appcommon.now.download.local.DownloadNativeApi.1;
import com.tencent.open.downloadnew.DownloadInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class bfkb
{
  private static bfkb jdField_a_of_type_Bfkb;
  private bfka jdField_a_of_type_Bfka = new bfka();
  
  public static bfkb a()
  {
    if (jdField_a_of_type_Bfkb == null) {
      jdField_a_of_type_Bfkb = new bfkb();
    }
    return jdField_a_of_type_Bfkb;
  }
  
  private DownloadInfo a(bfkg parambfkg)
  {
    DownloadInfo localDownloadInfo = new DownloadInfo(parambfkg.jdField_a_of_type_JavaLangString, parambfkg.jdField_b_of_type_JavaLangString);
    localDownloadInfo.jdField_d_of_type_JavaLangString = parambfkg.jdField_d_of_type_JavaLangString;
    localDownloadInfo.jdField_b_of_type_Int = parambfkg.jdField_a_of_type_Int;
    localDownloadInfo.jdField_b_of_type_Boolean = parambfkg.jdField_d_of_type_Boolean;
    localDownloadInfo.jdField_a_of_type_Boolean = parambfkg.e;
    localDownloadInfo.f = parambfkg.jdField_c_of_type_JavaLangString;
    localDownloadInfo.jdField_a_of_type_Int = parambfkg.jdField_c_of_type_Int;
    localDownloadInfo.jdField_c_of_type_Int = parambfkg.jdField_b_of_type_Int;
    localDownloadInfo.jdField_d_of_type_Int = 0;
    localDownloadInfo.jdField_c_of_type_Boolean = true;
    return localDownloadInfo;
  }
  
  private boolean a()
  {
    return "com.tencent.mobileqq:tool".equals(bfiu.r());
  }
  
  public int a(Activity paramActivity, bfkg parambfkg)
  {
    if (!a()) {
      return 401;
    }
    if (parambfkg == null) {
      return 400;
    }
    if ((parambfkg.jdField_a_of_type_Boolean) && (!"com.tencent.now".equals(parambfkg.jdField_c_of_type_JavaLangString))) {
      return 402;
    }
    DownloadInfo localDownloadInfo = a(parambfkg);
    localDownloadInfo.g = 2;
    localDownloadInfo.jdField_c_of_type_Boolean = true;
    if ((ndd.a() != 1) && (paramActivity != null) && (parambfkg.f)) {
      a(paramActivity, localDownloadInfo, parambfkg);
    }
    for (;;)
    {
      return 200;
      bfjr.a().a(localDownloadInfo);
      this.jdField_a_of_type_Bfka.a(parambfkg);
    }
  }
  
  public int a(bfkg parambfkg)
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
      } while (parambfkg == null);
      parambfkg = a(parambfkg);
      parambfkg.g = 13;
      parambfkg.jdField_c_of_type_Int = 0;
      k = bfjr.a().a(parambfkg);
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
    this.jdField_a_of_type_Bfka.a(paramString);
    bfjr.a().a(paramString);
    return 200;
  }
  
  public int a(String paramString1, String paramString2)
  {
    if (!a()) {
      return 401;
    }
    bfjr.a().a(paramString1, paramString2);
    return 200;
  }
  
  public int a(List<bfkg> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      return 400;
    }
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      DownloadInfo localDownloadInfo = a((bfkg)paramList.next());
      localDownloadInfo.jdField_c_of_type_Int = 0;
      localArrayList.add(localDownloadInfo);
    }
    if (bfjr.a().a(localArrayList) != 0) {
      return 400;
    }
    return 200;
  }
  
  public void a(Activity paramActivity, DownloadInfo paramDownloadInfo, bfkg parambfkg)
  {
    new Handler(Looper.getMainLooper()).post(new DownloadNativeApi.1(this, paramDownloadInfo, parambfkg, paramActivity));
  }
  
  public void a(bfke parambfke)
  {
    this.jdField_a_of_type_Bfka.a(parambfke);
    bfjr.a().a(this.jdField_a_of_type_Bfka);
  }
  
  public boolean a(String paramString)
  {
    return bfms.a(paramString);
  }
  
  public void b(bfke parambfke)
  {
    this.jdField_a_of_type_Bfka.a();
    this.jdField_a_of_type_Bfka.b(parambfke);
    bfjr.a().b(this.jdField_a_of_type_Bfka);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bfkb
 * JD-Core Version:    0.7.0.1
 */