import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import com.tencent.ttpic.openapi.model.WMElement;
import com.tencent.ttpic.openapi.watermark.LogicDataManager;
import java.util.List;

class bipi
  implements View.OnClickListener
{
  bipi(biph parambiph, int paramInt, bipp parambipp) {}
  
  public void onClick(View paramView)
  {
    paramView = (WMElement)LogicDataManager.getInstance().getEditableWMElement().get(this.jdField_a_of_type_Int);
    if (paramView != null)
    {
      if (paramView.ischeckin) {
        biph.a(this.jdField_a_of_type_Biph, paramView, this.jdField_a_of_type_Bipp);
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_Bipp.a.setText("");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bipi
 * JD-Core Version:    0.7.0.1
 */