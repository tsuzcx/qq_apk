package com.tencent.biz.pubaccount.readinjoy.proteus.view;

import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.model.IReadInJoyModel;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.impl.NativeAvatarView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;

public class AvatarView
  extends ViewBase
{
  private NativeAvatarView a;
  
  public AvatarView(VafContext paramVafContext)
  {
    super(paramVafContext);
    this.a = new NativeAvatarView(paramVafContext.a());
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
    this.a.a();
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.a.b(paramInt1, paramInt2);
  }
  
  public void a(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.a.a(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  protected boolean a(int paramInt)
  {
    super.a(paramInt);
    this.a.b();
    return true;
  }
  
  protected boolean a(int paramInt, Object paramObject)
  {
    boolean bool = true;
    switch (paramInt)
    {
    default: 
      bool = false;
    }
    do
    {
      do
      {
        return bool;
      } while (!(paramObject instanceof Long));
      this.a.setUin(((Long)paramObject).longValue());
      return true;
    } while (!(paramObject instanceof IReadInJoyModel));
    this.a.setModel((IReadInJoyModel)paramObject);
    return true;
  }
  
  public int b()
  {
    return this.a.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.proteus.view.AvatarView
 * JD-Core Version:    0.7.0.1
 */