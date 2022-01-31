import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.widget.ImageView;
import com.tencent.mobileqq.profile.CustomCoverFragment;

public class ausr
  extends RecyclerView.ViewHolder
{
  public ausr(CustomCoverFragment paramCustomCoverFragment, View paramView)
  {
    super(paramView);
    this.itemView.setTag(this);
    this.itemView.findViewById(2131361899).setOnClickListener(paramCustomCoverFragment);
    this.itemView.findViewById(2131361907).setOnClickListener(paramCustomCoverFragment);
    this.itemView.findViewById(2131361896).setOnClickListener(paramCustomCoverFragment);
    CustomCoverFragment.a(paramCustomCoverFragment, this.itemView.findViewById(2131368928));
    CustomCoverFragment.a(paramCustomCoverFragment).setVisibility(8);
    CustomCoverFragment.a(paramCustomCoverFragment, (ImageView)this.itemView.findViewById(2131368525));
    CustomCoverFragment.a(paramCustomCoverFragment).setOnClickListener(paramCustomCoverFragment.a);
    actj.a(CustomCoverFragment.a(paramCustomCoverFragment), 0, 0, (int)(CustomCoverFragment.a(paramCustomCoverFragment) * 20.0F + 0.5F), (int)(CustomCoverFragment.b(paramCustomCoverFragment) * 20.0F + 0.5F));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ausr
 * JD-Core Version:    0.7.0.1
 */