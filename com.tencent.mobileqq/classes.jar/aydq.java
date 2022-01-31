import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.richstatus.HistorySignItem;
import com.tencent.mobileqq.richstatus.SignatureHistoryFragment;
import com.tencent.mobileqq.richstatus.comment.bean.CommentItem;
import java.util.List;

class aydq
  implements ayes
{
  aydq(aydn paramaydn, HistorySignItem paramHistorySignItem) {}
  
  public void a(int paramInt, View paramView)
  {
    if (SignatureHistoryFragment.b(this.jdField_a_of_type_Aydn.a)) {}
    Object localObject;
    ayek localayek;
    do
    {
      do
      {
        return;
        localObject = this.jdField_a_of_type_ComTencentMobileqqRichstatusHistorySignItem.commentItemList;
      } while ((localObject == null) || (((List)localObject).size() <= paramInt));
      localObject = (CommentItem)((List)localObject).get(paramInt);
      localayek = ((CommentItem)localObject).user;
    } while ((localayek == null) || (TextUtils.isEmpty(localayek.a)));
    paramView.setSelected(true);
    bdpi localbdpi = new bdpi();
    SignatureHistoryFragment.a(this.jdField_a_of_type_Aydn.a, (CommentItem)localObject);
    localbdpi.a(2131364912, this.jdField_a_of_type_Aydn.a.getString(2131691361), 0);
    if ((localayek.a.equals(SignatureHistoryFragment.b(this.jdField_a_of_type_Aydn.a))) || (bdeu.a(SignatureHistoryFragment.b(this.jdField_a_of_type_Aydn.a), SignatureHistoryFragment.a(this.jdField_a_of_type_Aydn.a)))) {
      localbdpi.a(2131365071, this.jdField_a_of_type_Aydn.a.getString(2131692822), 0);
    }
    bdft.a(paramView, localbdpi, this.jdField_a_of_type_Aydn.a, new aydr(this, paramView));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aydq
 * JD-Core Version:    0.7.0.1
 */