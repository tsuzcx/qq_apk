import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.ttpic.openapi.model.WMElement;
import com.tencent.ttpic.openapi.watermark.LogicDataManager;
import java.util.List;

class bnoe
  implements View.OnClickListener
{
  bnoe(bnod parambnod, int paramInt, bnol parambnol) {}
  
  public void onClick(View paramView)
  {
    WMElement localWMElement = (WMElement)LogicDataManager.getInstance().getEditableWMElement().get(this.jdField_a_of_type_Int);
    if (localWMElement != null)
    {
      if (!localWMElement.ischeckin) {
        break label50;
      }
      bnod.a(this.jdField_a_of_type_Bnod, localWMElement, this.jdField_a_of_type_Bnol);
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      label50:
      this.jdField_a_of_type_Bnol.a.setText("");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnoe
 * JD-Core Version:    0.7.0.1
 */