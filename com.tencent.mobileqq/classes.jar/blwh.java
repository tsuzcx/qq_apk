import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup.MarginLayoutParams;
import com.tencent.mobileqq.activity.contacts.base.tabs.SimpleSlidingIndicator;

class blwh
  implements Observer<Boolean>
{
  blwh(blwd paramblwd) {}
  
  public void a(@Nullable Boolean paramBoolean)
  {
    if ((paramBoolean != null) && (paramBoolean.booleanValue()))
    {
      paramBoolean = (ViewGroup.MarginLayoutParams)blwd.a(this.a).getLayoutParams();
      paramBoolean.topMargin = 0;
      blwd.a(this.a).setLayoutParams(paramBoolean);
      paramBoolean = (ViewGroup.MarginLayoutParams)blwd.a(this.a).getLayoutParams();
      paramBoolean.topMargin = 0;
      blwd.a(this.a).setLayoutParams(paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blwh
 * JD-Core Version:    0.7.0.1
 */