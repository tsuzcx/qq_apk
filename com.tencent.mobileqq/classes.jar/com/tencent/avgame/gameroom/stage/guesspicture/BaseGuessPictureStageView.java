package com.tencent.avgame.gameroom.stage.guesspicture;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.avgame.gamelogic.GameEngine;
import com.tencent.avgame.gamelogic.ITopic;
import com.tencent.avgame.gamelogic.data.Player;
import com.tencent.avgame.gamelogic.data.TopicMosaicGuess;
import com.tencent.avgame.gameroom.GameRoomViewLayoutParamsDef;
import com.tencent.avgame.gameroom.IGameRoomPresenter;
import com.tencent.avgame.gameroom.stage.IGameStagePresenter;
import com.tencent.avgame.gameroom.stage.IGameStageView.SwitchTopicClickListener;
import com.tencent.avgame.gameroom.stage.IStagePresenter;
import com.tencent.avgame.gameroom.stage.base.BaseGuessClickStageView;
import com.tencent.avgame.gameroom.stage.util.CountDownClockNumLottieView;
import com.tencent.avgame.gameroom.stage.util.FontStyleConfig;
import com.tencent.avgame.session.AVGameUserInfo;
import com.tencent.avgame.ui.AVGameText;
import com.tencent.avgame.util.AVGameUtils;
import com.tencent.avgame.util.MosaicUtil;
import com.tencent.avgame.util.UiUtils;
import com.tencent.avgame.videorecord.GameImageData;
import com.tencent.avgame.videorecord.GuessPictureGameRecordCtrl;
import com.tencent.avgame.videorecord.GuessPictureGameRecordCtrl.GameImageDataProvider;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import java.util.ArrayList;
import java.util.List;
import mqq.os.MqqHandler;

public class BaseGuessPictureStageView
  extends BaseGuessClickStageView
  implements Handler.Callback, GuessPictureGameRecordCtrl.GameImageDataProvider
{
  int jdField_a_of_type_Int = 0;
  Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  public Handler a;
  View jdField_a_of_type_AndroidViewView;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  IGameStagePresenter jdField_a_of_type_ComTencentAvgameGameroomStageIGameStagePresenter;
  IGameStageView.SwitchTopicClickListener jdField_a_of_type_ComTencentAvgameGameroomStageIGameStageView$SwitchTopicClickListener;
  AVGameText jdField_a_of_type_ComTencentAvgameUiAVGameText;
  GuessPictureGameRecordCtrl jdField_a_of_type_ComTencentAvgameVideorecordGuessPictureGameRecordCtrl;
  URLDrawable jdField_a_of_type_ComTencentImageURLDrawable;
  public Runnable a;
  protected String a;
  ArrayList<Pair<Integer, String>> jdField_a_of_type_JavaUtilArrayList;
  List<GameImageData> jdField_a_of_type_JavaUtilList = new ArrayList();
  boolean jdField_a_of_type_Boolean = false;
  View jdField_b_of_type_AndroidViewView;
  ImageView jdField_b_of_type_AndroidWidgetImageView;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  AVGameText jdField_b_of_type_ComTencentAvgameUiAVGameText;
  public Runnable b;
  volatile boolean jdField_b_of_type_Boolean = true;
  View jdField_c_of_type_AndroidViewView;
  ImageView jdField_c_of_type_AndroidWidgetImageView;
  TextView jdField_c_of_type_AndroidWidgetTextView;
  public Runnable c;
  View jdField_d_of_type_AndroidViewView;
  TextView jdField_d_of_type_AndroidWidgetTextView;
  public Runnable d;
  
  public BaseGuessPictureStageView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public BaseGuessPictureStageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public BaseGuessPictureStageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_JavaLangRunnable = new BaseGuessPictureStageView.1(this);
    this.jdField_b_of_type_JavaLangRunnable = new BaseGuessPictureStageView.2(this);
    this.jdField_c_of_type_JavaLangRunnable = new BaseGuessPictureStageView.3(this);
    this.jdField_d_of_type_JavaLangRunnable = new BaseGuessPictureStageView.4(this);
    this.jdField_a_of_type_JavaLangString = null;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), this);
    b();
  }
  
  private void e()
  {
    if (this.jdField_a_of_type_ComTencentAvgameVideorecordGuessPictureGameRecordCtrl == null)
    {
      QLog.d("BaseGuessPictureStageView", 1, "startRecord fail, mGameRecordCtrl null");
      return;
    }
    this.jdField_a_of_type_ComTencentAvgameVideorecordGuessPictureGameRecordCtrl.a(this, getWidth(), getHeight());
  }
  
  public ImageView a()
  {
    return this.jdField_c_of_type_AndroidWidgetImageView;
  }
  
  public IGameStagePresenter a()
  {
    return this.jdField_a_of_type_ComTencentAvgameGameroomStageIGameStagePresenter;
  }
  
  public ArrayList<GameImageData> a()
  {
    try
    {
      this.jdField_b_of_type_Boolean = false;
      ArrayList localArrayList = new ArrayList(this.jdField_a_of_type_JavaUtilList);
      return localArrayList;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void a(ITopic paramITopic)
  {
    b(paramITopic);
    a((TopicMosaicGuess)paramITopic);
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
  
  public void a(TopicMosaicGuess paramTopicMosaicGuess)
  {
    if (QLog.isColorLevel()) {
      QLog.i("BaseGuessPictureStageView", 2, "onShowMosaicImageGameMosaicImage() topicMosaicGuess:" + paramTopicMosaicGuess);
    }
    if (paramTopicMosaicGuess == null)
    {
      this.jdField_b_of_type_AndroidWidgetImageView.setImageBitmap(null);
      ThreadManager.getUIHandlerV2().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      return;
    }
    this.jdField_a_of_type_JavaLangString = paramTopicMosaicGuess.c();
    if ((TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) || (!this.jdField_a_of_type_JavaLangString.startsWith("http")))
    {
      QLog.i("BaseGuessPictureStageView", 1, "onShowMosaicImageGameMosaicImage() illegal url:" + this.jdField_a_of_type_JavaLangString);
      d();
      return;
    }
    this.jdField_a_of_type_ComTencentImageURLDrawable = URLDrawable.getDrawable(this.jdField_a_of_type_JavaLangString, null);
    int i;
    if (this.jdField_a_of_type_ComTencentImageURLDrawable.getStatus() == 1)
    {
      Object localObject = MosaicUtil.a(this.jdField_a_of_type_ComTencentImageURLDrawable.getCurrDrawable());
      this.jdField_a_of_type_AndroidGraphicsBitmap = ((Bitmap)localObject);
      if (paramTopicMosaicGuess.jdField_c_of_type_Int == 0)
      {
        i = 10;
        label166:
        setMosaicBitmapFromOriginal((Bitmap)localObject, i);
        label172:
        localObject = paramTopicMosaicGuess.a();
        if ((localObject[0] == null) || (localObject[0].length() == 0) || (localObject[1] == null) || (localObject[1].length() == 0) || (localObject[2] == null) || (localObject[2].length() == 0)) {
          break label566;
        }
        if (paramTopicMosaicGuess.a() == 0L) {
          break label547;
        }
        i = 1;
        label233:
        this.jdField_a_of_type_ComTencentAvgameUiAVGameText.setAttribute("#FFFFFF", localObject[2]);
        this.jdField_a_of_type_ComTencentAvgameUiAVGameText.setText(localObject[0]);
        this.jdField_b_of_type_ComTencentAvgameUiAVGameText.setAttribute("#FFC000", "#FFFFFF");
        this.jdField_b_of_type_ComTencentAvgameUiAVGameText.setText(localObject[1]);
        if (i == 0) {
          break label552;
        }
        ThreadManager.getUIHandlerV2().removeCallbacks(this.jdField_c_of_type_JavaLangRunnable);
        ThreadManager.getUIHandlerV2().removeCallbacks(this.jdField_d_of_type_JavaLangRunnable);
        ThreadManager.getUIHandlerV2().post(this.jdField_d_of_type_JavaLangRunnable);
        ThreadManager.getUIHandlerV2().postDelayed(this.jdField_c_of_type_JavaLangRunnable, 1600L);
      }
    }
    for (;;)
    {
      if (paramTopicMosaicGuess.a() != 0L)
      {
        ThreadManager.getUIHandlerV2().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
        if (this.jdField_b_of_type_AndroidViewView != null)
        {
          this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
          this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
          this.jdField_b_of_type_AndroidViewView.setVisibility(8);
        }
      }
      this.jdField_a_of_type_JavaUtilArrayList = paramTopicMosaicGuess.jdField_a_of_type_JavaUtilArrayList;
      if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > 0))
      {
        this.jdField_a_of_type_Int = 0;
        ThreadManager.getUIHandlerV2().postDelayed(this.jdField_a_of_type_JavaLangRunnable, ((Integer)((Pair)this.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_Int)).first).intValue() * 1000);
      }
      paramTopicMosaicGuess = paramTopicMosaicGuess.jdField_c_of_type_JavaLangString;
      if (QLog.isColorLevel()) {
        QLog.i("BaseGuessPictureStageView", 2, "onShowMosaicImageGameMosaicImage() businessAdsTips:" + paramTopicMosaicGuess);
      }
      if (TextUtils.isEmpty(paramTopicMosaicGuess)) {
        break;
      }
      this.jdField_a_of_type_ComTencentAvgameGameroomStageIGameStagePresenter.a().a().a(paramTopicMosaicGuess);
      return;
      i = paramTopicMosaicGuess.jdField_c_of_type_Int;
      break label166;
      this.jdField_a_of_type_ComTencentImageURLDrawable.setURLDrawableListener(new BaseGuessPictureStageView.6(this, paramTopicMosaicGuess));
      this.jdField_a_of_type_ComTencentImageURLDrawable.startDownload();
      break label172;
      label547:
      i = 0;
      break label233;
      label552:
      ThreadManager.getUIHandlerV2().post(this.jdField_c_of_type_JavaLangRunnable);
      continue;
      label566:
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
      this.jdField_b_of_type_AndroidWidgetTextView.getViewTreeObserver().addOnGlobalLayoutListener(new BaseGuessPictureStageView.5(this, paramString));
      ThreadManager.getUIHandlerV2().postDelayed(this.jdField_b_of_type_JavaLangRunnable, 3000L);
      b("Tips");
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
      return;
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (!paramBoolean2)
    {
      this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(4);
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
    }
    do
    {
      return;
      this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
    } while ((GameEngine.a().f()) || (this.jdField_a_of_type_Boolean));
    if (paramBoolean1)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
  }
  
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
  
  public void b(String paramString)
  {
    for (;;)
    {
      Object localObject1;
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("BaseGuessPictureStageView", 2, new Object[] { "updateGameImageData, from ", paramString });
        }
        this.jdField_b_of_type_Boolean = true;
        this.jdField_a_of_type_JavaUtilList.clear();
        localObject1 = new GameImageData();
        Object localObject2 = (BitmapDrawable)this.jdField_b_of_type_AndroidWidgetImageView.getDrawable();
        if (localObject2 != null)
        {
          localObject2 = ((BitmapDrawable)localObject2).getBitmap();
          if (localObject2 != null)
          {
            boolean bool = ((Bitmap)localObject2).isRecycled();
            if (!bool) {
              continue;
            }
          }
        }
        return;
        ((GameImageData)localObject1).jdField_a_of_type_AndroidGraphicsBitmap = Bitmap.createBitmap((Bitmap)localObject2);
        ((GameImageData)localObject1).jdField_a_of_type_JavaLangString = paramString;
        ((GameImageData)localObject1).jdField_b_of_type_JavaLangString = "Back Image";
        this.jdField_a_of_type_JavaUtilList.add(localObject1);
        localObject1 = this.jdField_b_of_type_AndroidViewView;
        if (localObject1 == null) {}
      }
      finally {}
      try
      {
        localObject1 = GameImageData.a(this.jdField_b_of_type_AndroidViewView);
        if (localObject1 != null)
        {
          ((GameImageData)localObject1).jdField_a_of_type_JavaLangString = paramString;
          ((GameImageData)localObject1).jdField_b_of_type_JavaLangString = "Tips";
          this.jdField_a_of_type_JavaUtilList.add(localObject1);
        }
      }
      catch (Exception paramString)
      {
        QLog.e("BaseGuessPictureStageView", 1, "get drawingCache error", paramString);
        continue;
      }
      if (this.jdField_a_of_type_ComTencentAvgameVideorecordGuessPictureGameRecordCtrl != null) {
        this.jdField_a_of_type_ComTencentAvgameVideorecordGuessPictureGameRecordCtrl.a(new ArrayList(this.jdField_a_of_type_JavaUtilList));
      }
    }
  }
  
  public boolean b()
  {
    try
    {
      boolean bool = this.jdField_b_of_type_Boolean;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_AndroidGraphicsBitmap != null) {
      this.jdField_b_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap);
    }
    if (this.jdField_b_of_type_AndroidViewView != null)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
    }
    if (this.jdField_a_of_type_AndroidViewView != null) {
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    }
    this.jdField_b_of_type_AndroidWidgetTextView.setText("");
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_JavaUtilArrayList = null;
    ThreadManager.getUIHandlerV2().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    b("Origin Image");
  }
  
  public void d()
  {
    this.jdField_a_of_type_AndroidGraphicsBitmap = AVGameUtils.a("avgame_float_masaic_guess_place_holder@2x.png");
    if (this.jdField_a_of_type_AndroidGraphicsBitmap != null) {
      this.jdField_b_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap);
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return false;
      if ((this.jdField_b_of_type_AndroidWidgetImageView != null) && ((paramMessage.obj instanceof Bitmap)))
      {
        this.jdField_b_of_type_AndroidWidgetImageView.setImageBitmap((Bitmap)paramMessage.obj);
        b("Mosaic Image");
        e();
      }
    }
  }
  
  public void setFontStyle(FontStyleConfig paramFontStyleConfig)
  {
    this.jdField_d_of_type_AndroidWidgetTextView.setTextSize(paramFontStyleConfig.jdField_a_of_type_Int);
    this.jdField_d_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor(paramFontStyleConfig.jdField_a_of_type_JavaLangString));
    if ((this.jdField_c_of_type_AndroidWidgetImageView instanceof CountDownClockNumLottieView)) {
      ((CountDownClockNumLottieView)this.jdField_c_of_type_AndroidWidgetImageView).setParams(Color.parseColor(paramFontStyleConfig.jdField_b_of_type_JavaLangString), ViewUtils.a(paramFontStyleConfig.jdField_b_of_type_Int));
    }
  }
  
  public void setGameRecordCtrl(GuessPictureGameRecordCtrl paramGuessPictureGameRecordCtrl)
  {
    this.jdField_a_of_type_ComTencentAvgameVideorecordGuessPictureGameRecordCtrl = paramGuessPictureGameRecordCtrl;
  }
  
  public void setMosaicBitmapFromOriginal(Bitmap paramBitmap, int paramInt)
  {
    ThreadManager.getFileThreadHandler().post(new BaseGuessPictureStageView.7(this, paramBitmap, paramInt));
  }
  
  public void setOnSwitchTopicClickListener(IGameStageView.SwitchTopicClickListener paramSwitchTopicClickListener)
  {
    this.jdField_a_of_type_ComTencentAvgameGameroomStageIGameStageView$SwitchTopicClickListener = paramSwitchTopicClickListener;
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
 * Qualified Name:     com.tencent.avgame.gameroom.stage.guesspicture.BaseGuessPictureStageView
 * JD-Core Version:    0.7.0.1
 */