package com.tencent.avgame.gameroom.stage.guesssong;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.avgame.data.FontStyleConfig;
import com.tencent.avgame.gamelogic.GameEngine;
import com.tencent.avgame.gamelogic.data.EngineData;
import com.tencent.avgame.gamelogic.data.GameItem;
import com.tencent.avgame.gamelogic.data.TopicSongGuess;
import com.tencent.avgame.gamelogic.gameres.AvGameResDownloadUtil;
import com.tencent.avgame.gameroom.AVGameLottieHelper;
import com.tencent.avgame.gameroom.IGameRoomPresenter;
import com.tencent.avgame.gameroom.festivalstage.questionoption.QuestionOptionItemConfig;
import com.tencent.avgame.gameroom.festivalstage.questionoption.QuestionOptionsView;
import com.tencent.avgame.gameroom.stage.IGameStagePresenter;
import com.tencent.avgame.gameroom.stage.IStagePresenter;
import com.tencent.avgame.ui.AVGameText;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.dinifly.LottieDrawable;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import java.util.ArrayList;

public class GuessSongClickStageView
  extends BaseGuessSongStageView
{
  public Runnable x = new GuessSongClickStageView.1(this);
  public Runnable y = new GuessSongClickStageView.2(this);
  private ImageView z;
  
  public GuessSongClickStageView(Context paramContext)
  {
    super(paramContext);
  }
  
  public GuessSongClickStageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public GuessSongClickStageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  protected void a(TopicSongGuess paramTopicSongGuess)
  {
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("onSongStart() topicSong:");
      localStringBuilder.append(paramTopicSongGuess);
      QLog.i("GuessSongClickStageView", 2, localStringBuilder.toString());
    }
    if (paramTopicSongGuess == null)
    {
      ThreadManager.getUIHandlerV2().removeCallbacks(this.x);
      return;
    }
    if ((!TextUtils.isEmpty(paramTopicSongGuess.e())) && (paramTopicSongGuess.e().startsWith("http")))
    {
      this.r = paramTopicSongGuess.k;
      if ((this.r != null) && (this.r.size() > 0))
      {
        this.s = 0;
        ThreadManager.getUIHandlerV2().postDelayed(this.x, ((Integer)((Pair)this.r.get(this.s)).first).intValue() * 1000);
      }
      paramTopicSongGuess = paramTopicSongGuess.r;
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("onSongStart() businessAdsTips:");
        localStringBuilder.append(paramTopicSongGuess);
        QLog.i("GuessSongClickStageView", 2, localStringBuilder.toString());
      }
      if (!TextUtils.isEmpty(paramTopicSongGuess)) {
        this.c.a().a().b(paramTopicSongGuess);
      }
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onSongStart() illegal url:");
    localStringBuilder.append(paramTopicSongGuess.e());
    QLog.i("GuessSongClickStageView", 1, localStringBuilder.toString());
  }
  
  public void a(String paramString)
  {
    TextView localTextView = this.e;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(getResources().getText(2131887251));
    localStringBuilder.append(paramString);
    localTextView.setText(localStringBuilder.toString());
    ThreadManager.getUIHandlerV2().postDelayed(this.y, 3000L);
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (!paramBoolean2)
    {
      this.f.setVisibility(4);
      this.g.setVisibility(8);
      setBackgroundDrawable(null);
      if ((this.p != null) && (this.p.isRunning())) {
        this.p.stop();
      }
      this.p = null;
      this.o.setVisibility(4);
      return;
    }
    this.f.setVisibility(0);
    this.g.setVisibility(8);
    if (this.o.getVisibility() != 0)
    {
      String str = this.c.a().a().s();
      if (!TextUtils.isEmpty(str)) {
        setBackgroundDrawable(URLDrawable.getDrawable(str));
      } else {
        setBackgroundDrawable(AvGameResDownloadUtil.a("avgame_float_act_guess_place_holder@2x.png"));
      }
      this.o.setVisibility(0);
      d();
    }
  }
  
  protected void c()
  {
    LayoutInflater.from(getContext()).inflate(2131624285, this, true);
    this.e = ((TextView)findViewById(2131448811));
    this.h = ((AVGameText)findViewById(2131448302));
    this.i = ((AVGameText)findViewById(2131448303));
    this.j = findViewById(2131437420);
    this.f = ((ImageView)findViewById(2131447536));
    this.g = findViewById(2131437582);
    this.k = findViewById(2131434340);
    this.k.setVisibility(8);
    this.c = new GuessSongClickStagePresenter(this);
    this.f.setVisibility(4);
    this.g.setVisibility(4);
    this.o = ((ImageView)findViewById(2131446158));
    this.o.setVisibility(4);
    this.z = ((ImageView)findViewById(2131446159));
    super.c();
  }
  
  public void d()
  {
    if (this.p == null)
    {
      AVGameLottieHelper.a(getContext(), "avgame_guess_song_playing/data.json", "avgame_guess_song_playing/images/", 140, 140, new GuessSongClickStageView.3(this));
      return;
    }
    e();
  }
  
  protected void f()
  {
    Object localObject = GameEngine.a().s();
    if (!((EngineData)localObject).N())
    {
      super.f();
      return;
    }
    localObject = ((EngineData)localObject).f();
    if ((localObject != null) && (!TextUtils.isEmpty(((GameItem)localObject).u))) {
      localObject = ((GameItem)localObject).u;
    } else {
      localObject = null;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("checkLogo = ");
      localStringBuilder.append((String)localObject);
      QLog.d("GuessSongClickStageView", 2, localStringBuilder.toString());
    }
    if (localObject == null)
    {
      this.z.setImageDrawable(null);
      return;
    }
    localObject = URLDrawable.getDrawable((String)localObject);
    this.z.setImageDrawable((Drawable)localObject);
  }
  
  public void setFontStyle(FontStyleConfig paramFontStyleConfig)
  {
    super.setFontStyle(paramFontStyleConfig);
    this.e.setTextSize(paramFontStyleConfig.h);
    this.e.setTextColor(Color.parseColor(paramFontStyleConfig.g));
    paramFontStyleConfig = new QuestionOptionItemConfig(paramFontStyleConfig.l, Color.parseColor(paramFontStyleConfig.m), Color.parseColor(paramFontStyleConfig.k), paramFontStyleConfig.B, Color.parseColor(paramFontStyleConfig.A), paramFontStyleConfig.D, Color.parseColor(paramFontStyleConfig.C));
    this.a.setConfig(paramFontStyleConfig);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gameroom.stage.guesssong.GuessSongClickStageView
 * JD-Core Version:    0.7.0.1
 */