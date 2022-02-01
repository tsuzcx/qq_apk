import android.support.v7.widget.RecyclerView;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class blro
  implements CompoundButton.OnCheckedChangeListener
{
  blro(blrm paramblrm) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    RecyclerView localRecyclerView = blrm.a(this.a);
    if (paramBoolean) {}
    for (int i = 0;; i = 8)
    {
      localRecyclerView.setVisibility(i);
      EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blro
 * JD-Core Version:    0.7.0.1
 */