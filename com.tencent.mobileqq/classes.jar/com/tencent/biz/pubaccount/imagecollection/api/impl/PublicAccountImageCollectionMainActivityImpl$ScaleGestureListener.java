package com.tencent.biz.pubaccount.imagecollection.api.impl;

import android.graphics.Matrix;
import android.view.ScaleGestureDetector;
import android.view.ScaleGestureDetector.OnScaleGestureListener;
import android.view.ViewGroup;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.biz.pubaccount.imagecollection.PublicAccountImageCollectionAdapter;
import com.tencent.biz.pubaccount.imagecollection.PublicAccountImageCollectionAdapter.ImageItemHolder;
import com.tencent.biz.pubaccount.imagecollection.PublicAccountImageCollectionListView;
import com.tencent.biz.pubaccount.imagecollection.PublicAccountImageView;
import com.tencent.biz.pubaccount.imagecollection.api.IPublicAccountImageCollectionUtils.PhotoItemInfo;
import com.tencent.mobileqq.kandian.base.view.widget.ZImageView;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class PublicAccountImageCollectionMainActivityImpl$ScaleGestureListener
  implements ScaleGestureDetector.OnScaleGestureListener
{
  private PublicAccountImageCollectionMainActivityImpl$ScaleGestureListener(PublicAccountImageCollectionMainActivityImpl paramPublicAccountImageCollectionMainActivityImpl) {}
  
  public boolean onScale(ScaleGestureDetector paramScaleGestureDetector)
  {
    this.a.scale = paramScaleGestureDetector.getScaleFactor();
    if (QLog.isColorLevel())
    {
      paramScaleGestureDetector = new StringBuilder();
      paramScaleGestureDetector.append("缩放比例是");
      paramScaleGestureDetector.append(this.a.scale);
      QLog.d("qqBaseActivity", 2, paramScaleGestureDetector.toString());
    }
    QLog.d("qqBaseActivity", 2, "catch zoom");
    if (PublicAccountImageCollectionMainActivityImpl.access$100(this.a))
    {
      if (PublicAccountImageCollectionMainActivityImpl.access$200(this.a).getScaleType() != ImageView.ScaleType.MATRIX) {
        PublicAccountImageCollectionMainActivityImpl.access$200(this.a).setScaleType(ImageView.ScaleType.MATRIX);
      }
      this.a.mCurrentMatrix.set(PublicAccountImageCollectionMainActivityImpl.access$200(this.a).getImageMatrix());
      this.a.mCurrentMatrix.getValues(this.a.currentValues);
      if (this.a.currentValues[0] > this.a.initValues[0] * 3.0F)
      {
        paramScaleGestureDetector = this.a;
        paramScaleGestureDetector.scale = (paramScaleGestureDetector.initValues[0] * 3.0F / this.a.currentValues[0]);
        if (QLog.isColorLevel())
        {
          paramScaleGestureDetector = new StringBuilder();
          paramScaleGestureDetector.append("the last scale is");
          paramScaleGestureDetector.append(this.a.scale);
          QLog.d("qqBaseActivity", 2, paramScaleGestureDetector.toString());
        }
      }
      this.a.matrix.set(this.a.mCurrentMatrix);
      this.a.matrix.postScale(this.a.scale, this.a.scale, PublicAccountImageCollectionMainActivityImpl.access$200(this.a).getWidth() / 2, PublicAccountImageCollectionMainActivityImpl.access$200(this.a).getHeight() / 2);
      PublicAccountImageCollectionMainActivityImpl.access$200(this.a).setImageMatrix(this.a.matrix);
      return true;
    }
    paramScaleGestureDetector = this.a;
    paramScaleGestureDetector.centerView = PublicAccountImageCollectionMainActivityImpl.access$2500(paramScaleGestureDetector).a();
    if ((this.a.centerView != null) && ((this.a.centerView.getTag() instanceof PublicAccountImageCollectionAdapter.ImageItemHolder)))
    {
      Object localObject = (ZImageView)this.a.centerView.getChildAt(0);
      if ((localObject != null) && ((localObject instanceof ZImageView)))
      {
        PublicAccountImageCollectionMainActivityImpl.access$2602(this.a, ((ZImageView)localObject).getDrawable());
        int i = ((ZImageView)localObject).getWidth();
        int j = ((ZImageView)localObject).getHeight();
        paramScaleGestureDetector = new RelativeLayout.LayoutParams(-1, -1);
        paramScaleGestureDetector.addRule(15);
        this.a.initMatrix = ((ZImageView)localObject).getImageMatrix();
        this.a.initMatrix.getValues(this.a.initValues);
        this.a.matrix.set(this.a.initMatrix);
        localObject = this.a;
        PublicAccountImageCollectionMainActivityImpl.access$202((PublicAccountImageCollectionMainActivityImpl)localObject, new PublicAccountImageView(((PublicAccountImageCollectionMainActivityImpl)localObject).mContext, this.a.mHandler, this.a.initMatrix, this.a.zoomEvent, i, j));
        PublicAccountImageCollectionMainActivityImpl.access$200(this.a).setImageDrawable(PublicAccountImageCollectionMainActivityImpl.access$2600(this.a));
        PublicAccountImageCollectionMainActivityImpl.access$200(this.a).setImageMatrix(this.a.matrix);
        this.a.viewGroup.addView(PublicAccountImageCollectionMainActivityImpl.access$200(this.a), paramScaleGestureDetector);
        PublicAccountImageCollectionMainActivityImpl.access$102(this.a, true);
        i = ((PublicAccountImageCollectionAdapter.ImageItemHolder)this.a.centerView.getTag()).a;
        if (PublicAccountImageCollectionMainActivityImpl.access$700(this.a).a != null)
        {
          paramScaleGestureDetector = ((IPublicAccountImageCollectionUtils.PhotoItemInfo)PublicAccountImageCollectionMainActivityImpl.access$700(this.a).a.get(i - 1)).a;
          ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, this.a.puin, "0X8007B91", "0X8007B91", 0, 0, this.a.articleID, this.a.webUrl, paramScaleGestureDetector, "1", false);
        }
      }
    }
    PublicAccountImageCollectionMainActivityImpl.access$2500(this.a).a();
    return true;
  }
  
  public boolean onScaleBegin(ScaleGestureDetector paramScaleGestureDetector)
  {
    return true;
  }
  
  public void onScaleEnd(ScaleGestureDetector paramScaleGestureDetector) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.imagecollection.api.impl.PublicAccountImageCollectionMainActivityImpl.ScaleGestureListener
 * JD-Core Version:    0.7.0.1
 */