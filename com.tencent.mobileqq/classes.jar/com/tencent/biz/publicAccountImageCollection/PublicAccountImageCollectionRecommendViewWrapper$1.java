package com.tencent.biz.publicAccountImageCollection;

import android.content.Intent;
import android.view.View;
import com.tencent.biz.pubaccount.api.IPublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.view.imageloader.ImageManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemClickListener;
import java.util.ArrayList;

class PublicAccountImageCollectionRecommendViewWrapper$1
  implements AdapterView.OnItemClickListener
{
  PublicAccountImageCollectionRecommendViewWrapper$1(PublicAccountImageCollectionRecommendViewWrapper paramPublicAccountImageCollectionRecommendViewWrapper) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PublicAccountImageCollectionRecommendViewWrapper", 2, "onItemClick!");
    }
    paramAdapterView = (PublicAccountImageCollectionUtils.RecommendItemInfo)PublicAccountImageCollectionRecommendViewWrapper.a.get(paramInt);
    paramView = new Intent(paramView.getContext(), PublicAccountImageCollectionMainActivity.class);
    paramView.putExtra("recommend_source", paramAdapterView.c);
    paramView.putExtra("recommend_position", paramInt + 1);
    paramView.putExtra("click_source", 2);
    paramView.putExtra("source_for_report", 15);
    PublicAccountImageCollectionUtils.a(PublicAccountImageCollectionRecommendViewWrapper.a(this.a), paramView, String.valueOf(paramAdapterView.d));
    if ((PublicAccountImageCollectionRecommendViewWrapper.a(this.a) instanceof PublicAccountImageCollectionMainActivity))
    {
      paramView = (PublicAccountImageCollectionMainActivity)PublicAccountImageCollectionRecommendViewWrapper.a(this.a);
      paramInt += 1;
      paramView.a(2, paramInt, paramAdapterView.c);
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, paramView.a, "0X8007B94", "0X8007B94", 0, 0, paramView.b, paramView.c, paramAdapterView.d, "" + paramInt, false);
    }
    ImageManager.a().a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.publicAccountImageCollection.PublicAccountImageCollectionRecommendViewWrapper.1
 * JD-Core Version:    0.7.0.1
 */