import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.profile.CustomCoverFragment;

public class azow
  extends RecyclerView.ViewHolder
{
  public azow(CustomCoverFragment paramCustomCoverFragment, View paramView)
  {
    super(paramView);
    this.itemView.setTag(this);
    this.itemView.findViewById(2131361955).setOnClickListener(paramCustomCoverFragment);
    this.itemView.findViewById(2131361964).setOnClickListener(paramCustomCoverFragment);
    this.itemView.findViewById(2131361950).setOnClickListener(paramCustomCoverFragment);
    CustomCoverFragment.a(paramCustomCoverFragment, this.itemView.findViewById(2131369819));
    CustomCoverFragment.a(paramCustomCoverFragment).setVisibility(8);
    CustomCoverFragment.a(paramCustomCoverFragment, (ImageView)this.itemView.findViewById(2131369347));
    CustomCoverFragment.a(paramCustomCoverFragment).setOnClickListener(paramCustomCoverFragment.a);
    AIOUtils.expandViewTouchDelegate(CustomCoverFragment.a(paramCustomCoverFragment), 0, 0, (int)(CustomCoverFragment.a(paramCustomCoverFragment) * 20.0F + 0.5F), (int)(CustomCoverFragment.b(paramCustomCoverFragment) * 20.0F + 0.5F));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azow
 * JD-Core Version:    0.7.0.1
 */