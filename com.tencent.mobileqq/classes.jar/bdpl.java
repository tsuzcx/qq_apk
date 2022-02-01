import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.structmsg.StructMsgForHypertext;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class bdpl
  implements View.OnClickListener
{
  public bdpl(StructMsgForHypertext paramStructMsgForHypertext) {}
  
  public void onClick(View paramView)
  {
    new bdos(null, paramView, this.a.message).a("web", this.a.mSourceUrl, null, null);
    bdll.b(null, "CliOper", "", "", "0X800567C", "0X800567C", 0, 0, this.a.mMsgServiceID + "", "", "", "");
    bdll.b(null, "CliOper", "", "", "0X8004B5C", "0X8004B5C", 1, 0, "", "", "", "");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdpl
 * JD-Core Version:    0.7.0.1
 */