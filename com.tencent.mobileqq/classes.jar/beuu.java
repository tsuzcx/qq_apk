import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import mqq.manager.ProxyIpManager;

public class beuu
  extends beru
{
  public beuu(beyb parambeyb, beyg parambeyg)
  {
    super(parambeyb, parambeyg);
    this.jdField_a_of_type_JavaUtilList = ((ProxyIpManager)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getManager(3)).getProxyIp(4);
  }
  
  private void b(boolean paramBoolean)
  {
    if (!paramBoolean) {
      d(1001);
    }
    this.jdField_a_of_type_Bete.a();
    if ((this.jdField_b_of_type_ArrayOfByte == null) && (!h()))
    {
      d();
      return;
    }
    if (this.jdField_b_of_type_JavaIoRandomAccessFile == null) {
      try
      {
        this.jdField_b_of_type_JavaIoRandomAccessFile = new RandomAccessFile(this.jdField_a_of_type_Beyg.i, "r");
        if (this.jdField_b_of_type_JavaIoRandomAccessFile == null)
        {
          b(9303, "read file error");
          d();
          return;
        }
      }
      catch (FileNotFoundException localFileNotFoundException)
      {
        for (;;)
        {
          localFileNotFoundException.printStackTrace();
          this.jdField_b_of_type_JavaIoRandomAccessFile = null;
        }
      }
    }
    f();
  }
  
  private int d()
  {
    b("uiParam", this.jdField_a_of_type_Beyg.toString());
    String str = this.jdField_a_of_type_Beyg.i;
    if ((str == null) || ("".equals(str)))
    {
      b(9302, a(new Exception("filePath null")));
      d();
      return -1;
    }
    if (str != null)
    {
      File localFile = new File(str);
      if (!localFile.exists())
      {
        b(9042, a(new Exception("sendFile not exist " + str)));
        d();
        return -1;
      }
      if (!localFile.canRead())
      {
        b(9070, a(new Exception("sendFile not readable " + this.jdField_a_of_type_Bete.jdField_c_of_type_JavaLangString)));
        d();
        return -1;
      }
      this.e = "amr";
      long l = localFile.length();
      this.jdField_a_of_type_Bete.a = l;
      this.q = l;
      if (l <= 0L)
      {
        b(9071, a(new Exception("file size 0 " + str)));
        d();
        return -1;
      }
    }
    return 0;
  }
  
  protected String a(byte[] paramArrayOfByte)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    bewy localbewy = (bewy)this.jdField_a_of_type_JavaUtilArrayList.get(0);
    localStringBuilder.append("http://");
    localStringBuilder.append(localbewy.jdField_a_of_type_JavaLangString);
    if (localbewy.jdField_a_of_type_Int != 80)
    {
      localStringBuilder.append(":");
      localStringBuilder.append(localbewy.jdField_a_of_type_Int);
    }
    localStringBuilder.append("/qqcommfileupload?ver=");
    localStringBuilder.append(100);
    localStringBuilder.append("&ukey=");
    localStringBuilder.append(this.jdField_m_of_type_JavaLangString);
    localStringBuilder.append("&filekey=");
    localStringBuilder.append(this.jdField_c_of_type_JavaLangString);
    localStringBuilder.append("&filesize=");
    localStringBuilder.append(this.q);
    localStringBuilder.append("&bmd5=");
    localStringBuilder.append(MD5.toMD5(paramArrayOfByte));
    localStringBuilder.append("&range=");
    localStringBuilder.append(this.s);
    localStringBuilder.append("&voice_codec=0");
    paramArrayOfByte = a(localStringBuilder.toString(), this.jdField_a_of_type_JavaUtilArrayList);
    berp.a(this.jdField_a_of_type_JavaUtilList, this.jdField_a_of_type_JavaUtilArrayList);
    return paramArrayOfByte;
  }
  
  public void a(bfau parambfau, bfbj parambfbj)
  {
    this.jdField_a_of_type_Bfau = null;
    if (parambfbj != null)
    {
      int i = 0;
      if (i < parambfbj.jdField_a_of_type_JavaUtilList.size())
      {
        parambfau = (bfbn)parambfbj.jdField_a_of_type_JavaUtilList.get(i);
        if (QLog.isColorLevel()) {
          b("procUrl", parambfau.toString());
        }
        this.k = parambfau.d;
        if (QLog.isColorLevel()) {
          QLog.e("http_sideway", 2, "JSPttUpProcessor.onBusiProtoResp:isSendByQuickHttp=" + this.k);
        }
        a(this.jdField_a_of_type_Berr, parambfau);
        if (parambfau.jdField_c_of_type_Int == 0)
        {
          if (parambfau.jdField_a_of_type_Boolean) {
            this.f = parambfau.jdField_a_of_type_JavaLangString;
          }
          for (;;)
          {
            i += 1;
            break;
            this.f = parambfau.jdField_a_of_type_JavaLangString;
            this.jdField_m_of_type_JavaLangString = parambfau.b;
            this.jdField_a_of_type_JavaUtilArrayList = parambfau.jdField_a_of_type_JavaUtilArrayList;
            this.s = 0L;
            this.jdField_t_of_type_Long = parambfau.jdField_a_of_type_Int;
            tyl.c(this.f);
            aL_();
          }
        }
        d();
      }
    }
  }
  
  public void aN_()
  {
    super.aN_();
    b(false);
  }
  
  public int c()
  {
    super.c();
    return d();
  }
  
  void d()
  {
    super.d();
    d(1005);
    a(false);
  }
  
  void e()
  {
    super.e();
    d(1003);
    a(true);
  }
  
  void f()
  {
    this.jdField_a_of_type_Berr.a();
    bfau localbfau = new bfau();
    bfbe localbfbe = new bfbe();
    localbfbe.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_Beyg.b;
    localbfbe.jdField_d_of_type_JavaLangString = this.jdField_a_of_type_Beyg.jdField_c_of_type_JavaLangString;
    localbfbe.e = this.jdField_a_of_type_Beyg.jdField_d_of_type_JavaLangString;
    localbfbe.f = this.jdField_a_of_type_Beyg.jdField_a_of_type_Int;
    localbfbe.jdField_a_of_type_JavaLangString = this.jdField_d_of_type_JavaLangString;
    localbfbe.b = ((int)this.q);
    localbfbe.jdField_a_of_type_ArrayOfByte = this.jdField_b_of_type_ArrayOfByte;
    localbfbe.jdField_c_of_type_Int = 0;
    localbfbe.jdField_a_of_type_Int = 1;
    localbfbe.jdField_d_of_type_Int = this.jdField_a_of_type_Beyg.n;
    localbfau.jdField_a_of_type_Bfcb = this;
    localbfau.jdField_a_of_type_JavaLangString = "c2c_ptt_up";
    localbfau.jdField_a_of_type_JavaUtilList.add(localbfbe);
    localbfau.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getProtoReqManager();
    if (!e())
    {
      a(9366, "illegal app", null, this.jdField_a_of_type_Berr);
      d();
    }
    do
    {
      return;
      if (QLog.isColorLevel()) {
        b("requestStart", localbfau.toString());
      }
    } while (!f());
    this.jdField_a_of_type_Bfau = localbfau;
    bfca.a(localbfau);
  }
  
  protected void o()
  {
    if ((this.jdField_a_of_type_Bevl != null) && ((this.jdField_a_of_type_Bevl instanceof beum))) {
      ((beum)this.jdField_a_of_type_Bevl).jdField_a_of_type_JavaLangString = MsfSdkUtils.insertMtype("pttCu", ((beum)this.jdField_a_of_type_Bevl).jdField_a_of_type_JavaLangString);
    }
  }
  
  public void onResp(bevm parambevm)
  {
    Object localObject1 = null;
    super.onResp(parambevm);
    this.jdField_a_of_type_Bevl = null;
    int i = parambevm.jdField_c_of_type_Int;
    for (;;)
    {
      long l2;
      try
      {
        if (parambevm.jdField_a_of_type_Int != 0) {
          break label505;
        }
        if (parambevm.jdField_a_of_type_JavaUtilHashMap.get("User-ReturnCode") == null) {
          break label579;
        }
        l3 = Long.parseLong((String)parambevm.jdField_a_of_type_JavaUtilHashMap.get("User-ReturnCode"));
        if ((l3 != 0L) && (l3 != 9223372036854775807L))
        {
          a(this.jdField_b_of_type_Berr, parambevm, false);
          a(-9527, null, a(i, l3), this.jdField_b_of_type_Berr);
          d();
          return;
        }
        str2 = (String)parambevm.jdField_a_of_type_JavaUtilHashMap.get("Range");
        if (str2 == null) {
          break label587;
        }
      }
      catch (Exception parambevm)
      {
        String str2;
        String str1;
        a(9343, bera.a(new Exception("decode unknown exception")), "", this.jdField_b_of_type_Berr);
        d();
        return;
      }
      try
      {
        i = Integer.parseInt(str2);
        l1 = i;
        l2 = l1;
        if (l1 == 9223372036854775807L)
        {
          str1 = (String)parambevm.jdField_a_of_type_JavaUtilHashMap.get("X-Range");
          localObject1 = str1;
          l2 = l1;
          if (str1 == null) {}
        }
      }
      catch (Exception localException2)
      {
        localException2.printStackTrace();
      }
      try
      {
        i = Integer.parseInt(str1);
        l2 = i;
        localObject1 = str1;
      }
      catch (Exception localException1)
      {
        localException1.printStackTrace();
        l2 = 9223372036854775807L;
        Object localObject2 = localException2;
        continue;
        b("decodeHttpResp", "from " + this.s + " to " + l2 + " userReturnCode:" + l3);
        if (l2 > this.s) {
          break label420;
        }
        if (this.jdField_t_of_type_Int >= 3) {
          break label460;
        }
        b("procHttpRespBody", "server offset rollback");
        this.jdField_t_of_type_Int += 1;
        this.jdField_a_of_type_Bete.e = l2;
        this.s = l2;
        a(this.jdField_b_of_type_Berr, parambevm, true);
        if (l2 >= this.q) {
          break label500;
        }
        aL_();
        return;
        a(this.jdField_b_of_type_Berr, parambevm, false);
        a(-9527, "", a(this.jdField_h_of_type_JavaLangString, this.g), this.jdField_b_of_type_Berr);
        d();
        return;
        e();
        return;
      }
      if (l2 == 9223372036854775807L)
      {
        a(this.jdField_b_of_type_Berr, parambevm, false);
        a(-9527, "no header range:" + str2 + " x-range:" + localObject1, a(this.jdField_h_of_type_JavaLangString, this.jdField_h_of_type_Int), this.jdField_b_of_type_Berr);
        bewa.b(true);
        d();
        return;
      }
      label420:
      label460:
      label500:
      label505:
      if ((parambevm.b == 9364) && (this.jdField_m_of_type_Int < 3))
      {
        b("[netChg]", "failed.but net change detect.so retry");
        this.jdField_m_of_type_Int += 1;
        n();
        f();
        return;
      }
      a(this.jdField_b_of_type_Berr, parambevm, false);
      b(parambevm.b, parambevm.jdField_a_of_type_JavaLangString);
      d();
      return;
      label579:
      long l3 = 9223372036854775807L;
      continue;
      label587:
      long l1 = 9223372036854775807L;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     beuu
 * JD-Core Version:    0.7.0.1
 */