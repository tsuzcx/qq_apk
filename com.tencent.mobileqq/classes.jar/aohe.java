import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import android.support.v7.widget.StaggeredGridLayoutManager;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.extendfriend.fragment.ExtendFriendGroupFragment;

public class aohe
  extends RecyclerView.OnScrollListener
{
  public aohe(ExtendFriendGroupFragment paramExtendFriendGroupFragment) {}
  
  public void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
  {
    if (paramInt == 0)
    {
      URLDrawable.resume();
      return;
    }
    URLDrawable.pause();
  }
  
  public void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    super.onScrolled(paramRecyclerView, paramInt1, paramInt2);
    if ((!ExtendFriendGroupFragment.a(this.a)) && (!ExtendFriendGroupFragment.b(this.a)) && (this.a.a != null) && (ExtendFriendGroupFragment.a(this.a) != null) && (ExtendFriendGroupFragment.a(this.a).a() > 0) && (this.a.a.findViewByPosition(ExtendFriendGroupFragment.a(this.a).getItemCount() - 1) != null))
    {
      if (bbev.g(ExtendFriendGroupFragment.a(this.a)))
      {
        ExtendFriendGroupFragment.a(this.a, true);
        ExtendFriendGroupFragment.a(this.a).a(0, true);
        axqw.b(ExtendFriendGroupFragment.a(this.a), "dc00898", "", "", "0X80092D9", "0X80092D9", 0, 0, "", "", "", "");
      }
    }
    else {
      return;
    }
    ExtendFriendGroupFragment.a(this.a).a(1, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aohe
 * JD-Core Version:    0.7.0.1
 */