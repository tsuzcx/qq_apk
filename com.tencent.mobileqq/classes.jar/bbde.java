import android.view.View;
import com.tencent.mobileqq.remind.widget.IosTimepicker;
import com.tencent.widget.AdapterView;

public class bbde
  implements bljo
{
  public bbde(IosTimepicker paramIosTimepicker) {}
  
  public void onItemSelected(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    IosTimepicker.a(this.a, paramView, 1);
    if (paramView.getTag() != null)
    {
      int i = Integer.parseInt(paramView.getTag().toString());
      int j = paramAdapterView.getChildCount();
      paramInt = 0;
      while (paramInt < j)
      {
        if (i != paramInt) {
          IosTimepicker.a(this.a, paramAdapterView.getChildAt(paramInt), 0);
        }
        paramInt += 1;
      }
    }
  }
  
  public void onNothingSelected(AdapterView<?> paramAdapterView) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbde
 * JD-Core Version:    0.7.0.1
 */