import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup.MarginLayoutParams;
import com.tencent.mobileqq.activity.contacts.base.tabs.SimpleSlidingIndicator;

class bnlr
  implements Observer<Boolean>
{
  bnlr(bnln parambnln) {}
  
  public void a(@Nullable Boolean paramBoolean)
  {
    if ((paramBoolean != null) && (paramBoolean.booleanValue()))
    {
      paramBoolean = (ViewGroup.MarginLayoutParams)bnln.a(this.a).getLayoutParams();
      paramBoolean.topMargin = 0;
      bnln.a(this.a).setLayoutParams(paramBoolean);
      paramBoolean = (ViewGroup.MarginLayoutParams)bnln.a(this.a).getLayoutParams();
      paramBoolean.topMargin = 0;
      bnln.a(this.a).setLayoutParams(paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnlr
 * JD-Core Version:    0.7.0.1
 */