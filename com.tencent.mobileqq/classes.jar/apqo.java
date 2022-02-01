import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.ar.view.QRScanEntryView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class apqo
  implements CompoundButton.OnCheckedChangeListener
{
  public apqo(QRScanEntryView paramQRScanEntryView) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    com.tencent.mobileqq.minicode.RecogUtil.SAVE_DETECT_IMAGE = paramBoolean;
    EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apqo
 * JD-Core Version:    0.7.0.1
 */