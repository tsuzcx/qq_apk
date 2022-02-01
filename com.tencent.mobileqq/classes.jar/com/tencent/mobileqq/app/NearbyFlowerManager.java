package com.tencent.mobileqq.app;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.GrayTipsInfo;
import com.tencent.mobileqq.data.GrayTipsSpan;
import com.tencent.mobileqq.data.HotChatInfo;
import com.tencent.mobileqq.data.MessageForNewGrayTips;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.nearby.api.INearbySPUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.AbsStructMsgElement;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.structmsg.view.StructMsgItemLayout12;
import com.tencent.mobileqq.structmsg.view.StructMsgItemLayout7;
import com.tencent.mobileqq.structmsg.view.StructMsgItemTitle;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import mqq.manager.Manager;
import org.json.JSONException;
import org.json.JSONObject;

public class NearbyFlowerManager
  implements Manager
{
  public static int b;
  public static int c;
  public static final String e = HardCodeUtil.a(2131707182);
  public static final String f = HardCodeUtil.a(2131707190);
  public static final String g = HardCodeUtil.a(2131707185);
  public int a;
  public Handler a;
  public QQAppInterface a;
  public String a;
  public HashMap<String, Long> a;
  Map<String, Long> a;
  public String b;
  Map<String, Long> b;
  public String c;
  public String d;
  
  static
  {
    jdField_b_of_type_Int = 0;
    jdField_c_of_type_Int = 60;
  }
  
  public NearbyFlowerManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    this.jdField_b_of_type_JavaUtilMap = new HashMap();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    a();
  }
  
  private SharedPreferences a()
  {
    BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.sApplication;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("nearby_flower_");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    return localBaseApplicationImpl.getSharedPreferences(localStringBuilder.toString(), 0);
  }
  
  public static final NearbyFlowerManager a(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {
      return null;
    }
    return (NearbyFlowerManager)paramQQAppInterface.getManager(QQManagerFactory.NEARBY_FLOWER_MANAGER);
  }
  
  private GrayTipsInfo a(String paramString1, String paramString2, AbsStructMsg paramAbsStructMsg)
  {
    if (QLog.isColorLevel()) {
      QLog.i("NearbyFlowerManager", 2, "shouldShowTip start");
    }
    boolean bool = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin().equals(paramString1);
    if (this.jdField_a_of_type_JavaUtilHashMap == null) {
      this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    }
    long l = MessageCache.a();
    int i = 0;
    Object localObject2;
    String str;
    if (!bool)
    {
      if (((Boolean)((INearbySPUtil)QRoute.api(INearbySPUtil.class)).getValue(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "sp_file_nearby_flower_tip", 0, "nearby_flower_tip_first_flag", Boolean.valueOf(true))).booleanValue())
      {
        if (QLog.isColorLevel()) {
          QLog.i("NearbyFlowerManager", 2, "shouldShowTip first rec");
        }
        localObject2 = this.jdField_c_of_type_JavaLangString;
        str = this.d;
        if (Friends.isValidUin(paramString1)) {
          localObject1 = String.format("https://imgcache.qq.com/club/client/flower/release/html/gift_mall.html?ADTAG=%s&_bid=2050&sourceType=%d&_handle=1&_wv=2147347&platId=1&qqVersion=%s", new Object[] { "aio.m.xiaohuitiao", Integer.valueOf(1), "8.7.0" });
        } else {
          localObject1 = null;
        }
        ((INearbySPUtil)QRoute.api(INearbySPUtil.class)).setValue(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "sp_file_nearby_flower_tip", 0, "nearby_flower_tip_first_flag", Boolean.valueOf(false));
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80060B6", "0X80060B6", 0, 0, "", "", "", "");
        i = 1;
      }
      else
      {
        localObject1 = (Long)this.jdField_a_of_type_JavaUtilHashMap.get(paramString1);
        if ((localObject1 != null) && (l - ((Long)localObject1).longValue() <= jdField_c_of_type_Int)) {
          localObject2 = null;
        }
        for (;;)
        {
          localObject1 = null;
          str = null;
          break;
          if (QLog.isColorLevel()) {
            QLog.i("NearbyFlowerManager", 2, "shouldShowTip rec >60s");
          }
          localObject1 = a(paramAbsStructMsg);
          localObject2 = localObject1;
          if (!TextUtils.isEmpty((CharSequence)localObject1))
          {
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80060B8", "0X80060B8", 0, 0, "", "", "", "");
            i = 1;
            localObject2 = localObject1;
          }
        }
      }
    }
    else
    {
      localObject1 = (Long)this.jdField_a_of_type_JavaUtilHashMap.get(paramString2);
      if ((localObject1 != null) && (l - ((Long)localObject1).longValue() <= jdField_c_of_type_Int))
      {
        localObject2 = null;
        localObject1 = null;
        str = null;
        i = 0;
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.i("NearbyFlowerManager", 2, "shouldShowTip send >60s");
        }
        localObject2 = this.jdField_a_of_type_JavaLangString;
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80060B5", "0X80060B5", 0, 0, "", "", "", "");
        localObject1 = null;
        str = null;
        i = 1;
      }
    }
    if (i != 0)
    {
      localObject2 = a(bool, (String)localObject2, paramAbsStructMsg);
      paramAbsStructMsg = new GrayTipsInfo();
      paramAbsStructMsg.text = ((String)localObject2);
      if ((!TextUtils.isEmpty(str)) && (((String)localObject2).contains(str)))
      {
        i = ((String)localObject2).indexOf(str);
        localObject1 = new GrayTipsSpan(i, str.length() + i, (String)localObject1);
        localObject2 = new ArrayList();
        ((ArrayList)localObject2).add(localObject1);
        paramAbsStructMsg.spans = ((ArrayList)localObject2);
      }
    }
    else
    {
      paramAbsStructMsg = null;
    }
    Object localObject1 = this.jdField_a_of_type_JavaUtilHashMap;
    if (bool) {
      paramString1 = paramString2;
    }
    ((HashMap)localObject1).put(paramString1, Long.valueOf(l));
    return paramAbsStructMsg;
  }
  
  private String a(AbsStructMsg paramAbsStructMsg)
  {
    if (QLog.isColorLevel()) {
      QLog.i("NearbyFlowerManager", 2, "getFlowerFlorid");
    }
    boolean bool = paramAbsStructMsg instanceof StructMsgForGeneralShare;
    String str = null;
    Object localObject = str;
    if (bool)
    {
      paramAbsStructMsg = (StructMsgForGeneralShare)paramAbsStructMsg;
      localObject = str;
      if (paramAbsStructMsg.getItemCount() > 0)
      {
        paramAbsStructMsg = paramAbsStructMsg.getItemByIndex(0);
        if ((paramAbsStructMsg instanceof StructMsgItemLayout12))
        {
          paramAbsStructMsg = ((StructMsgItemLayout12)paramAbsStructMsg).a.getString("cMean");
        }
        else
        {
          if ((paramAbsStructMsg instanceof StructMsgItemLayout7))
          {
            paramAbsStructMsg = ((StructMsgItemLayout7)paramAbsStructMsg).a.iterator();
            while (paramAbsStructMsg.hasNext())
            {
              localObject = (AbsStructMsgElement)paramAbsStructMsg.next();
              if ((localObject instanceof StructMsgItemTitle))
              {
                paramAbsStructMsg = ((StructMsgItemTitle)localObject).b();
                break label132;
              }
            }
          }
          paramAbsStructMsg = null;
        }
        label132:
        if ((!TextUtils.isEmpty(paramAbsStructMsg)) && (this.jdField_b_of_type_JavaLangString.contains("XX朵YY")))
        {
          str = this.jdField_b_of_type_JavaLangString.replace("XX朵YY", paramAbsStructMsg);
          localObject = str;
          if (QLog.isColorLevel())
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("getFlowerFlorid,cMean:");
            ((StringBuilder)localObject).append(paramAbsStructMsg);
            ((StringBuilder)localObject).append(" wording:");
            ((StringBuilder)localObject).append(str);
            QLog.i("NearbyFlowerManager", 2, ((StringBuilder)localObject).toString());
            return str;
          }
        }
        else
        {
          localObject = str;
          if (QLog.isColorLevel())
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("getFlowerFlorid,cMean:");
            ((StringBuilder)localObject).append(paramAbsStructMsg);
            ((StringBuilder)localObject).append(" wording:");
            ((StringBuilder)localObject).append(null);
            QLog.i("NearbyFlowerManager", 2, ((StringBuilder)localObject).toString());
            localObject = str;
          }
        }
      }
    }
    return localObject;
  }
  
  private String a(boolean paramBoolean, String paramString, AbsStructMsg paramAbsStructMsg)
  {
    if ((paramString.contains("Ta")) && ((paramAbsStructMsg instanceof StructMsgForGeneralShare)))
    {
      paramAbsStructMsg = (StructMsgForGeneralShare)paramAbsStructMsg;
      if (paramAbsStructMsg.getItemCount() > 0)
      {
        AbsStructMsgElement localAbsStructMsgElement = paramAbsStructMsg.getItemByIndex(0);
        if ((localAbsStructMsgElement instanceof StructMsgItemLayout12))
        {
          if (paramBoolean) {
            paramAbsStructMsg = "rSex";
          } else {
            paramAbsStructMsg = "sSex";
          }
          paramAbsStructMsg = ((StructMsgItemLayout12)localAbsStructMsgElement).a.getString(paramAbsStructMsg);
          if (!TextUtils.isEmpty(paramAbsStructMsg))
          {
            int i;
            if (Integer.valueOf(paramAbsStructMsg).intValue() == 2) {
              i = 2131707181;
            } else {
              i = 2131707191;
            }
            return paramString.replace("Ta", HardCodeUtil.a(i));
          }
        }
      }
    }
    return paramString;
  }
  
  private void a()
  {
    this.jdField_a_of_type_JavaLangString = ((String)((INearbySPUtil)QRoute.api(INearbySPUtil.class)).getValue(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), "sp_file_nearby_flower_tip", 0, "senderGrayTip", e));
    this.jdField_b_of_type_JavaLangString = ((String)((INearbySPUtil)QRoute.api(INearbySPUtil.class)).getValue(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), "sp_file_nearby_flower_tip", 0, "receiverGrayTip", "Ta送了你XX朵YY，快和Ta说声谢谢吧。"));
    this.jdField_c_of_type_JavaLangString = ((String)((INearbySPUtil)QRoute.api(INearbySPUtil.class)).getValue(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), "sp_file_nearby_flower_tip", 0, "exchangeGrayTip", f));
    this.d = ((String)((INearbySPUtil)QRoute.api(INearbySPUtil.class)).getValue(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), "sp_file_nearby_flower_tip", 0, "exchangeHighLight", g));
    jdField_b_of_type_Int = ((Integer)((INearbySPUtil)QRoute.api(INearbySPUtil.class)).getValue(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), "sp_file_nearby_flower_tip", 0, "openFlag", Integer.valueOf(jdField_b_of_type_Int))).intValue();
    this.jdField_a_of_type_Int = ((Integer)((INearbySPUtil)QRoute.api(INearbySPUtil.class)).getValue(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), "sp_file_nearby_flower_tip", 0, "scoreThreshold", Integer.valueOf(0))).intValue();
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString)
  {
    ThreadManager.postImmediately(new NearbyFlowerManager.1(paramQQAppInterface, paramString), null, true);
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    ReportController.b(null, "dc00899", "grp_lbs", "", paramString1, paramString2, 0, 0, paramString3, paramString4, paramString5, paramString6);
  }
  
  public MessageRecord a(String paramString1, String paramString2, int paramInt, AbsStructMsg paramAbsStructMsg)
  {
    if (QLog.isColorLevel()) {
      QLog.i("NearbyFlowerManager", 2, "insertFlowerTipMsg start");
    }
    paramString2 = a(paramString1, paramString2, paramAbsStructMsg);
    if (paramString2 != null)
    {
      paramAbsStructMsg = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
      long l = MessageCache.a();
      MessageForNewGrayTips localMessageForNewGrayTips = (MessageForNewGrayTips)MessageRecordFactory.a(-2037);
      localMessageForNewGrayTips.init(paramAbsStructMsg, paramString1, paramAbsStructMsg, paramString2.text, l, -2037, paramInt, l);
      localMessageForNewGrayTips.isread = true;
      localMessageForNewGrayTips.spans = paramString2.spans;
      localMessageForNewGrayTips.updateMsgData();
      if (QLog.isColorLevel()) {
        QLog.i("NearbyFlowerManager", 2, "insertFlowerTipMsg has grayTip");
      }
      return localMessageForNewGrayTips;
    }
    return null;
  }
  
  public String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("_key_time_joinhotchat");
    return localStringBuilder.toString();
  }
  
  public void a(String paramString)
  {
    long l = MessageCache.a();
    a().edit().putLong(a(paramString), l);
    this.jdField_b_of_type_JavaUtilMap.put(paramString, Long.valueOf(l));
  }
  
  public void a(String paramString1, String paramString2)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("handleGetNewConfig:");
      ((StringBuilder)localObject).append(paramString2);
      QLog.d("NearbyFlowerManager", 2, ((StringBuilder)localObject).toString());
    }
    if (TextUtils.isEmpty(paramString2)) {
      return;
    }
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject(paramString2);
        boolean bool = localJSONObject.has("senderGrayTip");
        String str2 = "";
        if (!bool) {
          break label556;
        }
        paramString2 = localJSONObject.getString("senderGrayTip");
        if (!localJSONObject.has("receiverGrayTip")) {
          break label562;
        }
        localObject = localJSONObject.getString("receiverGrayTip");
        if (!localJSONObject.has("exchangeGrayTip")) {
          break label569;
        }
        str1 = localJSONObject.getString("exchangeGrayTip");
        if (localJSONObject.has("exchangeHighLight")) {
          str2 = localJSONObject.getString("exchangeHighLight");
        }
        int i;
        if (localJSONObject.has("openFlag")) {
          i = localJSONObject.getInt("openFlag");
        } else {
          i = jdField_b_of_type_Int;
        }
        int j;
        if (localJSONObject.has("groupAnimationScore")) {
          j = localJSONObject.getInt("groupAnimationScore");
        } else {
          j = this.jdField_a_of_type_Int;
        }
        if ((!TextUtils.isEmpty(paramString2)) && (!paramString2.equals(this.jdField_a_of_type_JavaLangString)))
        {
          this.jdField_a_of_type_JavaLangString = paramString2;
          ((INearbySPUtil)QRoute.api(INearbySPUtil.class)).setValue(paramString1, "sp_file_nearby_flower_tip", 0, "senderGrayTip", this.jdField_a_of_type_JavaLangString);
        }
        if ((!TextUtils.isEmpty((CharSequence)localObject)) && (!paramString2.equals(this.jdField_b_of_type_JavaLangString)))
        {
          this.jdField_b_of_type_JavaLangString = ((String)localObject);
          ((INearbySPUtil)QRoute.api(INearbySPUtil.class)).setValue(paramString1, "sp_file_nearby_flower_tip", 0, "receiverGrayTip", this.jdField_b_of_type_JavaLangString);
        }
        if ((!TextUtils.isEmpty(str1)) && (!paramString2.equals(this.jdField_c_of_type_JavaLangString)))
        {
          this.jdField_c_of_type_JavaLangString = str1;
          ((INearbySPUtil)QRoute.api(INearbySPUtil.class)).setValue(paramString1, "sp_file_nearby_flower_tip", 0, "exchangeGrayTip", this.jdField_c_of_type_JavaLangString);
        }
        if ((!TextUtils.isEmpty(str2)) && (!paramString2.equals(this.d)))
        {
          this.d = str2;
          ((INearbySPUtil)QRoute.api(INearbySPUtil.class)).setValue(paramString1, "sp_file_nearby_flower_tip", 0, "exchangeHighLight", this.d);
        }
        if (i != jdField_b_of_type_Int)
        {
          jdField_b_of_type_Int = i;
          ((INearbySPUtil)QRoute.api(INearbySPUtil.class)).setValue(paramString1, "sp_file_nearby_flower_tip", 0, "openFlag", Integer.valueOf(jdField_b_of_type_Int));
        }
        if (j != this.jdField_a_of_type_Int)
        {
          this.jdField_a_of_type_Int = j;
          ((INearbySPUtil)QRoute.api(INearbySPUtil.class)).setValue(paramString1, "sp_file_nearby_flower_tip", 0, "scoreThreshold", Integer.valueOf(this.jdField_a_of_type_Int));
        }
        if (QLog.isColorLevel())
        {
          QLog.d("NearbyFlowerManager", 2, "handleGetNewConfig parse success");
          return;
        }
      }
      catch (JSONException paramString1)
      {
        if (QLog.isColorLevel())
        {
          paramString2 = new StringBuilder();
          paramString2.append("handleGetNewConfig parse exception:");
          paramString2.append(paramString1);
          QLog.d("NearbyFlowerManager", 2, paramString2.toString());
          paramString1.printStackTrace();
        }
      }
      return;
      label556:
      paramString2 = "";
      continue;
      label562:
      localObject = "";
      continue;
      label569:
      String str1 = "";
    }
  }
  
  public void a(List<HotChatInfo> paramList)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("onGetJoinedHotchats:");
      ((StringBuilder)localObject1).append(paramList.size());
      QLog.i("NearbyFlowerManager", 2, ((StringBuilder)localObject1).toString());
    }
    Object localObject2 = a();
    SharedPreferences.Editor localEditor = ((SharedPreferences)localObject2).edit();
    Object localObject1 = null;
    try
    {
      localObject2 = ((SharedPreferences)localObject2).getAll();
      localObject1 = localObject2;
    }
    catch (NullPointerException|Exception localNullPointerException)
    {
      label67:
      break label67;
    }
    if (localObject1 == null) {
      return;
    }
    localObject2 = new HashSet();
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      ((Set)localObject2).add(((HotChatInfo)paramList.next()).troopUin);
    }
    paramList = ((Map)localObject1).entrySet().iterator();
    while (paramList.hasNext())
    {
      localObject1 = (String)((Map.Entry)paramList.next()).getKey();
      if (!((Set)localObject2).contains(localObject1))
      {
        localEditor.remove((String)localObject1);
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("onGetJoinedHotchats.remove:");
          localStringBuilder.append((String)localObject1);
          QLog.i("NearbyFlowerManager", 2, localStringBuilder.toString());
        }
      }
    }
    localEditor.commit();
  }
  
  public void b(String paramString)
  {
    a().edit().remove(a(paramString));
    this.jdField_b_of_type_JavaUtilMap.put(paramString, Long.valueOf(0L));
  }
  
  public void onDestroy()
  {
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.NearbyFlowerManager
 * JD-Core Version:    0.7.0.1
 */