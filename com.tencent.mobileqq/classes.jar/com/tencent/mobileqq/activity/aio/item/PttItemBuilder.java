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
  Set<PttItemBuilder.Holder> A = new HashSet();
  protected Map<Long, String> B = new HashMap();
  protected int C = 14;
  protected SpannableString w;
  protected SpannableString x;
  protected TextView y;
  protected BaseChatPie z;
  
  public PttItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner, BaseChatPie paramBaseChatPie)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    ((ISttManagerService)paramQQAppInterface.getRuntimeService(ISttManagerService.class)).setListener(this);
    this.z = paramBaseChatPie;
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
      i = BaseChatItemLayout.f - BaseChatItemLayout.getBubblePaddingAlignHead() - BaseChatItemLayout.getBubblePaddingAlignError() - 32;
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
      i = BaseChatItemLayout.f - BaseChatItemLayout.getBubblePaddingAlignHead() - BaseChatItemLayout.getBubblePaddingAlignError() - 32;
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
    boolean bool2 = a(this.d, this.e, this.c, paramHolder, paramMessageForPtt);
    Resources localResources = this.e.getResources();
    int i = AIOUtils.b(15.0F, this.e.getResources());
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
          paramHolder.d.setText(paramString);
          paramHolder.d.setPadding(AIOUtils.b(10.0F, localResources), BaseChatItemLayout.n, AIOUtils.b(10.0F, localResources), BaseChatItemLayout.o);
          if (paramHolder.c != null) {
            paramHolder.c.setVisibility(8);
          }
          a(paramHolder, bool2, bool1, paramMessageForPtt.isSend());
          paramHolder.v.setAnimating(false);
          ((RelativeLayout.LayoutParams)paramHolder.u.getLayoutParams()).width = i;
          paramHolder.u.setVisibility(4);
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
      ((RelativeLayout.LayoutParams)paramHolder.u.getLayoutParams()).width = i;
      paramHolder.u.setVisibility(4);
      paramHolder.d.setText(paramString);
      paramHolder.d.setPadding(AIOUtils.b(40.0F, localResources), BaseChatItemLayout.n, AIOUtils.b(40.0F, localResources), BaseChatItemLayout.o);
      if (paramHolder.c != null) {
        paramHolder.c.setVisibility(8);
      }
      if (paramInt == 999)
      {
        paramHolder.v.setAnimating(false);
        paramHolder.s.setVisibility(8);
      }
      else
      {
        paramHolder.v.setAnimating(true);
        paramHolder.s.setVisibility(0);
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
            if (!c(paramMessageForPtt)) {}
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
  
  private void a(int paramInt, PttItemBuilder.Holder paramHolder)
  {
    if (paramHolder.u != null) {
      paramHolder.u.setProgressColor(paramInt);
    }
    if (paramHolder.s != null) {
      paramHolder.s.setThemeColor(paramInt);
    }
    if (paramHolder.t != null) {
      paramHolder.t.setThemeColor(paramInt);
    }
  }
  
  private void a(View paramView, ColorFilter paramColorFilter)
  {
    PttItemBuilder.Holder localHolder = (PttItemBuilder.Holder)paramView.getTag();
    if (localHolder != null)
    {
      paramView = AIOUtils.a(paramView);
      if ((paramView != null) && (paramView.vipBubbleID == 0L)) {
        a(localHolder.v.getBackground(), paramColorFilter);
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
        paramString2 = localContext.getString(2131916817);
      }
      localObject = new TextView(localContext);
      ((TextView)localObject).setTextSize(0, paramInt2);
      f = ((TextView)localObject).getPaint().measureText(paramString2);
    }
    else
    {
      f = 0.0F;
    }
    paramInt2 = j + 44 + (int)AIOUtils.a((int)paramHolder.d.getPaint().measureText(paramString1), localContext.getResources());
    paramInt1 = paramInt2;
    if (bool1) {
      paramInt1 = paramInt2 + 16;
    }
    paramInt2 = paramInt1;
    if (bool2) {
      paramInt2 = paramInt1 + 38;
    }
    paramInt1 = a(localContext, paramMessageForPtt.voiceLength, f, paramInt2, i, bool1, bool2);
    localObject = (RelativeLayout.LayoutParams)paramHolder.u.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).width = paramInt1;
    paramString1 = VoicePrintUtils.a(paramQQAppInterface, paramBoolean1, bool1, paramInt1 + j, paramHolder);
    paramString2 = (RelativeLayout.LayoutParams)paramHolder.c.getLayoutParams();
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
      localStringBuilder.append(paramHolder.B.getLeft());
      QLog.d("PttItemBuilder", 2, localStringBuilder.toString());
    }
    if ((paramBoolean1) && (paramString2.height > 0))
    {
      paramHolder.u.setVisibility(8);
      paramHolder.c.setVisibility(0);
      paramQQAppInterface = paramHolder.i.a(paramQQAppInterface, 7);
      if ((((BubbleInfo.CommonAttrs)paramQQAppInterface.first).k != null) && (((BubbleInfo.CommonAttrs)paramQQAppInterface.first).k.length > 0))
      {
        paramHolder.c.setBitmap((BubbleInfo.CommonAttrs)paramQQAppInterface.first, paramString1[0], paramString2.height, paramString1[1], paramString1[2], paramMessageForPtt.isSend() ^ true);
        if (paramBoolean2)
        {
          paramHolder.c.a(false);
          return;
        }
        paramHolder.c.a(true);
      }
    }
    else
    {
      if (paramMessageForPtt.voiceLength > 0) {
        paramHolder.u.setAudioData(paramMessageForPtt.waveformArray, ((RelativeLayout.LayoutParams)localObject).width - AIOUtils.b(i, localContext.getResources()), paramMessageForPtt.voiceLength);
      }
      paramHolder.u.setVisibility(0);
      paramHolder.c.setVisibility(8);
    }
  }
  
  private void a(PttItemBuilder.Holder paramHolder, MessageForPtt paramMessageForPtt, View paramView)
  {
    if (this.d.isVideoChatting())
    {
      QQToast.makeText(this.e, 1, 2131892896, 0).show(this.e.getResources().getDimensionPixelSize(2131299920));
      return;
    }
    PttAudioWaveView localPttAudioWaveView = (PttAudioWaveView)paramView.findViewById(2131442196);
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
    MediaPlayerManager.a(this.d).a(paramHolder.l);
    ReportController.b(null, "dc00898", "", "", "0X8009D00", "0X8009D00", 1, 0, "", "", "", "");
    if (!MediaPlayerManager.a(this.d).a(AIOUtils.a(paramView), i)) {
      QQToast.makeText(this.e, 1, 2131892895, 0).show(this.e.getResources().getDimensionPixelSize(2131299920));
    }
  }
  
  private void a(PttItemBuilder.Holder paramHolder, MessageForPtt paramMessageForPtt, boolean paramBoolean)
  {
    paramHolder.d.setTextColor(-16777216);
    if (paramHolder.f != null)
    {
      paramHolder.f.setTextColor(-16777216);
      if ((((ISttManagerService)this.d.getRuntimeService(ISttManagerService.class)).isTranslating(paramMessageForPtt)) && (!paramMessageForPtt.getSttResult().f())) {
        paramHolder.f.setTextColor(PttAudioWaveView.a(-16777216, 0.5F));
      }
    }
    if (paramHolder.A != null) {
      paramHolder.A.setTextColor(-16777216);
    }
    if (!paramBoolean) {
      a(-16777216, paramHolder);
    }
  }
  
  private void a(PttItemBuilder.Holder paramHolder, MessageForPtt paramMessageForPtt, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    Resources localResources = this.e.getResources();
    int j = AIOUtils.b(9.0F, localResources);
    int n = AIOUtils.b(1.5F, localResources);
    int k = AIOUtils.b(12.0F, localResources);
    int m = AIOUtils.b(10.0F, localResources);
    int i;
    try
    {
      i = localResources.getDrawable(2130846265).getIntrinsicHeight();
    }
    catch (Exception localException)
    {
      i = AIOUtils.b(24.0F, localResources);
      QLog.e("PttItemBuilder", 1, "", localException);
    }
    int i1 = AIOUtils.b(1.0F, localResources);
    int i2 = AIOUtils.b(1.5F, localResources);
    paramHolder.d.setPadding(0, BaseChatItemLayout.n, j, BaseChatItemLayout.o);
    paramHolder.u.setPadding(0, 0, n, 0);
    paramHolder.t.setPadding(0, 0, i2, 0);
    Object localObject1 = (RelativeLayout.LayoutParams)paramHolder.s.getLayoutParams();
    if (paramBoolean)
    {
      ((RelativeLayout.LayoutParams)localObject1).width = AIOUtils.b(35.0F, this.e.getResources());
      paramHolder.s.setPadding(AIOUtils.b(2.0F, localResources) + j, 0, 0, 0);
    }
    else
    {
      ((RelativeLayout.LayoutParams)localObject1).width = AIOUtils.b(44.0F, this.e.getResources());
      paramHolder.s.setPadding(AIOUtils.b(2.0F, localResources) + j, 0, j, 0);
    }
    if (paramInt1 == 2)
    {
      if (paramHolder.f == null)
      {
        localObject1 = new ImageView(this.e);
        ((ImageView)localObject1).setImageDrawable(new ColorDrawable(838860800));
        RelativeLayout.LayoutParams localLayoutParams1 = new RelativeLayout.LayoutParams(-1, i1);
        ((ImageView)localObject1).setLayoutParams(localLayoutParams1);
        ((ImageView)localObject1).setId(2131442213);
        ETTextView localETTextView = new ETTextView(this.e);
        if (paramMessageForPtt.isSend()) {
          paramInt1 = 2131168020;
        } else {
          paramInt1 = 2131168016;
        }
        Object localObject2 = localResources.getColorStateList(paramInt1);
        if (localObject2 != null)
        {
          localETTextView.setTextColor((ColorStateList)localObject2);
          if ((paramInt2 == 5) && (paramHolder.i != null) && (paramHolder.i.l != 0)) {
            localETTextView.setTextColor(PttAudioWaveView.a(paramHolder.i.l, 0.5F));
          }
        }
        localETTextView.setId(2131442212);
        localETTextView.setMaxWidth(BaseChatItemLayout.f);
        Object localObject4 = new RelativeLayout.LayoutParams(-2, -2);
        localObject2 = new RelativeLayout(this.e);
        ((RelativeLayout)localObject2).setId(2131442209);
        ProgressBar localProgressBar = new ProgressBar(this.e);
        localProgressBar.setId(2131442210);
        Object localObject3 = new RelativeLayout.LayoutParams(AIOUtils.b(13.0F, this.e.getResources()), AIOUtils.b(13.0F, this.e.getResources()));
        localProgressBar.setIndeterminate(true);
        localProgressBar.setIndeterminateDrawable(this.e.getResources().getDrawable(2130839585));
        ((RelativeLayout.LayoutParams)localObject3).topMargin = AIOUtils.b(13.0F, localResources);
        ((RelativeLayout.LayoutParams)localObject3).leftMargin = AIOUtils.b(16.0F, localResources);
        localProgressBar.setLayoutParams((ViewGroup.LayoutParams)localObject3);
        localObject3 = new TextView(BaseApplicationImpl.getContext());
        RelativeLayout.LayoutParams localLayoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        ((TextView)localObject3).setLayoutParams(localLayoutParams2);
        ((TextView)localObject3).setText(2131916815);
        ((TextView)localObject3).setTextSize(AIOUtils.b(4.0F, localResources));
        ((TextView)localObject3).setIncludeFontPadding(false);
        localLayoutParams2.addRule(5, 2131442212);
        localLayoutParams2.addRule(8, 2131442206);
        if ((paramInt2 != 5) && (paramInt2 != 6))
        {
          ((RelativeLayout.LayoutParams)localObject4).leftMargin = AIOUtils.b(0.0F, localResources);
          localProgressBar.setVisibility(8);
          ((TextView)localObject3).setVisibility(0);
          ((TextView)localObject3).setText(2131916815);
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
            ((TextView)localObject3).setText(2131916813);
          }
        }
        localETTextView.setLayoutParams((ViewGroup.LayoutParams)localObject4);
        ((RelativeLayout)localObject2).addView(localProgressBar);
        ((RelativeLayout)localObject2).addView(localETTextView);
        localObject4 = new ImageView(this.e);
        ((ImageView)localObject4).setId(2131442206);
        localLayoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        ((ImageView)localObject4).setLayoutParams(localLayoutParams2);
        ((ImageView)localObject4).setImageResource(2130846265);
        ((ImageView)localObject4).setScaleType(ImageView.ScaleType.FIT_END);
        ((ImageView)localObject4).setOnClickListener(this);
        localLayoutParams1.addRule(3, 2131442193);
        localLayoutParams1.addRule(14);
        localLayoutParams2.addRule(3, 2131442213);
        localLayoutParams2.addRule(14);
        localLayoutParams2.addRule(6, 2131442209);
        localLayoutParams2.addRule(8, 2131442209);
        localLayoutParams1 = new RelativeLayout.LayoutParams(-2, -2);
        localLayoutParams1.addRule(3, 2131442213);
        ((RelativeLayout)localObject2).setLayoutParams(localLayoutParams1);
        paramHolder.v.addView((View)localObject1);
        paramHolder.v.addView((View)localObject2);
        paramHolder.v.addView((View)localObject4);
        paramHolder.v.addView((View)localObject3);
        paramHolder.y = ((ImageView)localObject1);
        paramHolder.f = localETTextView;
        paramHolder.z = ((ImageView)localObject4);
        paramHolder.A = ((TextView)localObject3);
        paramHolder.C = localProgressBar;
      }
      else
      {
        paramHolder.y.setVisibility(0);
        paramHolder.f.setVisibility(0);
        paramHolder.z.setVisibility(0);
        localObject1 = (RelativeLayout.LayoutParams)paramHolder.f.getLayoutParams();
        if ((paramInt2 != 5) && (paramInt2 != 6))
        {
          ((RelativeLayout.LayoutParams)localObject1).leftMargin = AIOUtils.b(0.0F, localResources);
          paramHolder.C.setVisibility(8);
          paramHolder.A.setVisibility(0);
          paramHolder.A.setText(2131916815);
        }
        else
        {
          ((RelativeLayout.LayoutParams)localObject1).leftMargin = AIOUtils.b(25.0F, localResources);
          if (paramInt2 == 5)
          {
            paramHolder.C.setVisibility(0);
            paramHolder.A.setVisibility(8);
          }
          if (paramInt2 == 6)
          {
            ((RelativeLayout.LayoutParams)localObject1).leftMargin = AIOUtils.b(0.0F, localResources);
            paramHolder.C.setVisibility(8);
            paramHolder.A.setVisibility(0);
            paramHolder.A.setText(2131916813);
          }
        }
        paramHolder.f.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      }
      paramHolder.f.setOnClickListener(this);
      paramHolder.f.setOnTouchListener(paramHolder.D);
      paramHolder.f.setOnLongClickListener(paramHolder.D);
      if ((paramInt2 != 5) && (paramInt2 != 6)) {
        paramHolder.f.setTextSize(0, this.f.r);
      } else {
        paramHolder.f.setTextSize(0, AIOUtils.b(17.0F, this.e.getResources()));
      }
      paramHolder.g = new AIOSelectableDelegateProxy();
      paramHolder.g.a(paramHolder.f);
      paramHolder.g.a(paramHolder.j, paramHolder.j);
      paramHolder.g.b(paramMessageForPtt);
      localObject1 = (RelativeLayout.LayoutParams)paramHolder.y.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject1).addRule(5, 2131442193);
      ((RelativeLayout.LayoutParams)localObject1).addRule(7, 2131442193);
      localObject1 = (RelativeLayout.LayoutParams)paramHolder.f.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject1).addRule(5, 2131442193);
      ((RelativeLayout.LayoutParams)localObject1).addRule(7, 2131442193);
      paramInt1 = AIOUtils.b(22.0F, localResources);
      paramHolder.y.setPadding(j, 0, j, 0);
      paramHolder.f.setPadding(j, BaseChatItemLayout.n, j, paramInt1 + i);
      paramHolder.z.setPadding(0, 0, 0, k);
      paramHolder.A.setPadding(j, 0, 0, m);
      paramMessageForPtt = c(paramMessageForPtt, paramInt2);
      paramHolder.f.setText(paramMessageForPtt);
    }
  }
  
  private void a(PttItemBuilder.Holder paramHolder, MessageForPtt paramMessageForPtt, boolean paramBoolean, View paramView, ChatMessage paramChatMessage)
  {
    paramView = paramView.getResources();
    int i;
    if (paramChatMessage.isSend()) {
      i = 2131168020;
    } else {
      i = 2131168016;
    }
    paramView = paramView.getColorStateList(i);
    if ((paramHolder.d != null) && (paramView != null)) {
      paramHolder.d.setTextColor(paramView);
    }
    if ((paramHolder.f != null) && (paramView != null))
    {
      paramHolder.f.setTextColor(paramView);
      if ((((ISttManagerService)this.d.getRuntimeService(ISttManagerService.class)).isTranslating(paramMessageForPtt)) && (!paramMessageForPtt.getSttResult().f())) {
        paramHolder.f.setTextColor(PttAudioWaveView.a(paramView.getDefaultColor(), 0.5F));
      }
    }
    if ((paramHolder.A != null) && (paramView != null)) {
      paramHolder.A.setTextColor(paramView);
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
    paramHolder.d.setTextColor(paramBubbleInfo.l);
    if (paramHolder.f != null)
    {
      paramHolder.f.setTextColor(paramBubbleInfo.l);
      if ((((ISttManagerService)this.d.getRuntimeService(ISttManagerService.class)).isTranslating(paramMessageForPtt)) && (!paramMessageForPtt.getSttResult().f())) {
        paramHolder.f.setTextColor(PttAudioWaveView.a(paramBubbleInfo.l, 0.5F));
      }
    }
    if (paramHolder.A != null) {
      paramHolder.A.setTextColor(paramBubbleInfo.l);
    }
    if (!paramBoolean) {
      a(paramBubbleInfo.l, paramHolder);
    }
  }
  
  private void a(MessageForPtt paramMessageForPtt)
  {
    paramMessageForPtt.isReadPtt = true;
    paramMessageForPtt.serial();
    this.d.getMessageFacade().a(this.f.b, this.f.a, paramMessageForPtt.uniseq, paramMessageForPtt.msgData);
  }
  
  private void a(MessageForPtt paramMessageForPtt, int paramInt)
  {
    float f = SonicHelper.a;
    Object localObject1;
    if (paramInt == 2131446233)
    {
      f = SonicHelper.b;
      localObject1 = "0X8009E7D";
    }
    else if (paramInt == 2131446230)
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
      if (this.d.isVideoChatting())
      {
        QQToast.makeText(this.e, 1, 2131892896, 0).show(this.e.getResources().getDimensionPixelSize(2131299920));
        return;
      }
      boolean bool1 = AudioDeviceHelper.a(BaseApplicationImpl.getContext());
      boolean bool2 = AudioDeviceHelper.b(BaseApplicationImpl.getContext());
      paramInt = ((AudioPanelAioHelper)this.z.q(128)).m();
      Object localObject2 = PlayModeUtils.a(((AudioPanelAioHelper)this.z.q(128)).i, bool1, bool2, paramInt, f);
      if (paramInt == 0) {
        ((AudioPanelAioHelper)this.z.q(128)).j(PlayModeUtils.a(((AudioPanelAioHelper)this.z.q(128)).i, bool1, bool2));
      }
      if (!TextUtils.isEmpty((CharSequence)localObject2)) {
        QQToast.makeText(this.e, (CharSequence)localObject2, 0).show(this.e.getResources().getDimensionPixelSize(2131299920));
      }
      if (this.z.F() == 0) {
        paramInt = 1;
      } else {
        paramInt = 2;
      }
      ReportController.b(null, "dc00898", "", "", (String)localObject1, (String)localObject1, paramInt, 0, "", "", "", "");
      if (f(paramMessageForPtt)) {
        MediaPlayerManager.a(this.d).a(false);
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
      paramInt = this.z.V.b(paramMessageForPtt) + this.z.U.getHeaderViewsCount();
      int i = this.z.U.getFirstVisiblePosition();
      if (paramInt >= 0)
      {
        localObject2 = this.z.U.getChildAt(paramInt - i);
        Object localObject3 = (PttItemBuilder.Holder)AIOUtils.b((View)localObject2);
        if ((localObject2 != null) && (localObject3 != null))
        {
          localObject1 = (MessageForPtt)((PttItemBuilder.Holder)localObject3).q;
          MediaPlayerManager.a(this.d).a(((PttItemBuilder.Holder)localObject3).l);
          if (localObject1 != null) {
            ((MessageForPtt)localObject1).playSpeedPos = f;
          }
          ((PttItemBuilder.Holder)localObject3).s.setPlayState(true);
          ((PttItemBuilder.Holder)localObject3).u.setCanSupportSlide(true);
          ((PttItemBuilder.Holder)localObject3).a(true);
          localObject2 = (PttAudioWaveView)((View)localObject2).findViewById(2131442196);
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
      if (!MediaPlayerManager.a(this.d).a(paramMessageForPtt, paramInt)) {
        QQToast.makeText(this.e, 1, 2131892895, 0).show(this.e.getResources().getDimensionPixelSize(2131299920));
      }
    }
  }
  
  private void a(MessageForPtt paramMessageForPtt, ChatMessage paramChatMessage)
  {
    if (f(paramMessageForPtt)) {
      MediaPlayerManager.a(this.d).a(false);
    }
    ChatActivityFacade.b(this.e, this.d, paramChatMessage);
    PttInfoCollector.reportLongPressPtt(2);
  }
  
  private void a(QQCustomMenu paramQQCustomMenu)
  {
    paramQQCustomMenu.a(2131431492, this.e.getString(2131916816), 2130839059);
    paramQQCustomMenu.a(2131433636, this.e.getString(2131886589), 2130839066);
    paramQQCustomMenu.a(2131432813, this.e.getString(2131889171), 2130839065);
    paramQQCustomMenu.a(2131446477, this.e.getString(2131916812), 2130846265);
  }
  
  private void a(QQCustomMenu paramQQCustomMenu, MessageForPtt paramMessageForPtt)
  {
    if (i())
    {
      boolean bool1 = SonicHelper.a(paramMessageForPtt.playSpeedPos, SonicHelper.a);
      boolean bool2 = SonicHelper.a(paramMessageForPtt.playSpeedPos, SonicHelper.c);
      if (!bool1) {
        paramQQCustomMenu.a(2131446232, this.e.getString(2131892652), 2130839063);
      }
      if (!bool2) {
        paramQQCustomMenu.a(2131446230, this.e.getString(2131892647), 2130839063);
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
    Object localObject = this.e.getResources();
    int i = AIOUtils.b(15.0F, this.e.getResources());
    if (paramMessageForPtt.voiceLength <= 1) {
      paramMessageForPtt.voiceLength = ((IQQRecorderTempApi)QRoute.api(IQQRecorderTempApi.class)).getFilePlayTime(paramMessageForPtt);
    }
    if (paramMessageForPtt.voiceLength <= 0)
    {
      ((RelativeLayout.LayoutParams)paramHolder.u.getLayoutParams()).width = i;
      paramHolder.u.setVisibility(4);
      paramHolder.d.setText("");
      paramHolder.d.setPadding(AIOUtils.b(10.0F, (Resources)localObject), BaseChatItemLayout.n, AIOUtils.b(10.0F, (Resources)localObject), BaseChatItemLayout.o);
      if (paramHolder.c != null) {
        paramHolder.c.setVisibility(8);
      }
      return false;
    }
    if (paramMessageForPtt.voiceLength > a(this.d, "Normal_MaxPtt"))
    {
      if (paramMessageForPtt.longPttVipFlag == 1)
      {
        if (this.w == null)
        {
          this.w = new SpannableString("[v] QQ会员专享长语音");
          localObject = ((Resources)localObject).getDrawable(2130841176);
          ((Drawable)localObject).setBounds(0, -5, ((Drawable)localObject).getIntrinsicWidth() * 4 / 5 + 5, ((Drawable)localObject).getIntrinsicHeight() * 4 / 5);
          localObject = new OffsetableImageSpan((Drawable)localObject, 1).setOffset(0.05F);
          this.w.setSpan(localObject, 0, 3, 17);
        }
        paramHolder.j.setTailMessage(true, this.w, this);
      }
      else if (paramMessageForPtt.longPttVipFlag == 2)
      {
        if (this.x == null)
        {
          this.x = new SpannableString(HardCodeUtil.a(2131906490));
          localObject = ((Resources)localObject).getDrawable(2130841175);
          ((Drawable)localObject).setBounds(0, -5, ((Drawable)localObject).getIntrinsicWidth() * 4 / 5 + 5, ((Drawable)localObject).getIntrinsicHeight() * 4 / 5);
          localObject = new OffsetableImageSpan((Drawable)localObject, 1).setOffset(0.05F);
          this.x.setSpan(localObject, 0, 3, 17);
        }
        paramHolder.j.setTailMessage(true, this.x, this);
      }
      if (VasUtil.b(this.d).getVipStatus().isSVip())
      {
        localObject = this.d.getCurrentAccountUin();
        String str = HttpUtil.getNetWorkTypeByStr();
        if (VasUtil.b(this.d).getVipStatus().isSVip()) {
          paramHolder = "svip";
        } else {
          paramHolder = "vip";
        }
        VasWebviewUtil.a((String)localObject, "LongVoice", "TailView", "0", 1, 0, 0, str, "", paramHolder);
      }
    }
    if ((paramMessageForPtt.voiceLength > a(this.d, "ConvertText_MaxPtt")) && (paramMessageForPtt.autoToText != 2)) {
      paramMessageForPtt.sttAbility = 0;
    }
    return true;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, ChatMessage paramChatMessage)
  {
    paramQQAppInterface = MediaPlayerManager.a(paramQQAppInterface).f();
    return (paramQQAppInterface == paramChatMessage) || (((paramQQAppInterface instanceof MessageForPtt)) && (paramQQAppInterface.frienduin != null) && (paramQQAppInterface.frienduin.equals(paramChatMessage.frienduin)) && (paramQQAppInterface.uniseq == paramChatMessage.uniseq));
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
    boolean bool3 = a(this.d, this.e, this.c, paramHolder, paramMessageForPtt);
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
    paramHolder.d.setText(paramString);
    a(paramHolder, bool3, bool1, paramMessageForPtt.isSend());
    paramHolder.v.setAnimating(false);
    paramHolder.B.setOnClickListener(this);
    if (paramMessageForPtt.isSend())
    {
      if (paramMessageForPtt.mRobotFlag == 1)
      {
        localObject = ((TroopRobotManager)this.d.getManager(QQManagerFactory.TROOP_ROBOT_MANAGER)).a(this.d, paramMessageForPtt);
        if (!TextUtils.isEmpty((CharSequence)localObject)) {
          paramHolder.j.setTailMessage(true, (CharSequence)localObject, null);
        }
      }
    }
    else
    {
      localObject = ((TroopRobotManager)this.d.getManager(QQManagerFactory.TROOP_ROBOT_MANAGER)).a(this.d, paramMessageForPtt);
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        paramHolder.j.setTailMessage(true, (CharSequence)localObject, null);
      }
    }
    if (((paramInt == 2003) || (paramInt == 1003)) && (!paramMessageForPtt.isSend()) && (!paramMessageForPtt.isReadPtt)) {
      paramHolder.j.setUnread(true);
    }
    int i = b(paramMessageForPtt, paramInt, this.d);
    paramInt = a(paramMessageForPtt, paramInt, this.d);
    a(paramHolder, paramMessageForPtt, bool2, i, paramInt);
    Object localObject = b(paramMessageForPtt, paramInt);
    a(paramHolder, paramMessageForPtt, i, bool3, paramString, paramBoolean, this.d, this.f.r, (String)localObject);
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
    if ((paramInt != 1001) && (paramInt != 1002) && (paramInt != 1005) && (paramInt != 1004) && (paramInt != 2003) && (paramInt != 1003)) {
      return "";
    }
    if ((TextUtils.isEmpty(paramMessageForPtt.timeStr)) || (TextUtils.equals(paramMessageForPtt.timeStr, "0\""))) {
      paramMessageForPtt.timeStr = a(paramMessageForPtt.voiceLength);
    }
    return paramMessageForPtt.timeStr;
  }
  
  private String b(MessageForPtt paramMessageForPtt, int paramInt)
  {
    Object localObject = paramMessageForPtt.sttText;
    if (paramInt == 5)
    {
      localObject = h();
      if ((localObject != null) && (paramMessageForPtt.getSttResult().f())) {
        paramMessageForPtt = ((PttSttHelper)localObject).h(paramMessageForPtt);
      } else {
        paramMessageForPtt = (String)this.B.get(Long.valueOf(paramMessageForPtt.uniseq));
      }
      return paramMessageForPtt;
    }
    paramMessageForPtt = (MessageForPtt)localObject;
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      paramMessageForPtt = this.e.getString(2131916817);
    }
    return paramMessageForPtt;
  }
  
  private void b(MessageForPtt paramMessageForPtt, ChatMessage paramChatMessage)
  {
    if (!AppNetConnInfo.isNetSupport())
    {
      paramMessageForPtt = h();
      if (paramMessageForPtt != null) {
        paramMessageForPtt.b();
      }
      return;
    }
    int i = this.z.V.b(paramMessageForPtt) + this.z.U.getHeaderViewsCount();
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
    int j = this.z.U.getFirstVisiblePosition();
    Object localObject = this.z.U.getChildAt(i - j);
    if (localObject == null) {
      return;
    }
    ReportController.b(this.d, "CliOper", "", "", "0X8005B40", "0X8005B40", 0, 0, "", "", "", "");
    ReportController.b(null, "dc00898", "", "", "0X8009DF7", "0X8009DF7", 0, 0, "", "", "", "");
    localObject = (PttItemBuilder.Holder)((View)localObject).getTag();
    PttInfoCollector.reportLongPressPtt(5);
    if ((paramMessageForPtt.sttAbility != 1) && (paramMessageForPtt.sttAbility != 3))
    {
      if ((paramMessageForPtt.sttAbility == 2) && (!paramMessageForPtt.expandStt))
      {
        paramMessageForPtt.expandStt = true;
        paramMessageForPtt.serial();
        this.d.getMessageFacade().a(this.f.b, this.f.a, paramMessageForPtt.uniseq, paramMessageForPtt.msgData);
        a((PttItemBuilder.Holder)localObject, paramMessageForPtt, a(this.d, paramMessageForPtt), f(paramMessageForPtt));
        a((BaseBubbleBuilder.ViewHolder)localObject, ((PttItemBuilder.Holder)localObject).j, paramMessageForPtt, ((PttItemBuilder.Holder)localObject).i);
      }
    }
    else
    {
      if ((paramMessageForPtt.sttAbility == 3) && (!paramMessageForPtt.expandStt)) {
        paramMessageForPtt.expandStt = true;
      }
      h(paramChatMessage);
      this.B.put(Long.valueOf(paramChatMessage.uniseq), "");
      d(paramMessageForPtt, 1);
      ((ISttManagerService)this.d.getRuntimeService(ISttManagerService.class)).setListener(this);
      a((PttItemBuilder.Holder)localObject, paramMessageForPtt, a(this.d, paramMessageForPtt), f(paramMessageForPtt));
    }
  }
  
  private boolean b(QQCustomMenu paramQQCustomMenu, MessageForPtt paramMessageForPtt)
  {
    if (ConfessMsgUtil.b(paramMessageForPtt)) {
      return true;
    }
    if (!paramMessageForPtt.isReady())
    {
      ChatActivityFacade.a(paramQQCustomMenu, this.e, this.f.a);
      super.a(paramQQCustomMenu, this.e, 2131439015, null, null);
      super.a(paramQQCustomMenu, this.e, 2131428089, null, null);
      return true;
    }
    if (b(paramMessageForPtt) <= 0)
    {
      ChatActivityFacade.a(paramQQCustomMenu, this.e, this.f.a);
      super.a(paramQQCustomMenu, this.e, 2131439015, null, null);
      super.a(paramQQCustomMenu, this.e, 2131428089, null, null);
      return true;
    }
    return false;
  }
  
  private CharSequence c(MessageForPtt paramMessageForPtt, int paramInt)
  {
    String str = paramMessageForPtt.sttText;
    if (paramInt == 5)
    {
      localObject = h();
      if ((localObject != null) && (paramMessageForPtt.getSttResult().f())) {
        paramMessageForPtt = ((PttSttHelper)localObject).g(paramMessageForPtt);
      } else {
        paramMessageForPtt = (CharSequence)this.B.get(Long.valueOf(paramMessageForPtt.uniseq));
      }
      return paramMessageForPtt;
    }
    Object localObject = str;
    if (TextUtils.isEmpty(str))
    {
      if (paramMessageForPtt.sttAbility == 3) {
        return "";
      }
      localObject = this.e.getString(2131916817);
    }
    return localObject;
  }
  
  private String c(int paramInt, MessageForPtt paramMessageForPtt)
  {
    if ((paramInt == 1001) || (paramInt == 1002) || (paramInt == 1005) || (paramInt == 1004) || (paramInt == 2003) || (paramInt == 1003)) {
      if (paramMessageForPtt.voiceLength > a(this.d, "Normal_MaxPtt"))
      {
        if (paramMessageForPtt.longPttVipFlag == 1) {
          return "QQ会员专享长语音";
        }
      }
      else if (paramMessageForPtt.longPttVipFlag == 2) {
        return HardCodeUtil.a(2131906488);
      }
    }
    return null;
  }
  
  protected static boolean c(MessageForPtt paramMessageForPtt)
  {
    String str = ((IQQRecorderUtils)QRoute.api(IQQRecorderUtils.class)).getLastRecorderPath();
    return (paramMessageForPtt.fileSize == -2L) && (!TextUtils.isEmpty(str)) && (str.equals(paramMessageForPtt.getLocalFilePath()));
  }
  
  private void d(int paramInt, MessageForPtt paramMessageForPtt)
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
  
  private void d(MessageForPtt paramMessageForPtt, int paramInt)
  {
    ((ISttManagerService)this.d.getRuntimeService(ISttManagerService.class)).translate(paramMessageForPtt, paramInt);
  }
  
  private void f(MessageForPtt paramMessageForPtt)
  {
    int i = ((IQQRecorderTempApi)QRoute.api(IQQRecorderTempApi.class)).getFilePlayTime(paramMessageForPtt);
    if (i <= 0) {
      return;
    }
    QfavMicroPhoneDialog localQfavMicroPhoneDialog = new QfavMicroPhoneDialog(this.e, this.d, paramMessageForPtt.voiceType, new PttItemBuilder.1(this, paramMessageForPtt));
    if (paramMessageForPtt.isSend()) {
      localObject = paramMessageForPtt.selfuin;
    } else {
      localObject = paramMessageForPtt.senderuin;
    }
    Drawable localDrawable = null;
    if (AnonymousChatHelper.c(paramMessageForPtt)) {
      localDrawable = this.e.getResources().getDrawable(2130844765);
    }
    Bitmap localBitmap = this.g.getBitmapFromCache(1, (String)localObject);
    Object localObject = localBitmap;
    if (localBitmap == null) {
      localObject = this.g.getBitmapFromCache(1, paramMessageForPtt.frienduin);
    }
    if (localQfavMicroPhoneDialog.a(paramMessageForPtt.getLocalFilePath(), i, (Bitmap)localObject, localDrawable)) {
      localQfavMicroPhoneDialog.show();
    } else {
      QfavUtil.a(this.e, 2131889173, 1);
    }
    PttInfoCollector.reportLongPressPtt(1);
  }
  
  private void g(MessageForPtt paramMessageForPtt)
  {
    if (TextUtils.isEmpty(paramMessageForPtt.sttText)) {
      paramMessageForPtt = this.e.getString(2131916817);
    } else {
      paramMessageForPtt = paramMessageForPtt.sttText;
    }
    PttInfoCollector.reportLongPressPtt(3);
    try
    {
      int i = Build.VERSION.SDK_INT;
      if (i < 11)
      {
        ((android.text.ClipboardManager)this.e.getSystemService("clipboard")).setText(paramMessageForPtt);
      }
      else
      {
        android.content.ClipboardManager localClipboardManager = (android.content.ClipboardManager)this.e.getSystemService("clipboard");
        paramMessageForPtt = ClipData.newPlainText("msg", paramMessageForPtt);
        ClipboardMonitor.setPrimaryClip(localClipboardManager, paramMessageForPtt);
        localClipboardManager.setPrimaryClip(paramMessageForPtt);
      }
      ReportController.b(this.d, "CliOper", "", "", "0X8007359", "0X8007359", 0, 0, "", "", "", "");
      return;
    }
    catch (Exception paramMessageForPtt) {}
  }
  
  private boolean g(ChatMessage paramChatMessage)
  {
    return paramChatMessage.vipBubbleID >= 1L;
  }
  
  private void h(ChatMessage paramChatMessage)
  {
    if (QVipConfigManager.a(this.d, "have_show_open_svip_gray_msg", false))
    {
      if (QLog.isColorLevel()) {
        QLog.d("vip_ptt.PttItemBuilder", 1, "ptt auto to txt msg have showed ,so click ptt msg not add msg");
      }
      return;
    }
    Object localObject1 = QVipAutoPttProcessor.e();
    Object localObject2 = (PttAutoChangeBean)QConfigManager.b().b(442);
    if ((localObject2 != null) && (((PttAutoChangeBean)localObject2).a()))
    {
      if (((QVipAutoPttConfig)localObject1).a != 3)
      {
        if (QLog.isColorLevel())
        {
          paramChatMessage = new StringBuilder();
          paramChatMessage.append("ptt auto to txt is open but stage=");
          paramChatMessage.append(((QVipAutoPttConfig)localObject1).a);
          paramChatMessage.append(",so click ptt msg not add msg");
          QLog.d("vip_ptt.PttItemBuilder", 1, paramChatMessage.toString());
        }
        return;
      }
      if (PttConstants.f)
      {
        if (QLog.isColorLevel()) {
          QLog.d("vip_ptt.PttItemBuilder", 1, "ptt auto to txt is open but switch is open ,so click ptt msg not add msg");
        }
        return;
      }
      localObject2 = HardCodeUtil.a(2131906489);
      localObject1 = new Bundle();
      ((Bundle)localObject1).putInt("key_action", 41);
      ((Bundle)localObject1).putString("textColor", "#40A0FF");
      localObject2 = new UniteGrayTipParam(paramChatMessage.frienduin, paramChatMessage.selfuin, (String)localObject2, this.f.a, -5020, 655392, ((MessageForPtt)paramChatMessage).time);
      ((UniteGrayTipParam)localObject2).a(15, 19, (Bundle)localObject1);
      localObject1 = new MessageForUniteGrayTip();
      if (paramChatMessage.istroop == 1) {
        ((MessageForUniteGrayTip)localObject1).shmsgseq = paramChatMessage.shmsgseq;
      }
      ((MessageForUniteGrayTip)localObject1).initGrayTipMsg(this.d, (UniteGrayTipParam)localObject2);
      UniteGrayTipMsgUtil.a(this.d, (MessageForUniteGrayTip)localObject1);
      paramChatMessage = this.z.d.getApp().getSharedPreferences("check_update_sp_key", 0);
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("businessinfo_ptt_auto_change_guide_has_show_");
      ((StringBuilder)localObject1).append(this.z.d.getCurrentAccountUin());
      localObject1 = ((StringBuilder)localObject1).toString();
      paramChatMessage.edit().putBoolean((String)localObject1, true).commit();
      PttConstants.h = true;
      QVipConfigManager.b(this.d, "have_show_open_svip_gray_msg", true);
      QLog.e("vip_ptt.PttItemBuilder", 1, "stage 3 add gray msg seccess");
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("vip_ptt.PttItemBuilder", 1, "ptt auto to txt is close ,so click ptt msg not add msg");
    }
  }
  
  private void h(MessageForPtt paramMessageForPtt)
  {
    PttInfoCollector.reportLongPressPtt(4);
    if ((paramMessageForPtt.sttText != null) && (paramMessageForPtt.sttText.length() > 0))
    {
      Bundle localBundle = new Bundle();
      localBundle.putInt("forward_type", -1);
      localBundle.putString("forward_text", paramMessageForPtt.sttText);
      localBundle.putInt("selection_mode", this.u);
      paramMessageForPtt = new Intent();
      paramMessageForPtt.putExtras(localBundle);
      ForwardBaseOption.a((Activity)this.e, paramMessageForPtt, 21);
      ReportController.b(this.d, "CliOper", "", "", "0X8004045", "0X8004045", 0, 0, "", "", "", "");
      return;
    }
    QQToast.makeText(this.e, HardCodeUtil.a(2131906495), 0).show(this.e.getResources().getDimensionPixelSize(2131299920));
  }
  
  private void i(MessageForPtt paramMessageForPtt)
  {
    if (paramMessageForPtt.sttAbility == 2)
    {
      if (!paramMessageForPtt.expandStt) {
        return;
      }
      int i = this.z.V.b(paramMessageForPtt) + this.z.U.getHeaderViewsCount();
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
      int j = this.z.U.getFirstVisiblePosition();
      paramMessageForPtt = this.z.U.getChildAt(i - j);
      if (paramMessageForPtt == null) {
        return;
      }
      ((PttItemBuilder.Holder)paramMessageForPtt.getTag()).f.performClick();
    }
  }
  
  private void j(MessageForPtt paramMessageForPtt)
  {
    Object localObject1 = this.z;
    if (localObject1 == null) {
      return;
    }
    boolean bool1 = ((AudioPanelAioHelper)((BaseChatPie)localObject1).q(128)).i;
    int i;
    if (bool1) {
      i = 9;
    } else {
      i = 10;
    }
    PttInfoCollector.reportLongPressPtt(i);
    if (paramMessageForPtt.isReady())
    {
      if (this.d.isVideoChatting())
      {
        QQToast.makeText(this.e, 1, 2131892896, 0).show(this.e.getResources().getDimensionPixelSize(2131299920));
        return;
      }
      AudioDeviceHelper.a(bool1 ^ true, this.d);
      boolean bool2 = bool1 ^ true;
      ((AudioPanelAioHelper)this.z.q(128)).i = bool2;
      MediaPlayerManager.a(this.d).c();
      if ((this.z.p != null) && (this.z.ah != null))
      {
        localObject1 = this.z.p;
        if (!bool2) {
          bool1 = true;
        } else {
          bool1 = false;
        }
        ((NavBarAIO)localObject1).a(bool1, this.z.ah.a);
      }
      bool1 = AudioDeviceHelper.a(BaseApplicationImpl.getContext());
      boolean bool3 = AudioDeviceHelper.b(BaseApplicationImpl.getContext());
      ((AudioPanelAioHelper)this.z.q(128)).b(BaseApplicationImpl.getContext(), bool2, bool1, bool3);
      if (f(paramMessageForPtt)) {
        MediaPlayerManager.a(this.d).a(false);
      }
      i = this.z.V.b(paramMessageForPtt) + this.z.U.getHeaderViewsCount();
      int j = this.z.U.getFirstVisiblePosition();
      if (i >= 0)
      {
        Object localObject2 = this.z.U.getChildAt(i - j);
        Object localObject3 = (PttItemBuilder.Holder)AIOUtils.b((View)localObject2);
        if ((localObject2 != null) && (localObject3 != null))
        {
          localObject1 = (MessageForPtt)((PttItemBuilder.Holder)localObject3).q;
          MediaPlayerManager.a(this.d).a(((PttItemBuilder.Holder)localObject3).l);
          ((PttItemBuilder.Holder)localObject3).s.setPlayState(true);
          ((PttItemBuilder.Holder)localObject3).u.setCanSupportSlide(true);
          ((PttItemBuilder.Holder)localObject3).a(true);
          localObject2 = (PttAudioWaveView)((View)localObject2).findViewById(2131442196);
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
      if (!MediaPlayerManager.a(this.d).a(paramMessageForPtt, i)) {
        QQToast.makeText(this.e, 1, 2131892895, 0).show(this.e.getResources().getDimensionPixelSize(2131299920));
      }
    }
  }
  
  protected View a(ChatMessage paramChatMessage, BaseBubbleBuilder.ViewHolder paramViewHolder, View paramView, BaseChatItemLayout paramBaseChatItemLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    paramChatMessage = b(paramChatMessage, paramViewHolder, paramView, paramBaseChatItemLayout, paramOnLongClickAndTouchListener);
    FileTransferManager.a(this.d).a(paramViewHolder.j, this);
    if (AppSetting.e) {
      paramViewHolder.j.setOnClickListener(this);
    }
    paramViewHolder.j.setMiniAioShieldItemTouchListener(this);
    return paramChatMessage;
  }
  
  protected BaseBubbleBuilder.ViewHolder a()
  {
    return new PttItemBuilder.Holder();
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
      if (2131432813 == paramInt)
      {
        f(localMessageForPtt);
        return;
      }
      if (paramInt == 2131431695)
      {
        a(localMessageForPtt, paramChatMessage);
        return;
      }
      if (paramInt == 2131439015)
      {
        PttInfoCollector.reportLongPressPtt(6);
        super.a(paramInt, paramContext, paramChatMessage);
        return;
      }
      if (paramInt == 2131431492)
      {
        g(localMessageForPtt);
        return;
      }
      if (paramInt == 2131433636)
      {
        h(localMessageForPtt);
        return;
      }
      if (paramInt == 2131446477)
      {
        i(localMessageForPtt);
        return;
      }
      if (paramInt == 2131446478)
      {
        b(localMessageForPtt, paramChatMessage);
        return;
      }
      if (paramInt == 2131438943)
      {
        if (f(localMessageForPtt)) {
          MediaPlayerManager.a(this.d).a(true);
        }
        super.a(paramInt, paramContext, paramChatMessage);
        return;
      }
      if (paramInt == 2131440387)
      {
        j(localMessageForPtt);
        return;
      }
      if ((paramInt != 2131446232) && (paramInt != 2131446233) && (paramInt != 2131446230))
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
  
  public void a(View paramView, MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    if ((i != 1) && (i != 3)) {
      return;
    }
    paramView = (PttItemBuilder.Holder)((View)paramView.getParent().getParent()).getTag();
    if (paramView != null) {
      a(paramView.v.getBackground(), null);
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
      b(paramChatMessage, (BaseBubbleBuilder.ViewHolder)localObject, ((BaseBubbleBuilder.ViewHolder)localObject).h, paramView, null);
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
        localObject2 = ((PttItemBuilder.Holder)localObject2).u;
        paramView = AIOUtils.a((View)paramView.getParent().getParent().getParent());
        if ((paramView != null) && ((paramView instanceof MessageForPtt))) {
          if (paramBoolean)
          {
            if (((MessageForPtt)paramView).playProgress > 0.0F) {
              ((PttAudioWaveView)localObject2).setCanSupportSlide(true);
            }
          }
          else if (f(paramView)) {
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
    for (paramView = n;; paramView = null)
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
    boolean bool = a(this.d, this.e, this.c, paramViewHolder, localMessageForPtt);
    if ((paramBubbleInfo.a != 0) && (paramBubbleInfo.b()))
    {
      if (paramBubbleInfo.l == 0) {
        a(paramViewHolder, localMessageForPtt, bool);
      } else {
        a(paramViewHolder, localMessageForPtt, bool, paramBubbleInfo);
      }
      if ((paramBubbleInfo.p) && (((ChatBackgroundManager)this.d.getManager(QQManagerFactory.CHAT_BACKGROUND_MANAGER)).a(this.e, this.f, paramViewHolder.d.getCurrentTextColor(), paramViewHolder.i.q * 10000.0D) == 1))
      {
        float f2 = paramViewHolder.d.getTextSize() * 3.0F / 16.0F;
        float f1 = f2;
        if (f2 > 25.0F) {
          f1 = 25.0F;
        }
        paramViewHolder.d.setTextColor(-1);
        paramViewHolder.d.setShadowLayer(f1, 0.0F, 0.0F, paramBubbleInfo.n);
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
    paramPttAudioWaveView = (PttItemBuilder.Holder)AIOUtils.b(paramPttAudioWaveView);
    if (paramPttAudioWaveView != null)
    {
      MediaPlayerManager localMediaPlayerManager = MediaPlayerManager.a(this.d);
      localMediaPlayerManager.a(localMediaPlayerManager.f(), paramPttAudioWaveView.q);
    }
    MediaPlayerManager.a(this.d).a(false);
  }
  
  public void a(PttAudioWaveView paramPttAudioWaveView, float paramFloat)
  {
    Object localObject = (PttItemBuilder.Holder)AIOUtils.b(paramPttAudioWaveView);
    if (localObject != null)
    {
      paramPttAudioWaveView = (MessageForPtt)((PttItemBuilder.Holder)localObject).q;
      if (paramPttAudioWaveView != null) {
        paramPttAudioWaveView.playProgress = paramFloat;
      }
      if ((((PttItemBuilder.Holder)localObject).s != null) && (!((PttItemBuilder.Holder)localObject).s.getPlayState())) {
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
        MediaPlayerManager.a(this.d).a(paramPttAudioWaveView, i);
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
    paramHolder.j.setUnread(false);
    Object localObject1 = (RelativeLayout.LayoutParams)paramHolder.B.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject1).addRule(0, -1);
    ((RelativeLayout.LayoutParams)localObject1).addRule(1, -1);
    if (paramHolder.w != null)
    {
      paramHolder.w.setVisibility(8);
      paramHolder.w.setOnClickListener(null);
      paramHolder.x.setVisibility(8);
    }
    if ((paramHolder.g != null) && (paramHolder.g.l()) && (paramHolder.g.i()))
    {
      paramHolder.g.j();
      paramHolder.g.n();
    }
    if (paramHolder.f != null)
    {
      paramHolder.f.setVisibility(8);
      paramHolder.f.setOnClickListener(null);
      paramHolder.y.setVisibility(8);
      paramHolder.z.setVisibility(8);
      paramHolder.A.setVisibility(8);
      paramHolder.C.setVisibility(8);
    }
    paramHolder.j.setTailMessage(false, null, null);
    paramHolder.B.setOnTouchListener(paramHolder.D);
    paramHolder.B.setOnLongClickListener(paramHolder.D);
    boolean bool1 = a(paramMessageForPtt, paramHolder);
    boolean bool2 = a(paramInt, paramMessageForPtt);
    String str = b(paramInt, paramMessageForPtt);
    int i = a(paramHolder, paramMessageForPtt, paramInt, paramBoolean, str);
    localObject1 = c(paramInt, paramMessageForPtt);
    if (paramHolder.u != null) {
      paramHolder.u.setSeekListener(this);
    }
    Object localObject2;
    if (i != 1)
    {
      if ((i != 4) && (i != 7))
      {
        paramHolder.j.setFailedIconVisable(false, null);
        if (paramHolder.j.ah != null) {
          paramHolder.j.ah.setBackgroundDrawable(null);
        }
      }
      else
      {
        paramHolder.j.setFailedIconResource(2130839590, null);
        paramHolder.j.ah.setBackgroundDrawable(null);
        ((Animatable)paramHolder.j.ah.getDrawable()).start();
      }
    }
    else
    {
      paramHolder.j.setFailedIconVisable(true, this);
      paramHolder.j.ah.setBackgroundDrawable(null);
      localObject2 = paramHolder.j.ah;
      if (paramMessageForPtt.isSendFromLocal()) {
        paramInt = 2131906492;
      } else {
        paramInt = 2131906484;
      }
      ((ImageView)localObject2).setContentDescription(HardCodeUtil.a(paramInt));
    }
    if (bool1)
    {
      paramMessageForPtt = (IQWalletConfigService)this.d.getRuntimeService(IQWalletConfigService.class, "");
      if (paramMessageForPtt != null) {
        paramMessageForPtt = paramMessageForPtt.getString("voice_pwd", HardCodeUtil.a(2131906491), new String[] { "lowTipStr" });
      } else {
        paramMessageForPtt = HardCodeUtil.a(2131906491);
      }
      paramHolder.j.setTailMessage(true, paramMessageForPtt, null);
    }
    if (AppSetting.e)
    {
      paramMessageForPtt = HardCodeUtil.a(2131906482);
      StringBuilder localStringBuilder;
      if (bool2)
      {
        localObject2 = paramHolder.B;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramMessageForPtt);
        localStringBuilder.append(str);
        localStringBuilder.append(HardCodeUtil.a(2131906487));
        localStringBuilder.append(HardCodeUtil.a(2131906483));
        ((RelativeLayout)localObject2).setContentDescription(localStringBuilder.toString());
      }
      else
      {
        localObject2 = paramHolder.B;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramMessageForPtt);
        localStringBuilder.append(str);
        localStringBuilder.append(HardCodeUtil.a(2131906496));
        ((RelativeLayout)localObject2).setContentDescription(localStringBuilder.toString());
      }
      if (paramHolder.a != null)
      {
        paramMessageForPtt = paramHolder.a;
        paramMessageForPtt.append("发送了语音.");
        paramMessageForPtt.append(str);
        if (localObject1 != null)
        {
          paramHolder = paramHolder.a;
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
    if (this.z != null)
    {
      if (paramBoolean1) {
        i = 2;
      } else {
        i = 1;
      }
      j = this.z.bv().e().b().f();
    }
    else
    {
      i = 5;
      j = 0;
    }
    ChatActivityFacade.a(this.d, this.f.b, paramMessageForPtt, false, i, j, paramBoolean2);
  }
  
  protected void a(PttItemBuilder.Holder paramHolder, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if ((paramBoolean1) && (paramBoolean2))
    {
      Object localObject = this.e.getResources();
      paramHolder.d.setCompoundDrawablePadding(AIOUtils.b(6.0F, this.e.getResources()));
      if (paramBoolean3)
      {
        localObject = ((Resources)localObject).getDrawable(2130848941);
        if (localObject != null)
        {
          ((Drawable)localObject).setBounds(0, 0, ((Drawable)localObject).getMinimumWidth(), ((Drawable)localObject).getMinimumHeight());
          paramHolder.d.setCompoundDrawables((Drawable)localObject, null, null, null);
        }
      }
      else
      {
        localObject = ((Resources)localObject).getDrawable(2130848939);
        if (localObject != null)
        {
          ((Drawable)localObject).setBounds(0, 0, ((Drawable)localObject).getMinimumWidth(), ((Drawable)localObject).getMinimumHeight());
          paramHolder.d.setCompoundDrawables(null, null, (Drawable)localObject, null);
        }
      }
    }
    else
    {
      paramHolder.d.setCompoundDrawablePadding(0);
      paramHolder.d.setCompoundDrawables(null, null, null, null);
    }
  }
  
  public void a(MessageForPtt paramMessageForPtt, boolean paramBoolean)
  {
    this.B.remove(Long.valueOf(paramMessageForPtt.uniseq));
    if (paramMessageForPtt.getSttResult().f())
    {
      if (paramBoolean) {
        this.c.notifyDataSetChanged();
      }
      PttSttHelper localPttSttHelper = h();
      if (localPttSttHelper != null) {
        localPttSttHelper.a(paramMessageForPtt);
      }
    }
    else
    {
      this.c.notifyDataSetChanged();
    }
  }
  
  protected void a(MessageForPtt paramMessageForPtt, boolean paramBoolean, PttItemBuilder.Holder paramHolder)
  {
    this.e.getResources();
    int i;
    if (paramMessageForPtt.isSend())
    {
      if (g(paramMessageForPtt))
      {
        paramMessageForPtt = paramHolder.b;
        if (paramBoolean) {
          i = 2130848937;
        } else {
          i = 2130848940;
        }
        paramMessageForPtt.setImageResource(i);
        return;
      }
      paramMessageForPtt = paramHolder.b;
      if (paramBoolean) {
        i = 2130852107;
      } else {
        i = 2130852108;
      }
      paramMessageForPtt.setImageResource(i);
      return;
    }
    if (g(paramMessageForPtt))
    {
      paramMessageForPtt = paramHolder.b;
      if (paramBoolean) {
        i = 2130848931;
      } else {
        i = 2130848938;
      }
      paramMessageForPtt.setImageResource(i);
      return;
    }
    paramMessageForPtt = paramHolder.b;
    if (paramBoolean) {
      i = 2130852101;
    } else {
      i = 2130852100;
    }
    paramMessageForPtt.setImageResource(i);
  }
  
  protected void a(MessageForPtt paramMessageForPtt, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, PttItemBuilder.Holder paramHolder)
  {
    for (;;)
    {
      try
      {
        Resources localResources = this.e.getResources();
        if ((paramBoolean1) && (!paramBoolean2))
        {
          if (paramMessageForPtt.isSend())
          {
            if (!g(paramMessageForPtt)) {
              break label153;
            }
            if (!paramBoolean3) {
              break label145;
            }
            i = 2130772396;
          }
          else
          {
            if (!g(paramMessageForPtt)) {
              break label182;
            }
            if (!paramBoolean3) {
              break label174;
            }
            i = 2130772394;
          }
          paramMessageForPtt = (AnimationDrawable)localResources.getDrawable(i);
          paramHolder.b.setImageDrawable(paramMessageForPtt);
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
      int i = 2130772395;
      continue;
      label153:
      if (paramBoolean3)
      {
        i = 2130772193;
      }
      else
      {
        i = 2130772192;
        continue;
        label174:
        i = 2130772393;
        continue;
        label182:
        if (paramBoolean3) {
          i = 2130772494;
        } else {
          i = 2130772493;
        }
      }
    }
  }
  
  public void a(MessageRecord paramMessageRecord)
  {
    if ((paramMessageRecord != null) && (this.d != null))
    {
      MqqHandler localMqqHandler = this.d.getHandler(ChatActivity.class);
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
      paramXListView = AIOUtils.b(paramView);
      if ((paramXListView instanceof PttItemBuilder.Holder))
      {
        paramXListView = (PttItemBuilder.Holder)paramXListView;
        if (paramXListView.u != null)
        {
          paramXListView.u.setProgress(paramFloat);
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
      paramXListView = AIOUtils.b(paramView);
      if ((paramXListView instanceof PttItemBuilder.Holder))
      {
        paramXListView = (PttItemBuilder.Holder)paramXListView;
        paramView = (MessageForPtt)paramChatMessage;
        a(paramXListView, paramView, a(this.d, paramView), false);
        if (paramXListView.u != null)
        {
          if (paramBoolean)
          {
            paramXListView.u.setProgress(0.0F);
            paramView.playProgress = 0.0F;
            paramXListView.u.setCanSupportSlide(false);
            paramXListView.a(false);
          }
          if ((!paramXListView.u.o) && (paramXListView.s != null)) {
            paramXListView.s.setPlayState(false);
          }
        }
      }
    }
    e();
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
    return VoicePrintUtils.a(paramQQAppInterface, this.e, paramViewHolder, paramMessageForPtt);
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
        localObject = (IQWalletConfigService)this.d.getRuntimeService(IQWalletConfigService.class, "");
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
          paramMessageForPtt = ((IQWalletHbApi)QRoute.api(IQWalletHbApi.class)).getCustomizeStrategyFactory().a(this.d, (RedPacketInfo)localObject, this);
          if (QLog.isColorLevel())
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("redPacketInfo.icon = ");
            ((StringBuilder)localObject).append(paramMessageForPtt.icon);
            QLog.d("PttItemBuilder", 2, ((StringBuilder)localObject).toString());
          }
          if (paramMessageForPtt.icon != null)
          {
            paramHolder.e.setImageBitmap(paramMessageForPtt.icon);
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
      k = ((IQWalletPreferenceApi)QRoute.api(IQWalletPreferenceApi.class)).getInt(this.d.getAccount(), "voice_low_tips_count", 0);
      if (k < i)
      {
        paramMessageForPtt.saveExtInfoToExtStr("voice_low_tips_tag", "1");
        ThreadManager.post(new PttItemBuilder.2(this, paramMessageForPtt), 10, null, false);
        ((IQWalletPreferenceApi)QRoute.api(IQWalletPreferenceApi.class)).putInt(this.d.getAccount(), "voice_low_tips_count", k + 1);
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
    paramMessageForPtt = paramHolder.e;
    if (i != 0) {
      j = 0;
    }
    paramMessageForPtt.setVisibility(j);
    return bool1;
    if (paramHolder.e != null) {
      paramHolder.e.setVisibility(8);
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
    ((IPTTPreDownloader)this.d.getRuntimeService(IPTTPreDownloader.class)).onPlayPTT(paramXListView);
    boolean bool2 = paramXListView.isReady();
    boolean bool1 = false;
    paramInt1 = 2;
    if (bool2)
    {
      paramView = AIOUtils.b(paramView);
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
        paramAudioPlayerBase.a(this.C);
        paramAudioPlayerBase.d(paramXListView.isSendFromLocal());
        if (paramAudioPlayerBase.c(paramXListView.getLocalFilePath(), paramInt2))
        {
          a(paramXListView);
          if (paramView != null)
          {
            paramAudioPlayerBase = h();
            if (paramAudioPlayerBase != null) {
              paramAudioPlayerBase.f(paramXListView);
            }
            a(paramView, paramXListView, a(this.d, paramXListView), true);
            if (paramView.s != null) {
              paramView.s.setPlayState(true);
            }
            if (paramView.u != null) {
              paramView.u.setCanSupportSlide(true);
            }
            paramView.a(true);
            a(paramXListView, paramView.i);
          }
          PttInfoCollector.reportPttPlay(this.d, paramXListView.istroop, paramXListView.issend);
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
            paramView = this.d;
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
      return paramQQCustomMenu.d();
    }
    if (b(paramQQCustomMenu, paramMessageForPtt)) {
      return paramQQCustomMenu.d();
    }
    if (f(paramMessageForPtt)) {
      MediaPlayerManager.a(this.d).a(false);
    }
    if (!DeviceInfoUtil.W())
    {
      localObject = this.z;
      int i;
      if ((localObject != null) && (((AudioPanelAioHelper)((BaseChatPie)localObject).q(128)).i)) {
        i = 1;
      } else {
        i = 0;
      }
      int j;
      if (i != 0)
      {
        localObject = this.e;
        j = 2131892648;
      }
      else
      {
        localObject = this.e;
        j = 2131892650;
      }
      localObject = ((Context)localObject).getString(j);
      if (i != 0) {
        i = 2130839063;
      } else {
        i = 2130839067;
      }
      paramQQCustomMenu.a(2131440387, (String)localObject, i);
    }
    if (((paramMessageForPtt.extraflag != 32768) && (a(this.d, paramMessageForPtt) == 1003) && (!this.d.getMsgCache().f(paramMessageForPtt))) || (TroopUtils.a(this.d, paramMessageForPtt, this.d.getCurrentAccountUin()))) {
      a(paramQQCustomMenu, this.e, 2131438943, paramMessageForPtt, new Bundle());
    }
    a(paramQQCustomMenu, paramMessageForPtt);
    if (paramMessageForPtt.voiceChangeFlag != 1) {
      if ((paramMessageForPtt.sttAbility != 1) && (paramMessageForPtt.sttAbility != 3))
      {
        if ((paramMessageForPtt.sttAbility == 2) && (!paramMessageForPtt.expandStt) && (!((IVoiceRedPacketHelper)QRoute.api(IVoiceRedPacketHelper.class)).isRedPackPTT(paramMessageForPtt))) {
          paramQQCustomMenu.a(2131446478, this.e.getString(2131916819), 2130839056);
        }
      }
      else if ((!((ISttManagerService)this.d.getRuntimeService(ISttManagerService.class)).isTranslating(paramMessageForPtt)) && ((!paramMessageForPtt.isSend()) || (paramMessageForPtt.fileSize > 0L)) && (!((IVoiceRedPacketHelper)QRoute.api(IVoiceRedPacketHelper.class)).isRedPackPTT(paramMessageForPtt))) {
        paramQQCustomMenu.a(2131446478, this.e.getString(2131916819), 2130839056);
      }
    }
    a(paramQQCustomMenu, this.e, 2131444634, paramMessageForPtt, null);
    paramQQCustomMenu.a(this.e.getString(2131888193));
    a(paramQQCustomMenu, this.e, 2131431695, paramMessageForPtt, new Bundle());
    paramQQCustomMenu.a(2131432813, this.e.getString(2131889171), 2130839065);
    Object localObject = new Bundle();
    ((Bundle)localObject).putBoolean("isSearch", false);
    a(paramQQCustomMenu, this.e, 2131449133, paramMessageForPtt, (Bundle)localObject);
    a(paramQQCustomMenu, this.e, 2131444651, paramMessageForPtt, null);
    a(paramQQCustomMenu, this.e, 2131439015, null, null);
    a(paramQQCustomMenu, this.e, 2131428089, null, null);
    return paramQQCustomMenu.d();
  }
  
  public void a_(ChatMessage paramChatMessage)
  {
    ReportController.b(this.d, "dc00898", "", "", "0X800A5A7", "0X800A5A7", 0, 0, "1", "", "", "");
  }
  
  protected int b(MessageForPtt paramMessageForPtt)
  {
    return ((IQQRecorderTempApi)QRoute.api(IQQRecorderTempApi.class)).getFilePlayTime(paramMessageForPtt);
  }
  
  protected View b(ChatMessage paramChatMessage, BaseBubbleBuilder.ViewHolder paramViewHolder, View paramView, BaseChatItemLayout paramBaseChatItemLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    paramBaseChatItemLayout = (PttItemBuilder.Holder)paramViewHolder;
    this.A.add(paramBaseChatItemLayout);
    MessageForPtt localMessageForPtt = (MessageForPtt)paramChatMessage;
    paramViewHolder = h();
    if (paramViewHolder != null) {
      paramViewHolder.a(paramBaseChatItemLayout, localMessageForPtt, this.f.r);
    }
    if (paramView == null)
    {
      paramViewHolder = new BreathAnimationLayout(this.e);
      paramViewHolder.setId(2131442190);
      paramView = new PttAudioPlayView(this.e, 12);
      paramView.setThemeColor(this.e.getResources().getColorStateList(2131168016).getDefaultColor());
      paramView.setId(2131442195);
      Object localObject1 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject1).addRule(15, -1);
      ((RelativeLayout.LayoutParams)localObject1).width = AIOUtils.b(44.0F, this.e.getResources());
      ((RelativeLayout.LayoutParams)localObject1).height = AIOUtils.b(44.0F, this.e.getResources());
      paramView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      localObject1 = new PttAudioChangeView(this.e, 2130838207, 8);
      ((PttAudioChangeView)localObject1).setThemeColor(this.e.getResources().getColorStateList(2131168016).getDefaultColor());
      ((PttAudioChangeView)localObject1).setId(2131442201);
      Object localObject2 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject2).addRule(15, -1);
      ((RelativeLayout.LayoutParams)localObject2).width = AIOUtils.b(16.0F, this.e.getResources());
      ((RelativeLayout.LayoutParams)localObject2).height = AIOUtils.b(19.0F, this.e.getResources());
      ((PttAudioChangeView)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
      localObject2 = new PttAudioWaveView(this.e);
      ((PttAudioWaveView)localObject2).setProgressColor(this.e.getResources().getColorStateList(2131168016).getDefaultColor());
      ((PttAudioWaveView)localObject2).setId(2131442196);
      Object localObject3 = new RelativeLayout.LayoutParams(-1, -1);
      ((RelativeLayout.LayoutParams)localObject3).addRule(15, -1);
      ((RelativeLayout.LayoutParams)localObject3).width = AIOUtils.b(10.0F, this.e.getResources());
      ((RelativeLayout.LayoutParams)localObject3).height = AIOUtils.b(52.0F, this.e.getResources());
      ((PttAudioWaveView)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject3);
      localObject3 = new TextView(this.e);
      ((TextView)localObject3).setId(2131442197);
      ((TextView)localObject3).setTextColor(this.e.getResources().getColorStateList(2131168016));
      VoicePrintUtils.VoicePrintView localVoicePrintView = new VoicePrintUtils.VoicePrintView(this.e);
      localVoicePrintView.setId(2131442198);
      ImageView localImageView = new ImageView(this.e);
      localImageView.setId(2131442200);
      Object localObject4 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject4).addRule(15, -1);
      ((TextView)localObject3).setLayoutParams((ViewGroup.LayoutParams)localObject4);
      localObject4 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject4).addRule(15, -1);
      localVoicePrintView.setLayoutParams((ViewGroup.LayoutParams)localObject4);
      localObject4 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject4).addRule(15, -1);
      ((RelativeLayout.LayoutParams)localObject4).width = AIOUtils.b(47.0F, this.e.getResources());
      ((RelativeLayout.LayoutParams)localObject4).height = AIOUtils.b(41.0F, this.e.getResources());
      localImageView.setLayoutParams((ViewGroup.LayoutParams)localObject4);
      localObject4 = new SyncParentPressedRelativeLayout(this.e);
      ((RelativeLayout)localObject4).setId(2131442193);
      ((RelativeLayout)localObject4).addView((View)localObject2);
      ((RelativeLayout)localObject4).addView(paramView);
      ((RelativeLayout)localObject4).addView((View)localObject1);
      ((RelativeLayout)localObject4).addView((View)localObject3);
      ((RelativeLayout)localObject4).addView(localVoicePrintView);
      ((RelativeLayout)localObject4).addView(localImageView);
      paramViewHolder.addView((View)localObject4);
      paramBaseChatItemLayout.v = paramViewHolder;
      paramBaseChatItemLayout.s = paramView;
      paramBaseChatItemLayout.t = ((PttAudioChangeView)localObject1);
      paramBaseChatItemLayout.u = ((PttAudioWaveView)localObject2);
      paramBaseChatItemLayout.d = ((TextView)localObject3);
      paramBaseChatItemLayout.c = localVoicePrintView;
      paramBaseChatItemLayout.e = localImageView;
      paramBaseChatItemLayout.B = ((RelativeLayout)localObject4);
    }
    else
    {
      paramViewHolder = paramView;
    }
    if (paramOnLongClickAndTouchListener != null) {
      paramBaseChatItemLayout.D = paramOnLongClickAndTouchListener;
    }
    if (localMessageForPtt.voiceChangeFlag != 0) {
      i = 1;
    } else {
      i = 0;
    }
    boolean bool = a(this.d, this.e, this.c, paramBaseChatItemLayout, localMessageForPtt);
    if (bool)
    {
      paramBaseChatItemLayout.c.setVisibility(0);
      paramBaseChatItemLayout.u.setVisibility(8);
      paramBaseChatItemLayout.s.setVisibility(8);
      paramBaseChatItemLayout.t.setVisibility(8);
    }
    else
    {
      paramBaseChatItemLayout.c.setVisibility(8);
      paramBaseChatItemLayout.s.setVisibility(0);
      paramBaseChatItemLayout.u.setVisibility(0);
      paramBaseChatItemLayout.u.setOnClickListener(this);
      if (i != 0) {
        paramBaseChatItemLayout.t.setVisibility(0);
      } else {
        paramBaseChatItemLayout.t.setVisibility(8);
      }
      paramBaseChatItemLayout.u.setOnTouchListener(paramBaseChatItemLayout.D);
      paramBaseChatItemLayout.u.setOnLongClickListener(paramBaseChatItemLayout.D);
      paramBaseChatItemLayout.u.setOnPressListener(paramBaseChatItemLayout.E);
      if ((!f(paramChatMessage)) && (!paramBaseChatItemLayout.u.o))
      {
        if (localMessageForPtt.playProgress > 0.0F)
        {
          paramBaseChatItemLayout.u.setCanSupportSlide(true);
          paramBaseChatItemLayout.a(true);
        }
        else
        {
          paramBaseChatItemLayout.u.setCanSupportSlide(false);
          paramBaseChatItemLayout.a(false);
        }
        paramBaseChatItemLayout.u.setProgress(localMessageForPtt.playProgress);
        paramBaseChatItemLayout.s.setPlayState(false);
      }
      else
      {
        paramBaseChatItemLayout.u.setCanSupportSlide(true);
        paramBaseChatItemLayout.a(true);
        paramBaseChatItemLayout.s.setPlayState(true);
      }
    }
    if (paramChatMessage.isSend())
    {
      paramView = (RelativeLayout.LayoutParams)paramBaseChatItemLayout.d.getLayoutParams();
      if (bool)
      {
        paramView.addRule(1, 2131442198);
        ((RelativeLayout.LayoutParams)paramBaseChatItemLayout.c.getLayoutParams()).addRule(1, 2131442200);
        ((RelativeLayout.LayoutParams)paramBaseChatItemLayout.e.getLayoutParams()).addRule(1, -1);
      }
      else
      {
        paramView.addRule(1, 2131442196);
        ((RelativeLayout.LayoutParams)paramBaseChatItemLayout.u.getLayoutParams()).addRule(1, 2131442201);
        ((RelativeLayout.LayoutParams)paramBaseChatItemLayout.t.getLayoutParams()).addRule(1, 2131442200);
        ((RelativeLayout.LayoutParams)paramBaseChatItemLayout.e.getLayoutParams()).addRule(1, 2131442195);
        ((RelativeLayout.LayoutParams)paramBaseChatItemLayout.s.getLayoutParams()).addRule(1, -1);
      }
    }
    else if (bool)
    {
      ((RelativeLayout.LayoutParams)paramBaseChatItemLayout.e.getLayoutParams()).addRule(1, 2131442197);
      ((RelativeLayout.LayoutParams)paramBaseChatItemLayout.d.getLayoutParams()).addRule(1, 2131442198);
      ((RelativeLayout.LayoutParams)paramBaseChatItemLayout.c.getLayoutParams()).addRule(1, -1);
    }
    else
    {
      ((RelativeLayout.LayoutParams)paramBaseChatItemLayout.d.getLayoutParams()).addRule(1, 2131442196);
      ((RelativeLayout.LayoutParams)paramBaseChatItemLayout.u.getLayoutParams()).addRule(1, 2131442201);
      ((RelativeLayout.LayoutParams)paramBaseChatItemLayout.t.getLayoutParams()).addRule(1, 2131442200);
      ((RelativeLayout.LayoutParams)paramBaseChatItemLayout.e.getLayoutParams()).addRule(1, 2131442195);
      ((RelativeLayout.LayoutParams)paramBaseChatItemLayout.s.getLayoutParams()).addRule(1, -1);
    }
    int j = a(this.d, localMessageForPtt);
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
    if (((localMessageForPtt.istroop == 1) || (localMessageForPtt.istroop == 3000)) && (i == 2003) && (((ISttManagerService)this.d.getRuntimeService(ISttManagerService.class)).needAuotoChange(localMessageForPtt)))
    {
      d(localMessageForPtt, 1);
      ReportController.b(null, "dc00898", "", "", "0X8009DF6", "0X8009DF6", 0, 0, "", "", "", "");
    }
    a(paramBaseChatItemLayout, localMessageForPtt, i, f(localMessageForPtt));
    ((IPTTPreDownloader)this.d.getRuntimeService(IPTTPreDownloader.class)).onViewPTT(localMessageForPtt);
    PttInfoCollector.reportPttItemBuilderType(this.d, i, paramChatMessage);
    return paramViewHolder;
  }
  
  public void b()
  {
    ((ISttManagerService)this.d.getRuntimeService(ISttManagerService.class)).setListener(null);
    Iterator localIterator = this.A.iterator();
    while (localIterator.hasNext()) {
      ((PttItemBuilder.Holder)localIterator.next()).b();
    }
    this.A.clear();
    this.A = null;
    this.B.clear();
  }
  
  protected void b(View paramView)
  {
    MessageForPtt localMessageForPtt = (MessageForPtt)AIOUtils.a(paramView);
    paramView = (PttItemBuilder.Holder)AIOUtils.b(paramView);
    if (localMessageForPtt.isSendFromLocal())
    {
      paramView = ActionSheet.create(this.e);
      paramView.setMainTitle(2131886575);
      paramView.addButton(2131886574);
      paramView.addCancelButton(2131887648);
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
      QQToast.makeText(BaseApplication.getContext(), 2131892168, 0).show(BaseApplication.getContext().getResources().getDimensionPixelSize(2131299920));
      return;
    }
    QQToast.makeText(BaseApplication.getContext(), 2131916077, 0).show(BaseApplication.getContext().getResources().getDimensionPixelSize(2131299920));
  }
  
  public boolean b(ChatMessage paramChatMessage)
  {
    return true;
  }
  
  public int c(ChatMessage paramChatMessage)
  {
    return 1;
  }
  
  public BaseBubbleBuilder.TouchDelegate d(View paramView)
  {
    if (AIOUtils.a(paramView) != null) {
      return this;
    }
    return null;
  }
  
  protected String d(ChatMessage paramChatMessage)
  {
    if (MessageRecordInfo.b(paramChatMessage.issend)) {
      return HardCodeUtil.a(2131906485);
    }
    return HardCodeUtil.a(2131906486);
  }
  
  public void d(MessageForPtt paramMessageForPtt)
  {
    this.B.remove(Long.valueOf(paramMessageForPtt.uniseq));
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramMessageForPtt.getSttResult().g());
    ((StringBuilder)localObject).append("");
    localObject = ((StringBuilder)localObject).toString();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramMessageForPtt.getSttResult().h());
    localStringBuilder.append("");
    ThreadManager.excute(new PttItemBuilder.4(this, (String)localObject, localStringBuilder.toString()), 16, null, false);
    localObject = h();
    if (localObject != null) {
      ((PttSttHelper)localObject).b(paramMessageForPtt);
    }
    this.c.notifyDataSetChanged();
  }
  
  public void e(MessageForPtt paramMessageForPtt)
  {
    PttSttHelper localPttSttHelper = h();
    if (localPttSttHelper != null) {
      localPttSttHelper.c(paramMessageForPtt);
    }
  }
  
  public void f()
  {
    PttInfoCollector.reportLongPressPtt(7);
    super.f();
  }
  
  protected boolean f(ChatMessage paramChatMessage)
  {
    return a(this.d, paramChatMessage);
  }
  
  @Nullable
  protected PttSttHelper h()
  {
    BaseChatPie localBaseChatPie = this.z;
    if (localBaseChatPie == null) {
      return null;
    }
    return (PttSttHelper)localBaseChatPie.q(82);
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
        paramView = (PttItemBuilder.Holder)AIOUtils.b(paramView);
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
                d(paramInt2, localMessageForPtt);
                i = paramInt1;
              }
            }
          }
          else
          {
            this.c.notifyDataSetChanged();
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
              d();
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
        a(paramView, localMessageForPtt, i, f(localMessageForPtt));
      }
    }
  }
  
  protected boolean i()
  {
    return SonicHelper.a();
  }
  
  public void onClick(View paramView)
  {
    AIOUtils.q = true;
    int i = paramView.getId();
    if ((AppSetting.e) && (i == 2131429332))
    {
      paramView.findViewById(2131442193).performClick();
    }
    else
    {
      Object localObject2 = (PttItemBuilder.Holder)AIOUtils.b(paramView);
      Object localObject1 = (MessageForPtt)((PttItemBuilder.Holder)localObject2).q;
      Object localObject3;
      if ((i != 2131442193) && (i != 2131442196))
      {
        if ((i != 2131442212) && (i != 2131442206))
        {
          if (i == 2131430608)
          {
            if (this.e != null)
            {
              localObject2 = this.d.getCurrentAccountUin();
              localObject3 = HttpUtil.getNetWorkTypeByStr();
              if (VasUtil.b(this.d).getVipStatus().isSVip()) {
                localObject1 = "svip";
              } else {
                localObject1 = "vip";
              }
              VasWebviewUtil.a((String)localObject2, "LongVoice", "TailClick", "0", 1, 0, 0, (String)localObject3, "", (String)localObject1);
              localObject1 = new Intent(this.e, QQBrowserActivity.class);
              ((Intent)localObject1).putExtra("uin", this.d.getCurrentAccountUin());
              ((Intent)localObject1).putExtra("url", "https://m.vip.qq.com/freedom/xhycyy.html?_nav_alpha=0");
              this.e.startActivity((Intent)localObject1);
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
          this.d.getMessageFacade().a(this.f.b, this.f.a, ((MessageForPtt)localObject1).uniseq, ((MessageForPtt)localObject1).msgData);
          a((PttItemBuilder.Holder)localObject2, (MessageForPtt)localObject1, a(this.d, (MessageForPtt)localObject1), f((ChatMessage)localObject1));
          ReportController.b(null, "dc00898", "", "", "0X8009DF8", "0X8009DF8", 0, 0, "", "", "", "");
          ReportController.b(this.d, "CliOper", "", "", "0X8003F37", "0X8003F37", 0, 0, "", "", "", "");
        }
      }
      else if (localObject1 != null)
      {
        if (f((ChatMessage)localObject1))
        {
          MediaPlayerManager.a(this.d).a(false);
          ReportController.b(null, "dc00898", "", "", "0X8009D00", "0X8009D00", 2, 0, "", "", "", "");
        }
        else if ((localObject1 != MediaPlayerManager.a(this.d).f()) && (((MessageForPtt)localObject1).isReady()))
        {
          a((PttItemBuilder.Holder)localObject2, (MessageForPtt)localObject1, paramView);
        }
        if (((MessageForPtt)localObject1).istroop == 1008) {
          ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(this.d, "P_CliOper", "Pb_account_lifeservice", "", "0X8005857", "0X8005857", 0, 0, "", "", ((MessageForPtt)localObject1).timeStr, "", false);
        }
        if (((MessageForPtt)localObject1).voiceChangeFlag == 1)
        {
          localObject2 = this.d;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.PttItemBuilder
 * JD-Core Version:    0.7.0.1
 */