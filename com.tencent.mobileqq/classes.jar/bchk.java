import android.text.TextUtils;
import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;

public class bchk
  implements View.OnLongClickListener
{
  public bchk(StructMsgForGeneralShare paramStructMsgForGeneralShare, afce paramafce) {}
  
  public boolean onLongClick(View paramView)
  {
    StructMsgForGeneralShare.clickedItemIndex = 0;
    bcgw localbcgw = (bcgw)paramView.getTag();
    if (!TextUtils.isEmpty(localbcgw.aa)) {
      StructMsgForGeneralShare.clickedItemIndex = Integer.valueOf(localbcgw.aa).intValue();
    }
    return this.jdField_a_of_type_Afce.onLongClick(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bchk
 * JD-Core Version:    0.7.0.1
 */