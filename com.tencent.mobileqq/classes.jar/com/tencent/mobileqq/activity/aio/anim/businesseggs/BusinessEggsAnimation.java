package com.tencent.mobileqq.activity.aio.anim.businesseggs;

import android.graphics.drawable.Drawable;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner.AIOAnimator;
import com.tencent.mobileqq.activity.aio.anim.AioAnimationRule;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.utils.RandomUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ListView;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class BusinessEggsAnimation
  extends AIOAnimationConatiner.AIOAnimator
{
  private BusinessEggsAnimation.BusinessEggsQueueDriver d;
  private final Queue<BusinessEggsElement> e = new LinkedList();
  private final Queue<BusinessEggsElement> f = new LinkedList();
  private final Queue<BusinessEggsElement> g = new LinkedList();
  private final Map<Long, AioAnimationRule> h = new HashMap();
  
  public BusinessEggsAnimation(int paramInt, AIOAnimationConatiner paramAIOAnimationConatiner, ListView paramListView)
  {
    super(paramInt, paramAIOAnimationConatiner, paramListView);
  }
  
  private void a(BusinessEggsElement paramBusinessEggsElement, ChatMessage paramChatMessage)
  {
    paramBusinessEggsElement.a(new BusinessEggsAnimation.1(this, paramBusinessEggsElement, paramChatMessage));
    paramBusinessEggsElement.a(new BusinessEggsAnimation.2(this));
  }
  
  private void a(Queue<BusinessEggsElement> paramQueue)
  {
    if (!paramQueue.isEmpty())
    {
      Iterator localIterator = paramQueue.iterator();
      while (localIterator.hasNext())
      {
        BusinessEggsElement localBusinessEggsElement = (BusinessEggsElement)localIterator.next();
        if (localBusinessEggsElement.a()) {
          localBusinessEggsElement.c();
        }
        localBusinessEggsElement.a(null);
        localBusinessEggsElement.a(null);
      }
      paramQueue.clear();
    }
  }
  
  private BusinessEggsElement b(Object... paramVarArgs)
  {
    BusinessEggsElement localBusinessEggsElement = new BusinessEggsElement(this.a, this.b);
    try
    {
      Object localObject = (Drawable)paramVarArgs[0];
      paramVarArgs = (AioAnimationRule)paramVarArgs[1];
      long l = RandomUtils.a();
      this.h.put(Long.valueOf(l), paramVarArgs);
      localBusinessEggsElement.a = l;
      localBusinessEggsElement.a((Drawable)localObject);
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("[parseEggsAnimationInfo] sig: ");
        ((StringBuilder)localObject).append(l);
        ((StringBuilder)localObject).append(", rule id: ");
        ((StringBuilder)localObject).append(paramVarArgs.b);
        QLog.d("BusinessEggsAnimation", 2, ((StringBuilder)localObject).toString());
      }
      return localBusinessEggsElement;
    }
    catch (Exception paramVarArgs)
    {
      label126:
      break label126;
    }
    return null;
  }
  
  private void e()
  {
    if (!this.e.isEmpty()) {
      this.e.clear();
    }
    a(this.f);
    if (!this.g.isEmpty()) {
      this.g.clear();
    }
  }
  
  protected void a() {}
  
  protected boolean a(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    return false;
  }
  
  protected boolean a(Object... paramVarArgs)
  {
    if (QLog.isColorLevel()) {
      QLog.i("BusinessEggsAnimation", 2, "[start] start animation");
    }
    if (this.e.size() >= 10) {
      return false;
    }
    BusinessEggsElement localBusinessEggsElement = b(paramVarArgs);
    if (localBusinessEggsElement == null) {
      return false;
    }
    try
    {
      paramVarArgs = (ChatMessage)paramVarArgs[2];
    }
    catch (Exception paramVarArgs)
    {
      label52:
      break label52;
    }
    QLog.e("BusinessEggsAnimation", 1, "[start] message is null");
    paramVarArgs = null;
    a(localBusinessEggsElement, paramVarArgs);
    this.e.add(localBusinessEggsElement);
    if (this.d == null)
    {
      this.d = new BusinessEggsAnimation.BusinessEggsQueueDriver(this, null);
      this.b.post(this.d);
    }
    return true;
  }
  
  protected void b() {}
  
  protected boolean b(int paramInt)
  {
    return paramInt == 8;
  }
  
  protected void c()
  {
    if (QLog.isColorLevel()) {
      QLog.i("BusinessEggsAnimation", 2, "[stop] stop animation");
    }
    e();
    this.b.removeCallbacks(this.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.anim.businesseggs.BusinessEggsAnimation
 * JD-Core Version:    0.7.0.1
 */