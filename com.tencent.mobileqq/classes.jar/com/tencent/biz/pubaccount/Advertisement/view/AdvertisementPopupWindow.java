package com.tencent.biz.pubaccount.Advertisement.view;

import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.PopupWindow;
import com.tencent.biz.pubaccount.Advertisement.data.AdvertisementItem;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.imaxad.inject.ImaxadThirdProcessorProxy;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class AdvertisementPopupWindow
  extends PopupWindow
  implements View.OnClickListener
{
  public ImaxadThirdProcessorProxy a;
  private AppInterface b;
  private AdvertisementItem c;
  
  public void onClick(View paramView)
  {
    QQToast.makeText(BaseApplication.getContext(), 0, 2131892901, 0).show(BaseApplication.getContext().getResources().getDimensionPixelSize(2131299920));
    dismiss();
    this.a.a(this.b, 3, this.c);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.Advertisement.view.AdvertisementPopupWindow
 * JD-Core Version:    0.7.0.1
 */