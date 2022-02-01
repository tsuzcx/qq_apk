import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gamecenter.activities.GameCenterActivity;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.QQMessageFacade.Message;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.activity.recent.data.RecentItemPublicAccountChatMsgData;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.AccountDetail;
import com.tencent.mobileqq.data.ConversationInfo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.gamecenter.data.GameCenterSessionInfo;
import com.tencent.mobileqq.gamecenter.message.GameBasicInfo;
import com.tencent.mobileqq.gamecenter.message.GameSwitchConfig;
import com.tencent.mobileqq.gamecenter.message.GameUserInfo;
import com.tencent.mobileqq.gamecenter.message.TinyInfo;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.transfile.AbsDownloader;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import mqq.app.AppRuntime;
import org.json.JSONArray;
import org.json.JSONObject;

public class avdu
{
  public static String a;
  public static int[] a;
  public static String[] a;
  public static String b;
  public static String c;
  public static String d;
  
  static
  {
    jdField_a_of_type_JavaLangString = avec.jdField_a_of_type_JavaLangString + "GameMsgUtil";
    b = "https://fastest.gamecenter.qq.com/_fst_/speed_gamecenter_qq_com/_fst_/pushgame/v1/home/msg?_wv=18950115&_wwv=393&_fst_id=194";
    c = "[游戏好友]";
    d = "\"玩伴\"小程序";
    jdField_a_of_type_ArrayOfInt = new int[] { 23, 40, 19, 43, 21, 9, 20, 106, 35, 10, 25, 24, 1, 0, 33, 32, 12, 27, 13, 22, 3, 18, 30, 31, 81, 82, 26, 2, 37, 50, 42, 83, 34, 11, 49, 84, 39, 78, 5, 4, 6, 85, 86, 87, 46, 88, 44, 89, 48, 14, 90, 41, 36, 91, 51, 164, 174, 171, 165, 166, 161, 167, 170, 169, 172, 173, 168, 175, 17, 60, 61, 92, 93, 163, 66, 58, 7, 8, 57, 29, 28, 74, 59, 80, 16, 70, 77, 62, 15, 68, 75, 76, 45, 52, 53, 54, 55, 56, 63, 73, 72, 65, 94, 64 };
    jdField_a_of_type_ArrayOfJavaLangString = new String[] { "🕹", "🎮", "🔊", "🔉", "🔈", "📢", "✉", "📨", "📧", "📩", "💌", "📪", "📫", "📬", "📮", "🎈", "📍" };
  }
  
  public static long a(QQAppInterface paramQQAppInterface)
  {
    return BaseApplicationImpl.getApplication().getSharedPreferences("game_center_sp", 0).getLong("sp_top_last_time" + paramQQAppInterface.getCurrentAccountUin(), 0L);
  }
  
  public static long a(String paramString)
  {
    return BaseApplicationImpl.getApplication().getSharedPreferences("game_center_sp", 0).getLong("sp_last_game_session_clicked" + paramString, 0L);
  }
  
  public static long a(String paramString1, String paramString2)
  {
    return BaseApplicationImpl.getApplication().getSharedPreferences("game_center_sp", 0).getLong(paramString2 + paramString1, 0L);
  }
  
  public static Intent a(Context paramContext, QQMessageFacade.Message paramMessage, QQAppInterface paramQQAppInterface)
  {
    Intent localIntent = new Intent(paramContext, GameCenterActivity.class);
    String str1 = paramMessage.frienduin;
    localIntent.putExtra("uin", str1);
    localIntent.putExtra("uintype", 10007);
    if (paramQQAppInterface != null) {}
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "getIntentFromMsg is called!.");
      }
      paramContext = paramQQAppInterface.getConversationFacade().b(str1, 10007);
      if (paramContext == null) {
        break label369;
      }
      str2 = paramContext.tinyInfo.fromRoleId;
      str3 = paramContext.tinyInfo.toRoleId;
      QLog.i(jdField_a_of_type_JavaLangString, 1, "[getIntentFromMsg], uin:" + str1 + ",fRoleId:" + str2 + ",mRoleId:" + str3);
      localObject = (avds)paramQQAppInterface.getManager(QQManagerFactory.GAME_CENTER_MSG_MANAGER);
      paramContext = ((avds)localObject).a(str3);
      if (paramContext == null) {
        break label402;
      }
      paramContext = ((avds)localObject).a(paramContext.c);
      if ((paramContext == null) || (paramContext.mSyncSwitch == 1)) {
        break label402;
      }
      i = 0;
    }
    catch (Throwable paramContext)
    {
      for (;;)
      {
        String str2;
        String str3;
        Object localObject;
        label369:
        QLog.e(jdField_a_of_type_JavaLangString, 1, "getIntentFromMsg is called!. error", paramContext);
        continue;
        continue;
        int i = 1;
      }
    }
    paramContext = ((avds)localObject).b();
    if (i == 0)
    {
      localObject = ((avds)localObject).a(str1);
      if (localObject != null)
      {
        paramContext = paramContext + "&&gameId=" + ((GameCenterSessionInfo)localObject).e() + "&gameName=" + ((GameCenterSessionInfo)localObject).f() + "&sessionId=" + ((GameCenterSessionInfo)localObject).d() + "&requestCount=" + ((GameCenterSessionInfo)localObject).b();
        localIntent.putExtra("url", paramContext);
        localIntent.putExtra("sessionType", i);
        localIntent.putExtra("sessionId", str1);
        localIntent.putExtra("roleId", str2);
        localIntent.putExtra("myRoleId", str3);
        localIntent.addFlags(268435456);
        localIntent.putExtra("startOpenPageTime", System.currentTimeMillis());
        localIntent.putExtra("big_brother_source_key", "biz_src_zf_games");
        localIntent.putExtra("game_msg_enter_from", 1);
        a(paramQQAppInterface, paramMessage.frienduin, 10006, 2);
        return localIntent;
      }
    }
  }
  
  public static Bitmap a(QQMessageFacade.Message paramMessage, QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {
      return null;
    }
    paramMessage = avdv.b(paramMessage);
    Object localObject;
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localObject = jdField_a_of_type_JavaLangString;
      localStringBuilder = new StringBuilder().append("[getGameRoleBitmap],roleId:").append(paramMessage).append(" thread column = ");
      if (Looper.getMainLooper() != Looper.myLooper()) {
        break label125;
      }
    }
    long l1;
    label125:
    for (boolean bool = true;; bool = false)
    {
      QLog.d((String)localObject, 2, bool);
      l1 = SystemClock.elapsedRealtime();
      paramQQAppInterface = ((avds)paramQQAppInterface.getManager(QQManagerFactory.GAME_CENTER_MSG_MANAGER)).a(paramMessage);
      if (paramQQAppInterface != null) {
        break;
      }
      QLog.w(jdField_a_of_type_JavaLangString, 1, "getGameRoleBitmap usrInfo is null, roleId:" + paramMessage);
      return null;
    }
    if (TextUtils.isEmpty(paramQQAppInterface.mFaceUrl))
    {
      QLog.w(jdField_a_of_type_JavaLangString, 1, " getGameRoleBitmap faceurl is null, roleId:" + paramMessage);
      return null;
    }
    paramMessage = AbsDownloader.getFile(paramQQAppInterface.mFaceUrl);
    if ((paramMessage != null) && (paramMessage.exists()))
    {
      paramQQAppInterface = BitmapFactory.decodeFile(paramMessage.getAbsolutePath());
      paramMessage = paramQQAppInterface;
      if (QLog.isColorLevel())
      {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "getGameRoleBitmap is called!.decode from file" + paramQQAppInterface);
        paramMessage = paramQQAppInterface;
      }
    }
    for (;;)
    {
      long l2 = SystemClock.elapsedRealtime();
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "getGameRoleBitmap is called!. total cost = " + (l2 - l1));
      }
      return paramMessage;
      paramMessage = BaseApplicationImpl.getApplication().getResources().getDrawable(2130840422);
      localObject = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = paramMessage;
      ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = paramMessage;
      try
      {
        paramMessage = URLDrawable.getDrawable(new URL(paramQQAppInterface.mFaceUrl), (URLDrawable.URLDrawableOptions)localObject);
      }
      catch (MalformedURLException paramQQAppInterface)
      {
        for (;;)
        {
          try
          {
            paramMessage.setTag(bgxc.b(100, 100, 6));
            paramMessage.setDecodeHandler(bgxc.a);
            if (paramMessage == null) {
              continue;
            }
            paramMessage = paramMessage.getCurrDrawable();
            if (QLog.isColorLevel()) {
              QLog.d(jdField_a_of_type_JavaLangString, 2, "getGameRoleBitmap is called!." + paramMessage.getClass().getSimpleName());
            }
            if (!(paramMessage instanceof BitmapDrawable)) {
              continue;
            }
            paramQQAppInterface = ((BitmapDrawable)paramMessage).getBitmap();
            paramMessage = paramQQAppInterface;
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.d(jdField_a_of_type_JavaLangString, 2, "getGameRoleBitmap is called!. bitmap = " + paramQQAppInterface);
            paramMessage = paramQQAppInterface;
          }
          catch (MalformedURLException paramQQAppInterface)
          {
            continue;
            paramMessage = null;
          }
          paramQQAppInterface = paramQQAppInterface;
          paramMessage = null;
          paramQQAppInterface.printStackTrace();
        }
      }
    }
  }
  
  public static URLDrawable a(Context paramContext, QQAppInterface paramQQAppInterface, String paramString)
  {
    if (paramQQAppInterface == null) {
      return null;
    }
    paramQQAppInterface = ((avds)paramQQAppInterface.getManager(QQManagerFactory.GAME_CENTER_MSG_MANAGER)).a(paramString);
    if (paramQQAppInterface == null)
    {
      QLog.w(jdField_a_of_type_JavaLangString, 1, "usrInfo is null, roleId:" + paramString);
      return null;
    }
    if (TextUtils.isEmpty(paramQQAppInterface.mFaceUrl))
    {
      QLog.w(jdField_a_of_type_JavaLangString, 1, "faceurl is null, roleId:" + paramString);
      return null;
    }
    paramString = paramContext.getResources().getDrawable(2130840348);
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mFailedDrawable = paramString;
    localURLDrawableOptions.mLoadingDrawable = paramString;
    localURLDrawableOptions.mRequestWidth = AIOUtils.dp2px(60.0F, paramContext.getResources());
    localURLDrawableOptions.mRequestHeight = AIOUtils.dp2px(60.0F, paramContext.getResources());
    try
    {
      paramContext = URLDrawable.getDrawable(new URL(paramQQAppInterface.mFaceUrl), localURLDrawableOptions);
      try
      {
        paramContext.setTag(bgxc.b(100, 100, 6));
        paramContext.setDecodeHandler(bgxc.a);
        return paramContext;
      }
      catch (MalformedURLException paramQQAppInterface) {}
    }
    catch (MalformedURLException paramQQAppInterface)
    {
      for (;;)
      {
        paramContext = null;
      }
    }
    paramQQAppInterface.printStackTrace();
    return paramContext;
  }
  
  public static CharSequence a(QQAppInterface paramQQAppInterface, RecentBaseData paramRecentBaseData, CharSequence paramCharSequence)
  {
    if ((paramQQAppInterface == null) || (paramRecentBaseData == null)) {
      return paramCharSequence;
    }
    try
    {
      paramQQAppInterface = a(paramQQAppInterface, paramQQAppInterface.getMessageFacade().getLastMessage(paramRecentBaseData.getRecentUserUin(), paramRecentBaseData.getRecentUserType()), paramCharSequence);
      return paramQQAppInterface;
    }
    catch (Throwable paramQQAppInterface) {}
    return paramCharSequence;
  }
  
  public static String a(int paramInt)
  {
    if (paramInt > 99) {
      return "99+";
    }
    return paramInt + "";
  }
  
  public static String a(long paramLong)
  {
    Object localObject = Calendar.getInstance();
    ((Calendar)localObject).set(((Calendar)localObject).get(1), ((Calendar)localObject).get(2), ((Calendar)localObject).get(5) - 1, 0, 0, 0);
    long l = ((Calendar)localObject).getTime().getTime();
    if (a(paramLong))
    {
      localObject = new Date(paramLong);
      return new SimpleDateFormat("HH:mm").format((Date)localObject);
    }
    if (paramLong > l) {
      return "昨天";
    }
    if (paramLong > l - 518400000L) {
      return "两天前";
    }
    if (paramLong > l - 2505600000L) {
      return "一周前";
    }
    return "一月前";
  }
  
  public static String a(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord, CharSequence paramCharSequence)
  {
    paramCharSequence = BaseApplicationImpl.getContext().getString(2131692697) + paramCharSequence;
    if (paramQQAppInterface == null) {
      return paramCharSequence;
    }
    paramMessageRecord = avdv.a(paramMessageRecord);
    if (TextUtils.isEmpty(paramMessageRecord)) {
      return paramCharSequence;
    }
    paramQQAppInterface = (avds)paramQQAppInterface.getManager(QQManagerFactory.GAME_CENTER_MSG_MANAGER);
    paramMessageRecord = paramQQAppInterface.a(paramMessageRecord);
    if (paramMessageRecord == null) {
      return paramCharSequence;
    }
    paramQQAppInterface = paramQQAppInterface.a(paramMessageRecord.c);
    if ((paramQQAppInterface == null) || (paramQQAppInterface.mSyncSwitch == 1)) {
      return paramCharSequence;
    }
    return BaseApplicationImpl.getContext().getString(2131692698) + paramMessageRecord.i;
  }
  
  public static String a(MessageRecord paramMessageRecord, QQAppInterface paramQQAppInterface)
  {
    if ((paramMessageRecord != null) && (paramQQAppInterface != null))
    {
      String str = avdv.b(paramMessageRecord);
      paramQQAppInterface = ((avds)paramQQAppInterface.getManager(QQManagerFactory.GAME_CENTER_MSG_MANAGER)).a(str);
      if ((paramQQAppInterface != null) && (!TextUtils.isEmpty(paramQQAppInterface.mNickInGame))) {
        return paramQQAppInterface.mNickInGame;
      }
      paramMessageRecord = new TinyInfo(paramMessageRecord.getExtInfoFromExtStr("ext_key_game_msg_info"));
      if (!TextUtils.isEmpty(paramMessageRecord.nickName)) {
        return paramMessageRecord.nickName;
      }
    }
    return BaseApplicationImpl.getApplication().getResources().getString(2131692694);
  }
  
  public static String a(String paramString, QQAppInterface paramQQAppInterface)
  {
    Object localObject = paramQQAppInterface.getConversationFacade().a(paramString, 10007);
    if ((localObject != null) && (((ConversationInfo)localObject).tinyInfo != null))
    {
      localObject = ((avds)paramQQAppInterface.getManager(QQManagerFactory.GAME_CENTER_MSG_MANAGER)).a(((ConversationInfo)localObject).tinyInfo.fromRoleId);
      if ((localObject != null) && (!TextUtils.isEmpty(((GameUserInfo)localObject).mNickInGame))) {
        return ((GameUserInfo)localObject).mNickInGame;
      }
      paramString = paramQQAppInterface.getMessageProxy(10007).a(paramString, 10007);
      if (paramString != null)
      {
        paramString = new TinyInfo(paramString.getExtInfoFromExtStr("ext_key_game_msg_info"));
        if (!TextUtils.isEmpty(paramString.nickName)) {
          return paramString.nickName;
        }
      }
    }
    return BaseApplicationImpl.getApplication().getResources().getString(2131692694);
  }
  
  public static void a(int paramInt1, int paramInt2)
  {
    String str = b(paramInt1);
    bdla.b(null, "dc00898", "", "", str, str, paramInt2, 0, "", "", "", "");
  }
  
  public static void a(Context paramContext, avdr paramavdr)
  {
    QLog.i(jdField_a_of_type_JavaLangString, 1, "[startGame]");
    if (paramavdr == null)
    {
      QLog.w(jdField_a_of_type_JavaLangString, 1, "fail to start game, detailInfo is null.");
      return;
    }
    QLog.i(jdField_a_of_type_JavaLangString, 1, "appId:" + paramavdr.c);
    String str2 = paramavdr.l;
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = GameBasicInfo.getDefaultGameLaunchUrl(paramavdr.c);
    }
    paramavdr = new Intent(paramContext, QQBrowserActivity.class);
    paramavdr.putExtra("url", str1);
    paramContext.startActivity(paramavdr);
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    a(paramContext, paramString1, paramString2, paramString3, 0);
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, String paramString3, int paramInt)
  {
    QLog.i(jdField_a_of_type_JavaLangString, 1, "[enterGameMsgChatPie], convertUin:" + paramString1 + ",fRoleId:" + paramString2 + ",mRoleId:" + paramString3 + ", clickFrom = " + paramInt);
    Intent localIntent = new Intent(paramContext, ChatActivity.class);
    localIntent.putExtra("uin", paramString1);
    localIntent.putExtra("game_msg_friend_role_id", paramString2);
    localIntent.putExtra("game_msg_my_role_id", paramString3);
    localIntent.putExtra("uintype", 10007);
    localIntent.putExtra("game_msg_enter_from", paramInt);
    localIntent.putExtra("game_msg_open_aio_from", 1);
    localIntent.addFlags(268435456);
    paramContext.startActivity(localIntent);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, GameCenterSessionInfo paramGameCenterSessionInfo)
  {
    if ((paramQQAppInterface == null) || (paramGameCenterSessionInfo == null) || (paramContext == null)) {
      return;
    }
    paramQQAppInterface = (avds)paramQQAppInterface.getManager(QQManagerFactory.GAME_CENTER_MSG_MANAGER);
    Intent localIntent = new Intent(paramContext, GameCenterActivity.class);
    String str = paramQQAppInterface.b();
    paramQQAppInterface = str;
    if (paramGameCenterSessionInfo != null)
    {
      paramQQAppInterface = str;
      if (paramGameCenterSessionInfo.a() == 0) {
        paramQQAppInterface = str + "&&gameId=" + paramGameCenterSessionInfo.e() + "&gameName=" + paramGameCenterSessionInfo.f() + "&sessionId=" + paramGameCenterSessionInfo.d() + "&requestCount=" + paramGameCenterSessionInfo.b();
      }
    }
    localIntent.putExtra("url", paramQQAppInterface);
    if (paramGameCenterSessionInfo != null)
    {
      localIntent.putExtra("sessionType", paramGameCenterSessionInfo.a());
      localIntent.putExtra("sessionId", paramGameCenterSessionInfo.d());
      localIntent.putExtra("roleId", paramGameCenterSessionInfo.c());
      localIntent.putExtra("myRoleId", paramGameCenterSessionInfo.b());
    }
    localIntent.addFlags(268435456);
    localIntent.putExtra("startOpenPageTime", System.currentTimeMillis());
    localIntent.putExtra("big_brother_source_key", "biz_src_zf_games");
    localIntent.putExtra("game_msg_open_aio_from", 2);
    paramContext.startActivity(localIntent);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, String paramString)
  {
    if (paramQQAppInterface != null) {}
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "enterGameMsgChatPie is called.");
      }
      Object localObject = paramQQAppInterface.getConversationFacade().b(paramString, 10007);
      if (localObject != null)
      {
        String str1 = ((ConversationInfo)localObject).tinyInfo.fromRoleId;
        String str2 = ((ConversationInfo)localObject).tinyInfo.toRoleId;
        GameCenterSessionInfo localGameCenterSessionInfo = ((avds)paramQQAppInterface.getManager(QQManagerFactory.GAME_CENTER_MSG_MANAGER)).a(paramString);
        localObject = localGameCenterSessionInfo;
        if (localGameCenterSessionInfo == null) {
          localObject = new GameCenterSessionInfo();
        }
        ((GameCenterSessionInfo)localObject).e(paramString);
        ((GameCenterSessionInfo)localObject).d(str1);
        ((GameCenterSessionInfo)localObject).b(str2);
        a(paramQQAppInterface, paramContext, (GameCenterSessionInfo)localObject);
        a(paramQQAppInterface, paramString, 10004, 1);
      }
      return;
    }
    catch (Exception paramQQAppInterface)
    {
      paramQQAppInterface.printStackTrace();
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, QQMessageFacade.Message paramMessage, MsgSummary paramMsgSummary, RecentItemPublicAccountChatMsgData paramRecentItemPublicAccountChatMsgData)
  {
    long l1 = System.currentTimeMillis();
    Object localObject = paramQQAppInterface.getMessageFacade().getLastMsgForMsgTab("2747277822", 1008);
    avds localavds = (avds)paramQQAppInterface.getManager(QQManagerFactory.GAME_CENTER_MSG_MANAGER);
    if (!localavds.c()) {}
    RecentUser localRecentUser;
    GameCenterSessionInfo localGameCenterSessionInfo;
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  return;
                  localavds.b = false;
                  localavds.c = false;
                  localavds.d = false;
                  paramMessage = paramQQAppInterface.getRecentUserProxy();
                  localRecentUser = (RecentUser)paramMessage.findRecentUserByUin("2747277822", 1008);
                  paramRecentItemPublicAccountChatMsgData.mUnreadNum = (localavds.c() + paramRecentItemPublicAccountChatMsgData.mUnreadNum);
                  if ((!a((MessageRecord)localObject)) || (((MessageRecord)localObject).isread)) {
                    break;
                  }
                } while (!QLog.isColorLevel());
                QLog.d(jdField_a_of_type_JavaLangString, 2, "[buildMessageBody] has unread public account message.return.");
                return;
                localGameCenterSessionInfo = localavds.a();
              } while (localGameCenterSessionInfo == null);
              if (!a((MessageRecord)localObject)) {
                break;
              }
            } while (((MessageRecord)localObject).time > localGameCenterSessionInfo.a());
            if ((localavds.a) || (localGameCenterSessionInfo.a() != 1)) {
              break;
            }
          } while (!QLog.isColorLevel());
          QLog.d(jdField_a_of_type_JavaLangString, 2, "[buildMessageBody] show operating msg.return.");
          return;
          if (QLog.isColorLevel()) {
            QLog.d(jdField_a_of_type_JavaLangString, 2, "[buildMessageBody] last info:" + localGameCenterSessionInfo + ",  msg:" + localObject);
          }
          if ((localGameCenterSessionInfo != null) && (localGameCenterSessionInfo.a() != 0L)) {
            break;
          }
        } while (a((MessageRecord)localObject));
        paramQQAppInterface = (RecentUser)paramMessage.findRecentUserByUin("2747277822", 1008);
      } while (paramQQAppInterface == null);
      paramMessage.delRecentUser(paramQQAppInterface);
      return;
    } while ((localGameCenterSessionInfo.c() <= 0) && (localObject != null) && (localGameCenterSessionInfo.a() <= ((MessageRecord)localObject).time));
    if (localGameCenterSessionInfo.a() == 0)
    {
      paramMsgSummary.strContent = new QQText("[" + localGameCenterSessionInfo.b() + "位好友请求] 来自" + localGameCenterSessionInfo.f(), 3, 16, -1);
      long l2 = a(paramQQAppInterface);
      paramRecentItemPublicAccountChatMsgData.mDisplayTime = localGameCenterSessionInfo.a();
      if ((localavds.a() == 1L) || ((!a(l2)) && (a(localGameCenterSessionInfo.a() * 1000L))))
      {
        localRecentUser.lastmsgtime = localGameCenterSessionInfo.a();
        paramRecentItemPublicAccountChatMsgData.mDisplayTime = localGameCenterSessionInfo.a();
        paramMessage = BaseApplicationImpl.getApplication().getSharedPreferences("game_center_sp", 0);
        paramQQAppInterface = "sp_top_last_time" + paramQQAppInterface.getCurrentAccountUin();
        paramMessage.edit().putLong(paramQQAppInterface, System.currentTimeMillis()).commit();
      }
      label495:
      localavds.b = true;
      if (localavds.c() == 0) {
        break label887;
      }
      localavds.c = true;
      if (localavds.a(false) == 0) {
        localavds.d = true;
      }
    }
    label887:
    for (int i = 0;; i = 1)
    {
      a(localGameCenterSessionInfo.e(), "1", "145", "920", "92003", "206345", i + "", localGameCenterSessionInfo.a() + "", "0", "8", "0", "", "");
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d(jdField_a_of_type_JavaLangString, 2, "[buildMessageBody] msgSummary:" + paramMsgSummary.toString() + "，user:" + localRecentUser.lastmsgtime + " ， cost time:" + (System.currentTimeMillis() - l1));
      return;
      localObject = localGameCenterSessionInfo.h();
      paramMessage = localavds.c();
      paramQQAppInterface = paramMessage;
      if (!TextUtils.isEmpty(paramMessage)) {}
      try
      {
        i = paramMessage.indexOf("<");
        int j = paramMessage.indexOf(">");
        paramQQAppInterface = paramMessage;
        if (j >= 0)
        {
          paramQQAppInterface = paramMessage;
          if (i >= 0)
          {
            paramQQAppInterface = paramMessage.substring(i, j + 1);
            j = Integer.parseInt(paramQQAppInterface.substring(1, paramQQAppInterface.length() - 1));
            i = j;
            if (j >= jdField_a_of_type_ArrayOfJavaLangString.length) {
              i = 0;
            }
            paramQQAppInterface = paramMessage.replace(paramQQAppInterface, jdField_a_of_type_ArrayOfJavaLangString[i]);
          }
        }
      }
      catch (Exception paramMessage)
      {
        for (;;)
        {
          paramQQAppInterface = c;
          QLog.e(jdField_a_of_type_JavaLangString, 2, paramMessage, new Object[0]);
        }
      }
      paramMsgSummary.strContent = new QQText(paramQQAppInterface + " " + (String)localObject + ": " + localGameCenterSessionInfo.i(), 3, 16, -1);
      localRecentUser.lastmsgtime = localGameCenterSessionInfo.a();
      paramRecentItemPublicAccountChatMsgData.mDisplayTime = localGameCenterSessionInfo.a();
      break label495;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, int paramInt1, int paramInt2)
  {
    if (paramQQAppInterface == null) {}
    String str;
    do
    {
      return;
      str = b(paramInt1);
      try
      {
        paramQQAppInterface = paramQQAppInterface.getMessageProxy(10007).a(paramString, 10007);
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "report called with: key = [" + str + "], from = [" + paramInt1 + "], fromType = [" + paramInt2 + "]");
        }
        if (paramQQAppInterface == null)
        {
          QLog.d(jdField_a_of_type_JavaLangString, 1, "report called with: conversationInfo null. key = [" + str + "], from = [" + paramInt1 + "], fromType = [" + paramInt2 + "]");
          return;
        }
      }
      catch (Exception paramQQAppInterface)
      {
        QLog.e(jdField_a_of_type_JavaLangString, 1, "report called with:  key = [" + str + "], fromType = [" + paramInt1 + "], fromType = [" + paramInt2 + "]", paramQQAppInterface);
        return;
      }
      paramString = paramQQAppInterface.getExtInfoFromExtStr("ext_key_game_msg_info");
    } while (TextUtils.isEmpty(paramString));
    bdla.b(null, "dc00898", "", "", str, str, paramInt2, 0, String.valueOf(new TinyInfo(paramString, paramQQAppInterface.isSend()).gameAppId), "", "", "");
  }
  
  public static void a(String paramString, long paramLong)
  {
    SharedPreferences localSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("game_center_sp", 0);
    paramString = "sp_top_clean_time" + paramString;
    localSharedPreferences.edit().putLong(paramString, paramLong).commit();
  }
  
  public static void a(String paramString, Context paramContext, GameCenterSessionInfo paramGameCenterSessionInfo)
  {
    if (paramContext == null) {
      return;
    }
    Intent localIntent = new Intent(paramContext, GameCenterActivity.class);
    String str = paramString;
    if (paramGameCenterSessionInfo != null)
    {
      str = paramString;
      if (paramGameCenterSessionInfo.a() == 0) {
        str = paramString + "&&gameId=" + paramGameCenterSessionInfo.e() + "&gameName=" + paramGameCenterSessionInfo.f() + "&sessionId=" + paramGameCenterSessionInfo.d() + "&requestCount=" + paramGameCenterSessionInfo.b();
      }
    }
    localIntent.putExtra("url", str);
    if (paramGameCenterSessionInfo != null)
    {
      localIntent.putExtra("sessionType", paramGameCenterSessionInfo.a());
      localIntent.putExtra("sessionId", paramGameCenterSessionInfo.d());
      localIntent.putExtra("roleId", paramGameCenterSessionInfo.c());
      localIntent.putExtra("myRoleId", paramGameCenterSessionInfo.b());
    }
    localIntent.addFlags(268435456);
    localIntent.putExtra("startOpenPageTime", System.currentTimeMillis());
    localIntent.putExtra("big_brother_source_key", "biz_src_zf_games");
    paramContext.startActivity(localIntent);
  }
  
  public static void a(String paramString1, String paramString2, long paramLong)
  {
    SharedPreferences localSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("game_center_sp", 0);
    paramString1 = paramString2 + paramString1;
    localSharedPreferences.edit().putLong(paramString1, paramLong).commit();
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10)
  {
    a(paramString1, paramString2, paramString3, paramString4, paramString5, paramString6, paramString7, paramString8, paramString9, paramString10, "", "");
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11, String paramString12)
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    try
    {
      JSONObject localJSONObject1 = new JSONObject();
      JSONArray localJSONArray = new JSONArray();
      JSONObject localJSONObject2 = new JSONObject();
      JSONObject localJSONObject3 = new JSONObject();
      localJSONObject3.put("sq_ver", "8.4.10");
      localJSONObject3.put("device_type", Build.BRAND);
      localJSONObject3.put("gameappid", paramString1);
      localJSONObject3.put("ext12", paramString3);
      localJSONObject3.put("ext11", paramString2);
      localJSONObject3.put("ext1", paramString5);
      localJSONObject3.put("oper_moudle", paramString4);
      localJSONObject3.put("oper_id", paramString6);
      localJSONObject3.put("ext2", paramString7);
      localJSONObject3.put("ext3", paramString8);
      localJSONObject3.put("ext4", paramString9);
      localJSONObject3.put("ext6", paramString10);
      localJSONObject3.put("ext7", paramString11);
      localJSONObject3.put("ext8", paramString12);
      localJSONObject2.put("data", localJSONObject3);
      localJSONObject2.put("dc_id", "dc00087");
      localJSONArray.put(localJSONObject2);
      localJSONObject1.put("report_list", localJSONArray);
      if (localAppRuntime != null)
      {
        bmqt.a().a(localAppRuntime, "dc_qqgame", localJSONObject1.toString());
        return;
      }
      bdka.a(null, "dc_qqgame", localJSONObject1.toString());
      return;
    }
    catch (Exception paramString1)
    {
      QLog.e(jdField_a_of_type_JavaLangString, 1, paramString1, new Object[0]);
    }
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11, String paramString12, String paramString13)
  {
    paramString11 = BaseApplicationImpl.getApplication().getRuntime();
    try
    {
      JSONObject localJSONObject1 = new JSONObject();
      JSONArray localJSONArray = new JSONArray();
      JSONObject localJSONObject2 = new JSONObject();
      JSONObject localJSONObject3 = new JSONObject();
      localJSONObject3.put("sq_ver", "8.4.10");
      localJSONObject3.put("device_type", Build.BRAND);
      localJSONObject3.put("gameappid", paramString1);
      localJSONObject3.put("ext12", paramString3);
      localJSONObject3.put("ext11", paramString2);
      localJSONObject3.put("ext1", paramString5);
      localJSONObject3.put("oper_moudle", paramString4);
      localJSONObject3.put("oper_id", paramString6);
      localJSONObject3.put("logic_id", paramString7);
      localJSONObject3.put("ext2", paramString8);
      localJSONObject3.put("ext3", paramString9);
      localJSONObject3.put("ext4", paramString10);
      localJSONObject3.put("ext6", paramString7);
      localJSONObject3.put("ext10", paramString12);
      localJSONObject3.put("ext11", paramString13);
      localJSONObject2.put("data", localJSONObject3);
      localJSONObject2.put("dc_id", "dc00087");
      localJSONArray.put(localJSONObject2);
      localJSONObject1.put("report_list", localJSONArray);
      if (paramString11 != null)
      {
        bmqt.a().a(paramString11, "dc_qqgame", localJSONObject1.toString());
        return;
      }
      bdka.a(null, "dc_qqgame", localJSONObject1.toString());
      return;
    }
    catch (Exception paramString1)
    {
      QLog.e(jdField_a_of_type_JavaLangString, 1, paramString1, new Object[0]);
    }
  }
  
  public static void a(String paramString, boolean paramBoolean)
  {
    SharedPreferences localSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("game_center_sp", 0);
    paramString = "sp_game_session_shown" + paramString;
    localSharedPreferences.edit().putBoolean(paramString, paramBoolean).commit();
  }
  
  public static boolean a(long paramLong)
  {
    return a(paramLong, "yyyy-MM-dd");
  }
  
  private static boolean a(long paramLong, String paramString)
  {
    Date localDate = new Date(paramLong);
    paramString = new SimpleDateFormat(paramString);
    return paramString.format(localDate).equals(paramString.format(new Date()));
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {
      return false;
    }
    AccountDetail localAccountDetail = ((aoan)paramQQAppInterface.getManager(QQManagerFactory.PUBLICACCOUNTDATA_MANAGER)).a("2747277822");
    boolean bool;
    if (localAccountDetail == null)
    {
      uuc.a(paramQQAppInterface, paramQQAppInterface.getApplication(), "2747277822");
      bool = false;
    }
    for (;;)
    {
      if (QLog.isColorLevel())
      {
        paramQQAppInterface = "";
        if (localAccountDetail != null) {
          paramQQAppInterface = "followType:" + localAccountDetail.followType + ",isRecvMsg:" + localAccountDetail.isRecvMsg + ",isRecvPush:" + localAccountDetail.isRecvPush + ",mShowMsgFlag:" + localAccountDetail.mShowMsgFlag;
        }
        QLog.d(jdField_a_of_type_JavaLangString, 2, "[isPubAccountReceiveMsg], detail:" + paramQQAppInterface + "ret:" + bool);
      }
      return bool;
      if (localAccountDetail.followType == 1) {
        bool = true;
      } else {
        bool = false;
      }
    }
  }
  
  public static boolean a(MessageRecord paramMessageRecord)
  {
    boolean bool2 = true;
    boolean bool1;
    if (paramMessageRecord != null)
    {
      bool1 = bool2;
      if (TextUtils.isEmpty(paramMessageRecord.msg))
      {
        bool1 = bool2;
        if (paramMessageRecord.time != 0L) {}
      }
    }
    else
    {
      bool1 = false;
    }
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "[checkMesssageIsValid] ret = " + bool1);
    }
    return bool1;
  }
  
  public static boolean a(String paramString)
  {
    return BaseApplicationImpl.getApplication().getSharedPreferences("game_center_sp", 0).getBoolean("sp_game_session_shown" + paramString, true);
  }
  
  private static String b(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "";
    case 10001: 
      return "0X800AD42";
    case 10002: 
      return "0X800AD41";
    case 10003: 
      return "0X800AD40";
    case 10004: 
      return "0X800AD3F";
    case 10005: 
      return "0X800AD3E";
    }
    return "0X800AD3D";
  }
  
  public static void b(String paramString, long paramLong)
  {
    SharedPreferences localSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("game_center_sp", 0);
    paramString = "sp_last_game_session_clicked" + paramString;
    localSharedPreferences.edit().putLong(paramString, paramLong).commit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avdu
 * JD-Core Version:    0.7.0.1
 */