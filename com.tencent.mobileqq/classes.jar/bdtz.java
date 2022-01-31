import NS_QWEB_PROTOCAL.PROTOCAL.StAuthInfo;
import NS_QWEB_PROTOCAL.PROTOCAL.StQWebReq;
import NS_QWEB_PROTOCAL.PROTOCAL.StQWebRsp;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qqmini.sdk.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

public abstract class bdtz
{
  private static volatile AtomicInteger a;
  public int a;
  
  static
  {
    jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
  }
  
  private String c()
  {
    String str = ((MiniAppProxy)ProxyManager.get(MiniAppProxy.class)).getAccount();
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
      bdnw.a("ProtoBufRequest", "decode fail.", paramArrayOfByte);
    }
    return null;
  }
  
  protected abstract String b();
  
  public byte[] b()
  {
    MiniAppProxy localMiniAppProxy = (MiniAppProxy)ProxyManager.get(MiniAppProxy.class);
    PROTOCAL.StQWebReq localStQWebReq = new PROTOCAL.StQWebReq();
    this.jdField_a_of_type_Int = jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.incrementAndGet();
    localStQWebReq.Seq.set(this.jdField_a_of_type_Int);
    localStQWebReq.traceid.set(c());
    localStQWebReq.qua.set(bdzd.a());
    localStQWebReq.deviceInfo.set(localMiniAppProxy.getDeviceInfo());
    localStQWebReq.busiBuff.set(ByteStringMicro.copyFrom(a()));
    localStQWebReq.Module.set(a());
    localStQWebReq.Cmdname.set(b());
    PROTOCAL.StAuthInfo localStAuthInfo = new PROTOCAL.StAuthInfo();
    localStAuthInfo.uin.set(localMiniAppProxy.getAccount());
    localStAuthInfo.platform.set(localMiniAppProxy.getPlatformId());
    localStAuthInfo.sig.set(ByteStringMicro.copyFrom(localMiniAppProxy.getLoginSig()));
    localStQWebReq.loginSig.set(localStAuthInfo);
    return localStQWebReq.toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bdtz
 * JD-Core Version:    0.7.0.1
 */