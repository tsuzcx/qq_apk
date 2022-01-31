package com.tencent.mobileqq.activity.aio.item;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.SpannableString;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.pubaccount.PublicAccountReportUtils;
import com.tencent.biz.pubaccount.VideoReporter;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayActivity;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPlayUtils;
import com.tencent.biz.pubaccount.readinjoy.video.VideoVolumeControl;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.component.network.utils.NetworkUtils;
import com.tencent.image.QQLiveDrawable;
import com.tencent.image.QQLiveDrawable.OnDownloadListener;
import com.tencent.image.QQLiveDrawable.OnStateListener;
import com.tencent.image.QQLiveDrawable.QQLiveDrawableParams;
import com.tencent.image.QQLiveImage;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.TouchDelegate;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.ViewHolder;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.FileTransferManager;
import com.tencent.mobileqq.activity.aio.FileTransferManager.Callback;
import com.tencent.mobileqq.activity.aio.OnLongClickAndTouchListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.activity.shortvideo.ShortVideoPlayActivity;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.AccountDpcManager.DpcAccountNames;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.message.BaseMessageManager;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.drawable.EmptyDrawable;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.managers.CUOpenCardGuideMng;
import com.tencent.mobileqq.prediction.PredictionReporter;
import com.tencent.mobileqq.richmedia.dc.DCShortVideo;
import com.tencent.mobileqq.shortvideo.ShortVideoBusiManager;
import com.tencent.mobileqq.shortvideo.ShortVideoConstants;
import com.tencent.mobileqq.shortvideo.ShortVideoDownloadInfo;
import com.tencent.mobileqq.shortvideo.ShortVideoMsgTailHelper;
import com.tencent.mobileqq.shortvideo.ShortVideoReq;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.shortvideo.util.ShortVideoTrimmer;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.AIOVideoPlayController;
import com.tencent.mobileqq.transfile.BaseTransProcessor;
import com.tencent.mobileqq.transfile.FileMsg;
import com.tencent.mobileqq.transfile.ShortVideoDownloadProcessor;
import com.tencent.mobileqq.transfile.ShortVideoForwardProcessor;
import com.tencent.mobileqq.transfile.ShortVideoUploadProcessor;
import com.tencent.mobileqq.transfile.TransFileController;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.utils.AIOSingleReporter;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.MsgUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenuItem;
import com.tencent.mobileqq.widget.BubbleImageView;
import com.tencent.mobileqq.widget.MessageProgressView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import com.tencent.widget.ListView;
import cooperation.qqfav.QfavBuilder;
import cooperation.qqfav.QfavReport;
import cooperation.readinjoy.ReadInJoyHelper;
import java.io.File;
import java.net.URL;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import mqq.os.MqqHandler;
import org.json.JSONException;
import org.json.JSONObject;
import vkn;
import vko;
import vkp;
import vkq;
import vkr;
import vks;
import vkt;
import vku;
import vkv;

public class ShortVideoItemBuilder
  extends BaseBubbleBuilder
  implements QQLiveDrawable.OnDownloadListener, QQLiveDrawable.OnStateListener, FileTransferManager.Callback, ShortVideoConstants
{
  public static AtomicLong a;
  static long jdField_c_of_type_Long;
  static long d;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new vku(this);
  MessageForShortVideo jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo;
  QQCustomDialog jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog;
  private ListView jdField_a_of_type_ComTencentWidgetListView;
  private Runnable jdField_a_of_type_JavaLangRunnable = new vkt(this);
  public int b;
  private Handler b;
  int jdField_c_of_type_Int = -1;
  boolean jdField_c_of_type_Boolean = false;
  
  static
  {
    URLDrawableHelper.b();
    d = 1000L;
    jdField_a_of_type_JavaUtilConcurrentAtomicAtomicLong = new AtomicLong(-1L);
  }
  
  public ShortVideoItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    this.jdField_b_of_type_Int = 0;
    if (paramAIOAnimationConatiner != null) {
      this.jdField_a_of_type_ComTencentWidgetListView = paramAIOAnimationConatiner.jdField_a_of_type_ComTencentWidgetListView;
    }
    this.jdField_b_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  }
  
  public static Drawable a(int paramInt1, int paramInt2)
  {
    return new EmptyDrawable(Color.rgb(214, 214, 214), paramInt1, paramInt2);
  }
  
  public static Drawable a(String paramString, int paramInt1, int paramInt2)
  {
    Drawable localDrawable = a(paramInt1, paramInt2);
    Object localObject = localDrawable;
    if (!TextUtils.isEmpty(paramString)) {}
    try
    {
      localObject = URLDrawable.getDrawable(paramString, localDrawable, localDrawable);
      return localObject;
    }
    catch (Exception localException)
    {
      do
      {
        localObject = localDrawable;
      } while (!QLog.isColorLevel());
      QLog.e("ShortVideoItemBuilder", 2, "getCoverDrawable():  getDrawable Exception, coverUrl=" + paramString, localException);
    }
    return localDrawable;
  }
  
  public static String a(long paramLong)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("qqlive://msgId=").append(paramLong);
    return localStringBuilder.toString();
  }
  
  private String a(String paramString)
  {
    if (paramString == null) {}
    do
    {
      int i;
      do
      {
        return null;
        i = paramString.indexOf(':');
      } while ((i < 0) || (i + 1 >= paramString.length()));
      paramString = paramString.substring(i + 1);
    } while (paramString == null);
    return paramString.trim();
  }
  
  private void a(ShortVideoItemBuilder.Holder paramHolder, View paramView, ChatMessage paramChatMessage)
  {
    if ((paramChatMessage instanceof MessageForShortVideo)) {}
    for (MessageForShortVideo localMessageForShortVideo = (MessageForShortVideo)paramChatMessage;; localMessageForShortVideo = null)
    {
      if (localMessageForShortVideo == null) {}
      do
      {
        return;
        if (QLog.isColorLevel()) {
          QLog.i("ShortVideoItemBuilder", 2, "msgForShortVideo.msgTailType=" + localMessageForShortVideo.msgTailType);
        }
        if ((ShortVideoMsgTailHelper.a(this.jdField_a_of_type_AndroidContentContext, localMessageForShortVideo.msgTailType)) && (paramChatMessage.istroop == 1))
        {
          if (paramHolder.e == null)
          {
            paramHolder.e = new TextView(this.jdField_a_of_type_AndroidContentContext);
            paramHolder.e.setBackgroundResource(2130840660);
            paramHolder.e.setTextSize(1, 12.0F);
            paramHolder.e.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131492969));
            paramHolder.e.setText(ShortVideoMsgTailHelper.b(this.jdField_a_of_type_AndroidContentContext, localMessageForShortVideo.msgTailType));
            paramHolder.e.setSingleLine();
            paramHolder.e.setGravity(16);
            paramHolder.e.setPadding(DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 5.0F), 0, DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 5.0F), 0);
            paramHolder.e.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
            paramChatMessage = new RelativeLayout.LayoutParams(-2, -2);
            paramChatMessage.addRule(3, 2131361877);
            paramChatMessage.addRule(5, 2131361877);
            if ((paramView instanceof ViewGroup)) {
              ((ViewGroup)paramView).addView(paramHolder.e, paramChatMessage);
            }
          }
          paramView = (RelativeLayout.LayoutParams)paramHolder.e.getLayoutParams();
          if (localMessageForShortVideo.isSend()) {}
          for (paramView.leftMargin = BaseChatItemLayout.j;; paramView.leftMargin = BaseChatItemLayout.i)
          {
            paramHolder.e.setTag(localMessageForShortVideo);
            paramHolder.e.setVisibility(0);
            return;
          }
        }
      } while (paramHolder.e == null);
      paramHolder.e.setVisibility(8);
      return;
    }
  }
  
  public void OnDownload(String paramString1, QQLiveDrawable.QQLiveDrawableParams paramQQLiveDrawableParams, String paramString2)
  {
    paramString1 = AIOUtils.a(paramQQLiveDrawableParams.msgUniseq, this.jdField_a_of_type_ComTencentWidgetListView.getAdapter());
    MessageForShortVideo localMessageForShortVideo;
    if ((paramString1 instanceof MessageForShortVideo))
    {
      localMessageForShortVideo = (MessageForShortVideo)paramString1;
      if (((localMessageForShortVideo.fileType != 6) && (localMessageForShortVideo.fileType != 17) && (localMessageForShortVideo.fileType != 9)) || (localMessageForShortVideo.videoFileStatus == 2003)) {}
    }
    label532:
    label537:
    for (;;)
    {
      try
      {
        int j;
        if (!TextUtils.isEmpty(paramString2))
        {
          paramString1 = new JSONObject(paramString2);
          int m = paramString1.getInt("callBackType");
          int k = paramString1.getInt("fileSize");
          int n = paramString1.getInt("newFileSize");
          int i = paramString1.getInt("offset");
          if (m != 7) {
            break label537;
          }
          localMessageForShortVideo.videoFileStatus = 2003;
          localMessageForShortVideo.transferedSize = 0;
          localMessageForShortVideo.videoFileProgress = 100;
          localMessageForShortVideo.serial();
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localMessageForShortVideo.frienduin, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, localMessageForShortVideo.uniseq, localMessageForShortVideo.msgData);
          i = k;
          if (paramString1.has("httpHeader"))
          {
            paramString1 = paramString1.getString("httpHeader");
            if (!TextUtils.isEmpty(paramString1))
            {
              paramString1 = paramString1.split("\r\n");
              if (paramString1 != null)
              {
                j = 1;
                if (j >= paramString1.length) {
                  break label532;
                }
                paramString2 = paramString1[j];
                if (!paramString2.startsWith("User-ReturnCode")) {
                  continue;
                }
                paramString1 = a(paramString2);
                if ((!TextUtils.isEmpty(paramString1)) && (paramString1.equals("-5103059")))
                {
                  paramString2 = a(localMessageForShortVideo.uniseq);
                  if (paramString2 != null)
                  {
                    paramString2.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
                    paramString2.d.setVisibility(8);
                    a(paramString2, 2131432996);
                  }
                  localMessageForShortVideo.videoFileStatus = 5002;
                  localMessageForShortVideo.serial();
                  this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localMessageForShortVideo.frienduin, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, localMessageForShortVideo.uniseq, localMessageForShortVideo.msgData);
                }
                if (QLog.isColorLevel()) {
                  QLog.d("ShortVideoItemBuilder", 2, "OnDownload: User-ReturnCode = " + paramString1);
                }
              }
            }
          }
          if (QLog.isColorLevel())
          {
            paramString1 = new StringBuilder("OnDownload:");
            paramString1.append("uniseq=").append(paramQQLiveDrawableParams.msgUniseq).append("|");
            paramString1.append("callBackType=").append(m).append("|");
            paramString1.append("fileSize=").append(k).append("|");
            paramString1.append("newFileSize=").append(n).append("|");
            paramString1.append("offset=").append(i).append("|");
            QLog.i("ShortVideoItemBuilder", 2, paramString1.toString());
          }
        }
        return;
        j += 1;
        continue;
        paramString1 = null;
      }
      catch (JSONException paramString1)
      {
        paramString1.printStackTrace();
        return;
      }
    }
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    return 0;
  }
  
  public View a(int paramInt1, int paramInt2, ChatMessage paramChatMessage, View paramView, ViewGroup paramViewGroup, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    paramView = super.a(paramInt1, paramInt2, paramChatMessage, paramView, paramViewGroup, paramOnLongClickAndTouchListener);
    if ((paramChatMessage instanceof MessageForShortVideo)) {
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo = ((MessageForShortVideo)paramChatMessage);
    }
    paramViewGroup = FileTransferManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    if (paramViewGroup != null) {
      paramViewGroup.a(paramView, this);
    }
    a((ShortVideoItemBuilder.Holder)paramView.getTag(), paramView, paramChatMessage);
    if (jdField_b_of_type_Boolean) {}
    try
    {
      paramViewGroup = (ShortVideoItemBuilder.Holder)paramView.getTag();
      paramViewGroup.jdField_b_of_type_JavaLangStringBuilder.append(paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.getText());
      paramViewGroup.jdField_b_of_type_JavaLangStringBuilder.append(String.valueOf(((MessageForShortVideo)paramChatMessage).videoFileTime));
      paramViewGroup.jdField_b_of_type_JavaLangStringBuilder.append("秒按钮");
      paramView.setContentDescription(paramViewGroup.jdField_b_of_type_JavaLangStringBuilder.toString());
      return paramView;
    }
    catch (Exception paramChatMessage) {}
    return paramView;
  }
  
  protected View a(ChatMessage paramChatMessage, BaseBubbleBuilder.ViewHolder paramViewHolder, View paramView, BaseChatItemLayout paramBaseChatItemLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    ShortVideoItemBuilder.Holder localHolder = (ShortVideoItemBuilder.Holder)paramViewHolder;
    Object localObject1 = this.jdField_a_of_type_AndroidContentContext.getResources();
    paramBaseChatItemLayout = (MessageForShortVideo)paramChatMessage;
    boolean bool1 = paramBaseChatItemLayout.isSend();
    paramViewHolder = paramView;
    Object localObject2;
    int i;
    if (paramView == null)
    {
      paramViewHolder = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
      paramView = new BubbleImageView(this.jdField_a_of_type_AndroidContentContext);
      paramView.setId(2131366638);
      paramView.setScaleType(ImageView.ScaleType.CENTER_CROP);
      paramView.setRadius(15.0F);
      paramView.d(true);
      paramView.setSharpCornerCor(BubbleImageView.jdField_a_of_type_ArrayOfFloat);
      paramViewHolder.addView(paramView);
      localObject2 = new MessageProgressView(this.jdField_a_of_type_AndroidContentContext);
      ((MessageProgressView)localObject2).setId(2131361903);
      paramViewHolder.addView((View)localObject2);
      ProgressBar localProgressBar = new ProgressBar(this.jdField_a_of_type_AndroidContentContext, null, 0);
      i = AIOUtils.a(50.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      Object localObject3 = new RelativeLayout.LayoutParams(i, i);
      ((RelativeLayout.LayoutParams)localObject3).addRule(13);
      paramViewHolder.addView(localProgressBar, (ViewGroup.LayoutParams)localObject3);
      Object localObject4 = new LinearLayout(this.jdField_a_of_type_AndroidContentContext);
      ((LinearLayout)localObject4).setOrientation(1);
      ((LinearLayout)localObject4).setGravity(17);
      localObject3 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject3).addRule(13);
      paramViewHolder.addView((View)localObject4, (ViewGroup.LayoutParams)localObject3);
      localObject3 = new TextView(this.jdField_a_of_type_AndroidContentContext);
      Object localObject5 = new LinearLayout.LayoutParams(-2, -2);
      ((LinearLayout.LayoutParams)localObject5).topMargin = AIOUtils.a(70.0F, (Resources)localObject1);
      ((TextView)localObject3).setTextColor(-1);
      ((TextView)localObject3).setTextSize(2, 12.0F);
      ((TextView)localObject3).setId(2131361904);
      ((TextView)localObject3).setVisibility(4);
      ((LinearLayout)localObject4).addView((View)localObject3, (ViewGroup.LayoutParams)localObject5);
      localObject4 = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
      ((RelativeLayout)localObject4).setBackgroundResource(2130838370);
      localObject5 = new RelativeLayout.LayoutParams(-1, AIOUtils.a(55.0F, (Resources)localObject1));
      ((RelativeLayout.LayoutParams)localObject5).addRule(5, 2131366638);
      ((RelativeLayout.LayoutParams)localObject5).addRule(7, 2131366638);
      ((RelativeLayout.LayoutParams)localObject5).addRule(8, 2131366638);
      paramViewHolder.addView((View)localObject4, (ViewGroup.LayoutParams)localObject5);
      localObject5 = new TextView(this.jdField_a_of_type_AndroidContentContext);
      ((TextView)localObject5).setTextSize(1, 12.0F);
      ((TextView)localObject5).setTextColor(-1);
      Object localObject6 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject6).leftMargin = AIOUtils.a(7.0F, (Resources)localObject1);
      ((RelativeLayout.LayoutParams)localObject6).bottomMargin = AIOUtils.a(7.0F, (Resources)localObject1);
      ((RelativeLayout.LayoutParams)localObject6).addRule(9);
      ((RelativeLayout.LayoutParams)localObject6).addRule(12);
      ((RelativeLayout)localObject4).addView((View)localObject5, (ViewGroup.LayoutParams)localObject6);
      localObject6 = new TextView(this.jdField_a_of_type_AndroidContentContext);
      ((TextView)localObject6).setTextSize(1, 12.0F);
      ((TextView)localObject6).setTextColor(-1);
      Object localObject7 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject7).rightMargin = AIOUtils.a(7.0F, (Resources)localObject1);
      ((RelativeLayout.LayoutParams)localObject7).bottomMargin = AIOUtils.a(7.0F, (Resources)localObject1);
      ((RelativeLayout.LayoutParams)localObject7).addRule(11);
      ((RelativeLayout.LayoutParams)localObject7).addRule(12);
      ((RelativeLayout)localObject4).addView((View)localObject6, (ViewGroup.LayoutParams)localObject7);
      localObject7 = new TextView(this.jdField_a_of_type_AndroidContentContext);
      ((TextView)localObject7).setTextSize(1, 14.0F);
      ((TextView)localObject7).setTextColor(-1);
      ((TextView)localObject7).setGravity(17);
      ((TextView)localObject7).setText(2131437419);
      ((TextView)localObject7).setShadowLayer(3.0F, 1.0F, 1.0F, -16777216);
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams.topMargin = AIOUtils.a(14.0F, (Resources)localObject1);
      localLayoutParams.addRule(14);
      paramViewHolder.addView((View)localObject7, localLayoutParams);
      paramViewHolder.setOnClickListener(this);
      paramViewHolder.setOnTouchListener(paramOnLongClickAndTouchListener);
      paramViewHolder.setOnLongClickListener(paramOnLongClickAndTouchListener);
      localHolder.jdField_a_of_type_AndroidWidgetProgressBar = localProgressBar;
      localHolder.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView = paramView;
      localHolder.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localObject4);
      localHolder.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localObject5);
      localHolder.jdField_b_of_type_AndroidWidgetTextView = ((TextView)localObject6);
      localHolder.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView = ((MessageProgressView)localObject2);
      localHolder.c = ((TextView)localObject3);
      localHolder.d = ((TextView)localObject7);
    }
    localHolder.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setTag(Long.valueOf(paramBaseChatItemLayout.uniseq));
    AIOSingleReporter.a().a(Long.valueOf(paramBaseChatItemLayout.uniseq), paramBaseChatItemLayout);
    if (localHolder.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.d != bool1)
    {
      localHolder.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.d = bool1;
      localHolder.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.invalidate();
    }
    localHolder.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setOnClickListener(this);
    localHolder.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setOnTouchListener(paramOnLongClickAndTouchListener);
    localHolder.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setOnLongClickListener(paramOnLongClickAndTouchListener);
    localHolder.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setRadius(15.0F, true);
    localHolder.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setShowCorner(true);
    localHolder.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setSharpCornerCor(BubbleImageView.jdField_a_of_type_ArrayOfFloat);
    localHolder.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setCornerDirection(bool1);
    localHolder.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.a(paramChatMessage.frienduin + paramChatMessage.uniseq);
    PredictionReporter.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseChatItemLayout);
    paramView = (RelativeLayout.LayoutParams)localHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
    label999:
    int j;
    int k;
    if (bool1)
    {
      paramView.leftMargin = 0;
      if (localHolder.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.a())
      {
        i = AIOUtils.a(localHolder.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.jdField_a_of_type_Float, (Resources)localObject1);
        paramView.rightMargin = i;
        paramView = (RelativeLayout.LayoutParams)localHolder.d.getLayoutParams();
        if (!bool1) {
          break label1345;
        }
        paramView.rightMargin = (AIOUtils.a(localHolder.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.jdField_a_of_type_Float, (Resources)localObject1) / 2);
        localHolder.jdField_b_of_type_AndroidWidgetTextView.setText(ShortVideoUtils.a(paramBaseChatItemLayout.videoFileTime * 1000));
        paramView = ShortVideoUtils.a(paramBaseChatItemLayout.thumbMD5, "jpg");
        paramOnLongClickAndTouchListener = ShortVideoUtils.a(paramBaseChatItemLayout.thumbWidth, paramBaseChatItemLayout.thumbHeight);
        j = paramOnLongClickAndTouchListener[0];
        k = paramOnLongClickAndTouchListener[1];
        paramOnLongClickAndTouchListener = localHolder.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.getLayoutParams();
        if (paramOnLongClickAndTouchListener != null) {
          break label1367;
        }
        paramOnLongClickAndTouchListener = new RelativeLayout.LayoutParams(j, k);
        localHolder.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setLayoutParams(paramOnLongClickAndTouchListener);
        label1097:
        paramOnLongClickAndTouchListener = localHolder.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.getLayoutParams();
        if (paramOnLongClickAndTouchListener != null) {
          break label1414;
        }
        paramOnLongClickAndTouchListener = new LinearLayout.LayoutParams(j, k);
        localHolder.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setLayoutParams(paramOnLongClickAndTouchListener);
        label1135:
        if (ShortVideoBusiManager.jdField_a_of_type_Boolean)
        {
          ShortVideoBusiManager.jdField_a_of_type_Long = System.currentTimeMillis();
          ShortVideoBusiManager.jdField_a_of_type_Boolean = false;
        }
        paramOnLongClickAndTouchListener = a(j, k);
        b(localHolder);
        if ((paramBaseChatItemLayout.md5 != null) || (paramBaseChatItemLayout.CheckIsHotVideo())) {
          break label1524;
        }
        if (paramBaseChatItemLayout.isSendFromLocal())
        {
          localHolder.jdField_a_of_type_AndroidWidgetTextView.setText("");
          if (FileUtils.b(paramView))
          {
            paramChatMessage = ShortVideoUtils.a(paramView);
            if ((localHolder.jdField_a_of_type_ComTencentImageURLDrawable == null) || (!localHolder.jdField_a_of_type_ComTencentImageURLDrawable.getURL().equals(paramChatMessage)))
            {
              paramChatMessage = URLDrawable.getDrawable(paramChatMessage, j, k, paramOnLongClickAndTouchListener, paramOnLongClickAndTouchListener);
              localHolder.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setImageDrawable(paramChatMessage);
              localHolder.jdField_a_of_type_ComTencentImageURLDrawable = paramChatMessage;
            }
            if (paramBaseChatItemLayout.videoFileStatus != 1005) {
              break label1461;
            }
            localHolder.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setDrawStatus(2);
            a(localHolder, false);
          }
        }
      }
    }
    for (;;)
    {
      label1291:
      return paramViewHolder;
      i = 0;
      break;
      if (localHolder.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.a()) {}
      for (i = AIOUtils.a(localHolder.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.jdField_a_of_type_Float, (Resources)localObject1);; i = 0)
      {
        paramView.leftMargin = i;
        paramView.rightMargin = 0;
        break;
      }
      label1345:
      paramView.leftMargin = (AIOUtils.a(localHolder.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.jdField_a_of_type_Float, (Resources)localObject1) / 2);
      break label999;
      label1367:
      if ((paramOnLongClickAndTouchListener.width == j) && (paramOnLongClickAndTouchListener.height == k)) {
        break label1097;
      }
      paramOnLongClickAndTouchListener.width = j;
      paramOnLongClickAndTouchListener.height = k;
      localHolder.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setLayoutParams(paramOnLongClickAndTouchListener);
      break label1097;
      label1414:
      if ((paramOnLongClickAndTouchListener.width == j) && (paramOnLongClickAndTouchListener.height == k)) {
        break label1135;
      }
      paramOnLongClickAndTouchListener.width = j;
      paramOnLongClickAndTouchListener.height = k;
      localHolder.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setLayoutParams(paramOnLongClickAndTouchListener);
      break label1135;
      label1461:
      a(localHolder, true);
      if (paramBaseChatItemLayout.videoFileStatus == 998) {
        continue;
      }
      com.tencent.image.Utils.executeAsyncTaskOnSerialExcuter(new vkv(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramBaseChatItemLayout), new Void[0]);
      if (!QLog.isColorLevel()) {
        continue;
      }
      QLog.d("ShortVideoItemBuilder", 2, "getBubbleView(): msg.md5 == null, start compress task..");
      return paramViewHolder;
      label1524:
      a(localHolder, false);
      localHolder.jdField_a_of_type_AndroidWidgetTextView.setText(ShortVideoUtils.a(this.jdField_a_of_type_AndroidContentContext, paramBaseChatItemLayout.videoFileSize));
      localHolder.d.setVisibility(8);
      if (FileUtils.b(paramView))
      {
        if ((paramBaseChatItemLayout.videoFileStatus == 998) || (paramBaseChatItemLayout.videoFileStatus == 1001) || (paramBaseChatItemLayout.videoFileStatus == 1002) || (paramBaseChatItemLayout.videoFileStatus == 1004)) {}
        for (i = 1;; i = 0)
        {
          if ((AIOVideoPlayController.a().a(this.jdField_a_of_type_AndroidContentContext, 1, paramBaseChatItemLayout.istroop)) && ((!paramBaseChatItemLayout.isSendFromLocal()) || (i == 0))) {
            break label2010;
          }
          paramChatMessage = ShortVideoUtils.a(paramView);
          if ((localHolder.jdField_a_of_type_ComTencentImageURLDrawable == null) || (!localHolder.jdField_a_of_type_ComTencentImageURLDrawable.getURL().equals(paramChatMessage)))
          {
            paramChatMessage = URLDrawable.getDrawable(paramChatMessage, j, k, paramOnLongClickAndTouchListener, paramOnLongClickAndTouchListener);
            localHolder.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setImageDrawable(paramChatMessage);
            localHolder.jdField_a_of_type_ComTencentImageURLDrawable = paramChatMessage;
          }
          label1704:
          if (QLog.isColorLevel()) {
            QLog.d("ShortVideoItemBuilder", 2, "getBubbleView ，video no exits: sendFromLocal=" + paramBaseChatItemLayout.isSendFromLocal() + "===>  fileType:" + ShortVideoUtils.a(paramBaseChatItemLayout.fileType) + " ===> videoFileStatus:" + ShortVideoUtils.b(paramBaseChatItemLayout.videoFileStatus) + "===> videoFileProgress:" + paramBaseChatItemLayout.videoFileProgress + ", uniseq:" + paramBaseChatItemLayout.uniseq);
          }
          paramChatMessage = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramBaseChatItemLayout.frienduin, paramBaseChatItemLayout.uniseq);
          if ((paramBaseChatItemLayout.fileType != 6) && (paramBaseChatItemLayout.fileType != 17) && (paramBaseChatItemLayout.fileType != 9) && (paramBaseChatItemLayout.fileType != 19) && (paramBaseChatItemLayout.fileType != 20)) {
            break;
          }
          switch (paramBaseChatItemLayout.videoFileStatus)
          {
          default: 
            return paramViewHolder;
          case 1001: 
            if (paramChatMessage != null) {
              break label3043;
            }
            localHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
            b(localHolder);
            if (!QLog.isColorLevel()) {
              break label1291;
            }
            QLog.d("ShortVideoItemBuilder", 2, "getBubbleView : --> STATUS_SEND_START, 上传开始被杀进程然后恢复, uniseq:" + paramBaseChatItemLayout.uniseq);
            return paramViewHolder;
          }
        }
        label2010:
        localObject1 = ShortVideoUtils.a(paramBaseChatItemLayout, "mp4");
        localObject2 = new File((String)localObject1);
        long l1;
        if (((File)localObject2).exists())
        {
          long l2 = ((File)localObject2).length();
          if (paramBaseChatItemLayout.videoFileTime <= 8)
          {
            l1 = paramBaseChatItemLayout.videoFileSize;
            label2064:
            if (l2 < l1) {
              break label2280;
            }
            bool1 = false;
            label2075:
            bool2 = bool1;
            if (QLog.isColorLevel()) {
              QLog.d("ShortVideoItemBuilder", 2, "===> 1 video file  exits, downloadedSize =" + l2 + ", estimatedSize=" + l1 + ", needDownload=" + bool1 + ",videoFileTime=" + paramBaseChatItemLayout.videoFileTime);
            }
          }
        }
        for (boolean bool2 = bool1;; bool2 = true)
        {
          if (!bool2) {
            break label2307;
          }
          if ((NetworkUtil.h(this.jdField_a_of_type_AndroidContentContext)) && (paramBaseChatItemLayout.videoFileStatus != 5002))
          {
            paramChatMessage = ShortVideoBusiManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseChatItemLayout, 2);
            if (paramChatMessage != null) {
              ShortVideoBusiManager.a(paramChatMessage, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
            }
          }
          paramChatMessage = ShortVideoUtils.a(paramView);
          if ((localHolder.jdField_a_of_type_ComTencentImageURLDrawable != null) && (localHolder.jdField_a_of_type_ComTencentImageURLDrawable.getURL().equals(paramChatMessage))) {
            break;
          }
          paramChatMessage = URLDrawable.getDrawable(paramChatMessage, j, k, paramOnLongClickAndTouchListener, paramOnLongClickAndTouchListener);
          localHolder.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setImageDrawable(paramChatMessage);
          localHolder.jdField_a_of_type_ComTencentImageURLDrawable = paramChatMessage;
          break;
          l1 = VideoPlayUtils.a(8, paramBaseChatItemLayout.videoFileTime, paramBaseChatItemLayout.videoFileSize);
          break label2064;
          label2280:
          bool1 = true;
          break label2075;
          if (QLog.isColorLevel()) {
            QLog.d("ShortVideoItemBuilder", 2, "===> 2 video file no exits, need download video.");
          }
        }
        label2307:
        paramOnLongClickAndTouchListener = new QQLiveDrawable.QQLiveDrawableParams();
        paramOnLongClickAndTouchListener.mPreviewWidth = paramBaseChatItemLayout.thumbWidth;
        paramOnLongClickAndTouchListener.mPreviewHeight = paramBaseChatItemLayout.thumbHeight;
        paramOnLongClickAndTouchListener.mDataSourceType = 3;
        paramOnLongClickAndTouchListener.mDataSource = ((String)localObject1);
        if (paramBaseChatItemLayout.videoFileTime <= 8)
        {
          i = 1;
          label2362:
          if (i == 0) {
            paramOnLongClickAndTouchListener.mMaxPlayTimeMs = 8000;
          }
          paramOnLongClickAndTouchListener.mLoopback = true;
          paramOnLongClickAndTouchListener.mPlayType = 2;
          paramOnLongClickAndTouchListener.mListener = this;
          paramOnLongClickAndTouchListener.msgUniseq = paramBaseChatItemLayout.uniseq;
          paramOnLongClickAndTouchListener.mCoverUrl = ShortVideoUtils.a(paramView).toString();
          paramView = URLDrawable.URLDrawableOptions.obtain();
          paramView.mExtraInfo = paramOnLongClickAndTouchListener;
          paramView.mLoadingDrawable = a(paramOnLongClickAndTouchListener.mCoverUrl, j, k);
          paramView = URLDrawable.getDrawable(a(paramBaseChatItemLayout.uniseq), paramView);
          localHolder.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setImageDrawable(paramView);
          localHolder.jdField_a_of_type_ComTencentImageURLDrawable = paramView;
          a(localHolder);
          if (i == 0) {
            localHolder.d.setVisibility(0);
          }
          if ((paramBaseChatItemLayout.CheckIsHotVideo()) && (!AIOSingleReporter.a().a(paramBaseChatItemLayout, "0X8007EDB")))
          {
            AIOSingleReporter.a().a(paramBaseChatItemLayout, "0X8007EDB");
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8007EDB", "0X8007EDB", 0, 0, "", "", "", "");
          }
          if (AIOSingleReporter.a().a(paramBaseChatItemLayout, "0X80077D9")) {
            continue;
          }
          i = VideoReporter.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
          paramView = new JSONObject();
        }
      }
      try
      {
        paramView.put("uin", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
        paramView.put("memNum", i);
        paramView.put("msg_uniseq", paramChatMessage.uniseq);
        PublicAccountReportUtils.a(null, "", "0X80077D9", "0X80077D9", 0, 0, "0", "", "0", VideoReporter.a(paramBaseChatItemLayout.getMd5(), null, null, null, paramView), false);
        AIOSingleReporter.a().a(paramBaseChatItemLayout, "0X80077D9");
        return paramViewHolder;
        i = 0;
        break label2362;
        if (((paramBaseChatItemLayout.fileType == 7) || (paramBaseChatItemLayout.fileType == 18) || (paramBaseChatItemLayout.fileType == 16)) && (paramBaseChatItemLayout.videoFileStatus == 5002))
        {
          localHolder.d.setVisibility(8);
          localHolder.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setImageDrawable(paramOnLongClickAndTouchListener);
          a(localHolder, 2131432996);
          if (!QLog.isColorLevel()) {
            break label1704;
          }
          QLog.d("ShortVideoItemBuilder", 2, "getBubbleView not download pic : 缩略图不存在，而且文件已经过期，不下载, , uniseq:" + paramBaseChatItemLayout.uniseq);
          break label1704;
        }
        if (paramBaseChatItemLayout.extraflag == 32768) {
          break label1704;
        }
        if (QLog.isColorLevel()) {
          QLog.d("ShortVideoItemBuilder", 2, "getBubbleView not SendFromLocal : 缩略图不存在，开始下载缩略图, , uniseq:" + paramBaseChatItemLayout.uniseq);
        }
        localHolder.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setImageDrawable(paramOnLongClickAndTouchListener);
        paramChatMessage = ShortVideoBusiManager.a(2, this.jdField_b_of_type_Int);
        paramView = paramBaseChatItemLayout.getDownloadInfo(paramChatMessage.jdField_b_of_type_Int);
        paramView.i = ShortVideoUtils.a(paramBaseChatItemLayout.thumbMD5, "jpg");
        if ((paramBaseChatItemLayout.istroop == 0) || (paramBaseChatItemLayout.istroop == 1008)) {
          paramView.e = 1002;
        }
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("ShortVideoItemBuilder", 2, " startDownloadVideoThumb downloadVideo fileType=" + paramView.e + ", uniseq:" + paramBaseChatItemLayout.uniseq);
          }
          paramView.f = 2;
          paramChatMessage.a(paramView);
          paramChatMessage.a(paramBaseChatItemLayout);
          ShortVideoBusiManager.a(paramChatMessage, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
          break;
          if (paramBaseChatItemLayout.istroop == 3000) {
            paramView.e = 1006;
          } else if (paramBaseChatItemLayout.istroop == 1) {
            paramView.e = 1004;
          }
        }
        label3043:
        a(localHolder, ShortVideoUtils.a(paramBaseChatItemLayout.videoFileProgress, 10), false);
        return paramViewHolder;
        b(localHolder);
        localHolder.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setDrawStatus(3);
        localHolder.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setImageResource(2130845665);
        return paramViewHolder;
        if (paramChatMessage == null)
        {
          localHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
          b(localHolder);
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("ShortVideoItemBuilder", 2, "getBubbleView : --> STATUS_SEND_PROCESS, 上传过程中被杀进程然后恢复, uniseq:" + paramBaseChatItemLayout.uniseq);
          return paramViewHolder;
        }
        i = paramBaseChatItemLayout.videoFileProgress;
        if ((paramChatMessage instanceof ShortVideoUploadProcessor))
        {
          paramChatMessage = (ShortVideoUploadProcessor)paramChatMessage;
          if (paramChatMessage.a() != 0L)
          {
            i = (int)(100L * paramChatMessage.b() / paramChatMessage.a());
            a(localHolder, ShortVideoUtils.a(i, 10), false);
            return paramViewHolder;
            b(localHolder);
            return paramViewHolder;
            b(localHolder);
            return paramViewHolder;
            b(localHolder);
            return paramViewHolder;
            a(localHolder, 2131432996);
            return paramViewHolder;
          }
        }
      }
      catch (Exception paramChatMessage)
      {
        for (;;) {}
      }
    }
  }
  
  public BaseBubbleBuilder.TouchDelegate a(View paramView)
  {
    if (paramView != null)
    {
      paramView = (ShortVideoItemBuilder.Holder)AIOUtils.a(paramView);
      if (paramView != null) {
        return paramView.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView;
      }
    }
    return null;
  }
  
  protected BaseBubbleBuilder.ViewHolder a()
  {
    return new ShortVideoItemBuilder.Holder();
  }
  
  public ShortVideoItemBuilder.Holder a(long paramLong)
  {
    if ((this.jdField_a_of_type_ComTencentWidgetListView != null) && (paramLong > 0L))
    {
      int i = AIOUtils.a(paramLong, this.jdField_a_of_type_ComTencentWidgetListView.getAdapter());
      int j = this.jdField_a_of_type_ComTencentWidgetListView.getHeaderViewsCount();
      int k = this.jdField_a_of_type_ComTencentWidgetListView.getFirstVisiblePosition();
      int m = this.jdField_a_of_type_ComTencentWidgetListView.getLastVisiblePosition();
      if (i <= -1) {
        break label223;
      }
      Object localObject = AIOUtils.a(this.jdField_a_of_type_ComTencentWidgetListView, i);
      if (localObject != null)
      {
        localObject = AIOUtils.a((View)localObject);
        if ((localObject != null) && ((localObject instanceof ShortVideoItemBuilder.Holder))) {
          return (ShortVideoItemBuilder.Holder)localObject;
        }
      }
      else if (QLog.isColorLevel())
      {
        QLog.w("ShortVideoItemBuilder", 2, "getHolderByMsg() uniseq=" + paramLong + ", posi =" + i + ", view = null");
      }
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoItemBuilder", 2, "getHolderByMsg() uniseq=" + paramLong + ", posi =" + i + ", firstVisblePosi=" + k + ",lastVisblePosi=" + m + ",headerCount=" + j);
      }
    }
    for (;;)
    {
      return null;
      label223:
      if (QLog.isColorLevel()) {
        QLog.w("ShortVideoItemBuilder", 2, "getHolderByMsg() uniseq=" + paramLong + ", posi<= -1");
      }
    }
  }
  
  protected String a(ChatMessage paramChatMessage)
  {
    if (MsgUtils.a(paramChatMessage.issend)) {
      return "发出视频";
    }
    return "发来视频";
  }
  
  public void a()
  {
    super.a();
    if ((this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.isShowing()))
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.dismiss();
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = null;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo != null) && (this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.uniseq != 0L)) {
      URLDrawable.removeMemoryCacheByUrl(a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.uniseq));
    }
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    MessageForShortVideo localMessageForShortVideo;
    if ((paramChatMessage != null) && ((paramChatMessage instanceof MessageForShortVideo)))
    {
      localMessageForShortVideo = (MessageForShortVideo)paramChatMessage;
      this.jdField_c_of_type_Int = paramInt;
      if (paramInt != 2131375633) {
        break label42;
      }
      ChatActivityFacade.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
    }
    for (;;)
    {
      return;
      label42:
      if (paramInt == 2131375643)
      {
        super.c(paramChatMessage);
        return;
      }
      if (paramInt == 2131363536)
      {
        b(localMessageForShortVideo);
        return;
      }
      if (paramInt == 2131366774)
      {
        QfavBuilder.a(localMessageForShortVideo).b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage).a((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
        QfavReport.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 6, 5);
        return;
      }
      if (paramInt == 2131361906)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ShortVideoItemBuilder", 2, "onMenuItemClicked(): msg_revoke =>" + localMessageForShortVideo.toLogString());
        }
        if (localMessageForShortVideo.md5 == null)
        {
          ShortVideoTrimmer.a.set(false);
          paramContext = ShortVideoTrimmer.a();
          if (paramContext != null) {
            paramContext.destroy();
          }
          jdField_a_of_type_JavaUtilConcurrentAtomicAtomicLong.set(localMessageForShortVideo.uniseq);
          ((QQMessageFacade)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(19)).a(localMessageForShortVideo.istroop).d(localMessageForShortVideo);
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80056B1", "0X80056B1", 0, 0, "", "", "", "");
          return;
        }
        paramContext = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localMessageForShortVideo.frienduin, localMessageForShortVideo.uniseq);
        if ((paramContext == null) || ((!ShortVideoUploadProcessor.class.isInstance(paramContext)) && (!ShortVideoForwardProcessor.class.isInstance(paramContext)))) {
          break label458;
        }
        boolean bool = ((BaseTransProcessor)paramContext).b();
        paramInt = localMessageForShortVideo.videoFileStatus;
        if ((!bool) && (paramInt != 1002) && (paramInt != 1001)) {
          break label458;
        }
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(localMessageForShortVideo.frienduin, localMessageForShortVideo.uniseq);
        ((QQMessageFacade)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(19)).a(localMessageForShortVideo.istroop).d(localMessageForShortVideo);
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80056B1", "0X80056B1", 0, 0, "", "", "", "");
        if (QLog.isColorLevel()) {
          QLog.d("ShortVideoItemBuilder", 2, "onMenuItemClicked: stop uploading short video");
        }
      }
      label458:
      for (paramInt = 0; paramInt != 0; paramInt = 1)
      {
        super.a(localMessageForShortVideo);
        return;
        super.a(paramInt, paramContext, paramChatMessage);
        return;
      }
    }
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    paramView = (ShortVideoItemBuilder.Holder)AIOUtils.a(paramView);
    MessageForShortVideo localMessageForShortVideo = (MessageForShortVideo)paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
    if (localMessageForShortVideo.isSendFromLocal())
    {
      ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(this.jdField_a_of_type_AndroidContentContext, null);
      localActionSheet.a(2131433649, 5);
      localActionSheet.c(2131433029);
      localActionSheet.a(new vks(this, localMessageForShortVideo, paramView, localActionSheet));
      localActionSheet.show();
    }
  }
  
  protected void a(View paramView, ChatMessage paramChatMessage)
  {
    int i = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131558623);
    if (paramChatMessage.isSend())
    {
      paramView.setPadding(BaseChatItemLayout.j, BaseChatItemLayout.g, i, BaseChatItemLayout.h);
      return;
    }
    paramView.setPadding(i, BaseChatItemLayout.g, BaseChatItemLayout.j, BaseChatItemLayout.h);
  }
  
  public void a(View paramView, FileMsg paramFileMsg, int paramInt1, int paramInt2)
  {
    paramView = (ShortVideoItemBuilder.Holder)AIOUtils.a(paramView);
    Object localObject1 = (MessageForShortVideo)paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
    Object localObject2 = paramView.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView;
    if (((MessageForShortVideo)localObject1).uniseq != paramFileMsg.jdField_b_of_type_Long) {}
    for (;;)
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoItemBuilder", 2, "handleMessage msg.uniseq:" + ((MessageForShortVideo)localObject1).uniseq + ",fileType:" + ShortVideoUtils.a(paramFileMsg.jdField_b_of_type_Int) + " ===> fileStatus:" + ShortVideoUtils.b(paramFileMsg.d));
      }
      paramInt2 = 0;
      paramInt1 = 0;
      if ((paramFileMsg.jdField_b_of_type_Int == 6) || (paramFileMsg.jdField_b_of_type_Int == 17) || (paramFileMsg.jdField_b_of_type_Int == 9) || (paramFileMsg.jdField_b_of_type_Int == 20)) {}
      switch (paramFileMsg.d)
      {
      default: 
      case 1001: 
        if (paramFileMsg.jdField_a_of_type_Long != 0L) {
          paramInt1 = (int)(100L * paramFileMsg.e / paramFileMsg.jdField_a_of_type_Long);
        }
        a(paramView, ShortVideoUtils.a(paramInt1, 10), true);
        paramView.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(false, this);
        return;
      case 1003: 
        a(paramView, 100, true);
        b(paramView);
        return;
      case 1005: 
        b(paramView);
        paramView.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
        return;
      case 1004: 
        b(paramView);
        ((MessageProgressView)localObject2).setImageResource(2130845665);
        return;
      case 1007: 
        b(paramView);
        return;
      case 1002: 
        if (!((MessageForShortVideo)localObject1).isSendFromLocal()) {
          continue;
        }
        if (paramFileMsg.jdField_a_of_type_Long != 0L) {
          paramInt1 = (int)(100L * paramFileMsg.e / paramFileMsg.jdField_a_of_type_Long);
        }
        for (;;)
        {
          a(paramView, ShortVideoUtils.a(paramInt1, 10), true);
          return;
          paramInt1 = paramInt2;
          if (QLog.isColorLevel())
          {
            QLog.e("ShortVideoItemBuilder", 2, "handleMessage VIDEO ==> STATUS_SEND_PROCESS: fileSize == 0 ");
            paramInt1 = paramInt2;
          }
        }
      case 2001: 
        b(paramView);
        paramView.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(false, this);
        return;
      case 2003: 
        b(paramView);
        paramView = ShortVideoUtils.a(((MessageForShortVideo)localObject1).thumbMD5, "jpg");
        if (FileUtils.b(paramView)) {
          continue;
        }
        paramFileMsg = ShortVideoBusiManager.a(2, this.jdField_b_of_type_Int);
        localObject2 = ((MessageForShortVideo)localObject1).getDownloadInfo(paramFileMsg.jdField_b_of_type_Int);
        ((ShortVideoDownloadInfo)localObject2).i = paramView;
        if ((((MessageForShortVideo)localObject1).istroop == 0) || (((MessageForShortVideo)localObject1).istroop == 1008)) {
          ((ShortVideoDownloadInfo)localObject2).e = 1002;
        }
        for (;;)
        {
          paramFileMsg.a((ShortVideoDownloadInfo)localObject2);
          paramFileMsg.a((MessageForShortVideo)localObject1);
          ShortVideoBusiManager.a(paramFileMsg, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
          return;
          if (((MessageForShortVideo)localObject1).istroop == 3000) {
            ((ShortVideoDownloadInfo)localObject2).e = 1006;
          } else if (((MessageForShortVideo)localObject1).istroop == 1) {
            ((ShortVideoDownloadInfo)localObject2).e = 1004;
          }
        }
      case 2005: 
        b(paramView);
        QQToast.a(this.jdField_a_of_type_AndroidContentContext, 2131437387, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131558448));
        return;
      case 5001: 
        a(paramView, 2131432997);
        if (((MessageForShortVideo)localObject1).uiOperatorFlag == 2)
        {
          paramView.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
          QQToast.a(this.jdField_a_of_type_AndroidContentContext, 2131437400, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131558448));
          return;
        }
        QQToast.a(this.jdField_a_of_type_AndroidContentContext, 2131437388, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131558448));
        return;
      case 5002: 
        a(paramView, 2131432996);
        if (((MessageForShortVideo)localObject1).uiOperatorFlag == 2)
        {
          paramView.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
          QQToast.a(this.jdField_a_of_type_AndroidContentContext, 2131437401, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131558448));
          return;
        }
        QQToast.a(this.jdField_a_of_type_AndroidContentContext, 2131437389, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131558448));
        return;
      case 2004: 
        b(paramView);
        return;
      case 2002: 
        b(paramView);
        a(paramView);
        boolean bool = AIOVideoPlayController.a().a(this.jdField_a_of_type_AndroidContentContext, 1, ((MessageForShortVideo)localObject1).istroop);
        if ((paramFileMsg.c == null) || (!bool)) {
          continue;
        }
        localObject2 = paramFileMsg.c;
        paramFileMsg = paramFileMsg.u;
        if (QLog.isColorLevel()) {
          QLog.d("ShortVideoItemBuilder", 2, "handleMessage VIDEO ==> STATUS_RECV_PROCESS: domain=" + paramFileMsg + ", videoUrls=" + Arrays.toString((Object[])localObject2));
        }
        paramInt1 = 0;
        while (paramInt1 < 1)
        {
          if (!TextUtils.isEmpty(paramFileMsg)) {
            localObject2[paramInt1] = (localObject2[paramInt1] + "&txhost=" + paramFileMsg);
          }
          paramInt1 += 1;
        }
        paramFileMsg = new QQLiveDrawable.QQLiveDrawableParams();
        paramFileMsg.mPreviewWidth = ((MessageForShortVideo)localObject1).thumbWidth;
        paramFileMsg.mPreviewHeight = ((MessageForShortVideo)localObject1).thumbHeight;
        paramFileMsg.mDataSourceType = 4;
        paramFileMsg.mPlayType = 0;
        if ((((MessageForShortVideo)localObject1).videoFileTime == 0) || (((MessageForShortVideo)localObject1).videoFileTime > 8)) {
          paramFileMsg.mMaxPlayTimeMs = 8000;
        }
        paramFileMsg.mLoopback = true;
        paramFileMsg.mServerType = "20160518";
        paramFileMsg.mSavePath = ShortVideoUtils.a((MessageForShortVideo)localObject1, "mp4");
        paramFileMsg.mUrls = ((String[])localObject2);
        paramFileMsg.mVid = ((MessageForShortVideo)localObject1).md5;
        paramFileMsg.msgUniseq = ((MessageForShortVideo)localObject1).uniseq;
        paramFileMsg.mListener = this;
        paramFileMsg.mDownloadListener = this;
        localObject2 = ShortVideoUtils.a(((MessageForShortVideo)localObject1).thumbMD5, "jpg");
        if (FileUtils.b((String)localObject2)) {
          paramFileMsg.mCoverUrl = ShortVideoUtils.a((String)localObject2).toString();
        }
        localObject2 = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject2).mExtraInfo = paramFileMsg;
        Object localObject3 = ShortVideoUtils.a(((MessageForShortVideo)localObject1).thumbWidth, ((MessageForShortVideo)localObject1).thumbHeight);
        paramInt1 = localObject3[0];
        paramInt2 = localObject3[1];
        ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = a(paramFileMsg.mCoverUrl, paramInt1, paramInt2);
        paramFileMsg = URLDrawable.getDrawable(a(((MessageForShortVideo)localObject1).uniseq), (URLDrawable.URLDrawableOptions)localObject2);
        paramView.jdField_a_of_type_ComTencentImageURLDrawable = paramFileMsg;
        paramView.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setImageDrawable(paramFileMsg);
        if ((((MessageForShortVideo)localObject1).CheckIsHotVideo()) && (!AIOSingleReporter.a().a((MessageRecord)localObject1, "0X8007EDB")))
        {
          AIOSingleReporter.a().a((MessageRecord)localObject1, "0X8007EDB");
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8007EDB", "0X8007EDB", 0, 0, "", "", "", "");
        }
        if (AIOSingleReporter.a().a((MessageRecord)localObject1, "0X80077D9")) {
          continue;
        }
        paramInt1 = VideoReporter.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
        paramView = new JSONObject();
        try
        {
          paramView.put("uin", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
          paramView.put("memNum", paramInt1);
          paramView.put("msg_uniseq", ((MessageForShortVideo)localObject1).uniseq);
          label1322:
          PublicAccountReportUtils.a(null, "", "0X80077D9", "0X80077D9", 0, 0, "0", "", "0", VideoReporter.a(((MessageForShortVideo)localObject1).getMd5(), null, null, null, paramView), false);
          AIOSingleReporter.a().a((MessageRecord)localObject1, "0X80077D9");
          return;
          if ((paramFileMsg.jdField_b_of_type_Int != 7) && (paramFileMsg.jdField_b_of_type_Int != 18) && (paramFileMsg.jdField_b_of_type_Int != 16)) {
            continue;
          }
          switch (paramFileMsg.d)
          {
          default: 
          case 2001: 
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.d("ShortVideoItemBuilder", 2, "handleMessage THUMB ==> STATUS_RECV_START:");
            return;
          case 2003: 
            paramFileMsg = ShortVideoUtils.a(((MessageForShortVideo)localObject1).thumbMD5, "jpg");
            localObject2 = ShortVideoUtils.a(((MessageForShortVideo)localObject1).thumbWidth, ((MessageForShortVideo)localObject1).thumbHeight);
            paramInt2 = localObject2[0];
            int i = localObject2[1];
            if (!AIOVideoPlayController.a().a(this.jdField_a_of_type_AndroidContentContext, 1, ((MessageForShortVideo)localObject1).istroop)) {
              continue;
            }
            localObject2 = ShortVideoUtils.a((MessageForShortVideo)localObject1, "mp4");
            localObject3 = new File((String)localObject2);
            long l1;
            if (((File)localObject3).exists())
            {
              long l2 = ((File)localObject3).length();
              if (((MessageForShortVideo)localObject1).videoFileTime <= 8)
              {
                l1 = ((MessageForShortVideo)localObject1).videoFileSize;
                if (l2 < l1) {
                  break label1711;
                }
                paramInt1 = 0;
              }
            }
            for (;;)
            {
              if (paramInt1 == 0) {
                break label1721;
              }
              if (NetworkUtil.h(this.jdField_a_of_type_AndroidContentContext))
              {
                localObject1 = ShortVideoBusiManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (MessageForShortVideo)localObject1, 2);
                if (localObject1 != null) {
                  ShortVideoBusiManager.a((ShortVideoReq)localObject1, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
                }
              }
              paramFileMsg = ShortVideoUtils.a(paramFileMsg);
              localObject1 = a(paramInt2, i);
              if (((paramView.jdField_a_of_type_ComTencentImageURLDrawable != null) && (paramView.jdField_a_of_type_ComTencentImageURLDrawable.getURL().equals(paramFileMsg))) || (paramFileMsg == null)) {
                break;
              }
              try
              {
                paramFileMsg = URLDrawable.getDrawable(paramFileMsg, (Drawable)localObject1, (Drawable)localObject1);
                paramView.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setImageDrawable(paramFileMsg);
                paramView.jdField_a_of_type_ComTencentImageURLDrawable = paramFileMsg;
                return;
              }
              catch (Exception paramView)
              {
                paramView.printStackTrace();
                return;
              }
              l1 = VideoPlayUtils.a(8, ((MessageForShortVideo)localObject1).videoFileTime, ((MessageForShortVideo)localObject1).videoFileSize);
              break label1573;
              paramInt1 = 1;
              continue;
              paramInt1 = 1;
            }
            localObject3 = new QQLiveDrawable.QQLiveDrawableParams();
            ((QQLiveDrawable.QQLiveDrawableParams)localObject3).mPreviewWidth = ((MessageForShortVideo)localObject1).thumbWidth;
            ((QQLiveDrawable.QQLiveDrawableParams)localObject3).mPreviewHeight = ((MessageForShortVideo)localObject1).thumbHeight;
            ((QQLiveDrawable.QQLiveDrawableParams)localObject3).mDataSourceType = 3;
            ((QQLiveDrawable.QQLiveDrawableParams)localObject3).mDataSource = ((String)localObject2);
            if ((((MessageForShortVideo)localObject1).videoFileTime == 0) || (((MessageForShortVideo)localObject1).videoFileTime <= 8)) {}
            for (paramInt1 = 1;; paramInt1 = 0)
            {
              if (paramInt1 == 0) {
                ((QQLiveDrawable.QQLiveDrawableParams)localObject3).mMaxPlayTimeMs = 8000;
              }
              ((QQLiveDrawable.QQLiveDrawableParams)localObject3).mLoopback = true;
              ((QQLiveDrawable.QQLiveDrawableParams)localObject3).mPlayType = 2;
              ((QQLiveDrawable.QQLiveDrawableParams)localObject3).mListener = this;
              ((QQLiveDrawable.QQLiveDrawableParams)localObject3).msgUniseq = ((MessageForShortVideo)localObject1).uniseq;
              ((QQLiveDrawable.QQLiveDrawableParams)localObject3).mCoverUrl = ShortVideoUtils.a(paramFileMsg).toString();
              paramFileMsg = URLDrawable.URLDrawableOptions.obtain();
              paramFileMsg.mExtraInfo = localObject3;
              paramFileMsg.mLoadingDrawable = a(((QQLiveDrawable.QQLiveDrawableParams)localObject3).mCoverUrl, paramInt2, i);
              paramFileMsg = URLDrawable.getDrawable(a(((MessageForShortVideo)localObject1).uniseq), paramFileMsg);
              paramView.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setImageDrawable(paramFileMsg);
              paramView.jdField_a_of_type_ComTencentImageURLDrawable = paramFileMsg;
              a(paramView);
              if (paramInt1 == 0) {
                break;
              }
              paramView.d.setVisibility(8);
              return;
            }
            paramView.d.setVisibility(0);
            return;
          case 2005: 
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.d("ShortVideoItemBuilder", 2, "handleMessage THUMB ==> STATUS_RECV_ERROR:");
            return;
          case 5002: 
            label1573:
            label1711:
            label1721:
            paramFileMsg = ShortVideoUtils.a(((MessageForShortVideo)localObject1).thumbWidth, ((MessageForShortVideo)localObject1).thumbHeight);
            paramInt1 = paramFileMsg[0];
            paramInt2 = paramFileMsg[1];
            paramView.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setImageDrawable(a(paramInt1, paramInt2));
            a(paramView, 2131432996);
            paramView.d.setVisibility(8);
            return;
          }
        }
        catch (Exception paramFileMsg)
        {
          break label1322;
        }
      }
    }
  }
  
  public void a(ShortVideoItemBuilder.Holder paramHolder)
  {
    if (!paramHolder.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.a(paramHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin + paramHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq))
    {
      paramHolder.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setVisibility(8);
      return;
    }
    paramHolder.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setAnimRunnableListener(new vko(this, paramHolder));
  }
  
  void a(ShortVideoItemBuilder.Holder paramHolder, int paramInt)
  {
    paramHolder.c.setVisibility(0);
    paramHolder.c.setText(paramInt);
    paramHolder.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.b(paramHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin + paramHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
    paramHolder.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setVisibility(0);
    paramHolder.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setImageResource(2130845666);
    paramHolder.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setDrawStatus(3);
  }
  
  public void a(ShortVideoItemBuilder.Holder paramHolder, int paramInt, boolean paramBoolean)
  {
    if (paramInt < 100)
    {
      paramHolder.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setDrawStatus(1);
      paramHolder.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setAnimProgress(paramInt, paramHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin + paramHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
    }
    for (;;)
    {
      paramHolder.c.setVisibility(8);
      return;
      paramHolder.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setDrawStatus(1);
      paramHolder.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setAnimProgress(paramInt, paramHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin + paramHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
    }
  }
  
  public void a(ShortVideoItemBuilder.Holder paramHolder, boolean paramBoolean)
  {
    if (paramHolder == null) {
      return;
    }
    if (paramBoolean)
    {
      paramHolder.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
      paramHolder.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setVisibility(0);
      paramHolder.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setDrawStatus(1);
      paramHolder.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setAnimProgress(0, paramHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin + paramHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
    }
    paramHolder.c.setVisibility(8);
  }
  
  public void a(MessageForShortVideo paramMessageForShortVideo, long paramLong)
  {
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800742A", "0X800742A", 0, 0, "", "", "", "");
    if ((VideoVolumeControl.a(this.jdField_a_of_type_AndroidContentContext)) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c()))
    {
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, 0, 2131437399, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131558448));
      return;
    }
    if (!paramMessageForShortVideo.isSend()) {
      new DCShortVideo(BaseApplication.getContext()).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 2002, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, 1001);
    }
    Object localObject = ShortVideoUtils.a(paramMessageForShortVideo.thumbMD5, "jpg");
    Bundle localBundle = new Bundle();
    localBundle.putInt("uintype", paramMessageForShortVideo.istroop);
    localBundle.putString("from_uin", ShortVideoUtils.b(paramMessageForShortVideo));
    localBundle.putInt("from_uin_type", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
    localBundle.putString("from_session_uin", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    localBundle.putInt("from_busi_type", paramMessageForShortVideo.busiType);
    localBundle.putInt("file_send_size", paramMessageForShortVideo.videoFileSize);
    localBundle.putInt("file_send_duration", paramMessageForShortVideo.videoFileTime);
    localBundle.putString("file_name", paramMessageForShortVideo.videoFileName);
    localBundle.putInt("file_format", paramMessageForShortVideo.videoFileFormat);
    localBundle.putString("thumbfile_send_path", (String)localObject);
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
    localBundle.putInt("video_play_caller", 0);
    localBundle.putParcelable("key_message_for_shortvideo", paramMessageForShortVideo);
    localBundle.putLong("message_click_start", System.currentTimeMillis());
    localBundle.putInt("special_video_type", paramMessageForShortVideo.specialVideoType);
    localBundle.putInt("short_video_msg_tail_type", paramMessageForShortVideo.msgTailType);
    if (paramMessageForShortVideo.CheckIsHotVideo())
    {
      localBundle.putBoolean("is_hotVideo", true);
      localBundle.putString("hot_video_icon", paramMessageForShortVideo.hotVideoIconUrl);
      localBundle.putString("hot_video_icon_sub", paramMessageForShortVideo.hotVideoSubIconUrl);
      localBundle.putString("hot_video_title", paramMessageForShortVideo.hotVideoTitle);
      localBundle.putString("hot_video_url", paramMessageForShortVideo.hotVideoUrl);
    }
    localObject = Boolean.valueOf(ReadInJoyHelper.d(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface));
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoItemBuilder", 2, "startPlayerActivity() msg.videoAttr=" + paramMessageForShortVideo.videoAttr + ", msg.istroop=" + paramMessageForShortVideo.istroop + ", isSupportMultiVideoSwitch=" + localObject);
    }
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("md5", paramMessageForShortVideo.md5);
      if ((paramMessageForShortVideo.videoAttr == 1) && ((paramMessageForShortVideo.istroop == 1) || (paramMessageForShortVideo.istroop == 3000)) && (((Boolean)localObject).booleanValue()))
      {
        PublicAccountReportUtils.a(null, "", "0X8007415", "0X8007415", 0, 0, "", "0", "0", VideoReporter.a(paramMessageForShortVideo.getMd5(), null, null, null, localJSONObject), false);
        localObject = new Intent(this.jdField_a_of_type_AndroidContentContext, VideoFeedsPlayActivity.class);
        localBundle.putInt("VIDEO_FROM_TYPE", 1);
        localBundle.putInt("VIDEO_PLAY_STATUS", 0);
        localBundle.putLong("VIDEO_PLAY_POSITION", paramLong);
        localBundle.putInt("REPORT_VIDEO_FEEDS_JUMP_FROM", 2);
        localBundle.putInt("PERFORMANCE_REPORT_VIDEO_FEEDS_JUMP_FROM", 2);
        if ((paramMessageForShortVideo.istroop == 0) && (com.tencent.mobileqq.util.Utils.b(paramMessageForShortVideo.senderuin)) && (!TextUtils.isEmpty(paramMessageForShortVideo.getExtInfoFromExtStr("guide_video_type")))) {
          localBundle.putString("babyq_video_type", paramMessageForShortVideo.getExtInfoFromExtStr("guide_video_type"));
        }
        ((Intent)localObject).putExtras(localBundle);
        ((Activity)this.jdField_a_of_type_AndroidContentContext).startActivityForResult((Intent)localObject, 13002);
        ((Activity)this.jdField_a_of_type_AndroidContentContext).overridePendingTransition(2131034165, 2131034167);
        ThreadManager.getFileThreadHandler().post(this.jdField_a_of_type_JavaLangRunnable);
        PredictionReporter.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForShortVideo);
        return;
      }
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        if (QLog.isColorLevel())
        {
          QLog.d("Q.readinjoy.video", 2, "report JSON fail");
          continue;
          PublicAccountReportUtils.a(null, "", "0X8007415", "0X8007415", 0, 0, "", "1", "0", VideoReporter.a(paramMessageForShortVideo.getMd5(), null, null, null, localJSONObject), false);
          localObject = new Intent(this.jdField_a_of_type_AndroidContentContext, ShortVideoPlayActivity.class);
        }
      }
    }
  }
  
  public void a(MessageForShortVideo paramMessageForShortVideo, ShortVideoItemBuilder.Holder paramHolder)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoItemBuilder", 2, "startUploadVideo：" + paramMessageForShortVideo.toString());
    }
    boolean bool = paramMessageForShortVideo.CheckIsHotVideo();
    String str1 = paramMessageForShortVideo.videoFileName;
    String str2 = ShortVideoUtils.a(paramMessageForShortVideo.thumbMD5, "jpg");
    if ((!FileUtils.b(str1)) && (!bool))
    {
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, 1, 2131437377, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131558448));
      b(paramHolder);
      paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
      paramMessageForShortVideo.videoFileStatus = 1005;
      return;
    }
    if ((!FileUtils.b(str2)) && (!bool))
    {
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, 1, 2131437378, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131558448));
      b(paramHolder);
      paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
      paramMessageForShortVideo.videoFileStatus = 1005;
      return;
    }
    paramHolder = ShortVideoBusiManager.a(1, this.jdField_b_of_type_Int);
    paramMessageForShortVideo = ShortVideoBusiManager.a(this.jdField_b_of_type_Int, paramMessageForShortVideo, paramHolder);
    paramMessageForShortVideo.e = bool;
    paramHolder.a(paramMessageForShortVideo);
    ShortVideoBusiManager.a(paramHolder, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
  }
  
  void a(String paramString, MessageForShortVideo paramMessageForShortVideo)
  {
    if ((paramMessageForShortVideo.CheckIsHotVideo()) && (QLog.isColorLevel()))
    {
      paramMessageForShortVideo = "logHotVideoError ";
      if (paramString != null) {
        paramMessageForShortVideo = "logHotVideoError " + paramString;
      }
      QLog.d("ShortVideoItemBuilder", 2, paramMessageForShortVideo);
    }
  }
  
  protected boolean a(ChatMessage paramChatMessage, BaseChatItemLayout paramBaseChatItemLayout)
  {
    if (paramChatMessage.isMultiMsg) {}
    do
    {
      do
      {
        return false;
      } while (!paramChatMessage.isSendFromLocal());
      paramChatMessage = (MessageForShortVideo)paramChatMessage;
      if (paramChatMessage.videoFileStatus == 1005)
      {
        a("2131 msg.videoFileStatus == FileMsg.STATUS_SEND_ERROR", paramChatMessage);
        return true;
      }
    } while (paramChatMessage.md5 == null);
    int i;
    if (paramChatMessage.uiOperatorFlag == 2) {
      if ((paramChatMessage.videoFileStatus == 5002) || (paramChatMessage.videoFileStatus == 5001))
      {
        i = 1;
        k = i;
        if (i != 0) {
          a("2145 forwardError = true msg.videoFileStatus is " + paramChatMessage.videoFileStatus, paramChatMessage);
        }
      }
    }
    for (int k = i;; k = 0)
    {
      if ((paramChatMessage.videoFileStatus == 1005) || (paramChatMessage.extraflag == 32768)) {
        a("2151 msg.extraflag == MessageRecordInfo.EXTRA_FLAG_SEND_FAIL sendError = true", paramChatMessage);
      }
      for (i = 1;; i = 0)
      {
        int j = i;
        if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramChatMessage.frienduin, paramChatMessage.uniseq) == null)
        {
          if (!paramChatMessage.CheckIsHotVideo()) {
            break label326;
          }
          j = i;
          if (paramChatMessage.videoFileProgress != 100)
          {
            j = i;
            if (paramChatMessage.videoFileStatus != 1003)
            {
              j = i;
              if (paramChatMessage.videoFileStatus != 1004)
              {
                j = i;
                if (paramChatMessage.videoFileStatus != 2009)
                {
                  j = i;
                  if (paramChatMessage.uiOperatorFlag != 2)
                  {
                    j = i;
                    if (paramChatMessage.videoFileStatus != 2003)
                    {
                      j = i;
                      if (paramChatMessage.videoFileStatus != 2002)
                      {
                        a("2164 msg.videoFileProgress = " + paramChatMessage.videoFileProgress + " msg.videoFileStatus = " + paramChatMessage.videoFileStatus, paramChatMessage);
                        j = 1;
                      }
                    }
                  }
                }
              }
            }
          }
        }
        for (;;)
        {
          if ((k == 0) && (j == 0)) {
            break label392;
          }
          return true;
          i = 0;
          break;
          label326:
          j = i;
          if (paramChatMessage.videoFileProgress != 100)
          {
            j = i;
            if (paramChatMessage.videoFileStatus != 1003)
            {
              j = i;
              if (paramChatMessage.videoFileStatus != 1004)
              {
                j = i;
                if (paramChatMessage.videoFileStatus != 2009)
                {
                  j = i;
                  if (paramChatMessage.uiOperatorFlag != 2) {
                    j = 1;
                  }
                }
              }
            }
          }
        }
        label392:
        break;
      }
    }
  }
  
  public QQCustomMenuItem[] a(View paramView)
  {
    boolean bool3 = false;
    ShortVideoItemBuilder.Holder localHolder = (ShortVideoItemBuilder.Holder)AIOUtils.a(paramView);
    MessageForShortVideo localMessageForShortVideo = (MessageForShortVideo)localHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
    QQCustomMenu localQQCustomMenu = new QQCustomMenu();
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoItemBuilder", 2, "getMenuItem, msg.uniseq:" + localMessageForShortVideo.uniseq + ",fileType===>" + ShortVideoUtils.a(localMessageForShortVideo.fileType) + " ===> fileStatus:" + ShortVideoUtils.b(localMessageForShortVideo.videoFileStatus));
    }
    int i;
    boolean bool1;
    label230:
    boolean bool2;
    if ((localMessageForShortVideo != null) && (!TextUtils.isEmpty(localMessageForShortVideo.md5)))
    {
      paramView = ShortVideoUtils.a(localMessageForShortVideo.thumbMD5, "jpg");
      if (FileUtils.b(paramView))
      {
        paramView = "";
        i = 1;
        if (i == 0) {
          break label576;
        }
        if (!"1".equals(DeviceProfileManager.a().a(DeviceProfileManager.AccountDpcManager.DpcAccountNames.shortvideo_forward_switch.name(), "1"))) {
          break label564;
        }
        boolean bool4 = localMessageForShortVideo.checkForward();
        if ((localHolder.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView == null) || (!localHolder.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.a(localHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin + localHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq))) {
          break label571;
        }
        bool1 = true;
        bool2 = bool3;
        if (localHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.c != null)
        {
          bool2 = bool3;
          if (localHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.c.getVisibility() == 0) {
            bool2 = true;
          }
        }
        if ((!bool4) || (bool1) || (bool2)) {
          break label525;
        }
        localQQCustomMenu.a(2131363536, this.jdField_a_of_type_AndroidContentContext.getString(2131435099), 2130838318);
        paramView = paramView + "inMiddleStatus = false, progeressBarShowing = false, errorIconShowing = false, show forward menu.";
      }
    }
    label525:
    label564:
    label571:
    label576:
    for (;;)
    {
      a(localMessageForShortVideo, localQQCustomMenu);
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoItemBuilder", 2, "getMenuItem: " + paramView);
      }
      if ((localMessageForShortVideo != null) && ((localHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.c == null) || (localHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.c.getVisibility() != 0))) {
        a(localQQCustomMenu, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, localMessageForShortVideo);
      }
      if ((localMessageForShortVideo != null) && (FileUtils.b(ShortVideoUtils.a(localMessageForShortVideo, "mp4")))) {
        localQQCustomMenu.a(2131366774, this.jdField_a_of_type_AndroidContentContext.getString(2131431574), 2130838317);
      }
      ChatActivityFacade.a(localQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
      super.b(localQQCustomMenu, this.jdField_a_of_type_AndroidContentContext);
      this.jdField_c_of_type_Boolean = true;
      return localQQCustomMenu.a();
      paramView = "thumbFilePath=" + paramView + " , not exits.";
      i = 0;
      break;
      paramView = " msg == null or md5 is empty.";
      i = 0;
      break;
      paramView = paramView + "progeressBarShowing=" + bool1 + ", errorIconShowing=" + bool2;
      continue;
      paramView = " not inDPCWhiteList.";
      continue;
      bool1 = false;
      break label230;
    }
  }
  
  public void b(ShortVideoItemBuilder.Holder paramHolder)
  {
    paramHolder.c.setVisibility(8);
    if (!paramHolder.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.a(paramHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin + paramHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq))
    {
      paramHolder.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setDrawStatus(2);
      return;
    }
    paramHolder.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setAnimRunnableListener(new vkn(this, paramHolder));
  }
  
  public void b(MessageForShortVideo paramMessageForShortVideo)
  {
    if (TextUtils.isEmpty(paramMessageForShortVideo.md5))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoItemBuilder", 2, "Forward menu clicked, md5 is empty.");
      }
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putInt("forward_type", 21);
    localBundle.putBoolean("forward_is_long_video", true);
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
      QLog.d("ShortVideoItemBuilder", 2, "Forward menu clicked, videoPath=" + str2 + ",videoPath = " + str2 + ", " + paramMessageForShortVideo.toLogString());
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
    localBundle.putInt("special_video_type", paramMessageForShortVideo.specialVideoType);
    localBundle.putInt("short_video_msg_tail_type", paramMessageForShortVideo.msgTailType);
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
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80052CC", "0X80052CC", 0, 0, "", "1", "", "");
  }
  
  public void b(MessageForShortVideo paramMessageForShortVideo, long paramLong)
  {
    if (paramMessageForShortVideo.videoFileStatus == 998) {
      return;
    }
    String str = ShortVideoUtils.a(paramMessageForShortVideo, "mp4");
    boolean bool2 = NetworkUtils.isMobileConnected(this.jdField_a_of_type_AndroidContentContext);
    if ((ShortVideoBusiManager.jdField_a_of_type_Long != 0L) && (System.currentTimeMillis() - ShortVideoBusiManager.jdField_a_of_type_Long < 300000L)) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoItemBuilder", 2, "startPlayVideo isConfirmed=" + bool1 + " allowPlayInXGTime=" + ShortVideoBusiManager.jdField_a_of_type_Long + " isXGConnected = " + bool2);
      }
      if ((!bool2) || (bool1) || ((FileUtils.a(str)) && (paramMessageForShortVideo.videoFileStatus != 2002))) {
        break;
      }
      str = this.jdField_a_of_type_AndroidContentContext.getString(2131428448);
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = DialogUtil.a(this.jdField_a_of_type_AndroidContentContext, 230, this.jdField_a_of_type_AndroidContentContext.getString(2131428449), str, this.jdField_a_of_type_AndroidContentContext.getString(2131428450), this.jdField_a_of_type_AndroidContentContext.getString(2131428451), new vkq(this, paramMessageForShortVideo, paramLong), new vkr(this));
      paramMessageForShortVideo = CUOpenCardGuideMng.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, str);
      if ((paramMessageForShortVideo instanceof SpannableString)) {
        this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setMessageWithoutAutoLink(paramMessageForShortVideo);
      }
      try
      {
        this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
        return;
      }
      catch (Throwable paramMessageForShortVideo)
      {
        return;
      }
    }
    a(paramMessageForShortVideo, paramLong);
    ShortVideoUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "0X8008E53", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramMessageForShortVideo, this.jdField_a_of_type_AndroidContentContext);
  }
  
  public void b(MessageForShortVideo paramMessageForShortVideo, ShortVideoItemBuilder.Holder paramHolder)
  {
    if (paramMessageForShortVideo == null) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoItemBuilder", 2, "reForwardVideo：" + paramMessageForShortVideo.toString());
      }
      if (!FileUtils.b(ShortVideoUtils.a(paramMessageForShortVideo.thumbMD5, "jpg")))
      {
        QQToast.a(this.jdField_a_of_type_AndroidContentContext, 1, 2131437378, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131558448));
        b(paramHolder);
        paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
        paramMessageForShortVideo.videoFileStatus = 1005;
        return;
      }
      if (!TextUtils.isEmpty(paramMessageForShortVideo.videoFileName))
      {
        paramHolder = ShortVideoBusiManager.a(4, this.jdField_b_of_type_Int);
        paramHolder.a(ShortVideoBusiManager.a(this.jdField_b_of_type_Int, paramMessageForShortVideo, paramHolder));
        ShortVideoBusiManager.a(paramHolder, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.e("ShortVideoItemBuilder", 2, "ShortVideoItemBuilder:reForwardVideo() path is empty");
  }
  
  public void c(MessageForShortVideo paramMessageForShortVideo)
  {
    b(paramMessageForShortVideo, 0L);
  }
  
  public void d()
  {
    super.d();
    this.jdField_c_of_type_Int = -1;
    this.jdField_c_of_type_Boolean = false;
  }
  
  public void onClick(View paramView)
  {
    super.onClick(paramView);
    AIOUtils.m = true;
    long l = System.currentTimeMillis();
    if ((l - jdField_c_of_type_Long < d) && (l > jdField_c_of_type_Long)) {
      if (QLog.isColorLevel()) {
        QLog.e("ShortVideoItemBuilder", 2, "click too offen,please try again later ");
      }
    }
    do
    {
      return;
      jdField_c_of_type_Long = l;
    } while ((paramView.getId() != 2131361877) && (paramView.getId() != 2131361903));
    paramView = (ShortVideoItemBuilder.Holder)AIOUtils.a(paramView);
    MessageForShortVideo localMessageForShortVideo = (MessageForShortVideo)paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
    int i = localMessageForShortVideo.videoFileStatus;
    if ((paramView.jdField_a_of_type_ComTencentImageURLDrawable != null) && (paramView.jdField_a_of_type_ComTencentImageURLDrawable.getStatus() == 1) && ((paramView.jdField_a_of_type_ComTencentImageURLDrawable.getCurrDrawable() instanceof QQLiveDrawable))) {}
    for (l = ((QQLiveDrawable)paramView.jdField_a_of_type_ComTencentImageURLDrawable.getCurrDrawable()).getCurrentPosition();; l = 0L)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoItemBuilder", 2, "click ppv, msg.uniseq:" + localMessageForShortVideo.uniseq + ",fileType: " + ShortVideoUtils.a(localMessageForShortVideo.fileType) + ", fileStatus:" + ShortVideoUtils.b(i) + ", playPosition:" + l);
      }
      StringBuilder localStringBuilder = new StringBuilder("");
      localStringBuilder.append("......click ppv, msg.uniseq:" + localMessageForShortVideo.uniseq);
      Object localObject = ShortVideoUtils.a(localMessageForShortVideo, "mp4");
      if (!localMessageForShortVideo.isSendFromLocal())
      {
        localStringBuilder.append(" sendFromLocal:false ");
        if (!FileUtils.b((String)localObject))
        {
          localStringBuilder.append(" videoPathExists:false ");
          if ((localMessageForShortVideo.fileType == 6) || (localMessageForShortVideo.fileType == 17) || (localMessageForShortVideo.fileType == 9))
          {
            localStringBuilder.append(" fileType:video, =" + ShortVideoUtils.a(localMessageForShortVideo.fileType));
            if (i == 2005)
            {
              b(paramView);
              QQToast.a(this.jdField_a_of_type_AndroidContentContext, 2131437387, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131558448));
              localStringBuilder.append(" result:toast recv_error ");
            }
          }
        }
      }
      while (QLog.isColorLevel())
      {
        QLog.i("ShortVideoItemBuilder", 2, localStringBuilder.toString());
        return;
        if ((i == 2002) || (i == 2000) || (i == 2008) || (i == 2001))
        {
          b(paramView);
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localMessageForShortVideo.frienduin, localMessageForShortVideo.uniseq);
          localStringBuilder.append("status:process or r p s, result: pauseRecving ");
        }
        else if (i == 5001)
        {
          b(paramView);
          QQToast.a(this.jdField_a_of_type_AndroidContentContext, 2131437388, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131558448));
          localStringBuilder.append(" result: toast file_unsafe ");
        }
        else if (i == 5002)
        {
          a(paramView, 2131432996);
          QQToast.a(this.jdField_a_of_type_AndroidContentContext, 2131437389, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131558448));
          localStringBuilder.append(" result: toast file_expired ");
        }
        else
        {
          b(paramView);
          b(localMessageForShortVideo, l);
          localStringBuilder.append(" status:other, result: download ");
          continue;
          if (i == 5002)
          {
            a(paramView, 2131432996);
            QQToast.a(this.jdField_a_of_type_AndroidContentContext, 2131437389, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131558448));
            localStringBuilder.append("fileType:not video,videoPathExits:false, result:toast file_expired ");
          }
          else
          {
            b(paramView);
            b(localMessageForShortVideo, l);
            localStringBuilder.append("fileType:not video,videoPathExits:false, result: download");
            continue;
            b(paramView);
            b(localMessageForShortVideo, l);
            localStringBuilder.append("videoPathExists:true, result:play ");
            continue;
            localStringBuilder.append(" sendFromLocal:true ");
            if (localMessageForShortVideo.isMultiMsg) {
              localMessageForShortVideo.extraflag = 32772;
            }
            boolean bool;
            if (FileUtils.b(localMessageForShortVideo.videoFileName))
            {
              localStringBuilder.append(" localUploadPath Exists:true ");
              if ((localMessageForShortVideo.fileType == 6) || (localMessageForShortVideo.fileType == 17) || (localMessageForShortVideo.fileType == 9))
              {
                localStringBuilder.append(" fileType:video ");
                localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localMessageForShortVideo.frienduin, localMessageForShortVideo.uniseq);
                if (localObject != null)
                {
                  if ((ShortVideoUploadProcessor.class.isInstance(localObject)) || (ShortVideoForwardProcessor.class.isInstance(localObject)))
                  {
                    if ((((BaseTransProcessor)localObject).b()) || (i == 1004)) {}
                    for (bool = true;; bool = false)
                    {
                      localStringBuilder.append(" processor:up or forward, pause:" + bool);
                      if (!bool) {
                        break label997;
                      }
                      a(paramView, 10, false);
                      localMessageForShortVideo.videoFileStatus = 1002;
                      if (localMessageForShortVideo.uiOperatorFlag != 2) {
                        break label969;
                      }
                      b(localMessageForShortVideo, paramView);
                      localStringBuilder.append(" uiOper:forward, result:reforward ");
                      break;
                    }
                    label969:
                    if (localMessageForShortVideo.uiOperatorFlag == 1)
                    {
                      a(localMessageForShortVideo, paramView);
                      localStringBuilder.append(" uiOper:upload, result:upload ");
                      continue;
                      label997:
                      if (i == 1005)
                      {
                        b(paramView);
                        paramView.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
                        localStringBuilder.append(" status:send_error, result:show send error ");
                      }
                      else if ((i == 1002) || (i == 1001))
                      {
                        b(localMessageForShortVideo, l);
                        localStringBuilder.append(" status:process or start, result:pauseSending ");
                      }
                      else
                      {
                        b(paramView);
                        b(localMessageForShortVideo, l);
                        localStringBuilder.append(" status:other, result:play ");
                      }
                    }
                  }
                  else if (ShortVideoDownloadProcessor.class.isInstance(localObject))
                  {
                    localStringBuilder.append(" processor:not up of forward, result: none");
                  }
                }
                else if ((i == 1004) && (localMessageForShortVideo.extraflag == 32772))
                {
                  a(paramView, 10, false);
                  a(localMessageForShortVideo, paramView);
                  localStringBuilder.append(" processor:null, but send_cancel && msg_sending, result:upload ");
                }
                else
                {
                  b(paramView);
                  b(localMessageForShortVideo, l);
                  localStringBuilder.append(" processor:null, result:play ");
                }
              }
              else
              {
                b(paramView);
                b(localMessageForShortVideo, l);
                localStringBuilder.append(" fileType:not video, result: play ");
              }
            }
            else
            {
              localStringBuilder.append(" localUploadPath Exists:false ");
              if (!FileUtils.b(ShortVideoUtils.a(localMessageForShortVideo, "mp4")))
              {
                localStringBuilder.append(" downloadPath Exists:false ");
                if ((localMessageForShortVideo.fileType == 6) || (localMessageForShortVideo.fileType == 17) || (localMessageForShortVideo.fileType == 9))
                {
                  localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localMessageForShortVideo.frienduin, localMessageForShortVideo.uniseq);
                  if (localObject != null)
                  {
                    if (ShortVideoDownloadProcessor.class.isInstance(localObject))
                    {
                      bool = ((ShortVideoDownloadProcessor)localObject).b();
                      localStringBuilder.append(" processor:download, pause:" + bool);
                      if (bool)
                      {
                        b(paramView);
                        b(localMessageForShortVideo, l);
                        localStringBuilder.append(" pause:true, result:download ");
                      }
                      else if (i == 2005)
                      {
                        b(paramView);
                        QQToast.a(this.jdField_a_of_type_AndroidContentContext, 2131437387, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131558448));
                        localStringBuilder.append(" status:recv_error, result:toast recv_error ");
                      }
                      else if ((i == 2002) || (i == 2000) || (i == 2008) || (i == 2001))
                      {
                        b(paramView);
                      }
                      else if (i == 5001)
                      {
                        b(paramView);
                        QQToast.a(this.jdField_a_of_type_AndroidContentContext, 2131437388, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131558448));
                        localStringBuilder.append(" status:file_unsafe, result:toast unsafe ");
                      }
                      else if (i == 5002)
                      {
                        a(paramView, 2131432996);
                        QQToast.a(this.jdField_a_of_type_AndroidContentContext, 2131437389, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131558448));
                        localStringBuilder.append(" status:file_expired, result:toast expired ");
                      }
                      else
                      {
                        b(paramView);
                        b(localMessageForShortVideo, l);
                        localStringBuilder.append(" status:other, result:download ");
                      }
                    }
                    else if (ShortVideoUploadProcessor.class.isInstance(localObject))
                    {
                      b(paramView);
                      paramView.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
                      QQToast.a(this.jdField_a_of_type_AndroidContentContext, 2131437377, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131558448));
                      localStringBuilder.append(" processor:upload, result:show upload error and show toast");
                    }
                    else if (ShortVideoForwardProcessor.class.isInstance(localObject))
                    {
                      bool = ((ShortVideoForwardProcessor)localObject).b();
                      localStringBuilder.append(" processor:forward, pause:" + bool);
                      if (bool)
                      {
                        a(paramView, 10, false);
                        b(localMessageForShortVideo, paramView);
                        localStringBuilder.append(" pause:true, result:reforward ");
                      }
                      else if (i == 5001)
                      {
                        b(paramView);
                        paramView.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
                        QQToast.a(this.jdField_a_of_type_AndroidContentContext, 2131437400, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131558448));
                        localStringBuilder.append(" status:unsafe, result:toast unsafe ");
                      }
                      else if (i == 5002)
                      {
                        a(paramView, 2131432996);
                        paramView.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
                        QQToast.a(this.jdField_a_of_type_AndroidContentContext, 2131437401, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131558448));
                        localStringBuilder.append(" status:expired, result:toast expired ");
                      }
                      else if (i == 1005)
                      {
                        b(paramView);
                        paramView.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
                        localStringBuilder.append(" status:send_error, result:show send_error ");
                      }
                      else if ((i == 1002) || (i == 1001))
                      {
                        c(localMessageForShortVideo);
                      }
                      else
                      {
                        b(paramView);
                        c(localMessageForShortVideo);
                        localStringBuilder.append(" status:other, result:plau ");
                      }
                    }
                    else
                    {
                      localStringBuilder.append(" processor:not down or forward or up, result:none ");
                    }
                  }
                  else
                  {
                    b(paramView);
                    localStringBuilder.append(" processor:null, result:download ");
                    c(localMessageForShortVideo);
                  }
                }
                else
                {
                  b(paramView);
                  b(localMessageForShortVideo, l);
                  localStringBuilder.append(" fileType:not video, result:download ");
                }
              }
              else
              {
                b(paramView);
                b(localMessageForShortVideo, l);
                localStringBuilder.append(" downloadPath Exists:true，result:play ");
              }
            }
          }
        }
      }
      break;
    }
  }
  
  public void onStateChange(String paramString, QQLiveDrawable.QQLiveDrawableParams paramQQLiveDrawableParams, int paramInt, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoItemBuilder", 2, "onStateChange => " + QQLiveImage.getStateStr(paramInt) + ", msgUniseq=" + paramQQLiveDrawableParams.msgUniseq + ", extra = " + paramObject);
    }
    if (paramInt == 2)
    {
      paramString = AIOSingleReporter.a().a(Long.valueOf(paramQQLiveDrawableParams.msgUniseq));
      if ((!AIOSingleReporter.a().a(Long.valueOf(paramQQLiveDrawableParams.msgUniseq))) && (paramString != null))
      {
        ShortVideoUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "0X8008E51", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramString, this.jdField_a_of_type_AndroidContentContext);
        if (!AIOSingleReporter.a().b(Long.valueOf(paramString.uniseq)))
        {
          AIOSingleReporter.a().a(Long.valueOf(paramString.uniseq));
          ShortVideoUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "0X8008E50", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramString, this.jdField_a_of_type_AndroidContentContext);
        }
        AIOSingleReporter.a().a(Long.valueOf(paramQQLiveDrawableParams.msgUniseq), true);
      }
    }
    ShortVideoItemBuilder.Holder localHolder = a(paramQQLiveDrawableParams.msgUniseq);
    if (localHolder == null) {
      if (QLog.isColorLevel()) {
        QLog.w("ShortVideoItemBuilder", 2, "holder == null, msgUniseq=" + paramQQLiveDrawableParams.msgUniseq);
      }
    }
    for (;;)
    {
      return;
      paramString = (MessageForShortVideo)localHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
      if (paramString.videoFileTime <= 8) {}
      for (boolean bool = true; paramInt == 3; bool = false)
      {
        this.jdField_b_of_type_AndroidOsHandler.postDelayed(new vkp(this, bool, localHolder), 1200L);
        return;
      }
      if ((paramInt == 5) || (paramInt == 6))
      {
        this.jdField_b_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
        localHolder.d.setVisibility(8);
        localHolder.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setVisibility(0);
        b(localHolder);
        localHolder.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
        localHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
        return;
      }
      if (paramInt == 2)
      {
        this.jdField_b_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
        if (bool) {
          localHolder.d.setVisibility(8);
        }
        for (;;)
        {
          a(localHolder);
          localHolder.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
          localHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
          return;
          localHolder.d.setVisibility(0);
        }
      }
      if (paramInt == 8)
      {
        if ((paramObject instanceof Long))
        {
          long l = ((Long)paramObject).longValue();
          if ((l < 300L) && (l != -1L)) {}
        }
        for (paramInt = 1; paramInt != 0; paramInt = 0)
        {
          paramInt = VideoReporter.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
          paramObject = new JSONObject();
          try
          {
            paramObject.put("uin", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
            paramObject.put("memNum", paramInt);
            paramObject.put("msg_uniseq", paramQQLiveDrawableParams.msgUniseq);
            label540:
            PublicAccountReportUtils.a(null, "", "0X8007414", "0X8007414", 0, 0, "0", "", "0", VideoReporter.a(paramString.getMd5(), null, null, null, paramObject), false);
            return;
          }
          catch (Exception paramQQLiveDrawableParams)
          {
            break label540;
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.ShortVideoItemBuilder
 * JD-Core Version:    0.7.0.1
 */