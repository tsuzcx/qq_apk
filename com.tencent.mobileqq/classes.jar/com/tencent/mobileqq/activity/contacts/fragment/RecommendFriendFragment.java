package com.tencent.mobileqq.activity.contacts.fragment;

import aekt;
import ahnl;
import ahoj;
import ahpf;
import ahql;
import alox;
import alro;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XListView;
import java.util.List;

public class RecommendFriendFragment
  extends ContactsBaseFragment
  implements ahql
{
  protected int a;
  public ahnl a;
  alox jdField_a_of_type_Alox = new ahpf(this);
  View jdField_a_of_type_AndroidViewView;
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
    if (this.jdField_a_of_type_Ahnl != null) {
      return this.jdField_a_of_type_Ahnl.isEmpty();
    }
    return false;
  }
  
  private void h()
  {
    if (this.jdField_a_of_type_Ahnl != null)
    {
      Object localObject = (alro)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(159);
      if (localObject != null)
      {
        ((alro)localObject).a(3);
        localObject = ((alro)localObject).c();
        this.jdField_a_of_type_Ahnl.a((List)localObject);
        this.jdField_c_of_type_AndroidViewView.removeCallbacks(this.jdField_c_of_type_JavaLangRunnable);
        this.jdField_c_of_type_AndroidViewView.postDelayed(this.jdField_c_of_type_JavaLangRunnable, 100L);
      }
      if (QLog.isColorLevel()) {
        QLog.d("RecommendFriendFragment", 2, "loadAndUpdateData size:" + this.jdField_a_of_type_Ahnl.getCount() + "  uin:" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      }
    }
  }
  
  public View a()
  {
    return this.jdField_a_of_type_ComTencentWidgetXListView;
  }
  
  protected View a(LayoutInflater paramLayoutInflater, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RecommendFriendFragment", 2, "getView mListView=" + this.jdField_a_of_type_ComTencentWidgetXListView);
    }
    if (this.jdField_a_of_type_AndroidViewView == null)
    {
      this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity).inflate(2131558897, null, false);
      this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)this.jdField_a_of_type_AndroidViewView.findViewById(2131375448));
      this.jdField_a_of_type_ComTencentWidgetXListView.setSelector(new ColorDrawable(0));
      this.jdField_a_of_type_ComTencentWidgetXListView.setNeedCheckSpringback(true);
      this.jdField_a_of_type_ComTencentWidgetXListView.setCacheColorHint(0);
      this.jdField_a_of_type_ComTencentWidgetXListView.setDivider(null);
      this.jdField_a_of_type_ComTencentWidgetXListView.setOverScrollMode(0);
      this.jdField_a_of_type_ComTencentWidgetXListView.mForContacts = true;
      this.jdField_c_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131365722);
      paramLayoutInflater = (ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131365737);
      paramBundle = URLDrawable.URLDrawableOptions.obtain();
      paramBundle.mRequestHeight = aekt.a(200.0F, BaseApplication.getContext().getResources());
      paramBundle.mRequestWidth = aekt.a(145.0F, BaseApplication.getContext().getResources());
      paramBundle.mLoadingDrawable = null;
      paramBundle.mFailedDrawable = null;
      paramLayoutInflater.setImageDrawable(URLDrawable.getDrawable("http://sqimg.qq.com/qq_product_operations/nearby/recommend/recommend_empty.png", paramBundle));
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
    if (this.jdField_a_of_type_Ahnl != null) {
      this.jdField_a_of_type_Ahnl.a();
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
    if (this.jdField_a_of_type_Ahnl == null)
    {
      this.jdField_a_of_type_Ahnl = new ahnl(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentWidgetXListView, 1, true);
      this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_Ahnl);
      h();
    }
    if (this.jdField_a_of_type_Ahnl != null) {
      this.jdField_a_of_type_Ahnl.b();
    }
    a(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
  }
  
  public void av_()
  {
    if (QLog.isColorLevel()) {
      QLog.d("RecommendFriendFragment", 2, "refresh");
    }
    h();
    if (this.jdField_a_of_type_Ahoj != null) {
      this.jdField_a_of_type_Ahoj.a(b(), true, null);
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
    if (this.jdField_a_of_type_Ahnl != null) {
      this.jdField_a_of_type_Ahnl.d();
    }
  }
  
  public void c()
  {
    h();
    if (this.jdField_a_of_type_Ahnl != null) {
      this.jdField_a_of_type_Ahnl.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
  }
  
  protected void d()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Alox);
    }
  }
  
  protected void e()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Alox);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.fragment.RecommendFriendFragment
 * JD-Core Version:    0.7.0.1
 */