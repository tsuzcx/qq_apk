import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.richstatus.HistorySignItem;
import com.tencent.mobileqq.richstatus.SignatureHistoryFragment;
import com.tencent.mobileqq.richstatus.comment.bean.CommentItem;
import java.util.List;

class axzh
  implements ayaj
{
  axzh(axze paramaxze, HistorySignItem paramHistorySignItem) {}
  
  public void a(int paramInt, View paramView)
  {
    if (SignatureHistoryFragment.b(this.jdField_a_of_type_Axze.a)) {}
    Object localObject;
    ayab localayab;
    do
    {
      do
      {
        return;
        localObject = this.jdField_a_of_type_ComTencentMobileqqRichstatusHistorySignItem.commentItemList;
      } while ((localObject == null) || (((List)localObject).size() <= paramInt));
      localObject = (CommentItem)((List)localObject).get(paramInt);
      localayab = ((CommentItem)localObject).user;
    } while ((localayab == null) || (TextUtils.isEmpty(localayab.a)));
    paramView.setSelected(true);
    bdkz localbdkz = new bdkz();
    SignatureHistoryFragment.a(this.jdField_a_of_type_Axze.a, (CommentItem)localObject);
    localbdkz.a(2131364910, this.jdField_a_of_type_Axze.a.getString(2131691360), 0);
    if ((localayab.a.equals(SignatureHistoryFragment.b(this.jdField_a_of_type_Axze.a))) || (bdal.a(SignatureHistoryFragment.b(this.jdField_a_of_type_Axze.a), SignatureHistoryFragment.a(this.jdField_a_of_type_Axze.a)))) {
      localbdkz.a(2131365069, this.jdField_a_of_type_Axze.a.getString(2131692820), 0);
    }
    bdbk.a(paramView, localbdkz, this.jdField_a_of_type_Axze.a, new axzi(this, paramView));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axzh
 * JD-Core Version:    0.7.0.1
 */