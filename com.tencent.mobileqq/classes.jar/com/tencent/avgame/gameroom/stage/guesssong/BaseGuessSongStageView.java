package com.tencent.avgame.gameroom.stage.guesssong;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.avgame.data.FontStyleConfig;
import com.tencent.avgame.gamelogic.GameEngine;
import com.tencent.avgame.gamelogic.ITopic;
import com.tencent.avgame.gamelogic.data.EngineData;
import com.tencent.avgame.gamelogic.data.Player;
import com.tencent.avgame.gamelogic.data.TopicSongGuess;
import com.tencent.avgame.gameroom.AVGameLottieHelper;
import com.tencent.avgame.gameroom.GameRoomViewLayoutParamsDef;
import com.tencent.avgame.gameroom.IGameRoomPresenter;
import com.tencent.avgame.gameroom.stage.IGameStagePresenter;
import com.tencent.avgame.gameroom.stage.IStagePresenter;
import com.tencent.avgame.gameroom.stage.base.BaseGuessClickStageView;
import com.tencent.avgame.gameroom.stage.util.CountDownClockNumLottieView;
import com.tencent.avgame.session.AVGameUserInfo;
import com.tencent.avgame.ui.AVGameText;
import com.tencent.avgame.util.UiUtils;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.dinifly.LottieDrawable;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import java.util.ArrayList;

public class BaseGuessSongStageView
  extends BaseGuessClickStageView
{
  IGameStagePresenter c;
  TextView d;
  TextView e;
  ImageView f;
  View g;
  AVGameText h;
  AVGameText i;
  View j;
  View k;
  TextView l;
  View m;
  TextView n;
  ImageView o;
  LottieDrawable p;
  boolean q = false;
  ArrayList<Pair<Integer, String>> r;
  int s = 0;
  public Runnable t = new BaseGuessSongStageView.1(this);
  public Runnable u = new BaseGuessSongStageView.2(this);
  public Runnable v = new BaseGuessSongStageView.3(this);
  public Runnable w = new BaseGuessSongStageView.4(this);
  
  public BaseGuessSongStageView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public BaseGuessSongStageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public BaseGuessSongStageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    c();
  }
  
  public Bitmap a(Drawable paramDrawable, int paramInt1, int paramInt2)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("drawableToBitmap ");
    ((StringBuilder)localObject).append(paramInt1);
    ((StringBuilder)localObject).append(" ");
    ((StringBuilder)localObject).append(paramInt2);
    QLog.d("BaseGuessSongStageView", 2, ((StringBuilder)localObject).toString());
    paramDrawable.setBounds(0, 0, paramInt1, paramInt2);
    if (paramDrawable.getOpacity() != -1) {
      localObject = Bitmap.Config.ARGB_8888;
    } else {
      localObject = Bitmap.Config.RGB_565;
    }
    localObject = Bitmap.createBitmap(paramInt1, paramInt2, (Bitmap.Config)localObject);
    paramDrawable.draw(new Canvas((Bitmap)localObject));
    return localObject;
  }
  
  public void a(ITopic paramITopic)
  {
    b(paramITopic);
    if ((paramITopic instanceof TopicSongGuess)) {
      a((TopicSongGuess)paramITopic);
    }
  }
  
  public void a(Player paramPlayer, AVGameUserInfo paramAVGameUserInfo)
  {
    if (GameRoomViewLayoutParamsDef.w <= 0)
    {
      this.k.setVisibility(0);
      return;
    }
    this.k.setVisibility(8);
  }
  
  protected void a(TopicSongGuess paramTopicSongGuess)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onSongStart() topicSong:");
      ((StringBuilder)localObject).append(paramTopicSongGuess);
      QLog.i("BaseGuessSongStageView", 2, ((StringBuilder)localObject).toString());
    }
    if (paramTopicSongGuess == null)
    {
      ThreadManager.getUIHandlerV2().removeCallbacks(this.t);
      return;
    }
    if ((!TextUtils.isEmpty(paramTopicSongGuess.e())) && (paramTopicSongGuess.e().startsWith("http")))
    {
      localObject = paramTopicSongGuess.g();
      if ((localObject[0] != null) && (localObject[0].length() != 0) && (localObject[1] != null) && (localObject[1].length() != 0) && (localObject[2] != null) && (localObject[2].length() != 0))
      {
        this.h.setAttribute("#FFFFFF", localObject[2]);
        this.h.setText(localObject[0]);
        this.i.setAttribute("#FFC000", "#FFFFFF");
        this.i.setText(localObject[1]);
        ThreadManager.getUIHandlerV2().post(this.v);
      }
      else
      {
        ThreadManager.getUIHandlerV2().removeCallbacks(this.w);
        ThreadManager.getUIHandlerV2().post(this.w);
      }
      this.r = paramTopicSongGuess.k;
      localObject = this.r;
      if ((localObject != null) && (((ArrayList)localObject).size() > 0))
      {
        this.s = 0;
        ThreadManager.getUIHandlerV2().postDelayed(this.t, ((Integer)((Pair)this.r.get(this.s)).first).intValue() * 1000);
      }
      paramTopicSongGuess = paramTopicSongGuess.r;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onSongStart() businessAdsTips:");
        ((StringBuilder)localObject).append(paramTopicSongGuess);
        QLog.i("BaseGuessSongStageView", 2, ((StringBuilder)localObject).toString());
      }
      if (!TextUtils.isEmpty(paramTopicSongGuess)) {
        this.c.a().a().b(paramTopicSongGuess);
      }
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onSongStart() illegal url:");
    ((StringBuilder)localObject).append(paramTopicSongGuess.e());
    QLog.i("BaseGuessSongStageView", 1, ((StringBuilder)localObject).toString());
  }
  
  public void a(String paramString)
  {
    this.e.setText(paramString);
    if ((paramString != null) && (paramString.length() > 5)) {
      this.e.setTextSize(0, UiUtils.d());
    } else {
      this.e.setTextSize(0, UiUtils.c());
    }
    this.e.setText(paramString);
    this.e.getViewTreeObserver().addOnGlobalLayoutListener(new BaseGuessSongStageView.5(this, paramString));
    ThreadManager.getUIHandlerV2().postDelayed(this.u, 3000L);
  }
  
  public void a(boolean paramBoolean)
  {
    int i1;
    if (paramBoolean) {
      i1 = 0;
    } else {
      i1 = 8;
    }
    setVisibility(i1);
    if (!paramBoolean)
    {
      LottieDrawable localLottieDrawable = this.p;
      if (localLottieDrawable != null)
      {
        if (localLottieDrawable.isRunning()) {
          this.p.stop();
        }
        this.p = null;
      }
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2) {}
  
  public boolean a()
  {
    return this.q;
  }
  
  public void b(IStagePresenter paramIStagePresenter)
  {
    this.c.a(paramIStagePresenter);
    a(paramIStagePresenter);
  }
  
  protected void c()
  {
    this.l = ((TextView)findViewById(2131447504));
    this.n = ((TextView)findViewById(2131447559));
    this.m = findViewById(2131447534);
    ((RelativeLayout.LayoutParams)this.m.getLayoutParams()).topMargin = GameRoomViewLayoutParamsDef.x;
  }
  
  public void d()
  {
    if (this.p == null)
    {
      AVGameLottieHelper.a(getContext(), "avgame_guess_song_playing/data.json", "avgame_guess_song_playing/images/", 250, 250, new BaseGuessSongStageView.6(this));
      return;
    }
    e();
  }
  
  public void e()
  {
    if (this.p.isRunning()) {
      this.p.stop();
    }
    this.p.setProgress(0.0F);
    this.p.setRepeatCount(-1);
    this.o.setImageDrawable(this.p);
    this.p.start();
    f();
  }
  
  protected void f()
  {
    Object localObject = GameEngine.a().s().y();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("playSongPlayingLottieDrawable ");
      localStringBuilder.append((String)localObject);
      QLog.d("BaseGuessSongStageView", 2, localStringBuilder.toString());
    }
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      localObject = URLDrawable.getDrawable((String)localObject);
      ((URLDrawable)localObject).setURLDrawableListener(new BaseGuessSongStageView.7(this));
      ((URLDrawable)localObject).startDownload();
    }
  }
  
  public IGameStagePresenter getPresenter()
  {
    return this.c;
  }
  
  public ImageView getTopicClockView()
  {
    return this.f;
  }
  
  public void setFontStyle(FontStyleConfig paramFontStyleConfig)
  {
    this.n.setTextSize(paramFontStyleConfig.b);
    this.n.setTextColor(Color.parseColor(paramFontStyleConfig.a));
    ImageView localImageView = this.f;
    if ((localImageView instanceof CountDownClockNumLottieView)) {
      ((CountDownClockNumLottieView)localImageView).setParams(Color.parseColor(paramFontStyleConfig.c), ViewUtils.dip2px(paramFontStyleConfig.d));
    }
  }
  
  public void setSpecialMode(boolean paramBoolean)
  {
    this.q = paramBoolean;
  }
  
  public void setTitleCenter(String paramString)
  {
    TextView localTextView = this.l;
    if (localTextView != null) {
      localTextView.setText(paramString);
    }
  }
  
  public void setTitleRight(String paramString)
  {
    TextView localTextView = this.n;
    if (localTextView != null) {
      localTextView.setText(paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gameroom.stage.guesssong.BaseGuessSongStageView
 * JD-Core Version:    0.7.0.1
 */