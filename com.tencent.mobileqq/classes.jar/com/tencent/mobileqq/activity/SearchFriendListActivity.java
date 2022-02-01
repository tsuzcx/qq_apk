package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.eqq.CrmUtils;
import com.tencent.mobileqq.activity.contact.addcontact.SearchResultItem;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.avatar.observer.AvatarObserver;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.XListView;
import java.util.ArrayList;

public class SearchFriendListActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener
{
  private SearchFriendListActivity.SearchFriendAdapter jdField_a_of_type_ComTencentMobileqqActivitySearchFriendListActivity$SearchFriendAdapter;
  private AvatarObserver jdField_a_of_type_ComTencentMobileqqAvatarObserverAvatarObserver = new SearchFriendListActivity.1(this);
  private XListView jdField_a_of_type_ComTencentWidgetXListView;
  private ArrayList<SearchResultItem> jdField_a_of_type_JavaUtilArrayList;
  
  void a(View paramView, int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= this.jdField_a_of_type_JavaUtilArrayList.size())) {}
    do
    {
      return;
      localObject2 = (SearchResultItem)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
    } while (localObject2 == null);
    Object localObject1 = ((SearchResultItem)localObject2).jdField_a_of_type_JavaLangString;
    String str1 = String.valueOf(((SearchResultItem)localObject2).jdField_a_of_type_Long);
    String str2 = ((SearchResultItem)localObject2).b;
    int i = ((SearchResultItem)localObject2).jdField_a_of_type_Int;
    Object localObject2 = (SearchFriendListActivity.ViewHolder)paramView.getTag();
    if (!TextUtils.isEmpty((CharSequence)localObject1))
    {
      ((SearchFriendListActivity.ViewHolder)localObject2).jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject1);
      if (i != 1) {
        break label194;
      }
      ((SearchFriendListActivity.ViewHolder)localObject2).jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(FaceDrawable.getUserFaceDrawable(this.app, str1, (byte)3));
      ((SearchFriendListActivity.ViewHolder)localObject2).b.setText("QQ号码: " + str1);
    }
    for (;;)
    {
      ((SearchFriendListActivity.ViewHolder)localObject2).jdField_a_of_type_Int = paramInt;
      paramView.setContentDescription(((SearchFriendListActivity.ViewHolder)localObject2).jdField_a_of_type_AndroidWidgetTextView.getText());
      return;
      TextView localTextView = ((SearchFriendListActivity.ViewHolder)localObject2).jdField_a_of_type_AndroidWidgetTextView;
      if (i == 1) {}
      for (localObject1 = str1;; localObject1 = str2)
      {
        localTextView.setText((CharSequence)localObject1);
        break;
      }
      label194:
      ((SearchFriendListActivity.ViewHolder)localObject2).jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(FaceDrawable.getMobileFaceDrawable(this.app, str2, (byte)3));
      ((SearchFriendListActivity.ViewHolder)localObject2).b.setText(HardCodeUtil.a(2131713583) + str2);
    }
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
    super.setContentView(2131562958);
    setContentBackgroundResource(2130838979);
    setTitle(HardCodeUtil.a(2131713582));
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)findViewById(2131377614));
    this.jdField_a_of_type_ComTencentWidgetXListView.setContentBackground(2130838979);
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAvatarObserverAvatarObserver);
    this.jdField_a_of_type_JavaUtilArrayList = getIntent().getParcelableArrayListExtra("param_search_result_item_list");
    if (this.jdField_a_of_type_JavaUtilArrayList == null) {
      this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    }
    this.jdField_a_of_type_ComTencentMobileqqActivitySearchFriendListActivity$SearchFriendAdapter = new SearchFriendListActivity.SearchFriendAdapter(this, null);
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivitySearchFriendListActivity$SearchFriendAdapter);
    return true;
  }
  
  public void doOnDestroy()
  {
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAvatarObserverAvatarObserver);
    super.doOnDestroy();
  }
  
  public void onClick(View paramView)
  {
    int i;
    if ((paramView.getTag() instanceof SearchFriendListActivity.ViewHolder))
    {
      i = ((SearchFriendListActivity.ViewHolder)paramView.getTag()).jdField_a_of_type_Int;
      if ((i < 0) || (i >= this.jdField_a_of_type_JavaUtilArrayList.size())) {
        break label101;
      }
    }
    label101:
    for (SearchResultItem localSearchResultItem = (SearchResultItem)this.jdField_a_of_type_JavaUtilArrayList.get(i);; localSearchResultItem = null)
    {
      if (localSearchResultItem == null) {}
      for (;;)
      {
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        if (localSearchResultItem.c == 0) {
          AddFriendActivity.a(this, localSearchResultItem, this.app, false, 1);
        } else {
          CrmUtils.a(this, null, String.valueOf(localSearchResultItem.jdField_a_of_type_Long), false, -1, true, -1);
        }
      }
    }
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.SearchFriendListActivity
 * JD-Core Version:    0.7.0.1
 */