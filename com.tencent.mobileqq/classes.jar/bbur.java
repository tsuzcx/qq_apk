import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.richstatus.HistorySignItem;
import com.tencent.mobileqq.richstatus.SignatureHistoryFragment;
import com.tencent.mobileqq.richstatus.comment.bean.CommentItem;
import java.util.List;

class bbur
  implements bbvt
{
  bbur(bbuo parambbuo, HistorySignItem paramHistorySignItem) {}
  
  public void a(int paramInt, View paramView)
  {
    if (SignatureHistoryFragment.b(this.jdField_a_of_type_Bbuo.a)) {}
    Object localObject;
    bbvl localbbvl;
    do
    {
      do
      {
        return;
        localObject = this.jdField_a_of_type_ComTencentMobileqqRichstatusHistorySignItem.commentItemList;
      } while ((localObject == null) || (((List)localObject).size() <= paramInt));
      localObject = (CommentItem)((List)localObject).get(paramInt);
      localbbvl = ((CommentItem)localObject).user;
    } while ((localbbvl == null) || (TextUtils.isEmpty(localbbvl.a)));
    paramView.setSelected(true);
    bhuk localbhuk = new bhuk();
    SignatureHistoryFragment.a(this.jdField_a_of_type_Bbuo.a, (CommentItem)localObject);
    localbhuk.a(2131365191, this.jdField_a_of_type_Bbuo.a.getString(2131691140), 0);
    if ((localbbvl.a.equals(SignatureHistoryFragment.b(this.jdField_a_of_type_Bbuo.a))) || (bhjx.a(SignatureHistoryFragment.b(this.jdField_a_of_type_Bbuo.a), SignatureHistoryFragment.a(this.jdField_a_of_type_Bbuo.a)))) {
      localbhuk.a(2131365352, this.jdField_a_of_type_Bbuo.a.getString(2131692390), 0);
    }
    bhkx.a(paramView, localbhuk, this.jdField_a_of_type_Bbuo.a, new bbus(this, paramView));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbur
 * JD-Core Version:    0.7.0.1
 */