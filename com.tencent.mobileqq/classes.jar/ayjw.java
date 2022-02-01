import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.widget.QQToast;

class ayjw
  implements bkzq
{
  ayjw(ayjt paramayjt, ayka paramayka, aylx paramaylx, bkzi parambkzi) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    }
    axxu localaxxu = new axxu().h("data_card").i("feed_inform").d("2").a(this.jdField_a_of_type_Ayjt.a(this.jdField_a_of_type_Ayka)).b(this.jdField_a_of_type_Aylx.c).c(String.valueOf(this.jdField_a_of_type_Ayjt.a(this.jdField_a_of_type_Ayka)));
    if (this.jdField_a_of_type_Ayjt.jdField_a_of_type_Boolean)
    {
      paramView = "1";
      localaxxu.e(paramView).b(this.jdField_a_of_type_Ayjt.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      if ((TextUtils.isEmpty(this.jdField_a_of_type_Aylx.e)) || (!(this.jdField_a_of_type_Ayjt.jdField_a_of_type_AndroidContentContext instanceof BaseActivity))) {
        break label341;
      }
      paramView = new bhab();
      if (!(this.jdField_a_of_type_Aylx instanceof aylu)) {
        break label231;
      }
      paramView.b(((aylu)this.jdField_a_of_type_Aylx).b);
      label172:
      paramView.a(this.jdField_a_of_type_Aylx.n);
      paramView = paramView.a();
      bhaa.a((BaseActivity)this.jdField_a_of_type_Ayjt.jdField_a_of_type_AndroidContentContext, 0L, this.jdField_a_of_type_Aylx.e, null, 20006, "", paramView);
    }
    for (;;)
    {
      this.jdField_a_of_type_Bkzi.dismiss();
      return;
      paramView = "2";
      break;
      label231:
      if ((this.jdField_a_of_type_Aylx instanceof aylw))
      {
        paramView.d(((aylw)this.jdField_a_of_type_Aylx).b).b(((aylw)this.jdField_a_of_type_Aylx).a);
        break label172;
      }
      if ((this.jdField_a_of_type_Aylx instanceof ayly))
      {
        paramView.b(((ayly)this.jdField_a_of_type_Aylx).a);
        break label172;
      }
      if ((this.jdField_a_of_type_Aylx instanceof ayma))
      {
        paramView.b(((ayma)this.jdField_a_of_type_Aylx).a);
        break label172;
      }
      if (!(this.jdField_a_of_type_Aylx instanceof aymb)) {
        break label172;
      }
      break label172;
      label341:
      QQToast.a(this.jdField_a_of_type_Ayjt.jdField_a_of_type_AndroidContentContext, 2, anvx.a(2131700533), 0).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayjw
 * JD-Core Version:    0.7.0.1
 */