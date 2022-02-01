package com.tencent.mobileqq.apollo.drawer;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.DrawerPushItem;
import com.tencent.mobileqq.apollo.api.IApolloManagerService;
import com.tencent.mobileqq.apollo.api.impl.ApolloManagerServiceImpl;
import com.tencent.mobileqq.apollo.model.ApolloActionData;
import com.tencent.mobileqq.apollo.persistence.api.IApolloDaoManagerService;
import com.tencent.mobileqq.apollo.persistence.api.impl.ApolloDaoManagerServiceImpl;
import com.tencent.mobileqq.apollo.res.api.IApolloResDownloader;
import com.tencent.mobileqq.apollo.script.SpriteUtil;
import com.tencent.mobileqq.apollo.script.drawerinfo.SpriteDrawerInfoManager;
import com.tencent.mobileqq.apollo.statistics.ApolloTianshuReportUtil;
import com.tencent.mobileqq.apollo.utils.ApolloConstant;
import com.tencent.mobileqq.apollo.utils.api.impl.ApolloUtilImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.cmshow.engine.util.CMGetResPathUtil;
import com.tencent.mobileqq.cmshow.engine.util.CMResUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tianshu.api.IRedTouchManager;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class PushDrawerStatus
  extends ApolloDrawerStatus
{
  public static String a;
  public static String b;
  public static String c;
  public static String d;
  public static boolean d;
  private long a;
  public DrawerPushItem a;
  private int b;
  private int c;
  
  public PushDrawerStatus(QQAppInterface paramQQAppInterface, DrawerPushItem paramDrawerPushItem)
  {
    super(paramQQAppInterface);
    this.jdField_c_of_type_Int = 7;
    this.jdField_a_of_type_Int = paramDrawerPushItem.priority;
    jdField_a_of_type_JavaLangString = paramDrawerPushItem.content;
    this.jdField_b_of_type_Int = paramDrawerPushItem.action_id;
    jdField_b_of_type_JavaLangString = paramDrawerPushItem.ext_url;
    jdField_d_of_type_JavaLangString = paramDrawerPushItem.msg_id;
    jdField_c_of_type_JavaLangString = paramDrawerPushItem.tips_str;
    if (paramDrawerPushItem.bubble_res_id == 32) {
      this.jdField_c_of_type_Int = 7;
    } else if (paramDrawerPushItem.bubble_res_id == 33) {
      this.jdField_c_of_type_Int = 6;
    } else {
      this.jdField_c_of_type_Int = 9;
    }
    this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem = paramDrawerPushItem;
    if (this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem.fromTianshu) {
      this.jdField_a_of_type_Boolean = false;
    }
    if (!a())
    {
      jdField_d_of_type_Boolean = false;
      this.jdField_b_of_type_Boolean = false;
    }
  }
  
  public int a(SpriteDrawerInfoManager paramSpriteDrawerInfoManager, int paramInt, AppInterface paramAppInterface, Context paramContext)
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      DrawerPushItem localDrawerPushItem = this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem;
      if ((localDrawerPushItem != null) && (localDrawerPushItem.show_sum < this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem.show_counts))
      {
        int i;
        if (this.jdField_b_of_type_Int > ApolloConstant.jdField_a_of_type_Int) {
          i = 3;
        } else {
          i = 2;
        }
        boolean bool = CMResUtil.d(5, this.jdField_b_of_type_Int);
        if (this.jdField_b_of_type_Int > 0)
        {
          if (bool)
          {
            paramAppInterface = new ApolloActionData();
            paramAppInterface.actionId = this.jdField_b_of_type_Int;
            paramAppInterface.actionType = 0;
            SpriteUtil.a(paramSpriteDrawerInfoManager, 6, paramAppInterface);
            paramInt = 6;
            break label198;
          }
          super.a(paramSpriteDrawerInfoManager, i, paramInt, paramAppInterface, paramContext);
          paramSpriteDrawerInfoManager = (IApolloResDownloader)QRoute.api(IApolloResDownloader.class);
          paramContext = new StringBuilder();
          paramContext.append(CMGetResPathUtil.d(this.jdField_b_of_type_Int));
          paramContext.append("/d.zip");
          paramSpriteDrawerInfoManager.downLoadSpecialAction(paramAppInterface, paramContext.toString(), CMResUtil.b(this.jdField_b_of_type_Int));
        }
        else
        {
          super.a(paramSpriteDrawerInfoManager, i, paramInt, paramAppInterface, paramContext);
        }
        paramInt = 0;
        label198:
        if (QLog.isColorLevel()) {
          QLog.d("[cmshow]AplloDrawerStatus", 2, new Object[] { "PushDrawerStatus onExecAction:", Integer.valueOf(this.jdField_b_of_type_Int), ",rscType:", Integer.valueOf(paramInt), ",isRscDone:", Boolean.valueOf(bool) });
        }
        return 0;
      }
    }
    return super.a(paramSpriteDrawerInfoManager, paramInt, paramAppInterface, paramContext);
  }
  
  public void a(SpriteDrawerInfoManager paramSpriteDrawerInfoManager, Context paramContext, QQAppInterface paramQQAppInterface)
  {
    a(paramQQAppInterface, paramContext);
  }
  
  public void a(SpriteDrawerInfoManager paramSpriteDrawerInfoManager, Context paramContext, QQAppInterface paramQQAppInterface, int paramInt)
  {
    if (!a()) {
      return;
    }
    boolean bool;
    if ((this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem.is_reddot != 0) && (!this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem.fromTianshu)) {
      bool = false;
    } else {
      bool = true;
    }
    jdField_d_of_type_Boolean = bool;
    this.jdField_b_of_type_Boolean = true;
    if (!TextUtils.isEmpty(jdField_a_of_type_JavaLangString)) {
      SpriteUtil.a(paramSpriteDrawerInfoManager, jdField_a_of_type_JavaLangString, this.jdField_c_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem.bubble_res_id);
    }
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    paramSpriteDrawerInfoManager = (ApolloManagerServiceImpl)paramQQAppInterface.getRuntimeService(IApolloManagerService.class, "all");
    QLog.d("[cmshow]AplloDrawerStatus", 1, new Object[] { "compass report, show, advId=", jdField_d_of_type_JavaLangString });
    VipUtils.a(paramQQAppInterface, "cmshow", "Apollo", "drawer_avatar_RedDotShow", 0, 0, new String[] { jdField_d_of_type_JavaLangString, String.valueOf(paramSpriteDrawerInfoManager.mIsNewStoreUser ^ true), this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem.act_id });
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem.reddotPath))
    {
      QLog.d("[cmshow]AplloDrawerStatus", 1, new Object[] { "tianshu report, show, advId=", jdField_d_of_type_JavaLangString, ", path=", this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem.reddotPath });
      paramSpriteDrawerInfoManager = (IRedTouchManager)paramQQAppInterface.getRuntimeService(IRedTouchManager.class, "");
      paramSpriteDrawerInfoManager.onRedTouchItemExposure(paramSpriteDrawerInfoManager.getAppInfoByPath(this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem.reddotPath), "");
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem.tianshuAdId != 0) {
      ApolloTianshuReportUtil.a(101, String.valueOf(this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem.tianshuAdId), this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem.tianshuTraceInfo);
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface != null)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem == null) {
        return;
      }
      ApolloManagerServiceImpl localApolloManagerServiceImpl = (ApolloManagerServiceImpl)paramQQAppInterface.getRuntimeService(IApolloManagerService.class, "all");
      paramQQAppInterface = (ApolloDaoManagerServiceImpl)paramQQAppInterface.getRuntimeService(IApolloDaoManagerService.class, "all");
      DrawerPushItem localDrawerPushItem = this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem;
      localDrawerPushItem.show_sum = localDrawerPushItem.show_counts;
      if ((this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem.is_reddot == 1) && (!this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem.fromTianshu))
      {
        localApolloManagerServiceImpl.updateDrawerItem(this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem);
        return;
      }
      paramQQAppInterface.removePushItem(this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem);
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    if (paramQQAppInterface != null)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem == null) {
        return;
      }
      a(paramQQAppInterface);
      ApolloManagerServiceImpl localApolloManagerServiceImpl = (ApolloManagerServiceImpl)paramQQAppInterface.getRuntimeService(IApolloManagerService.class, "all");
      if (this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem.reddotGameId > 0) {
        QLog.e("[cmshow]AplloDrawerStatus", 1, "light game had been remove");
      } else {
        ApolloUtilImpl.openStoreByTabScheme(paramQQAppInterface, paramContext, this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem.scheme, this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem.ext_url, "drawer");
      }
      QLog.d("[cmshow]AplloDrawerStatus", 1, new Object[] { "compass report, click, advId=", jdField_d_of_type_JavaLangString });
      VipUtils.a(paramQQAppInterface, "cmshow", "Apollo", "drawer_avatar_RedDotClear", 0, 0, new String[] { jdField_d_of_type_JavaLangString, String.valueOf(localApolloManagerServiceImpl.mIsNewStoreUser ^ true), this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem.act_id });
      paramContext = this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem;
      if (paramContext != null)
      {
        if (!TextUtils.isEmpty(paramContext.reddotPath))
        {
          QLog.d("[cmshow]AplloDrawerStatus", 1, new Object[] { "tianshu report, click, advId=", jdField_d_of_type_JavaLangString, ", path=", this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem.reddotPath });
          ((IRedTouchManager)paramQQAppInterface.getRuntimeService(IRedTouchManager.class, "")).onRedTouchItemClick(this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem.reddotPath);
          return;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem.tianshuAdId != 0) {
          ApolloTianshuReportUtil.a(102, String.valueOf(this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem.tianshuAdId), this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem.tianshuTraceInfo);
        }
      }
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, SpriteDrawerInfoManager paramSpriteDrawerInfoManager)
  {
    super.a(paramQQAppInterface, paramSpriteDrawerInfoManager);
    if (paramQQAppInterface != null)
    {
      if (this.jdField_a_of_type_Long == 0L) {
        return;
      }
      jdField_d_of_type_Boolean = false;
      if (System.currentTimeMillis() - this.jdField_a_of_type_Long > 1000L)
      {
        a(paramQQAppInterface.getApp().getApplicationContext(), paramQQAppInterface);
        paramSpriteDrawerInfoManager = this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem;
        paramSpriteDrawerInfoManager.show_sum += 1;
        paramSpriteDrawerInfoManager = (ApolloManagerServiceImpl)paramQQAppInterface.getRuntimeService(IApolloManagerService.class, "all");
        paramQQAppInterface = (ApolloDaoManagerServiceImpl)paramQQAppInterface.getRuntimeService(IApolloDaoManagerService.class, "all");
        if ((this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem.show_sum >= this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem.show_counts) && ((this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem.is_reddot != 1) || (this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem.fromTianshu)))
        {
          paramQQAppInterface.removePushItem(this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem);
          return;
        }
        paramSpriteDrawerInfoManager.updateDrawerItem(this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem);
      }
    }
  }
  
  public boolean a()
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      DrawerPushItem localDrawerPushItem = this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem;
      if ((localDrawerPushItem != null) && (localDrawerPushItem.show_sum < this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem.show_counts)) {
        return true;
      }
    }
    return false;
  }
  
  public void b(SpriteDrawerInfoManager paramSpriteDrawerInfoManager, Context paramContext, QQAppInterface paramQQAppInterface)
  {
    a(paramQQAppInterface, paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.drawer.PushDrawerStatus
 * JD-Core Version:    0.7.0.1
 */