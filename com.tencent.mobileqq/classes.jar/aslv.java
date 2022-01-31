import android.content.Context;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.gamecenter.data.FeedsItemData;

public abstract class aslv
  extends RecyclerView.ViewHolder
{
  public aslv(Context paramContext, View paramView, ViewGroup paramViewGroup)
  {
    super(paramView);
  }
  
  public abstract void a(FeedsItemData paramFeedsItemData);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aslv
 * JD-Core Version:    0.7.0.1
 */