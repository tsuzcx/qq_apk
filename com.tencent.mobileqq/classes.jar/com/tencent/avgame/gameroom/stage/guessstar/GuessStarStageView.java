package com.tencent.avgame.gameroom.stage.guessstar;

import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.avgame.gamelogic.data.Player;
import com.tencent.avgame.session.AVGameUserInfo;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import java.util.ArrayList;
import mxq;
import myn;
import nak;
import nbl;
import nbm;
import nbn;
import nbo;
import ncg;
import nch;
import ngk;

public class GuessStarStageView
  extends RelativeLayout
  implements nbm
{
  int jdField_a_of_type_Int = 0;
  View jdField_a_of_type_AndroidViewView;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  public LinearLayout a;
  public TextView a;
  public Runnable a;
  ArrayList<Pair<Integer, String>> jdField_a_of_type_JavaUtilArrayList;
  public nbl a;
  nbo jdField_a_of_type_Nbo;
  TextView b;
  
  public GuessStarStageView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public GuessStarStageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public GuessStarStageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_JavaLangRunnable = new GuessStarStageView.1(this);
    a();
  }
  
  private void a()
  {
    LayoutInflater.from(getContext()).inflate(2131558718, this, true);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131365106));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131379066));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131379037));
    this.b = ((TextView)findViewById(2131379039));
    this.jdField_a_of_type_AndroidViewView = findViewById(2131367572);
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    this.b.setTextSize(0, ngk.b());
    this.jdField_a_of_type_AndroidWidgetLinearLayout.getLayoutParams().width = ngk.a();
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    this.jdField_a_of_type_Nbl = new ncg(this);
  }
  
  private void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("GuessStarStageView", 2, "showTopicTips tip = " + paramString);
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString);
    if ((paramString != null) && (paramString.length() > 5)) {
      this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(0, ngk.d());
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString);
      this.jdField_a_of_type_AndroidWidgetTextView.getViewTreeObserver().addOnGlobalLayoutListener(new nch(this, paramString));
      return;
      this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(0, ngk.c());
    }
  }
  
  public ImageView a()
  {
    return this.jdField_a_of_type_AndroidWidgetImageView;
  }
  
  public nbl a()
  {
    return this.jdField_a_of_type_Nbl;
  }
  
  public void a(Player paramPlayer, AVGameUserInfo paramAVGameUserInfo)
  {
    if (nak.k <= 0)
    {
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      return;
    }
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
  }
  
  public void a(mxq parammxq)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GuessStarStageView", 2, "onUpdateCurTopic topic = " + parammxq);
    }
    if (parammxq == null) {}
    do
    {
      return;
      this.jdField_a_of_type_JavaUtilArrayList = ((myn)parammxq).jdField_a_of_type_JavaUtilArrayList;
    } while ((this.jdField_a_of_type_JavaUtilArrayList == null) || (this.jdField_a_of_type_JavaUtilArrayList.size() <= 0));
    this.jdField_a_of_type_Int = 0;
    ThreadManager.getUIHandlerV2().postDelayed(this.jdField_a_of_type_JavaLangRunnable, ((Integer)((Pair)this.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_Int)).first).intValue() * 1000);
  }
  
  public void a(nbn paramnbn)
  {
    this.jdField_a_of_type_Nbl.a(paramnbn);
  }
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GuessStarStageView", 2, "onShowGameContent " + paramBoolean);
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
    if (QLog.isColorLevel()) {
      QLog.d("GuessStarStageView", 2, "onShowGameBottomWidget ,isPlayerSelf = " + paramBoolean1 + ",show = " + paramBoolean2);
    }
    if (!paramBoolean2)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Nbo != null) {
        this.jdField_a_of_type_Nbo.a(this.jdField_a_of_type_AndroidWidgetLinearLayout);
      }
      return;
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    }
  }
  
  public void setStageRecordPresenter(nbo paramnbo)
  {
    this.jdField_a_of_type_Nbo = paramnbo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.avgame.gameroom.stage.guessstar.GuessStarStageView
 * JD-Core Version:    0.7.0.1
 */