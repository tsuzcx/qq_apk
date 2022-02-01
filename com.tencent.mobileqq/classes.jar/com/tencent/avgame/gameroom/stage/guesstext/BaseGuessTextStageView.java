package com.tencent.avgame.gameroom.stage.guesstext;

import android.content.Context;
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
import com.tencent.avgame.gamelogic.ITopic;
import com.tencent.avgame.gamelogic.data.Player;
import com.tencent.avgame.gamelogic.data.TopicTextGuess;
import com.tencent.avgame.gamelogic.gameres.AvGameResDownloadUtil;
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
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import java.util.ArrayList;

public class BaseGuessTextStageView
  extends BaseGuessClickStageView
{
  IGameStagePresenter c;
  TextView d;
  TextView e;
  ImageView f;
  View g;
  TextView h;
  View i;
  TextView j;
  boolean k = false;
  public Runnable l = new BaseGuessTextStageView.1(this);
  AVGameText m;
  AVGameText n;
  View o;
  public Runnable p = new BaseGuessTextStageView.2(this);
  public Runnable q = new BaseGuessTextStageView.3(this);
  TextView r;
  ImageView s;
  View t;
  boolean u = false;
  ArrayList<Pair<Integer, String>> v;
  int w = 0;
  public Runnable x = new BaseGuessTextStageView.4(this);
  
  public BaseGuessTextStageView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public BaseGuessTextStageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public BaseGuessTextStageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    c();
  }
  
  public void a(ITopic paramITopic)
  {
    b(paramITopic);
    b((TopicTextGuess)paramITopic);
  }
  
  public void a(Player paramPlayer, AVGameUserInfo paramAVGameUserInfo)
  {
    if (GameRoomViewLayoutParamsDef.w <= 0)
    {
      this.t.setVisibility(0);
      return;
    }
    this.t.setVisibility(8);
  }
  
  protected void a(TopicTextGuess paramTopicTextGuess)
  {
    Object localObject = paramTopicTextGuess.c();
    paramTopicTextGuess = paramTopicTextGuess.e();
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mUseMemoryCache = true;
      localObject = URLDrawable.getDrawable((String)localObject, localURLDrawableOptions);
      this.s.setImageDrawable((Drawable)localObject);
      this.s.setVisibility(0);
    }
    else
    {
      this.s.setVisibility(8);
    }
    localObject = this.r;
    if (localObject != null)
    {
      ((TextView)localObject).setText(paramTopicTextGuess);
      this.r.setVisibility(0);
    }
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
    this.e.getViewTreeObserver().addOnGlobalLayoutListener(new BaseGuessTextStageView.5(this, paramString));
    ThreadManager.getUIHandlerV2().postDelayed(this.l, 3000L);
  }
  
  public void a(boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      TextView localTextView = this.r;
      if (localTextView != null)
      {
        localTextView.setVisibility(4);
        this.s.setVisibility(4);
      }
    }
    int i1;
    if (paramBoolean) {
      i1 = 0;
    } else {
      i1 = 8;
    }
    setVisibility(i1);
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
  
  public boolean a()
  {
    return this.k;
  }
  
  protected void b(TopicTextGuess paramTopicTextGuess)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onGuessTextStart() topicSong:");
      ((StringBuilder)localObject).append(paramTopicTextGuess);
      QLog.i("BaseGuessTextStageView", 2, ((StringBuilder)localObject).toString());
    }
    if (paramTopicTextGuess == null)
    {
      QLog.e("BaseGuessTextStageView", 1, "onGuessTextStart()  topicText empty");
      ThreadManager.getUIHandlerV2().removeCallbacks(this.x);
      ReportController.b(null, "dc00898", "", "", "0X800B1F2", "0X800B1F2", 0, 0, "", "", "", "");
      return;
    }
    if (TextUtils.isEmpty(paramTopicTextGuess.e()))
    {
      QLog.e("BaseGuessTextStageView", 1, "onGuessTextStart() illegal topicText getContent empty");
      ReportController.b(null, "dc00898", "", "", "0X800B1F2", "0X800B1F2", 0, 0, "", "", "", "");
      return;
    }
    ReportController.b(null, "dc00898", "", "", "0X800B1F1", "0X800B1F1", 0, 0, "", "", "", "");
    a(paramTopicTextGuess);
    Object localObject = paramTopicTextGuess.g();
    if ((localObject[0] != null) && (localObject[0].length() != 0) && (localObject[1] != null) && (localObject[1].length() != 0) && (localObject[2] != null) && (localObject[2].length() != 0))
    {
      this.m.setAttribute("#FFFFFF", localObject[2]);
      this.m.setText(localObject[0]);
      this.n.setAttribute("#FFC000", "#FFFFFF");
      this.n.setText(localObject[1]);
      ThreadManager.getUIHandlerV2().post(this.q);
    }
    else
    {
      ThreadManager.getUIHandlerV2().removeCallbacks(this.p);
      ThreadManager.getUIHandlerV2().post(this.p);
    }
    this.v = paramTopicTextGuess.k;
    localObject = this.v;
    if ((localObject != null) && (((ArrayList)localObject).size() > 0))
    {
      this.w = 0;
      ThreadManager.getUIHandlerV2().postDelayed(this.x, ((Integer)((Pair)this.v.get(this.w)).first).intValue() * 1000);
    }
    paramTopicTextGuess = paramTopicTextGuess.r;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onGuessTextStart() businessAdsTips:");
      ((StringBuilder)localObject).append(paramTopicTextGuess);
      QLog.i("BaseGuessTextStageView", 2, ((StringBuilder)localObject).toString());
    }
    if (!TextUtils.isEmpty(paramTopicTextGuess)) {
      this.c.a().a().b(paramTopicTextGuess);
    }
  }
  
  public void b(IStagePresenter paramIStagePresenter)
  {
    this.c.a(paramIStagePresenter);
    a(paramIStagePresenter);
  }
  
  protected void c()
  {
    this.h = ((TextView)findViewById(2131447504));
    this.j = ((TextView)findViewById(2131447559));
    this.i = findViewById(2131447534);
    ((RelativeLayout.LayoutParams)this.i.getLayoutParams()).topMargin = GameRoomViewLayoutParamsDef.x;
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
    this.j.setTextSize(paramFontStyleConfig.b);
    this.j.setTextColor(Color.parseColor(paramFontStyleConfig.a));
    this.r.setTextSize(paramFontStyleConfig.f);
    this.r.setTextColor(Color.parseColor(paramFontStyleConfig.e));
    ImageView localImageView = this.f;
    if ((localImageView instanceof CountDownClockNumLottieView)) {
      ((CountDownClockNumLottieView)localImageView).setParams(Color.parseColor(paramFontStyleConfig.c), ViewUtils.dip2px(paramFontStyleConfig.d));
    }
  }
  
  public void setSpecialMode(boolean paramBoolean)
  {
    this.k = paramBoolean;
  }
  
  public void setTitleCenter(String paramString)
  {
    TextView localTextView = this.h;
    if (localTextView != null) {
      localTextView.setText(paramString);
    }
  }
  
  public void setTitleRight(String paramString)
  {
    TextView localTextView = this.j;
    if (localTextView != null) {
      localTextView.setText(paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gameroom.stage.guesstext.BaseGuessTextStageView
 * JD-Core Version:    0.7.0.1
 */