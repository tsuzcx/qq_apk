import android.content.Intent;
import com.tencent.mobileqq.richmedia.capture.data.MusicItemInfo;
import dov.com.qq.im.capture.music.humrecognition.HummingActivity;

public class bhja
  extends bhim
{
  public bhja(HummingActivity paramHummingActivity) {}
  
  public void a(int paramInt) {}
  
  public void a(String paramString) {}
  
  public void a(String paramString, int paramInt) {}
  
  public void a(String paramString, boolean paramBoolean)
  {
    bcec.a().a(ajjy.a(2131639878) + HummingActivity.a(this.a), 0);
  }
  
  public void a(String paramString, boolean paramBoolean, int paramInt)
  {
    if ((paramBoolean) && (paramString != null) && (HummingActivity.a(this.a).getLocalPath().equals(paramString)))
    {
      paramString = new Intent();
      paramString.putExtra("EXTRA_HUM_RECOGNITION_RESULT", HummingActivity.a(this.a));
      this.a.setResult(-1, paramString);
      this.a.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bhja
 * JD-Core Version:    0.7.0.1
 */