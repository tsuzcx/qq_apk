import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.nearby.now.model.Comments.Comment;
import com.tencent.mobileqq.nearby.now.view.ShortVideoCommentsView;

public class asnx
  implements View.OnClickListener
{
  public asnx(ShortVideoCommentsView paramShortVideoCommentsView) {}
  
  public void onClick(View paramView)
  {
    String str2 = ShortVideoCommentsView.a(this.a).getText().toString();
    if (str2.equals(""))
    {
      this.a.a(this.a.getContext().getResources().getString(2131630962));
      return;
    }
    if (str2.length() > 140)
    {
      this.a.a(this.a.getContext().getResources().getString(2131630963));
      return;
    }
    Comments.Comment localComment = new Comments.Comment();
    localComment.jdField_c_of_type_Long = Long.parseLong(this.a.a.getCurrentAccountUin());
    localComment.jdField_c_of_type_JavaLangString = "";
    String str1 = BaseApplicationImpl.getApplication().getSharedPreferences("self_info" + this.a.a.getCurrentAccountUin(), 4).getString("nick", "");
    paramView = str1;
    if (TextUtils.isEmpty(str1)) {
      paramView = this.a.a.getCurrentNickname();
    }
    localComment.jdField_b_of_type_JavaLangString = paramView;
    localComment.jdField_a_of_type_JavaLangString = str2;
    localComment.jdField_b_of_type_Long = (System.currentTimeMillis() / 1000L);
    localComment.jdField_a_of_type_ComTencentMobileqqNearbyNowModelMedalInfo = ShortVideoCommentsView.a(this.a);
    if ((ShortVideoCommentsView.a(this.a) != null) && ((ShortVideoCommentsView.a(this.a).jdField_c_of_type_Long > 0L) || (ShortVideoCommentsView.a(this.a).jdField_d_of_type_Long > 0L)))
    {
      localComment.jdField_e_of_type_JavaLangString = ShortVideoCommentsView.a(this.a).jdField_c_of_type_JavaLangString;
      localComment.jdField_d_of_type_JavaLangString = ShortVideoCommentsView.a(this.a).jdField_b_of_type_JavaLangString;
      localComment.jdField_e_of_type_Long = ShortVideoCommentsView.a(this.a).jdField_c_of_type_Long;
      localComment.f = ShortVideoCommentsView.a(this.a).jdField_d_of_type_Long;
      localComment.jdField_c_of_type_Int = ShortVideoCommentsView.a(this.a).jdField_b_of_type_Int;
    }
    ShortVideoCommentsView.a(this.a).a(localComment);
    ShortVideoCommentsView.a(this.a, localComment);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     asnx
 * JD-Core Version:    0.7.0.1
 */