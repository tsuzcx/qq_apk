import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.qqstory.playvideo.player.TextureVideoView;
import java.io.File;

public class avgv
  implements avgi
{
  TextureVideoView a;
  
  public avgv(Context paramContext)
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
  
  public void a(avgj paramavgj)
  {
    this.a.setOnCompletionListener(new avgw(this, paramavgj));
  }
  
  public void a(avgk paramavgk) {}
  
  public void a(avgl paramavgl)
  {
    this.a.setOnErrorListener(new avgx(this, paramavgl, null));
  }
  
  public void a(avgm paramavgm)
  {
    this.a.setOnInfoListener(new avgy(this, paramavgm));
  }
  
  public void a(avgn paramavgn)
  {
    TextureVideoView localTextureVideoView = this.a;
    if (paramavgn == null) {}
    for (paramavgn = null;; paramavgn = new avgz(this, paramavgn))
    {
      localTextureVideoView.setOnPreparedListener(paramavgn);
      return;
    }
  }
  
  public void a(String paramString1, String paramString2, String paramString3, long paramLong)
  {
    paramString1 = paramString3;
    if (!TextUtils.isEmpty(paramString2))
    {
      paramString1 = paramString3;
      if (unk.a(new File(paramString2))) {
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     avgv
 * JD-Core Version:    0.7.0.1
 */