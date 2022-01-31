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

public class axrw
  extends axox
{
  public axrw(axvo paramaxvo, axvt paramaxvt)
  {
    super(paramaxvo, paramaxvt);
    this.jdField_a_of_type_JavaUtilList = ((ProxyIpManager)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getManager(3)).getProxyIp(4);
  }
  
  private void b(boolean paramBoolean)
  {
    if (!paramBoolean) {
      d(1001);
    }
    this.jdField_a_of_type_Axqf.a();
    if ((this.jdField_a_of_type_ArrayOfByte == null) && (!j()))
    {
      d();
      return;
    }
    if (this.jdField_a_of_type_JavaIoRandomAccessFile == null) {
      try
      {
        this.jdField_a_of_type_JavaIoRandomAccessFile = new RandomAccessFile(this.jdField_a_of_type_Axvt.i, "r");
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
    b("uiParam", this.jdField_a_of_type_Axvt.toString());
    String str = this.jdField_a_of_type_Axvt.i;
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
        b(9070, a(new Exception("sendFile not readable " + this.jdField_a_of_type_Axqf.jdField_c_of_type_JavaLangString)));
        d();
        return -1;
      }
      this.e = "amr";
      long l = localFile.length();
      this.jdField_a_of_type_Axqf.a = l;
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
    axuh localaxuh = (axuh)this.jdField_a_of_type_JavaUtilArrayList.get(0);
    localStringBuilder.append("http://");
    localStringBuilder.append(localaxuh.jdField_a_of_type_JavaLangString);
    if (localaxuh.jdField_a_of_type_Int != 80)
    {
      localStringBuilder.append(":");
      localStringBuilder.append(localaxuh.jdField_a_of_type_Int);
    }
    localStringBuilder.append("/qqcommfileupload?ver=");
    localStringBuilder.append(100);
    localStringBuilder.append("&ukey=");
    localStringBuilder.append(this.jdField_l_of_type_JavaLangString);
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
    axou.a(this.jdField_a_of_type_JavaUtilList, this.jdField_a_of_type_JavaUtilArrayList);
    return paramArrayOfByte;
  }
  
  public void a(axyg paramaxyg, axyv paramaxyv)
  {
    this.jdField_a_of_type_Axyg = null;
    if (paramaxyv != null)
    {
      int i = 0;
      if (i < paramaxyv.jdField_a_of_type_JavaUtilList.size())
      {
        paramaxyg = (axyz)paramaxyv.jdField_a_of_type_JavaUtilList.get(i);
        if (QLog.isColorLevel()) {
          b("procUrl", paramaxyg.toString());
        }
        this.i = paramaxyg.d;
        if (QLog.isColorLevel()) {
          QLog.e("http_sideway", 2, "JSPttUpProcessor.onBusiProtoResp:isSendByQuickHttp=" + this.i);
        }
        a(this.jdField_a_of_type_Axow, paramaxyg);
        if (paramaxyg.jdField_c_of_type_Int == 0)
        {
          if (paramaxyg.jdField_a_of_type_Boolean) {
            this.jdField_f_of_type_JavaLangString = paramaxyg.jdField_a_of_type_JavaLangString;
          }
          for (;;)
          {
            i += 1;
            break;
            this.jdField_f_of_type_JavaLangString = paramaxyg.jdField_a_of_type_JavaLangString;
            this.jdField_l_of_type_JavaLangString = paramaxyg.b;
            this.jdField_a_of_type_JavaUtilArrayList = paramaxyg.jdField_a_of_type_JavaUtilArrayList;
            this.s = 0L;
            this.jdField_t_of_type_Long = paramaxyg.jdField_a_of_type_Int;
            rss.c(this.jdField_f_of_type_JavaLangString);
            aS_();
          }
        }
        d();
      }
    }
  }
  
  public void aU_()
  {
    super.aU_();
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
    this.jdField_a_of_type_Axow.a();
    axyg localaxyg = new axyg();
    axyq localaxyq = new axyq();
    localaxyq.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_Axvt.b;
    localaxyq.jdField_d_of_type_JavaLangString = this.jdField_a_of_type_Axvt.jdField_c_of_type_JavaLangString;
    localaxyq.e = this.jdField_a_of_type_Axvt.jdField_d_of_type_JavaLangString;
    localaxyq.jdField_f_of_type_Int = this.jdField_a_of_type_Axvt.jdField_a_of_type_Int;
    localaxyq.jdField_a_of_type_JavaLangString = this.jdField_d_of_type_JavaLangString;
    localaxyq.b = ((int)this.q);
    localaxyq.jdField_a_of_type_ArrayOfByte = this.jdField_a_of_type_ArrayOfByte;
    localaxyq.jdField_c_of_type_Int = 0;
    localaxyq.jdField_a_of_type_Int = 1;
    localaxyq.jdField_d_of_type_Int = this.jdField_a_of_type_Axvt.n;
    localaxyg.jdField_a_of_type_Axzn = this;
    localaxyg.jdField_a_of_type_JavaLangString = "c2c_ptt_up";
    localaxyg.jdField_a_of_type_JavaUtilList.add(localaxyq);
    localaxyg.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getProtoReqManager();
    if (!e())
    {
      a(9366, "illegal app", null, this.jdField_a_of_type_Axow);
      d();
    }
    do
    {
      return;
      if (QLog.isColorLevel()) {
        b("requestStart", localaxyg.toString());
      }
    } while (!f());
    this.jdField_a_of_type_Axyg = localaxyg;
    axzm.a(localaxyg);
  }
  
  protected void n()
  {
    if ((this.jdField_a_of_type_Axsp != null) && ((this.jdField_a_of_type_Axsp instanceof axro))) {
      ((axro)this.jdField_a_of_type_Axsp).jdField_a_of_type_JavaLangString = MsfSdkUtils.insertMtype("pttCu", ((axro)this.jdField_a_of_type_Axsp).jdField_a_of_type_JavaLangString);
    }
  }
  
  public void onResp(axsq paramaxsq)
  {
    Object localObject1 = null;
    super.onResp(paramaxsq);
    this.jdField_a_of_type_Axsp = null;
    int i = paramaxsq.jdField_c_of_type_Int;
    for (;;)
    {
      long l2;
      try
      {
        if (paramaxsq.jdField_a_of_type_Int != 0) {
          break label505;
        }
        if (paramaxsq.jdField_a_of_type_JavaUtilHashMap.get("User-ReturnCode") == null) {
          break label579;
        }
        l3 = Long.parseLong((String)paramaxsq.jdField_a_of_type_JavaUtilHashMap.get("User-ReturnCode"));
        if ((l3 != 0L) && (l3 != 9223372036854775807L))
        {
          a(this.b, paramaxsq, false);
          a(-9527, null, a(i, l3), this.b);
          d();
          return;
        }
        str2 = (String)paramaxsq.jdField_a_of_type_JavaUtilHashMap.get("Range");
        if (str2 == null) {
          break label587;
        }
      }
      catch (Exception paramaxsq)
      {
        String str2;
        String str1;
        a(9343, axob.a(new Exception("decode unknown exception")), "", this.b);
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
          str1 = (String)paramaxsq.jdField_a_of_type_JavaUtilHashMap.get("X-Range");
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
        this.jdField_a_of_type_Axqf.e = l2;
        this.s = l2;
        a(this.b, paramaxsq, true);
        if (l2 >= this.q) {
          break label500;
        }
        aS_();
        return;
        a(this.b, paramaxsq, false);
        a(-9527, "", a(this.h, this.jdField_f_of_type_Int), this.b);
        d();
        return;
        e();
        return;
      }
      if (l2 == 9223372036854775807L)
      {
        a(this.b, paramaxsq, false);
        a(-9527, "no header range:" + str2 + " x-range:" + localObject1, a(this.h, this.g), this.b);
        axte.b(true);
        d();
        return;
      }
      label420:
      label460:
      label500:
      label505:
      if ((paramaxsq.b == 9364) && (this.jdField_l_of_type_Int < 3))
      {
        b("[netChg]", "failed.but net change detect.so retry");
        this.jdField_l_of_type_Int += 1;
        m();
        f();
        return;
      }
      a(this.b, paramaxsq, false);
      b(paramaxsq.b, paramaxsq.jdField_a_of_type_JavaLangString);
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
 * Qualified Name:     axrw
 * JD-Core Version:    0.7.0.1
 */