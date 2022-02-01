import android.view.View;
import com.tencent.mobileqq.conditionsearch.widget.IphonePickerView;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemSelectedListener;

public class aqug
  implements AdapterView.OnItemSelectedListener
{
  public aqug(IphonePickerView paramIphonePickerView) {}
  
  public void onItemSelected(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    IphonePickerView.a(this.a, paramView, 1);
    IphonePickerView.a(this.a, paramView, true);
    if ((paramView != null) && (paramView.getTag() != null))
    {
      int i = Integer.parseInt(paramView.getTag().toString());
      int j = paramAdapterView.getChildCount();
      paramInt = 0;
      while (paramInt < j)
      {
        if (i != paramInt)
        {
          IphonePickerView.a(this.a, paramAdapterView.getChildAt(paramInt), 0);
          IphonePickerView.a(this.a, paramAdapterView.getChildAt(paramInt), false);
        }
        paramInt += 1;
      }
    }
  }
  
  public void onNothingSelected(AdapterView<?> paramAdapterView) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqug
 * JD-Core Version:    0.7.0.1
 */