package com.tencent.mobileqq.activity.aio.helper;

import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.view.View;
import com.tencent.mobileqq.activity.aio.ChatAdapter1;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.multiaio.model.MultiAIOManager;
import com.tencent.mobileqq.multiaio.presenter.MultiAioContext;
import com.tencent.mobileqq.multiaio.view.MultiAioContainer;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ListView;
import java.util.List;

public class MultiWindowAIOHelper
  implements ILifeCycleHelper
{
  private long jdField_a_of_type_Long = 0L;
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
  private Runnable jdField_a_of_type_JavaLangRunnable = new MultiWindowAIOHelper.1(this);
  
  public MultiWindowAIOHelper(BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie = paramBaseChatPie;
  }
  
  private int a()
  {
    MultiAioContext localMultiAioContext = a();
    if (localMultiAioContext == null) {
      return -1;
    }
    return localMultiAioContext.c();
  }
  
  private MultiAioContext a()
  {
    BaseActivity localBaseActivity = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a();
    if (localBaseActivity != null)
    {
      if (localBaseActivity.isFinishing()) {
        return null;
      }
      int i = localBaseActivity.getIntent().getIntExtra("KEY_MULTI_WINDOW_AIO_CONTEXT_ID", -1);
      if (i == -1) {
        return null;
      }
      return ((MultiAIOManager)localBaseActivity.app.getManager(QQManagerFactory.AIO_MULTI_WINDOW_MANAGER)).b(i);
    }
    return null;
  }
  
  private void b()
  {
    this.jdField_a_of_type_Long = SystemClock.elapsedRealtime();
  }
  
  private void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiWindowAIOHelper", 2, "onShowFirst() called");
    }
  }
  
  private void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiWindowAIOHelper", 2, "onCreate() called");
    }
    Object localObject = a();
    if ((localObject != null) && (((MultiAioContext)localObject).a()))
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView;
      if (localObject != null) {
        ((ChatXListView)localObject).setOnLayoutListener(new MultiWindowAIOHelper.2(this));
      }
    }
  }
  
  private void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiWindowAIOHelper", 2, "onStart() called");
    }
  }
  
  private void f()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiWindowAIOHelper", 2, "onResume() called");
    }
  }
  
  private void g()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiWindowAIOHelper", 2, "onShow() called");
    }
  }
  
  private void h()
  {
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
  }
  
  private void i() {}
  
  private void j()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiWindowAIOHelper", 2, "tryRestoreListViewState() called");
    }
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1;
    if (localObject1 != null)
    {
      localObject1 = ((ChatAdapter1)localObject1).a();
      int i = a();
      if ((localObject1 != null) && (((List)localObject1).size() == i))
      {
        localObject1 = a();
        if ((localObject1 != null) && (((MultiAioContext)localObject1).a()))
        {
          Object localObject2 = ((MultiAioContext)localObject1).a();
          if (localObject2 != null)
          {
            localObject2 = ((MultiAioContainer)localObject2).a();
            if (localObject2 == null)
            {
              QLog.e("MultiWindowAIOHelper", 1, "tryRestoreListViewState: listView == null");
              return;
            }
            i = ((ListView)localObject2).getLastVisiblePosition();
            View localView = ((ListView)localObject2).getChildAt(((ListView)localObject2).getChildCount() - 1);
            int j = ((ListView)localObject2).getBottom() - localView.getBottom();
            if (QLog.isColorLevel())
            {
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("tryRestoreListViewState() anchorPosition = ");
              ((StringBuilder)localObject2).append(i);
              ((StringBuilder)localObject2).append(", specifyBottom = ");
              ((StringBuilder)localObject2).append(j);
              QLog.d("MultiWindowAIOHelper", 2, ((StringBuilder)localObject2).toString());
            }
            this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setOnLayoutListener(null);
            this.jdField_a_of_type_AndroidOsHandler.post(new MultiWindowAIOHelper.3(this, i, j));
            this.jdField_a_of_type_AndroidOsHandler.postDelayed(new MultiWindowAIOHelper.4(this, (MultiAioContext)localObject1), 350L);
          }
        }
      }
    }
  }
  
  public void a()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
    if ((localObject != null) && (((BaseChatPie)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1 != null)) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.d();
    }
    long l = SystemClock.elapsedRealtime();
    if (l - this.jdField_a_of_type_Long >= 1000L)
    {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 300L);
      return;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("AIO start multi window!  but list idle time lower 2s!  please wait... dif time = ");
      ((StringBuilder)localObject).append(l - this.jdField_a_of_type_Long);
      QLog.d("MultiWindowAIOHelper", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  public String getTag()
  {
    return "MultiWindowAIOHelper";
  }
  
  public int[] interestedIn()
  {
    return new int[] { 4, 7, 9, 10, 11, 15, 18 };
  }
  
  public void onMoveToState(int paramInt)
  {
    if (paramInt != 4)
    {
      if (paramInt != 5)
      {
        if (paramInt != 7) {
          if (paramInt != 15) {
            if (paramInt == 18) {}
          }
        }
        switch (paramInt)
        {
        default: 
          return;
        case 11: 
          h();
          return;
        case 10: 
          g();
          return;
          b();
          return;
          i();
          return;
          f();
        }
        c();
        return;
      }
      e();
      return;
    }
    d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.MultiWindowAIOHelper
 * JD-Core Version:    0.7.0.1
 */