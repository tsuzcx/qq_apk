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
  private GameVideoRecordPresenterWrapper a = new GameVideoRecordPresenterWrapper(paramContext, this);
  
  public AVGameBusinessVideoLayer(Context paramContext, AVGameAppInterface paramAVGameAppInterface)
  {
    super(paramContext, paramAVGameAppInterface);
  }
  
  private boolean a(long paramLong)
  {
    Iterator localIterator = this.b.iterator();
    for (boolean bool = false; localIterator.hasNext(); bool = true)
    {
      label13:
      MemberVideoDisplayInfo localMemberVideoDisplayInfo = (MemberVideoDisplayInfo)localIterator.next();
      if ((localMemberVideoDisplayInfo.jdField_a_of_type_Long != paramLong) || (localMemberVideoDisplayInfo.jdField_a_of_type_Boolean)) {
        break label13;
      }
    }
    return bool;
  }
  
  public IStageRecordPresenter a()
  {
    return this.a;
  }
  
  public void a(IStagePresenter paramIStagePresenter)
  {
    this.a.a(paramIStagePresenter);
  }
  
  public void a(String paramString)
  {
    super.a(paramString);
    if (this.c) {
      return;
    }
    ReportController.b(null, "dc00898", "", "", "0X800B0F6", "0X800B0F6", 0, 0, "", "", "", "");
    this.a.a(paramString);
  }
  
  public void a(List<MemberVideoDisplayInfo> paramList)
  {
    if (paramList != null)
    {
      if (paramList.isEmpty()) {
        return;
      }
      synchronized (this.b)
      {
        this.b.clear();
        this.b.addAll(paramList);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onMemberVideoDisplayInfoUpdate infoList:=");
        localStringBuilder.append(Arrays.toString(paramList.toArray()));
        AVLog.d("AVGameBusinessVideoLayer", localStringBuilder.toString());
        AVGameHandler.a().b().post(new AVGameBusinessVideoLayer.1(this));
        return;
      }
    }
  }
  
  public void b(String paramString)
  {
    super.b(paramString);
    if (this.c) {
      return;
    }
    this.a.b(paramString);
  }
  
  protected void f(GLCanvas paramGLCanvas)
  {
    if (this.a.a())
    {
      this.a.a(paramGLCanvas);
      return;
    }
    GLES20.glBindFramebuffer(36160, 0);
    GLES20.glViewport(0, 0, paramGLCanvas.a(), paramGLCanvas.b());
    super.f(paramGLCanvas);
    this.a.g();
  }
  
  public void g(GLCanvas paramGLCanvas)
  {
    super.f(paramGLCanvas);
  }
  
  public void l()
  {
    super.l();
  }
  
  public void m()
  {
    super.m();
    this.a.c();
  }
  
  public void n()
  {
    super.n();
    this.a.d();
  }
  
  public void o()
  {
    super.o();
    this.a.h();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gameroom.video.AVGameBusinessVideoLayer
 * JD-Core Version:    0.7.0.1
 */