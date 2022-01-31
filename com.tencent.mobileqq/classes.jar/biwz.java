import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqfav.widget.LocationDetailActivity;

public class biwz
  extends aobz
{
  public biwz(LocationDetailActivity paramLocationDetailActivity) {}
  
  public void onAddColorNote(Bundle paramBundle, boolean paramBoolean)
  {
    super.onAddColorNote(paramBundle, paramBoolean);
    QLog.e("PoiMapActivity", 1, "[ColorNote exit]");
    if (this.a.v)
    {
      azqs.b(null, "dc00898", "", "", "0X800A991", "0X800A991", 4, 0, "", "", "", "");
      return;
    }
    azqs.b(null, "dc00898", "", "", "0X800A990", "0X800A990", 4, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     biwz
 * JD-Core Version:    0.7.0.1
 */