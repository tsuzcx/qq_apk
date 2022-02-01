package com.tencent.mobileqq.activity.aio.item;

import admh;
import afqq;
import afqr;
import afsn;
import aftf;
import aftk;
import ahac;
import ahad;
import ahae;
import ahaf;
import ahag;
import ahdc;
import ahdy;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.ColorDrawable;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import anvx;
import asbg;
import awel;
import awem;
import bbot;
import bcrn;
import bcwz;
import bcxb;
import bcxj;
import bcxr;
import bdla;
import bhbz;
import bhjq;
import bhjs;
import bkzi;
import bkzz;
import bmad;
import bman;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.image.QQLiveDrawable;
import com.tencent.image.QQLiveDrawable.OnStateListener;
import com.tencent.image.QQLiveDrawable.QQLiveDrawableParams;
import com.tencent.image.QQLiveImage;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.AudioPlayerBase;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.MediaPlayerManager;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForLightVideo;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.shortvideo.ShortVideoConstants;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils.ShortVideoPlayConfig;
import com.tencent.mobileqq.transfile.BaseTransProcessor;
import com.tencent.mobileqq.transfile.FileMsg;
import com.tencent.mobileqq.transfile.TransFileController;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.widget.BubbleImageView;
import com.tencent.mobileqq.widget.MessageProgressView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_SDKMgr;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ListView;
import com.tencent.widget.XListView;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import ykv;

public class LightVideoItemBuilder
  extends ahdy
  implements afsn, aftf, awem, QQLiveDrawable.OnStateListener, ShortVideoConstants
{
  protected static ColorDrawable a;
  private static Map<Long, MessageForLightVideo> jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap();
  static int jdField_c_of_type_Int;
  static int d;
  static int e;
  static int f;
  static int g;
  static int h;
  static int i;
  private URLDrawable jdField_a_of_type_ComTencentImageURLDrawable;
  private AudioPlayerBase jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayerBase;
  private MessageForLightVideo jdField_a_of_type_ComTencentMobileqqDataMessageForLightVideo;
  private ListView jdField_a_of_type_ComTencentWidgetListView;
  private Handler b = new Handler(Looper.getMainLooper());
  private long jdField_c_of_type_Long;
  private int j;
  private int k;
  private int l;
  
  static
  {
    Resources localResources = BaseApplicationImpl.sApplication.getResources();
    g = BaseChatItemLayout.f;
    g = Math.min(AIOUtils.dp2px(320.0F, localResources), g);
    h = AIOUtils.dp2px(100.0F, localResources);
    i = AIOUtils.dp2px(100.0F, localResources);
    e = AIOUtils.dp2px(160.0F, localResources);
    f = AIOUtils.dp2px(160.0F, localResources);
    jdField_a_of_type_AndroidGraphicsDrawableColorDrawable = new asbg(-10065297, e, f);
    jdField_c_of_type_Int = AIOUtils.dp2px(8.0F, localResources);
    d = AIOUtils.dp2px(3.0F, localResources);
  }
  
  public LightVideoItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    if (paramAIOAnimationConatiner != null) {
      this.jdField_a_of_type_ComTencentWidgetListView = paramAIOAnimationConatiner.a();
    }
    awel.a().a(this);
  }
  
  private void a(int paramInt, ahag paramahag, MessageForLightVideo paramMessageForLightVideo)
  {
    LightVideoItemBuilder.ChatVideoView localChatVideoView = paramahag.jdField_a_of_type_ComTencentMobileqqActivityAioItemLightVideoItemBuilder$ChatVideoView;
    switch (paramInt)
    {
    default: 
      return;
    case 2001: 
      a(paramMessageForLightVideo, "THUMB STATUS_RECV_START");
      return;
    case 2003: 
      a(paramMessageForLightVideo, "THUMB STATUS_RECV_FINISHED");
      b(paramahag, paramMessageForLightVideo, localChatVideoView);
      return;
    case 5002: 
      a(paramMessageForLightVideo, "THUMB STATUS_FILE_EXPIRED");
    }
    a(paramMessageForLightVideo, "THUMB STATUS_RECV_ERROR");
    String str = ShortVideoUtils.getShortVideoSavePath(paramMessageForLightVideo, "mp4");
    if (FileUtils.fileExistsAndNotEmpty(str)) {
      if (localChatVideoView.a(str))
      {
        a(paramMessageForLightVideo, anvx.a(2131705532) + str);
        if (ShortVideoUtils.isVideoSoLibLoaded())
        {
          paramMessageForLightVideo = awel.a(str, ShortVideoUtils.getShortVideoThumbPicPath(paramMessageForLightVideo.thumbMD5, "jpg"), paramMessageForLightVideo.uniseq, this.k, this.l, false, true, false, 0, this, null);
          paramahag.jdField_a_of_type_ComTencentMobileqqActivityAioItemLightVideoItemBuilder$ChatVideoView.setURLDrawable(paramMessageForLightVideo);
          b(paramahag);
        }
      }
    }
    for (;;)
    {
      a(paramahag);
      return;
      paramMessageForLightVideo = localChatVideoView.b;
      if ((paramMessageForLightVideo != null) && (paramMessageForLightVideo.getStatus() == 1))
      {
        localChatVideoView.setURLDrawable(paramMessageForLightVideo);
        continue;
        localChatVideoView.setImageDrawable(jdField_a_of_type_AndroidGraphicsDrawableColorDrawable);
      }
    }
  }
  
  private void a(ahag paramahag, MessageForLightVideo paramMessageForLightVideo, LightVideoItemBuilder.ChatVideoView paramChatVideoView)
  {
    if (c(paramMessageForLightVideo))
    {
      a(paramahag, false, false, 0, false, false);
      a(paramahag, paramMessageForLightVideo, 1);
    }
    do
    {
      return;
      if (d(paramMessageForLightVideo))
      {
        paramChatVideoView = ShortVideoUtils.getShortVideoThumbPicPath(paramMessageForLightVideo.thumbMD5, "jpg");
        a(paramahag.jdField_a_of_type_ComTencentMobileqqActivityAioItemLightVideoItemBuilder$ChatVideoView, paramChatVideoView, this.l, this.k);
        a(paramahag, paramMessageForLightVideo, 2);
        return;
      }
      if (!e(paramMessageForLightVideo)) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.d("LightVideoItemBuilder", 2, "shouldBePlayed uniseq:" + this.jdField_c_of_type_Long + " ,currPosition:" + this.j);
      }
      if (this.j > 0)
      {
        a(this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayerBase, paramahag, 0);
        a(paramahag, paramMessageForLightVideo, 1);
        this.j = 0;
        this.jdField_c_of_type_Long = 0L;
        return;
      }
    } while (MediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(paramMessageForLightVideo));
    QQToast.a(this.jdField_a_of_type_AndroidContentContext, 1, 2131694934, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299080));
    return;
    if (a(paramahag, paramMessageForLightVideo, paramChatVideoView))
    {
      a(paramahag, paramMessageForLightVideo, 3);
      return;
    }
    a(paramahag, paramMessageForLightVideo, 0);
  }
  
  private void a(ahag paramahag, boolean paramBoolean1, boolean paramBoolean2, int paramInt, boolean paramBoolean3, boolean paramBoolean4)
  {
    if (paramahag != null)
    {
      Object localObject1 = (MessageForLightVideo)paramahag.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
      String str1 = ShortVideoUtils.getShortVideoThumbPicPath(((MessageForLightVideo)localObject1).thumbMD5, "jpg");
      String str2 = ShortVideoUtils.getShortVideoSavePath((MessageForShortVideo)localObject1, "mp4");
      if ((this.k == 0) || (this.l == 0))
      {
        localObject2 = BaseApplicationImpl.getContext().getResources();
        this.k = AIOUtils.dp2px(160.0F, (Resources)localObject2);
        this.l = AIOUtils.dp2px(160.0F, (Resources)localObject2);
        if (QLog.isColorLevel()) {
          QLog.d("LightVideoItemBuilder", 2, "getURLDrawableByMsg w:" + this.k + " ,h:" + this.l + " ,uniseq:" + ((MessageForLightVideo)localObject1).uniseq);
        }
      }
      if ((this.jdField_a_of_type_ComTencentImageURLDrawable == null) || (!this.jdField_a_of_type_ComTencentImageURLDrawable.getURL().getPath().equals(str1))) {
        this.jdField_a_of_type_ComTencentImageURLDrawable = awel.a(str1, this.k, this.l);
      }
      Object localObject2 = awel.a(str2, str1, ((MessageForLightVideo)localObject1).uniseq, this.k, this.l, paramBoolean1, paramBoolean2, paramBoolean4, paramInt, this, this.jdField_a_of_type_ComTencentImageURLDrawable);
      paramahag.jdField_a_of_type_ComTencentMobileqqActivityAioItemLightVideoItemBuilder$ChatVideoView.setURLDrawable((URLDrawable)localObject2);
      if (paramBoolean3)
      {
        localObject2 = (URLDrawable)paramahag.jdField_a_of_type_ComTencentMobileqqActivityAioItemLightVideoItemBuilder$ChatVideoView.getDrawable();
        if ((((URLDrawable)localObject2).getStatus() == 1) && ((((URLDrawable)localObject2).getCurrDrawable() instanceof QQLiveDrawable)))
        {
          ((QQLiveDrawable)((URLDrawable)localObject2).getCurrDrawable()).release();
          localObject1 = awel.a(str2, str1, ((MessageForLightVideo)localObject1).uniseq, this.k, this.l, paramBoolean1, paramBoolean2, paramBoolean4, paramInt, this, this.jdField_a_of_type_ComTencentImageURLDrawable);
          paramahag.jdField_a_of_type_ComTencentMobileqqActivityAioItemLightVideoItemBuilder$ChatVideoView.setURLDrawable((URLDrawable)localObject1);
          if (QLog.isColorLevel()) {
            QLog.d("LightVideoItemBuilder", 2, "refreshVideo needRelease uniseq:" + paramahag.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
          }
        }
      }
    }
  }
  
  private void a(AudioPlayerBase paramAudioPlayerBase, ahag paramahag, int paramInt)
  {
    if ((paramahag == null) || (paramAudioPlayerBase == null)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("LightVideoItemBuilder", 2, "refreshVideoWithEarModeJudge! uniseq:" + paramahag.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq + " ,loudSpeaker:" + awel.a + " ,position:" + paramInt);
    }
    try
    {
      paramAudioPlayerBase.f();
      if (awel.a)
      {
        if (paramAudioPlayerBase.a()) {
          paramAudioPlayerBase.c();
        }
        a(paramahag, false, false, paramInt, true, false);
        return;
      }
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        localIOException.printStackTrace();
      }
      a(paramahag, false, true, paramInt, true, false);
      paramAudioPlayerBase.b(ShortVideoUtils.getShortVideoSavePath((MessageForShortVideo)paramahag.jdField_a_of_type_ComTencentMobileqqDataChatMessage, "mp4"), paramInt + 1000);
    }
  }
  
  private void a(LightVideoItemBuilder.ChatVideoView paramChatVideoView, String paramString, int paramInt1, int paramInt2)
  {
    if (paramChatVideoView.a(paramString)) {
      paramChatVideoView.setURLDrawable(awel.a(paramString, paramInt2, paramInt1));
    }
    do
    {
      return;
      paramString = paramChatVideoView.b;
    } while ((paramString == null) || (paramString.getStatus() != 1));
    paramChatVideoView.setURLDrawable(paramString);
  }
  
  private void a(MessageRecord paramMessageRecord, String paramString)
  {
    if (QLog.isColorLevel())
    {
      paramMessageRecord = "LightVideoItemBuilder" + "[" + paramMessageRecord.uniseq + "]";
      QLog.i("LightVideoItemBuilder", 2, paramMessageRecord + ":content " + paramString);
    }
  }
  
  private boolean a(MessageForLightVideo paramMessageForLightVideo, ahag paramahag)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LightVideoItemBuilder", 2, "startUploadVideo! uniseq:" + paramMessageForLightVideo.uniseq);
    }
    String str1 = paramMessageForLightVideo.videoFileName;
    String str2 = ShortVideoUtils.getShortVideoThumbPicPath(paramMessageForLightVideo.thumbMD5, "jpg");
    if (!FileUtils.fileExistsAndNotEmpty(str1))
    {
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, 1, 2131718867, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299080));
      paramMessageForLightVideo.videoFileStatus = 1005;
      return false;
    }
    if (!FileUtils.fileExistsAndNotEmpty(str2))
    {
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, 1, 2131718868, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299080));
      paramahag.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
      paramMessageForLightVideo.videoFileStatus = 1005;
      return false;
    }
    paramMessageForLightVideo.mThumbFilePath = str2;
    paramahag = bbot.a(paramMessageForLightVideo);
    paramahag.mLocalPath = paramMessageForLightVideo.videoFileName;
    paramahag.mMd5 = paramMessageForLightVideo.mLocalMd5;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getTransFileController().transferAsync(paramahag);
    return true;
  }
  
  private void b(int paramInt, ahag paramahag, MessageForLightVideo paramMessageForLightVideo)
  {
    LightVideoItemBuilder.ChatVideoView localChatVideoView = paramahag.jdField_a_of_type_ComTencentMobileqqActivityAioItemLightVideoItemBuilder$ChatVideoView;
    int m;
    if (paramMessageForLightVideo.thumbWidth > 0)
    {
      m = paramMessageForLightVideo.thumbWidth;
      label19:
      if (paramMessageForLightVideo.thumbHeight <= 0) {
        break label156;
      }
    }
    label156:
    for (int n = paramMessageForLightVideo.thumbHeight;; n = 100) {
      switch (paramInt)
      {
      default: 
        return;
        m = 100;
        break label19;
      }
    }
    a(paramMessageForLightVideo, "VIDEO STATUS_UPLOAD_FINISHED progress " + paramMessageForLightVideo.videoFileProgress);
    return;
    a(paramMessageForLightVideo, "VIDEO STATUS_SEND_START progress " + paramMessageForLightVideo.videoFileProgress);
    if (paramMessageForLightVideo.busiType != 1) {
      a(paramMessageForLightVideo, paramahag, paramMessageForLightVideo.videoFileProgress, true);
    }
    paramahag.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(false, this);
    return;
    String str = ShortVideoUtils.getShortVideoSavePath(paramMessageForLightVideo, "mp4");
    boolean bool = FileUtils.fileExistsAndNotEmpty(str);
    a(paramMessageForLightVideo, "VIDEO STATUS_SEND_FINISHED ,videofile:" + str + " ,videoexist:" + bool);
    if (bool)
    {
      a(paramahag, paramMessageForLightVideo, localChatVideoView);
      a(paramMessageForLightVideo, paramahag, 100, true);
    }
    c(paramMessageForLightVideo);
    return;
    a(paramMessageForLightVideo, "VIDEO STATUS_SEND_ERROR");
    c(paramMessageForLightVideo);
    b(paramMessageForLightVideo, paramahag, 2131718126);
    a(paramahag);
    paramahag.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
    return;
    a(paramMessageForLightVideo, "VIDEO STATUS_SEND_CANCEL");
    c(paramMessageForLightVideo);
    a(paramahag);
    return;
    paramInt = paramMessageForLightVideo.videoFileProgress;
    a(paramMessageForLightVideo, "VIDEO STATUS_SEND_PROCESS " + paramInt);
    a(paramMessageForLightVideo, paramahag, paramInt);
    return;
    a(paramMessageForLightVideo, "VIDEO STATUS_RECV_START");
    a(paramMessageForLightVideo, paramahag, paramMessageForLightVideo.videoFileProgress, true);
    return;
    a(paramMessageForLightVideo, "VIDEO STATUS_RECV_FINISHED");
    a(paramahag, paramMessageForLightVideo, localChatVideoView);
    a(paramMessageForLightVideo, paramahag, 100, true);
    b(paramahag);
    return;
    a(paramMessageForLightVideo, "VIDEO STATUS_FILE_UNSAFE");
    b(paramMessageForLightVideo, paramahag, 2131718120);
    if (paramMessageForLightVideo.uiOperatorFlag == 2)
    {
      paramahag.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, 2131718836, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299080));
      return;
    }
    QQToast.a(this.jdField_a_of_type_AndroidContentContext, 2131718860, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299080));
    return;
    a(paramMessageForLightVideo, "VIDEO STATUS_RECV_ERROR");
    a(paramahag);
    a(paramMessageForLightVideo, paramahag);
    QQToast.a(this.jdField_a_of_type_AndroidContentContext, 2131718862, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299080));
    return;
    a(paramMessageForLightVideo, "VIDEO STATUS_FILE_EXPIRED");
    str = ShortVideoUtils.getShortVideoThumbPicPath(paramMessageForLightVideo.thumbMD5, "jpg");
    if (FileUtils.fileExistsAndNotEmpty(str)) {
      a(localChatVideoView, str, n, m);
    }
    b(paramMessageForLightVideo, paramahag, 2131718121);
    return;
    a(paramMessageForLightVideo, "VIDEO STATUS_RECV_CANCEL");
    return;
    paramInt = paramMessageForLightVideo.videoFileProgress;
    a(paramMessageForLightVideo, "VIDEO STATUS_RECV_PROCESS " + paramInt);
    a(paramMessageForLightVideo, paramahag, paramInt, true);
  }
  
  private void b(ahag paramahag, MessageForLightVideo paramMessageForLightVideo, LightVideoItemBuilder.ChatVideoView paramChatVideoView)
  {
    int m;
    int n;
    label26:
    Object localObject;
    int i1;
    int i2;
    String str;
    if (paramMessageForLightVideo.thumbWidth > 0)
    {
      m = paramMessageForLightVideo.thumbWidth;
      if (paramMessageForLightVideo.thumbHeight <= 0) {
        break label166;
      }
      n = paramMessageForLightVideo.thumbHeight;
      localObject = this.jdField_a_of_type_AndroidContentContext.getResources();
      i1 = AIOUtils.dp2px(m, (Resources)localObject);
      i2 = AIOUtils.dp2px(n, (Resources)localObject);
      localObject = ShortVideoUtils.getShortVideoThumbPicPath(paramMessageForLightVideo.thumbMD5, "jpg");
      str = ShortVideoUtils.getShortVideoSavePath(paramMessageForLightVideo, "mp4");
      if ((!FileUtils.fileExistsAndNotEmpty(str)) || (!ShortVideoUtils.ShortVideoPlayConfig.sAutoPlayInAIO)) {
        break label173;
      }
      a(paramMessageForLightVideo, anvx.a(2131705542) + (String)localObject);
      if (ShortVideoUtils.isVideoSoLibLoaded())
      {
        paramMessageForLightVideo = awel.a(str, (String)localObject, paramMessageForLightVideo.uniseq, m, n, false, true, false, 0, this, null);
        paramahag.jdField_a_of_type_ComTencentMobileqqActivityAioItemLightVideoItemBuilder$ChatVideoView.setURLDrawable(paramMessageForLightVideo);
        b(paramahag);
      }
    }
    label166:
    label173:
    do
    {
      return;
      m = 100;
      break;
      n = 100;
      break label26;
      if (!FileUtils.fileExistsAndNotEmpty((String)localObject)) {
        break label328;
      }
    } while (!paramChatVideoView.a((String)localObject));
    a(paramMessageForLightVideo, anvx.a(2131705546) + (String)localObject);
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mRequestWidth = i1;
    localURLDrawableOptions.mRequestHeight = i2;
    localURLDrawableOptions.mLoadingDrawable = jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
    localURLDrawableOptions.mFailedDrawable = jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
    paramChatVideoView.setURLDrawable(URLDrawable.getDrawable(new File((String)localObject), localURLDrawableOptions));
    if (!FileUtils.fileExistsAndNotEmpty(str))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getShortVideoPredownloer().a(paramMessageForLightVideo, true))
      {
        a(paramMessageForLightVideo, true);
        return;
      }
      a(paramMessageForLightVideo, paramahag);
      return;
    }
    if (ShortVideoUtils.isVideoSoLibLoaded())
    {
      a(paramahag);
      return;
    }
    a(paramMessageForLightVideo, paramahag);
    return;
    label328:
    paramChatVideoView.setImageDrawable(URLDrawableHelper.getFailedDrawable());
  }
  
  private void b(boolean paramBoolean)
  {
    Iterator localIterator = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().getAIOList(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType).iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (ChatMessage)localIterator.next();
      if (((localObject instanceof MessageForLightVideo)) && (((MessageForLightVideo)localObject).videoStatus == 3))
      {
        localObject = a(((ChatMessage)localObject).uniseq);
        if ((localObject != null) && (((ahag)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioItemLightVideoItemBuilder$ChatVideoView != null) && (((ahag)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioItemLightVideoItemBuilder$ChatVideoView.b != null) && (((ahag)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioItemLightVideoItemBuilder$ChatVideoView.b.getStatus() == 1) && ((((ahag)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioItemLightVideoItemBuilder$ChatVideoView.b.getCurrDrawable() instanceof QQLiveDrawable))) {
          if (paramBoolean) {
            ((QQLiveDrawable)((ahag)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioItemLightVideoItemBuilder$ChatVideoView.b.getCurrDrawable()).pause();
          } else {
            ((QQLiveDrawable)((ahag)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioItemLightVideoItemBuilder$ChatVideoView.b.getCurrDrawable()).resume();
          }
        }
      }
    }
  }
  
  private boolean b(ahag paramahag, MessageForLightVideo paramMessageForLightVideo, LightVideoItemBuilder.ChatVideoView paramChatVideoView)
  {
    if ((TextUtils.isEmpty(paramMessageForLightVideo.md5)) && (paramMessageForLightVideo.videoFileStatus != 1005) && (paramMessageForLightVideo.extraflag != 32768))
    {
      if (paramMessageForLightVideo.isSendFromLocal())
      {
        Object localObject2 = paramMessageForLightVideo.mThumbFilePath;
        Object localObject1 = localObject2;
        if (!FileUtils.fileExistsAndNotEmpty((String)localObject2))
        {
          if (TextUtils.isEmpty(paramMessageForLightVideo.thumbMD5))
          {
            paramChatVideoView.setImageDrawable(URLDrawableHelper.getFailedDrawable());
            a(paramahag);
            a(paramMessageForLightVideo, "getBubbleView():You must get thumb before send video.");
            return true;
          }
          localObject1 = ShortVideoUtils.getShortVideoThumbPicPath(paramMessageForLightVideo.thumbMD5, "jpg");
        }
        if (paramChatVideoView.a((String)localObject1))
        {
          localObject2 = URLDrawable.URLDrawableOptions.obtain();
          ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
          ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
          ((URLDrawable.URLDrawableOptions)localObject2).mRequestWidth = this.k;
          ((URLDrawable.URLDrawableOptions)localObject2).mRequestHeight = this.l;
          paramChatVideoView.setURLDrawable(URLDrawable.getDrawable(new File((String)localObject1), (URLDrawable.URLDrawableOptions)localObject2));
          boolean bool = a(paramMessageForLightVideo, null);
          if (QLog.isColorLevel()) {
            QLog.d("LightVideoItemBuilder", 2, String.format("getBubbleView, judge mr status uniseq:%d, filestatus:%s, isfailed:%s", new Object[] { Long.valueOf(paramMessageForLightVideo.uniseq), Integer.valueOf(paramMessageForLightVideo.videoFileStatus), Boolean.valueOf(bool) }));
          }
          if (!bool) {
            a(paramMessageForLightVideo, paramahag, paramMessageForLightVideo.videoFileProgress, true);
          }
        }
      }
      return true;
    }
    return false;
  }
  
  private void c(MessageForLightVideo paramMessageForLightVideo)
  {
    if ((paramMessageForLightVideo != null) && (paramMessageForLightVideo.progressTask != null))
    {
      this.b.removeCallbacks(paramMessageForLightVideo.progressTask);
      paramMessageForLightVideo.progressTask = null;
    }
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    return 0;
  }
  
  public afqq a(View paramView)
  {
    if ((paramView != null) && (paramView.getParent() != null))
    {
      paramView = (ahag)((View)paramView.getParent()).getTag();
      if (paramView != null) {
        return paramView.jdField_a_of_type_ComTencentMobileqqActivityAioItemLightVideoItemBuilder$ChatVideoView;
      }
    }
    return null;
  }
  
  public afqr a()
  {
    return new ahag(this);
  }
  
  public ahag a(long paramLong)
  {
    if ((this.jdField_a_of_type_ComTencentWidgetListView != null) && (paramLong > 0L))
    {
      int m = AIOUtils.findMessagePosition(paramLong, this.jdField_a_of_type_ComTencentWidgetListView.getAdapter());
      int n = this.jdField_a_of_type_ComTencentWidgetListView.getHeaderViewsCount();
      int i1 = this.jdField_a_of_type_ComTencentWidgetListView.getFirstVisiblePosition();
      int i2 = this.jdField_a_of_type_ComTencentWidgetListView.getLastVisiblePosition();
      if (m <= -1) {
        break label223;
      }
      Object localObject = AIOUtils.getViewByPostion(this.jdField_a_of_type_ComTencentWidgetListView, m);
      if (localObject != null)
      {
        localObject = AIOUtils.getHolder((View)localObject);
        if ((localObject != null) && ((localObject instanceof ahag))) {
          return (ahag)localObject;
        }
      }
      else if (QLog.isColorLevel())
      {
        QLog.w("LightVideoItemBuilder", 2, "getHolderByMsg() uniseq=" + paramLong + ", posi =" + m + ", view = null");
      }
      if (QLog.isColorLevel()) {
        QLog.d("LightVideoItemBuilder", 2, "getHolderByMsg() uniseq=" + paramLong + ", posi =" + m + ", firstVisblePosi=" + i1 + ",lastVisblePosi=" + i2 + ",headerCount=" + n);
      }
    }
    for (;;)
    {
      return null;
      label223:
      if (QLog.isColorLevel()) {
        QLog.w("LightVideoItemBuilder", 2, "getHolderByMsg() uniseq=" + paramLong + ", posi<= -1");
      }
    }
  }
  
  public View a(int paramInt1, int paramInt2, ChatMessage paramChatMessage, View paramView, ViewGroup paramViewGroup, aftk paramaftk)
  {
    paramViewGroup = super.a(paramInt1, paramInt2, paramChatMessage, paramView, paramViewGroup, paramaftk);
    a(paramChatMessage, paramView, this);
    return paramViewGroup;
  }
  
  public View a(ChatMessage paramChatMessage, afqr paramafqr, View paramView, BaseChatItemLayout paramBaseChatItemLayout, aftk paramaftk)
  {
    paramBaseChatItemLayout = (ahag)paramafqr;
    Object localObject2 = this.jdField_a_of_type_AndroidContentContext;
    Resources localResources = ((Context)localObject2).getResources();
    MessageForLightVideo localMessageForLightVideo = (MessageForLightVideo)paramChatMessage;
    paramafqr = paramView;
    if (paramView == null)
    {
      paramafqr = new RelativeLayout((Context)localObject2);
      paramView = new LightVideoItemBuilder.ChatVideoView((Context)localObject2);
      paramView.setId(2131372790);
      paramView.setScaleType(ImageView.ScaleType.CENTER_CROP);
      paramView.setRadius(15.0F);
      paramView.d(false);
      paramView.setSharpCornerCor(BubbleImageView.a);
      paramView.setContentDescription(anvx.a(2131705528));
      paramafqr.addView(paramView);
      MessageProgressView localMessageProgressView = new MessageProgressView((Context)localObject2);
      paramafqr.addView(localMessageProgressView);
      Object localObject3 = new LinearLayout((Context)localObject2);
      ((LinearLayout)localObject3).setOrientation(1);
      ((LinearLayout)localObject3).setGravity(17);
      Object localObject1 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject1).addRule(13);
      paramafqr.addView((View)localObject3, (ViewGroup.LayoutParams)localObject1);
      localObject1 = new TextView((Context)localObject2);
      Object localObject4 = new LinearLayout.LayoutParams(-2, -2);
      ((LinearLayout.LayoutParams)localObject4).topMargin = AIOUtils.dp2px(70.0F, localResources);
      ((TextView)localObject1).setTextColor(-1);
      ((TextView)localObject1).setTextSize(2, 12.0F);
      ((TextView)localObject1).setId(2131364565);
      ((LinearLayout)localObject3).addView((View)localObject1, (ViewGroup.LayoutParams)localObject4);
      localObject2 = new LinearLayout((Context)localObject2);
      ((LinearLayout)localObject2).setOrientation(0);
      ((LinearLayout)localObject2).setGravity(16);
      ((LinearLayout)localObject2).setBackgroundResource(2130838124);
      ((LinearLayout)localObject2).setId(2131362433);
      ((LinearLayout)localObject2).setOnClickListener(new ahac(this));
      localObject3 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject3).addRule(8, 2131372790);
      ((RelativeLayout.LayoutParams)localObject3).bottomMargin = jdField_c_of_type_Int;
      ((RelativeLayout.LayoutParams)localObject3).addRule(5, 2131372790);
      ((RelativeLayout.LayoutParams)localObject3).leftMargin = jdField_c_of_type_Int;
      paramafqr.addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
      localObject3 = new ImageView(this.jdField_a_of_type_AndroidContentContext);
      ((ImageView)localObject3).setId(2131374239);
      ((ImageView)localObject3).setPadding(jdField_c_of_type_Int, d, d, d);
      ((LinearLayout)localObject2).addView((View)localObject3);
      localObject4 = new TextView(this.jdField_a_of_type_AndroidContentContext);
      ((TextView)localObject4).setId(2131374244);
      ((TextView)localObject4).setTextColor(-1);
      ((TextView)localObject4).setPadding(0, d, jdField_c_of_type_Int, d);
      ((LinearLayout)localObject2).addView((View)localObject4);
      paramafqr.setOnClickListener(this);
      paramafqr.setOnTouchListener(paramaftk);
      paramafqr.setOnLongClickListener(paramaftk);
      paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqActivityAioItemLightVideoItemBuilder$ChatVideoView = paramView;
      paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView = localMessageProgressView;
      paramBaseChatItemLayout.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localObject1);
      paramBaseChatItemLayout.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localObject3);
      paramBaseChatItemLayout.b = ((TextView)localObject4);
    }
    paramView = paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqActivityAioItemLightVideoItemBuilder$ChatVideoView;
    if (AppSetting.c)
    {
      paramaftk = new StringBuilder();
      paramaftk.append("轻量短视频 ");
      paramaftk.append(localMessageForLightVideo.videoFileTime);
      paramaftk.append("秒");
      if ((!localMessageForLightVideo.isSend()) && (!localMessageForLightVideo.isLightVideoRead)) {
        paramaftk.append(" 未播放");
      }
      paramView.setContentDescription(paramaftk.toString());
    }
    paramView.d = localMessageForLightVideo.isSend();
    paramView.setTag(Long.valueOf(localMessageForLightVideo.uniseq));
    bhbz.a().a(Long.valueOf(localMessageForLightVideo.uniseq), localMessageForLightVideo);
    paramBaseChatItemLayout.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setRadius(15.0F, true);
    paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setShowCorner(false);
    paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setSharpCornerCor(BubbleImageView.a);
    paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setCornerDirection(localMessageForLightVideo.isSend());
    paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.a(paramChatMessage.frienduin + paramChatMessage.uniseq);
    this.k = AIOUtils.dp2px(160.0F, localResources);
    this.l = AIOUtils.dp2px(160.0F, localResources);
    localMessageForLightVideo.thumbWidth = this.k;
    localMessageForLightVideo.thumbHeight = this.l;
    localMessageForLightVideo.hasShowInAIO = true;
    paramChatMessage = paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqActivityAioItemLightVideoItemBuilder$ChatVideoView.getLayoutParams();
    if (paramChatMessage == null)
    {
      paramChatMessage = new RelativeLayout.LayoutParams(this.k, this.l);
      paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqActivityAioItemLightVideoItemBuilder$ChatVideoView.setLayoutParams(paramChatMessage);
      paramChatMessage = paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.getLayoutParams();
      if (paramChatMessage != null) {
        break label882;
      }
      paramChatMessage = new RelativeLayout.LayoutParams(this.k, this.l);
      paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setLayoutParams(paramChatMessage);
    }
    for (;;)
    {
      a(paramBaseChatItemLayout, localMessageForLightVideo, paramView);
      return paramafqr;
      if ((paramChatMessage.width == this.k) && (paramChatMessage.height == this.l)) {
        break;
      }
      paramChatMessage.width = this.k;
      paramChatMessage.height = this.l;
      paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqActivityAioItemLightVideoItemBuilder$ChatVideoView.setLayoutParams(paramChatMessage);
      break;
      label882:
      if ((paramChatMessage.width != this.k) || (paramChatMessage.height != this.l))
      {
        paramChatMessage.width = this.k;
        paramChatMessage.height = this.l;
        paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setLayoutParams(paramChatMessage);
      }
    }
  }
  
  public String a(ChatMessage paramChatMessage)
  {
    return anvx.a(2131705551);
  }
  
  public void a()
  {
    Iterator localIterator = jdField_a_of_type_JavaUtilMap.values().iterator();
    while (localIterator.hasNext())
    {
      MessageForLightVideo localMessageForLightVideo = (MessageForLightVideo)localIterator.next();
      if (localMessageForLightVideo.progressTask != null) {
        localMessageForLightVideo.progressTask = null;
      }
    }
    jdField_a_of_type_JavaUtilMap.clear();
    this.b.removeCallbacksAndMessages(null);
    this.jdField_a_of_type_AndroidContentContext = null;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayerBase = null;
    if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForLightVideo != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForLightVideo.mCurrQQLive = null;
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForLightVideo = null;
    }
    awel.a().a(null);
    this.jdField_a_of_type_ComTencentImageURLDrawable = null;
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    MessageForLightVideo localMessageForLightVideo;
    if ((paramChatMessage != null) && ((paramChatMessage instanceof MessageForLightVideo)))
    {
      localMessageForLightVideo = (MessageForLightVideo)paramChatMessage;
      if (paramInt == 2131365475)
      {
        admh.b(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localMessageForLightVideo);
        ykv.a("story_grp", "press_msg", 0, 0, new String[] { "4", "", "", "" });
      }
    }
    else
    {
      return;
    }
    if (paramInt == 2131371684)
    {
      super.d(paramChatMessage);
      ykv.a("story_grp", "press_msg", 0, 0, new String[] { "5", "", "", "" });
      return;
    }
    if (paramInt == 2131366456)
    {
      bmad.a(localMessageForLightVideo).b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage).a((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
      bman.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 6, 5);
      bman.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 3, 0, paramChatMessage.istroop);
      ykv.a("story_grp", "press_msg", 0, 0, new String[] { "2", "", "", "" });
      return;
    }
    if (paramInt == 2131371641)
    {
      if (c(paramChatMessage)) {
        MediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(true);
      }
      super.a(localMessageForLightVideo);
      ykv.a("story_grp", "press_msg", 0, 0, new String[] { "3", "", "", "" });
      return;
    }
    if (paramInt == 2131365437)
    {
      paramContext = new StringBuilder();
      paramContext.append("uniseq:").append(localMessageForLightVideo.uniseq).append("\n");
      Toast.makeText(this.jdField_a_of_type_AndroidContentContext, paramContext.toString(), 1).show();
      return;
    }
    super.a(paramInt, paramContext, paramChatMessage);
  }
  
  protected void a(ahag paramahag)
  {
    if (!paramahag.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.a(paramahag.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin + paramahag.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq)) {
      paramahag.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setVisibility(8);
    }
    for (;;)
    {
      paramahag.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      if (QLog.isColorLevel()) {
        QLog.w("LightVideoItemBuilder", 2, "[hideProgress] set ProgressPieDrawable visible");
      }
      return;
      paramahag.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setAnimRunnableListener(new ahae(this, paramahag));
    }
  }
  
  protected void a(ahag paramahag, MessageForLightVideo paramMessageForLightVideo, int paramInt)
  {
    if (paramahag == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("LightVideoItemBuilder", 2, String.format("handleVideoViewAnimStatus uniseq:%d, status:%d", new Object[] { Long.valueOf(paramMessageForLightVideo.uniseq), Integer.valueOf(paramInt) }));
    }
    paramahag.b.setText(ahdc.a(paramMessageForLightVideo.videoFileTime));
    paramahag.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setUnread(false, null, null);
    paramMessageForLightVideo.videoStatus = paramInt;
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      if ((!paramMessageForLightVideo.isSend()) && (!paramMessageForLightVideo.isLightVideoRead)) {
        paramahag.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setUnread(true, null, null);
      }
      paramahag.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130840562);
      return;
    case 1: 
      a(paramMessageForLightVideo);
      paramMessageForLightVideo = (AnimationDrawable)this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130772076);
      paramahag.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramMessageForLightVideo);
      paramMessageForLightVideo.start();
      return;
    case 2: 
      paramahag.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130840559);
      return;
    }
    if ((!paramMessageForLightVideo.isSend()) && (!paramMessageForLightVideo.isLightVideoRead)) {
      paramahag.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setUnread(true, null, null);
    }
    paramahag.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130840559);
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    paramView = (ahag)AIOUtils.getHolder(paramView);
    MessageForLightVideo localMessageForLightVideo = (MessageForLightVideo)paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
    if (!localMessageForLightVideo.isSendFromLocal()) {
      return;
    }
    bkzi localbkzi = (bkzi)bkzz.a(this.jdField_a_of_type_AndroidContentContext, null);
    localbkzi.a(2131689976, 5);
    localbkzi.c(2131690697);
    localbkzi.a(new ahad(this, localMessageForLightVideo, paramView, localbkzi));
    localbkzi.show();
  }
  
  public void a(View paramView, ChatMessage paramChatMessage)
  {
    int m = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131296391);
    if (paramChatMessage.isSend())
    {
      paramView.setPadding(BaseChatItemLayout.k, BaseChatItemLayout.h, m, BaseChatItemLayout.i);
      return;
    }
    paramView.setPadding(m, BaseChatItemLayout.h, BaseChatItemLayout.k, BaseChatItemLayout.i);
  }
  
  public void a(View paramView, FileMsg paramFileMsg, int paramInt1, int paramInt2)
  {
    paramView = (ahag)AIOUtils.getHolder(paramView);
    MessageForLightVideo localMessageForLightVideo = (MessageForLightVideo)paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
    if (localMessageForLightVideo.uniseq != paramFileMsg.uniseq) {}
    do
    {
      do
      {
        return;
      } while (this.jdField_a_of_type_AndroidContentContext == null);
      if ((paramFileMsg.fileType == 327689) || (paramFileMsg.fileType == 6) || (paramFileMsg.fileType == 17) || (paramFileMsg.fileType == 9))
      {
        b(paramFileMsg.status, paramView, localMessageForLightVideo);
        return;
      }
    } while ((paramFileMsg.fileType != 7) && (paramFileMsg.fileType != 18) && (paramFileMsg.fileType != 16));
    a(paramFileMsg.status, paramView, localMessageForLightVideo);
  }
  
  public void a(MessageForLightVideo paramMessageForLightVideo)
  {
    if (!paramMessageForLightVideo.isLightVideoRead)
    {
      paramMessageForLightVideo.isLightVideoRead = true;
      paramMessageForLightVideo.saveExtInfoToExtStr(bcrn.u, "1");
      ThreadManager.post(new LightVideoItemBuilder.2(this, paramMessageForLightVideo), 10, null, false);
    }
  }
  
  void a(MessageForLightVideo paramMessageForLightVideo, ahag paramahag)
  {
    paramahag.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.b(paramMessageForLightVideo.frienduin + paramMessageForLightVideo.uniseq);
    paramahag.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setDrawStatus(2);
    paramahag.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setVisibility(0);
    paramahag.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    if (QLog.isColorLevel()) {
      QLog.w("LightVideoItemBuilder", 2, "[showPauseProgress] uinseq:" + paramMessageForLightVideo.uniseq);
    }
  }
  
  void a(MessageForLightVideo paramMessageForLightVideo, ahag paramahag, int paramInt)
  {
    int m = ShortVideoUtils.getDisplayProgress(paramInt, 10);
    if (paramMessageForLightVideo.busiType == 1)
    {
      if (m < 60) {
        return;
      }
      if (paramMessageForLightVideo.progressTask != null)
      {
        this.b.removeCallbacks(paramMessageForLightVideo.progressTask);
        paramMessageForLightVideo.progressTask = null;
        a(paramMessageForLightVideo, "VIDEO STATUS_SEND_PROCESS CLOSE_TASK PROCESS:" + m);
      }
    }
    a(paramMessageForLightVideo, paramahag, paramInt, true);
  }
  
  protected void a(MessageForLightVideo paramMessageForLightVideo, ahag paramahag, int paramInt, boolean paramBoolean)
  {
    paramahag.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setDrawStatus(1);
    paramahag.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setAnimProgress(paramInt, paramMessageForLightVideo.frienduin + paramMessageForLightVideo.uniseq);
    paramahag.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setVisibility(0);
    paramahag.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    if (QLog.isColorLevel()) {
      QLog.w("LightVideoItemBuilder", 2, "[setProgress] uinseq:" + paramMessageForLightVideo.uniseq + ", p:" + paramInt);
    }
  }
  
  void a(MessageForLightVideo paramMessageForLightVideo, boolean paramBoolean)
  {
    if (paramMessageForLightVideo.videoFileStatus == 5002)
    {
      a(paramMessageForLightVideo, anvx.a(2131705549));
      return;
    }
    bcxr localbcxr = bcwz.a(2, 2);
    bcxb localbcxb = paramMessageForLightVideo.getDownloadInfo(localbcxr.b);
    localbcxb.h = ShortVideoUtils.getShortVideoSavePath(paramMessageForLightVideo, "mp4");
    localbcxb.a(paramMessageForLightVideo.istroop, 0);
    if (paramBoolean) {}
    for (int m = 2;; m = 1)
    {
      localbcxb.f = m;
      localbcxb.g = 2;
      if (QLog.isColorLevel()) {
        QLog.d("LightVideoItemBuilder", 2, " startDownloadVideo downloadvideo fileType==" + localbcxb.e + ", uniseq:" + paramMessageForLightVideo.uniseq);
      }
      localbcxr.a(localbcxb);
      localbcxr.a(paramMessageForLightVideo);
      bcwz.a(localbcxr, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      return;
    }
  }
  
  public void a(ListView paramListView)
  {
    this.jdField_a_of_type_ComTencentWidgetListView = paramListView;
  }
  
  public void a(XListView paramXListView, int paramInt, View paramView, ChatMessage paramChatMessage, long paramLong, float paramFloat) {}
  
  public void a(XListView paramXListView, int paramInt, View paramView, ChatMessage paramChatMessage, boolean paramBoolean)
  {
    paramBoolean = true;
    if (QLog.isColorLevel()) {
      QLog.d("LightVideoItemBuilder", 2, "onStop! uniseq:" + paramChatMessage.uniseq);
    }
    b(false);
    paramXListView = (ahag)AIOUtils.getHolder(paramView);
    if (paramXListView == null) {
      if (QLog.isColorLevel())
      {
        paramXListView = new StringBuilder().append("onStop msgUniseq=").append(paramChatMessage.uniseq).append(" , holder is null, ,currMsg is null:");
        if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForLightVideo == null) {
          QLog.w("LightVideoItemBuilder", 2, paramBoolean);
        }
      }
      else if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForLightVideo != null) && (this.jdField_a_of_type_ComTencentMobileqqDataMessageForLightVideo.mCurrQQLive != null))
      {
        if (QLog.isColorLevel()) {
          QLog.d("LightVideoItemBuilder", 2, "onStop! release lastQQLive, uniseq" + this.jdField_a_of_type_ComTencentMobileqqDataMessageForLightVideo.uniseq);
        }
        this.jdField_a_of_type_ComTencentMobileqqDataMessageForLightVideo.mCurrQQLive.release();
        this.jdField_a_of_type_ComTencentMobileqqDataMessageForLightVideo.mCurrQQLive = null;
        this.jdField_a_of_type_ComTencentMobileqqDataMessageForLightVideo = null;
      }
    }
    for (;;)
    {
      return;
      paramBoolean = false;
      break;
      paramView = paramXListView.jdField_a_of_type_ComTencentMobileqqActivityAioItemLightVideoItemBuilder$ChatVideoView;
      paramChatMessage = (MessageForLightVideo)paramXListView.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
      URLDrawable localURLDrawable = (URLDrawable)paramView.getDrawable();
      if ((localURLDrawable != null) && (localURLDrawable.getStatus() == 1) && ((localURLDrawable.getCurrDrawable() instanceof QQLiveDrawable))) {
        ((QQLiveDrawable)localURLDrawable.getCurrDrawable()).release();
      }
      if (d(paramChatMessage)) {
        a(paramView, ShortVideoUtils.getShortVideoThumbPicPath(paramChatMessage.thumbMD5, "jpg"), AIOUtils.dp2px(160.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), AIOUtils.dp2px(160.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
      }
      while (this.jdField_a_of_type_ComTencentMobileqqDataMessageForLightVideo != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqDataMessageForLightVideo.mCurrQQLive = null;
        this.jdField_a_of_type_ComTencentMobileqqDataMessageForLightVideo = null;
        return;
        a(paramXListView, true, true, 0, false, false);
        a(paramXListView, paramChatMessage, 3);
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    ChatMessage localChatMessage = MediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a();
    ahag localahag;
    if ((localChatMessage != null) && ((localChatMessage instanceof MessageForLightVideo)))
    {
      localahag = a(localChatMessage.uniseq);
      if (localahag != null) {
        break label73;
      }
      if (QLog.isColorLevel()) {
        QLog.w("LightVideoItemBuilder", 2, "onNearToEar holder == null, uniseq = " + localChatMessage.uniseq);
      }
    }
    label73:
    int m;
    do
    {
      do
      {
        return;
      } while ((localahag.jdField_a_of_type_ComTencentMobileqqActivityAioItemLightVideoItemBuilder$ChatVideoView == null) || (localahag.jdField_a_of_type_ComTencentMobileqqActivityAioItemLightVideoItemBuilder$ChatVideoView.b == null) || (localahag.jdField_a_of_type_ComTencentMobileqqActivityAioItemLightVideoItemBuilder$ChatVideoView.b.getStatus() != 1) || (!(localahag.jdField_a_of_type_ComTencentMobileqqActivityAioItemLightVideoItemBuilder$ChatVideoView.b.getCurrDrawable() instanceof QQLiveDrawable)));
      m = (int)((QQLiveDrawable)localahag.jdField_a_of_type_ComTencentMobileqqActivityAioItemLightVideoItemBuilder$ChatVideoView.b.getCurrDrawable()).getCurrentPosition();
      a(this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayerBase, localahag, m - 1000);
    } while (!QLog.isColorLevel());
    QLog.d("LightVideoItemBuilder", 2, String.format("onNearToEar usingLoudSpeaker:%s, position:%d, duration:%d, uniseq:%d", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(m), Integer.valueOf(((MessageForShortVideo)localahag.jdField_a_of_type_ComTencentMobileqqDataChatMessage).videoFileTime), Long.valueOf(localahag.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq) }));
  }
  
  protected boolean a(ahag paramahag, MessageForLightVideo paramMessageForLightVideo, LightVideoItemBuilder.ChatVideoView paramChatVideoView)
  {
    boolean bool2 = false;
    if (b(paramahag, paramMessageForLightVideo, paramChatVideoView))
    {
      bool2 = false;
      return bool2;
    }
    String str1 = ShortVideoUtils.getShortVideoThumbPicPath(paramMessageForLightVideo.thumbMD5, "jpg");
    String str2 = ShortVideoUtils.getShortVideoSavePath(paramMessageForLightVideo, "mp4");
    boolean bool4 = FileUtils.fileExistsAndNotEmpty(str1);
    boolean bool1 = FileUtils.fileExistsAndNotEmpty(str2);
    if (QLog.isColorLevel()) {
      QLog.d("LightVideoItemBuilder", 2, String.format("handleVideoFileStatus uniseq:%d, thumb:%s, videofile:%s", new Object[] { Long.valueOf(paramMessageForLightVideo.uniseq), Boolean.valueOf(bool4), Boolean.valueOf(bool1) }));
    }
    if (bool1)
    {
      paramahag.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setVisibility(8);
      if ((!paramMessageForLightVideo.isSendFromLocal()) || (paramMessageForLightVideo.isStatusReady())) {
        if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForLightVideo != null) && (this.jdField_a_of_type_ComTencentMobileqqDataMessageForLightVideo.videoStatus == 1))
        {
          bool2 = true;
          label149:
          a(paramahag, true, true, 0, false, bool2);
          boolean bool3 = true;
          bool1 = bool3;
          if (QLog.isColorLevel())
          {
            QLog.d("LightVideoItemBuilder", 2, "LightVideo mutePlaying, uniseq:" + paramMessageForLightVideo.uniseq + " ,shouldPause:" + bool2);
            bool1 = bool3;
          }
        }
      }
      for (;;)
      {
        bool2 = bool1;
        if (bool4) {
          break;
        }
        b(paramMessageForLightVideo);
        a(paramMessageForLightVideo, "getBubbleView: Video file exist and status finish. Thumb not exist.");
        return bool1;
        bool2 = false;
        break label149;
        bool1 = bool2;
        if (bool4)
        {
          a(paramChatVideoView, str1, this.l, this.k);
          bool1 = bool2;
        }
      }
    }
    if (bool4)
    {
      a(paramChatVideoView, str1, this.l, this.k);
      if (paramMessageForLightVideo.videoFileStatus == 2005) {
        a(paramMessageForLightVideo, paramahag);
      }
      if (paramMessageForLightVideo.videoFileStatus == 5002)
      {
        a(paramMessageForLightVideo, anvx.a(2131705555));
        b(paramMessageForLightVideo, paramahag, 2131718121);
        return false;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getShortVideoPredownloer().a(paramMessageForLightVideo, true))
      {
        a(paramMessageForLightVideo, true);
        return false;
      }
      if ((paramMessageForLightVideo.videoFileStatus == 2001) || (paramMessageForLightVideo.videoFileStatus == 2002) || (paramMessageForLightVideo.videoFileStatus == 2000))
      {
        a(paramMessageForLightVideo, paramahag, paramMessageForLightVideo.videoFileProgress, false);
        return false;
      }
      a(paramMessageForLightVideo, paramahag);
      return true;
    }
    if (paramMessageForLightVideo.videoFileStatus == 5002)
    {
      a(paramMessageForLightVideo, anvx.a(2131705529));
      paramChatVideoView.setImageDrawable(jdField_a_of_type_AndroidGraphicsDrawableColorDrawable);
      b(paramMessageForLightVideo, paramahag, 2131718121);
      return false;
    }
    a(paramMessageForLightVideo, anvx.a(2131705535));
    paramChatVideoView.setImageDrawable(jdField_a_of_type_AndroidGraphicsDrawableColorDrawable);
    b(paramMessageForLightVideo);
    return false;
  }
  
  public boolean a(ChatMessage paramChatMessage, BaseChatItemLayout paramBaseChatItemLayout)
  {
    if (!paramChatMessage.isSendFromLocal()) {}
    do
    {
      do
      {
        return false;
        paramChatMessage = (MessageForLightVideo)paramChatMessage;
      } while (paramChatMessage.videoFileStatus == 5002);
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
    } while ((paramChatMessage.videoFileProgress == 100) || (paramChatMessage.videoFileStatus == 1003) || (paramChatMessage.videoFileStatus == 2003));
    if (QLog.isColorLevel()) {
      QLog.d("LightVideoItemBuilder", 2, String.format("isFailed is true, uniseq:%d, fileStatus:%d, fileProgress:%d", new Object[] { Long.valueOf(paramChatMessage.uniseq), Integer.valueOf(paramChatMessage.videoFileStatus), Integer.valueOf(paramChatMessage.videoFileProgress) }));
    }
    return true;
  }
  
  public boolean a(XListView paramXListView, int paramInt, View paramView, ChatMessage paramChatMessage)
  {
    paramXListView = (MessageForLightVideo)paramChatMessage;
    boolean bool;
    if ((!paramXListView.isSend()) && (!paramXListView.isLightVideoRead) && (paramXListView.isAllReady())) {
      bool = true;
    }
    while (paramXListView.istroop != 0) {
      if ((bool) && (paramXListView.hasShowInAIO))
      {
        return true;
        bool = false;
      }
      else
      {
        return false;
      }
    }
    return bool;
  }
  
  public boolean a(XListView paramXListView, int paramInt1, View paramView, ChatMessage paramChatMessage, AudioPlayerBase paramAudioPlayerBase, int paramInt2)
  {
    paramXListView = (ahag)AIOUtils.getHolder(paramView);
    if (QLog.isColorLevel()) {
      QLog.d("LightVideoItemBuilder", 2, "play! uniseq:" + paramChatMessage.uniseq + " ,viewpositon:" + paramInt1);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayerBase = paramAudioPlayerBase;
    if (paramXListView == null)
    {
      this.jdField_c_of_type_Long = paramChatMessage.uniseq;
      this.j = paramInt1;
      this.jdField_a_of_type_ComTencentWidgetListView.smoothScrollToPosition(this.jdField_a_of_type_ComTencentWidgetListView.getHeaderViewsCount() + paramInt1);
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForLightVideo = ((MessageForLightVideo)paramChatMessage);
      return true;
    }
    this.jdField_c_of_type_Long = 0L;
    this.j = 0;
    if ((paramXListView != null) && ((paramXListView.jdField_a_of_type_ComTencentMobileqqActivityAioItemLightVideoItemBuilder$ChatVideoView.getDrawable() instanceof URLDrawable)))
    {
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForLightVideo = ((MessageForLightVideo)paramChatMessage);
      a(paramXListView, (MessageForLightVideo)paramChatMessage, 1);
      b(true);
      a(paramAudioPlayerBase, paramXListView, 0);
      return true;
    }
    return false;
  }
  
  public bhjs[] a(View paramView)
  {
    bhjq localbhjq = new bhjq();
    paramView = (ahag)AIOUtils.getHolder(paramView);
    MessageForLightVideo localMessageForLightVideo = (MessageForLightVideo)paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
    if ((!TextUtils.isEmpty(localMessageForLightVideo.md5)) && (FileUtils.fileExistsAndNotEmpty(ShortVideoUtils.getShortVideoThumbPicPath(localMessageForLightVideo.thumbMD5, "jpg")))) {
      if ((paramView.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.c == null) || (paramView.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.c.getVisibility() != 0)) {
        break label125;
      }
    }
    label125:
    for (int m = 1;; m = 0)
    {
      if (m == 0) {
        a(localbhjq, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType, localMessageForLightVideo);
      }
      a(localbhjq, localMessageForLightVideo);
      super.c(localbhjq, this.jdField_a_of_type_AndroidContentContext);
      super.e(localbhjq, this.jdField_a_of_type_AndroidContentContext);
      return localbhjq.a();
    }
  }
  
  protected void b(ahag paramahag)
  {
    if (!paramahag.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.a(paramahag.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin + paramahag.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq))
    {
      paramahag.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setVisibility(8);
      return;
    }
    paramahag.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setAnimRunnableListener(new ahaf(this, paramahag));
  }
  
  void b(MessageForLightVideo paramMessageForLightVideo)
  {
    bcxr localbcxr = bcwz.a(2, 2);
    bcxb localbcxb = paramMessageForLightVideo.getDownloadInfo(localbcxr.b);
    localbcxb.i = ShortVideoUtils.getShortVideoThumbPicPath(paramMessageForLightVideo.thumbMD5, "jpg");
    localbcxb.a(paramMessageForLightVideo.istroop, 1);
    localbcxb.f = 2;
    localbcxb.g = 2;
    localbcxr.a(localbcxb);
    localbcxr.a(paramMessageForLightVideo);
    bcwz.a(localbcxr, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
  }
  
  void b(MessageForLightVideo paramMessageForLightVideo, ahag paramahag, int paramInt)
  {
    paramahag.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.b(paramMessageForLightVideo.frienduin + paramMessageForLightVideo.uniseq);
    paramahag.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setVisibility(0);
    paramahag.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setImageResource(2130849774);
    paramahag.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setDrawStatus(3);
    paramahag.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    paramahag.jdField_a_of_type_AndroidWidgetTextView.setText(paramInt);
    if (QLog.isColorLevel()) {
      QLog.w("LightVideoItemBuilder", 2, "[showWarnProgress] uinseq:" + paramMessageForLightVideo.uniseq);
    }
  }
  
  public boolean b(ChatMessage paramChatMessage)
  {
    return true;
  }
  
  public boolean c(ChatMessage paramChatMessage)
  {
    ChatMessage localChatMessage = MediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a();
    return ((localChatMessage == paramChatMessage) || (((localChatMessage instanceof MessageForLightVideo)) && (localChatMessage.uniseq == paramChatMessage.uniseq))) && (((MessageForLightVideo)paramChatMessage).videoStatus == 1);
  }
  
  public void d()
  {
    super.d();
  }
  
  protected boolean d(ChatMessage paramChatMessage)
  {
    return (paramChatMessage != null) && (((MessageForLightVideo)paramChatMessage).videoStatus == 2);
  }
  
  protected boolean e(ChatMessage paramChatMessage)
  {
    return (paramChatMessage.uniseq == this.jdField_c_of_type_Long) && (((MessageForLightVideo)paramChatMessage).isAllReady());
  }
  
  public void onClick(View paramView)
  {
    ahag localahag = (ahag)AIOUtils.getHolder(paramView);
    if (localahag == null) {}
    MessageForLightVideo localMessageForLightVideo;
    do
    {
      for (;;)
      {
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        localMessageForLightVideo = (MessageForLightVideo)localahag.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
        if (QLog.isColorLevel()) {
          QLog.d("LightVideoItemBuilder", 2, "onClick! uniseq:" + localMessageForLightVideo.uniseq);
        }
        if (paramView.getId() != 2131364567)
        {
          if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isVideoChatting()) {
            break;
          }
          QQToast.a(this.jdField_a_of_type_AndroidContentContext, 2131695634, 1).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299080));
        }
      }
      if ((paramView.getId() != 2131364522) && (paramView.getId() != 2131362433)) {
        break;
      }
    } while (localMessageForLightVideo.md5 == null);
    if (c(localMessageForLightVideo))
    {
      a(localahag, localMessageForLightVideo, 2);
      MediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(false);
    }
    for (;;)
    {
      super.onClick(paramView);
      break;
      String str = ShortVideoUtils.getShortVideoThumbPicPath(localMessageForLightVideo.thumbMD5, "jpg");
      if (!FileUtils.fileExistsAndNotEmpty(ShortVideoUtils.getShortVideoSavePath(localMessageForLightVideo, "mp4")))
      {
        a(localMessageForLightVideo, false);
        a(localMessageForLightVideo, localahag, localMessageForLightVideo.videoFileProgress, false);
        this.jdField_c_of_type_Long = localMessageForLightVideo.uniseq;
        this.j = 0;
      }
      else if (FileUtils.fileExistsAndNotEmpty(str))
      {
        bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800561C", "0X800561C", 0, 0, "", "", "", "");
        if (TVK_SDKMgr.isInstalled(this.jdField_a_of_type_AndroidContentContext))
        {
          if (!MediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(AIOUtils.getMessage(paramView))) {
            QQToast.a(this.jdField_a_of_type_AndroidContentContext, 1, 2131694934, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299080));
          }
        }
        else {
          QQToast.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131697478), 0).b(BaseApplicationImpl.getApplication().getResources().getDimensionPixelSize(2131299080));
        }
      }
    }
  }
  
  public void onStateChange(String paramString, QQLiveDrawable.QQLiveDrawableParams paramQQLiveDrawableParams, int paramInt, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LightVideoItemBuilder", 2, "onStateChange => " + QQLiveImage.getStateStr(paramInt) + ", msgUniseq=" + paramQQLiveDrawableParams.msgUniseq + ", extra = " + paramObject);
    }
    if (paramInt == 2)
    {
      paramString = bhbz.a().a(Long.valueOf(paramQQLiveDrawableParams.msgUniseq));
      if ((paramString != null) && (!bhbz.a().a(Long.valueOf(paramQQLiveDrawableParams.msgUniseq))))
      {
        ShortVideoUtils.reportVideoPlay(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "0X8008E51", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramString, this.jdField_a_of_type_AndroidContentContext);
        if (!bhbz.a().b(Long.valueOf(paramString.uniseq)))
        {
          bhbz.a().a(Long.valueOf(paramString.uniseq));
          ShortVideoUtils.reportVideoPlay(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "0X8008E50", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramString, this.jdField_a_of_type_AndroidContentContext);
        }
        bhbz.a().a(Long.valueOf(paramQQLiveDrawableParams.msgUniseq), true);
      }
    }
    paramObject = a(paramQQLiveDrawableParams.msgUniseq);
    if (paramObject == null)
    {
      if (QLog.isColorLevel()) {
        QLog.w("LightVideoItemBuilder", 2, "onStateChange msgUniseq=" + paramQQLiveDrawableParams.msgUniseq + " , holder is null ");
      }
      if ((paramInt == 6) && (this.jdField_a_of_type_ComTencentMobileqqDataMessageForLightVideo != null)) {}
    }
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
                for (paramString = this.jdField_a_of_type_ComTencentMobileqqDataMessageForLightVideo; paramInt == 5; paramString = (MessageForLightVideo)paramObject.jdField_a_of_type_ComTencentMobileqqDataChatMessage)
                {
                  paramObject.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setVisibility(0);
                  a(paramObject);
                  return;
                }
                if (paramInt != 2) {
                  break;
                }
                b(paramObject);
              } while (this.jdField_a_of_type_ComTencentMobileqqDataMessageForLightVideo == null);
              if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForLightVideo.mCurrQQLive != null) || (this.jdField_a_of_type_ComTencentMobileqqDataMessageForLightVideo.uniseq != paramQQLiveDrawableParams.msgUniseq)) {
                break;
              }
              paramString = (URLDrawable)paramObject.jdField_a_of_type_ComTencentMobileqqActivityAioItemLightVideoItemBuilder$ChatVideoView.getDrawable();
            } while ((paramString.getStatus() != 1) || (!(paramString.getCurrDrawable() instanceof QQLiveDrawable)));
            this.jdField_a_of_type_ComTencentMobileqqDataMessageForLightVideo.mCurrQQLive = ((QQLiveDrawable)paramString.getCurrDrawable());
          } while (!QLog.isColorLevel());
          QLog.w("LightVideoItemBuilder", 2, "success update currQQLive:" + this.jdField_a_of_type_ComTencentMobileqqDataMessageForLightVideo.mCurrQQLive + " ,uniseq:" + this.jdField_a_of_type_ComTencentMobileqqDataMessageForLightVideo.uniseq);
          return;
        } while (this.jdField_a_of_type_ComTencentMobileqqDataMessageForLightVideo.uniseq == paramQQLiveDrawableParams.msgUniseq);
        paramString = (URLDrawable)paramObject.jdField_a_of_type_ComTencentMobileqqActivityAioItemLightVideoItemBuilder$ChatVideoView.getDrawable();
      } while ((paramString.getStatus() != 1) || (!(paramString.getCurrDrawable() instanceof QQLiveDrawable)));
      ((QQLiveDrawable)paramString.getCurrDrawable()).pause();
      return;
    } while ((paramInt == 4) || (paramInt != 6) || (!c(paramString)) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayerBase == null));
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayerBase.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.LightVideoItemBuilder
 * JD-Core Version:    0.7.0.1
 */