package com.tencent.mobileqq.activity.aio.helper;

import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.core.helper.OnFinishListener;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.qphone.base.util.QLog;

public class SpecWordEmotionThinkHelper
  implements OnFinishListener, ILifeCycleHelper
{
  private BaseChatPie a;
  private int b = 0;
  
  public SpecWordEmotionThinkHelper(BaseChatPie paramBaseChatPie)
  {
    this.a = paramBaseChatPie;
  }
  
  public void a()
  {
    b();
  }
  
  public void a(int paramInt)
  {
    this.b = paramInt;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(" setSpecWordType:  mSpecWordType=");
      localStringBuilder.append(this.b);
      QLog.d("SpecWordEmotionThinkHelper", 2, localStringBuilder.toString());
    }
  }
  
  public void a(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    if (QLog.isColorLevel())
    {
      paramCharSequence = new StringBuilder();
      paramCharSequence.append(" beforeTextChanged:  start=");
      paramCharSequence.append(paramInt1);
      paramCharSequence.append(" after=");
      paramCharSequence.append(paramInt3);
      paramCharSequence.append(" count=");
      paramCharSequence.append(paramInt2);
      QLog.d("SpecWordEmotionThinkHelper", 2, paramCharSequence.toString());
    }
    if ((paramInt2 > paramInt3) || (paramInt3 == 0)) {
      b();
    }
  }
  
  public boolean a(boolean paramBoolean)
  {
    return false;
  }
  
  public void b()
  {
    this.b = 0;
    if (QLog.isColorLevel()) {
      QLog.d("SpecWordEmotionThinkHelper", 2, " clearSpecWordType");
    }
  }
  
  public int bM_()
  {
    a();
    return 0;
  }
  
  public String d()
  {
    String str;
    if (this.b == 1) {
      str = HardCodeUtil.a(2131911650);
    } else {
      str = null;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(" getSpecKeyWord:  mSpecWordType=");
      localStringBuilder.append(this.b);
      QLog.d("SpecWordEmotionThinkHelper", 2, localStringBuilder.toString());
    }
    return str;
  }
  
  public boolean d(int paramInt)
  {
    return false;
  }
  
  public void e(int paramInt) {}
  
  public boolean e()
  {
    int i = this.b;
    boolean bool = true;
    if (i != 1) {
      bool = false;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(" needSendMixMsg:  mSpecWordType=");
      localStringBuilder.append(this.b);
      QLog.d("SpecWordEmotionThinkHelper", 2, localStringBuilder.toString());
    }
    return bool;
  }
  
  public String getTag()
  {
    return "SpecWordEmotionThinkHelper";
  }
  
  public int[] interestedIn()
  {
    return new int[] { 15, 19 };
  }
  
  public void onMoveToState(int paramInt)
  {
    if ((paramInt != 15) && (paramInt != 19)) {
      return;
    }
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.SpecWordEmotionThinkHelper
 * JD-Core Version:    0.7.0.1
 */