package com.tencent.avgame.gameroom.stage.guesspicture;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.avgame.gamelogic.data.Player;
import com.tencent.avgame.session.AVGameUserInfo;
import com.tencent.avgame.ui.AVGameText;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import java.util.ArrayList;
import java.util.List;
import mqq.os.MqqHandler;
import nfc;
import nfh;
import ngg;
import nin;
import nkv;
import nkw;
import nkx;
import nky;
import nlk;
import nll;
import nlm;
import nln;
import nqf;
import nqr;
import nqu;
import nqw;
import nrc;
import nrd;

public class GuessPictureStageView
  extends RelativeLayout
  implements Handler.Callback, nkw, nrd
{
  int jdField_a_of_type_Int = 0;
  public Bitmap a;
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), this);
  View jdField_a_of_type_AndroidViewView;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  AVGameText jdField_a_of_type_ComTencentAvgameUiAVGameText;
  URLDrawable jdField_a_of_type_ComTencentImageURLDrawable;
  public Runnable a;
  ArrayList<Pair<Integer, String>> jdField_a_of_type_JavaUtilArrayList;
  private List<nqw> jdField_a_of_type_JavaUtilList = new ArrayList();
  public nkx a;
  public nlk a;
  private nrc jdField_a_of_type_Nrc;
  private volatile boolean jdField_a_of_type_Boolean = true;
  public View b;
  ImageView jdField_b_of_type_AndroidWidgetImageView;
  public TextView b;
  AVGameText jdField_b_of_type_ComTencentAvgameUiAVGameText;
  public Runnable b;
  View jdField_c_of_type_AndroidViewView;
  ImageView jdField_c_of_type_AndroidWidgetImageView;
  public Runnable c;
  public Runnable d = new GuessPictureStageView.4(this);
  
  public GuessPictureStageView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public GuessPictureStageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public GuessPictureStageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_JavaLangRunnable = new GuessPictureStageView.1(this);
    this.jdField_b_of_type_JavaLangRunnable = new GuessPictureStageView.2(this);
    this.jdField_c_of_type_JavaLangRunnable = new GuessPictureStageView.3(this);
    c();
  }
  
  private void a(Bitmap paramBitmap, int paramInt)
  {
    ThreadManager.getFileThreadHandler().post(new GuessPictureStageView.8(this, paramBitmap, paramInt));
  }
  
  private void a(ngg paramngg)
  {
    if (QLog.isColorLevel()) {
      QLog.i("GuessPictureStageView", 2, "onShowMosaicImageGameMosaicImage() topicMosaicGuess:" + paramngg);
    }
    if (paramngg == null)
    {
      this.jdField_b_of_type_AndroidWidgetImageView.setImageBitmap(null);
      ThreadManager.getUIHandlerV2().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      return;
    }
    Object localObject = paramngg.b();
    if ((TextUtils.isEmpty((CharSequence)localObject)) || (!((String)localObject).startsWith("http")))
    {
      QLog.i("GuessPictureStageView", 1, "onShowMosaicImageGameMosaicImage() illegal url:" + (String)localObject);
      b();
      return;
    }
    this.jdField_a_of_type_ComTencentImageURLDrawable = URLDrawable.getDrawable((String)localObject, null);
    int i;
    if (this.jdField_a_of_type_ComTencentImageURLDrawable.getStatus() == 1)
    {
      localObject = nqr.a(this.jdField_a_of_type_ComTencentImageURLDrawable.getCurrDrawable());
      this.jdField_a_of_type_AndroidGraphicsBitmap = ((Bitmap)localObject);
      if (paramngg.c == 0)
      {
        i = 10;
        label151:
        a((Bitmap)localObject, i);
        label157:
        localObject = paramngg.a();
        if ((localObject[0] == null) || (localObject[0].length() == 0) || (localObject[1] == null) || (localObject[1].length() == 0) || (localObject[2] == null) || (localObject[2].length() == 0)) {
          break label486;
        }
        if (paramngg.a() == 0L) {
          break label467;
        }
        i = 1;
        label218:
        this.jdField_a_of_type_ComTencentAvgameUiAVGameText.setAttribute("#FFFFFF", localObject[2]);
        this.jdField_a_of_type_ComTencentAvgameUiAVGameText.setText(localObject[0]);
        this.jdField_b_of_type_ComTencentAvgameUiAVGameText.setAttribute("#FFC000", "#FFFFFF");
        this.jdField_b_of_type_ComTencentAvgameUiAVGameText.setText(localObject[1]);
        if (i == 0) {
          break label472;
        }
        ThreadManager.getUIHandlerV2().removeCallbacks(this.jdField_c_of_type_JavaLangRunnable);
        ThreadManager.getUIHandlerV2().removeCallbacks(this.d);
        ThreadManager.getUIHandlerV2().post(this.d);
        ThreadManager.getUIHandlerV2().postDelayed(this.jdField_c_of_type_JavaLangRunnable, 1600L);
      }
    }
    for (;;)
    {
      if (paramngg.a() != 0L)
      {
        ThreadManager.getUIHandlerV2().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
        if (this.jdField_b_of_type_AndroidViewView != null)
        {
          this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
          this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
          this.jdField_b_of_type_AndroidViewView.setVisibility(8);
        }
      }
      this.jdField_a_of_type_JavaUtilArrayList = paramngg.jdField_a_of_type_JavaUtilArrayList;
      if ((this.jdField_a_of_type_JavaUtilArrayList == null) || (this.jdField_a_of_type_JavaUtilArrayList.size() <= 0)) {
        break;
      }
      this.jdField_a_of_type_Int = 0;
      ThreadManager.getUIHandlerV2().postDelayed(this.jdField_a_of_type_JavaLangRunnable, ((Integer)((Pair)this.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_Int)).first).intValue() * 1000);
      return;
      i = paramngg.c;
      break label151;
      this.jdField_a_of_type_ComTencentImageURLDrawable.setURLDrawableListener(new nln(this, paramngg));
      this.jdField_a_of_type_ComTencentImageURLDrawable.startDownload();
      break label157;
      label467:
      i = 0;
      break label218;
      label472:
      ThreadManager.getUIHandlerV2().post(this.jdField_c_of_type_JavaLangRunnable);
      continue;
      label486:
      ThreadManager.getUIHandlerV2().removeCallbacks(this.d);
      ThreadManager.getUIHandlerV2().post(this.d);
    }
  }
  
  private void c()
  {
    LayoutInflater.from(getContext()).inflate(2131558737, this, true);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131380209));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131380207));
    this.jdField_a_of_type_ComTencentAvgameUiAVGameText = ((AVGameText)findViewById(2131379804));
    this.jdField_b_of_type_ComTencentAvgameUiAVGameText = ((AVGameText)findViewById(2131379805));
    this.jdField_a_of_type_AndroidViewView = findViewById(2131370308);
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131369464));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131365264));
    this.jdField_b_of_type_AndroidViewView = findViewById(2131370413);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131378348));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new nll(this));
    this.jdField_c_of_type_AndroidViewView = findViewById(2131367809);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(0, nqu.b());
    this.jdField_b_of_type_AndroidViewView.getLayoutParams().width = nqu.a();
    this.jdField_a_of_type_Nlk = new nlk(this);
    this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(4);
    this.jdField_b_of_type_AndroidViewView.setVisibility(4);
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
    this.jdField_c_of_type_AndroidViewView.setVisibility(8);
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_Nrc == null)
    {
      QLog.d("GuessPictureStageView", 1, "startRecord fail, mGameRecordCtrl null");
      return;
    }
    this.jdField_a_of_type_Nrc.a(this, getWidth(), getHeight());
  }
  
  public ImageView a()
  {
    return this.jdField_c_of_type_AndroidWidgetImageView;
  }
  
  public ArrayList<nqw> a()
  {
    try
    {
      this.jdField_a_of_type_Boolean = false;
      ArrayList localArrayList = new ArrayList(this.jdField_a_of_type_JavaUtilList);
      return localArrayList;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public nkv a()
  {
    return this.jdField_a_of_type_Nlk;
  }
  
  public void a()
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
  
  public void a(Player paramPlayer, AVGameUserInfo paramAVGameUserInfo)
  {
    if (nin.k <= 0)
    {
      this.jdField_c_of_type_AndroidViewView.setVisibility(0);
      return;
    }
    this.jdField_c_of_type_AndroidViewView.setVisibility(8);
  }
  
  public void a(String paramString)
  {
    this.jdField_b_of_type_AndroidWidgetTextView.setText(paramString);
    if ((paramString != null) && (paramString.length() > 5)) {
      this.jdField_b_of_type_AndroidWidgetTextView.setTextSize(0, nqu.d());
    }
    for (;;)
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setText(paramString);
      this.jdField_b_of_type_AndroidWidgetTextView.getViewTreeObserver().addOnGlobalLayoutListener(new nlm(this, paramString));
      ThreadManager.getUIHandlerV2().postDelayed(this.jdField_b_of_type_JavaLangRunnable, 3000L);
      b("Tips");
      return;
      this.jdField_b_of_type_AndroidWidgetTextView.setTextSize(0, nqu.c());
    }
  }
  
  public void a(nfh paramnfh)
  {
    a((ngg)paramnfh);
  }
  
  public void a(nky paramnky)
  {
    this.jdField_a_of_type_Nlk.a(paramnky);
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
    } while (nfc.a().f());
    if (paramBoolean1)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
  }
  
  public boolean a()
  {
    try
    {
      boolean bool = this.jdField_a_of_type_Boolean;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void b()
  {
    this.jdField_a_of_type_AndroidGraphicsBitmap = nqf.a("avgame_float_masaic_guess_place_holder@2x.png");
    if (this.jdField_a_of_type_AndroidGraphicsBitmap != null) {
      this.jdField_b_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap);
    }
  }
  
  public void b(String paramString)
  {
    for (;;)
    {
      nqw localnqw;
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("GuessPictureStageView", 2, new Object[] { "updateGameImageData, from ", paramString });
        }
        this.jdField_a_of_type_Boolean = true;
        this.jdField_a_of_type_JavaUtilList.clear();
        localnqw = new nqw();
        Object localObject = (BitmapDrawable)this.jdField_b_of_type_AndroidWidgetImageView.getDrawable();
        if (localObject != null)
        {
          localObject = ((BitmapDrawable)localObject).getBitmap();
          if (localObject != null)
          {
            boolean bool = ((Bitmap)localObject).isRecycled();
            if (!bool) {
              continue;
            }
          }
        }
        return;
        localnqw.jdField_a_of_type_AndroidGraphicsBitmap = Bitmap.createBitmap((Bitmap)localObject);
        localnqw.jdField_a_of_type_JavaLangString = paramString;
        localnqw.b = "Back Image";
        this.jdField_a_of_type_JavaUtilList.add(localnqw);
      }
      finally {}
      try
      {
        localnqw = nqw.a(this.jdField_b_of_type_AndroidViewView);
        if (localnqw != null)
        {
          localnqw.jdField_a_of_type_JavaLangString = paramString;
          localnqw.b = "Tips";
          this.jdField_a_of_type_JavaUtilList.add(localnqw);
        }
      }
      catch (Exception paramString)
      {
        QLog.e("GuessPictureStageView", 1, "get drawingCache error", paramString);
        continue;
      }
      if (this.jdField_a_of_type_Nrc != null) {
        this.jdField_a_of_type_Nrc.a(new ArrayList(this.jdField_a_of_type_JavaUtilList));
      }
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
        d();
      }
    }
  }
  
  public void setGameRecordCtrl(nrc paramnrc)
  {
    this.jdField_a_of_type_Nrc = paramnrc;
  }
  
  public void setOnSwitchTopicClickListener(nkx paramnkx)
  {
    this.jdField_a_of_type_Nkx = paramnkx;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.avgame.gameroom.stage.guesspicture.GuessPictureStageView
 * JD-Core Version:    0.7.0.1
 */