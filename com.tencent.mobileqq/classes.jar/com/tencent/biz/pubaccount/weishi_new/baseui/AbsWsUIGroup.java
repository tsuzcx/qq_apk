package com.tencent.biz.pubaccount.weishi_new.baseui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;

public abstract class AbsWsUIGroup<T>
  extends AbsWsUI<T>
  implements IPlayModeChangeListener
{
  protected int f = 1;
  
  public AbsWsUIGroup(Context paramContext)
  {
    super(paramContext);
  }
  
  public void a(View paramView)
  {
    if ((paramView != null) && (k()))
    {
      ((ViewGroup)this.b).addView(paramView);
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramView);
    localStringBuilder.append(" is not a viewGroup");
    WSLog.d("AbsWsUIGroup", localStringBuilder.toString());
  }
  
  public void a(ViewStub paramViewStub)
  {
    paramViewStub.setLayoutResource(i());
    this.b = paramViewStub.inflate();
    j();
  }
  
  public View c(int paramInt)
  {
    if (this.b != null) {
      return this.b.findViewById(paramInt);
    }
    return null;
  }
  
  protected abstract int i();
  
  protected abstract void j();
  
  protected boolean k()
  {
    return (this.b != null) && ((this.b instanceof ViewGroup));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.baseui.AbsWsUIGroup
 * JD-Core Version:    0.7.0.1
 */