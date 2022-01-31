import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.httputils.HttpCommunicator;
import com.tencent.qphone.base.util.BaseApplication;

public class aztj
  implements bbmw
{
  private final int jdField_a_of_type_Int;
  private final long jdField_a_of_type_Long;
  private aztk jdField_a_of_type_Aztk;
  private bbmu jdField_a_of_type_Bbmu;
  private final QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean = true;
  private final int jdField_b_of_type_Int;
  private long jdField_b_of_type_Long;
  private boolean jdField_b_of_type_Boolean;
  
  public aztj(QQAppInterface paramQQAppInterface, long paramLong1, int paramInt1, int paramInt2, long paramLong2, boolean paramBoolean, String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Long = paramLong1;
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
    this.jdField_b_of_type_Long = paramLong2;
    this.jdField_b_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Boolean = true;
    if (this.jdField_a_of_type_Bbmu != null)
    {
      azst.c("FtnDownloader", azst.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_Long + "] cancel ftn download");
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHttpCommunicatort().a(this.jdField_a_of_type_Bbmu);
      this.jdField_a_of_type_Bbmu = null;
    }
  }
  
  protected void a(int paramInt, String paramString1, String paramString2, bbmu parambbmu)
  {
    azst.a("FtnDownloader", azst.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_Long + "] ftn download err. errCode:" + paramInt + " errMsg:" + paramString1 + " rspHeader:" + paramString2);
    this.jdField_a_of_type_Boolean = true;
    if (this.jdField_a_of_type_Aztk != null) {
      this.jdField_a_of_type_Aztk.a(paramInt, paramString1, paramString2, parambbmu);
    }
  }
  
  public void a(aztk paramaztk)
  {
    this.jdField_a_of_type_Aztk = paramaztk;
  }
  
  public void a(bbmu parambbmu1, bbmu parambbmu2)
  {
    if (this.jdField_a_of_type_Boolean) {}
    long l;
    do
    {
      do
      {
        return;
        if (parambbmu1 == this.jdField_a_of_type_Bbmu) {
          break;
        }
        if ((parambbmu1 != null) && (this.jdField_a_of_type_Bbmu != null))
        {
          azst.a("FtnDownloader", azst.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_Long + "],Req Serial[" + String.valueOf(parambbmu1.a()) + "], curRequest Serial[" + String.valueOf(this.jdField_a_of_type_Bbmu.a()) + "]");
          return;
        }
        if (parambbmu1 != null)
        {
          azst.a("FtnDownloader", azst.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_Long + "],Req Serial[" + String.valueOf(parambbmu1.a()) + "]");
          return;
        }
      } while (this.jdField_a_of_type_Bbmu == null);
      azst.a("FtnDownloader", azst.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_Long + "],curRequest Serial[" + String.valueOf(this.jdField_a_of_type_Bbmu.a()) + "]");
      return;
      if ((parambbmu2.c() != 206) && (parambbmu2.c() != 200)) {
        break;
      }
      parambbmu1 = parambbmu2.a();
      l = parambbmu2.a();
      if (this.jdField_b_of_type_Long == 0L) {
        this.jdField_b_of_type_Long = l;
      }
    } while (this.jdField_a_of_type_Aztk == null);
    this.jdField_a_of_type_Aztk.a(parambbmu1, l, parambbmu2.jdField_c_of_type_JavaLangString);
    return;
    azst.a("FtnDownloader", azst.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_Long + "] ftn download decode resp code no 200|206");
  }
  
  public void a(String paramString)
  {
    if (this.jdField_a_of_type_Boolean) {}
    do
    {
      return;
      azst.a("FtnDownloader", azst.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_Long + "] ftn download Redirect. " + paramString);
    } while (this.jdField_a_of_type_Aztk == null);
    this.jdField_a_of_type_Aztk.a(paramString);
  }
  
  public boolean a(bbmu parambbmu1, bbmu parambbmu2, int paramInt)
  {
    if (5 == paramInt) {
      if (!this.jdField_a_of_type_Boolean) {}
    }
    while ((3 != paramInt) || (this.jdField_a_of_type_Boolean) || (this.jdField_a_of_type_Aztk == null))
    {
      do
      {
        return true;
        this.jdField_a_of_type_Boolean = true;
      } while (this.jdField_a_of_type_Aztk == null);
      this.jdField_a_of_type_Aztk.a();
      return true;
    }
    this.jdField_a_of_type_Aztk.a(parambbmu2);
    return true;
  }
  
  public boolean a(String paramString, long paramLong)
  {
    azst.c("FtnDownloader", azst.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_Long + "] ftn download url:" + paramString + " pos:" + paramLong);
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    this.jdField_a_of_type_Boolean = false;
    String str2 = "bytes=" + paramLong + "-";
    bbmu localbbmu = new bbmu(paramString, null, this, true);
    localbbmu.b(false);
    String str1 = "gprs";
    if (bbfj.b(BaseApplication.getContext()) == 1) {
      str1 = "wifi";
    }
    localbbmu.a("Net-type", str1);
    localbbmu.a("cache-control", "no-cache");
    if (paramLong != 0L) {
      localbbmu.a("Range", str2);
    }
    localbbmu.b(5);
    localbbmu.a(true);
    localbbmu.jdField_b_of_type_Int = this.jdField_b_of_type_Int;
    localbbmu.jdField_c_of_type_Int = this.jdField_a_of_type_Int;
    localbbmu.jdField_a_of_type_JavaLangString = String.valueOf(this.jdField_a_of_type_Long);
    localbbmu.a("Accept-Encoding", "identity");
    if (this.jdField_a_of_type_Aztk != null) {
      this.jdField_a_of_type_Aztk.b(localbbmu);
    }
    str1 = "";
    if (paramString != null) {
      str1 = paramString.toLowerCase();
    }
    if ((this.jdField_b_of_type_Boolean) && (str1.startsWith("https")))
    {
      localbbmu.j = true;
      localbbmu.k = apaq.a(paramString);
      localbbmu.e = this.jdField_a_of_type_JavaLangString;
    }
    localbbmu.jdField_a_of_type_Ayui = apug.a();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHttpCommunicatort().a(localbbmu);
    this.jdField_a_of_type_Bbmu = localbbmu;
    return true;
  }
  
  public void b(bbmu parambbmu1, bbmu parambbmu2)
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    if (parambbmu2 != null)
    {
      a(parambbmu2.f, parambbmu2.d(), parambbmu2.d, parambbmu2);
      return;
    }
    a(9001, "err no response", "", null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     aztj
 * JD-Core Version:    0.7.0.1
 */