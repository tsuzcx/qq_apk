import android.content.Context;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.troop.data.RecommendTroopItem;

public class bfkc
  extends ajcf
{
  public bfkc(Context paramContext, QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    super(paramContext, paramQQAppInterface, paramBoolean);
  }
  
  protected int a()
  {
    return 10100;
  }
  
  protected void a(RecommendTroopItem paramRecommendTroopItem)
  {
    String str1 = paramRecommendTroopItem.uin;
    String str2 = paramRecommendTroopItem.recomAlgol;
    if (paramRecommendTroopItem.isJoined()) {}
    for (paramRecommendTroopItem = "1";; paramRecommendTroopItem = "2")
    {
      bcst.b(null, "dc00899", "Grp_recom", "", "set_page", "clk_grp", 0, 0, str1, str2, paramRecommendTroopItem, "");
      return;
    }
  }
  
  protected int b()
  {
    return 39;
  }
  
  protected void b(RecommendTroopItem paramRecommendTroopItem)
  {
    String str1 = String.valueOf(paramRecommendTroopItem.uin);
    String str2 = paramRecommendTroopItem.recomAlgol;
    if (paramRecommendTroopItem.isJoined()) {}
    for (paramRecommendTroopItem = "1";; paramRecommendTroopItem = "2")
    {
      bcst.b(null, "dc00899", "Grp_recom", "", "set_page", "clk_add", 0, 0, str1, str2, paramRecommendTroopItem, "");
      return;
    }
  }
  
  protected int c()
  {
    return 10101;
  }
  
  protected void c(RecommendTroopItem paramRecommendTroopItem)
  {
    String str1 = paramRecommendTroopItem.uin;
    String str2 = paramRecommendTroopItem.recomAlgol;
    if (paramRecommendTroopItem.isJoined()) {}
    for (paramRecommendTroopItem = "1";; paramRecommendTroopItem = "2")
    {
      bcst.b(null, "dc00899", "Grp_recom", "", "set_page", "exp_grp", 0, 0, str1, str2, paramRecommendTroopItem, "");
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfkc
 * JD-Core Version:    0.7.0.1
 */