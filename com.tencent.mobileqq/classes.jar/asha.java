import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import com.tencent.mobileqq.extendfriend.wiget.ExtendFriendCampusVerifyTipsView;

public class asha
  extends RecyclerView.ViewHolder
{
  private ExtendFriendCampusVerifyTipsView a;
  
  public asha(View paramView, asnl paramasnl)
  {
    super(paramView);
    this.a = ((ExtendFriendCampusVerifyTipsView)paramView);
    this.a.setOnClickListener(paramasnl);
  }
  
  public void a(asht paramasht, int paramInt)
  {
    if ((paramasht instanceof ashb))
    {
      paramasht = (ashb)paramasht;
      this.a.setTipsType(paramasht.a);
      this.a.setPadding(0, paramInt, 0, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asha
 * JD-Core Version:    0.7.0.1
 */