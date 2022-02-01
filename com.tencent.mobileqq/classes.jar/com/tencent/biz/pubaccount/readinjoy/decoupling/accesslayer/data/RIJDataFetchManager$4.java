package com.tencent.biz.pubaccount.readinjoy.decoupling.accesslayer.data;

import android.text.TextUtils;
import bhhr;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import pmz;
import pnb;
import pqb;
import rmu;
import rna;

public class RIJDataFetchManager$4
  implements Runnable
{
  public RIJDataFetchManager$4(pmz parampmz) {}
  
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
      if ((pmz.a(this.this$0).a() instanceof BaseActivity))
      {
        bool = bhhr.t(pmz.a(this.this$0).a(), ((BaseActivity)pmz.a(this.this$0).a()).getCurrentAccountUin());
        if ((pmz.a(this.this$0).a() instanceof BaseActivity))
        {
          str = ((rna)((BaseActivity)pmz.a(this.this$0).a()).app.getManager(QQManagerFactory.READ_INJOY_SKIN_MANAGER)).a();
          if ((TextUtils.isEmpty(str)) || (str.equals("0")))
          {
            i = 0;
            str = "0";
            j = 0;
            k = i;
            localObject = str;
            m = j;
            if ((pmz.a(this.this$0).a() instanceof BaseActivity))
            {
              rmu localrmu = (rmu)((BaseActivity)pmz.a(this.this$0).a()).app.getManager(QQManagerFactory.READ_INJOY_REFRESH_MANAGER);
              k = i;
              localObject = str;
              m = j;
              if (localrmu.a() == 1)
              {
                k = i;
                localObject = str;
                m = j;
                if (localrmu.b())
                {
                  localObject = localrmu.a();
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
      pqb.a(pmz.a(this.this$0).d(), m, (String)localObject, k);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.decoupling.accesslayer.data.RIJDataFetchManager.4
 * JD-Core Version:    0.7.0.1
 */