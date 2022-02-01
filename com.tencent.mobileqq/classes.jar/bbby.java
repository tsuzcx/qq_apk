import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.richstatus.HistorySignItem;
import com.tencent.mobileqq.richstatus.SignatureHistoryFragment;
import com.tencent.mobileqq.richstatus.comment.bean.CommentItem;
import java.util.List;

class bbby
  implements bbda
{
  bbby(bbbv parambbbv, HistorySignItem paramHistorySignItem) {}
  
  public void a(int paramInt, View paramView)
  {
    if (SignatureHistoryFragment.b(this.jdField_a_of_type_Bbbv.a)) {}
    Object localObject;
    bbcs localbbcs;
    do
    {
      do
      {
        return;
        localObject = this.jdField_a_of_type_ComTencentMobileqqRichstatusHistorySignItem.commentItemList;
      } while ((localObject == null) || (((List)localObject).size() <= paramInt));
      localObject = (CommentItem)((List)localObject).get(paramInt);
      localbbcs = ((CommentItem)localObject).user;
    } while ((localbbcs == null) || (TextUtils.isEmpty(localbbcs.a)));
    paramView.setSelected(true);
    bguh localbguh = new bguh();
    SignatureHistoryFragment.a(this.jdField_a_of_type_Bbbv.a, (CommentItem)localObject);
    localbguh.a(2131365147, this.jdField_a_of_type_Bbbv.a.getString(2131691140), 0);
    if ((localbbcs.a.equals(SignatureHistoryFragment.b(this.jdField_a_of_type_Bbbv.a))) || (bgjw.a(SignatureHistoryFragment.b(this.jdField_a_of_type_Bbbv.a), SignatureHistoryFragment.a(this.jdField_a_of_type_Bbbv.a)))) {
      localbguh.a(2131365308, this.jdField_a_of_type_Bbbv.a.getString(2131692385), 0);
    }
    bgkw.a(paramView, localbguh, this.jdField_a_of_type_Bbbv.a, new bbbz(this, paramView));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbby
 * JD-Core Version:    0.7.0.1
 */