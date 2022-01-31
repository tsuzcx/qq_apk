import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import com.tencent.ttpic.openapi.model.WMElement;
import com.tencent.ttpic.openapi.watermark.LogicDataManager;
import java.util.List;

class bkut
  implements View.OnClickListener
{
  bkut(bkus parambkus, int paramInt, bkva parambkva) {}
  
  public void onClick(View paramView)
  {
    paramView = (WMElement)LogicDataManager.getInstance().getEditableWMElement().get(this.jdField_a_of_type_Int);
    if (paramView != null)
    {
      if (paramView.ischeckin) {
        bkus.a(this.jdField_a_of_type_Bkus, paramView, this.jdField_a_of_type_Bkva);
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_Bkva.a.setText("");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkut
 * JD-Core Version:    0.7.0.1
 */