import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.widget.QQToast;

class axdr
  implements bjoe
{
  axdr(axdo paramaxdo, axdv paramaxdv, axfs paramaxfs, bjnw parambjnw) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    }
    awrs localawrs = new awrs().h("data_card").i("feed_inform").d("2").a(this.jdField_a_of_type_Axdo.a(this.jdField_a_of_type_Axdv)).b(this.jdField_a_of_type_Axfs.c).c(String.valueOf(this.jdField_a_of_type_Axdo.a(this.jdField_a_of_type_Axdv)));
    if (this.jdField_a_of_type_Axdo.jdField_a_of_type_Boolean)
    {
      paramView = "1";
      localawrs.e(paramView).b(this.jdField_a_of_type_Axdo.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      if ((TextUtils.isEmpty(this.jdField_a_of_type_Axfs.e)) || (!(this.jdField_a_of_type_Axdo.jdField_a_of_type_AndroidContentContext instanceof BaseActivity))) {
        break label341;
      }
      paramView = new bfrk();
      if (!(this.jdField_a_of_type_Axfs instanceof axfp)) {
        break label231;
      }
      paramView.b(((axfp)this.jdField_a_of_type_Axfs).b);
      label172:
      paramView.a(this.jdField_a_of_type_Axfs.n);
      paramView = paramView.a();
      bfrj.a((BaseActivity)this.jdField_a_of_type_Axdo.jdField_a_of_type_AndroidContentContext, 0L, this.jdField_a_of_type_Axfs.e, null, 20006, "", paramView);
    }
    for (;;)
    {
      this.jdField_a_of_type_Bjnw.dismiss();
      return;
      paramView = "2";
      break;
      label231:
      if ((this.jdField_a_of_type_Axfs instanceof axfr))
      {
        paramView.d(((axfr)this.jdField_a_of_type_Axfs).b).b(((axfr)this.jdField_a_of_type_Axfs).a);
        break label172;
      }
      if ((this.jdField_a_of_type_Axfs instanceof axft))
      {
        paramView.b(((axft)this.jdField_a_of_type_Axfs).a);
        break label172;
      }
      if ((this.jdField_a_of_type_Axfs instanceof axfv))
      {
        paramView.b(((axfv)this.jdField_a_of_type_Axfs).a);
        break label172;
      }
      if (!(this.jdField_a_of_type_Axfs instanceof axfw)) {
        break label172;
      }
      break label172;
      label341:
      QQToast.a(this.jdField_a_of_type_Axdo.jdField_a_of_type_AndroidContentContext, 2, amtj.a(2131700182), 0).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axdr
 * JD-Core Version:    0.7.0.1
 */