import NS_MINI_INTERFACE.INTERFACE.StGetAuthListRsp;
import NS_MINI_INTERFACE.INTERFACE.StUserAuthInfo;
import NS_MINI_INTERFACE.INTERFACE.StUserSettingInfo;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.core.auth.UserAuthInfo;
import com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy.AuthListResult;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

class bjcf
  implements MiniAppCmdInterface
{
  bjcf(bjce parambjce, ChannelProxy.AuthListResult paramAuthListResult) {}
  
  public void onCmdListener(boolean paramBoolean, JSONObject paramJSONObject)
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    Object localObject;
    if ((paramBoolean) && (paramJSONObject != null))
    {
      localObject = paramJSONObject.opt("authList");
      if ((localObject instanceof byte[]))
      {
        paramJSONObject = new INTERFACE.StGetAuthListRsp();
        try
        {
          paramJSONObject.mergeFrom((byte[])localObject);
          localObject = paramJSONObject.auths.get().iterator();
          while (((Iterator)localObject).hasNext())
          {
            INTERFACE.StUserAuthInfo localStUserAuthInfo = (INTERFACE.StUserAuthInfo)((Iterator)localObject).next();
            UserAuthInfo localUserAuthInfo = new UserAuthInfo();
            localUserAuthInfo.scope = localStUserAuthInfo.scope.get();
            localUserAuthInfo.desc = localStUserAuthInfo.desc.get();
            localUserAuthInfo.authState = localStUserAuthInfo.authState.get();
            localArrayList1.add(localUserAuthInfo);
          }
          if (this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreProxyChannelProxy$AuthListResult == null) {
            break label208;
          }
        }
        catch (InvalidProtocolBufferMicroException paramJSONObject)
        {
          QLog.e("ChannelProxyImpl", 1, "getSetting, InvalidProtocolBufferMicroException:" + paramJSONObject);
          paramJSONObject.printStackTrace();
        }
      }
    }
    this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreProxyChannelProxy$AuthListResult.onReceiveResult(false, localArrayList1, localArrayList2);
    label208:
    do
    {
      return;
      paramJSONObject = paramJSONObject.settings.get().iterator();
      while (paramJSONObject.hasNext())
      {
        localObject = (INTERFACE.StUserSettingInfo)paramJSONObject.next();
        localArrayList2.add(bjce.a(this.jdField_a_of_type_Bjce, (INTERFACE.StUserSettingInfo)localObject));
      }
    } while (this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreProxyChannelProxy$AuthListResult == null);
    this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreProxyChannelProxy$AuthListResult.onReceiveResult(true, localArrayList1, localArrayList2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bjcf
 * JD-Core Version:    0.7.0.1
 */