package com.tencent.biz.pubaccount.weishi_new.view;

import UserGrowth.stNotificationRsp;
import UserGrowth.stSimpleMetaPerson;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import blcq;
import com.tencent.biz.pubaccount.weishi_new.report.WSPublicAccReport;
import java.util.ArrayList;
import sli;
import smp;
import snb;
import snf;

public class WeiShiNoticeView
  extends LinearLayout
{
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private RoundImageView jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRoundImageView;
  ArrayList<RoundImageView> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private RoundImageView b;
  private RoundImageView c;
  
  public WeiShiNoticeView(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  public WeiShiNoticeView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  private void a(int paramInt, String paramString)
  {
    RoundImageView localRoundImageView;
    if (this.jdField_a_of_type_JavaUtilArrayList.size() > paramInt)
    {
      localRoundImageView = (RoundImageView)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
      if (TextUtils.isEmpty(paramString)) {
        break label78;
      }
      Drawable localDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130845457);
      snf.a(localRoundImageView, paramString, localDrawable, localDrawable, "avatar" + paramInt);
    }
    for (;;)
    {
      localRoundImageView.setVisibility(0);
      return;
      label78:
      localRoundImageView.setImageResource(2130845457);
    }
  }
  
  private void a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      Drawable localDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130841259);
      snf.a(this.jdField_a_of_type_AndroidWidgetImageView, paramString, localDrawable, localDrawable, "banner");
      return;
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130841259);
  }
  
  private void b()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRoundImageView = ((RoundImageView)findViewById(2131362949));
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRoundImageView.setBorderColor(Color.parseColor("#c1c1c1"));
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRoundImageView.setBorderWidth(1);
    this.b = ((RoundImageView)findViewById(2131362950));
    this.b.setBorderColor(Color.parseColor("#c1c1c1"));
    this.b.setBorderWidth(1);
    this.c = ((RoundImageView)findViewById(2131362951));
    this.c.setBorderColor(Color.parseColor("#c1c1c1"));
    this.c.setBorderWidth(1);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRoundImageView.setVisibility(8);
    this.b.setVisibility(8);
    this.c.setVisibility(8);
    this.jdField_a_of_type_JavaUtilArrayList.add(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRoundImageView);
    this.jdField_a_of_type_JavaUtilArrayList.add(this.b);
    this.jdField_a_of_type_JavaUtilArrayList.add(this.c);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131370951));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131370947));
    ViewGroup.LayoutParams localLayoutParams = this.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
    int i = blcq.jdField_a_of_type_Int * 120 / 750;
    if (i > 0)
    {
      localLayoutParams.height = i;
      this.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams(localLayoutParams);
    }
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131378177));
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public void a()
  {
    setVisibility(8);
  }
  
  public void a(stNotificationRsp paramstNotificationRsp, sli paramsli)
  {
    if (paramstNotificationRsp == null)
    {
      a();
      return;
    }
    this.jdField_a_of_type_Int = paramstNotificationRsp.type;
    setVisibility(0);
    smp.a(6, this.jdField_a_of_type_Int, paramstNotificationRsp.cid);
    WSPublicAccReport.getInstance().reportMsgEntry("gzh_exposure", this.jdField_a_of_type_Int, 0, paramstNotificationRsp.cid);
    if (this.jdField_a_of_type_Int == 6)
    {
      a(paramstNotificationRsp.imgurl);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    if (!TextUtils.isEmpty(paramstNotificationRsp.text))
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-16777216);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramstNotificationRsp.text);
    }
    paramstNotificationRsp = paramstNotificationRsp.persons;
    int i = 0;
    while (i < paramstNotificationRsp.size())
    {
      paramsli = (stSimpleMetaPerson)paramstNotificationRsp.get(i);
      if ((paramsli != null) && (!TextUtils.isEmpty(paramsli.avatar))) {
        a(i, paramsli.avatar);
      }
      i += 1;
    }
    snb.a("813", "mAvatar1 :" + this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRoundImageView.getVisibility());
    snb.a("813", "mAvatar2 :" + this.b.getVisibility());
    snb.a("813", "mAvatar3 :" + this.c.getVisibility());
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.view.WeiShiNoticeView
 * JD-Core Version:    0.7.0.1
 */