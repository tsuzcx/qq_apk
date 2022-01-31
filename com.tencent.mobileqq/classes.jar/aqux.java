import android.text.SpannableStringBuilder;
import android.text.style.ClickableSpan;
import android.view.View;
import android.view.View.AccessibilityDelegate;
import com.tencent.mobileqq.data.MessageForGrayTips.HightlightClickableSpan;
import com.tencent.mobileqq.data.MessageForGrayTips.HightlightItem;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

class aqux
  extends View.AccessibilityDelegate
{
  aqux(aquu paramaquu, long paramLong1, long paramLong2, ArrayList paramArrayList, SpannableStringBuilder paramSpannableStringBuilder) {}
  
  public void sendAccessibilityEvent(View paramView, int paramInt)
  {
    super.sendAccessibilityEvent(paramView, paramInt);
    if (paramInt == 1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ChatItemBuilder", 2, new Object[] { "revoke msg grayTipItemBuilder sendAccessibilityEvent click msg uinseq=", Long.valueOf(this.jdField_a_of_type_Long), ",holder.mPosition=", Long.valueOf(this.b) });
      }
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (MessageForGrayTips.HightlightItem)localIterator.next();
        if (localObject != null)
        {
          localObject = (ClickableSpan[])this.jdField_a_of_type_AndroidTextSpannableStringBuilder.getSpans(((MessageForGrayTips.HightlightItem)localObject).start, ((MessageForGrayTips.HightlightItem)localObject).end, MessageForGrayTips.HightlightClickableSpan.class);
          if (localObject.length > 0) {
            localObject[0].onClick(paramView);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aqux
 * JD-Core Version:    0.7.0.1
 */