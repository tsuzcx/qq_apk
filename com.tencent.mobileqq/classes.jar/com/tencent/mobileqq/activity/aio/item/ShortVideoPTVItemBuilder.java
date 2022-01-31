package com.tencent.mobileqq.activity.aio.item;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
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
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.Utils;
import com.tencent.image.VideoDrawable;
import com.tencent.image.VideoDrawable.VideoDrawableParams;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.TouchDelegate;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.ViewHolder;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.FileTransferManager;
import com.tencent.mobileqq.activity.aio.FileTransferManager.Callback;
import com.tencent.mobileqq.activity.aio.MediaPlayerManager;
import com.tencent.mobileqq.activity.aio.OnLongClickAndTouchListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.BaseMessageManager;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.drawable.EmptyDrawable;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.pic.PicPreDownloadUtils;
import com.tencent.mobileqq.richmedia.dc.DCShortVideo;
import com.tencent.mobileqq.shortvideo.ShortVideoBusiManager;
import com.tencent.mobileqq.shortvideo.ShortVideoConstants;
import com.tencent.mobileqq.shortvideo.ShortVideoDownloadInfo;
import com.tencent.mobileqq.shortvideo.ShortVideoPreDownloader;
import com.tencent.mobileqq.shortvideo.ShortVideoReq;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.transfile.BaseTransProcessor;
import com.tencent.mobileqq.transfile.FileMsg;
import com.tencent.mobileqq.transfile.ShortVideoForwardProcessor;
import com.tencent.mobileqq.transfile.ShortVideoUploadProcessor;
import com.tencent.mobileqq.transfile.TransFileController;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.MsgUtils;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenuItem;
import com.tencent.mobileqq.widget.AudioAnimationView;
import com.tencent.mobileqq.widget.CircleProgressView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import com.tencent.widget.ListView;
import cooperation.qqfav.QfavBuilder;
import cooperation.qqfav.QfavReport;
import java.io.File;
import java.lang.ref.WeakReference;
import vcw;
import vcx;
import vcy;
import vcz;

public class ShortVideoPTVItemBuilder
  extends BaseBubbleBuilder
  implements FileTransferManager.Callback, ShortVideoConstants
{
  static ColorDrawable jdField_a_of_type_AndroidGraphicsDrawableColorDrawable = new EmptyDrawable(-10065297, jdField_b_of_type_Int, c);
  public static WeakReference a;
  static int jdField_b_of_type_Int;
  private static WeakReference jdField_b_of_type_JavaLangRefWeakReference;
  static int c;
  private ListView jdField_a_of_type_ComTencentWidgetListView;
  Handler jdField_b_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  
  static
  {
    Resources localResources = BaseApplicationImpl.sApplication.getResources();
    jdField_b_of_type_Int = AIOUtils.a(160.0F, localResources);
    c = AIOUtils.a(160.0F, localResources);
  }
  
  public ShortVideoPTVItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    if (paramAIOAnimationConatiner != null) {
      this.jdField_a_of_type_ComTencentWidgetListView = paramAIOAnimationConatiner.jdField_a_of_type_ComTencentWidgetListView;
    }
    ShortVideoUtils.a(paramQQAppInterface);
    ShortVideoPTVItemBuilder.PtvPlayConfig.a();
  }
  
  public static void a(ListView paramListView)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (jdField_a_of_type_JavaLangRefWeakReference != null)
    {
      bool1 = bool2;
      if (jdField_a_of_type_JavaLangRefWeakReference.get() != null)
      {
        bool1 = bool2;
        if (((VideoDrawable)jdField_a_of_type_JavaLangRefWeakReference.get()).isAudioPlaying())
        {
          ((VideoDrawable)jdField_a_of_type_JavaLangRefWeakReference.get()).stopAudio();
          bool2 = true;
          bool1 = bool2;
          if (jdField_b_of_type_JavaLangRefWeakReference != null)
          {
            bool1 = bool2;
            if (jdField_b_of_type_JavaLangRefWeakReference.get() != null)
            {
              a(paramListView, (ChatMessage)jdField_b_of_type_JavaLangRefWeakReference.get());
              bool1 = bool2;
            }
          }
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPTVItemBuilder", 2, "stopAudioIfPlaying(), stopSuccess = " + bool1);
    }
  }
  
  public static void a(ListView paramListView, ChatMessage paramChatMessage)
  {
    if ((paramChatMessage != null) && (paramListView != null))
    {
      i = AIOUtils.a(paramChatMessage.uniseq, paramListView.getAdapter());
      if (i > -1)
      {
        paramListView = AIOUtils.a(paramListView, i);
        if (paramListView != null)
        {
          paramListView = AIOUtils.a(paramListView);
          if ((paramListView != null) && ((paramListView instanceof ShortVideoPTVItemBuilder.Holder)))
          {
            paramListView = (ShortVideoPTVItemBuilder.Holder)paramListView;
            if (paramListView != null) {
              paramListView.jdField_a_of_type_ComTencentMobileqqWidgetAudioAnimationView.d();
            }
          }
        }
      }
    }
    while (!QLog.isColorLevel())
    {
      int i;
      return;
    }
    QLog.e("ShortVideoPTVItemBuilder", 2, "stopAudioAnimByMsg(), message = " + paramChatMessage);
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    return 0;
  }
  
  public View a(int paramInt1, int paramInt2, ChatMessage paramChatMessage, View paramView, ViewGroup paramViewGroup, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    paramView = super.a(paramInt1, paramInt2, paramChatMessage, paramView, paramViewGroup, paramOnLongClickAndTouchListener);
    paramOnLongClickAndTouchListener = FileTransferManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    if (paramOnLongClickAndTouchListener != null) {
      paramOnLongClickAndTouchListener.a(paramView, this);
    }
    if ((this.jdField_a_of_type_ComTencentWidgetListView == null) && (paramViewGroup != null) && ((paramViewGroup instanceof ListView))) {
      this.jdField_a_of_type_ComTencentWidgetListView = ((ListView)paramViewGroup);
    }
    try
    {
      paramViewGroup = (ShortVideoPTVItemBuilder.Holder)paramView.getTag();
      float f = ((MessageForShortVideo)paramChatMessage).videoFileSize / 1000;
      paramViewGroup.b.append(f);
      paramViewGroup.b.append("K");
      paramViewGroup.b.append(String.valueOf(((MessageForShortVideo)paramChatMessage).videoFileTime));
      paramViewGroup.b.append("秒");
      paramView.setContentDescription(paramViewGroup.b.toString());
      return paramView;
    }
    catch (Exception paramChatMessage) {}
    return paramView;
  }
  
  protected View a(ChatMessage paramChatMessage, BaseBubbleBuilder.ViewHolder paramViewHolder, View paramView, BaseChatItemLayout paramBaseChatItemLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    paramBaseChatItemLayout = (ShortVideoPTVItemBuilder.Holder)paramViewHolder;
    Object localObject1 = this.jdField_a_of_type_AndroidContentContext;
    Object localObject2 = ((Context)localObject1).getResources();
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPTVItemBuilder", 2, "getBubbleView(), message = " + paramChatMessage);
    }
    paramViewHolder = paramView;
    Object localObject3;
    if (paramView == null)
    {
      paramViewHolder = new RelativeLayout((Context)localObject1);
      int i = AIOUtils.a(160.0F, (Resources)localObject2);
      int j = AIOUtils.a(160.0F, (Resources)localObject2);
      paramView = new vcy((Context)localObject1);
      paramView.setId(2131366616);
      paramView.setScaleType(ImageView.ScaleType.FIT_XY);
      localObject3 = new RelativeLayout.LayoutParams(i, j);
      ((RelativeLayout.LayoutParams)localObject3).addRule(13);
      paramViewHolder.addView(paramView, (ViewGroup.LayoutParams)localObject3);
      localObject3 = new CircleProgressView((Context)localObject1);
      ((CircleProgressView)localObject3).setVisibility(8);
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(i, j);
      localLayoutParams.addRule(13);
      paramViewHolder.addView((View)localObject3, localLayoutParams);
      localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams.addRule(14);
      localLayoutParams.addRule(8, 2131366616);
      localLayoutParams.bottomMargin = AIOUtils.a(6.0F, (Resources)localObject2);
      localObject2 = new AudioAnimationView((Context)localObject1);
      ((AudioAnimationView)localObject2).setRectCount(7);
      ((AudioAnimationView)localObject2).setSyle(1);
      ((AudioAnimationView)localObject2).setIcon(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130837706));
      paramViewHolder.addView((View)localObject2, localLayoutParams);
      localObject1 = new ImageView((Context)localObject1);
      localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams.addRule(13);
      ((ImageView)localObject1).setVisibility(8);
      paramViewHolder.addView((View)localObject1, localLayoutParams);
      paramViewHolder.setOnClickListener(this);
      paramViewHolder.setOnTouchListener(paramOnLongClickAndTouchListener);
      paramViewHolder.setOnLongClickListener(paramOnLongClickAndTouchListener);
      paramBaseChatItemLayout.jdField_a_of_type_Vcy = paramView;
      paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgressView = ((CircleProgressView)localObject3);
      paramBaseChatItemLayout.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localObject1);
      paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqWidgetAudioAnimationView = ((AudioAnimationView)localObject2);
    }
    paramOnLongClickAndTouchListener = paramBaseChatItemLayout.jdField_a_of_type_Vcy;
    paramView = (MessageForShortVideo)paramChatMessage;
    paramOnLongClickAndTouchListener.c = paramView.isSend();
    paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgressView.setIsSend(paramView.isSend());
    if (jdField_b_of_type_Boolean)
    {
      localObject1 = new StringBuilder();
      if (paramChatMessage.isSend())
      {
        ((StringBuilder)localObject1).append("你发出视频对讲消息,");
        float f = ((MessageForShortVideo)paramChatMessage).videoFileSize / 1000;
        ((StringBuilder)localObject1).append("文件大小:");
        ((StringBuilder)localObject1).append(f);
        ((StringBuilder)localObject1).append("K ");
        ((StringBuilder)localObject1).append("视频时长:");
        ((StringBuilder)localObject1).append(String.valueOf(((MessageForShortVideo)paramChatMessage).videoFileTime));
        ((StringBuilder)localObject1).append("秒");
        paramViewHolder.setContentDescription(((StringBuilder)localObject1).toString());
      }
    }
    else
    {
      if (paramView.md5 != null) {
        break label736;
      }
      if (paramView.isSendFromLocal())
      {
        paramChatMessage = paramView.mThumbFilePath;
        if (!FileUtils.b(paramChatMessage)) {
          break label681;
        }
        if (paramOnLongClickAndTouchListener.a(paramChatMessage))
        {
          if (QLog.isColorLevel()) {
            QLog.i("ShortVideoPTVItemBuilder", 2, "getBubbleView: 占坑 msgSeq: " + paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
          }
          localObject1 = URLDrawable.URLDrawableOptions.obtain();
          ((URLDrawable.URLDrawableOptions)localObject1).mLoadingDrawable = jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
          ((URLDrawable.URLDrawableOptions)localObject1).mFailedDrawable = jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
          paramOnLongClickAndTouchListener.b(URLDrawable.getDrawable(new File(paramChatMessage), (URLDrawable.URLDrawableOptions)localObject1));
          a(paramBaseChatItemLayout);
          Utils.executeAsyncTaskOnSerialExcuter(new vcz(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, paramView), new Void[] { (Void)null });
        }
      }
    }
    label681:
    do
    {
      return paramViewHolder;
      ((StringBuilder)localObject1).append(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d).append("发出视频对讲消息,");
      break;
      paramOnLongClickAndTouchListener.setImageDrawable(URLDrawableHelper.a());
      b(paramBaseChatItemLayout);
    } while (!QLog.isColorLevel());
    QLog.i("ShortVideoPTVItemBuilder", 2, "getBubbleView():You must get thumb before send video. msgSeq: " + paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
    return paramViewHolder;
    label736:
    localObject1 = ShortVideoUtils.a(paramView.thumbMD5, "jpg");
    paramChatMessage = ShortVideoUtils.a(paramView, "mp4");
    if (QLog.isColorLevel()) {
      QLog.i("ShortVideoPTVItemBuilder", 2, "getBubbleView() videoPath" + paramChatMessage + "thumbPath=" + (String)localObject1);
    }
    if ((ShortVideoPTVItemBuilder.PtvPlayConfig.jdField_b_of_type_Boolean) && (ShortVideoUtils.a()) && (FileUtils.b(paramChatMessage)) && ((!paramView.isSendFromLocal()) || (paramView.videoFileStatus == 1003) || (paramView.videoFileStatus == 2003)))
    {
      if (!paramView.isSend()) {
        new DCShortVideo(BaseApplication.getContext()).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 2003, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, 1002);
      }
      if (paramOnLongClickAndTouchListener.a(paramChatMessage))
      {
        if (QLog.isColorLevel()) {
          QLog.i("ShortVideoPTVItemBuilder", 2, "getBubbleView: 刷视频 " + paramChatMessage + " msgSeq: " + paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
        }
        localObject2 = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
        ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
        if (!paramOnLongClickAndTouchListener.a((String)localObject1)) {
          ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = paramOnLongClickAndTouchListener.b;
        }
        localObject3 = new VideoDrawable.VideoDrawableParams();
        ((VideoDrawable.VideoDrawableParams)localObject3).mPlayVideoFrame = true;
        ((VideoDrawable.VideoDrawableParams)localObject3).mPlayAudioFrame = false;
        ((VideoDrawable.VideoDrawableParams)localObject3).mVideoRoundCorner = 0;
        ((VideoDrawable.VideoDrawableParams)localObject3).mRequestedFPS = ShortVideoPTVItemBuilder.PtvPlayConfig.jdField_a_of_type_Int;
        ((URLDrawable.URLDrawableOptions)localObject2).mExtraInfo = localObject3;
        localObject2 = URLDrawable.getDrawable(new File(paramChatMessage), (URLDrawable.URLDrawableOptions)localObject2);
        paramOnLongClickAndTouchListener.b((URLDrawable)localObject2);
        if ((((URLDrawable)localObject2).getCurrDrawable() instanceof VideoDrawable))
        {
          boolean bool = ((VideoDrawable)((URLDrawable)localObject2).getCurrDrawable()).isAudioPlaying();
          if (!bool) {
            break label1263;
          }
          paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqWidgetAudioAnimationView.c();
          label1089:
          if (QLog.isColorLevel()) {
            QLog.i("ShortVideoPTVItemBuilder", 2, "getBubbleView: 刷视频, isAudioPlaying= " + bool + ", videoPath:" + paramChatMessage + " msgSeq: " + paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
          }
        }
      }
      for (;;)
      {
        if (!FileUtils.b((String)localObject1))
        {
          a(paramView);
          if (QLog.isColorLevel()) {
            QLog.i("ShortVideoPTVItemBuilder", 2, "getBubbleView: Video file exist and status finish. Thumb not exist. msgSeq: " + paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
          }
        }
        if (!paramView.isSendFromLocal()) {
          break label1424;
        }
        paramChatMessage = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramView.frienduin, paramView.uniseq);
        if (!BaseTransProcessor.class.isInstance(paramChatMessage)) {
          break label1416;
        }
        if (((BaseTransProcessor)paramChatMessage).c() != 1002L) {
          break;
        }
        a(paramBaseChatItemLayout, paramView.videoFileProgress);
        return paramViewHolder;
        label1263:
        paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqWidgetAudioAnimationView.d();
        break label1089;
        localObject2 = paramOnLongClickAndTouchListener.b;
        if ((localObject2 != null) && (((URLDrawable)localObject2).getStatus() == 1))
        {
          paramOnLongClickAndTouchListener.b((URLDrawable)localObject2);
          if ((((URLDrawable)localObject2).getCurrDrawable() instanceof VideoDrawable))
          {
            paramOnLongClickAndTouchListener = (VideoDrawable)((URLDrawable)localObject2).getCurrDrawable();
            if (QLog.isColorLevel()) {
              QLog.i("ShortVideoPTVItemBuilder", 2, "getBubbleView: 刷视频用缓存, isAudioPlaying= " + paramOnLongClickAndTouchListener.isAudioPlaying() + ", videoPath:" + paramChatMessage + " msgSeq: " + paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
            }
            if (paramOnLongClickAndTouchListener.isAudioPlaying()) {
              paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqWidgetAudioAnimationView.c();
            } else {
              paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqWidgetAudioAnimationView.d();
            }
          }
        }
      }
      label1416:
      b(paramBaseChatItemLayout);
      return paramViewHolder;
      label1424:
      b(paramBaseChatItemLayout);
      return paramViewHolder;
    }
    if (FileUtils.b((String)localObject1))
    {
      if (paramOnLongClickAndTouchListener.a((String)localObject1))
      {
        if (QLog.isColorLevel()) {
          QLog.i("ShortVideoPTVItemBuilder", 2, "getBubbleView: 刷缩略图 " + (String)localObject1 + " msgSeq: " + paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
        }
        localObject2 = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
        ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
        paramOnLongClickAndTouchListener.b(URLDrawable.getDrawable(new File((String)localObject1), (URLDrawable.URLDrawableOptions)localObject2));
      }
      for (;;)
      {
        paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqWidgetAudioAnimationView.d();
        if (!FileUtils.b(paramChatMessage)) {
          break label1702;
        }
        if ((!paramView.isSendFromLocal()) || (paramView.videoFileProgress > 100) || (paramView.videoFileStatus == 1003)) {
          break;
        }
        a(paramBaseChatItemLayout, paramView.videoFileProgress);
        return paramViewHolder;
        if (QLog.isColorLevel()) {
          QLog.i("ShortVideoPTVItemBuilder", 2, "getBubbleView: 刷缩略图用缓存 " + (String)localObject1 + " msgSeq: " + paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
        }
        localObject1 = paramOnLongClickAndTouchListener.b;
        if ((localObject1 != null) && (((URLDrawable)localObject1).getStatus() == 1)) {
          paramOnLongClickAndTouchListener.b((URLDrawable)localObject1);
        }
      }
      if ((ShortVideoUtils.a()) && (ShortVideoPTVItemBuilder.PtvPlayConfig.jdField_b_of_type_Boolean))
      {
        b(paramBaseChatItemLayout);
        return paramViewHolder;
      }
      c(paramBaseChatItemLayout);
      return paramViewHolder;
      label1702:
      if (paramView.videoFileStatus == 5002)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ShortVideoPTVItemBuilder", 2, "getBubbleView():短视频已过期不启动下载流程 1 msgSeq: " + paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
        }
        b(paramBaseChatItemLayout, 2131432965);
        return paramViewHolder;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramView, true))
      {
        a(paramView, true);
        a(paramBaseChatItemLayout, paramView.videoFileProgress);
        return paramViewHolder;
      }
      if (BaseTransProcessor.class.isInstance(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramView.frienduin, paramView.uniseq)))
      {
        a(paramBaseChatItemLayout, paramView.videoFileProgress);
        return paramViewHolder;
      }
      c(paramBaseChatItemLayout);
      return paramViewHolder;
    }
    if (paramView.videoFileStatus == 5002)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoPTVItemBuilder", 2, "getBubbleView():短视频已过期不启动下载流程 2 msgSeq: " + paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
      }
      paramOnLongClickAndTouchListener.setImageDrawable(jdField_a_of_type_AndroidGraphicsDrawableColorDrawable);
      b(paramBaseChatItemLayout, 2131432965);
      paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqWidgetAudioAnimationView.d();
      return paramViewHolder;
    }
    if (QLog.isColorLevel()) {
      QLog.i("ShortVideoPTVItemBuilder", 2, "getBubbleView: 下占位图 msgSeq: " + paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
    }
    paramOnLongClickAndTouchListener.setImageDrawable(jdField_a_of_type_AndroidGraphicsDrawableColorDrawable);
    a(paramView);
    paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqWidgetAudioAnimationView.d();
    return paramViewHolder;
  }
  
  public BaseBubbleBuilder.TouchDelegate a(View paramView)
  {
    if ((paramView != null) && (paramView.getParent() != null))
    {
      paramView = (ShortVideoPTVItemBuilder.Holder)((View)paramView.getParent()).getTag();
      if (paramView != null) {
        return paramView.jdField_a_of_type_Vcy;
      }
    }
    return null;
  }
  
  protected BaseBubbleBuilder.ViewHolder a()
  {
    return new ShortVideoPTVItemBuilder.Holder(this);
  }
  
  protected String a(ChatMessage paramChatMessage)
  {
    if (MsgUtils.a(paramChatMessage.issend)) {
      return "发出视频对讲消息";
    }
    return "发来视频对讲消息";
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    MessageForShortVideo localMessageForShortVideo;
    if ((paramChatMessage != null) && ((paramChatMessage instanceof MessageForShortVideo)))
    {
      localMessageForShortVideo = (MessageForShortVideo)paramChatMessage;
      if (paramInt != 2131375336) {
        break label38;
      }
      ChatActivityFacade.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localMessageForShortVideo);
    }
    label38:
    do
    {
      do
      {
        return;
        if (paramInt == 2131375346)
        {
          super.c(paramChatMessage);
          return;
        }
        if (paramInt == 2131363499)
        {
          paramInt = PicPreDownloadUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage.istroop, paramChatMessage.frienduin);
          if (paramInt == 3) {
            paramContext = "1";
          }
          for (;;)
          {
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005624", "0X8005624", 0, 0, paramContext, "", "", "");
            b(localMessageForShortVideo);
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
        if (paramInt == 2131366733)
        {
          QfavBuilder.a(localMessageForShortVideo).b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage).a((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
          QfavReport.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 6, 5);
          return;
        }
        if (paramInt != 2131361906) {
          break label409;
        }
        if (localMessageForShortVideo.md5 != null) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("ShortVideoPTVItemBuilder", 2, "onMenuItemClicked: msg_revoke => md5 = null");
      return;
      int i = 1;
      paramContext = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localMessageForShortVideo.frienduin, localMessageForShortVideo.uniseq);
      paramInt = i;
      if (paramContext != null) {
        if (!ShortVideoUploadProcessor.class.isInstance(paramContext))
        {
          paramInt = i;
          if (!ShortVideoForwardProcessor.class.isInstance(paramContext)) {}
        }
        else
        {
          boolean bool = ((BaseTransProcessor)paramContext).b();
          int j = localMessageForShortVideo.videoFileStatus;
          if ((!bool) && (j != 1002))
          {
            paramInt = i;
            if (j != 1001) {}
          }
          else
          {
            i = 0;
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(localMessageForShortVideo.frienduin, localMessageForShortVideo.uniseq);
            ((QQMessageFacade)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(19)).a(localMessageForShortVideo.istroop).d(localMessageForShortVideo);
            paramInt = i;
            if (QLog.isColorLevel())
            {
              QLog.d("ShortVideoPTVItemBuilder", 2, "onMenuItemClicked: stop uploading short video");
              paramInt = i;
            }
          }
        }
      }
    } while (paramInt == 0);
    super.a(localMessageForShortVideo);
    return;
    label409:
    super.a(paramInt, paramContext, paramChatMessage);
  }
  
  protected void a(View paramView)
  {
    super.a(paramView);
    paramView = (ShortVideoPTVItemBuilder.Holder)AIOUtils.a(paramView);
    MessageForShortVideo localMessageForShortVideo = (MessageForShortVideo)paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
    if (!localMessageForShortVideo.isSendFromLocal()) {
      return;
    }
    ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(this.jdField_a_of_type_AndroidContentContext, null);
    localActionSheet.a(2131433618, 5);
    localActionSheet.c(2131432998);
    localActionSheet.a(new vcw(this, localMessageForShortVideo, paramView, localActionSheet));
    localActionSheet.show();
  }
  
  protected void a(View paramView, ChatMessage paramChatMessage)
  {
    if (paramChatMessage.isSend())
    {
      paramView.setPadding(0, BaseChatItemLayout.g, 0, BaseChatItemLayout.h);
      return;
    }
    paramView.setPadding(0, BaseChatItemLayout.g, 0, BaseChatItemLayout.h);
  }
  
  public void a(View paramView, FileMsg paramFileMsg, int paramInt1, int paramInt2)
  {
    paramView = (ShortVideoPTVItemBuilder.Holder)AIOUtils.a(paramView);
    Object localObject1 = (MessageForShortVideo)paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
    Object localObject2 = "handleMessage() msgSeq: " + ((MessageForShortVideo)localObject1).uniseq + " ";
    if (((MessageForShortVideo)localObject1).uniseq != paramFileMsg.jdField_b_of_type_Long) {}
    vcy localvcy;
    label870:
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            localvcy = paramView.jdField_a_of_type_Vcy;
            localObject3 = this.jdField_a_of_type_AndroidContentContext.getResources();
            paramInt1 = AIOUtils.a(' ', (Resources)localObject3);
            paramInt2 = AIOUtils.a(' ', (Resources)localObject3);
            if ((paramFileMsg.jdField_b_of_type_Int != 6) && (paramFileMsg.jdField_b_of_type_Int != 17) && (paramFileMsg.jdField_b_of_type_Int != 9) && (paramFileMsg.jdField_b_of_type_Int != 20)) {
              break;
            }
            switch (paramFileMsg.d)
            {
            default: 
              return;
            case 1001: 
              if (QLog.isColorLevel()) {
                QLog.i("ShortVideoPTVItemBuilder", 2, (String)localObject2 + "VIDEO STATUS_SEND_START progress " + ((MessageForShortVideo)localObject1).videoFileProgress);
              }
              paramView.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(false, this);
              return;
            case 1003: 
              if (QLog.isColorLevel()) {
                QLog.i("ShortVideoPTVItemBuilder", 2, (String)localObject2 + "VIDEO STATUS_SEND_FINISHED");
              }
              b(paramView);
              return;
            case 1005: 
              if (QLog.isColorLevel()) {
                QLog.i("ShortVideoPTVItemBuilder", 2, (String)localObject2 + "VIDEO STATUS_SEND_ERROR");
              }
              paramView.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
              b(paramView);
              paramView.jdField_a_of_type_ComTencentMobileqqWidgetAudioAnimationView.setVisibility(8);
              return;
            case 1004: 
              if (QLog.isColorLevel()) {
                QLog.i("ShortVideoPTVItemBuilder", 2, (String)localObject2 + "VIDEO STATUS_SEND_CANCEL");
              }
              b(paramView);
              return;
            case 1002: 
              paramInt1 = ((MessageForShortVideo)localObject1).videoFileProgress;
              if (QLog.isColorLevel()) {
                QLog.i("ShortVideoPTVItemBuilder", 2, (String)localObject2 + "VIDEO STATUS_SEND_PROCESS " + paramInt1);
              }
              a(paramView, paramInt1);
              return;
            case 2001: 
              if (QLog.isColorLevel()) {
                QLog.i("ShortVideoPTVItemBuilder", 2, (String)localObject2 + "VIDEO STATUS_RECV_START");
              }
              a(paramView, ((MessageForShortVideo)localObject1).videoFileProgress);
              return;
            case 2003: 
              if (QLog.isColorLevel()) {
                QLog.i("ShortVideoPTVItemBuilder", 2, (String)localObject2 + "VIDEO STATUS_RECV_FINISHED");
              }
              if (ShortVideoPTVItemBuilder.PtvPlayConfig.jdField_b_of_type_Boolean)
              {
                paramFileMsg = ShortVideoUtils.a((MessageForShortVideo)localObject1, "mp4");
                if (localvcy.a(paramFileMsg))
                {
                  QLog.i("ShortVideoPTVItemBuilder", 2, (String)localObject2 + "handleMessage: 刷视频 " + paramFileMsg);
                  if ((ShortVideoUtils.a()) && (FileUtils.b(paramFileMsg)))
                  {
                    localObject2 = URLDrawable.URLDrawableOptions.obtain();
                    ((URLDrawable.URLDrawableOptions)localObject2).mRequestWidth = paramInt1;
                    ((URLDrawable.URLDrawableOptions)localObject2).mRequestHeight = paramInt2;
                    ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
                    ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
                    localObject3 = new VideoDrawable.VideoDrawableParams();
                    ((VideoDrawable.VideoDrawableParams)localObject3).mPlayVideoFrame = true;
                    ((VideoDrawable.VideoDrawableParams)localObject3).mVideoRoundCorner = 0;
                    ((VideoDrawable.VideoDrawableParams)localObject3).mRequestedFPS = ShortVideoPTVItemBuilder.PtvPlayConfig.jdField_a_of_type_Int;
                    ((URLDrawable.URLDrawableOptions)localObject2).mExtraInfo = localObject3;
                    paramFileMsg = URLDrawable.getDrawable(new File(paramFileMsg), (URLDrawable.URLDrawableOptions)localObject2);
                    if (paramFileMsg.getStatus() != 1) {
                      break label870;
                    }
                    localvcy.b(paramFileMsg);
                  }
                }
                for (;;)
                {
                  if (!((MessageForShortVideo)localObject1).isSend()) {
                    new DCShortVideo(BaseApplication.getContext()).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 2003, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, 1002);
                  }
                  if (((MessageForShortVideo)localObject1).subBusiType == 1) {
                    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006199", "0X8006199", 0, 0, "", "", "" + ((MessageForShortVideo)localObject1).uuid, "" + ((MessageForShortVideo)localObject1).isSend());
                  }
                  b(paramView);
                  paramView.jdField_a_of_type_ComTencentMobileqqWidgetAudioAnimationView.setVisibility(0);
                  return;
                  localvcy.a(paramFileMsg);
                }
              }
              paramFileMsg = ShortVideoUtils.a(((MessageForShortVideo)localObject1).thumbMD5, "jpg");
              if (FileUtils.b(paramFileMsg))
              {
                if (!localvcy.a(paramFileMsg)) {
                  break label965;
                }
                localObject1 = URLDrawable.URLDrawableOptions.obtain();
                ((URLDrawable.URLDrawableOptions)localObject1).mRequestWidth = paramInt1;
                ((URLDrawable.URLDrawableOptions)localObject1).mRequestHeight = paramInt2;
                ((URLDrawable.URLDrawableOptions)localObject1).mLoadingDrawable = jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
                ((URLDrawable.URLDrawableOptions)localObject1).mFailedDrawable = jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
                localvcy.b(URLDrawable.getDrawable(new File(paramFileMsg), (URLDrawable.URLDrawableOptions)localObject1));
              }
              for (;;)
              {
                c(paramView);
                return;
                paramFileMsg = localvcy.b;
                if ((paramFileMsg != null) && (paramFileMsg.getStatus() == 1)) {
                  localvcy.b(paramFileMsg);
                }
              }
            case 5001: 
              if (QLog.isColorLevel()) {
                QLog.i("ShortVideoPTVItemBuilder", 2, "VIDEO STATUS_FILE_UNSAFE");
              }
              b(paramView);
              if (((MessageForShortVideo)localObject1).uiOperatorFlag == 2)
              {
                paramView.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
                QQToast.a(this.jdField_a_of_type_AndroidContentContext, 2131437363, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131558448));
                return;
              }
              QQToast.a(this.jdField_a_of_type_AndroidContentContext, 2131437351, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131558448));
              return;
            case 2005: 
            case 5002: 
              if (QLog.isColorLevel())
              {
                if (paramFileMsg.d == 2005) {
                  QLog.i("ShortVideoPTVItemBuilder", 2, "VIDEO STATUS_RECV_ERROR");
                }
              }
              else
              {
                localObject1 = ShortVideoUtils.a(((MessageForShortVideo)localObject1).thumbMD5, "jpg");
                if (FileUtils.b((String)localObject1))
                {
                  if (!localvcy.a((String)localObject1)) {
                    break label1248;
                  }
                  if (QLog.isColorLevel()) {
                    QLog.i("ShortVideoPTVItemBuilder", 2, "STATUS_FILE_EXPIRED: 刷缩略图 " + (String)localObject1);
                  }
                  localObject2 = URLDrawable.URLDrawableOptions.obtain();
                  ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
                  ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
                  localvcy.b(URLDrawable.getDrawable(new File((String)localObject1), (URLDrawable.URLDrawableOptions)localObject2));
                }
              }
              for (;;)
              {
                if (paramFileMsg.d != 2005) {
                  break label1312;
                }
                b(paramView, 2131432967);
                return;
                QLog.i("ShortVideoPTVItemBuilder", 2, "VIDEO STATUS_FILE_EXPIRED");
                break;
                if (QLog.isColorLevel()) {
                  QLog.i("ShortVideoPTVItemBuilder", 2, "STATUS_FILE_EXPIRED: 刷缩略图用缓存 " + (String)localObject1);
                }
                localObject1 = localvcy.b;
                if ((localObject1 != null) && (((URLDrawable)localObject1).getStatus() == 1)) {
                  localvcy.b((URLDrawable)localObject1);
                }
              }
              b(paramView, 2131432965);
              return;
            }
          } while (!QLog.isColorLevel());
          QLog.i("ShortVideoPTVItemBuilder", 2, "VIDEO STATUS_RECV_CANCEL");
          return;
          paramInt1 = ((MessageForShortVideo)localObject1).videoFileProgress;
          if (QLog.isColorLevel()) {
            QLog.i("ShortVideoPTVItemBuilder", 2, "VIDEO STATUS_RECV_PROCESS " + paramInt1);
          }
          a(paramView, paramInt1);
          return;
        } while ((paramFileMsg.jdField_b_of_type_Int != 7) && (paramFileMsg.jdField_b_of_type_Int != 18) && (paramFileMsg.jdField_b_of_type_Int != 16));
        switch (paramFileMsg.d)
        {
        default: 
          return;
        }
      } while (!QLog.isColorLevel());
      QLog.i("ShortVideoPTVItemBuilder", 2, "THUMB STATUS_RECV_START");
      return;
      localObject2 = ShortVideoUtils.a(((MessageForShortVideo)localObject1).thumbMD5, "jpg");
      paramFileMsg = ShortVideoUtils.a((MessageForShortVideo)localObject1, "mp4");
      boolean bool = FileUtils.b(paramFileMsg);
      if (QLog.isColorLevel()) {
        QLog.i("ShortVideoPTVItemBuilder", 2, "THUMB STATUS_RECV_FINISHED: videoExists=" + bool + ", sAutoPlayInAIO=" + ShortVideoPTVItemBuilder.PtvPlayConfig.jdField_b_of_type_Boolean);
      }
      if ((bool) && (ShortVideoPTVItemBuilder.PtvPlayConfig.jdField_b_of_type_Boolean))
      {
        if (localvcy.a(paramFileMsg))
        {
          if (QLog.isColorLevel()) {
            QLog.i("ShortVideoPTVItemBuilder", 2, "STATUS_RECV_FINISHED: 视频存在,刷缩略图 " + (String)localObject2);
          }
          if (ShortVideoUtils.a())
          {
            localObject1 = URLDrawable.URLDrawableOptions.obtain();
            ((URLDrawable.URLDrawableOptions)localObject1).mRequestWidth = paramInt1;
            ((URLDrawable.URLDrawableOptions)localObject1).mRequestHeight = paramInt2;
            ((URLDrawable.URLDrawableOptions)localObject1).mLoadingDrawable = jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
            ((URLDrawable.URLDrawableOptions)localObject1).mFailedDrawable = jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
            localObject2 = new VideoDrawable.VideoDrawableParams();
            ((VideoDrawable.VideoDrawableParams)localObject2).mPlayVideoFrame = true;
            ((VideoDrawable.VideoDrawableParams)localObject2).mVideoRoundCorner = 0;
            ((VideoDrawable.VideoDrawableParams)localObject2).mRequestedFPS = ShortVideoPTVItemBuilder.PtvPlayConfig.jdField_a_of_type_Int;
            ((URLDrawable.URLDrawableOptions)localObject1).mExtraInfo = localObject2;
            localvcy.b(URLDrawable.getDrawable(new File(paramFileMsg), (URLDrawable.URLDrawableOptions)localObject1));
          }
        }
        for (;;)
        {
          b(paramView);
          return;
          paramFileMsg = localvcy.b;
          if ((paramFileMsg != null) && (paramFileMsg.getStatus() == 1)) {
            localvcy.b(paramFileMsg);
          }
        }
      }
      if (!FileUtils.b((String)localObject2)) {
        break;
      }
    } while (!localvcy.a((String)localObject2));
    label965:
    label1248:
    if (QLog.isColorLevel()) {
      QLog.i("ShortVideoPTVItemBuilder", 2, "STATUS_RECV_FINISHED: 缩略图存在，刷缩略图 " + (String)localObject2);
    }
    label1312:
    Object localObject3 = URLDrawable.URLDrawableOptions.obtain();
    ((URLDrawable.URLDrawableOptions)localObject3).mRequestWidth = paramInt1;
    ((URLDrawable.URLDrawableOptions)localObject3).mRequestHeight = paramInt2;
    ((URLDrawable.URLDrawableOptions)localObject3).mLoadingDrawable = jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
    ((URLDrawable.URLDrawableOptions)localObject3).mFailedDrawable = jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
    localvcy.b(URLDrawable.getDrawable(new File((String)localObject2), (URLDrawable.URLDrawableOptions)localObject3));
    if (!FileUtils.b(paramFileMsg))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a((MessageForShortVideo)localObject1, true))
      {
        if (QLog.isColorLevel()) {
          QLog.i("ShortVideoPTVItemBuilder", 2, "STATUS_RECV_FINISHED: 刷缩略图，视频文件不存在， isNeedPredownload=true, downloadVideo");
        }
        a((MessageForShortVideo)localObject1, true);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.i("ShortVideoPTVItemBuilder", 2, "STATUS_RECV_FINISHED: 刷缩略图，视频文件不存在， isNeedPredownload=false, showPauseProgress");
      }
      c(paramView);
      return;
    }
    if (ShortVideoUtils.a())
    {
      b(paramView);
      return;
    }
    c(paramView);
    return;
    localvcy.setImageDrawable(URLDrawableHelper.a());
    return;
    if (QLog.isColorLevel()) {
      QLog.i("ShortVideoPTVItemBuilder", 2, (String)localObject2 + "THUMB STATUS_FILE_EXPIRED");
    }
    if (QLog.isColorLevel()) {
      QLog.i("ShortVideoPTVItemBuilder", 2, (String)localObject2 + "THUMB STATUS_RECV_ERROR");
    }
    paramFileMsg = ShortVideoUtils.a((MessageForShortVideo)localObject1, "mp4");
    if (FileUtils.b(paramFileMsg)) {
      if (localvcy.a(paramFileMsg))
      {
        QLog.i("ShortVideoPTVItemBuilder", 2, (String)localObject2 + "STATUS_RECV_ERROR: 缩略图下载失败刷视频 " + paramFileMsg);
        if (ShortVideoUtils.a())
        {
          localObject1 = URLDrawable.URLDrawableOptions.obtain();
          ((URLDrawable.URLDrawableOptions)localObject1).mRequestWidth = paramInt1;
          ((URLDrawable.URLDrawableOptions)localObject1).mRequestHeight = paramInt2;
          ((URLDrawable.URLDrawableOptions)localObject1).mLoadingDrawable = jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
          ((URLDrawable.URLDrawableOptions)localObject1).mFailedDrawable = jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
          localObject2 = new VideoDrawable.VideoDrawableParams();
          ((VideoDrawable.VideoDrawableParams)localObject2).mPlayVideoFrame = true;
          ((VideoDrawable.VideoDrawableParams)localObject2).mVideoRoundCorner = 0;
          ((VideoDrawable.VideoDrawableParams)localObject2).mRequestedFPS = ShortVideoPTVItemBuilder.PtvPlayConfig.jdField_a_of_type_Int;
          ((URLDrawable.URLDrawableOptions)localObject1).mExtraInfo = localObject2;
          localvcy.b(URLDrawable.getDrawable(new File(paramFileMsg), (URLDrawable.URLDrawableOptions)localObject1));
        }
      }
    }
    for (;;)
    {
      b(paramView);
      return;
      paramFileMsg = localvcy.b;
      if ((paramFileMsg != null) && (paramFileMsg.getStatus() == 1))
      {
        localvcy.b(paramFileMsg);
        continue;
        localvcy.setImageDrawable(jdField_a_of_type_AndroidGraphicsDrawableColorDrawable);
      }
    }
  }
  
  void a(ShortVideoPTVItemBuilder.Holder paramHolder)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPTVItemBuilder", 2, "showLoading() msgSeq: " + paramHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
    }
    paramHolder.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgressView.setIndeterminate(true);
    paramHolder.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgressView.a();
    paramHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
  }
  
  void a(ShortVideoPTVItemBuilder.Holder paramHolder, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPTVItemBuilder", 2, "showProgress(), progress = " + paramInt + " msgSeq: " + paramHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
    }
    CircleProgressView localCircleProgressView = paramHolder.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgressView;
    int i = paramInt;
    if (paramInt > 100)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoPTVItemBuilder", 2, "startShowProgress, illegal process:" + paramInt + " msgSeq: " + paramHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
      }
      i = 100;
    }
    localCircleProgressView.setIndeterminate(false);
    localCircleProgressView.setProgress(i);
    paramHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
  }
  
  void a(MessageForShortVideo paramMessageForShortVideo)
  {
    ShortVideoReq localShortVideoReq = ShortVideoBusiManager.a(2, 3);
    ShortVideoDownloadInfo localShortVideoDownloadInfo = paramMessageForShortVideo.getDownloadInfo(localShortVideoReq.jdField_b_of_type_Int);
    localShortVideoDownloadInfo.i = ShortVideoUtils.a(paramMessageForShortVideo.thumbMD5, "jpg");
    if (QLog.isColorLevel()) {
      QLog.e("ShortVideoPTVItemBuilder", 2, "downloadThumb thumbPath" + localShortVideoDownloadInfo.i);
    }
    localShortVideoDownloadInfo.a(paramMessageForShortVideo.istroop, 1);
    localShortVideoDownloadInfo.f = 2;
    localShortVideoDownloadInfo.g = 2;
    localShortVideoReq.a(localShortVideoDownloadInfo);
    localShortVideoReq.a(paramMessageForShortVideo);
    ShortVideoBusiManager.a(localShortVideoReq, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
  }
  
  public void a(MessageForShortVideo paramMessageForShortVideo, ShortVideoPTVItemBuilder.Holder paramHolder)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPTVItemBuilder", 2, "startUploadVideo：" + paramMessageForShortVideo.toString());
    }
    Object localObject = ShortVideoUtils.a(paramMessageForShortVideo, "mp4");
    String str = ShortVideoUtils.a(paramMessageForShortVideo.thumbMD5, "jpg");
    if (!FileUtils.b((String)localObject))
    {
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, 1, 2131437340, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131558448));
      paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
      paramMessageForShortVideo.videoFileStatus = 1005;
    }
    do
    {
      return;
      if (!FileUtils.b(str))
      {
        QQToast.a(this.jdField_a_of_type_AndroidContentContext, 1, 2131437341, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131558448));
        paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
        paramMessageForShortVideo.videoFileStatus = 1005;
        return;
      }
      localObject = ShortVideoBusiManager.a(1, 3);
      ((ShortVideoReq)localObject).a(ShortVideoBusiManager.a(((ShortVideoReq)localObject).jdField_b_of_type_Int, paramMessageForShortVideo, (ShortVideoReq)localObject));
      ShortVideoBusiManager.a((ShortVideoReq)localObject, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    } while ((!paramMessageForShortVideo.isSendFromLocal()) || (paramMessageForShortVideo.videoFileStatus != 1005) || (paramMessageForShortVideo.videoFileProgress != 0));
    a(paramHolder, 3);
  }
  
  void a(MessageForShortVideo paramMessageForShortVideo, boolean paramBoolean)
  {
    int j = 1;
    if (paramMessageForShortVideo.videoFileStatus == 5002)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoPTVItemBuilder", 2, "downloadVideo():STATUS_FILE_EXPIRED 短视频已过期不启动下载流程");
      }
      return;
    }
    Object localObject = Environment.getExternalStorageDirectory();
    if ((((File)localObject).exists()) && (((File)localObject).canWrite()))
    {
      i = 1;
      if ((!Environment.getExternalStorageState().equals("mounted")) || (i == 0)) {
        break label109;
      }
    }
    label109:
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        break label114;
      }
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, 1, 2131434753, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131558448));
      return;
      i = 0;
      break;
    }
    label114:
    localObject = ShortVideoBusiManager.a(2, 3);
    ShortVideoDownloadInfo localShortVideoDownloadInfo = paramMessageForShortVideo.getDownloadInfo(((ShortVideoReq)localObject).jdField_b_of_type_Int);
    localShortVideoDownloadInfo.h = ShortVideoUtils.a(paramMessageForShortVideo, "mp4");
    localShortVideoDownloadInfo.a(paramMessageForShortVideo.istroop, 0);
    i = j;
    if (paramBoolean) {
      i = 2;
    }
    localShortVideoDownloadInfo.f = i;
    localShortVideoDownloadInfo.g = 2;
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPTVItemBuilder", 2, " startDownloadVideo downloadvideo fileType==" + localShortVideoDownloadInfo.e + ", uniseq:" + paramMessageForShortVideo.uniseq + "localPath=" + localShortVideoDownloadInfo.h);
    }
    ((ShortVideoReq)localObject).a(localShortVideoDownloadInfo);
    ((ShortVideoReq)localObject).a(paramMessageForShortVideo);
    ShortVideoBusiManager.a((ShortVideoReq)localObject, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
  }
  
  protected boolean a(ChatMessage paramChatMessage, BaseChatItemLayout paramBaseChatItemLayout)
  {
    if (!paramChatMessage.isSendFromLocal()) {}
    do
    {
      do
      {
        return false;
        paramChatMessage = (MessageForShortVideo)paramChatMessage;
      } while ((paramChatMessage.md5 == null) || (paramChatMessage.videoFileStatus == 5002));
      paramBaseChatItemLayout = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramChatMessage.frienduin, paramChatMessage.uniseq);
      if ((paramBaseChatItemLayout instanceof BaseTransProcessor))
      {
        if (((BaseTransProcessor)paramBaseChatItemLayout).c() == 1005L) {}
        for (boolean bool = true;; bool = false) {
          return bool;
        }
      }
      if (paramChatMessage.videoFileStatus == 1005) {
        return true;
      }
    } while ((paramChatMessage.videoFileProgress == 100) || (paramChatMessage.videoFileStatus == 1003) || (paramChatMessage.videoFileStatus == 2003));
    return true;
  }
  
  public QQCustomMenuItem[] a(View paramView)
  {
    int k = 0;
    QQCustomMenu localQQCustomMenu = new QQCustomMenu();
    paramView = (ShortVideoPTVItemBuilder.Holder)AIOUtils.a(paramView);
    MessageForShortVideo localMessageForShortVideo = (MessageForShortVideo)paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
    if ((localMessageForShortVideo.md5 != null) && (FileUtils.b(ShortVideoUtils.a(localMessageForShortVideo, "mp4")))) {
      localQQCustomMenu.a(2131366733, this.jdField_a_of_type_AndroidContentContext.getString(2131431546), 2130838308);
    }
    if (localMessageForShortVideo.md5 != null)
    {
      String str = ShortVideoUtils.a(localMessageForShortVideo.thumbMD5, "jpg");
      ShortVideoUtils.a(localMessageForShortVideo, "mp4");
      if (FileUtils.b(str)) {
        if ((paramView.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgressView == null) || (!paramView.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgressView.a())) {
          break label246;
        }
      }
    }
    label246:
    for (int i = 1;; i = 0)
    {
      int j = k;
      if (paramView.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.c != null)
      {
        j = k;
        if (paramView.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.c.getVisibility() == 0) {
          j = 1;
        }
      }
      if ((localMessageForShortVideo.isSendFromLocal()) && (j == 0)) {
        localQQCustomMenu.a(2131363499, this.jdField_a_of_type_AndroidContentContext.getString(2131435066), 2130838309);
      }
      a(localMessageForShortVideo, localQQCustomMenu);
      if ((i == 0) && (j == 0)) {
        a(localQQCustomMenu, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, localMessageForShortVideo);
      }
      ChatActivityFacade.a(localQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
      return localQQCustomMenu.a();
    }
  }
  
  void b(ShortVideoPTVItemBuilder.Holder paramHolder)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPTVItemBuilder", 2, "hideProgress() msgSeq: " + paramHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
    }
    paramHolder.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgressView.c();
    paramHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
  }
  
  void b(ShortVideoPTVItemBuilder.Holder paramHolder, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPTVItemBuilder", 2, "showWarnProgress() msgSeq: " + paramHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
    }
    paramHolder.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgressView.c();
    paramHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    paramHolder.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130842903);
    paramHolder.jdField_a_of_type_ComTencentMobileqqWidgetAudioAnimationView.setVisibility(4);
  }
  
  public void b(MessageForShortVideo paramMessageForShortVideo)
  {
    if (TextUtils.isEmpty(paramMessageForShortVideo.md5))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoPTVItemBuilder", 2, "Forward menu clicked, md5 is empty.");
      }
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putInt("forward_type", 21);
    localBundle.putBoolean("forward_need_sendmsg", true);
    String str1 = ShortVideoUtils.a(paramMessageForShortVideo.thumbMD5, "jpg");
    localBundle.putString("forward_thumb", str1);
    localBundle.putString("from_uin", ShortVideoUtils.b(paramMessageForShortVideo));
    localBundle.putInt("from_uin_type", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
    localBundle.putString("from_session_uin", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    localBundle.putInt("from_busi_type", paramMessageForShortVideo.busiType);
    localBundle.putInt("file_send_size", paramMessageForShortVideo.videoFileSize);
    localBundle.putInt("file_send_duration", paramMessageForShortVideo.videoFileTime);
    localBundle.putString("file_name", paramMessageForShortVideo.videoFileName);
    localBundle.putInt("file_format", paramMessageForShortVideo.videoFileFormat);
    String str2 = ShortVideoUtils.a(paramMessageForShortVideo);
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPTVItemBuilder", 2, "Forward menu clicked, thumbPath=" + str1 + ",videoPath = " + str2 + ", " + paramMessageForShortVideo.toLogString());
    }
    localBundle.putString("file_send_path", str2);
    localBundle.putString("thumbfile_send_path", str1);
    localBundle.putString("file_shortvideo_md5", paramMessageForShortVideo.md5);
    localBundle.putInt("thumbfile_send_width", paramMessageForShortVideo.thumbWidth);
    localBundle.putInt("thumbfile_send_height", paramMessageForShortVideo.thumbHeight);
    localBundle.putString("thumbfile_md5", paramMessageForShortVideo.thumbMD5);
    localBundle.putString("file_source", paramMessageForShortVideo.fileSource);
    localBundle.putString("file_uuid", paramMessageForShortVideo.uuid);
    localBundle.putInt("file_thumb_Size", paramMessageForShortVideo.thumbFileSize);
    localBundle.putBoolean("support_progressive", paramMessageForShortVideo.supportProgressive);
    localBundle.putInt("file_width", paramMessageForShortVideo.fileWidth);
    localBundle.putInt("file_height", paramMessageForShortVideo.fileHeight);
    localBundle.putBoolean("is_forward_ptv", true);
    localBundle.putInt("special_video_type", paramMessageForShortVideo.specialVideoType);
    if (paramMessageForShortVideo.CheckIsHotVideo())
    {
      localBundle.putString("hot_video_icon", paramMessageForShortVideo.hotVideoIconUrl);
      localBundle.putString("hot_video_icon_sub", paramMessageForShortVideo.hotVideoSubIconUrl);
      localBundle.putString("hot_video_title", paramMessageForShortVideo.hotVideoTitle);
      localBundle.putString("hot_video_url", paramMessageForShortVideo.hotVideoUrl);
    }
    paramMessageForShortVideo = new Intent();
    paramMessageForShortVideo.putExtras(localBundle);
    ForwardBaseOption.a((Activity)this.jdField_a_of_type_AndroidContentContext, paramMessageForShortVideo, 21);
  }
  
  public void b(MessageForShortVideo paramMessageForShortVideo, ShortVideoPTVItemBuilder.Holder paramHolder)
  {
    if (paramMessageForShortVideo == null) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoPTVItemBuilder", 2, "startUploadVideo：" + paramMessageForShortVideo.toString());
      }
      if (!FileUtils.b(ShortVideoUtils.a(paramMessageForShortVideo.thumbMD5, "jpg")))
      {
        QQToast.a(this.jdField_a_of_type_AndroidContentContext, 1, 2131437341, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131558448));
        paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
        paramMessageForShortVideo.videoFileStatus = 1005;
        return;
      }
      if (!TextUtils.isEmpty(paramMessageForShortVideo.videoFileName))
      {
        paramHolder = ShortVideoBusiManager.a(4, 3);
        paramHolder.a(ShortVideoBusiManager.a(paramHolder.jdField_b_of_type_Int, paramMessageForShortVideo, paramHolder));
        ShortVideoBusiManager.a(paramHolder, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.e("ShortVideoPTVItemBuilder", 2, "ShortVideoRealItemBuilder:reForwardVideo() path is empty");
  }
  
  void c(ShortVideoPTVItemBuilder.Holder paramHolder)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPTVItemBuilder", 2, "showPauseProgress() msgSeq: " + paramHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
    }
    paramHolder.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgressView.c();
    paramHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    paramHolder.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130842902);
    paramHolder.jdField_a_of_type_ComTencentMobileqqWidgetAudioAnimationView.setVisibility(4);
  }
  
  public void d()
  {
    super.d();
  }
  
  public void onClick(View paramView)
  {
    ShortVideoPTVItemBuilder.Holder localHolder = (ShortVideoPTVItemBuilder.Holder)AIOUtils.a(paramView);
    MessageForShortVideo localMessageForShortVideo = (MessageForShortVideo)localHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
    if (paramView.getId() == 2131361903) {}
    do
    {
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c())
      {
        QQToast.a(this.jdField_a_of_type_AndroidContentContext, 2131428986, 1).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131558448));
        return;
      }
      if (paramView.getId() != 2131361877) {
        break;
      }
    } while (localMessageForShortVideo.md5 == null);
    Object localObject = ShortVideoUtils.a(localMessageForShortVideo.thumbMD5, "jpg");
    String str = ShortVideoUtils.a(localMessageForShortVideo, "mp4");
    if (QLog.isColorLevel()) {
      QLog.e("ptvitem", 2, "onClick videoPath=" + str + "thumbPath=" + (String)localObject);
    }
    if (!FileUtils.b(str))
    {
      a(localMessageForShortVideo, false);
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005E96", "0X8005E96", 0, 0, "", "", "", "");
    }
    for (;;)
    {
      if (!localMessageForShortVideo.isSend()) {
        new DCShortVideo(BaseApplication.getContext()).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 2003, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, 1003);
      }
      if (localMessageForShortVideo.isBlessMsg) {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006199", "0X8006199", 0, 0, "", "", "" + localMessageForShortVideo.uuid, "" + localMessageForShortVideo.isSend());
      }
      super.onClick(paramView);
      return;
      if (FileUtils.b((String)localObject))
      {
        if ((ShortVideoPTVItemBuilder.PtvPlayConfig.jdField_b_of_type_Boolean) && (ShortVideoUtils.a()))
        {
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005E95", "0X8005E95", 0, 0, "", "", "", "");
          if (this.jdField_a_of_type_ComTencentWidgetListView == null) {
            break;
          }
          if ((localHolder.jdField_a_of_type_Vcy.getDrawable() == null) || (!(localHolder.jdField_a_of_type_Vcy.getDrawable() instanceof URLDrawable))) {
            continue;
          }
          localObject = (URLDrawable)localHolder.jdField_a_of_type_Vcy.getDrawable();
          if ((((URLDrawable)localObject).getStatus() != 1) || (!(((URLDrawable)localObject).getCurrDrawable() instanceof VideoDrawable))) {
            continue;
          }
          localObject = (VideoDrawable)((URLDrawable)localObject).getCurrDrawable();
          if (QLog.isColorLevel()) {
            QLog.d("ShortVideoPTVItemBuilder", 2, " videoDrawable.isAudioPlaying(): " + ((VideoDrawable)localObject).isAudioPlaying());
          }
          if (((VideoDrawable)localObject).isAudioPlaying())
          {
            ((VideoDrawable)localObject).stopAudio();
            localHolder.jdField_a_of_type_ComTencentMobileqqWidgetAudioAnimationView.d();
            jdField_b_of_type_JavaLangRefWeakReference = null;
            continue;
          }
          if (MediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).b()) {
            MediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(true);
          }
          if ((jdField_a_of_type_JavaLangRefWeakReference != null) && (jdField_a_of_type_JavaLangRefWeakReference.get() != null) && (jdField_a_of_type_JavaLangRefWeakReference.get() != localObject) && (((VideoDrawable)jdField_a_of_type_JavaLangRefWeakReference.get()).isAudioPlaying()))
          {
            if (QLog.isColorLevel()) {
              QLog.d("ShortVideoPTVItemBuilder", 2, "onCLick sPlayingAudioDrawable.get() not null && isAudioPlaying, need stop audio.");
            }
            ((VideoDrawable)jdField_a_of_type_JavaLangRefWeakReference.get()).stopAudio();
            if ((jdField_b_of_type_JavaLangRefWeakReference != null) && (jdField_b_of_type_JavaLangRefWeakReference.get() != null))
            {
              a(this.jdField_a_of_type_ComTencentWidgetListView, (ChatMessage)jdField_b_of_type_JavaLangRefWeakReference.get());
              jdField_b_of_type_JavaLangRefWeakReference = null;
            }
          }
          ((VideoDrawable)localObject).resetAndPlayAudioOnce();
          jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(localObject);
          localHolder.jdField_a_of_type_ComTencentMobileqqWidgetAudioAnimationView.c();
          jdField_b_of_type_JavaLangRefWeakReference = new WeakReference(localMessageForShortVideo);
          ((VideoDrawable)localObject).setOnAudioPlayOnceListener(new vcx(this));
          continue;
        }
        ShortVideoRealItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, localMessageForShortVideo, localHolder.jdField_a_of_type_Vcy, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.ShortVideoPTVItemBuilder
 * JD-Core Version:    0.7.0.1
 */