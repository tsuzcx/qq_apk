package com.tencent.mobileqq.activity.aio.item;

import aagn;
import acvv;
import aeze;
import aezf;
import aezk;
import aezy;
import afbb;
import afce;
import agli;
import agod;
import agoe;
import agof;
import agog;
import agoh;
import agoi;
import agoj;
import agok;
import agzl;
import akrx;
import akuq;
import amtj;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
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
import aqww;
import atky;
import awdi;
import aydq;
import azjm;
import azjn;
import babd;
import badr;
import bahm;
import bbqf;
import bbqh;
import bbqp;
import bbqx;
import bbta;
import bbwb;
import bbxo;
import bcef;
import bcgr;
import bftf;
import bfth;
import bgaz;
import bgbb;
import bjnw;
import bjon;
import bkkh;
import bkov;
import bkpf;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.Utils;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.MultiForwardActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.MediaPlayerManager;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.photo.AIOImageProviderService;
import com.tencent.mobileqq.activity.chathistory.ChatHistoryBubbleListForTroopFragment;
import com.tencent.mobileqq.activity.history.ChatHistoryActivity;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.shortvideo.EncodeVideoTask;
import com.tencent.mobileqq.activity.shortvideo.EncodeVideoTask.ResultListener;
import com.tencent.mobileqq.activity.shortvideo.EncodeVideoTask.ThumbInfo;
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
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.shortvideo.ShortVideoConstants;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils.ShortVideoPlayConfig;
import com.tencent.mobileqq.shortvideo.mediadevice.CodecParam;
import com.tencent.mobileqq.transfile.BaseTransProcessor;
import com.tencent.mobileqq.transfile.FileMsg;
import com.tencent.mobileqq.transfile.ShortVideoUploadProcessor;
import com.tencent.mobileqq.transfile.TransFileController;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.videoplatform.api.VideoPlayParam;
import com.tencent.mobileqq.videoplatform.view.CropBubbleVideoView;
import com.tencent.mobileqq.widget.BubbleImageView;
import com.tencent.mobileqq.widget.MessageProgressView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_SDKMgr;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
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
import xwa;
import yns;

public class ShortVideoRealItemBuilder
  extends agli
  implements aezk, afbb, ShortVideoConstants
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
  private EncodeVideoTask.ResultListener jdField_a_of_type_ComTencentMobileqqActivityShortvideoEncodeVideoTask$ResultListener = new agoj(this);
  private MessageForShortVideo jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo;
  private ListView jdField_a_of_type_ComTencentWidgetListView;
  private Handler b;
  public long c;
  
  static
  {
    URLDrawableHelper.initVideoAIOSizeByDpc();
    jdField_f_of_type_Boolean = true;
    jdField_c_of_type_Int = 960;
    jdField_d_of_type_Int = 720;
    jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap();
    jdField_a_of_type_JavaUtilHashMap = new HashMap();
    jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet = new CopyOnWriteArraySet();
    Resources localResources = BaseApplicationImpl.sApplication.getResources();
    jdField_g_of_type_Int = BaseChatItemLayout.jdField_f_of_type_Int;
    jdField_g_of_type_Int = Math.min(AIOUtils.dp2px(320.0F, localResources), jdField_g_of_type_Int);
    jdField_h_of_type_Int = AIOUtils.dp2px(100.0F, localResources);
    i = AIOUtils.dp2px(100.0F, localResources);
    jdField_e_of_type_Int = AIOUtils.dp2px(CodecParam.FINAL_DST_VIDEO_WIDTH, localResources);
    jdField_f_of_type_Int = AIOUtils.dp2px(CodecParam.FINAL_DST_VIDEO_HEIGHT, localResources);
    jdField_a_of_type_AndroidGraphicsDrawableColorDrawable = new aqww(-10065297, jdField_e_of_type_Int, jdField_f_of_type_Int);
  }
  
  public ShortVideoRealItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    this.jdField_b_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    this.jdField_c_of_type_Long = 0L;
    if (paramAIOAnimationConatiner != null) {
      this.jdField_a_of_type_ComTencentWidgetListView = paramAIOAnimationConatiner.a();
    }
    ShortVideoUtils.loadShortVideoSo(paramQQAppInterface);
    ShortVideoUtils.ShortVideoPlayConfig.initConfig();
    h();
  }
  
  public static List<? extends Entity> a(EntityManager paramEntityManager, Class<? extends Entity> paramClass, String paramString1, String paramString2, String[] paramArrayOfString)
  {
    return paramEntityManager.query(paramClass, paramString1, false, paramString2, paramArrayOfString, null, null, null, null, null);
  }
  
  private void a(long paramLong)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder().append("doEncodeNext, curMsg:");
      if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo != null)
      {
        localObject = Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.uniseq);
        QLog.i("ShortVideoRealItemBuilder", 2, localObject + ", seq:" + paramLong + ", contains:" + EncodeVideoTask.mEncodeList.containsKey(Long.valueOf(paramLong)));
      }
    }
    else
    {
      EncodeVideoTask.mEncodeList.remove(Long.valueOf(paramLong));
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
  
  private void a(agok paramagok, View paramView)
  {
    if (a(paramagok))
    {
      if (paramagok.b == null)
      {
        paramagok.b = new ImageView(this.jdField_a_of_type_AndroidContentContext);
        paramagok.b.setImageResource(2130838310);
        paramagok.b.setId(2131364460);
        RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
        localLayoutParams.bottomMargin = AIOUtils.dp2px(16.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
        localLayoutParams.addRule(8, 2131364441);
        localLayoutParams.addRule(0, 2131364441);
        localLayoutParams.addRule(1, 0);
        if ((paramView instanceof ViewGroup)) {
          ((ViewGroup)paramView).addView(paramagok.b, localLayoutParams);
        }
      }
      a(paramagok, true, this);
      return;
    }
    a(paramagok, false, null);
  }
  
  private void a(agok paramagok, MessageForShortVideo paramMessageForShortVideo, boolean paramBoolean)
  {
    if (paramMessageForShortVideo.md5 == null) {
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, 2131718442, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299076));
    }
    String str;
    do
    {
      for (;;)
      {
        return;
        if (paramMessageForShortVideo.redBagType == LocalMediaInfo.REDBAG_TYPE_GET) {
          bbwb.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, true);
        }
        akrx.b("", "0X8006A1C");
        akuq.a("shortvideo_bubble", null);
        xwa.a("story_grp", "aio_msg", 0, 0, new String[] { "", "", "", "" });
        str = ShortVideoUtils.getShortVideoThumbPicPath(paramMessageForShortVideo.thumbMD5, "jpg");
        if (FileUtils.fileExistsAndNotEmpty(ShortVideoUtils.getShortVideoSavePath(paramMessageForShortVideo, "mp4"))) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.d("ShortVideoRealItemBuilder", 2, "onClick, video file not exist");
        }
        if (paramMessageForShortVideo.videoFileStatus == 5002)
        {
          b(paramMessageForShortVideo, paramagok, 2131717739);
          QQToast.a(this.jdField_a_of_type_AndroidContentContext, 2131718475, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299076));
        }
        while (!paramMessageForShortVideo.isSend())
        {
          new badr(BaseApplication.getContext()).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 2001, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin, 1003);
          return;
          a(paramMessageForShortVideo, false);
          a(paramMessageForShortVideo, paramagok, paramMessageForShortVideo.videoFileProgress, false);
        }
      }
    } while (!FileUtils.fileExistsAndNotEmpty(str));
    bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800561C", "0X800561C", 0, 0, "", "", "", "");
    if (TVK_SDKMgr.isInstalled(this.jdField_a_of_type_AndroidContentContext))
    {
      a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, paramMessageForShortVideo, paramagok.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramBoolean, false, true, true, null);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoRealItemBuilder", 2, "onClick, sdk is not installed");
    }
    QQToast.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131697201), 0).b(BaseApplicationImpl.getApplication().getResources().getDimensionPixelSize(2131299076));
  }
  
  private void a(agok paramagok, boolean paramBoolean, View.OnClickListener paramOnClickListener)
  {
    if (paramBoolean) {
      if (paramagok.b != null)
      {
        paramagok.b.setVisibility(0);
        paramagok.b.setOnClickListener(paramOnClickListener);
      }
    }
    while (paramagok.b == null) {
      return;
    }
    paramagok.b.setVisibility(8);
    paramagok.b.setOnClickListener(null);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, MessageForShortVideo paramMessageForShortVideo, View paramView, SessionInfo paramSessionInfo, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, MessageForReplyText paramMessageForReplyText)
  {
    bcef.b(paramQQAppInterface, "dc00898", "", "", "0X8007429", "0X8007429", 0, 0, "", "", "", "");
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoRealItemBuilder", 2, "enterRichMediaPreview");
    }
    if (MediaPlayerManager.a(paramQQAppInterface).a()) {
      MediaPlayerManager.a(paramQQAppInterface).a(true);
    }
    paramView = aagn.a(paramView);
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("KEY_THUMBNAL_BOUND", paramView);
    if ((((paramContext instanceof ChatActivity)) || ((paramContext instanceof SplashActivity))) && (!(paramContext instanceof MultiForwardActivity)) && (!paramSessionInfo.isUpComingPrevious)) {
      localBundle.putInt("extra.AIO_CURRENT_PANEL_STATE", ((FragmentActivity)paramContext).getChatFragment().a().getCurrentPanel());
    }
    if (paramSessionInfo.curType == 1)
    {
      localBundle.putBoolean("extra.CAN_FORWARD_TO_GROUP_ALBUM", true);
      localBundle.putString("extra.GROUP_UIN", paramSessionInfo.curFriendUin);
      localBundle.putString("extra.GROUP_CODE", paramSessionInfo.troopUin);
    }
    if ((paramSessionInfo.curType == 1) || (paramSessionInfo.curType == 3000))
    {
      localBundle.putInt("extra.EXTRA_FORWARD_TO_QZONE_SRC", 2);
      if (paramMessageForReplyText == null) {
        break label575;
      }
      localBundle.putBoolean("extra.IS_FROM_MULTI_MSG", paramMessageForReplyText.isMultiMsg);
      label230:
      localBundle.putLong("click_video_bubble_time", System.currentTimeMillis());
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
        break label684;
      }
    }
    label684:
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
        label575:
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
        bkkh.a(paramContext, localBundle, new AIOImageProviderService(paramView, paramMessageForShortVideo.frienduin, paramMessageForShortVideo.istroop, paramMessageForShortVideo), agzl.a(paramMessageForShortVideo), -1, j);
        continue;
      }
      localBundle.putInt("forward_source_uin_type", paramSessionInfo.curType);
      localBundle.putString("uin", paramSessionInfo.curFriendUin);
      k = -1;
      if ((paramContext instanceof SplashActivity))
      {
        j = 1;
        localBundle.putBoolean("muate_play", paramBoolean1);
        localBundle.putBoolean("is_one_item", paramBoolean2);
        localBundle.putBoolean("is_ReplyMsg_From_Same_Session", paramBoolean3);
        localBundle.putBoolean(bkkh.b, paramBoolean4);
        if ((paramMessageForShortVideo.istroop != 0) || (!bftf.b(paramMessageForShortVideo.senderuin)) || (TextUtils.isEmpty(paramMessageForShortVideo.getExtInfoFromExtStr("guide_video_type")))) {
          continue;
        }
        localBundle.putString("babyq_video_type", paramMessageForShortVideo.getExtInfoFromExtStr("guide_video_type"));
        localBundle.putBoolean("extra.ENTER_NEW_GALLERY", true);
        bkkh.a(paramContext, localBundle, new AIOImageProviderService(paramView, paramMessageForShortVideo.frienduin, paramMessageForShortVideo.istroop, paramMessageForShortVideo), agzl.a(paramMessageForShortVideo), 13007, j);
        if (!paramMessageForShortVideo.isSend()) {
          new badr(BaseApplication.getContext()).a(paramQQAppInterface, 2001, paramSessionInfo.curType, paramSessionInfo.curFriendUin, 1001);
        }
        ShortVideoUtils.reportVideoPlay(paramQQAppInterface, "0X8008E53", paramSessionInfo, paramMessageForShortVideo, paramContext);
        return;
        localBundle.putInt("extra.EXTRA_FORWARD_TO_QZONE_SRC", 1);
        break;
        localBundle.putBoolean("extra.IS_FROM_MULTI_MSG", paramMessageForShortVideo.isMultiMsg);
        break label230;
      }
    }
  }
  
  private void a(MessageForShortVideo paramMessageForShortVideo, agok paramagok, String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    if (!paramMessageForShortVideo.isSend()) {
      new badr(BaseApplication.getContext()).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 2001, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin, 1002);
    }
    a(paramMessageForShortVideo, amtj.a(2131713155) + paramString2);
    a(paramagok.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView, paramString2, paramString1, paramMessageForShortVideo, paramInt1, paramInt2);
    if ((yns.a(paramagok.jdField_a_of_type_ComTencentMobileqqDataChatMessage.istroop, paramagok.jdField_a_of_type_ComTencentMobileqqDataChatMessage)) && (!bfth.a().a(paramagok.jdField_a_of_type_ComTencentMobileqqDataChatMessage, "aio_msg|play_msg_video")))
    {
      bfth.a().a(paramagok.jdField_a_of_type_ComTencentMobileqqDataChatMessage, "aio_msg|play_msg_video");
      xwa.a("aio_msg", "play_msg_video", 0, 0, new String[] { "", "", "", yns.a((MessageForShortVideo)paramagok.jdField_a_of_type_ComTencentMobileqqDataChatMessage) });
    }
    if (!FileUtils.fileExistsAndNotEmpty(paramString1))
    {
      b(paramMessageForShortVideo);
      a(paramMessageForShortVideo, "getBubbleView: Video file exist and status finish. Thumb not exist.");
    }
  }
  
  private void a(MessageForShortVideo paramMessageForShortVideo, agok paramagok, boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject = a(paramMessageForShortVideo);
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      jdField_h_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo = paramMessageForShortVideo;
      EncodeVideoTask.ThumbInfo localThumbInfo = new EncodeVideoTask.ThumbInfo(paramMessageForShortVideo.mThumbFilePath, paramMessageForShortVideo.thumbMD5, null, paramMessageForShortVideo.thumbWidth, paramMessageForShortVideo.thumbHeight);
      localObject = new EncodeVideoTask(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, (String)localObject, paramMessageForShortVideo.mediacodecEncode, localThumbInfo, paramMessageForShortVideo);
      EncodeVideoTask.mEncodeList.put(Long.valueOf(paramMessageForShortVideo.uniseq), localObject);
      ((EncodeVideoTask)localObject).setResultListener(this.jdField_a_of_type_ComTencentMobileqqActivityShortvideoEncodeVideoTask$ResultListener);
      ((EncodeVideoTask)localObject).setmEnableClearCache(false);
      Utils.executeAsyncTaskOnSerialExcuter((AsyncTask)localObject, new Void[] { (Void)null });
      ThreadManager.getUIHandler().post(new ShortVideoRealItemBuilder.12(this, paramBoolean1, paramagok, paramMessageForShortVideo, paramBoolean2));
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
  
  private void a(boolean paramBoolean, CropBubbleVideoView paramCropBubbleVideoView, MessageForShortVideo paramMessageForShortVideo, agok paramagok, String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    a(paramagok, paramString1, paramMessageForShortVideo, paramInt1, paramInt2);
    if ((FileUtils.fileExistsAndNotEmpty(paramString2)) || ((paramMessageForShortVideo.isSend()) && (paramMessageForShortVideo.md5 == null) && (paramMessageForShortVideo.videoFileStatus == 1004)))
    {
      paramInt1 = 0;
      if ((paramMessageForShortVideo.videoFileStatus == 1005) || (paramMessageForShortVideo.extraflag == 32768) || (paramMessageForShortVideo.videoFileStatus == 1004)) {
        paramInt1 = 1;
      }
      paramCropBubbleVideoView = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getTransFileController().findProcessor(paramMessageForShortVideo.frienduin, paramMessageForShortVideo.uniseq);
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
        b(paramMessageForShortVideo, paramagok, 2131717744);
      }
      do
      {
        return;
        if ((!ShortVideoUtils.isVideoSoLibLoaded()) || (!paramBoolean))
        {
          c(paramMessageForShortVideo, paramagok);
          return;
        }
      } while (paramMessageForShortVideo.videoFileStatus == 1003);
      if (ShortVideoUtils.getDisplayProgress(paramMessageForShortVideo.videoFileProgress, 10) <= 60) {}
      for (paramInt1 = 1; (paramMessageForShortVideo.busiType == 1) && (paramInt1 != 0); paramInt1 = 0)
      {
        if (paramMessageForShortVideo.progress > 60) {
          paramMessageForShortVideo.progress = 60;
        }
        a(paramMessageForShortVideo, paramagok, paramMessageForShortVideo.videoFileProgress, paramMessageForShortVideo.progress);
        return;
      }
      a(paramMessageForShortVideo, paramagok, paramMessageForShortVideo.videoFileProgress, false);
      return;
    }
    if (paramMessageForShortVideo.videoFileStatus == 2005) {
      c(paramMessageForShortVideo, paramagok);
    }
    if (paramMessageForShortVideo.videoFileStatus == 5002)
    {
      a(paramMessageForShortVideo, amtj.a(2131713146));
      b(paramMessageForShortVideo, paramagok, 2131717739);
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getShortVideoPredownloer().a(paramMessageForShortVideo, true))
    {
      a(paramMessageForShortVideo, true);
      return;
    }
    if ((paramMessageForShortVideo.videoFileStatus == 2001) || (paramMessageForShortVideo.videoFileStatus == 2002) || (paramMessageForShortVideo.videoFileStatus == 2000))
    {
      a(paramMessageForShortVideo, paramagok, paramMessageForShortVideo.videoFileProgress, false);
      return;
    }
    c(paramMessageForShortVideo, paramagok);
  }
  
  private boolean a(agok paramagok)
  {
    boolean bool2 = true;
    if ((paramagok.jdField_a_of_type_ComTencentMobileqqDataChatMessage instanceof MessageForShortVideo)) {}
    for (MessageForShortVideo localMessageForShortVideo = (MessageForShortVideo)paramagok.jdField_a_of_type_ComTencentMobileqqDataChatMessage;; localMessageForShortVideo = null)
    {
      if (localMessageForShortVideo == null) {
        return false;
      }
      int j;
      int k;
      if ((localMessageForShortVideo.videoFileStatus == 998) || (localMessageForShortVideo.videoFileStatus == 1002) || (localMessageForShortVideo.videoFileStatus == 1001))
      {
        j = 1;
        if ((localMessageForShortVideo.isMultiMsg) || (localMessageForShortVideo.uiOperatorFlag == 2) || (localMessageForShortVideo.busiType != 1) || (!localMessageForShortVideo.isSendFromLocal()) || (paramagok.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.a())) {
          break label204;
        }
        k = 1;
        label110:
        if (QLog.isColorLevel())
        {
          paramagok = new StringBuilder().append("shortVideoCancel needShowPauseIcon seq:").append(localMessageForShortVideo.uniseq).append(", videostatus:").append(localMessageForShortVideo.videoFileStatus).append(", iconshow:");
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
  
  private boolean a(agok paramagok, MessageForShortVideo paramMessageForShortVideo, int paramInt1, int paramInt2, CropBubbleVideoView paramCropBubbleVideoView)
  {
    if ((TextUtils.isEmpty(paramMessageForShortVideo.md5)) && (paramMessageForShortVideo.videoFileStatus != 1005) && (paramMessageForShortVideo.extraflag != 32768) && (paramMessageForShortVideo.videoFileStatus != 1004))
    {
      String str1;
      if (paramMessageForShortVideo.isSendFromLocal())
      {
        String str2 = paramMessageForShortVideo.mThumbFilePath;
        str1 = str2;
        if (FileUtils.fileExistsAndNotEmpty(str2)) {
          break label119;
        }
        if (!TextUtils.isEmpty(paramMessageForShortVideo.thumbMD5)) {
          break label107;
        }
        paramCropBubbleVideoView.setID(paramMessageForShortVideo.uniseq);
        paramCropBubbleVideoView.showCover(URLDrawableHelper.getFailedDrawable());
        a(paramagok);
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
            str1 = ShortVideoUtils.getShortVideoThumbPicPath(paramMessageForShortVideo.thumbMD5, "jpg");
            if (a(paramCropBubbleVideoView, str1))
            {
              a(paramagok, str1, paramMessageForShortVideo, paramInt1, paramInt2);
              b(paramagok, paramMessageForShortVideo);
              if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo == null) || ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.uniseq != paramMessageForShortVideo.uniseq) && (!jdField_a_of_type_JavaUtilMap.containsKey(Long.valueOf(paramMessageForShortVideo.uniseq))))) {}
              for (paramInt1 = 1; (!paramMessageForShortVideo.mPreUpload) && (TextUtils.isEmpty(paramMessageForShortVideo.md5)) && (paramInt1 != 0) && (paramMessageForShortVideo.busiType == 1); paramInt1 = 0)
              {
                if (jdField_h_of_type_Boolean) {
                  break label239;
                }
                a(paramMessageForShortVideo, null, false, true);
                return true;
              }
            }
          }
        } while (jdField_a_of_type_JavaUtilMap.containsKey(Long.valueOf(paramMessageForShortVideo.uniseq)));
        jdField_a_of_type_JavaUtilMap.put(Long.valueOf(paramMessageForShortVideo.uniseq), paramMessageForShortVideo);
      } while (!QLog.isColorLevel());
      label239:
      QLog.i("ShortVideoRealItemBuilder", 2, "messageMap size:" + jdField_a_of_type_JavaUtilMap.size() + ", [" + paramMessageForShortVideo.uniseq + "] added, mEncoding:" + jdField_h_of_type_Boolean);
      return true;
    }
    return false;
  }
  
  private boolean a(MessageForShortVideo paramMessageForShortVideo)
  {
    awdi localawdi = (awdi)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(324);
    if (localawdi != null)
    {
      paramMessageForShortVideo = localawdi.a(localawdi.a(paramMessageForShortVideo));
      if ((paramMessageForShortVideo != null) && (QLog.isColorLevel())) {
        QLog.d("ShortVideoRealItemBuilder", 2, "isVideoInMultiSaving = true");
      }
      return paramMessageForShortVideo != null;
    }
    return false;
  }
  
  private void b(agok paramagok, MessageForShortVideo paramMessageForShortVideo)
  {
    paramagok = new WeakReference(paramagok);
    if (paramMessageForShortVideo.busiType == 1)
    {
      if (paramMessageForShortVideo.progressTask == null)
      {
        paramMessageForShortVideo.progressTask = new ShortVideoRealItemBuilder.1(this, paramMessageForShortVideo, paramagok);
        this.jdField_b_of_type_AndroidOsHandler.removeCallbacks(paramMessageForShortVideo.progressTask);
        this.jdField_b_of_type_AndroidOsHandler.post(paramMessageForShortVideo.progressTask);
      }
      return;
    }
    if (paramMessageForShortVideo.mShowProgressTask == null) {
      paramMessageForShortVideo.mShowProgressTask = new ShortVideoRealItemBuilder.2(this, paramagok, paramMessageForShortVideo);
    }
    this.jdField_b_of_type_AndroidOsHandler.removeCallbacks(paramMessageForShortVideo.mShowProgressTask);
    this.jdField_b_of_type_AndroidOsHandler.post(paramMessageForShortVideo.mShowProgressTask);
  }
  
  private void b(agok paramagok, boolean paramBoolean, View.OnClickListener paramOnClickListener)
  {
    if ((paramagok != null) && (paramagok.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout != null))
    {
      if (paramBoolean) {
        a(paramagok, false, null);
      }
      paramagok.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(paramBoolean, paramOnClickListener);
    }
  }
  
  private boolean b(MessageForShortVideo paramMessageForShortVideo)
  {
    return bcgr.a().a(this.jdField_a_of_type_AndroidContentContext, 2, paramMessageForShortVideo.istroop);
  }
  
  private void d(MessageForShortVideo paramMessageForShortVideo)
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
            ((BaseChatPie)localObject).instantUpdate(false, false);
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
  
  public aeze a(View paramView)
  {
    return null;
  }
  
  public aezf a()
  {
    return new agok(this);
  }
  
  public agok a(long paramLong)
  {
    if ((this.jdField_a_of_type_ComTencentWidgetListView != null) && (paramLong > 0L))
    {
      int j = AIOUtils.findMessagePosition(paramLong, this.jdField_a_of_type_ComTencentWidgetListView.getAdapter());
      int k = this.jdField_a_of_type_ComTencentWidgetListView.getHeaderViewsCount();
      int m = this.jdField_a_of_type_ComTencentWidgetListView.getFirstVisiblePosition();
      int n = this.jdField_a_of_type_ComTencentWidgetListView.getLastVisiblePosition();
      if (j <= -1) {
        break label223;
      }
      Object localObject = AIOUtils.getViewByPostion(this.jdField_a_of_type_ComTencentWidgetListView, j);
      if (localObject != null)
      {
        localObject = AIOUtils.getHolder((View)localObject);
        if ((localObject != null) && ((localObject instanceof agok))) {
          return (agok)localObject;
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
  
  public View a(int paramInt1, int paramInt2, ChatMessage paramChatMessage, View paramView, ViewGroup paramViewGroup, afce paramafce)
  {
    paramView = super.a(paramInt1, paramInt2, paramChatMessage, paramView, paramViewGroup, paramafce);
    a(paramChatMessage, paramView, this);
    a((agok)paramView.getTag(), paramView);
    return paramView;
  }
  
  public View a(ChatMessage paramChatMessage, aezf paramaezf, View paramView, BaseChatItemLayout paramBaseChatItemLayout, afce paramafce)
  {
    agok localagok = (agok)paramaezf;
    Context localContext = this.jdField_a_of_type_AndroidContentContext;
    Resources localResources = localContext.getResources();
    MessageForShortVideo localMessageForShortVideo = (MessageForShortVideo)paramChatMessage;
    paramaezf = ShortVideoUtils.adjustSize(localMessageForShortVideo.thumbWidth, localMessageForShortVideo.thumbHeight);
    int j = paramaezf[0];
    int k = paramaezf[1];
    boolean bool = localMessageForShortVideo.isSend();
    paramaezf = paramView;
    if (paramView == null)
    {
      paramaezf = new RelativeLayout(localContext);
      paramView = (CropBubbleVideoView)azjm.a(this.jdField_a_of_type_AndroidContentContext, localMessageForShortVideo.uniseq, null, bool);
      paramView.setId(2131362350);
      paramView.setVisibility(0);
      paramView.setContentDescription(amtj.a(2131713179));
      paramaezf.addView(paramView);
      MessageProgressView localMessageProgressView = new MessageProgressView(localContext);
      paramaezf.addView(localMessageProgressView);
      ImageView localImageView = new ImageView(localContext);
      localImageView.setImageResource(2130838075);
      localImageView.setVisibility(8);
      Object localObject1 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject1).addRule(7, 2131362350);
      ((RelativeLayout.LayoutParams)localObject1).addRule(8, 2131362350);
      ((RelativeLayout.LayoutParams)localObject1).bottomMargin = AIOUtils.dp2px(10.0F, localResources);
      ((RelativeLayout.LayoutParams)localObject1).rightMargin = AIOUtils.dp2px(10.0F, localResources);
      paramaezf.addView(localImageView, (ViewGroup.LayoutParams)localObject1);
      jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet.add(paramView);
      localObject1 = new LinearLayout(localContext);
      ((LinearLayout)localObject1).setOrientation(1);
      ((LinearLayout)localObject1).setGravity(17);
      Object localObject2 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject2).addRule(13);
      paramaezf.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
      localObject2 = new TextView(localContext);
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
      localLayoutParams.topMargin = AIOUtils.dp2px(70.0F, localResources);
      ((TextView)localObject2).setTextColor(-1);
      ((TextView)localObject2).setTextSize(2, 12.0F);
      ((TextView)localObject2).setId(2131364483);
      ((LinearLayout)localObject1).addView((View)localObject2, localLayoutParams);
      paramaezf.setOnClickListener(this);
      super.a(paramaezf, paramafce);
      localagok.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView = paramView;
      localagok.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView = localMessageProgressView;
      localagok.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localObject2);
      localagok.jdField_a_of_type_AndroidWidgetImageView = localImageView;
    }
    paramView = localagok.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView;
    if (jdField_e_of_type_Boolean) {
      paramView.setContentDescription(amtj.a(2131713141));
    }
    localagok.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setMiniAioShieldItemTouchListener(this);
    paramView.mIsSend = localMessageForShortVideo.isSend();
    paramView.setTag(Long.valueOf(localMessageForShortVideo.uniseq));
    bfth.a().a(Long.valueOf(localMessageForShortVideo.uniseq), localMessageForShortVideo);
    localagok.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    a(localagok, localMessageForShortVideo);
    paramafce = localagok.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView.getLayoutParams();
    if (paramafce == null)
    {
      paramafce = new RelativeLayout.LayoutParams(j, k);
      localagok.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView.setLayoutParams(paramafce);
      paramafce = localagok.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.getLayoutParams();
      if (paramafce != null) {
        break label705;
      }
      paramafce = new RelativeLayout.LayoutParams(j, k);
      localagok.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setLayoutParams(paramafce);
    }
    for (;;)
    {
      if (paramBaseChatItemLayout != null)
      {
        a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseChatItemLayout, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramChatMessage, this);
        if ((!(this.jdField_a_of_type_AndroidContentContext instanceof MultiForwardActivity)) && (!this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.isUpComingPrevious))
        {
          a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseChatItemLayout, localagok, paramChatMessage);
          bbwb.a(paramaezf, localagok, paramChatMessage, localContext);
        }
      }
      a(localMessageForShortVideo);
      a(localMessageForShortVideo, localagok, localResources, bool);
      if (!a(localagok, localMessageForShortVideo, j, k, paramView)) {
        break label752;
      }
      return paramaezf;
      if ((paramafce.width == j) && (paramafce.height == k)) {
        break;
      }
      paramafce.width = j;
      paramafce.height = k;
      localagok.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView.setLayoutParams(paramafce);
      break;
      label705:
      if ((paramafce.width != j) || (paramafce.height != k))
      {
        paramafce.width = j;
        paramafce.height = k;
        localagok.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setLayoutParams(paramafce);
      }
    }
    label752:
    paramChatMessage = ShortVideoUtils.getShortVideoThumbPicPath(localMessageForShortVideo.thumbMD5, "jpg");
    paramBaseChatItemLayout = ShortVideoUtils.getShortVideoSavePath(localMessageForShortVideo, "mp4");
    bool = b(localMessageForShortVideo);
    if ((bool) && (FileUtils.fileExistsAndNotEmpty(paramBaseChatItemLayout)) && ((!localMessageForShortVideo.isSendFromLocal()) || (localMessageForShortVideo.videoFileStatus == 1003) || (localMessageForShortVideo.videoFileStatus == 2003) || (localMessageForShortVideo.isMultiMsg == true)))
    {
      a(localMessageForShortVideo, localagok, paramChatMessage, paramBaseChatItemLayout, j, k);
      return paramaezf;
    }
    if (FileUtils.fileExistsAndNotEmpty(paramChatMessage))
    {
      a(bool, paramView, localMessageForShortVideo, localagok, paramChatMessage, paramBaseChatItemLayout, j, k);
      return paramaezf;
    }
    if (localMessageForShortVideo.videoFileStatus == 5002)
    {
      a(localMessageForShortVideo, amtj.a(2131713172));
      paramView.setID(localMessageForShortVideo.uniseq);
      paramView.showCover(jdField_a_of_type_AndroidGraphicsDrawableColorDrawable);
      b(localMessageForShortVideo, localagok, 2131717739);
      return paramaezf;
    }
    a(localMessageForShortVideo, amtj.a(2131713193));
    paramView.setID(localMessageForShortVideo.uniseq);
    paramView.showCover(jdField_a_of_type_AndroidGraphicsDrawableColorDrawable);
    b(localMessageForShortVideo);
    return paramaezf;
  }
  
  public bgaz a(bgaz parambgaz, ChatMessage paramChatMessage, aezy paramaezy)
  {
    int m = 0;
    paramChatMessage = (MessageForShortVideo)paramChatMessage;
    paramaezy = (agok)paramaezy;
    b(parambgaz, this.jdField_a_of_type_AndroidContentContext);
    int k = m;
    if (!TextUtils.isEmpty(paramChatMessage.md5)) {
      if (paramChatMessage.mPreUpload)
      {
        k = m;
        if (TextUtils.isEmpty(paramChatMessage.mLocalMd5)) {}
      }
      else
      {
        String str = ShortVideoUtils.getShortVideoThumbPicPath(paramChatMessage.thumbMD5, "jpg");
        paramChatMessage = ShortVideoUtils.getShortVideoSavePath(paramChatMessage, "mp4");
        k = m;
        if (FileUtils.fileExistsAndNotEmpty(str)) {
          if ((paramaezy.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.c == null) || (paramaezy.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.c.getVisibility() != 0)) {
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
        parambgaz.a(2131367094, this.jdField_a_of_type_AndroidContentContext.getString(2131692448), 2130838971);
        k = m;
        if (FileUtils.fileExistsAndNotEmpty(paramChatMessage)) {
          k = 1;
        }
      }
      if (k != 0) {
        parambgaz.a(2131366347, this.jdField_a_of_type_AndroidContentContext.getString(2131692036), 2130838970);
      }
      return parambgaz;
    }
  }
  
  public String a(ChatMessage paramChatMessage)
  {
    return amtj.a(2131713194);
  }
  
  public String a(MessageForShortVideo paramMessageForShortVideo)
  {
    paramMessageForShortVideo = paramMessageForShortVideo.mVideoFileSourceDir + File.separator + "configure.txt";
    if (!FileUtils.fileExistsAndNotEmpty(paramMessageForShortVideo))
    {
      if (QLog.isColorLevel()) {
        QLog.i("ShortVideoRealItemBuilder", 2, "configure file empty!");
      }
      return null;
    }
    try
    {
      paramMessageForShortVideo = FileUtils.readFileToString(new File(paramMessageForShortVideo));
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
            MessageForShortVideo localMessageForShortVideo = bfth.a().a(Integer.valueOf(((CropBubbleVideoView)localObject2).getId()));
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
      if (paramInt != 2131365382) {
        break label77;
      }
      acvv.b(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localMessageForShortVideo);
      xwa.a("story_grp", "press_msg", 0, 0, new String[] { "4", "", "", "" });
    }
    label77:
    do
    {
      do
      {
        return;
        if (paramInt == 2131371498)
        {
          super.d(paramChatMessage);
          xwa.a("story_grp", "press_msg", 0, 0, new String[] { "5", "", "", "" });
          return;
        }
        if (paramInt == 2131367094)
        {
          paramInt = aydq.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage.istroop, paramChatMessage.frienduin);
          if (paramInt == 3) {
            paramContext = "1";
          }
          for (;;)
          {
            bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005624", "0X8005624", 0, 0, paramContext, "", "", "");
            xwa.a("story_grp", "press_msg", 0, 0, new String[] { "1", "", "", "" });
            c(localMessageForShortVideo);
            if (!paramChatMessage.isMultiMsg) {
              break;
            }
            bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009D66", "0X8009D66", 5, 0, "5", "", "", "");
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
        if (paramInt != 2131366347) {
          break;
        }
        bkov.a(localMessageForShortVideo).b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage).a((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
        bkpf.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 3, 0, paramChatMessage.istroop);
        bkpf.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 6, 5);
        xwa.a("story_grp", "press_msg", 0, 0, new String[] { "2", "", "", "" });
      } while (!paramChatMessage.isMultiMsg);
      bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009D67", "0X8009D67", 5, 0, "5", "", "", "");
      return;
      if (paramInt == 2131371455)
      {
        super.a(localMessageForShortVideo);
        xwa.a("story_grp", "press_msg", 0, 0, new String[] { "3", "", "", "" });
        return;
      }
      if (paramInt == 2131365342)
      {
        paramContext = new StringBuilder();
        paramContext.append("uniseq:").append(localMessageForShortVideo.uniseq).append("\n");
        Toast.makeText(this.jdField_a_of_type_AndroidContentContext, paramContext.toString(), 1).show();
        return;
      }
      if (paramInt != 2131371562) {
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
    bcef.b(null, "dc00898", "", "", "0X8009F65", "0X8009F65", 1, 0, "", "", "", "");
    return;
    label664:
    super.a(paramInt, paramContext, paramChatMessage);
  }
  
  public void a(agok paramagok)
  {
    if (!paramagok.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.a(paramagok.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin + paramagok.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq)) {
      paramagok.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setVisibility(8);
    }
    for (;;)
    {
      paramagok.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      if (QLog.isColorLevel()) {
        QLog.w("ShortVideoRealItemBuilder", 2, "[hideProgress] set mProgressView gone");
      }
      return;
      paramagok.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setAnimRunnableListener(new agoh(this, paramagok));
    }
  }
  
  protected void a(agok paramagok, MessageForShortVideo paramMessageForShortVideo)
  {
    paramagok.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setRadius(15.0F, true);
    paramagok.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setShowCorner(true);
    paramagok.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setSharpCornerCor(BubbleImageView.a);
    paramagok.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setCornerDirection(paramMessageForShortVideo.isSend());
    paramagok.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.a(paramMessageForShortVideo.frienduin + paramMessageForShortVideo.uniseq);
    if ((paramMessageForShortVideo.fileType == 6) || (paramMessageForShortVideo.fileType == 17) || (paramMessageForShortVideo.fileType == 9) || (paramMessageForShortVideo.fileType == 20))
    {
      if ((paramMessageForShortVideo.videoFileStatus == 1003) || (paramMessageForShortVideo.videoFileStatus == 2003)) {
        b(paramagok);
      }
    }
    else {
      return;
    }
    paramagok.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setVisibility(0);
  }
  
  public void a(agok paramagok, String paramString, MessageForShortVideo paramMessageForShortVideo, int paramInt1, int paramInt2)
  {
    if ((FileUtils.fileExistsAndNotEmpty(paramString)) && (a(paramagok.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView, paramString)))
    {
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mRequestWidth = paramInt1;
      localURLDrawableOptions.mRequestHeight = paramInt2;
      localURLDrawableOptions.mLoadingDrawable = jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
      localURLDrawableOptions.mFailedDrawable = jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
      paramString = URLDrawable.getDrawable(new File(paramString), localURLDrawableOptions);
      paramagok.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView.setID(paramMessageForShortVideo.uniseq);
      paramagok.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView.showCover(paramString);
    }
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    paramView = (agok)AIOUtils.getHolder(paramView);
    MessageForShortVideo localMessageForShortVideo = (MessageForShortVideo)paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
    if (!localMessageForShortVideo.isSendFromLocal()) {}
    do
    {
      return;
      bjnw localbjnw = (bjnw)bjon.a(this.jdField_a_of_type_AndroidContentContext, null);
      localbjnw.a(2131689947, 5);
      localbjnw.c(2131690620);
      localbjnw.a(new agog(this, localMessageForShortVideo, paramView, localbjnw));
      localbjnw.show();
    } while (localMessageForShortVideo.videoFileStatus != 1004);
    ShortVideoUtils.reportCancelSendVideo("0X800A7EF", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType);
  }
  
  public void a(View paramView, ChatMessage paramChatMessage)
  {
    int j = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131296391);
    if (paramChatMessage.isSend())
    {
      paramView.setPadding(BaseChatItemLayout.k, BaseChatItemLayout.jdField_h_of_type_Int, j, BaseChatItemLayout.i);
      return;
    }
    paramView.setPadding(j, BaseChatItemLayout.jdField_h_of_type_Int, BaseChatItemLayout.k, BaseChatItemLayout.i);
  }
  
  public void a(View paramView, FileMsg paramFileMsg, int paramInt1, int paramInt2)
  {
    paramView = AIOUtils.getHolder(paramView);
    if (!(paramView instanceof agok)) {}
    MessageForShortVideo localMessageForShortVideo;
    int j;
    int k;
    label188:
    label195:
    do
    {
      do
      {
        do
        {
          return;
          paramView = (agok)paramView;
          localMessageForShortVideo = (MessageForShortVideo)paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
        } while (localMessageForShortVideo.uniseq != paramFileMsg.uniseq);
        this.jdField_b_of_type_AndroidOsHandler.removeCallbacks(localMessageForShortVideo.mShowProgressTask);
        if (localMessageForShortVideo.mShowProgressTask != null) {
          localMessageForShortVideo.mShowProgressTask = null;
        }
      } while (this.jdField_a_of_type_AndroidContentContext == null);
      Resources localResources = this.jdField_a_of_type_AndroidContentContext.getResources();
      if (localMessageForShortVideo.thumbWidth > 0)
      {
        paramInt1 = localMessageForShortVideo.thumbWidth;
        if (localMessageForShortVideo.thumbHeight <= 0) {
          break label188;
        }
      }
      for (paramInt2 = localMessageForShortVideo.thumbHeight;; paramInt2 = 100)
      {
        j = AIOUtils.dp2px(paramInt1, localResources);
        k = AIOUtils.dp2px(paramInt2, localResources);
        if ((paramFileMsg.fileType != 6) && (paramFileMsg.fileType != 17) && (paramFileMsg.fileType != 9) && (paramFileMsg.fileType != 20)) {
          break label195;
        }
        a(paramFileMsg, paramView, localMessageForShortVideo, paramInt1, paramInt2, j, k);
        return;
        paramInt1 = 100;
        break;
      }
    } while ((paramFileMsg.fileType != 7) && (paramFileMsg.fileType != 18) && (paramFileMsg.fileType != 16));
    b(paramFileMsg, paramView, localMessageForShortVideo, paramInt1, paramInt2, j, k);
  }
  
  public void a(QQAppInterface paramQQAppInterface, BaseChatItemLayout paramBaseChatItemLayout, agok paramagok, MessageRecord paramMessageRecord)
  {
    boolean bool2 = false;
    if ((paramMessageRecord instanceof MessageForShortVideo))
    {
      paramMessageRecord = (MessageForShortVideo)paramMessageRecord;
      if (paramMessageRecord.redBagType != LocalMediaInfo.REDBAG_TYPE_GET) {
        break label108;
      }
      if (paramagok.jdField_e_of_type_Int != LocalMediaInfo.REDBAG_TYPE_GET) {
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
        paramagok.jdField_e_of_type_Int = LocalMediaInfo.REDBAG_TYPE_GET;
        paramQQAppInterface = new agod(this, paramQQAppInterface);
        paramagok = new SpannableString(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131718453));
        paramagok.setSpan(new ForegroundColorSpan(-1), 0, paramagok.length(), 17);
        paramBaseChatItemLayout.setTailMessage(true, paramagok, paramQQAppInterface, bbwb.a());
        return;
        if ((!paramMessageRecord.CheckIsDanceVideo()) || (!bbta.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType))) {
          break;
        }
      } while (paramagok.jdField_e_of_type_Int == 2);
      paramagok.jdField_e_of_type_Int = 2;
      boolean bool3 = babd.a();
      boolean bool4 = bbxo.g(paramQQAppInterface);
      paramQQAppInterface = new agoe(this, bool3, bool4, paramQQAppInterface);
      paramagok = new SpannableString(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131718443));
      paramagok.setSpan(new ForegroundColorSpan(-1), 0, paramagok.length(), 17);
      boolean bool1 = bool2;
      if (bool3)
      {
        bool1 = bool2;
        if (bool4) {
          bool1 = true;
        }
      }
      paramBaseChatItemLayout.setTailMessage(true, paramagok, paramQQAppInterface, bool1);
      return;
    } while (paramagok.jdField_e_of_type_Int == 0);
    paramagok.jdField_e_of_type_Int = 0;
    paramBaseChatItemLayout.setTailMessage(false, null, null);
  }
  
  protected void a(MessageForShortVideo paramMessageForShortVideo)
  {
    if (!bfth.a().a(paramMessageForShortVideo, "0X8007428"))
    {
      bfth.a().a(paramMessageForShortVideo, "0X8007428");
      bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8007428", "0X8007428", 0, 0, "", "", "", "");
    }
    if ((paramMessageForShortVideo.CheckIsHotVideo()) && (!bfth.a().a(paramMessageForShortVideo, "0X8007EDB")))
    {
      bfth.a().a(paramMessageForShortVideo, "0X8007EDB");
      bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8007EDB", "0X8007EDB", 0, 0, "", "", "", "");
    }
  }
  
  public void a(MessageForShortVideo paramMessageForShortVideo, long paramLong)
  {
    if ((paramMessageForShortVideo != null) && (!bfth.a().a(paramMessageForShortVideo, "0X8009AA6")))
    {
      bfth.a().a(paramMessageForShortVideo, "0X8009AA6");
      ShortVideoUtils.reportVideoPlayEvent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType, paramMessageForShortVideo.frienduin, 1, 2, paramMessageForShortVideo.videoFileTime * 1000, paramLong);
    }
  }
  
  public void a(MessageForShortVideo paramMessageForShortVideo, agok paramagok)
  {
    a(paramMessageForShortVideo, "startUploadVideo：" + paramMessageForShortVideo.toString());
    Object localObject = ShortVideoUtils.getShortVideoSavePath(paramMessageForShortVideo, "mp4");
    String str = ShortVideoUtils.getShortVideoThumbPicPath(paramMessageForShortVideo.thumbMD5, "jpg");
    if (!FileUtils.fileExistsAndNotEmpty((String)localObject))
    {
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, 1, 2131718481, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299076));
      paramagok.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
      paramMessageForShortVideo.videoFileStatus = 1005;
      return;
    }
    if (!FileUtils.fileExistsAndNotEmpty(str))
    {
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, 1, 2131718482, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299076));
      paramagok.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
      paramMessageForShortVideo.videoFileStatus = 1005;
      return;
    }
    ((bahm)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(326)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin, paramMessageForShortVideo, paramMessageForShortVideo.videoFileName);
    localObject = bbqf.a(1, 2);
    ((bbqx)localObject).a(bbqf.a(2, paramMessageForShortVideo, (bbqx)localObject));
    bbqf.a((bbqx)localObject, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    a(paramMessageForShortVideo, paramagok, paramMessageForShortVideo.videoFileProgress, true);
  }
  
  void a(MessageForShortVideo paramMessageForShortVideo, agok paramagok, int paramInt)
  {
    int j = ShortVideoUtils.getDisplayProgress(paramInt, 10);
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
    a(paramMessageForShortVideo, paramagok, paramInt, true);
  }
  
  protected void a(MessageForShortVideo paramMessageForShortVideo, agok paramagok, int paramInt1, int paramInt2)
  {
    if ((ShortVideoUtils.getDisplayProgress(paramMessageForShortVideo.videoFileProgress, 10) > 60) || (paramInt2 > 60)) {}
    do
    {
      return;
      paramInt2 = ShortVideoUtils.getDisplayProgress(paramInt2, 0);
      paramagok.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setDrawStatus(1);
      paramagok.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setAnimProgress(paramInt2, paramMessageForShortVideo.frienduin + paramMessageForShortVideo.uniseq);
      paramagok.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setVisibility(0);
      paramagok.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      if ((paramMessageForShortVideo.progressTask != null) && (NetworkUtil.isNetSupport(this.jdField_a_of_type_AndroidContentContext)))
      {
        paramMessageForShortVideo.progress += 3;
        this.jdField_b_of_type_AndroidOsHandler.postDelayed(paramMessageForShortVideo.progressTask, 1000L);
      }
    } while (!QLog.isColorLevel());
    QLog.w("ShortVideoRealItemBuilder", 2, "[setProgress] uinseq:" + paramMessageForShortVideo.uniseq + ", p:" + paramInt1 + ", progress:" + paramInt2);
  }
  
  public void a(MessageForShortVideo paramMessageForShortVideo, agok paramagok, int paramInt, boolean paramBoolean)
  {
    paramagok.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setDrawStatus(1);
    paramagok.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setAnimProgress(paramInt, paramMessageForShortVideo.frienduin + paramMessageForShortVideo.uniseq);
    paramagok.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setVisibility(0);
    paramagok.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    if (QLog.isColorLevel()) {
      QLog.w("ShortVideoRealItemBuilder", 2, "[setProgress] uinseq:" + paramMessageForShortVideo.uniseq + ", p:" + paramInt);
    }
  }
  
  protected void a(MessageForShortVideo paramMessageForShortVideo, agok paramagok, Resources paramResources, boolean paramBoolean)
  {
    int j = Math.max(paramMessageForShortVideo.thumbWidth, paramMessageForShortVideo.thumbHeight);
    int k = Math.min(paramMessageForShortVideo.thumbWidth, paramMessageForShortVideo.thumbHeight);
    if ((jdField_f_of_type_Boolean) && (j >= jdField_c_of_type_Int) && (k >= jdField_d_of_type_Int))
    {
      paramMessageForShortVideo = (RelativeLayout.LayoutParams)paramagok.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
      if (paramBoolean) {}
      for (paramMessageForShortVideo.rightMargin = AIOUtils.dp2px(paramagok.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView.getTriaWidth() + 8.0F, paramResources);; paramMessageForShortVideo.rightMargin = AIOUtils.dp2px(8.0F, paramResources))
      {
        paramagok.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        return;
      }
    }
    paramagok.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
  }
  
  void a(MessageForShortVideo paramMessageForShortVideo, boolean paramBoolean)
  {
    if (paramMessageForShortVideo.videoFileStatus == 5002)
    {
      a(paramMessageForShortVideo, amtj.a(2131713153));
      return;
    }
    bbqx localbbqx = bbqf.a(2, 2);
    bbqh localbbqh = paramMessageForShortVideo.getDownloadInfo(localbbqx.jdField_b_of_type_Int);
    localbbqh.h = ShortVideoUtils.getShortVideoSavePath(paramMessageForShortVideo, "mp4");
    localbbqh.a(paramMessageForShortVideo.istroop, 0);
    if (paramBoolean) {}
    for (int j = 2;; j = 1)
    {
      localbbqh.jdField_f_of_type_Int = j;
      localbbqh.jdField_g_of_type_Int = 2;
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoRealItemBuilder", 2, " startDownloadVideo downloadvideo fileType==" + localbbqh.jdField_e_of_type_Int + ", uniseq:" + paramMessageForShortVideo.uniseq);
      }
      localbbqx.a(localbbqh);
      localbbqx.a(paramMessageForShortVideo);
      bbqf.a(localbbqx, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      return;
    }
  }
  
  public void a(FileMsg paramFileMsg, agok paramagok, MessageForShortVideo paramMessageForShortVideo, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    switch (paramFileMsg.status)
    {
    default: 
    case 1007: 
    case 1001: 
    case 1003: 
    case 1005: 
    case 1004: 
    case 1002: 
    case 2001: 
    case 2003: 
    case 5001: 
    case 2005: 
      do
      {
        do
        {
          return;
          a(paramagok, false, null);
          EncodeVideoTask.mEncodeList.remove(Long.valueOf(paramMessageForShortVideo.uniseq));
          a(paramMessageForShortVideo, "VIDEO STATUS_UPLOAD_FINISHED progress " + paramMessageForShortVideo.videoFileProgress);
          return;
          a(paramMessageForShortVideo, "VIDEO STATUS_SEND_START progress " + paramMessageForShortVideo.videoFileProgress);
          if (paramMessageForShortVideo.busiType != 1) {
            a(paramMessageForShortVideo, paramagok, paramMessageForShortVideo.videoFileProgress, true);
          }
          paramagok.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(false, this);
          EncodeVideoTask.mEncodeList.remove(Long.valueOf(paramMessageForShortVideo.uniseq));
          return;
          a(paramMessageForShortVideo, "VIDEO STATUS_SEND_FINISHED");
          d(paramMessageForShortVideo);
          a(paramMessageForShortVideo.mVideoFileSourceDir);
          a(paramMessageForShortVideo, paramagok, 100, true);
          a(paramagok, false, null);
          EncodeVideoTask.mEncodeList.remove(Long.valueOf(paramMessageForShortVideo.uniseq));
          return;
          a(paramMessageForShortVideo, "VIDEO STATUS_SEND_ERROR");
          d(paramMessageForShortVideo);
          b(paramMessageForShortVideo, paramagok, 2131717744);
          paramagok.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
          EncodeVideoTask.mEncodeList.remove(Long.valueOf(paramMessageForShortVideo.uniseq));
          return;
          a(paramMessageForShortVideo, "VIDEO STATUS_SEND_CANCEL");
          paramagok.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.b(paramagok.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin + paramagok.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
          d(paramMessageForShortVideo);
          a(paramagok);
          b(paramMessageForShortVideo, paramagok, 2131717744);
          b(paramagok, true, this);
          EncodeVideoTask.mEncodeList.remove(Long.valueOf(paramMessageForShortVideo.uniseq));
          return;
          paramInt1 = paramMessageForShortVideo.videoFileProgress;
          a(paramMessageForShortVideo, "VIDEO STATUS_SEND_PROCESS " + paramInt1);
          a(paramMessageForShortVideo, paramagok, paramInt1);
          return;
          a(paramMessageForShortVideo, "VIDEO STATUS_RECV_START");
          a(paramMessageForShortVideo, paramagok, paramMessageForShortVideo.videoFileProgress, true);
          return;
          a(paramMessageForShortVideo, "VIDEO STATUS_RECV_FINISHED , getAIOState() = " + a());
          if ((!b(paramMessageForShortVideo)) || (a() != 4)) {
            break;
          }
          paramFileMsg = ShortVideoUtils.getShortVideoSavePath(paramMessageForShortVideo, "mp4");
          a(paramMessageForShortVideo, amtj.a(2131713176) + paramFileMsg);
          if ((ShortVideoUtils.isVideoSoLibLoaded()) && (FileUtils.fileExistsAndNotEmpty(paramFileMsg)))
          {
            a(paramMessageForShortVideo, amtj.a(2131713188) + paramFileMsg);
            String str = ShortVideoUtils.getShortVideoThumbPicPath(paramMessageForShortVideo.thumbMD5, "jpg");
            a(paramagok.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView, paramFileMsg, str, paramMessageForShortVideo, paramInt1, paramInt2);
            if (!paramMessageForShortVideo.isSend()) {
              new badr(BaseApplication.getContext()).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 2001, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin, 1002);
            }
          }
          a(paramMessageForShortVideo, paramagok, 100, true);
        } while (!paramMessageForShortVideo.isMultiMsg);
        a(paramagok);
        return;
        a(paramagok, ShortVideoUtils.getShortVideoThumbPicPath(paramMessageForShortVideo.thumbMD5, "jpg"), paramMessageForShortVideo, paramInt3, paramInt4);
        c(paramMessageForShortVideo, paramagok);
        return;
        a(paramMessageForShortVideo, "VIDEO STATUS_FILE_UNSAFE");
        b(paramMessageForShortVideo, paramagok, 2131717738);
        if (paramMessageForShortVideo.uiOperatorFlag == 2)
        {
          paramagok.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
          QQToast.a(this.jdField_a_of_type_AndroidContentContext, 2131718450, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299076));
          return;
        }
        QQToast.a(this.jdField_a_of_type_AndroidContentContext, 2131718474, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299076));
        return;
        a(paramMessageForShortVideo, "VIDEO STATUS_RECV_ERROR");
        a(paramagok);
        c(paramMessageForShortVideo, paramagok);
      } while (paramFileMsg.errorCode == -5100528);
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, 2131718476, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299076));
      return;
    case 5002: 
      a(paramMessageForShortVideo, "VIDEO STATUS_FILE_EXPIRED");
      a(paramagok, ShortVideoUtils.getShortVideoThumbPicPath(paramMessageForShortVideo.thumbMD5, "jpg"), paramMessageForShortVideo, paramInt3, paramInt4);
      b(paramMessageForShortVideo, paramagok, 2131717739);
      return;
    case 2004: 
      a(paramMessageForShortVideo, "VIDEO STATUS_RECV_CANCEL");
      return;
    }
    paramInt1 = paramMessageForShortVideo.videoFileProgress;
    a(paramMessageForShortVideo, "VIDEO STATUS_RECV_PROCESS " + paramInt1);
    a(paramMessageForShortVideo, paramagok, paramInt1, true);
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
      ((VideoPlayParam)localObject).mSceneName = azjn.a(100);
      ((VideoPlayParam)localObject).mIsMute = true;
      ((VideoPlayParam)localObject).mCallback = new agof(this);
      ((VideoPlayParam)localObject).mIsLocal = true;
      ((VideoPlayParam)localObject).mIsLoop = true;
      ((VideoPlayParam)localObject).mVideoPath = paramString1;
      ((VideoPlayParam)localObject).mFileSize = paramMessageForShortVideo.videoFileSize;
      paramCropBubbleVideoView.setVideoParam((VideoPlayParam)localObject);
      paramString1 = new aqww(-10065297, 100, 100);
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
      paramCropBubbleVideoView.setCoverDrawable(URLDrawable.getDrawable(ShortVideoUtils.getThumbUrl(paramString2).toString(), paramInt1, paramInt2, paramString1, paramString1));
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
      paramBaseChatItemLayout = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getTransFileController().findProcessor(paramChatMessage.frienduin, paramChatMessage.uniseq);
      if ((paramBaseChatItemLayout instanceof BaseTransProcessor))
      {
        if (((BaseTransProcessor)paramBaseChatItemLayout).getFileStatus() == 1005L) {}
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
  
  public bgbb[] a(View paramView)
  {
    bgaz localbgaz = new bgaz();
    paramView = (agok)AIOUtils.getHolder(paramView);
    MessageForShortVideo localMessageForShortVideo = (MessageForShortVideo)paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
    if (localMessageForShortVideo != null)
    {
      if (!localMessageForShortVideo.isMultiMsg) {
        break label48;
      }
      a(localbgaz, localMessageForShortVideo, paramView);
    }
    for (;;)
    {
      return localbgaz.a();
      label48:
      b(localbgaz, localMessageForShortVideo, paramView);
    }
  }
  
  public void a_(ChatMessage paramChatMessage)
  {
    bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A5A7", "0X800A5A7", 0, 0, "3", "", "", "");
  }
  
  public bgaz b(bgaz parambgaz, ChatMessage paramChatMessage, aezy paramaezy)
  {
    int n = 1;
    int k = 0;
    int j = 0;
    MessageForShortVideo localMessageForShortVideo = (MessageForShortVideo)paramChatMessage;
    paramaezy = (agok)paramaezy;
    b(parambgaz, this.jdField_a_of_type_AndroidContentContext);
    int m;
    label167:
    int i1;
    if ((!TextUtils.isEmpty(localMessageForShortVideo.md5)) && ((!localMessageForShortVideo.mPreUpload) || (!TextUtils.isEmpty(localMessageForShortVideo.mLocalMd5))))
    {
      String str1 = ShortVideoUtils.getShortVideoThumbPicPath(localMessageForShortVideo.thumbMD5, "jpg");
      String str2 = ShortVideoUtils.getShortVideoSavePath(localMessageForShortVideo, "mp4");
      if (FileUtils.fileExistsAndNotEmpty(str1)) {
        if ((paramaezy.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.c != null) && (paramaezy.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.c.getVisibility() == 0))
        {
          m = 1;
          if (m == 0)
          {
            parambgaz.a(2131367094, this.jdField_a_of_type_AndroidContentContext.getString(2131692448), 2130838971);
            a(localMessageForShortVideo, parambgaz);
            k = n;
            if (FileUtils.fileExistsAndNotEmpty(str2))
            {
              j = 1;
              k = n;
            }
            n = j;
            i1 = k;
            if (m == 0)
            {
              a(parambgaz, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType, localMessageForShortVideo);
              i1 = k;
            }
          }
        }
      }
    }
    for (n = j;; n = k)
    {
      a(parambgaz, localMessageForShortVideo);
      if (n != 0) {
        parambgaz.a(2131366347, this.jdField_a_of_type_AndroidContentContext.getString(2131692036), 2130838970);
      }
      super.a(parambgaz, this.jdField_a_of_type_AndroidContentContext, paramChatMessage);
      if (i1 != 0) {
        b(localMessageForShortVideo, parambgaz);
      }
      super.c(parambgaz, this.jdField_a_of_type_AndroidContentContext);
      super.e(parambgaz, this.jdField_a_of_type_AndroidContentContext);
      return parambgaz;
      k = 0;
      break label167;
      m = 0;
      break;
      i1 = 0;
    }
  }
  
  public void b(agok paramagok)
  {
    if (!paramagok.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.a(paramagok.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin + paramagok.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq)) {
      paramagok.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setVisibility(8);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.w("ShortVideoRealItemBuilder", 2, "[disProgress] set mProgressView gone");
      }
      return;
      paramagok.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setAnimRunnableListener(new agoi(this, paramagok));
    }
  }
  
  void b(MessageForShortVideo paramMessageForShortVideo)
  {
    if (a(paramMessageForShortVideo)) {
      return;
    }
    bbqx localbbqx = bbqf.a(2, 2);
    bbqh localbbqh = paramMessageForShortVideo.getDownloadInfo(localbbqx.jdField_b_of_type_Int);
    localbbqh.i = ShortVideoUtils.getShortVideoThumbPicPath(paramMessageForShortVideo.thumbMD5, "jpg");
    localbbqh.a(paramMessageForShortVideo.istroop, 1);
    localbbqh.jdField_f_of_type_Int = 2;
    localbbqh.jdField_g_of_type_Int = 2;
    localbbqx.a(localbbqh);
    localbbqx.a(paramMessageForShortVideo);
    bbqf.a(localbbqx, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
  }
  
  public void b(MessageForShortVideo paramMessageForShortVideo, agok paramagok)
  {
    if (paramMessageForShortVideo == null) {
      return;
    }
    a(paramMessageForShortVideo, "reForwardVideo：" + paramMessageForShortVideo.toString());
    if (!FileUtils.fileExistsAndNotEmpty(ShortVideoUtils.getShortVideoThumbPicPath(paramMessageForShortVideo.thumbMD5, "jpg")))
    {
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, 1, 2131718482, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299076));
      paramagok.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
      paramMessageForShortVideo.videoFileStatus = 1005;
      return;
    }
    if (!TextUtils.isEmpty(paramMessageForShortVideo.videoFileName))
    {
      ((bahm)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(326)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin, paramMessageForShortVideo, paramMessageForShortVideo.videoFileName);
      paramagok = bbqf.a(4, 2);
      paramagok.a(bbqf.a(2, paramMessageForShortVideo, paramagok));
      bbqf.a(paramagok, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      return;
    }
    a(paramMessageForShortVideo, "ShortVideoRealItemBuilder:reForwardVideo() path is empty");
  }
  
  void b(MessageForShortVideo paramMessageForShortVideo, agok paramagok, int paramInt)
  {
    paramagok.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.b(paramMessageForShortVideo.frienduin + paramMessageForShortVideo.uniseq);
    paramagok.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setVisibility(0);
    paramagok.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setImageResource(2130849681);
    paramagok.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setDrawStatus(3);
    if (QLog.isColorLevel()) {
      QLog.w("ShortVideoRealItemBuilder", 2, "[showWarnProgress] set mProgressView visible");
    }
    paramagok.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    paramagok.jdField_a_of_type_AndroidWidgetTextView.setText(paramInt);
  }
  
  public void b(FileMsg paramFileMsg, agok paramagok, MessageForShortVideo paramMessageForShortVideo, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    String str;
    switch (paramFileMsg.status)
    {
    default: 
    case 2001: 
    case 2003: 
      do
      {
        do
        {
          return;
          a(paramMessageForShortVideo, "THUMB STATUS_RECV_START");
          return;
          a(paramMessageForShortVideo, "THUMB STATUS_RECV_FINISHED");
          paramFileMsg = ShortVideoUtils.getShortVideoThumbPicPath(paramMessageForShortVideo.thumbMD5, "jpg");
          str = ShortVideoUtils.getShortVideoSavePath(paramMessageForShortVideo, "mp4");
          if ((!FileUtils.fileExistsAndNotEmpty(str)) || (!b(paramMessageForShortVideo))) {
            break;
          }
          a(paramMessageForShortVideo, amtj.a(2131713148) + paramFileMsg);
        } while (!ShortVideoUtils.isVideoSoLibLoaded());
        a(paramagok.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView, str, paramFileMsg, paramMessageForShortVideo, paramInt1, paramInt2);
        return;
        a(paramagok, paramFileMsg, paramMessageForShortVideo, paramInt3, paramInt4);
        if (!FileUtils.fileExistsAndNotEmpty(paramFileMsg)) {
          break;
        }
      } while (!a(paramagok.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView, paramFileMsg));
      a(paramMessageForShortVideo, amtj.a(2131713136) + paramFileMsg);
      if (!FileUtils.fileExistsAndNotEmpty(str))
      {
        if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getShortVideoPredownloer().a(paramMessageForShortVideo, true))
        {
          a(paramMessageForShortVideo, true);
          return;
        }
        c(paramMessageForShortVideo, paramagok);
        return;
      }
      if (ShortVideoUtils.isVideoSoLibLoaded())
      {
        a(paramagok);
        return;
      }
      c(paramMessageForShortVideo, paramagok);
      return;
      paramagok.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView.setID(paramMessageForShortVideo.uniseq);
      paramagok.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView.showCover(URLDrawableHelper.getFailedDrawable());
      return;
    case 5002: 
      a(paramMessageForShortVideo, "THUMB STATUS_FILE_EXPIRED");
    }
    a(paramMessageForShortVideo, "THUMB STATUS_RECV_ERROR");
    paramFileMsg = ShortVideoUtils.getShortVideoSavePath(paramMessageForShortVideo, "mp4");
    if (FileUtils.fileExistsAndNotEmpty(paramFileMsg))
    {
      a(paramMessageForShortVideo, amtj.a(2131713133) + paramFileMsg);
      if (ShortVideoUtils.isVideoSoLibLoaded())
      {
        str = ShortVideoUtils.getShortVideoThumbPicPath(paramMessageForShortVideo.thumbMD5, "jpg");
        a(paramagok.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView, paramFileMsg, str, paramMessageForShortVideo, paramInt1, paramInt2);
      }
    }
    for (;;)
    {
      a(paramagok);
      return;
      paramagok.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView.setID(paramMessageForShortVideo.uniseq);
      paramagok.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView.showCover(jdField_a_of_type_AndroidGraphicsDrawableColorDrawable);
    }
  }
  
  public void c(MessageForShortVideo paramMessageForShortVideo)
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
      String str1 = ShortVideoUtils.getShortVideoThumbPicPath(paramMessageForShortVideo.thumbMD5, "jpg");
      localBundle.putString("forward_thumb", str1);
      localBundle.putString("from_uin", ShortVideoUtils.getFromUinForForward(paramMessageForShortVideo));
      localBundle.putInt("from_uin_type", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType);
      localBundle.putString("from_session_uin", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin);
      localBundle.putInt("from_busi_type", paramMessageForShortVideo.busiType);
      localBundle.putInt("file_send_size", paramMessageForShortVideo.videoFileSize);
      localBundle.putInt("file_send_duration", paramMessageForShortVideo.videoFileTime);
      localBundle.putString("file_name", paramMessageForShortVideo.videoFileName);
      localBundle.putInt("file_format", paramMessageForShortVideo.videoFileFormat);
      localBundle.putInt("selection_mode", this.jdField_b_of_type_Int);
      String str2 = ShortVideoUtils.findVideoPathIfExists(paramMessageForShortVideo);
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
      if (FileUtils.fileExistsAndNotEmpty(str2))
      {
        localBundle.putBoolean("k_dataline", true);
        localBundle.putString("forward_extra", str2);
        localBundle.putBoolean("direct_send_if_dataline_forward", true);
        localBundle.putInt("forward_source_uin_type", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType);
      }
      paramMessageForShortVideo = new Intent();
      paramMessageForShortVideo.putExtras(localBundle);
    } while (this.jdField_a_of_type_AndroidContentContext == null);
    atky.a((Activity)this.jdField_a_of_type_AndroidContentContext, paramMessageForShortVideo, 21);
  }
  
  public void c(MessageForShortVideo paramMessageForShortVideo, agok paramagok)
  {
    paramagok.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.b(paramMessageForShortVideo.frienduin + paramMessageForShortVideo.uniseq);
    paramagok.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setDrawStatus(2);
    paramagok.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setVisibility(0);
    paramagok.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
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
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      jdField_d_of_type_Long = l;
      Object localObject;
      if (paramView.getId() == 2131364469)
      {
        localObject = (MessageRecord)paramView.getTag();
        if (localObject != null) {
          ((FlashChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(217)).a(paramView.getContext(), (MessageRecord)localObject);
        }
      }
      else
      {
        agok localagok = (agok)AIOUtils.getHolder(paramView);
        MessageForShortVideo localMessageForShortVideo = (MessageForShortVideo)localagok.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
        if (paramView.getId() != 2131364485) {
          if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isVideoChatting())
          {
            QQToast.a(this.jdField_a_of_type_AndroidContentContext, 2131695417, 1).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299076));
          }
          else
          {
            if (paramView.getId() == 2131364441) {
              a(localagok, localMessageForShortVideo, false);
            }
            if (paramView.getId() == 2131364460)
            {
              if (!localagok.jdField_a_of_type_ComTencentMobileqqDataChatMessage.isMultiMsg)
              {
                localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getTransFileController().findProcessor(localagok.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin, localagok.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
                if (((localObject instanceof ShortVideoUploadProcessor)) && (((ShortVideoUploadProcessor)localObject).isBDHSuccess))
                {
                  if (QLog.isColorLevel()) {
                    QLog.d("ShortVideoRealItemBuilder", 2, "shortVideoCancel pauseOperator BDHSuccess!");
                  }
                }
                else
                {
                  StringBuilder localStringBuilder1 = new StringBuilder();
                  localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getTransFileController().findProcessor(localagok.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin, localagok.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
                  if ((localObject instanceof ShortVideoUploadProcessor))
                  {
                    ((ShortVideoUploadProcessor)localObject).pause();
                    localStringBuilder1.append("\n shortVideoCancel uploadProcess pause!");
                    ShortVideoUtils.reportCancelSendVideo("0X800A7EE", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType);
                    if (QLog.isColorLevel()) {
                      QLog.d("ShortVideoRealItemBuilder", 2, "shortVideoCancel pauseOperator info:" + localStringBuilder1.toString());
                    }
                  }
                  else
                  {
                    EncodeVideoTask localEncodeVideoTask = (EncodeVideoTask)EncodeVideoTask.mEncodeList.remove(Long.valueOf(localagok.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq));
                    StringBuilder localStringBuilder2 = localStringBuilder1.append("\n shortVideoCancel uniseq:");
                    if (localEncodeVideoTask != null)
                    {
                      localObject = Long.valueOf(localEncodeVideoTask.mMsg.uniseq);
                      label439:
                      localObject = localStringBuilder2.append(localObject).append(", msgUniseq:").append(localagok.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq).append(", encodeFinish:");
                      if ((localEncodeVideoTask == null) || (!localEncodeVideoTask.isEncodeFinish)) {
                        break label636;
                      }
                    }
                    label636:
                    for (boolean bool = true;; bool = false)
                    {
                      ((StringBuilder)localObject).append(bool);
                      if ((localEncodeVideoTask == null) || (localEncodeVideoTask.mMsg.uniseq != localagok.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq) || (!localEncodeVideoTask.cancel())) {
                        break;
                      }
                      this.jdField_b_of_type_AndroidOsHandler.removeCallbacks(localMessageForShortVideo.progressTask);
                      localMessageForShortVideo.progressTask = null;
                      localMessageForShortVideo.videoFileStatus = 1004;
                      localMessageForShortVideo.md5 = null;
                      localMessageForShortVideo.serial();
                      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().updateMsgContentByUniseq(localMessageForShortVideo.frienduin, localMessageForShortVideo.istroop, localMessageForShortVideo.uniseq, localMessageForShortVideo.msgData);
                      bahm.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localMessageForShortVideo.frienduin, localMessageForShortVideo.uniseq);
                      i();
                      this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo = null;
                      jdField_h_of_type_Boolean = false;
                      break;
                      localObject = "-1";
                      break label439;
                    }
                  }
                }
              }
            }
            else {
              super.onClick(paramView);
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.ShortVideoRealItemBuilder
 * JD-Core Version:    0.7.0.1
 */