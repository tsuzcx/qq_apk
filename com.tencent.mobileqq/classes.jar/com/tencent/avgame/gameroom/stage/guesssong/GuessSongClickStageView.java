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
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("onSongStart() topicSong:");
      localStringBuilder.append(paramTopicSongGuess);
      QLog.i("GuessSongClickStageView", 2, localStringBuilder.toString());
    }
    if (paramTopicSongGuess == null)
    {
      ThreadManager.getUIHandlerV2().removeCallbacks(this.e);
      return;
    }
    if ((!TextUtils.isEmpty(paramTopicSongGuess.c())) && (paramTopicSongGuess.c().startsWith("http")))
    {
      this.jdField_a_of_type_JavaUtilArrayList = paramTopicSongGuess.jdField_a_of_type_JavaUtilArrayList;
      if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > 0))
      {
        this.jdField_a_of_type_Int = 0;
        ThreadManager.getUIHandlerV2().postDelayed(this.e, ((Integer)((Pair)this.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_Int)).first).intValue() * 1000);
      }
      paramTopicSongGuess = paramTopicSongGuess.c;
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("onSongStart() businessAdsTips:");
        localStringBuilder.append(paramTopicSongGuess);
        QLog.i("GuessSongClickStageView", 2, localStringBuilder.toString());
      }
      if (!TextUtils.isEmpty(paramTopicSongGuess)) {
        this.jdField_a_of_type_ComTencentAvgameGameroomStageIGameStagePresenter.a().a().a(paramTopicSongGuess);
      }
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onSongStart() illegal url:");
    localStringBuilder.append(paramTopicSongGuess.c());
    QLog.i("GuessSongClickStageView", 1, localStringBuilder.toString());
  }
  
  public void a(String paramString)
  {
    TextView localTextView = this.jdField_b_of_type_AndroidWidgetTextView;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(getResources().getText(2131690340));
    localStringBuilder.append(paramString);
    localTextView.setText(localStringBuilder.toString());
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
      return;
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    if (this.jdField_b_of_type_AndroidWidgetImageView.getVisibility() != 0)
    {
      String str = this.jdField_a_of_type_ComTencentAvgameGameroomStageIGameStagePresenter.a().a().b();
      if (!TextUtils.isEmpty(str)) {
        setBackgroundDrawable(URLDrawable.getDrawable(str));
      } else {
        setBackgroundDrawable(AvGameResDownloadUtil.a("avgame_float_act_guess_place_holder@2x.png"));
      }
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      c();
    }
  }
  
  protected void b()
  {
    LayoutInflater.from(getContext()).inflate(2131558668, this, true);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131379927));
    this.jdField_a_of_type_ComTencentAvgameUiAVGameText = ((AVGameText)findViewById(2131379550));
    this.jdField_b_of_type_ComTencentAvgameUiAVGameText = ((AVGameText)findViewById(2131379551));
    this.jdField_b_of_type_AndroidViewView = findViewById(2131370232);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131378839));
    this.jdField_a_of_type_AndroidViewView = findViewById(2131370328);
    this.jdField_c_of_type_AndroidViewView = findViewById(2131367771);
    this.jdField_c_of_type_AndroidViewView.setVisibility(8);
    this.jdField_a_of_type_ComTencentAvgameGameroomStageIGameStagePresenter = new GuessSongClickStagePresenter(this);
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
    this.jdField_a_of_type_AndroidViewView.setVisibility(4);
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131377702));
    this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(4);
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131377703));
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
    if ((localObject != null) && (!TextUtils.isEmpty(((GameItem)localObject).o))) {
      localObject = ((GameItem)localObject).o;
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
      this.jdField_c_of_type_AndroidWidgetImageView.setImageDrawable(null);
      return;
    }
    localObject = URLDrawable.getDrawable((String)localObject);
    this.jdField_c_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gameroom.stage.guesssong.GuessSongClickStageView
 * JD-Core Version:    0.7.0.1
 */