import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqfav.widget.LocationDetailActivity;

public class bkqu
  extends apkq
{
  public bkqu(LocationDetailActivity paramLocationDetailActivity) {}
  
  public void onAddColorNote(Bundle paramBundle, boolean paramBoolean)
  {
    super.onAddColorNote(paramBundle, paramBoolean);
    QLog.e("PoiMapActivity", 1, "[ColorNote exit]");
    if (this.a.v)
    {
      bcef.b(null, "dc00898", "", "", "0X800A991", "0X800A991", 4, 0, "", "", "", "");
      return;
    }
    bcef.b(null, "dc00898", "", "", "0X800A990", "0X800A990", 4, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkqu
 * JD-Core Version:    0.7.0.1
 */