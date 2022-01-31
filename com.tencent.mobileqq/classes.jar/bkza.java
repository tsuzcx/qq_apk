import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import com.tencent.ttpic.openapi.model.WMElement;
import com.tencent.ttpic.openapi.watermark.LogicDataManager;
import java.util.List;

class bkza
  implements View.OnClickListener
{
  bkza(bkyz parambkyz, int paramInt, bkzh parambkzh) {}
  
  public void onClick(View paramView)
  {
    paramView = (WMElement)LogicDataManager.getInstance().getEditableWMElement().get(this.jdField_a_of_type_Int);
    if (paramView != null)
    {
      if (paramView.ischeckin) {
        bkyz.a(this.jdField_a_of_type_Bkyz, paramView, this.jdField_a_of_type_Bkzh);
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_Bkzh.a.setText("");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkza
 * JD-Core Version:    0.7.0.1
 */