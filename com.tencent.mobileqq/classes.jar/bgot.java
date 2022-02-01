import NS_QWEB_PROTOCAL.PROTOCAL.StQWebReq;
import NS_QWEB_PROTOCAL.PROTOCAL.StQWebRsp;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.soso.LbsManagerService;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.vas.VasExtensionHandler;
import cooperation.qzone.PlatformInfor;
import cooperation.qzone.QUA;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.TimeZone;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;

public class bgot
{
  private static long a;
  
  @NotNull
  public static MessageMicro a(byte[] paramArrayOfByte)
  {
    paramArrayOfByte = ByteStringMicro.copyFrom(paramArrayOfByte);
    PROTOCAL.StQWebReq localStQWebReq = new PROTOCAL.StQWebReq();
    PBUInt64Field localPBUInt64Field = localStQWebReq.Seq;
    long l = a + 1L;
    a = l;
    localPBUInt64Field.set(l);
    localStQWebReq.qua.set(QUA.getQUA3());
    localStQWebReq.deviceInfo.set(a());
    localStQWebReq.busiBuff.set(paramArrayOfByte);
    localStQWebReq.traceid.set(b());
    return localStQWebReq;
  }
  
  public static String a()
  {
    Object localObject2 = PlatformInfor.g().getDeviceInfor();
    Object localObject1 = localObject2;
    if (localObject2 != null)
    {
      localObject1 = localObject2;
      if (((String)localObject2).length() > 0)
      {
        localObject1 = new StringBuilder((String)localObject2);
        ((StringBuilder)localObject1).append('&');
        ((StringBuilder)localObject1).append("timezone=").append(TimeZone.getDefault().getID());
        localObject2 = LbsManagerService.getCachedLbsInfo("qqcircle");
        if ((localObject2 != null) && (((SosoInterface.SosoLbsInfo)localObject2).mLocation != null))
        {
          ((StringBuilder)localObject1).append('&');
          ((StringBuilder)localObject1).append("latitude=").append(String.valueOf(((SosoInterface.SosoLbsInfo)localObject2).mLocation.mLat02));
          ((StringBuilder)localObject1).append('&');
          ((StringBuilder)localObject1).append("longitude=").append(String.valueOf(((SosoInterface.SosoLbsInfo)localObject2).mLocation.mLon02));
        }
        localObject1 = ((StringBuilder)localObject1).toString();
      }
    }
    return localObject1;
  }
  
  public static void a(String paramString, MessageMicro paramMessageMicro, Class paramClass, BusinessObserver paramBusinessObserver)
  {
    ((VasExtensionHandler)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getBusinessHandler(71)).a(paramString, paramMessageMicro, paramClass, paramBusinessObserver);
  }
  
  public static void a(String paramString1, String paramString2, BusinessObserver paramBusinessObserver)
  {
    ((VasExtensionHandler)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getBusinessHandler(71)).a(paramString1, paramString2, paramBusinessObserver);
  }
  
  public static void a(String paramString, byte[] paramArrayOfByte, BusinessObserver paramBusinessObserver)
  {
    ((VasExtensionHandler)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getBusinessHandler(71)).a(paramString, paramArrayOfByte, paramBusinessObserver);
  }
  
  public static byte[] a(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return null;
    }
    try
    {
      paramArrayOfByte = a(paramArrayOfByte);
      ((Long)paramArrayOfByte[0]).longValue();
      String str = (String)paramArrayOfByte[1];
      paramArrayOfByte = ((ByteStringMicro)paramArrayOfByte[2]).toByteArray();
      return paramArrayOfByte;
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
    return null;
  }
  
  public static Object[] a(byte[] paramArrayOfByte)
  {
    PROTOCAL.StQWebRsp localStQWebRsp = new PROTOCAL.StQWebRsp();
    localStQWebRsp.mergeFrom(paramArrayOfByte);
    return new Object[] { Long.valueOf(localStQWebRsp.retCode.get()), localStQWebRsp.errMsg.get().toStringUtf8(), localStQWebRsp.busiBuff.get() };
  }
  
  public static String b()
  {
    String str = BaseApplicationImpl.sApplication.getRuntime().getAccount();
    StringBuilder localStringBuilder = new StringBuilder(50);
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("MMddHHmmss");
    Random localRandom = new Random();
    localRandom.setSeed(System.currentTimeMillis());
    localStringBuilder.append(str).append("_").append(localSimpleDateFormat.format(new Date())).append(System.currentTimeMillis() % 1000L).append("_").append(localRandom.nextInt(90000) + 10000);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgot
 * JD-Core Version:    0.7.0.1
 */