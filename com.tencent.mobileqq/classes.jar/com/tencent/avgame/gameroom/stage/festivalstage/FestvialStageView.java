package com.tencent.avgame.gameroom.stage.festivalstage;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.avgame.data.FontStyleConfig;
import com.tencent.avgame.gamelogic.GameEngine;
import com.tencent.avgame.gamelogic.data.EngineData;
import com.tencent.avgame.gamelogic.gameres.AvGameResDownloadUtil;
import com.tencent.avgame.gameroom.IGameRoomPresenter;
import com.tencent.avgame.gameroom.stage.base.BaseStageView;
import com.tencent.avgame.gameroom.stage.guessaction.GuessActionStageView;
import com.tencent.avgame.gameroom.stage.guesspicture.BaseGuessPictureStageView;
import com.tencent.avgame.gameroom.stage.guesspicture.GuessPictureClickStageView;
import com.tencent.avgame.gameroom.stage.guesspicture.GuessPictureStageView;
import com.tencent.avgame.gameroom.stage.guesssong.BaseGuessSongStageView;
import com.tencent.avgame.gameroom.stage.guesssong.GuessSongClickStageView;
import com.tencent.avgame.gameroom.stage.guesssong.GuessSongStageView;
import com.tencent.avgame.gameroom.stage.guessstar.BaseGuessStarStageView;
import com.tencent.avgame.gameroom.stage.guessstar.GuessStarClickStageView;
import com.tencent.avgame.gameroom.stage.guessstar.GuessStarStageView;
import com.tencent.avgame.gameroom.stage.guesstext.BaseGuessTextStageView;
import com.tencent.avgame.gameroom.stage.guesstext.GuessTextClickStageView;
import com.tencent.avgame.gameroom.stage.guesstext.GuessTextStageView;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;

public class FestvialStageView
  extends BaseStageView
{
  private boolean K = false;
  protected TextView j;
  protected ImageView k;
  protected RelativeLayout.LayoutParams l;
  protected RelativeLayout.LayoutParams m;
  Runnable n = new FestvialStageView.1(this);
  Runnable o = new FestvialStageView.2(this);
  
  public FestvialStageView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public FestvialStageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public FestvialStageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.p = new FestivalStagePresenterImp(this);
  }
  
  private void g()
  {
    FontStyleConfig localFontStyleConfig = GameEngine.a().s().x;
    if (localFontStyleConfig != null)
    {
      int i = 0;
      try
      {
        int i1 = Color.parseColor(localFontStyleConfig.o);
        i = i1;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
      this.j.setTextColor(i);
    }
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
    g();
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
    if (this.K) {
      super.d();
    }
    boolean bool1 = GameEngine.a().C();
    boolean bool2 = GameEngine.a().D();
    this.r = new GuessActionStageView(getContext());
    if ((bool2) && (!bool1))
    {
      this.t = new GuessPictureClickStageView(getContext());
      this.u = new GuessSongClickStageView(getContext());
      this.v = new GuessTextClickStageView(getContext());
      this.s = new GuessStarClickStageView(getContext());
    }
    else
    {
      this.t = new GuessPictureStageView(getContext());
      this.u = new GuessSongStageView(getContext());
      this.v = new GuessTextStageView(getContext());
      this.s = new GuessStarStageView(getContext());
      this.t.setSpecialMode(true);
      this.u.setSpecialMode(true);
      this.v.setSpecialMode(true);
      this.s.setSpecialMode(true);
    }
    FontStyleConfig localFontStyleConfig = GameEngine.a().s().x;
    this.t.setFontStyle(localFontStyleConfig);
    this.u.setFontStyle(localFontStyleConfig);
    this.v.setFontStyle(localFontStyleConfig);
    this.s.setFontStyle(localFontStyleConfig);
    this.K = true;
  }
  
  public boolean f()
  {
    return this.K;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gameroom.stage.festivalstage.FestvialStageView
 * JD-Core Version:    0.7.0.1
 */