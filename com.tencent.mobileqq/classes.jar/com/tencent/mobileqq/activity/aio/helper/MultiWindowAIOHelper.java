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
    if ((localBaseActivity == null) || (localBaseActivity.isFinishing())) {}
    int i;
    do
    {
      return null;
      i = localBaseActivity.getIntent().getIntExtra("KEY_MULTI_WINDOW_AIO_CONTEXT_ID", -1);
    } while (i == -1);
    return ((MultiAIOManager)localBaseActivity.app.getManager(QQManagerFactory.AIO_MULTI_WINDOW_MANAGER)).b(i);
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
    Object localObject2;
    if (localObject1 != null)
    {
      localObject1 = ((ChatAdapter1)localObject1).a();
      i = a();
      if ((localObject1 != null) && (((List)localObject1).size() == i))
      {
        localObject1 = a();
        if ((localObject1 != null) && (((MultiAioContext)localObject1).a()))
        {
          localObject2 = ((MultiAioContext)localObject1).a();
          if (localObject2 != null)
          {
            localObject2 = ((MultiAioContainer)localObject2).a();
            if (localObject2 != null) {
              break label100;
            }
            QLog.e("MultiWindowAIOHelper", 1, "tryRestoreListViewState: listView == null");
          }
        }
      }
    }
    return;
    label100:
    int i = ((ListView)localObject2).getLastVisiblePosition();
    View localView = ((ListView)localObject2).getChildAt(((ListView)localObject2).getChildCount() - 1);
    int j = ((ListView)localObject2).getBottom() - localView.getBottom();
    if (QLog.isColorLevel()) {
      QLog.d("MultiWindowAIOHelper", 2, "tryRestoreListViewState() anchorPosition = " + i + ", specifyBottom = " + j);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setOnLayoutListener(null);
    this.jdField_a_of_type_AndroidOsHandler.post(new MultiWindowAIOHelper.3(this, i, j));
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(new MultiWindowAIOHelper.4(this, (MultiAioContext)localObject1), 350L);
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1 != null)) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.d();
    }
    long l = SystemClock.elapsedRealtime();
    if (l - this.jdField_a_of_type_Long >= 1000L)
    {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 300L);
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("MultiWindowAIOHelper", 2, "AIO start multi window!  but list idle time lower 2s!  please wait... dif time = " + (l - this.jdField_a_of_type_Long));
  }
  
  public String getTag()
  {
    return "MultiWindowAIOHelper";
  }
  
  public int[] interestedIn()
  {
    return new int[] { 4, 6, 8, 9, 10, 14, 17 };
  }
  
  public void onMoveToState(int paramInt)
  {
    switch (paramInt)
    {
    case 7: 
    case 11: 
    case 12: 
    case 13: 
    case 15: 
    case 16: 
    default: 
      return;
    case 4: 
      d();
      return;
    case 5: 
      e();
      return;
    case 6: 
      f();
    case 8: 
      c();
      return;
    case 9: 
      g();
      return;
    case 10: 
      h();
      return;
    case 14: 
      i();
      return;
    }
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.MultiWindowAIOHelper
 * JD-Core Version:    0.7.0.1
 */