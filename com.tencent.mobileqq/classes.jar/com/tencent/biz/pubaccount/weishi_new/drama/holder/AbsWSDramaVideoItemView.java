package com.tencent.biz.pubaccount.weishi_new.drama.holder;

import android.content.Context;
import android.view.View;
import com.tencent.biz.pubaccount.weishi_new.baseui.AbsWSItemView;
import com.tencent.biz.pubaccount.weishi_new.drama.WSDramaPageContract.View;
import com.tencent.biz.pubaccount.weishi_new.drama.WSDramaPageFragment;
import com.tencent.biz.pubaccount.weishi_new.drama.data.WSDramaItemData;
import com.tencent.biz.pubaccount.weishi_new.drama.holder.controller.WSDramaItemVideoAreaController;
import com.tencent.biz.pubaccount.weishi_new.drama.utils.WSDramaUtils;
import mqq.util.WeakReference;

public abstract class AbsWSDramaVideoItemView
  extends AbsWSItemView<WSDramaItemData>
{
  private WSDramaItemVideoAreaController d;
  private final WeakReference<WSDramaPageContract.View> e;
  
  public AbsWSDramaVideoItemView(Context paramContext, View paramView, WSDramaPageContract.View paramView1)
  {
    super(paramContext, paramView);
    this.e = new WeakReference(paramView1);
  }
  
  private void f()
  {
    WSDramaPageContract.View localView = (WSDramaPageContract.View)this.e.get();
    if ((localView instanceof WSDramaPageFragment)) {
      WSDramaUtils.a((WSDramaPageFragment)localView, ((WSDramaItemData)this.c).b(), ((WSDramaItemData)this.c).d(), WSDramaUtils.a);
    }
  }
  
  public void b()
  {
    this.d = new WSDramaItemVideoAreaController(this.b);
    a(2131449761, this.d);
    this.a.setOnClickListener(new AbsWSDramaVideoItemView.1(this));
  }
  
  public void c() {}
  
  public void d() {}
  
  public void d(int paramInt) {}
  
  public WSDramaItemVideoAreaController e()
  {
    return this.d;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.drama.holder.AbsWSDramaVideoItemView
 * JD-Core Version:    0.7.0.1
 */