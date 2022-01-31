package com.tencent.mobileqq.activity.aio.item;

import acex;
import aekt;
import aels;
import aelt;
import aenl;
import aeor;
import aeov;
import afps;
import afpt;
import afpu;
import afpv;
import afpw;
import aftc;
import aftq;
import alpo;
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
import apgg;
import athg;
import athh;
import axtg;
import ayvj;
import ayyu;
import ayyw;
import ayyx;
import ayzf;
import ayzo;
import azag;
import azmj;
import bamw;
import baoj;
import batw;
import baul;
import bdan;
import bdcs;
import bdkz;
import bdlb;
import bhpy;
import bhql;
import biqt;
import birh;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.image.QQLiveDrawable;
import com.tencent.image.QQLiveDrawable.OnStateListener;
import com.tencent.image.QQLiveDrawable.QQLiveDrawableParams;
import com.tencent.image.QQLiveImage;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.AudioPlayer;
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
import wta;

public class LightVideoItemBuilder
  extends aftq
  implements aenl, aeor, athh, ayyw, QQLiveDrawable.OnStateListener
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
  private AudioPlayer jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer;
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
    g = BaseChatItemLayout.e;
    g = Math.min(aekt.a(320.0F, localResources), g);
    h = aekt.a(100.0F, localResources);
    i = aekt.a(100.0F, localResources);
    e = aekt.a(160.0F, localResources);
    f = aekt.a(160.0F, localResources);
    jdField_a_of_type_AndroidGraphicsDrawableColorDrawable = new apgg(-10065297, e, f);
    jdField_c_of_type_Int = aekt.a(8.0F, localResources);
    d = aekt.a(3.0F, localResources);
  }
  
  public LightVideoItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    if (paramAIOAnimationConatiner != null) {
      this.jdField_a_of_type_ComTencentWidgetListView = paramAIOAnimationConatiner.a();
    }
    athg.a().a(this);
  }
  
  private void a(afpw paramafpw, MessageForLightVideo paramMessageForLightVideo, LightVideoItemBuilder.ChatVideoView paramChatVideoView)
  {
    if (c(paramMessageForLightVideo))
    {
      a(paramafpw, false, false, 0, false, false);
      a(paramafpw, paramMessageForLightVideo, 1);
    }
    do
    {
      return;
      if (d(paramMessageForLightVideo))
      {
        paramChatVideoView = ShortVideoUtils.a(paramMessageForLightVideo.thumbMD5, "jpg");
        a(paramafpw.jdField_a_of_type_ComTencentMobileqqActivityAioItemLightVideoItemBuilder$ChatVideoView, paramChatVideoView, this.l, this.k);
        a(paramafpw, paramMessageForLightVideo, 2);
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
        a(this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer, paramafpw, 0);
        a(paramafpw, paramMessageForLightVideo, 1);
        this.j = 0;
        this.jdField_c_of_type_Long = 0L;
        return;
      }
    } while (MediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(paramMessageForLightVideo));
    QQToast.a(this.jdField_a_of_type_AndroidContentContext, 1, 2131695679, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298914));
    return;
    if (a(paramafpw, paramMessageForLightVideo, paramChatVideoView))
    {
      a(paramafpw, paramMessageForLightVideo, 3);
      return;
    }
    a(paramafpw, paramMessageForLightVideo, 0);
  }
  
  private void a(afpw paramafpw, boolean paramBoolean1, boolean paramBoolean2, int paramInt, boolean paramBoolean3, boolean paramBoolean4)
  {
    if (paramafpw != null)
    {
      Object localObject1 = (MessageForLightVideo)paramafpw.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
      String str1 = ShortVideoUtils.a(((MessageForLightVideo)localObject1).thumbMD5, "jpg");
      String str2 = ShortVideoUtils.a((MessageForShortVideo)localObject1, "mp4");
      if ((this.k == 0) || (this.l == 0))
      {
        localObject2 = BaseApplicationImpl.getContext().getResources();
        this.k = aekt.a(160.0F, (Resources)localObject2);
        this.l = aekt.a(160.0F, (Resources)localObject2);
        if (QLog.isColorLevel()) {
          QLog.d("LightVideoItemBuilder", 2, "getURLDrawableByMsg w:" + this.k + " ,h:" + this.l + " ,uniseq:" + ((MessageForLightVideo)localObject1).uniseq);
        }
      }
      if ((this.jdField_a_of_type_ComTencentImageURLDrawable == null) || (!this.jdField_a_of_type_ComTencentImageURLDrawable.getURL().getPath().equals(str1))) {
        this.jdField_a_of_type_ComTencentImageURLDrawable = athg.a(str1, this.k, this.l);
      }
      Object localObject2 = athg.a(str2, str1, ((MessageForLightVideo)localObject1).uniseq, this.k, this.l, paramBoolean1, paramBoolean2, paramBoolean4, paramInt, this, this.jdField_a_of_type_ComTencentImageURLDrawable);
      paramafpw.jdField_a_of_type_ComTencentMobileqqActivityAioItemLightVideoItemBuilder$ChatVideoView.setURLDrawable((URLDrawable)localObject2);
      if (paramBoolean3)
      {
        localObject2 = (URLDrawable)paramafpw.jdField_a_of_type_ComTencentMobileqqActivityAioItemLightVideoItemBuilder$ChatVideoView.getDrawable();
        if ((((URLDrawable)localObject2).getStatus() == 1) && ((((URLDrawable)localObject2).getCurrDrawable() instanceof QQLiveDrawable)))
        {
          ((QQLiveDrawable)((URLDrawable)localObject2).getCurrDrawable()).release();
          localObject1 = athg.a(str2, str1, ((MessageForLightVideo)localObject1).uniseq, this.k, this.l, paramBoolean1, paramBoolean2, paramBoolean4, paramInt, this, this.jdField_a_of_type_ComTencentImageURLDrawable);
          paramafpw.jdField_a_of_type_ComTencentMobileqqActivityAioItemLightVideoItemBuilder$ChatVideoView.setURLDrawable((URLDrawable)localObject1);
          if (QLog.isColorLevel()) {
            QLog.d("LightVideoItemBuilder", 2, "refreshVideo needRelease uniseq:" + paramafpw.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
          }
        }
      }
    }
  }
  
  private void a(AudioPlayer paramAudioPlayer, afpw paramafpw, int paramInt)
  {
    if ((paramafpw == null) || (paramAudioPlayer == null)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("LightVideoItemBuilder", 2, "refreshVideoWithEarModeJudge! uniseq:" + paramafpw.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq + " ,loudSpeaker:" + athg.a + " ,position:" + paramInt);
    }
    try
    {
      paramAudioPlayer.b();
      if (athg.a)
      {
        if (paramAudioPlayer.a()) {
          paramAudioPlayer.c();
        }
        a(paramafpw, false, false, paramInt, true, false);
        return;
      }
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        localIOException.printStackTrace();
      }
      a(paramafpw, false, true, paramInt, true, false);
      paramAudioPlayer.a(ShortVideoUtils.a((MessageForShortVideo)paramafpw.jdField_a_of_type_ComTencentMobileqqDataChatMessage, "mp4"), paramInt + 1000);
    }
  }
  
  private void a(LightVideoItemBuilder.ChatVideoView paramChatVideoView, String paramString, int paramInt1, int paramInt2)
  {
    if (paramChatVideoView.a(paramString)) {
      paramChatVideoView.setURLDrawable(athg.a(paramString, paramInt2, paramInt1));
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
  
  private boolean a(MessageForLightVideo paramMessageForLightVideo, afpw paramafpw)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LightVideoItemBuilder", 2, "startUploadVideo! uniseq:" + paramMessageForLightVideo.uniseq);
    }
    String str1 = paramMessageForLightVideo.videoFileName;
    String str2 = ShortVideoUtils.a(paramMessageForLightVideo.thumbMD5, "jpg");
    if (!bdcs.b(str1))
    {
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, 1, 2131720133, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298914));
      paramMessageForLightVideo.videoFileStatus = 1005;
      return false;
    }
    if (!bdcs.b(str2))
    {
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, 1, 2131720134, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298914));
      paramafpw.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
      paramMessageForLightVideo.videoFileStatus = 1005;
      return false;
    }
    paramMessageForLightVideo.mThumbFilePath = str2;
    paramafpw = axtg.a(paramMessageForLightVideo);
    paramafpw.i = paramMessageForLightVideo.videoFileName;
    paramafpw.f = paramMessageForLightVideo.mLocalMd5;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramafpw);
    return true;
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
        if ((localObject != null) && (((afpw)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioItemLightVideoItemBuilder$ChatVideoView != null) && (((afpw)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioItemLightVideoItemBuilder$ChatVideoView.b != null) && (((afpw)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioItemLightVideoItemBuilder$ChatVideoView.b.getStatus() == 1) && ((((afpw)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioItemLightVideoItemBuilder$ChatVideoView.b.getCurrDrawable() instanceof QQLiveDrawable))) {
          if (paramBoolean) {
            ((QQLiveDrawable)((afpw)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioItemLightVideoItemBuilder$ChatVideoView.b.getCurrDrawable()).pause();
          } else {
            ((QQLiveDrawable)((afpw)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioItemLightVideoItemBuilder$ChatVideoView.b.getCurrDrawable()).resume();
          }
        }
      }
    }
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
  
  public aels a(View paramView)
  {
    if ((paramView != null) && (paramView.getParent() != null))
    {
      paramView = (afpw)((View)paramView.getParent()).getTag();
      if (paramView != null) {
        return paramView.jdField_a_of_type_ComTencentMobileqqActivityAioItemLightVideoItemBuilder$ChatVideoView;
      }
    }
    return null;
  }
  
  public aelt a()
  {
    return new afpw(this);
  }
  
  public afpw a(long paramLong)
  {
    if ((this.jdField_a_of_type_ComTencentWidgetListView != null) && (paramLong > 0L))
    {
      int m = aekt.a(paramLong, this.jdField_a_of_type_ComTencentWidgetListView.getAdapter());
      int n = this.jdField_a_of_type_ComTencentWidgetListView.getHeaderViewsCount();
      int i1 = this.jdField_a_of_type_ComTencentWidgetListView.getFirstVisiblePosition();
      int i2 = this.jdField_a_of_type_ComTencentWidgetListView.getLastVisiblePosition();
      if (m <= -1) {
        break label223;
      }
      Object localObject = aekt.a(this.jdField_a_of_type_ComTencentWidgetListView, m);
      if (localObject != null)
      {
        localObject = aekt.a((View)localObject);
        if ((localObject != null) && ((localObject instanceof afpw))) {
          return (afpw)localObject;
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
  
  public View a(int paramInt1, int paramInt2, ChatMessage paramChatMessage, View paramView, ViewGroup paramViewGroup, aeov paramaeov)
  {
    paramViewGroup = super.a(paramInt1, paramInt2, paramChatMessage, paramView, paramViewGroup, paramaeov);
    a(paramChatMessage, paramView, this);
    return paramViewGroup;
  }
  
  public View a(ChatMessage paramChatMessage, aelt paramaelt, View paramView, BaseChatItemLayout paramBaseChatItemLayout, aeov paramaeov)
  {
    paramBaseChatItemLayout = (afpw)paramaelt;
    Object localObject2 = this.jdField_a_of_type_AndroidContentContext;
    Resources localResources = ((Context)localObject2).getResources();
    MessageForLightVideo localMessageForLightVideo = (MessageForLightVideo)paramChatMessage;
    paramaelt = paramView;
    if (paramView == null)
    {
      paramaelt = new RelativeLayout((Context)localObject2);
      paramView = new LightVideoItemBuilder.ChatVideoView((Context)localObject2);
      paramView.setId(2131371925);
      paramView.setScaleType(ImageView.ScaleType.CENTER_CROP);
      paramView.setRadius(15.0F);
      paramView.d(false);
      paramView.setSharpCornerCor(BubbleImageView.a);
      paramView.setContentDescription(alpo.a(2131706417));
      paramaelt.addView(paramView);
      MessageProgressView localMessageProgressView = new MessageProgressView((Context)localObject2);
      paramaelt.addView(localMessageProgressView);
      Object localObject3 = new LinearLayout((Context)localObject2);
      ((LinearLayout)localObject3).setOrientation(1);
      ((LinearLayout)localObject3).setGravity(17);
      Object localObject1 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject1).addRule(13);
      paramaelt.addView((View)localObject3, (ViewGroup.LayoutParams)localObject1);
      localObject1 = new TextView((Context)localObject2);
      Object localObject4 = new LinearLayout.LayoutParams(-2, -2);
      ((LinearLayout.LayoutParams)localObject4).topMargin = aekt.a(70.0F, localResources);
      ((TextView)localObject1).setTextColor(-1);
      ((TextView)localObject1).setTextSize(2, 12.0F);
      ((TextView)localObject1).setId(2131364211);
      ((LinearLayout)localObject3).addView((View)localObject1, (ViewGroup.LayoutParams)localObject4);
      localObject2 = new LinearLayout((Context)localObject2);
      ((LinearLayout)localObject2).setOrientation(0);
      ((LinearLayout)localObject2).setGravity(16);
      ((LinearLayout)localObject2).setBackgroundResource(2130837980);
      ((LinearLayout)localObject2).setId(2131362332);
      ((LinearLayout)localObject2).setOnClickListener(new afps(this));
      localObject3 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject3).addRule(8, 2131371925);
      ((RelativeLayout.LayoutParams)localObject3).bottomMargin = jdField_c_of_type_Int;
      ((RelativeLayout.LayoutParams)localObject3).addRule(5, 2131371925);
      ((RelativeLayout.LayoutParams)localObject3).leftMargin = jdField_c_of_type_Int;
      paramaelt.addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
      localObject3 = new ImageView(this.jdField_a_of_type_AndroidContentContext);
      ((ImageView)localObject3).setId(2131373371);
      ((ImageView)localObject3).setPadding(jdField_c_of_type_Int, d, d, d);
      ((LinearLayout)localObject2).addView((View)localObject3);
      localObject4 = new TextView(this.jdField_a_of_type_AndroidContentContext);
      ((TextView)localObject4).setId(2131373376);
      ((TextView)localObject4).setTextColor(-1);
      ((TextView)localObject4).setPadding(0, d, jdField_c_of_type_Int, d);
      ((LinearLayout)localObject2).addView((View)localObject4);
      paramaelt.setOnClickListener(this);
      paramaelt.setOnTouchListener(paramaeov);
      paramaelt.setOnLongClickListener(paramaeov);
      paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqActivityAioItemLightVideoItemBuilder$ChatVideoView = paramView;
      paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView = localMessageProgressView;
      paramBaseChatItemLayout.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localObject1);
      paramBaseChatItemLayout.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localObject3);
      paramBaseChatItemLayout.b = ((TextView)localObject4);
    }
    paramView = paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqActivityAioItemLightVideoItemBuilder$ChatVideoView;
    if (AppSetting.c)
    {
      paramaeov = new StringBuilder();
      paramaeov.append("轻量短视频 ");
      paramaeov.append(localMessageForLightVideo.videoFileTime);
      paramaeov.append("秒");
      if ((!localMessageForLightVideo.isSend()) && (!localMessageForLightVideo.isLightVideoRead)) {
        paramaeov.append(" 未播放");
      }
      paramView.setContentDescription(paramaeov.toString());
    }
    paramView.d = localMessageForLightVideo.isSend();
    paramView.setTag(Long.valueOf(localMessageForLightVideo.uniseq));
    bdan.a().a(Long.valueOf(localMessageForLightVideo.uniseq), localMessageForLightVideo);
    paramBaseChatItemLayout.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setRadius(15.0F, true);
    paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setShowCorner(false);
    paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setSharpCornerCor(BubbleImageView.a);
    paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setCornerDirection(localMessageForLightVideo.isSend());
    paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.a(paramChatMessage.frienduin + paramChatMessage.uniseq);
    this.k = aekt.a(160.0F, localResources);
    this.l = aekt.a(160.0F, localResources);
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
      return paramaelt;
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
    return alpo.a(2131706440);
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
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer = null;
    if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForLightVideo != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForLightVideo.mCurrQQLive = null;
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForLightVideo = null;
    }
    athg.a().a(null);
    this.jdField_a_of_type_ComTencentImageURLDrawable = null;
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    MessageForLightVideo localMessageForLightVideo;
    if ((paramChatMessage != null) && ((paramChatMessage instanceof MessageForLightVideo)))
    {
      localMessageForLightVideo = (MessageForLightVideo)paramChatMessage;
      if (paramInt == 2131365069)
      {
        acex.b(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localMessageForLightVideo);
        wta.a("story_grp", "press_msg", 0, 0, new String[] { "4", "", "", "" });
      }
    }
    else
    {
      return;
    }
    if (paramInt == 2131370842)
    {
      super.d(paramChatMessage);
      wta.a("story_grp", "press_msg", 0, 0, new String[] { "5", "", "", "" });
      return;
    }
    if (paramInt == 2131366015)
    {
      biqt.a(localMessageForLightVideo).b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage).a((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
      birh.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 6, 5);
      birh.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 3, 0, paramChatMessage.istroop);
      wta.a("story_grp", "press_msg", 0, 0, new String[] { "2", "", "", "" });
      return;
    }
    if (paramInt == 2131370799)
    {
      if (c(paramChatMessage)) {
        MediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(true);
      }
      super.a(localMessageForLightVideo);
      wta.a("story_grp", "press_msg", 0, 0, new String[] { "3", "", "", "" });
      return;
    }
    if (paramInt == 2131365029)
    {
      paramContext = new StringBuilder();
      paramContext.append("uniseq:").append(localMessageForLightVideo.uniseq).append("\n");
      Toast.makeText(this.jdField_a_of_type_AndroidContentContext, paramContext.toString(), 1).show();
      return;
    }
    super.a(paramInt, paramContext, paramChatMessage);
  }
  
  protected void a(afpw paramafpw)
  {
    if (!paramafpw.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.a(paramafpw.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin + paramafpw.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq)) {
      paramafpw.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setVisibility(8);
    }
    for (;;)
    {
      paramafpw.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      if (QLog.isColorLevel()) {
        QLog.w("LightVideoItemBuilder", 2, "[hideProgress] set ProgressPieDrawable visible");
      }
      return;
      paramafpw.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setAnimRunnableListener(new afpu(this, paramafpw));
    }
  }
  
  protected void a(afpw paramafpw, MessageForLightVideo paramMessageForLightVideo, int paramInt)
  {
    if (paramafpw == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("LightVideoItemBuilder", 2, String.format("handleVideoViewAnimStatus uniseq:%d, status:%d", new Object[] { Long.valueOf(paramMessageForLightVideo.uniseq), Integer.valueOf(paramInt) }));
    }
    paramafpw.b.setText(aftc.a(paramMessageForLightVideo.videoFileTime));
    paramafpw.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setUnread(false, null, null);
    paramMessageForLightVideo.videoStatus = paramInt;
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      if ((!paramMessageForLightVideo.isSend()) && (!paramMessageForLightVideo.isLightVideoRead)) {
        paramafpw.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setUnread(true, null, null);
      }
      paramafpw.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130840295);
      return;
    case 1: 
      a(paramMessageForLightVideo);
      paramMessageForLightVideo = (AnimationDrawable)this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130772069);
      paramafpw.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramMessageForLightVideo);
      paramMessageForLightVideo.start();
      return;
    case 2: 
      paramafpw.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130840292);
      return;
    }
    if ((!paramMessageForLightVideo.isSend()) && (!paramMessageForLightVideo.isLightVideoRead)) {
      paramafpw.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setUnread(true, null, null);
    }
    paramafpw.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130840292);
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    paramView = (afpw)aekt.a(paramView);
    MessageForLightVideo localMessageForLightVideo = (MessageForLightVideo)paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
    if (!localMessageForLightVideo.isSendFromLocal()) {
      return;
    }
    bhpy localbhpy = (bhpy)bhql.a(this.jdField_a_of_type_AndroidContentContext, null);
    localbhpy.a(2131690042, 5);
    localbhpy.c(2131690648);
    localbhpy.a(new afpt(this, localMessageForLightVideo, paramView, localbhpy));
    localbhpy.show();
  }
  
  public void a(View paramView, baoj parambaoj, int paramInt1, int paramInt2)
  {
    paramView = (afpw)aekt.a(paramView);
    MessageForLightVideo localMessageForLightVideo = (MessageForLightVideo)paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
    if (localMessageForLightVideo.uniseq != parambaoj.jdField_b_of_type_Long) {}
    LightVideoItemBuilder.ChatVideoView localChatVideoView;
    Object localObject;
    label67:
    int m;
    int n;
    label325:
    label846:
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            localChatVideoView = paramView.jdField_a_of_type_ComTencentMobileqqActivityAioItemLightVideoItemBuilder$ChatVideoView;
          } while (this.jdField_a_of_type_AndroidContentContext == null);
          localObject = this.jdField_a_of_type_AndroidContentContext.getResources();
          if (localMessageForLightVideo.thumbWidth > 0)
          {
            paramInt1 = localMessageForLightVideo.thumbWidth;
            if (localMessageForLightVideo.thumbHeight <= 0) {
              break label325;
            }
          }
          for (paramInt2 = localMessageForLightVideo.thumbHeight;; paramInt2 = 100)
          {
            m = aekt.a(paramInt1, (Resources)localObject);
            n = aekt.a(paramInt2, (Resources)localObject);
            if ((parambaoj.jdField_b_of_type_Int != 327689) && (parambaoj.jdField_b_of_type_Int != 6) && (parambaoj.jdField_b_of_type_Int != 17) && (parambaoj.jdField_b_of_type_Int != 9)) {
              break label846;
            }
            switch (parambaoj.d)
            {
            default: 
              return;
            case 1001: 
              a(localMessageForLightVideo, "VIDEO STATUS_SEND_START progress " + localMessageForLightVideo.videoFileProgress);
              if (localMessageForLightVideo.busiType != 1) {
                a(localMessageForLightVideo, paramView, localMessageForLightVideo.videoFileProgress, true);
              }
              paramView.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(false, this);
              return;
              paramInt1 = 100;
              break label67;
            }
          }
          a(localMessageForLightVideo, "VIDEO STATUS_UPLOAD_FINISHED progress " + localMessageForLightVideo.videoFileProgress);
          return;
          parambaoj = ShortVideoUtils.a(localMessageForLightVideo, "mp4");
          boolean bool = bdcs.b(parambaoj);
          a(localMessageForLightVideo, "VIDEO STATUS_SEND_FINISHED ,videofile:" + parambaoj + " ,videoexist:" + bool);
          if (bool)
          {
            a(paramView, localMessageForLightVideo, localChatVideoView);
            a(localMessageForLightVideo, paramView, 100, true);
          }
          c(localMessageForLightVideo);
          return;
          a(localMessageForLightVideo, "VIDEO STATUS_SEND_ERROR");
          c(localMessageForLightVideo);
          b(localMessageForLightVideo, paramView, 2131719269);
          a(paramView);
          paramView.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
          return;
          a(localMessageForLightVideo, "VIDEO STATUS_SEND_CANCEL");
          c(localMessageForLightVideo);
          a(paramView);
          return;
          paramInt1 = localMessageForLightVideo.videoFileProgress;
          a(localMessageForLightVideo, "VIDEO STATUS_SEND_PROCESS " + paramInt1);
          a(localMessageForLightVideo, paramView, paramInt1);
          return;
          a(localMessageForLightVideo, "VIDEO STATUS_RECV_START");
          a(localMessageForLightVideo, paramView, localMessageForLightVideo.videoFileProgress, true);
          return;
          a(localMessageForLightVideo, "VIDEO STATUS_RECV_FINISHED");
          a(paramView, localMessageForLightVideo, localChatVideoView);
          a(localMessageForLightVideo, paramView, 100, true);
          b(paramView);
          return;
          a(localMessageForLightVideo, "VIDEO STATUS_FILE_UNSAFE");
          b(localMessageForLightVideo, paramView, 2131719263);
          if (localMessageForLightVideo.uiOperatorFlag == 2)
          {
            paramView.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
            QQToast.a(this.jdField_a_of_type_AndroidContentContext, 2131720101, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298914));
            return;
          }
          QQToast.a(this.jdField_a_of_type_AndroidContentContext, 2131720126, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298914));
          return;
          a(localMessageForLightVideo, "VIDEO STATUS_RECV_ERROR");
          a(paramView);
          a(localMessageForLightVideo, paramView);
          QQToast.a(this.jdField_a_of_type_AndroidContentContext, 2131720128, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298914));
          return;
          a(localMessageForLightVideo, "VIDEO STATUS_FILE_EXPIRED");
          parambaoj = ShortVideoUtils.a(localMessageForLightVideo.thumbMD5, "jpg");
          if (bdcs.b(parambaoj)) {
            a(localChatVideoView, parambaoj, paramInt2, paramInt1);
          }
          b(localMessageForLightVideo, paramView, 2131719264);
          return;
          a(localMessageForLightVideo, "VIDEO STATUS_RECV_CANCEL");
          return;
          paramInt1 = localMessageForLightVideo.videoFileProgress;
          a(localMessageForLightVideo, "VIDEO STATUS_RECV_PROCESS " + paramInt1);
          a(localMessageForLightVideo, paramView, paramInt1, true);
          return;
        } while ((parambaoj.jdField_b_of_type_Int != 7) && (parambaoj.jdField_b_of_type_Int != 18) && (parambaoj.jdField_b_of_type_Int != 16));
        switch (parambaoj.d)
        {
        default: 
          return;
        case 2001: 
          a(localMessageForLightVideo, "THUMB STATUS_RECV_START");
          return;
        case 2003: 
          a(localMessageForLightVideo, "THUMB STATUS_RECV_FINISHED");
          parambaoj = ShortVideoUtils.a(localMessageForLightVideo.thumbMD5, "jpg");
          localObject = ShortVideoUtils.a(localMessageForLightVideo, "mp4");
          if ((!bdcs.b((String)localObject)) || (!azag.b)) {
            break label1044;
          }
          a(localMessageForLightVideo, alpo.a(2131706431) + parambaoj);
        }
      } while (!ShortVideoUtils.a());
      parambaoj = athg.a((String)localObject, parambaoj, localMessageForLightVideo.uniseq, paramInt1, paramInt2, false, true, false, 0, this, null);
      paramView.jdField_a_of_type_ComTencentMobileqqActivityAioItemLightVideoItemBuilder$ChatVideoView.setURLDrawable(parambaoj);
      b(paramView);
      return;
      if (!bdcs.b(parambaoj)) {
        break;
      }
    } while (!localChatVideoView.a(parambaoj));
    label1044:
    a(localMessageForLightVideo, alpo.a(2131706435) + parambaoj);
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mRequestWidth = m;
    localURLDrawableOptions.mRequestHeight = n;
    localURLDrawableOptions.mLoadingDrawable = jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
    localURLDrawableOptions.mFailedDrawable = jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
    localChatVideoView.setURLDrawable(URLDrawable.getDrawable(new File(parambaoj), localURLDrawableOptions));
    if (!bdcs.b((String)localObject))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localMessageForLightVideo, true))
      {
        a(localMessageForLightVideo, true);
        return;
      }
      a(localMessageForLightVideo, paramView);
      return;
    }
    if (ShortVideoUtils.a())
    {
      a(paramView);
      return;
    }
    a(localMessageForLightVideo, paramView);
    return;
    localChatVideoView.setImageDrawable(baul.a());
    return;
    a(localMessageForLightVideo, "THUMB STATUS_FILE_EXPIRED");
    a(localMessageForLightVideo, "THUMB STATUS_RECV_ERROR");
    parambaoj = ShortVideoUtils.a(localMessageForLightVideo, "mp4");
    if (bdcs.b(parambaoj)) {
      if (localChatVideoView.a(parambaoj))
      {
        a(localMessageForLightVideo, alpo.a(2131706421) + parambaoj);
        if (ShortVideoUtils.a())
        {
          parambaoj = athg.a(parambaoj, ShortVideoUtils.a(localMessageForLightVideo.thumbMD5, "jpg"), localMessageForLightVideo.uniseq, paramInt1, paramInt2, false, true, false, 0, this, null);
          paramView.jdField_a_of_type_ComTencentMobileqqActivityAioItemLightVideoItemBuilder$ChatVideoView.setURLDrawable(parambaoj);
          b(paramView);
        }
      }
    }
    for (;;)
    {
      a(paramView);
      return;
      parambaoj = localChatVideoView.b;
      if ((parambaoj != null) && (parambaoj.getStatus() == 1))
      {
        localChatVideoView.setURLDrawable(parambaoj);
        continue;
        localChatVideoView.setImageDrawable(jdField_a_of_type_AndroidGraphicsDrawableColorDrawable);
      }
    }
  }
  
  public void a(View paramView, ChatMessage paramChatMessage)
  {
    int m = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131296300);
    if (paramChatMessage.isSend())
    {
      paramView.setPadding(BaseChatItemLayout.j, BaseChatItemLayout.g, m, BaseChatItemLayout.h);
      return;
    }
    paramView.setPadding(m, BaseChatItemLayout.g, BaseChatItemLayout.j, BaseChatItemLayout.h);
  }
  
  public void a(MessageForLightVideo paramMessageForLightVideo)
  {
    if (!paramMessageForLightVideo.isLightVideoRead)
    {
      paramMessageForLightVideo.isLightVideoRead = true;
      paramMessageForLightVideo.saveExtInfoToExtStr(ayvj.u, "1");
      ThreadManager.post(new LightVideoItemBuilder.2(this, paramMessageForLightVideo), 10, null, false);
    }
  }
  
  void a(MessageForLightVideo paramMessageForLightVideo, afpw paramafpw)
  {
    paramafpw.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.b(paramMessageForLightVideo.frienduin + paramMessageForLightVideo.uniseq);
    paramafpw.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setDrawStatus(2);
    paramafpw.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setVisibility(0);
    paramafpw.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    if (QLog.isColorLevel()) {
      QLog.w("LightVideoItemBuilder", 2, "[showPauseProgress] uinseq:" + paramMessageForLightVideo.uniseq);
    }
  }
  
  void a(MessageForLightVideo paramMessageForLightVideo, afpw paramafpw, int paramInt)
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
    a(paramMessageForLightVideo, paramafpw, paramInt, true);
  }
  
  protected void a(MessageForLightVideo paramMessageForLightVideo, afpw paramafpw, int paramInt, boolean paramBoolean)
  {
    paramafpw.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setDrawStatus(1);
    paramafpw.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setAnimProgress(paramInt, paramMessageForLightVideo.frienduin + paramMessageForLightVideo.uniseq);
    paramafpw.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setVisibility(0);
    paramafpw.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    if (QLog.isColorLevel()) {
      QLog.w("LightVideoItemBuilder", 2, "[setProgress] uinseq:" + paramMessageForLightVideo.uniseq + ", p:" + paramInt);
    }
  }
  
  void a(MessageForLightVideo paramMessageForLightVideo, boolean paramBoolean)
  {
    if (paramMessageForLightVideo.videoFileStatus == 5002)
    {
      a(paramMessageForLightVideo, alpo.a(2131706438));
      return;
    }
    ayzo localayzo = ayyu.a(2, 2);
    ayyx localayyx = paramMessageForLightVideo.getDownloadInfo(localayzo.jdField_b_of_type_Int);
    localayyx.h = ShortVideoUtils.a(paramMessageForLightVideo, "mp4");
    localayyx.a(paramMessageForLightVideo.istroop, 0);
    if (paramBoolean) {}
    for (int m = 2;; m = 1)
    {
      localayyx.f = m;
      localayyx.g = 2;
      if (QLog.isColorLevel()) {
        QLog.d("LightVideoItemBuilder", 2, " startDownloadVideo downloadvideo fileType==" + localayyx.e + ", uniseq:" + paramMessageForLightVideo.uniseq);
      }
      localayzo.a(localayyx);
      localayzo.a(paramMessageForLightVideo);
      ayyu.a(localayzo, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
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
    paramXListView = (afpw)aekt.a(paramView);
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
        a(paramView, ShortVideoUtils.a(paramChatMessage.thumbMD5, "jpg"), aekt.a(160.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), aekt.a(160.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
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
    afpw localafpw;
    if ((localChatMessage != null) && ((localChatMessage instanceof MessageForLightVideo)))
    {
      localafpw = a(localChatMessage.uniseq);
      if (localafpw != null) {
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
      } while ((localafpw.jdField_a_of_type_ComTencentMobileqqActivityAioItemLightVideoItemBuilder$ChatVideoView == null) || (localafpw.jdField_a_of_type_ComTencentMobileqqActivityAioItemLightVideoItemBuilder$ChatVideoView.b == null) || (localafpw.jdField_a_of_type_ComTencentMobileqqActivityAioItemLightVideoItemBuilder$ChatVideoView.b.getStatus() != 1) || (!(localafpw.jdField_a_of_type_ComTencentMobileqqActivityAioItemLightVideoItemBuilder$ChatVideoView.b.getCurrDrawable() instanceof QQLiveDrawable)));
      m = (int)((QQLiveDrawable)localafpw.jdField_a_of_type_ComTencentMobileqqActivityAioItemLightVideoItemBuilder$ChatVideoView.b.getCurrDrawable()).getCurrentPosition();
      a(this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer, localafpw, m - 1000);
    } while (!QLog.isColorLevel());
    QLog.d("LightVideoItemBuilder", 2, String.format("onNearToEar usingLoudSpeaker:%s, position:%d, duration:%d, uniseq:%d", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(m), Integer.valueOf(((MessageForShortVideo)localafpw.jdField_a_of_type_ComTencentMobileqqDataChatMessage).videoFileTime), Long.valueOf(localafpw.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq) }));
  }
  
  protected boolean a(afpw paramafpw, MessageForLightVideo paramMessageForLightVideo, LightVideoItemBuilder.ChatVideoView paramChatVideoView)
  {
    boolean bool2 = false;
    boolean bool1 = false;
    if ((TextUtils.isEmpty(paramMessageForLightVideo.md5)) && (paramMessageForLightVideo.videoFileStatus != 1005) && (paramMessageForLightVideo.extraflag != 32768))
    {
      bool2 = bool1;
      if (paramMessageForLightVideo.isSendFromLocal())
      {
        localObject2 = paramMessageForLightVideo.mThumbFilePath;
        localObject1 = localObject2;
        if (bdcs.b((String)localObject2)) {
          break label113;
        }
        if (!TextUtils.isEmpty(paramMessageForLightVideo.thumbMD5)) {
          break label102;
        }
        paramChatVideoView.setImageDrawable(baul.a());
        a(paramafpw);
        a(paramMessageForLightVideo, "getBubbleView():You must get thumb before send video.");
        bool2 = bool1;
      }
      label102:
      label113:
      do
      {
        do
        {
          return bool2;
          localObject1 = ShortVideoUtils.a(paramMessageForLightVideo.thumbMD5, "jpg");
          bool2 = bool1;
        } while (!paramChatVideoView.a((String)localObject1));
        localObject2 = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
        ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
        ((URLDrawable.URLDrawableOptions)localObject2).mRequestWidth = this.k;
        ((URLDrawable.URLDrawableOptions)localObject2).mRequestHeight = this.l;
        paramChatVideoView.setURLDrawable(URLDrawable.getDrawable(new File((String)localObject1), (URLDrawable.URLDrawableOptions)localObject2));
        bool3 = a(paramMessageForLightVideo, null);
        if (QLog.isColorLevel()) {
          QLog.d("LightVideoItemBuilder", 2, String.format("getBubbleView, judge mr status uniseq:%d, filestatus:%s, isfailed:%s", new Object[] { Long.valueOf(paramMessageForLightVideo.uniseq), Integer.valueOf(paramMessageForLightVideo.videoFileStatus), Boolean.valueOf(bool3) }));
        }
        bool2 = bool1;
      } while (bool3);
      a(paramMessageForLightVideo, paramafpw, paramMessageForLightVideo.videoFileProgress, true);
      return false;
    }
    Object localObject1 = ShortVideoUtils.a(paramMessageForLightVideo.thumbMD5, "jpg");
    Object localObject2 = ShortVideoUtils.a(paramMessageForLightVideo, "mp4");
    boolean bool3 = bdcs.b((String)localObject1);
    bool1 = bdcs.b((String)localObject2);
    if (QLog.isColorLevel()) {
      QLog.d("LightVideoItemBuilder", 2, String.format("handleVideoFileStatus uniseq:%d, thumb:%s, videofile:%s", new Object[] { Long.valueOf(paramMessageForLightVideo.uniseq), Boolean.valueOf(bool3), Boolean.valueOf(bool1) }));
    }
    if (bool1)
    {
      paramafpw.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setVisibility(8);
      if ((!paramMessageForLightVideo.isSendFromLocal()) || (paramMessageForLightVideo.isStatusReady())) {
        if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForLightVideo != null) && (this.jdField_a_of_type_ComTencentMobileqqDataMessageForLightVideo.videoStatus == 1))
        {
          bool1 = true;
          label393:
          a(paramafpw, true, true, 0, false, bool1);
          if (QLog.isColorLevel()) {
            QLog.d("LightVideoItemBuilder", 2, "LightVideo mutePlaying, uniseq:" + paramMessageForLightVideo.uniseq + " ,shouldPause:" + bool1);
          }
          bool1 = true;
        }
      }
      for (;;)
      {
        bool2 = bool1;
        if (bool3) {
          break;
        }
        b(paramMessageForLightVideo);
        a(paramMessageForLightVideo, "getBubbleView: Video file exist and status finish. Thumb not exist.");
        return bool1;
        bool1 = false;
        break label393;
        bool1 = bool2;
        if (bool3)
        {
          a(paramChatVideoView, (String)localObject1, this.l, this.k);
          bool1 = bool2;
        }
      }
    }
    if (bool3)
    {
      a(paramChatVideoView, (String)localObject1, this.l, this.k);
      if (paramMessageForLightVideo.videoFileStatus == 2005) {
        a(paramMessageForLightVideo, paramafpw);
      }
      if (paramMessageForLightVideo.videoFileStatus == 5002)
      {
        a(paramMessageForLightVideo, alpo.a(2131706444));
        b(paramMessageForLightVideo, paramafpw, 2131719264);
        return false;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramMessageForLightVideo, true))
      {
        a(paramMessageForLightVideo, true);
        return false;
      }
      if ((paramMessageForLightVideo.videoFileStatus == 2001) || (paramMessageForLightVideo.videoFileStatus == 2002) || (paramMessageForLightVideo.videoFileStatus == 2000))
      {
        a(paramMessageForLightVideo, paramafpw, paramMessageForLightVideo.videoFileProgress, false);
        return false;
      }
      a(paramMessageForLightVideo, paramafpw);
      return true;
    }
    if (paramMessageForLightVideo.videoFileStatus == 5002)
    {
      a(paramMessageForLightVideo, alpo.a(2131706418));
      paramChatVideoView.setImageDrawable(jdField_a_of_type_AndroidGraphicsDrawableColorDrawable);
      b(paramMessageForLightVideo, paramafpw, 2131719264);
      return false;
    }
    a(paramMessageForLightVideo, alpo.a(2131706424));
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
      if ((paramBaseChatItemLayout instanceof bamw))
      {
        if (((bamw)paramBaseChatItemLayout).c() == 1005L) {}
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
  
  public boolean a(XListView paramXListView, int paramInt1, View paramView, ChatMessage paramChatMessage, AudioPlayer paramAudioPlayer, int paramInt2)
  {
    paramXListView = (afpw)aekt.a(paramView);
    if (QLog.isColorLevel()) {
      QLog.d("LightVideoItemBuilder", 2, "play! uniseq:" + paramChatMessage.uniseq + " ,viewpositon:" + paramInt1);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer = paramAudioPlayer;
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
      a(paramAudioPlayer, paramXListView, 0);
      return true;
    }
    return false;
  }
  
  public bdlb[] a(View paramView)
  {
    bdkz localbdkz = new bdkz();
    paramView = (afpw)aekt.a(paramView);
    MessageForLightVideo localMessageForLightVideo = (MessageForLightVideo)paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
    if ((!TextUtils.isEmpty(localMessageForLightVideo.md5)) && (bdcs.b(ShortVideoUtils.a(localMessageForLightVideo.thumbMD5, "jpg")))) {
      if ((paramView.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.c == null) || (paramView.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.c.getVisibility() != 0)) {
        break label125;
      }
    }
    label125:
    for (int m = 1;; m = 0)
    {
      if (m == 0) {
        a(localbdkz, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, localMessageForLightVideo);
      }
      a(localbdkz, localMessageForLightVideo);
      super.c(localbdkz, this.jdField_a_of_type_AndroidContentContext);
      super.e(localbdkz, this.jdField_a_of_type_AndroidContentContext);
      return localbdkz.a();
    }
  }
  
  protected void b(afpw paramafpw)
  {
    if (!paramafpw.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.a(paramafpw.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin + paramafpw.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq))
    {
      paramafpw.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setVisibility(8);
      return;
    }
    paramafpw.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setAnimRunnableListener(new afpv(this, paramafpw));
  }
  
  void b(MessageForLightVideo paramMessageForLightVideo)
  {
    ayzo localayzo = ayyu.a(2, 2);
    ayyx localayyx = paramMessageForLightVideo.getDownloadInfo(localayzo.jdField_b_of_type_Int);
    localayyx.i = ShortVideoUtils.a(paramMessageForLightVideo.thumbMD5, "jpg");
    localayyx.a(paramMessageForLightVideo.istroop, 1);
    localayyx.f = 2;
    localayyx.g = 2;
    localayzo.a(localayyx);
    localayzo.a(paramMessageForLightVideo);
    ayyu.a(localayzo, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
  }
  
  void b(MessageForLightVideo paramMessageForLightVideo, afpw paramafpw, int paramInt)
  {
    paramafpw.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.b(paramMessageForLightVideo.frienduin + paramMessageForLightVideo.uniseq);
    paramafpw.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setVisibility(0);
    paramafpw.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setImageResource(2130849131);
    paramafpw.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setDrawStatus(3);
    paramafpw.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    paramafpw.jdField_a_of_type_AndroidWidgetTextView.setText(paramInt);
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
    afpw localafpw = (afpw)aekt.a(paramView);
    if (localafpw == null) {}
    MessageForLightVideo localMessageForLightVideo;
    do
    {
      do
      {
        return;
        localMessageForLightVideo = (MessageForLightVideo)localafpw.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
        if (QLog.isColorLevel()) {
          QLog.d("LightVideoItemBuilder", 2, "onClick! uniseq:" + localMessageForLightVideo.uniseq);
        }
      } while (paramView.getId() == 2131364213);
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c())
      {
        QQToast.a(this.jdField_a_of_type_AndroidContentContext, 2131696351, 1).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298914));
        return;
      }
      if ((paramView.getId() != 2131364171) && (paramView.getId() != 2131362332)) {
        break;
      }
    } while (localMessageForLightVideo.md5 == null);
    if (c(localMessageForLightVideo))
    {
      a(localafpw, localMessageForLightVideo, 2);
      MediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(false);
    }
    for (;;)
    {
      super.onClick(paramView);
      return;
      String str = ShortVideoUtils.a(localMessageForLightVideo.thumbMD5, "jpg");
      if (!bdcs.b(ShortVideoUtils.a(localMessageForLightVideo, "mp4")))
      {
        a(localMessageForLightVideo, false);
        a(localMessageForLightVideo, localafpw, localMessageForLightVideo.videoFileProgress, false);
        this.jdField_c_of_type_Long = localMessageForLightVideo.uniseq;
        this.j = 0;
      }
      else if (bdcs.b(str))
      {
        azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800561C", "0X800561C", 0, 0, "", "", "", "");
        if (TVK_SDKMgr.isInstalled(this.jdField_a_of_type_AndroidContentContext))
        {
          if (!MediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(aekt.a(paramView))) {
            QQToast.a(this.jdField_a_of_type_AndroidContentContext, 1, 2131695679, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298914));
          }
        }
        else {
          QQToast.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131698158), 0).b(BaseApplicationImpl.getApplication().getResources().getDimensionPixelSize(2131298914));
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
      paramString = bdan.a().a(Long.valueOf(paramQQLiveDrawableParams.msgUniseq));
      if ((paramString != null) && (!bdan.a().a(Long.valueOf(paramQQLiveDrawableParams.msgUniseq))))
      {
        ShortVideoUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "0X8008E51", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramString, this.jdField_a_of_type_AndroidContentContext);
        if (!bdan.a().b(Long.valueOf(paramString.uniseq)))
        {
          bdan.a().a(Long.valueOf(paramString.uniseq));
          ShortVideoUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "0X8008E50", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramString, this.jdField_a_of_type_AndroidContentContext);
        }
        bdan.a().a(Long.valueOf(paramQQLiveDrawableParams.msgUniseq), true);
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
    } while ((paramInt == 4) || (paramInt != 6) || (!c(paramString)) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer == null));
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.LightVideoItemBuilder
 * JD-Core Version:    0.7.0.1
 */