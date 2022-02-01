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
    Object localObject = this.b;
    if ((localObject == null) || (((List)localObject).size() <= 0))
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelChatpanelbarChatPanelBarContext.a().a();
      this.jdField_a_of_type_JavaUtilList = b(paramQQAppInterface, paramSessionInfo, paramBaseChatPie);
      this.b = a((Context)localObject, this.jdField_a_of_type_JavaUtilList);
    }
    return this.b;
  }
  
  protected void a()
  {
    if (ShortVideoUtils.needTwoEntrance()) {
      AIOPanelUtiles.v[2] = 2130844820;
    } else {
      AIOPanelUtiles.v[2] = 2130844809;
    }
    this.jdField_a_of_type_JavaUtilList.add(AIOPanelUtiles.v);
  }
  
  protected void a(Context paramContext)
  {
    if (ShortVideoUtils.needTwoEntrance())
    {
      AIOPanelUtiles.v[2] = 2130838142;
      AIOPanelUtiles.v[5] = 2130850293;
      AIOPanelUtiles.v[6] = 2130850294;
    }
    else
    {
      AIOPanelUtiles.v[2] = 2130838065;
      AIOPanelUtiles.v[5] = 2130850195;
      AIOPanelUtiles.v[6] = 2130850196;
    }
    this.jdField_a_of_type_JavaUtilList.add(AIOPanelUtiles.v);
  }
  
  protected abstract void a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, BaseChatPie paramBaseChatPie);
  
  protected void a(int[] paramArrayOfInt)
  {
    this.jdField_a_of_type_JavaUtilList.add(paramArrayOfInt);
  }
  
  public List<int[]> b(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, BaseChatPie paramBaseChatPie)
  {
    if (this.jdField_a_of_type_JavaUtilList == null)
    {
      boolean bool = this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelChatpanelbarChatPanelBarContext.a().a();
      this.jdField_a_of_type_JavaUtilList = new ArrayList();
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
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  protected void b()
  {
    int i;
    if ((!ShortVideoUtils.needTwoEntrance()) && (this.jdField_a_of_type_JavaUtilList.contains(AIOPanelUtiles.v))) {
      i = 0;
    } else {
      i = 1;
    }
    if (i != 0)
    {
      AIOPanelUtiles.s[2] = 2130844809;
      AIOPanelUtiles.s[5] = 0;
      AIOPanelUtiles.s[6] = 0;
    }
  }
  
  protected void b(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, BaseChatPie paramBaseChatPie)
  {
    c(paramQQAppInterface, paramSessionInfo, paramBaseChatPie);
  }
  
  protected void c()
  {
    boolean bool;
    if ((!ShortVideoUtils.needTwoEntrance()) && (this.jdField_a_of_type_JavaUtilList.contains(AIOPanelUtiles.v))) {
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
      this.jdField_a_of_type_JavaUtilList.add(AIOPanelUtiles.s);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.panel.chatpanelbar.loader.BaseChatPanelBarLoader
 * JD-Core Version:    0.7.0.1
 */