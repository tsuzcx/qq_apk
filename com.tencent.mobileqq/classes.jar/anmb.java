import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.transfile.INetEngine;
import com.tencent.mobileqq.transfile.INetEngine.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.qphone.base.util.QLog;
import com.tencent.securitysdk.utils.MD5;
import dov.com.qq.im.capture.music.QIMMusicConfigManager;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public abstract class anmb
  implements INetEngine.INetEngineListener, Runnable
{
  public final QQAppInterface a;
  public final INetEngine a;
  final QIMMusicConfigManager a;
  public final String b;
  final String c;
  
  public anmb(QIMMusicConfigManager paramQIMMusicConfigManager)
  {
    this.jdField_a_of_type_DovComQqImCaptureMusicQIMMusicConfigManager = paramQIMMusicConfigManager;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQIMMusicConfigManager.a();
    this.b = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    this.c = paramQIMMusicConfigManager.a;
    this.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine = QIMMusicConfigManager.a(paramQIMMusicConfigManager);
  }
  
  public String a(long paramLong)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("OpitrtqeGzopIlwxs").append("_").append("2000000025").append("_").append("SApgehUTVGxZKBQZTt").append("_").append("QmnkKmaTHNDozKdIUA").append("_").append(paramLong);
    localObject = ((StringBuilder)localObject).toString();
    String str = MD5.a((String)localObject).toLowerCase();
    if (QLog.isColorLevel()) {
      QLog.d("QIMMusicConfigManager", 2, "generate the sign string, pre=" + (String)localObject + ", md5=" + str);
    }
    return str;
  }
  
  public String a(String paramString, Map paramMap)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    if (!paramMap.isEmpty())
    {
      paramString = paramMap.entrySet().iterator();
      int i = 1;
      if (paramString.hasNext())
      {
        paramMap = (Map.Entry)paramString.next();
        if (i != 0)
        {
          localStringBuilder.append("?");
          i = 0;
        }
        for (;;)
        {
          localStringBuilder.append((String)paramMap.getKey()).append("=").append((String)paramMap.getValue());
          break;
          localStringBuilder.append("&");
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("QIMMusicConfigManager", 2, "genQQMusicReqUrl url" + localStringBuilder.toString());
    }
    return localStringBuilder.toString();
  }
  
  public Map a(String paramString1, String paramString2)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("login_type", String.valueOf(1));
    localHashMap.put("uin", paramString1);
    localHashMap.put("ticket_type", "skey");
    localHashMap.put("auth", paramString2);
    return localHashMap;
  }
  
  public void a()
  {
    ThreadManager.executeOnSubThread(this);
  }
  
  public void a(NetReq paramNetReq, long paramLong1, long paramLong2) {}
  
  public void a(NetResp paramNetResp) {}
  
  void a(boolean paramBoolean)
  {
    if (paramBoolean) {
      QIMMusicConfigManager.b(this.b);
    }
    anma localanma = new anma(this.jdField_a_of_type_DovComQqImCaptureMusicQIMMusicConfigManager);
    localanma.a = true;
    localanma.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     anmb
 * JD-Core Version:    0.7.0.1
 */