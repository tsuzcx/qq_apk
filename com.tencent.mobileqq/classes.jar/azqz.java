import android.text.TextUtils;
import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;

public class azqz
  implements View.OnLongClickListener
{
  public azqz(StructMsgForGeneralShare paramStructMsgForGeneralShare, aeov paramaeov) {}
  
  public boolean onLongClick(View paramView)
  {
    StructMsgForGeneralShare.clickedItemIndex = 0;
    azqj localazqj = (azqj)paramView.getTag();
    if (!TextUtils.isEmpty(localazqj.Q)) {
      StructMsgForGeneralShare.clickedItemIndex = Integer.valueOf(localazqj.Q).intValue();
    }
    return this.jdField_a_of_type_Aeov.onLongClick(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azqz
 * JD-Core Version:    0.7.0.1
 */