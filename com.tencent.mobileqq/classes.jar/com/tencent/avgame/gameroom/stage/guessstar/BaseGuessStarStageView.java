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
import com.tencent.avgame.gameroom.stage.util.FontStyleConfig;
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
  int jdField_a_of_type_Int = 0;
  View jdField_a_of_type_AndroidViewView;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  IGameStagePresenter jdField_a_of_type_ComTencentAvgameGameroomStageIGameStagePresenter;
  IStageRecordPresenter jdField_a_of_type_ComTencentAvgameGameroomStageIStageRecordPresenter;
  AVGameText jdField_a_of_type_ComTencentAvgameUiAVGameText;
  public Runnable a;
  ArrayList<Pair<Integer, String>> jdField_a_of_type_JavaUtilArrayList;
  boolean jdField_a_of_type_Boolean = false;
  View jdField_b_of_type_AndroidViewView;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  AVGameText jdField_b_of_type_ComTencentAvgameUiAVGameText;
  public Runnable b;
  View jdField_c_of_type_AndroidViewView;
  TextView jdField_c_of_type_AndroidWidgetTextView;
  public Runnable c;
  TextView d;
  
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
    this.jdField_a_of_type_JavaLangRunnable = new BaseGuessStarStageView.1(this);
    this.jdField_b_of_type_JavaLangRunnable = new BaseGuessStarStageView.2(this);
    this.jdField_c_of_type_JavaLangRunnable = new BaseGuessStarStageView.3(this);
    b();
  }
  
  public ImageView a()
  {
    return this.jdField_a_of_type_AndroidWidgetImageView;
  }
  
  public IGameStagePresenter a()
  {
    return this.jdField_a_of_type_ComTencentAvgameGameroomStageIGameStagePresenter;
  }
  
  public void a(ITopic paramITopic)
  {
    if (QLog.isColorLevel()) {
      QLog.d("BaseGuessStarStageView", 2, "onUpdateCurTopic topic = " + paramITopic);
    }
    if (paramITopic == null) {
      return;
    }
    TopicOperGuessVideo localTopicOperGuessVideo = (TopicOperGuessVideo)paramITopic;
    String[] arrayOfString = localTopicOperGuessVideo.a();
    if ((arrayOfString[0] != null) && (arrayOfString[0].length() != 0) && (arrayOfString[1] != null) && (arrayOfString[1].length() != 0) && (arrayOfString[2] != null) && (arrayOfString[2].length() != 0))
    {
      this.jdField_a_of_type_ComTencentAvgameUiAVGameText.setAttribute("#FFFFFF", arrayOfString[2]);
      this.jdField_a_of_type_ComTencentAvgameUiAVGameText.setText(arrayOfString[0]);
      this.jdField_b_of_type_ComTencentAvgameUiAVGameText.setAttribute("#FFC000", "#FFFFFF");
      this.jdField_b_of_type_ComTencentAvgameUiAVGameText.setText(arrayOfString[1]);
      ThreadManager.getUIHandlerV2().post(this.jdField_b_of_type_JavaLangRunnable);
    }
    for (;;)
    {
      this.jdField_a_of_type_JavaUtilArrayList = localTopicOperGuessVideo.jdField_a_of_type_JavaUtilArrayList;
      if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > 0))
      {
        this.jdField_a_of_type_Int = 0;
        ThreadManager.getUIHandlerV2().postDelayed(this.jdField_a_of_type_JavaLangRunnable, ((Integer)((Pair)this.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_Int)).first).intValue() * 1000);
      }
      b(paramITopic);
      paramITopic = localTopicOperGuessVideo.c;
      if (QLog.isColorLevel()) {
        QLog.i("BaseGuessStarStageView", 2, "onUpdateCurTopic() businessAdsTips:" + paramITopic);
      }
      if (TextUtils.isEmpty(paramITopic)) {
        break;
      }
      this.jdField_a_of_type_ComTencentAvgameGameroomStageIGameStagePresenter.a().a().a(paramITopic);
      return;
      ThreadManager.getUIHandlerV2().removeCallbacks(this.jdField_c_of_type_JavaLangRunnable);
      ThreadManager.getUIHandlerV2().post(this.jdField_c_of_type_JavaLangRunnable);
    }
  }
  
  public void a(Player paramPlayer, AVGameUserInfo paramAVGameUserInfo)
  {
    if (GameRoomViewLayoutParamsDef.l <= 0)
    {
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      return;
    }
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("BaseGuessStarStageView", 2, "showTopicTips tip = " + paramString);
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString);
    if ((paramString != null) && (paramString.length() > 5)) {
      this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(0, UiUtils.d());
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString);
      this.jdField_a_of_type_AndroidWidgetTextView.getViewTreeObserver().addOnGlobalLayoutListener(new BaseGuessStarStageView.4(this, paramString));
      return;
      this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(0, UiUtils.c());
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("BaseGuessStarStageView", 2, "onShowGameContent " + paramBoolean);
    }
    if (paramBoolean) {}
    for (int i = 0;; i = 8)
    {
      setVisibility(i);
      return;
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("BaseGuessStarStageView", 2, "onShowGameBottomWidget ,isPlayerSelf = " + paramBoolean1 + ",show = " + paramBoolean2);
    }
    if (!paramBoolean2)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentAvgameGameroomStageIStageRecordPresenter != null) {
        this.jdField_a_of_type_ComTencentAvgameGameroomStageIStageRecordPresenter.a(this.jdField_a_of_type_AndroidWidgetLinearLayout);
      }
      return;
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  protected void b()
  {
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131379469));
    this.d = ((TextView)findViewById(2131379510));
    this.jdField_c_of_type_AndroidViewView = findViewById(2131379487);
    ((RelativeLayout.LayoutParams)this.jdField_c_of_type_AndroidViewView.getLayoutParams()).topMargin = GameRoomViewLayoutParamsDef.m;
  }
  
  public void b(IStagePresenter paramIStagePresenter)
  {
    this.jdField_a_of_type_ComTencentAvgameGameroomStageIGameStagePresenter.a(paramIStagePresenter);
    a(paramIStagePresenter);
  }
  
  public void setFontStyle(FontStyleConfig paramFontStyleConfig)
  {
    this.d.setTextSize(paramFontStyleConfig.jdField_a_of_type_Int);
    this.d.setTextColor(Color.parseColor(paramFontStyleConfig.jdField_a_of_type_JavaLangString));
    if ((this.jdField_a_of_type_AndroidWidgetImageView instanceof CountDownClockNumLottieView)) {
      ((CountDownClockNumLottieView)this.jdField_a_of_type_AndroidWidgetImageView).setParams(Color.parseColor(paramFontStyleConfig.jdField_b_of_type_JavaLangString), ViewUtils.a(paramFontStyleConfig.jdField_b_of_type_Int));
    }
  }
  
  public void setSpecialMode(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void setStageRecordPresenter(IStageRecordPresenter paramIStageRecordPresenter)
  {
    this.jdField_a_of_type_ComTencentAvgameGameroomStageIStageRecordPresenter = paramIStageRecordPresenter;
  }
  
  public void setTitleCenter(String paramString)
  {
    if (this.jdField_c_of_type_AndroidWidgetTextView != null) {
      this.jdField_c_of_type_AndroidWidgetTextView.setText(paramString);
    }
  }
  
  public void setTitleRight(String paramString)
  {
    if (this.d != null) {
      this.d.setText(paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.avgame.gameroom.stage.guessstar.BaseGuessStarStageView
 * JD-Core Version:    0.7.0.1
 */