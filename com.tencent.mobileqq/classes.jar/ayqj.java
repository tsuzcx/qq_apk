import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.widget.QQToast;

class ayqj
  implements bliz
{
  ayqj(ayqg paramayqg, ayqn paramayqn, aysk paramaysk, blir paramblir) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    }
    ayek localayek = new ayek().h("data_card").i("feed_inform").d("2").a(this.jdField_a_of_type_Ayqg.a(this.jdField_a_of_type_Ayqn)).b(this.jdField_a_of_type_Aysk.c).c(String.valueOf(this.jdField_a_of_type_Ayqg.a(this.jdField_a_of_type_Ayqn)));
    if (this.jdField_a_of_type_Ayqg.jdField_a_of_type_Boolean)
    {
      paramView = "1";
      localayek.e(paramView).b(this.jdField_a_of_type_Ayqg.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      if ((TextUtils.isEmpty(this.jdField_a_of_type_Aysk.e)) || (!(this.jdField_a_of_type_Ayqg.jdField_a_of_type_AndroidContentContext instanceof BaseActivity))) {
        break label341;
      }
      paramView = new bhia();
      if (!(this.jdField_a_of_type_Aysk instanceof aysh)) {
        break label231;
      }
      paramView.b(((aysh)this.jdField_a_of_type_Aysk).b);
      label172:
      paramView.a(this.jdField_a_of_type_Aysk.n);
      paramView = paramView.a();
      bhhz.a((BaseActivity)this.jdField_a_of_type_Ayqg.jdField_a_of_type_AndroidContentContext, 0L, this.jdField_a_of_type_Aysk.e, null, 20006, "", paramView);
    }
    for (;;)
    {
      this.jdField_a_of_type_Blir.dismiss();
      return;
      paramView = "2";
      break;
      label231:
      if ((this.jdField_a_of_type_Aysk instanceof aysj))
      {
        paramView.d(((aysj)this.jdField_a_of_type_Aysk).b).b(((aysj)this.jdField_a_of_type_Aysk).a);
        break label172;
      }
      if ((this.jdField_a_of_type_Aysk instanceof aysl))
      {
        paramView.b(((aysl)this.jdField_a_of_type_Aysk).a);
        break label172;
      }
      if ((this.jdField_a_of_type_Aysk instanceof aysn))
      {
        paramView.b(((aysn)this.jdField_a_of_type_Aysk).a);
        break label172;
      }
      if (!(this.jdField_a_of_type_Aysk instanceof ayso)) {
        break label172;
      }
      break label172;
      label341:
      QQToast.a(this.jdField_a_of_type_Ayqg.jdField_a_of_type_AndroidContentContext, 2, anzj.a(2131699947), 0).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayqj
 * JD-Core Version:    0.7.0.1
 */