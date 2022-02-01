package com.tencent.mobileqq.activity.aio.tips;

import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.format.Time;
import android.view.LayoutInflater;
import android.view.View;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.contacts.friend.FriendsUtils;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.config.operation.QQOperateManager;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.servlet.ReduFriendServlet;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;
import java.util.HashMap;
import mqq.app.NewIntent;

public class FriendHotTipsBar
  implements TipsBarTask
{
  private static HashMap<String, Boolean> a = new HashMap();
  private static HashMap<String, Integer> b = new HashMap();
  private QQAppInterface c;
  private TipsManager d;
  private Activity e;
  private SessionInfo f;
  
  public static String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("voice_shown_hot_friend_tip_bar_");
    localStringBuilder.append(paramString);
    return localStringBuilder.toString();
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString)
  {
    String str = paramQQAppInterface.getCurrentAccountUin();
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(str);
    ((StringBuilder)localObject1).append("_");
    ((StringBuilder)localObject1).append(paramString);
    localObject1 = ((StringBuilder)localObject1).toString();
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("afterShowHotFriendTip() is called,mapKey is:");
      ((StringBuilder)localObject2).append((String)localObject1);
      QLog.d("ReduFriendServlet", 2, ((StringBuilder)localObject2).toString());
    }
    Object localObject3 = BaseApplication.getContext().getSharedPreferences("free_call", 0);
    Object localObject2 = a(str);
    boolean bool = ((SharedPreferences)localObject3).getBoolean((String)localObject2, false);
    if (bool)
    {
      if (QLog.isColorLevel())
      {
        paramQQAppInterface = new StringBuilder();
        paramQQAppInterface.append("shownHotFriendTip is:");
        paramQQAppInterface.append(bool);
        paramQQAppInterface.append(",not need to save value");
        QLog.d("ReduFriendServlet", 2, paramQQAppInterface.toString());
      }
    }
    else
    {
      localObject3 = ((SharedPreferences)localObject3).edit();
      ((SharedPreferences.Editor)localObject3).putBoolean((String)localObject2, true);
      long l = MessageCache.c();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("voice_hot_friend_tip_show_time");
      ((StringBuilder)localObject2).append(str);
      ((SharedPreferences.Editor)localObject3).putString(((StringBuilder)localObject2).toString(), String.valueOf(l * 1000L));
      ((SharedPreferences.Editor)localObject3).commit();
      a.put(localObject1, Boolean.TRUE);
      b(paramQQAppInterface, paramString);
      if (QLog.isColorLevel())
      {
        paramQQAppInterface = new StringBuilder();
        paramQQAppInterface.append("shownHotFriendTip is:");
        paramQQAppInterface.append(bool);
        paramQQAppInterface.append(",need to save value");
        QLog.d("ReduFriendServlet", 2, paramQQAppInterface.toString());
      }
    }
  }
  
  public static String[] a(QQAppInterface paramQQAppInterface, String paramString, long paramLong)
  {
    paramQQAppInterface = BaseApplication.getContext().getSharedPreferences("free_call", 0);
    long l = Long.parseLong(paramQQAppInterface.getString(b(paramString), "-1"));
    if (Math.abs(paramLong - l) >= 86400000L)
    {
      if (QLog.isColorLevel())
      {
        paramQQAppInterface = new StringBuilder();
        paramQQAppInterface.append("currTime is:");
        paramQQAppInterface.append(paramLong);
        paramQQAppInterface.append(",pullHotFriendTimeLong is:");
        paramQQAppInterface.append(l);
        paramQQAppInterface.append(",need to pull hot friend");
        QLog.d("ReduFriendServlet", 2, paramQQAppInterface.toString());
      }
      return null;
    }
    return paramQQAppInterface.getString(c(paramString), "").split("\\|");
  }
  
  public static String b(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("free_call_pull_hot_friend_time_");
    localStringBuilder.append(paramString);
    return localStringBuilder.toString();
  }
  
  public static void b(QQAppInterface paramQQAppInterface, String paramString)
  {
    paramQQAppInterface = paramQQAppInterface.getCurrentAccountUin();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramQQAppInterface);
    localStringBuilder.append("_");
    localStringBuilder.append(paramString);
    paramQQAppInterface = localStringBuilder.toString();
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder();
      paramString.append("incrementHotFriendEnterAIOTimes() is called,mapKey is:");
      paramString.append(paramQQAppInterface);
      QLog.d("ReduFriendServlet", 2, paramString.toString());
    }
    if (a.get(paramQQAppInterface) != null)
    {
      paramString = (Integer)b.get(paramQQAppInterface);
      if (paramString == null) {
        b.put(paramQQAppInterface, Integer.valueOf(1));
      } else {
        b.put(paramQQAppInterface, Integer.valueOf(paramString.intValue() + 1));
      }
      if (QLog.isColorLevel())
      {
        paramQQAppInterface = new StringBuilder();
        paramQQAppInterface.append("shownHotFriendTip flag exist,beforeTimes is:");
        paramQQAppInterface.append(paramString);
        QLog.d("ReduFriendServlet", 2, paramQQAppInterface.toString());
      }
    }
    else if (QLog.isColorLevel())
    {
      QLog.d("ReduFriendServlet", 2, "shownHotFriendTip flag does not exist,not increment time");
    }
  }
  
  public static String c(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("free_call_hot_friend_");
    localStringBuilder.append(paramString);
    return localStringBuilder.toString();
  }
  
  public static void c(QQAppInterface paramQQAppInterface, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReduFriendServlet", 2, "removeShownHotFriendTipFlag() is called");
    }
    paramQQAppInterface = paramQQAppInterface.getCurrentAccountUin();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramQQAppInterface);
    localStringBuilder.append("_");
    localStringBuilder.append(paramString);
    paramQQAppInterface = localStringBuilder.toString();
    a.remove(paramQQAppInterface);
  }
  
  public int a()
  {
    return 40;
  }
  
  public int a(QQAppInterface paramQQAppInterface, String paramString, boolean paramBoolean)
  {
    Object localObject2 = "";
    Object localObject3 = paramQQAppInterface.getCurrentAccountUin();
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append((String)localObject3);
    ((StringBuilder)localObject1).append("_");
    ((StringBuilder)localObject1).append(paramString);
    Object localObject4 = ((StringBuilder)localObject1).toString();
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("shouldShowHotFriendVoiceCallBar() ==> ,mapKey is:");
      ((StringBuilder)localObject1).append((String)localObject4);
      QLog.d("FriendHotTipsBar", 2, ((StringBuilder)localObject1).toString());
    }
    localObject1 = localObject2;
    try
    {
      if (a.get(localObject4) != null)
      {
        localObject1 = localObject2;
        localObject3 = (Integer)b.get(localObject4);
        if (localObject3 != null)
        {
          localObject1 = localObject2;
          if (((Integer)localObject3).intValue() > 3)
          {
            localObject1 = localObject2;
            c(paramQQAppInterface, paramString);
            localObject1 = localObject2;
            paramQQAppInterface = new StringBuilder();
            localObject1 = localObject2;
            paramQQAppInterface.append("find true flag from memory but enterAIOTimes is too large,enterAIOTimes is:");
            localObject1 = localObject2;
            paramQQAppInterface.append(localObject3);
            localObject1 = localObject2;
            paramQQAppInterface.append(",MAX_ENTER_TIMES is:");
            localObject1 = localObject2;
            paramQQAppInterface.append(3);
            localObject1 = localObject2;
            paramQQAppInterface = paramQQAppInterface.toString();
            if (QLog.isColorLevel())
            {
              paramString = new StringBuilder();
              paramString.append("shouldShowVoiceHotFriendTipBar() ==> step is:");
              paramString.append(paramQQAppInterface);
              QLog.d("FriendHotTipsBar", 2, paramString.toString());
            }
            return 2;
          }
        }
        localObject1 = localObject2;
        localObject3 = ((FriendsManager)paramQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).m(paramString);
        localObject1 = localObject2;
        i = FriendsUtils.a(((Friends)localObject3).eNetwork, ((Friends)localObject3).iTermType, ((Friends)localObject3).netTypeIconId);
        if (localObject3 != null)
        {
          localObject1 = localObject2;
          l = ((Friends)localObject3).abilityBits;
          if ((1L & l) != 0L)
          {
            if (i == 2)
            {
              if (QLog.isColorLevel())
              {
                paramQQAppInterface = new StringBuilder();
                paramQQAppInterface.append("shouldShowVoiceHotFriendTipBar() ==> step is:");
                paramQQAppInterface.append("");
                QLog.d("FriendHotTipsBar", 2, paramQQAppInterface.toString());
              }
              return 2;
            }
            if (QLog.isColorLevel())
            {
              paramQQAppInterface = new StringBuilder();
              paramQQAppInterface.append("shouldShowVoiceHotFriendTipBar() ==> step is:");
              paramQQAppInterface.append("find true flag from memory");
              QLog.d("FriendHotTipsBar", 2, paramQQAppInterface.toString());
            }
            return 1;
          }
        }
        localObject1 = localObject2;
        c(paramQQAppInterface, paramString);
        if (QLog.isColorLevel())
        {
          paramQQAppInterface = new StringBuilder();
          paramQQAppInterface.append("shouldShowVoiceHotFriendTipBar() ==> step is:");
          paramQQAppInterface.append("find true flag from memory but friend abilityBits does not contain support voice flag");
          QLog.d("FriendHotTipsBar", 2, paramQQAppInterface.toString());
        }
        return 2;
      }
      localObject1 = localObject2;
      localObject4 = BaseApplication.getContext().getSharedPreferences("free_call", 0);
      localObject1 = localObject2;
      if (((SharedPreferences)localObject4).getBoolean(a((String)localObject3), false))
      {
        if (QLog.isColorLevel())
        {
          paramQQAppInterface = new StringBuilder();
          paramQQAppInterface.append("shouldShowVoiceHotFriendTipBar() ==> step is:");
          paramQQAppInterface.append("has shown hot friend tip");
          QLog.d("FriendHotTipsBar", 2, paramQQAppInterface.toString());
        }
        return 2;
      }
      localObject1 = localObject2;
      Object localObject5 = new StringBuilder();
      localObject1 = localObject2;
      ((StringBuilder)localObject5).append("voice_remark_tip_show_time");
      localObject1 = localObject2;
      ((StringBuilder)localObject5).append((String)localObject3);
      localObject1 = localObject2;
      localObject5 = ((SharedPreferences)localObject4).getString(((StringBuilder)localObject5).toString(), "");
      localObject1 = localObject2;
      long l = MessageCache.c() * 1000L;
      localObject1 = localObject2;
      localObject4 = new Time();
      localObject1 = localObject2;
      if (QLog.isColorLevel())
      {
        localObject1 = localObject2;
        StringBuilder localStringBuilder = new StringBuilder();
        localObject1 = localObject2;
        localStringBuilder.append("multiRemarkTipShowTime is:");
        localObject1 = localObject2;
        localStringBuilder.append((String)localObject5);
        localObject1 = localObject2;
        localStringBuilder.append(",currTimeMillis is:");
        localObject1 = localObject2;
        localStringBuilder.append(l);
        localObject1 = localObject2;
        QLog.d("FriendHotTipsBar", 2, localStringBuilder.toString());
      }
      if (localObject5 != null)
      {
        localObject1 = localObject2;
        if (((String)localObject5).length() > 0)
        {
          localObject1 = localObject2;
          localObject5 = ((String)localObject5).split("\\|");
          localObject1 = localObject2;
          ((Time)localObject4).set(l);
          localObject1 = localObject2;
          i = ((Time)localObject4).year;
          localObject1 = localObject2;
          int j = ((Time)localObject4).month;
          localObject1 = localObject2;
          int k = ((Time)localObject4).monthDay;
          localObject1 = localObject2;
          ((Time)localObject4).set(Long.parseLong(localObject5[(localObject5.length - 1)]));
          localObject1 = localObject2;
          int m = ((Time)localObject4).year;
          localObject1 = localObject2;
          int n = ((Time)localObject4).month;
          localObject1 = localObject2;
          int i1 = ((Time)localObject4).monthDay;
          if ((i == m) && (j == n) && (k == i1))
          {
            if (QLog.isColorLevel())
            {
              paramQQAppInterface = new StringBuilder();
              paramQQAppInterface.append("shouldShowVoiceHotFriendTipBar() ==> step is:");
              paramQQAppInterface.append("has shown remark tip this day");
              QLog.d("FriendHotTipsBar", 2, paramQQAppInterface.toString());
            }
            return 2;
          }
        }
      }
      localObject1 = localObject2;
      if (!NetworkUtil.isWifiConnected(BaseApplication.getContext()))
      {
        localObject1 = localObject2;
        if (!NetworkUtil.is3Gor4G(BaseApplication.getContext()))
        {
          if (QLog.isColorLevel())
          {
            paramQQAppInterface = new StringBuilder();
            paramQQAppInterface.append("shouldShowVoiceHotFriendTipBar() ==> step is:");
            paramQQAppInterface.append("my network is not wifi or 3g or 4g");
            QLog.d("FriendHotTipsBar", 2, paramQQAppInterface.toString());
          }
          return 2;
        }
      }
      localObject1 = localObject2;
      localObject4 = a(paramQQAppInterface, (String)localObject3, MessageCache.c());
      if (localObject4 == null)
      {
        paramString = "there is no hot friend,need to pull";
        if (paramBoolean)
        {
          localObject1 = paramString;
          localObject2 = new NewIntent(paramQQAppInterface.getApp(), ReduFriendServlet.class);
          localObject1 = paramString;
          ((NewIntent)localObject2).putExtra("k_uin", (String)localObject3);
          localObject1 = paramString;
          paramQQAppInterface.startServlet((NewIntent)localObject2);
          if (QLog.isColorLevel())
          {
            paramQQAppInterface = new StringBuilder();
            paramQQAppInterface.append("shouldShowVoiceHotFriendTipBar() ==> step is:");
            paramQQAppInterface.append("there is no hot friend,need to pull");
            QLog.d("FriendHotTipsBar", 2, paramQQAppInterface.toString());
          }
          return 3;
        }
        if (QLog.isColorLevel())
        {
          paramQQAppInterface = new StringBuilder();
          paramQQAppInterface.append("shouldShowVoiceHotFriendTipBar() ==> step is:");
          paramQQAppInterface.append("there is no hot friend,need to pull");
          QLog.d("FriendHotTipsBar", 2, paramQQAppInterface.toString());
        }
        return 2;
      }
      localObject1 = localObject2;
      localObject3 = new HashMap();
      int i = 0;
      for (;;)
      {
        localObject1 = localObject2;
        if (i >= localObject4.length) {
          break;
        }
        localObject1 = localObject2;
        ((HashMap)localObject3).put(localObject4[i], localObject4[i]);
        i += 1;
      }
      localObject1 = localObject2;
      if (((HashMap)localObject3).get(paramString) != null)
      {
        localObject1 = localObject2;
        localObject3 = ((FriendsManager)paramQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).m(paramString);
        if (localObject3 == null)
        {
          localObject1 = localObject2;
          paramQQAppInterface = new StringBuilder();
          localObject1 = localObject2;
          paramQQAppInterface.append("can not find friend,friendUin is:");
          localObject1 = localObject2;
          paramQQAppInterface.append(paramString);
          localObject1 = localObject2;
          paramQQAppInterface = paramQQAppInterface.toString();
          if (QLog.isColorLevel())
          {
            paramString = new StringBuilder();
            paramString.append("shouldShowVoiceHotFriendTipBar() ==> step is:");
            paramString.append(paramQQAppInterface);
            QLog.d("FriendHotTipsBar", 2, paramString.toString());
          }
          return 2;
        }
        localObject1 = localObject2;
        if ((((Friends)localObject3).abilityBits & 1L) == 0L)
        {
          localObject1 = localObject2;
          paramQQAppInterface = new StringBuilder();
          localObject1 = localObject2;
          paramQQAppInterface.append("friend abilityBits does not contain support voice flag,f.abilityBits is:");
          localObject1 = localObject2;
          paramQQAppInterface.append(((Friends)localObject3).abilityBits);
          localObject1 = localObject2;
          paramQQAppInterface = paramQQAppInterface.toString();
          if (QLog.isColorLevel())
          {
            paramString = new StringBuilder();
            paramString.append("shouldShowVoiceHotFriendTipBar() ==> step is:");
            paramString.append(paramQQAppInterface);
            QLog.d("FriendHotTipsBar", 2, paramString.toString());
          }
          return 2;
        }
        localObject1 = localObject2;
        i = FriendsUtils.a(((Friends)localObject3).eNetwork, ((Friends)localObject3).iTermType, ((Friends)localObject3).netTypeIconId);
        if (i == 2)
        {
          if (QLog.isColorLevel())
          {
            paramQQAppInterface = new StringBuilder();
            paramQQAppInterface.append("shouldShowVoiceHotFriendTipBar() ==> step is:");
            paramQQAppInterface.append("");
            QLog.d("FriendHotTipsBar", 2, paramQQAppInterface.toString());
          }
          return 2;
        }
        try
        {
          ReportController.b(paramQQAppInterface, "CliOper", "", "", "Free_call", "Free_call_tips", 0, 0, "", "", "", "");
          if (QLog.isColorLevel())
          {
            paramQQAppInterface = new StringBuilder();
            paramQQAppInterface.append("shouldShowVoiceHotFriendTipBar() ==> step is:");
            paramQQAppInterface.append("can show hot friend voice call bar");
            QLog.d("FriendHotTipsBar", 2, paramQQAppInterface.toString());
          }
          return 1;
        }
        finally
        {
          localObject1 = "can show hot friend voice call bar";
          break label1658;
        }
      }
      localObject1 = localObject2;
      paramQQAppInterface = new StringBuilder();
      localObject1 = localObject2;
      paramQQAppInterface.append("friend does not exist in hot friend,friendUin is:");
      localObject1 = localObject2;
      paramQQAppInterface.append(paramString);
      localObject1 = localObject2;
      paramQQAppInterface.append(",hotFriend is:");
      localObject1 = localObject2;
      paramQQAppInterface.append(Arrays.toString((Object[])localObject4));
      localObject1 = localObject2;
      paramQQAppInterface = paramQQAppInterface.toString();
      if (QLog.isColorLevel())
      {
        paramString = new StringBuilder();
        paramString.append("shouldShowVoiceHotFriendTipBar() ==> step is:");
        paramString.append(paramQQAppInterface);
        QLog.d("FriendHotTipsBar", 2, paramString.toString());
        return 2;
      }
      return 2;
    }
    finally
    {
      label1658:
      if (QLog.isColorLevel())
      {
        paramString = new StringBuilder();
        paramString.append("shouldShowVoiceHotFriendTipBar() ==> step is:");
        paramString.append((String)localObject1);
        QLog.d("FriendHotTipsBar", 2, paramString.toString());
      }
    }
    for (;;)
    {
      throw paramQQAppInterface;
    }
  }
  
  public View a(Object... paramVarArgs)
  {
    paramVarArgs = LayoutInflater.from(this.e).inflate(2131627287, null);
    paramVarArgs.findViewById(2131442215).setOnClickListener(new FriendHotTipsBar.1(this));
    return paramVarArgs;
  }
  
  public void a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt != 1000) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("FriendHotTipsBar", 2, "onAIOEvent() : TYPE_ON_SHOW =====>");
    }
    d();
  }
  
  public int b()
  {
    return 5;
  }
  
  public int[] c()
  {
    return new int[] { 2000 };
  }
  
  public void d()
  {
    if (this.f.a != 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("FriendHotTipsBar", 2, "curType != Friend");
      }
      return;
    }
    QQOperateManager localQQOperateManager = QQOperateManager.a(this.c);
    if (localQQOperateManager.b(this.f.a, 1))
    {
      if (QLog.isColorLevel()) {
        QLog.d("FriendHotTipsBar", 2, "hasNetTipShow today");
      }
      return;
    }
    if ((a(this.c, this.f.b, true) == 1) && (this.d.a(this, new Object[0])))
    {
      a(this.c, this.f.b);
      localQQOperateManager.a(this.c, this.f.a, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.tips.FriendHotTipsBar
 * JD-Core Version:    0.7.0.1
 */