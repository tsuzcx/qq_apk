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
  private IFaceDecoder e;
  private Map<String, ImageView> f = new HashMap();
  private String g;
  private int h;
  private AnonymousObserver i = new TofuAioMiniProfileItemBuilder.7(this);
  
  public TofuAioMiniProfileItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo);
    this.e = ((IQQAvatarService)paramQQAppInterface.getRuntimeService(IQQAvatarService.class, "")).getInstance(paramQQAppInterface);
    this.e.setDecodeTaskCompletionListener(this);
    double d1 = Math.random();
    double d2 = AnonymousConstant.HEAD_BG_COLOR.length;
    Double.isNaN(d2);
    this.h = ((int)(d1 * d2));
    a(paramQQAppInterface);
    paramQQAppInterface.addObserver(this.i);
  }
  
  private View a(View paramView, TofuAioMiniProfileItemBuilder.Holder paramHolder)
  {
    View localView = paramView;
    if (paramView == null)
    {
      localView = LayoutInflater.from(this.c).inflate(2131624451, null);
      TofuAioMiniProfileItemBuilder.Holder.a(paramHolder, (RoundCorneredRelativeLayout)localView.findViewById(2131444932));
      TofuAioMiniProfileItemBuilder.Holder.a(paramHolder, (ViewGroup)localView.findViewById(2131445053));
      TofuAioMiniProfileItemBuilder.Holder.a(paramHolder, (TextView)localView.findViewById(2131448488));
      TofuAioMiniProfileItemBuilder.Holder.b(paramHolder, (TextView)localView.findViewById(2131448257));
      TofuAioMiniProfileItemBuilder.Holder.c(paramHolder, (TextView)localView.findViewById(2131448572));
      TofuAioMiniProfileItemBuilder.Holder.b(paramHolder, (ViewGroup)localView.findViewById(2131437416));
      TofuAioMiniProfileItemBuilder.Holder.a(paramHolder, localView.findViewById(2131432018));
      TofuAioMiniProfileItemBuilder.Holder.b(paramHolder, localView.findViewById(2131432019));
      TofuAioMiniProfileItemBuilder.Holder.d(paramHolder, (TextView)localView.findViewById(2131448756));
      TofuAioMiniProfileItemBuilder.Holder.e(paramHolder, (TextView)localView.findViewById(2131448349));
      TofuAioMiniProfileItemBuilder.Holder.c(paramHolder, localView.findViewById(2131432020));
      TofuAioMiniProfileItemBuilder.Holder.c(paramHolder, (ViewGroup)localView.findViewById(2131437418));
      TofuAioMiniProfileItemBuilder.Holder.a(paramHolder, (AvatarLayout)localView.findViewById(2131428163));
      TofuAioMiniProfileItemBuilder.Holder.a(paramHolder, (DynamicAvatarView)localView.findViewById(2131431630));
      TofuAioMiniProfileItemBuilder.Holder.a(paramHolder, (AioMiniProfileLabelFlowLayout)localView.findViewById(2131433270));
      TofuAioMiniProfileItemBuilder.Holder.d(paramHolder, localView.findViewById(2131432024));
      TofuAioMiniProfileItemBuilder.Holder.a(paramHolder, (FrameLayout)localView.findViewById(2131433234));
      TofuAioMiniProfileItemBuilder.Holder.d(paramHolder, (ViewGroup)localView.findViewById(2131437568));
      TofuAioMiniProfileItemBuilder.Holder.f(paramHolder, (TextView)localView.findViewById(2131448814));
      TofuAioMiniProfileItemBuilder.Holder.a(paramHolder, (GridView)localView.findViewById(2131434776));
      TofuAioMiniProfileItemBuilder.Holder.g(paramHolder, (TextView)localView.findViewById(2131448751));
      TofuAioMiniProfileItemBuilder.Holder.e(paramHolder, (ViewGroup)localView.findViewById(2131437527));
      TofuAioMiniProfileItemBuilder.Holder.a(paramHolder, (ImageView)localView.findViewById(2131442249));
      TofuAioMiniProfileItemBuilder.Holder.b(paramHolder, (ImageView)localView.findViewById(2131442247));
      TofuAioMiniProfileItemBuilder.Holder.c(paramHolder, (ImageView)localView.findViewById(2131442248));
      TofuAioMiniProfileItemBuilder.Holder.h(paramHolder, (TextView)localView.findViewById(2131442262));
      TofuAioMiniProfileItemBuilder.Holder.d(paramHolder, (ImageView)localView.findViewById(2131442242));
      TofuAioMiniProfileItemBuilder.Holder.e(paramHolder, (ImageView)localView.findViewById(2131442243));
      TofuAioMiniProfileItemBuilder.Holder.i(paramHolder, (TextView)localView.findViewById(2131442258));
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
      int j = Color.parseColor("#FCFCFC");
      int k = Color.parseColor("#03081A");
      int m = Color.parseColor("#878B99");
      int n = Color.parseColor("#EFEFEF");
      int i1 = Color.parseColor("#FFFFFF");
      int i2 = Color.parseColor("#FAFAFD");
      int i3 = Color.parseColor("#FFFFFF");
      int i4 = Color.parseColor("#838383");
      int i5 = Color.parseColor("#000000");
      int i6 = Color.parseColor("#1F1F1F");
      int i7 = Color.parseColor("#1C1C1E");
      if (ThemeUtil.isNowThemeIsNight(paramQQAppInterface, false, null))
      {
        TofuAioMiniProfileItemBuilder.Holder.g(paramHolder).setTextColor(i3);
        TofuAioMiniProfileItemBuilder.Holder.h(paramHolder).setTextColor(i3);
        TofuAioMiniProfileItemBuilder.Holder.i(paramHolder).setTextColor(i3);
        TofuAioMiniProfileItemBuilder.Holder.m(paramHolder).setTextColor(i4);
        TofuAioMiniProfileItemBuilder.Holder.n(paramHolder).setTextColor(i4);
        TofuAioMiniProfileItemBuilder.Holder.s(paramHolder).setTextColor(i4);
        TofuAioMiniProfileItemBuilder.Holder.v(paramHolder).setTextColor(i3);
        TofuAioMiniProfileItemBuilder.Holder.b(paramHolder).setBackgroundColor(i5);
        TofuAioMiniProfileItemBuilder.Holder.A(paramHolder).setBackgroundColor(i6);
        TofuAioMiniProfileItemBuilder.Holder.c(paramHolder).setBackgroundColor(i7);
        TofuAioMiniProfileItemBuilder.Holder.x(paramHolder).setTextColor(i4);
        TofuAioMiniProfileItemBuilder.Holder.z(paramHolder).setTextColor(i3);
      }
      else
      {
        TofuAioMiniProfileItemBuilder.Holder.g(paramHolder).setTextColor(k);
        TofuAioMiniProfileItemBuilder.Holder.h(paramHolder).setTextColor(k);
        TofuAioMiniProfileItemBuilder.Holder.i(paramHolder).setTextColor(k);
        TofuAioMiniProfileItemBuilder.Holder.m(paramHolder).setTextColor(m);
        TofuAioMiniProfileItemBuilder.Holder.n(paramHolder).setTextColor(m);
        TofuAioMiniProfileItemBuilder.Holder.s(paramHolder).setTextColor(m);
        TofuAioMiniProfileItemBuilder.Holder.v(paramHolder).setTextColor(k);
        TofuAioMiniProfileItemBuilder.Holder.b(paramHolder).setBackgroundColor(n);
        TofuAioMiniProfileItemBuilder.Holder.A(paramHolder).setBackgroundColor(i1);
        TofuAioMiniProfileItemBuilder.Holder.c(paramHolder).setBackgroundColor(i2);
        TofuAioMiniProfileItemBuilder.Holder.x(paramHolder).setTextColor(m);
        TofuAioMiniProfileItemBuilder.Holder.z(paramHolder).setTextColor(k);
      }
      if ((ThemeUtil.isSimpleDayTheme(false)) && (!ThemeUtil.isNowThemeIsNight(paramQQAppInterface, false, null))) {
        if (Build.VERSION.SDK_INT >= 21)
        {
          if (this.c != null) {
            TofuAioMiniProfileItemBuilder.Holder.a(paramHolder).setBackground(this.c.getResources().getDrawable(2130853384));
          }
        }
        else {
          TofuAioMiniProfileItemBuilder.Holder.A(paramHolder).setBackgroundColor(j);
        }
      }
      if (SimpleUIUtil.e())
      {
        TofuAioMiniProfileItemBuilder.Holder.B(paramHolder).setImageResource(2130847385);
        TofuAioMiniProfileItemBuilder.Holder.C(paramHolder).setImageResource(2130847382);
        TofuAioMiniProfileItemBuilder.Holder.D(paramHolder).setImageResource(2130847384);
        TofuAioMiniProfileItemBuilder.Holder.E(paramHolder).setImageResource(2130847370);
      }
      else
      {
        TofuAioMiniProfileItemBuilder.Holder.B(paramHolder).setImageResource(2130847380);
        TofuAioMiniProfileItemBuilder.Holder.C(paramHolder).setImageResource(2130847381);
        TofuAioMiniProfileItemBuilder.Holder.D(paramHolder).setImageResource(2130847383);
        TofuAioMiniProfileItemBuilder.Holder.E(paramHolder).setImageResource(2130847369);
      }
      j = this.h;
      k = AnonymousConstant.HEAD_BG_COLOR.length;
      TofuAioMiniProfileItemBuilder.Holder.C(paramHolder).clearColorFilter();
      TofuAioMiniProfileItemBuilder.Holder.C(paramHolder).setColorFilter(AnonymousConstant.HEAD_BG_COLOR[(j % k)]);
    }
  }
  
  private void a(TofuAioMiniProfileItemBuilder.Holder paramHolder, AnonymousQuestion paramAnonymousQuestion)
  {
    TofuAioMiniProfileItemBuilder.Holder.b(paramHolder).setVisibility(0);
    TofuAioMiniProfileItemBuilder.Holder.c(paramHolder).setVisibility(0);
    TofuAioMiniProfileItemBuilder.Holder.w(paramHolder).setVisibility(0);
    TofuAioMiniProfileItemBuilder.Holder.x(paramHolder).setText(paramAnonymousQuestion.mQuest);
    TofuAioMiniProfileItemBuilder.Holder.y(paramHolder).setImageBitmap(a(paramHolder.d, TofuAioMiniProfileItemBuilder.Holder.y(paramHolder)));
    TofuAioMiniProfileItemBuilder.Holder.z(paramHolder).setText(paramAnonymousQuestion.mAnswer);
    TofuAioMiniProfileItemBuilder.Holder.r(paramHolder).setVisibility(8);
    TofuAioMiniProfileItemBuilder.Holder.v(paramHolder).setVisibility(8);
    TofuAioMiniProfileItemBuilder.Holder.w(paramHolder).setOnClickListener(new TofuAioMiniProfileItemBuilder.5(this, paramHolder));
  }
  
  private void a(TofuAioMiniProfileItemBuilder.Holder paramHolder, MiniCard.BaseProfile paramBaseProfile)
  {
    if (paramBaseProfile == null)
    {
      TofuAioMiniProfileItemBuilder.Holder.f(paramHolder).setVisibility(8);
      return;
    }
    TofuAioMiniProfileItemBuilder.Holder.f(paramHolder).setVisibility(0);
    int j = paramBaseProfile.b;
    int n = 1;
    if ((j != 1) && (paramBaseProfile.b != 2))
    {
      TofuAioMiniProfileItemBuilder.Holder.g(paramHolder).setVisibility(8);
      j = 0;
    }
    else
    {
      TofuAioMiniProfileItemBuilder.Holder.g(paramHolder).setVisibility(0);
      TextView localTextView = TofuAioMiniProfileItemBuilder.Holder.g(paramHolder);
      if (paramBaseProfile.b == 1) {
        j = 2131891484;
      } else {
        j = 2131889246;
      }
      localTextView.setText(j);
      j = 1;
    }
    int k;
    if (paramBaseProfile.a >= 0)
    {
      TofuAioMiniProfileItemBuilder.Holder.h(paramHolder).setVisibility(0);
      TofuAioMiniProfileItemBuilder.Holder.h(paramHolder).setText(this.c.getResources().getString(2131886592, new Object[] { Integer.valueOf(paramBaseProfile.a) }));
      k = 1;
    }
    else
    {
      TofuAioMiniProfileItemBuilder.Holder.h(paramHolder).setVisibility(8);
      k = 0;
    }
    int m;
    if (!TextUtils.isEmpty(paramBaseProfile.c))
    {
      TofuAioMiniProfileItemBuilder.Holder.i(paramHolder).setVisibility(0);
      TofuAioMiniProfileItemBuilder.Holder.i(paramHolder).setText(paramBaseProfile.c);
      m = 1;
    }
    else
    {
      TofuAioMiniProfileItemBuilder.Holder.i(paramHolder).setVisibility(8);
      m = 0;
    }
    j = j + k + m;
    if (j == 3)
    {
      TofuAioMiniProfileItemBuilder.Holder.j(paramHolder).setVisibility(0);
      TofuAioMiniProfileItemBuilder.Holder.k(paramHolder).setVisibility(0);
    }
    else if (j == 2)
    {
      if ((k == 1) && (m == 1))
      {
        TofuAioMiniProfileItemBuilder.Holder.j(paramHolder).setVisibility(8);
        TofuAioMiniProfileItemBuilder.Holder.k(paramHolder).setVisibility(0);
      }
      else
      {
        TofuAioMiniProfileItemBuilder.Holder.j(paramHolder).setVisibility(0);
        TofuAioMiniProfileItemBuilder.Holder.k(paramHolder).setVisibility(8);
      }
    }
    else if (j == 1)
    {
      TofuAioMiniProfileItemBuilder.Holder.j(paramHolder).setVisibility(8);
      TofuAioMiniProfileItemBuilder.Holder.k(paramHolder).setVisibility(8);
    }
    else
    {
      TofuAioMiniProfileItemBuilder.Holder.j(paramHolder).setVisibility(8);
      TofuAioMiniProfileItemBuilder.Holder.k(paramHolder).setVisibility(8);
      TofuAioMiniProfileItemBuilder.Holder.l(paramHolder).setVisibility(8);
    }
    if (!TextUtils.isEmpty(paramBaseProfile.d))
    {
      TofuAioMiniProfileItemBuilder.Holder.m(paramHolder).setText(this.c.getResources().getString(2131886591, new Object[] { paramBaseProfile.d }));
      j = 1;
    }
    else
    {
      TofuAioMiniProfileItemBuilder.Holder.m(paramHolder).setVisibility(8);
      j = 0;
    }
    if (paramBaseProfile.e > 0)
    {
      TofuAioMiniProfileItemBuilder.Holder.n(paramHolder).setText(String.format(this.c.getResources().getString(2131886303), new Object[] { Integer.valueOf(paramBaseProfile.e) }));
      k = n;
    }
    else
    {
      TofuAioMiniProfileItemBuilder.Holder.n(paramHolder).setVisibility(8);
      k = 0;
    }
    if ((k != 0) && (j != 0))
    {
      TofuAioMiniProfileItemBuilder.Holder.o(paramHolder).setVisibility(0);
      return;
    }
    TofuAioMiniProfileItemBuilder.Holder.o(paramHolder).setVisibility(8);
  }
  
  private void a(TofuAioMiniProfileItemBuilder.Holder paramHolder, MiniCard.QZoneInfo paramQZoneInfo)
  {
    TofuAioMiniProfileItemBuilder.Holder.b(paramHolder).setVisibility(0);
    TofuAioMiniProfileItemBuilder.Holder.c(paramHolder).setVisibility(0);
    TofuAioMiniProfileItemBuilder.Holder.r(paramHolder).setVisibility(0);
    TextView localTextView = TofuAioMiniProfileItemBuilder.Holder.s(paramHolder);
    String str;
    if (TextUtils.isEmpty(paramQZoneInfo.a)) {
      str = this.c.getResources().getString(2131914011);
    } else {
      str = paramQZoneInfo.a;
    }
    localTextView.setText(str);
    if (TofuAioMiniProfileItemBuilder.Holder.t(paramHolder) != null)
    {
      if (TofuAioMiniProfileItemBuilder.Holder.t(paramHolder).a(paramQZoneInfo.c)) {
        return;
      }
      TofuAioMiniProfileItemBuilder.Holder.t(paramHolder).a(false);
      TofuAioMiniProfileItemBuilder.Holder.t(paramHolder).a();
    }
    else
    {
      TofuAioMiniProfileItemBuilder.Holder.a(paramHolder, new PictureAdapter(this.c, false));
    }
    TofuAioMiniProfileItemBuilder.Holder.t(paramHolder).b(paramQZoneInfo.c);
    TofuAioMiniProfileItemBuilder.Holder.u(paramHolder).setAdapter(TofuAioMiniProfileItemBuilder.Holder.t(paramHolder));
    TofuAioMiniProfileItemBuilder.Holder.u(paramHolder).setClickable(false);
    TofuAioMiniProfileItemBuilder.Holder.u(paramHolder).setEnabled(false);
    TofuAioMiniProfileItemBuilder.Holder.c(paramHolder).setOnTouchListener(UITools.a);
    TofuAioMiniProfileItemBuilder.Holder.c(paramHolder).setOnClickListener(new TofuAioMiniProfileItemBuilder.2(this));
    TofuAioMiniProfileItemBuilder.Holder.v(paramHolder).setVisibility(8);
    TofuAioMiniProfileItemBuilder.Holder.w(paramHolder).setVisibility(8);
  }
  
  private void a(TofuAioMiniProfileItemBuilder.Holder paramHolder, MiniCard.Sign paramSign)
  {
    TofuAioMiniProfileItemBuilder.Holder.b(paramHolder).setVisibility(0);
    TofuAioMiniProfileItemBuilder.Holder.c(paramHolder).setVisibility(0);
    TofuAioMiniProfileItemBuilder.Holder.v(paramHolder).setVisibility(0);
    if (paramSign.a != 0)
    {
      localObject = ((StatusManager)this.a.getManager(QQManagerFactory.STATUS_MANAGER)).a(paramSign.a, 200);
      localObject = new BitmapDrawable(this.c.getResources(), (Bitmap)localObject);
      int j = AIOUtils.b(12.0F, this.c.getResources());
      ((Drawable)localObject).setBounds(0, 0, Math.round(((Drawable)localObject).getIntrinsicWidth() * 1.0F / ((Drawable)localObject).getIntrinsicHeight() * j), j);
    }
    else
    {
      localObject = null;
    }
    TofuAioMiniProfileItemBuilder.Holder.v(paramHolder).setCompoundDrawables((Drawable)localObject, null, null, null);
    Object localObject = TofuAioMiniProfileItemBuilder.Holder.v(paramHolder);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramSign.b);
    localStringBuilder.append(" ");
    localStringBuilder.append(paramSign.c);
    ((TextView)localObject).setText(localStringBuilder.toString());
    TofuAioMiniProfileItemBuilder.Holder.c(paramHolder).setOnTouchListener(UITools.a);
    TofuAioMiniProfileItemBuilder.Holder.c(paramHolder).setOnClickListener(new TofuAioMiniProfileItemBuilder.4(this));
    TofuAioMiniProfileItemBuilder.Holder.r(paramHolder).setVisibility(8);
    TofuAioMiniProfileItemBuilder.Holder.w(paramHolder).setVisibility(8);
  }
  
  private void a(TofuAioMiniProfileItemBuilder.Holder paramHolder, boolean paramBoolean)
  {
    paramHolder = TofuAioMiniProfileItemBuilder.Holder.f(paramHolder).getLayoutParams();
    if (paramBoolean)
    {
      paramHolder.height = -2;
      return;
    }
    paramHolder.height = ViewUtils.dip2px(60.0F);
  }
  
  private void a(QQAppInterface paramQQAppInterface)
  {
    ThreadManager.post(new TofuAioMiniProfileItemBuilder.6(this), 8, null, false);
  }
  
  private void b(TofuAioMiniProfileItemBuilder.Holder paramHolder, List<String> paramList)
  {
    if ((paramList != null) && (paramList.size() != 0))
    {
      TofuAioMiniProfileItemBuilder.Holder.p(paramHolder).setVisibility(0);
      if (TofuAioMiniProfileItemBuilder.Holder.q(paramHolder) != null) {
        TofuAioMiniProfileItemBuilder.Holder.q(paramHolder).a();
      } else {
        TofuAioMiniProfileItemBuilder.Holder.a(paramHolder, new AioMiniProfileLabelListAdapter(this.c));
      }
      TofuAioMiniProfileItemBuilder.Holder.q(paramHolder).a(paramList);
      TofuAioMiniProfileItemBuilder.Holder.p(paramHolder).setAdapter(TofuAioMiniProfileItemBuilder.Holder.q(paramHolder));
      a(paramHolder, true);
      return;
    }
    TofuAioMiniProfileItemBuilder.Holder.p(paramHolder).setVisibility(8);
    a(paramHolder, false);
  }
  
  private void b(String paramString, TofuAioMiniProfileItemBuilder.Holder paramHolder)
  {
    TofuAioMiniProfileItemBuilder.Holder.e(paramHolder).a(0, TofuAioMiniProfileItemBuilder.Holder.d(paramHolder), false);
    if ((paramString != null) && (paramString.length() != 0))
    {
      Object localObject = this.a.getFaceBitmapCacheKey(1, paramString, (byte)3, 0, 100, true);
      localObject = this.a.getBitmapFromCache((String)localObject);
      if (localObject != null) {
        TofuAioMiniProfileItemBuilder.Holder.d(paramHolder).setImageBitmap((Bitmap)localObject);
      } else {
        TofuAioMiniProfileItemBuilder.Holder.d(paramHolder).setImageResource(2130841060);
      }
    }
    else
    {
      TofuAioMiniProfileItemBuilder.Holder.d(paramHolder).setImageResource(2130841060);
    }
    TofuAioMiniProfileItemBuilder.Holder.e(paramHolder).setOnClickListener(this);
    a(paramString, paramHolder);
  }
  
  private void c()
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("gotoSignatureHistory and uin:");
      if (this.d == null) {
        localObject = "null";
      } else {
        localObject = this.d.b;
      }
      localStringBuilder.append((String)localObject);
      localStringBuilder.append(" mContext:");
      localStringBuilder.append(this.c);
      QLog.i("TofuAioMiniProfileItemBuilder", 2, localStringBuilder.toString());
    }
    if ((this.d != null) && (!TextUtils.isEmpty(this.d.b)))
    {
      if (this.c == null) {
        return;
      }
      localObject = new Intent(this.c, PublicFragmentActivity.class);
      ((Intent)localObject).putExtra("key_uin", this.d.b);
      ((Intent)localObject).putExtra("key_uin_name", this.d.e);
      ((Intent)localObject).putExtra("key_open_via", "history-liaotian");
      PublicFragmentActivity.Launcher.a(this.c, (Intent)localObject, PublicFragmentActivity.class, SignatureHistoryFragment.class);
    }
  }
  
  private void d()
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("gotoProfileCard and uin:");
      if (this.d == null) {
        localObject = "null";
      } else {
        localObject = this.d.b;
      }
      localStringBuilder.append((String)localObject);
      localStringBuilder.append(" mContext:");
      localStringBuilder.append(this.c);
      QLog.i("TofuAioMiniProfileItemBuilder", 2, localStringBuilder.toString());
    }
    if ((this.d != null) && (!TextUtils.isEmpty(this.d.b)))
    {
      if (this.c == null) {
        return;
      }
      localObject = new AllInOne(this.d.b, 1);
      ProfileUtils.openProfileCard(this.c, (AllInOne)localObject);
    }
  }
  
  private void e()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("gotoQZoneUserHome and uin:");
      String str;
      if (this.d == null) {
        str = "null";
      } else {
        str = this.d.b;
      }
      localStringBuilder.append(str);
      localStringBuilder.append(" mContext:");
      localStringBuilder.append(this.c);
      QLog.i("TofuAioMiniProfileItemBuilder", 2, localStringBuilder.toString());
    }
    if ((this.d != null) && (!TextUtils.isEmpty(this.d.b)))
    {
      if (this.c == null) {
        return;
      }
      try
      {
        QZoneHelper.forwardToUserHome(this.c, QZoneHelper.UserInfo.getInstance(), this.d.b, 0, 0, 0);
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
      Bitmap localBitmap = this.e.getBitmapFromCache(1, paramString);
      if (localBitmap != null) {
        return localBitmap;
      }
      if (!this.e.isPausing())
      {
        this.e.requestDecodeFace(paramString, 200, true);
        this.f.put(paramString, paramImageView);
      }
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return ImageUtil.k();
  }
  
  protected View a(MessageRecord paramMessageRecord, AbstractChatItemBuilder.ViewHolder paramViewHolder, View paramView, LinearLayout paramLinearLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    paramLinearLayout = (MessageForTofuAioMiniProfile)paramMessageRecord;
    paramMessageRecord = (TofuAioMiniProfileItemBuilder.Holder)paramViewHolder;
    paramViewHolder = a(paramView, paramMessageRecord);
    paramMessageRecord.d = paramLinearLayout.frienduin;
    if (QLog.isColorLevel())
    {
      paramView = new StringBuilder();
      paramView.append("getItemView and miniCard:");
      paramView.append(paramLinearLayout.miniCard);
      QLog.i("TofuAioMiniProfileItemBuilder", 2, paramView.toString());
    }
    if (paramLinearLayout.miniCard != null)
    {
      int j = ViewUtils.dip2px(16.0F);
      TofuAioMiniProfileItemBuilder.Holder.a(paramMessageRecord).enablePressEffect(true);
      paramView = TofuAioMiniProfileItemBuilder.Holder.a(paramMessageRecord);
      float f1 = j;
      paramView.setRadius(f1, f1, f1, f1);
      TofuAioMiniProfileItemBuilder.Holder.a(paramMessageRecord).setOnClickListener(this);
      TofuAioMiniProfileItemBuilder.Holder.a(paramMessageRecord).setOnTouchListener(UITools.a);
      paramViewHolder.setVisibility(0);
      b(paramMessageRecord.d, paramMessageRecord);
      a(paramMessageRecord, paramLinearLayout.miniCard.a);
      b(paramMessageRecord, paramLinearLayout.miniCard.b);
      if ((paramLinearLayout.miniCard.c != null) && (paramLinearLayout.miniCard.c.c != null) && (paramLinearLayout.miniCard.c.c.size() > 0))
      {
        a(paramMessageRecord, paramLinearLayout.miniCard.c);
        this.g = "空间";
      }
      else if (paramLinearLayout.miniCard.f != null)
      {
        a(paramMessageRecord, paramLinearLayout.miniCard.f);
        this.g = "匿问我答";
      }
      else if ((paramLinearLayout.miniCard.d != null) && (paramLinearLayout.miniCard.d.size() > 0))
      {
        a(paramMessageRecord, paramLinearLayout.miniCard.d);
        this.g = "精选照片";
      }
      else if (paramLinearLayout.miniCard.e != null)
      {
        a(paramMessageRecord, paramLinearLayout.miniCard.e);
        this.g = "个性签名";
      }
      else
      {
        TofuAioMiniProfileItemBuilder.Holder.b(paramMessageRecord).setVisibility(8);
        TofuAioMiniProfileItemBuilder.Holder.c(paramMessageRecord).setVisibility(8);
        this.g = "无信息";
      }
      a(paramMessageRecord, this.a);
    }
    else
    {
      paramViewHolder.setVisibility(8);
    }
    if (!paramMessageRecord.e)
    {
      paramMessageRecord.e = true;
      ThreadManagerV2.excute(new TofuAioMiniProfileItemBuilder.1(this, paramMessageRecord), 128, null, true);
      ReportController.b(null, "dc00898", "", "", "0X800B1A8", "0X800B1A8", 0, 0, "", "", this.g, "");
      if ("匿问我答".equals(this.g))
      {
        try
        {
          paramLinearLayout.miniCard.f.mOwnerUin = Long.parseLong(paramMessageRecord.d);
          ((AnonymousHandler)this.a.getBusinessHandler(BusinessHandlerFactory.ANONYMOUS_ANSWER_HANDLER)).browseAskAnonymouslyReport(paramLinearLayout.miniCard.f);
        }
        catch (Exception paramView)
        {
          paramLinearLayout = new StringBuilder();
          paramLinearLayout.append("report exception ");
          paramLinearLayout.append(paramView);
          QLog.e("TofuAioMiniProfileItemBuilder", 1, paramLinearLayout.toString());
        }
        ReportController.b(null, "dc00898", "", paramMessageRecord.d, "0X800B5BE", "0X800B5BE", 0, 0, "", "", "", "");
      }
    }
    return paramViewHolder;
  }
  
  protected AbstractChatItemBuilder.ViewHolder a()
  {
    return new TofuAioMiniProfileItemBuilder.Holder();
  }
  
  public void a(TofuAioMiniProfileItemBuilder.Holder paramHolder, List<MiniCard.NicePicInfo> paramList)
  {
    TofuAioMiniProfileItemBuilder.Holder.b(paramHolder).setVisibility(0);
    TofuAioMiniProfileItemBuilder.Holder.c(paramHolder).setVisibility(0);
    TofuAioMiniProfileItemBuilder.Holder.r(paramHolder).setVisibility(0);
    TofuAioMiniProfileItemBuilder.Holder.s(paramHolder).setText(this.c.getResources().getString(2131892890));
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      paramList = (MiniCard.NicePicInfo)localIterator.next();
      if ((!TextUtils.isEmpty(paramList.a)) && (!TextUtils.isEmpty(paramList.b)))
      {
        localArrayList1.add(paramList.a);
        if (!TextUtils.isEmpty(paramList.b)) {
          paramList = paramList.b;
        } else {
          paramList = paramList.a;
        }
        localArrayList2.add(paramList);
      }
    }
    if (TofuAioMiniProfileItemBuilder.Holder.t(paramHolder) != null)
    {
      if (TofuAioMiniProfileItemBuilder.Holder.t(paramHolder).a(localArrayList2)) {
        return;
      }
      TofuAioMiniProfileItemBuilder.Holder.t(paramHolder).a();
      TofuAioMiniProfileItemBuilder.Holder.t(paramHolder).a(true);
    }
    else
    {
      TofuAioMiniProfileItemBuilder.Holder.a(paramHolder, new PictureAdapter(this.c, true));
    }
    TofuAioMiniProfileItemBuilder.Holder.t(paramHolder).b(localArrayList2);
    TofuAioMiniProfileItemBuilder.Holder.u(paramHolder).setAdapter(TofuAioMiniProfileItemBuilder.Holder.t(paramHolder));
    TofuAioMiniProfileItemBuilder.Holder.u(paramHolder).setClickable(true);
    TofuAioMiniProfileItemBuilder.Holder.u(paramHolder).setEnabled(true);
    TofuAioMiniProfileItemBuilder.Holder.c(paramHolder).setOnTouchListener(null);
    TofuAioMiniProfileItemBuilder.Holder.c(paramHolder).setOnClickListener(null);
    TofuAioMiniProfileItemBuilder.Holder.u(paramHolder).setOnItemClickListener(new TofuAioMiniProfileItemBuilder.3(this, localArrayList1));
    TofuAioMiniProfileItemBuilder.Holder.v(paramHolder).setVisibility(8);
    TofuAioMiniProfileItemBuilder.Holder.w(paramHolder).setVisibility(8);
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
    Object localObject = FaceDrawable.getUserFaceDrawable(this.a, paramString, (byte)3);
    TofuAioMiniProfileItemBuilder.Holder.e(paramHolder).setFaceDrawable(this.a, (Drawable)localObject, 1, paramString, 200, true, true, 8);
  }
  
  public QQCustomMenuItem[] a(View paramView)
  {
    return new QQCustomMenuItem[0];
  }
  
  public void b()
  {
    super.b();
    Object localObject = this.e;
    if (localObject != null) {
      ((IFaceDecoder)localObject).destory();
    }
    localObject = this.f;
    if (localObject != null) {
      ((Map)localObject).clear();
    }
    this.a.removeObserver(this.i);
  }
  
  public void onClick(View paramView)
  {
    int j = paramView.getId();
    if (j != 2131428163)
    {
      if (j == 2131444932)
      {
        ReportController.b(null, "dc00898", "", "", "0X800B1A9", "0X800B1A9", 0, 0, "", "", this.g, "空白处");
        d();
      }
    }
    else
    {
      ReportController.b(null, "dc00898", "", "", "0X800B1A9", "0X800B1A9", 0, 0, "", "", this.g, "头像");
      d();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    paramString = (ImageView)this.f.get(paramString);
    if (paramString != null) {
      paramString.setImageBitmap(paramBitmap);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.TofuAioMiniProfileItemBuilder
 * JD-Core Version:    0.7.0.1
 */