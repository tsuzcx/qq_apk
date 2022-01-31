import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.WebSsoBody.WebSsoResponseBody;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.werewolves.WerewolvesHostInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;
import mqq.observer.BusinessObserver;
import org.json.JSONObject;

public class bcio
  implements BusinessObserver
{
  public bcio(WerewolvesHostInterface paramWerewolvesHostInterface, QQAppInterface paramQQAppInterface, String paramString1, String paramString2, boolean paramBoolean) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    try
    {
      ((aszd)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(106)).d.put(this.jdField_a_of_type_JavaLangString, Integer.valueOf(1));
      if (!paramBoolean) {
        break label348;
      }
      paramBundle = paramBundle.getByteArray("data");
      if (paramBundle == null) {
        break label348;
      }
      localObject = new WebSsoBody.WebSsoResponseBody();
      ((WebSsoBody.WebSsoResponseBody)localObject).mergeFrom(paramBundle);
      paramInt = ((WebSsoBody.WebSsoResponseBody)localObject).ret.get();
      localObject = new JSONObject(((WebSsoBody.WebSsoResponseBody)localObject).data.get());
      if (paramInt != 0)
      {
        paramBundle = ((JSONObject)localObject).optString("msg");
        if ((TextUtils.isEmpty(paramBundle)) || (!QLog.isColorLevel())) {
          break label348;
        }
        QLog.d("Q.werewolf.WerewolvesHostInterfaceQ.nearby.follow", 2, "sendOperateFollowUser,targetUin:" + this.jdField_a_of_type_JavaLangString + ", op:" + this.b + ", errMsg:" + paramBundle);
        bcpw.a(BaseApplicationImpl.getContext(), 1, paramBundle, 0).a();
        return;
      }
      paramBundle = ((JSONObject)localObject).getJSONObject("result");
      if (((JSONObject)localObject).optInt("retcode") != 0) {
        break label348;
      }
      if (this.jdField_a_of_type_Boolean) {
        this.jdField_a_of_type_ComTencentMobileqqWerewolvesWerewolvesHostInterface.manager.a().a(5, new Object[] { Boolean.valueOf(true), Boolean.valueOf(this.jdField_a_of_type_Boolean) });
      }
      localObject = BaseApplicationImpl.getContext();
      localBaseApplication = BaseApplicationImpl.getContext();
      if (!this.b.equals("1")) {
        break label477;
      }
      paramInt = 2131694534;
    }
    catch (Exception paramBundle)
    {
      Object localObject;
      BaseApplication localBaseApplication;
      if (!QLog.isColorLevel()) {
        break label348;
      }
      QLog.d("Q.werewolf.WerewolvesHostInterface", 2, "sendOperateFollowUser, Exception");
      label348:
      paramBundle = BaseApplicationImpl.getContext();
      if (!this.b.equals("1")) {
        break label483;
      }
      label477:
      label483:
      for (paramInt = 2131694533;; paramInt = 2131694546)
      {
        paramBundle = paramBundle.getString(paramInt);
        bcpw.a(BaseApplicationImpl.getContext(), 1, paramBundle, 0).a();
        if (QLog.isColorLevel()) {
          QLog.d("Q.werewolf.WerewolvesHostInterfaceQ.nearby.follow", 2, "sendOperateFollowUser,targetUin:" + this.jdField_a_of_type_JavaLangString + ", op:" + this.b + ", re:" + paramBundle);
        }
        this.jdField_a_of_type_ComTencentMobileqqWerewolvesWerewolvesHostInterface.manager.a().a(5, new Object[] { Boolean.valueOf(false), Boolean.valueOf(this.jdField_a_of_type_Boolean) });
        return;
        paramInt = 2131694547;
        break;
      }
    }
    bcpw.a((Context)localObject, 2, localBaseApplication.getString(paramInt), 0).a();
    if (QLog.isColorLevel())
    {
      QLog.d("Q.werewolf.WerewolvesHostInterfaceQ.nearby.follow", 2, "sendOperateFollowUser,targetUin:" + this.jdField_a_of_type_JavaLangString + ", op:" + this.b + ", result:" + paramBundle.toString());
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     bcio
 * JD-Core Version:    0.7.0.1
 */