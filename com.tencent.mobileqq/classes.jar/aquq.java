import android.os.Vibrator;
import android.view.View;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.conditionsearch.widget.TimeSelectView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemSelectedListener;

public class aquq
  implements AdapterView.OnItemSelectedListener
{
  public aquq(TimeSelectView paramTimeSelectView) {}
  
  public void onItemSelected(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    TimeSelectView.a(this.a, paramView, 1);
    TimeSelectView.a(this.a, paramView, true);
    if ((paramView != null) && (paramView.getTag() != null))
    {
      int i = Integer.parseInt(paramView.getTag().toString());
      int j = paramAdapterView.getChildCount();
      paramInt = 0;
      while (paramInt < j)
      {
        if (i != paramInt)
        {
          TimeSelectView.a(this.a, paramAdapterView.getChildAt(paramInt), 0);
          TimeSelectView.a(this.a, paramAdapterView.getChildAt(paramInt), false);
        }
        paramInt += 1;
      }
    }
    if ((!TimeSelectView.a(this.a)) && (this.a.a != null))
    {
      this.a.a.vibrate(QQAppInterface.VIBRATOR_TIME_SELECTOR, -1);
      if (QLog.isColorLevel()) {
        QLog.d("TimeSelectView", 1, "hasVibrator: " + this.a.a.hasVibrator() + "Vibrator vibrate! " + TimeSelectView.a(this.a));
      }
    }
    TimeSelectView.a(this.a, false);
  }
  
  public void onNothingSelected(AdapterView<?> paramAdapterView) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aquq
 * JD-Core Version:    0.7.0.1
 */