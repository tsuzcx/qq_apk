package com.tencent.mobileqq.apollo.drawer;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.DrawerPushItem;
import com.tencent.mobileqq.apollo.api.IApolloManagerService;
import com.tencent.mobileqq.apollo.api.impl.ApolloManagerServiceImpl;
import com.tencent.mobileqq.apollo.api.model.ApolloActionData;
import com.tencent.mobileqq.apollo.api.res.IApolloResDownloader;
import com.tencent.mobileqq.apollo.api.uitls.ApolloConstant;
import com.tencent.mobileqq.apollo.api.uitls.impl.ApolloUtilImpl;
import com.tencent.mobileqq.apollo.script.SpriteUtil;
import com.tencent.mobileqq.apollo.script.drawerInfo.SpriteDrawerInfoManager;
import com.tencent.mobileqq.apollo.statistics.ApolloTianshuReportUtil;
import com.tencent.mobileqq.apollo.utils.ApolloGameUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.redtouch.RedTouchManager;
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
  long a;
  public DrawerPushItem a;
  int b;
  int c;
  
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
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem = paramDrawerPushItem;
      if (this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem.fromTianshu) {
        this.jdField_a_of_type_Boolean = false;
      }
      if (!a())
      {
        jdField_d_of_type_Boolean = false;
        this.jdField_b_of_type_Boolean = false;
      }
      return;
      if (paramDrawerPushItem.bubble_res_id == 33) {
        this.jdField_c_of_type_Int = 6;
      } else {
        this.jdField_c_of_type_Int = 9;
      }
    }
  }
  
  public int a(SpriteDrawerInfoManager paramSpriteDrawerInfoManager, int paramInt, AppInterface paramAppInterface, Context paramContext)
  {
    if ((this.jdField_a_of_type_Boolean) || (this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem == null) || (this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem.show_sum >= this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem.show_counts)) {
      return super.a(paramSpriteDrawerInfoManager, paramInt, paramAppInterface, paramContext);
    }
    int i;
    boolean bool;
    if (this.jdField_b_of_type_Int > ApolloConstant.jdField_b_of_type_Int)
    {
      i = 3;
      bool = ApolloUtilImpl.isSpecialActionResDone(5, this.jdField_b_of_type_Int);
      if (this.jdField_b_of_type_Int <= 0) {
        break label235;
      }
      if (!bool) {
        break label172;
      }
      paramAppInterface = new ApolloActionData();
      paramAppInterface.actionId = this.jdField_b_of_type_Int;
      paramAppInterface.actionType = 0;
      paramInt = 6;
      SpriteUtil.a(paramSpriteDrawerInfoManager, 6, paramAppInterface);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AplloDrawerStatus", 2, new Object[] { "PushDrawerStatus onExecAction:", Integer.valueOf(this.jdField_b_of_type_Int), ",rscType:", Integer.valueOf(paramInt), ",isRscDone:", Boolean.valueOf(bool) });
      }
      return 0;
      i = 2;
      break;
      label172:
      super.a(paramSpriteDrawerInfoManager, i, paramInt, paramAppInterface, paramContext);
      ((IApolloResDownloader)QRoute.api(IApolloResDownloader.class)).downLoadSpecialAction(paramAppInterface, ApolloUtilImpl.getApolloDrawerPath(this.jdField_b_of_type_Int) + "/d.zip", ApolloUtilImpl.getApolloDrawerUrl(this.jdField_b_of_type_Int));
      paramInt = 0;
      continue;
      label235:
      super.a(paramSpriteDrawerInfoManager, i, paramInt, paramAppInterface, paramContext);
      paramInt = 0;
    }
  }
  
  public void a(SpriteDrawerInfoManager paramSpriteDrawerInfoManager, Context paramContext, QQAppInterface paramQQAppInterface)
  {
    a(paramQQAppInterface, paramContext);
  }
  
  public void a(SpriteDrawerInfoManager paramSpriteDrawerInfoManager, Context paramContext, QQAppInterface paramQQAppInterface, int paramInt)
  {
    if (!a()) {}
    label244:
    label250:
    do
    {
      return;
      boolean bool;
      if ((this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem.is_reddot == 0) || (this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem.fromTianshu))
      {
        bool = true;
        jdField_d_of_type_Boolean = bool;
        this.jdField_b_of_type_Boolean = true;
        if (!TextUtils.isEmpty(jdField_a_of_type_JavaLangString)) {
          SpriteUtil.a(paramSpriteDrawerInfoManager, jdField_a_of_type_JavaLangString, this.jdField_c_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem.bubble_res_id);
        }
        this.jdField_a_of_type_Long = System.currentTimeMillis();
        paramSpriteDrawerInfoManager = (ApolloManagerServiceImpl)paramQQAppInterface.getRuntimeService(IApolloManagerService.class, "all");
        QLog.d("AplloDrawerStatus", 1, new Object[] { "compass report, show, advId=", jdField_d_of_type_JavaLangString });
        paramContext = jdField_d_of_type_JavaLangString;
        if (!paramSpriteDrawerInfoManager.mIsNewStoreUser) {
          break label244;
        }
      }
      for (paramInt = 0;; paramInt = 1)
      {
        VipUtils.a(paramQQAppInterface, "cmshow", "Apollo", "drawer_avatar_RedDotShow", 0, 0, new String[] { paramContext, String.valueOf(paramInt), this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem.act_id });
        if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem.reddotPath)) {
          break label250;
        }
        QLog.d("AplloDrawerStatus", 1, new Object[] { "tianshu report, show, advId=", jdField_d_of_type_JavaLangString, ", path=", this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem.reddotPath });
        paramSpriteDrawerInfoManager = (RedTouchManager)paramQQAppInterface.getManager(QQManagerFactory.MGR_RED_TOUCH);
        paramSpriteDrawerInfoManager.b(paramSpriteDrawerInfoManager.a(this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem.reddotPath), "");
        return;
        bool = false;
        break;
      }
    } while (this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem.tianshuAdId == 0);
    ApolloTianshuReportUtil.a(101, String.valueOf(this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem.tianshuAdId), this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem.tianshuTraceInfo);
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    if ((paramQQAppInterface == null) || (this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem == null)) {
      return;
    }
    paramQQAppInterface = (ApolloManagerServiceImpl)paramQQAppInterface.getRuntimeService(IApolloManagerService.class, "all");
    this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem.show_sum = this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem.show_counts;
    if ((this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem.is_reddot != 1) || (this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem.fromTianshu))
    {
      paramQQAppInterface.removePushItem(this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem);
      return;
    }
    paramQQAppInterface.updateDrawerItem(this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem);
  }
  
  public void a(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    if ((paramQQAppInterface == null) || (this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem == null)) {}
    label90:
    do
    {
      return;
      a(paramQQAppInterface);
      ApolloManagerServiceImpl localApolloManagerServiceImpl = (ApolloManagerServiceImpl)paramQQAppInterface.getRuntimeService(IApolloManagerService.class, "all");
      if (this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem.reddotGameId > 0)
      {
        QLog.d("AplloDrawerStatus", 1, "onBubbleClick play game id:" + this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem.reddotGameId);
        ApolloGameUtil.a(paramQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem.reddotGameId, 0L, 0, null, 323, null);
        QLog.d("AplloDrawerStatus", 1, new Object[] { "compass report, click, advId=", jdField_d_of_type_JavaLangString });
        paramContext = jdField_d_of_type_JavaLangString;
        if (!localApolloManagerServiceImpl.mIsNewStoreUser) {
          break label267;
        }
      }
      for (int i = 0;; i = 1)
      {
        VipUtils.a(paramQQAppInterface, "cmshow", "Apollo", "drawer_avatar_RedDotClear", 0, 0, new String[] { paramContext, String.valueOf(i), this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem.act_id });
        if (this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem == null) {
          break;
        }
        if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem.reddotPath)) {
          break label272;
        }
        QLog.d("AplloDrawerStatus", 1, new Object[] { "tianshu report, click, advId=", jdField_d_of_type_JavaLangString, ", path=", this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem.reddotPath });
        ((RedTouchManager)paramQQAppInterface.getManager(QQManagerFactory.MGR_RED_TOUCH)).b(this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem.reddotPath);
        return;
        ApolloUtilImpl.openStoreByTabScheme(paramQQAppInterface, paramContext, this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem.scheme, this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem.ext_url, "drawer");
        break label90;
      }
    } while (this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem.tianshuAdId == 0);
    label267:
    label272:
    ApolloTianshuReportUtil.a(102, String.valueOf(this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem.tianshuAdId), this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem.tianshuTraceInfo);
  }
  
  public void a(QQAppInterface paramQQAppInterface, SpriteDrawerInfoManager paramSpriteDrawerInfoManager)
  {
    super.a(paramQQAppInterface, paramSpriteDrawerInfoManager);
    if ((paramQQAppInterface == null) || (this.jdField_a_of_type_Long == 0L)) {}
    do
    {
      return;
      jdField_d_of_type_Boolean = false;
    } while (System.currentTimeMillis() - this.jdField_a_of_type_Long <= 1000L);
    a(paramQQAppInterface.getApp().getApplicationContext(), paramQQAppInterface);
    paramSpriteDrawerInfoManager = this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem;
    paramSpriteDrawerInfoManager.show_sum += 1;
    paramQQAppInterface = (ApolloManagerServiceImpl)paramQQAppInterface.getRuntimeService(IApolloManagerService.class, "all");
    if ((this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem.show_sum >= this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem.show_counts) && ((this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem.is_reddot != 1) || (this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem.fromTianshu)))
    {
      paramQQAppInterface.removePushItem(this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem);
      return;
    }
    paramQQAppInterface.updateDrawerItem(this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem);
  }
  
  public boolean a()
  {
    return (!this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem != null) && (this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem.show_sum < this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem.show_counts);
  }
  
  public void b(SpriteDrawerInfoManager paramSpriteDrawerInfoManager, Context paramContext, QQAppInterface paramQQAppInterface)
  {
    a(paramQQAppInterface, paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.drawer.PushDrawerStatus
 * JD-Core Version:    0.7.0.1
 */