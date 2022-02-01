import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class bjzd
  implements View.OnClickListener
{
  bjzd(bjzc parambjzc) {}
  
  public void onClick(View paramView)
  {
    CheckBox localCheckBox = bjzc.a(this.a);
    if (!bjzc.a(this.a).isChecked()) {}
    for (boolean bool = true;; bool = false)
    {
      localCheckBox.setChecked(bool);
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bjzd
 * JD-Core Version:    0.7.0.1
 */