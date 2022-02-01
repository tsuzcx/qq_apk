package com.tencent.mobileqq.activity.aio.anim.egg;

import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner.AIOAnimator;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ListView;
import java.util.Queue;

public abstract class QueuedEggsAnimation<A>
  extends AIOAnimationConatiner.AIOAnimator
{
  protected QueuedEggsAnimation<A>.QueueDriver d;
  protected volatile boolean e;
  protected final Queue<A> f;
  protected final Queue<A> g;
  protected final Queue<A> h;
  protected int i;
  protected int j;
  
  private void e()
  {
    this.f.clear();
    this.g.clear();
    this.h.clear();
  }
  
  protected abstract void a(A paramA);
  
  protected boolean a(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    return false;
  }
  
  protected boolean a(Object... paramVarArgs)
  {
    paramVarArgs = c(paramVarArgs);
    this.f.add(paramVarArgs);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[start] prepare animation: ");
    localStringBuilder.append(paramVarArgs.toString());
    QLog.i("QueuedEggsAnimation", 1, localStringBuilder.toString());
    if (this.d == null)
    {
      this.d = new QueuedEggsAnimation.QueueDriver(this, null);
      this.b.post(this.d);
    }
    return false;
  }
  
  protected abstract void b(A paramA);
  
  protected abstract A c(Object... paramVarArgs);
  
  protected void c()
  {
    QLog.i("QueuedEggsAnimation", 1, "[stop] animation stop, clear queue.");
    e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.anim.egg.QueuedEggsAnimation
 * JD-Core Version:    0.7.0.1
 */