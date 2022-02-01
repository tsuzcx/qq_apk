package com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_action.jump_action;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyForCanvasFragment;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyVideoCeilingFragment;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.util.ReadinJoyActionUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.aditem.GdtAppReceiver;
import com.tencent.gdtad.aditem.GdtHandler.Params;
import java.lang.ref.WeakReference;

public class AdParamsFactory
{
  public static GdtHandler.Params a(AdvertisementInfo paramAdvertisementInfo, Activity paramActivity, ReadInJoyGdtAdParams paramReadInJoyGdtAdParams)
  {
    if ((paramAdvertisementInfo == null) || (paramActivity == null)) {
      return null;
    }
    GdtHandler.Params localParams = new GdtHandler.Params();
    ReadInJoyGdtAdParams localReadInJoyGdtAdParams = paramReadInJoyGdtAdParams;
    if (paramReadInJoyGdtAdParams == null) {
      localReadInJoyGdtAdParams = new ReadInJoyGdtAdParams();
    }
    paramReadInJoyGdtAdParams = ReadinJoyActionUtil.a(paramAdvertisementInfo);
    localParams.c = 1;
    localParams.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramActivity);
    localParams.jdField_a_of_type_ComTencentGdtadAditemGdtAd = new GdtAd(paramReadInJoyGdtAdParams);
    localParams.jdField_a_of_type_Boolean = localReadInJoyGdtAdParams.jdField_a_of_type_Boolean;
    localParams.jdField_b_of_type_Boolean = false;
    if (paramAdvertisementInfo.clickPos > 0)
    {
      localParams.jdField_b_of_type_Int = paramAdvertisementInfo.clickPos;
      paramAdvertisementInfo.resetClickPos();
    }
    localParams.jdField_a_of_type_Long = localReadInJoyGdtAdParams.jdField_a_of_type_Long;
    if (ReadinJoyActionUtil.a == null)
    {
      ReadinJoyActionUtil.a = new GdtAppReceiver();
      ReadinJoyActionUtil.a.register(BaseApplicationImpl.getContext());
    }
    localParams.jdField_b_of_type_JavaLangRefWeakReference = new WeakReference(ReadinJoyActionUtil.a);
    long l = paramAdvertisementInfo.mChannelID;
    if ((l != 3L) && (l != 4L) && (paramAdvertisementInfo.mAdJumpMode != 6) && (!localReadInJoyGdtAdParams.d) && (l != 2000001L))
    {
      localParams.jdField_a_of_type_JavaLangClass = ReadInJoyVideoCeilingFragment.class;
      ReadinJoyActionUtil.a(localParams, localReadInJoyGdtAdParams.c, paramAdvertisementInfo, paramActivity);
    }
    localParams.jdField_b_of_type_JavaLangClass = ReadInJoyForCanvasFragment.class;
    localParams.jdField_a_of_type_AndroidOsBundle = new Bundle();
    localParams.jdField_a_of_type_AndroidOsBundle.putString("big_brother_ref_source_key", "biz_src_feeds_kandian");
    return localParams;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_action.jump_action.AdParamsFactory
 * JD-Core Version:    0.7.0.1
 */