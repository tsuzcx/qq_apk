package com.tencent.mobileqq.activity.contact.recommendtroop;

import android.content.Context;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.adapter.RecommendTroopAdapter;
import com.tencent.mobileqq.troop.recommend.data.RecommendTroopItem;

public class RecommendTroopAdapterForAddContact
  extends RecommendTroopAdapter
{
  public RecommendTroopAdapterForAddContact(Context paramContext, QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    super(paramContext, paramQQAppInterface, paramBoolean);
  }
  
  protected int a()
  {
    return 10028;
  }
  
  protected void a(RecommendTroopItem paramRecommendTroopItem)
  {
    super.a(paramRecommendTroopItem);
    ReportController.b(null, "dc00899", "Grp_find_new", "", "grptab", "Clk_join", 0, 0, paramRecommendTroopItem.uin, paramRecommendTroopItem.recomAlgol, "", "");
  }
  
  protected int b()
  {
    return 21;
  }
  
  protected void b(RecommendTroopItem paramRecommendTroopItem)
  {
    super.b(paramRecommendTroopItem);
    ReportController.b(null, "dc00899", "Grp_recom", "", "search", "recom_clk_add", 0, 0, paramRecommendTroopItem.uin, paramRecommendTroopItem.recomAlgol, "", "");
  }
  
  protected int c()
  {
    return 10003;
  }
  
  protected void c(RecommendTroopItem paramRecommendTroopItem)
  {
    super.c(paramRecommendTroopItem);
    ReportController.b(null, "dc00899", "Grp_find_new", "", "grptab", "exp_grp", 0, 0, paramRecommendTroopItem.uin, paramRecommendTroopItem.recomAlgol, "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.recommendtroop.RecommendTroopAdapterForAddContact
 * JD-Core Version:    0.7.0.1
 */