package com.tencent.mobileqq.activity.contacts.mayknow;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.contacts.base.HeadViewScrollListener;
import com.tencent.mobileqq.activity.contacts.base.tabs.ContactsBaseFragment;
import com.tencent.mobileqq.activity.contacts.base.tabs.ContactsBaseFragment.RefreshDataListener;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.MayknowRecommendManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XListView;
import java.util.List;

public class RecommendFriendFragment
  extends ContactsBaseFragment
  implements HeadViewScrollListener
{
  protected int a;
  View jdField_a_of_type_AndroidViewView;
  RecommendsAdapter jdField_a_of_type_ComTencentMobileqqActivityContactsMayknowRecommendsAdapter;
  FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new RecommendFriendFragment.1(this);
  XListView jdField_a_of_type_ComTencentWidgetXListView;
  protected Runnable a;
  protected int b;
  protected Runnable b;
  View c;
  protected Runnable c;
  
  public RecommendFriendFragment()
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_b_of_type_Int = -1;
    this.jdField_a_of_type_JavaLangRunnable = new RecommendFriendFragment.2(this);
    this.jdField_b_of_type_JavaLangRunnable = new RecommendFriendFragment.3(this);
    this.jdField_c_of_type_JavaLangRunnable = new RecommendFriendFragment.4(this);
  }
  
  private boolean a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactsMayknowRecommendsAdapter != null) {
      return this.jdField_a_of_type_ComTencentMobileqqActivityContactsMayknowRecommendsAdapter.isEmpty();
    }
    return false;
  }
  
  private void h()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactsMayknowRecommendsAdapter != null)
    {
      Object localObject = (MayknowRecommendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.MAYKNOW_RECOMMEND_MANAGER);
      if (localObject != null)
      {
        ((MayknowRecommendManager)localObject).a(3);
        localObject = ((MayknowRecommendManager)localObject).c();
        this.jdField_a_of_type_ComTencentMobileqqActivityContactsMayknowRecommendsAdapter.a((List)localObject);
        this.jdField_c_of_type_AndroidViewView.removeCallbacks(this.jdField_c_of_type_JavaLangRunnable);
        this.jdField_c_of_type_AndroidViewView.postDelayed(this.jdField_c_of_type_JavaLangRunnable, 100L);
      }
      if (QLog.isColorLevel()) {
        QLog.d("RecommendFriendFragment", 2, "loadAndUpdateData size:" + this.jdField_a_of_type_ComTencentMobileqqActivityContactsMayknowRecommendsAdapter.getCount() + "  uin:" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      }
    }
  }
  
  public View a()
  {
    return this.jdField_a_of_type_ComTencentWidgetXListView;
  }
  
  public View a(LayoutInflater paramLayoutInflater, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RecommendFriendFragment", 2, "getView mListView=" + this.jdField_a_of_type_ComTencentWidgetXListView);
    }
    if (this.jdField_a_of_type_AndroidViewView == null)
    {
      this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity).inflate(2131559038, null, false);
      this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)this.jdField_a_of_type_AndroidViewView.findViewById(2131376771));
      this.jdField_a_of_type_ComTencentWidgetXListView.setSelector(new ColorDrawable(0));
      this.jdField_a_of_type_ComTencentWidgetXListView.setNeedCheckSpringback(true);
      this.jdField_a_of_type_ComTencentWidgetXListView.setCacheColorHint(0);
      this.jdField_a_of_type_ComTencentWidgetXListView.setDivider(null);
      this.jdField_a_of_type_ComTencentWidgetXListView.setOverScrollMode(0);
      this.jdField_a_of_type_ComTencentWidgetXListView.mForContacts = true;
      this.jdField_c_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131366314);
      paramLayoutInflater = (ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131366329);
      paramBundle = URLDrawable.URLDrawableOptions.obtain();
      paramBundle.mRequestHeight = AIOUtils.a(200.0F, BaseApplication.getContext().getResources());
      paramBundle.mRequestWidth = AIOUtils.a(145.0F, BaseApplication.getContext().getResources());
      paramBundle.mLoadingDrawable = null;
      paramBundle.mFailedDrawable = null;
      paramLayoutInflater.setImageDrawable(URLDrawable.getDrawable("https://sqimg.qq.com/qq_product_operations/nearby/recommend/recommend_empty.png", paramBundle));
    }
    for (;;)
    {
      return this.jdField_a_of_type_AndroidViewView;
      paramLayoutInflater = this.jdField_a_of_type_AndroidViewView.getParent();
      if ((paramLayoutInflater instanceof ViewGroup)) {
        ((ViewGroup)paramLayoutInflater).removeView(this.jdField_a_of_type_AndroidViewView);
      }
    }
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("RecommendFriendFragment", 2, "doOnDestroy");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactsMayknowRecommendsAdapter != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsMayknowRecommendsAdapter.a();
    }
    if (this.jdField_c_of_type_AndroidViewView != null)
    {
      this.jdField_c_of_type_AndroidViewView.removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
      this.jdField_c_of_type_AndroidViewView.removeCallbacks(this.jdField_c_of_type_JavaLangRunnable);
    }
    if (this.jdField_a_of_type_ComTencentWidgetXListView != null) {
      this.jdField_a_of_type_ComTencentWidgetXListView.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    }
    e();
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("RecommendFriendFragment", 2, "onHeadViewScrollChanged currentY:" + paramInt1 + "  maxY:" + paramInt2);
    }
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
    if ((this.jdField_c_of_type_AndroidViewView != null) && (this.jdField_c_of_type_AndroidViewView.getVisibility() == 0) && (this.jdField_c_of_type_AndroidViewView.getMeasuredHeight() > 0) && (this.jdField_a_of_type_AndroidViewView.getMeasuredHeight() > 0))
    {
      this.jdField_c_of_type_AndroidViewView.removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
      this.jdField_c_of_type_AndroidViewView.post(this.jdField_b_of_type_JavaLangRunnable);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RecommendFriendFragment", 2, "doOnResume:" + paramBoolean);
    }
    if (this.jdField_a_of_type_ComTencentWidgetXListView == null) {
      return;
    }
    d();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactsMayknowRecommendsAdapter == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsMayknowRecommendsAdapter = new RecommendsAdapter(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentWidgetXListView, 1, true);
      this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivityContactsMayknowRecommendsAdapter);
      h();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactsMayknowRecommendsAdapter != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsMayknowRecommendsAdapter.b();
    }
    a(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
  }
  
  public void ag_()
  {
    if (QLog.isColorLevel()) {
      QLog.d("RecommendFriendFragment", 2, "refresh");
    }
    h();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsContactsBaseFragment$RefreshDataListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsContactsBaseFragment$RefreshDataListener.a(b(), true, null);
    }
  }
  
  public void b(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RecommendFriendFragment", 2, "doOnPause:" + paramBoolean);
    }
    if (paramBoolean) {
      e();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactsMayknowRecommendsAdapter != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsMayknowRecommendsAdapter.d();
    }
  }
  
  public void c()
  {
    h();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactsMayknowRecommendsAdapter != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsMayknowRecommendsAdapter.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    }
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.mayknow.RecommendFriendFragment
 * JD-Core Version:    0.7.0.1
 */