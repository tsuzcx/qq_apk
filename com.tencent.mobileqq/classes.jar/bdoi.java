import android.text.TextUtils;
import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;

public class bdoi
  implements View.OnLongClickListener
{
  public bdoi(StructMsgForGeneralShare paramStructMsgForGeneralShare, aftk paramaftk) {}
  
  public boolean onLongClick(View paramView)
  {
    StructMsgForGeneralShare.clickedItemIndex = 0;
    bdnu localbdnu = (bdnu)paramView.getTag();
    if (!TextUtils.isEmpty(localbdnu.aa)) {
      StructMsgForGeneralShare.clickedItemIndex = Integer.valueOf(localbdnu.aa).intValue();
    }
    return this.jdField_a_of_type_Aftk.onLongClick(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdoi
 * JD-Core Version:    0.7.0.1
 */