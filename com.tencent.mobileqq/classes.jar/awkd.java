import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.widget.ImageView;
import com.tencent.mobileqq.profile.CustomCoverFragment;

public class awkd
  extends RecyclerView.ViewHolder
{
  public awkd(CustomCoverFragment paramCustomCoverFragment, View paramView)
  {
    super(paramView);
    this.itemView.setTag(this);
    this.itemView.findViewById(2131361899).setOnClickListener(paramCustomCoverFragment);
    this.itemView.findViewById(2131361907).setOnClickListener(paramCustomCoverFragment);
    this.itemView.findViewById(2131361896).setOnClickListener(paramCustomCoverFragment);
    CustomCoverFragment.a(paramCustomCoverFragment, this.itemView.findViewById(2131369158));
    CustomCoverFragment.a(paramCustomCoverFragment).setVisibility(8);
    CustomCoverFragment.a(paramCustomCoverFragment, (ImageView)this.itemView.findViewById(2131368721));
    CustomCoverFragment.a(paramCustomCoverFragment).setOnClickListener(paramCustomCoverFragment.a);
    aekt.a(CustomCoverFragment.a(paramCustomCoverFragment), 0, 0, (int)(CustomCoverFragment.a(paramCustomCoverFragment) * 20.0F + 0.5F), (int)(CustomCoverFragment.b(paramCustomCoverFragment) * 20.0F + 0.5F));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     awkd
 * JD-Core Version:    0.7.0.1
 */