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
  private final AEEditorPanelDialogDelegate a;
  private final View b;
  private final SeekBar c;
  private final View d;
  private final SeekBar e;
  private int f;
  private int g;
  private int h = 50;
  private long i;
  private AEEditorMusicVolumePanelDialog.OperationCallback j;
  
  public AEEditorMusicVolumePanelDialog(@NonNull Context paramContext)
  {
    super(paramContext, 2131951677);
    paramContext = LayoutInflater.from(paramContext).inflate(2064056432, null);
    paramContext.findViewById(2063991175).setOnClickListener(this);
    paramContext.findViewById(2063991181).setOnClickListener(this);
    this.b = paramContext.findViewById(2063991277);
    this.c = ((SeekBar)paramContext.findViewById(2063991276));
    this.d = paramContext.findViewById(2063991289);
    this.e = ((SeekBar)paramContext.findViewById(2063991288));
    setContentView(paramContext);
    this.a = new AEEditorPanelDialogDelegate(this, paramContext, new AEEditorMusicVolumePanelDialog.1(this));
    this.b.setOnClickListener(new AEEditorMusicVolumePanelDialog.2(this));
    this.c.setOnSeekBarChangeListener(new AEEditorMusicVolumePanelDialog.3(this));
    this.d.setOnClickListener(new AEEditorMusicVolumePanelDialog.4(this));
    this.e.setOnSeekBarChangeListener(new AEEditorMusicVolumePanelDialog.5(this));
  }
  
  private void a(int paramInt)
  {
    if (System.currentTimeMillis() - this.i > 2000L)
    {
      this.i = System.currentTimeMillis();
      QQToast.makeText(getContext(), paramInt, 0).show();
    }
  }
  
  public void a(@Nullable AEEditorMusicVolumePanelDialog.OperationCallback paramOperationCallback)
  {
    this.j = paramOperationCallback;
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.c.setProgress(50);
      this.e.setProgress(0);
      this.f = 50;
      this.g = 0;
      return;
    }
    this.c.setProgress(50);
    this.e.setProgress(50);
    this.f = 50;
    this.g = 50;
  }
  
  public void b(boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      this.e.setProgress(0);
      this.g = 0;
      return;
    }
    this.e.setProgress(this.h);
    this.g = this.h;
  }
  
  public void c(boolean paramBoolean)
  {
    this.c.setEnabled(paramBoolean);
    View localView = this.b;
    int k;
    if (paramBoolean) {
      k = 4;
    } else {
      k = 0;
    }
    localView.setVisibility(k);
  }
  
  public void d(boolean paramBoolean)
  {
    this.e.setEnabled(paramBoolean);
    View localView = this.d;
    int k;
    if (paramBoolean) {
      k = 4;
    } else {
      k = 0;
    }
    localView.setVisibility(k);
  }
  
  public void dismiss()
  {
    this.a.c();
    AEEditorMusicVolumePanelDialog.OperationCallback localOperationCallback = this.j;
    if (localOperationCallback != null) {
      localOperationCallback.ac();
    }
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2063991175)
    {
      dismiss();
      this.c.setProgress(this.f);
      this.e.setProgress(this.g);
      return;
    }
    if (paramView.getId() == 2063991181)
    {
      dismiss();
      this.f = this.c.getProgress();
      this.g = this.e.getProgress();
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.a.a();
  }
  
  public void show()
  {
    this.a.b();
    AEEditorMusicVolumePanelDialog.OperationCallback localOperationCallback = this.j;
    if (localOperationCallback != null) {
      localOperationCallback.ab();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.module.music.AEEditorMusicVolumePanelDialog
 * JD-Core Version:    0.7.0.1
 */