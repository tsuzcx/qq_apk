import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.troop.activity.MediaPreviewActivity;
import com.tencent.widget.AdapterView;

public class bbgc
  implements bhuy
{
  public bbgc(MediaPreviewActivity paramMediaPreviewActivity) {}
  
  public void onItemSelected(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (paramView == null) {
      return;
    }
    if (this.a.jdField_a_of_type_Bcrd != null) {
      this.a.jdField_a_of_type_Bcrd.a(false, paramInt);
    }
    this.a.jdField_a_of_type_Int = paramInt;
    paramAdapterView = this.a.jdField_a_of_type_Int + 1 + "/" + this.a.b;
    this.a.jdField_a_of_type_AndroidWidgetTextView.setText(paramAdapterView);
  }
  
  public void onNothingSelected(AdapterView<?> paramAdapterView) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbgc
 * JD-Core Version:    0.7.0.1
 */