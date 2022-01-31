import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tav.player.IPlayer.PlayerStatus;
import com.tencent.tavcut.timeline.SliderChangeListener;
import com.tencent.tavcut.util.Logger;
import dov.com.qq.im.aeeditor.module.clip.video.AEEditorMvClipMenu;

public class blmc
  implements SliderChangeListener
{
  private boolean jdField_a_of_type_Boolean;
  
  public blmc(AEEditorMvClipMenu paramAEEditorMvClipMenu) {}
  
  public void onIndicatorMove(float paramFloat) {}
  
  public void onIndicatorMove(long paramLong)
  {
    CMTime.convertTimeScale(CMTime.fromMs(paramLong), 1000);
  }
  
  public void onIndicatorPress()
  {
    AEEditorMvClipMenu.a(this.jdField_a_of_type_DovComQqImAeeditorModuleClipVideoAEEditorMvClipMenu, AEEditorMvClipMenu.b(this.jdField_a_of_type_DovComQqImAeeditorModuleClipVideoAEEditorMvClipMenu));
    AEEditorMvClipMenu.a(this.jdField_a_of_type_DovComQqImAeeditorModuleClipVideoAEEditorMvClipMenu, false);
    AEEditorMvClipMenu.b(this.jdField_a_of_type_DovComQqImAeeditorModuleClipVideoAEEditorMvClipMenu, true);
  }
  
  public void onIndicatorRelease()
  {
    AEEditorMvClipMenu localAEEditorMvClipMenu = this.jdField_a_of_type_DovComQqImAeeditorModuleClipVideoAEEditorMvClipMenu;
    if (AEEditorMvClipMenu.a(this.jdField_a_of_type_DovComQqImAeeditorModuleClipVideoAEEditorMvClipMenu) == IPlayer.PlayerStatus.PLAYING) {}
    for (boolean bool = true;; bool = false)
    {
      AEEditorMvClipMenu.a(localAEEditorMvClipMenu, bool);
      AEEditorMvClipMenu.a(this.jdField_a_of_type_DovComQqImAeeditorModuleClipVideoAEEditorMvClipMenu, null);
      AEEditorMvClipMenu.b(this.jdField_a_of_type_DovComQqImAeeditorModuleClipVideoAEEditorMvClipMenu, false);
      return;
    }
  }
  
  public void onSelectionChange(long paramLong1, long paramLong2, boolean paramBoolean)
  {
    Object localObject1 = CMTime.convertTimeScale(CMTime.fromMs(paramLong1), 1000);
    CMTime localCMTime = CMTime.convertTimeScale(CMTime.fromMs(paramLong2), 1000);
    Object localObject2 = localCMTime.sub((CMTime)localObject1);
    if (!paramBoolean)
    {
      if (AEEditorMvClipMenu.a(this.jdField_a_of_type_DovComQqImAeeditorModuleClipVideoAEEditorMvClipMenu) == null) {
        AEEditorMvClipMenu.a(this.jdField_a_of_type_DovComQqImAeeditorModuleClipVideoAEEditorMvClipMenu, AEEditorMvClipMenu.b(this.jdField_a_of_type_DovComQqImAeeditorModuleClipVideoAEEditorMvClipMenu));
      }
      AEEditorMvClipMenu.a(this.jdField_a_of_type_DovComQqImAeeditorModuleClipVideoAEEditorMvClipMenu, false);
      AEEditorMvClipMenu.b(this.jdField_a_of_type_DovComQqImAeeditorModuleClipVideoAEEditorMvClipMenu, true);
    }
    Logger.i("VideoDemoSlider", "onSelectionChange: seek " + this.jdField_a_of_type_Boolean + localCMTime.getTimeSeconds());
    AEEditorMvClipMenu.a(this.jdField_a_of_type_DovComQqImAeeditorModuleClipVideoAEEditorMvClipMenu, new CMTimeRange((CMTime)localObject1, (CMTime)localObject2));
    localObject2 = this.jdField_a_of_type_DovComQqImAeeditorModuleClipVideoAEEditorMvClipMenu;
    if (this.jdField_a_of_type_Boolean)
    {
      AEEditorMvClipMenu.a((AEEditorMvClipMenu)localObject2, (CMTime)localObject1);
      if (paramBoolean)
      {
        AEEditorMvClipMenu.b(this.jdField_a_of_type_DovComQqImAeeditorModuleClipVideoAEEditorMvClipMenu, false);
        localObject1 = this.jdField_a_of_type_DovComQqImAeeditorModuleClipVideoAEEditorMvClipMenu;
        if (AEEditorMvClipMenu.a(this.jdField_a_of_type_DovComQqImAeeditorModuleClipVideoAEEditorMvClipMenu) != IPlayer.PlayerStatus.PLAYING) {
          break label211;
        }
      }
    }
    label211:
    for (paramBoolean = true;; paramBoolean = false)
    {
      AEEditorMvClipMenu.a((AEEditorMvClipMenu)localObject1, paramBoolean);
      AEEditorMvClipMenu.a(this.jdField_a_of_type_DovComQqImAeeditorModuleClipVideoAEEditorMvClipMenu, null);
      return;
      localObject1 = localCMTime;
      break;
    }
  }
  
  public void onSliderBarMove(boolean paramBoolean, float paramFloat1, float paramFloat2)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void onSliderBarRelease(boolean paramBoolean)
  {
    AEEditorMvClipMenu localAEEditorMvClipMenu = this.jdField_a_of_type_DovComQqImAeeditorModuleClipVideoAEEditorMvClipMenu;
    if (AEEditorMvClipMenu.a(this.jdField_a_of_type_DovComQqImAeeditorModuleClipVideoAEEditorMvClipMenu) == IPlayer.PlayerStatus.PLAYING) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      AEEditorMvClipMenu.a(localAEEditorMvClipMenu, paramBoolean);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blmc
 * JD-Core Version:    0.7.0.1
 */