package com.tencent.biz.pubaccount.readinjoy.fragment;

import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.StaggeredGridLayoutManager.LayoutParams;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.common.DistinctEventReporter;
import com.tencent.biz.pubaccount.readinjoy.common.GalleryReportedUtils;
import com.tencent.biz.pubaccount.readinjoy.common.GalleryReportedUtils.ReportData;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyDisplayUtils;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.preparse.RIJPreParseData;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngine;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.FeedsInfoUser;
import com.tencent.biz.pubaccount.readinjoy.view.HeadImageWithRing;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyNickNameTextView;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInjoyXRecyclerView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.readinjoy.ReadInJoyHelper;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.oidb.gallery.galleryFeeds.GalleryFeedsInfo;
import tencent.im.oidb.gallery.galleryFeeds.Picture;
import tencent.im.oidb.gallery.galleryFeeds.UserInfo;

class ReadInJoyPicWaterFallFragment$WaterFallPicAdapter
  extends RecyclerView.Adapter<ReadInJoyPicWaterFallFragment.BaseViewHolder>
{
  public final int a;
  List<BaseArticleInfo> jdField_a_of_type_JavaUtilList = new ArrayList();
  int b;
  int c;
  int d;
  int e;
  
  public ReadInJoyPicWaterFallFragment$WaterFallPicAdapter(ReadInJoyPicWaterFallFragment paramReadInJoyPicWaterFallFragment)
  {
    this.jdField_a_of_type_Int = DisplayUtil.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyPicWaterFallFragment.getActivity(), 150.0F);
    this.b = AIOUtils.a(3.0F, paramReadInJoyPicWaterFallFragment.getResources());
    this.c = AIOUtils.a(58.5F, paramReadInJoyPicWaterFallFragment.getResources());
    this.d = AIOUtils.a(226.0F, paramReadInJoyPicWaterFallFragment.getResources());
  }
  
  private void a(ReadInJoyPicWaterFallFragment.ActiveViewHolder paramActiveViewHolder, int paramInt)
  {
    int i = -1;
    Object localObject1 = (BaseArticleInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    if (paramActiveViewHolder.itemView.getLayoutParams() == null)
    {
      localObject2 = new StaggeredGridLayoutManager.LayoutParams(-1, AIOUtils.a(314.0F, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyPicWaterFallFragment.getResources()));
      paramActiveViewHolder.itemView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
    }
    paramActiveViewHolder.jdField_a_of_type_AndroidWidgetTextView.setText(((BaseArticleInfo)localObject1).mTitle);
    Object localObject2 = paramActiveViewHolder.jdField_a_of_type_AndroidWidgetTextView;
    paramInt = i;
    if (ReadInJoyLogicEngine.a().a(((BaseArticleInfo)localObject1).mArticleID)) {
      paramInt = ReadInJoyPicWaterFallFragment.c;
    }
    ((TextView)localObject2).setTextColor(paramInt);
    paramActiveViewHolder.jdField_b_of_type_ComTencentImageURLImageView.setContentDescription(((BaseArticleInfo)localObject1).getSubscribeName());
    ReadInJoyDisplayUtils.a(paramActiveViewHolder.jdField_b_of_type_ComTencentImageURLImageView, ((BaseArticleInfo)localObject1).mGalleryFeedsInfo.bytes_topic_pic_url.get().toStringUtf8(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyPicWaterFallFragment.getActivity());
    paramActiveViewHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo = ((BaseArticleInfo)localObject1);
    localObject1 = ((BaseArticleInfo)localObject1).mGalleryFeedsInfo.bytes_topic_icon_url.get().toStringUtf8();
    if (!TextUtils.isEmpty((CharSequence)localObject1))
    {
      paramActiveViewHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      localObject1 = URLDrawableHelper.getDrawable((String)localObject1);
      paramActiveViewHolder.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject1);
      return;
    }
    paramActiveViewHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
  }
  
  private void a(ReadInJoyPicWaterFallFragment.NormalViewHolder paramNormalViewHolder, int paramInt)
  {
    Object localObject1 = (BaseArticleInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    a((BaseArticleInfo)localObject1);
    Object localObject2 = (FrameLayout.LayoutParams)paramNormalViewHolder.jdField_b_of_type_ComTencentImageURLImageView.getLayoutParams();
    label107:
    int i;
    label153:
    label330:
    label381:
    Object localObject3;
    if (localObject2 == null)
    {
      localObject2 = new FrameLayout.LayoutParams(-1, ((BaseArticleInfo)localObject1).waterFallPic.c);
      paramNormalViewHolder.jdField_b_of_type_ComTencentImageURLImageView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      if (((BaseArticleInfo)localObject1).waterFallPic.d <= this.d) {
        break label815;
      }
      paramNormalViewHolder.jdField_b_of_type_ComTencentImageURLImageView.setPadding(0, ((BaseArticleInfo)localObject1).waterFallPic.d - ((BaseArticleInfo)localObject1).waterFallPic.c, 0, 0);
      paramNormalViewHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo = ((BaseArticleInfo)localObject1);
      paramNormalViewHolder.jdField_a_of_type_AndroidWidgetTextView.setText(((BaseArticleInfo)localObject1).mTitle);
      boolean bool = ReadInJoyLogicEngine.a().a(((BaseArticleInfo)localObject1).mArticleID);
      localObject2 = paramNormalViewHolder.jdField_a_of_type_AndroidWidgetTextView;
      if (!bool) {
        break label829;
      }
      i = ReadInJoyPicWaterFallFragment.c;
      ((TextView)localObject2).setTextColor(i);
      paramNormalViewHolder.jdField_b_of_type_ComTencentImageURLImageView.setContentDescription(((BaseArticleInfo)localObject1).getSubscribeName());
      ReadInJoyDisplayUtils.a(paramNormalViewHolder.jdField_b_of_type_ComTencentImageURLImageView, ((BaseArticleInfo)localObject1).waterFallPic.jdField_a_of_type_JavaNetURL, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyPicWaterFallFragment.getActivity());
      paramNormalViewHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView.setVisibility(0);
      paramNormalViewHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView.setText(((BaseArticleInfo)localObject1).getSubscribeName());
      paramNormalViewHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView.setContentDescription(((BaseArticleInfo)localObject1).getSubscribeName());
      paramNormalViewHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView.getPaint().setFakeBoldText(true);
      if (((BaseArticleInfo)localObject1).mGalleryFeedsInfo.uint32_is_account_derelict.get() != 1) {
        break label836;
      }
      paramNormalViewHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewHeadImageWithRing.setImageResource(2130846724);
      label260:
      if (((BaseArticleInfo)localObject1).mSocialFeedInfo == null) {
        break label960;
      }
      paramNormalViewHolder.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      localObject2 = ReadInJoyHelper.a(((BaseArticleInfo)localObject1).mSocialFeedInfo.b, 999000L, "99.9万", "0");
      paramNormalViewHolder.jdField_b_of_type_AndroidWidgetTextView.setText((String)localObject2 + HardCodeUtil.a(2131712947));
      if (((BaseArticleInfo)localObject1).mGalleryPicNumber <= 1) {
        break label972;
      }
      paramNormalViewHolder.c.setVisibility(0);
      paramNormalViewHolder.c.setText(((BaseArticleInfo)localObject1).mGalleryPicNumber + HardCodeUtil.a(2131712854));
      if (((BaseArticleInfo)localObject1).mGalleryFeedsInfo == null) {
        break label1016;
      }
      localObject2 = ((BaseArticleInfo)localObject1).mGalleryFeedsInfo.bytes_attachment_content.get().toStringUtf8();
      localObject3 = ((BaseArticleInfo)localObject1).mGalleryFeedsInfo.bytes_attachment_jump_url.get().toStringUtf8();
      String str = ((BaseArticleInfo)localObject1).mGalleryFeedsInfo.bytes_attachment_icon_url.get().toStringUtf8();
      if ((TextUtils.isEmpty((CharSequence)localObject2)) || (TextUtils.isEmpty((CharSequence)localObject3)) || (TextUtils.isEmpty(str))) {
        break label994;
      }
      paramNormalViewHolder.jdField_a_of_type_AndroidViewView.setVisibility(0);
      paramNormalViewHolder.d.setText((CharSequence)localObject2);
      localObject2 = URLDrawableHelper.getDrawable(str);
      paramNormalViewHolder.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject2);
      localObject2 = GalleryReportedUtils.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyPicWaterFallFragment.getActivity(), ReadInJoyPicWaterFallFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyPicWaterFallFragment), 3, paramInt, (ArticleInfo)localObject1);
    }
    for (;;)
    {
      for (;;)
      {
        try
        {
          ((JSONObject)localObject2).put("exptime", System.currentTimeMillis());
          ((JSONObject)localObject2).put("proxy_bytes", ((BaseArticleInfo)localObject1).galleryReprotExdData);
          ((JSONObject)localObject2).put("operation_id", ((BaseArticleInfo)localObject1).mGalleryFeedsInfo.bytes_operation_id.get().toStringUtf8());
          localObject3 = new GalleryReportedUtils.ReportData((BaseArticleInfo)localObject1);
          ((GalleryReportedUtils.ReportData)localObject3).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo = ((BaseArticleInfo)localObject1);
          ((GalleryReportedUtils.ReportData)localObject3).e = String.valueOf(((BaseArticleInfo)localObject1).mArticleID);
          ((GalleryReportedUtils.ReportData)localObject3).f = String.valueOf(((BaseArticleInfo)localObject1).mAlgorithmID);
          ((GalleryReportedUtils.ReportData)localObject3).g = ((JSONObject)localObject2).toString();
          if (((BaseArticleInfo)localObject1).mSocialFeedInfo.a != null) {
            ((GalleryReportedUtils.ReportData)localObject3).jdField_a_of_type_JavaLangString = String.valueOf(((BaseArticleInfo)localObject1).mSocialFeedInfo.a.a);
          }
          ((GalleryReportedUtils.ReportData)localObject3).b = "0X8009A7A";
          ((GalleryReportedUtils.ReportData)localObject3).c = "0X8009A7A";
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyPicWaterFallFragment.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommonDistinctEventReporter.a("exp_waterfall_operation", localObject3);
        }
        catch (JSONException localJSONException)
        {
          label815:
          label829:
          label836:
          localJSONException.printStackTrace();
          continue;
        }
        localObject2 = ((BaseArticleInfo)localObject1).mGalleryFeedsInfo.bytes_note_content.get().toStringUtf8();
        localObject1 = ((BaseArticleInfo)localObject1).mGalleryFeedsInfo.bytes_note_icon_url.get().toStringUtf8();
        if ((TextUtils.isEmpty((CharSequence)localObject2)) || (TextUtils.isEmpty((CharSequence)localObject1))) {
          break label1006;
        }
        paramNormalViewHolder.jdField_b_of_type_AndroidViewView.setVisibility(0);
        paramNormalViewHolder.e.setText((CharSequence)localObject2);
        localObject1 = URLDrawableHelper.getDrawable((String)localObject1);
        paramNormalViewHolder.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject1);
        return;
        if ((((FrameLayout.LayoutParams)localObject2).height > 0) && (((FrameLayout.LayoutParams)localObject2).height == ((BaseArticleInfo)localObject1).waterFallPic.c)) {
          break;
        }
        ((FrameLayout.LayoutParams)localObject2).height = ((BaseArticleInfo)localObject1).waterFallPic.c;
        paramNormalViewHolder.jdField_b_of_type_ComTencentImageURLImageView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
        break;
        paramNormalViewHolder.jdField_b_of_type_ComTencentImageURLImageView.setPadding(0, 0, 0, 0);
        break label107;
        i = ReadInJoyPicWaterFallFragment.e;
        break label153;
        localObject2 = ((BaseArticleInfo)localObject1).mGalleryFeedsInfo.msg_publisher_info.bytes_header_url.get().toStringUtf8();
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          continue;
        }
        localObject3 = URLDrawable.URLDrawableOptions.obtain();
        i = AIOUtils.a(12.0F, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyPicWaterFallFragment.getResources());
        ((URLDrawable.URLDrawableOptions)localObject3).mRequestWidth = i;
        ((URLDrawable.URLDrawableOptions)localObject3).mRequestHeight = i;
        try
        {
          localObject2 = URLDrawable.getDrawable((String)localObject2, (URLDrawable.URLDrawableOptions)localObject3);
          paramNormalViewHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewHeadImageWithRing.setImageDrawable((Drawable)localObject2);
        }
        catch (Exception localException)
        {
          QLog.e("ReadInJoyPicWaterFallFragment", 1, "bindNormalHolder, e = " + localException);
        }
      }
      break label260;
      paramNormalViewHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewHeadImageWithRing.setImageResource(2130846724);
      break label260;
      label960:
      paramNormalViewHolder.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      break label330;
      label972:
      paramNormalViewHolder.c.setVisibility(8);
      break label381;
      label994:
      paramNormalViewHolder.jdField_a_of_type_AndroidViewView.setVisibility(8);
    }
    label1006:
    paramNormalViewHolder.jdField_b_of_type_AndroidViewView.setVisibility(8);
    return;
    label1016:
    paramNormalViewHolder.jdField_b_of_type_AndroidViewView.setVisibility(8);
    paramNormalViewHolder.jdField_a_of_type_AndroidViewView.setVisibility(8);
  }
  
  private void a(ReadInJoyPicWaterFallFragment.WaterFallPic paramWaterFallPic)
  {
    if (paramWaterFallPic.jdField_a_of_type_Int > 0)
    {
      i = (int)(this.e / paramWaterFallPic.jdField_a_of_type_Int * paramWaterFallPic.b);
      paramWaterFallPic.d = i;
      if ((i >= this.c) && (i <= this.d)) {
        paramWaterFallPic.c = i;
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ReadInJoyPicWaterFallFragment", 2, "WaterFallPic = " + paramWaterFallPic.toString());
        }
        return;
        if (i < this.c) {
          paramWaterFallPic.c = this.c;
        } else {
          paramWaterFallPic.c = this.d;
        }
      }
    }
    if (this.e != 0) {}
    for (int i = this.e;; i = this.jdField_a_of_type_Int)
    {
      paramWaterFallPic.c = i;
      break;
    }
  }
  
  private void a(BaseArticleInfo paramBaseArticleInfo)
  {
    if (paramBaseArticleInfo.waterFallPic != null) {
      return;
    }
    Object localObject = (galleryFeeds.Picture)paramBaseArticleInfo.mGalleryFeedsInfo.msg_custom_cover.get();
    ReadInJoyPicWaterFallFragment.WaterFallPic localWaterFallPic = new ReadInJoyPicWaterFallFragment.WaterFallPic();
    if (localObject != null)
    {
      int i = (int)((galleryFeeds.Picture)localObject).uint64_width.get();
      int j = (int)((galleryFeeds.Picture)localObject).uint64_height.get();
      localWaterFallPic.jdField_a_of_type_Int = i;
      localWaterFallPic.b = j;
    }
    for (localWaterFallPic.jdField_a_of_type_JavaNetURL = RIJPreParseData.a(((galleryFeeds.Picture)localObject).bytes_pic_url.get().toStringUtf8());; localWaterFallPic.jdField_a_of_type_JavaNetURL = RIJPreParseData.a((String)localObject))
    {
      paramBaseArticleInfo.waterFallPic = localWaterFallPic;
      a(paramBaseArticleInfo.waterFallPic);
      return;
      localObject = paramBaseArticleInfo.mFirstPagePicUrl;
      localWaterFallPic.jdField_a_of_type_Int = -1;
      localWaterFallPic.b = -1;
    }
  }
  
  public ReadInJoyPicWaterFallFragment.BaseViewHolder a(ViewGroup paramViewGroup, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 1: 
      paramViewGroup = LayoutInflater.from(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyPicWaterFallFragment.getActivity()).inflate(2131560367, null);
      paramViewGroup = new ReadInJoyPicWaterFallFragment.NormalViewHolder(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyPicWaterFallFragment, paramViewGroup);
      paramViewGroup.jdField_a_of_type_AndroidContentContext = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyPicWaterFallFragment.getActivity();
      return paramViewGroup;
    }
    paramViewGroup = LayoutInflater.from(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyPicWaterFallFragment.getActivity()).inflate(2131560368, null);
    paramViewGroup = new ReadInJoyPicWaterFallFragment.ActiveViewHolder(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyPicWaterFallFragment, paramViewGroup);
    paramViewGroup.jdField_a_of_type_AndroidContentContext = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyPicWaterFallFragment.getActivity();
    return paramViewGroup;
  }
  
  public void a(ReadInJoyPicWaterFallFragment.BaseViewHolder paramBaseViewHolder, int paramInt)
  {
    int j;
    int i;
    if (this.e == 0)
    {
      j = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyPicWaterFallFragment.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInjoyXRecyclerView.getWidth();
      if (j > 0) {
        break label290;
      }
      if (ScreenUtil.SCREEN_WIDTH <= 0) {
        break label259;
      }
      i = ScreenUtil.SCREEN_WIDTH;
      QLog.d("ReadInJoyPicWaterFallFragment", 1, "getRecyclerView width error, getScreenWidth : " + i + ", layoutWidth : " + j);
    }
    for (;;)
    {
      this.e = ((i - this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyPicWaterFallFragment.b * 2 - this.b * 2 * this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyPicWaterFallFragment.jdField_a_of_type_Int) / 2);
      this.c = ((int)(this.e * 0.52F));
      this.d = ((int)(this.e * 1.33F));
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyPicWaterFallFragment", 2, "itemWidth = " + this.e + ",minImgHeight = " + this.c + ",maxImgHeight = " + this.d);
      }
      switch (getItemViewType(paramInt))
      {
      }
      for (;;)
      {
        BaseArticleInfo localBaseArticleInfo = (BaseArticleInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyPicWaterFallFragment.a(localBaseArticleInfo, paramInt);
        EventCollector.getInstance().onRecyclerBindViewHolder(paramBaseViewHolder, paramInt, getItemId(paramInt));
        return;
        label259:
        i = 1080;
        break;
        a((ReadInJoyPicWaterFallFragment.NormalViewHolder)paramBaseViewHolder, paramInt);
        continue;
        a((ReadInJoyPicWaterFallFragment.ActiveViewHolder)paramBaseViewHolder, paramInt);
      }
      label290:
      i = j;
    }
  }
  
  public void a(List<BaseArticleInfo> paramList)
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaUtilList.addAll(paramList);
  }
  
  public int getItemCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public int getItemViewType(int paramInt)
  {
    paramInt = ((BaseArticleInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt)).mGalleryFeedsInfo.enum_article_style.get();
    if (paramInt == 4) {
      return 1;
    }
    if (paramInt == 5) {
      return 2;
    }
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyPicWaterFallFragment.WaterFallPicAdapter
 * JD-Core Version:    0.7.0.1
 */