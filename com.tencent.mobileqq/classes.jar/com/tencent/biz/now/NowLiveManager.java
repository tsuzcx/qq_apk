package com.tencent.biz.now;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.QQStoryManager;
import com.tencent.biz.qqstory.storyHome.qqstorylist.model.QQStoryNetReqUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.leba.ILebaHelperService;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.tianshu.api.IRedTouchManager;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.AppSetting;
import com.tencent.mobileqq.troop.utils.HttpWebCgiAsyncTask;
import com.tencent.mobileqq.troop.utils.HttpWebCgiAsyncTask.Callback;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import mqq.app.MobileQQ;
import mqq.manager.Manager;

public class NowLiveManager
  extends Observable
  implements Manager
{
  public static final int a;
  public static boolean c;
  public char a;
  SharedPreferences jdField_a_of_type_AndroidContentSharedPreferences = null;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  protected HttpWebCgiAsyncTask.Callback a;
  public String a;
  HashMap<String, NowLiveManager.NowLiveInfo> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  Map<String, Long> jdField_a_of_type_JavaUtilMap = new HashMap();
  public boolean a;
  public int b;
  private String b;
  public boolean b;
  public int c;
  
  static
  {
    int i;
    if (QQStoryNetReqUtils.a()) {
      i = 3050;
    } else {
      i = 6282;
    }
    jdField_a_of_type_Int = i;
    jdField_c_of_type_Boolean = false;
  }
  
  public NowLiveManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_b_of_type_Int = -1;
    this.jdField_c_of_type_Int = -100;
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_Char = '0';
    this.jdField_b_of_type_JavaLangString = null;
    this.jdField_a_of_type_ComTencentMobileqqTroopUtilsHttpWebCgiAsyncTask$Callback = new NowLiveManager.1(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    MobileQQ localMobileQQ = paramQQAppInterface.getApplication();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("now_msg_sp");
    localStringBuilder.append(paramQQAppInterface.getCurrentAccountUin());
    this.jdField_a_of_type_AndroidContentSharedPreferences = localMobileQQ.getSharedPreferences(localStringBuilder.toString(), 0);
    a();
  }
  
  private void c() {}
  
  public NowLiveManager.NowLiveInfo a(String paramString, long paramLong)
  {
    Object localObject1 = this.jdField_a_of_type_JavaUtilHashMap;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(paramString);
    ((StringBuilder)localObject2).append(paramLong);
    localObject2 = (NowLiveManager.NowLiveInfo)((HashMap)localObject1).get(((StringBuilder)localObject2).toString());
    localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = new NowLiveManager.NowLiveInfo(this);
      ((NowLiveManager.NowLiveInfo)localObject1).jdField_a_of_type_JavaLangString = paramString;
      ((NowLiveManager.NowLiveInfo)localObject1).jdField_a_of_type_Long = paramLong;
      this.jdField_a_of_type_JavaUtilHashMap.put(((NowLiveManager.NowLiveInfo)localObject1).a(), localObject1);
    }
    return localObject1;
  }
  
  public String a()
  {
    if (this.jdField_b_of_type_JavaLangString == null)
    {
      SharedPreferences localSharedPreferences = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("now_tab_sp", 0);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("now_show_key");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      this.jdField_b_of_type_JavaLangString = localSharedPreferences.getString(localStringBuilder.toString(), "00100");
    }
    return this.jdField_b_of_type_JavaLangString;
  }
  
  public void a()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp();
    boolean bool = false;
    this.jdField_b_of_type_Boolean = ((BaseApplication)localObject).getSharedPreferences("now_tab_sp", 0).getBoolean("now_is_first_run_key", true);
    this.jdField_c_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("now_tab_sp", 0).getInt("now_index_key", 3);
    this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("now_tab_sp", 0).getString("now_name_key", "");
    if (this.jdField_b_of_type_Int != -1) {
      return;
    }
    String str = a();
    if (str != null) {
      this.jdField_a_of_type_Char = str.charAt(2);
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("initNowTabShowValue : ");
      ((StringBuilder)localObject).append(str);
      QLog.i("Q.qqstory.fourTab", 4, ((StringBuilder)localObject).toString());
    }
    if ((str != null) && (str.length() <= 5))
    {
      localObject = str;
      if (str.length() < 5)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(str);
        ((StringBuilder)localObject).append("00100".substring(str.length()));
        localObject = ((StringBuilder)localObject).toString();
      }
      localObject = ((String)localObject).toCharArray();
      char c1 = localObject[2];
      int i;
      if (localObject[0] == '1')
      {
        if ((localObject[3] != '0') && (c1 != '0') && (c1 != '1')) {
          i = 1;
        } else {
          i = 0;
        }
        this.jdField_b_of_type_Int = i;
      }
      else
      {
        if ((localObject[1] != '0') && (c1 != '0') && (c1 != '1')) {
          i = 1;
        } else {
          i = 0;
        }
        this.jdField_b_of_type_Int = i;
      }
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("uin:");
        ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
        ((StringBuilder)localObject).append(",isNowTabShow mIsNowTabShow=");
        ((StringBuilder)localObject).append(this.jdField_b_of_type_Int);
        ((StringBuilder)localObject).append(" plan=");
        ((StringBuilder)localObject).append(c1);
        QLog.i("Q.qqstory.fourTab", 2, ((StringBuilder)localObject).toString());
      }
      if (this.jdField_b_of_type_Int != 0) {
        bool = true;
      }
      this.jdField_a_of_type_Boolean = bool;
      if (this.jdField_a_of_type_Boolean)
      {
        b();
        if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isCallTabShow) {
          c();
        }
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.e("Q.qqstory.fourTab", 2, "isNowTabShow fullVal is null");
    }
  }
  
  public void a(MessageForStructing paramMessageForStructing)
  {
    if (this.jdField_a_of_type_JavaUtilMap.containsKey(paramMessageForStructing.frienduin))
    {
      long l = ((Long)this.jdField_a_of_type_JavaUtilMap.get(paramMessageForStructing.frienduin)).longValue();
      if (paramMessageForStructing.time > l)
      {
        this.jdField_a_of_type_JavaUtilMap.put(paramMessageForStructing.frienduin, Long.valueOf(paramMessageForStructing.time));
        localEditor = this.jdField_a_of_type_AndroidContentSharedPreferences.edit();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("time");
        localStringBuilder.append(paramMessageForStructing.frienduin);
        localEditor.putLong(localStringBuilder.toString(), paramMessageForStructing.time).commit();
      }
    }
    else
    {
      this.jdField_a_of_type_JavaUtilMap.put(paramMessageForStructing.frienduin, Long.valueOf(paramMessageForStructing.time));
      localEditor = this.jdField_a_of_type_AndroidContentSharedPreferences.edit();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("time");
      localStringBuilder.append(paramMessageForStructing.frienduin);
      localEditor.putLong(localStringBuilder.toString(), paramMessageForStructing.time).commit();
    }
    SharedPreferences.Editor localEditor = this.jdField_a_of_type_AndroidContentSharedPreferences.edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("uid");
    localStringBuilder.append(paramMessageForStructing.frienduin);
    localEditor.putLong(localStringBuilder.toString(), paramMessageForStructing.msgUid).commit();
  }
  
  public void a(String paramString1, String paramString2, long paramLong)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("room_id", paramString2);
    localBundle.putLong("time", paramLong);
    localBundle.putString("friendUin", paramString1);
    paramString1 = a(paramString1, paramLong);
    if ((paramString1.jdField_a_of_type_Int != 1) && (paramString1.jdField_a_of_type_Int != 2))
    {
      if (paramString1.jdField_a_of_type_JavaUtilList.size() != 0)
      {
        setChanged();
        notifyObservers(new Object[] { Integer.valueOf(1001), Boolean.valueOf(true), paramString1, localBundle });
        return;
      }
      paramString1 = new Bundle();
      paramString1.putString("is_sub_room", "0");
      paramString1.putString("playtype", "4");
      paramString1.putString("platform", "3");
      paramString1.putString("room_id", paramString2);
      paramString2 = new HashMap();
      paramString2.put("BUNDLE", paramString1);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication();
      paramString2.put("CONTEXT", MobileQQ.getContext());
      new HttpWebCgiAsyncTask("https://now.qq.com/cgi-bin/now/web/room/get_live_room_url", "GET", this.jdField_a_of_type_ComTencentMobileqqTroopUtilsHttpWebCgiAsyncTask$Callback, 1001, localBundle, true).execute(new HashMap[] { paramString2 });
      return;
    }
    setChanged();
    notifyObservers(new Object[] { Integer.valueOf(1001), Boolean.valueOf(true), paramString1, localBundle });
  }
  
  public void a(String paramString1, String paramString2, String paramString3, long paramLong, boolean paramBoolean)
  {
    if ((!TextUtils.isEmpty(paramString2)) && (!TextUtils.isEmpty(paramString3)) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null))
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("room_id", paramString2);
      localBundle.putLong("time", paramLong);
      localBundle.putString("vid", paramString3);
      localBundle.putString("friendUin", paramString1);
      localBundle.putBoolean("needReqUrl", paramBoolean);
      paramString1 = a(paramString1, paramLong);
      if ((paramString1.jdField_a_of_type_Int != 1) && (paramString1.jdField_a_of_type_Int != 2))
      {
        paramString1 = new Bundle();
        paramString1.putString("room_id", paramString2);
        paramString1.putString("vid", paramString3);
        paramString2 = new HashMap();
        paramString2.put("BUNDLE", paramString1);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication();
        paramString2.put("CONTEXT", MobileQQ.getContext());
        new HttpWebCgiAsyncTask("https://now.qq.com/cgi-bin/now/web/room/check_live_stat", "GET", this.jdField_a_of_type_ComTencentMobileqqTroopUtilsHttpWebCgiAsyncTask$Callback, 1003, localBundle, true).execute(new HashMap[] { paramString2 });
        return;
      }
      setChanged();
      notifyObservers(new Object[] { Integer.valueOf(1003), Boolean.valueOf(true), paramString1, localBundle });
      return;
    }
    if (QLog.isColorLevel())
    {
      paramString1 = new StringBuilder();
      paramString1.append("getLiveState: roomId = ");
      paramString1.append(paramString2);
      paramString1.append(" vid = ");
      paramString1.append(paramString3);
      paramString1.append(" shMsgSeq = ");
      paramString1.append(paramLong);
      QLog.d("NowLiveManager", 2, paramString1.toString());
    }
  }
  
  public void a(Integer[] paramArrayOfInteger)
  {
    a(paramArrayOfInteger, true);
  }
  
  public void a(Integer[] paramArrayOfInteger, boolean paramBoolean)
  {
    Object localObject2 = a();
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("writeNowTabStateVal fullVal=");
      ((StringBuilder)localObject1).append((String)localObject2);
      ((StringBuilder)localObject1).append(" vals:");
      ((StringBuilder)localObject1).append(Arrays.toString(paramArrayOfInteger));
      ((StringBuilder)localObject1).append("     mNowTabShowState=");
      ((StringBuilder)localObject1).append(this.jdField_b_of_type_Int);
      QLog.i("Q.qqstory.fourTab", 2, ((StringBuilder)localObject1).toString());
    }
    if ((localObject2 != null) && (((String)localObject2).length() <= 5) && (paramArrayOfInteger != null) && (paramArrayOfInteger.length == 5))
    {
      localObject1 = localObject2;
      if (((String)localObject2).length() < 5)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append((String)localObject2);
        ((StringBuilder)localObject1).append("00100".substring(((String)localObject2).length()));
        localObject1 = ((StringBuilder)localObject1).toString();
      }
      localObject1 = new StringBuilder((String)localObject1);
      int i = 0;
      while (i < paramArrayOfInteger.length)
      {
        localObject2 = paramArrayOfInteger[i];
        if (localObject2 != null)
        {
          if ((((Integer)localObject2).intValue() >= 0) && (((Integer)localObject2).intValue() <= 9)) {
            ((StringBuilder)localObject1).setCharAt(i, (char)(((Integer)localObject2).intValue() + 48));
          }
        }
        else
        {
          i += 1;
          continue;
        }
        if (QLog.isColorLevel())
        {
          paramArrayOfInteger = new StringBuilder();
          paramArrayOfInteger.append("writeNowTabStateVal wrong index,,");
          paramArrayOfInteger.append(localObject2);
          QLog.e("Q.qqstory.fourTab", 2, paramArrayOfInteger.toString());
        }
        return;
      }
      char c1 = ((StringBuilder)localObject1).charAt(2);
      if ('1' == ((StringBuilder)localObject1).charAt(0))
      {
        if ((((StringBuilder)localObject1).charAt(3) != '0') && (c1 != '0') && (c1 != '1')) {
          i = 1;
        } else {
          i = 0;
        }
        this.jdField_b_of_type_Int = i;
        if (this.jdField_b_of_type_Int == 0) {
          bool = false;
        } else {
          bool = true;
        }
        this.jdField_a_of_type_Boolean = bool;
        b();
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("userChange mNowTabShowState=");
          ((StringBuilder)localObject2).append(this.jdField_b_of_type_Int);
          ((StringBuilder)localObject2).append(" result:");
          ((StringBuilder)localObject2).append(localObject1);
          ((StringBuilder)localObject2).append("  plan=");
          ((StringBuilder)localObject2).append(c1);
          QLog.i("Q.qqstory.fourTab", 2, ((StringBuilder)localObject2).toString());
        }
      }
      else
      {
        if ((((StringBuilder)localObject1).charAt(1) != '0') && (c1 != '0') && (c1 != '1')) {
          i = 1;
        } else {
          i = 0;
        }
        this.jdField_b_of_type_Int = i;
        if (this.jdField_b_of_type_Int == 0) {
          bool = false;
        } else {
          bool = true;
        }
        this.jdField_a_of_type_Boolean = bool;
        if (this.jdField_a_of_type_Boolean) {
          b();
        }
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("userNoChange mNowTabShowState=");
          ((StringBuilder)localObject2).append(this.jdField_b_of_type_Int);
          ((StringBuilder)localObject2).append(" result:");
          ((StringBuilder)localObject2).append(localObject1);
          ((StringBuilder)localObject2).append("  plan=");
          ((StringBuilder)localObject2).append(c1);
          QLog.i("Q.qqstory.fourTab", 2, ((StringBuilder)localObject2).toString());
        }
      }
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("uin:");
        ((StringBuilder)localObject2).append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
        ((StringBuilder)localObject2).append(",writeNowTabStateVal vals=");
        ((StringBuilder)localObject2).append(Arrays.toString(paramArrayOfInteger));
        ((StringBuilder)localObject2).append(",mIsNowTabShow=");
        ((StringBuilder)localObject2).append(this.jdField_b_of_type_Int);
        ((StringBuilder)localObject2).append(",isNowTabShow=");
        ((StringBuilder)localObject2).append(this.jdField_a_of_type_Boolean);
        QLog.i("Q.qqstory.fourTab", 2, ((StringBuilder)localObject2).toString());
      }
      localObject1 = ((StringBuilder)localObject1).toString();
      this.jdField_b_of_type_JavaLangString = ((String)localObject1);
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("now_tab_sp", 0).edit();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("now_show_key");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      ((SharedPreferences.Editor)localObject2).putString(localStringBuilder.toString(), (String)localObject1).apply();
      boolean bool = this.jdField_a_of_type_Boolean;
      localObject1 = SettingCloneUtil.readValue(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), null, "qqsetting_calltab_show_key", "0111100");
      if ((paramBoolean) && (paramArrayOfInteger[0] != null) && (1 == paramArrayOfInteger[0].intValue()) && (((String)localObject1).charAt(0) == '0'))
      {
        paramArrayOfInteger = new Integer[7];
        paramArrayOfInteger[0] = Integer.valueOf(1);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.writeCallTabStateVal(paramArrayOfInteger, false);
      }
      return;
    }
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("writeNowTabStateVal valid val,");
      ((StringBuilder)localObject1).append((String)localObject2);
      ((StringBuilder)localObject1).append(",");
      ((StringBuilder)localObject1).append(paramArrayOfInteger);
      QLog.e("Q.qqstory.fourTab", 2, ((StringBuilder)localObject1).toString());
    }
  }
  
  public boolean a()
  {
    boolean bool3 = QQStoryManager.i();
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (bool3)
    {
      int j = a().charAt(2);
      int i;
      if ((jdField_c_of_type_Boolean) && (this.jdField_a_of_type_Boolean)) {
        i = 1;
      } else {
        i = 0;
      }
      bool1 = bool2;
      if (j != 48)
      {
        bool1 = bool2;
        if (i == 0) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public boolean a(String paramString, long paramLong)
  {
    if (this.jdField_a_of_type_JavaUtilMap.containsKey(paramString)) {
      return paramLong >= ((Long)this.jdField_a_of_type_JavaUtilMap.get(paramString)).longValue();
    }
    SharedPreferences localSharedPreferences = this.jdField_a_of_type_AndroidContentSharedPreferences;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("time");
    localStringBuilder.append(paramString);
    long l = localSharedPreferences.getLong(localStringBuilder.toString(), 0L);
    this.jdField_a_of_type_JavaUtilMap.put(paramString, Long.valueOf(l));
    return paramLong >= l;
  }
  
  public void b()
  {
    ILebaHelperService localILebaHelperService = (ILebaHelperService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(ILebaHelperService.class, "");
    if (localILebaHelperService != null)
    {
      localILebaHelperService.setFlagUpdateOnPause();
      return;
    }
    QLog.d("NowLiveManager", 1, "setFlagUpdateOnPause lebaHelperService == null");
  }
  
  public boolean b()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    boolean bool1 = false;
    if (localObject == null) {
      return false;
    }
    if (a())
    {
      localObject = ((IRedTouchManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IRedTouchManager.class, "")).requestSettingInfoList();
      boolean bool2 = true;
      localObject = ((List)localObject).iterator();
      BusinessInfoCheckUpdate.AppSetting localAppSetting;
      do
      {
        bool1 = bool2;
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        localAppSetting = (BusinessInfoCheckUpdate.AppSetting)((Iterator)localObject).next();
      } while (localAppSetting.appid.get() != jdField_a_of_type_Int);
      bool1 = localAppSetting.setting.get();
    }
    return bool1;
  }
  
  public void onDestroy()
  {
    deleteObservers();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.now.NowLiveManager
 * JD-Core Version:    0.7.0.1
 */