package com.tencent.mobileqq.activity.aio.rebuild;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Message;
import android.os.Parcelable;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.dataline.util.file.SendInfo;
import com.tencent.av.ui.AIOTopRightButtonConfig;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.device.datadef.DeviceInfo;
import com.tencent.device.datadef.ProductInfo;
import com.tencent.device.devicemgr.SmartDeviceProxyMgr;
import com.tencent.device.file.DevVideoMsgProcessor;
import com.tencent.device.file.DeviceAVFileMsgObserver;
import com.tencent.device.file.DeviceFileHandler;
import com.tencent.device.msg.data.DevSingleStructMsgProcessor;
import com.tencent.device.msg.data.DeviceComnFileMsgProcessor;
import com.tencent.device.msg.data.DeviceMsgHandle;
import com.tencent.device.msg.data.MessageForDevLittleVideo;
import com.tencent.device.msg.data.MessageForDevPtt;
import com.tencent.device.utils.LightAppSettingInfo;
import com.tencent.device.utils.LightAppUtil;
import com.tencent.device.utils.SmartDeviceReport;
import com.tencent.device.utils.SmartDeviceUtil;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.InputLinearLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.core.UnreadTask;
import com.tencent.mobileqq.activity.aio.core.input.AIOInput;
import com.tencent.mobileqq.activity.aio.core.input.AIOInputBuilder;
import com.tencent.mobileqq.activity.aio.core.msglist.MsgList;
import com.tencent.mobileqq.activity.aio.core.msglist.MsgListBuilder;
import com.tencent.mobileqq.activity.aio.core.tips.TipsController;
import com.tencent.mobileqq.activity.aio.coreui.msglist.ListUI;
import com.tencent.mobileqq.activity.aio.coreui.msglist.Scroller;
import com.tencent.mobileqq.activity.aio.helper.HelperProvider;
import com.tencent.mobileqq.activity.aio.panel.AIOPanelUtiles;
import com.tencent.mobileqq.activity.aio.panel.PanelIconLinearLayout;
import com.tencent.mobileqq.activity.aio.rebuild.input.send.DeviceMessageSender;
import com.tencent.mobileqq.activity.aio.rebuild.msglist.DeviceMsgListRefresher;
import com.tencent.mobileqq.activity.aio.rebuild.panel.PtvPanelProviderHelper;
import com.tencent.mobileqq.activity.aio.tips.TipsManager;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.utils.PermissionUtils;
import com.tencent.mobileqq.data.MessageForDeviceFile;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.equipmentlock.EquipmentLockImpl;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter.FileAssistantReportData;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.pic.PicReq;
import com.tencent.mobileqq.pic.api.IPicBus;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.startup.step.CheckPermission;
import com.tencent.mobileqq.utils.AlbumConstants;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.RecordParams;
import com.tencent.mobileqq.utils.RecordParams.RecorderParam;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.VersionUtils;
import com.tencent.widget.PatchedButton;
import com.tencent.widget.XEditTextEx;
import com.tencent.widget.XPanelContainer;
import cooperation.smartdevice.SmartDevicePluginLoader;
import cooperation.smartdevice.SmartDevicePluginProxyActivity;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import mqq.os.MqqHandler;
import org.json.JSONException;
import org.json.JSONObject;

public class DeviceMsgChatPie
  extends BaseChatPie
{
  public static boolean H = false;
  public static ConcurrentHashMap<Integer, MessageRecord> a;
  static int j;
  static int k = 10;
  static int jdField_l_of_type_Int = 11;
  boolean D = false;
  public volatile boolean E = false;
  boolean F = false;
  public boolean G = false;
  boolean I = false;
  public boolean J = false;
  private boolean K = false;
  BroadcastReceiver a;
  protected Boolean a;
  public String d;
  public int g = 0;
  int h = 0;
  int i = 0;
  private ImageView jdField_l_of_type_AndroidWidgetImageView;
  
  static
  {
    jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap(20);
    jdField_j_of_type_Int = 100100;
  }
  
  public DeviceMsgChatPie(QQAppInterface paramQQAppInterface, ViewGroup paramViewGroup, BaseActivity paramBaseActivity, Context paramContext)
  {
    super(paramQQAppInterface, paramViewGroup, paramBaseActivity, paramContext);
    this.jdField_d_of_type_JavaLangString = "";
    this.jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(false);
    this.jdField_a_of_type_AndroidContentBroadcastReceiver = new DeviceMsgChatPie.7(this);
  }
  
  private void a(int paramInt, FrameLayout.LayoutParams paramLayoutParams, ProductInfo paramProductInfo)
  {
    if (paramProductInfo.isSupportMainMsgType(15))
    {
      if (paramProductInfo.isSupportFuncMsgType(3)) {
        return;
      }
      if (paramProductInfo.isSupportFuncMsgType(1)) {
        return;
      }
      paramProductInfo.isSupportFuncMsgType(2);
      return;
    }
    if (paramProductInfo.isSupportMainMsgType(8))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setAllEnable(true);
      if (VersionUtils.e()) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setAllAlpha(0.6F);
      }
      paramLayoutParams.leftMargin = paramInt;
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setLayoutParams(paramLayoutParams);
      return;
    }
    if ((0xF & paramProductInfo.supportMainMsgType) == 3)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setAllEnable(true);
      if (VersionUtils.e()) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setAllAlpha(0.6F);
      }
      paramLayoutParams.leftMargin = paramInt;
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setLayoutParams(paramLayoutParams);
      return;
    }
    if (paramProductInfo.isSupportMainMsgType(1))
    {
      if (paramProductInfo.isSupportFuncMsgType(3))
      {
        paramLayoutParams.rightMargin = paramInt;
        this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setLayoutParams(paramLayoutParams);
        return;
      }
      if (paramProductInfo.isSupportFuncMsgType(1))
      {
        paramLayoutParams.rightMargin = paramInt;
        this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setLayoutParams(paramLayoutParams);
        return;
      }
      if (paramProductInfo.isSupportFuncMsgType(2))
      {
        paramLayoutParams.rightMargin = paramInt;
        this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setLayoutParams(paramLayoutParams);
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setAllEnable(false);
      if (VersionUtils.e()) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setAllAlpha(0.6F);
      }
      paramLayoutParams.leftMargin = paramInt;
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setLayoutParams(paramLayoutParams);
      return;
    }
    if (paramProductInfo.isSupportMainMsgType(2))
    {
      if (paramProductInfo.isSupportFuncMsgType(3))
      {
        this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setHint(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getString(2131720128));
        this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setHintTextColor(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getColor(2131167287));
        this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setGravity(17);
        this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setFocusable(false);
        this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setFocusableInTouchMode(false);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.setVisibility(8);
        return;
      }
      if (paramProductInfo.isSupportFuncMsgType(1))
      {
        this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setHint(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getString(2131720128));
        this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setHintTextColor(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getColor(2131167287));
        this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setGravity(17);
        this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setFocusable(false);
        this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setFocusableInTouchMode(false);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.setVisibility(8);
        return;
      }
      if (paramProductInfo.isSupportFuncMsgType(2))
      {
        this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setHint(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getString(2131720128));
        this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setHintTextColor(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getColor(2131167287));
        this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setGravity(17);
        this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setFocusable(false);
        this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setFocusableInTouchMode(false);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.setVisibility(8);
        return;
      }
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setAllEnable(true);
      if (VersionUtils.e()) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setAllAlpha(0.6F);
      }
      this.jdField_a_of_type_ComTencentWidgetPatchedButton.setVisibility(8);
      return;
    }
    this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setVisibility(0);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setAllEnable(true);
    if (VersionUtils.e()) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setAllAlpha(1.0F);
    }
    if (paramProductInfo.isSupportFuncMsgType(3))
    {
      paramLayoutParams.rightMargin = paramInt;
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setHint(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getString(2131720128));
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setHintTextColor(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getColor(2131167287));
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setGravity(17);
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setFocusable(false);
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setFocusableInTouchMode(false);
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setLayoutParams(paramLayoutParams);
      this.jdField_a_of_type_ComTencentWidgetPatchedButton.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.setVisibility(8);
      return;
    }
    if (paramProductInfo.isSupportFuncMsgType(1))
    {
      paramLayoutParams.rightMargin = paramInt;
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setHint(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getString(2131720128));
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setHintTextColor(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getColor(2131167287));
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setGravity(17);
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setFocusable(false);
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setFocusableInTouchMode(false);
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setLayoutParams(paramLayoutParams);
      this.jdField_a_of_type_ComTencentWidgetPatchedButton.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.setVisibility(8);
      return;
    }
    if (paramProductInfo.isSupportFuncMsgType(2))
    {
      paramLayoutParams.rightMargin = paramInt;
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setHint(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getString(2131720128));
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setHintTextColor(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getColor(2131167287));
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setGravity(17);
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setFocusable(false);
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setFocusableInTouchMode(false);
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setLayoutParams(paramLayoutParams);
      this.jdField_a_of_type_ComTencentWidgetPatchedButton.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.setVisibility(8);
    }
  }
  
  public static void a(int paramInt, MessageRecord paramMessageRecord)
  {
    jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(paramInt), paramMessageRecord);
  }
  
  private void a(DeviceInfo paramDeviceInfo)
  {
    if ((this.F) && (this.G) && (paramDeviceInfo != null)) {
      SmartDeviceReport.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramDeviceInfo.din, "Usr_AIO_SupportGroupChat", 0, 0, paramDeviceInfo.productId);
    }
  }
  
  private void a(DeviceInfo paramDeviceInfo, ProductInfo paramProductInfo, boolean paramBoolean)
  {
    if (paramProductInfo != null)
    {
      if ((paramProductInfo.supportMainMsgType & 0xF) != 0) {
        this.F = true;
      }
      if ((!paramBoolean) && ((paramDeviceInfo.SSOBid_Platform == 1027) || ((!StringUtil.a(paramDeviceInfo.SSOBid_Version)) && (Double.valueOf(paramDeviceInfo.SSOBid_Version).doubleValue() >= 1.1D))))
      {
        this.G = true;
        SettingCloneUtil.writeValue(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, null, "devicemsg_openchat_firsttrue", true);
        return;
      }
      if ((paramBoolean) || (H)) {
        this.G = true;
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, ArrayList<String> paramArrayList, String paramString2)
  {
    Bundle localBundle = new Bundle();
    try
    {
      paramString2 = new JSONObject(paramString2);
      int m = paramString2.optInt("num", 1);
      int n = paramString2.optInt("face", 1);
      int i1 = paramString2.optInt("mediaSize", 1);
      int i2 = paramString2.optInt("mediaType", 1);
      int i3 = paramString2.optInt("scaling", 1);
      int i4 = paramString2.optInt("orientation", 1);
      try
      {
        int i5 = paramString2.optInt("color", 1);
        int i6 = paramString2.optInt("quality", 1);
        localBundle.putInt("copies", m);
        localBundle.putInt("duplexMode", n);
        localBundle.putInt("mediaSize", i1);
        localBundle.putInt("mediaType", i2);
        localBundle.putInt("scaling", i3);
        localBundle.putInt("orientation", i4);
        localBundle.putInt("color", i5);
        localBundle.putInt("quality", i6);
      }
      catch (Exception paramString2) {}catch (JSONException paramString2) {}
      if (!QLog.isColorLevel()) {
        break label286;
      }
    }
    catch (Exception paramString2)
    {
      if (!QLog.isColorLevel()) {
        break label286;
      }
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("getString from json Exception error:");
      localStringBuilder.append(paramString2.getMessage());
      QLog.d("DeviceMsgChatPie", 2, localStringBuilder.toString());
    }
    catch (JSONException paramString2) {}
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getString from json JSONException error:");
    localStringBuilder.append(paramString2.getMessage());
    QLog.d("DeviceMsgChatPie", 2, localStringBuilder.toString());
    label286:
    ((DeviceMsgHandle)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DEVICEMSG_HANDLER)).a().a(DeviceMsgHandle.c, paramString1, paramArrayList, localBundle);
  }
  
  /* Error */
  private boolean a(Intent paramIntent)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 208	com/tencent/mobileqq/activity/aio/rebuild/DeviceMsgChatPie:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   4: getstatic 371	com/tencent/mobileqq/app/BusinessHandlerFactory:DEVICEPROXYMGR_HANDLER	Ljava/lang/String;
    //   7: invokevirtual 352	com/tencent/mobileqq/app/QQAppInterface:getBusinessHandler	(Ljava/lang/String;)Lcom/tencent/mobileqq/app/BusinessHandler;
    //   10: checkcast 373	com/tencent/device/devicemgr/SmartDeviceProxyMgr
    //   13: astore 8
    //   15: aload 8
    //   17: aload_0
    //   18: getfield 249	com/tencent/mobileqq/activity/aio/rebuild/DeviceMsgChatPie:jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo	Lcom/tencent/mobileqq/activity/aio/SessionInfo;
    //   21: getfield 253	com/tencent/mobileqq/activity/aio/SessionInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   24: invokestatic 379	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   27: invokevirtual 382	com/tencent/device/devicemgr/SmartDeviceProxyMgr:a	(J)Lcom/tencent/device/datadef/DeviceInfo;
    //   30: astore 7
    //   32: aload 7
    //   34: ifnull +34 -> 68
    //   37: aload 8
    //   39: aload 7
    //   41: getfield 218	com/tencent/device/datadef/DeviceInfo:productId	I
    //   44: invokevirtual 385	com/tencent/device/devicemgr/SmartDeviceProxyMgr:a	(I)Lcom/tencent/device/datadef/ProductInfo;
    //   47: astore 8
    //   49: aload 8
    //   51: ifnull +17 -> 68
    //   54: aload 8
    //   56: iconst_2
    //   57: invokevirtual 102	com/tencent/device/datadef/ProductInfo:isSupportFuncMsgType	(I)Z
    //   60: ifeq +8 -> 68
    //   63: iconst_1
    //   64: istore_2
    //   65: goto +5 -> 70
    //   68: iconst_0
    //   69: istore_2
    //   70: aload 7
    //   72: ifnull +19 -> 91
    //   75: aload 7
    //   77: getfield 213	com/tencent/device/datadef/DeviceInfo:din	J
    //   80: lstore 4
    //   82: aload 7
    //   84: getfield 218	com/tencent/device/datadef/DeviceInfo:productId	I
    //   87: istore_3
    //   88: goto +8 -> 96
    //   91: lconst_0
    //   92: lstore 4
    //   94: iconst_0
    //   95: istore_3
    //   96: iload_2
    //   97: ifne +35 -> 132
    //   100: aload_0
    //   101: getfield 208	com/tencent/mobileqq/activity/aio/rebuild/DeviceMsgChatPie:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   104: getstatic 346	com/tencent/mobileqq/app/BusinessHandlerFactory:DEVICEMSG_HANDLER	Ljava/lang/String;
    //   107: invokevirtual 352	com/tencent/mobileqq/app/QQAppInterface:getBusinessHandler	(Ljava/lang/String;)Lcom/tencent/mobileqq/app/BusinessHandler;
    //   110: checkcast 354	com/tencent/device/msg/data/DeviceMsgHandle
    //   113: astore_1
    //   114: aload_0
    //   115: getfield 208	com/tencent/mobileqq/activity/aio/rebuild/DeviceMsgChatPie:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   118: lload 4
    //   120: ldc_w 387
    //   123: bipush 7
    //   125: iconst_0
    //   126: iload_3
    //   127: invokestatic 223	com/tencent/device/utils/SmartDeviceReport:a	(Lmqq/app/AppRuntime;JLjava/lang/String;III)V
    //   130: iconst_1
    //   131: ireturn
    //   132: aload_0
    //   133: getfield 145	com/tencent/mobileqq/activity/aio/rebuild/DeviceMsgChatPie:jdField_a_of_type_ComTencentMobileqqAppBaseActivity	Lcom/tencent/mobileqq/app/BaseActivity;
    //   136: astore 8
    //   138: aload_0
    //   139: getfield 249	com/tencent/mobileqq/activity/aio/rebuild/DeviceMsgChatPie:jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo	Lcom/tencent/mobileqq/activity/aio/SessionInfo;
    //   142: getfield 253	com/tencent/mobileqq/activity/aio/SessionInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   145: astore 10
    //   147: aconst_null
    //   148: astore 9
    //   150: aconst_null
    //   151: astore 7
    //   153: aload 8
    //   155: aload 10
    //   157: aconst_null
    //   158: ldc_w 389
    //   161: iconst_1
    //   162: invokestatic 393	com/tencent/mobileqq/msf/sdk/SettingCloneUtil:readValue	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)Z
    //   165: istore 6
    //   167: getstatic 263	com/tencent/mobileqq/activity/aio/rebuild/DeviceMsgChatPie:H	Z
    //   170: ifeq +62 -> 232
    //   173: iload 6
    //   175: ifeq +57 -> 232
    //   178: aload_0
    //   179: getfield 208	com/tencent/mobileqq/activity/aio/rebuild/DeviceMsgChatPie:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   182: getstatic 346	com/tencent/mobileqq/app/BusinessHandlerFactory:DEVICEMSG_HANDLER	Ljava/lang/String;
    //   185: invokevirtual 352	com/tencent/mobileqq/app/QQAppInterface:getBusinessHandler	(Ljava/lang/String;)Lcom/tencent/mobileqq/app/BusinessHandler;
    //   188: checkcast 354	com/tencent/device/msg/data/DeviceMsgHandle
    //   191: aload_0
    //   192: getfield 249	com/tencent/mobileqq/activity/aio/rebuild/DeviceMsgChatPie:jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo	Lcom/tencent/mobileqq/activity/aio/SessionInfo;
    //   195: getfield 253	com/tencent/mobileqq/activity/aio/SessionInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   198: ldc_w 394
    //   201: invokestatic 398	com/tencent/mobileqq/app/HardCodeUtil:a	(I)Ljava/lang/String;
    //   204: invokestatic 403	com/tencent/mobileqq/service/message/MessageCache:a	()J
    //   207: iconst_1
    //   208: iconst_0
    //   209: iconst_1
    //   210: invokevirtual 406	com/tencent/device/msg/data/DeviceMsgHandle:a	(Ljava/lang/String;Ljava/lang/String;JZZZ)V
    //   213: aload_0
    //   214: getfield 145	com/tencent/mobileqq/activity/aio/rebuild/DeviceMsgChatPie:jdField_a_of_type_ComTencentMobileqqAppBaseActivity	Lcom/tencent/mobileqq/app/BaseActivity;
    //   217: aload_0
    //   218: getfield 249	com/tencent/mobileqq/activity/aio/rebuild/DeviceMsgChatPie:jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo	Lcom/tencent/mobileqq/activity/aio/SessionInfo;
    //   221: getfield 253	com/tencent/mobileqq/activity/aio/SessionInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   224: aconst_null
    //   225: ldc_w 389
    //   228: iconst_0
    //   229: invokestatic 261	com/tencent/mobileqq/msf/sdk/SettingCloneUtil:writeValue	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V
    //   232: getstatic 411	android/os/Build$VERSION:SDK_INT	I
    //   235: bipush 10
    //   237: if_icmpgt +243 -> 480
    //   240: aload_0
    //   241: getfield 145	com/tencent/mobileqq/activity/aio/rebuild/DeviceMsgChatPie:jdField_a_of_type_ComTencentMobileqqAppBaseActivity	Lcom/tencent/mobileqq/app/BaseActivity;
    //   244: invokevirtual 415	com/tencent/mobileqq/app/BaseActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   247: aload_1
    //   248: invokevirtual 421	android/content/Intent:getData	()Landroid/net/Uri;
    //   251: ldc_w 423
    //   254: invokevirtual 429	android/content/ContentResolver:openAssetFileDescriptor	(Landroid/net/Uri;Ljava/lang/String;)Landroid/content/res/AssetFileDescriptor;
    //   257: astore_1
    //   258: aload_1
    //   259: ifnull +125 -> 384
    //   262: aload_1
    //   263: invokevirtual 435	android/content/res/AssetFileDescriptor:createInputStream	()Ljava/io/FileInputStream;
    //   266: astore_1
    //   267: new 437	java/io/FileOutputStream
    //   270: dup
    //   271: new 439	java/io/File
    //   274: dup
    //   275: aload_0
    //   276: getfield 145	com/tencent/mobileqq/activity/aio/rebuild/DeviceMsgChatPie:jdField_a_of_type_ComTencentMobileqqAppBaseActivity	Lcom/tencent/mobileqq/app/BaseActivity;
    //   279: invokevirtual 443	com/tencent/mobileqq/app/BaseActivity:getApplicationContext	()Landroid/content/Context;
    //   282: invokestatic 449	android/preference/PreferenceManager:getDefaultSharedPreferences	(Landroid/content/Context;)Landroid/content/SharedPreferences;
    //   285: ldc_w 451
    //   288: ldc 55
    //   290: invokeinterface 456 3 0
    //   295: invokespecial 457	java/io/File:<init>	(Ljava/lang/String;)V
    //   298: invokespecial 460	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   301: astore 7
    //   303: sipush 1024
    //   306: newarray byte
    //   308: astore 10
    //   310: aload_1
    //   311: aload 10
    //   313: invokevirtual 466	java/io/FileInputStream:read	([B)I
    //   316: istore_2
    //   317: aload 7
    //   319: astore 8
    //   321: aload_1
    //   322: astore 9
    //   324: iload_2
    //   325: ifle +66 -> 391
    //   328: aload 7
    //   330: aload 10
    //   332: iconst_0
    //   333: iload_2
    //   334: invokevirtual 470	java/io/FileOutputStream:write	([BII)V
    //   337: goto -27 -> 310
    //   340: astore 8
    //   342: aload 7
    //   344: astore 9
    //   346: aload_1
    //   347: astore 7
    //   349: goto +103 -> 452
    //   352: astore 8
    //   354: goto +17 -> 371
    //   357: astore 8
    //   359: aload 9
    //   361: astore 7
    //   363: goto +96 -> 459
    //   366: astore 8
    //   368: aconst_null
    //   369: astore 7
    //   371: aload_1
    //   372: astore 9
    //   374: aload 7
    //   376: astore_1
    //   377: aload 9
    //   379: astore 7
    //   381: goto +44 -> 425
    //   384: aconst_null
    //   385: astore 9
    //   387: aload 9
    //   389: astore 8
    //   391: aload 9
    //   393: ifnull +96 -> 489
    //   396: aload 9
    //   398: invokevirtual 473	java/io/FileInputStream:close	()V
    //   401: goto +88 -> 489
    //   404: aload_1
    //   405: invokevirtual 474	java/io/FileOutputStream:close	()V
    //   408: iconst_0
    //   409: ireturn
    //   410: astore 8
    //   412: aconst_null
    //   413: astore_1
    //   414: aload 9
    //   416: astore 7
    //   418: goto +41 -> 459
    //   421: astore 8
    //   423: aconst_null
    //   424: astore_1
    //   425: aload 8
    //   427: invokevirtual 477	java/lang/Exception:printStackTrace	()V
    //   430: aload 7
    //   432: ifnull +8 -> 440
    //   435: aload 7
    //   437: invokevirtual 473	java/io/FileInputStream:close	()V
    //   440: aload_1
    //   441: ifnull +39 -> 480
    //   444: goto -40 -> 404
    //   447: astore 8
    //   449: aload_1
    //   450: astore 9
    //   452: aload 7
    //   454: astore_1
    //   455: aload 9
    //   457: astore 7
    //   459: aload_1
    //   460: ifnull +7 -> 467
    //   463: aload_1
    //   464: invokevirtual 473	java/io/FileInputStream:close	()V
    //   467: aload 7
    //   469: ifnull +8 -> 477
    //   472: aload 7
    //   474: invokevirtual 474	java/io/FileOutputStream:close	()V
    //   477: aload 8
    //   479: athrow
    //   480: iconst_0
    //   481: ireturn
    //   482: astore_1
    //   483: iconst_0
    //   484: ireturn
    //   485: astore_1
    //   486: goto -9 -> 477
    //   489: aload 8
    //   491: ifnull -11 -> 480
    //   494: aload 8
    //   496: astore_1
    //   497: goto -93 -> 404
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	500	0	this	DeviceMsgChatPie
    //   0	500	1	paramIntent	Intent
    //   64	270	2	m	int
    //   87	40	3	n	int
    //   80	39	4	l1	long
    //   165	9	6	bool	boolean
    //   30	443	7	localObject1	Object
    //   13	307	8	localObject2	Object
    //   340	1	8	localObject3	Object
    //   352	1	8	localException1	Exception
    //   357	1	8	localObject4	Object
    //   366	1	8	localException2	Exception
    //   389	1	8	localObject5	Object
    //   410	1	8	localObject6	Object
    //   421	5	8	localException3	Exception
    //   447	48	8	localObject7	Object
    //   148	308	9	localObject8	Object
    //   145	186	10	localObject9	Object
    // Exception table:
    //   from	to	target	type
    //   303	310	340	finally
    //   310	317	340	finally
    //   328	337	340	finally
    //   303	310	352	java/lang/Exception
    //   310	317	352	java/lang/Exception
    //   328	337	352	java/lang/Exception
    //   267	303	357	finally
    //   267	303	366	java/lang/Exception
    //   240	258	410	finally
    //   262	267	410	finally
    //   240	258	421	java/lang/Exception
    //   262	267	421	java/lang/Exception
    //   425	430	447	finally
    //   396	401	482	java/lang/Exception
    //   404	408	482	java/lang/Exception
    //   435	440	482	java/lang/Exception
    //   463	467	485	java/lang/Exception
    //   472	477	485	java/lang/Exception
  }
  
  public static boolean a(MessageRecord paramMessageRecord)
  {
    Iterator localIterator = jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.entrySet().iterator();
    while (localIterator.hasNext()) {
      if (((MessageRecord)((Map.Entry)localIterator.next()).getValue()).uniseq == paramMessageRecord.uniseq) {
        return true;
      }
    }
    return false;
  }
  
  private void ap()
  {
    if (!this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.isFinishing())
    {
      Object localObject1 = (DeviceMsgHandle)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DEVICEMSG_HANDLER);
      ((DeviceMsgHandle)localObject1).a().a();
      ((DeviceMsgHandle)localObject1).a().a();
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setAllEnable(false);
      if (VersionUtils.e()) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setAllAlpha(0.6F);
      }
      a();
      localObject1 = new IntentFilter();
      ((IntentFilter)localObject1).addAction("SmartDevice_DeviceUnBindRst");
      ((IntentFilter)localObject1).addAction("SmartDevice_ProductFetchRst");
      ((IntentFilter)localObject1).addAction("SmartDevice_receiveVasFlagResult");
      ((IntentFilter)localObject1).addAction("SmartDevice_OnDataPointFileMsgProgress");
      ((IntentFilter)localObject1).addAction("SmartDevice_OnDataPointFileMsgSendRet");
      this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, (IntentFilter)localObject1);
      int m = 1;
      this.E = true;
      Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getIntent().getExtras();
      if (localObject2 != null)
      {
        this.jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(((Bundle)localObject2).getBoolean("bFromLightApp", false));
        this.h = ((Bundle)localObject2).getInt("operType", 0);
        this.i = ((Bundle)localObject2).getInt("jumpTab", 0);
      }
      Object localObject3 = (ImageView)this.c.findViewById(2131369216);
      localObject1 = null;
      if (localObject3 != null)
      {
        ((ImageView)localObject3).setImageResource(2130839562);
        localObject1 = (RelativeLayout)((ImageView)localObject3).getParent();
      }
      localObject3 = (ImageView)this.c.findViewById(2131369211);
      if (localObject3 != null)
      {
        ((ImageView)localObject3).setVisibility(0);
        ((ImageView)localObject3).setImageResource(2130839561);
        ((ImageView)localObject3).setOnClickListener(new DeviceMsgChatPie.2(this));
      }
      long l1 = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      localObject3 = (SmartDeviceProxyMgr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DEVICEPROXYMGR_HANDLER);
      if ((((SmartDeviceProxyMgr)localObject3).c(l1)) && (((SmartDeviceProxyMgr)localObject3).a(l1, 17))) {
        bool = true;
      } else {
        bool = false;
      }
      this.J = bool;
      if (this.J) {
        ((SmartDeviceProxyMgr)localObject3).a(l1, "", "", "", 0, null);
      }
      if (localObject2 != null)
      {
        localObject2 = ((Bundle)localObject2).getStringArrayList("PhotoConst.PHOTO_PATHS");
        if ((localObject2 != null) && (((List)localObject2).size() > 0)) {
          h(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getIntent());
        }
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getIntent().getParcelableArrayListExtra("sFilesSelected");
        if ((localObject2 != null) && (((ArrayList)localObject2).size() > 0)) {
          i(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getIntent());
        }
      }
      boolean bool = BaseApplication.getContext().getSharedPreferences("qsmart_preference", 0).getBoolean("ota_showupdatereddot", true);
      localObject2 = BaseApplication.getContext().getSharedPreferences("lock_red_dot_show", 0);
      if (EquipmentLockImpl.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, BaseApplicationImpl.getApplication()) != 0)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
        localStringBuilder.append("_");
        localStringBuilder.append("lock_red_dot_show");
        localStringBuilder.append("_");
        localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
        if (!((SharedPreferences)localObject2).getBoolean(localStringBuilder.toString(), false)) {}
      }
      else
      {
        m = 0;
      }
      if (((bool) && (((SmartDeviceProxyMgr)localObject3).d(l1))) || (m != 0))
      {
        this.jdField_l_of_type_AndroidWidgetImageView = new ImageView(this.jdField_a_of_type_AndroidContentContext);
        localObject2 = new RelativeLayout.LayoutParams(-2, -2);
        ((RelativeLayout.LayoutParams)localObject2).addRule(6, 2131369216);
        ((RelativeLayout.LayoutParams)localObject2).addRule(7, 2131369216);
        if (localObject1 != null)
        {
          ((RelativeLayout)localObject1).addView(this.jdField_l_of_type_AndroidWidgetImageView, (ViewGroup.LayoutParams)localObject2);
          this.jdField_l_of_type_AndroidWidgetImageView.setImageResource(2130850767);
        }
        this.jdField_l_of_type_AndroidWidgetImageView.setVisibility(0);
      }
    }
  }
  
  private void h(Intent paramIntent)
  {
    this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a();
    Object localObject1 = paramIntent.getExtras().getStringArrayList("PhotoConst.PHOTO_PATHS");
    int i1 = paramIntent.getExtras().getInt("PhotoConst.SEND_SIZE_SPEC", 0);
    Object localObject3 = (SmartDeviceProxyMgr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DEVICEPROXYMGR_HANDLER);
    Object localObject2 = ((SmartDeviceProxyMgr)localObject3).a(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString));
    if (localObject2 != null)
    {
      localObject4 = ((SmartDeviceProxyMgr)localObject3).a(((DeviceInfo)localObject2).productId);
      if ((localObject4 != null) && (((ProductInfo)localObject4).isSupportFuncMsgType(1)))
      {
        m = 1;
        break label103;
      }
    }
    int m = 0;
    label103:
    long l1;
    int n;
    if (localObject2 != null)
    {
      l1 = ((DeviceInfo)localObject2).din;
      n = ((DeviceInfo)localObject2).productId;
    }
    else
    {
      l1 = 0L;
      n = 0;
    }
    if (m == 0)
    {
      m = this.h;
      if ((m != 4) && (m != 3))
      {
        paramIntent = (DeviceMsgHandle)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DEVICEMSG_HANDLER);
        SmartDeviceReport.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, l1, "Usr_AIO_SendMsg", 7, 0, n);
        return;
      }
    }
    Object localObject4 = new ArrayList();
    Iterator localIterator = ((List)localObject1).iterator();
    for (;;)
    {
      String str;
      if (localIterator.hasNext()) {
        str = (String)localIterator.next();
      }
      try
      {
        ((ArrayList)localObject4).add(new FileInfo(str));
      }
      catch (FileNotFoundException localFileNotFoundException) {}
      m = this.h;
      if ((m != 4) && (m != 3))
      {
        if (m == 9)
        {
          if (((ArrayList)localObject4).size() > 0)
          {
            localObject1 = new Intent();
            ((Intent)localObject1).putParcelableArrayListExtra("sFilesSelected", (ArrayList)localObject4);
            ((Intent)localObject1).putExtra("sIsCloudPrinter", true);
            ((Intent)localObject1).putExtra("device_info", (Parcelable)localObject2);
            ((Intent)localObject1).putExtra(AlbumConstants.h, paramIntent.getIntExtra(AlbumConstants.h, -1));
            ((Intent)localObject1).putExtra("filetype", "pic");
            ((Intent)localObject1).putExtra("url", "https://qzs.qq.com/open/mobile/iot_print/html/printOpt.html");
            SmartDevicePluginLoader.a().a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), (Intent)localObject1, "com.tencent.device.activities.LightPinterOptionActivity", 102, null, SmartDevicePluginProxyActivity.class);
          }
        }
        else
        {
          localObject3 = (DeviceMsgHandle)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DEVICEMSG_HANDLER);
          if ((H) && (this.G))
          {
            ((DeviceMsgHandle)localObject3).a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, (List)localObject1);
            SmartDeviceReport.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, l1, "Usr_AIO_SendGroupMsg", 3, 0, n);
            return;
          }
          if (this.J)
          {
            if (((ArrayList)localObject4).size() > 0)
            {
              localObject1 = new Intent();
              ((Intent)localObject1).putParcelableArrayListExtra("sFilesSelected", (ArrayList)localObject4);
              ((Intent)localObject1).putExtra("sIsCloudPrinter", true);
              ((Intent)localObject1).putExtra("device_info", (Parcelable)localObject2);
              ((Intent)localObject1).putExtra(AlbumConstants.h, paramIntent.getIntExtra(AlbumConstants.h, -1));
              ((Intent)localObject1).putExtra("filetype", "pic");
              ((Intent)localObject1).putExtra("url", "https://qzs.qq.com/open/mobile/iot_print/html/printOpt.html");
              SmartDevicePluginLoader.a().a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), (Intent)localObject1, "com.tencent.device.activities.LightPinterOptionActivity", 102, null, SmartDevicePluginProxyActivity.class);
            }
          }
          else
          {
            if (i1 == 2)
            {
              b((List)localObject1);
              return;
            }
            c((List)localObject1);
          }
        }
      }
      else
      {
        paramIntent = (SmartDeviceProxyMgr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DEVICEPROXYMGR_HANDLER);
        paramIntent = ((List)localObject1).iterator();
        while (paramIntent.hasNext()) {
          ((SmartDeviceProxyMgr)localObject3).a((String)paramIntent.next(), 2154);
        }
        if (QLog.isColorLevel())
        {
          paramIntent = this.jdField_b_of_type_JavaLangString;
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("prcessExtraData: send:");
          ((StringBuilder)localObject2).append(((List)localObject1).size());
          QLog.d(paramIntent, 2, ((StringBuilder)localObject2).toString());
        }
        q();
      }
      return;
    }
  }
  
  private void i(Intent paramIntent)
  {
    if (!((DeviceFileHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DEVICEFILE_HANDLER)).a(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)))
    {
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, HardCodeUtil.a(2131703337), 2000).a();
      return;
    }
    Object localObject = paramIntent.getParcelableArrayListExtra("sFilesSelected");
    if ((localObject != null) && (((ArrayList)localObject).size() > 0))
    {
      ArrayList localArrayList = new ArrayList();
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        localArrayList.add(((FileInfo)((Iterator)localObject).next()).c());
      }
      paramIntent = paramIntent.getStringExtra("sPrintParam");
      if (!NetworkUtil.isWifiEnabled(this.jdField_a_of_type_AndroidContentContext))
      {
        paramIntent = DialogUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 230, this.jdField_a_of_type_AndroidContentContext.getString(2131697613), this.jdField_a_of_type_AndroidContentContext.getString(2131697403), HardCodeUtil.a(2131703352), HardCodeUtil.a(2131703353), new DeviceMsgChatPie.5(this, localArrayList, paramIntent), new DeviceMsgChatPie.6(this));
        if (!paramIntent.isShowing()) {
          paramIntent.show();
        }
      }
      else
      {
        a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, localArrayList, paramIntent);
      }
    }
  }
  
  private void j(Intent paramIntent)
  {
    paramIntent = paramIntent.getExtras();
    if (paramIntent != null)
    {
      int m = paramIntent.getInt("cookie", 0);
      int n = paramIntent.getInt("err_code", 1);
      if ((m != 0) && (jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(Integer.valueOf(m))))
      {
        paramIntent = (MessageRecord)jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(m));
        MessageForDevLittleVideo localMessageForDevLittleVideo;
        if (n == 0)
        {
          if ((paramIntent instanceof MessageForDevPtt))
          {
            paramIntent = (MessageForDevPtt)paramIntent;
            paramIntent.extraflag = 32770;
            paramIntent.fileSize = FileManagerUtil.a(paramIntent.url);
            paramIntent.extStr = "device_groupchat";
            paramIntent.serial();
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(paramIntent.frienduin, paramIntent.istroop, paramIntent.uniseq, paramIntent.msgData);
            ((DeviceMsgHandle)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DEVICEMSG_HANDLER)).a().a(paramIntent, Boolean.valueOf(true));
          }
          else if ((paramIntent instanceof MessageForDeviceFile))
          {
            ((DeviceMsgHandle)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DEVICEMSG_HANDLER)).a().a(paramIntent, Boolean.valueOf(true));
          }
          else if ((paramIntent instanceof MessageForDevLittleVideo))
          {
            localMessageForDevLittleVideo = (MessageForDevLittleVideo)paramIntent;
            localMessageForDevLittleVideo.videoFileStatus = 1003;
            localMessageForDevLittleVideo.videoFileProgress = 100;
            localMessageForDevLittleVideo.serial();
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(localMessageForDevLittleVideo.frienduin, localMessageForDevLittleVideo.istroop, localMessageForDevLittleVideo.uniseq, localMessageForDevLittleVideo.msgData);
            ((DeviceMsgHandle)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DEVICEMSG_HANDLER)).a().a(paramIntent, Boolean.valueOf(true));
          }
        }
        else if ((paramIntent instanceof MessageForDevPtt))
        {
          paramIntent = (MessageForDevPtt)paramIntent;
          paramIntent.extraflag = 32768;
          paramIntent.extStr = "device_groupchat";
          paramIntent.serial();
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(paramIntent.frienduin, paramIntent.istroop, paramIntent.uniseq, paramIntent.msgData);
          ((DeviceMsgHandle)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DEVICEMSG_HANDLER)).a().a(paramIntent, Boolean.valueOf(false));
        }
        else if ((paramIntent instanceof MessageForDeviceFile))
        {
          paramIntent = (MessageForDeviceFile)paramIntent;
          ((DeviceMsgHandle)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DEVICEMSG_HANDLER)).a().a(paramIntent, Boolean.valueOf(false));
        }
        else if ((paramIntent instanceof MessageForDevLittleVideo))
        {
          localMessageForDevLittleVideo = (MessageForDevLittleVideo)paramIntent;
          localMessageForDevLittleVideo.videoFileStatus = 1005;
          localMessageForDevLittleVideo.videoFileProgress = 0;
          localMessageForDevLittleVideo.serial();
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(localMessageForDevLittleVideo.frienduin, localMessageForDevLittleVideo.istroop, localMessageForDevLittleVideo.uniseq, localMessageForDevLittleVideo.msgData);
          ((DeviceMsgHandle)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DEVICEMSG_HANDLER)).a().a(paramIntent, Boolean.valueOf(false));
        }
        jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(Integer.valueOf(m));
      }
    }
  }
  
  private void k(Intent paramIntent)
  {
    paramIntent = paramIntent.getExtras();
    if (paramIntent != null)
    {
      int m = paramIntent.getInt("cookie", 0);
      float f = paramIntent.getFloat("percent", 0.0F);
      if ((m != 0) && (jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(Integer.valueOf(m))))
      {
        paramIntent = (MessageRecord)jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(m));
        if ((paramIntent instanceof MessageForDeviceFile))
        {
          paramIntent = (MessageForDeviceFile)paramIntent;
          paramIntent.nFileStatus = 3;
          paramIntent.progress = f;
          paramIntent.serial();
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(paramIntent.frienduin, paramIntent.istroop, paramIntent.uniseq, paramIntent.msgData);
          return;
        }
        if ((paramIntent instanceof MessageForDevLittleVideo))
        {
          paramIntent = (MessageForDevLittleVideo)paramIntent;
          paramIntent.videoFileStatus = 1002;
          paramIntent.videoFileProgress = ((int)(100.0F * f));
          paramIntent.serial();
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(paramIntent.frienduin, paramIntent.istroop, paramIntent.uniseq, paramIntent.msgData);
          ((DeviceMsgHandle)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DEVICEMSG_HANDLER)).a().a(paramIntent, f);
        }
      }
    }
  }
  
  private void l(int paramInt)
  {
    this.jdField_d_of_type_JavaLangString = PreferenceManager.getDefaultSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getApplicationContext()).getString("device_video_path", "");
    PreferenceManager.getDefaultSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getApplicationContext()).edit().remove("device_video_path").commit();
    if (paramInt == -1)
    {
      if (!TextUtils.isEmpty(this.jdField_d_of_type_JavaLangString))
      {
        QQCustomDialog localQQCustomDialog = DialogUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 230);
        localQQCustomDialog.setNegativeButton(2131690728, new DeviceMsgChatPie.3(this));
        localQQCustomDialog.setPositiveButton(2131694583, new DeviceMsgChatPie.4(this));
        localQQCustomDialog.setTitle(HardCodeUtil.a(2131703344));
        Object localObject = new File(this.jdField_d_of_type_JavaLangString);
        localObject = ShortVideoUtils.stringForFileSize(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, ((File)localObject).length());
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(HardCodeUtil.a(2131703350));
        localStringBuilder.append((String)localObject);
        localStringBuilder.append(HardCodeUtil.a(2131703342));
        localQQCustomDialog.setMessage(localStringBuilder.toString());
        localQQCustomDialog.show();
      }
    }
    else
    {
      if (!TextUtils.isEmpty(this.jdField_d_of_type_JavaLangString)) {
        FileUtils.deleteFile(this.jdField_d_of_type_JavaLangString);
      }
      this.jdField_d_of_type_JavaLangString = "";
    }
  }
  
  protected AIOContext a()
  {
    return new DeviceMsgAIOContext();
  }
  
  protected AIOInput a()
  {
    return new AIOInputBuilder().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext).a(new DeviceMessageSender(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext)).a();
  }
  
  protected MsgList a()
  {
    return new MsgListBuilder(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext).a(new Scroller()).a(new ListUI(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext)).a(new UnreadTask(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext)).a(new DeviceMsgListRefresher(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext)).a();
  }
  
  public RecordParams.RecorderParam a()
  {
    Object localObject = ((SmartDeviceProxyMgr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DEVICEPROXYMGR_HANDLER)).a(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString));
    localObject = new LightAppUtil().a((DeviceInfo)localObject);
    if ((localObject != null) && (((LightAppSettingInfo)localObject).a.get(Integer.valueOf(11007)) != null)) {
      try
      {
        localObject = (String)((LightAppSettingInfo)localObject).a.get(Integer.valueOf(11007));
        boolean bool = TextUtils.isEmpty((CharSequence)localObject);
        if (bool) {
          localObject = "";
        }
        if (new JSONObject(((String)localObject).replace("&quot;", "\"")).optString("Audio", "").toLowerCase().equals("slk"))
        {
          localObject = new RecordParams.RecorderParam(RecordParams.b, 16000, 1);
          return localObject;
        }
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel())
        {
          str = this.jdField_b_of_type_JavaLangString;
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("getString from json Exception error:");
          localStringBuilder.append(localException.getMessage());
          QLog.d(str, 2, localStringBuilder.toString());
        }
      }
      catch (JSONException localJSONException)
      {
        String str;
        StringBuilder localStringBuilder;
        if (QLog.isColorLevel())
        {
          str = this.jdField_b_of_type_JavaLangString;
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("getString from json JSONException error:");
          localStringBuilder.append(localJSONException.getMessage());
          QLog.d(str, 2, localStringBuilder.toString());
        }
      }
    }
    return new RecordParams.RecorderParam(RecordParams.jdField_a_of_type_Int, 0, 0);
  }
  
  public void a()
  {
    int m = (int)(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDisplayMetrics().density * 6.0F);
    Object localObject2 = (FrameLayout.LayoutParams)this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getLayoutParams();
    ((FrameLayout.LayoutParams)localObject2).leftMargin = m;
    this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setLayoutParams((ViewGroup.LayoutParams)localObject2);
    Object localObject1 = (SmartDeviceProxyMgr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DEVICEPROXYMGR_HANDLER);
    DeviceInfo localDeviceInfo = ((SmartDeviceProxyMgr)localObject1).a(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString));
    ProductInfo localProductInfo;
    if (localDeviceInfo != null)
    {
      localProductInfo = ((SmartDeviceProxyMgr)localObject1).a(localDeviceInfo.productId);
      if ((localProductInfo != null) && (localProductInfo.isSupportMainMsgType(4)))
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setAllEnable(true);
        if (VersionUtils.e()) {
          this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setAllAlpha(1.0F);
        }
        ((FrameLayout.LayoutParams)localObject2).leftMargin = 0;
        this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      }
      this.g = localDeviceInfo.productId;
    }
    else
    {
      localProductInfo = null;
    }
    H = ((SmartDeviceProxyMgr)localObject1).a(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)).booleanValue();
    boolean bool = SettingCloneUtil.readValue(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, null, "devicemsg_showsupporttips_first", true);
    a(localDeviceInfo, localProductInfo, SettingCloneUtil.readValue(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, null, "devicemsg_openchat_firsttrue", false));
    a(localDeviceInfo);
    if ((localProductInfo != null) && (bool))
    {
      if ((localProductInfo.supportMainMsgType & 0xF) == 0)
      {
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131691569);
      }
      else
      {
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131691591);
        localObject1 = localObject2;
        if (localProductInfo.isSupportMainMsgType(1))
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append((String)localObject2);
          ((StringBuilder)localObject1).append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131691592));
          ((StringBuilder)localObject1).append("、");
          localObject1 = ((StringBuilder)localObject1).toString();
        }
        localObject2 = localObject1;
        if (localProductInfo.isSupportMainMsgType(2))
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append((String)localObject1);
          ((StringBuilder)localObject2).append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131691522));
          ((StringBuilder)localObject2).append("、");
          localObject2 = ((StringBuilder)localObject2).toString();
        }
        localObject1 = localObject2;
        if (localProductInfo.isSupportMainMsgType(8))
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append((String)localObject2);
          ((StringBuilder)localObject1).append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131691528));
          ((StringBuilder)localObject1).append("、");
          localObject1 = ((StringBuilder)localObject1).toString();
        }
        localObject2 = localObject1;
        if (localProductInfo.isSupportFuncMsgType(1))
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append((String)localObject1);
          ((StringBuilder)localObject2).append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131691571));
          ((StringBuilder)localObject2).append("、");
          localObject2 = ((StringBuilder)localObject2).toString();
        }
        localObject1 = localObject2;
        if (localProductInfo.isSupportFuncMsgType(2))
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append((String)localObject2);
          ((StringBuilder)localObject1).append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131691596));
          ((StringBuilder)localObject1).append("、");
          localObject1 = ((StringBuilder)localObject1).toString();
        }
        localObject2 = localObject1;
        if (((String)localObject1).endsWith("、")) {
          localObject2 = ((String)localObject1).substring(0, ((String)localObject1).length() - 1);
        }
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append((String)localObject2);
        ((StringBuilder)localObject1).append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131691590));
        localObject1 = ((StringBuilder)localObject1).toString();
      }
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        localObject1 = (DeviceMsgHandle)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DEVICEMSG_HANDLER);
        if ((this.F) && (localDeviceInfo.isAdmin == 1) && (this.G) && (!H))
        {
          localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131691593);
          ((DeviceMsgHandle)localObject1).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, (String)localObject2, MessageCache.a(), true, false, true);
        }
        SettingCloneUtil.writeValue(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, null, "devicemsg_showsupporttips_first", false);
      }
    }
    if (QLog.isColorLevel()) {
      if (localProductInfo != null)
      {
        localObject1 = this.jdField_b_of_type_JavaLangString;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("support msg type maintype");
        ((StringBuilder)localObject2).append(localProductInfo.supportMainMsgType);
        ((StringBuilder)localObject2).append(", FuncMsgType:");
        ((StringBuilder)localObject2).append(localProductInfo.supportFuncMsgType);
        QLog.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
      }
      else
      {
        QLog.d(this.jdField_b_of_type_JavaLangString, 2, "product is null");
      }
    }
    ao();
  }
  
  public void a(int paramInt)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onPanelIconClick panelID=");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append("currentID=");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a());
      QLog.d("XPanel", 2, ((StringBuilder)localObject).toString());
    }
    if (paramInt == this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a())
    {
      this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a();
      return;
    }
    if (paramInt != 12)
    {
      if (paramInt != 13)
      {
        if (paramInt == 16)
        {
          AIOPanelUtiles.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "0X800407C", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
          localObject = new FileManagerReporter.FileAssistantReportData();
          ((FileManagerReporter.FileAssistantReportData)localObject).jdField_b_of_type_JavaLangString = "send_file";
          ((FileManagerReporter.FileAssistantReportData)localObject).jdField_a_of_type_Int = 1;
          FileManagerReporter.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), (FileManagerReporter.FileAssistantReportData)localObject);
          localObject = (SmartDeviceProxyMgr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DEVICEPROXYMGR_HANDLER);
          long l1 = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
          if ((localObject != null) && (((SmartDeviceProxyMgr)localObject).c(l1)) && (((SmartDeviceProxyMgr)localObject).a(l1, 17))) {
            PlusPanelUtils.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, a(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
          } else {
            PlusPanelUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, a(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
          }
        }
      }
      else
      {
        this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a();
        ((PtvPanelProviderHelper)a(131)).a(false);
      }
    }
    else
    {
      this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a();
      PlusPanelUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, a(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, 2, true);
    }
    super.a(paramInt);
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.a(paramInt1, paramInt2, paramIntent);
    Object localObject;
    if ((84 == paramInt1) && (paramIntent != null))
    {
      localObject = ((SmartDeviceProxyMgr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DEVICEPROXYMGR_HANDLER)).a(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString));
      ArrayList localArrayList = paramIntent.getParcelableArrayListExtra("sFilesSelected");
      Intent localIntent = new Intent();
      localIntent.putParcelableArrayListExtra("sFilesSelected", localArrayList);
      localIntent.putExtra("sIsCloudPrinter", true);
      localIntent.putExtra("device_info", (Parcelable)localObject);
      localIntent.putExtra("url", "https://qzs.qq.com/open/mobile/iot_print/html/printOpt.html");
      localIntent.putExtra("filetype", "file");
      SmartDevicePluginLoader.a().a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), localIntent, "com.tencent.device.activities.LightPinterOptionActivity", 102, null, SmartDevicePluginProxyActivity.class);
    }
    else if (paramInt1 == 102)
    {
      if ((paramInt2 == -1) && (paramIntent != null)) {
        i(paramIntent);
      }
    }
    else if ((81 != paramInt1) && (83 != paramInt1))
    {
      if (paramInt1 == jdField_j_of_type_Int)
      {
        if (paramInt2 == k) {
          q();
        } else if (paramInt2 == jdField_l_of_type_Int) {
          this.K = true;
        }
        localObject = SmartDeviceUtil.a(((SmartDeviceProxyMgr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DEVICEPROXYMGR_HANDLER)).a(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)));
        if (localObject != null) {
          this.e.setText((CharSequence)localObject);
        }
      }
    }
    else if (a(paramIntent))
    {
      return;
    }
    if (paramInt1 != 81)
    {
      if (paramInt1 == 83) {
        l(paramInt2);
      }
    }
    else if ((paramInt2 == -1) && (paramIntent != null))
    {
      paramIntent = paramIntent.getParcelableArrayListExtra("sendInfo");
      if ((paramIntent != null) && (paramIntent.size() > 0))
      {
        this.jdField_d_of_type_JavaLangString = ((SendInfo)paramIntent.get(0)).a();
        DevVideoMsgProcessor.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_d_of_type_JavaLangString);
      }
    }
    if ((this.h == 4) && (paramInt2 == -1) && (paramInt1 == 1)) {
      this.I = false;
    }
  }
  
  public boolean a(boolean paramBoolean)
  {
    this.v = false;
    this.B = false;
    if (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getIntent().getExtras() == null)
    {
      super.q();
      return true;
    }
    super.a(paramBoolean);
    if (Build.VERSION.SDK_INT >= 23)
    {
      if (!PermissionUtils.isStorePermissionEnable(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity))
      {
        CheckPermission.requestStorePermission(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, new DeviceMsgChatPie.1(this));
        return true;
      }
      ap();
      return true;
    }
    ap();
    return true;
  }
  
  void ao()
  {
    int m = (int)(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDisplayMetrics().density * 6.0F);
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getLayoutParams();
    Object localObject = (SmartDeviceProxyMgr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DEVICEPROXYMGR_HANDLER);
    DeviceInfo localDeviceInfo = ((SmartDeviceProxyMgr)localObject).a(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString));
    if (localDeviceInfo != null) {
      localObject = ((SmartDeviceProxyMgr)localObject).a(localDeviceInfo.productId);
    } else {
      localObject = null;
    }
    if (localObject != null)
    {
      if ((((ProductInfo)localObject).supportMainMsgType & 0xF) == 0)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.setVisibility(8);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setVisibility(8);
      }
      else
      {
        a(m, localLayoutParams, (ProductInfo)localObject);
      }
      if (!((ProductInfo)localObject).isSupportMainMsgType(1)) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.setVisibility(8);
      }
    }
    else
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.setVisibility(8);
    }
  }
  
  public void b(List<String> paramList)
  {
    DeviceMsgHandle localDeviceMsgHandle = (DeviceMsgHandle)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DEVICEMSG_HANDLER);
    if ((H) && (this.G))
    {
      localDeviceMsgHandle.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, paramList);
      paramList = ((SmartDeviceProxyMgr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DEVICEPROXYMGR_HANDLER)).a(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString));
      SmartDeviceReport.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramList.din, "Usr_AIO_SendGroupMsg", 3, 0, paramList.productId);
      return;
    }
    localDeviceMsgHandle.a().a(DeviceMsgHandle.jdField_d_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, paramList);
  }
  
  protected boolean b()
  {
    Object localObject = (SmartDeviceProxyMgr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DEVICEPROXYMGR_HANDLER);
    DeviceInfo localDeviceInfo = ((SmartDeviceProxyMgr)localObject).a(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString));
    if (localDeviceInfo != null)
    {
      localObject = ((SmartDeviceProxyMgr)localObject).a(localDeviceInfo.productId);
      if ((localObject != null) && ((((ProductInfo)localObject).supportMainMsgType & 0xF) == 6)) {
        return true;
      }
    }
    return false;
  }
  
  protected void c()
  {
    this.jdField_b_of_type_JavaLangString = "DeviceMsgChatPie";
  }
  
  public void c(List<String> paramList)
  {
    Intent localIntent = new Intent();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      String str = (String)paramList.next();
      if ((str != null) && (!"".equals(str)))
      {
        localIntent.putExtra("PhotoConst.PHOTO_SEND_PATH", str);
        localIntent.putExtra("PhotoConst.SEND_BUSINESS_TYPE", 1007);
        localIntent.putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
        localIntent.putExtra("uintype", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
        localIntent.putExtra("troop_uin", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_JavaLangString);
        localIntent.putExtra("PhotoConst.SEND_SIZE_SPEC", 0);
        localIntent.putExtra("PhotoConst.HANDLE_DEST_RESULT", true);
        PicReq localPicReq1 = ((IPicBus)QRoute.api(IPicBus.class)).createPicReq(2, 1007);
        PicReq localPicReq2 = ((IPicBus)QRoute.api(IPicBus.class)).createPicReq(1, 1007);
        localPicReq2.a(localPicReq1.jdField_a_of_type_JavaLangString);
        if (localPicReq2.a(((IPicBus)QRoute.api(IPicBus.class)).createCompressInfo(1007, localIntent)))
        {
          localPicReq2.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoICompressionCallBack = new DeviceMsgChatPie.CompressCallBack(this);
          ((IPicBus)QRoute.api(IPicBus.class)).launch(localPicReq2);
        }
        else
        {
          d(str);
        }
      }
    }
  }
  
  protected boolean c()
  {
    Object localObject = (SmartDeviceProxyMgr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DEVICEPROXYMGR_HANDLER);
    DeviceInfo localDeviceInfo = ((SmartDeviceProxyMgr)localObject).a(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString));
    if (localDeviceInfo != null)
    {
      localObject = ((SmartDeviceProxyMgr)localObject).a(localDeviceInfo.productId);
      if (localObject != null)
      {
        if ((((ProductInfo)localObject).supportMainMsgType & 0xF) == 1) {
          return true;
        }
        if (((((ProductInfo)localObject).supportMainMsgType & 0xF) == 5) && (((ProductInfo)localObject).supportFuncMsgType == 1)) {
          return true;
        }
        if (((((ProductInfo)localObject).supportMainMsgType & 0xF) == 5) && (((ProductInfo)localObject).supportFuncMsgType == 2)) {
          return true;
        }
        if (((((ProductInfo)localObject).supportMainMsgType & 0xF) == 5) && (((ProductInfo)localObject).supportFuncMsgType == 3)) {
          return true;
        }
        if ((((ProductInfo)localObject).supportMainMsgType & 0xF) == 9) {
          return true;
        }
      }
    }
    return false;
  }
  
  public void d(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramString);
    b(localArrayList);
  }
  
  protected void f(Intent paramIntent)
  {
    int m = paramIntent.getIntExtra("forward_type", 2147483647);
    if (m == 2147483647) {
      return;
    }
    paramIntent.removeExtra("forward_type");
    if (m == -1)
    {
      String str = paramIntent.getStringExtra("forward_text");
      DeviceMsgHandle localDeviceMsgHandle = (DeviceMsgHandle)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DEVICEMSG_HANDLER);
      if (!TextUtils.isEmpty(str))
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString = paramIntent.getStringExtra("uin");
        this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int = paramIntent.getIntExtra("uintype", -1);
        paramIntent = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        SessionInfo localSessionInfo = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
        boolean bool;
        if ((H) && (this.G)) {
          bool = true;
        } else {
          bool = false;
        }
        localDeviceMsgHandle.a(paramIntent, localSessionInfo, str, bool);
      }
    }
    else
    {
      super.f(paramIntent);
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int m = paramMessage.what;
    if (m != 19)
    {
      if (m == 20) {
        this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(20);
      }
    }
    else
    {
      this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(20);
      this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(20, 10000L);
    }
    return super.handleMessage(paramMessage);
  }
  
  protected void i()
  {
    super.i();
    int m = this.h;
    Object localObject;
    StringBuilder localStringBuilder;
    if ((m != 1) && (m != 3) && (m != 9))
    {
      if ((m != 2) && (m != 4))
      {
        if (m == 5) {
          return;
        }
        if (m == 6)
        {
          AIOPanelUtiles.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
          return;
        }
        if (m == 7)
        {
          localObject = new FileManagerReporter.FileAssistantReportData();
          ((FileManagerReporter.FileAssistantReportData)localObject).jdField_b_of_type_JavaLangString = "send_file";
          ((FileManagerReporter.FileAssistantReportData)localObject).jdField_a_of_type_Int = 1;
          FileManagerReporter.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), (FileManagerReporter.FileAssistantReportData)localObject);
          PlusPanelUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, a(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.i, false);
          return;
        }
        if (m == 8)
        {
          this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a(2);
          return;
        }
        if (m == 10)
        {
          localObject = new FileManagerReporter.FileAssistantReportData();
          ((FileManagerReporter.FileAssistantReportData)localObject).jdField_b_of_type_JavaLangString = "send_file";
          ((FileManagerReporter.FileAssistantReportData)localObject).jdField_a_of_type_Int = 1;
          FileManagerReporter.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), (FileManagerReporter.FileAssistantReportData)localObject);
          PlusPanelUtils.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, a(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
          return;
        }
        if (m == 11) {
          a(13);
        }
      }
      else
      {
        if ((PanelIconLinearLayout)this.c.findViewById(2131372306) != null)
        {
          a(5);
          return;
        }
        if (QLog.isColorLevel())
        {
          localObject = this.jdField_b_of_type_JavaLangString;
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("DeviceMsgChatPie, OPER_TYPE_SEND_PICTURE[");
          localStringBuilder.append(this.h);
          localStringBuilder.append("], find view panelicons failed!!");
          QLog.d((String)localObject, 2, localStringBuilder.toString());
        }
      }
    }
    else
    {
      if ((PanelIconLinearLayout)this.c.findViewById(2131372306) != null)
      {
        a(4);
        return;
      }
      if (QLog.isColorLevel())
      {
        localObject = this.jdField_b_of_type_JavaLangString;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("DeviceMsgChatPie, OPER_TYPE_SEND_PICTURE[");
        localStringBuilder.append(this.h);
        localStringBuilder.append("], find view panelicons failed!!");
        QLog.d((String)localObject, 2, localStringBuilder.toString());
      }
    }
  }
  
  protected void j()
  {
    if (this.jdField_d_of_type_AndroidWidgetImageView != null)
    {
      if (AIOTopRightButtonConfig.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()))
      {
        this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(0);
        return;
      }
      this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
    }
  }
  
  public void k()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString.equals(AppConstants.SMARTDEVICE_SEARCH_UIN))
    {
      localObject1 = new Intent();
      ((Intent)localObject1).putExtra("url", "https://qzs.qq.com/open/mobile/iot_menu/aioSet.html");
      SmartDevicePluginLoader.a().a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), (Intent)localObject1, "com.tencent.device.activities.DeviceSquareSettingActivity", jdField_j_of_type_Int, null, SmartDevicePluginProxyActivity.class);
      return;
    }
    Object localObject2 = ((SmartDeviceProxyMgr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DEVICEPROXYMGR_HANDLER)).a(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString));
    int m;
    long l1;
    if (localObject2 != null)
    {
      m = ((DeviceInfo)localObject2).productId;
      l1 = ((DeviceInfo)localObject2).din;
    }
    else
    {
      l1 = 0L;
      m = 0;
    }
    SmartDeviceReport.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, l1, "Usr_AIO_Menu", 1, 0, m);
    if (localObject2 == null) {
      return;
    }
    Object localObject1 = new Intent();
    ((Intent)localObject1).putExtra("device_info", (Parcelable)localObject2);
    ((Intent)localObject1).putExtra("isPublicDevice", true);
    localObject2 = new LightAppUtil(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity).a((DeviceInfo)localObject2);
    if (localObject2 != null) {
      ((Intent)localObject1).putExtra("lightapp_setting", (Parcelable)localObject2);
    }
    SmartDevicePluginLoader.a().a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), (Intent)localObject1, "com.tencent.device.activities.DeviceSettingActivity", jdField_j_of_type_Int, null, SmartDevicePluginProxyActivity.class);
    localObject1 = this.jdField_l_of_type_AndroidWidgetImageView;
    if (localObject1 != null) {
      ((ImageView)localObject1).setVisibility(8);
    }
    localObject1 = BaseApplication.getContext().getSharedPreferences("lock_red_dot_show", 0).edit();
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    ((StringBuilder)localObject2).append("_");
    ((StringBuilder)localObject2).append("lock_red_dot_show");
    ((StringBuilder)localObject2).append("_");
    ((StringBuilder)localObject2).append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    ((SharedPreferences.Editor)localObject1).putBoolean(((StringBuilder)localObject2).toString(), true).commit();
    BaseApplication.getContext().getSharedPreferences("qsmart_preference", 0).edit().putBoolean("ota_showupdatereddot", false).commit();
  }
  
  protected void m()
  {
    if (this.jdField_a_of_type_AndroidWidgetImageView != null)
    {
      a(this.jdField_a_of_type_AndroidWidgetImageView, 2130839562, 2130839562);
      this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getText(2131696425));
    }
  }
  
  public void m(boolean paramBoolean)
  {
    this.D = paramBoolean;
  }
  
  public void p()
  {
    if (this.B)
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_b_of_type_JavaLangString, 2, "hasDestory = true return");
      }
      return;
    }
    super.p();
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      if (QLog.isColorLevel())
      {
        String str = this.jdField_b_of_type_JavaLangString;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(" already unregisterReceiver");
        localStringBuilder.append(localIllegalArgumentException);
        QLog.w(str, 2, localStringBuilder.toString());
      }
    }
  }
  
  public boolean t()
  {
    return this.D;
  }
  
  public boolean u()
  {
    Object localObject = (SmartDeviceProxyMgr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DEVICEPROXYMGR_HANDLER);
    DeviceInfo localDeviceInfo = ((SmartDeviceProxyMgr)localObject).a(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString));
    if (localDeviceInfo != null)
    {
      localObject = ((SmartDeviceProxyMgr)localObject).a(localDeviceInfo.productId);
      if ((localObject != null) && (((ProductInfo)localObject).isSupportFuncMsgType(2))) {
        return true;
      }
    }
    return false;
  }
  
  public boolean v()
  {
    Object localObject = (SmartDeviceProxyMgr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DEVICEPROXYMGR_HANDLER);
    DeviceInfo localDeviceInfo = ((SmartDeviceProxyMgr)localObject).a(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString));
    if (localDeviceInfo != null)
    {
      localObject = ((SmartDeviceProxyMgr)localObject).a(localDeviceInfo.productId);
      if ((localObject != null) && (((ProductInfo)localObject).isSupportMainMsgType(8))) {
        return true;
      }
    }
    return false;
  }
  
  public boolean w()
  {
    if (v()) {
      return true;
    }
    long l1 = 0L;
    try
    {
      long l2 = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      l1 = l2;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    SmartDeviceProxyMgr localSmartDeviceProxyMgr = (SmartDeviceProxyMgr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DEVICEPROXYMGR_HANDLER);
    return (localSmartDeviceProxyMgr != null) && (localSmartDeviceProxyMgr.c(l1)) && (localSmartDeviceProxyMgr.a(l1, 17));
  }
  
  public boolean x()
  {
    Object localObject = (SmartDeviceProxyMgr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DEVICEPROXYMGR_HANDLER);
    DeviceInfo localDeviceInfo = ((SmartDeviceProxyMgr)localObject).a(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString));
    if (localDeviceInfo != null)
    {
      localObject = ((SmartDeviceProxyMgr)localObject).a(localDeviceInfo.productId);
      if ((localObject != null) && (((ProductInfo)localObject).isSupportFuncMsgType(1))) {
        return true;
      }
    }
    return false;
  }
  
  public void y()
  {
    super.y();
    int m = this.h;
    if ((m == 3) || (m == 4))
    {
      if (!this.I)
      {
        this.I = true;
        return;
      }
      super.q();
    }
  }
  
  public boolean y()
  {
    Object localObject = (SmartDeviceProxyMgr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DEVICEPROXYMGR_HANDLER);
    DeviceInfo localDeviceInfo = ((SmartDeviceProxyMgr)localObject).a(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString));
    if (localDeviceInfo != null)
    {
      localObject = ((SmartDeviceProxyMgr)localObject).a(localDeviceInfo.productId);
      if ((localObject != null) && (((ProductInfo)localObject).isSupportMainMsgType(2))) {
        return true;
      }
    }
    return false;
  }
  
  public void z()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioHelperHelperProvider.a(6);
    AIOUtils.a(false);
    this.f = false;
    this.jdField_j_of_type_Boolean = false;
    this.m = false;
    this.A = true;
    this.B = false;
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTipsTipsController.a();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager.a();
    }
    if (this.jdField_a_of_type_ComTencentWidgetXPanelContainer != null)
    {
      this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a();
      this.jdField_a_of_type_ComTencentWidgetXPanelContainer.c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.DeviceMsgChatPie
 * JD-Core Version:    0.7.0.1
 */