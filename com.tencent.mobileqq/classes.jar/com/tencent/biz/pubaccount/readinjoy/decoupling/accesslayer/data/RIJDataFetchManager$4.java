package com.tencent.biz.pubaccount.readinjoy.decoupling.accesslayer.data;

import android.text.TextUtils;
import bfyz;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import pdy;
import pea;
import pgw;
import rao;
import rau;

public class RIJDataFetchManager$4
  implements Runnable
{
  public RIJDataFetchManager$4(pdy parampdy) {}
  
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
      if ((pdy.a(this.this$0).a() instanceof BaseActivity))
      {
        bool = bfyz.t(pdy.a(this.this$0).a(), ((BaseActivity)pdy.a(this.this$0).a()).getCurrentAccountUin());
        if ((pdy.a(this.this$0).a() instanceof BaseActivity))
        {
          str = ((rau)((BaseActivity)pdy.a(this.this$0).a()).app.getManager(261)).a();
          if ((TextUtils.isEmpty(str)) || (str.equals("0")))
          {
            i = 0;
            str = "0";
            j = 0;
            k = i;
            localObject = str;
            m = j;
            if ((pdy.a(this.this$0).a() instanceof BaseActivity))
            {
              rao localrao = (rao)((BaseActivity)pdy.a(this.this$0).a()).app.getManager(270);
              k = i;
              localObject = str;
              m = j;
              if (localrao.a() == 1)
              {
                k = i;
                localObject = str;
                m = j;
                if (localrao.b())
                {
                  localObject = localrao.a();
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
      pgw.a(pdy.a(this.this$0).d(), m, (String)localObject, k);
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