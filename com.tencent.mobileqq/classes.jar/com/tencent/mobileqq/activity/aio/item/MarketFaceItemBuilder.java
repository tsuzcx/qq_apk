package com.tencent.mobileqq.activity.aio.item;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningTaskInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v4.util.ArraySet;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.common.galleryactivity.AnimationUtils;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.MultiForwardActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.ViewHolder;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.MediaPlayerManager;
import com.tencent.mobileqq.activity.aio.MediaPlayerManager.Callback;
import com.tencent.mobileqq.activity.aio.OnLongClickAndTouchListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.helper.AIORelatedEmotionHelper;
import com.tencent.mobileqq.activity.contact.connections.TriangleView;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.config.business.AIORelatedEmotionConfProcessor;
import com.tencent.mobileqq.config.business.AIORelatedEmotionConfProcessor.RelatedEmotionConfigBean;
import com.tencent.mobileqq.core.util.EmoticonPanelUtils;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.CustomEmotionData;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.data.MarkFaceMessage;
import com.tencent.mobileqq.data.MessageForMarketFace;
import com.tencent.mobileqq.doutu.DoutuConfigReporter;
import com.tencent.mobileqq.doutu.DoutuMsgUtil;
import com.tencent.mobileqq.doutu.DuiButtonImageView;
import com.tencent.mobileqq.emosm.AIOEmoticonUIHelper;
import com.tencent.mobileqq.emosm.IEmoticonHandler;
import com.tencent.mobileqq.emosm.api.IEmoticonManagerService;
import com.tencent.mobileqq.emosm.api.IFavroamingDBManagerService;
import com.tencent.mobileqq.emosm.api.IFavroamingManagerService;
import com.tencent.mobileqq.emosm.favroaming.EmoBatchAddedHandlerConstant;
import com.tencent.mobileqq.emosm.favroaming.FavEmoConstant;
import com.tencent.mobileqq.emosm.favroaming.IEmoBatchAddedCallback;
import com.tencent.mobileqq.emoticon.EmoticonOperateReport;
import com.tencent.mobileqq.emoticon.EmoticonPackageDownloadListener;
import com.tencent.mobileqq.emoticon.IEmojiListenerManager;
import com.tencent.mobileqq.emoticon.api.EmojiManagerServiceConstant;
import com.tencent.mobileqq.emoticon.api.IEmojiManagerService;
import com.tencent.mobileqq.emoticonview.EmotionPanelConstans;
import com.tencent.mobileqq.emoticonview.IPicEmoticonInfo;
import com.tencent.mobileqq.emoticonview.QueryTask;
import com.tencent.mobileqq.emoticonview.api.IEmoAddedAuthCallbackService;
import com.tencent.mobileqq.emoticonview.api.IPicEmoticonInfoService;
import com.tencent.mobileqq.emotionintegrate.AIOEmotionFragment;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.magicface.drawable.PngFrameDrawable;
import com.tencent.mobileqq.magicface.drawable.PngFrameManager;
import com.tencent.mobileqq.magicface.drawable.PngFrameUtil;
import com.tencent.mobileqq.magicface.view.MagicfaceViewController;
import com.tencent.mobileqq.nearby.api.IHotChatUtil;
import com.tencent.mobileqq.qqaudio.audioplayer.AudioPlayerBase;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.service.message.remote.MessageRecordInfo;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.structmsg.RoundedColorDrawable;
import com.tencent.mobileqq.troop.troopgag.data.SelfGagInfo;
import com.tencent.mobileqq.troop.utils.TroopGagMgr;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenuItem;
import com.tencent.mobileqq.vas.webview.util.VasWebviewUtil;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import com.tencent.widget.XListView;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;

public class MarketFaceItemBuilder
  extends BaseBubbleBuilder
  implements MediaPlayerManager.Callback
{
  public static int a = 1;
  public static ChatMessage a;
  public static IPicEmoticonInfo a;
  static long jdField_c_of_type_Long;
  MarketFaceItemBuilder.EmoticonDetailJsonDownloaderVars jdField_a_of_type_ComTencentMobileqqActivityAioItemMarketFaceItemBuilder$EmoticonDetailJsonDownloaderVars = new MarketFaceItemBuilder.EmoticonDetailJsonDownloaderVars();
  EmoticonPackageDownloadListener jdField_a_of_type_ComTencentMobileqqEmoticonEmoticonPackageDownloadListener = new MarketFaceItemBuilder.7(this);
  IEmojiManagerService jdField_a_of_type_ComTencentMobileqqEmoticonApiIEmojiManagerService;
  public List<MarketFaceItemBuilder.Holder> a;
  Set<Long> jdField_a_of_type_JavaUtilSet = new HashSet();
  public Context b;
  Set<MarketFaceItemBuilder.Holder> b;
  Set<Long> jdField_c_of_type_JavaUtilSet = new ArraySet();
  public int d;
  private long d;
  public int e;
  boolean f = false;
  
  public MarketFaceItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    this.jdField_b_of_type_JavaUtilSet = new HashSet();
    this.jdField_d_of_type_Int = 320;
    this.jdField_e_of_type_Int = BaseApplication.getContext().getResources().getDisplayMetrics().densityDpi;
    this.jdField_b_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_ComTencentMobileqqEmoticonApiIEmojiManagerService = ((IEmojiManagerService)paramQQAppInterface.getRuntimeService(IEmojiManagerService.class));
    if ((this.jdField_b_of_type_AndroidContentContext instanceof SplashActivity)) {
      this.f = true;
    }
  }
  
  public static int a(Context paramContext, QQAppInterface paramQQAppInterface, Emoticon paramEmoticon, Handler paramHandler)
  {
    IFavroamingDBManagerService localIFavroamingDBManagerService = (IFavroamingDBManagerService)paramQQAppInterface.getRuntimeService(IFavroamingDBManagerService.class);
    if (QLog.isColorLevel()) {
      QLog.i("MarketFaceItemBuilder", 2, "Call getEmoticonDataList from addEmotionToFavorite.");
    }
    List localList = localIFavroamingDBManagerService.getEmoticonDataList();
    boolean bool = true;
    int j;
    int i;
    if (localList != null)
    {
      j = 0;
      int m = 0;
      int n;
      for (i = 1; j < localList.size(); i = n)
      {
        CustomEmotionData localCustomEmotionData = (CustomEmotionData)localList.get(j);
        int k;
        if (!TextUtils.isEmpty(localCustomEmotionData.RomaingType))
        {
          k = m;
          if ("needDel".equals(localCustomEmotionData.RomaingType)) {}
        }
        else
        {
          k = m + 1;
        }
        if ((localCustomEmotionData.isMarkFace) && (localCustomEmotionData.emoPath.equals(paramEmoticon.epId)) && (localCustomEmotionData.eId.equals(paramEmoticon.eId)))
        {
          if (localIFavroamingDBManagerService.updateDeletedEmoticon(localCustomEmotionData, j))
          {
            paramQQAppInterface = paramQQAppInterface.getHandler(ChatActivity.class);
            if (paramHandler != null) {
              paramHandler.post(new MarketFaceItemBuilder.15(paramContext));
            }
            EmoticonOperateReport.reportEmoticonOperateMonitorAddStatus("0", 1);
            if (paramQQAppInterface != null)
            {
              paramQQAppInterface.obtainMessage(10).sendToTarget();
              return 0;
            }
          }
          else
          {
            if (paramHandler != null) {
              paramHandler.post(new MarketFaceItemBuilder.16(paramContext));
            }
            EmoticonOperateReport.reportEmoticonOperateMonitorAddStatus("2003", 1);
          }
          return 0;
        }
        n = i;
        if (i < localCustomEmotionData.emoId) {
          n = localCustomEmotionData.emoId;
        }
        j += 1;
        m = k;
      }
      if (m >= FavEmoConstant.jdField_a_of_type_Int) {
        j = -2;
      } else {
        j = 0;
      }
    }
    else
    {
      j = 0;
      i = 1;
    }
    paramHandler = new CustomEmotionData();
    paramHandler.uin = paramQQAppInterface.getCurrentAccountUin();
    paramHandler.emoId = (i + 1);
    paramHandler.isMarkFace = true;
    paramHandler.emoPath = paramEmoticon.epId;
    paramHandler.eId = paramEmoticon.eId;
    paramHandler.checkMarketFace("addEmotionToFavorite");
    paramEmoticon = ((IEmoticonManagerService)paramQQAppInterface.getRuntimeService(IEmoticonManagerService.class)).syncFindEmoticonPackageById(paramEmoticon.epId);
    if (paramEmoticon != null)
    {
      if (paramEmoticon.isAPNG != 2) {
        bool = false;
      }
      paramHandler.isAPNG = bool;
    }
    paramEmoticon = (IFavroamingManagerService)paramQQAppInterface.getRuntimeService(IFavroamingManagerService.class);
    if (paramEmoticon != null) {
      paramEmoticon.syncUpload(paramHandler, ((IEmoAddedAuthCallbackService)QRoute.api(IEmoAddedAuthCallbackService.class)).createEmoAddedAuthCallback(paramQQAppInterface, paramContext, paramHandler, null, 0));
    }
    paramContext = jdField_a_of_type_ComTencentMobileqqDataChatMessage;
    if (paramContext != null) {
      a(paramQQAppInterface, paramContext.frienduin, "ep_mall", "Clk_collect_suc", 0);
    }
    return j;
  }
  
  private SpannableString a(int paramInt, String paramString1, String paramString2)
  {
    Object localObject = paramString2;
    if (TextUtils.isEmpty(paramString2))
    {
      i = 2131691028;
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          if (paramInt != 3)
          {
            if (paramInt != 4)
            {
              paramString2 = "";
              paramInt = i;
            }
            else
            {
              paramString2 = HardCodeUtil.a(2131706532);
              paramInt = i;
            }
          }
          else
          {
            paramString2 = HardCodeUtil.a(2131706522);
            paramInt = i;
          }
        }
        else
        {
          paramString2 = HardCodeUtil.a(2131706525);
          paramInt = i;
        }
      }
      else
      {
        paramInt = 2131691029;
        paramString2 = HardCodeUtil.a(2131706530);
      }
      localObject = this.jdField_b_of_type_AndroidContentContext.getString(paramInt, new Object[] { paramString2 });
    }
    paramString2 = new StringBuilder();
    paramString2.append((String)localObject);
    paramString2.append(paramString1);
    paramString2 = paramString2.toString();
    localObject = new SpannableString(paramString2);
    paramInt = paramString2.indexOf(paramString1);
    int i = paramString1.length();
    ((SpannableString)localObject).setSpan(new ForegroundColorSpan(-31676), paramInt, i + paramInt, 33);
    return localObject;
  }
  
  private QQProgressDialog a()
  {
    if (((BaseActivity)this.jdField_b_of_type_AndroidContentContext).getChatFragment().a() != null)
    {
      if (((BaseActivity)this.jdField_b_of_type_AndroidContentContext).getChatFragment().a().a == null) {
        ((BaseActivity)this.jdField_b_of_type_AndroidContentContext).getChatFragment().a().a = new QQProgressDialog(this.jdField_b_of_type_AndroidContentContext);
      }
      return ((BaseActivity)this.jdField_b_of_type_AndroidContentContext).getChatFragment().a().a;
    }
    return null;
  }
  
  private String a()
  {
    try
    {
      i = NetworkUtil.getSystemNetwork(this.jdField_b_of_type_AndroidContentContext);
    }
    catch (Exception localException)
    {
      int i;
      label11:
      break label11;
    }
    i = 0;
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3)
        {
          if (i != 4) {
            return "";
          }
          return "4G";
        }
        return "3G";
      }
      return "2G";
    }
    return "wifi";
  }
  
  private void a(int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemMarketFaceItemBuilder$EmoticonDetailJsonDownloaderVars.a(paramInt, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_AndroidContentContext, jdField_a_of_type_ComTencentMobileqqEmoticonviewIPicEmoticonInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, a());
    this.jdField_a_of_type_ComTencentMobileqqEmoticonApiIEmojiManagerService.getEmojiListenerManager().addEmotionJsonDownloadListener(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemMarketFaceItemBuilder$EmoticonDetailJsonDownloaderVars);
    this.jdField_a_of_type_ComTencentMobileqqEmoticonApiIEmojiManagerService.startDownloadEmosmJson(jdField_a_of_type_ComTencentMobileqqEmoticonviewIPicEmoticonInfo.getEmoticon().epId, EmojiManagerServiceConstant.JSON_EMOSM_MALL);
  }
  
  public static void a(int paramInt1, Context paramContext, QQAppInterface paramQQAppInterface, Emoticon paramEmoticon, int paramInt2, String paramString, SessionInfo paramSessionInfo, boolean paramBoolean)
  {
    if (paramEmoticon == null)
    {
      QLog.d("MarketFaceItemBuilder", 1, "can not find emoticon");
      return;
    }
    if (!a(paramContext))
    {
      if (QLog.isColorLevel()) {
        QLog.d("MarketFaceItemBuilder", 2, "context is not in the top");
      }
      return;
    }
    Handler localHandler = new Handler(Looper.getMainLooper());
    if (paramInt2 == 0)
    {
      paramInt1 %= 1000;
      if (7 == paramInt1) {
        try
        {
          paramQQAppInterface = new Bundle();
          paramQQAppInterface.putInt("forward_type", 9);
          paramQQAppInterface.putBoolean("forward_emotion_from_preview", paramBoolean);
          paramEmoticon = new Intent();
          paramEmoticon.putExtras(paramQQAppInterface);
          ForwardBaseOption.a((BaseActivity)paramContext, paramEmoticon, 21, 100500, "biz_src_jc_gif");
          return;
        }
        catch (Exception paramContext)
        {
          if (QLog.isColorLevel()) {
            QLog.e("EmosmDetailActivity.operateMarketFaceFromDownLoad", 2, paramContext.getMessage());
          }
          return;
        }
      }
      if (6 == paramInt1)
      {
        ThreadManager.post(new MarketFaceItemBuilder.12(paramContext, paramQQAppInterface, paramEmoticon, localHandler), 5, null, true);
        return;
      }
      if (107 == paramInt1)
      {
        ReportController.b(paramQQAppInterface, "CliOper", "", "", "ep_mall", "Ep_follow_send_aio", 0, 0, "", paramEmoticon.epId, "", "");
        ((IPicEmoticonInfoService)QRoute.api(IPicEmoticonInfoService.class)).send(paramQQAppInterface, paramContext, paramSessionInfo, paramEmoticon, null);
      }
    }
    else
    {
      if (paramInt2 < 0)
      {
        localHandler.post(new MarketFaceItemBuilder.13(paramContext, paramString));
        if (6 == paramInt1 % 1000) {
          EmoticonOperateReport.reportEmoticonOperateMonitorAddStatus("2001", 1);
        }
        paramContext = new StringBuilder();
        paramContext.append("opType: ");
        paramContext.append(paramInt1);
        paramContext.append(",result:");
        paramContext.append(paramInt2);
        QLog.i("MarketFaceItemBuilder", 1, paramContext.toString());
        return;
      }
      localHandler.post(new MarketFaceItemBuilder.14(paramInt1, paramContext, paramQQAppInterface, paramEmoticon, paramString));
      if (6 == paramInt1 % 1000) {
        EmoticonOperateReport.reportEmoticonOperateMonitorAddStatus("2002", 1);
      }
    }
  }
  
  public static void a(int paramInt, Context paramContext, QQAppInterface paramQQAppInterface, EmoticonPackage paramEmoticonPackage, IPicEmoticonInfo paramIPicEmoticonInfo, SessionInfo paramSessionInfo, QQProgressDialog paramQQProgressDialog)
  {
    a(paramInt, paramContext, paramQQAppInterface, paramEmoticonPackage, paramIPicEmoticonInfo, paramSessionInfo, paramQQProgressDialog, false);
  }
  
  public static void a(int paramInt, Context paramContext, QQAppInterface paramQQAppInterface, EmoticonPackage paramEmoticonPackage, IPicEmoticonInfo paramIPicEmoticonInfo, SessionInfo paramSessionInfo, QQProgressDialog paramQQProgressDialog, boolean paramBoolean)
  {
    if (paramIPicEmoticonInfo == null) {
      return;
    }
    if ((paramEmoticonPackage != null) && (paramEmoticonPackage.mobileFeetype == 1))
    {
      if ((paramQQProgressDialog != null) && (paramQQProgressDialog.isShowing())) {
        paramQQProgressDialog.dismiss();
      }
      a(paramInt, paramContext, paramQQAppInterface, paramIPicEmoticonInfo.getEmoticon(), 0, null, paramSessionInfo, paramBoolean);
      return;
    }
    if ((NetworkUtil.isNetworkAvailable(paramContext)) && (paramInt <= 1000))
    {
      ((IEmoticonHandler)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.HANDLER_EMOSM)).a(paramInt, Integer.valueOf(paramIPicEmoticonInfo.getEmoticon().epId).intValue(), paramIPicEmoticonInfo.getEmoticon().eId);
      return;
    }
    if ((paramQQProgressDialog != null) && (paramQQProgressDialog.isShowing())) {
      paramQQProgressDialog.dismiss();
    }
    a(paramInt, paramContext, paramQQAppInterface, paramIPicEmoticonInfo.getEmoticon(), -404, HardCodeUtil.a(2131706529), paramSessionInfo, paramBoolean);
  }
  
  private void a(MarketFaceItemBuilder.Holder paramHolder)
  {
    if (!this.jdField_a_of_type_ComTencentMobileqqEmoticonApiIEmojiManagerService.isMagicFacePackageIntact(paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewIPicEmoticonInfo.getEmoticon().epId, Boolean.valueOf(false)))
    {
      this.jdField_a_of_type_ComTencentMobileqqEmoticonApiIEmojiManagerService.getEmojiListenerManager().addEmoticonPackageDownloadListener(this.jdField_a_of_type_ComTencentMobileqqEmoticonEmoticonPackageDownloadListener);
      EmoticonPackage localEmoticonPackage = new EmoticonPackage();
      localEmoticonPackage.name = paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewIPicEmoticonInfo.getEmoticon().name;
      localEmoticonPackage.epId = paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewIPicEmoticonInfo.getEmoticon().epId;
      localEmoticonPackage.jobType = 3;
      localEmoticonPackage.type = 1;
      localEmoticonPackage.isMagicFaceDownloading = true;
      if (paramHolder.jdField_e_of_type_Int == -1) {
        localEmoticonPackage.rscType = PngFrameUtil.a(paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewIPicEmoticonInfo.getEmoticon().magicValue);
      } else {
        localEmoticonPackage.rscType = paramHolder.jdField_e_of_type_Int;
      }
      ((IEmoticonManagerService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IEmoticonManagerService.class)).saveEmoticon(paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewIPicEmoticonInfo.getEmoticon());
      paramHolder.jdField_a_of_type_Boolean = false;
      ((MessageForMarketFace)paramHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage).needToPlay = true;
      this.jdField_a_of_type_JavaUtilList.add(paramHolder);
      paramHolder.f.setVisibility(8);
      paramHolder.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqEmoticonApiIEmojiManagerService.pullEmoticonPackage(localEmoticonPackage, false);
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "MbJieshou", "MbZhudongXiazai", 0, 0, "", "", "", "");
    }
  }
  
  private void a(MarketFaceItemBuilder.Holder paramHolder, int paramInt, MessageForMarketFace paramMessageForMarketFace, ChatMessage paramChatMessage, long paramLong)
  {
    paramHolder.jdField_e_of_type_AndroidWidgetImageView.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
    if (paramMessageForMarketFace.mMarkFaceMessage != null) {
      a(paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewIPicEmoticonInfo, paramInt, paramMessageForMarketFace.mMarkFaceMessage.copywritingContent);
    }
    PicItemBuilder.e();
    long l = paramHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq;
    paramHolder.jdField_a_of_type_Long = paramHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq;
    if (paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewIPicEmoticonInfo == null)
    {
      paramHolder.jdField_e_of_type_AndroidWidgetImageView.setImageResource(2130837970);
    }
    else
    {
      Object localObject = paramHolder.jdField_e_of_type_AndroidWidgetImageView;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(HardCodeUtil.a(2131706531));
      localStringBuilder.append(paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewIPicEmoticonInfo.getEmoticon().name);
      ((ImageView)localObject).setContentDescription(localStringBuilder.toString());
      if (2 == paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewIPicEmoticonInfo.getEmoticon().jobType)
      {
        localObject = (PngFrameManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.PNG_FRAME_DRAWABLE_MANAGER);
        boolean bool = false;
        if (paramHolder.jdField_b_of_type_Int == paramHolder.jdField_c_of_type_Int - 1) {
          bool = ((PngFrameManager)localObject).a(paramHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
        }
        if (paramMessageForMarketFace.mMarkFaceMessage != null)
        {
          if ((paramMessageForMarketFace.mMarkFaceMessage.mobileparam != null) && (paramMessageForMarketFace.mMarkFaceMessage.mobileparam.length > 0))
          {
            paramMessageForMarketFace = new String(paramMessageForMarketFace.mMarkFaceMessage.mobileparam);
            break label271;
          }
          QLog.e("MarketFaceItemBuilder", 1, "getBubble view mMessage.mMarkFaceMessage mobileparam is empty");
        }
        else
        {
          QLog.e("MarketFaceItemBuilder", 1, "getBubble view mMessage.mMarkFaceMessage is null");
        }
        paramMessageForMarketFace = "";
        label271:
        ((PngFrameManager)localObject).a(paramMessageForMarketFace, paramHolder, l, bool, true, new MarketFaceItemBuilder.5(this, paramChatMessage, paramHolder));
        paramHolder.d.setVisibility(8);
        paramHolder.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
        paramHolder.jdField_a_of_type_ComTencentMobileqqDoutuDuiButtonImageView.setVisibility(8);
        paramHolder.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
        paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemBreathAnimationLayout.setVisibility(8);
        paramHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        paramHolder.f.setVisibility(8);
        c(paramHolder);
      }
      else if (4 == paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewIPicEmoticonInfo.getEmoticon().jobType)
      {
        if (!paramChatMessage.isSend()) {
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "MbJieshou", "mbjieshou", 0, 0, paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewIPicEmoticonInfo.getEmoticon().epId, "", "", "");
        }
        a(paramChatMessage, paramHolder);
        b(paramHolder);
      }
      else
      {
        a(paramChatMessage, paramHolder);
      }
      if (((2 == paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewIPicEmoticonInfo.getEmoticon().jobType) || (4 == paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewIPicEmoticonInfo.getEmoticon().jobType)) && (paramHolder.jdField_a_of_type_ComTencentMobileqqDoutuDuiButtonImageView != null))
      {
        paramHolder.jdField_a_of_type_ComTencentMobileqqDoutuDuiButtonImageView.setVisibility(8);
        paramHolder.jdField_a_of_type_ComTencentMobileqqDoutuDuiButtonImageView.e();
      }
      if (this.f) {
        d(paramHolder);
      }
    }
    l = System.currentTimeMillis();
    if ((QLog.isColorLevel()) && (paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewIPicEmoticonInfo != null) && (paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewIPicEmoticonInfo.getEmoticon() != null))
    {
      paramMessageForMarketFace = new StringBuilder();
      paramMessageForMarketFace.append("epId = ");
      paramMessageForMarketFace.append(paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewIPicEmoticonInfo.getEmoticon().epId);
      paramMessageForMarketFace.append(":view time = ");
      paramMessageForMarketFace.append(l - paramLong);
      QLog.d("MarketFaceItemBuilder", 1, paramMessageForMarketFace.toString());
    }
  }
  
  private void a(MarketFaceItemBuilder.Holder paramHolder, long paramLong)
  {
    Animatable localAnimatable = (Animatable)paramHolder.g.getDrawable();
    if (this.jdField_a_of_type_JavaUtilSet.contains(Long.valueOf(paramLong)))
    {
      if (!localAnimatable.isRunning()) {
        localAnimatable.start();
      }
      paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView.setVisibility(4);
      paramHolder.g.setVisibility(0);
      return;
    }
    if (localAnimatable.isRunning()) {
      localAnimatable.stop();
    }
    paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView.setVisibility(0);
    paramHolder.g.setVisibility(4);
  }
  
  private void a(MarketFaceItemBuilder.Holder paramHolder, Rect paramRect)
  {
    AIOEmotionFragment.a(this.jdField_b_of_type_AndroidContentContext, paramHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramRect);
  }
  
  private void a(MarketFaceItemBuilder.Holder paramHolder, URLDrawable paramURLDrawable, BaseChatItemLayout paramBaseChatItemLayout)
  {
    if (paramURLDrawable != null)
    {
      int i = paramURLDrawable.getStatus();
      if (i != 1)
      {
        if (i != 2)
        {
          paramHolder.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
          paramBaseChatItemLayout.setProgressVisable(true);
          return;
        }
        paramHolder.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
        paramBaseChatItemLayout.setProgressVisable(false);
        if (AppSetting.d) {
          paramHolder.jdField_a_of_type_AndroidWidgetFrameLayout.setContentDescription(HardCodeUtil.a(2131706526));
        }
      }
      else
      {
        if (!MagicfaceViewController.a()) {
          paramHolder.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
        }
        if ((!EmoticonPanelUtils.a()) || (2 != paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewIPicEmoticonInfo.getEmoticon().jobType) || (this.jdField_a_of_type_ComTencentMobileqqEmoticonApiIEmojiManagerService.verifyMagicFacePackageIntact(paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewIPicEmoticonInfo.getEmoticon().epId)) || (EmoticonPanelUtils.c()))
        {
          float f1 = this.jdField_a_of_type_ComTencentMobileqqEmoticonApiIEmojiManagerService.getEmoticonPackageLoadingProgress(paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewIPicEmoticonInfo.getEmoticon().epId);
          if ((f1 < 0.0F) || (1.0F == f1))
          {
            paramHolder.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
            paramBaseChatItemLayout.setProgressVisable(false);
          }
        }
      }
    }
  }
  
  private void a(MarketFaceItemBuilder.Holder paramHolder, String paramString)
  {
    if ((paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewIPicEmoticonInfo != null) && (paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewIPicEmoticonInfo.getEmoticon() != null) && (paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewIPicEmoticonInfo.getEmoticon().jobType != 0) && (paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewIPicEmoticonInfo.getEmoticon().jobType != 2) && (paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewIPicEmoticonInfo.getEmoticon().jobType != 4))
    {
      paramHolder.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
      if ("big_sound".equals(paramString))
      {
        if ((paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewIPicEmoticonInfo.getEmoticon() != null) && (paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewIPicEmoticonInfo.getEmoticon().isSound))
        {
          if (c(paramHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage))
          {
            MediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(false);
            return;
          }
          if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isVideoChatting())
          {
            QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), 2131695163, 0).b(this.jdField_b_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299168));
            return;
          }
          MediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(paramHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage);
        }
      }
      else if ("aio_preview".equals(paramString))
      {
        paramString = paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewIPicEmoticonInfo.getLoadingDrawable("fromAIO", true);
        if (paramString != null)
        {
          paramHolder.jdField_e_of_type_AndroidWidgetImageView.setImageDrawable(paramString);
          paramHolder.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
          a(paramHolder, paramString);
          if (paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewIPicEmoticonInfo.isSound()) {
            jdField_c_of_type_Long = paramHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq;
          }
        }
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Emoticon paramEmoticon, IEmoBatchAddedCallback paramIEmoBatchAddedCallback)
  {
    Object localObject = (IFavroamingDBManagerService)paramQQAppInterface.getRuntimeService(IFavroamingDBManagerService.class);
    if (QLog.isColorLevel()) {
      QLog.i("EmoBatchAdded", 2, "Call getEmoticonDataList from addEmotionToFavorite.");
    }
    List localList = ((IFavroamingDBManagerService)localObject).getEmoticonDataList();
    boolean bool = false;
    if (localList != null)
    {
      int i = 0;
      while (i < localList.size())
      {
        CustomEmotionData localCustomEmotionData = (CustomEmotionData)localList.get(i);
        if ((localCustomEmotionData.isMarkFace) && (localCustomEmotionData.emoPath.equals(paramEmoticon.epId)) && (localCustomEmotionData.eId.equals(paramEmoticon.eId)))
        {
          if (((IFavroamingDBManagerService)localObject).updateDeletedEmoticon(localCustomEmotionData, i))
          {
            paramQQAppInterface = paramQQAppInterface.getHandler(ChatActivity.class);
            EmoticonOperateReport.reportEmoticonOperateMonitorAddStatus("0", 1);
            if (paramQQAppInterface != null) {
              paramQQAppInterface.obtainMessage(10).sendToTarget();
            }
            EmoBatchAddedHandlerConstant.a(paramIEmoBatchAddedCallback, 4);
            return;
          }
          EmoBatchAddedHandlerConstant.a(paramIEmoBatchAddedCallback, 2);
          EmoticonOperateReport.reportEmoticonOperateMonitorAddStatus("2003", 1);
          return;
        }
        i += 1;
      }
    }
    localObject = new CustomEmotionData();
    ((CustomEmotionData)localObject).uin = paramQQAppInterface.getCurrentAccountUin();
    ((CustomEmotionData)localObject).emoId = paramIEmoBatchAddedCallback.a();
    ((CustomEmotionData)localObject).isMarkFace = true;
    ((CustomEmotionData)localObject).emoPath = paramEmoticon.epId;
    ((CustomEmotionData)localObject).eId = paramEmoticon.eId;
    ((CustomEmotionData)localObject).checkMarketFace("addEmotionToFavorite");
    paramEmoticon = ((IEmoticonManagerService)paramQQAppInterface.getRuntimeService(IEmoticonManagerService.class)).syncFindEmoticonPackageById(paramEmoticon.epId);
    if (paramEmoticon != null)
    {
      if (paramEmoticon.isAPNG == 2) {
        bool = true;
      }
      ((CustomEmotionData)localObject).isAPNG = bool;
    }
    paramIEmoBatchAddedCallback.a((CustomEmotionData)localObject);
    paramQQAppInterface = (IFavroamingManagerService)paramQQAppInterface.getRuntimeService(IFavroamingManagerService.class);
    if (paramQQAppInterface != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("EmoBatchAdded", 1, "addBatchEmotionToFavorite fm.syncUpload");
      }
      paramQQAppInterface.syncUpload((CustomEmotionData)localObject, paramIEmoBatchAddedCallback);
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, EmoticonPackage paramEmoticonPackage, IPicEmoticonInfo paramIPicEmoticonInfo, IEmoBatchAddedCallback paramIEmoBatchAddedCallback)
  {
    if (paramIPicEmoticonInfo == null) {
      return;
    }
    if ((paramEmoticonPackage != null) && (paramEmoticonPackage.mobileFeetype == 1))
    {
      a(paramQQAppInterface, paramIPicEmoticonInfo.getEmoticon(), paramIEmoBatchAddedCallback);
      return;
    }
    ((IEmoticonHandler)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.HANDLER_EMOSM)).a(6, Integer.valueOf(paramIPicEmoticonInfo.getEmoticon().epId).intValue(), paramIPicEmoticonInfo.getEmoticon().eId);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3, int paramInt)
  {
    ReportController.b(paramQQAppInterface, "CliOper", "", "", paramString2, paramString3, paramInt, 0, "", "", "", "");
  }
  
  private void a(ChatMessage paramChatMessage, MarketFaceItemBuilder.Holder paramHolder)
  {
    a(paramChatMessage, paramHolder, "");
  }
  
  private void a(ChatMessage paramChatMessage, MarketFaceItemBuilder.Holder paramHolder, String paramString)
  {
    boolean bool;
    if ((paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewIPicEmoticonInfo.isSound()) && (!c(paramChatMessage))) {
      bool = false;
    } else {
      bool = true;
    }
    URLDrawable localURLDrawable = paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewIPicEmoticonInfo.getLoadingDrawable("fromAIO", bool);
    Object localObject;
    String str2;
    if ((localURLDrawable != null) && (localURLDrawable.getStatus() == 1))
    {
      String str1;
      if ((localURLDrawable.getStateTag() instanceof Bundle)) {
        str1 = ((Bundle)localURLDrawable.getStateTag()).getString("display_type");
      } else {
        str1 = "";
      }
      localObject = localURLDrawable;
      str2 = str1;
      if (!TextUtils.isEmpty(str1))
      {
        localObject = localURLDrawable;
        str2 = str1;
        if (str1.equals("aio_preview"))
        {
          localObject = paramHolder.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage;
          if ((localObject != null) && (((EmoticonPackage)localObject).status == 2))
          {
            URLDrawable.removeMemoryCacheByUrl(localURLDrawable.getURL().toString());
            localObject = paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewIPicEmoticonInfo.getLoadingDrawable("fromAIO", bool);
            str2 = str1;
          }
          else
          {
            localObject = localURLDrawable;
            str2 = str1;
            if ((paramString.equals("") ^ true))
            {
              URLDrawable.removeMemoryCacheByUrl(localURLDrawable.getURL().toString());
              localObject = paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewIPicEmoticonInfo.getLoadingDrawable("fromAIO", bool, true, paramHolder);
              str2 = str1;
            }
          }
        }
      }
    }
    else
    {
      str2 = "";
      localObject = localURLDrawable;
    }
    b(paramHolder, (URLDrawable)localObject);
    paramHolder.d.setVisibility(8);
    paramHolder.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
    paramHolder.jdField_a_of_type_ComTencentMobileqqDoutuDuiButtonImageView.setVisibility(8);
    c(paramChatMessage, paramHolder);
    b(paramChatMessage, paramHolder);
    if (localObject != null) {
      a(paramHolder, (URLDrawable)localObject, str2);
    }
    c(paramHolder);
  }
  
  private void a(IPicEmoticonInfo paramIPicEmoticonInfo, int paramInt, String paramString)
  {
    String str1 = "";
    if ((paramInt != 1) && (paramInt != 2))
    {
      if (paramInt != 3)
      {
        if (paramInt != 4) {
          return;
        }
        str2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin();
        str3 = a();
        if (paramIPicEmoticonInfo != null) {
          str1 = paramIPicEmoticonInfo.getEmoticon().epId;
        }
        VasWebviewUtil.a(str2, "ep_mall", "yinliu_xiaoweiba_view", "AIO", 1, 0, 1, str3, str1, paramString, "1", "", "", "", 0, 0, 0, 0);
        return;
      }
      paramString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      if (paramIPicEmoticonInfo != null) {
        str1 = paramIPicEmoticonInfo.getEmoticon().epId;
      }
      ReportController.b(paramString, "CliOper", "", "", "ep_mall", "0X8007187", 0, 0, str1, "", "", "");
      return;
    }
    String str2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin();
    String str3 = a();
    if (paramIPicEmoticonInfo != null) {
      str1 = paramIPicEmoticonInfo.getEmoticon().epId;
    }
    VasWebviewUtil.a(str2, "ep_mall", "yinliu_xiaoweiba_view", "AIO", 1, 0, 1, str3, str1, paramString);
  }
  
  public static boolean a(Context paramContext)
  {
    Object localObject = (ActivityManager)paramContext.getSystemService("activity");
    boolean bool2 = true;
    localObject = ((ActivityManager)localObject).getRunningTasks(1);
    boolean bool1 = bool2;
    if (localObject != null)
    {
      bool1 = bool2;
      if (((List)localObject).size() > 0)
      {
        localObject = ((ActivityManager.RunningTaskInfo)((List)localObject).get(0)).topActivity;
        bool1 = bool2;
        if (localObject != null)
        {
          localObject = ((ComponentName)localObject).getClassName();
          bool1 = paramContext.getClass().getName().equals(localObject);
        }
      }
    }
    return bool1;
  }
  
  private static void b(int paramInt, Context paramContext, QQAppInterface paramQQAppInterface, Emoticon paramEmoticon, String paramString1, String paramString2)
  {
    try
    {
      DialogUtil.a(paramContext, 230, paramString1, paramString2, 2131690728, 2131691607, new MarketFaceItemBuilder.17(paramEmoticon, paramContext, paramQQAppInterface, paramInt), new MarketFaceItemBuilder.18()).show();
      return;
    }
    catch (Exception paramContext)
    {
      if (QLog.isColorLevel()) {
        QLog.e("EmosmDetailActivity.showCustomMarketFaceTips", 2, paramContext.getMessage());
      }
    }
  }
  
  private void b(MarketFaceItemBuilder.Holder paramHolder)
  {
    if (4 == paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewIPicEmoticonInfo.getEmoticon().jobType)
    {
      if (((MessageForMarketFace)paramHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage).mMarkFaceMessage == null) {
        return;
      }
      Object localObject;
      if (!this.jdField_a_of_type_ComTencentMobileqqEmoticonApiIEmojiManagerService.isH5MagicIntact(paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewIPicEmoticonInfo.getEmoticon().epId, true, true))
      {
        if (!EmoticonPanelUtils.a())
        {
          if (QLog.isColorLevel())
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("magicFaceIcon gone: H5MagicSource isnot Intact , and network isnot 2 3 4G or wifi;epId = ");
            ((StringBuilder)localObject).append(paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewIPicEmoticonInfo.getEmoticon().epId);
            QLog.d("MarketFaceItemBuilder", 2, ((StringBuilder)localObject).toString());
          }
          paramHolder.f.setVisibility(8);
          return;
        }
        if (-1.0F == this.jdField_a_of_type_ComTencentMobileqqEmoticonApiIEmojiManagerService.getEmoticonPackageLoadingProgress(paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewIPicEmoticonInfo.getEmoticon().epId))
        {
          this.jdField_a_of_type_ComTencentMobileqqEmoticonApiIEmojiManagerService.getEmojiListenerManager().addEmoticonPackageDownloadListener(this.jdField_a_of_type_ComTencentMobileqqEmoticonEmoticonPackageDownloadListener);
          localObject = new EmoticonPackage();
          ((EmoticonPackage)localObject).name = paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewIPicEmoticonInfo.getEmoticon().name;
          ((EmoticonPackage)localObject).epId = paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewIPicEmoticonInfo.getEmoticon().epId;
          ((EmoticonPackage)localObject).jobType = 5;
          ((EmoticonPackage)localObject).type = 1;
          ((EmoticonPackage)localObject).isMagicFaceDownloading = true;
          ((IEmoticonManagerService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IEmoticonManagerService.class)).saveEmoticon(paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewIPicEmoticonInfo.getEmoticon());
          this.jdField_a_of_type_JavaUtilList.add(paramHolder);
          paramHolder.jdField_a_of_type_Boolean = ((MessageForMarketFace)paramHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage).needToPlay;
          paramHolder.f.setVisibility(8);
          paramHolder.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
          ((MessageForMarketFace)paramHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage).needToPlay = false;
          this.jdField_a_of_type_ComTencentMobileqqEmoticonApiIEmojiManagerService.pullEmoticonPackage((EmoticonPackage)localObject, false);
          if (QLog.isColorLevel())
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("magicFaceIcon gone,start download epId = ");
            localStringBuilder.append(paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewIPicEmoticonInfo.getEmoticon().epId);
            QLog.d("MarketFaceItemBuilder", 2, localStringBuilder.toString());
          }
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "MbJieshou", "MbZhudongXiazai", 0, 0, ((EmoticonPackage)localObject).epId, "", "", "");
        }
      }
      else
      {
        if ((this.f) && (this.jdField_a_of_type_ComTencentMobileqqEmoticonApiIEmojiManagerService.isDPCSupportH5Magic()))
        {
          if (!this.jdField_b_of_type_Boolean) {
            paramHolder.f.setVisibility(0);
          }
          if (QLog.isColorLevel())
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("magicFaceIcon visible,h5source intacat epId = ");
            ((StringBuilder)localObject).append(paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewIPicEmoticonInfo.getEmoticon().epId);
            QLog.d("MarketFaceItemBuilder", 2, ((StringBuilder)localObject).toString());
          }
        }
        else
        {
          paramHolder.f.setVisibility(8);
        }
        paramHolder.f.setImageResource(2130837974);
        if ((!((MessageForMarketFace)paramHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage).isSend()) && (((MessageForMarketFace)paramHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage).needToPlay) && (this.jdField_a_of_type_ComTencentMobileqqEmoticonApiIEmojiManagerService.canPlayH5Magic()) && (System.currentTimeMillis() - this.jdField_d_of_type_Long > 3000L) && (((BaseActivity)this.jdField_b_of_type_AndroidContentContext).getChatFragment() != null) && (((BaseActivity)this.jdField_b_of_type_AndroidContentContext).getChatFragment().a() != null) && (!((BaseActivity)this.jdField_b_of_type_AndroidContentContext).getChatFragment().a().g()))
        {
          this.jdField_d_of_type_Long = System.currentTimeMillis();
          ((MessageForMarketFace)paramHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage).needToPlay = false;
          b(paramHolder, "1");
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "MbJieshou", "MbZidongBofang", 0, 0, paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewIPicEmoticonInfo.getEmoticon().epId, "", "", "");
        }
      }
    }
  }
  
  private void b(MarketFaceItemBuilder.Holder paramHolder, URLDrawable paramURLDrawable)
  {
    if ((paramURLDrawable != null) && (paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewIPicEmoticonInfo.getEmoticon() != null))
    {
      int i = paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewIPicEmoticonInfo.getEmoticon().width;
      int m = 200;
      if (i == 0) {
        j = 200;
      } else {
        j = paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewIPicEmoticonInfo.getEmoticon().width;
      }
      if (paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewIPicEmoticonInfo.getEmoticon().height != 0) {
        m = paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewIPicEmoticonInfo.getEmoticon().height;
      }
      int k = j;
      i = m;
      if (paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewIPicEmoticonInfo.getEmoticon().extensionWidth != 0)
      {
        k = j;
        i = m;
        if (paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewIPicEmoticonInfo.getEmoticon().extensionHeight != 0)
        {
          k = paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewIPicEmoticonInfo.getEmoticon().extensionWidth;
          i = paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewIPicEmoticonInfo.getEmoticon().extensionHeight;
        }
      }
      int j = k;
      if (k != i) {
        j = i;
      }
      k = this.jdField_e_of_type_Int;
      int n = this.jdField_d_of_type_Int;
      m = (j * k + (n >> 1)) / n;
      i = (i * k + (n >> 1)) / n;
      paramHolder.jdField_e_of_type_AndroidWidgetImageView.setLayoutParams(new FrameLayout.LayoutParams(m, i));
      Object localObject1 = paramHolder.jdField_a_of_type_AndroidWidgetTextView.getTag();
      if ((localObject1 instanceof Integer)) {
        i = ((Integer)localObject1).intValue();
      } else {
        i = -1;
      }
      if ((paramHolder.jdField_a_of_type_AndroidWidgetTextView.getVisibility() == 0) && (i != -1))
      {
        String str = (String)paramHolder.jdField_a_of_type_AndroidWidgetTextView.getTag(2131364142);
        Object localObject2 = (String)paramHolder.jdField_a_of_type_AndroidWidgetTextView.getTag(2131364141);
        Paint localPaint = new Paint(1);
        localPaint.setTextSize(AIOUtils.b(12.0F, this.jdField_b_of_type_AndroidContentContext.getResources()));
        localPaint.setTextAlign(Paint.Align.LEFT);
        n = (int)localPaint.measureText("...");
        float f1;
        if (!TextUtils.isEmpty(str))
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append(HardCodeUtil.a(2131706527));
          ((StringBuilder)localObject1).append(str);
          f1 = localPaint.measureText(((StringBuilder)localObject1).toString());
        }
        else
        {
          f1 = localPaint.measureText(HardCodeUtil.a(2131706523));
        }
        int i1 = (int)f1;
        j = ((String)localObject2).length();
        k = (int)localPaint.measureText((String)localObject2) + i1;
        localObject1 = "";
        while ((k > m) && (j > 0))
        {
          j -= 1;
          localObject1 = ((String)localObject2).substring(0, j);
          k = (int)localPaint.measureText((String)localObject1) + n + i1;
        }
        if (!((String)localObject1).equals(""))
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append((String)localObject1);
          ((StringBuilder)localObject2).append("...");
          localObject1 = a(i, ((StringBuilder)localObject2).toString(), str);
          paramHolder.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject1);
        }
      }
    }
    paramHolder.jdField_e_of_type_AndroidWidgetImageView.setImageDrawable(paramURLDrawable);
    a(paramHolder, paramURLDrawable, paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout);
  }
  
  private void b(MarketFaceItemBuilder.Holder paramHolder, URLDrawable paramURLDrawable, String paramString)
  {
    String str;
    if ((paramURLDrawable.getStateTag() instanceof Bundle)) {
      str = ((Bundle)paramURLDrawable.getStateTag()).getString("display_type");
    } else {
      str = "";
    }
    paramURLDrawable.restartDownload();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("msgOnclickListener| URLDrawable restartDownload status=");
      localStringBuilder.append(paramURLDrawable.getStatus());
      QLog.d("MarketFaceItemBuilder", 2, localStringBuilder.toString());
    }
    a(paramHolder, paramURLDrawable, str);
    paramHolder.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
    if ((paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewIPicEmoticonInfo != null) && (paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewIPicEmoticonInfo.isSound()) && ("big_sound".equals(paramString))) {
      jdField_c_of_type_Long = paramHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq;
    }
  }
  
  private void b(MarketFaceItemBuilder.Holder paramHolder, String paramString)
  {
    ThreadManager.post(new MarketFaceItemBuilder.6(this, paramString, paramHolder), 5, null, true);
  }
  
  private void b(ChatMessage paramChatMessage, MarketFaceItemBuilder.Holder paramHolder)
  {
    if ((paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewIPicEmoticonInfo.isSound()) && (paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewIPicEmoticonInfo.isNewSoundType()) && ((paramChatMessage instanceof MessageForMarketFace)))
    {
      if (paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewIPicEmoticonInfo.getWaveformArray() != null)
      {
        paramChatMessage = (RelativeLayout.LayoutParams)paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.getLayoutParams();
        paramChatMessage.width = AIOUtils.b(39.0F, this.jdField_b_of_type_AndroidContentContext.getResources());
        paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.setAudioData(paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewIPicEmoticonInfo.getWaveformArray(), paramChatMessage.width, paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewIPicEmoticonInfo.getVoiceLength());
        if (Build.VERSION.SDK_INT < 19)
        {
          paramChatMessage = (RelativeLayout.LayoutParams)paramHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
          RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemBreathAnimationLayout.getLayoutParams();
          paramChatMessage.width = AIOUtils.b(92.0F, this.jdField_b_of_type_AndroidContentContext.getResources());
          localLayoutParams.width = AIOUtils.b(92.0F, this.jdField_b_of_type_AndroidContentContext.getResources());
        }
      }
      int i = paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewIPicEmoticonInfo.getWaveBackgroundColor();
      int j = paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewIPicEmoticonInfo.getWaveForegroundColor();
      paramChatMessage = new RoundedColorDrawable(i, 1, 1, AIOUtils.b(22.0F, this.jdField_b_of_type_AndroidContentContext.getResources()));
      paramHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundDrawable(paramChatMessage);
      paramHolder.jdField_a_of_type_ComTencentMobileqqActivityContactConnectionsTriangleView.setDrawColor(i);
      paramHolder.jdField_a_of_type_ComTencentMobileqqActivityContactConnectionsTriangleView.postInvalidate();
      paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.setProgressColor(j);
      paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView.setThemeColor(j);
    }
  }
  
  private void c(MarketFaceItemBuilder.Holder paramHolder)
  {
    paramHolder.jdField_a_of_type_Boolean = false;
    if ((2 == paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewIPicEmoticonInfo.getEmoticon().jobType) && (((MessageForMarketFace)paramHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage).mMarkFaceMessage != null))
    {
      if (!MagicfaceViewController.a()) {
        return;
      }
      Object localObject1;
      if (!this.jdField_a_of_type_ComTencentMobileqqEmoticonApiIEmojiManagerService.verifyMagicFacePackageIntact(paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewIPicEmoticonInfo.getEmoticon().epId))
      {
        if (!EmoticonPanelUtils.a())
        {
          paramHolder.f.setVisibility(8);
          return;
        }
        if (EmoticonPanelUtils.c()) {
          return;
        }
        if ((!this.jdField_a_of_type_ComTencentMobileqqEmoticonApiIEmojiManagerService.isMagicFacePackageIntact(paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewIPicEmoticonInfo.getEmoticon().epId, Boolean.valueOf(false))) && (-1.0F == this.jdField_a_of_type_ComTencentMobileqqEmoticonApiIEmojiManagerService.getEmoticonPackageLoadingProgress(paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewIPicEmoticonInfo.getEmoticon().epId)))
        {
          this.jdField_a_of_type_ComTencentMobileqqEmoticonApiIEmojiManagerService.getEmojiListenerManager().addEmoticonPackageDownloadListener(this.jdField_a_of_type_ComTencentMobileqqEmoticonEmoticonPackageDownloadListener);
          localObject1 = new EmoticonPackage();
          ((EmoticonPackage)localObject1).name = paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewIPicEmoticonInfo.getEmoticon().name;
          ((EmoticonPackage)localObject1).epId = paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewIPicEmoticonInfo.getEmoticon().epId;
          ((EmoticonPackage)localObject1).jobType = 3;
          ((EmoticonPackage)localObject1).rscType = PngFrameUtil.a(paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewIPicEmoticonInfo.getEmoticon().magicValue);
          ((EmoticonPackage)localObject1).type = 1;
          ((EmoticonPackage)localObject1).isMagicFaceDownloading = true;
          ((IEmoticonManagerService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IEmoticonManagerService.class)).saveEmoticon(paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewIPicEmoticonInfo.getEmoticon());
          this.jdField_a_of_type_JavaUtilList.add(paramHolder);
          paramHolder.jdField_a_of_type_Boolean = ((MessageForMarketFace)paramHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage).needToPlay;
          paramHolder.f.setVisibility(8);
          paramHolder.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
          ((MessageForMarketFace)paramHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage).needToPlay = false;
          this.jdField_a_of_type_ComTencentMobileqqEmoticonApiIEmojiManagerService.pullEmoticonPackage((EmoticonPackage)localObject1, false);
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "MbJieshou", "MbZidongXiazai", 0, 0, paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewIPicEmoticonInfo.getEmoticon().epId, "", "", "");
        }
      }
      else
      {
        if (PngFrameUtil.a(paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewIPicEmoticonInfo.getEmoticon().magicValue) == 1)
        {
          paramHolder.f.setVisibility(8);
        }
        else if (!this.jdField_b_of_type_Boolean)
        {
          paramHolder.f.setImageResource(2130837974);
          paramHolder.f.setVisibility(0);
        }
        if (((MessageForMarketFace)paramHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage).needToPlay)
        {
          ((MessageForMarketFace)paramHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage).needToPlay = false;
          localObject1 = new Emoticon();
          ((Emoticon)localObject1).eId = paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewIPicEmoticonInfo.getEmoticon().eId;
          ((Emoticon)localObject1).epId = paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewIPicEmoticonInfo.getEmoticon().epId;
          ((Emoticon)localObject1).magicValue = paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewIPicEmoticonInfo.getEmoticon().magicValue;
          ((Emoticon)localObject1).jobType = paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewIPicEmoticonInfo.getEmoticon().jobType;
          Object localObject2 = ((BaseActivity)this.jdField_b_of_type_AndroidContentContext).getChatFragment();
          if (localObject2 != null)
          {
            localObject2 = ((ChatFragment)localObject2).a();
            if ((localObject2 != null) && (MagicfaceViewController.a()))
            {
              localObject2 = (AIOEmoticonUIHelper)((BaseChatPie)localObject2).a(105);
              if (localObject2 != null) {
                ((AIOEmoticonUIHelper)localObject2).a((Emoticon)localObject1, 1, ((MessageForMarketFace)paramHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage).senderuin, false);
              }
            }
          }
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "MbJieshou", "MbZidongBofang", 0, 0, paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewIPicEmoticonInfo.getEmoticon().epId, "", "", "");
        }
      }
    }
  }
  
  private void c(ChatMessage paramChatMessage, MarketFaceItemBuilder.Holder paramHolder)
  {
    if ((paramChatMessage.isFlowMessage) && (a(paramHolder)) && (paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewIPicEmoticonInfo.getEmoticon().jobType == 0))
    {
      if (!(this.jdField_b_of_type_AndroidContentContext instanceof MultiForwardActivity))
      {
        if (paramChatMessage.isSend())
        {
          paramHolder.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130847347);
          paramHolder.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
          return;
        }
        paramHolder.d.setImageResource(2130847347);
        paramHolder.d.setVisibility(0);
      }
    }
    else if ((paramChatMessage.isDui) && (DuiButtonImageView.jdField_a_of_type_Boolean) && (!((IHotChatUtil)QRoute.api(IHotChatUtil.class)).isHotChatMsg(paramChatMessage)))
    {
      paramHolder.jdField_a_of_type_ComTencentMobileqqDoutuDuiButtonImageView.jdField_a_of_type_ComTencentMobileqqDoutuDoutuMsgItem = DoutuMsgUtil.a(paramChatMessage);
      if ((!paramChatMessage.isSend()) && ((!a(paramHolder)) || (!paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewIPicEmoticonInfo.isSound())))
      {
        if ((a(paramHolder)) && (paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewIPicEmoticonInfo.getEmoticon() != null) && ((2 == paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewIPicEmoticonInfo.getEmoticon().jobType) || (4 == paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewIPicEmoticonInfo.getEmoticon().jobType)))
        {
          paramHolder.jdField_a_of_type_ComTencentMobileqqDoutuDuiButtonImageView.setVisibility(8);
          paramHolder.jdField_a_of_type_ComTencentMobileqqDoutuDuiButtonImageView.e();
          return;
        }
        if (!paramChatMessage.hasPlayedDui) {
          paramChatMessage.hasPlayedDui = DuiButtonImageView.a(paramHolder.jdField_a_of_type_ComTencentMobileqqDoutuDuiButtonImageView);
        } else if (paramHolder.jdField_a_of_type_ComTencentMobileqqDoutuDuiButtonImageView.b()) {
          DoutuConfigReporter.a(paramChatMessage);
        }
        if (DuiButtonImageView.jdField_a_of_type_Boolean)
        {
          paramHolder.jdField_a_of_type_ComTencentMobileqqDoutuDuiButtonImageView.setOnClickListener(this);
          paramHolder.jdField_a_of_type_ComTencentMobileqqDoutuDuiButtonImageView.setVisibility(0);
          return;
        }
        paramHolder.jdField_a_of_type_ComTencentMobileqqDoutuDuiButtonImageView.setOnClickListener(null);
        paramHolder.jdField_a_of_type_ComTencentMobileqqDoutuDuiButtonImageView.setVisibility(8);
        return;
      }
      paramHolder.jdField_a_of_type_ComTencentMobileqqDoutuDuiButtonImageView.setVisibility(8);
      paramHolder.jdField_a_of_type_ComTencentMobileqqDoutuDuiButtonImageView.e();
    }
  }
  
  private boolean c(ChatMessage paramChatMessage)
  {
    boolean bool2 = false;
    if (paramChatMessage == null) {
      return false;
    }
    ChatMessage localChatMessage = MediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a();
    boolean bool1;
    if (localChatMessage != paramChatMessage)
    {
      bool1 = bool2;
      if ((localChatMessage instanceof MessageForMarketFace))
      {
        bool1 = bool2;
        if (localChatMessage.frienduin != null)
        {
          bool1 = bool2;
          if (localChatMessage.frienduin.equals(paramChatMessage.frienduin))
          {
            bool1 = bool2;
            if (localChatMessage.uniseq != paramChatMessage.uniseq) {}
          }
        }
      }
    }
    else
    {
      bool1 = true;
    }
    return bool1;
  }
  
  private void d(MarketFaceItemBuilder.Holder paramHolder)
  {
    if ((paramHolder != null) && (paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewIPicEmoticonInfo != null) && (paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewIPicEmoticonInfo.isNewSoundType()) && (paramHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage != null) && (!this.jdField_c_of_type_JavaUtilSet.contains(Long.valueOf(paramHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq))))
    {
      EmoticonOperateReport.reportNewSoundEvent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "0X800AB51", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewIPicEmoticonInfo.getEmoticon().epId);
      this.jdField_c_of_type_JavaUtilSet.add(Long.valueOf(paramHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq));
    }
  }
  
  private void f(View paramView)
  {
    paramView = (MarketFaceItemBuilder.Holder)AIOUtils.a(paramView);
    Object localObject;
    if ((paramView.jdField_a_of_type_ComTencentMobileqqEmoticonviewIPicEmoticonInfo != null) && (paramView.jdField_a_of_type_ComTencentMobileqqEmoticonviewIPicEmoticonInfo.getEmoticon() != null) && (2 == paramView.jdField_a_of_type_ComTencentMobileqqEmoticonviewIPicEmoticonInfo.getEmoticon().jobType))
    {
      if (!this.jdField_a_of_type_ComTencentMobileqqEmoticonApiIEmojiManagerService.isMagicFacePackageIntact(paramView.jdField_a_of_type_ComTencentMobileqqEmoticonviewIPicEmoticonInfo.getEmoticon().epId, Boolean.valueOf(false)))
      {
        this.jdField_a_of_type_ComTencentMobileqqEmoticonApiIEmojiManagerService.getEmojiListenerManager().addEmoticonPackageDownloadListener(this.jdField_a_of_type_ComTencentMobileqqEmoticonEmoticonPackageDownloadListener);
        localObject = new EmoticonPackage();
        ((EmoticonPackage)localObject).name = paramView.jdField_a_of_type_ComTencentMobileqqEmoticonviewIPicEmoticonInfo.getEmoticon().name;
        ((EmoticonPackage)localObject).epId = paramView.jdField_a_of_type_ComTencentMobileqqEmoticonviewIPicEmoticonInfo.getEmoticon().epId;
        ((EmoticonPackage)localObject).jobType = 3;
        ((EmoticonPackage)localObject).type = 1;
        ((EmoticonPackage)localObject).isMagicFaceDownloading = true;
        paramView.jdField_a_of_type_Boolean = false;
        ((MessageForMarketFace)paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage).needToPlay = false;
        ((IEmoticonManagerService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IEmoticonManagerService.class)).saveEmoticon(paramView.jdField_a_of_type_ComTencentMobileqqEmoticonviewIPicEmoticonInfo.getEmoticon());
        this.jdField_a_of_type_JavaUtilList.add(paramView);
        paramView.f.setVisibility(8);
        paramView.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
        this.jdField_a_of_type_ComTencentMobileqqEmoticonApiIEmojiManagerService.pullEmoticonPackage((EmoticonPackage)localObject, false);
      }
      else
      {
        localObject = ((BaseActivity)this.jdField_b_of_type_AndroidContentContext).getChatFragment();
        if (localObject != null)
        {
          localObject = ((ChatFragment)localObject).a();
          if ((localObject != null) && (MagicfaceViewController.a()))
          {
            localObject = (AIOEmoticonUIHelper)((BaseChatPie)localObject).a(105);
            if (localObject != null) {
              ((AIOEmoticonUIHelper)localObject).a(paramView.jdField_a_of_type_ComTencentMobileqqEmoticonviewIPicEmoticonInfo.getEmoticon(), 1, paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage.senderuin, true);
            }
          }
        }
      }
      ReportController.b(null, "CliOper", "", "", "MbJieshou", "MbZhudongBofang", 0, 0, paramView.jdField_a_of_type_ComTencentMobileqqEmoticonviewIPicEmoticonInfo.getEmoticon().epId, "", "", "");
    }
    if ((paramView.jdField_a_of_type_ComTencentMobileqqEmoticonviewIPicEmoticonInfo != null) && (paramView.jdField_a_of_type_ComTencentMobileqqEmoticonviewIPicEmoticonInfo.getEmoticon() != null) && (4 == paramView.jdField_a_of_type_ComTencentMobileqqEmoticonviewIPicEmoticonInfo.getEmoticon().jobType) && (System.currentTimeMillis() - this.jdField_d_of_type_Long > 3000L) && (this.jdField_a_of_type_ComTencentMobileqqEmoticonApiIEmojiManagerService.canPlayH5Magic()))
    {
      this.jdField_d_of_type_Long = System.currentTimeMillis();
      if (this.jdField_a_of_type_ComTencentMobileqqEmoticonApiIEmojiManagerService.isH5MagicIntact(paramView.jdField_a_of_type_ComTencentMobileqqEmoticonviewIPicEmoticonInfo.getEmoticon().epId, true, true))
      {
        b(paramView, "0");
      }
      else
      {
        this.jdField_a_of_type_ComTencentMobileqqEmoticonApiIEmojiManagerService.getEmojiListenerManager().addEmoticonPackageDownloadListener(this.jdField_a_of_type_ComTencentMobileqqEmoticonEmoticonPackageDownloadListener);
        localObject = new EmoticonPackage();
        ((EmoticonPackage)localObject).name = paramView.jdField_a_of_type_ComTencentMobileqqEmoticonviewIPicEmoticonInfo.getEmoticon().name;
        ((EmoticonPackage)localObject).epId = paramView.jdField_a_of_type_ComTencentMobileqqEmoticonviewIPicEmoticonInfo.getEmoticon().epId;
        ((EmoticonPackage)localObject).jobType = 5;
        ((EmoticonPackage)localObject).type = 1;
        ((EmoticonPackage)localObject).isMagicFaceDownloading = true;
        paramView.jdField_a_of_type_Boolean = false;
        ((MessageForMarketFace)paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage).needToPlay = false;
        ((IEmoticonManagerService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IEmoticonManagerService.class)).saveEmoticon(paramView.jdField_a_of_type_ComTencentMobileqqEmoticonviewIPicEmoticonInfo.getEmoticon());
        this.jdField_a_of_type_JavaUtilList.add(paramView);
        paramView.f.setVisibility(8);
        paramView.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
        this.jdField_a_of_type_ComTencentMobileqqEmoticonApiIEmojiManagerService.pullEmoticonPackage((EmoticonPackage)localObject, false);
      }
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "MbFasong", "MbZhudongBofang", 0, 0, paramView.jdField_a_of_type_ComTencentMobileqqEmoticonviewIPicEmoticonInfo.getEmoticon().epId, "", "", "");
    }
  }
  
  private void g(View paramView)
  {
    MarketFaceItemBuilder.Holder localHolder = (MarketFaceItemBuilder.Holder)AIOUtils.a(paramView);
    if ((localHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewIPicEmoticonInfo != null) && (localHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewIPicEmoticonInfo.isSound()) && (localHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewIPicEmoticonInfo.isNewSoundType()))
    {
      boolean bool = c(localHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage);
      paramView = "";
      int i;
      if (bool)
      {
        MediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(false);
        localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        i = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int;
        if (localHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewIPicEmoticonInfo.getEmoticon() != null) {
          paramView = localHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewIPicEmoticonInfo.getEmoticon().epId;
        }
        EmoticonOperateReport.reportNewSoundEvent((AppInterface)localObject, "0X800A934", i, paramView);
        return;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isVideoChatting())
      {
        QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), 2131695163, 0).b(this.jdField_b_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299168));
        return;
      }
      if ((localHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage instanceof MessageForMarketFace)) {
        ((MessageForMarketFace)localHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage).playProgress = 0.0F;
      }
      localHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.setProgress(0.0F);
      if (MediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(localHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage))
      {
        localHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView.setPlayState(true);
        QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        i = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int;
        if (localHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewIPicEmoticonInfo.getEmoticon() != null) {
          localObject = localHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewIPicEmoticonInfo.getEmoticon().epId;
        } else {
          localObject = "";
        }
        EmoticonOperateReport.reportNewSoundEvent(localQQAppInterface, "0X800A933", i, (String)localObject);
        bool = true;
      }
      else
      {
        bool = false;
      }
      if (!bool)
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        if (localHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewIPicEmoticonInfo.getEmoticon() != null) {
          paramView = localHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewIPicEmoticonInfo.getEmoticon().epId;
        }
        EmoticonOperateReport.reportNewSoundEvent((AppInterface)localObject, "0X800A935", -1, paramView);
      }
      Object localObject = new HashMap();
      if (bool) {
        paramView = "0";
      } else {
        paramView = "1";
      }
      ((HashMap)localObject).put("playResult", paramView);
      ((HashMap)localObject).put("playType", "1");
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(BaseApplicationImpl.getApplication().getRuntime().getAccount(), "NewAudioEmoticonVoicePlay", bool, 0L, 0L, (HashMap)localObject, null);
    }
  }
  
  private void h(View paramView)
  {
    MarketFaceItemBuilder.Holder localHolder = (MarketFaceItemBuilder.Holder)AIOUtils.a(paramView);
    Object localObject = localHolder.jdField_e_of_type_AndroidWidgetImageView.getDrawable();
    if ((localObject instanceof URLDrawable))
    {
      URLDrawable localURLDrawable = (URLDrawable)localObject;
      localObject = localURLDrawable.getURL().getHost();
      if ((localURLDrawable.getTag() instanceof Bundle)) {
        localObject = ((Bundle)localURLDrawable.getTag()).getString("display_type");
      }
      int i = localURLDrawable.getStatus();
      if (i != 1)
      {
        if (i == 2) {
          b(localHolder, localURLDrawable, (String)localObject);
        }
      }
      else {
        a(localHolder, (String)localObject);
      }
      if ((localHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewIPicEmoticonInfo != null) && (localHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewIPicEmoticonInfo.getEmoticon() != null) && (localHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewIPicEmoticonInfo.getEmoticon().jobType == 2) && (MagicfaceViewController.a())) {
        a(localHolder);
      }
      if ((localURLDrawable.getStatus() == 1) || ((localHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewIPicEmoticonInfo != null) && (localHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewIPicEmoticonInfo.getEmoticon() != null) && (localHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewIPicEmoticonInfo.isAioPreviewExists()))) {
        a(localHolder, AnimationUtils.a(paramView));
      }
    }
    else if (((localObject instanceof PngFrameDrawable)) && (localHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewIPicEmoticonInfo != null) && (localHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewIPicEmoticonInfo.getEmoticon() != null) && (localHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewIPicEmoticonInfo.isAioPreviewExists()))
    {
      a(localHolder, AnimationUtils.a(paramView));
    }
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    return 0;
  }
  
  protected View a(ChatMessage paramChatMessage, BaseBubbleBuilder.ViewHolder paramViewHolder, View paramView, BaseChatItemLayout paramBaseChatItemLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    long l = System.currentTimeMillis();
    paramBaseChatItemLayout = (MessageForMarketFace)paramChatMessage;
    MarketFaceItemBuilder.Holder localHolder = (MarketFaceItemBuilder.Holder)paramViewHolder;
    this.jdField_b_of_type_JavaUtilSet.add(localHolder);
    if (paramView == null)
    {
      paramViewHolder = new RelativeLayout(this.jdField_b_of_type_AndroidContentContext);
      Object localObject2 = new RelativeLayout(this.jdField_b_of_type_AndroidContentContext);
      RelativeLayout.LayoutParams localLayoutParams1 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout)localObject2).setId(2131370689);
      paramView = new ImageView(this.jdField_b_of_type_AndroidContentContext);
      paramView.setId(2131367027);
      Object localObject1 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject1).addRule(0, 2131364521);
      ((RelativeLayout.LayoutParams)localObject1).addRule(15, 2131364521);
      ((RelativeLayout)localObject2).addView(paramView, (ViewGroup.LayoutParams)localObject1);
      paramView.setOnClickListener(this);
      localObject1 = new FrameLayout(this.jdField_b_of_type_AndroidContentContext);
      ((FrameLayout)localObject1).setId(2131363531);
      Object localObject3 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject3).leftMargin = 8;
      ((RelativeLayout.LayoutParams)localObject3).addRule(1, 2131367027);
      ((RelativeLayout)localObject2).addView((View)localObject1, (ViewGroup.LayoutParams)localObject3);
      ((FrameLayout)localObject1).setOnClickListener(this);
      ((FrameLayout)localObject1).setOnTouchListener(paramOnLongClickAndTouchListener);
      ((FrameLayout)localObject1).setOnLongClickListener(paramOnLongClickAndTouchListener);
      paramOnLongClickAndTouchListener = new MarketFaceItemBuilder.MarketFaceView(this, this.jdField_b_of_type_AndroidContentContext);
      ((FrameLayout)localObject1).addView(paramOnLongClickAndTouchListener, -2, -2);
      localObject3 = new ImageView(this.jdField_b_of_type_AndroidContentContext);
      Object localObject4 = new FrameLayout.LayoutParams(-2, -2);
      ((FrameLayout.LayoutParams)localObject4).gravity = 85;
      ((FrameLayout)localObject1).addView((View)localObject3, (ViewGroup.LayoutParams)localObject4);
      localObject4 = new ImageView(this.jdField_b_of_type_AndroidContentContext);
      ((ImageView)localObject4).setId(2131380979);
      Object localObject5 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject5).addRule(1, 2131363531);
      ((RelativeLayout.LayoutParams)localObject5).addRule(8, 2131363531);
      ((RelativeLayout.LayoutParams)localObject5).leftMargin = 10;
      ((RelativeLayout)localObject2).addView((View)localObject4, (ViewGroup.LayoutParams)localObject5);
      ((ImageView)localObject4).setOnClickListener(this);
      localObject5 = new BreathAnimationLayout(this.jdField_b_of_type_AndroidContentContext);
      ((BreathAnimationLayout)localObject5).setId(2131371824);
      PttAudioPlayView localPttAudioPlayView = new PttAudioPlayView(this.jdField_b_of_type_AndroidContentContext, 10);
      localPttAudioPlayView.setThemeColor(this.jdField_b_of_type_AndroidContentContext.getResources().getColorStateList(2131167075).getDefaultColor());
      localPttAudioPlayView.setId(2131371826);
      localPttAudioPlayView.setPttPauseOrStopDrawable(2130838159);
      Object localObject6 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject6).addRule(15, -1);
      ((RelativeLayout.LayoutParams)localObject6).leftMargin = AIOUtils.b(5.0F, this.jdField_b_of_type_AndroidContentContext.getResources());
      ((RelativeLayout.LayoutParams)localObject6).width = AIOUtils.b(25.0F, this.jdField_b_of_type_AndroidContentContext.getResources());
      ((RelativeLayout.LayoutParams)localObject6).height = AIOUtils.b(25.0F, this.jdField_b_of_type_AndroidContentContext.getResources());
      localPttAudioPlayView.setLayoutParams((ViewGroup.LayoutParams)localObject6);
      localPttAudioPlayView.setOnClickListener(this);
      localObject6 = new ImageView(this.jdField_b_of_type_AndroidContentContext);
      Object localObject7 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject7).addRule(15, -1);
      ((RelativeLayout.LayoutParams)localObject7).leftMargin = AIOUtils.b(5.0F, this.jdField_b_of_type_AndroidContentContext.getResources());
      ((RelativeLayout.LayoutParams)localObject7).width = AIOUtils.b(20.0F, this.jdField_b_of_type_AndroidContentContext.getResources());
      ((RelativeLayout.LayoutParams)localObject7).height = AIOUtils.b(20.0F, this.jdField_b_of_type_AndroidContentContext.getResources());
      ((ImageView)localObject6).setLayoutParams((ViewGroup.LayoutParams)localObject7);
      ((ImageView)localObject6).setImageDrawable((Drawable)this.jdField_b_of_type_AndroidContentContext.getResources().getDrawable(2130839399));
      ((ImageView)localObject6).setVisibility(4);
      localObject7 = new PttAudioWaveView(this.jdField_b_of_type_AndroidContentContext);
      ((PttAudioWaveView)localObject7).setShowProgressLine(false);
      ((PttAudioWaveView)localObject7).setMaxTopBottomPadding(4);
      ((PttAudioWaveView)localObject7).setProgressColor(this.jdField_b_of_type_AndroidContentContext.getResources().getColorStateList(2131167075).getDefaultColor());
      ((PttAudioWaveView)localObject7).setId(2131371827);
      Object localObject8 = new RelativeLayout.LayoutParams(-1, -1);
      ((RelativeLayout.LayoutParams)localObject8).addRule(15, -1);
      ((RelativeLayout.LayoutParams)localObject8).addRule(1, 2131371826);
      ((RelativeLayout.LayoutParams)localObject8).width = AIOUtils.b(39.0F, this.jdField_b_of_type_AndroidContentContext.getResources());
      ((RelativeLayout.LayoutParams)localObject8).height = AIOUtils.b(45.0F, this.jdField_b_of_type_AndroidContentContext.getResources());
      ((RelativeLayout.LayoutParams)localObject8).leftMargin = ViewUtils.a(9.0F);
      ((RelativeLayout.LayoutParams)localObject8).rightMargin = ViewUtils.a(12.0F);
      ((PttAudioWaveView)localObject7).setLayoutParams((ViewGroup.LayoutParams)localObject8);
      ((PttAudioWaveView)localObject7).setCanSupportSlide(false);
      ((PttAudioWaveView)localObject7).setOnClickListener(this);
      localObject8 = new SyncParentPressedRelativeLayout(this.jdField_b_of_type_AndroidContentContext);
      ((RelativeLayout)localObject8).setId(2131371825);
      ((RelativeLayout)localObject8).addView((View)localObject7);
      ((RelativeLayout)localObject8).addView(localPttAudioPlayView);
      ((RelativeLayout)localObject8).addView((View)localObject6);
      RelativeLayout localRelativeLayout = new RelativeLayout(this.jdField_b_of_type_AndroidContentContext);
      TriangleView localTriangleView = new TriangleView(this.jdField_b_of_type_AndroidContentContext);
      Object localObject9 = new RelativeLayout.LayoutParams(ViewUtils.a(9.0F), ViewUtils.a(5.0F));
      ((RelativeLayout.LayoutParams)localObject9).leftMargin = ViewUtils.a(2.0F);
      ((RelativeLayout.LayoutParams)localObject9).addRule(14);
      ((RelativeLayout.LayoutParams)localObject9).addRule(10);
      localTriangleView.setId(2131372860);
      localTriangleView.setRotation(180.0F);
      localTriangleView.setTranslationY(ViewUtils.a(1.0F));
      localTriangleView.setLayoutParams((ViewGroup.LayoutParams)localObject9);
      localRelativeLayout.addView(localTriangleView);
      localObject9 = new RelativeLayout.LayoutParams(-2, ViewUtils.a(29.0F));
      ((RelativeLayout.LayoutParams)localObject9).addRule(3, 2131372860);
      localRelativeLayout.addView((View)localObject8, (ViewGroup.LayoutParams)localObject9);
      ((BreathAnimationLayout)localObject5).addView(localRelativeLayout);
      localObject9 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject9).addRule(14, 2131363531);
      ((RelativeLayout.LayoutParams)localObject9).addRule(3, 2131363531);
      ((RelativeLayout.LayoutParams)localObject9).bottomMargin = ViewUtils.a(17.0F);
      ((RelativeLayout)localObject2).addView((View)localObject5, (ViewGroup.LayoutParams)localObject9);
      localObject9 = new ImageView(this.jdField_b_of_type_AndroidContentContext);
      ((ImageView)localObject9).setId(2131367028);
      Object localObject10 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject10).addRule(1, 2131363531);
      ((RelativeLayout.LayoutParams)localObject10).addRule(15, 2131363531);
      ((RelativeLayout.LayoutParams)localObject10).leftMargin = 10;
      ((RelativeLayout)localObject2).addView((View)localObject9, (ViewGroup.LayoutParams)localObject10);
      ((ImageView)localObject9).setOnClickListener(this);
      localObject10 = new DuiButtonImageView(this.jdField_b_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, DoutuMsgUtil.a(paramChatMessage));
      ((DuiButtonImageView)localObject10).setId(2131365992);
      Object localObject11 = new RelativeLayout.LayoutParams(AIOUtils.b(50.0F, this.jdField_b_of_type_AndroidContentContext.getResources()), AIOUtils.b(50.0F, this.jdField_b_of_type_AndroidContentContext.getResources()));
      ((RelativeLayout.LayoutParams)localObject11).addRule(1, 2131363531);
      ((RelativeLayout.LayoutParams)localObject11).addRule(8, 2131363531);
      ((RelativeLayout.LayoutParams)localObject11).setMargins(0, 0, 0, -AIOUtils.b(6.5F, this.jdField_b_of_type_AndroidContentContext.getResources()));
      ((RelativeLayout)localObject2).addView((View)localObject10, (ViewGroup.LayoutParams)localObject11);
      localObject11 = new ImageView(this.jdField_b_of_type_AndroidContentContext);
      ((ImageView)localObject11).setId(2131370602);
      Object localObject12 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject12).addRule(1, 2131363531);
      ((RelativeLayout.LayoutParams)localObject12).addRule(8, 2131363531);
      ((RelativeLayout.LayoutParams)localObject12).leftMargin = AIOUtils.b(10.0F, this.jdField_b_of_type_AndroidContentContext.getResources());
      ((RelativeLayout)localObject2).addView((View)localObject11, (ViewGroup.LayoutParams)localObject12);
      localObject12 = new TextView(this.jdField_b_of_type_AndroidContentContext);
      RelativeLayout.LayoutParams localLayoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
      ((TextView)localObject12).setTextSize(12.0F);
      ((TextView)localObject12).setTextColor(-1);
      localLayoutParams2.topMargin = AIOUtils.b(8.0F, this.jdField_b_of_type_AndroidContentContext.getResources());
      ((TextView)localObject12).setGravity(17);
      localLayoutParams2.addRule(3, 2131370689);
      try
      {
        ((TextView)localObject12).setBackgroundDrawable(this.jdField_b_of_type_AndroidContentContext.getResources().getDrawable(2130844764));
      }
      catch (Exception localException2)
      {
        QLog.e("MarketFaceItemBuilder", 1, "getBubbleView: ", localException2);
      }
      ((TextView)localObject12).setPadding(AIOUtils.b(9.0F, this.jdField_b_of_type_AndroidContentContext.getResources()), AIOUtils.b(4.0F, this.jdField_b_of_type_AndroidContentContext.getResources()), AIOUtils.b(9.0F, this.jdField_b_of_type_AndroidContentContext.getResources()), AIOUtils.b(4.0F, this.jdField_b_of_type_AndroidContentContext.getResources()));
      paramViewHolder.addView((View)localObject2, localLayoutParams1);
      paramViewHolder.addView((View)localObject12, localLayoutParams2);
      ((ImageView)localObject11).setOnClickListener(this);
      localObject2 = new ProgressBar(this.jdField_b_of_type_AndroidContentContext, null, 0);
      ((ProgressBar)localObject2).setId(2131364548);
      try
      {
        ((ProgressBar)localObject2).setIndeterminateDrawable(this.jdField_b_of_type_AndroidContentContext.getResources().getDrawable(2130839401));
      }
      catch (Exception localException1)
      {
        QLog.e("MarketFaceItemBuilder", 1, "getBubbleView: ", localException1);
      }
      int i = AIOUtils.b(16.0F, this.jdField_b_of_type_AndroidContentContext.getResources());
      FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(i, i);
      localLayoutParams.gravity = 17;
      ((FrameLayout)localObject1).addView((View)localObject2, localLayoutParams);
      localHolder.jdField_e_of_type_AndroidWidgetImageView = paramOnLongClickAndTouchListener;
      localHolder.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localObject3);
      localHolder.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)localObject4);
      localHolder.jdField_c_of_type_AndroidWidgetImageView = paramView;
      localHolder.d = ((ImageView)localObject9);
      localHolder.jdField_a_of_type_ComTencentMobileqqDoutuDuiButtonImageView = ((DuiButtonImageView)localObject10);
      localHolder.f = ((ImageView)localObject11);
      localHolder.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)localObject1);
      localHolder.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)localObject2);
      localHolder.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localObject12);
      localHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemBreathAnimationLayout = ((BreathAnimationLayout)localObject5);
      localHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView = localPttAudioPlayView;
      localHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView = ((PttAudioWaveView)localObject7);
      localHolder.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localObject8);
      localHolder.jdField_b_of_type_AndroidWidgetRelativeLayout = localRelativeLayout;
      localHolder.jdField_a_of_type_ComTencentMobileqqActivityContactConnectionsTriangleView = localTriangleView;
      localHolder.g = ((ImageView)localObject6);
    }
    else
    {
      if ((localHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewIPicEmoticonInfo != null) && (localHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewIPicEmoticonInfo.isSound()) && (localHolder.jdField_b_of_type_AndroidWidgetImageView != null) && ((localHolder.jdField_b_of_type_AndroidWidgetImageView.getDrawable() instanceof AnimationDrawable))) {
        localHolder.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130847365);
      }
      if (AppSetting.d) {
        localHolder.jdField_a_of_type_AndroidWidgetFrameLayout.setContentDescription("");
      }
      paramViewHolder = paramView;
    }
    paramView = paramBaseChatItemLayout;
    if (!c(paramChatMessage)) {
      paramView.playProgress = 0.0F;
    }
    a(localHolder, paramChatMessage.uniseq);
    localHolder.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    localHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.setProgress(paramView.playProgress);
    if ((AppSetting.d) && (a(paramChatMessage, localHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout)) && (localHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.jdField_a_of_type_AndroidWidgetImageView != null)) {
      localHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(HardCodeUtil.a(2131706528));
    }
    new QueryTask(new MarketFaceItemBuilder.3(this, localHolder), new MarketFaceItemBuilder.4(this, localHolder, paramView, paramChatMessage, l)).execute(paramView.mMarkFaceMessage);
    return paramViewHolder;
  }
  
  protected BaseBubbleBuilder.ViewHolder a()
  {
    return new MarketFaceItemBuilder.Holder();
  }
  
  protected String a(ChatMessage paramChatMessage)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if ((paramChatMessage != null) && ((paramChatMessage instanceof MessageForMarketFace)))
    {
      if (MessageRecordInfo.a(paramChatMessage.issend)) {
        localStringBuilder.append("发出表情");
      } else {
        localStringBuilder.append("发来表情");
      }
      paramChatMessage = (MessageForMarketFace)paramChatMessage;
      if (paramChatMessage.mMarkFaceMessage != null)
      {
        paramChatMessage = (IPicEmoticonInfo)((IEmoticonManagerService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IEmoticonManagerService.class)).syncGetEmoticonInfo(paramChatMessage.mMarkFaceMessage);
        if (paramChatMessage != null)
        {
          paramChatMessage = paramChatMessage.getEmoticon();
          if ((paramChatMessage != null) && (paramChatMessage.name != null)) {
            localStringBuilder.append(paramChatMessage.name);
          }
        }
      }
    }
    return localStringBuilder.toString();
  }
  
  public void a()
  {
    Object localObject = ((IEmojiManagerService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IEmojiManagerService.class)).getEmojiListenerManager();
    ((IEmojiListenerManager)localObject).removeEmoticonPackageDownloadListener(this.jdField_a_of_type_ComTencentMobileqqEmoticonEmoticonPackageDownloadListener);
    ((IEmojiListenerManager)localObject).removeEmotionJsonDownloadListener(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemMarketFaceItemBuilder$EmoticonDetailJsonDownloaderVars);
    localObject = this.jdField_b_of_type_JavaUtilSet.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((MarketFaceItemBuilder.Holder)((Iterator)localObject).next()).a();
    }
    this.jdField_b_of_type_JavaUtilSet.clear();
    this.jdField_a_of_type_JavaUtilSet.clear();
    this.jdField_b_of_type_JavaUtilSet = null;
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    IPicEmoticonInfo localIPicEmoticonInfo = jdField_a_of_type_ComTencentMobileqqEmoticonviewIPicEmoticonInfo;
    if ((localIPicEmoticonInfo != null) && (localIPicEmoticonInfo.getEmoticon() != null))
    {
      if ((paramInt != 2131365480) && (paramInt != 2131362241) && (paramInt != 2131367197) && (paramInt != 2131366973) && (paramInt != 2131371561))
      {
        super.a(paramInt, paramContext, paramChatMessage);
        return;
      }
      a(paramInt, paramChatMessage);
      return;
    }
    QLog.e("MarketFaceItemBuilder", 1, "onMenuItemClicked emoticon is null");
  }
  
  protected void a(int paramInt, ChatMessage paramChatMessage)
  {
    ((IEmoticonManagerService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IEmoticonManagerService.class)).asyncFindEmoticonPackage(jdField_a_of_type_ComTencentMobileqqEmoticonviewIPicEmoticonInfo.getEmoticon().epId, new MarketFaceItemBuilder.2(this, paramInt, paramChatMessage));
  }
  
  protected void a(View paramView)
  {
    paramView = (MarketFaceItemBuilder.Holder)AIOUtils.a(paramView);
    if (paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage.isSendFromLocal())
    {
      String str1 = this.jdField_b_of_type_AndroidContentContext.getString(2131689933);
      String str2 = this.jdField_b_of_type_AndroidContentContext.getString(2131689934);
      if ((paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage.sendFailCode == 41) && (paramView.jdField_a_of_type_ComTencentMobileqqEmoticonviewIPicEmoticonInfo != null) && (paramView.jdField_a_of_type_ComTencentMobileqqEmoticonviewIPicEmoticonInfo.getEmoticon() != null))
      {
        a((MessageForMarketFace)paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage, paramView.jdField_a_of_type_ComTencentMobileqqEmoticonviewIPicEmoticonInfo);
        return;
      }
      DialogUtil.a(this.jdField_b_of_type_AndroidContentContext, 230, str1, str2, new MarketFaceItemBuilder.9(this, paramView), new MarketFaceItemBuilder.10(this)).show();
      return;
    }
    paramView = paramView.jdField_e_of_type_AndroidWidgetImageView.getDrawable();
    if ((paramView instanceof URLDrawable)) {
      ((URLDrawable)paramView).restartDownload();
    }
  }
  
  protected void a(View paramView, ChatMessage paramChatMessage)
  {
    paramView.setPadding(0, 0, ScreenUtil.dip2px(10.0F), 0);
  }
  
  void a(MarketFaceItemBuilder.Holder paramHolder, URLDrawable paramURLDrawable)
  {
    a(paramHolder, paramURLDrawable, "");
  }
  
  void a(MarketFaceItemBuilder.Holder paramHolder, URLDrawable paramURLDrawable, String paramString)
  {
    paramHolder.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
    paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemBreathAnimationLayout.setVisibility(8);
    paramHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    paramHolder.f.setVisibility(8);
    paramHolder.jdField_b_of_type_Boolean = false;
    int i = paramURLDrawable.getStatus();
    if (paramURLDrawable.getHeader("2g_use_gif") != null) {
      i = 1;
    }
    String str = paramString;
    if (TextUtils.isEmpty(paramString))
    {
      str = paramString;
      if ((paramURLDrawable.getStateTag() instanceof Bundle)) {
        str = ((Bundle)paramURLDrawable.getStateTag()).getString("display_type");
      }
    }
    if ("aio_preview".equals(str))
    {
      if (paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewIPicEmoticonInfo.isSound())
      {
        if (paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewIPicEmoticonInfo.isNewSoundType())
        {
          paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemBreathAnimationLayout.setVisibility(0);
          return;
        }
        paramHolder.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130847365);
        paramHolder.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
        return;
      }
      if ((i == 1) && (paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewIPicEmoticonInfo.getImageType() == 3))
      {
        paramHolder.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130837971);
        paramHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        paramHolder.jdField_b_of_type_Boolean = true;
      }
    }
    else if ("big_sound".equals(str))
    {
      if (c(paramHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage))
      {
        if (paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewIPicEmoticonInfo.isNewSoundType())
        {
          paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemBreathAnimationLayout.setVisibility(0);
          paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView.setPlayState(true);
          return;
        }
        paramHolder.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
        paramURLDrawable = (AnimationDrawable)this.jdField_b_of_type_AndroidContentContext.getResources().getDrawable(2130772308);
        paramHolder.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(paramURLDrawable);
        paramURLDrawable.start();
        return;
      }
      if (paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewIPicEmoticonInfo.isNewSoundType())
      {
        paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemBreathAnimationLayout.setVisibility(0);
        paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView.setPlayState(false);
        return;
      }
      paramHolder.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130847365);
      paramHolder.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
    }
  }
  
  protected void a(EmoticonPackage paramEmoticonPackage, String paramString, int paramInt)
  {
    QQProgressDialog localQQProgressDialog = a();
    if (localQQProgressDialog != null)
    {
      localQQProgressDialog.a(this.jdField_b_of_type_AndroidContentContext.getString(2131691927));
      localQQProgressDialog.show();
    }
    a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin, "ep_mall", "Clk_collect", 0);
    Object localObject = jdField_a_of_type_ComTencentMobileqqEmoticonviewIPicEmoticonInfo;
    if ((localObject != null) && (((IPicEmoticonInfo)localObject).getEmoticon() != null)) {
      EmoticonOperateReport.reportFavAddEmotionEvent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, null, jdField_a_of_type_ComTencentMobileqqEmoticonviewIPicEmoticonInfo.getEmoticon().eId);
    }
    QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramInt);
    localObject = "";
    localStringBuilder.append("");
    ReportController.b(localQQAppInterface, "CliOper", "", "", "0X8006448", "0X8006448", 0, 0, "4", paramString, localStringBuilder.toString(), "");
    paramString = jdField_a_of_type_ComTencentMobileqqEmoticonviewIPicEmoticonInfo;
    if ((paramString != null) && (paramString.isNewSoundType()))
    {
      localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      paramInt = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int;
      paramString = (String)localObject;
      if (jdField_a_of_type_ComTencentMobileqqEmoticonviewIPicEmoticonInfo.getEmoticon() != null) {
        paramString = jdField_a_of_type_ComTencentMobileqqEmoticonviewIPicEmoticonInfo.getEmoticon().epId;
      }
      EmoticonOperateReport.reportNewSoundEvent(localQQAppInterface, "0X800A939", paramInt, paramString);
    }
    if ((paramEmoticonPackage != null) && (paramEmoticonPackage.name != null) && ((paramEmoticonPackage.mobileFeetype != 0) || (paramEmoticonPackage.downloadCount != 0)))
    {
      paramInt = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().getInt("emosm_json_last_download_timestamp", 0);
      int i = (int)(System.currentTimeMillis() / 1000L);
      if ((i - paramInt <= 86400) && (i >= paramInt))
      {
        a(6, this.jdField_b_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramEmoticonPackage, jdField_a_of_type_ComTencentMobileqqEmoticonviewIPicEmoticonInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, localQQProgressDialog);
        return;
      }
      a(6);
      return;
    }
    a(6);
  }
  
  protected void a(EmoticonPackage paramEmoticonPackage, String paramString, int paramInt1, int paramInt2)
  {
    QQProgressDialog localQQProgressDialog = a();
    if (paramInt2 == 2131367197)
    {
      QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramInt1);
      localStringBuilder.append("");
      ReportController.b(localQQAppInterface, "CliOper", "", "", "ep_mall", "aio_trans_bq", 0, 0, "4", paramString, localStringBuilder.toString(), "");
      if ((2 == jdField_a_of_type_ComTencentMobileqqEmoticonviewIPicEmoticonInfo.getEmoticon().jobType) && (!this.jdField_a_of_type_ComTencentMobileqqEmoticonApiIEmojiManagerService.getMagicFaceSendAccessControl()))
      {
        ChatActivityUtils.a(this.jdField_b_of_type_AndroidContentContext, 2131689932, 0);
        return;
      }
      jdField_a_of_type_Int = 1;
      a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin, "ep_mall", "Clk_button_forward_aio", 0);
      paramInt1 = 7;
      paramString = this.jdField_b_of_type_AndroidContentContext.getString(2131691930);
    }
    else
    {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006449", "0X8006449", 0, 0, "4", "", "", "");
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1) && (((TroopGagMgr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_GAG_MANAGER)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, true).jdField_a_of_type_Boolean))
      {
        ChatActivityUtils.a(this.jdField_b_of_type_AndroidContentContext, 2131697407, 0);
        return;
      }
      paramInt1 = 107;
      paramString = this.jdField_b_of_type_AndroidContentContext.getString(2131691929);
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "ep_mall", "Clk_button_follow_aio", 0, 0, "", jdField_a_of_type_ComTencentMobileqqEmoticonviewIPicEmoticonInfo.getEmoticon().epId, "", "");
    }
    if (localQQProgressDialog != null)
    {
      localQQProgressDialog.a(paramString);
      localQQProgressDialog.show();
    }
    if (paramEmoticonPackage == null)
    {
      a(paramInt1);
      return;
    }
    a(paramInt1, this.jdField_b_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramEmoticonPackage, jdField_a_of_type_ComTencentMobileqqEmoticonviewIPicEmoticonInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, localQQProgressDialog);
  }
  
  protected void a(MessageForMarketFace paramMessageForMarketFace, IPicEmoticonInfo paramIPicEmoticonInfo)
  {
    if ((paramMessageForMarketFace != null) && (paramIPicEmoticonInfo != null) && (paramIPicEmoticonInfo.getEmoticon() != null))
    {
      if (paramIPicEmoticonInfo.getEmoticon().epId == null) {
        return;
      }
      ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(this.jdField_b_of_type_AndroidContentContext, null);
      localActionSheet.setMainTitle(this.jdField_b_of_type_AndroidContentContext.getString(2131691925));
      localActionSheet.addButton(this.jdField_b_of_type_AndroidContentContext.getResources().getString(2131691924), 1);
      localActionSheet.addButton(this.jdField_b_of_type_AndroidContentContext.getResources().getString(2131691926), 1);
      localActionSheet.addCancelButton(2131690728);
      localActionSheet.setOnButtonClickListener(new MarketFaceItemBuilder.11(this, paramIPicEmoticonInfo, localActionSheet, paramMessageForMarketFace));
      localActionSheet.show();
    }
  }
  
  protected void a(QQCustomMenu paramQQCustomMenu)
  {
    if (jdField_a_of_type_ComTencentMobileqqDataChatMessage != null)
    {
      if (jdField_a_of_type_ComTencentMobileqqEmoticonviewIPicEmoticonInfo.getEmoticon() == null) {
        return;
      }
      int i;
      if (jdField_a_of_type_ComTencentMobileqqEmoticonviewIPicEmoticonInfo.getEmoticon().jobType == 0) {
        i = 1;
      } else {
        i = 0;
      }
      if ((i != 0) && (EmoticonPanelUtils.d(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int)))
      {
        AIORelatedEmotionConfProcessor.RelatedEmotionConfigBean localRelatedEmotionConfigBean = AIORelatedEmotionConfProcessor.a();
        if ((localRelatedEmotionConfigBean != null) && (localRelatedEmotionConfigBean.a()))
        {
          paramQQCustomMenu.a(2131371561, this.jdField_b_of_type_AndroidContentContext.getString(2131718180), 2130838920);
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "0X800B114", "0X800B114", EmoticonPanelUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int), 0, "", "", "", "");
        }
      }
    }
  }
  
  public void a(XListView paramXListView, int paramInt, View paramView, ChatMessage paramChatMessage, long paramLong, float paramFloat)
  {
    if ((paramView != null) && (paramFloat > 0.0F))
    {
      paramXListView = (MarketFaceItemBuilder.Holder)AIOUtils.a(paramView);
      if ((paramXListView != null) && (paramXListView.jdField_a_of_type_ComTencentMobileqqEmoticonviewIPicEmoticonInfo != null) && (paramXListView.jdField_a_of_type_ComTencentMobileqqEmoticonviewIPicEmoticonInfo.isSound()) && (paramXListView.jdField_a_of_type_ComTencentMobileqqEmoticonviewIPicEmoticonInfo.isNewSoundType()) && (c(paramChatMessage)))
      {
        paramView = new StringBuilder();
        paramView.append("AudioPlayer onPlayProgress progress_ratio = ");
        paramView.append(paramFloat);
        QLog.i("MarketFaceItemBuilder", 2, paramView.toString());
        paramXListView.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.setProgress(paramFloat);
        if ((paramChatMessage instanceof MessageForMarketFace)) {
          ((MessageForMarketFace)paramChatMessage).playProgress = paramFloat;
        }
      }
    }
  }
  
  public void a(XListView paramXListView, int paramInt, View paramView, ChatMessage paramChatMessage, boolean paramBoolean)
  {
    if (paramView != null)
    {
      paramXListView = (MarketFaceItemBuilder.Holder)AIOUtils.a(paramView);
      if (paramXListView.jdField_a_of_type_ComTencentMobileqqEmoticonviewIPicEmoticonInfo.isNewSoundType())
      {
        paramXListView.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.setProgress(0.0F);
        if (paramXListView.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView != null) {
          paramXListView.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView.setPlayState(false);
        }
      }
      else
      {
        paramXListView.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130847365);
      }
      paramView = paramXListView.jdField_a_of_type_ComTencentMobileqqEmoticonviewIPicEmoticonInfo.getLoadingDrawable("fromAIO", false);
      paramXListView.jdField_e_of_type_AndroidWidgetImageView.setImageDrawable(paramView);
    }
  }
  
  public boolean a(BaseBubbleBuilder.ViewHolder paramViewHolder)
  {
    return paramViewHolder instanceof MarketFaceItemBuilder.Holder;
  }
  
  public boolean a(MarketFaceItemBuilder.Holder paramHolder)
  {
    return paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewIPicEmoticonInfo != null;
  }
  
  public boolean a(XListView paramXListView, int paramInt, View paramView, ChatMessage paramChatMessage)
  {
    return false;
  }
  
  public boolean a(XListView paramXListView, int paramInt1, View paramView, ChatMessage paramChatMessage, AudioPlayerBase paramAudioPlayerBase, int paramInt2)
  {
    paramXListView = (MarketFaceItemBuilder.Holder)AIOUtils.a(paramView);
    if ((paramXListView != null) && (paramXListView.jdField_a_of_type_ComTencentMobileqqEmoticonviewIPicEmoticonInfo != null))
    {
      if (paramXListView.jdField_a_of_type_ComTencentMobileqqEmoticonviewIPicEmoticonInfo.getEmoticon() == null) {
        return false;
      }
      if (paramXListView.jdField_a_of_type_ComTencentMobileqqEmoticonviewIPicEmoticonInfo.isSound())
      {
        paramView = EmotionPanelConstans.emoticonSoundPath.replace("[epId]", paramXListView.jdField_a_of_type_ComTencentMobileqqEmoticonviewIPicEmoticonInfo.getEmoticon().epId).replace("[eId]", paramXListView.jdField_a_of_type_ComTencentMobileqqEmoticonviewIPicEmoticonInfo.getEmoticon().eId);
        if (!FileUtils.fileExistsAndNotEmpty(paramView))
        {
          if (this.jdField_a_of_type_JavaUtilSet.contains(Long.valueOf(paramChatMessage.uniseq))) {
            return false;
          }
          this.jdField_a_of_type_JavaUtilSet.add(Long.valueOf(paramChatMessage.uniseq));
          a(paramXListView, paramChatMessage.uniseq);
          ThreadManager.getFileThreadHandler().post(new MarketFaceItemBuilder.8(this, paramXListView, paramChatMessage));
          return false;
        }
        paramAudioPlayerBase.a(4);
        if (paramAudioPlayerBase.a(paramView))
        {
          paramView = paramXListView.jdField_a_of_type_ComTencentMobileqqEmoticonviewIPicEmoticonInfo.getLoadingDrawable("fromAIO", true);
          paramXListView.jdField_e_of_type_AndroidWidgetImageView.setImageDrawable(paramView);
          ((IPicEmoticonInfoService)QRoute.api(IPicEmoticonInfoService.class)).startSoundDrawablePlay(paramView);
          if (paramXListView.jdField_a_of_type_ComTencentMobileqqEmoticonviewIPicEmoticonInfo.isNewSoundType())
          {
            if (paramXListView.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView != null)
            {
              paramXListView.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView.setPlayState(true);
              return true;
            }
          }
          else
          {
            paramView = (AnimationDrawable)this.jdField_b_of_type_AndroidContentContext.getResources().getDrawable(2130772308);
            paramXListView.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(paramView);
            paramView.start();
          }
          return true;
        }
      }
    }
    return false;
  }
  
  public QQCustomMenuItem[] a(View paramView)
  {
    paramView = (MarketFaceItemBuilder.Holder)AIOUtils.a(paramView);
    QQCustomMenu localQQCustomMenu = new QQCustomMenu();
    jdField_a_of_type_ComTencentMobileqqDataChatMessage = paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
    Object localObject = jdField_a_of_type_ComTencentMobileqqDataChatMessage;
    if ((localObject instanceof MessageForMarketFace))
    {
      localObject = (MessageForMarketFace)localObject;
      if ((((MessageForMarketFace)localObject).mMarkFaceMessage != null) && (((MessageForMarketFace)localObject).mMarkFaceMessage.stickerInfo != null))
      {
        i = 1;
        break label69;
      }
    }
    int i = 0;
    label69:
    if (i == 0)
    {
      if (paramView.jdField_a_of_type_ComTencentMobileqqEmoticonviewIPicEmoticonInfo.getEmoticon().jobType != 1)
      {
        jdField_a_of_type_ComTencentMobileqqEmoticonviewIPicEmoticonInfo = paramView.jdField_a_of_type_ComTencentMobileqqEmoticonviewIPicEmoticonInfo;
        if (AIOUtils.a(1) == 1) {
          localQQCustomMenu.a(2131362241, this.jdField_b_of_type_AndroidContentContext.getString(2131693248), 2130838910);
        }
        a(localQQCustomMenu);
        localQQCustomMenu.a(2131367197, this.jdField_b_of_type_AndroidContentContext.getString(2131692644), 2130838912);
        a(localQQCustomMenu, this.jdField_b_of_type_AndroidContentContext, 2131376417, jdField_a_of_type_ComTencentMobileqqDataChatMessage, null);
        if ((paramView.jdField_a_of_type_ComTencentMobileqqEmoticonviewIPicEmoticonInfo.getEmoticon().jobType != 2) && (paramView.jdField_a_of_type_ComTencentMobileqqEmoticonviewIPicEmoticonInfo.getEmoticon().jobType != 4)) {
          localQQCustomMenu.a(2131366973, this.jdField_b_of_type_AndroidContentContext.getString(2131693255), 2130838862);
        }
        a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin, "ep_mall", "Ap_show_forward", 0);
      }
      if ((paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage.extraflag != 32768) && (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgCache().b(paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage))) {
        a(localQQCustomMenu, this.jdField_b_of_type_AndroidContentContext, 2131371562, paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage, new Bundle());
      }
      a(localQQCustomMenu, this.jdField_b_of_type_AndroidContentContext, 2131365480, paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage, new Bundle());
      localObject = new Bundle();
      ((Bundle)localObject).putBoolean("isSearch", false);
      super.a(localQQCustomMenu, this.jdField_b_of_type_AndroidContentContext, 2131380215, jdField_a_of_type_ComTencentMobileqqDataChatMessage, (Bundle)localObject);
      if (paramView.jdField_a_of_type_ComTencentMobileqqEmoticonviewIPicEmoticonInfo.getEmoticon().jobType != 1) {
        a(localQQCustomMenu, this.jdField_b_of_type_AndroidContentContext, 2131376430, jdField_a_of_type_ComTencentMobileqqDataChatMessage, null);
      }
      super.a(localQQCustomMenu, this.jdField_b_of_type_AndroidContentContext, 2131371603, null, null);
      super.a(localQQCustomMenu, this.jdField_b_of_type_AndroidContentContext, 2131362480, null, null);
    }
    else
    {
      jdField_a_of_type_ComTencentMobileqqEmoticonviewIPicEmoticonInfo = paramView.jdField_a_of_type_ComTencentMobileqqEmoticonviewIPicEmoticonInfo;
      ChatActivityFacade.a(localQQCustomMenu, this.jdField_b_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
    }
    return localQQCustomMenu.a();
  }
  
  protected void b(ChatMessage paramChatMessage)
  {
    Object localObject = ((BaseActivity)this.jdField_b_of_type_AndroidContentContext).getChatFragment();
    if (localObject != null)
    {
      localObject = ((ChatFragment)localObject).a();
      if (localObject != null)
      {
        ((AIORelatedEmotionHelper)((BaseChatPie)localObject).a(72)).a(paramChatMessage, jdField_a_of_type_ComTencentMobileqqEmoticonviewIPicEmoticonInfo.getLoadingDrawable("fromAIO", false));
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("MarketFaceItemBuilder", 2, "[Related_Emotion] curPie is null.");
      }
    }
    else if (QLog.isColorLevel())
    {
      QLog.d("MarketFaceItemBuilder", 2, "[Related_Emotion] chatFragment is null.");
    }
  }
  
  public boolean b(ChatMessage paramChatMessage)
  {
    return true;
  }
  
  public void c(View paramView)
  {
    AIOUtils.o = true;
    if (super.a()) {
      return;
    }
    if (paramView.getId() == 2131363531)
    {
      h(paramView);
      return;
    }
    if (paramView.getId() == 2131380979) {
      e(paramView);
    } else if ((paramView.getId() != 2131371826) && (paramView.getId() != 2131371827))
    {
      if ((paramView.getId() != 2131367028) && (paramView.getId() != 2131367027))
      {
        if (paramView.getId() == 2131365992) {
          e();
        } else if (paramView.getId() == 2131370602) {
          f(paramView);
        }
      }
      else {
        d(paramView);
      }
    }
    else {
      g(paramView);
    }
    super.onClick(paramView);
  }
  
  protected void d(View paramView)
  {
    paramView = (MarketFaceItemBuilder.Holder)AIOUtils.a(paramView);
    QQProgressDialog localQQProgressDialog = a();
    if (localQQProgressDialog != null)
    {
      localQQProgressDialog.a(this.jdField_b_of_type_AndroidContentContext.getString(2131691929));
      localQQProgressDialog.show();
    }
    ((IEmoticonManagerService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IEmoticonManagerService.class)).asyncFindEmoticonPackage(paramView.jdField_a_of_type_ComTencentMobileqqEmoticonviewIPicEmoticonInfo.getEmoticon().epId, new MarketFaceItemBuilder.1(this, paramView, localQQProgressDialog));
  }
  
  protected void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MarketFaceItemBuilder", 2, "[Doutu] Dui Button Clicked.");
    }
    Object localObject = ((BaseActivity)this.jdField_b_of_type_AndroidContentContext).getChatFragment();
    if (localObject != null)
    {
      localObject = ((ChatFragment)localObject).a();
      if (localObject != null)
      {
        ((BaseChatPie)localObject).a().obtainMessage(79, null).sendToTarget();
        DoutuConfigReporter.b();
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("MarketFaceItemBuilder", 2, "[Doutu] curPie is null.");
      }
    }
    else if (QLog.isColorLevel())
    {
      QLog.d("MarketFaceItemBuilder", 2, "[Doutu] chatFragment is null.");
    }
  }
  
  protected void e(View paramView)
  {
    paramView = (MarketFaceItemBuilder.Holder)AIOUtils.a(paramView);
    if ((paramView.jdField_a_of_type_ComTencentMobileqqEmoticonviewIPicEmoticonInfo != null) && (paramView.jdField_a_of_type_ComTencentMobileqqEmoticonviewIPicEmoticonInfo.isSound()))
    {
      if (c(paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage))
      {
        MediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(false);
        return;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isVideoChatting())
      {
        QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), 2131695163, 0).b(this.jdField_b_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299168));
        return;
      }
      MediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage);
    }
  }
  
  public void onClick(View paramView)
  {
    c(paramView);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.MarketFaceItemBuilder
 * JD-Core Version:    0.7.0.1
 */