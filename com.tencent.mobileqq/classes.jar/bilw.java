import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.common.app.InnerFrameManager;
import com.tencent.open.agent.GroupListOpenFrame;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class bilw
  implements View.OnClickListener
{
  bilw(bilv parambilv, int paramInt, String paramString) {}
  
  public void onClick(View paramView)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("group_index", this.jdField_a_of_type_Int);
    localBundle.putString("group_name", this.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_Bilv.a.a.a(1, localBundle);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bilw
 * JD-Core Version:    0.7.0.1
 */