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
  private QQAppInterface a;
  private Context b;
  private ConcurrentHashMap<PttItemBuilder.Holder, MessageForPtt> c;
  private ConcurrentHashMap<Long, PttSttItemAnimator> d;
  private volatile PttSttItemAnimator e = null;
  private Handler f;
  private Handler g;
  private volatile boolean h = false;
  
  public PttSttHelper(BaseChatPie paramBaseChatPie)
  {
    this.a = paramBaseChatPie.d;
    this.b = paramBaseChatPie.e;
    this.f = new Handler(Looper.getMainLooper());
    this.g = new Handler(ThreadManager.getSubThreadLooper(), this);
    this.c = new ConcurrentHashMap();
    this.d = new ConcurrentHashMap();
  }
  
  private void a(PttSttItemAnimator paramPttSttItemAnimator)
  {
    if (paramPttSttItemAnimator == null)
    {
      QLog.e("Q.stt_AIOHelper", 1, "startSttAnimator animator is null!");
      return;
    }
    this.e = paramPttSttItemAnimator;
    c();
  }
  
  private boolean b(PttSttItemAnimator paramPttSttItemAnimator)
  {
    boolean bool = false;
    if (paramPttSttItemAnimator != null)
    {
      if (!paramPttSttItemAnimator.h()) {
        return false;
      }
      if (this.e != null)
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
    Handler localHandler = this.g;
    if (localHandler != null)
    {
      localHandler.sendEmptyMessageDelayed(1, 100L);
      if (QLog.isColorLevel()) {
        QLog.d("Q.stt_AIOHelper", 2, "timer tick 100ms start");
      }
    }
  }
  
  private boolean i(MessageForPtt paramMessageForPtt)
  {
    return (paramMessageForPtt.getSttResult() != null) && (paramMessageForPtt.getSttResult().f());
  }
  
  private void j(MessageForPtt paramMessageForPtt)
  {
    paramMessageForPtt = e(paramMessageForPtt);
    if (paramMessageForPtt != null) {
      paramMessageForPtt.i();
    }
  }
  
  private void k(MessageForPtt paramMessageForPtt)
  {
    long l = paramMessageForPtt.uniseq;
    if (this.d.containsKey(Long.valueOf(l)))
    {
      paramMessageForPtt = (PttSttItemAnimator)this.d.get(Long.valueOf(l));
      if ((paramMessageForPtt != null) && (paramMessageForPtt.equals(this.e)))
      {
        paramMessageForPtt.a(false);
        this.e = null;
      }
      this.d.remove(Long.valueOf(l));
    }
  }
  
  protected void a()
  {
    if (this.e == null) {
      return;
    }
    Iterator localIterator = this.d.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      if (localEntry.getValue() == this.e) {
        this.d.remove(localEntry.getKey());
      }
    }
    this.e.k();
    this.e = null;
  }
  
  public void a(PttItemBuilder.Holder paramHolder, MessageForPtt paramMessageForPtt, int paramInt)
  {
    for (;;)
    {
      try
      {
        boolean bool = this.c.containsKey(paramHolder);
        PttSttItemAnimator localPttSttItemAnimator = null;
        Object localObject = localPttSttItemAnimator;
        if (bool)
        {
          localObject = (MessageForPtt)this.c.get(paramHolder);
          if (localObject != paramMessageForPtt) {
            break label210;
          }
          localObject = localPttSttItemAnimator;
        }
        if (localObject != null)
        {
          localObject = (PttSttItemAnimator)this.d.get(Long.valueOf(((MessageForPtt)localObject).uniseq));
          if (localObject != null) {
            ((PttSttItemAnimator)localObject).a();
          }
        }
        this.c.put(paramHolder, paramMessageForPtt);
        localPttSttItemAnimator = (PttSttItemAnimator)this.d.get(Long.valueOf(paramMessageForPtt.uniseq));
        localObject = localPttSttItemAnimator;
        if (localPttSttItemAnimator == null)
        {
          if (PttSttItemAnimator.b(paramMessageForPtt)) {
            return;
          }
          localObject = new PttSttItemAnimator(this.a, paramMessageForPtt, paramInt);
          this.d.put(Long.valueOf(paramMessageForPtt.uniseq), localObject);
        }
        ((PttSttItemAnimator)localObject).a(paramHolder);
        if ((!b((PttSttItemAnimator)localObject)) || (!PttSttItemAnimator.a(paramMessageForPtt))) {
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
    PttSttItemAnimator localPttSttItemAnimator = (PttSttItemAnimator)this.d.get(Long.valueOf(paramMessageForPtt.uniseq));
    if (this.e == localPttSttItemAnimator) {
      return;
    }
    boolean bool1 = b(localPttSttItemAnimator);
    boolean bool2 = PttSttItemAnimator.a(paramMessageForPtt);
    if ((bool1) && (bool2))
    {
      a(localPttSttItemAnimator);
      return;
    }
    if ((paramMessageForPtt.getSttResult().e() == 3) && (localPttSttItemAnimator != null))
    {
      localPttSttItemAnimator.f();
      if (!this.h) {
        localPttSttItemAnimator.a(this.f);
      }
    }
  }
  
  public void b()
  {
    QQToast.makeText(this.b, 1, 2131916814, 0).show();
  }
  
  public void b(MessageForPtt paramMessageForPtt)
  {
    if (i(paramMessageForPtt)) {
      j(paramMessageForPtt);
    }
    k(paramMessageForPtt);
    b();
  }
  
  public void c(MessageForPtt paramMessageForPtt)
  {
    if (i(paramMessageForPtt)) {
      d(paramMessageForPtt);
    }
  }
  
  protected void d(MessageForPtt paramMessageForPtt)
  {
    paramMessageForPtt = e(paramMessageForPtt);
    if (paramMessageForPtt != null)
    {
      paramMessageForPtt.i();
      paramMessageForPtt.j();
    }
  }
  
  @Nullable
  protected PttSttItemAnimator e(MessageForPtt paramMessageForPtt)
  {
    paramMessageForPtt = Long.valueOf(paramMessageForPtt.uniseq);
    if (this.d.containsKey(paramMessageForPtt)) {
      return (PttSttItemAnimator)this.d.get(paramMessageForPtt);
    }
    return null;
  }
  
  public void f(MessageForPtt paramMessageForPtt) {}
  
  public CharSequence g(MessageForPtt paramMessageForPtt)
  {
    paramMessageForPtt = Long.valueOf(paramMessageForPtt.uniseq);
    if (this.d.containsKey(paramMessageForPtt))
    {
      paramMessageForPtt = (PttSttItemAnimator)this.d.get(paramMessageForPtt);
      if (paramMessageForPtt != null) {
        return paramMessageForPtt.e();
      }
    }
    return "";
  }
  
  public String getTag()
  {
    return getClass().getName();
  }
  
  public String h(MessageForPtt paramMessageForPtt)
  {
    return g(paramMessageForPtt).toString();
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 1)
    {
      boolean bool;
      if (this.e != null)
      {
        this.e.f();
        if (!this.h) {
          this.e.a(this.f);
        }
        bool = this.e.b();
      }
      else
      {
        bool = false;
      }
      if (!bool)
      {
        this.g.sendEmptyMessageDelayed(1, 100L);
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
          this.f.removeCallbacksAndMessages(null);
          this.g.removeCallbacksAndMessages(null);
          this.c.clear();
          this.d.clear();
          return;
        }
        this.h = true;
      }
    }
    else {
      this.h = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.PttSttHelper
 * JD-Core Version:    0.7.0.1
 */