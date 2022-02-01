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
  private final AEEditorPanelDialogDelegate a;
  private final FrameLayout b;
  private final MoreLyricLayout c;
  private final TextView d;
  private final TextView e;
  private final AEEditorMusicWaveView f;
  private AEEditorQcircleBubbleView g;
  private Runnable h;
  private AEEditorLyricPanelDialog.OperationCallback i;
  private int j;
  private int k;
  private int l;
  
  public AEEditorLyricPanelDialog(@NonNull Context paramContext)
  {
    super(paramContext, 2131951677);
    View localView = LayoutInflater.from(paramContext).inflate(2064056430, null);
    this.b = ((FrameLayout)localView.findViewById(2063991094));
    this.c = ((MoreLyricLayout)localView.findViewById(2063991261));
    this.d = ((TextView)localView.findViewById(2063991568));
    this.e = ((TextView)localView.findViewById(2063991535));
    this.f = ((AEEditorMusicWaveView)localView.findViewById(2063990866));
    this.c.setOnMoreLyricLayoutActionListener(new AEEditorLyricPanelDialog.1(this));
    this.c.setMoreBackground(paramContext.getResources().getDrawable(2131168376));
    this.c.setLyricBackgroundEffect(new AEEditorLyricPanelDialog.2(this));
    this.f.setDragIndicatorListener(this);
    localView.findViewById(2063991181).setOnClickListener(this);
    localView.findViewById(2063991175).setOnClickListener(this);
    localView.findViewById(2063991571).setOnClickListener(this);
    ((IQCircleRFWApi)QRoute.api(IQCircleRFWApi.class)).setNumberTypeface(this.d, false);
    ((IQCircleRFWApi)QRoute.api(IQCircleRFWApi.class)).setNumberTypeface(this.e, false);
    setContentView(localView);
    this.a = new AEEditorPanelDialogDelegate(this, localView, new AEEditorLyricPanelDialog.3(this));
    c();
  }
  
  private void c()
  {
    if (AECameraPrefsUtil.a().b("SP_KEY_FIRST_ENTER_MUSIC_TAB", true, 0))
    {
      this.h = new AEEditorLyricPanelDialog.6(this);
      this.f.post(new AEEditorLyricPanelDialog.7(this));
    }
  }
  
  private void c(int paramInt)
  {
    int m = this.l;
    b(paramInt);
    Object localObject = this.c;
    if (localObject != null) {
      ((MoreLyricLayout)localObject).setLyricSeek(paramInt);
    }
    localObject = this.i;
    if (localObject != null)
    {
      ((AEEditorLyricPanelDialog.OperationCallback)localObject).onMusicWaveMoving(paramInt, m + paramInt);
      this.i.onMusicWaveMoveEnd();
    }
  }
  
  private boolean d()
  {
    AEEditorMusicWaveView localAEEditorMusicWaveView = this.f;
    if (localAEEditorMusicWaveView == null) {
      return true;
    }
    return localAEEditorMusicWaveView.getStartTime() == this.j;
  }
  
  public void a()
  {
    AEEditorLyricPanelDialog.OperationCallback localOperationCallback = this.i;
    if (localOperationCallback != null) {
      localOperationCallback.onMusicWaveMoveStart();
    }
  }
  
  public void a(int paramInt)
  {
    if (this.f != null)
    {
      AEReportUtils.a(9);
      AEEditorLyricPanelDialog.OperationCallback localOperationCallback = this.i;
      if (localOperationCallback != null) {
        localOperationCallback.onIndicatorDragged(this.f.a(this.l));
      }
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    AEEditorLyricPanelDialog.OperationCallback localOperationCallback = this.i;
    if (localOperationCallback != null) {
      localOperationCallback.onMusicWaveMoving(paramInt1, paramInt2);
    }
  }
  
  public void a(@Nullable AEEditorLyricPanelDialog.OperationCallback paramOperationCallback)
  {
    this.i = paramOperationCallback;
  }
  
  public void a(@NonNull AEEditorMusicAdapter.AEEditorMusicInfo paramAEEditorMusicInfo, int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean)
  {
    this.j = paramAEEditorMusicInfo.e();
    this.k = paramAEEditorMusicInfo.f();
    this.l = paramInt2;
    AEEditorLyricProgressCalculator.a().b(paramInt1, Math.min(paramInt1 + paramInt2, this.k));
    Object localObject = this.f;
    if (localObject != null)
    {
      ((AEEditorMusicWaveView)localObject).a(paramAEEditorMusicInfo.c(), AEEditorMusicHelper.a(paramAEEditorMusicInfo), paramAEEditorMusicInfo.f(), paramInt2, false, paramInt3, paramInt4, true, paramBoolean);
      this.f.setOnMusicMoveListener(this);
      b(paramInt1);
    }
    localObject = this.c;
    if (localObject != null)
    {
      ((MoreLyricLayout)localObject).setVisibility(0);
      this.c.setBackgroundResource(2131168376);
      this.c.a(paramAEEditorMusicInfo, paramInt1, true, false);
    }
    paramAEEditorMusicInfo = this.b;
    if (paramAEEditorMusicInfo != null) {
      paramAEEditorMusicInfo.setAlpha(1.0F);
    }
  }
  
  public void b()
  {
    AEEditorLyricPanelDialog.OperationCallback localOperationCallback = this.i;
    if (localOperationCallback != null) {
      localOperationCallback.onMusicWaveMoveEnd();
    }
  }
  
  public void b(int paramInt)
  {
    AEEditorMusicWaveView localAEEditorMusicWaveView = this.f;
    if (localAEEditorMusicWaveView != null) {
      localAEEditorMusicWaveView.b(paramInt);
    }
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    Object localObject = this.f;
    if ((localObject != null) && (!((AEEditorMusicWaveView)localObject).f()))
    {
      this.f.setIndicatorIndexByVideo(paramInt1, paramInt2);
      this.f.setCurrentPosition(paramInt1, paramInt2);
    }
    localObject = this.c;
    if (localObject != null) {
      ((MoreLyricLayout)localObject).a((int)AEEditorLyricProgressCalculator.a().a(false));
    }
  }
  
  public void c(int paramInt1, int paramInt2)
  {
    TextView localTextView = this.d;
    if (localTextView != null) {
      localTextView.setText(TimeUtils.a(TimeUtils.a, paramInt1));
    }
    localTextView = this.e;
    if (localTextView != null) {
      localTextView.setText(TimeUtils.a(TimeUtils.a, Math.min(paramInt2, this.k)));
    }
  }
  
  public void dismiss()
  {
    this.a.c();
  }
  
  public void onClick(View paramView)
  {
    int m = paramView.getId();
    if (m == 2063991175)
    {
      paramView = this.i;
      if (paramView != null) {
        paramView.onClickCancelBtn();
      }
      dismiss();
      return;
    }
    if (m == 2063991181)
    {
      paramView = this.i;
      if (paramView != null) {
        paramView.onClickConfirmBtn();
      }
      dismiss();
      return;
    }
    if (m == 2063991571)
    {
      if (d()) {
        return;
      }
      paramView = this.i;
      if (paramView != null) {
        paramView.onResetMusicRangeToRecommend(this.j);
      }
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.a.a();
    setOnShowListener(new AEEditorLyricPanelDialog.4(this));
    setOnDismissListener(new AEEditorLyricPanelDialog.5(this));
  }
  
  public void show()
  {
    this.a.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.module.music.AEEditorLyricPanelDialog
 * JD-Core Version:    0.7.0.1
 */