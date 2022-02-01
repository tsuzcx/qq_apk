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
import com.tencent.mobileqq.bubble.ChatXListView.OnLayoutListener;
import com.tencent.mobileqq.multiaio.model.MultiAIOManager;
import com.tencent.mobileqq.multiaio.presenter.MultiAioContext;
import com.tencent.mobileqq.multiaio.view.MultiAioContainer;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ListView;
import java.util.List;

public class MultiWindowAIOHelper
  implements ILifeCycleHelper
{
  private BaseChatPie a;
  private Handler b = new Handler(Looper.getMainLooper());
  private long c = 0L;
  private Runnable d = new MultiWindowAIOHelper.1(this);
  private ChatXListView.OnLayoutListener e = new MultiWindowAIOHelper.2(this);
  
  public MultiWindowAIOHelper(BaseChatPie paramBaseChatPie)
  {
    this.a = paramBaseChatPie;
  }
  
  private void b()
  {
    this.c = SystemClock.elapsedRealtime();
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
    Object localObject = k();
    if ((localObject != null) && (((MultiAioContext)localObject).i()))
    {
      localObject = this.a.U;
      if (localObject != null) {
        ((ChatXListView)localObject).a(this.e);
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
    this.b.removeCallbacks(this.d);
  }
  
  private void i() {}
  
  private int j()
  {
    MultiAioContext localMultiAioContext = k();
    if (localMultiAioContext == null) {
      return -1;
    }
    return localMultiAioContext.j();
  }
  
  private MultiAioContext k()
  {
    BaseActivity localBaseActivity = this.a.aX();
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
  
  private void l()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiWindowAIOHelper", 2, "tryRestoreListViewState() called");
    }
    Object localObject1 = this.a.V;
    if (localObject1 != null)
    {
      localObject1 = ((ChatAdapter1)localObject1).a();
      int i = j();
      if ((localObject1 != null) && (((List)localObject1).size() == i))
      {
        localObject1 = k();
        if ((localObject1 != null) && (((MultiAioContext)localObject1).i()))
        {
          Object localObject2 = ((MultiAioContext)localObject1).a();
          if (localObject2 != null)
          {
            localObject2 = ((MultiAioContainer)localObject2).f();
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
            this.a.U.b(this.e);
            this.b.post(new MultiWindowAIOHelper.3(this, i, j));
            this.b.postDelayed(new MultiWindowAIOHelper.4(this, (MultiAioContext)localObject1), 350L);
          }
        }
      }
    }
  }
  
  public void a()
  {
    Object localObject = this.a;
    if ((localObject != null) && (((BaseChatPie)localObject).V != null)) {
      this.a.V.e();
    }
    long l = SystemClock.elapsedRealtime();
    if (l - this.c >= 1000L)
    {
      this.b.removeCallbacks(this.d);
      this.b.postDelayed(this.d, 300L);
      return;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("AIO start multi window!  but list idle time lower 2s!  please wait... dif time = ");
      ((StringBuilder)localObject).append(l - this.c);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.MultiWindowAIOHelper
 * JD-Core Version:    0.7.0.1
 */