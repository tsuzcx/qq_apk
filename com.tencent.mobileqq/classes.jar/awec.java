import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.richstatus.HistorySignItem;
import com.tencent.mobileqq.richstatus.SignatureHistoryFragment;
import com.tencent.mobileqq.richstatus.comment.bean.CommentItem;
import java.util.List;

class awec
  implements awfe
{
  awec(awdz paramawdz, HistorySignItem paramHistorySignItem) {}
  
  public void a(int paramInt, View paramView)
  {
    if (SignatureHistoryFragment.b(this.jdField_a_of_type_Awdz.a)) {}
    Object localObject;
    awew localawew;
    do
    {
      do
      {
        return;
        localObject = this.jdField_a_of_type_ComTencentMobileqqRichstatusHistorySignItem.commentItemList;
      } while ((localObject == null) || (((List)localObject).size() <= paramInt));
      localObject = (CommentItem)((List)localObject).get(paramInt);
      localawew = ((CommentItem)localObject).user;
    } while ((localawew == null) || (TextUtils.isEmpty(localawew.a)));
    paramView.setSelected(true);
    bblr localbblr = new bblr();
    SignatureHistoryFragment.a(this.jdField_a_of_type_Awdz.a, (CommentItem)localObject);
    localbblr.a(2131364825, this.jdField_a_of_type_Awdz.a.getString(2131691307), 0);
    if ((localawew.a.equals(SignatureHistoryFragment.b(this.jdField_a_of_type_Awdz.a))) || (bbbd.a(SignatureHistoryFragment.b(this.jdField_a_of_type_Awdz.a), SignatureHistoryFragment.a(this.jdField_a_of_type_Awdz.a)))) {
      localbblr.a(2131364985, this.jdField_a_of_type_Awdz.a.getString(2131692737), 0);
    }
    bbcc.a(paramView, localbblr, this.jdField_a_of_type_Awdz.a, new awed(this, paramView));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     awec
 * JD-Core Version:    0.7.0.1
 */