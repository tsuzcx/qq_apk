import android.view.View;
import com.tencent.mobileqq.troop.widget.WheelPickerLayout;
import com.tencent.widget.AdapterView;

public class bctp
  implements bhuy
{
  public bctp(WheelPickerLayout paramWheelPickerLayout) {}
  
  public void onItemSelected(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    WheelPickerLayout.a(this.a, paramView, 1);
    WheelPickerLayout.a(this.a, paramView, true);
    if ((paramView != null) && (paramView.getTag() != null))
    {
      int i = Integer.parseInt(paramView.getTag().toString());
      int j = paramAdapterView.getChildCount();
      paramInt = 0;
      while (paramInt < j)
      {
        if (i != paramInt)
        {
          WheelPickerLayout.a(this.a, paramAdapterView.getChildAt(paramInt), 0);
          WheelPickerLayout.a(this.a, paramAdapterView.getChildAt(paramInt), false);
        }
        paramInt += 1;
      }
    }
  }
  
  public void onNothingSelected(AdapterView<?> paramAdapterView) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bctp
 * JD-Core Version:    0.7.0.1
 */