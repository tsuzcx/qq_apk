package com.tencent.mobileqq.activity.aio.item;

import aael;
import aciy;
import acju;
import acmv;
import adrw;
import adrx;
import adry;
import adrz;
import adsa;
import ajed;
import ajjy;
import amym;
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
import aphp;
import awao;
import awfq;
import awqx;
import azhy;
import azvv;
import baab;
import bakh;
import bakj;
import batm;
import bato;
import batr;
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
import mmi;
import mqq.app.NewIntent;
import org.json.JSONObject;
import shu;
import sia;
import sqg;

public class TribeShortVideoItemBuilder
  extends BaseBubbleBuilder
{
  public adrz a;
  protected Drawable a;
  public View.OnClickListener a;
  protected batr a;
  protected shu a;
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
    this.jdField_a_of_type_Shu = new shu();
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new adrw(this);
    this.jdField_a_of_type_Adrz = new adry(this);
    this.jdField_b_of_type_AndroidContentContext = paramContext;
    float f1 = azvv.a(this.jdField_b_of_type_AndroidContentContext, 15.0F);
    this.jdField_a_of_type_ArrayOfFloat = new float[] { 0.0F, 0.0F, 0.0F, 0.0F, f1, f1, f1, f1 };
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = new ColorDrawable(Color.parseColor("#e1e1e5"));
    this.jdField_b_of_type_AndroidGraphicsDrawableDrawable = new ColorDrawable(Color.parseColor("#00000000"));
    this.e = azvv.a(this.jdField_b_of_type_AndroidContentContext, 135.0F);
    this.jdField_f_of_type_Int = azvv.a(this.jdField_b_of_type_AndroidContentContext, 19.0F);
    this.c = azvv.a(this.jdField_b_of_type_AndroidContentContext, 137.0F);
    this.d = azvv.a(this.jdField_b_of_type_AndroidContentContext, 218.0F);
    this.g = azvv.a(this.jdField_b_of_type_AndroidContentContext, 7.0F);
    paramBaseAdapter = (sia)sqg.a(6);
    if (!paramBaseAdapter.a())
    {
      paramBaseAdapter.c();
      this.jdField_f_of_type_Boolean = true;
    }
    this.jdField_a_of_type_Batr = ((bato)paramQQAppInterface.getManager(47)).a(1);
    this.jdField_a_of_type_Shu.a(this.jdField_a_of_type_Adrz);
    awfq.a();
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
  
  public acju a()
  {
    return new adsa();
  }
  
  public Drawable a(String paramString)
  {
    amym localamym2 = PAVideoView.a;
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
      amym localamym1 = localamym2;
    } while (!QLog.isColorLevel());
    QLog.e("TribeShortVideoItemBuilder", 2, "getCoverDrawable():  coverUrl=" + paramString);
    return localamym2;
  }
  
  public View a(int paramInt1, int paramInt2, ChatMessage paramChatMessage, View paramView, ViewGroup paramViewGroup, acmv paramacmv)
  {
    paramView = (ViewGroup)super.a(paramInt1, paramInt2, paramChatMessage, paramView, paramViewGroup, paramacmv);
    a(paramView, paramChatMessage);
    return paramView;
  }
  
  public View a(ChatMessage paramChatMessage, acju paramacju, View paramView, BaseChatItemLayout paramBaseChatItemLayout, acmv paramacmv)
  {
    boolean bool = paramChatMessage.isSend();
    paramacju = (adsa)paramacju;
    MessageForTribeShortVideo localMessageForTribeShortVideo = (MessageForTribeShortVideo)paramChatMessage;
    int i;
    int j;
    int k;
    int m;
    int n;
    int i1;
    if (localMessageForTribeShortVideo.videoWidth > localMessageForTribeShortVideo.videoHeight)
    {
      this.c = azvv.a(this.jdField_b_of_type_AndroidContentContext, 218.0F);
      this.d = azvv.a(this.jdField_b_of_type_AndroidContentContext, 137.0F);
      if (paramView != null) {
        break label759;
      }
      paramView = LayoutInflater.from(this.jdField_b_of_type_AndroidContentContext).inflate(2131493191, paramBaseChatItemLayout, false);
      paramacju.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131298552));
      paramacju.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131297865));
      paramacju.jdField_a_of_type_AndroidWidgetTextView.setMaxLines(1);
      paramacju.jdField_a_of_type_AndroidWidgetTextView.setSingleLine(true);
      paramacju.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131304140));
      paramacju.jdField_a_of_type_ComTencentBizQqstoryViewWidgetAutoStartProgressBar = ((AutoStartProgressBar)paramacju.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131313184));
      paramacju.jdField_a_of_type_ComTencentBizQqstoryViewWidgetAutoStartProgressBar.setSharpCornerCor(BubbleImageView.jdField_a_of_type_ArrayOfFloat);
      paramacju.jdField_a_of_type_ComTencentMobileqqActivityAioItemTribeShortVideoItemBuilder$TribeShortVideoView = new TribeShortVideoItemBuilder.TribeShortVideoView(this.jdField_b_of_type_AndroidContentContext);
      paramBaseChatItemLayout = new RelativeLayout.LayoutParams(this.c, this.d);
      paramacju.jdField_a_of_type_ComTencentMobileqqActivityAioItemTribeShortVideoItemBuilder$TribeShortVideoView.setLayoutParams(paramBaseChatItemLayout);
      paramacju.jdField_a_of_type_ComTencentMobileqqActivityAioItemTribeShortVideoItemBuilder$TribeShortVideoView.c(false);
      paramacju.jdField_a_of_type_ComTencentMobileqqActivityAioItemTribeShortVideoItemBuilder$TribeShortVideoView.setRadius(15.0F);
      paramacju.jdField_a_of_type_ComTencentMobileqqActivityAioItemTribeShortVideoItemBuilder$TribeShortVideoView.setScaleType(ImageView.ScaleType.CENTER_CROP);
      paramacju.jdField_a_of_type_ComTencentMobileqqActivityAioItemTribeShortVideoItemBuilder$TribeShortVideoView.d(true);
      paramacju.jdField_a_of_type_ComTencentMobileqqActivityAioItemTribeShortVideoItemBuilder$TribeShortVideoView.setFocusable(false);
      paramacju.jdField_a_of_type_ComTencentMobileqqActivityAioItemTribeShortVideoItemBuilder$TribeShortVideoView.setFocusableInTouchMode(false);
      paramacju.jdField_a_of_type_ComTencentMobileqqActivityAioItemTribeShortVideoItemBuilder$TribeShortVideoView.setClickable(false);
      paramacju.jdField_a_of_type_ComTencentMobileqqActivityAioItemTribeShortVideoItemBuilder$TribeShortVideoView.setSharpCornerCor(BubbleImageView.jdField_a_of_type_ArrayOfFloat);
      paramacju.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(paramacju.jdField_a_of_type_ComTencentMobileqqActivityAioItemTribeShortVideoItemBuilder$TribeShortVideoView, 0);
      paramBaseChatItemLayout = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[] { 536870912, 0 });
      paramBaseChatItemLayout.setShape(0);
      float f1 = azvv.a(this.jdField_b_of_type_AndroidContentContext, 15.0F);
      paramBaseChatItemLayout.setCornerRadii(new float[] { f1, f1, f1, f1, 0.0F, 0.0F, 0.0F, 0.0F });
      paramBaseChatItemLayout.setGradientType(0);
      paramacju.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(paramBaseChatItemLayout);
      paramacju.jdField_a_of_type_ComTencentBizQqstoryViewWidgetAutoStartProgressBar.setRadius(15.0F, true);
      paramacju.jdField_a_of_type_ComTencentBizQqstoryViewWidgetAutoStartProgressBar.setShowCorner(true);
      paramacju.jdField_a_of_type_ComTencentBizQqstoryViewWidgetAutoStartProgressBar.setDrawStatus(1);
      paramView.setOnLongClickListener(paramacmv);
      paramView.setOnTouchListener(paramacmv);
      paramacju.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      i = this.jdField_b_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131165222);
      j = this.c;
      k = BaseChatItemLayout.j;
      m = this.d;
      n = BaseChatItemLayout.g;
      i1 = this.g;
      paramBaseChatItemLayout = (RelativeLayout.LayoutParams)paramacju.jdField_a_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
      paramBaseChatItemLayout.width = (j + k + i);
      paramBaseChatItemLayout.height = (i1 + (m + n));
      paramacju.jdField_a_of_type_AndroidWidgetRelativeLayout.setLayoutParams(paramBaseChatItemLayout);
      label526:
      paramacju.jdField_a_of_type_ComTencentBizQqstoryViewWidgetAutoStartProgressBar.setKey(paramChatMessage.frienduin + paramChatMessage.uniseq);
      paramacju.jdField_a_of_type_ComTencentBizQqstoryViewWidgetAutoStartProgressBar.setCornerDirection(bool);
      i = azvv.a(this.jdField_b_of_type_AndroidContentContext, paramacju.jdField_a_of_type_ComTencentMobileqqActivityAioItemTribeShortVideoItemBuilder$TribeShortVideoView.a);
      if (paramacju.jdField_a_of_type_ComTencentMobileqqActivityAioItemTribeShortVideoItemBuilder$TribeShortVideoView.d != bool)
      {
        paramacju.jdField_a_of_type_ComTencentMobileqqActivityAioItemTribeShortVideoItemBuilder$TribeShortVideoView.d = bool;
        paramacju.jdField_a_of_type_ComTencentMobileqqActivityAioItemTribeShortVideoItemBuilder$TribeShortVideoView.a(this.c - i, this.d - azvv.a(this.jdField_b_of_type_AndroidContentContext, 3.0F));
        paramacju.jdField_a_of_type_ComTencentMobileqqActivityAioItemTribeShortVideoItemBuilder$TribeShortVideoView.invalidate();
      }
      if (bool) {
        break label878;
      }
      paramBaseChatItemLayout = (RelativeLayout.LayoutParams)paramacju.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams();
      paramBaseChatItemLayout.leftMargin = i;
      paramBaseChatItemLayout.rightMargin = 0;
      paramacju.jdField_a_of_type_AndroidWidgetTextView.setLayoutParams(paramBaseChatItemLayout);
      paramBaseChatItemLayout = (RelativeLayout.LayoutParams)paramacju.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
      paramBaseChatItemLayout.leftMargin = i;
      paramBaseChatItemLayout.rightMargin = 0;
      paramacju.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams(paramBaseChatItemLayout);
    }
    for (;;)
    {
      a(paramacju, paramChatMessage.uniseq, (MessageForTribeShortVideo)paramChatMessage, false);
      return paramView;
      this.c = azvv.a(this.jdField_b_of_type_AndroidContentContext, 137.0F);
      this.d = azvv.a(this.jdField_b_of_type_AndroidContentContext, 218.0F);
      break;
      label759:
      paramBaseChatItemLayout = new RelativeLayout.LayoutParams(this.c, this.d);
      paramacju.jdField_a_of_type_ComTencentMobileqqActivityAioItemTribeShortVideoItemBuilder$TribeShortVideoView.setLayoutParams(paramBaseChatItemLayout);
      i = this.jdField_b_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131165222);
      j = this.c;
      k = BaseChatItemLayout.j;
      m = this.d;
      n = BaseChatItemLayout.g;
      i1 = this.g;
      paramBaseChatItemLayout = (RelativeLayout.LayoutParams)paramacju.jdField_a_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
      paramBaseChatItemLayout.width = (j + k + i);
      paramBaseChatItemLayout.height = (i1 + (m + n));
      paramacju.jdField_a_of_type_AndroidWidgetRelativeLayout.setLayoutParams(paramBaseChatItemLayout);
      break label526;
      label878:
      paramBaseChatItemLayout = (RelativeLayout.LayoutParams)paramacju.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams();
      paramBaseChatItemLayout.leftMargin = 0;
      paramBaseChatItemLayout.rightMargin = i;
      paramacju.jdField_a_of_type_AndroidWidgetTextView.setLayoutParams(paramBaseChatItemLayout);
      paramBaseChatItemLayout = (RelativeLayout.LayoutParams)paramacju.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
      paramBaseChatItemLayout.leftMargin = 0;
      paramBaseChatItemLayout.rightMargin = i;
      paramacju.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams(paramBaseChatItemLayout);
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
      aael.b(this.jdField_b_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
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
      aphp.a((Activity)this.jdField_b_of_type_AndroidContentContext, paramChatMessage, 21);
      return;
      super.a(paramChatMessage);
      return;
      super.d(paramChatMessage);
    }
  }
  
  public void a(adsa paramadsa)
  {
    try
    {
      paramadsa = (MessageForTribeShortVideo)paramadsa.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
      if (QLog.isColorLevel()) {
        QLog.d("TribeShortVideoItemBuilder", 2, "TribeShortVideoItemBuilder onBubbleOnClick:" + paramadsa.toString());
      }
      Intent localIntent = new Intent(this.jdField_b_of_type_AndroidContentContext, QQBrowserActivity.class);
      localIntent.putExtra("url", paramadsa.jumpUrl);
      this.jdField_b_of_type_AndroidContentContext.startActivity(localIntent);
      awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_tribe", "", "video_obj", "clk_obj", 0, 0, paramadsa.bid, paramadsa.pid, "", "");
      return;
    }
    catch (Exception paramadsa)
    {
      while (!QLog.isColorLevel()) {}
      QLog.w("TribeShortVideoItemBuilder", 2, "TribeShortVideoItemBuilder onBubbleOnClick exp :", paramadsa);
    }
  }
  
  public void a(adsa paramadsa, long paramLong)
  {
    ((Activity)this.jdField_b_of_type_AndroidContentContext).runOnUiThread(new TribeShortVideoItemBuilder.6(this, paramadsa, paramLong));
  }
  
  public void a(adsa paramadsa, long paramLong, int paramInt1, int paramInt2, String paramString1, String paramString2)
  {
    a(paramadsa.jdField_a_of_type_ComTencentMobileqqActivityAioItemTribeShortVideoItemBuilder$TribeShortVideoView, paramLong, paramInt1, paramInt2, paramString1, paramString2);
    if (!baab.a().a(paramadsa.jdField_a_of_type_ComTencentMobileqqDataChatMessage, "video_play"))
    {
      baab.a().a(paramadsa.jdField_a_of_type_ComTencentMobileqqDataChatMessage, "video_play");
      if ((paramadsa.jdField_a_of_type_ComTencentMobileqqDataChatMessage instanceof MessageForTribeShortVideo))
      {
        paramString2 = (MessageForTribeShortVideo)paramadsa.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
        awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_tribe", "", "video_obj", "video_play", 0, 0, paramString2.bid, paramString2.pid, "", "");
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
        paramadsa = Integer.valueOf(0);
        paramString1.put("pid", paramadsa);
        if (!TextUtils.isEmpty(paramString2.themeName)) {
          paramString1.put("theme_id", paramString2.themeName);
        }
      }
      catch (Exception paramadsa)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.w("TribeShortVideoItemBuilder", 2, "request cgi params is wrong!");
        continue;
      }
      paramadsa = new NewIntent(this.jdField_b_of_type_AndroidContentContext, mmi.class);
      paramadsa.putExtra("cmd", "MQUpdateSvc_com_qq_xiaoqu.web.publish_post");
      paramString2 = new WebSsoBody.WebSsoRequestBody();
      paramString2.type.set(0);
      paramString2.data.set(paramString1.toString());
      paramadsa.putExtra("data", paramString2.toByteArray());
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet(paramadsa);
      return;
      paramLong = Long.parseLong(paramString2.bid);
      continue;
      paramadsa = paramString2.pid;
    }
  }
  
  public void a(adsa paramadsa, long paramLong, MessageForTribeShortVideo paramMessageForTribeShortVideo, boolean paramBoolean)
  {
    Object localObject = new File(ajed.bd + paramMessageForTribeShortVideo.mVid + ".mp4");
    if (((File)localObject).exists())
    {
      if ((this.jdField_b_of_type_AndroidContentContext instanceof Activity))
      {
        localObject = ((File)localObject).getAbsolutePath();
        ((Activity)this.jdField_b_of_type_AndroidContentContext).runOnUiThread(new TribeShortVideoItemBuilder.2(this, (String)localObject, paramadsa, paramLong, paramMessageForTribeShortVideo));
      }
      return;
    }
    ((Activity)this.jdField_b_of_type_AndroidContentContext).runOnUiThread(new TribeShortVideoItemBuilder.3(this, paramadsa));
    if (QLog.isColorLevel()) {
      QLog.d("TribeShortVideoItemBuilder", 2, "TribeShortVideoItemBuilder handleGetVideo 1: download");
    }
    a(paramMessageForTribeShortVideo, paramadsa);
  }
  
  protected void a(adsa paramadsa, ViewGroup paramViewGroup, boolean paramBoolean)
  {
    paramadsa.jdField_a_of_type_AndroidWidgetFrameLayout = new FrameLayout(this.jdField_b_of_type_AndroidContentContext);
    Object localObject1 = new TextView(this.jdField_b_of_type_AndroidContentContext);
    ((TextView)localObject1).setBackgroundResource(2130841999);
    Object localObject2 = this.jdField_b_of_type_AndroidContentContext.getResources().getDrawable(2130845294);
    ((Drawable)localObject2).setBounds(0, 0, 36, 36);
    ((TextView)localObject1).setCompoundDrawables((Drawable)localObject2, null, null, null);
    ((TextView)localObject1).setCompoundDrawablePadding(5);
    ((TextView)localObject1).setTextSize(1, 12.0F);
    ((TextView)localObject1).setTextColor(this.jdField_b_of_type_AndroidContentContext.getResources().getColor(2131101537));
    ((TextView)localObject1).setIncludeFontPadding(false);
    ((TextView)localObject1).setSingleLine();
    ((TextView)localObject1).setGravity(16);
    ((TextView)localObject1).setPadding(azvv.a(this.jdField_b_of_type_AndroidContentContext, 5.0F), 0, azvv.a(this.jdField_b_of_type_AndroidContentContext, 5.0F), 0);
    paramadsa.jdField_a_of_type_AndroidWidgetFrameLayout.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    localObject2 = new FrameLayout.LayoutParams(-2, -2);
    paramadsa.jdField_a_of_type_AndroidWidgetFrameLayout.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
    paramadsa.b = ((TextView)localObject1);
    localObject1 = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject1).addRule(3, 2131298552);
    ((RelativeLayout.LayoutParams)localObject1).addRule(5, 2131298552);
    paramViewGroup.addView(paramadsa.jdField_a_of_type_AndroidWidgetFrameLayout, (ViewGroup.LayoutParams)localObject1);
  }
  
  protected void a(ViewGroup paramViewGroup, ChatMessage paramChatMessage)
  {
    MessageForTribeShortVideo localMessageForTribeShortVideo = (MessageForTribeShortVideo)paramChatMessage;
    localMessageForTribeShortVideo.parse();
    adsa localadsa = (adsa)paramViewGroup.getTag();
    boolean bool = localMessageForTribeShortVideo.isSend();
    if (localadsa.jdField_a_of_type_AndroidWidgetFrameLayout == null) {
      a(localadsa, paramViewGroup, bool);
    }
    paramViewGroup = (FrameLayout.LayoutParams)localadsa.b.getLayoutParams();
    if (bool)
    {
      paramViewGroup.leftMargin = BaseChatItemLayout.j;
      localadsa.b.setLayoutParams(paramViewGroup);
      if (TextUtils.isEmpty(localMessageForTribeShortVideo.themeName)) {
        break label294;
      }
      localadsa.jdField_a_of_type_AndroidWidgetTextView.setText("#" + localMessageForTribeShortVideo.themeName);
      localadsa.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      label126:
      if (TextUtils.isEmpty(localMessageForTribeShortVideo.srcName)) {
        break label381;
      }
      if (localMessageForTribeShortVideo.srcName.length() <= 5) {
        break label343;
      }
      localadsa.b.setText(localMessageForTribeShortVideo.srcName.substring(0, 5) + ajjy.a(2131649301));
      label189:
      localadsa.jdField_a_of_type_ComTencentBizQqstoryViewWidgetAutoStartProgressBar.setCornerDirection(paramChatMessage.isSend());
      if ((!TextUtils.isEmpty(localMessageForTribeShortVideo.mVid)) && (awfq.b)) {
        break label411;
      }
      localadsa.jdField_a_of_type_Boolean = false;
      localadsa.jdField_a_of_type_ComTencentBizQqstoryViewWidgetAutoStartProgressBar.setDrawStatus(2);
      localadsa.jdField_a_of_type_ComTencentBizQqstoryViewWidgetAutoStartProgressBar.setVisibility(0);
      a(localadsa.jdField_a_of_type_ComTencentMobileqqActivityAioItemTribeShortVideoItemBuilder$TribeShortVideoView, localMessageForTribeShortVideo.coverImgUrl, this.c, this.d, this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
    }
    label294:
    label343:
    label381:
    do
    {
      return;
      paramViewGroup.leftMargin = (azvv.a(this.jdField_b_of_type_AndroidContentContext, localadsa.jdField_a_of_type_ComTencentMobileqqActivityAioItemTribeShortVideoItemBuilder$TribeShortVideoView.a) + BaseChatItemLayout.i);
      break;
      if (!TextUtils.isEmpty(localMessageForTribeShortVideo.brief))
      {
        localadsa.jdField_a_of_type_AndroidWidgetTextView.setText(localMessageForTribeShortVideo.brief);
        localadsa.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
        break label126;
      }
      localadsa.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      break label126;
      localadsa.b.setText(localMessageForTribeShortVideo.srcName + ajjy.a(2131649302));
      break label189;
      localadsa.b.setText(this.jdField_b_of_type_AndroidContentContext.getString(2131655019));
      localadsa.b.setOnClickListener(null);
      break label189;
      paramViewGroup = (Long)localadsa.jdField_a_of_type_ComTencentMobileqqActivityAioItemTribeShortVideoItemBuilder$TribeShortVideoView.getTag();
    } while ((paramViewGroup != null) && (paramViewGroup.longValue() == localMessageForTribeShortVideo.uniseq));
    label411:
    localadsa.jdField_a_of_type_Boolean = false;
    a(localadsa.jdField_a_of_type_ComTencentMobileqqActivityAioItemTribeShortVideoItemBuilder$TribeShortVideoView, localMessageForTribeShortVideo.coverImgUrl, this.c, this.d, this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
    a(localadsa, localMessageForTribeShortVideo.uniseq, localMessageForTribeShortVideo, false);
    localadsa.jdField_a_of_type_ComTencentMobileqqActivityAioItemTribeShortVideoItemBuilder$TribeShortVideoView.setTag(Long.valueOf(localMessageForTribeShortVideo.uniseq));
  }
  
  public void a(TribeShortVideoItemBuilder.TribeShortVideoView paramTribeShortVideoView, long paramLong, int paramInt1, int paramInt2, String paramString1, String paramString2)
  {
    paramString1 = a(paramInt1, paramInt2, paramLong, paramString1, paramString2);
    paramString2 = URLDrawable.URLDrawableOptions.obtain();
    paramString2.mExtraInfo = paramString1;
    paramString2.mLoadingDrawable = a(paramString1.mCoverUrl);
    paramTribeShortVideoView.setImageDrawable(URLDrawable.getDrawable(PAVideoView.a(paramLong), paramString2));
  }
  
  protected void a(MessageForTribeShortVideo paramMessageForTribeShortVideo, adsa paramadsa)
  {
    Object localObject1 = new File(ajed.bd);
    if (!((File)localObject1).exists()) {
      ((File)localObject1).mkdirs();
    }
    localObject1 = ajed.bd + paramMessageForTribeShortVideo.mVid + ".mp4";
    Object localObject2 = new File((String)localObject1);
    localObject2 = new batm(paramMessageForTribeShortVideo.videoUrl, (File)localObject2);
    ((batm)localObject2).jdField_b_of_type_Int = 2;
    Bundle localBundle = new Bundle();
    localBundle.putString("filePath", (String)localObject1);
    this.jdField_a_of_type_Batr.a((batm)localObject2, new adrx(this, paramadsa, paramMessageForTribeShortVideo), localBundle);
  }
  
  public bakj[] a(View paramView)
  {
    bakh localbakh = new bakh();
    paramView = aciy.a(paramView);
    if (azhy.a(paramView) == null) {}
    localbakh.a(2131301021, this.jdField_b_of_type_AndroidContentContext.getString(2131627114), 2130838599);
    if ((paramView.extraflag != 32768) && (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(paramView))) {
      a(localbakh, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, paramView);
    }
    a(localbakh, paramView);
    c(localbakh, this.jdField_b_of_type_AndroidContentContext);
    super.d(localbakh, this.jdField_b_of_type_AndroidContentContext);
    return localbakh.a();
  }
  
  public void b(adsa paramadsa)
  {
    try
    {
      paramadsa = (MessageForTribeShortVideo)paramadsa.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
      if (QLog.isColorLevel()) {
        QLog.d("TribeShortVideoItemBuilder", 2, "TribeShortVideoItemBuilder onSourceOnClick:" + paramadsa.toString());
      }
      Intent localIntent = new Intent(this.jdField_b_of_type_AndroidContentContext, QQBrowserActivity.class);
      localIntent.putExtra("isOpeningQunApp", false);
      localIntent.putExtra("url", paramadsa.sourceJumpUrl);
      this.jdField_b_of_type_AndroidContentContext.startActivity(localIntent);
      awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_tribe", "", "video_obj", "Clk_tail", 0, 0, paramadsa.bid, paramadsa.pid, "", "");
      return;
    }
    catch (Exception paramadsa)
    {
      while (!QLog.isColorLevel()) {}
      QLog.w("TribeShortVideoItemBuilder", 2, "TribeShortVideoItemBuilder onSourceOnClick exp :", paramadsa);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.TribeShortVideoItemBuilder
 * JD-Core Version:    0.7.0.1
 */