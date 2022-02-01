import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.ttpic.openapi.model.WMElement;
import com.tencent.ttpic.openapi.watermark.LogicDataManager;
import java.util.List;

class bnhz
  implements View.OnClickListener
{
  bnhz(bnhy parambnhy, int paramInt, bnih parambnih) {}
  
  public void onClick(View paramView)
  {
    WMElement localWMElement = (WMElement)LogicDataManager.getInstance().getEditableWMElement().get(this.jdField_a_of_type_Int);
    if (localWMElement != null)
    {
      if (!localWMElement.ischeckin) {
        break label50;
      }
      bnhy.a(this.jdField_a_of_type_Bnhy, localWMElement, this.jdField_a_of_type_Bnih);
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      label50:
      this.jdField_a_of_type_Bnih.a.setText("");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnhz
 * JD-Core Version:    0.7.0.1
 */