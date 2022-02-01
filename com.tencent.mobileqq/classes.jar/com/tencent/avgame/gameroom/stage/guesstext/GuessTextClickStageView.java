package com.tencent.avgame.gameroom.stage.guesstext;

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
import com.tencent.avgame.gamelogic.data.TopicTextGuess;
import com.tencent.avgame.gamelogic.gameres.AvGameResDownloadManager;
import com.tencent.avgame.gameroom.IGameRoomPresenter;
import com.tencent.avgame.gameroom.festivalstage.questionoption.QuestionOptionItemConfig;
import com.tencent.avgame.gameroom.festivalstage.questionoption.QuestionOptionsView;
import com.tencent.avgame.gameroom.stage.IGameStagePresenter;
import com.tencent.avgame.gameroom.stage.IStagePresenter;
import com.tencent.avgame.gameroom.stage.util.FontStyleConfig;
import com.tencent.avgame.ui.AVGameText;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import java.util.ArrayList;

public class GuessTextClickStageView
  extends BaseGuessTextStageView
{
  public Runnable e;
  public Runnable f = new GuessTextClickStageView.2(this);
  
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
    this.jdField_e_of_type_JavaLangRunnable = new GuessTextClickStageView.1(this);
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
      if (this.jdField_e_of_type_AndroidWidgetTextView != null)
      {
        this.jdField_e_of_type_AndroidWidgetTextView.setText(paramTopicTextGuess);
        this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(0);
      }
      return;
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
    }
  }
  
  protected void a(TopicTextGuess paramTopicTextGuess)
  {
    if (QLog.isColorLevel()) {
      QLog.i("GuessTextClickStageView", 2, "onGuessTextStart() topicSong:" + paramTopicTextGuess);
    }
    if (paramTopicTextGuess == null)
    {
      QLog.e("GuessTextClickStageView", 1, "onGuessTextStart()  topicText empty");
      ThreadManager.getUIHandlerV2().removeCallbacks(this.f);
    }
    do
    {
      do
      {
        return;
      } while (TextUtils.isEmpty(paramTopicTextGuess.c()));
      b(paramTopicTextGuess);
      this.jdField_a_of_type_JavaUtilArrayList = paramTopicTextGuess.jdField_a_of_type_JavaUtilArrayList;
      if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > 0))
      {
        this.jdField_a_of_type_Int = 0;
        ThreadManager.getUIHandlerV2().postDelayed(this.f, ((Integer)((Pair)this.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_Int)).first).intValue() * 1000);
      }
      paramTopicTextGuess = paramTopicTextGuess.c;
      if (QLog.isColorLevel()) {
        QLog.i("GuessTextClickStageView", 2, "onUpdateCurTopic() businessAdsTips:" + paramTopicTextGuess);
      }
    } while (TextUtils.isEmpty(paramTopicTextGuess));
    this.jdField_a_of_type_ComTencentAvgameGameroomStageIGameStagePresenter.a().a().a(paramTopicTextGuess);
  }
  
  public void a(String paramString)
  {
    this.jdField_b_of_type_AndroidWidgetTextView.setText(getResources().getText(2131690416) + paramString);
    ThreadManager.getUIHandlerV2().postDelayed(this.jdField_e_of_type_JavaLangRunnable, 3000L);
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
  
  protected void b()
  {
    LayoutInflater.from(getContext()).inflate(2131558771, this, true);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131380648));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131379489));
    this.jdField_a_of_type_AndroidViewView = findViewById(2131370688);
    this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131380397));
    this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(4);
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131380399));
    if (this.jdField_b_of_type_AndroidWidgetImageView != null) {
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
    }
    this.jdField_a_of_type_ComTencentAvgameUiAVGameText = ((AVGameText)findViewById(2131380233));
    this.jdField_b_of_type_ComTencentAvgameUiAVGameText = ((AVGameText)findViewById(2131380234));
    this.c = findViewById(2131370577);
    this.d = findViewById(2131368017);
    this.d.setVisibility(8);
    this.jdField_a_of_type_ComTencentAvgameGameroomStageIGameStagePresenter = new GuessTextClickStagePresenter(this);
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
    this.jdField_a_of_type_AndroidViewView.setVisibility(4);
    super.b();
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
 * Qualified Name:     com.tencent.avgame.gameroom.stage.guesstext.GuessTextClickStageView
 * JD-Core Version:    0.7.0.1
 */