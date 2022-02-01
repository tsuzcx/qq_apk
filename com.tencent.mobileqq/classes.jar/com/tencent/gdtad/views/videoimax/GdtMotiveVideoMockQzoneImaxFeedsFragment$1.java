package com.tencent.gdtad.views.videoimax;

import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.aditem.GdtHandler;
import com.tencent.gdtad.aditem.GdtHandler.Params;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.gdtad.views.video.GdtVideoData;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.DestInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.VideoInfo;

class GdtMotiveVideoMockQzoneImaxFeedsFragment$1
  implements View.OnClickListener
{
  GdtMotiveVideoMockQzoneImaxFeedsFragment$1(GdtMotiveVideoMockQzoneImaxFeedsFragment paramGdtMotiveVideoMockQzoneImaxFeedsFragment) {}
  
  public void onClick(View paramView)
  {
    GdtHandler.Params localParams = new GdtHandler.Params();
    localParams.q = 2;
    localParams.r = new WeakReference(this.a.getBaseActivity());
    Object localObject = GdtMotiveVideoMockQzoneImaxFeedsFragment.a(this.a).getAd();
    ((GdtAd)localObject).info.product_type.set(1000);
    ((GdtAd)localObject).info.dest_info.dest_type.set(4);
    ((GdtAd)localObject).info.display_info.video_info2.video_url.set(GdtMotiveVideoMockQzoneImaxFeedsFragment.a(this.a).getVideoData().getUrl());
    localParams.a = ((GdtAd)localObject);
    localParams.i = true;
    localParams.b = true;
    localObject = new int[2];
    paramView.getLocationInWindow((int[])localObject);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onClick() getLocationInWindow = [");
    localStringBuilder.append(Arrays.toString((int[])localObject));
    localStringBuilder.append("]");
    GdtLog.a("GdtMotiveVideoMockQzoneImaxFeedsFragment", localStringBuilder.toString());
    paramView.getLocationOnScreen((int[])localObject);
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("onClick() getLocationOnScreen = [");
    localStringBuilder.append(Arrays.toString((int[])localObject));
    localStringBuilder.append("]");
    GdtLog.a("GdtMotiveVideoMockQzoneImaxFeedsFragment", localStringBuilder.toString());
    localParams.j = new Rect(localObject[0], localObject[1], localObject[0] + paramView.getWidth(), localObject[1] + paramView.getHeight());
    localObject = this.a.getBaseActivity().getIntent();
    if (TextUtils.isEmpty(((Intent)localObject).getStringExtra("big_brother_ref_source_key"))) {
      localObject = ((Intent)localObject).getStringExtra("big_brother_source_key");
    } else {
      localObject = ((Intent)localObject).getStringExtra("big_brother_ref_source_key");
    }
    localParams.p = new Bundle();
    localParams.p.putString("big_brother_ref_source_key", (String)localObject);
    localParams.l = true;
    GdtHandler.a(localParams);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gdtad.views.videoimax.GdtMotiveVideoMockQzoneImaxFeedsFragment.1
 * JD-Core Version:    0.7.0.1
 */