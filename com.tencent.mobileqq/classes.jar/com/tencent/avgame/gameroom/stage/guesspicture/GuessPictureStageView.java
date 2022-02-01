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
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import java.util.ArrayList;
import java.util.List;
import mqq.os.MqqHandler;
import mxq;
import mym;
import nak;
import nbl;
import nbm;
import nbn;
import nbz;
import nca;
import ncb;
import nfx;
import ngh;
import ngk;
import ngm;
import ngs;
import ngt;

public class GuessPictureStageView
  extends RelativeLayout
  implements Handler.Callback, nbm, ngt
{
  int jdField_a_of_type_Int = 0;
  public Bitmap a;
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), this);
  public View a;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  URLDrawable jdField_a_of_type_ComTencentImageURLDrawable;
  public Runnable a;
  ArrayList<Pair<Integer, String>> jdField_a_of_type_JavaUtilArrayList;
  private List<ngm> jdField_a_of_type_JavaUtilList = new ArrayList();
  public nbz a;
  private ngs jdField_a_of_type_Ngs;
  private volatile boolean jdField_a_of_type_Boolean = true;
  View jdField_b_of_type_AndroidViewView;
  ImageView jdField_b_of_type_AndroidWidgetImageView;
  public TextView b;
  public Runnable b;
  
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
    c();
  }
  
  private void a(Bitmap paramBitmap, int paramInt)
  {
    ThreadManager.getFileThreadHandler().post(new GuessPictureStageView.5(this, paramBitmap, paramInt));
  }
  
  private void a(mym parammym)
  {
    if (QLog.isColorLevel()) {
      QLog.i("GuessPictureStageView", 2, "onShowMosaicImageGameMosaicImage() topicMosaicGuess:" + parammym);
    }
    if (parammym == null)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(null);
      ThreadManager.getUIHandlerV2().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      return;
    }
    Object localObject = parammym.b();
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
      localObject = ngh.a(this.jdField_a_of_type_ComTencentImageURLDrawable.getCurrDrawable());
      this.jdField_a_of_type_AndroidGraphicsBitmap = ((Bitmap)localObject);
      if (parammym.c == 0)
      {
        i = 10;
        label151:
        a((Bitmap)localObject, i);
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_JavaUtilArrayList = parammym.jdField_a_of_type_JavaUtilArrayList;
      if ((this.jdField_a_of_type_JavaUtilArrayList == null) || (this.jdField_a_of_type_JavaUtilArrayList.size() <= 0)) {
        break;
      }
      this.jdField_a_of_type_Int = 0;
      ThreadManager.getUIHandlerV2().postDelayed(this.jdField_a_of_type_JavaLangRunnable, ((Integer)((Pair)this.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_Int)).first).intValue() * 1000);
      return;
      i = parammym.c;
      break label151;
      this.jdField_a_of_type_ComTencentImageURLDrawable.setURLDrawableListener(new ncb(this, parammym));
      this.jdField_a_of_type_ComTencentImageURLDrawable.startDownload();
    }
  }
  
  private void c()
  {
    LayoutInflater.from(getContext()).inflate(2131558715, this, true);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131379956));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131379954));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131369190));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131365106));
    this.jdField_a_of_type_AndroidViewView = findViewById(2131370166);
    this.jdField_b_of_type_AndroidViewView = findViewById(2131367572);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(0, ngk.b());
    this.jdField_a_of_type_AndroidViewView.getLayoutParams().width = ngk.a();
    this.jdField_a_of_type_Nbz = new nbz(this);
    this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(4);
    this.jdField_a_of_type_AndroidViewView.setVisibility(4);
    this.jdField_b_of_type_AndroidViewView.setVisibility(8);
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_Ngs == null)
    {
      QLog.d("GuessPictureStageView", 1, "startRecord fail, mGameRecordCtrl null");
      return;
    }
    this.jdField_a_of_type_Ngs.a(this, getWidth(), getHeight());
  }
  
  public ImageView a()
  {
    return this.jdField_b_of_type_AndroidWidgetImageView;
  }
  
  public ArrayList<ngm> a()
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
  
  public nbl a()
  {
    return this.jdField_a_of_type_Nbz;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_AndroidGraphicsBitmap != null) {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap);
    }
    if (this.jdField_a_of_type_AndroidViewView != null)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
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
    if (nak.k <= 0)
    {
      this.jdField_b_of_type_AndroidViewView.setVisibility(0);
      return;
    }
    this.jdField_b_of_type_AndroidViewView.setVisibility(8);
  }
  
  public void a(String paramString)
  {
    this.jdField_b_of_type_AndroidWidgetTextView.setText(paramString);
    if ((paramString != null) && (paramString.length() > 5)) {
      this.jdField_b_of_type_AndroidWidgetTextView.setTextSize(0, ngk.d());
    }
    for (;;)
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setText(paramString);
      this.jdField_b_of_type_AndroidWidgetTextView.getViewTreeObserver().addOnGlobalLayoutListener(new nca(this, paramString));
      ThreadManager.getUIHandlerV2().postDelayed(this.jdField_b_of_type_JavaLangRunnable, 3000L);
      b("Tips");
      return;
      this.jdField_b_of_type_AndroidWidgetTextView.setTextSize(0, ngk.c());
    }
  }
  
  public void a(mxq parammxq)
  {
    a((mym)parammxq);
  }
  
  public void a(nbn paramnbn)
  {
    this.jdField_a_of_type_Nbz.a(paramnbn);
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
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(4);
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      return;
    }
    this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
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
    this.jdField_a_of_type_AndroidGraphicsBitmap = nfx.a("avgame_float_masaic_guess_place_holder@2x.png");
    if (this.jdField_a_of_type_AndroidGraphicsBitmap != null) {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap);
    }
  }
  
  public void b(String paramString)
  {
    for (;;)
    {
      ngm localngm;
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("GuessPictureStageView", 2, new Object[] { "updateGameImageData, from ", paramString });
        }
        this.jdField_a_of_type_Boolean = true;
        this.jdField_a_of_type_JavaUtilList.clear();
        localngm = new ngm();
        Object localObject = (BitmapDrawable)this.jdField_a_of_type_AndroidWidgetImageView.getDrawable();
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
        localngm.jdField_a_of_type_AndroidGraphicsBitmap = Bitmap.createBitmap((Bitmap)localObject);
        localngm.jdField_a_of_type_JavaLangString = paramString;
        localngm.b = "Back Image";
        this.jdField_a_of_type_JavaUtilList.add(localngm);
      }
      finally {}
      try
      {
        localngm = ngm.a(this.jdField_a_of_type_AndroidViewView);
        if (localngm != null)
        {
          localngm.jdField_a_of_type_JavaLangString = paramString;
          localngm.b = "Tips";
          this.jdField_a_of_type_JavaUtilList.add(localngm);
        }
      }
      catch (Exception paramString)
      {
        QLog.e("GuessPictureStageView", 1, "get drawingCache error", paramString);
        continue;
      }
      if (this.jdField_a_of_type_Ngs != null) {
        this.jdField_a_of_type_Ngs.a(new ArrayList(this.jdField_a_of_type_JavaUtilList));
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
      if ((this.jdField_a_of_type_AndroidWidgetImageView != null) && ((paramMessage.obj instanceof Bitmap)))
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap((Bitmap)paramMessage.obj);
        b("Mosaic Image");
        d();
      }
    }
  }
  
  public void setGameRecordCtrl(ngs paramngs)
  {
    this.jdField_a_of_type_Ngs = paramngs;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.avgame.gameroom.stage.guesspicture.GuessPictureStageView
 * JD-Core Version:    0.7.0.1
 */