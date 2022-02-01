import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import com.tencent.mobileqq.extendfriend.wiget.ExtendFriendCampusVerifyTipsView;

public class arir
  extends RecyclerView.ViewHolder
{
  private ExtendFriendCampusVerifyTipsView a;
  
  public arir(View paramView, arpx paramarpx)
  {
    super(paramView);
    this.a = ((ExtendFriendCampusVerifyTipsView)paramView);
    this.a.setOnClickListener(paramarpx);
  }
  
  public void a(arjk paramarjk, int paramInt)
  {
    if ((paramarjk instanceof aris))
    {
      paramarjk = (aris)paramarjk;
      this.a.setTipsType(paramarjk.a);
      this.a.setPadding(0, paramInt, 0, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arir
 * JD-Core Version:    0.7.0.1
 */