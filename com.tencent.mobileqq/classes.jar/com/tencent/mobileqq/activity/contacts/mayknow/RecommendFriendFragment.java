package com.tencent.mobileqq.activity.contacts.mayknow;

import ajjn;
import ajju;
import ajll;
import ajlm;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import anvi;
import anyb;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.contacts.base.tabs.ContactsBaseFragment;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XListView;
import java.util.List;

public class RecommendFriendFragment
  extends ContactsBaseFragment
  implements ajjn
{
  protected int a;
  public ajlm a;
  View jdField_a_of_type_AndroidViewView;
  anvi jdField_a_of_type_Anvi = new ajll(this);
  public XListView a;
  public Runnable a;
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
    if (this.jdField_a_of_type_Ajlm != null) {
      return this.jdField_a_of_type_Ajlm.isEmpty();
    }
    return false;
  }
  
  private void h()
  {
    if (this.jdField_a_of_type_Ajlm != null)
    {
      Object localObject = (anyb)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.MAYKNOW_RECOMMEND_MANAGER);
      if (localObject != null)
      {
        ((anyb)localObject).a(3);
        localObject = ((anyb)localObject).c();
        this.jdField_a_of_type_Ajlm.a((List)localObject);
        this.jdField_c_of_type_AndroidViewView.removeCallbacks(this.jdField_c_of_type_JavaLangRunnable);
        this.jdField_c_of_type_AndroidViewView.postDelayed(this.jdField_c_of_type_JavaLangRunnable, 100L);
      }
      if (QLog.isColorLevel()) {
        QLog.d("RecommendFriendFragment", 2, "loadAndUpdateData size:" + this.jdField_a_of_type_Ajlm.getCount() + "  uin:" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
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
      this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity).inflate(2131558997, null, false);
      this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)this.jdField_a_of_type_AndroidViewView.findViewById(2131376376));
      this.jdField_a_of_type_ComTencentWidgetXListView.setSelector(new ColorDrawable(0));
      this.jdField_a_of_type_ComTencentWidgetXListView.setNeedCheckSpringback(true);
      this.jdField_a_of_type_ComTencentWidgetXListView.setCacheColorHint(0);
      this.jdField_a_of_type_ComTencentWidgetXListView.setDivider(null);
      this.jdField_a_of_type_ComTencentWidgetXListView.setOverScrollMode(0);
      this.jdField_a_of_type_ComTencentWidgetXListView.mForContacts = true;
      this.jdField_c_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131366142);
      paramLayoutInflater = (ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131366158);
      paramBundle = URLDrawable.URLDrawableOptions.obtain();
      paramBundle.mRequestHeight = AIOUtils.dp2px(200.0F, BaseApplication.getContext().getResources());
      paramBundle.mRequestWidth = AIOUtils.dp2px(145.0F, BaseApplication.getContext().getResources());
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
    if (this.jdField_a_of_type_Ajlm != null) {
      this.jdField_a_of_type_Ajlm.a();
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
    if (this.jdField_a_of_type_Ajlm == null)
    {
      this.jdField_a_of_type_Ajlm = new ajlm(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentWidgetXListView, 1, true);
      this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_Ajlm);
      h();
    }
    if (this.jdField_a_of_type_Ajlm != null) {
      this.jdField_a_of_type_Ajlm.b();
    }
    a(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
  }
  
  public void ah_()
  {
    if (QLog.isColorLevel()) {
      QLog.d("RecommendFriendFragment", 2, "refresh");
    }
    h();
    if (this.jdField_a_of_type_Ajju != null) {
      this.jdField_a_of_type_Ajju.a(b(), true, null);
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
    if (this.jdField_a_of_type_Ajlm != null) {
      this.jdField_a_of_type_Ajlm.d();
    }
  }
  
  public void c()
  {
    h();
    if (this.jdField_a_of_type_Ajlm != null) {
      this.jdField_a_of_type_Ajlm.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Anvi);
    }
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Anvi);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.mayknow.RecommendFriendFragment
 * JD-Core Version:    0.7.0.1
 */