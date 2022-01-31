package com.tencent.mobileqq.activity;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.adapter.SigCommentSessionListAdapter;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SignatureHandler;
import com.tencent.mobileqq.app.SignatureObserver;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.MqqWeakReferenceHandler;
import com.tencent.widget.XListView;
import tpp;
import tpq;
import tpr;

public class SigCommentListActivity
  extends IphoneTitleBarActivity
  implements Handler.Callback
{
  Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  View jdField_a_of_type_AndroidViewView;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  public SigCommentSessionListAdapter a;
  SignatureObserver jdField_a_of_type_ComTencentMobileqqAppSignatureObserver = new tpp(this);
  private MqqWeakReferenceHandler jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler;
  XListView jdField_a_of_type_ComTencentWidgetXListView;
  
  private void a(int paramInt)
  {
    if (paramInt == 1) {
      try
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(ColorStateList.createFromXml(getResources(), getResources().getXml(2131494262)));
        this.jdField_a_of_type_AndroidWidgetTextView.setText("正在加载互动记录...");
        this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
        this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setVisible(true, true);
        return;
      }
      catch (Exception localException1)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("SigCommentListActivity", 2, localException1.toString());
          }
        }
      }
    }
    try
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(ColorStateList.createFromXml(getResources(), getResources().getXml(2131494262)));
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setVisible(false, false);
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130845946);
      if (paramInt == 3)
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setText("暂无交互记录");
        return;
      }
    }
    catch (Exception localException2)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("SigCommentListActivity", 2, localException2.toString());
        }
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setText("加载失败，点击此处重新加载。");
    }
    try
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(ColorStateList.createFromXml(getResources(), getResources().getXml(2131494162)));
      this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(new tpq(this));
      this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new tpr(this));
      return;
    }
    catch (Exception localException3)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("SigCommentListActivity", 2, localException3.toString());
        }
      }
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    a(1);
    Object localObject;
    if (NetworkUtil.d(this))
    {
      localObject = (SignatureHandler)this.app.a(41);
      if (localObject != null) {
        ((SignatureHandler)localObject).a(paramBoolean2);
      }
    }
    for (;;)
    {
      if (paramBoolean1) {
        startTitleProgress();
      }
      return;
      localObject = this.jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler.obtainMessage(1, 1, 0);
      this.jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler.sendMessageDelayed((Message)localObject, 1000L);
      this.jdField_a_of_type_ComTencentMobileqqAdapterSigCommentSessionListAdapter.a(2131437869);
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.setContentView(2130970974);
    super.setTitle("互动记录");
    this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(this).inflate(2130971536, this.jdField_a_of_type_ComTencentWidgetXListView, false);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131365660));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131366651));
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(2130838596);
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)findViewById(2131372427));
    this.jdField_a_of_type_ComTencentWidgetXListView.setScrollbarFadingEnabled(true);
    this.jdField_a_of_type_ComTencentWidgetXListView.setDivider(null);
    this.jdField_a_of_type_ComTencentMobileqqAdapterSigCommentSessionListAdapter = new SigCommentSessionListAdapter(this, this.app, this.jdField_a_of_type_ComTencentWidgetXListView, this.jdField_a_of_type_AndroidViewView);
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqAdapterSigCommentSessionListAdapter);
    this.jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler = new MqqWeakReferenceHandler(this);
    this.app.setHandler(SigCommentListActivity.class, this.jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler);
    if (this.jdField_a_of_type_ComTencentMobileqqAppSignatureObserver != null) {
      this.app.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppSignatureObserver);
    }
    paramBundle = this.jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler.obtainMessage(0, 1, 1);
    this.jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler.sendMessageDelayed(paramBundle, 500L);
    a(1);
    return true;
  }
  
  protected void doOnDestroy()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppSignatureObserver != null)
    {
      this.app.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppSignatureObserver);
      this.jdField_a_of_type_ComTencentMobileqqAppSignatureObserver = null;
    }
    this.app.removeHandler(SigCommentListActivity.class);
    super.doOnDestroy();
  }
  
  protected void doOnPause()
  {
    super.doOnPause();
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    boolean bool2 = false;
    switch (paramMessage.what)
    {
    }
    do
    {
      return true;
      if (paramMessage.arg1 == 1) {}
      for (boolean bool1 = true;; bool1 = false)
      {
        if (paramMessage.arg2 == 1) {
          bool2 = true;
        }
        a(bool1, bool2);
        return true;
      }
      stopTitleProgress();
    } while (1 != paramMessage.arg1);
    if (isResume()) {
      QQToast.a(this, 0, getResources().getString(2131437867), 0).b(getTitleBarHeight());
    }
    a(2);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.SigCommentListActivity
 * JD-Core Version:    0.7.0.1
 */