import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Environment;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.RewardNoticeActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import mqq.app.MobileQQ;
import org.json.JSONArray;
import org.json.JSONObject;
import tencent.im.babyq.babyq_cookie.BabyQCookie;
import tencent.im.oidb.cmd0x77d.oidb_cmd0x77d.ReqBody;
import tencent.im.oidb.cmd0x8db.oidb_0x8db.ReqBody;
import tencent.im.oidb.cmd0x8db.oidb_0x8db.RspBody;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;
import tencent.im.s2c.msgtype0x210.submsgtype0x6f.SubMsgType0x6f.ForwardBody;
import tencent.im.s2c.msgtype0x210.submsgtype0x6f.SubMsgType0x6f.RewardInfo;

public class antk
  extends anud
  implements beup, beuq
{
  private static String c;
  private static String d;
  private int jdField_a_of_type_Int = -1;
  private long jdField_a_of_type_Long = -1L;
  private SharedPreferences jdField_a_of_type_AndroidContentSharedPreferences;
  private Bundle jdField_a_of_type_AndroidOsBundle;
  public String a;
  public ArrayList<String> a;
  public HashMap<String, String[]> a;
  private boolean jdField_a_of_type_Boolean;
  private SharedPreferences b;
  public String b;
  
  protected antk(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    c = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + "tencent" + File.separator + "MobileQQ" + File.separator + "babyQIconRes" + File.separator + "babyQIconRes.zip";
    d = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + "tencent" + File.separator + "MobileQQ" + File.separator + "babyQIconRes";
    try
    {
      this.jdField_a_of_type_AndroidContentSharedPreferences = paramQQAppInterface.getApp().getSharedPreferences("pref_babyq" + paramQQAppInterface.getCurrentAccountUin(), 0);
      this.jdField_b_of_type_AndroidContentSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences(paramQQAppInterface.getCurrentAccountUin() + "_" + "babyQ_pluspanel_config_sp_name", 0);
      this.jdField_b_of_type_JavaLangString = this.jdField_b_of_type_AndroidContentSharedPreferences.getString("babyq_pluspanel_config_zipMd5", "");
      this.jdField_a_of_type_JavaLangString = this.jdField_b_of_type_AndroidContentSharedPreferences.getString("babyq_pluspanel_config_zipUrl", "");
      paramQQAppInterface = this.jdField_b_of_type_AndroidContentSharedPreferences.getString("babyq_profile_config_Url", "");
      if (!TextUtils.isEmpty(paramQQAppInterface)) {
        bhjx.jdField_a_of_type_JavaLangString = paramQQAppInterface;
      }
      d();
    }
    catch (Exception paramQQAppInterface)
    {
      for (;;)
      {
        QLog.i("Q.BabyQ", 1, "init plusPanelItems error!" + paramQQAppInterface);
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.BabyQ", 2, "BabyQHandler | Utils.sBabyQProfileUrl :" + bhjx.jdField_a_of_type_JavaLangString);
    }
  }
  
  public static void a(Context paramContext, View paramView)
  {
    paramView.setVisibility(0);
    paramContext = AnimationUtils.loadAnimation(paramContext, 2130772234);
    paramContext.setAnimationListener(new antl(paramView));
    paramView.startAnimation(paramContext);
  }
  
  private void a(SharedPreferences paramSharedPreferences, ArrayList<String> paramArrayList, String paramString)
  {
    if (paramArrayList == null) {}
    do
    {
      return;
      paramArrayList.clear();
      paramSharedPreferences = paramSharedPreferences.getString(paramString, "");
    } while (paramSharedPreferences.length() <= 0);
    int j;
    for (int i = 0;; i = j + 1)
    {
      j = paramSharedPreferences.indexOf(",", i);
      if (j == -1) {
        break;
      }
      paramArrayList.add(paramSharedPreferences.substring(i, j));
    }
    paramArrayList.add(paramSharedPreferences.substring(i));
  }
  
  public static void a(View paramView)
  {
    if ((paramView != null) && (paramView.getVisibility() == 0))
    {
      paramView.setVisibility(8);
      paramView.clearAnimation();
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, int paramInt1, int paramInt2)
  {
    int j = 1;
    int i = 1;
    String str = "";
    if ((paramInt1 == 1) || (paramInt1 == 2)) {
      if (paramInt2 == 1)
      {
        str = "0X800724C";
        if (paramInt1 != 1) {
          break label73;
        }
      }
    }
    for (;;)
    {
      label33:
      if (!TextUtils.isEmpty(str)) {
        bdll.b(paramQQAppInterface, "dc00898", "", "", str, str, i, 0, "", "", "", "");
      }
      label73:
      label97:
      label115:
      while (!QLog.isColorLevel())
      {
        return;
        str = "0X800724D";
        break;
        i = 2;
        break label33;
        if ((paramInt1 == 3) || (paramInt1 == 4))
        {
          if (paramInt2 == 1)
          {
            str = "0X800724E";
            if (paramInt1 != 3) {
              break label115;
            }
          }
          for (i = j;; i = 2)
          {
            break;
            str = "0X800724F";
            break label97;
          }
        }
        if (paramInt1 != 5) {
          break label187;
        }
        if (paramInt2 == 1) {}
        for (str = "0X8007250";; str = "0X8007251")
        {
          i = 0;
          break;
        }
      }
      QLog.d("Q.BabyQ", 2, "reportRewardAction error type:" + paramInt1 + " action:" + paramInt2);
      return;
      label187:
      i = 0;
    }
  }
  
  private void a(String paramString1, String paramString2, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.e("Q.BabyQ", 2, "downloadIconRes | tryTimes : " + paramInt);
    }
    if (paramInt > 2) {
      return;
    }
    beuo localbeuo = this.app.getNetEngine(0);
    beum localbeum = new beum();
    localbeum.jdField_a_of_type_Beuq = this;
    localbeum.jdField_a_of_type_Beup = this;
    localbeum.jdField_a_of_type_JavaLangString = paramString1;
    localbeum.c = c;
    localbeum.jdField_a_of_type_Int = 0;
    localbeum.d = 1;
    localbeum.a(new antm(this, paramInt + 1, paramString1, paramString2));
    localbeuo.a(localbeum);
  }
  
  private boolean a(String paramString1, String paramString2)
  {
    try
    {
      bhmi.a(paramString1, paramString2, false);
      return true;
    }
    catch (Exception paramString1)
    {
      paramString1.printStackTrace();
      if (QLog.isColorLevel()) {
        QLog.e("Q.BabyQ", 2, "unZipResource : delete and uncompress Exception=>", paramString1);
      }
    }
    return false;
  }
  
  private void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool;
    oidb_0x8db.RspBody localRspBody;
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess()) && (paramObject != null))
    {
      bool = true;
      if (QLog.isColorLevel()) {
        QLog.d("Q.BabyQ", 2, "BabyQ funcall handleAddBabyQAsFriend success = " + bool);
      }
      paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
      localRspBody = new oidb_0x8db.RspBody();
      paramFromServiceMsg = new Bundle();
      if (paramObject == null) {}
    }
    for (;;)
    {
      try
      {
        paramToServiceMsg = (oidb_sso.OIDBSSOPkg)paramToServiceMsg.mergeFrom((byte[])paramObject);
        if (paramToServiceMsg != null)
        {
          int i = paramToServiceMsg.uint32_result.get();
          paramFromServiceMsg.putInt("ad_bbq_code", i);
          if (i != 0) {
            break label349;
          }
          bool = true;
          if ((paramToServiceMsg.bytes_bodybuffer.has()) && (paramToServiceMsg.bytes_bodybuffer.get() != null))
          {
            localRspBody.mergeFrom(paramToServiceMsg.bytes_bodybuffer.get().toByteArray());
            if (localRspBody != null)
            {
              paramToServiceMsg = localRspBody.bytes_welcome_msg.get().toStringUtf8();
              paramFromServiceMsg.putString("ad_bbq_message", paramToServiceMsg);
              if (QLog.isColorLevel()) {
                QLog.d("Q.BabyQ", 2, "BabyQ funcall handleAddBabyQAsFriend result = " + i + " msg = " + paramToServiceMsg);
              }
              ((FriendListHandler)this.app.a(1)).a(antf.aC, 0, 3999, "", true, false, -1L);
              notifyUI(4, bool, paramFromServiceMsg);
            }
          }
        }
        else
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.BabyQ", 2, "BabyQ funcall handleAddBabyQAsFriend false ");
          }
          notifyUI(4, false, null);
          return;
        }
      }
      catch (InvalidProtocolBufferMicroException paramToServiceMsg)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.BabyQ", 2, "BabyQ funcall handleAddBabyQAsFriend exception =" + paramToServiceMsg.getStackTrace());
        }
        notifyUI(4, false, paramFromServiceMsg);
        return;
      }
      paramToServiceMsg = "";
      continue;
      continue;
      bool = false;
      break;
      label349:
      bool = false;
    }
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList == null) {
      this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    }
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    a(this.jdField_b_of_type_AndroidContentSharedPreferences, localArrayList2, "babyq_pluspanel_config_reds");
    a(this.jdField_b_of_type_AndroidContentSharedPreferences, this.jdField_a_of_type_JavaUtilArrayList, "babyq_pluspanel_config_titles");
    a(this.jdField_b_of_type_AndroidContentSharedPreferences, localArrayList1, "babyq_pluspanel_config_codes");
    if (QLog.isColorLevel()) {
      QLog.d("Q.BabyQ", 2, "BabyQHandler | titleList :" + this.jdField_a_of_type_JavaUtilArrayList + " | codeList : " + localArrayList1 + " | redList : " + localArrayList2 + " | zipMd5 : " + this.jdField_b_of_type_JavaLangString + " | zipUrl : " + this.jdField_a_of_type_JavaLangString);
    }
    if ((this.jdField_a_of_type_JavaUtilArrayList.size() != localArrayList1.size()) || (localArrayList1.size() != localArrayList2.size()) || (this.jdField_a_of_type_JavaUtilArrayList.size() != localArrayList2.size())) {}
    for (;;)
    {
      return;
      if (this.jdField_a_of_type_JavaUtilHashMap == null) {
        this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
      }
      int i = 0;
      while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
      {
        this.jdField_a_of_type_JavaUtilHashMap.put(this.jdField_a_of_type_JavaUtilArrayList.get(i), new String[] { (String)localArrayList1.get(i), (String)localArrayList2.get(i) });
        i += 1;
      }
    }
  }
  
  public int a(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt(paramString + "_" + "babyq_pluspanel_config_version", 0);
  }
  
  public long a()
  {
    try
    {
      if (this.jdField_a_of_type_AndroidContentSharedPreferences == null) {
        this.jdField_a_of_type_AndroidContentSharedPreferences = this.app.getApp().getSharedPreferences("pref_babyq" + this.app.getCurrentAccountUin(), 0);
      }
      if (this.jdField_a_of_type_Long == -1L)
      {
        this.jdField_a_of_type_Long = this.jdField_a_of_type_AndroidContentSharedPreferences.getLong("Key_Ability", 0L);
        if (QLog.isColorLevel()) {
          QLog.d("Q.BabyQ", 2, "getAbility " + this.jdField_a_of_type_Long);
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.BabyQ", 2, "getAbility error e:" + localException.toString());
        }
      }
    }
    return this.jdField_a_of_type_Long;
  }
  
  public Drawable a(int paramInt)
  {
    String str = d + File.separator + "babyq_" + paramInt + ".png";
    if (QLog.isColorLevel()) {
      QLog.d("Q.BabyQ", 2, "getBabyQPlusPanelIcon iconPath: " + str);
    }
    if (bhmi.b(str)) {
      return new BitmapDrawable(this.app.getApplication().getResources(), str);
    }
    return null;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Int = -1;
    notifyUI(3, true, null);
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.BabyQ", 2, "handleBabyQGuide handleType:" + paramInt);
    }
    if (this.jdField_a_of_type_AndroidContentSharedPreferences == null) {
      this.jdField_a_of_type_AndroidContentSharedPreferences = this.app.getApp().getSharedPreferences("pref_babyq" + this.app.getCurrentAccountUin(), 0);
    }
    if (this.jdField_a_of_type_AndroidContentSharedPreferences.getBoolean("Key_Guide_" + paramInt, false))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.BabyQ", 2, "handleBabyQGuide return");
      }
      return;
    }
    if (this.jdField_a_of_type_Int != -1) {
      a();
    }
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putBoolean("Key_Guide_" + paramInt, true).commit();
    notifyUI(2, true, Integer.valueOf(paramInt));
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    Object localObject = new oidb_0x8db.ReqBody();
    ((oidb_0x8db.ReqBody)localObject).uint32_user_type.set(paramInt1);
    ((oidb_0x8db.ReqBody)localObject).uint32_from_type.set(paramInt2);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder("BabyQ funcall addBabyQAsFreind ");
      localStringBuilder.append(" userType = ").append(paramInt1);
      localStringBuilder.append(" fromType = ").append(paramInt2);
      localStringBuilder.append("\n");
      QLog.i("Q.BabyQ", 2, localStringBuilder.toString());
    }
    localObject = makeOIDBPkg("OidbSvc.0x8db_0", 2267, 0, ((oidb_0x8db.ReqBody)localObject).toByteArray());
    ((ToServiceMsg)localObject).extraData.putBoolean("req_pb_protocol_flag", true);
    send((ToServiceMsg)localObject);
  }
  
  public void a(int paramInt, String paramString)
  {
    Object localObject2;
    Object localObject1;
    StringBuilder localStringBuilder1;
    StringBuilder localStringBuilder2;
    int i;
    try
    {
      if (TextUtils.isEmpty(paramString)) {
        break label763;
      }
      paramString = new JSONObject(paramString);
      if (paramString == null) {
        break label743;
      }
      this.jdField_a_of_type_JavaLangString = paramString.optString("zip_url");
      this.jdField_b_of_type_JavaLangString = paramString.optString("zip_md5");
      localObject2 = paramString.getJSONArray("babyq_items");
      if ((localObject2 == null) || (((JSONArray)localObject2).length() <= 0)) {
        break label659;
      }
      localObject1 = new StringBuilder(64);
      localStringBuilder1 = new StringBuilder(32);
      localStringBuilder2 = new StringBuilder(32);
      if (this.jdField_a_of_type_JavaUtilArrayList == null) {
        this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
      }
      while (this.jdField_a_of_type_JavaUtilHashMap == null)
      {
        this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
        break label918;
        while (i < ((JSONArray)localObject2).length())
        {
          Object localObject3 = ((JSONArray)localObject2).optJSONObject(i);
          String str1 = ((JSONObject)localObject3).optString("title");
          String str2 = ((JSONObject)localObject3).optString("code");
          localObject3 = ((JSONObject)localObject3).optString("redpoint");
          this.jdField_a_of_type_JavaUtilHashMap.put(str1, new String[] { str2, localObject3 });
          this.jdField_a_of_type_JavaUtilArrayList.add(str1);
          ((StringBuilder)localObject1).append(str1).append(",");
          localStringBuilder1.append(str2).append(",");
          localStringBuilder2.append((String)localObject3).append(",");
          i += 1;
        }
        this.jdField_a_of_type_JavaUtilArrayList.clear();
      }
      this.jdField_a_of_type_JavaUtilHashMap.clear();
    }
    catch (Exception paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.e("Q.BabyQ", 2, "updateBabyQPlusPanelConfig error " + paramString.getMessage());
      }
      return;
    }
    break label918;
    if (this.jdField_b_of_type_AndroidContentSharedPreferences == null) {
      this.jdField_b_of_type_AndroidContentSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences(this.app.getCurrentAccountUin() + "_" + "babyQ_pluspanel_config_sp_name", 0);
    }
    if (!this.jdField_b_of_type_AndroidContentSharedPreferences.getString("babyq_pluspanel_config_zipMd5", "").equalsIgnoreCase(this.jdField_b_of_type_JavaLangString)) {}
    for (boolean bool = true;; bool = false)
    {
      localObject2 = this.jdField_b_of_type_AndroidContentSharedPreferences.edit();
      if (((StringBuilder)localObject1).length() > 1)
      {
        ((StringBuilder)localObject1).deleteCharAt(((StringBuilder)localObject1).length() - 1);
        ((SharedPreferences.Editor)localObject2).putString("babyq_pluspanel_config_titles", ((StringBuilder)localObject1).toString());
      }
      if (localStringBuilder1.length() > 1)
      {
        localStringBuilder1.deleteCharAt(localStringBuilder1.length() - 1);
        ((SharedPreferences.Editor)localObject2).putString("babyq_pluspanel_config_codes", localStringBuilder1.toString());
      }
      if (localStringBuilder2.length() > 1)
      {
        localStringBuilder2.deleteCharAt(localStringBuilder2.length() - 1);
        ((SharedPreferences.Editor)localObject2).putString("babyq_pluspanel_config_reds", localStringBuilder2.toString());
      }
      ((SharedPreferences.Editor)localObject2).putString("babyq_pluspanel_config_zipMd5", this.jdField_b_of_type_JavaLangString);
      ((SharedPreferences.Editor)localObject2).putString("babyq_pluspanel_config_zipUrl", this.jdField_a_of_type_JavaLangString);
      ((SharedPreferences.Editor)localObject2).commit();
      a(true, bool);
      if (QLog.isColorLevel()) {
        QLog.d("Q.BabyQ", 2, "updateBabyQPlusPanelConfig|version:" + paramInt + "|sbTitle:" + ((StringBuilder)localObject1).toString() + "|sbCode:" + localStringBuilder1.toString() + "|sbRed:" + localStringBuilder2 + "|zipUrl:" + this.jdField_a_of_type_JavaLangString + "|zipMd5:" + this.jdField_b_of_type_JavaLangString);
      }
      label659:
      paramString = paramString.optString("babyq_profile_url");
      bhjx.jdField_a_of_type_JavaLangString = paramString;
      localObject1 = this.jdField_b_of_type_AndroidContentSharedPreferences.edit();
      ((SharedPreferences.Editor)localObject1).putString("babyq_profile_config_Url", paramString);
      ((SharedPreferences.Editor)localObject1).commit();
      if (QLog.isColorLevel()) {
        QLog.d("Q.BabyQ", 2, "updateBabyQPlusPanelConfig| version:" + paramInt + "|profile_url:" + paramString);
      }
      for (;;)
      {
        label743:
        a(this.app.getApp(), this.app.getCurrentAccountUin(), paramInt);
        return;
        label763:
        if (QLog.isColorLevel()) {
          QLog.d("Q.BabyQ", 2, "updateBabyQPlusPanelConfig|content is empty|version:" + paramInt);
        }
        if (this.jdField_b_of_type_AndroidContentSharedPreferences == null) {
          this.jdField_b_of_type_AndroidContentSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences(this.app.getCurrentAccountUin() + "_" + "babyQ_pluspanel_config_sp_name", 0);
        }
        paramString = this.jdField_b_of_type_AndroidContentSharedPreferences.edit();
        paramString.clear();
        paramString.commit();
        this.jdField_a_of_type_JavaUtilHashMap.clear();
        this.jdField_a_of_type_JavaUtilArrayList.clear();
        this.jdField_a_of_type_JavaUtilHashMap = null;
        this.jdField_a_of_type_JavaUtilArrayList = null;
        this.jdField_a_of_type_JavaLangString = null;
        this.jdField_b_of_type_JavaLangString = null;
        bhmi.a(c, false);
        bhmi.a(d, false);
      }
      label918:
      i = 0;
      break;
    }
  }
  
  public void a(Context paramContext, String paramString, int paramInt)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt(paramString + "_" + "babyq_pluspanel_config_version", paramInt);
    paramContext.commit();
  }
  
  public void a(Context paramContext, String paramString, boolean paramBoolean)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putBoolean(paramString + "_" + "babyq_pluspanel_auto_show", paramBoolean);
    paramContext.commit();
  }
  
  public void a(Intent paramIntent)
  {
    if (paramIntent.getBooleanExtra("from_babyq", false))
    {
      this.jdField_a_of_type_Boolean = true;
      this.app.a().b("babyq_add_friend");
      bdll.b(this.app, "dc00898", "", "", "0X8007242", "0X8007242", 0, 0, "", "", "", "");
    }
  }
  
  public void a(bevl parambevl, bevm parambevm)
  {
    if ((parambevl == null) || (parambevm == null)) {}
    do
    {
      do
      {
        return;
      } while (!(parambevl instanceof beum));
      parambevl = (beum)parambevl;
      parambevl.jdField_a_of_type_Long += parambevm.c;
      parambevm.c = 0L;
      parambevm = "bytes=" + parambevl.jdField_a_of_type_Long + "-";
      parambevl.jdField_a_of_type_JavaUtilHashMap.put("Range", parambevm);
    } while (!QLog.isColorLevel());
    QLog.d("Q.BabyQ", 2, "fixReq|mWrittenBlockLen : " + parambevl.jdField_a_of_type_Long);
  }
  
  void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool5 = false;
    boolean bool1;
    boolean bool3;
    boolean bool4;
    if ((paramFromServiceMsg.isSuccess()) && (paramObject != null))
    {
      bool1 = true;
      if (QLog.isColorLevel()) {
        QLog.d("Q.BabyQ", 2, "handleGetReward success=" + bool1);
      }
      if (!bool1) {
        break label383;
      }
      bool3 = bool1;
      bool4 = bool1;
    }
    label383:
    for (;;)
    {
      try
      {
        paramToServiceMsg = (oidb_sso.OIDBSSOPkg)new oidb_sso.OIDBSSOPkg().mergeFrom((byte[])paramObject);
        if (paramToServiceMsg == null) {
          continue;
        }
        bool3 = bool1;
        bool4 = bool1;
        if (paramToServiceMsg.uint32_result.get() != 0) {
          continue;
        }
        bool2 = true;
        bool3 = bool2;
        bool4 = bool2;
        if (QLog.isColorLevel())
        {
          bool3 = bool2;
          bool4 = bool2;
          QLog.d("Q.BabyQ", 2, "handleGetReward result=" + bool2);
        }
        bool1 = bool5;
        if (bool2)
        {
          bool1 = bool5;
          bool3 = bool2;
          bool4 = bool2;
          if (paramToServiceMsg.bytes_bodybuffer.has())
          {
            bool3 = bool2;
            bool4 = bool2;
            paramToServiceMsg = paramToServiceMsg.bytes_bodybuffer.get();
            bool1 = bool5;
            if (paramToServiceMsg != null) {
              bool1 = true;
            }
          }
        }
        bool2 = bool1;
        if (QLog.isColorLevel())
        {
          QLog.d("Q.BabyQ", 2, "handleGetReward result=" + bool1);
          bool2 = bool1;
        }
      }
      catch (Exception paramToServiceMsg) {}finally
      {
        try
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.BabyQ", 2, "handleGetReward ex", paramToServiceMsg);
          }
          boolean bool2 = bool3;
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("Q.BabyQ", 2, "handleGetReward result=" + bool3);
          bool2 = bool3;
          continue;
        }
        finally
        {
          bool4 = bool3;
        }
        paramToServiceMsg = finally;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("Q.BabyQ", 2, "handleGetReward result=" + bool4);
      }
      notifyUI(1, bool2, null);
      return;
      bool1 = false;
      break;
      bool2 = false;
    }
  }
  
  public void a(String paramString)
  {
    int i = 0;
    if (TextUtils.isEmpty(paramString)) {}
    label9:
    do
    {
      ArrayList localArrayList;
      do
      {
        do
        {
          break label9;
          do
          {
            return;
          } while ((this.jdField_a_of_type_JavaUtilHashMap == null) || (this.jdField_a_of_type_JavaUtilHashMap.isEmpty()));
          localObject = (String[])this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
        } while ((localObject == null) || (localObject.length != 2));
        localObject[1] = "0";
        this.jdField_a_of_type_JavaUtilHashMap.put(paramString, localObject);
        if (this.jdField_b_of_type_AndroidContentSharedPreferences == null) {
          this.jdField_b_of_type_AndroidContentSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences(this.app.getCurrentAccountUin() + "_" + "babyQ_pluspanel_config_sp_name", 0);
        }
        localArrayList = new ArrayList();
        localObject = new ArrayList();
        a(this.jdField_b_of_type_AndroidContentSharedPreferences, localArrayList, "babyq_pluspanel_config_titles");
        a(this.jdField_b_of_type_AndroidContentSharedPreferences, (ArrayList)localObject, "babyq_pluspanel_config_reds");
      } while (localArrayList.size() != ((ArrayList)localObject).size());
      for (;;)
      {
        if (i < localArrayList.size())
        {
          if (paramString.equalsIgnoreCase((String)localArrayList.get(i))) {
            ((ArrayList)localObject).set(i, "0");
          }
        }
        else
        {
          paramString = new StringBuilder();
          localObject = ((ArrayList)localObject).iterator();
          while (((Iterator)localObject).hasNext()) {
            paramString.append((String)((Iterator)localObject).next()).append(",");
          }
        }
        i += 1;
      }
    } while (paramString.length() <= 1);
    paramString.deleteCharAt(paramString.length() - 1);
    Object localObject = this.jdField_b_of_type_AndroidContentSharedPreferences.edit();
    ((SharedPreferences.Editor)localObject).putString("babyq_pluspanel_config_reds", paramString.toString());
    ((SharedPreferences.Editor)localObject).commit();
  }
  
  public void a(SubMsgType0x6f.ForwardBody paramForwardBody)
  {
    Object localObject = (SubMsgType0x6f.RewardInfo)paramForwardBody.msg_babyq_reward_info.get();
    paramForwardBody = new Bundle();
    if (((SubMsgType0x6f.RewardInfo)localObject).uint32_type.has()) {
      paramForwardBody.putInt("rewardType", ((SubMsgType0x6f.RewardInfo)localObject).uint32_type.get());
    }
    if (((SubMsgType0x6f.RewardInfo)localObject).bytes_name.has()) {
      paramForwardBody.putByteArray("rewardName", ((SubMsgType0x6f.RewardInfo)localObject).bytes_name.get().toByteArray());
    }
    if (((SubMsgType0x6f.RewardInfo)localObject).bytes_jmp_url.has()) {
      paramForwardBody.putByteArray("rewardUrl", ((SubMsgType0x6f.RewardInfo)localObject).bytes_jmp_url.get().toByteArray());
    }
    if (((SubMsgType0x6f.RewardInfo)localObject).bytes_cookies.has()) {
      paramForwardBody.putByteArray("rewardCookie", ((SubMsgType0x6f.RewardInfo)localObject).bytes_cookies.get().toByteArray());
    }
    if (((SubMsgType0x6f.RewardInfo)localObject).bytes_jmp_wording.has()) {
      paramForwardBody.putByteArray("rewardJupWording", ((SubMsgType0x6f.RewardInfo)localObject).bytes_jmp_wording.get().toByteArray());
    }
    if (((SubMsgType0x6f.RewardInfo)localObject).bytes_opt_wording.has()) {
      paramForwardBody.putByteArray("rewardOptWording", ((SubMsgType0x6f.RewardInfo)localObject).bytes_opt_wording.get().toByteArray());
    }
    if (((SubMsgType0x6f.RewardInfo)localObject).bytes_opt_url.has()) {
      paramForwardBody.putByteArray("rewardOptUrl", ((SubMsgType0x6f.RewardInfo)localObject).bytes_opt_url.get().toByteArray());
    }
    if (((SubMsgType0x6f.RewardInfo)localObject).uint64_face_addon_id.has()) {
      paramForwardBody.putLong("rewardFaceId", ((SubMsgType0x6f.RewardInfo)localObject).uint64_face_addon_id.get());
    }
    if (((SubMsgType0x6f.RewardInfo)localObject).bytes_icon_url.has()) {
      paramForwardBody.putByteArray("rewardIconUrl", ((SubMsgType0x6f.RewardInfo)localObject).bytes_icon_url.get().toByteArray());
    }
    if (((SubMsgType0x6f.RewardInfo)localObject).bytes_toast_wording.has()) {
      paramForwardBody.putByteArray("rewardToastWording", ((SubMsgType0x6f.RewardInfo)localObject).bytes_toast_wording.get().toByteArray());
    }
    if (((SubMsgType0x6f.RewardInfo)localObject).uint32_report_type.has()) {
      paramForwardBody.putInt("rewardReportType", ((SubMsgType0x6f.RewardInfo)localObject).uint32_report_type.get());
    }
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidOsBundle = paramForwardBody;
      return;
    }
    localObject = new Intent(BaseActivity.sTopActivity, RewardNoticeActivity.class);
    ((Intent)localObject).putExtras(paramForwardBody);
    BaseActivity.sTopActivity.startActivity((Intent)localObject);
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.e("Q.BabyQ", 2, "checkDownloadIconRes | isConfigChanged : " + paramBoolean1 + ", isMD5Changed : " + paramBoolean2);
    }
    if (this.jdField_b_of_type_AndroidContentSharedPreferences == null) {
      this.jdField_b_of_type_AndroidContentSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences(this.app.getCurrentAccountUin() + "_" + "babyQ_pluspanel_config_sp_name", 0);
    }
    if (TextUtils.isEmpty(this.jdField_b_of_type_AndroidContentSharedPreferences.getString("babyq_pluspanel_config_titles", ""))) {}
    label110:
    Object localObject;
    File localFile;
    do
    {
      String str1;
      String str2;
      do
      {
        do
        {
          do
          {
            break label110;
            break label110;
            do
            {
              return;
            } while (TextUtils.isEmpty(this.jdField_b_of_type_AndroidContentSharedPreferences.getString("babyq_pluspanel_config_codes", "")));
            str1 = this.jdField_b_of_type_AndroidContentSharedPreferences.getString("babyq_pluspanel_config_zipMd5", "");
          } while (TextUtils.isEmpty(str1));
          str2 = this.jdField_b_of_type_AndroidContentSharedPreferences.getString("babyq_pluspanel_config_zipUrl", "");
        } while (TextUtils.isEmpty(str2));
        if (paramBoolean2)
        {
          bhmi.a(d, false);
          a(str2, str1, 1);
          return;
        }
        localObject = new File(d);
        localFile = new File(c);
        if (!((File)localObject).exists())
        {
          a(str2, str1, 1);
          return;
        }
      } while (!((File)localObject).isDirectory());
      localObject = ((File)localObject).listFiles();
      if ((localObject == null) || (localObject.length == 0))
      {
        a(str2, str1, 1);
        return;
      }
    } while ((localObject.length != 1) || (!localFile.exists()));
    notifyUI(5, a(c, d), null);
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    for (;;)
    {
      try
      {
        if (this.jdField_a_of_type_AndroidContentSharedPreferences == null) {
          this.jdField_a_of_type_AndroidContentSharedPreferences = this.app.getApp().getSharedPreferences("pref_babyq" + this.app.getCurrentAccountUin(), 0);
        }
        paramArrayOfByte = (babyq_cookie.BabyQCookie)new babyq_cookie.BabyQCookie().mergeFrom(paramArrayOfByte);
        if (paramArrayOfByte.uint64_client_ability.has())
        {
          long l2 = paramArrayOfByte.uint64_client_ability.get();
          l1 = l2;
          if (QLog.isColorLevel())
          {
            QLog.d("Q.BabyQ", 2, "decodePBMsgElems, babyQ ability:" + l2);
            l1 = l2;
          }
          this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putLong("Key_Ability", l1).commit();
          this.jdField_a_of_type_Long = l1;
          return;
        }
      }
      catch (Exception paramArrayOfByte)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("Q.BabyQ", 2, "setAbility " + paramArrayOfByte.toString());
        return;
      }
      long l1 = 0L;
    }
  }
  
  public boolean a(int paramInt)
  {
    return this.jdField_a_of_type_Int == paramInt;
  }
  
  public boolean a(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getBoolean(paramString + "_" + "babyq_pluspanel_auto_show", false);
  }
  
  public boolean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    if ((this.jdField_a_of_type_JavaUtilHashMap == null) || (this.jdField_a_of_type_JavaUtilHashMap.isEmpty())) {
      return false;
    }
    String[] arrayOfString = (String[])this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
    if (QLog.isColorLevel()) {
      QLog.d("Q.BabyQ", 2, "babyQPlusPanelShowRed codeAndRed.length: " + arrayOfString.length);
    }
    if ((arrayOfString == null) || (arrayOfString.length != 2)) {
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.BabyQ", 2, "babyQPlusPanelShowRed title: " + paramString + ", showRed : " + arrayOfString[1]);
    }
    return "1".equalsIgnoreCase(arrayOfString[1]);
  }
  
  public int b(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt(paramString + "_" + "babyq_pluspanel_config_appid", 0);
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_AndroidOsBundle != null))
    {
      Intent localIntent = new Intent(BaseActivity.sTopActivity, RewardNoticeActivity.class);
      localIntent.putExtras(this.jdField_a_of_type_AndroidOsBundle);
      BaseActivity.sTopActivity.startActivity(localIntent);
      this.jdField_a_of_type_AndroidOsBundle = null;
      this.jdField_a_of_type_Boolean = false;
    }
  }
  
  public void b(Context paramContext, String paramString, int paramInt)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt(paramString + "_" + "babyq_pluspanel_config_appid", paramInt);
    paramContext.commit();
  }
  
  public void b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      if (QLog.isColorLevel()) {
        QLog.d("Q.BabyQ", 2, "BabyQ funcall addBabyQGreetingMsg error for empty greeting");
      }
    }
    do
    {
      return;
      avpd localavpd = new avpd(antf.aC, this.app.getCurrentAccountUin(), paramString, 9002, -5040, 655362, bcrg.a());
      MessageForUniteGrayTip localMessageForUniteGrayTip = new MessageForUniteGrayTip();
      localMessageForUniteGrayTip.initGrayTipMsg(this.app, localavpd);
      avpe.a(this.app, localMessageForUniteGrayTip);
    } while (!QLog.isColorLevel());
    QLog.d("Q.BabyQ", 2, "BabyQ funcall addBabyQGreetingMsg success greeting =" + paramString);
  }
  
  public void b(byte[] paramArrayOfByte)
  {
    oidb_cmd0x77d.ReqBody localReqBody = new oidb_cmd0x77d.ReqBody();
    localReqBody.bytes_reward_cookie.set(ByteStringMicro.copyFrom(paramArrayOfByte));
    if (QLog.isColorLevel()) {
      QLog.i("Q.BabyQ", 2, "getReward");
    }
    paramArrayOfByte = makeOIDBPkg("OidbSvc.0x77d_0", 1917, 0, localReqBody.toByteArray());
    paramArrayOfByte.extraData.putBoolean("req_pb_protocol_flag", true);
    send(paramArrayOfByte);
  }
  
  public void c()
  {
    if (this.jdField_b_of_type_AndroidContentSharedPreferences == null) {
      this.jdField_b_of_type_AndroidContentSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences(this.app.getCurrentAccountUin() + "_" + "babyQ_pluspanel_config_sp_name", 0);
    }
    SharedPreferences.Editor localEditor = this.jdField_b_of_type_AndroidContentSharedPreferences.edit();
    localEditor.clear();
    localEditor.commit();
  }
  
  protected boolean msgCmdFilter(String paramString)
  {
    if (this.allowCmdSet == null)
    {
      this.allowCmdSet = new HashSet();
      this.allowCmdSet.add("OidbSvc.0x77d_0");
      this.allowCmdSet.add("OidbSvc.0x8db_0");
    }
    return !this.allowCmdSet.contains(paramString);
  }
  
  protected Class<? extends anui> observerClass()
  {
    return antp.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ("OidbSvc.0x77d_0".equals(paramFromServiceMsg.getServiceCmd())) {
      a(paramToServiceMsg, paramFromServiceMsg, paramObject);
    }
    while (!"OidbSvc.0x8db_0".equals(paramFromServiceMsg.getServiceCmd())) {
      return;
    }
    b(paramToServiceMsg, paramFromServiceMsg, paramObject);
  }
  
  public void onResp(bevm parambevm)
  {
    if (parambevm.jdField_a_of_type_Int == 3) {
      if (QLog.isColorLevel()) {
        QLog.d("Q.BabyQ", 2, "onResp is downloading...");
      }
    }
    do
    {
      return;
      localObject1 = parambevm.jdField_a_of_type_Bevl.a();
    } while ((localObject1 == null) || (!(localObject1 instanceof antm)));
    Object localObject1 = (antm)localObject1;
    int i;
    label57:
    Object localObject2;
    if (parambevm.jdField_a_of_type_Int == 0)
    {
      i = 1;
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder().append("onResp|download ");
        if (i == 0) {
          break label204;
        }
      }
    }
    label204:
    for (parambevm = "success";; parambevm = "failed")
    {
      QLog.d("Q.BabyQ", 2, parambevm);
      if (i == 0) {
        break label229;
      }
      parambevm = new File(c);
      localObject2 = azul.a(parambevm.getAbsolutePath());
      if ((TextUtils.isEmpty((CharSequence)localObject2)) || (((String)localObject2).equalsIgnoreCase(((antm)localObject1).jdField_b_of_type_JavaLangString))) {
        break label211;
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("Q.BabyQ", 2, "onResp|Md5 error，fileMD5 = " + (String)localObject2 + ", configMD5 = " + ((antm)localObject1).jdField_b_of_type_JavaLangString);
      bhmi.a(d, false);
      return;
      i = 0;
      break label57;
    }
    label211:
    notifyUI(5, a(parambevm.getAbsolutePath(), d), null);
    return;
    label229:
    a(((antm)localObject1).jdField_a_of_type_JavaLangString, ((antm)localObject1).jdField_b_of_type_JavaLangString, ((antm)localObject1).jdField_a_of_type_Int);
  }
  
  public void onUpdateProgeress(bevl parambevl, long paramLong1, long paramLong2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.BabyQ", 2, "onUpdateProgeress|curOffset : " + paramLong1 + ", totalLen : " + paramLong2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     antk
 * JD-Core Version:    0.7.0.1
 */