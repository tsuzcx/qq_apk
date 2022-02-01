import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqfav.widget.LocationDetailActivity;

public class bmcd
  extends aqnu
{
  public bmcd(LocationDetailActivity paramLocationDetailActivity) {}
  
  public void onAddColorNote(Bundle paramBundle, boolean paramBoolean)
  {
    super.onAddColorNote(paramBundle, paramBoolean);
    QLog.e("PoiMapActivity", 1, "[ColorNote exit]");
    if (this.a.v)
    {
      bdla.b(null, "dc00898", "", "", "0X800A991", "0X800A991", 4, 0, "", "", "", "");
      return;
    }
    bdla.b(null, "dc00898", "", "", "0X800A990", "0X800A990", 4, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmcd
 * JD-Core Version:    0.7.0.1
 */