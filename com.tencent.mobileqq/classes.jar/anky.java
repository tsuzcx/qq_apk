import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class anky
  implements AdapterView.OnItemClickListener
{
  anky(ankx paramankx, String paramString) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    Message localMessage = this.jdField_a_of_type_Ankx.a.obtainMessage();
    localMessage.what = ((int)paramLong);
    localMessage.obj = this.jdField_a_of_type_JavaLangString;
    localMessage.sendToTarget();
    EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anky
 * JD-Core Version:    0.7.0.1
 */