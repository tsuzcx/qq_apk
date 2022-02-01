import android.content.Intent;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.TMG.utils.QLog;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.gamecenter.message.GameBasicInfo;
import com.tencent.mobileqq.gamecenter.message.GameSwitchConfig;
import com.tencent.mobileqq.gamecenter.message.GameUserInfo;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.pb.webssoagent.WebSSOAgent.UniSsoServerReq;
import com.tencent.pb.webssoagent.WebSSOAgent.UniSsoServerReqComm;
import com.tencent.pb.webssoagent.WebSSOAgent.UniSsoServerRsp;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import java.util.ArrayList;
import java.util.Iterator;
import mqq.app.NewIntent;
import org.json.JSONArray;
import org.json.JSONObject;

public class autn
  extends anii
{
  public static String a;
  private static String b = jdField_a_of_type_JavaLangString + "GameCenterUnissoHandler";
  private QQAppInterface a;
  
  static
  {
    jdField_a_of_type_JavaLangString = "GameCenterMsg.";
  }
  
  public autn(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  private autc a(GameUserInfo paramGameUserInfo)
  {
    if (paramGameUserInfo == null) {
      return null;
    }
    autd localautd = (autd)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(358);
    if (GameUserInfo.isUsrInfoUpdate(localautd.a(paramGameUserInfo.mRoleId), paramGameUserInfo))
    {
      QLog.i(b, 1, "[notifyGameUsrInfoChanged], roleId:" + paramGameUserInfo.mRoleId);
      return autc.a(localautd.a(paramGameUserInfo.mAppId), paramGameUserInfo);
    }
    return null;
  }
  
  private void b(Intent paramIntent, FromServiceMsg paramFromServiceMsg, byte[] paramArrayOfByte)
  {
    if (QLog.isColorLevel()) {
      QLog.d(b, 0, "[handleGetGameSwitch]");
    }
    if ((paramArrayOfByte != null) && (paramFromServiceMsg != null)) {
      try
      {
        if (paramFromServiceMsg.isSuccess())
        {
          paramIntent = new WebSSOAgent.UniSsoServerRsp();
          paramIntent.mergeFrom(paramArrayOfByte);
          paramIntent.ret.get();
          paramIntent = new JSONObject(paramIntent.rspdata.get()).getJSONObject("UserInfo.GetSwitch").getJSONObject("rsp");
          int i = paramIntent.optInt("ret_code");
          paramFromServiceMsg = paramIntent.optString("err_msg");
          paramIntent = paramIntent.optJSONObject("result_map").optJSONObject(this.app.getCurrentAccountUin());
          if (i != 0)
          {
            QLog.w(b, 1, "errMsg:" + paramFromServiceMsg);
            return;
          }
          if (QLog.isColorLevel()) {
            QLog.d(b, 0, "[handleGetGameSwitch] result: " + paramIntent.toString());
          }
          paramFromServiceMsg = new ArrayList();
          if (paramIntent != null)
          {
            paramArrayOfByte = paramIntent.keys();
            while (paramArrayOfByte.hasNext())
            {
              String str = (String)paramArrayOfByte.next();
              if (!TextUtils.isEmpty(str))
              {
                GameSwitchConfig localGameSwitchConfig = new GameSwitchConfig();
                JSONObject localJSONObject = paramIntent.getJSONObject(str);
                localGameSwitchConfig.mAppId = str;
                localGameSwitchConfig.mSyncSwitch = localJSONObject.optInt("switch");
                localGameSwitchConfig.mBlockSwitch = localJSONObject.optInt("qq_block_switch");
                localGameSwitchConfig.print();
                paramFromServiceMsg.add(localGameSwitchConfig);
              }
            }
            ((autd)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(358)).c(paramFromServiceMsg);
          }
        }
      }
      catch (Throwable paramIntent)
      {
        QLog.e(b, 1, paramIntent.getMessage());
        return;
      }
    }
  }
  
  private void c(Intent paramIntent, FromServiceMsg paramFromServiceMsg, byte[] paramArrayOfByte)
  {
    if (QLog.isColorLevel()) {
      QLog.d(b, 0, "[handleGetUserInfoRsp]");
    }
    long l1;
    int i;
    ArrayList localArrayList;
    Object localObject1;
    Object localObject3;
    Object localObject2;
    try
    {
      l1 = System.currentTimeMillis();
      paramIntent = (autd)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(358);
      if ((paramArrayOfByte == null) || (paramFromServiceMsg == null) || (!paramFromServiceMsg.isSuccess())) {
        return;
      }
      paramFromServiceMsg = new WebSSOAgent.UniSsoServerRsp();
      paramFromServiceMsg.mergeFrom(paramArrayOfByte);
      paramFromServiceMsg.ret.get();
      paramFromServiceMsg = new JSONObject(paramFromServiceMsg.rspdata.get());
      if (QLog.isColorLevel()) {
        QLog.d(b, 0, paramFromServiceMsg.toString());
      }
      paramFromServiceMsg = paramFromServiceMsg.getJSONObject("UserInfo.GetUserInfo").getJSONObject("rsp");
      i = paramFromServiceMsg.optInt("ret_code");
      paramArrayOfByte = paramFromServiceMsg.optString("err_msg");
      if (i != 0)
      {
        QLog.w(b, 1, "errMsg:" + paramArrayOfByte);
        return;
      }
      paramArrayOfByte = paramFromServiceMsg.optJSONObject("game_config");
      localArrayList = new ArrayList();
      if (paramArrayOfByte != null)
      {
        localObject1 = paramArrayOfByte.keys();
        while (((Iterator)localObject1).hasNext())
        {
          localObject3 = (String)((Iterator)localObject1).next();
          if (!TextUtils.isEmpty((CharSequence)localObject3))
          {
            localObject2 = new GameBasicInfo();
            ((GameBasicInfo)localObject2).mAppId = ((String)localObject3);
            localObject3 = paramArrayOfByte.getJSONObject((String)localObject3);
            ((GameBasicInfo)localObject2).mName = ((JSONObject)localObject3).optString("name");
            ((GameBasicInfo)localObject2).mIconUrl = ((JSONObject)localObject3).optString("icon");
            ((GameBasicInfo)localObject2).mMsgMaxLen = ((JSONObject)localObject3).optInt("msg_max_len");
            ((GameBasicInfo)localObject2).mUpdateTs = ((JSONObject)localObject3).optLong("data_update_ts");
            ((GameBasicInfo)localObject2).mStartGameUrl = ((JSONObject)localObject3).optString("zone_url");
            ((GameBasicInfo)localObject2).print();
            localArrayList.add(localObject2);
          }
        }
        paramIntent.b(localArrayList);
      }
    }
    catch (Throwable paramIntent)
    {
      QLog.e(b, 1, paramIntent.getMessage());
      return;
    }
    paramFromServiceMsg = paramFromServiceMsg.optJSONArray("result_list");
    paramArrayOfByte = new ArrayList();
    if (paramFromServiceMsg != null)
    {
      int j = paramFromServiceMsg.length();
      localArrayList = new ArrayList();
      i = 0;
      while (i < j)
      {
        localObject1 = new GameUserInfo();
        Object localObject4 = paramFromServiceMsg.getJSONObject(i);
        int k = ((JSONObject)localObject4).optInt("online_type");
        int m = ((JSONObject)localObject4).optInt("sex");
        long l2 = ((JSONObject)localObject4).optLong("data_update_ts");
        int n = ((JSONObject)localObject4).optInt("msgsync_switch");
        localObject2 = ((JSONObject)localObject4).optString("appid");
        localObject3 = ((JSONObject)localObject4).optString("nick");
        String str1 = ((JSONObject)localObject4).optString("face_url");
        String str2 = ((JSONObject)localObject4).optString("role_id");
        String str3 = ((JSONObject)localObject4).optString("partition_name");
        String str4 = ((JSONObject)localObject4).optJSONObject("game_profile").optString("level_pic");
        String str5 = ((JSONObject)localObject4).optJSONObject("game_profile").getString("level_text");
        localObject4 = ((JSONObject)localObject4).optString("online_desc");
        ((GameUserInfo)localObject1).mRoleId = str2;
        ((GameUserInfo)localObject1).mAppId = ((String)localObject2);
        ((GameUserInfo)localObject1).mUpdateTs = l2;
        ((GameUserInfo)localObject1).mFaceUrl = str1;
        ((GameUserInfo)localObject1).mSex = m;
        ((GameUserInfo)localObject1).mNickInGame = ((String)localObject3);
        ((GameUserInfo)localObject1).mOnlineType = k;
        ((GameUserInfo)localObject1).mPartitioName = str3;
        ((GameUserInfo)localObject1).mLevelPic = str4;
        ((GameUserInfo)localObject1).mLevelText = str5;
        ((GameUserInfo)localObject1).mSaveTs = l1;
        ((GameUserInfo)localObject1).mSwitchInGame = n;
        ((GameUserInfo)localObject1).mOnLineDesc = ((String)localObject4);
        ((GameUserInfo)localObject1).print();
        localObject2 = a((GameUserInfo)localObject1);
        if (localObject2 != null) {
          localArrayList.add(localObject2);
        }
        paramArrayOfByte.add(localObject1);
        i += 1;
      }
      if (localArrayList.size() > 0) {
        notifyUI(8224, true, localArrayList);
      }
    }
    if (paramIntent != null) {
      paramIntent.a(paramArrayOfByte);
    }
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d(b, 0, "[getGameSwitch]");
    }
    try
    {
      Object localObject = new WebSSOAgent.UniSsoServerReqComm();
      ((WebSSOAgent.UniSsoServerReqComm)localObject).platform.set(109L);
      ((WebSSOAgent.UniSsoServerReqComm)localObject).osver.set(Build.VERSION.RELEASE);
      ((WebSSOAgent.UniSsoServerReqComm)localObject).mqqver.set("8.4.1");
      WebSSOAgent.UniSsoServerReq localUniSsoServerReq = new WebSSOAgent.UniSsoServerReq();
      localUniSsoServerReq.comm.set((MessageMicro)localObject);
      localObject = new JSONObject();
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("req", new JSONObject());
      ((JSONObject)localObject).put("UserInfo.GetSwitch", localJSONObject);
      localUniSsoServerReq.reqdata.set(((JSONObject)localObject).toString());
      if (QLog.isColorLevel()) {
        QLog.d(b, 0, ((JSONObject)localObject).toString());
      }
      localObject = new NewIntent(this.app.getApp(), autp.class);
      ((NewIntent)localObject).putExtra("cmd", "GameCenterMsg.GetSwitch");
      ((NewIntent)localObject).putExtra("data", localUniSsoServerReq.toByteArray());
      this.app.startServlet((NewIntent)localObject);
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e(b, 1, localThrowable.getMessage());
    }
  }
  
  public void a(Intent paramIntent, FromServiceMsg paramFromServiceMsg, byte[] paramArrayOfByte)
  {
    String str = paramIntent.getStringExtra("cmd");
    if (TextUtils.isEmpty(str)) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d(b, 0, "[onReceive], cmd:" + str);
      }
      if ("GameCenterMsg.GetUserInfo".equals(str))
      {
        c(paramIntent, paramFromServiceMsg, paramArrayOfByte);
        return;
      }
    } while (!"GameCenterMsg.GetSwitch".equals(str));
    b(paramIntent, paramFromServiceMsg, paramArrayOfByte);
  }
  
  public void a(ArrayList<String> paramArrayList)
  {
    if (QLog.isColorLevel()) {
      QLog.d(b, 0, "[getGameUserInfo] from svr");
    }
    if ((paramArrayList == null) || (paramArrayList.size() == 0)) {
      return;
    }
    Object localObject1;
    WebSSOAgent.UniSsoServerReq localUniSsoServerReq;
    try
    {
      localObject1 = new WebSSOAgent.UniSsoServerReqComm();
      ((WebSSOAgent.UniSsoServerReqComm)localObject1).platform.set(109L);
      ((WebSSOAgent.UniSsoServerReqComm)localObject1).osver.set(Build.VERSION.RELEASE);
      ((WebSSOAgent.UniSsoServerReqComm)localObject1).mqqver.set("8.4.1");
      localUniSsoServerReq = new WebSSOAgent.UniSsoServerReq();
      localUniSsoServerReq.comm.set((MessageMicro)localObject1);
      localObject1 = new JSONObject();
      localObject2 = new JSONArray();
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        String str = (String)paramArrayList.next();
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("role_id", str);
        ((JSONArray)localObject2).put(localJSONObject);
      }
      paramArrayList = new JSONObject();
    }
    catch (Throwable paramArrayList)
    {
      QLog.e(b, 1, paramArrayList.getMessage());
      return;
    }
    paramArrayList.put("is_need_game_config", true);
    paramArrayList.put("query_list", localObject2);
    Object localObject2 = new JSONObject();
    ((JSONObject)localObject2).put("req", paramArrayList);
    ((JSONObject)localObject1).put("UserInfo.GetUserInfo", localObject2);
    localUniSsoServerReq.reqdata.set(((JSONObject)localObject1).toString());
    if (QLog.isColorLevel()) {
      QLog.d(b, 0, ((JSONObject)localObject1).toString());
    }
    paramArrayList = new NewIntent(this.app.getApp(), autp.class);
    paramArrayList.putExtra("cmd", "GameCenterMsg.GetUserInfo");
    paramArrayList.putExtra("data", localUniSsoServerReq.toByteArray());
    this.app.startServlet(paramArrayList);
  }
  
  protected Class<? extends anil> observerClass()
  {
    return auto.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     autn
 * JD-Core Version:    0.7.0.1
 */