package com.tencent.mobileqq.activity.contacts.topentry;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.activity.RecommendFriendActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.contacts.mayknow.ContactReportUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.WeakReferenceHandler;
import com.tencent.widget.AlphaClickableRelativeLayout;
import com.tencent.widget.XListView;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MayKnowPersonEntryController
  extends CTEntryController
  implements Handler.Callback, View.OnClickListener, CTEntryListener
{
  protected CTEntryMng a;
  protected MayknowRecommendsAdapter a;
  protected final WeakReferenceHandler a;
  protected boolean a;
  protected boolean b = false;
  
  public MayKnowPersonEntryController(Activity paramActivity)
  {
    super(paramActivity);
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler = new WeakReferenceHandler(Looper.getMainLooper(), this);
  }
  
  private void f()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsTopentryCTEntryMng = ((CTEntryMng)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.CTENTRY_MNG));
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsTopentryCTEntryMng.a(this);
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsTopentryCTEntryMng.a(true);
    }
  }
  
  private void g()
  {
    CTEntryMng localCTEntryMng = this.jdField_a_of_type_ComTencentMobileqqActivityContactsTopentryCTEntryMng;
    if (localCTEntryMng != null) {
      localCTEntryMng.b(this);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsTopentryCTEntryMng = null;
  }
  
  private void h()
  {
    if (QLog.isColorLevel()) {
      QLog.d("CTEntryController", 2, "onMayknowEntryClosed");
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsTopentryCTEntryMng.a();
    ContactReportUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "", "banner_recomlist_dlt");
  }
  
  public void a()
  {
    a(200L);
  }
  
  protected void a(long paramLong)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("refreshData  hasdata:");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.hasMessages(2));
      localStringBuilder.append(" mHasPaused:");
      localStringBuilder.append(this.b);
      QLog.i("CTEntryController", 2, localStringBuilder.toString());
    }
    if (this.b) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.hasMessages(2)) {
      return;
    }
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendEmptyMessageDelayed(2, paramLong);
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsTopentryMayknowRecommendsAdapter = new MayknowRecommendsAdapter(a(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentWidgetXListView, 1, true);
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivityContactsTopentryMayknowRecommendsAdapter);
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131706536));
    this.jdField_a_of_type_ComTencentWidgetAlphaClickableRelativeLayout.setOnClickListener(this);
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    super.a(paramQQAppInterface);
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != paramQQAppInterface)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
      MayknowRecommendsAdapter localMayknowRecommendsAdapter = this.jdField_a_of_type_ComTencentMobileqqActivityContactsTopentryMayknowRecommendsAdapter;
      if (localMayknowRecommendsAdapter != null) {
        localMayknowRecommendsAdapter.a(paramQQAppInterface);
      }
    }
    f();
    a(50L);
    paramQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqActivityContactsTopentryCTEntryMng.a();
    if (paramQQAppInterface != null) {
      paramQQAppInterface.b();
    }
  }
  
  public void a(boolean paramBoolean)
  {
    super.a(paramBoolean);
    if (QLog.isColorLevel()) {
      QLog.i("CTEntryController", 2, "onResume");
    }
    this.jdField_a_of_type_Boolean = false;
    if (this.b)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityContactsTopentryMayknowRecommendsAdapter;
      if (localObject != null) {
        ((MayknowRecommendsAdapter)localObject).notifyDataSetChanged();
      }
      a(500L);
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendEmptyMessageDelayed(3, 500L);
    }
    else
    {
      a(0L);
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityContactsTopentryCTEntryMng.a();
      if (localObject != null) {
        ((CardViewController)localObject).b();
      }
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityContactsTopentryMayknowRecommendsAdapter;
    if (localObject != null) {
      ((MayknowRecommendsAdapter)localObject).d();
    }
    this.b = false;
  }
  
  public void b()
  {
    super.b();
    f();
  }
  
  public void c()
  {
    super.c();
    if (QLog.isColorLevel()) {
      QLog.i("CTEntryController", 2, "onPause");
    }
    MayknowRecommendsAdapter localMayknowRecommendsAdapter = this.jdField_a_of_type_ComTencentMobileqqActivityContactsTopentryMayknowRecommendsAdapter;
    if (localMayknowRecommendsAdapter != null) {
      localMayknowRecommendsAdapter.b();
    }
    this.b = true;
  }
  
  public void c(boolean paramBoolean)
  {
    MayknowRecommendsAdapter localMayknowRecommendsAdapter = this.jdField_a_of_type_ComTencentMobileqqActivityContactsTopentryMayknowRecommendsAdapter;
    if (localMayknowRecommendsAdapter != null) {
      localMayknowRecommendsAdapter.a(paramBoolean);
    }
  }
  
  public void d()
  {
    super.d();
    if (QLog.isColorLevel()) {
      QLog.i("CTEntryController", 2, "onDestroy");
    }
    Object localObject = this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler;
    if (localObject != null) {
      ((WeakReferenceHandler)localObject).removeCallbacksAndMessages(null);
    }
    g();
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsTopentryCTEntryController$OnCTEntryDataChangeListener = null;
    localObject = this.jdField_a_of_type_ComTencentMobileqqActivityContactsTopentryMayknowRecommendsAdapter;
    if (localObject != null) {
      ((MayknowRecommendsAdapter)localObject).a();
    }
  }
  
  public void d(boolean paramBoolean)
  {
    a(0L);
  }
  
  public void e()
  {
    super.e();
    g();
    if (this.jdField_a_of_type_ComTencentWidgetXListView != null) {
      this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(null);
    }
    MayknowRecommendsAdapter localMayknowRecommendsAdapter = this.jdField_a_of_type_ComTencentMobileqqActivityContactsTopentryMayknowRecommendsAdapter;
    if (localMayknowRecommendsAdapter != null) {
      localMayknowRecommendsAdapter.a();
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsTopentryMayknowRecommendsAdapter = null;
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(8);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3) {
          return false;
        }
        paramMessage = this.jdField_a_of_type_ComTencentMobileqqActivityContactsTopentryCTEntryMng;
        if (paramMessage != null)
        {
          paramMessage = paramMessage.a();
          if (paramMessage != null)
          {
            paramMessage.b();
            return false;
          }
        }
      }
      else
      {
        this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeMessages(2);
        ThreadManager.excute(new MayKnowPersonEntryController.1(this), 16, null, true);
        return false;
      }
    }
    else
    {
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeMessages(1);
      paramMessage = (List)paramMessage.obj;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityContactsTopentryMayknowRecommendsAdapter == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityContactsTopentryMayknowRecommendsAdapter = new MayknowRecommendsAdapter(a(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentWidgetXListView, 1, true);
        this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivityContactsTopentryMayknowRecommendsAdapter);
      }
      int j = this.jdField_a_of_type_ComTencentMobileqqActivityContactsTopentryMayknowRecommendsAdapter.getCount();
      boolean bool3 = a();
      Object localObject1 = paramMessage.iterator();
      i = 0;
      boolean bool1 = false;
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (CTEntry)((Iterator)localObject1).next();
        if ((localObject2 != null) && (((CTEntry)localObject2).jdField_a_of_type_Int == 3) && (bool3))
        {
          boolean bool2 = ((CTEntry)localObject2).e;
          bool1 = bool2;
          if (!bool2)
          {
            bool1 = bool2;
            if ((((CTEntry)localObject2).jdField_a_of_type_JavaLangObject instanceof List))
            {
              localObject2 = (List)((CTEntry)localObject2).jdField_a_of_type_JavaLangObject;
              bool1 = bool2;
              if (((List)localObject2).size() > 0)
              {
                this.jdField_a_of_type_ComTencentMobileqqActivityContactsTopentryMayknowRecommendsAdapter.a((List)localObject2);
                i = ((List)localObject2).size();
                bool1 = bool2;
              }
            }
          }
        }
      }
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("MSG_UPDATE_ENTRY_LIST preCount:");
        ((StringBuilder)localObject1).append(j);
        ((StringBuilder)localObject1).append(" size:");
        ((StringBuilder)localObject1).append(i);
        ((StringBuilder)localObject1).append(" userClose:");
        ((StringBuilder)localObject1).append(bool1);
        ((StringBuilder)localObject1).append(" shouldShowRecommendEntry: ");
        ((StringBuilder)localObject1).append(bool3);
        QLog.d("CTEntryController", 2, ((StringBuilder)localObject1).toString());
      }
      if (i > 0)
      {
        localObject1 = (LinearLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetFrameLayout.getLayoutParams();
        ((LinearLayout.LayoutParams)localObject1).height = AIOUtils.b(i * 60 + 28, this.jdField_a_of_type_AndroidWidgetFrameLayout.getResources());
        this.jdField_a_of_type_AndroidWidgetFrameLayout.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(0);
        i = 1;
      }
      else
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityContactsTopentryMayknowRecommendsAdapter.a(null);
        this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(8);
        if ((j > 0) && (!bool1)) {
          h();
        }
        i = 0;
      }
      if (!this.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_Boolean = true;
        paramMessage = paramMessage.iterator();
        while (paramMessage.hasNext())
        {
          localObject1 = (CTEntry)paramMessage.next();
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800979E", "0X800979E", ((CTEntry)localObject1).jdField_a_of_type_Int, 0, "", "", "", "");
        }
        if (i != 0) {
          ContactReportUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "", "banner_recomlist_exp");
        }
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityContactsTopentryCTEntryController$OnCTEntryDataChangeListener != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityContactsTopentryCTEntryController$OnCTEntryDataChangeListener.a();
      }
    }
    return false;
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131376253)
    {
      Intent localIntent = new Intent(this.jdField_a_of_type_AndroidAppActivity, RecommendFriendActivity.class);
      localIntent.putExtra("EntranceId", 8);
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityContactsTopentryCTEntryMng;
      if (localObject == null) {
        localObject = null;
      } else {
        localObject = ((CTEntryMng)localObject).a();
      }
      if (localObject != null)
      {
        localObject = ((CardViewController)localObject).a();
        if (!((ArrayList)localObject).isEmpty()) {
          localIntent.putExtra("may_know_recmmds", (Serializable)localObject);
        }
      }
      this.jdField_a_of_type_AndroidAppActivity.startActivity(localIntent);
      ContactReportUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "", "banner_recomlist_clk");
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.topentry.MayKnowPersonEntryController
 * JD-Core Version:    0.7.0.1
 */