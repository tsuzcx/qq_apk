package com.tencent.mobileqq.activity.aio.panel.chatpanelbar.loader;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.panel.AIOPanelUtiles;
import com.tencent.mobileqq.activity.aio.panel.chatpanelbar.ChatPanelBarContext;
import com.tencent.mobileqq.activity.aio.panel.chatpanelbar.IChatPanelBarData;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpic.HotPicManager;
import com.tencent.mobileqq.pluspanel.AIOPanelIconItem;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public abstract class BaseChatPanelBarLoader
  implements IChatPanelBarLoader
{
  protected List<int[]> a;
  protected List<AIOPanelIconItem> b;
  protected ChatPanelBarContext c;
  
  public BaseChatPanelBarLoader(ChatPanelBarContext paramChatPanelBarContext)
  {
    this.c = paramChatPanelBarContext;
  }
  
  protected static AIOPanelIconItem a(Context paramContext, int[] paramArrayOfInt)
  {
    AIOPanelIconItem localAIOPanelIconItem = new AIOPanelIconItem();
    localAIOPanelIconItem.g = paramArrayOfInt[0];
    localAIOPanelIconItem.h = paramContext.getResources().getString(paramArrayOfInt[1]);
    localAIOPanelIconItem.m = paramContext.getResources().getDrawable(paramArrayOfInt[2]);
    localAIOPanelIconItem.o = paramArrayOfInt[3];
    localAIOPanelIconItem.p = paramArrayOfInt;
    return localAIOPanelIconItem;
  }
  
  public static List<AIOPanelIconItem> a(Context paramContext, List<int[]> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < paramList.size())
    {
      localArrayList.add(a(paramContext, (int[])paramList.get(i)));
      i += 1;
    }
    return localArrayList;
  }
  
  protected void a()
  {
    if (ShortVideoUtils.needTwoEntrance()) {
      AIOPanelUtiles.w[2] = 2130846254;
    } else {
      AIOPanelUtiles.w[2] = 2130846243;
    }
    this.a.add(AIOPanelUtiles.w);
  }
  
  protected void a(Context paramContext)
  {
    if (ShortVideoUtils.needTwoEntrance())
    {
      AIOPanelUtiles.w[2] = 2130838185;
      AIOPanelUtiles.w[5] = 2130852084;
      AIOPanelUtiles.w[6] = 2130852085;
    }
    else
    {
      AIOPanelUtiles.w[2] = 2130838107;
      AIOPanelUtiles.w[5] = 2130851986;
      AIOPanelUtiles.w[6] = 2130851987;
    }
    this.a.add(AIOPanelUtiles.w);
  }
  
  protected abstract void a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, BaseChatPie paramBaseChatPie);
  
  protected void a(int[] paramArrayOfInt)
  {
    this.a.add(paramArrayOfInt);
  }
  
  protected void b()
  {
    int i;
    if ((!ShortVideoUtils.needTwoEntrance()) && (this.a.contains(AIOPanelUtiles.w))) {
      i = 0;
    } else {
      i = 1;
    }
    if (i != 0)
    {
      AIOPanelUtiles.t[2] = 2130846243;
      AIOPanelUtiles.t[5] = 0;
      AIOPanelUtiles.t[6] = 0;
    }
  }
  
  protected void b(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, BaseChatPie paramBaseChatPie)
  {
    c(paramQQAppInterface, paramSessionInfo, paramBaseChatPie);
  }
  
  protected void c()
  {
    boolean bool;
    if ((!ShortVideoUtils.needTwoEntrance()) && (this.a.contains(AIOPanelUtiles.w))) {
      bool = false;
    } else {
      bool = true;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("addCameraIcon");
      localStringBuilder.append(bool);
      QLog.d("BaseChatPanelBarLoader", 2, localStringBuilder.toString());
    }
    if (bool) {
      this.a.add(AIOPanelUtiles.t);
    }
  }
  
  protected abstract void c(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, BaseChatPie paramBaseChatPie);
  
  public List<AIOPanelIconItem> d(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, BaseChatPie paramBaseChatPie)
  {
    Object localObject = this.b;
    if ((localObject == null) || (((List)localObject).size() <= 0))
    {
      localObject = this.c.a().j();
      this.a = e(paramQQAppInterface, paramSessionInfo, paramBaseChatPie);
      this.b = a((Context)localObject, this.a);
    }
    return this.b;
  }
  
  protected void d()
  {
    if (HotPicManager.a(this.c.a().e()).j()) {
      this.a.add(AIOPanelUtiles.P);
    }
  }
  
  public List<int[]> e(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, BaseChatPie paramBaseChatPie)
  {
    if (this.a == null)
    {
      boolean bool = this.c.a().a();
      this.a = new ArrayList();
      if (bool)
      {
        if ((!"1103".equals(ThemeUtil.curThemeId)) && (!"2920".equals(ThemeUtil.curThemeId))) {
          a(paramQQAppInterface, paramSessionInfo, paramBaseChatPie);
        } else {
          b(paramQQAppInterface, paramSessionInfo, paramBaseChatPie);
        }
      }
      else {
        c(paramQQAppInterface, paramSessionInfo, paramBaseChatPie);
      }
    }
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.panel.chatpanelbar.loader.BaseChatPanelBarLoader
 * JD-Core Version:    0.7.0.1
 */