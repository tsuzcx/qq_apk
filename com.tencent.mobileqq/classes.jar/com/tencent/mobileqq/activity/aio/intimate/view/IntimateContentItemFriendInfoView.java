package com.tencent.mobileqq.activity.aio.intimate.view;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.intimate.BaseIntimateView;
import com.tencent.mobileqq.activity.aio.intimate.IntimateUtil;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.config.business.FriendIntimateRelationshipBean;
import com.tencent.mobileqq.config.business.FriendIntimateRelationshipConfProcessor;
import com.tencent.mobileqq.data.IntimateInfo;
import com.tencent.mobileqq.data.IntimateInfo.IntimateScoreCardInfo;
import com.tencent.mobileqq.kandian.base.view.widget.ticker.TickerView;
import com.tencent.mobileqq.multicard.MultiCardCustomViewDelegate;
import com.tencent.mobileqq.mutualmark.oldlogic.FriendIntimateRelationshipHelper;
import com.tencent.mobileqq.profile.TroopMemberCardUtils;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.utils.ProfileUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.webview.util.WebViewComUtils;
import com.tencent.qphone.base.util.QLog;

public class IntimateContentItemFriendInfoView
  extends IntimateContentItemBaseView
{
  Runnable i = new IntimateContentItemFriendInfoView.2(this);
  private ImageView j;
  private ImageView k;
  private TickerView l;
  private TextView m;
  private TextView n;
  private LinearLayout o;
  private TextView p;
  private View q;
  private TextView r;
  private TextView s;
  
  public IntimateContentItemFriendInfoView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public IntimateContentItemFriendInfoView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public IntimateContentItemFriendInfoView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private Bitmap a(Bitmap paramBitmap)
  {
    if ((paramBitmap != null) && (!paramBitmap.isRecycled()))
    {
      int i1 = Math.min(paramBitmap.getWidth(), paramBitmap.getHeight()) + 8;
      Bitmap localBitmap = Bitmap.createBitmap(i1, i1, Bitmap.Config.ARGB_8888);
      Canvas localCanvas = new Canvas(localBitmap);
      Paint localPaint = new Paint();
      float f1 = i1 / 2.0F;
      localPaint.setAntiAlias(true);
      localCanvas.drawARGB(0, 0, 0, 0);
      localPaint.setColor(-1);
      float f2 = 8 / 2.0F;
      localCanvas.drawBitmap(paramBitmap, f2, f2, localPaint);
      localPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_ATOP));
      localCanvas.drawCircle(f1, f1, f1, localPaint);
      return localBitmap;
    }
    return paramBitmap;
  }
  
  private void a(int paramInt)
  {
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 3)
        {
          if (paramInt != 26)
          {
            ReportController.b(null, "dc00898", "", "", "0X800B565", "0X800B565", 4, 0, "", "", "", "");
            return;
          }
          ReportController.b(null, "dc00898", "", "", "0X800B565", "0X800B565", 5, 0, "", "", "", "");
          return;
        }
        ReportController.b(null, "dc00898", "", "", "0X800B565", "0X800B565", 3, 0, "", "", "", "");
        return;
      }
      ReportController.b(null, "dc00898", "", "", "0X800B565", "0X800B565", 2, 0, "", "", "", "");
      return;
    }
    ReportController.b(null, "dc00898", "", "", "0X800B565", "0X800B565", 1, 0, "", "", "", "");
  }
  
  private void a(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (WebViewComUtils.a(1000L)))
    {
      Intent localIntent = new Intent(this.a, QQBrowserActivity.class);
      localIntent.putExtra("url", paramString);
      localIntent.putExtra("startOpenPageTime", System.currentTimeMillis());
      this.a.startActivity(localIntent);
    }
  }
  
  private void o()
  {
    if (!this.g) {
      return;
    }
    if (this.d != null)
    {
      this.d.lastAnimAfterFriendDays = this.d.beFriendDays;
      ThreadManager.postImmediately(new IntimateContentItemFriendInfoView.1(this), null, true);
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onDaysUpdated intimateInfo: ");
      localStringBuilder.append(this.d);
      QLog.d("intimate_relationship", 2, localStringBuilder.toString());
    }
  }
  
  private void p()
  {
    if (!this.g) {
      return;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("checkAndStartUpdateAnim isResumed:");
      localStringBuilder.append(this.b);
      localStringBuilder.append(" currentShowType:");
      localStringBuilder.append(this.f);
      localStringBuilder.append(" intimateInfo:");
      localStringBuilder.append(this.d);
      QLog.i("IntimateContentItemFriendInfoView", 2, localStringBuilder.toString());
    }
    if ((this.b) && (this.d != null))
    {
      removeCallbacks(this.i);
      if ((q()) && (this.d.lastAnimAfterFriendDays != this.d.beFriendDays) && (this.d.beFriendDays > 0)) {
        postDelayed(this.i, 300L);
      }
    }
  }
  
  private boolean q()
  {
    boolean bool;
    if (this.f == 4) {
      bool = false;
    } else {
      bool = true;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("canUpdateAnim res: ");
      localStringBuilder.append(bool);
      localStringBuilder.append("  currentShowType:");
      localStringBuilder.append(this.f);
      QLog.d("IntimateContentItemFriendInfoView", 2, localStringBuilder.toString());
    }
    return bool;
  }
  
  private void r()
  {
    if (!this.g) {
      return;
    }
    int i4 = Math.max(0, this.d.lastAnimAfterFriendDays);
    int i3 = Math.max(0, this.d.beFriendDays);
    boolean bool = QLog.isColorLevel();
    int i2 = 2;
    if (bool)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("smoothUpdateDays fromDays:");
      ((StringBuilder)localObject).append(i4);
      ((StringBuilder)localObject).append(" toDays:");
      ((StringBuilder)localObject).append(i3);
      QLog.i("IntimateContentItemFriendInfoView", 2, ((StringBuilder)localObject).toString());
    }
    if (i4 <= 0)
    {
      int i5 = String.valueOf(i3).length();
      localObject = "";
      i1 = 0;
      while ((i1 < i5) && (i1 < 5))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append((String)localObject);
        localStringBuilder.append("0");
        localObject = localStringBuilder.toString();
        i1 += 1;
      }
      this.l.setText((String)localObject, false);
    }
    Object localObject = this.l;
    int i1 = i2;
    if (i3 > i4) {
      i1 = 1;
    }
    ((TickerView)localObject).setPreferredScrollingDirection(i1);
    this.l.setDigitalAnimWidthSpeedIncrement(true);
    this.l.setIgnoreWidthAnim(true);
    this.l.setText(String.valueOf(i3));
    this.m.setVisibility(0);
    o();
  }
  
  private void s()
  {
    if (this.h != null)
    {
      if (this.d == null) {
        return;
      }
      String str = this.h.k();
      int i1 = this.d.maskType;
      if (IntimateUtil.a(i1))
      {
        Object localObject = FriendIntimateRelationshipHelper.c();
        if ((!TextUtils.isEmpty((CharSequence)localObject)) && (((String)localObject).contains("frd_uin=")) && (((String)localObject).contains("frd_type=")))
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("frd_uin=");
          localStringBuilder.append(str);
          str = ((String)localObject).replace("frd_uin=", localStringBuilder.toString());
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("frd_type=");
          ((StringBuilder)localObject).append(i1);
          str = str.replace("frd_type=", ((StringBuilder)localObject).toString());
          a(i1);
          a(str);
        }
      }
      else
      {
        str = FriendIntimateRelationshipHelper.b(str);
        a(i1);
        a(str);
      }
    }
  }
  
  public void a(Bitmap paramBitmap, String paramString)
  {
    if (!this.g) {
      return;
    }
    if (paramString.equals(this.h.k()))
    {
      paramBitmap = a(paramBitmap);
      if ((paramBitmap != null) && (!paramBitmap.isRecycled())) {
        this.k.setImageBitmap(paramBitmap);
      }
    }
    else if ((this.h.n() != null) && (paramString.equals(this.h.n().getCurrentAccountUin())))
    {
      paramBitmap = a(paramBitmap);
      if ((paramBitmap != null) && (!paramBitmap.isRecycled())) {
        this.j.setImageBitmap(paramBitmap);
      }
    }
  }
  
  protected void a(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131445565: 
      if (this.h.m() == null)
      {
        paramView = new AllInOne(this.h.n().getCurrentAccountUin(), 0);
        ProfileUtils.openProfileCard(this.h.l(), paramView);
        return;
      }
      paramView = this.h.m().m();
      if (!TextUtils.isEmpty(paramView))
      {
        TroopMemberCardUtils.a(this.h.n(), this.a, paramView, this.h.n().getCurrentAccountUin(), 0, -1);
        return;
      }
      QLog.e("intimate_relationship", 2, "open troop member card troop uin empty");
      return;
    case 2131435280: 
    case 2131439286: 
      s();
      return;
    }
    if (this.h.m() == null)
    {
      paramView = new AllInOne(this.h.k(), 1);
      ProfileUtils.openProfileCard(this.h.l(), paramView);
      return;
    }
    paramView = this.h.m().m();
    if (!TextUtils.isEmpty(paramView))
    {
      TroopMemberCardUtils.a(this.h.n(), this.a, paramView, this.h.k(), 0, -1);
      return;
    }
    QLog.e("intimate_relationship", 2, "open troop member card troop uin empty");
  }
  
  protected void a(IntimateInfo paramIntimateInfo, int paramInt)
  {
    int i2 = paramIntimateInfo.beFriendDays;
    int i1 = i2;
    if (q())
    {
      i1 = i2;
      if (paramIntimateInfo.beFriendDays > 0) {
        i1 = Math.max(0, paramIntimateInfo.lastAnimAfterFriendDays);
      }
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("updateIntimateInfo beFriendDays: ");
      ((StringBuilder)localObject).append(i1);
      QLog.d("IntimateContentItemFriendInfoView", 2, ((StringBuilder)localObject).toString());
    }
    if (i1 >= -1)
    {
      if (i1 == 0)
      {
        localObject = this.a.getResources().getString(2131890951);
        this.m.setVisibility(8);
      }
      else
      {
        if (i1 == -1) {
          localObject = "999+";
        } else {
          localObject = String.valueOf(i1);
        }
        this.m.setVisibility(0);
      }
      this.l.setText((String)localObject, false);
      i1 = 2130846934;
      if (paramInt == 3)
      {
        this.n.setText(2131890953);
        this.o.setBackgroundResource(2130846926);
        this.q.setBackgroundColor(getResources().getColor(2131167268));
        this.s.setBackgroundResource(2130846932);
        i2 = 2131166323;
        paramInt = 2131166322;
        i1 = 2130846932;
      }
      else if (paramInt == 2)
      {
        this.n.setText(2131890952);
        this.o.setBackgroundResource(2130846925);
        this.q.setBackgroundColor(getResources().getColor(2131167267));
        this.s.setBackgroundResource(2130846931);
        i2 = 2131166321;
        paramInt = 2131166320;
        i1 = 2130846931;
      }
      else if (paramInt == 1)
      {
        this.n.setText(2131890954);
        this.o.setBackgroundResource(2130846927);
        this.q.setBackgroundColor(getResources().getColor(2131167269));
        this.s.setBackgroundResource(2130846933);
        i2 = 2131166325;
        paramInt = 2131166324;
        i1 = 2130846933;
      }
      else if (paramInt == 26)
      {
        this.n.setText(2131890955);
        this.o.setBackgroundResource(2130846928);
        this.q.setBackgroundColor(getResources().getColor(2131167270));
        this.s.setBackgroundResource(2130846934);
        i2 = 2131166327;
        paramInt = 2131166326;
      }
      else
      {
        this.n.setText(2131890949);
        this.o.setBackgroundResource(2130846924);
        this.q.setBackgroundColor(getResources().getColor(2131167266));
        this.s.setBackgroundResource(2130846930);
        i2 = 2131166328;
        paramInt = 2131166329;
        i1 = 2130846930;
      }
      if ((paramIntimateInfo.scoreCardInfo != null) && (!TextUtils.isEmpty(paramIntimateInfo.scoreCardInfo.typeDescribe)))
      {
        this.p.setText(paramIntimateInfo.scoreCardInfo.typeDescribe);
        this.r.setText(String.format(this.a.getString(2131890969), new Object[] { Integer.valueOf(paramIntimateInfo.scoreCardInfo.score) }));
        this.o.setVisibility(0);
      }
      else
      {
        this.o.setVisibility(8);
      }
      if ((paramIntimateInfo.scoreCardInfo != null) && (!TextUtils.isEmpty(paramIntimateInfo.scoreCardInfo.levelDescribe)))
      {
        this.s.setText(paramIntimateInfo.scoreCardInfo.levelDescribe);
        this.s.setVisibility(0);
      }
      else
      {
        this.s.setVisibility(8);
      }
      this.l.setTextColor(this.a.getResources().getColor(i2));
      this.m.setTextColor(this.a.getResources().getColor(i2));
      this.n.setTextColor(this.a.getResources().getColor(i2));
      this.s.setTextColor(this.a.getResources().getColor(paramInt));
      this.s.setBackgroundResource(i1);
    }
    else
    {
      this.l.setText("");
      this.m.setVisibility(8);
      this.n.setText("");
      this.r.setVisibility(4);
      this.s.setVisibility(4);
    }
    p();
    Object localObject = FriendIntimateRelationshipConfProcessor.a();
    if (paramIntimateInfo.currentScore >= ((FriendIntimateRelationshipBean)localObject).U)
    {
      this.o.setVisibility(0);
      this.s.setVisibility(0);
      return;
    }
    this.o.setVisibility(8);
    this.s.setVisibility(8);
  }
  
  protected boolean a()
  {
    return true;
  }
  
  protected void b()
  {
    View localView = LayoutInflater.from(this.a).inflate(2131625175, this, true);
    this.j = ((ImageView)localView.findViewById(2131445565));
    this.k = ((ImageView)localView.findViewById(2131433781));
    this.l = ((TickerView)localView.findViewById(2131435877));
    this.m = ((TextView)localView.findViewById(2131435876));
    this.n = ((TextView)localView.findViewById(2131435874));
    this.o = ((LinearLayout)localView.findViewById(2131435280));
    this.p = ((TextView)localView.findViewById(2131431528));
    this.q = localView.findViewById(2131435279);
    this.r = ((TextView)localView.findViewById(2131431529));
    this.s = ((TextView)localView.findViewById(2131439286));
    this.l.setCharacterLists(new String[] { "9876543210" });
    this.l.setAnimationDuration(2000L);
    this.o.setOnClickListener(this);
    this.s.setOnClickListener(this);
    this.j.setOnClickListener(this);
    this.k.setOnClickListener(this);
    this.j.setOnTouchListener(this);
    this.k.setOnTouchListener(this);
    this.o.setOnTouchListener(this);
    this.s.setOnTouchListener(this);
    if (AppSetting.e)
    {
      this.k.setContentDescription(HardCodeUtil.a(2131903782));
      this.j.setContentDescription(HardCodeUtil.a(2131903780));
    }
  }
  
  protected void c()
  {
    p();
  }
  
  protected void d()
  {
    removeCallbacks(this.i);
  }
  
  protected void e()
  {
    p();
  }
  
  protected void f()
  {
    removeCallbacks(this.i);
  }
  
  protected void g()
  {
    removeCallbacks(this.i);
  }
  
  public void n()
  {
    if (!this.g) {
      return;
    }
    Bitmap localBitmap = this.h.b(this.h.n().getCurrentAccountUin());
    if (localBitmap != null)
    {
      localBitmap = a(localBitmap);
      if ((localBitmap != null) && (!localBitmap.isRecycled())) {
        this.j.setImageBitmap(localBitmap);
      }
    }
    if (!TextUtils.isEmpty(this.h.k()))
    {
      localBitmap = this.h.b(this.h.k());
      if (localBitmap != null)
      {
        localBitmap = a(localBitmap);
        if ((localBitmap != null) && (!localBitmap.isRecycled())) {
          this.k.setImageBitmap(localBitmap);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.intimate.view.IntimateContentItemFriendInfoView
 * JD-Core Version:    0.7.0.1
 */