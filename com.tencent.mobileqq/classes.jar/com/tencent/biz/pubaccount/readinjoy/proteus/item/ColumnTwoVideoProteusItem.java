package com.tencent.biz.pubaccount.readinjoy.proteus.item;

import android.os.Bundle;
import androidx.annotation.VisibleForTesting;
import com.google.gson.JsonArray;
import com.tencent.biz.ProtoUtils;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.decoupling.accesslayer.util.RIJQQAppInterfaceUtil;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.report.RIJFrameworkReportManager;
import com.tencent.biz.pubaccount.readinjoy.model.IReadInJoyModel;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.MultiVideoColumnInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SubVideoInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import cooperation.readinjoy.ReadInJoyHelper;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;
import tencent.im.oidb.cmd0xd4b.oidb_0xd4b.ReqBody;
import tencent.im.oidb.cmd0xd4b.oidb_0xd4b.SubscribeVideoColumnReq;

public class ColumnTwoVideoProteusItem
  implements ProteusItem
{
  private static final Set<Integer> a = new HashSet(Collections.singletonList(Integer.valueOf(4)));
  private static final Set<Integer> b = new HashSet(Collections.singletonList(Integer.valueOf(1)));
  private static final Set<Integer> c = new HashSet(Collections.singletonList(Integer.valueOf(6)));
  private static final Set<Integer> d = new HashSet(Arrays.asList(new Integer[] { Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(3), Integer.valueOf(4), Integer.valueOf(5) }));
  private static final Set<Integer> e = new HashSet(Arrays.asList(new Integer[] { Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(3), Integer.valueOf(4), Integer.valueOf(5), Integer.valueOf(7) }));
  private static final Set<Integer> f = new HashSet(Arrays.asList(new Integer[] { Integer.valueOf(3), Integer.valueOf(6), Integer.valueOf(7) }));
  private static final Set<Integer> g = new HashSet(Arrays.asList(new Integer[] { Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(3), Integer.valueOf(4), Integer.valueOf(5), Integer.valueOf(6), Integer.valueOf(7) }));
  private static final Set<Integer> h = new HashSet(Arrays.asList(new Integer[] { Integer.valueOf(1), Integer.valueOf(2) }));
  
  @VisibleForTesting
  static String a(long paramLong1, long paramLong2)
  {
    long l = paramLong2 - paramLong1;
    if ((l <= 0L) || (paramLong1 <= 0L) || (paramLong2 <= 0L)) {
      localObject = "";
    }
    String str;
    do
    {
      return localObject;
      str = ReadInJoyUtils.a(2131718410);
      if (l >= 60000L) {
        break;
      }
      localObject = str;
    } while (!str.isEmpty());
    Object localObject = ReadInJoyUtils.a(2131718411);
    if ((l < 3600000L) && (!((String)localObject).isEmpty())) {
      return String.format((String)localObject, new Object[] { Long.valueOf(l / 1000L / 60L) });
    }
    localObject = ReadInJoyUtils.a(2131718409);
    if ((l < 86400000L) && (!((String)localObject).isEmpty())) {
      return String.format((String)localObject, new Object[] { Long.valueOf(l / 1000L / 60L / 60L) });
    }
    localObject = ReadInJoyUtils.a(2131718408);
    if ((l >= 86400000L) && (!((String)localObject).isEmpty())) {
      return String.format((String)localObject, new Object[] { Long.valueOf(l / 1000L / 60L / 60L / 24L) });
    }
    return "";
  }
  
  private void a(@NotNull ArticleInfo paramArticleInfo)
  {
    MultiVideoColumnInfo localMultiVideoColumnInfo = paramArticleInfo.multiVideoColumnInfo;
    HashMap localHashMap = new HashMap();
    localHashMap.put("feeds_type", Integer.valueOf(1050));
    JsonArray localJsonArray = new JsonArray();
    Iterator localIterator = localMultiVideoColumnInfo.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      localJsonArray.add(((SubVideoInfo)localIterator.next()).jdField_a_of_type_JavaLangString);
    }
    localHashMap.put("rowkey", localJsonArray);
    localHashMap.put("column_id", Integer.valueOf(localMultiVideoColumnInfo.jdField_a_of_type_Int));
    localHashMap.put("column_card_bg_style", Integer.valueOf(localMultiVideoColumnInfo.e));
    if (localMultiVideoColumnInfo.jdField_a_of_type_Boolean) {}
    for (int i = 1;; i = 0)
    {
      localHashMap.put("subscribe_flag", Integer.valueOf(i));
      RIJFrameworkReportManager.a(paramArticleInfo, "0X8007625", "0X8007625", (int)paramArticleInfo.mChannelID, localHashMap);
      return;
    }
  }
  
  private void a(ArticleInfo paramArticleInfo, int paramInt)
  {
    QLog.d("ColumnTwoVideoProteusItem", 1, "requestSubscribeEvent, subscribeAction = " + paramInt);
    MultiVideoColumnInfo localMultiVideoColumnInfo = paramArticleInfo.multiVideoColumnInfo;
    oidb_0xd4b.ReqBody localReqBody = new oidb_0xd4b.ReqBody();
    localReqBody.msg_subscribe_video_column_req.uint32_video_column_id.set(localMultiVideoColumnInfo.jdField_a_of_type_Int);
    localReqBody.msg_subscribe_video_column_req.uint32_oper_type.set(paramInt);
    localReqBody.msg_subscribe_video_column_req.setHasFlag(true);
    Bundle localBundle = new Bundle();
    localBundle.putInt("subscribeAction", paramInt);
    localBundle.putString("columnIconUrl", localMultiVideoColumnInfo.jdField_b_of_type_JavaLangString);
    localBundle.putInt("columnId", localMultiVideoColumnInfo.jdField_a_of_type_Int);
    ProtoUtils.a(RIJQQAppInterfaceUtil.a(), new ColumnTwoVideoProteusItem.ColumnSubscriptionCallback(paramArticleInfo, paramInt), localReqBody.toByteArray(), "OidbSvc.0xd4b", 3403, 1, localBundle);
  }
  
  private void a(@NotNull ArticleInfo paramArticleInfo, boolean paramBoolean)
  {
    MultiVideoColumnInfo localMultiVideoColumnInfo = paramArticleInfo.multiVideoColumnInfo;
    String str;
    HashMap localHashMap;
    if (paramBoolean)
    {
      str = "0x800A7FB";
      localHashMap = new HashMap();
      if (paramArticleInfo.mChannelID != 0L) {
        break label126;
      }
    }
    label126:
    for (int i = 1;; i = 2)
    {
      localHashMap.put("subscribe_page", Integer.valueOf(i));
      localHashMap.put("feeds_type", Integer.valueOf(1050));
      localHashMap.put("column_id", Integer.valueOf(localMultiVideoColumnInfo.jdField_a_of_type_Int));
      localHashMap.put("column_card_bg_style", Integer.valueOf(localMultiVideoColumnInfo.e));
      RIJFrameworkReportManager.a(paramArticleInfo, str, str, (int)paramArticleInfo.mChannelID, localHashMap);
      return;
      str = "0x800A7D3";
      break;
    }
  }
  
  private void a(MultiVideoColumnInfo paramMultiVideoColumnInfo, JSONObject paramJSONObject)
  {
    paramJSONObject.put("column_cover_image_url", paramMultiVideoColumnInfo.jdField_b_of_type_JavaLangString);
    paramJSONObject.put("column_logo_image_url", paramMultiVideoColumnInfo.jdField_c_of_type_JavaLangString);
    a(paramJSONObject, paramMultiVideoColumnInfo);
    b(paramJSONObject, paramMultiVideoColumnInfo);
    a(paramJSONObject, paramMultiVideoColumnInfo.jdField_a_of_type_Boolean);
  }
  
  private void a(JSONObject paramJSONObject, @NotNull MultiVideoColumnInfo paramMultiVideoColumnInfo)
  {
    String str = paramMultiVideoColumnInfo.jdField_a_of_type_JavaLangString;
    if (str.isEmpty()) {
      QLog.e("ColumnTwoVideoProteusItem", 1, "column Name is empty.");
    }
    if ((a.contains(Integer.valueOf(paramMultiVideoColumnInfo.e))) && (!paramMultiVideoColumnInfo.g.isEmpty()))
    {
      paramJSONObject.put("column_info_name_text", paramMultiVideoColumnInfo.g + "·" + str);
      return;
    }
    paramJSONObject.put("column_info_name_text", str);
  }
  
  private void a(JSONObject paramJSONObject, @NotNull MultiVideoColumnInfo paramMultiVideoColumnInfo, SubVideoInfo paramSubVideoInfo1, SubVideoInfo paramSubVideoInfo2)
  {
    if (c.contains(Integer.valueOf(paramMultiVideoColumnInfo.e)))
    {
      if (paramSubVideoInfo1.jdField_b_of_type_JavaLangString.isEmpty()) {
        break label65;
      }
      paramJSONObject.put("column_show_video_left_title", paramSubVideoInfo1.jdField_b_of_type_JavaLangString);
    }
    while (!paramSubVideoInfo2.jdField_b_of_type_JavaLangString.isEmpty())
    {
      paramJSONObject.put("column_show_video_right_title", paramSubVideoInfo2.jdField_b_of_type_JavaLangString);
      return;
      label65:
      QLog.e("ColumnTwoVideoProteusItem", 1, "leftVideoInfo's title isEmpty.");
    }
    QLog.e("ColumnTwoVideoProteusItem", 1, "rightVideoInfo's title isEmpty.");
  }
  
  private void a(JSONObject paramJSONObject, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      paramJSONObject.put("subscription_background_color", "#FFFFFF");
      paramJSONObject.put("subscribe_title", ReadInJoyUtils.a(2131695266));
      paramJSONObject.put("subscription_title_color", "#737373");
      paramJSONObject.put("subscription_border_color", "#E6E6E6");
      paramJSONObject.put("subscription_border_width", "0.5");
      return;
    }
    paramJSONObject.put("subscription_background_color", "#00CAFC");
    paramJSONObject.put("subscribe_title", ReadInJoyUtils.a(2131695267));
    paramJSONObject.put("subscription_title_color", "#FFFFFF");
    paramJSONObject.remove("subscription_border_color");
    paramJSONObject.remove("subscription_border_width");
  }
  
  private void b(MultiVideoColumnInfo paramMultiVideoColumnInfo, JSONObject paramJSONObject)
  {
    SubVideoInfo localSubVideoInfo1 = (SubVideoInfo)paramMultiVideoColumnInfo.jdField_a_of_type_JavaUtilList.get(0);
    SubVideoInfo localSubVideoInfo2 = (SubVideoInfo)paramMultiVideoColumnInfo.jdField_a_of_type_JavaUtilList.get(1);
    paramJSONObject.put("column_left_item_cover_url", localSubVideoInfo1.jdField_c_of_type_JavaLangString);
    paramJSONObject.put("column_right_item_cover_url", localSubVideoInfo2.jdField_c_of_type_JavaLangString);
    a(paramJSONObject, paramMultiVideoColumnInfo, localSubVideoInfo1, localSubVideoInfo2);
    c(paramJSONObject, paramMultiVideoColumnInfo);
    b(paramJSONObject, paramMultiVideoColumnInfo, localSubVideoInfo1, localSubVideoInfo2);
  }
  
  private void b(JSONObject paramJSONObject, @NotNull MultiVideoColumnInfo paramMultiVideoColumnInfo)
  {
    String str = ReadInJoyUtils.a(2131718122);
    if ((b.contains(Integer.valueOf(paramMultiVideoColumnInfo.e))) && (paramMultiVideoColumnInfo.d != 0) && (!str.isEmpty())) {
      paramJSONObject.put("column_info_subscription_text", String.format(str, new Object[] { ReadInJoyHelper.b(paramMultiVideoColumnInfo.d) }));
    }
  }
  
  private void b(JSONObject paramJSONObject, @NotNull MultiVideoColumnInfo paramMultiVideoColumnInfo, SubVideoInfo paramSubVideoInfo1, SubVideoInfo paramSubVideoInfo2)
  {
    if (e.contains(Integer.valueOf(paramMultiVideoColumnInfo.e)))
    {
      if (paramSubVideoInfo1.jdField_b_of_type_Int == 0) {
        break label65;
      }
      paramJSONObject.put("column_card_play_left_time_text", ReadInJoyHelper.d(paramSubVideoInfo1.jdField_b_of_type_Int));
    }
    while (paramSubVideoInfo2.jdField_b_of_type_Int != 0)
    {
      paramJSONObject.put("column_card_play_right_time_text", ReadInJoyHelper.d(paramSubVideoInfo2.jdField_b_of_type_Int));
      return;
      label65:
      QLog.e("ColumnTwoVideoProteusItem", 1, "leftVideoInfo's duration == 0.");
    }
    QLog.e("ColumnTwoVideoProteusItem", 1, "rightVideoInfo's duration == 0.");
  }
  
  private void c(JSONObject paramJSONObject, @NotNull MultiVideoColumnInfo paramMultiVideoColumnInfo)
  {
    if (d.contains(Integer.valueOf(paramMultiVideoColumnInfo.e)))
    {
      paramJSONObject.put("column_card_play_left_icon_url", "rij_multi_video_column_play");
      paramJSONObject.put("column_card_play_right_icon_url", "rij_multi_video_column_play");
    }
  }
  
  private void d(JSONObject paramJSONObject, @NotNull MultiVideoColumnInfo paramMultiVideoColumnInfo)
  {
    if (f.contains(Integer.valueOf(paramMultiVideoColumnInfo.e)))
    {
      if ((!paramMultiVideoColumnInfo.h.isEmpty()) && (!paramMultiVideoColumnInfo.g.isEmpty()))
      {
        paramJSONObject.put("column_bottom_icon_view_visibility", "1");
        paramJSONObject.put("column_bottom_icon_url", paramMultiVideoColumnInfo.h);
        paramJSONObject.put("column_bottom_name", paramMultiVideoColumnInfo.g);
      }
    }
    else {
      return;
    }
    QLog.e("ColumnTwoVideoProteusItem", 1, "dataInfo's appIconUrl or appName is Empty.");
  }
  
  private void e(JSONObject paramJSONObject, @NotNull MultiVideoColumnInfo paramMultiVideoColumnInfo)
  {
    String str2 = "";
    String str3 = ReadInJoyUtils.a(2131718126);
    String str1 = str2;
    if (paramMultiVideoColumnInfo.jdField_c_of_type_Int > 0)
    {
      str1 = str2;
      if (!str3.isEmpty()) {
        str1 = String.format(str3, new Object[] { Integer.valueOf(paramMultiVideoColumnInfo.jdField_c_of_type_Int) });
      }
    }
    if ((g.contains(Integer.valueOf(paramMultiVideoColumnInfo.e))) && (!str1.isEmpty()))
    {
      if ((paramMultiVideoColumnInfo.jdField_a_of_type_Boolean) && (f.contains(Integer.valueOf(paramMultiVideoColumnInfo.e)))) {
        paramJSONObject.remove("column_bottom_video_count");
      }
    }
    else
    {
      str1 = ReadInJoyUtils.a(2131718127);
      if ((!paramMultiVideoColumnInfo.jdField_a_of_type_Boolean) || (paramMultiVideoColumnInfo.jdField_b_of_type_Int == 0) || (str1.isEmpty())) {
        break label178;
      }
      paramJSONObject.put("column_bottom_video_update_count", String.format(str1, new Object[] { Integer.valueOf(paramMultiVideoColumnInfo.jdField_b_of_type_Int) }));
    }
    label178:
    do
    {
      return;
      paramJSONObject.put("column_bottom_video_count", str1);
      break;
      paramMultiVideoColumnInfo = a(paramMultiVideoColumnInfo.jdField_a_of_type_Long, System.currentTimeMillis());
    } while (paramMultiVideoColumnInfo.isEmpty());
    paramJSONObject.put("column_bottom_video_update_time", paramMultiVideoColumnInfo);
  }
  
  private void f(JSONObject paramJSONObject, @NotNull MultiVideoColumnInfo paramMultiVideoColumnInfo)
  {
    JsonArray localJsonArray = new JsonArray();
    Iterator localIterator = paramMultiVideoColumnInfo.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      localJsonArray.add(((SubVideoInfo)localIterator.next()).jdField_a_of_type_JavaLangString);
    }
    paramJSONObject.put("rowkey", localJsonArray);
    paramJSONObject.put("column_id", paramMultiVideoColumnInfo.jdField_a_of_type_Int);
    paramJSONObject.put("column_card_bg_style", paramMultiVideoColumnInfo.e);
    if (paramMultiVideoColumnInfo.jdField_a_of_type_Boolean) {}
    for (int i = 1;; i = 0)
    {
      paramJSONObject.put("subscribe_flag", i);
      return;
    }
  }
  
  private void g(JSONObject paramJSONObject, @NotNull MultiVideoColumnInfo paramMultiVideoColumnInfo)
  {
    if (h.contains(Integer.valueOf(paramMultiVideoColumnInfo.e)))
    {
      paramJSONObject.put("column_top_view_visibility", "1");
      paramJSONObject.remove("column_middle_view_visibility");
    }
    while (c.contains(Integer.valueOf(paramMultiVideoColumnInfo.e)))
    {
      paramJSONObject.put("column_card_show_video_title_visibility", "1");
      paramJSONObject.remove("column_card_not_show_video_title_visibility");
      return;
      paramJSONObject.put("column_middle_view_visibility", "1");
      paramJSONObject.remove("column_top_view_visibility");
    }
    paramJSONObject.put("column_card_not_show_video_title_visibility", "1");
    paramJSONObject.remove("column_card_show_video_title_visibility");
  }
  
  public TemplateBean a(int paramInt, JSONObject paramJSONObject)
  {
    return null;
  }
  
  public JSONObject a(int paramInt, BaseArticleInfo paramBaseArticleInfo)
  {
    if ((paramBaseArticleInfo == null) || (paramBaseArticleInfo.columnStyle != 1)) {
      return new JSONObject();
    }
    paramBaseArticleInfo = paramBaseArticleInfo.multiVideoColumnInfo;
    if ((paramBaseArticleInfo == null) || (paramBaseArticleInfo.jdField_a_of_type_JavaUtilList == null) || (paramBaseArticleInfo.jdField_a_of_type_JavaUtilList.size() < 2)) {
      return new JSONObject();
    }
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("style_ID", "ReadInJoy_Column_card_cell");
    a(paramBaseArticleInfo, localJSONObject);
    b(paramBaseArticleInfo, localJSONObject);
    d(localJSONObject, paramBaseArticleInfo);
    e(localJSONObject, paramBaseArticleInfo);
    f(localJSONObject, paramBaseArticleInfo);
    g(localJSONObject, paramBaseArticleInfo);
    QLog.d("ColumnTwoVideoInfo", 1, localJSONObject.toString());
    return localJSONObject;
  }
  
  public void a(int paramInt1, Container paramContainer, IReadInJoyModel paramIReadInJoyModel, int paramInt2) {}
  
  public boolean a(int paramInt, Container paramContainer, IReadInJoyModel paramIReadInJoyModel, ViewBase paramViewBase)
  {
    if (paramViewBase == null) {}
    String str;
    MultiVideoColumnInfo localMultiVideoColumnInfo;
    do
    {
      return false;
      str = paramViewBase.getClickEvnet();
      paramIReadInJoyModel = paramIReadInJoyModel.a();
      localMultiVideoColumnInfo = paramIReadInJoyModel.multiVideoColumnInfo;
      paramContainer = paramContainer.getContext();
      if ("cmd_column_card_click".equals(str))
      {
        paramViewBase.setOnClickListener(new ColumnTwoVideoProteusItem.1(this, paramContainer, localMultiVideoColumnInfo, paramIReadInJoyModel));
        return true;
      }
      if ("cmd_column_left_item_click".equals(str))
      {
        paramViewBase.setOnClickListener(new ColumnTwoVideoProteusItem.2(this, paramContainer, localMultiVideoColumnInfo, paramIReadInJoyModel));
        return true;
      }
      if ("cmd_column_right_item_click".equals(str))
      {
        paramViewBase.setOnClickListener(new ColumnTwoVideoProteusItem.3(this, paramContainer, localMultiVideoColumnInfo, paramIReadInJoyModel));
        return true;
      }
    } while (!"cmd_subscription_click".equals(str));
    paramViewBase.setOnClickListener(new ColumnTwoVideoProteusItem.4(this, localMultiVideoColumnInfo, paramIReadInJoyModel));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.proteus.item.ColumnTwoVideoProteusItem
 * JD-Core Version:    0.7.0.1
 */