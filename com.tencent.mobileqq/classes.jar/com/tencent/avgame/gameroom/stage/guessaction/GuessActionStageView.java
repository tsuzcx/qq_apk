package com.tencent.avgame.gameroom.stage.guessaction;

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
import bdla;
import com.tencent.avgame.gamelogic.data.Player;
import com.tencent.avgame.session.AVGameUserInfo;
import com.tencent.avgame.ui.AVGameText;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import nfh;
import nin;
import nkv;
import nkw;
import nkx;
import nky;
import nlh;
import nli;
import nlj;
import nqu;

public class GuessActionStageView
  extends RelativeLayout
  implements nkw
{
  View jdField_a_of_type_AndroidViewView;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  public LinearLayout a;
  public TextView a;
  AVGameText jdField_a_of_type_ComTencentAvgameUiAVGameText;
  public Runnable a;
  public nkv a;
  public nkx a;
  boolean jdField_a_of_type_Boolean = false;
  View jdField_b_of_type_AndroidViewView;
  ImageView jdField_b_of_type_AndroidWidgetImageView;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  AVGameText jdField_b_of_type_ComTencentAvgameUiAVGameText;
  public Runnable b;
  
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
    this.jdField_a_of_type_JavaLangRunnable = new GuessActionStageView.1(this);
    this.jdField_b_of_type_JavaLangRunnable = new GuessActionStageView.2(this);
    a();
  }
  
  private void a()
  {
    LayoutInflater.from(getContext()).inflate(2131558736, this, true);
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131365264));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131379293));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131379264));
    this.jdField_a_of_type_ComTencentAvgameUiAVGameText = ((AVGameText)findViewById(2131379804));
    this.jdField_b_of_type_ComTencentAvgameUiAVGameText = ((AVGameText)findViewById(2131379805));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131379266));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131378348));
    this.jdField_b_of_type_AndroidViewView = findViewById(2131370308);
    this.jdField_a_of_type_AndroidViewView = findViewById(2131367809);
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new nli(this));
    this.jdField_b_of_type_AndroidWidgetTextView.setTextSize(0, nqu.b());
    this.jdField_a_of_type_AndroidWidgetLinearLayout.getLayoutParams().width = nqu.a();
    this.jdField_a_of_type_Nkv = new nlh(this);
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
  
  public nkv a()
  {
    return this.jdField_a_of_type_Nkv;
  }
  
  public void a(Player paramPlayer, AVGameUserInfo paramAVGameUserInfo)
  {
    if ((nin.k <= 0) && (paramPlayer != null) && (paramAVGameUserInfo != null) && (paramAVGameUserInfo.hasCameraVideo()))
    {
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      return;
    }
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
  }
  
  public void a(nfh paramnfh)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GuessActionStageView", 2, "onUpdateCurTopic topic = " + paramnfh);
    }
    if (paramnfh == null) {}
    do
    {
      return;
      bdla.b(null, "dc00898", "", "", "0X800B04D", "0X800B04D", 1, 0, "", "", "", "");
      localObject = paramnfh.b();
      if ((localObject == null) || (((String)localObject).length() <= 5)) {
        break;
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(0, nqu.d());
      this.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
      this.jdField_a_of_type_AndroidWidgetTextView.getViewTreeObserver().addOnGlobalLayoutListener(new nlj(this, (String)localObject));
    } while ((this.jdField_a_of_type_AndroidWidgetLinearLayout == null) || (this.jdField_a_of_type_AndroidWidgetLinearLayout.getVisibility() == 0));
    Object localObject = paramnfh.a();
    if ((localObject[0] != null) && (localObject[0].length() != 0) && (localObject[1] != null) && (localObject[1].length() != 0) && (localObject[2] != null) && (localObject[2].length() != 0))
    {
      if (paramnfh.a() != 0L) {}
      for (boolean bool = true;; bool = false)
      {
        this.jdField_a_of_type_Boolean = bool;
        this.jdField_a_of_type_ComTencentAvgameUiAVGameText.setAttribute("#FFFFFF", localObject[2]);
        this.jdField_a_of_type_ComTencentAvgameUiAVGameText.setText(localObject[0]);
        this.jdField_b_of_type_ComTencentAvgameUiAVGameText.setAttribute("#FFC000", "#FFFFFF");
        this.jdField_b_of_type_ComTencentAvgameUiAVGameText.setText(localObject[1]);
        if (!this.jdField_a_of_type_Boolean) {
          break label321;
        }
        ThreadManager.getUIHandlerV2().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
        ThreadManager.getUIHandlerV2().removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
        ThreadManager.getUIHandlerV2().post(this.jdField_b_of_type_JavaLangRunnable);
        ThreadManager.getUIHandlerV2().postDelayed(this.jdField_a_of_type_JavaLangRunnable, 1600L);
        return;
        this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(0, nqu.c());
        break;
      }
      label321:
      ThreadManager.getUIHandlerV2().post(this.jdField_a_of_type_JavaLangRunnable);
      return;
    }
    ThreadManager.getUIHandlerV2().removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
    ThreadManager.getUIHandlerV2().post(this.jdField_b_of_type_JavaLangRunnable);
  }
  
  public void a(nky paramnky)
  {
    this.jdField_a_of_type_Nkv.a(paramnky);
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
  
  public void setOnSwitchTopicClickListener(nkx paramnkx)
  {
    this.jdField_a_of_type_Nkx = paramnkx;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.avgame.gameroom.stage.guessaction.GuessActionStageView
 * JD-Core Version:    0.7.0.1
 */