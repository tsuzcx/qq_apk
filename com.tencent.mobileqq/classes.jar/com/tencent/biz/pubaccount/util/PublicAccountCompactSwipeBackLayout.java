package com.tencent.biz.pubaccount.util;

import android.content.Context;
import android.graphics.Rect;
import com.tencent.biz.ui.ISwipeBackCallBack;
import com.tencent.mobileqq.colornote.swipeback.SwipePostTableLayout;

public class PublicAccountCompactSwipeBackLayout
  extends SwipePostTableLayout
  implements ISwipeBackCallBack
{
  protected ReadinjoyH5ElementManager a = new ReadinjoyH5ElementManager();
  private boolean g = true;
  private boolean h = false;
  
  public PublicAccountCompactSwipeBackLayout(Context paramContext)
  {
    super(paramContext);
  }
  
  public void a(String paramString)
  {
    this.a.a(paramString);
  }
  
  public void a(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.a.a(paramString, new Rect(paramInt1, paramInt2, paramInt3, paramInt4));
  }
  
  public void a(boolean paramBoolean)
  {
    this.g = paramBoolean;
  }
  
  public void b(boolean paramBoolean)
  {
    this.h = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.util.PublicAccountCompactSwipeBackLayout
 * JD-Core Version:    0.7.0.1
 */