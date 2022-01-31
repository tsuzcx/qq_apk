package com.tencent.mobileqq.activity.aio.item;

import acjm;
import aepi;
import aeqh;
import aeqi;
import aeql;
import aeqz;
import aesa;
import aetk;
import afyf;
import agbb;
import agbc;
import agbd;
import agbe;
import agbf;
import agbg;
import agbh;
import agbi;
import agjb;
import ajpy;
import ajst;
import akci;
import akcn;
import akco;
import alud;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.app.FragmentActivity;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import apkp;
import aryv;
import auqc;
import awge;
import awgf;
import awji;
import axaz;
import axba;
import axpm;
import axtc;
import axwx;
import azdd;
import azdf;
import azdg;
import azdo;
import azdx;
import azep;
import azgd;
import azib;
import azjh;
import azla;
import azqs;
import azun;
import barf;
import bass;
import bayf;
import bayu;
import bdeu;
import bdew;
import bdhb;
import bdin;
import bdpi;
import bdpk;
import bhuf;
import bhus;
import biqe;
import biva;
import bivo;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.Utils;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.MultiForwardActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.MediaPlayerManager;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.activity.aio.photo.AIOImageProviderService;
import com.tencent.mobileqq.activity.chathistory.ChatHistoryBubbleListForTroopFragment;
import com.tencent.mobileqq.activity.history.ChatHistoryActivity;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForReplyText;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.flashchat.FlashChatManager;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.transfile.ShortVideoUploadProcessor;
import com.tencent.mobileqq.videoplatform.api.VideoPlayParam;
import com.tencent.mobileqq.videoplatform.view.CropBubbleVideoView;
import com.tencent.mobileqq.widget.BubbleImageView;
import com.tencent.mobileqq.widget.MessageProgressView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_SDKMgr;
import com.tencent.widget.ListView;
import java.io.File;
import java.lang.ref.WeakReference;
import java.net.URL;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;
import wxj;
import xpq;
import zjc;

public class ShortVideoRealItemBuilder
  extends afyf
  implements aeql, aesa, azdf
{
  protected static ColorDrawable a;
  private static HashMap<String, String> jdField_a_of_type_JavaUtilHashMap;
  private static Map<Long, MessageForShortVideo> jdField_a_of_type_JavaUtilMap;
  public static CopyOnWriteArraySet<CropBubbleVideoView> a;
  public static int c;
  public static int d;
  private static long d;
  protected static int e;
  protected static int f;
  public static boolean f;
  protected static int g;
  private static boolean g;
  protected static int h;
  private static boolean h;
  protected static int i;
  private akcn jdField_a_of_type_Akcn = new agbh(this);
  private MessageForShortVideo jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo;
  private ListView jdField_a_of_type_ComTencentWidgetListView;
  private Handler b;
  public long c;
  
  static
  {
    bayu.b();
    jdField_f_of_type_Boolean = true;
    jdField_c_of_type_Int = 960;
    jdField_d_of_type_Int = 720;
    jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap();
    jdField_a_of_type_JavaUtilHashMap = new HashMap();
    jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet = new CopyOnWriteArraySet();
    Resources localResources = BaseApplicationImpl.sApplication.getResources();
    jdField_g_of_type_Int = BaseChatItemLayout.jdField_e_of_type_Int;
    jdField_g_of_type_Int = Math.min(aepi.a(320.0F, localResources), jdField_g_of_type_Int);
    jdField_h_of_type_Int = aepi.a(100.0F, localResources);
    i = aepi.a(100.0F, localResources);
    jdField_e_of_type_Int = aepi.a(azib.l, localResources);
    jdField_f_of_type_Int = aepi.a(azib.m, localResources);
    jdField_a_of_type_AndroidGraphicsDrawableColorDrawable = new apkp(-10065297, jdField_e_of_type_Int, jdField_f_of_type_Int);
  }
  
  public ShortVideoRealItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    this.jdField_b_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    this.jdField_c_of_type_Long = 0L;
    if (paramAIOAnimationConatiner != null) {
      this.jdField_a_of_type_ComTencentWidgetListView = paramAIOAnimationConatiner.a();
    }
    ShortVideoUtils.a(paramQQAppInterface);
    azep.a();
    h();
  }
  
  public static List<? extends awge> a(awgf paramawgf, Class<? extends awge> paramClass, String paramString1, String paramString2, String[] paramArrayOfString)
  {
    return paramawgf.a(paramClass, paramString1, false, paramString2, paramArrayOfString, null, null, null, null, null);
  }
  
  private void a(long paramLong)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder().append("doEncodeNext, curMsg:");
      if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo != null)
      {
        localObject = Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.uniseq);
        QLog.i("ShortVideoRealItemBuilder", 2, localObject + ", seq:" + paramLong + ", contains:" + akci.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(Long.valueOf(paramLong)));
      }
    }
    else
    {
      akci.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(Long.valueOf(paramLong));
      if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo != null) {
        jdField_a_of_type_JavaUtilMap.remove(Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.uniseq));
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo != null) && (this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.progressTask != null)) {
        this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.progressTask = null;
      }
      jdField_h_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo = null;
      if (jdField_a_of_type_JavaUtilMap.size() != 0)
      {
        localObject = jdField_a_of_type_JavaUtilMap.entrySet().iterator();
        if (!((Iterator)localObject).hasNext()) {
          break label303;
        }
      }
    }
    label303:
    for (Object localObject = (MessageForShortVideo)((Map.Entry)((Iterator)localObject).next()).getValue();; localObject = null)
    {
      if (localObject != null)
      {
        ThreadManager.postImmediately(new ShortVideoRealItemBuilder.9(this, (MessageForShortVideo)localObject), null, true);
        jdField_a_of_type_JavaUtilMap.remove(Long.valueOf(((MessageForShortVideo)localObject).uniseq));
        if (QLog.isColorLevel()) {
          QLog.i("ShortVideoRealItemBuilder", 2, "messageMap size:" + jdField_a_of_type_JavaUtilMap.size() + ", [" + ((MessageForShortVideo)localObject).uniseq + "] start upload!");
        }
      }
      return;
      localObject = "";
      break;
    }
  }
  
  private void a(agbi paramagbi, View paramView)
  {
    if (a(paramagbi))
    {
      if (paramagbi.b == null)
      {
        paramagbi.b = new ImageView(this.jdField_a_of_type_AndroidContentContext);
        paramagbi.b.setImageResource(2130838162);
        paramagbi.b.setId(2131364192);
        RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
        localLayoutParams.bottomMargin = aepi.a(16.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
        localLayoutParams.addRule(8, 2131364173);
        localLayoutParams.addRule(0, 2131364173);
        localLayoutParams.addRule(1, 0);
        if ((paramView instanceof ViewGroup)) {
          ((ViewGroup)paramView).addView(paramagbi.b, localLayoutParams);
        }
      }
      a(paramagbi, true, this);
      return;
    }
    a(paramagbi, false, null);
  }
  
  private void a(agbi paramagbi, MessageForShortVideo paramMessageForShortVideo, boolean paramBoolean)
  {
    if (paramMessageForShortVideo.md5 == null) {
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, 2131720103, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298914));
    }
    String str;
    do
    {
      for (;;)
      {
        return;
        if (paramMessageForShortVideo.redBagType == LocalMediaInfo.REDBAG_TYPE_GET) {
          azjh.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, true);
        }
        ajpy.b("", "0X8006A1C");
        ajst.a("shortvideo_bubble", null);
        wxj.a("story_grp", "aio_msg", 0, 0, new String[] { "", "", "", "" });
        str = ShortVideoUtils.a(paramMessageForShortVideo.thumbMD5, "jpg");
        if (bdhb.b(ShortVideoUtils.a(paramMessageForShortVideo, "mp4"))) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.d("ShortVideoRealItemBuilder", 2, "onClick, video file not exist");
        }
        if (paramMessageForShortVideo.videoFileStatus == 5002)
        {
          b(paramMessageForShortVideo, paramagbi, 2131719276);
          QQToast.a(this.jdField_a_of_type_AndroidContentContext, 2131720139, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298914));
        }
        while (!paramMessageForShortVideo.isSend())
        {
          new axtc(BaseApplication.getContext()).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 2001, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, 1003);
          return;
          a(paramMessageForShortVideo, false);
          a(paramMessageForShortVideo, paramagbi, paramMessageForShortVideo.videoFileProgress, false);
        }
      }
    } while (!bdhb.b(str));
    azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800561C", "0X800561C", 0, 0, "", "", "", "");
    if (TVK_SDKMgr.isInstalled(this.jdField_a_of_type_AndroidContentContext))
    {
      a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, paramMessageForShortVideo, paramagbi.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramBoolean, false, true, true, null);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoRealItemBuilder", 2, "onClick, sdk is not installed");
    }
    QQToast.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131698160), 0).b(BaseApplicationImpl.getApplication().getResources().getDimensionPixelSize(2131298914));
  }
  
  private void a(agbi paramagbi, boolean paramBoolean, View.OnClickListener paramOnClickListener)
  {
    if (paramBoolean) {
      if (paramagbi.b != null)
      {
        paramagbi.b.setVisibility(0);
        paramagbi.b.setOnClickListener(paramOnClickListener);
      }
    }
    while (paramagbi.b == null) {
      return;
    }
    paramagbi.b.setVisibility(8);
    paramagbi.b.setOnClickListener(null);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, MessageForShortVideo paramMessageForShortVideo, View paramView, SessionInfo paramSessionInfo, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, MessageForReplyText paramMessageForReplyText)
  {
    azqs.b(paramQQAppInterface, "dc00898", "", "", "0X8007429", "0X8007429", 0, 0, "", "", "", "");
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoRealItemBuilder", 2, "enterRichMediaPreview");
    }
    if (MediaPlayerManager.a(paramQQAppInterface).a()) {
      MediaPlayerManager.a(paramQQAppInterface).a(true);
    }
    paramView = zjc.a(paramView);
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("KEY_THUMBNAL_BOUND", paramView);
    if ((((paramContext instanceof ChatActivity)) || ((paramContext instanceof SplashActivity))) && (!(paramContext instanceof MultiForwardActivity))) {
      localBundle.putInt("extra.AIO_CURRENT_PANEL_STATE", ((FragmentActivity)paramContext).getChatFragment().a().f());
    }
    if (paramSessionInfo.jdField_a_of_type_Int == 1)
    {
      localBundle.putBoolean("extra.CAN_FORWARD_TO_GROUP_ALBUM", true);
      localBundle.putString("extra.GROUP_UIN", paramSessionInfo.jdField_a_of_type_JavaLangString);
      localBundle.putString("extra.GROUP_CODE", paramSessionInfo.b);
    }
    if ((paramSessionInfo.jdField_a_of_type_Int == 1) || (paramSessionInfo.jdField_a_of_type_Int == 3000))
    {
      localBundle.putInt("extra.EXTRA_FORWARD_TO_QZONE_SRC", 2);
      if (paramMessageForReplyText == null) {
        break label556;
      }
      localBundle.putBoolean("extra.IS_FROM_MULTI_MSG", paramMessageForReplyText.isMultiMsg);
      label222:
      paramView = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses().iterator();
      while (paramView.hasNext())
      {
        paramMessageForReplyText = (ActivityManager.RunningAppProcessInfo)paramView.next();
        if (paramMessageForReplyText.processName.endsWith("mobileqq")) {
          localBundle.putInt("extra.MOBILE_QQ_PROCESS_ID", paramMessageForReplyText.pid);
        }
      }
      paramView = paramMessageForShortVideo.selfuin;
      if (!paramMessageForShortVideo.isMultiMsg) {
        break label665;
      }
    }
    label665:
    for (;;)
    {
      try
      {
        AppRuntime localAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
        paramMessageForReplyText = paramView;
        if ((localAppRuntime instanceof QQAppInterface)) {
          paramMessageForReplyText = localAppRuntime.getAccount();
        }
        paramView = paramMessageForReplyText;
      }
      catch (Exception paramMessageForReplyText)
      {
        int k;
        label556:
        continue;
        if (!(paramContext instanceof ChatHistoryActivity)) {
          continue;
        }
        int j = 2;
        continue;
        j = k;
        if (!(paramContext instanceof PublicFragmentActivity)) {
          continue;
        }
        j = k;
        if (!(((PublicFragmentActivity)paramContext).a() instanceof ChatHistoryBubbleListForTroopFragment)) {
          continue;
        }
        j = 2;
        continue;
        localBundle.putBoolean("extra.ENTER_NEW_GALLERY", true);
        biqe.a(paramContext, localBundle, new AIOImageProviderService(paramView, paramMessageForShortVideo.frienduin, paramMessageForShortVideo.istroop, paramMessageForShortVideo), agjb.a(paramMessageForShortVideo), -1, j);
        continue;
      }
      localBundle.putInt("forward_source_uin_type", paramSessionInfo.jdField_a_of_type_Int);
      localBundle.putString("uin", paramSessionInfo.jdField_a_of_type_JavaLangString);
      k = -1;
      if ((paramContext instanceof SplashActivity))
      {
        j = 1;
        localBundle.putBoolean("muate_play", paramBoolean1);
        localBundle.putBoolean("is_one_item", paramBoolean2);
        localBundle.putBoolean("is_ReplyMsg_From_Same_Session", paramBoolean3);
        localBundle.putBoolean(biqe.b, paramBoolean4);
        if ((paramMessageForShortVideo.istroop != 0) || (!bdeu.b(paramMessageForShortVideo.senderuin)) || (TextUtils.isEmpty(paramMessageForShortVideo.getExtInfoFromExtStr("guide_video_type")))) {
          continue;
        }
        localBundle.putString("babyq_video_type", paramMessageForShortVideo.getExtInfoFromExtStr("guide_video_type"));
        localBundle.putBoolean("extra.ENTER_NEW_GALLERY", true);
        biqe.a(paramContext, localBundle, new AIOImageProviderService(paramView, paramMessageForShortVideo.frienduin, paramMessageForShortVideo.istroop, paramMessageForShortVideo), agjb.a(paramMessageForShortVideo), 13007, j);
        if (!paramMessageForShortVideo.isSend()) {
          new axtc(BaseApplication.getContext()).a(paramQQAppInterface, 2001, paramSessionInfo.jdField_a_of_type_Int, paramSessionInfo.jdField_a_of_type_JavaLangString, 1001);
        }
        ShortVideoUtils.a(paramQQAppInterface, "0X8008E53", paramSessionInfo, paramMessageForShortVideo, paramContext);
        return;
        localBundle.putInt("extra.EXTRA_FORWARD_TO_QZONE_SRC", 1);
        break;
        localBundle.putBoolean("extra.IS_FROM_MULTI_MSG", paramMessageForShortVideo.isMultiMsg);
        break label222;
      }
    }
  }
  
  private void a(MessageForShortVideo paramMessageForShortVideo, agbi paramagbi, String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    if (!paramMessageForShortVideo.isSend()) {
      new axtc(BaseApplication.getContext()).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 2001, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, 1002);
    }
    a(paramMessageForShortVideo, alud.a(2131714444) + paramString2);
    a(paramagbi.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView, paramString2, paramString1, paramMessageForShortVideo, paramInt1, paramInt2);
    if ((xpq.a(paramagbi.jdField_a_of_type_ComTencentMobileqqDataChatMessage.istroop, paramagbi.jdField_a_of_type_ComTencentMobileqqDataChatMessage)) && (!bdew.a().a(paramagbi.jdField_a_of_type_ComTencentMobileqqDataChatMessage, "aio_msg|play_msg_video")))
    {
      bdew.a().a(paramagbi.jdField_a_of_type_ComTencentMobileqqDataChatMessage, "aio_msg|play_msg_video");
      wxj.a("aio_msg", "play_msg_video", 0, 0, new String[] { "", "", "", xpq.a((MessageForShortVideo)paramagbi.jdField_a_of_type_ComTencentMobileqqDataChatMessage) });
    }
    if (!bdhb.b(paramString1))
    {
      a(paramMessageForShortVideo);
      a(paramMessageForShortVideo, "getBubbleView: Video file exist and status finish. Thumb not exist.");
    }
  }
  
  private void a(MessageForShortVideo paramMessageForShortVideo, agbi paramagbi, boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject = a(paramMessageForShortVideo);
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      jdField_h_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo = paramMessageForShortVideo;
      akco localakco = new akco(paramMessageForShortVideo.mThumbFilePath, paramMessageForShortVideo.thumbMD5, null, paramMessageForShortVideo.thumbWidth, paramMessageForShortVideo.thumbHeight);
      localObject = new akci(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, (String)localObject, paramMessageForShortVideo.mediacodecEncode, localakco, paramMessageForShortVideo);
      akci.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Long.valueOf(paramMessageForShortVideo.uniseq), localObject);
      ((akci)localObject).a(this.jdField_a_of_type_Akcn);
      ((akci)localObject).a(false);
      Utils.executeAsyncTaskOnSerialExcuter((AsyncTask)localObject, new Void[] { (Void)null });
      ThreadManager.getUIHandler().post(new ShortVideoRealItemBuilder.12(this, paramBoolean1, paramagbi, paramMessageForShortVideo, paramBoolean2));
    }
  }
  
  private void a(MessageRecord paramMessageRecord, String paramString)
  {
    if (QLog.isColorLevel())
    {
      paramMessageRecord = "ShortVideoRealItemBuilder" + "[" + paramMessageRecord.uniseq + "]";
      QLog.i("ShortVideoRealItemBuilder", 2, paramMessageRecord + ":content " + paramString);
    }
  }
  
  private void a(boolean paramBoolean, CropBubbleVideoView paramCropBubbleVideoView, MessageForShortVideo paramMessageForShortVideo, agbi paramagbi, String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    if (a(paramCropBubbleVideoView, paramString1))
    {
      a(paramMessageForShortVideo, alud.a(2131714420) + paramString1);
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mLoadingDrawable = jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
      localURLDrawableOptions.mFailedDrawable = jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
      localURLDrawableOptions.mRequestHeight = paramInt2;
      localURLDrawableOptions.mRequestWidth = paramInt1;
      paramString1 = URLDrawable.getDrawable(new File(paramString1), localURLDrawableOptions);
      paramCropBubbleVideoView.setID(paramMessageForShortVideo.uniseq);
      paramagbi.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView.showCover(paramString1);
    }
    if ((bdhb.b(paramString2)) || ((paramMessageForShortVideo.isSend()) && (paramMessageForShortVideo.md5 == null) && (paramMessageForShortVideo.videoFileStatus == 1004)))
    {
      paramInt1 = 0;
      if ((paramMessageForShortVideo.videoFileStatus == 1005) || (paramMessageForShortVideo.extraflag == 32768) || (paramMessageForShortVideo.videoFileStatus == 1004)) {
        paramInt1 = 1;
      }
      paramCropBubbleVideoView = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramMessageForShortVideo.frienduin, paramMessageForShortVideo.uniseq);
      paramInt2 = paramInt1;
      if (paramMessageForShortVideo.isSendFromLocal())
      {
        paramInt2 = paramInt1;
        if (paramMessageForShortVideo.videoFileProgress < 100)
        {
          paramInt2 = paramInt1;
          if (paramMessageForShortVideo.videoFileStatus != 1003)
          {
            paramInt2 = paramInt1;
            if (paramCropBubbleVideoView == null) {
              paramInt2 = 1;
            }
          }
        }
      }
      if (paramInt2 != 0) {
        b(paramMessageForShortVideo, paramagbi, 2131719281);
      }
      do
      {
        return;
        if ((!ShortVideoUtils.a()) || (!paramBoolean))
        {
          c(paramMessageForShortVideo, paramagbi);
          return;
        }
      } while (paramMessageForShortVideo.videoFileStatus == 1003);
      if (ShortVideoUtils.a(paramMessageForShortVideo.videoFileProgress, 10) <= 60) {}
      for (paramInt1 = 1; (paramMessageForShortVideo.busiType == 1) && (paramInt1 != 0); paramInt1 = 0)
      {
        if (paramMessageForShortVideo.progress > 60) {
          paramMessageForShortVideo.progress = 60;
        }
        a(paramMessageForShortVideo, paramagbi, paramMessageForShortVideo.videoFileProgress, paramMessageForShortVideo.progress);
        return;
      }
      a(paramMessageForShortVideo, paramagbi, paramMessageForShortVideo.videoFileProgress, false);
      return;
    }
    if (paramMessageForShortVideo.videoFileStatus == 2005) {
      c(paramMessageForShortVideo, paramagbi);
    }
    if (paramMessageForShortVideo.videoFileStatus == 5002)
    {
      a(paramMessageForShortVideo, alud.a(2131714435));
      b(paramMessageForShortVideo, paramagbi, 2131719276);
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramMessageForShortVideo, true))
    {
      a(paramMessageForShortVideo, true);
      return;
    }
    if ((paramMessageForShortVideo.videoFileStatus == 2001) || (paramMessageForShortVideo.videoFileStatus == 2002) || (paramMessageForShortVideo.videoFileStatus == 2000))
    {
      a(paramMessageForShortVideo, paramagbi, paramMessageForShortVideo.videoFileProgress, false);
      return;
    }
    c(paramMessageForShortVideo, paramagbi);
  }
  
  private boolean a(agbi paramagbi)
  {
    boolean bool2 = true;
    if ((paramagbi.jdField_a_of_type_ComTencentMobileqqDataChatMessage instanceof MessageForShortVideo)) {}
    for (MessageForShortVideo localMessageForShortVideo = (MessageForShortVideo)paramagbi.jdField_a_of_type_ComTencentMobileqqDataChatMessage;; localMessageForShortVideo = null)
    {
      if (localMessageForShortVideo == null) {
        return false;
      }
      int j;
      int k;
      if ((localMessageForShortVideo.videoFileStatus == 998) || (localMessageForShortVideo.videoFileStatus == 1002) || (localMessageForShortVideo.videoFileStatus == 1001))
      {
        j = 1;
        if ((localMessageForShortVideo.isMultiMsg) || (localMessageForShortVideo.uiOperatorFlag == 2) || (localMessageForShortVideo.busiType != 1) || (!localMessageForShortVideo.isSendFromLocal()) || (paramagbi.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.a())) {
          break label204;
        }
        k = 1;
        label110:
        if (QLog.isColorLevel())
        {
          paramagbi = new StringBuilder().append("shortVideoCancel needShowPauseIcon seq:").append(localMessageForShortVideo.uniseq).append(", videostatus:").append(localMessageForShortVideo.videoFileStatus).append(", iconshow:");
          if ((j == 0) || (k == 0)) {
            break label209;
          }
          bool1 = true;
          QLog.i("ShortVideoRealItemBuilder", 2, bool1);
        }
        label169:
        if ((j == 0) || (k == 0)) {
          break label215;
        }
      }
      label204:
      label209:
      label215:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        return bool1;
        j = 0;
        break;
        k = 0;
        break label110;
        bool1 = false;
        break label169;
      }
    }
  }
  
  private boolean a(agbi paramagbi, MessageForShortVideo paramMessageForShortVideo, int paramInt1, int paramInt2, CropBubbleVideoView paramCropBubbleVideoView)
  {
    if ((TextUtils.isEmpty(paramMessageForShortVideo.md5)) && (paramMessageForShortVideo.videoFileStatus != 1005) && (paramMessageForShortVideo.extraflag != 32768) && (paramMessageForShortVideo.videoFileStatus != 1004))
    {
      Object localObject2;
      Object localObject1;
      if (paramMessageForShortVideo.isSendFromLocal())
      {
        localObject2 = paramMessageForShortVideo.mThumbFilePath;
        localObject1 = localObject2;
        if (bdhb.b((String)localObject2)) {
          break label119;
        }
        if (!TextUtils.isEmpty(paramMessageForShortVideo.thumbMD5)) {
          break label107;
        }
        paramCropBubbleVideoView.setID(paramMessageForShortVideo.uniseq);
        paramCropBubbleVideoView.showCover(bayu.a());
        a(paramagbi);
        a(paramMessageForShortVideo, "getBubbleView():You must get thumb before send video.");
      }
      label107:
      label119:
      do
      {
        do
        {
          for (;;)
          {
            return true;
            localObject1 = ShortVideoUtils.a(paramMessageForShortVideo.thumbMD5, "jpg");
            if (a(paramCropBubbleVideoView, (String)localObject1))
            {
              localObject2 = URLDrawable.URLDrawableOptions.obtain();
              ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
              ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
              ((URLDrawable.URLDrawableOptions)localObject2).mRequestWidth = paramInt1;
              ((URLDrawable.URLDrawableOptions)localObject2).mRequestHeight = paramInt2;
              localObject1 = URLDrawable.getDrawable(new File((String)localObject1), (URLDrawable.URLDrawableOptions)localObject2);
              paramCropBubbleVideoView.setID(paramMessageForShortVideo.uniseq);
              paramCropBubbleVideoView.showCover((Drawable)localObject1);
              paramagbi = new WeakReference(paramagbi);
              if (paramMessageForShortVideo.busiType == 1)
              {
                if (paramMessageForShortVideo.progressTask == null)
                {
                  paramMessageForShortVideo.progressTask = new ShortVideoRealItemBuilder.1(this, paramMessageForShortVideo, paramagbi);
                  this.jdField_b_of_type_AndroidOsHandler.removeCallbacks(paramMessageForShortVideo.progressTask);
                  this.jdField_b_of_type_AndroidOsHandler.post(paramMessageForShortVideo.progressTask);
                }
                if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo != null) && ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.uniseq == paramMessageForShortVideo.uniseq) || (jdField_a_of_type_JavaUtilMap.containsKey(Long.valueOf(paramMessageForShortVideo.uniseq))))) {
                  break label391;
                }
              }
              for (paramInt1 = 1;; paramInt1 = 0)
              {
                if ((paramMessageForShortVideo.mPreUpload) || (!TextUtils.isEmpty(paramMessageForShortVideo.md5)) || (paramInt1 == 0) || (paramMessageForShortVideo.busiType != 1)) {
                  break label394;
                }
                if (jdField_h_of_type_Boolean) {
                  break label396;
                }
                a(paramMessageForShortVideo, null, false, true);
                return true;
                if (paramMessageForShortVideo.mShowProgressTask == null) {
                  paramMessageForShortVideo.mShowProgressTask = new ShortVideoRealItemBuilder.2(this, paramagbi, paramMessageForShortVideo);
                }
                this.jdField_b_of_type_AndroidOsHandler.removeCallbacks(paramMessageForShortVideo.mShowProgressTask);
                this.jdField_b_of_type_AndroidOsHandler.post(paramMessageForShortVideo.mShowProgressTask);
                break;
              }
            }
          }
        } while (jdField_a_of_type_JavaUtilMap.containsKey(Long.valueOf(paramMessageForShortVideo.uniseq)));
        jdField_a_of_type_JavaUtilMap.put(Long.valueOf(paramMessageForShortVideo.uniseq), paramMessageForShortVideo);
      } while (!QLog.isColorLevel());
      label391:
      label394:
      label396:
      QLog.i("ShortVideoRealItemBuilder", 2, "messageMap size:" + jdField_a_of_type_JavaUtilMap.size() + ", [" + paramMessageForShortVideo.uniseq + "] added, mEncoding:" + jdField_h_of_type_Boolean);
      return true;
    }
    return false;
  }
  
  private boolean a(MessageForShortVideo paramMessageForShortVideo)
  {
    auqc localauqc = (auqc)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(324);
    if (localauqc != null)
    {
      paramMessageForShortVideo = localauqc.a(localauqc.a(paramMessageForShortVideo));
      if ((paramMessageForShortVideo != null) && (QLog.isColorLevel())) {
        QLog.d("ShortVideoRealItemBuilder", 2, "isVideoInMultiSaving = true");
      }
      return paramMessageForShortVideo != null;
    }
    return false;
  }
  
  private void b(agbi paramagbi, boolean paramBoolean, View.OnClickListener paramOnClickListener)
  {
    if ((paramagbi != null) && (paramagbi.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout != null))
    {
      if (paramBoolean) {
        a(paramagbi, false, null);
      }
      paramagbi.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(paramBoolean, paramOnClickListener);
    }
  }
  
  private boolean b(MessageForShortVideo paramMessageForShortVideo)
  {
    return azun.a().a(this.jdField_a_of_type_AndroidContentContext, 2, paramMessageForShortVideo.istroop);
  }
  
  private void c(MessageForShortVideo paramMessageForShortVideo)
  {
    if ((paramMessageForShortVideo != null) && (paramMessageForShortVideo.progressTask != null))
    {
      this.jdField_b_of_type_AndroidOsHandler.removeCallbacks(paramMessageForShortVideo.progressTask);
      paramMessageForShortVideo.progressTask = null;
    }
  }
  
  public static void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoRealItemBuilder", 2, "pauseAllVideo");
    }
    if (jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet != null)
    {
      Iterator localIterator = jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet.iterator();
      while (localIterator.hasNext())
      {
        CropBubbleVideoView localCropBubbleVideoView = (CropBubbleVideoView)localIterator.next();
        if (localCropBubbleVideoView != null) {
          localCropBubbleVideoView.pause();
        }
      }
    }
  }
  
  private boolean e()
  {
    if ((this.jdField_a_of_type_AndroidViewViewGroup != null) && ((this.jdField_a_of_type_AndroidViewViewGroup instanceof ChatXListView))) {
      return ((ChatXListView)this.jdField_a_of_type_AndroidViewViewGroup).a();
    }
    return true;
  }
  
  public static void f()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoRealItemBuilder", 2, "resumeAllVideo");
    }
    if (jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet != null)
    {
      Iterator localIterator = jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet.iterator();
      while (localIterator.hasNext())
      {
        CropBubbleVideoView localCropBubbleVideoView = (CropBubbleVideoView)localIterator.next();
        if (localCropBubbleVideoView != null) {
          localCropBubbleVideoView.resume();
        }
      }
    }
  }
  
  public static void g()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoRealItemBuilder", 2, "releaseAllVideo");
    }
    if (jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet != null)
    {
      Iterator localIterator = jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet.iterator();
      while (localIterator.hasNext())
      {
        CropBubbleVideoView localCropBubbleVideoView = (CropBubbleVideoView)localIterator.next();
        if (localCropBubbleVideoView != null)
        {
          localCropBubbleVideoView.releasePlayer(false);
          jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet.remove(localCropBubbleVideoView);
        }
      }
    }
  }
  
  private void h()
  {
    int k = 720;
    int m = 540;
    Object localObject;
    int j;
    if (!jdField_g_of_type_Boolean)
    {
      localObject = DeviceProfileManager.a().a(DeviceProfileManager.DpcNames.ShortVideoHDConfig.name(), null);
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoRealItemBuilder", 2, "initVideoHDConfig(), shortVideoHDConfig=" + (String)localObject);
      }
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        localObject = ((String)localObject).split("\\|");
        if ((localObject != null) && (localObject.length >= 3))
        {
          if (!TextUtils.isEmpty(localObject[0])) {
            jdField_f_of_type_Boolean = localObject[0].equals("1");
          }
          j = k;
          if (TextUtils.isEmpty(localObject[1])) {}
        }
      }
    }
    try
    {
      j = Integer.parseInt(localObject[1]);
      k = m;
      if (!TextUtils.isEmpty(localObject[2])) {}
      try
      {
        k = Integer.parseInt(localObject[2]);
        jdField_c_of_type_Int = Math.max(j, k);
        jdField_d_of_type_Int = Math.min(j, k);
        jdField_g_of_type_Boolean = true;
        if (QLog.isColorLevel()) {
          QLog.d("ShortVideoRealItemBuilder", 2, "initVideoHDConfig(), sReadHDConfig=" + jdField_g_of_type_Boolean + ", sHDEnable:" + jdField_f_of_type_Boolean + ", sHDMaxLength:" + jdField_c_of_type_Int + ", sHDMinLength:" + jdField_d_of_type_Int);
        }
        return;
      }
      catch (Exception localException1)
      {
        for (;;)
        {
          k = m;
        }
      }
    }
    catch (Exception localException2)
    {
      for (;;)
      {
        j = k;
      }
    }
  }
  
  private void i()
  {
    try
    {
      if ((this.jdField_a_of_type_AndroidContentContext != null) && ((this.jdField_a_of_type_AndroidContentContext instanceof FragmentActivity)))
      {
        Object localObject = ((FragmentActivity)this.jdField_a_of_type_AndroidContentContext).getChatFragment();
        if (localObject != null)
        {
          localObject = ((ChatFragment)localObject).a();
          if (localObject != null) {
            ((BaseChatPie)localObject).b(false, false);
          }
        }
      }
      return;
    }
    catch (Exception localException) {}
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    return 0;
  }
  
  public aeqh a(View paramView)
  {
    return null;
  }
  
  public aeqi a()
  {
    return new agbi(this);
  }
  
  public agbi a(long paramLong)
  {
    if ((this.jdField_a_of_type_ComTencentWidgetListView != null) && (paramLong > 0L))
    {
      int j = aepi.a(paramLong, this.jdField_a_of_type_ComTencentWidgetListView.getAdapter());
      int k = this.jdField_a_of_type_ComTencentWidgetListView.getHeaderViewsCount();
      int m = this.jdField_a_of_type_ComTencentWidgetListView.getFirstVisiblePosition();
      int n = this.jdField_a_of_type_ComTencentWidgetListView.getLastVisiblePosition();
      if (j <= -1) {
        break label223;
      }
      Object localObject = aepi.a(this.jdField_a_of_type_ComTencentWidgetListView, j);
      if (localObject != null)
      {
        localObject = aepi.a((View)localObject);
        if ((localObject != null) && ((localObject instanceof agbi))) {
          return (agbi)localObject;
        }
      }
      else if (QLog.isColorLevel())
      {
        QLog.w("ShortVideoRealItemBuilder", 2, "getHolderByMsg() uniseq=" + paramLong + ", posi =" + j + ", view = null");
      }
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoRealItemBuilder", 2, "getHolderByMsg() uniseq=" + paramLong + ", posi =" + j + ", firstVisblePosi=" + m + ",lastVisblePosi=" + n + ",headerCount=" + k);
      }
    }
    for (;;)
    {
      return null;
      label223:
      if (QLog.isColorLevel()) {
        QLog.w("ShortVideoRealItemBuilder", 2, "getHolderByMsg() uniseq=" + paramLong + ", posi<= -1");
      }
    }
  }
  
  public View a(int paramInt1, int paramInt2, ChatMessage paramChatMessage, View paramView, ViewGroup paramViewGroup, aetk paramaetk)
  {
    paramView = super.a(paramInt1, paramInt2, paramChatMessage, paramView, paramViewGroup, paramaetk);
    a(paramChatMessage, paramView, this);
    a((agbi)paramView.getTag(), paramView);
    return paramView;
  }
  
  public View a(ChatMessage paramChatMessage, aeqi paramaeqi, View paramView, BaseChatItemLayout paramBaseChatItemLayout, aetk paramaetk)
  {
    agbi localagbi = (agbi)paramaeqi;
    Context localContext = this.jdField_a_of_type_AndroidContentContext;
    Resources localResources = localContext.getResources();
    MessageForShortVideo localMessageForShortVideo = (MessageForShortVideo)paramChatMessage;
    paramaeqi = ShortVideoUtils.a(localMessageForShortVideo.thumbWidth, localMessageForShortVideo.thumbHeight);
    int j = paramaeqi[0];
    int k = paramaeqi[1];
    boolean bool = localMessageForShortVideo.isSend();
    paramaeqi = paramView;
    if (paramView == null)
    {
      paramaeqi = new RelativeLayout(localContext);
      paramView = (CropBubbleVideoView)axaz.a(this.jdField_a_of_type_AndroidContentContext, localMessageForShortVideo.uniseq, null, bool);
      paramView.setId(2131362258);
      paramView.setVisibility(0);
      paramView.setContentDescription(alud.a(2131714468));
      paramaeqi.addView(paramView);
      MessageProgressView localMessageProgressView = new MessageProgressView(localContext);
      paramaeqi.addView(localMessageProgressView);
      ImageView localImageView = new ImageView(localContext);
      localImageView.setImageResource(2130837946);
      localImageView.setVisibility(8);
      Object localObject1 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject1).addRule(7, 2131362258);
      ((RelativeLayout.LayoutParams)localObject1).addRule(8, 2131362258);
      ((RelativeLayout.LayoutParams)localObject1).bottomMargin = aepi.a(10.0F, localResources);
      ((RelativeLayout.LayoutParams)localObject1).rightMargin = aepi.a(10.0F, localResources);
      paramaeqi.addView(localImageView, (ViewGroup.LayoutParams)localObject1);
      jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet.add(paramView);
      localObject1 = new LinearLayout(localContext);
      ((LinearLayout)localObject1).setOrientation(1);
      ((LinearLayout)localObject1).setGravity(17);
      Object localObject2 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject2).addRule(13);
      paramaeqi.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
      localObject2 = new TextView(localContext);
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
      localLayoutParams.topMargin = aepi.a(70.0F, localResources);
      ((TextView)localObject2).setTextColor(-1);
      ((TextView)localObject2).setTextSize(2, 12.0F);
      ((TextView)localObject2).setId(2131364213);
      ((LinearLayout)localObject1).addView((View)localObject2, localLayoutParams);
      paramaeqi.setOnClickListener(this);
      super.a(paramaeqi, paramaetk);
      localagbi.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView = paramView;
      localagbi.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView = localMessageProgressView;
      localagbi.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localObject2);
      localagbi.jdField_a_of_type_AndroidWidgetImageView = localImageView;
    }
    paramView = localagbi.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView;
    if (jdField_e_of_type_Boolean) {
      paramView.setContentDescription(alud.a(2131714430));
    }
    localagbi.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setMiniAioShieldItemTouchListener(this);
    paramView.mIsSend = localMessageForShortVideo.isSend();
    paramView.setTag(Long.valueOf(localMessageForShortVideo.uniseq));
    bdew.a().a(Long.valueOf(localMessageForShortVideo.uniseq), localMessageForShortVideo);
    localagbi.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    localagbi.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setRadius(15.0F, true);
    localagbi.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setShowCorner(true);
    localagbi.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setSharpCornerCor(BubbleImageView.a);
    localagbi.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setCornerDirection(localMessageForShortVideo.isSend());
    localagbi.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.a(paramChatMessage.frienduin + paramChatMessage.uniseq);
    if ((localMessageForShortVideo.fileType == 6) || (localMessageForShortVideo.fileType == 17) || (localMessageForShortVideo.fileType == 9) || (localMessageForShortVideo.fileType == 20))
    {
      if ((localMessageForShortVideo.videoFileStatus == 1003) || (localMessageForShortVideo.videoFileStatus == 2003)) {
        b(localagbi);
      }
    }
    else
    {
      localagbi.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      paramaetk = localagbi.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView.getLayoutParams();
      if (paramaetk != null) {
        break label1018;
      }
      paramaetk = new RelativeLayout.LayoutParams(j, k);
      localagbi.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView.setLayoutParams(paramaetk);
      label667:
      paramaetk = localagbi.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.getLayoutParams();
      if (paramaetk != null) {
        break label1065;
      }
      paramaetk = new RelativeLayout.LayoutParams(j, k);
      localagbi.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setLayoutParams(paramaetk);
      label705:
      if (paramBaseChatItemLayout != null)
      {
        a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseChatItemLayout, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramChatMessage, this);
        if (!(this.jdField_a_of_type_AndroidContentContext instanceof MultiForwardActivity))
        {
          a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseChatItemLayout, localagbi, paramChatMessage);
          azjh.a(paramaeqi, localagbi, paramChatMessage, localContext);
        }
      }
      if (!bdew.a().a(localMessageForShortVideo, "0X8007428"))
      {
        bdew.a().a(localMessageForShortVideo, "0X8007428");
        azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8007428", "0X8007428", 0, 0, "", "", "", "");
      }
      if ((localMessageForShortVideo.CheckIsHotVideo()) && (!bdew.a().a(localMessageForShortVideo, "0X8007EDB")))
      {
        bdew.a().a(localMessageForShortVideo, "0X8007EDB");
        azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8007EDB", "0X8007EDB", 0, 0, "", "", "", "");
      }
      int m = Math.max(localMessageForShortVideo.thumbWidth, localMessageForShortVideo.thumbHeight);
      int n = Math.min(localMessageForShortVideo.thumbWidth, localMessageForShortVideo.thumbHeight);
      if ((!jdField_f_of_type_Boolean) || (m < jdField_c_of_type_Int) || (n < jdField_d_of_type_Int)) {
        break label1127;
      }
      paramChatMessage = (RelativeLayout.LayoutParams)localagbi.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
      if (!bool) {
        break label1112;
      }
      paramChatMessage.rightMargin = aepi.a(8.0F + localagbi.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView.getTriaWidth(), localResources);
      label979:
      localagbi.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    }
    for (;;)
    {
      if (!a(localagbi, localMessageForShortVideo, j, k, paramView)) {
        break label1140;
      }
      return paramaeqi;
      localagbi.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setVisibility(0);
      break;
      label1018:
      if ((paramaetk.width == j) && (paramaetk.height == k)) {
        break label667;
      }
      paramaetk.width = j;
      paramaetk.height = k;
      localagbi.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView.setLayoutParams(paramaetk);
      break label667;
      label1065:
      if ((paramaetk.width == j) && (paramaetk.height == k)) {
        break label705;
      }
      paramaetk.width = j;
      paramaetk.height = k;
      localagbi.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setLayoutParams(paramaetk);
      break label705;
      label1112:
      paramChatMessage.rightMargin = aepi.a(8.0F, localResources);
      break label979;
      label1127:
      localagbi.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    }
    label1140:
    paramChatMessage = ShortVideoUtils.a(localMessageForShortVideo.thumbMD5, "jpg");
    paramBaseChatItemLayout = ShortVideoUtils.a(localMessageForShortVideo, "mp4");
    bool = b(localMessageForShortVideo);
    if ((bool) && (bdhb.b(paramBaseChatItemLayout)) && ((!localMessageForShortVideo.isSendFromLocal()) || (localMessageForShortVideo.videoFileStatus == 1003) || (localMessageForShortVideo.videoFileStatus == 2003) || (localMessageForShortVideo.isMultiMsg == true)))
    {
      a(localMessageForShortVideo, localagbi, paramChatMessage, paramBaseChatItemLayout, j, k);
      return paramaeqi;
    }
    if (bdhb.b(paramChatMessage))
    {
      a(bool, paramView, localMessageForShortVideo, localagbi, paramChatMessage, paramBaseChatItemLayout, j, k);
      return paramaeqi;
    }
    if (localMessageForShortVideo.videoFileStatus == 5002)
    {
      a(localMessageForShortVideo, alud.a(2131714461));
      paramView.setID(localMessageForShortVideo.uniseq);
      paramView.showCover(jdField_a_of_type_AndroidGraphicsDrawableColorDrawable);
      b(localMessageForShortVideo, localagbi, 2131719276);
      return paramaeqi;
    }
    a(localMessageForShortVideo, alud.a(2131714482));
    paramView.setID(localMessageForShortVideo.uniseq);
    paramView.showCover(jdField_a_of_type_AndroidGraphicsDrawableColorDrawable);
    a(localMessageForShortVideo);
    return paramaeqi;
  }
  
  public bdpi a(bdpi parambdpi, ChatMessage paramChatMessage, aeqz paramaeqz)
  {
    int m = 0;
    paramChatMessage = (MessageForShortVideo)paramChatMessage;
    paramaeqz = (agbi)paramaeqz;
    b(parambdpi, this.jdField_a_of_type_AndroidContentContext);
    int k = m;
    if (!TextUtils.isEmpty(paramChatMessage.md5)) {
      if (paramChatMessage.mPreUpload)
      {
        k = m;
        if (TextUtils.isEmpty(paramChatMessage.mLocalMd5)) {}
      }
      else
      {
        String str = ShortVideoUtils.a(paramChatMessage.thumbMD5, "jpg");
        paramChatMessage = ShortVideoUtils.a(paramChatMessage, "mp4");
        k = m;
        if (bdhb.b(str)) {
          if ((paramaeqz.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.c == null) || (paramaeqz.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.c.getVisibility() != 0)) {
            break label185;
          }
        }
      }
    }
    label185:
    for (int j = 1;; j = 0)
    {
      k = m;
      if (j == 0)
      {
        parambdpi.a(2131366760, this.jdField_a_of_type_AndroidContentContext.getString(2131692837), 2130838678);
        k = m;
        if (bdhb.b(paramChatMessage)) {
          k = 1;
        }
      }
      if (k != 0) {
        parambdpi.a(2131366017, this.jdField_a_of_type_AndroidContentContext.getString(2131692401), 2130838677);
      }
      return parambdpi;
    }
  }
  
  public String a(ChatMessage paramChatMessage)
  {
    return alud.a(2131714483);
  }
  
  public String a(MessageForShortVideo paramMessageForShortVideo)
  {
    paramMessageForShortVideo = paramMessageForShortVideo.mVideoFileSourceDir + File.separator + "configure.txt";
    if (!bdhb.b(paramMessageForShortVideo))
    {
      if (QLog.isColorLevel()) {
        QLog.i("ShortVideoRealItemBuilder", 2, "configure file empty!");
      }
      return null;
    }
    try
    {
      paramMessageForShortVideo = bdhb.b(new File(paramMessageForShortVideo));
      if (paramMessageForShortVideo == null) {
        break label97;
      }
      paramMessageForShortVideo = paramMessageForShortVideo.replaceAll("[\\t\\n\\r]", "");
      boolean bool = TextUtils.isEmpty(paramMessageForShortVideo);
      if (bool) {
        break label97;
      }
    }
    catch (Exception paramMessageForShortVideo)
    {
      for (;;)
      {
        paramMessageForShortVideo.printStackTrace();
        paramMessageForShortVideo = null;
      }
    }
    return paramMessageForShortVideo;
  }
  
  public void a()
  {
    super.a();
    Object localObject1 = jdField_a_of_type_JavaUtilMap.values().iterator();
    Object localObject2;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (MessageForShortVideo)((Iterator)localObject1).next();
      if (((MessageForShortVideo)localObject2).progressTask != null) {
        ((MessageForShortVideo)localObject2).progressTask = null;
      }
    }
    if (jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet != null)
    {
      localObject1 = jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (CropBubbleVideoView)((Iterator)localObject1).next();
        if (localObject2 != null)
        {
          long l = ((CropBubbleVideoView)localObject2).getCurPlayingPos();
          if (l > 0L)
          {
            MessageForShortVideo localMessageForShortVideo = bdew.a().a(Integer.valueOf(((CropBubbleVideoView)localObject2).getId()));
            if (localMessageForShortVideo != null) {
              a(localMessageForShortVideo, l);
            }
          }
          ((CropBubbleVideoView)localObject2).releasePlayer(false);
          jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet.remove(localObject2);
        }
      }
    }
    jdField_a_of_type_JavaUtilMap.clear();
    this.jdField_b_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    this.jdField_a_of_type_AndroidContentContext = null;
    localObject1 = this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo;
    if ((localObject1 != null) && (((MessageForShortVideo)localObject1).progressTask != null)) {
      ((MessageForShortVideo)localObject1).progressTask = null;
    }
    this.jdField_a_of_type_ComTencentWidgetListView = null;
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    MessageForShortVideo localMessageForShortVideo;
    if ((paramChatMessage != null) && ((paramChatMessage instanceof MessageForShortVideo)))
    {
      localMessageForShortVideo = (MessageForShortVideo)paramChatMessage;
      if (paramInt != 2131365071) {
        break label77;
      }
      acjm.b(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localMessageForShortVideo);
      wxj.a("story_grp", "press_msg", 0, 0, new String[] { "4", "", "", "" });
    }
    label77:
    do
    {
      do
      {
        return;
        if (paramInt == 2131370861)
        {
          super.d(paramChatMessage);
          wxj.a("story_grp", "press_msg", 0, 0, new String[] { "5", "", "", "" });
          return;
        }
        if (paramInt == 2131366760)
        {
          paramInt = awji.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage.istroop, paramChatMessage.frienduin);
          if (paramInt == 3) {
            paramContext = "1";
          }
          for (;;)
          {
            azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005624", "0X8005624", 0, 0, paramContext, "", "", "");
            wxj.a("story_grp", "press_msg", 0, 0, new String[] { "1", "", "", "" });
            b(localMessageForShortVideo);
            if (!paramChatMessage.isMultiMsg) {
              break;
            }
            azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009D66", "0X8009D66", 5, 0, "5", "", "", "");
            return;
            if (paramInt == 2) {
              paramContext = "2";
            } else if (paramInt == 0) {
              paramContext = "3";
            } else {
              paramContext = "4";
            }
          }
        }
        if (paramInt != 2131366017) {
          break;
        }
        biva.a(localMessageForShortVideo).b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage).a((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
        bivo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 3, 0, paramChatMessage.istroop);
        bivo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 6, 5);
        wxj.a("story_grp", "press_msg", 0, 0, new String[] { "2", "", "", "" });
      } while (!paramChatMessage.isMultiMsg);
      azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009D67", "0X8009D67", 5, 0, "5", "", "", "");
      return;
      if (paramInt == 2131370818)
      {
        super.a(localMessageForShortVideo);
        wxj.a("story_grp", "press_msg", 0, 0, new String[] { "3", "", "", "" });
        return;
      }
      if (paramInt == 2131365031)
      {
        paramContext = new StringBuilder();
        paramContext.append("uniseq:").append(localMessageForShortVideo.uniseq).append("\n");
        Toast.makeText(this.jdField_a_of_type_AndroidContentContext, paramContext.toString(), 1).show();
        return;
      }
      if (paramInt != 2131370921) {
        break label664;
      }
      paramContext = a(localMessageForShortVideo.uniseq);
      if (paramContext != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.e("ShortVideoRealItemBuilder", 2, "onMenuItemClicked(), mute_play, holder == null, mr.uniseq = " + localMessageForShortVideo.uniseq);
    return;
    a(paramContext, localMessageForShortVideo, true);
    azqs.b(null, "dc00898", "", "", "0X8009F65", "0X8009F65", 1, 0, "", "", "", "");
    return;
    label664:
    super.a(paramInt, paramContext, paramChatMessage);
  }
  
  public void a(agbi paramagbi)
  {
    if (!paramagbi.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.a(paramagbi.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin + paramagbi.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq)) {
      paramagbi.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setVisibility(8);
    }
    for (;;)
    {
      paramagbi.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      if (QLog.isColorLevel()) {
        QLog.w("ShortVideoRealItemBuilder", 2, "[hideProgress] set mProgressView gone");
      }
      return;
      paramagbi.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setAnimRunnableListener(new agbf(this, paramagbi));
    }
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    paramView = (agbi)aepi.a(paramView);
    MessageForShortVideo localMessageForShortVideo = (MessageForShortVideo)paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
    if (!localMessageForShortVideo.isSendFromLocal()) {}
    do
    {
      return;
      bhuf localbhuf = (bhuf)bhus.a(this.jdField_a_of_type_AndroidContentContext, null);
      localbhuf.a(2131690042, 5);
      localbhuf.c(2131690648);
      localbhuf.a(new agbe(this, localMessageForShortVideo, paramView, localbhuf));
      localbhuf.show();
    } while (localMessageForShortVideo.videoFileStatus != 1004);
    ShortVideoUtils.c("0X800A7EF", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
  }
  
  public void a(View paramView, bass parambass, int paramInt1, int paramInt2)
  {
    paramView = aepi.a(paramView);
    if (!(paramView instanceof agbi)) {}
    MessageForShortVideo localMessageForShortVideo;
    label96:
    int j;
    int k;
    label368:
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  return;
                  paramView = (agbi)paramView;
                  localMessageForShortVideo = (MessageForShortVideo)paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
                } while (localMessageForShortVideo.uniseq != parambass.jdField_b_of_type_Long);
                this.jdField_b_of_type_AndroidOsHandler.removeCallbacks(localMessageForShortVideo.mShowProgressTask);
                if (localMessageForShortVideo.mShowProgressTask != null) {
                  localMessageForShortVideo.mShowProgressTask = null;
                }
              } while (this.jdField_a_of_type_AndroidContentContext == null);
              localObject = this.jdField_a_of_type_AndroidContentContext.getResources();
              if (localMessageForShortVideo.thumbWidth > 0)
              {
                paramInt1 = localMessageForShortVideo.thumbWidth;
                if (localMessageForShortVideo.thumbHeight <= 0) {
                  break label368;
                }
              }
              for (paramInt2 = localMessageForShortVideo.thumbHeight;; paramInt2 = 100)
              {
                j = aepi.a(paramInt1, (Resources)localObject);
                k = aepi.a(paramInt2, (Resources)localObject);
                if ((parambass.jdField_b_of_type_Int != 6) && (parambass.jdField_b_of_type_Int != 17) && (parambass.jdField_b_of_type_Int != 9) && (parambass.jdField_b_of_type_Int != 20)) {
                  break label1335;
                }
                switch (parambass.jdField_d_of_type_Int)
                {
                default: 
                  return;
                case 1001: 
                  a(localMessageForShortVideo, "VIDEO STATUS_SEND_START progress " + localMessageForShortVideo.videoFileProgress);
                  if (localMessageForShortVideo.busiType != 1) {
                    a(localMessageForShortVideo, paramView, localMessageForShortVideo.videoFileProgress, true);
                  }
                  paramView.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(false, this);
                  akci.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(Long.valueOf(localMessageForShortVideo.uniseq));
                  return;
                  paramInt1 = 100;
                  break label96;
                }
              }
              a(paramView, false, null);
              akci.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(Long.valueOf(localMessageForShortVideo.uniseq));
              a(localMessageForShortVideo, "VIDEO STATUS_UPLOAD_FINISHED progress " + localMessageForShortVideo.videoFileProgress);
              return;
              a(localMessageForShortVideo, "VIDEO STATUS_SEND_FINISHED");
              c(localMessageForShortVideo);
              a(localMessageForShortVideo.mVideoFileSourceDir);
              a(localMessageForShortVideo, paramView, 100, true);
              a(paramView, false, null);
              akci.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(Long.valueOf(localMessageForShortVideo.uniseq));
              return;
              a(localMessageForShortVideo, "VIDEO STATUS_SEND_ERROR");
              c(localMessageForShortVideo);
              b(localMessageForShortVideo, paramView, 2131719281);
              paramView.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
              akci.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(Long.valueOf(localMessageForShortVideo.uniseq));
              return;
              a(localMessageForShortVideo, "VIDEO STATUS_SEND_CANCEL");
              paramView.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.b(paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin + paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
              c(localMessageForShortVideo);
              a(paramView);
              b(localMessageForShortVideo, paramView, 2131719281);
              b(paramView, true, this);
              akci.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(Long.valueOf(localMessageForShortVideo.uniseq));
              return;
              paramInt1 = localMessageForShortVideo.videoFileProgress;
              a(localMessageForShortVideo, "VIDEO STATUS_SEND_PROCESS " + paramInt1);
              a(localMessageForShortVideo, paramView, paramInt1);
              return;
              a(localMessageForShortVideo, "VIDEO STATUS_RECV_START");
              a(localMessageForShortVideo, paramView, localMessageForShortVideo.videoFileProgress, true);
              return;
              a(localMessageForShortVideo, "VIDEO STATUS_RECV_FINISHED");
              if (!b(localMessageForShortVideo)) {
                break;
              }
              parambass = ShortVideoUtils.a(localMessageForShortVideo, "mp4");
              a(localMessageForShortVideo, alud.a(2131714465) + parambass);
              if ((ShortVideoUtils.a()) && (bdhb.b(parambass)))
              {
                a(localMessageForShortVideo, alud.a(2131714477) + parambass);
                localObject = ShortVideoUtils.a(localMessageForShortVideo.thumbMD5, "jpg");
                a(paramView.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView, parambass, (String)localObject, localMessageForShortVideo, paramInt1, paramInt2);
                if (!localMessageForShortVideo.isSend()) {
                  new axtc(BaseApplication.getContext()).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 2001, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, 1002);
                }
              }
              a(localMessageForShortVideo, paramView, 100, true);
            } while (!localMessageForShortVideo.isMultiMsg);
            a(paramView);
            return;
            parambass = ShortVideoUtils.a(localMessageForShortVideo.thumbMD5, "jpg");
            if ((bdhb.b(parambass)) && (a(paramView.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView, parambass)))
            {
              localObject = URLDrawable.URLDrawableOptions.obtain();
              ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = j;
              ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = k;
              ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
              ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
              parambass = URLDrawable.getDrawable(new File(parambass), (URLDrawable.URLDrawableOptions)localObject);
              paramView.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView.setID(localMessageForShortVideo.uniseq);
              paramView.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView.showCover(parambass);
            }
            c(localMessageForShortVideo, paramView);
            return;
            a(localMessageForShortVideo, "VIDEO STATUS_FILE_UNSAFE");
            b(localMessageForShortVideo, paramView, 2131719275);
            if (localMessageForShortVideo.uiOperatorFlag == 2)
            {
              paramView.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
              QQToast.a(this.jdField_a_of_type_AndroidContentContext, 2131720113, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298914));
              return;
            }
            QQToast.a(this.jdField_a_of_type_AndroidContentContext, 2131720138, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298914));
            return;
            a(localMessageForShortVideo, "VIDEO STATUS_RECV_ERROR");
            a(paramView);
            c(localMessageForShortVideo, paramView);
          } while (parambass.jdField_g_of_type_Int == -5100528);
          QQToast.a(this.jdField_a_of_type_AndroidContentContext, 2131720140, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298914));
          return;
          a(localMessageForShortVideo, "VIDEO STATUS_FILE_EXPIRED");
          parambass = ShortVideoUtils.a(localMessageForShortVideo.thumbMD5, "jpg");
          if ((bdhb.b(parambass)) && (a(paramView.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView, parambass)))
          {
            a(localMessageForShortVideo, alud.a(2131714443) + parambass);
            localObject = URLDrawable.URLDrawableOptions.obtain();
            ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
            ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
            parambass = URLDrawable.getDrawable(new File(parambass), (URLDrawable.URLDrawableOptions)localObject);
            paramView.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView.setID(localMessageForShortVideo.uniseq);
            paramView.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView.showCover(parambass);
          }
          b(localMessageForShortVideo, paramView, 2131719276);
          return;
          a(localMessageForShortVideo, "VIDEO STATUS_RECV_CANCEL");
          return;
          paramInt1 = localMessageForShortVideo.videoFileProgress;
          a(localMessageForShortVideo, "VIDEO STATUS_RECV_PROCESS " + paramInt1);
          a(localMessageForShortVideo, paramView, paramInt1, true);
          return;
        } while ((parambass.jdField_b_of_type_Int != 7) && (parambass.jdField_b_of_type_Int != 18) && (parambass.jdField_b_of_type_Int != 16));
        switch (parambass.jdField_d_of_type_Int)
        {
        default: 
          return;
        case 2001: 
          a(localMessageForShortVideo, "THUMB STATUS_RECV_START");
          return;
        case 2003: 
          a(localMessageForShortVideo, "THUMB STATUS_RECV_FINISHED");
          localObject = ShortVideoUtils.a(localMessageForShortVideo.thumbMD5, "jpg");
          parambass = ShortVideoUtils.a(localMessageForShortVideo, "mp4");
          if ((!bdhb.b(parambass)) || (!b(localMessageForShortVideo))) {
            break label1519;
          }
          a(localMessageForShortVideo, alud.a(2131714437) + (String)localObject);
        }
      } while (!ShortVideoUtils.a());
      a(paramView.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView, parambass, (String)localObject, localMessageForShortVideo, paramInt1, paramInt2);
      return;
      if (!bdhb.b((String)localObject)) {
        break;
      }
    } while (!a(paramView.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView, (String)localObject));
    label1335:
    label1519:
    a(localMessageForShortVideo, alud.a(2131714425) + (String)localObject);
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mRequestWidth = j;
    localURLDrawableOptions.mRequestHeight = k;
    localURLDrawableOptions.mLoadingDrawable = jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
    localURLDrawableOptions.mFailedDrawable = jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
    Object localObject = URLDrawable.getDrawable(new File((String)localObject), localURLDrawableOptions);
    paramView.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView.setID(localMessageForShortVideo.uniseq);
    paramView.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView.showCover((Drawable)localObject);
    if (!bdhb.b(parambass))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localMessageForShortVideo, true))
      {
        a(localMessageForShortVideo, true);
        return;
      }
      c(localMessageForShortVideo, paramView);
      return;
    }
    if (ShortVideoUtils.a())
    {
      a(paramView);
      return;
    }
    c(localMessageForShortVideo, paramView);
    return;
    paramView.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView.setID(localMessageForShortVideo.uniseq);
    paramView.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView.showCover(bayu.a());
    return;
    a(localMessageForShortVideo, "THUMB STATUS_FILE_EXPIRED");
    a(localMessageForShortVideo, "THUMB STATUS_RECV_ERROR");
    parambass = ShortVideoUtils.a(localMessageForShortVideo, "mp4");
    if (bdhb.b(parambass))
    {
      a(localMessageForShortVideo, alud.a(2131714422) + parambass);
      if (ShortVideoUtils.a())
      {
        localObject = ShortVideoUtils.a(localMessageForShortVideo.thumbMD5, "jpg");
        a(paramView.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView, parambass, (String)localObject, localMessageForShortVideo, paramInt1, paramInt2);
      }
    }
    for (;;)
    {
      a(paramView);
      return;
      paramView.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView.setID(localMessageForShortVideo.uniseq);
      paramView.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView.showCover(jdField_a_of_type_AndroidGraphicsDrawableColorDrawable);
    }
  }
  
  public void a(View paramView, ChatMessage paramChatMessage)
  {
    int j = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131296300);
    if (paramChatMessage.isSend())
    {
      paramView.setPadding(BaseChatItemLayout.j, BaseChatItemLayout.jdField_g_of_type_Int, j, BaseChatItemLayout.jdField_h_of_type_Int);
      return;
    }
    paramView.setPadding(j, BaseChatItemLayout.jdField_g_of_type_Int, BaseChatItemLayout.j, BaseChatItemLayout.jdField_h_of_type_Int);
  }
  
  public void a(QQAppInterface paramQQAppInterface, BaseChatItemLayout paramBaseChatItemLayout, agbi paramagbi, MessageRecord paramMessageRecord)
  {
    boolean bool2 = false;
    if ((paramMessageRecord instanceof MessageForShortVideo))
    {
      paramMessageRecord = (MessageForShortVideo)paramMessageRecord;
      if (paramMessageRecord.redBagType != LocalMediaInfo.REDBAG_TYPE_GET) {
        break label108;
      }
      if (paramagbi.jdField_e_of_type_Int != LocalMediaInfo.REDBAG_TYPE_GET) {
        break label40;
      }
    }
    label40:
    label108:
    do
    {
      do
      {
        return;
        paramagbi.jdField_e_of_type_Int = LocalMediaInfo.REDBAG_TYPE_GET;
        paramQQAppInterface = new agbb(this, paramQQAppInterface);
        paramagbi = new SpannableString(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131720116));
        paramagbi.setSpan(new ForegroundColorSpan(-1), 0, paramagbi.length(), 17);
        paramBaseChatItemLayout.setTailMessage(true, paramagbi, paramQQAppInterface, azjh.a());
        return;
        if ((!paramMessageRecord.CheckIsDanceVideo()) || (!azgd.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int))) {
          break;
        }
      } while (paramagbi.jdField_e_of_type_Int == 2);
      paramagbi.jdField_e_of_type_Int = 2;
      boolean bool3 = axpm.a();
      boolean bool4 = azla.g(paramQQAppInterface);
      paramQQAppInterface = new agbc(this, bool3, bool4, paramQQAppInterface);
      paramagbi = new SpannableString(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131720104));
      paramagbi.setSpan(new ForegroundColorSpan(-1), 0, paramagbi.length(), 17);
      boolean bool1 = bool2;
      if (bool3)
      {
        bool1 = bool2;
        if (bool4) {
          bool1 = true;
        }
      }
      paramBaseChatItemLayout.setTailMessage(true, paramagbi, paramQQAppInterface, bool1);
      return;
    } while (paramagbi.jdField_e_of_type_Int == 0);
    paramagbi.jdField_e_of_type_Int = 0;
    paramBaseChatItemLayout.setTailMessage(false, null, null);
  }
  
  void a(MessageForShortVideo paramMessageForShortVideo)
  {
    if (a(paramMessageForShortVideo)) {
      return;
    }
    azdx localazdx = azdd.a(2, 2);
    azdg localazdg = paramMessageForShortVideo.getDownloadInfo(localazdx.jdField_b_of_type_Int);
    localazdg.i = ShortVideoUtils.a(paramMessageForShortVideo.thumbMD5, "jpg");
    localazdg.a(paramMessageForShortVideo.istroop, 1);
    localazdg.jdField_f_of_type_Int = 2;
    localazdg.jdField_g_of_type_Int = 2;
    localazdx.a(localazdg);
    localazdx.a(paramMessageForShortVideo);
    azdd.a(localazdx, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
  }
  
  public void a(MessageForShortVideo paramMessageForShortVideo, long paramLong)
  {
    if ((paramMessageForShortVideo != null) && (!bdew.a().a(paramMessageForShortVideo, "0X8009AA6")))
    {
      bdew.a().a(paramMessageForShortVideo, "0X8009AA6");
      ShortVideoUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, paramMessageForShortVideo.frienduin, 1, 2, paramMessageForShortVideo.videoFileTime * 1000, paramLong);
    }
  }
  
  public void a(MessageForShortVideo paramMessageForShortVideo, agbi paramagbi)
  {
    a(paramMessageForShortVideo, "startUploadVideo：" + paramMessageForShortVideo.toString());
    Object localObject = ShortVideoUtils.a(paramMessageForShortVideo, "mp4");
    String str = ShortVideoUtils.a(paramMessageForShortVideo.thumbMD5, "jpg");
    if (!bdhb.b((String)localObject))
    {
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, 1, 2131720145, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298914));
      paramagbi.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
      paramMessageForShortVideo.videoFileStatus = 1005;
      return;
    }
    if (!bdhb.b(str))
    {
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, 1, 2131720146, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298914));
      paramagbi.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
      paramMessageForShortVideo.videoFileStatus = 1005;
      return;
    }
    ((axwx)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(326)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, paramMessageForShortVideo, paramMessageForShortVideo.videoFileName);
    localObject = azdd.a(1, 2);
    ((azdx)localObject).a(azdd.a(2, paramMessageForShortVideo, (azdx)localObject));
    azdd.a((azdx)localObject, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    a(paramMessageForShortVideo, paramagbi, paramMessageForShortVideo.videoFileProgress, true);
  }
  
  void a(MessageForShortVideo paramMessageForShortVideo, agbi paramagbi, int paramInt)
  {
    int j = ShortVideoUtils.a(paramInt, 10);
    if (paramMessageForShortVideo.busiType == 1)
    {
      if (j < 60) {
        return;
      }
      if (paramMessageForShortVideo.progressTask != null)
      {
        this.jdField_b_of_type_AndroidOsHandler.removeCallbacks(paramMessageForShortVideo.progressTask);
        paramMessageForShortVideo.progressTask = null;
        a(paramMessageForShortVideo, "VIDEO STATUS_SEND_PROCESS CLOSE_TASK PROCESS:" + j);
      }
    }
    a(paramMessageForShortVideo, paramagbi, paramInt, true);
  }
  
  protected void a(MessageForShortVideo paramMessageForShortVideo, agbi paramagbi, int paramInt1, int paramInt2)
  {
    if ((ShortVideoUtils.a(paramMessageForShortVideo.videoFileProgress, 10) > 60) || (paramInt2 > 60)) {}
    do
    {
      return;
      paramInt2 = ShortVideoUtils.a(paramInt2, 0);
      paramagbi.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setDrawStatus(1);
      paramagbi.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setAnimProgress(paramInt2, paramMessageForShortVideo.frienduin + paramMessageForShortVideo.uniseq);
      paramagbi.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setVisibility(0);
      paramagbi.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      if ((paramMessageForShortVideo.progressTask != null) && (bdin.d(this.jdField_a_of_type_AndroidContentContext)))
      {
        paramMessageForShortVideo.progress += 3;
        this.jdField_b_of_type_AndroidOsHandler.postDelayed(paramMessageForShortVideo.progressTask, 1000L);
      }
    } while (!QLog.isColorLevel());
    QLog.w("ShortVideoRealItemBuilder", 2, "[setProgress] uinseq:" + paramMessageForShortVideo.uniseq + ", p:" + paramInt1 + ", progress:" + paramInt2);
  }
  
  public void a(MessageForShortVideo paramMessageForShortVideo, agbi paramagbi, int paramInt, boolean paramBoolean)
  {
    paramagbi.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setDrawStatus(1);
    paramagbi.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setAnimProgress(paramInt, paramMessageForShortVideo.frienduin + paramMessageForShortVideo.uniseq);
    paramagbi.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setVisibility(0);
    paramagbi.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    if (QLog.isColorLevel()) {
      QLog.w("ShortVideoRealItemBuilder", 2, "[setProgress] uinseq:" + paramMessageForShortVideo.uniseq + ", p:" + paramInt);
    }
  }
  
  void a(MessageForShortVideo paramMessageForShortVideo, boolean paramBoolean)
  {
    if (paramMessageForShortVideo.videoFileStatus == 5002)
    {
      a(paramMessageForShortVideo, alud.a(2131714442));
      return;
    }
    azdx localazdx = azdd.a(2, 2);
    azdg localazdg = paramMessageForShortVideo.getDownloadInfo(localazdx.jdField_b_of_type_Int);
    localazdg.h = ShortVideoUtils.a(paramMessageForShortVideo, "mp4");
    localazdg.a(paramMessageForShortVideo.istroop, 0);
    if (paramBoolean) {}
    for (int j = 2;; j = 1)
    {
      localazdg.jdField_f_of_type_Int = j;
      localazdg.jdField_g_of_type_Int = 2;
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoRealItemBuilder", 2, " startDownloadVideo downloadvideo fileType==" + localazdg.jdField_e_of_type_Int + ", uniseq:" + paramMessageForShortVideo.uniseq);
      }
      localazdx.a(localazdg);
      localazdx.a(paramMessageForShortVideo);
      azdd.a(localazdx, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      return;
    }
  }
  
  protected void a(CropBubbleVideoView paramCropBubbleVideoView, String paramString1, String paramString2, MessageForShortVideo paramMessageForShortVideo, int paramInt1, int paramInt2)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder().append("playShortVideoByPath uniseq=").append(paramMessageForShortVideo.uniseq).append(", videoPath = ");
      if (paramString1 != null)
      {
        localObject = paramString1;
        localStringBuilder = localStringBuilder.append((String)localObject).append(", thumbPath = ");
        if (paramString2 == null) {
          break label223;
        }
        localObject = paramString2;
        label64:
        QLog.d("ShortVideoRealItemBuilder", 2, (String)localObject);
      }
    }
    else
    {
      paramCropBubbleVideoView.setID(paramMessageForShortVideo.uniseq);
      localObject = new VideoPlayParam();
      ((VideoPlayParam)localObject).mSceneId = 100;
      ((VideoPlayParam)localObject).mSceneName = axba.a(100);
      ((VideoPlayParam)localObject).mIsMute = true;
      ((VideoPlayParam)localObject).mCallback = new agbd(this);
      ((VideoPlayParam)localObject).mIsLocal = true;
      ((VideoPlayParam)localObject).mIsLoop = true;
      ((VideoPlayParam)localObject).mVideoPath = paramString1;
      ((VideoPlayParam)localObject).mFileSize = paramMessageForShortVideo.videoFileSize;
      paramCropBubbleVideoView.setVideoParam((VideoPlayParam)localObject);
      paramString1 = new apkp(-10065297, 100, 100);
      if (!TextUtils.isEmpty(paramString2)) {
        break label231;
      }
      paramCropBubbleVideoView.setCoverDrawable(paramString1);
    }
    for (;;)
    {
      if (e()) {
        paramCropBubbleVideoView.play();
      }
      jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet.add(paramCropBubbleVideoView);
      return;
      localObject = "null";
      break;
      label223:
      localObject = "null";
      break label64;
      label231:
      paramCropBubbleVideoView.setCoverDrawable(URLDrawable.getDrawable(ShortVideoUtils.a(paramString2).toString(), paramInt1, paramInt2, paramString1, paramString1));
    }
  }
  
  void a(String paramString)
  {
    ThreadManager.post(new ShortVideoRealItemBuilder.4(this, paramString), 5, null, false);
  }
  
  public boolean a(ChatMessage paramChatMessage, BaseChatItemLayout paramBaseChatItemLayout)
  {
    if (paramChatMessage.isMultiMsg) {}
    do
    {
      do
      {
        do
        {
          return false;
        } while (!paramChatMessage.isSendFromLocal());
        paramChatMessage = (MessageForShortVideo)paramChatMessage;
        if ((paramChatMessage.md5 == null) && (paramChatMessage.videoFileStatus == 1004)) {
          return true;
        }
      } while ((paramChatMessage.md5 == null) || (paramChatMessage.videoFileStatus == 5002));
      if ((paramChatMessage.busiType == 1) && (paramChatMessage.uiOperatorFlag == 1) && (paramChatMessage.videoFileStatus == 1004)) {
        return true;
      }
      paramBaseChatItemLayout = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramChatMessage.frienduin, paramChatMessage.uniseq);
      if ((paramBaseChatItemLayout instanceof barf))
      {
        if (((barf)paramBaseChatItemLayout).c() == 1005L) {}
        for (boolean bool = true;; bool = false) {
          return bool;
        }
      }
      if (paramChatMessage.videoFileStatus == 1005) {
        return true;
      }
    } while ((paramChatMessage.videoFileProgress == 100) || (paramChatMessage.videoFileStatus == 1003) || (paramChatMessage.videoFileStatus == 2003) || (paramChatMessage.isAllowAutoDown != true));
    return true;
  }
  
  protected boolean a(CropBubbleVideoView paramCropBubbleVideoView, String paramString)
  {
    paramCropBubbleVideoView = paramCropBubbleVideoView.getCoverDrawable();
    if (paramCropBubbleVideoView == null) {
      return true;
    }
    return (!(paramCropBubbleVideoView instanceof URLDrawable)) || (!((URLDrawable)paramCropBubbleVideoView).getURL().getPath().equals(paramString));
  }
  
  public bdpk[] a(View paramView)
  {
    bdpi localbdpi = new bdpi();
    paramView = (agbi)aepi.a(paramView);
    MessageForShortVideo localMessageForShortVideo = (MessageForShortVideo)paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
    if (localMessageForShortVideo != null)
    {
      if (!localMessageForShortVideo.isMultiMsg) {
        break label48;
      }
      a(localbdpi, localMessageForShortVideo, paramView);
    }
    for (;;)
    {
      return localbdpi.a();
      label48:
      b(localbdpi, localMessageForShortVideo, paramView);
    }
  }
  
  public void a_(ChatMessage paramChatMessage)
  {
    azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A5A7", "0X800A5A7", 0, 0, "3", "", "", "");
  }
  
  public bdpi b(bdpi parambdpi, ChatMessage paramChatMessage, aeqz paramaeqz)
  {
    int n = 1;
    int k = 0;
    int j = 0;
    paramChatMessage = (MessageForShortVideo)paramChatMessage;
    paramaeqz = (agbi)paramaeqz;
    b(parambdpi, this.jdField_a_of_type_AndroidContentContext);
    int m;
    label160:
    int i1;
    if ((!TextUtils.isEmpty(paramChatMessage.md5)) && ((!paramChatMessage.mPreUpload) || (!TextUtils.isEmpty(paramChatMessage.mLocalMd5))))
    {
      String str1 = ShortVideoUtils.a(paramChatMessage.thumbMD5, "jpg");
      String str2 = ShortVideoUtils.a(paramChatMessage, "mp4");
      if (bdhb.b(str1)) {
        if ((paramaeqz.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.c != null) && (paramaeqz.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.c.getVisibility() == 0))
        {
          m = 1;
          if (m == 0)
          {
            parambdpi.a(2131366760, this.jdField_a_of_type_AndroidContentContext.getString(2131692837), 2130838678);
            a(paramChatMessage, parambdpi);
            k = n;
            if (bdhb.b(str2))
            {
              j = 1;
              k = n;
            }
            n = j;
            i1 = k;
            if (m == 0)
            {
              a(parambdpi, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, paramChatMessage);
              i1 = k;
            }
          }
        }
      }
    }
    for (n = j;; n = k)
    {
      a(parambdpi, paramChatMessage);
      if (n != 0) {
        parambdpi.a(2131366017, this.jdField_a_of_type_AndroidContentContext.getString(2131692401), 2130838677);
      }
      if (i1 != 0) {
        b(paramChatMessage, parambdpi);
      }
      super.c(parambdpi, this.jdField_a_of_type_AndroidContentContext);
      super.e(parambdpi, this.jdField_a_of_type_AndroidContentContext);
      return parambdpi;
      k = 0;
      break label160;
      m = 0;
      break;
      i1 = 0;
    }
  }
  
  public void b(agbi paramagbi)
  {
    if (!paramagbi.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.a(paramagbi.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin + paramagbi.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq)) {
      paramagbi.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setVisibility(8);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.w("ShortVideoRealItemBuilder", 2, "[disProgress] set mProgressView gone");
      }
      return;
      paramagbi.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setAnimRunnableListener(new agbg(this, paramagbi));
    }
  }
  
  public void b(MessageForShortVideo paramMessageForShortVideo)
  {
    if (TextUtils.isEmpty(paramMessageForShortVideo.md5)) {
      a(paramMessageForShortVideo, "Forward menu clicked, md5 is empty.");
    }
    do
    {
      return;
      Bundle localBundle = new Bundle();
      localBundle.putInt("forward_type", 21);
      localBundle.putBoolean("forward_need_sendmsg", true);
      String str1 = ShortVideoUtils.a(paramMessageForShortVideo.thumbMD5, "jpg");
      localBundle.putString("forward_thumb", str1);
      localBundle.putString("from_uin", ShortVideoUtils.d(paramMessageForShortVideo));
      localBundle.putInt("from_uin_type", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
      localBundle.putString("from_session_uin", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      localBundle.putInt("from_busi_type", paramMessageForShortVideo.busiType);
      localBundle.putInt("file_send_size", paramMessageForShortVideo.videoFileSize);
      localBundle.putInt("file_send_duration", paramMessageForShortVideo.videoFileTime);
      localBundle.putString("file_name", paramMessageForShortVideo.videoFileName);
      localBundle.putInt("file_format", paramMessageForShortVideo.videoFileFormat);
      localBundle.putInt("selection_mode", this.jdField_b_of_type_Int);
      String str2 = ShortVideoUtils.c(paramMessageForShortVideo);
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoRealItemBuilder", 2, "Forward menu clicked, videoPath=" + str2 + ",videoPath = " + str2 + ", " + paramMessageForShortVideo.toLogString());
      }
      localBundle.putString("file_send_path", str2);
      localBundle.putString("thumbfile_send_path", str1);
      localBundle.putString("file_shortvideo_md5", paramMessageForShortVideo.md5);
      if (!TextUtils.isEmpty(paramMessageForShortVideo.mLocalMd5)) {
        localBundle.putString("file_shortvideo_local_md5", paramMessageForShortVideo.mLocalMd5);
      }
      localBundle.putInt("thumbfile_send_width", paramMessageForShortVideo.thumbWidth);
      localBundle.putInt("thumbfile_send_height", paramMessageForShortVideo.thumbHeight);
      localBundle.putString("thumbfile_md5", paramMessageForShortVideo.thumbMD5);
      localBundle.putString("file_source", paramMessageForShortVideo.fileSource);
      localBundle.putString("file_uuid", paramMessageForShortVideo.uuid);
      localBundle.putInt("file_thumb_Size", paramMessageForShortVideo.thumbFileSize);
      localBundle.putBoolean("support_progressive", paramMessageForShortVideo.supportProgressive);
      localBundle.putInt("file_width", paramMessageForShortVideo.fileWidth);
      localBundle.putInt("file_height", paramMessageForShortVideo.fileHeight);
      localBundle.putInt("special_video_type", paramMessageForShortVideo.specialVideoType);
      localBundle.putLong("from_msg_uniseq", paramMessageForShortVideo.uniseq);
      if (paramMessageForShortVideo.CheckIsHotVideo())
      {
        localBundle.putString("hot_video_icon", paramMessageForShortVideo.hotVideoIconUrl);
        localBundle.putString("hot_video_icon_sub", paramMessageForShortVideo.hotVideoSubIconUrl);
        localBundle.putString("hot_video_title", paramMessageForShortVideo.hotVideoTitle);
        localBundle.putString("hot_video_url", paramMessageForShortVideo.hotVideoUrl);
      }
      if ((paramMessageForShortVideo.redBagType == LocalMediaInfo.REDBAG_TYPE_GET) && (paramMessageForShortVideo.isSend()))
      {
        localBundle.putInt("param_key_redbag_type", paramMessageForShortVideo.redBagType);
        localBundle.putString("param_key_redbag_video_id", paramMessageForShortVideo.shortVideoId);
      }
      if (!TextUtils.isEmpty(paramMessageForShortVideo.templateId))
      {
        localBundle.putString("widgetinfo", paramMessageForShortVideo.templateId);
        localBundle.putString("key_camera_material_name", paramMessageForShortVideo.templateName);
      }
      if (bdhb.b(str2))
      {
        localBundle.putBoolean("k_dataline", true);
        localBundle.putString("forward_extra", str2);
        localBundle.putBoolean("direct_send_if_dataline_forward", true);
        localBundle.putInt("forward_source_uin_type", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
      }
      paramMessageForShortVideo = new Intent();
      paramMessageForShortVideo.putExtras(localBundle);
    } while (this.jdField_a_of_type_AndroidContentContext == null);
    aryv.a((Activity)this.jdField_a_of_type_AndroidContentContext, paramMessageForShortVideo, 21);
  }
  
  public void b(MessageForShortVideo paramMessageForShortVideo, agbi paramagbi)
  {
    if (paramMessageForShortVideo == null) {
      return;
    }
    a(paramMessageForShortVideo, "reForwardVideo：" + paramMessageForShortVideo.toString());
    if (!bdhb.b(ShortVideoUtils.a(paramMessageForShortVideo.thumbMD5, "jpg")))
    {
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, 1, 2131720146, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298914));
      paramagbi.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
      paramMessageForShortVideo.videoFileStatus = 1005;
      return;
    }
    if (!TextUtils.isEmpty(paramMessageForShortVideo.videoFileName))
    {
      ((axwx)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(326)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, paramMessageForShortVideo, paramMessageForShortVideo.videoFileName);
      paramagbi = azdd.a(4, 2);
      paramagbi.a(azdd.a(2, paramMessageForShortVideo, paramagbi));
      azdd.a(paramagbi, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      return;
    }
    a(paramMessageForShortVideo, "ShortVideoRealItemBuilder:reForwardVideo() path is empty");
  }
  
  void b(MessageForShortVideo paramMessageForShortVideo, agbi paramagbi, int paramInt)
  {
    paramagbi.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.b(paramMessageForShortVideo.frienduin + paramMessageForShortVideo.uniseq);
    paramagbi.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setVisibility(0);
    paramagbi.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setImageResource(2130849204);
    paramagbi.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setDrawStatus(3);
    if (QLog.isColorLevel()) {
      QLog.w("ShortVideoRealItemBuilder", 2, "[showWarnProgress] set mProgressView visible");
    }
    paramagbi.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    paramagbi.jdField_a_of_type_AndroidWidgetTextView.setText(paramInt);
  }
  
  public void c(MessageForShortVideo paramMessageForShortVideo, agbi paramagbi)
  {
    paramagbi.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.b(paramMessageForShortVideo.frienduin + paramMessageForShortVideo.uniseq);
    paramagbi.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setDrawStatus(2);
    paramagbi.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setVisibility(0);
    paramagbi.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
  }
  
  public void d()
  {
    super.d();
  }
  
  public void onClick(View paramView)
  {
    long l = System.currentTimeMillis();
    if ((l - jdField_d_of_type_Long < 500L) && (l > jdField_d_of_type_Long)) {
      if (QLog.isColorLevel()) {
        QLog.e("ShortVideoRealItemBuilder", 2, "click too offen, please try again later!");
      }
    }
    Object localObject;
    MessageForShortVideo localMessageForShortVideo;
    StringBuilder localStringBuilder1;
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              return;
              jdField_d_of_type_Long = l;
              if (paramView.getId() != 2131364201) {
                break;
              }
              localObject = (MessageRecord)paramView.getTag();
            } while (localObject == null);
            ((FlashChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(217)).a(paramView.getContext(), (MessageRecord)localObject);
            return;
            localObject = (agbi)aepi.a(paramView);
            localMessageForShortVideo = (MessageForShortVideo)((agbi)localObject).jdField_a_of_type_ComTencentMobileqqDataChatMessage;
          } while (paramView.getId() == 2131364215);
          if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c())
          {
            QQToast.a(this.jdField_a_of_type_AndroidContentContext, 2131696353, 1).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298914));
            return;
          }
          if (paramView.getId() == 2131364173) {
            a((agbi)localObject, localMessageForShortVideo, false);
          }
          if (paramView.getId() != 2131364192) {
            break;
          }
        } while (((agbi)localObject).jdField_a_of_type_ComTencentMobileqqDataChatMessage.isMultiMsg);
        paramView = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(((agbi)localObject).jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin, ((agbi)localObject).jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
        if ((!(paramView instanceof ShortVideoUploadProcessor)) || (!((ShortVideoUploadProcessor)paramView).jdField_g_of_type_Boolean)) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("ShortVideoRealItemBuilder", 2, "shortVideoCancel pauseOperator BDHSuccess!");
      return;
      localStringBuilder1 = new StringBuilder();
      paramView = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(((agbi)localObject).jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin, ((agbi)localObject).jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
      if (!(paramView instanceof ShortVideoUploadProcessor)) {
        break;
      }
      ((ShortVideoUploadProcessor)paramView).c();
      localStringBuilder1.append("\n shortVideoCancel uploadProcess pause!");
      ShortVideoUtils.c("0X800A7EE", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
    } while (!QLog.isColorLevel());
    QLog.d("ShortVideoRealItemBuilder", 2, "shortVideoCancel pauseOperator info:" + localStringBuilder1.toString());
    return;
    akci localakci = (akci)akci.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(Long.valueOf(((agbi)localObject).jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq));
    StringBuilder localStringBuilder2 = localStringBuilder1.append("\n shortVideoCancel uniseq:");
    if (localakci != null)
    {
      paramView = Long.valueOf(localakci.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.uniseq);
      label417:
      paramView = localStringBuilder2.append(paramView).append(", msgUniseq:").append(((agbi)localObject).jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq).append(", encodeFinish:");
      if ((localakci == null) || (!localakci.jdField_a_of_type_Boolean)) {
        break label610;
      }
    }
    label610:
    for (boolean bool = true;; bool = false)
    {
      paramView.append(bool);
      if ((localakci == null) || (localakci.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.uniseq != ((agbi)localObject).jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq) || (!localakci.a())) {
        break;
      }
      this.jdField_b_of_type_AndroidOsHandler.removeCallbacks(localMessageForShortVideo.progressTask);
      localMessageForShortVideo.progressTask = null;
      localMessageForShortVideo.videoFileStatus = 1004;
      localMessageForShortVideo.md5 = null;
      localMessageForShortVideo.serial();
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localMessageForShortVideo.frienduin, localMessageForShortVideo.istroop, localMessageForShortVideo.uniseq, localMessageForShortVideo.msgData);
      axwx.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localMessageForShortVideo.frienduin, localMessageForShortVideo.uniseq);
      i();
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo = null;
      jdField_h_of_type_Boolean = false;
      break;
      paramView = "-1";
      break label417;
    }
    super.onClick(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.ShortVideoRealItemBuilder
 * JD-Core Version:    0.7.0.1
 */