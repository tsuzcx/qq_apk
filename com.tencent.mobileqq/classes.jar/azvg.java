import android.text.TextUtils;
import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;

public class azvg
  implements View.OnLongClickListener
{
  public azvg(StructMsgForGeneralShare paramStructMsgForGeneralShare, aetk paramaetk) {}
  
  public boolean onLongClick(View paramView)
  {
    StructMsgForGeneralShare.clickedItemIndex = 0;
    azus localazus = (azus)paramView.getTag();
    if (!TextUtils.isEmpty(localazus.Q)) {
      StructMsgForGeneralShare.clickedItemIndex = Integer.valueOf(localazus.Q).intValue();
    }
    return this.jdField_a_of_type_Aetk.onLongClick(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azvg
 * JD-Core Version:    0.7.0.1
 */