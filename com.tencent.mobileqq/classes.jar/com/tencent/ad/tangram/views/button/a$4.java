package com.tencent.ad.tangram.views.button;

import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.ad.tangram.web.AdBrowser;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.lang.ref.WeakReference;

class a$4
  implements View.OnClickListener
{
  a$4(a parama) {}
  
  public void onClick(View paramView)
  {
    if (!TextUtils.isEmpty(a.access$200(this.this$0).rightInfoUrl)) {
      AdBrowser.showWithoutAd(new WeakReference(this.this$0.getActivity()), a.access$200(this.this$0).rightInfoUrl, null);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ad.tangram.views.button.a.4
 * JD-Core Version:    0.7.0.1
 */