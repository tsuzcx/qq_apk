import android.content.Intent;
import android.view.View;
import com.tencent.mobileqq.activity.EditInfoActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.data.Card;

class azwu
  implements bkzq
{
  azwu(azwp paramazwp, String paramString1, String paramString2, int paramInt, boolean paramBoolean, bkzi parambkzi) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if ((paramInt == 0) && (azwp.b(this.jdField_a_of_type_Azwp) != null))
    {
      paramView = new Intent(azwp.c(this.jdField_a_of_type_Azwp), EditInfoActivity.class);
      paramView.putExtra("title", this.jdField_a_of_type_JavaLangString);
      paramView.putExtra("default_text", this.b);
      paramView.putExtra("uin", ((azrb)azwp.a(this.jdField_a_of_type_Azwp)).jdField_a_of_type_ComTencentMobileqqDataCard.uin);
      paramView.putExtra("edit_action", this.jdField_a_of_type_Int);
      paramView.putExtra("max_limit_mode", 1);
      paramView.putExtra("edit_type", 2);
      if (!this.jdField_a_of_type_Boolean) {
        break label169;
      }
      paramView.putExtra("max_num", 60);
      paramView.putExtra("isTroopNick", true);
      paramView.putExtra("troopUin", ((azrb)azwp.b(this.jdField_a_of_type_Azwp)).jdField_a_of_type_JavaLangString);
    }
    for (;;)
    {
      azwp.d(this.jdField_a_of_type_Azwp).startActivityForResult(paramView, 1034);
      this.jdField_a_of_type_Bkzi.dismiss();
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
 * Qualified Name:     azwu
 * JD-Core Version:    0.7.0.1
 */