package com.tencent.biz.pubaccount.readinjoy.decoupling.accesslayer.data;

import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.report.RIJFrameworkReportManager;
import com.tencent.biz.pubaccount.readinjoy.skin.ReadInJoyRefreshManager;
import com.tencent.biz.pubaccount.readinjoy.skin.ReadInJoySkinManager;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.utils.SharedPreUtils;

class RIJDataFetchManager$4
  implements Runnable
{
  RIJDataFetchManager$4(RIJDataFetchManager paramRIJDataFetchManager) {}
  
  public void run()
  {
    Object localObject = "0";
    boolean bool;
    String str;
    label107:
    int i;
    int j;
    label133:
    int k;
    if (!this.this$0.d()) {
      if ((RIJDataFetchManager.a(this.this$0).a() instanceof BaseActivity))
      {
        bool = SharedPreUtils.t(RIJDataFetchManager.a(this.this$0).a(), ((BaseActivity)RIJDataFetchManager.a(this.this$0).a()).getCurrentAccountUin());
        if ((RIJDataFetchManager.a(this.this$0).a() instanceof BaseActivity))
        {
          str = ((ReadInJoySkinManager)((BaseActivity)RIJDataFetchManager.a(this.this$0).a()).app.getManager(QQManagerFactory.READ_INJOY_SKIN_MANAGER)).a();
          if ((TextUtils.isEmpty(str)) || (str.equals("0")))
          {
            i = 0;
            str = "0";
            j = 0;
            k = i;
            localObject = str;
            m = j;
            if ((RIJDataFetchManager.a(this.this$0).a() instanceof BaseActivity))
            {
              ReadInJoyRefreshManager localReadInJoyRefreshManager = (ReadInJoyRefreshManager)((BaseActivity)RIJDataFetchManager.a(this.this$0).a()).app.getManager(QQManagerFactory.READ_INJOY_REFRESH_MANAGER);
              k = i;
              localObject = str;
              m = j;
              if (localReadInJoyRefreshManager.a() == 1)
              {
                k = i;
                localObject = str;
                m = j;
                if (localReadInJoyRefreshManager.b())
                {
                  localObject = localReadInJoyRefreshManager.a();
                  k = 2;
                }
              }
            }
          }
        }
      }
    }
    for (int m = 0;; m = 0)
    {
      RIJFrameworkReportManager.a(RIJDataFetchManager.a(this.this$0).d(), m, (String)localObject, k);
      return;
      if (bool)
      {
        i = 1;
        j = 1;
        break label133;
      }
      i = 1;
      j = 2;
      break label133;
      str = "0";
      break label107;
      bool = false;
      break;
      k = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.decoupling.accesslayer.data.RIJDataFetchManager.4
 * JD-Core Version:    0.7.0.1
 */