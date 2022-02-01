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
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class ayfq
  implements View.OnClickListener
{
  public ayfq(ShortVideoCommentsView paramShortVideoCommentsView) {}
  
  public void onClick(View paramView)
  {
    String str3 = ShortVideoCommentsView.a(this.a).getText().toString();
    if (str3.equals("")) {
      this.a.a(this.a.getContext().getResources().getString(2131695717));
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (str3.length() > 140)
      {
        this.a.a(this.a.getContext().getResources().getString(2131695718));
      }
      else
      {
        Comments.Comment localComment = new Comments.Comment();
        localComment.jdField_c_of_type_Long = Long.parseLong(this.a.a.getCurrentAccountUin());
        localComment.jdField_c_of_type_JavaLangString = "";
        String str2 = BaseApplicationImpl.getApplication().getSharedPreferences("self_info" + this.a.a.getCurrentAccountUin(), 4).getString("nick", "");
        String str1 = str2;
        if (TextUtils.isEmpty(str2)) {
          str1 = this.a.a.getCurrentNickname();
        }
        localComment.jdField_b_of_type_JavaLangString = str1;
        localComment.jdField_a_of_type_JavaLangString = str3;
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
        bdll.b(this.a.a, "dc00899", "grp_lbs", "", "new_thing", "clk_reply", 0, 0, "", "", "", "");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayfq
 * JD-Core Version:    0.7.0.1
 */