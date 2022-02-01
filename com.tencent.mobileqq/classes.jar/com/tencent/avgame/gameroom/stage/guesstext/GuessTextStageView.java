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
import bcst;
import com.tencent.avgame.gamelogic.data.Player;
import com.tencent.avgame.session.AVGameUserInfo;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import java.util.ArrayList;
import mxq;
import myp;
import myr;
import nak;
import nal;
import nbl;
import nbm;
import nbn;
import nci;
import ncj;
import ngk;

public class GuessTextStageView
  extends RelativeLayout
  implements nbm
{
  int jdField_a_of_type_Int = 0;
  public View a;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  public Runnable a;
  ArrayList<Pair<Integer, String>> jdField_a_of_type_JavaUtilArrayList;
  public nci a;
  boolean jdField_a_of_type_Boolean = false;
  View b;
  public TextView b;
  public Runnable b;
  TextView c;
  
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
    a();
  }
  
  private void a()
  {
    LayoutInflater.from(getContext()).inflate(2131558720, this, true);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131379956));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131379954));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131365106));
    this.jdField_a_of_type_AndroidViewView = findViewById(2131370166);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(0, ngk.b());
    this.c = ((TextView)findViewById(2131379707));
    this.c.setVisibility(4);
    this.jdField_b_of_type_AndroidViewView = findViewById(2131367572);
    this.jdField_b_of_type_AndroidViewView.setVisibility(8);
    this.jdField_a_of_type_AndroidViewView.getLayoutParams().width = ngk.a();
    this.jdField_a_of_type_Nci = new nci(this);
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
    this.jdField_a_of_type_AndroidViewView.setVisibility(4);
  }
  
  private void a(myp parammyp)
  {
    if (QLog.isColorLevel()) {
      QLog.i("GuessTextStageView", 2, "onGuessTextStart() topicSong:" + parammyp);
    }
    if (parammyp == null)
    {
      QLog.e("GuessTextStageView", 1, "onGuessTextStart()  topicText empty");
      ThreadManager.getUIHandlerV2().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      bcst.b(null, "dc00898", "", "", "0X800B1F2", "0X800B1F2", 0, 0, "", "", "", "");
    }
    do
    {
      return;
      if (TextUtils.isEmpty(parammyp.b()))
      {
        QLog.e("GuessTextStageView", 1, "onGuessTextStart() illegal topicText getContent empty");
        bcst.b(null, "dc00898", "", "", "0X800B1F2", "0X800B1F2", 0, 0, "", "", "", "");
        return;
      }
      bcst.b(null, "dc00898", "", "", "0X800B1F1", "0X800B1F1", 0, 0, "", "", "", "");
      this.c.setText(parammyp.b());
      this.c.setVisibility(0);
      this.jdField_a_of_type_JavaUtilArrayList = parammyp.jdField_a_of_type_JavaUtilArrayList;
    } while ((this.jdField_a_of_type_JavaUtilArrayList == null) || (this.jdField_a_of_type_JavaUtilArrayList.size() <= 0));
    this.jdField_a_of_type_Int = 0;
    ThreadManager.getUIHandlerV2().postDelayed(this.jdField_a_of_type_JavaLangRunnable, ((Integer)((Pair)this.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_Int)).first).intValue() * 1000);
  }
  
  public ImageView a()
  {
    return this.jdField_a_of_type_AndroidWidgetImageView;
  }
  
  public nbl a()
  {
    return this.jdField_a_of_type_Nci;
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
      this.jdField_b_of_type_AndroidWidgetTextView.getViewTreeObserver().addOnGlobalLayoutListener(new ncj(this, paramString));
      ThreadManager.getUIHandlerV2().postDelayed(this.jdField_b_of_type_JavaLangRunnable, 3000L);
      return;
      this.jdField_b_of_type_AndroidWidgetTextView.setTextSize(0, ngk.c());
    }
  }
  
  public void a(mxq parammxq)
  {
    a((myp)parammxq);
  }
  
  public void a(nbn paramnbn)
  {
    this.jdField_a_of_type_Nci.a(paramnbn);
  }
  
  public void a(boolean paramBoolean)
  {
    if ((!paramBoolean) && (this.c != null)) {
      this.c.setVisibility(4);
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
    String str = this.jdField_a_of_type_Nci.a().a().b();
    if (!TextUtils.isEmpty(str)) {
      setBackgroundDrawable(URLDrawable.getDrawable(str));
    }
    for (;;)
    {
      this.jdField_a_of_type_Boolean = true;
      return;
      setBackgroundDrawable(myr.a("avgame_float_act_guess_place_holder@2x.png"));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.avgame.gameroom.stage.guesstext.GuessTextStageView
 * JD-Core Version:    0.7.0.1
 */