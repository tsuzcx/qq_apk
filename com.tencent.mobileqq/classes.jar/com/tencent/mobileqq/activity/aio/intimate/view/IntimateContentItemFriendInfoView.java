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
  private View jdField_a_of_type_AndroidViewView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private TickerView jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetTickerTickerView;
  Runnable jdField_a_of_type_JavaLangRunnable = new IntimateContentItemFriendInfoView.2(this);
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private TextView c;
  private TextView d;
  private TextView e;
  
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
      int i = Math.min(paramBitmap.getWidth(), paramBitmap.getHeight()) + 8;
      Bitmap localBitmap = Bitmap.createBitmap(i, i, Bitmap.Config.ARGB_8888);
      Canvas localCanvas = new Canvas(localBitmap);
      Paint localPaint = new Paint();
      float f1 = i / 2.0F;
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
      Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
      localIntent.putExtra("url", paramString);
      localIntent.putExtra("startOpenPageTime", System.currentTimeMillis());
      this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
    }
  }
  
  private boolean b()
  {
    boolean bool;
    if (this.jdField_b_of_type_Int == 4) {
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
      localStringBuilder.append(this.jdField_b_of_type_Int);
      QLog.d("IntimateContentItemFriendInfoView", 2, localStringBuilder.toString());
    }
    return bool;
  }
  
  private void n()
  {
    if (!this.jdField_c_of_type_Boolean) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo.lastAnimAfterFriendDays = this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo.beFriendDays;
      ThreadManager.postImmediately(new IntimateContentItemFriendInfoView.1(this), null, true);
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onDaysUpdated intimateInfo: ");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo);
      QLog.d("intimate_relationship", 2, localStringBuilder.toString());
    }
  }
  
  private void o()
  {
    if (!this.jdField_c_of_type_Boolean) {
      return;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("checkAndStartUpdateAnim isResumed:");
      localStringBuilder.append(this.jdField_a_of_type_Boolean);
      localStringBuilder.append(" currentShowType:");
      localStringBuilder.append(this.jdField_b_of_type_Int);
      localStringBuilder.append(" intimateInfo:");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo);
      QLog.i("IntimateContentItemFriendInfoView", 2, localStringBuilder.toString());
    }
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo != null))
    {
      removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      if ((b()) && (this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo.lastAnimAfterFriendDays != this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo.beFriendDays) && (this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo.beFriendDays > 0)) {
        postDelayed(this.jdField_a_of_type_JavaLangRunnable, 300L);
      }
    }
  }
  
  private void p()
  {
    if (!this.jdField_c_of_type_Boolean) {
      return;
    }
    int m = Math.max(0, this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo.lastAnimAfterFriendDays);
    int k = Math.max(0, this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo.beFriendDays);
    boolean bool = QLog.isColorLevel();
    int j = 2;
    if (bool)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("smoothUpdateDays fromDays:");
      ((StringBuilder)localObject).append(m);
      ((StringBuilder)localObject).append(" toDays:");
      ((StringBuilder)localObject).append(k);
      QLog.i("IntimateContentItemFriendInfoView", 2, ((StringBuilder)localObject).toString());
    }
    if (m <= 0)
    {
      int n = String.valueOf(k).length();
      localObject = "";
      i = 0;
      while ((i < n) && (i < 5))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append((String)localObject);
        localStringBuilder.append("0");
        localObject = localStringBuilder.toString();
        i += 1;
      }
      this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetTickerTickerView.setText((String)localObject, false);
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetTickerTickerView;
    int i = j;
    if (k > m) {
      i = 1;
    }
    ((TickerView)localObject).setPreferredScrollingDirection(i);
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetTickerTickerView.setDigitalAnimWidthSpeedIncrement(true);
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetTickerTickerView.setIgnoreWidthAnim(true);
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetTickerTickerView.setText(String.valueOf(k));
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    n();
  }
  
  private void q()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateBaseIntimateView != null)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo == null) {
        return;
      }
      String str = this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateBaseIntimateView.a();
      int i = this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo.maskType;
      if (IntimateUtil.a(i))
      {
        Object localObject = FriendIntimateRelationshipHelper.b();
        if ((!TextUtils.isEmpty((CharSequence)localObject)) && (((String)localObject).contains("frd_uin=")) && (((String)localObject).contains("frd_type=")))
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("frd_uin=");
          localStringBuilder.append(str);
          str = ((String)localObject).replace("frd_uin=", localStringBuilder.toString());
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("frd_type=");
          ((StringBuilder)localObject).append(i);
          str = str.replace("frd_type=", ((StringBuilder)localObject).toString());
          a(i);
          a(str);
        }
      }
      else
      {
        str = FriendIntimateRelationshipHelper.a(str);
        a(i);
        a(str);
      }
    }
  }
  
  protected void a()
  {
    View localView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131559254, this, true);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131377184));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131367324));
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetTickerTickerView = ((TickerView)localView.findViewById(2131368928));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131368927));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131368925));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)localView.findViewById(2131368396));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131365344));
    this.jdField_a_of_type_AndroidViewView = localView.findViewById(2131368395);
    this.d = ((TextView)localView.findViewById(2131365345));
    this.e = ((TextView)localView.findViewById(2131371847));
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetTickerTickerView.setCharacterLists(new String[] { "9876543210" });
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetTickerTickerView.setAnimationDuration(2000L);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener(this);
    this.e.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetImageView.setOnTouchListener(this);
    this.jdField_b_of_type_AndroidWidgetImageView.setOnTouchListener(this);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setOnTouchListener(this);
    this.e.setOnTouchListener(this);
    if (AppSetting.d)
    {
      this.jdField_b_of_type_AndroidWidgetImageView.setContentDescription(HardCodeUtil.a(2131705901));
      this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(HardCodeUtil.a(2131705899));
    }
  }
  
  public void a(Bitmap paramBitmap, String paramString)
  {
    if (!this.jdField_c_of_type_Boolean) {
      return;
    }
    if (paramString.equals(this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateBaseIntimateView.a()))
    {
      paramBitmap = a(paramBitmap);
      if ((paramBitmap != null) && (!paramBitmap.isRecycled())) {
        this.jdField_b_of_type_AndroidWidgetImageView.setImageBitmap(paramBitmap);
      }
    }
    else if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateBaseIntimateView.a() != null) && (paramString.equals(this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateBaseIntimateView.a().getCurrentAccountUin())))
    {
      paramBitmap = a(paramBitmap);
      if ((paramBitmap != null) && (!paramBitmap.isRecycled())) {
        this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(paramBitmap);
      }
    }
  }
  
  protected void a(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131377184: 
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateBaseIntimateView.a() == null)
      {
        paramView = new AllInOne(this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateBaseIntimateView.a().getCurrentAccountUin(), 0);
        ProfileUtils.openProfileCard(this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateBaseIntimateView.a(), paramView);
        return;
      }
      paramView = this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateBaseIntimateView.a().a();
      if (!TextUtils.isEmpty(paramView))
      {
        TroopMemberCardUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateBaseIntimateView.a(), this.jdField_a_of_type_AndroidContentContext, paramView, this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateBaseIntimateView.a().getCurrentAccountUin(), 0, -1);
        return;
      }
      QLog.e("intimate_relationship", 2, "open troop member card troop uin empty");
      return;
    case 2131368396: 
    case 2131371847: 
      q();
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateBaseIntimateView.a() == null)
    {
      paramView = new AllInOne(this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateBaseIntimateView.a(), 1);
      ProfileUtils.openProfileCard(this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateBaseIntimateView.a(), paramView);
      return;
    }
    paramView = this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateBaseIntimateView.a().a();
    if (!TextUtils.isEmpty(paramView))
    {
      TroopMemberCardUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateBaseIntimateView.a(), this.jdField_a_of_type_AndroidContentContext, paramView, this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateBaseIntimateView.a(), 0, -1);
      return;
    }
    QLog.e("intimate_relationship", 2, "open troop member card troop uin empty");
  }
  
  protected void a(IntimateInfo paramIntimateInfo, int paramInt)
  {
    int j = paramIntimateInfo.beFriendDays;
    int i = j;
    if (b())
    {
      i = j;
      if (paramIntimateInfo.beFriendDays > 0) {
        i = Math.max(0, paramIntimateInfo.lastAnimAfterFriendDays);
      }
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("updateIntimateInfo beFriendDays: ");
      ((StringBuilder)localObject).append(i);
      QLog.d("IntimateContentItemFriendInfoView", 2, ((StringBuilder)localObject).toString());
    }
    if (i >= -1)
    {
      if (i == 0)
      {
        localObject = this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131693402);
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      }
      else
      {
        if (i == -1) {
          localObject = "999+";
        } else {
          localObject = String.valueOf(i);
        }
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      }
      this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetTickerTickerView.setText((String)localObject, false);
      i = 2130845478;
      if (paramInt == 3)
      {
        this.jdField_b_of_type_AndroidWidgetTextView.setText(2131693404);
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setBackgroundResource(2130845470);
        this.jdField_a_of_type_AndroidViewView.setBackgroundColor(getResources().getColor(2131166429));
        this.e.setBackgroundResource(2130845476);
        j = 2131165729;
        paramInt = 2131165728;
        i = 2130845476;
      }
      else if (paramInt == 2)
      {
        this.jdField_b_of_type_AndroidWidgetTextView.setText(2131693403);
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setBackgroundResource(2130845469);
        this.jdField_a_of_type_AndroidViewView.setBackgroundColor(getResources().getColor(2131166428));
        this.e.setBackgroundResource(2130845475);
        j = 2131165727;
        paramInt = 2131165726;
        i = 2130845475;
      }
      else if (paramInt == 1)
      {
        this.jdField_b_of_type_AndroidWidgetTextView.setText(2131693405);
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setBackgroundResource(2130845471);
        this.jdField_a_of_type_AndroidViewView.setBackgroundColor(getResources().getColor(2131166430));
        this.e.setBackgroundResource(2130845477);
        j = 2131165731;
        paramInt = 2131165730;
        i = 2130845477;
      }
      else if (paramInt == 26)
      {
        this.jdField_b_of_type_AndroidWidgetTextView.setText(2131693406);
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setBackgroundResource(2130845472);
        this.jdField_a_of_type_AndroidViewView.setBackgroundColor(getResources().getColor(2131166431));
        this.e.setBackgroundResource(2130845478);
        j = 2131165733;
        paramInt = 2131165732;
      }
      else
      {
        this.jdField_b_of_type_AndroidWidgetTextView.setText(2131693400);
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setBackgroundResource(2130845468);
        this.jdField_a_of_type_AndroidViewView.setBackgroundColor(getResources().getColor(2131166427));
        this.e.setBackgroundResource(2130845474);
        j = 2131165734;
        paramInt = 2131165735;
        i = 2130845474;
      }
      if ((paramIntimateInfo.scoreCardInfo != null) && (!TextUtils.isEmpty(paramIntimateInfo.scoreCardInfo.typeDescribe)))
      {
        this.jdField_c_of_type_AndroidWidgetTextView.setText(paramIntimateInfo.scoreCardInfo.typeDescribe);
        this.d.setText(String.format(this.jdField_a_of_type_AndroidContentContext.getString(2131693420), new Object[] { Integer.valueOf(paramIntimateInfo.scoreCardInfo.score) }));
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      }
      else
      {
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      }
      if ((paramIntimateInfo.scoreCardInfo != null) && (!TextUtils.isEmpty(paramIntimateInfo.scoreCardInfo.levelDescribe)))
      {
        this.e.setText(paramIntimateInfo.scoreCardInfo.levelDescribe);
        this.e.setVisibility(0);
      }
      else
      {
        this.e.setVisibility(8);
      }
      this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetTickerTickerView.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(j));
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(j));
      this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(j));
      this.e.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(paramInt));
      this.e.setBackgroundResource(i);
    }
    else
    {
      this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetTickerTickerView.setText("");
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetTextView.setText("");
      this.d.setVisibility(4);
      this.e.setVisibility(4);
    }
    o();
    Object localObject = FriendIntimateRelationshipConfProcessor.a();
    if (paramIntimateInfo.currentScore >= ((FriendIntimateRelationshipBean)localObject).a)
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      this.e.setVisibility(0);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    this.e.setVisibility(8);
  }
  
  protected boolean a()
  {
    return true;
  }
  
  protected void b()
  {
    o();
  }
  
  protected void c()
  {
    removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
  }
  
  protected void d()
  {
    o();
  }
  
  protected void e()
  {
    removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
  }
  
  protected void f()
  {
    removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
  }
  
  public void m()
  {
    if (!this.jdField_c_of_type_Boolean) {
      return;
    }
    Bitmap localBitmap = this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateBaseIntimateView.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateBaseIntimateView.a().getCurrentAccountUin());
    if (localBitmap != null)
    {
      localBitmap = a(localBitmap);
      if ((localBitmap != null) && (!localBitmap.isRecycled())) {
        this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(localBitmap);
      }
    }
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateBaseIntimateView.a()))
    {
      localBitmap = this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateBaseIntimateView.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateBaseIntimateView.a());
      if (localBitmap != null)
      {
        localBitmap = a(localBitmap);
        if ((localBitmap != null) && (!localBitmap.isRecycled())) {
          this.jdField_b_of_type_AndroidWidgetImageView.setImageBitmap(localBitmap);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.intimate.view.IntimateContentItemFriendInfoView
 * JD-Core Version:    0.7.0.1
 */