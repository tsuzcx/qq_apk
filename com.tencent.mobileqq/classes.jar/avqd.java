import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;

class avqd
  implements View.OnClickListener
{
  avqd(avqc paramavqc, Context paramContext, avsg paramavsg, avqj paramavqj) {}
  
  public void onClick(View paramView)
  {
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
    String str1 = this.jdField_a_of_type_Avsg.h;
    String str2 = this.jdField_a_of_type_Avsg.i;
    Object localObject = this.jdField_a_of_type_Avsg.k;
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      paramView = this.jdField_a_of_type_Avsg.j;
      localIntent.putExtra("url", String.format("http://3gimg.qq.com/lightmap/v1/marker/?key=%s&referer=qqnearby&marker=coord:%s,%s;title:%s;addr:%s", new Object[] { "25TBZ-W4HCP-2BKDM-LBYH3-L4QRT-G3BDP", str2, str1, paramView, localObject }));
      this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
      localObject = new azqx(this.jdField_a_of_type_Avqc.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a("dc00899").b("grp_lbs").c("data_card").d("clk_lbs").e(String.valueOf(this.jdField_a_of_type_Avqj.jdField_a_of_type_Avsg.e));
      if (!this.jdField_a_of_type_Avqc.jdField_a_of_type_Boolean) {
        break label210;
      }
    }
    label210:
    for (paramView = "1";; paramView = "2")
    {
      ((azqx)localObject).a(new String[] { paramView, "", "", this.jdField_a_of_type_Avqj.jdField_a_of_type_Avsg.c }).a();
      return;
      paramView = (View)localObject;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     avqd
 * JD-Core Version:    0.7.0.1
 */