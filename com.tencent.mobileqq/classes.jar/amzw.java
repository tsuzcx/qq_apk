import android.content.Intent;
import com.tencent.mobileqq.activity.richmedia.QzDynamicVideoPreviewActivity;
import com.tencent.mobileqq.activity.richmedia.p2veffect.utils.P2VEffectLoader;
import com.tencent.mobileqq.activity.richmedia.p2veffect.utils.P2VEffectLoader.P2VEffectDownloadListener;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import cooperation.qzone.QZoneVideoDownloadActivity;

class amzw
  implements P2VEffectLoader.P2VEffectDownloadListener
{
  amzw(amzv paramamzv) {}
  
  public void a(boolean paramBoolean)
  {
    VideoEnvironment.a("QZoneVideoDownloadActivity", "P2VEffectLoader - downLoadP2VJarModule - loadState:" + paramBoolean, null);
    if (paramBoolean)
    {
      P2VEffectLoader.a(this.a.a.getApplicationContext());
      Intent localIntent = this.a.a.getIntent();
      localIntent.setClass(this.a.a.getApplicationContext(), QzDynamicVideoPreviewActivity.class);
      this.a.a.startActivity(localIntent);
      this.a.a.overridePendingTransition(2131034134, 2131034135);
      this.a.a.finish();
      return;
    }
    VideoEnvironment.a("QZoneVideoDownloadActivity", "P2VEffectLoader - downLoadP2VJarModule - loadFailed", null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amzw
 * JD-Core Version:    0.7.0.1
 */