import android.content.Context;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.gamecenter.data.FeedsItemData;

public abstract class avch
  extends RecyclerView.ViewHolder
{
  public avch(Context paramContext, View paramView, ViewGroup paramViewGroup)
  {
    super(paramView);
  }
  
  public abstract void a(FeedsItemData paramFeedsItemData);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avch
 * JD-Core Version:    0.7.0.1
 */