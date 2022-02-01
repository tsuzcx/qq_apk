package com.tencent.aelight.camera.aeeditor.module.music;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.aelight.camera.ae.util.AECameraPrefsUtil;
import com.tencent.aelight.camera.aebase.AEReportUtils;
import com.tencent.aelight.camera.aeeditor.lyric.interaction.MoreLyricLayout;
import com.tencent.aelight.camera.aeeditor.util.TimeUtils;
import com.tencent.aelight.camera.aeeditor.view.AEEditorMusicWaveScrollProcessor.IMusicBarMoveListener;
import com.tencent.aelight.camera.aeeditor.view.AEEditorMusicWaveView;
import com.tencent.aelight.camera.aeeditor.view.AEEditorMusicWaveView.IDragIndicatorListener;
import com.tencent.aelight.camera.aeeditor.view.AEEditorQcircleBubbleView;
import com.tencent.mobileqq.qcircle.api.IQCircleRFWApi;
import com.tencent.mobileqq.qroute.QRoute;

public class AEEditorLyricPanelDialog
  extends Dialog
  implements View.OnClickListener, AEEditorMusicWaveScrollProcessor.IMusicBarMoveListener, AEEditorMusicWaveView.IDragIndicatorListener
{
  private int jdField_a_of_type_Int;
  private final FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  private final TextView jdField_a_of_type_AndroidWidgetTextView;
  private final MoreLyricLayout jdField_a_of_type_ComTencentAelightCameraAeeditorLyricInteractionMoreLyricLayout;
  private AEEditorLyricPanelDialog.OperationCallback jdField_a_of_type_ComTencentAelightCameraAeeditorModuleMusicAEEditorLyricPanelDialog$OperationCallback;
  private final AEEditorPanelDialogDelegate jdField_a_of_type_ComTencentAelightCameraAeeditorModuleMusicAEEditorPanelDialogDelegate;
  private final AEEditorMusicWaveView jdField_a_of_type_ComTencentAelightCameraAeeditorViewAEEditorMusicWaveView;
  private AEEditorQcircleBubbleView jdField_a_of_type_ComTencentAelightCameraAeeditorViewAEEditorQcircleBubbleView;
  private Runnable jdField_a_of_type_JavaLangRunnable;
  private int jdField_b_of_type_Int;
  private final TextView jdField_b_of_type_AndroidWidgetTextView;
  private int c;
  
  public AEEditorLyricPanelDialog(@NonNull Context paramContext)
  {
    super(paramContext, 2131755059);
    View localView = LayoutInflater.from(paramContext).inflate(2064318558, null);
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)localView.findViewById(2064122213));
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorLyricInteractionMoreLyricLayout = ((MoreLyricLayout)localView.findViewById(2064122404));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2064122793));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2064122761));
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewAEEditorMusicWaveView = ((AEEditorMusicWaveView)localView.findViewById(2064121932));
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorLyricInteractionMoreLyricLayout.setOnMoreLyricLayoutActionListener(new AEEditorLyricPanelDialog.1(this));
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorLyricInteractionMoreLyricLayout.setMoreBackground(paramContext.getResources().getDrawable(2131167333));
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorLyricInteractionMoreLyricLayout.setLyricBackgroundEffect(new AEEditorLyricPanelDialog.2(this));
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewAEEditorMusicWaveView.setDragIndicatorListener(this);
    localView.findViewById(2064122302).setOnClickListener(this);
    localView.findViewById(2064122296).setOnClickListener(this);
    localView.findViewById(2064122796).setOnClickListener(this);
    ((IQCircleRFWApi)QRoute.api(IQCircleRFWApi.class)).setNumberTypeface(this.jdField_a_of_type_AndroidWidgetTextView, false);
    ((IQCircleRFWApi)QRoute.api(IQCircleRFWApi.class)).setNumberTypeface(this.jdField_b_of_type_AndroidWidgetTextView, false);
    setContentView(localView);
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleMusicAEEditorPanelDialogDelegate = new AEEditorPanelDialogDelegate(this, localView, new AEEditorLyricPanelDialog.3(this));
    c();
  }
  
  private boolean a()
  {
    AEEditorMusicWaveView localAEEditorMusicWaveView = this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewAEEditorMusicWaveView;
    if (localAEEditorMusicWaveView == null) {
      return true;
    }
    return localAEEditorMusicWaveView.a() == this.jdField_a_of_type_Int;
  }
  
  private void c()
  {
    if (AECameraPrefsUtil.a().a("SP_KEY_FIRST_ENTER_MUSIC_TAB", true, 0))
    {
      this.jdField_a_of_type_JavaLangRunnable = new AEEditorLyricPanelDialog.6(this);
      this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewAEEditorMusicWaveView.post(new AEEditorLyricPanelDialog.7(this));
    }
  }
  
  private void c(int paramInt)
  {
    int i = this.c;
    b(paramInt);
    Object localObject = this.jdField_a_of_type_ComTencentAelightCameraAeeditorLyricInteractionMoreLyricLayout;
    if (localObject != null) {
      ((MoreLyricLayout)localObject).setLyricSeek(paramInt);
    }
    localObject = this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleMusicAEEditorLyricPanelDialog$OperationCallback;
    if (localObject != null)
    {
      ((AEEditorLyricPanelDialog.OperationCallback)localObject).a(paramInt, i + paramInt);
      this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleMusicAEEditorLyricPanelDialog$OperationCallback.M();
    }
  }
  
  public void a()
  {
    AEEditorLyricPanelDialog.OperationCallback localOperationCallback = this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleMusicAEEditorLyricPanelDialog$OperationCallback;
    if (localOperationCallback != null) {
      localOperationCallback.L();
    }
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewAEEditorMusicWaveView != null)
    {
      AEReportUtils.b(9);
      AEEditorLyricPanelDialog.OperationCallback localOperationCallback = this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleMusicAEEditorLyricPanelDialog$OperationCallback;
      if (localOperationCallback != null) {
        localOperationCallback.b(this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewAEEditorMusicWaveView.a(this.c));
      }
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    AEEditorLyricPanelDialog.OperationCallback localOperationCallback = this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleMusicAEEditorLyricPanelDialog$OperationCallback;
    if (localOperationCallback != null) {
      localOperationCallback.a(paramInt1, paramInt2);
    }
  }
  
  public void a(@Nullable AEEditorLyricPanelDialog.OperationCallback paramOperationCallback)
  {
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleMusicAEEditorLyricPanelDialog$OperationCallback = paramOperationCallback;
  }
  
  public void a(@NonNull AEEditorMusicAdapter.AEEditorMusicInfo paramAEEditorMusicInfo, int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean)
  {
    this.jdField_a_of_type_Int = paramAEEditorMusicInfo.a();
    this.jdField_b_of_type_Int = paramAEEditorMusicInfo.b();
    this.c = paramInt2;
    AEEditorLyricProgressCalculator.a().b(paramInt1, Math.min(paramInt1 + paramInt2, this.jdField_b_of_type_Int));
    Object localObject = this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewAEEditorMusicWaveView;
    if (localObject != null)
    {
      ((AEEditorMusicWaveView)localObject).a(paramAEEditorMusicInfo.a(), AEEditorMusicHelper.a(paramAEEditorMusicInfo), paramAEEditorMusicInfo.b(), paramInt2, false, paramInt3, paramInt4, true, paramBoolean);
      this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewAEEditorMusicWaveView.setOnMusicMoveListener(this);
      b(paramInt1);
    }
    localObject = this.jdField_a_of_type_ComTencentAelightCameraAeeditorLyricInteractionMoreLyricLayout;
    if (localObject != null)
    {
      ((MoreLyricLayout)localObject).setVisibility(0);
      this.jdField_a_of_type_ComTencentAelightCameraAeeditorLyricInteractionMoreLyricLayout.setBackgroundResource(2131167333);
      this.jdField_a_of_type_ComTencentAelightCameraAeeditorLyricInteractionMoreLyricLayout.a(paramAEEditorMusicInfo, paramInt1, true, false);
    }
    paramAEEditorMusicInfo = this.jdField_a_of_type_AndroidWidgetFrameLayout;
    if (paramAEEditorMusicInfo != null) {
      paramAEEditorMusicInfo.setAlpha(1.0F);
    }
  }
  
  public void b()
  {
    AEEditorLyricPanelDialog.OperationCallback localOperationCallback = this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleMusicAEEditorLyricPanelDialog$OperationCallback;
    if (localOperationCallback != null) {
      localOperationCallback.M();
    }
  }
  
  public void b(int paramInt)
  {
    AEEditorMusicWaveView localAEEditorMusicWaveView = this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewAEEditorMusicWaveView;
    if (localAEEditorMusicWaveView != null) {
      localAEEditorMusicWaveView.a(paramInt);
    }
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    Object localObject = this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewAEEditorMusicWaveView;
    if ((localObject != null) && (!((AEEditorMusicWaveView)localObject).c()))
    {
      this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewAEEditorMusicWaveView.setIndicatorIndexByVideo(paramInt1, paramInt2);
      this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewAEEditorMusicWaveView.setCurrentPosition(paramInt1, paramInt2);
    }
    localObject = this.jdField_a_of_type_ComTencentAelightCameraAeeditorLyricInteractionMoreLyricLayout;
    if (localObject != null) {
      ((MoreLyricLayout)localObject).a((int)AEEditorLyricProgressCalculator.a().a(false));
    }
  }
  
  public void c(int paramInt1, int paramInt2)
  {
    TextView localTextView = this.jdField_a_of_type_AndroidWidgetTextView;
    if (localTextView != null) {
      localTextView.setText(TimeUtils.a(TimeUtils.a, paramInt1));
    }
    localTextView = this.jdField_b_of_type_AndroidWidgetTextView;
    if (localTextView != null) {
      localTextView.setText(TimeUtils.a(TimeUtils.a, Math.min(paramInt2, this.jdField_b_of_type_Int)));
    }
  }
  
  public void dismiss()
  {
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleMusicAEEditorPanelDialogDelegate.c();
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i == 2064122296)
    {
      paramView = this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleMusicAEEditorLyricPanelDialog$OperationCallback;
      if (paramView != null) {
        paramView.N();
      }
      dismiss();
      return;
    }
    if (i == 2064122302)
    {
      paramView = this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleMusicAEEditorLyricPanelDialog$OperationCallback;
      if (paramView != null) {
        paramView.O();
      }
      dismiss();
      return;
    }
    if (i == 2064122796)
    {
      if (a()) {
        return;
      }
      paramView = this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleMusicAEEditorLyricPanelDialog$OperationCallback;
      if (paramView != null) {
        paramView.c(this.jdField_a_of_type_Int);
      }
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleMusicAEEditorPanelDialogDelegate.a();
    setOnShowListener(new AEEditorLyricPanelDialog.4(this));
    setOnDismissListener(new AEEditorLyricPanelDialog.5(this));
  }
  
  public void show()
  {
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleMusicAEEditorPanelDialogDelegate.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.module.music.AEEditorLyricPanelDialog
 * JD-Core Version:    0.7.0.1
 */