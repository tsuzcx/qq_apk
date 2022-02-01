import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.ClipboardManager;
import android.view.View;
import com.tencent.mobileqq.activity.AddFriendActivity;

final class begr
  implements bliz
{
  begr(int paramInt, String paramString1, Context paramContext, String paramString2, blir paramblir) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.jdField_a_of_type_Blir.dismiss();
      return;
      if (this.jdField_a_of_type_Int == 2)
      {
        paramView = Intent.createChooser(new Intent("android.intent.action.SENDTO", Uri.parse("mailto:" + this.jdField_a_of_type_JavaLangString)), this.jdField_a_of_type_AndroidContentContext.getString(2131693466));
        paramView.putExtra("big_brother_source_key", this.b);
        this.jdField_a_of_type_AndroidContentContext.startActivity(paramView);
      }
      else
      {
        paramView = new Intent("android.intent.action.DIAL", Uri.parse("tel:" + this.jdField_a_of_type_JavaLangString));
        paramView.putExtra("big_brother_source_key", this.b);
        this.jdField_a_of_type_AndroidContentContext.startActivity(paramView);
        begp.a("1", "2");
        continue;
        ((ClipboardManager)this.jdField_a_of_type_AndroidContentContext.getSystemService("clipboard")).setText(this.jdField_a_of_type_JavaLangString);
        begp.a("2", "1");
        continue;
        begp.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaLangString);
        begp.b("0X800A00A", "0X800A00A");
        continue;
        AddFriendActivity.a(this.jdField_a_of_type_AndroidContentContext, false, this.jdField_a_of_type_JavaLangString, true);
        begp.a("3", "1");
        continue;
        AddFriendActivity.a(this.jdField_a_of_type_AndroidContentContext, true, this.jdField_a_of_type_JavaLangString, true);
        begp.a("4", "1");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     begr
 * JD-Core Version:    0.7.0.1
 */