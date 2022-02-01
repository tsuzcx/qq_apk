import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.ttpic.openapi.model.WMElement;
import com.tencent.ttpic.openapi.watermark.LogicDataManager;
import java.util.List;

class bopp
  implements View.OnClickListener
{
  bopp(bopo parambopo, int paramInt, bopw parambopw) {}
  
  public void onClick(View paramView)
  {
    WMElement localWMElement = (WMElement)LogicDataManager.getInstance().getEditableWMElement().get(this.jdField_a_of_type_Int);
    if (localWMElement != null)
    {
      if (!localWMElement.ischeckin) {
        break label50;
      }
      bopo.a(this.jdField_a_of_type_Bopo, localWMElement, this.jdField_a_of_type_Bopw);
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      label50:
      this.jdField_a_of_type_Bopw.a.setText("");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bopp
 * JD-Core Version:    0.7.0.1
 */