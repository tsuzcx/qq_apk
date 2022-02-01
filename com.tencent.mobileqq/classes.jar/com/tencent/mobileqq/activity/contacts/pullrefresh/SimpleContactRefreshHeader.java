package com.tencent.mobileqq.activity.contacts.pullrefresh;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.SimpleLottiePullRefreshHeader;

public class SimpleContactRefreshHeader
  extends SimpleLottiePullRefreshHeader
  implements SwipeRefreshTrigger, SwipeTrigger
{
  private boolean c = false;
  private int d = ViewUtils.dpToPx(26.0F);
  private int e = ViewUtils.dpToPx(60.0F);
  
  public SimpleContactRefreshHeader(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public SimpleContactRefreshHeader(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public SimpleContactRefreshHeader(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setBackgroundColor(getResources().getColor(2131168188));
  }
  
  private void setRefresh(boolean paramBoolean)
  {
    this.c = paramBoolean;
  }
  
  public void a() {}
  
  public void a(int paramInt, Object paramObject)
  {
    super.a(paramInt, paramObject);
    if (paramInt == 18)
    {
      setRefresh(((Boolean)paramObject).booleanValue());
      return;
    }
    if (paramInt == 26) {
      onSpringBack();
    }
  }
  
  public void a(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((!paramBoolean1) && (!this.c))
    {
      int i = this.d;
      a(3, Float.valueOf((paramInt - i) / (this.e - i) / 2.0F));
    }
  }
  
  public Object b(int paramInt, Object paramObject)
  {
    paramObject = super.b(paramInt, paramObject);
    if (paramObject != null) {
      return paramObject;
    }
    if (paramInt == 25) {
      return Integer.valueOf(this.e);
    }
    return null;
  }
  
  public void b()
  {
    if (!this.c)
    {
      this.c = true;
      a(0L);
    }
  }
  
  public void c() {}
  
  public void d() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.pullrefresh.SimpleContactRefreshHeader
 * JD-Core Version:    0.7.0.1
 */