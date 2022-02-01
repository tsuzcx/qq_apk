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
import com.tencent.avgame.gamelogic.ITopic;
import com.tencent.avgame.gamelogic.data.Player;
import com.tencent.avgame.gamelogic.data.TopicTextGuess;
import com.tencent.avgame.gamelogic.gameres.AvGameResDownloadManager;
import com.tencent.avgame.gameroom.GameRoomViewLayoutParamsDef;
import com.tencent.avgame.gameroom.IGameRoomPresenter;
import com.tencent.avgame.gameroom.stage.IGameStagePresenter;
import com.tencent.avgame.gameroom.stage.IStagePresenter;
import com.tencent.avgame.gameroom.stage.base.BaseGuessClickStageView;
import com.tencent.avgame.gameroom.stage.util.CountDownClockNumLottieView;
import com.tencent.avgame.gameroom.stage.util.FontStyleConfig;
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
  int jdField_a_of_type_Int = 0;
  View jdField_a_of_type_AndroidViewView;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  IGameStagePresenter jdField_a_of_type_ComTencentAvgameGameroomStageIGameStagePresenter;
  AVGameText jdField_a_of_type_ComTencentAvgameUiAVGameText;
  public Runnable a;
  ArrayList<Pair<Integer, String>> jdField_a_of_type_JavaUtilArrayList;
  boolean jdField_a_of_type_Boolean = false;
  View jdField_b_of_type_AndroidViewView;
  ImageView jdField_b_of_type_AndroidWidgetImageView;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  AVGameText jdField_b_of_type_ComTencentAvgameUiAVGameText;
  public Runnable b;
  boolean jdField_b_of_type_Boolean = false;
  View jdField_c_of_type_AndroidViewView;
  TextView jdField_c_of_type_AndroidWidgetTextView;
  public Runnable c;
  View jdField_d_of_type_AndroidViewView;
  TextView jdField_d_of_type_AndroidWidgetTextView;
  public Runnable d;
  TextView e;
  
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
    this.jdField_a_of_type_JavaLangRunnable = new BaseGuessTextStageView.1(this);
    this.jdField_b_of_type_JavaLangRunnable = new BaseGuessTextStageView.2(this);
    this.jdField_c_of_type_JavaLangRunnable = new BaseGuessTextStageView.3(this);
    this.jdField_d_of_type_JavaLangRunnable = new BaseGuessTextStageView.4(this);
    b();
  }
  
  private void b(TopicTextGuess paramTopicTextGuess)
  {
    Object localObject = paramTopicTextGuess.a();
    paramTopicTextGuess = paramTopicTextGuess.c();
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mUseMemoryCache = true;
      localObject = URLDrawable.getDrawable((String)localObject, localURLDrawableOptions);
      this.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
    }
    for (;;)
    {
      if (this.e != null)
      {
        this.e.setText(paramTopicTextGuess);
        this.e.setVisibility(0);
      }
      return;
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
    }
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
    b(paramITopic);
    a((TopicTextGuess)paramITopic);
  }
  
  public void a(Player paramPlayer, AVGameUserInfo paramAVGameUserInfo)
  {
    if (GameRoomViewLayoutParamsDef.l <= 0)
    {
      this.jdField_d_of_type_AndroidViewView.setVisibility(0);
      return;
    }
    this.jdField_d_of_type_AndroidViewView.setVisibility(8);
  }
  
  protected void a(TopicTextGuess paramTopicTextGuess)
  {
    if (QLog.isColorLevel()) {
      QLog.i("BaseGuessTextStageView", 2, "onGuessTextStart() topicSong:" + paramTopicTextGuess);
    }
    if (paramTopicTextGuess == null)
    {
      QLog.e("BaseGuessTextStageView", 1, "onGuessTextStart()  topicText empty");
      ThreadManager.getUIHandlerV2().removeCallbacks(this.jdField_d_of_type_JavaLangRunnable);
      ReportController.b(null, "dc00898", "", "", "0X800B1F2", "0X800B1F2", 0, 0, "", "", "", "");
      return;
    }
    if (TextUtils.isEmpty(paramTopicTextGuess.c()))
    {
      QLog.e("BaseGuessTextStageView", 1, "onGuessTextStart() illegal topicText getContent empty");
      ReportController.b(null, "dc00898", "", "", "0X800B1F2", "0X800B1F2", 0, 0, "", "", "", "");
      return;
    }
    ReportController.b(null, "dc00898", "", "", "0X800B1F1", "0X800B1F1", 0, 0, "", "", "", "");
    b(paramTopicTextGuess);
    String[] arrayOfString = paramTopicTextGuess.a();
    if ((arrayOfString[0] != null) && (arrayOfString[0].length() != 0) && (arrayOfString[1] != null) && (arrayOfString[1].length() != 0) && (arrayOfString[2] != null) && (arrayOfString[2].length() != 0))
    {
      this.jdField_a_of_type_ComTencentAvgameUiAVGameText.setAttribute("#FFFFFF", arrayOfString[2]);
      this.jdField_a_of_type_ComTencentAvgameUiAVGameText.setText(arrayOfString[0]);
      this.jdField_b_of_type_ComTencentAvgameUiAVGameText.setAttribute("#FFC000", "#FFFFFF");
      this.jdField_b_of_type_ComTencentAvgameUiAVGameText.setText(arrayOfString[1]);
      ThreadManager.getUIHandlerV2().post(this.jdField_c_of_type_JavaLangRunnable);
    }
    for (;;)
    {
      this.jdField_a_of_type_JavaUtilArrayList = paramTopicTextGuess.jdField_a_of_type_JavaUtilArrayList;
      if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > 0))
      {
        this.jdField_a_of_type_Int = 0;
        ThreadManager.getUIHandlerV2().postDelayed(this.jdField_d_of_type_JavaLangRunnable, ((Integer)((Pair)this.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_Int)).first).intValue() * 1000);
      }
      paramTopicTextGuess = paramTopicTextGuess.jdField_c_of_type_JavaLangString;
      if (QLog.isColorLevel()) {
        QLog.i("BaseGuessTextStageView", 2, "onGuessTextStart() businessAdsTips:" + paramTopicTextGuess);
      }
      if (TextUtils.isEmpty(paramTopicTextGuess)) {
        break;
      }
      this.jdField_a_of_type_ComTencentAvgameGameroomStageIGameStagePresenter.a().a().a(paramTopicTextGuess);
      return;
      ThreadManager.getUIHandlerV2().removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
      ThreadManager.getUIHandlerV2().post(this.jdField_b_of_type_JavaLangRunnable);
    }
  }
  
  public void a(String paramString)
  {
    this.jdField_b_of_type_AndroidWidgetTextView.setText(paramString);
    if ((paramString != null) && (paramString.length() > 5)) {
      this.jdField_b_of_type_AndroidWidgetTextView.setTextSize(0, UiUtils.d());
    }
    for (;;)
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setText(paramString);
      this.jdField_b_of_type_AndroidWidgetTextView.getViewTreeObserver().addOnGlobalLayoutListener(new BaseGuessTextStageView.5(this, paramString));
      ThreadManager.getUIHandlerV2().postDelayed(this.jdField_a_of_type_JavaLangRunnable, 3000L);
      return;
      this.jdField_b_of_type_AndroidWidgetTextView.setTextSize(0, UiUtils.c());
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if ((!paramBoolean) && (this.e != null))
    {
      this.e.setVisibility(4);
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(4);
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
    if (!paramBoolean2)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    }
    do
    {
      return;
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    } while (this.jdField_b_of_type_Boolean);
    String str = this.jdField_a_of_type_ComTencentAvgameGameroomStageIGameStagePresenter.a().a().b();
    if (!TextUtils.isEmpty(str)) {
      setBackgroundDrawable(URLDrawable.getDrawable(str));
    }
    for (;;)
    {
      this.jdField_b_of_type_Boolean = true;
      return;
      setBackgroundDrawable(AvGameResDownloadManager.a("avgame_float_act_guess_place_holder@2x.png"));
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  protected void b()
  {
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131379469));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131379510));
    this.jdField_b_of_type_AndroidViewView = findViewById(2131379487);
    ((RelativeLayout.LayoutParams)this.jdField_b_of_type_AndroidViewView.getLayoutParams()).topMargin = GameRoomViewLayoutParamsDef.m;
  }
  
  public void b(IStagePresenter paramIStagePresenter)
  {
    this.jdField_a_of_type_ComTencentAvgameGameroomStageIGameStagePresenter.a(paramIStagePresenter);
    a(paramIStagePresenter);
  }
  
  public void setFontStyle(FontStyleConfig paramFontStyleConfig)
  {
    this.jdField_d_of_type_AndroidWidgetTextView.setTextSize(paramFontStyleConfig.jdField_a_of_type_Int);
    this.jdField_d_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor(paramFontStyleConfig.jdField_a_of_type_JavaLangString));
    this.e.setTextSize(paramFontStyleConfig.jdField_c_of_type_Int);
    this.e.setTextColor(Color.parseColor(paramFontStyleConfig.jdField_c_of_type_JavaLangString));
    if ((this.jdField_a_of_type_AndroidWidgetImageView instanceof CountDownClockNumLottieView)) {
      ((CountDownClockNumLottieView)this.jdField_a_of_type_AndroidWidgetImageView).setParams(Color.parseColor(paramFontStyleConfig.jdField_b_of_type_JavaLangString), ViewUtils.a(paramFontStyleConfig.jdField_b_of_type_Int));
    }
  }
  
  public void setSpecialMode(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void setTitleCenter(String paramString)
  {
    if (this.jdField_c_of_type_AndroidWidgetTextView != null) {
      this.jdField_c_of_type_AndroidWidgetTextView.setText(paramString);
    }
  }
  
  public void setTitleRight(String paramString)
  {
    if (this.jdField_d_of_type_AndroidWidgetTextView != null) {
      this.jdField_d_of_type_AndroidWidgetTextView.setText(paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.avgame.gameroom.stage.guesstext.BaseGuessTextStageView
 * JD-Core Version:    0.7.0.1
 */