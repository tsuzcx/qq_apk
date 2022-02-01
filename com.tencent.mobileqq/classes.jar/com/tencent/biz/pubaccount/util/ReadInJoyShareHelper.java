package com.tencent.biz.pubaccount.util;

import android.app.Activity;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.biz.pubaccount.readinjoy.view.FontSizePanel;
import com.tencent.biz.qrcode.util.QRUtils;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItemViewHolder;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.WeakReferenceHandler;
import com.tencent.widget.RangeButtonView.OnChangeListener;
import dov.com.tencent.biz.qqstory.takevideo.EditPicActivity;

@Deprecated
public class ReadInJoyShareHelper
  implements Handler.Callback, AdapterView.OnItemClickListener
{
  private int jdField_a_of_type_Int = -1;
  public Activity a;
  private FontSizePanel jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFontSizePanel = null;
  private ReadInJoyShareHelper.BaseSheetItemClickProcessor jdField_a_of_type_ComTencentBizPubaccountUtilReadInJoyShareHelper$BaseSheetItemClickProcessor;
  private ReadInJoyShareHelper.OnFontSizeChangeListener jdField_a_of_type_ComTencentBizPubaccountUtilReadInJoyShareHelper$OnFontSizeChangeListener;
  protected ReadInJoyShareHelper.ReadInJoyDefaultSheetItemSuppiler a;
  public ShareActionSheetBuilder a;
  private WeakReferenceHandler jdField_a_of_type_ComTencentUtilWeakReferenceHandler;
  private RangeButtonView.OnChangeListener jdField_a_of_type_ComTencentWidgetRangeButtonView$OnChangeListener = new ReadInJoyShareHelper.2(this);
  
  public void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      QRUtils.a(1, 2131695248);
      return;
    }
    paramString = EditPicActivity.a(this.jdField_a_of_type_AndroidAppActivity, paramString, true, true, true, true, true, 4);
    this.jdField_a_of_type_AndroidAppActivity.startActivity(paramString);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return true;
      if (paramMessage.obj != null) {
        a((String)paramMessage.obj);
      }
    }
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    Object localObject = paramView.getTag();
    boolean bool;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder().append("onItemClick, tag = ");
      if (localObject != null)
      {
        bool = true;
        QLog.d("ReadInJoyShareHelper", 2, bool);
      }
    }
    else
    {
      if (localObject != null) {
        break label73;
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
      return;
      bool = false;
      break;
      label73:
      this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.dismiss();
      localObject = (ReadInJoyShareHelper.ReadInjoyActionItem)((ShareActionSheetBuilder.ActionSheetItemViewHolder)localObject).a;
      int i = ((ReadInJoyShareHelper.ReadInjoyActionItem)localObject).action;
      if (this.jdField_a_of_type_ComTencentBizPubaccountUtilReadInJoyShareHelper$BaseSheetItemClickProcessor != null) {
        if (((ReadInJoyShareHelper.ReadInjoyActionItem)localObject).a)
        {
          this.jdField_a_of_type_ComTencentBizPubaccountUtilReadInJoyShareHelper$BaseSheetItemClickProcessor.a(Integer.valueOf(i));
        }
        else
        {
          localObject = this.jdField_a_of_type_ComTencentBizPubaccountUtilReadInJoyShareHelper$ReadInJoyDefaultSheetItemSuppiler.a(i);
          if (localObject != null) {
            this.jdField_a_of_type_ComTencentBizPubaccountUtilReadInJoyShareHelper$BaseSheetItemClickProcessor.a((Integer)localObject);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.util.ReadInJoyShareHelper
 * JD-Core Version:    0.7.0.1
 */