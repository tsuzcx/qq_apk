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
import com.tencent.avgame.ui.AVGameText;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import java.util.ArrayList;
import mzq;
import nar;
import ncp;
import ned;
import nee;
import neg;
import neh;
import nfa;
import nfb;
import nju;

public class GuessStarStageView
  extends RelativeLayout
  implements nee
{
  int jdField_a_of_type_Int = 0;
  View jdField_a_of_type_AndroidViewView;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  public LinearLayout a;
  public TextView a;
  AVGameText jdField_a_of_type_ComTencentAvgameUiAVGameText;
  public Runnable a;
  ArrayList<Pair<Integer, String>> jdField_a_of_type_JavaUtilArrayList;
  public ned a;
  neh jdField_a_of_type_Neh;
  View jdField_b_of_type_AndroidViewView;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  AVGameText jdField_b_of_type_ComTencentAvgameUiAVGameText;
  public Runnable b;
  public Runnable c = new GuessStarStageView.3(this);
  
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
    this.jdField_b_of_type_JavaLangRunnable = new GuessStarStageView.2(this);
    a();
  }
  
  private void a()
  {
    LayoutInflater.from(getContext()).inflate(2131558725, this, true);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131365179));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131378999));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131378970));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131378972));
    this.jdField_a_of_type_AndroidViewView = findViewById(2131367673);
    this.jdField_a_of_type_ComTencentAvgameUiAVGameText = ((AVGameText)findViewById(2131379495));
    this.jdField_b_of_type_ComTencentAvgameUiAVGameText = ((AVGameText)findViewById(2131379496));
    this.jdField_b_of_type_AndroidViewView = findViewById(2131370134);
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    this.jdField_b_of_type_AndroidWidgetTextView.setTextSize(0, nju.b());
    this.jdField_a_of_type_AndroidWidgetLinearLayout.getLayoutParams().width = nju.a();
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    this.jdField_a_of_type_Ned = new nfa(this);
  }
  
  private void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("GuessStarStageView", 2, "showTopicTips tip = " + paramString);
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString);
    if ((paramString != null) && (paramString.length() > 5)) {
      this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(0, nju.d());
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString);
      this.jdField_a_of_type_AndroidWidgetTextView.getViewTreeObserver().addOnGlobalLayoutListener(new nfb(this, paramString));
      return;
      this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(0, nju.c());
    }
  }
  
  public ImageView a()
  {
    return this.jdField_a_of_type_AndroidWidgetImageView;
  }
  
  public ned a()
  {
    return this.jdField_a_of_type_Ned;
  }
  
  public void a(Player paramPlayer, AVGameUserInfo paramAVGameUserInfo)
  {
    if (ncp.k <= 0)
    {
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      return;
    }
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
  }
  
  public void a(mzq parammzq)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GuessStarStageView", 2, "onUpdateCurTopic topic = " + parammzq);
    }
    if (parammzq == null) {
      return;
    }
    parammzq = (nar)parammzq;
    String[] arrayOfString = parammzq.a();
    if ((arrayOfString[0] != null) && (arrayOfString[0].length() != 0) && (arrayOfString[1] != null) && (arrayOfString[1].length() != 0) && (arrayOfString[2] != null) && (arrayOfString[2].length() != 0))
    {
      this.jdField_a_of_type_ComTencentAvgameUiAVGameText.setAttribute("#FFFFFF", arrayOfString[2]);
      this.jdField_a_of_type_ComTencentAvgameUiAVGameText.setText(arrayOfString[0]);
      this.jdField_b_of_type_ComTencentAvgameUiAVGameText.setAttribute("#FFC000", "#FFFFFF");
      this.jdField_b_of_type_ComTencentAvgameUiAVGameText.setText(arrayOfString[1]);
      ThreadManager.getUIHandlerV2().post(this.jdField_b_of_type_JavaLangRunnable);
    }
    for (;;)
    {
      this.jdField_a_of_type_JavaUtilArrayList = parammzq.jdField_a_of_type_JavaUtilArrayList;
      if ((this.jdField_a_of_type_JavaUtilArrayList == null) || (this.jdField_a_of_type_JavaUtilArrayList.size() <= 0)) {
        break;
      }
      this.jdField_a_of_type_Int = 0;
      ThreadManager.getUIHandlerV2().postDelayed(this.jdField_a_of_type_JavaLangRunnable, ((Integer)((Pair)this.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_Int)).first).intValue() * 1000);
      return;
      ThreadManager.getUIHandlerV2().removeCallbacks(this.c);
      ThreadManager.getUIHandlerV2().post(this.c);
    }
  }
  
  public void a(neg paramneg)
  {
    this.jdField_a_of_type_Ned.a(paramneg);
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
      if (this.jdField_a_of_type_Neh != null) {
        this.jdField_a_of_type_Neh.a(this.jdField_a_of_type_AndroidWidgetLinearLayout);
      }
      return;
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    }
  }
  
  public void setStageRecordPresenter(neh paramneh)
  {
    this.jdField_a_of_type_Neh = paramneh;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.avgame.gameroom.stage.guessstar.GuessStarStageView
 * JD-Core Version:    0.7.0.1
 */