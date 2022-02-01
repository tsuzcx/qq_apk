package com.tencent.avgame.gameroom.stage.guessaction;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import bcst;
import com.tencent.avgame.gamelogic.data.Player;
import com.tencent.avgame.session.AVGameUserInfo;
import com.tencent.qphone.base.util.QLog;
import mxq;
import nak;
import nbl;
import nbm;
import nbn;
import nbv;
import nbw;
import nbx;
import nby;
import ngk;

public class GuessActionStageView
  extends RelativeLayout
  implements nbm
{
  View jdField_a_of_type_AndroidViewView;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  public LinearLayout a;
  public TextView a;
  public nbl a;
  public nby a;
  ImageView jdField_b_of_type_AndroidWidgetImageView;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  
  public GuessActionStageView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public GuessActionStageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public GuessActionStageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  private void a()
  {
    LayoutInflater.from(getContext()).inflate(2131558714, this, true);
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131365106));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131379066));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131379037));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131379039));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131378135));
    this.jdField_a_of_type_AndroidViewView = findViewById(2131367572);
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new nbw(this));
    this.jdField_b_of_type_AndroidWidgetTextView.setTextSize(0, ngk.b());
    this.jdField_a_of_type_AndroidWidgetLinearLayout.getLayoutParams().width = ngk.a();
    this.jdField_a_of_type_Nbl = new nbv(this);
    this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(4);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(4);
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
  }
  
  public View a()
  {
    return this.jdField_a_of_type_AndroidWidgetLinearLayout;
  }
  
  public ImageView a()
  {
    return this.jdField_b_of_type_AndroidWidgetImageView;
  }
  
  public nbl a()
  {
    return this.jdField_a_of_type_Nbl;
  }
  
  public void a(Player paramPlayer, AVGameUserInfo paramAVGameUserInfo)
  {
    if ((nak.k <= 0) && (paramPlayer != null) && (paramAVGameUserInfo != null) && (paramAVGameUserInfo.hasCameraVideo()))
    {
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      return;
    }
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
  }
  
  public void a(mxq parammxq)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GuessActionStageView", 2, "onUpdateCurTopic topic = " + parammxq);
    }
    if (parammxq == null) {
      return;
    }
    bcst.b(null, "dc00898", "", "", "0X800B04D", "0X800B04D", 1, 0, "", "", "", "");
    parammxq = parammxq.b();
    if ((parammxq != null) && (parammxq.length() > 5)) {
      this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(0, ngk.d());
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(parammxq);
      this.jdField_a_of_type_AndroidWidgetTextView.getViewTreeObserver().addOnGlobalLayoutListener(new nbx(this, parammxq));
      return;
      this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(0, ngk.c());
    }
  }
  
  public void a(nbn paramnbn)
  {
    this.jdField_a_of_type_Nbl.a(paramnbn);
  }
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GuessActionStageView", 2, "onShowGameContent " + paramBoolean);
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
      QLog.d("GuessActionStageView", 2, "onShowGameBottomWidget ,isPlayerSelf = " + paramBoolean1 + ",show = " + paramBoolean2);
    }
    if (!paramBoolean2)
    {
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(4);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(4);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
      return;
    }
    this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
    if (paramBoolean1)
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-1);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(4);
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
  }
  
  public void setOnSwitchTopicClickListener(nby paramnby)
  {
    this.jdField_a_of_type_Nby = paramnby;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.avgame.gameroom.stage.guessaction.GuessActionStageView
 * JD-Core Version:    0.7.0.1
 */