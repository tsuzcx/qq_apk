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

public class aysd
  extends aype
{
  public aysd(ayvv paramayvv, aywa paramaywa)
  {
    super(paramayvv, paramaywa);
    this.jdField_a_of_type_JavaUtilList = ((ProxyIpManager)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getManager(3)).getProxyIp(4);
  }
  
  private void b(boolean paramBoolean)
  {
    if (!paramBoolean) {
      d(1001);
    }
    this.jdField_a_of_type_Ayqm.a();
    if ((this.jdField_a_of_type_ArrayOfByte == null) && (!j()))
    {
      d();
      return;
    }
    if (this.jdField_a_of_type_JavaIoRandomAccessFile == null) {
      try
      {
        this.jdField_a_of_type_JavaIoRandomAccessFile = new RandomAccessFile(this.jdField_a_of_type_Aywa.i, "r");
        if (this.jdField_a_of_type_JavaIoRandomAccessFile == null)
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
          this.jdField_a_of_type_JavaIoRandomAccessFile = null;
        }
      }
    }
    f();
  }
  
  private int d()
  {
    b("uiParam", this.jdField_a_of_type_Aywa.toString());
    String str = this.jdField_a_of_type_Aywa.i;
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
        b(9070, a(new Exception("sendFile not readable " + this.jdField_a_of_type_Ayqm.jdField_c_of_type_JavaLangString)));
        d();
        return -1;
      }
      this.e = "amr";
      long l = localFile.length();
      this.jdField_a_of_type_Ayqm.a = l;
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
    ayuo localayuo = (ayuo)this.jdField_a_of_type_JavaUtilArrayList.get(0);
    localStringBuilder.append("http://");
    localStringBuilder.append(localayuo.jdField_a_of_type_JavaLangString);
    if (localayuo.jdField_a_of_type_Int != 80)
    {
      localStringBuilder.append(":");
      localStringBuilder.append(localayuo.jdField_a_of_type_Int);
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
    ayoz.a(this.jdField_a_of_type_JavaUtilList, this.jdField_a_of_type_JavaUtilArrayList);
    return paramArrayOfByte;
  }
  
  public void a(ayyn paramayyn, ayzc paramayzc)
  {
    this.jdField_a_of_type_Ayyn = null;
    if (paramayzc != null)
    {
      int i = 0;
      if (i < paramayzc.jdField_a_of_type_JavaUtilList.size())
      {
        paramayyn = (ayzg)paramayzc.jdField_a_of_type_JavaUtilList.get(i);
        if (QLog.isColorLevel()) {
          b("procUrl", paramayyn.toString());
        }
        this.i = paramayyn.d;
        if (QLog.isColorLevel()) {
          QLog.e("http_sideway", 2, "JSPttUpProcessor.onBusiProtoResp:isSendByQuickHttp=" + this.i);
        }
        a(this.jdField_a_of_type_Aypb, paramayyn);
        if (paramayyn.jdField_c_of_type_Int == 0)
        {
          if (paramayyn.jdField_a_of_type_Boolean) {
            this.jdField_f_of_type_JavaLangString = paramayyn.jdField_a_of_type_JavaLangString;
          }
          for (;;)
          {
            i += 1;
            break;
            this.jdField_f_of_type_JavaLangString = paramayyn.jdField_a_of_type_JavaLangString;
            this.m = paramayyn.b;
            this.jdField_a_of_type_JavaUtilArrayList = paramayyn.jdField_a_of_type_JavaUtilArrayList;
            this.s = 0L;
            this.jdField_t_of_type_Long = paramayyn.jdField_a_of_type_Int;
            sfk.c(this.jdField_f_of_type_JavaLangString);
            aP_();
          }
        }
        d();
      }
    }
  }
  
  public void aR_()
  {
    super.aR_();
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
    this.jdField_a_of_type_Aypb.a();
    ayyn localayyn = new ayyn();
    ayyx localayyx = new ayyx();
    localayyx.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_Aywa.b;
    localayyx.jdField_d_of_type_JavaLangString = this.jdField_a_of_type_Aywa.jdField_c_of_type_JavaLangString;
    localayyx.e = this.jdField_a_of_type_Aywa.jdField_d_of_type_JavaLangString;
    localayyx.jdField_f_of_type_Int = this.jdField_a_of_type_Aywa.jdField_a_of_type_Int;
    localayyx.jdField_a_of_type_JavaLangString = this.jdField_d_of_type_JavaLangString;
    localayyx.b = ((int)this.q);
    localayyx.jdField_a_of_type_ArrayOfByte = this.jdField_a_of_type_ArrayOfByte;
    localayyx.jdField_c_of_type_Int = 0;
    localayyx.jdField_a_of_type_Int = 1;
    localayyx.jdField_d_of_type_Int = this.jdField_a_of_type_Aywa.n;
    localayyn.jdField_a_of_type_Ayzu = this;
    localayyn.jdField_a_of_type_JavaLangString = "c2c_ptt_up";
    localayyn.jdField_a_of_type_JavaUtilList.add(localayyx);
    localayyn.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getProtoReqManager();
    if (!e())
    {
      a(9366, "illegal app", null, this.jdField_a_of_type_Aypb);
      d();
    }
    do
    {
      return;
      if (QLog.isColorLevel()) {
        b("requestStart", localayyn.toString());
      }
    } while (!f());
    this.jdField_a_of_type_Ayyn = localayyn;
    ayzt.a(localayyn);
  }
  
  protected void n()
  {
    if ((this.jdField_a_of_type_Aysw != null) && ((this.jdField_a_of_type_Aysw instanceof ayrv))) {
      ((ayrv)this.jdField_a_of_type_Aysw).jdField_a_of_type_JavaLangString = MsfSdkUtils.insertMtype("pttCu", ((ayrv)this.jdField_a_of_type_Aysw).jdField_a_of_type_JavaLangString);
    }
  }
  
  public void onResp(aysx paramaysx)
  {
    Object localObject1 = null;
    super.onResp(paramaysx);
    this.jdField_a_of_type_Aysw = null;
    int i = paramaysx.jdField_c_of_type_Int;
    for (;;)
    {
      long l2;
      try
      {
        if (paramaysx.jdField_a_of_type_Int != 0) {
          break label505;
        }
        if (paramaysx.jdField_a_of_type_JavaUtilHashMap.get("User-ReturnCode") == null) {
          break label579;
        }
        l3 = Long.parseLong((String)paramaysx.jdField_a_of_type_JavaUtilHashMap.get("User-ReturnCode"));
        if ((l3 != 0L) && (l3 != 9223372036854775807L))
        {
          a(this.b, paramaysx, false);
          a(-9527, null, a(i, l3), this.b);
          d();
          return;
        }
        str2 = (String)paramaysx.jdField_a_of_type_JavaUtilHashMap.get("Range");
        if (str2 == null) {
          break label587;
        }
      }
      catch (Exception paramaysx)
      {
        String str2;
        String str1;
        a(9343, ayoh.a(new Exception("decode unknown exception")), "", this.b);
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
          str1 = (String)paramaysx.jdField_a_of_type_JavaUtilHashMap.get("X-Range");
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
        this.jdField_a_of_type_Ayqm.e = l2;
        this.s = l2;
        a(this.b, paramaysx, true);
        if (l2 >= this.q) {
          break label500;
        }
        aP_();
        return;
        a(this.b, paramaysx, false);
        a(-9527, "", a(this.h, this.jdField_f_of_type_Int), this.b);
        d();
        return;
        e();
        return;
      }
      if (l2 == 9223372036854775807L)
      {
        a(this.b, paramaysx, false);
        a(-9527, "no header range:" + str2 + " x-range:" + localObject1, a(this.h, this.g), this.b);
        aytl.b(true);
        d();
        return;
      }
      label420:
      label460:
      label500:
      label505:
      if ((paramaysx.b == 9364) && (this.l < 3))
      {
        b("[netChg]", "failed.but net change detect.so retry");
        this.l += 1;
        m();
        f();
        return;
      }
      a(this.b, paramaysx, false);
      b(paramaysx.b, paramaysx.jdField_a_of_type_JavaLangString);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     aysd
 * JD-Core Version:    0.7.0.1
 */