import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.structmsg.StructMsgForHypertext;

public class axvn
  implements View.OnClickListener
{
  public axvn(StructMsgForHypertext paramStructMsgForHypertext) {}
  
  public void onClick(View paramView)
  {
    new axuu(null, paramView, this.a.message).a("web", this.a.mSourceUrl, null, null);
    axqw.b(null, "CliOper", "", "", "0X800567C", "0X800567C", 0, 0, this.a.mMsgServiceID + "", "", "", "");
    axqw.b(null, "CliOper", "", "", "0X8004B5C", "0X8004B5C", 1, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     axvn
 * JD-Core Version:    0.7.0.1
 */