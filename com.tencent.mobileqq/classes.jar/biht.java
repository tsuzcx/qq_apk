import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;

class biht
  implements aaea
{
  biht(biho parambiho) {}
  
  public void callback(Bundle paramBundle)
  {
    int i = paramBundle.getInt("fontSize", 1);
    QLog.d("SwiftBrowserShareMenuHandler", 2, new Object[] { "adjustFontSize curFontSizeIndex=", Integer.valueOf(this.a.b), " globalFontSizeIndex=", Integer.valueOf(i) });
    if (i != this.a.b)
    {
      this.a.b = i;
      this.a.b(this.a.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     biht
 * JD-Core Version:    0.7.0.1
 */