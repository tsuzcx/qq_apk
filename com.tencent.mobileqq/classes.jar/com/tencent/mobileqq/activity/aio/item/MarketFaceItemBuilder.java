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
import android.support.v4.app.FragmentActivity;
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
import com.tencent.mobileqq.apollo.utils.ApolloGameUtil;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.EmoticonHandler;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.config.business.AIORelatedEmotionConfProcessor;
import com.tencent.mobileqq.config.business.AIORelatedEmotionConfProcessor.RelatedEmotionConfigBean;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.CustomEmotionData;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.data.MarkFaceMessage;
import com.tencent.mobileqq.data.MessageForMarketFace;
import com.tencent.mobileqq.doutu.DoutuConfigReporter;
import com.tencent.mobileqq.doutu.DuiButtonImageView;
import com.tencent.mobileqq.emosm.AIOEmoticonUIHelper;
import com.tencent.mobileqq.emosm.favroaming.EmoAddedAuthCallback;
import com.tencent.mobileqq.emosm.favroaming.EmoBatchAddedCallback;
import com.tencent.mobileqq.emosm.favroaming.EmoBatchAddedHandler;
import com.tencent.mobileqq.emosm.favroaming.FavEmoConstant;
import com.tencent.mobileqq.emosm.favroaming.FavroamingDBManager;
import com.tencent.mobileqq.emosm.favroaming.FavroamingManager;
import com.tencent.mobileqq.emoticon.EmojiListenerManager;
import com.tencent.mobileqq.emoticon.EmojiManager;
import com.tencent.mobileqq.emoticon.EmoticonPackageDownloadListener;
import com.tencent.mobileqq.emoticonview.EmoticonUtils;
import com.tencent.mobileqq.emoticonview.EmotionUtils;
import com.tencent.mobileqq.emoticonview.PicEmoticonInfo;
import com.tencent.mobileqq.emotionintegrate.AIOEmotionFragment;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.magicface.drawable.PngFrameDrawable;
import com.tencent.mobileqq.magicface.drawable.PngFrameManager;
import com.tencent.mobileqq.magicface.drawable.PngFrameUtil;
import com.tencent.mobileqq.magicface.view.MagicfaceViewController;
import com.tencent.mobileqq.model.EmoticonManager;
import com.tencent.mobileqq.model.QueryTask;
import com.tencent.mobileqq.nearby.HotChatUtil;
import com.tencent.mobileqq.qqaudio.audioplayer.AudioPlayerBase;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.service.message.remote.MessageRecordInfo;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.structmsg.RoundedColorDrawable;
import com.tencent.mobileqq.troop.data.SelfGagInfo;
import com.tencent.mobileqq.troop.utils.TroopGagMgr;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenuItem;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
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
  public static ChatMessage a;
  public static PicEmoticonInfo a;
  public static int c;
  static long jdField_c_of_type_Long = 0L;
  MarketFaceItemBuilder.EmoticonDetailJsonDownloaderVars jdField_a_of_type_ComTencentMobileqqActivityAioItemMarketFaceItemBuilder$EmoticonDetailJsonDownloaderVars = new MarketFaceItemBuilder.EmoticonDetailJsonDownloaderVars();
  EmojiManager jdField_a_of_type_ComTencentMobileqqEmoticonEmojiManager;
  EmoticonPackageDownloadListener jdField_a_of_type_ComTencentMobileqqEmoticonEmoticonPackageDownloadListener = new MarketFaceItemBuilder.7(this);
  public List<MarketFaceItemBuilder.Holder> a;
  Set<Long> jdField_a_of_type_JavaUtilSet = new HashSet();
  public Context b;
  Set<MarketFaceItemBuilder.Holder> b;
  Set<Long> jdField_c_of_type_JavaUtilSet = new ArraySet();
  public int d;
  private long d;
  public int e;
  boolean f = false;
  
  static
  {
    jdField_c_of_type_Int = 1;
  }
  
  public MarketFaceItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    this.jdField_b_of_type_JavaUtilSet = new HashSet();
    this.jdField_d_of_type_Int = 320;
    this.jdField_e_of_type_Int = BaseApplication.getContext().getResources().getDisplayMetrics().densityDpi;
    this.jdField_b_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiManager = ((EmojiManager)paramQQAppInterface.getManager(QQManagerFactory.CHAT_EMOTION_MANAGER));
    if ((this.jdField_b_of_type_AndroidContentContext instanceof SplashActivity)) {
      this.f = true;
    }
  }
  
  public static int a(Context paramContext, QQAppInterface paramQQAppInterface, Emoticon paramEmoticon, Handler paramHandler)
  {
    boolean bool = true;
    FavroamingDBManager localFavroamingDBManager = (FavroamingDBManager)paramQQAppInterface.getManager(QQManagerFactory.FAVROAMING_DB_MANAGER);
    if (QLog.isColorLevel()) {
      QLog.i("MarketFaceItemBuilder", 2, "Call getEmoticonDataList from addEmotionToFavorite.");
    }
    List localList = localFavroamingDBManager.a();
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
          if (localFavroamingDBManager.a(localCustomEmotionData, j))
          {
            paramQQAppInterface = paramQQAppInterface.getHandler(ChatActivity.class);
            if (paramHandler != null) {
              paramHandler.post(new MarketFaceItemBuilder.15(paramContext));
            }
            EmoticonManager.c("0", 1);
            if (paramQQAppInterface != null) {
              paramQQAppInterface.obtainMessage(10).sendToTarget();
            }
            return 0;
          }
          if (paramHandler != null) {
            paramHandler.post(new MarketFaceItemBuilder.16(paramContext));
          }
          EmoticonManager.c("2003", 1);
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
      }
    }
    for (;;)
    {
      paramHandler = new CustomEmotionData();
      paramHandler.uin = paramQQAppInterface.getCurrentAccountUin();
      paramHandler.emoId = (i + 1);
      paramHandler.isMarkFace = true;
      paramHandler.emoPath = paramEmoticon.epId;
      paramHandler.eId = paramEmoticon.eId;
      paramHandler.checkMarketFace("addEmotionToFavorite");
      paramEmoticon = ((EmoticonManager)paramQQAppInterface.getManager(QQManagerFactory.EMOTICON_MANAGER)).a(paramEmoticon.epId);
      if (paramEmoticon != null) {
        if (paramEmoticon.isAPNG != 2) {
          break label427;
        }
      }
      for (;;)
      {
        paramHandler.isAPNG = bool;
        paramEmoticon = (FavroamingManager)paramQQAppInterface.getManager(QQManagerFactory.FAV_ROAMING_MANAGER);
        if (paramEmoticon != null) {
          paramEmoticon.b(paramHandler, new EmoAddedAuthCallback(paramQQAppInterface, paramContext, paramHandler, null, 0));
        }
        if (jdField_a_of_type_ComTencentMobileqqDataChatMessage != null) {
          a(paramQQAppInterface, jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin, "ep_mall", "Clk_collect_suc", 0);
        }
        return j;
        label427:
        bool = false;
      }
      j = 0;
      continue;
      i = 1;
      j = 0;
    }
  }
  
  private SpannableString a(int paramInt, String paramString1, String paramString2)
  {
    String str = "";
    Object localObject = paramString2;
    int i;
    if (TextUtils.isEmpty(paramString2))
    {
      i = 2131691108;
      switch (paramInt)
      {
      default: 
        paramString2 = str;
        paramInt = i;
      }
    }
    for (;;)
    {
      localObject = this.jdField_b_of_type_AndroidContentContext.getString(paramInt, new Object[] { paramString2 });
      paramString2 = (String)localObject + paramString1;
      localObject = new SpannableString(paramString2);
      paramInt = paramString2.indexOf(paramString1);
      i = paramString1.length();
      ((SpannableString)localObject).setSpan(new ForegroundColorSpan(-31676), paramInt, i + paramInt, 33);
      return localObject;
      paramInt = 2131691109;
      paramString2 = HardCodeUtil.a(2131706483);
      continue;
      paramString2 = HardCodeUtil.a(2131706478);
      paramInt = i;
      continue;
      paramString2 = HardCodeUtil.a(2131706475);
      paramInt = i;
      continue;
      paramString2 = HardCodeUtil.a(2131706485);
      paramInt = i;
    }
  }
  
  private QQProgressDialog a()
  {
    if (((FragmentActivity)this.jdField_b_of_type_AndroidContentContext).getChatFragment().a() != null)
    {
      if (((FragmentActivity)this.jdField_b_of_type_AndroidContentContext).getChatFragment().a().a == null) {
        ((FragmentActivity)this.jdField_b_of_type_AndroidContentContext).getChatFragment().a().a = new QQProgressDialog(this.jdField_b_of_type_AndroidContentContext);
      }
      return ((FragmentActivity)this.jdField_b_of_type_AndroidContentContext).getChatFragment().a().a;
    }
    return null;
  }
  
  private String a()
  {
    try
    {
      i = NetworkUtil.a(this.jdField_b_of_type_AndroidContentContext);
      switch (i)
      {
      default: 
        return "";
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        int i = 0;
      }
      return "2G";
    }
    return "3G";
    return "4G";
    return "wifi";
  }
  
  private void a(int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemMarketFaceItemBuilder$EmoticonDetailJsonDownloaderVars.a(paramInt, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_AndroidContentContext, jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, a());
    EmojiListenerManager.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemMarketFaceItemBuilder$EmoticonDetailJsonDownloaderVars);
    this.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiManager.a(jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon.epId, EmojiManager.jdField_c_of_type_Int);
  }
  
  public static void a(int paramInt1, Context paramContext, QQAppInterface paramQQAppInterface, Emoticon paramEmoticon, int paramInt2, String paramString, SessionInfo paramSessionInfo, boolean paramBoolean)
  {
    if (paramEmoticon == null) {
      QLog.d("MarketFaceItemBuilder", 1, "can not find emoticon");
    }
    label223:
    do
    {
      Handler localHandler;
      do
      {
        do
        {
          do
          {
            return;
            if (a(paramContext)) {
              break;
            }
          } while (!QLog.isColorLevel());
          QLog.d("MarketFaceItemBuilder", 2, "context is not in the top");
          return;
          localHandler = new Handler(Looper.getMainLooper());
          if (paramInt2 != 0) {
            break label223;
          }
          if (7 != paramInt1 % 1000) {
            break;
          }
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
          catch (Exception paramContext) {}
        } while (!QLog.isColorLevel());
        QLog.e("EmosmDetailActivity.operateMarketFaceFromDownLoad", 2, paramContext.getMessage());
        return;
        if (6 == paramInt1 % 1000)
        {
          ThreadManager.post(new MarketFaceItemBuilder.12(paramContext, paramQQAppInterface, paramEmoticon, localHandler), 5, null, true);
          return;
        }
      } while (107 != paramInt1 % 1000);
      ReportController.b(paramQQAppInterface, "CliOper", "", "", "ep_mall", "Ep_follow_send_aio", 0, 0, "", paramEmoticon.epId, "", "");
      PicEmoticonInfo.send(paramQQAppInterface, paramContext, paramSessionInfo, paramEmoticon, null);
      return;
      if (paramInt2 < 0)
      {
        localHandler.post(new MarketFaceItemBuilder.13(paramContext, paramString));
        if (6 == paramInt1 % 1000) {
          EmoticonManager.c("2001", 1);
        }
        QLog.i("MarketFaceItemBuilder", 1, "opType: " + paramInt1 + ",result:" + paramInt2);
        return;
      }
      localHandler.post(new MarketFaceItemBuilder.14(paramInt1, paramContext, paramQQAppInterface, paramEmoticon, paramString));
    } while (6 != paramInt1 % 1000);
    EmoticonManager.c("2002", 1);
  }
  
  public static void a(int paramInt, Context paramContext, QQAppInterface paramQQAppInterface, EmoticonPackage paramEmoticonPackage, PicEmoticonInfo paramPicEmoticonInfo, SessionInfo paramSessionInfo, QQProgressDialog paramQQProgressDialog)
  {
    a(paramInt, paramContext, paramQQAppInterface, paramEmoticonPackage, paramPicEmoticonInfo, paramSessionInfo, paramQQProgressDialog, false);
  }
  
  public static void a(int paramInt, Context paramContext, QQAppInterface paramQQAppInterface, EmoticonPackage paramEmoticonPackage, PicEmoticonInfo paramPicEmoticonInfo, SessionInfo paramSessionInfo, QQProgressDialog paramQQProgressDialog, boolean paramBoolean)
  {
    if (paramPicEmoticonInfo == null) {
      return;
    }
    if ((paramEmoticonPackage != null) && (paramEmoticonPackage.mobileFeetype == 1))
    {
      if ((paramQQProgressDialog != null) && (paramQQProgressDialog.isShowing())) {
        paramQQProgressDialog.dismiss();
      }
      a(paramInt, paramContext, paramQQAppInterface, paramPicEmoticonInfo.emoticon, 0, null, paramSessionInfo, paramBoolean);
      return;
    }
    if ((!NetworkUtil.g(paramContext)) || (paramInt > 1000))
    {
      if ((paramQQProgressDialog != null) && (paramQQProgressDialog.isShowing())) {
        paramQQProgressDialog.dismiss();
      }
      a(paramInt, paramContext, paramQQAppInterface, paramPicEmoticonInfo.emoticon, -404, HardCodeUtil.a(2131706482), paramSessionInfo, paramBoolean);
      return;
    }
    ((EmoticonHandler)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.HANDLER_EMOSM)).a(paramInt, Integer.valueOf(paramPicEmoticonInfo.emoticon.epId).intValue(), paramPicEmoticonInfo.emoticon.eId);
  }
  
  private void a(MarketFaceItemBuilder.Holder paramHolder)
  {
    EmoticonPackage localEmoticonPackage;
    if (!this.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiManager.a(paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon.epId, Boolean.valueOf(false)))
    {
      EmojiListenerManager.a().a(this.jdField_a_of_type_ComTencentMobileqqEmoticonEmoticonPackageDownloadListener);
      localEmoticonPackage = new EmoticonPackage();
      localEmoticonPackage.name = paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon.name;
      localEmoticonPackage.epId = paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon.epId;
      localEmoticonPackage.jobType = 3;
      localEmoticonPackage.type = 1;
      localEmoticonPackage.isMagicFaceDownloading = true;
      if (paramHolder.jdField_e_of_type_Int != -1) {
        break label223;
      }
    }
    label223:
    for (localEmoticonPackage.rscType = PngFrameUtil.a(paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon.magicValue);; localEmoticonPackage.rscType = paramHolder.jdField_e_of_type_Int)
    {
      ((EmoticonManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.EMOTICON_MANAGER)).a(paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon);
      paramHolder.jdField_a_of_type_Boolean = false;
      ((MessageForMarketFace)paramHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage).needToPlay = true;
      this.jdField_a_of_type_JavaUtilList.add(paramHolder);
      paramHolder.f.setVisibility(8);
      paramHolder.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiManager.a(localEmoticonPackage, false);
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "MbJieshou", "MbZhudongXiazai", 0, 0, "", "", "", "");
      return;
    }
  }
  
  private void a(MarketFaceItemBuilder.Holder paramHolder, int paramInt, MessageForMarketFace paramMessageForMarketFace, ChatMessage paramChatMessage, long paramLong)
  {
    paramHolder.jdField_e_of_type_AndroidWidgetImageView.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
    if (paramMessageForMarketFace.mMarkFaceMessage != null) {
      a(paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo, paramInt, paramMessageForMarketFace.mMarkFaceMessage.copywritingContent);
    }
    PicItemBuilder.e();
    long l = paramHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq;
    paramHolder.jdField_a_of_type_Long = paramHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq;
    if (paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo == null)
    {
      paramHolder.jdField_e_of_type_AndroidWidgetImageView.setImageResource(2130838121);
      l = System.currentTimeMillis();
      if ((QLog.isColorLevel()) && (paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo != null) && (paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon != null)) {
        QLog.d("MarketFaceItemBuilder", 1, "epId = " + paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon.epId + ":view time = " + (l - paramLong));
      }
      return;
    }
    paramHolder.jdField_e_of_type_AndroidWidgetImageView.setContentDescription(HardCodeUtil.a(2131706484) + paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon.name);
    String str;
    if (2 == paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon.jobType)
    {
      PngFrameManager localPngFrameManager = (PngFrameManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.PNG_FRAME_DRAWABLE_MANAGER);
      boolean bool = false;
      if (paramHolder.jdField_b_of_type_Int == paramHolder.jdField_c_of_type_Int - 1) {
        bool = localPngFrameManager.a(paramHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
      }
      str = "";
      if (paramMessageForMarketFace.mMarkFaceMessage != null) {
        if ((paramMessageForMarketFace.mMarkFaceMessage.mobileparam != null) && (paramMessageForMarketFace.mMarkFaceMessage.mobileparam.length > 0))
        {
          paramMessageForMarketFace = new String(paramMessageForMarketFace.mMarkFaceMessage.mobileparam);
          label305:
          localPngFrameManager.a(paramMessageForMarketFace, paramHolder, l, bool, true, new MarketFaceItemBuilder.5(this, paramChatMessage, paramHolder));
          paramHolder.d.setVisibility(8);
          paramHolder.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
          paramHolder.jdField_a_of_type_ComTencentMobileqqDoutuDuiButtonImageView.setVisibility(8);
          paramHolder.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
          paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemBreathAnimationLayout.setVisibility(8);
          paramHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
          paramHolder.f.setVisibility(8);
          c(paramHolder);
        }
      }
    }
    for (;;)
    {
      if (((2 == paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon.jobType) || (4 == paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon.jobType)) && (paramHolder.jdField_a_of_type_ComTencentMobileqqDoutuDuiButtonImageView != null))
      {
        paramHolder.jdField_a_of_type_ComTencentMobileqqDoutuDuiButtonImageView.setVisibility(8);
        paramHolder.jdField_a_of_type_ComTencentMobileqqDoutuDuiButtonImageView.e();
      }
      if (!this.f) {
        break;
      }
      d(paramHolder);
      break;
      QLog.e("MarketFaceItemBuilder", 1, "getBubble view mMessage.mMarkFaceMessage mobileparam is empty");
      paramMessageForMarketFace = str;
      break label305;
      QLog.e("MarketFaceItemBuilder", 1, "getBubble view mMessage.mMarkFaceMessage is null");
      paramMessageForMarketFace = str;
      break label305;
      if (4 == paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon.jobType)
      {
        if (!paramChatMessage.isSend()) {
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "MbJieshou", "mbjieshou", 0, 0, paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon.epId, "", "", "");
        }
        a(paramChatMessage, paramHolder);
        b(paramHolder);
      }
      else
      {
        a(paramChatMessage, paramHolder);
      }
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
    if (paramURLDrawable != null) {
      switch (paramURLDrawable.getStatus())
      {
      default: 
        paramHolder.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
        paramBaseChatItemLayout.setProgressVisable(true);
      }
    }
    do
    {
      float f1;
      do
      {
        do
        {
          return;
          if (!MagicfaceViewController.a()) {
            paramHolder.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
          }
        } while ((EmoticonUtils.isWifiOrG3OrG4()) && (2 == paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon.jobType) && (!this.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiManager.f(paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon.epId)) && (!EmoticonUtils.needDisableAutoReceiveMagicFace()));
        f1 = this.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiManager.a(paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon.epId);
      } while ((f1 >= 0.0F) && (1.0F != f1));
      paramHolder.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
      paramBaseChatItemLayout.setProgressVisable(false);
      return;
      paramHolder.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
      paramBaseChatItemLayout.setProgressVisable(false);
    } while (!AppSetting.d);
    paramHolder.jdField_a_of_type_AndroidWidgetFrameLayout.setContentDescription(HardCodeUtil.a(2131706479));
  }
  
  private void a(MarketFaceItemBuilder.Holder paramHolder, String paramString)
  {
    if ((paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo != null) && (paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon != null) && (paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon.jobType != 0) && (paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon.jobType != 2) && (paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon.jobType != 4))
    {
      paramHolder.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
      if (!"big_sound".equals(paramString)) {
        break label181;
      }
      if ((paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon != null) && (paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon.isSound))
      {
        if (!c(paramHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage)) {
          break label123;
        }
        MediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(false);
      }
    }
    label123:
    do
    {
      do
      {
        do
        {
          return;
          if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isVideoChatting())
          {
            QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), 2131695173, 0).b(this.jdField_b_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299166));
            return;
          }
          MediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(paramHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage);
          return;
        } while (!"aio_preview".equals(paramString));
        paramString = paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.getLoadingDrawable("fromAIO", true);
      } while (paramString == null);
      paramHolder.jdField_e_of_type_AndroidWidgetImageView.setImageDrawable(paramString);
      paramHolder.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
      a(paramHolder, paramString);
    } while (!paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.isSound());
    label181:
    jdField_c_of_type_Long = paramHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq;
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Emoticon paramEmoticon, EmoBatchAddedCallback paramEmoBatchAddedCallback)
  {
    boolean bool = false;
    Object localObject = (FavroamingDBManager)paramQQAppInterface.getManager(QQManagerFactory.FAVROAMING_DB_MANAGER);
    if (QLog.isColorLevel()) {
      QLog.i("EmoBatchAdded", 2, "Call getEmoticonDataList from addEmotionToFavorite.");
    }
    List localList = ((FavroamingDBManager)localObject).a();
    int i;
    if (localList != null)
    {
      i = 0;
      if (i < localList.size())
      {
        CustomEmotionData localCustomEmotionData = (CustomEmotionData)localList.get(i);
        if ((localCustomEmotionData.isMarkFace) && (localCustomEmotionData.emoPath.equals(paramEmoticon.epId)) && (localCustomEmotionData.eId.equals(paramEmoticon.eId))) {
          if (((FavroamingDBManager)localObject).a(localCustomEmotionData, i))
          {
            paramQQAppInterface = paramQQAppInterface.getHandler(ChatActivity.class);
            EmoticonManager.c("0", 1);
            if (paramQQAppInterface != null) {
              paramQQAppInterface.obtainMessage(10).sendToTarget();
            }
            EmoBatchAddedHandler.a(paramEmoBatchAddedCallback, 4);
          }
        }
      }
    }
    do
    {
      return;
      EmoBatchAddedHandler.a(paramEmoBatchAddedCallback, 2);
      EmoticonManager.c("2003", 1);
      return;
      i += 1;
      break;
      localObject = new CustomEmotionData();
      ((CustomEmotionData)localObject).uin = paramQQAppInterface.getCurrentAccountUin();
      ((CustomEmotionData)localObject).emoId = paramEmoBatchAddedCallback.jdField_a_of_type_Int;
      ((CustomEmotionData)localObject).isMarkFace = true;
      ((CustomEmotionData)localObject).emoPath = paramEmoticon.epId;
      ((CustomEmotionData)localObject).eId = paramEmoticon.eId;
      ((CustomEmotionData)localObject).checkMarketFace("addEmotionToFavorite");
      paramEmoticon = ((EmoticonManager)paramQQAppInterface.getManager(QQManagerFactory.EMOTICON_MANAGER)).a(paramEmoticon.epId);
      if (paramEmoticon != null)
      {
        if (paramEmoticon.isAPNG == 2) {
          bool = true;
        }
        ((CustomEmotionData)localObject).isAPNG = bool;
      }
      paramEmoBatchAddedCallback.a((CustomEmotionData)localObject);
      paramQQAppInterface = (FavroamingManager)paramQQAppInterface.getManager(QQManagerFactory.FAV_ROAMING_MANAGER);
    } while (paramQQAppInterface == null);
    if (QLog.isColorLevel()) {
      QLog.d("EmoBatchAdded", 1, "addBatchEmotionToFavorite fm.syncUpload");
    }
    paramQQAppInterface.b((CustomEmotionData)localObject, paramEmoBatchAddedCallback);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, EmoticonPackage paramEmoticonPackage, PicEmoticonInfo paramPicEmoticonInfo, EmoBatchAddedCallback paramEmoBatchAddedCallback)
  {
    if (paramPicEmoticonInfo == null) {
      return;
    }
    if ((paramEmoticonPackage != null) && (paramEmoticonPackage.mobileFeetype == 1))
    {
      a(paramQQAppInterface, paramPicEmoticonInfo.emoticon, paramEmoBatchAddedCallback);
      return;
    }
    ((EmoticonHandler)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.HANDLER_EMOSM)).a(6, Integer.valueOf(paramPicEmoticonInfo.emoticon.epId).intValue(), paramPicEmoticonInfo.emoticon.eId);
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
    int i = 0;
    if ((paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.isSound()) && (!c(paramChatMessage))) {}
    for (boolean bool = false;; bool = true)
    {
      URLDrawable localURLDrawable = paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.getLoadingDrawable("fromAIO", bool);
      Object localObject1 = "";
      Object localObject2 = localObject1;
      if (localURLDrawable != null)
      {
        localObject2 = localObject1;
        if (localURLDrawable.getStatus() == 1)
        {
          if ((localURLDrawable.getStateTag() instanceof Bundle)) {
            localObject1 = ((Bundle)localURLDrawable.getStateTag()).getString("display_type");
          }
          localObject2 = localObject1;
          if (!TextUtils.isEmpty((CharSequence)localObject1))
          {
            localObject2 = localObject1;
            if (((String)localObject1).equals("aio_preview"))
            {
              localObject2 = paramHolder.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage;
              if ((localObject2 != null) && (((EmoticonPackage)localObject2).status == 2))
              {
                URLDrawable.removeMemoryCacheByUrl(localURLDrawable.getURL().toString());
                paramString = paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.getLoadingDrawable("fromAIO", bool);
              }
            }
          }
        }
      }
      for (;;)
      {
        b(paramHolder, paramString);
        paramHolder.d.setVisibility(8);
        paramHolder.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
        paramHolder.jdField_a_of_type_ComTencentMobileqqDoutuDuiButtonImageView.setVisibility(8);
        c(paramChatMessage, paramHolder);
        b(paramChatMessage, paramHolder);
        if (paramString != null) {
          a(paramHolder, paramString, (String)localObject1);
        }
        c(paramHolder);
        return;
        if (!paramString.equals("")) {
          i = 1;
        }
        localObject2 = localObject1;
        if (i != 0)
        {
          URLDrawable.removeMemoryCacheByUrl(localURLDrawable.getURL().toString());
          paramString = paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.getLoadingDrawable("fromAIO", bool, true, paramHolder);
        }
        else
        {
          paramString = localURLDrawable;
          localObject1 = localObject2;
        }
      }
    }
  }
  
  private void a(PicEmoticonInfo paramPicEmoticonInfo, int paramInt, String paramString)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 1: 
    case 2: 
      str1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin();
      str2 = a();
      if (paramPicEmoticonInfo == null) {}
      for (paramPicEmoticonInfo = "";; paramPicEmoticonInfo = paramPicEmoticonInfo.emoticon.epId)
      {
        VasWebviewUtil.reportCommercialDrainage(str1, "ep_mall", "yinliu_xiaoweiba_view", "AIO", 1, 0, 1, str2, paramPicEmoticonInfo, paramString);
        return;
      }
    case 3: 
      paramString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      if (paramPicEmoticonInfo == null) {}
      for (paramPicEmoticonInfo = "";; paramPicEmoticonInfo = paramPicEmoticonInfo.emoticon.epId)
      {
        ReportController.b(paramString, "CliOper", "", "", "ep_mall", "0X8007187", 0, 0, paramPicEmoticonInfo, "", "", "");
        return;
      }
    }
    String str1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin();
    String str2 = a();
    if (paramPicEmoticonInfo == null) {}
    for (paramPicEmoticonInfo = "";; paramPicEmoticonInfo = paramPicEmoticonInfo.emoticon.epId)
    {
      VasWebviewUtil.reportCommercialDrainage(str1, "ep_mall", "yinliu_xiaoweiba_view", "AIO", 1, 0, 1, str2, paramPicEmoticonInfo, paramString, "1", "", "", "", 0, 0, 0, 0);
      return;
    }
  }
  
  public static boolean a(Context paramContext)
  {
    Object localObject = ((ActivityManager)paramContext.getSystemService("activity")).getRunningTasks(1);
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      localObject = ((ActivityManager.RunningTaskInfo)((List)localObject).get(0)).topActivity;
      if (localObject != null)
      {
        localObject = ((ComponentName)localObject).getClassName();
        return paramContext.getClass().getName().equals(localObject);
      }
    }
    return true;
  }
  
  private static void b(int paramInt, Context paramContext, QQAppInterface paramQQAppInterface, Emoticon paramEmoticon, String paramString1, String paramString2)
  {
    try
    {
      DialogUtil.a(paramContext, 230, paramString1, paramString2, 2131690800, 2131691685, new MarketFaceItemBuilder.17(paramEmoticon, paramContext, paramQQAppInterface, paramInt), new MarketFaceItemBuilder.18()).show();
      return;
    }
    catch (Exception paramContext)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("EmosmDetailActivity.showCustomMarketFaceTips", 2, paramContext.getMessage());
    }
  }
  
  private void b(MarketFaceItemBuilder.Holder paramHolder)
  {
    if ((4 != paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon.jobType) || (((MessageForMarketFace)paramHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage).mMarkFaceMessage == null)) {}
    do
    {
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiManager.a(paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon.epId, true, true)) {
        break;
      }
      if (!EmoticonUtils.isWifiOrG3OrG4())
      {
        if (QLog.isColorLevel()) {
          QLog.d("MarketFaceItemBuilder", 2, "magicFaceIcon gone: H5MagicSource isnot Intact , and network isnot 2 3 4G or wifi;epId = " + paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon.epId);
        }
        paramHolder.f.setVisibility(8);
        return;
      }
    } while (-1.0F != this.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiManager.a(paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon.epId));
    EmojiListenerManager.a().a(this.jdField_a_of_type_ComTencentMobileqqEmoticonEmoticonPackageDownloadListener);
    EmoticonPackage localEmoticonPackage = new EmoticonPackage();
    localEmoticonPackage.name = paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon.name;
    localEmoticonPackage.epId = paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon.epId;
    localEmoticonPackage.jobType = 5;
    localEmoticonPackage.type = 1;
    localEmoticonPackage.isMagicFaceDownloading = true;
    ((EmoticonManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.EMOTICON_MANAGER)).a(paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon);
    this.jdField_a_of_type_JavaUtilList.add(paramHolder);
    paramHolder.jdField_a_of_type_Boolean = ((MessageForMarketFace)paramHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage).needToPlay;
    paramHolder.f.setVisibility(8);
    paramHolder.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
    ((MessageForMarketFace)paramHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage).needToPlay = false;
    this.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiManager.a(localEmoticonPackage, false);
    if (QLog.isColorLevel()) {
      QLog.d("MarketFaceItemBuilder", 2, "magicFaceIcon gone,start download epId = " + paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon.epId);
    }
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "MbJieshou", "MbZhudongXiazai", 0, 0, localEmoticonPackage.epId, "", "", "");
    return;
    if ((this.f) && (this.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiManager.b()))
    {
      if (!this.jdField_b_of_type_Boolean) {
        paramHolder.f.setVisibility(0);
      }
      if (QLog.isColorLevel()) {
        QLog.d("MarketFaceItemBuilder", 2, "magicFaceIcon visible,h5source intacat epId = " + paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon.epId);
      }
    }
    for (;;)
    {
      paramHolder.f.setImageResource(2130838125);
      if ((((MessageForMarketFace)paramHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage).isSend()) || (!((MessageForMarketFace)paramHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage).needToPlay) || (!this.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiManager.a()) || (System.currentTimeMillis() - this.jdField_d_of_type_Long <= 3000L) || (((FragmentActivity)this.jdField_b_of_type_AndroidContentContext).getChatFragment() == null) || (((FragmentActivity)this.jdField_b_of_type_AndroidContentContext).getChatFragment().a() == null) || (((FragmentActivity)this.jdField_b_of_type_AndroidContentContext).getChatFragment().a().n())) {
        break;
      }
      this.jdField_d_of_type_Long = System.currentTimeMillis();
      ((MessageForMarketFace)paramHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage).needToPlay = false;
      b(paramHolder, "1");
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "MbJieshou", "MbZidongBofang", 0, 0, paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon.epId, "", "", "");
      return;
      paramHolder.f.setVisibility(8);
    }
  }
  
  private void b(MarketFaceItemBuilder.Holder paramHolder, URLDrawable paramURLDrawable)
  {
    int m = 200;
    int j;
    label50:
    int k;
    int n;
    Object localObject;
    if ((paramURLDrawable != null) && (paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon != null)) {
      if (paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon.width == 0)
      {
        j = 200;
        if (paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon.height != 0) {
          break label429;
        }
        k = j;
        i = m;
        if (paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon.extensionWidth != 0)
        {
          k = j;
          i = m;
          if (paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon.extensionHeight != 0)
          {
            k = paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon.extensionWidth;
            i = paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon.extensionHeight;
          }
        }
        j = k;
        if (k != i) {
          j = i;
        }
        n = (j * this.jdField_e_of_type_Int + (this.jdField_d_of_type_Int >> 1)) / this.jdField_d_of_type_Int;
        i = (this.jdField_e_of_type_Int * i + (this.jdField_d_of_type_Int >> 1)) / this.jdField_d_of_type_Int;
        paramHolder.jdField_e_of_type_AndroidWidgetImageView.setLayoutParams(new FrameLayout.LayoutParams(n, i));
        localObject = paramHolder.jdField_a_of_type_AndroidWidgetTextView.getTag();
        if (!(localObject instanceof Integer)) {
          break label530;
        }
      }
    }
    label530:
    for (int i = ((Integer)localObject).intValue();; i = -1)
    {
      if ((paramHolder.jdField_a_of_type_AndroidWidgetTextView.getVisibility() == 0) && (i != -1))
      {
        String str1 = (String)paramHolder.jdField_a_of_type_AndroidWidgetTextView.getTag(2131364225);
        String str2 = (String)paramHolder.jdField_a_of_type_AndroidWidgetTextView.getTag(2131364224);
        Paint localPaint = new Paint(1);
        localPaint.setTextSize(AIOUtils.a(12.0F, this.jdField_b_of_type_AndroidContentContext.getResources()));
        localPaint.setTextAlign(Paint.Align.LEFT);
        int i1 = (int)localPaint.measureText("...");
        if (!TextUtils.isEmpty(str1)) {}
        for (j = (int)localPaint.measureText(HardCodeUtil.a(2131706480) + str1);; j = (int)localPaint.measureText(HardCodeUtil.a(2131706476)))
        {
          m = str2.length();
          k = (int)localPaint.measureText(str2) + j;
          localObject = "";
          while ((k > n) && (m > 0))
          {
            m -= 1;
            localObject = str2.substring(0, m);
            k = (int)localPaint.measureText((String)localObject) + i1 + j;
          }
          j = paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon.width;
          break;
          label429:
          m = paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon.height;
          break label50;
        }
        if (!((String)localObject).equals(""))
        {
          localObject = a(i, (String)localObject + "...", str1);
          paramHolder.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
        }
      }
      paramHolder.jdField_e_of_type_AndroidWidgetImageView.setImageDrawable(paramURLDrawable);
      a(paramHolder, paramURLDrawable, paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout);
      return;
    }
  }
  
  private void b(MarketFaceItemBuilder.Holder paramHolder, URLDrawable paramURLDrawable, String paramString)
  {
    String str = "";
    if ((paramURLDrawable.getStateTag() instanceof Bundle)) {
      str = ((Bundle)paramURLDrawable.getStateTag()).getString("display_type");
    }
    paramURLDrawable.restartDownload();
    if (QLog.isColorLevel()) {
      QLog.d("MarketFaceItemBuilder", 2, "msgOnclickListener| URLDrawable restartDownload status=" + paramURLDrawable.getStatus());
    }
    a(paramHolder, paramURLDrawable, str);
    paramHolder.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
    if ((paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo != null) && (paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.isSound()) && ("big_sound".equals(paramString))) {
      jdField_c_of_type_Long = paramHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq;
    }
  }
  
  private void b(MarketFaceItemBuilder.Holder paramHolder, String paramString)
  {
    ThreadManager.post(new MarketFaceItemBuilder.6(this, paramString, paramHolder), 5, null, true);
  }
  
  private void b(ChatMessage paramChatMessage, MarketFaceItemBuilder.Holder paramHolder)
  {
    if ((paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.isSound()) && (paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.isNewSoundType()) && ((paramChatMessage instanceof MessageForMarketFace)))
    {
      if (paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.getWaveformArray() != null)
      {
        paramChatMessage = (RelativeLayout.LayoutParams)paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.getLayoutParams();
        paramChatMessage.width = AIOUtils.a(39.0F, this.jdField_b_of_type_AndroidContentContext.getResources());
        paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.setAudioData(paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.getWaveformArray(), paramChatMessage.width, paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.getVoiceLength());
        if (Build.VERSION.SDK_INT < 19)
        {
          paramChatMessage = (RelativeLayout.LayoutParams)paramHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
          RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemBreathAnimationLayout.getLayoutParams();
          paramChatMessage.width = AIOUtils.a(92.0F, this.jdField_b_of_type_AndroidContentContext.getResources());
          localLayoutParams.width = AIOUtils.a(92.0F, this.jdField_b_of_type_AndroidContentContext.getResources());
        }
      }
      int i = paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.getWaveBackgroundColor();
      int j = paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.getWaveForegroundColor();
      paramChatMessage = new RoundedColorDrawable(i, 1, 1, AIOUtils.a(22.0F, this.jdField_b_of_type_AndroidContentContext.getResources()));
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
    if ((2 != paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon.jobType) || (((MessageForMarketFace)paramHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage).mMarkFaceMessage == null) || (!MagicfaceViewController.a())) {}
    for (;;)
    {
      return;
      Object localObject1;
      if (!this.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiManager.f(paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon.epId))
      {
        if (!EmoticonUtils.isWifiOrG3OrG4())
        {
          paramHolder.f.setVisibility(8);
          return;
        }
        if ((!EmoticonUtils.needDisableAutoReceiveMagicFace()) && (!this.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiManager.a(paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon.epId, Boolean.valueOf(false))) && (-1.0F == this.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiManager.a(paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon.epId)))
        {
          EmojiListenerManager.a().a(this.jdField_a_of_type_ComTencentMobileqqEmoticonEmoticonPackageDownloadListener);
          localObject1 = new EmoticonPackage();
          ((EmoticonPackage)localObject1).name = paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon.name;
          ((EmoticonPackage)localObject1).epId = paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon.epId;
          ((EmoticonPackage)localObject1).jobType = 3;
          ((EmoticonPackage)localObject1).rscType = PngFrameUtil.a(paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon.magicValue);
          ((EmoticonPackage)localObject1).type = 1;
          ((EmoticonPackage)localObject1).isMagicFaceDownloading = true;
          ((EmoticonManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.EMOTICON_MANAGER)).a(paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon);
          this.jdField_a_of_type_JavaUtilList.add(paramHolder);
          paramHolder.jdField_a_of_type_Boolean = ((MessageForMarketFace)paramHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage).needToPlay;
          paramHolder.f.setVisibility(8);
          paramHolder.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
          ((MessageForMarketFace)paramHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage).needToPlay = false;
          this.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiManager.a((EmoticonPackage)localObject1, false);
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "MbJieshou", "MbZidongXiazai", 0, 0, paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon.epId, "", "", "");
        }
      }
      else
      {
        if (PngFrameUtil.a(paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon.magicValue) == 1) {
          paramHolder.f.setVisibility(8);
        }
        while (((MessageForMarketFace)paramHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage).needToPlay)
        {
          ((MessageForMarketFace)paramHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage).needToPlay = false;
          localObject1 = new Emoticon();
          ((Emoticon)localObject1).eId = paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon.eId;
          ((Emoticon)localObject1).epId = paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon.epId;
          ((Emoticon)localObject1).magicValue = paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon.magicValue;
          ((Emoticon)localObject1).jobType = paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon.jobType;
          Object localObject2 = ((FragmentActivity)this.jdField_b_of_type_AndroidContentContext).getChatFragment();
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
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "MbJieshou", "MbZidongBofang", 0, 0, paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon.epId, "", "", "");
          return;
          if (!this.jdField_b_of_type_Boolean)
          {
            paramHolder.f.setImageResource(2130838125);
            paramHolder.f.setVisibility(0);
          }
        }
      }
    }
  }
  
  private void c(ChatMessage paramChatMessage, MarketFaceItemBuilder.Holder paramHolder)
  {
    if ((paramChatMessage.isFlowMessage) && (a(paramHolder)) && (paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon.jobType == 0)) {
      if (!(this.jdField_b_of_type_AndroidContentContext instanceof MultiForwardActivity))
      {
        if (!paramChatMessage.isSend()) {
          break label64;
        }
        paramHolder.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130847477);
        paramHolder.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
      }
    }
    label64:
    while ((!paramChatMessage.isDui) || (!DuiButtonImageView.jdField_a_of_type_Boolean) || (HotChatUtil.a(paramChatMessage)))
    {
      return;
      paramHolder.d.setImageResource(2130847477);
      paramHolder.d.setVisibility(0);
      return;
    }
    paramHolder.jdField_a_of_type_ComTencentMobileqqDoutuDuiButtonImageView.jdField_a_of_type_ComTencentMobileqqDataChatMessage = paramChatMessage;
    if ((paramChatMessage.isSend()) || ((a(paramHolder)) && (paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.isSound())))
    {
      paramHolder.jdField_a_of_type_ComTencentMobileqqDoutuDuiButtonImageView.setVisibility(8);
      paramHolder.jdField_a_of_type_ComTencentMobileqqDoutuDuiButtonImageView.e();
      return;
    }
    if ((a(paramHolder)) && (paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon != null) && ((2 == paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon.jobType) || (4 == paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon.jobType)))
    {
      paramHolder.jdField_a_of_type_ComTencentMobileqqDoutuDuiButtonImageView.setVisibility(8);
      paramHolder.jdField_a_of_type_ComTencentMobileqqDoutuDuiButtonImageView.e();
      return;
    }
    if (!paramChatMessage.hasPlayedDui) {
      paramChatMessage.hasPlayedDui = DuiButtonImageView.a(paramHolder.jdField_a_of_type_ComTencentMobileqqDoutuDuiButtonImageView);
    }
    while (DuiButtonImageView.jdField_a_of_type_Boolean)
    {
      paramHolder.jdField_a_of_type_ComTencentMobileqqDoutuDuiButtonImageView.setOnClickListener(this);
      paramHolder.jdField_a_of_type_ComTencentMobileqqDoutuDuiButtonImageView.setVisibility(0);
      return;
      if (paramHolder.jdField_a_of_type_ComTencentMobileqqDoutuDuiButtonImageView.b()) {
        DoutuConfigReporter.a(paramChatMessage);
      }
    }
    paramHolder.jdField_a_of_type_ComTencentMobileqqDoutuDuiButtonImageView.setOnClickListener(null);
    paramHolder.jdField_a_of_type_ComTencentMobileqqDoutuDuiButtonImageView.setVisibility(8);
  }
  
  private boolean c(ChatMessage paramChatMessage)
  {
    if (paramChatMessage == null) {}
    ChatMessage localChatMessage;
    do
    {
      return false;
      localChatMessage = MediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a();
    } while ((localChatMessage != paramChatMessage) && ((!(localChatMessage instanceof MessageForMarketFace)) || (localChatMessage.frienduin == null) || (!localChatMessage.frienduin.equals(paramChatMessage.frienduin)) || (localChatMessage.uniseq != paramChatMessage.uniseq)));
    return true;
  }
  
  private void d(MarketFaceItemBuilder.Holder paramHolder)
  {
    if ((paramHolder != null) && (paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo != null) && (paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.isNewSoundType()) && (paramHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage != null) && (!this.jdField_c_of_type_JavaUtilSet.contains(Long.valueOf(paramHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq))))
    {
      EmoticonManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "0X800AB51", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon.epId);
      this.jdField_c_of_type_JavaUtilSet.add(Long.valueOf(paramHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq));
    }
  }
  
  private void f(View paramView)
  {
    paramView = (MarketFaceItemBuilder.Holder)AIOUtils.a(paramView);
    Object localObject;
    if ((paramView.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo != null) && (paramView.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon != null) && (2 == paramView.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon.jobType))
    {
      if (!this.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiManager.a(paramView.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon.epId, Boolean.valueOf(false)))
      {
        EmojiListenerManager.a().a(this.jdField_a_of_type_ComTencentMobileqqEmoticonEmoticonPackageDownloadListener);
        localObject = new EmoticonPackage();
        ((EmoticonPackage)localObject).name = paramView.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon.name;
        ((EmoticonPackage)localObject).epId = paramView.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon.epId;
        ((EmoticonPackage)localObject).jobType = 3;
        ((EmoticonPackage)localObject).type = 1;
        ((EmoticonPackage)localObject).isMagicFaceDownloading = true;
        paramView.jdField_a_of_type_Boolean = false;
        ((MessageForMarketFace)paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage).needToPlay = false;
        ((EmoticonManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.EMOTICON_MANAGER)).a(paramView.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon);
        this.jdField_a_of_type_JavaUtilList.add(paramView);
        paramView.f.setVisibility(8);
        paramView.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
        this.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiManager.a((EmoticonPackage)localObject, false);
        ReportController.b(null, "CliOper", "", "", "MbJieshou", "MbZhudongBofang", 0, 0, paramView.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon.epId, "", "", "");
      }
    }
    else if ((paramView.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo != null) && (paramView.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon != null) && (4 == paramView.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon.jobType) && (System.currentTimeMillis() - this.jdField_d_of_type_Long > 3000L) && (this.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiManager.a()))
    {
      this.jdField_d_of_type_Long = System.currentTimeMillis();
      if (!this.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiManager.a(paramView.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon.epId, true, true)) {
        break label443;
      }
      b(paramView, "0");
    }
    for (;;)
    {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "MbFasong", "MbZhudongBofang", 0, 0, paramView.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon.epId, "", "", "");
      return;
      localObject = ((FragmentActivity)this.jdField_b_of_type_AndroidContentContext).getChatFragment();
      if (localObject == null) {
        break;
      }
      localObject = ((ChatFragment)localObject).a();
      if ((localObject == null) || (!MagicfaceViewController.a())) {
        break;
      }
      localObject = (AIOEmoticonUIHelper)((BaseChatPie)localObject).a(105);
      if (localObject == null) {
        break;
      }
      ((AIOEmoticonUIHelper)localObject).a(paramView.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon, 1, paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage.senderuin, true);
      break;
      label443:
      EmojiListenerManager.a().a(this.jdField_a_of_type_ComTencentMobileqqEmoticonEmoticonPackageDownloadListener);
      localObject = new EmoticonPackage();
      ((EmoticonPackage)localObject).name = paramView.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon.name;
      ((EmoticonPackage)localObject).epId = paramView.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon.epId;
      ((EmoticonPackage)localObject).jobType = 5;
      ((EmoticonPackage)localObject).type = 1;
      ((EmoticonPackage)localObject).isMagicFaceDownloading = true;
      paramView.jdField_a_of_type_Boolean = false;
      ((MessageForMarketFace)paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage).needToPlay = false;
      ((EmoticonManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.EMOTICON_MANAGER)).a(paramView.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon);
      this.jdField_a_of_type_JavaUtilList.add(paramView);
      paramView.f.setVisibility(8);
      paramView.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiManager.a((EmoticonPackage)localObject, false);
    }
  }
  
  private void g(View paramView)
  {
    boolean bool = true;
    Object localObject = (MarketFaceItemBuilder.Holder)AIOUtils.a(paramView);
    QQAppInterface localQQAppInterface;
    int i;
    if ((((MarketFaceItemBuilder.Holder)localObject).jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo != null) && (((MarketFaceItemBuilder.Holder)localObject).jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.isSound()) && (((MarketFaceItemBuilder.Holder)localObject).jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.isNewSoundType()))
    {
      if (!c(((MarketFaceItemBuilder.Holder)localObject).jdField_a_of_type_ComTencentMobileqqDataChatMessage)) {
        break label119;
      }
      MediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(false);
      localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      i = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int;
      if (((MarketFaceItemBuilder.Holder)localObject).jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon == null) {
        break label112;
      }
    }
    label112:
    for (paramView = ((MarketFaceItemBuilder.Holder)localObject).jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon.epId;; paramView = "")
    {
      EmoticonManager.a(localQQAppInterface, "0X800A934", i, paramView);
      return;
    }
    label119:
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isVideoChatting())
    {
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), 2131695173, 0).b(this.jdField_b_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299166));
      return;
    }
    if ((((MarketFaceItemBuilder.Holder)localObject).jdField_a_of_type_ComTencentMobileqqDataChatMessage instanceof MessageForMarketFace)) {
      ((MessageForMarketFace)((MarketFaceItemBuilder.Holder)localObject).jdField_a_of_type_ComTencentMobileqqDataChatMessage).playProgress = 0.0F;
    }
    ((MarketFaceItemBuilder.Holder)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.setProgress(0.0F);
    if (MediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(((MarketFaceItemBuilder.Holder)localObject).jdField_a_of_type_ComTencentMobileqqDataChatMessage))
    {
      ((MarketFaceItemBuilder.Holder)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView.setPlayState(true);
      localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      i = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int;
      if (((MarketFaceItemBuilder.Holder)localObject).jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon != null)
      {
        paramView = ((MarketFaceItemBuilder.Holder)localObject).jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon.epId;
        EmoticonManager.a(localQQAppInterface, "0X800A933", i, paramView);
      }
    }
    for (;;)
    {
      if (!bool)
      {
        localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        if (((MarketFaceItemBuilder.Holder)localObject).jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon != null)
        {
          paramView = ((MarketFaceItemBuilder.Holder)localObject).jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon.epId;
          label300:
          EmoticonManager.a(localQQAppInterface, "0X800A935", -1, paramView);
        }
      }
      else
      {
        localObject = new HashMap();
        if (!bool) {
          break label390;
        }
      }
      label390:
      for (paramView = "0";; paramView = "1")
      {
        ((HashMap)localObject).put("playResult", paramView);
        ((HashMap)localObject).put("playType", "1");
        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(BaseApplicationImpl.getApplication().getRuntime().getAccount(), "NewAudioEmoticonVoicePlay", bool, 0L, 0L, (HashMap)localObject, null);
        return;
        paramView = "";
        break;
        paramView = "";
        break label300;
      }
      bool = false;
    }
  }
  
  private void h(View paramView)
  {
    MarketFaceItemBuilder.Holder localHolder = (MarketFaceItemBuilder.Holder)AIOUtils.a(paramView);
    Drawable localDrawable = localHolder.jdField_e_of_type_AndroidWidgetImageView.getDrawable();
    URLDrawable localURLDrawable;
    String str;
    if ((localDrawable instanceof URLDrawable))
    {
      localURLDrawable = (URLDrawable)localDrawable;
      str = localURLDrawable.getURL().getHost();
      if (!(localURLDrawable.getTag() instanceof Bundle)) {
        break label252;
      }
      str = ((Bundle)localURLDrawable.getTag()).getString("display_type");
    }
    label252:
    for (;;)
    {
      switch (((URLDrawable)localDrawable).getStatus())
      {
      default: 
        if ((localHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo != null) && (localHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon != null) && (localHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon.jobType == 2) && (MagicfaceViewController.a())) {
          a(localHolder);
        }
        if ((((URLDrawable)localDrawable).getStatus() == 1) || ((localHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo != null) && (localHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon != null) && (localHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.isAioPreviewExists()))) {
          a(localHolder, AnimationUtils.a(paramView));
        }
        break;
      }
      do
      {
        return;
        b(localHolder, localURLDrawable, str);
        break;
        a(localHolder, str);
        break;
      } while ((!(localDrawable instanceof PngFrameDrawable)) || (localHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo == null) || (localHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon == null) || (!localHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.isAioPreviewExists()));
      a(localHolder, AnimationUtils.a(paramView));
      return;
    }
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    return 0;
  }
  
  public View a(ChatMessage paramChatMessage, BaseBubbleBuilder.ViewHolder paramViewHolder, View paramView, BaseChatItemLayout paramBaseChatItemLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    long l = System.currentTimeMillis();
    paramBaseChatItemLayout = (MessageForMarketFace)paramChatMessage;
    MarketFaceItemBuilder.Holder localHolder = (MarketFaceItemBuilder.Holder)paramViewHolder;
    this.jdField_b_of_type_JavaUtilSet.add(localHolder);
    Object localObject2;
    Object localObject3;
    Object localObject1;
    Object localObject4;
    Object localObject5;
    Object localObject6;
    PttAudioPlayView localPttAudioPlayView;
    Object localObject7;
    Object localObject8;
    Object localObject9;
    RelativeLayout localRelativeLayout;
    TriangleView localTriangleView;
    Object localObject10;
    Object localObject11;
    Object localObject12;
    Object localObject13;
    RelativeLayout.LayoutParams localLayoutParams;
    if (paramView == null)
    {
      paramViewHolder = new RelativeLayout(this.jdField_b_of_type_AndroidContentContext);
      localObject2 = new RelativeLayout(this.jdField_b_of_type_AndroidContentContext);
      localObject3 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout)localObject2).setId(2131371055);
      paramView = new ImageView(this.jdField_b_of_type_AndroidContentContext);
      paramView.setId(2131367238);
      localObject1 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject1).addRule(0, 2131364634);
      ((RelativeLayout.LayoutParams)localObject1).addRule(15, 2131364634);
      ((RelativeLayout)localObject2).addView(paramView, (ViewGroup.LayoutParams)localObject1);
      paramView.setOnClickListener(this);
      localObject1 = new FrameLayout(this.jdField_b_of_type_AndroidContentContext);
      ((FrameLayout)localObject1).setId(2131363603);
      localObject4 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject4).leftMargin = 8;
      ((RelativeLayout.LayoutParams)localObject4).addRule(1, 2131367238);
      ((RelativeLayout)localObject2).addView((View)localObject1, (ViewGroup.LayoutParams)localObject4);
      ((FrameLayout)localObject1).setOnClickListener(this);
      ((FrameLayout)localObject1).setOnTouchListener(paramOnLongClickAndTouchListener);
      ((FrameLayout)localObject1).setOnLongClickListener(paramOnLongClickAndTouchListener);
      paramOnLongClickAndTouchListener = new MarketFaceItemBuilder.MarketFaceView(this, this.jdField_b_of_type_AndroidContentContext);
      ((FrameLayout)localObject1).addView(paramOnLongClickAndTouchListener, -2, -2);
      localObject4 = new ImageView(this.jdField_b_of_type_AndroidContentContext);
      localObject5 = new FrameLayout.LayoutParams(-2, -2);
      ((FrameLayout.LayoutParams)localObject5).gravity = 85;
      ((FrameLayout)localObject1).addView((View)localObject4, (ViewGroup.LayoutParams)localObject5);
      localObject5 = new ImageView(this.jdField_b_of_type_AndroidContentContext);
      ((ImageView)localObject5).setId(2131381749);
      localObject6 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject6).addRule(1, 2131363603);
      ((RelativeLayout.LayoutParams)localObject6).addRule(8, 2131363603);
      ((RelativeLayout.LayoutParams)localObject6).leftMargin = 10;
      ((RelativeLayout)localObject2).addView((View)localObject5, (ViewGroup.LayoutParams)localObject6);
      ((ImageView)localObject5).setOnClickListener(this);
      localObject6 = new BreathAnimationLayout(this.jdField_b_of_type_AndroidContentContext);
      ((BreathAnimationLayout)localObject6).setId(2131372230);
      localPttAudioPlayView = new PttAudioPlayView(this.jdField_b_of_type_AndroidContentContext, 10);
      localPttAudioPlayView.setThemeColor(this.jdField_b_of_type_AndroidContentContext.getResources().getColorStateList(2131167052).getDefaultColor());
      localPttAudioPlayView.setId(2131372232);
      localPttAudioPlayView.setPttPauseOrStopDrawable(2130838330);
      localObject7 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject7).addRule(15, -1);
      ((RelativeLayout.LayoutParams)localObject7).leftMargin = AIOUtils.a(5.0F, this.jdField_b_of_type_AndroidContentContext.getResources());
      ((RelativeLayout.LayoutParams)localObject7).width = AIOUtils.a(25.0F, this.jdField_b_of_type_AndroidContentContext.getResources());
      ((RelativeLayout.LayoutParams)localObject7).height = AIOUtils.a(25.0F, this.jdField_b_of_type_AndroidContentContext.getResources());
      localPttAudioPlayView.setLayoutParams((ViewGroup.LayoutParams)localObject7);
      localPttAudioPlayView.setOnClickListener(this);
      localObject7 = new ImageView(this.jdField_b_of_type_AndroidContentContext);
      localObject8 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject8).addRule(15, -1);
      ((RelativeLayout.LayoutParams)localObject8).leftMargin = AIOUtils.a(5.0F, this.jdField_b_of_type_AndroidContentContext.getResources());
      ((RelativeLayout.LayoutParams)localObject8).width = AIOUtils.a(20.0F, this.jdField_b_of_type_AndroidContentContext.getResources());
      ((RelativeLayout.LayoutParams)localObject8).height = AIOUtils.a(20.0F, this.jdField_b_of_type_AndroidContentContext.getResources());
      ((ImageView)localObject7).setLayoutParams((ViewGroup.LayoutParams)localObject8);
      ((ImageView)localObject7).setImageDrawable((Drawable)this.jdField_b_of_type_AndroidContentContext.getResources().getDrawable(2130839543));
      ((ImageView)localObject7).setVisibility(4);
      localObject8 = new PttAudioWaveView(this.jdField_b_of_type_AndroidContentContext);
      ((PttAudioWaveView)localObject8).setShowProgressLine(false);
      ((PttAudioWaveView)localObject8).setMaxTopBottomPadding(4);
      ((PttAudioWaveView)localObject8).setProgressColor(this.jdField_b_of_type_AndroidContentContext.getResources().getColorStateList(2131167052).getDefaultColor());
      ((PttAudioWaveView)localObject8).setId(2131372233);
      localObject9 = new RelativeLayout.LayoutParams(-1, -1);
      ((RelativeLayout.LayoutParams)localObject9).addRule(15, -1);
      ((RelativeLayout.LayoutParams)localObject9).addRule(1, 2131372232);
      ((RelativeLayout.LayoutParams)localObject9).width = AIOUtils.a(39.0F, this.jdField_b_of_type_AndroidContentContext.getResources());
      ((RelativeLayout.LayoutParams)localObject9).height = AIOUtils.a(45.0F, this.jdField_b_of_type_AndroidContentContext.getResources());
      ((RelativeLayout.LayoutParams)localObject9).leftMargin = ViewUtils.a(9.0F);
      ((RelativeLayout.LayoutParams)localObject9).rightMargin = ViewUtils.a(12.0F);
      ((PttAudioWaveView)localObject8).setLayoutParams((ViewGroup.LayoutParams)localObject9);
      ((PttAudioWaveView)localObject8).setCanSupportSlide(false);
      ((PttAudioWaveView)localObject8).setOnClickListener(this);
      localObject9 = new SyncParentPressedRelativeLayout(this.jdField_b_of_type_AndroidContentContext);
      ((RelativeLayout)localObject9).setId(2131372231);
      ((RelativeLayout)localObject9).addView((View)localObject8);
      ((RelativeLayout)localObject9).addView(localPttAudioPlayView);
      ((RelativeLayout)localObject9).addView((View)localObject7);
      localRelativeLayout = new RelativeLayout(this.jdField_b_of_type_AndroidContentContext);
      localTriangleView = new TriangleView(this.jdField_b_of_type_AndroidContentContext);
      localObject10 = new RelativeLayout.LayoutParams(ViewUtils.a(9.0F), ViewUtils.a(5.0F));
      ((RelativeLayout.LayoutParams)localObject10).leftMargin = ViewUtils.a(2.0F);
      ((RelativeLayout.LayoutParams)localObject10).addRule(14);
      ((RelativeLayout.LayoutParams)localObject10).addRule(10);
      localTriangleView.setId(2131373284);
      localTriangleView.setRotation(180.0F);
      localTriangleView.setTranslationY(ViewUtils.a(1.0F));
      localTriangleView.setLayoutParams((ViewGroup.LayoutParams)localObject10);
      localRelativeLayout.addView(localTriangleView);
      localObject10 = new RelativeLayout.LayoutParams(-2, ViewUtils.a(29.0F));
      ((RelativeLayout.LayoutParams)localObject10).addRule(3, 2131373284);
      localRelativeLayout.addView((View)localObject9, (ViewGroup.LayoutParams)localObject10);
      ((BreathAnimationLayout)localObject6).addView(localRelativeLayout);
      localObject10 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject10).addRule(14, 2131363603);
      ((RelativeLayout.LayoutParams)localObject10).addRule(3, 2131363603);
      ((RelativeLayout.LayoutParams)localObject10).bottomMargin = ViewUtils.a(17.0F);
      ((RelativeLayout)localObject2).addView((View)localObject6, (ViewGroup.LayoutParams)localObject10);
      localObject10 = new ImageView(this.jdField_b_of_type_AndroidContentContext);
      ((ImageView)localObject10).setId(2131367239);
      localObject11 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject11).addRule(1, 2131363603);
      ((RelativeLayout.LayoutParams)localObject11).addRule(15, 2131363603);
      ((RelativeLayout.LayoutParams)localObject11).leftMargin = 10;
      ((RelativeLayout)localObject2).addView((View)localObject10, (ViewGroup.LayoutParams)localObject11);
      ((ImageView)localObject10).setOnClickListener(this);
      localObject11 = new DuiButtonImageView(this.jdField_b_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
      ((DuiButtonImageView)localObject11).setId(2131366075);
      localObject12 = new RelativeLayout.LayoutParams(AIOUtils.a(50.0F, this.jdField_b_of_type_AndroidContentContext.getResources()), AIOUtils.a(50.0F, this.jdField_b_of_type_AndroidContentContext.getResources()));
      ((RelativeLayout.LayoutParams)localObject12).addRule(1, 2131363603);
      ((RelativeLayout.LayoutParams)localObject12).addRule(8, 2131363603);
      ((RelativeLayout.LayoutParams)localObject12).setMargins(0, 0, 0, -AIOUtils.a(6.5F, this.jdField_b_of_type_AndroidContentContext.getResources()));
      ((RelativeLayout)localObject2).addView((View)localObject11, (ViewGroup.LayoutParams)localObject12);
      localObject12 = new ImageView(this.jdField_b_of_type_AndroidContentContext);
      ((ImageView)localObject12).setId(2131370968);
      localObject13 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject13).addRule(1, 2131363603);
      ((RelativeLayout.LayoutParams)localObject13).addRule(8, 2131363603);
      ((RelativeLayout.LayoutParams)localObject13).leftMargin = AIOUtils.a(10.0F, this.jdField_b_of_type_AndroidContentContext.getResources());
      ((RelativeLayout)localObject2).addView((View)localObject12, (ViewGroup.LayoutParams)localObject13);
      localObject13 = new TextView(this.jdField_b_of_type_AndroidContentContext);
      localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      ((TextView)localObject13).setTextSize(12.0F);
      ((TextView)localObject13).setTextColor(-1);
      localLayoutParams.topMargin = AIOUtils.a(8.0F, this.jdField_b_of_type_AndroidContentContext.getResources());
      ((TextView)localObject13).setGravity(17);
      localLayoutParams.addRule(3, 2131371055);
    }
    for (;;)
    {
      try
      {
        ((TextView)localObject13).setBackgroundDrawable(this.jdField_b_of_type_AndroidContentContext.getResources().getDrawable(2130844888));
        ((TextView)localObject13).setPadding(AIOUtils.a(9.0F, this.jdField_b_of_type_AndroidContentContext.getResources()), AIOUtils.a(4.0F, this.jdField_b_of_type_AndroidContentContext.getResources()), AIOUtils.a(9.0F, this.jdField_b_of_type_AndroidContentContext.getResources()), AIOUtils.a(4.0F, this.jdField_b_of_type_AndroidContentContext.getResources()));
        paramViewHolder.addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
        paramViewHolder.addView((View)localObject13, localLayoutParams);
        ((ImageView)localObject12).setOnClickListener(this);
        localObject2 = new ProgressBar(this.jdField_b_of_type_AndroidContentContext, null, 0);
        ((ProgressBar)localObject2).setId(2131364661);
      }
      catch (Exception localException2)
      {
        try
        {
          ((ProgressBar)localObject2).setIndeterminateDrawable(this.jdField_b_of_type_AndroidContentContext.getResources().getDrawable(2130839545));
          int i = AIOUtils.a(16.0F, this.jdField_b_of_type_AndroidContentContext.getResources());
          localObject3 = new FrameLayout.LayoutParams(i, i);
          ((FrameLayout.LayoutParams)localObject3).gravity = 17;
          ((FrameLayout)localObject1).addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
          localHolder.jdField_e_of_type_AndroidWidgetImageView = paramOnLongClickAndTouchListener;
          localHolder.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localObject4);
          localHolder.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)localObject5);
          localHolder.jdField_c_of_type_AndroidWidgetImageView = paramView;
          localHolder.d = ((ImageView)localObject10);
          localHolder.jdField_a_of_type_ComTencentMobileqqDoutuDuiButtonImageView = ((DuiButtonImageView)localObject11);
          localHolder.f = ((ImageView)localObject12);
          localHolder.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)localObject1);
          localHolder.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)localObject2);
          localHolder.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localObject13);
          localHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemBreathAnimationLayout = ((BreathAnimationLayout)localObject6);
          localHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView = localPttAudioPlayView;
          localHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView = ((PttAudioWaveView)localObject8);
          localHolder.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localObject9);
          localHolder.jdField_b_of_type_AndroidWidgetRelativeLayout = localRelativeLayout;
          localHolder.jdField_a_of_type_ComTencentMobileqqActivityContactConnectionsTriangleView = localTriangleView;
          localHolder.g = ((ImageView)localObject7);
          if (!c(paramChatMessage)) {
            paramBaseChatItemLayout.playProgress = 0.0F;
          }
          a(localHolder, paramChatMessage.uniseq);
          localHolder.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
          localHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.setProgress(paramBaseChatItemLayout.playProgress);
          if ((AppSetting.d) && (a(paramChatMessage, localHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout)) && (localHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.jdField_c_of_type_AndroidWidgetImageView != null)) {
            localHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.jdField_c_of_type_AndroidWidgetImageView.setContentDescription(HardCodeUtil.a(2131706481));
          }
          new QueryTask(new MarketFaceItemBuilder.3(this, localHolder), new MarketFaceItemBuilder.4(this, localHolder, paramBaseChatItemLayout, paramChatMessage, l)).a(paramBaseChatItemLayout.mMarkFaceMessage);
          return paramViewHolder;
          localException2 = localException2;
          QLog.e("MarketFaceItemBuilder", 1, "getBubbleView: ", localException2);
        }
        catch (Exception localException1)
        {
          QLog.e("MarketFaceItemBuilder", 1, "getBubbleView: ", localException1);
          continue;
        }
      }
      if ((localHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo != null) && (localHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.isSound()) && (localHolder.jdField_b_of_type_AndroidWidgetImageView != null) && ((localHolder.jdField_b_of_type_AndroidWidgetImageView.getDrawable() instanceof AnimationDrawable))) {
        localHolder.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130847495);
      }
      paramViewHolder = paramView;
      if (AppSetting.d)
      {
        localHolder.jdField_a_of_type_AndroidWidgetFrameLayout.setContentDescription("");
        paramViewHolder = paramView;
      }
    }
  }
  
  public BaseBubbleBuilder.ViewHolder a()
  {
    return new MarketFaceItemBuilder.Holder();
  }
  
  public String a(ChatMessage paramChatMessage)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if ((paramChatMessage != null) && ((paramChatMessage instanceof MessageForMarketFace)))
    {
      if (!MessageRecordInfo.a(paramChatMessage.issend)) {
        break label104;
      }
      localStringBuilder.append("发出表情");
    }
    for (;;)
    {
      paramChatMessage = (MessageForMarketFace)paramChatMessage;
      if (paramChatMessage.mMarkFaceMessage != null)
      {
        paramChatMessage = ((EmoticonManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.EMOTICON_MANAGER)).a(paramChatMessage.mMarkFaceMessage);
        if (paramChatMessage != null)
        {
          paramChatMessage = paramChatMessage.emoticon;
          if ((paramChatMessage != null) && (paramChatMessage.name != null)) {
            localStringBuilder.append(paramChatMessage.name);
          }
        }
      }
      return localStringBuilder.toString();
      label104:
      localStringBuilder.append("发来表情");
    }
  }
  
  public void a()
  {
    EmojiListenerManager.a().b(this.jdField_a_of_type_ComTencentMobileqqEmoticonEmoticonPackageDownloadListener);
    EmojiListenerManager.a().b(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemMarketFaceItemBuilder$EmoticonDetailJsonDownloaderVars);
    Iterator localIterator = this.jdField_b_of_type_JavaUtilSet.iterator();
    while (localIterator.hasNext()) {
      ((MarketFaceItemBuilder.Holder)localIterator.next()).a();
    }
    this.jdField_b_of_type_JavaUtilSet.clear();
    this.jdField_a_of_type_JavaUtilSet.clear();
    this.jdField_b_of_type_JavaUtilSet = null;
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    if ((jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo == null) || (jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon == null))
    {
      QLog.e("MarketFaceItemBuilder", 1, "onMenuItemClicked emoticon is null");
      return;
    }
    if ((paramInt == 2131365636) || (paramInt == 2131362218) || (paramInt == 2131367415) || (paramInt == 2131367136) || (paramInt == 2131371953))
    {
      a(paramInt, paramChatMessage);
      return;
    }
    super.a(paramInt, paramContext, paramChatMessage);
  }
  
  protected void a(int paramInt, ChatMessage paramChatMessage)
  {
    ((EmoticonManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.EMOTICON_MANAGER)).a(jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon.epId, new MarketFaceItemBuilder.2(this, paramInt, paramChatMessage));
  }
  
  public void a(View paramView)
  {
    paramView = (MarketFaceItemBuilder.Holder)AIOUtils.a(paramView);
    String str1;
    String str2;
    if (paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage.isSendFromLocal())
    {
      str1 = this.jdField_b_of_type_AndroidContentContext.getString(2131690018);
      str2 = this.jdField_b_of_type_AndroidContentContext.getString(2131690019);
      if ((paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage.sendFailCode == 41) && (paramView.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo != null) && (paramView.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon != null)) {
        a((MessageForMarketFace)paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage, paramView.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo);
      }
    }
    do
    {
      return;
      DialogUtil.a(this.jdField_b_of_type_AndroidContentContext, 230, str1, str2, new MarketFaceItemBuilder.9(this, paramView), new MarketFaceItemBuilder.10(this)).show();
      return;
      paramView = paramView.jdField_e_of_type_AndroidWidgetImageView.getDrawable();
    } while (!(paramView instanceof URLDrawable));
    ((URLDrawable)paramView).restartDownload();
  }
  
  public void a(View paramView, ChatMessage paramChatMessage)
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
    for (;;)
    {
      String str = paramString;
      if (TextUtils.isEmpty(paramString))
      {
        str = paramString;
        if ((paramURLDrawable.getStateTag() instanceof Bundle)) {
          str = ((Bundle)paramURLDrawable.getStateTag()).getString("display_type");
        }
      }
      if ("aio_preview".equals(str)) {
        if (paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.isSound()) {
          if (paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.isNewSoundType()) {
            paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemBreathAnimationLayout.setVisibility(0);
          }
        }
      }
      while (!"big_sound".equals(str))
      {
        do
        {
          return;
          paramHolder.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130847495);
          paramHolder.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
          return;
        } while ((i != 1) || (paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.imageType != 3));
        paramHolder.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130838122);
        paramHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        paramHolder.jdField_b_of_type_Boolean = true;
        return;
      }
      if (c(paramHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage))
      {
        if (paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.isNewSoundType())
        {
          paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemBreathAnimationLayout.setVisibility(0);
          paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView.setPlayState(true);
          return;
        }
        paramHolder.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
        paramURLDrawable = (AnimationDrawable)this.jdField_b_of_type_AndroidContentContext.getResources().getDrawable(2130772280);
        paramHolder.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(paramURLDrawable);
        paramURLDrawable.start();
        return;
      }
      if (paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.isNewSoundType())
      {
        paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemBreathAnimationLayout.setVisibility(0);
        paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView.setPlayState(false);
        return;
      }
      paramHolder.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130847495);
      paramHolder.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      return;
    }
  }
  
  protected void a(EmoticonPackage paramEmoticonPackage, String paramString, int paramInt)
  {
    QQProgressDialog localQQProgressDialog = a();
    if (localQQProgressDialog != null)
    {
      localQQProgressDialog.a(this.jdField_b_of_type_AndroidContentContext.getString(2131692006));
      localQQProgressDialog.show();
    }
    a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin, "ep_mall", "Clk_collect", 0);
    if ((jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo != null) && (jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon != null)) {
      EmoticonUtils.reportFavAddEmotionEvent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, null, jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon.eId);
    }
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006448", "0X8006448", 0, 0, "4", paramString, paramInt + "", "");
    QQAppInterface localQQAppInterface;
    if ((jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo != null) && (jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.isNewSoundType()))
    {
      localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      paramInt = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int;
      if (jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon == null) {
        break label268;
      }
    }
    label268:
    for (paramString = jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon.epId;; paramString = "")
    {
      EmoticonManager.a(localQQAppInterface, "0X800A939", paramInt, paramString);
      if ((paramEmoticonPackage == null) || (paramEmoticonPackage.name == null) || ((paramEmoticonPackage.mobileFeetype == 0) && (paramEmoticonPackage.downloadCount == 0))) {
        break label299;
      }
      paramInt = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().getInt("emosm_json_last_download_timestamp", 0);
      int i = (int)(System.currentTimeMillis() / 1000L);
      if ((i - paramInt <= 86400) && (i >= paramInt)) {
        break;
      }
      a(6);
      return;
    }
    a(6, this.jdField_b_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramEmoticonPackage, jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, localQQProgressDialog);
    return;
    label299:
    a(6);
  }
  
  protected void a(EmoticonPackage paramEmoticonPackage, String paramString, int paramInt1, int paramInt2)
  {
    QQProgressDialog localQQProgressDialog = a();
    if (paramInt2 == 2131367415)
    {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "ep_mall", "aio_trans_bq", 0, 0, "4", paramString, paramInt1 + "", "");
      if ((2 == jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon.jobType) && (!this.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiManager.c()))
      {
        ChatActivityUtils.a(this.jdField_b_of_type_AndroidContentContext, 2131690017, 0);
        return;
      }
      jdField_c_of_type_Int = 1;
      a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin, "ep_mall", "Clk_button_forward_aio", 0);
      paramString = this.jdField_b_of_type_AndroidContentContext.getString(2131692009);
    }
    for (paramInt1 = 7;; paramInt1 = 107)
    {
      if (localQQProgressDialog != null)
      {
        localQQProgressDialog.a(paramString);
        localQQProgressDialog.show();
      }
      if (paramEmoticonPackage != null) {
        break;
      }
      a(paramInt1);
      return;
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006449", "0X8006449", 0, 0, "4", "", "", "");
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1) && (((TroopGagMgr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_GAG_MANAGER)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, true).jdField_a_of_type_Boolean))
      {
        ChatActivityUtils.a(this.jdField_b_of_type_AndroidContentContext, 2131697388, 0);
        return;
      }
      paramString = this.jdField_b_of_type_AndroidContentContext.getString(2131692008);
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "ep_mall", "Clk_button_follow_aio", 0, 0, "", jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon.epId, "", "");
    }
    a(paramInt1, this.jdField_b_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramEmoticonPackage, jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, localQQProgressDialog);
  }
  
  protected void a(MessageForMarketFace paramMessageForMarketFace, PicEmoticonInfo paramPicEmoticonInfo)
  {
    if ((paramMessageForMarketFace == null) || (paramPicEmoticonInfo == null) || (paramPicEmoticonInfo.emoticon == null) || (paramPicEmoticonInfo.emoticon.epId == null)) {
      return;
    }
    ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(this.jdField_b_of_type_AndroidContentContext, null);
    localActionSheet.setMainTitle(this.jdField_b_of_type_AndroidContentContext.getString(2131692004));
    localActionSheet.addButton(this.jdField_b_of_type_AndroidContentContext.getResources().getString(2131692003), 1);
    localActionSheet.addButton(this.jdField_b_of_type_AndroidContentContext.getResources().getString(2131692005), 1);
    localActionSheet.addCancelButton(2131690800);
    localActionSheet.setOnButtonClickListener(new MarketFaceItemBuilder.11(this, paramPicEmoticonInfo, localActionSheet, paramMessageForMarketFace));
    localActionSheet.show();
  }
  
  protected void a(QQCustomMenu paramQQCustomMenu)
  {
    if ((jdField_a_of_type_ComTencentMobileqqDataChatMessage == null) || (jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon == null)) {}
    label135:
    for (;;)
    {
      return;
      if (jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon.jobType == 0) {}
      for (int i = 1;; i = 0)
      {
        if ((i == 0) || (!EmoticonUtils.isShowRelatedEmoInAio(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int))) {
          break label135;
        }
        AIORelatedEmotionConfProcessor.RelatedEmotionConfigBean localRelatedEmotionConfigBean = AIORelatedEmotionConfProcessor.a();
        if ((localRelatedEmotionConfigBean == null) || (!localRelatedEmotionConfigBean.a())) {
          break;
        }
        paramQQCustomMenu.a(2131371953, this.jdField_b_of_type_AndroidContentContext.getString(2131718515), 2130839067);
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "0X800B114", "0X800B114", EmoticonUtils.getRelatedEmotionReportFromType(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int), 0, "", "", "", "");
        return;
      }
    }
  }
  
  public void a(XListView paramXListView, int paramInt, View paramView, ChatMessage paramChatMessage, long paramLong, float paramFloat)
  {
    if ((paramView != null) && (paramFloat > 0.0F))
    {
      paramXListView = (MarketFaceItemBuilder.Holder)AIOUtils.a(paramView);
      if ((paramXListView != null) && (paramXListView.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo != null) && (paramXListView.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.isSound()) && (paramXListView.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.isNewSoundType()) && (c(paramChatMessage)))
      {
        QLog.i("MarketFaceItemBuilder", 2, "AudioPlayer onPlayProgress progress_ratio = " + paramFloat);
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
      if (!paramXListView.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.isNewSoundType()) {
        break label66;
      }
      paramXListView.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.setProgress(0.0F);
      if (paramXListView.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView != null) {
        paramXListView.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView.setPlayState(false);
      }
    }
    for (;;)
    {
      paramView = paramXListView.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.getLoadingDrawable("fromAIO", false);
      paramXListView.jdField_e_of_type_AndroidWidgetImageView.setImageDrawable(paramView);
      return;
      label66:
      paramXListView.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130847495);
    }
  }
  
  public boolean a(BaseBubbleBuilder.ViewHolder paramViewHolder)
  {
    return paramViewHolder instanceof MarketFaceItemBuilder.Holder;
  }
  
  public boolean a(MarketFaceItemBuilder.Holder paramHolder)
  {
    return paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo != null;
  }
  
  public boolean a(XListView paramXListView, int paramInt, View paramView, ChatMessage paramChatMessage)
  {
    return false;
  }
  
  public boolean a(XListView paramXListView, int paramInt1, View paramView, ChatMessage paramChatMessage, AudioPlayerBase paramAudioPlayerBase, int paramInt2)
  {
    paramXListView = (MarketFaceItemBuilder.Holder)AIOUtils.a(paramView);
    if ((paramXListView == null) || (paramXListView.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo == null) || (paramXListView.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon == null)) {
      return false;
    }
    if (paramXListView.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.isSound())
    {
      paramView = EmoticonUtils.emoticonSoundPath.replace("[epId]", paramXListView.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon.epId).replace("[eId]", paramXListView.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon.eId);
      if (!FileUtils.b(paramView))
      {
        if (this.jdField_a_of_type_JavaUtilSet.contains(Long.valueOf(paramChatMessage.uniseq))) {
          return false;
        }
        this.jdField_a_of_type_JavaUtilSet.add(Long.valueOf(paramChatMessage.uniseq));
        a(paramXListView, paramChatMessage.uniseq);
        ThreadManager.getFileThreadHandler().post(new MarketFaceItemBuilder.8(this, paramXListView, paramChatMessage));
        return false;
      }
      paramAudioPlayerBase.b(4);
      if (paramAudioPlayerBase.a(paramView))
      {
        paramView = paramXListView.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.getLoadingDrawable("fromAIO", true);
        paramXListView.jdField_e_of_type_AndroidWidgetImageView.setImageDrawable(paramView);
        EmotionUtils.startSoundDrawablePlay(paramView);
        if (paramXListView.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.isNewSoundType()) {
          if (paramXListView.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView != null) {
            paramXListView.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView.setPlayState(true);
          }
        }
        for (;;)
        {
          return true;
          paramView = (AnimationDrawable)this.jdField_b_of_type_AndroidContentContext.getResources().getDrawable(2130772280);
          paramXListView.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(paramView);
          paramView.start();
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
    if (ApolloGameUtil.a(jdField_a_of_type_ComTencentMobileqqDataChatMessage)) {
      return localQQCustomMenu.a();
    }
    Object localObject;
    if ((jdField_a_of_type_ComTencentMobileqqDataChatMessage instanceof MessageForMarketFace))
    {
      localObject = (MessageForMarketFace)jdField_a_of_type_ComTencentMobileqqDataChatMessage;
      if ((((MessageForMarketFace)localObject).mMarkFaceMessage == null) || (((MessageForMarketFace)localObject).mMarkFaceMessage.stickerInfo == null)) {}
    }
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        if (paramView.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon.jobType != 1)
        {
          jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo = paramView.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo;
          if (AIOUtils.a(1) == 1) {
            localQQCustomMenu.a(2131362218, this.jdField_b_of_type_AndroidContentContext.getString(2131693294), 2130839057);
          }
          a(localQQCustomMenu);
          localQQCustomMenu.a(2131367415, this.jdField_b_of_type_AndroidContentContext.getString(2131692687), 2130839059);
          a(localQQCustomMenu, this.jdField_b_of_type_AndroidContentContext, 2131376927, jdField_a_of_type_ComTencentMobileqqDataChatMessage, null);
          if ((paramView.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon.jobType != 2) && (paramView.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon.jobType != 4)) {
            localQQCustomMenu.a(2131367136, this.jdField_b_of_type_AndroidContentContext.getString(2131693301), 2130839035);
          }
          a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin, "ep_mall", "Ap_show_forward", 0);
        }
        if ((paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage.extraflag != 32768) && (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgCache().b(paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage))) {
          a(localQQCustomMenu, this.jdField_b_of_type_AndroidContentContext, 2131371954, paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage, new Bundle());
        }
        a(localQQCustomMenu, this.jdField_b_of_type_AndroidContentContext, 2131365636, paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage, new Bundle());
        localObject = new Bundle();
        ((Bundle)localObject).putBoolean("isSearch", false);
        super.a(localQQCustomMenu, this.jdField_b_of_type_AndroidContentContext, 2131380949, jdField_a_of_type_ComTencentMobileqqDataChatMessage, (Bundle)localObject);
        if (paramView.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon.jobType != 1) {
          a(localQQCustomMenu, this.jdField_b_of_type_AndroidContentContext, 2131376940, jdField_a_of_type_ComTencentMobileqqDataChatMessage, null);
        }
        super.a(localQQCustomMenu, this.jdField_b_of_type_AndroidContentContext, 2131371997, null, null);
        super.a(localQQCustomMenu, this.jdField_b_of_type_AndroidContentContext, 2131362524, null, null);
      }
      for (;;)
      {
        return localQQCustomMenu.a();
        jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo = paramView.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo;
        ChatActivityFacade.a(localQQCustomMenu, this.jdField_b_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
      }
    }
  }
  
  protected void b(ChatMessage paramChatMessage)
  {
    Object localObject = ((FragmentActivity)this.jdField_b_of_type_AndroidContentContext).getChatFragment();
    if (localObject != null)
    {
      localObject = ((ChatFragment)localObject).a();
      if (localObject != null) {
        ((AIORelatedEmotionHelper)((BaseChatPie)localObject).a(72)).a(paramChatMessage, jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.getLoadingDrawable("fromAIO", false));
      }
    }
    while (!QLog.isColorLevel())
    {
      do
      {
        return;
      } while (!QLog.isColorLevel());
      QLog.d("MarketFaceItemBuilder", 2, "[Related_Emotion] curPie is null.");
      return;
    }
    QLog.d("MarketFaceItemBuilder", 2, "[Related_Emotion] chatFragment is null.");
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
    if (paramView.getId() == 2131363603)
    {
      h(paramView);
      return;
    }
    if (paramView.getId() == 2131381749) {
      e(paramView);
    }
    for (;;)
    {
      super.onClick(paramView);
      return;
      if ((paramView.getId() == 2131372232) || (paramView.getId() == 2131372233)) {
        g(paramView);
      } else if ((paramView.getId() == 2131367239) || (paramView.getId() == 2131367238)) {
        d(paramView);
      } else if (paramView.getId() == 2131366075) {
        e();
      } else if (paramView.getId() == 2131370968) {
        f(paramView);
      }
    }
  }
  
  protected void d(View paramView)
  {
    paramView = (MarketFaceItemBuilder.Holder)AIOUtils.a(paramView);
    QQProgressDialog localQQProgressDialog = a();
    if (localQQProgressDialog != null)
    {
      localQQProgressDialog.a(this.jdField_b_of_type_AndroidContentContext.getString(2131692008));
      localQQProgressDialog.show();
    }
    ((EmoticonManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.EMOTICON_MANAGER)).a(paramView.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon.epId, new MarketFaceItemBuilder.1(this, paramView, localQQProgressDialog));
  }
  
  protected void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MarketFaceItemBuilder", 2, "[Doutu] Dui Button Clicked.");
    }
    Object localObject = ((FragmentActivity)this.jdField_b_of_type_AndroidContentContext).getChatFragment();
    if (localObject != null)
    {
      localObject = ((ChatFragment)localObject).a();
      if (localObject != null)
      {
        ((BaseChatPie)localObject).a().obtainMessage(79, null).sendToTarget();
        DoutuConfigReporter.b();
      }
    }
    while (!QLog.isColorLevel())
    {
      do
      {
        return;
      } while (!QLog.isColorLevel());
      QLog.d("MarketFaceItemBuilder", 2, "[Doutu] curPie is null.");
      return;
    }
    QLog.d("MarketFaceItemBuilder", 2, "[Doutu] chatFragment is null.");
  }
  
  protected void e(View paramView)
  {
    paramView = (MarketFaceItemBuilder.Holder)AIOUtils.a(paramView);
    if ((paramView.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo != null) && (paramView.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.isSound()))
    {
      if (c(paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage)) {
        MediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(false);
      }
    }
    else {
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isVideoChatting())
    {
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), 2131695173, 0).b(this.jdField_b_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299166));
      return;
    }
    MediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage);
  }
  
  public void onClick(View paramView)
  {
    c(paramView);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.MarketFaceItemBuilder
 * JD-Core Version:    0.7.0.1
 */