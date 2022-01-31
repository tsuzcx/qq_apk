import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.widget.QQToast;

class avlw
  implements bhqd
{
  avlw(avlt paramavlt, avma paramavma, avnx paramavnx, bhpy parambhpy) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    }
    auzx localauzx = new auzx().h("data_card").i("feed_inform").d("2").a(this.jdField_a_of_type_Avlt.a(this.jdField_a_of_type_Avma)).b(this.jdField_a_of_type_Avnx.c).c(String.valueOf(this.jdField_a_of_type_Avlt.a(this.jdField_a_of_type_Avma)));
    if (this.jdField_a_of_type_Avlt.jdField_a_of_type_Boolean)
    {
      paramView = "1";
      localauzx.e(paramView).b(this.jdField_a_of_type_Avlt.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      if ((TextUtils.isEmpty(this.jdField_a_of_type_Avnx.e)) || (!(this.jdField_a_of_type_Avlt.jdField_a_of_type_AndroidContentContext instanceof BaseActivity))) {
        break label341;
      }
      paramView = new bcyx();
      if (!(this.jdField_a_of_type_Avnx instanceof avnu)) {
        break label231;
      }
      paramView.b(((avnu)this.jdField_a_of_type_Avnx).b);
      label172:
      paramView.a(this.jdField_a_of_type_Avnx.n);
      paramView = paramView.a();
      bcyw.a((BaseActivity)this.jdField_a_of_type_Avlt.jdField_a_of_type_AndroidContentContext, 0L, this.jdField_a_of_type_Avnx.e, null, 20006, "", paramView);
    }
    for (;;)
    {
      this.jdField_a_of_type_Bhpy.dismiss();
      return;
      paramView = "2";
      break;
      label231:
      if ((this.jdField_a_of_type_Avnx instanceof avnw))
      {
        paramView.d(((avnw)this.jdField_a_of_type_Avnx).b).b(((avnw)this.jdField_a_of_type_Avnx).a);
        break label172;
      }
      if ((this.jdField_a_of_type_Avnx instanceof avny))
      {
        paramView.b(((avny)this.jdField_a_of_type_Avnx).a);
        break label172;
      }
      if ((this.jdField_a_of_type_Avnx instanceof avoa))
      {
        paramView.b(((avoa)this.jdField_a_of_type_Avnx).a);
        break label172;
      }
      if (!(this.jdField_a_of_type_Avnx instanceof avob)) {
        break label172;
      }
      break label172;
      label341:
      QQToast.a(this.jdField_a_of_type_Avlt.jdField_a_of_type_AndroidContentContext, 2, alpo.a(2131701404), 0).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     avlw
 * JD-Core Version:    0.7.0.1
 */