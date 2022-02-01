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

public class bdwb
  extends bdtc
{
  public bdwb(bdzi parambdzi, bdzn parambdzn)
  {
    super(parambdzi, parambdzn);
    this.jdField_a_of_type_JavaUtilList = ((ProxyIpManager)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getManager(3)).getProxyIp(4);
  }
  
  private void b(boolean paramBoolean)
  {
    if (!paramBoolean) {
      d(1001);
    }
    this.jdField_a_of_type_Bduk.a();
    if ((this.jdField_b_of_type_ArrayOfByte == null) && (!h()))
    {
      d();
      return;
    }
    if (this.jdField_b_of_type_JavaIoRandomAccessFile == null) {
      try
      {
        this.jdField_b_of_type_JavaIoRandomAccessFile = new RandomAccessFile(this.jdField_a_of_type_Bdzn.i, "r");
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
    b("uiParam", this.jdField_a_of_type_Bdzn.toString());
    String str = this.jdField_a_of_type_Bdzn.i;
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
        b(9070, a(new Exception("sendFile not readable " + this.jdField_a_of_type_Bduk.jdField_c_of_type_JavaLangString)));
        d();
        return -1;
      }
      this.e = "amr";
      long l = localFile.length();
      this.jdField_a_of_type_Bduk.a = l;
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
    bdyf localbdyf = (bdyf)this.jdField_a_of_type_JavaUtilArrayList.get(0);
    localStringBuilder.append("http://");
    localStringBuilder.append(localbdyf.jdField_a_of_type_JavaLangString);
    if (localbdyf.jdField_a_of_type_Int != 80)
    {
      localStringBuilder.append(":");
      localStringBuilder.append(localbdyf.jdField_a_of_type_Int);
    }
    localStringBuilder.append("/qqcommfileupload?ver=");
    localStringBuilder.append(100);
    localStringBuilder.append("&ukey=");
    localStringBuilder.append(this.m);
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
    bdsx.a(this.jdField_a_of_type_JavaUtilList, this.jdField_a_of_type_JavaUtilArrayList);
    return paramArrayOfByte;
  }
  
  public void a(bebv parambebv, beck parambeck)
  {
    this.jdField_a_of_type_Bebv = null;
    if (parambeck != null)
    {
      int i = 0;
      if (i < parambeck.jdField_a_of_type_JavaUtilList.size())
      {
        parambebv = (beco)parambeck.jdField_a_of_type_JavaUtilList.get(i);
        if (QLog.isColorLevel()) {
          b("procUrl", parambebv.toString());
        }
        this.k = parambebv.d;
        if (QLog.isColorLevel()) {
          QLog.e("http_sideway", 2, "JSPttUpProcessor.onBusiProtoResp:isSendByQuickHttp=" + this.k);
        }
        a(this.jdField_a_of_type_Bdsz, parambebv);
        if (parambebv.jdField_c_of_type_Int == 0)
        {
          if (parambebv.jdField_a_of_type_Boolean) {
            this.jdField_f_of_type_JavaLangString = parambebv.jdField_a_of_type_JavaLangString;
          }
          for (;;)
          {
            i += 1;
            break;
            this.jdField_f_of_type_JavaLangString = parambebv.jdField_a_of_type_JavaLangString;
            this.m = parambebv.b;
            this.jdField_a_of_type_JavaUtilArrayList = parambebv.jdField_a_of_type_JavaUtilArrayList;
            this.s = 0L;
            this.jdField_t_of_type_Long = parambebv.jdField_a_of_type_Int;
            tyj.c(this.jdField_f_of_type_JavaLangString);
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
    this.jdField_a_of_type_Bdsz.a();
    bebv localbebv = new bebv();
    becf localbecf = new becf();
    localbecf.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_Bdzn.b;
    localbecf.jdField_d_of_type_JavaLangString = this.jdField_a_of_type_Bdzn.jdField_c_of_type_JavaLangString;
    localbecf.e = this.jdField_a_of_type_Bdzn.jdField_d_of_type_JavaLangString;
    localbecf.jdField_f_of_type_Int = this.jdField_a_of_type_Bdzn.jdField_a_of_type_Int;
    localbecf.jdField_a_of_type_JavaLangString = this.jdField_d_of_type_JavaLangString;
    localbecf.b = ((int)this.q);
    localbecf.jdField_a_of_type_ArrayOfByte = this.jdField_b_of_type_ArrayOfByte;
    localbecf.jdField_c_of_type_Int = 0;
    localbecf.jdField_a_of_type_Int = 1;
    localbecf.jdField_d_of_type_Int = this.jdField_a_of_type_Bdzn.n;
    localbebv.jdField_a_of_type_Bedc = this;
    localbebv.jdField_a_of_type_JavaLangString = "c2c_ptt_up";
    localbebv.jdField_a_of_type_JavaUtilList.add(localbecf);
    localbebv.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getProtoReqManager();
    if (!e())
    {
      a(9366, "illegal app", null, this.jdField_a_of_type_Bdsz);
      d();
    }
    do
    {
      return;
      if (QLog.isColorLevel()) {
        b("requestStart", localbebv.toString());
      }
    } while (!f());
    this.jdField_a_of_type_Bebv = localbebv;
    bedb.a(localbebv);
  }
  
  protected void o()
  {
    if ((this.jdField_a_of_type_Bdws != null) && ((this.jdField_a_of_type_Bdws instanceof bdvs))) {
      ((bdvs)this.jdField_a_of_type_Bdws).jdField_a_of_type_JavaLangString = MsfSdkUtils.insertMtype("pttCu", ((bdvs)this.jdField_a_of_type_Bdws).jdField_a_of_type_JavaLangString);
    }
  }
  
  public void onResp(bdwt parambdwt)
  {
    Object localObject1 = null;
    super.onResp(parambdwt);
    this.jdField_a_of_type_Bdws = null;
    int i = parambdwt.jdField_c_of_type_Int;
    for (;;)
    {
      long l2;
      try
      {
        if (parambdwt.jdField_a_of_type_Int != 0) {
          break label505;
        }
        if (parambdwt.jdField_a_of_type_JavaUtilHashMap.get("User-ReturnCode") == null) {
          break label579;
        }
        l3 = Long.parseLong((String)parambdwt.jdField_a_of_type_JavaUtilHashMap.get("User-ReturnCode"));
        if ((l3 != 0L) && (l3 != 9223372036854775807L))
        {
          a(this.jdField_b_of_type_Bdsz, parambdwt, false);
          a(-9527, null, a(i, l3), this.jdField_b_of_type_Bdsz);
          d();
          return;
        }
        str2 = (String)parambdwt.jdField_a_of_type_JavaUtilHashMap.get("Range");
        if (str2 == null) {
          break label587;
        }
      }
      catch (Exception parambdwt)
      {
        String str2;
        String str1;
        a(9343, bdsi.a(new Exception("decode unknown exception")), "", this.jdField_b_of_type_Bdsz);
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
          str1 = (String)parambdwt.jdField_a_of_type_JavaUtilHashMap.get("X-Range");
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
        this.jdField_a_of_type_Bduk.e = l2;
        this.s = l2;
        a(this.jdField_b_of_type_Bdsz, parambdwt, true);
        if (l2 >= this.q) {
          break label500;
        }
        aL_();
        return;
        a(this.jdField_b_of_type_Bdsz, parambdwt, false);
        a(-9527, "", a(this.h, this.jdField_f_of_type_Int), this.jdField_b_of_type_Bdsz);
        d();
        return;
        e();
        return;
      }
      if (l2 == 9223372036854775807L)
      {
        a(this.jdField_b_of_type_Bdsz, parambdwt, false);
        a(-9527, "no header range:" + str2 + " x-range:" + localObject1, a(this.h, this.g), this.jdField_b_of_type_Bdsz);
        bdxh.b(true);
        d();
        return;
      }
      label420:
      label460:
      label500:
      label505:
      if ((parambdwt.b == 9364) && (this.l < 3))
      {
        b("[netChg]", "failed.but net change detect.so retry");
        this.l += 1;
        n();
        f();
        return;
      }
      a(this.jdField_b_of_type_Bdsz, parambdwt, false);
      b(parambdwt.b, parambdwt.jdField_a_of_type_JavaLangString);
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
 * Qualified Name:     bdwb
 * JD-Core Version:    0.7.0.1
 */