package com.tencent.biz.pubaccount.readinjoy.viola.reward;

import android.content.Context;
import android.widget.FrameLayout;
import com.tencent.viola.ui.view.IVView;
import java.lang.ref.WeakReference;

public class VKdRewardTaskLayout
  extends FrameLayout
  implements IVView<VKdRewardTaskVideoTimer>
{
  private WeakReference<VKdRewardTaskVideoTimer> a;
  
  public VKdRewardTaskLayout(Context paramContext)
  {
    super(paramContext);
  }
  
  public VKdRewardTaskVideoTimer a()
  {
    if (this.a != null) {
      return (VKdRewardTaskVideoTimer)this.a.get();
    }
    return null;
  }
  
  public void a(VKdRewardTaskVideoTimer paramVKdRewardTaskVideoTimer)
  {
    this.a = new WeakReference(paramVKdRewardTaskVideoTimer);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.viola.reward.VKdRewardTaskLayout
 * JD-Core Version:    0.7.0.1
 */