import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.httputils.HttpCommunicator;
import com.tencent.qphone.base.util.BaseApplication;

public class bbrs
  implements bdlq
{
  private final int jdField_a_of_type_Int;
  private final long jdField_a_of_type_Long;
  private bbrt jdField_a_of_type_Bbrt;
  private bdlo jdField_a_of_type_Bdlo;
  private final QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean = true;
  private final int jdField_b_of_type_Int;
  private long jdField_b_of_type_Long;
  private boolean jdField_b_of_type_Boolean;
  
  public bbrs(QQAppInterface paramQQAppInterface, long paramLong1, int paramInt1, int paramInt2, long paramLong2, boolean paramBoolean, String paramString)
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
    if (this.jdField_a_of_type_Bdlo != null)
    {
      bbrc.c("FtnDownloader", bbrc.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_Long + "] cancel ftn download");
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHttpCommunicatort().a(this.jdField_a_of_type_Bdlo);
      this.jdField_a_of_type_Bdlo = null;
    }
  }
  
  protected void a(int paramInt, String paramString1, String paramString2, bdlo parambdlo)
  {
    bbrc.a("FtnDownloader", bbrc.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_Long + "] ftn download err. errCode:" + paramInt + " errMsg:" + paramString1 + " rspHeader:" + paramString2);
    this.jdField_a_of_type_Boolean = true;
    if (this.jdField_a_of_type_Bbrt != null) {
      this.jdField_a_of_type_Bbrt.a(paramInt, paramString1, paramString2, parambdlo);
    }
  }
  
  public void a(bbrt parambbrt)
  {
    this.jdField_a_of_type_Bbrt = parambbrt;
  }
  
  public void a(bdlo parambdlo1, bdlo parambdlo2)
  {
    if (this.jdField_a_of_type_Boolean) {}
    long l;
    do
    {
      do
      {
        return;
        if (parambdlo1 == this.jdField_a_of_type_Bdlo) {
          break;
        }
        if ((parambdlo1 != null) && (this.jdField_a_of_type_Bdlo != null))
        {
          bbrc.a("FtnDownloader", bbrc.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_Long + "],Req Serial[" + String.valueOf(parambdlo1.a()) + "], curRequest Serial[" + String.valueOf(this.jdField_a_of_type_Bdlo.a()) + "]");
          return;
        }
        if (parambdlo1 != null)
        {
          bbrc.a("FtnDownloader", bbrc.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_Long + "],Req Serial[" + String.valueOf(parambdlo1.a()) + "]");
          return;
        }
      } while (this.jdField_a_of_type_Bdlo == null);
      bbrc.a("FtnDownloader", bbrc.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_Long + "],curRequest Serial[" + String.valueOf(this.jdField_a_of_type_Bdlo.a()) + "]");
      return;
      if ((parambdlo2.c() != 206) && (parambdlo2.c() != 200)) {
        break;
      }
      parambdlo1 = parambdlo2.a();
      l = parambdlo2.a();
      if (this.jdField_b_of_type_Long == 0L) {
        this.jdField_b_of_type_Long = l;
      }
    } while (this.jdField_a_of_type_Bbrt == null);
    this.jdField_a_of_type_Bbrt.a(parambdlo1, l, parambdlo2.jdField_c_of_type_JavaLangString);
    return;
    bbrc.a("FtnDownloader", bbrc.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_Long + "] ftn download decode resp code no 200|206");
  }
  
  public void a(String paramString)
  {
    if (this.jdField_a_of_type_Boolean) {}
    do
    {
      return;
      bbrc.a("FtnDownloader", bbrc.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_Long + "] ftn download Redirect. " + paramString);
    } while (this.jdField_a_of_type_Bbrt == null);
    this.jdField_a_of_type_Bbrt.a(paramString);
  }
  
  public boolean a(bdlo parambdlo1, bdlo parambdlo2, int paramInt)
  {
    if (5 == paramInt) {
      if (!this.jdField_a_of_type_Boolean) {}
    }
    while ((3 != paramInt) || (this.jdField_a_of_type_Boolean) || (this.jdField_a_of_type_Bbrt == null))
    {
      do
      {
        return true;
        this.jdField_a_of_type_Boolean = true;
      } while (this.jdField_a_of_type_Bbrt == null);
      this.jdField_a_of_type_Bbrt.a();
      return true;
    }
    this.jdField_a_of_type_Bbrt.a(parambdlo2);
    return true;
  }
  
  public boolean a(String paramString, long paramLong)
  {
    bbrc.c("FtnDownloader", bbrc.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_Long + "] ftn download url:" + paramString + " pos:" + paramLong);
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    this.jdField_a_of_type_Boolean = false;
    String str2 = "bytes=" + paramLong + "-";
    bdlo localbdlo = new bdlo(paramString, null, this, true);
    localbdlo.b(false);
    String str1 = "gprs";
    if (bdee.b(BaseApplication.getContext()) == 1) {
      str1 = "wifi";
    }
    localbdlo.a("Net-type", str1);
    localbdlo.a("cache-control", "no-cache");
    if (paramLong != 0L) {
      localbdlo.a("Range", str2);
    }
    localbdlo.b(5);
    localbdlo.a(true);
    localbdlo.jdField_b_of_type_Int = this.jdField_b_of_type_Int;
    localbdlo.jdField_c_of_type_Int = this.jdField_a_of_type_Int;
    localbdlo.jdField_a_of_type_JavaLangString = String.valueOf(this.jdField_a_of_type_Long);
    localbdlo.a("Accept-Encoding", "identity");
    if (this.jdField_a_of_type_Bbrt != null) {
      this.jdField_a_of_type_Bbrt.b(localbdlo);
    }
    str1 = "";
    if (paramString != null) {
      str1 = paramString.toLowerCase();
    }
    if ((this.jdField_b_of_type_Boolean) && (str1.startsWith("https")))
    {
      localbdlo.j = true;
      localbdlo.k = aqto.a(paramString);
      localbdlo.e = this.jdField_a_of_type_JavaLangString;
    }
    localbdlo.jdField_a_of_type_Bash = arni.a();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHttpCommunicatort().a(localbdlo);
    this.jdField_a_of_type_Bdlo = localbdlo;
    return true;
  }
  
  public void b(bdlo parambdlo1, bdlo parambdlo2)
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    if (parambdlo2 != null)
    {
      a(parambdlo2.f, parambdlo2.d(), parambdlo2.d, parambdlo2);
      return;
    }
    a(9001, "err no response", "", null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbrs
 * JD-Core Version:    0.7.0.1
 */