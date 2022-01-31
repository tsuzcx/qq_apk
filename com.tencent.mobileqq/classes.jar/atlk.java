import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.qqstory.playvideo.player.TextureVideoView;
import java.io.File;

public class atlk
  implements atkx
{
  TextureVideoView a;
  
  public atlk(Context paramContext)
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
  
  public void a(atky paramatky)
  {
    this.a.setOnCompletionListener(new atll(this, paramatky));
  }
  
  public void a(atkz paramatkz) {}
  
  public void a(atla paramatla)
  {
    this.a.setOnErrorListener(new atlm(this, paramatla, null));
  }
  
  public void a(atlb paramatlb)
  {
    this.a.setOnInfoListener(new atln(this, paramatlb));
  }
  
  public void a(atlc paramatlc)
  {
    TextureVideoView localTextureVideoView = this.a;
    if (paramatlc == null) {}
    for (paramatlc = null;; paramatlc = new atlo(this, paramatlc))
    {
      localTextureVideoView.setOnPreparedListener(paramatlc);
      return;
    }
  }
  
  public void a(String paramString1, String paramString2, String paramString3, long paramLong)
  {
    paramString1 = paramString3;
    if (!TextUtils.isEmpty(paramString2))
    {
      paramString1 = paramString3;
      if (sum.a(new File(paramString2))) {
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
 * Qualified Name:     atlk
 * JD-Core Version:    0.7.0.1
 */