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

class aqqh
  implements View.OnClickListener
{
  aqqh(aqqc paramaqqc, String paramString1, String paramString2) {}
  
  public void onClick(View paramView)
  {
    paramView = new HashMap();
    yoa.a(paramView, this.jdField_a_of_type_JavaLangString);
    paramView.put(Integer.valueOf(2), this.jdField_a_of_type_JavaLangString);
    paramView.put(Integer.valueOf(10), "1");
    paramView.put(Integer.valueOf(12), this.b);
    Intent localIntent = new Intent(aqqc.a(this.jdField_a_of_type_Aqqc), QQBrowserActivity.class);
    if (TextUtils.isEmpty(this.b))
    {
      localIntent.putExtra("url", "https://speed.gamecenter.qq.com/pushgame/v1/home/index?ADTAG=gzh&_wv=18950115&_wwv=393");
      paramView.put(Integer.valueOf(12), this.b + "&adtag=gzhyuyuezq");
    }
    for (;;)
    {
      yoa.a(ajac.a(), "769", "205711", this.jdField_a_of_type_Aqqc.a().gameAppId, "76905", "1", "160", paramView);
      aqqc.a(this.jdField_a_of_type_Aqqc).startActivity(localIntent);
      aqqc.a(this.jdField_a_of_type_Aqqc).dismiss();
      return;
      localIntent.putExtra("url", this.b);
      paramView.put(Integer.valueOf(12), this.b + "&adtag=gzhyuyuebl");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aqqh
 * JD-Core Version:    0.7.0.1
 */