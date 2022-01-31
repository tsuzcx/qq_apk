import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.httputils.HttpCommunicator;
import com.tencent.qphone.base.util.BaseApplication;

public class aysr
  implements baky
{
  private final int jdField_a_of_type_Int;
  private final long jdField_a_of_type_Long;
  private ayss jdField_a_of_type_Ayss;
  private bakw jdField_a_of_type_Bakw;
  private final QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean = true;
  private final int jdField_b_of_type_Int;
  private long jdField_b_of_type_Long;
  private boolean jdField_b_of_type_Boolean;
  
  public aysr(QQAppInterface paramQQAppInterface, long paramLong1, int paramInt1, int paramInt2, long paramLong2, boolean paramBoolean, String paramString)
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
    if (this.jdField_a_of_type_Bakw != null)
    {
      aysb.c("FtnDownloader", aysb.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_Long + "] cancel ftn download");
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHttpCommunicatort().a(this.jdField_a_of_type_Bakw);
      this.jdField_a_of_type_Bakw = null;
    }
  }
  
  protected void a(int paramInt, String paramString1, String paramString2)
  {
    aysb.a("FtnDownloader", aysb.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_Long + "] ftn download err. errCode:" + paramInt + " errMsg:" + paramString1 + " rspHeader:" + paramString2);
    this.jdField_a_of_type_Boolean = true;
    if (this.jdField_a_of_type_Ayss != null) {
      this.jdField_a_of_type_Ayss.a(paramInt, paramString1, paramString2);
    }
  }
  
  public void a(ayss paramayss)
  {
    this.jdField_a_of_type_Ayss = paramayss;
  }
  
  public void a(bakw parambakw1, bakw parambakw2)
  {
    if (this.jdField_a_of_type_Boolean) {}
    long l;
    do
    {
      do
      {
        return;
        if (parambakw1 == this.jdField_a_of_type_Bakw) {
          break;
        }
        if ((parambakw1 != null) && (this.jdField_a_of_type_Bakw != null))
        {
          aysb.a("FtnDownloader", aysb.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_Long + "],Req Serial[" + String.valueOf(parambakw1.a()) + "], curRequest Serial[" + String.valueOf(this.jdField_a_of_type_Bakw.a()) + "]");
          return;
        }
        if (parambakw1 != null)
        {
          aysb.a("FtnDownloader", aysb.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_Long + "],Req Serial[" + String.valueOf(parambakw1.a()) + "]");
          return;
        }
      } while (this.jdField_a_of_type_Bakw == null);
      aysb.a("FtnDownloader", aysb.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_Long + "],curRequest Serial[" + String.valueOf(this.jdField_a_of_type_Bakw.a()) + "]");
      return;
      if ((parambakw2.c() != 206) && (parambakw2.c() != 200)) {
        break;
      }
      parambakw1 = parambakw2.a();
      l = parambakw2.a();
      if (this.jdField_b_of_type_Long == 0L) {
        this.jdField_b_of_type_Long = l;
      }
    } while (this.jdField_a_of_type_Ayss == null);
    this.jdField_a_of_type_Ayss.a(parambakw1, l, parambakw2.jdField_c_of_type_JavaLangString);
    return;
    aysb.a("FtnDownloader", aysb.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_Long + "] ftn download decode resp code no 200|206");
  }
  
  public void a(String paramString)
  {
    if (this.jdField_a_of_type_Boolean) {}
    do
    {
      return;
      aysb.a("FtnDownloader", aysb.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_Long + "] ftn download Redirect. " + paramString);
    } while (this.jdField_a_of_type_Ayss == null);
    this.jdField_a_of_type_Ayss.a(paramString);
  }
  
  public boolean a(bakw parambakw1, bakw parambakw2, int paramInt)
  {
    if (5 == paramInt) {
      if (!this.jdField_a_of_type_Boolean) {}
    }
    while ((3 != paramInt) || (this.jdField_a_of_type_Boolean) || (this.jdField_a_of_type_Ayss == null))
    {
      do
      {
        return true;
        this.jdField_a_of_type_Boolean = true;
      } while (this.jdField_a_of_type_Ayss == null);
      this.jdField_a_of_type_Ayss.a();
      return true;
    }
    this.jdField_a_of_type_Ayss.a(parambakw2);
    return true;
  }
  
  public boolean a(String paramString, long paramLong)
  {
    aysb.c("FtnDownloader", aysb.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_Long + "] ftn download url:" + paramString + " pos:" + paramLong);
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    this.jdField_a_of_type_Boolean = false;
    String str2 = "bytes=" + paramLong + "-";
    bakw localbakw = new bakw(paramString, null, this, true);
    localbakw.b(false);
    String str1 = "gprs";
    if (badq.b(BaseApplication.getContext()) == 1) {
      str1 = "wifi";
    }
    localbakw.a("Net-type", str1);
    localbakw.a("cache-control", "no-cache");
    if (paramLong != 0L) {
      localbakw.a("Range", str2);
    }
    localbakw.b(5);
    localbakw.a(true);
    localbakw.jdField_b_of_type_Int = this.jdField_b_of_type_Int;
    localbakw.jdField_c_of_type_Int = this.jdField_a_of_type_Int;
    localbakw.jdField_a_of_type_JavaLangString = String.valueOf(this.jdField_a_of_type_Long);
    localbakw.a("Accept-Encoding", "identity");
    if (this.jdField_a_of_type_Ayss != null) {
      this.jdField_a_of_type_Ayss.b(localbakw);
    }
    str1 = "";
    if (paramString != null) {
      str1 = paramString.toLowerCase();
    }
    if ((this.jdField_b_of_type_Boolean) && (str1.startsWith("https")))
    {
      localbakw.j = true;
      localbakw.k = aojs.a(paramString);
      localbakw.e = this.jdField_a_of_type_JavaLangString;
    }
    localbakw.jdField_a_of_type_Axtz = apck.a();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHttpCommunicatort().a(localbakw);
    this.jdField_a_of_type_Bakw = localbakw;
    return true;
  }
  
  public void b(bakw parambakw1, bakw parambakw2)
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    if (parambakw2 != null)
    {
      a(parambakw2.f, parambakw2.d(), parambakw2.d);
      return;
    }
    a(9001, "err no response", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     aysr
 * JD-Core Version:    0.7.0.1
 */