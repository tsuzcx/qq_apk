import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.confess.ConfessNewsBgView;
import com.tencent.mobileqq.confess.data.TroopConfessMsg;
import com.tencent.mobileqq.confess.data.TroopConfessMsgItem;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class aqkk
  extends afwr
{
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private ConfessNewsBgView jdField_a_of_type_ComTencentMobileqqConfessConfessNewsBgView;
  private TextView b;
  private View jdField_c_of_type_AndroidViewView;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  
  public void a(TroopConfessMsg paramTroopConfessMsg)
  {
    if (paramTroopConfessMsg == null) {
      if (QLog.isColorLevel()) {
        QLog.i("TroopConfessItemBuilder", 2, "TroopConfessViewHolder bindData null is troopConfessMsgItem.");
      }
    }
    do
    {
      return;
      if ((paramTroopConfessMsg.items != null) && (!paramTroopConfessMsg.items.isEmpty())) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.i("TroopConfessItemBuilder", 2, "TroopConfessViewHolder bindData items is null or empty.");
    return;
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramTroopConfessMsg.getConfessToNick());
    this.b.setText(((TroopConfessMsgItem)paramTroopConfessMsg.items.get(0)).topic);
    String str2 = ((TroopConfessMsgItem)paramTroopConfessMsg.items.get(0)).topic;
    float f = aqjz.a(str2);
    int i;
    if (f > 8.0F)
    {
      this.b.setTextSize(1, 24.0F);
      this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(1, 18.0F);
      this.b.setLineSpacing(0.0F, 1.1F);
      str1 = str2;
      if (f <= 12.0F)
      {
        str1 = str2;
        if (aqjz.a(str2)) {
          i = (int)(f * 0.7D);
        }
      }
    }
    for (String str1 = str2.substring(0, i) + "\n" + str2.substring(i, str2.length());; str1 = str2)
    {
      this.b.setText(str1);
      if (paramTroopConfessMsg.totalCount > 1) {
        break;
      }
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      return;
      this.b.setTextSize(1, 24.0F);
      this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(1, 18.0F);
      this.b.setLineSpacing(0.0F, 1.0F);
    }
    this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_c_of_type_AndroidWidgetTextView.setText(String.format(anni.a(2131713951), new Object[] { Integer.valueOf(paramTroopConfessMsg.totalCount - 1) }));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqkk
 * JD-Core Version:    0.7.0.1
 */