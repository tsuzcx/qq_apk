package com.tencent.mobileqq.activity.aio.item;

import aean;
import agej;
import aggk;
import aggl;
import agif;
import agjg;
import agjk;
import ahkz;
import ahla;
import ahlb;
import ahlc;
import ahld;
import ahnz;
import ahov;
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
import anzj;
import ascz;
import awli;
import awlj;
import bboj;
import bcrn;
import bcwu;
import bcww;
import bcwx;
import bcxf;
import bcxn;
import bcyh;
import bdll;
import berp;
import bete;
import beyb;
import beyq;
import bhjz;
import bhmi;
import bhuk;
import bhum;
import blir;
import blji;
import bmko;
import bmky;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.image.QQLiveDrawable;
import com.tencent.image.QQLiveDrawable.OnStateListener;
import com.tencent.image.QQLiveDrawable.QQLiveDrawableParams;
import com.tencent.image.QQLiveImage;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.imcore.message.QQMessageFacade;
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
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
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
import yup;

public class LightVideoItemBuilder
  extends ahov
  implements agif, agjg, awlj, bcww, QQLiveDrawable.OnStateListener
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
    g = Math.min(agej.a(320.0F, localResources), g);
    h = agej.a(100.0F, localResources);
    i = agej.a(100.0F, localResources);
    e = agej.a(160.0F, localResources);
    f = agej.a(160.0F, localResources);
    jdField_a_of_type_AndroidGraphicsDrawableColorDrawable = new ascz(-10065297, e, f);
    jdField_c_of_type_Int = agej.a(8.0F, localResources);
    d = agej.a(3.0F, localResources);
  }
  
  public LightVideoItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    if (paramAIOAnimationConatiner != null) {
      this.jdField_a_of_type_ComTencentWidgetListView = paramAIOAnimationConatiner.a();
    }
    awli.a().a(this);
  }
  
  private void a(int paramInt, ahld paramahld, MessageForLightVideo paramMessageForLightVideo)
  {
    LightVideoItemBuilder.ChatVideoView localChatVideoView = paramahld.jdField_a_of_type_ComTencentMobileqqActivityAioItemLightVideoItemBuilder$ChatVideoView;
    switch (paramInt)
    {
    default: 
      return;
    case 2001: 
      a(paramMessageForLightVideo, "THUMB STATUS_RECV_START");
      return;
    case 2003: 
      a(paramMessageForLightVideo, "THUMB STATUS_RECV_FINISHED");
      b(paramahld, paramMessageForLightVideo, localChatVideoView);
      return;
    case 5002: 
      a(paramMessageForLightVideo, "THUMB STATUS_FILE_EXPIRED");
    }
    a(paramMessageForLightVideo, "THUMB STATUS_RECV_ERROR");
    String str = ShortVideoUtils.a(paramMessageForLightVideo, "mp4");
    if (bhmi.b(str)) {
      if (localChatVideoView.a(str))
      {
        a(paramMessageForLightVideo, anzj.a(2131704951) + str);
        if (ShortVideoUtils.a())
        {
          paramMessageForLightVideo = awli.a(str, ShortVideoUtils.a(paramMessageForLightVideo.thumbMD5, "jpg"), paramMessageForLightVideo.uniseq, this.k, this.l, false, true, false, 0, this, null);
          paramahld.jdField_a_of_type_ComTencentMobileqqActivityAioItemLightVideoItemBuilder$ChatVideoView.setURLDrawable(paramMessageForLightVideo);
          b(paramahld);
        }
      }
    }
    for (;;)
    {
      a(paramahld);
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
  
  private void a(ahld paramahld, MessageForLightVideo paramMessageForLightVideo, LightVideoItemBuilder.ChatVideoView paramChatVideoView)
  {
    if (c(paramMessageForLightVideo))
    {
      a(paramahld, false, false, 0, false, false);
      a(paramahld, paramMessageForLightVideo, 1);
    }
    do
    {
      return;
      if (d(paramMessageForLightVideo))
      {
        paramChatVideoView = ShortVideoUtils.a(paramMessageForLightVideo.thumbMD5, "jpg");
        a(paramahld.jdField_a_of_type_ComTencentMobileqqActivityAioItemLightVideoItemBuilder$ChatVideoView, paramChatVideoView, this.l, this.k);
        a(paramahld, paramMessageForLightVideo, 2);
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
        a(this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayerBase, paramahld, 0);
        a(paramahld, paramMessageForLightVideo, 1);
        this.j = 0;
        this.jdField_c_of_type_Long = 0L;
        return;
      }
    } while (MediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(paramMessageForLightVideo));
    QQToast.a(this.jdField_a_of_type_AndroidContentContext, 1, 2131694615, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299011));
    return;
    if (a(paramahld, paramMessageForLightVideo, paramChatVideoView))
    {
      a(paramahld, paramMessageForLightVideo, 3);
      return;
    }
    a(paramahld, paramMessageForLightVideo, 0);
  }
  
  private void a(ahld paramahld, boolean paramBoolean1, boolean paramBoolean2, int paramInt, boolean paramBoolean3, boolean paramBoolean4)
  {
    if (paramahld != null)
    {
      Object localObject1 = (MessageForLightVideo)paramahld.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
      String str1 = ShortVideoUtils.a(((MessageForLightVideo)localObject1).thumbMD5, "jpg");
      String str2 = ShortVideoUtils.a((MessageForShortVideo)localObject1, "mp4");
      if ((this.k == 0) || (this.l == 0))
      {
        localObject2 = BaseApplicationImpl.getContext().getResources();
        this.k = agej.a(160.0F, (Resources)localObject2);
        this.l = agej.a(160.0F, (Resources)localObject2);
        if (QLog.isColorLevel()) {
          QLog.d("LightVideoItemBuilder", 2, "getURLDrawableByMsg w:" + this.k + " ,h:" + this.l + " ,uniseq:" + ((MessageForLightVideo)localObject1).uniseq);
        }
      }
      if ((this.jdField_a_of_type_ComTencentImageURLDrawable == null) || (!this.jdField_a_of_type_ComTencentImageURLDrawable.getURL().getPath().equals(str1))) {
        this.jdField_a_of_type_ComTencentImageURLDrawable = awli.a(str1, this.k, this.l);
      }
      Object localObject2 = awli.a(str2, str1, ((MessageForLightVideo)localObject1).uniseq, this.k, this.l, paramBoolean1, paramBoolean2, paramBoolean4, paramInt, this, this.jdField_a_of_type_ComTencentImageURLDrawable);
      paramahld.jdField_a_of_type_ComTencentMobileqqActivityAioItemLightVideoItemBuilder$ChatVideoView.setURLDrawable((URLDrawable)localObject2);
      if (paramBoolean3)
      {
        localObject2 = (URLDrawable)paramahld.jdField_a_of_type_ComTencentMobileqqActivityAioItemLightVideoItemBuilder$ChatVideoView.getDrawable();
        if ((((URLDrawable)localObject2).getStatus() == 1) && ((((URLDrawable)localObject2).getCurrDrawable() instanceof QQLiveDrawable)))
        {
          ((QQLiveDrawable)((URLDrawable)localObject2).getCurrDrawable()).release();
          localObject1 = awli.a(str2, str1, ((MessageForLightVideo)localObject1).uniseq, this.k, this.l, paramBoolean1, paramBoolean2, paramBoolean4, paramInt, this, this.jdField_a_of_type_ComTencentImageURLDrawable);
          paramahld.jdField_a_of_type_ComTencentMobileqqActivityAioItemLightVideoItemBuilder$ChatVideoView.setURLDrawable((URLDrawable)localObject1);
          if (QLog.isColorLevel()) {
            QLog.d("LightVideoItemBuilder", 2, "refreshVideo needRelease uniseq:" + paramahld.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
          }
        }
      }
    }
  }
  
  private void a(AudioPlayerBase paramAudioPlayerBase, ahld paramahld, int paramInt)
  {
    if ((paramahld == null) || (paramAudioPlayerBase == null)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("LightVideoItemBuilder", 2, "refreshVideoWithEarModeJudge! uniseq:" + paramahld.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq + " ,loudSpeaker:" + awli.a + " ,position:" + paramInt);
    }
    try
    {
      paramAudioPlayerBase.f();
      if (awli.a)
      {
        if (paramAudioPlayerBase.a()) {
          paramAudioPlayerBase.c();
        }
        a(paramahld, false, false, paramInt, true, false);
        return;
      }
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        localIOException.printStackTrace();
      }
      a(paramahld, false, true, paramInt, true, false);
      paramAudioPlayerBase.b(ShortVideoUtils.a((MessageForShortVideo)paramahld.jdField_a_of_type_ComTencentMobileqqDataChatMessage, "mp4"), paramInt + 1000);
    }
  }
  
  private void a(LightVideoItemBuilder.ChatVideoView paramChatVideoView, String paramString, int paramInt1, int paramInt2)
  {
    if (paramChatVideoView.a(paramString)) {
      paramChatVideoView.setURLDrawable(awli.a(paramString, paramInt2, paramInt1));
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
  
  private boolean a(MessageForLightVideo paramMessageForLightVideo, ahld paramahld)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LightVideoItemBuilder", 2, "startUploadVideo! uniseq:" + paramMessageForLightVideo.uniseq);
    }
    String str1 = paramMessageForLightVideo.videoFileName;
    String str2 = ShortVideoUtils.a(paramMessageForLightVideo.thumbMD5, "jpg");
    if (!bhmi.b(str1))
    {
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, 1, 2131718240, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299011));
      paramMessageForLightVideo.videoFileStatus = 1005;
      return false;
    }
    if (!bhmi.b(str2))
    {
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, 1, 2131718241, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299011));
      paramahld.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
      paramMessageForLightVideo.videoFileStatus = 1005;
      return false;
    }
    paramMessageForLightVideo.mThumbFilePath = str2;
    paramahld = bboj.a(paramMessageForLightVideo);
    paramahld.i = paramMessageForLightVideo.videoFileName;
    paramahld.f = paramMessageForLightVideo.mLocalMd5;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramahld);
    return true;
  }
  
  private void b(int paramInt, ahld paramahld, MessageForLightVideo paramMessageForLightVideo)
  {
    LightVideoItemBuilder.ChatVideoView localChatVideoView = paramahld.jdField_a_of_type_ComTencentMobileqqActivityAioItemLightVideoItemBuilder$ChatVideoView;
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
      a(paramMessageForLightVideo, paramahld, paramMessageForLightVideo.videoFileProgress, true);
    }
    paramahld.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(false, this);
    return;
    String str = ShortVideoUtils.a(paramMessageForLightVideo, "mp4");
    boolean bool = bhmi.b(str);
    a(paramMessageForLightVideo, "VIDEO STATUS_SEND_FINISHED ,videofile:" + str + " ,videoexist:" + bool);
    if (bool)
    {
      a(paramahld, paramMessageForLightVideo, localChatVideoView);
      a(paramMessageForLightVideo, paramahld, 100, true);
    }
    c(paramMessageForLightVideo);
    return;
    a(paramMessageForLightVideo, "VIDEO STATUS_SEND_ERROR");
    c(paramMessageForLightVideo);
    b(paramMessageForLightVideo, paramahld, 2131717508);
    a(paramahld);
    paramahld.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
    return;
    a(paramMessageForLightVideo, "VIDEO STATUS_SEND_CANCEL");
    c(paramMessageForLightVideo);
    a(paramahld);
    return;
    paramInt = paramMessageForLightVideo.videoFileProgress;
    a(paramMessageForLightVideo, "VIDEO STATUS_SEND_PROCESS " + paramInt);
    a(paramMessageForLightVideo, paramahld, paramInt);
    return;
    a(paramMessageForLightVideo, "VIDEO STATUS_RECV_START");
    a(paramMessageForLightVideo, paramahld, paramMessageForLightVideo.videoFileProgress, true);
    return;
    a(paramMessageForLightVideo, "VIDEO STATUS_RECV_FINISHED");
    a(paramahld, paramMessageForLightVideo, localChatVideoView);
    a(paramMessageForLightVideo, paramahld, 100, true);
    b(paramahld);
    return;
    a(paramMessageForLightVideo, "VIDEO STATUS_FILE_UNSAFE");
    b(paramMessageForLightVideo, paramahld, 2131717502);
    if (paramMessageForLightVideo.uiOperatorFlag == 2)
    {
      paramahld.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, 2131718209, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299011));
      return;
    }
    QQToast.a(this.jdField_a_of_type_AndroidContentContext, 2131718233, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299011));
    return;
    a(paramMessageForLightVideo, "VIDEO STATUS_RECV_ERROR");
    a(paramahld);
    a(paramMessageForLightVideo, paramahld);
    QQToast.a(this.jdField_a_of_type_AndroidContentContext, 2131718235, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299011));
    return;
    a(paramMessageForLightVideo, "VIDEO STATUS_FILE_EXPIRED");
    str = ShortVideoUtils.a(paramMessageForLightVideo.thumbMD5, "jpg");
    if (bhmi.b(str)) {
      a(localChatVideoView, str, n, m);
    }
    b(paramMessageForLightVideo, paramahld, 2131717503);
    return;
    a(paramMessageForLightVideo, "VIDEO STATUS_RECV_CANCEL");
    return;
    paramInt = paramMessageForLightVideo.videoFileProgress;
    a(paramMessageForLightVideo, "VIDEO STATUS_RECV_PROCESS " + paramInt);
    a(paramMessageForLightVideo, paramahld, paramInt, true);
  }
  
  private void b(ahld paramahld, MessageForLightVideo paramMessageForLightVideo, LightVideoItemBuilder.ChatVideoView paramChatVideoView)
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
      i1 = agej.a(m, (Resources)localObject);
      i2 = agej.a(n, (Resources)localObject);
      localObject = ShortVideoUtils.a(paramMessageForLightVideo.thumbMD5, "jpg");
      str = ShortVideoUtils.a(paramMessageForLightVideo, "mp4");
      if ((!bhmi.b(str)) || (!bcyh.b)) {
        break label173;
      }
      a(paramMessageForLightVideo, anzj.a(2131704961) + (String)localObject);
      if (ShortVideoUtils.a())
      {
        paramMessageForLightVideo = awli.a(str, (String)localObject, paramMessageForLightVideo.uniseq, m, n, false, true, false, 0, this, null);
        paramahld.jdField_a_of_type_ComTencentMobileqqActivityAioItemLightVideoItemBuilder$ChatVideoView.setURLDrawable(paramMessageForLightVideo);
        b(paramahld);
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
      if (!bhmi.b((String)localObject)) {
        break label328;
      }
    } while (!paramChatVideoView.a((String)localObject));
    a(paramMessageForLightVideo, anzj.a(2131704965) + (String)localObject);
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mRequestWidth = i1;
    localURLDrawableOptions.mRequestHeight = i2;
    localURLDrawableOptions.mLoadingDrawable = jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
    localURLDrawableOptions.mFailedDrawable = jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
    paramChatVideoView.setURLDrawable(URLDrawable.getDrawable(new File((String)localObject), localURLDrawableOptions));
    if (!bhmi.b(str))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramMessageForLightVideo, true))
      {
        a(paramMessageForLightVideo, true);
        return;
      }
      a(paramMessageForLightVideo, paramahld);
      return;
    }
    if (ShortVideoUtils.a())
    {
      a(paramahld);
      return;
    }
    a(paramMessageForLightVideo, paramahld);
    return;
    label328:
    paramChatVideoView.setImageDrawable(beyq.a());
  }
  
  private void b(boolean paramBoolean)
  {
    Iterator localIterator = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int).iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (ChatMessage)localIterator.next();
      if (((localObject instanceof MessageForLightVideo)) && (((MessageForLightVideo)localObject).videoStatus == 3))
      {
        localObject = a(((ChatMessage)localObject).uniseq);
        if ((localObject != null) && (((ahld)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioItemLightVideoItemBuilder$ChatVideoView != null) && (((ahld)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioItemLightVideoItemBuilder$ChatVideoView.b != null) && (((ahld)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioItemLightVideoItemBuilder$ChatVideoView.b.getStatus() == 1) && ((((ahld)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioItemLightVideoItemBuilder$ChatVideoView.b.getCurrDrawable() instanceof QQLiveDrawable))) {
          if (paramBoolean) {
            ((QQLiveDrawable)((ahld)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioItemLightVideoItemBuilder$ChatVideoView.b.getCurrDrawable()).pause();
          } else {
            ((QQLiveDrawable)((ahld)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioItemLightVideoItemBuilder$ChatVideoView.b.getCurrDrawable()).resume();
          }
        }
      }
    }
  }
  
  private boolean b(ahld paramahld, MessageForLightVideo paramMessageForLightVideo, LightVideoItemBuilder.ChatVideoView paramChatVideoView)
  {
    if ((TextUtils.isEmpty(paramMessageForLightVideo.md5)) && (paramMessageForLightVideo.videoFileStatus != 1005) && (paramMessageForLightVideo.extraflag != 32768))
    {
      if (paramMessageForLightVideo.isSendFromLocal())
      {
        Object localObject2 = paramMessageForLightVideo.mThumbFilePath;
        Object localObject1 = localObject2;
        if (!bhmi.b((String)localObject2))
        {
          if (TextUtils.isEmpty(paramMessageForLightVideo.thumbMD5))
          {
            paramChatVideoView.setImageDrawable(beyq.a());
            a(paramahld);
            a(paramMessageForLightVideo, "getBubbleView():You must get thumb before send video.");
            return true;
          }
          localObject1 = ShortVideoUtils.a(paramMessageForLightVideo.thumbMD5, "jpg");
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
            a(paramMessageForLightVideo, paramahld, paramMessageForLightVideo.videoFileProgress, true);
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
  
  public aggk a(View paramView)
  {
    if ((paramView != null) && (paramView.getParent() != null))
    {
      paramView = (ahld)((View)paramView.getParent()).getTag();
      if (paramView != null) {
        return paramView.jdField_a_of_type_ComTencentMobileqqActivityAioItemLightVideoItemBuilder$ChatVideoView;
      }
    }
    return null;
  }
  
  public aggl a()
  {
    return new ahld(this);
  }
  
  public ahld a(long paramLong)
  {
    if ((this.jdField_a_of_type_ComTencentWidgetListView != null) && (paramLong > 0L))
    {
      int m = agej.a(paramLong, this.jdField_a_of_type_ComTencentWidgetListView.getAdapter());
      int n = this.jdField_a_of_type_ComTencentWidgetListView.getHeaderViewsCount();
      int i1 = this.jdField_a_of_type_ComTencentWidgetListView.getFirstVisiblePosition();
      int i2 = this.jdField_a_of_type_ComTencentWidgetListView.getLastVisiblePosition();
      if (m <= -1) {
        break label223;
      }
      Object localObject = agej.a(this.jdField_a_of_type_ComTencentWidgetListView, m);
      if (localObject != null)
      {
        localObject = agej.a((View)localObject);
        if ((localObject != null) && ((localObject instanceof ahld))) {
          return (ahld)localObject;
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
  
  public View a(int paramInt1, int paramInt2, ChatMessage paramChatMessage, View paramView, ViewGroup paramViewGroup, agjk paramagjk)
  {
    paramViewGroup = super.a(paramInt1, paramInt2, paramChatMessage, paramView, paramViewGroup, paramagjk);
    a(paramChatMessage, paramView, this);
    return paramViewGroup;
  }
  
  public View a(ChatMessage paramChatMessage, aggl paramaggl, View paramView, BaseChatItemLayout paramBaseChatItemLayout, agjk paramagjk)
  {
    paramBaseChatItemLayout = (ahld)paramaggl;
    Object localObject2 = this.jdField_a_of_type_AndroidContentContext;
    Resources localResources = ((Context)localObject2).getResources();
    MessageForLightVideo localMessageForLightVideo = (MessageForLightVideo)paramChatMessage;
    paramaggl = paramView;
    if (paramView == null)
    {
      paramaggl = new RelativeLayout((Context)localObject2);
      paramView = new LightVideoItemBuilder.ChatVideoView((Context)localObject2);
      paramView.setId(2131372628);
      paramView.setScaleType(ImageView.ScaleType.CENTER_CROP);
      paramView.setRadius(15.0F);
      paramView.d(false);
      paramView.setSharpCornerCor(BubbleImageView.a);
      paramView.setContentDescription(anzj.a(2131704947));
      paramaggl.addView(paramView);
      MessageProgressView localMessageProgressView = new MessageProgressView((Context)localObject2);
      paramaggl.addView(localMessageProgressView);
      Object localObject3 = new LinearLayout((Context)localObject2);
      ((LinearLayout)localObject3).setOrientation(1);
      ((LinearLayout)localObject3).setGravity(17);
      Object localObject1 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject1).addRule(13);
      paramaggl.addView((View)localObject3, (ViewGroup.LayoutParams)localObject1);
      localObject1 = new TextView((Context)localObject2);
      Object localObject4 = new LinearLayout.LayoutParams(-2, -2);
      ((LinearLayout.LayoutParams)localObject4).topMargin = agej.a(70.0F, localResources);
      ((TextView)localObject1).setTextColor(-1);
      ((TextView)localObject1).setTextSize(2, 12.0F);
      ((TextView)localObject1).setId(2131364464);
      ((LinearLayout)localObject3).addView((View)localObject1, (ViewGroup.LayoutParams)localObject4);
      localObject2 = new LinearLayout((Context)localObject2);
      ((LinearLayout)localObject2).setOrientation(0);
      ((LinearLayout)localObject2).setGravity(16);
      ((LinearLayout)localObject2).setBackgroundResource(2130838085);
      ((LinearLayout)localObject2).setId(2131362423);
      ((LinearLayout)localObject2).setOnClickListener(new ahkz(this));
      localObject3 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject3).addRule(8, 2131372628);
      ((RelativeLayout.LayoutParams)localObject3).bottomMargin = jdField_c_of_type_Int;
      ((RelativeLayout.LayoutParams)localObject3).addRule(5, 2131372628);
      ((RelativeLayout.LayoutParams)localObject3).leftMargin = jdField_c_of_type_Int;
      paramaggl.addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
      localObject3 = new ImageView(this.jdField_a_of_type_AndroidContentContext);
      ((ImageView)localObject3).setId(2131374265);
      ((ImageView)localObject3).setPadding(jdField_c_of_type_Int, d, d, d);
      ((LinearLayout)localObject2).addView((View)localObject3);
      localObject4 = new TextView(this.jdField_a_of_type_AndroidContentContext);
      ((TextView)localObject4).setId(2131374270);
      ((TextView)localObject4).setTextColor(-1);
      ((TextView)localObject4).setPadding(0, d, jdField_c_of_type_Int, d);
      ((LinearLayout)localObject2).addView((View)localObject4);
      paramaggl.setOnClickListener(this);
      paramaggl.setOnTouchListener(paramagjk);
      paramaggl.setOnLongClickListener(paramagjk);
      paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqActivityAioItemLightVideoItemBuilder$ChatVideoView = paramView;
      paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView = localMessageProgressView;
      paramBaseChatItemLayout.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localObject1);
      paramBaseChatItemLayout.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localObject3);
      paramBaseChatItemLayout.b = ((TextView)localObject4);
    }
    paramView = paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqActivityAioItemLightVideoItemBuilder$ChatVideoView;
    if (AppSetting.c)
    {
      paramagjk = new StringBuilder();
      paramagjk.append("轻量短视频 ");
      paramagjk.append(localMessageForLightVideo.videoFileTime);
      paramagjk.append("秒");
      if ((!localMessageForLightVideo.isSend()) && (!localMessageForLightVideo.isLightVideoRead)) {
        paramagjk.append(" 未播放");
      }
      paramView.setContentDescription(paramagjk.toString());
    }
    paramView.d = localMessageForLightVideo.isSend();
    paramView.setTag(Long.valueOf(localMessageForLightVideo.uniseq));
    bhjz.a().a(Long.valueOf(localMessageForLightVideo.uniseq), localMessageForLightVideo);
    paramBaseChatItemLayout.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setRadius(15.0F, true);
    paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setShowCorner(false);
    paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setSharpCornerCor(BubbleImageView.a);
    paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setCornerDirection(localMessageForLightVideo.isSend());
    paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.a(paramChatMessage.frienduin + paramChatMessage.uniseq);
    this.k = agej.a(160.0F, localResources);
    this.l = agej.a(160.0F, localResources);
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
      return paramaggl;
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
    return anzj.a(2131704970);
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
    awli.a().a(null);
    this.jdField_a_of_type_ComTencentImageURLDrawable = null;
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    MessageForLightVideo localMessageForLightVideo;
    if ((paramChatMessage != null) && ((paramChatMessage instanceof MessageForLightVideo)))
    {
      localMessageForLightVideo = (MessageForLightVideo)paramChatMessage;
      if (paramInt == 2131365352)
      {
        aean.b(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localMessageForLightVideo);
        yup.a("story_grp", "press_msg", 0, 0, new String[] { "4", "", "", "" });
      }
    }
    else
    {
      return;
    }
    if (paramInt == 2131371530)
    {
      super.d(paramChatMessage);
      yup.a("story_grp", "press_msg", 0, 0, new String[] { "5", "", "", "" });
      return;
    }
    if (paramInt == 2131366320)
    {
      bmko.a(localMessageForLightVideo).b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage).a((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
      bmky.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 6, 5);
      bmky.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 3, 0, paramChatMessage.istroop);
      yup.a("story_grp", "press_msg", 0, 0, new String[] { "2", "", "", "" });
      return;
    }
    if (paramInt == 2131371487)
    {
      if (c(paramChatMessage)) {
        MediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(true);
      }
      super.a(localMessageForLightVideo);
      yup.a("story_grp", "press_msg", 0, 0, new String[] { "3", "", "", "" });
      return;
    }
    if (paramInt == 2131365312)
    {
      paramContext = new StringBuilder();
      paramContext.append("uniseq:").append(localMessageForLightVideo.uniseq).append("\n");
      Toast.makeText(this.jdField_a_of_type_AndroidContentContext, paramContext.toString(), 1).show();
      return;
    }
    super.a(paramInt, paramContext, paramChatMessage);
  }
  
  protected void a(ahld paramahld)
  {
    if (!paramahld.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.a(paramahld.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin + paramahld.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq)) {
      paramahld.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setVisibility(8);
    }
    for (;;)
    {
      paramahld.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      if (QLog.isColorLevel()) {
        QLog.w("LightVideoItemBuilder", 2, "[hideProgress] set ProgressPieDrawable visible");
      }
      return;
      paramahld.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setAnimRunnableListener(new ahlb(this, paramahld));
    }
  }
  
  protected void a(ahld paramahld, MessageForLightVideo paramMessageForLightVideo, int paramInt)
  {
    if (paramahld == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("LightVideoItemBuilder", 2, String.format("handleVideoViewAnimStatus uniseq:%d, status:%d", new Object[] { Long.valueOf(paramMessageForLightVideo.uniseq), Integer.valueOf(paramInt) }));
    }
    paramahld.b.setText(ahnz.a(paramMessageForLightVideo.videoFileTime));
    paramahld.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setUnread(false, null, null);
    paramMessageForLightVideo.videoStatus = paramInt;
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      if ((!paramMessageForLightVideo.isSend()) && (!paramMessageForLightVideo.isLightVideoRead)) {
        paramahld.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setUnread(true, null, null);
      }
      paramahld.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130840487);
      return;
    case 1: 
      a(paramMessageForLightVideo);
      paramMessageForLightVideo = (AnimationDrawable)this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130772070);
      paramahld.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramMessageForLightVideo);
      paramMessageForLightVideo.start();
      return;
    case 2: 
      paramahld.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130840484);
      return;
    }
    if ((!paramMessageForLightVideo.isSend()) && (!paramMessageForLightVideo.isLightVideoRead)) {
      paramahld.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setUnread(true, null, null);
    }
    paramahld.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130840484);
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    paramView = (ahld)agej.a(paramView);
    MessageForLightVideo localMessageForLightVideo = (MessageForLightVideo)paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
    if (!localMessageForLightVideo.isSendFromLocal()) {
      return;
    }
    blir localblir = (blir)blji.a(this.jdField_a_of_type_AndroidContentContext, null);
    localblir.a(2131689933, 5);
    localblir.c(2131690580);
    localblir.a(new ahla(this, localMessageForLightVideo, paramView, localblir));
    localblir.show();
  }
  
  public void a(View paramView, bete parambete, int paramInt1, int paramInt2)
  {
    paramView = (ahld)agej.a(paramView);
    MessageForLightVideo localMessageForLightVideo = (MessageForLightVideo)paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
    if (localMessageForLightVideo.uniseq != parambete.jdField_b_of_type_Long) {}
    do
    {
      do
      {
        return;
      } while (this.jdField_a_of_type_AndroidContentContext == null);
      if ((parambete.jdField_b_of_type_Int == 327689) || (parambete.jdField_b_of_type_Int == 6) || (parambete.jdField_b_of_type_Int == 17) || (parambete.jdField_b_of_type_Int == 9))
      {
        b(parambete.d, paramView, localMessageForLightVideo);
        return;
      }
    } while ((parambete.jdField_b_of_type_Int != 7) && (parambete.jdField_b_of_type_Int != 18) && (parambete.jdField_b_of_type_Int != 16));
    a(parambete.d, paramView, localMessageForLightVideo);
  }
  
  public void a(View paramView, ChatMessage paramChatMessage)
  {
    int m = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131296338);
    if (paramChatMessage.isSend())
    {
      paramView.setPadding(BaseChatItemLayout.k, BaseChatItemLayout.h, m, BaseChatItemLayout.i);
      return;
    }
    paramView.setPadding(m, BaseChatItemLayout.h, BaseChatItemLayout.k, BaseChatItemLayout.i);
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
  
  void a(MessageForLightVideo paramMessageForLightVideo, ahld paramahld)
  {
    paramahld.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.b(paramMessageForLightVideo.frienduin + paramMessageForLightVideo.uniseq);
    paramahld.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setDrawStatus(2);
    paramahld.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setVisibility(0);
    paramahld.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    if (QLog.isColorLevel()) {
      QLog.w("LightVideoItemBuilder", 2, "[showPauseProgress] uinseq:" + paramMessageForLightVideo.uniseq);
    }
  }
  
  void a(MessageForLightVideo paramMessageForLightVideo, ahld paramahld, int paramInt)
  {
    int m = ShortVideoUtils.a(paramInt, 10);
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
    a(paramMessageForLightVideo, paramahld, paramInt, true);
  }
  
  protected void a(MessageForLightVideo paramMessageForLightVideo, ahld paramahld, int paramInt, boolean paramBoolean)
  {
    paramahld.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setDrawStatus(1);
    paramahld.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setAnimProgress(paramInt, paramMessageForLightVideo.frienduin + paramMessageForLightVideo.uniseq);
    paramahld.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setVisibility(0);
    paramahld.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    if (QLog.isColorLevel()) {
      QLog.w("LightVideoItemBuilder", 2, "[setProgress] uinseq:" + paramMessageForLightVideo.uniseq + ", p:" + paramInt);
    }
  }
  
  void a(MessageForLightVideo paramMessageForLightVideo, boolean paramBoolean)
  {
    if (paramMessageForLightVideo.videoFileStatus == 5002)
    {
      a(paramMessageForLightVideo, anzj.a(2131704968));
      return;
    }
    bcxn localbcxn = bcwu.a(2, 2);
    bcwx localbcwx = paramMessageForLightVideo.getDownloadInfo(localbcxn.jdField_b_of_type_Int);
    localbcwx.h = ShortVideoUtils.a(paramMessageForLightVideo, "mp4");
    localbcwx.a(paramMessageForLightVideo.istroop, 0);
    if (paramBoolean) {}
    for (int m = 2;; m = 1)
    {
      localbcwx.f = m;
      localbcwx.g = 2;
      if (QLog.isColorLevel()) {
        QLog.d("LightVideoItemBuilder", 2, " startDownloadVideo downloadvideo fileType==" + localbcwx.e + ", uniseq:" + paramMessageForLightVideo.uniseq);
      }
      localbcxn.a(localbcwx);
      localbcxn.a(paramMessageForLightVideo);
      bcwu.a(localbcxn, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
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
    paramXListView = (ahld)agej.a(paramView);
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
        a(paramView, ShortVideoUtils.a(paramChatMessage.thumbMD5, "jpg"), agej.a(160.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), agej.a(160.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
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
    ahld localahld;
    if ((localChatMessage != null) && ((localChatMessage instanceof MessageForLightVideo)))
    {
      localahld = a(localChatMessage.uniseq);
      if (localahld != null) {
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
      } while ((localahld.jdField_a_of_type_ComTencentMobileqqActivityAioItemLightVideoItemBuilder$ChatVideoView == null) || (localahld.jdField_a_of_type_ComTencentMobileqqActivityAioItemLightVideoItemBuilder$ChatVideoView.b == null) || (localahld.jdField_a_of_type_ComTencentMobileqqActivityAioItemLightVideoItemBuilder$ChatVideoView.b.getStatus() != 1) || (!(localahld.jdField_a_of_type_ComTencentMobileqqActivityAioItemLightVideoItemBuilder$ChatVideoView.b.getCurrDrawable() instanceof QQLiveDrawable)));
      m = (int)((QQLiveDrawable)localahld.jdField_a_of_type_ComTencentMobileqqActivityAioItemLightVideoItemBuilder$ChatVideoView.b.getCurrDrawable()).getCurrentPosition();
      a(this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayerBase, localahld, m - 1000);
    } while (!QLog.isColorLevel());
    QLog.d("LightVideoItemBuilder", 2, String.format("onNearToEar usingLoudSpeaker:%s, position:%d, duration:%d, uniseq:%d", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(m), Integer.valueOf(((MessageForShortVideo)localahld.jdField_a_of_type_ComTencentMobileqqDataChatMessage).videoFileTime), Long.valueOf(localahld.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq) }));
  }
  
  protected boolean a(ahld paramahld, MessageForLightVideo paramMessageForLightVideo, LightVideoItemBuilder.ChatVideoView paramChatVideoView)
  {
    boolean bool2 = false;
    if (b(paramahld, paramMessageForLightVideo, paramChatVideoView))
    {
      bool2 = false;
      return bool2;
    }
    String str1 = ShortVideoUtils.a(paramMessageForLightVideo.thumbMD5, "jpg");
    String str2 = ShortVideoUtils.a(paramMessageForLightVideo, "mp4");
    boolean bool4 = bhmi.b(str1);
    boolean bool1 = bhmi.b(str2);
    if (QLog.isColorLevel()) {
      QLog.d("LightVideoItemBuilder", 2, String.format("handleVideoFileStatus uniseq:%d, thumb:%s, videofile:%s", new Object[] { Long.valueOf(paramMessageForLightVideo.uniseq), Boolean.valueOf(bool4), Boolean.valueOf(bool1) }));
    }
    if (bool1)
    {
      paramahld.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setVisibility(8);
      if ((!paramMessageForLightVideo.isSendFromLocal()) || (paramMessageForLightVideo.isStatusReady())) {
        if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForLightVideo != null) && (this.jdField_a_of_type_ComTencentMobileqqDataMessageForLightVideo.videoStatus == 1))
        {
          bool2 = true;
          label149:
          a(paramahld, true, true, 0, false, bool2);
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
        a(paramMessageForLightVideo, paramahld);
      }
      if (paramMessageForLightVideo.videoFileStatus == 5002)
      {
        a(paramMessageForLightVideo, anzj.a(2131704974));
        b(paramMessageForLightVideo, paramahld, 2131717503);
        return false;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramMessageForLightVideo, true))
      {
        a(paramMessageForLightVideo, true);
        return false;
      }
      if ((paramMessageForLightVideo.videoFileStatus == 2001) || (paramMessageForLightVideo.videoFileStatus == 2002) || (paramMessageForLightVideo.videoFileStatus == 2000))
      {
        a(paramMessageForLightVideo, paramahld, paramMessageForLightVideo.videoFileProgress, false);
        return false;
      }
      a(paramMessageForLightVideo, paramahld);
      return true;
    }
    if (paramMessageForLightVideo.videoFileStatus == 5002)
    {
      a(paramMessageForLightVideo, anzj.a(2131704948));
      paramChatVideoView.setImageDrawable(jdField_a_of_type_AndroidGraphicsDrawableColorDrawable);
      b(paramMessageForLightVideo, paramahld, 2131717503);
      return false;
    }
    a(paramMessageForLightVideo, anzj.a(2131704954));
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
      paramBaseChatItemLayout = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramChatMessage.frienduin, paramChatMessage.uniseq);
      if ((paramBaseChatItemLayout instanceof berp))
      {
        if (((berp)paramBaseChatItemLayout).c() == 1005L) {}
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
    paramXListView = (ahld)agej.a(paramView);
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
  
  public bhum[] a(View paramView)
  {
    bhuk localbhuk = new bhuk();
    paramView = (ahld)agej.a(paramView);
    MessageForLightVideo localMessageForLightVideo = (MessageForLightVideo)paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
    if ((!TextUtils.isEmpty(localMessageForLightVideo.md5)) && (bhmi.b(ShortVideoUtils.a(localMessageForLightVideo.thumbMD5, "jpg")))) {
      if ((paramView.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.c == null) || (paramView.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.c.getVisibility() != 0)) {
        break label125;
      }
    }
    label125:
    for (int m = 1;; m = 0)
    {
      if (m == 0) {
        a(localbhuk, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, localMessageForLightVideo);
      }
      a(localbhuk, localMessageForLightVideo);
      super.c(localbhuk, this.jdField_a_of_type_AndroidContentContext);
      super.e(localbhuk, this.jdField_a_of_type_AndroidContentContext);
      return localbhuk.a();
    }
  }
  
  protected void b(ahld paramahld)
  {
    if (!paramahld.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.a(paramahld.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin + paramahld.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq))
    {
      paramahld.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setVisibility(8);
      return;
    }
    paramahld.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setAnimRunnableListener(new ahlc(this, paramahld));
  }
  
  void b(MessageForLightVideo paramMessageForLightVideo)
  {
    bcxn localbcxn = bcwu.a(2, 2);
    bcwx localbcwx = paramMessageForLightVideo.getDownloadInfo(localbcxn.jdField_b_of_type_Int);
    localbcwx.i = ShortVideoUtils.a(paramMessageForLightVideo.thumbMD5, "jpg");
    localbcwx.a(paramMessageForLightVideo.istroop, 1);
    localbcwx.f = 2;
    localbcwx.g = 2;
    localbcxn.a(localbcwx);
    localbcxn.a(paramMessageForLightVideo);
    bcwu.a(localbcxn, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
  }
  
  void b(MessageForLightVideo paramMessageForLightVideo, ahld paramahld, int paramInt)
  {
    paramahld.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.b(paramMessageForLightVideo.frienduin + paramMessageForLightVideo.uniseq);
    paramahld.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setVisibility(0);
    paramahld.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setImageResource(2130849764);
    paramahld.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setDrawStatus(3);
    paramahld.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    paramahld.jdField_a_of_type_AndroidWidgetTextView.setText(paramInt);
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
    ahld localahld = (ahld)agej.a(paramView);
    if (localahld == null) {}
    MessageForLightVideo localMessageForLightVideo;
    do
    {
      for (;;)
      {
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        localMessageForLightVideo = (MessageForLightVideo)localahld.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
        if (QLog.isColorLevel()) {
          QLog.d("LightVideoItemBuilder", 2, "onClick! uniseq:" + localMessageForLightVideo.uniseq);
        }
        if (paramView.getId() != 2131364466)
        {
          if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.d()) {
            break;
          }
          QQToast.a(this.jdField_a_of_type_AndroidContentContext, 2131695278, 1).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299011));
        }
      }
      if ((paramView.getId() != 2131364423) && (paramView.getId() != 2131362423)) {
        break;
      }
    } while (localMessageForLightVideo.md5 == null);
    if (c(localMessageForLightVideo))
    {
      a(localahld, localMessageForLightVideo, 2);
      MediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(false);
    }
    for (;;)
    {
      super.onClick(paramView);
      break;
      String str = ShortVideoUtils.a(localMessageForLightVideo.thumbMD5, "jpg");
      if (!bhmi.b(ShortVideoUtils.a(localMessageForLightVideo, "mp4")))
      {
        a(localMessageForLightVideo, false);
        a(localMessageForLightVideo, localahld, localMessageForLightVideo.videoFileProgress, false);
        this.jdField_c_of_type_Long = localMessageForLightVideo.uniseq;
        this.j = 0;
      }
      else if (bhmi.b(str))
      {
        bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800561C", "0X800561C", 0, 0, "", "", "", "");
        if (TVK_SDKMgr.isInstalled(this.jdField_a_of_type_AndroidContentContext))
        {
          if (!MediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(agej.a(paramView))) {
            QQToast.a(this.jdField_a_of_type_AndroidContentContext, 1, 2131694615, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299011));
          }
        }
        else {
          QQToast.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131697059), 0).b(BaseApplicationImpl.getApplication().getResources().getDimensionPixelSize(2131299011));
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
      paramString = bhjz.a().a(Long.valueOf(paramQQLiveDrawableParams.msgUniseq));
      if ((paramString != null) && (!bhjz.a().a(Long.valueOf(paramQQLiveDrawableParams.msgUniseq))))
      {
        ShortVideoUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "0X8008E51", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramString, this.jdField_a_of_type_AndroidContentContext);
        if (!bhjz.a().b(Long.valueOf(paramString.uniseq)))
        {
          bhjz.a().a(Long.valueOf(paramString.uniseq));
          ShortVideoUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "0X8008E50", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramString, this.jdField_a_of_type_AndroidContentContext);
        }
        bhjz.a().a(Long.valueOf(paramQQLiveDrawableParams.msgUniseq), true);
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