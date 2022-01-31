import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mobileqq.emotionintegrate.AIOEmotionFragment;
import com.tencent.qphone.base.util.QLog;

public class anmq
  implements AdapterView.OnItemClickListener
{
  public anmq(AIOEmotionFragment paramAIOEmotionFragment) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = paramView.getTag();
    if (paramAdapterView == null)
    {
      QLog.e("AIOEmotionFragment", 1, "error, tag is null");
      return;
    }
    try
    {
      this.a.a.b();
      paramInt = ((baia)paramAdapterView).a.c;
      this.a.c(paramInt);
      return;
    }
    catch (Exception paramAdapterView)
    {
      QLog.e("AIOEmotionFragment", 1, "error, ", paramAdapterView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     anmq
 * JD-Core Version:    0.7.0.1
 */