package com.tencent.mobileqq.activity.qwallet;

import aela;
import agyn;
import agyo;
import agyp;
import agyq;
import agyr;
import agys;
import agyu;
import agyy;
import agyz;
import ahiw;
import ajya;
import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ItemAnimator;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import baww;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.qwallet.redpacket.IRedPacket;
import com.tencent.mobileqq.activity.qwallet.redpacket.RedPacketManager;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.dinifly.LottieComposition.Factory;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;
import vzl;

public class TroopUnAccalimedRedPacketList
  extends FrameLayout
{
  private static final String jdField_a_of_type_JavaLangString = TroopUnAccalimedRedPacketList.class.getSimpleName();
  private int jdField_a_of_type_Int;
  private agyu jdField_a_of_type_Agyu;
  private agyz jdField_a_of_type_Agyz;
  private Animator jdField_a_of_type_AndroidAnimationAnimator;
  private Context jdField_a_of_type_AndroidContentContext;
  private RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  public PopupWindow a;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private boolean jdField_a_of_type_Boolean;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean;
  
  public TroopUnAccalimedRedPacketList(QQAppInterface paramQQAppInterface, BaseChatPie paramBaseChatPie)
  {
    super(paramBaseChatPie.a().getApplicationContext());
    try
    {
      this.jdField_a_of_type_AndroidContentContext = paramBaseChatPie.a().getApplicationContext();
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = paramBaseChatPie;
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
      addView(this.jdField_a_of_type_AndroidWidgetRelativeLayout);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.getLayoutParams().width = -1;
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.getLayoutParams().height = -1;
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundColor(Color.parseColor("#b2000000"));
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(new agyn(this));
      this.jdField_a_of_type_AndroidWidgetImageView = new ImageView(this.jdField_a_of_type_AndroidContentContext);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_AndroidWidgetImageView);
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130842833);
      baww.a(this.jdField_a_of_type_AndroidWidgetImageView, ajya.a(2131715806));
      paramQQAppInterface = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
      paramQQAppInterface.leftMargin = vzl.a(this.jdField_a_of_type_AndroidContentContext, 12.5F);
      paramQQAppInterface.topMargin = vzl.a(this.jdField_a_of_type_AndroidContentContext, 37.5F);
      this.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams(paramQQAppInterface);
      this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new agyo(this));
      this.jdField_b_of_type_AndroidWidgetImageView = new ImageView(this.jdField_a_of_type_AndroidContentContext);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_b_of_type_AndroidWidgetImageView);
      paramQQAppInterface = (RelativeLayout.LayoutParams)this.jdField_b_of_type_AndroidWidgetImageView.getLayoutParams();
      paramQQAppInterface.width = vzl.a(this.jdField_a_of_type_AndroidContentContext, 80.0F);
      paramQQAppInterface.height = vzl.a(this.jdField_a_of_type_AndroidContentContext, 32.0F);
      paramQQAppInterface.addRule(13);
      this.jdField_a_of_type_AndroidWidgetTextView = new TextView(this.jdField_a_of_type_AndroidContentContext);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_AndroidWidgetTextView);
      paramQQAppInterface = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams();
      paramQQAppInterface.width = -1;
      paramQQAppInterface.height = -2;
      paramQQAppInterface.addRule(15);
      this.jdField_a_of_type_AndroidWidgetTextView.setLayoutParams(paramQQAppInterface);
      paramQQAppInterface = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130842832);
      paramQQAppInterface.setBounds(0, 0, vzl.a(this.jdField_a_of_type_AndroidContentContext, 100.0F), vzl.a(this.jdField_a_of_type_AndroidContentContext, 100.0F));
      this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawables(null, paramQQAppInterface, null, null);
      this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(vzl.a(this.jdField_a_of_type_AndroidContentContext, 20.0F));
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#FFFFFF"));
      this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(1, 14.0F);
      this.jdField_a_of_type_AndroidWidgetTextView.setGravity(1);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_a_of_type_Agyu = new agyu(this, this.jdField_a_of_type_AndroidContentContext);
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = new RecyclerView(this.jdField_a_of_type_AndroidContentContext);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView);
      paramQQAppInterface = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getLayoutParams();
      paramQQAppInterface.width = -1;
      paramQQAppInterface.height = vzl.a(this.jdField_a_of_type_AndroidContentContext, 300.0F);
      paramQQAppInterface.addRule(15);
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setLayoutManager(new LinearLayoutManager(this.jdField_a_of_type_AndroidContentContext, 0, false));
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setAdapter(this.jdField_a_of_type_Agyu);
      int i = (vzl.a(this.jdField_a_of_type_AndroidContentContext) - vzl.a(this.jdField_a_of_type_AndroidContentContext, 160.0F)) / 2;
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.addItemDecoration(new agyy(i, vzl.a(this.jdField_a_of_type_AndroidContentContext, 3.5F), null));
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setHasFixedSize(false);
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getItemAnimator().setRemoveDuration(300L);
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getItemAnimator().setChangeDuration(300L);
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setOnScrollListener(new agyp(this));
      this.jdField_a_of_type_AndroidAnimationAnimator = ObjectAnimator.ofFloat(this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView, "translationX", new float[] { i, 0.0F });
      this.jdField_a_of_type_AndroidAnimationAnimator.setInterpolator(new LinearInterpolator());
      this.jdField_a_of_type_AndroidAnimationAnimator.setDuration(300L);
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setVisibility(8);
      return;
    }
    catch (Throwable paramQQAppInterface)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e(jdField_a_of_type_JavaLangString, 2, "init faile because has occur an exception: " + paramQQAppInterface);
    }
  }
  
  public String a()
  {
    return "{\"v\":\"5.5.3\",\"fr\":25,\"ip\":0,\"op\":12,\"w\":156,\"h\":60,\"nm\":\"预合成 1\",\"ddd\":0,\"assets\":[],\"layers\":[{\"ddd\":0,\"ind\":1,\"ty\":4,\"nm\":\"形状图层 2\",\"sr\":1,\"ks\":{\"o\":{\"a\":1,\"k\":[{\"i\":{\"x\":[0.833],\"y\":[0.833]},\"o\":{\"x\":[0.167],\"y\":[0.167]},\"t\":0,\"s\":[0]},{\"i\":{\"x\":[0.833],\"y\":[0.833]},\"o\":{\"x\":[0.167],\"y\":[0.167]},\"t\":8,\"s\":[72]},{\"t\":10,\"s\":[80]}],\"ix\":11},\"r\":{\"a\":0,\"k\":0,\"ix\":10},\"p\":{\"a\":1,\"k\":[{\"i\":{\"x\":0.833,\"y\":0.833},\"o\":{\"x\":0.167,\"y\":0.167},\"t\":0,\"s\":[130,30,0],\"to\":[-4.838,0,0],\"ti\":[10.78,0,0]},{\"i\":{\"x\":0.833,\"y\":0.833},\"o\":{\"x\":0.167,\"y\":0.167},\"t\":2,\"s\":[124.6,30,0],\"to\":[-25.839,0,0],\"ti\":[12.231,0,0]},{\"i\":{\"x\":0.833,\"y\":0.833},\"o\":{\"x\":0.167,\"y\":0.167},\"t\":8,\"s\":[94.8,30,0],\"to\":[-17.333,0,0],\"ti\":[2.8,0,0]},{\"t\":10,\"s\":[78,30,0]}],\"ix\":2},\"a\":{\"a\":0,\"k\":[0,0,0],\"ix\":1},\"s\":{\"a\":0,\"k\":[100,100,100],\"ix\":6}},\"ao\":0,\"shapes\":[{\"ty\":\"gr\",\"it\":[{\"ind\":0,\"ty\":\"sh\",\"ix\":1,\"ks\":{\"a\":0,\"k\":{\"i\":[[-0.42,-1.76],[14.266,-0.006],[3.48,4.502],[-1.923,0],[0,0]],\"o\":[[-3.513,4.387],[-14.368,0.344],[0.383,-1.809],[0,0],[1.889,0]],\"v\":[[25.891,-26.931],[0,-15],[-25.913,-26.834],[-22,-30],[22,-30]],\"c\":true},\"ix\":2},\"nm\":\"路径 1\",\"mn\":\"ADBE Vector Shape - Group\",\"hd\":false},{\"ty\":\"fl\",\"c\":{\"a\":0,\"k\":[1,1,1,1],\"ix\":4},\"o\":{\"a\":0,\"k\":100,\"ix\":5},\"r\":1,\"bm\":0,\"nm\":\"填充 1\",\"mn\":\"ADBE Vector Graphic - Fill\",\"hd\":false},{\"ty\":\"tr\",\"p\":{\"a\":0,\"k\":[0,0],\"ix\":2},\"a\":{\"a\":0,\"k\":[0,0],\"ix\":1},\"s\":{\"a\":0,\"k\":[100,100],\"ix\":3},\"r\":{\"a\":0,\"k\":0,\"ix\":6},\"o\":{\"a\":0,\"k\":100,\"ix\":7},\"sk\":{\"a\":0,\"k\":0,\"ix\":4},\"sa\":{\"a\":0,\"k\":0,\"ix\":5},\"nm\":\"变换\"}],\"nm\":\"形状 2\",\"np\":2,\"cix\":2,\"bm\":0,\"ix\":1,\"mn\":\"ADBE Vector Group\",\"hd\":false},{\"ty\":\"gr\",\"it\":[{\"ind\":0,\"ty\":\"sh\",\"ix\":1,\"ks\":{\"a\":0,\"k\":{\"i\":[[-4.464,2.15],[0,0],[2.209,0],[0,0],[0,2.209],[0,0],[-9.878,0.003]],\"o\":[[0,0],[0,2.209],[0,0],[-2.209,0],[0,0],[4.565,1.866],[10.339,-0.003]],\"v\":[[26,-16.992],[26,26],[22,30],[-22,30],[-26,26],[-26,-16.148],[0,-10]],\"c\":true},\"ix\":2},\"nm\":\"路径 1\",\"mn\":\"ADBE Vector Shape - Group\",\"hd\":false},{\"ty\":\"fl\",\"c\":{\"a\":0,\"k\":[1,1,1,1],\"ix\":4},\"o\":{\"a\":0,\"k\":100,\"ix\":5},\"r\":1,\"bm\":0,\"nm\":\"填充 1\",\"mn\":\"ADBE Vector Graphic - Fill\",\"hd\":false},{\"ty\":\"tr\",\"p\":{\"a\":0,\"k\":[0,0],\"ix\":2},\"a\":{\"a\":0,\"k\":[0,0],\"ix\":1},\"s\":{\"a\":0,\"k\":[100,100],\"ix\":3},\"r\":{\"a\":0,\"k\":0,\"ix\":6},\"o\":{\"a\":0,\"k\":100,\"ix\":7},\"sk\":{\"a\":0,\"k\":0,\"ix\":4},\"sa\":{\"a\":0,\"k\":0,\"ix\":5},\"nm\":\"变换\"}],\"nm\":\"形状 1\",\"np\":2,\"cix\":2,\"bm\":0,\"ix\":2,\"mn\":\"ADBE Vector Group\",\"hd\":false}],\"ip\":0,\"op\":12,\"st\":0,\"bm\":0},{\"ddd\":0,\"ind\":2,\"ty\":4,\"nm\":\"形状图层 1\",\"sr\":1,\"ks\":{\"o\":{\"a\":1,\"k\":[{\"i\":{\"x\":[0.833],\"y\":[0.833]},\"o\":{\"x\":[0.167],\"y\":[0.167]},\"t\":0,\"s\":[80]},{\"i\":{\"x\":[0.833],\"y\":[0.833]},\"o\":{\"x\":[0.167],\"y\":[0.167]},\"t\":8,\"s\":[8]},{\"t\":10,\"s\":[0]}],\"ix\":11},\"r\":{\"a\":0,\"k\":0,\"ix\":10},\"p\":{\"a\":1,\"k\":[{\"i\":{\"x\":0.833,\"y\":0.833},\"o\":{\"x\":0.167,\"y\":0.167},\"t\":0,\"s\":[78,30,0],\"to\":[-7.767,0,0],\"ti\":[8.667,0,0]},{\"i\":{\"x\":0.833,\"y\":0.833},\"o\":{\"x\":0.167,\"y\":0.167},\"t\":8,\"s\":[31.4,30,0],\"to\":[-8.667,0,0],\"ti\":[0.9,0,0]},{\"t\":10,\"s\":[26,30,0]}],\"ix\":2},\"a\":{\"a\":0,\"k\":[0,0,0],\"ix\":1},\"s\":{\"a\":0,\"k\":[100,100,100],\"ix\":6}},\"ao\":0,\"shapes\":[{\"ty\":\"gr\",\"it\":[{\"ind\":0,\"ty\":\"sh\",\"ix\":1,\"ks\":{\"a\":0,\"k\":{\"i\":[[-0.42,-1.76],[14.266,-0.006],[3.48,4.502],[-1.923,0],[0,0]],\"o\":[[-3.513,4.387],[-14.368,0.344],[0.383,-1.809],[0,0],[1.889,0]],\"v\":[[25.891,-26.931],[0,-15],[-25.913,-26.834],[-22,-30],[22,-30]],\"c\":true},\"ix\":2},\"nm\":\"路径 1\",\"mn\":\"ADBE Vector Shape - Group\",\"hd\":false},{\"ty\":\"fl\",\"c\":{\"a\":0,\"k\":[1,1,1,1],\"ix\":4},\"o\":{\"a\":0,\"k\":100,\"ix\":5},\"r\":1,\"bm\":0,\"nm\":\"填充 1\",\"mn\":\"ADBE Vector Graphic - Fill\",\"hd\":false},{\"ty\":\"tr\",\"p\":{\"a\":0,\"k\":[0,0],\"ix\":2},\"a\":{\"a\":0,\"k\":[0,0],\"ix\":1},\"s\":{\"a\":0,\"k\":[100,100],\"ix\":3},\"r\":{\"a\":0,\"k\":0,\"ix\":6},\"o\":{\"a\":0,\"k\":100,\"ix\":7},\"sk\":{\"a\":0,\"k\":0,\"ix\":4},\"sa\":{\"a\":0,\"k\":0,\"ix\":5},\"nm\":\"变换\"}],\"nm\":\"形状 2\",\"np\":2,\"cix\":2,\"bm\":0,\"ix\":1,\"mn\":\"ADBE Vector Group\",\"hd\":false},{\"ty\":\"gr\",\"it\":[{\"ind\":0,\"ty\":\"sh\",\"ix\":1,\"ks\":{\"a\":0,\"k\":{\"i\":[[-4.464,2.15],[0,0],[2.209,0],[0,0],[0,2.209],[0,0],[-9.878,0.003]],\"o\":[[0,0],[0,2.209],[0,0],[-2.209,0],[0,0],[4.565,1.866],[10.339,-0.003]],\"v\":[[26,-16.992],[26,26],[22,30],[-22,30],[-26,26],[-26,-16.148],[0,-10]],\"c\":true},\"ix\":2},\"nm\":\"路径 1\",\"mn\":\"ADBE Vector Shape - Group\",\"hd\":false},{\"ty\":\"fl\",\"c\":{\"a\":0,\"k\":[1,1,1,1],\"ix\":4},\"o\":{\"a\":0,\"k\":100,\"ix\":5},\"r\":1,\"bm\":0,\"nm\":\"填充 1\",\"mn\":\"ADBE Vector Graphic - Fill\",\"hd\":false},{\"ty\":\"tr\",\"p\":{\"a\":0,\"k\":[0,0],\"ix\":2},\"a\":{\"a\":0,\"k\":[0,0],\"ix\":1},\"s\":{\"a\":0,\"k\":[100,100],\"ix\":3},\"r\":{\"a\":0,\"k\":0,\"ix\":6},\"o\":{\"a\":0,\"k\":100,\"ix\":7},\"sk\":{\"a\":0,\"k\":0,\"ix\":4},\"sa\":{\"a\":0,\"k\":0,\"ix\":5},\"nm\":\"变换\"}],\"nm\":\"形状 1\",\"np\":2,\"cix\":2,\"bm\":0,\"ix\":2,\"mn\":\"ADBE Vector Group\",\"hd\":false}],\"ip\":0,\"op\":12,\"st\":0,\"bm\":0}],\"markers\":[]}";
  }
  
  public void a(String paramString, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
      ahiw.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 2, "", 0L, 162, "aio.hongbaolist.show", "", "");
    }
    try
    {
      if (this.jdField_b_of_type_AndroidWidgetImageView != null) {
        LottieComposition.Factory.fromJsonString(a(), new agyq(this));
      }
      this.jdField_b_of_type_JavaLangString = paramString;
      this.jdField_a_of_type_Int = paramInt;
      if (this.jdField_a_of_type_AndroidWidgetPopupWindow == null) {
        this.jdField_a_of_type_AndroidWidgetPopupWindow = new PopupWindow(this, -1, -1);
      }
      this.jdField_a_of_type_AndroidWidgetPopupWindow.setBackgroundDrawable(new ColorDrawable());
      this.jdField_a_of_type_AndroidWidgetPopupWindow.setOutsideTouchable(true);
      this.jdField_a_of_type_AndroidWidgetPopupWindow.setFocusable(true);
      this.jdField_a_of_type_AndroidWidgetPopupWindow.showAtLocation(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.c, 17, 0, 0);
      this.jdField_a_of_type_AndroidWidgetPopupWindow.setOnDismissListener(new agyr(this));
      RedPacketManager.getInstance().reqGroupAvailableList(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_Int, new agys(this));
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        localThrowable.printStackTrace();
      }
    }
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_Agyz = new agyz(this, null);
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("troop_hblist_broadcast_action");
    this.jdField_a_of_type_AndroidContentContext.registerReceiver(this.jdField_a_of_type_Agyz, localIntentFilter);
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    this.jdField_b_of_type_Boolean = false;
    if ((this.jdField_a_of_type_AndroidAnimationAnimator != null) && (this.jdField_a_of_type_AndroidAnimationAnimator.isRunning())) {
      this.jdField_a_of_type_AndroidAnimationAnimator.cancel();
    }
    if (this.jdField_a_of_type_Agyz != null)
    {
      this.jdField_a_of_type_AndroidContentContext.unregisterReceiver(this.jdField_a_of_type_Agyz);
      this.jdField_a_of_type_Agyz = null;
    }
    if ((aela.a != null) && (!aela.a.isEmpty())) {
      aela.a.clear();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.TroopUnAccalimedRedPacketList
 * JD-Core Version:    0.7.0.1
 */