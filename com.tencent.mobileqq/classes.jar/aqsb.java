import com.tencent.beacon.upload.TunnelInfo;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.qqlive.module.videoreport.dtreport.api.IDTParamProvider;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import mqq.app.AppRuntime;

public class aqsb
  implements IDTParamProvider
{
  public static List<TunnelInfo> a()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new TunnelInfo("LOGDEBUGKEY00001"));
    localArrayList.add(new TunnelInfo(pik.a));
    localArrayList.add(new TunnelInfo("0P000B1E6X38P6V3"));
    localArrayList.add(new TunnelInfo("00000QG6YX3X0LZH"));
    return localArrayList;
  }
  
  private static void a(Map<String, Object> paramMap)
  {
    if (paramMap != null)
    {
      String str = amxy.a();
      int i = AppSetting.a();
      paramMap.put("client_page_name", str);
      paramMap.put("client_process_name", BaseApplicationImpl.processName);
      paramMap.put("qq_appid", String.valueOf(i));
    }
  }
  
  public String getActiveInfo()
  {
    return null;
  }
  
  public String getAdCode()
  {
    return null;
  }
  
  public String getCallFrom()
  {
    return null;
  }
  
  public String getCallScheme()
  {
    return null;
  }
  
  public String getFactoryChannelId()
  {
    return null;
  }
  
  public String getGuid()
  {
    return null;
  }
  
  public String getMainLogin()
  {
    return null;
  }
  
  public String getModifyChannelId()
  {
    return null;
  }
  
  public String getOaid()
  {
    return null;
  }
  
  public String getOmgbzid()
  {
    return null;
  }
  
  public String getQQ()
  {
    Object localObject1 = null;
    Object localObject2 = BaseApplicationImpl.getApplication();
    if (localObject2 != null) {
      localObject1 = ((BaseApplicationImpl)localObject2).getRuntime();
    }
    if (localObject1 == null) {
      localObject1 = "0";
    }
    do
    {
      return localObject1;
      localObject2 = ((AppRuntime)localObject1).getAccount();
      localObject1 = localObject2;
    } while (localObject2 != null);
    return "0";
  }
  
  public String getQQOpenID()
  {
    return null;
  }
  
  public String getSIMType()
  {
    if (bgoa.a() == 1) {
      return "1";
    }
    return "3";
  }
  
  public int getStartType()
  {
    return 0;
  }
  
  public String getTid()
  {
    return null;
  }
  
  public String getWbOpenID()
  {
    return null;
  }
  
  public String getWxOpenID()
  {
    return null;
  }
  
  public String getWxUnionID()
  {
    return null;
  }
  
  public void setEventDynamicParams(String paramString, Map<String, Object> paramMap) {}
  
  public void setNonRealtimePublicDynamicParams(Map<String, Object> paramMap)
  {
    a(paramMap);
  }
  
  public void setRealtimePublicDynamicParams(Map<String, Object> paramMap)
  {
    a(paramMap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqsb
 * JD-Core Version:    0.7.0.1
 */