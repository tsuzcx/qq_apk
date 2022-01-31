package com.tencent.mobileqq.activity.aio.item;

import aanz;
import actj;
import acuj;
import acxj;
import aect;
import aecu;
import aecv;
import aecw;
import aecx;
import ajsd;
import ajya;
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
import anoz;
import aqbe;
import awzy;
import axfa;
import axqy;
import bajp;
import baxn;
import bbbt;
import bbmf;
import bbmh;
import bbvj;
import bbwu;
import bbww;
import bbwz;
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
import mxe;
import org.json.JSONObject;
import sun;
import sut;
import tcz;

public class TribeShortVideoItemBuilder
  extends BaseBubbleBuilder
{
  public aecw a;
  protected Drawable a;
  public View.OnClickListener a;
  protected bbwz a;
  protected sun a;
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
    this.jdField_a_of_type_Sun = new sun();
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new aect(this);
    this.jdField_a_of_type_Aecw = new aecv(this);
    this.jdField_b_of_type_AndroidContentContext = paramContext;
    float f1 = baxn.a(this.jdField_b_of_type_AndroidContentContext, 15.0F);
    this.jdField_a_of_type_ArrayOfFloat = new float[] { 0.0F, 0.0F, 0.0F, 0.0F, f1, f1, f1, f1 };
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = new ColorDrawable(Color.parseColor("#e1e1e5"));
    this.jdField_b_of_type_AndroidGraphicsDrawableDrawable = new ColorDrawable(Color.parseColor("#00000000"));
    this.e = baxn.a(this.jdField_b_of_type_AndroidContentContext, 135.0F);
    this.jdField_f_of_type_Int = baxn.a(this.jdField_b_of_type_AndroidContentContext, 19.0F);
    this.c = baxn.a(this.jdField_b_of_type_AndroidContentContext, 137.0F);
    this.d = baxn.a(this.jdField_b_of_type_AndroidContentContext, 218.0F);
    this.g = baxn.a(this.jdField_b_of_type_AndroidContentContext, 7.0F);
    paramBaseAdapter = (sut)tcz.a(6);
    if (!paramBaseAdapter.a())
    {
      paramBaseAdapter.c();
      this.jdField_f_of_type_Boolean = true;
    }
    this.jdField_a_of_type_Bbwz = ((bbww)paramQQAppInterface.getManager(47)).a(1);
    this.jdField_a_of_type_Sun.a(this.jdField_a_of_type_Aecw);
    axfa.a();
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
  
  public acuj a()
  {
    return new aecx();
  }
  
  public Drawable a(String paramString)
  {
    anoz localanoz2 = PAVideoView.a;
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
      anoz localanoz1 = localanoz2;
    } while (!QLog.isColorLevel());
    QLog.e("TribeShortVideoItemBuilder", 2, "getCoverDrawable():  coverUrl=" + paramString);
    return localanoz2;
  }
  
  public View a(int paramInt1, int paramInt2, ChatMessage paramChatMessage, View paramView, ViewGroup paramViewGroup, acxj paramacxj)
  {
    paramView = (ViewGroup)super.a(paramInt1, paramInt2, paramChatMessage, paramView, paramViewGroup, paramacxj);
    a(paramView, paramChatMessage);
    return paramView;
  }
  
  public View a(ChatMessage paramChatMessage, acuj paramacuj, View paramView, BaseChatItemLayout paramBaseChatItemLayout, acxj paramacxj)
  {
    boolean bool = paramChatMessage.isSend();
    paramacuj = (aecx)paramacuj;
    MessageForTribeShortVideo localMessageForTribeShortVideo = (MessageForTribeShortVideo)paramChatMessage;
    int i;
    int j;
    int k;
    int m;
    int n;
    int i1;
    if (localMessageForTribeShortVideo.videoWidth > localMessageForTribeShortVideo.videoHeight)
    {
      this.c = baxn.a(this.jdField_b_of_type_AndroidContentContext, 218.0F);
      this.d = baxn.a(this.jdField_b_of_type_AndroidContentContext, 137.0F);
      if (paramView != null) {
        break label759;
      }
      paramView = LayoutInflater.from(this.jdField_b_of_type_AndroidContentContext).inflate(2131558747, paramBaseChatItemLayout, false);
      paramacuj.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131364109));
      paramacuj.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131363410));
      paramacuj.jdField_a_of_type_AndroidWidgetTextView.setMaxLines(1);
      paramacuj.jdField_a_of_type_AndroidWidgetTextView.setSingleLine(true);
      paramacuj.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131369812));
      paramacuj.jdField_a_of_type_ComTencentBizQqstoryViewWidgetAutoStartProgressBar = ((AutoStartProgressBar)paramacuj.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131379024));
      paramacuj.jdField_a_of_type_ComTencentBizQqstoryViewWidgetAutoStartProgressBar.setSharpCornerCor(BubbleImageView.jdField_a_of_type_ArrayOfFloat);
      paramacuj.jdField_a_of_type_ComTencentMobileqqActivityAioItemTribeShortVideoItemBuilder$TribeShortVideoView = new TribeShortVideoItemBuilder.TribeShortVideoView(this.jdField_b_of_type_AndroidContentContext);
      paramBaseChatItemLayout = new RelativeLayout.LayoutParams(this.c, this.d);
      paramacuj.jdField_a_of_type_ComTencentMobileqqActivityAioItemTribeShortVideoItemBuilder$TribeShortVideoView.setLayoutParams(paramBaseChatItemLayout);
      paramacuj.jdField_a_of_type_ComTencentMobileqqActivityAioItemTribeShortVideoItemBuilder$TribeShortVideoView.c(false);
      paramacuj.jdField_a_of_type_ComTencentMobileqqActivityAioItemTribeShortVideoItemBuilder$TribeShortVideoView.setRadius(15.0F);
      paramacuj.jdField_a_of_type_ComTencentMobileqqActivityAioItemTribeShortVideoItemBuilder$TribeShortVideoView.setScaleType(ImageView.ScaleType.CENTER_CROP);
      paramacuj.jdField_a_of_type_ComTencentMobileqqActivityAioItemTribeShortVideoItemBuilder$TribeShortVideoView.d(true);
      paramacuj.jdField_a_of_type_ComTencentMobileqqActivityAioItemTribeShortVideoItemBuilder$TribeShortVideoView.setFocusable(false);
      paramacuj.jdField_a_of_type_ComTencentMobileqqActivityAioItemTribeShortVideoItemBuilder$TribeShortVideoView.setFocusableInTouchMode(false);
      paramacuj.jdField_a_of_type_ComTencentMobileqqActivityAioItemTribeShortVideoItemBuilder$TribeShortVideoView.setClickable(false);
      paramacuj.jdField_a_of_type_ComTencentMobileqqActivityAioItemTribeShortVideoItemBuilder$TribeShortVideoView.setSharpCornerCor(BubbleImageView.jdField_a_of_type_ArrayOfFloat);
      paramacuj.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(paramacuj.jdField_a_of_type_ComTencentMobileqqActivityAioItemTribeShortVideoItemBuilder$TribeShortVideoView, 0);
      paramBaseChatItemLayout = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[] { 536870912, 0 });
      paramBaseChatItemLayout.setShape(0);
      float f1 = baxn.a(this.jdField_b_of_type_AndroidContentContext, 15.0F);
      paramBaseChatItemLayout.setCornerRadii(new float[] { f1, f1, f1, f1, 0.0F, 0.0F, 0.0F, 0.0F });
      paramBaseChatItemLayout.setGradientType(0);
      paramacuj.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(paramBaseChatItemLayout);
      paramacuj.jdField_a_of_type_ComTencentBizQqstoryViewWidgetAutoStartProgressBar.setRadius(15.0F, true);
      paramacuj.jdField_a_of_type_ComTencentBizQqstoryViewWidgetAutoStartProgressBar.setShowCorner(true);
      paramacuj.jdField_a_of_type_ComTencentBizQqstoryViewWidgetAutoStartProgressBar.setDrawStatus(1);
      paramView.setOnLongClickListener(paramacxj);
      paramView.setOnTouchListener(paramacxj);
      paramacuj.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      i = this.jdField_b_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131296294);
      j = this.c;
      k = BaseChatItemLayout.j;
      m = this.d;
      n = BaseChatItemLayout.g;
      i1 = this.g;
      paramBaseChatItemLayout = (RelativeLayout.LayoutParams)paramacuj.jdField_a_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
      paramBaseChatItemLayout.width = (j + k + i);
      paramBaseChatItemLayout.height = (i1 + (m + n));
      paramacuj.jdField_a_of_type_AndroidWidgetRelativeLayout.setLayoutParams(paramBaseChatItemLayout);
      label526:
      paramacuj.jdField_a_of_type_ComTencentBizQqstoryViewWidgetAutoStartProgressBar.setKey(paramChatMessage.frienduin + paramChatMessage.uniseq);
      paramacuj.jdField_a_of_type_ComTencentBizQqstoryViewWidgetAutoStartProgressBar.setCornerDirection(bool);
      i = baxn.a(this.jdField_b_of_type_AndroidContentContext, paramacuj.jdField_a_of_type_ComTencentMobileqqActivityAioItemTribeShortVideoItemBuilder$TribeShortVideoView.a);
      if (paramacuj.jdField_a_of_type_ComTencentMobileqqActivityAioItemTribeShortVideoItemBuilder$TribeShortVideoView.d != bool)
      {
        paramacuj.jdField_a_of_type_ComTencentMobileqqActivityAioItemTribeShortVideoItemBuilder$TribeShortVideoView.d = bool;
        paramacuj.jdField_a_of_type_ComTencentMobileqqActivityAioItemTribeShortVideoItemBuilder$TribeShortVideoView.a(this.c - i, this.d - baxn.a(this.jdField_b_of_type_AndroidContentContext, 3.0F));
        paramacuj.jdField_a_of_type_ComTencentMobileqqActivityAioItemTribeShortVideoItemBuilder$TribeShortVideoView.invalidate();
      }
      if (bool) {
        break label878;
      }
      paramBaseChatItemLayout = (RelativeLayout.LayoutParams)paramacuj.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams();
      paramBaseChatItemLayout.leftMargin = i;
      paramBaseChatItemLayout.rightMargin = 0;
      paramacuj.jdField_a_of_type_AndroidWidgetTextView.setLayoutParams(paramBaseChatItemLayout);
      paramBaseChatItemLayout = (RelativeLayout.LayoutParams)paramacuj.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
      paramBaseChatItemLayout.leftMargin = i;
      paramBaseChatItemLayout.rightMargin = 0;
      paramacuj.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams(paramBaseChatItemLayout);
    }
    for (;;)
    {
      a(paramacuj, paramChatMessage.uniseq, (MessageForTribeShortVideo)paramChatMessage, false);
      return paramView;
      this.c = baxn.a(this.jdField_b_of_type_AndroidContentContext, 137.0F);
      this.d = baxn.a(this.jdField_b_of_type_AndroidContentContext, 218.0F);
      break;
      label759:
      paramBaseChatItemLayout = new RelativeLayout.LayoutParams(this.c, this.d);
      paramacuj.jdField_a_of_type_ComTencentMobileqqActivityAioItemTribeShortVideoItemBuilder$TribeShortVideoView.setLayoutParams(paramBaseChatItemLayout);
      i = this.jdField_b_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131296294);
      j = this.c;
      k = BaseChatItemLayout.j;
      m = this.d;
      n = BaseChatItemLayout.g;
      i1 = this.g;
      paramBaseChatItemLayout = (RelativeLayout.LayoutParams)paramacuj.jdField_a_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
      paramBaseChatItemLayout.width = (j + k + i);
      paramBaseChatItemLayout.height = (i1 + (m + n));
      paramacuj.jdField_a_of_type_AndroidWidgetRelativeLayout.setLayoutParams(paramBaseChatItemLayout);
      break label526;
      label878:
      paramBaseChatItemLayout = (RelativeLayout.LayoutParams)paramacuj.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams();
      paramBaseChatItemLayout.leftMargin = 0;
      paramBaseChatItemLayout.rightMargin = i;
      paramacuj.jdField_a_of_type_AndroidWidgetTextView.setLayoutParams(paramBaseChatItemLayout);
      paramBaseChatItemLayout = (RelativeLayout.LayoutParams)paramacuj.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
      paramBaseChatItemLayout.leftMargin = 0;
      paramBaseChatItemLayout.rightMargin = i;
      paramacuj.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams(paramBaseChatItemLayout);
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
      aanz.b(this.jdField_b_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
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
      aqbe.a((Activity)this.jdField_b_of_type_AndroidContentContext, paramChatMessage, 21);
      return;
      super.a(paramChatMessage);
      return;
      super.d(paramChatMessage);
    }
  }
  
  public void a(aecx paramaecx)
  {
    try
    {
      paramaecx = (MessageForTribeShortVideo)paramaecx.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
      if (QLog.isColorLevel()) {
        QLog.d("TribeShortVideoItemBuilder", 2, "TribeShortVideoItemBuilder onBubbleOnClick:" + paramaecx.toString());
      }
      Intent localIntent = new Intent(this.jdField_b_of_type_AndroidContentContext, QQBrowserActivity.class);
      localIntent.putExtra("url", paramaecx.jumpUrl);
      this.jdField_b_of_type_AndroidContentContext.startActivity(localIntent);
      axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_tribe", "", "video_obj", "clk_obj", 0, 0, paramaecx.bid, paramaecx.pid, "", "");
      return;
    }
    catch (Exception paramaecx)
    {
      while (!QLog.isColorLevel()) {}
      QLog.w("TribeShortVideoItemBuilder", 2, "TribeShortVideoItemBuilder onBubbleOnClick exp :", paramaecx);
    }
  }
  
  public void a(aecx paramaecx, long paramLong)
  {
    ((Activity)this.jdField_b_of_type_AndroidContentContext).runOnUiThread(new TribeShortVideoItemBuilder.6(this, paramaecx, paramLong));
  }
  
  public void a(aecx paramaecx, long paramLong, int paramInt1, int paramInt2, String paramString1, String paramString2)
  {
    a(paramaecx.jdField_a_of_type_ComTencentMobileqqActivityAioItemTribeShortVideoItemBuilder$TribeShortVideoView, paramLong, paramInt1, paramInt2, paramString1, paramString2);
    if (!bbbt.a().a(paramaecx.jdField_a_of_type_ComTencentMobileqqDataChatMessage, "video_play"))
    {
      bbbt.a().a(paramaecx.jdField_a_of_type_ComTencentMobileqqDataChatMessage, "video_play");
      if ((paramaecx.jdField_a_of_type_ComTencentMobileqqDataChatMessage instanceof MessageForTribeShortVideo))
      {
        paramString2 = (MessageForTribeShortVideo)paramaecx.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
        axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_tribe", "", "video_obj", "video_play", 0, 0, paramString2.bid, paramString2.pid, "", "");
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
        paramaecx = Integer.valueOf(0);
        paramString1.put("pid", paramaecx);
        if (!TextUtils.isEmpty(paramString2.themeName)) {
          paramString1.put("theme_id", paramString2.themeName);
        }
      }
      catch (Exception paramaecx)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.w("TribeShortVideoItemBuilder", 2, "request cgi params is wrong!");
        continue;
      }
      paramaecx = new NewIntent(this.jdField_b_of_type_AndroidContentContext, mxe.class);
      paramaecx.putExtra("cmd", "MQUpdateSvc_com_qq_xiaoqu.web.publish_post");
      paramString2 = new WebSsoBody.WebSsoRequestBody();
      paramString2.type.set(0);
      paramString2.data.set(paramString1.toString());
      paramaecx.putExtra("data", paramString2.toByteArray());
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet(paramaecx);
      return;
      paramLong = Long.parseLong(paramString2.bid);
      continue;
      paramaecx = paramString2.pid;
    }
  }
  
  public void a(aecx paramaecx, long paramLong, MessageForTribeShortVideo paramMessageForTribeShortVideo, boolean paramBoolean)
  {
    Object localObject = new File(bbvj.a(ajsd.bf + paramMessageForTribeShortVideo.mVid + ".mp4"));
    if (((File)localObject).exists())
    {
      if ((this.jdField_b_of_type_AndroidContentContext instanceof Activity))
      {
        localObject = ((File)localObject).getAbsolutePath();
        ((Activity)this.jdField_b_of_type_AndroidContentContext).runOnUiThread(new TribeShortVideoItemBuilder.2(this, (String)localObject, paramaecx, paramLong, paramMessageForTribeShortVideo));
      }
      return;
    }
    ((Activity)this.jdField_b_of_type_AndroidContentContext).runOnUiThread(new TribeShortVideoItemBuilder.3(this, paramaecx));
    if (QLog.isColorLevel()) {
      QLog.d("TribeShortVideoItemBuilder", 2, "TribeShortVideoItemBuilder handleGetVideo 1: download");
    }
    a(paramMessageForTribeShortVideo, paramaecx);
  }
  
  protected void a(aecx paramaecx, ViewGroup paramViewGroup, boolean paramBoolean)
  {
    paramaecx.jdField_a_of_type_AndroidWidgetFrameLayout = new FrameLayout(this.jdField_b_of_type_AndroidContentContext);
    Object localObject1 = new TextView(this.jdField_b_of_type_AndroidContentContext);
    ((TextView)localObject1).setBackgroundResource(2130842092);
    Object localObject2 = this.jdField_b_of_type_AndroidContentContext.getResources().getDrawable(2130845484);
    ((Drawable)localObject2).setBounds(0, 0, 36, 36);
    ((TextView)localObject1).setCompoundDrawables((Drawable)localObject2, null, null, null);
    ((TextView)localObject1).setCompoundDrawablePadding(5);
    ((TextView)localObject1).setTextSize(1, 12.0F);
    ((TextView)localObject1).setTextColor(this.jdField_b_of_type_AndroidContentContext.getResources().getColor(2131167134));
    ((TextView)localObject1).setIncludeFontPadding(false);
    ((TextView)localObject1).setSingleLine();
    ((TextView)localObject1).setGravity(16);
    ((TextView)localObject1).setPadding(baxn.a(this.jdField_b_of_type_AndroidContentContext, 5.0F), 0, baxn.a(this.jdField_b_of_type_AndroidContentContext, 5.0F), 0);
    paramaecx.jdField_a_of_type_AndroidWidgetFrameLayout.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    localObject2 = new FrameLayout.LayoutParams(-2, -2);
    paramaecx.jdField_a_of_type_AndroidWidgetFrameLayout.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
    paramaecx.b = ((TextView)localObject1);
    localObject1 = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject1).addRule(3, 2131364109);
    ((RelativeLayout.LayoutParams)localObject1).addRule(5, 2131364109);
    paramViewGroup.addView(paramaecx.jdField_a_of_type_AndroidWidgetFrameLayout, (ViewGroup.LayoutParams)localObject1);
  }
  
  protected void a(ViewGroup paramViewGroup, ChatMessage paramChatMessage)
  {
    MessageForTribeShortVideo localMessageForTribeShortVideo = (MessageForTribeShortVideo)paramChatMessage;
    localMessageForTribeShortVideo.parse();
    aecx localaecx = (aecx)paramViewGroup.getTag();
    boolean bool = localMessageForTribeShortVideo.isSend();
    if (localaecx.jdField_a_of_type_AndroidWidgetFrameLayout == null) {
      a(localaecx, paramViewGroup, bool);
    }
    paramViewGroup = (FrameLayout.LayoutParams)localaecx.b.getLayoutParams();
    if (bool)
    {
      paramViewGroup.leftMargin = BaseChatItemLayout.j;
      localaecx.b.setLayoutParams(paramViewGroup);
      if (TextUtils.isEmpty(localMessageForTribeShortVideo.themeName)) {
        break label294;
      }
      localaecx.jdField_a_of_type_AndroidWidgetTextView.setText("#" + localMessageForTribeShortVideo.themeName);
      localaecx.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      label126:
      if (TextUtils.isEmpty(localMessageForTribeShortVideo.srcName)) {
        break label381;
      }
      if (localMessageForTribeShortVideo.srcName.length() <= 5) {
        break label343;
      }
      localaecx.b.setText(localMessageForTribeShortVideo.srcName.substring(0, 5) + ajya.a(2131715101));
      label189:
      localaecx.jdField_a_of_type_ComTencentBizQqstoryViewWidgetAutoStartProgressBar.setCornerDirection(paramChatMessage.isSend());
      if ((!TextUtils.isEmpty(localMessageForTribeShortVideo.mVid)) && (axfa.b)) {
        break label411;
      }
      localaecx.jdField_a_of_type_Boolean = false;
      localaecx.jdField_a_of_type_ComTencentBizQqstoryViewWidgetAutoStartProgressBar.setDrawStatus(2);
      localaecx.jdField_a_of_type_ComTencentBizQqstoryViewWidgetAutoStartProgressBar.setVisibility(0);
      a(localaecx.jdField_a_of_type_ComTencentMobileqqActivityAioItemTribeShortVideoItemBuilder$TribeShortVideoView, localMessageForTribeShortVideo.coverImgUrl, this.c, this.d, this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
    }
    label294:
    label343:
    label381:
    do
    {
      return;
      paramViewGroup.leftMargin = (baxn.a(this.jdField_b_of_type_AndroidContentContext, localaecx.jdField_a_of_type_ComTencentMobileqqActivityAioItemTribeShortVideoItemBuilder$TribeShortVideoView.a) + BaseChatItemLayout.i);
      break;
      if (!TextUtils.isEmpty(localMessageForTribeShortVideo.brief))
      {
        localaecx.jdField_a_of_type_AndroidWidgetTextView.setText(localMessageForTribeShortVideo.brief);
        localaecx.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
        break label126;
      }
      localaecx.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      break label126;
      localaecx.b.setText(localMessageForTribeShortVideo.srcName + ajya.a(2131715102));
      break label189;
      localaecx.b.setText(this.jdField_b_of_type_AndroidContentContext.getString(2131720928));
      localaecx.b.setOnClickListener(null);
      break label189;
      paramViewGroup = (Long)localaecx.jdField_a_of_type_ComTencentMobileqqActivityAioItemTribeShortVideoItemBuilder$TribeShortVideoView.getTag();
    } while ((paramViewGroup != null) && (paramViewGroup.longValue() == localMessageForTribeShortVideo.uniseq));
    label411:
    localaecx.jdField_a_of_type_Boolean = false;
    a(localaecx.jdField_a_of_type_ComTencentMobileqqActivityAioItemTribeShortVideoItemBuilder$TribeShortVideoView, localMessageForTribeShortVideo.coverImgUrl, this.c, this.d, this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
    a(localaecx, localMessageForTribeShortVideo.uniseq, localMessageForTribeShortVideo, false);
    localaecx.jdField_a_of_type_ComTencentMobileqqActivityAioItemTribeShortVideoItemBuilder$TribeShortVideoView.setTag(Long.valueOf(localMessageForTribeShortVideo.uniseq));
  }
  
  public void a(TribeShortVideoItemBuilder.TribeShortVideoView paramTribeShortVideoView, long paramLong, int paramInt1, int paramInt2, String paramString1, String paramString2)
  {
    paramString1 = a(paramInt1, paramInt2, paramLong, paramString1, paramString2);
    paramString2 = URLDrawable.URLDrawableOptions.obtain();
    paramString2.mExtraInfo = paramString1;
    paramString2.mLoadingDrawable = a(paramString1.mCoverUrl);
    paramTribeShortVideoView.setImageDrawable(URLDrawable.getDrawable(PAVideoView.a(paramLong), paramString2));
  }
  
  protected void a(MessageForTribeShortVideo paramMessageForTribeShortVideo, aecx paramaecx)
  {
    Object localObject1 = new File(bbvj.a(ajsd.bf));
    if (!((File)localObject1).exists()) {
      ((File)localObject1).mkdirs();
    }
    localObject1 = ajsd.bf + paramMessageForTribeShortVideo.mVid + ".mp4";
    Object localObject2 = new File(bbvj.a((String)localObject1));
    localObject2 = new bbwu(paramMessageForTribeShortVideo.videoUrl, (File)localObject2);
    ((bbwu)localObject2).jdField_b_of_type_Int = 2;
    Bundle localBundle = new Bundle();
    localBundle.putString("filePath", (String)localObject1);
    this.jdField_a_of_type_Bbwz.a((bbwu)localObject2, new aecu(this, paramaecx, paramMessageForTribeShortVideo), localBundle);
  }
  
  public bbmh[] a(View paramView)
  {
    bbmf localbbmf = new bbmf();
    paramView = actj.a(paramView);
    if (bajp.a(paramView) == null) {}
    localbbmf.a(2131366632, this.jdField_b_of_type_AndroidContentContext.getString(2131692753), 2130838606);
    if ((paramView.extraflag != 32768) && (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(paramView))) {
      a(localbbmf, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, paramView);
    }
    a(localbbmf, paramView);
    c(localbbmf, this.jdField_b_of_type_AndroidContentContext);
    super.e(localbbmf, this.jdField_b_of_type_AndroidContentContext);
    return localbbmf.a();
  }
  
  public void b(aecx paramaecx)
  {
    try
    {
      paramaecx = (MessageForTribeShortVideo)paramaecx.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
      if (QLog.isColorLevel()) {
        QLog.d("TribeShortVideoItemBuilder", 2, "TribeShortVideoItemBuilder onSourceOnClick:" + paramaecx.toString());
      }
      Intent localIntent = new Intent(this.jdField_b_of_type_AndroidContentContext, QQBrowserActivity.class);
      localIntent.putExtra("isOpeningQunApp", false);
      localIntent.putExtra("url", paramaecx.sourceJumpUrl);
      this.jdField_b_of_type_AndroidContentContext.startActivity(localIntent);
      axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_tribe", "", "video_obj", "Clk_tail", 0, 0, paramaecx.bid, paramaecx.pid, "", "");
      return;
    }
    catch (Exception paramaecx)
    {
      while (!QLog.isColorLevel()) {}
      QLog.w("TribeShortVideoItemBuilder", 2, "TribeShortVideoItemBuilder onSourceOnClick exp :", paramaecx);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.TribeShortVideoItemBuilder
 * JD-Core Version:    0.7.0.1
 */