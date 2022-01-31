import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.tencent.mobileqq.troopAddFrd.TroopRecommendFriendFragment;

public class bcpt
  extends ahga<bcpp>
{
  public bcpt(TroopRecommendFriendFragment paramTroopRecommendFriendFragment, Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
  }
  
  protected void a(ahgk paramahgk, bcpp parambcpp, int paramInt)
  {
    TroopRecommendFriendFragment.a(this.a, paramahgk, parambcpp, paramInt);
  }
  
  protected ahgk b(Context paramContext, ViewGroup paramViewGroup, int paramInt)
  {
    return new bcpo(paramContext, LayoutInflater.from(paramContext).inflate(paramInt, paramViewGroup, false));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcpt
 * JD-Core Version:    0.7.0.1
 */