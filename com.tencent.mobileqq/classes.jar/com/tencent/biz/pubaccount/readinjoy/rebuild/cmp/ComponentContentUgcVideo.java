package com.tencent.biz.pubaccount.readinjoy.rebuild.cmp;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView.ScaleType;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.view.KandianUrlImageView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;
import java.util.ArrayList;
import pai;
import pay;
import pvc;
import qtr;
import rfj;
import rfl;

public class ComponentContentUgcVideo
  extends ComponentContentBigImageVideo
{
  public ComponentContentUgcVideo(Context paramContext)
  {
    super(paramContext);
  }
  
  public ComponentContentUgcVideo(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public ComponentContentUgcVideo(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public View a(Context paramContext)
  {
    return LayoutInflater.from(paramContext).inflate(2131560125, this, true);
  }
  
  public URL a(pvc parampvc)
  {
    ArticleInfo localArticleInfo = parampvc.a();
    if ((localArticleInfo.mSocialFeedInfo != null) && (localArticleInfo.mSocialFeedInfo.a != null) && (localArticleInfo.mSocialFeedInfo.a.b.size() > 0))
    {
      Object localObject = (rfl)localArticleInfo.mSocialFeedInfo.a.b.get(0);
      int i = ((rfl)localObject).c;
      int j = ((rfl)localObject).d;
      if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.getLayoutParams() != null))
      {
        localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.getLayoutParams();
        int k = ((ViewGroup.LayoutParams)localObject).width;
        int m = ((ViewGroup.LayoutParams)localObject).height;
        if (k == m)
        {
          localObject = localArticleInfo.getVideoCoverWithSmartCut(k, m);
          if (QLog.isColorLevel())
          {
            if (localObject == null) {
              break label204;
            }
            QLog.d("ComponentContentUgcVideo", 2, "url: " + ((URL)localObject).toString() + ", ivWidth: " + k + ", ivHeight: " + m);
          }
          while (localObject != null)
          {
            parampvc = (pvc)localObject;
            return parampvc;
            label204:
            QLog.d("ComponentContentUgcVideo", 2, "ivWidth: " + k + ", ivHeight: " + m);
          }
        }
      }
      if (i * 4 > j * 3)
      {
        i = 1;
        label254:
        if (i != 0) {
          break label321;
        }
      }
      label321:
      for (boolean bool = true;; bool = false)
      {
        localObject = localArticleInfo.getVideoCoverUrlWithSmartCut(bool);
        if (localObject == null) {
          break label327;
        }
        parampvc = (pvc)localObject;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("ComponentContentUgcVideo", 2, "url: " + ((URL)localObject).toString());
        return localObject;
        i = 0;
        break label254;
      }
    }
    label327:
    return super.a(parampvc);
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
  }
  
  public void a(Object paramObject)
  {
    super.a(paramObject);
  }
  
  public void b()
  {
    ArticleInfo localArticleInfo;
    ViewGroup.LayoutParams localLayoutParams;
    Object localObject;
    int i;
    int k;
    boolean bool;
    int j;
    if ((this.jdField_a_of_type_Qtr.a != null) && (this.jdField_a_of_type_Qtr.a.a() != null))
    {
      localArticleInfo = this.jdField_a_of_type_Qtr.a.a();
      if ((localArticleInfo.mSocialFeedInfo != null) && (localArticleInfo.mSocialFeedInfo.a != null) && (localArticleInfo.mSocialFeedInfo.a.b.size() > 0))
      {
        localLayoutParams = getLayoutParams();
        localObject = getResources().getDisplayMetrics();
        i = Math.min(((DisplayMetrics)localObject).widthPixels, ((DisplayMetrics)localObject).heightPixels);
        k = AIOUtils.dp2px(12.0F, getResources());
        localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.getLayoutParams();
        rfl localrfl = (rfl)localArticleInfo.mSocialFeedInfo.a.b.get(0);
        if (pay.a(localrfl.c, localrfl.d)) {
          break label299;
        }
        bool = true;
        QLog.d("ComponentContentUgcVideo", 2, "isHorizontalScreen " + bool);
        if (!bool) {
          break label305;
        }
        j = i - k * 2;
        i = j * 9 / 16;
      }
    }
    for (;;)
    {
      ((ViewGroup.LayoutParams)localObject).width = j;
      ((ViewGroup.LayoutParams)localObject).height = i;
      localLayoutParams.width = j;
      localLayoutParams.height = i;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      setLayoutParams(localLayoutParams);
      QLog.d("ComponentContentUgcVideo", 2, "imageParams.width is " + ((ViewGroup.LayoutParams)localObject).width + "; imageParams.height is " + ((ViewGroup.LayoutParams)localObject).height);
      return;
      label299:
      bool = false;
      break;
      label305:
      if (localArticleInfo.mChannelID == 0L)
      {
        i = pai.a(i, getResources());
        QLog.d("ComponentContentUgcVideo", 2, "main feeds | ivWidth is " + i + "; ivHeight is " + i);
        j = i;
      }
      else
      {
        j = (i - k * 2 + 9) / 2;
        i = (i - k * 2) / 3 * 2;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentContentUgcVideo
 * JD-Core Version:    0.7.0.1
 */