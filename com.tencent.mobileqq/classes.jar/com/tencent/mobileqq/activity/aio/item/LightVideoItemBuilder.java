package com.tencent.mobileqq.activity.aio.item;

import aael;
import aciy;
import acjt;
import acju;
import aclm;
import acmr;
import acmv;
import adif;
import adig;
import adih;
import adii;
import adij;
import adik;
import adlr;
import admg;
import ajjy;
import akhu;
import amym;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.ColorDrawable;
import android.os.Build.VERSION;
import android.os.Environment;
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
import aqut;
import aquu;
import avbm;
import awav;
import aweg;
import awei;
import awej;
import awer;
import awey;
import awfq;
import awqx;
import axou;
import axqf;
import axvo;
import axwd;
import baab;
import bace;
import bakh;
import bakj;
import bbmy;
import begr;
import behe;
import bfhl;
import bfhz;
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
import mqq.app.AppActivity;
import urp;

public class LightVideoItemBuilder
  extends admg
  implements aclm, acmr, aquu, awei, QQLiveDrawable.OnStateListener
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
    g = Math.min(aciy.a(320.0F, localResources), g);
    h = aciy.a(100.0F, localResources);
    i = aciy.a(100.0F, localResources);
    e = aciy.a(160.0F, localResources);
    f = aciy.a(160.0F, localResources);
    jdField_a_of_type_AndroidGraphicsDrawableColorDrawable = new amym(-10065297, e, f);
    jdField_c_of_type_Int = aciy.a(8.0F, localResources);
    d = aciy.a(3.0F, localResources);
  }
  
  public LightVideoItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    if (paramAIOAnimationConatiner != null) {
      this.jdField_a_of_type_ComTencentWidgetListView = paramAIOAnimationConatiner.a();
    }
    aqut.a().a(this);
  }
  
  private void a(adik paramadik, MessageForLightVideo paramMessageForLightVideo, LightVideoItemBuilder.ChatVideoView paramChatVideoView)
  {
    if (c(paramMessageForLightVideo))
    {
      a(paramadik, false, false, 0, false, false);
      a(paramadik, paramMessageForLightVideo, 1);
    }
    do
    {
      return;
      if (d(paramMessageForLightVideo))
      {
        paramChatVideoView = ShortVideoUtils.a(paramMessageForLightVideo.thumbMD5, "jpg");
        a(paramadik.jdField_a_of_type_ComTencentMobileqqActivityAioItemLightVideoItemBuilder$ChatVideoView, paramChatVideoView, this.l, this.k);
        a(paramadik, paramMessageForLightVideo, 2);
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
        a(this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer, paramadik, 0);
        a(paramadik, paramMessageForLightVideo, 1);
        this.j = 0;
        this.jdField_c_of_type_Long = 0L;
        return;
      }
    } while (MediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(paramMessageForLightVideo));
    bbmy.a(this.jdField_a_of_type_AndroidContentContext, 1, 2131629839, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131167766));
    return;
    if (a(paramadik, paramMessageForLightVideo, paramChatVideoView))
    {
      a(paramadik, paramMessageForLightVideo, 3);
      return;
    }
    a(paramadik, paramMessageForLightVideo, 0);
  }
  
  private void a(adik paramadik, boolean paramBoolean1, boolean paramBoolean2, int paramInt, boolean paramBoolean3, boolean paramBoolean4)
  {
    if (paramadik != null)
    {
      Object localObject1 = (MessageForLightVideo)paramadik.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
      String str1 = ShortVideoUtils.a(((MessageForLightVideo)localObject1).thumbMD5, "jpg");
      String str2 = ShortVideoUtils.a((MessageForShortVideo)localObject1, "mp4");
      if ((this.k == 0) || (this.l == 0))
      {
        localObject2 = BaseApplicationImpl.getContext().getResources();
        this.k = aciy.a(160.0F, (Resources)localObject2);
        this.l = aciy.a(160.0F, (Resources)localObject2);
        if (QLog.isColorLevel()) {
          QLog.d("LightVideoItemBuilder", 2, "getURLDrawableByMsg w:" + this.k + " ,h:" + this.l + " ,uniseq:" + ((MessageForLightVideo)localObject1).uniseq);
        }
      }
      if ((this.jdField_a_of_type_ComTencentImageURLDrawable == null) || (!this.jdField_a_of_type_ComTencentImageURLDrawable.getURL().getPath().equals(str1))) {
        this.jdField_a_of_type_ComTencentImageURLDrawable = aqut.a(str1, this.k, this.l);
      }
      Object localObject2 = aqut.a(str2, str1, ((MessageForLightVideo)localObject1).uniseq, this.k, this.l, paramBoolean1, paramBoolean2, paramBoolean4, paramInt, this, this.jdField_a_of_type_ComTencentImageURLDrawable);
      paramadik.jdField_a_of_type_ComTencentMobileqqActivityAioItemLightVideoItemBuilder$ChatVideoView.setURLDrawable((URLDrawable)localObject2);
      if (paramBoolean3)
      {
        localObject2 = (URLDrawable)paramadik.jdField_a_of_type_ComTencentMobileqqActivityAioItemLightVideoItemBuilder$ChatVideoView.getDrawable();
        if ((((URLDrawable)localObject2).getStatus() == 1) && ((((URLDrawable)localObject2).getCurrDrawable() instanceof QQLiveDrawable)))
        {
          ((QQLiveDrawable)((URLDrawable)localObject2).getCurrDrawable()).release();
          localObject1 = aqut.a(str2, str1, ((MessageForLightVideo)localObject1).uniseq, this.k, this.l, paramBoolean1, paramBoolean2, paramBoolean4, paramInt, this, this.jdField_a_of_type_ComTencentImageURLDrawable);
          paramadik.jdField_a_of_type_ComTencentMobileqqActivityAioItemLightVideoItemBuilder$ChatVideoView.setURLDrawable((URLDrawable)localObject1);
          if (QLog.isColorLevel()) {
            QLog.d("LightVideoItemBuilder", 2, "refreshVideo needRelease uniseq:" + paramadik.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
          }
        }
      }
    }
  }
  
  private void a(AudioPlayer paramAudioPlayer, adik paramadik, int paramInt)
  {
    if ((paramadik == null) || (paramAudioPlayer == null)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("LightVideoItemBuilder", 2, "refreshVideoWithEarModeJudge! uniseq:" + paramadik.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq + " ,loudSpeaker:" + aqut.a + " ,position:" + paramInt);
    }
    try
    {
      paramAudioPlayer.b();
      if (aqut.a)
      {
        if (paramAudioPlayer.a()) {
          paramAudioPlayer.c();
        }
        a(paramadik, false, false, paramInt, true, false);
        return;
      }
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        localIOException.printStackTrace();
      }
      a(paramadik, false, true, paramInt, true, false);
      paramAudioPlayer.a(ShortVideoUtils.a((MessageForShortVideo)paramadik.jdField_a_of_type_ComTencentMobileqqDataChatMessage, "mp4"), paramInt + 1000);
    }
  }
  
  private void a(LightVideoItemBuilder.ChatVideoView paramChatVideoView, String paramString, int paramInt1, int paramInt2)
  {
    if (paramChatVideoView.a(paramString)) {
      paramChatVideoView.setURLDrawable(aqut.a(paramString, paramInt2, paramInt1));
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
  
  private boolean a(MessageForLightVideo paramMessageForLightVideo, adik paramadik)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LightVideoItemBuilder", 2, "startUploadVideo! uniseq:" + paramMessageForLightVideo.uniseq);
    }
    String str1 = paramMessageForLightVideo.videoFileName;
    String str2 = ShortVideoUtils.a(paramMessageForLightVideo.thumbMD5, "jpg");
    if (!bace.b(str1))
    {
      bbmy.a(this.jdField_a_of_type_AndroidContentContext, 1, 2131653706, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131167766));
      paramMessageForLightVideo.videoFileStatus = 1005;
      return false;
    }
    if (!bace.b(str2))
    {
      bbmy.a(this.jdField_a_of_type_AndroidContentContext, 1, 2131653707, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131167766));
      paramadik.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
      paramMessageForLightVideo.videoFileStatus = 1005;
      return false;
    }
    paramMessageForLightVideo.mThumbFilePath = str2;
    paramadik = avbm.a(paramMessageForLightVideo);
    paramadik.i = paramMessageForLightVideo.videoFileName;
    paramadik.f = paramMessageForLightVideo.mLocalMd5;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramadik);
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
        if ((localObject != null) && (((adik)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioItemLightVideoItemBuilder$ChatVideoView != null) && (((adik)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioItemLightVideoItemBuilder$ChatVideoView.b != null) && (((adik)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioItemLightVideoItemBuilder$ChatVideoView.b.getStatus() == 1) && ((((adik)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioItemLightVideoItemBuilder$ChatVideoView.b.getCurrDrawable() instanceof QQLiveDrawable))) {
          if (paramBoolean) {
            ((QQLiveDrawable)((adik)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioItemLightVideoItemBuilder$ChatVideoView.b.getCurrDrawable()).pause();
          } else {
            ((QQLiveDrawable)((adik)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioItemLightVideoItemBuilder$ChatVideoView.b.getCurrDrawable()).resume();
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
  
  public acjt a(View paramView)
  {
    if ((paramView != null) && (paramView.getParent() != null))
    {
      paramView = (adik)((View)paramView.getParent()).getTag();
      if (paramView != null) {
        return paramView.jdField_a_of_type_ComTencentMobileqqActivityAioItemLightVideoItemBuilder$ChatVideoView;
      }
    }
    return null;
  }
  
  public acju a()
  {
    return new adik(this);
  }
  
  public adik a(long paramLong)
  {
    if ((this.jdField_a_of_type_ComTencentWidgetListView != null) && (paramLong > 0L))
    {
      int m = aciy.a(paramLong, this.jdField_a_of_type_ComTencentWidgetListView.getAdapter());
      int n = this.jdField_a_of_type_ComTencentWidgetListView.getHeaderViewsCount();
      int i1 = this.jdField_a_of_type_ComTencentWidgetListView.getFirstVisiblePosition();
      int i2 = this.jdField_a_of_type_ComTencentWidgetListView.getLastVisiblePosition();
      if (m <= -1) {
        break label223;
      }
      Object localObject = aciy.a(this.jdField_a_of_type_ComTencentWidgetListView, m);
      if (localObject != null)
      {
        localObject = aciy.a((View)localObject);
        if ((localObject != null) && ((localObject instanceof adik))) {
          return (adik)localObject;
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
  
  public View a(int paramInt1, int paramInt2, ChatMessage paramChatMessage, View paramView, ViewGroup paramViewGroup, acmv paramacmv)
  {
    paramViewGroup = super.a(paramInt1, paramInt2, paramChatMessage, paramView, paramViewGroup, paramacmv);
    a(paramChatMessage, paramView, this);
    return paramViewGroup;
  }
  
  public View a(ChatMessage paramChatMessage, acju paramacju, View paramView, BaseChatItemLayout paramBaseChatItemLayout, acmv paramacmv)
  {
    paramBaseChatItemLayout = (adik)paramacju;
    Object localObject2 = this.jdField_a_of_type_AndroidContentContext;
    Resources localResources = ((Context)localObject2).getResources();
    MessageForLightVideo localMessageForLightVideo = (MessageForLightVideo)paramChatMessage;
    paramacju = paramView;
    if (paramView == null)
    {
      paramacju = new RelativeLayout((Context)localObject2);
      paramView = new LightVideoItemBuilder.ChatVideoView((Context)localObject2);
      paramView.setId(2131305912);
      paramView.setScaleType(ImageView.ScaleType.CENTER_CROP);
      paramView.setRadius(15.0F);
      paramView.d(false);
      paramView.setSharpCornerCor(BubbleImageView.a);
      paramView.setContentDescription(ajjy.a(2131640249));
      paramacju.addView(paramView);
      MessageProgressView localMessageProgressView = new MessageProgressView((Context)localObject2);
      paramacju.addView(localMessageProgressView);
      Object localObject3 = new LinearLayout((Context)localObject2);
      ((LinearLayout)localObject3).setOrientation(1);
      ((LinearLayout)localObject3).setGravity(17);
      Object localObject1 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject1).addRule(13);
      paramacju.addView((View)localObject3, (ViewGroup.LayoutParams)localObject1);
      localObject1 = new TextView((Context)localObject2);
      Object localObject4 = new LinearLayout.LayoutParams(-2, -2);
      ((LinearLayout.LayoutParams)localObject4).topMargin = aciy.a(70.0F, localResources);
      ((TextView)localObject1).setTextColor(-1);
      ((TextView)localObject1).setTextSize(2, 12.0F);
      ((TextView)localObject1).setId(2131298592);
      ((LinearLayout)localObject3).addView((View)localObject1, (ViewGroup.LayoutParams)localObject4);
      localObject2 = new LinearLayout((Context)localObject2);
      ((LinearLayout)localObject2).setOrientation(0);
      ((LinearLayout)localObject2).setGravity(16);
      ((LinearLayout)localObject2).setBackgroundResource(2130837915);
      ((LinearLayout)localObject2).setId(2131296771);
      ((LinearLayout)localObject2).setOnClickListener(new adif(this));
      localObject3 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject3).addRule(8, 2131305912);
      ((RelativeLayout.LayoutParams)localObject3).bottomMargin = jdField_c_of_type_Int;
      ((RelativeLayout.LayoutParams)localObject3).addRule(5, 2131305912);
      ((RelativeLayout.LayoutParams)localObject3).leftMargin = jdField_c_of_type_Int;
      paramacju.addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
      localObject3 = new ImageView(this.jdField_a_of_type_AndroidContentContext);
      ((ImageView)localObject3).setId(2131307220);
      ((ImageView)localObject3).setPadding(jdField_c_of_type_Int, d, d, d);
      ((LinearLayout)localObject2).addView((View)localObject3);
      localObject4 = new TextView(this.jdField_a_of_type_AndroidContentContext);
      ((TextView)localObject4).setId(2131307225);
      ((TextView)localObject4).setTextColor(-1);
      ((TextView)localObject4).setPadding(0, d, jdField_c_of_type_Int, d);
      ((LinearLayout)localObject2).addView((View)localObject4);
      paramacju.setOnClickListener(this);
      paramacju.setOnTouchListener(paramacmv);
      paramacju.setOnLongClickListener(paramacmv);
      paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqActivityAioItemLightVideoItemBuilder$ChatVideoView = paramView;
      paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView = localMessageProgressView;
      paramBaseChatItemLayout.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localObject1);
      paramBaseChatItemLayout.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localObject3);
      paramBaseChatItemLayout.b = ((TextView)localObject4);
    }
    paramView = paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqActivityAioItemLightVideoItemBuilder$ChatVideoView;
    if (AppSetting.c)
    {
      paramacmv = new StringBuilder();
      paramacmv.append("轻量短视频 ");
      paramacmv.append(localMessageForLightVideo.videoFileTime);
      paramacmv.append("秒");
      if ((!localMessageForLightVideo.isSend()) && (!localMessageForLightVideo.isLightVideoRead)) {
        paramacmv.append(" 未播放");
      }
      paramView.setContentDescription(paramacmv.toString());
    }
    paramView.d = localMessageForLightVideo.isSend();
    paramView.setTag(Long.valueOf(localMessageForLightVideo.uniseq));
    baab.a().a(Long.valueOf(localMessageForLightVideo.uniseq), localMessageForLightVideo);
    paramBaseChatItemLayout.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setRadius(15.0F, true);
    paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setShowCorner(false);
    paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setSharpCornerCor(BubbleImageView.a);
    paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setCornerDirection(localMessageForLightVideo.isSend());
    paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.a(paramChatMessage.frienduin + paramChatMessage.uniseq);
    this.k = aciy.a(160.0F, localResources);
    this.l = aciy.a(160.0F, localResources);
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
      return paramacju;
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
    return ajjy.a(2131640272);
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
    aqut.a().a(null);
    this.jdField_a_of_type_ComTencentImageURLDrawable = null;
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    MessageForLightVideo localMessageForLightVideo;
    if ((paramChatMessage != null) && ((paramChatMessage instanceof MessageForLightVideo)))
    {
      localMessageForLightVideo = (MessageForLightVideo)paramChatMessage;
      if (paramInt == 2131299417)
      {
        aael.b(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localMessageForLightVideo);
        urp.a("story_grp", "press_msg", 0, 0, new String[] { "4", "", "", "" });
      }
    }
    else
    {
      return;
    }
    if (paramInt == 2131304871)
    {
      super.d(paramChatMessage);
      urp.a("story_grp", "press_msg", 0, 0, new String[] { "5", "", "", "" });
      return;
    }
    if (paramInt == 2131300328)
    {
      bfhl.a(localMessageForLightVideo).b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage).a((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
      bfhz.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 6, 5);
      urp.a("story_grp", "press_msg", 0, 0, new String[] { "2", "", "", "" });
      return;
    }
    if (paramInt == 2131304829)
    {
      if (c(paramChatMessage)) {
        MediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(true);
      }
      super.a(localMessageForLightVideo);
      urp.a("story_grp", "press_msg", 0, 0, new String[] { "3", "", "", "" });
      return;
    }
    if (paramInt == 2131299379)
    {
      paramContext = new StringBuilder();
      paramContext.append("uniseq:").append(localMessageForLightVideo.uniseq).append("\n");
      Toast.makeText(this.jdField_a_of_type_AndroidContentContext, paramContext.toString(), 1).show();
      return;
    }
    super.a(paramInt, paramContext, paramChatMessage);
  }
  
  protected void a(adik paramadik)
  {
    if (!paramadik.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.a(paramadik.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin + paramadik.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq)) {
      paramadik.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setVisibility(8);
    }
    for (;;)
    {
      paramadik.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      if (QLog.isColorLevel()) {
        QLog.w("LightVideoItemBuilder", 2, "[hideProgress] set ProgressPieDrawable visible");
      }
      return;
      paramadik.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setAnimRunnableListener(new adii(this, paramadik));
    }
  }
  
  protected void a(adik paramadik, MessageForLightVideo paramMessageForLightVideo, int paramInt)
  {
    if (paramadik == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("LightVideoItemBuilder", 2, String.format("handleVideoViewAnimStatus uniseq:%d, status:%d", new Object[] { Long.valueOf(paramMessageForLightVideo.uniseq), Integer.valueOf(paramInt) }));
    }
    paramadik.b.setText(adlr.a(paramMessageForLightVideo.videoFileTime));
    paramadik.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setUnread(false, null, null);
    paramMessageForLightVideo.videoStatus = paramInt;
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      if ((!paramMessageForLightVideo.isSend()) && (!paramMessageForLightVideo.isLightVideoRead)) {
        paramadik.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setUnread(true, null, null);
      }
      paramadik.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130840146);
      return;
    case 1: 
      a(paramMessageForLightVideo);
      paramMessageForLightVideo = (AnimationDrawable)this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130772069);
      paramadik.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramMessageForLightVideo);
      paramMessageForLightVideo.start();
      return;
    case 2: 
      paramadik.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130840143);
      return;
    }
    if ((!paramMessageForLightVideo.isSend()) && (!paramMessageForLightVideo.isLightVideoRead)) {
      paramadik.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setUnread(true, null, null);
    }
    paramadik.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130840143);
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    paramView = (adik)aciy.a(paramView);
    MessageForLightVideo localMessageForLightVideo = (MessageForLightVideo)paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
    if (!localMessageForLightVideo.isSendFromLocal()) {
      return;
    }
    begr localbegr = (begr)behe.a(this.jdField_a_of_type_AndroidContentContext, null);
    localbegr.a(2131624443, 5);
    localbegr.c(2131625035);
    localbegr.a(new adig(this, localMessageForLightVideo, paramView, localbegr));
    localbegr.show();
  }
  
  public void a(View paramView, axqf paramaxqf, int paramInt1, int paramInt2)
  {
    paramView = (adik)aciy.a(paramView);
    MessageForLightVideo localMessageForLightVideo = (MessageForLightVideo)paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
    if (localMessageForLightVideo.uniseq != paramaxqf.jdField_b_of_type_Long) {}
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
            m = aciy.a(paramInt1, (Resources)localObject);
            n = aciy.a(paramInt2, (Resources)localObject);
            if ((paramaxqf.jdField_b_of_type_Int != 327689) && (paramaxqf.jdField_b_of_type_Int != 6) && (paramaxqf.jdField_b_of_type_Int != 17) && (paramaxqf.jdField_b_of_type_Int != 9)) {
              break label846;
            }
            switch (paramaxqf.d)
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
          paramaxqf = ShortVideoUtils.a(localMessageForLightVideo, "mp4");
          boolean bool = bace.b(paramaxqf);
          a(localMessageForLightVideo, "VIDEO STATUS_SEND_FINISHED ,videofile:" + paramaxqf + " ,videoexist:" + bool);
          if (bool)
          {
            a(paramView, localMessageForLightVideo, localChatVideoView);
            a(localMessageForLightVideo, paramView, 100, true);
          }
          c(localMessageForLightVideo);
          return;
          a(localMessageForLightVideo, "VIDEO STATUS_SEND_ERROR");
          c(localMessageForLightVideo);
          b(localMessageForLightVideo, paramView, 2131652959);
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
          b(localMessageForLightVideo, paramView, 2131652953);
          if (localMessageForLightVideo.uiOperatorFlag == 2)
          {
            paramView.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
            bbmy.a(this.jdField_a_of_type_AndroidContentContext, 2131653674, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131167766));
            return;
          }
          bbmy.a(this.jdField_a_of_type_AndroidContentContext, 2131653699, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131167766));
          return;
          a(localMessageForLightVideo, "VIDEO STATUS_RECV_ERROR");
          a(paramView);
          a(localMessageForLightVideo, paramView);
          bbmy.a(this.jdField_a_of_type_AndroidContentContext, 2131653701, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131167766));
          return;
          a(localMessageForLightVideo, "VIDEO STATUS_FILE_EXPIRED");
          paramaxqf = ShortVideoUtils.a(localMessageForLightVideo.thumbMD5, "jpg");
          if (bace.b(paramaxqf)) {
            a(localChatVideoView, paramaxqf, paramInt2, paramInt1);
          }
          b(localMessageForLightVideo, paramView, 2131652954);
          return;
          a(localMessageForLightVideo, "VIDEO STATUS_RECV_CANCEL");
          return;
          paramInt1 = localMessageForLightVideo.videoFileProgress;
          a(localMessageForLightVideo, "VIDEO STATUS_RECV_PROCESS " + paramInt1);
          a(localMessageForLightVideo, paramView, paramInt1, true);
          return;
        } while ((paramaxqf.jdField_b_of_type_Int != 7) && (paramaxqf.jdField_b_of_type_Int != 18) && (paramaxqf.jdField_b_of_type_Int != 16));
        switch (paramaxqf.d)
        {
        default: 
          return;
        case 2001: 
          a(localMessageForLightVideo, "THUMB STATUS_RECV_START");
          return;
        case 2003: 
          a(localMessageForLightVideo, "THUMB STATUS_RECV_FINISHED");
          paramaxqf = ShortVideoUtils.a(localMessageForLightVideo.thumbMD5, "jpg");
          localObject = ShortVideoUtils.a(localMessageForLightVideo, "mp4");
          if ((!bace.b((String)localObject)) || (!awfq.b)) {
            break label1044;
          }
          a(localMessageForLightVideo, ajjy.a(2131640263) + paramaxqf);
        }
      } while (!ShortVideoUtils.a());
      paramaxqf = aqut.a((String)localObject, paramaxqf, localMessageForLightVideo.uniseq, paramInt1, paramInt2, false, true, false, 0, this, null);
      paramView.jdField_a_of_type_ComTencentMobileqqActivityAioItemLightVideoItemBuilder$ChatVideoView.setURLDrawable(paramaxqf);
      b(paramView);
      return;
      if (!bace.b(paramaxqf)) {
        break;
      }
    } while (!localChatVideoView.a(paramaxqf));
    label1044:
    a(localMessageForLightVideo, ajjy.a(2131640267) + paramaxqf);
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mRequestWidth = m;
    localURLDrawableOptions.mRequestHeight = n;
    localURLDrawableOptions.mLoadingDrawable = jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
    localURLDrawableOptions.mFailedDrawable = jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
    localChatVideoView.setURLDrawable(URLDrawable.getDrawable(new File(paramaxqf), localURLDrawableOptions));
    if (!bace.b((String)localObject))
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
    localChatVideoView.setImageDrawable(axwd.a());
    return;
    a(localMessageForLightVideo, "THUMB STATUS_FILE_EXPIRED");
    a(localMessageForLightVideo, "THUMB STATUS_RECV_ERROR");
    paramaxqf = ShortVideoUtils.a(localMessageForLightVideo, "mp4");
    if (bace.b(paramaxqf)) {
      if (localChatVideoView.a(paramaxqf))
      {
        a(localMessageForLightVideo, ajjy.a(2131640253) + paramaxqf);
        if (ShortVideoUtils.a())
        {
          paramaxqf = aqut.a(paramaxqf, ShortVideoUtils.a(localMessageForLightVideo.thumbMD5, "jpg"), localMessageForLightVideo.uniseq, paramInt1, paramInt2, false, true, false, 0, this, null);
          paramView.jdField_a_of_type_ComTencentMobileqqActivityAioItemLightVideoItemBuilder$ChatVideoView.setURLDrawable(paramaxqf);
          b(paramView);
        }
      }
    }
    for (;;)
    {
      a(paramView);
      return;
      paramaxqf = localChatVideoView.b;
      if ((paramaxqf != null) && (paramaxqf.getStatus() == 1))
      {
        localChatVideoView.setURLDrawable(paramaxqf);
        continue;
        localChatVideoView.setImageDrawable(jdField_a_of_type_AndroidGraphicsDrawableColorDrawable);
      }
    }
  }
  
  public void a(View paramView, ChatMessage paramChatMessage)
  {
    int m = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131165222);
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
      paramMessageForLightVideo.saveExtInfoToExtStr(awav.u, "1");
      ThreadManager.post(new LightVideoItemBuilder.2(this, paramMessageForLightVideo), 10, null, false);
    }
  }
  
  void a(MessageForLightVideo paramMessageForLightVideo, adik paramadik)
  {
    paramadik.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.b(paramMessageForLightVideo.frienduin + paramMessageForLightVideo.uniseq);
    paramadik.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setDrawStatus(2);
    paramadik.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setVisibility(0);
    paramadik.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    if (QLog.isColorLevel()) {
      QLog.w("LightVideoItemBuilder", 2, "[showPauseProgress] uinseq:" + paramMessageForLightVideo.uniseq);
    }
  }
  
  void a(MessageForLightVideo paramMessageForLightVideo, adik paramadik, int paramInt)
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
    a(paramMessageForLightVideo, paramadik, paramInt, true);
  }
  
  protected void a(MessageForLightVideo paramMessageForLightVideo, adik paramadik, int paramInt, boolean paramBoolean)
  {
    paramadik.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setDrawStatus(1);
    paramadik.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setAnimProgress(paramInt, paramMessageForLightVideo.frienduin + paramMessageForLightVideo.uniseq);
    paramadik.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setVisibility(0);
    paramadik.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    if (QLog.isColorLevel()) {
      QLog.w("LightVideoItemBuilder", 2, "[setProgress] uinseq:" + paramMessageForLightVideo.uniseq + ", p:" + paramInt);
    }
  }
  
  void a(MessageForLightVideo paramMessageForLightVideo, boolean paramBoolean)
  {
    int n = 1;
    if (paramMessageForLightVideo.videoFileStatus == 5002)
    {
      a(paramMessageForLightVideo, ajjy.a(2131640270));
      return;
    }
    Object localObject = Environment.getExternalStorageDirectory();
    if ((((File)localObject).exists()) && (((File)localObject).canWrite()))
    {
      m = 1;
      if ((!Environment.getExternalStorageState().equals("mounted")) || (m == 0)) {
        break label104;
      }
    }
    label104:
    for (int m = 1;; m = 0)
    {
      if (m != 0) {
        break label109;
      }
      bbmy.a(this.jdField_a_of_type_AndroidContentContext, 1, 2131653216, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131167766));
      return;
      m = 0;
      break;
    }
    label109:
    localObject = aweg.a(2, 2);
    awej localawej = paramMessageForLightVideo.getDownloadInfo(((awey)localObject).jdField_b_of_type_Int);
    localawej.h = ShortVideoUtils.a(paramMessageForLightVideo, "mp4");
    localawej.a(paramMessageForLightVideo.istroop, 0);
    m = n;
    if (paramBoolean) {
      m = 2;
    }
    localawej.f = m;
    localawej.g = 2;
    if (QLog.isColorLevel()) {
      QLog.d("LightVideoItemBuilder", 2, " startDownloadVideo downloadvideo fileType==" + localawej.e + ", uniseq:" + paramMessageForLightVideo.uniseq);
    }
    ((awey)localObject).a(localawej);
    ((awey)localObject).a(paramMessageForLightVideo);
    aweg.a((awey)localObject, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
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
    paramXListView = (adik)aciy.a(paramView);
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
        a(paramView, ShortVideoUtils.a(paramChatMessage.thumbMD5, "jpg"), aciy.a(160.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), aciy.a(160.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
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
    adik localadik;
    if ((localChatMessage != null) && ((localChatMessage instanceof MessageForLightVideo)))
    {
      localadik = a(localChatMessage.uniseq);
      if (localadik != null) {
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
      } while ((localadik.jdField_a_of_type_ComTencentMobileqqActivityAioItemLightVideoItemBuilder$ChatVideoView == null) || (localadik.jdField_a_of_type_ComTencentMobileqqActivityAioItemLightVideoItemBuilder$ChatVideoView.b == null) || (localadik.jdField_a_of_type_ComTencentMobileqqActivityAioItemLightVideoItemBuilder$ChatVideoView.b.getStatus() != 1) || (!(localadik.jdField_a_of_type_ComTencentMobileqqActivityAioItemLightVideoItemBuilder$ChatVideoView.b.getCurrDrawable() instanceof QQLiveDrawable)));
      m = (int)((QQLiveDrawable)localadik.jdField_a_of_type_ComTencentMobileqqActivityAioItemLightVideoItemBuilder$ChatVideoView.b.getCurrDrawable()).getCurrentPosition();
      a(this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer, localadik, m - 1000);
    } while (!QLog.isColorLevel());
    QLog.d("LightVideoItemBuilder", 2, String.format("onNearToEar usingLoudSpeaker:%s, position:%d, duration:%d, uniseq:%d", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(m), Integer.valueOf(((MessageForShortVideo)localadik.jdField_a_of_type_ComTencentMobileqqDataChatMessage).videoFileTime), Long.valueOf(localadik.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq) }));
  }
  
  protected boolean a(adik paramadik, MessageForLightVideo paramMessageForLightVideo, LightVideoItemBuilder.ChatVideoView paramChatVideoView)
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
        if (bace.b((String)localObject2)) {
          break label113;
        }
        if (!TextUtils.isEmpty(paramMessageForLightVideo.thumbMD5)) {
          break label102;
        }
        paramChatVideoView.setImageDrawable(axwd.a());
        a(paramadik);
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
      a(paramMessageForLightVideo, paramadik, paramMessageForLightVideo.videoFileProgress, true);
      return false;
    }
    Object localObject1 = ShortVideoUtils.a(paramMessageForLightVideo.thumbMD5, "jpg");
    Object localObject2 = ShortVideoUtils.a(paramMessageForLightVideo, "mp4");
    boolean bool3 = bace.b((String)localObject1);
    bool1 = bace.b((String)localObject2);
    if (QLog.isColorLevel()) {
      QLog.d("LightVideoItemBuilder", 2, String.format("handleVideoFileStatus uniseq:%d, thumb:%s, videofile:%s", new Object[] { Long.valueOf(paramMessageForLightVideo.uniseq), Boolean.valueOf(bool3), Boolean.valueOf(bool1) }));
    }
    if (bool1)
    {
      paramadik.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setVisibility(8);
      if ((!paramMessageForLightVideo.isSendFromLocal()) || (paramMessageForLightVideo.isStatusReady())) {
        if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForLightVideo != null) && (this.jdField_a_of_type_ComTencentMobileqqDataMessageForLightVideo.videoStatus == 1))
        {
          bool1 = true;
          label393:
          a(paramadik, true, true, 0, false, bool1);
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
        a(paramMessageForLightVideo, paramadik);
      }
      if (paramMessageForLightVideo.videoFileStatus == 5002)
      {
        a(paramMessageForLightVideo, ajjy.a(2131640276));
        b(paramMessageForLightVideo, paramadik, 2131652954);
        return false;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramMessageForLightVideo, true))
      {
        a(paramMessageForLightVideo, true);
        return false;
      }
      if ((paramMessageForLightVideo.videoFileStatus == 2001) || (paramMessageForLightVideo.videoFileStatus == 2002) || (paramMessageForLightVideo.videoFileStatus == 2000))
      {
        a(paramMessageForLightVideo, paramadik, paramMessageForLightVideo.videoFileProgress, false);
        return false;
      }
      a(paramMessageForLightVideo, paramadik);
      return true;
    }
    if (paramMessageForLightVideo.videoFileStatus == 5002)
    {
      a(paramMessageForLightVideo, ajjy.a(2131640250));
      paramChatVideoView.setImageDrawable(jdField_a_of_type_AndroidGraphicsDrawableColorDrawable);
      b(paramMessageForLightVideo, paramadik, 2131652954);
      return false;
    }
    a(paramMessageForLightVideo, ajjy.a(2131640256));
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
      if ((paramBaseChatItemLayout instanceof axou))
      {
        if (((axou)paramBaseChatItemLayout).c() == 1005L) {}
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
    paramXListView = (adik)aciy.a(paramView);
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
  
  public bakj[] a(View paramView)
  {
    bakh localbakh = new bakh();
    paramView = (adik)aciy.a(paramView);
    MessageForLightVideo localMessageForLightVideo = (MessageForLightVideo)paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
    if ((!TextUtils.isEmpty(localMessageForLightVideo.md5)) && (bace.b(ShortVideoUtils.a(localMessageForLightVideo.thumbMD5, "jpg")))) {
      if ((paramView.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.c == null) || (paramView.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.c.getVisibility() != 0)) {
        break label125;
      }
    }
    label125:
    for (int m = 1;; m = 0)
    {
      if (m == 0) {
        a(localbakh, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, localMessageForLightVideo);
      }
      a(localbakh, localMessageForLightVideo);
      super.c(localbakh, this.jdField_a_of_type_AndroidContentContext);
      super.d(localbakh, this.jdField_a_of_type_AndroidContentContext);
      return localbakh.a();
    }
  }
  
  protected void b(adik paramadik)
  {
    if (!paramadik.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.a(paramadik.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin + paramadik.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq))
    {
      paramadik.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setVisibility(8);
      return;
    }
    paramadik.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setAnimRunnableListener(new adij(this, paramadik));
  }
  
  void b(MessageForLightVideo paramMessageForLightVideo)
  {
    awey localawey = aweg.a(2, 2);
    awej localawej = paramMessageForLightVideo.getDownloadInfo(localawey.jdField_b_of_type_Int);
    localawej.i = ShortVideoUtils.a(paramMessageForLightVideo.thumbMD5, "jpg");
    localawej.a(paramMessageForLightVideo.istroop, 1);
    localawej.f = 2;
    localawej.g = 2;
    localawey.a(localawej);
    localawey.a(paramMessageForLightVideo);
    aweg.a(localawey, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
  }
  
  void b(MessageForLightVideo paramMessageForLightVideo, adik paramadik, int paramInt)
  {
    paramadik.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.b(paramMessageForLightVideo.frienduin + paramMessageForLightVideo.uniseq);
    paramadik.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setVisibility(0);
    paramadik.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setImageResource(2130848457);
    paramadik.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setDrawStatus(3);
    paramadik.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    paramadik.jdField_a_of_type_AndroidWidgetTextView.setText(paramInt);
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
    Object localObject = (AppActivity)this.jdField_a_of_type_AndroidContentContext;
    if ((localObject != null) && (Build.VERSION.SDK_INT >= 23) && (!akhu.a((Context)localObject))) {
      akhu.a((AppActivity)localObject, 3, new adih(this, (AppActivity)localObject));
    }
    MessageForLightVideo localMessageForLightVideo;
    do
    {
      do
      {
        do
        {
          return;
          localObject = (adik)aciy.a(paramView);
        } while (localObject == null);
        localMessageForLightVideo = (MessageForLightVideo)((adik)localObject).jdField_a_of_type_ComTencentMobileqqDataChatMessage;
        if (QLog.isColorLevel()) {
          QLog.d("LightVideoItemBuilder", 2, "onClick! uniseq:" + localMessageForLightVideo.uniseq);
        }
      } while (paramView.getId() == 2131298594);
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c())
      {
        bbmy.a(this.jdField_a_of_type_AndroidContentContext, 2131630481, 1).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131167766));
        return;
      }
      if ((paramView.getId() != 2131298552) && (paramView.getId() != 2131296771)) {
        break;
      }
    } while (localMessageForLightVideo.md5 == null);
    if (c(localMessageForLightVideo))
    {
      a((adik)localObject, localMessageForLightVideo, 2);
      MediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(false);
    }
    for (;;)
    {
      super.onClick(paramView);
      return;
      String str = ShortVideoUtils.a(localMessageForLightVideo.thumbMD5, "jpg");
      if (!bace.b(ShortVideoUtils.a(localMessageForLightVideo, "mp4")))
      {
        a(localMessageForLightVideo, false);
        a(localMessageForLightVideo, (adik)localObject, localMessageForLightVideo.videoFileProgress, false);
        this.jdField_c_of_type_Long = localMessageForLightVideo.uniseq;
        this.j = 0;
      }
      else if (bace.b(str))
      {
        awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800561C", "0X800561C", 0, 0, "", "", "", "");
        if (TVK_SDKMgr.isInstalled(this.jdField_a_of_type_AndroidContentContext))
        {
          if (!MediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(aciy.a(paramView))) {
            bbmy.a(this.jdField_a_of_type_AndroidContentContext, 1, 2131629839, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131167766));
          }
        }
        else {
          bbmy.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131632246), 0).b(BaseApplicationImpl.getApplication().getResources().getDimensionPixelSize(2131167766));
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
      paramString = baab.a().a(Long.valueOf(paramQQLiveDrawableParams.msgUniseq));
      if ((paramString != null) && (!baab.a().a(Long.valueOf(paramQQLiveDrawableParams.msgUniseq))))
      {
        ShortVideoUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "0X8008E51", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramString, this.jdField_a_of_type_AndroidContentContext);
        if (!baab.a().b(Long.valueOf(paramString.uniseq)))
        {
          baab.a().a(Long.valueOf(paramString.uniseq));
          ShortVideoUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "0X8008E50", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramString, this.jdField_a_of_type_AndroidContentContext);
        }
        baab.a().a(Long.valueOf(paramQQLiveDrawableParams.msgUniseq), true);
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