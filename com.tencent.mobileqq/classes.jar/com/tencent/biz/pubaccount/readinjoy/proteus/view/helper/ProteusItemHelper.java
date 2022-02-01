package com.tencent.biz.pubaccount.readinjoy.proteus.view.helper;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.pubaccount.api.IPublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.config.handlers.DailyModeConfigHandler;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.report.RIJTransMergeKanDianReport;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.report.RIJTransMergeKanDianReport.ReportR5Builder;
import com.tencent.biz.pubaccount.readinjoy.model.IReadInJoyModel;
import com.tencent.biz.pubaccount.readinjoy.proteus.item.ProteusItemView;
import com.tencent.biz.pubaccount.readinjoy.proteus.item.ProteusItemView.OnItemDrawFinishedListener;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyDailyOverScrollListener;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.Utils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import cooperation.readinjoy.ReadInJoyHelper;

public class ProteusItemHelper
  implements ProteusItemView.OnItemDrawFinishedListener
{
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new ProteusItemHelper.1(this);
  private View jdField_a_of_type_AndroidViewView;
  private IReadInJoyModel jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelIReadInJoyModel;
  private final ProteusItemView jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusItemProteusItemView;
  private boolean jdField_a_of_type_Boolean = false;
  
  public ProteusItemHelper(ProteusItemView paramProteusItemView)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusItemProteusItemView = paramProteusItemView;
    b();
  }
  
  private static float a()
  {
    try
    {
      float f = Float.valueOf((String)ReadInJoyHelper.a("kandian_daily_wrapper_alpha", "1.0")).floatValue();
      if ((f >= 0.0F) && (f <= 1.0F)) {
        return f;
      }
    }
    catch (Exception localException)
    {
      QLog.d("ProteusItemHelper", 1, localException, new Object[] { "" });
    }
    return 1.0F;
  }
  
  private boolean a()
  {
    return false;
  }
  
  private void b()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusItemProteusItemView.a(this);
  }
  
  private void c()
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_Boolean = true;
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X8009882", "0X8009882", 0, 0, "", "", "", RIJTransMergeKanDianReport.a().b("jump_src", DailyModeConfigHandler.b()).a(), false);
  }
  
  public IReadInJoyModel a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelIReadInJoyModel;
  }
  
  public void a()
  {
    if (a())
    {
      if (this.jdField_a_of_type_AndroidViewView == null)
      {
        this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusItemProteusItemView.getContext()).inflate(2131560279, null, false);
        localObject = (TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131379275);
        ((TextView)localObject).setTextSize(0, Utils.dp2px(14.0D));
        ((TextView)localObject).setText(ReadInJoyDailyOverScrollListener.a(((TextView)localObject).getContext()));
        f = a();
        this.jdField_a_of_type_AndroidViewView.setBackgroundResource(2130849768);
        this.jdField_a_of_type_AndroidViewView.getBackground().setAlpha((int)(f * 255.0F));
        this.jdField_a_of_type_AndroidViewView.setPadding(0, 0, 0, 0);
        localObject = new RelativeLayout.LayoutParams(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusItemProteusItemView.getWidth(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusItemProteusItemView.getHeight());
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusItemProteusItemView.addView(this.jdField_a_of_type_AndroidViewView, (ViewGroup.LayoutParams)localObject);
        c();
      }
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      this.jdField_a_of_type_AndroidViewView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    }
    while (this.jdField_a_of_type_AndroidViewView == null)
    {
      Object localObject;
      float f;
      return;
    }
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusItemProteusItemView.removeView(this.jdField_a_of_type_AndroidViewView);
    this.jdField_a_of_type_AndroidViewView = null;
  }
  
  public void a(IReadInJoyModel paramIReadInJoyModel)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelIReadInJoyModel = paramIReadInJoyModel;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.proteus.view.helper.ProteusItemHelper
 * JD-Core Version:    0.7.0.1
 */