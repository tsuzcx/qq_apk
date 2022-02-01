import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.gamecenter.data.FeedsItemData.GameInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.HashMap;
import java.util.Map;

class auqy
  implements View.OnClickListener
{
  auqy(auqu paramauqu, String paramString) {}
  
  public void onClick(View paramView)
  {
    HashMap localHashMap = new HashMap();
    aceh.a(localHashMap, this.jdField_a_of_type_JavaLangString);
    localHashMap.put(Integer.valueOf(2), this.jdField_a_of_type_JavaLangString);
    localHashMap.put(Integer.valueOf(10), "0");
    aceh.a(ampj.a(), "769", "205711", this.jdField_a_of_type_Auqu.a().gameAppId, "76905", "1", "160", localHashMap);
    auqu.a(this.jdField_a_of_type_Auqu).dismiss();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     auqy
 * JD-Core Version:    0.7.0.1
 */