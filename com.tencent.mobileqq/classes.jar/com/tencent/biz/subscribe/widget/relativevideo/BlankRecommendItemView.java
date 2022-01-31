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
import azgq;
import bhns;
import com.tencent.biz.subscribe.baseUI.BaseWidgetView;
import com.tencent.biz.subscribe.widget.textview.FollowTextView;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.widget.SquareImageView;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import xxd;
import xxk;
import ykg;
import ykh;
import yvu;

public class BlankRecommendItemView
  extends BaseWidgetView<CertifiedAccountMeta.StFollowRcmd>
  implements View.OnClickListener
{
  private int jdField_a_of_type_Int;
  private View jdField_a_of_type_AndroidViewView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private FollowTextView jdField_a_of_type_ComTencentBizSubscribeWidgetTextviewFollowTextView;
  private SquareImageView jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView;
  private ArrayList<ykh> jdField_a_of_type_JavaUtilArrayList;
  private boolean jdField_a_of_type_Boolean;
  private TextView b;
  private TextView c;
  
  public BlankRecommendItemView(Context paramContext)
  {
    super(paramContext);
  }
  
  private String a(int paramInt)
  {
    DecimalFormat localDecimalFormat;
    if (paramInt >= 10000)
    {
      localDecimalFormat = new DecimalFormat(".#");
      return localDecimalFormat.format(paramInt / 10000.0D) + "W";
    }
    if (paramInt >= 1000)
    {
      localDecimalFormat = new DecimalFormat(".#");
      return localDecimalFormat.format(paramInt / 1000.0D) + "K";
    }
    return String.valueOf(paramInt);
  }
  
  public int a()
  {
    return 2131558698;
  }
  
  public View.OnClickListener a()
  {
    return null;
  }
  
  public View a()
  {
    return this;
  }
  
  @RequiresApi(api=8)
  protected void a(CertifiedAccountMeta.StFollowRcmd paramStFollowRcmd)
  {
    if ((paramStFollowRcmd == null) || (!paramStFollowRcmd.user.has())) {
      return;
    }
    CertifiedAccountMeta.StUser localStUser = (CertifiedAccountMeta.StUser)paramStFollowRcmd.user.get();
    this.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView.getLayoutParams().width = azgq.a(36.0F);
    this.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView.getLayoutParams().height = azgq.a(36.0F);
    xxd.a(localStUser.icon.get(), this.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(localStUser.nick.get());
    this.b.setText(String.format("%s%s", new Object[] { this.b.getContext().getString(2131720469), a(paramStFollowRcmd.fansCount.get()) }));
    String str = paramStFollowRcmd.reason.get();
    if (TextUtils.isEmpty(str)) {
      str = localStUser.desc.get();
    }
    for (;;)
    {
      this.c.setText(str);
      this.jdField_a_of_type_ComTencentBizSubscribeWidgetTextviewFollowTextView.setUserData(localStUser);
      this.jdField_a_of_type_ComTencentBizSubscribeWidgetTextviewFollowTextView.setExtraTypeInfo(a());
      this.jdField_a_of_type_ComTencentBizSubscribeWidgetTextviewFollowTextView.setFollowStateChangeListener(new ykg(this, localStUser));
      paramStFollowRcmd = paramStFollowRcmd.feedList.get();
      int i = 0;
      if (i < 3)
      {
        if (bhns.a(i, paramStFollowRcmd)) {
          ((ykh)this.jdField_a_of_type_JavaUtilArrayList.get(i)).a(null);
        }
        for (;;)
        {
          i += 1;
          break;
          ((ykh)this.jdField_a_of_type_JavaUtilArrayList.get(i)).a((CertifiedAccountMeta.StFeed)paramStFollowRcmd.get(i));
        }
      }
      yvu.b(localStUser.id.get(), "auth_follow", "blank_content_exp", 0, 0, new String[] { "", this.jdField_a_of_type_Int + "", localStUser.nick.get(), str });
      return;
    }
  }
  
  public void a(Context paramContext, View paramView)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView = ((SquareImageView)findViewById(2131368692));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131378609));
    this.b = ((TextView)findViewById(2131378608));
    this.c = ((TextView)findViewById(2131378610));
    this.jdField_a_of_type_AndroidViewView = findViewById(2131365360);
    this.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.b.setOnClickListener(this);
    this.c.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentBizSubscribeWidgetTextviewFollowTextView = ((FollowTextView)findViewById(2131378749));
    if (this.jdField_a_of_type_JavaUtilArrayList == null) {
      this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    }
    this.jdField_a_of_type_JavaUtilArrayList.add(new ykh(this, findViewById(2131375857), 1));
    this.jdField_a_of_type_JavaUtilArrayList.add(new ykh(this, findViewById(2131375858), 2));
    this.jdField_a_of_type_JavaUtilArrayList.add(new ykh(this, findViewById(2131375859), 3));
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    CertifiedAccountMeta.StFollowRcmd localStFollowRcmd;
    do
    {
      return;
      localStFollowRcmd = (CertifiedAccountMeta.StFollowRcmd)a();
      xxk.a(getContext(), (CertifiedAccountMeta.StUser)localStFollowRcmd.user.get());
      if (2131368692 == paramView.getId())
      {
        yvu.b(localStFollowRcmd.user.id.get(), "auth_follow", "blank_head_clk", 0, 0, new String[] { "", "", localStFollowRcmd.user.nick.get() });
        return;
      }
    } while (2131378609 != paramView.getId());
    yvu.b(localStFollowRcmd.user.id.get(), "auth_follow", "blank_name_clk", 0, 0, new String[] { "", "", localStFollowRcmd.user.nick.get() });
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
      this.c.setTextColor(-10132123);
      this.jdField_a_of_type_ComTencentBizSubscribeWidgetTextviewFollowTextView.setIsInNightMode(this.jdField_a_of_type_Boolean);
      this.jdField_a_of_type_AndroidViewView.setBackgroundColor(-9211021);
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        ykh localykh = (ykh)localIterator.next();
        if (localykh != null) {
          localykh.a();
        }
      }
    }
  }
  
  public void setPos(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.subscribe.widget.relativevideo.BlankRecommendItemView
 * JD-Core Version:    0.7.0.1
 */