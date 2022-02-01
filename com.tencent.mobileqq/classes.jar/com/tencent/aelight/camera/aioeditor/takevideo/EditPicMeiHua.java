package com.tencent.aelight.camera.aioeditor.takevideo;

import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import com.tencent.aelight.camera.aioeditor.activity.richmedia.VideoFilterTools;
import com.tencent.aelight.camera.aioeditor.capture.view.ProviderContainerView;
import com.tencent.aelight.camera.aioeditor.capture.view.ProviderContainerView.ProviderContainViewListener;
import com.tencent.aelight.camera.aioeditor.capture.view.QIMFilterProviderView;
import com.tencent.aelight.camera.aioeditor.takevideo.publish.GenerateContext;
import com.tencent.aelight.camera.aioeditor.takevideo.publish.GeneratePicArgs;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.editor.params.EditVideoParams;
import com.tencent.mobileqq.shortvideo.EditActivityEntranceUtil;
import java.util.ArrayList;
import java.util.List;
import mqq.os.MqqHandler;

public class EditPicMeiHua
  extends EditVideoPart
  implements ProviderContainerView.ProviderContainViewListener
{
  private static List<Integer> b = new ArrayList();
  private ProviderContainerView a;
  
  public EditPicMeiHua(@NonNull EditVideoPartManager paramEditVideoPartManager)
  {
    super(paramEditVideoPartManager);
  }
  
  public static void a(int paramInt)
  {
    try
    {
      if (b.isEmpty())
      {
        if (EditVideoPartManager.a(paramInt, 8)) {
          b.add(Integer.valueOf(101));
        }
        if ((EditVideoPartManager.a(paramInt, 64)) && (Build.VERSION.SDK_INT >= 21)) {
          b.add(Integer.valueOf(100));
        }
        if (EditVideoPartManager.a(paramInt, 2048)) {
          b.add(Integer.valueOf(102));
        }
      }
      return;
    }
    finally {}
  }
  
  public static boolean b(int paramInt)
  {
    a(paramInt);
    return (EditVideoPartManager.a(paramInt, 65536)) && (!b.isEmpty());
  }
  
  public void a()
  {
    super.a();
    this.a = ((ProviderContainerView)d(2063991331));
    if (b.isEmpty()) {
      a(this.t.I.c);
    }
    this.a.a(c(), b);
    this.a.setProviderContainViewListener(this);
    this.a.setEditActivityEntrance(this.t.I.j());
  }
  
  public void a(int paramInt, @NonNull GenerateContext paramGenerateContext)
  {
    super.a(paramInt, paramGenerateContext);
    if ((QIMFilterProviderView)this.a.a(QIMFilterProviderView.class) != null)
    {
      boolean bool;
      if (VideoFilterTools.a().b(c()) != null) {
        bool = true;
      } else {
        bool = false;
      }
      paramGenerateContext.h = bool;
      if ((paramGenerateContext.h) && (this.t.j()))
      {
        paramGenerateContext = paramGenerateContext.l;
        paramGenerateContext.f += 1;
      }
    }
  }
  
  public void a(int paramInt, Object paramObject)
  {
    if (paramInt != 10)
    {
      if (paramInt != 21)
      {
        if (paramInt != 22) {
          this.a.setVisibility(4);
        }
      }
      else
      {
        this.a.setVisibility(0);
        this.a.a(0);
        if (this.t.j())
        {
          EditActivityEntranceUtil.a("0X800B3CB", this.t.I.j());
          EditActivityEntranceUtil.a("0X800B3CC", this.t.I.j());
          this.a.b(101);
        }
      }
    }
    else {
      ThreadManager.getUIHandler().post(new EditPicMeiHua.1(this));
    }
  }
  
  public void b()
  {
    this.t.a(10, Boolean.valueOf(true));
  }
  
  public int c()
  {
    if (this.t.k()) {
      return 3;
    }
    return 1;
  }
  
  public void g()
  {
    super.g();
    this.a.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.EditPicMeiHua
 * JD-Core Version:    0.7.0.1
 */