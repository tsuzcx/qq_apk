import android.content.res.Resources;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.TextView;
import com.tencent.mobileqq.campuscircle.CampusCircleReplyActivity;

public class aobi
  implements CompoundButton.OnCheckedChangeListener
{
  public aobi(CampusCircleReplyActivity paramCampusCircleReplyActivity) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    paramCompoundButton = this.a.getResources();
    TextView localTextView = CampusCircleReplyActivity.a(this.a);
    if (paramBoolean) {}
    for (paramCompoundButton = paramCompoundButton.getColorStateList(2131166256);; paramCompoundButton = paramCompoundButton.getColorStateList(2131166258))
    {
      localTextView.setTextColor(paramCompoundButton);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aobi
 * JD-Core Version:    0.7.0.1
 */