import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.gamecenter.data.FeedsItemData.GameInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.HashMap;
import java.util.Map;

class avbf
  implements View.OnClickListener
{
  avbf(avbb paramavbb, String paramString) {}
  
  public void onClick(View paramView)
  {
    HashMap localHashMap = new HashMap();
    abuf.a(localHashMap, this.jdField_a_of_type_JavaLangString);
    localHashMap.put(Integer.valueOf(2), this.jdField_a_of_type_JavaLangString);
    localHashMap.put(Integer.valueOf(10), "0");
    abuf.a(amwn.a(), "769", "205711", this.jdField_a_of_type_Avbb.a().gameAppId, "76905", "1", "160", localHashMap);
    avbb.a(this.jdField_a_of_type_Avbb).dismiss();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avbf
 * JD-Core Version:    0.7.0.1
 */