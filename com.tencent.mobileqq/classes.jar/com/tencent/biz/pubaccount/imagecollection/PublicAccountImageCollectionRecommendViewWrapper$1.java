package com.tencent.biz.pubaccount.imagecollection;

import android.content.Intent;
import android.view.View;
import com.tencent.biz.pubaccount.imagecollection.api.IPublicAccountImageCollectionUtils.RecommendItemInfo;
import com.tencent.biz.pubaccount.imagecollection.api.impl.PublicAccountImageCollectionMainActivityImpl;
import com.tencent.biz.pubaccount.imagecollection.api.impl.PublicAccountImageCollectionUtilsImpl;
import com.tencent.mobileqq.kandian.base.image.api.IImageManager;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
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
    paramAdapterView = (IPublicAccountImageCollectionUtils.RecommendItemInfo)PublicAccountImageCollectionRecommendViewWrapper.a.get(paramInt);
    paramView = new Intent(paramView.getContext(), PublicAccountImageCollectionMainActivityImpl.class);
    paramView.putExtra("recommend_source", paramAdapterView.c);
    paramInt += 1;
    paramView.putExtra("recommend_position", paramInt);
    paramView.putExtra("click_source", 2);
    paramView.putExtra("source_for_report", 15);
    PublicAccountImageCollectionUtilsImpl.openPublicAccountImageCollectionMainActivityInner(PublicAccountImageCollectionRecommendViewWrapper.a(this.a), paramView, String.valueOf(paramAdapterView.d));
    if ((PublicAccountImageCollectionRecommendViewWrapper.a(this.a) instanceof PublicAccountImageCollectionMainActivityImpl))
    {
      Object localObject = (PublicAccountImageCollectionMainActivityImpl)PublicAccountImageCollectionRecommendViewWrapper.a(this.a);
      ((PublicAccountImageCollectionMainActivityImpl)localObject).reportOntime(2, paramInt, paramAdapterView.c);
      paramView = (IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class);
      String str1 = ((PublicAccountImageCollectionMainActivityImpl)localObject).puin;
      String str2 = ((PublicAccountImageCollectionMainActivityImpl)localObject).articleID;
      localObject = ((PublicAccountImageCollectionMainActivityImpl)localObject).webUrl;
      paramAdapterView = paramAdapterView.d;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(paramInt);
      paramView.publicAccountReportClickEvent(null, str1, "0X8007B94", "0X8007B94", 0, 0, str2, (String)localObject, paramAdapterView, localStringBuilder.toString(), false);
    }
    ((IImageManager)QRoute.api(IImageManager.class)).clean();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.imagecollection.PublicAccountImageCollectionRecommendViewWrapper.1
 * JD-Core Version:    0.7.0.1
 */