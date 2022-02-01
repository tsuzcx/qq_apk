import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import com.tencent.mobileqq.extendfriend.wiget.ExtendFriendCampusVerifyTipsView;

public class aswo
  extends RecyclerView.ViewHolder
{
  private ExtendFriendCampusVerifyTipsView a;
  
  public aswo(View paramView, atdp paramatdp)
  {
    super(paramView);
    this.a = ((ExtendFriendCampusVerifyTipsView)paramView);
    this.a.setOnClickListener(paramatdp);
  }
  
  public void a(asxh paramasxh, int paramInt)
  {
    if ((paramasxh instanceof aswp))
    {
      paramasxh = (aswp)paramasxh;
      this.a.setTipsType(paramasxh.a);
      this.a.setPadding(0, paramInt, 0, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aswo
 * JD-Core Version:    0.7.0.1
 */