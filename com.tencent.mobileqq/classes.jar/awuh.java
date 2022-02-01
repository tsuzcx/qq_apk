import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.qqstory.playvideo.player.TextureVideoView;
import java.io.File;

public class awuh
  implements awtu
{
  TextureVideoView a;
  
  public awuh(Context paramContext)
  {
    this.a = new TextureVideoView(paramContext.getApplicationContext());
  }
  
  public int a()
  {
    if (this.a == null) {
      return 0;
    }
    return (int)(this.a.getCurrentPosition() / (this.a.getDuration() + 0.1D) * 100.0D);
  }
  
  public long a()
  {
    return this.a.getCurrentPosition();
  }
  
  public View a()
  {
    return this.a;
  }
  
  public void a()
  {
    this.a.a();
  }
  
  public void a(long paramLong)
  {
    this.a.seekTo((int)paramLong);
  }
  
  public void a(awtv paramawtv)
  {
    this.a.setOnCompletionListener(new awui(this, paramawtv));
  }
  
  public void a(awtw paramawtw) {}
  
  public void a(awtx paramawtx)
  {
    this.a.setOnErrorListener(new awuj(this, paramawtx, null));
  }
  
  public void a(awty paramawty)
  {
    this.a.setOnInfoListener(new awuk(this, paramawty));
  }
  
  public void a(awtz paramawtz)
  {
    TextureVideoView localTextureVideoView = this.a;
    if (paramawtz == null) {}
    for (paramawtz = null;; paramawtz = new awul(this, paramawtz))
    {
      localTextureVideoView.setOnPreparedListener(paramawtz);
      return;
    }
  }
  
  public void a(String paramString1, String paramString2, String paramString3, long paramLong)
  {
    paramString1 = paramString3;
    if (!TextUtils.isEmpty(paramString2))
    {
      paramString1 = paramString3;
      if (vmq.a(new File(paramString2))) {
        paramString1 = paramString2;
      }
    }
    this.a.setVideoPath(paramString1);
  }
  
  public boolean a()
  {
    return this.a.isPlaying();
  }
  
  public void b()
  {
    this.a.start();
  }
  
  public void c()
  {
    this.a.pause();
  }
  
  public void d()
  {
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awuh
 * JD-Core Version:    0.7.0.1
 */