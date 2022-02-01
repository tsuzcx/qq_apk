import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class bkro
  implements View.OnClickListener
{
  bkro(bkrn parambkrn) {}
  
  public void onClick(View paramView)
  {
    CheckBox localCheckBox = bkrn.a(this.a);
    if (!bkrn.a(this.a).isChecked()) {}
    for (boolean bool = true;; bool = false)
    {
      localCheckBox.setChecked(bool);
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkro
 * JD-Core Version:    0.7.0.1
 */