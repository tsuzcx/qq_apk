package com.tencent.av.ui.redbag;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Handler;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.redpacket.AVRedPacketManager;
import com.tencent.av.redpacket.RedPacketLinkMovementMethod;
import com.tencent.av.redpacket.ui.RedPacketRollNumberView;
import com.tencent.av.redpacket.ui.RedPacketShareFragment;
import com.tencent.av.ui.AVActivity;
import com.tencent.av.ui.ControlUIObserver;
import com.tencent.av.utils.TintStateDrawable;
import com.tencent.mobileqq.activity.PublicFragmentActivity.Launcher;
import com.tencent.mobileqq.activity.PublicFragmentActivityForVideo;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.portal.StrokeTextView;
import com.tencent.mobileqq.util.BitmapManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import kho;
import khp;
import khq;
import khr;
import khs;
import kht;
import khu;

public class ResultUI
  extends SubHandleBase
  implements View.OnClickListener
{
  public Bitmap a;
  public ControlUIObserver a;
  public ResultData a;
  public khu a;
  public boolean a;
  public Bitmap b;
  public boolean b;
  public Bitmap c;
  public Bitmap d;
  public Bitmap e;
  public Bitmap f;
  private Bitmap g;
  private Bitmap h;
  
  ResultUI(AVRedBagMgr paramAVRedBagMgr)
  {
    super(paramAVRedBagMgr);
  }
  
  private String a(Context paramContext, int paramInt1, int paramInt2, int paramInt3)
  {
    paramContext = paramContext.getString(paramInt1);
    return paramContext + paramInt2 + "/" + paramInt3;
  }
  
  RelativeLayout a(AVActivity paramAVActivity)
  {
    RelativeLayout localRelativeLayout = (RelativeLayout)paramAVActivity.findViewById(2131366218);
    if (localRelativeLayout != null) {
      return localRelativeLayout;
    }
    paramAVActivity = (RelativeLayout)paramAVActivity.getLayoutInflater().inflate(2130969344, (RelativeLayout)paramAVActivity.findViewById(2131365828)).findViewById(2131366218);
    a(paramAVActivity);
    return paramAVActivity;
  }
  
  com.tencent.util.Pair a(ResultData paramResultData)
  {
    String str2;
    String str1;
    switch (paramResultData.jdField_e_of_type_Int)
    {
    case 7: 
    case 9: 
    default: 
      str2 = "网络异常，\n无法领取红包。";
      str1 = "请到消息窗口点击红包补领。\n";
      str3 = str1;
      if (TextUtils.isEmpty(str1)) {
        if (!TextUtils.isEmpty(paramResultData.h)) {
          break label268;
        }
      }
      break;
    }
    label268:
    for (String str3 = "请到消息窗口点击红包补领。\n";; str3 = paramResultData.h)
    {
      QLog.w(this.i, 1, "getErrorTips, resultCode[" + paramResultData.jdField_e_of_type_JavaLangString + "], js_state[" + paramResultData.jdField_f_of_type_JavaLangString + "], mRedbagErrorType[" + paramResultData.jdField_e_of_type_Int + "], defMsg[" + paramResultData.h + "], title[" + str2 + "], err[" + str3 + "]");
      return new com.tencent.util.Pair(str2, str3);
      if (this.jdField_a_of_type_ComTencentAvUiRedbagResultData.jdField_b_of_type_Boolean)
      {
        str2 = "对方未领到红包。";
        str1 = "对方未领到红包，需要到消息窗口点击红包领取。";
        break;
      }
      str2 = "未同意服务协议，\n无法领取红包。";
      str1 = "请到消息窗口点击红包补领。\n";
      break;
      if (this.jdField_a_of_type_ComTencentAvUiRedbagResultData.jdField_b_of_type_Boolean)
      {
        str2 = "对方未领到红包。";
        str1 = "对方未领到红包，需要到消息窗口点击红包领取。";
        break;
      }
      str2 = "因政策要求，\n无法领取红包。";
      str1 = "请到消息窗口点击红包补领。\n";
      break;
      if (this.jdField_a_of_type_ComTencentAvUiRedbagResultData.jdField_b_of_type_Boolean)
      {
        str2 = "对方未实名认证，\n红包金额无法到账。";
        str1 = "对方在24小时之内完成认证，可领取到红包金额，否则红包金额将在24小时后退回。";
        break;
      }
      str2 = "未作实名认证，\n无法领取红包。";
      str1 = "请先完成实名认证，然后在消息窗口点击红包补领。";
      break;
      str2 = "因收起到悬浮窗，\n无法领取红包。";
      str1 = "请到消息窗口点击红包补领。\n";
      break;
    }
  }
  
  String a()
  {
    if (a())
    {
      if (this.jdField_a_of_type_ComTencentAvUiRedbagResultData.jdField_b_of_type_Boolean) {
        return "对方演技爆棚，\n领到了你的红包。";
      }
      return "好厉害！不愧是表情大师！";
    }
    if (this.jdField_a_of_type_ComTencentAvUiRedbagResultData.jdField_b_of_type_Boolean) {
      return "对方领到了你的红包。";
    }
    return "再接再厉！";
  }
  
  String a(String paramString)
  {
    String str1 = "-.--";
    if (!TextUtils.isEmpty(paramString))
    {
      if (paramString.length() != 1) {
        break label87;
      }
      str1 = "0.0" + paramString;
    }
    for (;;)
    {
      if (QLog.isDevelopLevel()) {
        QLog.w(this.i, 1, "formatShowMoney, src[" + paramString + "], dest[" + str1 + "]");
      }
      return str1;
      label87:
      if (paramString.length() == 2)
      {
        str1 = "0." + paramString;
      }
      else
      {
        str1 = paramString.substring(paramString.length() - 2);
        String str2 = paramString.substring(0, paramString.length() - 2);
        str1 = str2 + "." + str1;
      }
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentAvUiControlUIObserver != null)
    {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.b(this.jdField_a_of_type_ComTencentAvUiControlUIObserver);
      this.jdField_a_of_type_ComTencentAvUiControlUIObserver = null;
    }
  }
  
  void a(RelativeLayout paramRelativeLayout)
  {
    paramRelativeLayout.setOnTouchListener(new khr(this));
  }
  
  public void a(AVActivity paramAVActivity)
  {
    RelativeLayout localRelativeLayout = a(paramAVActivity);
    paramAVActivity = RedBagUtil.b();
    if (this.jdField_a_of_type_ComTencentAvUiRedbagResultData.jdField_b_of_type_Boolean) {}
    for (paramAVActivity = paramAVActivity + "avredbag_error_sender.png";; paramAVActivity = paramAVActivity + "avredbag_error_player.png")
    {
      paramAVActivity = BitmapManager.a(paramAVActivity);
      ((ImageView)localRelativeLayout.findViewById(2131366235)).setImageBitmap(paramAVActivity);
      ((RelativeLayout)localRelativeLayout.findViewById(2131366234)).setVisibility(0);
      return;
    }
  }
  
  void a(AVActivity paramAVActivity, RelativeLayout paramRelativeLayout)
  {
    View localView = paramRelativeLayout.findViewById(2131366230);
    AVRedPacketManager localAVRedPacketManager = paramAVActivity.a();
    if (this.c == null) {
      this.c = localAVRedPacketManager.a("qav_redpacket_result_close.png");
    }
    if (this.c != null) {
      localView.setBackgroundDrawable(TintStateDrawable.a(paramAVActivity.getResources(), this.c, 2131494077));
    }
    localView.setOnClickListener(this);
    paramRelativeLayout.findViewById(2131366219).setOnTouchListener(new khq(this));
  }
  
  public void a(AVActivity paramAVActivity, ResultData paramResultData)
  {
    Object localObject1 = (RelativeLayout)paramAVActivity.findViewById(2131366218);
    if ((localObject1 == null) || (paramResultData == null))
    {
      paramAVActivity = this.i;
      localObject1 = new StringBuilder().append("showNormal_Result, result_root is null, ResultData[");
      if (paramResultData != null)
      {
        bool = true;
        QLog.w(paramAVActivity, 1, bool + "]");
      }
    }
    int i;
    for (;;)
    {
      return;
      bool = false;
      break;
      localObject1 = (RelativeLayout)((RelativeLayout)localObject1).findViewById(2131366219);
      localObject2 = paramAVActivity.a();
      localObject3 = ((RelativeLayout)localObject1).findViewById(2131366231);
      ((View)localObject3).setAnimation(null);
      ((View)localObject3).setVisibility(8);
      paramAVActivity = paramAVActivity.getResources();
      i = AIOUtils.a(4.0F, paramAVActivity);
      if (paramResultData.jdField_e_of_type_Int == 0)
      {
        StrokeTextView localStrokeTextView = (StrokeTextView)((RelativeLayout)localObject1).findViewById(2131366222);
        localObject3 = (RedPacketRollNumberView)((RelativeLayout)localObject1).findViewById(2131366223);
        localObject4 = (StrokeTextView)((RelativeLayout)localObject1).findViewById(2131366224);
        localObject5 = (TextView)((RelativeLayout)localObject1).findViewById(2131366227);
        localStrokeTextView.setVisibility(0);
        localStrokeTextView.setStrokeEnable(true);
        localStrokeTextView.setStrokeColor(-3109366);
        localStrokeTextView.setInnerTextColor(-1);
        localStrokeTextView.setStrokeSize(i);
        i = AIOUtils.a(6.0F, paramAVActivity);
        try
        {
          f1 = Float.parseFloat(a(paramResultData.i));
          ((RedPacketRollNumberView)localObject3).b(f1);
          ((RedPacketRollNumberView)localObject3).a();
          ((StrokeTextView)localObject4).setVisibility(0);
          ((StrokeTextView)localObject4).setStrokeEnable(true);
          ((StrokeTextView)localObject4).setStrokeColor(-1);
          ((StrokeTextView)localObject4).setStrokeSize(i);
          ((StrokeTextView)localObject4).setInnerTextColor(-2094274);
          ((TextView)localObject5).setText(a());
          if (a())
          {
            if (this.jdField_b_of_type_AndroidGraphicsBitmap == null) {
              this.jdField_b_of_type_AndroidGraphicsBitmap = ((AVRedPacketManager)localObject2).a("qav_redpacket_result_bqd.png");
            }
            if (this.jdField_b_of_type_AndroidGraphicsBitmap != null) {
              ((RelativeLayout)localObject1).findViewById(2131366226).setBackgroundDrawable(new BitmapDrawable(paramAVActivity, this.jdField_b_of_type_AndroidGraphicsBitmap));
            }
          }
          if (this.e == null) {
            this.e = ((AVRedPacketManager)localObject2).a("qav_redpacket_result_button_normal.png");
          }
          if (this.f == null) {
            this.f = ((AVRedPacketManager)localObject2).a("qav_redpacket_result_button_pressed.png");
          }
          if ((this.e != null) && (this.f != null))
          {
            paramResultData = ((RelativeLayout)localObject1).findViewById(2131366228);
            paramResultData.setVisibility(0);
            localObject3 = new StateListDrawable();
            localObject4 = new BitmapDrawable(paramAVActivity, this.f);
            ((StateListDrawable)localObject3).addState(new int[] { 16842919 }, (Drawable)localObject4);
            localObject4 = new BitmapDrawable(paramAVActivity, this.e);
            ((StateListDrawable)localObject3).addState(new int[] { -16842919 }, (Drawable)localObject4);
            paramResultData.setOnClickListener(this);
            paramResultData.setBackgroundDrawable((Drawable)localObject3);
          }
          if (this.g == null) {
            this.g = ((AVRedPacketManager)localObject2).a("qav_redpacket_result_share_normal.png");
          }
          if (this.h == null) {
            this.h = ((AVRedPacketManager)localObject2).a("qav_redpacket_result_share_pressed.png");
          }
          if ((this.g != null) && (this.h != null))
          {
            paramResultData = ((RelativeLayout)localObject1).findViewById(2131366229);
            paramResultData.setVisibility(0);
            localObject1 = new StateListDrawable();
            localObject2 = new BitmapDrawable(paramAVActivity, this.h);
            ((StateListDrawable)localObject1).addState(new int[] { 16842919 }, (Drawable)localObject2);
            paramAVActivity = new BitmapDrawable(paramAVActivity, this.g);
            ((StateListDrawable)localObject1).addState(new int[] { -16842919 }, paramAVActivity);
            paramResultData.setOnClickListener(this);
            paramResultData.setBackgroundDrawable((Drawable)localObject1);
            return;
          }
        }
        catch (NumberFormatException paramResultData)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.e(this.i, 2, "showNormal_Result e = " + paramResultData);
            }
            float f1 = 0.0F;
          }
        }
      }
    }
    Object localObject2 = a(paramResultData);
    Object localObject3 = paramResultData.g;
    Object localObject4 = (String)((com.tencent.util.Pair)localObject2).second;
    Object localObject5 = new ForegroundColorSpan(-7447805);
    if ((!TextUtils.isEmpty((CharSequence)localObject3)) && (paramResultData.jdField_e_of_type_Int == 8)) {
      paramAVActivity = "去认证";
    }
    for (boolean bool = true;; bool = false)
    {
      paramResultData = new SpannableString((String)localObject4 + paramAVActivity);
      int j = ((String)localObject4).length();
      int k = paramAVActivity.length() + j;
      paramResultData.setSpan(new kht(this, bool, paramAVActivity, (String)localObject3), j, k, 33);
      paramResultData.setSpan(localObject5, j, k, 17);
      paramAVActivity = (StrokeTextView)((RelativeLayout)localObject1).findViewById(2131366232);
      paramAVActivity.setText((CharSequence)((com.tencent.util.Pair)localObject2).first);
      paramAVActivity.setStrokeEnable(true);
      paramAVActivity.setStrokeColor(-3109366);
      paramAVActivity.setInnerTextColor(-1);
      paramAVActivity.setStrokeSize(i);
      paramAVActivity = (TextView)((RelativeLayout)localObject1).findViewById(2131366233);
      paramAVActivity.setVisibility(0);
      paramAVActivity.setText(paramResultData);
      paramResultData = (RedPacketLinkMovementMethod)RedPacketLinkMovementMethod.a();
      paramResultData.jdField_a_of_type_Int = -10864125;
      paramResultData.jdField_b_of_type_Int = -7447805;
      paramAVActivity.setMovementMethod(paramResultData);
      paramAVActivity.setHighlightColor(0);
      return;
      paramAVActivity = "去领取";
    }
  }
  
  void a(ResultData paramResultData)
  {
    AVActivity localAVActivity = a();
    if (localAVActivity == null)
    {
      QLog.w(this.i, 1, "onGetResult, AVActivity为空");
      return;
    }
    if (this.jdField_b_of_type_Boolean)
    {
      QLog.w(this.i, 1, "onGetResult, 显示结果");
      a(localAVActivity, paramResultData);
      return;
    }
    this.jdField_a_of_type_ComTencentAvUiRedbagResultData = paramResultData;
    QLog.w(this.i, 1, "onGetResult, 窗口还没显示");
  }
  
  void a(ResultData paramResultData, khu paramkhu)
  {
    this.jdField_a_of_type_ComTencentAvUiRedbagResultData = paramResultData;
    paramResultData = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin();
    this.jdField_a_of_type_ComTencentAvUiRedbagResultData.jdField_b_of_type_Boolean = TextUtils.equals(paramResultData, this.jdField_a_of_type_ComTencentAvUiRedbagResultData.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_Khu = paramkhu;
    paramResultData = a();
    QLog.w(this.i, 1, "show, mStarter[" + this.jdField_a_of_type_ComTencentAvUiRedbagResultData.jdField_b_of_type_Boolean + "], mGotMoney[" + this.jdField_a_of_type_ComTencentAvUiRedbagResultData.i + "], avActivity[" + paramResultData + "]");
    c();
  }
  
  boolean a()
  {
    return this.jdField_a_of_type_ComTencentAvUiRedbagResultData.jdField_b_of_type_Int - this.jdField_a_of_type_ComTencentAvUiRedbagResultData.jdField_a_of_type_Int <= this.jdField_a_of_type_ComTencentAvUiRedbagResultData.jdField_a_of_type_Int;
  }
  
  public boolean a(String paramString)
  {
    a();
    AVActivity localAVActivity = a();
    if (localAVActivity != null)
    {
      RelativeLayout localRelativeLayout = (RelativeLayout)localAVActivity.findViewById(2131366218);
      if (localRelativeLayout != null)
      {
        localRelativeLayout.setOnTouchListener(null);
        ((RelativeLayout)localAVActivity.findViewById(2131365828)).removeView(localRelativeLayout);
      }
    }
    for (boolean bool = true;; bool = false)
    {
      QLog.w(this.i, 1, "closeUI[" + paramString + "], bret[" + bool + "]");
      if (this.jdField_a_of_type_Khu != null)
      {
        this.jdField_a_of_type_Khu.a();
        this.jdField_a_of_type_Khu = null;
      }
      if (this.jdField_a_of_type_AndroidGraphicsBitmap != null)
      {
        this.jdField_a_of_type_AndroidGraphicsBitmap.recycle();
        this.jdField_a_of_type_AndroidGraphicsBitmap = null;
      }
      if (this.jdField_b_of_type_AndroidGraphicsBitmap != null)
      {
        this.jdField_b_of_type_AndroidGraphicsBitmap.recycle();
        this.jdField_b_of_type_AndroidGraphicsBitmap = null;
      }
      if (this.c != null)
      {
        this.c.recycle();
        this.c = null;
      }
      if (this.d != null)
      {
        this.d.recycle();
        this.d = null;
      }
      if (this.e != null)
      {
        this.e.recycle();
        this.e = null;
      }
      if (this.f != null)
      {
        this.f.recycle();
        this.f = null;
      }
      if (this.g != null)
      {
        this.g.recycle();
        this.g = null;
      }
      if (this.h != null)
      {
        this.h.recycle();
        this.h = null;
      }
      return bool;
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentAvUiControlUIObserver != null) {
      return;
    }
    QLog.w(this.i, 1, "listenOnActivityEvent,  mStarter[" + this.jdField_a_of_type_ComTencentAvUiRedbagResultData.jdField_b_of_type_Boolean + "], mPlayUin[" + this.jdField_a_of_type_ComTencentAvUiRedbagResultData.jdField_b_of_type_JavaLangString + "], mStartUin[" + this.jdField_a_of_type_ComTencentAvUiRedbagResultData.jdField_a_of_type_JavaLangString + "]");
    this.jdField_a_of_type_ComTencentAvUiControlUIObserver = new kho(this);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.jdField_a_of_type_ComTencentAvUiControlUIObserver);
  }
  
  public void b(AVActivity paramAVActivity)
  {
    int j = 0;
    Object localObject2 = null;
    AVRedPacketManager localAVRedPacketManager = (AVRedPacketManager)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(6);
    Object localObject3;
    Object localObject1;
    int i;
    Object localObject4;
    if (this.jdField_a_of_type_ComTencentAvUiRedbagResultData.b()) {
      if (this.jdField_a_of_type_ComTencentAvUiRedbagResultData.jdField_e_of_type_Int == 0)
      {
        localObject3 = (a(this.jdField_a_of_type_ComTencentAvUiRedbagResultData.i) + '$').toCharArray();
        localObject1 = localObject2;
        i = j;
        if (localObject3 != null)
        {
          localObject1 = localObject2;
          i = j;
          if (localObject3.length > 0)
          {
            localObject2 = new ArrayList();
            j = localObject3.length;
            i = 0;
            if (i < j)
            {
              localObject4 = Character.valueOf(localObject3[i]);
              localObject1 = "";
              if (((Character)localObject4).charValue() == '.') {
                localObject1 = "qav_redpacket_result_starter_" + "dot.png";
              }
              for (;;)
              {
                ((List)localObject2).add(new android.util.Pair(localObject4, localObject1));
                i += 1;
                break;
                if (((Character)localObject4).charValue() == '$') {
                  localObject1 = "qav_redpacket_result_starter_" + "yuan.png";
                } else if (Character.isDigit(((Character)localObject4).charValue())) {
                  localObject1 = "qav_redpacket_result_starter_" + localObject4 + ".png";
                }
              }
            }
            localObject1 = localObject2;
            i = 1;
          }
        }
        if (this.jdField_a_of_type_ComTencentAvUiRedbagResultData.jdField_a_of_type_Int * 1.0F / this.jdField_a_of_type_ComTencentAvUiRedbagResultData.jdField_b_of_type_Int >= 0.5F)
        {
          j = 1;
          if (j == 0) {
            break label572;
          }
          localObject2 = "avredbag_suc1_sender.png";
        }
      }
    }
    for (;;)
    {
      label313:
      localObject3 = a(paramAVActivity);
      ((RelativeLayout)localObject3).findViewById(2131366236).setOnTouchListener(new khs(this));
      localObject4 = (ViewGroup)((RelativeLayout)localObject3).findViewById(2131366238);
      ((ViewGroup)localObject4).removeAllViews();
      ((ImageView)((RelativeLayout)localObject3).findViewById(2131366237)).setImageBitmap(localAVRedPacketManager.a((String)localObject2));
      localObject2 = (ImageView)((RelativeLayout)localObject3).findViewById(2131366239);
      ((ImageView)localObject2).setImageBitmap(localAVRedPacketManager.a("qav_redpacket_result_close.png"));
      ((ImageView)localObject2).setOnClickListener(this);
      label415:
      label437:
      android.util.Pair localPair;
      if (i != 0)
      {
        i = 0;
        ((ViewGroup)localObject4).setVisibility(i);
        if ((localObject1 == null) || ("qav_redpacket_result_starter_".isEmpty())) {
          break label771;
        }
        j = 0;
        if (j >= ((List)localObject1).size()) {
          break label771;
        }
        localPair = (android.util.Pair)((List)localObject1).get(j);
        localObject2 = (Character)localPair.first;
        if (((Character)localObject2).charValue() != '.') {
          break label645;
        }
        localObject2 = new LinearLayout.LayoutParams(AIOUtils.a(12.0F, paramAVActivity.getResources()), AIOUtils.a(12.0F, paramAVActivity.getResources()));
        ((LinearLayout.LayoutParams)localObject2).gravity = 80;
        i = 1;
      }
      for (;;)
      {
        if (i != 0)
        {
          ImageView localImageView = new ImageView(paramAVActivity);
          localImageView.setImageBitmap(localAVRedPacketManager.a((String)localPair.second));
          ((ViewGroup)localObject4).addView(localImageView, (ViewGroup.LayoutParams)localObject2);
        }
        j += 1;
        break label437;
        j = 0;
        break;
        label572:
        localObject2 = "avredbag_suc2_sender.png";
        break label313;
        localObject1 = null;
        localObject2 = "avredbag_error2_sender.png";
        i = 0;
        break label313;
        if (this.jdField_a_of_type_ComTencentAvUiRedbagResultData.a())
        {
          localObject1 = null;
          localObject2 = "avredbag_error_sender.png";
          i = 0;
          break label313;
        }
        if (this.jdField_a_of_type_ComTencentAvUiRedbagResultData.jdField_f_of_type_Int != 4) {
          break label787;
        }
        localObject1 = null;
        localObject2 = "avredbag_error2_sender.png";
        i = 0;
        break label313;
        i = 8;
        break label415;
        label645:
        if (((Character)localObject2).charValue() == '$')
        {
          localObject2 = new LinearLayout.LayoutParams(AIOUtils.a(22.0F, paramAVActivity.getResources()), AIOUtils.a(20.0F, paramAVActivity.getResources()));
          ((LinearLayout.LayoutParams)localObject2).leftMargin = AIOUtils.a(5.0F, paramAVActivity.getResources());
          ((LinearLayout.LayoutParams)localObject2).gravity = 80;
          i = 1;
        }
        else if (Character.isDigit(((Character)localObject2).charValue()))
        {
          localObject2 = new LinearLayout.LayoutParams(AIOUtils.a(27.0F, paramAVActivity.getResources()), AIOUtils.a(37.0F, paramAVActivity.getResources()));
          ((LinearLayout.LayoutParams)localObject2).gravity = 16;
          i = 1;
        }
        else
        {
          i = 0;
          localObject2 = null;
        }
      }
      label771:
      ((RelativeLayout)((RelativeLayout)localObject3).findViewById(2131366236)).setVisibility(0);
      return;
      label787:
      localObject1 = null;
      localObject2 = "";
      i = 0;
    }
  }
  
  public void c()
  {
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().post(new khp(this));
  }
  
  public void c(AVActivity paramAVActivity)
  {
    Object localObject2 = a(paramAVActivity);
    a(paramAVActivity, (RelativeLayout)localObject2);
    RelativeLayout localRelativeLayout = (RelativeLayout)((RelativeLayout)localObject2).findViewById(2131366219);
    localRelativeLayout.setVisibility(0);
    Object localObject1 = paramAVActivity.a();
    if (this.jdField_a_of_type_AndroidGraphicsBitmap == null) {
      this.jdField_a_of_type_AndroidGraphicsBitmap = ((AVRedPacketManager)localObject1).a("qav_redpacket_result_background.png");
    }
    if (this.jdField_a_of_type_AndroidGraphicsBitmap != null) {
      localRelativeLayout.findViewById(2131366220).setBackgroundDrawable(new BitmapDrawable(paramAVActivity.getResources(), this.jdField_a_of_type_AndroidGraphicsBitmap));
    }
    ((TextView)localRelativeLayout.findViewById(2131366221)).setText(a(paramAVActivity, 2131429620, this.jdField_a_of_type_ComTencentAvUiRedbagResultData.c, this.jdField_a_of_type_ComTencentAvUiRedbagResultData.d) + "\n" + a(paramAVActivity, 2131429621, this.jdField_a_of_type_ComTencentAvUiRedbagResultData.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentAvUiRedbagResultData.jdField_b_of_type_Int));
    ((RelativeLayout)localObject2).findViewById(2131366225).setBackgroundDrawable(new BitmapDrawable(paramAVActivity.getResources(), this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(0, this.jdField_a_of_type_ComTencentAvUiRedbagResultData.jdField_b_of_type_JavaLangString, null, true, true)));
    localObject2 = localRelativeLayout.findViewById(2131366231);
    if (this.d == null) {
      this.d = ((AVRedPacketManager)localObject1).a("qav_redpacket_result_loading.png");
    }
    if (this.d != null) {
      ((View)localObject2).setBackgroundDrawable(new BitmapDrawable(paramAVActivity.getResources(), this.d));
    }
    localObject1 = new RotateAnimation(0.0F, -360.0F, 1, 0.5F, 1, 0.5F);
    ((RotateAnimation)localObject1).setInterpolator(new LinearInterpolator());
    ((RotateAnimation)localObject1).setDuration(1800L);
    ((RotateAnimation)localObject1).setRepeatCount(-1);
    ((RotateAnimation)localObject1).setRepeatMode(1);
    ((View)localObject2).setAnimation((Animation)localObject1);
    if (this.jdField_a_of_type_ComTencentAvUiRedbagResultData.jdField_b_of_type_Boolean)
    {
      a(paramAVActivity, this.jdField_a_of_type_ComTencentAvUiRedbagResultData);
      return;
    }
    if ((this.jdField_a_of_type_ComTencentAvUiRedbagResultData.jdField_e_of_type_Int != 1) && (this.jdField_a_of_type_ComTencentAvUiRedbagResultData.jdField_e_of_type_Int != -1))
    {
      QLog.w(this.i, 1, "showNormal_Result, 抢红包回调早就来了");
      a(paramAVActivity, this.jdField_a_of_type_ComTencentAvUiRedbagResultData);
      return;
    }
    this.jdField_b_of_type_Boolean = true;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131366230: 
      a("qav_result_close");
      return;
    case 2131366239: 
      a("result_starter_close");
      return;
    case 2131366228: 
      a("qav_result_button");
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(126), Boolean.valueOf(true), Integer.valueOf(7) });
      RedBagReport.m();
      return;
    }
    paramView = a();
    if (paramView != null)
    {
      Intent localIntent = new Intent();
      localIntent.addFlags(603979776);
      localIntent.putExtra("score", this.jdField_a_of_type_ComTencentAvUiRedbagResultData.jdField_a_of_type_Int);
      localIntent.putExtra("count", this.jdField_a_of_type_ComTencentAvUiRedbagResultData.c);
      localIntent.putExtra("isGoodScore", a());
      PublicFragmentActivity.Launcher.a(paramView, localIntent, PublicFragmentActivityForVideo.class, RedPacketShareFragment.class);
      paramView.finish();
      RedPacketShareFragment.a("0X8008CF4");
    }
    a("qav_result_share");
  }
  
  public String toString()
  {
    return "mResultData[" + this.jdField_a_of_type_ComTencentAvUiRedbagResultData + "]";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.av.ui.redbag.ResultUI
 * JD-Core Version:    0.7.0.1
 */