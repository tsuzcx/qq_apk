package com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.dislike;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.decoupling.accesslayer.data.RIJDataManager;
import com.tencent.biz.pubaccount.readinjoy.decoupling.accesslayer.data.RIJDataManager.Builder;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util.RIJFeedsType;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.DislikeInfo;
import com.tencent.biz.pubaccount.readinjoy.video.viewholder.ViewHolder;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter;
import com.tencent.biz.pubaccount.readinjoy.view.widget.ReadInJoyFeedbackPopupWindow;
import com.tencent.widget.KandianNegativeWindow;
import com.tencent.widget.KandianNegativeWindowForAd;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

public class RIJDislikeManager
{
  private ReadInJoyFeedbackPopupWindow jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyFeedbackPopupWindow;
  private KandianNegativeWindow jdField_a_of_type_ComTencentWidgetKandianNegativeWindow;
  private KandianNegativeWindowForAd jdField_a_of_type_ComTencentWidgetKandianNegativeWindowForAd;
  
  public static String a(ArrayList<DislikeInfo> paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.isEmpty())) {
      return "";
    }
    localJSONArray = new JSONArray();
    try
    {
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        DislikeInfo localDislikeInfo = (DislikeInfo)paramArrayList.next();
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("type", localDislikeInfo.jdField_a_of_type_Int);
        localJSONObject.put("name", localDislikeInfo.jdField_a_of_type_JavaLangString);
        localJSONObject.put("tagid", localDislikeInfo.jdField_a_of_type_Long);
        localJSONArray.put(localJSONObject);
      }
      return localJSONArray.toString();
    }
    catch (Exception paramArrayList)
    {
      paramArrayList.printStackTrace();
    }
  }
  
  public ReadInJoyFeedbackPopupWindow a(Activity paramActivity, ReadInJoyBaseAdapter paramReadInJoyBaseAdapter)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyFeedbackPopupWindow == null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyFeedbackPopupWindow = new ReadInJoyFeedbackPopupWindow(paramActivity, paramReadInJoyBaseAdapter);
    }
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyFeedbackPopupWindow;
  }
  
  public KandianNegativeWindow a(Context paramContext)
  {
    if (this.jdField_a_of_type_ComTencentWidgetKandianNegativeWindow == null) {
      this.jdField_a_of_type_ComTencentWidgetKandianNegativeWindow = new KandianNegativeWindow(paramContext);
    }
    return this.jdField_a_of_type_ComTencentWidgetKandianNegativeWindow;
  }
  
  public KandianNegativeWindowForAd a(Context paramContext)
  {
    if (this.jdField_a_of_type_ComTencentWidgetKandianNegativeWindowForAd == null) {
      this.jdField_a_of_type_ComTencentWidgetKandianNegativeWindowForAd = new KandianNegativeWindowForAd(paramContext);
    }
    return this.jdField_a_of_type_ComTencentWidgetKandianNegativeWindowForAd;
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentWidgetKandianNegativeWindow = null;
    this.jdField_a_of_type_ComTencentWidgetKandianNegativeWindowForAd = null;
  }
  
  public void a(View paramView, ViewHolder paramViewHolder, BaseArticleInfo paramBaseArticleInfo, RIJDataManager paramRIJDataManager)
  {
    int i = paramViewHolder.jdField_a_of_type_Int;
    paramViewHolder = new RIJDislikeManager.1(this, i, paramRIJDataManager, paramViewHolder, paramBaseArticleInfo);
    if (AdvertisementInfo.isAdvertisementInfo(paramBaseArticleInfo))
    {
      if ((this.jdField_a_of_type_ComTencentWidgetKandianNegativeWindow != null) && (this.jdField_a_of_type_ComTencentWidgetKandianNegativeWindow.isShowing())) {
        this.jdField_a_of_type_ComTencentWidgetKandianNegativeWindow.dismiss();
      }
      this.jdField_a_of_type_ComTencentWidgetKandianNegativeWindowForAd.a(i, paramRIJDataManager.a().b(), RIJFeedsType.a(paramBaseArticleInfo), ((AdvertisementInfo)paramBaseArticleInfo).mAdDislikeInfos);
      this.jdField_a_of_type_ComTencentWidgetKandianNegativeWindowForAd.a(paramView, paramViewHolder);
      this.jdField_a_of_type_ComTencentWidgetKandianNegativeWindowForAd.a(new RIJDislikeManager.2(this, paramRIJDataManager, paramBaseArticleInfo));
      this.jdField_a_of_type_ComTencentWidgetKandianNegativeWindowForAd.setOnDismissListener(new RIJDislikeManager.3(this, paramRIJDataManager));
      return;
    }
    if ((this.jdField_a_of_type_ComTencentWidgetKandianNegativeWindowForAd != null) && (this.jdField_a_of_type_ComTencentWidgetKandianNegativeWindowForAd.isShowing())) {
      this.jdField_a_of_type_ComTencentWidgetKandianNegativeWindowForAd.dismiss();
    }
    this.jdField_a_of_type_ComTencentWidgetKandianNegativeWindow.a(i, paramRIJDataManager.a().b(), RIJFeedsType.a(paramBaseArticleInfo), paramBaseArticleInfo.mDislikeInfos, paramBaseArticleInfo.innerUniqueID);
    this.jdField_a_of_type_ComTencentWidgetKandianNegativeWindow.a(paramView, paramViewHolder);
    this.jdField_a_of_type_ComTencentWidgetKandianNegativeWindow.setOnDismissListener(new RIJDislikeManager.4(this, paramRIJDataManager));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.dislike.RIJDislikeManager
 * JD-Core Version:    0.7.0.1
 */