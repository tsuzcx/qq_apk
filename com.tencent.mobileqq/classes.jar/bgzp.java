import NS_QWEB_PROTOCAL.PROTOCAL.StAuthInfo;
import NS_QWEB_PROTOCAL.PROTOCAL.StQWebReq;
import NS_QWEB_PROTOCAL.PROTOCAL.StQWebRsp;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qqmini.sdk.core.proxy.ChannelProxy;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.log.QMLog;
import com.tencent.qqmini.sdk.utils.QUAUtil;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

public abstract class bgzp
{
  private static volatile AtomicInteger a;
  public int a;
  
  static
  {
    jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
  }
  
  private String c()
  {
    String str = bgte.a().a();
    StringBuilder localStringBuilder = new StringBuilder(50);
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("MMddHHmmss");
    Random localRandom = new Random();
    localRandom.setSeed(System.currentTimeMillis());
    localStringBuilder.append(str).append("_").append(localSimpleDateFormat.format(new Date())).append(System.currentTimeMillis() % 1000L).append("_").append(localRandom.nextInt(90000) + 10000);
    return localStringBuilder.toString();
  }
  
  protected abstract String a();
  
  public abstract JSONObject a(byte[] paramArrayOfByte);
  
  protected abstract byte[] a();
  
  protected byte[] a(byte[] paramArrayOfByte)
  {
    PROTOCAL.StQWebRsp localStQWebRsp = new PROTOCAL.StQWebRsp();
    try
    {
      localStQWebRsp.mergeFrom(paramArrayOfByte);
      paramArrayOfByte = localStQWebRsp.busiBuff.get().toByteArray();
      return paramArrayOfByte;
    }
    catch (Exception paramArrayOfByte)
    {
      QMLog.d("ProtoBufRequest", "decode fail.", paramArrayOfByte);
    }
    return null;
  }
  
  protected abstract String b();
  
  public byte[] b()
  {
    Object localObject = (ChannelProxy)ProxyManager.get(ChannelProxy.class);
    PROTOCAL.StQWebReq localStQWebReq = new PROTOCAL.StQWebReq();
    this.jdField_a_of_type_Int = jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.incrementAndGet();
    localStQWebReq.Seq.set(this.jdField_a_of_type_Int);
    localStQWebReq.traceid.set(c());
    if (QUAUtil.getQUA() != null) {
      localStQWebReq.qua.set(QUAUtil.getQUA());
    }
    if (((ChannelProxy)localObject).getDeviceInfo() != null) {
      localStQWebReq.deviceInfo.set(((ChannelProxy)localObject).getDeviceInfo());
    }
    localStQWebReq.busiBuff.set(ByteStringMicro.copyFrom(a()));
    localStQWebReq.Module.set(a());
    localStQWebReq.Cmdname.set(b());
    localObject = new PROTOCAL.StAuthInfo();
    if (bgte.a().a() != null) {
      ((PROTOCAL.StAuthInfo)localObject).uin.set(bgte.a().a());
    }
    if (bgte.a().a() != null) {
      ((PROTOCAL.StAuthInfo)localObject).sig.set(ByteStringMicro.copyFrom(bgte.a().a()));
    }
    ((PROTOCAL.StAuthInfo)localObject).type.set(bgte.a().a());
    if ((!QUAUtil.isQQApp()) && (bgte.a().e() != null)) {
      ((PROTOCAL.StAuthInfo)localObject).platform.set(bgte.a().e());
    }
    if (bgte.a().c() != null) {
      ((PROTOCAL.StAuthInfo)localObject).openid.set(bgte.a().c());
    }
    if (bgte.a().f() != null) {
      ((PROTOCAL.StAuthInfo)localObject).appid.set(bgte.a().f());
    }
    if (bgte.a().d() != null) {
      ((PROTOCAL.StAuthInfo)localObject).sessionkey.set(ByteStringMicro.copyFrom(bgte.a().d().getBytes()));
    }
    localStQWebReq.loginSig.set((MessageMicro)localObject);
    return localStQWebReq.toByteArray();
  }
  
  public String toString()
  {
    return "ProtoBufRequest{seqNo=" + this.jdField_a_of_type_Int + ",CmdName=" + b() + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bgzp
 * JD-Core Version:    0.7.0.1
 */