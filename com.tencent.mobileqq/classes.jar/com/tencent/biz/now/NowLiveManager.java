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
  public static boolean j = false;
  QQAppInterface b;
  SharedPreferences c = null;
  public boolean d;
  public int e = -1;
  public int f = -100;
  public String g = "";
  public boolean h = true;
  public char i = '0';
  protected HttpWebCgiAsyncTask.Callback k = new NowLiveManager.1(this);
  Map<String, Long> l = new HashMap();
  HashMap<String, NowLiveManager.NowLiveInfo> m = new HashMap();
  private String n = null;
  
  static
  {
    int i1;
    if (QQStoryNetReqUtils.a()) {
      i1 = 3050;
    } else {
      i1 = 6282;
    }
    a = i1;
  }
  
  public NowLiveManager(QQAppInterface paramQQAppInterface)
  {
    this.b = paramQQAppInterface;
    MobileQQ localMobileQQ = paramQQAppInterface.getApplication();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("now_msg_sp");
    localStringBuilder.append(paramQQAppInterface.getCurrentAccountUin());
    this.c = localMobileQQ.getSharedPreferences(localStringBuilder.toString(), 0);
    c();
  }
  
  private void f() {}
  
  public void a(MessageForStructing paramMessageForStructing)
  {
    if (this.l.containsKey(paramMessageForStructing.frienduin))
    {
      long l1 = ((Long)this.l.get(paramMessageForStructing.frienduin)).longValue();
      if (paramMessageForStructing.time > l1)
      {
        this.l.put(paramMessageForStructing.frienduin, Long.valueOf(paramMessageForStructing.time));
        localEditor = this.c.edit();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("time");
        localStringBuilder.append(paramMessageForStructing.frienduin);
        localEditor.putLong(localStringBuilder.toString(), paramMessageForStructing.time).commit();
      }
    }
    else
    {
      this.l.put(paramMessageForStructing.frienduin, Long.valueOf(paramMessageForStructing.time));
      localEditor = this.c.edit();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("time");
      localStringBuilder.append(paramMessageForStructing.frienduin);
      localEditor.putLong(localStringBuilder.toString(), paramMessageForStructing.time).commit();
    }
    SharedPreferences.Editor localEditor = this.c.edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("uid");
    localStringBuilder.append(paramMessageForStructing.frienduin);
    localEditor.putLong(localStringBuilder.toString(), paramMessageForStructing.msgUid).commit();
  }
  
  public void a(String paramString1, String paramString2, long paramLong)
  {
    if (this.b == null) {
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("room_id", paramString2);
    localBundle.putLong("time", paramLong);
    localBundle.putString("friendUin", paramString1);
    paramString1 = b(paramString1, paramLong);
    if ((paramString1.d != 1) && (paramString1.d != 2))
    {
      if (paramString1.e.size() != 0)
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
      this.b.getApplication();
      paramString2.put("CONTEXT", MobileQQ.getContext());
      new HttpWebCgiAsyncTask("https://now.qq.com/cgi-bin/now/web/room/get_live_room_url", "GET", this.k, 1001, localBundle, true).execute(new HashMap[] { paramString2 });
      return;
    }
    setChanged();
    notifyObservers(new Object[] { Integer.valueOf(1001), Boolean.valueOf(true), paramString1, localBundle });
  }
  
  public void a(String paramString1, String paramString2, String paramString3, long paramLong, boolean paramBoolean)
  {
    if ((!TextUtils.isEmpty(paramString2)) && (!TextUtils.isEmpty(paramString3)) && (this.b != null))
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("room_id", paramString2);
      localBundle.putLong("time", paramLong);
      localBundle.putString("vid", paramString3);
      localBundle.putString("friendUin", paramString1);
      localBundle.putBoolean("needReqUrl", paramBoolean);
      paramString1 = b(paramString1, paramLong);
      if ((paramString1.d != 1) && (paramString1.d != 2))
      {
        paramString1 = new Bundle();
        paramString1.putString("room_id", paramString2);
        paramString1.putString("vid", paramString3);
        paramString2 = new HashMap();
        paramString2.put("BUNDLE", paramString1);
        this.b.getApplication();
        paramString2.put("CONTEXT", MobileQQ.getContext());
        new HttpWebCgiAsyncTask("https://now.qq.com/cgi-bin/now/web/room/check_live_stat", "GET", this.k, 1003, localBundle, true).execute(new HashMap[] { paramString2 });
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
    Object localObject2 = d();
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("writeNowTabStateVal fullVal=");
      ((StringBuilder)localObject1).append((String)localObject2);
      ((StringBuilder)localObject1).append(" vals:");
      ((StringBuilder)localObject1).append(Arrays.toString(paramArrayOfInteger));
      ((StringBuilder)localObject1).append("     mNowTabShowState=");
      ((StringBuilder)localObject1).append(this.e);
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
      int i1 = 0;
      while (i1 < paramArrayOfInteger.length)
      {
        localObject2 = paramArrayOfInteger[i1];
        if (localObject2 != null)
        {
          if ((((Integer)localObject2).intValue() >= 0) && (((Integer)localObject2).intValue() <= 9)) {
            ((StringBuilder)localObject1).setCharAt(i1, (char)(((Integer)localObject2).intValue() + 48));
          }
        }
        else
        {
          i1 += 1;
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
          i1 = 1;
        } else {
          i1 = 0;
        }
        this.e = i1;
        if (this.e == 0) {
          bool = false;
        } else {
          bool = true;
        }
        this.d = bool;
        e();
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("userChange mNowTabShowState=");
          ((StringBuilder)localObject2).append(this.e);
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
          i1 = 1;
        } else {
          i1 = 0;
        }
        this.e = i1;
        if (this.e == 0) {
          bool = false;
        } else {
          bool = true;
        }
        this.d = bool;
        if (this.d) {
          e();
        }
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("userNoChange mNowTabShowState=");
          ((StringBuilder)localObject2).append(this.e);
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
        ((StringBuilder)localObject2).append(this.b.getCurrentAccountUin());
        ((StringBuilder)localObject2).append(",writeNowTabStateVal vals=");
        ((StringBuilder)localObject2).append(Arrays.toString(paramArrayOfInteger));
        ((StringBuilder)localObject2).append(",mIsNowTabShow=");
        ((StringBuilder)localObject2).append(this.e);
        ((StringBuilder)localObject2).append(",isNowTabShow=");
        ((StringBuilder)localObject2).append(this.d);
        QLog.i("Q.qqstory.fourTab", 2, ((StringBuilder)localObject2).toString());
      }
      localObject1 = ((StringBuilder)localObject1).toString();
      this.n = ((String)localObject1);
      localObject2 = this.b.getApp().getSharedPreferences("now_tab_sp", 0).edit();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("now_show_key");
      localStringBuilder.append(this.b.getCurrentAccountUin());
      ((SharedPreferences.Editor)localObject2).putString(localStringBuilder.toString(), (String)localObject1).apply();
      boolean bool = this.d;
      localObject1 = SettingCloneUtil.readValue(this.b.getApplication(), this.b.getCurrentAccountUin(), null, "qqsetting_calltab_show_key", "0111100");
      if ((paramBoolean) && (paramArrayOfInteger[0] != null) && (1 == paramArrayOfInteger[0].intValue()) && (((String)localObject1).charAt(0) == '0'))
      {
        paramArrayOfInteger = new Integer[7];
        paramArrayOfInteger[0] = Integer.valueOf(1);
        this.b.writeCallTabStateVal(paramArrayOfInteger, false);
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
    boolean bool3 = QQStoryManager.o();
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (bool3)
    {
      int i2 = d().charAt(2);
      int i1;
      if ((j) && (this.d)) {
        i1 = 1;
      } else {
        i1 = 0;
      }
      bool1 = bool2;
      if (i2 != 48)
      {
        bool1 = bool2;
        if (i1 == 0) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public boolean a(String paramString, long paramLong)
  {
    if (this.l.containsKey(paramString)) {
      return paramLong >= ((Long)this.l.get(paramString)).longValue();
    }
    SharedPreferences localSharedPreferences = this.c;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("time");
    localStringBuilder.append(paramString);
    long l1 = localSharedPreferences.getLong(localStringBuilder.toString(), 0L);
    this.l.put(paramString, Long.valueOf(l1));
    return paramLong >= l1;
  }
  
  public NowLiveManager.NowLiveInfo b(String paramString, long paramLong)
  {
    Object localObject1 = this.m;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(paramString);
    ((StringBuilder)localObject2).append(paramLong);
    localObject2 = (NowLiveManager.NowLiveInfo)((HashMap)localObject1).get(((StringBuilder)localObject2).toString());
    localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = new NowLiveManager.NowLiveInfo(this);
      ((NowLiveManager.NowLiveInfo)localObject1).a = paramString;
      ((NowLiveManager.NowLiveInfo)localObject1).b = paramLong;
      this.m.put(((NowLiveManager.NowLiveInfo)localObject1).a(), localObject1);
    }
    return localObject1;
  }
  
  public boolean b()
  {
    Object localObject = this.b;
    boolean bool1 = false;
    if (localObject == null) {
      return false;
    }
    if (a())
    {
      localObject = ((IRedTouchManager)this.b.getRuntimeService(IRedTouchManager.class, "")).requestSettingInfoList();
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
      } while (localAppSetting.appid.get() != a);
      bool1 = localAppSetting.setting.get();
    }
    return bool1;
  }
  
  public void c()
  {
    Object localObject = this.b.getApp();
    boolean bool = false;
    this.h = ((BaseApplication)localObject).getSharedPreferences("now_tab_sp", 0).getBoolean("now_is_first_run_key", true);
    this.f = this.b.getApp().getSharedPreferences("now_tab_sp", 0).getInt("now_index_key", 3);
    this.g = this.b.getApp().getSharedPreferences("now_tab_sp", 0).getString("now_name_key", "");
    if (this.e != -1) {
      return;
    }
    String str = d();
    if (str != null) {
      this.i = str.charAt(2);
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
      int i1;
      if (localObject[0] == '1')
      {
        if ((localObject[3] != '0') && (c1 != '0') && (c1 != '1')) {
          i1 = 1;
        } else {
          i1 = 0;
        }
        this.e = i1;
      }
      else
      {
        if ((localObject[1] != '0') && (c1 != '0') && (c1 != '1')) {
          i1 = 1;
        } else {
          i1 = 0;
        }
        this.e = i1;
      }
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("uin:");
        ((StringBuilder)localObject).append(this.b.getCurrentAccountUin());
        ((StringBuilder)localObject).append(",isNowTabShow mIsNowTabShow=");
        ((StringBuilder)localObject).append(this.e);
        ((StringBuilder)localObject).append(" plan=");
        ((StringBuilder)localObject).append(c1);
        QLog.i("Q.qqstory.fourTab", 2, ((StringBuilder)localObject).toString());
      }
      if (this.e != 0) {
        bool = true;
      }
      this.d = bool;
      if (this.d)
      {
        e();
        if (this.b.isCallTabShow) {
          f();
        }
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.e("Q.qqstory.fourTab", 2, "isNowTabShow fullVal is null");
    }
  }
  
  public String d()
  {
    if (this.n == null)
    {
      SharedPreferences localSharedPreferences = this.b.getApp().getSharedPreferences("now_tab_sp", 0);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("now_show_key");
      localStringBuilder.append(this.b.getCurrentAccountUin());
      this.n = localSharedPreferences.getString(localStringBuilder.toString(), "00100");
    }
    return this.n;
  }
  
  public void e()
  {
    ILebaHelperService localILebaHelperService = (ILebaHelperService)this.b.getRuntimeService(ILebaHelperService.class, "");
    if (localILebaHelperService != null)
    {
      localILebaHelperService.setFlagUpdateOnPause();
      return;
    }
    QLog.d("NowLiveManager", 1, "setFlagUpdateOnPause lebaHelperService == null");
  }
  
  public void onDestroy()
  {
    deleteObservers();
    this.b = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.now.NowLiveManager
 * JD-Core Version:    0.7.0.1
 */