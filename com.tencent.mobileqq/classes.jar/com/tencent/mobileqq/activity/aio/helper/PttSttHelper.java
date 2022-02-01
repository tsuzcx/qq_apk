package com.tencent.mobileqq.activity.aio.helper;

import android.content.Context;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.item.PttItemBuilder.Holder;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.stt.shard.AIOSttResult;
import com.tencent.mobileqq.stt.ui.PttSttItemAnimator;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import javax.annotation.Nullable;

public class PttSttHelper
  implements Handler.Callback, ILifeCycleHelper
{
  private Context jdField_a_of_type_AndroidContentContext;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private volatile PttSttItemAnimator jdField_a_of_type_ComTencentMobileqqSttUiPttSttItemAnimator = null;
  private ConcurrentHashMap<PttItemBuilder.Holder, MessageForPtt> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
  private volatile boolean jdField_a_of_type_Boolean = false;
  private Handler jdField_b_of_type_AndroidOsHandler;
  private ConcurrentHashMap<Long, PttSttItemAnimator> jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap;
  
  public PttSttHelper(BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramBaseChatPie.jdField_a_of_type_AndroidContentContext;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    this.jdField_b_of_type_AndroidOsHandler = new Handler(ThreadManager.getSubThreadLooper(), this);
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  }
  
  private void a(PttSttItemAnimator paramPttSttItemAnimator)
  {
    if (paramPttSttItemAnimator == null)
    {
      QLog.e("Q.stt_AIOHelper", 1, "startSttAnimator animator is null!");
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqSttUiPttSttItemAnimator = paramPttSttItemAnimator;
    c();
  }
  
  private boolean a(MessageForPtt paramMessageForPtt)
  {
    return (paramMessageForPtt.getSttResult() != null) && (paramMessageForPtt.getSttResult().a());
  }
  
  private boolean a(PttSttItemAnimator paramPttSttItemAnimator)
  {
    boolean bool = false;
    if (paramPttSttItemAnimator != null)
    {
      if (!paramPttSttItemAnimator.b()) {
        return false;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqSttUiPttSttItemAnimator != null)
      {
        paramPttSttItemAnimator.a(false);
        return false;
      }
      bool = true;
      paramPttSttItemAnimator.a(true);
    }
    return bool;
  }
  
  private void c()
  {
    Handler localHandler = this.jdField_b_of_type_AndroidOsHandler;
    if (localHandler != null)
    {
      localHandler.sendEmptyMessageDelayed(1, 100L);
      if (QLog.isColorLevel()) {
        QLog.d("Q.stt_AIOHelper", 2, "timer tick 100ms start");
      }
    }
  }
  
  private void f(MessageForPtt paramMessageForPtt)
  {
    paramMessageForPtt = a(paramMessageForPtt);
    if (paramMessageForPtt != null) {
      paramMessageForPtt.f();
    }
  }
  
  private void g(MessageForPtt paramMessageForPtt)
  {
    long l = paramMessageForPtt.uniseq;
    if (this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(Long.valueOf(l)))
    {
      paramMessageForPtt = (PttSttItemAnimator)this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.get(Long.valueOf(l));
      if ((paramMessageForPtt != null) && (paramMessageForPtt.equals(this.jdField_a_of_type_ComTencentMobileqqSttUiPttSttItemAnimator)))
      {
        paramMessageForPtt.a(false);
        this.jdField_a_of_type_ComTencentMobileqqSttUiPttSttItemAnimator = null;
      }
      this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.remove(Long.valueOf(l));
    }
  }
  
  @Nullable
  protected PttSttItemAnimator a(MessageForPtt paramMessageForPtt)
  {
    paramMessageForPtt = Long.valueOf(paramMessageForPtt.uniseq);
    if (this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramMessageForPtt)) {
      return (PttSttItemAnimator)this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramMessageForPtt);
    }
    return null;
  }
  
  public CharSequence a(MessageForPtt paramMessageForPtt)
  {
    paramMessageForPtt = Long.valueOf(paramMessageForPtt.uniseq);
    if (this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramMessageForPtt))
    {
      paramMessageForPtt = (PttSttItemAnimator)this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramMessageForPtt);
      if (paramMessageForPtt != null) {
        return paramMessageForPtt.a();
      }
    }
    return "";
  }
  
  public String a(MessageForPtt paramMessageForPtt)
  {
    return a(paramMessageForPtt).toString();
  }
  
  protected void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqSttUiPttSttItemAnimator == null) {
      return;
    }
    Iterator localIterator = this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      if (localEntry.getValue() == this.jdField_a_of_type_ComTencentMobileqqSttUiPttSttItemAnimator) {
        this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.remove(localEntry.getKey());
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqSttUiPttSttItemAnimator.h();
    this.jdField_a_of_type_ComTencentMobileqqSttUiPttSttItemAnimator = null;
  }
  
  public void a(PttItemBuilder.Holder paramHolder, MessageForPtt paramMessageForPtt, int paramInt)
  {
    for (;;)
    {
      try
      {
        boolean bool = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramHolder);
        PttSttItemAnimator localPttSttItemAnimator = null;
        Object localObject = localPttSttItemAnimator;
        if (bool)
        {
          localObject = (MessageForPtt)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramHolder);
          if (localObject != paramMessageForPtt) {
            break label210;
          }
          localObject = localPttSttItemAnimator;
        }
        if (localObject != null)
        {
          localObject = (PttSttItemAnimator)this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.get(Long.valueOf(((MessageForPtt)localObject).uniseq));
          if (localObject != null) {
            ((PttSttItemAnimator)localObject).a();
          }
        }
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramHolder, paramMessageForPtt);
        localPttSttItemAnimator = (PttSttItemAnimator)this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.get(Long.valueOf(paramMessageForPtt.uniseq));
        localObject = localPttSttItemAnimator;
        if (localPttSttItemAnimator == null)
        {
          if (PttSttItemAnimator.b(paramMessageForPtt)) {
            return;
          }
          localObject = new PttSttItemAnimator(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForPtt, paramInt);
          this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.put(Long.valueOf(paramMessageForPtt.uniseq), localObject);
        }
        ((PttSttItemAnimator)localObject).a(paramHolder);
        if ((!a((PttSttItemAnimator)localObject)) || (!PttSttItemAnimator.a(paramMessageForPtt))) {
          break label213;
        }
        paramInt = 1;
        if (paramInt != 0) {
          a((PttSttItemAnimator)localObject);
        }
        return;
      }
      finally {}
      label210:
      continue;
      label213:
      paramInt = 0;
    }
  }
  
  public void a(MessageForPtt paramMessageForPtt)
  {
    if (paramMessageForPtt == null) {
      return;
    }
    PttSttItemAnimator localPttSttItemAnimator = (PttSttItemAnimator)this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.get(Long.valueOf(paramMessageForPtt.uniseq));
    if (this.jdField_a_of_type_ComTencentMobileqqSttUiPttSttItemAnimator == localPttSttItemAnimator) {
      return;
    }
    boolean bool1 = a(localPttSttItemAnimator);
    boolean bool2 = PttSttItemAnimator.a(paramMessageForPtt);
    if ((bool1) && (bool2))
    {
      a(localPttSttItemAnimator);
      return;
    }
    if ((paramMessageForPtt.getSttResult().a() == 3) && (localPttSttItemAnimator != null))
    {
      localPttSttItemAnimator.d();
      if (!this.jdField_a_of_type_Boolean) {
        localPttSttItemAnimator.a(this.jdField_a_of_type_AndroidOsHandler);
      }
    }
  }
  
  public void b()
  {
    QQToast.a(this.jdField_a_of_type_AndroidContentContext, 1, 2131719262, 0).a();
  }
  
  public void b(MessageForPtt paramMessageForPtt)
  {
    if (a(paramMessageForPtt)) {
      f(paramMessageForPtt);
    }
    g(paramMessageForPtt);
    b();
  }
  
  public void c(MessageForPtt paramMessageForPtt)
  {
    if (a(paramMessageForPtt)) {
      d(paramMessageForPtt);
    }
  }
  
  protected void d(MessageForPtt paramMessageForPtt)
  {
    paramMessageForPtt = a(paramMessageForPtt);
    if (paramMessageForPtt != null)
    {
      paramMessageForPtt.f();
      paramMessageForPtt.g();
    }
  }
  
  public void e(MessageForPtt paramMessageForPtt) {}
  
  public String getTag()
  {
    return getClass().getName();
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 1)
    {
      boolean bool;
      if (this.jdField_a_of_type_ComTencentMobileqqSttUiPttSttItemAnimator != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqSttUiPttSttItemAnimator.d();
        if (!this.jdField_a_of_type_Boolean) {
          this.jdField_a_of_type_ComTencentMobileqqSttUiPttSttItemAnimator.a(this.jdField_a_of_type_AndroidOsHandler);
        }
        bool = this.jdField_a_of_type_ComTencentMobileqqSttUiPttSttItemAnimator.a();
      }
      else
      {
        bool = false;
      }
      if (!bool)
      {
        this.jdField_b_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1, 100L);
        return false;
      }
      a();
    }
    return false;
  }
  
  public int[] interestedIn()
  {
    return new int[] { 15, 9, 11, 7 };
  }
  
  public void onMoveToState(int paramInt)
  {
    if (paramInt != 7)
    {
      if (paramInt != 9)
      {
        if (paramInt != 11)
        {
          if (paramInt != 15) {
            return;
          }
          this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
          this.jdField_b_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
          this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
          this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
          return;
        }
        this.jdField_a_of_type_Boolean = true;
      }
    }
    else {
      this.jdField_a_of_type_Boolean = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.PttSttHelper
 * JD-Core Version:    0.7.0.1
 */