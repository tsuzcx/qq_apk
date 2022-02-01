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
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public abstract class BaseChatPanelBarLoader
  implements IChatPanelBarLoader
{
  protected ChatPanelBarContext a;
  protected List<int[]> a;
  protected List<AIOPanelIconItem> b;
  
  public BaseChatPanelBarLoader(ChatPanelBarContext paramChatPanelBarContext)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelChatpanelbarChatPanelBarContext = paramChatPanelBarContext;
  }
  
  protected static AIOPanelIconItem a(Context paramContext, int[] paramArrayOfInt)
  {
    AIOPanelIconItem localAIOPanelIconItem = new AIOPanelIconItem();
    localAIOPanelIconItem.jdField_d_of_type_Int = paramArrayOfInt[0];
    localAIOPanelIconItem.jdField_d_of_type_JavaLangString = paramContext.getResources().getString(paramArrayOfInt[1]);
    localAIOPanelIconItem.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramContext.getResources().getDrawable(paramArrayOfInt[2]);
    localAIOPanelIconItem.e = paramArrayOfInt[3];
    localAIOPanelIconItem.jdField_a_of_type_ArrayOfInt = paramArrayOfInt;
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
  
  public List<AIOPanelIconItem> a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, BaseChatPie paramBaseChatPie)
  {
    if ((this.b != null) && (this.b.size() > 0)) {}
    for (;;)
    {
      return this.b;
      Context localContext = this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelChatpanelbarChatPanelBarContext.a().a();
      this.jdField_a_of_type_JavaUtilList = b(paramQQAppInterface, paramSessionInfo, paramBaseChatPie);
      this.b = a(localContext, this.jdField_a_of_type_JavaUtilList);
    }
  }
  
  protected void a()
  {
    if (ShortVideoUtils.needTwoEntrance()) {
      AIOPanelUtiles.v[2] = 2130844944;
    }
    for (;;)
    {
      this.jdField_a_of_type_JavaUtilList.add(AIOPanelUtiles.v);
      return;
      AIOPanelUtiles.v[2] = 2130844933;
    }
  }
  
  protected void a(Context paramContext)
  {
    if (ShortVideoUtils.needTwoEntrance())
    {
      AIOPanelUtiles.v[2] = 2130838317;
      AIOPanelUtiles.v[5] = 2130850366;
      AIOPanelUtiles.v[6] = 2130850367;
    }
    for (;;)
    {
      this.jdField_a_of_type_JavaUtilList.add(AIOPanelUtiles.v);
      return;
      AIOPanelUtiles.v[2] = 2130838223;
      AIOPanelUtiles.v[5] = 2130850268;
      AIOPanelUtiles.v[6] = 2130850269;
    }
  }
  
  protected abstract void a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, BaseChatPie paramBaseChatPie);
  
  protected void a(int[] paramArrayOfInt)
  {
    this.jdField_a_of_type_JavaUtilList.add(paramArrayOfInt);
  }
  
  public List<int[]> b(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, BaseChatPie paramBaseChatPie)
  {
    if (this.jdField_a_of_type_JavaUtilList != null) {}
    for (;;)
    {
      return this.jdField_a_of_type_JavaUtilList;
      boolean bool = this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelChatpanelbarChatPanelBarContext.a().a();
      this.jdField_a_of_type_JavaUtilList = new ArrayList();
      if (bool)
      {
        if (("1103".equals(ThemeUtil.curThemeId)) || ("2920".equals(ThemeUtil.curThemeId))) {
          b(paramQQAppInterface, paramSessionInfo, paramBaseChatPie);
        } else {
          a(paramQQAppInterface, paramSessionInfo, paramBaseChatPie);
        }
      }
      else {
        c(paramQQAppInterface, paramSessionInfo, paramBaseChatPie);
      }
    }
  }
  
  protected void b()
  {
    if ((ShortVideoUtils.needTwoEntrance()) || (!this.jdField_a_of_type_JavaUtilList.contains(AIOPanelUtiles.v))) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        AIOPanelUtiles.s[2] = 2130844933;
        AIOPanelUtiles.s[5] = 0;
        AIOPanelUtiles.s[6] = 0;
      }
      return;
    }
  }
  
  protected void b(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, BaseChatPie paramBaseChatPie)
  {
    c(paramQQAppInterface, paramSessionInfo, paramBaseChatPie);
  }
  
  protected void c()
  {
    if ((ShortVideoUtils.needTwoEntrance()) || (!this.jdField_a_of_type_JavaUtilList.contains(AIOPanelUtiles.v))) {}
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("BaseChatPanelBarLoader", 2, "addCameraIcon" + bool);
      }
      if (bool) {
        this.jdField_a_of_type_JavaUtilList.add(AIOPanelUtiles.s);
      }
      return;
    }
  }
  
  protected abstract void c(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, BaseChatPie paramBaseChatPie);
  
  protected void d()
  {
    if (HotPicManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelChatpanelbarChatPanelBarContext.a().a()).b()) {
      this.jdField_a_of_type_JavaUtilList.add(AIOPanelUtiles.O);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.panel.chatpanelbar.loader.BaseChatPanelBarLoader
 * JD-Core Version:    0.7.0.1
 */