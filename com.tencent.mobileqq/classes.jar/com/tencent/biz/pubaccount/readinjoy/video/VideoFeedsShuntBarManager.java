package com.tencent.biz.pubaccount.readinjoy.video;

import android.app.Activity;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.TextView;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.VideoInfo.ECommerceEntranceInfo;
import com.tencent.biz.pubaccount.api.IPublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.UrlJumpInfo;
import com.tencent.biz.pubaccount.readinjoy.video.report.VideoR5;
import com.tencent.biz.pubaccount.readinjoy.video.report.VideoR5.Builder;
import com.tencent.biz.pubaccount.readinjoy.video.videofeeds.BaseItemHolder;
import com.tencent.biz.pubaccount.readinjoy.video.videofeeds.ShortVideoItemHolder;
import com.tencent.biz.pubaccount.readinjoy.video.videofeeds.VideoItemHolder;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.urldrawable.URLDrawableDecodeHandler;
import com.tencent.mobileqq.utils.PackageUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class VideoFeedsShuntBarManager
  implements View.OnClickListener
{
  private static final String jdField_a_of_type_JavaLangString = "Q.readinjoy.video." + VideoFeedsShuntBarManager.class.getSimpleName();
  private int jdField_a_of_type_Int;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private VideoInfo.ECommerceEntranceInfo jdField_a_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo;
  private VideoFeedsAdapter jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter;
  private VideoFeedsShuntBarConfigure jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsShuntBarConfigure;
  private VideofeedsUserGuideController jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsUserGuideController;
  private ArrayList<Integer> jdField_a_of_type_JavaUtilArrayList;
  private Set<String> jdField_a_of_type_JavaUtilSet = new HashSet();
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private VideoInfo.ECommerceEntranceInfo jdField_b_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo;
  private boolean jdField_b_of_type_Boolean;
  private int c;
  
  public VideoFeedsShuntBarManager(QQAppInterface paramQQAppInterface, Activity paramActivity, VideoFeedsAdapter paramVideoFeedsAdapter, VideofeedsUserGuideController paramVideofeedsUserGuideController)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsShuntBarConfigure = new VideoFeedsShuntBarConfigure(paramQQAppInterface);
    this.jdField_a_of_type_Int = VideoFeedsHelper.a();
    this.jdField_b_of_type_Int = VideoFeedsHelper.b();
    this.jdField_c_of_type_Int = VideoFeedsHelper.c();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter = paramVideoFeedsAdapter;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsUserGuideController = paramVideofeedsUserGuideController;
  }
  
  private void a(VideoInfo.ECommerceEntranceInfo paramECommerceEntranceInfo, VideoItemHolder paramVideoItemHolder, VideoInfo paramVideoInfo)
  {
    this.jdField_b_of_type_Boolean = true;
    if (paramECommerceEntranceInfo == null) {
      return;
    }
    this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo = paramECommerceEntranceInfo;
    if (paramECommerceEntranceInfo.jdField_h_of_type_Int == 0)
    {
      if ((paramVideoItemHolder.q == null) && ((paramVideoItemHolder instanceof ShortVideoItemHolder)))
      {
        paramVideoItemHolder.q = ((ViewGroup)((ViewStub)paramVideoItemHolder.p.findViewById(2131381380)).inflate());
        paramVideoItemHolder.jdField_d_of_type_ComTencentImageURLImageView = ((URLImageView)paramVideoItemHolder.q.findViewById(2131378092));
        paramVideoItemHolder.z = ((TextView)paramVideoItemHolder.q.findViewById(2131378093));
        paramVideoItemHolder.r = paramVideoItemHolder.q.findViewById(2131378091);
      }
      if (paramVideoItemHolder.q != null)
      {
        paramVideoItemHolder.q.setVisibility(0);
        if (TextUtils.isEmpty(paramECommerceEntranceInfo.jdField_c_of_type_JavaLangString)) {}
      }
    }
    for (;;)
    {
      try
      {
        Object localObject1 = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject1).mRequestWidth = ViewUtils.a(this.jdField_c_of_type_Int);
        ((URLDrawable.URLDrawableOptions)localObject1).mRequestHeight = ViewUtils.a(this.jdField_c_of_type_Int);
        localObject1 = URLDrawable.getDrawable(paramECommerceEntranceInfo.jdField_c_of_type_JavaLangString, (URLDrawable.URLDrawableOptions)localObject1);
        ((URLDrawable)localObject1).setTag(new int[] { 0, 0, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int });
        ((URLDrawable)localObject1).setDecodeHandler(URLDrawableDecodeHandler.k);
        paramVideoItemHolder.jdField_d_of_type_ComTencentImageURLImageView.setImageDrawable((Drawable)localObject1);
        paramVideoItemHolder.z.setText(paramECommerceEntranceInfo.jdField_a_of_type_JavaLangString);
        VideoFeedsHelper.a(paramVideoItemHolder.q, 200);
        paramVideoItemHolder.q.setTag(paramVideoItemHolder);
        paramVideoItemHolder.q.setOnClickListener(this);
        if (paramVideoItemHolder.r != null)
        {
          paramVideoItemHolder.r.setTag(paramVideoItemHolder);
          paramVideoItemHolder.r.setOnClickListener(this);
        }
        ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, null, "0X8009376", "0X8009376", 0, 0, "", "", "", new VideoR5.Builder(null, null, null, paramVideoInfo.g).Q(paramECommerceEntranceInfo.jdField_h_of_type_Int).a(paramECommerceEntranceInfo.f).e(paramVideoInfo.f).i(paramVideoInfo.g).f(paramECommerceEntranceInfo.jdField_c_of_type_Int).a().a(), false);
        return;
      }
      catch (Exception localException)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d(jdField_a_of_type_JavaLangString, 2, "后台下发的url格式有问题：" + paramECommerceEntranceInfo.jdField_c_of_type_JavaLangString);
        continue;
      }
      if (paramECommerceEntranceInfo.jdField_h_of_type_Int == 1)
      {
        if ((paramVideoItemHolder.u == null) && (paramVideoItemHolder.jdField_a_of_type_AndroidViewViewStub != null))
        {
          paramVideoItemHolder.jdField_a_of_type_AndroidViewViewStub.inflate();
          paramVideoItemHolder.u = ((ViewGroup)paramVideoItemHolder.C.findViewById(2131374185));
          paramVideoItemHolder.f = ((URLImageView)paramVideoItemHolder.C.findViewById(2131378539));
          paramVideoItemHolder.E = ((TextView)paramVideoItemHolder.C.findViewById(2131378538));
          paramVideoItemHolder.s = paramVideoItemHolder.C.findViewById(2131378536);
          paramVideoItemHolder.F = ((TextView)paramVideoItemHolder.C.findViewById(2131378540));
          paramVideoItemHolder.G = ((TextView)paramVideoItemHolder.C.findViewById(2131378537));
          paramVideoItemHolder.s.setTag(paramVideoItemHolder);
          paramVideoItemHolder.s.setOnClickListener(this);
          paramVideoItemHolder.E.setTag(paramVideoItemHolder);
          paramVideoItemHolder.E.setOnClickListener(this);
        }
        VideoFeedsHelper.a(paramVideoItemHolder.u, 0);
        Object localObject2 = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = new ColorDrawable(0);
        ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable;
        int i = ViewUtils.a(60.0F);
        int j = ViewUtils.a(10.0F);
        ((URLDrawable.URLDrawableOptions)localObject2).mRequestWidth = ViewUtils.a(i);
        ((URLDrawable.URLDrawableOptions)localObject2).mRequestHeight = ViewUtils.a(i);
        localObject2 = URLDrawable.getDrawable(paramECommerceEntranceInfo.jdField_c_of_type_JavaLangString, (URLDrawable.URLDrawableOptions)localObject2);
        ((URLDrawable)localObject2).setDecodeHandler(URLDrawableDecodeHandler.k);
        ((URLDrawable)localObject2).setTag(new int[] { 0, 0, j, 0 });
        paramVideoItemHolder.f.setImageDrawable((Drawable)localObject2);
        if ((paramECommerceEntranceInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo != null) && (PackageUtil.a(this.jdField_a_of_type_AndroidAppActivity, paramECommerceEntranceInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo.jdField_b_of_type_JavaLangString)))
        {
          i = 1;
          label718:
          if (i == 0) {
            break label812;
          }
          paramVideoItemHolder.E.setText(paramECommerceEntranceInfo.jdField_h_of_type_JavaLangString);
        }
        for (;;)
        {
          paramVideoItemHolder.F.setText(paramECommerceEntranceInfo.jdField_a_of_type_JavaLangString);
          paramVideoItemHolder.G.setText(paramECommerceEntranceInfo.jdField_b_of_type_JavaLangString);
          paramVideoItemHolder.v.setVisibility(8);
          paramVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoIVideoFeedsItemUIDelegate.b(false);
          paramVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoIVideoFeedsItemUIDelegate.c(false);
          paramVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoIVideoFeedsItemUIDelegate.d(false);
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter.f(false);
          break;
          i = 0;
          break label718;
          label812:
          paramVideoItemHolder.E.setText(paramECommerceEntranceInfo.g);
        }
      }
      if (paramECommerceEntranceInfo.jdField_h_of_type_Int == 2) {
        b(paramECommerceEntranceInfo, paramVideoItemHolder, paramVideoInfo);
      }
    }
  }
  
  private boolean a(VideoInfo.ECommerceEntranceInfo paramECommerceEntranceInfo)
  {
    if (paramECommerceEntranceInfo.jdField_h_of_type_Int == 2) {
      if (TextUtils.isEmpty(paramECommerceEntranceInfo.jdField_a_of_type_JavaLangString)) {}
    }
    while ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsShuntBarConfigure.a(paramECommerceEntranceInfo)) && ((!TextUtils.isEmpty(paramECommerceEntranceInfo.jdField_a_of_type_JavaLangString)) || (!TextUtils.isEmpty(paramECommerceEntranceInfo.jdField_b_of_type_JavaLangString))))
    {
      return true;
      return false;
    }
    return false;
  }
  
  private boolean a(VideoInfo.ECommerceEntranceInfo paramECommerceEntranceInfo, int paramInt1, int paramInt2)
  {
    if ((paramECommerceEntranceInfo.jdField_b_of_type_Int >= 0) && (paramInt1 >= paramECommerceEntranceInfo.jdField_b_of_type_Int)) {}
    while ((paramECommerceEntranceInfo.jdField_c_of_type_Int >= 0) && (paramInt1 / paramInt2 * 100.0F >= paramECommerceEntranceInfo.jdField_c_of_type_Int)) {
      return true;
    }
    return false;
  }
  
  private void b(VideoInfo.ECommerceEntranceInfo paramECommerceEntranceInfo, VideoItemHolder paramVideoItemHolder, VideoInfo paramVideoInfo)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsUserGuideController.a(paramVideoInfo, paramECommerceEntranceInfo, this);
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsShuntBarConfigure.a();
    this.jdField_a_of_type_AndroidAppActivity = null;
  }
  
  public void a(VideoInfo.ECommerceEntranceInfo paramECommerceEntranceInfo)
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo == null) && (paramECommerceEntranceInfo != null))
    {
      this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo = paramECommerceEntranceInfo;
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "play by positions, position to play is: " + Arrays.toString(paramECommerceEntranceInfo.jdField_a_of_type_ArrayOfInt) + ", play time is:" + paramECommerceEntranceInfo.jdField_b_of_type_Int + ", play percent :" + paramECommerceEntranceInfo.jdField_c_of_type_Int);
      }
      this.jdField_a_of_type_JavaUtilArrayList = new ArrayList(Arrays.asList(VideoFeedsHelper.a(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo.jdField_a_of_type_ArrayOfInt)));
    }
  }
  
  public void a(VideoInfo paramVideoInfo, VideoItemHolder paramVideoItemHolder, int paramInt1, int paramInt2)
  {
    if (paramVideoItemHolder.jdField_a_of_type_Int != 2) {}
    label8:
    do
    {
      do
      {
        do
        {
          break label8;
          do
          {
            return;
          } while (paramVideoItemHolder.jdField_d_of_type_AndroidViewViewGroup.getVisibility() == 0);
          if ((paramVideoInfo == null) || (paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo == null)) {
            break;
          }
        } while ((!a(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo, paramInt1, paramInt2)) || (this.jdField_a_of_type_Boolean) || (this.jdField_b_of_type_Boolean) || (!a(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo)));
        a(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo, paramVideoItemHolder, paramVideoInfo);
        this.jdField_a_of_type_JavaUtilSet.add(paramVideoInfo.jdField_a_of_type_JavaLangString);
      } while (!QLog.isColorLevel());
      QLog.d(jdField_a_of_type_JavaLangString, 2, "show shunt bar!!!");
      return;
    } while ((paramVideoItemHolder.q == null) || (paramVideoItemHolder.q.getVisibility() != 0));
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "默认不显示引流条");
    }
    paramVideoItemHolder.q.setVisibility(8);
  }
  
  public void a(VideoItemHolder paramVideoItemHolder)
  {
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_Boolean = false;
    b(paramVideoItemHolder);
  }
  
  public void a(List<VideoInfo> paramList)
  {
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      Iterator localIterator = new ArrayList(this.jdField_a_of_type_JavaUtilArrayList).iterator();
      while (localIterator.hasNext())
      {
        Integer localInteger = (Integer)localIterator.next();
        int i = localInteger.intValue() - 1;
        if ((i > 0) && (i < paramList.size()))
        {
          VideoInfo localVideoInfo2 = (VideoInfo)paramList.get(i);
          VideoInfo localVideoInfo1 = localVideoInfo2;
          if (localVideoInfo2.c)
          {
            if (i + 1 < paramList.size()) {
              localVideoInfo1 = (VideoInfo)paramList.get(i + 1);
            }
          }
          else
          {
            if (localVideoInfo1.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo == null) {
              localVideoInfo1.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo = this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo;
            }
            this.jdField_a_of_type_JavaUtilArrayList.remove(localInteger);
          }
        }
      }
    }
  }
  
  public void b(VideoItemHolder paramVideoItemHolder)
  {
    if ((paramVideoItemHolder == null) || (this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo == null)) {}
    do
    {
      do
      {
        do
        {
          return;
        } while (paramVideoItemHolder.jdField_a_of_type_Int != 2);
        if (this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo.jdField_h_of_type_Int != 0) {
          break;
        }
      } while (paramVideoItemHolder.q == null);
      paramVideoItemHolder.q.setVisibility(8);
      return;
      if (this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo.jdField_h_of_type_Int == 1)
      {
        if (paramVideoItemHolder.u != null) {
          paramVideoItemHolder.u.setVisibility(8);
        }
        paramVideoItemHolder.v.setVisibility(0);
        paramVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoIVideoFeedsItemUIDelegate.b(true);
        paramVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoIVideoFeedsItemUIDelegate.c(true);
        paramVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoIVideoFeedsItemUIDelegate.d(true);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter.f(true);
        return;
      }
    } while (this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo.jdField_h_of_type_Int != 2);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsUserGuideController.a();
  }
  
  public void c(VideoItemHolder paramVideoItemHolder)
  {
    if (this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo == null) {
      return;
    }
    this.jdField_a_of_type_Boolean = true;
    this.jdField_b_of_type_Boolean = false;
    label80:
    IPublicAccountReportUtils localIPublicAccountReportUtils;
    Object localObject;
    if (this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo.jdField_h_of_type_Int == 0) {
      if (!TextUtils.isEmpty(this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo.e))
      {
        ReadInJoyUtils.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo.e);
        b(paramVideoItemHolder);
        if ((paramVideoItemHolder == null) || (paramVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam == null)) {
          break label262;
        }
        paramVideoItemHolder = paramVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam.a;
        localIPublicAccountReportUtils = (IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class);
        if (paramVideoItemHolder == null) {
          break label267;
        }
        localObject = paramVideoItemHolder.g;
        label98:
        VideoR5.Builder localBuilder = new VideoR5.Builder(null, null, null, (String)localObject).Q(this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo.jdField_h_of_type_Int).f(this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo.jdField_c_of_type_Int).a(this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo.f);
        if (paramVideoItemHolder == null) {
          break label272;
        }
        localObject = paramVideoItemHolder.g;
        label150:
        localObject = localBuilder.i((String)localObject);
        if (paramVideoItemHolder == null) {
          break label277;
        }
      }
    }
    label262:
    label267:
    label272:
    label277:
    for (paramVideoItemHolder = Long.valueOf(paramVideoItemHolder.f);; paramVideoItemHolder = null)
    {
      localIPublicAccountReportUtils.publicAccountReportClickEvent(null, null, "0X8009377", "0X8009377", 0, 0, "", "", "", ((VideoR5.Builder)localObject).e(paramVideoItemHolder.longValue()).a().a(), false);
      return;
      if (this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo == null) {
        break;
      }
      VideoFeedsHelper.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo);
      break;
      if (this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo.jdField_h_of_type_Int != 1) {
        break;
      }
      VideoFeedsHelper.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo);
      break;
      paramVideoItemHolder = null;
      break label80;
      localObject = null;
      break label98;
      localObject = null;
      break label150;
    }
  }
  
  public void onClick(View paramView)
  {
    BaseItemHolder localBaseItemHolder = (BaseItemHolder)paramView.getTag();
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      c((VideoItemHolder)localBaseItemHolder);
      continue;
      b((VideoItemHolder)localBaseItemHolder);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsShuntBarManager
 * JD-Core Version:    0.7.0.1
 */