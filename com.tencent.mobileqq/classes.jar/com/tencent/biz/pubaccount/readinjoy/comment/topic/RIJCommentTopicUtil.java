package com.tencent.biz.pubaccount.readinjoy.comment.topic;

import android.text.Spannable;
import android.text.Spanned;
import android.text.TextUtils;
import android.util.SparseIntArray;
import android.view.View;
import androidx.annotation.NonNull;
import com.google.gson.Gson;
import com.tencent.biz.pubaccount.VideoReporter;
import com.tencent.biz.pubaccount.api.IPublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.comment.CommentReportR5Builder;
import com.tencent.biz.pubaccount.readinjoy.comment.ReadInJoyCommentUtils;
import com.tencent.biz.pubaccount.readinjoy.comment.data.BaseCommentData;
import com.tencent.biz.pubaccount.readinjoy.comment.data.BaseCommentData.CommentRptData;
import com.tencent.biz.pubaccount.readinjoy.comment.helper.StringUtil;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util.RIJJumpUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.text.EmotcationConstants;
import com.tencent.mobileqq.utils.Base64Util;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.readinjoy.ReadInJoyHelper;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class RIJCommentTopicUtil
{
  private static final int[] a = { 10, 32, 35, 20 };
  
  private static int a(CharSequence paramCharSequence, int paramInt1, int paramInt2)
  {
    int i = Character.codePointAt(paramCharSequence, paramInt1);
    if (b(i)) {}
    while (a(i)) {
      return paramInt1;
    }
    if (a(paramInt2, paramInt1)) {
      return paramInt1 + 1;
    }
    if (a(paramCharSequence, paramInt1)) {
      return paramCharSequence.length();
    }
    return -1;
  }
  
  @NonNull
  private static List<BaseCommentData.CommentRptData> a(JSONObject paramJSONObject)
  {
    List localList = Collections.emptyList();
    Object localObject = localList;
    if (paramJSONObject != null)
    {
      paramJSONObject = paramJSONObject.optString("commentTopicInfo");
      localObject = localList;
      if (!TextUtils.isEmpty(paramJSONObject))
      {
        localObject = new RIJCommentTopicUtil.1().getType();
        localObject = (List)new Gson().fromJson(paramJSONObject, (Type)localObject);
        b((Iterable)localObject);
      }
    }
    return localObject;
  }
  
  public static JSONArray a(Collection<BaseCommentData.CommentRptData> paramCollection)
  {
    localJSONArray = new JSONArray();
    if ((paramCollection != null) && (!paramCollection.isEmpty())) {
      try
      {
        paramCollection = paramCollection.iterator();
        while (paramCollection.hasNext())
        {
          BaseCommentData.CommentRptData localCommentRptData = (BaseCommentData.CommentRptData)paramCollection.next();
          JSONObject localJSONObject = new JSONObject();
          localJSONObject.put("data_type", localCommentRptData.jdField_a_of_type_Int);
          a(localCommentRptData, localJSONObject);
          localJSONArray.put(localJSONObject);
        }
        return localJSONArray;
      }
      catch (JSONException paramCollection)
      {
        QLog.w("RIJCommentTopicUtil", 4, "", paramCollection);
      }
    }
  }
  
  public static void a(@NonNull View paramView, @NonNull String paramString)
  {
    paramString = paramString.substring(0, paramString.length() - "#comment_topic".length());
    QLog.d("RIJCommentTopicUtil", 1, "onTopicClick: clickedUrl=" + paramString);
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    paramView = paramView.getTag(2131376605);
    if (!(paramView instanceof RIJCommentTopicUtil.PTSCommentModel))
    {
      QLog.d("RIJCommentTopicUtil", 1, "onTopicClick: tag is" + paramView);
      return;
    }
    a((RIJCommentTopicUtil.PTSCommentModel)paramView, paramString);
  }
  
  private static void a(BaseCommentData.CommentRptData paramCommentRptData, JSONObject paramJSONObject)
  {
    switch (paramCommentRptData.jdField_a_of_type_Int)
    {
    case 1: 
    case 2: 
    default: 
      return;
    case 0: 
      b(paramCommentRptData, paramJSONObject);
      return;
    }
    c(paramCommentRptData, paramJSONObject);
  }
  
  public static void a(BaseCommentData paramBaseCommentData, JSONObject paramJSONObject, String paramString, boolean paramBoolean)
  {
    JSONArray localJSONArray = new JSONArray();
    if (paramBoolean) {
      a(localJSONArray, " : ");
    }
    String str = paramBaseCommentData.commentContent;
    if (!TextUtils.isEmpty(str)) {
      a(localJSONArray, str);
    }
    if ((paramBaseCommentData.commentRptDataList != null) && (!paramBaseCommentData.commentRptDataList.isEmpty())) {
      a(localJSONArray, paramBaseCommentData.commentRptDataList);
    }
    try
    {
      paramJSONObject.put(paramString, localJSONArray);
      return;
    }
    catch (JSONException paramBaseCommentData)
    {
      QLog.w("RIJCommentTopicUtil", 4, "", paramBaseCommentData);
    }
  }
  
  private static void a(RIJCommentTopicUtil.PTSCommentModel paramPTSCommentModel, BaseCommentData.CommentRptData paramCommentRptData)
  {
    ArticleInfo localArticleInfo = paramPTSCommentModel.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
    paramPTSCommentModel = new CommentReportR5Builder(localArticleInfo, paramPTSCommentModel.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData).a().c();
    try
    {
      JSONObject localJSONObject = paramPTSCommentModel.a();
      localJSONObject.put("subject_id", paramCommentRptData.c);
      localJSONObject.put("version", VideoReporter.jdField_a_of_type_JavaLangString);
      localJSONObject.put("os", 1);
      paramPTSCommentModel = paramPTSCommentModel.a();
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, ReadInJoyCommentUtils.a(localArticleInfo), "0X800B9E1", "0X800B9E1", 0, 0, String.valueOf(localArticleInfo.mArticleID), String.valueOf(localArticleInfo.mAlgorithmID), localArticleInfo.innerUniqueID, paramPTSCommentModel, false);
      return;
    }
    catch (JSONException paramCommentRptData)
    {
      for (;;)
      {
        paramCommentRptData.printStackTrace();
      }
    }
  }
  
  private static void a(RIJCommentTopicUtil.PTSCommentModel paramPTSCommentModel, String paramString)
  {
    Iterator localIterator = paramPTSCommentModel.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData.commentRptDataList.iterator();
    while (localIterator.hasNext())
    {
      BaseCommentData.CommentRptData localCommentRptData = (BaseCommentData.CommentRptData)localIterator.next();
      if ((localCommentRptData.jdField_a_of_type_Int == 3) && (TextUtils.equals(paramString, localCommentRptData.b)))
      {
        RIJJumpUtils.a(BaseApplication.getContext(), paramString);
        a(paramPTSCommentModel, localCommentRptData);
      }
    }
  }
  
  private static void a(Iterable<BaseCommentData.CommentRptData> paramIterable)
  {
    paramIterable = paramIterable.iterator();
    while (paramIterable.hasNext())
    {
      BaseCommentData.CommentRptData localCommentRptData = (BaseCommentData.CommentRptData)paramIterable.next();
      localCommentRptData.jdField_a_of_type_JavaLangString = new String(Base64Util.encode(ReadInJoyCommentUtils.a(localCommentRptData.jdField_a_of_type_JavaLangString, false).getBytes(), 0));
    }
  }
  
  private static void a(Collection<BaseCommentData.CommentRptData> paramCollection, int paramInt, String paramString)
  {
    BaseCommentData.CommentRptData localCommentRptData = new BaseCommentData.CommentRptData();
    localCommentRptData.jdField_a_of_type_Int = paramInt;
    localCommentRptData.jdField_a_of_type_JavaLangString = paramString;
    paramCollection.add(localCommentRptData);
  }
  
  private static void a(List<BaseCommentData.CommentRptData> paramList)
  {
    BaseCommentData.CommentRptData localCommentRptData = (BaseCommentData.CommentRptData)paramList.get(0);
    localCommentRptData.jdField_a_of_type_JavaLangString = StringUtil.a(localCommentRptData.jdField_a_of_type_JavaLangString);
    paramList = (BaseCommentData.CommentRptData)paramList.get(paramList.size() - 1);
    paramList.jdField_a_of_type_JavaLangString = StringUtil.b(paramList.jdField_a_of_type_JavaLangString);
  }
  
  private static void a(JSONArray paramJSONArray)
  {
    try
    {
      JSONObject localJSONObject1 = new JSONObject();
      localJSONObject1.put("name", "img");
      JSONObject localJSONObject2 = new JSONObject();
      localJSONObject2.put("style", "width:16px; height:16px;");
      localJSONObject2.put("src", "rij_comment_topic_icon");
      localJSONObject1.put("attrs", localJSONObject2);
      paramJSONArray.put(localJSONObject1);
      return;
    }
    catch (JSONException paramJSONArray)
    {
      QLog.w("RIJCommentTopicUtil", 4, "", paramJSONArray);
    }
  }
  
  private static void a(JSONArray paramJSONArray, BaseCommentData.CommentRptData paramCommentRptData)
  {
    if ((paramCommentRptData.jdField_a_of_type_JavaLangString == null) || (paramCommentRptData.jdField_a_of_type_JavaLangString.length() < 2)) {
      return;
    }
    if (!a())
    {
      a(paramJSONArray, paramCommentRptData.jdField_a_of_type_JavaLangString);
      return;
    }
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("name", "a");
      Object localObject = new JSONObject();
      ((JSONObject)localObject).put("href", paramCommentRptData.b + "#comment_topic");
      ((JSONObject)localObject).put("style", "color: #40A0FF;");
      localJSONObject.put("attrs", localObject);
      localObject = new JSONArray();
      a((JSONArray)localObject);
      a((JSONArray)localObject, paramCommentRptData.jdField_a_of_type_JavaLangString.substring(1), "#40A0FF");
      localJSONObject.put("children", localObject);
      paramJSONArray.put(localJSONObject);
      return;
    }
    catch (JSONException paramJSONArray)
    {
      QLog.w("RIJCommentTopicUtil", 4, "", paramJSONArray);
    }
  }
  
  private static void a(JSONArray paramJSONArray, Iterable<BaseCommentData.CommentRptData> paramIterable)
  {
    paramIterable = paramIterable.iterator();
    while (paramIterable.hasNext())
    {
      BaseCommentData.CommentRptData localCommentRptData = (BaseCommentData.CommentRptData)paramIterable.next();
      switch (localCommentRptData.jdField_a_of_type_Int)
      {
      case 1: 
      case 2: 
      default: 
        break;
      case 0: 
        a(paramJSONArray, localCommentRptData.jdField_a_of_type_JavaLangString);
        break;
      case 3: 
        a(paramJSONArray, localCommentRptData);
      }
    }
  }
  
  private static void a(JSONArray paramJSONArray, String paramString)
  {
    a(paramJSONArray, paramString, "#000000");
  }
  
  private static void a(JSONArray paramJSONArray, String paramString1, String paramString2)
  {
    try
    {
      JSONObject localJSONObject1 = new JSONObject();
      localJSONObject1.put("name", "text");
      JSONObject localJSONObject2 = new JSONObject();
      localJSONObject2.put("class", "div_class");
      localJSONObject2.put("style", "color: " + paramString2 + ';');
      localJSONObject1.put("attrs", localJSONObject2);
      paramString2 = new JSONArray();
      localJSONObject2 = new JSONObject();
      localJSONObject2.put("type", "text");
      localJSONObject2.put("text", paramString1);
      paramString2.put(localJSONObject2);
      localJSONObject1.put("children", paramString2);
      paramJSONArray.put(localJSONObject1);
      return;
    }
    catch (JSONException paramJSONArray)
    {
      QLog.w("RIJCommentTopicUtil", 4, "", paramJSONArray);
    }
  }
  
  public static void a(JSONObject paramJSONObject, Spanned paramSpanned)
  {
    int i = paramSpanned.length();
    RIJCommentTopicSpanForPublisher[] arrayOfRIJCommentTopicSpanForPublisher = (RIJCommentTopicSpanForPublisher[])paramSpanned.getSpans(0, i, RIJCommentTopicSpanForPublisher.class);
    if ((arrayOfRIJCommentTopicSpanForPublisher == null) || (arrayOfRIJCommentTopicSpanForPublisher.length <= 0)) {
      return;
    }
    a(paramJSONObject, paramSpanned, arrayOfRIJCommentTopicSpanForPublisher, i);
  }
  
  private static void a(JSONObject paramJSONObject, Spanned paramSpanned, RIJCommentTopicSpanForPublisher[] paramArrayOfRIJCommentTopicSpanForPublisher, int paramInt)
  {
    String str = paramSpanned.toString();
    LinkedList localLinkedList = new LinkedList();
    int i = 0;
    int k;
    for (int j = 0; i < paramArrayOfRIJCommentTopicSpanForPublisher.length; j = k)
    {
      RIJCommentTopicSpanForPublisher localRIJCommentTopicSpanForPublisher = paramArrayOfRIJCommentTopicSpanForPublisher[i];
      int m = paramSpanned.getSpanStart(localRIJCommentTopicSpanForPublisher);
      k = paramSpanned.getSpanEnd(localRIJCommentTopicSpanForPublisher);
      if (m > j) {
        a(localLinkedList, 0, str.substring(j, m));
      }
      a(localLinkedList, 3, str.substring(m, k));
      i += 1;
    }
    if (j < paramInt) {
      a(localLinkedList, 0, str.substring(j, paramInt));
    }
    a(paramJSONObject, localLinkedList);
  }
  
  public static void a(JSONObject paramJSONObject, BaseCommentData paramBaseCommentData)
  {
    List localList = a(paramJSONObject);
    if (localList.isEmpty())
    {
      paramBaseCommentData.commentContent = new String(Base64Util.decode(paramJSONObject.optString("comment"), 0));
      return;
    }
    paramJSONObject = localList.iterator();
    while (paramJSONObject.hasNext())
    {
      BaseCommentData.CommentRptData localCommentRptData = (BaseCommentData.CommentRptData)paramJSONObject.next();
      if (!TextUtils.isEmpty(localCommentRptData.jdField_a_of_type_JavaLangString)) {
        localCommentRptData.jdField_a_of_type_JavaLangString = new String(Base64Util.decode(localCommentRptData.jdField_a_of_type_JavaLangString, 0));
      }
    }
    paramBaseCommentData.commentRptDataList = localList;
    paramBaseCommentData.commentContent = "";
  }
  
  private static void a(JSONObject paramJSONObject, List<BaseCommentData.CommentRptData> paramList)
  {
    a(paramList);
    a(paramList);
    paramList = new Gson().toJson(paramList);
    try
    {
      paramJSONObject.put("commentTopicInfo", paramList);
      return;
    }
    catch (JSONException paramJSONObject)
    {
      paramJSONObject.printStackTrace();
    }
  }
  
  public static boolean a()
  {
    boolean bool = ReadInJoyHelper.g();
    QLog.d("RIJCommentTopicUtil", 1, "isCommentTopicDisplaySwitchOn: topicSwitchOn=" + bool);
    return bool;
  }
  
  private static boolean a(int paramInt)
  {
    return EmotcationConstants.EMOJI_MAP.get(paramInt, -1) >= 0;
  }
  
  private static boolean a(int paramInt1, int paramInt2)
  {
    return paramInt2 - paramInt1 >= 12;
  }
  
  public static boolean a(Spannable paramSpannable)
  {
    int i = 0;
    int m = paramSpannable.length();
    int j = -1;
    boolean bool2;
    for (boolean bool1 = false; i < m; bool1 = bool2)
    {
      int n = paramSpannable.charAt(i);
      int k = j;
      bool2 = bool1;
      if (j >= 0)
      {
        int i1 = a(paramSpannable, i, j);
        k = j;
        bool2 = bool1;
        if (i1 > 0)
        {
          bool2 = a(paramSpannable, j, i1) | bool1;
          k = -1;
        }
      }
      j = k;
      if (n == 35) {
        j = i;
      }
      i += 1;
    }
    return bool1;
  }
  
  private static boolean a(Spannable paramSpannable, int paramInt1, int paramInt2)
  {
    if (paramInt2 - paramInt1 > 1)
    {
      paramSpannable.setSpan(new RIJCommentTopicSpanForPublisher(), paramInt1, paramInt2, 33);
      return true;
    }
    return false;
  }
  
  public static boolean a(@NotNull BaseCommentData paramBaseCommentData)
  {
    if (!a()) {
      return false;
    }
    paramBaseCommentData = paramBaseCommentData.commentRptDataList;
    if (paramBaseCommentData != null)
    {
      paramBaseCommentData = paramBaseCommentData.iterator();
      while (paramBaseCommentData.hasNext()) {
        if (((BaseCommentData.CommentRptData)paramBaseCommentData.next()).jdField_a_of_type_Int == 3) {
          return true;
        }
      }
    }
    return false;
  }
  
  private static boolean a(CharSequence paramCharSequence, int paramInt)
  {
    return paramInt == paramCharSequence.length() - 1;
  }
  
  private static void b(BaseCommentData.CommentRptData paramCommentRptData, JSONObject paramJSONObject)
  {
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("content", paramCommentRptData.jdField_a_of_type_JavaLangString);
    paramJSONObject.put("text_data", localJSONObject);
  }
  
  private static void b(Iterable<BaseCommentData.CommentRptData> paramIterable) {}
  
  private static boolean b(int paramInt)
  {
    boolean bool2 = false;
    int[] arrayOfInt = a;
    int j = arrayOfInt.length;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < j)
      {
        if (arrayOfInt[i] == paramInt) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  private static void c(BaseCommentData.CommentRptData paramCommentRptData, JSONObject paramJSONObject)
  {
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("content", paramCommentRptData.jdField_a_of_type_JavaLangString);
    localJSONObject.put("url", paramCommentRptData.b);
    localJSONObject.put("topic_id", paramCommentRptData.c);
    paramJSONObject.put("herf_data", localJSONObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.comment.topic.RIJCommentTopicUtil
 * JD-Core Version:    0.7.0.1
 */