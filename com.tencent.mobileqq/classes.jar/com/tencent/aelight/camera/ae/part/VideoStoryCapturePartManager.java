package com.tencent.aelight.camera.ae.part;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.ViewStub;
import com.tencent.aelight.camera.ae.AEBaseCameraUnit;
import com.tencent.aelight.camera.ae.AECameraConfig;
import com.tencent.aelight.camera.ae.camera.ui.VideoStoryPiecesPart;
import com.tencent.aelight.camera.ae.camera.ui.aiscene.VideoStoryAIScenePart;
import com.tencent.aelight.camera.ae.camera.ui.bottom.AEBottomListPart;
import com.tencent.aelight.camera.ae.camera.ui.bottom.AECircleBottomListPart;
import com.tencent.aelight.camera.ae.camera.ui.capture.VideoStoryCapturePart;
import com.tencent.aelight.camera.ae.camera.ui.dashboard.AEDashboardUtil;
import com.tencent.aelight.camera.ae.camera.ui.dashboard.AEVideoStoryDashboardPart;
import com.tencent.aelight.camera.ae.camera.ui.flashshow.AEFlashShowBottomPart;
import com.tencent.aelight.camera.ae.camera.ui.flashshow.AEFlashShowMusicPart;
import com.tencent.aelight.camera.ae.camera.ui.flashshow.AEFlashShowRightBarPart;
import com.tencent.aelight.camera.ae.camera.ui.gallery.AECaptureCustomMaterialPart;
import com.tencent.aelight.camera.ae.camera.ui.panel.AEBottomPanelPart;
import com.tencent.aelight.camera.ae.camera.ui.topbar.AEAIONewTopBarPart;
import com.tencent.aelight.camera.ae.camera.ui.topbar.AETopRightBarPart;
import com.tencent.aelight.camera.ae.camera.ui.topbar.AEVideoStoryTopBarPart;
import com.tencent.aelight.camera.ae.camera.ui.watermark.AEWaterMarkEditorPart;
import com.tencent.aelight.camera.ae.data.AEMaterialManager;
import com.tencent.aelight.camera.ae.entry.AECameraEntryManager;
import com.tencent.aelight.camera.ae.gif.AEGIFStickerListPart;
import com.tencent.aelight.camera.ae.mode.AEVideoStoryCaptureModePart;
import com.tencent.aelight.camera.ae.play.AEPlayShowPart;
import com.tencent.aelight.camera.ae.util.AECameraPrefsUtil;
import com.tencent.aelight.camera.entry.api.AECameraEntry;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

@SuppressLint({"UseSparseArrays"})
public class VideoStoryCapturePartManager
{
  private Activity a;
  private AEBaseCameraUnit b;
  private View c;
  private Map<Integer, VideoStoryBasePart> d = new HashMap();
  private Set<Integer> e;
  private volatile boolean f = false;
  
  public VideoStoryCapturePartManager(Activity paramActivity, View paramView, AEBaseCameraUnit paramAEBaseCameraUnit)
  {
    this.a = paramActivity;
    this.c = paramView;
    this.b = paramAEBaseCameraUnit;
    this.e = g();
  }
  
  private <T> T c(int paramInt, Object... paramVarArgs)
  {
    if (paramInt != 65537) {
      return null;
    }
    return this.b;
  }
  
  private void c(int paramInt)
  {
    Object localObject;
    switch (paramInt)
    {
    default: 
      localObject = null;
      break;
    case 1048576: 
      localObject = new AEFlashShowMusicPart(this.a, this.c, this);
      break;
    case 983041: 
      localObject = new AEBottomPanelPart(this.a, this.c, this);
      break;
    case 983040: 
      localObject = new AEFlashShowBottomPart(this.a, this.c, this);
      break;
    case 917506: 
      localObject = new AEAIONewTopBarPart(this.a, this.c, this);
      break;
    case 917505: 
      localObject = new AETopRightBarPart(this.a, this.c, this);
      break;
    case 917504: 
      localObject = new AEFlashShowRightBarPart(this.a, this.c, this);
      break;
    case 851968: 
      localObject = new AECaptureCustomMaterialPart(this.a, this.c, this);
      break;
    case 786432: 
      localObject = new AECircleBottomListPart(this.a, this.c, this);
      break;
    case 720896: 
      localObject = new AEVideoStoryDashboardPart(this.a, this.c, this);
      break;
    case 655360: 
      localObject = new AEPlayShowPart(this.a, (ViewStub)this.c.findViewById(2063990849), this);
      break;
    case 589824: 
      localObject = new AEWaterMarkEditorPart(this.a, this.c, this);
      break;
    case 524288: 
      localObject = new AEGIFStickerListPart(this.a, this.c, this);
      break;
    case 458752: 
      localObject = new AEVideoStoryTopBarPart(this.a, this.c, this);
      break;
    case 393216: 
      localObject = new AEVideoStoryCaptureModePart(this.a, this.c, this);
      break;
    case 327680: 
      localObject = new VideoStoryPiecesPart(this.a, this.c, this);
      break;
    case 262144: 
      localObject = new VideoStoryCapturePart(this.a, this.c, this);
      break;
    case 196608: 
      localObject = new VideoStoryAIScenePart(this.a, this.c, this);
      break;
    case 131072: 
      localObject = new AEBottomListPart(this.a, this.c, this);
    }
    if (localObject != null) {
      this.d.put(Integer.valueOf(paramInt), localObject);
    }
  }
  
  private int d(int paramInt)
  {
    if (paramInt >> 16 == 2) {
      return 786432;
    }
    return 65536;
  }
  
  private void d(int paramInt, Object... paramVarArgs) {}
  
  private int e(int paramInt)
  {
    Iterator localIterator = this.e.iterator();
    while (localIterator.hasNext())
    {
      Integer localInteger = (Integer)localIterator.next();
      if (paramInt >> 16 == localInteger.intValue() >> 16) {
        return localInteger.intValue();
      }
    }
    return 65536;
  }
  
  private Set<Integer> g()
  {
    return h();
  }
  
  private Set<Integer> h()
  {
    int i = this.b.u().u();
    HashSet localHashSet = new HashSet();
    boolean bool = AECameraEntry.L.b(i);
    Integer localInteger1 = Integer.valueOf(655360);
    Integer localInteger2 = Integer.valueOf(524288);
    Integer localInteger3 = Integer.valueOf(458752);
    Integer localInteger4 = Integer.valueOf(262144);
    if (bool)
    {
      localHashSet.add(Integer.valueOf(917504));
      localHashSet.add(localInteger4);
      localHashSet.add(Integer.valueOf(983040));
      localHashSet.add(Integer.valueOf(1048576));
    }
    else if (AECameraEntry.J.b(i))
    {
      localHashSet.add(localInteger3);
      localHashSet.add(localInteger4);
      localHashSet.add(Integer.valueOf(327680));
      localHashSet.add(Integer.valueOf(131072));
    }
    else if ((!AECameraEntry.c.b(i)) && (!AECameraEntry.t.b(i)) && (!AECameraEntry.n.b(i)) && (!AECameraEntry.e.b(i)) && (!AECameraEntryManager.c(i)))
    {
      if (AECameraEntry.e.b(i))
      {
        localHashSet.add(localInteger3);
        localHashSet.add(Integer.valueOf(131072));
        localHashSet.add(Integer.valueOf(196608));
        localHashSet.add(localInteger4);
        localHashSet.add(Integer.valueOf(327680));
        localHashSet.add(Integer.valueOf(393216));
        localHashSet.add(localInteger2);
        localHashSet.add(Integer.valueOf(589824));
        localHashSet.add(Integer.valueOf(917505));
      }
      else if ((!AECameraEntry.N.b(i)) && (!AECameraEntry.M.b(i)))
      {
        if (AECameraEntry.w.b(i))
        {
          localHashSet.add(localInteger3);
          localHashSet.add(localInteger4);
          localHashSet.add(Integer.valueOf(327680));
          localHashSet.add(localInteger2);
          localHashSet.add(Integer.valueOf(131072));
          localHashSet.add(Integer.valueOf(393216));
          localHashSet.add(Integer.valueOf(917505));
        }
        else if (AECameraEntry.I.b(i))
        {
          localHashSet.add(localInteger3);
          localHashSet.add(localInteger4);
          localHashSet.add(Integer.valueOf(327680));
          localHashSet.add(Integer.valueOf(131072));
          localHashSet.add(Integer.valueOf(393216));
          localHashSet.add(Integer.valueOf(917505));
        }
        else
        {
          localHashSet.add(localInteger3);
          localHashSet.add(Integer.valueOf(917505));
          if (AECameraEntryManager.g(i)) {
            localHashSet.add(Integer.valueOf(786432));
          } else {
            localHashSet.add(Integer.valueOf(131072));
          }
          localHashSet.add(Integer.valueOf(196608));
          localHashSet.add(localInteger4);
          localHashSet.add(Integer.valueOf(327680));
          localHashSet.add(Integer.valueOf(393216));
          localHashSet.add(localInteger2);
          localHashSet.add(Integer.valueOf(589824));
        }
      }
      else
      {
        localHashSet.add(localInteger3);
        localHashSet.add(Integer.valueOf(131072));
        localHashSet.add(localInteger4);
        localHashSet.add(Integer.valueOf(327680));
        localHashSet.add(Integer.valueOf(393216));
        localHashSet.add(Integer.valueOf(917505));
      }
    }
    else
    {
      localHashSet.add(localInteger3);
      localHashSet.add(Integer.valueOf(131072));
      localHashSet.add(Integer.valueOf(196608));
      localHashSet.add(localInteger4);
      localHashSet.add(Integer.valueOf(327680));
      localHashSet.add(Integer.valueOf(393216));
      localHashSet.add(localInteger2);
      localHashSet.add(Integer.valueOf(589824));
      localHashSet.add(localInteger1);
      localHashSet.add(Integer.valueOf(917505));
      if (AECameraEntry.e.b(i)) {
        localHashSet.add(Integer.valueOf(851968));
      }
    }
    if (AECameraEntryManager.a(this.b) == 204) {
      localHashSet.remove(localInteger2);
    }
    if (AECameraEntryManager.a(this.b) == 205) {
      localHashSet.remove(localInteger1);
    }
    if ((!AECameraEntryManager.g(i)) && (!AECameraEntry.L.b(i))) {
      localHashSet.add(Integer.valueOf(983041));
    }
    if ((AECameraEntryManager.a(this.b) == 207) || (AECameraEntryManager.a(this.b) == 205) || (AECameraEntryManager.a(this.b) == 201) || (AECameraEntryManager.a(this.b) == 203) || (AECameraEntryManager.a(this.b) == 202))
    {
      localHashSet.remove(localInteger3);
      localHashSet.add(Integer.valueOf(917506));
    }
    if (AEDashboardUtil.f())
    {
      bool = AECameraPrefsUtil.a().b("DEBUG_KEY_TEST_LAUNCH_SPEED_MODE", false, 4);
      if ((AEDashboardUtil.f()) && (!bool)) {
        localHashSet.add(Integer.valueOf(720896));
      }
    }
    return localHashSet;
  }
  
  private void i()
  {
    Iterator localIterator = this.e.iterator();
    while (localIterator.hasNext()) {
      c(((Integer)localIterator.next()).intValue());
    }
  }
  
  private void j()
  {
    Iterator localIterator = this.d.keySet().iterator();
    while (localIterator.hasNext())
    {
      Integer localInteger = (Integer)localIterator.next();
      ((VideoStoryBasePart)this.d.get(localInteger)).initView();
    }
  }
  
  public <T> T a(int paramInt, Object... paramVarArgs)
  {
    int i = e(paramInt);
    VideoStoryBasePart localVideoStoryBasePart = (VideoStoryBasePart)this.d.get(Integer.valueOf(i));
    if (localVideoStoryBasePart != null) {
      return localVideoStoryBasePart.get(paramInt, paramVarArgs);
    }
    return c(paramInt, paramVarArgs);
  }
  
  public void a()
  {
    try
    {
      if (!this.f)
      {
        i();
        j();
        this.f = true;
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    Iterator localIterator = this.d.keySet().iterator();
    while (localIterator.hasNext())
    {
      Integer localInteger = (Integer)localIterator.next();
      ((VideoStoryBasePart)this.d.get(localInteger)).onActivityResult(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public boolean a(int paramInt)
  {
    paramInt = e(paramInt);
    return (VideoStoryBasePart)this.d.get(Integer.valueOf(paramInt)) != null;
  }
  
  public AEMaterialManager b(int paramInt)
  {
    paramInt = e(paramInt);
    VideoStoryBasePart localVideoStoryBasePart = (VideoStoryBasePart)this.d.get(Integer.valueOf(paramInt));
    if ((localVideoStoryBasePart instanceof AEBottomListPart)) {
      return ((AEBottomListPart)localVideoStoryBasePart).j();
    }
    return null;
  }
  
  public void b()
  {
    Iterator localIterator = this.d.keySet().iterator();
    while (localIterator.hasNext())
    {
      Integer localInteger = (Integer)localIterator.next();
      ((VideoStoryBasePart)this.d.get(localInteger)).onActivityResume();
    }
  }
  
  public void b(int paramInt, Object... paramVarArgs)
  {
    int j = e(paramInt);
    int i = j;
    if (j == 65536) {
      i = d(paramInt);
    }
    VideoStoryBasePart localVideoStoryBasePart = (VideoStoryBasePart)this.d.get(Integer.valueOf(i));
    if (localVideoStoryBasePart != null)
    {
      localVideoStoryBasePart.send(paramInt, paramVarArgs);
      return;
    }
    d(paramInt, paramVarArgs);
  }
  
  public void c()
  {
    Iterator localIterator = this.d.keySet().iterator();
    while (localIterator.hasNext())
    {
      Integer localInteger = (Integer)localIterator.next();
      ((VideoStoryBasePart)this.d.get(localInteger)).onActivityPause();
    }
  }
  
  public void d()
  {
    Iterator localIterator = this.d.keySet().iterator();
    while (localIterator.hasNext())
    {
      Integer localInteger = (Integer)localIterator.next();
      ((VideoStoryBasePart)this.d.get(localInteger)).onActivityStart();
    }
  }
  
  public void e()
  {
    Iterator localIterator = this.d.keySet().iterator();
    while (localIterator.hasNext())
    {
      Integer localInteger = (Integer)localIterator.next();
      ((VideoStoryBasePart)this.d.get(localInteger)).onActivityStop();
    }
  }
  
  public void f()
  {
    Iterator localIterator = this.d.keySet().iterator();
    while (localIterator.hasNext())
    {
      Integer localInteger = (Integer)localIterator.next();
      ((VideoStoryBasePart)this.d.get(localInteger)).onDestroy();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.part.VideoStoryCapturePartManager
 * JD-Core Version:    0.7.0.1
 */