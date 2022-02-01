import android.content.Intent;
import android.view.View;
import com.tencent.mobileqq.activity.EditInfoActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.data.Card;

class azkx
  implements bkhw
{
  azkx(azks paramazks, String paramString1, String paramString2, int paramInt, boolean paramBoolean, bkho parambkho) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if ((paramInt == 0) && (azks.b(this.jdField_a_of_type_Azks) != null))
    {
      paramView = new Intent(azks.c(this.jdField_a_of_type_Azks), EditInfoActivity.class);
      paramView.putExtra("title", this.jdField_a_of_type_JavaLangString);
      paramView.putExtra("default_text", this.b);
      paramView.putExtra("uin", ((azfe)azks.a(this.jdField_a_of_type_Azks)).jdField_a_of_type_ComTencentMobileqqDataCard.uin);
      paramView.putExtra("edit_action", this.jdField_a_of_type_Int);
      paramView.putExtra("max_limit_mode", 1);
      paramView.putExtra("edit_type", 2);
      if (!this.jdField_a_of_type_Boolean) {
        break label169;
      }
      paramView.putExtra("max_num", 60);
      paramView.putExtra("isTroopNick", true);
      paramView.putExtra("troopUin", ((azfe)azks.b(this.jdField_a_of_type_Azks)).jdField_a_of_type_JavaLangString);
    }
    for (;;)
    {
      azks.d(this.jdField_a_of_type_Azks).startActivityForResult(paramView, 1034);
      this.jdField_a_of_type_Bkho.dismiss();
      return;
      label169:
      paramInt = 36;
      if (this.jdField_a_of_type_Int == 2) {
        paramInt = 60;
      }
      paramView.putExtra("max_num", paramInt);
      paramView.putExtra("support_emotion", true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azkx
 * JD-Core Version:    0.7.0.1
 */