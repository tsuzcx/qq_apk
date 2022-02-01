package com.tencent.mobileqq.activity.aio.core;

import android.content.Intent;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.biz.eqq.CrmUtils;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.core.chatpiecreator.ChatPieCreatorFactory;
import com.tencent.mobileqq.activity.aio.core.chatpiecreator.IChatPieCreator;
import com.tencent.mobileqq.activity.aio.core.chatpiecreator.PutOrderCache;
import com.tencent.mobileqq.activity.aio.rebuild.chatpiecreator.ChatPieSubTypeCreatorFactory;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.filemanager.util.QFileUtils;
import com.tencent.mobileqq.troop.utils.RobotUtils;
import com.tencent.qidian.QidianManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.MqqWeakReferenceHandler;
import java.util.Collection;
import java.util.Iterator;
import mqq.os.MqqHandler;
import org.jetbrains.annotations.Nullable;

public class ChatPieCache
  implements Handler.Callback
{
  protected final PutOrderCache<Class<? extends BaseChatPie>, BaseChatPie> a = new PutOrderCache();
  protected final MqqHandler b = new MqqWeakReferenceHandler(Looper.getMainLooper(), this, true);
  private BaseActivity c;
  private BaseChatPie d;
  
  public ChatPieCache()
  {
    this.a.setCapacity(2);
  }
  
  private BaseChatPie a(BaseChatPie paramBaseChatPie)
  {
    BaseChatPie localBaseChatPie = (BaseChatPie)this.a.putAndGetRemoved(paramBaseChatPie.getClass(), paramBaseChatPie);
    this.d = paramBaseChatPie;
    return localBaseChatPie;
  }
  
  private void a(BaseChatPie paramBaseChatPie, Intent paramIntent) {}
  
  private boolean a(IChatPieCreator paramIChatPieCreator, BaseChatPie paramBaseChatPie, Intent paramIntent, TopGestureLayout paramTopGestureLayout)
  {
    return (paramIChatPieCreator.a(this.c.app, paramBaseChatPie, paramIntent)) && (paramBaseChatPie.aW() == paramTopGestureLayout);
  }
  
  private boolean b(Intent paramIntent, TopGestureLayout paramTopGestureLayout)
  {
    Object localObject = this.d;
    if ((localObject != null) && (((BaseChatPie)localObject).aW() == paramTopGestureLayout))
    {
      if ((this.c instanceof SplashActivity)) {
        d();
      }
      return true;
    }
    d();
    localObject = this.c.app;
    BaseActivity localBaseActivity = this.c;
    a(a(new BaseChatPie((QQAppInterface)localObject, paramTopGestureLayout, localBaseActivity, localBaseActivity)), paramIntent);
    return false;
  }
  
  protected int a(Intent paramIntent)
  {
    int k = paramIntent.getIntExtra("uintype", -1);
    int j = 1;
    if (k == 1026)
    {
      if (QLog.isDevelopLevel()) {
        QLog.i("PttShow", 4, "UIN_TYPE_HOTCHAT_TOPIC in create chat pie");
      }
      return 1;
    }
    String str;
    if (k == 0)
    {
      str = paramIntent.getStringExtra("uin");
      if ((!CrmUtils.a(this.c.app, str, k)) && (!QidianManager.a(this.c.app, str)))
      {
        if (RobotUtils.a(this.c.app, str)) {
          return 1043;
        }
        if (QFileUtils.b(this.c.app, str)) {
          return 6000;
        }
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.d("ChatPieCache", 2, "change uinType from UIN_TYPE_FRIEND to UIN_TYPE_BUSINESS_CMR_TMP");
        }
        paramIntent.putExtra("uintype", 1024);
        return 1024;
      }
    }
    else if (k == 1025)
    {
      str = paramIntent.getStringExtra("uin");
      if ((!TextUtils.isEmpty(str)) && (((FriendsManager)this.c.app.getManager(QQManagerFactory.FRIENDS_MANAGER)).n(str))) {
        paramIntent.putExtra("uintype", 0);
      }
    }
    else
    {
      for (;;)
      {
        return 0;
        if (k != 1024) {
          break;
        }
        str = paramIntent.getStringExtra("uin");
        if (TextUtils.isEmpty(str)) {
          break label341;
        }
        int i = j;
        if (!CrmUtils.a(this.c.app, str, k)) {
          if (QidianManager.a(this.c.app, str)) {
            i = j;
          } else {
            i = 0;
          }
        }
        if ((i != 0) || (!((FriendsManager)this.c.app.getManager(QQManagerFactory.FRIENDS_MANAGER)).n(str))) {
          break label341;
        }
        if (QLog.isColorLevel()) {
          QLog.d("ChatPieCache", 2, "change uinType from UIN_TYPE_BUSINESS_CMR_TMP to UIN_TYPE_FRIEND");
        }
        paramIntent.putExtra("uintype", 0);
      }
      if (k == 1043) {
        paramIntent.putExtra("uintype", 0);
      }
    }
    label341:
    return k;
  }
  
  protected IChatPieCreator a(int paramInt)
  {
    return ChatPieCreatorFactory.a().a(paramInt);
  }
  
  public void a()
  {
    this.b.removeMessages(1);
  }
  
  public void a(BaseActivity paramBaseActivity)
  {
    this.c = paramBaseActivity;
  }
  
  protected boolean a(Intent paramIntent, int paramInt, TopGestureLayout paramTopGestureLayout)
  {
    IChatPieCreator localIChatPieCreator = a(paramInt);
    if (localIChatPieCreator != null)
    {
      Iterator localIterator = this.a.values().iterator();
      while (localIterator.hasNext())
      {
        BaseChatPie localBaseChatPie = (BaseChatPie)localIterator.next();
        if (a(localIChatPieCreator, localBaseChatPie, paramIntent, paramTopGestureLayout))
        {
          if (localIChatPieCreator.a(this.c)) {
            d();
          }
          a(localBaseChatPie);
          return false;
        }
      }
      d();
      a(a(localIChatPieCreator.a(this.c.app, this.c, paramTopGestureLayout, paramIntent)), paramIntent);
      return true;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ChatPieCache", 2, "AIOTime getChatPie no Type at default");
    }
    return !b(paramIntent, paramTopGestureLayout);
  }
  
  public boolean a(Intent paramIntent, TopGestureLayout paramTopGestureLayout)
  {
    Object localObject = this.d;
    boolean bool = false;
    if ((localObject != null) && (!paramIntent.getBooleanExtra("open_chatfragment_fromphoto", false)))
    {
      this.d.U();
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("getChatPie doOnNewIntent_clearBusinessData ");
        ((StringBuilder)localObject).append(this.d.hashCode());
        QLog.i("ChatPieCache", 2, ((StringBuilder)localObject).toString());
      }
    }
    int i = paramIntent.getIntExtra("chat_subType", 0);
    localObject = paramIntent.getStringExtra("uin");
    if ((localObject != null) && (((String)localObject).length() >= 4) && (QLog.isColorLevel()))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getChatPie uin=");
      localStringBuilder.append(((String)localObject).substring(((String)localObject).length() - 4));
      QLog.i("ChatPieCache", 2, localStringBuilder.toString());
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getChatPie subType = ");
      ((StringBuilder)localObject).append(i);
      ((StringBuilder)localObject).append(" type = ");
      ((StringBuilder)localObject).append(paramIntent.getIntExtra("uintype", -1));
      ((StringBuilder)localObject).append(" mRootView is null?: ");
      if (paramTopGestureLayout == null) {
        bool = true;
      }
      ((StringBuilder)localObject).append(bool);
      QLog.i("ChatPieCache", 2, ((StringBuilder)localObject).toString());
    }
    localObject = b(paramIntent, i, paramTopGestureLayout);
    if (localObject != null)
    {
      if (((Boolean)localObject).booleanValue()) {
        this.d.g();
      }
      return ((Boolean)localObject).booleanValue();
    }
    paramIntent = Boolean.valueOf(a(paramIntent, a(paramIntent), paramTopGestureLayout));
    if (paramIntent.booleanValue()) {
      this.d.g();
    }
    return paramIntent.booleanValue();
  }
  
  @Nullable
  Boolean b(Intent paramIntent, int paramInt, TopGestureLayout paramTopGestureLayout)
  {
    if ((paramInt == 1) || (paramInt == 3) || (paramInt == 4))
    {
      IChatPieCreator localIChatPieCreator = ChatPieSubTypeCreatorFactory.a().a(paramInt);
      if (localIChatPieCreator != null)
      {
        Iterator localIterator = this.a.values().iterator();
        while (localIterator.hasNext())
        {
          BaseChatPie localBaseChatPie = (BaseChatPie)localIterator.next();
          if (a(localIChatPieCreator, localBaseChatPie, paramIntent, paramTopGestureLayout))
          {
            if (localIChatPieCreator.a(this.c)) {
              d();
            }
            a(localBaseChatPie);
            return Boolean.valueOf(false);
          }
        }
        d();
        a(a(localIChatPieCreator.a(this.c.app, this.c, paramTopGestureLayout, paramIntent)), paramIntent);
        return Boolean.valueOf(true);
      }
    }
    return null;
  }
  
  public void b()
  {
    this.b.sendEmptyMessageDelayed(1, 500L);
  }
  
  public BaseChatPie c()
  {
    return this.d;
  }
  
  public void d()
  {
    Iterator localIterator = this.a.values().iterator();
    while (localIterator.hasNext())
    {
      BaseChatPie localBaseChatPie = (BaseChatPie)localIterator.next();
      if (QLog.isColorLevel()) {
        QLog.i("ChatPieCache", 2, "OnClearLastPie");
      }
      if ((localBaseChatPie.bb() != 6) && (!localBaseChatPie.bu())) {
        localBaseChatPie.O();
      }
      if (!localBaseChatPie.bu()) {
        localBaseChatPie.K();
      } else {
        QLog.e("ChatPieCache", 1, "chatpie life cycle illegal");
      }
    }
    if ((this.d == null) && (QLog.isColorLevel())) {
      QLog.i("ChatPieCache", 2, "OnClearLastPie already cleared.");
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 1) {
      d();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.ChatPieCache
 * JD-Core Version:    0.7.0.1
 */