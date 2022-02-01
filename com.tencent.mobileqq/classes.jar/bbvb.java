import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.richstatus.HistorySignItem;
import com.tencent.mobileqq.richstatus.SignatureHistoryFragment;
import com.tencent.mobileqq.richstatus.comment.bean.CommentItem;
import java.util.List;

class bbvb
  implements bbwd
{
  bbvb(bbuy parambbuy, HistorySignItem paramHistorySignItem) {}
  
  public void a(int paramInt, View paramView)
  {
    if (SignatureHistoryFragment.b(this.jdField_a_of_type_Bbuy.a)) {}
    Object localObject;
    bbvv localbbvv;
    do
    {
      do
      {
        return;
        localObject = this.jdField_a_of_type_ComTencentMobileqqRichstatusHistorySignItem.commentItemList;
      } while ((localObject == null) || (((List)localObject).size() <= paramInt));
      localObject = (CommentItem)((List)localObject).get(paramInt);
      localbbvv = ((CommentItem)localObject).user;
    } while ((localbbvv == null) || (TextUtils.isEmpty(localbbvv.a)));
    paramView.setSelected(true);
    bhjq localbhjq = new bhjq();
    SignatureHistoryFragment.a(this.jdField_a_of_type_Bbuy.a, (CommentItem)localObject);
    localbhjq.a(2131365307, this.jdField_a_of_type_Bbuy.a.getString(2131691264), 0);
    if ((localbbvv.a.equals(SignatureHistoryFragment.b(this.jdField_a_of_type_Bbuy.a))) || (bhbx.a(SignatureHistoryFragment.b(this.jdField_a_of_type_Bbuy.a), SignatureHistoryFragment.a(this.jdField_a_of_type_Bbuy.a)))) {
      localbhjq.a(2131365475, this.jdField_a_of_type_Bbuy.a.getString(2131692540), 0);
    }
    bhcw.a(paramView, localbhjq, this.jdField_a_of_type_Bbuy.a, new bbvc(this, paramView));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbvb
 * JD-Core Version:    0.7.0.1
 */