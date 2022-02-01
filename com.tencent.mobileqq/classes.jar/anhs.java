import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ChatSettingActivity;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.Groups;
import com.tencent.mobileqq.profile.like.PraiseManager;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import java.util.concurrent.ConcurrentHashMap;
import mqq.os.MqqHandler;

public class anhs
  extends QIPCModule
{
  private static volatile anhs jdField_a_of_type_Anhs;
  private aniz jdField_a_of_type_Aniz = new anht(this);
  private azfe jdField_a_of_type_Azfe = new azfe();
  private Card jdField_a_of_type_ComTencentMobileqqDataCard;
  private ConcurrentHashMap<String, Bundle> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap(10);
  boolean jdField_a_of_type_Boolean = false;
  
  public anhs(String paramString)
  {
    super(paramString);
    this.jdField_a_of_type_Azfe.jdField_a_of_type_ArrayOfJavaLangString = new String[7];
  }
  
  public static anhs a()
  {
    if (jdField_a_of_type_Anhs == null) {}
    try
    {
      if (jdField_a_of_type_Anhs == null) {
        jdField_a_of_type_Anhs = new anhs("BabyQIPCModule");
      }
      return jdField_a_of_type_Anhs;
    }
    finally {}
  }
  
  private EIPCResult a(QQAppInterface paramQQAppInterface, Bundle paramBundle)
  {
    anip localanip = (anip)paramQQAppInterface.a(2);
    int i;
    int j;
    label78:
    boolean bool;
    label230:
    long l;
    if ((localanip != null) && (this.jdField_a_of_type_Azfe.jdField_a_of_type_ComTencentMobileqqDataCard != null) && (bgnt.d(BaseApplication.getContext()))) {
      if (this.jdField_a_of_type_Azfe.jdField_a_of_type_ComTencentMobileqqDataCard.bAvailVoteCnt <= 0)
      {
        i = 1;
        if ((this.jdField_a_of_type_Azfe.jdField_a_of_type_ComTencentMobileqqDataCard.bHaveVotedCnt > 0) || (this.jdField_a_of_type_Azfe.jdField_a_of_type_ComTencentMobileqqDataCard.bAvailVoteCnt > 0)) {
          break label372;
        }
        j = 1;
        if ((i != 0) || (j != 0)) {
          break label398;
        }
        Card localCard = this.jdField_a_of_type_ComTencentMobileqqDataCard;
        localCard.lVoteCount += 1L;
        this.jdField_a_of_type_ComTencentMobileqqDataCard.bVoted = 1;
        localCard = this.jdField_a_of_type_ComTencentMobileqqDataCard;
        localCard.bAvailVoteCnt = ((short)(localCard.bAvailVoteCnt - 1));
        localanip.a(Long.valueOf(paramQQAppInterface.getCurrentAccountUin()).longValue(), Long.valueOf(this.jdField_a_of_type_Azfe.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.a).longValue(), this.jdField_a_of_type_Azfe.jdField_a_of_type_ComTencentMobileqqDataCard.vCookies, this.jdField_a_of_type_Azfe.jdField_a_of_type_ComTencentMobileqqDataCard.favoriteSource, 1, 0);
        bool = ((axda)paramQQAppInterface.getManager(207)).c(Long.valueOf(this.jdField_a_of_type_Azfe.jdField_a_of_type_ComTencentMobileqqDataCard.uin).longValue());
        if (PraiseManager.a(paramQQAppInterface) <= 0) {
          break label383;
        }
        if (!bool) {
          break label378;
        }
        i = 3;
        bcst.b(paramQQAppInterface, "CliOper", "", "", "P_prof", "Prof_good", 1, 1, i, Integer.toString(ProfileActivity.a(this.jdField_a_of_type_Azfe.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.h)), String.valueOf(1), paramQQAppInterface.getCurrentAccountUin(), this.jdField_a_of_type_Azfe.jdField_a_of_type_ComTencentMobileqqDataCard.uin);
        l = 0L;
      }
    }
    for (;;)
    {
      QLog.i("BabyQIPCModule", 1, "babyqWeb vote, card.bAvailVoteCnt = " + this.jdField_a_of_type_Azfe.jdField_a_of_type_ComTencentMobileqqDataCard.bAvailVoteCnt + ",card.bHaveVotedCnt = " + this.jdField_a_of_type_Azfe.jdField_a_of_type_ComTencentMobileqqDataCard.bHaveVotedCnt + ",card.strVoteLimitedNotice = " + this.jdField_a_of_type_Azfe.jdField_a_of_type_ComTencentMobileqqDataCard.strVoteLimitedNotice);
      paramBundle.putLong("key_request_zan_vote_result", l);
      return EIPCResult.createSuccessResult(paramBundle);
      i = 0;
      break;
      label372:
      j = 0;
      break label78;
      label378:
      i = 2;
      break label230;
      label383:
      if (bool)
      {
        i = 1;
        break label230;
      }
      i = 0;
      break label230;
      label398:
      l = 1L;
      continue;
      l = 2L;
    }
  }
  
  private EIPCResult a(QQAppInterface paramQQAppInterface, Bundle paramBundle, String paramString1, int paramInt, String paramString2)
  {
    if (this.jdField_a_of_type_Azfe.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne != null)
    {
      paramQQAppInterface = (anmw)paramQQAppInterface.getManager(51);
      if (paramQQAppInterface != null) {
        break label74;
      }
    }
    label74:
    for (paramQQAppInterface = null;; paramQQAppInterface = paramQQAppInterface.e(this.jdField_a_of_type_Azfe.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.a))
    {
      if (paramQQAppInterface != null)
      {
        paramBundle.putString("friendUin", this.jdField_a_of_type_Azfe.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.a);
        paramBundle.putByte("mgid", (byte)paramQQAppInterface.groupid);
      }
      if (paramInt == -1) {
        break;
      }
      a(paramString1, paramInt, paramString2);
      return null;
    }
    return EIPCResult.createSuccessResult(paramBundle);
  }
  
  private void a(String paramString1, int paramInt, String paramString2)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("key_process_callback_id", paramInt);
    localBundle.putString("key_js_callback_id", paramString2);
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString1, localBundle);
  }
  
  private EIPCResult b(QQAppInterface paramQQAppInterface, Bundle paramBundle)
  {
    if (bgnt.d(BaseApplication.getContext()))
    {
      ((FriendListHandler)paramQQAppInterface.a(1)).c(this.jdField_a_of_type_Azfe.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.a, (byte)2);
      MqqHandler localMqqHandler = paramQQAppInterface.getHandler(ChatActivity.class);
      if (localMqqHandler != null) {
        localMqqHandler.sendMessage(localMqqHandler.obtainMessage(16711681, this.jdField_a_of_type_Azfe.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.a));
      }
      localMqqHandler = paramQQAppInterface.getHandler(ChatSettingActivity.class);
      if (localMqqHandler != null) {
        localMqqHandler.sendMessage(localMqqHandler.obtainMessage(16711681, this.jdField_a_of_type_Azfe.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.a));
      }
      bcst.b(paramQQAppInterface, "dc00898", "", "", "0X8007FDF", "0X8007FDF", 0, 0, "", "", "", "");
      return EIPCResult.createSuccessResult(paramBundle);
    }
    return EIPCResult.createResult(-102, paramBundle);
  }
  
  private EIPCResult c(QQAppInterface paramQQAppInterface, Bundle paramBundle)
  {
    anmw localanmw;
    if ((this.jdField_a_of_type_Azfe.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne != null) && (ProfileActivity.AllInOne.b(this.jdField_a_of_type_Azfe.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)))
    {
      localanmw = (anmw)paramQQAppInterface.getManager(51);
      if (localanmw != null) {
        break label104;
      }
    }
    label104:
    for (paramQQAppInterface = null;; paramQQAppInterface = localanmw.e(this.jdField_a_of_type_Azfe.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.a))
    {
      if (paramQQAppInterface != null)
      {
        paramQQAppInterface = localanmw.a(String.valueOf(paramQQAppInterface.groupid));
        if (paramQQAppInterface != null)
        {
          paramBundle.putString("key_handle_set_get_group", paramQQAppInterface.group_name);
          QLog.i("BabyQIPCModule", 1, "babyqWeb get group =" + paramQQAppInterface.group_name);
        }
      }
      return EIPCResult.createSuccessResult(paramBundle);
    }
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("BabyQIPCModule", 2, "babyqWeb callWebJSHandledSetGroup");
    }
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get("setFriendGrouping") != null)
    {
      localBundle = new Bundle();
      localObject2 = (Bundle)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get("setFriendGrouping");
      localObject1 = ((Bundle)localObject2).getString("key_js_callback_id");
      i = ((Bundle)localObject2).getInt("key_process_callback_id");
      localObject2 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      if ((this.jdField_a_of_type_Azfe.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne != null) && (ProfileActivity.AllInOne.b(this.jdField_a_of_type_Azfe.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)))
      {
        localBundle.putString("key_method_action", "setFriendGrouping");
        localBundle.putString("web_js_call_back_id", (String)localObject1);
        localObject2 = (anmw)((QQAppInterface)localObject2).getManager(51);
        if (localObject2 != null) {
          break label191;
        }
        localObject1 = null;
        if (localObject1 != null)
        {
          localObject1 = ((anmw)localObject2).a(String.valueOf(((Friends)localObject1).groupid));
          if (localObject1 != null) {
            localBundle.putString("key_handle_set_get_group", ((Groups)localObject1).group_name);
          }
        }
      }
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove("setFriendGrouping");
      callbackResult(i, EIPCResult.createSuccessResult(localBundle));
    }
    label191:
    while (!QLog.isColorLevel()) {
      for (;;)
      {
        Bundle localBundle;
        Object localObject2;
        int i;
        return;
        Object localObject1 = ((anmw)localObject2).e(this.jdField_a_of_type_Azfe.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.a);
      }
    }
    QLog.d("BabyQIPCModule", 2, "babyqWeb callWebJSHandledSetGroup");
  }
  
  public void a(String paramString, Bundle paramBundle, EIPCResultCallback paramEIPCResultCallback)
  {
    QIPCClientHelper.getInstance().callServer("BabyQIPCModule", paramString, paramBundle, paramEIPCResultCallback);
  }
  
  public void b()
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if (!this.jdField_a_of_type_Boolean)
    {
      localQQAppInterface.addObserver(this.jdField_a_of_type_Aniz);
      this.jdField_a_of_type_Boolean = true;
    }
    if (QLog.isColorLevel()) {
      QLog.d("BabyQIPCModule", 2, "babyqWeb BabyQFriendStatusWebPlugin init ");
    }
    Object localObject = (anmw)localQQAppInterface.getManager(51);
    if (this.jdField_a_of_type_ComTencentMobileqqDataCard == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqDataCard = bghy.a(localQQAppInterface, anhk.aC);
      this.jdField_a_of_type_Azfe.jdField_a_of_type_ComTencentMobileqqDataCard = this.jdField_a_of_type_ComTencentMobileqqDataCard;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqDataCard != null) && (localObject != null)) {
      if (!((anmw)localObject).b(this.jdField_a_of_type_ComTencentMobileqqDataCard.uin)) {
        break label154;
      }
    }
    anip localanip;
    label154:
    for (localObject = new ProfileActivity.AllInOne(this.jdField_a_of_type_ComTencentMobileqqDataCard.uin, 1);; localObject = new ProfileActivity.AllInOne(this.jdField_a_of_type_ComTencentMobileqqDataCard.uin, 19))
    {
      this.jdField_a_of_type_Azfe.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne = ((ProfileActivity.AllInOne)localObject);
      localanip = (anip)localQQAppInterface.a(2);
      if (localanip != null) {
        break;
      }
      return;
    }
    long l = ProfileActivity.a((ProfileActivity.AllInOne)localObject, false);
    localanip.a(localQQAppInterface.getCurrentAccountUin(), this.jdField_a_of_type_ComTencentMobileqqDataCard.uin, 1, 0L, (byte)1, 0L, 0L, new byte[] { 0 }, "", l, 10004, new byte[] { 0 }, (byte)1);
    localanip.v();
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    QLog.d("BabyQIPCModule", 1, "babyqWeb action = " + paramString);
    if (this.jdField_a_of_type_ComTencentMobileqqDataCard == null) {
      b();
    }
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    String str = null;
    if (paramBundle != null) {
      str = paramBundle.getString("web_js_call_back_id");
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("key_method_action", paramString);
    localBundle.putString("web_js_call_back_id", str);
    if (paramString.equals("getFriendStatus"))
    {
      paramString = (anmw)localQQAppInterface.getManager(51);
      if (paramString == null) {
        break label568;
      }
    }
    label560:
    label562:
    label568:
    for (boolean bool = paramString.b(anhk.aC);; bool = false)
    {
      if (bool) {}
      for (long l = 1L;; l = 0L)
      {
        localBundle.putLong("key_get_friend_status", l);
        return EIPCResult.createSuccessResult(localBundle);
      }
      if (paramString.equals("getZanVoteCount"))
      {
        if (this.jdField_a_of_type_ComTencentMobileqqDataCard != null) {
          localBundle.putLong("key_get_zan_vote_count", this.jdField_a_of_type_ComTencentMobileqqDataCard.lVoteCount);
        }
        return EIPCResult.createSuccessResult(localBundle);
      }
      if (paramString.equals("requestZan")) {
        return a(localQQAppInterface, localBundle);
      }
      if (paramString.equals("addFriend")) {
        bcst.b(localQQAppInterface, "dc00898", "", "", "0X8008274", "0X8008274", 0, 0, "", "", "", "");
      }
      do
      {
        return null;
        if (paramString.equals("sendmsg"))
        {
          localBundle.putParcelable("key_parcel_allinone", this.jdField_a_of_type_Azfe.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne);
          return EIPCResult.createSuccessResult(localBundle);
        }
        if (paramString.equals("deleteFriend")) {
          return b(localQQAppInterface, localBundle);
        }
        if (paramString.equals("getFriendGrouping")) {
          return c(localQQAppInterface, localBundle);
        }
        if (paramString.equals("setFriendGrouping")) {
          return a(localQQAppInterface, localBundle, paramString, paramInt, str);
        }
        if (paramString.equals("reportFriend"))
        {
          if (this.jdField_a_of_type_Azfe.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne != null) {}
          try
          {
            localBundle.putString("key_report_msg", abao.a(localQQAppInterface, this.jdField_a_of_type_Azfe.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.a, "", 21001, null));
            return EIPCResult.createSuccessResult(localBundle);
          }
          catch (Exception paramString)
          {
            for (;;)
            {
              QLog.e("BabyQIPCModule", 1, "babyqWeb getReportMsg Exception", paramString);
            }
          }
        }
        if (paramString.equals("getPushStatus"))
        {
          if (this.jdField_a_of_type_ComTencentMobileqqDataCard.babyQSwitch) {}
          for (l = 1L;; l = 0L)
          {
            localBundle.putLong("key_request_zan_vote_result", l);
            return EIPCResult.createSuccessResult(localBundle);
          }
        }
      } while (!paramString.equals("setPushStatus"));
      if (paramBundle != null)
      {
        l = paramBundle.getLong("key_push_status", 0L);
        label491:
        if (!bgnt.d(BaseApplication.getContext())) {
          break label560;
        }
        paramString = (anip)localQQAppInterface.a(2);
        if (l != 1L) {
          break label562;
        }
      }
      for (bool = true;; bool = false)
      {
        paramString.m(bool);
        QLog.i("BabyQIPCModule", 1, "babyqWeb set babyQSwitch = " + l);
        break;
        l = 0L;
        break label491;
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anhs
 * JD-Core Version:    0.7.0.1
 */