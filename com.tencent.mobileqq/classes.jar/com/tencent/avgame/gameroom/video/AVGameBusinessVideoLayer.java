package com.tencent.avgame.gameroom.video;

import android.annotation.TargetApi;
import android.content.Context;
import android.opengl.GLES20;
import android.os.Handler;
import com.tencent.av.opengl.glrenderer.GLCanvas;
import com.tencent.avgame.app.AVGameAppInterface;
import com.tencent.avgame.gameroom.MemberVideoDisplayInfo;
import com.tencent.avgame.gameroom.stage.IStagePresenter;
import com.tencent.avgame.gameroom.stage.IStageRecordPresenter;
import com.tencent.avgame.ui.AVGameHandler;
import com.tencent.avgame.videorecord.GameVideoRecordPresenterWrapper;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qav.log.AVLog;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

@TargetApi(18)
public class AVGameBusinessVideoLayer
  extends AVGameVideoLayer
{
  private GameVideoRecordPresenterWrapper R = new GameVideoRecordPresenterWrapper(paramContext, this);
  
  public AVGameBusinessVideoLayer(Context paramContext, AVGameAppInterface paramAVGameAppInterface)
  {
    super(paramContext, paramAVGameAppInterface);
  }
  
  private boolean b(long paramLong)
  {
    Iterator localIterator = this.I.iterator();
    for (boolean bool = false; localIterator.hasNext(); bool = true)
    {
      label13:
      MemberVideoDisplayInfo localMemberVideoDisplayInfo = (MemberVideoDisplayInfo)localIterator.next();
      if ((localMemberVideoDisplayInfo.a != paramLong) || (localMemberVideoDisplayInfo.g)) {
        break label13;
      }
    }
    return bool;
  }
  
  public IStageRecordPresenter A()
  {
    return this.R;
  }
  
  public void B()
  {
    super.B();
    this.R.c();
  }
  
  public void C()
  {
    super.C();
    this.R.d();
  }
  
  public void D()
  {
    super.D();
    this.R.k();
  }
  
  public void a(IStagePresenter paramIStagePresenter)
  {
    this.R.a(paramIStagePresenter);
  }
  
  public void a(String paramString)
  {
    super.a(paramString);
    if (this.Q) {
      return;
    }
    ReportController.b(null, "dc00898", "", "", "0X800B0F6", "0X800B0F6", 0, 0, "", "", "", "");
    this.R.a(paramString);
  }
  
  public void a(List<MemberVideoDisplayInfo> paramList)
  {
    if (paramList != null)
    {
      if (paramList.isEmpty()) {
        return;
      }
      synchronized (this.I)
      {
        this.I.clear();
        this.I.addAll(paramList);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onMemberVideoDisplayInfoUpdate infoList:=");
        localStringBuilder.append(Arrays.toString(paramList.toArray()));
        AVLog.d("AVGameBusinessVideoLayer", localStringBuilder.toString());
        AVGameHandler.a().c().post(new AVGameBusinessVideoLayer.1(this));
        return;
      }
    }
  }
  
  public void b(String paramString)
  {
    super.b(paramString);
    if (this.Q) {
      return;
    }
    this.R.b(paramString);
  }
  
  protected void f(GLCanvas paramGLCanvas)
  {
    if (this.R.i())
    {
      this.R.a(paramGLCanvas);
      return;
    }
    GLES20.glBindFramebuffer(36160, 0);
    GLES20.glViewport(0, 0, paramGLCanvas.b(), paramGLCanvas.c());
    super.f(paramGLCanvas);
    this.R.j();
  }
  
  public void g(GLCanvas paramGLCanvas)
  {
    super.f(paramGLCanvas);
  }
  
  public void z()
  {
    super.z();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gameroom.video.AVGameBusinessVideoLayer
 * JD-Core Version:    0.7.0.1
 */