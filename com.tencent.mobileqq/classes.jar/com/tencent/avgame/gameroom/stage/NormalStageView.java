package com.tencent.avgame.gameroom.stage;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.avgame.gamelogic.gameres.AvGameResDownloadUtil;
import com.tencent.avgame.gameroom.IGameRoomPresenter;
import com.tencent.avgame.gameroom.stage.base.BaseStageView;
import com.tencent.avgame.gameroom.stage.guessaction.GuessActionStageView;
import com.tencent.avgame.gameroom.stage.guesspicture.GuessPictureStageView;
import com.tencent.avgame.gameroom.stage.guesssong.GuessSongStageView;
import com.tencent.avgame.gameroom.stage.guessstar.GuessStarStageView;
import com.tencent.avgame.gameroom.stage.guesstext.GuessTextStageView;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;

public class NormalStageView
  extends BaseStageView
{
  protected TextView j;
  protected ImageView k;
  protected RelativeLayout.LayoutParams l;
  protected RelativeLayout.LayoutParams m;
  Runnable n = new NormalStageView.1(this);
  Runnable o = new NormalStageView.2(this);
  
  public NormalStageView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public NormalStageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public NormalStageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.p = new StagePresenterImp(this);
  }
  
  public void a(IGameRoomPresenter paramIGameRoomPresenter)
  {
    super.a(paramIGameRoomPresenter);
    this.j = new TextView(getContext());
    this.j.setTextColor(-1);
    this.j.setTextSize(1, 17.0F);
    this.j.setGravity(17);
    this.m = new RelativeLayout.LayoutParams(-2, -2);
    this.m.addRule(12);
    this.m.addRule(14);
    this.m.bottomMargin = ViewUtils.dpToPx(33.0F);
    this.k = new ImageView(getContext());
    this.l = new RelativeLayout.LayoutParams(ViewUtils.dpToPx(190.0F), ViewUtils.dpToPx(40.0F));
    this.l.addRule(12);
    this.l.addRule(14);
    this.l.bottomMargin = ViewUtils.dpToPx(20.0F);
  }
  
  public void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    if (this.j.getParent() != null) {
      removeView(this.j);
    }
    addView(this.j, this.m);
    this.j.setText(paramString);
    postDelayed(this.n, 3000L);
  }
  
  public void b(String paramString)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onShowImageTipOnStageBottom imageName = ");
      localStringBuilder.append(paramString);
      QLog.d("StageView", 2, localStringBuilder.toString());
    }
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    if (this.k.getParent() != null) {
      removeView(this.k);
    }
    addView(this.k, this.l);
    this.k.setBackgroundDrawable(AvGameResDownloadUtil.a(paramString));
    postDelayed(this.o, 1500L);
  }
  
  public void d()
  {
    super.d();
    this.r = new GuessActionStageView(getContext());
    this.t = new GuessPictureStageView(getContext());
    this.u = new GuessSongStageView(getContext());
    this.v = new GuessTextStageView(getContext());
    this.s = new GuessStarStageView(getContext());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gameroom.stage.NormalStageView
 * JD-Core Version:    0.7.0.1
 */