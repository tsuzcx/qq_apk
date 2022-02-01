package com.tencent.biz.pubaccount.readinjoyAd.ad.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.ListView;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.GiftServiceBean;
import com.tencent.biz.pubaccount.util.PublicDrawableUtil;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import java.util.ArrayList;
import java.util.List;

public class GiftPkgSelectDialog
  extends ReportDialog
  implements View.OnClickListener
{
  private int jdField_a_of_type_Int = -1;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private ListView jdField_a_of_type_AndroidWidgetListView;
  private GiftPkgSelectDialog.GiftSelectListener jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewGiftPkgSelectDialog$GiftSelectListener;
  private GiftPkgSelectDialog.SelectAdatpter jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewGiftPkgSelectDialog$SelectAdatpter;
  private List<GiftServiceBean> jdField_a_of_type_JavaUtilList = new ArrayList();
  private LinearLayout b;
  
  public GiftPkgSelectDialog(Context paramContext, int paramInt)
  {
    super(paramContext, 2131755346);
    requestWindowFeature(1);
    getWindow().setBackgroundDrawable(new ColorDrawable(paramContext.getResources().getColor(17170445)));
    setContentView(2131560328);
    this.jdField_a_of_type_AndroidWidgetListView = ((ListView)findViewById(2131370881));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131370891));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewGiftPkgSelectDialog$SelectAdatpter = new GiftPkgSelectDialog.SelectAdatpter(this);
    this.jdField_a_of_type_AndroidWidgetListView.setAdapter(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewGiftPkgSelectDialog$SelectAdatpter);
    this.jdField_a_of_type_AndroidWidgetListView.setOnItemClickListener(new GiftPkgSelectDialog.1(this));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131370891));
    this.b = ((LinearLayout)findViewById(2131370894));
    this.b.setOnClickListener(this);
    PublicDrawableUtil.a(this.jdField_a_of_type_AndroidWidgetLinearLayout, AIOUtils.a(6.0F, paramContext.getResources()), Color.parseColor("#FFFFFF"));
    PublicDrawableUtil.a(this.jdField_a_of_type_AndroidWidgetListView, AIOUtils.a(6.0F, paramContext.getResources()), Color.parseColor("#FFFFFF"));
    setCanceledOnTouchOutside(true);
  }
  
  public void a(List<GiftServiceBean> paramList, GiftPkgSelectDialog.GiftSelectListener paramGiftSelectListener, String paramString)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewGiftPkgSelectDialog$GiftSelectListener = paramGiftSelectListener;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewGiftPkgSelectDialog$SelectAdatpter.notifyDataSetChanged();
    int i = 0;
    for (;;)
    {
      if (i < paramList.size())
      {
        paramGiftSelectListener = (GiftServiceBean)paramList.get(i);
        if ((!TextUtils.isEmpty(paramGiftSelectListener.t)) && (paramGiftSelectListener.t.equals(paramString))) {
          this.jdField_a_of_type_Int = i;
        }
      }
      else
      {
        return;
      }
      i += 1;
    }
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
      dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.view.GiftPkgSelectDialog
 * JD-Core Version:    0.7.0.1
 */