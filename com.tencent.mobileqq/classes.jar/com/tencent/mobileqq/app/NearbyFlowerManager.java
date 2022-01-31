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
import com.tencent.mobileqq.nearby.NearbySPUtil;
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
import zhr;

public class NearbyFlowerManager
  implements Manager
{
  public static int b;
  public static int c;
  public int a;
  public Handler a;
  public QQAppInterface a;
  public String a;
  public HashMap a;
  Map a;
  public String b;
  Map b;
  public String c;
  public String d;
  
  static
  {
    jdField_c_of_type_Int = 60;
  }
  
  public NearbyFlowerManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    this.jdField_b_of_type_JavaUtilMap = new HashMap();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    a();
  }
  
  private SharedPreferences a()
  {
    return BaseApplicationImpl.sApplication.getSharedPreferences("nearby_flower_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 0);
  }
  
  public static final NearbyFlowerManager a(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {
      return null;
    }
    return (NearbyFlowerManager)paramQQAppInterface.getManager(123);
  }
  
  private GrayTipsInfo a(String paramString1, String paramString2, AbsStructMsg paramAbsStructMsg)
  {
    if (QLog.isColorLevel()) {
      QLog.i("NearbyFlowerManager", 2, "shouldShowTip start");
    }
    int j = 0;
    int i = 0;
    Object localObject6 = null;
    Object localObject1 = null;
    Object localObject4 = null;
    Object localObject3 = null;
    Object localObject5 = null;
    Object localObject2 = null;
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin().equals(paramString1)) {}
    for (boolean bool = true;; bool = false)
    {
      if (this.jdField_a_of_type_JavaUtilHashMap == null) {
        this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
      }
      long l = MessageCache.a();
      if (!bool) {
        if (((Boolean)NearbySPUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "sp_file_nearby_flower_tip", 0, "nearby_flower_tip_first_flag", Boolean.valueOf(true))).booleanValue())
        {
          if (QLog.isColorLevel()) {
            QLog.i("NearbyFlowerManager", 2, "shouldShowTip first rec");
          }
          localObject1 = this.jdField_c_of_type_JavaLangString;
          localObject4 = this.d;
          localObject3 = localObject2;
          if (Friends.isValidUin(paramString1)) {
            localObject3 = String.format("https://imgcache.qq.com/club/client/flower/release/html/gift_mall.html?ADTAG=%s&_bid=2050&sourceType=%d&_handle=1&_wv=2147347&platId=1&qqVersion=%s", new Object[] { "aio.m.xiaohuitiao", Integer.valueOf(1), "7.6.3" });
          }
          NearbySPUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "sp_file_nearby_flower_tip", 0, "nearby_flower_tip_first_flag", Boolean.valueOf(false));
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80060B6", "0X80060B6", 0, 0, "", "", "", "");
          localObject2 = localObject4;
          i = 1;
        }
      }
      for (;;)
      {
        localObject4 = null;
        if (i != 0)
        {
          localObject1 = a(bool, (String)localObject1, paramAbsStructMsg);
          paramAbsStructMsg = new GrayTipsInfo();
          paramAbsStructMsg.text = ((String)localObject1);
          localObject4 = paramAbsStructMsg;
          if (!TextUtils.isEmpty((CharSequence)localObject2))
          {
            localObject4 = paramAbsStructMsg;
            if (((String)localObject1).contains((CharSequence)localObject2))
            {
              i = ((String)localObject1).indexOf((String)localObject2);
              localObject1 = new GrayTipsSpan(i, ((String)localObject2).length() + i, (String)localObject3);
              localObject2 = new ArrayList();
              ((ArrayList)localObject2).add(localObject1);
              paramAbsStructMsg.spans = ((ArrayList)localObject2);
              localObject4 = paramAbsStructMsg;
            }
          }
        }
        paramAbsStructMsg = this.jdField_a_of_type_JavaUtilHashMap;
        if (bool) {}
        for (;;)
        {
          paramAbsStructMsg.put(paramString2, Long.valueOf(l));
          return localObject4;
          localObject2 = (Long)this.jdField_a_of_type_JavaUtilHashMap.get(paramString1);
          if ((localObject2 != null) && (l - ((Long)localObject2).longValue() <= jdField_c_of_type_Int)) {
            break label588;
          }
          if (QLog.isColorLevel()) {
            QLog.i("NearbyFlowerManager", 2, "shouldShowTip rec >60s");
          }
          localObject1 = a(paramAbsStructMsg);
          if (TextUtils.isEmpty((CharSequence)localObject1)) {
            break label582;
          }
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80060B8", "0X80060B8", 0, 0, "", "", "", "");
          localObject2 = null;
          i = 1;
          break;
          Long localLong = (Long)this.jdField_a_of_type_JavaUtilHashMap.get(paramString2);
          if (localLong != null)
          {
            localObject1 = localObject6;
            i = j;
            localObject3 = localObject5;
            localObject2 = localObject4;
            if (l - localLong.longValue() <= jdField_c_of_type_Int) {
              break;
            }
          }
          if (QLog.isColorLevel()) {
            QLog.i("NearbyFlowerManager", 2, "shouldShowTip send >60s");
          }
          localObject1 = this.jdField_a_of_type_JavaLangString;
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80060B5", "0X80060B5", 0, 0, "", "", "", "");
          i = 1;
          localObject3 = localObject5;
          localObject2 = localObject4;
          break;
          paramString2 = paramString1;
        }
        label582:
        localObject2 = null;
        continue;
        label588:
        localObject2 = null;
      }
    }
  }
  
  private String a(AbsStructMsg paramAbsStructMsg)
  {
    String str = null;
    if (QLog.isColorLevel()) {
      QLog.i("NearbyFlowerManager", 2, "getFlowerFlorid");
    }
    Object localObject = str;
    if ((paramAbsStructMsg instanceof StructMsgForGeneralShare))
    {
      paramAbsStructMsg = (StructMsgForGeneralShare)paramAbsStructMsg;
      localObject = str;
      if (paramAbsStructMsg.getItemCount() > 0)
      {
        paramAbsStructMsg = paramAbsStructMsg.getItemByIndex(0);
        if (!(paramAbsStructMsg instanceof StructMsgItemLayout12)) {
          break label146;
        }
        paramAbsStructMsg = ((StructMsgItemLayout12)paramAbsStructMsg).a.getString("cMean");
      }
    }
    for (;;)
    {
      if ((!TextUtils.isEmpty(paramAbsStructMsg)) && (this.jdField_b_of_type_JavaLangString.contains("XX朵YY")))
      {
        str = this.jdField_b_of_type_JavaLangString.replace("XX朵YY", paramAbsStructMsg);
        localObject = str;
        if (QLog.isColorLevel())
        {
          QLog.i("NearbyFlowerManager", 2, "getFlowerFlorid,cMean:" + paramAbsStructMsg + " wording:" + str);
          localObject = str;
        }
      }
      label146:
      do
      {
        return localObject;
        if (!(paramAbsStructMsg instanceof StructMsgItemLayout7)) {
          break label247;
        }
        paramAbsStructMsg = ((StructMsgItemLayout7)paramAbsStructMsg).a.iterator();
        do
        {
          if (!paramAbsStructMsg.hasNext()) {
            break;
          }
          localObject = (AbsStructMsgElement)paramAbsStructMsg.next();
        } while (!(localObject instanceof StructMsgItemTitle));
        paramAbsStructMsg = ((StructMsgItemTitle)localObject).b();
        break;
        localObject = str;
      } while (!QLog.isColorLevel());
      QLog.i("NearbyFlowerManager", 2, "getFlowerFlorid,cMean:" + paramAbsStructMsg + " wording:" + null);
      return null;
      label247:
      paramAbsStructMsg = null;
    }
  }
  
  private String a(boolean paramBoolean, String paramString, AbsStructMsg paramAbsStructMsg)
  {
    String str = paramString;
    if (paramString.contains("Ta"))
    {
      str = paramString;
      if ((paramAbsStructMsg instanceof StructMsgForGeneralShare))
      {
        paramAbsStructMsg = (StructMsgForGeneralShare)paramAbsStructMsg;
        str = paramString;
        if (paramAbsStructMsg.getItemCount() > 0)
        {
          AbsStructMsgElement localAbsStructMsgElement = paramAbsStructMsg.getItemByIndex(0);
          str = paramString;
          if ((localAbsStructMsgElement instanceof StructMsgItemLayout12))
          {
            if (!paramBoolean) {
              break label115;
            }
            paramAbsStructMsg = "rSex";
            paramAbsStructMsg = ((StructMsgItemLayout12)localAbsStructMsgElement).a.getString(paramAbsStructMsg);
            str = paramString;
            if (!TextUtils.isEmpty(paramAbsStructMsg)) {
              if (Integer.valueOf(paramAbsStructMsg).intValue() != 2) {
                break label122;
              }
            }
          }
        }
      }
    }
    label115:
    label122:
    for (paramAbsStructMsg = "她";; paramAbsStructMsg = "他")
    {
      str = paramString.replace("Ta", paramAbsStructMsg);
      return str;
      paramAbsStructMsg = "sSex";
      break;
    }
  }
  
  private void a()
  {
    this.jdField_a_of_type_JavaLangString = ((String)NearbySPUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), "sp_file_nearby_flower_tip", 0, "senderGrayTip", "鲜花代表了你什么样的心意？快去告诉Ta吧。"));
    this.jdField_b_of_type_JavaLangString = ((String)NearbySPUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), "sp_file_nearby_flower_tip", 0, "receiverGrayTip", "Ta送了你XX朵YY，快和Ta说声谢谢吧。"));
    this.jdField_c_of_type_JavaLangString = ((String)NearbySPUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), "sp_file_nearby_flower_tip", 0, "exchangeGrayTip", "鲜花可以兑换多种购物卡。立即兑换"));
    this.d = ((String)NearbySPUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), "sp_file_nearby_flower_tip", 0, "exchangeHighLight", "立即兑换"));
    jdField_b_of_type_Int = ((Integer)NearbySPUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), "sp_file_nearby_flower_tip", 0, "openFlag", Integer.valueOf(jdField_b_of_type_Int))).intValue();
    this.jdField_a_of_type_Int = ((Integer)NearbySPUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), "sp_file_nearby_flower_tip", 0, "scoreThreshold", Integer.valueOf(0))).intValue();
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString)
  {
    ThreadManager.postImmediately(new zhr(paramQQAppInterface, paramString), null, true);
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
    return paramString + "_key_time_joinhotchat";
  }
  
  public void a(String paramString)
  {
    long l = MessageCache.a();
    a().edit().putLong(a(paramString), l);
    this.jdField_b_of_type_JavaUtilMap.put(paramString, Long.valueOf(l));
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NearbyFlowerManager", 2, "handleGetNewConfig:" + paramString2);
    }
    if (TextUtils.isEmpty(paramString2)) {
      return;
    }
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject(paramString2);
        if (!localJSONObject.has("senderGrayTip")) {
          break label447;
        }
        paramString2 = localJSONObject.getString("senderGrayTip");
        if (!localJSONObject.has("receiverGrayTip")) {
          break label469;
        }
        str1 = localJSONObject.getString("receiverGrayTip");
        if (!localJSONObject.has("exchangeGrayTip")) {
          break label476;
        }
        str2 = localJSONObject.getString("exchangeGrayTip");
        if (!localJSONObject.has("exchangeHighLight")) {
          break label483;
        }
        str3 = localJSONObject.getString("exchangeHighLight");
        if (!localJSONObject.has("openFlag")) {
          break label453;
        }
        i = localJSONObject.getInt("openFlag");
        if (!localJSONObject.has("groupAnimationScore")) {
          break label460;
        }
        j = localJSONObject.getInt("groupAnimationScore");
        if ((!TextUtils.isEmpty(paramString2)) && (!paramString2.equals(this.jdField_a_of_type_JavaLangString)))
        {
          this.jdField_a_of_type_JavaLangString = paramString2;
          NearbySPUtil.a(paramString1, "sp_file_nearby_flower_tip", 0, "senderGrayTip", this.jdField_a_of_type_JavaLangString);
        }
        if ((!TextUtils.isEmpty(str1)) && (!paramString2.equals(this.jdField_b_of_type_JavaLangString)))
        {
          this.jdField_b_of_type_JavaLangString = str1;
          NearbySPUtil.a(paramString1, "sp_file_nearby_flower_tip", 0, "receiverGrayTip", this.jdField_b_of_type_JavaLangString);
        }
        if ((!TextUtils.isEmpty(str2)) && (!paramString2.equals(this.jdField_c_of_type_JavaLangString)))
        {
          this.jdField_c_of_type_JavaLangString = str2;
          NearbySPUtil.a(paramString1, "sp_file_nearby_flower_tip", 0, "exchangeGrayTip", this.jdField_c_of_type_JavaLangString);
        }
        if ((!TextUtils.isEmpty(str3)) && (!paramString2.equals(this.d)))
        {
          this.d = str3;
          NearbySPUtil.a(paramString1, "sp_file_nearby_flower_tip", 0, "exchangeHighLight", this.d);
        }
        if (i != jdField_b_of_type_Int)
        {
          jdField_b_of_type_Int = i;
          NearbySPUtil.a(paramString1, "sp_file_nearby_flower_tip", 0, "openFlag", Integer.valueOf(jdField_b_of_type_Int));
        }
        if (j != this.jdField_a_of_type_Int)
        {
          this.jdField_a_of_type_Int = j;
          NearbySPUtil.a(paramString1, "sp_file_nearby_flower_tip", 0, "scoreThreshold", Integer.valueOf(this.jdField_a_of_type_Int));
        }
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("NearbyFlowerManager", 2, "handleGetNewConfig parse success");
        return;
      }
      catch (JSONException paramString1) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("NearbyFlowerManager", 2, "handleGetNewConfig parse exception:" + paramString1);
      paramString1.printStackTrace();
      return;
      label447:
      paramString2 = "";
      continue;
      label453:
      int i = jdField_b_of_type_Int;
      continue;
      label460:
      int j = this.jdField_a_of_type_Int;
      continue;
      label469:
      String str1 = "";
      continue;
      label476:
      String str2 = "";
      continue;
      label483:
      String str3 = "";
    }
  }
  
  public void a(List paramList)
  {
    if (QLog.isColorLevel()) {
      QLog.i("NearbyFlowerManager", 2, "onGetJoinedHotchats:" + paramList.size());
    }
    Object localObject1 = a();
    SharedPreferences.Editor localEditor = ((SharedPreferences)localObject1).edit();
    try
    {
      localObject1 = ((SharedPreferences)localObject1).getAll();
      if (localObject1 == null) {
        return;
      }
    }
    catch (NullPointerException localNullPointerException)
    {
      for (;;)
      {
        Object localObject2 = null;
      }
    }
    catch (Exception localException)
    {
      String str;
      for (;;)
      {
        str = null;
      }
      HashSet localHashSet = new HashSet();
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        localHashSet.add(((HotChatInfo)paramList.next()).troopUin);
      }
      paramList = str.entrySet().iterator();
      while (paramList.hasNext())
      {
        str = (String)((Map.Entry)paramList.next()).getKey();
        if (!localHashSet.contains(str))
        {
          localEditor.remove(str);
          if (QLog.isColorLevel()) {
            QLog.i("NearbyFlowerManager", 2, "onGetJoinedHotchats.remove:" + str);
          }
        }
      }
      localEditor.commit();
    }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.NearbyFlowerManager
 * JD-Core Version:    0.7.0.1
 */