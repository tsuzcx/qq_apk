import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.gamecenter.data.FeedsItemData.GameInfo;
import java.util.HashMap;
import java.util.Map;

class aqqf
  implements View.OnClickListener
{
  aqqf(aqqa paramaqqa, String paramString1, String paramString2) {}
  
  public void onClick(View paramView)
  {
    paramView = new HashMap();
    yod.a(paramView, this.jdField_a_of_type_JavaLangString);
    paramView.put(Integer.valueOf(2), this.jdField_a_of_type_JavaLangString);
    paramView.put(Integer.valueOf(10), "1");
    paramView.put(Integer.valueOf(12), this.b);
    Intent localIntent = new Intent(aqqa.a(this.jdField_a_of_type_Aqqa), QQBrowserActivity.class);
    if (TextUtils.isEmpty(this.b))
    {
      localIntent.putExtra("url", "https://speed.gamecenter.qq.com/pushgame/v1/home/index?ADTAG=gzh&_wv=18950115&_wwv=393");
      paramView.put(Integer.valueOf(12), this.b + "&adtag=gzhyuyuezq");
    }
    for (;;)
    {
      yod.a(ajae.a(), "769", "205711", this.jdField_a_of_type_Aqqa.a().gameAppId, "76905", "1", "160", paramView);
      aqqa.a(this.jdField_a_of_type_Aqqa).startActivity(localIntent);
      aqqa.a(this.jdField_a_of_type_Aqqa).dismiss();
      return;
      localIntent.putExtra("url", this.b);
      paramView.put(Integer.valueOf(12), this.b + "&adtag=gzhyuyuebl");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aqqf
 * JD-Core Version:    0.7.0.1
 */