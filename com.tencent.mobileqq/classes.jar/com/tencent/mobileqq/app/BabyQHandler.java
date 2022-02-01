package com.tencent.mobileqq.app;

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
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.graytip.UniteGrayTipMsgUtil;
import com.tencent.mobileqq.graytip.UniteGrayTipParam;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.portal.PortalUtils;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.mobileqq.transfile.api.IHttpEngineService;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.FileUtils;
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

public class BabyQHandler
  extends BusinessHandler
  implements INetEngineListener
{
  private static String c;
  private static String d;
  private int jdField_a_of_type_Int = -1;
  private long jdField_a_of_type_Long = -1L;
  private SharedPreferences jdField_a_of_type_AndroidContentSharedPreferences = null;
  private Bundle jdField_a_of_type_AndroidOsBundle;
  public QQAppInterface a;
  public String a;
  public ArrayList<String> a;
  public HashMap<String, String[]> a;
  private boolean jdField_a_of_type_Boolean = false;
  private SharedPreferences b;
  public String b;
  
  protected BabyQHandler(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    this.jdField_b_of_type_AndroidContentSharedPreferences = null;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(Environment.getExternalStorageDirectory().getAbsolutePath());
    ((StringBuilder)localObject).append(File.separator);
    ((StringBuilder)localObject).append("tencent");
    ((StringBuilder)localObject).append(File.separator);
    ((StringBuilder)localObject).append("MobileQQ");
    ((StringBuilder)localObject).append(File.separator);
    ((StringBuilder)localObject).append("babyQIconRes");
    ((StringBuilder)localObject).append(File.separator);
    ((StringBuilder)localObject).append("babyQIconRes.zip");
    c = ((StringBuilder)localObject).toString();
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(Environment.getExternalStorageDirectory().getAbsolutePath());
    ((StringBuilder)localObject).append(File.separator);
    ((StringBuilder)localObject).append("tencent");
    ((StringBuilder)localObject).append(File.separator);
    ((StringBuilder)localObject).append("MobileQQ");
    ((StringBuilder)localObject).append(File.separator);
    ((StringBuilder)localObject).append("babyQIconRes");
    d = ((StringBuilder)localObject).toString();
    try
    {
      localObject = paramQQAppInterface.getApp();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("pref_babyq");
      localStringBuilder.append(paramQQAppInterface.getCurrentAccountUin());
      this.jdField_a_of_type_AndroidContentSharedPreferences = ((BaseApplication)localObject).getSharedPreferences(localStringBuilder.toString(), 0);
      localObject = BaseApplicationImpl.getApplication();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramQQAppInterface.getCurrentAccountUin());
      localStringBuilder.append("_");
      localStringBuilder.append("babyQ_pluspanel_config_sp_name");
      this.jdField_b_of_type_AndroidContentSharedPreferences = ((BaseApplicationImpl)localObject).getSharedPreferences(localStringBuilder.toString(), 0);
      this.jdField_b_of_type_JavaLangString = this.jdField_b_of_type_AndroidContentSharedPreferences.getString("babyq_pluspanel_config_zipMd5", "");
      this.jdField_a_of_type_JavaLangString = this.jdField_b_of_type_AndroidContentSharedPreferences.getString("babyq_pluspanel_config_zipUrl", "");
      paramQQAppInterface = this.jdField_b_of_type_AndroidContentSharedPreferences.getString("babyq_profile_config_Url", "");
      if (!TextUtils.isEmpty(paramQQAppInterface)) {
        Utils.jdField_b_of_type_JavaLangString = paramQQAppInterface;
      }
      d();
    }
    catch (Exception paramQQAppInterface)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("init plusPanelItems error!");
      ((StringBuilder)localObject).append(paramQQAppInterface);
      QLog.i("Q.BabyQ", 1, ((StringBuilder)localObject).toString());
    }
    if (QLog.isColorLevel())
    {
      paramQQAppInterface = new StringBuilder();
      paramQQAppInterface.append("BabyQHandler | Utils.sBabyQProfileUrl :");
      paramQQAppInterface.append(Utils.jdField_b_of_type_JavaLangString);
      QLog.d("Q.BabyQ", 2, paramQQAppInterface.toString());
    }
  }
  
  public static void a(Context paramContext, View paramView)
  {
    paramView.setVisibility(0);
    paramContext = AnimationUtils.loadAnimation(paramContext, 2130772273);
    paramContext.setAnimationListener(new BabyQHandler.1(paramView));
    paramView.startAnimation(paramContext);
  }
  
  private void a(SharedPreferences paramSharedPreferences, ArrayList<String> paramArrayList, String paramString)
  {
    if (paramArrayList == null) {
      return;
    }
    paramArrayList.clear();
    paramSharedPreferences = paramSharedPreferences.getString(paramString, "");
    if (paramSharedPreferences.length() > 0)
    {
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
    int i = 1;
    Object localObject2;
    if ((paramInt1 != 1) && (paramInt1 != 2))
    {
      if ((paramInt1 != 3) && (paramInt1 != 4))
      {
        if (paramInt1 == 5)
        {
          if (paramInt2 == 1) {
            localObject1 = "0X8007250";
          } else {
            localObject1 = "0X8007251";
          }
        }
        else {
          localObject1 = "";
        }
        i = 0;
        break label123;
      }
      if (paramInt2 == 1) {
        localObject1 = "0X800724E";
      } else {
        localObject1 = "0X800724F";
      }
      localObject2 = localObject1;
      if (paramInt1 == 3) {
        break label123;
      }
    }
    else
    {
      if (paramInt2 == 1) {
        localObject1 = "0X800724C";
      } else {
        localObject1 = "0X800724D";
      }
      localObject2 = localObject1;
      if (paramInt1 == 1) {
        break label123;
      }
    }
    i = 2;
    Object localObject1 = localObject2;
    label123:
    if (!TextUtils.isEmpty((CharSequence)localObject1))
    {
      ReportController.b(paramQQAppInterface, "dc00898", "", "", (String)localObject1, (String)localObject1, i, 0, "", "", "", "");
      return;
    }
    if (QLog.isColorLevel())
    {
      paramQQAppInterface = new StringBuilder();
      paramQQAppInterface.append("reportRewardAction error type:");
      paramQQAppInterface.append(paramInt1);
      paramQQAppInterface.append(" action:");
      paramQQAppInterface.append(paramInt2);
      QLog.d("Q.BabyQ", 2, paramQQAppInterface.toString());
    }
  }
  
  private void a(String paramString1, String paramString2, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("downloadIconRes | tryTimes : ");
      ((StringBuilder)localObject).append(paramInt);
      QLog.e("Q.BabyQ", 2, ((StringBuilder)localObject).toString());
    }
    if (paramInt > 2) {
      return;
    }
    Object localObject = (IHttpEngineService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IHttpEngineService.class, "all");
    HttpNetReq localHttpNetReq = new HttpNetReq();
    localHttpNetReq.mCallback = this;
    localHttpNetReq.mSupportBreakResume = true;
    localHttpNetReq.mReqUrl = paramString1;
    localHttpNetReq.mOutPath = c;
    localHttpNetReq.mHttpMethod = 0;
    localHttpNetReq.mPrioty = 1;
    localHttpNetReq.setUserData(new BabyQHandler.BabyQUserData(this, paramInt + 1, paramString1, paramString2));
    ((IHttpEngineService)localObject).sendReq(localHttpNetReq);
  }
  
  private boolean a(String paramString1, String paramString2)
  {
    try
    {
      FileUtils.uncompressZip(paramString1, paramString2, false);
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
    boolean bool2 = true;
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess()) && (paramObject != null)) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    if (QLog.isColorLevel())
    {
      paramToServiceMsg = new StringBuilder();
      paramToServiceMsg.append("BabyQ funcall handleAddBabyQAsFriend success = ");
      paramToServiceMsg.append(bool1);
      QLog.d("Q.BabyQ", 2, paramToServiceMsg.toString());
    }
    paramFromServiceMsg = new oidb_sso.OIDBSSOPkg();
    oidb_0x8db.RspBody localRspBody = new oidb_0x8db.RspBody();
    Bundle localBundle = new Bundle();
    paramToServiceMsg = paramFromServiceMsg;
    if (paramObject != null) {}
    try
    {
      paramToServiceMsg = (oidb_sso.OIDBSSOPkg)paramFromServiceMsg.mergeFrom((byte[])paramObject);
      if (paramToServiceMsg == null) {
        break label308;
      }
      i = paramToServiceMsg.uint32_result.get();
      localBundle.putInt("ad_bbq_code", i);
      if (i != 0) {
        break label385;
      }
      bool1 = bool2;
    }
    catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
    {
      for (;;)
      {
        int i;
        continue;
        bool1 = false;
      }
    }
    if ((paramToServiceMsg.bytes_bodybuffer.has()) && (paramToServiceMsg.bytes_bodybuffer.get() != null))
    {
      localRspBody.mergeFrom(paramToServiceMsg.bytes_bodybuffer.get().toByteArray());
      paramToServiceMsg = localRspBody.bytes_welcome_msg.get().toStringUtf8();
      localBundle.putString("ad_bbq_message", paramToServiceMsg);
    }
    else
    {
      paramToServiceMsg = "";
    }
    if (QLog.isColorLevel())
    {
      paramFromServiceMsg = new StringBuilder();
      paramFromServiceMsg.append("BabyQ funcall handleAddBabyQAsFriend result = ");
      paramFromServiceMsg.append(i);
      paramFromServiceMsg.append(" msg = ");
      paramFromServiceMsg.append(paramToServiceMsg);
      QLog.d("Q.BabyQ", 2, paramFromServiceMsg.toString());
    }
    ((FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).addFriendToFriendList(AppConstants.BABY_Q_UIN, 0, 3999, "", true, false, -1L);
    notifyUI(4, bool1, localBundle);
    return;
    label308:
    if (QLog.isColorLevel()) {
      QLog.d("Q.BabyQ", 2, "BabyQ funcall handleAddBabyQAsFriend false ");
    }
    notifyUI(4, false, null);
    return;
    if (QLog.isColorLevel())
    {
      paramToServiceMsg = new StringBuilder();
      paramToServiceMsg.append("BabyQ funcall handleAddBabyQAsFriend exception =");
      paramToServiceMsg.append(paramFromServiceMsg.getStackTrace());
      QLog.d("Q.BabyQ", 2, paramToServiceMsg.toString());
    }
    notifyUI(4, false, localBundle);
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
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("BabyQHandler | titleList :");
      localStringBuilder.append(this.jdField_a_of_type_JavaUtilArrayList);
      localStringBuilder.append(" | codeList : ");
      localStringBuilder.append(localArrayList1);
      localStringBuilder.append(" | redList : ");
      localStringBuilder.append(localArrayList2);
      localStringBuilder.append(" | zipMd5 : ");
      localStringBuilder.append(this.jdField_b_of_type_JavaLangString);
      localStringBuilder.append(" | zipUrl : ");
      localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
      QLog.d("Q.BabyQ", 2, localStringBuilder.toString());
    }
    if ((this.jdField_a_of_type_JavaUtilArrayList.size() == localArrayList1.size()) && (localArrayList1.size() == localArrayList2.size()))
    {
      if (this.jdField_a_of_type_JavaUtilArrayList.size() != localArrayList2.size()) {
        return;
      }
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
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("_");
    localStringBuilder.append("babyq_pluspanel_config_version");
    return paramContext.getInt(localStringBuilder.toString(), 0);
  }
  
  public long a()
  {
    try
    {
      Object localObject;
      if (this.jdField_a_of_type_AndroidContentSharedPreferences == null)
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("pref_babyq");
        localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
        this.jdField_a_of_type_AndroidContentSharedPreferences = ((BaseApplication)localObject).getSharedPreferences(localStringBuilder.toString(), 0);
      }
      if (this.jdField_a_of_type_Long == -1L)
      {
        this.jdField_a_of_type_Long = this.jdField_a_of_type_AndroidContentSharedPreferences.getLong("Key_Ability", 0L);
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("getAbility ");
          ((StringBuilder)localObject).append(this.jdField_a_of_type_Long);
          QLog.d("Q.BabyQ", 2, ((StringBuilder)localObject).toString());
        }
      }
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder;
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("getAbility error e:");
        localStringBuilder.append(localException.toString());
        QLog.d("Q.BabyQ", 2, localStringBuilder.toString());
      }
    }
    return this.jdField_a_of_type_Long;
  }
  
  public Drawable a(int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(d);
    ((StringBuilder)localObject).append(File.separator);
    ((StringBuilder)localObject).append("babyq_");
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append(".png");
    localObject = ((StringBuilder)localObject).toString();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getBabyQPlusPanelIcon iconPath: ");
      localStringBuilder.append((String)localObject);
      QLog.d("Q.BabyQ", 2, localStringBuilder.toString());
    }
    if (FileUtils.fileExistsAndNotEmpty((String)localObject)) {
      return new BitmapDrawable(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getResources(), (String)localObject);
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
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("handleBabyQGuide handleType:");
      ((StringBuilder)localObject).append(paramInt);
      QLog.d("Q.BabyQ", 2, ((StringBuilder)localObject).toString());
    }
    if (this.jdField_a_of_type_AndroidContentSharedPreferences == null)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("pref_babyq");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      this.jdField_a_of_type_AndroidContentSharedPreferences = ((BaseApplication)localObject).getSharedPreferences(localStringBuilder.toString(), 0);
    }
    Object localObject = this.jdField_a_of_type_AndroidContentSharedPreferences;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Key_Guide_");
    localStringBuilder.append(paramInt);
    if (((SharedPreferences)localObject).getBoolean(localStringBuilder.toString(), false))
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
    localObject = this.jdField_a_of_type_AndroidContentSharedPreferences.edit();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("Key_Guide_");
    localStringBuilder.append(paramInt);
    ((SharedPreferences.Editor)localObject).putBoolean(localStringBuilder.toString(), true).commit();
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
      localStringBuilder.append(" userType = ");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(" fromType = ");
      localStringBuilder.append(paramInt2);
      localStringBuilder.append("\n");
      QLog.i("Q.BabyQ", 2, localStringBuilder.toString());
    }
    localObject = makeOIDBPkg("OidbSvc.0x8db_0", 2267, 0, ((oidb_0x8db.ReqBody)localObject).toByteArray());
    ((ToServiceMsg)localObject).extraData.putBoolean("req_pb_protocol_flag", true);
    send((ToServiceMsg)localObject);
  }
  
  public void a(int paramInt, String paramString)
  {
    Object localObject4 = "Q.BabyQ";
    Object localObject1 = localObject4;
    for (;;)
    {
      boolean bool;
      Object localObject5;
      int i;
      try
      {
        bool = TextUtils.isEmpty(paramString);
        if (!bool)
        {
          localObject1 = localObject4;
          localObject3 = new JSONObject(paramString);
          localObject1 = localObject4;
          this.jdField_a_of_type_JavaLangString = ((JSONObject)localObject3).optString("zip_url");
          localObject1 = localObject4;
          this.jdField_b_of_type_JavaLangString = ((JSONObject)localObject3).optString("zip_md5");
          localObject1 = localObject4;
          localObject5 = ((JSONObject)localObject3).getJSONArray("babyq_items");
          if (localObject5 == null) {
            break label1310;
          }
          localObject1 = localObject4;
          if (((JSONArray)localObject5).length() <= 0) {
            break label1310;
          }
          localObject1 = localObject4;
          localStringBuilder2 = new StringBuilder(64);
          localObject1 = localObject4;
          localStringBuilder3 = new StringBuilder(32);
          localObject1 = localObject4;
          localStringBuilder4 = new StringBuilder(32);
          localObject1 = localObject4;
          if (this.jdField_a_of_type_JavaUtilArrayList == null)
          {
            localObject1 = localObject4;
            this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
          }
          else
          {
            localObject1 = localObject4;
            this.jdField_a_of_type_JavaUtilArrayList.clear();
          }
          localObject1 = localObject4;
          if (this.jdField_a_of_type_JavaUtilHashMap == null)
          {
            localObject1 = localObject4;
            this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
            break label1284;
          }
          localObject1 = localObject4;
          this.jdField_a_of_type_JavaUtilHashMap.clear();
          break label1284;
          localObject1 = paramString;
          if (i < ((JSONArray)localObject4).length())
          {
            localObject1 = paramString;
            localObject6 = ((JSONArray)localObject4).optJSONObject(i);
            localObject1 = paramString;
            localObject5 = ((JSONObject)localObject6).optString("title");
            localObject1 = paramString;
            str2 = ((JSONObject)localObject6).optString("code");
            localObject1 = paramString;
            localObject6 = ((JSONObject)localObject6).optString("redpoint");
            localObject1 = paramString;
            localHashMap = this.jdField_a_of_type_JavaUtilHashMap;
          }
        }
      }
      catch (Exception localException3)
      {
        Object localObject3;
        StringBuilder localStringBuilder2;
        StringBuilder localStringBuilder3;
        StringBuilder localStringBuilder4;
        Object localObject6;
        String str2;
        HashMap localHashMap;
        paramString = localException1;
        localObject2 = localException3;
      }
      try
      {
        localHashMap.put(localObject5, new String[] { str2, localObject6 });
        this.jdField_a_of_type_JavaUtilArrayList.add(localObject5);
        localStringBuilder2.append((String)localObject5);
        localStringBuilder2.append(",");
        localStringBuilder3.append(str2);
        localStringBuilder3.append(",");
        localStringBuilder4.append((String)localObject6);
        localStringBuilder4.append(",");
        i += 1;
      }
      catch (Exception localException2)
      {
        break label1238;
      }
    }
    localObject1 = paramString;
    if (this.jdField_b_of_type_AndroidContentSharedPreferences == null)
    {
      localObject4 = BaseApplicationImpl.getApplication();
      localObject5 = new StringBuilder();
      ((StringBuilder)localObject5).append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      ((StringBuilder)localObject5).append("_");
      ((StringBuilder)localObject5).append("babyQ_pluspanel_config_sp_name");
      this.jdField_b_of_type_AndroidContentSharedPreferences = ((BaseApplicationImpl)localObject4).getSharedPreferences(((StringBuilder)localObject5).toString(), 0);
    }
    if (!this.jdField_b_of_type_AndroidContentSharedPreferences.getString("babyq_pluspanel_config_zipMd5", "").equalsIgnoreCase(this.jdField_b_of_type_JavaLangString))
    {
      bool = true;
      label479:
      localObject4 = this.jdField_b_of_type_AndroidContentSharedPreferences.edit();
      if (localStringBuilder2.length() > 1)
      {
        localStringBuilder2.deleteCharAt(localStringBuilder2.length() - 1);
        ((SharedPreferences.Editor)localObject4).putString("babyq_pluspanel_config_titles", localStringBuilder2.toString());
      }
      if (localStringBuilder3.length() > 1)
      {
        localStringBuilder3.deleteCharAt(localStringBuilder3.length() - 1);
        ((SharedPreferences.Editor)localObject4).putString("babyq_pluspanel_config_codes", localStringBuilder3.toString());
      }
      if (localStringBuilder4.length() > 1)
      {
        localStringBuilder4.deleteCharAt(localStringBuilder4.length() - 1);
        ((SharedPreferences.Editor)localObject4).putString("babyq_pluspanel_config_reds", localStringBuilder4.toString());
      }
      ((SharedPreferences.Editor)localObject4).putString("babyq_pluspanel_config_zipMd5", this.jdField_b_of_type_JavaLangString);
      ((SharedPreferences.Editor)localObject4).putString("babyq_pluspanel_config_zipUrl", this.jdField_a_of_type_JavaLangString);
      ((SharedPreferences.Editor)localObject4).commit();
      a(true, bool);
      if (!QLog.isColorLevel()) {
        break label1302;
      }
      localObject4 = new StringBuilder();
      ((StringBuilder)localObject4).append("updateBabyQPlusPanelConfig|version:");
      ((StringBuilder)localObject4).append(paramInt);
      ((StringBuilder)localObject4).append("|sbTitle:");
      ((StringBuilder)localObject4).append(localStringBuilder2.toString());
      ((StringBuilder)localObject4).append("|sbCode:");
      ((StringBuilder)localObject4).append(localStringBuilder3.toString());
      ((StringBuilder)localObject4).append("|sbRed:");
      ((StringBuilder)localObject4).append(localStringBuilder4);
      ((StringBuilder)localObject4).append("|zipUrl:");
      ((StringBuilder)localObject4).append(this.jdField_a_of_type_JavaLangString);
      ((StringBuilder)localObject4).append("|zipMd5:");
      ((StringBuilder)localObject4).append(this.jdField_b_of_type_JavaLangString);
      localObject4 = ((StringBuilder)localObject4).toString();
      paramString = (String)localObject1;
    }
    for (;;)
    {
      try
      {
        QLog.d((String)localObject1, 2, (String)localObject4);
        paramString = (String)localObject1;
        localObject4 = ((JSONObject)localObject3).optString("babyq_profile_url");
        paramString = (String)localObject1;
        Utils.jdField_b_of_type_JavaLangString = (String)localObject4;
        paramString = (String)localObject1;
        localObject3 = this.jdField_b_of_type_AndroidContentSharedPreferences.edit();
        paramString = (String)localObject1;
        ((SharedPreferences.Editor)localObject3).putString("babyq_profile_config_Url", (String)localObject4);
        paramString = (String)localObject1;
        ((SharedPreferences.Editor)localObject3).commit();
        localObject3 = localObject1;
        paramString = (String)localObject1;
        if (QLog.isColorLevel())
        {
          paramString = (String)localObject1;
          localObject3 = new StringBuilder();
          paramString = (String)localObject1;
          ((StringBuilder)localObject3).append("updateBabyQPlusPanelConfig| version:");
          paramString = (String)localObject1;
          ((StringBuilder)localObject3).append(paramInt);
          paramString = (String)localObject1;
          ((StringBuilder)localObject3).append("|profile_url:");
          paramString = (String)localObject1;
          ((StringBuilder)localObject3).append((String)localObject4);
          paramString = (String)localObject1;
          QLog.d((String)localObject1, 2, ((StringBuilder)localObject3).toString());
          localObject3 = localObject1;
          continue;
          localObject3 = "Q.BabyQ";
          paramString = (String)localObject3;
          if (QLog.isColorLevel())
          {
            paramString = (String)localObject3;
            localObject1 = new StringBuilder();
            paramString = (String)localObject3;
            ((StringBuilder)localObject1).append("updateBabyQPlusPanelConfig|content is empty|version:");
            paramString = (String)localObject3;
            ((StringBuilder)localObject1).append(paramInt);
            paramString = (String)localObject3;
            QLog.d((String)localObject3, 2, ((StringBuilder)localObject1).toString());
          }
          paramString = (String)localObject3;
          if (this.jdField_b_of_type_AndroidContentSharedPreferences == null)
          {
            paramString = (String)localObject3;
            localObject1 = BaseApplicationImpl.getApplication();
            paramString = (String)localObject3;
            localObject4 = new StringBuilder();
            paramString = (String)localObject3;
            ((StringBuilder)localObject4).append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
            paramString = (String)localObject3;
            ((StringBuilder)localObject4).append("_");
            paramString = (String)localObject3;
            ((StringBuilder)localObject4).append("babyQ_pluspanel_config_sp_name");
            paramString = (String)localObject3;
            this.jdField_b_of_type_AndroidContentSharedPreferences = ((BaseApplicationImpl)localObject1).getSharedPreferences(((StringBuilder)localObject4).toString(), 0);
          }
          paramString = (String)localObject3;
          localObject1 = this.jdField_b_of_type_AndroidContentSharedPreferences.edit();
          paramString = (String)localObject3;
          ((SharedPreferences.Editor)localObject1).clear();
          paramString = (String)localObject3;
          ((SharedPreferences.Editor)localObject1).commit();
          paramString = (String)localObject3;
          this.jdField_a_of_type_JavaUtilHashMap.clear();
          paramString = (String)localObject3;
          this.jdField_a_of_type_JavaUtilArrayList.clear();
          paramString = (String)localObject3;
          this.jdField_a_of_type_JavaUtilHashMap = null;
          paramString = (String)localObject3;
          this.jdField_a_of_type_JavaUtilArrayList = null;
          paramString = (String)localObject3;
          this.jdField_a_of_type_JavaLangString = null;
          paramString = (String)localObject3;
          this.jdField_b_of_type_JavaLangString = null;
          paramString = (String)localObject3;
          FileUtils.delete(c, false);
          paramString = (String)localObject3;
          FileUtils.delete(d, false);
        }
        paramString = (String)localObject3;
        a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), paramInt);
        return;
      }
      catch (Exception localException1) {}
      Object localObject2;
      label1238:
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder1 = new StringBuilder();
        localStringBuilder1.append("updateBabyQPlusPanelConfig error ");
        localStringBuilder1.append(localObject2.getMessage());
        QLog.e(paramString, 2, localStringBuilder1.toString());
      }
      return;
      label1284:
      i = 0;
      paramString = (String)localObject4;
      localObject4 = localObject5;
      break;
      bool = false;
      break label479;
      label1302:
      continue;
      label1310:
      String str1 = "Q.BabyQ";
    }
  }
  
  public void a(Context paramContext, String paramString, int paramInt)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("_");
    localStringBuilder.append("babyq_pluspanel_config_version");
    paramContext.putInt(localStringBuilder.toString(), paramInt);
    paramContext.commit();
  }
  
  public void a(Context paramContext, String paramString, boolean paramBoolean)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("_");
    localStringBuilder.append("babyq_pluspanel_auto_show");
    paramContext.putBoolean(localStringBuilder.toString(), paramBoolean);
    paramContext.commit();
  }
  
  public void a(Intent paramIntent)
  {
    if (paramIntent.getBooleanExtra("from_babyq", false))
    {
      this.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().b("babyq_add_friend");
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8007242", "0X8007242", 0, 0, "", "", "", "");
    }
  }
  
  /* Error */
  void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    // Byte code:
    //   0: aload_2
    //   1: invokevirtual 325	com/tencent/qphone/base/remote/FromServiceMsg:isSuccess	()Z
    //   4: ifeq +13 -> 17
    //   7: aload_3
    //   8: ifnull +9 -> 17
    //   11: iconst_1
    //   12: istore 5
    //   14: goto +6 -> 20
    //   17: iconst_0
    //   18: istore 5
    //   20: invokestatic 155	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   23: ifeq +36 -> 59
    //   26: new 44	java/lang/StringBuilder
    //   29: dup
    //   30: invokespecial 47	java/lang/StringBuilder:<init>	()V
    //   33: astore_1
    //   34: aload_1
    //   35: ldc_w 699
    //   38: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   41: pop
    //   42: aload_1
    //   43: iload 5
    //   45: invokevirtual 330	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   48: pop
    //   49: ldc 145
    //   51: iconst_2
    //   52: aload_1
    //   53: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   56: invokestatic 159	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   59: iload 5
    //   61: istore 4
    //   63: iload 5
    //   65: ifeq +314 -> 379
    //   68: iload 5
    //   70: istore 6
    //   72: iload 5
    //   74: istore 4
    //   76: new 332	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   79: dup
    //   80: invokespecial 333	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   83: aload_3
    //   84: checkcast 341	[B
    //   87: checkcast 341	[B
    //   90: invokevirtual 345	tencent/im/oidb/oidb_sso$OIDBSSOPkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   93: checkcast 332	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   96: astore_1
    //   97: aload_1
    //   98: ifnull +311 -> 409
    //   101: iload 5
    //   103: istore 6
    //   105: iload 5
    //   107: istore 4
    //   109: aload_1
    //   110: getfield 349	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   113: invokevirtual 354	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   116: ifne +293 -> 409
    //   119: iconst_1
    //   120: istore 5
    //   122: goto +3 -> 125
    //   125: iload 5
    //   127: istore 6
    //   129: iload 5
    //   131: istore 4
    //   133: invokestatic 155	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   136: ifeq +68 -> 204
    //   139: iload 5
    //   141: istore 6
    //   143: iload 5
    //   145: istore 4
    //   147: new 44	java/lang/StringBuilder
    //   150: dup
    //   151: invokespecial 47	java/lang/StringBuilder:<init>	()V
    //   154: astore_2
    //   155: iload 5
    //   157: istore 6
    //   159: iload 5
    //   161: istore 4
    //   163: aload_2
    //   164: ldc_w 701
    //   167: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   170: pop
    //   171: iload 5
    //   173: istore 6
    //   175: iload 5
    //   177: istore 4
    //   179: aload_2
    //   180: iload 5
    //   182: invokevirtual 330	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   185: pop
    //   186: iload 5
    //   188: istore 6
    //   190: iload 5
    //   192: istore 4
    //   194: ldc 145
    //   196: iconst_2
    //   197: aload_2
    //   198: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   201: invokestatic 159	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   204: iload 5
    //   206: ifeq +47 -> 253
    //   209: iload 5
    //   211: istore 6
    //   213: iload 5
    //   215: istore 4
    //   217: aload_1
    //   218: getfield 364	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   221: invokevirtual 369	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   224: ifeq +29 -> 253
    //   227: iload 5
    //   229: istore 6
    //   231: iload 5
    //   233: istore 4
    //   235: aload_1
    //   236: getfield 364	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   239: invokevirtual 372	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   242: astore_1
    //   243: aload_1
    //   244: ifnull +9 -> 253
    //   247: iconst_1
    //   248: istore 4
    //   250: goto +129 -> 379
    //   253: iconst_0
    //   254: istore 4
    //   256: goto +123 -> 379
    //   259: astore_1
    //   260: goto +78 -> 338
    //   263: astore_1
    //   264: iload 4
    //   266: istore 6
    //   268: invokestatic 155	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   271: ifeq +17 -> 288
    //   274: iload 4
    //   276: istore 6
    //   278: ldc 145
    //   280: iconst_2
    //   281: ldc_w 703
    //   284: aload_1
    //   285: invokestatic 705	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   288: iload 4
    //   290: istore 5
    //   292: invokestatic 155	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   295: ifeq +105 -> 400
    //   298: new 44	java/lang/StringBuilder
    //   301: dup
    //   302: invokespecial 47	java/lang/StringBuilder:<init>	()V
    //   305: astore_1
    //   306: aload_1
    //   307: ldc_w 701
    //   310: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   313: pop
    //   314: aload_1
    //   315: iload 4
    //   317: invokevirtual 330	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   320: pop
    //   321: ldc 145
    //   323: iconst_2
    //   324: aload_1
    //   325: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   328: invokestatic 159	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   331: iload 4
    //   333: istore 5
    //   335: goto +65 -> 400
    //   338: invokestatic 155	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   341: ifeq +36 -> 377
    //   344: new 44	java/lang/StringBuilder
    //   347: dup
    //   348: invokespecial 47	java/lang/StringBuilder:<init>	()V
    //   351: astore_2
    //   352: aload_2
    //   353: ldc_w 701
    //   356: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   359: pop
    //   360: aload_2
    //   361: iload 6
    //   363: invokevirtual 330	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   366: pop
    //   367: ldc 145
    //   369: iconst_2
    //   370: aload_2
    //   371: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   374: invokestatic 159	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   377: aload_1
    //   378: athrow
    //   379: iload 4
    //   381: istore 5
    //   383: invokestatic 155	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   386: ifeq +14 -> 400
    //   389: new 44	java/lang/StringBuilder
    //   392: dup
    //   393: invokespecial 47	java/lang/StringBuilder:<init>	()V
    //   396: astore_1
    //   397: goto -91 -> 306
    //   400: aload_0
    //   401: iconst_1
    //   402: iload 5
    //   404: aconst_null
    //   405: invokevirtual 419	com/tencent/mobileqq/app/BabyQHandler:notifyUI	(IZLjava/lang/Object;)V
    //   408: return
    //   409: iconst_0
    //   410: istore 5
    //   412: goto -287 -> 125
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	415	0	this	BabyQHandler
    //   0	415	1	paramToServiceMsg	ToServiceMsg
    //   0	415	2	paramFromServiceMsg	FromServiceMsg
    //   0	415	3	paramObject	Object
    //   61	319	4	bool1	boolean
    //   12	399	5	bool2	boolean
    //   70	292	6	bool3	boolean
    // Exception table:
    //   from	to	target	type
    //   76	97	259	finally
    //   109	119	259	finally
    //   133	139	259	finally
    //   147	155	259	finally
    //   163	171	259	finally
    //   179	186	259	finally
    //   194	204	259	finally
    //   217	227	259	finally
    //   235	243	259	finally
    //   268	274	259	finally
    //   278	288	259	finally
    //   76	97	263	java/lang/Exception
    //   109	119	263	java/lang/Exception
    //   133	139	263	java/lang/Exception
    //   147	155	263	java/lang/Exception
    //   163	171	263	java/lang/Exception
    //   179	186	263	java/lang/Exception
    //   194	204	263	java/lang/Exception
    //   217	227	263	java/lang/Exception
    //   235	243	263	java/lang/Exception
  }
  
  public void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    Object localObject1 = this.jdField_a_of_type_JavaUtilHashMap;
    if (localObject1 != null)
    {
      if (((HashMap)localObject1).isEmpty()) {
        return;
      }
      localObject1 = (String[])this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
      if (localObject1 != null)
      {
        if (localObject1.length != 2) {
          return;
        }
        localObject1[1] = "0";
        this.jdField_a_of_type_JavaUtilHashMap.put(paramString, localObject1);
        localObject1 = this.jdField_b_of_type_AndroidContentSharedPreferences;
        int i = 0;
        if (localObject1 == null)
        {
          localObject1 = BaseApplicationImpl.getApplication();
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
          ((StringBuilder)localObject2).append("_");
          ((StringBuilder)localObject2).append("babyQ_pluspanel_config_sp_name");
          this.jdField_b_of_type_AndroidContentSharedPreferences = ((BaseApplicationImpl)localObject1).getSharedPreferences(((StringBuilder)localObject2).toString(), 0);
        }
        Object localObject2 = new ArrayList();
        localObject1 = new ArrayList();
        a(this.jdField_b_of_type_AndroidContentSharedPreferences, (ArrayList)localObject2, "babyq_pluspanel_config_titles");
        a(this.jdField_b_of_type_AndroidContentSharedPreferences, (ArrayList)localObject1, "babyq_pluspanel_config_reds");
        if (((ArrayList)localObject2).size() != ((ArrayList)localObject1).size()) {
          return;
        }
        while (i < ((ArrayList)localObject2).size())
        {
          if (paramString.equalsIgnoreCase((String)((ArrayList)localObject2).get(i)))
          {
            ((ArrayList)localObject1).set(i, "0");
            break;
          }
          i += 1;
        }
        paramString = new StringBuilder();
        localObject1 = ((ArrayList)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          paramString.append((String)((Iterator)localObject1).next());
          paramString.append(",");
        }
        if (paramString.length() > 1)
        {
          paramString.deleteCharAt(paramString.length() - 1);
          localObject1 = this.jdField_b_of_type_AndroidContentSharedPreferences.edit();
          ((SharedPreferences.Editor)localObject1).putString("babyq_pluspanel_config_reds", paramString.toString());
          ((SharedPreferences.Editor)localObject1).commit();
        }
      }
    }
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
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("checkDownloadIconRes | isConfigChanged : ");
      ((StringBuilder)localObject1).append(paramBoolean1);
      ((StringBuilder)localObject1).append(", isMD5Changed : ");
      ((StringBuilder)localObject1).append(paramBoolean2);
      QLog.e("Q.BabyQ", 2, ((StringBuilder)localObject1).toString());
    }
    if (this.jdField_b_of_type_AndroidContentSharedPreferences == null)
    {
      localObject1 = BaseApplicationImpl.getApplication();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      ((StringBuilder)localObject2).append("_");
      ((StringBuilder)localObject2).append("babyQ_pluspanel_config_sp_name");
      this.jdField_b_of_type_AndroidContentSharedPreferences = ((BaseApplicationImpl)localObject1).getSharedPreferences(((StringBuilder)localObject2).toString(), 0);
    }
    if (TextUtils.isEmpty(this.jdField_b_of_type_AndroidContentSharedPreferences.getString("babyq_pluspanel_config_titles", ""))) {
      return;
    }
    if (TextUtils.isEmpty(this.jdField_b_of_type_AndroidContentSharedPreferences.getString("babyq_pluspanel_config_codes", ""))) {
      return;
    }
    Object localObject1 = this.jdField_b_of_type_AndroidContentSharedPreferences.getString("babyq_pluspanel_config_zipMd5", "");
    if (TextUtils.isEmpty((CharSequence)localObject1)) {
      return;
    }
    Object localObject2 = this.jdField_b_of_type_AndroidContentSharedPreferences.getString("babyq_pluspanel_config_zipUrl", "");
    if (TextUtils.isEmpty((CharSequence)localObject2)) {
      return;
    }
    if (paramBoolean2)
    {
      FileUtils.delete(d, false);
      a((String)localObject2, (String)localObject1, 1);
      return;
    }
    Object localObject3 = new File(d);
    File localFile = new File(c);
    if (!((File)localObject3).exists())
    {
      a((String)localObject2, (String)localObject1, 1);
      return;
    }
    if (((File)localObject3).isDirectory())
    {
      localObject3 = ((File)localObject3).listFiles();
      if ((localObject3 != null) && (localObject3.length != 0))
      {
        if ((localObject3.length == 1) && (localFile.exists())) {
          notifyUI(5, a(c, d), null);
        }
      }
      else {
        a((String)localObject2, (String)localObject1, 1);
      }
    }
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    try
    {
      if (this.jdField_a_of_type_AndroidContentSharedPreferences == null)
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("pref_babyq");
        localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
        this.jdField_a_of_type_AndroidContentSharedPreferences = ((BaseApplication)localObject).getSharedPreferences(localStringBuilder.toString(), 0);
      }
      paramArrayOfByte = (babyq_cookie.BabyQCookie)new babyq_cookie.BabyQCookie().mergeFrom(paramArrayOfByte);
      long l1 = 0L;
      if (paramArrayOfByte.uint64_client_ability.has())
      {
        long l2 = paramArrayOfByte.uint64_client_ability.get();
        l1 = l2;
        if (QLog.isColorLevel())
        {
          paramArrayOfByte = new StringBuilder();
          paramArrayOfByte.append("decodePBMsgElems, babyQ ability:");
          paramArrayOfByte.append(l2);
          QLog.d("Q.BabyQ", 2, paramArrayOfByte.toString());
          l1 = l2;
        }
      }
      this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putLong("Key_Ability", l1).commit();
      this.jdField_a_of_type_Long = l1;
      return;
    }
    catch (Exception paramArrayOfByte)
    {
      Object localObject;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("setAbility ");
        ((StringBuilder)localObject).append(paramArrayOfByte.toString());
        QLog.d("Q.BabyQ", 2, ((StringBuilder)localObject).toString());
      }
    }
  }
  
  public boolean a(int paramInt)
  {
    return this.jdField_a_of_type_Int == paramInt;
  }
  
  public boolean a(Context paramContext, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("_");
    localStringBuilder.append("babyq_pluspanel_auto_show");
    return paramContext.getBoolean(localStringBuilder.toString(), false);
  }
  
  public boolean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    Object localObject = this.jdField_a_of_type_JavaUtilHashMap;
    if (localObject != null)
    {
      if (((HashMap)localObject).isEmpty()) {
        return false;
      }
      localObject = (String[])this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
      StringBuilder localStringBuilder;
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("babyQPlusPanelShowRed codeAndRed.length: ");
        localStringBuilder.append(localObject.length);
        QLog.d("Q.BabyQ", 2, localStringBuilder.toString());
      }
      if (localObject != null)
      {
        if (localObject.length != 2) {
          return false;
        }
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("babyQPlusPanelShowRed title: ");
          localStringBuilder.append(paramString);
          localStringBuilder.append(", showRed : ");
          localStringBuilder.append(localObject[1]);
          QLog.d("Q.BabyQ", 2, localStringBuilder.toString());
        }
        return "1".equalsIgnoreCase(localObject[1]);
      }
    }
    return false;
  }
  
  public int b(Context paramContext, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("_");
    localStringBuilder.append("babyq_pluspanel_config_appid");
    return paramContext.getInt(localStringBuilder.toString(), 0);
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("_");
    localStringBuilder.append("babyq_pluspanel_config_appid");
    paramContext.putInt(localStringBuilder.toString(), paramInt);
    paramContext.commit();
  }
  
  public void b(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.BabyQ", 2, "BabyQ funcall addBabyQGreetingMsg error for empty greeting");
      }
      return;
    }
    Object localObject = new UniteGrayTipParam(AppConstants.BABY_Q_UIN, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), paramString, 9002, -5040, 655362, MessageCache.a());
    MessageForUniteGrayTip localMessageForUniteGrayTip = new MessageForUniteGrayTip();
    localMessageForUniteGrayTip.initGrayTipMsg(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (UniteGrayTipParam)localObject);
    UniteGrayTipMsgUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localMessageForUniteGrayTip);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("BabyQ funcall addBabyQGreetingMsg success greeting =");
      ((StringBuilder)localObject).append(paramString);
      QLog.d("Q.BabyQ", 2, ((StringBuilder)localObject).toString());
    }
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
    if (this.jdField_b_of_type_AndroidContentSharedPreferences == null)
    {
      localObject = BaseApplicationImpl.getApplication();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      localStringBuilder.append("_");
      localStringBuilder.append("babyQ_pluspanel_config_sp_name");
      this.jdField_b_of_type_AndroidContentSharedPreferences = ((BaseApplicationImpl)localObject).getSharedPreferences(localStringBuilder.toString(), 0);
    }
    Object localObject = this.jdField_b_of_type_AndroidContentSharedPreferences.edit();
    ((SharedPreferences.Editor)localObject).clear();
    ((SharedPreferences.Editor)localObject).commit();
  }
  
  public Set<String> getCommandList()
  {
    if (this.allowCmdSet == null)
    {
      this.allowCmdSet = new HashSet();
      this.allowCmdSet.add("OidbSvc.0x77d_0");
      this.allowCmdSet.add("OidbSvc.0x8db_0");
    }
    return this.allowCmdSet;
  }
  
  protected Class<? extends BusinessObserver> observerClass()
  {
    return BabyQObserver.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ("OidbSvc.0x77d_0".equals(paramFromServiceMsg.getServiceCmd()))
    {
      a(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    if ("OidbSvc.0x8db_0".equals(paramFromServiceMsg.getServiceCmd())) {
      b(paramToServiceMsg, paramFromServiceMsg, paramObject);
    }
  }
  
  public void onResp(NetResp paramNetResp)
  {
    if (paramNetResp.mResult == 3)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.BabyQ", 2, "onResp is downloading...");
      }
      return;
    }
    Object localObject1 = paramNetResp.mReq.getUserData();
    if (localObject1 != null)
    {
      if (!(localObject1 instanceof BabyQHandler.BabyQUserData)) {
        return;
      }
      localObject1 = (BabyQHandler.BabyQUserData)localObject1;
      int i;
      if (paramNetResp.mResult == 0) {
        i = 1;
      } else {
        i = 0;
      }
      Object localObject2;
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("onResp|download ");
        if (i != 0) {
          paramNetResp = "success";
        } else {
          paramNetResp = "failed";
        }
        ((StringBuilder)localObject2).append(paramNetResp);
        QLog.d("Q.BabyQ", 2, ((StringBuilder)localObject2).toString());
      }
      if (i != 0)
      {
        localObject2 = new File(c);
        paramNetResp = PortalUtils.a(((File)localObject2).getAbsolutePath());
        if ((!TextUtils.isEmpty(paramNetResp)) && (!paramNetResp.equalsIgnoreCase(((BabyQHandler.BabyQUserData)localObject1).jdField_b_of_type_JavaLangString)))
        {
          if (QLog.isColorLevel())
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("onResp|Md5 error，fileMD5 = ");
            ((StringBuilder)localObject2).append(paramNetResp);
            ((StringBuilder)localObject2).append(", configMD5 = ");
            ((StringBuilder)localObject2).append(((BabyQHandler.BabyQUserData)localObject1).jdField_b_of_type_JavaLangString);
            QLog.d("Q.BabyQ", 2, ((StringBuilder)localObject2).toString());
            FileUtils.delete(d, false);
          }
        }
        else {
          notifyUI(5, a(((File)localObject2).getAbsolutePath(), d), null);
        }
      }
      else
      {
        a(((BabyQHandler.BabyQUserData)localObject1).jdField_a_of_type_JavaLangString, ((BabyQHandler.BabyQUserData)localObject1).jdField_b_of_type_JavaLangString, ((BabyQHandler.BabyQUserData)localObject1).jdField_a_of_type_Int);
      }
    }
  }
  
  public void onUpdateProgeress(NetReq paramNetReq, long paramLong1, long paramLong2)
  {
    if (QLog.isColorLevel())
    {
      paramNetReq = new StringBuilder();
      paramNetReq.append("onUpdateProgeress|curOffset : ");
      paramNetReq.append(paramLong1);
      paramNetReq.append(", totalLen : ");
      paramNetReq.append(paramLong2);
      QLog.d("Q.BabyQ", 2, paramNetReq.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.BabyQHandler
 * JD-Core Version:    0.7.0.1
 */