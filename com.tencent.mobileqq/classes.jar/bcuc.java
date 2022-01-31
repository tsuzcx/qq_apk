import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.tencent.mobileqq.troopAddFrd.TroopRecommendFriendFragment;

public class bcuc
  extends ahkp<bcty>
{
  public bcuc(TroopRecommendFriendFragment paramTroopRecommendFriendFragment, Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
  }
  
  protected void a(ahkz paramahkz, bcty parambcty, int paramInt)
  {
    TroopRecommendFriendFragment.a(this.a, paramahkz, parambcty, paramInt);
  }
  
  protected ahkz b(Context paramContext, ViewGroup paramViewGroup, int paramInt)
  {
    return new bctx(paramContext, LayoutInflater.from(paramContext).inflate(paramInt, paramViewGroup, false));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcuc
 * JD-Core Version:    0.7.0.1
 */