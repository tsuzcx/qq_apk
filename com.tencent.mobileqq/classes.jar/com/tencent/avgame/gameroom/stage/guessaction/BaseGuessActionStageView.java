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
  View jdField_a_of_type_AndroidViewView;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  IGameStagePresenter jdField_a_of_type_ComTencentAvgameGameroomStageIGameStagePresenter;
  IGameStageView.SwitchTopicClickListener jdField_a_of_type_ComTencentAvgameGameroomStageIGameStageView$SwitchTopicClickListener;
  AVGameText jdField_a_of_type_ComTencentAvgameUiAVGameText;
  public Runnable a;
  boolean jdField_a_of_type_Boolean = false;
  View jdField_b_of_type_AndroidViewView;
  ImageView jdField_b_of_type_AndroidWidgetImageView;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  AVGameText jdField_b_of_type_ComTencentAvgameUiAVGameText;
  public Runnable b;
  boolean jdField_b_of_type_Boolean = false;
  TextView c;
  
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
    this.jdField_a_of_type_JavaLangRunnable = new BaseGuessActionStageView.1(this);
    this.jdField_b_of_type_JavaLangRunnable = new BaseGuessActionStageView.2(this);
    a();
  }
  
  public View a()
  {
    return this.jdField_a_of_type_AndroidWidgetLinearLayout;
  }
  
  public ImageView a()
  {
    return this.jdField_b_of_type_AndroidWidgetImageView;
  }
  
  public IGameStagePresenter a()
  {
    return this.jdField_a_of_type_ComTencentAvgameGameroomStageIGameStagePresenter;
  }
  
  protected void a() {}
  
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
    Object localObject = paramITopic.c();
    if ((localObject != null) && (((String)localObject).length() > 5)) {
      this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(0, UiUtils.d());
    } else {
      this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(0, UiUtils.c());
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
    this.jdField_a_of_type_AndroidWidgetTextView.getViewTreeObserver().addOnGlobalLayoutListener(new BaseGuessActionStageView.3(this, (String)localObject));
    localObject = this.jdField_a_of_type_AndroidWidgetLinearLayout;
    if ((localObject != null) && (((LinearLayout)localObject).getVisibility() != 0))
    {
      localObject = paramITopic.a();
      if ((localObject[0] != null) && (localObject[0].length() != 0) && (localObject[1] != null) && (localObject[1].length() != 0) && (localObject[2] != null) && (localObject[2].length() != 0))
      {
        boolean bool;
        if (paramITopic.a() != 0L) {
          bool = true;
        } else {
          bool = false;
        }
        this.jdField_b_of_type_Boolean = bool;
        this.jdField_a_of_type_ComTencentAvgameUiAVGameText.setAttribute("#FFFFFF", localObject[2]);
        this.jdField_a_of_type_ComTencentAvgameUiAVGameText.setText(localObject[0]);
        this.jdField_b_of_type_ComTencentAvgameUiAVGameText.setAttribute("#FFC000", "#FFFFFF");
        this.jdField_b_of_type_ComTencentAvgameUiAVGameText.setText(localObject[1]);
        if (this.jdField_b_of_type_Boolean)
        {
          ThreadManager.getUIHandlerV2().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
          ThreadManager.getUIHandlerV2().removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
          ThreadManager.getUIHandlerV2().post(this.jdField_b_of_type_JavaLangRunnable);
          ThreadManager.getUIHandlerV2().postDelayed(this.jdField_a_of_type_JavaLangRunnable, 1600L);
          return;
        }
        ThreadManager.getUIHandlerV2().post(this.jdField_a_of_type_JavaLangRunnable);
        return;
      }
      ThreadManager.getUIHandlerV2().removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
      ThreadManager.getUIHandlerV2().post(this.jdField_b_of_type_JavaLangRunnable);
    }
  }
  
  public void a(Player paramPlayer, AVGameUserInfo paramAVGameUserInfo)
  {
    if ((GameRoomViewLayoutParamsDef.w <= 0) && (paramPlayer != null) && (paramAVGameUserInfo != null) && (paramAVGameUserInfo.hasCameraVideo()))
    {
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      return;
    }
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
  }
  
  public void a(IStagePresenter paramIStagePresenter)
  {
    this.jdField_a_of_type_ComTencentAvgameGameroomStageIGameStagePresenter.a(paramIStagePresenter);
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
    int i;
    if (paramBoolean) {
      i = 0;
    } else {
      i = 8;
    }
    setVisibility(i);
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
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(4);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(4);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
      return;
    }
    this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
    if (paramBoolean1)
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-1);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(4);
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public void setFontStyle(FontStyleConfig paramFontStyleConfig) {}
  
  public void setOnSwitchTopicClickListener(IGameStageView.SwitchTopicClickListener paramSwitchTopicClickListener)
  {
    this.jdField_a_of_type_ComTencentAvgameGameroomStageIGameStageView$SwitchTopicClickListener = paramSwitchTopicClickListener;
  }
  
  public void setSpecialMode(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void setTitleCenter(String paramString)
  {
    TextView localTextView = this.c;
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