package com.tencent.biz.pubaccount.readinjoy.proteus.view;

import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.impl.NativeGridImageView;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;

public class GridImageView
  extends ViewBase
{
  private NativeGridImageView a;
  
  public GridImageView(VafContext paramVafContext)
  {
    super(paramVafContext);
    this.a = new NativeGridImageView(paramVafContext.a());
  }
  
  public int a()
  {
    return this.a.a();
  }
  
  public View a()
  {
    return this.a;
  }
  
  public void a()
  {
    super.a();
    this.a.a(this);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.a.b(paramInt1, paramInt2);
  }
  
  public void a(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.a.a(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  protected boolean a(int paramInt, Object paramObject)
  {
    switch (paramInt)
    {
    default: 
      return false;
    }
    if ((paramObject instanceof ArticleInfo)) {
      this.a.a((ArticleInfo)paramObject);
    }
    return true;
  }
  
  public int b()
  {
    return this.a.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.proteus.view.GridImageView
 * JD-Core Version:    0.7.0.1
 */