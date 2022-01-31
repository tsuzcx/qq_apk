import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.httputils.HttpCommunicator;
import com.tencent.qphone.base.util.BaseApplication;

public class azth
  implements bbmi
{
  private final int jdField_a_of_type_Int;
  private final long jdField_a_of_type_Long;
  private azti jdField_a_of_type_Azti;
  private bbmg jdField_a_of_type_Bbmg;
  private final QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean = true;
  private final int jdField_b_of_type_Int;
  private long jdField_b_of_type_Long;
  private boolean jdField_b_of_type_Boolean;
  
  public azth(QQAppInterface paramQQAppInterface, long paramLong1, int paramInt1, int paramInt2, long paramLong2, boolean paramBoolean, String paramString)
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
    if (this.jdField_a_of_type_Bbmg != null)
    {
      azsr.c("FtnDownloader", azsr.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_Long + "] cancel ftn download");
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHttpCommunicatort().a(this.jdField_a_of_type_Bbmg);
      this.jdField_a_of_type_Bbmg = null;
    }
  }
  
  protected void a(int paramInt, String paramString1, String paramString2, bbmg parambbmg)
  {
    azsr.a("FtnDownloader", azsr.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_Long + "] ftn download err. errCode:" + paramInt + " errMsg:" + paramString1 + " rspHeader:" + paramString2);
    this.jdField_a_of_type_Boolean = true;
    if (this.jdField_a_of_type_Azti != null) {
      this.jdField_a_of_type_Azti.a(paramInt, paramString1, paramString2, parambbmg);
    }
  }
  
  public void a(azti paramazti)
  {
    this.jdField_a_of_type_Azti = paramazti;
  }
  
  public void a(bbmg parambbmg1, bbmg parambbmg2)
  {
    if (this.jdField_a_of_type_Boolean) {}
    long l;
    do
    {
      do
      {
        return;
        if (parambbmg1 == this.jdField_a_of_type_Bbmg) {
          break;
        }
        if ((parambbmg1 != null) && (this.jdField_a_of_type_Bbmg != null))
        {
          azsr.a("FtnDownloader", azsr.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_Long + "],Req Serial[" + String.valueOf(parambbmg1.a()) + "], curRequest Serial[" + String.valueOf(this.jdField_a_of_type_Bbmg.a()) + "]");
          return;
        }
        if (parambbmg1 != null)
        {
          azsr.a("FtnDownloader", azsr.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_Long + "],Req Serial[" + String.valueOf(parambbmg1.a()) + "]");
          return;
        }
      } while (this.jdField_a_of_type_Bbmg == null);
      azsr.a("FtnDownloader", azsr.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_Long + "],curRequest Serial[" + String.valueOf(this.jdField_a_of_type_Bbmg.a()) + "]");
      return;
      if ((parambbmg2.c() != 206) && (parambbmg2.c() != 200)) {
        break;
      }
      parambbmg1 = parambbmg2.a();
      l = parambbmg2.a();
      if (this.jdField_b_of_type_Long == 0L) {
        this.jdField_b_of_type_Long = l;
      }
    } while (this.jdField_a_of_type_Azti == null);
    this.jdField_a_of_type_Azti.a(parambbmg1, l, parambbmg2.jdField_c_of_type_JavaLangString);
    return;
    azsr.a("FtnDownloader", azsr.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_Long + "] ftn download decode resp code no 200|206");
  }
  
  public void a(String paramString)
  {
    if (this.jdField_a_of_type_Boolean) {}
    do
    {
      return;
      azsr.a("FtnDownloader", azsr.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_Long + "] ftn download Redirect. " + paramString);
    } while (this.jdField_a_of_type_Azti == null);
    this.jdField_a_of_type_Azti.a(paramString);
  }
  
  public boolean a(bbmg parambbmg1, bbmg parambbmg2, int paramInt)
  {
    if (5 == paramInt) {
      if (!this.jdField_a_of_type_Boolean) {}
    }
    while ((3 != paramInt) || (this.jdField_a_of_type_Boolean) || (this.jdField_a_of_type_Azti == null))
    {
      do
      {
        return true;
        this.jdField_a_of_type_Boolean = true;
      } while (this.jdField_a_of_type_Azti == null);
      this.jdField_a_of_type_Azti.a();
      return true;
    }
    this.jdField_a_of_type_Azti.a(parambbmg2);
    return true;
  }
  
  public boolean a(String paramString, long paramLong)
  {
    azsr.c("FtnDownloader", azsr.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_Long + "] ftn download url:" + paramString + " pos:" + paramLong);
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    this.jdField_a_of_type_Boolean = false;
    String str2 = "bytes=" + paramLong + "-";
    bbmg localbbmg = new bbmg(paramString, null, this, true);
    localbbmg.b(false);
    String str1 = "gprs";
    if (bbev.b(BaseApplication.getContext()) == 1) {
      str1 = "wifi";
    }
    localbbmg.a("Net-type", str1);
    localbbmg.a("cache-control", "no-cache");
    if (paramLong != 0L) {
      localbbmg.a("Range", str2);
    }
    localbbmg.b(5);
    localbbmg.a(true);
    localbbmg.jdField_b_of_type_Int = this.jdField_b_of_type_Int;
    localbbmg.jdField_c_of_type_Int = this.jdField_a_of_type_Int;
    localbbmg.jdField_a_of_type_JavaLangString = String.valueOf(this.jdField_a_of_type_Long);
    localbbmg.a("Accept-Encoding", "identity");
    if (this.jdField_a_of_type_Azti != null) {
      this.jdField_a_of_type_Azti.b(localbbmg);
    }
    str1 = "";
    if (paramString != null) {
      str1 = paramString.toLowerCase();
    }
    if ((this.jdField_b_of_type_Boolean) && (str1.startsWith("https")))
    {
      localbbmg.j = true;
      localbbmg.k = apam.a(paramString);
      localbbmg.e = this.jdField_a_of_type_JavaLangString;
    }
    localbbmg.jdField_a_of_type_Ayug = apue.a();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHttpCommunicatort().a(localbbmg);
    this.jdField_a_of_type_Bbmg = localbbmg;
    return true;
  }
  
  public void b(bbmg parambbmg1, bbmg parambbmg2)
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    if (parambbmg2 != null)
    {
      a(parambbmg2.f, parambbmg2.d(), parambbmg2.d, parambbmg2);
      return;
    }
    a(9001, "err no response", "", null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     azth
 * JD-Core Version:    0.7.0.1
 */