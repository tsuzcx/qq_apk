package com.tencent.biz.pubaccount.Advertisement.view;

import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.PopupWindow;
import com.tencent.biz.pubaccount.Advertisement.data.AdvertisementItem;
import com.tencent.biz.pubaccount.Advertisement.manager.AdvertisementRecentUserManager;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;

public class AdvertisementPopupWindow
  extends PopupWindow
  implements View.OnClickListener
{
  private AdvertisementItem jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataAdvertisementItem;
  private AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  
  public void onClick(View paramView)
  {
    QQToast.a(BaseApplication.getContext(), 0, 2131438684, 0).b(BaseApplication.getContext().getResources().getDimensionPixelSize(2131558448));
    dismiss();
    AdvertisementRecentUserManager.a().a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, 3, this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataAdvertisementItem);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.Advertisement.view.AdvertisementPopupWindow
 * JD-Core Version:    0.7.0.1
 */