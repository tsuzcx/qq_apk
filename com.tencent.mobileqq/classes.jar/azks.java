import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.util.ArrayMap;
import android.text.SpannableString;
import android.text.TextUtils;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.HotChatInfo;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.data.MessageForReplyText;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageForText.AtTroopMemberInfo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.troop.org.pb.oidb_0x496.Robot;
import com.tencent.mobileqq.troop.org.pb.oidb_0x496.RobotSubscribeCategory;
import com.tencent.mobileqq.troop.org.pb.oidb_0x496.UinRange;
import com.tencent.mobileqq.troop.utils.TroopRobotManager.1;
import com.tencent.mobileqq.troop.utils.TroopRobotManager.3;
import com.tencent.mobileqq.troop.utils.TroopRobotManager.6;
import com.tencent.mobileqq.troop.utils.TroopRobotManager.7;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import mqq.manager.Manager;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.oidb.cmd0x934.cmd0x934.ReqBody;
import tencent.im.oidb.cmd0x934.cmd0x934.RspBody;

public class azks
  implements Manager
{
  static Object jdField_a_of_type_JavaLangObject = new Object();
  protected int a;
  private ajjh jdField_a_of_type_Ajjh;
  protected Handler a;
  protected ArrayMap<Long, ArrayList<azkr>> a;
  protected AppInterface a;
  protected String a;
  public WeakReference<azlb> a;
  protected ArrayList<String> a;
  protected HashMap<Long, MessageForUniteGrayTip> a;
  protected List<azlc> a;
  public boolean a;
  protected ArrayMap<Long, ArrayList<azkr>> b;
  public String b;
  HashMap<String, Long> jdField_b_of_type_JavaUtilHashMap = new HashMap();
  protected List<String> b;
  private boolean jdField_b_of_type_Boolean;
  protected ArrayMap<Long, Integer> c;
  public String c;
  private HashMap<String, ArrayList<String>> c;
  protected List<String> c;
  public String d;
  protected List<String> d;
  public String e;
  List<oidb_0x496.RobotSubscribeCategory> e = new ArrayList();
  private String f = "";
  private String g = "";
  private String h;
  
  public azks(AppInterface paramAppInterface)
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList(5);
    this.jdField_b_of_type_JavaUtilList = new ArrayList(5);
    this.jdField_c_of_type_JavaUtilList = new ArrayList(5);
    this.jdField_d_of_type_JavaUtilList = new ArrayList(5);
    this.jdField_a_of_type_Int = 60000;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_c_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_AndroidSupportV4UtilArrayMap = new ArrayMap(20);
    this.jdField_b_of_type_AndroidSupportV4UtilArrayMap = new ArrayMap(50);
    this.jdField_c_of_type_AndroidSupportV4UtilArrayMap = new ArrayMap(50);
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    this.jdField_c_of_type_JavaUtilList.add(ajjy.a(2131649967));
    this.jdField_d_of_type_JavaUtilList.add(ajjy.a(2131649953));
    ThreadManager.post(new TroopRobotManager.1(this), 5, null, true);
    b();
  }
  
  private void a(QQAppInterface paramQQAppInterface)
  {
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (this.jdField_a_of_type_JavaUtilArrayList == null)
      {
        QLog.d("TroopRobotManager", 2, "initRobotRedInRedList ");
        this.jdField_a_of_type_JavaUtilArrayList = azgu.a(paramQQAppInterface);
        if (this.jdField_a_of_type_JavaUtilArrayList == null) {
          this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
        }
      }
      return;
    }
  }
  
  public static void a(MessageRecord paramMessageRecord)
  {
    if (!TextUtils.isEmpty(paramMessageRecord.msg))
    {
      Object localObject = baea.d.matcher(paramMessageRecord.msg);
      if (((Matcher)localObject).find())
      {
        localObject = ((Matcher)localObject).group(0);
        int i = paramMessageRecord.msg.indexOf((String)localObject);
        if (i >= 0)
        {
          String str = paramMessageRecord.msg.substring(0, i);
          paramMessageRecord.saveExtInfoToExtStr("robot_short_link_url", (String)localObject);
          paramMessageRecord.saveExtInfoToExtStr("robot_short_link_description", str);
          paramMessageRecord.saveExtInfoToExtStr("robot_processed", "true");
        }
      }
    }
  }
  
  private void a(MessageRecord paramMessageRecord, String paramString)
  {
    SharedPreferences localSharedPreferences = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApp().getSharedPreferences("robot_subcribmsg_timestamp", 0);
    long l;
    if (!this.jdField_b_of_type_JavaUtilHashMap.containsKey(paramString))
    {
      l = localSharedPreferences.getLong(paramString, 0L);
      this.jdField_b_of_type_JavaUtilHashMap.put(paramString, Long.valueOf(l));
    }
    for (;;)
    {
      if (paramMessageRecord.shmsgseq > ((Long)this.jdField_b_of_type_JavaUtilHashMap.get(paramString)).longValue())
      {
        localSharedPreferences.edit().putLong(paramString, paramMessageRecord.shmsgseq).commit();
        this.jdField_b_of_type_JavaUtilHashMap.put(paramString, Long.valueOf(paramMessageRecord.shmsgseq));
      }
      return;
      l = Math.max(((Long)this.jdField_b_of_type_JavaUtilHashMap.get(paramString)).longValue(), localSharedPreferences.getLong(paramString, 0L));
      localSharedPreferences.edit().putLong(paramString, l).commit();
      this.jdField_b_of_type_JavaUtilHashMap.put(paramString, Long.valueOf(l));
    }
  }
  
  private void a(MessageRecord paramMessageRecord, String paramString1, String paramString2, String paramString3)
  {
    b(paramMessageRecord.frienduin, paramString1, paramString2);
    b(Long.parseLong(paramMessageRecord.frienduin), Long.parseLong(paramString1), paramString3, new azkx(this, paramString3));
  }
  
  private void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    QQAppInterface localQQAppInterface;
    do
    {
      return;
      localQQAppInterface = null;
      if ((this.jdField_a_of_type_ComTencentCommonAppAppInterface instanceof QQAppInterface)) {
        localQQAppInterface = (QQAppInterface)this.jdField_a_of_type_ComTencentCommonAppAppInterface;
      }
    } while (localQQAppInterface == null);
    baig.c(localQQAppInterface.getApplication(), localQQAppInterface.c(), paramString, false);
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    awqx.b(null, "dc00899", "Grp_robot", "", paramString1, paramString2, 0, 0, paramString3, paramString4, paramString5, paramString6);
  }
  
  private void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_AndroidOsHandler.post(new TroopRobotManager.3(this));
  }
  
  public static boolean a(TextView paramTextView, MessageRecord paramMessageRecord)
  {
    boolean bool = false;
    String str1 = paramMessageRecord.getExtInfoFromExtStr("robot_short_link_url");
    if (!TextUtils.isEmpty(str1))
    {
      paramTextView.setText(paramMessageRecord.getExtInfoFromExtStr("robot_short_link_description"));
      paramTextView.append("\r\n");
      String str2 = ajjy.a(2131649955);
      SpannableString localSpannableString = new SpannableString(str2);
      localSpannableString.setSpan(new azku(str1, paramMessageRecord), 0, str2.length(), 33);
      paramTextView.append(localSpannableString);
      bool = true;
    }
    return bool;
  }
  
  public static String b(MessageRecord paramMessageRecord)
  {
    if (b(paramMessageRecord))
    {
      String str = paramMessageRecord.getExtInfoFromExtStr("robot_short_link_url");
      paramMessageRecord = paramMessageRecord.getExtInfoFromExtStr("robot_short_link_description");
      if ((!TextUtils.isEmpty(str)) && (!TextUtils.isEmpty(paramMessageRecord))) {
        return paramMessageRecord + ajjy.a(2131649963);
      }
    }
    return null;
  }
  
  private void b()
  {
    if ((this.jdField_a_of_type_Ajjh != null) || (this.jdField_a_of_type_ComTencentCommonAppAppInterface == null) || (!(this.jdField_a_of_type_ComTencentCommonAppAppInterface instanceof QQAppInterface))) {
      return;
    }
    this.jdField_a_of_type_Ajjh = new azkv(this);
    this.jdField_a_of_type_ComTencentCommonAppAppInterface.addObserver(this.jdField_a_of_type_Ajjh);
  }
  
  public static boolean b(MessageRecord paramMessageRecord)
  {
    return false;
  }
  
  private void c()
  {
    if ((this.jdField_a_of_type_Ajjh != null) && (this.jdField_a_of_type_ComTencentCommonAppAppInterface != null))
    {
      this.jdField_a_of_type_ComTencentCommonAppAppInterface.removeObserver(this.jdField_a_of_type_Ajjh);
      this.jdField_a_of_type_Ajjh = null;
    }
  }
  
  private void d()
  {
    Object localObject1 = baig.f(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApp(), this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin());
    if (!TextUtils.isEmpty((CharSequence)localObject1)) {
      try
      {
        localObject1 = new JSONArray((String)localObject1);
        this.jdField_c_of_type_JavaUtilHashMap.clear();
        int i = 0;
        while (i < ((JSONArray)localObject1).length())
        {
          Object localObject3 = ((JSONArray)localObject1).optJSONObject(i);
          if (localObject3 != null)
          {
            String str = ((JSONObject)localObject3).optString("robotUin");
            localObject3 = ((JSONObject)localObject3).optJSONArray("barItem");
            if ((!TextUtils.isEmpty(str)) && (localObject3 != null))
            {
              ArrayList localArrayList = new ArrayList(((JSONArray)localObject3).length());
              int j = 0;
              while (j < ((JSONArray)localObject3).length())
              {
                localArrayList.add(((JSONArray)localObject3).optString(j));
                j += 1;
              }
              this.jdField_c_of_type_JavaUtilHashMap.put(str, localArrayList);
            }
          }
          i += 1;
        }
        localObject2 = baig.g(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApp(), this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin());
      }
      catch (JSONException localJSONException1)
      {
        localJSONException1.printStackTrace();
      }
    }
    Object localObject2;
    if (!TextUtils.isEmpty((CharSequence)localObject2)) {}
    try
    {
      localObject2 = new JSONObject((String)localObject2);
      this.f = ((JSONObject)localObject2).optString("userTail");
      this.g = ((JSONObject)localObject2).optString("robotTail");
      localObject2 = amka.a();
      if (localObject2 != null) {
        a(((amka)localObject2).a(), ((amka)localObject2).a());
      }
      return;
    }
    catch (JSONException localJSONException2)
    {
      for (;;)
      {
        localJSONException2.printStackTrace();
      }
    }
  }
  
  public static boolean d(MessageRecord paramMessageRecord)
  {
    paramMessageRecord = paramMessageRecord.getExtInfoFromExtStr("robot_processed");
    return (!TextUtils.isEmpty(paramMessageRecord)) && (paramMessageRecord.equals("true"));
  }
  
  public int a(long paramLong)
  {
    int i = 0;
    if (this.jdField_c_of_type_AndroidSupportV4UtilArrayMap != null) {
      synchronized (this.jdField_c_of_type_AndroidSupportV4UtilArrayMap)
      {
        if (this.jdField_c_of_type_AndroidSupportV4UtilArrayMap.containsKey(Long.valueOf(paramLong))) {
          i = ((Integer)this.jdField_c_of_type_AndroidSupportV4UtilArrayMap.get(Long.valueOf(paramLong))).intValue();
        }
        return i;
      }
    }
    return 0;
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    paramChatMessage = paramChatMessage.getExtInfoFromExtStr("robot_news_class_id");
    int i = 0;
    if (!TextUtils.isEmpty(paramChatMessage)) {}
    try
    {
      i = Integer.parseInt(paramChatMessage);
      return i;
    }
    catch (Exception paramChatMessage) {}
    return 0;
  }
  
  public azkq a(long paramLong)
  {
    azkq localazkq = new azkq();
    localazkq.jdField_a_of_type_JavaUtilArrayList = a(paramLong);
    localazkq.b = b(paramLong);
    localazkq.jdField_a_of_type_Int = a(paramLong);
    return localazkq;
  }
  
  public oidb_0x496.RobotSubscribeCategory a(int paramInt)
  {
    Iterator localIterator = this.e.iterator();
    while (localIterator.hasNext())
    {
      oidb_0x496.RobotSubscribeCategory localRobotSubscribeCategory = (oidb_0x496.RobotSubscribeCategory)localIterator.next();
      if (localRobotSubscribeCategory.id.get() == paramInt) {
        return localRobotSubscribeCategory;
      }
    }
    return null;
  }
  
  public String a()
  {
    return this.h;
  }
  
  public String a(QQAppInterface paramQQAppInterface, MessageForPtt paramMessageForPtt)
  {
    return "";
  }
  
  public String a(MessageRecord paramMessageRecord)
  {
    String str = paramMessageRecord.getExtInfoFromExtStr("robot_news_class_id");
    return paramMessageRecord.frienduin + "_" + str;
  }
  
  public ArrayList<azkr> a(long paramLong)
  {
    ArrayList localArrayList = new ArrayList(0);
    if (this.jdField_b_of_type_AndroidSupportV4UtilArrayMap != null) {
      synchronized (this.jdField_b_of_type_AndroidSupportV4UtilArrayMap)
      {
        if (this.jdField_b_of_type_AndroidSupportV4UtilArrayMap.containsKey(Long.valueOf(paramLong)))
        {
          Iterator localIterator = ((ArrayList)this.jdField_b_of_type_AndroidSupportV4UtilArrayMap.get(Long.valueOf(paramLong))).iterator();
          while (localIterator.hasNext())
          {
            azkr localazkr = (azkr)localIterator.next();
            if (localazkr.a()) {
              localArrayList.add(localazkr);
            }
          }
        }
      }
    }
    return localArrayList1;
  }
  
  public void a()
  {
    this.jdField_b_of_type_JavaLangString = null;
    this.jdField_c_of_type_JavaLangString = null;
    this.jdField_d_of_type_JavaLangString = null;
    a(false);
  }
  
  public void a(int paramInt1, long paramLong1, long paramLong2, int paramInt2, azla paramazla)
  {
    cmd0x934.ReqBody localReqBody = new cmd0x934.ReqBody();
    localReqBody.cmd.set(paramInt1, true);
    localReqBody.version.set(paramInt2, true);
    localReqBody.group_id.set(paramLong1, true);
    localReqBody.robot_uin.set(paramLong2);
    mmj.a((QQAppInterface)this.jdField_a_of_type_ComTencentCommonAppAppInterface, new azky(this, paramazla), localReqBody.toByteArray(), "OidbSvc.0x934_1", 2356, 1, new Bundle(), 12000L);
  }
  
  public void a(int paramInt, long paramLong1, long paramLong2, String paramString, azla paramazla)
  {
    cmd0x934.ReqBody localReqBody = new cmd0x934.ReqBody();
    localReqBody.cmd.set(paramInt, true);
    localReqBody.group_id.set(paramLong1, true);
    localReqBody.keyword.set(paramString, true);
    localReqBody.robot_uin.set(paramLong2);
    mmj.a((QQAppInterface)this.jdField_a_of_type_ComTencentCommonAppAppInterface, new azkz(this, paramazla), localReqBody.toByteArray(), "OidbSvc.0x934_1", 2356, 1, new Bundle(), 12000L);
  }
  
  public void a(long paramLong, int paramInt, azla paramazla)
  {
    a(4, 0L, paramLong, paramInt, paramazla);
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    MessageForUniteGrayTip localMessageForUniteGrayTip = (MessageForUniteGrayTip)this.jdField_a_of_type_JavaUtilHashMap.remove(Long.valueOf(paramLong1));
    if (localMessageForUniteGrayTip != null)
    {
      localMessageForUniteGrayTip.shmsgseq = paramLong2;
      aqay.a((QQAppInterface)this.jdField_a_of_type_ComTencentCommonAppAppInterface, localMessageForUniteGrayTip);
    }
  }
  
  public void a(long paramLong1, long paramLong2, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopRobotManager", 2, "onSetTroopRobot troopuin:" + paramLong1 + " robotuin:" + paramLong2 + " status:" + paramInt);
    }
    if (this.jdField_b_of_type_AndroidSupportV4UtilArrayMap != null) {
      for (;;)
      {
        synchronized (this.jdField_b_of_type_AndroidSupportV4UtilArrayMap)
        {
          if (this.jdField_b_of_type_AndroidSupportV4UtilArrayMap.containsKey(Long.valueOf(paramLong1)))
          {
            ArrayList localArrayList = (ArrayList)this.jdField_b_of_type_AndroidSupportV4UtilArrayMap.get(Long.valueOf(paramLong1));
            Object localObject4 = null;
            Object localObject1 = localArrayList.iterator();
            if (!((Iterator)localObject1).hasNext()) {
              break label243;
            }
            azkr localazkr = (azkr)((Iterator)localObject1).next();
            if (localazkr.a() != paramLong2) {
              continue;
            }
            localObject1 = localObject4;
            if (!localazkr.a())
            {
              localObject1 = localObject4;
              if (paramInt == 1) {
                localObject1 = localazkr;
              }
            }
            localazkr.a(paramInt);
            if (localObject1 != null)
            {
              localArrayList.remove(localObject1);
              localArrayList.add(0, localObject1);
              if (QLog.isColorLevel()) {
                QLog.d("TroopRobotManager", 2, "onSetTroopRobot move position " + ((azkr)localObject1).a());
              }
            }
          }
          return;
        }
        label243:
        Object localObject3 = null;
      }
    }
  }
  
  public void a(long paramLong1, long paramLong2, int paramInt, azla paramazla)
  {
    a(1, paramLong1, paramLong2, paramInt, paramazla);
  }
  
  public void a(long paramLong1, long paramLong2, String paramString, azla paramazla)
  {
    a(3, paramLong1, paramLong2, paramString, paramazla);
  }
  
  public void a(long paramLong, String paramString, azla paramazla)
  {
    a(Long.valueOf("1").longValue(), paramLong, paramString, paramazla);
  }
  
  public void a(long paramLong, ArrayList<azkr> paramArrayList)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("onGetAddedRobot ").append(paramLong).append(" ");
      if (paramArrayList != null) {
        break label93;
      }
      ??? = "null";
    }
    for (;;)
    {
      QLog.d("TroopRobotManager", 2, (String)???);
      if ((paramArrayList != null) && (this.jdField_b_of_type_AndroidSupportV4UtilArrayMap != null)) {}
      synchronized (this.jdField_a_of_type_AndroidSupportV4UtilArrayMap)
      {
        this.jdField_a_of_type_AndroidSupportV4UtilArrayMap.put(Long.valueOf(paramLong), paramArrayList);
        return;
        label93:
        ??? = paramArrayList.toString();
      }
    }
  }
  
  public void a(long paramLong, ArrayList<azkr> arg3, int paramInt)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("onGetAllRobot ").append(paramLong).append(" ");
      if (??? != null) {
        break label137;
      }
      ??? = "null";
    }
    for (;;)
    {
      QLog.d("TroopRobotManager", 2, (String)??? + " " + paramInt);
      if ((??? != null) && (this.jdField_b_of_type_AndroidSupportV4UtilArrayMap != null)) {}
      synchronized (this.jdField_b_of_type_AndroidSupportV4UtilArrayMap)
      {
        this.jdField_b_of_type_AndroidSupportV4UtilArrayMap.put(Long.valueOf(paramLong), ???);
        if (this.jdField_c_of_type_AndroidSupportV4UtilArrayMap == null) {}
      }
      synchronized (this.jdField_c_of_type_AndroidSupportV4UtilArrayMap)
      {
        this.jdField_c_of_type_AndroidSupportV4UtilArrayMap.put(Long.valueOf(paramLong), Integer.valueOf(paramInt));
        return;
        label137:
        ??? = ???.toString();
        continue;
        ??? = finally;
        throw ???;
      }
    }
  }
  
  public void a(Context paramContext, BaseChatPie paramBaseChatPie, QQAppInterface paramQQAppInterface, EditText paramEditText, SessionInfo paramSessionInfo, ChatMessage paramChatMessage, String paramString)
  {
    String str = babh.h(paramQQAppInterface, paramChatMessage.frienduin, paramChatMessage.senderuin);
    paramEditText = azef.a(paramQQAppInterface, paramContext, paramSessionInfo.jdField_a_of_type_JavaLangString, paramChatMessage.senderuin, str, false, paramEditText, true, true);
    paramContext = new ArrayList();
    paramEditText = azef.a(paramEditText, paramContext);
    paramSessionInfo = paramChatMessage.getExtInfoFromExtStr("robot_news_class_id");
    try
    {
      int i = Integer.parseInt(paramSessionInfo);
      paramBaseChatPie.a(paramEditText + " " + paramString, paramContext, i);
      new awrb(paramQQAppInterface).a("dc00899").b("Grp_robot").c("sub_page").d("next_msg_clk").a(new String[] { paramChatMessage.frienduin, paramSessionInfo }).a();
      return;
    }
    catch (Exception paramContext)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("TroopRobotManager", 2, "parse robotNewTipsClsId error");
    }
  }
  
  public void a(azlb paramazlb)
  {
    if (paramazlb == null)
    {
      this.jdField_a_of_type_JavaLangRefWeakReference = null;
      return;
    }
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramazlb);
  }
  
  public void a(QQAppInterface paramQQAppInterface, long paramLong, ArrayList<String> paramArrayList)
  {
    int k = 0;
    if (QLog.isColorLevel()) {
      QLog.d("TroopRobotManager", 2, "onGetRobotRedInfo cacheTime" + paramLong);
    }
    a(paramQQAppInterface);
    ArrayList localArrayList;
    int i;
    label182:
    String str;
    label271:
    int j;
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      localArrayList = azgu.b(paramQQAppInterface);
      if (localArrayList == null)
      {
        localArrayList = new ArrayList();
        if ((paramArrayList == null) || (paramArrayList.size() == 0))
        {
          this.jdField_a_of_type_JavaUtilArrayList.clear();
          azgu.a(paramQQAppInterface, this.jdField_a_of_type_JavaUtilArrayList);
          azgu.a(paramQQAppInterface, false);
          azgu.c(paramQQAppInterface, false);
          return;
        }
        QLog.d("TroopRobotManager", 2, "onGetRobotRedInfo historyList " + localArrayList.size() + " uinList: " + paramArrayList.size() + " red:" + this.jdField_a_of_type_JavaUtilArrayList.size());
        try
        {
          i = this.jdField_a_of_type_JavaUtilArrayList.size() - 1;
          if (i >= 0)
          {
            str = (String)this.jdField_a_of_type_JavaUtilArrayList.get(i);
            if (paramArrayList.contains(str)) {
              break label527;
            }
            this.jdField_a_of_type_JavaUtilArrayList.remove(i);
            QLog.d("TroopRobotManager", 2, "onGetRobotRedInfo remove red newing " + str + " index: " + i);
            break label527;
          }
          i = paramArrayList.size() - 1;
          j = k;
          if (i < 0) {
            break label402;
          }
          str = (String)paramArrayList.get(i);
          if (localArrayList.contains(str))
          {
            paramArrayList.remove(i);
            QLog.d("TroopRobotManager", 2, "onGetRobotRedInfo remove red uinList " + str + " index: " + i);
          }
          else
          {
            localArrayList.add(str);
          }
        }
        catch (Exception paramQQAppInterface)
        {
          QLog.e("TroopRobotManager", 2, "onGetRobotRedInfo REMOVE EXCEPTION" + paramQQAppInterface.toString());
        }
        label392:
        return;
      }
    }
    for (;;)
    {
      label402:
      if (j < paramArrayList.size())
      {
        str = (String)paramArrayList.get(j);
        if (!this.jdField_a_of_type_JavaUtilArrayList.contains(str))
        {
          this.jdField_a_of_type_JavaUtilArrayList.add(str);
          QLog.d("TroopRobotManager", 2, "onGetRobotRedInfo add red uinList " + str + " index: " + j);
        }
      }
      else
      {
        azgu.a(paramQQAppInterface, this.jdField_a_of_type_JavaUtilArrayList);
        azgu.b(paramQQAppInterface, localArrayList);
        if (paramArrayList.size() <= 0) {
          break label392;
        }
        azgu.a(paramQQAppInterface, true);
        azgu.c(paramQQAppInterface, true);
        break label392;
        break;
        i -= 1;
        break label182;
        i -= 1;
        break label271;
      }
      label527:
      j += 1;
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, String paramString)
  {
    a(paramQQAppInterface);
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.contains(paramString))) {
        this.jdField_a_of_type_JavaUtilArrayList.remove(paramString);
      }
      azgu.a(paramQQAppInterface, this.jdField_a_of_type_JavaUtilArrayList);
      QLog.d("TroopRobotManager", 2, "removeRobotRedUinInRed " + paramString);
      return;
    }
  }
  
  public void a(oidb_0x496.Robot paramRobot)
  {
    try
    {
      int i;
      if (paramRobot.uin_range.has())
      {
        this.jdField_a_of_type_JavaUtilList.clear();
        i = 0;
        while ((i < paramRobot.uin_range.size()) && (i < 5))
        {
          oidb_0x496.UinRange localUinRange = (oidb_0x496.UinRange)paramRobot.uin_range.get(i);
          azlc localazlc = new azlc();
          localazlc.a = localUinRange.start_uin.get();
          localazlc.b = localUinRange.end_uin.get();
          this.jdField_a_of_type_JavaUtilList.add(localazlc);
          i += 1;
        }
      }
      if (paramRobot.fire_keywords.has())
      {
        this.jdField_b_of_type_JavaUtilList.clear();
        i = 0;
        while ((i < paramRobot.fire_keywords.size()) && (i < 5))
        {
          this.jdField_b_of_type_JavaUtilList.add(paramRobot.fire_keywords.get(i));
          i += 1;
        }
      }
      if (paramRobot.start_keywords.has())
      {
        this.jdField_c_of_type_JavaUtilList.clear();
        i = 0;
        while ((i < paramRobot.start_keywords.size()) && (i < 5))
        {
          this.jdField_c_of_type_JavaUtilList.add(paramRobot.start_keywords.get(i));
          i += 1;
        }
      }
      if (paramRobot.end_keywords.has())
      {
        this.jdField_d_of_type_JavaUtilList.clear();
        i = 0;
        while ((i < paramRobot.end_keywords.size()) && (i < 5))
        {
          this.jdField_d_of_type_JavaUtilList.add(paramRobot.end_keywords.get(i));
          i += 1;
        }
      }
      if (paramRobot.session_timeout.has()) {
        this.jdField_a_of_type_Int = paramRobot.session_timeout.get();
      }
      if (paramRobot.subscribe_categories.has())
      {
        this.e.clear();
        this.e.addAll(paramRobot.subscribe_categories.get());
      }
      if (QLog.isColorLevel()) {
        QLog.i("TroopRobotManager", 2, "setRobotConfig " + this.jdField_a_of_type_JavaUtilList.toString());
      }
      return;
    }
    finally {}
  }
  
  public void a(String paramString1, String paramString2)
  {
    b("1", paramString1, paramString2);
  }
  
  public void a(String paramString1, String paramString2, String paramString3)
  {
    if ((this.jdField_c_of_type_JavaLangString == null) || (!TextUtils.isEmpty(paramString1))) {}
    try
    {
      b(Long.parseLong(paramString1), Long.parseLong(paramString2), paramString3, new azkw(this, paramString3));
      a();
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
      return;
    }
    catch (Exception paramString3)
    {
      for (;;)
      {
        QLog.e("TroopRobotManager", 2, "release exception, troopuin:" + paramString1 + " robotuin:" + paramString2);
      }
    }
  }
  
  public void a(String paramString1, String paramString2, cmd0x934.RspBody paramRspBody)
  {
    ThreadManager.post(new TroopRobotManager.7(this, paramString1, paramString2, paramRspBody), 5, null, true);
  }
  
  public void a(JSONObject paramJSONObject)
  {
    JSONArray localJSONArray = paramJSONObject.optJSONArray("robot_aio_bar");
    if (localJSONArray != null) {
      baig.f(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApp(), this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin(), localJSONArray.toString());
    }
    paramJSONObject = paramJSONObject.optJSONObject("robot_voice_tail");
    if (paramJSONObject != null) {
      baig.g(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApp(), this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin(), paramJSONObject.toString());
    }
    d();
  }
  
  public void a(boolean paramBoolean, String paramString)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
    this.h = paramString;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public boolean a(long paramLong)
  {
    boolean bool2 = false;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < this.jdField_a_of_type_JavaUtilList.size())
      {
        azlc localazlc = (azlc)this.jdField_a_of_type_JavaUtilList.get(i);
        if ((paramLong >= localazlc.a) && (paramLong <= localazlc.b)) {
          bool1 = true;
        }
      }
      else
      {
        return bool1;
      }
      i += 1;
    }
  }
  
  public boolean a(Context paramContext, String paramString, long paramLong)
  {
    if (a(paramLong))
    {
      azgu.a(paramContext, paramString, String.valueOf(paramLong));
      return true;
    }
    return false;
  }
  
  public boolean a(QQAppInterface paramQQAppInterface, ChatMessage paramChatMessage)
  {
    return false;
  }
  
  public boolean a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2)
  {
    boolean bool2 = false;
    if (!azgu.d(paramQQAppInterface, paramString2))
    {
      QLog.d("TroopRobotManager", 2, "isRobotUinNeedShowRed RobotRed ：" + paramString1 + " role not show red in troop:" + paramString2);
      return false;
    }
    a(paramQQAppInterface);
    paramQQAppInterface = jdField_a_of_type_JavaLangObject;
    boolean bool1 = bool2;
    try
    {
      if (this.jdField_a_of_type_JavaUtilArrayList != null)
      {
        bool1 = bool2;
        if (this.jdField_a_of_type_JavaUtilArrayList.contains(paramString1)) {
          bool1 = true;
        }
      }
      QLog.d("TroopRobotManager", 2, "isRobotUinNeedShowRed RobotRed ：" + paramString1 + " " + bool1);
      return bool1;
    }
    finally {}
  }
  
  public boolean a(MessageRecord paramMessageRecord)
  {
    boolean bool3 = true;
    int j = 0;
    boolean bool2 = false;
    boolean bool1;
    if ((!a(paramMessageRecord.frienduin)) || (paramMessageRecord.mRobotFlag == -1)) {
      bool1 = false;
    }
    Object localObject;
    label187:
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
                return bool1;
                bool1 = bool3;
              } while (paramMessageRecord.mRobotFlag == 1);
              localObject = ((HotChatManager)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getManager(60)).a(paramMessageRecord.frienduin);
              if ((localObject == null) || (!((HotChatInfo)localObject).isRobotHotChat)) {
                break label187;
              }
              if (((paramMessageRecord instanceof MessageForText)) || ((paramMessageRecord instanceof MessageForReplyText)) || ((paramMessageRecord instanceof MessageForPtt))) {
                break;
              }
              bool1 = bool3;
            } while (!(paramMessageRecord instanceof MessageForMixedMsg));
            bool1 = bool3;
          } while (paramMessageRecord.atInfoList == null);
          bool1 = bool3;
        } while (paramMessageRecord.atInfoList.size() <= 0);
        i = 0;
        for (;;)
        {
          bool1 = bool2;
          if (i < paramMessageRecord.atInfoList.size())
          {
            if (a(((MessageForText.AtTroopMemberInfo)paramMessageRecord.atInfoList.get(i)).uin)) {
              bool1 = true;
            }
          }
          else {
            return bool1;
          }
          i += 1;
        }
        if ((!(paramMessageRecord instanceof MessageForText)) && (!(paramMessageRecord instanceof MessageForReplyText)) && (!(paramMessageRecord instanceof MessageForPtt)) && (!(paramMessageRecord instanceof MessageForMixedMsg))) {
          break label1098;
        }
        if (this.jdField_c_of_type_JavaLangString == null) {
          break;
        }
        bool1 = bool3;
      } while (paramMessageRecord.atInfoList == null);
      bool1 = bool3;
    } while (paramMessageRecord.atInfoList.size() <= 0);
    int i = 0;
    for (;;)
    {
      bool1 = bool3;
      if (i >= paramMessageRecord.atInfoList.size()) {
        break;
      }
      if (a(((MessageForText.AtTroopMemberInfo)paramMessageRecord.atInfoList.get(i)).uin))
      {
        bool1 = bool3;
        if ((paramMessageRecord instanceof MessageForPtt)) {
          break;
        }
        bool1 = bool3;
        if ((paramMessageRecord instanceof MessageForMixedMsg)) {
          break;
        }
        localObject = paramMessageRecord.msg.replace("@" + this.jdField_c_of_type_JavaLangString + " ", "").replace("@" + this.jdField_c_of_type_JavaLangString, "");
        i = j;
        for (;;)
        {
          bool1 = bool3;
          if (i >= this.jdField_d_of_type_JavaUtilList.size()) {
            break;
          }
          if (((String)localObject).equals(((String)this.jdField_d_of_type_JavaUtilList.get(i)).replace("$ROBOTNICK$", this.jdField_c_of_type_JavaLangString)))
          {
            a(paramMessageRecord.frienduin, this.jdField_b_of_type_JavaLangString, (String)this.jdField_d_of_type_JavaUtilList.get(i));
            return true;
          }
          i += 1;
        }
      }
      i += 1;
    }
    String str1;
    if ((paramMessageRecord.atInfoList != null) && (paramMessageRecord.atInfoList.size() > 0))
    {
      i = 0;
      for (;;)
      {
        if (i >= paramMessageRecord.atInfoList.size()) {
          break label880;
        }
        localObject = (MessageForText.AtTroopMemberInfo)paramMessageRecord.atInfoList.get(i);
        if (a(((MessageForText.AtTroopMemberInfo)localObject).uin))
        {
          this.jdField_a_of_type_JavaLangString = (((MessageForText.AtTroopMemberInfo)localObject).uin + "");
          str1 = babh.h((QQAppInterface)this.jdField_a_of_type_ComTencentCommonAppAppInterface, paramMessageRecord.frienduin, "" + ((MessageForText.AtTroopMemberInfo)localObject).uin);
          BaseApplication.getContext().getSharedPreferences("troop_robot_nickname", 0).edit().putString("troopuin_" + paramMessageRecord.frienduin, str1).commit();
          bool1 = bool3;
          if ((paramMessageRecord instanceof MessageForPtt)) {
            break;
          }
          bool1 = bool3;
          if ((paramMessageRecord instanceof MessageForMixedMsg)) {
            break;
          }
          String str2 = paramMessageRecord.msg.replace("@" + str1 + " ", "").replace("@" + str1, "");
          j = 0;
          for (;;)
          {
            bool1 = bool3;
            if (j >= this.jdField_c_of_type_JavaUtilList.size()) {
              break;
            }
            if (str2.equals(((String)this.jdField_c_of_type_JavaUtilList.get(j)).replace("$ROBOTNICK$", str1)))
            {
              a(paramMessageRecord, "" + ((MessageForText.AtTroopMemberInfo)localObject).uin, str1, (String)this.jdField_c_of_type_JavaUtilList.get(j));
              awqx.b((QQAppInterface)this.jdField_a_of_type_ComTencentCommonAppAppInterface, "dc00899", "Grp_robot", "", "msg", "conti_dialog_msg", 0, 0, paramMessageRecord.frienduin, this.jdField_a_of_type_JavaLangString, (String)this.jdField_c_of_type_JavaUtilList.get(i), "");
              return true;
            }
            j += 1;
          }
        }
        i += 1;
      }
    }
    label880:
    if (((paramMessageRecord instanceof MessageForPtt)) || ((paramMessageRecord instanceof MessageForMixedMsg))) {
      return false;
    }
    i = 0;
    while (i < this.jdField_b_of_type_JavaUtilList.size())
    {
      localObject = BaseApplication.getContext().getSharedPreferences("troop_robot_nickname", 0).getString("troopuin_" + paramMessageRecord.frienduin, this.jdField_c_of_type_JavaLangString);
      if (localObject == null) {}
      for (localObject = "";; localObject = ((String)localObject).toUpperCase().replaceAll(" ", ""))
      {
        localObject = ((String)this.jdField_b_of_type_JavaUtilList.get(i)).replace("$ROBOTNICK$", (CharSequence)localObject);
        str1 = paramMessageRecord.msg.toUpperCase().replaceAll(" ", "");
        if ((TextUtils.isEmpty((CharSequence)localObject)) || (!str1.contains((CharSequence)localObject))) {
          break;
        }
        awqx.b((QQAppInterface)this.jdField_a_of_type_ComTencentCommonAppAppInterface, "dc00899", "Grp_robot", "", "msg", "keyword_msg", 0, 0, paramMessageRecord.frienduin, this.jdField_a_of_type_JavaLangString, (String)this.jdField_b_of_type_JavaUtilList.get(i), "");
        return true;
      }
      i += 1;
    }
    label1098:
    return false;
  }
  
  public boolean a(String paramString)
  {
    HotChatInfo localHotChatInfo = ((HotChatManager)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getManager(60)).a(paramString);
    if (localHotChatInfo != null) {
      return localHotChatInfo.isRobotHotChat;
    }
    paramString = ((TroopManager)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getManager(52)).b(paramString);
    return (paramString != null) && ((paramString.dwAppPrivilegeFlag & 0x10000000) != 0L);
  }
  
  public boolean a(String paramString1, String paramString2, String paramString3)
  {
    boolean bool2 = false;
    paramString2 = babh.h((QQAppInterface)this.jdField_a_of_type_ComTencentCommonAppAppInterface, paramString3, "" + paramString2);
    paramString1 = paramString1.replace("@" + paramString2 + " ", "").replace("@" + paramString2, "");
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < this.jdField_c_of_type_JavaUtilList.size())
      {
        if (paramString1.equals(((String)this.jdField_c_of_type_JavaUtilList.get(i)).replace("$ROBOTNICK$", paramString2))) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  public byte[] a()
  {
    return bace.a(BaseApplication.getContext().getFileStreamPath("troop_robot_config"));
  }
  
  public byte[] a(String paramString1, String paramString2)
  {
    return bace.a(BaseApplication.getContext().getFileStreamPath("troop_robot_panel_data_" + paramString1 + "_" + paramString2));
  }
  
  public ArrayList<azkr> b(long paramLong)
  {
    ArrayList localArrayList = new ArrayList(0);
    if (this.jdField_b_of_type_AndroidSupportV4UtilArrayMap != null) {
      synchronized (this.jdField_b_of_type_AndroidSupportV4UtilArrayMap)
      {
        if (this.jdField_b_of_type_AndroidSupportV4UtilArrayMap.containsKey(Long.valueOf(paramLong)))
        {
          Iterator localIterator = ((ArrayList)this.jdField_b_of_type_AndroidSupportV4UtilArrayMap.get(Long.valueOf(paramLong))).iterator();
          while (localIterator.hasNext())
          {
            azkr localazkr = (azkr)localIterator.next();
            if (!localazkr.a()) {
              localArrayList.add(localazkr);
            }
          }
        }
      }
    }
    return localArrayList1;
  }
  
  public void b(int paramInt, long paramLong1, long paramLong2, String paramString, azla paramazla)
  {
    cmd0x934.ReqBody localReqBody = new cmd0x934.ReqBody();
    localReqBody.cmd.set(paramInt, true);
    localReqBody.group_id.set(paramLong1, true);
    localReqBody.keyword.set(paramString, true);
    localReqBody.robot_uin.set(paramLong2);
    mmj.a((QQAppInterface)this.jdField_a_of_type_ComTencentCommonAppAppInterface, new azkt(this, paramazla), localReqBody.toByteArray(), "OidbSvc.0x934_1", 2356, 1, new Bundle(), 12000L);
  }
  
  public void b(long paramLong1, long paramLong2, String paramString, azla paramazla)
  {
    b(2, paramLong1, paramLong2, paramString, paramazla);
  }
  
  public void b(long paramLong, String paramString, azla paramazla)
  {
    b(2, Long.valueOf("1").longValue(), paramLong, paramString, paramazla);
  }
  
  public void b(oidb_0x496.Robot paramRobot)
  {
    ThreadManager.post(new TroopRobotManager.6(this, paramRobot), 5, null, true);
  }
  
  public void b(String paramString1, String paramString2, String paramString3)
  {
    this.jdField_b_of_type_JavaLangString = paramString2;
    this.jdField_c_of_type_JavaLangString = paramString3;
    this.jdField_d_of_type_JavaLangString = paramString1;
    a(true);
  }
  
  public boolean b()
  {
    return this.jdField_b_of_type_Boolean;
  }
  
  public boolean b(String paramString)
  {
    try
    {
      long l = Long.valueOf(paramString).longValue();
      return a(l);
    }
    catch (Exception paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.e("TroopRobotManager", 2, QLog.getStackTraceString(paramString));
      }
    }
    return false;
  }
  
  public boolean b(String paramString1, String paramString2, String paramString3)
  {
    if ((!a()) || (this.jdField_c_of_type_JavaLangString == null)) {}
    for (;;)
    {
      return false;
      paramString1 = paramString1.replace("@" + this.jdField_c_of_type_JavaLangString + " ", "").replace("@" + this.jdField_c_of_type_JavaLangString, "");
      int i = 0;
      while (i < this.jdField_d_of_type_JavaUtilList.size())
      {
        if (paramString1.equals(((String)this.jdField_d_of_type_JavaUtilList.get(i)).replace("$ROBOTNICK$", this.jdField_c_of_type_JavaLangString))) {
          return true;
        }
        i += 1;
      }
    }
  }
  
  public boolean c(MessageRecord paramMessageRecord)
  {
    if (!b(paramMessageRecord.senderuin)) {}
    String str;
    do
    {
      return false;
      str = a(paramMessageRecord);
    } while (TextUtils.isEmpty(str));
    a(paramMessageRecord, str);
    if (paramMessageRecord.shmsgseq == ((Long)this.jdField_b_of_type_JavaUtilHashMap.get(str)).longValue()) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public void onDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopRobotManager", 2, "TroopRobotManager: onDestroy");
    }
    c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     azks
 * JD-Core Version:    0.7.0.1
 */