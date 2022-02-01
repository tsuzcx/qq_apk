import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.TextView;
import com.tencent.mobileqq.campuscircle.CampusCircleReplyActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class aqnc
  implements CompoundButton.OnCheckedChangeListener
{
  public aqnc(CampusCircleReplyActivity paramCampusCircleReplyActivity) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    Object localObject = this.a.getResources();
    TextView localTextView = CampusCircleReplyActivity.a(this.a);
    if (paramBoolean) {}
    for (localObject = ((Resources)localObject).getColorStateList(2131166359);; localObject = ((Resources)localObject).getColorStateList(2131166361))
    {
      localTextView.setTextColor((ColorStateList)localObject);
      EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqnc
 * JD-Core Version:    0.7.0.1
 */