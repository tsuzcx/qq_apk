package com.tencent.mobileqq.activity.contact.recommendtroop;

import android.content.Context;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.adapter.RecommendTroopAdapter;
import com.tencent.mobileqq.troop.recommend.RecommendTroopListWrapper;
import com.tencent.mobileqq.troop.recommend.RecommendTroopListWrapper.RecommendTroopListWrapperCallback;
import com.tencent.widget.XListView;

public class RecommendTroopListWrapperForSearchEmpty
  extends RecommendTroopListWrapper
{
  public RecommendTroopListWrapperForSearchEmpty(QQAppInterface paramQQAppInterface, Context paramContext, XListView paramXListView, RecommendTroopListWrapper.RecommendTroopListWrapperCallback paramRecommendTroopListWrapperCallback)
  {
    super(paramQQAppInterface, paramContext, paramXListView, paramRecommendTroopListWrapperCallback);
  }
  
  protected RecommendTroopAdapter a()
  {
    return new RecommendTroopAdapterForSearchEmpty(this.j, (QQAppInterface)this.i, true);
  }
  
  protected void b()
  {
    super.b();
    ReportController.b(null, "dc00899", "Grp_recom", "", "no_search_result", "exp", 0, 0, "", "", "", "");
  }
  
  public void f()
  {
    super.f();
    ReportController.b(null, "dc00899", "Grp_recom", "", "no_search_result", "exp", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.recommendtroop.RecommendTroopListWrapperForSearchEmpty
 * JD-Core Version:    0.7.0.1
 */