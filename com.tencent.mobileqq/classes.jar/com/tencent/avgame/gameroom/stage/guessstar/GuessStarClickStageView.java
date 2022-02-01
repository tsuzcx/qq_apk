package com.tencent.avgame.gameroom.stage.guessstar;

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
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.avgame.data.FontStyleConfig;
import com.tencent.avgame.gamelogic.ITopic;
import com.tencent.avgame.gamelogic.data.AVRes;
import com.tencent.avgame.gamelogic.data.EngineData;
import com.tencent.avgame.gamelogic.data.TopicOperGuessVideo;
import com.tencent.avgame.gameroom.IGameRoomPresenter;
import com.tencent.avgame.gameroom.festivalstage.questionoption.QuestionOptionItemConfig;
import com.tencent.avgame.gameroom.festivalstage.questionoption.QuestionOptionsView;
import com.tencent.avgame.gameroom.stage.IGameStagePresenter;
import com.tencent.avgame.gameroom.stage.IStagePresenter;
import com.tencent.avgame.gameroom.stage.IStageRecordPresenter;
import com.tencent.avgame.ui.AVGameText;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import java.util.ArrayList;

public class GuessStarClickStageView
  extends BaseGuessStarStageView
{
  private ImageView b;
  private View d;
  public Runnable d;
  
  public GuessStarClickStageView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public GuessStarClickStageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public GuessStarClickStageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_d_of_type_JavaLangRunnable = new GuessStarClickStageView.1(this);
  }
  
  public Bitmap a(EngineData paramEngineData)
  {
    if (paramEngineData == null) {
      return null;
    }
    paramEngineData = paramEngineData.a();
    if ((paramEngineData != null) && ((paramEngineData instanceof TopicOperGuessVideo))) {
      paramEngineData = ((TopicOperGuessVideo)paramEngineData).jdField_a_of_type_ComTencentAvgameGamelogicDataAVRes.a;
    } else {
      paramEngineData = null;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("showVideoBg ,videoUrl = ");
      localStringBuilder.append(paramEngineData);
      QLog.d("GuessStarClickStageView", 2, localStringBuilder.toString());
    }
    if (TextUtils.isEmpty(paramEngineData)) {
      return null;
    }
    return a(paramEngineData);
  }
  
  /* Error */
  public Bitmap a(String paramString)
  {
    // Byte code:
    //   0: new 82	android/media/MediaMetadataRetriever
    //   3: dup
    //   4: invokespecial 83	android/media/MediaMetadataRetriever:<init>	()V
    //   7: astore_2
    //   8: aload_2
    //   9: aload_1
    //   10: new 85	java/util/HashMap
    //   13: dup
    //   14: invokespecial 86	java/util/HashMap:<init>	()V
    //   17: invokevirtual 90	android/media/MediaMetadataRetriever:setDataSource	(Ljava/lang/String;Ljava/util/Map;)V
    //   20: aload_2
    //   21: invokevirtual 94	android/media/MediaMetadataRetriever:getFrameAtTime	()Landroid/graphics/Bitmap;
    //   24: astore_1
    //   25: aload_2
    //   26: invokevirtual 97	android/media/MediaMetadataRetriever:release	()V
    //   29: aload_1
    //   30: areturn
    //   31: astore_1
    //   32: goto +14 -> 46
    //   35: astore_1
    //   36: aload_1
    //   37: invokevirtual 100	java/lang/IllegalArgumentException:printStackTrace	()V
    //   40: aload_2
    //   41: invokevirtual 97	android/media/MediaMetadataRetriever:release	()V
    //   44: aconst_null
    //   45: areturn
    //   46: aload_2
    //   47: invokevirtual 97	android/media/MediaMetadataRetriever:release	()V
    //   50: aload_1
    //   51: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	52	0	this	GuessStarClickStageView
    //   0	52	1	paramString	String
    //   7	40	2	localMediaMetadataRetriever	android.media.MediaMetadataRetriever
    // Exception table:
    //   from	to	target	type
    //   8	25	31	finally
    //   36	40	31	finally
    //   8	25	35	java/lang/IllegalArgumentException
  }
  
  public void a(Bitmap paramBitmap)
  {
    if (paramBitmap == null) {
      return;
    }
    this.jdField_b_of_type_AndroidWidgetImageView.setImageBitmap(paramBitmap);
    this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
  }
  
  public void a(ITopic paramITopic)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onUpdateCurTopic topic = ");
      ((StringBuilder)localObject).append(paramITopic);
      QLog.d("GuessStarClickStageView", 2, ((StringBuilder)localObject).toString());
    }
    if (paramITopic == null) {
      return;
    }
    Object localObject = (TopicOperGuessVideo)paramITopic;
    this.jdField_a_of_type_JavaUtilArrayList = ((TopicOperGuessVideo)localObject).jdField_a_of_type_JavaUtilArrayList;
    b(paramITopic);
    paramITopic = ((TopicOperGuessVideo)localObject).c;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onUpdateCurTopic() businessAdsTips:");
      ((StringBuilder)localObject).append(paramITopic);
      QLog.i("GuessStarClickStageView", 2, ((StringBuilder)localObject).toString());
    }
    if (!TextUtils.isEmpty(paramITopic)) {
      this.jdField_a_of_type_ComTencentAvgameGameroomStageIGameStagePresenter.a().a().a(paramITopic);
    }
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("showTopicTips tip = ");
      ((StringBuilder)localObject).append(paramString);
      QLog.i("GuessStarClickStageView", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.jdField_a_of_type_AndroidWidgetTextView;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(getResources().getText(2131690340));
    localStringBuilder.append(paramString);
    ((TextView)localObject).setText(localStringBuilder.toString());
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
      QLog.d("GuessStarClickStageView", 2, localStringBuilder.toString());
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    if (this.jdField_a_of_type_ComTencentAvgameGameroomStageIStageRecordPresenter != null) {
      this.jdField_a_of_type_ComTencentAvgameGameroomStageIStageRecordPresenter.a(this.jdField_a_of_type_AndroidWidgetLinearLayout);
    }
  }
  
  protected void b()
  {
    LayoutInflater.from(getContext()).inflate(2131558669, this, true);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131379056));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131379039));
    this.jdField_a_of_type_AndroidViewView = findViewById(2131367771);
    this.jdField_a_of_type_ComTencentAvgameUiAVGameText = ((AVGameText)findViewById(2131379550));
    this.jdField_b_of_type_ComTencentAvgameUiAVGameText = ((AVGameText)findViewById(2131379551));
    this.jdField_b_of_type_AndroidViewView = findViewById(2131370232);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131378839));
    this.jdField_d_of_type_AndroidViewView = findViewById(2131379037);
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131364688));
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    this.jdField_a_of_type_ComTencentAvgameGameroomStageIGameStagePresenter = new GuessStarClickStagePresenter(this);
    super.b();
    b(false);
    if (QLog.isColorLevel()) {
      QLog.d("GuessStarClickStageView", 2, "init");
    }
  }
  
  public void b(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > 0))
      {
        this.jdField_a_of_type_Int = 0;
        ThreadManager.getUIHandlerV2().postDelayed(this.jdField_d_of_type_JavaLangRunnable, ((Integer)((Pair)this.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_Int)).first).intValue() * 1000);
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_d_of_type_AndroidViewView.setVisibility(0);
      this.jdField_a_of_type_ComTencentAvgameGameroomFestivalstageQuestionoptionQuestionOptionsView.setVisibility(0);
      return;
    }
    ThreadManager.getUIHandlerV2().removeCallbacks(this.jdField_d_of_type_JavaLangRunnable);
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
    this.jdField_d_of_type_AndroidViewView.setVisibility(8);
    this.jdField_a_of_type_ComTencentAvgameGameroomFestivalstageQuestionoptionQuestionOptionsView.setVisibility(8);
    this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
  }
  
  public void setFontStyle(FontStyleConfig paramFontStyleConfig)
  {
    super.setFontStyle(paramFontStyleConfig);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(paramFontStyleConfig.jdField_d_of_type_Int);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor(paramFontStyleConfig.jdField_d_of_type_JavaLangString));
    paramFontStyleConfig = new QuestionOptionItemConfig(paramFontStyleConfig.e, Color.parseColor(paramFontStyleConfig.jdField_h_of_type_JavaLangString), Color.parseColor(paramFontStyleConfig.jdField_g_of_type_JavaLangString), paramFontStyleConfig.jdField_g_of_type_Int, Color.parseColor(paramFontStyleConfig.u), paramFontStyleConfig.jdField_h_of_type_Int, Color.parseColor(paramFontStyleConfig.v));
    this.jdField_a_of_type_ComTencentAvgameGameroomFestivalstageQuestionoptionQuestionOptionsView.setConfig(paramFontStyleConfig);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gameroom.stage.guessstar.GuessStarClickStageView
 * JD-Core Version:    0.7.0.1
 */