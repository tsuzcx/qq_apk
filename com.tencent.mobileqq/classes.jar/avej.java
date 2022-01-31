import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.richstatus.HistorySignItem;
import com.tencent.mobileqq.richstatus.SignatureHistoryFragment;
import com.tencent.mobileqq.richstatus.comment.bean.CommentItem;
import java.util.List;

class avej
  implements avfl
{
  avej(aveg paramaveg, HistorySignItem paramHistorySignItem) {}
  
  public void a(int paramInt, View paramView)
  {
    if (SignatureHistoryFragment.b(this.jdField_a_of_type_Aveg.a)) {}
    Object localObject;
    avfd localavfd;
    do
    {
      do
      {
        return;
        localObject = this.jdField_a_of_type_ComTencentMobileqqRichstatusHistorySignItem.commentItemList;
      } while ((localObject == null) || (((List)localObject).size() <= paramInt));
      localObject = (CommentItem)((List)localObject).get(paramInt);
      localavfd = ((CommentItem)localObject).user;
    } while ((localavfd == null) || (TextUtils.isEmpty(localavfd.a)));
    paramView.setSelected(true);
    bakh localbakh = new bakh();
    SignatureHistoryFragment.a(this.jdField_a_of_type_Aveg.a, (CommentItem)localObject);
    localbakh.a(2131299262, this.jdField_a_of_type_Aveg.a.getString(2131625731), 0);
    if ((localavfd.a.equals(SignatureHistoryFragment.b(this.jdField_a_of_type_Aveg.a))) || (azzz.a(SignatureHistoryFragment.b(this.jdField_a_of_type_Aveg.a), SignatureHistoryFragment.a(this.jdField_a_of_type_Aveg.a)))) {
      localbakh.a(2131299417, this.jdField_a_of_type_Aveg.a.getString(2131627099), 0);
    }
    baay.a(paramView, localbakh, this.jdField_a_of_type_Aveg.a, new avek(this, paramView));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     avej
 * JD-Core Version:    0.7.0.1
 */