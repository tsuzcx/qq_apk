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
  public Runnable v = new GuessStarClickStageView.1(this);
  private View w;
  private ImageView x;
  
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
  }
  
  public Bitmap a(EngineData paramEngineData)
  {
    if (paramEngineData == null) {
      return null;
    }
    paramEngineData = paramEngineData.s();
    if ((paramEngineData != null) && ((paramEngineData instanceof TopicOperGuessVideo))) {
      paramEngineData = ((TopicOperGuessVideo)paramEngineData).i.a;
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
    return b(paramEngineData);
  }
  
  public void a(Bitmap paramBitmap)
  {
    if (paramBitmap == null) {
      return;
    }
    this.x.setImageBitmap(paramBitmap);
    this.x.setVisibility(0);
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
    this.q = ((TopicOperGuessVideo)localObject).k;
    b(paramITopic);
    paramITopic = ((TopicOperGuessVideo)localObject).r;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onUpdateCurTopic() businessAdsTips:");
      ((StringBuilder)localObject).append(paramITopic);
      QLog.i("GuessStarClickStageView", 2, ((StringBuilder)localObject).toString());
    }
    if (!TextUtils.isEmpty(paramITopic)) {
      this.c.a().a().b(paramITopic);
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
    Object localObject = this.e;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(getResources().getText(2131887251));
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
    this.h.setVisibility(4);
    this.g.setVisibility(8);
    if (this.d != null) {
      this.d.a(this.g);
    }
  }
  
  /* Error */
  public Bitmap b(String paramString)
  {
    // Byte code:
    //   0: new 189	android/media/MediaMetadataRetriever
    //   3: dup
    //   4: invokespecial 190	android/media/MediaMetadataRetriever:<init>	()V
    //   7: astore_2
    //   8: aload_2
    //   9: aload_1
    //   10: new 192	java/util/HashMap
    //   13: dup
    //   14: invokespecial 193	java/util/HashMap:<init>	()V
    //   17: invokevirtual 197	android/media/MediaMetadataRetriever:setDataSource	(Ljava/lang/String;Ljava/util/Map;)V
    //   20: aload_2
    //   21: invokevirtual 201	android/media/MediaMetadataRetriever:getFrameAtTime	()Landroid/graphics/Bitmap;
    //   24: astore_1
    //   25: aload_2
    //   26: invokevirtual 204	android/media/MediaMetadataRetriever:release	()V
    //   29: aload_1
    //   30: areturn
    //   31: astore_1
    //   32: goto +14 -> 46
    //   35: astore_1
    //   36: aload_1
    //   37: invokevirtual 207	java/lang/IllegalArgumentException:printStackTrace	()V
    //   40: aload_2
    //   41: invokevirtual 204	android/media/MediaMetadataRetriever:release	()V
    //   44: aconst_null
    //   45: areturn
    //   46: aload_2
    //   47: invokevirtual 204	android/media/MediaMetadataRetriever:release	()V
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
  
  public void b(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if ((this.q != null) && (this.q.size() > 0))
      {
        this.r = 0;
        ThreadManager.getUIHandlerV2().postDelayed(this.v, ((Integer)((Pair)this.q.get(this.r)).first).intValue() * 1000);
      }
      this.h.setVisibility(0);
      this.w.setVisibility(0);
      this.a.setVisibility(0);
      return;
    }
    ThreadManager.getUIHandlerV2().removeCallbacks(this.v);
    this.h.setVisibility(4);
    this.w.setVisibility(8);
    this.a.setVisibility(8);
    this.x.setVisibility(8);
  }
  
  protected void c()
  {
    LayoutInflater.from(getContext()).inflate(2131624286, this, true);
    this.g = ((LinearLayout)findViewById(2131447779));
    this.e = ((TextView)findViewById(2131447762));
    this.i = findViewById(2131434340);
    this.j = ((AVGameText)findViewById(2131448302));
    this.k = ((AVGameText)findViewById(2131448303));
    this.l = findViewById(2131437420);
    this.h = ((ImageView)findViewById(2131447536));
    this.w = findViewById(2131447760);
    this.x = ((ImageView)findViewById(2131430781));
    this.i.setVisibility(8);
    this.g.setVisibility(8);
    this.c = new GuessStarClickStagePresenter(this);
    super.c();
    b(false);
    if (QLog.isColorLevel()) {
      QLog.d("GuessStarClickStageView", 2, "init");
    }
  }
  
  public void setFontStyle(FontStyleConfig paramFontStyleConfig)
  {
    super.setFontStyle(paramFontStyleConfig);
    this.e.setTextSize(paramFontStyleConfig.h);
    this.e.setTextColor(Color.parseColor(paramFontStyleConfig.g));
    paramFontStyleConfig = new QuestionOptionItemConfig(paramFontStyleConfig.l, Color.parseColor(paramFontStyleConfig.m), Color.parseColor(paramFontStyleConfig.k), paramFontStyleConfig.B, Color.parseColor(paramFontStyleConfig.A), paramFontStyleConfig.D, Color.parseColor(paramFontStyleConfig.C));
    this.a.setConfig(paramFontStyleConfig);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gameroom.stage.guessstar.GuessStarClickStageView
 * JD-Core Version:    0.7.0.1
 */