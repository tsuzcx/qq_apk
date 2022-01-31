import android.text.TextUtils;
import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;

public class awuz
  implements View.OnLongClickListener
{
  public awuz(StructMsgForGeneralShare paramStructMsgForGeneralShare, acmv paramacmv) {}
  
  public boolean onLongClick(View paramView)
  {
    StructMsgForGeneralShare.clickedItemIndex = 0;
    awul localawul = (awul)paramView.getTag();
    if (!TextUtils.isEmpty(localawul.Q)) {
      StructMsgForGeneralShare.clickedItemIndex = Integer.valueOf(localawul.Q).intValue();
    }
    return this.jdField_a_of_type_Acmv.onLongClick(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     awuz
 * JD-Core Version:    0.7.0.1
 */