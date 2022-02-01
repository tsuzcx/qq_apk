import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.apollo.view.pannel.ApolloPanel;
import com.tencent.mobileqq.apollo.view.pannel.ApolloPanel.32.1;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ApolloActionPackage;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import mqq.os.MqqHandler;

public class anou
  implements anpr
{
  public anou(ApolloPanel paramApolloPanel) {}
  
  public anqh a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return new anps(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mContext, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
    }
    if (amme.c("gamePanelSwitch") != 1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloPanel", 2, "loadPanel gameSwitch is 0 return null");
      }
      return null;
    }
    return new anpu(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mContext, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie);
  }
  
  public void a()
  {
    ApolloPanel.a(this.a).post(new ApolloPanel.32.1(this));
  }
  
  public void a(int paramInt)
  {
    SharedPreferences.Editor localEditor = this.a.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app.getApp().getSharedPreferences("apollo_sp" + this.a.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app.getCurrentUin(), 0).edit();
    if (paramInt < 0) {
      localEditor.remove("sp_key_apollo_current_page_index_3d");
    }
    for (;;)
    {
      localEditor.apply();
      return;
      localEditor.putString("sp_key_apollo_current_page_index_3d", String.valueOf(paramInt));
    }
  }
  
  public void a(List<anqh> paramList, List<ApolloActionPackage> paramList1, boolean paramBoolean)
  {
    int i = 0;
    int m = 0;
    while (i < paramList.size())
    {
      m += ((anqh)paramList.get(i)).a();
      i += 1;
    }
    i = -1;
    Object localObject = this.a.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app.getApp().getSharedPreferences("apollo_sp" + this.a.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app.getCurrentUin(), 0);
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
        QLog.e("ApolloPanel", 1, "parse previousSavedPagerIndexStr error", localException1);
        continue;
        k += 1;
        continue;
        j = 0;
        continue;
      }
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("ApolloPanel", 2, new Object[] { "[setCurrentIndex] from previous saved for 3d, pagerIndex=", Integer.valueOf(j) });
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
        i = ApolloPanel.a(this.a, paramList, k);
        if (QLog.isColorLevel()) {
          QLog.d("ApolloPanel", 2, new Object[] { "[setCurrentIndex] default single action, pagerIndex=", Integer.valueOf(i) });
        }
        j = 1;
        if (j == 0) {
          i = 1;
        }
        if (i < m)
        {
          ApolloPanel.jdField_a_of_type_Int = i;
          if (QLog.isColorLevel()) {
            QLog.d("ApolloPanel", 2, new Object[] { "[setCurrentIndex] sCurrentIndex= ", Integer.valueOf(ApolloPanel.jdField_a_of_type_Int) });
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anou
 * JD-Core Version:    0.7.0.1
 */