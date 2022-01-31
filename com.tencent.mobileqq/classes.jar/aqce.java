import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import com.tencent.mobileqq.extendfriend.wiget.ExtendFriendCampusVerifyTipsView;

public class aqce
  extends RecyclerView.ViewHolder
{
  private ExtendFriendCampusVerifyTipsView a;
  
  public aqce(View paramView, aqib paramaqib)
  {
    super(paramView);
    this.a = ((ExtendFriendCampusVerifyTipsView)paramView);
    this.a.setOnClickListener(paramaqib);
  }
  
  public void a(aqcx paramaqcx, int paramInt)
  {
    if ((paramaqcx instanceof aqcf))
    {
      paramaqcx = (aqcf)paramaqcx;
      this.a.setTipsType(paramaqcx.a);
      this.a.setPadding(0, paramInt, 0, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqce
 * JD-Core Version:    0.7.0.1
 */