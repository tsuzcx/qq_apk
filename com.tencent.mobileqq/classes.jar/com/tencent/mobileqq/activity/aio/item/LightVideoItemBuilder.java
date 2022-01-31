package com.tencent.mobileqq.activity.aio.item;

import aanz;
import actj;
import acui;
import acuj;
import acwb;
import acxf;
import acxj;
import adtf;
import adtg;
import adth;
import adti;
import adtj;
import adwp;
import adxd;
import ajya;
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
import anoz;
import arql;
import arqm;
import awbh;
import axaf;
import axdq;
import axds;
import axdt;
import axeb;
import axei;
import axfa;
import axqy;
import aypb;
import ayqo;
import ayvx;
import aywm;
import bbbt;
import bbdx;
import bbmf;
import bbmh;
import bcql;
import bfpc;
import bfpp;
import bgpu;
import bgqi;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.image.QQLiveDrawable;
import com.tencent.image.QQLiveDrawable.OnStateListener;
import com.tencent.image.QQLiveDrawable.QQLiveDrawableParams;
import com.tencent.image.QQLiveImage;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.aio.AudioPlayer;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.MediaPlayerManager;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForLightVideo;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.widget.BubbleImageView;
import com.tencent.mobileqq.widget.MessageProgressView;
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
import vei;

public class LightVideoItemBuilder
  extends adxd
  implements acwb, acxf, arqm, axds, QQLiveDrawable.OnStateListener
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
    g = Math.min(actj.a(320.0F, localResources), g);
    h = actj.a(100.0F, localResources);
    i = actj.a(100.0F, localResources);
    e = actj.a(160.0F, localResources);
    f = actj.a(160.0F, localResources);
    jdField_a_of_type_AndroidGraphicsDrawableColorDrawable = new anoz(-10065297, e, f);
    jdField_c_of_type_Int = actj.a(8.0F, localResources);
    d = actj.a(3.0F, localResources);
  }
  
  public LightVideoItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    if (paramAIOAnimationConatiner != null) {
      this.jdField_a_of_type_ComTencentWidgetListView = paramAIOAnimationConatiner.a();
    }
    arql.a().a(this);
  }
  
  private void a(adtj paramadtj, MessageForLightVideo paramMessageForLightVideo, LightVideoItemBuilder.ChatVideoView paramChatVideoView)
  {
    if (c(paramMessageForLightVideo))
    {
      a(paramadtj, false, false, 0, false, false);
      a(paramadtj, paramMessageForLightVideo, 1);
    }
    do
    {
      return;
      if (d(paramMessageForLightVideo))
      {
        paramChatVideoView = ShortVideoUtils.a(paramMessageForLightVideo.thumbMD5, "jpg");
        a(paramadtj.jdField_a_of_type_ComTencentMobileqqActivityAioItemLightVideoItemBuilder$ChatVideoView, paramChatVideoView, this.l, this.k);
        a(paramadtj, paramMessageForLightVideo, 2);
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
        a(this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer, paramadtj, 0);
        a(paramadtj, paramMessageForLightVideo, 1);
        this.j = 0;
        this.jdField_c_of_type_Long = 0L;
        return;
      }
    } while (MediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(paramMessageForLightVideo));
    bcql.a(this.jdField_a_of_type_AndroidContentContext, 1, 2131695521, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298865));
    return;
    if (a(paramadtj, paramMessageForLightVideo, paramChatVideoView))
    {
      a(paramadtj, paramMessageForLightVideo, 3);
      return;
    }
    a(paramadtj, paramMessageForLightVideo, 0);
  }
  
  private void a(adtj paramadtj, boolean paramBoolean1, boolean paramBoolean2, int paramInt, boolean paramBoolean3, boolean paramBoolean4)
  {
    if (paramadtj != null)
    {
      Object localObject1 = (MessageForLightVideo)paramadtj.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
      String str1 = ShortVideoUtils.a(((MessageForLightVideo)localObject1).thumbMD5, "jpg");
      String str2 = ShortVideoUtils.a((MessageForShortVideo)localObject1, "mp4");
      if ((this.k == 0) || (this.l == 0))
      {
        localObject2 = BaseApplicationImpl.getContext().getResources();
        this.k = actj.a(160.0F, (Resources)localObject2);
        this.l = actj.a(160.0F, (Resources)localObject2);
        if (QLog.isColorLevel()) {
          QLog.d("LightVideoItemBuilder", 2, "getURLDrawableByMsg w:" + this.k + " ,h:" + this.l + " ,uniseq:" + ((MessageForLightVideo)localObject1).uniseq);
        }
      }
      if ((this.jdField_a_of_type_ComTencentImageURLDrawable == null) || (!this.jdField_a_of_type_ComTencentImageURLDrawable.getURL().getPath().equals(str1))) {
        this.jdField_a_of_type_ComTencentImageURLDrawable = arql.a(str1, this.k, this.l);
      }
      Object localObject2 = arql.a(str2, str1, ((MessageForLightVideo)localObject1).uniseq, this.k, this.l, paramBoolean1, paramBoolean2, paramBoolean4, paramInt, this, this.jdField_a_of_type_ComTencentImageURLDrawable);
      paramadtj.jdField_a_of_type_ComTencentMobileqqActivityAioItemLightVideoItemBuilder$ChatVideoView.setURLDrawable((URLDrawable)localObject2);
      if (paramBoolean3)
      {
        localObject2 = (URLDrawable)paramadtj.jdField_a_of_type_ComTencentMobileqqActivityAioItemLightVideoItemBuilder$ChatVideoView.getDrawable();
        if ((((URLDrawable)localObject2).getStatus() == 1) && ((((URLDrawable)localObject2).getCurrDrawable() instanceof QQLiveDrawable)))
        {
          ((QQLiveDrawable)((URLDrawable)localObject2).getCurrDrawable()).release();
          localObject1 = arql.a(str2, str1, ((MessageForLightVideo)localObject1).uniseq, this.k, this.l, paramBoolean1, paramBoolean2, paramBoolean4, paramInt, this, this.jdField_a_of_type_ComTencentImageURLDrawable);
          paramadtj.jdField_a_of_type_ComTencentMobileqqActivityAioItemLightVideoItemBuilder$ChatVideoView.setURLDrawable((URLDrawable)localObject1);
          if (QLog.isColorLevel()) {
            QLog.d("LightVideoItemBuilder", 2, "refreshVideo needRelease uniseq:" + paramadtj.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
          }
        }
      }
    }
  }
  
  private void a(AudioPlayer paramAudioPlayer, adtj paramadtj, int paramInt)
  {
    if ((paramadtj == null) || (paramAudioPlayer == null)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("LightVideoItemBuilder", 2, "refreshVideoWithEarModeJudge! uniseq:" + paramadtj.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq + " ,loudSpeaker:" + arql.a + " ,position:" + paramInt);
    }
    try
    {
      paramAudioPlayer.b();
      if (arql.a)
      {
        if (paramAudioPlayer.a()) {
          paramAudioPlayer.c();
        }
        a(paramadtj, false, false, paramInt, true, false);
        return;
      }
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        localIOException.printStackTrace();
      }
      a(paramadtj, false, true, paramInt, true, false);
      paramAudioPlayer.a(ShortVideoUtils.a((MessageForShortVideo)paramadtj.jdField_a_of_type_ComTencentMobileqqDataChatMessage, "mp4"), paramInt + 1000);
    }
  }
  
  private void a(LightVideoItemBuilder.ChatVideoView paramChatVideoView, String paramString, int paramInt1, int paramInt2)
  {
    if (paramChatVideoView.a(paramString)) {
      paramChatVideoView.setURLDrawable(arql.a(paramString, paramInt2, paramInt1));
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
  
  private boolean a(MessageForLightVideo paramMessageForLightVideo, adtj paramadtj)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LightVideoItemBuilder", 2, "startUploadVideo! uniseq:" + paramMessageForLightVideo.uniseq);
    }
    String str1 = paramMessageForLightVideo.videoFileName;
    String str2 = ShortVideoUtils.a(paramMessageForLightVideo.thumbMD5, "jpg");
    if (!bbdx.b(str1))
    {
      bcql.a(this.jdField_a_of_type_AndroidContentContext, 1, 2131719601, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298865));
      paramMessageForLightVideo.videoFileStatus = 1005;
      return false;
    }
    if (!bbdx.b(str2))
    {
      bcql.a(this.jdField_a_of_type_AndroidContentContext, 1, 2131719602, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298865));
      paramadtj.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
      paramMessageForLightVideo.videoFileStatus = 1005;
      return false;
    }
    paramMessageForLightVideo.mThumbFilePath = str2;
    paramadtj = awbh.a(paramMessageForLightVideo);
    paramadtj.i = paramMessageForLightVideo.videoFileName;
    paramadtj.f = paramMessageForLightVideo.mLocalMd5;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramadtj);
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
        if ((localObject != null) && (((adtj)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioItemLightVideoItemBuilder$ChatVideoView != null) && (((adtj)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioItemLightVideoItemBuilder$ChatVideoView.b != null) && (((adtj)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioItemLightVideoItemBuilder$ChatVideoView.b.getStatus() == 1) && ((((adtj)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioItemLightVideoItemBuilder$ChatVideoView.b.getCurrDrawable() instanceof QQLiveDrawable))) {
          if (paramBoolean) {
            ((QQLiveDrawable)((adtj)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioItemLightVideoItemBuilder$ChatVideoView.b.getCurrDrawable()).pause();
          } else {
            ((QQLiveDrawable)((adtj)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioItemLightVideoItemBuilder$ChatVideoView.b.getCurrDrawable()).resume();
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
  
  public acui a(View paramView)
  {
    if ((paramView != null) && (paramView.getParent() != null))
    {
      paramView = (adtj)((View)paramView.getParent()).getTag();
      if (paramView != null) {
        return paramView.jdField_a_of_type_ComTencentMobileqqActivityAioItemLightVideoItemBuilder$ChatVideoView;
      }
    }
    return null;
  }
  
  public acuj a()
  {
    return new adtj(this);
  }
  
  public adtj a(long paramLong)
  {
    if ((this.jdField_a_of_type_ComTencentWidgetListView != null) && (paramLong > 0L))
    {
      int m = actj.a(paramLong, this.jdField_a_of_type_ComTencentWidgetListView.getAdapter());
      int n = this.jdField_a_of_type_ComTencentWidgetListView.getHeaderViewsCount();
      int i1 = this.jdField_a_of_type_ComTencentWidgetListView.getFirstVisiblePosition();
      int i2 = this.jdField_a_of_type_ComTencentWidgetListView.getLastVisiblePosition();
      if (m <= -1) {
        break label223;
      }
      Object localObject = actj.a(this.jdField_a_of_type_ComTencentWidgetListView, m);
      if (localObject != null)
      {
        localObject = actj.a((View)localObject);
        if ((localObject != null) && ((localObject instanceof adtj))) {
          return (adtj)localObject;
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
  
  public View a(int paramInt1, int paramInt2, ChatMessage paramChatMessage, View paramView, ViewGroup paramViewGroup, acxj paramacxj)
  {
    paramViewGroup = super.a(paramInt1, paramInt2, paramChatMessage, paramView, paramViewGroup, paramacxj);
    a(paramChatMessage, paramView, this);
    return paramViewGroup;
  }
  
  public View a(ChatMessage paramChatMessage, acuj paramacuj, View paramView, BaseChatItemLayout paramBaseChatItemLayout, acxj paramacxj)
  {
    paramBaseChatItemLayout = (adtj)paramacuj;
    Object localObject2 = this.jdField_a_of_type_AndroidContentContext;
    Resources localResources = ((Context)localObject2).getResources();
    MessageForLightVideo localMessageForLightVideo = (MessageForLightVideo)paramChatMessage;
    paramacuj = paramView;
    if (paramView == null)
    {
      paramacuj = new RelativeLayout((Context)localObject2);
      paramView = new LightVideoItemBuilder.ChatVideoView((Context)localObject2);
      paramView.setId(2131371608);
      paramView.setScaleType(ImageView.ScaleType.CENTER_CROP);
      paramView.setRadius(15.0F);
      paramView.d(false);
      paramView.setSharpCornerCor(BubbleImageView.a);
      paramView.setContentDescription(ajya.a(2131706045));
      paramacuj.addView(paramView);
      MessageProgressView localMessageProgressView = new MessageProgressView((Context)localObject2);
      paramacuj.addView(localMessageProgressView);
      Object localObject3 = new LinearLayout((Context)localObject2);
      ((LinearLayout)localObject3).setOrientation(1);
      ((LinearLayout)localObject3).setGravity(17);
      Object localObject1 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject1).addRule(13);
      paramacuj.addView((View)localObject3, (ViewGroup.LayoutParams)localObject1);
      localObject1 = new TextView((Context)localObject2);
      Object localObject4 = new LinearLayout.LayoutParams(-2, -2);
      ((LinearLayout.LayoutParams)localObject4).topMargin = actj.a(70.0F, localResources);
      ((TextView)localObject1).setTextColor(-1);
      ((TextView)localObject1).setTextSize(2, 12.0F);
      ((TextView)localObject1).setId(2131364149);
      ((LinearLayout)localObject3).addView((View)localObject1, (ViewGroup.LayoutParams)localObject4);
      localObject2 = new LinearLayout((Context)localObject2);
      ((LinearLayout)localObject2).setOrientation(0);
      ((LinearLayout)localObject2).setGravity(16);
      ((LinearLayout)localObject2).setBackgroundResource(2130837924);
      ((LinearLayout)localObject2).setId(2131362311);
      ((LinearLayout)localObject2).setOnClickListener(new adtf(this));
      localObject3 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject3).addRule(8, 2131371608);
      ((RelativeLayout.LayoutParams)localObject3).bottomMargin = jdField_c_of_type_Int;
      ((RelativeLayout.LayoutParams)localObject3).addRule(5, 2131371608);
      ((RelativeLayout.LayoutParams)localObject3).leftMargin = jdField_c_of_type_Int;
      paramacuj.addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
      localObject3 = new ImageView(this.jdField_a_of_type_AndroidContentContext);
      ((ImageView)localObject3).setId(2131372933);
      ((ImageView)localObject3).setPadding(jdField_c_of_type_Int, d, d, d);
      ((LinearLayout)localObject2).addView((View)localObject3);
      localObject4 = new TextView(this.jdField_a_of_type_AndroidContentContext);
      ((TextView)localObject4).setId(2131372938);
      ((TextView)localObject4).setTextColor(-1);
      ((TextView)localObject4).setPadding(0, d, jdField_c_of_type_Int, d);
      ((LinearLayout)localObject2).addView((View)localObject4);
      paramacuj.setOnClickListener(this);
      paramacuj.setOnTouchListener(paramacxj);
      paramacuj.setOnLongClickListener(paramacxj);
      paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqActivityAioItemLightVideoItemBuilder$ChatVideoView = paramView;
      paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView = localMessageProgressView;
      paramBaseChatItemLayout.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localObject1);
      paramBaseChatItemLayout.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localObject3);
      paramBaseChatItemLayout.b = ((TextView)localObject4);
    }
    paramView = paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqActivityAioItemLightVideoItemBuilder$ChatVideoView;
    if (AppSetting.d)
    {
      paramacxj = new StringBuilder();
      paramacxj.append("轻量短视频 ");
      paramacxj.append(localMessageForLightVideo.videoFileTime);
      paramacxj.append("秒");
      if ((!localMessageForLightVideo.isSend()) && (!localMessageForLightVideo.isLightVideoRead)) {
        paramacxj.append(" 未播放");
      }
      paramView.setContentDescription(paramacxj.toString());
    }
    paramView.d = localMessageForLightVideo.isSend();
    paramView.setTag(Long.valueOf(localMessageForLightVideo.uniseq));
    bbbt.a().a(Long.valueOf(localMessageForLightVideo.uniseq), localMessageForLightVideo);
    paramBaseChatItemLayout.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setRadius(15.0F, true);
    paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setShowCorner(false);
    paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setSharpCornerCor(BubbleImageView.a);
    paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setCornerDirection(localMessageForLightVideo.isSend());
    paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.a(paramChatMessage.frienduin + paramChatMessage.uniseq);
    this.k = actj.a(160.0F, localResources);
    this.l = actj.a(160.0F, localResources);
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
      return paramacuj;
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
    return ajya.a(2131706068);
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
    arql.a().a(null);
    this.jdField_a_of_type_ComTencentImageURLDrawable = null;
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    MessageForLightVideo localMessageForLightVideo;
    if ((paramChatMessage != null) && ((paramChatMessage instanceof MessageForLightVideo)))
    {
      localMessageForLightVideo = (MessageForLightVideo)paramChatMessage;
      if (paramInt == 2131364984)
      {
        aanz.b(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localMessageForLightVideo);
        vei.a("story_grp", "press_msg", 0, 0, new String[] { "4", "", "", "" });
      }
    }
    else
    {
      return;
    }
    if (paramInt == 2131370536)
    {
      super.d(paramChatMessage);
      vei.a("story_grp", "press_msg", 0, 0, new String[] { "5", "", "", "" });
      return;
    }
    if (paramInt == 2131365928)
    {
      bgpu.a(localMessageForLightVideo).b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage).a((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
      bgqi.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 6, 5);
      bgqi.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 3, 0, paramChatMessage.istroop);
      vei.a("story_grp", "press_msg", 0, 0, new String[] { "2", "", "", "" });
      return;
    }
    if (paramInt == 2131370493)
    {
      if (c(paramChatMessage)) {
        MediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(true);
      }
      super.a(localMessageForLightVideo);
      vei.a("story_grp", "press_msg", 0, 0, new String[] { "3", "", "", "" });
      return;
    }
    if (paramInt == 2131364942)
    {
      paramContext = new StringBuilder();
      paramContext.append("uniseq:").append(localMessageForLightVideo.uniseq).append("\n");
      Toast.makeText(this.jdField_a_of_type_AndroidContentContext, paramContext.toString(), 1).show();
      return;
    }
    super.a(paramInt, paramContext, paramChatMessage);
  }
  
  protected void a(adtj paramadtj)
  {
    if (!paramadtj.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.a(paramadtj.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin + paramadtj.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq)) {
      paramadtj.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setVisibility(8);
    }
    for (;;)
    {
      paramadtj.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      if (QLog.isColorLevel()) {
        QLog.w("LightVideoItemBuilder", 2, "[hideProgress] set ProgressPieDrawable visible");
      }
      return;
      paramadtj.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setAnimRunnableListener(new adth(this, paramadtj));
    }
  }
  
  protected void a(adtj paramadtj, MessageForLightVideo paramMessageForLightVideo, int paramInt)
  {
    if (paramadtj == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("LightVideoItemBuilder", 2, String.format("handleVideoViewAnimStatus uniseq:%d, status:%d", new Object[] { Long.valueOf(paramMessageForLightVideo.uniseq), Integer.valueOf(paramInt) }));
    }
    paramadtj.b.setText(adwp.a(paramMessageForLightVideo.videoFileTime));
    paramadtj.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setUnread(false, null, null);
    paramMessageForLightVideo.videoStatus = paramInt;
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      if ((!paramMessageForLightVideo.isSend()) && (!paramMessageForLightVideo.isLightVideoRead)) {
        paramadtj.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setUnread(true, null, null);
      }
      paramadtj.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130840192);
      return;
    case 1: 
      a(paramMessageForLightVideo);
      paramMessageForLightVideo = (AnimationDrawable)this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130772069);
      paramadtj.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramMessageForLightVideo);
      paramMessageForLightVideo.start();
      return;
    case 2: 
      paramadtj.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130840189);
      return;
    }
    if ((!paramMessageForLightVideo.isSend()) && (!paramMessageForLightVideo.isLightVideoRead)) {
      paramadtj.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setUnread(true, null, null);
    }
    paramadtj.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130840189);
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    paramView = (adtj)actj.a(paramView);
    MessageForLightVideo localMessageForLightVideo = (MessageForLightVideo)paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
    if (!localMessageForLightVideo.isSendFromLocal()) {
      return;
    }
    bfpc localbfpc = (bfpc)bfpp.a(this.jdField_a_of_type_AndroidContentContext, null);
    localbfpc.a(2131689995, 5);
    localbfpc.c(2131690596);
    localbfpc.a(new adtg(this, localMessageForLightVideo, paramView, localbfpc));
    localbfpc.show();
  }
  
  public void a(View paramView, ayqo paramayqo, int paramInt1, int paramInt2)
  {
    paramView = (adtj)actj.a(paramView);
    MessageForLightVideo localMessageForLightVideo = (MessageForLightVideo)paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
    if (localMessageForLightVideo.uniseq != paramayqo.jdField_b_of_type_Long) {}
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
            m = actj.a(paramInt1, (Resources)localObject);
            n = actj.a(paramInt2, (Resources)localObject);
            if ((paramayqo.jdField_b_of_type_Int != 327689) && (paramayqo.jdField_b_of_type_Int != 6) && (paramayqo.jdField_b_of_type_Int != 17) && (paramayqo.jdField_b_of_type_Int != 9)) {
              break label846;
            }
            switch (paramayqo.d)
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
          paramayqo = ShortVideoUtils.a(localMessageForLightVideo, "mp4");
          boolean bool = bbdx.b(paramayqo);
          a(localMessageForLightVideo, "VIDEO STATUS_SEND_FINISHED ,videofile:" + paramayqo + " ,videoexist:" + bool);
          if (bool)
          {
            a(paramView, localMessageForLightVideo, localChatVideoView);
            a(localMessageForLightVideo, paramView, 100, true);
          }
          c(localMessageForLightVideo);
          return;
          a(localMessageForLightVideo, "VIDEO STATUS_SEND_ERROR");
          c(localMessageForLightVideo);
          b(localMessageForLightVideo, paramView, 2131718795);
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
          b(localMessageForLightVideo, paramView, 2131718789);
          if (localMessageForLightVideo.uiOperatorFlag == 2)
          {
            paramView.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
            bcql.a(this.jdField_a_of_type_AndroidContentContext, 2131719569, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298865));
            return;
          }
          bcql.a(this.jdField_a_of_type_AndroidContentContext, 2131719594, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298865));
          return;
          a(localMessageForLightVideo, "VIDEO STATUS_RECV_ERROR");
          a(paramView);
          a(localMessageForLightVideo, paramView);
          bcql.a(this.jdField_a_of_type_AndroidContentContext, 2131719596, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298865));
          return;
          a(localMessageForLightVideo, "VIDEO STATUS_FILE_EXPIRED");
          paramayqo = ShortVideoUtils.a(localMessageForLightVideo.thumbMD5, "jpg");
          if (bbdx.b(paramayqo)) {
            a(localChatVideoView, paramayqo, paramInt2, paramInt1);
          }
          b(localMessageForLightVideo, paramView, 2131718790);
          return;
          a(localMessageForLightVideo, "VIDEO STATUS_RECV_CANCEL");
          return;
          paramInt1 = localMessageForLightVideo.videoFileProgress;
          a(localMessageForLightVideo, "VIDEO STATUS_RECV_PROCESS " + paramInt1);
          a(localMessageForLightVideo, paramView, paramInt1, true);
          return;
        } while ((paramayqo.jdField_b_of_type_Int != 7) && (paramayqo.jdField_b_of_type_Int != 18) && (paramayqo.jdField_b_of_type_Int != 16));
        switch (paramayqo.d)
        {
        default: 
          return;
        case 2001: 
          a(localMessageForLightVideo, "THUMB STATUS_RECV_START");
          return;
        case 2003: 
          a(localMessageForLightVideo, "THUMB STATUS_RECV_FINISHED");
          paramayqo = ShortVideoUtils.a(localMessageForLightVideo.thumbMD5, "jpg");
          localObject = ShortVideoUtils.a(localMessageForLightVideo, "mp4");
          if ((!bbdx.b((String)localObject)) || (!axfa.b)) {
            break label1044;
          }
          a(localMessageForLightVideo, ajya.a(2131706059) + paramayqo);
        }
      } while (!ShortVideoUtils.a());
      paramayqo = arql.a((String)localObject, paramayqo, localMessageForLightVideo.uniseq, paramInt1, paramInt2, false, true, false, 0, this, null);
      paramView.jdField_a_of_type_ComTencentMobileqqActivityAioItemLightVideoItemBuilder$ChatVideoView.setURLDrawable(paramayqo);
      b(paramView);
      return;
      if (!bbdx.b(paramayqo)) {
        break;
      }
    } while (!localChatVideoView.a(paramayqo));
    label1044:
    a(localMessageForLightVideo, ajya.a(2131706063) + paramayqo);
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mRequestWidth = m;
    localURLDrawableOptions.mRequestHeight = n;
    localURLDrawableOptions.mLoadingDrawable = jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
    localURLDrawableOptions.mFailedDrawable = jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
    localChatVideoView.setURLDrawable(URLDrawable.getDrawable(new File(paramayqo), localURLDrawableOptions));
    if (!bbdx.b((String)localObject))
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
    localChatVideoView.setImageDrawable(aywm.a());
    return;
    a(localMessageForLightVideo, "THUMB STATUS_FILE_EXPIRED");
    a(localMessageForLightVideo, "THUMB STATUS_RECV_ERROR");
    paramayqo = ShortVideoUtils.a(localMessageForLightVideo, "mp4");
    if (bbdx.b(paramayqo)) {
      if (localChatVideoView.a(paramayqo))
      {
        a(localMessageForLightVideo, ajya.a(2131706049) + paramayqo);
        if (ShortVideoUtils.a())
        {
          paramayqo = arql.a(paramayqo, ShortVideoUtils.a(localMessageForLightVideo.thumbMD5, "jpg"), localMessageForLightVideo.uniseq, paramInt1, paramInt2, false, true, false, 0, this, null);
          paramView.jdField_a_of_type_ComTencentMobileqqActivityAioItemLightVideoItemBuilder$ChatVideoView.setURLDrawable(paramayqo);
          b(paramView);
        }
      }
    }
    for (;;)
    {
      a(paramView);
      return;
      paramayqo = localChatVideoView.b;
      if ((paramayqo != null) && (paramayqo.getStatus() == 1))
      {
        localChatVideoView.setURLDrawable(paramayqo);
        continue;
        localChatVideoView.setImageDrawable(jdField_a_of_type_AndroidGraphicsDrawableColorDrawable);
      }
    }
  }
  
  public void a(View paramView, ChatMessage paramChatMessage)
  {
    int m = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131296294);
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
      paramMessageForLightVideo.saveExtInfoToExtStr(axaf.u, "1");
      ThreadManager.post(new LightVideoItemBuilder.2(this, paramMessageForLightVideo), 10, null, false);
    }
  }
  
  void a(MessageForLightVideo paramMessageForLightVideo, adtj paramadtj)
  {
    paramadtj.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.b(paramMessageForLightVideo.frienduin + paramMessageForLightVideo.uniseq);
    paramadtj.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setDrawStatus(2);
    paramadtj.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setVisibility(0);
    paramadtj.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    if (QLog.isColorLevel()) {
      QLog.w("LightVideoItemBuilder", 2, "[showPauseProgress] uinseq:" + paramMessageForLightVideo.uniseq);
    }
  }
  
  void a(MessageForLightVideo paramMessageForLightVideo, adtj paramadtj, int paramInt)
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
    a(paramMessageForLightVideo, paramadtj, paramInt, true);
  }
  
  protected void a(MessageForLightVideo paramMessageForLightVideo, adtj paramadtj, int paramInt, boolean paramBoolean)
  {
    paramadtj.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setDrawStatus(1);
    paramadtj.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setAnimProgress(paramInt, paramMessageForLightVideo.frienduin + paramMessageForLightVideo.uniseq);
    paramadtj.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setVisibility(0);
    paramadtj.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    if (QLog.isColorLevel()) {
      QLog.w("LightVideoItemBuilder", 2, "[setProgress] uinseq:" + paramMessageForLightVideo.uniseq + ", p:" + paramInt);
    }
  }
  
  void a(MessageForLightVideo paramMessageForLightVideo, boolean paramBoolean)
  {
    if (paramMessageForLightVideo.videoFileStatus == 5002)
    {
      a(paramMessageForLightVideo, ajya.a(2131706066));
      return;
    }
    axei localaxei = axdq.a(2, 2);
    axdt localaxdt = paramMessageForLightVideo.getDownloadInfo(localaxei.jdField_b_of_type_Int);
    localaxdt.h = ShortVideoUtils.a(paramMessageForLightVideo, "mp4");
    localaxdt.a(paramMessageForLightVideo.istroop, 0);
    if (paramBoolean) {}
    for (int m = 2;; m = 1)
    {
      localaxdt.f = m;
      localaxdt.g = 2;
      if (QLog.isColorLevel()) {
        QLog.d("LightVideoItemBuilder", 2, " startDownloadVideo downloadvideo fileType==" + localaxdt.e + ", uniseq:" + paramMessageForLightVideo.uniseq);
      }
      localaxei.a(localaxdt);
      localaxei.a(paramMessageForLightVideo);
      axdq.a(localaxei, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
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
    paramXListView = (adtj)actj.a(paramView);
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
        a(paramView, ShortVideoUtils.a(paramChatMessage.thumbMD5, "jpg"), actj.a(160.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), actj.a(160.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
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
    adtj localadtj;
    if ((localChatMessage != null) && ((localChatMessage instanceof MessageForLightVideo)))
    {
      localadtj = a(localChatMessage.uniseq);
      if (localadtj != null) {
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
      } while ((localadtj.jdField_a_of_type_ComTencentMobileqqActivityAioItemLightVideoItemBuilder$ChatVideoView == null) || (localadtj.jdField_a_of_type_ComTencentMobileqqActivityAioItemLightVideoItemBuilder$ChatVideoView.b == null) || (localadtj.jdField_a_of_type_ComTencentMobileqqActivityAioItemLightVideoItemBuilder$ChatVideoView.b.getStatus() != 1) || (!(localadtj.jdField_a_of_type_ComTencentMobileqqActivityAioItemLightVideoItemBuilder$ChatVideoView.b.getCurrDrawable() instanceof QQLiveDrawable)));
      m = (int)((QQLiveDrawable)localadtj.jdField_a_of_type_ComTencentMobileqqActivityAioItemLightVideoItemBuilder$ChatVideoView.b.getCurrDrawable()).getCurrentPosition();
      a(this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer, localadtj, m - 1000);
    } while (!QLog.isColorLevel());
    QLog.d("LightVideoItemBuilder", 2, String.format("onNearToEar usingLoudSpeaker:%s, position:%d, duration:%d, uniseq:%d", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(m), Integer.valueOf(((MessageForShortVideo)localadtj.jdField_a_of_type_ComTencentMobileqqDataChatMessage).videoFileTime), Long.valueOf(localadtj.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq) }));
  }
  
  protected boolean a(adtj paramadtj, MessageForLightVideo paramMessageForLightVideo, LightVideoItemBuilder.ChatVideoView paramChatVideoView)
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
        if (bbdx.b((String)localObject2)) {
          break label113;
        }
        if (!TextUtils.isEmpty(paramMessageForLightVideo.thumbMD5)) {
          break label102;
        }
        paramChatVideoView.setImageDrawable(aywm.a());
        a(paramadtj);
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
      a(paramMessageForLightVideo, paramadtj, paramMessageForLightVideo.videoFileProgress, true);
      return false;
    }
    Object localObject1 = ShortVideoUtils.a(paramMessageForLightVideo.thumbMD5, "jpg");
    Object localObject2 = ShortVideoUtils.a(paramMessageForLightVideo, "mp4");
    boolean bool3 = bbdx.b((String)localObject1);
    bool1 = bbdx.b((String)localObject2);
    if (QLog.isColorLevel()) {
      QLog.d("LightVideoItemBuilder", 2, String.format("handleVideoFileStatus uniseq:%d, thumb:%s, videofile:%s", new Object[] { Long.valueOf(paramMessageForLightVideo.uniseq), Boolean.valueOf(bool3), Boolean.valueOf(bool1) }));
    }
    if (bool1)
    {
      paramadtj.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setVisibility(8);
      if ((!paramMessageForLightVideo.isSendFromLocal()) || (paramMessageForLightVideo.isStatusReady())) {
        if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForLightVideo != null) && (this.jdField_a_of_type_ComTencentMobileqqDataMessageForLightVideo.videoStatus == 1))
        {
          bool1 = true;
          label393:
          a(paramadtj, true, true, 0, false, bool1);
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
        a(paramMessageForLightVideo, paramadtj);
      }
      if (paramMessageForLightVideo.videoFileStatus == 5002)
      {
        a(paramMessageForLightVideo, ajya.a(2131706072));
        b(paramMessageForLightVideo, paramadtj, 2131718790);
        return false;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramMessageForLightVideo, true))
      {
        a(paramMessageForLightVideo, true);
        return false;
      }
      if ((paramMessageForLightVideo.videoFileStatus == 2001) || (paramMessageForLightVideo.videoFileStatus == 2002) || (paramMessageForLightVideo.videoFileStatus == 2000))
      {
        a(paramMessageForLightVideo, paramadtj, paramMessageForLightVideo.videoFileProgress, false);
        return false;
      }
      a(paramMessageForLightVideo, paramadtj);
      return true;
    }
    if (paramMessageForLightVideo.videoFileStatus == 5002)
    {
      a(paramMessageForLightVideo, ajya.a(2131706046));
      paramChatVideoView.setImageDrawable(jdField_a_of_type_AndroidGraphicsDrawableColorDrawable);
      b(paramMessageForLightVideo, paramadtj, 2131718790);
      return false;
    }
    a(paramMessageForLightVideo, ajya.a(2131706052));
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
      if ((paramBaseChatItemLayout instanceof aypb))
      {
        if (((aypb)paramBaseChatItemLayout).c() == 1005L) {}
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
    paramXListView = (adtj)actj.a(paramView);
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
  
  public bbmh[] a(View paramView)
  {
    bbmf localbbmf = new bbmf();
    paramView = (adtj)actj.a(paramView);
    MessageForLightVideo localMessageForLightVideo = (MessageForLightVideo)paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
    if ((!TextUtils.isEmpty(localMessageForLightVideo.md5)) && (bbdx.b(ShortVideoUtils.a(localMessageForLightVideo.thumbMD5, "jpg")))) {
      if ((paramView.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.c == null) || (paramView.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.c.getVisibility() != 0)) {
        break label125;
      }
    }
    label125:
    for (int m = 1;; m = 0)
    {
      if (m == 0) {
        a(localbbmf, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, localMessageForLightVideo);
      }
      a(localbbmf, localMessageForLightVideo);
      super.c(localbbmf, this.jdField_a_of_type_AndroidContentContext);
      super.e(localbbmf, this.jdField_a_of_type_AndroidContentContext);
      return localbbmf.a();
    }
  }
  
  protected void b(adtj paramadtj)
  {
    if (!paramadtj.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.a(paramadtj.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin + paramadtj.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq))
    {
      paramadtj.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setVisibility(8);
      return;
    }
    paramadtj.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setAnimRunnableListener(new adti(this, paramadtj));
  }
  
  void b(MessageForLightVideo paramMessageForLightVideo)
  {
    axei localaxei = axdq.a(2, 2);
    axdt localaxdt = paramMessageForLightVideo.getDownloadInfo(localaxei.jdField_b_of_type_Int);
    localaxdt.i = ShortVideoUtils.a(paramMessageForLightVideo.thumbMD5, "jpg");
    localaxdt.a(paramMessageForLightVideo.istroop, 1);
    localaxdt.f = 2;
    localaxdt.g = 2;
    localaxei.a(localaxdt);
    localaxei.a(paramMessageForLightVideo);
    axdq.a(localaxei, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
  }
  
  void b(MessageForLightVideo paramMessageForLightVideo, adtj paramadtj, int paramInt)
  {
    paramadtj.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.b(paramMessageForLightVideo.frienduin + paramMessageForLightVideo.uniseq);
    paramadtj.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setVisibility(0);
    paramadtj.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setImageResource(2130848699);
    paramadtj.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setDrawStatus(3);
    paramadtj.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    paramadtj.jdField_a_of_type_AndroidWidgetTextView.setText(paramInt);
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
    adtj localadtj = (adtj)actj.a(paramView);
    if (localadtj == null) {}
    MessageForLightVideo localMessageForLightVideo;
    do
    {
      do
      {
        return;
        localMessageForLightVideo = (MessageForLightVideo)localadtj.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
        if (QLog.isColorLevel()) {
          QLog.d("LightVideoItemBuilder", 2, "onClick! uniseq:" + localMessageForLightVideo.uniseq);
        }
      } while (paramView.getId() == 2131364151);
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c())
      {
        bcql.a(this.jdField_a_of_type_AndroidContentContext, 2131696182, 1).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298865));
        return;
      }
      if ((paramView.getId() != 2131364109) && (paramView.getId() != 2131362311)) {
        break;
      }
    } while (localMessageForLightVideo.md5 == null);
    if (c(localMessageForLightVideo))
    {
      a(localadtj, localMessageForLightVideo, 2);
      MediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(false);
    }
    for (;;)
    {
      super.onClick(paramView);
      return;
      String str = ShortVideoUtils.a(localMessageForLightVideo.thumbMD5, "jpg");
      if (!bbdx.b(ShortVideoUtils.a(localMessageForLightVideo, "mp4")))
      {
        a(localMessageForLightVideo, false);
        a(localMessageForLightVideo, localadtj, localMessageForLightVideo.videoFileProgress, false);
        this.jdField_c_of_type_Long = localMessageForLightVideo.uniseq;
        this.j = 0;
      }
      else if (bbdx.b(str))
      {
        axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800561C", "0X800561C", 0, 0, "", "", "", "");
        if (TVK_SDKMgr.isInstalled(this.jdField_a_of_type_AndroidContentContext))
        {
          if (!MediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(actj.a(paramView))) {
            bcql.a(this.jdField_a_of_type_AndroidContentContext, 1, 2131695521, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298865));
          }
        }
        else {
          bcql.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131697981), 0).b(BaseApplicationImpl.getApplication().getResources().getDimensionPixelSize(2131298865));
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
      paramString = bbbt.a().a(Long.valueOf(paramQQLiveDrawableParams.msgUniseq));
      if ((paramString != null) && (!bbbt.a().a(Long.valueOf(paramQQLiveDrawableParams.msgUniseq))))
      {
        ShortVideoUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "0X8008E51", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramString, this.jdField_a_of_type_AndroidContentContext);
        if (!bbbt.a().b(Long.valueOf(paramString.uniseq)))
        {
          bbbt.a().a(Long.valueOf(paramString.uniseq));
          ShortVideoUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "0X8008E50", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramString, this.jdField_a_of_type_AndroidContentContext);
        }
        bbbt.a().a(Long.valueOf(paramQQLiveDrawableParams.msgUniseq), true);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.LightVideoItemBuilder
 * JD-Core Version:    0.7.0.1
 */