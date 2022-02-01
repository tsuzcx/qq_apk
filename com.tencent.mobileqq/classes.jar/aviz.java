import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.gamecenter.data.FeedsItemData.GameInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.HashMap;
import java.util.Map;

class aviz
  implements View.OnClickListener
{
  aviz(aviu paramaviu, String paramString1, String paramString2) {}
  
  public void onClick(View paramView)
  {
    HashMap localHashMap = new HashMap();
    acik.a(localHashMap, this.jdField_a_of_type_JavaLangString);
    localHashMap.put(Integer.valueOf(2), this.jdField_a_of_type_JavaLangString);
    localHashMap.put(Integer.valueOf(10), "1");
    localHashMap.put(Integer.valueOf(12), this.b);
    Intent localIntent = new Intent(aviu.a(this.jdField_a_of_type_Aviu), QQBrowserActivity.class);
    if (TextUtils.isEmpty(this.b))
    {
      localIntent.putExtra("url", "https://speed.gamecenter.qq.com/pushgame/v1/home/index?ADTAG=gzh&_wv=18950115&_wwv=393");
      localHashMap.put(Integer.valueOf(12), this.b + "&adtag=gzhyuyuezq");
    }
    for (;;)
    {
      acik.a(anbd.a(), "769", "205711", this.jdField_a_of_type_Aviu.a().gameAppId, "76905", "1", "160", localHashMap);
      aviu.a(this.jdField_a_of_type_Aviu).startActivity(localIntent);
      aviu.a(this.jdField_a_of_type_Aviu).dismiss();
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      localIntent.putExtra("url", this.b);
      localHashMap.put(Integer.valueOf(12), this.b + "&adtag=gzhyuyuebl");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aviz
 * JD-Core Version:    0.7.0.1
 */