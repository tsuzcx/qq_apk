package com.tencent.mobileqq.activity;

import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.avatar.api.IQQAvatarService;
import com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener;
import com.tencent.mobileqq.utils.DisplayUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.Switch;
import com.tencent.widget.XListView;

public class ShieldFriendsListActivity
  extends IphoneTitleBarActivity
  implements DecodeTaskCompletionListener
{
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private ShieldFriendsListActivity.ShieldFriendsAdapter jdField_a_of_type_ComTencentMobileqqActivityShieldFriendsListActivity$ShieldFriendsAdapter;
  FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new ShieldFriendsListActivity.2(this);
  private IFaceDecoder jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder;
  private XListView jdField_a_of_type_ComTencentWidgetXListView;
  
  private void a()
  {
    ThreadManager.excute(new ShieldFriendsListActivity.1(this), 16, null, true);
  }
  
  private boolean a(long paramLong, boolean paramBoolean)
  {
    int j = this.jdField_a_of_type_ComTencentWidgetXListView.getChildCount();
    int i = 0;
    while (i < j)
    {
      Object localObject = this.jdField_a_of_type_ComTencentWidgetXListView.getChildAt(i);
      if (localObject != null)
      {
        localObject = (ShieldFriendsListActivity.Holder)((View)localObject).getTag();
        if ((localObject != null) && (paramLong == Long.valueOf(((ShieldFriendsListActivity.Holder)localObject).jdField_a_of_type_JavaLangString).longValue()))
        {
          if (((ShieldFriendsListActivity.Holder)localObject).jdField_a_of_type_ComTencentWidgetSwitch.isChecked() != paramBoolean)
          {
            ((ShieldFriendsListActivity.Holder)localObject).jdField_a_of_type_ComTencentWidgetSwitch.setOnCheckedChangeListener(null);
            ((ShieldFriendsListActivity.Holder)localObject).jdField_a_of_type_ComTencentWidgetSwitch.setChecked(paramBoolean);
            ((ShieldFriendsListActivity.Holder)localObject).jdField_a_of_type_ComTencentWidgetSwitch.setOnCheckedChangeListener(((ShieldFriendsListActivity.Holder)localObject).jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
          }
          return true;
        }
      }
      i += 1;
    }
    return false;
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityShieldFriendsListActivity$ShieldFriendsAdapter.getCount() <= 0)
    {
      this.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      return;
    }
    this.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentView(2131561644);
    super.setTitle(2131699168);
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)super.findViewById(2131370493));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131367045));
    this.jdField_a_of_type_AndroidWidgetTextView.setText(2131699169);
    this.jdField_a_of_type_AndroidWidgetTextView.setBackgroundDrawable(null);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(2, 17.0F);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(getResources().getColor(2131167234));
    paramBundle = new RelativeLayout.LayoutParams(-2, -2);
    paramBundle.addRule(13);
    this.jdField_a_of_type_AndroidWidgetTextView.setLayoutParams(paramBundle);
    this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder = ((IQQAvatarService)this.app.getRuntimeService(IQQAvatarService.class, "")).getInstance(this.app);
    this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.setDecodeTaskCompletionListener(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityShieldFriendsListActivity$ShieldFriendsAdapter = new ShieldFriendsListActivity.ShieldFriendsAdapter(this, this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder, this.app);
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivityShieldFriendsListActivity$ShieldFriendsAdapter);
    paramBundle = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentWidgetXListView.getLayoutParams();
    paramBundle.topMargin = ((int)DisplayUtils.a(this, 12.0F));
    this.jdField_a_of_type_ComTencentWidgetXListView.setLayoutParams(paramBundle);
    a();
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    if (AppSetting.d) {
      this.leftView.setContentDescription(HardCodeUtil.a(2131713944));
    }
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    if (this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.destory();
    }
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShieldFriendsListActivity", 2, "uin=" + paramString + ", type=" + paramInt2 + ",avatar= " + paramBitmap);
    }
    if (paramBitmap == null) {}
    for (;;)
    {
      return;
      paramInt2 = this.jdField_a_of_type_ComTencentWidgetXListView.getChildCount();
      paramInt1 = 0;
      while (paramInt1 < paramInt2)
      {
        Object localObject = this.jdField_a_of_type_ComTencentWidgetXListView.getChildAt(paramInt1);
        if (localObject != null)
        {
          localObject = (ShieldFriendsListActivity.Holder)((View)localObject).getTag();
          if ((localObject != null) && (!TextUtils.isEmpty(paramString)) && (paramString.equals(((ShieldFriendsListActivity.Holder)localObject).jdField_a_of_type_JavaLangString)))
          {
            ((ShieldFriendsListActivity.Holder)localObject).jdField_a_of_type_ComTencentImageURLImageView.setBackgroundDrawable(new BitmapDrawable(paramBitmap));
            return;
          }
        }
        paramInt1 += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ShieldFriendsListActivity
 * JD-Core Version:    0.7.0.1
 */