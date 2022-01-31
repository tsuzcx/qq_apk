package com.tencent.biz.pubaccount.readinjoy.view;

import android.text.TextUtils;
import bbkb;
import bhvy;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import nol;
import npu;
import onh;
import ono;
import pyz;
import pzf;

class ReadInJoyListViewGroup$33
  implements Runnable
{
  ReadInJoyListViewGroup$33(ReadInJoyListViewGroup paramReadInJoyListViewGroup) {}
  
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
    for (boolean bool = bbkb.u(this.this$0.getContext(), ((BaseActivity)this.this$0.a()).getCurrentAccountUin());; bool = false)
    {
      if ((this.this$0.getContext() instanceof BaseActivity)) {}
      for (Object localObject1 = ((pzf)((BaseActivity)this.this$0.getContext()).app.getManager(261)).a();; localObject1 = "0")
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
          pyz localpyz = (pyz)((BaseActivity)this.this$0.getContext()).app.getManager(270);
          k = i;
          localObject2 = localObject1;
          m = j;
          if (localpyz.a() != 1) {
            break label357;
          }
          k = i;
          localObject2 = localObject1;
          m = j;
          if (!localpyz.b()) {
            break label357;
          }
          localObject1 = localpyz.a();
          i = 0;
        }
        for (int j = 2;; j = k)
        {
          if (this.this$0.a == 40677)
          {
            nol.a(null, "CliOper", "", "", "0X8009294", "0X8009294", 0, 0, bhvy.a("default_feeds_proteus_offline_bid"), "", "", onh.a(this.this$0.a, (String)localObject1, i, j, false, -1).a(), false);
            nol.a("0X8009294", "", "", "", "", onh.b(this.this$0.a));
          }
          if (this.this$0.a == 56) {
            nol.a(null, "", "0X8007413", "0X8007413", 0, 0, "", "1", "", npu.a(this.this$0.a, null), false);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyListViewGroup.33
 * JD-Core Version:    0.7.0.1
 */