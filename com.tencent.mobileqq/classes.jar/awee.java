import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.richstatus.HistorySignItem;
import com.tencent.mobileqq.richstatus.SignatureHistoryFragment;
import com.tencent.mobileqq.richstatus.comment.bean.CommentItem;
import java.util.List;

class awee
  implements awfg
{
  awee(aweb paramaweb, HistorySignItem paramHistorySignItem) {}
  
  public void a(int paramInt, View paramView)
  {
    if (SignatureHistoryFragment.b(this.jdField_a_of_type_Aweb.a)) {}
    Object localObject;
    awey localawey;
    do
    {
      do
      {
        return;
        localObject = this.jdField_a_of_type_ComTencentMobileqqRichstatusHistorySignItem.commentItemList;
      } while ((localObject == null) || (((List)localObject).size() <= paramInt));
      localObject = (CommentItem)((List)localObject).get(paramInt);
      localawey = ((CommentItem)localObject).user;
    } while ((localawey == null) || (TextUtils.isEmpty(localawey.a)));
    paramView.setSelected(true);
    bbmf localbbmf = new bbmf();
    SignatureHistoryFragment.a(this.jdField_a_of_type_Aweb.a, (CommentItem)localObject);
    localbbmf.a(2131364824, this.jdField_a_of_type_Aweb.a.getString(2131691307), 0);
    if ((localawey.a.equals(SignatureHistoryFragment.b(this.jdField_a_of_type_Aweb.a))) || (bbbr.a(SignatureHistoryFragment.b(this.jdField_a_of_type_Aweb.a), SignatureHistoryFragment.a(this.jdField_a_of_type_Aweb.a)))) {
      localbbmf.a(2131364984, this.jdField_a_of_type_Aweb.a.getString(2131692738), 0);
    }
    bbcq.a(paramView, localbbmf, this.jdField_a_of_type_Aweb.a, new awef(this, paramView));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     awee
 * JD-Core Version:    0.7.0.1
 */