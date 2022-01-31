package com.tencent.mobileqq.activity.aio.rebuild;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Message;
import android.os.Parcelable;
import android.support.v4.app.FragmentActivity;
import android.text.Editable;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.av.ui.AIOTopRightButtonConfig;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.device.datadef.DeviceInfo;
import com.tencent.device.datadef.ProductInfo;
import com.tencent.device.devicemgr.SmartDeviceProxyMgr;
import com.tencent.device.file.DevAudioMsgProcessor;
import com.tencent.device.file.DeviceAVFileMsgObserver;
import com.tencent.device.file.DeviceFileHandler;
import com.tencent.device.msg.data.DevSingleStructMsgProcessor;
import com.tencent.device.msg.data.DeviceComnFileMsgProcessor;
import com.tencent.device.msg.data.DeviceMsgHandle;
import com.tencent.device.msg.data.MessageForDevPtt;
import com.tencent.device.utils.LightAppSettingInfo;
import com.tencent.device.utils.LightAppUtil;
import com.tencent.device.utils.SmartDeviceReport;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.PlusPanelUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.panel.AIOPanelUtiles;
import com.tencent.mobileqq.activity.aio.panel.PanelIconLinearLayout;
import com.tencent.mobileqq.activity.aio.tips.TipsManager;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.emoticonview.EmoticonMainPanel;
import com.tencent.mobileqq.equipmentlock.EquipmentLockImpl;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter.fileAssistantReportData;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.pic.PicBusiManager;
import com.tencent.mobileqq.pic.PicPreDownloadUtils;
import com.tencent.mobileqq.pic.PicReq;
import com.tencent.mobileqq.ptt.PttBuffer;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.streamtransfile.StreamDataManager;
import com.tencent.mobileqq.utils.AlbumConstants;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.PerformanceReportUtils;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.QQRecorder;
import com.tencent.mobileqq.utils.QQRecorder.RecorderParam;
import com.tencent.mobileqq.utils.RecordParams;
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
import vrz;
import vsc;
import vsd;
import vse;
import vsf;

public class DeviceMsgChatPie
  extends BaseChatPie
{
  public static boolean S;
  public static ConcurrentHashMap a;
  static int p;
  static int q;
  static int r;
  boolean O = false;
  public volatile boolean P;
  boolean Q = false;
  boolean R = false;
  boolean T = false;
  boolean U = false;
  private boolean V;
  BroadcastReceiver a;
  public Boolean a;
  public String f = "";
  public int m;
  int jdField_n_of_type_Int = 0;
  private ImageView jdField_n_of_type_AndroidWidgetImageView;
  int o;
  
  static
  {
    jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap(20);
    p = 100100;
    jdField_q_of_type_Int = 10;
    jdField_r_of_type_Int = 11;
  }
  
  public DeviceMsgChatPie(QQAppInterface paramQQAppInterface, ViewGroup paramViewGroup, FragmentActivity paramFragmentActivity, Context paramContext)
  {
    super(paramQQAppInterface, paramViewGroup, paramFragmentActivity, paramContext);
    this.jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(false);
    this.jdField_o_of_type_Int = 0;
    this.jdField_a_of_type_AndroidContentBroadcastReceiver = new vse(this);
  }
  
  public static void a(int paramInt, MessageRecord paramMessageRecord)
  {
    jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(paramInt), paramMessageRecord);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, ArrayList paramArrayList, String paramString2)
  {
    Bundle localBundle = new Bundle();
    try
    {
      paramString2 = new JSONObject(paramString2);
      int i = paramString2.optInt("num", 1);
      int j = paramString2.optInt("face", 1);
      int k = paramString2.optInt("mediaSize", 1);
      int i1 = paramString2.optInt("mediaType", 1);
      int i2 = paramString2.optInt("scaling", 1);
      int i3 = paramString2.optInt("orientation", 1);
      int i4 = paramString2.optInt("color", 1);
      int i5 = paramString2.optInt("quality", 1);
      localBundle.putInt("copies", i);
      localBundle.putInt("duplexMode", j);
      localBundle.putInt("mediaSize", k);
      localBundle.putInt("mediaType", i1);
      localBundle.putInt("scaling", i2);
      localBundle.putInt("orientation", i3);
      localBundle.putInt("color", i4);
      localBundle.putInt("quality", i5);
      ((DeviceMsgHandle)paramQQAppInterface.a(49)).a().a(DeviceMsgHandle.c, paramString1, paramArrayList, localBundle);
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
  
  private void l(Intent paramIntent)
  {
    this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a();
    Object localObject1 = paramIntent.getExtras().getStringArrayList("PhotoConst.PHOTO_PATHS");
    int k = paramIntent.getExtras().getInt("PhotoConst.SEND_SIZE_SPEC", 0);
    int j = 0;
    Object localObject2 = (SmartDeviceProxyMgr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(51);
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
    long l = 0L;
    j = 0;
    if (localDeviceInfo != null)
    {
      l = localDeviceInfo.din;
      j = localDeviceInfo.productId;
    }
    if ((i == 0) && (this.jdField_n_of_type_Int != 4) && (this.jdField_n_of_type_Int != 3))
    {
      paramIntent = (DeviceMsgHandle)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(49);
      SmartDeviceReport.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, l, "Usr_AIO_SendMsg", 7, 0, j);
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
        if ((this.jdField_n_of_type_Int == 4) || (this.jdField_n_of_type_Int == 3))
        {
          paramIntent = (SmartDeviceProxyMgr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(51);
          paramIntent = ((List)localObject1).iterator();
          while (paramIntent.hasNext()) {
            ((SmartDeviceProxyMgr)localObject2).a((String)paramIntent.next(), 2154);
          }
          if (QLog.isColorLevel()) {
            QLog.d("DeviceMsgChatPie", 2, "prcessExtraData: send:" + ((List)localObject1).size());
          }
          A();
          return;
        }
        if (this.jdField_n_of_type_Int != 9) {
          break;
        }
      } while (((ArrayList)localObject3).size() <= 0);
      localObject1 = new Intent();
      ((Intent)localObject1).putParcelableArrayListExtra("sFilesSelected", (ArrayList)localObject3);
      ((Intent)localObject1).putExtra("sIsCloudPrinter", true);
      ((Intent)localObject1).putExtra("device_info", localDeviceInfo);
      ((Intent)localObject1).putExtra(AlbumConstants.h, paramIntent.getIntExtra(AlbumConstants.h, -1));
      ((Intent)localObject1).putExtra("filetype", "pic");
      ((Intent)localObject1).putExtra("url", "http://qzs.qq.com/open/mobile/iot_print/html/printOpt.html");
      SmartDevicePluginLoader.a().a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), (Intent)localObject1, "com.tencent.device.activities.LightPinterOptionActivity", 102, null, SmartDevicePluginProxyActivity.class);
      return;
      localObject2 = (DeviceMsgHandle)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(49);
      if ((S) && (this.R))
      {
        ((DeviceMsgHandle)localObject2).a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, (List)localObject1);
        SmartDeviceReport.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, l, "Usr_AIO_SendGroupMsg", 3, 0, j);
        return;
      }
      if (!this.U) {
        break;
      }
    } while (((ArrayList)localObject3).size() <= 0);
    localObject1 = new Intent();
    ((Intent)localObject1).putParcelableArrayListExtra("sFilesSelected", (ArrayList)localObject3);
    ((Intent)localObject1).putExtra("sIsCloudPrinter", true);
    ((Intent)localObject1).putExtra("device_info", localDeviceInfo);
    ((Intent)localObject1).putExtra(AlbumConstants.h, paramIntent.getIntExtra(AlbumConstants.h, -1));
    ((Intent)localObject1).putExtra("filetype", "pic");
    ((Intent)localObject1).putExtra("url", "http://qzs.qq.com/open/mobile/iot_print/html/printOpt.html");
    SmartDevicePluginLoader.a().a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), (Intent)localObject1, "com.tencent.device.activities.LightPinterOptionActivity", 102, null, SmartDevicePluginProxyActivity.class);
    return;
    if (k == 2)
    {
      b((List)localObject1);
      return;
    }
    c((List)localObject1);
  }
  
  private void m(Intent paramIntent)
  {
    if (!((DeviceFileHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(50)).a(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))) {
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, "打印机离线，无法打印", 2000).a();
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
      paramIntent = DialogUtil.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 230, this.jdField_a_of_type_AndroidContentContext.getString(2131429769), this.jdField_a_of_type_AndroidContentContext.getString(2131429774), "不要", "要", new vsc(this, localArrayList, paramIntent), new vsd(this));
    } while (paramIntent.isShowing());
    paramIntent.show();
    return;
    a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, localArrayList, paramIntent);
  }
  
  public boolean A()
  {
    Object localObject = (SmartDeviceProxyMgr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(51);
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
  
  public boolean B()
  {
    Object localObject = (SmartDeviceProxyMgr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(51);
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
  
  protected void G()
  {
    super.G();
    if ((this.jdField_n_of_type_Int == 3) || (this.jdField_n_of_type_Int == 4))
    {
      if (!this.T) {
        this.T = true;
      }
    }
    else {
      return;
    }
    super.A();
  }
  
  protected void H()
  {
    PerformanceReportUtils.a();
    AIOUtils.a(false);
    this.i = false;
    this.k = true;
    this.l = false;
    this.jdField_n_of_type_Boolean = false;
    this.jdField_o_of_type_Boolean = false;
    this.jdField_q_of_type_Boolean = false;
    this.jdField_r_of_type_Boolean = false;
    this.H = true;
    this.I = false;
    this.jdField_a_of_type_Boolean = true;
    this.jdField_b_of_type_Boolean = false;
    if (this.jdField_b_of_type_AndroidWidgetRelativeLayout != null)
    {
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.removeAllViews();
      this.jdField_g_of_type_AndroidWidgetTextView = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager.a();
    }
    if (this.jdField_g_of_type_AndroidViewView != null)
    {
      this.jdField_g_of_type_AndroidViewView.setVisibility(4);
      this.jdField_g_of_type_AndroidViewView = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.e();
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel = null;
    }
    if (this.jdField_a_of_type_ComTencentWidgetXPanelContainer != null)
    {
      this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a();
      this.jdField_a_of_type_ComTencentWidgetXPanelContainer.b();
    }
  }
  
  public QQRecorder.RecorderParam a()
  {
    Object localObject = ((SmartDeviceProxyMgr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(51)).a(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString));
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
        localObject = new QQRecorder.RecorderParam(RecordParams.b, 16000, 1);
        return localObject;
      }
    }
    catch (JSONException localJSONException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("DeviceMsgChatPie", 2, "getString from json JSONException error:" + localJSONException.getMessage());
      }
      return new QQRecorder.RecorderParam(RecordParams.jdField_a_of_type_Int, 0, 0);
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("DeviceMsgChatPie", 2, "getString from json Exception error:" + localException.getMessage());
        }
      }
    }
  }
  
  /* Error */
  protected void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    // Byte code:
    //   0: aload_0
    //   1: iload_1
    //   2: iload_2
    //   3: aload_3
    //   4: invokespecial 600	com/tencent/mobileqq/activity/BaseChatPie:a	(IILandroid/content/Intent;)V
    //   7: bipush 84
    //   9: iload_1
    //   10: if_icmpne +190 -> 200
    //   13: aload_3
    //   14: ifnull +186 -> 200
    //   17: aload_0
    //   18: getfield 249	com/tencent/mobileqq/activity/aio/rebuild/DeviceMsgChatPie:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   21: bipush 51
    //   23: invokevirtual 142	com/tencent/mobileqq/app/QQAppInterface:a	(I)Lcom/tencent/mobileqq/app/BusinessHandler;
    //   26: checkcast 251	com/tencent/device/devicemgr/SmartDeviceProxyMgr
    //   29: aload_0
    //   30: getfield 254	com/tencent/mobileqq/activity/aio/rebuild/DeviceMsgChatPie:jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo	Lcom/tencent/mobileqq/activity/aio/SessionInfo;
    //   33: getfield 258	com/tencent/mobileqq/activity/aio/SessionInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   36: invokestatic 264	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   39: invokevirtual 267	com/tencent/device/devicemgr/SmartDeviceProxyMgr:a	(J)Lcom/tencent/device/datadef/DeviceInfo;
    //   42: astore 9
    //   44: aload_3
    //   45: ldc_w 325
    //   48: invokevirtual 413	android/content/Intent:getParcelableArrayListExtra	(Ljava/lang/String;)Ljava/util/ArrayList;
    //   51: astore 10
    //   53: new 231	android/content/Intent
    //   56: dup
    //   57: invokespecial 323	android/content/Intent:<init>	()V
    //   60: astore 11
    //   62: aload 11
    //   64: ldc_w 325
    //   67: aload 10
    //   69: invokevirtual 329	android/content/Intent:putParcelableArrayListExtra	(Ljava/lang/String;Ljava/util/ArrayList;)Landroid/content/Intent;
    //   72: pop
    //   73: aload 11
    //   75: ldc_w 331
    //   78: iconst_1
    //   79: invokevirtual 335	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   82: pop
    //   83: aload 11
    //   85: ldc_w 337
    //   88: aload 9
    //   90: invokevirtual 340	android/content/Intent:putExtra	(Ljava/lang/String;Landroid/os/Parcelable;)Landroid/content/Intent;
    //   93: pop
    //   94: aload 11
    //   96: ldc_w 360
    //   99: ldc_w 362
    //   102: invokevirtual 358	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   105: pop
    //   106: aload 11
    //   108: ldc_w 353
    //   111: ldc_w 602
    //   114: invokevirtual 358	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   117: pop
    //   118: invokestatic 367	cooperation/smartdevice/SmartDevicePluginLoader:a	()Lcooperation/smartdevice/SmartDevicePluginLoader;
    //   121: aload_0
    //   122: getfield 370	com/tencent/mobileqq/activity/aio/rebuild/DeviceMsgChatPie:jdField_a_of_type_AndroidSupportV4AppFragmentActivity	Landroid/support/v4/app/FragmentActivity;
    //   125: aload_0
    //   126: getfield 249	com/tencent/mobileqq/activity/aio/rebuild/DeviceMsgChatPie:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   129: aload_0
    //   130: getfield 249	com/tencent/mobileqq/activity/aio/rebuild/DeviceMsgChatPie:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   133: invokevirtual 373	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   136: aload 11
    //   138: ldc_w 375
    //   141: bipush 102
    //   143: aconst_null
    //   144: ldc_w 377
    //   147: invokevirtual 380	cooperation/smartdevice/SmartDevicePluginLoader:a	(Landroid/app/Activity;Lmqq/app/AppRuntime;Ljava/lang/String;Landroid/content/Intent;Ljava/lang/String;ILandroid/content/DialogInterface$OnDismissListener;Ljava/lang/Class;)V
    //   150: iload_1
    //   151: tableswitch	default:+25 -> 176, 81:+599->750, 82:+25->176, 83:+667->818
    //   177: getfield 64	com/tencent/mobileqq/activity/aio/rebuild/DeviceMsgChatPie:jdField_n_of_type_Int	I
    //   180: iconst_4
    //   181: if_icmpne +18 -> 199
    //   184: iload_2
    //   185: iconst_m1
    //   186: if_icmpne +13 -> 199
    //   189: iload_1
    //   190: iconst_1
    //   191: if_icmpne +8 -> 199
    //   194: aload_0
    //   195: iconst_0
    //   196: putfield 72	com/tencent/mobileqq/activity/aio/rebuild/DeviceMsgChatPie:T	Z
    //   199: return
    //   200: iload_1
    //   201: bipush 102
    //   203: if_icmpne +20 -> 223
    //   206: iload_2
    //   207: iconst_m1
    //   208: if_icmpne -58 -> 150
    //   211: aload_3
    //   212: ifnull -62 -> 150
    //   215: aload_0
    //   216: aload_3
    //   217: invokespecial 604	com/tencent/mobileqq/activity/aio/rebuild/DeviceMsgChatPie:m	(Landroid/content/Intent;)V
    //   220: goto -70 -> 150
    //   223: bipush 81
    //   225: iload_1
    //   226: if_icmpeq +9 -> 235
    //   229: bipush 83
    //   231: iload_1
    //   232: if_icmpne +438 -> 670
    //   235: aload_0
    //   236: getfield 249	com/tencent/mobileqq/activity/aio/rebuild/DeviceMsgChatPie:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   239: bipush 51
    //   241: invokevirtual 142	com/tencent/mobileqq/app/QQAppInterface:a	(I)Lcom/tencent/mobileqq/app/BusinessHandler;
    //   244: checkcast 251	com/tencent/device/devicemgr/SmartDeviceProxyMgr
    //   247: astore 10
    //   249: aload 10
    //   251: aload_0
    //   252: getfield 254	com/tencent/mobileqq/activity/aio/rebuild/DeviceMsgChatPie:jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo	Lcom/tencent/mobileqq/activity/aio/SessionInfo;
    //   255: getfield 258	com/tencent/mobileqq/activity/aio/SessionInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   258: invokestatic 264	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   261: invokevirtual 267	com/tencent/device/devicemgr/SmartDeviceProxyMgr:a	(J)Lcom/tencent/device/datadef/DeviceInfo;
    //   264: astore 9
    //   266: aload 9
    //   268: ifnull +822 -> 1090
    //   271: aload 10
    //   273: aload 9
    //   275: getfield 272	com/tencent/device/datadef/DeviceInfo:productId	I
    //   278: invokevirtual 275	com/tencent/device/devicemgr/SmartDeviceProxyMgr:a	(I)Lcom/tencent/device/datadef/ProductInfo;
    //   281: astore 10
    //   283: aload 10
    //   285: ifnull +805 -> 1090
    //   288: aload 10
    //   290: iconst_2
    //   291: invokevirtual 281	com/tencent/device/datadef/ProductInfo:isSupportFuncMsgType	(I)Z
    //   294: ifeq +796 -> 1090
    //   297: iconst_1
    //   298: istore 4
    //   300: lconst_0
    //   301: lstore 6
    //   303: iconst_0
    //   304: istore 5
    //   306: aload 9
    //   308: ifnull +17 -> 325
    //   311: aload 9
    //   313: getfield 284	com/tencent/device/datadef/DeviceInfo:din	J
    //   316: lstore 6
    //   318: aload 9
    //   320: getfield 272	com/tencent/device/datadef/DeviceInfo:productId	I
    //   323: istore 5
    //   325: iload 4
    //   327: ifne +34 -> 361
    //   330: aload_0
    //   331: getfield 249	com/tencent/mobileqq/activity/aio/rebuild/DeviceMsgChatPie:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   334: bipush 49
    //   336: invokevirtual 142	com/tencent/mobileqq/app/QQAppInterface:a	(I)Lcom/tencent/mobileqq/app/BusinessHandler;
    //   339: checkcast 144	com/tencent/device/msg/data/DeviceMsgHandle
    //   342: astore_3
    //   343: aload_0
    //   344: getfield 249	com/tencent/mobileqq/activity/aio/rebuild/DeviceMsgChatPie:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   347: lload 6
    //   349: ldc_w 286
    //   352: bipush 7
    //   354: iconst_0
    //   355: iload 5
    //   357: invokestatic 291	com/tencent/device/utils/SmartDeviceReport:a	(Lmqq/app/AppRuntime;JLjava/lang/String;III)V
    //   360: return
    //   361: aload_0
    //   362: getfield 370	com/tencent/mobileqq/activity/aio/rebuild/DeviceMsgChatPie:jdField_a_of_type_AndroidSupportV4AppFragmentActivity	Landroid/support/v4/app/FragmentActivity;
    //   365: aload_0
    //   366: getfield 254	com/tencent/mobileqq/activity/aio/rebuild/DeviceMsgChatPie:jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo	Lcom/tencent/mobileqq/activity/aio/SessionInfo;
    //   369: getfield 258	com/tencent/mobileqq/activity/aio/SessionInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   372: aconst_null
    //   373: ldc_w 606
    //   376: iconst_1
    //   377: invokestatic 612	com/tencent/mobileqq/msf/sdk/SettingCloneUtil:readValue	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)Z
    //   380: istore 8
    //   382: getstatic 382	com/tencent/mobileqq/activity/aio/rebuild/DeviceMsgChatPie:S	Z
    //   385: ifeq +58 -> 443
    //   388: iload 8
    //   390: ifeq +53 -> 443
    //   393: aload_0
    //   394: getfield 249	com/tencent/mobileqq/activity/aio/rebuild/DeviceMsgChatPie:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   397: bipush 49
    //   399: invokevirtual 142	com/tencent/mobileqq/app/QQAppInterface:a	(I)Lcom/tencent/mobileqq/app/BusinessHandler;
    //   402: checkcast 144	com/tencent/device/msg/data/DeviceMsgHandle
    //   405: aload_0
    //   406: getfield 254	com/tencent/mobileqq/activity/aio/rebuild/DeviceMsgChatPie:jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo	Lcom/tencent/mobileqq/activity/aio/SessionInfo;
    //   409: getfield 258	com/tencent/mobileqq/activity/aio/SessionInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   412: ldc_w 614
    //   415: invokestatic 619	com/tencent/mobileqq/service/message/MessageCache:a	()J
    //   418: iconst_1
    //   419: iconst_0
    //   420: iconst_1
    //   421: invokevirtual 622	com/tencent/device/msg/data/DeviceMsgHandle:a	(Ljava/lang/String;Ljava/lang/String;JZZZ)V
    //   424: aload_0
    //   425: getfield 370	com/tencent/mobileqq/activity/aio/rebuild/DeviceMsgChatPie:jdField_a_of_type_AndroidSupportV4AppFragmentActivity	Landroid/support/v4/app/FragmentActivity;
    //   428: aload_0
    //   429: getfield 254	com/tencent/mobileqq/activity/aio/rebuild/DeviceMsgChatPie:jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo	Lcom/tencent/mobileqq/activity/aio/SessionInfo;
    //   432: getfield 258	com/tencent/mobileqq/activity/aio/SessionInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   435: aconst_null
    //   436: ldc_w 606
    //   439: iconst_0
    //   440: invokestatic 626	com/tencent/mobileqq/msf/sdk/SettingCloneUtil:writeValue	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V
    //   443: getstatic 631	android/os/Build$VERSION:SDK_INT	I
    //   446: bipush 10
    //   448: if_icmpgt -298 -> 150
    //   451: aconst_null
    //   452: astore 10
    //   454: aload_0
    //   455: getfield 370	com/tencent/mobileqq/activity/aio/rebuild/DeviceMsgChatPie:jdField_a_of_type_AndroidSupportV4AppFragmentActivity	Landroid/support/v4/app/FragmentActivity;
    //   458: invokevirtual 637	android/support/v4/app/FragmentActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   461: aload_3
    //   462: invokevirtual 641	android/content/Intent:getData	()Landroid/net/Uri;
    //   465: ldc_w 642
    //   468: invokevirtual 648	android/content/ContentResolver:openAssetFileDescriptor	(Landroid/net/Uri;Ljava/lang/String;)Landroid/content/res/AssetFileDescriptor;
    //   471: astore 9
    //   473: aload 9
    //   475: ifnull +135 -> 610
    //   478: aload 9
    //   480: invokevirtual 654	android/content/res/AssetFileDescriptor:createInputStream	()Ljava/io/FileInputStream;
    //   483: astore 9
    //   485: new 656	java/io/FileOutputStream
    //   488: dup
    //   489: new 658	java/io/File
    //   492: dup
    //   493: aload_0
    //   494: getfield 370	com/tencent/mobileqq/activity/aio/rebuild/DeviceMsgChatPie:jdField_a_of_type_AndroidSupportV4AppFragmentActivity	Landroid/support/v4/app/FragmentActivity;
    //   497: invokevirtual 662	android/support/v4/app/FragmentActivity:getApplicationContext	()Landroid/content/Context;
    //   500: invokestatic 668	android/preference/PreferenceManager:getDefaultSharedPreferences	(Landroid/content/Context;)Landroid/content/SharedPreferences;
    //   503: ldc_w 670
    //   506: ldc 52
    //   508: invokeinterface 674 3 0
    //   513: invokespecial 675	java/io/File:<init>	(Ljava/lang/String;)V
    //   516: invokespecial 678	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   519: astore 11
    //   521: sipush 1024
    //   524: newarray byte
    //   526: astore 13
    //   528: aload 9
    //   530: aload 13
    //   532: invokevirtual 684	java/io/FileInputStream:read	([B)I
    //   535: istore 4
    //   537: aload 11
    //   539: astore 12
    //   541: aload 9
    //   543: astore 10
    //   545: iload 4
    //   547: ifle +69 -> 616
    //   550: aload 11
    //   552: aload 13
    //   554: iconst_0
    //   555: iload 4
    //   557: invokevirtual 688	java/io/FileOutputStream:write	([BII)V
    //   560: goto -32 -> 528
    //   563: astore 12
    //   565: aload 9
    //   567: astore 10
    //   569: aload 11
    //   571: astore 9
    //   573: aload 12
    //   575: astore 11
    //   577: aload 11
    //   579: invokevirtual 691	java/lang/Exception:printStackTrace	()V
    //   582: aload 10
    //   584: ifnull +8 -> 592
    //   587: aload 10
    //   589: invokevirtual 694	java/io/FileInputStream:close	()V
    //   592: aload 9
    //   594: ifnull -444 -> 150
    //   597: aload 9
    //   599: invokevirtual 695	java/io/FileOutputStream:close	()V
    //   602: goto -452 -> 150
    //   605: astore 9
    //   607: goto -457 -> 150
    //   610: aconst_null
    //   611: astore 10
    //   613: aconst_null
    //   614: astore 12
    //   616: aload 10
    //   618: ifnull +8 -> 626
    //   621: aload 10
    //   623: invokevirtual 694	java/io/FileInputStream:close	()V
    //   626: aload 12
    //   628: ifnull -478 -> 150
    //   631: aload 12
    //   633: invokevirtual 695	java/io/FileOutputStream:close	()V
    //   636: goto -486 -> 150
    //   639: astore 9
    //   641: goto -491 -> 150
    //   644: astore_3
    //   645: aconst_null
    //   646: astore 9
    //   648: aload 9
    //   650: ifnull +8 -> 658
    //   653: aload 9
    //   655: invokevirtual 694	java/io/FileInputStream:close	()V
    //   658: aload 10
    //   660: ifnull +8 -> 668
    //   663: aload 10
    //   665: invokevirtual 695	java/io/FileOutputStream:close	()V
    //   668: aload_3
    //   669: athrow
    //   670: iload_1
    //   671: getstatic 40	com/tencent/mobileqq/activity/aio/rebuild/DeviceMsgChatPie:p	I
    //   674: if_icmpne -524 -> 150
    //   677: iload_2
    //   678: getstatic 42	com/tencent/mobileqq/activity/aio/rebuild/DeviceMsgChatPie:jdField_q_of_type_Int	I
    //   681: if_icmpne +54 -> 735
    //   684: aload_0
    //   685: invokevirtual 321	com/tencent/mobileqq/activity/aio/rebuild/DeviceMsgChatPie:A	()V
    //   688: aload_0
    //   689: getfield 249	com/tencent/mobileqq/activity/aio/rebuild/DeviceMsgChatPie:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   692: bipush 51
    //   694: invokevirtual 142	com/tencent/mobileqq/app/QQAppInterface:a	(I)Lcom/tencent/mobileqq/app/BusinessHandler;
    //   697: checkcast 251	com/tencent/device/devicemgr/SmartDeviceProxyMgr
    //   700: aload_0
    //   701: getfield 254	com/tencent/mobileqq/activity/aio/rebuild/DeviceMsgChatPie:jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo	Lcom/tencent/mobileqq/activity/aio/SessionInfo;
    //   704: getfield 258	com/tencent/mobileqq/activity/aio/SessionInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   707: invokestatic 264	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   710: invokevirtual 267	com/tencent/device/devicemgr/SmartDeviceProxyMgr:a	(J)Lcom/tencent/device/datadef/DeviceInfo;
    //   713: invokestatic 700	com/tencent/device/utils/SmartDeviceUtil:a	(Lcom/tencent/device/datadef/DeviceInfo;)Ljava/lang/String;
    //   716: astore 9
    //   718: aload 9
    //   720: ifnull -570 -> 150
    //   723: aload_0
    //   724: getfield 702	com/tencent/mobileqq/activity/aio/rebuild/DeviceMsgChatPie:jdField_d_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   727: aload 9
    //   729: invokevirtual 708	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   732: goto -582 -> 150
    //   735: iload_2
    //   736: getstatic 44	com/tencent/mobileqq/activity/aio/rebuild/DeviceMsgChatPie:jdField_r_of_type_Int	I
    //   739: if_icmpne -51 -> 688
    //   742: aload_0
    //   743: iconst_1
    //   744: putfield 189	com/tencent/mobileqq/activity/aio/rebuild/DeviceMsgChatPie:V	Z
    //   747: goto -59 -> 688
    //   750: iload_2
    //   751: iconst_m1
    //   752: if_icmpne -576 -> 176
    //   755: aload_3
    //   756: ifnull -580 -> 176
    //   759: aload_3
    //   760: ldc_w 710
    //   763: invokevirtual 413	android/content/Intent:getParcelableArrayListExtra	(Ljava/lang/String;)Ljava/util/ArrayList;
    //   766: astore_3
    //   767: aload_3
    //   768: ifnull -592 -> 176
    //   771: aload_3
    //   772: invokevirtual 322	java/util/ArrayList:size	()I
    //   775: ifle -599 -> 176
    //   778: aload_0
    //   779: aload_3
    //   780: iconst_0
    //   781: invokevirtual 713	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   784: checkcast 715	com/dataline/util/file/SendInfo
    //   787: invokevirtual 717	com/dataline/util/file/SendInfo:a	()Ljava/lang/String;
    //   790: putfield 54	com/tencent/mobileqq/activity/aio/rebuild/DeviceMsgChatPie:f	Ljava/lang/String;
    //   793: aload_0
    //   794: getfield 249	com/tencent/mobileqq/activity/aio/rebuild/DeviceMsgChatPie:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   797: aload_0
    //   798: getfield 370	com/tencent/mobileqq/activity/aio/rebuild/DeviceMsgChatPie:jdField_a_of_type_AndroidSupportV4AppFragmentActivity	Landroid/support/v4/app/FragmentActivity;
    //   801: aload_0
    //   802: getfield 254	com/tencent/mobileqq/activity/aio/rebuild/DeviceMsgChatPie:jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo	Lcom/tencent/mobileqq/activity/aio/SessionInfo;
    //   805: getfield 258	com/tencent/mobileqq/activity/aio/SessionInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   808: aload_0
    //   809: getfield 54	com/tencent/mobileqq/activity/aio/rebuild/DeviceMsgChatPie:f	Ljava/lang/String;
    //   812: invokestatic 722	com/tencent/device/file/DevVideoMsgProcessor:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V
    //   815: goto -639 -> 176
    //   818: aload_0
    //   819: aload_0
    //   820: getfield 370	com/tencent/mobileqq/activity/aio/rebuild/DeviceMsgChatPie:jdField_a_of_type_AndroidSupportV4AppFragmentActivity	Landroid/support/v4/app/FragmentActivity;
    //   823: invokevirtual 662	android/support/v4/app/FragmentActivity:getApplicationContext	()Landroid/content/Context;
    //   826: invokestatic 668	android/preference/PreferenceManager:getDefaultSharedPreferences	(Landroid/content/Context;)Landroid/content/SharedPreferences;
    //   829: ldc_w 670
    //   832: ldc 52
    //   834: invokeinterface 674 3 0
    //   839: putfield 54	com/tencent/mobileqq/activity/aio/rebuild/DeviceMsgChatPie:f	Ljava/lang/String;
    //   842: aload_0
    //   843: getfield 370	com/tencent/mobileqq/activity/aio/rebuild/DeviceMsgChatPie:jdField_a_of_type_AndroidSupportV4AppFragmentActivity	Landroid/support/v4/app/FragmentActivity;
    //   846: invokevirtual 662	android/support/v4/app/FragmentActivity:getApplicationContext	()Landroid/content/Context;
    //   849: invokestatic 668	android/preference/PreferenceManager:getDefaultSharedPreferences	(Landroid/content/Context;)Landroid/content/SharedPreferences;
    //   852: invokeinterface 726 1 0
    //   857: ldc_w 670
    //   860: invokeinterface 732 2 0
    //   865: invokeinterface 735 1 0
    //   870: pop
    //   871: iload_2
    //   872: iconst_m1
    //   873: if_icmpne +130 -> 1003
    //   876: aload_0
    //   877: getfield 54	com/tencent/mobileqq/activity/aio/rebuild/DeviceMsgChatPie:f	Ljava/lang/String;
    //   880: invokestatic 564	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   883: ifne -707 -> 176
    //   886: aload_0
    //   887: getfield 370	com/tencent/mobileqq/activity/aio/rebuild/DeviceMsgChatPie:jdField_a_of_type_AndroidSupportV4AppFragmentActivity	Landroid/support/v4/app/FragmentActivity;
    //   890: sipush 230
    //   893: invokestatic 738	com/tencent/mobileqq/utils/DialogUtil:a	(Landroid/content/Context;I)Lcom/tencent/mobileqq/utils/QQCustomDialog;
    //   896: astore_3
    //   897: aload_3
    //   898: ldc_w 739
    //   901: new 741	vsa
    //   904: dup
    //   905: aload_0
    //   906: invokespecial 742	vsa:<init>	(Lcom/tencent/mobileqq/activity/aio/rebuild/DeviceMsgChatPie;)V
    //   909: invokevirtual 746	com/tencent/mobileqq/utils/QQCustomDialog:setNegativeButton	(ILandroid/content/DialogInterface$OnClickListener;)Lcom/tencent/mobileqq/utils/QQCustomDialog;
    //   912: pop
    //   913: aload_3
    //   914: ldc_w 747
    //   917: new 749	vsb
    //   920: dup
    //   921: aload_0
    //   922: invokespecial 750	vsb:<init>	(Lcom/tencent/mobileqq/activity/aio/rebuild/DeviceMsgChatPie;)V
    //   925: invokevirtual 753	com/tencent/mobileqq/utils/QQCustomDialog:setPositiveButton	(ILandroid/content/DialogInterface$OnClickListener;)Lcom/tencent/mobileqq/utils/QQCustomDialog;
    //   928: pop
    //   929: aload_3
    //   930: ldc_w 755
    //   933: invokevirtual 759	com/tencent/mobileqq/utils/QQCustomDialog:setTitle	(Ljava/lang/String;)Lcom/tencent/mobileqq/utils/QQCustomDialog;
    //   936: pop
    //   937: new 658	java/io/File
    //   940: dup
    //   941: aload_0
    //   942: getfield 54	com/tencent/mobileqq/activity/aio/rebuild/DeviceMsgChatPie:f	Ljava/lang/String;
    //   945: invokespecial 675	java/io/File:<init>	(Ljava/lang/String;)V
    //   948: astore 9
    //   950: aload_0
    //   951: getfield 370	com/tencent/mobileqq/activity/aio/rebuild/DeviceMsgChatPie:jdField_a_of_type_AndroidSupportV4AppFragmentActivity	Landroid/support/v4/app/FragmentActivity;
    //   954: aload 9
    //   956: invokevirtual 762	java/io/File:length	()J
    //   959: invokestatic 767	com/tencent/mobileqq/shortvideo/ShortVideoUtils:a	(Landroid/content/Context;J)Ljava/lang/String;
    //   962: astore 9
    //   964: aload_3
    //   965: new 165	java/lang/StringBuilder
    //   968: dup
    //   969: invokespecial 166	java/lang/StringBuilder:<init>	()V
    //   972: ldc_w 769
    //   975: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   978: aload 9
    //   980: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   983: ldc_w 771
    //   986: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   989: invokevirtual 179	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   992: invokevirtual 775	com/tencent/mobileqq/utils/QQCustomDialog:setMessage	(Ljava/lang/CharSequence;)Lcom/tencent/mobileqq/utils/QQCustomDialog;
    //   995: pop
    //   996: aload_3
    //   997: invokevirtual 460	com/tencent/mobileqq/utils/QQCustomDialog:show	()V
    //   1000: goto -824 -> 176
    //   1003: aload_0
    //   1004: getfield 54	com/tencent/mobileqq/activity/aio/rebuild/DeviceMsgChatPie:f	Ljava/lang/String;
    //   1007: invokestatic 564	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1010: ifne +11 -> 1021
    //   1013: aload_0
    //   1014: getfield 54	com/tencent/mobileqq/activity/aio/rebuild/DeviceMsgChatPie:f	Ljava/lang/String;
    //   1017: invokestatic 780	com/tencent/mobileqq/utils/FileUtils:d	(Ljava/lang/String;)Z
    //   1020: pop
    //   1021: aload_0
    //   1022: ldc 52
    //   1024: putfield 54	com/tencent/mobileqq/activity/aio/rebuild/DeviceMsgChatPie:f	Ljava/lang/String;
    //   1027: goto -851 -> 176
    //   1030: astore 9
    //   1032: goto -364 -> 668
    //   1035: astore_3
    //   1036: goto -388 -> 648
    //   1039: astore_3
    //   1040: aload 11
    //   1042: astore 10
    //   1044: goto -396 -> 648
    //   1047: astore_3
    //   1048: aload 10
    //   1050: astore 11
    //   1052: aload 9
    //   1054: astore 10
    //   1056: aload 11
    //   1058: astore 9
    //   1060: goto -412 -> 648
    //   1063: astore 11
    //   1065: aconst_null
    //   1066: astore 10
    //   1068: aconst_null
    //   1069: astore 9
    //   1071: goto -494 -> 577
    //   1074: astore 11
    //   1076: aconst_null
    //   1077: astore 12
    //   1079: aload 9
    //   1081: astore 10
    //   1083: aload 12
    //   1085: astore 9
    //   1087: goto -510 -> 577
    //   1090: iconst_0
    //   1091: istore 4
    //   1093: goto -793 -> 300
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1096	0	this	DeviceMsgChatPie
    //   0	1096	1	paramInt1	int
    //   0	1096	2	paramInt2	int
    //   0	1096	3	paramIntent	Intent
    //   298	794	4	i	int
    //   304	52	5	j	int
    //   301	47	6	l	long
    //   380	9	8	bool	boolean
    //   42	556	9	localObject1	Object
    //   605	1	9	localException1	Exception
    //   639	1	9	localException2	Exception
    //   646	333	9	localObject2	Object
    //   1030	23	9	localException3	Exception
    //   1058	28	9	localObject3	Object
    //   51	1031	10	localObject4	Object
    //   60	997	11	localObject5	Object
    //   1063	1	11	localException4	Exception
    //   1074	1	11	localException5	Exception
    //   539	1	12	localObject6	Object
    //   563	11	12	localException6	Exception
    //   614	470	12	localObject7	Object
    //   526	27	13	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   521	528	563	java/lang/Exception
    //   528	537	563	java/lang/Exception
    //   550	560	563	java/lang/Exception
    //   587	592	605	java/lang/Exception
    //   597	602	605	java/lang/Exception
    //   621	626	639	java/lang/Exception
    //   631	636	639	java/lang/Exception
    //   454	473	644	finally
    //   478	485	644	finally
    //   653	658	1030	java/lang/Exception
    //   663	668	1030	java/lang/Exception
    //   485	521	1035	finally
    //   521	528	1039	finally
    //   528	537	1039	finally
    //   550	560	1039	finally
    //   577	582	1047	finally
    //   454	473	1063	java/lang/Exception
    //   478	485	1063	java/lang/Exception
    //   485	521	1074	java/lang/Exception
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
    do
    {
      for (;;)
      {
        super.a(paramObject);
        return;
        this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a();
        PlusPanelUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, a(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, 2, true);
        continue;
        this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a();
        h(false);
        continue;
        AIOPanelUtiles.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "0X800407C", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
        Object localObject = new FileManagerReporter.fileAssistantReportData();
        ((FileManagerReporter.fileAssistantReportData)localObject).b = "send_file";
        ((FileManagerReporter.fileAssistantReportData)localObject).jdField_a_of_type_Int = 1;
        FileManagerReporter.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), (FileManagerReporter.fileAssistantReportData)localObject);
        localObject = (SmartDeviceProxyMgr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(51);
        long l = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
        if ((localObject != null) && (((SmartDeviceProxyMgr)localObject).c(l)) && (((SmartDeviceProxyMgr)localObject).a(l, 17))) {
          PlusPanelUtils.d(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, a(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
        } else {
          PlusPanelUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, a(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
        }
      }
    } while (!this.U);
    PlusPanelUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, super.a(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, null, null);
  }
  
  public void a(String paramString)
  {
    if (this.O) {
      super.a(paramString);
    }
  }
  
  protected void a(String paramString, long paramLong, int paramInt1, int paramInt2, QQRecorder.RecorderParam paramRecorderParam, int paramInt3, boolean paramBoolean)
  {
    if (!this.O) {
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
        break label528;
      }
      paramInt1 = 0;
      paramRecorderParam = paramString;
      label53:
      if (paramInt1 >= VoiceTuneUtil.jdField_a_of_type_Int) {
        break label522;
      }
      paramRecorderParam = VoiceTuneUtil.a(paramString, paramInt1);
      if (!new File(paramRecorderParam).exists()) {
        break label306;
      }
      paramString = paramRecorderParam;
    }
    label522:
    label528:
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
      for (paramRecorderParam = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, paramLong);; paramRecorderParam = DevAudioMsgProcessor.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b, -2L))
      {
        if (paramRecorderParam == null) {
          break label350;
        }
        super.a(0, paramString, paramRecorderParam.uniseq);
        if ((!S) || (!this.R)) {
          break label467;
        }
        if ((NetworkUtil.d(BaseApplication.getContext())) || (!(paramRecorderParam instanceof MessageForDevPtt))) {
          break label352;
        }
        paramString = (MessageForDevPtt)paramRecorderParam;
        paramString.fileSize = -1L;
        paramString.extraflag = 32768;
        paramString.extStr = "device_groupchat";
        paramString.serial();
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString.frienduin, paramString.istroop, paramString.uniseq, paramString.msgData);
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
      localSmartDeviceProxyMgr = (SmartDeviceProxyMgr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(51);
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
      label467:
      ((DeviceMsgHandle)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(49)).a().a(DeviceMsgHandle.f, paramString, Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString), paramRecorderParam.uniseq, paramRecorderParam.istroop, QQRecorder.a(paramInt2));
      paramLong = paramRecorderParam.uniseq;
      return;
      paramString = paramRecorderParam;
    }
  }
  
  public void a(String paramString, boolean paramBoolean, QQRecorder.RecorderParam paramRecorderParam)
  {
    Object localObject2 = (SmartDeviceProxyMgr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(51);
    Object localObject1 = ((SmartDeviceProxyMgr)localObject2).a(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString));
    if (localObject1 != null)
    {
      localObject2 = ((SmartDeviceProxyMgr)localObject2).a(((DeviceInfo)localObject1).productId);
      if ((localObject2 == null) || (!((ProductInfo)localObject2).isSupportMainMsgType(2))) {}
    }
    for (boolean bool = true;; bool = false)
    {
      long l = 0L;
      int i = 0;
      if (localObject1 != null)
      {
        l = ((DeviceInfo)localObject1).din;
        i = ((DeviceInfo)localObject1).productId;
      }
      SmartDeviceReport.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, l, "Usr_AIO_SendMsg", 1, 0, i);
      this.O = bool;
      if (!bool)
      {
        paramString = (DeviceMsgHandle)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(49);
        SmartDeviceReport.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, l, "Usr_AIO_SendMsg", 7, 0, i);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("DeviceMsgChatPie", 2, "onRecorderPerpare path = " + paramString);
      }
      localObject1 = RecordParams.a(paramRecorderParam.c, paramRecorderParam.jdField_a_of_type_Int);
      if (paramRecorderParam.jdField_a_of_type_JavaLangObject == null)
      {
        i = 1;
        label203:
        if (i != 0) {
          break label274;
        }
        StreamDataManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramRecorderParam.c, paramString, 0, (int)(System.currentTimeMillis() / 1000L));
        StreamDataManager.a(paramString, (byte[])localObject1, localObject1.length, (short)0);
        label241:
        if (paramString == null) {
          break label290;
        }
        if (paramBoolean) {
          break label292;
        }
        this.jdField_c_of_type_Long = 0L;
        h(2131230744);
      }
      for (;;)
      {
        a(true, false);
        return;
        i = 0;
        break label203;
        label274:
        PttBuffer.a(paramString);
        PttBuffer.a(paramString, (byte[])localObject1, localObject1.length);
        break label241;
        label290:
        break;
        label292:
        paramString = DevAudioMsgProcessor.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b, -2L);
        if (i == 0) {
          paramString.setPttStreamFlag(10001);
        }
        if (paramString != null) {
          this.jdField_c_of_type_Long = paramString.uniseq;
        }
        h(2131230732);
      }
    }
  }
  
  protected boolean a(boolean paramBoolean)
  {
    this.C = false;
    this.I = false;
    if (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getExtras() == null) {
      super.A();
    }
    do
    {
      return true;
      super.a(paramBoolean);
    } while (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.isFinishing());
    Object localObject1 = (DeviceMsgHandle)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(49);
    ((DeviceMsgHandle)localObject1).a().a();
    ((DeviceMsgHandle)localObject1).a().a();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setAllEnable(false);
    if (VersionUtils.e()) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setAllAlpha(0.6F);
    }
    aX();
    localObject1 = new IntentFilter();
    ((IntentFilter)localObject1).addAction("SmartDevice_DeviceUnBindRst");
    ((IntentFilter)localObject1).addAction("SmartDevice_ProductFetchRst");
    ((IntentFilter)localObject1).addAction("SmartDevice_receiveVasFlagResult");
    ((IntentFilter)localObject1).addAction("SmartDevice_OnDataPointFileMsgProgress");
    ((IntentFilter)localObject1).addAction("SmartDevice_OnDataPointFileMsgSendRet");
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, (IntentFilter)localObject1);
    this.P = true;
    Object localObject2 = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getExtras();
    if (localObject2 != null)
    {
      this.jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(((Bundle)localObject2).getBoolean("bFromLightApp", false));
      this.jdField_n_of_type_Int = ((Bundle)localObject2).getInt("operType", 0);
      this.jdField_o_of_type_Int = ((Bundle)localObject2).getInt("jumpTab", 0);
    }
    localObject1 = (ImageView)this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131363474);
    if (localObject1 != null) {
      ((ImageView)localObject1).setImageResource(2130838728);
    }
    for (localObject1 = (RelativeLayout)((ImageView)localObject1).getParent();; localObject1 = null)
    {
      Object localObject3 = (ImageView)this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131364003);
      if (localObject3 != null)
      {
        ((ImageView)localObject3).setVisibility(0);
        ((ImageView)localObject3).setImageResource(2130838727);
        ((ImageView)localObject3).setOnClickListener(new vrz(this));
      }
      long l = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      localObject3 = (SmartDeviceProxyMgr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(51);
      if ((((SmartDeviceProxyMgr)localObject3).c(l)) && (((SmartDeviceProxyMgr)localObject3).a(l, 17)))
      {
        paramBoolean = true;
        this.U = paramBoolean;
        if (this.U) {
          ((SmartDeviceProxyMgr)localObject3).a(l, "", "", "", 0, null);
        }
        if (localObject2 != null)
        {
          localObject2 = ((Bundle)localObject2).getStringArrayList("PhotoConst.PHOTO_PATHS");
          if ((localObject2 != null) && (((List)localObject2).size() > 0)) {
            l(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent());
          }
          localObject2 = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getParcelableArrayListExtra("sFilesSelected");
          if ((localObject2 != null) && (((ArrayList)localObject2).size() > 0)) {
            m(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent());
          }
        }
        paramBoolean = BaseApplication.getContext().getSharedPreferences("qsmart_preference", 0).getBoolean("ota_showupdatereddot", true);
        localObject2 = BaseApplication.getContext().getSharedPreferences("lock_red_dot_show", 0);
        if ((EquipmentLockImpl.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, BaseApplicationImpl.getApplication()) == 0) || (((SharedPreferences)localObject2).getBoolean(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString + "_" + "lock_red_dot_show" + "_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), false))) {
          break label682;
        }
      }
      label682:
      for (int i = 1;; i = 0)
      {
        if (((!paramBoolean) || (!((SmartDeviceProxyMgr)localObject3).d(l))) && (i == 0)) {
          break label685;
        }
        this.jdField_n_of_type_AndroidWidgetImageView = new ImageView(this.jdField_a_of_type_AndroidContentContext);
        localObject2 = new RelativeLayout.LayoutParams(-2, -2);
        ((RelativeLayout.LayoutParams)localObject2).addRule(6, 2131363474);
        ((RelativeLayout.LayoutParams)localObject2).addRule(7, 2131363474);
        if (localObject1 != null)
        {
          ((RelativeLayout)localObject1).addView(this.jdField_n_of_type_AndroidWidgetImageView, (ViewGroup.LayoutParams)localObject2);
          this.jdField_n_of_type_AndroidWidgetImageView.setImageResource(2130846052);
        }
        this.jdField_n_of_type_AndroidWidgetImageView.setVisibility(0);
        return true;
        paramBoolean = false;
        break;
      }
      label685:
      break;
    }
  }
  
  public void aX()
  {
    int i = (int)(6.0F * this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getDisplayMetrics().density);
    Object localObject2 = (LinearLayout.LayoutParams)this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getLayoutParams();
    ((LinearLayout.LayoutParams)localObject2).leftMargin = i;
    this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setLayoutParams((ViewGroup.LayoutParams)localObject2);
    Object localObject1 = (SmartDeviceProxyMgr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(51);
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
        ((LinearLayout.LayoutParams)localObject2).leftMargin = 0;
        this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      }
      this.m = localDeviceInfo.productId;
    }
    for (;;)
    {
      S = ((SmartDeviceProxyMgr)localObject1).a(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)).booleanValue();
      boolean bool1 = SettingCloneUtil.readValue(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, null, "devicemsg_showsupporttips_first", true);
      boolean bool2 = SettingCloneUtil.readValue(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, null, "devicemsg_openchat_firsttrue", false);
      if (localProductInfo != null)
      {
        if ((localProductInfo.supportMainMsgType & 0xF) != 0) {
          this.Q = true;
        }
        if ((!bool2) && ((localDeviceInfo.SSOBid_Platform == 1027) || ((!StringUtil.a(localDeviceInfo.SSOBid_Version)) && (Double.valueOf(localDeviceInfo.SSOBid_Version).doubleValue() >= 1.1D))))
        {
          this.R = true;
          SettingCloneUtil.writeValue(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, null, "devicemsg_openchat_firsttrue", true);
        }
      }
      else
      {
        if ((this.Q) && (this.R) && (localDeviceInfo != null)) {
          SmartDeviceReport.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localDeviceInfo.din, "Usr_AIO_SupportGroupChat", 0, 0, localDeviceInfo.productId);
        }
        if ((localProductInfo != null) && (bool1))
        {
          if ((localProductInfo.supportMainMsgType & 0xF) != 0) {
            break label563;
          }
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131437818);
          label380:
          if (!TextUtils.isEmpty((CharSequence)localObject1))
          {
            localObject1 = (DeviceMsgHandle)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(49);
            if ((this.Q) && (localDeviceInfo.isAdmin == 1) && (this.R) && (!S))
            {
              localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131437844);
              ((DeviceMsgHandle)localObject1).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, (String)localObject2, MessageCache.a(), true, false, true);
            }
            SettingCloneUtil.writeValue(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, null, "devicemsg_showsupporttips_first", false);
          }
        }
        if (QLog.isColorLevel())
        {
          if (localProductInfo == null) {
            break label905;
          }
          QLog.d("DeviceMsgChatPie", 2, "support msg type maintype" + localProductInfo.supportMainMsgType + ", FuncMsgType:" + localProductInfo.supportFuncMsgType);
        }
      }
      for (;;)
      {
        aY();
        return;
        if ((!bool2) && (!S)) {
          break;
        }
        this.R = true;
        break;
        label563:
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131437819);
        localObject1 = localObject2;
        if (localProductInfo.isSupportMainMsgType(1)) {
          localObject1 = (String)localObject2 + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131437812) + "、";
        }
        localObject2 = localObject1;
        if (localProductInfo.isSupportMainMsgType(2)) {
          localObject2 = (String)localObject1 + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131437813) + "、";
        }
        localObject1 = localObject2;
        if (localProductInfo.isSupportMainMsgType(8)) {
          localObject1 = (String)localObject2 + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131437816) + "、";
        }
        localObject2 = localObject1;
        if (localProductInfo.isSupportFuncMsgType(1)) {
          localObject2 = (String)localObject1 + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131437814) + "、";
        }
        localObject1 = localObject2;
        if (localProductInfo.isSupportFuncMsgType(2)) {
          localObject1 = (String)localObject2 + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131437815) + "、";
        }
        localObject2 = localObject1;
        if (((String)localObject1).endsWith("、")) {
          localObject2 = ((String)localObject1).substring(0, ((String)localObject1).length() - 1);
        }
        localObject1 = (String)localObject2 + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131437820);
        break label380;
        label905:
        QLog.d("DeviceMsgChatPie", 2, "product is null");
      }
      localProductInfo = null;
    }
  }
  
  void aY()
  {
    int i = (int)(6.0F * this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getDisplayMetrics().density);
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getLayoutParams();
    Object localObject = (SmartDeviceProxyMgr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(51);
    DeviceInfo localDeviceInfo = ((SmartDeviceProxyMgr)localObject).a(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString));
    if (localDeviceInfo != null) {}
    for (localObject = ((SmartDeviceProxyMgr)localObject).a(localDeviceInfo.productId);; localObject = null)
    {
      if (localObject != null)
      {
        if ((((ProductInfo)localObject).supportMainMsgType & 0xF) == 0)
        {
          this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
          this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setVisibility(8);
        }
        for (;;)
        {
          if (!((ProductInfo)localObject).isSupportMainMsgType(1)) {
            this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
          }
          return;
          if (((ProductInfo)localObject).isSupportMainMsgType(15))
          {
            if ((((ProductInfo)localObject).isSupportFuncMsgType(3)) || (((ProductInfo)localObject).isSupportFuncMsgType(1)) || (!((ProductInfo)localObject).isSupportFuncMsgType(2))) {}
          }
          else if (((ProductInfo)localObject).isSupportMainMsgType(8))
          {
            this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setAllEnable(true);
            if (VersionUtils.e()) {
              this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setAllAlpha(0.6F);
            }
            localLayoutParams.leftMargin = i;
            this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setLayoutParams(localLayoutParams);
          }
          else if ((((ProductInfo)localObject).supportMainMsgType & 0xF) == 3)
          {
            this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setAllEnable(true);
            if (VersionUtils.e()) {
              this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setAllAlpha(0.6F);
            }
            localLayoutParams.leftMargin = i;
            this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setLayoutParams(localLayoutParams);
          }
          else if (((ProductInfo)localObject).isSupportMainMsgType(1))
          {
            if (((ProductInfo)localObject).isSupportFuncMsgType(3))
            {
              localLayoutParams.rightMargin = i;
              this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setLayoutParams(localLayoutParams);
            }
            else if (((ProductInfo)localObject).isSupportFuncMsgType(1))
            {
              localLayoutParams.rightMargin = i;
              this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setLayoutParams(localLayoutParams);
            }
            else if (((ProductInfo)localObject).isSupportFuncMsgType(2))
            {
              localLayoutParams.rightMargin = i;
              this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setLayoutParams(localLayoutParams);
            }
            else
            {
              this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setAllEnable(false);
              if (VersionUtils.e()) {
                this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setAllAlpha(0.6F);
              }
              localLayoutParams.leftMargin = i;
              this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setLayoutParams(localLayoutParams);
            }
          }
          else if (((ProductInfo)localObject).isSupportMainMsgType(2))
          {
            if (((ProductInfo)localObject).isSupportFuncMsgType(3))
            {
              this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setHint(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getString(2131437056));
              this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setHintTextColor(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getColor(2131492875));
              this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setGravity(17);
              this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setFocusable(false);
              this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setFocusableInTouchMode(false);
              this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
            }
            else if (((ProductInfo)localObject).isSupportFuncMsgType(1))
            {
              this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setHint(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getString(2131437056));
              this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setHintTextColor(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getColor(2131492875));
              this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setGravity(17);
              this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setFocusable(false);
              this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setFocusableInTouchMode(false);
              this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
            }
            else if (((ProductInfo)localObject).isSupportFuncMsgType(2))
            {
              this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setHint(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getString(2131437056));
              this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setHintTextColor(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getColor(2131492875));
              this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setGravity(17);
              this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setFocusable(false);
              this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setFocusableInTouchMode(false);
              this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
            }
            else
            {
              this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setVisibility(8);
              this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
              this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setAllEnable(true);
              if (VersionUtils.e()) {
                this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setAllAlpha(0.6F);
              }
              this.jdField_a_of_type_ComTencentWidgetPatchedButton.setVisibility(8);
            }
          }
          else
          {
            this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setVisibility(0);
            this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setAllEnable(true);
            if (VersionUtils.e()) {
              this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setAllAlpha(1.0F);
            }
            if (((ProductInfo)localObject).isSupportFuncMsgType(3))
            {
              localLayoutParams.rightMargin = i;
              this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setHint(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getString(2131437056));
              this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setHintTextColor(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getColor(2131492875));
              this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setGravity(17);
              this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setFocusable(false);
              this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setFocusableInTouchMode(false);
              this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setLayoutParams(localLayoutParams);
              this.jdField_a_of_type_ComTencentWidgetPatchedButton.setVisibility(8);
              this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
            }
            else if (((ProductInfo)localObject).isSupportFuncMsgType(1))
            {
              localLayoutParams.rightMargin = i;
              this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setHint(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getString(2131437056));
              this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setHintTextColor(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getColor(2131492875));
              this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setGravity(17);
              this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setFocusable(false);
              this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setFocusableInTouchMode(false);
              this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setLayoutParams(localLayoutParams);
              this.jdField_a_of_type_ComTencentWidgetPatchedButton.setVisibility(8);
              this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
            }
            else if (((ProductInfo)localObject).isSupportFuncMsgType(2))
            {
              localLayoutParams.rightMargin = i;
              this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setHint(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getString(2131437056));
              this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setHintTextColor(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getColor(2131492875));
              this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setGravity(17);
              this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setFocusable(false);
              this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setFocusableInTouchMode(false);
              this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setLayoutParams(localLayoutParams);
              this.jdField_a_of_type_ComTencentWidgetPatchedButton.setVisibility(8);
              this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
            }
          }
        }
      }
      this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      return;
    }
  }
  
  public void ak()
  {
    boolean bool = true;
    Object localObject1;
    if (this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().length() > 0)
    {
      localObject1 = this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().toString();
      PicPreDownloadUtils.a((String)localObject1);
      if ((localObject1 != null) && (((String)localObject1).length() > 3478))
      {
        ChatActivityUtils.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 2131433378, 1);
        return;
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setText("");
      Object localObject3 = (SmartDeviceProxyMgr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(51);
      Object localObject2 = ((SmartDeviceProxyMgr)localObject3).a(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString));
      if (localObject2 != null)
      {
        localObject3 = ((SmartDeviceProxyMgr)localObject3).a(((DeviceInfo)localObject2).productId);
        if ((localObject3 == null) || (!((ProductInfo)localObject3).isSupportMainMsgType(1))) {}
      }
      for (int i = 1;; i = 0)
      {
        long l = 0L;
        if (localObject2 != null) {
          l = ((DeviceInfo)localObject2).din;
        }
        for (int j = ((DeviceInfo)localObject2).productId;; j = 0)
        {
          if (i == 0)
          {
            localObject1 = (DeviceMsgHandle)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(49);
            SmartDeviceReport.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, l, "Usr_AIO_SendMsg", 7, 0, j);
            return;
          }
          localObject2 = (DeviceMsgHandle)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(49);
          SessionInfo localSessionInfo;
          if (!TextUtils.isEmpty((CharSequence)localObject1))
          {
            localObject3 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
            localSessionInfo = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
            if ((!S) || (!this.R)) {
              break label267;
            }
          }
          for (;;)
          {
            ((DeviceMsgHandle)localObject2).a((QQAppInterface)localObject3, localSessionInfo, (String)localObject1, bool);
            SmartDeviceReport.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, l, "Usr_AIO_SendMsg", 6, 0, j);
            return;
            label267:
            bool = false;
          }
        }
      }
      localObject1 = null;
    }
  }
  
  public void b(int paramInt)
  {
    super.b(paramInt);
    this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(20);
  }
  
  public void b(List paramList)
  {
    DeviceMsgHandle localDeviceMsgHandle = (DeviceMsgHandle)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(49);
    if ((S) && (this.R))
    {
      localDeviceMsgHandle.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, paramList);
      paramList = ((SmartDeviceProxyMgr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(51)).a(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString));
      SmartDeviceReport.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramList.din, "Usr_AIO_SendGroupMsg", 3, 0, paramList.productId);
      return;
    }
    localDeviceMsgHandle.a().a(DeviceMsgHandle.d, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, paramList);
  }
  
  public void c(List paramList)
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
        localIntent.putExtra("troop_uin", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b);
        localIntent.putExtra("PhotoConst.SEND_SIZE_SPEC", 0);
        localIntent.putExtra("PhotoConst.HANDLE_DEST_RESULT", true);
        PicReq localPicReq1 = PicBusiManager.a(2, 1007);
        PicBusiManager.a(1007, localIntent);
        PicReq localPicReq2 = PicBusiManager.a(1, 1007);
        localPicReq2.a(localPicReq1.jdField_a_of_type_JavaLangString);
        if (localPicReq2.a(PicBusiManager.a(1007, localIntent)))
        {
          localPicReq2.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoICompressionCallBack = new vsf(this);
          PicBusiManager.a(localPicReq2, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        }
        else
        {
          e(str);
        }
      }
    }
  }
  
  protected boolean c()
  {
    Object localObject = (SmartDeviceProxyMgr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(51);
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
  
  protected boolean d()
  {
    Object localObject = (SmartDeviceProxyMgr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(51);
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
  
  public void e(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramString);
    b(localArrayList);
  }
  
  protected void f(Intent paramIntent)
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
      localDeviceMsgHandle = (DeviceMsgHandle)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(49);
    } while (TextUtils.isEmpty(str));
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString = paramIntent.getStringExtra("uin");
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int = paramIntent.getIntExtra("uintype", -1);
    paramIntent = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    SessionInfo localSessionInfo = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
    if ((S) && (this.R)) {}
    for (boolean bool = true;; bool = false)
    {
      localDeviceMsgHandle.a(paramIntent, localSessionInfo, str, bool);
      return;
    }
    super.f(paramIntent);
  }
  
  protected void g(Intent paramIntent)
  {
    if (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getExtras() == null) {
      super.A();
    }
    do
    {
      return;
      super.g(paramIntent);
    } while (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.isFinishing());
    k(paramIntent);
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
  
  void k(Intent paramIntent)
  {
    int i = paramIntent.getIntExtra(AlbumConstants.h, -1);
    if ((80 == i) || (82 == i)) {
      l(paramIntent);
    }
  }
  
  protected void o()
  {
    super.o();
    if ((this.jdField_n_of_type_Int == 1) || (this.jdField_n_of_type_Int == 3) || (this.jdField_n_of_type_Int == 9)) {
      if ((PanelIconLinearLayout)this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131363493) != null) {
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
          QLog.d("DeviceMsgChatPie", 2, "DeviceMsgChatPie, OPER_TYPE_SEND_PICTURE[" + this.jdField_n_of_type_Int + "], find view panelicons failed!!");
          return;
          if ((this.jdField_n_of_type_Int != 2) && (this.jdField_n_of_type_Int != 4)) {
            break;
          }
          if ((PanelIconLinearLayout)this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131363493) != null)
          {
            a(Integer.valueOf(5));
            return;
          }
        } while (!QLog.isColorLevel());
        QLog.d("DeviceMsgChatPie", 2, "DeviceMsgChatPie, OPER_TYPE_SEND_PICTURE[" + this.jdField_n_of_type_Int + "], find view panelicons failed!!");
        return;
      } while (this.jdField_n_of_type_Int == 5);
      if (this.jdField_n_of_type_Int == 6)
      {
        AIOPanelUtiles.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
        return;
      }
      FileManagerReporter.fileAssistantReportData localfileAssistantReportData;
      if (this.jdField_n_of_type_Int == 7)
      {
        localfileAssistantReportData = new FileManagerReporter.fileAssistantReportData();
        localfileAssistantReportData.b = "send_file";
        localfileAssistantReportData.jdField_a_of_type_Int = 1;
        FileManagerReporter.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), localfileAssistantReportData);
        PlusPanelUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, a(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_o_of_type_Int, false);
        return;
      }
      if (this.jdField_n_of_type_Int == 8)
      {
        this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a(2);
        return;
      }
      if (this.jdField_n_of_type_Int == 10)
      {
        localfileAssistantReportData = new FileManagerReporter.fileAssistantReportData();
        localfileAssistantReportData.b = "send_file";
        localfileAssistantReportData.jdField_a_of_type_Int = 1;
        FileManagerReporter.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), localfileAssistantReportData);
        PlusPanelUtils.d(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, a(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
        return;
      }
    } while (this.jdField_n_of_type_Int != 11);
    a(Integer.valueOf(13));
  }
  
  protected void p()
  {
    if (this.jdField_d_of_type_AndroidWidgetImageView != null)
    {
      if (AIOTopRightButtonConfig.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())) {
        this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(0);
      }
    }
    else {
      return;
    }
    this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
  }
  
  public void s()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString.equals(AppConstants.x))
    {
      localIntent = new Intent();
      localIntent.putExtra("url", "http://qzs.qq.com/open/mobile/iot_menu/aioSet.html");
      SmartDevicePluginLoader.a().a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), localIntent, "com.tencent.device.activities.DeviceSquareSettingActivity", p, null, SmartDevicePluginProxyActivity.class);
    }
    do
    {
      return;
      localObject = ((SmartDeviceProxyMgr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(51)).a(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString));
      int i = 0;
      long l = 0L;
      if (localObject != null)
      {
        i = ((DeviceInfo)localObject).productId;
        l = ((DeviceInfo)localObject).din;
      }
      SmartDeviceReport.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, l, "Usr_AIO_Menu", 1, 0, i);
    } while (localObject == null);
    Intent localIntent = new Intent();
    localIntent.putExtra("device_info", (Parcelable)localObject);
    localIntent.putExtra("isPublicDevice", true);
    Object localObject = new LightAppUtil(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity).a((DeviceInfo)localObject);
    if (localObject != null) {
      localIntent.putExtra("lightapp_setting", (Parcelable)localObject);
    }
    SmartDevicePluginLoader.a().a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), localIntent, "com.tencent.device.activities.DeviceSettingActivity", p, null, SmartDevicePluginProxyActivity.class);
    if (this.jdField_n_of_type_AndroidWidgetImageView != null) {
      this.jdField_n_of_type_AndroidWidgetImageView.setVisibility(8);
    }
    BaseApplication.getContext().getSharedPreferences("lock_red_dot_show", 0).edit().putBoolean(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString + "_" + "lock_red_dot_show" + "_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), true).commit();
    BaseApplication.getContext().getSharedPreferences("qsmart_preference", 0).edit().putBoolean("ota_showupdatereddot", false).commit();
  }
  
  protected void u()
  {
    if (this.jdField_a_of_type_AndroidWidgetImageView != null)
    {
      a(this.jdField_a_of_type_AndroidWidgetImageView, 2130838728, 2130838728);
      this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getText(2131430118));
    }
  }
  
  public boolean x()
  {
    Object localObject = (SmartDeviceProxyMgr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(51);
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
  
  public boolean y()
  {
    Object localObject = (SmartDeviceProxyMgr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(51);
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
  
  protected void z()
  {
    if (this.I) {
      if (QLog.isColorLevel()) {
        QLog.d("DeviceMsgChatPie", 2, "hasDestory = true return");
      }
    }
    do
    {
      return;
      super.z();
      try
      {
        this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
        return;
      }
      catch (IllegalArgumentException localIllegalArgumentException) {}
    } while (!QLog.isColorLevel());
    QLog.w("DeviceMsgChatPie", 2, " already unregisterReceiver" + localIllegalArgumentException);
  }
  
  public boolean z()
  {
    if (y()) {
      return true;
    }
    try
    {
      l = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      SmartDeviceProxyMgr localSmartDeviceProxyMgr = (SmartDeviceProxyMgr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(51);
      if ((localSmartDeviceProxyMgr != null) && (localSmartDeviceProxyMgr.c(l)) && (localSmartDeviceProxyMgr.a(l, 17))) {
        return true;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
        long l = 0L;
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.DeviceMsgChatPie
 * JD-Core Version:    0.7.0.1
 */