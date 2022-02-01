import android.text.TextUtils;
import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;

public class bcwg
  implements View.OnLongClickListener
{
  public bcwg(StructMsgForGeneralShare paramStructMsgForGeneralShare, afzq paramafzq) {}
  
  public boolean onLongClick(View paramView)
  {
    StructMsgForGeneralShare.clickedItemIndex = 0;
    bcvs localbcvs = (bcvs)paramView.getTag();
    if (!TextUtils.isEmpty(localbcvs.Y)) {
      StructMsgForGeneralShare.clickedItemIndex = Integer.valueOf(localbcvs.Y).intValue();
    }
    return this.jdField_a_of_type_Afzq.onLongClick(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcwg
 * JD-Core Version:    0.7.0.1
 */