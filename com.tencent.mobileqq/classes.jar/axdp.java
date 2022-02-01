import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class axdp
  implements View.OnClickListener
{
  axdp(axdo paramaxdo, Context paramContext, axfs paramaxfs, axdv paramaxdv) {}
  
  public void onClick(View paramView)
  {
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
    String str1 = this.jdField_a_of_type_Axfs.h;
    String str2 = this.jdField_a_of_type_Axfs.i;
    Object localObject2 = this.jdField_a_of_type_Axfs.k;
    if (TextUtils.isEmpty((CharSequence)localObject2))
    {
      localObject1 = this.jdField_a_of_type_Axfs.j;
      localIntent.putExtra("url", String.format("https://3gimg.qq.com/lightmap/v1/marker/?key=%s&referer=qqnearby&marker=coord:%s,%s;title:%s;addr:%s", new Object[] { "25TBZ-W4HCP-2BKDM-LBYH3-L4QRT-G3BDP", str2, str1, localObject1, localObject2 }));
      this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
      localObject2 = new bcek(this.jdField_a_of_type_Axdo.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a("dc00899").b("grp_lbs").c("data_card").d("clk_lbs").e(String.valueOf(this.jdField_a_of_type_Axdv.jdField_a_of_type_Axfs.e));
      if (!this.jdField_a_of_type_Axdo.jdField_a_of_type_Boolean) {
        break label220;
      }
    }
    label220:
    for (Object localObject1 = "1";; localObject1 = "2")
    {
      ((bcek)localObject2).a(new String[] { localObject1, "", "", this.jdField_a_of_type_Axdv.jdField_a_of_type_Axfs.c }).a();
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      localObject1 = localObject2;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axdp
 * JD-Core Version:    0.7.0.1
 */