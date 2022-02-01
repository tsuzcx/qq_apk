package com.tencent.biz.pubaccount.readinjoy.proteus.item;

import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.report.RIJFrameworkReportManager;
import com.tencent.biz.pubaccount.readinjoy.model.IReadInJoyModel;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.polymeric.RvPolymericContainer;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.NewPolymericInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.NewPolymericInfo.PackArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.Layout.Params;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public class NewPolymericMultiVideoProteusItem
  implements ProteusItem
{
  private void a(ArticleInfo paramArticleInfo, int paramInt)
  {
    Object localObject = paramArticleInfo.mNewPolymericInfo;
    HashMap localHashMap = new HashMap();
    localObject = (NewPolymericInfo.PackArticleInfo)((NewPolymericInfo)localObject).jdField_a_of_type_JavaUtilList.get(paramInt);
    localHashMap.put("rowkey", ((NewPolymericInfo.PackArticleInfo)localObject).jdField_g_of_type_JavaLangString);
    if (!TextUtils.isEmpty(((NewPolymericInfo.PackArticleInfo)localObject).k)) {
      localHashMap.put("jump_report_info", ((NewPolymericInfo.PackArticleInfo)localObject).k);
    }
    RIJFrameworkReportManager.a(paramArticleInfo, "0X8007625", "0X8007625", (int)paramArticleInfo.mChannelID, localHashMap);
  }
  
  private void a(ArticleInfo paramArticleInfo, String paramString)
  {
    HashMap localHashMap = new HashMap();
    if (!TextUtils.isEmpty(paramArticleInfo.mReportCommonData)) {
      localHashMap.put("jump_report_info", paramString);
    }
    RIJFrameworkReportManager.a(paramArticleInfo, "0X8007625", "0X8007625", (int)paramArticleInfo.mChannelID, localHashMap);
  }
  
  public TemplateBean a(int paramInt, JSONObject paramJSONObject)
  {
    return null;
  }
  
  public JSONObject a(int paramInt, BaseArticleInfo paramBaseArticleInfo)
  {
    if ((paramBaseArticleInfo == null) || (paramBaseArticleInfo.mNewPolymericInfo == null)) {
      return new JSONObject();
    }
    JSONObject localJSONObject1 = new JSONObject();
    JSONArray localJSONArray = new JSONArray();
    NewPolymericInfo localNewPolymericInfo = paramBaseArticleInfo.mNewPolymericInfo;
    localJSONObject1.put("style_ID", "ReadInJoy_video_set_card");
    localJSONObject1.put("common_header_text", localNewPolymericInfo.jdField_b_of_type_JavaLangString);
    localJSONObject1.put("topic_header_big_icon_url", localNewPolymericInfo.jdField_a_of_type_JavaLangString);
    localJSONObject1.put("topic_header_small_icon_url", localNewPolymericInfo.e);
    localJSONObject1.put("topic_header_desc_text", localNewPolymericInfo.jdField_c_of_type_JavaLangString);
    String str2;
    String str1;
    label175:
    label177:
    NewPolymericInfo.PackArticleInfo localPackArticleInfo;
    switch (localNewPolymericInfo.jdField_b_of_type_Int)
    {
    default: 
      localJSONObject1.put("empty_header_visibility", "1");
      switch (localNewPolymericInfo.jdField_c_of_type_Int)
      {
      default: 
        str2 = "195";
        str1 = "148";
        paramInt = 0;
        if (paramInt >= localNewPolymericInfo.jdField_a_of_type_JavaUtilList.size()) {
          break label398;
        }
        localPackArticleInfo = (NewPolymericInfo.PackArticleInfo)localNewPolymericInfo.jdField_a_of_type_JavaUtilList.get(paramInt);
        if (localPackArticleInfo != null) {}
        break;
      }
      break;
    }
    for (;;)
    {
      paramInt += 1;
      break label177;
      localJSONObject1.put("common_header_visibility", "1");
      break;
      localJSONObject1.put("topic_header_visibility", "1");
      break;
      str2 = "260";
      str1 = "146";
      break label175;
      str2 = "315";
      str1 = "236";
      break label175;
      JSONObject localJSONObject2 = new JSONObject();
      localJSONObject2.put("style_ID", "ReadInJoy_video_set_card_collection_cell");
      localJSONObject2.put("videoWidth", str1);
      localJSONObject2.put("videoHeight", str2);
      localJSONObject2.put("video_cover_url", localPackArticleInfo.jdField_c_of_type_JavaLangString);
      localJSONObject2.put("video_title_text", localPackArticleInfo.jdField_a_of_type_JavaLangString);
      localJSONObject2.put("play_count_text", localPackArticleInfo.j);
      localJSONObject2.put("comment_count_text", localPackArticleInfo.jdField_g_of_type_Int + "评论");
      localJSONObject2.put("rowkey", localPackArticleInfo.jdField_g_of_type_JavaLangString);
      localJSONArray.put(paramInt, localJSONObject2);
    }
    label398:
    if (paramBaseArticleInfo.mNewPolymericInfo.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo == null) {
      localJSONObject1.put("canScroll", "0");
    }
    for (;;)
    {
      localJSONObject1.put("video_data", localJSONArray);
      localJSONObject1.put("card_jump_report_info", "");
      QLog.d("NewPolymericMultiVideoProteusItem", 1, localJSONObject1.toString());
      return localJSONObject1;
      localJSONObject1.put("canScroll", "1");
    }
  }
  
  public void a(int paramInt1, Container paramContainer, IReadInJoyModel paramIReadInJoyModel, int paramInt2)
  {
    ArticleInfo localArticleInfo = paramIReadInJoyModel.a();
    if (localArticleInfo == null) {}
    Object localObject;
    do
    {
      return;
      localObject = paramContainer.getVirtualView();
      RvPolymericContainer localRvPolymericContainer = (RvPolymericContainer)((ViewBase)localObject).findViewBaseByName("id_proteus_collection_view");
      localRvPolymericContainer.a(paramIReadInJoyModel);
      localRvPolymericContainer.a(new NewPolymericMultiVideoProteusItem.1(this, localArticleInfo, paramContainer));
      localRvPolymericContainer.a(new NewPolymericMultiVideoProteusItem.2(this, localArticleInfo, paramIReadInJoyModel));
      paramIReadInJoyModel = paramContainer.getLayoutParams();
      localObject = ((ViewBase)localObject).getComLayoutParams();
    } while ((paramIReadInJoyModel == null) || (localObject == null));
    paramIReadInJoyModel.width = ((Layout.Params)localObject).mLayoutWidth;
    paramIReadInJoyModel.height = ((Layout.Params)localObject).mLayoutHeight;
    paramContainer.setLayoutParams(paramIReadInJoyModel);
  }
  
  public boolean a(int paramInt, Container paramContainer, IReadInJoyModel paramIReadInJoyModel, ViewBase paramViewBase)
  {
    if (paramViewBase == null) {}
    String str;
    do
    {
      do
      {
        return false;
        str = paramViewBase.getClickEvnet();
      } while (TextUtils.isEmpty(str));
      paramIReadInJoyModel = paramIReadInJoyModel.a();
    } while (!"cmd_video_set_card_click".equals(str));
    paramViewBase.setOnClickListener(new NewPolymericMultiVideoProteusItem.3(this, paramIReadInJoyModel, paramContainer));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.proteus.item.NewPolymericMultiVideoProteusItem
 * JD-Core Version:    0.7.0.1
 */