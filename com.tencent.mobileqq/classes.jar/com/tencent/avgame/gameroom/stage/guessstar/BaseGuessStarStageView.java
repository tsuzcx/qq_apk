package com.tencent.avgame.gameroom.stage.guessstar;

import android.content.Context;
import android.graphics.Color;
import android.os.Handler;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.avgame.data.FontStyleConfig;
import com.tencent.avgame.gamelogic.ITopic;
import com.tencent.avgame.gamelogic.data.Player;
import com.tencent.avgame.gamelogic.data.TopicOperGuessVideo;
import com.tencent.avgame.gameroom.GameRoomViewLayoutParamsDef;
import com.tencent.avgame.gameroom.IGameRoomPresenter;
import com.tencent.avgame.gameroom.stage.IGameStagePresenter;
import com.tencent.avgame.gameroom.stage.IStagePresenter;
import com.tencent.avgame.gameroom.stage.IStageRecordPresenter;
import com.tencent.avgame.gameroom.stage.base.BaseGuessClickStageView;
import com.tencent.avgame.gameroom.stage.util.CountDownClockNumLottieView;
import com.tencent.avgame.session.AVGameUserInfo;
import com.tencent.avgame.ui.AVGameText;
import com.tencent.avgame.util.UiUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import java.util.ArrayList;

public class BaseGuessStarStageView
  extends BaseGuessClickStageView
{
  IGameStagePresenter c;
  IStageRecordPresenter d;
  TextView e;
  TextView f;
  LinearLayout g;
  ImageView h;
  View i;
  AVGameText j;
  AVGameText k;
  View l;
  TextView m;
  View n;
  TextView o;
  boolean p = false;
  ArrayList<Pair<Integer, String>> q;
  int r = 0;
  public Runnable s = new BaseGuessStarStageView.1(this);
  public Runnable t = new BaseGuessStarStageView.2(this);
  public Runnable u = new BaseGuessStarStageView.3(this);
  
  public BaseGuessStarStageView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public BaseGuessStarStageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public BaseGuessStarStageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    c();
  }
  
  public void a(ITopic paramITopic)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("onUpdateCurTopic topic = ");
      ((StringBuilder)localObject1).append(paramITopic);
      QLog.d("BaseGuessStarStageView", 2, ((StringBuilder)localObject1).toString());
    }
    if (paramITopic == null) {
      return;
    }
    Object localObject1 = (TopicOperGuessVideo)paramITopic;
    Object localObject2 = ((TopicOperGuessVideo)localObject1).g();
    if ((localObject2[0] != null) && (localObject2[0].length() != 0) && (localObject2[1] != null) && (localObject2[1].length() != 0) && (localObject2[2] != null) && (localObject2[2].length() != 0))
    {
      this.j.setAttribute("#FFFFFF", localObject2[2]);
      this.j.setText(localObject2[0]);
      this.k.setAttribute("#FFC000", "#FFFFFF");
      this.k.setText(localObject2[1]);
      ThreadManager.getUIHandlerV2().post(this.t);
    }
    else
    {
      ThreadManager.getUIHandlerV2().removeCallbacks(this.u);
      ThreadManager.getUIHandlerV2().post(this.u);
    }
    this.q = ((TopicOperGuessVideo)localObject1).k;
    localObject2 = this.q;
    if ((localObject2 != null) && (((ArrayList)localObject2).size() > 0))
    {
      this.r = 0;
      ThreadManager.getUIHandlerV2().postDelayed(this.s, ((Integer)((Pair)this.q.get(this.r)).first).intValue() * 1000);
    }
    b(paramITopic);
    paramITopic = ((TopicOperGuessVideo)localObject1).r;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("onUpdateCurTopic() businessAdsTips:");
      ((StringBuilder)localObject1).append(paramITopic);
      QLog.i("BaseGuessStarStageView", 2, ((StringBuilder)localObject1).toString());
    }
    if (!TextUtils.isEmpty(paramITopic)) {
      this.c.a().a().b(paramITopic);
    }
  }
  
  public void a(Player paramPlayer, AVGameUserInfo paramAVGameUserInfo)
  {
    if (GameRoomViewLayoutParamsDef.w <= 0)
    {
      this.i.setVisibility(0);
      return;
    }
    this.i.setVisibility(8);
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("showTopicTips tip = ");
      localStringBuilder.append(paramString);
      QLog.i("BaseGuessStarStageView", 2, localStringBuilder.toString());
    }
    this.e.setText(paramString);
    if ((paramString != null) && (paramString.length() > 5)) {
      this.e.setTextSize(0, UiUtils.d());
    } else {
      this.e.setTextSize(0, UiUtils.c());
    }
    this.e.setText(paramString);
    this.e.getViewTreeObserver().addOnGlobalLayoutListener(new BaseGuessStarStageView.4(this, paramString));
  }
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onShowGameContent ");
      localStringBuilder.append(paramBoolean);
      QLog.d("BaseGuessStarStageView", 2, localStringBuilder.toString());
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
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onShowGameBottomWidget ,isPlayerSelf = ");
      ((StringBuilder)localObject).append(paramBoolean1);
      ((StringBuilder)localObject).append(",show = ");
      ((StringBuilder)localObject).append(paramBoolean2);
      QLog.d("BaseGuessStarStageView", 2, ((StringBuilder)localObject).toString());
    }
    if (!paramBoolean2)
    {
      this.h.setVisibility(4);
      this.g.setVisibility(8);
    }
    else
    {
      this.h.setVisibility(0);
      this.g.setVisibility(8);
    }
    Object localObject = this.d;
    if (localObject != null) {
      ((IStageRecordPresenter)localObject).a(this.g);
    }
  }
  
  public boolean a()
  {
    return this.p;
  }
  
  public void b(IStagePresenter paramIStagePresenter)
  {
    this.c.a(paramIStagePresenter);
    a(paramIStagePresenter);
  }
  
  protected void c()
  {
    this.m = ((TextView)findViewById(2131447504));
    this.o = ((TextView)findViewById(2131447559));
    this.n = findViewById(2131447534);
    ((RelativeLayout.LayoutParams)this.n.getLayoutParams()).topMargin = GameRoomViewLayoutParamsDef.x;
  }
  
  public IGameStagePresenter getPresenter()
  {
    return this.c;
  }
  
  public ImageView getTopicClockView()
  {
    return this.h;
  }
  
  public void setFontStyle(FontStyleConfig paramFontStyleConfig)
  {
    this.o.setTextSize(paramFontStyleConfig.b);
    this.o.setTextColor(Color.parseColor(paramFontStyleConfig.a));
    ImageView localImageView = this.h;
    if ((localImageView instanceof CountDownClockNumLottieView)) {
      ((CountDownClockNumLottieView)localImageView).setParams(Color.parseColor(paramFontStyleConfig.c), ViewUtils.dip2px(paramFontStyleConfig.d));
    }
  }
  
  public void setSpecialMode(boolean paramBoolean)
  {
    this.p = paramBoolean;
  }
  
  public void setStageRecordPresenter(IStageRecordPresenter paramIStageRecordPresenter)
  {
    this.d = paramIStageRecordPresenter;
  }
  
  public void setTitleCenter(String paramString)
  {
    TextView localTextView = this.m;
    if (localTextView != null) {
      localTextView.setText(paramString);
    }
  }
  
  public void setTitleRight(String paramString)
  {
    TextView localTextView = this.o;
    if (localTextView != null) {
      localTextView.setText(paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gameroom.stage.guessstar.BaseGuessStarStageView
 * JD-Core Version:    0.7.0.1
 */