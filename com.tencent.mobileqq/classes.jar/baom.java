import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.richstatus.HistorySignItem;
import com.tencent.mobileqq.richstatus.SignatureHistoryFragment;
import com.tencent.mobileqq.richstatus.comment.bean.CommentItem;
import java.util.List;

class baom
  implements bapo
{
  baom(baoj parambaoj, HistorySignItem paramHistorySignItem) {}
  
  public void a(int paramInt, View paramView)
  {
    if (SignatureHistoryFragment.b(this.jdField_a_of_type_Baoj.a)) {}
    Object localObject;
    bapg localbapg;
    do
    {
      do
      {
        return;
        localObject = this.jdField_a_of_type_ComTencentMobileqqRichstatusHistorySignItem.commentItemList;
      } while ((localObject == null) || (((List)localObject).size() <= paramInt));
      localObject = (CommentItem)((List)localObject).get(paramInt);
      localbapg = ((CommentItem)localObject).user;
    } while ((localbapg == null) || (TextUtils.isEmpty(localbapg.a)));
    paramView.setSelected(true);
    bgaz localbgaz = new bgaz();
    SignatureHistoryFragment.a(this.jdField_a_of_type_Baoj.a, (CommentItem)localObject);
    localbgaz.a(2131365216, this.jdField_a_of_type_Baoj.a.getString(2131691179), 0);
    if ((localbapg.a.equals(SignatureHistoryFragment.b(this.jdField_a_of_type_Baoj.a))) || (bftf.a(SignatureHistoryFragment.b(this.jdField_a_of_type_Baoj.a), SignatureHistoryFragment.a(this.jdField_a_of_type_Baoj.a)))) {
      localbgaz.a(2131365382, this.jdField_a_of_type_Baoj.a.getString(2131692438), 0);
    }
    bfue.a(paramView, localbgaz, this.jdField_a_of_type_Baoj.a, new baon(this, paramView));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     baom
 * JD-Core Version:    0.7.0.1
 */