import android.text.TextUtils;
import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;

public class bdpb
  implements View.OnLongClickListener
{
  public bdpb(StructMsgForGeneralShare paramStructMsgForGeneralShare, agjk paramagjk) {}
  
  public boolean onLongClick(View paramView)
  {
    StructMsgForGeneralShare.clickedItemIndex = 0;
    bdol localbdol = (bdol)paramView.getTag();
    if (!TextUtils.isEmpty(localbdol.aa)) {
      StructMsgForGeneralShare.clickedItemIndex = Integer.valueOf(localbdol.aa).intValue();
    }
    return this.jdField_a_of_type_Agjk.onLongClick(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdpb
 * JD-Core Version:    0.7.0.1
 */