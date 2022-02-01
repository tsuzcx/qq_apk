import android.support.v7.widget.RecyclerView;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class boni
  implements CompoundButton.OnCheckedChangeListener
{
  boni(bonf parambonf) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    RecyclerView localRecyclerView = bonf.b(this.a);
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
 * Qualified Name:     boni
 * JD-Core Version:    0.7.0.1
 */