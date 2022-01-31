package com.tencent.mobileqq.activity.qwallet;

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
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.qwallet.QQWalletHbItemUtils;
import com.tencent.mobileqq.activity.qwallet.redpacket.IRedPacket;
import com.tencent.mobileqq.activity.qwallet.redpacket.RedPacketManager;
import com.tencent.mobileqq.activity.qwallet.utils.QWalletTools;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.dinifly.LottieComposition.Factory;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;
import org.json.JSONObject;
import wyz;
import wza;
import wzb;
import wzc;
import wzd;
import wze;
import wzj;

public class TroopUnAccalimedRedPacketList
  extends FrameLayout
{
  private static int jdField_a_of_type_Int;
  private static RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  private static ImageView jdField_a_of_type_AndroidWidgetImageView;
  private static PopupWindow jdField_a_of_type_AndroidWidgetPopupWindow;
  private static TextView jdField_a_of_type_AndroidWidgetTextView;
  private static BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie;
  private static TroopUnAccalimedRedPacketList.HbListAdapter jdField_a_of_type_ComTencentMobileqqActivityQwalletTroopUnAccalimedRedPacketList$HbListAdapter;
  private static QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private static final String jdField_a_of_type_JavaLangString = TroopUnAccalimedRedPacketList.class.getSimpleName();
  private static String jdField_b_of_type_JavaLangString;
  private static boolean jdField_b_of_type_Boolean;
  private Animator jdField_a_of_type_AndroidAnimationAnimator;
  private Context jdField_a_of_type_AndroidContentContext;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TroopUnAccalimedRedPacketList.RedPacketRefreshReceiver jdField_a_of_type_ComTencentMobileqqActivityQwalletTroopUnAccalimedRedPacketList$RedPacketRefreshReceiver;
  private boolean jdField_a_of_type_Boolean;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  
  public TroopUnAccalimedRedPacketList(QQAppInterface paramQQAppInterface, BaseChatPie paramBaseChatPie)
  {
    super(paramBaseChatPie.a());
    this.jdField_a_of_type_AndroidContentContext = paramBaseChatPie.a();
    jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = paramBaseChatPie;
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
    addView(this.jdField_a_of_type_AndroidWidgetRelativeLayout);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.getLayoutParams().width = -1;
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.getLayoutParams().height = -1;
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundColor(Color.parseColor("#b2000000"));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(new wyz(this));
    jdField_a_of_type_AndroidWidgetImageView = new ImageView(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(jdField_a_of_type_AndroidWidgetImageView);
    jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130841041);
    paramQQAppInterface = (RelativeLayout.LayoutParams)jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
    paramQQAppInterface.leftMargin = UIUtils.a(this.jdField_a_of_type_AndroidContentContext, 12.5F);
    paramQQAppInterface.topMargin = UIUtils.a(this.jdField_a_of_type_AndroidContentContext, 37.5F);
    jdField_a_of_type_AndroidWidgetImageView.setLayoutParams(paramQQAppInterface);
    jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new wza(this));
    this.jdField_b_of_type_AndroidWidgetImageView = new ImageView(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_b_of_type_AndroidWidgetImageView);
    paramQQAppInterface = (RelativeLayout.LayoutParams)this.jdField_b_of_type_AndroidWidgetImageView.getLayoutParams();
    paramQQAppInterface.width = UIUtils.a(this.jdField_a_of_type_AndroidContentContext, 80.0F);
    paramQQAppInterface.height = UIUtils.a(this.jdField_a_of_type_AndroidContentContext, 32.0F);
    paramQQAppInterface.addRule(13);
    try
    {
      paramQQAppInterface = a();
      LottieComposition.Factory.fromJson(getResources(), paramQQAppInterface, new wzb(this));
      jdField_a_of_type_AndroidWidgetTextView = new TextView(this.jdField_a_of_type_AndroidContentContext);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(jdField_a_of_type_AndroidWidgetTextView);
      paramQQAppInterface = (RelativeLayout.LayoutParams)jdField_a_of_type_AndroidWidgetTextView.getLayoutParams();
      paramQQAppInterface.width = -1;
      paramQQAppInterface.height = -2;
      paramQQAppInterface.addRule(15);
      jdField_a_of_type_AndroidWidgetTextView.setLayoutParams(paramQQAppInterface);
      paramQQAppInterface = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130841040);
      paramQQAppInterface.setBounds(0, 0, UIUtils.a(this.jdField_a_of_type_AndroidContentContext, 100.0F), UIUtils.a(this.jdField_a_of_type_AndroidContentContext, 100.0F));
      jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawables(null, paramQQAppInterface, null, null);
      jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(UIUtils.a(this.jdField_a_of_type_AndroidContentContext, 20.0F));
      jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#FFFFFF"));
      jdField_a_of_type_AndroidWidgetTextView.setTextSize(1, 14.0F);
      jdField_a_of_type_AndroidWidgetTextView.setGravity(1);
      jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      jdField_a_of_type_ComTencentMobileqqActivityQwalletTroopUnAccalimedRedPacketList$HbListAdapter = new TroopUnAccalimedRedPacketList.HbListAdapter(this.jdField_a_of_type_AndroidContentContext);
      jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = new RecyclerView(this.jdField_a_of_type_AndroidContentContext);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(jdField_a_of_type_AndroidSupportV7WidgetRecyclerView);
      paramQQAppInterface = (RelativeLayout.LayoutParams)jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getLayoutParams();
      paramQQAppInterface.width = -1;
      paramQQAppInterface.height = UIUtils.a(this.jdField_a_of_type_AndroidContentContext, 300.0F);
      paramQQAppInterface.addRule(15);
      jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setLayoutManager(new LinearLayoutManager(this.jdField_a_of_type_AndroidContentContext, 0, false));
      jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setAdapter(jdField_a_of_type_ComTencentMobileqqActivityQwalletTroopUnAccalimedRedPacketList$HbListAdapter);
      int i = (UIUtils.a(this.jdField_a_of_type_AndroidContentContext) - UIUtils.a(this.jdField_a_of_type_AndroidContentContext, 160.0F)) / 2;
      jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.addItemDecoration(new wzj(i, UIUtils.a(this.jdField_a_of_type_AndroidContentContext, 3.5F), null));
      jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setHasFixedSize(false);
      jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getItemAnimator().setRemoveDuration(300L);
      jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getItemAnimator().setChangeDuration(300L);
      jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setOnScrollListener(new wzc(this));
      this.jdField_a_of_type_AndroidAnimationAnimator = ObjectAnimator.ofFloat(jdField_a_of_type_AndroidSupportV7WidgetRecyclerView, "translationX", new float[] { i, 0.0F });
      this.jdField_a_of_type_AndroidAnimationAnimator.setInterpolator(new LinearInterpolator());
      this.jdField_a_of_type_AndroidAnimationAnimator.setDuration(300L);
      jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setVisibility(8);
      return;
    }
    catch (Exception paramQQAppInterface)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e(jdField_a_of_type_JavaLangString, 2, "getLoadingLottieJson has occur exception " + paramQQAppInterface.getLocalizedMessage());
        }
      }
    }
  }
  
  public static JSONObject a()
  {
    return new JSONObject("{\"v\":\"4.7.1\",\"fr\":25,\"ip\":0,\"op\":12,\"w\":156,\"h\":60,\"nm\":\"预合成 1\",\"ddd\":0,\"assets\":[],\"layers\":[{\"ddd\":0,\"ind\":1,\"ty\":1,\"nm\":\"白色 纯色 1\",\"ks\":{\"o\":{\"a\":1,\"k\":[{\"i\":{\"x\":[0.667],\"y\":[1]},\"o\":{\"x\":[0.333],\"y\":[0]},\"n\":[\"0p667_1_0p333_0\"],\"t\":0,\"s\":[0],\"e\":[80]},{\"t\":10}]},\"r\":{\"a\":0,\"k\":0},\"p\":{\"a\":1,\"k\":[{\"i\":{\"x\":0.667,\"y\":1},\"o\":{\"x\":0.333,\"y\":0},\"n\":\"0p667_1_0p333_0\",\"t\":0,\"s\":[130,30,0],\"e\":[78,30,0],\"to\":[-8.66666698455811,0,0],\"ti\":[8.66666698455811,0,0]},{\"t\":10}]},\"a\":{\"a\":0,\"k\":[78,30,0]},\"s\":{\"a\":1,\"k\":[{\"i\":{\"x\":[0.667,0.667,0.667],\"y\":[1,1,1]},\"o\":{\"x\":[0.333,0.333,0.333],\"y\":[0,0,0]},\"n\":[\"0p667_1_0p333_0\",\"0p667_1_0p333_0\",\"0p667_1_0p333_0\"],\"t\":0,\"s\":[0,0,100],\"e\":[100,100,100]},{\"t\":2}]}},\"ao\":0,\"hasMask\":true,\"masksProperties\":[{\"inv\":false,\"mode\":\"a\",\"pt\":{\"a\":0,\"k\":{\"i\":[[-4.464,2.15],[0,0],[2.209,0],[0,0],[0,2.209],[0,0],[-9.878,0.003]],\"o\":[[0,0],[0,2.209],[0,0],[-2.209,0],[0,0],[4.565,1.866],[10.339,-0.003]],\"v\":[[104,13.008],[104,56],[100,60],[56,60],[52,56],[52,13.852],[78,20]],\"c\":true}},\"o\":{\"a\":0,\"k\":100},\"x\":{\"a\":0,\"k\":0},\"nm\":\"蒙版 1\"},{\"inv\":false,\"mode\":\"a\",\"pt\":{\"a\":0,\"k\":{\"i\":[[-0.42,-1.76],[14.266,-0.006],[3.48,4.502],[-1.923,0],[0,0]],\"o\":[[-3.513,4.387],[-14.368,0.344],[0.383,-1.809],[0,0],[1.889,0]],\"v\":[[103.891,3.069],[78,15],[52.087,3.166],[56,0],[100,0]],\"c\":true}},\"o\":{\"a\":0,\"k\":100},\"x\":{\"a\":0,\"k\":0},\"nm\":\"蒙版 2\"}],\"sw\":156,\"sh\":60,\"sc\":\"#ffffff\",\"ip\":0,\"op\":12,\"st\":0,\"bm\":0,\"sr\":1},{\"ddd\":0,\"ind\":2,\"ty\":1,\"nm\":\"白色 纯色 1\",\"ks\":{\"o\":{\"a\":1,\"k\":[{\"i\":{\"x\":[0.667],\"y\":[1]},\"o\":{\"x\":[0.333],\"y\":[0]},\"n\":[\"0p667_1_0p333_0\"],\"t\":0,\"s\":[80],\"e\":[0]},{\"t\":10}]},\"r\":{\"a\":0,\"k\":0},\"p\":{\"a\":1,\"k\":[{\"i\":{\"x\":0.667,\"y\":1},\"o\":{\"x\":0.333,\"y\":0},\"n\":\"0p667_1_0p333_0\",\"t\":0,\"s\":[78,30,0],\"e\":[26,30,0],\"to\":[-8.66666698455811,0,0],\"ti\":[8.66666698455811,0,0]},{\"t\":10}]},\"a\":{\"a\":0,\"k\":[78,30,0]},\"s\":{\"a\":1,\"k\":[{\"i\":{\"x\":[0.667,0.667,0.667],\"y\":[1,1,1]},\"o\":{\"x\":[0.333,0.333,0.333],\"y\":[0,0,0]},\"n\":[\"0p667_1_0p333_0\",\"0p667_1_0p333_0\",\"0p667_1_0p333_0\"],\"t\":8,\"s\":[100,100,100],\"e\":[0,0,100]},{\"t\":10}]}},\"ao\":0,\"hasMask\":true,\"masksProperties\":[{\"inv\":false,\"mode\":\"a\",\"pt\":{\"a\":0,\"k\":{\"i\":[[-4.464,2.15],[0,0],[2.209,0],[0,0],[0,2.209],[0,0],[-9.878,0.003]],\"o\":[[0,0],[0,2.209],[0,0],[-2.209,0],[0,0],[4.565,1.866],[10.339,-0.003]],\"v\":[[104,13.008],[104,56],[100,60],[56,60],[52,56],[52,13.852],[78,20]],\"c\":true}},\"o\":{\"a\":0,\"k\":100},\"x\":{\"a\":0,\"k\":0},\"nm\":\"蒙版 1\"},{\"inv\":false,\"mode\":\"a\",\"pt\":{\"a\":0,\"k\":{\"i\":[[-0.42,-1.76],[14.266,-0.006],[3.48,4.502],[-1.923,0],[0,0]],\"o\":[[-3.513,4.387],[-14.368,0.344],[0.383,-1.809],[0,0],[1.889,0]],\"v\":[[103.891,3.069],[78,15],[52.087,3.166],[56,0],[100,0]],\"c\":true}},\"o\":{\"a\":0,\"k\":100},\"x\":{\"a\":0,\"k\":0},\"nm\":\"蒙版 2\"}],\"sw\":156,\"sh\":60,\"sc\":\"#ffffff\",\"ip\":0,\"op\":12,\"st\":0,\"bm\":0,\"sr\":1}]}");
  }
  
  public void a(String paramString, int paramInt)
  {
    QWalletTools.a(jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 2, "", 0L, 162, "aio.hongbaolist.show", "", "");
    jdField_b_of_type_JavaLangString = paramString;
    jdField_a_of_type_Int = paramInt;
    jdField_a_of_type_AndroidWidgetPopupWindow = new PopupWindow(this, -1, -1);
    jdField_a_of_type_AndroidWidgetPopupWindow.setBackgroundDrawable(new ColorDrawable());
    jdField_a_of_type_AndroidWidgetPopupWindow.setOutsideTouchable(true);
    jdField_a_of_type_AndroidWidgetPopupWindow.setFocusable(true);
    jdField_a_of_type_AndroidWidgetPopupWindow.showAtLocation(jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.c, 17, 0, 0);
    jdField_a_of_type_AndroidWidgetPopupWindow.setOnDismissListener(new wzd(this));
    RedPacketManager.getInstance().reqGroupAvailableList(jdField_b_of_type_JavaLangString, jdField_a_of_type_Int, new wze(this));
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqActivityQwalletTroopUnAccalimedRedPacketList$RedPacketRefreshReceiver = new TroopUnAccalimedRedPacketList.RedPacketRefreshReceiver();
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("troop_hblist_broadcast_action");
    this.jdField_a_of_type_AndroidContentContext.registerReceiver(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletTroopUnAccalimedRedPacketList$RedPacketRefreshReceiver, localIntentFilter);
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    jdField_b_of_type_Boolean = false;
    if ((this.jdField_a_of_type_AndroidAnimationAnimator != null) && (this.jdField_a_of_type_AndroidAnimationAnimator.isRunning())) {
      this.jdField_a_of_type_AndroidAnimationAnimator.cancel();
    }
    this.jdField_a_of_type_AndroidContentContext.unregisterReceiver(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletTroopUnAccalimedRedPacketList$RedPacketRefreshReceiver);
    if ((QQWalletHbItemUtils.a != null) && (!QQWalletHbItemUtils.a.isEmpty())) {
      QQWalletHbItemUtils.a.clear();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.TroopUnAccalimedRedPacketList
 * JD-Core Version:    0.7.0.1
 */