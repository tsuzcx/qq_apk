import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.widget.QQToast;

class avqf
  implements bhuk
{
  avqf(avqc paramavqc, avqj paramavqj, avsg paramavsg, bhuf parambhuf) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    }
    aveg localaveg = new aveg().h("data_card").i("feed_inform").d("2").a(this.jdField_a_of_type_Avqc.a(this.jdField_a_of_type_Avqj)).b(this.jdField_a_of_type_Avsg.c).c(String.valueOf(this.jdField_a_of_type_Avqc.a(this.jdField_a_of_type_Avqj)));
    if (this.jdField_a_of_type_Avqc.jdField_a_of_type_Boolean)
    {
      paramView = "1";
      localaveg.e(paramView).b(this.jdField_a_of_type_Avqc.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      if ((TextUtils.isEmpty(this.jdField_a_of_type_Avsg.e)) || (!(this.jdField_a_of_type_Avqc.jdField_a_of_type_AndroidContentContext instanceof BaseActivity))) {
        break label341;
      }
      paramView = new bddg();
      if (!(this.jdField_a_of_type_Avsg instanceof avsd)) {
        break label231;
      }
      paramView.b(((avsd)this.jdField_a_of_type_Avsg).b);
      label172:
      paramView.a(this.jdField_a_of_type_Avsg.n);
      paramView = paramView.a();
      bddf.a((BaseActivity)this.jdField_a_of_type_Avqc.jdField_a_of_type_AndroidContentContext, 0L, this.jdField_a_of_type_Avsg.e, null, 20006, "", paramView);
    }
    for (;;)
    {
      this.jdField_a_of_type_Bhuf.dismiss();
      return;
      paramView = "2";
      break;
      label231:
      if ((this.jdField_a_of_type_Avsg instanceof avsf))
      {
        paramView.d(((avsf)this.jdField_a_of_type_Avsg).b).b(((avsf)this.jdField_a_of_type_Avsg).a);
        break label172;
      }
      if ((this.jdField_a_of_type_Avsg instanceof avsh))
      {
        paramView.b(((avsh)this.jdField_a_of_type_Avsg).a);
        break label172;
      }
      if ((this.jdField_a_of_type_Avsg instanceof avsj))
      {
        paramView.b(((avsj)this.jdField_a_of_type_Avsg).a);
        break label172;
      }
      if (!(this.jdField_a_of_type_Avsg instanceof avsk)) {
        break label172;
      }
      break label172;
      label341:
      QQToast.a(this.jdField_a_of_type_Avqc.jdField_a_of_type_AndroidContentContext, 2, alud.a(2131701416), 0).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     avqf
 * JD-Core Version:    0.7.0.1
 */