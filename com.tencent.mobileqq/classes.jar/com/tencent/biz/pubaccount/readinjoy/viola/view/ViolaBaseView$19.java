package com.tencent.biz.pubaccount.readinjoy.viola.view;

import android.text.TextUtils;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.viola.utils.ViolaUtils;
import pkh;

class ViolaBaseView$19
  implements Runnable
{
  ViolaBaseView$19(ViolaBaseView paramViolaBaseView) {}
  
  public void run()
  {
    if (TextUtils.isEmpty(ViolaBaseView.b(this.this$0))) {
      return;
    }
    Object localObject = FileUtils.readObject("viola_cache_file_viola_qq_page_data_" + ViolaUtils.getPageName(this.this$0.a) + "_" + pkh.a());
    if (localObject == null) {
      FileUtils.writeObject("viola_cache_file_viola_qq_page_data_" + ViolaUtils.getPageName(this.this$0.a) + "_" + pkh.a(), ViolaBaseView.b(this.this$0));
    }
    for (;;)
    {
      ViolaBaseView.c(this.this$0, null);
      return;
      if (((localObject instanceof String)) && (!localObject.equals(ViolaBaseView.b(this.this$0)))) {
        FileUtils.writeObject("viola_cache_file_viola_qq_page_data_" + ViolaUtils.getPageName(this.this$0.a) + "_" + pkh.a(), ViolaBaseView.b(this.this$0));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.viola.view.ViolaBaseView.19
 * JD-Core Version:    0.7.0.1
 */