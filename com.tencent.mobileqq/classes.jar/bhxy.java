import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.open.appcommon.now.download.local.DownloadNativeApi.1;
import com.tencent.open.downloadnew.DownloadInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class bhxy
{
  private static bhxy jdField_a_of_type_Bhxy;
  private bhxx jdField_a_of_type_Bhxx = new bhxx();
  
  public static bhxy a()
  {
    if (jdField_a_of_type_Bhxy == null) {
      jdField_a_of_type_Bhxy = new bhxy();
    }
    return jdField_a_of_type_Bhxy;
  }
  
  private DownloadInfo a(bhyd parambhyd)
  {
    DownloadInfo localDownloadInfo = new DownloadInfo(parambhyd.jdField_a_of_type_JavaLangString, parambhyd.jdField_b_of_type_JavaLangString);
    localDownloadInfo.jdField_d_of_type_JavaLangString = parambhyd.jdField_d_of_type_JavaLangString;
    localDownloadInfo.jdField_b_of_type_Int = parambhyd.jdField_a_of_type_Int;
    localDownloadInfo.jdField_b_of_type_Boolean = parambhyd.jdField_d_of_type_Boolean;
    localDownloadInfo.jdField_a_of_type_Boolean = parambhyd.e;
    localDownloadInfo.f = parambhyd.jdField_c_of_type_JavaLangString;
    localDownloadInfo.jdField_a_of_type_Int = parambhyd.jdField_c_of_type_Int;
    localDownloadInfo.jdField_c_of_type_Int = parambhyd.jdField_b_of_type_Int;
    localDownloadInfo.jdField_d_of_type_Int = 0;
    localDownloadInfo.jdField_c_of_type_Boolean = true;
    return localDownloadInfo;
  }
  
  private boolean a()
  {
    return "com.tencent.mobileqq:tool".equals(bhwr.r());
  }
  
  public int a(Activity paramActivity, bhyd parambhyd)
  {
    if (!a()) {
      return 401;
    }
    if (parambhyd == null) {
      return 400;
    }
    if ((parambhyd.jdField_a_of_type_Boolean) && (!"com.tencent.now".equals(parambhyd.jdField_c_of_type_JavaLangString))) {
      return 402;
    }
    DownloadInfo localDownloadInfo = a(parambhyd);
    localDownloadInfo.g = 2;
    localDownloadInfo.jdField_c_of_type_Boolean = true;
    if ((HttpUtil.getNetWorkType() != 1) && (paramActivity != null) && (parambhyd.f)) {
      a(paramActivity, localDownloadInfo, parambhyd);
    }
    for (;;)
    {
      return 200;
      bhxo.a().a(localDownloadInfo);
      this.jdField_a_of_type_Bhxx.a(parambhyd);
    }
  }
  
  public int a(bhyd parambhyd)
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
      } while (parambhyd == null);
      parambhyd = a(parambhyd);
      parambhyd.g = 13;
      parambhyd.jdField_c_of_type_Int = 0;
      k = bhxo.a().a(parambhyd);
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
    this.jdField_a_of_type_Bhxx.a(paramString);
    bhxo.a().a(paramString);
    return 200;
  }
  
  public int a(String paramString1, String paramString2)
  {
    if (!a()) {
      return 401;
    }
    bhxo.a().a(paramString1, paramString2);
    return 200;
  }
  
  public int a(List<bhyd> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      return 400;
    }
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      DownloadInfo localDownloadInfo = a((bhyd)paramList.next());
      localDownloadInfo.jdField_c_of_type_Int = 0;
      localArrayList.add(localDownloadInfo);
    }
    if (bhxo.a().a(localArrayList) != 0) {
      return 400;
    }
    return 200;
  }
  
  public void a(Activity paramActivity, DownloadInfo paramDownloadInfo, bhyd parambhyd)
  {
    new Handler(Looper.getMainLooper()).post(new DownloadNativeApi.1(this, paramDownloadInfo, parambhyd, paramActivity));
  }
  
  public void a(bhyb parambhyb)
  {
    this.jdField_a_of_type_Bhxx.a(parambhyb);
    bhxo.a().a(this.jdField_a_of_type_Bhxx);
  }
  
  public boolean a(String paramString)
  {
    return biam.a(paramString);
  }
  
  public void b(bhyb parambhyb)
  {
    this.jdField_a_of_type_Bhxx.a();
    this.jdField_a_of_type_Bhxx.b(parambhyb);
    bhxo.a().b(this.jdField_a_of_type_Bhxx);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhxy
 * JD-Core Version:    0.7.0.1
 */