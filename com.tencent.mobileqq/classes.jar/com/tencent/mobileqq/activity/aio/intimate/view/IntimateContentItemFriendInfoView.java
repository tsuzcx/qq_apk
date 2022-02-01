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
import com.tencent.biz.pubaccount.readinjoy.view.widget.ticker.TickerView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
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
import com.tencent.mobileqq.multicard.MultiCardCustomViewDelegate;
import com.tencent.mobileqq.mutualmark.oldlogic.FriendIntimateRelationshipHelper;
import com.tencent.mobileqq.profile.TroopMemberCardUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;

public class IntimateContentItemFriendInfoView
  extends IntimateContentItemBaseView
{
  private View jdField_a_of_type_AndroidViewView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private TickerView jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTickerTickerView;
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
    Bitmap localBitmap = paramBitmap;
    if (paramBitmap != null)
    {
      localBitmap = paramBitmap;
      if (!paramBitmap.isRecycled())
      {
        int i = Math.min(paramBitmap.getWidth(), paramBitmap.getHeight()) + 8;
        localBitmap = Bitmap.createBitmap(i, i, Bitmap.Config.ARGB_8888);
        Canvas localCanvas = new Canvas(localBitmap);
        Paint localPaint = new Paint();
        float f = i / 2.0F;
        localPaint.setAntiAlias(true);
        localCanvas.drawARGB(0, 0, 0, 0);
        localPaint.setColor(-1);
        localCanvas.drawBitmap(paramBitmap, 8 / 2.0F, 8 / 2.0F, localPaint);
        localPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_ATOP));
        localCanvas.drawCircle(f, f, f, localPaint);
      }
    }
    return localBitmap;
  }
  
  private void a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      ReportController.b(null, "dc00898", "", "", "0X800B565", "0X800B565", 4, 0, "", "", "", "");
      return;
    case 1: 
      ReportController.b(null, "dc00898", "", "", "0X800B565", "0X800B565", 1, 0, "", "", "", "");
      return;
    case 2: 
      ReportController.b(null, "dc00898", "", "", "0X800B565", "0X800B565", 2, 0, "", "", "", "");
      return;
    case 26: 
      ReportController.b(null, "dc00898", "", "", "0X800B565", "0X800B565", 5, 0, "", "", "", "");
      return;
    }
    ReportController.b(null, "dc00898", "", "", "0X800B565", "0X800B565", 3, 0, "", "", "", "");
  }
  
  private void a(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (QQBrowserActivity.checkNotFrequentlyThenEnter(1000L)))
    {
      Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
      localIntent.putExtra("url", paramString);
      localIntent.putExtra("startOpenPageTime", System.currentTimeMillis());
      this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
    }
  }
  
  private boolean b()
  {
    boolean bool = true;
    if (this.jdField_b_of_type_Int == 4) {
      bool = false;
    }
    if (QLog.isColorLevel()) {
      QLog.d("IntimateContentItemFriendInfoView", 2, "canUpdateAnim res: " + bool + "  currentShowType:" + this.jdField_b_of_type_Int);
    }
    return bool;
  }
  
  private void n()
  {
    if (!this.jdField_c_of_type_Boolean) {}
    do
    {
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo.lastAnimAfterFriendDays = this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo.beFriendDays;
        ThreadManager.postImmediately(new IntimateContentItemFriendInfoView.1(this), null, true);
      }
    } while (!QLog.isColorLevel());
    QLog.d("intimate_relationship", 2, "onDaysUpdated intimateInfo: " + this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo);
  }
  
  private void o()
  {
    if (!this.jdField_c_of_type_Boolean) {}
    do
    {
      do
      {
        return;
        if (QLog.isColorLevel()) {
          QLog.i("IntimateContentItemFriendInfoView", 2, "checkAndStartUpdateAnim isResumed:" + this.jdField_a_of_type_Boolean + " currentShowType:" + this.jdField_b_of_type_Int + " intimateInfo:" + this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo);
        }
      } while ((!this.jdField_a_of_type_Boolean) || (this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo == null));
      removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    } while ((!b()) || (this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo.lastAnimAfterFriendDays == this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo.beFriendDays) || (this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo.beFriendDays <= 0));
    postDelayed(this.jdField_a_of_type_JavaLangRunnable, 300L);
  }
  
  private void p()
  {
    int j = 2;
    if (!this.jdField_c_of_type_Boolean) {
      return;
    }
    int m = Math.max(0, this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo.lastAnimAfterFriendDays);
    int k = Math.max(0, this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo.beFriendDays);
    if (QLog.isColorLevel()) {
      QLog.i("IntimateContentItemFriendInfoView", 2, "smoothUpdateDays fromDays:" + m + " toDays:" + k);
    }
    if (m <= 0)
    {
      int n = String.valueOf(k).length();
      localObject = "";
      i = 0;
      while ((i < n) && (i < 5))
      {
        localObject = (String)localObject + "0";
        i += 1;
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTickerTickerView.setText((String)localObject, false);
    }
    Object localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTickerTickerView;
    int i = j;
    if (k > m) {
      i = 1;
    }
    ((TickerView)localObject).setPreferredScrollingDirection(i);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTickerTickerView.setDigitalAnimWidthSpeedIncrement(true);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTickerTickerView.setIgnoreWidthAnim(true);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTickerTickerView.setText(String.valueOf(k));
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    n();
  }
  
  private void q()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateBaseIntimateView == null) || (this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo == null)) {}
    int i;
    String str2;
    do
    {
      return;
      str1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateBaseIntimateView.a();
      i = this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo.maskType;
      if (!IntimateUtil.a(i)) {
        break;
      }
      str2 = FriendIntimateRelationshipHelper.b();
    } while ((TextUtils.isEmpty(str2)) || (!str2.contains("frd_uin=")) || (!str2.contains("frd_type=")));
    String str1 = str2.replace("frd_uin=", "frd_uin=" + str1).replace("frd_type=", "frd_type=" + i);
    a(i);
    a(str1);
    return;
    str1 = FriendIntimateRelationshipHelper.a(str1);
    a(i);
    a(str1);
  }
  
  protected void a()
  {
    View localView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131559379, this, true);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131377756));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131367566));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTickerTickerView = ((TickerView)localView.findViewById(2131369198));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131369197));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131369195));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)localView.findViewById(2131368661));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131365499));
    this.jdField_a_of_type_AndroidViewView = localView.findViewById(2131368660);
    this.d = ((TextView)localView.findViewById(2131365500));
    this.e = ((TextView)localView.findViewById(2131372254));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTickerTickerView.setCharacterLists(new String[] { "9876543210" });
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTickerTickerView.setAnimationDuration(2000L);
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
      this.jdField_b_of_type_AndroidWidgetImageView.setContentDescription(HardCodeUtil.a(2131705849));
      this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(HardCodeUtil.a(2131705847));
    }
  }
  
  public void a(Bitmap paramBitmap, String paramString)
  {
    if (!this.jdField_c_of_type_Boolean) {}
    do
    {
      do
      {
        do
        {
          return;
          if (!paramString.equals(this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateBaseIntimateView.a())) {
            break;
          }
          paramBitmap = a(paramBitmap);
        } while ((paramBitmap == null) || (paramBitmap.isRecycled()));
        this.jdField_b_of_type_AndroidWidgetImageView.setImageBitmap(paramBitmap);
        return;
      } while ((this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateBaseIntimateView.a() == null) || (!paramString.equals(this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateBaseIntimateView.a().getCurrentAccountUin())));
      paramBitmap = a(paramBitmap);
    } while ((paramBitmap == null) || (paramBitmap.isRecycled()));
    this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(paramBitmap);
  }
  
  protected void a(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131377756: 
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateBaseIntimateView.a() == null)
      {
        paramView = new ProfileActivity.AllInOne(this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateBaseIntimateView.a().getCurrentAccountUin(), 0);
        ProfileActivity.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateBaseIntimateView.a(), paramView);
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
    case 2131367566: 
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateBaseIntimateView.a() == null)
      {
        paramView = new ProfileActivity.AllInOne(this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateBaseIntimateView.a(), 1);
        ProfileActivity.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateBaseIntimateView.a(), paramView);
        return;
      }
      paramView = this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateBaseIntimateView.a().a();
      if (!TextUtils.isEmpty(paramView))
      {
        TroopMemberCardUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateBaseIntimateView.a(), this.jdField_a_of_type_AndroidContentContext, paramView, this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateBaseIntimateView.a(), 0, -1);
        return;
      }
      QLog.e("intimate_relationship", 2, "open troop member card troop uin empty");
      return;
    }
    q();
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
    if (QLog.isColorLevel()) {
      QLog.d("IntimateContentItemFriendInfoView", 2, "updateIntimateInfo beFriendDays: " + i);
    }
    if (i >= -1) {
      if (i == 0)
      {
        localObject = this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131693447);
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTickerTickerView.setText((String)localObject, false);
        if (paramInt == 3)
        {
          this.jdField_b_of_type_AndroidWidgetTextView.setText(2131693449);
          this.jdField_a_of_type_AndroidWidgetLinearLayout.setBackgroundResource(2130845597);
          this.jdField_a_of_type_AndroidViewView.setBackgroundColor(getResources().getColor(2131166418));
          this.e.setBackgroundResource(2130845603);
          j = 2131165738;
          i = 2131165737;
          paramInt = 2130845603;
          label175:
          if ((paramIntimateInfo.scoreCardInfo == null) || (TextUtils.isEmpty(paramIntimateInfo.scoreCardInfo.typeDescribe))) {
            break label706;
          }
          this.jdField_c_of_type_AndroidWidgetTextView.setText(paramIntimateInfo.scoreCardInfo.typeDescribe);
          this.d.setText(String.format(this.jdField_a_of_type_AndroidContentContext.getString(2131693465), new Object[] { Integer.valueOf(paramIntimateInfo.scoreCardInfo.score) }));
          this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
          label254:
          if ((paramIntimateInfo.scoreCardInfo == null) || (TextUtils.isEmpty(paramIntimateInfo.scoreCardInfo.levelDescribe))) {
            break label718;
          }
          this.e.setText(paramIntimateInfo.scoreCardInfo.levelDescribe);
          this.e.setVisibility(0);
          label296:
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTickerTickerView.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(j));
          this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(j));
          this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(j));
          this.e.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(i));
          this.e.setBackgroundResource(paramInt);
          label379:
          o();
          localObject = FriendIntimateRelationshipConfProcessor.a();
          if (paramIntimateInfo.currentScore < ((FriendIntimateRelationshipBean)localObject).a) {
            break label776;
          }
          this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
          this.e.setVisibility(0);
        }
      }
      else
      {
        if (i != -1) {
          break label795;
        }
      }
    }
    label776:
    label795:
    for (Object localObject = "999+";; localObject = String.valueOf(i))
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      break;
      if (paramInt == 2)
      {
        this.jdField_b_of_type_AndroidWidgetTextView.setText(2131693448);
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setBackgroundResource(2130845596);
        this.jdField_a_of_type_AndroidViewView.setBackgroundColor(getResources().getColor(2131166417));
        this.e.setBackgroundResource(2130845602);
        j = 2131165736;
        i = 2131165735;
        paramInt = 2130845602;
        break label175;
      }
      if (paramInt == 1)
      {
        this.jdField_b_of_type_AndroidWidgetTextView.setText(2131693450);
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setBackgroundResource(2130845598);
        this.jdField_a_of_type_AndroidViewView.setBackgroundColor(getResources().getColor(2131166419));
        this.e.setBackgroundResource(2130845604);
        j = 2131165740;
        i = 2131165739;
        paramInt = 2130845604;
        break label175;
      }
      if (paramInt == 26)
      {
        this.jdField_b_of_type_AndroidWidgetTextView.setText(2131693451);
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setBackgroundResource(2130845599);
        this.jdField_a_of_type_AndroidViewView.setBackgroundColor(getResources().getColor(2131166420));
        this.e.setBackgroundResource(2130845605);
        j = 2131165742;
        i = 2131165741;
        paramInt = 2130845605;
        break label175;
      }
      this.jdField_b_of_type_AndroidWidgetTextView.setText(2131693445);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setBackgroundResource(2130845595);
      this.jdField_a_of_type_AndroidViewView.setBackgroundColor(getResources().getColor(2131166416));
      this.e.setBackgroundResource(2130845601);
      j = 2131165743;
      i = 2131165744;
      paramInt = 2130845601;
      break label175;
      label706:
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      break label254;
      label718:
      this.e.setVisibility(8);
      break label296;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTickerTickerView.setText("");
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetTextView.setText("");
      this.d.setVisibility(4);
      this.e.setVisibility(4);
      break label379;
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      this.e.setVisibility(8);
      return;
    }
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
    if (!this.jdField_c_of_type_Boolean) {}
    Bitmap localBitmap;
    do
    {
      do
      {
        do
        {
          return;
          localBitmap = this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateBaseIntimateView.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateBaseIntimateView.a().getCurrentAccountUin());
          if (localBitmap != null)
          {
            localBitmap = a(localBitmap);
            if ((localBitmap != null) && (!localBitmap.isRecycled())) {
              this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(localBitmap);
            }
          }
        } while (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateBaseIntimateView.a()));
        localBitmap = this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateBaseIntimateView.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateBaseIntimateView.a());
      } while (localBitmap == null);
      localBitmap = a(localBitmap);
    } while ((localBitmap == null) || (localBitmap.isRecycled()));
    this.jdField_b_of_type_AndroidWidgetImageView.setImageBitmap(localBitmap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.intimate.view.IntimateContentItemFriendInfoView
 * JD-Core Version:    0.7.0.1
 */