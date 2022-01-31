import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.data.MarkFaceMessage;
import com.tencent.mobileqq.data.MessageForMarketFace;
import com.tencent.mobileqq.data.VipIPSiteInfo;
import com.tencent.mobileqq.vas.VasQuickUpdateManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import mqq.manager.Manager;
import org.json.JSONObject;

public class askc
  implements Manager
{
  public static int a;
  private static long jdField_a_of_type_Long;
  public static String a;
  public static int b;
  public static String b;
  public static int c;
  public static int d;
  public static int e;
  public static int f;
  public static int g;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  
  static
  {
    jdField_b_of_type_Int = 1;
    c = 2;
    d = 3;
    e = 4;
    f = 100;
    g = 101;
    jdField_a_of_type_Long = 86400L;
    jdField_a_of_type_JavaLangString = ajyc.a(2131702209);
    jdField_b_of_type_JavaLangString = ajyc.a(2131702208);
  }
  
  public askc(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  public static void a(QQAppInterface paramQQAppInterface, MessageForMarketFace paramMessageForMarketFace)
  {
    MarkFaceMessage localMarkFaceMessage = paramMessageForMarketFace.mMarkFaceMessage;
    int i;
    if ((localMarkFaceMessage != null) && (localMarkFaceMessage.copywritingType != jdField_a_of_type_Int))
    {
      i = ((askc)paramQQAppInterface.getManager(200)).a(paramMessageForMarketFace.time, String.valueOf(localMarkFaceMessage.dwTabID), localMarkFaceMessage.copywritingContent, localMarkFaceMessage.copywritingType);
      if (i != 0) {
        break label70;
      }
      localMarkFaceMessage.shouldDisplay = true;
    }
    for (;;)
    {
      try
      {
        paramMessageForMarketFace.msgData = akwb.a(localMarkFaceMessage);
        return;
      }
      catch (Exception paramQQAppInterface)
      {
        label70:
        QLog.e("MessageForMarketFace", 1, "decodeC2CUinPairPackage: ", paramQQAppInterface);
      }
      if ((i == 1) && (localMarkFaceMessage.hasIpProduct))
      {
        localMarkFaceMessage.shouldDisplay = true;
        localMarkFaceMessage.showIpProduct = true;
        localMarkFaceMessage.from = jdField_a_of_type_JavaLangString;
        localMarkFaceMessage.copywritingContent = jdField_b_of_type_JavaLangString;
      }
      else
      {
        localMarkFaceMessage.shouldDisplay = false;
      }
    }
  }
  
  public int a(long paramLong, String paramString1, String paramString2, int paramInt)
  {
    SharedPreferences localSharedPreferences = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("commercial_sp" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), 0);
    long l2 = localSharedPreferences.getLong("disPlayInteval", -1L);
    l1 = l2;
    if (l2 == -1L) {}
    for (;;)
    {
      try
      {
        localObject = VasQuickUpdateManager.getJSONFromLocal(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "vip_personal_card.json", false, null);
        if (localObject == null) {
          continue;
        }
        if (!((JSONObject)localObject).has("ipStackConfigDic")) {
          continue;
        }
        localObject = ((JSONObject)localObject).getJSONObject("ipStackConfigDic");
        if (!((JSONObject)localObject).has("ipStackTimeInterval")) {
          continue;
        }
        l1 = ((JSONObject)localObject).getInt("ipStackTimeInterval");
        if (QLog.isColorLevel()) {
          QLog.d("CommercialDrainageManager", 2, "getJson interval = " + l1);
        }
        l2 = l1;
        if (l1 <= 0L) {
          l2 = jdField_a_of_type_Long;
        }
        if (Build.VERSION.SDK_INT <= 8) {
          continue;
        }
        localSharedPreferences.edit().putLong("disPlayInteval", l2).apply();
        l1 = l2;
      }
      catch (Exception localException)
      {
        Object localObject;
        int i;
        l1 = jdField_a_of_type_Long;
        QLog.e("CommercialDrainageManager", 1, "getShowCount error = " + localException);
        continue;
        QLog.e("CommercialDrainageManager", 1, "getShowCount json not exist");
        l1 = jdField_a_of_type_Long;
        continue;
        boolean bool = false;
        continue;
        localException.commit();
        continue;
      }
      if (localSharedPreferences.getLong(paramString1 + "_lastDisPlayTime", 9223372036854775807L) + l1 <= paramLong) {
        continue;
      }
      bool = true;
      i = localSharedPreferences.getInt(paramString1 + "_count", 0);
      localObject = localSharedPreferences.edit();
      if (!bool)
      {
        i = 0;
        ((SharedPreferences.Editor)localObject).putLong(paramString1 + "_lastDisPlayTime", paramLong);
      }
      ((SharedPreferences.Editor)localObject).putInt(paramString1 + "_count", i + 1);
      if (Build.VERSION.SDK_INT <= 8) {
        continue;
      }
      ((SharedPreferences.Editor)localObject).apply();
      if (QLog.isColorLevel()) {
        QLog.d("CommercialDrainageManager", 2, "getShowCount, haveShown = " + bool + " count = " + i + " epId = " + paramString1 + " timestamp = " + paramLong + "interval = " + l1 + " name = " + paramString2 + " type = " + paramInt);
      }
      return i;
      localObject = null;
      continue;
      l1 = -1L;
      continue;
      localSharedPreferences.edit().putLong("disPlayInteval", l2).commit();
      l1 = l2;
    }
  }
  
  public void a(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.i("CommercialDrainageManager", 2, "updateDisPlayInteval interval = " + paramLong);
    }
    long l = paramLong;
    if (paramLong <= 0L) {
      l = jdField_a_of_type_Long;
    }
    SharedPreferences localSharedPreferences = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("commercial_sp" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), 0);
    if (Build.VERSION.SDK_INT > 8)
    {
      localSharedPreferences.edit().putLong("disPlayInteval", l).apply();
      return;
    }
    localSharedPreferences.edit().putLong("disPlayInteval", l).commit();
  }
  
  public boolean a(Emoticon paramEmoticon)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramEmoticon != null) {
      if (TextUtils.isEmpty(paramEmoticon.ipsiteUrl))
      {
        bool1 = bool2;
        if (TextUtils.isEmpty(paramEmoticon.ipsiteName)) {}
      }
      else
      {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public boolean a(EmoticonPackage paramEmoticonPackage)
  {
    return (paramEmoticonPackage.endTime != paramEmoticonPackage.beginTime) && ((paramEmoticonPackage.beginTime >= System.currentTimeMillis()) || (System.currentTimeMillis() >= paramEmoticonPackage.endTime));
  }
  
  public boolean a(VipIPSiteInfo paramVipIPSiteInfo)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramVipIPSiteInfo != null)
    {
      paramVipIPSiteInfo = paramVipIPSiteInfo.strType;
      if ((!"comic".equals(paramVipIPSiteInfo)) && (!"book".equals(paramVipIPSiteInfo)) && (!"video".equals(paramVipIPSiteInfo)) && (!"goods".equals(paramVipIPSiteInfo)))
      {
        bool1 = bool2;
        if (!"game".equals(paramVipIPSiteInfo)) {}
      }
      else
      {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public boolean b(EmoticonPackage paramEmoticonPackage)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramEmoticonPackage != null) {
      if ((TextUtils.isEmpty(paramEmoticonPackage.ipUrl)) && (TextUtils.isEmpty(paramEmoticonPackage.ipName)) && (TextUtils.isEmpty(paramEmoticonPackage.ipDetail)) && (TextUtils.isEmpty(paramEmoticonPackage.ipOpName)))
      {
        bool1 = bool2;
        if (TextUtils.isEmpty(paramEmoticonPackage.ipJumpUrl)) {}
      }
      else
      {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     askc
 * JD-Core Version:    0.7.0.1
 */