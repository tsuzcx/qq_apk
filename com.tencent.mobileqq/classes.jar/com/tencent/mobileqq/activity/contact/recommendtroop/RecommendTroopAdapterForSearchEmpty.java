package com.tencent.mobileqq.activity.contact.recommendtroop;

import android.content.Context;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.adapter.RecommendTroopAdapter;
import com.tencent.mobileqq.troop.recommend.data.RecommendTroopItem;

public class RecommendTroopAdapterForSearchEmpty
  extends RecommendTroopAdapter
{
  public RecommendTroopAdapterForSearchEmpty(Context paramContext, QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    super(paramContext, paramQQAppInterface, paramBoolean);
  }
  
  protected int a()
  {
    return 10021;
  }
  
  protected void a(RecommendTroopItem paramRecommendTroopItem)
  {
    ReportController.b(null, "dc00899", "Grp_recom", "", "no_search_result", "clk_grp", 0, 0, paramRecommendTroopItem.uin, paramRecommendTroopItem.recomAlgol, "", "");
  }
  
  protected int b()
  {
    return 109;
  }
  
  protected void b(RecommendTroopItem paramRecommendTroopItem)
  {
    ReportController.b(null, "dc00899", "Grp_recom", "", "no_search_result", "clk_add", 0, 0, String.valueOf(paramRecommendTroopItem.uin), paramRecommendTroopItem.recomAlgol, "", "");
  }
  
  protected int c()
  {
    return 10022;
  }
  
  protected void c(RecommendTroopItem paramRecommendTroopItem)
  {
    ReportController.b(null, "dc00899", "Grp_recom", "", "no_search_result", "exp_grp", 0, 0, paramRecommendTroopItem.uin, paramRecommendTroopItem.recomAlgol, "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.recommendtroop.RecommendTroopAdapterForSearchEmpty
 * JD-Core Version:    0.7.0.1
 */