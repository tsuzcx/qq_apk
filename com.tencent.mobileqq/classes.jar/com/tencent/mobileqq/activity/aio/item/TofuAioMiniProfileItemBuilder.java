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
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
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
import com.tencent.mobileqq.relationx.icebreaking.bean.MiniCard;
import com.tencent.mobileqq.relationx.icebreaking.bean.MiniCard.BaseProfile;
import com.tencent.mobileqq.relationx.icebreaking.bean.MiniCard.NicePicInfo;
import com.tencent.mobileqq.relationx.icebreaking.bean.MiniCard.QZoneInfo;
import com.tencent.mobileqq.relationx.icebreaking.bean.MiniCard.Sign;
import com.tencent.mobileqq.richstatus.SignatureHistoryFragment;
import com.tencent.mobileqq.richstatus.StatusManager;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenuItem;
import com.tencent.mobileqq.vas.avatar.AvatarLayout;
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
    this.jdField_a_of_type_Int = ((int)(Math.random() * AnonymousConstant.headBgColor.length));
    a(paramQQAppInterface);
    paramQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqProfilecardBussinessAnonymousHandlerAnonymousObserver);
  }
  
  private View a(View paramView, TofuAioMiniProfileItemBuilder.Holder paramHolder)
  {
    View localView = paramView;
    if (paramView == null)
    {
      localView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558933, null);
      TofuAioMiniProfileItemBuilder.Holder.a(paramHolder, (RoundCorneredRelativeLayout)localView.findViewById(2131377206));
      TofuAioMiniProfileItemBuilder.Holder.a(paramHolder, (ViewGroup)localView.findViewById(2131377305));
      TofuAioMiniProfileItemBuilder.Holder.a(paramHolder, (TextView)localView.findViewById(2131380379));
      TofuAioMiniProfileItemBuilder.Holder.b(paramHolder, (TextView)localView.findViewById(2131380190));
      TofuAioMiniProfileItemBuilder.Holder.c(paramHolder, (TextView)localView.findViewById(2131380451));
      TofuAioMiniProfileItemBuilder.Holder.b(paramHolder, (ViewGroup)localView.findViewById(2131370573));
      TofuAioMiniProfileItemBuilder.Holder.a(paramHolder, localView.findViewById(2131365924));
      TofuAioMiniProfileItemBuilder.Holder.b(paramHolder, localView.findViewById(2131365925));
      TofuAioMiniProfileItemBuilder.Holder.d(paramHolder, (TextView)localView.findViewById(2131380606));
      TofuAioMiniProfileItemBuilder.Holder.e(paramHolder, (TextView)localView.findViewById(2131380279));
      TofuAioMiniProfileItemBuilder.Holder.c(paramHolder, localView.findViewById(2131365926));
      TofuAioMiniProfileItemBuilder.Holder.c(paramHolder, (ViewGroup)localView.findViewById(2131370574));
      TofuAioMiniProfileItemBuilder.Holder.a(paramHolder, (AvatarLayout)localView.findViewById(2131362596));
      TofuAioMiniProfileItemBuilder.Holder.a(paramHolder, (DynamicAvatarView)localView.findViewById(2131365583));
      TofuAioMiniProfileItemBuilder.Holder.a(paramHolder, (AioMiniProfileLabelFlowLayout)localView.findViewById(2131367080));
      TofuAioMiniProfileItemBuilder.Holder.d(paramHolder, localView.findViewById(2131365930));
      TofuAioMiniProfileItemBuilder.Holder.a(paramHolder, (FrameLayout)localView.findViewById(2131367055));
      TofuAioMiniProfileItemBuilder.Holder.d(paramHolder, (ViewGroup)localView.findViewById(2131370678));
      TofuAioMiniProfileItemBuilder.Holder.f(paramHolder, (TextView)localView.findViewById(2131380651));
      TofuAioMiniProfileItemBuilder.Holder.a(paramHolder, (GridView)localView.findViewById(2131368187));
      TofuAioMiniProfileItemBuilder.Holder.g(paramHolder, (TextView)localView.findViewById(2131380601));
      TofuAioMiniProfileItemBuilder.Holder.e(paramHolder, (ViewGroup)localView.findViewById(2131370649));
      TofuAioMiniProfileItemBuilder.Holder.a(paramHolder, (ImageView)localView.findViewById(2131374616));
      TofuAioMiniProfileItemBuilder.Holder.b(paramHolder, (ImageView)localView.findViewById(2131374614));
      TofuAioMiniProfileItemBuilder.Holder.c(paramHolder, (ImageView)localView.findViewById(2131374615));
      TofuAioMiniProfileItemBuilder.Holder.h(paramHolder, (TextView)localView.findViewById(2131374629));
      TofuAioMiniProfileItemBuilder.Holder.d(paramHolder, (ImageView)localView.findViewById(2131374609));
      TofuAioMiniProfileItemBuilder.Holder.e(paramHolder, (ImageView)localView.findViewById(2131374610));
      TofuAioMiniProfileItemBuilder.Holder.i(paramHolder, (TextView)localView.findViewById(2131374625));
    }
    return localView;
  }
  
  private void a(TofuAioMiniProfileItemBuilder.Holder paramHolder, QQAppInterface paramQQAppInterface)
  {
    if ((paramHolder == null) || (paramQQAppInterface == null)) {
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
      if ((ThemeUtil.isSimpleDayTheme(false)) && (!ThemeUtil.isNowThemeIsNight(paramQQAppInterface, false, null)))
      {
        if (Build.VERSION.SDK_INT < 21) {
          break label444;
        }
        if (this.jdField_a_of_type_AndroidContentContext != null) {
          TofuAioMiniProfileItemBuilder.Holder.a(paramHolder).setBackground(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130851233));
        }
      }
      label253:
      if (!SimpleUIUtil.a()) {
        break label455;
      }
      TofuAioMiniProfileItemBuilder.Holder.b(paramHolder).setImageResource(2130846040);
      TofuAioMiniProfileItemBuilder.Holder.c(paramHolder).setImageResource(2130846037);
      TofuAioMiniProfileItemBuilder.Holder.d(paramHolder).setImageResource(2130846039);
      TofuAioMiniProfileItemBuilder.Holder.e(paramHolder).setImageResource(2130846025);
    }
    for (;;)
    {
      i = this.jdField_a_of_type_Int;
      j = AnonymousConstant.headBgColor.length;
      TofuAioMiniProfileItemBuilder.Holder.c(paramHolder).clearColorFilter();
      TofuAioMiniProfileItemBuilder.Holder.c(paramHolder).setColorFilter(AnonymousConstant.headBgColor[(i % j)]);
      return;
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
      break;
      label444:
      TofuAioMiniProfileItemBuilder.Holder.e(paramHolder).setBackgroundColor(i);
      break label253;
      label455:
      TofuAioMiniProfileItemBuilder.Holder.b(paramHolder).setImageResource(2130846035);
      TofuAioMiniProfileItemBuilder.Holder.c(paramHolder).setImageResource(2130846036);
      TofuAioMiniProfileItemBuilder.Holder.d(paramHolder).setImageResource(2130846038);
      TofuAioMiniProfileItemBuilder.Holder.e(paramHolder).setImageResource(2130846024);
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
    int m = 1;
    if (paramBaseProfile == null)
    {
      TofuAioMiniProfileItemBuilder.Holder.a(paramHolder).setVisibility(8);
      return;
    }
    TofuAioMiniProfileItemBuilder.Holder.a(paramHolder).setVisibility(0);
    int i;
    label75:
    label127:
    int k;
    if ((paramBaseProfile.jdField_b_of_type_Int == 1) || (paramBaseProfile.jdField_b_of_type_Int == 2))
    {
      TofuAioMiniProfileItemBuilder.Holder.a(paramHolder).setVisibility(0);
      TextView localTextView = TofuAioMiniProfileItemBuilder.Holder.a(paramHolder);
      if (paramBaseProfile.jdField_b_of_type_Int == 1)
      {
        i = 2131693923;
        localTextView.setText(i);
        i = 1;
        if (paramBaseProfile.jdField_a_of_type_Int < 0) {
          break label318;
        }
        TofuAioMiniProfileItemBuilder.Holder.b(paramHolder).setVisibility(0);
        TofuAioMiniProfileItemBuilder.Holder.b(paramHolder).setText(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131690036, new Object[] { Integer.valueOf(paramBaseProfile.jdField_a_of_type_Int) }));
        j = 1;
        if (TextUtils.isEmpty(paramBaseProfile.jdField_a_of_type_JavaLangString)) {
          break label333;
        }
        TofuAioMiniProfileItemBuilder.Holder.c(paramHolder).setVisibility(0);
        TofuAioMiniProfileItemBuilder.Holder.c(paramHolder).setText(paramBaseProfile.jdField_a_of_type_JavaLangString);
        k = 1;
        label159:
        i = i + j + k;
        if (i != 3) {
          break label348;
        }
        TofuAioMiniProfileItemBuilder.Holder.b(paramHolder).setVisibility(0);
        TofuAioMiniProfileItemBuilder.Holder.c(paramHolder).setVisibility(0);
        label188:
        if (TextUtils.isEmpty(paramBaseProfile.jdField_b_of_type_JavaLangString)) {
          break label461;
        }
        TofuAioMiniProfileItemBuilder.Holder.d(paramHolder).setText(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131690035, new Object[] { paramBaseProfile.jdField_b_of_type_JavaLangString }));
        i = 1;
        label231:
        if (paramBaseProfile.c <= 0) {
          break label475;
        }
        TofuAioMiniProfileItemBuilder.Holder.e(paramHolder).setText(String.format(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131689659), new Object[] { Integer.valueOf(paramBaseProfile.c) }));
      }
    }
    for (int j = m;; j = 0)
    {
      if ((j == 0) || (i == 0)) {
        break label490;
      }
      TofuAioMiniProfileItemBuilder.Holder.d(paramHolder).setVisibility(0);
      return;
      i = 2131692330;
      break;
      TofuAioMiniProfileItemBuilder.Holder.a(paramHolder).setVisibility(8);
      i = 0;
      break label75;
      label318:
      TofuAioMiniProfileItemBuilder.Holder.b(paramHolder).setVisibility(8);
      j = 0;
      break label127;
      label333:
      TofuAioMiniProfileItemBuilder.Holder.c(paramHolder).setVisibility(8);
      k = 0;
      break label159;
      label348:
      if (i == 2)
      {
        if ((j == 1) && (k == 1))
        {
          TofuAioMiniProfileItemBuilder.Holder.b(paramHolder).setVisibility(8);
          TofuAioMiniProfileItemBuilder.Holder.c(paramHolder).setVisibility(0);
          break label188;
        }
        TofuAioMiniProfileItemBuilder.Holder.b(paramHolder).setVisibility(0);
        TofuAioMiniProfileItemBuilder.Holder.c(paramHolder).setVisibility(8);
        break label188;
      }
      if (i == 1)
      {
        TofuAioMiniProfileItemBuilder.Holder.b(paramHolder).setVisibility(8);
        TofuAioMiniProfileItemBuilder.Holder.c(paramHolder).setVisibility(8);
        break label188;
      }
      TofuAioMiniProfileItemBuilder.Holder.b(paramHolder).setVisibility(8);
      TofuAioMiniProfileItemBuilder.Holder.c(paramHolder).setVisibility(8);
      TofuAioMiniProfileItemBuilder.Holder.b(paramHolder).setVisibility(8);
      break label188;
      label461:
      TofuAioMiniProfileItemBuilder.Holder.d(paramHolder).setVisibility(8);
      i = 0;
      break label231;
      label475:
      TofuAioMiniProfileItemBuilder.Holder.e(paramHolder).setVisibility(8);
    }
    label490:
    TofuAioMiniProfileItemBuilder.Holder.d(paramHolder).setVisibility(8);
  }
  
  private void a(TofuAioMiniProfileItemBuilder.Holder paramHolder, MiniCard.QZoneInfo paramQZoneInfo)
  {
    TofuAioMiniProfileItemBuilder.Holder.a(paramHolder).setVisibility(0);
    TofuAioMiniProfileItemBuilder.Holder.a(paramHolder).setVisibility(0);
    TofuAioMiniProfileItemBuilder.Holder.c(paramHolder).setVisibility(0);
    TextView localTextView = TofuAioMiniProfileItemBuilder.Holder.f(paramHolder);
    if (TextUtils.isEmpty(paramQZoneInfo.jdField_a_of_type_JavaLangString)) {}
    for (String str = this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131716895);; str = paramQZoneInfo.jdField_a_of_type_JavaLangString)
    {
      localTextView.setText(str);
      if (TofuAioMiniProfileItemBuilder.Holder.a(paramHolder) == null) {
        break label187;
      }
      if (!TofuAioMiniProfileItemBuilder.Holder.a(paramHolder).a(paramQZoneInfo.jdField_a_of_type_JavaUtilList)) {
        break;
      }
      return;
    }
    TofuAioMiniProfileItemBuilder.Holder.a(paramHolder).a(false);
    TofuAioMiniProfileItemBuilder.Holder.a(paramHolder).a();
    for (;;)
    {
      TofuAioMiniProfileItemBuilder.Holder.a(paramHolder).a(paramQZoneInfo.jdField_a_of_type_JavaUtilList);
      TofuAioMiniProfileItemBuilder.Holder.a(paramHolder).setAdapter(TofuAioMiniProfileItemBuilder.Holder.a(paramHolder));
      TofuAioMiniProfileItemBuilder.Holder.a(paramHolder).setClickable(false);
      TofuAioMiniProfileItemBuilder.Holder.a(paramHolder).setEnabled(false);
      TofuAioMiniProfileItemBuilder.Holder.a(paramHolder).setOnTouchListener(UITools.a);
      TofuAioMiniProfileItemBuilder.Holder.a(paramHolder).setOnClickListener(new TofuAioMiniProfileItemBuilder.2(this));
      TofuAioMiniProfileItemBuilder.Holder.g(paramHolder).setVisibility(8);
      TofuAioMiniProfileItemBuilder.Holder.d(paramHolder).setVisibility(8);
      return;
      label187:
      TofuAioMiniProfileItemBuilder.Holder.a(paramHolder, new PictureAdapter(this.jdField_a_of_type_AndroidContentContext, false));
    }
  }
  
  private void a(TofuAioMiniProfileItemBuilder.Holder paramHolder, MiniCard.Sign paramSign)
  {
    TofuAioMiniProfileItemBuilder.Holder.a(paramHolder).setVisibility(0);
    TofuAioMiniProfileItemBuilder.Holder.a(paramHolder).setVisibility(0);
    TofuAioMiniProfileItemBuilder.Holder.g(paramHolder).setVisibility(0);
    Object localObject;
    if (paramSign.jdField_a_of_type_Int != 0)
    {
      localObject = ((StatusManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.STATUS_MANAGER)).a(paramSign.jdField_a_of_type_Int, 200);
      localObject = new BitmapDrawable(this.jdField_a_of_type_AndroidContentContext.getResources(), (Bitmap)localObject);
      int i = AIOUtils.a(12.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      ((Drawable)localObject).setBounds(0, 0, Math.round(((Drawable)localObject).getIntrinsicWidth() * 1.0F / ((Drawable)localObject).getIntrinsicHeight() * i), i);
    }
    for (;;)
    {
      TofuAioMiniProfileItemBuilder.Holder.g(paramHolder).setCompoundDrawables((Drawable)localObject, null, null, null);
      TofuAioMiniProfileItemBuilder.Holder.g(paramHolder).setText(paramSign.jdField_a_of_type_JavaLangString + " " + paramSign.jdField_b_of_type_JavaLangString);
      TofuAioMiniProfileItemBuilder.Holder.a(paramHolder).setOnTouchListener(UITools.a);
      TofuAioMiniProfileItemBuilder.Holder.a(paramHolder).setOnClickListener(new TofuAioMiniProfileItemBuilder.4(this));
      TofuAioMiniProfileItemBuilder.Holder.c(paramHolder).setVisibility(8);
      TofuAioMiniProfileItemBuilder.Holder.d(paramHolder).setVisibility(8);
      return;
      localObject = null;
    }
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
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("gotoSignatureHistory and uin:");
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null) {
        break label87;
      }
    }
    label87:
    for (Object localObject = "null";; localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)
    {
      QLog.i("TofuAioMiniProfileItemBuilder", 2, (String)localObject + " mContext:" + this.jdField_a_of_type_AndroidContentContext);
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) && (this.jdField_a_of_type_AndroidContentContext != null)) {
        break;
      }
      return;
    }
    localObject = new Intent(this.jdField_a_of_type_AndroidContentContext, PublicFragmentActivity.class);
    ((Intent)localObject).putExtra("key_uin", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    ((Intent)localObject).putExtra("key_uin_name", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d);
    ((Intent)localObject).putExtra("key_open_via", "history-liaotian");
    PublicFragmentActivity.Launcher.a(this.jdField_a_of_type_AndroidContentContext, (Intent)localObject, PublicFragmentActivity.class, SignatureHistoryFragment.class);
  }
  
  private void b(TofuAioMiniProfileItemBuilder.Holder paramHolder, List<String> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0))
    {
      TofuAioMiniProfileItemBuilder.Holder.a(paramHolder).setVisibility(8);
      a(paramHolder, false);
      return;
    }
    TofuAioMiniProfileItemBuilder.Holder.a(paramHolder).setVisibility(0);
    if (TofuAioMiniProfileItemBuilder.Holder.a(paramHolder) != null) {
      TofuAioMiniProfileItemBuilder.Holder.a(paramHolder).a();
    }
    for (;;)
    {
      TofuAioMiniProfileItemBuilder.Holder.a(paramHolder).a(paramList);
      TofuAioMiniProfileItemBuilder.Holder.a(paramHolder).setAdapter(TofuAioMiniProfileItemBuilder.Holder.a(paramHolder));
      a(paramHolder, true);
      return;
      TofuAioMiniProfileItemBuilder.Holder.a(paramHolder, new AioMiniProfileLabelListAdapter(this.jdField_a_of_type_AndroidContentContext));
    }
  }
  
  private void b(String paramString, TofuAioMiniProfileItemBuilder.Holder paramHolder)
  {
    TofuAioMiniProfileItemBuilder.Holder.a(paramHolder).a(0, TofuAioMiniProfileItemBuilder.Holder.a(paramHolder), false);
    if ((paramString == null) || (paramString.length() == 0)) {
      TofuAioMiniProfileItemBuilder.Holder.a(paramHolder).setImageResource(2130840452);
    }
    for (;;)
    {
      TofuAioMiniProfileItemBuilder.Holder.a(paramHolder).setOnClickListener(this);
      a(paramString, paramHolder);
      return;
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFaceBitmapCacheKey(1, paramString, (byte)3, 0, 100, true);
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBitmapFromCache((String)localObject);
      if (localObject != null) {
        TofuAioMiniProfileItemBuilder.Holder.a(paramHolder).setImageBitmap((Bitmap)localObject);
      } else {
        TofuAioMiniProfileItemBuilder.Holder.a(paramHolder).setImageResource(2130840452);
      }
    }
  }
  
  private void c()
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("gotoProfileCard and uin:");
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null) {
        break label87;
      }
    }
    label87:
    for (Object localObject = "null";; localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)
    {
      QLog.i("TofuAioMiniProfileItemBuilder", 2, (String)localObject + " mContext:" + this.jdField_a_of_type_AndroidContentContext);
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) && (this.jdField_a_of_type_AndroidContentContext != null)) {
        break;
      }
      return;
    }
    localObject = new ProfileActivity.AllInOne(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, 1);
    ProfileActivity.b(this.jdField_a_of_type_AndroidContentContext, (ProfileActivity.AllInOne)localObject);
  }
  
  private void d()
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("gotoQZoneUserHome and uin:");
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null) {
        break label87;
      }
    }
    label87:
    for (String str = "null";; str = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)
    {
      QLog.i("TofuAioMiniProfileItemBuilder", 2, str + " mContext:" + this.jdField_a_of_type_AndroidContentContext);
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) && (this.jdField_a_of_type_AndroidContentContext != null)) {
        break;
      }
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
      for (;;)
      {
        paramString.printStackTrace();
      }
    }
    return ImageUtil.c();
  }
  
  public View a(MessageRecord paramMessageRecord, AbstractChatItemBuilder.ViewHolder paramViewHolder, View paramView, LinearLayout paramLinearLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    paramMessageRecord = (MessageForTofuAioMiniProfile)paramMessageRecord;
    paramViewHolder = (TofuAioMiniProfileItemBuilder.Holder)paramViewHolder;
    paramView = a(paramView, paramViewHolder);
    paramViewHolder.jdField_a_of_type_JavaLangString = paramMessageRecord.frienduin;
    if (QLog.isColorLevel()) {
      QLog.i("TofuAioMiniProfileItemBuilder", 2, "getItemView and miniCard:" + paramMessageRecord.miniCard);
    }
    if (paramMessageRecord.miniCard != null)
    {
      int i = ViewUtils.a(16.0F);
      TofuAioMiniProfileItemBuilder.Holder.a(paramViewHolder).enablePressEffect(true);
      TofuAioMiniProfileItemBuilder.Holder.a(paramViewHolder).setRadius(i, i, i, i);
      TofuAioMiniProfileItemBuilder.Holder.a(paramViewHolder).setOnClickListener(this);
      TofuAioMiniProfileItemBuilder.Holder.a(paramViewHolder).setOnTouchListener(UITools.a);
      paramView.setVisibility(0);
      b(paramViewHolder.jdField_a_of_type_JavaLangString, paramViewHolder);
      a(paramViewHolder, paramMessageRecord.miniCard.jdField_a_of_type_ComTencentMobileqqRelationxIcebreakingBeanMiniCard$BaseProfile);
      b(paramViewHolder, paramMessageRecord.miniCard.jdField_a_of_type_JavaUtilList);
      if ((paramMessageRecord.miniCard.jdField_a_of_type_ComTencentMobileqqRelationxIcebreakingBeanMiniCard$QZoneInfo != null) && (paramMessageRecord.miniCard.jdField_a_of_type_ComTencentMobileqqRelationxIcebreakingBeanMiniCard$QZoneInfo.jdField_a_of_type_JavaUtilList != null) && (paramMessageRecord.miniCard.jdField_a_of_type_ComTencentMobileqqRelationxIcebreakingBeanMiniCard$QZoneInfo.jdField_a_of_type_JavaUtilList.size() > 0))
      {
        a(paramViewHolder, paramMessageRecord.miniCard.jdField_a_of_type_ComTencentMobileqqRelationxIcebreakingBeanMiniCard$QZoneInfo);
        this.jdField_a_of_type_JavaLangString = "空间";
      }
    }
    for (;;)
    {
      a(paramViewHolder, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      if (!paramViewHolder.jdField_a_of_type_Boolean)
      {
        paramViewHolder.jdField_a_of_type_Boolean = true;
        ThreadManagerV2.excute(new TofuAioMiniProfileItemBuilder.1(this, paramViewHolder), 128, null, true);
        ReportController.b(null, "dc00898", "", "", "0X800B1A8", "0X800B1A8", 0, 0, "", "", this.jdField_a_of_type_JavaLangString, "");
        if (!"匿问我答".equals(this.jdField_a_of_type_JavaLangString)) {}
      }
      try
      {
        paramMessageRecord.miniCard.jdField_a_of_type_ComTencentMobileqqProfilecardBussinessAnonymousBeanAnonymousQuestion.mOwnerUin = Long.parseLong(paramViewHolder.jdField_a_of_type_JavaLangString);
        ((AnonymousHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.ANONYMOUS_ANSWER_HANDLER)).browseAskAnonymouslyReport(paramMessageRecord.miniCard.jdField_a_of_type_ComTencentMobileqqProfilecardBussinessAnonymousBeanAnonymousQuestion);
        ReportController.b(null, "dc00898", "", paramViewHolder.jdField_a_of_type_JavaLangString, "0X800B5BE", "0X800B5BE", 0, 0, "", "", "", "");
        return paramView;
        if (paramMessageRecord.miniCard.jdField_a_of_type_ComTencentMobileqqProfilecardBussinessAnonymousBeanAnonymousQuestion != null)
        {
          a(paramViewHolder, paramMessageRecord.miniCard.jdField_a_of_type_ComTencentMobileqqProfilecardBussinessAnonymousBeanAnonymousQuestion);
          this.jdField_a_of_type_JavaLangString = "匿问我答";
          continue;
        }
        if ((paramMessageRecord.miniCard.b != null) && (paramMessageRecord.miniCard.b.size() > 0))
        {
          a(paramViewHolder, paramMessageRecord.miniCard.b);
          this.jdField_a_of_type_JavaLangString = "精选照片";
          continue;
        }
        if (paramMessageRecord.miniCard.jdField_a_of_type_ComTencentMobileqqRelationxIcebreakingBeanMiniCard$Sign != null)
        {
          a(paramViewHolder, paramMessageRecord.miniCard.jdField_a_of_type_ComTencentMobileqqRelationxIcebreakingBeanMiniCard$Sign);
          this.jdField_a_of_type_JavaLangString = "个性签名";
          continue;
        }
        TofuAioMiniProfileItemBuilder.Holder.a(paramViewHolder).setVisibility(8);
        TofuAioMiniProfileItemBuilder.Holder.a(paramViewHolder).setVisibility(8);
        this.jdField_a_of_type_JavaLangString = "无信息";
        continue;
        paramView.setVisibility(8);
      }
      catch (Exception paramMessageRecord)
      {
        for (;;)
        {
          QLog.e("TofuAioMiniProfileItemBuilder", 1, "report exception " + paramMessageRecord);
        }
      }
    }
  }
  
  public AbstractChatItemBuilder.ViewHolder a()
  {
    return new TofuAioMiniProfileItemBuilder.Holder();
  }
  
  public void a()
  {
    super.a();
    if (this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.destory();
    }
    if (this.jdField_a_of_type_JavaUtilMap != null) {
      this.jdField_a_of_type_JavaUtilMap.clear();
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqProfilecardBussinessAnonymousHandlerAnonymousObserver);
  }
  
  public void a(TofuAioMiniProfileItemBuilder.Holder paramHolder, List<MiniCard.NicePicInfo> paramList)
  {
    TofuAioMiniProfileItemBuilder.Holder.a(paramHolder).setVisibility(0);
    TofuAioMiniProfileItemBuilder.Holder.a(paramHolder).setVisibility(0);
    TofuAioMiniProfileItemBuilder.Holder.c(paramHolder).setVisibility(0);
    TofuAioMiniProfileItemBuilder.Holder.f(paramHolder).setText(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131695167));
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      paramList = (MiniCard.NicePicInfo)localIterator.next();
      if ((!TextUtils.isEmpty(paramList.jdField_a_of_type_JavaLangString)) && (!TextUtils.isEmpty(paramList.jdField_b_of_type_JavaLangString)))
      {
        localArrayList1.add(paramList.jdField_a_of_type_JavaLangString);
        if (!TextUtils.isEmpty(paramList.jdField_b_of_type_JavaLangString)) {}
        for (paramList = paramList.jdField_b_of_type_JavaLangString;; paramList = paramList.jdField_a_of_type_JavaLangString)
        {
          localArrayList2.add(paramList);
          break;
        }
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
    for (;;)
    {
      TofuAioMiniProfileItemBuilder.Holder.a(paramHolder).a(localArrayList2);
      TofuAioMiniProfileItemBuilder.Holder.a(paramHolder).setAdapter(TofuAioMiniProfileItemBuilder.Holder.a(paramHolder));
      TofuAioMiniProfileItemBuilder.Holder.a(paramHolder).setClickable(true);
      TofuAioMiniProfileItemBuilder.Holder.a(paramHolder).setEnabled(true);
      TofuAioMiniProfileItemBuilder.Holder.a(paramHolder).setOnTouchListener(null);
      TofuAioMiniProfileItemBuilder.Holder.a(paramHolder).setOnClickListener(null);
      TofuAioMiniProfileItemBuilder.Holder.a(paramHolder).setOnItemClickListener(new TofuAioMiniProfileItemBuilder.3(this, localArrayList1));
      TofuAioMiniProfileItemBuilder.Holder.g(paramHolder).setVisibility(8);
      TofuAioMiniProfileItemBuilder.Holder.d(paramHolder).setVisibility(8);
      return;
      TofuAioMiniProfileItemBuilder.Holder.a(paramHolder, new PictureAdapter(this.jdField_a_of_type_AndroidContentContext, true));
    }
  }
  
  protected void a(String paramString, TofuAioMiniProfileItemBuilder.Holder paramHolder)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    if (QLog.isDevelopLevel()) {
      QLog.i("TofuAioMiniProfileItemBuilder", 4, "updateFace, " + paramString);
    }
    FaceDrawable localFaceDrawable = FaceDrawable.getUserFaceDrawable(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString, (byte)3);
    TofuAioMiniProfileItemBuilder.Holder.a(paramHolder).setFaceDrawable(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localFaceDrawable, 1, paramString, 200, true, true, 8);
  }
  
  public QQCustomMenuItem[] a(View paramView)
  {
    return new QQCustomMenuItem[0];
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      ReportController.b(null, "dc00898", "", "", "0X800B1A9", "0X800B1A9", 0, 0, "", "", this.jdField_a_of_type_JavaLangString, "空白处");
      c();
      continue;
      ReportController.b(null, "dc00898", "", "", "0X800B1A9", "0X800B1A9", 0, 0, "", "", this.jdField_a_of_type_JavaLangString, "头像");
      c();
    }
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    paramString = (ImageView)this.jdField_a_of_type_JavaUtilMap.get(paramString);
    if (paramString != null) {
      paramString.setImageBitmap(paramBitmap);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.TofuAioMiniProfileItemBuilder
 * JD-Core Version:    0.7.0.1
 */