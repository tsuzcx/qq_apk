import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;

class atuu
  implements View.OnClickListener
{
  atuu(atut paramatut, Context paramContext, atwx paramatwx, atva paramatva) {}
  
  public void onClick(View paramView)
  {
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
    String str1 = this.jdField_a_of_type_Atwx.h;
    String str2 = this.jdField_a_of_type_Atwx.i;
    Object localObject = this.jdField_a_of_type_Atwx.k;
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      paramView = this.jdField_a_of_type_Atwx.j;
      localIntent.putExtra("url", String.format("http://3gimg.qq.com/lightmap/v1/marker/?key=%s&referer=qqnearby&marker=coord:%s,%s;title:%s;addr:%s", new Object[] { "25TBZ-W4HCP-2BKDM-LBYH3-L4QRT-G3BDP", str2, str1, paramView, localObject }));
      this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
      localObject = new axrc(this.jdField_a_of_type_Atut.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a("dc00899").b("grp_lbs").c("data_card").d("clk_lbs").e(String.valueOf(this.jdField_a_of_type_Atva.jdField_a_of_type_Atwx.e));
      if (!this.jdField_a_of_type_Atut.jdField_a_of_type_Boolean) {
        break label210;
      }
    }
    label210:
    for (paramView = "1";; paramView = "2")
    {
      ((axrc)localObject).a(new String[] { paramView, "", "", this.jdField_a_of_type_Atva.jdField_a_of_type_Atwx.c }).a();
      return;
      paramView = (View)localObject;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atuu
 * JD-Core Version:    0.7.0.1
 */