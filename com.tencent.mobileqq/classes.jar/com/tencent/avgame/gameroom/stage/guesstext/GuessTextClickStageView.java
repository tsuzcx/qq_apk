package com.tencent.avgame.gameroom.stage.guesstext;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Handler;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.avgame.data.FontStyleConfig;
import com.tencent.avgame.gamelogic.data.TopicTextGuess;
import com.tencent.avgame.gamelogic.gameres.AvGameResDownloadUtil;
import com.tencent.avgame.gameroom.IGameRoomPresenter;
import com.tencent.avgame.gameroom.festivalstage.questionoption.QuestionOptionItemConfig;
import com.tencent.avgame.gameroom.festivalstage.questionoption.QuestionOptionsView;
import com.tencent.avgame.gameroom.stage.IGameStagePresenter;
import com.tencent.avgame.gameroom.stage.IStagePresenter;
import com.tencent.avgame.ui.AVGameText;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import java.util.ArrayList;

public class GuessTextClickStageView
  extends BaseGuessTextStageView
{
  public Runnable y = new GuessTextClickStageView.1(this);
  public Runnable z = new GuessTextClickStageView.2(this);
  
  public GuessTextClickStageView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public GuessTextClickStageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public GuessTextClickStageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
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
      return;
    }
    this.f.setVisibility(0);
    this.g.setVisibility(8);
    if (!this.u)
    {
      String str = this.c.a().a().s();
      if (!TextUtils.isEmpty(str)) {
        setBackgroundDrawable(URLDrawable.getDrawable(str));
      } else {
        setBackgroundDrawable(AvGameResDownloadUtil.a("avgame_float_act_guess_place_holder@2x.png"));
      }
      this.u = true;
    }
  }
  
  protected void b(TopicTextGuess paramTopicTextGuess)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("onGuessTextStart() topicSong:");
      localStringBuilder.append(paramTopicTextGuess);
      QLog.i("GuessTextClickStageView", 2, localStringBuilder.toString());
    }
    if (paramTopicTextGuess == null)
    {
      QLog.e("GuessTextClickStageView", 1, "onGuessTextStart()  topicText empty");
      ThreadManager.getUIHandlerV2().removeCallbacks(this.z);
      return;
    }
    if (TextUtils.isEmpty(paramTopicTextGuess.e())) {
      return;
    }
    a(paramTopicTextGuess);
    this.v = paramTopicTextGuess.k;
    if ((this.v != null) && (this.v.size() > 0))
    {
      this.w = 0;
      ThreadManager.getUIHandlerV2().postDelayed(this.z, ((Integer)((Pair)this.v.get(this.w)).first).intValue() * 1000);
    }
    paramTopicTextGuess = paramTopicTextGuess.r;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("onUpdateCurTopic() businessAdsTips:");
      localStringBuilder.append(paramTopicTextGuess);
      QLog.i("GuessTextClickStageView", 2, localStringBuilder.toString());
    }
    if (!TextUtils.isEmpty(paramTopicTextGuess)) {
      this.c.a().a().b(paramTopicTextGuess);
    }
  }
  
  protected void c()
  {
    LayoutInflater.from(getContext()).inflate(2131624287, this, true);
    this.e = ((TextView)findViewById(2131448811));
    this.f = ((ImageView)findViewById(2131447536));
    this.g = findViewById(2131437582);
    this.r = ((TextView)findViewById(2131448507));
    this.r.setVisibility(4);
    this.s = ((ImageView)findViewById(2131448509));
    if (this.s != null) {
      this.s.setVisibility(8);
    }
    this.m = ((AVGameText)findViewById(2131448302));
    this.n = ((AVGameText)findViewById(2131448303));
    this.o = findViewById(2131437420);
    this.t = findViewById(2131434340);
    this.t.setVisibility(8);
    this.c = new GuessTextClickStagePresenter(this);
    this.f.setVisibility(4);
    this.g.setVisibility(4);
    super.c();
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
 * Qualified Name:     com.tencent.avgame.gameroom.stage.guesstext.GuessTextClickStageView
 * JD-Core Version:    0.7.0.1
 */