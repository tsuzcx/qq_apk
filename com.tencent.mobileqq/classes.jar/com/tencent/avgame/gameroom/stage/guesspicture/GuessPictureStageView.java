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
import myp;
import mzp;
import nbo;
import ncy;
import ncz;
import nda;
import ndm;
import ndn;
import ndo;
import nhs;
import nic;
import nif;
import nih;
import nin;
import nio;

public class GuessPictureStageView
  extends RelativeLayout
  implements Handler.Callback, ncz, nio
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
  private List<nih> jdField_a_of_type_JavaUtilList = new ArrayList();
  public ndm a;
  private nin jdField_a_of_type_Nin;
  private volatile boolean jdField_a_of_type_Boolean = true;
  public View b;
  ImageView jdField_b_of_type_AndroidWidgetImageView;
  public TextView b;
  AVGameText jdField_b_of_type_ComTencentAvgameUiAVGameText;
  public Runnable b;
  View c;
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
    ThreadManager.getFileThreadHandler().post(new GuessPictureStageView.7(this, paramBitmap, paramInt));
  }
  
  private void a(mzp parammzp)
  {
    if (QLog.isColorLevel()) {
      QLog.i("GuessPictureStageView", 2, "onShowMosaicImageGameMosaicImage() topicMosaicGuess:" + parammzp);
    }
    if (parammzp == null)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(null);
      ThreadManager.getUIHandlerV2().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      return;
    }
    Object localObject = parammzp.b();
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
      localObject = nic.a(this.jdField_a_of_type_ComTencentImageURLDrawable.getCurrDrawable());
      this.jdField_a_of_type_AndroidGraphicsBitmap = ((Bitmap)localObject);
      if (parammzp.c == 0)
      {
        i = 10;
        label151:
        a((Bitmap)localObject, i);
        label157:
        localObject = parammzp.a();
        if ((localObject[0] == null) || (localObject[0].length() == 0) || (localObject[1] == null) || (localObject[1].length() == 0) || (localObject[2] == null) || (localObject[2].length() == 0)) {
          break label365;
        }
        this.jdField_a_of_type_ComTencentAvgameUiAVGameText.setAttribute("#FFFFFF", localObject[2]);
        this.jdField_a_of_type_ComTencentAvgameUiAVGameText.setText(localObject[0]);
        this.jdField_b_of_type_ComTencentAvgameUiAVGameText.setAttribute("#FFC000", "#FFFFFF");
        this.jdField_b_of_type_ComTencentAvgameUiAVGameText.setText(localObject[1]);
        ThreadManager.getUIHandlerV2().post(this.jdField_c_of_type_JavaLangRunnable);
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_JavaUtilArrayList = parammzp.jdField_a_of_type_JavaUtilArrayList;
      if ((this.jdField_a_of_type_JavaUtilArrayList == null) || (this.jdField_a_of_type_JavaUtilArrayList.size() <= 0)) {
        break;
      }
      this.jdField_a_of_type_Int = 0;
      ThreadManager.getUIHandlerV2().postDelayed(this.jdField_a_of_type_JavaLangRunnable, ((Integer)((Pair)this.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_Int)).first).intValue() * 1000);
      return;
      i = parammzp.c;
      break label151;
      this.jdField_a_of_type_ComTencentImageURLDrawable.setURLDrawableListener(new ndo(this, parammzp));
      this.jdField_a_of_type_ComTencentImageURLDrawable.startDownload();
      break label157;
      label365:
      ThreadManager.getUIHandlerV2().removeCallbacks(this.d);
      ThreadManager.getUIHandlerV2().post(this.d);
    }
  }
  
  private void c()
  {
    LayoutInflater.from(getContext()).inflate(2131558717, this, true);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131380140));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131380138));
    this.jdField_a_of_type_ComTencentAvgameUiAVGameText = ((AVGameText)findViewById(2131379711));
    this.jdField_b_of_type_ComTencentAvgameUiAVGameText = ((AVGameText)findViewById(2131379712));
    this.jdField_a_of_type_AndroidViewView = findViewById(2131370139);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131369281));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131365152));
    this.jdField_b_of_type_AndroidViewView = findViewById(2131370265);
    this.jdField_c_of_type_AndroidViewView = findViewById(2131367641);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(0, nif.b());
    this.jdField_b_of_type_AndroidViewView.getLayoutParams().width = nif.a();
    this.jdField_a_of_type_Ndm = new ndm(this);
    this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(4);
    this.jdField_b_of_type_AndroidViewView.setVisibility(4);
    this.jdField_c_of_type_AndroidViewView.setVisibility(8);
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_Nin == null)
    {
      QLog.d("GuessPictureStageView", 1, "startRecord fail, mGameRecordCtrl null");
      return;
    }
    this.jdField_a_of_type_Nin.a(this, getWidth(), getHeight());
  }
  
  public ImageView a()
  {
    return this.jdField_b_of_type_AndroidWidgetImageView;
  }
  
  public ArrayList<nih> a()
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
  
  public ncy a()
  {
    return this.jdField_a_of_type_Ndm;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_AndroidGraphicsBitmap != null) {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap);
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
    if (nbo.o <= 0)
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
      this.jdField_b_of_type_AndroidWidgetTextView.setTextSize(0, nif.d());
    }
    for (;;)
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setText(paramString);
      this.jdField_b_of_type_AndroidWidgetTextView.getViewTreeObserver().addOnGlobalLayoutListener(new ndn(this, paramString));
      ThreadManager.getUIHandlerV2().postDelayed(this.jdField_b_of_type_JavaLangRunnable, 3000L);
      b("Tips");
      return;
      this.jdField_b_of_type_AndroidWidgetTextView.setTextSize(0, nif.c());
    }
  }
  
  public void a(myp parammyp)
  {
    a((mzp)parammyp);
  }
  
  public void a(nda paramnda)
  {
    this.jdField_a_of_type_Ndm.a(paramnda);
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
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
      return;
    }
    this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
    this.jdField_b_of_type_AndroidViewView.setVisibility(8);
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
    this.jdField_a_of_type_AndroidGraphicsBitmap = nhs.a("avgame_float_masaic_guess_place_holder@2x.png");
    if (this.jdField_a_of_type_AndroidGraphicsBitmap != null) {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap);
    }
  }
  
  public void b(String paramString)
  {
    for (;;)
    {
      nih localnih;
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("GuessPictureStageView", 2, new Object[] { "updateGameImageData, from ", paramString });
        }
        this.jdField_a_of_type_Boolean = true;
        this.jdField_a_of_type_JavaUtilList.clear();
        localnih = new nih();
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
        localnih.jdField_a_of_type_AndroidGraphicsBitmap = Bitmap.createBitmap((Bitmap)localObject);
        localnih.jdField_a_of_type_JavaLangString = paramString;
        localnih.b = "Back Image";
        this.jdField_a_of_type_JavaUtilList.add(localnih);
      }
      finally {}
      try
      {
        localnih = nih.a(this.jdField_b_of_type_AndroidViewView);
        if (localnih != null)
        {
          localnih.jdField_a_of_type_JavaLangString = paramString;
          localnih.b = "Tips";
          this.jdField_a_of_type_JavaUtilList.add(localnih);
        }
      }
      catch (Exception paramString)
      {
        QLog.e("GuessPictureStageView", 1, "get drawingCache error", paramString);
        continue;
      }
      if (this.jdField_a_of_type_Nin != null) {
        this.jdField_a_of_type_Nin.a(new ArrayList(this.jdField_a_of_type_JavaUtilList));
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
  
  public void setGameRecordCtrl(nin paramnin)
  {
    this.jdField_a_of_type_Nin = paramnin;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.avgame.gameroom.stage.guesspicture.GuessPictureStageView
 * JD-Core Version:    0.7.0.1
 */