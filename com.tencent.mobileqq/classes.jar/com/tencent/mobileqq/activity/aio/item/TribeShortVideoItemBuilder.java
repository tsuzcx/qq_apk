package com.tencent.mobileqq.activity.aio.item;

import acex;
import aekt;
import aelt;
import aeov;
import afzh;
import afzi;
import afzj;
import afzk;
import afzl;
import aljq;
import alpo;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.GradientDrawable.Orientation;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import apgg;
import arum;
import ayvc;
import azag;
import azmj;
import bcid;
import bcwh;
import bdan;
import bdkz;
import bdlb;
import bduw;
import bdvv;
import bdvx;
import bdwa;
import com.tencent.biz.qqstory.view.widget.AutoStartProgressBar;
import com.tencent.image.QQLiveDrawable.QQLiveDrawableParams;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.WebSsoBody.WebSsoRequestBody;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForTribeShortVideo;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.widget.BubbleImageView;
import com.tencent.mobileqq.widget.PAVideoView;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import mqq.app.NewIntent;
import mzx;
import org.json.JSONObject;
import ujf;
import ujl;
import urr;

public class TribeShortVideoItemBuilder
  extends BaseBubbleBuilder
{
  public afzk a;
  protected Drawable a;
  public View.OnClickListener a;
  protected bdwa a;
  protected ujf a;
  protected float[] a;
  protected final float b;
  protected Context b;
  protected Drawable b;
  protected int c;
  protected int d;
  protected int e;
  protected int f;
  protected boolean f;
  protected int g;
  
  public TribeShortVideoItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    this.jdField_b_of_type_Float = 15.0F;
    this.jdField_a_of_type_Ujf = new ujf();
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new afzh(this);
    this.jdField_a_of_type_Afzk = new afzj(this);
    this.jdField_b_of_type_AndroidContentContext = paramContext;
    float f1 = bcwh.a(this.jdField_b_of_type_AndroidContentContext, 15.0F);
    this.jdField_a_of_type_ArrayOfFloat = new float[] { 0.0F, 0.0F, 0.0F, 0.0F, f1, f1, f1, f1 };
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = new ColorDrawable(Color.parseColor("#e1e1e5"));
    this.jdField_b_of_type_AndroidGraphicsDrawableDrawable = new ColorDrawable(Color.parseColor("#00000000"));
    this.e = bcwh.a(this.jdField_b_of_type_AndroidContentContext, 135.0F);
    this.jdField_f_of_type_Int = bcwh.a(this.jdField_b_of_type_AndroidContentContext, 19.0F);
    this.c = bcwh.a(this.jdField_b_of_type_AndroidContentContext, 137.0F);
    this.d = bcwh.a(this.jdField_b_of_type_AndroidContentContext, 218.0F);
    this.g = bcwh.a(this.jdField_b_of_type_AndroidContentContext, 7.0F);
    paramBaseAdapter = (ujl)urr.a(6);
    if (!paramBaseAdapter.a())
    {
      paramBaseAdapter.c();
      this.jdField_f_of_type_Boolean = true;
    }
    this.jdField_a_of_type_Bdwa = ((bdvx)paramQQAppInterface.getManager(47)).a(1);
    this.jdField_a_of_type_Ujf.a(this.jdField_a_of_type_Afzk);
    azag.a();
  }
  
  public static void a(ImageView paramImageView, String paramString, int paramInt1, int paramInt2, Drawable paramDrawable)
  {
    try
    {
      paramImageView.setImageDrawable(paramDrawable);
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mFailedDrawable = paramDrawable;
      localURLDrawableOptions.mLoadingDrawable = paramDrawable;
      localURLDrawableOptions.mRequestWidth = paramInt1;
      localURLDrawableOptions.mRequestHeight = paramInt2;
      paramString = URLDrawable.getDrawable(paramString, localURLDrawableOptions);
      if (paramString.getStatus() == 2) {
        paramString.restartDownload();
      }
      paramImageView.setImageDrawable(paramString);
      return;
    }
    catch (Exception paramImageView)
    {
      while (!QLog.isColorLevel()) {}
      QLog.w("TribeShortVideoItemBuilder", 2, "setImageUrl exp: " + paramImageView.toString());
    }
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    return 0;
  }
  
  public aelt a()
  {
    return new afzl();
  }
  
  public Drawable a(String paramString)
  {
    apgg localapgg2 = PAVideoView.a;
    if (!TextUtils.isEmpty(paramString)) {}
    do
    {
      try
      {
        URLDrawable localURLDrawable = URLDrawable.getDrawable(paramString, PAVideoView.a, PAVideoView.a);
        return localURLDrawable;
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.e("TribeShortVideoItemBuilder", 2, "getCoverDrawable():  getDrawable Exception, coverUrl=" + paramString, localException);
        }
        return PAVideoView.a;
      }
      apgg localapgg1 = localapgg2;
    } while (!QLog.isColorLevel());
    QLog.e("TribeShortVideoItemBuilder", 2, "getCoverDrawable():  coverUrl=" + paramString);
    return localapgg2;
  }
  
  public View a(int paramInt1, int paramInt2, ChatMessage paramChatMessage, View paramView, ViewGroup paramViewGroup, aeov paramaeov)
  {
    paramView = (ViewGroup)super.a(paramInt1, paramInt2, paramChatMessage, paramView, paramViewGroup, paramaeov);
    a(paramView, paramChatMessage);
    return paramView;
  }
  
  public View a(ChatMessage paramChatMessage, aelt paramaelt, View paramView, BaseChatItemLayout paramBaseChatItemLayout, aeov paramaeov)
  {
    boolean bool = paramChatMessage.isSend();
    paramaelt = (afzl)paramaelt;
    MessageForTribeShortVideo localMessageForTribeShortVideo = (MessageForTribeShortVideo)paramChatMessage;
    int i;
    int j;
    int k;
    int m;
    int n;
    int i1;
    if (localMessageForTribeShortVideo.videoWidth > localMessageForTribeShortVideo.videoHeight)
    {
      this.c = bcwh.a(this.jdField_b_of_type_AndroidContentContext, 218.0F);
      this.d = bcwh.a(this.jdField_b_of_type_AndroidContentContext, 137.0F);
      if (paramView != null) {
        break label759;
      }
      paramView = LayoutInflater.from(this.jdField_b_of_type_AndroidContentContext).inflate(2131558783, paramBaseChatItemLayout, false);
      paramaelt.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131364171));
      paramaelt.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131363449));
      paramaelt.jdField_a_of_type_AndroidWidgetTextView.setMaxLines(1);
      paramaelt.jdField_a_of_type_AndroidWidgetTextView.setSingleLine(true);
      paramaelt.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131370076));
      paramaelt.jdField_a_of_type_ComTencentBizQqstoryViewWidgetAutoStartProgressBar = ((AutoStartProgressBar)paramaelt.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131379693));
      paramaelt.jdField_a_of_type_ComTencentBizQqstoryViewWidgetAutoStartProgressBar.setSharpCornerCor(BubbleImageView.jdField_a_of_type_ArrayOfFloat);
      paramaelt.jdField_a_of_type_ComTencentMobileqqActivityAioItemTribeShortVideoItemBuilder$TribeShortVideoView = new TribeShortVideoItemBuilder.TribeShortVideoView(this.jdField_b_of_type_AndroidContentContext);
      paramBaseChatItemLayout = new RelativeLayout.LayoutParams(this.c, this.d);
      paramaelt.jdField_a_of_type_ComTencentMobileqqActivityAioItemTribeShortVideoItemBuilder$TribeShortVideoView.setLayoutParams(paramBaseChatItemLayout);
      paramaelt.jdField_a_of_type_ComTencentMobileqqActivityAioItemTribeShortVideoItemBuilder$TribeShortVideoView.c(false);
      paramaelt.jdField_a_of_type_ComTencentMobileqqActivityAioItemTribeShortVideoItemBuilder$TribeShortVideoView.setRadius(15.0F);
      paramaelt.jdField_a_of_type_ComTencentMobileqqActivityAioItemTribeShortVideoItemBuilder$TribeShortVideoView.setScaleType(ImageView.ScaleType.CENTER_CROP);
      paramaelt.jdField_a_of_type_ComTencentMobileqqActivityAioItemTribeShortVideoItemBuilder$TribeShortVideoView.d(true);
      paramaelt.jdField_a_of_type_ComTencentMobileqqActivityAioItemTribeShortVideoItemBuilder$TribeShortVideoView.setFocusable(false);
      paramaelt.jdField_a_of_type_ComTencentMobileqqActivityAioItemTribeShortVideoItemBuilder$TribeShortVideoView.setFocusableInTouchMode(false);
      paramaelt.jdField_a_of_type_ComTencentMobileqqActivityAioItemTribeShortVideoItemBuilder$TribeShortVideoView.setClickable(false);
      paramaelt.jdField_a_of_type_ComTencentMobileqqActivityAioItemTribeShortVideoItemBuilder$TribeShortVideoView.setSharpCornerCor(BubbleImageView.jdField_a_of_type_ArrayOfFloat);
      paramaelt.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(paramaelt.jdField_a_of_type_ComTencentMobileqqActivityAioItemTribeShortVideoItemBuilder$TribeShortVideoView, 0);
      paramBaseChatItemLayout = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[] { 536870912, 0 });
      paramBaseChatItemLayout.setShape(0);
      float f1 = bcwh.a(this.jdField_b_of_type_AndroidContentContext, 15.0F);
      paramBaseChatItemLayout.setCornerRadii(new float[] { f1, f1, f1, f1, 0.0F, 0.0F, 0.0F, 0.0F });
      paramBaseChatItemLayout.setGradientType(0);
      paramaelt.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(paramBaseChatItemLayout);
      paramaelt.jdField_a_of_type_ComTencentBizQqstoryViewWidgetAutoStartProgressBar.setRadius(15.0F, true);
      paramaelt.jdField_a_of_type_ComTencentBizQqstoryViewWidgetAutoStartProgressBar.setShowCorner(true);
      paramaelt.jdField_a_of_type_ComTencentBizQqstoryViewWidgetAutoStartProgressBar.setDrawStatus(1);
      paramView.setOnLongClickListener(paramaeov);
      paramView.setOnTouchListener(paramaeov);
      paramaelt.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      i = this.jdField_b_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131296300);
      j = this.c;
      k = BaseChatItemLayout.j;
      m = this.d;
      n = BaseChatItemLayout.g;
      i1 = this.g;
      paramBaseChatItemLayout = (RelativeLayout.LayoutParams)paramaelt.jdField_a_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
      paramBaseChatItemLayout.width = (j + k + i);
      paramBaseChatItemLayout.height = (i1 + (m + n));
      paramaelt.jdField_a_of_type_AndroidWidgetRelativeLayout.setLayoutParams(paramBaseChatItemLayout);
      label526:
      paramaelt.jdField_a_of_type_ComTencentBizQqstoryViewWidgetAutoStartProgressBar.setKey(paramChatMessage.frienduin + paramChatMessage.uniseq);
      paramaelt.jdField_a_of_type_ComTencentBizQqstoryViewWidgetAutoStartProgressBar.setCornerDirection(bool);
      i = bcwh.a(this.jdField_b_of_type_AndroidContentContext, paramaelt.jdField_a_of_type_ComTencentMobileqqActivityAioItemTribeShortVideoItemBuilder$TribeShortVideoView.a);
      if (paramaelt.jdField_a_of_type_ComTencentMobileqqActivityAioItemTribeShortVideoItemBuilder$TribeShortVideoView.d != bool)
      {
        paramaelt.jdField_a_of_type_ComTencentMobileqqActivityAioItemTribeShortVideoItemBuilder$TribeShortVideoView.d = bool;
        paramaelt.jdField_a_of_type_ComTencentMobileqqActivityAioItemTribeShortVideoItemBuilder$TribeShortVideoView.a(this.c - i, this.d - bcwh.a(this.jdField_b_of_type_AndroidContentContext, 3.0F));
        paramaelt.jdField_a_of_type_ComTencentMobileqqActivityAioItemTribeShortVideoItemBuilder$TribeShortVideoView.invalidate();
      }
      if (bool) {
        break label878;
      }
      paramBaseChatItemLayout = (RelativeLayout.LayoutParams)paramaelt.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams();
      paramBaseChatItemLayout.leftMargin = i;
      paramBaseChatItemLayout.rightMargin = 0;
      paramaelt.jdField_a_of_type_AndroidWidgetTextView.setLayoutParams(paramBaseChatItemLayout);
      paramBaseChatItemLayout = (RelativeLayout.LayoutParams)paramaelt.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
      paramBaseChatItemLayout.leftMargin = i;
      paramBaseChatItemLayout.rightMargin = 0;
      paramaelt.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams(paramBaseChatItemLayout);
    }
    for (;;)
    {
      a(paramaelt, paramChatMessage.uniseq, (MessageForTribeShortVideo)paramChatMessage, false);
      return paramView;
      this.c = bcwh.a(this.jdField_b_of_type_AndroidContentContext, 137.0F);
      this.d = bcwh.a(this.jdField_b_of_type_AndroidContentContext, 218.0F);
      break;
      label759:
      paramBaseChatItemLayout = new RelativeLayout.LayoutParams(this.c, this.d);
      paramaelt.jdField_a_of_type_ComTencentMobileqqActivityAioItemTribeShortVideoItemBuilder$TribeShortVideoView.setLayoutParams(paramBaseChatItemLayout);
      i = this.jdField_b_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131296300);
      j = this.c;
      k = BaseChatItemLayout.j;
      m = this.d;
      n = BaseChatItemLayout.g;
      i1 = this.g;
      paramBaseChatItemLayout = (RelativeLayout.LayoutParams)paramaelt.jdField_a_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
      paramBaseChatItemLayout.width = (j + k + i);
      paramBaseChatItemLayout.height = (i1 + (m + n));
      paramaelt.jdField_a_of_type_AndroidWidgetRelativeLayout.setLayoutParams(paramBaseChatItemLayout);
      break label526;
      label878:
      paramBaseChatItemLayout = (RelativeLayout.LayoutParams)paramaelt.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams();
      paramBaseChatItemLayout.leftMargin = 0;
      paramBaseChatItemLayout.rightMargin = i;
      paramaelt.jdField_a_of_type_AndroidWidgetTextView.setLayoutParams(paramBaseChatItemLayout);
      paramBaseChatItemLayout = (RelativeLayout.LayoutParams)paramaelt.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
      paramBaseChatItemLayout.leftMargin = 0;
      paramBaseChatItemLayout.rightMargin = i;
      paramaelt.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams(paramBaseChatItemLayout);
    }
  }
  
  public QQLiveDrawable.QQLiveDrawableParams a(int paramInt1, int paramInt2, long paramLong, String paramString1, String paramString2)
  {
    QQLiveDrawable.QQLiveDrawableParams localQQLiveDrawableParams = new QQLiveDrawable.QQLiveDrawableParams();
    int i = paramInt1;
    if (paramInt1 == 0) {
      i = 200;
    }
    localQQLiveDrawableParams.mPreviewWidth = i;
    paramInt1 = paramInt2;
    if (paramInt2 == 0) {
      paramInt1 = 400;
    }
    localQQLiveDrawableParams.mPreviewHeight = paramInt1;
    localQQLiveDrawableParams.mPlayType = 2;
    localQQLiveDrawableParams.mDataSourceType = 3;
    localQQLiveDrawableParams.mDataSource = paramString2;
    localQQLiveDrawableParams.mCoverUrl = paramString1;
    localQQLiveDrawableParams.mCoverLoadingDrawable = PAVideoView.a;
    localQQLiveDrawableParams.mLoopback = true;
    localQQLiveDrawableParams.msgUniseq = paramLong;
    return localQQLiveDrawableParams;
  }
  
  public String a(ChatMessage paramChatMessage)
  {
    return paramChatMessage.getSummaryMsg();
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    if (!(paramChatMessage instanceof MessageForTribeShortVideo))
    {
      super.a(paramInt, paramContext, paramChatMessage);
      return;
    }
    MessageForTribeShortVideo localMessageForTribeShortVideo = (MessageForTribeShortVideo)paramChatMessage;
    switch (paramInt)
    {
    }
    for (;;)
    {
      super.a(paramInt, paramContext, paramChatMessage);
      return;
      acex.b(this.jdField_b_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
      return;
      paramContext = new Bundle();
      if ((localMessageForTribeShortVideo.structingMsg.source_puin != null) && (!"".equals(localMessageForTribeShortVideo.structingMsg.source_puin))) {
        paramContext.putString("source_puin", localMessageForTribeShortVideo.structingMsg.source_puin);
      }
      paramContext.putInt("forward_type", 36);
      localMessageForTribeShortVideo.structingMsg.mCommentText = null;
      paramContext.putInt("structmsg_service_id", localMessageForTribeShortVideo.structingMsg.mMsgServiceID);
      paramContext.putByteArray("stuctmsg_bytes", localMessageForTribeShortVideo.structingMsg.getBytes());
      paramContext.putLong("structmsg_uniseq", localMessageForTribeShortVideo.uniseq);
      paramContext.putString("qqtribeVideoInfoExtra ", localMessageForTribeShortVideo.structingMsg.mTribeShortVideoExtra);
      paramContext.putInt("accostType", localMessageForTribeShortVideo.structingMsg.sourceAccoutType);
      paramContext.putInt("selection_mode", this.jdField_b_of_type_Int);
      paramContext.putInt("forward_source_uin_type", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
      paramChatMessage = new Intent();
      paramChatMessage.putExtras(paramContext);
      arum.a((Activity)this.jdField_b_of_type_AndroidContentContext, paramChatMessage, 21);
      return;
      super.a(paramChatMessage);
      return;
      super.d(paramChatMessage);
    }
  }
  
  public void a(afzl paramafzl)
  {
    try
    {
      paramafzl = (MessageForTribeShortVideo)paramafzl.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
      if (QLog.isColorLevel()) {
        QLog.d("TribeShortVideoItemBuilder", 2, "TribeShortVideoItemBuilder onBubbleOnClick:" + paramafzl.toString());
      }
      Intent localIntent = new Intent(this.jdField_b_of_type_AndroidContentContext, QQBrowserActivity.class);
      localIntent.putExtra("url", paramafzl.jumpUrl);
      this.jdField_b_of_type_AndroidContentContext.startActivity(localIntent);
      azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_tribe", "", "video_obj", "clk_obj", 0, 0, paramafzl.bid, paramafzl.pid, "", "");
      return;
    }
    catch (Exception paramafzl)
    {
      while (!QLog.isColorLevel()) {}
      QLog.w("TribeShortVideoItemBuilder", 2, "TribeShortVideoItemBuilder onBubbleOnClick exp :", paramafzl);
    }
  }
  
  public void a(afzl paramafzl, long paramLong)
  {
    ((Activity)this.jdField_b_of_type_AndroidContentContext).runOnUiThread(new TribeShortVideoItemBuilder.6(this, paramafzl, paramLong));
  }
  
  public void a(afzl paramafzl, long paramLong, int paramInt1, int paramInt2, String paramString1, String paramString2)
  {
    a(paramafzl.jdField_a_of_type_ComTencentMobileqqActivityAioItemTribeShortVideoItemBuilder$TribeShortVideoView, paramLong, paramInt1, paramInt2, paramString1, paramString2);
    if (!bdan.a().a(paramafzl.jdField_a_of_type_ComTencentMobileqqDataChatMessage, "video_play"))
    {
      bdan.a().a(paramafzl.jdField_a_of_type_ComTencentMobileqqDataChatMessage, "video_play");
      if ((paramafzl.jdField_a_of_type_ComTencentMobileqqDataChatMessage instanceof MessageForTribeShortVideo))
      {
        paramString2 = (MessageForTribeShortVideo)paramafzl.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
        azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_tribe", "", "video_obj", "video_play", 0, 0, paramString2.bid, paramString2.pid, "", "");
        paramString1 = new JSONObject();
      }
    }
    for (;;)
    {
      try
      {
        if (!TextUtils.isEmpty(paramString2.bid)) {
          continue;
        }
        paramLong = 0L;
        paramString1.put("bid", paramLong);
        if (!TextUtils.isEmpty(paramString2.pid)) {
          continue;
        }
        paramafzl = Integer.valueOf(0);
        paramString1.put("pid", paramafzl);
        if (!TextUtils.isEmpty(paramString2.themeName)) {
          paramString1.put("theme_id", paramString2.themeName);
        }
      }
      catch (Exception paramafzl)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.w("TribeShortVideoItemBuilder", 2, "request cgi params is wrong!");
        continue;
      }
      paramafzl = new NewIntent(this.jdField_b_of_type_AndroidContentContext, mzx.class);
      paramafzl.putExtra("cmd", "MQUpdateSvc_com_qq_xiaoqu.web.publish_post");
      paramString2 = new WebSsoBody.WebSsoRequestBody();
      paramString2.type.set(0);
      paramString2.data.set(paramString1.toString());
      paramafzl.putExtra("data", paramString2.toByteArray());
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet(paramafzl);
      return;
      paramLong = Long.parseLong(paramString2.bid);
      continue;
      paramafzl = paramString2.pid;
    }
  }
  
  public void a(afzl paramafzl, long paramLong, MessageForTribeShortVideo paramMessageForTribeShortVideo, boolean paramBoolean)
  {
    Object localObject = new File(bduw.a(aljq.bg + paramMessageForTribeShortVideo.mVid + ".mp4"));
    if (((File)localObject).exists())
    {
      if ((this.jdField_b_of_type_AndroidContentContext instanceof Activity))
      {
        localObject = ((File)localObject).getAbsolutePath();
        ((Activity)this.jdField_b_of_type_AndroidContentContext).runOnUiThread(new TribeShortVideoItemBuilder.2(this, (String)localObject, paramafzl, paramLong, paramMessageForTribeShortVideo));
      }
      return;
    }
    ((Activity)this.jdField_b_of_type_AndroidContentContext).runOnUiThread(new TribeShortVideoItemBuilder.3(this, paramafzl));
    if (QLog.isColorLevel()) {
      QLog.d("TribeShortVideoItemBuilder", 2, "TribeShortVideoItemBuilder handleGetVideo 1: download");
    }
    a(paramMessageForTribeShortVideo, paramafzl);
  }
  
  protected void a(afzl paramafzl, ViewGroup paramViewGroup, boolean paramBoolean)
  {
    paramafzl.jdField_a_of_type_AndroidWidgetFrameLayout = new FrameLayout(this.jdField_b_of_type_AndroidContentContext);
    Object localObject1 = new TextView(this.jdField_b_of_type_AndroidContentContext);
    ((TextView)localObject1).setBackgroundResource(2130842245);
    Object localObject2 = this.jdField_b_of_type_AndroidContentContext.getResources().getDrawable(2130845863);
    ((Drawable)localObject2).setBounds(0, 0, 36, 36);
    ((TextView)localObject1).setCompoundDrawables((Drawable)localObject2, null, null, null);
    ((TextView)localObject1).setCompoundDrawablePadding(5);
    ((TextView)localObject1).setTextSize(1, 12.0F);
    ((TextView)localObject1).setTextColor(this.jdField_b_of_type_AndroidContentContext.getResources().getColor(2131167192));
    ((TextView)localObject1).setIncludeFontPadding(false);
    ((TextView)localObject1).setSingleLine();
    ((TextView)localObject1).setGravity(16);
    ((TextView)localObject1).setPadding(bcwh.a(this.jdField_b_of_type_AndroidContentContext, 5.0F), 0, bcwh.a(this.jdField_b_of_type_AndroidContentContext, 5.0F), 0);
    paramafzl.jdField_a_of_type_AndroidWidgetFrameLayout.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    localObject2 = new FrameLayout.LayoutParams(-2, -2);
    paramafzl.jdField_a_of_type_AndroidWidgetFrameLayout.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
    paramafzl.b = ((TextView)localObject1);
    localObject1 = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject1).addRule(3, 2131364171);
    ((RelativeLayout.LayoutParams)localObject1).addRule(5, 2131364171);
    paramViewGroup.addView(paramafzl.jdField_a_of_type_AndroidWidgetFrameLayout, (ViewGroup.LayoutParams)localObject1);
  }
  
  protected void a(ViewGroup paramViewGroup, ChatMessage paramChatMessage)
  {
    MessageForTribeShortVideo localMessageForTribeShortVideo = (MessageForTribeShortVideo)paramChatMessage;
    localMessageForTribeShortVideo.parse();
    afzl localafzl = (afzl)paramViewGroup.getTag();
    boolean bool = localMessageForTribeShortVideo.isSend();
    if (localafzl.jdField_a_of_type_AndroidWidgetFrameLayout == null) {
      a(localafzl, paramViewGroup, bool);
    }
    paramViewGroup = (FrameLayout.LayoutParams)localafzl.b.getLayoutParams();
    if (bool)
    {
      paramViewGroup.leftMargin = BaseChatItemLayout.j;
      localafzl.b.setLayoutParams(paramViewGroup);
      if (TextUtils.isEmpty(localMessageForTribeShortVideo.themeName)) {
        break label294;
      }
      localafzl.jdField_a_of_type_AndroidWidgetTextView.setText("#" + localMessageForTribeShortVideo.themeName);
      localafzl.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      label126:
      if (TextUtils.isEmpty(localMessageForTribeShortVideo.srcName)) {
        break label381;
      }
      if (localMessageForTribeShortVideo.srcName.length() <= 5) {
        break label343;
      }
      localafzl.b.setText(localMessageForTribeShortVideo.srcName.substring(0, 5) + alpo.a(2131715473));
      label189:
      localafzl.jdField_a_of_type_ComTencentBizQqstoryViewWidgetAutoStartProgressBar.setCornerDirection(paramChatMessage.isSend());
      if ((!TextUtils.isEmpty(localMessageForTribeShortVideo.mVid)) && (azag.b)) {
        break label411;
      }
      localafzl.jdField_a_of_type_Boolean = false;
      localafzl.jdField_a_of_type_ComTencentBizQqstoryViewWidgetAutoStartProgressBar.setDrawStatus(2);
      localafzl.jdField_a_of_type_ComTencentBizQqstoryViewWidgetAutoStartProgressBar.setVisibility(0);
      a(localafzl.jdField_a_of_type_ComTencentMobileqqActivityAioItemTribeShortVideoItemBuilder$TribeShortVideoView, localMessageForTribeShortVideo.coverImgUrl, this.c, this.d, this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
    }
    label294:
    label343:
    label381:
    do
    {
      return;
      paramViewGroup.leftMargin = (bcwh.a(this.jdField_b_of_type_AndroidContentContext, localafzl.jdField_a_of_type_ComTencentMobileqqActivityAioItemTribeShortVideoItemBuilder$TribeShortVideoView.a) + BaseChatItemLayout.i);
      break;
      if (!TextUtils.isEmpty(localMessageForTribeShortVideo.brief))
      {
        localafzl.jdField_a_of_type_AndroidWidgetTextView.setText(localMessageForTribeShortVideo.brief);
        localafzl.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
        break label126;
      }
      localafzl.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      break label126;
      localafzl.b.setText(localMessageForTribeShortVideo.srcName + alpo.a(2131715474));
      break label189;
      localafzl.b.setText(this.jdField_b_of_type_AndroidContentContext.getString(2131721489));
      localafzl.b.setOnClickListener(null);
      break label189;
      paramViewGroup = (Long)localafzl.jdField_a_of_type_ComTencentMobileqqActivityAioItemTribeShortVideoItemBuilder$TribeShortVideoView.getTag();
    } while ((paramViewGroup != null) && (paramViewGroup.longValue() == localMessageForTribeShortVideo.uniseq));
    label411:
    localafzl.jdField_a_of_type_Boolean = false;
    a(localafzl.jdField_a_of_type_ComTencentMobileqqActivityAioItemTribeShortVideoItemBuilder$TribeShortVideoView, localMessageForTribeShortVideo.coverImgUrl, this.c, this.d, this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
    a(localafzl, localMessageForTribeShortVideo.uniseq, localMessageForTribeShortVideo, false);
    localafzl.jdField_a_of_type_ComTencentMobileqqActivityAioItemTribeShortVideoItemBuilder$TribeShortVideoView.setTag(Long.valueOf(localMessageForTribeShortVideo.uniseq));
  }
  
  public void a(TribeShortVideoItemBuilder.TribeShortVideoView paramTribeShortVideoView, long paramLong, int paramInt1, int paramInt2, String paramString1, String paramString2)
  {
    paramString1 = a(paramInt1, paramInt2, paramLong, paramString1, paramString2);
    paramString2 = URLDrawable.URLDrawableOptions.obtain();
    paramString2.mExtraInfo = paramString1;
    paramString2.mLoadingDrawable = a(paramString1.mCoverUrl);
    paramTribeShortVideoView.setImageDrawable(URLDrawable.getDrawable(PAVideoView.a(paramLong), paramString2));
  }
  
  protected void a(MessageForTribeShortVideo paramMessageForTribeShortVideo, afzl paramafzl)
  {
    Object localObject1 = new File(bduw.a(aljq.bg));
    if (!((File)localObject1).exists()) {
      ((File)localObject1).mkdirs();
    }
    localObject1 = aljq.bg + paramMessageForTribeShortVideo.mVid + ".mp4";
    Object localObject2 = new File(bduw.a((String)localObject1));
    localObject2 = new bdvv(paramMessageForTribeShortVideo.videoUrl, (File)localObject2);
    ((bdvv)localObject2).jdField_b_of_type_Int = 2;
    Bundle localBundle = new Bundle();
    localBundle.putString("filePath", (String)localObject1);
    this.jdField_a_of_type_Bdwa.a((bdvv)localObject2, new afzi(this, paramafzl, paramMessageForTribeShortVideo), localBundle);
  }
  
  public bdlb[] a(View paramView)
  {
    bdkz localbdkz = new bdkz();
    paramView = aekt.a(paramView);
    if (bcid.a(paramView) == null) {}
    localbdkz.a(2131366750, this.jdField_b_of_type_AndroidContentContext.getString(2131692835), 2130838677);
    if ((paramView.extraflag != 32768) && (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(paramView))) {
      a(localbdkz, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, paramView);
    }
    a(localbdkz, paramView);
    c(localbdkz, this.jdField_b_of_type_AndroidContentContext);
    super.e(localbdkz, this.jdField_b_of_type_AndroidContentContext);
    return localbdkz.a();
  }
  
  public void b(afzl paramafzl)
  {
    try
    {
      paramafzl = (MessageForTribeShortVideo)paramafzl.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
      if (QLog.isColorLevel()) {
        QLog.d("TribeShortVideoItemBuilder", 2, "TribeShortVideoItemBuilder onSourceOnClick:" + paramafzl.toString());
      }
      Intent localIntent = new Intent(this.jdField_b_of_type_AndroidContentContext, QQBrowserActivity.class);
      localIntent.putExtra("isOpeningQunApp", false);
      localIntent.putExtra("url", paramafzl.sourceJumpUrl);
      this.jdField_b_of_type_AndroidContentContext.startActivity(localIntent);
      azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_tribe", "", "video_obj", "Clk_tail", 0, 0, paramafzl.bid, paramafzl.pid, "", "");
      return;
    }
    catch (Exception paramafzl)
    {
      while (!QLog.isColorLevel()) {}
      QLog.w("TribeShortVideoItemBuilder", 2, "TribeShortVideoItemBuilder onSourceOnClick exp :", paramafzl);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.TribeShortVideoItemBuilder
 * JD-Core Version:    0.7.0.1
 */