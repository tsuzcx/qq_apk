import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;

public class bfwh
  implements bhvc
{
  private final int jdField_a_of_type_Int;
  private final long jdField_a_of_type_Long;
  private bfwi jdField_a_of_type_Bfwi;
  private bhva jdField_a_of_type_Bhva;
  private final QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean = true;
  private final int jdField_b_of_type_Int;
  private long jdField_b_of_type_Long;
  private boolean jdField_b_of_type_Boolean;
  
  public bfwh(QQAppInterface paramQQAppInterface, long paramLong1, int paramInt1, int paramInt2, long paramLong2, boolean paramBoolean, String paramString)
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
    if (this.jdField_a_of_type_Bhva != null)
    {
      bfvr.c("FtnDownloader", bfvr.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_Long + "] cancel ftn download");
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHttpCommunicatort().b(this.jdField_a_of_type_Bhva);
      this.jdField_a_of_type_Bhva = null;
    }
  }
  
  protected void a(int paramInt, String paramString1, String paramString2, bhva parambhva)
  {
    bfvr.a("FtnDownloader", bfvr.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_Long + "] ftn download err. errCode:" + paramInt + " errMsg:" + paramString1 + " rspHeader:" + paramString2);
    this.jdField_a_of_type_Boolean = true;
    if (this.jdField_a_of_type_Bfwi != null) {
      this.jdField_a_of_type_Bfwi.a(paramInt, paramString1, paramString2, parambhva);
    }
  }
  
  public void a(bfwi parambfwi)
  {
    this.jdField_a_of_type_Bfwi = parambfwi;
  }
  
  public void a(bhva parambhva1, bhva parambhva2)
  {
    if (this.jdField_a_of_type_Boolean) {}
    long l;
    do
    {
      do
      {
        return;
        if (parambhva1 == this.jdField_a_of_type_Bhva) {
          break;
        }
        if ((parambhva1 != null) && (this.jdField_a_of_type_Bhva != null))
        {
          bfvr.a("FtnDownloader", bfvr.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_Long + "],Req Serial[" + String.valueOf(parambhva1.a()) + "], curRequest Serial[" + String.valueOf(this.jdField_a_of_type_Bhva.a()) + "]");
          return;
        }
        if (parambhva1 != null)
        {
          bfvr.a("FtnDownloader", bfvr.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_Long + "],Req Serial[" + String.valueOf(parambhva1.a()) + "]");
          return;
        }
      } while (this.jdField_a_of_type_Bhva == null);
      bfvr.a("FtnDownloader", bfvr.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_Long + "],curRequest Serial[" + String.valueOf(this.jdField_a_of_type_Bhva.a()) + "]");
      return;
      if ((parambhva2.c() != 206) && (parambhva2.c() != 200)) {
        break;
      }
      parambhva1 = parambhva2.a();
      l = parambhva2.a();
      if (this.jdField_b_of_type_Long == 0L) {
        this.jdField_b_of_type_Long = l;
      }
    } while (this.jdField_a_of_type_Bfwi == null);
    this.jdField_a_of_type_Bfwi.a(parambhva1, l, parambhva2.jdField_c_of_type_JavaLangString);
    return;
    bfvr.a("FtnDownloader", bfvr.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_Long + "] ftn download decode resp code no 200|206");
  }
  
  public void a(String paramString)
  {
    if (this.jdField_a_of_type_Boolean) {}
    do
    {
      return;
      bfvr.a("FtnDownloader", bfvr.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_Long + "] ftn download Redirect. " + paramString);
    } while (this.jdField_a_of_type_Bfwi == null);
    this.jdField_a_of_type_Bfwi.a(paramString);
  }
  
  public boolean a(bhva parambhva1, bhva parambhva2, int paramInt)
  {
    if (5 == paramInt) {
      if (!this.jdField_a_of_type_Boolean) {}
    }
    while ((3 != paramInt) || (this.jdField_a_of_type_Boolean) || (this.jdField_a_of_type_Bfwi == null))
    {
      do
      {
        return true;
        this.jdField_a_of_type_Boolean = true;
      } while (this.jdField_a_of_type_Bfwi == null);
      this.jdField_a_of_type_Bfwi.a();
      return true;
    }
    this.jdField_a_of_type_Bfwi.a(parambhva2);
    return true;
  }
  
  public boolean a(String paramString, long paramLong)
  {
    bfvr.c("FtnDownloader", bfvr.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_Long + "] ftn download url:" + paramString + " pos:" + paramLong);
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    this.jdField_a_of_type_Boolean = false;
    String str2 = "bytes=" + paramLong + "-";
    bhva localbhva = new bhva(paramString, null, this, true);
    localbhva.b(false);
    String str1 = "gprs";
    if (bhnv.b(BaseApplication.getContext()) == 1) {
      str1 = "wifi";
    }
    localbhva.a("Net-type", str1);
    localbhva.a("cache-control", "no-cache");
    if (paramLong != 0L) {
      localbhva.a("Range", str2);
    }
    localbhva.b(5);
    localbhva.a(true);
    localbhva.jdField_b_of_type_Int = this.jdField_b_of_type_Int;
    localbhva.jdField_c_of_type_Int = this.jdField_a_of_type_Int;
    localbhva.jdField_a_of_type_JavaLangString = String.valueOf(this.jdField_a_of_type_Long);
    localbhva.a("Accept-Encoding", "identity");
    if (this.jdField_a_of_type_Bfwi != null) {
      this.jdField_a_of_type_Bfwi.b(localbhva);
    }
    str1 = "";
    if (paramString != null) {
      str1 = paramString.toLowerCase();
    }
    if ((this.jdField_b_of_type_Boolean) && (str1.startsWith("https")))
    {
      localbhva.i = true;
      localbhva.j = atvr.a(paramString);
      localbhva.e = this.jdField_a_of_type_JavaLangString;
    }
    localbhva.jdField_a_of_type_Bewq = aunj.a();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHttpCommunicatort().a(localbhva);
    this.jdField_a_of_type_Bhva = localbhva;
    return true;
  }
  
  public void b(bhva parambhva1, bhva parambhva2)
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    if (parambhva2 != null)
    {
      a(parambhva2.f, parambhva2.d(), parambhva2.d, parambhva2);
      return;
    }
    a(9001, "err no response", "", null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfwh
 * JD-Core Version:    0.7.0.1
 */