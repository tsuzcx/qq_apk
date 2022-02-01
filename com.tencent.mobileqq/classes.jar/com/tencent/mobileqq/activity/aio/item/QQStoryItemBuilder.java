package com.tencent.mobileqq.activity.aio.item;

import aean;
import agej;
import aggl;
import aggr;
import agjk;
import ahpe;
import ahpf;
import ahpg;
import ahph;
import ahpi;
import ahpj;
import ahpk;
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
import anzj;
import auxu;
import bcrg;
import bcxf;
import bcyh;
import bgrf;
import bhgr;
import bhjz;
import bhlq;
import bhmr;
import bhni;
import bhnv;
import bhpc;
import bhuk;
import bhum;
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
import com.tencent.util.VersionUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import wkv;
import wlb;
import wte;
import wth;
import wuu;
import xiz;
import yuk;
import yup;

public class QQStoryItemBuilder
  extends BaseBubbleBuilder
{
  public ahpj a;
  protected Drawable a;
  public View.OnClickListener a;
  private StoryVideoItem a;
  protected String a;
  protected wkv a;
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
    this.jdField_a_of_type_Wkv = new wkv();
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new ahpe(this);
    this.jdField_a_of_type_Ahpj = new ahph(this);
    this.jdField_b_of_type_AndroidContentContext = paramContext;
    float f1 = bhgr.a(this.jdField_b_of_type_AndroidContentContext, 15.0F);
    this.jdField_a_of_type_ArrayOfFloat = new float[] { 0.0F, 0.0F, 0.0F, 0.0F, f1, f1, f1, f1 };
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = new ColorDrawable(Color.parseColor("#e1e1e5"));
    this.jdField_b_of_type_AndroidGraphicsDrawableDrawable = new ColorDrawable(Color.parseColor("#00000000"));
    this.e = bhgr.a(this.jdField_b_of_type_AndroidContentContext, 135.0F);
    this.jdField_f_of_type_Int = bhgr.a(this.jdField_b_of_type_AndroidContentContext, 19.0F);
    this.c = bhgr.a(this.jdField_b_of_type_AndroidContentContext, 137.0F);
    this.d = bhgr.a(this.jdField_b_of_type_AndroidContentContext, 218.0F);
    this.g = bhgr.a(this.jdField_b_of_type_AndroidContentContext, 7.0F);
    paramBaseAdapter = (wlb)wth.a(6);
    if (!paramBaseAdapter.a())
    {
      paramBaseAdapter.c();
      this.jdField_f_of_type_Boolean = true;
    }
    this.jdField_a_of_type_Wkv.a(this.jdField_a_of_type_Ahpj);
    bcyh.a();
    paramQQAppInterface = (aggr)paramQQAppInterface.getManager(282);
    if (paramQQAppInterface != null) {
      paramQQAppInterface.a(3, 5);
    }
  }
  
  private Drawable a(ahpk paramahpk, String paramString)
  {
    a(paramahpk, paramString);
    Object localObject2;
    if ((paramahpk.jdField_a_of_type_ComTencentImageURLDrawable != null) && ((paramahpk.jdField_a_of_type_ComTencentImageURLDrawable instanceof URLDrawable)))
    {
      localObject1 = paramahpk.jdField_a_of_type_ComTencentImageURLDrawable.getCurrDrawable();
      if ((localObject1 != null) && ((localObject1 instanceof RegionDrawable)))
      {
        localObject1 = ((RegionDrawable)localObject1).getBitmap();
        if ((localObject1 == null) || (((Bitmap)localObject1).isRecycled())) {
          break label226;
        }
        localObject2 = new BitmapDrawable((Bitmap)localObject1);
        localObject1 = localObject2;
        if (QLog.isColorLevel()) {
          QLog.e("QQStoryItemBuilder", 2, "getBitmapDrawable(): find bitmap drawable coverUrl=" + paramString + " holder=" + paramahpk.hashCode());
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
          QLog.e("QQStoryItemBuilder", 2, "getBitmapDrawable(): use loading drawable coverUrl=" + paramString + " holder=" + paramahpk.hashCode());
          localObject2 = localObject1;
        }
      }
      return localObject2;
      if (QLog.isColorLevel()) {
        QLog.e("QQStoryItemBuilder", 2, "getBitmapDrawable(): not find reginDrawable coverUrl=" + paramString + " holder=" + paramahpk.hashCode());
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
    wuu localwuu = paramStoryVideoItem.getVideoGameInfo();
    if (localwuu != null)
    {
      this.jdField_a_of_type_JavaLangString = localwuu.jdField_a_of_type_JavaLangString;
      if (!paramStoryVideoItem.isMine()) {
        break label45;
      }
      if (localwuu.jdField_a_of_type_Int != 1) {
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
    if (localwuu.jdField_a_of_type_Int == 1) {}
    for (i = 2;; i = 4)
    {
      this.h = i;
      return;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, int paramInt, String paramString, bhmr parambhmr, boolean paramBoolean)
  {
    int i = 3;
    if (paramInt == 0) {
      i = 1;
    }
    for (;;)
    {
      if (parambhmr != null) {}
      for (;;)
      {
        try
        {
          str = parambhmr.b("unionid");
          paramQQAppInterface = parambhmr.b("storyid");
        }
        catch (Exception paramQQAppInterface)
        {
          if (!QLog.isColorLevel()) {
            break;
          }
        }
        try
        {
          paramInt = Integer.valueOf(parambhmr.b("contentType")).intValue();
          parambhmr = str;
        }
        catch (Exception parambhmr)
        {
          paramInt = -1;
          parambhmr = str;
          continue;
        }
        if (paramBoolean)
        {
          str = "1";
          yup.a("share_obj", paramString, i, paramInt, new String[] { parambhmr, paramQQAppInterface, str, "" });
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("Q.qqstory.share", 2, "reportClickEvent: opName=" + paramString + ", fromType=" + i + ", result=" + paramInt + ", extra1=" + parambhmr + ", extra2=" + paramQQAppInterface + ", extra3=" + str);
          return;
        }
        str = "2";
        continue;
        QLog.w("Q.qqstory.share", 2, "reportClickEvent exp:", paramQQAppInterface);
        return;
        paramInt = -1;
        parambhmr = "";
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
  
  public aggl a()
  {
    return new ahpk();
  }
  
  public View a(int paramInt1, int paramInt2, ChatMessage paramChatMessage, View paramView, ViewGroup paramViewGroup, agjk paramagjk)
  {
    paramView = (ViewGroup)super.a(paramInt1, paramInt2, paramChatMessage, paramView, paramViewGroup, paramagjk);
    a(paramView, paramChatMessage);
    return paramView;
  }
  
  public View a(ChatMessage paramChatMessage, aggl paramaggl, View paramView, BaseChatItemLayout paramBaseChatItemLayout, agjk paramagjk)
  {
    ahpk localahpk = (ahpk)paramaggl;
    boolean bool = paramChatMessage.isSend();
    paramaggl = paramView;
    int j;
    if (paramView == null)
    {
      paramaggl = LayoutInflater.from(this.jdField_b_of_type_AndroidContentContext).inflate(2131558848, paramBaseChatItemLayout, false);
      localahpk.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramaggl.findViewById(2131364423));
      localahpk.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localahpk.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131363669));
      localahpk.jdField_b_of_type_AndroidWidgetTextView = ((TextView)localahpk.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131371917));
      localahpk.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localahpk.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131370405));
      localahpk.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)localahpk.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131370642));
      localahpk.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)localahpk.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131367378));
      localahpk.d = ((TextView)localahpk.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131367401));
      localahpk.e = ((TextView)localahpk.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131367364));
      localahpk.jdField_a_of_type_ComTencentBizQqstoryViewWidgetAutoStartProgressBar = ((AutoStartProgressBar)localahpk.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131380885));
      localahpk.jdField_a_of_type_ComTencentBizQqstoryViewWidgetAutoStartProgressBar.setSharpCornerCor(BubbleImageView.jdField_a_of_type_ArrayOfFloat);
      localahpk.jdField_a_of_type_ComTencentMobileqqActivityAioItemQQStoryItemBuilder$StoryChatVideoView = new QQStoryItemBuilder.StoryChatVideoView(this.jdField_b_of_type_AndroidContentContext);
      paramView = new RelativeLayout.LayoutParams(this.c, this.d);
      localahpk.jdField_a_of_type_ComTencentMobileqqActivityAioItemQQStoryItemBuilder$StoryChatVideoView.setLayoutParams(paramView);
      localahpk.jdField_a_of_type_ComTencentMobileqqActivityAioItemQQStoryItemBuilder$StoryChatVideoView.c(false);
      localahpk.jdField_a_of_type_ComTencentMobileqqActivityAioItemQQStoryItemBuilder$StoryChatVideoView.setRadius(15.0F);
      localahpk.jdField_a_of_type_ComTencentMobileqqActivityAioItemQQStoryItemBuilder$StoryChatVideoView.setScaleType(ImageView.ScaleType.CENTER_CROP);
      localahpk.jdField_a_of_type_ComTencentMobileqqActivityAioItemQQStoryItemBuilder$StoryChatVideoView.d(true);
      localahpk.jdField_a_of_type_ComTencentMobileqqActivityAioItemQQStoryItemBuilder$StoryChatVideoView.setFocusable(false);
      localahpk.jdField_a_of_type_ComTencentMobileqqActivityAioItemQQStoryItemBuilder$StoryChatVideoView.setFocusableInTouchMode(false);
      localahpk.jdField_a_of_type_ComTencentMobileqqActivityAioItemQQStoryItemBuilder$StoryChatVideoView.setClickable(false);
      localahpk.jdField_a_of_type_ComTencentMobileqqActivityAioItemQQStoryItemBuilder$StoryChatVideoView.setSharpCornerCor(BubbleImageView.jdField_a_of_type_ArrayOfFloat);
      localahpk.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(localahpk.jdField_a_of_type_ComTencentMobileqqActivityAioItemQQStoryItemBuilder$StoryChatVideoView, 0);
      localahpk.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView = new BubbleImageView(this.jdField_b_of_type_AndroidContentContext);
      paramView = new RelativeLayout.LayoutParams(this.c, this.d);
      localahpk.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setLayoutParams(paramView);
      localahpk.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.c(false);
      localahpk.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setRadius(15.0F);
      localahpk.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
      localahpk.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.d(true);
      localahpk.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setFocusable(false);
      localahpk.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setFocusableInTouchMode(false);
      localahpk.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setClickable(false);
      localahpk.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setSharpCornerCor(BubbleImageView.jdField_a_of_type_ArrayOfFloat);
      localahpk.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(localahpk.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView, 1);
      localahpk.jdField_b_of_type_ComTencentMobileqqWidgetBubbleImageView = new BubbleImageView(this.jdField_b_of_type_AndroidContentContext);
      localahpk.jdField_b_of_type_ComTencentMobileqqWidgetBubbleImageView.setLayoutParams(new RelativeLayout.LayoutParams(this.c, this.d));
      localahpk.jdField_b_of_type_ComTencentMobileqqWidgetBubbleImageView.c(false);
      localahpk.jdField_b_of_type_ComTencentMobileqqWidgetBubbleImageView.setRadius(15.0F);
      localahpk.jdField_b_of_type_ComTencentMobileqqWidgetBubbleImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
      localahpk.jdField_b_of_type_ComTencentMobileqqWidgetBubbleImageView.d(true);
      localahpk.jdField_b_of_type_ComTencentMobileqqWidgetBubbleImageView.setFocusable(false);
      localahpk.jdField_b_of_type_ComTencentMobileqqWidgetBubbleImageView.setFocusableInTouchMode(false);
      localahpk.jdField_b_of_type_ComTencentMobileqqWidgetBubbleImageView.setClickable(false);
      localahpk.jdField_b_of_type_ComTencentMobileqqWidgetBubbleImageView.setVisibility(4);
      localahpk.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(localahpk.jdField_b_of_type_ComTencentMobileqqWidgetBubbleImageView, 2);
      localahpk.jdField_c_of_type_ComTencentMobileqqWidgetBubbleImageView = new BubbleImageView(this.jdField_b_of_type_AndroidContentContext);
      localahpk.jdField_c_of_type_ComTencentMobileqqWidgetBubbleImageView.setLayoutParams(new RelativeLayout.LayoutParams(this.c, this.d));
      localahpk.jdField_c_of_type_ComTencentMobileqqWidgetBubbleImageView.c(false);
      localahpk.jdField_c_of_type_ComTencentMobileqqWidgetBubbleImageView.setRadius(15.0F);
      localahpk.jdField_c_of_type_ComTencentMobileqqWidgetBubbleImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
      localahpk.jdField_c_of_type_ComTencentMobileqqWidgetBubbleImageView.d(true);
      localahpk.jdField_c_of_type_ComTencentMobileqqWidgetBubbleImageView.setFocusable(false);
      localahpk.jdField_c_of_type_ComTencentMobileqqWidgetBubbleImageView.setFocusableInTouchMode(false);
      localahpk.jdField_c_of_type_ComTencentMobileqqWidgetBubbleImageView.setClickable(false);
      localahpk.jdField_c_of_type_ComTencentMobileqqWidgetBubbleImageView.setVisibility(4);
      localahpk.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(localahpk.jdField_c_of_type_ComTencentMobileqqWidgetBubbleImageView, 2);
      paramView = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[] { 536870912, 0 });
      paramView.setShape(0);
      float f1 = bhgr.a(this.jdField_b_of_type_AndroidContentContext, 15.0F);
      paramView.setCornerRadii(new float[] { f1, f1, f1, f1, 0.0F, 0.0F, 0.0F, 0.0F });
      paramView.setGradientType(0);
      localahpk.jdField_b_of_type_AndroidWidgetImageView.setBackgroundDrawable(paramView);
      localahpk.jdField_a_of_type_ComTencentBizQqstoryViewWidgetAutoStartProgressBar.setRadius(15.0F, true);
      localahpk.jdField_a_of_type_ComTencentBizQqstoryViewWidgetAutoStartProgressBar.setShowCorner(true);
      localahpk.jdField_a_of_type_ComTencentBizQqstoryViewWidgetAutoStartProgressBar.setDrawStatus(1);
      paramaggl.setOnLongClickListener(paramagjk);
      paramaggl.setOnTouchListener(paramagjk);
      localahpk.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      i = this.jdField_b_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131296338);
      j = this.c;
      int k = BaseChatItemLayout.k;
      int m = this.d;
      int n = BaseChatItemLayout.h;
      int i1 = this.g;
      paramView = (RelativeLayout.LayoutParams)localahpk.jdField_a_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
      paramView.width = (j + k + i);
      paramView.height = (i1 + (m + n));
      localahpk.jdField_a_of_type_AndroidWidgetRelativeLayout.setLayoutParams(paramView);
    }
    localahpk.jdField_a_of_type_ComTencentBizQqstoryViewWidgetAutoStartProgressBar.setKey(paramChatMessage.frienduin + paramChatMessage.uniseq);
    localahpk.jdField_a_of_type_ComTencentBizQqstoryViewWidgetAutoStartProgressBar.setCornerDirection(bool);
    if (localahpk.jdField_a_of_type_ComTencentMobileqqActivityAioItemQQStoryItemBuilder$StoryChatVideoView.d != bool)
    {
      localahpk.jdField_a_of_type_ComTencentMobileqqActivityAioItemQQStoryItemBuilder$StoryChatVideoView.d = bool;
      localahpk.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.d = bool;
      localahpk.jdField_b_of_type_ComTencentMobileqqWidgetBubbleImageView.d = bool;
      localahpk.jdField_c_of_type_ComTencentMobileqqWidgetBubbleImageView.d = bool;
      if (VersionUtils.isHoneycomb())
      {
        localahpk.jdField_a_of_type_ComTencentMobileqqActivityAioItemQQStoryItemBuilder$StoryChatVideoView.a(this.c, this.d);
        localahpk.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.a(this.c, this.d);
        localahpk.jdField_b_of_type_ComTencentMobileqqWidgetBubbleImageView.a(this.c, this.d);
        localahpk.jdField_c_of_type_ComTencentMobileqqWidgetBubbleImageView.a(this.c, this.d);
      }
      localahpk.jdField_a_of_type_ComTencentMobileqqActivityAioItemQQStoryItemBuilder$StoryChatVideoView.invalidate();
      localahpk.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.invalidate();
      localahpk.jdField_b_of_type_ComTencentMobileqqWidgetBubbleImageView.invalidate();
      localahpk.jdField_c_of_type_ComTencentMobileqqWidgetBubbleImageView.invalidate();
    }
    int i = bhgr.a(this.jdField_b_of_type_AndroidContentContext, localahpk.jdField_a_of_type_ComTencentMobileqqActivityAioItemQQStoryItemBuilder$StoryChatVideoView.a);
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
      paramView = (RelativeLayout.LayoutParams)localahpk.jdField_a_of_type_AndroidViewViewGroup.getLayoutParams();
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
      paramView.height = bhgr.a(this.jdField_b_of_type_AndroidContentContext, 42.0F);
      localahpk.jdField_a_of_type_AndroidViewViewGroup.setLayoutParams(paramView);
      localahpk.jdField_a_of_type_AndroidViewViewGroup.setVisibility(0);
      if ((GradientDrawable)localahpk.jdField_a_of_type_AndroidViewViewGroup.getBackground() == null)
      {
        paramView = new GradientDrawable();
        paramView.setCornerRadii(this.jdField_a_of_type_ArrayOfFloat);
        paramView.setColor(1929379840);
        localahpk.jdField_a_of_type_AndroidViewViewGroup.setBackgroundDrawable(paramView);
      }
      localahpk.d.setText(paramChatMessage.storyTitle);
      localahpk.e.setText(paramChatMessage.storyBrief);
    }
    for (;;)
    {
      if (bool) {
        break label1552;
      }
      paramChatMessage = (RelativeLayout.LayoutParams)localahpk.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams();
      paramChatMessage.leftMargin = i;
      paramChatMessage.rightMargin = 0;
      localahpk.jdField_a_of_type_AndroidWidgetTextView.setLayoutParams(paramChatMessage);
      paramChatMessage = (RelativeLayout.LayoutParams)localahpk.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
      paramChatMessage.leftMargin = bhgr.a(this.jdField_b_of_type_AndroidContentContext, localahpk.jdField_a_of_type_ComTencentMobileqqActivityAioItemQQStoryItemBuilder$StoryChatVideoView.a + 10);
      paramChatMessage.rightMargin = bhgr.a(this.jdField_b_of_type_AndroidContentContext, 10);
      localahpk.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams(paramChatMessage);
      paramChatMessage = (RelativeLayout.LayoutParams)localahpk.jdField_b_of_type_AndroidWidgetImageView.getLayoutParams();
      paramChatMessage.leftMargin = i;
      paramChatMessage.rightMargin = 0;
      localahpk.jdField_b_of_type_AndroidWidgetImageView.setLayoutParams(paramChatMessage);
      return paramaggl;
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
      localahpk.jdField_a_of_type_AndroidViewViewGroup.setVisibility(8);
    }
    label1552:
    paramChatMessage = (RelativeLayout.LayoutParams)localahpk.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams();
    paramChatMessage.leftMargin = 0;
    paramChatMessage.rightMargin = i;
    localahpk.jdField_a_of_type_AndroidWidgetTextView.setLayoutParams(paramChatMessage);
    paramChatMessage = (RelativeLayout.LayoutParams)localahpk.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
    paramChatMessage.leftMargin = bhgr.a(this.jdField_b_of_type_AndroidContentContext, 10);
    paramChatMessage.rightMargin = bhgr.a(this.jdField_b_of_type_AndroidContentContext, localahpk.jdField_a_of_type_ComTencentMobileqqActivityAioItemQQStoryItemBuilder$StoryChatVideoView.a + 10);
    localahpk.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams(paramChatMessage);
    paramChatMessage = (RelativeLayout.LayoutParams)localahpk.jdField_b_of_type_AndroidWidgetImageView.getLayoutParams();
    paramChatMessage.leftMargin = 0;
    paramChatMessage.rightMargin = i;
    localahpk.jdField_b_of_type_AndroidWidgetImageView.setLayoutParams(paramChatMessage);
    return paramaggl;
  }
  
  public String a(ChatMessage paramChatMessage)
  {
    return paramChatMessage.getSummaryMsg();
  }
  
  public void a()
  {
    this.jdField_a_of_type_Wkv.a();
    if (this.jdField_f_of_type_Boolean)
    {
      ((wlb)wth.a(6)).a(15000L);
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
            if (bgrf.a(paramChatMessage) == null) {
              bool = true;
            }
            for (;;)
            {
              Object localObject2 = null;
              try
              {
                localObject1 = bhni.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_AndroidContentContext, localMessageForQQStory.msgAction);
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
                aean.b(this.jdField_b_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
                a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, "delete", (bhmr)localObject1, bool);
                if (localMessageForQQStory.type == 3) {
                  yup.a("mystory", "delete_obj_myday", 0, 0, new String[] { "", "", "", "" });
                }
              }
            }
          } while (localMessageForQQStory.type != 1);
          yup.a("mystory", "delete_obj", 0, 0, new String[] { "", "", "", "" });
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
          auxu.a((Activity)this.jdField_b_of_type_AndroidContentContext, paramChatMessage, 21);
          a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, "forward", (bhmr)localObject1, bool);
          if (localMessageForQQStory.type == 3) {
            yup.a("mystory", "forward_obj_myday", 0, 0, new String[] { "", "", "", "" });
          }
        } while (localMessageForQQStory.type != 1);
        yup.a("mystory", "forward_obj", 0, 0, new String[] { "", "", "", "" });
        return;
        super.a(paramChatMessage);
        a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, "withdraw", (bhmr)localObject1, bool);
        if (localMessageForQQStory.type == 3) {
          yup.a("mystory", "withdraw_obj_myday", 0, 0, new String[] { "", "", "", "" });
        }
      } while (localMessageForQQStory.type != 1);
      yup.a("mystory", "withdraw_obj", 0, 0, new String[] { "", "", "", "" });
      return;
      super.a(paramInt, paramContext, paramChatMessage);
      a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, "reply", (bhmr)localObject1, bool);
      if (localMessageForQQStory.type == 1)
      {
        yup.a("mystory", "reply_obj", 0, 0, new String[] { "", "", "", "" });
        return;
      }
    } while (localMessageForQQStory.type != 2);
    yup.a("ugc_video", "obj_reply", 0, 0, new String[] { "", "", "", "" });
  }
  
  public void a(ahpk paramahpk)
  {
    boolean bool = true;
    for (;;)
    {
      try
      {
        paramahpk = (MessageForQQStory)paramahpk.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
        if (QLog.isColorLevel()) {
          QLog.d("Q.qqstory.share", 2, "QQStoryItemBuilder onBubbleOnClick:" + paramahpk.toString());
        }
        if (bgrf.a(paramahpk) == null)
        {
          paramahpk = bhni.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_AndroidContentContext, paramahpk.msgAction);
          paramahpk.a();
          a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, "clk_play", paramahpk, bool);
          int i = this.h;
          String str = this.jdField_a_of_type_JavaLangString;
          if (this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem == null)
          {
            paramahpk = "";
            yup.a("video_game", "clk_gamevideo", 0, 0, new String[] { String.valueOf(i), "", str, paramahpk });
            return;
          }
          paramahpk = this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVid;
          continue;
        }
        bool = false;
      }
      catch (Exception paramahpk)
      {
        if (QLog.isColorLevel()) {
          QLog.w("Q.qqstory.share", 2, "QQStoryItemBuilder onBubbleOnClick exp:", paramahpk);
        }
        return;
      }
    }
  }
  
  public void a(ahpk paramahpk, long paramLong)
  {
    ((Activity)this.jdField_b_of_type_AndroidContentContext).runOnUiThread(new QQStoryItemBuilder.10(this, paramahpk, paramLong));
  }
  
  public void a(ahpk paramahpk, long paramLong, int paramInt1, int paramInt2, String paramString1, String paramString2)
  {
    b(paramahpk, paramLong, paramInt1, paramInt2, paramString1, paramString2);
    if (!bhjz.a().a(paramahpk.jdField_a_of_type_ComTencentMobileqqDataChatMessage, "share|auto_play"))
    {
      bhjz.a().a(paramahpk.jdField_a_of_type_ComTencentMobileqqDataChatMessage, "share|auto_play");
      if (!(paramahpk.jdField_a_of_type_ComTencentMobileqqDataChatMessage instanceof MessageForQQStory)) {
        break label188;
      }
      paramInt1 = ((MessageForQQStory)paramahpk.jdField_a_of_type_ComTencentMobileqqDataChatMessage).type;
      if (paramInt1 != 1) {
        break label91;
      }
      paramInt1 = 1;
    }
    label188:
    for (;;)
    {
      yup.a("share", "auto_play", paramInt1, 0, new String[0]);
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
  
  public void a(ahpk paramahpk, long paramLong, StoryVideoItem paramStoryVideoItem, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem = paramStoryVideoItem;
    boolean bool = StoryVideoItem.isPlayable(paramStoryVideoItem.mVid, true);
    if (QLog.isColorLevel()) {
      QLog.i("QQStoryItemBuilder", 2, "handleGetVideo: isPlayable =" + bool);
    }
    Object localObject;
    if (!bool) {
      if ((b(paramahpk.jdField_a_of_type_ComTencentMobileqqDataChatMessage)) || (paramBoolean))
      {
        ((Activity)this.jdField_b_of_type_AndroidContentContext).runOnUiThread(new QQStoryItemBuilder.5(this, paramahpk));
        if (QLog.isColorLevel()) {
          QLog.d("Q.qqstory.share", 2, "QQStoryItemBuilder handleGetVideo 1: wifi download");
        }
        localObject = new ArrayList();
        ((ArrayList)localObject).add(paramStoryVideoItem);
        this.jdField_a_of_type_Wkv.a((List)localObject);
        this.jdField_a_of_type_Wkv.a(paramStoryVideoItem.mVid);
        this.jdField_a_of_type_Ahpj.a(paramahpk, paramStoryVideoItem.mVid, paramLong);
      }
    }
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqstory.share", 2, "QQStoryItemBuilder handleGetVideo 2: no wifi");
      }
      ((Activity)this.jdField_b_of_type_AndroidContentContext).runOnUiThread(new QQStoryItemBuilder.6(this, paramahpk, paramLong, paramStoryVideoItem));
      return;
      String str = this.jdField_a_of_type_Wkv.a(paramStoryVideoItem.mVid);
      localObject = str;
      if (str != null)
      {
        localObject = str;
        if (str.startsWith("file://")) {
          localObject = str.substring(7);
        }
      }
    } while (!(this.jdField_b_of_type_AndroidContentContext instanceof Activity));
    ((Activity)this.jdField_b_of_type_AndroidContentContext).runOnUiThread(new QQStoryItemBuilder.7(this, (String)localObject, paramahpk, paramStoryVideoItem, paramLong, paramBoolean));
  }
  
  protected void a(ahpk paramahpk, ViewGroup paramViewGroup, boolean paramBoolean)
  {
    paramahpk.jdField_a_of_type_AndroidWidgetFrameLayout = new FrameLayout(this.jdField_b_of_type_AndroidContentContext);
    Object localObject = new TextView(this.jdField_b_of_type_AndroidContentContext);
    ((TextView)localObject).setBackgroundResource(2130842581);
    ((TextView)localObject).setTextSize(1, 12.0F);
    ((TextView)localObject).setTextColor(this.jdField_b_of_type_AndroidContentContext.getResources().getColor(2131167302));
    ((TextView)localObject).setIncludeFontPadding(false);
    ((TextView)localObject).setSingleLine();
    ((TextView)localObject).setGravity(16);
    ((TextView)localObject).setPadding(bhgr.a(this.jdField_b_of_type_AndroidContentContext, 5.0F), 0, bhgr.a(this.jdField_b_of_type_AndroidContentContext, 5.0F), 0);
    paramahpk.jdField_a_of_type_AndroidWidgetFrameLayout.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-2, -2);
    paramahpk.jdField_a_of_type_AndroidWidgetFrameLayout.addView((View)localObject, localLayoutParams);
    paramahpk.jdField_c_of_type_AndroidWidgetTextView = ((TextView)localObject);
    localObject = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject).addRule(3, 2131364423);
    ((RelativeLayout.LayoutParams)localObject).addRule(5, 2131364423);
    paramViewGroup.addView(paramahpk.jdField_a_of_type_AndroidWidgetFrameLayout, (ViewGroup.LayoutParams)localObject);
  }
  
  public void a(ahpk paramahpk, String paramString)
  {
    if ((!TextUtils.equals(paramString, paramahpk.jdField_b_of_type_JavaLangString)) || (paramahpk.jdField_a_of_type_ComTencentImageURLDrawable == null))
    {
      paramahpk.jdField_b_of_type_JavaLangString = paramString;
      paramahpk.jdField_a_of_type_ComTencentImageURLDrawable = null;
      if (TextUtils.isEmpty(paramString)) {}
    }
    while (!QLog.isColorLevel()) {
      try
      {
        paramahpk.jdField_a_of_type_ComTencentImageURLDrawable = URLDrawable.getDrawable(paramString, PAVideoView.a, PAVideoView.a);
        if (QLog.isColorLevel()) {
          QLog.e("QQStoryItemBuilder", 2, "checkCoverDrawable(): reload drawable, coverUrl=" + paramString + " holder=" + paramahpk.hashCode());
        }
        return;
      }
      catch (Exception localException)
      {
        while (!QLog.isColorLevel()) {}
        QLog.e("QQStoryItemBuilder", 2, "checkCoverDrawable():  getDrawable Exception, coverUrl=" + paramString + " holder=" + paramahpk.hashCode(), localException);
        return;
      }
    }
    QLog.e("QQStoryItemBuilder", 2, "checkCoverDrawable(): reuse drawable, coverUrl=" + paramString + " holder=" + paramahpk.hashCode());
  }
  
  public void a(ahpk paramahpk, String paramString, long paramLong, boolean paramBoolean)
  {
    xiz.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString, new ahpi(this, paramahpk, paramLong, paramBoolean));
  }
  
  public void a(ahpk paramahpk, String paramString1, String paramString2, long paramLong, boolean paramBoolean)
  {
    yuk.a("QQStoryItemBuilder", "setVideoView %s vid %s", paramString1, paramString2);
    ThreadManager.post(new QQStoryItemBuilder.8(this, paramString2, paramahpk, paramLong, paramString1, paramBoolean), 8, null, true);
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    Object localObject = agej.a(paramView);
    if (!ahpk.class.isInstance(localObject)) {}
    String str1;
    String str2;
    do
    {
      return;
      paramView = this.jdField_b_of_type_AndroidContentContext;
      localObject = ((ahpk)localObject).jdField_a_of_type_ComTencentMobileqqDataChatMessage;
      str1 = paramView.getString(2131689933);
      str2 = paramView.getString(2131689934);
    } while (!((ChatMessage)localObject).isSendFromLocal());
    bhlq.a(paramView, 230, str1, str2, new ahpf(this, paramView, (ChatMessage)localObject), new ahpg(this)).show();
  }
  
  public void a(View paramView, ChatMessage paramChatMessage)
  {
    int i = this.jdField_b_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131296338);
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
    ahpk localahpk = (ahpk)paramViewGroup.getTag();
    boolean bool = localMessageForQQStory.isSend();
    if (localahpk.jdField_a_of_type_AndroidWidgetFrameLayout == null) {
      a(localahpk, paramViewGroup, bool);
    }
    paramViewGroup = (FrameLayout.LayoutParams)localahpk.jdField_c_of_type_AndroidWidgetTextView.getLayoutParams();
    if (bool)
    {
      paramViewGroup.leftMargin = BaseChatItemLayout.k;
      localahpk.jdField_c_of_type_AndroidWidgetTextView.setLayoutParams(paramViewGroup);
      localahpk.jdField_a_of_type_AndroidWidgetTextView.setText(localMessageForQQStory.brief);
      localahpk.jdField_c_of_type_AndroidWidgetTextView.setText(localMessageForQQStory.srcName);
      if ((localMessageForQQStory.type != 3) && (localMessageForQQStory.type != 5) && (localMessageForQQStory.type != 8) && (localMessageForQQStory.type != 9)) {
        break label346;
      }
      localahpk.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      localahpk.jdField_b_of_type_AndroidWidgetTextView.setText(anzj.a(2131709782));
      label161:
      localahpk.jdField_a_of_type_ComTencentBizQqstoryViewWidgetAutoStartProgressBar.setCornerDirection(paramChatMessage.isSend());
      if ((!TextUtils.isEmpty(localMessageForQQStory.mVid)) && (bcyh.b)) {
        break label422;
      }
      localahpk.jdField_a_of_type_Boolean = false;
      localahpk.jdField_a_of_type_ComTencentBizQqstoryViewWidgetAutoStartProgressBar.setDrawStatus(2);
      localahpk.jdField_a_of_type_ComTencentBizQqstoryViewWidgetAutoStartProgressBar.setVisibility(0);
      a(localahpk.jdField_a_of_type_ComTencentMobileqqActivityAioItemQQStoryItemBuilder$StoryChatVideoView, localMessageForQQStory.coverImgUrl, this.c, this.d, this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
      a(localahpk.jdField_a_of_type_AndroidWidgetImageView, localMessageForQQStory.logoImgUrl, this.e, this.jdField_f_of_type_Int, this.jdField_b_of_type_AndroidGraphicsDrawableDrawable);
      localahpk.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setImageDrawable(null);
    }
    for (;;)
    {
      try
      {
        paramViewGroup = bhni.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_AndroidContentContext, localMessageForQQStory.msgAction);
        if (bgrf.a(localMessageForQQStory) != null) {
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
      paramViewGroup.leftMargin = (bhgr.a(this.jdField_b_of_type_AndroidContentContext, localahpk.jdField_a_of_type_ComTencentMobileqqActivityAioItemQQStoryItemBuilder$StoryChatVideoView.a) + BaseChatItemLayout.j);
      break;
      if (localMessageForQQStory.type == 11)
      {
        localahpk.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
        if (!TextUtils.isEmpty(localMessageForQQStory.mHeadTip))
        {
          localahpk.jdField_b_of_type_AndroidWidgetTextView.setText(localMessageForQQStory.mHeadTip);
          break label161;
        }
        localahpk.jdField_b_of_type_AndroidWidgetTextView.setText(anzj.a(2131709781));
        break label161;
      }
      localahpk.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      break label161;
      paramViewGroup = (Long)localahpk.jdField_a_of_type_ComTencentMobileqqActivityAioItemQQStoryItemBuilder$StoryChatVideoView.getTag();
      paramChatMessage = ((wte)wth.a(5)).a(localMessageForQQStory.mVid);
      if ((paramViewGroup == null) || (paramViewGroup.longValue() != localMessageForQQStory.uniseq))
      {
        localahpk.jdField_a_of_type_Boolean = false;
        localahpk.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setImageDrawable(null);
        a(localahpk.jdField_a_of_type_ComTencentMobileqqActivityAioItemQQStoryItemBuilder$StoryChatVideoView, localMessageForQQStory.coverImgUrl, this.c, this.d, this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
        if (paramChatMessage != null)
        {
          b(localahpk, localMessageForQQStory.uniseq, paramChatMessage, false);
          c(localahpk, localMessageForQQStory.uniseq, paramChatMessage, false);
        }
        a(localahpk, localMessageForQQStory.coverImgUrl, localMessageForQQStory.mVid, localMessageForQQStory.uniseq, false);
        localahpk.jdField_a_of_type_ComTencentMobileqqActivityAioItemQQStoryItemBuilder$StoryChatVideoView.setTag(Long.valueOf(localMessageForQQStory.uniseq));
      }
      else if (paramChatMessage != null)
      {
        b(localahpk, localMessageForQQStory.uniseq, paramChatMessage, false);
        c(localahpk, localMessageForQQStory.uniseq, paramChatMessage, false);
        continue;
        bool = false;
      }
    }
  }
  
  public bhum[] a(View paramView)
  {
    bhuk localbhuk = new bhuk();
    paramView = agej.a(paramView);
    boolean bool;
    if (bgrf.a(paramView) == null) {
      bool = true;
    }
    for (;;)
    {
      localbhuk.a(2131367078, this.jdField_b_of_type_AndroidContentContext.getString(2131692400), 2130838939);
      a(paramView, localbhuk);
      if ((paramView.isSend()) && (paramView.extraflag != 32768) && (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(paramView))) {
        a(localbhuk, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, paramView);
      }
      a(localbhuk, paramView);
      b(paramView, localbhuk);
      try
      {
        paramView = (MessageForQQStory)paramView;
        paramView = bhni.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_AndroidContentContext, paramView.msgAction);
        a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, "press", paramView, bool);
        super.e(localbhuk, this.jdField_b_of_type_AndroidContentContext);
        return localbhuk.a();
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
  
  public void b(ahpk paramahpk)
  {
    for (;;)
    {
      try
      {
        paramahpk = (MessageForQQStory)paramahpk.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
        if (QLog.isColorLevel()) {
          QLog.d("Q.qqstory.share", 2, "QQStoryItemBuilder onSourceOnClick:" + paramahpk.toString());
        }
        if (bgrf.a(paramahpk) == null)
        {
          bool = true;
          bhni.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_AndroidContentContext, paramahpk.srcAction).a();
          paramahpk = bhni.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_AndroidContentContext, paramahpk.msgAction);
          a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, "clk_tail", paramahpk, bool);
          return;
        }
      }
      catch (Exception paramahpk)
      {
        boolean bool;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.w("Q.qqstory.share", 2, "QQStoryItemBuilder onSourceOnClick exp:", paramahpk);
      }
      bool = false;
    }
  }
  
  public void b(ahpk paramahpk, long paramLong, int paramInt1, int paramInt2, String paramString1, String paramString2)
  {
    paramString1 = a(paramInt1, paramInt2, paramLong, paramString1, paramString2);
    paramString2 = URLDrawable.URLDrawableOptions.obtain();
    paramString2.mExtraInfo = paramString1;
    paramString2.mLoadingDrawable = a(paramahpk, paramString1.mCoverUrl);
    paramString1 = URLDrawable.getDrawable(PAVideoView.a(paramLong), paramString2);
    paramahpk.jdField_a_of_type_ComTencentMobileqqActivityAioItemQQStoryItemBuilder$StoryChatVideoView.setImageDrawable(paramString1);
  }
  
  public void b(ahpk paramahpk, long paramLong, StoryVideoItem paramStoryVideoItem, boolean paramBoolean)
  {
    yuk.c("QQStoryItemBuilder", "updateStoryPollLayout");
    String str = paramStoryVideoItem.getPollDescription();
    if (TextUtils.equals(str, (String)paramahpk.jdField_b_of_type_ComTencentMobileqqWidgetBubbleImageView.getTag()))
    {
      yuk.b("QQStoryItemBuilder", "updateStoryPollLayout no need refresh, it is already %s", str);
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
      paramahpk.jdField_b_of_type_ComTencentMobileqqWidgetBubbleImageView.setImageDrawable(new BitmapDrawable(this.jdField_b_of_type_AndroidContentContext.getResources(), paramStoryVideoItem));
      paramahpk.jdField_b_of_type_ComTencentMobileqqWidgetBubbleImageView.setVisibility(0);
    }
    for (;;)
    {
      paramahpk.jdField_b_of_type_ComTencentMobileqqWidgetBubbleImageView.setTag(str);
      return;
      paramahpk.jdField_b_of_type_ComTencentMobileqqWidgetBubbleImageView.setVisibility(4);
    }
  }
  
  protected boolean b(MessageRecord paramMessageRecord)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 2) {}
    while (NetConnInfoCenter.getServerTimeMillis() - paramMessageRecord.time * 1000L > bcxf.jdField_a_of_type_Long) {
      return false;
    }
    return bhnv.h(this.jdField_b_of_type_AndroidContentContext);
  }
  
  public void c(ahpk paramahpk, long paramLong, StoryVideoItem paramStoryVideoItem, boolean paramBoolean)
  {
    yuk.c("QQStoryItemBuilder", "updateStoryInteractLayout");
    String str = paramStoryVideoItem.getInteractDescription();
    if (TextUtils.equals(str, (String)paramahpk.jdField_c_of_type_ComTencentMobileqqWidgetBubbleImageView.getTag()))
    {
      yuk.b("QQStoryItemBuilder", "updateStoryInteractLayout no need refresh, it is already %s", str);
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
      paramahpk.jdField_c_of_type_ComTencentMobileqqWidgetBubbleImageView.setImageDrawable(new BitmapDrawable(this.jdField_b_of_type_AndroidContentContext.getResources(), paramStoryVideoItem));
      paramahpk.jdField_c_of_type_ComTencentMobileqqWidgetBubbleImageView.setVisibility(0);
    }
    for (;;)
    {
      paramahpk.jdField_c_of_type_ComTencentMobileqqWidgetBubbleImageView.setTag(str);
      return;
      paramahpk.jdField_c_of_type_ComTencentMobileqqWidgetBubbleImageView.setVisibility(4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.QQStoryItemBuilder
 * JD-Core Version:    0.7.0.1
 */