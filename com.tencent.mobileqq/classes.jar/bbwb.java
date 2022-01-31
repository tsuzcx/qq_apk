import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.httputils.HttpCommunicator;
import com.tencent.qphone.base.util.BaseApplication;

public class bbwb
  implements bdpz
{
  private final int jdField_a_of_type_Int;
  private final long jdField_a_of_type_Long;
  private bbwc jdField_a_of_type_Bbwc;
  private bdpx jdField_a_of_type_Bdpx;
  private final QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean = true;
  private final int jdField_b_of_type_Int;
  private long jdField_b_of_type_Long;
  private boolean jdField_b_of_type_Boolean;
  
  public bbwb(QQAppInterface paramQQAppInterface, long paramLong1, int paramInt1, int paramInt2, long paramLong2, boolean paramBoolean, String paramString)
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
    if (this.jdField_a_of_type_Bdpx != null)
    {
      bbvl.c("FtnDownloader", bbvl.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_Long + "] cancel ftn download");
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHttpCommunicatort().a(this.jdField_a_of_type_Bdpx);
      this.jdField_a_of_type_Bdpx = null;
    }
  }
  
  protected void a(int paramInt, String paramString1, String paramString2, bdpx parambdpx)
  {
    bbvl.a("FtnDownloader", bbvl.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_Long + "] ftn download err. errCode:" + paramInt + " errMsg:" + paramString1 + " rspHeader:" + paramString2);
    this.jdField_a_of_type_Boolean = true;
    if (this.jdField_a_of_type_Bbwc != null) {
      this.jdField_a_of_type_Bbwc.a(paramInt, paramString1, paramString2, parambdpx);
    }
  }
  
  public void a(bbwc parambbwc)
  {
    this.jdField_a_of_type_Bbwc = parambbwc;
  }
  
  public void a(bdpx parambdpx1, bdpx parambdpx2)
  {
    if (this.jdField_a_of_type_Boolean) {}
    long l;
    do
    {
      do
      {
        return;
        if (parambdpx1 == this.jdField_a_of_type_Bdpx) {
          break;
        }
        if ((parambdpx1 != null) && (this.jdField_a_of_type_Bdpx != null))
        {
          bbvl.a("FtnDownloader", bbvl.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_Long + "],Req Serial[" + String.valueOf(parambdpx1.a()) + "], curRequest Serial[" + String.valueOf(this.jdField_a_of_type_Bdpx.a()) + "]");
          return;
        }
        if (parambdpx1 != null)
        {
          bbvl.a("FtnDownloader", bbvl.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_Long + "],Req Serial[" + String.valueOf(parambdpx1.a()) + "]");
          return;
        }
      } while (this.jdField_a_of_type_Bdpx == null);
      bbvl.a("FtnDownloader", bbvl.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_Long + "],curRequest Serial[" + String.valueOf(this.jdField_a_of_type_Bdpx.a()) + "]");
      return;
      if ((parambdpx2.c() != 206) && (parambdpx2.c() != 200)) {
        break;
      }
      parambdpx1 = parambdpx2.a();
      l = parambdpx2.a();
      if (this.jdField_b_of_type_Long == 0L) {
        this.jdField_b_of_type_Long = l;
      }
    } while (this.jdField_a_of_type_Bbwc == null);
    this.jdField_a_of_type_Bbwc.a(parambdpx1, l, parambdpx2.jdField_c_of_type_JavaLangString);
    return;
    bbvl.a("FtnDownloader", bbvl.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_Long + "] ftn download decode resp code no 200|206");
  }
  
  public void a(String paramString)
  {
    if (this.jdField_a_of_type_Boolean) {}
    do
    {
      return;
      bbvl.a("FtnDownloader", bbvl.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_Long + "] ftn download Redirect. " + paramString);
    } while (this.jdField_a_of_type_Bbwc == null);
    this.jdField_a_of_type_Bbwc.a(paramString);
  }
  
  public boolean a(bdpx parambdpx1, bdpx parambdpx2, int paramInt)
  {
    if (5 == paramInt) {
      if (!this.jdField_a_of_type_Boolean) {}
    }
    while ((3 != paramInt) || (this.jdField_a_of_type_Boolean) || (this.jdField_a_of_type_Bbwc == null))
    {
      do
      {
        return true;
        this.jdField_a_of_type_Boolean = true;
      } while (this.jdField_a_of_type_Bbwc == null);
      this.jdField_a_of_type_Bbwc.a();
      return true;
    }
    this.jdField_a_of_type_Bbwc.a(parambdpx2);
    return true;
  }
  
  public boolean a(String paramString, long paramLong)
  {
    bbvl.c("FtnDownloader", bbvl.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_Long + "] ftn download url:" + paramString + " pos:" + paramLong);
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    this.jdField_a_of_type_Boolean = false;
    String str2 = "bytes=" + paramLong + "-";
    bdpx localbdpx = new bdpx(paramString, null, this, true);
    localbdpx.b(false);
    String str1 = "gprs";
    if (bdin.b(BaseApplication.getContext()) == 1) {
      str1 = "wifi";
    }
    localbdpx.a("Net-type", str1);
    localbdpx.a("cache-control", "no-cache");
    if (paramLong != 0L) {
      localbdpx.a("Range", str2);
    }
    localbdpx.b(5);
    localbdpx.a(true);
    localbdpx.jdField_b_of_type_Int = this.jdField_b_of_type_Int;
    localbdpx.jdField_c_of_type_Int = this.jdField_a_of_type_Int;
    localbdpx.jdField_a_of_type_JavaLangString = String.valueOf(this.jdField_a_of_type_Long);
    localbdpx.a("Accept-Encoding", "identity");
    if (this.jdField_a_of_type_Bbwc != null) {
      this.jdField_a_of_type_Bbwc.b(localbdpx);
    }
    str1 = "";
    if (paramString != null) {
      str1 = paramString.toLowerCase();
    }
    if ((this.jdField_b_of_type_Boolean) && (str1.startsWith("https")))
    {
      localbdpx.j = true;
      localbdpx.k = aqxx.a(paramString);
      localbdpx.e = this.jdField_a_of_type_JavaLangString;
    }
    localbdpx.jdField_a_of_type_Bawq = arrr.a();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHttpCommunicatort().a(localbdpx);
    this.jdField_a_of_type_Bdpx = localbdpx;
    return true;
  }
  
  public void b(bdpx parambdpx1, bdpx parambdpx2)
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    if (parambdpx2 != null)
    {
      a(parambdpx2.f, parambdpx2.d(), parambdpx2.d, parambdpx2);
      return;
    }
    a(9001, "err no response", "", null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbwb
 * JD-Core Version:    0.7.0.1
 */