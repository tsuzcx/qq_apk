package com.tencent.aelight.camera.aeeditor.module.music;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.SeekBar;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.widget.QQToast;

public class AEEditorMusicVolumePanelDialog
  extends Dialog
  implements View.OnClickListener
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private final View jdField_a_of_type_AndroidViewView;
  private final SeekBar jdField_a_of_type_AndroidWidgetSeekBar;
  private AEEditorMusicVolumePanelDialog.OperationCallback jdField_a_of_type_ComTencentAelightCameraAeeditorModuleMusicAEEditorMusicVolumePanelDialog$OperationCallback;
  private final AEEditorPanelDialogDelegate jdField_a_of_type_ComTencentAelightCameraAeeditorModuleMusicAEEditorPanelDialogDelegate;
  private int jdField_b_of_type_Int;
  private final View jdField_b_of_type_AndroidViewView;
  private final SeekBar jdField_b_of_type_AndroidWidgetSeekBar;
  private int c = 50;
  
  public AEEditorMusicVolumePanelDialog(@NonNull Context paramContext)
  {
    super(paramContext, 2131755059);
    paramContext = LayoutInflater.from(paramContext).inflate(2064318560, null);
    paramContext.findViewById(2064122296).setOnClickListener(this);
    paramContext.findViewById(2064122302).setOnClickListener(this);
    this.jdField_a_of_type_AndroidViewView = paramContext.findViewById(2064122448);
    this.jdField_a_of_type_AndroidWidgetSeekBar = ((SeekBar)paramContext.findViewById(2064122447));
    this.jdField_b_of_type_AndroidViewView = paramContext.findViewById(2064122463);
    this.jdField_b_of_type_AndroidWidgetSeekBar = ((SeekBar)paramContext.findViewById(2064122462));
    setContentView(paramContext);
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleMusicAEEditorPanelDialogDelegate = new AEEditorPanelDialogDelegate(this, paramContext, new AEEditorMusicVolumePanelDialog.1(this));
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(new AEEditorMusicVolumePanelDialog.2(this));
    this.jdField_a_of_type_AndroidWidgetSeekBar.setOnSeekBarChangeListener(new AEEditorMusicVolumePanelDialog.3(this));
    this.jdField_b_of_type_AndroidViewView.setOnClickListener(new AEEditorMusicVolumePanelDialog.4(this));
    this.jdField_b_of_type_AndroidWidgetSeekBar.setOnSeekBarChangeListener(new AEEditorMusicVolumePanelDialog.5(this));
  }
  
  private void a(int paramInt)
  {
    if (System.currentTimeMillis() - this.jdField_a_of_type_Long > 2000L)
    {
      this.jdField_a_of_type_Long = System.currentTimeMillis();
      QQToast.a(getContext(), paramInt, 0).a();
    }
  }
  
  public void a(@Nullable AEEditorMusicVolumePanelDialog.OperationCallback paramOperationCallback)
  {
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleMusicAEEditorMusicVolumePanelDialog$OperationCallback = paramOperationCallback;
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_a_of_type_AndroidWidgetSeekBar.setProgress(50);
      this.jdField_b_of_type_AndroidWidgetSeekBar.setProgress(0);
      this.jdField_a_of_type_Int = 50;
      this.jdField_b_of_type_Int = 0;
      return;
    }
    this.jdField_a_of_type_AndroidWidgetSeekBar.setProgress(50);
    this.jdField_b_of_type_AndroidWidgetSeekBar.setProgress(50);
    this.jdField_a_of_type_Int = 50;
    this.jdField_b_of_type_Int = 50;
  }
  
  public void b(boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      this.jdField_b_of_type_AndroidWidgetSeekBar.setProgress(0);
      this.jdField_b_of_type_Int = 0;
      return;
    }
    this.jdField_b_of_type_AndroidWidgetSeekBar.setProgress(this.c);
    this.jdField_b_of_type_Int = this.c;
  }
  
  public void c(boolean paramBoolean)
  {
    this.jdField_a_of_type_AndroidWidgetSeekBar.setEnabled(paramBoolean);
    View localView = this.jdField_a_of_type_AndroidViewView;
    int i;
    if (paramBoolean) {
      i = 4;
    } else {
      i = 0;
    }
    localView.setVisibility(i);
  }
  
  public void d(boolean paramBoolean)
  {
    this.jdField_b_of_type_AndroidWidgetSeekBar.setEnabled(paramBoolean);
    View localView = this.jdField_b_of_type_AndroidViewView;
    int i;
    if (paramBoolean) {
      i = 4;
    } else {
      i = 0;
    }
    localView.setVisibility(i);
  }
  
  public void dismiss()
  {
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleMusicAEEditorPanelDialogDelegate.c();
    AEEditorMusicVolumePanelDialog.OperationCallback localOperationCallback = this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleMusicAEEditorMusicVolumePanelDialog$OperationCallback;
    if (localOperationCallback != null) {
      localOperationCallback.I();
    }
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2064122296)
    {
      dismiss();
      this.jdField_a_of_type_AndroidWidgetSeekBar.setProgress(this.jdField_a_of_type_Int);
      this.jdField_b_of_type_AndroidWidgetSeekBar.setProgress(this.jdField_b_of_type_Int);
      return;
    }
    if (paramView.getId() == 2064122302)
    {
      dismiss();
      this.jdField_a_of_type_Int = this.jdField_a_of_type_AndroidWidgetSeekBar.getProgress();
      this.jdField_b_of_type_Int = this.jdField_b_of_type_AndroidWidgetSeekBar.getProgress();
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleMusicAEEditorPanelDialogDelegate.a();
  }
  
  public void show()
  {
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleMusicAEEditorPanelDialogDelegate.b();
    AEEditorMusicVolumePanelDialog.OperationCallback localOperationCallback = this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleMusicAEEditorMusicVolumePanelDialog$OperationCallback;
    if (localOperationCallback != null) {
      localOperationCallback.H();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.module.music.AEEditorMusicVolumePanelDialog
 * JD-Core Version:    0.7.0.1
 */