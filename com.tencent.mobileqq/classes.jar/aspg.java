import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.qqstory.playvideo.player.TextureVideoView;
import java.io.File;

public class aspg
  implements asot
{
  TextureVideoView a;
  
  public aspg(Context paramContext)
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
  
  public void a(asou paramasou)
  {
    this.a.setOnCompletionListener(new asph(this, paramasou));
  }
  
  public void a(asov paramasov) {}
  
  public void a(asow paramasow)
  {
    this.a.setOnErrorListener(new aspi(this, paramasow, null));
  }
  
  public void a(asox paramasox)
  {
    this.a.setOnInfoListener(new aspj(this, paramasox));
  }
  
  public void a(asoy paramasoy)
  {
    TextureVideoView localTextureVideoView = this.a;
    if (paramasoy == null) {}
    for (paramasoy = null;; paramasoy = new aspk(this, paramasoy))
    {
      localTextureVideoView.setOnPreparedListener(paramasoy);
      return;
    }
  }
  
  public void a(String paramString1, String paramString2, String paramString3, long paramLong)
  {
    paramString1 = paramString3;
    if (!TextUtils.isEmpty(paramString2))
    {
      paramString1 = paramString3;
      if (shq.a(new File(paramString2))) {
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
 * Qualified Name:     aspg
 * JD-Core Version:    0.7.0.1
 */