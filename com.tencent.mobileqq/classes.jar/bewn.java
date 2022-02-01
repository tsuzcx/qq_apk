import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;

public class bewn
  implements bguz
{
  private final int jdField_a_of_type_Int;
  private final long jdField_a_of_type_Long;
  private bewo jdField_a_of_type_Bewo;
  private bgux jdField_a_of_type_Bgux;
  private final QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean = true;
  private final int jdField_b_of_type_Int;
  private long jdField_b_of_type_Long;
  private boolean jdField_b_of_type_Boolean;
  
  public bewn(QQAppInterface paramQQAppInterface, long paramLong1, int paramInt1, int paramInt2, long paramLong2, boolean paramBoolean, String paramString)
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
    if (this.jdField_a_of_type_Bgux != null)
    {
      bevx.c("FtnDownloader", bevx.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_Long + "] cancel ftn download");
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHttpCommunicatort().b(this.jdField_a_of_type_Bgux);
      this.jdField_a_of_type_Bgux = null;
    }
  }
  
  protected void a(int paramInt, String paramString1, String paramString2, bgux parambgux)
  {
    bevx.a("FtnDownloader", bevx.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_Long + "] ftn download err. errCode:" + paramInt + " errMsg:" + paramString1 + " rspHeader:" + paramString2);
    this.jdField_a_of_type_Boolean = true;
    if (this.jdField_a_of_type_Bewo != null) {
      this.jdField_a_of_type_Bewo.a(paramInt, paramString1, paramString2, parambgux);
    }
  }
  
  public void a(bewo parambewo)
  {
    this.jdField_a_of_type_Bewo = parambewo;
  }
  
  public void a(bgux parambgux1, bgux parambgux2)
  {
    if (this.jdField_a_of_type_Boolean) {}
    long l;
    do
    {
      do
      {
        return;
        if (parambgux1 == this.jdField_a_of_type_Bgux) {
          break;
        }
        if ((parambgux1 != null) && (this.jdField_a_of_type_Bgux != null))
        {
          bevx.a("FtnDownloader", bevx.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_Long + "],Req Serial[" + String.valueOf(parambgux1.a()) + "], curRequest Serial[" + String.valueOf(this.jdField_a_of_type_Bgux.a()) + "]");
          return;
        }
        if (parambgux1 != null)
        {
          bevx.a("FtnDownloader", bevx.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_Long + "],Req Serial[" + String.valueOf(parambgux1.a()) + "]");
          return;
        }
      } while (this.jdField_a_of_type_Bgux == null);
      bevx.a("FtnDownloader", bevx.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_Long + "],curRequest Serial[" + String.valueOf(this.jdField_a_of_type_Bgux.a()) + "]");
      return;
      if ((parambgux2.c() != 206) && (parambgux2.c() != 200)) {
        break;
      }
      parambgux1 = parambgux2.a();
      l = parambgux2.a();
      if (this.jdField_b_of_type_Long == 0L) {
        this.jdField_b_of_type_Long = l;
      }
    } while (this.jdField_a_of_type_Bewo == null);
    this.jdField_a_of_type_Bewo.a(parambgux1, l, parambgux2.jdField_c_of_type_JavaLangString);
    return;
    bevx.a("FtnDownloader", bevx.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_Long + "] ftn download decode resp code no 200|206");
  }
  
  public void a(String paramString)
  {
    if (this.jdField_a_of_type_Boolean) {}
    do
    {
      return;
      bevx.a("FtnDownloader", bevx.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_Long + "] ftn download Redirect. " + paramString);
    } while (this.jdField_a_of_type_Bewo == null);
    this.jdField_a_of_type_Bewo.a(paramString);
  }
  
  public boolean a(bgux parambgux1, bgux parambgux2, int paramInt)
  {
    if (5 == paramInt) {
      if (!this.jdField_a_of_type_Boolean) {}
    }
    while ((3 != paramInt) || (this.jdField_a_of_type_Boolean) || (this.jdField_a_of_type_Bewo == null))
    {
      do
      {
        return true;
        this.jdField_a_of_type_Boolean = true;
      } while (this.jdField_a_of_type_Bewo == null);
      this.jdField_a_of_type_Bewo.a();
      return true;
    }
    this.jdField_a_of_type_Bewo.a(parambgux2);
    return true;
  }
  
  public boolean a(String paramString, long paramLong)
  {
    bevx.c("FtnDownloader", bevx.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_Long + "] ftn download url:" + paramString + " pos:" + paramLong);
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    this.jdField_a_of_type_Boolean = false;
    String str2 = "bytes=" + paramLong + "-";
    bgux localbgux = new bgux(paramString, null, this, true);
    localbgux.b(false);
    String str1 = "gprs";
    if (bgnt.b(BaseApplication.getContext()) == 1) {
      str1 = "wifi";
    }
    localbgux.a("Net-type", str1);
    localbgux.a("cache-control", "no-cache");
    if (paramLong != 0L) {
      localbgux.a("Range", str2);
    }
    localbgux.b(5);
    localbgux.a(true);
    localbgux.jdField_b_of_type_Int = this.jdField_b_of_type_Int;
    localbgux.jdField_c_of_type_Int = this.jdField_a_of_type_Int;
    localbgux.jdField_a_of_type_JavaLangString = String.valueOf(this.jdField_a_of_type_Long);
    localbgux.a("Accept-Encoding", "identity");
    if (this.jdField_a_of_type_Bewo != null) {
      this.jdField_a_of_type_Bewo.b(localbgux);
    }
    str1 = "";
    if (paramString != null) {
      str1 = paramString.toLowerCase();
    }
    if ((this.jdField_b_of_type_Boolean) && (str1.startsWith("https")))
    {
      localbgux.i = true;
      localbgux.j = atdx.a(paramString);
      localbgux.e = this.jdField_a_of_type_JavaLangString;
    }
    localbgux.jdField_a_of_type_Bdxx = atvo.a();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHttpCommunicatort().a(localbgux);
    this.jdField_a_of_type_Bgux = localbgux;
    return true;
  }
  
  public void b(bgux parambgux1, bgux parambgux2)
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    if (parambgux2 != null)
    {
      a(parambgux2.f, parambgux2.d(), parambgux2.d, parambgux2);
      return;
    }
    a(9001, "err no response", "", null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bewn
 * JD-Core Version:    0.7.0.1
 */