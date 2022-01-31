import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import com.tencent.ttpic.openapi.model.WMElement;
import com.tencent.ttpic.openapi.watermark.LogicDataManager;
import java.util.List;

class bgzo
  implements View.OnClickListener
{
  bgzo(bgzn parambgzn, int paramInt, bgzv parambgzv) {}
  
  public void onClick(View paramView)
  {
    paramView = (WMElement)LogicDataManager.getInstance().getEditableWMElement().get(this.jdField_a_of_type_Int);
    if (paramView != null)
    {
      if (paramView.ischeckin) {
        bgzn.a(this.jdField_a_of_type_Bgzn, paramView, this.jdField_a_of_type_Bgzv);
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_Bgzv.a.setText("");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bgzo
 * JD-Core Version:    0.7.0.1
 */