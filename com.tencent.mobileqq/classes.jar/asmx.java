import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import com.tencent.mobileqq.extendfriend.wiget.ExtendFriendCampusVerifyTipsView;

public class asmx
  extends RecyclerView.ViewHolder
{
  private ExtendFriendCampusVerifyTipsView a;
  
  public asmx(View paramView, asud paramasud)
  {
    super(paramView);
    this.a = ((ExtendFriendCampusVerifyTipsView)paramView);
    this.a.setOnClickListener(paramasud);
  }
  
  public void a(asnq paramasnq, int paramInt)
  {
    if ((paramasnq instanceof asmy))
    {
      paramasnq = (asmy)paramasnq;
      this.a.setTipsType(paramasnq.a);
      this.a.setPadding(0, paramInt, 0, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asmx
 * JD-Core Version:    0.7.0.1
 */