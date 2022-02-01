package com.tencent.biz.subscribe.widget.relativevideo;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFollowRcmd;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;
import android.content.Context;
import android.support.annotation.RequiresApi;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.biz.subscribe.SubImageLoader;
import com.tencent.biz.subscribe.SubscribeLaucher;
import com.tencent.biz.subscribe.baseUI.BaseWidgetView;
import com.tencent.biz.subscribe.widget.textview.FollowTextView;
import com.tencent.biz.videostory.support.VSReporter;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.widget.SquareImageView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.ArrayUtils;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BlankRecommendItemView
  extends BaseWidgetView<CertifiedAccountMeta.StFollowRcmd>
  implements View.OnClickListener
{
  private View jdField_a_of_type_AndroidViewView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private FollowTextView jdField_a_of_type_ComTencentBizSubscribeWidgetTextviewFollowTextView;
  private SquareImageView jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView;
  private ArrayList<BlankRecommendItemView.InnerRecommendItemView> jdField_a_of_type_JavaUtilArrayList;
  private boolean jdField_a_of_type_Boolean;
  private TextView b;
  private int jdField_c_of_type_Int;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  
  public BlankRecommendItemView(Context paramContext)
  {
    super(paramContext);
  }
  
  private String a(int paramInt)
  {
    DecimalFormat localDecimalFormat;
    StringBuilder localStringBuilder;
    double d;
    if (paramInt >= 10000)
    {
      localDecimalFormat = new DecimalFormat(".#");
      localStringBuilder = new StringBuilder();
      d = paramInt;
      Double.isNaN(d);
      localStringBuilder.append(localDecimalFormat.format(d / 10000.0D));
      localStringBuilder.append("W");
      return localStringBuilder.toString();
    }
    if (paramInt >= 1000)
    {
      localDecimalFormat = new DecimalFormat(".#");
      localStringBuilder = new StringBuilder();
      d = paramInt;
      Double.isNaN(d);
      localStringBuilder.append(localDecimalFormat.format(d / 1000.0D));
      localStringBuilder.append("K");
      return localStringBuilder.toString();
    }
    return String.valueOf(paramInt);
  }
  
  protected int a()
  {
    return 2131558733;
  }
  
  protected View.OnClickListener a()
  {
    return null;
  }
  
  protected View a()
  {
    return this;
  }
  
  @RequiresApi(api=8)
  protected void a(CertifiedAccountMeta.StFollowRcmd paramStFollowRcmd)
  {
    if (paramStFollowRcmd != null)
    {
      if (!paramStFollowRcmd.user.has()) {
        return;
      }
      CertifiedAccountMeta.StUser localStUser = (CertifiedAccountMeta.StUser)paramStFollowRcmd.user.get();
      this.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView.getLayoutParams().width = ScreenUtil.dip2px(36.0F);
      this.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView.getLayoutParams().height = ScreenUtil.dip2px(36.0F);
      SubImageLoader.a(localStUser.icon.get(), this.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(localStUser.nick.get());
      Object localObject1 = this.b;
      ((TextView)localObject1).setText(String.format("%s%s", new Object[] { ((TextView)localObject1).getContext().getString(2131719358), a(paramStFollowRcmd.fansCount.get()) }));
      Object localObject2 = paramStFollowRcmd.reason.get();
      localObject1 = localObject2;
      if (TextUtils.isEmpty((CharSequence)localObject2)) {
        localObject1 = localStUser.desc.get();
      }
      this.jdField_c_of_type_AndroidWidgetTextView.setText((CharSequence)localObject1);
      this.jdField_a_of_type_ComTencentBizSubscribeWidgetTextviewFollowTextView.setUserData(localStUser);
      this.jdField_a_of_type_ComTencentBizSubscribeWidgetTextviewFollowTextView.setExtraTypeInfo(a());
      this.jdField_a_of_type_ComTencentBizSubscribeWidgetTextviewFollowTextView.setFollowStateChangeListener(new BlankRecommendItemView.1(this, localStUser));
      paramStFollowRcmd = paramStFollowRcmd.feedList.get();
      int i = 0;
      while (i < 3)
      {
        if (ArrayUtils.a(i, paramStFollowRcmd)) {
          ((BlankRecommendItemView.InnerRecommendItemView)this.jdField_a_of_type_JavaUtilArrayList.get(i)).a(null);
        } else {
          ((BlankRecommendItemView.InnerRecommendItemView)this.jdField_a_of_type_JavaUtilArrayList.get(i)).a((CertifiedAccountMeta.StFeed)paramStFollowRcmd.get(i));
        }
        i += 1;
      }
      paramStFollowRcmd = localStUser.id.get();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(this.jdField_c_of_type_Int);
      ((StringBuilder)localObject2).append("");
      VSReporter.b(paramStFollowRcmd, "auth_follow", "blank_content_exp", 0, 0, new String[] { "", ((StringBuilder)localObject2).toString(), localStUser.nick.get(), localObject1 });
    }
  }
  
  protected void a(Context paramContext, View paramView)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView = ((SquareImageView)findViewById(2131369284));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131379529));
    this.b = ((TextView)findViewById(2131379528));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131379530));
    this.jdField_a_of_type_AndroidViewView = findViewById(2131365768);
    this.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.b.setOnClickListener(this);
    this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentBizSubscribeWidgetTextviewFollowTextView = ((FollowTextView)findViewById(2131379687));
    if (this.jdField_a_of_type_JavaUtilArrayList == null) {
      this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    }
    this.jdField_a_of_type_JavaUtilArrayList.add(new BlankRecommendItemView.InnerRecommendItemView(this, findViewById(2131376678), 1));
    this.jdField_a_of_type_JavaUtilArrayList.add(new BlankRecommendItemView.InnerRecommendItemView(this, findViewById(2131376679), 2));
    this.jdField_a_of_type_JavaUtilArrayList.add(new BlankRecommendItemView.InnerRecommendItemView(this, findViewById(2131376680), 3));
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if ((i == 2131369284) || (i == 2131379529))
    {
      CertifiedAccountMeta.StFollowRcmd localStFollowRcmd = (CertifiedAccountMeta.StFollowRcmd)a();
      SubscribeLaucher.a(getContext(), (CertifiedAccountMeta.StUser)localStFollowRcmd.user.get());
      if (2131369284 == paramView.getId()) {
        VSReporter.b(localStFollowRcmd.user.id.get(), "auth_follow", "blank_head_clk", 0, 0, new String[] { "", "", localStFollowRcmd.user.nick.get() });
      } else if (2131379529 == paramView.getId()) {
        VSReporter.b(localStFollowRcmd.user.id.get(), "auth_follow", "blank_name_clk", 0, 0, new String[] { "", "", localStFollowRcmd.user.nick.get() });
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
  }
  
  public void setIsInNightMode(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView.setFilterColor(1711276032);
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-5723992);
      this.b.setTextColor(-10132123);
      this.jdField_c_of_type_AndroidWidgetTextView.setTextColor(-10132123);
      this.jdField_a_of_type_ComTencentBizSubscribeWidgetTextviewFollowTextView.setIsInNightMode(this.jdField_a_of_type_Boolean);
      this.jdField_a_of_type_AndroidViewView.setBackgroundColor(-9211021);
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        BlankRecommendItemView.InnerRecommendItemView localInnerRecommendItemView = (BlankRecommendItemView.InnerRecommendItemView)localIterator.next();
        if (localInnerRecommendItemView != null) {
          localInnerRecommendItemView.a();
        }
      }
    }
  }
  
  public void setPos(int paramInt)
  {
    this.jdField_c_of_type_Int = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.widget.relativevideo.BlankRecommendItemView
 * JD-Core Version:    0.7.0.1
 */