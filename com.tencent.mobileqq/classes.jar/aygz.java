import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.qqstory.playvideo.player.TextureVideoView;
import java.io.File;

public class aygz
  implements aygm
{
  TextureVideoView a;
  
  public aygz(Context paramContext)
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
  
  public void a(aygn paramaygn)
  {
    this.a.setOnCompletionListener(new ayha(this, paramaygn));
  }
  
  public void a(aygo paramaygo) {}
  
  public void a(aygp paramaygp)
  {
    this.a.setOnErrorListener(new ayhb(this, paramaygp, null));
  }
  
  public void a(aygq paramaygq)
  {
    this.a.setOnInfoListener(new ayhc(this, paramaygq));
  }
  
  public void a(aygr paramaygr)
  {
    TextureVideoView localTextureVideoView = this.a;
    if (paramaygr == null) {}
    for (paramaygr = null;; paramaygr = new ayhd(this, paramaygr))
    {
      localTextureVideoView.setOnPreparedListener(paramaygr);
      return;
    }
  }
  
  public void a(String paramString1, String paramString2, String paramString3, long paramLong)
  {
    paramString1 = paramString3;
    if (!TextUtils.isEmpty(paramString2))
    {
      paramString1 = paramString3;
      if (wkr.a(new File(paramString2))) {
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
 * Qualified Name:     aygz
 * JD-Core Version:    0.7.0.1
 */