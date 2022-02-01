package com.tencent.avgame.gameroom.stage.guesssong;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Handler;
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
import com.tencent.mobileqq.dinifly.LottieDrawable;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import java.util.ArrayList;
import mzl;
import mzq;
import naf;
import nas;
import nav;
import nbx;
import ncp;
import ncq;
import ned;
import nee;
import neg;
import new;
import nex;
import ney;
import nez;
import nju;

public class GuessSongStageView
  extends RelativeLayout
  implements nee
{
  int jdField_a_of_type_Int = 0;
  public View a;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  AVGameText jdField_a_of_type_ComTencentAvgameUiAVGameText;
  public LottieDrawable a;
  public Runnable a;
  ArrayList<Pair<Integer, String>> jdField_a_of_type_JavaUtilArrayList;
  public new a;
  View jdField_b_of_type_AndroidViewView;
  ImageView jdField_b_of_type_AndroidWidgetImageView;
  public TextView b;
  AVGameText jdField_b_of_type_ComTencentAvgameUiAVGameText;
  public Runnable b;
  View c;
  public Runnable c;
  public Runnable d = new GuessSongStageView.4(this);
  
  public GuessSongStageView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public GuessSongStageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public GuessSongStageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_JavaLangRunnable = new GuessSongStageView.1(this);
    this.jdField_b_of_type_JavaLangRunnable = new GuessSongStageView.2(this);
    this.jdField_c_of_type_JavaLangRunnable = new GuessSongStageView.3(this);
    a();
  }
  
  private Bitmap a(Drawable paramDrawable, int paramInt1, int paramInt2)
  {
    QLog.d("GuessSongStageView", 2, "drawableToBitmap " + paramInt1 + " " + paramInt2);
    paramDrawable.setBounds(0, 0, paramInt1, paramInt2);
    if (paramDrawable.getOpacity() != -1) {}
    for (Object localObject = Bitmap.Config.ARGB_8888;; localObject = Bitmap.Config.RGB_565)
    {
      localObject = Bitmap.createBitmap(paramInt1, paramInt2, (Bitmap.Config)localObject);
      paramDrawable.draw(new Canvas((Bitmap)localObject));
      return localObject;
    }
  }
  
  private void a()
  {
    LayoutInflater.from(getContext()).inflate(2131558724, this, true);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131379876));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131379874));
    this.jdField_a_of_type_ComTencentAvgameUiAVGameText = ((AVGameText)findViewById(2131379495));
    this.jdField_b_of_type_ComTencentAvgameUiAVGameText = ((AVGameText)findViewById(2131379496));
    this.jdField_b_of_type_AndroidViewView = findViewById(2131370134);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131365179));
    this.jdField_a_of_type_AndroidViewView = findViewById(2131370236);
    this.jdField_c_of_type_AndroidViewView = findViewById(2131367673);
    this.jdField_c_of_type_AndroidViewView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(0, nju.b());
    this.jdField_a_of_type_AndroidViewView.getLayoutParams().width = nju.a();
    this.jdField_a_of_type_New = new new(this);
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
    this.jdField_a_of_type_AndroidViewView.setVisibility(4);
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131377608));
    this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(4);
  }
  
  private void a(nas paramnas)
  {
    if (QLog.isColorLevel()) {
      QLog.i("GuessSongStageView", 2, "onSongStart() topicSong:" + paramnas);
    }
    if (paramnas == null)
    {
      ThreadManager.getUIHandlerV2().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      return;
    }
    if ((TextUtils.isEmpty(paramnas.b())) || (!paramnas.b().startsWith("http")))
    {
      QLog.i("GuessSongStageView", 1, "onSongStart() illegal url:" + paramnas.b());
      return;
    }
    String[] arrayOfString = paramnas.a();
    if ((arrayOfString[0] != null) && (arrayOfString[0].length() != 0) && (arrayOfString[1] != null) && (arrayOfString[1].length() != 0) && (arrayOfString[2] != null) && (arrayOfString[2].length() != 0))
    {
      this.jdField_a_of_type_ComTencentAvgameUiAVGameText.setAttribute("#FFFFFF", arrayOfString[2]);
      this.jdField_a_of_type_ComTencentAvgameUiAVGameText.setText(arrayOfString[0]);
      this.jdField_b_of_type_ComTencentAvgameUiAVGameText.setAttribute("#FFC000", "#FFFFFF");
      this.jdField_b_of_type_ComTencentAvgameUiAVGameText.setText(arrayOfString[1]);
      ThreadManager.getUIHandlerV2().post(this.jdField_c_of_type_JavaLangRunnable);
    }
    for (;;)
    {
      this.jdField_a_of_type_JavaUtilArrayList = paramnas.jdField_a_of_type_JavaUtilArrayList;
      if ((this.jdField_a_of_type_JavaUtilArrayList == null) || (this.jdField_a_of_type_JavaUtilArrayList.size() <= 0)) {
        break;
      }
      this.jdField_a_of_type_Int = 0;
      ThreadManager.getUIHandlerV2().postDelayed(this.jdField_a_of_type_JavaLangRunnable, ((Integer)((Pair)this.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_Int)).first).intValue() * 1000);
      return;
      ThreadManager.getUIHandlerV2().removeCallbacks(this.d);
      ThreadManager.getUIHandlerV2().post(this.d);
    }
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable == null)
    {
      nbx.a(getContext(), "avgame_guess_song_playing/data.json", "avgame_guess_song_playing/images/", 250, 250, new ney(this));
      return;
    }
    c();
  }
  
  private void c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable.isRunning()) {
      this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable.stop();
    }
    this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable.setProgress(0.0F);
    this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable.setRepeatCount(-1);
    this.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable);
    this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable.start();
    Object localObject = mzl.a().a().d();
    if (QLog.isColorLevel()) {
      QLog.d("GuessSongStageView", 2, "playSongPlayingLottieDrawable " + (String)localObject);
    }
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      localObject = URLDrawable.getDrawable((String)localObject);
      ((URLDrawable)localObject).setURLDrawableListener(new nez(this));
      ((URLDrawable)localObject).startDownload();
    }
  }
  
  public ImageView a()
  {
    return this.jdField_a_of_type_AndroidWidgetImageView;
  }
  
  public ned a()
  {
    return this.jdField_a_of_type_New;
  }
  
  public void a(Player paramPlayer, AVGameUserInfo paramAVGameUserInfo)
  {
    if (ncp.k <= 0)
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
      this.jdField_b_of_type_AndroidWidgetTextView.setTextSize(0, nju.d());
    }
    for (;;)
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setText(paramString);
      this.jdField_b_of_type_AndroidWidgetTextView.getViewTreeObserver().addOnGlobalLayoutListener(new nex(this, paramString));
      ThreadManager.getUIHandlerV2().postDelayed(this.jdField_b_of_type_JavaLangRunnable, 3000L);
      return;
      this.jdField_b_of_type_AndroidWidgetTextView.setTextSize(0, nju.c());
    }
  }
  
  public void a(mzq parammzq)
  {
    a((nas)parammzq);
  }
  
  public void a(neg paramneg)
  {
    this.jdField_a_of_type_New.a(paramneg);
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = 0;; i = 8)
    {
      setVisibility(i);
      if ((!paramBoolean) && (this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable != null))
      {
        if (this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable.isRunning()) {
          this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable.stop();
        }
        this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable = null;
      }
      return;
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (!paramBoolean2)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      setBackgroundDrawable(null);
      if ((this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable != null) && (this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable.isRunning())) {
        this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable.stop();
      }
      this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable = null;
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(4);
    }
    do
    {
      return;
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    } while (this.jdField_b_of_type_AndroidWidgetImageView.getVisibility() == 0);
    String str = this.jdField_a_of_type_New.a().a().b();
    if (!TextUtils.isEmpty(str)) {
      setBackgroundDrawable(URLDrawable.getDrawable(str));
    }
    for (;;)
    {
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      b();
      return;
      setBackgroundDrawable(nav.a("avgame_float_act_guess_place_holder@2x.png"));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.avgame.gameroom.stage.guesssong.GuessSongStageView
 * JD-Core Version:    0.7.0.1
 */