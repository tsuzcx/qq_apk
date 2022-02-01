package com.tencent.aelight.camera.aeeditor.module.controlpanel;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.aelight.camera.aeeditor.module.music.AEEditorLyricPanelDialog;
import com.tencent.aelight.camera.aeeditor.module.music.AEEditorLyricPanelDialog.OperationCallback;
import com.tencent.aelight.camera.aeeditor.module.music.AEEditorMusicAdapter.AEEditorMusicInfo;
import com.tencent.aelight.camera.aeeditor.module.music.AEEditorMusicPanel;
import com.tencent.aelight.camera.aeeditor.module.music.AEEditorMusicPanel.OperationCallback;
import com.tencent.aelight.camera.aeeditor.module.music.AEEditorMusicVolumePanelDialog;
import com.tencent.aelight.camera.aeeditor.module.music.AEEditorMusicVolumePanelDialog.OperationCallback;
import com.tencent.mobileqq.utils.ViewUtils;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/aelight/camera/aeeditor/module/controlpanel/AEEditorMusicControlPanel;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "lyricPanelDialog", "Lcom/tencent/aelight/camera/aeeditor/module/music/AEEditorLyricPanelDialog;", "musicPanel", "Lcom/tencent/aelight/camera/aeeditor/module/music/AEEditorMusicPanel;", "musicVolumePanelDialog", "Lcom/tencent/aelight/camera/aeeditor/module/music/AEEditorMusicVolumePanelDialog;", "musicWaveViewHeight", "musicWaveViewWidth", "clearMusicListViewCache", "", "getBackgroundMusicData", "", "Lcom/tencent/aelight/camera/aeeditor/module/music/AEEditorMusicAdapter$AEEditorMusicInfo;", "hide", "hideMusicListPanel", "hideMusicLyricPanel", "hideMusicVolumePanel", "onBgmVolumeChanged", "volume", "", "onCurrentMusicDownloadFailed", "onOriginSoundSwitch", "isOn", "", "onOriginVolumeChanged", "onReceiveMusicFromWeb", "musicInfoFromWeb", "scrollToMusicListPosition", "position", "setAutoTemplateMode", "isAutoTemplateOn", "hasBgm", "setBgmPlayed", "bgmPlayed", "currentMusic", "setMusicListOperationCallback", "callback", "Lcom/tencent/aelight/camera/aeeditor/module/music/AEEditorMusicPanel$OperationCallback;", "setMusicLyricOperationCallback", "Lcom/tencent/aelight/camera/aeeditor/module/music/AEEditorLyricPanelDialog$OperationCallback;", "setMusicVolumeOperationCallback", "Lcom/tencent/aelight/camera/aeeditor/module/music/AEEditorMusicVolumePanelDialog$OperationCallback;", "setOriginSoundOn", "soundOn", "showMusicListPanel", "showMusicLyricPanel", "editorMusicInfo", "savedMusicStartTimeInMs", "videoClipDurationInMs", "forceRefreshWaveView", "(Lcom/tencent/aelight/camera/aeeditor/module/music/AEEditorMusicAdapter$AEEditorMusicInfo;Ljava/lang/Integer;IZ)V", "showMusicVolumePanel", "switchMusicLyric", "updateBackgroundMusicData", "musicInfoList", "updateMusicLyricProgress", "videoClipProgressInMs", "updateMusicLyricRangeText", "startTimeInMs", "endTimeInMs", "updateMusicLyricTrimBoxPosition", "musicProgressInMs", "aelight_impl_release"}, k=1, mv={1, 1, 16})
public final class AEEditorMusicControlPanel
  extends FrameLayout
{
  private int jdField_a_of_type_Int = ViewUtils.a();
  private AEEditorLyricPanelDialog jdField_a_of_type_ComTencentAelightCameraAeeditorModuleMusicAEEditorLyricPanelDialog;
  private AEEditorMusicPanel jdField_a_of_type_ComTencentAelightCameraAeeditorModuleMusicAEEditorMusicPanel;
  private AEEditorMusicVolumePanelDialog jdField_a_of_type_ComTencentAelightCameraAeeditorModuleMusicAEEditorMusicVolumePanelDialog;
  private int b;
  
  public AEEditorMusicControlPanel(@NotNull Context paramContext)
  {
    super(paramContext);
    paramContext = getContext();
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "context");
    this.b = paramContext.getResources().getDimensionPixelSize(2063990875);
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleMusicAEEditorMusicPanel = new AEEditorMusicPanel(getContext());
    addView((View)this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleMusicAEEditorMusicPanel, (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -1));
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleMusicAEEditorLyricPanelDialog = new AEEditorLyricPanelDialog(getContext());
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleMusicAEEditorMusicVolumePanelDialog = new AEEditorMusicVolumePanelDialog(getContext());
  }
  
  public AEEditorMusicControlPanel(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = getContext();
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "context");
    this.b = paramContext.getResources().getDimensionPixelSize(2063990875);
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleMusicAEEditorMusicPanel = new AEEditorMusicPanel(getContext());
    addView((View)this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleMusicAEEditorMusicPanel, (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -1));
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleMusicAEEditorLyricPanelDialog = new AEEditorLyricPanelDialog(getContext());
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleMusicAEEditorMusicVolumePanelDialog = new AEEditorMusicVolumePanelDialog(getContext());
  }
  
  public AEEditorMusicControlPanel(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramContext = getContext();
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "context");
    this.b = paramContext.getResources().getDimensionPixelSize(2063990875);
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleMusicAEEditorMusicPanel = new AEEditorMusicPanel(getContext());
    addView((View)this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleMusicAEEditorMusicPanel, (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -1));
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleMusicAEEditorLyricPanelDialog = new AEEditorLyricPanelDialog(getContext());
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleMusicAEEditorMusicVolumePanelDialog = new AEEditorMusicVolumePanelDialog(getContext());
  }
  
  @NotNull
  public final List<AEEditorMusicAdapter.AEEditorMusicInfo> a()
  {
    Object localObject = this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleMusicAEEditorMusicPanel;
    if (localObject != null)
    {
      localObject = ((AEEditorMusicPanel)localObject).a();
      if (localObject != null) {
        return localObject;
      }
    }
    return (List)new LinkedList();
  }
  
  public final void a()
  {
    AEEditorMusicPanel localAEEditorMusicPanel = this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleMusicAEEditorMusicPanel;
    if (localAEEditorMusicPanel != null) {
      localAEEditorMusicPanel.a();
    }
  }
  
  public final void a(float paramFloat)
  {
    AEEditorMusicPanel localAEEditorMusicPanel = this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleMusicAEEditorMusicPanel;
    if (localAEEditorMusicPanel != null) {
      localAEEditorMusicPanel.a(paramFloat);
    }
  }
  
  public final void a(int paramInt)
  {
    AEEditorMusicPanel localAEEditorMusicPanel = this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleMusicAEEditorMusicPanel;
    if (localAEEditorMusicPanel != null) {
      localAEEditorMusicPanel.a(paramInt);
    }
  }
  
  public final void a(int paramInt1, int paramInt2)
  {
    AEEditorLyricPanelDialog localAEEditorLyricPanelDialog = this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleMusicAEEditorLyricPanelDialog;
    if (localAEEditorLyricPanelDialog != null) {
      localAEEditorLyricPanelDialog.c(paramInt1, paramInt2);
    }
  }
  
  public final void a(@NotNull AEEditorMusicAdapter.AEEditorMusicInfo paramAEEditorMusicInfo)
  {
    Intrinsics.checkParameterIsNotNull(paramAEEditorMusicInfo, "musicInfoFromWeb");
    AEEditorMusicPanel localAEEditorMusicPanel = this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleMusicAEEditorMusicPanel;
    if (localAEEditorMusicPanel != null) {
      localAEEditorMusicPanel.a(paramAEEditorMusicInfo);
    }
  }
  
  public final void a(@NotNull AEEditorMusicAdapter.AEEditorMusicInfo paramAEEditorMusicInfo, @Nullable Integer paramInteger, int paramInt, boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramAEEditorMusicInfo, "editorMusicInfo");
    AEEditorLyricPanelDialog localAEEditorLyricPanelDialog = this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleMusicAEEditorLyricPanelDialog;
    if ((localAEEditorLyricPanelDialog != null) && (!localAEEditorLyricPanelDialog.isShowing()))
    {
      int i;
      if (paramInteger != null) {
        i = paramInteger.intValue();
      } else {
        i = paramAEEditorMusicInfo.a();
      }
      paramInteger = this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleMusicAEEditorLyricPanelDialog;
      if (paramInteger != null) {
        paramInteger.a(paramAEEditorMusicInfo, i, paramInt, this.jdField_a_of_type_Int, this.b, paramBoolean);
      }
      a(i, paramInt + i);
      paramAEEditorMusicInfo = this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleMusicAEEditorLyricPanelDialog;
      if (paramAEEditorMusicInfo != null) {
        paramAEEditorMusicInfo.show();
      }
    }
  }
  
  public final void a(@NotNull List<? extends AEEditorMusicAdapter.AEEditorMusicInfo> paramList)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "musicInfoList");
    AEEditorMusicPanel localAEEditorMusicPanel = this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleMusicAEEditorMusicPanel;
    if (localAEEditorMusicPanel != null) {
      localAEEditorMusicPanel.a(paramList);
    }
  }
  
  public final void a(boolean paramBoolean)
  {
    AEEditorMusicVolumePanelDialog localAEEditorMusicVolumePanelDialog = this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleMusicAEEditorMusicVolumePanelDialog;
    if (localAEEditorMusicVolumePanelDialog != null) {
      localAEEditorMusicVolumePanelDialog.b(paramBoolean);
    }
  }
  
  public final void b()
  {
    AEEditorMusicPanel localAEEditorMusicPanel = this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleMusicAEEditorMusicPanel;
    if (localAEEditorMusicPanel != null) {
      localAEEditorMusicPanel.b();
    }
  }
  
  public final void b(float paramFloat)
  {
    AEEditorMusicPanel localAEEditorMusicPanel = this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleMusicAEEditorMusicPanel;
    if (localAEEditorMusicPanel != null) {
      localAEEditorMusicPanel.b(paramFloat);
    }
  }
  
  public final void b(int paramInt)
  {
    AEEditorLyricPanelDialog localAEEditorLyricPanelDialog = this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleMusicAEEditorLyricPanelDialog;
    if ((localAEEditorLyricPanelDialog != null) && (localAEEditorLyricPanelDialog.isShowing() == true))
    {
      localAEEditorLyricPanelDialog = this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleMusicAEEditorLyricPanelDialog;
      if (localAEEditorLyricPanelDialog != null) {
        localAEEditorLyricPanelDialog.b(paramInt);
      }
    }
  }
  
  public final void b(int paramInt1, int paramInt2)
  {
    AEEditorLyricPanelDialog localAEEditorLyricPanelDialog = this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleMusicAEEditorLyricPanelDialog;
    if ((localAEEditorLyricPanelDialog != null) && (localAEEditorLyricPanelDialog.isShowing() == true))
    {
      localAEEditorLyricPanelDialog = this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleMusicAEEditorLyricPanelDialog;
      if (localAEEditorLyricPanelDialog != null) {
        localAEEditorLyricPanelDialog.b(paramInt1, paramInt2);
      }
    }
  }
  
  public final void c()
  {
    AEEditorMusicPanel localAEEditorMusicPanel = this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleMusicAEEditorMusicPanel;
    if (localAEEditorMusicPanel != null) {
      localAEEditorMusicPanel.e();
    }
  }
  
  public final void d()
  {
    AEEditorMusicPanel localAEEditorMusicPanel = this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleMusicAEEditorMusicPanel;
    if (localAEEditorMusicPanel != null) {
      localAEEditorMusicPanel.setEnableBgm(false);
    }
  }
  
  public final void e()
  {
    AEEditorMusicVolumePanelDialog localAEEditorMusicVolumePanelDialog = this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleMusicAEEditorMusicVolumePanelDialog;
    if ((localAEEditorMusicVolumePanelDialog != null) && (!localAEEditorMusicVolumePanelDialog.isShowing()))
    {
      localAEEditorMusicVolumePanelDialog = this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleMusicAEEditorMusicVolumePanelDialog;
      if (localAEEditorMusicVolumePanelDialog != null) {
        localAEEditorMusicVolumePanelDialog.show();
      }
    }
  }
  
  public final void f()
  {
    AEEditorMusicPanel localAEEditorMusicPanel = this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleMusicAEEditorMusicPanel;
    if (localAEEditorMusicPanel != null) {
      localAEEditorMusicPanel.d();
    }
  }
  
  public final void setAutoTemplateMode(boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject = this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleMusicAEEditorMusicPanel;
    if (localObject != null) {
      ((AEEditorMusicPanel)localObject).setAutoTemplate(paramBoolean1, paramBoolean2);
    }
    localObject = this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleMusicAEEditorMusicVolumePanelDialog;
    if (localObject != null) {
      ((AEEditorMusicVolumePanelDialog)localObject).a(paramBoolean1);
    }
  }
  
  public final void setBgmPlayed(boolean paramBoolean, @Nullable AEEditorMusicAdapter.AEEditorMusicInfo paramAEEditorMusicInfo)
  {
    Object localObject = this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleMusicAEEditorMusicPanel;
    if (localObject != null) {
      ((AEEditorMusicPanel)localObject).setBgmPlayed(paramBoolean, paramAEEditorMusicInfo);
    }
    localObject = this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleMusicAEEditorMusicVolumePanelDialog;
    if (localObject != null)
    {
      if (paramAEEditorMusicInfo != null) {
        paramBoolean = true;
      } else {
        paramBoolean = false;
      }
      ((AEEditorMusicVolumePanelDialog)localObject).c(paramBoolean);
    }
  }
  
  public final void setMusicListOperationCallback(@Nullable AEEditorMusicPanel.OperationCallback paramOperationCallback)
  {
    AEEditorMusicPanel localAEEditorMusicPanel = this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleMusicAEEditorMusicPanel;
    if (localAEEditorMusicPanel != null) {
      localAEEditorMusicPanel.setOperationCallback(paramOperationCallback);
    }
  }
  
  public final void setMusicLyricOperationCallback(@Nullable AEEditorLyricPanelDialog.OperationCallback paramOperationCallback)
  {
    AEEditorLyricPanelDialog localAEEditorLyricPanelDialog = this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleMusicAEEditorLyricPanelDialog;
    if (localAEEditorLyricPanelDialog != null) {
      localAEEditorLyricPanelDialog.a(paramOperationCallback);
    }
  }
  
  public final void setMusicVolumeOperationCallback(@Nullable AEEditorMusicVolumePanelDialog.OperationCallback paramOperationCallback)
  {
    AEEditorMusicVolumePanelDialog localAEEditorMusicVolumePanelDialog = this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleMusicAEEditorMusicVolumePanelDialog;
    if (localAEEditorMusicVolumePanelDialog != null) {
      localAEEditorMusicVolumePanelDialog.a(paramOperationCallback);
    }
  }
  
  public final void setOriginSoundOn(boolean paramBoolean)
  {
    AEEditorMusicVolumePanelDialog localAEEditorMusicVolumePanelDialog = this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleMusicAEEditorMusicVolumePanelDialog;
    if (localAEEditorMusicVolumePanelDialog != null) {
      localAEEditorMusicVolumePanelDialog.d(paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.module.controlpanel.AEEditorMusicControlPanel
 * JD-Core Version:    0.7.0.1
 */