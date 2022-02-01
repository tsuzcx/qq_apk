package com.tencent.avgame.gameroom.stage.guessaction;

import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.avgame.data.FontStyleConfig;
import com.tencent.avgame.gamelogic.ITopic;
import com.tencent.avgame.gamelogic.data.Player;
import com.tencent.avgame.gameroom.GameRoomViewLayoutParamsDef;
import com.tencent.avgame.gameroom.stage.IGameStagePresenter;
import com.tencent.avgame.gameroom.stage.IGameStageView;
import com.tencent.avgame.gameroom.stage.IGameStageView.SwitchTopicClickListener;
import com.tencent.avgame.gameroom.stage.IStagePresenter;
import com.tencent.avgame.session.AVGameUserInfo;
import com.tencent.avgame.ui.AVGameText;
import com.tencent.avgame.util.UiUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;

public class BaseGuessActionStageView
  extends RelativeLayout
  implements IGameStageView
{
  IGameStagePresenter a;
  IGameStageView.SwitchTopicClickListener b;
  TextView c;
  TextView d;
  ImageView e;
  LinearLayout f;
  ImageView g;
  View h;
  AVGameText i;
  AVGameText j;
  View k;
  TextView l;
  boolean m = false;
  boolean n = false;
  public Runnable o = new BaseGuessActionStageView.1(this);
  public Runnable p = new BaseGuessActionStageView.2(this);
  
  public BaseGuessActionStageView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public BaseGuessActionStageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public BaseGuessActionStageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    b();
  }
  
  public void a(ITopic paramITopic)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onUpdateCurTopic topic = ");
      ((StringBuilder)localObject).append(paramITopic);
      QLog.d("BaseGuessActionStageView", 2, ((StringBuilder)localObject).toString());
    }
    if (paramITopic == null) {
      return;
    }
    ReportController.b(null, "dc00898", "", "", "0X800B04D", "0X800B04D", 1, 0, "", "", "", "");
    Object localObject = paramITopic.e();
    if ((localObject != null) && (((String)localObject).length() > 5)) {
      this.c.setTextSize(0, UiUtils.d());
    } else {
      this.c.setTextSize(0, UiUtils.c());
    }
    this.c.setText((CharSequence)localObject);
    this.c.getViewTreeObserver().addOnGlobalLayoutListener(new BaseGuessActionStageView.3(this, (String)localObject));
    localObject = this.f;
    if ((localObject != null) && (((LinearLayout)localObject).getVisibility() != 0))
    {
      localObject = paramITopic.g();
      if ((localObject[0] != null) && (localObject[0].length() != 0) && (localObject[1] != null) && (localObject[1].length() != 0) && (localObject[2] != null) && (localObject[2].length() != 0))
      {
        boolean bool;
        if (paramITopic.h() != 0L) {
          bool = true;
        } else {
          bool = false;
        }
        this.n = bool;
        this.i.setAttribute("#FFFFFF", localObject[2]);
        this.i.setText(localObject[0]);
        this.j.setAttribute("#FFC000", "#FFFFFF");
        this.j.setText(localObject[1]);
        if (this.n)
        {
          ThreadManager.getUIHandlerV2().removeCallbacks(this.o);
          ThreadManager.getUIHandlerV2().removeCallbacks(this.p);
          ThreadManager.getUIHandlerV2().post(this.p);
          ThreadManager.getUIHandlerV2().postDelayed(this.o, 1600L);
          return;
        }
        ThreadManager.getUIHandlerV2().post(this.o);
        return;
      }
      ThreadManager.getUIHandlerV2().removeCallbacks(this.p);
      ThreadManager.getUIHandlerV2().post(this.p);
    }
  }
  
  public void a(Player paramPlayer, AVGameUserInfo paramAVGameUserInfo)
  {
    if ((GameRoomViewLayoutParamsDef.w <= 0) && (paramPlayer != null) && (paramAVGameUserInfo != null) && (paramAVGameUserInfo.hasCameraVideo()))
    {
      this.h.setVisibility(0);
      return;
    }
    this.h.setVisibility(8);
  }
  
  public void a(IStagePresenter paramIStagePresenter)
  {
    this.a.a(paramIStagePresenter);
  }
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onShowGameContent ");
      localStringBuilder.append(paramBoolean);
      QLog.d("BaseGuessActionStageView", 2, localStringBuilder.toString());
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
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onShowGameBottomWidget ,isPlayerSelf = ");
      localStringBuilder.append(paramBoolean1);
      localStringBuilder.append(",show = ");
      localStringBuilder.append(paramBoolean2);
      QLog.d("BaseGuessActionStageView", 2, localStringBuilder.toString());
    }
    if (!paramBoolean2)
    {
      this.g.setVisibility(4);
      this.f.setVisibility(4);
      this.e.setVisibility(4);
      return;
    }
    this.g.setVisibility(0);
    if (paramBoolean1)
    {
      this.f.setVisibility(0);
      this.c.setTextColor(-1);
      this.e.setVisibility(0);
      return;
    }
    this.f.setVisibility(4);
    this.e.setVisibility(4);
  }
  
  public boolean a()
  {
    return this.m;
  }
  
  protected void b() {}
  
  public IGameStagePresenter getPresenter()
  {
    return this.a;
  }
  
  public ImageView getTopicClockView()
  {
    return this.g;
  }
  
  public View getTopicWrapperView()
  {
    return this.f;
  }
  
  public void setFontStyle(FontStyleConfig paramFontStyleConfig) {}
  
  public void setOnSwitchTopicClickListener(IGameStageView.SwitchTopicClickListener paramSwitchTopicClickListener)
  {
    this.b = paramSwitchTopicClickListener;
  }
  
  public void setSpecialMode(boolean paramBoolean)
  {
    this.m = paramBoolean;
  }
  
  public void setTitleCenter(String paramString)
  {
    TextView localTextView = this.l;
    if (localTextView != null) {
      localTextView.setText(paramString);
    }
  }
  
  public void setTitleRight(String paramString) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gameroom.stage.guessaction.BaseGuessActionStageView
 * JD-Core Version:    0.7.0.1
 */