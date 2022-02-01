package com.tencent.mobileqq.apollo.view.pannel;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.apollo.api.model.ApolloActionPackage;
import com.tencent.mobileqq.apollo.script.SpriteActionScript;
import com.tencent.mobileqq.apollo.script.SpriteUtil;
import com.tencent.mobileqq.apollo.view.pannel.viewbinder.Apollo3dActionViewBinder;
import com.tencent.mobileqq.apollo.view.pannel.viewbinder.ApolloBattleGameViewBinder;
import com.tencent.mobileqq.apollo.view.pannel.viewbinder.ApolloTagActionViewBinder;
import com.tencent.mobileqq.apollo.view.pannel.viewbinder.ApolloViewBinder;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class Panel3DStrategy
  extends PanelStrategy
{
  public Panel3DStrategy(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramContext, paramSessionInfo);
  }
  
  public ApolloViewBinder a(int paramInt)
  {
    return new Apollo3dActionViewBinder(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
  }
  
  public ApolloViewBinder a(int paramInt1, int paramInt2)
  {
    if (paramInt2 == 302) {
      return new ApolloBattleGameViewBinder(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
    }
    if ((paramInt2 == 0) || (paramInt2 == 1) || (paramInt2 == 9)) {
      return new ApolloTagActionViewBinder(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
    }
    return a(paramInt1);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("apollo_sp" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), 0).edit();
    if (paramInt1 < 0)
    {
      ((SharedPreferences.Editor)localObject).remove("sp_key_apollo_current_page_index_3d");
      ((SharedPreferences.Editor)localObject).remove("sp_key_apollo_current_page_package_id_3d");
    }
    for (;;)
    {
      ((SharedPreferences.Editor)localObject).apply();
      QLog.d("Panel3DStrategy", 1, new Object[] { "saveCurrentIndex-3D, index:", Integer.valueOf(paramInt1), ", packageId:", Integer.valueOf(paramInt2) });
      localObject = SpriteUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      if (localObject != null) {
        ((SpriteActionScript)localObject).a(String.valueOf(paramInt2));
      }
      return;
      ((SharedPreferences.Editor)localObject).putString("sp_key_apollo_current_page_index_3d", String.valueOf(paramInt1));
      ((SharedPreferences.Editor)localObject).putString("sp_key_apollo_current_page_package_id_3d", String.valueOf(paramInt2));
    }
  }
  
  public void a(List<ApolloViewBinder> paramList, List<ApolloActionPackage> paramList1, boolean paramBoolean1, boolean paramBoolean2)
  {
    int i = 0;
    int m = 0;
    while (i < paramList.size())
    {
      m += ((ApolloViewBinder)paramList.get(i)).a();
      i += 1;
    }
    i = -1;
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("apollo_sp" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), 0);
    if (((SharedPreferences)localObject).contains("sp_key_apollo_current_page_index_3d"))
    {
      localObject = ((SharedPreferences)localObject).getString("sp_key_apollo_current_page_index_3d", null);
      if (TextUtils.isEmpty((CharSequence)localObject)) {}
    }
    for (;;)
    {
      try
      {
        j = Integer.parseInt((String)localObject);
        if (j >= m) {
          continue;
        }
      }
      catch (Exception localException1)
      {
        int k;
        int n;
        j = -1;
        i = 0;
        QLog.e("Panel3DStrategy", 1, "parse previousSavedPagerIndexStr error", localException1);
        continue;
        k += 1;
        continue;
        j = 0;
        continue;
      }
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("Panel3DStrategy", 2, new Object[] { "[setCurrentIndex] from previous saved for 3d, pagerIndex=", Integer.valueOf(j) });
        }
        i = j;
        j = 1;
        k = j;
        j = i;
        i = k;
        if (i != 0) {
          continue;
        }
        n = paramList1.size();
        k = 0;
        if (k >= n) {
          continue;
        }
        localObject = (ApolloActionPackage)paramList1.get(k);
        if ((localObject == null) || (((ApolloActionPackage)localObject).packageId != 300)) {
          continue;
        }
      }
      catch (Exception localException2)
      {
        i = 1;
        continue;
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
          QLog.d("Panel3DStrategy", 2, new Object[] { "[setCurrentIndex] default single action, pagerIndex=", Integer.valueOf(i) });
        }
        j = 1;
        if (j == 0) {
          i = 1;
        }
        if (i < m)
        {
          ApolloPanel.a = i;
          if (QLog.isColorLevel()) {
            QLog.d("Panel3DStrategy", 2, new Object[] { "[setCurrentIndex] sCurrentIndex= ", Integer.valueOf(ApolloPanel.a) });
          }
        }
        return;
      }
      i = 0;
      int j = -1;
    }
  }
  
  public boolean a(int paramInt)
  {
    return (paramInt >= 100) && (paramInt != 400);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.view.pannel.Panel3DStrategy
 * JD-Core Version:    0.7.0.1
 */