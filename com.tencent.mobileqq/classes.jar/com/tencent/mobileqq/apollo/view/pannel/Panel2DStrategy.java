package com.tencent.mobileqq.apollo.view.pannel;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.apollo.api.IApolloManagerService;
import com.tencent.mobileqq.apollo.api.impl.ApolloManagerServiceImpl;
import com.tencent.mobileqq.apollo.api.model.ApolloActionPackage;
import com.tencent.mobileqq.apollo.script.SpriteActionScript;
import com.tencent.mobileqq.apollo.script.SpriteUtil;
import com.tencent.mobileqq.apollo.view.pannel.viewbinder.ApolloBattleGameViewBinder;
import com.tencent.mobileqq.apollo.view.pannel.viewbinder.ApolloFavViewBinder;
import com.tencent.mobileqq.apollo.view.pannel.viewbinder.ApolloSecondaryViewBinder;
import com.tencent.mobileqq.apollo.view.pannel.viewbinder.ApolloSlaveViewBinder;
import com.tencent.mobileqq.apollo.view.pannel.viewbinder.ApolloTagActionViewBinder;
import com.tencent.mobileqq.apollo.view.pannel.viewbinder.ApolloViewBinder;
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
    switch (paramInt)
    {
    case 1: 
    case 3: 
    default: 
      return new ApolloSecondaryViewBinder(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
    case 0: 
      return new ApolloSecondaryViewBinder(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
    case 2: 
      return new ApolloFavViewBinder(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
    }
    return new ApolloSlaveViewBinder(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
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
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("apollo_sp" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), 0).edit();
    if (paramInt1 < 0)
    {
      ((SharedPreferences.Editor)localObject).remove("sp_key_apollo_current_page_index");
      ((SharedPreferences.Editor)localObject).remove("sp_key_apollo_current_page_package_id_2d");
    }
    for (;;)
    {
      ((SharedPreferences.Editor)localObject).apply();
      QLog.d("Panel2DStrategy", 1, new Object[] { "saveCurrentIndex-2D, index:", Integer.valueOf(paramInt1), ", packageId:", Integer.valueOf(paramInt2) });
      localObject = SpriteUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      if (localObject != null) {
        ((SpriteActionScript)localObject).a(String.valueOf(paramInt2));
      }
      return;
      ((SharedPreferences.Editor)localObject).putString("sp_key_apollo_current_page_index", String.valueOf(paramInt1));
      ((SharedPreferences.Editor)localObject).putString("sp_key_apollo_current_page_package_id_2d", String.valueOf(paramInt2));
    }
  }
  
  public void a(List<ApolloViewBinder> paramList, List<ApolloActionPackage> paramList1, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Panel2DStrategy", 2, new Object[] { "[setCurrentIndex] mShouldShowActionFloatView=", Boolean.valueOf(paramBoolean2), ", refreshByGetUserAction=", Boolean.valueOf(paramBoolean1) });
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("apollo_sp" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), 0);
    int i;
    int j;
    int k;
    ApolloActionPackage localApolloActionPackage;
    if (!paramBoolean1)
    {
      paramBoolean1 = false;
      i = 0;
      this.jdField_a_of_type_Int = -1;
      if (((ApolloManagerServiceImpl)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IApolloManagerService.class, "all")).mIsBubbleTab)
      {
        j = ((SharedPreferences)localObject).getInt("key_panel_bubble_tab", -1);
        i = 0;
        k = paramList1.size();
        if (i >= k) {
          break label872;
        }
        localApolloActionPackage = (ApolloActionPackage)paramList1.get(i);
        if ((localApolloActionPackage == null) || (localApolloActionPackage.packageId != j)) {
          break label437;
        }
      }
    }
    for (paramBoolean1 = true;; paramBoolean1 = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Panel2DStrategy", 2, new Object[] { "[setCurrentIndex] bubble pakcageId:", Integer.valueOf(j) });
      }
      if ((!paramBoolean1) && (paramBoolean2))
      {
        j = 0;
        k = paramList1.size();
        label222:
        if (j < k)
        {
          localApolloActionPackage = (ApolloActionPackage)paramList1.get(j);
          if ((localApolloActionPackage != null) && (localApolloActionPackage.isUpdate) && (NetConnInfoCenter.getServerTimeMillis() >= localApolloActionPackage.redStartTime))
          {
            paramBoolean1 = true;
            i = j;
          }
        }
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Panel2DStrategy", 2, new Object[] { "[setCurrentIndex] hasNewAction=", Boolean.valueOf(paramBoolean1), ", tabIndex=", Integer.valueOf(i) });
        }
        int m;
        if ((paramBoolean1) && (i < paramList.size()))
        {
          k = a(paramList, i);
          m = 1;
          this.jdField_a_of_type_Int = i;
          j = m;
          i = k;
          if (QLog.isColorLevel())
          {
            QLog.d("Panel2DStrategy", 2, new Object[] { "[setCurrentIndex] hasNewAction, pagerIndex=", Integer.valueOf(k) });
            i = k;
            j = m;
          }
        }
        for (;;)
        {
          int n = 0;
          k = 0;
          for (;;)
          {
            if (k < paramList.size())
            {
              n += ((ApolloViewBinder)paramList.get(k)).a();
              k += 1;
              continue;
              label437:
              i += 1;
              break;
              j += 1;
              break label222;
            }
          }
          m = j;
          k = i;
          if (j == 0)
          {
            if ((this.jdField_a_of_type_Int < 0) || (this.jdField_a_of_type_Int >= paramList.size())) {
              break label857;
            }
            i = a(paramList, this.jdField_a_of_type_Int);
            j = 1;
          }
          label801:
          label818:
          label833:
          label839:
          label857:
          for (;;)
          {
            if ((j == 0) && (((SharedPreferences)localObject).contains("sp_key_apollo_current_page_index")))
            {
              localObject = ((SharedPreferences)localObject).getString("sp_key_apollo_current_page_index", null);
              if (TextUtils.isEmpty((CharSequence)localObject)) {}
            }
            for (;;)
            {
              try
              {
                k = Integer.parseInt((String)localObject);
                if (k >= n) {
                  break label839;
                }
                m = 1;
                j = m;
                i = k;
              }
              catch (Exception localException1)
              {
                k = i;
                i = j;
              }
              try
              {
                if (QLog.isColorLevel())
                {
                  QLog.d("Panel2DStrategy", 2, new Object[] { "[setCurrentIndex] from previous saved, pagerIndex=", Integer.valueOf(k) });
                  i = k;
                  j = m;
                }
                k = j;
                j = i;
                i = k;
                if (i != 0) {
                  break label818;
                }
                k = 0;
                m = paramList1.size();
                if (k >= m) {
                  break label833;
                }
                localObject = (ApolloActionPackage)paramList1.get(k);
                if ((localObject == null) || (((ApolloActionPackage)localObject).packageId != 0)) {
                  break label801;
                }
              }
              catch (Exception localException2)
              {
                for (;;)
                {
                  i = 1;
                }
                k = i;
                i = j;
                j = k;
                continue;
                k = 0;
                continue;
              }
              if (k < paramList.size())
              {
                i = a(paramList, k);
                if (QLog.isColorLevel()) {
                  QLog.d("Panel2DStrategy", 2, new Object[] { "[setCurrentIndex] default single action, pagerIndex=", Integer.valueOf(i) });
                }
                j = 1;
                if (j == 0) {
                  i = 1;
                }
                if (i < n)
                {
                  ApolloPanel.jdField_a_of_type_Int = i;
                  if (QLog.isColorLevel()) {
                    QLog.d("Panel2DStrategy", 2, new Object[] { "[setCurrentIndex] sCurrentIndex= ", Integer.valueOf(ApolloPanel.jdField_a_of_type_Int) });
                  }
                }
                return;
                QLog.e("Panel2DStrategy", 1, "parse previousSavedPagerIndexStr error", localException1);
                m = i;
                i = m;
                j = k;
                continue;
                k += 1;
              }
              else
              {
                continue;
                k = i;
                i = j;
                j = k;
              }
            }
          }
          j = 0;
          i = 1;
        }
      }
      label872:
      i = 0;
    }
  }
  
  public boolean a(int paramInt)
  {
    return !ApolloActionPackage.is3DPackage(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.view.pannel.Panel2DStrategy
 * JD-Core Version:    0.7.0.1
 */