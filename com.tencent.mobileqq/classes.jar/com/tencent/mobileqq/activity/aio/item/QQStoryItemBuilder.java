package com.tencent.mobileqq.activity.aio.item;

import acex;
import aekt;
import aelt;
import aely;
import aeov;
import aftz;
import afua;
import afub;
import afuc;
import afud;
import afue;
import afuf;
import alpo;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.GradientDrawable.Orientation;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
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
import arum;
import ayvc;
import ayzf;
import azag;
import bcid;
import bcwh;
import bdan;
import bdcd;
import bddb;
import bdds;
import bdee;
import bdfq;
import bdkz;
import bdlb;
import bhou;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.view.widget.AutoStartProgressBar;
import com.tencent.biz.qqstory.widget.InteractContainerLayout;
import com.tencent.biz.qqstory.widget.PollContainerLayout;
import com.tencent.image.QQLiveDrawable.QQLiveDrawableParams;
import com.tencent.image.RegionDrawable;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForQQStory;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.widget.BubbleImageView;
import com.tencent.mobileqq.widget.PAVideoView;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import ujf;
import ujl;
import uro;
import urr;
import ute;
import vhj;
import wsv;
import wta;

public class QQStoryItemBuilder
  extends BaseBubbleBuilder
{
  public afue a;
  protected Drawable a;
  public View.OnClickListener a;
  private StoryVideoItem a;
  protected String a;
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
  protected int h;
  
  public QQStoryItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    this.jdField_b_of_type_Float = 15.0F;
    this.jdField_a_of_type_Ujf = new ujf();
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new aftz(this);
    this.jdField_a_of_type_Afue = new afuc(this);
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
    this.jdField_a_of_type_Ujf.a(this.jdField_a_of_type_Afue);
    azag.a();
    paramQQAppInterface = (aely)paramQQAppInterface.getManager(282);
    if (paramQQAppInterface != null) {
      paramQQAppInterface.a(3, 5);
    }
  }
  
  private Drawable a(afuf paramafuf, String paramString)
  {
    a(paramafuf, paramString);
    Object localObject2;
    if ((paramafuf.jdField_a_of_type_ComTencentImageURLDrawable != null) && ((paramafuf.jdField_a_of_type_ComTencentImageURLDrawable instanceof URLDrawable)))
    {
      localObject1 = paramafuf.jdField_a_of_type_ComTencentImageURLDrawable.getCurrDrawable();
      if ((localObject1 != null) && ((localObject1 instanceof RegionDrawable)))
      {
        localObject1 = ((RegionDrawable)localObject1).getBitmap();
        if ((localObject1 == null) || (((Bitmap)localObject1).isRecycled())) {
          break label226;
        }
        localObject2 = new BitmapDrawable((Bitmap)localObject1);
        localObject1 = localObject2;
        if (QLog.isColorLevel()) {
          QLog.e("QQStoryItemBuilder", 2, "getBitmapDrawable(): find bitmap drawable coverUrl=" + paramString + " holder=" + paramafuf.hashCode());
        }
      }
    }
    label226:
    for (Object localObject1 = localObject2;; localObject1 = null)
    {
      localObject2 = localObject1;
      if (localObject1 == null)
      {
        localObject1 = PAVideoView.a;
        localObject2 = localObject1;
        if (QLog.isColorLevel())
        {
          QLog.e("QQStoryItemBuilder", 2, "getBitmapDrawable(): use loading drawable coverUrl=" + paramString + " holder=" + paramafuf.hashCode());
          localObject2 = localObject1;
        }
      }
      return localObject2;
      if (QLog.isColorLevel()) {
        QLog.e("QQStoryItemBuilder", 2, "getBitmapDrawable(): not find reginDrawable coverUrl=" + paramString + " holder=" + paramafuf.hashCode());
      }
    }
  }
  
  public static QQLiveDrawable.QQLiveDrawableParams a(int paramInt1, int paramInt2, long paramLong, String paramString1, String paramString2)
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
      QLog.w("Q.qqstory.share", 2, "setImageUrl exp: " + paramImageView.toString());
    }
  }
  
  private void a(StoryVideoItem paramStoryVideoItem)
  {
    int i = 1;
    ute localute = paramStoryVideoItem.getVideoGameInfo();
    if (localute != null)
    {
      this.jdField_a_of_type_JavaLangString = localute.jdField_a_of_type_JavaLangString;
      if (!paramStoryVideoItem.isMine()) {
        break label45;
      }
      if (localute.jdField_a_of_type_Int != 1) {
        break label40;
      }
    }
    for (;;)
    {
      this.h = i;
      return;
      label40:
      i = 3;
    }
    label45:
    if (localute.jdField_a_of_type_Int == 1) {}
    for (i = 2;; i = 4)
    {
      this.h = i;
      return;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, int paramInt, String paramString, bddb parambddb, boolean paramBoolean)
  {
    int i = 3;
    if (paramInt == 0) {
      i = 1;
    }
    for (;;)
    {
      if (parambddb != null) {}
      for (;;)
      {
        try
        {
          str = parambddb.b("unionid");
          paramQQAppInterface = parambddb.b("storyid");
        }
        catch (Exception paramQQAppInterface)
        {
          if (!QLog.isColorLevel()) {
            break;
          }
        }
        try
        {
          paramInt = Integer.valueOf(parambddb.b("contentType")).intValue();
          parambddb = str;
        }
        catch (Exception parambddb)
        {
          paramInt = -1;
          parambddb = str;
          continue;
        }
        if (paramBoolean)
        {
          str = "1";
          wta.a("share_obj", paramString, i, paramInt, new String[] { parambddb, paramQQAppInterface, str, "" });
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("Q.qqstory.share", 2, "reportClickEvent: opName=" + paramString + ", fromType=" + i + ", result=" + paramInt + ", extra1=" + parambddb + ", extra2=" + paramQQAppInterface + ", extra3=" + str);
          return;
        }
        str = "2";
        continue;
        QLog.w("Q.qqstory.share", 2, "reportClickEvent exp:", paramQQAppInterface);
        return;
        paramInt = -1;
        parambddb = "";
        paramQQAppInterface = "";
      }
      return;
      if (paramInt == 1) {
        i = 2;
      } else if (paramInt != 3000) {
        i = -1;
      }
    }
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    return 0;
  }
  
  public aelt a()
  {
    return new afuf();
  }
  
  public View a(int paramInt1, int paramInt2, ChatMessage paramChatMessage, View paramView, ViewGroup paramViewGroup, aeov paramaeov)
  {
    paramView = (ViewGroup)super.a(paramInt1, paramInt2, paramChatMessage, paramView, paramViewGroup, paramaeov);
    a(paramView, paramChatMessage);
    return paramView;
  }
  
  public View a(ChatMessage paramChatMessage, aelt paramaelt, View paramView, BaseChatItemLayout paramBaseChatItemLayout, aeov paramaeov)
  {
    afuf localafuf = (afuf)paramaelt;
    boolean bool = paramChatMessage.isSend();
    paramaelt = paramView;
    int j;
    if (paramView == null)
    {
      paramaelt = LayoutInflater.from(this.jdField_b_of_type_AndroidContentContext).inflate(2131558783, paramBaseChatItemLayout, false);
      localafuf.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramaelt.findViewById(2131364171));
      localafuf.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localafuf.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131363449));
      localafuf.jdField_b_of_type_AndroidWidgetTextView = ((TextView)localafuf.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131371227));
      localafuf.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localafuf.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131369844));
      localafuf.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)localafuf.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131370076));
      localafuf.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)localafuf.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131367038));
      localafuf.d = ((TextView)localafuf.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131367057));
      localafuf.e = ((TextView)localafuf.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131367028));
      localafuf.jdField_a_of_type_ComTencentBizQqstoryViewWidgetAutoStartProgressBar = ((AutoStartProgressBar)localafuf.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131379693));
      localafuf.jdField_a_of_type_ComTencentBizQqstoryViewWidgetAutoStartProgressBar.setSharpCornerCor(BubbleImageView.jdField_a_of_type_ArrayOfFloat);
      localafuf.jdField_a_of_type_ComTencentMobileqqActivityAioItemQQStoryItemBuilder$StoryChatVideoView = new QQStoryItemBuilder.StoryChatVideoView(this.jdField_b_of_type_AndroidContentContext);
      paramView = new RelativeLayout.LayoutParams(this.c, this.d);
      localafuf.jdField_a_of_type_ComTencentMobileqqActivityAioItemQQStoryItemBuilder$StoryChatVideoView.setLayoutParams(paramView);
      localafuf.jdField_a_of_type_ComTencentMobileqqActivityAioItemQQStoryItemBuilder$StoryChatVideoView.c(false);
      localafuf.jdField_a_of_type_ComTencentMobileqqActivityAioItemQQStoryItemBuilder$StoryChatVideoView.setRadius(15.0F);
      localafuf.jdField_a_of_type_ComTencentMobileqqActivityAioItemQQStoryItemBuilder$StoryChatVideoView.setScaleType(ImageView.ScaleType.CENTER_CROP);
      localafuf.jdField_a_of_type_ComTencentMobileqqActivityAioItemQQStoryItemBuilder$StoryChatVideoView.d(true);
      localafuf.jdField_a_of_type_ComTencentMobileqqActivityAioItemQQStoryItemBuilder$StoryChatVideoView.setFocusable(false);
      localafuf.jdField_a_of_type_ComTencentMobileqqActivityAioItemQQStoryItemBuilder$StoryChatVideoView.setFocusableInTouchMode(false);
      localafuf.jdField_a_of_type_ComTencentMobileqqActivityAioItemQQStoryItemBuilder$StoryChatVideoView.setClickable(false);
      localafuf.jdField_a_of_type_ComTencentMobileqqActivityAioItemQQStoryItemBuilder$StoryChatVideoView.setSharpCornerCor(BubbleImageView.jdField_a_of_type_ArrayOfFloat);
      localafuf.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(localafuf.jdField_a_of_type_ComTencentMobileqqActivityAioItemQQStoryItemBuilder$StoryChatVideoView, 0);
      localafuf.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView = new BubbleImageView(this.jdField_b_of_type_AndroidContentContext);
      paramView = new RelativeLayout.LayoutParams(this.c, this.d);
      localafuf.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setLayoutParams(paramView);
      localafuf.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.c(false);
      localafuf.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setRadius(15.0F);
      localafuf.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
      localafuf.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.d(true);
      localafuf.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setFocusable(false);
      localafuf.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setFocusableInTouchMode(false);
      localafuf.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setClickable(false);
      localafuf.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setSharpCornerCor(BubbleImageView.jdField_a_of_type_ArrayOfFloat);
      localafuf.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(localafuf.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView, 1);
      localafuf.jdField_b_of_type_ComTencentMobileqqWidgetBubbleImageView = new BubbleImageView(this.jdField_b_of_type_AndroidContentContext);
      localafuf.jdField_b_of_type_ComTencentMobileqqWidgetBubbleImageView.setLayoutParams(new RelativeLayout.LayoutParams(this.c, this.d));
      localafuf.jdField_b_of_type_ComTencentMobileqqWidgetBubbleImageView.c(false);
      localafuf.jdField_b_of_type_ComTencentMobileqqWidgetBubbleImageView.setRadius(15.0F);
      localafuf.jdField_b_of_type_ComTencentMobileqqWidgetBubbleImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
      localafuf.jdField_b_of_type_ComTencentMobileqqWidgetBubbleImageView.d(true);
      localafuf.jdField_b_of_type_ComTencentMobileqqWidgetBubbleImageView.setFocusable(false);
      localafuf.jdField_b_of_type_ComTencentMobileqqWidgetBubbleImageView.setFocusableInTouchMode(false);
      localafuf.jdField_b_of_type_ComTencentMobileqqWidgetBubbleImageView.setClickable(false);
      localafuf.jdField_b_of_type_ComTencentMobileqqWidgetBubbleImageView.setVisibility(4);
      localafuf.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(localafuf.jdField_b_of_type_ComTencentMobileqqWidgetBubbleImageView, 2);
      localafuf.jdField_c_of_type_ComTencentMobileqqWidgetBubbleImageView = new BubbleImageView(this.jdField_b_of_type_AndroidContentContext);
      localafuf.jdField_c_of_type_ComTencentMobileqqWidgetBubbleImageView.setLayoutParams(new RelativeLayout.LayoutParams(this.c, this.d));
      localafuf.jdField_c_of_type_ComTencentMobileqqWidgetBubbleImageView.c(false);
      localafuf.jdField_c_of_type_ComTencentMobileqqWidgetBubbleImageView.setRadius(15.0F);
      localafuf.jdField_c_of_type_ComTencentMobileqqWidgetBubbleImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
      localafuf.jdField_c_of_type_ComTencentMobileqqWidgetBubbleImageView.d(true);
      localafuf.jdField_c_of_type_ComTencentMobileqqWidgetBubbleImageView.setFocusable(false);
      localafuf.jdField_c_of_type_ComTencentMobileqqWidgetBubbleImageView.setFocusableInTouchMode(false);
      localafuf.jdField_c_of_type_ComTencentMobileqqWidgetBubbleImageView.setClickable(false);
      localafuf.jdField_c_of_type_ComTencentMobileqqWidgetBubbleImageView.setVisibility(4);
      localafuf.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(localafuf.jdField_c_of_type_ComTencentMobileqqWidgetBubbleImageView, 2);
      paramView = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[] { 536870912, 0 });
      paramView.setShape(0);
      float f1 = bcwh.a(this.jdField_b_of_type_AndroidContentContext, 15.0F);
      paramView.setCornerRadii(new float[] { f1, f1, f1, f1, 0.0F, 0.0F, 0.0F, 0.0F });
      paramView.setGradientType(0);
      localafuf.jdField_b_of_type_AndroidWidgetImageView.setBackgroundDrawable(paramView);
      localafuf.jdField_a_of_type_ComTencentBizQqstoryViewWidgetAutoStartProgressBar.setRadius(15.0F, true);
      localafuf.jdField_a_of_type_ComTencentBizQqstoryViewWidgetAutoStartProgressBar.setShowCorner(true);
      localafuf.jdField_a_of_type_ComTencentBizQqstoryViewWidgetAutoStartProgressBar.setDrawStatus(1);
      paramaelt.setOnLongClickListener(paramaeov);
      paramaelt.setOnTouchListener(paramaeov);
      localafuf.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      i = this.jdField_b_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131296300);
      j = this.c;
      int k = BaseChatItemLayout.j;
      int m = this.d;
      int n = BaseChatItemLayout.g;
      int i1 = this.g;
      paramView = (RelativeLayout.LayoutParams)localafuf.jdField_a_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
      paramView.width = (j + k + i);
      paramView.height = (i1 + (m + n));
      localafuf.jdField_a_of_type_AndroidWidgetRelativeLayout.setLayoutParams(paramView);
    }
    localafuf.jdField_a_of_type_ComTencentBizQqstoryViewWidgetAutoStartProgressBar.setKey(paramChatMessage.frienduin + paramChatMessage.uniseq);
    localafuf.jdField_a_of_type_ComTencentBizQqstoryViewWidgetAutoStartProgressBar.setCornerDirection(bool);
    if (localafuf.jdField_a_of_type_ComTencentMobileqqActivityAioItemQQStoryItemBuilder$StoryChatVideoView.d != bool)
    {
      localafuf.jdField_a_of_type_ComTencentMobileqqActivityAioItemQQStoryItemBuilder$StoryChatVideoView.d = bool;
      localafuf.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.d = bool;
      localafuf.jdField_b_of_type_ComTencentMobileqqWidgetBubbleImageView.d = bool;
      localafuf.jdField_c_of_type_ComTencentMobileqqWidgetBubbleImageView.d = bool;
      if (bhou.e())
      {
        localafuf.jdField_a_of_type_ComTencentMobileqqActivityAioItemQQStoryItemBuilder$StoryChatVideoView.a(this.c, this.d);
        localafuf.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.a(this.c, this.d);
        localafuf.jdField_b_of_type_ComTencentMobileqqWidgetBubbleImageView.a(this.c, this.d);
        localafuf.jdField_c_of_type_ComTencentMobileqqWidgetBubbleImageView.a(this.c, this.d);
      }
      localafuf.jdField_a_of_type_ComTencentMobileqqActivityAioItemQQStoryItemBuilder$StoryChatVideoView.invalidate();
      localafuf.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.invalidate();
      localafuf.jdField_b_of_type_ComTencentMobileqqWidgetBubbleImageView.invalidate();
      localafuf.jdField_c_of_type_ComTencentMobileqqWidgetBubbleImageView.invalidate();
    }
    int i = bcwh.a(this.jdField_b_of_type_AndroidContentContext, localafuf.jdField_a_of_type_ComTencentMobileqqActivityAioItemQQStoryItemBuilder$StoryChatVideoView.a);
    if ((paramChatMessage instanceof MessageForQQStory))
    {
      paramChatMessage = (MessageForQQStory)paramChatMessage;
      if ((TextUtils.isEmpty(paramChatMessage.storyTitle)) || (TextUtils.isEmpty(paramChatMessage.storyBrief))) {
        break label1520;
      }
      j = 1;
      if (j == 0) {
        break label1539;
      }
      paramView = (RelativeLayout.LayoutParams)localafuf.jdField_a_of_type_AndroidViewViewGroup.getLayoutParams();
      if (bool) {
        break label1526;
      }
      j = i;
      label1258:
      paramView.leftMargin = j;
      if (bool) {
        break label1532;
      }
      j = 0;
      label1272:
      paramView.rightMargin = j;
      paramView.width = (this.c - i);
      paramView.height = bcwh.a(this.jdField_b_of_type_AndroidContentContext, 42.0F);
      localafuf.jdField_a_of_type_AndroidViewViewGroup.setLayoutParams(paramView);
      localafuf.jdField_a_of_type_AndroidViewViewGroup.setVisibility(0);
      if ((GradientDrawable)localafuf.jdField_a_of_type_AndroidViewViewGroup.getBackground() == null)
      {
        paramView = new GradientDrawable();
        paramView.setCornerRadii(this.jdField_a_of_type_ArrayOfFloat);
        paramView.setColor(1929379840);
        localafuf.jdField_a_of_type_AndroidViewViewGroup.setBackgroundDrawable(paramView);
      }
      localafuf.d.setText(paramChatMessage.storyTitle);
      localafuf.e.setText(paramChatMessage.storyBrief);
    }
    for (;;)
    {
      if (bool) {
        break label1552;
      }
      paramChatMessage = (RelativeLayout.LayoutParams)localafuf.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams();
      paramChatMessage.leftMargin = i;
      paramChatMessage.rightMargin = 0;
      localafuf.jdField_a_of_type_AndroidWidgetTextView.setLayoutParams(paramChatMessage);
      paramChatMessage = (RelativeLayout.LayoutParams)localafuf.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
      paramChatMessage.leftMargin = bcwh.a(this.jdField_b_of_type_AndroidContentContext, localafuf.jdField_a_of_type_ComTencentMobileqqActivityAioItemQQStoryItemBuilder$StoryChatVideoView.a + 10);
      paramChatMessage.rightMargin = bcwh.a(this.jdField_b_of_type_AndroidContentContext, 10);
      localafuf.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams(paramChatMessage);
      paramChatMessage = (RelativeLayout.LayoutParams)localafuf.jdField_b_of_type_AndroidWidgetImageView.getLayoutParams();
      paramChatMessage.leftMargin = i;
      paramChatMessage.rightMargin = 0;
      localafuf.jdField_b_of_type_AndroidWidgetImageView.setLayoutParams(paramChatMessage);
      return paramaelt;
      label1520:
      j = 0;
      break;
      label1526:
      j = 0;
      break label1258;
      label1532:
      j = i;
      break label1272;
      label1539:
      localafuf.jdField_a_of_type_AndroidViewViewGroup.setVisibility(8);
    }
    label1552:
    paramChatMessage = (RelativeLayout.LayoutParams)localafuf.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams();
    paramChatMessage.leftMargin = 0;
    paramChatMessage.rightMargin = i;
    localafuf.jdField_a_of_type_AndroidWidgetTextView.setLayoutParams(paramChatMessage);
    paramChatMessage = (RelativeLayout.LayoutParams)localafuf.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
    paramChatMessage.leftMargin = bcwh.a(this.jdField_b_of_type_AndroidContentContext, 10);
    paramChatMessage.rightMargin = bcwh.a(this.jdField_b_of_type_AndroidContentContext, localafuf.jdField_a_of_type_ComTencentMobileqqActivityAioItemQQStoryItemBuilder$StoryChatVideoView.a + 10);
    localafuf.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams(paramChatMessage);
    paramChatMessage = (RelativeLayout.LayoutParams)localafuf.jdField_b_of_type_AndroidWidgetImageView.getLayoutParams();
    paramChatMessage.leftMargin = 0;
    paramChatMessage.rightMargin = i;
    localafuf.jdField_b_of_type_AndroidWidgetImageView.setLayoutParams(paramChatMessage);
    return paramaelt;
  }
  
  public String a(ChatMessage paramChatMessage)
  {
    return paramChatMessage.getSummaryMsg();
  }
  
  public void a()
  {
    this.jdField_a_of_type_Ujf.a();
    if (this.jdField_f_of_type_Boolean)
    {
      ((ujl)urr.a(6)).a(15000L);
      this.jdField_f_of_type_Boolean = false;
    }
    super.a();
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    if (!(paramChatMessage instanceof MessageForQQStory)) {
      super.a(paramInt, paramContext, paramChatMessage);
    }
    MessageForQQStory localMessageForQQStory;
    do
    {
      boolean bool;
      Object localObject1;
      do
      {
        do
        {
          do
          {
            return;
            localMessageForQQStory = (MessageForQQStory)paramChatMessage;
            if (bcid.a(paramChatMessage) == null) {
              bool = true;
            }
            for (;;)
            {
              Object localObject2 = null;
              try
              {
                localObject1 = bdds.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_AndroidContentContext, localMessageForQQStory.msgAction);
                switch (paramInt)
                {
                default: 
                  super.a(paramInt, paramContext, paramChatMessage);
                  return;
                  bool = false;
                }
              }
              catch (Exception localException)
              {
                for (;;)
                {
                  localObject1 = localObject2;
                  if (QLog.isColorLevel())
                  {
                    QLog.w("Q.qqstory.share", 2, "onMenuItemClicked exp:", localException);
                    localObject1 = localObject2;
                  }
                }
                acex.b(this.jdField_b_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
                a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, "delete", (bddb)localObject1, bool);
                if (localMessageForQQStory.type == 3) {
                  wta.a("mystory", "delete_obj_myday", 0, 0, new String[] { "", "", "", "" });
                }
              }
            }
          } while (localMessageForQQStory.type != 1);
          wta.a("mystory", "delete_obj", 0, 0, new String[] { "", "", "", "" });
          return;
          paramContext = new Bundle();
          if ((localMessageForQQStory.structingMsg.source_puin != null) && (!"".equals(localMessageForQQStory.structingMsg.source_puin))) {
            paramContext.putString("source_puin", localMessageForQQStory.structingMsg.source_puin);
          }
          paramContext.putInt("forward_type", 28);
          localMessageForQQStory.structingMsg.mCommentText = null;
          paramContext.putInt("structmsg_service_id", localMessageForQQStory.structingMsg.mMsgServiceID);
          paramContext.putByteArray("stuctmsg_bytes", localMessageForQQStory.structingMsg.getBytes());
          paramContext.putLong("structmsg_uniseq", localMessageForQQStory.uniseq);
          paramContext.putInt("accostType", localMessageForQQStory.structingMsg.sourceAccoutType);
          paramContext.putInt("selection_mode", this.jdField_b_of_type_Int);
          paramContext.putInt("forward_source_uin_type", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
          paramChatMessage = new Intent();
          paramChatMessage.putExtras(paramContext);
          arum.a((Activity)this.jdField_b_of_type_AndroidContentContext, paramChatMessage, 21);
          a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, "forward", (bddb)localObject1, bool);
          if (localMessageForQQStory.type == 3) {
            wta.a("mystory", "forward_obj_myday", 0, 0, new String[] { "", "", "", "" });
          }
        } while (localMessageForQQStory.type != 1);
        wta.a("mystory", "forward_obj", 0, 0, new String[] { "", "", "", "" });
        return;
        super.a(paramChatMessage);
        a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, "withdraw", (bddb)localObject1, bool);
        if (localMessageForQQStory.type == 3) {
          wta.a("mystory", "withdraw_obj_myday", 0, 0, new String[] { "", "", "", "" });
        }
      } while (localMessageForQQStory.type != 1);
      wta.a("mystory", "withdraw_obj", 0, 0, new String[] { "", "", "", "" });
      return;
      super.a(paramInt, paramContext, paramChatMessage);
      a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, "reply", (bddb)localObject1, bool);
      if (localMessageForQQStory.type == 1)
      {
        wta.a("mystory", "reply_obj", 0, 0, new String[] { "", "", "", "" });
        return;
      }
    } while (localMessageForQQStory.type != 2);
    wta.a("ugc_video", "obj_reply", 0, 0, new String[] { "", "", "", "" });
  }
  
  public void a(afuf paramafuf)
  {
    boolean bool = true;
    for (;;)
    {
      try
      {
        paramafuf = (MessageForQQStory)paramafuf.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
        if (QLog.isColorLevel()) {
          QLog.d("Q.qqstory.share", 2, "QQStoryItemBuilder onBubbleOnClick:" + paramafuf.toString());
        }
        if (bcid.a(paramafuf) == null)
        {
          paramafuf = bdds.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_AndroidContentContext, paramafuf.msgAction);
          paramafuf.c();
          a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, "clk_play", paramafuf, bool);
          int i = this.h;
          String str = this.jdField_a_of_type_JavaLangString;
          if (this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem == null)
          {
            paramafuf = "";
            wta.a("video_game", "clk_gamevideo", 0, 0, new String[] { String.valueOf(i), "", str, paramafuf });
            return;
          }
          paramafuf = this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVid;
          continue;
        }
        bool = false;
      }
      catch (Exception paramafuf)
      {
        if (QLog.isColorLevel()) {
          QLog.w("Q.qqstory.share", 2, "QQStoryItemBuilder onBubbleOnClick exp:", paramafuf);
        }
        return;
      }
    }
  }
  
  public void a(afuf paramafuf, long paramLong)
  {
    ((Activity)this.jdField_b_of_type_AndroidContentContext).runOnUiThread(new QQStoryItemBuilder.10(this, paramafuf, paramLong));
  }
  
  public void a(afuf paramafuf, long paramLong, int paramInt1, int paramInt2, String paramString1, String paramString2)
  {
    b(paramafuf, paramLong, paramInt1, paramInt2, paramString1, paramString2);
    if (!bdan.a().a(paramafuf.jdField_a_of_type_ComTencentMobileqqDataChatMessage, "share|auto_play"))
    {
      bdan.a().a(paramafuf.jdField_a_of_type_ComTencentMobileqqDataChatMessage, "share|auto_play");
      if (!(paramafuf.jdField_a_of_type_ComTencentMobileqqDataChatMessage instanceof MessageForQQStory)) {
        break label188;
      }
      paramInt1 = ((MessageForQQStory)paramafuf.jdField_a_of_type_ComTencentMobileqqDataChatMessage).type;
      if (paramInt1 != 1) {
        break label91;
      }
      paramInt1 = 1;
    }
    label188:
    for (;;)
    {
      wta.a("share", "auto_play", paramInt1, 0, new String[0]);
      return;
      label91:
      if (paramInt1 == 3)
      {
        paramInt1 = 2;
      }
      else if (paramInt1 == 4)
      {
        paramInt1 = 3;
      }
      else if (paramInt1 == 5)
      {
        paramInt1 = 4;
      }
      else if (paramInt1 == 6)
      {
        paramInt1 = 5;
      }
      else if (paramInt1 == 9)
      {
        paramInt1 = 6;
      }
      else if (paramInt1 == 12)
      {
        paramInt1 = 7;
      }
      else if (paramInt1 == 11)
      {
        paramInt1 = 8;
      }
      else
      {
        paramInt1 = 0;
        continue;
        paramInt1 = 0;
      }
    }
  }
  
  public void a(afuf paramafuf, long paramLong, StoryVideoItem paramStoryVideoItem, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem = paramStoryVideoItem;
    boolean bool = StoryVideoItem.isPlayable(paramStoryVideoItem.mVid, true);
    if (QLog.isColorLevel()) {
      QLog.i("QQStoryItemBuilder", 2, "handleGetVideo: isPlayable =" + bool);
    }
    Object localObject;
    if (!bool) {
      if ((b(paramafuf.jdField_a_of_type_ComTencentMobileqqDataChatMessage)) || (paramBoolean))
      {
        ((Activity)this.jdField_b_of_type_AndroidContentContext).runOnUiThread(new QQStoryItemBuilder.5(this, paramafuf));
        if (QLog.isColorLevel()) {
          QLog.d("Q.qqstory.share", 2, "QQStoryItemBuilder handleGetVideo 1: wifi download");
        }
        localObject = new ArrayList();
        ((ArrayList)localObject).add(paramStoryVideoItem);
        this.jdField_a_of_type_Ujf.a((List)localObject);
        this.jdField_a_of_type_Ujf.a(paramStoryVideoItem.mVid);
        this.jdField_a_of_type_Afue.a(paramafuf, paramStoryVideoItem.mVid, paramLong);
      }
    }
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqstory.share", 2, "QQStoryItemBuilder handleGetVideo 2: no wifi");
      }
      ((Activity)this.jdField_b_of_type_AndroidContentContext).runOnUiThread(new QQStoryItemBuilder.6(this, paramafuf, paramLong, paramStoryVideoItem));
      return;
      String str = this.jdField_a_of_type_Ujf.a(paramStoryVideoItem.mVid);
      localObject = str;
      if (str != null)
      {
        localObject = str;
        if (str.startsWith("file://")) {
          localObject = str.substring(7);
        }
      }
    } while (!(this.jdField_b_of_type_AndroidContentContext instanceof Activity));
    ((Activity)this.jdField_b_of_type_AndroidContentContext).runOnUiThread(new QQStoryItemBuilder.7(this, (String)localObject, paramafuf, paramStoryVideoItem, paramLong, paramBoolean));
  }
  
  protected void a(afuf paramafuf, ViewGroup paramViewGroup, boolean paramBoolean)
  {
    paramafuf.jdField_a_of_type_AndroidWidgetFrameLayout = new FrameLayout(this.jdField_b_of_type_AndroidContentContext);
    Object localObject = new TextView(this.jdField_b_of_type_AndroidContentContext);
    ((TextView)localObject).setBackgroundResource(2130842245);
    ((TextView)localObject).setTextSize(1, 12.0F);
    ((TextView)localObject).setTextColor(this.jdField_b_of_type_AndroidContentContext.getResources().getColor(2131167192));
    ((TextView)localObject).setIncludeFontPadding(false);
    ((TextView)localObject).setSingleLine();
    ((TextView)localObject).setGravity(16);
    ((TextView)localObject).setPadding(bcwh.a(this.jdField_b_of_type_AndroidContentContext, 5.0F), 0, bcwh.a(this.jdField_b_of_type_AndroidContentContext, 5.0F), 0);
    paramafuf.jdField_a_of_type_AndroidWidgetFrameLayout.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-2, -2);
    paramafuf.jdField_a_of_type_AndroidWidgetFrameLayout.addView((View)localObject, localLayoutParams);
    paramafuf.jdField_c_of_type_AndroidWidgetTextView = ((TextView)localObject);
    localObject = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject).addRule(3, 2131364171);
    ((RelativeLayout.LayoutParams)localObject).addRule(5, 2131364171);
    paramViewGroup.addView(paramafuf.jdField_a_of_type_AndroidWidgetFrameLayout, (ViewGroup.LayoutParams)localObject);
  }
  
  public void a(afuf paramafuf, String paramString)
  {
    if ((!TextUtils.equals(paramString, paramafuf.jdField_b_of_type_JavaLangString)) || (paramafuf.jdField_a_of_type_ComTencentImageURLDrawable == null))
    {
      paramafuf.jdField_b_of_type_JavaLangString = paramString;
      paramafuf.jdField_a_of_type_ComTencentImageURLDrawable = null;
      if (TextUtils.isEmpty(paramString)) {}
    }
    while (!QLog.isColorLevel()) {
      try
      {
        paramafuf.jdField_a_of_type_ComTencentImageURLDrawable = URLDrawable.getDrawable(paramString, PAVideoView.a, PAVideoView.a);
        if (QLog.isColorLevel()) {
          QLog.e("QQStoryItemBuilder", 2, "checkCoverDrawable(): reload drawable, coverUrl=" + paramString + " holder=" + paramafuf.hashCode());
        }
        return;
      }
      catch (Exception localException)
      {
        while (!QLog.isColorLevel()) {}
        QLog.e("QQStoryItemBuilder", 2, "checkCoverDrawable():  getDrawable Exception, coverUrl=" + paramString + " holder=" + paramafuf.hashCode(), localException);
        return;
      }
    }
    QLog.e("QQStoryItemBuilder", 2, "checkCoverDrawable(): reuse drawable, coverUrl=" + paramString + " holder=" + paramafuf.hashCode());
  }
  
  public void a(afuf paramafuf, String paramString, long paramLong, boolean paramBoolean)
  {
    vhj.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString, new afud(this, paramafuf, paramLong, paramBoolean));
  }
  
  public void a(afuf paramafuf, String paramString1, String paramString2, long paramLong, boolean paramBoolean)
  {
    wsv.a("QQStoryItemBuilder", "setVideoView %s vid %s", paramString1, paramString2);
    ThreadManager.post(new QQStoryItemBuilder.8(this, paramString2, paramafuf, paramLong, paramString1, paramBoolean), 8, null, true);
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    Object localObject = aekt.a(paramView);
    if (!afuf.class.isInstance(localObject)) {}
    String str1;
    String str2;
    do
    {
      return;
      paramView = this.jdField_b_of_type_AndroidContentContext;
      localObject = ((afuf)localObject).jdField_a_of_type_ComTencentMobileqqDataChatMessage;
      str1 = paramView.getString(2131690042);
      str2 = paramView.getString(2131690043);
    } while (!((ChatMessage)localObject).isSendFromLocal());
    bdcd.a(paramView, 230, str1, str2, new afua(this, paramView, (ChatMessage)localObject), new afub(this)).show();
  }
  
  public void a(View paramView, ChatMessage paramChatMessage)
  {
    int i = this.jdField_b_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131296300);
    if (paramChatMessage.isSend())
    {
      paramView.setPadding(BaseChatItemLayout.j, BaseChatItemLayout.g, i, this.g);
      return;
    }
    paramView.setPadding(i, BaseChatItemLayout.g, BaseChatItemLayout.j, this.g);
  }
  
  public void a(View paramView, ChatMessage paramChatMessage, int paramInt)
  {
    super.a(paramView, paramChatMessage, paramInt);
    a((ViewGroup)paramView, paramChatMessage);
  }
  
  protected void a(ViewGroup paramViewGroup, ChatMessage paramChatMessage)
  {
    MessageForQQStory localMessageForQQStory = (MessageForQQStory)paramChatMessage;
    localMessageForQQStory.parse();
    afuf localafuf = (afuf)paramViewGroup.getTag();
    boolean bool = localMessageForQQStory.isSend();
    if (localafuf.jdField_a_of_type_AndroidWidgetFrameLayout == null) {
      a(localafuf, paramViewGroup, bool);
    }
    paramViewGroup = (FrameLayout.LayoutParams)localafuf.jdField_c_of_type_AndroidWidgetTextView.getLayoutParams();
    if (bool)
    {
      paramViewGroup.leftMargin = BaseChatItemLayout.j;
      localafuf.jdField_c_of_type_AndroidWidgetTextView.setLayoutParams(paramViewGroup);
      localafuf.jdField_a_of_type_AndroidWidgetTextView.setText(localMessageForQQStory.brief);
      localafuf.jdField_c_of_type_AndroidWidgetTextView.setText(localMessageForQQStory.srcName);
      if ((localMessageForQQStory.type != 3) && (localMessageForQQStory.type != 5) && (localMessageForQQStory.type != 8) && (localMessageForQQStory.type != 9)) {
        break label346;
      }
      localafuf.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      localafuf.jdField_b_of_type_AndroidWidgetTextView.setText(alpo.a(2131711285));
      label161:
      localafuf.jdField_a_of_type_ComTencentBizQqstoryViewWidgetAutoStartProgressBar.setCornerDirection(paramChatMessage.isSend());
      if ((!TextUtils.isEmpty(localMessageForQQStory.mVid)) && (azag.b)) {
        break label422;
      }
      localafuf.jdField_a_of_type_Boolean = false;
      localafuf.jdField_a_of_type_ComTencentBizQqstoryViewWidgetAutoStartProgressBar.setDrawStatus(2);
      localafuf.jdField_a_of_type_ComTencentBizQqstoryViewWidgetAutoStartProgressBar.setVisibility(0);
      a(localafuf.jdField_a_of_type_ComTencentMobileqqActivityAioItemQQStoryItemBuilder$StoryChatVideoView, localMessageForQQStory.coverImgUrl, this.c, this.d, this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
      a(localafuf.jdField_a_of_type_AndroidWidgetImageView, localMessageForQQStory.logoImgUrl, this.e, this.jdField_f_of_type_Int, this.jdField_b_of_type_AndroidGraphicsDrawableDrawable);
      localafuf.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setImageDrawable(null);
    }
    for (;;)
    {
      try
      {
        paramViewGroup = bdds.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_AndroidContentContext, localMessageForQQStory.msgAction);
        if (bcid.a(localMessageForQQStory) != null) {
          continue;
        }
        bool = true;
        a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, "exp", paramViewGroup, bool);
        return;
      }
      catch (Exception paramViewGroup)
      {
        label346:
        if (!QLog.isColorLevel()) {
          continue;
        }
        label422:
        QLog.w("Q.qqstory.share", 2, "getView report exp:", paramViewGroup);
      }
      paramViewGroup.leftMargin = (bcwh.a(this.jdField_b_of_type_AndroidContentContext, localafuf.jdField_a_of_type_ComTencentMobileqqActivityAioItemQQStoryItemBuilder$StoryChatVideoView.a) + BaseChatItemLayout.i);
      break;
      if (localMessageForQQStory.type == 11)
      {
        localafuf.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
        if (!TextUtils.isEmpty(localMessageForQQStory.mHeadTip))
        {
          localafuf.jdField_b_of_type_AndroidWidgetTextView.setText(localMessageForQQStory.mHeadTip);
          break label161;
        }
        localafuf.jdField_b_of_type_AndroidWidgetTextView.setText(alpo.a(2131711284));
        break label161;
      }
      localafuf.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      break label161;
      paramViewGroup = (Long)localafuf.jdField_a_of_type_ComTencentMobileqqActivityAioItemQQStoryItemBuilder$StoryChatVideoView.getTag();
      paramChatMessage = ((uro)urr.a(5)).a(localMessageForQQStory.mVid);
      if ((paramViewGroup == null) || (paramViewGroup.longValue() != localMessageForQQStory.uniseq))
      {
        localafuf.jdField_a_of_type_Boolean = false;
        localafuf.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setImageDrawable(null);
        a(localafuf.jdField_a_of_type_ComTencentMobileqqActivityAioItemQQStoryItemBuilder$StoryChatVideoView, localMessageForQQStory.coverImgUrl, this.c, this.d, this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
        if (paramChatMessage != null)
        {
          b(localafuf, localMessageForQQStory.uniseq, paramChatMessage, false);
          c(localafuf, localMessageForQQStory.uniseq, paramChatMessage, false);
        }
        a(localafuf, localMessageForQQStory.coverImgUrl, localMessageForQQStory.mVid, localMessageForQQStory.uniseq, false);
        localafuf.jdField_a_of_type_ComTencentMobileqqActivityAioItemQQStoryItemBuilder$StoryChatVideoView.setTag(Long.valueOf(localMessageForQQStory.uniseq));
      }
      else if (paramChatMessage != null)
      {
        b(localafuf, localMessageForQQStory.uniseq, paramChatMessage, false);
        c(localafuf, localMessageForQQStory.uniseq, paramChatMessage, false);
        continue;
        bool = false;
      }
    }
  }
  
  public bdlb[] a(View paramView)
  {
    bdkz localbdkz = new bdkz();
    paramView = aekt.a(paramView);
    boolean bool;
    if (bcid.a(paramView) == null) {
      bool = true;
    }
    for (;;)
    {
      localbdkz.a(2131366750, this.jdField_b_of_type_AndroidContentContext.getString(2131692835), 2130838677);
      a(paramView, localbdkz);
      if ((paramView.isSend()) && (paramView.extraflag != 32768) && (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(paramView))) {
        a(localbdkz, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, paramView);
      }
      a(localbdkz, paramView);
      b(paramView, localbdkz);
      try
      {
        paramView = (MessageForQQStory)paramView;
        paramView = bdds.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_AndroidContentContext, paramView.msgAction);
        a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, "press", paramView, bool);
        super.e(localbdkz, this.jdField_b_of_type_AndroidContentContext);
        return localbdkz.a();
        bool = false;
      }
      catch (Exception paramView)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.w("Q.qqstory.share", 2, "getMenuItem exp:", paramView);
          }
        }
      }
    }
  }
  
  public void b(afuf paramafuf)
  {
    for (;;)
    {
      try
      {
        paramafuf = (MessageForQQStory)paramafuf.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
        if (QLog.isColorLevel()) {
          QLog.d("Q.qqstory.share", 2, "QQStoryItemBuilder onSourceOnClick:" + paramafuf.toString());
        }
        if (bcid.a(paramafuf) == null)
        {
          bool = true;
          bdds.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_AndroidContentContext, paramafuf.srcAction).c();
          paramafuf = bdds.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_AndroidContentContext, paramafuf.msgAction);
          a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, "clk_tail", paramafuf, bool);
          return;
        }
      }
      catch (Exception paramafuf)
      {
        boolean bool;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.w("Q.qqstory.share", 2, "QQStoryItemBuilder onSourceOnClick exp:", paramafuf);
      }
      bool = false;
    }
  }
  
  public void b(afuf paramafuf, long paramLong, int paramInt1, int paramInt2, String paramString1, String paramString2)
  {
    paramString1 = a(paramInt1, paramInt2, paramLong, paramString1, paramString2);
    paramString2 = URLDrawable.URLDrawableOptions.obtain();
    paramString2.mExtraInfo = paramString1;
    paramString2.mLoadingDrawable = a(paramafuf, paramString1.mCoverUrl);
    paramString1 = URLDrawable.getDrawable(PAVideoView.a(paramLong), paramString2);
    paramafuf.jdField_a_of_type_ComTencentMobileqqActivityAioItemQQStoryItemBuilder$StoryChatVideoView.setImageDrawable(paramString1);
  }
  
  public void b(afuf paramafuf, long paramLong, StoryVideoItem paramStoryVideoItem, boolean paramBoolean)
  {
    wsv.c("QQStoryItemBuilder", "updateStoryPollLayout");
    String str = paramStoryVideoItem.getPollDescription();
    if (TextUtils.equals(str, (String)paramafuf.jdField_b_of_type_ComTencentMobileqqWidgetBubbleImageView.getTag()))
    {
      wsv.b("QQStoryItemBuilder", "updateStoryPollLayout no need refresh, it is already %s", str);
      return;
    }
    if (paramStoryVideoItem.isPollVideo())
    {
      PollContainerLayout localPollContainerLayout = new PollContainerLayout(this.jdField_b_of_type_AndroidContentContext);
      localPollContainerLayout.a(true);
      localPollContainerLayout.a(paramStoryVideoItem);
      FrameLayout localFrameLayout = new FrameLayout(this.jdField_b_of_type_AndroidContentContext);
      localFrameLayout.setLayoutParams(new ViewGroup.LayoutParams(this.c, this.d));
      localFrameLayout.addView(localPollContainerLayout, new FrameLayout.LayoutParams(-1, -1));
      localFrameLayout.measure(View.MeasureSpec.makeMeasureSpec(this.c, 1073741824), View.MeasureSpec.makeMeasureSpec(this.d, 1073741824));
      localFrameLayout.layout(0, 0, this.c, this.d);
      localPollContainerLayout.a(paramStoryVideoItem);
      paramStoryVideoItem = Bitmap.createBitmap(this.c, this.d, Bitmap.Config.ARGB_8888);
      localFrameLayout.draw(new Canvas(paramStoryVideoItem));
      paramafuf.jdField_b_of_type_ComTencentMobileqqWidgetBubbleImageView.setImageDrawable(new BitmapDrawable(this.jdField_b_of_type_AndroidContentContext.getResources(), paramStoryVideoItem));
      paramafuf.jdField_b_of_type_ComTencentMobileqqWidgetBubbleImageView.setVisibility(0);
    }
    for (;;)
    {
      paramafuf.jdField_b_of_type_ComTencentMobileqqWidgetBubbleImageView.setTag(str);
      return;
      paramafuf.jdField_b_of_type_ComTencentMobileqqWidgetBubbleImageView.setVisibility(4);
    }
  }
  
  protected boolean b(MessageRecord paramMessageRecord)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 2) {}
    while (NetConnInfoCenter.getServerTimeMillis() - paramMessageRecord.time * 1000L > ayzf.jdField_a_of_type_Long) {
      return false;
    }
    return bdee.h(this.jdField_b_of_type_AndroidContentContext);
  }
  
  public void c(afuf paramafuf, long paramLong, StoryVideoItem paramStoryVideoItem, boolean paramBoolean)
  {
    wsv.c("QQStoryItemBuilder", "updateStoryInteractLayout");
    String str = paramStoryVideoItem.getInteractDescription();
    if (TextUtils.equals(str, (String)paramafuf.jdField_c_of_type_ComTencentMobileqqWidgetBubbleImageView.getTag()))
    {
      wsv.b("QQStoryItemBuilder", "updateStoryInteractLayout no need refresh, it is already %s", str);
      return;
    }
    if (paramStoryVideoItem.isInteractVideo())
    {
      InteractContainerLayout localInteractContainerLayout = new InteractContainerLayout(this.jdField_b_of_type_AndroidContentContext);
      localInteractContainerLayout.a(paramStoryVideoItem);
      FrameLayout localFrameLayout = new FrameLayout(this.jdField_b_of_type_AndroidContentContext);
      localFrameLayout.setLayoutParams(new ViewGroup.LayoutParams(this.c, this.d));
      localFrameLayout.addView(localInteractContainerLayout, new FrameLayout.LayoutParams(-1, -1));
      localFrameLayout.measure(View.MeasureSpec.makeMeasureSpec(this.c, 1073741824), View.MeasureSpec.makeMeasureSpec(this.d, 1073741824));
      localFrameLayout.layout(0, 0, this.c, this.d);
      localInteractContainerLayout.a(paramStoryVideoItem);
      paramStoryVideoItem = Bitmap.createBitmap(this.c, this.d, Bitmap.Config.ARGB_8888);
      localFrameLayout.draw(new Canvas(paramStoryVideoItem));
      paramafuf.jdField_c_of_type_ComTencentMobileqqWidgetBubbleImageView.setImageDrawable(new BitmapDrawable(this.jdField_b_of_type_AndroidContentContext.getResources(), paramStoryVideoItem));
      paramafuf.jdField_c_of_type_ComTencentMobileqqWidgetBubbleImageView.setVisibility(0);
    }
    for (;;)
    {
      paramafuf.jdField_c_of_type_ComTencentMobileqqWidgetBubbleImageView.setTag(str);
      return;
      paramafuf.jdField_c_of_type_ComTencentMobileqqWidgetBubbleImageView.setVisibility(4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.QQStoryItemBuilder
 * JD-Core Version:    0.7.0.1
 */