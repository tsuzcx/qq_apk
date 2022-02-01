import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup.MarginLayoutParams;
import com.tencent.mobileqq.activity.contacts.base.tabs.SimpleSlidingIndicator;

class bosc
  implements Observer<Boolean>
{
  bosc(bory parambory) {}
  
  public void a(@Nullable Boolean paramBoolean)
  {
    if ((paramBoolean != null) && (paramBoolean.booleanValue()))
    {
      paramBoolean = (ViewGroup.MarginLayoutParams)bory.a(this.a).getLayoutParams();
      paramBoolean.topMargin = 0;
      bory.a(this.a).setLayoutParams(paramBoolean);
      paramBoolean = (ViewGroup.MarginLayoutParams)bory.a(this.a).getLayoutParams();
      paramBoolean.topMargin = 0;
      bory.a(this.a).setLayoutParams(paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bosc
 * JD-Core Version:    0.7.0.1
 */