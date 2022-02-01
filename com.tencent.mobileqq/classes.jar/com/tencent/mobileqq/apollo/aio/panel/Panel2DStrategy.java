package com.tencent.mobileqq.apollo.aio.panel;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.apollo.aio.panel.viewbinder.ApolloBattleGameViewBinder;
import com.tencent.mobileqq.apollo.aio.panel.viewbinder.ApolloFavViewBinder;
import com.tencent.mobileqq.apollo.aio.panel.viewbinder.ApolloSecondaryViewBinder;
import com.tencent.mobileqq.apollo.aio.panel.viewbinder.ApolloSlaveViewBinder;
import com.tencent.mobileqq.apollo.aio.panel.viewbinder.ApolloTagActionViewBinder;
import com.tencent.mobileqq.apollo.aio.panel.viewbinder.ApolloViewBinder;
import com.tencent.mobileqq.apollo.api.IApolloManagerService;
import com.tencent.mobileqq.apollo.api.impl.ApolloManagerServiceImpl;
import com.tencent.mobileqq.apollo.model.ApolloActionPackage;
import com.tencent.mobileqq.apollo.script.SpriteActionScript;
import com.tencent.mobileqq.apollo.script.SpriteUtil;
import com.tencent.mobileqq.apollo.utils.ApolloPanelUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import java.util.List;

public class Panel2DStrategy
  extends PanelStrategy
{
  public Panel2DStrategy(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramContext, paramSessionInfo);
  }
  
  public ApolloViewBinder a(int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 2)
      {
        if (paramInt != 4) {
          return new ApolloSecondaryViewBinder(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
        }
        return new ApolloSlaveViewBinder(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
      }
      return new ApolloFavViewBinder(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
    }
    return new ApolloSecondaryViewBinder(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
  }
  
  public ApolloViewBinder a(int paramInt1, int paramInt2)
  {
    if (paramInt2 == 10) {
      return new ApolloBattleGameViewBinder(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
    }
    if (((paramInt2 == 0) || (paramInt2 == 1) || (paramInt2 == 9)) && (QzoneConfig.getInstance().getConfig("CMShow", "CMShowAIOPanelTag", 0) != 0)) {
      return new ApolloTagActionViewBinder(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
    }
    return a(paramInt1);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    QLog.d("[cmshow]Panel2DStrategy", 1, new Object[] { "saveCurrentIndex-2D, index:", Integer.valueOf(paramInt1), ", packageId:", Integer.valueOf(paramInt2) });
    ApolloPanelUtil.a(1, paramInt1, paramInt2);
    SpriteActionScript localSpriteActionScript = SpriteUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    if (localSpriteActionScript != null) {
      localSpriteActionScript.a(String.valueOf(paramInt2), "tabStatusChange");
    }
  }
  
  public void a(List<ApolloViewBinder> paramList, List<ApolloActionPackage> paramList1, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("[cmshow]Panel2DStrategy", 2, new Object[] { "[setCurrentIndex] mShouldShowActionFloatView=", Boolean.valueOf(paramBoolean2), ", refreshByGetUserAction=", Boolean.valueOf(paramBoolean1) });
    }
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("apollo_sp");
    ((StringBuilder)localObject2).append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin());
    localObject1 = ((BaseApplication)localObject1).getSharedPreferences(((StringBuilder)localObject2).toString(), 0);
    if (!paramBoolean1)
    {
      this.jdField_a_of_type_Int = -1;
      if (((ApolloManagerServiceImpl)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IApolloManagerService.class, "all")).mIsBubbleTab)
      {
        k = ((SharedPreferences)localObject1).getInt("key_panel_bubble_tab", -1);
        j = paramList1.size();
        i = 0;
        while (i < j)
        {
          localObject2 = (ApolloActionPackage)paramList1.get(i);
          if ((localObject2 != null) && (((ApolloActionPackage)localObject2).packageId == k))
          {
            bool = true;
            j = i;
            break label205;
          }
          i += 1;
        }
        bool = false;
        j = 0;
        label205:
        paramBoolean1 = bool;
        i = j;
        if (QLog.isColorLevel())
        {
          QLog.d("[cmshow]Panel2DStrategy", 2, new Object[] { "[setCurrentIndex] bubble pakcageId:", Integer.valueOf(k) });
          paramBoolean1 = bool;
          i = j;
        }
      }
      else
      {
        paramBoolean1 = false;
        i = 0;
      }
      boolean bool = paramBoolean1;
      m = i;
      if (!paramBoolean1)
      {
        bool = paramBoolean1;
        m = i;
        if (paramBoolean2)
        {
          k = paramList1.size();
          j = 0;
          for (;;)
          {
            bool = paramBoolean1;
            m = i;
            if (j >= k) {
              break;
            }
            localObject2 = (ApolloActionPackage)paramList1.get(j);
            if ((localObject2 != null) && (((ApolloActionPackage)localObject2).isUpdate) && (NetConnInfoCenter.getServerTimeMillis() >= ((ApolloActionPackage)localObject2).redStartTime))
            {
              bool = true;
              m = j;
              break;
            }
            j += 1;
          }
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("[cmshow]Panel2DStrategy", 2, new Object[] { "[setCurrentIndex] hasNewAction=", Boolean.valueOf(bool), ", tabIndex=", Integer.valueOf(m) });
      }
      if ((bool) && (m < paramList.size()))
      {
        k = a(paramList, m);
        this.jdField_a_of_type_Int = m;
        if (QLog.isColorLevel()) {
          QLog.d("[cmshow]Panel2DStrategy", 2, new Object[] { "[setCurrentIndex] hasNewAction, pagerIndex=", Integer.valueOf(k) });
        }
        m = 1;
        break label475;
      }
    }
    int k = 1;
    int m = 0;
    label475:
    int i = 0;
    int i2 = 0;
    while (i < paramList.size())
    {
      i2 += ((ApolloViewBinder)paramList.get(i)).a();
      i += 1;
    }
    int j = k;
    i = m;
    if (m == 0)
    {
      int n = k;
      int i1 = m;
      if (this.jdField_a_of_type_Int >= 0)
      {
        n = k;
        i1 = m;
        if (this.jdField_a_of_type_Int < paramList.size())
        {
          n = a(paramList, this.jdField_a_of_type_Int);
          i1 = 1;
        }
      }
      j = n;
      i = i1;
      if (i1 == 0)
      {
        j = n;
        i = i1;
        if (((SharedPreferences)localObject1).contains("sp_key_apollo_current_page_index"))
        {
          localObject1 = ((SharedPreferences)localObject1).getString("sp_key_apollo_current_page_index", null);
          j = n;
          i = i1;
          if (!TextUtils.isEmpty((CharSequence)localObject1)) {
            try
            {
              k = Integer.parseInt((String)localObject1);
              j = n;
              i = i1;
              if (k < i2)
              {
                try
                {
                  if (QLog.isColorLevel()) {
                    QLog.d("[cmshow]Panel2DStrategy", 2, new Object[] { "[setCurrentIndex] from previous saved, pagerIndex=", Integer.valueOf(k) });
                  }
                  j = k;
                  i = 1;
                }
                catch (Exception localException1)
                {
                  j = k;
                  i = 1;
                }
                QLog.e("[cmshow]Panel2DStrategy", 1, "parse previousSavedPagerIndexStr error", localException2);
              }
            }
            catch (Exception localException2)
            {
              i = i1;
              j = n;
            }
          }
        }
      }
    }
    if (i == 0)
    {
      m = paramList1.size();
      k = 0;
      while (k < m)
      {
        ApolloActionPackage localApolloActionPackage = (ApolloActionPackage)paramList1.get(k);
        if ((localApolloActionPackage != null) && (localApolloActionPackage.packageId == 0)) {
          break label801;
        }
        k += 1;
      }
      k = 0;
      label801:
      if (k < paramList.size())
      {
        i = a(paramList, k);
        if (QLog.isColorLevel()) {
          QLog.d("[cmshow]Panel2DStrategy", 2, new Object[] { "[setCurrentIndex] default single action, pagerIndex=", Integer.valueOf(i) });
        }
        j = 1;
        break label868;
      }
    }
    k = j;
    j = i;
    i = k;
    label868:
    if (j == 0) {
      i = 1;
    }
    if (i < i2)
    {
      ApolloPanel.jdField_a_of_type_Int = i;
      if (QLog.isColorLevel()) {
        QLog.d("[cmshow]Panel2DStrategy", 2, new Object[] { "[setCurrentIndex] sCurrentIndex= ", Integer.valueOf(ApolloPanel.jdField_a_of_type_Int) });
      }
    }
  }
  
  public boolean a(int paramInt)
  {
    return ApolloActionPackage.is3DPackage(paramInt) ^ true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.aio.panel.Panel2DStrategy
 * JD-Core Version:    0.7.0.1
 */