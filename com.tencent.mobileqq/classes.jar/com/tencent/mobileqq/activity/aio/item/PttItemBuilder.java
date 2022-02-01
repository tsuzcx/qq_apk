package com.tencent.mobileqq.activity.aio.item;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Environment;
import android.os.Message;
import android.os.StatFs;
import android.support.annotation.Nullable;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.etrump.mixlayout.ETTextView;
import com.tencent.biz.anonymous.AnonymousChatHelper;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.TouchDelegate;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.ViewHolder;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout.MiniAioShieldItemTouchListener;
import com.tencent.mobileqq.activity.aio.Callback;
import com.tencent.mobileqq.activity.aio.ChatAdapter1;
import com.tencent.mobileqq.activity.aio.FileTransferManager;
import com.tencent.mobileqq.activity.aio.MediaPlayerManager;
import com.tencent.mobileqq.activity.aio.MediaPlayerManager.Callback;
import com.tencent.mobileqq.activity.aio.OnLongClickAndTouchListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.activity.aio.anim.VoicePrintUtils;
import com.tencent.mobileqq.activity.aio.anim.VoicePrintUtils.VoicePrintView;
import com.tencent.mobileqq.activity.aio.audiopanel.AudioPanelAioHelper;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.core.msglist.MsgList;
import com.tencent.mobileqq.activity.aio.coreui.msglist.ListUI;
import com.tencent.mobileqq.activity.aio.helper.PttSttHelper;
import com.tencent.mobileqq.activity.selectable.AIOSelectableDelegateProxy;
import com.tencent.mobileqq.activity.selectable.SelectableComponent;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.bubble.BubbleInfo;
import com.tencent.mobileqq.bubble.BubbleInfo.CommonAttrs;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.confess.ConfessMsgUtil;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.mobileqq.config.business.PttAutoChangeBean;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.graytip.UniteGrayTipMsgUtil;
import com.tencent.mobileqq.graytip.UniteGrayTipParam;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.model.ChatBackgroundManager;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.ptt.IQQRecorderUtils;
import com.tencent.mobileqq.ptt.api.IPttInfoCollector;
import com.tencent.mobileqq.ptt.temp.api.IQQRecorderTempApi;
import com.tencent.mobileqq.pttlogic.api.IPTTPreDownloader;
import com.tencent.mobileqq.pttlogic.api.IPttUtils;
import com.tencent.mobileqq.qmethodmonitor.monitor.ClipboardMonitor;
import com.tencent.mobileqq.qqaudio.audioplayer.AudioDeviceHelper;
import com.tencent.mobileqq.qqaudio.audioplayer.AudioPlayerBase;
import com.tencent.mobileqq.qqaudio.audioplayer.sonic.SonicHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.IQWalletPreferenceApi;
import com.tencent.mobileqq.qwallet.config.IQWalletConfigService;
import com.tencent.mobileqq.qwallet.hb.IQWalletHbApi;
import com.tencent.mobileqq.qwallet.hb.aio.elem.ICustomizeStrategyFactory;
import com.tencent.mobileqq.qwallet.hb.aio.elem.ICustomizeStrategyFactory.OnCustomizeListener;
import com.tencent.mobileqq.qwallet.hb.aio.elem.RedPacketInfo;
import com.tencent.mobileqq.qwallet.hb.grap.voice.IVoiceRedPacketHelper;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.service.message.remote.MessageRecordInfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.stt.ISttListener;
import com.tencent.mobileqq.stt.ISttManagerService;
import com.tencent.mobileqq.stt.shard.AIOSttResult;
import com.tencent.mobileqq.text.OffsetableImageSpan;
import com.tencent.mobileqq.transfile.FileMsg;
import com.tencent.mobileqq.transfile.PttInfoCollector;
import com.tencent.mobileqq.transfile.api.ITransFileController;
import com.tencent.mobileqq.transfile.api.TransFileControllerBusHelper;
import com.tencent.mobileqq.troop.utils.TroopRobotManager;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.PlayModeUtils;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenuItem;
import com.tencent.mobileqq.vas.api.IVasSingedApi;
import com.tencent.mobileqq.vas.config.business.qvip.QVipAutoPttConfig;
import com.tencent.mobileqq.vas.config.business.qvip.QVipAutoPttProcessor;
import com.tencent.mobileqq.vas.util.VasUtil;
import com.tencent.mobileqq.vas.vip.QVipConfigManager;
import com.tencent.mobileqq.vas.webview.util.VasWebviewUtil;
import com.tencent.mobileqq.vip.IVipStatusManager;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.navbar.NavBarAIO;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.Pair;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.XListView;
import cooperation.qqfav.QfavUtil;
import cooperation.qqfav.widget.QfavMicroPhoneDialog;
import java.io.File;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import mqq.app.AppRuntime;
import mqq.manager.ServerConfigManager.ConfigType;
import mqq.os.MqqHandler;

public class PttItemBuilder
  extends BaseBubbleBuilder
  implements BaseBubbleBuilder.TouchDelegate, BaseChatItemLayout.MiniAioShieldItemTouchListener, Callback, MediaPlayerManager.Callback, PttAudioWaveView.SeekProgressListener, ICustomizeStrategyFactory.OnCustomizeListener, ISttListener
{
  protected SpannableString a;
  protected TextView a;
  protected BaseChatPie a;
  protected Map<Long, String> a;
  Set<PttItemBuilder.Holder> a;
  protected SpannableString b;
  protected int d = 14;
  
  public PttItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner, BaseChatPie paramBaseChatPie)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    this.jdField_a_of_type_JavaUtilSet = new HashSet();
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    ((ISttManagerService)paramQQAppInterface.getRuntimeService(ISttManagerService.class)).setListener(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie = paramBaseChatPie;
  }
  
  public static int a(Context paramContext, int paramInt1, float paramFloat, int paramInt2, int paramInt3, boolean paramBoolean1, boolean paramBoolean2)
  {
    paramInt1 = Math.min(60, Math.max(1, paramInt1));
    if (paramInt1 == 1) {
      paramInt1 = 25;
    } else {
      paramInt1 = (int)(PttAudioWaveView.a(paramInt1, 60, 1.5F) * 125.0F) + 15;
    }
    int i = 0;
    if (paramBoolean1) {
      i = 16;
    }
    int j = i;
    if (paramBoolean2) {
      j = i + 38;
    }
    i = paramInt1;
    if (j != 0)
    {
      j = 170 - j;
      i = paramInt1;
      if (paramInt1 > j) {
        i = j;
      }
    }
    paramInt1 = i;
    if (i % 5 != 0) {
      paramInt1 = i / 5 * 5;
    }
    paramInt1 = AIOUtils.b(paramInt1, paramContext.getResources());
    if (paramFloat > 0.0F)
    {
      paramInt3 = Math.max(paramInt1 + AIOUtils.b(paramInt2, paramContext.getResources()) + AIOUtils.b(paramInt3, paramContext.getResources()), (int)paramFloat);
      i = BaseChatItemLayout.f - BaseChatItemLayout.j - BaseChatItemLayout.k - 32;
      paramInt1 = paramInt3;
      if (paramInt3 > i) {
        paramInt1 = i;
      }
      return paramInt1 - AIOUtils.b(paramInt2 - 40, paramContext.getResources());
    }
    return paramInt1 + AIOUtils.b(paramInt3, paramContext.getResources());
  }
  
  public static int a(Context paramContext, int paramInt1, String paramString, Paint paramPaint, int paramInt2)
  {
    int i = Math.min(60, Math.max(1, paramInt1));
    if (i > 40) {
      i += 40;
    } else {
      i *= 2;
    }
    int j = AIOUtils.b(i + 20, paramContext.getResources());
    if ((paramString != null) && (paramPaint != null))
    {
      i = BaseChatItemLayout.f - BaseChatItemLayout.j - BaseChatItemLayout.k - 32;
      float f2 = paramPaint.measureText(paramString) + paramInt2;
      float f3 = i;
      float f1 = f2;
      if (f2 > f3) {
        f1 = f3;
      }
      if (paramInt1 > 99)
      {
        f2 = 38.0F;
      }
      else
      {
        if (paramInt1 > 9) {
          paramInt1 = 34;
        } else {
          paramInt1 = 30;
        }
        f2 = paramInt1;
      }
      int k = AIOUtils.b(f2, paramContext.getResources());
      paramInt2 = j + k;
      paramInt1 = paramInt2;
      if (paramInt2 > i) {
        paramInt1 = i;
      }
      return Math.max(paramInt1, (int)f1) - k;
    }
    return j;
  }
  
  private int a(PttItemBuilder.Holder paramHolder, MessageForPtt paramMessageForPtt, int paramInt, boolean paramBoolean, String paramString)
  {
    boolean bool1;
    if (paramMessageForPtt.voiceChangeFlag != 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    boolean bool2 = a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidWidgetBaseAdapter, paramHolder, paramMessageForPtt);
    Resources localResources = this.jdField_a_of_type_AndroidContentContext.getResources();
    int i = AIOUtils.b(15.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    if (paramInt != -1)
    {
      if (paramInt != 5003) {}
      switch (paramInt)
      {
      default: 
        switch (paramInt)
        {
        default: 
          break;
        case 2004: 
        case 2005: 
          paramHolder.jdField_a_of_type_AndroidWidgetTextView.setText(paramString);
          paramHolder.jdField_a_of_type_AndroidWidgetTextView.setPadding(AIOUtils.b(10.0F, localResources), BaseChatItemLayout.m, AIOUtils.b(10.0F, localResources), BaseChatItemLayout.n);
          if (paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVoicePrintUtils$VoicePrintView != null) {
            paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVoicePrintUtils$VoicePrintView.setVisibility(8);
          }
          a(paramHolder, bool2, bool1, paramMessageForPtt.isSend());
          paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemBreathAnimationLayout.setAnimating(false);
          ((RelativeLayout.LayoutParams)paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.getLayoutParams()).width = i;
          paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.setVisibility(4);
          return 1;
        }
        break;
      case 1001: 
      case 1002: 
      case 1003: 
      case 1004: 
      case 1005: 
        return b(paramHolder, paramMessageForPtt, paramInt, paramBoolean, paramString);
        return 7;
      }
    }
    else
    {
      ((RelativeLayout.LayoutParams)paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.getLayoutParams()).width = i;
      paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.setVisibility(4);
      paramHolder.jdField_a_of_type_AndroidWidgetTextView.setText(paramString);
      paramHolder.jdField_a_of_type_AndroidWidgetTextView.setPadding(AIOUtils.b(40.0F, localResources), BaseChatItemLayout.m, AIOUtils.b(40.0F, localResources), BaseChatItemLayout.n);
      if (paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVoicePrintUtils$VoicePrintView != null) {
        paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVoicePrintUtils$VoicePrintView.setVisibility(8);
      }
      if (paramInt == 999)
      {
        paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemBreathAnimationLayout.setAnimating(false);
        paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView.setVisibility(8);
      }
      else
      {
        paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemBreathAnimationLayout.setAnimating(true);
        paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView.setVisibility(0);
      }
    }
    return 0;
  }
  
  public static int a(QQAppInterface paramQQAppInterface, MessageForPtt paramMessageForPtt)
  {
    int i = 0;
    if (paramMessageForPtt == null) {
      return 0;
    }
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("parsePttStatus  fileSize ");
      localStringBuilder.append(paramMessageForPtt.fileSize);
      localStringBuilder.append(" url ");
      localStringBuilder.append(paramMessageForPtt.url);
      localStringBuilder.append(" uniseq ");
      localStringBuilder.append(paramMessageForPtt.uniseq);
      QLog.d("PttItemBuilder", 2, localStringBuilder.toString());
    }
    int j;
    if (paramMessageForPtt.isSendFromLocal())
    {
      if ((paramMessageForPtt.url != null) && (paramMessageForPtt.url.startsWith(AppConstants.SDCARD_ROOT)))
      {
        if (paramMessageForPtt.fileSize > 0L) {
          return 1003;
        }
        if (paramMessageForPtt.fileSize == -1L) {}
        for (;;)
        {
          return 1005;
          if (paramMessageForPtt.fileSize == -2L) {
            if (!a(paramMessageForPtt)) {}
          }
          for (;;)
          {
            return 999;
            paramMessageForPtt.fileSize = -1L;
            break;
            if (paramMessageForPtt.fileSize != -3L) {
              break label320;
            }
            i = 1001;
            boolean bool = ((ITransFileController)paramQQAppInterface.getRuntimeService(ITransFileController.class)).containsProcessor(paramMessageForPtt.frienduin, paramMessageForPtt.uniseq);
            j = TransFileControllerBusHelper.findProcessorFileStatus(paramQQAppInterface, paramMessageForPtt.frienduin, paramMessageForPtt.getLocalFilePath(), paramMessageForPtt.uniseq);
            if (QLog.isColorLevel())
            {
              paramQQAppInterface = new StringBuilder();
              paramQQAppInterface.append("parsePttStatus transStatus  ");
              paramQQAppInterface.append(j);
              paramQQAppInterface.append(", hasTransProc ");
              paramQQAppInterface.append(bool);
              QLog.d("PttItemBuilder", 2, paramQQAppInterface.toString());
            }
            if ((!bool) || (j == 1005)) {
              break label310;
            }
            if (j != 7000) {
              return i;
            }
          }
          label310:
          paramMessageForPtt.fileSize = -1L;
        }
        label320:
        j = TransFileControllerBusHelper.findProcessorFileStatus(paramQQAppInterface, paramMessageForPtt.frienduin, paramMessageForPtt.getLocalFilePath(), paramMessageForPtt.uniseq);
        i = j;
        if (QLog.isColorLevel())
        {
          paramQQAppInterface = new StringBuilder();
          paramQQAppInterface.append("parsePttStatus status  ");
          paramQQAppInterface.append(j);
          QLog.d("PttItemBuilder", 2, paramQQAppInterface.toString());
          return j;
        }
      }
      else
      {
        return 1004;
      }
    }
    else
    {
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("handlePttItem recieve friendUin ");
        localStringBuilder.append(paramMessageForPtt.frienduin);
        localStringBuilder.append(" url ");
        localStringBuilder.append(paramMessageForPtt.url);
        localStringBuilder.append(" urlAtServer ");
        localStringBuilder.append(paramMessageForPtt.urlAtServer);
        localStringBuilder.append(" uniseq ");
        localStringBuilder.append(paramMessageForPtt.uniseq);
        QLog.d("PttItemBuilder", 2, localStringBuilder.toString());
      }
      if (paramMessageForPtt != null)
      {
        j = ((IPttUtils)QRoute.api(IPttUtils.class)).getReceivedPTTStatus(paramQQAppInterface, paramMessageForPtt);
        i = j;
        if (QLog.isColorLevel())
        {
          paramQQAppInterface = new StringBuilder();
          paramQQAppInterface.append("handlePttItem recieve status ");
          paramQQAppInterface.append(j);
          paramQQAppInterface.append("   url ");
          paramQQAppInterface.append(paramMessageForPtt.url);
          paramQQAppInterface.append(" uniseq ");
          paramQQAppInterface.append(paramMessageForPtt.uniseq);
          QLog.d("PttItemBuilder", 2, paramQQAppInterface.toString());
          i = j;
        }
      }
    }
    return i;
  }
  
  public static int a(QQAppInterface paramQQAppInterface, String paramString)
  {
    paramQQAppInterface = paramQQAppInterface.getServerConfigValue(ServerConfigManager.ConfigType.common, paramString);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("key = ");
      localStringBuilder.append(paramString);
      localStringBuilder.append(", time = ");
      localStringBuilder.append(paramQQAppInterface);
      QLog.d("PttItemBuilder", 2, localStringBuilder.toString());
    }
    if (paramQQAppInterface != null) {
      try
      {
        i = Integer.valueOf(paramQQAppInterface).intValue();
        if (i > 0) {
          return i;
        }
      }
      catch (Exception paramQQAppInterface)
      {
        if (QLog.isColorLevel()) {
          QLog.e("PttItemBuilder", 2, paramQQAppInterface.toString());
        }
      }
    }
    boolean bool = "ConvertText_MaxPtt".equals(paramString);
    int i = 120;
    if (bool) {
      return 120;
    }
    if ("Normal_MaxPtt".equals(paramString)) {
      return 120;
    }
    if ("VIP_MaxPtt".equals(paramString)) {
      return 180;
    }
    if ("SVIP_MaxPtt".equals(paramString)) {
      i = 300;
    }
    return i;
  }
  
  public static int a(MessageForPtt paramMessageForPtt, int paramInt, QQAppInterface paramQQAppInterface)
  {
    int i = 1;
    if ((paramInt != 2003) && (paramInt != 1003))
    {
      if (paramInt != 1005)
      {
        if (paramInt == 1004) {
          return 1;
        }
        return 4;
      }
    }
    else
    {
      if (((paramMessageForPtt.sttAbility == 1) || (paramMessageForPtt.sttAbility == 3)) && (((ISttManagerService)paramQQAppInterface.getRuntimeService(ISttManagerService.class)).isTranslating(paramMessageForPtt))) {
        return 5;
      }
      if ((paramMessageForPtt.sttAbility == 3) && (paramMessageForPtt.expandStt)) {
        return 6;
      }
      i = 0;
    }
    return i;
  }
  
  private CharSequence a(MessageForPtt paramMessageForPtt, int paramInt)
  {
    String str = paramMessageForPtt.sttText;
    if (paramInt == 5)
    {
      localObject = a();
      if ((localObject != null) && (paramMessageForPtt.getSttResult().a())) {
        paramMessageForPtt = ((PttSttHelper)localObject).a(paramMessageForPtt);
      } else {
        paramMessageForPtt = (CharSequence)this.jdField_a_of_type_JavaUtilMap.get(Long.valueOf(paramMessageForPtt.uniseq));
      }
      return paramMessageForPtt;
    }
    Object localObject = str;
    if (TextUtils.isEmpty(str))
    {
      if (paramMessageForPtt.sttAbility == 3) {
        return "";
      }
      localObject = this.jdField_a_of_type_AndroidContentContext.getString(2131719265);
    }
    return localObject;
  }
  
  public static String a(int paramInt)
  {
    int i = paramInt / 60;
    Object localObject;
    if (i > 0)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(i);
      ((StringBuilder)localObject).append("'");
      localObject = ((StringBuilder)localObject).toString();
    }
    else
    {
      localObject = "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append((String)localObject);
    localStringBuilder.append(paramInt % 60);
    localStringBuilder.append("\"");
    return localStringBuilder.toString();
  }
  
  private String a(int paramInt, MessageForPtt paramMessageForPtt)
  {
    if ((paramInt != 1001) && (paramInt != 1002) && (paramInt != 1005) && (paramInt != 1004) && (paramInt != 2003) && (paramInt != 1003)) {
      return "";
    }
    if ((TextUtils.isEmpty(paramMessageForPtt.timeStr)) || (TextUtils.equals(paramMessageForPtt.timeStr, "0\""))) {
      paramMessageForPtt.timeStr = a(paramMessageForPtt.voiceLength);
    }
    return paramMessageForPtt.timeStr;
  }
  
  private String a(MessageForPtt paramMessageForPtt, int paramInt)
  {
    Object localObject = paramMessageForPtt.sttText;
    if (paramInt == 5)
    {
      localObject = a();
      if ((localObject != null) && (paramMessageForPtt.getSttResult().a())) {
        paramMessageForPtt = ((PttSttHelper)localObject).a(paramMessageForPtt);
      } else {
        paramMessageForPtt = (String)this.jdField_a_of_type_JavaUtilMap.get(Long.valueOf(paramMessageForPtt.uniseq));
      }
      return paramMessageForPtt;
    }
    paramMessageForPtt = (MessageForPtt)localObject;
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      paramMessageForPtt = this.jdField_a_of_type_AndroidContentContext.getString(2131719265);
    }
    return paramMessageForPtt;
  }
  
  private void a(int paramInt, PttItemBuilder.Holder paramHolder)
  {
    if (paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView != null) {
      paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.setProgressColor(paramInt);
    }
    if (paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView != null) {
      paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView.setThemeColor(paramInt);
    }
    if (paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioChangeView != null) {
      paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioChangeView.setThemeColor(paramInt);
    }
  }
  
  private void a(int paramInt, MessageForPtt paramMessageForPtt)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("url", paramMessageForPtt.url);
    localHashMap.put("urlAtServer", paramMessageForPtt.urlAtServer);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramMessageForPtt.msgTime);
    localStringBuilder.append("");
    localHashMap.put("msgtime", localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramMessageForPtt.msgRecTime);
    localStringBuilder.append("");
    localHashMap.put("msgrectime", localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramMessageForPtt.busiType);
    localStringBuilder.append("");
    localHashMap.put("msgtype", localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramMessageForPtt.istroop);
    localStringBuilder.append("");
    localHashMap.put("msgUinType", localStringBuilder.toString());
    paramMessageForPtt = new StringBuilder();
    paramMessageForPtt.append(paramInt);
    paramMessageForPtt.append("");
    localHashMap.put("retcode", paramMessageForPtt.toString());
    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "pttDownloadedFail", true, 0L, 0L, localHashMap, "");
  }
  
  private void a(View paramView, ColorFilter paramColorFilter)
  {
    Object localObject = (PttItemBuilder.Holder)paramView.getTag();
    if (localObject != null)
    {
      paramView = AIOUtils.a(paramView);
      if ((paramView != null) && (paramView.vipBubbleID == 0L))
      {
        localObject = ((PttItemBuilder.Holder)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioItemBreathAnimationLayout.getBackground();
        if ((localObject != null) && (paramView.vipBubbleID == 0L))
        {
          ((Drawable)localObject).setColorFilter(paramColorFilter);
          ((Drawable)localObject).invalidateSelf();
        }
      }
    }
  }
  
  public static void a(PttItemBuilder.Holder paramHolder, MessageForPtt paramMessageForPtt, int paramInt1, boolean paramBoolean1, String paramString1, boolean paramBoolean2, QQAppInterface paramQQAppInterface, int paramInt2, String paramString2)
  {
    Context localContext;
    if (paramQQAppInterface != null) {
      localContext = paramQQAppInterface.getApp().getApplicationContext();
    } else {
      localContext = null;
    }
    if (localContext == null) {
      return;
    }
    boolean bool2 = ((IVoiceRedPacketHelper)QRoute.api(IVoiceRedPacketHelper.class)).isRedPackPTT(paramMessageForPtt);
    boolean bool1;
    if (paramMessageForPtt.voiceChangeFlag != 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    Object localObject = localContext.getResources();
    int i = AIOUtils.b(1.5F, (Resources)localObject);
    int j = AIOUtils.b(9.0F, (Resources)localObject);
    float f;
    if (paramInt1 == 2)
    {
      if (TextUtils.isEmpty(paramString2)) {
        paramString2 = localContext.getString(2131719265);
      }
      localObject = new TextView(localContext);
      ((TextView)localObject).setTextSize(0, paramInt2);
      f = ((TextView)localObject).getPaint().measureText(paramString2);
    }
    else
    {
      f = 0.0F;
    }
    paramInt2 = j + 44 + (int)AIOUtils.a((int)paramHolder.jdField_a_of_type_AndroidWidgetTextView.getPaint().measureText(paramString1), localContext.getResources());
    paramInt1 = paramInt2;
    if (bool1) {
      paramInt1 = paramInt2 + 16;
    }
    paramInt2 = paramInt1;
    if (bool2) {
      paramInt2 = paramInt1 + 38;
    }
    paramInt1 = a(localContext, paramMessageForPtt.voiceLength, f, paramInt2, i, bool1, bool2);
    localObject = (RelativeLayout.LayoutParams)paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).width = paramInt1;
    paramString1 = VoicePrintUtils.a(paramQQAppInterface, paramBoolean1, bool1, paramInt1 + j, paramHolder);
    paramString2 = (RelativeLayout.LayoutParams)paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVoicePrintUtils$VoicePrintView.getLayoutParams();
    paramString2.width = (paramString1[0] + paramString1[1] + paramString1[2]);
    paramString2.height = VoicePrintUtils.a(paramQQAppInterface, paramBoolean1, paramHolder);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("message seq=");
      localStringBuilder.append(paramMessageForPtt.uniseq);
      localStringBuilder.append(", VpLp.width=");
      localStringBuilder.append(paramString2.width);
      localStringBuilder.append(", flagTimeContainer.getLeft()=");
      localStringBuilder.append(paramHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.getLeft());
      QLog.d("PttItemBuilder", 2, localStringBuilder.toString());
    }
    if ((paramBoolean1) && (paramString2.height > 0))
    {
      paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.setVisibility(8);
      paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVoicePrintUtils$VoicePrintView.setVisibility(0);
      paramQQAppInterface = paramHolder.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInfo.a(paramQQAppInterface, 7);
      if ((((BubbleInfo.CommonAttrs)paramQQAppInterface.first).a != null) && (((BubbleInfo.CommonAttrs)paramQQAppInterface.first).a.length > 0))
      {
        paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVoicePrintUtils$VoicePrintView.setBitmap((BubbleInfo.CommonAttrs)paramQQAppInterface.first, paramString1[0], paramString2.height, paramString1[1], paramString1[2], paramMessageForPtt.isSend() ^ true);
        if (paramBoolean2)
        {
          paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVoicePrintUtils$VoicePrintView.a(false);
          return;
        }
        paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVoicePrintUtils$VoicePrintView.a(true);
      }
    }
    else
    {
      if (paramMessageForPtt.voiceLength > 0) {
        paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.setAudioData(paramMessageForPtt.waveformArray, ((RelativeLayout.LayoutParams)localObject).width - AIOUtils.b(i, localContext.getResources()), paramMessageForPtt.voiceLength);
      }
      paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.setVisibility(0);
      paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVoicePrintUtils$VoicePrintView.setVisibility(8);
    }
  }
  
  private void a(PttItemBuilder.Holder paramHolder, MessageForPtt paramMessageForPtt, View paramView)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isVideoChatting())
    {
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, 1, 2131695163, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299168));
      return;
    }
    PttAudioWaveView localPttAudioWaveView = (PttAudioWaveView)paramView.findViewById(2131374101);
    if (localPttAudioWaveView != null)
    {
      float f = paramMessageForPtt.playProgress;
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onClick, onPlayProgress progress = ");
        localStringBuilder.append(f);
        QLog.d("PttItemBuilder", 2, localStringBuilder.toString());
      }
      if (f == 1.0F)
      {
        localPttAudioWaveView.setProgress(0.0F);
        paramMessageForPtt.playProgress = 0.0F;
      }
      else
      {
        i = (int)(f * (paramMessageForPtt.voiceLength * 1000.0F));
        break label148;
      }
    }
    int i = 0;
    label148:
    if (QLog.isColorLevel())
    {
      paramMessageForPtt = new StringBuilder();
      paramMessageForPtt.append("onClick, onPlayProgress offset = ");
      paramMessageForPtt.append(i);
      QLog.d("PttItemBuilder", 2, paramMessageForPtt.toString());
    }
    MediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(paramHolder.jdField_b_of_type_Int);
    ReportController.b(null, "dc00898", "", "", "0X8009D00", "0X8009D00", 1, 0, "", "", "", "");
    if (!MediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(AIOUtils.a(paramView), i)) {
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, 1, 2131695162, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299168));
    }
  }
  
  private void a(PttItemBuilder.Holder paramHolder, MessageForPtt paramMessageForPtt, boolean paramBoolean)
  {
    paramHolder.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-16777216);
    if (paramHolder.jdField_a_of_type_ComEtrumpMixlayoutETTextView != null)
    {
      paramHolder.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setTextColor(-16777216);
      if ((((ISttManagerService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(ISttManagerService.class)).isTranslating(paramMessageForPtt)) && (!paramMessageForPtt.getSttResult().a())) {
        paramHolder.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setTextColor(PttAudioWaveView.a(-16777216, 0.5F));
      }
    }
    if (paramHolder.jdField_b_of_type_AndroidWidgetTextView != null) {
      paramHolder.jdField_b_of_type_AndroidWidgetTextView.setTextColor(-16777216);
    }
    if (!paramBoolean) {
      a(-16777216, paramHolder);
    }
  }
  
  private void a(PttItemBuilder.Holder paramHolder, MessageForPtt paramMessageForPtt, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    Resources localResources = this.jdField_a_of_type_AndroidContentContext.getResources();
    int j = AIOUtils.b(9.0F, localResources);
    int n = AIOUtils.b(1.5F, localResources);
    int k = AIOUtils.b(12.0F, localResources);
    int m = AIOUtils.b(10.0F, localResources);
    int i;
    try
    {
      i = localResources.getDrawable(2130844831).getIntrinsicHeight();
    }
    catch (Exception localException)
    {
      i = AIOUtils.b(24.0F, localResources);
      QLog.e("PttItemBuilder", 1, "", localException);
    }
    int i1 = AIOUtils.b(1.0F, localResources);
    int i2 = AIOUtils.b(1.5F, localResources);
    paramHolder.jdField_a_of_type_AndroidWidgetTextView.setPadding(0, BaseChatItemLayout.m, j, BaseChatItemLayout.n);
    paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.setPadding(0, 0, n, 0);
    paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioChangeView.setPadding(0, 0, i2, 0);
    Object localObject1 = (RelativeLayout.LayoutParams)paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView.getLayoutParams();
    if (paramBoolean)
    {
      ((RelativeLayout.LayoutParams)localObject1).width = AIOUtils.b(35.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView.setPadding(AIOUtils.b(2.0F, localResources) + j, 0, 0, 0);
    }
    else
    {
      ((RelativeLayout.LayoutParams)localObject1).width = AIOUtils.b(44.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView.setPadding(AIOUtils.b(2.0F, localResources) + j, 0, j, 0);
    }
    if (paramInt1 == 2)
    {
      if (paramHolder.jdField_a_of_type_ComEtrumpMixlayoutETTextView == null)
      {
        localObject1 = new ImageView(this.jdField_a_of_type_AndroidContentContext);
        ((ImageView)localObject1).setImageDrawable(new ColorDrawable(838860800));
        RelativeLayout.LayoutParams localLayoutParams1 = new RelativeLayout.LayoutParams(-1, i1);
        ((ImageView)localObject1).setLayoutParams(localLayoutParams1);
        ((ImageView)localObject1).setId(2131374118);
        ETTextView localETTextView = new ETTextView(this.jdField_a_of_type_AndroidContentContext);
        if (paramMessageForPtt.isSend()) {
          paramInt1 = 2131167079;
        } else {
          paramInt1 = 2131167075;
        }
        Object localObject2 = localResources.getColorStateList(paramInt1);
        if (localObject2 != null)
        {
          localETTextView.setTextColor((ColorStateList)localObject2);
          if ((paramInt2 == 5) && (paramHolder.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInfo != null) && (paramHolder.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInfo.jdField_b_of_type_Int != 0)) {
            localETTextView.setTextColor(PttAudioWaveView.a(paramHolder.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInfo.jdField_b_of_type_Int, 0.5F));
          }
        }
        localETTextView.setId(2131374117);
        localETTextView.setMaxWidth(BaseChatItemLayout.f);
        Object localObject4 = new RelativeLayout.LayoutParams(-2, -2);
        localObject2 = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
        ((RelativeLayout)localObject2).setId(2131374114);
        ProgressBar localProgressBar = new ProgressBar(this.jdField_a_of_type_AndroidContentContext);
        localProgressBar.setId(2131374115);
        Object localObject3 = new RelativeLayout.LayoutParams(AIOUtils.b(13.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), AIOUtils.b(13.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
        localProgressBar.setIndeterminate(true);
        localProgressBar.setIndeterminateDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130839401));
        ((RelativeLayout.LayoutParams)localObject3).topMargin = AIOUtils.b(13.0F, localResources);
        ((RelativeLayout.LayoutParams)localObject3).leftMargin = AIOUtils.b(16.0F, localResources);
        localProgressBar.setLayoutParams((ViewGroup.LayoutParams)localObject3);
        localObject3 = new TextView(BaseApplicationImpl.getContext());
        RelativeLayout.LayoutParams localLayoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        ((TextView)localObject3).setLayoutParams(localLayoutParams2);
        ((TextView)localObject3).setText(2131719263);
        ((TextView)localObject3).setTextSize(AIOUtils.b(4.0F, localResources));
        ((TextView)localObject3).setIncludeFontPadding(false);
        localLayoutParams2.addRule(5, 2131374117);
        localLayoutParams2.addRule(8, 2131374111);
        if ((paramInt2 != 5) && (paramInt2 != 6))
        {
          ((RelativeLayout.LayoutParams)localObject4).leftMargin = AIOUtils.b(0.0F, localResources);
          localProgressBar.setVisibility(8);
          ((TextView)localObject3).setVisibility(0);
          ((TextView)localObject3).setText(2131719263);
        }
        else
        {
          ((RelativeLayout.LayoutParams)localObject4).leftMargin = AIOUtils.b(25.0F, localResources);
          if (paramInt2 == 5)
          {
            localProgressBar.setVisibility(0);
            ((TextView)localObject3).setVisibility(8);
          }
          if (paramInt2 == 6)
          {
            localProgressBar.setVisibility(8);
            ((TextView)localObject3).setVisibility(0);
            ((TextView)localObject3).setText(2131719261);
          }
        }
        localETTextView.setLayoutParams((ViewGroup.LayoutParams)localObject4);
        ((RelativeLayout)localObject2).addView(localProgressBar);
        ((RelativeLayout)localObject2).addView(localETTextView);
        localObject4 = new ImageView(this.jdField_a_of_type_AndroidContentContext);
        ((ImageView)localObject4).setId(2131374111);
        localLayoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        ((ImageView)localObject4).setLayoutParams(localLayoutParams2);
        ((ImageView)localObject4).setImageResource(2130844831);
        ((ImageView)localObject4).setScaleType(ImageView.ScaleType.FIT_END);
        ((ImageView)localObject4).setOnClickListener(this);
        localLayoutParams1.addRule(3, 2131374098);
        localLayoutParams1.addRule(14);
        localLayoutParams2.addRule(3, 2131374118);
        localLayoutParams2.addRule(14);
        localLayoutParams2.addRule(6, 2131374114);
        localLayoutParams2.addRule(8, 2131374114);
        localLayoutParams1 = new RelativeLayout.LayoutParams(-2, -2);
        localLayoutParams1.addRule(3, 2131374118);
        ((RelativeLayout)localObject2).setLayoutParams(localLayoutParams1);
        paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemBreathAnimationLayout.addView((View)localObject1);
        paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemBreathAnimationLayout.addView((View)localObject2);
        paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemBreathAnimationLayout.addView((View)localObject4);
        paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemBreathAnimationLayout.addView((View)localObject3);
        paramHolder.e = ((ImageView)localObject1);
        paramHolder.jdField_a_of_type_ComEtrumpMixlayoutETTextView = localETTextView;
        paramHolder.f = ((ImageView)localObject4);
        paramHolder.jdField_b_of_type_AndroidWidgetTextView = ((TextView)localObject3);
        paramHolder.jdField_a_of_type_AndroidWidgetProgressBar = localProgressBar;
      }
      else
      {
        paramHolder.e.setVisibility(0);
        paramHolder.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setVisibility(0);
        paramHolder.f.setVisibility(0);
        localObject1 = (RelativeLayout.LayoutParams)paramHolder.jdField_a_of_type_ComEtrumpMixlayoutETTextView.getLayoutParams();
        if ((paramInt2 != 5) && (paramInt2 != 6))
        {
          ((RelativeLayout.LayoutParams)localObject1).leftMargin = AIOUtils.b(0.0F, localResources);
          paramHolder.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
          paramHolder.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
          paramHolder.jdField_b_of_type_AndroidWidgetTextView.setText(2131719263);
        }
        else
        {
          ((RelativeLayout.LayoutParams)localObject1).leftMargin = AIOUtils.b(25.0F, localResources);
          if (paramInt2 == 5)
          {
            paramHolder.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
            paramHolder.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
          }
          if (paramInt2 == 6)
          {
            ((RelativeLayout.LayoutParams)localObject1).leftMargin = AIOUtils.b(0.0F, localResources);
            paramHolder.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
            paramHolder.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
            paramHolder.jdField_b_of_type_AndroidWidgetTextView.setText(2131719261);
          }
        }
        paramHolder.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      }
      paramHolder.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setOnClickListener(this);
      paramHolder.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setOnTouchListener(paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioOnLongClickAndTouchListener);
      paramHolder.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setOnLongClickListener(paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioOnLongClickAndTouchListener);
      if ((paramInt2 != 5) && (paramInt2 != 6)) {
        paramHolder.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setTextSize(0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_Int);
      } else {
        paramHolder.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setTextSize(0, AIOUtils.b(17.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
      }
      paramHolder.jdField_a_of_type_ComTencentMobileqqActivitySelectableAIOSelectableDelegateProxy = new AIOSelectableDelegateProxy();
      paramHolder.jdField_a_of_type_ComTencentMobileqqActivitySelectableAIOSelectableDelegateProxy.a(paramHolder.jdField_a_of_type_ComEtrumpMixlayoutETTextView);
      paramHolder.jdField_a_of_type_ComTencentMobileqqActivitySelectableAIOSelectableDelegateProxy.a(paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout, paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout);
      paramHolder.jdField_a_of_type_ComTencentMobileqqActivitySelectableAIOSelectableDelegateProxy.b(paramMessageForPtt);
      localObject1 = (RelativeLayout.LayoutParams)paramHolder.e.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject1).addRule(5, 2131374098);
      ((RelativeLayout.LayoutParams)localObject1).addRule(7, 2131374098);
      localObject1 = (RelativeLayout.LayoutParams)paramHolder.jdField_a_of_type_ComEtrumpMixlayoutETTextView.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject1).addRule(5, 2131374098);
      ((RelativeLayout.LayoutParams)localObject1).addRule(7, 2131374098);
      paramInt1 = AIOUtils.b(22.0F, localResources);
      paramHolder.e.setPadding(j, 0, j, 0);
      paramHolder.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setPadding(j, BaseChatItemLayout.m, j, paramInt1 + i);
      paramHolder.f.setPadding(0, 0, 0, k);
      paramHolder.jdField_b_of_type_AndroidWidgetTextView.setPadding(j, 0, 0, m);
      paramMessageForPtt = a(paramMessageForPtt, paramInt2);
      paramHolder.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setText(paramMessageForPtt);
    }
  }
  
  private void a(PttItemBuilder.Holder paramHolder, MessageForPtt paramMessageForPtt, boolean paramBoolean, View paramView, ChatMessage paramChatMessage)
  {
    paramView = paramView.getResources();
    int i;
    if (paramChatMessage.isSend()) {
      i = 2131167079;
    } else {
      i = 2131167075;
    }
    paramView = paramView.getColorStateList(i);
    if ((paramHolder.jdField_a_of_type_AndroidWidgetTextView != null) && (paramView != null)) {
      paramHolder.jdField_a_of_type_AndroidWidgetTextView.setTextColor(paramView);
    }
    if ((paramHolder.jdField_a_of_type_ComEtrumpMixlayoutETTextView != null) && (paramView != null))
    {
      paramHolder.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setTextColor(paramView);
      if ((((ISttManagerService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(ISttManagerService.class)).isTranslating(paramMessageForPtt)) && (!paramMessageForPtt.getSttResult().a())) {
        paramHolder.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setTextColor(PttAudioWaveView.a(paramView.getDefaultColor(), 0.5F));
      }
    }
    if ((paramHolder.jdField_b_of_type_AndroidWidgetTextView != null) && (paramView != null)) {
      paramHolder.jdField_b_of_type_AndroidWidgetTextView.setTextColor(paramView);
    }
    if (!paramBoolean)
    {
      if (!paramChatMessage.isSend())
      {
        a(Color.parseColor("#424448"), paramHolder);
        return;
      }
      if (paramView != null) {
        a(paramView.getDefaultColor(), paramHolder);
      }
    }
  }
  
  private void a(PttItemBuilder.Holder paramHolder, MessageForPtt paramMessageForPtt, boolean paramBoolean, BubbleInfo paramBubbleInfo)
  {
    paramHolder.jdField_a_of_type_AndroidWidgetTextView.setTextColor(paramBubbleInfo.jdField_b_of_type_Int);
    if (paramHolder.jdField_a_of_type_ComEtrumpMixlayoutETTextView != null)
    {
      paramHolder.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setTextColor(paramBubbleInfo.jdField_b_of_type_Int);
      if ((((ISttManagerService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(ISttManagerService.class)).isTranslating(paramMessageForPtt)) && (!paramMessageForPtt.getSttResult().a())) {
        paramHolder.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setTextColor(PttAudioWaveView.a(paramBubbleInfo.jdField_b_of_type_Int, 0.5F));
      }
    }
    if (paramHolder.jdField_b_of_type_AndroidWidgetTextView != null) {
      paramHolder.jdField_b_of_type_AndroidWidgetTextView.setTextColor(paramBubbleInfo.jdField_b_of_type_Int);
    }
    if (!paramBoolean) {
      a(paramBubbleInfo.jdField_b_of_type_Int, paramHolder);
    }
  }
  
  private void a(MessageForPtt paramMessageForPtt, int paramInt)
  {
    float f = SonicHelper.a;
    Object localObject1;
    if (paramInt == 2131377773)
    {
      f = SonicHelper.b;
      localObject1 = "0X8009E7D";
    }
    else if (paramInt == 2131377770)
    {
      f = SonicHelper.c;
      localObject1 = "0X8009DE3";
    }
    else
    {
      localObject1 = "0X8009DE4";
    }
    if (paramMessageForPtt.isReady())
    {
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isVideoChatting())
      {
        QQToast.a(this.jdField_a_of_type_AndroidContentContext, 1, 2131695163, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299168));
        return;
      }
      boolean bool1 = AudioDeviceHelper.a(BaseApplicationImpl.getContext());
      boolean bool2 = AudioDeviceHelper.b(BaseApplicationImpl.getContext());
      paramInt = ((AudioPanelAioHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(128)).d();
      Object localObject2 = PlayModeUtils.a(((AudioPanelAioHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(128)).jdField_b_of_type_Boolean, bool1, bool2, paramInt, f);
      if (paramInt == 0) {
        ((AudioPanelAioHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(128)).i(PlayModeUtils.a(((AudioPanelAioHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(128)).jdField_b_of_type_Boolean, bool1, bool2));
      }
      if (!TextUtils.isEmpty((CharSequence)localObject2)) {
        QQToast.a(this.jdField_a_of_type_AndroidContentContext, (CharSequence)localObject2, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299168));
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.b() == 0) {
        paramInt = 1;
      } else {
        paramInt = 2;
      }
      ReportController.b(null, "dc00898", "", "", (String)localObject1, (String)localObject1, paramInt, 0, "", "", "", "");
      if (c(paramMessageForPtt)) {
        MediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(false);
      }
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("getMenuItem oriSpeed:");
        ((StringBuilder)localObject1).append(paramMessageForPtt.playSpeedPos);
        ((StringBuilder)localObject1).append(", newSpeed:");
        ((StringBuilder)localObject1).append(f);
        QLog.d("PttItemBuilder", 2, ((StringBuilder)localObject1).toString());
      }
      paramInt = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.a(paramMessageForPtt) + this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getHeaderViewsCount();
      int i = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getFirstVisiblePosition();
      if (paramInt >= 0)
      {
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getChildAt(paramInt - i);
        Object localObject3 = (PttItemBuilder.Holder)AIOUtils.a((View)localObject2);
        if ((localObject2 != null) && (localObject3 != null))
        {
          localObject1 = (MessageForPtt)((PttItemBuilder.Holder)localObject3).jdField_a_of_type_ComTencentMobileqqDataChatMessage;
          MediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(((PttItemBuilder.Holder)localObject3).jdField_b_of_type_Int);
          if (localObject1 != null) {
            ((MessageForPtt)localObject1).playSpeedPos = f;
          }
          ((PttItemBuilder.Holder)localObject3).jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView.setPlayState(true);
          ((PttItemBuilder.Holder)localObject3).jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.setCanSupportSlide(true);
          ((PttItemBuilder.Holder)localObject3).a(true);
          localObject2 = (PttAudioWaveView)((View)localObject2).findViewById(2131374101);
          if ((localObject2 != null) && (localObject1 != null))
          {
            f = ((MessageForPtt)localObject1).playProgress;
            if (QLog.isColorLevel())
            {
              localObject3 = new StringBuilder();
              ((StringBuilder)localObject3).append("onMenuItemClicked, progress = ");
              ((StringBuilder)localObject3).append(f);
              QLog.d("PttItemBuilder", 2, ((StringBuilder)localObject3).toString());
            }
            if (f == 1.0F)
            {
              ((PttAudioWaveView)localObject2).setProgress(0.0F);
            }
            else
            {
              paramInt = (int)(f * (((MessageForPtt)localObject1).voiceLength * 1000.0F));
              break label603;
            }
          }
        }
      }
      paramInt = 0;
      label603:
      if (!MediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(paramMessageForPtt, paramInt)) {
        QQToast.a(this.jdField_a_of_type_AndroidContentContext, 1, 2131695162, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299168));
      }
    }
  }
  
  private void a(MessageForPtt paramMessageForPtt, ChatMessage paramChatMessage)
  {
    if (c(paramMessageForPtt)) {
      MediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(false);
    }
    ChatActivityFacade.b(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
    PttInfoCollector.reportLongPressPtt(2);
  }
  
  private void a(QQCustomMenu paramQQCustomMenu)
  {
    paramQQCustomMenu.a(2131365311, this.jdField_a_of_type_AndroidContentContext.getString(2131719264), 2130838905);
    paramQQCustomMenu.a(2131367180, this.jdField_a_of_type_AndroidContentContext.getString(2131689948), 2130838912);
    paramQQCustomMenu.a(2131366494, this.jdField_a_of_type_AndroidContentContext.getString(2131692184), 2130838911);
    paramQQCustomMenu.a(2131377990, this.jdField_a_of_type_AndroidContentContext.getString(2131719260), 2130844831);
  }
  
  private void a(QQCustomMenu paramQQCustomMenu, MessageForPtt paramMessageForPtt)
  {
    if (b())
    {
      boolean bool1 = SonicHelper.a(paramMessageForPtt.playSpeedPos, SonicHelper.a);
      boolean bool2 = SonicHelper.a(paramMessageForPtt.playSpeedPos, SonicHelper.c);
      if (!bool1) {
        paramQQCustomMenu.a(2131377772, this.jdField_a_of_type_AndroidContentContext.getString(2131694925), 2130838909);
      }
      if (!bool2) {
        paramQQCustomMenu.a(2131377770, this.jdField_a_of_type_AndroidContentContext.getString(2131694920), 2130838909);
      }
      if (QLog.isColorLevel())
      {
        paramQQCustomMenu = new StringBuilder();
        paramQQCustomMenu.append("getMenuItem speed:");
        paramQQCustomMenu.append(paramMessageForPtt.playSpeedPos);
        QLog.d("PttItemBuilder", 2, paramQQCustomMenu.toString());
      }
    }
  }
  
  private boolean a(int paramInt, MessageForPtt paramMessageForPtt)
  {
    return ((paramInt == 2003) || (paramInt == 1003)) && (!paramMessageForPtt.isSend()) && (!paramMessageForPtt.isReadPtt);
  }
  
  private boolean a(PttItemBuilder.Holder paramHolder, MessageForPtt paramMessageForPtt)
  {
    Object localObject = this.jdField_a_of_type_AndroidContentContext.getResources();
    int i = AIOUtils.b(15.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    if (paramMessageForPtt.voiceLength <= 1) {
      paramMessageForPtt.voiceLength = ((IQQRecorderTempApi)QRoute.api(IQQRecorderTempApi.class)).getFilePlayTime(paramMessageForPtt);
    }
    if (paramMessageForPtt.voiceLength <= 0)
    {
      ((RelativeLayout.LayoutParams)paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.getLayoutParams()).width = i;
      paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.setVisibility(4);
      paramHolder.jdField_a_of_type_AndroidWidgetTextView.setText("");
      paramHolder.jdField_a_of_type_AndroidWidgetTextView.setPadding(AIOUtils.b(10.0F, (Resources)localObject), BaseChatItemLayout.m, AIOUtils.b(10.0F, (Resources)localObject), BaseChatItemLayout.n);
      if (paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVoicePrintUtils$VoicePrintView != null) {
        paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVoicePrintUtils$VoicePrintView.setVisibility(8);
      }
      return false;
    }
    if (paramMessageForPtt.voiceLength > a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "Normal_MaxPtt"))
    {
      if (paramMessageForPtt.longPttVipFlag == 1)
      {
        if (this.jdField_a_of_type_AndroidTextSpannableString == null)
        {
          this.jdField_a_of_type_AndroidTextSpannableString = new SpannableString("[v] QQ会员专享长语音");
          localObject = ((Resources)localObject).getDrawable(2130840420);
          ((Drawable)localObject).setBounds(0, -5, ((Drawable)localObject).getIntrinsicWidth() * 4 / 5 + 5, ((Drawable)localObject).getIntrinsicHeight() * 4 / 5);
          localObject = new OffsetableImageSpan((Drawable)localObject, 1).setOffset(0.05F);
          this.jdField_a_of_type_AndroidTextSpannableString.setSpan(localObject, 0, 3, 17);
        }
        paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setTailMessage(true, this.jdField_a_of_type_AndroidTextSpannableString, this);
      }
      else if (paramMessageForPtt.longPttVipFlag == 2)
      {
        if (this.b == null)
        {
          this.b = new SpannableString(HardCodeUtil.a(2131708709));
          localObject = ((Resources)localObject).getDrawable(2130840419);
          ((Drawable)localObject).setBounds(0, -5, ((Drawable)localObject).getIntrinsicWidth() * 4 / 5 + 5, ((Drawable)localObject).getIntrinsicHeight() * 4 / 5);
          localObject = new OffsetableImageSpan((Drawable)localObject, 1).setOffset(0.05F);
          this.b.setSpan(localObject, 0, 3, 17);
        }
        paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setTailMessage(true, this.b, this);
      }
      if (VasUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).getVipStatus().isSVip())
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
        String str = HttpUtil.getNetWorkTypeByStr();
        if (VasUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).getVipStatus().isSVip()) {
          paramHolder = "svip";
        } else {
          paramHolder = "vip";
        }
        VasWebviewUtil.a((String)localObject, "LongVoice", "TailView", "0", 1, 0, 0, str, "", paramHolder);
      }
    }
    if ((paramMessageForPtt.voiceLength > a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "ConvertText_MaxPtt")) && (paramMessageForPtt.autoToText != 2)) {
      paramMessageForPtt.sttAbility = 0;
    }
    return true;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, ChatMessage paramChatMessage)
  {
    paramQQAppInterface = MediaPlayerManager.a(paramQQAppInterface).a();
    return (paramQQAppInterface == paramChatMessage) || (((paramQQAppInterface instanceof MessageForPtt)) && (paramQQAppInterface.frienduin != null) && (paramQQAppInterface.frienduin.equals(paramChatMessage.frienduin)) && (paramQQAppInterface.uniseq == paramChatMessage.uniseq));
  }
  
  protected static boolean a(MessageForPtt paramMessageForPtt)
  {
    String str = ((IQQRecorderUtils)QRoute.api(IQQRecorderUtils.class)).getLastRecorderPath();
    return (paramMessageForPtt.fileSize == -2L) && (!TextUtils.isEmpty(str)) && (str.equals(paramMessageForPtt.getLocalFilePath()));
  }
  
  private boolean a(QQCustomMenu paramQQCustomMenu, MessageForPtt paramMessageForPtt)
  {
    if (ConfessMsgUtil.a(paramMessageForPtt)) {
      return true;
    }
    if (!paramMessageForPtt.isReady())
    {
      ChatActivityFacade.a(paramQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
      super.a(paramQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, 2131371603, null, null);
      super.a(paramQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, 2131362480, null, null);
      return true;
    }
    if (b(paramMessageForPtt) <= 0)
    {
      ChatActivityFacade.a(paramQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
      super.a(paramQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, 2131371603, null, null);
      super.a(paramQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, 2131362480, null, null);
      return true;
    }
    return false;
  }
  
  private int b(PttItemBuilder.Holder paramHolder, MessageForPtt paramMessageForPtt, int paramInt, boolean paramBoolean, String paramString)
  {
    boolean bool2 = ((IVoiceRedPacketHelper)QRoute.api(IVoiceRedPacketHelper.class)).isRedPackPTT(paramMessageForPtt);
    boolean bool1;
    if (paramMessageForPtt.voiceChangeFlag != 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    boolean bool3 = a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidWidgetBaseAdapter, paramHolder, paramMessageForPtt);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("showPttItem builder, voiceLength:");
      ((StringBuilder)localObject).append(paramMessageForPtt.voiceLength);
      QLog.d("PttItemBuilder", 2, ((StringBuilder)localObject).toString());
    }
    if (!a(paramHolder, paramMessageForPtt)) {
      return 0;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("showPttItem, msgText = ");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(", message.voiceLength");
      ((StringBuilder)localObject).append(paramMessageForPtt.voiceLength);
      QLog.d("PttItemBuilder", 2, ((StringBuilder)localObject).toString());
    }
    paramHolder.jdField_a_of_type_AndroidWidgetTextView.setText(paramString);
    a(paramHolder, bool3, bool1, paramMessageForPtt.isSend());
    paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemBreathAnimationLayout.setAnimating(false);
    paramHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this);
    if (paramMessageForPtt.isSend())
    {
      if (paramMessageForPtt.mRobotFlag == 1)
      {
        localObject = ((TroopRobotManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_ROBOT_MANAGER)).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForPtt);
        if (!TextUtils.isEmpty((CharSequence)localObject)) {
          paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setTailMessage(true, (CharSequence)localObject, null);
        }
      }
    }
    else
    {
      localObject = ((TroopRobotManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_ROBOT_MANAGER)).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForPtt);
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setTailMessage(true, (CharSequence)localObject, null);
      }
    }
    if (((paramInt == 2003) || (paramInt == 1003)) && (!paramMessageForPtt.isSend()) && (!paramMessageForPtt.isReadPtt)) {
      paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setUnread(true);
    }
    int i = b(paramMessageForPtt, paramInt, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    paramInt = a(paramMessageForPtt, paramInt, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    a(paramHolder, paramMessageForPtt, bool2, i, paramInt);
    Object localObject = a(paramMessageForPtt, paramInt);
    a(paramHolder, paramMessageForPtt, i, bool3, paramString, paramBoolean, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_Int, (String)localObject);
    return paramInt;
  }
  
  public static int b(MessageForPtt paramMessageForPtt, int paramInt, QQAppInterface paramQQAppInterface)
  {
    if ((paramInt == 2003) || (paramInt == 1003))
    {
      if ((paramMessageForPtt.sttAbility == 2) && (paramMessageForPtt.voiceChangeFlag != 1) && (paramMessageForPtt.expandStt)) {
        return 2;
      }
      if (((paramMessageForPtt.sttAbility == 1) || (paramMessageForPtt.sttAbility == 3)) && (((ISttManagerService)paramQQAppInterface.getRuntimeService(ISttManagerService.class)).isTranslating(paramMessageForPtt))) {
        return 2;
      }
      if ((paramMessageForPtt.sttAbility == 3) && (paramMessageForPtt.expandStt)) {
        return 2;
      }
    }
    return 1;
  }
  
  private String b(int paramInt, MessageForPtt paramMessageForPtt)
  {
    if ((paramInt == 1001) || (paramInt == 1002) || (paramInt == 1005) || (paramInt == 1004) || (paramInt == 2003) || (paramInt == 1003)) {
      if (paramMessageForPtt.voiceLength > a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "Normal_MaxPtt"))
      {
        if (paramMessageForPtt.longPttVipFlag == 1) {
          return "QQ会员专享长语音";
        }
      }
      else if (paramMessageForPtt.longPttVipFlag == 2) {
        return HardCodeUtil.a(2131708707);
      }
    }
    return null;
  }
  
  private void b(ChatMessage paramChatMessage)
  {
    if (QVipConfigManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "have_show_open_svip_gray_msg", false))
    {
      if (QLog.isColorLevel()) {
        QLog.d("vip_ptt.PttItemBuilder", 1, "ptt auto to txt msg have showed ,so click ptt msg not add msg");
      }
      return;
    }
    Object localObject1 = QVipAutoPttProcessor.c();
    Object localObject2 = (PttAutoChangeBean)QConfigManager.a().a(442);
    if ((localObject2 != null) && (((PttAutoChangeBean)localObject2).a()))
    {
      if (((QVipAutoPttConfig)localObject1).jdField_a_of_type_Int != 3)
      {
        if (QLog.isColorLevel())
        {
          paramChatMessage = new StringBuilder();
          paramChatMessage.append("ptt auto to txt is open but stage=");
          paramChatMessage.append(((QVipAutoPttConfig)localObject1).jdField_a_of_type_Int);
          paramChatMessage.append(",so click ptt msg not add msg");
          QLog.d("vip_ptt.PttItemBuilder", 1, paramChatMessage.toString());
        }
        return;
      }
      if (PttConstants.c)
      {
        if (QLog.isColorLevel()) {
          QLog.d("vip_ptt.PttItemBuilder", 1, "ptt auto to txt is open but switch is open ,so click ptt msg not add msg");
        }
        return;
      }
      localObject2 = HardCodeUtil.a(2131708708);
      localObject1 = new Bundle();
      ((Bundle)localObject1).putInt("key_action", 41);
      ((Bundle)localObject1).putString("textColor", "#40A0FF");
      localObject2 = new UniteGrayTipParam(paramChatMessage.frienduin, paramChatMessage.selfuin, (String)localObject2, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, -5020, 655392, ((MessageForPtt)paramChatMessage).time);
      ((UniteGrayTipParam)localObject2).a(15, 19, (Bundle)localObject1);
      localObject1 = new MessageForUniteGrayTip();
      if (paramChatMessage.istroop == 1) {
        ((MessageForUniteGrayTip)localObject1).shmsgseq = paramChatMessage.shmsgseq;
      }
      ((MessageForUniteGrayTip)localObject1).initGrayTipMsg(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (UniteGrayTipParam)localObject2);
      UniteGrayTipMsgUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (MessageForUniteGrayTip)localObject1);
      paramChatMessage = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("check_update_sp_key", 0);
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("businessinfo_ptt_auto_change_guide_has_show_");
      ((StringBuilder)localObject1).append(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      localObject1 = ((StringBuilder)localObject1).toString();
      paramChatMessage.edit().putBoolean((String)localObject1, true).commit();
      PttConstants.d = true;
      QVipConfigManager.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "have_show_open_svip_gray_msg", true);
      QLog.e("vip_ptt.PttItemBuilder", 1, "stage 3 add gray msg seccess");
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("vip_ptt.PttItemBuilder", 1, "ptt auto to txt is close ,so click ptt msg not add msg");
    }
  }
  
  private void b(MessageForPtt paramMessageForPtt, int paramInt)
  {
    ((ISttManagerService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(ISttManagerService.class)).translate(paramMessageForPtt, paramInt);
  }
  
  private void b(MessageForPtt paramMessageForPtt, ChatMessage paramChatMessage)
  {
    if (!AppNetConnInfo.isNetSupport())
    {
      paramMessageForPtt = a();
      if (paramMessageForPtt != null) {
        paramMessageForPtt.b();
      }
      return;
    }
    int i = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.a(paramMessageForPtt) + this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getHeaderViewsCount();
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("autochange pos is:");
      ((StringBuilder)localObject).append(i);
      QLog.d("Q.msg.delmsg", 2, ((StringBuilder)localObject).toString());
    }
    if (i < 0) {
      return;
    }
    int j = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getFirstVisiblePosition();
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getChildAt(i - j);
    if (localObject == null) {
      return;
    }
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005B40", "0X8005B40", 0, 0, "", "", "", "");
    ReportController.b(null, "dc00898", "", "", "0X8009DF7", "0X8009DF7", 0, 0, "", "", "", "");
    localObject = (PttItemBuilder.Holder)((View)localObject).getTag();
    PttInfoCollector.reportLongPressPtt(5);
    if ((paramMessageForPtt.sttAbility != 1) && (paramMessageForPtt.sttAbility != 3))
    {
      if ((paramMessageForPtt.sttAbility == 2) && (!paramMessageForPtt.expandStt))
      {
        paramMessageForPtt.expandStt = true;
        paramMessageForPtt.serial();
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, paramMessageForPtt.uniseq, paramMessageForPtt.msgData);
        a((PttItemBuilder.Holder)localObject, paramMessageForPtt, a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForPtt), c(paramMessageForPtt));
        a((BaseBubbleBuilder.ViewHolder)localObject, ((PttItemBuilder.Holder)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout, paramMessageForPtt, ((PttItemBuilder.Holder)localObject).jdField_a_of_type_ComTencentMobileqqBubbleBubbleInfo);
      }
    }
    else
    {
      if ((paramMessageForPtt.sttAbility == 3) && (!paramMessageForPtt.expandStt)) {
        paramMessageForPtt.expandStt = true;
      }
      b(paramChatMessage);
      this.jdField_a_of_type_JavaUtilMap.put(Long.valueOf(paramChatMessage.uniseq), "");
      b(paramMessageForPtt, 1);
      ((ISttManagerService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(ISttManagerService.class)).setListener(this);
      a((PttItemBuilder.Holder)localObject, paramMessageForPtt, a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForPtt), c(paramMessageForPtt));
    }
  }
  
  private void c(MessageForPtt paramMessageForPtt)
  {
    paramMessageForPtt.isReadPtt = true;
    paramMessageForPtt.serial();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, paramMessageForPtt.uniseq, paramMessageForPtt.msgData);
  }
  
  private void d(MessageForPtt paramMessageForPtt)
  {
    int i = ((IQQRecorderTempApi)QRoute.api(IQQRecorderTempApi.class)).getFilePlayTime(paramMessageForPtt);
    if (i <= 0) {
      return;
    }
    QfavMicroPhoneDialog localQfavMicroPhoneDialog = new QfavMicroPhoneDialog(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForPtt.voiceType, new PttItemBuilder.1(this, paramMessageForPtt));
    if (paramMessageForPtt.isSend()) {
      localObject = paramMessageForPtt.selfuin;
    } else {
      localObject = paramMessageForPtt.senderuin;
    }
    Drawable localDrawable = null;
    if (AnonymousChatHelper.a(paramMessageForPtt)) {
      localDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130843811);
    }
    Bitmap localBitmap = this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.getBitmapFromCache(1, (String)localObject);
    Object localObject = localBitmap;
    if (localBitmap == null) {
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.getBitmapFromCache(1, paramMessageForPtt.frienduin);
    }
    if (localQfavMicroPhoneDialog.a(paramMessageForPtt.getLocalFilePath(), i, (Bitmap)localObject, localDrawable)) {
      localQfavMicroPhoneDialog.show();
    } else {
      QfavUtil.a(this.jdField_a_of_type_AndroidContentContext, 2131692186, 1);
    }
    PttInfoCollector.reportLongPressPtt(1);
  }
  
  private boolean d(ChatMessage paramChatMessage)
  {
    return paramChatMessage.vipBubbleID >= 1L;
  }
  
  private void e(MessageForPtt paramMessageForPtt)
  {
    if (TextUtils.isEmpty(paramMessageForPtt.sttText)) {
      paramMessageForPtt = this.jdField_a_of_type_AndroidContentContext.getString(2131719265);
    } else {
      paramMessageForPtt = paramMessageForPtt.sttText;
    }
    PttInfoCollector.reportLongPressPtt(3);
    try
    {
      int i = Build.VERSION.SDK_INT;
      if (i < 11)
      {
        ((android.text.ClipboardManager)this.jdField_a_of_type_AndroidContentContext.getSystemService("clipboard")).setText(paramMessageForPtt);
      }
      else
      {
        android.content.ClipboardManager localClipboardManager = (android.content.ClipboardManager)this.jdField_a_of_type_AndroidContentContext.getSystemService("clipboard");
        paramMessageForPtt = ClipData.newPlainText("msg", paramMessageForPtt);
        ClipboardMonitor.setPrimaryClip(localClipboardManager, paramMessageForPtt);
        localClipboardManager.setPrimaryClip(paramMessageForPtt);
      }
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8007359", "0X8007359", 0, 0, "", "", "", "");
      return;
    }
    catch (Exception paramMessageForPtt) {}
  }
  
  private void f(MessageForPtt paramMessageForPtt)
  {
    PttInfoCollector.reportLongPressPtt(4);
    if ((paramMessageForPtt.sttText != null) && (paramMessageForPtt.sttText.length() > 0))
    {
      Bundle localBundle = new Bundle();
      localBundle.putInt("forward_type", -1);
      localBundle.putString("forward_text", paramMessageForPtt.sttText);
      localBundle.putInt("selection_mode", this.c);
      paramMessageForPtt = new Intent();
      paramMessageForPtt.putExtras(localBundle);
      ForwardBaseOption.a((Activity)this.jdField_a_of_type_AndroidContentContext, paramMessageForPtt, 21);
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004045", "0X8004045", 0, 0, "", "", "", "");
      return;
    }
    QQToast.a(this.jdField_a_of_type_AndroidContentContext, HardCodeUtil.a(2131708714), 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299168));
  }
  
  private void g(MessageForPtt paramMessageForPtt)
  {
    if (paramMessageForPtt.sttAbility == 2)
    {
      if (!paramMessageForPtt.expandStt) {
        return;
      }
      int i = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.a(paramMessageForPtt) + this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getHeaderViewsCount();
      if (QLog.isColorLevel())
      {
        paramMessageForPtt = new StringBuilder();
        paramMessageForPtt.append("autochange pos is:");
        paramMessageForPtt.append(i);
        QLog.d("Q.msg.delmsg", 2, paramMessageForPtt.toString());
      }
      if (i < 0) {
        return;
      }
      int j = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getFirstVisiblePosition();
      paramMessageForPtt = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getChildAt(i - j);
      if (paramMessageForPtt == null) {
        return;
      }
      ((PttItemBuilder.Holder)paramMessageForPtt.getTag()).jdField_a_of_type_ComEtrumpMixlayoutETTextView.performClick();
    }
  }
  
  private void h(MessageForPtt paramMessageForPtt)
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
    if (localObject1 == null) {
      return;
    }
    boolean bool1 = ((AudioPanelAioHelper)((BaseChatPie)localObject1).a(128)).jdField_b_of_type_Boolean;
    int i;
    if (bool1) {
      i = 9;
    } else {
      i = 10;
    }
    PttInfoCollector.reportLongPressPtt(i);
    if (paramMessageForPtt.isReady())
    {
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isVideoChatting())
      {
        QQToast.a(this.jdField_a_of_type_AndroidContentContext, 1, 2131695163, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299168));
        return;
      }
      AudioDeviceHelper.a(bool1 ^ true, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      boolean bool2 = bool1 ^ true;
      ((AudioPanelAioHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(128)).jdField_b_of_type_Boolean = bool2;
      MediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).c();
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null))
      {
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO;
        if (!bool2) {
          bool1 = true;
        } else {
          bool1 = false;
        }
        ((NavBarAIO)localObject1).a(bool1, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
      }
      bool1 = AudioDeviceHelper.a(BaseApplicationImpl.getContext());
      boolean bool3 = AudioDeviceHelper.b(BaseApplicationImpl.getContext());
      ((AudioPanelAioHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(128)).b(BaseApplicationImpl.getContext(), bool2, bool1, bool3);
      if (c(paramMessageForPtt)) {
        MediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(false);
      }
      i = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.a(paramMessageForPtt) + this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getHeaderViewsCount();
      int j = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getFirstVisiblePosition();
      if (i >= 0)
      {
        Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getChildAt(i - j);
        Object localObject3 = (PttItemBuilder.Holder)AIOUtils.a((View)localObject2);
        if ((localObject2 != null) && (localObject3 != null))
        {
          localObject1 = (MessageForPtt)((PttItemBuilder.Holder)localObject3).jdField_a_of_type_ComTencentMobileqqDataChatMessage;
          MediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(((PttItemBuilder.Holder)localObject3).jdField_b_of_type_Int);
          ((PttItemBuilder.Holder)localObject3).jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView.setPlayState(true);
          ((PttItemBuilder.Holder)localObject3).jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.setCanSupportSlide(true);
          ((PttItemBuilder.Holder)localObject3).a(true);
          localObject2 = (PttAudioWaveView)((View)localObject2).findViewById(2131374101);
          if ((localObject2 != null) && (localObject1 != null))
          {
            float f = ((MessageForPtt)localObject1).playProgress;
            if (QLog.isColorLevel())
            {
              localObject3 = new StringBuilder();
              ((StringBuilder)localObject3).append("onMenuItemClicked, progress = ");
              ((StringBuilder)localObject3).append(f);
              QLog.d("PttItemBuilder", 2, ((StringBuilder)localObject3).toString());
            }
            if (f == 1.0F)
            {
              ((PttAudioWaveView)localObject2).setProgress(0.0F);
            }
            else
            {
              i = (int)(f * (((MessageForPtt)localObject1).voiceLength * 1000.0F));
              break label487;
            }
          }
        }
      }
      i = 0;
      label487:
      if (!MediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(paramMessageForPtt, i)) {
        QQToast.a(this.jdField_a_of_type_AndroidContentContext, 1, 2131695162, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299168));
      }
    }
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    return 1;
  }
  
  protected View a(ChatMessage paramChatMessage, BaseBubbleBuilder.ViewHolder paramViewHolder, View paramView, BaseChatItemLayout paramBaseChatItemLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    paramChatMessage = b(paramChatMessage, paramViewHolder, paramView, paramBaseChatItemLayout, paramOnLongClickAndTouchListener);
    FileTransferManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(paramViewHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout, this);
    if (AppSetting.d) {
      paramViewHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setOnClickListener(this);
    }
    paramViewHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setMiniAioShieldItemTouchListener(this);
    return paramChatMessage;
  }
  
  public BaseBubbleBuilder.TouchDelegate a(View paramView)
  {
    if (AIOUtils.a(paramView) != null) {
      return this;
    }
    return null;
  }
  
  protected BaseBubbleBuilder.ViewHolder a()
  {
    return new PttItemBuilder.Holder();
  }
  
  @Nullable
  protected PttSttHelper a()
  {
    BaseChatPie localBaseChatPie = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
    if (localBaseChatPie == null) {
      return null;
    }
    return (PttSttHelper)localBaseChatPie.a(82);
  }
  
  protected String a(ChatMessage paramChatMessage)
  {
    if (MessageRecordInfo.a(paramChatMessage.issend)) {
      return HardCodeUtil.a(2131708704);
    }
    return HardCodeUtil.a(2131708705);
  }
  
  public void a()
  {
    ((ISttManagerService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(ISttManagerService.class)).setListener(null);
    Iterator localIterator = this.jdField_a_of_type_JavaUtilSet.iterator();
    while (localIterator.hasNext()) {
      ((PttItemBuilder.Holder)localIterator.next()).a();
    }
    this.jdField_a_of_type_JavaUtilSet.clear();
    this.jdField_a_of_type_JavaUtilSet = null;
    this.jdField_a_of_type_JavaUtilMap.clear();
  }
  
  @TargetApi(11)
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    if (paramChatMessage != null)
    {
      if (!(paramChatMessage instanceof MessageForPtt)) {
        return;
      }
      MessageForPtt localMessageForPtt = (MessageForPtt)paramChatMessage;
      if (2131366494 == paramInt)
      {
        d(localMessageForPtt);
        return;
      }
      if (paramInt == 2131365480)
      {
        a(localMessageForPtt, paramChatMessage);
        return;
      }
      if (paramInt == 2131371603)
      {
        PttInfoCollector.reportLongPressPtt(6);
        super.a(paramInt, paramContext, paramChatMessage);
        return;
      }
      if (paramInt == 2131365311)
      {
        e(localMessageForPtt);
        return;
      }
      if (paramInt == 2131367180)
      {
        f(localMessageForPtt);
        return;
      }
      if (paramInt == 2131377990)
      {
        g(localMessageForPtt);
        return;
      }
      if (paramInt == 2131377991)
      {
        b(localMessageForPtt, paramChatMessage);
        return;
      }
      if (paramInt == 2131371562)
      {
        if (c(localMessageForPtt)) {
          MediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(true);
        }
        super.a(paramInt, paramContext, paramChatMessage);
        return;
      }
      if (paramInt == 2131372837)
      {
        h(localMessageForPtt);
        return;
      }
      if ((paramInt != 2131377772) && (paramInt != 2131377773) && (paramInt != 2131377770))
      {
        super.a(paramInt, paramContext, paramChatMessage);
        return;
      }
      a(localMessageForPtt, paramInt);
    }
  }
  
  public void a(int paramInt, RedPacketInfo paramRedPacketInfo)
  {
    if (paramRedPacketInfo != null)
    {
      if (paramInt != 6) {
        return;
      }
      if (paramRedPacketInfo.icon != null) {
        a(paramRedPacketInfo.a);
      }
    }
  }
  
  protected void a(View paramView)
  {
    MessageForPtt localMessageForPtt = (MessageForPtt)AIOUtils.a(paramView);
    paramView = (PttItemBuilder.Holder)AIOUtils.a(paramView);
    if (localMessageForPtt.isSendFromLocal())
    {
      paramView = ActionSheet.create(this.jdField_a_of_type_AndroidContentContext);
      paramView.setMainTitle(2131689934);
      paramView.addButton(2131689933);
      paramView.addCancelButton(2131690728);
      paramView.setOnButtonClickListener(new PttItemBuilder.3(this, localMessageForPtt, paramView));
      paramView.show();
      return;
    }
    if ((Environment.getExternalStorageState().equals("mounted")) && (new StatFs(Environment.getExternalStorageDirectory().getAbsolutePath()).getAvailableBlocks() >= 1))
    {
      a(paramView, localMessageForPtt, true, false);
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("fileStatus:2001|url ");
        localStringBuilder.append(localMessageForPtt.url);
        localStringBuilder.append("|uniseq ");
        localStringBuilder.append(localMessageForPtt.uniseq);
        QLog.d("PTTItem->onErrorIconClick", 2, localStringBuilder.toString());
      }
      a(paramView, localMessageForPtt, 2001, false);
      return;
    }
    if (!Environment.getExternalStorageState().equals("mounted"))
    {
      QQToast.a(BaseApplication.getContext(), 2131694486, 0).b(BaseApplication.getContext().getResources().getDimensionPixelSize(2131299168));
      return;
    }
    QQToast.a(BaseApplication.getContext(), 2131718576, 0).b(BaseApplication.getContext().getResources().getDimensionPixelSize(2131299168));
  }
  
  public void a(View paramView, MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    if ((i != 1) && (i != 3)) {
      return;
    }
    paramView = (PttItemBuilder.Holder)((View)paramView.getParent().getParent()).getTag();
    if (paramView != null)
    {
      paramView = paramView.jdField_a_of_type_ComTencentMobileqqActivityAioItemBreathAnimationLayout.getBackground();
      if (paramView != null)
      {
        paramView.setColorFilter(null);
        paramView.invalidateSelf();
      }
    }
  }
  
  public void a(View paramView, ChatMessage paramChatMessage, int paramInt)
  {
    Object localObject = (MessageForPtt)paramChatMessage;
    int i = 1;
    if (paramInt == 889)
    {
      paramInt = i;
    }
    else
    {
      super.a(paramView, paramChatMessage, paramInt);
      paramInt = i;
      if (((MessageForPtt)localObject).voiceChangeFlag == 0) {
        if (((MessageForPtt)localObject).sendFromvoiceChangePanelFlag) {
          paramInt = i;
        } else {
          paramInt = 0;
        }
      }
    }
    if ((paramInt != 0) && (paramView != null))
    {
      localObject = (BaseBubbleBuilder.ViewHolder)paramView.getTag();
      paramView = (BaseChatItemLayout)paramView;
      b(paramChatMessage, (BaseBubbleBuilder.ViewHolder)localObject, ((BaseBubbleBuilder.ViewHolder)localObject).jdField_a_of_type_AndroidViewView, paramView, null);
    }
  }
  
  public void a(View paramView, boolean paramBoolean)
  {
    try
    {
      if ((paramView instanceof PttAudioWaveView)) {
        localObject1 = (View)paramView.getParent().getParent().getParent();
      } else {
        localObject1 = (View)paramView.getParent().getParent();
      }
      Object localObject2 = (PttItemBuilder.Holder)((View)localObject1).getTag();
      if (localObject2 != null)
      {
        localObject2 = ((PttItemBuilder.Holder)localObject2).jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView;
        paramView = AIOUtils.a((View)paramView.getParent().getParent().getParent());
        if ((paramView != null) && ((paramView instanceof MessageForPtt))) {
          if (paramBoolean)
          {
            if (((MessageForPtt)paramView).playProgress > 0.0F) {
              ((PttAudioWaveView)localObject2).setCanSupportSlide(true);
            }
          }
          else if (c(paramView)) {
            ((PttAudioWaveView)localObject2).setCanSupportSlide(false);
          }
        }
      }
    }
    catch (Exception paramView)
    {
      Object localObject1;
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("longClicked:");
        ((StringBuilder)localObject1).append(paramView.toString());
        QLog.d("PttItemBuilder", 2, ((StringBuilder)localObject1).toString());
      }
      return;
    }
    for (paramView = jdField_a_of_type_AndroidGraphicsColorFilter;; paramView = null)
    {
      a((View)localObject1, paramView);
      return;
      if (!paramBoolean) {
        break;
      }
    }
  }
  
  protected void a(BaseBubbleBuilder.ViewHolder paramViewHolder, View paramView, ChatMessage paramChatMessage, BubbleInfo paramBubbleInfo)
  {
    paramViewHolder = (PttItemBuilder.Holder)paramViewHolder;
    MessageForPtt localMessageForPtt = (MessageForPtt)paramChatMessage;
    boolean bool = a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidWidgetBaseAdapter, paramViewHolder, localMessageForPtt);
    if ((paramBubbleInfo.jdField_a_of_type_Int != 0) && (paramBubbleInfo.a()))
    {
      if (paramBubbleInfo.jdField_b_of_type_Int == 0) {
        a(paramViewHolder, localMessageForPtt, bool);
      } else {
        a(paramViewHolder, localMessageForPtt, bool, paramBubbleInfo);
      }
      if ((paramBubbleInfo.jdField_b_of_type_Boolean) && (((ChatBackgroundManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.CHAT_BACKGROUND_MANAGER)).a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramViewHolder.jdField_a_of_type_AndroidWidgetTextView.getCurrentTextColor(), paramViewHolder.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInfo.jdField_a_of_type_Double * 10000.0D) == 1))
      {
        float f2 = paramViewHolder.jdField_a_of_type_AndroidWidgetTextView.getTextSize() * 3.0F / 16.0F;
        float f1 = f2;
        if (f2 > 25.0F) {
          f1 = 25.0F;
        }
        paramViewHolder.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-1);
        paramViewHolder.jdField_a_of_type_AndroidWidgetTextView.setShadowLayer(f1, 0.0F, 0.0F, paramBubbleInfo.d);
        if (!bool) {
          a(-1, paramViewHolder);
        }
      }
      return;
    }
    a(paramViewHolder, localMessageForPtt, bool, paramView, paramChatMessage);
  }
  
  public void a(PttAudioWaveView paramPttAudioWaveView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PttItemBuilder", 2, "onStartSeek ");
    }
    paramPttAudioWaveView = (PttItemBuilder.Holder)AIOUtils.a(paramPttAudioWaveView);
    if (paramPttAudioWaveView != null)
    {
      MediaPlayerManager localMediaPlayerManager = MediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      localMediaPlayerManager.a(localMediaPlayerManager.a(), paramPttAudioWaveView.jdField_a_of_type_ComTencentMobileqqDataChatMessage);
    }
    MediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(false);
  }
  
  public void a(PttAudioWaveView paramPttAudioWaveView, float paramFloat)
  {
    Object localObject = (PttItemBuilder.Holder)AIOUtils.a(paramPttAudioWaveView);
    if (localObject != null)
    {
      paramPttAudioWaveView = (MessageForPtt)((PttItemBuilder.Holder)localObject).jdField_a_of_type_ComTencentMobileqqDataChatMessage;
      if (paramPttAudioWaveView != null) {
        paramPttAudioWaveView.playProgress = paramFloat;
      }
      if ((((PttItemBuilder.Holder)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView != null) && (!((PttItemBuilder.Holder)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView.b())) {
        return;
      }
      if (paramPttAudioWaveView != null)
      {
        int i = (int)(paramFloat * (paramPttAudioWaveView.voiceLength * 1000.0F));
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("onSeekProgressUpdate, offset = ");
          ((StringBuilder)localObject).append(i);
          QLog.d("PttItemBuilder", 2, ((StringBuilder)localObject).toString());
        }
        MediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(paramPttAudioWaveView, i);
      }
    }
  }
  
  protected void a(PttItemBuilder.Holder paramHolder, MessageForPtt paramMessageForPtt, int paramInt, boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("fileStatus is:");
      ((StringBuilder)localObject1).append(paramInt);
      ((StringBuilder)localObject1).append(",url is:");
      ((StringBuilder)localObject1).append(paramMessageForPtt.url);
      ((StringBuilder)localObject1).append(",uniseq is:");
      ((StringBuilder)localObject1).append(paramMessageForPtt.uniseq);
      ((StringBuilder)localObject1).append(",stt is:");
      ((StringBuilder)localObject1).append(paramMessageForPtt.sttAbility);
      ((StringBuilder)localObject1).append(",long is:");
      ((StringBuilder)localObject1).append(paramMessageForPtt.longPttVipFlag);
      ((StringBuilder)localObject1).append(", voiceLength is: ");
      ((StringBuilder)localObject1).append(paramMessageForPtt.voiceLength);
      QLog.d("PttItemBuilder", 2, ((StringBuilder)localObject1).toString());
    }
    paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setUnread(false);
    Object localObject1 = (RelativeLayout.LayoutParams)paramHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject1).addRule(0, -1);
    ((RelativeLayout.LayoutParams)localObject1).addRule(1, -1);
    if (paramHolder.c != null)
    {
      paramHolder.c.setVisibility(8);
      paramHolder.c.setOnClickListener(null);
      paramHolder.d.setVisibility(8);
    }
    if ((paramHolder.jdField_a_of_type_ComTencentMobileqqActivitySelectableAIOSelectableDelegateProxy != null) && (paramHolder.jdField_a_of_type_ComTencentMobileqqActivitySelectableAIOSelectableDelegateProxy.c()) && (paramHolder.jdField_a_of_type_ComTencentMobileqqActivitySelectableAIOSelectableDelegateProxy.a()))
    {
      paramHolder.jdField_a_of_type_ComTencentMobileqqActivitySelectableAIOSelectableDelegateProxy.b();
      paramHolder.jdField_a_of_type_ComTencentMobileqqActivitySelectableAIOSelectableDelegateProxy.d();
    }
    if (paramHolder.jdField_a_of_type_ComEtrumpMixlayoutETTextView != null)
    {
      paramHolder.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setVisibility(8);
      paramHolder.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setOnClickListener(null);
      paramHolder.e.setVisibility(8);
      paramHolder.f.setVisibility(8);
      paramHolder.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      paramHolder.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
    }
    paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setTailMessage(false, null, null);
    paramHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnTouchListener(paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioOnLongClickAndTouchListener);
    paramHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnLongClickListener(paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioOnLongClickAndTouchListener);
    boolean bool1 = a(paramMessageForPtt, paramHolder);
    boolean bool2 = a(paramInt, paramMessageForPtt);
    String str = a(paramInt, paramMessageForPtt);
    int i = a(paramHolder, paramMessageForPtt, paramInt, paramBoolean, str);
    localObject1 = b(paramInt, paramMessageForPtt);
    if (paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView != null) {
      paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.setSeekListener(this);
    }
    Object localObject2;
    if (i != 1)
    {
      if ((i != 4) && (i != 7))
      {
        paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(false, null);
        if (paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.jdField_a_of_type_AndroidWidgetImageView != null) {
          paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(null);
        }
      }
      else
      {
        paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconResource(2130839406, null);
        paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(null);
        ((Animatable)paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.jdField_a_of_type_AndroidWidgetImageView.getDrawable()).start();
      }
    }
    else
    {
      paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
      paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(null);
      localObject2 = paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.jdField_a_of_type_AndroidWidgetImageView;
      if (paramMessageForPtt.isSendFromLocal()) {
        paramInt = 2131708711;
      } else {
        paramInt = 2131708703;
      }
      ((ImageView)localObject2).setContentDescription(HardCodeUtil.a(paramInt));
    }
    if (bool1)
    {
      paramMessageForPtt = (IQWalletConfigService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IQWalletConfigService.class, "");
      if (paramMessageForPtt != null) {
        paramMessageForPtt = paramMessageForPtt.getString("voice_pwd", HardCodeUtil.a(2131708710), new String[] { "lowTipStr" });
      } else {
        paramMessageForPtt = HardCodeUtil.a(2131708710);
      }
      paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setTailMessage(true, paramMessageForPtt, null);
    }
    if (AppSetting.d)
    {
      paramMessageForPtt = HardCodeUtil.a(2131708701);
      StringBuilder localStringBuilder;
      if (bool2)
      {
        localObject2 = paramHolder.jdField_a_of_type_AndroidWidgetRelativeLayout;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramMessageForPtt);
        localStringBuilder.append(str);
        localStringBuilder.append(HardCodeUtil.a(2131708706));
        localStringBuilder.append(HardCodeUtil.a(2131708702));
        ((RelativeLayout)localObject2).setContentDescription(localStringBuilder.toString());
      }
      else
      {
        localObject2 = paramHolder.jdField_a_of_type_AndroidWidgetRelativeLayout;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramMessageForPtt);
        localStringBuilder.append(str);
        localStringBuilder.append(HardCodeUtil.a(2131708715));
        ((RelativeLayout)localObject2).setContentDescription(localStringBuilder.toString());
      }
      if (paramHolder.jdField_a_of_type_JavaLangStringBuilder != null)
      {
        paramMessageForPtt = paramHolder.jdField_a_of_type_JavaLangStringBuilder;
        paramMessageForPtt.append("发送了语音.");
        paramMessageForPtt.append(str);
        if (localObject1 != null)
        {
          paramHolder = paramHolder.jdField_a_of_type_JavaLangStringBuilder;
          paramHolder.append(" ");
          paramHolder.append((String)localObject1);
        }
      }
    }
  }
  
  protected void a(PttItemBuilder.Holder paramHolder, MessageForPtt paramMessageForPtt, boolean paramBoolean1, boolean paramBoolean2)
  {
    int i;
    int j;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie != null)
    {
      if (paramBoolean1) {
        i = 2;
      } else {
        i = 1;
      }
      j = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.b().a().a().a();
    }
    else
    {
      i = 5;
      j = 0;
    }
    ChatActivityFacade.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, paramMessageForPtt, false, i, j, paramBoolean2);
  }
  
  protected void a(PttItemBuilder.Holder paramHolder, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if ((paramBoolean1) && (paramBoolean2))
    {
      Object localObject = this.jdField_a_of_type_AndroidContentContext.getResources();
      paramHolder.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(AIOUtils.b(6.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
      if (paramBoolean3)
      {
        localObject = ((Resources)localObject).getDrawable(2130847290);
        if (localObject != null)
        {
          ((Drawable)localObject).setBounds(0, 0, ((Drawable)localObject).getMinimumWidth(), ((Drawable)localObject).getMinimumHeight());
          paramHolder.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawables((Drawable)localObject, null, null, null);
        }
      }
      else
      {
        localObject = ((Resources)localObject).getDrawable(2130847288);
        if (localObject != null)
        {
          ((Drawable)localObject).setBounds(0, 0, ((Drawable)localObject).getMinimumWidth(), ((Drawable)localObject).getMinimumHeight());
          paramHolder.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawables(null, null, (Drawable)localObject, null);
        }
      }
    }
    else
    {
      paramHolder.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(0);
      paramHolder.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawables(null, null, null, null);
    }
  }
  
  public void a(MessageForPtt paramMessageForPtt)
  {
    this.jdField_a_of_type_JavaUtilMap.remove(Long.valueOf(paramMessageForPtt.uniseq));
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramMessageForPtt.getSttResult().b());
    ((StringBuilder)localObject).append("");
    localObject = ((StringBuilder)localObject).toString();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramMessageForPtt.getSttResult().c());
    localStringBuilder.append("");
    ThreadManager.excute(new PttItemBuilder.4(this, (String)localObject, localStringBuilder.toString()), 16, null, false);
    localObject = a();
    if (localObject != null) {
      ((PttSttHelper)localObject).b(paramMessageForPtt);
    }
    this.jdField_a_of_type_AndroidWidgetBaseAdapter.notifyDataSetChanged();
  }
  
  public void a(MessageForPtt paramMessageForPtt, boolean paramBoolean)
  {
    this.jdField_a_of_type_JavaUtilMap.remove(Long.valueOf(paramMessageForPtt.uniseq));
    if (paramMessageForPtt.getSttResult().a())
    {
      if (paramBoolean) {
        this.jdField_a_of_type_AndroidWidgetBaseAdapter.notifyDataSetChanged();
      }
      PttSttHelper localPttSttHelper = a();
      if (localPttSttHelper != null) {
        localPttSttHelper.a(paramMessageForPtt);
      }
    }
    else
    {
      this.jdField_a_of_type_AndroidWidgetBaseAdapter.notifyDataSetChanged();
    }
  }
  
  protected void a(MessageForPtt paramMessageForPtt, boolean paramBoolean, PttItemBuilder.Holder paramHolder)
  {
    this.jdField_a_of_type_AndroidContentContext.getResources();
    int i;
    if (paramMessageForPtt.isSend())
    {
      if (d(paramMessageForPtt))
      {
        paramMessageForPtt = paramHolder.jdField_a_of_type_AndroidWidgetImageView;
        if (paramBoolean) {
          i = 2130847286;
        } else {
          i = 2130847289;
        }
        paramMessageForPtt.setImageResource(i);
        return;
      }
      paramMessageForPtt = paramHolder.jdField_a_of_type_AndroidWidgetImageView;
      if (paramBoolean) {
        i = 2130850316;
      } else {
        i = 2130850317;
      }
      paramMessageForPtt.setImageResource(i);
      return;
    }
    if (d(paramMessageForPtt))
    {
      paramMessageForPtt = paramHolder.jdField_a_of_type_AndroidWidgetImageView;
      if (paramBoolean) {
        i = 2130847280;
      } else {
        i = 2130847287;
      }
      paramMessageForPtt.setImageResource(i);
      return;
    }
    paramMessageForPtt = paramHolder.jdField_a_of_type_AndroidWidgetImageView;
    if (paramBoolean) {
      i = 2130850310;
    } else {
      i = 2130850309;
    }
    paramMessageForPtt.setImageResource(i);
  }
  
  protected void a(MessageForPtt paramMessageForPtt, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, PttItemBuilder.Holder paramHolder)
  {
    for (;;)
    {
      try
      {
        Resources localResources = this.jdField_a_of_type_AndroidContentContext.getResources();
        if ((paramBoolean1) && (!paramBoolean2))
        {
          if (paramMessageForPtt.isSend())
          {
            if (!d(paramMessageForPtt)) {
              break label153;
            }
            if (!paramBoolean3) {
              break label145;
            }
            i = 2130772304;
          }
          else
          {
            if (!d(paramMessageForPtt)) {
              break label182;
            }
            if (!paramBoolean3) {
              break label174;
            }
            i = 2130772302;
          }
          paramMessageForPtt = (AnimationDrawable)localResources.getDrawable(i);
          paramHolder.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramMessageForPtt);
          paramMessageForPtt.start();
        }
        else
        {
          a(paramMessageForPtt, paramBoolean3, paramHolder);
          return;
        }
      }
      catch (Throwable paramMessageForPtt)
      {
        if (QLog.isColorLevel())
        {
          paramHolder = new StringBuilder();
          paramHolder.append("when handlePttFlagOnAnim throw a exception ");
          paramHolder.append(paramMessageForPtt);
          QLog.e("PttItemBuilder", 2, paramHolder.toString());
        }
        return;
      }
      label145:
      int i = 2130772303;
      continue;
      label153:
      if (paramBoolean3)
      {
        i = 2130772144;
      }
      else
      {
        i = 2130772143;
        continue;
        label174:
        i = 2130772301;
        continue;
        label182:
        if (paramBoolean3) {
          i = 2130772398;
        } else {
          i = 2130772397;
        }
      }
    }
  }
  
  public void a(MessageRecord paramMessageRecord)
  {
    if ((paramMessageRecord != null) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null))
    {
      MqqHandler localMqqHandler = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHandler(ChatActivity.class);
      if (localMqqHandler != null)
      {
        Message localMessage = new Message();
        localMessage.what = 78;
        localMessage.arg1 = 889;
        Bundle localBundle = new Bundle();
        localBundle.putLong("messageUniseq", paramMessageRecord.uniseq);
        localMessage.setData(localBundle);
        localMqqHandler.sendMessage(localMessage);
      }
    }
  }
  
  public void a(XListView paramXListView, int paramInt, View paramView, ChatMessage paramChatMessage, long paramLong, float paramFloat)
  {
    if ((paramView != null) && (paramFloat > 0.0F))
    {
      paramXListView = AIOUtils.a(paramView);
      if ((paramXListView instanceof PttItemBuilder.Holder))
      {
        paramXListView = (PttItemBuilder.Holder)paramXListView;
        if (paramXListView.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView != null)
        {
          paramXListView.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.setProgress(paramFloat);
          if ((paramChatMessage instanceof MessageForPtt)) {
            ((MessageForPtt)paramChatMessage).playProgress = paramFloat;
          }
        }
      }
    }
  }
  
  public void a(XListView paramXListView, int paramInt, View paramView, ChatMessage paramChatMessage, boolean paramBoolean)
  {
    if (paramView != null)
    {
      paramXListView = AIOUtils.a(paramView);
      if ((paramXListView instanceof PttItemBuilder.Holder))
      {
        paramXListView = (PttItemBuilder.Holder)paramXListView;
        paramView = (MessageForPtt)paramChatMessage;
        a(paramXListView, paramView, a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramView), false);
        if (paramXListView.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView != null)
        {
          if (paramBoolean)
          {
            paramXListView.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.setProgress(0.0F);
            paramView.playProgress = 0.0F;
            paramXListView.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.setCanSupportSlide(false);
            paramXListView.a(false);
          }
          if ((!paramXListView.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.d) && (paramXListView.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView != null)) {
            paramXListView.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView.setPlayState(false);
          }
        }
      }
    }
    c();
    if ((paramBoolean) && ((paramChatMessage instanceof MessageForPtt))) {
      ((MessageForPtt)paramChatMessage).playSpeedPos = SonicHelper.a;
    }
  }
  
  public boolean a(BaseBubbleBuilder.ViewHolder paramViewHolder)
  {
    return paramViewHolder instanceof PttItemBuilder.Holder;
  }
  
  protected boolean a(QQAppInterface paramQQAppInterface, Context paramContext, BaseAdapter paramBaseAdapter, BaseBubbleBuilder.ViewHolder paramViewHolder, MessageForPtt paramMessageForPtt)
  {
    return VoicePrintUtils.a(paramQQAppInterface, this.jdField_a_of_type_AndroidContentContext, paramViewHolder, paramMessageForPtt);
  }
  
  protected boolean a(MessageForPtt paramMessageForPtt, PttItemBuilder.Holder paramHolder)
  {
    boolean bool1 = ((IVoiceRedPacketHelper)QRoute.api(IVoiceRedPacketHelper.class)).isRedPackPTT(paramMessageForPtt);
    int j = 8;
    boolean bool2;
    int k;
    Object localObject;
    if (bool1)
    {
      bool1 = ((IQWalletHbApi)QRoute.api(IQWalletHbApi.class)).getCustomizeStrategyFactory().a();
      bool2 = true;
      k = 1;
      if (bool1)
      {
        localObject = (IQWalletConfigService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IQWalletConfigService.class, "");
        if (localObject != null) {
          i = ((IQWalletConfigService)localObject).getInt("voice_pwd", 1, new String[] { "scoreSwitch" });
        } else {
          i = 1;
        }
        if (i != 1) {
          break label446;
        }
        String str = paramMessageForPtt.getExtInfoFromExtStr("voice_score_id");
        if (!TextUtils.isEmpty(str))
        {
          localObject = new RedPacketInfo();
          ((RedPacketInfo)localObject).a = paramMessageForPtt;
          ((RedPacketInfo)localObject).type = 6;
          ((RedPacketInfo)localObject).templateId = str;
          paramMessageForPtt = ((IQWalletHbApi)QRoute.api(IQWalletHbApi.class)).getCustomizeStrategyFactory().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (RedPacketInfo)localObject, this);
          if (QLog.isColorLevel())
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("redPacketInfo.icon = ");
            ((StringBuilder)localObject).append(paramMessageForPtt.icon);
            QLog.d("PttItemBuilder", 2, ((StringBuilder)localObject).toString());
          }
          if (paramMessageForPtt.icon != null)
          {
            paramHolder.jdField_b_of_type_AndroidWidgetImageView.setImageBitmap(paramMessageForPtt.icon);
            i = k;
          }
          else
          {
            i = 0;
          }
          break label448;
        }
      }
    }
    try
    {
      i = Integer.parseInt(paramMessageForPtt.getExtInfoFromExtStr("voice_low_tips_tag"));
    }
    catch (NumberFormatException localNumberFormatException)
    {
      label274:
      break label274;
    }
    int i = 0;
    if (i == 1) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    if (!bool1)
    {
      i = 5;
      if (localObject != null) {
        i = ((IQWalletConfigService)localObject).getInt("voice_pwd", 5, new String[] { "lowTipsLimit" });
      }
      k = ((IQWalletPreferenceApi)QRoute.api(IQWalletPreferenceApi.class)).getInt(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), "voice_low_tips_count", 0);
      if (k < i)
      {
        paramMessageForPtt.saveExtInfoToExtStr("voice_low_tips_tag", "1");
        ThreadManager.post(new PttItemBuilder.2(this, paramMessageForPtt), 10, null, false);
        ((IQWalletPreferenceApi)QRoute.api(IQWalletPreferenceApi.class)).putInt(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), "voice_low_tips_count", k + 1);
        bool1 = bool2;
      }
    }
    i = 0;
    break label451;
    ((IQWalletHbApi)QRoute.api(IQWalletHbApi.class)).getCustomizeStrategyFactory().b(true);
    label446:
    i = 0;
    label448:
    bool1 = false;
    label451:
    paramMessageForPtt = paramHolder.jdField_b_of_type_AndroidWidgetImageView;
    if (i != 0) {
      j = 0;
    }
    paramMessageForPtt.setVisibility(j);
    return bool1;
    if (paramHolder.jdField_b_of_type_AndroidWidgetImageView != null) {
      paramHolder.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
    }
    return false;
  }
  
  public boolean a(XListView paramXListView, int paramInt, View paramView, ChatMessage paramChatMessage)
  {
    paramXListView = (MessageForPtt)paramChatMessage;
    return (!paramXListView.isSend()) && (!paramXListView.isReadPtt) && (paramXListView.isReady());
  }
  
  public boolean a(XListView paramXListView, int paramInt1, View paramView, ChatMessage paramChatMessage, AudioPlayerBase paramAudioPlayerBase, int paramInt2)
  {
    paramXListView = (MessageForPtt)paramChatMessage;
    ((IPTTPreDownloader)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IPTTPreDownloader.class)).onPlayPTT(paramXListView);
    boolean bool2 = paramXListView.isReady();
    boolean bool1 = false;
    paramInt1 = 2;
    if (bool2)
    {
      paramView = AIOUtils.a(paramView);
      if ((paramView != null) && (!(paramView instanceof PttItemBuilder.Holder)))
      {
        if (QLog.isColorLevel())
        {
          paramView = new StringBuilder();
          paramView.append("play failed not Holder ");
          paramView.append(paramXListView.getLocalFilePath());
          QLog.d("PttItemBuilder", 2, paramView.toString());
        }
        return false;
      }
      paramView = (PttItemBuilder.Holder)paramView;
      if (paramAudioPlayerBase != null)
      {
        paramAudioPlayerBase.a(paramXListView.playSpeedPos);
        paramAudioPlayerBase.a(paramXListView.time);
        paramAudioPlayerBase.a(this.d);
        paramAudioPlayerBase.c(paramXListView.isSendFromLocal());
        if (paramAudioPlayerBase.b(paramXListView.getLocalFilePath(), paramInt2))
        {
          c(paramXListView);
          if (paramView != null)
          {
            paramAudioPlayerBase = a();
            if (paramAudioPlayerBase != null) {
              paramAudioPlayerBase.e(paramXListView);
            }
            a(paramView, paramXListView, a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramXListView), true);
            if (paramView.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView != null) {
              paramView.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView.setPlayState(true);
            }
            if (paramView.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView != null) {
              paramView.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.setCanSupportSlide(true);
            }
            paramView.a(true);
            a(paramXListView, paramView.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInfo);
          }
          PttInfoCollector.reportPttPlay(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramXListView.istroop, paramXListView.issend);
          if (!paramXListView.isSendFromLocal())
          {
            if (paramXListView.istroop == 0) {
              paramInt1 = 1;
            } else if (paramXListView.istroop == 1) {
              paramInt1 = 3;
            } else if (paramXListView.istroop != 3000) {
              paramInt1 = 4;
            }
            paramXListView = (IPttInfoCollector)QRoute.api(IPttInfoCollector.class);
            paramView = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
            if (paramChatMessage.getPttStreamFlag() == 10001) {
              bool1 = true;
            }
            paramXListView.reportPTTPV(paramView, paramInt1, bool1, 1);
          }
          return true;
        }
        if (QLog.isColorLevel())
        {
          paramView = new StringBuilder();
          paramView.append("play failed player return false ");
          paramView.append(paramXListView.getLocalFilePath());
          QLog.d("PttItemBuilder", 2, paramView.toString());
          return false;
        }
      }
    }
    else if (QLog.isColorLevel())
    {
      paramView = new StringBuilder();
      paramView.append("play failed not ready ");
      paramView.append(paramXListView.getLocalFilePath());
      QLog.d("PttItemBuilder", 2, paramView.toString());
    }
    return false;
  }
  
  public QQCustomMenuItem[] a(View paramView)
  {
    return a(new QQCustomMenu(), (MessageForPtt)AIOUtils.a(paramView), paramView instanceof SelectableComponent);
  }
  
  protected QQCustomMenuItem[] a(QQCustomMenu paramQQCustomMenu, MessageForPtt paramMessageForPtt, boolean paramBoolean)
  {
    if ((paramBoolean) && (paramMessageForPtt.sttAbility == 2) && (paramMessageForPtt.expandStt))
    {
      a(paramQQCustomMenu);
      return paramQQCustomMenu.a();
    }
    if (a(paramQQCustomMenu, paramMessageForPtt)) {
      return paramQQCustomMenu.a();
    }
    if (c(paramMessageForPtt)) {
      MediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(false);
    }
    if (!DeviceInfoUtil.j())
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
      int i;
      if ((localObject != null) && (((AudioPanelAioHelper)((BaseChatPie)localObject).a(128)).jdField_b_of_type_Boolean)) {
        i = 1;
      } else {
        i = 0;
      }
      int j;
      if (i != 0)
      {
        localObject = this.jdField_a_of_type_AndroidContentContext;
        j = 2131694921;
      }
      else
      {
        localObject = this.jdField_a_of_type_AndroidContentContext;
        j = 2131694923;
      }
      localObject = ((Context)localObject).getString(j);
      if (i != 0) {
        i = 2130838909;
      } else {
        i = 2130838913;
      }
      paramQQCustomMenu.a(2131372837, (String)localObject, i);
    }
    if (((paramMessageForPtt.extraflag != 32768) && (a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForPtt) == 1003) && (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgCache().b(paramMessageForPtt))) || (TroopUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForPtt, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()))) {
      a(paramQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, 2131371562, paramMessageForPtt, new Bundle());
    }
    a(paramQQCustomMenu, paramMessageForPtt);
    if (paramMessageForPtt.voiceChangeFlag != 1) {
      if ((paramMessageForPtt.sttAbility != 1) && (paramMessageForPtt.sttAbility != 3))
      {
        if ((paramMessageForPtt.sttAbility == 2) && (!paramMessageForPtt.expandStt) && (!((IVoiceRedPacketHelper)QRoute.api(IVoiceRedPacketHelper.class)).isRedPackPTT(paramMessageForPtt))) {
          paramQQCustomMenu.a(2131377991, this.jdField_a_of_type_AndroidContentContext.getString(2131719267), 2130838902);
        }
      }
      else if ((!((ISttManagerService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(ISttManagerService.class)).isTranslating(paramMessageForPtt)) && ((!paramMessageForPtt.isSend()) || (paramMessageForPtt.fileSize > 0L)) && (!((IVoiceRedPacketHelper)QRoute.api(IVoiceRedPacketHelper.class)).isRedPackPTT(paramMessageForPtt))) {
        paramQQCustomMenu.a(2131377991, this.jdField_a_of_type_AndroidContentContext.getString(2131719267), 2130838902);
      }
    }
    a(paramQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, 2131376417, paramMessageForPtt, null);
    paramQQCustomMenu.a(this.jdField_a_of_type_AndroidContentContext.getString(2131691247));
    a(paramQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, 2131365480, paramMessageForPtt, new Bundle());
    paramQQCustomMenu.a(2131366494, this.jdField_a_of_type_AndroidContentContext.getString(2131692184), 2130838911);
    Object localObject = new Bundle();
    ((Bundle)localObject).putBoolean("isSearch", false);
    a(paramQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, 2131380215, paramMessageForPtt, (Bundle)localObject);
    a(paramQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, 2131376430, paramMessageForPtt, null);
    a(paramQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, 2131371603, null, null);
    a(paramQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, 2131362480, null, null);
    return paramQQCustomMenu.a();
  }
  
  public void a_(ChatMessage paramChatMessage)
  {
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A5A7", "0X800A5A7", 0, 0, "1", "", "", "");
  }
  
  protected int b(MessageForPtt paramMessageForPtt)
  {
    return ((IQQRecorderTempApi)QRoute.api(IQQRecorderTempApi.class)).getFilePlayTime(paramMessageForPtt);
  }
  
  protected View b(ChatMessage paramChatMessage, BaseBubbleBuilder.ViewHolder paramViewHolder, View paramView, BaseChatItemLayout paramBaseChatItemLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    paramBaseChatItemLayout = (PttItemBuilder.Holder)paramViewHolder;
    this.jdField_a_of_type_JavaUtilSet.add(paramBaseChatItemLayout);
    MessageForPtt localMessageForPtt = (MessageForPtt)paramChatMessage;
    paramViewHolder = a();
    if (paramViewHolder != null) {
      paramViewHolder.a(paramBaseChatItemLayout, localMessageForPtt, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_Int);
    }
    if (paramView == null)
    {
      paramViewHolder = new BreathAnimationLayout(this.jdField_a_of_type_AndroidContentContext);
      paramViewHolder.setId(2131374095);
      paramView = new PttAudioPlayView(this.jdField_a_of_type_AndroidContentContext, 12);
      paramView.setThemeColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColorStateList(2131167075).getDefaultColor());
      paramView.setId(2131374100);
      Object localObject1 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject1).addRule(15, -1);
      ((RelativeLayout.LayoutParams)localObject1).width = AIOUtils.b(44.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      ((RelativeLayout.LayoutParams)localObject1).height = AIOUtils.b(44.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      paramView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      localObject1 = new PttAudioChangeView(this.jdField_a_of_type_AndroidContentContext, 2130838161, 8);
      ((PttAudioChangeView)localObject1).setThemeColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColorStateList(2131167075).getDefaultColor());
      ((PttAudioChangeView)localObject1).setId(2131374106);
      Object localObject2 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject2).addRule(15, -1);
      ((RelativeLayout.LayoutParams)localObject2).width = AIOUtils.b(16.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      ((RelativeLayout.LayoutParams)localObject2).height = AIOUtils.b(19.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      ((PttAudioChangeView)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
      localObject2 = new PttAudioWaveView(this.jdField_a_of_type_AndroidContentContext);
      ((PttAudioWaveView)localObject2).setProgressColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColorStateList(2131167075).getDefaultColor());
      ((PttAudioWaveView)localObject2).setId(2131374101);
      Object localObject3 = new RelativeLayout.LayoutParams(-1, -1);
      ((RelativeLayout.LayoutParams)localObject3).addRule(15, -1);
      ((RelativeLayout.LayoutParams)localObject3).width = AIOUtils.b(10.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      ((RelativeLayout.LayoutParams)localObject3).height = AIOUtils.b(52.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      ((PttAudioWaveView)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject3);
      localObject3 = new TextView(this.jdField_a_of_type_AndroidContentContext);
      ((TextView)localObject3).setId(2131374102);
      ((TextView)localObject3).setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColorStateList(2131167075));
      VoicePrintUtils.VoicePrintView localVoicePrintView = new VoicePrintUtils.VoicePrintView(this.jdField_a_of_type_AndroidContentContext);
      localVoicePrintView.setId(2131374103);
      ImageView localImageView = new ImageView(this.jdField_a_of_type_AndroidContentContext);
      localImageView.setId(2131374105);
      Object localObject4 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject4).addRule(15, -1);
      ((TextView)localObject3).setLayoutParams((ViewGroup.LayoutParams)localObject4);
      localObject4 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject4).addRule(15, -1);
      localVoicePrintView.setLayoutParams((ViewGroup.LayoutParams)localObject4);
      localObject4 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject4).addRule(15, -1);
      ((RelativeLayout.LayoutParams)localObject4).width = AIOUtils.b(47.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      ((RelativeLayout.LayoutParams)localObject4).height = AIOUtils.b(41.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      localImageView.setLayoutParams((ViewGroup.LayoutParams)localObject4);
      localObject4 = new SyncParentPressedRelativeLayout(this.jdField_a_of_type_AndroidContentContext);
      ((RelativeLayout)localObject4).setId(2131374098);
      ((RelativeLayout)localObject4).addView((View)localObject2);
      ((RelativeLayout)localObject4).addView(paramView);
      ((RelativeLayout)localObject4).addView((View)localObject1);
      ((RelativeLayout)localObject4).addView((View)localObject3);
      ((RelativeLayout)localObject4).addView(localVoicePrintView);
      ((RelativeLayout)localObject4).addView(localImageView);
      paramViewHolder.addView((View)localObject4);
      paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqActivityAioItemBreathAnimationLayout = paramViewHolder;
      paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView = paramView;
      paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioChangeView = ((PttAudioChangeView)localObject1);
      paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView = ((PttAudioWaveView)localObject2);
      paramBaseChatItemLayout.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localObject3);
      paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVoicePrintUtils$VoicePrintView = localVoicePrintView;
      paramBaseChatItemLayout.jdField_b_of_type_AndroidWidgetImageView = localImageView;
      paramBaseChatItemLayout.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localObject4);
    }
    else
    {
      paramViewHolder = paramView;
    }
    if (paramOnLongClickAndTouchListener != null) {
      paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqActivityAioOnLongClickAndTouchListener = paramOnLongClickAndTouchListener;
    }
    if (localMessageForPtt.voiceChangeFlag != 0) {
      i = 1;
    } else {
      i = 0;
    }
    boolean bool = a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidWidgetBaseAdapter, paramBaseChatItemLayout, localMessageForPtt);
    if (bool)
    {
      paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVoicePrintUtils$VoicePrintView.setVisibility(0);
      paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.setVisibility(8);
      paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView.setVisibility(8);
      paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioChangeView.setVisibility(8);
    }
    else
    {
      paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVoicePrintUtils$VoicePrintView.setVisibility(8);
      paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView.setVisibility(0);
      paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.setVisibility(0);
      paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.setOnClickListener(this);
      if (i != 0) {
        paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioChangeView.setVisibility(0);
      } else {
        paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioChangeView.setVisibility(8);
      }
      paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.setOnTouchListener(paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqActivityAioOnLongClickAndTouchListener);
      paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.setOnLongClickListener(paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqActivityAioOnLongClickAndTouchListener);
      paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.setOnPressListener(paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView$OnPressListener);
      if ((!c(paramChatMessage)) && (!paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.d))
      {
        if (localMessageForPtt.playProgress > 0.0F)
        {
          paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.setCanSupportSlide(true);
          paramBaseChatItemLayout.a(true);
        }
        else
        {
          paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.setCanSupportSlide(false);
          paramBaseChatItemLayout.a(false);
        }
        paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.setProgress(localMessageForPtt.playProgress);
        paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView.setPlayState(false);
      }
      else
      {
        paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.setCanSupportSlide(true);
        paramBaseChatItemLayout.a(true);
        paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView.setPlayState(true);
      }
    }
    if (paramChatMessage.isSend())
    {
      paramView = (RelativeLayout.LayoutParams)paramBaseChatItemLayout.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams();
      if (bool)
      {
        paramView.addRule(1, 2131374103);
        ((RelativeLayout.LayoutParams)paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVoicePrintUtils$VoicePrintView.getLayoutParams()).addRule(1, 2131374105);
        ((RelativeLayout.LayoutParams)paramBaseChatItemLayout.jdField_b_of_type_AndroidWidgetImageView.getLayoutParams()).addRule(1, -1);
      }
      else
      {
        paramView.addRule(1, 2131374101);
        ((RelativeLayout.LayoutParams)paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.getLayoutParams()).addRule(1, 2131374106);
        ((RelativeLayout.LayoutParams)paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioChangeView.getLayoutParams()).addRule(1, 2131374105);
        ((RelativeLayout.LayoutParams)paramBaseChatItemLayout.jdField_b_of_type_AndroidWidgetImageView.getLayoutParams()).addRule(1, 2131374100);
        ((RelativeLayout.LayoutParams)paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView.getLayoutParams()).addRule(1, -1);
      }
    }
    else if (bool)
    {
      ((RelativeLayout.LayoutParams)paramBaseChatItemLayout.jdField_b_of_type_AndroidWidgetImageView.getLayoutParams()).addRule(1, 2131374102);
      ((RelativeLayout.LayoutParams)paramBaseChatItemLayout.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams()).addRule(1, 2131374103);
      ((RelativeLayout.LayoutParams)paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVoicePrintUtils$VoicePrintView.getLayoutParams()).addRule(1, -1);
    }
    else
    {
      ((RelativeLayout.LayoutParams)paramBaseChatItemLayout.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams()).addRule(1, 2131374101);
      ((RelativeLayout.LayoutParams)paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.getLayoutParams()).addRule(1, 2131374106);
      ((RelativeLayout.LayoutParams)paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioChangeView.getLayoutParams()).addRule(1, 2131374105);
      ((RelativeLayout.LayoutParams)paramBaseChatItemLayout.jdField_b_of_type_AndroidWidgetImageView.getLayoutParams()).addRule(1, 2131374100);
      ((RelativeLayout.LayoutParams)paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView.getLayoutParams()).addRule(1, -1);
    }
    int j = a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localMessageForPtt);
    int i = j;
    if (j == -1)
    {
      a(paramBaseChatItemLayout, localMessageForPtt, false, true);
      i = 2001;
    }
    if (QLog.isColorLevel())
    {
      paramView = new StringBuilder();
      paramView.append("fileStatus = ");
      paramView.append(i);
      paramView.append(" url ");
      paramView.append(localMessageForPtt.url);
      paramView.append(" uniseq ");
      paramView.append(localMessageForPtt.uniseq);
      QLog.d("PTTItem->getBubbleView", 2, paramView.toString());
    }
    if (((localMessageForPtt.istroop == 1) || (localMessageForPtt.istroop == 3000)) && (i == 2003) && (((ISttManagerService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(ISttManagerService.class)).needAuotoChange(localMessageForPtt)))
    {
      b(localMessageForPtt, 1);
      ReportController.b(null, "dc00898", "", "", "0X8009DF6", "0X8009DF6", 0, 0, "", "", "", "");
    }
    a(paramBaseChatItemLayout, localMessageForPtt, i, c(localMessageForPtt));
    ((IPTTPreDownloader)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IPTTPreDownloader.class)).onViewPTT(localMessageForPtt);
    PttInfoCollector.reportPttItemBuilderType(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, i, paramChatMessage);
    return paramViewHolder;
  }
  
  public void b(MessageForPtt paramMessageForPtt)
  {
    PttSttHelper localPttSttHelper = a();
    if (localPttSttHelper != null) {
      localPttSttHelper.c(paramMessageForPtt);
    }
  }
  
  protected boolean b()
  {
    return SonicHelper.a();
  }
  
  public boolean b(ChatMessage paramChatMessage)
  {
    return true;
  }
  
  protected boolean c(ChatMessage paramChatMessage)
  {
    return a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
  }
  
  public void d()
  {
    PttInfoCollector.reportLongPressPtt(7);
    super.d();
  }
  
  public void handleMessage(View paramView, FileMsg paramFileMsg, int paramInt1, int paramInt2)
  {
    if ((paramFileMsg.fileType == 2) && (paramInt1 != 2002) && (paramInt1 != 1002))
    {
      if (paramInt1 == 2001) {
        return;
      }
      if (!(AIOUtils.a(paramView) instanceof MessageForPtt)) {
        return;
      }
      MessageForPtt localMessageForPtt = (MessageForPtt)AIOUtils.a(paramView);
      if (localMessageForPtt != null)
      {
        if (localMessageForPtt.uniseq != paramFileMsg.uniseq) {
          return;
        }
        paramView = (PttItemBuilder.Holder)AIOUtils.a(paramView);
        int i;
        if ((paramInt1 != 1003) && (paramInt1 != 2003))
        {
          if ((paramFileMsg.status != 1005) && (paramFileMsg.status != 1004))
          {
            if (localMessageForPtt.fileSize == -2L)
            {
              i = 999;
            }
            else if (localMessageForPtt.fileSize == -3L)
            {
              i = 1001;
            }
            else if (localMessageForPtt.fileSize == -1L)
            {
              i = 1005;
            }
            else
            {
              i = paramInt1;
              if (paramInt1 == 2005)
              {
                localMessageForPtt.fileSize = -4L;
                a(paramInt2, localMessageForPtt);
                i = paramInt1;
              }
            }
          }
          else
          {
            this.jdField_a_of_type_AndroidWidgetBaseAdapter.notifyDataSetChanged();
            i = paramInt1;
          }
        }
        else
        {
          i = paramInt1;
          if (!paramFileMsg.isStreamMode)
          {
            i = paramInt1;
            if (paramInt1 == 2003)
            {
              b();
              i = paramInt1;
            }
          }
        }
        if (QLog.isColorLevel())
        {
          paramFileMsg = new StringBuilder();
          paramFileMsg.append("fileStatus:");
          paramFileMsg.append(i);
          paramFileMsg.append("|url ");
          paramFileMsg.append(localMessageForPtt.url);
          paramFileMsg.append("|uniseq ");
          paramFileMsg.append(localMessageForPtt.uniseq);
          QLog.d("PTTItem->handleMessage", 2, paramFileMsg.toString());
        }
        a(paramView, localMessageForPtt, i, c(localMessageForPtt));
      }
    }
  }
  
  public void onClick(View paramView)
  {
    AIOUtils.o = true;
    int i = paramView.getId();
    if ((AppSetting.d) && (i == 2131363435))
    {
      paramView.findViewById(2131374098).performClick();
    }
    else
    {
      Object localObject2 = (PttItemBuilder.Holder)AIOUtils.a(paramView);
      Object localObject1 = (MessageForPtt)((PttItemBuilder.Holder)localObject2).jdField_a_of_type_ComTencentMobileqqDataChatMessage;
      Object localObject3;
      if ((i != 2131374098) && (i != 2131374101))
      {
        if ((i != 2131374117) && (i != 2131374111))
        {
          if (i == 2131364550)
          {
            if (this.jdField_a_of_type_AndroidContentContext != null)
            {
              localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
              localObject3 = HttpUtil.getNetWorkTypeByStr();
              if (VasUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).getVipStatus().isSVip()) {
                localObject1 = "svip";
              } else {
                localObject1 = "vip";
              }
              VasWebviewUtil.a((String)localObject2, "LongVoice", "TailClick", "0", 1, 0, 0, (String)localObject3, "", (String)localObject1);
              localObject1 = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
              ((Intent)localObject1).putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
              ((Intent)localObject1).putExtra("url", "https://m.vip.qq.com/freedom/xhycyy.html?_nav_alpha=0");
              this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject1);
            }
            else if (QLog.isColorLevel())
            {
              QLog.d("PttItemBuilder", 2, "chat_item_tail_message onclick nullpoint");
            }
          }
          else {
            super.onClick(paramView);
          }
        }
        else if ((localObject1 != null) && (((MessageForPtt)localObject1).expandStt))
        {
          ((MessageForPtt)localObject1).expandStt = false;
          ((MessageForPtt)localObject1).serial();
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, ((MessageForPtt)localObject1).uniseq, ((MessageForPtt)localObject1).msgData);
          a((PttItemBuilder.Holder)localObject2, (MessageForPtt)localObject1, a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (MessageForPtt)localObject1), c((ChatMessage)localObject1));
          ReportController.b(null, "dc00898", "", "", "0X8009DF8", "0X8009DF8", 0, 0, "", "", "", "");
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8003F37", "0X8003F37", 0, 0, "", "", "", "");
        }
      }
      else if (localObject1 != null)
      {
        if (c((ChatMessage)localObject1))
        {
          MediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(false);
          ReportController.b(null, "dc00898", "", "", "0X8009D00", "0X8009D00", 2, 0, "", "", "", "");
        }
        else if ((localObject1 != MediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a()) && (((MessageForPtt)localObject1).isReady()))
        {
          a((PttItemBuilder.Holder)localObject2, (MessageForPtt)localObject1, paramView);
        }
        if (((MessageForPtt)localObject1).istroop == 1008) {
          ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", "", "0X8005857", "0X8005857", 0, 0, "", "", ((MessageForPtt)localObject1).timeStr, "", false);
        }
        if (((MessageForPtt)localObject1).voiceChangeFlag == 1)
        {
          localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("");
          ((StringBuilder)localObject3).append(((MessageForPtt)localObject1).istroop);
          ReportController.b((AppRuntime)localObject2, "CliOper", "", "", "changevoice", "0X8006F7E", 0, 0, ((StringBuilder)localObject3).toString(), "", "", "");
        }
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.PttItemBuilder
 * JD-Core Version:    0.7.0.1
 */