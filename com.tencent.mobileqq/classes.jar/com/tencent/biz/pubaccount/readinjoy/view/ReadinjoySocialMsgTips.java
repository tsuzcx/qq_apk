package com.tencent.biz.pubaccount.readinjoy.view;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.biz.pubaccount.api.IPublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.preparse.RIJPreParseData;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.report.RIJMsgReport;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.report.RIJTransMergeKanDianReport;
import com.tencent.biz.pubaccount.readinjoy.struct.KandianMsgBoxRedPntInfo;
import com.tencent.biz.qqstory.takevideo.doodle.util.DisplayUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import cooperation.readinjoy.ReadInJoyHelper;

public class ReadinjoySocialMsgTips
  implements ReadinjoySocialMsgUI
{
  private static Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private static Drawable jdField_b_of_type_AndroidGraphicsDrawableDrawable;
  private int jdField_a_of_type_Int = 0;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  private View jdField_a_of_type_AndroidViewView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private KandianMsgBoxRedPntInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianMsgBoxRedPntInfo;
  private ReadInJoyHeadImageView jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView;
  private View jdField_b_of_type_AndroidViewView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  
  public ReadinjoySocialMsgTips(Activity paramActivity, View paramView)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_AndroidViewView = paramView;
    c();
  }
  
  private void c()
  {
    jdField_a_of_type_AndroidGraphicsDrawableDrawable = new BitmapDrawable(BitmapFactory.decodeResource(BaseApplicationImpl.getApplication().getResources(), 2130841899));
    jdField_b_of_type_AndroidGraphicsDrawableDrawable = new BitmapDrawable(BitmapFactory.decodeResource(BaseApplicationImpl.getApplication().getResources(), 2130841900));
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView = ((ReadInJoyHeadImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131368603));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView.setRound(true);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView.setImagePlaceHolder(jdField_a_of_type_AndroidGraphicsDrawableDrawable);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131365294));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131371951));
    this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131378285);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131363042));
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(new ReadinjoySocialMsgTips.1(this));
  }
  
  public View a()
  {
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_AndroidViewView != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianMsgBoxRedPntInfo != null))
    {
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      String str = RIJTransMergeKanDianReport.b();
      str = RIJMsgReport.a.a(str);
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X800824A", "0X800824A", 0, 0, "", "", "", str, false);
    }
  }
  
  public void a(View.OnClickListener paramOnClickListener)
  {
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
  }
  
  public void a(KandianMsgBoxRedPntInfo paramKandianMsgBoxRedPntInfo)
  {
    if ((paramKandianMsgBoxRedPntInfo == null) || (paramKandianMsgBoxRedPntInfo.equals(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianMsgBoxRedPntInfo)))
    {
      QLog.d("ReadinjoySocialMsgTips", 2, "210 msgInfo is null ! " + paramKandianMsgBoxRedPntInfo);
      return;
    }
    QLog.d("ReadinjoySocialMsgTips", 2, "set msg info , count : " + paramKandianMsgBoxRedPntInfo.mMsgCnt + ", uin : " + paramKandianMsgBoxRedPntInfo.mUin + ", seq : " + paramKandianMsgBoxRedPntInfo.mSeq);
    this.jdField_a_of_type_Int += 1;
    if (this.jdField_a_of_type_Int % 2 == 0)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView.setImagePlaceHolder(jdField_b_of_type_AndroidGraphicsDrawableDrawable);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianMsgBoxRedPntInfo = paramKandianMsgBoxRedPntInfo;
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianMsgBoxRedPntInfo.mMsgType != 2) {
        break label319;
      }
      if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianMsgBoxRedPntInfo.mIconUrl)) {
        break label272;
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView.setImage(RIJPreParseData.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianMsgBoxRedPntInfo.mIconUrl));
      label170:
      if (Aladdin.getConfig(431).getIntegerFromString("msg_ui_style", 0) != 1) {
        break label382;
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramKandianMsgBoxRedPntInfo.mMsgText);
      this.jdField_b_of_type_AndroidWidgetTextView.setText(ReadInJoyHelper.c(paramKandianMsgBoxRedPntInfo.mMsgCnt));
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130841478);
      this.jdField_a_of_type_AndroidWidgetImageView.clearColorFilter();
    }
    for (((LinearLayout.LayoutParams)this.jdField_b_of_type_AndroidViewView.getLayoutParams()).bottomMargin = 0;; ((LinearLayout.LayoutParams)this.jdField_b_of_type_AndroidViewView.getLayoutParams()).bottomMargin = DisplayUtil.b(this.jdField_a_of_type_AndroidAppActivity, 8.0F))
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianMsgBoxRedPntInfo.canDoAnimation = false;
      return;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView.setImagePlaceHolder(jdField_a_of_type_AndroidGraphicsDrawableDrawable);
      break;
      label272:
      Animatable localAnimatable = (Animatable)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView.getResources().getDrawable(2130843137);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView.setImageDrawable((Drawable)localAnimatable);
      if (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianMsgBoxRedPntInfo.canDoAnimation) {
        break label170;
      }
      localAnimatable.start();
      break label170;
      label319:
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianMsgBoxRedPntInfo.mIconUrl))
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView.setImage(RIJPreParseData.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianMsgBoxRedPntInfo.mIconUrl));
        break label170;
      }
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianMsgBoxRedPntInfo.mUin <= 0L) {
        break label170;
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView.setHeadImgByUin(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianMsgBoxRedPntInfo.mUin);
      break label170;
      label382:
      this.jdField_a_of_type_AndroidWidgetTextView.setText(ReadInJoyHelper.b(paramKandianMsgBoxRedPntInfo.mMsgCnt) + HardCodeUtil.a(2131712746));
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130843542);
      this.jdField_a_of_type_AndroidWidgetImageView.setColorFilter(this.jdField_a_of_type_AndroidViewView.getResources().getColor(2131165357), PorterDuff.Mode.SRC_IN);
    }
  }
  
  public void b()
  {
    this.jdField_a_of_type_AndroidAppActivity = null;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView = null;
    this.jdField_a_of_type_AndroidViewView = null;
    this.jdField_a_of_type_AndroidWidgetTextView = null;
    this.jdField_a_of_type_AndroidViewView$OnClickListener = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.ReadinjoySocialMsgTips
 * JD-Core Version:    0.7.0.1
 */