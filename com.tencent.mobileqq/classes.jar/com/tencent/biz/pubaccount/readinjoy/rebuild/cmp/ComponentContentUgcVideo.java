package com.tencent.biz.pubaccount.readinjoy.rebuild.cmp;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView.ScaleType;
import com.tencent.biz.pubaccount.readinjoy.model.IReadInJoyModel;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.UGCFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.UGCVideoInfo;
import com.tencent.biz.pubaccount.readinjoy.view.KandianUrlImageView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import java.util.ArrayList;

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
    return LayoutInflater.from(paramContext).inflate(2130969567, this, true);
  }
  
  public void b()
  {
    ViewGroup.LayoutParams localLayoutParams;
    Object localObject2;
    int k;
    int m;
    int j;
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt.a != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt.a.a() != null))
    {
      Object localObject1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt.a.a();
      if ((((ArticleInfo)localObject1).mSocialFeedInfo != null) && (((ArticleInfo)localObject1).mSocialFeedInfo.a != null) && (((ArticleInfo)localObject1).mSocialFeedInfo.a.b.size() > 0))
      {
        localLayoutParams = getLayoutParams();
        localObject2 = getResources().getDisplayMetrics();
        k = Math.min(((DisplayMetrics)localObject2).widthPixels, ((DisplayMetrics)localObject2).heightPixels);
        m = AIOUtils.a(12.0F, getResources());
        localObject2 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.getLayoutParams();
        localObject1 = (SocializeFeedsInfo.UGCVideoInfo)((ArticleInfo)localObject1).mSocialFeedInfo.a.b.get(0);
        if (((SocializeFeedsInfo.UGCVideoInfo)localObject1).c * 4 <= ((SocializeFeedsInfo.UGCVideoInfo)localObject1).d * 3) {
          break label232;
        }
        i = 1;
        if (i == 0) {
          break label237;
        }
        j = k - m * 2;
      }
    }
    for (int i = j * 9 / 16;; i = (k - m * 2) / 3 * 2)
    {
      ((ViewGroup.LayoutParams)localObject2).width = j;
      ((ViewGroup.LayoutParams)localObject2).height = i;
      localLayoutParams.width = j;
      localLayoutParams.height = i;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      setLayoutParams(localLayoutParams);
      return;
      label232:
      i = 0;
      break;
      label237:
      j = (k - m * 2 + 9) / 2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentContentUgcVideo
 * JD-Core Version:    0.7.0.1
 */