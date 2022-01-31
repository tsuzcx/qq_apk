package com.tencent.mobileqq.apollo.ai;

import android.app.Application;
import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.audiopanel.AudioPanel;
import com.tencent.mobileqq.activity.aio.audiopanel.VolumeIndicateSquareView;
import com.tencent.mobileqq.apollo.ApolloManager;
import com.tencent.mobileqq.apollo.ApolloRender;
import com.tencent.mobileqq.apollo.ApolloRenderDriver;
import com.tencent.mobileqq.apollo.ApolloRenderInterfaceImpl;
import com.tencent.mobileqq.apollo.ApolloTextureView;
import com.tencent.mobileqq.apollo.OnApolloViewListener;
import com.tencent.mobileqq.apollo.store.ApolloImageDownloader;
import com.tencent.mobileqq.apollo.store.ApolloResDownloader;
import com.tencent.mobileqq.apollo.store.openbox.RoundRectLinearLayout;
import com.tencent.mobileqq.apollo.task.ApolloActionHelper;
import com.tencent.mobileqq.apollo.utils.ApolloConstant;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ApolloActionData;
import com.tencent.mobileqq.data.ApolloBaseInfo;
import com.tencent.mobileqq.drawable.RoundRectColorDrawable;
import com.tencent.mobileqq.utils.AudioUtil;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.vas.VasExtensionHandler;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.StatableSpanTextView.StatableForegroundColorSpan;
import com.tencent.mqq.shared_file_accessor.SharedPreferencesProxyManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.WeakReferenceHandler;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;
import ylb;
import ylc;
import yld;
import yle;

public class ApolloAIActivity
  extends IphoneTitleBarActivity
  implements Handler.Callback, View.OnClickListener, OnApolloViewListener, ApolloRecorderView.OnRecordViewTouchListener, IApolloAIView
{
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private Dialog jdField_a_of_type_AndroidAppDialog;
  private AnimationDrawable jdField_a_of_type_AndroidGraphicsDrawableAnimationDrawable;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private VolumeIndicateSquareView jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeIndicateSquareView;
  private ApolloTextureView jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView;
  private ApolloAILogicProcessor jdField_a_of_type_ComTencentMobileqqApolloAiApolloAILogicProcessor;
  private ApolloAIMessage jdField_a_of_type_ComTencentMobileqqApolloAiApolloAIMessage;
  private ApolloAIPresenter jdField_a_of_type_ComTencentMobileqqApolloAiApolloAIPresenter;
  private ApolloRecorderView jdField_a_of_type_ComTencentMobileqqApolloAiApolloRecorderView;
  private RoundRectLinearLayout jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxRoundRectLinearLayout;
  private WeakReferenceHandler jdField_a_of_type_ComTencentUtilWeakReferenceHandler = new WeakReferenceHandler(Looper.getMainLooper(), this);
  public boolean a;
  private int[] jdField_a_of_type_ArrayOfInt;
  private int jdField_b_of_type_Int;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private VolumeIndicateSquareView jdField_b_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeIndicateSquareView;
  private RoundRectLinearLayout jdField_b_of_type_ComTencentMobileqqApolloStoreOpenboxRoundRectLinearLayout;
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private boolean jdField_c_of_type_Boolean;
  private int jdField_d_of_type_Int;
  private TextView jdField_d_of_type_AndroidWidgetTextView;
  private boolean jdField_d_of_type_Boolean;
  private int e;
  private int f;
  private int g;
  
  private ApolloAIMessage a(String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    ApolloAIMessage localApolloAIMessage = new ApolloAIMessage();
    localApolloAIMessage.jdField_a_of_type_JavaLangString = paramString;
    paramString = new ApolloActionData();
    paramString.actionId = paramInt;
    localApolloAIMessage.jdField_a_of_type_Boolean = true;
    localApolloAIMessage.jdField_c_of_type_Boolean = paramBoolean2;
    localApolloAIMessage.jdField_b_of_type_Boolean = paramBoolean1;
    localApolloAIMessage.jdField_c_of_type_Int = 4;
    if (ApolloUtil.a(ApolloUtil.a(paramString, 8)))
    {
      localApolloAIMessage.g = 9;
      localApolloAIMessage.jdField_b_of_type_Int = paramInt;
      return localApolloAIMessage;
    }
    localApolloAIMessage.g = 8;
    localApolloAIMessage.jdField_b_of_type_Int = 5;
    ApolloResDownloader.a(this.app, ApolloUtil.a(paramString, 8) + "/d.zip", ApolloUtil.a(paramString, 9));
    return localApolloAIMessage;
  }
  
  private void a(String paramString)
  {
    ApolloAIMessage localApolloAIMessage = new ApolloAIMessage();
    localApolloAIMessage.g = 8;
    localApolloAIMessage.jdField_c_of_type_Int = 1;
    localApolloAIMessage.jdField_b_of_type_Int = 1;
    localApolloAIMessage.jdField_a_of_type_JavaLangString = paramString;
    localApolloAIMessage.jdField_c_of_type_Boolean = false;
    localApolloAIMessage.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqApolloAiApolloAILogicProcessor.a(localApolloAIMessage);
  }
  
  private void c(boolean paramBoolean)
  {
    if (this.jdField_d_of_type_Int == 1)
    {
      this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqApolloAiApolloRecorderView.setVisibility(0);
      this.jdField_b_of_type_ComTencentMobileqqApolloStoreOpenboxRoundRectLinearLayout.setVisibility(4);
      if (paramBoolean) {
        this.jdField_a_of_type_ComTencentMobileqqApolloAiApolloAILogicProcessor.a(a("测试，测试，对面的人类你听得到我说话咩？", 109, false, false));
      }
      return;
    }
    this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(4);
    this.jdField_a_of_type_ComTencentMobileqqApolloAiApolloRecorderView.setVisibility(4);
    this.jdField_b_of_type_ComTencentMobileqqApolloStoreOpenboxRoundRectLinearLayout.setVisibility(0);
  }
  
  private void k()
  {
    SharedPreferences localSharedPreferences = getApplication().getSharedPreferences("apollo_sp", 0);
    if (localSharedPreferences.getBoolean("apollo_ai_pre_check_resource_first", true))
    {
      arrayOfInt = new int[9];
      int[] tmp33_31 = arrayOfInt;
      tmp33_31[0] = 108;
      int[] tmp38_33 = tmp33_31;
      tmp38_33[1] = 109;
      int[] tmp43_38 = tmp38_33;
      tmp43_38[2] = 110;
      int[] tmp48_43 = tmp43_38;
      tmp48_43[3] = 111;
      int[] tmp53_48 = tmp48_43;
      tmp53_48[4] = 112;
      int[] tmp58_53 = tmp53_48;
      tmp58_53[5] = 113;
      int[] tmp63_58 = tmp58_53;
      tmp63_58[6] = 114;
      int[] tmp69_63 = tmp63_58;
      tmp69_63[7] = 115;
      int[] tmp75_69 = tmp69_63;
      tmp75_69[8] = 116;
      tmp75_69;
      j = arrayOfInt.length;
      i = 0;
      while (i < j)
      {
        k = arrayOfInt[i];
        if (QLog.isColorLevel()) {
          QLog.d("ApolloAIActivity", 2, "pre check the resource" + k);
        }
        localApolloActionData = new ApolloActionData();
        localApolloActionData.actionId = k;
        if (!ApolloUtil.a(ApolloUtil.a(localApolloActionData, 8)))
        {
          if (QLog.isColorLevel()) {
            QLog.d("ApolloAIActivity", 2, "resource not found " + k);
          }
          ApolloResDownloader.a(this.app, ApolloUtil.a(localApolloActionData, 8) + "/d.zip", ApolloUtil.a(localApolloActionData, 9));
        }
        i += 1;
      }
      localSharedPreferences.edit().putBoolean("apollo_ai_pre_check_resource_first", false).commit();
    }
    while (!QLog.isColorLevel())
    {
      int[] arrayOfInt;
      int j;
      int i;
      int k;
      ApolloActionData localApolloActionData;
      return;
    }
    QLog.d("ApolloAIActivity", 2, "not the first time");
  }
  
  private void l()
  {
    int j = 0;
    if (isFinishing())
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloAIActivity", 2, "showAbnormalRecordDlg failed, mContext not valid");
      }
      return;
    }
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.obtainMessage(256, 1, 0).sendToTarget();
    String str = Build.MANUFACTURER;
    int i;
    if (str.equalsIgnoreCase("meizu")) {
      i = 2131433373;
    }
    for (;;)
    {
      try
      {
        if (this.jdField_a_of_type_AndroidAppDialog == null) {
          break label144;
        }
        this.jdField_a_of_type_AndroidAppDialog.show();
        return;
      }
      catch (Exception localException) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("ApolloAIActivity", 2, "show showAbnormalRecordDlg error : " + localException.getMessage());
      return;
      if (localException.equalsIgnoreCase("xiaomi"))
      {
        i = 2131433374;
      }
      else if (localException.equalsIgnoreCase("vivo"))
      {
        i = 2131433375;
      }
      else
      {
        i = 2131433372;
        j = 1;
      }
    }
    label144:
    SpannableString localSpannableString = new SpannableString(super.getString(i));
    if (j != 0) {
      localSpannableString.setSpan(new StatableSpanTextView.StatableForegroundColorSpan(super.getResources().getColor(2131493061), super.getResources().getColor(2131493062)), localSpannableString.length() - 7, localSpannableString.length() - 1, 33);
    }
    for (this.jdField_a_of_type_AndroidAppDialog = DialogUtil.a(this, "权限提示", localSpannableString, 0, 2131435179, null, null, new yld(this));; this.jdField_a_of_type_AndroidAppDialog = DialogUtil.a(this, 230, "权限提示", localSpannableString.toString(), "我知道了", "", null, new yle(this)))
    {
      this.jdField_a_of_type_AndroidAppDialog.show();
      return;
    }
  }
  
  public ApolloRenderDriver a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView != null) {
      return this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.getWorker();
    }
    return null;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqApolloAiApolloAIPresenter != null) {
      this.jdField_a_of_type_ComTencentMobileqqApolloAiApolloAIPresenter.b();
    }
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeIndicateSquareView.a();
    this.jdField_b_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeIndicateSquareView.a();
    this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(4);
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130837976);
    this.jdField_b_of_type_Boolean = false;
  }
  
  public void a(int paramInt) {}
  
  public void a(ApolloAIMessage paramApolloAIMessage)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloAIActivity", 2, "[onPushResponse]");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqApolloAiApolloRecorderView.a())
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloAIActivity", 2, "It is recording, discard.");
      }
      return;
    }
    long l1 = System.currentTimeMillis();
    long l2 = this.jdField_a_of_type_Long;
    if (this.jdField_a_of_type_ComTencentMobileqqApolloAiApolloAILogicProcessor != null) {
      this.jdField_a_of_type_ComTencentMobileqqApolloAiApolloAILogicProcessor.a(paramApolloAIMessage);
    }
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendEmptyMessage(255);
    int i;
    if (paramApolloAIMessage != null)
    {
      if (1 != paramApolloAIMessage.jdField_a_of_type_Int) {
        break label226;
      }
      i = paramApolloAIMessage.jdField_d_of_type_Int;
    }
    for (;;)
    {
      VipUtils.a(null, "cmshow", "Apollo", "show_chat", paramApolloAIMessage.jdField_a_of_type_Int, 0, new String[] { String.valueOf(paramApolloAIMessage.jdField_b_of_type_Int), "", String.valueOf(i), "" });
      if (this.jdField_d_of_type_Boolean) {
        break;
      }
      VipUtils.a(null, "cmshow", "Apollo", "wait_time", 0, 0, new String[] { "", "", String.valueOf(String.format("%.1f", new Object[] { Float.valueOf((float)(l1 - l2) / 1000.0F) })), "" });
      this.jdField_d_of_type_Boolean = true;
      return;
      label226:
      if ((paramApolloAIMessage.jdField_a_of_type_Int == 0) && (!TextUtils.isEmpty(paramApolloAIMessage.jdField_a_of_type_JavaLangString))) {
        i = paramApolloAIMessage.jdField_a_of_type_JavaLangString.length();
      } else {
        i = 0;
      }
    }
  }
  
  public void a(String paramString, int paramInt, double paramDouble)
  {
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.obtainMessage(258, paramInt, 0, Double.valueOf(paramDouble)).sendToTarget();
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqApolloAiApolloAIPresenter != null) {
      this.jdField_a_of_type_ComTencentMobileqqApolloAiApolloAIPresenter.a(paramBoolean);
    }
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(4);
    if (paramBoolean) {
      QQToast.a(this, "说话时间太长，已自动发送", 0).a();
    }
  }
  
  public void b()
  {
    a("啊咧？刚走神了つ﹏⊂，再说一次好不好嘛");
  }
  
  public void b(ApolloAIMessage paramApolloAIMessage)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloAIActivity", 2, "[onUpdateHistoryMsg]");
    }
    this.jdField_a_of_type_ComTencentMobileqqApolloAiApolloAIMessage = paramApolloAIMessage;
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendEmptyMessage(257);
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_c_of_type_Boolean = false;
    if (paramBoolean) {
      this.jdField_d_of_type_Int = 1;
    }
    for (;;)
    {
      c(true);
      return;
      QQToast.a(this, "开启厘米秀智能聊天失败", 0).a();
    }
  }
  
  public void c()
  {
    ApolloAIMessage localApolloAIMessage = new ApolloAIMessage();
    localApolloAIMessage.g = 8;
    localApolloAIMessage.jdField_c_of_type_Int = 2;
    localApolloAIMessage.jdField_b_of_type_Int = 2;
    localApolloAIMessage.jdField_b_of_type_Boolean = true;
    localApolloAIMessage.jdField_c_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqApolloAiApolloAILogicProcessor.a(localApolloAIMessage);
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendEmptyMessage(259);
  }
  
  public void d()
  {
    Object localObject = new ApolloAIMessage();
    ((ApolloAIMessage)localObject).jdField_b_of_type_Boolean = true;
    ((ApolloAIMessage)localObject).jdField_c_of_type_Boolean = false;
    ((ApolloAIMessage)localObject).jdField_c_of_type_Int = 3;
    ((ApolloAIMessage)localObject).jdField_b_of_type_Int = 3;
    ((ApolloAIMessage)localObject).g = 8;
    this.jdField_a_of_type_ComTencentMobileqqApolloAiApolloAILogicProcessor.a((ApolloAIMessage)localObject);
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    this.jdField_d_of_type_Boolean = false;
    localObject = super.getAppInterface();
    if ((localObject instanceof QQAppInterface)) {}
    for (localObject = (QQAppInterface)localObject;; localObject = null)
    {
      if ((localObject == null) || ((!((QQAppInterface)localObject).k()) && (!((QQAppInterface)localObject).l()))) {
        AudioUtil.b(2131230731, false);
      }
      return;
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.getWindow().addFlags(16777216);
    super.doOnCreate(paramBundle);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = new RelativeLayout(this);
    int i = (int)DeviceInfoUtil.j();
    int j = (int)DeviceInfoUtil.k();
    int k = ImmersiveUtils.a(this);
    paramBundle = URLDrawable.URLDrawableOptions.obtain();
    Object localObject1 = new ColorDrawable(-10994791);
    paramBundle.mLoadingDrawable = ((Drawable)localObject1);
    paramBundle.mFailedDrawable = ((Drawable)localObject1);
    paramBundle.mRequestWidth = i;
    paramBundle.mRequestHeight = (j - k);
    paramBundle = ApolloImageDownloader.a("apollo_ai_float_bg.png", paramBundle, "http://cmshow.gtimg.cn/client/img/apollo_ai_background.jpg");
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundDrawable(paramBundle);
    super.setContentView(this.jdField_a_of_type_AndroidWidgetRelativeLayout);
    this.jdField_a_of_type_ComTencentMobileqqApolloAiApolloAILogicProcessor = new ApolloAILogicProcessor(this);
    this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView = new ApolloTextureView(this, null);
    this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.init(this);
    this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.getRender().setRenderCallback(this.jdField_a_of_type_ComTencentMobileqqApolloAiApolloAILogicProcessor);
    this.jdField_c_of_type_Int = super.getIntent().getIntExtra("extra_key_apollo_roleid", 1);
    this.jdField_a_of_type_ArrayOfInt = super.getIntent().getIntArrayExtra("extra_key_apollo_dressids");
    this.jdField_a_of_type_Float = super.getIntent().getFloatExtra("extra_key_apollo_scale", 0.2F);
    this.jdField_b_of_type_Int = super.getIntent().getIntExtra("extra_key_apollo_position_x", 0);
    this.jdField_a_of_type_Int = super.getIntent().getIntExtra("extra_key_apollo_position_y", 0);
    i = super.getIntent().getIntExtra("extra_key_apollo_view_left", 0);
    j = super.getIntent().getIntExtra("extra_key_apollo_view_top", 0);
    paramBundle = new RelativeLayout.LayoutParams(super.getIntent().getIntExtra("extra_key_apollo_view_width", -1), super.getIntent().getIntExtra("extra_key_apollo_view_height", -1));
    paramBundle.addRule(10);
    paramBundle.addRule(9);
    paramBundle.leftMargin = i;
    paramBundle.topMargin = j;
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView, paramBundle);
    this.jdField_a_of_type_ComTencentMobileqqApolloAiApolloRecorderView = new ApolloRecorderView(this, this);
    paramBundle = new RelativeLayout.LayoutParams(AIOUtils.a(76.0F, super.getResources()), AIOUtils.a(76.0F, super.getResources()));
    paramBundle.addRule(12);
    paramBundle.addRule(14);
    paramBundle.bottomMargin = AIOUtils.a(47.0F, super.getResources());
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_ComTencentMobileqqApolloAiApolloRecorderView, paramBundle);
    this.jdField_c_of_type_AndroidWidgetTextView = new TextView(this);
    this.jdField_c_of_type_AndroidWidgetTextView.setBackgroundResource(2130846141);
    paramBundle = new RelativeLayout.LayoutParams(-2, -2);
    paramBundle.addRule(10, -1);
    paramBundle.addRule(11, -1);
    i = (int)DeviceInfoUtil.j();
    j = (int)DeviceInfoUtil.k();
    k = ImmersiveUtils.a(this);
    paramBundle.rightMargin = ((int)(i * 0.032D));
    paramBundle.topMargin = ((int)((j - k) * 0.017D));
    this.jdField_c_of_type_AndroidWidgetTextView.setGravity(17);
    this.jdField_c_of_type_AndroidWidgetTextView.setTextSize(17.0F);
    this.jdField_c_of_type_AndroidWidgetTextView.setTextColor(-1);
    this.jdField_c_of_type_AndroidWidgetTextView.setText(2131434920);
    this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_c_of_type_AndroidWidgetTextView, paramBundle);
    this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxRoundRectLinearLayout = new RoundRectLinearLayout(this);
    this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxRoundRectLinearLayout.setVisibility(8);
    paramBundle = new RelativeLayout.LayoutParams(-2, -2);
    paramBundle.addRule(10);
    paramBundle.addRule(9);
    paramBundle.topMargin = AIOUtils.a(48.0F, super.getResources());
    paramBundle.leftMargin = AIOUtils.a(12.0F, super.getResources());
    i = AIOUtils.a(10.0F, super.getResources());
    this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxRoundRectLinearLayout.setGravity(16);
    this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxRoundRectLinearLayout.setOrientation(0);
    this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxRoundRectLinearLayout.setGravity(17);
    this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxRoundRectLinearLayout.setPadding(i, i, i, i);
    this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxRoundRectLinearLayout.setRoundRect(AIOUtils.a(12.0F, super.getResources()), 838860800, false);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxRoundRectLinearLayout, paramBundle);
    this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxRoundRectLinearLayout.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetImageView = new ImageView(this);
    this.jdField_a_of_type_AndroidGraphicsDrawableAnimationDrawable = ((AnimationDrawable)super.getResources().getDrawable(2130837971));
    this.jdField_a_of_type_AndroidGraphicsDrawableAnimationDrawable.setBounds(0, 0, this.jdField_a_of_type_AndroidGraphicsDrawableAnimationDrawable.getIntrinsicWidth(), this.jdField_a_of_type_AndroidGraphicsDrawableAnimationDrawable.getIntrinsicHeight());
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130837976);
    paramBundle = new LinearLayout.LayoutParams(-2, -2);
    paramBundle.rightMargin = AIOUtils.a(5.0F, super.getResources());
    this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxRoundRectLinearLayout.addView(this.jdField_a_of_type_AndroidWidgetImageView, paramBundle);
    this.jdField_a_of_type_AndroidWidgetTextView = new TextView(this);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-1);
    this.jdField_a_of_type_AndroidWidgetTextView.setMaxLines(3);
    this.jdField_a_of_type_AndroidWidgetTextView.setMaxWidth(AIOUtils.a(168.0F, super.getResources()));
    this.jdField_a_of_type_AndroidWidgetTextView.setEllipsize(TextUtils.TruncateAt.END);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(14.0F);
    this.jdField_a_of_type_AndroidWidgetTextView.setIncludeFontPadding(false);
    paramBundle = new LinearLayout.LayoutParams(-2, -2);
    paramBundle.rightMargin = AIOUtils.a(4.0F, super.getResources());
    this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxRoundRectLinearLayout.addView(this.jdField_a_of_type_AndroidWidgetTextView, paramBundle);
    this.jdField_d_of_type_AndroidWidgetTextView = new TextView(this);
    this.jdField_d_of_type_AndroidWidgetTextView.setTextSize(14.0F);
    this.jdField_d_of_type_AndroidWidgetTextView.setTextColor(-6777857);
    this.jdField_d_of_type_AndroidWidgetTextView.setText("按住说话");
    paramBundle = new RelativeLayout.LayoutParams(-2, -2);
    paramBundle.addRule(12);
    paramBundle.addRule(14);
    paramBundle.bottomMargin = AIOUtils.a(24.0F, super.getResources());
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_d_of_type_AndroidWidgetTextView, paramBundle);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)super.getLayoutInflater().inflate(2130968675, null));
    paramBundle = new RelativeLayout.LayoutParams(-2, AIOUtils.a(20.0F, super.getResources()));
    paramBundle.addRule(12);
    paramBundle.addRule(14);
    paramBundle.bottomMargin = AIOUtils.a(24.0F, super.getResources());
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setOrientation(0);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_AndroidWidgetLinearLayout, paramBundle);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(4);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeIndicateSquareView = ((VolumeIndicateSquareView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131363108));
    this.jdField_b_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeIndicateSquareView = ((VolumeIndicateSquareView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131363110));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131363109));
    this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(-1);
    paramBundle = super.getAppInterface();
    if (paramBundle != null)
    {
      localObject1 = (ApolloManager)paramBundle.getManager(152);
      if (localObject1 != null) {
        this.jdField_d_of_type_Int = ((ApolloManager)localObject1).b(paramBundle.getCurrentAccountUin()).getAISwitch();
      }
    }
    this.jdField_b_of_type_ComTencentMobileqqApolloStoreOpenboxRoundRectLinearLayout = new RoundRectLinearLayout(this);
    i = AIOUtils.a(220.0F, super.getResources());
    j = AIOUtils.a(40.0F, super.getResources());
    localObject1 = new RelativeLayout.LayoutParams(i, j);
    ((RelativeLayout.LayoutParams)localObject1).addRule(12);
    ((RelativeLayout.LayoutParams)localObject1).addRule(14);
    ((RelativeLayout.LayoutParams)localObject1).bottomMargin = AIOUtils.a(80.0F, super.getResources());
    this.jdField_b_of_type_ComTencentMobileqqApolloStoreOpenboxRoundRectLinearLayout.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_b_of_type_ComTencentMobileqqApolloStoreOpenboxRoundRectLinearLayout, (ViewGroup.LayoutParams)localObject1);
    this.jdField_b_of_type_ComTencentMobileqqApolloStoreOpenboxRoundRectLinearLayout.setGravity(17);
    k = AIOUtils.a(3.0F, super.getResources());
    localObject1 = new StateListDrawable();
    Object localObject2 = new RoundRectColorDrawable(-10400769, k, i, j);
    RoundRectColorDrawable localRoundRectColorDrawable = new RoundRectColorDrawable(-11058203, k, i, j);
    ((StateListDrawable)localObject1).addState(new int[] { 16842919, 16842910 }, (Drawable)localObject2);
    ((StateListDrawable)localObject1).addState(new int[0], localRoundRectColorDrawable);
    this.jdField_b_of_type_ComTencentMobileqqApolloStoreOpenboxRoundRectLinearLayout.setBackgroundDrawable((Drawable)localObject1);
    localObject1 = new TextView(this);
    ((TextView)localObject1).setTextColor(-1);
    ((TextView)localObject1).setTextSize(18.0F);
    ((TextView)localObject1).setText("开启厘米秀智能聊天");
    localObject2 = new LinearLayout.LayoutParams(-2, -2);
    this.jdField_b_of_type_ComTencentMobileqqApolloStoreOpenboxRoundRectLinearLayout.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
    c(false);
    if ((paramBundle instanceof QQAppInterface))
    {
      this.jdField_a_of_type_ComTencentMobileqqApolloAiApolloAIPresenter = new ApolloAIPresenter((QQAppInterface)paramBundle, this, this);
      this.jdField_a_of_type_ComTencentMobileqqApolloAiApolloAILogicProcessor.a((QQAppInterface)paramBundle);
    }
    paramBundle = new File(ApolloConstant.j);
    if (!paramBundle.exists()) {
      paramBundle.mkdir();
    }
    ThreadManager.executeOnSubThread(new ylb(this));
    VasExtensionHandler.a(this, super.getAppInterface(), "android.ai", 1, "enter_AI", null);
    super.setImmersiveStatus();
    super.hideTitleBar();
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    if ((this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView != null) && (this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.getRenderImpl() != null)) {
      this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.getRenderImpl().c();
    }
    if (this.jdField_a_of_type_AndroidAppDialog != null) {
      this.jdField_a_of_type_AndroidAppDialog.dismiss();
    }
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeCallbacksAndMessages(null);
    ThreadManager.post(new ylc(this), 5, null, true);
    if (this.jdField_a_of_type_ComTencentMobileqqApolloAiApolloAILogicProcessor != null) {
      this.jdField_a_of_type_ComTencentMobileqqApolloAiApolloAILogicProcessor.c();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqApolloAiApolloAIPresenter != null) {
      this.jdField_a_of_type_ComTencentMobileqqApolloAiApolloAIPresenter.c();
    }
  }
  
  protected void doOnPause()
  {
    super.doOnPause();
    this.jdField_a_of_type_Boolean = true;
    if (this.jdField_a_of_type_ComTencentMobileqqApolloAiApolloAILogicProcessor != null) {
      this.jdField_a_of_type_ComTencentMobileqqApolloAiApolloAILogicProcessor.b();
    }
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void e()
  {
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendEmptyMessage(260);
  }
  
  public void f()
  {
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.obtainMessage(256, 5, 0).sendToTarget();
  }
  
  public void finish()
  {
    super.finish();
    super.overridePendingTransition(2131034165, 2131034167);
    if (QLog.isColorLevel()) {
      QLog.d("ApolloAIActivity", 2, "ApolloAIActivity:finish");
    }
  }
  
  public void g()
  {
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.obtainMessage(256, 1, 0).sendToTarget();
  }
  
  public void h()
  {
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.obtainMessage(256, 2, 0).sendToTarget();
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    label147:
    do
    {
      do
      {
        do
        {
          return false;
          if (this.jdField_b_of_type_Boolean)
          {
            this.jdField_b_of_type_Boolean = false;
            this.jdField_a_of_type_AndroidGraphicsDrawableAnimationDrawable.stop();
          }
          this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130837976);
          return false;
          this.jdField_b_of_type_AndroidWidgetTextView.setText("0:00");
          return false;
          this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
          this.jdField_a_of_type_ComTencentMobileqqApolloAiApolloRecorderView.setState(0);
          return false;
        } while (this.jdField_a_of_type_ComTencentMobileqqApolloAiApolloAIMessage == null);
        if (this.jdField_a_of_type_ComTencentMobileqqApolloAiApolloAIMessage.jdField_a_of_type_Int == 0) {
          if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqApolloAiApolloAIMessage.jdField_c_of_type_JavaLangString))
          {
            this.jdField_a_of_type_AndroidWidgetTextView.setText("查看详情");
            i = AIOUtils.a(10.0F, super.getResources());
            this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxRoundRectLinearLayout.setPadding(i, i, i, i);
            this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
          }
        }
        while (this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxRoundRectLinearLayout.getVisibility() != 0)
        {
          this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxRoundRectLinearLayout.setVisibility(0);
          return false;
          this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqApolloAiApolloAIMessage.jdField_a_of_type_JavaLangString);
          break label147;
          int k = (int)Math.ceil(this.jdField_a_of_type_ComTencentMobileqqApolloAiApolloAIMessage.jdField_d_of_type_Int / 1000.0F);
          this.jdField_a_of_type_AndroidWidgetTextView.setText(k + "\"");
          i = AIOUtils.a(10.0F, super.getResources());
          int j = AIOUtils.a(8.0F, super.getResources());
          k = k * 450 / 60;
          this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxRoundRectLinearLayout.setPadding(i, j, k + i, j);
          this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        }
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(4);
        this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_a_of_type_ComTencentMobileqqApolloAiApolloRecorderView.setState(0);
        if (paramMessage.arg1 == 1)
        {
          a("录音失败，再说一次嘛");
          return false;
        }
        if (paramMessage.arg1 == 4)
        {
          a("说话时间太短，我听不清楚");
          return false;
        }
        if (paramMessage.arg1 == 2)
        {
          a("语音发送失败，再说一次嘛");
          return false;
        }
        if (paramMessage.arg1 == 3)
        {
          a("语音发送失败，再说一次嘛");
          return false;
        }
      } while (paramMessage.arg1 != 5);
      l();
      return false;
    } while (paramMessage.obj == null);
    int i = AudioPanel.a(paramMessage.arg1) / 1250;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeIndicateSquareView.a(i);
    this.jdField_b_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeIndicateSquareView.a(i);
    this.jdField_b_of_type_AndroidWidgetTextView.setText(AudioPanel.a(((Double)paramMessage.obj).doubleValue()));
    return false;
  }
  
  public void i()
  {
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.obtainMessage(256, 3, 0).sendToTarget();
  }
  
  protected boolean isWrapContent()
  {
    return false;
  }
  
  public void j()
  {
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.obtainMessage(256, 4, 0).sendToTarget();
  }
  
  public void onClick(View paramView)
  {
    if (paramView == this.jdField_c_of_type_AndroidWidgetTextView) {
      finish();
    }
    do
    {
      do
      {
        do
        {
          return;
          if (paramView != this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxRoundRectLinearLayout) {
            break;
          }
        } while (this.jdField_a_of_type_ComTencentMobileqqApolloAiApolloAIMessage == null);
        this.jdField_a_of_type_ComTencentMobileqqApolloAiApolloAILogicProcessor.a(true, this.jdField_a_of_type_ComTencentMobileqqApolloAiApolloAIMessage);
      } while (this.jdField_a_of_type_ComTencentMobileqqApolloAiApolloAIMessage.jdField_a_of_type_Int != 1);
      if (!this.jdField_b_of_type_Boolean)
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableAnimationDrawable);
        this.jdField_a_of_type_AndroidGraphicsDrawableAnimationDrawable.start();
        this.jdField_b_of_type_Boolean = true;
        this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeMessages(260);
        this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendEmptyMessageDelayed(260, this.jdField_a_of_type_ComTencentMobileqqApolloAiApolloAIMessage.jdField_d_of_type_Int);
        return;
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130837976);
      this.jdField_b_of_type_Boolean = false;
      return;
    } while ((paramView != this.jdField_b_of_type_ComTencentMobileqqApolloStoreOpenboxRoundRectLinearLayout) || (this.jdField_a_of_type_ComTencentMobileqqApolloAiApolloAIPresenter == null) || (this.jdField_c_of_type_Boolean));
    this.jdField_c_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqApolloAiApolloAIPresenter.b(1);
    VipUtils.a(null, "cmshow", "Apollo", "open_AI", 0, 0, new String[0]);
  }
  
  public void onNotifyLongTouch(String paramString) {}
  
  public void onNotifyStatusChanged(int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloAIActivity", 2, "[onNotifyStatusChanged], clickPart:" + paramInt);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqApolloAiApolloAILogicProcessor == null) {
      return;
    }
    switch (paramInt)
    {
    }
    for (;;)
    {
      for (;;)
      {
        label88:
        if (7 == paramInt) {
          break label318;
        }
        try
        {
          paramString = new JSONObject();
          if ((paramInt <= 0) || (paramInt >= ApolloConstant.a.length)) {
            break;
          }
          paramString.put("SampleString1", ApolloConstant.a[paramInt]);
          VasExtensionHandler.a(this, super.getAppInterface(), "android.ai", 1, "clk_avatar", paramString);
          return;
        }
        catch (Exception paramString)
        {
          return;
        }
      }
      this.jdField_a_of_type_ComTencentMobileqqApolloAiApolloAILogicProcessor.a(false, null);
      continue;
      if (this.e % 2 == 0) {
        this.jdField_a_of_type_ComTencentMobileqqApolloAiApolloAILogicProcessor.a(a("最近好多烦心事，好想找你聊聊", 110, true, false));
      }
      for (;;)
      {
        this.e += 1;
        break;
        this.jdField_a_of_type_ComTencentMobileqqApolloAiApolloAILogicProcessor.a(a("你是不是想和人家聊天吶", 111, true, false));
      }
      if (this.f % 2 == 0) {
        this.jdField_a_of_type_ComTencentMobileqqApolloAiApolloAILogicProcessor.a(a("今天心情怎么样？我们来聊天吧╮(￣▽￣)╭", 114, true, false));
      }
      for (;;)
      {
        this.f += 1;
        break;
        this.jdField_a_of_type_ComTencentMobileqqApolloAiApolloAILogicProcessor.a(a("你这样人家会害羞的啦(′▽`〃)", 115, true, false));
      }
      if (this.g % 2 != 0) {
        break label320;
      }
      this.jdField_a_of_type_ComTencentMobileqqApolloAiApolloAILogicProcessor.a(a("诶？不好好说话干什么呢", 112, true, false));
    }
    for (;;)
    {
      this.g += 1;
      break label88;
      label318:
      break;
      label320:
      this.jdField_a_of_type_ComTencentMobileqqApolloAiApolloAILogicProcessor.a(a("不可以！", 113, true, false));
    }
  }
  
  public void onSurfaceReady(int paramInt1, int paramInt2)
  {
    if (!ApolloActionHelper.a(getCurrentAccountUin(), this.jdField_c_of_type_Int, this.jdField_a_of_type_ArrayOfInt, null)) {
      QLog.e("ApolloAIActivity", 1, "role or dress res not exsit!");
    }
    Object localObject;
    for (;;)
    {
      return;
      if ((this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView != null) && (this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.getRenderImpl() != null))
      {
        this.jdField_a_of_type_ComTencentMobileqqApolloAiApolloAILogicProcessor.a(this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.getRenderImpl());
        this.jdField_a_of_type_ComTencentMobileqqApolloAiApolloAILogicProcessor.a(this.jdField_c_of_type_Int, this.jdField_a_of_type_ArrayOfInt, this.jdField_a_of_type_Float, this.jdField_b_of_type_Int, this.jdField_a_of_type_Int);
        localObject = super.getIntent().getStringExtra("extra_key_apollo_aipush");
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          break label164;
        }
        localObject = ApolloManager.a((String)localObject);
        if (localObject == null) {
          break;
        }
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          ApolloAIMessage localApolloAIMessage = (ApolloAIMessage)((Iterator)localObject).next();
          ApolloAIPresenter.a(this.app, localApolloAIMessage);
          this.jdField_a_of_type_ComTencentMobileqqApolloAiApolloAILogicProcessor.a(localApolloAIMessage);
        }
      }
    }
    label164:
    if (this.jdField_d_of_type_Int == 1)
    {
      localObject = SharedPreferencesProxyManager.getInstance().getProxy("apollo_sp", 0);
      if (((SharedPreferences)localObject).getBoolean("apollo_ai_funcopen_firstuse", true))
      {
        this.jdField_a_of_type_ComTencentMobileqqApolloAiApolloAILogicProcessor.a(a("测试，测试，对面的人类你听得到我说话咩？", 109, false, false));
        ((SharedPreferences)localObject).edit().putBoolean("apollo_ai_funcopen_firstuse", false).commit();
        return;
      }
      localObject = new ApolloAIMessage();
      ((ApolloAIMessage)localObject).jdField_c_of_type_Int = 5;
      ((ApolloAIMessage)localObject).g = 8;
      ((ApolloAIMessage)localObject).jdField_b_of_type_Int = 5;
      ((ApolloAIMessage)localObject).jdField_c_of_type_Boolean = false;
      ((ApolloAIMessage)localObject).jdField_b_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentMobileqqApolloAiApolloAILogicProcessor.a((ApolloAIMessage)localObject);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqApolloAiApolloAILogicProcessor.a(a("我已经获得生命，可以和你自由对话。快开启功能试试看~", 108, false, false));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.ai.ApolloAIActivity
 * JD-Core Version:    0.7.0.1
 */