package com.tencent.biz.pubaccount.readinjoy.view;

import android.text.TextUtils;
import bhsi;
import bnrf;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import ocd;
import odr;
import ozs;
import paa;
import qtq;
import qtw;

class ReadInJoyListViewGroup$32
  implements Runnable
{
  ReadInJoyListViewGroup$32(ReadInJoyListViewGroup paramReadInJoyListViewGroup) {}
  
  public void run()
  {
    int m = 0;
    Object localObject2 = "0";
    int k = 0;
    if (!ReadInJoyListViewGroup.a(this.this$0)) {
      if (!(this.this$0.a() instanceof BaseActivity)) {
        break label376;
      }
    }
    label357:
    label376:
    for (boolean bool = bhsi.u(this.this$0.getContext(), ((BaseActivity)this.this$0.a()).getCurrentAccountUin());; bool = false)
    {
      if ((this.this$0.getContext() instanceof BaseActivity)) {}
      for (Object localObject1 = ((qtw)((BaseActivity)this.this$0.getContext()).app.getManager(261)).a();; localObject1 = "0")
      {
        int i;
        if ((TextUtils.isEmpty((CharSequence)localObject1)) || (((String)localObject1).equals("0")))
        {
          j = 0;
          localObject1 = "0";
          i = 0;
          k = i;
          localObject2 = localObject1;
          m = j;
          if (!(this.this$0.getContext() instanceof BaseActivity)) {
            break label357;
          }
          qtq localqtq = (qtq)((BaseActivity)this.this$0.getContext()).app.getManager(270);
          k = i;
          localObject2 = localObject1;
          m = j;
          if (localqtq.a() != 1) {
            break label357;
          }
          k = i;
          localObject2 = localObject1;
          m = j;
          if (!localqtq.b()) {
            break label357;
          }
          localObject1 = localqtq.a();
          i = 0;
        }
        for (int j = 2;; j = k)
        {
          if (this.this$0.a == 40677)
          {
            ocd.a(null, "CliOper", "", "", "0X8009294", "0X8009294", 0, 0, bnrf.a("default_feeds_proteus_offline_bid"), "", "", ozs.a(this.this$0.a, (String)localObject1, i, j, false, -1).a(), false);
            ocd.a("0X8009294", "", "", "", "", ozs.b(this.this$0.a));
          }
          if (this.this$0.a == 56) {
            ocd.a(null, "", "0X8007413", "0X8007413", 0, 0, "", "1", "", odr.a(this.this$0.a, null), false);
          }
          return;
          if (bool)
          {
            i = 1;
            j = 1;
            break;
          }
          i = 1;
          j = 2;
          break;
          localObject1 = localObject2;
          i = m;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyListViewGroup.32
 * JD-Core Version:    0.7.0.1
 */