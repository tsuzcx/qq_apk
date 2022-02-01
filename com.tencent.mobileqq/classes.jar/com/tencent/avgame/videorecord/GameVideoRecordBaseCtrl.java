package com.tencent.avgame.videorecord;

import android.content.Context;
import android.os.Build.VERSION;
import android.view.View;
import androidx.annotation.RequiresApi;
import com.tencent.av.audioprocess.AudioProcess;
import com.tencent.av.audioprocess.AudioProcessCallback.OnRecord;
import com.tencent.av.audioprocess.api.IAudioProcessApi;
import com.tencent.av.ui.funchat.record.QavRecordDpc;
import com.tencent.av.ui.funchat.record.QavRecordListener;
import com.tencent.avgame.gameroom.stage.IStageRecordPresenter;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qav.log.AVLog;
import java.io.File;
import mqq.util.WeakReference;

@RequiresApi(api=16)
public abstract class GameVideoRecordBaseCtrl
  implements AudioProcessCallback.OnRecord, QavRecordListener, IStageRecordPresenter
{
  public String a;
  protected QavRecordDpc b;
  public int c = 0;
  protected volatile boolean d = false;
  protected WeakReference<Context> e;
  private IAudioProcessApi f;
  
  public GameVideoRecordBaseCtrl(Context paramContext)
  {
    if (paramContext != null) {
      this.e = new WeakReference(paramContext);
    }
    this.b = QavRecordDpc.a();
    paramContext = new StringBuilder();
    paramContext.append(g());
    paramContext.append("_Base");
    this.a = paramContext.toString();
  }
  
  public void F() {}
  
  public void a() {}
  
  public void a(View paramView) {}
  
  public void b() {}
  
  public void b(View paramView) {}
  
  public void c() {}
  
  public void e() {}
  
  public void f() {}
  
  protected abstract String g();
  
  public boolean h()
  {
    boolean bool;
    if (Build.VERSION.SDK_INT >= 18) {
      bool = true;
    } else {
      bool = false;
    }
    String str = this.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("isDeviceSupport, sdk:");
    localStringBuilder.append(Build.VERSION.SDK_INT);
    AVLog.d(str, localStringBuilder.toString());
    return bool;
  }
  
  public boolean i()
  {
    boolean bool;
    if ((h()) && (j())) {
      bool = true;
    } else {
      bool = false;
    }
    String str = this.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("isSupportRecord. isSupport = ");
    localStringBuilder.append(bool);
    AVLog.d(str, localStringBuilder.toString());
    return bool;
  }
  
  public boolean j()
  {
    int i = this.c;
    boolean bool = true;
    if (i == 0)
    {
      if (this.b.s > this.b.e) {
        this.c = 2;
      } else if ((this.b.s == this.b.e) && (this.b.t >= this.b.f)) {
        this.c = 2;
      } else if (this.b.s > this.b.c) {
        this.c = 1;
      } else if ((this.b.s == this.b.c) && (this.b.t >= this.b.d)) {
        this.c = 1;
      } else {
        this.c = 3;
      }
      if (this.b.b != 1) {
        this.c = 4;
      }
      String str = this.a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("isPerformanceSupport=");
      localStringBuilder.append(this.c);
      AVLog.d(str, localStringBuilder.toString());
    }
    i = this.c;
    if (i != 2)
    {
      if (i == 1) {
        return true;
      }
      bool = false;
    }
    return bool;
  }
  
  public boolean k()
  {
    return this.d;
  }
  
  public boolean l()
  {
    if (!i()) {
      return false;
    }
    AVLog.d(this.a, "startRecord");
    this.d = true;
    this.f = AudioProcess.b();
    this.f.startRecord(7, this);
    return true;
  }
  
  public void m()
  {
    if (!i()) {
      return;
    }
    this.d = false;
    IAudioProcessApi localIAudioProcessApi = this.f;
    if (localIAudioProcessApi != null)
    {
      localIAudioProcessApi.stopRecord();
      this.f = null;
    }
    AVLog.d(this.a, "endRecord");
  }
  
  public void n() {}
  
  public String o()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(BaseApplicationImpl.getApplication().getFilesDir());
    ((StringBuilder)localObject).append(File.separator);
    ((StringBuilder)localObject).append("QQGameVideo");
    ((StringBuilder)localObject).append(File.separator);
    ((StringBuilder)localObject).append(System.currentTimeMillis());
    ((StringBuilder)localObject).append(".mp4");
    localObject = ((StringBuilder)localObject).toString();
    File localFile = new File((String)localObject).getParentFile();
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    return localObject;
  }
  
  public String p()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(BaseApplicationImpl.getApplication().getFilesDir());
    ((StringBuilder)localObject).append(File.separator);
    ((StringBuilder)localObject).append("QQGameVideo");
    ((StringBuilder)localObject).append(File.separator);
    ((StringBuilder)localObject).append(System.currentTimeMillis());
    ((StringBuilder)localObject).append(".jpg");
    localObject = ((StringBuilder)localObject).toString();
    File localFile = new File((String)localObject).getParentFile();
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    return localObject;
  }
  
  public void q() {}
  
  public void r() {}
  
  public void s() {}
  
  public void t() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.videorecord.GameVideoRecordBaseCtrl
 * JD-Core Version:    0.7.0.1
 */