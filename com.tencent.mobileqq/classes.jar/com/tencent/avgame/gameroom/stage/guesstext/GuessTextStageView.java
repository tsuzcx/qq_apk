package com.tencent.avgame.gameroom.stage.guesstext;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import bdla;
import com.tencent.avgame.gamelogic.data.Player;
import com.tencent.avgame.session.AVGameUserInfo;
import com.tencent.avgame.ui.AVGameText;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import java.util.ArrayList;
import nfh;
import ngj;
import ngl;
import nin;
import nio;
import nkv;
import nkw;
import nky;
import nlu;
import nlv;
import nqu;

public class GuessTextStageView
  extends RelativeLayout
  implements nkw
{
  int jdField_a_of_type_Int = 0;
  public View a;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  AVGameText jdField_a_of_type_ComTencentAvgameUiAVGameText;
  public Runnable a;
  ArrayList<Pair<Integer, String>> jdField_a_of_type_JavaUtilArrayList;
  public nlu a;
  boolean jdField_a_of_type_Boolean = false;
  View jdField_b_of_type_AndroidViewView;
  public TextView b;
  AVGameText jdField_b_of_type_ComTencentAvgameUiAVGameText;
  public Runnable b;
  View jdField_c_of_type_AndroidViewView;
  TextView jdField_c_of_type_AndroidWidgetTextView;
  public Runnable c;
  public Runnable d = new GuessTextStageView.4(this);
  
  public GuessTextStageView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public GuessTextStageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public GuessTextStageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_JavaLangRunnable = new GuessTextStageView.1(this);
    this.jdField_b_of_type_JavaLangRunnable = new GuessTextStageView.2(this);
    this.jdField_c_of_type_JavaLangRunnable = new GuessTextStageView.3(this);
    a();
  }
  
  private void a()
  {
    LayoutInflater.from(getContext()).inflate(2131558740, this, true);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131380209));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131380207));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131365264));
    this.jdField_a_of_type_AndroidViewView = findViewById(2131370413);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(0, nqu.b());
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131379968));
    this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(4);
    this.jdField_a_of_type_ComTencentAvgameUiAVGameText = ((AVGameText)findViewById(2131379804));
    this.jdField_b_of_type_ComTencentAvgameUiAVGameText = ((AVGameText)findViewById(2131379805));
    this.jdField_b_of_type_AndroidViewView = findViewById(2131370308);
    this.jdField_c_of_type_AndroidViewView = findViewById(2131367809);
    this.jdField_c_of_type_AndroidViewView.setVisibility(8);
    this.jdField_a_of_type_AndroidViewView.getLayoutParams().width = nqu.a();
    this.jdField_a_of_type_Nlu = new nlu(this);
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
    this.jdField_a_of_type_AndroidViewView.setVisibility(4);
  }
  
  private void a(ngj paramngj)
  {
    if (QLog.isColorLevel()) {
      QLog.i("GuessTextStageView", 2, "onGuessTextStart() topicSong:" + paramngj);
    }
    if (paramngj == null)
    {
      QLog.e("GuessTextStageView", 1, "onGuessTextStart()  topicText empty");
      ThreadManager.getUIHandlerV2().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      bdla.b(null, "dc00898", "", "", "0X800B1F2", "0X800B1F2", 0, 0, "", "", "", "");
      return;
    }
    if (TextUtils.isEmpty(paramngj.b()))
    {
      QLog.e("GuessTextStageView", 1, "onGuessTextStart() illegal topicText getContent empty");
      bdla.b(null, "dc00898", "", "", "0X800B1F2", "0X800B1F2", 0, 0, "", "", "", "");
      return;
    }
    bdla.b(null, "dc00898", "", "", "0X800B1F1", "0X800B1F1", 0, 0, "", "", "", "");
    this.jdField_c_of_type_AndroidWidgetTextView.setText(paramngj.b());
    this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
    String[] arrayOfString = paramngj.a();
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
      this.jdField_a_of_type_JavaUtilArrayList = paramngj.jdField_a_of_type_JavaUtilArrayList;
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
  
  public ImageView a()
  {
    return this.jdField_a_of_type_AndroidWidgetImageView;
  }
  
  public nkv a()
  {
    return this.jdField_a_of_type_Nlu;
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
      this.jdField_b_of_type_AndroidWidgetTextView.getViewTreeObserver().addOnGlobalLayoutListener(new nlv(this, paramString));
      ThreadManager.getUIHandlerV2().postDelayed(this.jdField_b_of_type_JavaLangRunnable, 3000L);
      return;
      this.jdField_b_of_type_AndroidWidgetTextView.setTextSize(0, nqu.c());
    }
  }
  
  public void a(nfh paramnfh)
  {
    a((ngj)paramnfh);
  }
  
  public void a(nky paramnky)
  {
    this.jdField_a_of_type_Nlu.a(paramnky);
  }
  
  public void a(boolean paramBoolean)
  {
    if ((!paramBoolean) && (this.jdField_c_of_type_AndroidWidgetTextView != null)) {
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(4);
    }
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
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    }
    do
    {
      return;
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    } while (this.jdField_a_of_type_Boolean);
    String str = this.jdField_a_of_type_Nlu.a().a().b();
    if (!TextUtils.isEmpty(str)) {
      setBackgroundDrawable(URLDrawable.getDrawable(str));
    }
    for (;;)
    {
      this.jdField_a_of_type_Boolean = true;
      return;
      setBackgroundDrawable(ngl.a("avgame_float_act_guess_place_holder@2x.png"));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.avgame.gameroom.stage.guesstext.GuessTextStageView
 * JD-Core Version:    0.7.0.1
 */