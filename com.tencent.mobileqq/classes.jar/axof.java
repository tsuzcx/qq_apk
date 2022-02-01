import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.qqstory.playvideo.player.TextureVideoView;
import java.io.File;

public class axof
  implements axns
{
  TextureVideoView a;
  
  public axof(Context paramContext)
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
  
  public void a(axnt paramaxnt)
  {
    this.a.setOnCompletionListener(new axog(this, paramaxnt));
  }
  
  public void a(axnu paramaxnu) {}
  
  public void a(axnv paramaxnv)
  {
    this.a.setOnErrorListener(new axoh(this, paramaxnv, null));
  }
  
  public void a(axnw paramaxnw)
  {
    this.a.setOnInfoListener(new axoi(this, paramaxnw));
  }
  
  public void a(axnx paramaxnx)
  {
    TextureVideoView localTextureVideoView = this.a;
    if (paramaxnx == null) {}
    for (paramaxnx = null;; paramaxnx = new axoj(this, paramaxnx))
    {
      localTextureVideoView.setOnPreparedListener(paramaxnx);
      return;
    }
  }
  
  public void a(String paramString1, String paramString2, String paramString3, long paramLong)
  {
    paramString1 = paramString3;
    if (!TextUtils.isEmpty(paramString2))
    {
      paramString1 = paramString3;
      if (wgw.a(new File(paramString2))) {
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
 * Qualified Name:     axof
 * JD-Core Version:    0.7.0.1
 */