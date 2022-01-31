import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import com.tencent.mobileqq.extendfriend.wiget.ExtendFriendCampusVerifyTipsView;

public class apxv
  extends RecyclerView.ViewHolder
{
  private ExtendFriendCampusVerifyTipsView a;
  
  public apxv(View paramView, aqds paramaqds)
  {
    super(paramView);
    this.a = ((ExtendFriendCampusVerifyTipsView)paramView);
    this.a.setOnClickListener(paramaqds);
  }
  
  public void a(apyo paramapyo, int paramInt)
  {
    if ((paramapyo instanceof apxw))
    {
      paramapyo = (apxw)paramapyo;
      this.a.setTipsType(paramapyo.a);
      this.a.setPadding(0, paramInt, 0, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apxv
 * JD-Core Version:    0.7.0.1
 */