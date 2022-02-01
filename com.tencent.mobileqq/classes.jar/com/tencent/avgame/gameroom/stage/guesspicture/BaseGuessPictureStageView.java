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
import com.tencent.avgame.data.FontStyleConfig;
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
import com.tencent.avgame.qav.videorecord.GameImageData;
import com.tencent.avgame.qav.videorecord.IGuessPictureGameRecordCtrl;
import com.tencent.avgame.qav.videorecord.IGuessPictureGameRecordCtrl.GameImageDataProvider;
import com.tencent.avgame.session.AVGameUserInfo;
import com.tencent.avgame.ui.AVGameText;
import com.tencent.avgame.util.AVGameUtil;
import com.tencent.avgame.util.MosaicUtil;
import com.tencent.avgame.util.UiUtils;
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
  implements Handler.Callback, IGuessPictureGameRecordCtrl.GameImageDataProvider
{
  volatile boolean A = true;
  List<GameImageData> B = new ArrayList();
  IGuessPictureGameRecordCtrl C;
  protected String D = null;
  public Handler E = new Handler(Looper.getMainLooper(), this);
  IGameStageView.SwitchTopicClickListener c;
  IGameStagePresenter d;
  TextView e;
  TextView f;
  AVGameText g;
  AVGameText h;
  View i;
  ImageView j;
  ImageView k;
  ImageView l;
  View m;
  View n;
  Bitmap o;
  URLDrawable p;
  TextView q;
  View r;
  TextView s;
  boolean t = false;
  ArrayList<Pair<Integer, String>> u;
  int v = 0;
  public Runnable w = new BaseGuessPictureStageView.1(this);
  public Runnable x = new BaseGuessPictureStageView.2(this);
  public Runnable y = new BaseGuessPictureStageView.3(this);
  public Runnable z = new BaseGuessPictureStageView.4(this);
  
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
    c();
  }
  
  private void h()
  {
    IGuessPictureGameRecordCtrl localIGuessPictureGameRecordCtrl = this.C;
    if (localIGuessPictureGameRecordCtrl == null)
    {
      QLog.d("BaseGuessPictureStageView", 1, "startRecord fail, mGameRecordCtrl null");
      return;
    }
    localIGuessPictureGameRecordCtrl.a(this, getWidth(), getHeight());
  }
  
  public void a(ITopic paramITopic)
  {
    b(paramITopic);
    a((TopicMosaicGuess)paramITopic);
  }
  
  public void a(Player paramPlayer, AVGameUserInfo paramAVGameUserInfo)
  {
    if (GameRoomViewLayoutParamsDef.w <= 0)
    {
      this.n.setVisibility(0);
      return;
    }
    this.n.setVisibility(8);
  }
  
  public void a(TopicMosaicGuess paramTopicMosaicGuess)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onShowMosaicImageGameMosaicImage() topicMosaicGuess:");
      ((StringBuilder)localObject).append(paramTopicMosaicGuess);
      QLog.i("BaseGuessPictureStageView", 2, ((StringBuilder)localObject).toString());
    }
    if (paramTopicMosaicGuess == null)
    {
      this.k.setImageBitmap(null);
      ThreadManager.getUIHandlerV2().removeCallbacks(this.w);
      return;
    }
    this.D = paramTopicMosaicGuess.e();
    if ((!TextUtils.isEmpty(this.D)) && (this.D.startsWith("http")))
    {
      this.p = URLDrawable.getDrawable(this.D, null);
      int i1;
      if (this.p.getStatus() == 1)
      {
        localObject = MosaicUtil.a(this.p.getCurrDrawable());
        this.o = ((Bitmap)localObject);
        if (paramTopicMosaicGuess.m == 0) {
          i1 = 10;
        } else {
          i1 = paramTopicMosaicGuess.m;
        }
        setMosaicBitmapFromOriginal((Bitmap)localObject, i1);
      }
      else
      {
        this.p.setURLDrawableListener(new BaseGuessPictureStageView.6(this, paramTopicMosaicGuess));
        this.p.startDownload();
      }
      localObject = paramTopicMosaicGuess.g();
      if ((localObject[0] != null) && (localObject[0].length() != 0) && (localObject[1] != null) && (localObject[1].length() != 0) && (localObject[2] != null) && (localObject[2].length() != 0))
      {
        if (paramTopicMosaicGuess.h() != 0L) {
          i1 = 1;
        } else {
          i1 = 0;
        }
        this.g.setAttribute("#FFFFFF", localObject[2]);
        this.g.setText(localObject[0]);
        this.h.setAttribute("#FFC000", "#FFFFFF");
        this.h.setText(localObject[1]);
        if (i1 != 0)
        {
          ThreadManager.getUIHandlerV2().removeCallbacks(this.y);
          ThreadManager.getUIHandlerV2().removeCallbacks(this.z);
          ThreadManager.getUIHandlerV2().post(this.z);
          ThreadManager.getUIHandlerV2().postDelayed(this.y, 1600L);
        }
        else
        {
          ThreadManager.getUIHandlerV2().post(this.y);
        }
      }
      else
      {
        ThreadManager.getUIHandlerV2().removeCallbacks(this.z);
        ThreadManager.getUIHandlerV2().post(this.z);
      }
      if (paramTopicMosaicGuess.h() != 0L)
      {
        ThreadManager.getUIHandlerV2().removeCallbacks(this.w);
        if (this.m != null)
        {
          this.e.setVisibility(8);
          this.f.setVisibility(8);
          this.m.setVisibility(8);
        }
      }
      this.u = paramTopicMosaicGuess.k;
      localObject = this.u;
      if ((localObject != null) && (((ArrayList)localObject).size() > 0))
      {
        this.v = 0;
        ThreadManager.getUIHandlerV2().postDelayed(this.w, ((Integer)((Pair)this.u.get(this.v)).first).intValue() * 1000);
      }
      paramTopicMosaicGuess = paramTopicMosaicGuess.r;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onShowMosaicImageGameMosaicImage() businessAdsTips:");
        ((StringBuilder)localObject).append(paramTopicMosaicGuess);
        QLog.i("BaseGuessPictureStageView", 2, ((StringBuilder)localObject).toString());
      }
      if (!TextUtils.isEmpty(paramTopicMosaicGuess)) {
        this.d.a().a().b(paramTopicMosaicGuess);
      }
      return;
    }
    paramTopicMosaicGuess = new StringBuilder();
    paramTopicMosaicGuess.append("onShowMosaicImageGameMosaicImage() illegal url:");
    paramTopicMosaicGuess.append(this.D);
    QLog.i("BaseGuessPictureStageView", 1, paramTopicMosaicGuess.toString());
    e();
  }
  
  public void a(String paramString)
  {
    this.f.setText(paramString);
    if ((paramString != null) && (paramString.length() > 5)) {
      this.f.setTextSize(0, UiUtils.d());
    } else {
      this.f.setTextSize(0, UiUtils.c());
    }
    this.f.setText(paramString);
    this.f.getViewTreeObserver().addOnGlobalLayoutListener(new BaseGuessPictureStageView.5(this, paramString));
    ThreadManager.getUIHandlerV2().postDelayed(this.x, 3000L);
    b("Tips");
  }
  
  public void a(boolean paramBoolean)
  {
    int i1;
    if (paramBoolean) {
      i1 = 0;
    } else {
      i1 = 8;
    }
    setVisibility(i1);
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (!paramBoolean2)
    {
      this.l.setVisibility(4);
      this.m.setVisibility(8);
      this.j.setVisibility(4);
      return;
    }
    this.l.setVisibility(0);
    this.m.setVisibility(8);
    if ((!GameEngine.a().A()) && (!this.t))
    {
      if (paramBoolean1)
      {
        this.j.setVisibility(0);
        return;
      }
      this.j.setVisibility(4);
    }
  }
  
  public boolean a()
  {
    return this.t;
  }
  
  public void b(IStagePresenter paramIStagePresenter)
  {
    this.d.a(paramIStagePresenter);
    a(paramIStagePresenter);
  }
  
  public void b(String paramString)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("BaseGuessPictureStageView", 2, new Object[] { "updateGameImageData, from ", paramString });
      }
      this.A = true;
      this.B.clear();
      Object localObject1 = new GameImageData();
      Object localObject2 = (BitmapDrawable)this.k.getDrawable();
      if ((localObject2 != null) && (this.C != null))
      {
        localObject2 = ((BitmapDrawable)localObject2).getBitmap();
        if ((localObject2 != null) && (!((Bitmap)localObject2).isRecycled()))
        {
          ((GameImageData)localObject1).a = Bitmap.createBitmap((Bitmap)localObject2);
          ((GameImageData)localObject1).g = paramString;
          ((GameImageData)localObject1).h = "Back Image";
          this.B.add(localObject1);
          localObject1 = this.m;
          if (localObject1 != null) {
            try
            {
              localObject1 = GameImageData.a(this.m);
              if (localObject1 != null)
              {
                ((GameImageData)localObject1).g = paramString;
                ((GameImageData)localObject1).h = "Tips";
                this.B.add(localObject1);
              }
            }
            catch (Exception paramString)
            {
              QLog.e("BaseGuessPictureStageView", 1, "get drawingCache error", paramString);
            }
          }
          if (this.C != null) {
            this.C.a(new ArrayList(this.B));
          }
          return;
        }
        return;
      }
      return;
    }
    finally {}
  }
  
  protected void c()
  {
    this.q = ((TextView)findViewById(2131447504));
    this.s = ((TextView)findViewById(2131447559));
    this.r = findViewById(2131447534);
    ((RelativeLayout.LayoutParams)this.r.getLayoutParams()).topMargin = GameRoomViewLayoutParamsDef.x;
  }
  
  public void d()
  {
    Object localObject = this.o;
    if (localObject != null) {
      this.k.setImageBitmap((Bitmap)localObject);
    }
    if (this.m != null)
    {
      this.e.setVisibility(8);
      this.f.setVisibility(8);
      this.m.setVisibility(8);
    }
    localObject = this.i;
    if (localObject != null) {
      ((View)localObject).setVisibility(8);
    }
    this.f.setText("");
    this.v = 0;
    this.u = null;
    ThreadManager.getUIHandlerV2().removeCallbacks(this.w);
    b("Origin Image");
  }
  
  public void e()
  {
    this.o = AVGameUtil.c("avgame_float_masaic_guess_place_holder@2x.png");
    Bitmap localBitmap = this.o;
    if (localBitmap != null) {
      this.k.setImageBitmap(localBitmap);
    }
  }
  
  public boolean f()
  {
    try
    {
      boolean bool = this.A;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public ArrayList<GameImageData> g()
  {
    try
    {
      this.A = false;
      ArrayList localArrayList = new ArrayList(this.B);
      return localArrayList;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public IGameStagePresenter getPresenter()
  {
    return this.d;
  }
  
  public ImageView getTopicClockView()
  {
    return this.l;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if ((paramMessage.what == 1) && (this.k != null) && ((paramMessage.obj instanceof Bitmap)))
    {
      this.k.setImageBitmap((Bitmap)paramMessage.obj);
      b("Mosaic Image");
      h();
    }
    return false;
  }
  
  public void setFontStyle(FontStyleConfig paramFontStyleConfig)
  {
    this.s.setTextSize(paramFontStyleConfig.b);
    this.s.setTextColor(Color.parseColor(paramFontStyleConfig.a));
    ImageView localImageView = this.l;
    if ((localImageView instanceof CountDownClockNumLottieView)) {
      ((CountDownClockNumLottieView)localImageView).setParams(Color.parseColor(paramFontStyleConfig.c), ViewUtils.dip2px(paramFontStyleConfig.d));
    }
  }
  
  public void setGameRecordCtrl(IGuessPictureGameRecordCtrl paramIGuessPictureGameRecordCtrl)
  {
    this.C = paramIGuessPictureGameRecordCtrl;
  }
  
  public void setMosaicBitmapFromOriginal(Bitmap paramBitmap, int paramInt)
  {
    ThreadManager.getFileThreadHandler().post(new BaseGuessPictureStageView.7(this, paramBitmap, paramInt));
  }
  
  public void setOnSwitchTopicClickListener(IGameStageView.SwitchTopicClickListener paramSwitchTopicClickListener)
  {
    this.c = paramSwitchTopicClickListener;
  }
  
  public void setSpecialMode(boolean paramBoolean)
  {
    this.t = paramBoolean;
  }
  
  public void setTitleCenter(String paramString)
  {
    TextView localTextView = this.q;
    if (localTextView != null) {
      localTextView.setText(paramString);
    }
  }
  
  public void setTitleRight(String paramString)
  {
    TextView localTextView = this.s;
    if (localTextView != null) {
      localTextView.setText(paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gameroom.stage.guesspicture.BaseGuessPictureStageView
 * JD-Core Version:    0.7.0.1
 */