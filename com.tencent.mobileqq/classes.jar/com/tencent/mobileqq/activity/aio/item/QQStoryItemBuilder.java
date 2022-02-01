package com.tencent.mobileqq.activity.aio.item;

import admh;
import afqr;
import afqy;
import aftk;
import aheh;
import ahei;
import ahej;
import ahek;
import ahel;
import ahem;
import ahen;
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
import anvx;
import aupt;
import bcrg;
import bcxj;
import bgiz;
import bhbz;
import bhdj;
import bheh;
import bhey;
import bhjq;
import bhjs;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.view.widget.AutoStartProgressBar;
import com.tencent.biz.qqstory.widget.InteractContainerLayout;
import com.tencent.biz.qqstory.widget.PollContainerLayout;
import com.tencent.image.QQLiveDrawable.QQLiveDrawableParams;
import com.tencent.image.RegionDrawable;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForQQStory;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils.ShortVideoPlayConfig;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.BubbleImageView;
import com.tencent.mobileqq.widget.PAVideoView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.VersionUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import wbp;
import wbv;
import wjp;
import wjs;
import wlf;
import wzk;
import ykq;
import ykv;

public class QQStoryItemBuilder
  extends BaseBubbleBuilder
{
  public ahem a;
  protected Drawable a;
  public View.OnClickListener a;
  private StoryVideoItem a;
  protected String a;
  protected wbp a;
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
    this.jdField_a_of_type_Wbp = new wbp();
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new aheh(this);
    this.jdField_a_of_type_Ahem = new ahek(this);
    this.jdField_b_of_type_AndroidContentContext = paramContext;
    float f1 = DisplayUtil.dip2px(this.jdField_b_of_type_AndroidContentContext, 15.0F);
    this.jdField_a_of_type_ArrayOfFloat = new float[] { 0.0F, 0.0F, 0.0F, 0.0F, f1, f1, f1, f1 };
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = new ColorDrawable(Color.parseColor("#e1e1e5"));
    this.jdField_b_of_type_AndroidGraphicsDrawableDrawable = new ColorDrawable(Color.parseColor("#00000000"));
    this.e = DisplayUtil.dip2px(this.jdField_b_of_type_AndroidContentContext, 135.0F);
    this.jdField_f_of_type_Int = DisplayUtil.dip2px(this.jdField_b_of_type_AndroidContentContext, 19.0F);
    this.c = DisplayUtil.dip2px(this.jdField_b_of_type_AndroidContentContext, 137.0F);
    this.d = DisplayUtil.dip2px(this.jdField_b_of_type_AndroidContentContext, 218.0F);
    this.g = DisplayUtil.dip2px(this.jdField_b_of_type_AndroidContentContext, 7.0F);
    paramBaseAdapter = (wbv)wjs.a(6);
    if (!paramBaseAdapter.a())
    {
      paramBaseAdapter.c();
      this.jdField_f_of_type_Boolean = true;
    }
    this.jdField_a_of_type_Wbp.a(this.jdField_a_of_type_Ahem);
    ShortVideoUtils.ShortVideoPlayConfig.initConfig();
    paramQQAppInterface = (afqy)paramQQAppInterface.getManager(QQManagerFactory.BEANCURD_MANAGER);
    if (paramQQAppInterface != null) {
      paramQQAppInterface.a(3, 5);
    }
  }
  
  private Drawable a(ahen paramahen, String paramString)
  {
    a(paramahen, paramString);
    Object localObject2;
    if ((paramahen.jdField_a_of_type_ComTencentImageURLDrawable != null) && ((paramahen.jdField_a_of_type_ComTencentImageURLDrawable instanceof URLDrawable)))
    {
      localObject1 = paramahen.jdField_a_of_type_ComTencentImageURLDrawable.getCurrDrawable();
      if ((localObject1 != null) && ((localObject1 instanceof RegionDrawable)))
      {
        localObject1 = ((RegionDrawable)localObject1).getBitmap();
        if ((localObject1 == null) || (((Bitmap)localObject1).isRecycled())) {
          break label226;
        }
        localObject2 = new BitmapDrawable((Bitmap)localObject1);
        localObject1 = localObject2;
        if (QLog.isColorLevel()) {
          QLog.e("QQStoryItemBuilder", 2, "getBitmapDrawable(): find bitmap drawable coverUrl=" + paramString + " holder=" + paramahen.hashCode());
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
          QLog.e("QQStoryItemBuilder", 2, "getBitmapDrawable(): use loading drawable coverUrl=" + paramString + " holder=" + paramahen.hashCode());
          localObject2 = localObject1;
        }
      }
      return localObject2;
      if (QLog.isColorLevel()) {
        QLog.e("QQStoryItemBuilder", 2, "getBitmapDrawable(): not find reginDrawable coverUrl=" + paramString + " holder=" + paramahen.hashCode());
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
    wlf localwlf = paramStoryVideoItem.getVideoGameInfo();
    if (localwlf != null)
    {
      this.jdField_a_of_type_JavaLangString = localwlf.jdField_a_of_type_JavaLangString;
      if (!paramStoryVideoItem.isMine()) {
        break label45;
      }
      if (localwlf.jdField_a_of_type_Int != 1) {
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
    if (localwlf.jdField_a_of_type_Int == 1) {}
    for (i = 2;; i = 4)
    {
      this.h = i;
      return;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, int paramInt, String paramString, bheh parambheh, boolean paramBoolean)
  {
    int i = 3;
    if (paramInt == 0) {
      i = 1;
    }
    for (;;)
    {
      if (parambheh != null) {}
      for (;;)
      {
        try
        {
          str = parambheh.b("unionid");
          paramQQAppInterface = parambheh.b("storyid");
        }
        catch (Exception paramQQAppInterface)
        {
          if (!QLog.isColorLevel()) {
            break;
          }
        }
        try
        {
          paramInt = Integer.valueOf(parambheh.b("contentType")).intValue();
          parambheh = str;
        }
        catch (Exception parambheh)
        {
          paramInt = -1;
          parambheh = str;
          continue;
        }
        if (paramBoolean)
        {
          str = "1";
          ykv.a("share_obj", paramString, i, paramInt, new String[] { parambheh, paramQQAppInterface, str, "" });
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("Q.qqstory.share", 2, "reportClickEvent: opName=" + paramString + ", fromType=" + i + ", result=" + paramInt + ", extra1=" + parambheh + ", extra2=" + paramQQAppInterface + ", extra3=" + str);
          return;
        }
        str = "2";
        continue;
        QLog.w("Q.qqstory.share", 2, "reportClickEvent exp:", paramQQAppInterface);
        return;
        paramInt = -1;
        parambheh = "";
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
  
  public afqr a()
  {
    return new ahen();
  }
  
  public View a(int paramInt1, int paramInt2, ChatMessage paramChatMessage, View paramView, ViewGroup paramViewGroup, aftk paramaftk)
  {
    paramView = (ViewGroup)super.a(paramInt1, paramInt2, paramChatMessage, paramView, paramViewGroup, paramaftk);
    a(paramView, paramChatMessage);
    return paramView;
  }
  
  public View a(ChatMessage paramChatMessage, afqr paramafqr, View paramView, BaseChatItemLayout paramBaseChatItemLayout, aftk paramaftk)
  {
    ahen localahen = (ahen)paramafqr;
    boolean bool = paramChatMessage.isSend();
    paramafqr = paramView;
    int j;
    if (paramView == null)
    {
      paramafqr = LayoutInflater.from(this.jdField_b_of_type_AndroidContentContext).inflate(2131558882, paramBaseChatItemLayout, false);
      localahen.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramafqr.findViewById(2131364522));
      localahen.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localahen.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131363771));
      localahen.jdField_b_of_type_AndroidWidgetTextView = ((TextView)localahen.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131372074));
      localahen.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localahen.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131370556));
      localahen.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)localahen.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131370793));
      localahen.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)localahen.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131367534));
      localahen.d = ((TextView)localahen.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131367560));
      localahen.e = ((TextView)localahen.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131367514));
      localahen.jdField_a_of_type_ComTencentBizQqstoryViewWidgetAutoStartProgressBar = ((AutoStartProgressBar)localahen.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131380957));
      localahen.jdField_a_of_type_ComTencentBizQqstoryViewWidgetAutoStartProgressBar.setSharpCornerCor(BubbleImageView.jdField_a_of_type_ArrayOfFloat);
      localahen.jdField_a_of_type_ComTencentMobileqqActivityAioItemQQStoryItemBuilder$StoryChatVideoView = new QQStoryItemBuilder.StoryChatVideoView(this.jdField_b_of_type_AndroidContentContext);
      paramView = new RelativeLayout.LayoutParams(this.c, this.d);
      localahen.jdField_a_of_type_ComTencentMobileqqActivityAioItemQQStoryItemBuilder$StoryChatVideoView.setLayoutParams(paramView);
      localahen.jdField_a_of_type_ComTencentMobileqqActivityAioItemQQStoryItemBuilder$StoryChatVideoView.c(false);
      localahen.jdField_a_of_type_ComTencentMobileqqActivityAioItemQQStoryItemBuilder$StoryChatVideoView.setRadius(15.0F);
      localahen.jdField_a_of_type_ComTencentMobileqqActivityAioItemQQStoryItemBuilder$StoryChatVideoView.setScaleType(ImageView.ScaleType.CENTER_CROP);
      localahen.jdField_a_of_type_ComTencentMobileqqActivityAioItemQQStoryItemBuilder$StoryChatVideoView.d(true);
      localahen.jdField_a_of_type_ComTencentMobileqqActivityAioItemQQStoryItemBuilder$StoryChatVideoView.setFocusable(false);
      localahen.jdField_a_of_type_ComTencentMobileqqActivityAioItemQQStoryItemBuilder$StoryChatVideoView.setFocusableInTouchMode(false);
      localahen.jdField_a_of_type_ComTencentMobileqqActivityAioItemQQStoryItemBuilder$StoryChatVideoView.setClickable(false);
      localahen.jdField_a_of_type_ComTencentMobileqqActivityAioItemQQStoryItemBuilder$StoryChatVideoView.setSharpCornerCor(BubbleImageView.jdField_a_of_type_ArrayOfFloat);
      localahen.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(localahen.jdField_a_of_type_ComTencentMobileqqActivityAioItemQQStoryItemBuilder$StoryChatVideoView, 0);
      localahen.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView = new BubbleImageView(this.jdField_b_of_type_AndroidContentContext);
      paramView = new RelativeLayout.LayoutParams(this.c, this.d);
      localahen.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setLayoutParams(paramView);
      localahen.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.c(false);
      localahen.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setRadius(15.0F);
      localahen.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
      localahen.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.d(true);
      localahen.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setFocusable(false);
      localahen.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setFocusableInTouchMode(false);
      localahen.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setClickable(false);
      localahen.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setSharpCornerCor(BubbleImageView.jdField_a_of_type_ArrayOfFloat);
      localahen.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(localahen.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView, 1);
      localahen.jdField_b_of_type_ComTencentMobileqqWidgetBubbleImageView = new BubbleImageView(this.jdField_b_of_type_AndroidContentContext);
      localahen.jdField_b_of_type_ComTencentMobileqqWidgetBubbleImageView.setLayoutParams(new RelativeLayout.LayoutParams(this.c, this.d));
      localahen.jdField_b_of_type_ComTencentMobileqqWidgetBubbleImageView.c(false);
      localahen.jdField_b_of_type_ComTencentMobileqqWidgetBubbleImageView.setRadius(15.0F);
      localahen.jdField_b_of_type_ComTencentMobileqqWidgetBubbleImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
      localahen.jdField_b_of_type_ComTencentMobileqqWidgetBubbleImageView.d(true);
      localahen.jdField_b_of_type_ComTencentMobileqqWidgetBubbleImageView.setFocusable(false);
      localahen.jdField_b_of_type_ComTencentMobileqqWidgetBubbleImageView.setFocusableInTouchMode(false);
      localahen.jdField_b_of_type_ComTencentMobileqqWidgetBubbleImageView.setClickable(false);
      localahen.jdField_b_of_type_ComTencentMobileqqWidgetBubbleImageView.setVisibility(4);
      localahen.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(localahen.jdField_b_of_type_ComTencentMobileqqWidgetBubbleImageView, 2);
      localahen.jdField_c_of_type_ComTencentMobileqqWidgetBubbleImageView = new BubbleImageView(this.jdField_b_of_type_AndroidContentContext);
      localahen.jdField_c_of_type_ComTencentMobileqqWidgetBubbleImageView.setLayoutParams(new RelativeLayout.LayoutParams(this.c, this.d));
      localahen.jdField_c_of_type_ComTencentMobileqqWidgetBubbleImageView.c(false);
      localahen.jdField_c_of_type_ComTencentMobileqqWidgetBubbleImageView.setRadius(15.0F);
      localahen.jdField_c_of_type_ComTencentMobileqqWidgetBubbleImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
      localahen.jdField_c_of_type_ComTencentMobileqqWidgetBubbleImageView.d(true);
      localahen.jdField_c_of_type_ComTencentMobileqqWidgetBubbleImageView.setFocusable(false);
      localahen.jdField_c_of_type_ComTencentMobileqqWidgetBubbleImageView.setFocusableInTouchMode(false);
      localahen.jdField_c_of_type_ComTencentMobileqqWidgetBubbleImageView.setClickable(false);
      localahen.jdField_c_of_type_ComTencentMobileqqWidgetBubbleImageView.setVisibility(4);
      localahen.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(localahen.jdField_c_of_type_ComTencentMobileqqWidgetBubbleImageView, 2);
      paramView = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[] { 536870912, 0 });
      paramView.setShape(0);
      float f1 = DisplayUtil.dip2px(this.jdField_b_of_type_AndroidContentContext, 15.0F);
      paramView.setCornerRadii(new float[] { f1, f1, f1, f1, 0.0F, 0.0F, 0.0F, 0.0F });
      paramView.setGradientType(0);
      localahen.jdField_b_of_type_AndroidWidgetImageView.setBackgroundDrawable(paramView);
      localahen.jdField_a_of_type_ComTencentBizQqstoryViewWidgetAutoStartProgressBar.setRadius(15.0F, true);
      localahen.jdField_a_of_type_ComTencentBizQqstoryViewWidgetAutoStartProgressBar.setShowCorner(true);
      localahen.jdField_a_of_type_ComTencentBizQqstoryViewWidgetAutoStartProgressBar.setDrawStatus(1);
      paramafqr.setOnLongClickListener(paramaftk);
      paramafqr.setOnTouchListener(paramaftk);
      localahen.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      i = this.jdField_b_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131296391);
      j = this.c;
      int k = BaseChatItemLayout.k;
      int m = this.d;
      int n = BaseChatItemLayout.h;
      int i1 = this.g;
      paramView = (RelativeLayout.LayoutParams)localahen.jdField_a_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
      paramView.width = (j + k + i);
      paramView.height = (i1 + (m + n));
      localahen.jdField_a_of_type_AndroidWidgetRelativeLayout.setLayoutParams(paramView);
    }
    localahen.jdField_a_of_type_ComTencentBizQqstoryViewWidgetAutoStartProgressBar.setKey(paramChatMessage.frienduin + paramChatMessage.uniseq);
    localahen.jdField_a_of_type_ComTencentBizQqstoryViewWidgetAutoStartProgressBar.setCornerDirection(bool);
    if (localahen.jdField_a_of_type_ComTencentMobileqqActivityAioItemQQStoryItemBuilder$StoryChatVideoView.d != bool)
    {
      localahen.jdField_a_of_type_ComTencentMobileqqActivityAioItemQQStoryItemBuilder$StoryChatVideoView.d = bool;
      localahen.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.d = bool;
      localahen.jdField_b_of_type_ComTencentMobileqqWidgetBubbleImageView.d = bool;
      localahen.jdField_c_of_type_ComTencentMobileqqWidgetBubbleImageView.d = bool;
      if (VersionUtils.isHoneycomb())
      {
        localahen.jdField_a_of_type_ComTencentMobileqqActivityAioItemQQStoryItemBuilder$StoryChatVideoView.a(this.c, this.d);
        localahen.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.a(this.c, this.d);
        localahen.jdField_b_of_type_ComTencentMobileqqWidgetBubbleImageView.a(this.c, this.d);
        localahen.jdField_c_of_type_ComTencentMobileqqWidgetBubbleImageView.a(this.c, this.d);
      }
      localahen.jdField_a_of_type_ComTencentMobileqqActivityAioItemQQStoryItemBuilder$StoryChatVideoView.invalidate();
      localahen.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.invalidate();
      localahen.jdField_b_of_type_ComTencentMobileqqWidgetBubbleImageView.invalidate();
      localahen.jdField_c_of_type_ComTencentMobileqqWidgetBubbleImageView.invalidate();
    }
    int i = DisplayUtil.dip2px(this.jdField_b_of_type_AndroidContentContext, localahen.jdField_a_of_type_ComTencentMobileqqActivityAioItemQQStoryItemBuilder$StoryChatVideoView.a);
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
      paramView = (RelativeLayout.LayoutParams)localahen.jdField_a_of_type_AndroidViewViewGroup.getLayoutParams();
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
      paramView.height = DisplayUtil.dip2px(this.jdField_b_of_type_AndroidContentContext, 42.0F);
      localahen.jdField_a_of_type_AndroidViewViewGroup.setLayoutParams(paramView);
      localahen.jdField_a_of_type_AndroidViewViewGroup.setVisibility(0);
      if ((GradientDrawable)localahen.jdField_a_of_type_AndroidViewViewGroup.getBackground() == null)
      {
        paramView = new GradientDrawable();
        paramView.setCornerRadii(this.jdField_a_of_type_ArrayOfFloat);
        paramView.setColor(1929379840);
        localahen.jdField_a_of_type_AndroidViewViewGroup.setBackgroundDrawable(paramView);
      }
      localahen.d.setText(paramChatMessage.storyTitle);
      localahen.e.setText(paramChatMessage.storyBrief);
    }
    for (;;)
    {
      if (bool) {
        break label1552;
      }
      paramChatMessage = (RelativeLayout.LayoutParams)localahen.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams();
      paramChatMessage.leftMargin = i;
      paramChatMessage.rightMargin = 0;
      localahen.jdField_a_of_type_AndroidWidgetTextView.setLayoutParams(paramChatMessage);
      paramChatMessage = (RelativeLayout.LayoutParams)localahen.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
      paramChatMessage.leftMargin = DisplayUtil.dip2px(this.jdField_b_of_type_AndroidContentContext, localahen.jdField_a_of_type_ComTencentMobileqqActivityAioItemQQStoryItemBuilder$StoryChatVideoView.a + 10);
      paramChatMessage.rightMargin = DisplayUtil.dip2px(this.jdField_b_of_type_AndroidContentContext, 10);
      localahen.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams(paramChatMessage);
      paramChatMessage = (RelativeLayout.LayoutParams)localahen.jdField_b_of_type_AndroidWidgetImageView.getLayoutParams();
      paramChatMessage.leftMargin = i;
      paramChatMessage.rightMargin = 0;
      localahen.jdField_b_of_type_AndroidWidgetImageView.setLayoutParams(paramChatMessage);
      return paramafqr;
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
      localahen.jdField_a_of_type_AndroidViewViewGroup.setVisibility(8);
    }
    label1552:
    paramChatMessage = (RelativeLayout.LayoutParams)localahen.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams();
    paramChatMessage.leftMargin = 0;
    paramChatMessage.rightMargin = i;
    localahen.jdField_a_of_type_AndroidWidgetTextView.setLayoutParams(paramChatMessage);
    paramChatMessage = (RelativeLayout.LayoutParams)localahen.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
    paramChatMessage.leftMargin = DisplayUtil.dip2px(this.jdField_b_of_type_AndroidContentContext, 10);
    paramChatMessage.rightMargin = DisplayUtil.dip2px(this.jdField_b_of_type_AndroidContentContext, localahen.jdField_a_of_type_ComTencentMobileqqActivityAioItemQQStoryItemBuilder$StoryChatVideoView.a + 10);
    localahen.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams(paramChatMessage);
    paramChatMessage = (RelativeLayout.LayoutParams)localahen.jdField_b_of_type_AndroidWidgetImageView.getLayoutParams();
    paramChatMessage.leftMargin = 0;
    paramChatMessage.rightMargin = i;
    localahen.jdField_b_of_type_AndroidWidgetImageView.setLayoutParams(paramChatMessage);
    return paramafqr;
  }
  
  public String a(ChatMessage paramChatMessage)
  {
    return paramChatMessage.getSummaryMsg();
  }
  
  public void a()
  {
    this.jdField_a_of_type_Wbp.a();
    if (this.jdField_f_of_type_Boolean)
    {
      ((wbv)wjs.a(6)).a(15000L);
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
            if (bgiz.a(paramChatMessage) == null) {
              bool = true;
            }
            for (;;)
            {
              Object localObject2 = null;
              try
              {
                localObject1 = bhey.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_AndroidContentContext, localMessageForQQStory.msgAction);
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
                admh.b(this.jdField_b_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
                a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType, "delete", (bheh)localObject1, bool);
                if (localMessageForQQStory.type == 3) {
                  ykv.a("mystory", "delete_obj_myday", 0, 0, new String[] { "", "", "", "" });
                }
              }
            }
          } while (localMessageForQQStory.type != 1);
          ykv.a("mystory", "delete_obj", 0, 0, new String[] { "", "", "", "" });
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
          paramContext.putInt("forward_source_uin_type", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType);
          paramChatMessage = new Intent();
          paramChatMessage.putExtras(paramContext);
          aupt.a((Activity)this.jdField_b_of_type_AndroidContentContext, paramChatMessage, 21);
          a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType, "forward", (bheh)localObject1, bool);
          if (localMessageForQQStory.type == 3) {
            ykv.a("mystory", "forward_obj_myday", 0, 0, new String[] { "", "", "", "" });
          }
        } while (localMessageForQQStory.type != 1);
        ykv.a("mystory", "forward_obj", 0, 0, new String[] { "", "", "", "" });
        return;
        super.a(paramChatMessage);
        a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType, "withdraw", (bheh)localObject1, bool);
        if (localMessageForQQStory.type == 3) {
          ykv.a("mystory", "withdraw_obj_myday", 0, 0, new String[] { "", "", "", "" });
        }
      } while (localMessageForQQStory.type != 1);
      ykv.a("mystory", "withdraw_obj", 0, 0, new String[] { "", "", "", "" });
      return;
      super.a(paramInt, paramContext, paramChatMessage);
      a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType, "reply", (bheh)localObject1, bool);
      if (localMessageForQQStory.type == 1)
      {
        ykv.a("mystory", "reply_obj", 0, 0, new String[] { "", "", "", "" });
        return;
      }
    } while (localMessageForQQStory.type != 2);
    ykv.a("ugc_video", "obj_reply", 0, 0, new String[] { "", "", "", "" });
  }
  
  public void a(ahen paramahen)
  {
    boolean bool = true;
    for (;;)
    {
      try
      {
        paramahen = (MessageForQQStory)paramahen.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
        if (QLog.isColorLevel()) {
          QLog.d("Q.qqstory.share", 2, "QQStoryItemBuilder onBubbleOnClick:" + paramahen.toString());
        }
        if (bgiz.a(paramahen) == null)
        {
          paramahen = bhey.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_AndroidContentContext, paramahen.msgAction);
          paramahen.a();
          a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType, "clk_play", paramahen, bool);
          int i = this.h;
          String str = this.jdField_a_of_type_JavaLangString;
          if (this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem == null)
          {
            paramahen = "";
            ykv.a("video_game", "clk_gamevideo", 0, 0, new String[] { String.valueOf(i), "", str, paramahen });
            return;
          }
          paramahen = this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVid;
          continue;
        }
        bool = false;
      }
      catch (Exception paramahen)
      {
        if (QLog.isColorLevel()) {
          QLog.w("Q.qqstory.share", 2, "QQStoryItemBuilder onBubbleOnClick exp:", paramahen);
        }
        return;
      }
    }
  }
  
  public void a(ahen paramahen, long paramLong)
  {
    ((Activity)this.jdField_b_of_type_AndroidContentContext).runOnUiThread(new QQStoryItemBuilder.10(this, paramahen, paramLong));
  }
  
  public void a(ahen paramahen, long paramLong, int paramInt1, int paramInt2, String paramString1, String paramString2)
  {
    b(paramahen, paramLong, paramInt1, paramInt2, paramString1, paramString2);
    if (!bhbz.a().a(paramahen.jdField_a_of_type_ComTencentMobileqqDataChatMessage, "share|auto_play"))
    {
      bhbz.a().a(paramahen.jdField_a_of_type_ComTencentMobileqqDataChatMessage, "share|auto_play");
      if (!(paramahen.jdField_a_of_type_ComTencentMobileqqDataChatMessage instanceof MessageForQQStory)) {
        break label188;
      }
      paramInt1 = ((MessageForQQStory)paramahen.jdField_a_of_type_ComTencentMobileqqDataChatMessage).type;
      if (paramInt1 != 1) {
        break label91;
      }
      paramInt1 = 1;
    }
    label188:
    for (;;)
    {
      ykv.a("share", "auto_play", paramInt1, 0, new String[0]);
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
  
  public void a(ahen paramahen, long paramLong, StoryVideoItem paramStoryVideoItem, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem = paramStoryVideoItem;
    boolean bool = StoryVideoItem.isPlayable(paramStoryVideoItem.mVid, true);
    if (QLog.isColorLevel()) {
      QLog.i("QQStoryItemBuilder", 2, "handleGetVideo: isPlayable =" + bool);
    }
    Object localObject;
    if (!bool) {
      if ((b(paramahen.jdField_a_of_type_ComTencentMobileqqDataChatMessage)) || (paramBoolean))
      {
        ((Activity)this.jdField_b_of_type_AndroidContentContext).runOnUiThread(new QQStoryItemBuilder.5(this, paramahen));
        if (QLog.isColorLevel()) {
          QLog.d("Q.qqstory.share", 2, "QQStoryItemBuilder handleGetVideo 1: wifi download");
        }
        localObject = new ArrayList();
        ((ArrayList)localObject).add(paramStoryVideoItem);
        this.jdField_a_of_type_Wbp.a((List)localObject);
        this.jdField_a_of_type_Wbp.a(paramStoryVideoItem.mVid);
        this.jdField_a_of_type_Ahem.a(paramahen, paramStoryVideoItem.mVid, paramLong);
      }
    }
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqstory.share", 2, "QQStoryItemBuilder handleGetVideo 2: no wifi");
      }
      ((Activity)this.jdField_b_of_type_AndroidContentContext).runOnUiThread(new QQStoryItemBuilder.6(this, paramahen, paramLong, paramStoryVideoItem));
      return;
      String str = this.jdField_a_of_type_Wbp.a(paramStoryVideoItem.mVid);
      localObject = str;
      if (str != null)
      {
        localObject = str;
        if (str.startsWith("file://")) {
          localObject = str.substring(7);
        }
      }
    } while (!(this.jdField_b_of_type_AndroidContentContext instanceof Activity));
    ((Activity)this.jdField_b_of_type_AndroidContentContext).runOnUiThread(new QQStoryItemBuilder.7(this, (String)localObject, paramahen, paramStoryVideoItem, paramLong, paramBoolean));
  }
  
  protected void a(ahen paramahen, ViewGroup paramViewGroup, boolean paramBoolean)
  {
    paramahen.jdField_a_of_type_AndroidWidgetFrameLayout = new FrameLayout(this.jdField_b_of_type_AndroidContentContext);
    Object localObject = new TextView(this.jdField_b_of_type_AndroidContentContext);
    ((TextView)localObject).setBackgroundResource(2130842656);
    ((TextView)localObject).setTextSize(1, 12.0F);
    ((TextView)localObject).setTextColor(this.jdField_b_of_type_AndroidContentContext.getResources().getColor(2131167363));
    ((TextView)localObject).setIncludeFontPadding(false);
    ((TextView)localObject).setSingleLine();
    ((TextView)localObject).setGravity(16);
    ((TextView)localObject).setPadding(DisplayUtil.dip2px(this.jdField_b_of_type_AndroidContentContext, 5.0F), 0, DisplayUtil.dip2px(this.jdField_b_of_type_AndroidContentContext, 5.0F), 0);
    paramahen.jdField_a_of_type_AndroidWidgetFrameLayout.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-2, -2);
    paramahen.jdField_a_of_type_AndroidWidgetFrameLayout.addView((View)localObject, localLayoutParams);
    paramahen.jdField_c_of_type_AndroidWidgetTextView = ((TextView)localObject);
    localObject = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject).addRule(3, 2131364522);
    ((RelativeLayout.LayoutParams)localObject).addRule(5, 2131364522);
    paramViewGroup.addView(paramahen.jdField_a_of_type_AndroidWidgetFrameLayout, (ViewGroup.LayoutParams)localObject);
  }
  
  public void a(ahen paramahen, String paramString)
  {
    if ((!TextUtils.equals(paramString, paramahen.jdField_b_of_type_JavaLangString)) || (paramahen.jdField_a_of_type_ComTencentImageURLDrawable == null))
    {
      paramahen.jdField_b_of_type_JavaLangString = paramString;
      paramahen.jdField_a_of_type_ComTencentImageURLDrawable = null;
      if (TextUtils.isEmpty(paramString)) {}
    }
    while (!QLog.isColorLevel()) {
      try
      {
        paramahen.jdField_a_of_type_ComTencentImageURLDrawable = URLDrawable.getDrawable(paramString, PAVideoView.a, PAVideoView.a);
        if (QLog.isColorLevel()) {
          QLog.e("QQStoryItemBuilder", 2, "checkCoverDrawable(): reload drawable, coverUrl=" + paramString + " holder=" + paramahen.hashCode());
        }
        return;
      }
      catch (Exception localException)
      {
        while (!QLog.isColorLevel()) {}
        QLog.e("QQStoryItemBuilder", 2, "checkCoverDrawable():  getDrawable Exception, coverUrl=" + paramString + " holder=" + paramahen.hashCode(), localException);
        return;
      }
    }
    QLog.e("QQStoryItemBuilder", 2, "checkCoverDrawable(): reuse drawable, coverUrl=" + paramString + " holder=" + paramahen.hashCode());
  }
  
  public void a(ahen paramahen, String paramString, long paramLong, boolean paramBoolean)
  {
    wzk.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString, new ahel(this, paramahen, paramLong, paramBoolean));
  }
  
  public void a(ahen paramahen, String paramString1, String paramString2, long paramLong, boolean paramBoolean)
  {
    ykq.a("QQStoryItemBuilder", "setVideoView %s vid %s", paramString1, paramString2);
    ThreadManager.post(new QQStoryItemBuilder.8(this, paramString2, paramahen, paramLong, paramString1, paramBoolean), 8, null, true);
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    Object localObject = AIOUtils.getHolder(paramView);
    if (!ahen.class.isInstance(localObject)) {}
    String str1;
    String str2;
    do
    {
      return;
      paramView = this.jdField_b_of_type_AndroidContentContext;
      localObject = ((ahen)localObject).jdField_a_of_type_ComTencentMobileqqDataChatMessage;
      str1 = paramView.getString(2131689976);
      str2 = paramView.getString(2131689977);
    } while (!((ChatMessage)localObject).isSendFromLocal());
    bhdj.a(paramView, 230, str1, str2, new ahei(this, paramView, (ChatMessage)localObject), new ahej(this)).show();
  }
  
  public void a(View paramView, ChatMessage paramChatMessage)
  {
    int i = this.jdField_b_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131296391);
    if (paramChatMessage.isSend())
    {
      paramView.setPadding(BaseChatItemLayout.k, BaseChatItemLayout.h, i, this.g);
      return;
    }
    paramView.setPadding(i, BaseChatItemLayout.h, BaseChatItemLayout.k, this.g);
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
    ahen localahen = (ahen)paramViewGroup.getTag();
    boolean bool = localMessageForQQStory.isSend();
    if (localahen.jdField_a_of_type_AndroidWidgetFrameLayout == null) {
      a(localahen, paramViewGroup, bool);
    }
    paramViewGroup = (FrameLayout.LayoutParams)localahen.jdField_c_of_type_AndroidWidgetTextView.getLayoutParams();
    if (bool)
    {
      paramViewGroup.leftMargin = BaseChatItemLayout.k;
      localahen.jdField_c_of_type_AndroidWidgetTextView.setLayoutParams(paramViewGroup);
      localahen.jdField_a_of_type_AndroidWidgetTextView.setText(localMessageForQQStory.brief);
      localahen.jdField_c_of_type_AndroidWidgetTextView.setText(localMessageForQQStory.srcName);
      if ((localMessageForQQStory.type != 3) && (localMessageForQQStory.type != 5) && (localMessageForQQStory.type != 8) && (localMessageForQQStory.type != 9)) {
        break label346;
      }
      localahen.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      localahen.jdField_b_of_type_AndroidWidgetTextView.setText(anvx.a(2131710361));
      label161:
      localahen.jdField_a_of_type_ComTencentBizQqstoryViewWidgetAutoStartProgressBar.setCornerDirection(paramChatMessage.isSend());
      if ((!TextUtils.isEmpty(localMessageForQQStory.mVid)) && (ShortVideoUtils.ShortVideoPlayConfig.sAutoPlayInAIO)) {
        break label422;
      }
      localahen.jdField_a_of_type_Boolean = false;
      localahen.jdField_a_of_type_ComTencentBizQqstoryViewWidgetAutoStartProgressBar.setDrawStatus(2);
      localahen.jdField_a_of_type_ComTencentBizQqstoryViewWidgetAutoStartProgressBar.setVisibility(0);
      a(localahen.jdField_a_of_type_ComTencentMobileqqActivityAioItemQQStoryItemBuilder$StoryChatVideoView, localMessageForQQStory.coverImgUrl, this.c, this.d, this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
      a(localahen.jdField_a_of_type_AndroidWidgetImageView, localMessageForQQStory.logoImgUrl, this.e, this.jdField_f_of_type_Int, this.jdField_b_of_type_AndroidGraphicsDrawableDrawable);
      localahen.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setImageDrawable(null);
    }
    for (;;)
    {
      try
      {
        paramViewGroup = bhey.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_AndroidContentContext, localMessageForQQStory.msgAction);
        if (bgiz.a(localMessageForQQStory) != null) {
          continue;
        }
        bool = true;
        a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType, "exp", paramViewGroup, bool);
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
      paramViewGroup.leftMargin = (DisplayUtil.dip2px(this.jdField_b_of_type_AndroidContentContext, localahen.jdField_a_of_type_ComTencentMobileqqActivityAioItemQQStoryItemBuilder$StoryChatVideoView.a) + BaseChatItemLayout.j);
      break;
      if (localMessageForQQStory.type == 11)
      {
        localahen.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
        if (!TextUtils.isEmpty(localMessageForQQStory.mHeadTip))
        {
          localahen.jdField_b_of_type_AndroidWidgetTextView.setText(localMessageForQQStory.mHeadTip);
          break label161;
        }
        localahen.jdField_b_of_type_AndroidWidgetTextView.setText(anvx.a(2131710360));
        break label161;
      }
      localahen.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      break label161;
      paramViewGroup = (Long)localahen.jdField_a_of_type_ComTencentMobileqqActivityAioItemQQStoryItemBuilder$StoryChatVideoView.getTag();
      paramChatMessage = ((wjp)wjs.a(5)).a(localMessageForQQStory.mVid);
      if ((paramViewGroup == null) || (paramViewGroup.longValue() != localMessageForQQStory.uniseq))
      {
        localahen.jdField_a_of_type_Boolean = false;
        localahen.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setImageDrawable(null);
        a(localahen.jdField_a_of_type_ComTencentMobileqqActivityAioItemQQStoryItemBuilder$StoryChatVideoView, localMessageForQQStory.coverImgUrl, this.c, this.d, this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
        if (paramChatMessage != null)
        {
          b(localahen, localMessageForQQStory.uniseq, paramChatMessage, false);
          c(localahen, localMessageForQQStory.uniseq, paramChatMessage, false);
        }
        a(localahen, localMessageForQQStory.coverImgUrl, localMessageForQQStory.mVid, localMessageForQQStory.uniseq, false);
        localahen.jdField_a_of_type_ComTencentMobileqqActivityAioItemQQStoryItemBuilder$StoryChatVideoView.setTag(Long.valueOf(localMessageForQQStory.uniseq));
      }
      else if (paramChatMessage != null)
      {
        b(localahen, localMessageForQQStory.uniseq, paramChatMessage, false);
        c(localahen, localMessageForQQStory.uniseq, paramChatMessage, false);
        continue;
        bool = false;
      }
    }
  }
  
  public bhjs[] a(View paramView)
  {
    bhjq localbhjq = new bhjq();
    paramView = AIOUtils.getMessage(paramView);
    boolean bool;
    if (bgiz.a(paramView) == null) {
      bool = true;
    }
    for (;;)
    {
      localbhjq.a(2131367213, this.jdField_b_of_type_AndroidContentContext.getString(2131692550), 2130838991);
      a(paramView, localbhjq);
      if ((paramView.isSend()) && (paramView.extraflag != 32768) && (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgCache().b(paramView))) {
        a(localbhjq, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType, paramView);
      }
      a(localbhjq, paramView);
      b(paramView, localbhjq);
      try
      {
        paramView = (MessageForQQStory)paramView;
        paramView = bhey.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_AndroidContentContext, paramView.msgAction);
        a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType, "press", paramView, bool);
        super.e(localbhjq, this.jdField_b_of_type_AndroidContentContext);
        return localbhjq.a();
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
  
  public void b(ahen paramahen)
  {
    for (;;)
    {
      try
      {
        paramahen = (MessageForQQStory)paramahen.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
        if (QLog.isColorLevel()) {
          QLog.d("Q.qqstory.share", 2, "QQStoryItemBuilder onSourceOnClick:" + paramahen.toString());
        }
        if (bgiz.a(paramahen) == null)
        {
          bool = true;
          bhey.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_AndroidContentContext, paramahen.srcAction).a();
          paramahen = bhey.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_AndroidContentContext, paramahen.msgAction);
          a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType, "clk_tail", paramahen, bool);
          return;
        }
      }
      catch (Exception paramahen)
      {
        boolean bool;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.w("Q.qqstory.share", 2, "QQStoryItemBuilder onSourceOnClick exp:", paramahen);
      }
      bool = false;
    }
  }
  
  public void b(ahen paramahen, long paramLong, int paramInt1, int paramInt2, String paramString1, String paramString2)
  {
    paramString1 = a(paramInt1, paramInt2, paramLong, paramString1, paramString2);
    paramString2 = URLDrawable.URLDrawableOptions.obtain();
    paramString2.mExtraInfo = paramString1;
    paramString2.mLoadingDrawable = a(paramahen, paramString1.mCoverUrl);
    paramString1 = URLDrawable.getDrawable(PAVideoView.a(paramLong), paramString2);
    paramahen.jdField_a_of_type_ComTencentMobileqqActivityAioItemQQStoryItemBuilder$StoryChatVideoView.setImageDrawable(paramString1);
  }
  
  public void b(ahen paramahen, long paramLong, StoryVideoItem paramStoryVideoItem, boolean paramBoolean)
  {
    ykq.c("QQStoryItemBuilder", "updateStoryPollLayout");
    String str = paramStoryVideoItem.getPollDescription();
    if (TextUtils.equals(str, (String)paramahen.jdField_b_of_type_ComTencentMobileqqWidgetBubbleImageView.getTag()))
    {
      ykq.b("QQStoryItemBuilder", "updateStoryPollLayout no need refresh, it is already %s", str);
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
      paramahen.jdField_b_of_type_ComTencentMobileqqWidgetBubbleImageView.setImageDrawable(new BitmapDrawable(this.jdField_b_of_type_AndroidContentContext.getResources(), paramStoryVideoItem));
      paramahen.jdField_b_of_type_ComTencentMobileqqWidgetBubbleImageView.setVisibility(0);
    }
    for (;;)
    {
      paramahen.jdField_b_of_type_ComTencentMobileqqWidgetBubbleImageView.setTag(str);
      return;
      paramahen.jdField_b_of_type_ComTencentMobileqqWidgetBubbleImageView.setVisibility(4);
    }
  }
  
  protected boolean b(MessageRecord paramMessageRecord)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getShortVideoPredownloer().jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 2) {}
    while (NetConnInfoCenter.getServerTimeMillis() - paramMessageRecord.time * 1000L > bcxj.jdField_a_of_type_Long) {
      return false;
    }
    return NetworkUtil.isWifiConnected(this.jdField_b_of_type_AndroidContentContext);
  }
  
  public void c(ahen paramahen, long paramLong, StoryVideoItem paramStoryVideoItem, boolean paramBoolean)
  {
    ykq.c("QQStoryItemBuilder", "updateStoryInteractLayout");
    String str = paramStoryVideoItem.getInteractDescription();
    if (TextUtils.equals(str, (String)paramahen.jdField_c_of_type_ComTencentMobileqqWidgetBubbleImageView.getTag()))
    {
      ykq.b("QQStoryItemBuilder", "updateStoryInteractLayout no need refresh, it is already %s", str);
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
      paramahen.jdField_c_of_type_ComTencentMobileqqWidgetBubbleImageView.setImageDrawable(new BitmapDrawable(this.jdField_b_of_type_AndroidContentContext.getResources(), paramStoryVideoItem));
      paramahen.jdField_c_of_type_ComTencentMobileqqWidgetBubbleImageView.setVisibility(0);
    }
    for (;;)
    {
      paramahen.jdField_c_of_type_ComTencentMobileqqWidgetBubbleImageView.setTag(str);
      return;
      paramahen.jdField_c_of_type_ComTencentMobileqqWidgetBubbleImageView.setVisibility(4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.QQStoryItemBuilder
 * JD-Core Version:    0.7.0.1
 */