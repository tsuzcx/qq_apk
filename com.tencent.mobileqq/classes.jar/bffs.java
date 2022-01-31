import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import com.tencent.open.appcommon.now.download.local.DownloadNativeApi.1;
import com.tencent.open.downloadnew.DownloadInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class bffs
{
  private static bffs jdField_a_of_type_Bffs;
  private bffr jdField_a_of_type_Bffr = new bffr();
  
  public static bffs a()
  {
    if (jdField_a_of_type_Bffs == null) {
      jdField_a_of_type_Bffs = new bffs();
    }
    return jdField_a_of_type_Bffs;
  }
  
  private DownloadInfo a(bffx parambffx)
  {
    DownloadInfo localDownloadInfo = new DownloadInfo(parambffx.jdField_a_of_type_JavaLangString, parambffx.jdField_b_of_type_JavaLangString);
    localDownloadInfo.jdField_d_of_type_JavaLangString = parambffx.jdField_d_of_type_JavaLangString;
    localDownloadInfo.jdField_b_of_type_Int = parambffx.jdField_a_of_type_Int;
    localDownloadInfo.jdField_b_of_type_Boolean = parambffx.jdField_d_of_type_Boolean;
    localDownloadInfo.jdField_a_of_type_Boolean = parambffx.e;
    localDownloadInfo.f = parambffx.jdField_c_of_type_JavaLangString;
    localDownloadInfo.jdField_a_of_type_Int = parambffx.jdField_c_of_type_Int;
    localDownloadInfo.jdField_c_of_type_Int = parambffx.jdField_b_of_type_Int;
    localDownloadInfo.jdField_d_of_type_Int = 0;
    localDownloadInfo.jdField_c_of_type_Boolean = true;
    return localDownloadInfo;
  }
  
  private boolean a()
  {
    return "com.tencent.mobileqq:tool".equals(bfel.r());
  }
  
  public int a(Activity paramActivity, bffx parambffx)
  {
    if (!a()) {
      return 401;
    }
    if (parambffx == null) {
      return 400;
    }
    if ((parambffx.jdField_a_of_type_Boolean) && (!"com.tencent.now".equals(parambffx.jdField_c_of_type_JavaLangString))) {
      return 402;
    }
    DownloadInfo localDownloadInfo = a(parambffx);
    localDownloadInfo.g = 2;
    localDownloadInfo.jdField_c_of_type_Boolean = true;
    if ((ndd.a() != 1) && (paramActivity != null) && (parambffx.f)) {
      a(paramActivity, localDownloadInfo, parambffx);
    }
    for (;;)
    {
      return 200;
      bffi.a().a(localDownloadInfo);
      this.jdField_a_of_type_Bffr.a(parambffx);
    }
  }
  
  public int a(bffx parambffx)
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
      } while (parambffx == null);
      parambffx = a(parambffx);
      parambffx.g = 13;
      parambffx.jdField_c_of_type_Int = 0;
      k = bffi.a().a(parambffx);
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
    this.jdField_a_of_type_Bffr.a(paramString);
    bffi.a().a(paramString);
    return 200;
  }
  
  public int a(String paramString1, String paramString2)
  {
    if (!a()) {
      return 401;
    }
    bffi.a().a(paramString1, paramString2);
    return 200;
  }
  
  public int a(List<bffx> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      return 400;
    }
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      DownloadInfo localDownloadInfo = a((bffx)paramList.next());
      localDownloadInfo.jdField_c_of_type_Int = 0;
      localArrayList.add(localDownloadInfo);
    }
    if (bffi.a().a(localArrayList) != 0) {
      return 400;
    }
    return 200;
  }
  
  public void a(Activity paramActivity, DownloadInfo paramDownloadInfo, bffx parambffx)
  {
    new Handler(Looper.getMainLooper()).post(new DownloadNativeApi.1(this, paramDownloadInfo, parambffx, paramActivity));
  }
  
  public void a(bffv parambffv)
  {
    this.jdField_a_of_type_Bffr.a(parambffv);
    bffi.a().a(this.jdField_a_of_type_Bffr);
  }
  
  public boolean a(String paramString)
  {
    return bfij.a(paramString);
  }
  
  public void b(bffv parambffv)
  {
    this.jdField_a_of_type_Bffr.a();
    this.jdField_a_of_type_Bffr.b(parambffv);
    bffi.a().b(this.jdField_a_of_type_Bffr);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bffs
 * JD-Core Version:    0.7.0.1
 */