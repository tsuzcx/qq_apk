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
  public int a;
  private IAudioProcessApi a;
  protected QavRecordDpc a;
  public String a;
  protected WeakReference<Context> a;
  protected volatile boolean a;
  
  public GameVideoRecordBaseCtrl(Context paramContext)
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_Boolean = false;
    if (paramContext != null) {
      this.jdField_a_of_type_MqqUtilWeakReference = new WeakReference(paramContext);
    }
    this.jdField_a_of_type_ComTencentAvUiFunchatRecordQavRecordDpc = QavRecordDpc.a();
    paramContext = new StringBuilder();
    paramContext.append(a());
    paramContext.append("_Base");
    this.jdField_a_of_type_JavaLangString = paramContext.toString();
  }
  
  protected abstract String a();
  
  public void a() {}
  
  public void a(View paramView) {}
  
  public boolean a()
  {
    boolean bool;
    if (Build.VERSION.SDK_INT >= 18) {
      bool = true;
    } else {
      bool = false;
    }
    String str = this.jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("isDeviceSupport, sdk:");
    localStringBuilder.append(Build.VERSION.SDK_INT);
    AVLog.d(str, localStringBuilder.toString());
    return bool;
  }
  
  public String b()
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
  
  public void b() {}
  
  public void b(View paramView) {}
  
  public boolean b()
  {
    boolean bool;
    if ((a()) && (c())) {
      bool = true;
    } else {
      bool = false;
    }
    String str = this.jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("isSupportRecord. isSupport = ");
    localStringBuilder.append(bool);
    AVLog.d(str, localStringBuilder.toString());
    return bool;
  }
  
  public String c()
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
  
  public void c() {}
  
  public boolean c()
  {
    int i = this.jdField_a_of_type_Int;
    boolean bool = true;
    if (i == 0)
    {
      if (this.jdField_a_of_type_ComTencentAvUiFunchatRecordQavRecordDpc.r > this.jdField_a_of_type_ComTencentAvUiFunchatRecordQavRecordDpc.d) {
        this.jdField_a_of_type_Int = 2;
      } else if ((this.jdField_a_of_type_ComTencentAvUiFunchatRecordQavRecordDpc.r == this.jdField_a_of_type_ComTencentAvUiFunchatRecordQavRecordDpc.d) && (this.jdField_a_of_type_ComTencentAvUiFunchatRecordQavRecordDpc.s >= this.jdField_a_of_type_ComTencentAvUiFunchatRecordQavRecordDpc.e)) {
        this.jdField_a_of_type_Int = 2;
      } else if (this.jdField_a_of_type_ComTencentAvUiFunchatRecordQavRecordDpc.r > this.jdField_a_of_type_ComTencentAvUiFunchatRecordQavRecordDpc.b) {
        this.jdField_a_of_type_Int = 1;
      } else if ((this.jdField_a_of_type_ComTencentAvUiFunchatRecordQavRecordDpc.r == this.jdField_a_of_type_ComTencentAvUiFunchatRecordQavRecordDpc.b) && (this.jdField_a_of_type_ComTencentAvUiFunchatRecordQavRecordDpc.s >= this.jdField_a_of_type_ComTencentAvUiFunchatRecordQavRecordDpc.c)) {
        this.jdField_a_of_type_Int = 1;
      } else {
        this.jdField_a_of_type_Int = 3;
      }
      if (this.jdField_a_of_type_ComTencentAvUiFunchatRecordQavRecordDpc.jdField_a_of_type_Int != 1) {
        this.jdField_a_of_type_Int = 4;
      }
      String str = this.jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("isPerformanceSupport=");
      localStringBuilder.append(this.jdField_a_of_type_Int);
      AVLog.d(str, localStringBuilder.toString());
    }
    i = this.jdField_a_of_type_Int;
    if (i != 2)
    {
      if (i == 1) {
        return true;
      }
      bool = false;
    }
    return bool;
  }
  
  public boolean d()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public void e() {}
  
  public boolean e()
  {
    if (!b()) {
      return false;
    }
    AVLog.d(this.jdField_a_of_type_JavaLangString, "startRecord");
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentAvAudioprocessApiIAudioProcessApi = AudioProcess.a();
    this.jdField_a_of_type_ComTencentAvAudioprocessApiIAudioProcessApi.startRecord(7, this);
    return true;
  }
  
  public void f() {}
  
  public void g() {}
  
  public void h() {}
  
  public void i() {}
  
  public void j() {}
  
  public void k()
  {
    if (!b()) {
      return;
    }
    this.jdField_a_of_type_Boolean = false;
    IAudioProcessApi localIAudioProcessApi = this.jdField_a_of_type_ComTencentAvAudioprocessApiIAudioProcessApi;
    if (localIAudioProcessApi != null)
    {
      localIAudioProcessApi.stopRecord();
      this.jdField_a_of_type_ComTencentAvAudioprocessApiIAudioProcessApi = null;
    }
    AVLog.d(this.jdField_a_of_type_JavaLangString, "endRecord");
  }
  
  public void l() {}
  
  public void o() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.videorecord.GameVideoRecordBaseCtrl
 * JD-Core Version:    0.7.0.1
 */