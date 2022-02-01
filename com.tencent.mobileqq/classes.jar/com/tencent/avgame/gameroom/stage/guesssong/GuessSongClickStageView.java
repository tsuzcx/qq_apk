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
import com.tencent.avgame.gamelogic.GameEngine;
import com.tencent.avgame.gamelogic.data.EngineData;
import com.tencent.avgame.gamelogic.data.GameItem;
import com.tencent.avgame.gamelogic.data.TopicSongGuess;
import com.tencent.avgame.gamelogic.gameres.AvGameResDownloadManager;
import com.tencent.avgame.gameroom.AVGameLottieHelper;
import com.tencent.avgame.gameroom.IGameRoomPresenter;
import com.tencent.avgame.gameroom.festivalstage.questionoption.QuestionOptionItemConfig;
import com.tencent.avgame.gameroom.festivalstage.questionoption.QuestionOptionsView;
import com.tencent.avgame.gameroom.stage.IGameStagePresenter;
import com.tencent.avgame.gameroom.stage.IStagePresenter;
import com.tencent.avgame.gameroom.stage.util.FontStyleConfig;
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
  private ImageView c;
  public Runnable e = new GuessSongClickStageView.1(this);
  public Runnable f = new GuessSongClickStageView.2(this);
  
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
    if (QLog.isColorLevel()) {
      QLog.i("GuessSongClickStageView", 2, "onSongStart() topicSong:" + paramTopicSongGuess);
    }
    if (paramTopicSongGuess == null) {
      ThreadManager.getUIHandlerV2().removeCallbacks(this.e);
    }
    do
    {
      return;
      if ((TextUtils.isEmpty(paramTopicSongGuess.c())) || (!paramTopicSongGuess.c().startsWith("http")))
      {
        QLog.i("GuessSongClickStageView", 1, "onSongStart() illegal url:" + paramTopicSongGuess.c());
        return;
      }
      this.jdField_a_of_type_JavaUtilArrayList = paramTopicSongGuess.jdField_a_of_type_JavaUtilArrayList;
      if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > 0))
      {
        this.jdField_a_of_type_Int = 0;
        ThreadManager.getUIHandlerV2().postDelayed(this.e, ((Integer)((Pair)this.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_Int)).first).intValue() * 1000);
      }
      paramTopicSongGuess = paramTopicSongGuess.c;
      if (QLog.isColorLevel()) {
        QLog.i("GuessSongClickStageView", 2, "onSongStart() businessAdsTips:" + paramTopicSongGuess);
      }
    } while (TextUtils.isEmpty(paramTopicSongGuess));
    this.jdField_a_of_type_ComTencentAvgameGameroomStageIGameStagePresenter.a().a().a(paramTopicSongGuess);
  }
  
  public void a(String paramString)
  {
    this.jdField_b_of_type_AndroidWidgetTextView.setText(getResources().getText(2131690416) + paramString);
    ThreadManager.getUIHandlerV2().postDelayed(this.f, 3000L);
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (!paramBoolean2)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      setBackgroundDrawable(null);
      if ((this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable != null) && (this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable.isRunning())) {
        this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable.stop();
      }
      this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable = null;
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(4);
    }
    do
    {
      return;
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    } while (this.jdField_b_of_type_AndroidWidgetImageView.getVisibility() == 0);
    String str = this.jdField_a_of_type_ComTencentAvgameGameroomStageIGameStagePresenter.a().a().b();
    if (!TextUtils.isEmpty(str)) {
      setBackgroundDrawable(URLDrawable.getDrawable(str));
    }
    for (;;)
    {
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      c();
      return;
      setBackgroundDrawable(AvGameResDownloadManager.a("avgame_float_act_guess_place_holder@2x.png"));
    }
  }
  
  protected void b()
  {
    LayoutInflater.from(getContext()).inflate(2131558769, this, true);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131380648));
    this.jdField_a_of_type_ComTencentAvgameUiAVGameText = ((AVGameText)findViewById(2131380233));
    this.jdField_b_of_type_ComTencentAvgameUiAVGameText = ((AVGameText)findViewById(2131380234));
    this.jdField_b_of_type_AndroidViewView = findViewById(2131370577);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131379489));
    this.jdField_a_of_type_AndroidViewView = findViewById(2131370688);
    this.jdField_c_of_type_AndroidViewView = findViewById(2131368017);
    this.jdField_c_of_type_AndroidViewView.setVisibility(8);
    this.jdField_a_of_type_ComTencentAvgameGameroomStageIGameStagePresenter = new GuessSongClickStagePresenter(this);
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
    this.jdField_a_of_type_AndroidViewView.setVisibility(4);
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131378294));
    this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(4);
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131378295));
    super.b();
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable == null)
    {
      AVGameLottieHelper.a(getContext(), "avgame_guess_song_playing/data.json", "avgame_guess_song_playing/images/", 140, 140, new GuessSongClickStageView.3(this));
      return;
    }
    d();
  }
  
  protected void e()
  {
    Object localObject = GameEngine.a().a();
    if (!((EngineData)localObject).g())
    {
      super.e();
      return;
    }
    localObject = ((EngineData)localObject).a();
    if ((localObject != null) && (!TextUtils.isEmpty(((GameItem)localObject).o))) {}
    for (localObject = ((GameItem)localObject).o;; localObject = null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("GuessSongClickStageView", 2, "checkLogo = " + (String)localObject);
      }
      if (localObject == null)
      {
        this.jdField_c_of_type_AndroidWidgetImageView.setImageDrawable(null);
        return;
      }
      localObject = URLDrawable.getDrawable((String)localObject);
      this.jdField_c_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
      return;
    }
  }
  
  public void setFontStyle(FontStyleConfig paramFontStyleConfig)
  {
    super.setFontStyle(paramFontStyleConfig);
    this.jdField_b_of_type_AndroidWidgetTextView.setTextSize(paramFontStyleConfig.jdField_d_of_type_Int);
    this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor(paramFontStyleConfig.jdField_d_of_type_JavaLangString));
    paramFontStyleConfig = new QuestionOptionItemConfig(paramFontStyleConfig.e, Color.parseColor(paramFontStyleConfig.jdField_h_of_type_JavaLangString), Color.parseColor(paramFontStyleConfig.jdField_g_of_type_JavaLangString), paramFontStyleConfig.jdField_g_of_type_Int, Color.parseColor(paramFontStyleConfig.u), paramFontStyleConfig.jdField_h_of_type_Int, Color.parseColor(paramFontStyleConfig.v));
    this.jdField_a_of_type_ComTencentAvgameGameroomFestivalstageQuestionoptionQuestionOptionsView.setConfig(paramFontStyleConfig);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.avgame.gameroom.stage.guesssong.GuessSongClickStageView
 * JD-Core Version:    0.7.0.1
 */