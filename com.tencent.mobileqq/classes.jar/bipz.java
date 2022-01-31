import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import com.tencent.ttpic.openapi.model.WMElement;
import com.tencent.ttpic.openapi.watermark.LogicDataManager;
import java.util.List;

class bipz
  implements View.OnClickListener
{
  bipz(bipy parambipy, int paramInt, biqg parambiqg) {}
  
  public void onClick(View paramView)
  {
    paramView = (WMElement)LogicDataManager.getInstance().getEditableWMElement().get(this.jdField_a_of_type_Int);
    if (paramView != null)
    {
      if (paramView.ischeckin) {
        bipy.a(this.jdField_a_of_type_Bipy, paramView, this.jdField_a_of_type_Biqg);
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_Biqg.a.setText("");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bipz
 * JD-Core Version:    0.7.0.1
 */