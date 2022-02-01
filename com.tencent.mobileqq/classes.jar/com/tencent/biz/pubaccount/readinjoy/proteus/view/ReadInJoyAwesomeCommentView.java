package com.tencent.biz.pubaccount.readinjoy.proteus.view;

import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.impl.NativeAwesomeCommentView;
import com.tencent.biz.pubaccount.readinjoy.struct.AwesomeCommentInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;

public class ReadInJoyAwesomeCommentView
  extends ViewBase
{
  private NativeAwesomeCommentView a;
  
  public ReadInJoyAwesomeCommentView(VafContext paramVafContext)
  {
    super(paramVafContext);
    this.a = new NativeAwesomeCommentView(paramVafContext.getContext());
  }
  
  public int getComMeasuredHeight()
  {
    return this.a.getComMeasuredHeight();
  }
  
  public int getComMeasuredWidth()
  {
    return this.a.getComMeasuredWidth();
  }
  
  public View getNativeView()
  {
    return this.a;
  }
  
  public void onComLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (this.a != null) {
      this.a.layout(paramInt1, paramInt2, paramInt3, paramInt4);
    }
  }
  
  public void onComMeasure(int paramInt1, int paramInt2)
  {
    if (this.a != null) {
      this.a.measure(paramInt1, paramInt2);
    }
  }
  
  public boolean setAttribute(int paramInt, Object paramObject)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return super.setAttribute(paramInt, paramObject);
      if (((paramObject instanceof AwesomeCommentInfo)) && (this.a != null)) {
        this.a.setAwesomeCommentInfo((AwesomeCommentInfo)paramObject);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.proteus.view.ReadInJoyAwesomeCommentView
 * JD-Core Version:    0.7.0.1
 */