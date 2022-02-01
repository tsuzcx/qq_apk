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
import com.tencent.avgame.gameroom.stage.util.FontStyleConfig;
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
  int jdField_a_of_type_Int = 0;
  View jdField_a_of_type_AndroidViewView;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  IGameStagePresenter jdField_a_of_type_ComTencentAvgameGameroomStageIGameStagePresenter;
  AVGameText jdField_a_of_type_ComTencentAvgameUiAVGameText;
  LottieDrawable jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable;
  public Runnable a;
  ArrayList<Pair<Integer, String>> jdField_a_of_type_JavaUtilArrayList;
  boolean jdField_a_of_type_Boolean = false;
  View jdField_b_of_type_AndroidViewView;
  ImageView jdField_b_of_type_AndroidWidgetImageView;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  AVGameText jdField_b_of_type_ComTencentAvgameUiAVGameText;
  public Runnable b;
  View jdField_c_of_type_AndroidViewView;
  TextView jdField_c_of_type_AndroidWidgetTextView;
  public Runnable c;
  View jdField_d_of_type_AndroidViewView;
  TextView jdField_d_of_type_AndroidWidgetTextView;
  public Runnable d;
  
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
    this.jdField_a_of_type_JavaLangRunnable = new BaseGuessSongStageView.1(this);
    this.jdField_b_of_type_JavaLangRunnable = new BaseGuessSongStageView.2(this);
    this.jdField_c_of_type_JavaLangRunnable = new BaseGuessSongStageView.3(this);
    this.jdField_d_of_type_JavaLangRunnable = new BaseGuessSongStageView.4(this);
    b();
  }
  
  public Bitmap a(Drawable paramDrawable, int paramInt1, int paramInt2)
  {
    QLog.d("BaseGuessSongStageView", 2, "drawableToBitmap " + paramInt1 + " " + paramInt2);
    paramDrawable.setBounds(0, 0, paramInt1, paramInt2);
    if (paramDrawable.getOpacity() != -1) {}
    for (Object localObject = Bitmap.Config.ARGB_8888;; localObject = Bitmap.Config.RGB_565)
    {
      localObject = Bitmap.createBitmap(paramInt1, paramInt2, (Bitmap.Config)localObject);
      paramDrawable.draw(new Canvas((Bitmap)localObject));
      return localObject;
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
    if ((paramITopic instanceof TopicSongGuess)) {
      a((TopicSongGuess)paramITopic);
    }
  }
  
  public void a(Player paramPlayer, AVGameUserInfo paramAVGameUserInfo)
  {
    if (GameRoomViewLayoutParamsDef.l <= 0)
    {
      this.jdField_c_of_type_AndroidViewView.setVisibility(0);
      return;
    }
    this.jdField_c_of_type_AndroidViewView.setVisibility(8);
  }
  
  protected void a(TopicSongGuess paramTopicSongGuess)
  {
    if (QLog.isColorLevel()) {
      QLog.i("BaseGuessSongStageView", 2, "onSongStart() topicSong:" + paramTopicSongGuess);
    }
    if (paramTopicSongGuess == null)
    {
      ThreadManager.getUIHandlerV2().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      return;
    }
    if ((TextUtils.isEmpty(paramTopicSongGuess.c())) || (!paramTopicSongGuess.c().startsWith("http")))
    {
      QLog.i("BaseGuessSongStageView", 1, "onSongStart() illegal url:" + paramTopicSongGuess.c());
      return;
    }
    String[] arrayOfString = paramTopicSongGuess.a();
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
      this.jdField_a_of_type_JavaUtilArrayList = paramTopicSongGuess.jdField_a_of_type_JavaUtilArrayList;
      if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > 0))
      {
        this.jdField_a_of_type_Int = 0;
        ThreadManager.getUIHandlerV2().postDelayed(this.jdField_a_of_type_JavaLangRunnable, ((Integer)((Pair)this.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_Int)).first).intValue() * 1000);
      }
      paramTopicSongGuess = paramTopicSongGuess.c;
      if (QLog.isColorLevel()) {
        QLog.i("BaseGuessSongStageView", 2, "onSongStart() businessAdsTips:" + paramTopicSongGuess);
      }
      if (TextUtils.isEmpty(paramTopicSongGuess)) {
        break;
      }
      this.jdField_a_of_type_ComTencentAvgameGameroomStageIGameStagePresenter.a().a().a(paramTopicSongGuess);
      return;
      ThreadManager.getUIHandlerV2().removeCallbacks(this.jdField_d_of_type_JavaLangRunnable);
      ThreadManager.getUIHandlerV2().post(this.jdField_d_of_type_JavaLangRunnable);
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
      this.jdField_b_of_type_AndroidWidgetTextView.getViewTreeObserver().addOnGlobalLayoutListener(new BaseGuessSongStageView.5(this, paramString));
      ThreadManager.getUIHandlerV2().postDelayed(this.jdField_b_of_type_JavaLangRunnable, 3000L);
      return;
      this.jdField_b_of_type_AndroidWidgetTextView.setTextSize(0, UiUtils.c());
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = 0;; i = 8)
    {
      setVisibility(i);
      if ((!paramBoolean) && (this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable != null))
      {
        if (this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable.isRunning()) {
          this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable.stop();
        }
        this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable = null;
      }
      return;
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2) {}
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  protected void b()
  {
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131379469));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131379510));
    this.jdField_d_of_type_AndroidViewView = findViewById(2131379487);
    ((RelativeLayout.LayoutParams)this.jdField_d_of_type_AndroidViewView.getLayoutParams()).topMargin = GameRoomViewLayoutParamsDef.m;
  }
  
  public void b(IStagePresenter paramIStagePresenter)
  {
    this.jdField_a_of_type_ComTencentAvgameGameroomStageIGameStagePresenter.a(paramIStagePresenter);
    a(paramIStagePresenter);
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable == null)
    {
      AVGameLottieHelper.a(getContext(), "avgame_guess_song_playing/data.json", "avgame_guess_song_playing/images/", 250, 250, new BaseGuessSongStageView.6(this));
      return;
    }
    d();
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable.isRunning()) {
      this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable.stop();
    }
    this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable.setProgress(0.0F);
    this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable.setRepeatCount(-1);
    this.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable);
    this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable.start();
    e();
  }
  
  protected void e()
  {
    Object localObject = GameEngine.a().a().d();
    if (QLog.isColorLevel()) {
      QLog.d("BaseGuessSongStageView", 2, "playSongPlayingLottieDrawable " + (String)localObject);
    }
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      localObject = URLDrawable.getDrawable((String)localObject);
      ((URLDrawable)localObject).setURLDrawableListener(new BaseGuessSongStageView.7(this));
      ((URLDrawable)localObject).startDownload();
    }
  }
  
  public void setFontStyle(FontStyleConfig paramFontStyleConfig)
  {
    this.jdField_d_of_type_AndroidWidgetTextView.setTextSize(paramFontStyleConfig.jdField_a_of_type_Int);
    this.jdField_d_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor(paramFontStyleConfig.jdField_a_of_type_JavaLangString));
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
 * Qualified Name:     com.tencent.avgame.gameroom.stage.guesssong.BaseGuessSongStageView
 * JD-Core Version:    0.7.0.1
 */