package com.tencent.aelight.camera.aioeditor.capture.control;

import com.tencent.aelight.camera.aioeditor.capture.QIMManager;
import com.tencent.aelight.camera.aioeditor.capture.music.QIMMusicConfigManager;
import com.tencent.aelight.camera.struct.editor.FlowMusic;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.app.automator.ParallGroup;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityTransaction;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class UpdateAllFullMusicInfoTask
  extends ParallGroup
{
  private QIMMusicConfigManager f = (QIMMusicConfigManager)QIMManager.a(2);
  private ArrayList<FlowMusic> g;
  private ArrayList<FlowMusic> h = new ArrayList();
  private List<FlowMusic> i = new ArrayList();
  
  private void b()
  {
    Object localObject = this.f.d.query(FlowMusic.class);
    int j;
    if ((localObject != null) && (!((List)localObject).isEmpty()))
    {
      this.g = new ArrayList((Collection)localObject);
      j = this.g.size();
    }
    else
    {
      j = 0;
    }
    localObject = this.g;
    if (localObject != null)
    {
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        FlowMusic localFlowMusic = (FlowMusic)((Iterator)localObject).next();
        if (localFlowMusic.albumUrl == null) {
          this.i.add(localFlowMusic);
        }
      }
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("load db, has load local, size=");
      ((StringBuilder)localObject).append(j);
      QLog.d("UpdateAllFullMusicInfoTask", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  private void c()
  {
    if (!this.h.isEmpty())
    {
      localObject1 = this.f.d.getTransaction();
      try
      {
        ((EntityTransaction)localObject1).begin();
        Iterator localIterator = this.h.iterator();
        while (localIterator.hasNext())
        {
          FlowMusic localFlowMusic = (FlowMusic)localIterator.next();
          this.f.d.update(localFlowMusic);
        }
        ((EntityTransaction)localObject1).commit();
      }
      finally
      {
        ((EntityTransaction)localObject1).end();
      }
    }
    Object localObject1 = this.g;
    if (localObject1 != null) {
      this.f.a(4, true, localObject1);
    }
  }
  
  public void a(AsyncStep paramAsyncStep, int paramInt)
  {
    try
    {
      if ((paramAsyncStep instanceof GetSingleFullMusicInfoTask))
      {
        FlowMusic localFlowMusic = ((GetSingleFullMusicInfoTask)paramAsyncStep).a;
        if ((localFlowMusic != null) && (((GetSingleFullMusicInfoTask)paramAsyncStep).b != null))
        {
          localFlowMusic.albumUrl = ((GetSingleFullMusicInfoTask)paramAsyncStep).b.albumUrl;
          localFlowMusic.url = ((GetSingleFullMusicInfoTask)paramAsyncStep).b.url;
          localFlowMusic.size = ((GetSingleFullMusicInfoTask)paramAsyncStep).b.size;
          localFlowMusic.playable = ((GetSingleFullMusicInfoTask)paramAsyncStep).b.playable;
          this.h.add(localFlowMusic);
        }
      }
      paramInt = this.a - 1;
      this.a = paramInt;
      if (paramInt == 0)
      {
        c();
        setResult(7);
        this.b = null;
      }
      this.mAutomator.a(this.b);
      return;
    }
    finally {}
  }
  
  protected int doStep()
  {
    this.a = this.i.size();
    if (!this.i.isEmpty())
    {
      Iterator localIterator = this.i.iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (FlowMusic)localIterator.next();
        if (this.mResult == 8) {
          break;
        }
        localObject = new GetSingleFullMusicInfoTask((FlowMusic)localObject, null);
        ((AsyncStep)localObject).mResultListener = this;
        this.mAutomator.b((AsyncStep)localObject);
      }
      return 2;
    }
    c();
    return 7;
  }
  
  public void onCreate()
  {
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.capture.control.UpdateAllFullMusicInfoTask
 * JD-Core Version:    0.7.0.1
 */