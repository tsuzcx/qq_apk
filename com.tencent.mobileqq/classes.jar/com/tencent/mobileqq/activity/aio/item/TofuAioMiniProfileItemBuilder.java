package com.tencent.mobileqq.activity.aio.item;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.av.utils.UITools;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivity.Launcher;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.AbstractChatItemBuilder;
import com.tencent.mobileqq.activity.aio.AbstractChatItemBuilder.ViewHolder;
import com.tencent.mobileqq.activity.aio.OnLongClickAndTouchListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.item.view.AioMiniProfileLabelFlowLayout;
import com.tencent.mobileqq.adapter.AioMiniProfileLabelListAdapter;
import com.tencent.mobileqq.adapter.PictureAdapter;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.avatar.api.IQQAvatarService;
import com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarView;
import com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener;
import com.tencent.mobileqq.data.MessageForTofuAioMiniProfile;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.profilecard.bussiness.anonymous.bean.AnonymousQuestion;
import com.tencent.mobileqq.profilecard.bussiness.anonymous.constant.AnonymousConstant;
import com.tencent.mobileqq.profilecard.bussiness.anonymous.handler.AnonymousHandler;
import com.tencent.mobileqq.profilecard.bussiness.anonymous.handler.AnonymousObserver;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.utils.ProfileUtils;
import com.tencent.mobileqq.relationx.icebreaking.bean.MiniCard;
import com.tencent.mobileqq.relationx.icebreaking.bean.MiniCard.BaseProfile;
import com.tencent.mobileqq.relationx.icebreaking.bean.MiniCard.NicePicInfo;
import com.tencent.mobileqq.relationx.icebreaking.bean.MiniCard.QZoneInfo;
import com.tencent.mobileqq.relationx.icebreaking.bean.MiniCard.Sign;
import com.tencent.mobileqq.richstatus.SignatureHistoryFragment;
import com.tencent.mobileqq.richstatus.StatusManager;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenuItem;
import com.tencent.mobileqq.vas.avatar.AvatarLayout;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.widget.RoundCorneredRelativeLayout;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QZoneHelper.UserInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class TofuAioMiniProfileItemBuilder
  extends AbstractChatItemBuilder
  implements View.OnClickListener, DecodeTaskCompletionListener
{
  private int jdField_a_of_type_Int;
  private IFaceDecoder jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder;
  private AnonymousObserver jdField_a_of_type_ComTencentMobileqqProfilecardBussinessAnonymousHandlerAnonymousObserver = new TofuAioMiniProfileItemBuilder.7(this);
  private String jdField_a_of_type_JavaLangString;
  private Map<String, ImageView> jdField_a_of_type_JavaUtilMap = new HashMap();
  
  public TofuAioMiniProfileItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo);
    this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder = ((IQQAvatarService)paramQQAppInterface.getRuntimeService(IQQAvatarService.class, "")).getInstance(paramQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.setDecodeTaskCompletionListener(this);
    double d1 = Math.random();
    double d2 = AnonymousConstant.HEAD_BG_COLOR.length;
    Double.isNaN(d2);
    this.jdField_a_of_type_Int = ((int)(d1 * d2));
    a(paramQQAppInterface);
    paramQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqProfilecardBussinessAnonymousHandlerAnonymousObserver);
  }
  
  private View a(View paramView, TofuAioMiniProfileItemBuilder.Holder paramHolder)
  {
    View localView = paramView;
    if (paramView == null)
    {
      localView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558831, null);
      TofuAioMiniProfileItemBuilder.Holder.a(paramHolder, (RoundCorneredRelativeLayout)localView.findViewById(2131376666));
      TofuAioMiniProfileItemBuilder.Holder.a(paramHolder, (ViewGroup)localView.findViewById(2131376760));
      TofuAioMiniProfileItemBuilder.Holder.a(paramHolder, (TextView)localView.findViewById(2131379699));
      TofuAioMiniProfileItemBuilder.Holder.b(paramHolder, (TextView)localView.findViewById(2131379509));
      TofuAioMiniProfileItemBuilder.Holder.c(paramHolder, (TextView)localView.findViewById(2131379763));
      TofuAioMiniProfileItemBuilder.Holder.b(paramHolder, (ViewGroup)localView.findViewById(2131370229));
      TofuAioMiniProfileItemBuilder.Holder.a(paramHolder, localView.findViewById(2131365761));
      TofuAioMiniProfileItemBuilder.Holder.b(paramHolder, localView.findViewById(2131365762));
      TofuAioMiniProfileItemBuilder.Holder.d(paramHolder, (TextView)localView.findViewById(2131379886));
      TofuAioMiniProfileItemBuilder.Holder.e(paramHolder, (TextView)localView.findViewById(2131379592));
      TofuAioMiniProfileItemBuilder.Holder.c(paramHolder, localView.findViewById(2131365763));
      TofuAioMiniProfileItemBuilder.Holder.c(paramHolder, (ViewGroup)localView.findViewById(2131370230));
      TofuAioMiniProfileItemBuilder.Holder.a(paramHolder, (AvatarLayout)localView.findViewById(2131362552));
      TofuAioMiniProfileItemBuilder.Holder.a(paramHolder, (DynamicAvatarView)localView.findViewById(2131365426));
      TofuAioMiniProfileItemBuilder.Holder.a(paramHolder, (AioMiniProfileLabelFlowLayout)localView.findViewById(2131366924));
      TofuAioMiniProfileItemBuilder.Holder.d(paramHolder, localView.findViewById(2131365767));
      TofuAioMiniProfileItemBuilder.Holder.a(paramHolder, (FrameLayout)localView.findViewById(2131366901));
      TofuAioMiniProfileItemBuilder.Holder.d(paramHolder, (ViewGroup)localView.findViewById(2131370318));
      TofuAioMiniProfileItemBuilder.Holder.f(paramHolder, (TextView)localView.findViewById(2131379930));
      TofuAioMiniProfileItemBuilder.Holder.a(paramHolder, (GridView)localView.findViewById(2131367938));
      TofuAioMiniProfileItemBuilder.Holder.g(paramHolder, (TextView)localView.findViewById(2131379882));
      TofuAioMiniProfileItemBuilder.Holder.e(paramHolder, (ViewGroup)localView.findViewById(2131370292));
      TofuAioMiniProfileItemBuilder.Holder.a(paramHolder, (ImageView)localView.findViewById(2131374154));
      TofuAioMiniProfileItemBuilder.Holder.b(paramHolder, (ImageView)localView.findViewById(2131374152));
      TofuAioMiniProfileItemBuilder.Holder.c(paramHolder, (ImageView)localView.findViewById(2131374153));
      TofuAioMiniProfileItemBuilder.Holder.h(paramHolder, (TextView)localView.findViewById(2131374167));
      TofuAioMiniProfileItemBuilder.Holder.d(paramHolder, (ImageView)localView.findViewById(2131374147));
      TofuAioMiniProfileItemBuilder.Holder.e(paramHolder, (ImageView)localView.findViewById(2131374148));
      TofuAioMiniProfileItemBuilder.Holder.i(paramHolder, (TextView)localView.findViewById(2131374163));
    }
    return localView;
  }
  
  private void a(TofuAioMiniProfileItemBuilder.Holder paramHolder, QQAppInterface paramQQAppInterface)
  {
    if (paramHolder != null)
    {
      if (paramQQAppInterface == null) {
        return;
      }
      int i = Color.parseColor("#FCFCFC");
      int j = Color.parseColor("#03081A");
      int k = Color.parseColor("#878B99");
      int m = Color.parseColor("#EFEFEF");
      int n = Color.parseColor("#FFFFFF");
      int i1 = Color.parseColor("#FAFAFD");
      int i2 = Color.parseColor("#FFFFFF");
      int i3 = Color.parseColor("#838383");
      int i4 = Color.parseColor("#000000");
      int i5 = Color.parseColor("#1F1F1F");
      int i6 = Color.parseColor("#1C1C1E");
      if (ThemeUtil.isNowThemeIsNight(paramQQAppInterface, false, null))
      {
        TofuAioMiniProfileItemBuilder.Holder.a(paramHolder).setTextColor(i2);
        TofuAioMiniProfileItemBuilder.Holder.b(paramHolder).setTextColor(i2);
        TofuAioMiniProfileItemBuilder.Holder.c(paramHolder).setTextColor(i2);
        TofuAioMiniProfileItemBuilder.Holder.d(paramHolder).setTextColor(i3);
        TofuAioMiniProfileItemBuilder.Holder.e(paramHolder).setTextColor(i3);
        TofuAioMiniProfileItemBuilder.Holder.f(paramHolder).setTextColor(i3);
        TofuAioMiniProfileItemBuilder.Holder.g(paramHolder).setTextColor(i2);
        TofuAioMiniProfileItemBuilder.Holder.a(paramHolder).setBackgroundColor(i4);
        TofuAioMiniProfileItemBuilder.Holder.e(paramHolder).setBackgroundColor(i5);
        TofuAioMiniProfileItemBuilder.Holder.a(paramHolder).setBackgroundColor(i6);
        TofuAioMiniProfileItemBuilder.Holder.h(paramHolder).setTextColor(i3);
        TofuAioMiniProfileItemBuilder.Holder.i(paramHolder).setTextColor(i2);
      }
      else
      {
        TofuAioMiniProfileItemBuilder.Holder.a(paramHolder).setTextColor(j);
        TofuAioMiniProfileItemBuilder.Holder.b(paramHolder).setTextColor(j);
        TofuAioMiniProfileItemBuilder.Holder.c(paramHolder).setTextColor(j);
        TofuAioMiniProfileItemBuilder.Holder.d(paramHolder).setTextColor(k);
        TofuAioMiniProfileItemBuilder.Holder.e(paramHolder).setTextColor(k);
        TofuAioMiniProfileItemBuilder.Holder.f(paramHolder).setTextColor(k);
        TofuAioMiniProfileItemBuilder.Holder.g(paramHolder).setTextColor(j);
        TofuAioMiniProfileItemBuilder.Holder.a(paramHolder).setBackgroundColor(m);
        TofuAioMiniProfileItemBuilder.Holder.e(paramHolder).setBackgroundColor(n);
        TofuAioMiniProfileItemBuilder.Holder.a(paramHolder).setBackgroundColor(i1);
        TofuAioMiniProfileItemBuilder.Holder.h(paramHolder).setTextColor(k);
        TofuAioMiniProfileItemBuilder.Holder.i(paramHolder).setTextColor(j);
      }
      if ((ThemeUtil.isSimpleDayTheme(false)) && (!ThemeUtil.isNowThemeIsNight(paramQQAppInterface, false, null))) {
        if (Build.VERSION.SDK_INT >= 21)
        {
          if (this.jdField_a_of_type_AndroidContentContext != null) {
            TofuAioMiniProfileItemBuilder.Holder.a(paramHolder).setBackground(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130851149));
          }
        }
        else {
          TofuAioMiniProfileItemBuilder.Holder.e(paramHolder).setBackgroundColor(i);
        }
      }
      if (SimpleUIUtil.a())
      {
        TofuAioMiniProfileItemBuilder.Holder.b(paramHolder).setImageResource(2130845915);
        TofuAioMiniProfileItemBuilder.Holder.c(paramHolder).setImageResource(2130845912);
        TofuAioMiniProfileItemBuilder.Holder.d(paramHolder).setImageResource(2130845914);
        TofuAioMiniProfileItemBuilder.Holder.e(paramHolder).setImageResource(2130845900);
      }
      else
      {
        TofuAioMiniProfileItemBuilder.Holder.b(paramHolder).setImageResource(2130845910);
        TofuAioMiniProfileItemBuilder.Holder.c(paramHolder).setImageResource(2130845911);
        TofuAioMiniProfileItemBuilder.Holder.d(paramHolder).setImageResource(2130845913);
        TofuAioMiniProfileItemBuilder.Holder.e(paramHolder).setImageResource(2130845899);
      }
      i = this.jdField_a_of_type_Int;
      j = AnonymousConstant.HEAD_BG_COLOR.length;
      TofuAioMiniProfileItemBuilder.Holder.c(paramHolder).clearColorFilter();
      TofuAioMiniProfileItemBuilder.Holder.c(paramHolder).setColorFilter(AnonymousConstant.HEAD_BG_COLOR[(i % j)]);
    }
  }
  
  private void a(TofuAioMiniProfileItemBuilder.Holder paramHolder, AnonymousQuestion paramAnonymousQuestion)
  {
    TofuAioMiniProfileItemBuilder.Holder.a(paramHolder).setVisibility(0);
    TofuAioMiniProfileItemBuilder.Holder.a(paramHolder).setVisibility(0);
    TofuAioMiniProfileItemBuilder.Holder.d(paramHolder).setVisibility(0);
    TofuAioMiniProfileItemBuilder.Holder.h(paramHolder).setText(paramAnonymousQuestion.mQuest);
    TofuAioMiniProfileItemBuilder.Holder.a(paramHolder).setImageBitmap(a(paramHolder.jdField_a_of_type_JavaLangString, TofuAioMiniProfileItemBuilder.Holder.a(paramHolder)));
    TofuAioMiniProfileItemBuilder.Holder.i(paramHolder).setText(paramAnonymousQuestion.mAnswer);
    TofuAioMiniProfileItemBuilder.Holder.c(paramHolder).setVisibility(8);
    TofuAioMiniProfileItemBuilder.Holder.g(paramHolder).setVisibility(8);
    TofuAioMiniProfileItemBuilder.Holder.d(paramHolder).setOnClickListener(new TofuAioMiniProfileItemBuilder.5(this, paramHolder));
  }
  
  private void a(TofuAioMiniProfileItemBuilder.Holder paramHolder, MiniCard.BaseProfile paramBaseProfile)
  {
    if (paramBaseProfile == null)
    {
      TofuAioMiniProfileItemBuilder.Holder.a(paramHolder).setVisibility(8);
      return;
    }
    TofuAioMiniProfileItemBuilder.Holder.a(paramHolder).setVisibility(0);
    int i = paramBaseProfile.jdField_b_of_type_Int;
    int m = 1;
    if ((i != 1) && (paramBaseProfile.jdField_b_of_type_Int != 2))
    {
      TofuAioMiniProfileItemBuilder.Holder.a(paramHolder).setVisibility(8);
      i = 0;
    }
    else
    {
      TofuAioMiniProfileItemBuilder.Holder.a(paramHolder).setVisibility(0);
      TextView localTextView = TofuAioMiniProfileItemBuilder.Holder.a(paramHolder);
      if (paramBaseProfile.jdField_b_of_type_Int == 1) {
        i = 2131693879;
      } else {
        i = 2131692259;
      }
      localTextView.setText(i);
      i = 1;
    }
    int j;
    if (paramBaseProfile.jdField_a_of_type_Int >= 0)
    {
      TofuAioMiniProfileItemBuilder.Holder.b(paramHolder).setVisibility(0);
      TofuAioMiniProfileItemBuilder.Holder.b(paramHolder).setText(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131689951, new Object[] { Integer.valueOf(paramBaseProfile.jdField_a_of_type_Int) }));
      j = 1;
    }
    else
    {
      TofuAioMiniProfileItemBuilder.Holder.b(paramHolder).setVisibility(8);
      j = 0;
    }
    int k;
    if (!TextUtils.isEmpty(paramBaseProfile.jdField_a_of_type_JavaLangString))
    {
      TofuAioMiniProfileItemBuilder.Holder.c(paramHolder).setVisibility(0);
      TofuAioMiniProfileItemBuilder.Holder.c(paramHolder).setText(paramBaseProfile.jdField_a_of_type_JavaLangString);
      k = 1;
    }
    else
    {
      TofuAioMiniProfileItemBuilder.Holder.c(paramHolder).setVisibility(8);
      k = 0;
    }
    i = i + j + k;
    if (i == 3)
    {
      TofuAioMiniProfileItemBuilder.Holder.b(paramHolder).setVisibility(0);
      TofuAioMiniProfileItemBuilder.Holder.c(paramHolder).setVisibility(0);
    }
    else if (i == 2)
    {
      if ((j == 1) && (k == 1))
      {
        TofuAioMiniProfileItemBuilder.Holder.b(paramHolder).setVisibility(8);
        TofuAioMiniProfileItemBuilder.Holder.c(paramHolder).setVisibility(0);
      }
      else
      {
        TofuAioMiniProfileItemBuilder.Holder.b(paramHolder).setVisibility(0);
        TofuAioMiniProfileItemBuilder.Holder.c(paramHolder).setVisibility(8);
      }
    }
    else if (i == 1)
    {
      TofuAioMiniProfileItemBuilder.Holder.b(paramHolder).setVisibility(8);
      TofuAioMiniProfileItemBuilder.Holder.c(paramHolder).setVisibility(8);
    }
    else
    {
      TofuAioMiniProfileItemBuilder.Holder.b(paramHolder).setVisibility(8);
      TofuAioMiniProfileItemBuilder.Holder.c(paramHolder).setVisibility(8);
      TofuAioMiniProfileItemBuilder.Holder.b(paramHolder).setVisibility(8);
    }
    if (!TextUtils.isEmpty(paramBaseProfile.jdField_b_of_type_JavaLangString))
    {
      TofuAioMiniProfileItemBuilder.Holder.d(paramHolder).setText(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131689950, new Object[] { paramBaseProfile.jdField_b_of_type_JavaLangString }));
      i = 1;
    }
    else
    {
      TofuAioMiniProfileItemBuilder.Holder.d(paramHolder).setVisibility(8);
      i = 0;
    }
    if (paramBaseProfile.c > 0)
    {
      TofuAioMiniProfileItemBuilder.Holder.e(paramHolder).setText(String.format(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131689691), new Object[] { Integer.valueOf(paramBaseProfile.c) }));
      j = m;
    }
    else
    {
      TofuAioMiniProfileItemBuilder.Holder.e(paramHolder).setVisibility(8);
      j = 0;
    }
    if ((j != 0) && (i != 0))
    {
      TofuAioMiniProfileItemBuilder.Holder.d(paramHolder).setVisibility(0);
      return;
    }
    TofuAioMiniProfileItemBuilder.Holder.d(paramHolder).setVisibility(8);
  }
  
  private void a(TofuAioMiniProfileItemBuilder.Holder paramHolder, MiniCard.QZoneInfo paramQZoneInfo)
  {
    TofuAioMiniProfileItemBuilder.Holder.a(paramHolder).setVisibility(0);
    TofuAioMiniProfileItemBuilder.Holder.a(paramHolder).setVisibility(0);
    TofuAioMiniProfileItemBuilder.Holder.c(paramHolder).setVisibility(0);
    TextView localTextView = TofuAioMiniProfileItemBuilder.Holder.f(paramHolder);
    String str;
    if (TextUtils.isEmpty(paramQZoneInfo.jdField_a_of_type_JavaLangString)) {
      str = this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131716548);
    } else {
      str = paramQZoneInfo.jdField_a_of_type_JavaLangString;
    }
    localTextView.setText(str);
    if (TofuAioMiniProfileItemBuilder.Holder.a(paramHolder) != null)
    {
      if (TofuAioMiniProfileItemBuilder.Holder.a(paramHolder).a(paramQZoneInfo.jdField_a_of_type_JavaUtilList)) {
        return;
      }
      TofuAioMiniProfileItemBuilder.Holder.a(paramHolder).a(false);
      TofuAioMiniProfileItemBuilder.Holder.a(paramHolder).a();
    }
    else
    {
      TofuAioMiniProfileItemBuilder.Holder.a(paramHolder, new PictureAdapter(this.jdField_a_of_type_AndroidContentContext, false));
    }
    TofuAioMiniProfileItemBuilder.Holder.a(paramHolder).a(paramQZoneInfo.jdField_a_of_type_JavaUtilList);
    TofuAioMiniProfileItemBuilder.Holder.a(paramHolder).setAdapter(TofuAioMiniProfileItemBuilder.Holder.a(paramHolder));
    TofuAioMiniProfileItemBuilder.Holder.a(paramHolder).setClickable(false);
    TofuAioMiniProfileItemBuilder.Holder.a(paramHolder).setEnabled(false);
    TofuAioMiniProfileItemBuilder.Holder.a(paramHolder).setOnTouchListener(UITools.a);
    TofuAioMiniProfileItemBuilder.Holder.a(paramHolder).setOnClickListener(new TofuAioMiniProfileItemBuilder.2(this));
    TofuAioMiniProfileItemBuilder.Holder.g(paramHolder).setVisibility(8);
    TofuAioMiniProfileItemBuilder.Holder.d(paramHolder).setVisibility(8);
  }
  
  private void a(TofuAioMiniProfileItemBuilder.Holder paramHolder, MiniCard.Sign paramSign)
  {
    TofuAioMiniProfileItemBuilder.Holder.a(paramHolder).setVisibility(0);
    TofuAioMiniProfileItemBuilder.Holder.a(paramHolder).setVisibility(0);
    TofuAioMiniProfileItemBuilder.Holder.g(paramHolder).setVisibility(0);
    if (paramSign.jdField_a_of_type_Int != 0)
    {
      localObject = ((StatusManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.STATUS_MANAGER)).a(paramSign.jdField_a_of_type_Int, 200);
      localObject = new BitmapDrawable(this.jdField_a_of_type_AndroidContentContext.getResources(), (Bitmap)localObject);
      int i = AIOUtils.b(12.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      ((Drawable)localObject).setBounds(0, 0, Math.round(((Drawable)localObject).getIntrinsicWidth() * 1.0F / ((Drawable)localObject).getIntrinsicHeight() * i), i);
    }
    else
    {
      localObject = null;
    }
    TofuAioMiniProfileItemBuilder.Holder.g(paramHolder).setCompoundDrawables((Drawable)localObject, null, null, null);
    Object localObject = TofuAioMiniProfileItemBuilder.Holder.g(paramHolder);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramSign.jdField_a_of_type_JavaLangString);
    localStringBuilder.append(" ");
    localStringBuilder.append(paramSign.jdField_b_of_type_JavaLangString);
    ((TextView)localObject).setText(localStringBuilder.toString());
    TofuAioMiniProfileItemBuilder.Holder.a(paramHolder).setOnTouchListener(UITools.a);
    TofuAioMiniProfileItemBuilder.Holder.a(paramHolder).setOnClickListener(new TofuAioMiniProfileItemBuilder.4(this));
    TofuAioMiniProfileItemBuilder.Holder.c(paramHolder).setVisibility(8);
    TofuAioMiniProfileItemBuilder.Holder.d(paramHolder).setVisibility(8);
  }
  
  private void a(TofuAioMiniProfileItemBuilder.Holder paramHolder, boolean paramBoolean)
  {
    paramHolder = TofuAioMiniProfileItemBuilder.Holder.a(paramHolder).getLayoutParams();
    if (paramBoolean)
    {
      paramHolder.height = -2;
      return;
    }
    paramHolder.height = ViewUtils.a(60.0F);
  }
  
  private void a(QQAppInterface paramQQAppInterface)
  {
    ThreadManager.post(new TofuAioMiniProfileItemBuilder.6(this), 8, null, false);
  }
  
  private void b()
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("gotoSignatureHistory and uin:");
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null) {
        localObject = "null";
      } else {
        localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
      }
      localStringBuilder.append((String)localObject);
      localStringBuilder.append(" mContext:");
      localStringBuilder.append(this.jdField_a_of_type_AndroidContentContext);
      QLog.i("TofuAioMiniProfileItemBuilder", 2, localStringBuilder.toString());
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)))
    {
      if (this.jdField_a_of_type_AndroidContentContext == null) {
        return;
      }
      localObject = new Intent(this.jdField_a_of_type_AndroidContentContext, PublicFragmentActivity.class);
      ((Intent)localObject).putExtra("key_uin", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      ((Intent)localObject).putExtra("key_uin_name", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d);
      ((Intent)localObject).putExtra("key_open_via", "history-liaotian");
      PublicFragmentActivity.Launcher.a(this.jdField_a_of_type_AndroidContentContext, (Intent)localObject, PublicFragmentActivity.class, SignatureHistoryFragment.class);
    }
  }
  
  private void b(TofuAioMiniProfileItemBuilder.Holder paramHolder, List<String> paramList)
  {
    if ((paramList != null) && (paramList.size() != 0))
    {
      TofuAioMiniProfileItemBuilder.Holder.a(paramHolder).setVisibility(0);
      if (TofuAioMiniProfileItemBuilder.Holder.a(paramHolder) != null) {
        TofuAioMiniProfileItemBuilder.Holder.a(paramHolder).a();
      } else {
        TofuAioMiniProfileItemBuilder.Holder.a(paramHolder, new AioMiniProfileLabelListAdapter(this.jdField_a_of_type_AndroidContentContext));
      }
      TofuAioMiniProfileItemBuilder.Holder.a(paramHolder).a(paramList);
      TofuAioMiniProfileItemBuilder.Holder.a(paramHolder).setAdapter(TofuAioMiniProfileItemBuilder.Holder.a(paramHolder));
      a(paramHolder, true);
      return;
    }
    TofuAioMiniProfileItemBuilder.Holder.a(paramHolder).setVisibility(8);
    a(paramHolder, false);
  }
  
  private void b(String paramString, TofuAioMiniProfileItemBuilder.Holder paramHolder)
  {
    TofuAioMiniProfileItemBuilder.Holder.a(paramHolder).a(0, TofuAioMiniProfileItemBuilder.Holder.a(paramHolder), false);
    if ((paramString != null) && (paramString.length() != 0))
    {
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFaceBitmapCacheKey(1, paramString, (byte)3, 0, 100, true);
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBitmapFromCache((String)localObject);
      if (localObject != null) {
        TofuAioMiniProfileItemBuilder.Holder.a(paramHolder).setImageBitmap((Bitmap)localObject);
      } else {
        TofuAioMiniProfileItemBuilder.Holder.a(paramHolder).setImageResource(2130840321);
      }
    }
    else
    {
      TofuAioMiniProfileItemBuilder.Holder.a(paramHolder).setImageResource(2130840321);
    }
    TofuAioMiniProfileItemBuilder.Holder.a(paramHolder).setOnClickListener(this);
    a(paramString, paramHolder);
  }
  
  private void c()
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("gotoProfileCard and uin:");
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null) {
        localObject = "null";
      } else {
        localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
      }
      localStringBuilder.append((String)localObject);
      localStringBuilder.append(" mContext:");
      localStringBuilder.append(this.jdField_a_of_type_AndroidContentContext);
      QLog.i("TofuAioMiniProfileItemBuilder", 2, localStringBuilder.toString());
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)))
    {
      if (this.jdField_a_of_type_AndroidContentContext == null) {
        return;
      }
      localObject = new AllInOne(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, 1);
      ProfileUtils.openProfileCard(this.jdField_a_of_type_AndroidContentContext, (AllInOne)localObject);
    }
  }
  
  private void d()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("gotoQZoneUserHome and uin:");
      String str;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null) {
        str = "null";
      } else {
        str = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
      }
      localStringBuilder.append(str);
      localStringBuilder.append(" mContext:");
      localStringBuilder.append(this.jdField_a_of_type_AndroidContentContext);
      QLog.i("TofuAioMiniProfileItemBuilder", 2, localStringBuilder.toString());
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)))
    {
      if (this.jdField_a_of_type_AndroidContentContext == null) {
        return;
      }
      try
      {
        QZoneHelper.forwardToUserHome(this.jdField_a_of_type_AndroidContentContext, QZoneHelper.UserInfo.getInstance(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, 0, 0, 0);
        return;
      }
      catch (Exception localException)
      {
        QLog.e("TofuAioMiniProfileItemBuilder", 1, localException, new Object[0]);
      }
    }
  }
  
  public Bitmap a(String paramString, ImageView paramImageView)
  {
    try
    {
      Bitmap localBitmap = this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.getBitmapFromCache(1, paramString);
      if (localBitmap != null) {
        return localBitmap;
      }
      if (!this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.isPausing())
      {
        this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.requestDecodeFace(paramString, 200, true);
        this.jdField_a_of_type_JavaUtilMap.put(paramString, paramImageView);
      }
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return ImageUtil.f();
  }
  
  protected View a(MessageRecord paramMessageRecord, AbstractChatItemBuilder.ViewHolder paramViewHolder, View paramView, LinearLayout paramLinearLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    paramLinearLayout = (MessageForTofuAioMiniProfile)paramMessageRecord;
    paramMessageRecord = (TofuAioMiniProfileItemBuilder.Holder)paramViewHolder;
    paramViewHolder = a(paramView, paramMessageRecord);
    paramMessageRecord.jdField_a_of_type_JavaLangString = paramLinearLayout.frienduin;
    if (QLog.isColorLevel())
    {
      paramView = new StringBuilder();
      paramView.append("getItemView and miniCard:");
      paramView.append(paramLinearLayout.miniCard);
      QLog.i("TofuAioMiniProfileItemBuilder", 2, paramView.toString());
    }
    if (paramLinearLayout.miniCard != null)
    {
      int i = ViewUtils.a(16.0F);
      TofuAioMiniProfileItemBuilder.Holder.a(paramMessageRecord).enablePressEffect(true);
      paramView = TofuAioMiniProfileItemBuilder.Holder.a(paramMessageRecord);
      float f = i;
      paramView.setRadius(f, f, f, f);
      TofuAioMiniProfileItemBuilder.Holder.a(paramMessageRecord).setOnClickListener(this);
      TofuAioMiniProfileItemBuilder.Holder.a(paramMessageRecord).setOnTouchListener(UITools.a);
      paramViewHolder.setVisibility(0);
      b(paramMessageRecord.jdField_a_of_type_JavaLangString, paramMessageRecord);
      a(paramMessageRecord, paramLinearLayout.miniCard.jdField_a_of_type_ComTencentMobileqqRelationxIcebreakingBeanMiniCard$BaseProfile);
      b(paramMessageRecord, paramLinearLayout.miniCard.jdField_a_of_type_JavaUtilList);
      if ((paramLinearLayout.miniCard.jdField_a_of_type_ComTencentMobileqqRelationxIcebreakingBeanMiniCard$QZoneInfo != null) && (paramLinearLayout.miniCard.jdField_a_of_type_ComTencentMobileqqRelationxIcebreakingBeanMiniCard$QZoneInfo.jdField_a_of_type_JavaUtilList != null) && (paramLinearLayout.miniCard.jdField_a_of_type_ComTencentMobileqqRelationxIcebreakingBeanMiniCard$QZoneInfo.jdField_a_of_type_JavaUtilList.size() > 0))
      {
        a(paramMessageRecord, paramLinearLayout.miniCard.jdField_a_of_type_ComTencentMobileqqRelationxIcebreakingBeanMiniCard$QZoneInfo);
        this.jdField_a_of_type_JavaLangString = "空间";
      }
      else if (paramLinearLayout.miniCard.jdField_a_of_type_ComTencentMobileqqProfilecardBussinessAnonymousBeanAnonymousQuestion != null)
      {
        a(paramMessageRecord, paramLinearLayout.miniCard.jdField_a_of_type_ComTencentMobileqqProfilecardBussinessAnonymousBeanAnonymousQuestion);
        this.jdField_a_of_type_JavaLangString = "匿问我答";
      }
      else if ((paramLinearLayout.miniCard.b != null) && (paramLinearLayout.miniCard.b.size() > 0))
      {
        a(paramMessageRecord, paramLinearLayout.miniCard.b);
        this.jdField_a_of_type_JavaLangString = "精选照片";
      }
      else if (paramLinearLayout.miniCard.jdField_a_of_type_ComTencentMobileqqRelationxIcebreakingBeanMiniCard$Sign != null)
      {
        a(paramMessageRecord, paramLinearLayout.miniCard.jdField_a_of_type_ComTencentMobileqqRelationxIcebreakingBeanMiniCard$Sign);
        this.jdField_a_of_type_JavaLangString = "个性签名";
      }
      else
      {
        TofuAioMiniProfileItemBuilder.Holder.a(paramMessageRecord).setVisibility(8);
        TofuAioMiniProfileItemBuilder.Holder.a(paramMessageRecord).setVisibility(8);
        this.jdField_a_of_type_JavaLangString = "无信息";
      }
      a(paramMessageRecord, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
    else
    {
      paramViewHolder.setVisibility(8);
    }
    if (!paramMessageRecord.jdField_a_of_type_Boolean)
    {
      paramMessageRecord.jdField_a_of_type_Boolean = true;
      ThreadManagerV2.excute(new TofuAioMiniProfileItemBuilder.1(this, paramMessageRecord), 128, null, true);
      ReportController.b(null, "dc00898", "", "", "0X800B1A8", "0X800B1A8", 0, 0, "", "", this.jdField_a_of_type_JavaLangString, "");
      if ("匿问我答".equals(this.jdField_a_of_type_JavaLangString))
      {
        try
        {
          paramLinearLayout.miniCard.jdField_a_of_type_ComTencentMobileqqProfilecardBussinessAnonymousBeanAnonymousQuestion.mOwnerUin = Long.parseLong(paramMessageRecord.jdField_a_of_type_JavaLangString);
          ((AnonymousHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.ANONYMOUS_ANSWER_HANDLER)).browseAskAnonymouslyReport(paramLinearLayout.miniCard.jdField_a_of_type_ComTencentMobileqqProfilecardBussinessAnonymousBeanAnonymousQuestion);
        }
        catch (Exception paramView)
        {
          paramLinearLayout = new StringBuilder();
          paramLinearLayout.append("report exception ");
          paramLinearLayout.append(paramView);
          QLog.e("TofuAioMiniProfileItemBuilder", 1, paramLinearLayout.toString());
        }
        ReportController.b(null, "dc00898", "", paramMessageRecord.jdField_a_of_type_JavaLangString, "0X800B5BE", "0X800B5BE", 0, 0, "", "", "", "");
      }
    }
    return paramViewHolder;
  }
  
  protected AbstractChatItemBuilder.ViewHolder a()
  {
    return new TofuAioMiniProfileItemBuilder.Holder();
  }
  
  public void a()
  {
    super.a();
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder;
    if (localObject != null) {
      ((IFaceDecoder)localObject).destory();
    }
    localObject = this.jdField_a_of_type_JavaUtilMap;
    if (localObject != null) {
      ((Map)localObject).clear();
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqProfilecardBussinessAnonymousHandlerAnonymousObserver);
  }
  
  public void a(TofuAioMiniProfileItemBuilder.Holder paramHolder, List<MiniCard.NicePicInfo> paramList)
  {
    TofuAioMiniProfileItemBuilder.Holder.a(paramHolder).setVisibility(0);
    TofuAioMiniProfileItemBuilder.Holder.a(paramHolder).setVisibility(0);
    TofuAioMiniProfileItemBuilder.Holder.c(paramHolder).setVisibility(0);
    TofuAioMiniProfileItemBuilder.Holder.f(paramHolder).setText(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131695157));
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      paramList = (MiniCard.NicePicInfo)localIterator.next();
      if ((!TextUtils.isEmpty(paramList.jdField_a_of_type_JavaLangString)) && (!TextUtils.isEmpty(paramList.jdField_b_of_type_JavaLangString)))
      {
        localArrayList1.add(paramList.jdField_a_of_type_JavaLangString);
        if (!TextUtils.isEmpty(paramList.jdField_b_of_type_JavaLangString)) {
          paramList = paramList.jdField_b_of_type_JavaLangString;
        } else {
          paramList = paramList.jdField_a_of_type_JavaLangString;
        }
        localArrayList2.add(paramList);
      }
    }
    if (TofuAioMiniProfileItemBuilder.Holder.a(paramHolder) != null)
    {
      if (TofuAioMiniProfileItemBuilder.Holder.a(paramHolder).a(localArrayList2)) {
        return;
      }
      TofuAioMiniProfileItemBuilder.Holder.a(paramHolder).a();
      TofuAioMiniProfileItemBuilder.Holder.a(paramHolder).a(true);
    }
    else
    {
      TofuAioMiniProfileItemBuilder.Holder.a(paramHolder, new PictureAdapter(this.jdField_a_of_type_AndroidContentContext, true));
    }
    TofuAioMiniProfileItemBuilder.Holder.a(paramHolder).a(localArrayList2);
    TofuAioMiniProfileItemBuilder.Holder.a(paramHolder).setAdapter(TofuAioMiniProfileItemBuilder.Holder.a(paramHolder));
    TofuAioMiniProfileItemBuilder.Holder.a(paramHolder).setClickable(true);
    TofuAioMiniProfileItemBuilder.Holder.a(paramHolder).setEnabled(true);
    TofuAioMiniProfileItemBuilder.Holder.a(paramHolder).setOnTouchListener(null);
    TofuAioMiniProfileItemBuilder.Holder.a(paramHolder).setOnClickListener(null);
    TofuAioMiniProfileItemBuilder.Holder.a(paramHolder).setOnItemClickListener(new TofuAioMiniProfileItemBuilder.3(this, localArrayList1));
    TofuAioMiniProfileItemBuilder.Holder.g(paramHolder).setVisibility(8);
    TofuAioMiniProfileItemBuilder.Holder.d(paramHolder).setVisibility(8);
  }
  
  protected void a(String paramString, TofuAioMiniProfileItemBuilder.Holder paramHolder)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    if (QLog.isDevelopLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("updateFace, ");
      ((StringBuilder)localObject).append(paramString);
      QLog.i("TofuAioMiniProfileItemBuilder", 4, ((StringBuilder)localObject).toString());
    }
    Object localObject = FaceDrawable.getUserFaceDrawable(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString, (byte)3);
    TofuAioMiniProfileItemBuilder.Holder.a(paramHolder).setFaceDrawable(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (Drawable)localObject, 1, paramString, 200, true, true, 8);
  }
  
  public QQCustomMenuItem[] a(View paramView)
  {
    return new QQCustomMenuItem[0];
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i != 2131362552)
    {
      if (i == 2131376666)
      {
        ReportController.b(null, "dc00898", "", "", "0X800B1A9", "0X800B1A9", 0, 0, "", "", this.jdField_a_of_type_JavaLangString, "空白处");
        c();
      }
    }
    else
    {
      ReportController.b(null, "dc00898", "", "", "0X800B1A9", "0X800B1A9", 0, 0, "", "", this.jdField_a_of_type_JavaLangString, "头像");
      c();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    paramString = (ImageView)this.jdField_a_of_type_JavaUtilMap.get(paramString);
    if (paramString != null) {
      paramString.setImageBitmap(paramBitmap);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.TofuAioMiniProfileItemBuilder
 * JD-Core Version:    0.7.0.1
 */