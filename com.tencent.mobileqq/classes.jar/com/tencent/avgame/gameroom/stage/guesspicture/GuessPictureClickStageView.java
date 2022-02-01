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
import com.tencent.avgame.data.FontStyleConfig;
import com.tencent.avgame.gamelogic.data.TopicMosaicGuess;
import com.tencent.avgame.gameroom.IGameRoomPresenter;
import com.tencent.avgame.gameroom.festivalstage.questionoption.QuestionOptionItemConfig;
import com.tencent.avgame.gameroom.festivalstage.questionoption.QuestionOptionsView;
import com.tencent.avgame.gameroom.stage.IGameStagePresenter;
import com.tencent.avgame.gameroom.stage.IStagePresenter;
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
  public Runnable F = new GuessPictureClickStageView.1(this);
  public Runnable G = new GuessPictureClickStageView.2(this);
  
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
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onShowMosaicImageGameMosaicImage() topicMosaicGuess:");
      ((StringBuilder)localObject).append(paramTopicMosaicGuess);
      QLog.i("GuessPictureClickStageView", 2, ((StringBuilder)localObject).toString());
    }
    this.D = "";
    if (paramTopicMosaicGuess == null)
    {
      this.k.setImageBitmap(null);
      ThreadManager.getUIHandlerV2().removeCallbacks(this.F);
      return;
    }
    this.D = paramTopicMosaicGuess.e();
    if ((!TextUtils.isEmpty(this.D)) && (this.D.startsWith("http")))
    {
      this.p = URLDrawable.getDrawable(this.D, null);
      if (this.p.getStatus() == 1)
      {
        localObject = MosaicUtil.a(this.p.getCurrDrawable());
        this.o = ((Bitmap)localObject);
        int i;
        if (paramTopicMosaicGuess.m == 0) {
          i = 10;
        } else {
          i = paramTopicMosaicGuess.m;
        }
        setMosaicBitmapFromOriginal((Bitmap)localObject, i);
      }
      else
      {
        this.p.setURLDrawableListener(new GuessPictureClickStageView.3(this, paramTopicMosaicGuess));
        this.p.startDownload();
      }
      if (paramTopicMosaicGuess.h() != 0L)
      {
        ThreadManager.getUIHandlerV2().removeCallbacks(this.F);
        if (this.m != null)
        {
          this.f.setVisibility(8);
          this.m.setVisibility(8);
        }
      }
      this.u = paramTopicMosaicGuess.k;
      if ((this.u != null) && (this.u.size() > 0))
      {
        this.v = 0;
        ThreadManager.getUIHandlerV2().postDelayed(this.F, ((Integer)((Pair)this.u.get(this.v)).first).intValue() * 1000);
      }
      paramTopicMosaicGuess = paramTopicMosaicGuess.r;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onShowMosaicImageGameMosaicImage() businessAdsTips:");
        ((StringBuilder)localObject).append(paramTopicMosaicGuess);
        QLog.i("GuessPictureClickStageView", 2, ((StringBuilder)localObject).toString());
      }
      if (!TextUtils.isEmpty(paramTopicMosaicGuess)) {
        this.d.a().a().b(paramTopicMosaicGuess);
      }
      return;
    }
    paramTopicMosaicGuess = new StringBuilder();
    paramTopicMosaicGuess.append("onShowMosaicImageGameMosaicImage() illegal url:");
    paramTopicMosaicGuess.append(this.D);
    QLog.i("GuessPictureClickStageView", 1, paramTopicMosaicGuess.toString());
    e();
  }
  
  public void a(String paramString)
  {
    TextView localTextView = this.f;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(getResources().getText(2131887251));
    localStringBuilder.append(paramString);
    localTextView.setText(localStringBuilder.toString());
    ThreadManager.getUIHandlerV2().postDelayed(this.G, 3000L);
    b("Tips");
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (!paramBoolean2)
    {
      this.l.setVisibility(4);
      this.m.setVisibility(8);
      return;
    }
    this.l.setVisibility(0);
    this.m.setVisibility(8);
  }
  
  protected void c()
  {
    LayoutInflater.from(getContext()).inflate(2131624284, this, true);
    this.f = ((TextView)findViewById(2131448811));
    this.g = ((AVGameText)findViewById(2131448302));
    this.h = ((AVGameText)findViewById(2131448303));
    this.i = findViewById(2131437420);
    this.k = ((ImageView)findViewById(2131436460));
    this.m = findViewById(2131437582);
    this.n = findViewById(2131434340);
    this.l = ((ImageView)findViewById(2131447536));
    this.d = new GuessPictureClickStagePresenter(this);
    this.l.setVisibility(4);
    this.m.setVisibility(4);
    this.n.setVisibility(8);
    super.c();
  }
  
  public void d()
  {
    if (this.o != null) {
      this.k.setImageBitmap(this.o);
    }
    if (this.m != null)
    {
      this.f.setVisibility(8);
      this.m.setVisibility(8);
    }
    if (this.i != null) {
      this.i.setVisibility(8);
    }
    this.f.setText("");
    this.v = 0;
    this.u = null;
    ThreadManager.getUIHandlerV2().removeCallbacks(this.F);
    b("Origin Image");
  }
  
  public void setFontStyle(FontStyleConfig paramFontStyleConfig)
  {
    super.setFontStyle(paramFontStyleConfig);
    this.f.setTextSize(paramFontStyleConfig.h);
    this.f.setTextColor(Color.parseColor(paramFontStyleConfig.g));
    QuestionOptionItemConfig localQuestionOptionItemConfig = new QuestionOptionItemConfig(paramFontStyleConfig.l, Color.parseColor(paramFontStyleConfig.m), Color.parseColor(paramFontStyleConfig.k), paramFontStyleConfig.B, Color.parseColor(paramFontStyleConfig.A), paramFontStyleConfig.D, Color.parseColor(paramFontStyleConfig.C));
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("FontStyleConfig :");
      localStringBuilder.append(paramFontStyleConfig.toString());
      QLog.i("GuessPictureClickStageView", 2, localStringBuilder.toString());
    }
    this.a.setConfig(localQuestionOptionItemConfig);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gameroom.stage.guesspicture.GuessPictureClickStageView
 * JD-Core Version:    0.7.0.1
 */