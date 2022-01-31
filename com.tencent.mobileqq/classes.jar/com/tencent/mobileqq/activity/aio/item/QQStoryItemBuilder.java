package com.tencent.mobileqq.activity.aio.item;

import aanz;
import actj;
import acuj;
import acuo;
import acxj;
import adxm;
import adxn;
import adxo;
import adxp;
import adxq;
import adxr;
import adxs;
import ajya;
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
import aqbe;
import awzy;
import axeb;
import axfa;
import bajp;
import baxn;
import bbbt;
import bbdj;
import bbeg;
import bbex;
import bbfj;
import bbgu;
import bbmf;
import bbmh;
import bfnz;
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
import sun;
import sut;
import tcw;
import tcz;
import tem;
import tsr;
import ved;
import vei;

public class QQStoryItemBuilder
  extends BaseBubbleBuilder
{
  public adxr a;
  protected Drawable a;
  public View.OnClickListener a;
  private StoryVideoItem a;
  protected String a;
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
  protected int h;
  
  public QQStoryItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    this.jdField_b_of_type_Float = 15.0F;
    this.jdField_a_of_type_Sun = new sun();
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new adxm(this);
    this.jdField_a_of_type_Adxr = new adxp(this);
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
    this.jdField_a_of_type_Sun.a(this.jdField_a_of_type_Adxr);
    axfa.a();
    paramQQAppInterface = (acuo)paramQQAppInterface.getManager(282);
    if (paramQQAppInterface != null) {
      paramQQAppInterface.a(3, 5);
    }
  }
  
  private Drawable a(adxs paramadxs, String paramString)
  {
    a(paramadxs, paramString);
    Object localObject2;
    if ((paramadxs.jdField_a_of_type_ComTencentImageURLDrawable != null) && ((paramadxs.jdField_a_of_type_ComTencentImageURLDrawable instanceof URLDrawable)))
    {
      localObject1 = paramadxs.jdField_a_of_type_ComTencentImageURLDrawable.getCurrDrawable();
      if ((localObject1 != null) && ((localObject1 instanceof RegionDrawable)))
      {
        localObject1 = ((RegionDrawable)localObject1).getBitmap();
        if ((localObject1 == null) || (((Bitmap)localObject1).isRecycled())) {
          break label226;
        }
        localObject2 = new BitmapDrawable((Bitmap)localObject1);
        localObject1 = localObject2;
        if (QLog.isColorLevel()) {
          QLog.e("QQStoryItemBuilder", 2, "getBitmapDrawable(): find bitmap drawable coverUrl=" + paramString + " holder=" + paramadxs.hashCode());
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
          QLog.e("QQStoryItemBuilder", 2, "getBitmapDrawable(): use loading drawable coverUrl=" + paramString + " holder=" + paramadxs.hashCode());
          localObject2 = localObject1;
        }
      }
      return localObject2;
      if (QLog.isColorLevel()) {
        QLog.e("QQStoryItemBuilder", 2, "getBitmapDrawable(): not find reginDrawable coverUrl=" + paramString + " holder=" + paramadxs.hashCode());
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
    tem localtem = paramStoryVideoItem.getVideoGameInfo();
    if (localtem != null)
    {
      this.jdField_a_of_type_JavaLangString = localtem.jdField_a_of_type_JavaLangString;
      if (!paramStoryVideoItem.isMine()) {
        break label45;
      }
      if (localtem.jdField_a_of_type_Int != 1) {
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
    if (localtem.jdField_a_of_type_Int == 1) {}
    for (i = 2;; i = 4)
    {
      this.h = i;
      return;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, int paramInt, String paramString, bbeg parambbeg, boolean paramBoolean)
  {
    int i = 3;
    if (paramInt == 0) {
      i = 1;
    }
    for (;;)
    {
      if (parambbeg != null) {}
      for (;;)
      {
        try
        {
          str = parambbeg.b("unionid");
          paramQQAppInterface = parambbeg.b("storyid");
        }
        catch (Exception paramQQAppInterface)
        {
          if (!QLog.isColorLevel()) {
            break;
          }
        }
        try
        {
          paramInt = Integer.valueOf(parambbeg.b("contentType")).intValue();
          parambbeg = str;
        }
        catch (Exception parambbeg)
        {
          paramInt = -1;
          parambbeg = str;
          continue;
        }
        if (paramBoolean)
        {
          str = "1";
          vei.a("share_obj", paramString, i, paramInt, new String[] { parambbeg, paramQQAppInterface, str, "" });
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("Q.qqstory.share", 2, "reportClickEvent: opName=" + paramString + ", fromType=" + i + ", result=" + paramInt + ", extra1=" + parambbeg + ", extra2=" + paramQQAppInterface + ", extra3=" + str);
          return;
        }
        str = "2";
        continue;
        QLog.w("Q.qqstory.share", 2, "reportClickEvent exp:", paramQQAppInterface);
        return;
        paramInt = -1;
        parambbeg = "";
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
  
  public acuj a()
  {
    return new adxs();
  }
  
  public View a(int paramInt1, int paramInt2, ChatMessage paramChatMessage, View paramView, ViewGroup paramViewGroup, acxj paramacxj)
  {
    paramView = (ViewGroup)super.a(paramInt1, paramInt2, paramChatMessage, paramView, paramViewGroup, paramacxj);
    a(paramView, paramChatMessage);
    return paramView;
  }
  
  public View a(ChatMessage paramChatMessage, acuj paramacuj, View paramView, BaseChatItemLayout paramBaseChatItemLayout, acxj paramacxj)
  {
    adxs localadxs = (adxs)paramacuj;
    boolean bool = paramChatMessage.isSend();
    paramacuj = paramView;
    int j;
    if (paramView == null)
    {
      paramacuj = LayoutInflater.from(this.jdField_b_of_type_AndroidContentContext).inflate(2131558747, paramBaseChatItemLayout, false);
      localadxs.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramacuj.findViewById(2131364109));
      localadxs.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localadxs.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131363410));
      localadxs.jdField_b_of_type_AndroidWidgetTextView = ((TextView)localadxs.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131370916));
      localadxs.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localadxs.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131369581));
      localadxs.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)localadxs.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131369812));
      localadxs.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)localadxs.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131366920));
      localadxs.d = ((TextView)localadxs.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131366939));
      localadxs.e = ((TextView)localadxs.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131366911));
      localadxs.jdField_a_of_type_ComTencentBizQqstoryViewWidgetAutoStartProgressBar = ((AutoStartProgressBar)localadxs.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131379024));
      localadxs.jdField_a_of_type_ComTencentBizQqstoryViewWidgetAutoStartProgressBar.setSharpCornerCor(BubbleImageView.jdField_a_of_type_ArrayOfFloat);
      localadxs.jdField_a_of_type_ComTencentMobileqqActivityAioItemQQStoryItemBuilder$StoryChatVideoView = new QQStoryItemBuilder.StoryChatVideoView(this.jdField_b_of_type_AndroidContentContext);
      paramView = new RelativeLayout.LayoutParams(this.c, this.d);
      localadxs.jdField_a_of_type_ComTencentMobileqqActivityAioItemQQStoryItemBuilder$StoryChatVideoView.setLayoutParams(paramView);
      localadxs.jdField_a_of_type_ComTencentMobileqqActivityAioItemQQStoryItemBuilder$StoryChatVideoView.c(false);
      localadxs.jdField_a_of_type_ComTencentMobileqqActivityAioItemQQStoryItemBuilder$StoryChatVideoView.setRadius(15.0F);
      localadxs.jdField_a_of_type_ComTencentMobileqqActivityAioItemQQStoryItemBuilder$StoryChatVideoView.setScaleType(ImageView.ScaleType.CENTER_CROP);
      localadxs.jdField_a_of_type_ComTencentMobileqqActivityAioItemQQStoryItemBuilder$StoryChatVideoView.d(true);
      localadxs.jdField_a_of_type_ComTencentMobileqqActivityAioItemQQStoryItemBuilder$StoryChatVideoView.setFocusable(false);
      localadxs.jdField_a_of_type_ComTencentMobileqqActivityAioItemQQStoryItemBuilder$StoryChatVideoView.setFocusableInTouchMode(false);
      localadxs.jdField_a_of_type_ComTencentMobileqqActivityAioItemQQStoryItemBuilder$StoryChatVideoView.setClickable(false);
      localadxs.jdField_a_of_type_ComTencentMobileqqActivityAioItemQQStoryItemBuilder$StoryChatVideoView.setSharpCornerCor(BubbleImageView.jdField_a_of_type_ArrayOfFloat);
      localadxs.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(localadxs.jdField_a_of_type_ComTencentMobileqqActivityAioItemQQStoryItemBuilder$StoryChatVideoView, 0);
      localadxs.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView = new BubbleImageView(this.jdField_b_of_type_AndroidContentContext);
      paramView = new RelativeLayout.LayoutParams(this.c, this.d);
      localadxs.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setLayoutParams(paramView);
      localadxs.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.c(false);
      localadxs.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setRadius(15.0F);
      localadxs.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
      localadxs.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.d(true);
      localadxs.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setFocusable(false);
      localadxs.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setFocusableInTouchMode(false);
      localadxs.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setClickable(false);
      localadxs.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setSharpCornerCor(BubbleImageView.jdField_a_of_type_ArrayOfFloat);
      localadxs.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(localadxs.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView, 1);
      localadxs.jdField_b_of_type_ComTencentMobileqqWidgetBubbleImageView = new BubbleImageView(this.jdField_b_of_type_AndroidContentContext);
      localadxs.jdField_b_of_type_ComTencentMobileqqWidgetBubbleImageView.setLayoutParams(new RelativeLayout.LayoutParams(this.c, this.d));
      localadxs.jdField_b_of_type_ComTencentMobileqqWidgetBubbleImageView.c(false);
      localadxs.jdField_b_of_type_ComTencentMobileqqWidgetBubbleImageView.setRadius(15.0F);
      localadxs.jdField_b_of_type_ComTencentMobileqqWidgetBubbleImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
      localadxs.jdField_b_of_type_ComTencentMobileqqWidgetBubbleImageView.d(true);
      localadxs.jdField_b_of_type_ComTencentMobileqqWidgetBubbleImageView.setFocusable(false);
      localadxs.jdField_b_of_type_ComTencentMobileqqWidgetBubbleImageView.setFocusableInTouchMode(false);
      localadxs.jdField_b_of_type_ComTencentMobileqqWidgetBubbleImageView.setClickable(false);
      localadxs.jdField_b_of_type_ComTencentMobileqqWidgetBubbleImageView.setVisibility(4);
      localadxs.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(localadxs.jdField_b_of_type_ComTencentMobileqqWidgetBubbleImageView, 2);
      localadxs.jdField_c_of_type_ComTencentMobileqqWidgetBubbleImageView = new BubbleImageView(this.jdField_b_of_type_AndroidContentContext);
      localadxs.jdField_c_of_type_ComTencentMobileqqWidgetBubbleImageView.setLayoutParams(new RelativeLayout.LayoutParams(this.c, this.d));
      localadxs.jdField_c_of_type_ComTencentMobileqqWidgetBubbleImageView.c(false);
      localadxs.jdField_c_of_type_ComTencentMobileqqWidgetBubbleImageView.setRadius(15.0F);
      localadxs.jdField_c_of_type_ComTencentMobileqqWidgetBubbleImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
      localadxs.jdField_c_of_type_ComTencentMobileqqWidgetBubbleImageView.d(true);
      localadxs.jdField_c_of_type_ComTencentMobileqqWidgetBubbleImageView.setFocusable(false);
      localadxs.jdField_c_of_type_ComTencentMobileqqWidgetBubbleImageView.setFocusableInTouchMode(false);
      localadxs.jdField_c_of_type_ComTencentMobileqqWidgetBubbleImageView.setClickable(false);
      localadxs.jdField_c_of_type_ComTencentMobileqqWidgetBubbleImageView.setVisibility(4);
      localadxs.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(localadxs.jdField_c_of_type_ComTencentMobileqqWidgetBubbleImageView, 2);
      paramView = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[] { 536870912, 0 });
      paramView.setShape(0);
      float f1 = baxn.a(this.jdField_b_of_type_AndroidContentContext, 15.0F);
      paramView.setCornerRadii(new float[] { f1, f1, f1, f1, 0.0F, 0.0F, 0.0F, 0.0F });
      paramView.setGradientType(0);
      localadxs.jdField_b_of_type_AndroidWidgetImageView.setBackgroundDrawable(paramView);
      localadxs.jdField_a_of_type_ComTencentBizQqstoryViewWidgetAutoStartProgressBar.setRadius(15.0F, true);
      localadxs.jdField_a_of_type_ComTencentBizQqstoryViewWidgetAutoStartProgressBar.setShowCorner(true);
      localadxs.jdField_a_of_type_ComTencentBizQqstoryViewWidgetAutoStartProgressBar.setDrawStatus(1);
      paramacuj.setOnLongClickListener(paramacxj);
      paramacuj.setOnTouchListener(paramacxj);
      localadxs.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      i = this.jdField_b_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131296294);
      j = this.c;
      int k = BaseChatItemLayout.j;
      int m = this.d;
      int n = BaseChatItemLayout.g;
      int i1 = this.g;
      paramView = (RelativeLayout.LayoutParams)localadxs.jdField_a_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
      paramView.width = (j + k + i);
      paramView.height = (i1 + (m + n));
      localadxs.jdField_a_of_type_AndroidWidgetRelativeLayout.setLayoutParams(paramView);
    }
    localadxs.jdField_a_of_type_ComTencentBizQqstoryViewWidgetAutoStartProgressBar.setKey(paramChatMessage.frienduin + paramChatMessage.uniseq);
    localadxs.jdField_a_of_type_ComTencentBizQqstoryViewWidgetAutoStartProgressBar.setCornerDirection(bool);
    if (localadxs.jdField_a_of_type_ComTencentMobileqqActivityAioItemQQStoryItemBuilder$StoryChatVideoView.d != bool)
    {
      localadxs.jdField_a_of_type_ComTencentMobileqqActivityAioItemQQStoryItemBuilder$StoryChatVideoView.d = bool;
      localadxs.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.d = bool;
      localadxs.jdField_b_of_type_ComTencentMobileqqWidgetBubbleImageView.d = bool;
      localadxs.jdField_c_of_type_ComTencentMobileqqWidgetBubbleImageView.d = bool;
      if (bfnz.e())
      {
        localadxs.jdField_a_of_type_ComTencentMobileqqActivityAioItemQQStoryItemBuilder$StoryChatVideoView.a(this.c, this.d);
        localadxs.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.a(this.c, this.d);
        localadxs.jdField_b_of_type_ComTencentMobileqqWidgetBubbleImageView.a(this.c, this.d);
        localadxs.jdField_c_of_type_ComTencentMobileqqWidgetBubbleImageView.a(this.c, this.d);
      }
      localadxs.jdField_a_of_type_ComTencentMobileqqActivityAioItemQQStoryItemBuilder$StoryChatVideoView.invalidate();
      localadxs.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.invalidate();
      localadxs.jdField_b_of_type_ComTencentMobileqqWidgetBubbleImageView.invalidate();
      localadxs.jdField_c_of_type_ComTencentMobileqqWidgetBubbleImageView.invalidate();
    }
    int i = baxn.a(this.jdField_b_of_type_AndroidContentContext, localadxs.jdField_a_of_type_ComTencentMobileqqActivityAioItemQQStoryItemBuilder$StoryChatVideoView.a);
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
      paramView = (RelativeLayout.LayoutParams)localadxs.jdField_a_of_type_AndroidViewViewGroup.getLayoutParams();
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
      paramView.height = baxn.a(this.jdField_b_of_type_AndroidContentContext, 42.0F);
      localadxs.jdField_a_of_type_AndroidViewViewGroup.setLayoutParams(paramView);
      localadxs.jdField_a_of_type_AndroidViewViewGroup.setVisibility(0);
      if ((GradientDrawable)localadxs.jdField_a_of_type_AndroidViewViewGroup.getBackground() == null)
      {
        paramView = new GradientDrawable();
        paramView.setCornerRadii(this.jdField_a_of_type_ArrayOfFloat);
        paramView.setColor(1929379840);
        localadxs.jdField_a_of_type_AndroidViewViewGroup.setBackgroundDrawable(paramView);
      }
      localadxs.d.setText(paramChatMessage.storyTitle);
      localadxs.e.setText(paramChatMessage.storyBrief);
    }
    for (;;)
    {
      if (bool) {
        break label1552;
      }
      paramChatMessage = (RelativeLayout.LayoutParams)localadxs.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams();
      paramChatMessage.leftMargin = i;
      paramChatMessage.rightMargin = 0;
      localadxs.jdField_a_of_type_AndroidWidgetTextView.setLayoutParams(paramChatMessage);
      paramChatMessage = (RelativeLayout.LayoutParams)localadxs.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
      paramChatMessage.leftMargin = baxn.a(this.jdField_b_of_type_AndroidContentContext, localadxs.jdField_a_of_type_ComTencentMobileqqActivityAioItemQQStoryItemBuilder$StoryChatVideoView.a + 10);
      paramChatMessage.rightMargin = baxn.a(this.jdField_b_of_type_AndroidContentContext, 10);
      localadxs.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams(paramChatMessage);
      paramChatMessage = (RelativeLayout.LayoutParams)localadxs.jdField_b_of_type_AndroidWidgetImageView.getLayoutParams();
      paramChatMessage.leftMargin = i;
      paramChatMessage.rightMargin = 0;
      localadxs.jdField_b_of_type_AndroidWidgetImageView.setLayoutParams(paramChatMessage);
      return paramacuj;
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
      localadxs.jdField_a_of_type_AndroidViewViewGroup.setVisibility(8);
    }
    label1552:
    paramChatMessage = (RelativeLayout.LayoutParams)localadxs.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams();
    paramChatMessage.leftMargin = 0;
    paramChatMessage.rightMargin = i;
    localadxs.jdField_a_of_type_AndroidWidgetTextView.setLayoutParams(paramChatMessage);
    paramChatMessage = (RelativeLayout.LayoutParams)localadxs.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
    paramChatMessage.leftMargin = baxn.a(this.jdField_b_of_type_AndroidContentContext, 10);
    paramChatMessage.rightMargin = baxn.a(this.jdField_b_of_type_AndroidContentContext, localadxs.jdField_a_of_type_ComTencentMobileqqActivityAioItemQQStoryItemBuilder$StoryChatVideoView.a + 10);
    localadxs.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams(paramChatMessage);
    paramChatMessage = (RelativeLayout.LayoutParams)localadxs.jdField_b_of_type_AndroidWidgetImageView.getLayoutParams();
    paramChatMessage.leftMargin = 0;
    paramChatMessage.rightMargin = i;
    localadxs.jdField_b_of_type_AndroidWidgetImageView.setLayoutParams(paramChatMessage);
    return paramacuj;
  }
  
  public String a(ChatMessage paramChatMessage)
  {
    return paramChatMessage.getSummaryMsg();
  }
  
  public void a()
  {
    this.jdField_a_of_type_Sun.a();
    if (this.jdField_f_of_type_Boolean)
    {
      ((sut)tcz.a(6)).a(15000L);
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
            if (bajp.a(paramChatMessage) == null) {
              bool = true;
            }
            for (;;)
            {
              Object localObject2 = null;
              try
              {
                localObject1 = bbex.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_AndroidContentContext, localMessageForQQStory.msgAction);
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
                aanz.b(this.jdField_b_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
                a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, "delete", (bbeg)localObject1, bool);
                if (localMessageForQQStory.type == 3) {
                  vei.a("mystory", "delete_obj_myday", 0, 0, new String[] { "", "", "", "" });
                }
              }
            }
          } while (localMessageForQQStory.type != 1);
          vei.a("mystory", "delete_obj", 0, 0, new String[] { "", "", "", "" });
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
          aqbe.a((Activity)this.jdField_b_of_type_AndroidContentContext, paramChatMessage, 21);
          a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, "forward", (bbeg)localObject1, bool);
          if (localMessageForQQStory.type == 3) {
            vei.a("mystory", "forward_obj_myday", 0, 0, new String[] { "", "", "", "" });
          }
        } while (localMessageForQQStory.type != 1);
        vei.a("mystory", "forward_obj", 0, 0, new String[] { "", "", "", "" });
        return;
        super.a(paramChatMessage);
        a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, "withdraw", (bbeg)localObject1, bool);
        if (localMessageForQQStory.type == 3) {
          vei.a("mystory", "withdraw_obj_myday", 0, 0, new String[] { "", "", "", "" });
        }
      } while (localMessageForQQStory.type != 1);
      vei.a("mystory", "withdraw_obj", 0, 0, new String[] { "", "", "", "" });
      return;
      super.a(paramInt, paramContext, paramChatMessage);
      a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, "reply", (bbeg)localObject1, bool);
      if (localMessageForQQStory.type == 1)
      {
        vei.a("mystory", "reply_obj", 0, 0, new String[] { "", "", "", "" });
        return;
      }
    } while (localMessageForQQStory.type != 2);
    vei.a("ugc_video", "obj_reply", 0, 0, new String[] { "", "", "", "" });
  }
  
  public void a(adxs paramadxs)
  {
    boolean bool = true;
    for (;;)
    {
      try
      {
        paramadxs = (MessageForQQStory)paramadxs.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
        if (QLog.isColorLevel()) {
          QLog.d("Q.qqstory.share", 2, "QQStoryItemBuilder onBubbleOnClick:" + paramadxs.toString());
        }
        if (bajp.a(paramadxs) == null)
        {
          paramadxs = bbex.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_AndroidContentContext, paramadxs.msgAction);
          paramadxs.c();
          a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, "clk_play", paramadxs, bool);
          int i = this.h;
          String str = this.jdField_a_of_type_JavaLangString;
          if (this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem == null)
          {
            paramadxs = "";
            vei.a("video_game", "clk_gamevideo", 0, 0, new String[] { String.valueOf(i), "", str, paramadxs });
            return;
          }
          paramadxs = this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVid;
          continue;
        }
        bool = false;
      }
      catch (Exception paramadxs)
      {
        if (QLog.isColorLevel()) {
          QLog.w("Q.qqstory.share", 2, "QQStoryItemBuilder onBubbleOnClick exp:", paramadxs);
        }
        return;
      }
    }
  }
  
  public void a(adxs paramadxs, long paramLong)
  {
    ((Activity)this.jdField_b_of_type_AndroidContentContext).runOnUiThread(new QQStoryItemBuilder.10(this, paramadxs, paramLong));
  }
  
  public void a(adxs paramadxs, long paramLong, int paramInt1, int paramInt2, String paramString1, String paramString2)
  {
    b(paramadxs, paramLong, paramInt1, paramInt2, paramString1, paramString2);
    if (!bbbt.a().a(paramadxs.jdField_a_of_type_ComTencentMobileqqDataChatMessage, "share|auto_play"))
    {
      bbbt.a().a(paramadxs.jdField_a_of_type_ComTencentMobileqqDataChatMessage, "share|auto_play");
      if (!(paramadxs.jdField_a_of_type_ComTencentMobileqqDataChatMessage instanceof MessageForQQStory)) {
        break label188;
      }
      paramInt1 = ((MessageForQQStory)paramadxs.jdField_a_of_type_ComTencentMobileqqDataChatMessage).type;
      if (paramInt1 != 1) {
        break label91;
      }
      paramInt1 = 1;
    }
    label188:
    for (;;)
    {
      vei.a("share", "auto_play", paramInt1, 0, new String[0]);
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
  
  public void a(adxs paramadxs, long paramLong, StoryVideoItem paramStoryVideoItem, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem = paramStoryVideoItem;
    boolean bool = StoryVideoItem.isPlayable(paramStoryVideoItem.mVid, true);
    if (QLog.isColorLevel()) {
      QLog.i("QQStoryItemBuilder", 2, "handleGetVideo: isPlayable =" + bool);
    }
    Object localObject;
    if (!bool) {
      if ((b(paramadxs.jdField_a_of_type_ComTencentMobileqqDataChatMessage)) || (paramBoolean))
      {
        ((Activity)this.jdField_b_of_type_AndroidContentContext).runOnUiThread(new QQStoryItemBuilder.5(this, paramadxs));
        if (QLog.isColorLevel()) {
          QLog.d("Q.qqstory.share", 2, "QQStoryItemBuilder handleGetVideo 1: wifi download");
        }
        localObject = new ArrayList();
        ((ArrayList)localObject).add(paramStoryVideoItem);
        this.jdField_a_of_type_Sun.a((List)localObject);
        this.jdField_a_of_type_Sun.a(paramStoryVideoItem.mVid);
        this.jdField_a_of_type_Adxr.a(paramadxs, paramStoryVideoItem.mVid, paramLong);
      }
    }
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqstory.share", 2, "QQStoryItemBuilder handleGetVideo 2: no wifi");
      }
      ((Activity)this.jdField_b_of_type_AndroidContentContext).runOnUiThread(new QQStoryItemBuilder.6(this, paramadxs, paramLong, paramStoryVideoItem));
      return;
      String str = this.jdField_a_of_type_Sun.a(paramStoryVideoItem.mVid);
      localObject = str;
      if (str != null)
      {
        localObject = str;
        if (str.startsWith("file://")) {
          localObject = str.substring(7);
        }
      }
    } while (!(this.jdField_b_of_type_AndroidContentContext instanceof Activity));
    ((Activity)this.jdField_b_of_type_AndroidContentContext).runOnUiThread(new QQStoryItemBuilder.7(this, (String)localObject, paramadxs, paramStoryVideoItem, paramLong, paramBoolean));
  }
  
  protected void a(adxs paramadxs, ViewGroup paramViewGroup, boolean paramBoolean)
  {
    paramadxs.jdField_a_of_type_AndroidWidgetFrameLayout = new FrameLayout(this.jdField_b_of_type_AndroidContentContext);
    Object localObject = new TextView(this.jdField_b_of_type_AndroidContentContext);
    ((TextView)localObject).setBackgroundResource(2130842092);
    ((TextView)localObject).setTextSize(1, 12.0F);
    ((TextView)localObject).setTextColor(this.jdField_b_of_type_AndroidContentContext.getResources().getColor(2131167134));
    ((TextView)localObject).setIncludeFontPadding(false);
    ((TextView)localObject).setSingleLine();
    ((TextView)localObject).setGravity(16);
    ((TextView)localObject).setPadding(baxn.a(this.jdField_b_of_type_AndroidContentContext, 5.0F), 0, baxn.a(this.jdField_b_of_type_AndroidContentContext, 5.0F), 0);
    paramadxs.jdField_a_of_type_AndroidWidgetFrameLayout.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-2, -2);
    paramadxs.jdField_a_of_type_AndroidWidgetFrameLayout.addView((View)localObject, localLayoutParams);
    paramadxs.jdField_c_of_type_AndroidWidgetTextView = ((TextView)localObject);
    localObject = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject).addRule(3, 2131364109);
    ((RelativeLayout.LayoutParams)localObject).addRule(5, 2131364109);
    paramViewGroup.addView(paramadxs.jdField_a_of_type_AndroidWidgetFrameLayout, (ViewGroup.LayoutParams)localObject);
  }
  
  public void a(adxs paramadxs, String paramString)
  {
    if ((!TextUtils.equals(paramString, paramadxs.jdField_b_of_type_JavaLangString)) || (paramadxs.jdField_a_of_type_ComTencentImageURLDrawable == null))
    {
      paramadxs.jdField_b_of_type_JavaLangString = paramString;
      paramadxs.jdField_a_of_type_ComTencentImageURLDrawable = null;
      if (TextUtils.isEmpty(paramString)) {}
    }
    while (!QLog.isColorLevel()) {
      try
      {
        paramadxs.jdField_a_of_type_ComTencentImageURLDrawable = URLDrawable.getDrawable(paramString, PAVideoView.a, PAVideoView.a);
        if (QLog.isColorLevel()) {
          QLog.e("QQStoryItemBuilder", 2, "checkCoverDrawable(): reload drawable, coverUrl=" + paramString + " holder=" + paramadxs.hashCode());
        }
        return;
      }
      catch (Exception localException)
      {
        while (!QLog.isColorLevel()) {}
        QLog.e("QQStoryItemBuilder", 2, "checkCoverDrawable():  getDrawable Exception, coverUrl=" + paramString + " holder=" + paramadxs.hashCode(), localException);
        return;
      }
    }
    QLog.e("QQStoryItemBuilder", 2, "checkCoverDrawable(): reuse drawable, coverUrl=" + paramString + " holder=" + paramadxs.hashCode());
  }
  
  public void a(adxs paramadxs, String paramString, long paramLong, boolean paramBoolean)
  {
    tsr.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString, new adxq(this, paramadxs, paramLong, paramBoolean));
  }
  
  public void a(adxs paramadxs, String paramString1, String paramString2, long paramLong, boolean paramBoolean)
  {
    ved.a("QQStoryItemBuilder", "setVideoView %s vid %s", paramString1, paramString2);
    ThreadManager.post(new QQStoryItemBuilder.8(this, paramString2, paramadxs, paramLong, paramString1, paramBoolean), 8, null, true);
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    Object localObject = actj.a(paramView);
    if (!adxs.class.isInstance(localObject)) {}
    String str1;
    String str2;
    do
    {
      return;
      paramView = this.jdField_b_of_type_AndroidContentContext;
      localObject = ((adxs)localObject).jdField_a_of_type_ComTencentMobileqqDataChatMessage;
      str1 = paramView.getString(2131689995);
      str2 = paramView.getString(2131689996);
    } while (!((ChatMessage)localObject).isSendFromLocal());
    bbdj.a(paramView, 230, str1, str2, new adxn(this, paramView, (ChatMessage)localObject), new adxo(this)).show();
  }
  
  public void a(View paramView, ChatMessage paramChatMessage)
  {
    int i = this.jdField_b_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131296294);
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
    adxs localadxs = (adxs)paramViewGroup.getTag();
    boolean bool = localMessageForQQStory.isSend();
    if (localadxs.jdField_a_of_type_AndroidWidgetFrameLayout == null) {
      a(localadxs, paramViewGroup, bool);
    }
    paramViewGroup = (FrameLayout.LayoutParams)localadxs.jdField_c_of_type_AndroidWidgetTextView.getLayoutParams();
    if (bool)
    {
      paramViewGroup.leftMargin = BaseChatItemLayout.j;
      localadxs.jdField_c_of_type_AndroidWidgetTextView.setLayoutParams(paramViewGroup);
      localadxs.jdField_a_of_type_AndroidWidgetTextView.setText(localMessageForQQStory.brief);
      localadxs.jdField_c_of_type_AndroidWidgetTextView.setText(localMessageForQQStory.srcName);
      if ((localMessageForQQStory.type != 3) && (localMessageForQQStory.type != 5) && (localMessageForQQStory.type != 8) && (localMessageForQQStory.type != 9)) {
        break label346;
      }
      localadxs.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      localadxs.jdField_b_of_type_AndroidWidgetTextView.setText(ajya.a(2131710913));
      label161:
      localadxs.jdField_a_of_type_ComTencentBizQqstoryViewWidgetAutoStartProgressBar.setCornerDirection(paramChatMessage.isSend());
      if ((!TextUtils.isEmpty(localMessageForQQStory.mVid)) && (axfa.b)) {
        break label422;
      }
      localadxs.jdField_a_of_type_Boolean = false;
      localadxs.jdField_a_of_type_ComTencentBizQqstoryViewWidgetAutoStartProgressBar.setDrawStatus(2);
      localadxs.jdField_a_of_type_ComTencentBizQqstoryViewWidgetAutoStartProgressBar.setVisibility(0);
      a(localadxs.jdField_a_of_type_ComTencentMobileqqActivityAioItemQQStoryItemBuilder$StoryChatVideoView, localMessageForQQStory.coverImgUrl, this.c, this.d, this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
      a(localadxs.jdField_a_of_type_AndroidWidgetImageView, localMessageForQQStory.logoImgUrl, this.e, this.jdField_f_of_type_Int, this.jdField_b_of_type_AndroidGraphicsDrawableDrawable);
      localadxs.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setImageDrawable(null);
    }
    for (;;)
    {
      try
      {
        paramViewGroup = bbex.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_AndroidContentContext, localMessageForQQStory.msgAction);
        if (bajp.a(localMessageForQQStory) != null) {
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
      paramViewGroup.leftMargin = (baxn.a(this.jdField_b_of_type_AndroidContentContext, localadxs.jdField_a_of_type_ComTencentMobileqqActivityAioItemQQStoryItemBuilder$StoryChatVideoView.a) + BaseChatItemLayout.i);
      break;
      if (localMessageForQQStory.type == 11)
      {
        localadxs.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
        if (!TextUtils.isEmpty(localMessageForQQStory.mHeadTip))
        {
          localadxs.jdField_b_of_type_AndroidWidgetTextView.setText(localMessageForQQStory.mHeadTip);
          break label161;
        }
        localadxs.jdField_b_of_type_AndroidWidgetTextView.setText(ajya.a(2131710912));
        break label161;
      }
      localadxs.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      break label161;
      paramViewGroup = (Long)localadxs.jdField_a_of_type_ComTencentMobileqqActivityAioItemQQStoryItemBuilder$StoryChatVideoView.getTag();
      paramChatMessage = ((tcw)tcz.a(5)).a(localMessageForQQStory.mVid);
      if ((paramViewGroup == null) || (paramViewGroup.longValue() != localMessageForQQStory.uniseq))
      {
        localadxs.jdField_a_of_type_Boolean = false;
        localadxs.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setImageDrawable(null);
        a(localadxs.jdField_a_of_type_ComTencentMobileqqActivityAioItemQQStoryItemBuilder$StoryChatVideoView, localMessageForQQStory.coverImgUrl, this.c, this.d, this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
        if (paramChatMessage != null)
        {
          b(localadxs, localMessageForQQStory.uniseq, paramChatMessage, false);
          c(localadxs, localMessageForQQStory.uniseq, paramChatMessage, false);
        }
        a(localadxs, localMessageForQQStory.coverImgUrl, localMessageForQQStory.mVid, localMessageForQQStory.uniseq, false);
        localadxs.jdField_a_of_type_ComTencentMobileqqActivityAioItemQQStoryItemBuilder$StoryChatVideoView.setTag(Long.valueOf(localMessageForQQStory.uniseq));
      }
      else if (paramChatMessage != null)
      {
        b(localadxs, localMessageForQQStory.uniseq, paramChatMessage, false);
        c(localadxs, localMessageForQQStory.uniseq, paramChatMessage, false);
        continue;
        bool = false;
      }
    }
  }
  
  public bbmh[] a(View paramView)
  {
    bbmf localbbmf = new bbmf();
    paramView = actj.a(paramView);
    boolean bool;
    if (bajp.a(paramView) == null) {
      bool = true;
    }
    for (;;)
    {
      localbbmf.a(2131366632, this.jdField_b_of_type_AndroidContentContext.getString(2131692753), 2130838606);
      a(paramView, localbbmf);
      if ((paramView.isSend()) && (paramView.extraflag != 32768) && (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(paramView))) {
        a(localbbmf, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, paramView);
      }
      a(localbbmf, paramView);
      b(paramView, localbbmf);
      try
      {
        paramView = (MessageForQQStory)paramView;
        paramView = bbex.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_AndroidContentContext, paramView.msgAction);
        a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, "press", paramView, bool);
        super.e(localbbmf, this.jdField_b_of_type_AndroidContentContext);
        return localbbmf.a();
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
  
  public void b(adxs paramadxs)
  {
    for (;;)
    {
      try
      {
        paramadxs = (MessageForQQStory)paramadxs.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
        if (QLog.isColorLevel()) {
          QLog.d("Q.qqstory.share", 2, "QQStoryItemBuilder onSourceOnClick:" + paramadxs.toString());
        }
        if (bajp.a(paramadxs) == null)
        {
          bool = true;
          bbex.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_AndroidContentContext, paramadxs.srcAction).c();
          paramadxs = bbex.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_AndroidContentContext, paramadxs.msgAction);
          a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, "clk_tail", paramadxs, bool);
          return;
        }
      }
      catch (Exception paramadxs)
      {
        boolean bool;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.w("Q.qqstory.share", 2, "QQStoryItemBuilder onSourceOnClick exp:", paramadxs);
      }
      bool = false;
    }
  }
  
  public void b(adxs paramadxs, long paramLong, int paramInt1, int paramInt2, String paramString1, String paramString2)
  {
    paramString1 = a(paramInt1, paramInt2, paramLong, paramString1, paramString2);
    paramString2 = URLDrawable.URLDrawableOptions.obtain();
    paramString2.mExtraInfo = paramString1;
    paramString2.mLoadingDrawable = a(paramadxs, paramString1.mCoverUrl);
    paramString1 = URLDrawable.getDrawable(PAVideoView.a(paramLong), paramString2);
    paramadxs.jdField_a_of_type_ComTencentMobileqqActivityAioItemQQStoryItemBuilder$StoryChatVideoView.setImageDrawable(paramString1);
  }
  
  public void b(adxs paramadxs, long paramLong, StoryVideoItem paramStoryVideoItem, boolean paramBoolean)
  {
    ved.c("QQStoryItemBuilder", "updateStoryPollLayout");
    String str = paramStoryVideoItem.getPollDescription();
    if (TextUtils.equals(str, (String)paramadxs.jdField_b_of_type_ComTencentMobileqqWidgetBubbleImageView.getTag()))
    {
      ved.b("QQStoryItemBuilder", "updateStoryPollLayout no need refresh, it is already %s", str);
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
      paramadxs.jdField_b_of_type_ComTencentMobileqqWidgetBubbleImageView.setImageDrawable(new BitmapDrawable(this.jdField_b_of_type_AndroidContentContext.getResources(), paramStoryVideoItem));
      paramadxs.jdField_b_of_type_ComTencentMobileqqWidgetBubbleImageView.setVisibility(0);
    }
    for (;;)
    {
      paramadxs.jdField_b_of_type_ComTencentMobileqqWidgetBubbleImageView.setTag(str);
      return;
      paramadxs.jdField_b_of_type_ComTencentMobileqqWidgetBubbleImageView.setVisibility(4);
    }
  }
  
  protected boolean b(MessageRecord paramMessageRecord)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 2) {}
    while (NetConnInfoCenter.getServerTimeMillis() - paramMessageRecord.time * 1000L > axeb.jdField_a_of_type_Long) {
      return false;
    }
    return bbfj.h(this.jdField_b_of_type_AndroidContentContext);
  }
  
  public void c(adxs paramadxs, long paramLong, StoryVideoItem paramStoryVideoItem, boolean paramBoolean)
  {
    ved.c("QQStoryItemBuilder", "updateStoryInteractLayout");
    String str = paramStoryVideoItem.getInteractDescription();
    if (TextUtils.equals(str, (String)paramadxs.jdField_c_of_type_ComTencentMobileqqWidgetBubbleImageView.getTag()))
    {
      ved.b("QQStoryItemBuilder", "updateStoryInteractLayout no need refresh, it is already %s", str);
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
      paramadxs.jdField_c_of_type_ComTencentMobileqqWidgetBubbleImageView.setImageDrawable(new BitmapDrawable(this.jdField_b_of_type_AndroidContentContext.getResources(), paramStoryVideoItem));
      paramadxs.jdField_c_of_type_ComTencentMobileqqWidgetBubbleImageView.setVisibility(0);
    }
    for (;;)
    {
      paramadxs.jdField_c_of_type_ComTencentMobileqqWidgetBubbleImageView.setTag(str);
      return;
      paramadxs.jdField_c_of_type_ComTencentMobileqqWidgetBubbleImageView.setVisibility(4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.QQStoryItemBuilder
 * JD-Core Version:    0.7.0.1
 */