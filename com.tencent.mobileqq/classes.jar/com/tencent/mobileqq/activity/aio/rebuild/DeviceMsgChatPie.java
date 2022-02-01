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
import android.support.v4.app.FragmentActivity;
import android.text.Editable;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
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
import com.tencent.device.file.DevAudioMsgProcessor;
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
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.InputLinearLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.core.UnreadTask;
import com.tencent.mobileqq.activity.aio.core.msglist.MsgList;
import com.tencent.mobileqq.activity.aio.core.msglist.MsgListBuilder;
import com.tencent.mobileqq.activity.aio.coreui.msglist.ListUI;
import com.tencent.mobileqq.activity.aio.coreui.msglist.Scroller;
import com.tencent.mobileqq.activity.aio.helper.HelperProvider;
import com.tencent.mobileqq.activity.aio.panel.AIOPanelUtiles;
import com.tencent.mobileqq.activity.aio.panel.PanelIconLinearLayout;
import com.tencent.mobileqq.activity.aio.rebuild.msglist.DeviceMsgListRefresher;
import com.tencent.mobileqq.activity.aio.tips.TipsManager;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.utils.PermissionUtils;
import com.tencent.mobileqq.data.MessageForDeviceFile;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.emosm.AIOEmoticonUIHelper;
import com.tencent.mobileqq.equipmentlock.EquipmentLockImpl;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter.FileAssistantReportData;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.pic.PicBusiManager;
import com.tencent.mobileqq.pic.PicPreDownloadUtils;
import com.tencent.mobileqq.pic.PicReq;
import com.tencent.mobileqq.ptt.PttBuffer;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.startup.step.CheckPermission;
import com.tencent.mobileqq.streamtransfile.StreamDataManager;
import com.tencent.mobileqq.utils.AlbumConstants;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.QQRecorder;
import com.tencent.mobileqq.utils.RecordParams;
import com.tencent.mobileqq.utils.RecordParams.RecorderParam;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.voicechange.VoiceTuneUtil;
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
  public static boolean R = false;
  public static ConcurrentHashMap<Integer, MessageRecord> a;
  static int n;
  static int o;
  static int p = 11;
  boolean N = false;
  public volatile boolean O = false;
  boolean P = false;
  boolean Q = false;
  boolean S = false;
  public boolean T = false;
  private boolean U = false;
  BroadcastReceiver a;
  protected Boolean a;
  public String f = "";
  public int k;
  int jdField_l_of_type_Int = 0;
  private ImageView jdField_l_of_type_AndroidWidgetImageView;
  int m = 0;
  
  static
  {
    jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap(20);
    jdField_n_of_type_Int = 100100;
    jdField_o_of_type_Int = 10;
  }
  
  public DeviceMsgChatPie(QQAppInterface paramQQAppInterface, ViewGroup paramViewGroup, FragmentActivity paramFragmentActivity, Context paramContext)
  {
    super(paramQQAppInterface, paramViewGroup, paramFragmentActivity, paramContext);
    this.jdField_k_of_type_Int = 0;
    this.jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(false);
    this.jdField_a_of_type_AndroidContentBroadcastReceiver = new DeviceMsgChatPie.7(this);
  }
  
  private void a(int paramInt, FrameLayout.LayoutParams paramLayoutParams, ProductInfo paramProductInfo)
  {
    if (paramProductInfo.isSupportMainMsgType(15)) {
      if (!paramProductInfo.isSupportFuncMsgType(3)) {}
    }
    do
    {
      do
      {
        return;
      } while ((paramProductInfo.isSupportFuncMsgType(1)) || (!paramProductInfo.isSupportFuncMsgType(2)));
      return;
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
      if ((paramProductInfo.supportMainMsgType & 0xF) == 3)
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
          this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setHint(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getString(2131720389));
          this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setHintTextColor(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getColor(2131167256));
          this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setGravity(17);
          this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setFocusable(false);
          this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setFocusableInTouchMode(false);
          this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.setVisibility(8);
          return;
        }
        if (paramProductInfo.isSupportFuncMsgType(1))
        {
          this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setHint(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getString(2131720389));
          this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setHintTextColor(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getColor(2131167256));
          this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setGravity(17);
          this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setFocusable(false);
          this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setFocusableInTouchMode(false);
          this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.setVisibility(8);
          return;
        }
        if (paramProductInfo.isSupportFuncMsgType(2))
        {
          this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setHint(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getString(2131720389));
          this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setHintTextColor(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getColor(2131167256));
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
        this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setHint(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getString(2131720389));
        this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setHintTextColor(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getColor(2131167256));
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
        this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setHint(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getString(2131720389));
        this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setHintTextColor(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getColor(2131167256));
        this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setGravity(17);
        this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setFocusable(false);
        this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setFocusableInTouchMode(false);
        this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setLayoutParams(paramLayoutParams);
        this.jdField_a_of_type_ComTencentWidgetPatchedButton.setVisibility(8);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.setVisibility(8);
        return;
      }
    } while (!paramProductInfo.isSupportFuncMsgType(2));
    paramLayoutParams.rightMargin = paramInt;
    this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setHint(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getString(2131720389));
    this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setHintTextColor(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getColor(2131167256));
    this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setGravity(17);
    this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setFocusable(false);
    this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setFocusableInTouchMode(false);
    this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setLayoutParams(paramLayoutParams);
    this.jdField_a_of_type_ComTencentWidgetPatchedButton.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.setVisibility(8);
  }
  
  public static void a(int paramInt, MessageRecord paramMessageRecord)
  {
    jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(paramInt), paramMessageRecord);
  }
  
  private void a(DeviceInfo paramDeviceInfo)
  {
    if ((this.P) && (this.Q) && (paramDeviceInfo != null)) {
      SmartDeviceReport.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramDeviceInfo.din, "Usr_AIO_SupportGroupChat", 0, 0, paramDeviceInfo.productId);
    }
  }
  
  private void a(DeviceInfo paramDeviceInfo, ProductInfo paramProductInfo, boolean paramBoolean)
  {
    if (paramProductInfo != null)
    {
      if ((paramProductInfo.supportMainMsgType & 0xF) != 0) {
        this.P = true;
      }
      if ((paramBoolean) || ((paramDeviceInfo.SSOBid_Platform != 1027) && ((StringUtil.a(paramDeviceInfo.SSOBid_Version)) || (Double.valueOf(paramDeviceInfo.SSOBid_Version).doubleValue() < 1.1D)))) {
        break label85;
      }
      this.Q = true;
      SettingCloneUtil.writeValue(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, null, "devicemsg_openchat_firsttrue", true);
    }
    label85:
    while ((!paramBoolean) && (!R)) {
      return;
    }
    this.Q = true;
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, ArrayList<String> paramArrayList, String paramString2)
  {
    Bundle localBundle = new Bundle();
    try
    {
      paramString2 = new JSONObject(paramString2);
      int i = paramString2.optInt("num", 1);
      int j = paramString2.optInt("face", 1);
      int i1 = paramString2.optInt("mediaSize", 1);
      int i2 = paramString2.optInt("mediaType", 1);
      int i3 = paramString2.optInt("scaling", 1);
      int i4 = paramString2.optInt("orientation", 1);
      int i5 = paramString2.optInt("color", 1);
      int i6 = paramString2.optInt("quality", 1);
      localBundle.putInt("copies", i);
      localBundle.putInt("duplexMode", j);
      localBundle.putInt("mediaSize", i1);
      localBundle.putInt("mediaType", i2);
      localBundle.putInt("scaling", i3);
      localBundle.putInt("orientation", i4);
      localBundle.putInt("color", i5);
      localBundle.putInt("quality", i6);
      ((DeviceMsgHandle)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DEVICEMSG_HANDLER)).a().a(DeviceMsgHandle.c, paramString1, paramArrayList, localBundle);
      return;
    }
    catch (JSONException paramString2)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("DeviceMsgChatPie", 2, "getString from json JSONException error:" + paramString2.getMessage());
        }
      }
    }
    catch (Exception paramString2)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("DeviceMsgChatPie", 2, "getString from json Exception error:" + paramString2.getMessage());
        }
      }
    }
  }
  
  /* Error */
  private boolean a(Intent paramIntent)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 10
    //   3: aconst_null
    //   4: astore 8
    //   6: iconst_0
    //   7: istore 5
    //   9: aload_0
    //   10: getfield 210	com/tencent/mobileqq/activity/aio/rebuild/DeviceMsgChatPie:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   13: getstatic 373	com/tencent/mobileqq/app/BusinessHandlerFactory:DEVICEPROXYMGR_HANDLER	Ljava/lang/String;
    //   16: invokevirtual 324	com/tencent/mobileqq/app/QQAppInterface:getBusinessHandler	(Ljava/lang/String;)Lcom/tencent/mobileqq/app/BusinessHandler;
    //   19: checkcast 375	com/tencent/device/devicemgr/SmartDeviceProxyMgr
    //   22: astore 11
    //   24: aload 11
    //   26: aload_0
    //   27: getfield 252	com/tencent/mobileqq/activity/aio/rebuild/DeviceMsgChatPie:jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo	Lcom/tencent/mobileqq/activity/aio/SessionInfo;
    //   30: getfield 256	com/tencent/mobileqq/activity/aio/SessionInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   33: invokestatic 381	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   36: invokevirtual 384	com/tencent/device/devicemgr/SmartDeviceProxyMgr:a	(J)Lcom/tencent/device/datadef/DeviceInfo;
    //   39: astore 9
    //   41: aload 9
    //   43: ifnull +465 -> 508
    //   46: aload 11
    //   48: aload 9
    //   50: getfield 221	com/tencent/device/datadef/DeviceInfo:productId	I
    //   53: invokevirtual 387	com/tencent/device/devicemgr/SmartDeviceProxyMgr:a	(I)Lcom/tencent/device/datadef/ProductInfo;
    //   56: astore 11
    //   58: aload 11
    //   60: ifnull +448 -> 508
    //   63: aload 11
    //   65: iconst_2
    //   66: invokevirtual 104	com/tencent/device/datadef/ProductInfo:isSupportFuncMsgType	(I)Z
    //   69: ifeq +439 -> 508
    //   72: iconst_1
    //   73: istore_2
    //   74: lconst_0
    //   75: lstore 6
    //   77: aload 9
    //   79: ifnull +424 -> 503
    //   82: aload 9
    //   84: getfield 216	com/tencent/device/datadef/DeviceInfo:din	J
    //   87: lstore 6
    //   89: aload 9
    //   91: getfield 221	com/tencent/device/datadef/DeviceInfo:productId	I
    //   94: istore_3
    //   95: iload_2
    //   96: ifne +39 -> 135
    //   99: aload_0
    //   100: getfield 210	com/tencent/mobileqq/activity/aio/rebuild/DeviceMsgChatPie:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   103: getstatic 318	com/tencent/mobileqq/app/BusinessHandlerFactory:DEVICEMSG_HANDLER	Ljava/lang/String;
    //   106: invokevirtual 324	com/tencent/mobileqq/app/QQAppInterface:getBusinessHandler	(Ljava/lang/String;)Lcom/tencent/mobileqq/app/BusinessHandler;
    //   109: checkcast 326	com/tencent/device/msg/data/DeviceMsgHandle
    //   112: astore_1
    //   113: aload_0
    //   114: getfield 210	com/tencent/mobileqq/activity/aio/rebuild/DeviceMsgChatPie:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   117: lload 6
    //   119: ldc_w 389
    //   122: bipush 7
    //   124: iconst_0
    //   125: iload_3
    //   126: invokestatic 226	com/tencent/device/utils/SmartDeviceReport:a	(Lmqq/app/AppRuntime;JLjava/lang/String;III)V
    //   129: iconst_1
    //   130: istore 4
    //   132: iload 4
    //   134: ireturn
    //   135: aload_0
    //   136: getfield 147	com/tencent/mobileqq/activity/aio/rebuild/DeviceMsgChatPie:jdField_a_of_type_AndroidSupportV4AppFragmentActivity	Landroid/support/v4/app/FragmentActivity;
    //   139: aload_0
    //   140: getfield 252	com/tencent/mobileqq/activity/aio/rebuild/DeviceMsgChatPie:jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo	Lcom/tencent/mobileqq/activity/aio/SessionInfo;
    //   143: getfield 256	com/tencent/mobileqq/activity/aio/SessionInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   146: aconst_null
    //   147: ldc_w 391
    //   150: iconst_1
    //   151: invokestatic 395	com/tencent/mobileqq/msf/sdk/SettingCloneUtil:readValue	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)Z
    //   154: istore 4
    //   156: getstatic 32	com/tencent/mobileqq/activity/aio/rebuild/DeviceMsgChatPie:R	Z
    //   159: ifeq +62 -> 221
    //   162: iload 4
    //   164: ifeq +57 -> 221
    //   167: aload_0
    //   168: getfield 210	com/tencent/mobileqq/activity/aio/rebuild/DeviceMsgChatPie:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   171: getstatic 318	com/tencent/mobileqq/app/BusinessHandlerFactory:DEVICEMSG_HANDLER	Ljava/lang/String;
    //   174: invokevirtual 324	com/tencent/mobileqq/app/QQAppInterface:getBusinessHandler	(Ljava/lang/String;)Lcom/tencent/mobileqq/app/BusinessHandler;
    //   177: checkcast 326	com/tencent/device/msg/data/DeviceMsgHandle
    //   180: aload_0
    //   181: getfield 252	com/tencent/mobileqq/activity/aio/rebuild/DeviceMsgChatPie:jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo	Lcom/tencent/mobileqq/activity/aio/SessionInfo;
    //   184: getfield 256	com/tencent/mobileqq/activity/aio/SessionInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   187: ldc_w 396
    //   190: invokestatic 400	com/tencent/mobileqq/app/HardCodeUtil:a	(I)Ljava/lang/String;
    //   193: invokestatic 405	com/tencent/mobileqq/service/message/MessageCache:a	()J
    //   196: iconst_1
    //   197: iconst_0
    //   198: iconst_1
    //   199: invokevirtual 408	com/tencent/device/msg/data/DeviceMsgHandle:a	(Ljava/lang/String;Ljava/lang/String;JZZZ)V
    //   202: aload_0
    //   203: getfield 147	com/tencent/mobileqq/activity/aio/rebuild/DeviceMsgChatPie:jdField_a_of_type_AndroidSupportV4AppFragmentActivity	Landroid/support/v4/app/FragmentActivity;
    //   206: aload_0
    //   207: getfield 252	com/tencent/mobileqq/activity/aio/rebuild/DeviceMsgChatPie:jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo	Lcom/tencent/mobileqq/activity/aio/SessionInfo;
    //   210: getfield 256	com/tencent/mobileqq/activity/aio/SessionInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   213: aconst_null
    //   214: ldc_w 391
    //   217: iconst_0
    //   218: invokestatic 264	com/tencent/mobileqq/msf/sdk/SettingCloneUtil:writeValue	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V
    //   221: iload 5
    //   223: istore 4
    //   225: getstatic 413	android/os/Build$VERSION:SDK_INT	I
    //   228: bipush 10
    //   230: if_icmpgt -98 -> 132
    //   233: aload_0
    //   234: getfield 147	com/tencent/mobileqq/activity/aio/rebuild/DeviceMsgChatPie:jdField_a_of_type_AndroidSupportV4AppFragmentActivity	Landroid/support/v4/app/FragmentActivity;
    //   237: invokevirtual 417	android/support/v4/app/FragmentActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   240: aload_1
    //   241: invokevirtual 423	android/content/Intent:getData	()Landroid/net/Uri;
    //   244: ldc_w 425
    //   247: invokevirtual 431	android/content/ContentResolver:openAssetFileDescriptor	(Landroid/net/Uri;Ljava/lang/String;)Landroid/content/res/AssetFileDescriptor;
    //   250: astore_1
    //   251: aload_1
    //   252: ifnull +125 -> 377
    //   255: aload_1
    //   256: invokevirtual 437	android/content/res/AssetFileDescriptor:createInputStream	()Ljava/io/FileInputStream;
    //   259: astore_1
    //   260: new 439	java/io/FileOutputStream
    //   263: dup
    //   264: new 441	java/io/File
    //   267: dup
    //   268: aload_0
    //   269: getfield 147	com/tencent/mobileqq/activity/aio/rebuild/DeviceMsgChatPie:jdField_a_of_type_AndroidSupportV4AppFragmentActivity	Landroid/support/v4/app/FragmentActivity;
    //   272: invokevirtual 445	android/support/v4/app/FragmentActivity:getApplicationContext	()Landroid/content/Context;
    //   275: invokestatic 451	android/preference/PreferenceManager:getDefaultSharedPreferences	(Landroid/content/Context;)Landroid/content/SharedPreferences;
    //   278: ldc_w 453
    //   281: ldc 57
    //   283: invokeinterface 458 3 0
    //   288: invokespecial 459	java/io/File:<init>	(Ljava/lang/String;)V
    //   291: invokespecial 462	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   294: astore 9
    //   296: sipush 1024
    //   299: newarray byte
    //   301: astore 11
    //   303: aload_1
    //   304: aload 11
    //   306: invokevirtual 468	java/io/FileInputStream:read	([B)I
    //   309: istore_2
    //   310: aload 9
    //   312: astore 10
    //   314: aload_1
    //   315: astore 8
    //   317: iload_2
    //   318: ifle +65 -> 383
    //   321: aload 9
    //   323: aload 11
    //   325: iconst_0
    //   326: iload_2
    //   327: invokevirtual 472	java/io/FileOutputStream:write	([BII)V
    //   330: goto -27 -> 303
    //   333: astore 10
    //   335: aload_1
    //   336: astore 8
    //   338: aload 9
    //   340: astore_1
    //   341: aload 10
    //   343: astore 9
    //   345: aload 9
    //   347: invokevirtual 475	java/lang/Exception:printStackTrace	()V
    //   350: aload 8
    //   352: ifnull +8 -> 360
    //   355: aload 8
    //   357: invokevirtual 478	java/io/FileInputStream:close	()V
    //   360: iload 5
    //   362: istore 4
    //   364: aload_1
    //   365: ifnull -233 -> 132
    //   368: aload_1
    //   369: invokevirtual 479	java/io/FileOutputStream:close	()V
    //   372: iconst_0
    //   373: ireturn
    //   374: astore_1
    //   375: iconst_0
    //   376: ireturn
    //   377: aconst_null
    //   378: astore 10
    //   380: aconst_null
    //   381: astore 8
    //   383: aload 8
    //   385: ifnull +8 -> 393
    //   388: aload 8
    //   390: invokevirtual 478	java/io/FileInputStream:close	()V
    //   393: iload 5
    //   395: istore 4
    //   397: aload 10
    //   399: ifnull -267 -> 132
    //   402: aload 10
    //   404: invokevirtual 479	java/io/FileOutputStream:close	()V
    //   407: iconst_0
    //   408: ireturn
    //   409: astore_1
    //   410: iconst_0
    //   411: ireturn
    //   412: astore 8
    //   414: aconst_null
    //   415: astore_1
    //   416: aload 10
    //   418: astore 9
    //   420: aload_1
    //   421: ifnull +7 -> 428
    //   424: aload_1
    //   425: invokevirtual 478	java/io/FileInputStream:close	()V
    //   428: aload 9
    //   430: ifnull +8 -> 438
    //   433: aload 9
    //   435: invokevirtual 479	java/io/FileOutputStream:close	()V
    //   438: aload 8
    //   440: athrow
    //   441: astore_1
    //   442: goto -4 -> 438
    //   445: astore 8
    //   447: aload 10
    //   449: astore 9
    //   451: goto -31 -> 420
    //   454: astore 8
    //   456: goto -36 -> 420
    //   459: astore 11
    //   461: aload 8
    //   463: astore 9
    //   465: aload_1
    //   466: astore 10
    //   468: aload 11
    //   470: astore 8
    //   472: aload 9
    //   474: astore_1
    //   475: aload 10
    //   477: astore 9
    //   479: goto -59 -> 420
    //   482: astore 9
    //   484: aconst_null
    //   485: astore_1
    //   486: goto -141 -> 345
    //   489: astore 9
    //   491: aconst_null
    //   492: astore 10
    //   494: aload_1
    //   495: astore 8
    //   497: aload 10
    //   499: astore_1
    //   500: goto -155 -> 345
    //   503: iconst_0
    //   504: istore_3
    //   505: goto -410 -> 95
    //   508: iconst_0
    //   509: istore_2
    //   510: goto -436 -> 74
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	513	0	this	DeviceMsgChatPie
    //   0	513	1	paramIntent	Intent
    //   73	437	2	i	int
    //   94	411	3	j	int
    //   130	266	4	bool1	boolean
    //   7	387	5	bool2	boolean
    //   75	43	6	l1	long
    //   4	385	8	localIntent1	Intent
    //   412	27	8	localObject1	Object
    //   445	1	8	localObject2	Object
    //   454	8	8	localObject3	Object
    //   470	26	8	localObject4	Object
    //   39	439	9	localObject5	Object
    //   482	1	9	localException1	Exception
    //   489	1	9	localException2	Exception
    //   1	312	10	localObject6	Object
    //   333	9	10	localException3	Exception
    //   378	120	10	localIntent2	Intent
    //   22	302	11	localObject7	Object
    //   459	10	11	localObject8	Object
    // Exception table:
    //   from	to	target	type
    //   296	303	333	java/lang/Exception
    //   303	310	333	java/lang/Exception
    //   321	330	333	java/lang/Exception
    //   355	360	374	java/lang/Exception
    //   368	372	374	java/lang/Exception
    //   388	393	409	java/lang/Exception
    //   402	407	409	java/lang/Exception
    //   233	251	412	finally
    //   255	260	412	finally
    //   424	428	441	java/lang/Exception
    //   433	438	441	java/lang/Exception
    //   260	296	445	finally
    //   296	303	454	finally
    //   303	310	454	finally
    //   321	330	454	finally
    //   345	350	459	finally
    //   233	251	482	java/lang/Exception
    //   255	260	482	java/lang/Exception
    //   260	296	489	java/lang/Exception
  }
  
  public static boolean b(MessageRecord paramMessageRecord)
  {
    Iterator localIterator = jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.entrySet().iterator();
    while (localIterator.hasNext()) {
      if (((MessageRecord)((Map.Entry)localIterator.next()).getValue()).uniseq == paramMessageRecord.uniseq) {
        return true;
      }
    }
    return false;
  }
  
  private void bj()
  {
    int i = 1;
    Object localObject2;
    if (!this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.isFinishing())
    {
      localObject1 = (DeviceMsgHandle)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DEVICEMSG_HANDLER);
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
      this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, (IntentFilter)localObject1);
      this.O = true;
      localObject2 = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getExtras();
      if (localObject2 != null)
      {
        this.jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(((Bundle)localObject2).getBoolean("bFromLightApp", false));
        this.jdField_l_of_type_Int = ((Bundle)localObject2).getInt("operType", 0);
        this.m = ((Bundle)localObject2).getInt("jumpTab", 0);
      }
      localObject1 = (ImageView)this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131369501);
      if (localObject1 == null) {
        break label658;
      }
      ((ImageView)localObject1).setImageResource(2130839704);
    }
    label653:
    label658:
    for (Object localObject1 = (RelativeLayout)((ImageView)localObject1).getParent();; localObject1 = null)
    {
      Object localObject3 = (ImageView)this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131369496);
      if (localObject3 != null)
      {
        ((ImageView)localObject3).setVisibility(0);
        ((ImageView)localObject3).setImageResource(2130839703);
        ((ImageView)localObject3).setOnClickListener(new DeviceMsgChatPie.2(this));
      }
      long l1 = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      localObject3 = (SmartDeviceProxyMgr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DEVICEPROXYMGR_HANDLER);
      boolean bool;
      if ((((SmartDeviceProxyMgr)localObject3).c(l1)) && (((SmartDeviceProxyMgr)localObject3).a(l1, 17)))
      {
        bool = true;
        this.T = bool;
        if (this.T) {
          ((SmartDeviceProxyMgr)localObject3).a(l1, "", "", "", 0, null);
        }
        if (localObject2 != null)
        {
          localObject2 = ((Bundle)localObject2).getStringArrayList("PhotoConst.PHOTO_PATHS");
          if ((localObject2 != null) && (((List)localObject2).size() > 0)) {
            h(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent());
          }
          localObject2 = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getParcelableArrayListExtra("sFilesSelected");
          if ((localObject2 != null) && (((ArrayList)localObject2).size() > 0)) {
            i(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent());
          }
        }
        bool = BaseApplication.getContext().getSharedPreferences("qsmart_preference", 0).getBoolean("ota_showupdatereddot", true);
        localObject2 = BaseApplication.getContext().getSharedPreferences("lock_red_dot_show", 0);
        if ((EquipmentLockImpl.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, BaseApplicationImpl.getApplication()) == 0) || (((SharedPreferences)localObject2).getBoolean(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString + "_" + "lock_red_dot_show" + "_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), false))) {
          break label653;
        }
      }
      for (;;)
      {
        if (((bool) && (((SmartDeviceProxyMgr)localObject3).d(l1))) || (i != 0))
        {
          this.jdField_l_of_type_AndroidWidgetImageView = new ImageView(this.jdField_a_of_type_AndroidContentContext);
          localObject2 = new RelativeLayout.LayoutParams(-2, -2);
          ((RelativeLayout.LayoutParams)localObject2).addRule(6, 2131369501);
          ((RelativeLayout.LayoutParams)localObject2).addRule(7, 2131369501);
          if (localObject1 != null)
          {
            ((RelativeLayout)localObject1).addView(this.jdField_l_of_type_AndroidWidgetImageView, (ViewGroup.LayoutParams)localObject2);
            this.jdField_l_of_type_AndroidWidgetImageView.setImageResource(2130850831);
          }
          this.jdField_l_of_type_AndroidWidgetImageView.setVisibility(0);
        }
        return;
        bool = false;
        break;
        i = 0;
      }
    }
  }
  
  private void h(Intent paramIntent)
  {
    this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a();
    Object localObject1 = paramIntent.getExtras().getStringArrayList("PhotoConst.PHOTO_PATHS");
    int i1 = paramIntent.getExtras().getInt("PhotoConst.SEND_SIZE_SPEC", 0);
    int j = 0;
    Object localObject2 = (SmartDeviceProxyMgr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DEVICEPROXYMGR_HANDLER);
    DeviceInfo localDeviceInfo = ((SmartDeviceProxyMgr)localObject2).a(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString));
    int i = j;
    Object localObject3;
    if (localDeviceInfo != null)
    {
      localObject3 = ((SmartDeviceProxyMgr)localObject2).a(localDeviceInfo.productId);
      i = j;
      if (localObject3 != null)
      {
        i = j;
        if (((ProductInfo)localObject3).isSupportFuncMsgType(1)) {
          i = 1;
        }
      }
    }
    long l1 = 0L;
    j = 0;
    if (localDeviceInfo != null)
    {
      l1 = localDeviceInfo.din;
      j = localDeviceInfo.productId;
    }
    if ((i == 0) && (this.jdField_l_of_type_Int != 4) && (this.jdField_l_of_type_Int != 3))
    {
      paramIntent = (DeviceMsgHandle)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DEVICEMSG_HANDLER);
      SmartDeviceReport.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, l1, "Usr_AIO_SendMsg", 7, 0, j);
    }
    do
    {
      do
      {
        return;
        localObject3 = new ArrayList();
        Iterator localIterator = ((List)localObject1).iterator();
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          try
          {
            ((ArrayList)localObject3).add(new FileInfo(str));
          }
          catch (FileNotFoundException localFileNotFoundException) {}
        }
        if ((this.jdField_l_of_type_Int == 4) || (this.jdField_l_of_type_Int == 3))
        {
          paramIntent = (SmartDeviceProxyMgr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DEVICEPROXYMGR_HANDLER);
          paramIntent = ((List)localObject1).iterator();
          while (paramIntent.hasNext()) {
            ((SmartDeviceProxyMgr)localObject2).a((String)paramIntent.next(), 2154);
          }
          if (QLog.isColorLevel()) {
            QLog.d(this.jdField_b_of_type_JavaLangString, 2, "prcessExtraData: send:" + ((List)localObject1).size());
          }
          K();
          return;
        }
        if (this.jdField_l_of_type_Int != 9) {
          break;
        }
      } while (((ArrayList)localObject3).size() <= 0);
      localObject1 = new Intent();
      ((Intent)localObject1).putParcelableArrayListExtra("sFilesSelected", (ArrayList)localObject3);
      ((Intent)localObject1).putExtra("sIsCloudPrinter", true);
      ((Intent)localObject1).putExtra("device_info", localDeviceInfo);
      ((Intent)localObject1).putExtra(AlbumConstants.h, paramIntent.getIntExtra(AlbumConstants.h, -1));
      ((Intent)localObject1).putExtra("filetype", "pic");
      ((Intent)localObject1).putExtra("url", "https://qzs.qq.com/open/mobile/iot_print/html/printOpt.html");
      SmartDevicePluginLoader.a().a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), (Intent)localObject1, "com.tencent.device.activities.LightPinterOptionActivity", 102, null, SmartDevicePluginProxyActivity.class);
      return;
      localObject2 = (DeviceMsgHandle)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DEVICEMSG_HANDLER);
      if ((R) && (this.Q))
      {
        ((DeviceMsgHandle)localObject2).a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, (List)localObject1);
        SmartDeviceReport.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, l1, "Usr_AIO_SendGroupMsg", 3, 0, j);
        return;
      }
      if (!this.T) {
        break;
      }
    } while (((ArrayList)localObject3).size() <= 0);
    localObject1 = new Intent();
    ((Intent)localObject1).putParcelableArrayListExtra("sFilesSelected", (ArrayList)localObject3);
    ((Intent)localObject1).putExtra("sIsCloudPrinter", true);
    ((Intent)localObject1).putExtra("device_info", localDeviceInfo);
    ((Intent)localObject1).putExtra(AlbumConstants.h, paramIntent.getIntExtra(AlbumConstants.h, -1));
    ((Intent)localObject1).putExtra("filetype", "pic");
    ((Intent)localObject1).putExtra("url", "https://qzs.qq.com/open/mobile/iot_print/html/printOpt.html");
    SmartDevicePluginLoader.a().a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), (Intent)localObject1, "com.tencent.device.activities.LightPinterOptionActivity", 102, null, SmartDevicePluginProxyActivity.class);
    return;
    if (i1 == 2)
    {
      b((List)localObject1);
      return;
    }
    c((List)localObject1);
  }
  
  private void i(Intent paramIntent)
  {
    if (!((DeviceFileHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DEVICEFILE_HANDLER)).a(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))) {
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, HardCodeUtil.a(2131703205), 2000).a();
    }
    ArrayList localArrayList;
    do
    {
      do
      {
        return;
        localObject = paramIntent.getParcelableArrayListExtra("sFilesSelected");
      } while ((localObject == null) || (((ArrayList)localObject).size() <= 0));
      localArrayList = new ArrayList();
      Object localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        localArrayList.add(((FileInfo)((Iterator)localObject).next()).c());
      }
      paramIntent = paramIntent.getStringExtra("sPrintParam");
      if (NetworkUtil.a(this.jdField_a_of_type_AndroidContentContext)) {
        break;
      }
      paramIntent = DialogUtil.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 230, this.jdField_a_of_type_AndroidContentContext.getString(2131697607), this.jdField_a_of_type_AndroidContentContext.getString(2131697384), HardCodeUtil.a(2131703220), HardCodeUtil.a(2131703221), new DeviceMsgChatPie.5(this, localArrayList, paramIntent), new DeviceMsgChatPie.6(this));
    } while (paramIntent.isShowing());
    paramIntent.show();
    return;
    a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, localArrayList, paramIntent);
  }
  
  private void j(Intent paramIntent)
  {
    paramIntent = paramIntent.getExtras();
    int i;
    if (paramIntent != null)
    {
      i = paramIntent.getInt("cookie", 0);
      int j = paramIntent.getInt("err_code", 1);
      if ((i != 0) && (jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(Integer.valueOf(i))))
      {
        paramIntent = (MessageRecord)jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(i));
        if (j != 0) {
          break label289;
        }
        if (!(paramIntent instanceof MessageForDevPtt)) {
          break label165;
        }
        paramIntent = (MessageForDevPtt)paramIntent;
        paramIntent.extraflag = 32770;
        paramIntent.fileSize = FileManagerUtil.a(paramIntent.url);
        paramIntent.extStr = "device_groupchat";
        paramIntent.serial();
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(paramIntent.frienduin, paramIntent.istroop, paramIntent.uniseq, paramIntent.msgData);
        ((DeviceMsgHandle)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DEVICEMSG_HANDLER)).a().a(paramIntent, Boolean.valueOf(true));
      }
    }
    label289:
    for (;;)
    {
      jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(Integer.valueOf(i));
      return;
      label165:
      if ((paramIntent instanceof MessageForDeviceFile))
      {
        ((DeviceMsgHandle)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DEVICEMSG_HANDLER)).a().a(paramIntent, Boolean.valueOf(true));
      }
      else if ((paramIntent instanceof MessageForDevLittleVideo))
      {
        MessageForDevLittleVideo localMessageForDevLittleVideo = (MessageForDevLittleVideo)paramIntent;
        localMessageForDevLittleVideo.videoFileStatus = 1003;
        localMessageForDevLittleVideo.videoFileProgress = 100;
        localMessageForDevLittleVideo.serial();
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(localMessageForDevLittleVideo.frienduin, localMessageForDevLittleVideo.istroop, localMessageForDevLittleVideo.uniseq, localMessageForDevLittleVideo.msgData);
        ((DeviceMsgHandle)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DEVICEMSG_HANDLER)).a().a(paramIntent, Boolean.valueOf(true));
        continue;
        if ((paramIntent instanceof MessageForDevPtt))
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
      }
    }
  }
  
  private void k(Intent paramIntent)
  {
    paramIntent = paramIntent.getExtras();
    float f1;
    if (paramIntent != null)
    {
      int i = paramIntent.getInt("cookie", 0);
      f1 = paramIntent.getFloat("percent", 0.0F);
      if ((i != 0) && (jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(Integer.valueOf(i))))
      {
        paramIntent = (MessageRecord)jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(i));
        if (!(paramIntent instanceof MessageForDeviceFile)) {
          break label111;
        }
        paramIntent = (MessageForDeviceFile)paramIntent;
        paramIntent.nFileStatus = 3;
        paramIntent.progress = f1;
        paramIntent.serial();
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(paramIntent.frienduin, paramIntent.istroop, paramIntent.uniseq, paramIntent.msgData);
      }
    }
    label111:
    while (!(paramIntent instanceof MessageForDevLittleVideo)) {
      return;
    }
    paramIntent = (MessageForDevLittleVideo)paramIntent;
    paramIntent.videoFileStatus = 1002;
    paramIntent.videoFileProgress = ((int)(100.0F * f1));
    paramIntent.serial();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(paramIntent.frienduin, paramIntent.istroop, paramIntent.uniseq, paramIntent.msgData);
    ((DeviceMsgHandle)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DEVICEMSG_HANDLER)).a().a(paramIntent, f1);
  }
  
  private void v(int paramInt)
  {
    this.f = PreferenceManager.getDefaultSharedPreferences(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getApplicationContext()).getString("device_video_path", "");
    PreferenceManager.getDefaultSharedPreferences(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getApplicationContext()).edit().remove("device_video_path").commit();
    if (paramInt == -1)
    {
      if (!TextUtils.isEmpty(this.f))
      {
        QQCustomDialog localQQCustomDialog = DialogUtil.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 230);
        localQQCustomDialog.setNegativeButton(2131690800, new DeviceMsgChatPie.3(this));
        localQQCustomDialog.setPositiveButton(2131694615, new DeviceMsgChatPie.4(this));
        localQQCustomDialog.setTitle(HardCodeUtil.a(2131703212));
        Object localObject = new File(this.f);
        localObject = ShortVideoUtils.stringForFileSize(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, ((File)localObject).length());
        localQQCustomDialog.setMessage(HardCodeUtil.a(2131703218) + (String)localObject + HardCodeUtil.a(2131703210));
        localQQCustomDialog.show();
      }
      return;
    }
    if (!TextUtils.isEmpty(this.f)) {
      FileUtils.e(this.f);
    }
    this.f = "";
  }
  
  public void B()
  {
    if (this.jdField_a_of_type_AndroidWidgetImageView != null)
    {
      a(this.jdField_a_of_type_AndroidWidgetImageView, 2130839704, 2130839704);
      this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getText(2131696406));
    }
  }
  
  public boolean E()
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
  
  public boolean F()
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
  
  public boolean G()
  {
    if (F()) {
      return true;
    }
    try
    {
      l1 = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      SmartDeviceProxyMgr localSmartDeviceProxyMgr = (SmartDeviceProxyMgr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DEVICEPROXYMGR_HANDLER);
      if ((localSmartDeviceProxyMgr != null) && (localSmartDeviceProxyMgr.c(l1)) && (localSmartDeviceProxyMgr.a(l1, 17))) {
        return true;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
        long l1 = 0L;
      }
    }
    return false;
  }
  
  public boolean H()
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
  
  public boolean I()
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
  
  public void J()
  {
    if (this.I) {
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_b_of_type_JavaLangString, 2, "hasDestory = true return");
      }
    }
    do
    {
      return;
      super.J();
      try
      {
        this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
        return;
      }
      catch (IllegalArgumentException localIllegalArgumentException) {}
    } while (!QLog.isColorLevel());
    QLog.w(this.jdField_b_of_type_JavaLangString, 2, " already unregisterReceiver" + localIllegalArgumentException);
  }
  
  public void R()
  {
    super.R();
    if ((this.jdField_l_of_type_Int == 3) || (this.jdField_l_of_type_Int == 4))
    {
      if (!this.S) {
        this.S = true;
      }
    }
    else {
      return;
    }
    super.K();
  }
  
  public void S()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioHelperHelperProvider.a(21);
    AIOUtils.a(false);
    this.jdField_i_of_type_Boolean = false;
    this.jdField_k_of_type_Boolean = true;
    this.jdField_n_of_type_Boolean = false;
    this.jdField_o_of_type_Boolean = false;
    this.q = false;
    this.r = false;
    this.H = true;
    this.I = false;
    this.jdField_b_of_type_Boolean = true;
    this.jdField_c_of_type_Boolean = false;
    if (this.jdField_b_of_type_AndroidWidgetRelativeLayout != null)
    {
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.removeAllViews();
      this.jdField_i_of_type_AndroidWidgetTextView = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager.a();
    }
    if (this.jdField_e_of_type_AndroidViewView != null)
    {
      this.jdField_e_of_type_AndroidViewView.setVisibility(4);
      this.jdField_e_of_type_AndroidViewView = null;
    }
    AIOEmoticonUIHelper localAIOEmoticonUIHelper = (AIOEmoticonUIHelper)a(105);
    if (localAIOEmoticonUIHelper != null) {
      localAIOEmoticonUIHelper.a();
    }
    if (this.jdField_a_of_type_ComTencentWidgetXPanelContainer != null)
    {
      this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a();
      this.jdField_a_of_type_ComTencentWidgetXPanelContainer.d();
    }
  }
  
  public MsgList a()
  {
    return new MsgListBuilder(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext).a(new Scroller()).a(new ListUI(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext)).a(new UnreadTask(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext)).a(new DeviceMsgListRefresher(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext)).a();
  }
  
  public RecordParams.RecorderParam a()
  {
    Object localObject = ((SmartDeviceProxyMgr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DEVICEPROXYMGR_HANDLER)).a(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString));
    localObject = new LightAppUtil().a((DeviceInfo)localObject);
    if ((localObject != null) && (((LightAppSettingInfo)localObject).a.get(Integer.valueOf(11007)) != null)) {}
    try
    {
      String str = (String)((LightAppSettingInfo)localObject).a.get(Integer.valueOf(11007));
      localObject = str;
      if (TextUtils.isEmpty(str)) {
        localObject = "";
      }
      if (new JSONObject(((String)localObject).replace("&quot;", "\"")).optString("Audio", "").toLowerCase().equals("slk"))
      {
        localObject = new RecordParams.RecorderParam(RecordParams.b, 16000, 1);
        return localObject;
      }
    }
    catch (JSONException localJSONException)
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_b_of_type_JavaLangString, 2, "getString from json JSONException error:" + localJSONException.getMessage());
      }
      return new RecordParams.RecorderParam(RecordParams.jdField_a_of_type_Int, 0, 0);
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d(this.jdField_b_of_type_JavaLangString, 2, "getString from json Exception error:" + localException.getMessage());
        }
      }
    }
  }
  
  public void a()
  {
    int i = (int)(6.0F * this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getDisplayMetrics().density);
    Object localObject2 = (FrameLayout.LayoutParams)this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getLayoutParams();
    ((FrameLayout.LayoutParams)localObject2).leftMargin = i;
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
      this.jdField_k_of_type_Int = localDeviceInfo.productId;
    }
    for (;;)
    {
      R = ((SmartDeviceProxyMgr)localObject1).a(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)).booleanValue();
      boolean bool = SettingCloneUtil.readValue(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, null, "devicemsg_showsupporttips_first", true);
      a(localDeviceInfo, localProductInfo, SettingCloneUtil.readValue(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, null, "devicemsg_openchat_firsttrue", false));
      a(localDeviceInfo);
      if ((localProductInfo != null) && (bool))
      {
        if ((localProductInfo.supportMainMsgType & 0xF) != 0) {
          break label424;
        }
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131691647);
        if (!TextUtils.isEmpty((CharSequence)localObject1))
        {
          localObject1 = (DeviceMsgHandle)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DEVICEMSG_HANDLER);
          if ((this.P) && (localDeviceInfo.isAdmin == 1) && (this.Q) && (!R))
          {
            localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131691671);
            ((DeviceMsgHandle)localObject1).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, (String)localObject2, MessageCache.a(), true, false, true);
          }
          SettingCloneUtil.writeValue(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, null, "devicemsg_showsupporttips_first", false);
        }
      }
      if (QLog.isColorLevel())
      {
        if (localProductInfo == null) {
          break label751;
        }
        QLog.d(this.jdField_b_of_type_JavaLangString, 2, "support msg type maintype" + localProductInfo.supportMainMsgType + ", FuncMsgType:" + localProductInfo.supportFuncMsgType);
      }
      for (;;)
      {
        bi();
        return;
        label424:
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131691669);
        localObject1 = localObject2;
        if (localProductInfo.isSupportMainMsgType(1)) {
          localObject1 = (String)localObject2 + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131691670) + "、";
        }
        localObject2 = localObject1;
        if (localProductInfo.isSupportMainMsgType(2)) {
          localObject2 = (String)localObject1 + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131691600) + "、";
        }
        localObject1 = localObject2;
        if (localProductInfo.isSupportMainMsgType(8)) {
          localObject1 = (String)localObject2 + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131691606) + "、";
        }
        localObject2 = localObject1;
        if (localProductInfo.isSupportFuncMsgType(1)) {
          localObject2 = (String)localObject1 + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131691649) + "、";
        }
        localObject1 = localObject2;
        if (localProductInfo.isSupportFuncMsgType(2)) {
          localObject1 = (String)localObject2 + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131691674) + "、";
        }
        localObject2 = localObject1;
        if (((String)localObject1).endsWith("、")) {
          localObject2 = ((String)localObject1).substring(0, ((String)localObject1).length() - 1);
        }
        localObject1 = (String)localObject2 + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131691668);
        break;
        label751:
        QLog.d(this.jdField_b_of_type_JavaLangString, 2, "product is null");
      }
      localProductInfo = null;
    }
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
      SmartDevicePluginLoader.a().a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), localIntent, "com.tencent.device.activities.LightPinterOptionActivity", 102, null, SmartDevicePluginProxyActivity.class);
      switch (paramInt1)
      {
      }
    }
    for (;;)
    {
      if ((this.jdField_l_of_type_Int == 4) && (paramInt2 == -1) && (paramInt1 == 1)) {
        this.S = false;
      }
      return;
      if (paramInt1 == 102)
      {
        if ((paramInt2 != -1) || (paramIntent == null)) {
          break;
        }
        i(paramIntent);
        break;
      }
      if ((81 == paramInt1) || (83 == paramInt1))
      {
        if (!a(paramIntent)) {
          break;
        }
        return;
      }
      if (paramInt1 != jdField_n_of_type_Int) {
        break;
      }
      if (paramInt2 == jdField_o_of_type_Int) {
        K();
      }
      for (;;)
      {
        localObject = SmartDeviceUtil.a(((SmartDeviceProxyMgr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DEVICEPROXYMGR_HANDLER)).a(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)));
        if (localObject == null) {
          break;
        }
        this.jdField_e_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
        break;
        if (paramInt2 == p) {
          this.U = true;
        }
      }
      if ((paramInt2 == -1) && (paramIntent != null))
      {
        paramIntent = paramIntent.getParcelableArrayListExtra("sendInfo");
        if ((paramIntent != null) && (paramIntent.size() > 0))
        {
          this.f = ((SendInfo)paramIntent.get(0)).a();
          DevVideoMsgProcessor.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.f);
          continue;
          v(paramInt2);
        }
      }
    }
  }
  
  public void a(Object paramObject)
  {
    if ((paramObject == null) || (!(paramObject instanceof Integer))) {
      return;
    }
    int i = ((Integer)paramObject).intValue();
    if (QLog.isColorLevel()) {
      QLog.d("XPanel", 2, "onPanelIconClick panelID=" + i + "currentID=" + this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a());
    }
    if (i == this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a())
    {
      this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a();
      return;
    }
    switch (i)
    {
    }
    for (;;)
    {
      super.a(paramObject);
      return;
      this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a();
      PlusPanelUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, a(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, 2, true);
      continue;
      this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a();
      aH();
      continue;
      AIOPanelUtiles.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "0X800407C", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
      Object localObject = new FileManagerReporter.FileAssistantReportData();
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
  
  public void a(String paramString, long paramLong, int paramInt1, int paramInt2, RecordParams.RecorderParam paramRecorderParam, int paramInt3, boolean paramBoolean, int paramInt4)
  {
    if (!this.N) {
      return;
    }
    if (paramRecorderParam.jdField_a_of_type_JavaLangObject == null)
    {
      paramInt1 = 1;
      if (paramInt1 != 0) {
        break label298;
      }
      StreamDataManager.a(paramString, false);
      StreamDataManager.a(paramString);
      label33:
      if (new File(paramString).exists()) {
        break label530;
      }
      paramInt1 = 0;
      paramRecorderParam = paramString;
      label53:
      if (paramInt1 >= VoiceTuneUtil.jdField_a_of_type_Int) {
        break label524;
      }
      paramRecorderParam = VoiceTuneUtil.a(paramString, paramInt1);
      if (!new File(paramRecorderParam).exists()) {
        break label306;
      }
      paramString = paramRecorderParam;
    }
    label524:
    label530:
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AIOAudioPanel", 2, "sendPttInner(),recordingUniseq is:" + paramLong + ",path is:" + paramString);
      }
      SmartDeviceProxyMgr localSmartDeviceProxyMgr = null;
      paramRecorderParam = localSmartDeviceProxyMgr;
      if (!TextUtils.isEmpty(paramString))
      {
        paramRecorderParam = localSmartDeviceProxyMgr;
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null) {
          if (paramLong == 0L) {
            break label315;
          }
        }
      }
      label298:
      label306:
      label315:
      for (paramRecorderParam = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, paramLong);; paramRecorderParam = DevAudioMsgProcessor.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_JavaLangString, -2L))
      {
        if (paramRecorderParam == null) {
          break label350;
        }
        super.a(0, paramString, paramRecorderParam.uniseq);
        if ((!R) || (!this.Q)) {
          break label468;
        }
        if ((NetworkUtil.d(BaseApplication.getContext())) || (!(paramRecorderParam instanceof MessageForDevPtt))) {
          break label352;
        }
        paramString = (MessageForDevPtt)paramRecorderParam;
        paramString.fileSize = -1L;
        paramString.extraflag = 32768;
        paramString.extStr = "device_groupchat";
        paramString.serial();
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(paramString.frienduin, paramString.istroop, paramString.uniseq, paramString.msgData);
        return;
        paramInt1 = 0;
        break;
        PttBuffer.b(paramString);
        break label33;
        paramInt1 += 1;
        break label53;
      }
      label350:
      break;
      label352:
      localSmartDeviceProxyMgr = (SmartDeviceProxyMgr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DEVICEPROXYMGR_HANDLER);
      paramInt1 = localSmartDeviceProxyMgr.a(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString), paramString, QQRecorder.a(paramInt2));
      if ((paramRecorderParam instanceof MessageForDevPtt)) {
        ((MessageForDevPtt)paramRecorderParam).voiceLength = QQRecorder.a(paramInt2);
      }
      jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(paramInt1), paramRecorderParam);
      paramString = localSmartDeviceProxyMgr.a(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString));
      if (paramString == null) {
        break;
      }
      SmartDeviceReport.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString.din, "Usr_AIO_SendGroupMsg", 1, 0, paramString.productId);
      return;
      label468:
      ((DeviceMsgHandle)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DEVICEMSG_HANDLER)).a().a(DeviceMsgHandle.f, paramString, Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString), paramRecorderParam.uniseq, paramRecorderParam.istroop, QQRecorder.a(paramInt2));
      paramLong = paramRecorderParam.uniseq;
      return;
      paramString = paramRecorderParam;
    }
  }
  
  public void a(String paramString, boolean paramBoolean, RecordParams.RecorderParam paramRecorderParam)
  {
    Object localObject2 = (SmartDeviceProxyMgr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DEVICEPROXYMGR_HANDLER);
    Object localObject1 = ((SmartDeviceProxyMgr)localObject2).a(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString));
    if (localObject1 != null)
    {
      localObject2 = ((SmartDeviceProxyMgr)localObject2).a(((DeviceInfo)localObject1).productId);
      if ((localObject2 == null) || (!((ProductInfo)localObject2).isSupportMainMsgType(2))) {}
    }
    for (boolean bool = true;; bool = false)
    {
      long l1 = 0L;
      int i = 0;
      if (localObject1 != null)
      {
        l1 = ((DeviceInfo)localObject1).din;
        i = ((DeviceInfo)localObject1).productId;
      }
      SmartDeviceReport.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, l1, "Usr_AIO_SendMsg", 1, 0, i);
      this.N = bool;
      if (!bool)
      {
        paramString = (DeviceMsgHandle)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DEVICEMSG_HANDLER);
        SmartDeviceReport.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, l1, "Usr_AIO_SendMsg", 7, 0, i);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_b_of_type_JavaLangString, 2, "onRecorderPerpare path = " + paramString);
      }
      localObject1 = RecordParams.a(paramRecorderParam.c, paramRecorderParam.jdField_a_of_type_Int);
      if (paramRecorderParam.jdField_a_of_type_JavaLangObject == null)
      {
        i = 1;
        label207:
        if (i != 0) {
          break label278;
        }
        StreamDataManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramRecorderParam.c, paramString, 0, (int)(System.currentTimeMillis() / 1000L));
        StreamDataManager.a(paramString, (byte[])localObject1, localObject1.length, (short)0);
        label245:
        if (paramString == null) {
          break label294;
        }
        if (paramBoolean) {
          break label296;
        }
        this.jdField_a_of_type_Long = 0L;
        k(2131230745);
      }
      for (;;)
      {
        c(true, false);
        return;
        i = 0;
        break label207;
        label278:
        PttBuffer.a(paramString);
        PttBuffer.a(paramString, (byte[])localObject1, localObject1.length);
        break label245;
        label294:
        break;
        label296:
        paramString = DevAudioMsgProcessor.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_JavaLangString, -2L);
        if (i == 0) {
          paramString.setPttStreamFlag(10001);
        }
        if (paramString != null) {
          this.jdField_a_of_type_Long = paramString.uniseq;
        }
        k(2131230733);
      }
    }
  }
  
  public boolean a(boolean paramBoolean)
  {
    this.B = false;
    this.I = false;
    if (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getExtras() == null)
    {
      super.K();
      return true;
    }
    super.a(paramBoolean);
    if (Build.VERSION.SDK_INT >= 23)
    {
      if (!PermissionUtils.isStorePermissionEnable(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity))
      {
        CheckPermission.requestStorePermission(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, new DeviceMsgChatPie.1(this));
        return true;
      }
      bj();
      return true;
    }
    bj();
    return true;
  }
  
  public void ao()
  {
    boolean bool = true;
    Object localObject1;
    if (this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().length() > 0)
    {
      localObject1 = this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().toString();
      PicPreDownloadUtils.a((String)localObject1);
      if ((localObject1 != null) && (((String)localObject1).length() > 3478))
      {
        ChatActivityUtils.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 2131719043, 1);
        return;
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setText("");
      Object localObject3 = (SmartDeviceProxyMgr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DEVICEPROXYMGR_HANDLER);
      Object localObject2 = ((SmartDeviceProxyMgr)localObject3).a(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString));
      if (localObject2 != null)
      {
        localObject3 = ((SmartDeviceProxyMgr)localObject3).a(((DeviceInfo)localObject2).productId);
        if ((localObject3 == null) || (!((ProductInfo)localObject3).isSupportMainMsgType(1))) {}
      }
      for (int i = 1;; i = 0)
      {
        long l1 = 0L;
        if (localObject2 != null) {
          l1 = ((DeviceInfo)localObject2).din;
        }
        for (int j = ((DeviceInfo)localObject2).productId;; j = 0)
        {
          if (i == 0)
          {
            localObject1 = (DeviceMsgHandle)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DEVICEMSG_HANDLER);
            SmartDeviceReport.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, l1, "Usr_AIO_SendMsg", 7, 0, j);
            return;
          }
          localObject2 = (DeviceMsgHandle)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DEVICEMSG_HANDLER);
          SessionInfo localSessionInfo;
          if (!TextUtils.isEmpty((CharSequence)localObject1))
          {
            localObject3 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
            localSessionInfo = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
            if ((!R) || (!this.Q)) {
              break label270;
            }
          }
          for (;;)
          {
            ((DeviceMsgHandle)localObject2).a((QQAppInterface)localObject3, localSessionInfo, (String)localObject1, bool);
            SmartDeviceReport.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, l1, "Usr_AIO_SendMsg", 6, 0, j);
            return;
            label270:
            bool = false;
          }
        }
      }
      localObject1 = null;
    }
  }
  
  public void b(List<String> paramList)
  {
    DeviceMsgHandle localDeviceMsgHandle = (DeviceMsgHandle)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DEVICEMSG_HANDLER);
    if ((R) && (this.Q))
    {
      localDeviceMsgHandle.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, paramList);
      paramList = ((SmartDeviceProxyMgr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DEVICEPROXYMGR_HANDLER)).a(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString));
      SmartDeviceReport.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramList.din, "Usr_AIO_SendGroupMsg", 3, 0, paramList.productId);
      return;
    }
    localDeviceMsgHandle.a().a(DeviceMsgHandle.d, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, paramList);
  }
  
  void bi()
  {
    int i = (int)(6.0F * this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getDisplayMetrics().density);
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getLayoutParams();
    Object localObject = (SmartDeviceProxyMgr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DEVICEPROXYMGR_HANDLER);
    DeviceInfo localDeviceInfo = ((SmartDeviceProxyMgr)localObject).a(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString));
    if (localDeviceInfo != null) {}
    for (localObject = ((SmartDeviceProxyMgr)localObject).a(localDeviceInfo.productId);; localObject = null)
    {
      if (localObject != null)
      {
        if ((((ProductInfo)localObject).supportMainMsgType & 0xF) == 0)
        {
          this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.setVisibility(8);
          this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setVisibility(8);
        }
        for (;;)
        {
          if (!((ProductInfo)localObject).isSupportMainMsgType(1)) {
            this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.setVisibility(8);
          }
          return;
          a(i, localLayoutParams, (ProductInfo)localObject);
        }
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.setVisibility(8);
      return;
    }
  }
  
  public void c()
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
        PicReq localPicReq1 = PicBusiManager.a(2, 1007);
        PicReq localPicReq2 = PicBusiManager.a(1, 1007);
        localPicReq2.a(localPicReq1.jdField_a_of_type_JavaLangString);
        if (localPicReq2.a(PicBusiManager.a(1007, localIntent)))
        {
          localPicReq2.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoICompressionCallBack = new DeviceMsgChatPie.CompressCallBack(this);
          PicBusiManager.a(localPicReq2);
        }
        else
        {
          i(str);
        }
      }
    }
  }
  
  public void d(String paramString)
  {
    if (this.N) {
      super.d(paramString);
    }
  }
  
  public boolean d()
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
  
  public boolean e()
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
  
  public void f(Intent paramIntent)
  {
    int i = paramIntent.getIntExtra("forward_type", 2147483647);
    if (i == 2147483647) {}
    String str;
    DeviceMsgHandle localDeviceMsgHandle;
    do
    {
      return;
      paramIntent.removeExtra("forward_type");
      if (i != -1) {
        break;
      }
      str = paramIntent.getStringExtra("forward_text");
      localDeviceMsgHandle = (DeviceMsgHandle)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DEVICEMSG_HANDLER);
    } while (TextUtils.isEmpty(str));
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString = paramIntent.getStringExtra("uin");
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int = paramIntent.getIntExtra("uintype", -1);
    paramIntent = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    SessionInfo localSessionInfo = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
    if ((R) && (this.Q)) {}
    for (boolean bool = true;; bool = false)
    {
      localDeviceMsgHandle.a(paramIntent, localSessionInfo, str, bool);
      return;
    }
    super.f(paramIntent);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return super.handleMessage(paramMessage);
      this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(20);
      this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(20, 10000L);
      continue;
      this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(20);
    }
  }
  
  public void i(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramString);
    b(localArrayList);
  }
  
  public void u()
  {
    super.u();
    if ((this.jdField_l_of_type_Int == 1) || (this.jdField_l_of_type_Int == 3) || (this.jdField_l_of_type_Int == 9)) {
      if ((PanelIconLinearLayout)this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131372729) != null) {
        a(Integer.valueOf(4));
      }
    }
    label53:
    do
    {
      do
      {
        do
        {
          break label53;
          do
          {
            return;
          } while (!QLog.isColorLevel());
          QLog.d(this.jdField_b_of_type_JavaLangString, 2, "DeviceMsgChatPie, OPER_TYPE_SEND_PICTURE[" + this.jdField_l_of_type_Int + "], find view panelicons failed!!");
          return;
          if ((this.jdField_l_of_type_Int != 2) && (this.jdField_l_of_type_Int != 4)) {
            break;
          }
          if ((PanelIconLinearLayout)this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131372729) != null)
          {
            a(Integer.valueOf(5));
            return;
          }
        } while (!QLog.isColorLevel());
        QLog.d(this.jdField_b_of_type_JavaLangString, 2, "DeviceMsgChatPie, OPER_TYPE_SEND_PICTURE[" + this.jdField_l_of_type_Int + "], find view panelicons failed!!");
        return;
      } while (this.jdField_l_of_type_Int == 5);
      if (this.jdField_l_of_type_Int == 6)
      {
        AIOPanelUtiles.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
        return;
      }
      FileManagerReporter.FileAssistantReportData localFileAssistantReportData;
      if (this.jdField_l_of_type_Int == 7)
      {
        localFileAssistantReportData = new FileManagerReporter.FileAssistantReportData();
        localFileAssistantReportData.jdField_b_of_type_JavaLangString = "send_file";
        localFileAssistantReportData.jdField_a_of_type_Int = 1;
        FileManagerReporter.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), localFileAssistantReportData);
        PlusPanelUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, a(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.m, false);
        return;
      }
      if (this.jdField_l_of_type_Int == 8)
      {
        this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a(2);
        return;
      }
      if (this.jdField_l_of_type_Int == 10)
      {
        localFileAssistantReportData = new FileManagerReporter.FileAssistantReportData();
        localFileAssistantReportData.jdField_b_of_type_JavaLangString = "send_file";
        localFileAssistantReportData.jdField_a_of_type_Int = 1;
        FileManagerReporter.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), localFileAssistantReportData);
        PlusPanelUtils.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, a(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
        return;
      }
    } while (this.jdField_l_of_type_Int != 11);
    a(Integer.valueOf(13));
  }
  
  public void v()
  {
    if (this.d != null)
    {
      if (AIOTopRightButtonConfig.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())) {
        this.d.setVisibility(0);
      }
    }
    else {
      return;
    }
    this.d.setVisibility(8);
  }
  
  public void z()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString.equals(AppConstants.SMARTDEVICE_SEARCH_UIN))
    {
      localIntent = new Intent();
      localIntent.putExtra("url", "https://qzs.qq.com/open/mobile/iot_menu/aioSet.html");
      SmartDevicePluginLoader.a().a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), localIntent, "com.tencent.device.activities.DeviceSquareSettingActivity", jdField_n_of_type_Int, null, SmartDevicePluginProxyActivity.class);
    }
    do
    {
      return;
      localObject = ((SmartDeviceProxyMgr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DEVICEPROXYMGR_HANDLER)).a(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString));
      int i = 0;
      long l1 = 0L;
      if (localObject != null)
      {
        i = ((DeviceInfo)localObject).productId;
        l1 = ((DeviceInfo)localObject).din;
      }
      SmartDeviceReport.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, l1, "Usr_AIO_Menu", 1, 0, i);
    } while (localObject == null);
    Intent localIntent = new Intent();
    localIntent.putExtra("device_info", (Parcelable)localObject);
    localIntent.putExtra("isPublicDevice", true);
    Object localObject = new LightAppUtil(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity).a((DeviceInfo)localObject);
    if (localObject != null) {
      localIntent.putExtra("lightapp_setting", (Parcelable)localObject);
    }
    SmartDevicePluginLoader.a().a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), localIntent, "com.tencent.device.activities.DeviceSettingActivity", jdField_n_of_type_Int, null, SmartDevicePluginProxyActivity.class);
    if (this.jdField_l_of_type_AndroidWidgetImageView != null) {
      this.jdField_l_of_type_AndroidWidgetImageView.setVisibility(8);
    }
    BaseApplication.getContext().getSharedPreferences("lock_red_dot_show", 0).edit().putBoolean(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString + "_" + "lock_red_dot_show" + "_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), true).commit();
    BaseApplication.getContext().getSharedPreferences("qsmart_preference", 0).edit().putBoolean("ota_showupdatereddot", false).commit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.DeviceMsgChatPie
 * JD-Core Version:    0.7.0.1
 */