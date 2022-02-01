import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.gamecenter.data.FeedsItemData.GameInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.HashMap;
import java.util.Map;

class atwe
  implements View.OnClickListener
{
  atwe(atwa paramatwa, String paramString) {}
  
  public void onClick(View paramView)
  {
    HashMap localHashMap = new HashMap();
    abet.a(localHashMap, this.jdField_a_of_type_JavaLangString);
    localHashMap.put(Integer.valueOf(2), this.jdField_a_of_type_JavaLangString);
    localHashMap.put(Integer.valueOf(10), "0");
    abet.a(alvx.a(), "769", "205711", this.jdField_a_of_type_Atwa.a().gameAppId, "76905", "1", "160", localHashMap);
    atwa.a(this.jdField_a_of_type_Atwa).dismiss();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atwe
 * JD-Core Version:    0.7.0.1
 */