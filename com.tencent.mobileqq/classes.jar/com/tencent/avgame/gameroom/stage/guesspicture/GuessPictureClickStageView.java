package com.tencent.avgame.gameroom.stage.guesspicture;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Handler;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.avgame.gamelogic.data.TopicMosaicGuess;
import com.tencent.avgame.gameroom.IGameRoomPresenter;
import com.tencent.avgame.gameroom.festivalstage.questionoption.QuestionOptionItemConfig;
import com.tencent.avgame.gameroom.festivalstage.questionoption.QuestionOptionsView;
import com.tencent.avgame.gameroom.stage.IGameStagePresenter;
import com.tencent.avgame.gameroom.stage.IStagePresenter;
import com.tencent.avgame.gameroom.stage.util.FontStyleConfig;
import com.tencent.avgame.ui.AVGameText;
import com.tencent.avgame.util.MosaicUtil;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import java.util.ArrayList;

public class GuessPictureClickStageView
  extends BaseGuessPictureStageView
{
  public Runnable e = new GuessPictureClickStageView.1(this);
  public Runnable f = new GuessPictureClickStageView.2(this);
  
  public GuessPictureClickStageView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public GuessPictureClickStageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public GuessPictureClickStageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public void a(TopicMosaicGuess paramTopicMosaicGuess)
  {
    if (QLog.isColorLevel()) {
      QLog.i("GuessPictureClickStageView", 2, "onShowMosaicImageGameMosaicImage() topicMosaicGuess:" + paramTopicMosaicGuess);
    }
    this.jdField_a_of_type_JavaLangString = "";
    if (paramTopicMosaicGuess == null)
    {
      this.jdField_b_of_type_AndroidWidgetImageView.setImageBitmap(null);
      ThreadManager.getUIHandlerV2().removeCallbacks(this.e);
      return;
    }
    this.jdField_a_of_type_JavaLangString = paramTopicMosaicGuess.c();
    if ((TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) || (!this.jdField_a_of_type_JavaLangString.startsWith("http")))
    {
      QLog.i("GuessPictureClickStageView", 1, "onShowMosaicImageGameMosaicImage() illegal url:" + this.jdField_a_of_type_JavaLangString);
      d();
      return;
    }
    this.jdField_a_of_type_ComTencentImageURLDrawable = URLDrawable.getDrawable(this.jdField_a_of_type_JavaLangString, null);
    int i;
    if (this.jdField_a_of_type_ComTencentImageURLDrawable.getStatus() == 1)
    {
      Bitmap localBitmap = MosaicUtil.a(this.jdField_a_of_type_ComTencentImageURLDrawable.getCurrDrawable());
      this.jdField_a_of_type_AndroidGraphicsBitmap = localBitmap;
      if (paramTopicMosaicGuess.jdField_c_of_type_Int == 0)
      {
        i = 10;
        label172:
        setMosaicBitmapFromOriginal(localBitmap, i);
      }
    }
    for (;;)
    {
      if (paramTopicMosaicGuess.a() != 0L)
      {
        ThreadManager.getUIHandlerV2().removeCallbacks(this.e);
        if (this.jdField_b_of_type_AndroidViewView != null)
        {
          this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
          this.jdField_b_of_type_AndroidViewView.setVisibility(8);
        }
      }
      this.jdField_a_of_type_JavaUtilArrayList = paramTopicMosaicGuess.jdField_a_of_type_JavaUtilArrayList;
      if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > 0))
      {
        this.jdField_a_of_type_Int = 0;
        ThreadManager.getUIHandlerV2().postDelayed(this.e, ((Integer)((Pair)this.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_Int)).first).intValue() * 1000);
      }
      paramTopicMosaicGuess = paramTopicMosaicGuess.jdField_c_of_type_JavaLangString;
      if (QLog.isColorLevel()) {
        QLog.i("GuessPictureClickStageView", 2, "onShowMosaicImageGameMosaicImage() businessAdsTips:" + paramTopicMosaicGuess);
      }
      if (TextUtils.isEmpty(paramTopicMosaicGuess)) {
        break;
      }
      this.jdField_a_of_type_ComTencentAvgameGameroomStageIGameStagePresenter.a().a().a(paramTopicMosaicGuess);
      return;
      i = paramTopicMosaicGuess.jdField_c_of_type_Int;
      break label172;
      this.jdField_a_of_type_ComTencentImageURLDrawable.setURLDrawableListener(new GuessPictureClickStageView.3(this, paramTopicMosaicGuess));
      this.jdField_a_of_type_ComTencentImageURLDrawable.startDownload();
    }
  }
  
  public void a(String paramString)
  {
    this.jdField_b_of_type_AndroidWidgetTextView.setText(getResources().getText(2131690416) + paramString);
    ThreadManager.getUIHandlerV2().postDelayed(this.f, 3000L);
    b("Tips");
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (!paramBoolean2)
    {
      this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(4);
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
      return;
    }
    this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
    this.jdField_b_of_type_AndroidViewView.setVisibility(8);
  }
  
  protected void b()
  {
    LayoutInflater.from(getContext()).inflate(2131558768, this, true);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131380648));
    this.jdField_a_of_type_ComTencentAvgameUiAVGameText = ((AVGameText)findViewById(2131380233));
    this.jdField_b_of_type_ComTencentAvgameUiAVGameText = ((AVGameText)findViewById(2131380234));
    this.jdField_a_of_type_AndroidViewView = findViewById(2131370577);
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131369723));
    this.jdField_b_of_type_AndroidViewView = findViewById(2131370688);
    this.jdField_c_of_type_AndroidViewView = findViewById(2131368017);
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131379489));
    this.jdField_a_of_type_ComTencentAvgameGameroomStageIGameStagePresenter = new GuessPictureClickStagePresenter(this);
    this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(4);
    this.jdField_b_of_type_AndroidViewView.setVisibility(4);
    this.jdField_c_of_type_AndroidViewView.setVisibility(8);
    super.b();
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_AndroidGraphicsBitmap != null) {
      this.jdField_b_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap);
    }
    if (this.jdField_b_of_type_AndroidViewView != null)
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
    }
    if (this.jdField_a_of_type_AndroidViewView != null) {
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    }
    this.jdField_b_of_type_AndroidWidgetTextView.setText("");
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_JavaUtilArrayList = null;
    ThreadManager.getUIHandlerV2().removeCallbacks(this.e);
    b("Origin Image");
  }
  
  public void setFontStyle(FontStyleConfig paramFontStyleConfig)
  {
    super.setFontStyle(paramFontStyleConfig);
    this.jdField_b_of_type_AndroidWidgetTextView.setTextSize(paramFontStyleConfig.jdField_d_of_type_Int);
    this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor(paramFontStyleConfig.jdField_d_of_type_JavaLangString));
    QuestionOptionItemConfig localQuestionOptionItemConfig = new QuestionOptionItemConfig(paramFontStyleConfig.e, Color.parseColor(paramFontStyleConfig.jdField_h_of_type_JavaLangString), Color.parseColor(paramFontStyleConfig.jdField_g_of_type_JavaLangString), paramFontStyleConfig.jdField_g_of_type_Int, Color.parseColor(paramFontStyleConfig.u), paramFontStyleConfig.jdField_h_of_type_Int, Color.parseColor(paramFontStyleConfig.v));
    if (QLog.isColorLevel()) {
      QLog.i("GuessPictureClickStageView", 2, "FontStyleConfig :" + paramFontStyleConfig.toString());
    }
    this.jdField_a_of_type_ComTencentAvgameGameroomFestivalstageQuestionoptionQuestionOptionsView.setConfig(localQuestionOptionItemConfig);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.avgame.gameroom.stage.guesspicture.GuessPictureClickStageView
 * JD-Core Version:    0.7.0.1
 */