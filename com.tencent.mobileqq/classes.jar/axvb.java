import android.text.TextUtils;
import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;

public class axvb
  implements View.OnLongClickListener
{
  public axvb(StructMsgForGeneralShare paramStructMsgForGeneralShare, acxn paramacxn) {}
  
  public boolean onLongClick(View paramView)
  {
    StructMsgForGeneralShare.clickedItemIndex = 0;
    axun localaxun = (axun)paramView.getTag();
    if (!TextUtils.isEmpty(localaxun.Q)) {
      StructMsgForGeneralShare.clickedItemIndex = Integer.valueOf(localaxun.Q).intValue();
    }
    return this.jdField_a_of_type_Acxn.onLongClick(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     axvb
 * JD-Core Version:    0.7.0.1
 */