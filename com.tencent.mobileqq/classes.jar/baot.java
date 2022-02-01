import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import com.tencent.mobileqq.app.QQAppInterface;

final class baot
  implements bkzq
{
  baot(bkzi parambkzi, int[] paramArrayOfInt, String paramString, Context paramContext, QQAppInterface paramQQAppInterface) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    this.jdField_a_of_type_Bkzi.dismiss();
    switch (this.jdField_a_of_type_ArrayOfInt[paramInt])
    {
    default: 
      return;
    }
    paramView = new Intent("android.intent.action.DIAL", Uri.parse("tel:" + this.jdField_a_of_type_JavaLangString));
    if ((!bhkn.a) && (bhkk.a().a())) {
      bhkk.a().a(paramView);
    }
    this.jdField_a_of_type_AndroidContentContext.startActivity(paramView);
    paramView = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCallFacade();
    long l = bcrg.a();
    paramView.a(this.jdField_a_of_type_JavaLangString, 26, -1, l, this.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     baot
 * JD-Core Version:    0.7.0.1
 */