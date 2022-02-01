import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.database.Cursor;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.TroopNotificationCache;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.trunk.group_feeds.group_feeds.GroupFeedsMessage;
import com.trunk.group_feeds.group_feeds.GroupFeedsMessage.MemoCtrlInfo;
import com.trunk.group_feeds.group_feeds.GroupFeedsMessage.MessageContent;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.OutputStream;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class bglm
{
  public static int a;
  public static String a;
  public static HashMap<Long, byte[]> a;
  static final int[] jdField_a_of_type_ArrayOfInt;
  static final String[] jdField_a_of_type_ArrayOfJavaLangString;
  public static int b;
  public static String b;
  private static HashMap<String, Boolean> b;
  public static int c;
  public static String c;
  private static HashMap<String, Boolean> c;
  public static String d;
  private static HashMap<String, bgll> d;
  public static String e;
  private static HashMap<String, Boolean> e;
  public static String f;
  private static HashMap<String, Boolean> f;
  public static String g = "src";
  
  static
  {
    jdField_a_of_type_JavaUtilHashMap = new HashMap();
    jdField_b_of_type_JavaUtilHashMap = new HashMap();
    jdField_c_of_type_JavaUtilHashMap = new HashMap();
    jdField_d_of_type_JavaUtilHashMap = new HashMap();
    jdField_e_of_type_JavaUtilHashMap = new HashMap();
    jdField_f_of_type_JavaUtilHashMap = new HashMap();
    jdField_a_of_type_ArrayOfInt = new int[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 80, 81, 82, 83, 84, 45, 85, 44, 43, 40, 41, 86, 42, 87, 57, 88, 52, 89, 63, 64, 65, 66, 67, 53, 69, 90, 91, 74, 92, 93, 75, 76, 77, 94, 95, 15, 16, 17, 18, 19, 26, 27, 28, 29, 46, 47, 48, 49, 60, 61, 62, 68, 70, 71, 72, 73, 78, 59, 20, 21, 22, 23, 24, 25, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 50, 51, 54, 55, 56, 58, 79, 96, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 123, 124, 125, 126, 127, 128, 129, 130, 131, 132, 133, 134 };
    jdField_a_of_type_ArrayOfJavaLangString = new String[] { "微笑", "撇嘴", "色", "发呆", "得意", "流泪", "害羞", "闭嘴", "睡", "大哭", "尴尬", "发怒", "调皮", "呲牙", "惊讶", "难过", "酷", "冷汗", "抓狂", "吐", "偷笑", "可爱", "白眼", "傲慢", "饥饿", "困", "惊恐", "流汗", "憨笑", "大兵", "奋斗", "咒骂", "疑问", "嘘", "晕", "折磨", "衰", "骷髅", "敲打", "再见", "擦汗", "抠鼻", "鼓掌", "糗大了", "坏笑", "左哼哼", "右哼哼", "哈欠", "鄙视", "委屈", "快哭了", "阴险", "亲亲", "吓", "可怜", "菜刀", "西瓜", "啤酒", "篮球", "乒乓", "咖啡", "饭", "猪头", "玫瑰", "凋谢", "示爱", "爱心", "心碎", "蛋糕", "闪电", "炸弹", "刀", "足球", "瓢虫", "便便", "月亮", "太阳", "礼物", "拥抱", "强", "弱", "握手", "胜利", "抱拳", "勾引", "拳头", "差劲", "爱你", "NO", "OK", "爱情", "飞吻", "跳跳", "发抖", "怄火", "转圈", "磕头", "回头", "跳绳", "挥手", "激动", "街舞", "献吻", "左太极", "右太极", "潜水", "敬礼", "石化", "加油", "熬夜", "赢了", "输啦", "火炬", "金牌", "坑爹", "伤不起", "亲", "裁判", "跨栏" };
    jdField_a_of_type_JavaLangString = "controlType";
    jdField_b_of_type_JavaLangString = "controlInfo";
    jdField_a_of_type_Int = 1;
    jdField_c_of_type_JavaLangString = "compress";
    jdField_b_of_type_Int = 1;
    jdField_d_of_type_JavaLangString = "validTime";
    jdField_e_of_type_JavaLangString = "needFilter";
    jdField_c_of_type_Int = 1;
    jdField_f_of_type_JavaLangString = "filterID";
  }
  
  public static bgll a(QQAppInterface paramQQAppInterface, String paramString)
  {
    Object localObject;
    if (paramString == null)
    {
      QLog.e("TroopNotificationHelper", 1, "HasUnReadRepeatTroopNotification, troopUin is NULL!");
      localObject = (bgll)jdField_d_of_type_JavaUtilHashMap.get(paramString);
      if (localObject == null) {
        break label141;
      }
      paramQQAppInterface = (QQAppInterface)localObject;
      if (QLog.isColorLevel())
      {
        paramString = new StringBuilder().append("HasUnReadRepeatTroopNotification. found in mTroopNotificationRepeatAIOFlag. type = ").append(((bgll)localObject).jdField_a_of_type_Int).append(", feedsId = ");
        if (!TextUtils.isEmpty(((bgll)localObject).jdField_a_of_type_JavaLangString)) {
          break label133;
        }
        paramQQAppInterface = "";
        label78:
        QLog.d("TroopNotificationHelper", 2, paramQQAppInterface);
        paramQQAppInterface = (QQAppInterface)localObject;
      }
    }
    label133:
    label141:
    label365:
    label383:
    do
    {
      do
      {
        return paramQQAppInterface;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("TroopNotificationHelper", 2, "HasUnReadRepeatTroopNotification. troop = " + paramString);
        break;
        paramQQAppInterface = ((bgll)localObject).jdField_a_of_type_JavaLangString;
        break label78;
        localObject = ((TroopManager)paramQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).b(paramString);
        if (localObject == null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("TroopNotificationHelper", 2, "HasUnReadRepeatTroopNotification. nothing in DB. return null");
          }
          return null;
        }
        if (((TroopInfo)localObject).feeds_id != null) {
          break label383;
        }
        if (!jdField_c_of_type_JavaUtilHashMap.containsKey(paramString)) {
          break label365;
        }
        localObject = (Boolean)jdField_c_of_type_JavaUtilHashMap.get(paramString);
        if ((localObject == null) || (((Boolean)localObject).booleanValue() != true)) {
          break label365;
        }
        if (QLog.isColorLevel()) {
          QLog.d("TroopNotificationHelper", 2, "HasUnReadRepeatTroopNotification = false, but mTroopNotificationAIOFlag is set. Checking old version DB.");
        }
        localObject = paramQQAppInterface.getEntityManagerFactory().createEntityManager();
        List localList = ((EntityManager)localObject).query(TroopNotificationCache.class, true, "troopUin=? and read=?", new String[] { paramString, "0" }, null, null, null, null);
        ((EntityManager)localObject).close();
        if ((localList == null) || (localList.size() <= 0) || (localList.get(0) == null) || (((TroopNotificationCache)localList.get(0)).feedsId == null)) {
          break label365;
        }
        a(paramQQAppInterface, ((TroopNotificationCache)localList.get(0)).feedsId, paramString, 0);
        paramString = (bgll)jdField_d_of_type_JavaUtilHashMap.get(paramString);
        paramQQAppInterface = paramString;
      } while (!QLog.isColorLevel());
      QLog.d("TroopNotificationHelper", 2, "HasUnReadRepeatTroopNotification(Old Flag). type = 0");
      return paramString;
      if (QLog.isColorLevel()) {
        QLog.d("TroopNotificationHelper", 2, "HasUnReadRepeatTroopNotification. feedisId is empty. return null");
      }
      return null;
      paramString = new bgll(((TroopInfo)localObject).feeds_id, ((TroopInfo)localObject).troopRepeatType);
      paramQQAppInterface = paramString;
    } while (!QLog.isColorLevel());
    QLog.d("TroopNotificationHelper", 2, "HasUnReadRepeatTroopNotification. type = " + paramString.jdField_a_of_type_Int);
    return paramString;
  }
  
  public static bgln a(DataInputStream paramDataInputStream, boolean paramBoolean)
  {
    paramDataInputStream.read();
    paramDataInputStream.readShort();
    int k = paramDataInputStream.readShort();
    paramDataInputStream.readInt();
    int m = paramDataInputStream.readInt();
    byte[] arrayOfByte2 = new byte[32];
    Arrays.fill(arrayOfByte2, (byte)0);
    paramDataInputStream.read(arrayOfByte2);
    paramDataInputStream.readInt();
    paramDataInputStream.readInt();
    paramDataInputStream.readInt();
    int n = paramDataInputStream.readInt();
    paramDataInputStream.readInt();
    paramDataInputStream.readInt();
    paramDataInputStream.readInt();
    paramDataInputStream.readInt();
    paramDataInputStream.skip(paramDataInputStream.readShort() * 5);
    paramDataInputStream.skip(16L);
    byte[] arrayOfByte1 = new byte[paramDataInputStream.readInt()];
    paramDataInputStream.read(arrayOfByte1);
    paramDataInputStream = new String(arrayOfByte2);
    int j = paramDataInputStream.indexOf(0);
    int i = j;
    if (j == -1) {
      i = paramDataInputStream.length();
    }
    paramDataInputStream = a(paramDataInputStream.substring(0, i), arrayOfByte1, paramBoolean);
    if (paramDataInputStream != null) {
      if (m >= 0) {
        break label197;
      }
    }
    label197:
    for (paramDataInputStream.jdField_a_of_type_Long = (m & 0xFFFFFFFF);; paramDataInputStream.jdField_a_of_type_Long = m)
    {
      paramDataInputStream.jdField_c_of_type_Int = n;
      paramDataInputStream.jdField_b_of_type_Int = k;
      return paramDataInputStream;
    }
  }
  
  public static bgln a(String paramString, byte[] paramArrayOfByte, boolean paramBoolean)
  {
    boolean bool1 = true;
    boolean bool2 = false;
    label851:
    label860:
    Object localObject4;
    for (;;)
    {
      Object localObject5;
      long l2;
      try
      {
        group_feeds.GroupFeedsMessage localGroupFeedsMessage = new group_feeds.GroupFeedsMessage();
        localGroupFeedsMessage.mergeFrom(paramArrayOfByte);
        i = localGroupFeedsMessage.enum_feeds_type.get();
        Object localObject3;
        if ((i == 5) || (i == 19))
        {
          Object localObject2 = localGroupFeedsMessage.rpt_feeds_content.get();
          paramArrayOfByte = "群公告";
          if (paramBoolean) {
            paramArrayOfByte = "";
          }
          localObject1 = "";
          localObject5 = new StringBuilder();
          Iterator localIterator = ((List)localObject2).iterator();
          if (localIterator.hasNext())
          {
            localObject2 = (group_feeds.GroupFeedsMessage.MessageContent)localIterator.next();
            i = ((group_feeds.GroupFeedsMessage.MessageContent)localObject2).enum_content_type.get();
            if (i == 3)
            {
              localObject2 = String.format("https://gdynamic.qpic.cn/gdynamic/%s/72", new Object[] { ((group_feeds.GroupFeedsMessage.MessageContent)localObject2).bytes_pic_id.get().toStringUtf8() });
              localObject1 = paramArrayOfByte;
              paramArrayOfByte = (byte[])localObject2;
              break label883;
            }
            if (i == 0)
            {
              ((StringBuilder)localObject5).append(((group_feeds.GroupFeedsMessage.MessageContent)localObject2).bytes_content_value.get().toStringUtf8());
              localObject2 = paramArrayOfByte;
              paramArrayOfByte = (byte[])localObject1;
              localObject1 = localObject2;
              break label883;
            }
            if (i == 10)
            {
              localObject2 = ((group_feeds.GroupFeedsMessage.MessageContent)localObject2).bytes_content_value.get().toStringUtf8();
              paramArrayOfByte = (byte[])localObject1;
              localObject1 = localObject2;
              break label883;
            }
            if (i != 2) {
              break label873;
            }
            i = ((group_feeds.GroupFeedsMessage.MessageContent)localObject2).int32_face_idx.get();
            if (i >= 0) {}
            try
            {
              if (i < jdField_a_of_type_ArrayOfInt.length)
              {
                localObject2 = jdField_a_of_type_ArrayOfJavaLangString[i];
                ((StringBuilder)localObject5).append('[');
                ((StringBuilder)localObject5).append((String)localObject2);
                ((StringBuilder)localObject5).append(']');
              }
              localObject2 = paramArrayOfByte;
              paramArrayOfByte = (byte[])localObject1;
              localObject1 = localObject2;
            }
            catch (Exception localException)
            {
              localObject3 = paramArrayOfByte;
              paramArrayOfByte = (byte[])localObject1;
              localObject1 = localObject3;
            }
          }
          localObject3 = ((StringBuilder)localObject5).toString();
          localObject5 = new bgln();
          ((bgln)localObject5).jdField_a_of_type_JavaLangString = paramArrayOfByte;
          ((bgln)localObject5).jdField_b_of_type_JavaLangString = paramString;
          ((bgln)localObject5).jdField_c_of_type_JavaLangString = ((String)localObject3);
          ((bgln)localObject5).jdField_d_of_type_JavaLangString = ((String)localObject1);
          ((bgln)localObject5).jdField_a_of_type_Int = 1;
          if (!localGroupFeedsMessage.opt_uint32_ctl_flag.has()) {
            break label899;
          }
          i = localGroupFeedsMessage.opt_uint32_ctl_flag.get();
          ((bgln)localObject5).jdField_e_of_type_Int = i;
          if ((!localGroupFeedsMessage.memo_ctrl_info.has()) || (!((group_feeds.GroupFeedsMessage.MemoCtrlInfo)localGroupFeedsMessage.memo_ctrl_info.get()).uint32_need_confirmation.has())) {
            break label896;
          }
          if (((group_feeds.GroupFeedsMessage.MemoCtrlInfo)localGroupFeedsMessage.memo_ctrl_info.get()).uint32_need_confirmation.get() != 1) {
            break label904;
          }
          paramBoolean = bool1;
          ((bgln)localObject5).jdField_a_of_type_Boolean = paramBoolean;
          break label896;
        }
        if (i == 22)
        {
          localObject5 = localGroupFeedsMessage.rpt_feeds_content.get().iterator();
          localObject1 = null;
          paramArrayOfByte = null;
          if (((Iterator)localObject5).hasNext())
          {
            localObject3 = (group_feeds.GroupFeedsMessage.MessageContent)((Iterator)localObject5).next();
            i = ((group_feeds.GroupFeedsMessage.MessageContent)localObject3).enum_content_type.get();
            if (i == 0)
            {
              localObject3 = ((group_feeds.GroupFeedsMessage.MessageContent)localObject3).bytes_content_value.get().toByteArray();
              paramArrayOfByte = (byte[])localObject1;
              localObject1 = localObject3;
              break label909;
            }
            if (i != 14) {
              break label860;
            }
            localObject1 = ((group_feeds.GroupFeedsMessage.MessageContent)localObject3).bytes_content_value.get().toStringUtf8();
            localObject3 = paramArrayOfByte;
            paramArrayOfByte = (byte[])localObject1;
            localObject1 = localObject3;
            break label909;
          }
          l2 = 0L;
          if (localObject1 == null) {
            break label851;
          }
          l1 = l2;
          try
          {
            localObject3 = new JSONObject((String)localObject1);
            l1 = l2;
            if (!((JSONObject)localObject3).has(jdField_a_of_type_JavaLangString)) {
              break label851;
            }
            l1 = l2;
            if (((JSONObject)localObject3).getInt(jdField_a_of_type_JavaLangString) != jdField_a_of_type_Int) {
              break label851;
            }
            l1 = l2;
            localObject3 = ((JSONObject)localObject3).getJSONObject(jdField_b_of_type_JavaLangString);
            l1 = l2;
            l2 = ((JSONObject)localObject3).getLong(jdField_f_of_type_JavaLangString);
            l1 = l2;
            i = ((JSONObject)localObject3).getInt(g);
            l1 = l2;
          }
          catch (JSONException localJSONException)
          {
            if (!QLog.isDevelopLevel()) {
              continue;
            }
            QLog.d("TroopNotificationHelper", 4, "decodeToFeedItem--JSONException");
            i = 0;
            continue;
            i = 0;
            continue;
          }
          localObject3 = new bgln();
          ((bgln)localObject3).jdField_b_of_type_JavaLangString = paramString;
          ((bgln)localObject3).jdField_a_of_type_ArrayOfByte = paramArrayOfByte;
          ((bgln)localObject3).jdField_e_of_type_JavaLangString = ((String)localObject1);
          ((bgln)localObject3).jdField_a_of_type_Int = 2;
          ((bgln)localObject3).jdField_b_of_type_Long = l1;
          ((bgln)localObject3).jdField_d_of_type_Int = i;
          if (localGroupFeedsMessage.opt_uint32_ctl_flag.has())
          {
            i = localGroupFeedsMessage.opt_uint32_ctl_flag.get();
            ((bgln)localObject3).jdField_e_of_type_Int = i;
            if ((!localGroupFeedsMessage.memo_ctrl_info.has()) || (!((group_feeds.GroupFeedsMessage.MemoCtrlInfo)localGroupFeedsMessage.memo_ctrl_info.get()).uint32_need_confirmation.has())) {
              break;
            }
            paramBoolean = bool2;
            if (((group_feeds.GroupFeedsMessage.MemoCtrlInfo)localGroupFeedsMessage.memo_ctrl_info.get()).uint32_need_confirmation.get() == 1) {
              paramBoolean = true;
            }
            ((bgln)localObject3).jdField_a_of_type_Boolean = paramBoolean;
            break;
          }
        }
        return null;
      }
      catch (Exception paramString)
      {
        if (QLog.isColorLevel()) {
          QLog.d(TroopNotificationCache.class.getSimpleName(), 2, paramString.getMessage());
        }
      }
      int i = 0;
      long l1 = l2;
      continue;
      localObject4 = paramArrayOfByte;
      paramArrayOfByte = (byte[])localObject1;
      Object localObject1 = localObject4;
      break label909;
      label873:
      localObject4 = localObject1;
      localObject1 = paramArrayOfByte;
      paramArrayOfByte = (byte[])localObject4;
      label883:
      localObject4 = localObject1;
      localObject1 = paramArrayOfByte;
      paramArrayOfByte = (byte[])localObject4;
      continue;
      label896:
      return localObject5;
      label899:
      i = 0;
      continue;
      label904:
      paramBoolean = false;
      continue;
      label909:
      localObject4 = localObject1;
      localObject1 = paramArrayOfByte;
      paramArrayOfByte = (byte[])localObject4;
    }
    return localObject4;
  }
  
  public static TroopNotificationCache a(bgln parambgln, String paramString, int paramInt1, int paramInt2, long paramLong)
  {
    if (parambgln != null)
    {
      if (parambgln.jdField_a_of_type_Int == 1)
      {
        String str2 = a(parambgln.jdField_c_of_type_JavaLangString);
        int i = str2.lastIndexOf('&');
        String str1 = str2;
        if (i != -1)
        {
          str1 = str2;
          if (str2.indexOf(";", i) == -1) {
            str1 = str2.substring(0, i - 1);
          }
        }
        str2 = a(parambgln.jdField_a_of_type_JavaLangString);
        if (TextUtils.isEmpty(parambgln.jdField_a_of_type_JavaLangString))
        {
          str2 = new SimpleDateFormat("yyyy年M月d日").format(new Date(parambgln.jdField_c_of_type_Int * 1000L));
          str2 = str2 + " 群公告";
        }
        paramString = String.format("https://web.qun.qq.com/mannounce/index.html?_wv=1031&amp;_bid=148#gc=%d&amp;feedType=%d&amp;gotoFid=%s", new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramInt1), paramString });
        TroopNotificationCache localTroopNotificationCache = new TroopNotificationCache();
        localTroopNotificationCache.title = parambgln.jdField_a_of_type_JavaLangString;
        localTroopNotificationCache.feedType = paramInt1;
        localTroopNotificationCache.appId = paramInt2;
        localTroopNotificationCache.userUin = parambgln.jdField_a_of_type_Long;
        localTroopNotificationCache.troopUin = paramLong;
        localTroopNotificationCache.time = parambgln.jdField_c_of_type_Int;
        localTroopNotificationCache.feedsId = parambgln.jdField_b_of_type_JavaLangString;
        localTroopNotificationCache.serviceID = 27;
        localTroopNotificationCache.needConfirm = parambgln.jdField_a_of_type_Boolean;
        String str3 = new SimpleDateFormat("M-d HH:mm").format(new Date(localTroopNotificationCache.time * 1000L));
        if (TextUtils.isEmpty(parambgln.jdField_d_of_type_JavaLangString)) {}
        for (localTroopNotificationCache.xmlBytes = String.format("<?xml version=\"1.0\" encoding=\"utf-8\" ?><msg action=\"web\" serviceID=\"27\" templateID=\"\" actionData=\"\" url=\"%s\" flag=\"5\" brief=\"%s\"><item layout=\"1\"><title size=\"30\" color=\"#000000\">[公告] %s</title><hr /><title size=\"22\" color=\"#000000\">%s</title><summary size=\"28\" color=\"#808080\">%s</summary></item></msg>", new Object[] { paramString, "", str2, str3, str1 }).getBytes();; localTroopNotificationCache.xmlBytes = String.format("<?xml version=\"1.0\" encoding=\"utf-8\" ?><msg action=\"web\" serviceID=\"27\" templateID=\"\" actionData=\"\" url=\"%s\" flag=\"5\" brief=\"%s\"><item layout=\"6\"><title size=\"30\" color=\"#000000\">[公告] %s</title><hr /></item><item layout=\"2\"><picture cover=\"%s\"/><title size=\"22\" color=\"#000000\">%s</title><summary size=\"28\" color=\"#808080\">%s</summary></item></msg>", new Object[] { paramString, "", str2, parambgln.jdField_d_of_type_JavaLangString, str3, str1 }).getBytes()) {
          return localTroopNotificationCache;
        }
      }
      if (parambgln.jdField_a_of_type_Int == 2)
      {
        paramString = new TroopNotificationCache();
        paramString.feedType = paramInt1;
        paramString.appId = paramInt2;
        paramString.userUin = parambgln.jdField_a_of_type_Long;
        paramString.troopUin = paramLong;
        paramString.time = parambgln.jdField_c_of_type_Int;
        paramString.feedsId = parambgln.jdField_b_of_type_JavaLangString;
        paramString.ctrlStr = parambgln.jdField_e_of_type_JavaLangString;
        paramString.xmlBytes = parambgln.jdField_a_of_type_ArrayOfByte;
        paramString.src = parambgln.jdField_d_of_type_Int;
        paramString.filterID = parambgln.jdField_b_of_type_Long;
        paramString.serviceID = 20;
        return paramString;
      }
    }
    return null;
  }
  
  public static TroopNotificationCache a(QQAppInterface paramQQAppInterface, long paramLong1, long paramLong2, byte[] paramArrayOfByte, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopNotificationHelper", 2, "handle get troop guide");
    }
    oidb_sso.OIDBSSOPkg localOIDBSSOPkg = new oidb_sso.OIDBSSOPkg();
    int i;
    try
    {
      paramArrayOfByte = (oidb_sso.OIDBSSOPkg)localOIDBSSOPkg.mergeFrom(paramArrayOfByte);
      if ((paramArrayOfByte == null) || (!paramArrayOfByte.uint32_result.has())) {
        return null;
      }
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      for (;;)
      {
        paramArrayOfByte.printStackTrace();
        paramArrayOfByte = localOIDBSSOPkg;
      }
      i = paramArrayOfByte.uint32_result.get();
      if (i != 0)
      {
        if (QLog.isColorLevel()) {
          QLog.d("TroopNotificationHelper", 2, "oidb0x852_48 cResult=" + i + ", troop = " + paramLong2 + ", feedType = " + paramInt1 + ", aioRequest = " + paramBoolean);
        }
        return null;
      }
    }
    for (;;)
    {
      try
      {
        paramArrayOfByte = new DataInputStream(new ByteArrayInputStream(paramArrayOfByte.bytes_bodybuffer.get().toByteArray()));
        paramArrayOfByte.readInt();
        paramArrayOfByte.readInt();
        i = paramArrayOfByte.readShort();
        paramArrayOfByte.readShort();
        if (paramInt1 != 23) {
          break label339;
        }
        bool = true;
        paramArrayOfByte = a(paramArrayOfByte, bool);
        if (paramArrayOfByte != null)
        {
          if (paramInt1 == 23)
          {
            paramQQAppInterface = a(paramArrayOfByte, paramArrayOfByte.jdField_b_of_type_JavaLangString, i, paramInt2, paramLong2);
            if ((paramQQAppInterface == null) || (!TextUtils.isEmpty(paramQQAppInterface.title))) {
              break label337;
            }
            paramQQAppInterface.title = paramArrayOfByte.jdField_c_of_type_JavaLangString;
            break label337;
          }
          if ((!a(paramQQAppInterface, Long.toString(paramLong2), paramArrayOfByte.jdField_b_of_type_JavaLangString)) && (paramBoolean)) {
            a(paramQQAppInterface, paramArrayOfByte.jdField_b_of_type_JavaLangString, Long.toString(paramLong2), 2);
          }
        }
      }
      catch (Exception paramQQAppInterface)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d(bglm.class.getSimpleName(), 2, paramQQAppInterface.getMessage());
        continue;
      }
      return null;
      label337:
      return paramQQAppInterface;
      label339:
      boolean bool = false;
    }
  }
  
  public static String a(String paramString)
  {
    if (paramString == null) {
      return "";
    }
    return a(a(a(a(a(paramString, "&", "&amp;"), "<", "&lt;"), ">", "&gt;"), "'", "&apos;"), "\"", "&quot;");
  }
  
  public static String a(String paramString1, String paramString2, String paramString3)
  {
    if (paramString1 == null) {
      localObject = null;
    }
    int i;
    String str;
    do
    {
      return localObject;
      i = paramString1.indexOf(paramString2);
      str = "";
      localObject = paramString1;
    } while (i < 0);
    Object localObject = str;
    while (i >= 0)
    {
      localObject = (String)localObject + paramString1.substring(0, i) + paramString3;
      paramString1 = paramString1.substring(i + paramString2.length());
      i = paramString1.indexOf(paramString2);
    }
    return (String)localObject + paramString1;
  }
  
  public static void a()
  {
    if (jdField_a_of_type_JavaUtilHashMap != null) {
      jdField_a_of_type_JavaUtilHashMap.clear();
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopNotificationHelper", 2, "initTroopNotificationFlag");
    }
    jdField_c_of_type_JavaUtilHashMap.clear();
    jdField_b_of_type_JavaUtilHashMap.clear();
    jdField_e_of_type_JavaUtilHashMap.clear();
    jdField_d_of_type_JavaUtilHashMap.clear();
    HashMap localHashMap1 = new HashMap();
    HashMap localHashMap2 = new HashMap();
    HashMap localHashMap3 = new HashMap();
    EntityManager localEntityManager = paramQQAppInterface.getEntityManagerFactory().createEntityManager();
    paramQQAppInterface = localEntityManager.query(true, TroopNotificationCache.class.getSimpleName(), new String[] { "troopUin", "feedType", "serviceID" }, "read=?", new String[] { String.valueOf(0) }, "troopUin", null, null, null);
    if (paramQQAppInterface != null) {}
    for (;;)
    {
      try
      {
        if (paramQQAppInterface.moveToFirst())
        {
          i = paramQQAppInterface.getColumnIndex("troopUin");
          if (i != -1)
          {
            long l = paramQQAppInterface.getLong(i);
            i = paramQQAppInterface.getColumnIndex("serviceID");
            if (i == -1) {
              continue;
            }
            i = paramQQAppInterface.getInt(i);
            if (QLog.isColorLevel()) {
              QLog.d("TroopNotificationHelper", 2, "noticeAIOMap add " + l);
            }
            localHashMap1.put(String.valueOf(l), Boolean.valueOf(true));
            if (i == 27)
            {
              if (QLog.isColorLevel()) {
                QLog.d("TroopNotificationHelper", 2, "noticeTroopAssistantMap add " + l);
              }
              localHashMap3.put(String.valueOf(l), Boolean.valueOf(true));
            }
            i = paramQQAppInterface.getColumnIndex("feedType");
            if ((i != -1) && (paramQQAppInterface.getInt(i) == 34))
            {
              if (QLog.isColorLevel()) {
                QLog.d("TroopNotificationHelper", 2, "newGuideMap add " + l);
              }
              localHashMap2.put(String.valueOf(l), Boolean.valueOf(true));
            }
          }
          boolean bool = paramQQAppInterface.moveToNext();
          if (bool) {
            continue;
          }
        }
      }
      catch (Exception localException)
      {
        int i;
        localException.printStackTrace();
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("TroopNotificationHelper", 2, "initTroopNotificationFlag Exception");
        paramQQAppInterface.close();
        continue;
      }
      finally
      {
        paramQQAppInterface.close();
      }
      localEntityManager.close();
      jdField_c_of_type_JavaUtilHashMap = localHashMap1;
      jdField_b_of_type_JavaUtilHashMap = localHashMap3;
      jdField_e_of_type_JavaUtilHashMap = localHashMap2;
      return;
      i = 27;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, int paramInt1, long paramLong1, long paramLong2, long paramLong3, String paramString1, int paramInt2, String paramString2, short paramShort, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopNotificationHelper", 2, "send0x580Cmd");
    }
    ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", paramQQAppInterface.getCurrentAccountUin(), "OidbSvc.0x580_1");
    try
    {
      Object localObject = new ByteArrayOutputStream();
      DataOutputStream localDataOutputStream = new DataOutputStream((OutputStream)localObject);
      localDataOutputStream.writeInt((int)paramLong2);
      byte[] arrayOfByte = ((ByteArrayOutputStream)localObject).toByteArray();
      localDataOutputStream.close();
      ((ByteArrayOutputStream)localObject).close();
      localObject = new oidb_sso.OIDBSSOPkg();
      ((oidb_sso.OIDBSSOPkg)localObject).uint32_command.set(1408);
      ((oidb_sso.OIDBSSOPkg)localObject).uint32_result.set(0);
      ((oidb_sso.OIDBSSOPkg)localObject).uint32_service_type.set(1);
      ((oidb_sso.OIDBSSOPkg)localObject).bytes_bodybuffer.set(ByteStringMicro.copyFrom(arrayOfByte));
      localToServiceMsg.putWupBuffer(((oidb_sso.OIDBSSOPkg)localObject).toByteArray());
      localToServiceMsg.extraData.putInt("appId", paramInt1);
      localToServiceMsg.extraData.putLong("troopUin", paramLong1);
      localToServiceMsg.extraData.putLong("troopCode", paramLong2);
      localToServiceMsg.extraData.putLong("userUin", paramLong3);
      localToServiceMsg.extraData.putString("feedsId", paramString1);
      localToServiceMsg.extraData.putInt("time", paramInt2);
      localToServiceMsg.extraData.putString("cmd", paramString2);
      localToServiceMsg.extraData.putInt("feedType", paramShort);
      localToServiceMsg.extraData.putBoolean("aioRequest", paramBoolean);
      localToServiceMsg.extraData.putBoolean("req_pb_protocol_flag", true);
      paramQQAppInterface.sendToService(localToServiceMsg);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d(bglm.class.getSimpleName(), 2, localException.getMessage());
        }
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, int paramInt1, long paramLong1, long paramLong2, long paramLong3, String paramString1, int paramInt2, String paramString2, short paramShort, boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((!paramBoolean2) && (jdField_a_of_type_JavaUtilHashMap != null) && (jdField_a_of_type_JavaUtilHashMap.containsKey(Long.valueOf(paramLong2))))
    {
      byte[] arrayOfByte = (byte[])jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(paramLong2));
      short s = (short)arrayOfByte.length;
      if ("OidbSvc.0x852_35".equals(paramString2))
      {
        jdField_f_of_type_JavaUtilHashMap.put(paramString1, Boolean.valueOf(true));
        a(paramQQAppInterface, paramInt1, paramLong1, paramLong2, s, arrayOfByte, paramLong3, paramString1, paramInt2);
      }
      while (!"OidbSvc.0x852_48".equals(paramString2)) {
        return;
      }
      a(paramQQAppInterface, paramInt1, paramLong1, paramLong2, s, arrayOfByte, paramShort, paramBoolean1);
      return;
    }
    if ("OidbSvc.0x852_35".equals(paramString2)) {
      jdField_f_of_type_JavaUtilHashMap.put(paramString1, Boolean.valueOf(true));
    }
    a(paramQQAppInterface, paramInt1, paramLong1, paramLong2, paramLong3, paramString1, paramInt2, paramString2, paramShort, paramBoolean1);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, int paramInt1, long paramLong1, long paramLong2, long paramLong3, String paramString, int paramInt2, byte[] paramArrayOfByte)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopNotificationHelper", 2, "handle get notice");
    }
    Object localObject = new oidb_sso.OIDBSSOPkg();
    try
    {
      paramArrayOfByte = (oidb_sso.OIDBSSOPkg)((oidb_sso.OIDBSSOPkg)localObject).mergeFrom((byte[])paramArrayOfByte);
      if ((paramArrayOfByte == null) || (!paramArrayOfByte.uint32_result.has()))
      {
        jdField_f_of_type_JavaUtilHashMap.remove(paramString);
        return;
      }
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      for (;;)
      {
        paramArrayOfByte.printStackTrace();
        paramArrayOfByte = (byte[])localObject;
      }
      paramInt2 = paramArrayOfByte.uint32_result.get();
      if (paramInt2 != 0)
      {
        if (QLog.isColorLevel()) {
          QLog.d("TroopNotificationHelper", 2, "0x852_35 cResult=" + paramInt2);
        }
        jdField_f_of_type_JavaUtilHashMap.remove(paramString);
        return;
      }
    }
    try
    {
      paramArrayOfByte = new DataInputStream(new ByteArrayInputStream(paramArrayOfByte.bytes_bodybuffer.get().toByteArray()));
      paramArrayOfByte.readInt();
      localObject = a(paramArrayOfByte, false);
      if (localObject != null)
      {
        paramArrayOfByte = null;
        if ((((bgln)localObject).jdField_a_of_type_Int == 1) || (((bgln)localObject).jdField_a_of_type_Int == 2)) {
          paramArrayOfByte = a((bgln)localObject, paramString, 23, paramInt1, paramLong2);
        }
        QQMessageFacade localQQMessageFacade = paramQQAppInterface.getMessageFacade();
        ArrayList localArrayList = new ArrayList();
        localArrayList.add(paramArrayOfByte);
        paramInt1 = (int)bcrg.a();
        localQQMessageFacade.getTroopMessageManager().a(paramQQAppInterface, String.valueOf(paramLong1), String.valueOf(paramLong2), localArrayList, 23, paramInt1, ((bgln)localObject).jdField_e_of_type_Int, ((bgln)localObject).jdField_b_of_type_JavaLangString);
      }
    }
    catch (Exception paramQQAppInterface)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d(bglm.class.getSimpleName(), 2, paramQQAppInterface.getMessage());
        }
      }
    }
    jdField_f_of_type_JavaUtilHashMap.remove(paramString);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, int paramInt1, long paramLong1, long paramLong2, short paramShort, byte[] paramArrayOfByte, long paramLong3, String paramString, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopNotificationHelper", 2, "send get notices");
    }
    ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", paramQQAppInterface.getCurrentAccountUin(), "OidbSvc.0x852_35");
    paramArrayOfByte = a(paramLong2, paramShort, paramArrayOfByte, paramString);
    oidb_sso.OIDBSSOPkg localOIDBSSOPkg = new oidb_sso.OIDBSSOPkg();
    localOIDBSSOPkg.uint32_command.set(2130);
    localOIDBSSOPkg.uint32_result.set(0);
    localOIDBSSOPkg.uint32_service_type.set(35);
    if (paramArrayOfByte != null) {
      localOIDBSSOPkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(paramArrayOfByte));
    }
    localToServiceMsg.putWupBuffer(localOIDBSSOPkg.toByteArray());
    localToServiceMsg.extraData.putInt("appId", paramInt1);
    localToServiceMsg.extraData.putLong("troopUin", paramLong1);
    localToServiceMsg.extraData.putLong("troopCode", paramLong2);
    localToServiceMsg.extraData.putLong("userUin", paramLong3);
    localToServiceMsg.extraData.putString("feedsId", paramString);
    localToServiceMsg.extraData.putInt("time", paramInt2);
    localToServiceMsg.extraData.putBoolean("req_pb_protocol_flag", true);
    paramQQAppInterface.sendToService(localToServiceMsg);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, int paramInt, long paramLong1, long paramLong2, short paramShort1, byte[] paramArrayOfByte, short paramShort2, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopNotificationHelper", 2, "send get troop guide");
    }
    int i = (short)47;
    i = (int)paramLong2;
    Object localObject1 = paramQQAppInterface.getCurrentAccountUin();
    long l2 = 0L;
    try
    {
      l1 = Long.valueOf(((String)localObject1).trim()).longValue();
      l1 &= 0xFFFFFFFF;
    }
    catch (Exception localException)
    {
      try
      {
        do
        {
          int j;
          int k;
          byte[] arrayOfByte;
          int m;
          int n;
          localObject1 = new ByteArrayOutputStream();
          Object localObject2 = new DataOutputStream((OutputStream)localObject1);
          ((DataOutputStream)localObject2).writeInt(m);
          ((DataOutputStream)localObject2).write(1);
          ((DataOutputStream)localObject2).writeShort(n);
          ((DataOutputStream)localObject2).writeInt(i);
          ((DataOutputStream)localObject2).writeInt((int)l1);
          ((DataOutputStream)localObject2).writeShort(paramShort2);
          ((DataOutputStream)localObject2).writeInt(-1);
          ((DataOutputStream)localObject2).writeInt(1);
          ((DataOutputStream)localObject2).writeInt(j);
          ((DataOutputStream)localObject2).writeInt(k);
          ((DataOutputStream)localObject2).writeShort(paramShort1);
          ((DataOutputStream)localObject2).write(paramArrayOfByte);
          ((DataOutputStream)localObject2).write(arrayOfByte);
          paramArrayOfByte = ((ByteArrayOutputStream)localObject1).toByteArray();
          ((DataOutputStream)localObject2).close();
          ((ByteArrayOutputStream)localObject1).close();
          localObject1 = new ToServiceMsg("mobileqq.service", paramQQAppInterface.getCurrentAccountUin(), "OidbSvc.0x852_48");
          localObject2 = new oidb_sso.OIDBSSOPkg();
          ((oidb_sso.OIDBSSOPkg)localObject2).uint32_command.set(2130);
          ((oidb_sso.OIDBSSOPkg)localObject2).uint32_result.set(0);
          ((oidb_sso.OIDBSSOPkg)localObject2).uint32_service_type.set(48);
          ((oidb_sso.OIDBSSOPkg)localObject2).bytes_bodybuffer.set(ByteStringMicro.copyFrom(paramArrayOfByte));
          ((ToServiceMsg)localObject1).putWupBuffer(((oidb_sso.OIDBSSOPkg)localObject2).toByteArray());
          ((ToServiceMsg)localObject1).extraData.putInt("appId", paramInt);
          ((ToServiceMsg)localObject1).extraData.putLong("troopUin", paramLong1);
          ((ToServiceMsg)localObject1).extraData.putLong("troopCode", paramLong2);
          ((ToServiceMsg)localObject1).extraData.putInt("feedType", paramShort2);
          ((ToServiceMsg)localObject1).extraData.putBoolean("aioRequest", paramBoolean);
          ((ToServiceMsg)localObject1).extraData.putBoolean("req_pb_protocol_flag", true);
          paramQQAppInterface.sendToService((ToServiceMsg)localObject1);
          return;
          localException = localException;
          l1 = l2;
        } while (!QLog.isColorLevel());
        QLog.d("TroopNotificationHelper", 2, localException.getMessage());
        long l1 = l2;
      }
      catch (Exception paramQQAppInterface)
      {
        while (!QLog.isColorLevel()) {}
        QLog.d(bglm.class.getSimpleName(), 2, paramQQAppInterface.getMessage());
      }
    }
    j = (int)(System.currentTimeMillis() / 1000L);
    k = (int)(System.currentTimeMillis() / 1000L);
    arrayOfByte = new byte[16];
    m = 47 + paramShort1;
    n = (short)m;
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString)
  {
    if (paramString == null) {
      QLog.e("TroopNotificationHelper", 1, "setReadNewAIOTroopNotification, troopCode is NULL!");
    }
    for (;;)
    {
      if (paramString != null)
      {
        jdField_c_of_type_JavaUtilHashMap.remove(paramString);
        BaseApplicationImpl.getContext().getSharedPreferences("new_notify_" + paramQQAppInterface.getCurrentAccountUin(), 0).edit().remove(paramString).commit();
      }
      return;
      if (QLog.isColorLevel()) {
        QLog.d("TroopNotificationHelper", 2, "setReadNewTroopNotification, troop = " + paramString);
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    if ((jdField_a_of_type_JavaUtilHashMap != null) && (jdField_a_of_type_JavaUtilHashMap.containsKey(paramString)))
    {
      byte[] arrayOfByte = (byte[])jdField_a_of_type_JavaUtilHashMap.get(paramString);
      ((aoep)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_HANDLER)).a(paramQQAppInterface, paramString, arrayOfByte, paramInt);
      return;
    }
    try
    {
      a(paramQQAppInterface, paramInt, Long.parseLong(paramString), Long.parseLong(paramString), Long.parseLong(paramQQAppInterface.getCurrentAccountUin()), "", (int)System.currentTimeMillis(), "OidbSvc.0x8ca_2", (short)0, true);
      return;
    }
    catch (NumberFormatException paramQQAppInterface) {}catch (Exception paramQQAppInterface) {}
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2)
  {
    SharedPreferences localSharedPreferences = BaseApplicationImpl.getContext().getSharedPreferences("troop_new_guid", 0);
    if (!localSharedPreferences.getBoolean(paramString1, false)) {}
    try
    {
      localSharedPreferences.edit().putBoolean(paramString1, true).commit();
      long l = Long.parseLong(paramString1);
      a(paramQQAppInterface, 0, Long.parseLong(paramString2), l, Long.parseLong(paramQQAppInterface.getCurrentAccountUin()), "", (int)System.currentTimeMillis(), "OidbSvc.0x852_48", (short)34, true, true);
      return;
    }
    catch (NumberFormatException paramQQAppInterface)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("TroopNotificationHelper", 2, "troopCode not long type!");
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, int paramInt)
  {
    if (paramString1 == null)
    {
      QLog.e("TroopNotificationHelper", 1, "setUnReadRepeatTroopNotification, feeds_id is NULL!");
      return;
    }
    if (paramString2 == null) {
      QLog.e("TroopNotificationHelper", 1, "setUnReadRepeatTroopNotification, troopUin is NULL!");
    }
    TroopInfo localTroopInfo;
    for (;;)
    {
      paramQQAppInterface = (TroopManager)paramQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
      localTroopInfo = paramQQAppInterface.b(paramString2);
      if (localTroopInfo != null) {
        break;
      }
      QLog.e("TroopNotificationHelper", 2, "setUnReadRepeatTroopNotification, troopInfo not found!");
      return;
      if (QLog.isColorLevel()) {
        QLog.d("TroopNotificationHelper", 2, "setUnReadRepeatTroopNotification, type = " + paramInt + ", troop = " + paramString2 + ", feedsId = " + paramString1);
      }
    }
    localTroopInfo.feeds_id = paramString1;
    localTroopInfo.troopRepeatType = paramInt;
    paramQQAppInterface.b(localTroopInfo);
    paramQQAppInterface = new bgll(paramString1, paramInt);
    jdField_d_of_type_JavaUtilHashMap.put(paramString2, paramQQAppInterface);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, List<TroopNotificationCache> paramList, int paramInt1, int paramInt2, String paramString2)
  {
    if (paramString1 == null) {
      QLog.e("TroopNotificationHelper", 1, "saveTroopNotificationsAndShowTips, troopUin is NULL!");
    }
    label39:
    label430:
    label576:
    label577:
    for (;;)
    {
      Object localObject1 = paramQQAppInterface.getEntityManagerFactory().createEntityManager();
      paramList = paramList.iterator();
      boolean bool2 = false;
      boolean bool1 = false;
      int i = 0;
      Object localObject2;
      if (paramList.hasNext())
      {
        localObject2 = (TroopNotificationCache)paramList.next();
        if (((TroopNotificationCache)localObject2).userUin == paramQQAppInterface.getLongAccountUin())
        {
          ((TroopNotificationCache)localObject2).read = true;
          label78:
          ((TroopNotificationCache)localObject2).currentUin = paramQQAppInterface.getCurrentAccountUin();
          ((EntityManager)localObject1).persist((Entity)localObject2);
          if (((TroopNotificationCache)localObject2).serviceID == 27) {
            bool2 = true;
          }
          if (!((TroopNotificationCache)localObject2).needConfirm) {
            break label576;
          }
          bool1 = true;
        }
      }
      for (;;)
      {
        break label39;
        if (!QLog.isColorLevel()) {
          break label577;
        }
        localObject2 = new StringBuilder().append("saveTroopNotificationsAndShowTips. troop = ").append(paramString1).append(", feedsId = ");
        if (TextUtils.isEmpty(paramString2)) {}
        for (localObject1 = "";; localObject1 = paramString2)
        {
          QLog.d("TroopNotificationHelper", 2, (String)localObject1);
          break;
        }
        ((TroopNotificationCache)localObject2).read = false;
        i += 1;
        break label78;
        ((EntityManager)localObject1).close();
        if (QLog.isColorLevel()) {
          QLog.d("TroopNotificationHelper", 2, "setUnReadFlag = " + i + ", isTroopNotification = " + bool2);
        }
        if (i == 0) {}
        do
        {
          do
          {
            return;
            if (bool2)
            {
              paramList = afnz.a();
              if ((paramList != null) && (paramList.getCurrentAIOState() < 5) && (paramList.getCurTroopUin().equals(paramString1)))
              {
                if (QLog.isColorLevel()) {
                  QLog.d("TroopNotificationHelper", 2, "AIO is opened. Do not popout troop notification.");
                }
                d(paramQQAppInterface, paramString1);
                return;
              }
            }
            a(paramQQAppInterface, paramString2, paramString1, 0);
            b(paramQQAppInterface, paramString1);
            paramList = paramQQAppInterface.getHandler(Conversation.class);
          } while ((paramList == null) || (!bool2));
          paramString2 = paramQQAppInterface.getProxyManager();
          paramString1 = (RecentUser)paramString2.a().findRecentUserByUin(paramString1, 1);
        } while (paramQQAppInterface.getTroopMask(paramString1.uin) == 3);
        if (paramInt2 == 1)
        {
          if (QLog.isColorLevel()) {
            QLog.d("TroopNotificationHelper", 2, "update recent user list with TroopNotification orange mark.");
          }
          paramQQAppInterface = algs.a(paramString1.uin, paramString1.getType());
          algs.a().a(paramQQAppInterface);
          if (paramInt2 != 1) {
            break label537;
          }
          i = 29;
          paramString1.msgType = i;
          if (!(paramString1.msg instanceof allh)) {
            break label557;
          }
          localObject1 = (allh)paramString1.msg;
          if (!bool1) {
            break label544;
          }
          paramQQAppInterface = BaseApplication.getContext().getString(2131719355);
          label470:
          ((allh)localObject1).jdField_a_of_type_JavaLangString = paramQQAppInterface;
        }
        for (;;)
        {
          ((allh)paramString1.msg).jdField_c_of_type_Int = paramInt2;
          paramString1.lastmsgtime = paramInt1;
          paramString2.a().saveRecentUser(paramString1);
          paramList.sendEmptyMessage(1009);
          return;
          if ((!(paramString1.msg instanceof allh)) || (((allh)paramString1.msg).jdField_c_of_type_Int != 1)) {
            break;
          }
          return;
          i = 11;
          break label430;
          paramQQAppInterface = BaseApplication.getContext().getString(2131719354);
          break label470;
          paramString1.msg = new allh(BaseApplication.getContext(), bool1);
        }
      }
    }
  }
  
  public static void a(String paramString)
  {
    if (paramString == null) {
      QLog.e("TroopNotificationHelper", 1, "setReadNewTroopNotification, troopCode is NULL!");
    }
    for (;;)
    {
      jdField_b_of_type_JavaUtilHashMap.remove(paramString);
      return;
      if (QLog.isColorLevel()) {
        QLog.d("TroopNotificationHelper", 2, "setReadNewTroopNotification, troop:" + paramString);
      }
    }
  }
  
  public static void a(String paramString, QQAppInterface paramQQAppInterface)
  {
    int i = 0;
    if ((paramString == null) || (paramQQAppInterface == null)) {}
    do
    {
      List localList;
      do
      {
        return;
        paramQQAppInterface = paramQQAppInterface.getEntityManagerFactory().createEntityManager();
        localList = paramQQAppInterface.query(TroopNotificationCache.class, TroopNotificationCache.class.getSimpleName(), false, "troopUin=?", new String[] { paramString }, null, null, null, null);
      } while (localList == null);
      while (i < localList.size())
      {
        paramQQAppInterface.remove((TroopNotificationCache)localList.get(i));
        i += 1;
      }
    } while (!QLog.isColorLevel());
    QLog.d("TroopNotificationHelper", 2, bglm.class.getSimpleName() + "-->clearTroopNotification. troop = " + paramString);
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2)
  {
    boolean bool2;
    if (paramString2 == null)
    {
      QLog.e("TroopNotificationHelper", 1, "isTroopNotificationRead, feedsId is NULL!");
      bool2 = false;
      return bool2;
    }
    if (paramString2.isEmpty())
    {
      QLog.e("TroopNotificationHelper", 1, "isTroopNotificationRead, feedsId is empty!");
      return false;
    }
    paramQQAppInterface = paramQQAppInterface.getEntityManagerFactory().createEntityManager();
    List localList = paramQQAppInterface.query(TroopNotificationCache.class, true, "troopUin=? and read=? and feedsId=?", new String[] { paramString1, "1", paramString2 }, null, null, null, null);
    paramQQAppInterface.close();
    if ((localList != null) && (localList.size() > 0)) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      if (paramString1 == null)
      {
        QLog.e("TroopNotificationHelper", 1, "isTroopNotificationRead, troopCode is NULL!");
        return bool1;
      }
      bool2 = bool1;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("TroopNotificationHelper", 2, "isTroopNotificationRead. feedsId = " + paramString2 + ", troop = " + paramString1);
      return bool1;
    }
  }
  
  public static boolean a(String paramString)
  {
    boolean bool = false;
    if (jdField_b_of_type_JavaUtilHashMap.containsKey(paramString)) {
      bool = ((Boolean)jdField_b_of_type_JavaUtilHashMap.get(paramString)).booleanValue();
    }
    if (paramString == null) {
      QLog.e("TroopNotificationHelper", 1, "hasNewTroopNotification, troopCode is NULL!");
    }
    while (!QLog.isColorLevel()) {
      return bool;
    }
    QLog.d("TroopNotificationHelper", 2, "hasNewTroopNotification, troop = " + paramString + ", bHasNewNotification = " + bool);
    return bool;
  }
  
  public static byte[] a(long paramLong, short paramShort, byte[] paramArrayOfByte, String paramString)
  {
    int i = 0;
    int j = (short)65;
    j = (int)paramLong;
    byte[] arrayOfByte1 = new byte[32];
    Arrays.fill(arrayOfByte1, (byte)0);
    paramString = paramString.getBytes();
    while ((i < 32) && (i < paramString.length))
    {
      arrayOfByte1[i] = paramString[i];
      i += 1;
    }
    i = (int)(System.currentTimeMillis() / 1000L);
    int k = (int)(System.currentTimeMillis() / 1000L);
    byte[] arrayOfByte2 = new byte[16];
    int m = 65 + paramShort;
    int n = (short)m;
    try
    {
      paramString = new ByteArrayOutputStream();
      DataOutputStream localDataOutputStream = new DataOutputStream(paramString);
      localDataOutputStream.writeInt(m);
      localDataOutputStream.write(1);
      localDataOutputStream.writeShort(n);
      localDataOutputStream.writeInt(j);
      localDataOutputStream.write(arrayOfByte1);
      localDataOutputStream.writeInt(i);
      localDataOutputStream.writeInt(k);
      localDataOutputStream.writeShort(paramShort);
      localDataOutputStream.write(paramArrayOfByte);
      localDataOutputStream.write(arrayOfByte2);
      paramArrayOfByte = paramString.toByteArray();
      localDataOutputStream.close();
      paramString.close();
      return paramArrayOfByte;
    }
    catch (Exception paramArrayOfByte)
    {
      if (QLog.isColorLevel()) {
        QLog.d(bglm.class.getSimpleName(), 2, paramArrayOfByte.getMessage());
      }
    }
    return null;
  }
  
  public static byte[] a(QQAppInterface paramQQAppInterface, int paramInt1, long paramLong1, long paramLong2, long paramLong3, String paramString, int paramInt2, byte[] paramArrayOfByte)
  {
    if (QLog.isColorLevel()) {
      QLog.d(bglm.class.getSimpleName(), 2, "handGetTroopAuth");
    }
    paramQQAppInterface = new oidb_sso.OIDBSSOPkg();
    try
    {
      paramArrayOfByte = (oidb_sso.OIDBSSOPkg)paramQQAppInterface.mergeFrom((byte[])paramArrayOfByte);
      paramQQAppInterface = paramArrayOfByte;
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      for (;;)
      {
        paramArrayOfByte.printStackTrace();
      }
      paramInt1 = paramQQAppInterface.uint32_result.get();
      if (paramInt1 == 0) {
        break label134;
      }
      if (!QLog.isColorLevel()) {
        break label123;
      }
      QLog.d("TroopNotificationHelper", 2, "0x580 cResult=" + paramInt1);
      label123:
      jdField_f_of_type_JavaUtilHashMap.remove(paramString);
      return null;
      try
      {
        label134:
        paramQQAppInterface = new ByteArrayInputStream(paramQQAppInterface.bytes_bodybuffer.get().toByteArray());
        paramString = new DataInputStream(paramQQAppInterface);
        paramString.readInt();
        paramString.readInt();
        paramString.readInt();
        paramString.readInt();
        paramString.skip(16L);
        paramString.readInt();
        paramString.readInt();
        paramString.skip(4L);
        paramArrayOfByte = new byte[paramString.readShort()];
        paramString.read(paramArrayOfByte);
        jdField_a_of_type_JavaUtilHashMap.put(Long.valueOf(paramLong2), paramArrayOfByte);
        paramString.close();
        paramQQAppInterface.close();
        return paramArrayOfByte;
      }
      catch (Exception paramQQAppInterface)
      {
        if (!QLog.isColorLevel()) {
          break label279;
        }
        QLog.d(bglm.class.getSimpleName(), 2, paramQQAppInterface.getMessage());
      }
    }
    if ((paramQQAppInterface == null) || (!paramQQAppInterface.uint32_result.has()))
    {
      jdField_f_of_type_JavaUtilHashMap.remove(paramString);
      return null;
    }
    label279:
    return null;
  }
  
  public static void b(QQAppInterface paramQQAppInterface, String paramString)
  {
    if (paramString == null) {
      QLog.e("TroopNotificationHelper", 1, "setUnReadAIONewTroopNotification, troopCode is NULL!");
    }
    for (;;)
    {
      if (paramString != null)
      {
        jdField_c_of_type_JavaUtilHashMap.put(paramString, Boolean.valueOf(true));
        BaseApplicationImpl.getContext().getSharedPreferences("new_notify_" + paramQQAppInterface.getCurrentAccountUin(), 0).edit().putBoolean(paramString, true).commit();
        aagb.b("https://gdynamic.qpic.cn/gdynamic/");
      }
      return;
      if (QLog.isColorLevel()) {
        QLog.d("TroopNotificationHelper", 2, "setUnReadAIONewTroopNotification. troop = " + paramString);
      }
    }
  }
  
  public static void b(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, int paramInt)
  {
    if (paramString1 == null) {}
    do
    {
      do
      {
        return;
        a(paramQQAppInterface, paramString1, paramString2, paramInt);
        paramString1 = paramQQAppInterface.getHandler(Conversation.class);
      } while (paramString1 == null);
      paramQQAppInterface = paramQQAppInterface.getProxyManager();
      paramString2 = (RecentUser)paramQQAppInterface.a().findRecentUserByUin(paramString2, 1);
    } while (((paramString2.msg instanceof allh)) && (((allh)paramString2.msg).jdField_c_of_type_Int == 1));
    if (QLog.isColorLevel()) {
      QLog.d("TroopNotificationHelper", 2, "setUnReadRepeatTroopNotificationPre, update recent user list");
    }
    Object localObject = algs.a(paramString2.uin, paramString2.getType());
    algs.a().a((String)localObject);
    paramString2.msgType = 11;
    localObject = new allh(BaseApplication.getContext(), true);
    ((allh)localObject).jdField_c_of_type_Int = 0;
    paramString2.msg = localObject;
    long l = bcrg.a();
    if (l > paramString2.lastmsgtime) {}
    for (;;)
    {
      paramString2.lastmsgtime = l;
      paramQQAppInterface.a().saveRecentUser(paramString2);
      paramString1.sendEmptyMessage(1009);
      return;
      l = paramString2.lastmsgtime;
    }
  }
  
  public static boolean b(String paramString)
  {
    if (jdField_f_of_type_JavaUtilHashMap.containsKey(paramString)) {
      return ((Boolean)jdField_f_of_type_JavaUtilHashMap.get(paramString)).booleanValue();
    }
    return false;
  }
  
  public static void c(QQAppInterface paramQQAppInterface, String paramString)
  {
    if (paramString == null) {
      QLog.e("TroopNotificationHelper", 1, "setReadRepeatTroopNotification, troopUin is NULL!");
    }
    for (;;)
    {
      paramQQAppInterface = (TroopManager)paramQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
      TroopInfo localTroopInfo = paramQQAppInterface.b(paramString);
      if (localTroopInfo != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("TroopNotificationHelper", 2, "setReadRepeatTroopNotification. type: " + localTroopInfo.troopRepeatType);
        }
        localTroopInfo.feeds_id = "";
        localTroopInfo.troopRepeatType = 0;
        paramQQAppInterface.b(localTroopInfo);
      }
      if (jdField_d_of_type_JavaUtilHashMap.containsKey(paramString)) {
        jdField_d_of_type_JavaUtilHashMap.remove(paramString);
      }
      return;
      if (QLog.isColorLevel()) {
        QLog.d("TroopNotificationHelper", 2, "setReadRepeatTroopNotification. troop = " + paramString);
      }
    }
  }
  
  public static boolean c(String paramString)
  {
    boolean bool = false;
    if (jdField_e_of_type_JavaUtilHashMap.containsKey(paramString)) {
      bool = ((Boolean)jdField_e_of_type_JavaUtilHashMap.get(paramString)).booleanValue();
    }
    if (QLog.isColorLevel()) {
      QLog.d("TroopNotificationHelper", 2, "hasNewGuide = " + bool);
    }
    return bool;
  }
  
  public static void d(QQAppInterface paramQQAppInterface, String paramString)
  {
    if (paramString == null) {
      QLog.e("TroopNotificationHelper", 1, "readTroopNotification, troopUin is NULL!");
    }
    for (;;)
    {
      TroopManager localTroopManager = (TroopManager)paramQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
      List localList = localTroopManager.a(paramString);
      if ((localList != null) && (QLog.isColorLevel())) {
        QLog.d("TroopNotificationHelper", 2, "readTroopNotification--->troopNotificationCaches size:" + localList.size());
      }
      localTroopManager.c(paramString);
      a(paramString);
      a(paramQQAppInterface, paramString);
      c(paramQQAppInterface, paramString);
      return;
      if (QLog.isColorLevel()) {
        QLog.d("TroopNotificationHelper", 2, "readTroopNotification troop:" + paramString);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bglm
 * JD-Core Version:    0.7.0.1
 */