import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.widget.QQToast;

class axxp
  implements bkhw
{
  axxp(axxm paramaxxm, axxt paramaxxt, axzq paramaxzq, bkho parambkho) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    }
    axlq localaxlq = new axlq().h("data_card").i("feed_inform").d("2").a(this.jdField_a_of_type_Axxm.a(this.jdField_a_of_type_Axxt)).b(this.jdField_a_of_type_Axzq.c).c(String.valueOf(this.jdField_a_of_type_Axxm.a(this.jdField_a_of_type_Axxt)));
    if (this.jdField_a_of_type_Axxm.jdField_a_of_type_Boolean)
    {
      paramView = "1";
      localaxlq.e(paramView).b(this.jdField_a_of_type_Axxm.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      if ((TextUtils.isEmpty(this.jdField_a_of_type_Axzq.e)) || (!(this.jdField_a_of_type_Axxm.jdField_a_of_type_AndroidContentContext instanceof BaseActivity))) {
        break label341;
      }
      paramView = new bghz();
      if (!(this.jdField_a_of_type_Axzq instanceof axzn)) {
        break label231;
      }
      paramView.b(((axzn)this.jdField_a_of_type_Axzq).b);
      label172:
      paramView.a(this.jdField_a_of_type_Axzq.n);
      paramView = paramView.a();
      bghy.a((BaseActivity)this.jdField_a_of_type_Axxm.jdField_a_of_type_AndroidContentContext, 0L, this.jdField_a_of_type_Axzq.e, null, 20006, "", paramView);
    }
    for (;;)
    {
      this.jdField_a_of_type_Bkho.dismiss();
      return;
      paramView = "2";
      break;
      label231:
      if ((this.jdField_a_of_type_Axzq instanceof axzp))
      {
        paramView.d(((axzp)this.jdField_a_of_type_Axzq).b).b(((axzp)this.jdField_a_of_type_Axzq).a);
        break label172;
      }
      if ((this.jdField_a_of_type_Axzq instanceof axzr))
      {
        paramView.b(((axzr)this.jdField_a_of_type_Axzq).a);
        break label172;
      }
      if ((this.jdField_a_of_type_Axzq instanceof axzt))
      {
        paramView.b(((axzt)this.jdField_a_of_type_Axzq).a);
        break label172;
      }
      if (!(this.jdField_a_of_type_Axzq instanceof axzu)) {
        break label172;
      }
      break label172;
      label341:
      QQToast.a(this.jdField_a_of_type_Axxm.jdField_a_of_type_AndroidContentContext, 2, anni.a(2131699840), 0).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axxp
 * JD-Core Version:    0.7.0.1
 */