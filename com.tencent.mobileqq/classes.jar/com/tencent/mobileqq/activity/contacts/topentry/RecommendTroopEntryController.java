package com.tencent.mobileqq.activity.contacts.topentry;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.MayknowRecommendManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.widget.AlphaClickableRelativeLayout;
import com.tencent.widget.XListView;
import java.util.List;

public class RecommendTroopEntryController
  extends CTEntryController
{
  public static boolean a;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new RecommendTroopEntryController.2(this);
  private RecommendTroopAdapter.IRecommendTroopAdapterCallback jdField_a_of_type_ComTencentMobileqqActivityContactsTopentryRecommendTroopAdapter$IRecommendTroopAdapterCallback = new RecommendTroopEntryController.1(this);
  private RecommendTroopAdapter jdField_a_of_type_ComTencentMobileqqActivityContactsTopentryRecommendTroopAdapter;
  
  static
  {
    jdField_a_of_type_Boolean = false;
  }
  
  public RecommendTroopEntryController(Activity paramActivity)
  {
    super(paramActivity);
  }
  
  private void a()
  {
    if (!a()) {
      this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(8);
    }
    label125:
    do
    {
      for (;;)
      {
        return;
        Object localObject = (MayknowRecommendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.MAYKNOW_RECOMMEND_MANAGER);
        if (TextUtils.isEmpty(((MayknowRecommendManager)localObject).a))
        {
          this.jdField_a_of_type_ComTencentWidgetAlphaClickableRelativeLayout.setOnClickListener(null);
          this.jdField_a_of_type_ComTencentWidgetAlphaClickableRelativeLayout.setClickable(false);
          this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
          if (this.jdField_a_of_type_ComTencentMobileqqActivityContactsTopentryRecommendTroopAdapter != null) {
            break label125;
          }
        }
        for (int i = 0;; i = this.jdField_a_of_type_ComTencentMobileqqActivityContactsTopentryRecommendTroopAdapter.getCount())
        {
          localObject = ((MayknowRecommendManager)localObject).a(i);
          if (localObject != null) {
            break label136;
          }
          this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(8);
          return;
          this.jdField_a_of_type_ComTencentWidgetAlphaClickableRelativeLayout.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
          this.jdField_a_of_type_ComTencentWidgetAlphaClickableRelativeLayout.setClickable(true);
          this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
          break;
        }
        if (((List)localObject).isEmpty()) {
          break;
        }
        this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(0);
        if (this.jdField_a_of_type_ComTencentMobileqqActivityContactsTopentryRecommendTroopAdapter == null)
        {
          this.jdField_a_of_type_ComTencentMobileqqActivityContactsTopentryRecommendTroopAdapter = new RecommendTroopAdapter(a(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentWidgetXListView, 4, true, this.jdField_a_of_type_ComTencentMobileqqActivityContactsTopentryRecommendTroopAdapter$IRecommendTroopAdapterCallback);
          this.jdField_a_of_type_ComTencentMobileqqActivityContactsTopentryRecommendTroopAdapter.a((List)localObject);
          this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivityContactsTopentryRecommendTroopAdapter);
        }
        while (((List)localObject).size() == 1)
        {
          f();
          return;
          this.jdField_a_of_type_ComTencentMobileqqActivityContactsTopentryRecommendTroopAdapter.a((List)localObject);
        }
      }
    } while (this.jdField_a_of_type_ComTencentMobileqqActivityContactsTopentryRecommendTroopAdapter == null);
    label136:
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsTopentryRecommendTroopAdapter.notifyDataSetChanged();
  }
  
  private void f()
  {
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetFrameLayout.getLayoutParams();
    localLayoutParams.height = AIOUtils.a(88.0F, this.jdField_a_of_type_AndroidWidgetFrameLayout.getResources());
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setLayoutParams(localLayoutParams);
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    this.jdField_a_of_type_ComTencentWidgetAlphaClickableRelativeLayout.a(false);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131713209));
    a();
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    super.a(paramQQAppInterface);
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != paramQQAppInterface)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityContactsTopentryRecommendTroopAdapter != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityContactsTopentryRecommendTroopAdapter.a(paramQQAppInterface);
      }
    }
    a();
  }
  
  public void a(String paramString)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityContactsTopentryRecommendTroopAdapter != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityContactsTopentryRecommendTroopAdapter.a(paramString)))
    {
      ((MayknowRecommendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.MAYKNOW_RECOMMEND_MANAGER)).i();
      a();
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactsTopentryRecommendTroopAdapter != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsTopentryRecommendTroopAdapter.a(paramBoolean);
    }
  }
  
  public void b(boolean paramBoolean)
  {
    super.b(paramBoolean);
    jdField_a_of_type_Boolean = true;
    a();
  }
  
  public void d()
  {
    super.d();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactsTopentryRecommendTroopAdapter != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsTopentryRecommendTroopAdapter.a();
    }
  }
  
  public void d(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_AndroidAppActivity != null) {
      this.jdField_a_of_type_AndroidAppActivity.runOnUiThread(new RecommendTroopEntryController.3(this));
    }
  }
  
  public void e()
  {
    super.e();
    if (this.jdField_a_of_type_ComTencentWidgetXListView != null) {
      this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(null);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactsTopentryRecommendTroopAdapter != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsTopentryRecommendTroopAdapter.a();
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsTopentryRecommendTroopAdapter = null;
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.topentry.RecommendTroopEntryController
 * JD-Core Version:    0.7.0.1
 */