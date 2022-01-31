import android.text.TextUtils;
import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;

public class axvf
  implements View.OnLongClickListener
{
  public axvf(StructMsgForGeneralShare paramStructMsgForGeneralShare, acxj paramacxj) {}
  
  public boolean onLongClick(View paramView)
  {
    StructMsgForGeneralShare.clickedItemIndex = 0;
    axup localaxup = (axup)paramView.getTag();
    if (!TextUtils.isEmpty(localaxup.Q)) {
      StructMsgForGeneralShare.clickedItemIndex = Integer.valueOf(localaxup.Q).intValue();
    }
    return this.jdField_a_of_type_Acxj.onLongClick(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     axvf
 * JD-Core Version:    0.7.0.1
 */