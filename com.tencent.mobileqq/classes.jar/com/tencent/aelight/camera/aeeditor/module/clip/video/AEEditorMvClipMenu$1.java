package com.tencent.aelight.camera.aeeditor.module.clip.video;

import com.tencent.qcircle.tavcut.timeline.SliderChangeListener;
import com.tencent.qcircle.tavcut.util.Logger;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tav.player.IPlayer.PlayerStatus;

class AEEditorMvClipMenu$1
  implements SliderChangeListener
{
  private boolean b = true;
  
  AEEditorMvClipMenu$1(AEEditorMvClipMenu paramAEEditorMvClipMenu) {}
  
  public void onIndicatorMove(float paramFloat) {}
  
  public void onIndicatorMove(long paramLong)
  {
    CMTime.convertTimeScale(CMTime.fromMs(paramLong), 1000);
  }
  
  public void onIndicatorPress()
  {
    AEEditorMvClipMenu localAEEditorMvClipMenu = this.a;
    AEEditorMvClipMenu.a(localAEEditorMvClipMenu, AEEditorMvClipMenu.b(localAEEditorMvClipMenu));
    AEEditorMvClipMenu.a(this.a, false);
    AEEditorMvClipMenu.b(this.a, true);
  }
  
  public void onIndicatorRelease()
  {
    AEEditorMvClipMenu localAEEditorMvClipMenu = this.a;
    boolean bool;
    if ((AEEditorMvClipMenu.a(localAEEditorMvClipMenu) != IPlayer.PlayerStatus.PLAYING) && (AEEditorMvClipMenu.a(this.a) != IPlayer.PlayerStatus.REPLAY)) {
      bool = false;
    } else {
      bool = true;
    }
    AEEditorMvClipMenu.a(localAEEditorMvClipMenu, bool);
    AEEditorMvClipMenu.a(this.a, null);
    AEEditorMvClipMenu.b(this.a, false);
  }
  
  public void onSelectionChange(long paramLong1, long paramLong2, boolean paramBoolean)
  {
    Object localObject1 = CMTime.convertTimeScale(CMTime.fromMs(paramLong1), 1000);
    CMTime localCMTime = CMTime.convertTimeScale(CMTime.fromMs(paramLong2), 1000);
    Object localObject2 = localCMTime.sub((CMTime)localObject1);
    boolean bool = true;
    if (!paramBoolean)
    {
      if (AEEditorMvClipMenu.a(this.a) == null)
      {
        localObject3 = this.a;
        AEEditorMvClipMenu.a((AEEditorMvClipMenu)localObject3, AEEditorMvClipMenu.b((AEEditorMvClipMenu)localObject3));
      }
      AEEditorMvClipMenu.a(this.a, false);
      AEEditorMvClipMenu.b(this.a, true);
    }
    Object localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append("onSelectionChange: seek ");
    ((StringBuilder)localObject3).append(this.b);
    ((StringBuilder)localObject3).append(localCMTime.getTimeSeconds());
    Logger.i("VideoDemoSlider", ((StringBuilder)localObject3).toString());
    AEEditorMvClipMenu.a(this.a, new CMTimeRange((CMTime)localObject1, (CMTime)localObject2));
    localObject2 = this.a;
    if (!this.b) {
      localObject1 = localCMTime;
    }
    AEEditorMvClipMenu.a((AEEditorMvClipMenu)localObject2, (CMTime)localObject1);
    if (paramBoolean)
    {
      AEEditorMvClipMenu.b(this.a, false);
      localObject1 = this.a;
      paramBoolean = bool;
      if (AEEditorMvClipMenu.a((AEEditorMvClipMenu)localObject1) != IPlayer.PlayerStatus.PLAYING) {
        if (AEEditorMvClipMenu.a(this.a) == IPlayer.PlayerStatus.REPLAY) {
          paramBoolean = bool;
        } else {
          paramBoolean = false;
        }
      }
      AEEditorMvClipMenu.a((AEEditorMvClipMenu)localObject1, paramBoolean);
      AEEditorMvClipMenu.a(this.a, null);
    }
  }
  
  public void onSliderBarMove(boolean paramBoolean, float paramFloat1, float paramFloat2)
  {
    this.b = paramBoolean;
  }
  
  public void onSliderBarRelease(boolean paramBoolean)
  {
    AEEditorMvClipMenu localAEEditorMvClipMenu = this.a;
    if ((AEEditorMvClipMenu.a(localAEEditorMvClipMenu) != IPlayer.PlayerStatus.PLAYING) && (AEEditorMvClipMenu.a(this.a) != IPlayer.PlayerStatus.REPLAY)) {
      paramBoolean = false;
    } else {
      paramBoolean = true;
    }
    AEEditorMvClipMenu.a(localAEEditorMvClipMenu, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.module.clip.video.AEEditorMvClipMenu.1
 * JD-Core Version:    0.7.0.1
 */