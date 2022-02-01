package com.tencent.biz.pubaccount.readinjoy;

import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.biz.pubaccount.readinjoy.engine.RIJXTabNormalRedDotStore;
import com.tencent.biz.pubaccount.readinjoy.view.widget.RIJXTabBar;
import com.tencent.biz.pubaccount.readinjoy.view.widget.RIJXTabLayout;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import kotlin.Metadata;
import kotlin.TypeCastException;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class RIJXTabViewPagerController$onPageChangeListener$1$onPageSelected$1
  implements Runnable
{
  RIJXTabViewPagerController$onPageChangeListener$1$onPageSelected$1(RIJXTabViewPagerController.onPageChangeListener.1 param1, int paramInt) {}
  
  public final void run()
  {
    RIJXTabNormalRedDotStore.a.a(this.a, true);
    Object localObject = ReadInJoyUtils.a();
    if (localObject == null) {
      throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
    }
    localObject = ((QQAppInterface)localObject).getManager(QQManagerFactory.KANDIAN_MERGE_MANAGER);
    if (localObject == null) {
      throw new TypeCastException("null cannot be cast to non-null type com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager");
    }
    ((KandianMergeManager)localObject).l();
    RIJXTabViewPagerController.a(this.this$0.a).a().a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.RIJXTabViewPagerController.onPageChangeListener.1.onPageSelected.1
 * JD-Core Version:    0.7.0.1
 */