package com.tencent.biz.pubaccount.readinjoy.common;

import android.text.TextUtils;
import com.tencent.biz.common.util.NetworkUtil;
import com.tencent.biz.pubaccount.readinjoy.config.handlers.DailyModeConfigHandler;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util.RIJFeedsType;
import com.tencent.biz.pubaccount.readinjoy.srtUtils.ReadInJoySrtHandler;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import cooperation.readinjoy.ReadInJoyHelper;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.oidb.articlesummary.articlesummary.SRTUniversalID;
import tencent.im.oidb.cmd0x64e.oidb_cmd0x64e.SRTClickInfo;
import tencent.im.oidb.cmd0x64e.oidb_cmd0x64e.SRTRule;
import tencent.im.oidb.cmd0x80a.oidb_cmd0x80a.AttributeList;

public class ReadInJoySrtUtils
{
  private static ReadInJoySrtUtils jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommonReadInJoySrtUtils;
  private int jdField_a_of_type_Int = 0;
  private String jdField_a_of_type_JavaLangString;
  private List<oidb_cmd0x64e.SRTRule> jdField_a_of_type_JavaUtilList = new ArrayList();
  private oidb_cmd0x64e.SRTClickInfo jdField_a_of_type_TencentImOidbCmd0x64eOidb_cmd0x64e$SRTClickInfo;
  private String jdField_b_of_type_JavaLangString;
  private List<ReadInJoySrtUtils.SRTInfo> jdField_b_of_type_JavaUtilList = new ArrayList();
  
  private ReadInJoySrtUtils()
  {
    b();
  }
  
  private ReadInJoySrtUtils.SRTInfo a(oidb_cmd0x64e.SRTRule paramSRTRule)
  {
    if (paramSRTRule == null) {
      return null;
    }
    ReadInJoySrtUtils.SRTInfo localSRTInfo = new ReadInJoySrtUtils.SRTInfo(this);
    if (paramSRTRule.uint32_click_number.has()) {
      localSRTInfo.jdField_b_of_type_JavaUtilList = paramSRTRule.uint32_click_number.get();
    }
    if (paramSRTRule.uint32_feeds_type.has()) {
      localSRTInfo.jdField_a_of_type_JavaUtilList = paramSRTRule.uint32_feeds_type.get();
    }
    if (paramSRTRule.uint32_network_type.has()) {
      localSRTInfo.jdField_a_of_type_Int = paramSRTRule.uint32_network_type.get();
    }
    if (paramSRTRule.bytes_app_package_name.has()) {
      localSRTInfo.jdField_a_of_type_JavaLangString = paramSRTRule.bytes_app_package_name.get().toStringUtf8();
    }
    if (paramSRTRule.bytes_schema.has()) {
      localSRTInfo.c = paramSRTRule.bytes_schema.get().toStringUtf8();
    }
    if (paramSRTRule.bytes_h5.has()) {
      localSRTInfo.jdField_b_of_type_JavaLangString = paramSRTRule.bytes_h5.get().toStringUtf8();
    }
    QLog.d("ReadInJoySrtUtils", 1, "convertSRTPbToSRTClassclickNumList = " + localSRTInfo.jdField_b_of_type_JavaUtilList + " feedsTypeList= " + localSRTInfo.jdField_a_of_type_JavaUtilList + " netWorkType= " + localSRTInfo.jdField_a_of_type_Int + " packageName = " + localSRTInfo.jdField_a_of_type_JavaLangString + " schemaUrl= " + localSRTInfo.c + " h5Url= " + localSRTInfo.jdField_b_of_type_JavaLangString);
    return localSRTInfo;
  }
  
  public static ReadInJoySrtUtils a()
  {
    try
    {
      if (jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommonReadInJoySrtUtils == null) {
        jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommonReadInJoySrtUtils = new ReadInJoySrtUtils();
      }
      ReadInJoySrtUtils localReadInJoySrtUtils = jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommonReadInJoySrtUtils;
      return localReadInJoySrtUtils;
    }
    finally {}
  }
  
  private String a(ReadInJoySrtUtils.SRTInfo paramSRTInfo, BaseArticleInfo paramBaseArticleInfo, TemplateBean paramTemplateBean, ViewBase paramViewBase)
  {
    if (paramBaseArticleInfo == null) {
      return "";
    }
    if ((TextUtils.isEmpty(paramSRTInfo.jdField_b_of_type_JavaLangString)) || (TextUtils.isEmpty(paramSRTInfo.c)) || (TextUtils.isEmpty(paramSRTInfo.jdField_a_of_type_JavaLangString))) {
      return "";
    }
    String str3 = paramSRTInfo.jdField_a_of_type_JavaLangString;
    String str1 = paramSRTInfo.jdField_b_of_type_JavaLangString;
    String str2 = paramSRTInfo.c;
    paramTemplateBean = a(paramBaseArticleInfo, str3, paramTemplateBean, paramViewBase);
    QLog.d("ReadInJoySrtUtils", 1, "appPackageName = " + str3 + "defaultURL = " + str1 + "appSchema = " + str2 + " rowKey = " + paramTemplateBean);
    if ((TextUtils.isEmpty(paramTemplateBean)) && ((str1.contains("${rowkey}")) || (str2.contains("${rowkey}")))) {
      return "";
    }
    paramBaseArticleInfo = str2;
    paramSRTInfo = str1;
    if (!TextUtils.isEmpty(paramTemplateBean))
    {
      paramSRTInfo = str1.replace("${rowkey}", paramTemplateBean).replace("${uin}", ReadInJoyUtils.a());
      paramBaseArticleInfo = str2.replace("${rowkey}", paramTemplateBean).replace("${uin}", ReadInJoyUtils.a());
    }
    paramTemplateBean = new StringBuilder();
    try
    {
      paramTemplateBean.append("mqqapi://readinjoy/open?src_type=internal&target=4").append("&defaultURL=").append(URLEncoder.encode(paramSRTInfo, "utf-8")).append("&appSchema=").append(URLEncoder.encode(paramBaseArticleInfo, "utf-8")).append("&appPackageName=").append(str3).append("&readinjoyNotDecodeUrl=1").append("&version=1").append("&isCancelJump=0");
      QLog.d("ReadInJoySrtUtils", 1, paramTemplateBean.toString());
      return paramTemplateBean.toString();
    }
    catch (UnsupportedEncodingException paramSRTInfo)
    {
      for (;;)
      {
        paramSRTInfo.printStackTrace();
      }
    }
  }
  
  private String a(BaseArticleInfo paramBaseArticleInfo, String paramString, TemplateBean paramTemplateBean, ViewBase paramViewBase)
  {
    if ((paramBaseArticleInfo == null) || (TextUtils.isEmpty(paramString)) || (paramBaseArticleInfo.srtUniversalID == null))
    {
      QLog.d("ReadInJoySrtUtils", 1, "getRowKey error, some object is null");
      if (paramBaseArticleInfo != null)
      {
        paramString = new StringBuilder().append("srtuniversalIdList is null = ");
        if (paramBaseArticleInfo.srtUniversalID != null) {
          break label71;
        }
      }
      label71:
      for (boolean bool = true;; bool = false)
      {
        QLog.d("ReadInJoySrtUtils", 1, bool);
        return "";
      }
    }
    paramBaseArticleInfo = a(paramBaseArticleInfo.srtUniversalID, paramTemplateBean, paramViewBase);
    if (paramBaseArticleInfo == null)
    {
      QLog.d("ReadInJoySrtUtils", 1, "srtUniversalID is null ");
      return "";
    }
    if ((paramString.equals("com.tencent.reading")) && (paramBaseArticleInfo.bytes_kb_id.has()))
    {
      if (paramBaseArticleInfo.bytes_kb_id.get() != null) {
        return paramBaseArticleInfo.bytes_kb_id.get().toStringUtf8();
      }
      return "";
    }
    if ((paramString.equals("com.tencent.rijvideo")) && (paramBaseArticleInfo.bytes_ks_id.has()))
    {
      if (paramBaseArticleInfo.bytes_ks_id.get() != null) {
        return paramBaseArticleInfo.bytes_ks_id.get().toStringUtf8();
      }
      return "";
    }
    if ((paramString.equals("com.tencent.weishi")) && (paramBaseArticleInfo.bytes_ws_id.has()))
    {
      if (paramBaseArticleInfo.bytes_ws_id.get() != null) {
        return paramBaseArticleInfo.bytes_ws_id.get().toStringUtf8();
      }
      return "";
    }
    QLog.d("ReadInJoySrtUtils", 1, "getRowKey : no appPackageName hit ");
    return "";
  }
  
  private articlesummary.SRTUniversalID a(List<articlesummary.SRTUniversalID> paramList, TemplateBean paramTemplateBean, ViewBase paramViewBase)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      return null;
    }
    if ((paramTemplateBean == null) || (paramViewBase == null)) {
      return (articlesummary.SRTUniversalID)paramList.get(0);
    }
    paramTemplateBean = paramTemplateBean.getDataAttribute(paramViewBase.getViewId()).get("srt_universal_id_index");
    if ((paramTemplateBean instanceof String)) {}
    for (;;)
    {
      try
      {
        i = Integer.parseInt((String)paramTemplateBean);
        if ((paramList.size() <= i) || (i < 0)) {
          break;
        }
        return (articlesummary.SRTUniversalID)paramList.get(i);
      }
      catch (Exception paramTemplateBean)
      {
        QLog.e("ReadInJoySrtUtils", 1, "handlePositionAndGetSRT parse int error");
      }
      int i = 0;
    }
    return null;
  }
  
  private oidb_cmd0x64e.SRTRule a(ReadInJoySrtUtils.SRTInfo paramSRTInfo)
  {
    if (paramSRTInfo == null) {
      return null;
    }
    oidb_cmd0x64e.SRTRule localSRTRule = new oidb_cmd0x64e.SRTRule();
    if (paramSRTInfo.c != null) {
      localSRTRule.bytes_schema.set(ByteStringMicro.copyFromUtf8(paramSRTInfo.c));
    }
    if (paramSRTInfo.jdField_b_of_type_JavaLangString != null) {
      localSRTRule.bytes_h5.set(ByteStringMicro.copyFromUtf8(paramSRTInfo.jdField_b_of_type_JavaLangString));
    }
    if (paramSRTInfo.jdField_a_of_type_JavaLangString != null) {
      localSRTRule.bytes_app_package_name.set(ByteStringMicro.copyFromUtf8(paramSRTInfo.jdField_a_of_type_JavaLangString));
    }
    if (paramSRTInfo.jdField_b_of_type_JavaUtilList != null) {
      localSRTRule.uint32_click_number.set(paramSRTInfo.jdField_b_of_type_JavaUtilList);
    }
    if (paramSRTInfo.jdField_a_of_type_JavaUtilList != null) {
      localSRTRule.uint32_feeds_type.set(paramSRTInfo.jdField_a_of_type_JavaUtilList);
    }
    localSRTRule.uint32_network_type.set(paramSRTInfo.jdField_a_of_type_Int);
    return localSRTRule;
  }
  
  private void a(ReadInJoySrtUtils.SRTInfo paramSRTInfo, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((this.jdField_a_of_type_JavaUtilList == null) || (paramInt3 >= this.jdField_a_of_type_JavaUtilList.size())) {}
    do
    {
      return;
      QLog.d("ReadInJoySrtUtils", 1, "convertSRTClickInfo feedsType:" + paramInt1 + " clickTimes: " + paramInt2 + " position" + paramInt3);
      this.jdField_a_of_type_TencentImOidbCmd0x64eOidb_cmd0x64e$SRTClickInfo = new oidb_cmd0x64e.SRTClickInfo();
      paramSRTInfo = a(paramSRTInfo);
      if (paramSRTInfo != null)
      {
        ArrayList localArrayList1 = new ArrayList();
        localArrayList1.add(Integer.valueOf(paramInt2));
        ArrayList localArrayList2 = new ArrayList();
        localArrayList2.add(Integer.valueOf(paramInt1));
        paramSRTInfo.uint32_click_number.set(localArrayList1);
        paramSRTInfo.uint32_feeds_type.set(localArrayList2);
      }
      this.jdField_a_of_type_TencentImOidbCmd0x64eOidb_cmd0x64e$SRTClickInfo.msg_srt_rule_list.set(this.jdField_a_of_type_JavaUtilList);
      this.jdField_a_of_type_TencentImOidbCmd0x64eOidb_cmd0x64e$SRTClickInfo.uint32_hit_srt_rule_index.set(paramInt3);
    } while (paramSRTInfo == null);
    this.jdField_a_of_type_TencentImOidbCmd0x64eOidb_cmd0x64e$SRTClickInfo.msg_hit_srt_rule.set(paramSRTInfo);
  }
  
  private boolean a(ReadInJoySrtUtils.SRTInfo paramSRTInfo, int paramInt)
  {
    if (paramSRTInfo == null) {}
    int i;
    int j;
    do
    {
      do
      {
        return false;
      } while ((paramSRTInfo.jdField_b_of_type_JavaUtilList == null) || (paramSRTInfo.jdField_a_of_type_JavaUtilList == null));
      i = paramSRTInfo.jdField_a_of_type_Int;
      j = NetworkUtil.a(BaseActivity.sTopActivity);
    } while ((j == 0) || ((i == 1) && (j != 1)) || ((i == 2) && (j == 1)) || (!paramSRTInfo.jdField_a_of_type_JavaUtilList.contains(Integer.valueOf(paramInt))));
    return paramSRTInfo.jdField_b_of_type_JavaUtilList.contains(Integer.valueOf(this.jdField_a_of_type_Int));
  }
  
  private void b() {}
  
  private void c()
  {
    try
    {
      Object localObject = (String)ReadInJoyHelper.a("readinjoy_srt_click_time_key", "");
      String str1;
      int i;
      if (TextUtils.isEmpty((CharSequence)localObject))
      {
        localObject = new JSONObject();
        String str2 = ((JSONObject)localObject).optString("time", "");
        int j = ((JSONObject)localObject).optInt("clickTimes" + this.jdField_b_of_type_JavaLangString, 0);
        str1 = ReadInJoySrtHandler.a();
        i = j;
        if (j == 0) {
          i = this.jdField_a_of_type_Int;
        }
        if (str2.equals(str1)) {
          break label180;
        }
        localObject = new JSONObject();
        i = 0;
      }
      for (;;)
      {
        i += 1;
        this.jdField_a_of_type_Int = i;
        ((JSONObject)localObject).put("time", str1);
        ((JSONObject)localObject).put("clickTimes" + this.jdField_b_of_type_JavaLangString, i);
        ReadInJoyHelper.a("readinjoy_srt_click_time_key", ((JSONObject)localObject).toString());
        return;
        localObject = new JSONObject((String)localObject);
        break;
      }
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
      return;
    }
  }
  
  public String a()
  {
    if (this.jdField_a_of_type_JavaLangString == null) {
      QLog.d("ReadInJoySrtUtils", 1, "getJumpSchema schemaCache is null");
    }
    String str = this.jdField_a_of_type_JavaLangString;
    this.jdField_a_of_type_JavaLangString = null;
    return str;
  }
  
  public oidb_cmd0x64e.SRTClickInfo a()
  {
    if (this.jdField_a_of_type_TencentImOidbCmd0x64eOidb_cmd0x64e$SRTClickInfo == null)
    {
      QLog.d("ReadInJoySrtUtils", 1, "getNoDifferenceDiversionInfo cache is null");
      return null;
    }
    QLog.d("ReadInJoySrtUtils", 1, "getNoDifferenceDiversionInfo");
    oidb_cmd0x64e.SRTClickInfo localSRTClickInfo = this.jdField_a_of_type_TencentImOidbCmd0x64eOidb_cmd0x64e$SRTClickInfo;
    this.jdField_a_of_type_TencentImOidbCmd0x64eOidb_cmd0x64e$SRTClickInfo = null;
    return localSRTClickInfo;
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_TencentImOidbCmd0x64eOidb_cmd0x64e$SRTClickInfo = null;
    this.jdField_a_of_type_JavaLangString = null;
    this.jdField_b_of_type_JavaUtilList = null;
    this.jdField_a_of_type_Int = 0;
    QLog.d("ReadInJoySrtUtils", 1, "clearData");
  }
  
  public void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    this.jdField_b_of_type_JavaLangString = paramString;
    ArrayList localArrayList = new ArrayList();
    oidb_cmd0x80a.AttributeList localAttributeList = new oidb_cmd0x80a.AttributeList();
    localAttributeList.att_id.set(1);
    localAttributeList.att_name.set("channel_id");
    localAttributeList.att_value.set(paramString);
    localArrayList.add(localAttributeList);
    ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).reportPushEffectEvent(202, localArrayList);
    QLog.d("ReadInJoySrtUtils", 1, "start requestSRTRulesattris size = " + localArrayList.size() + "event_id = " + 202 + "id: " + paramString);
  }
  
  public void a(List<oidb_cmd0x64e.SRTRule> paramList)
  {
    if (paramList != null)
    {
      this.jdField_a_of_type_JavaUtilList = paramList;
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        ReadInJoySrtUtils.SRTInfo localSRTInfo = a((oidb_cmd0x64e.SRTRule)localIterator.next());
        if (localSRTInfo != null) {
          localArrayList.add(localSRTInfo);
        }
      }
      this.jdField_b_of_type_JavaUtilList = localArrayList;
      QLog.d("ReadInJoySrtUtils", 1, "handle0x80aRespInfo  size = " + paramList.size());
    }
  }
  
  public boolean a()
  {
    return (this.jdField_b_of_type_JavaUtilList != null) && (this.jdField_b_of_type_JavaUtilList.size() != 0);
  }
  
  public boolean a(BaseArticleInfo paramBaseArticleInfo, TemplateBean paramTemplateBean, ViewBase paramViewBase)
  {
    if ((this.jdField_b_of_type_JavaUtilList == null) || (this.jdField_b_of_type_JavaUtilList.size() == 0) || (paramBaseArticleInfo == null) || ((paramBaseArticleInfo.mChannelID != 0L) && (!DailyModeConfigHandler.c((int)paramBaseArticleInfo.mChannelID)))) {
      QLog.d("ReadInJoySrtUtils", 1, "judgeIsNeedNoDifferenceDiversion srtInfos is null");
    }
    label255:
    for (;;)
    {
      return false;
      c();
      int i = 0;
      for (;;)
      {
        if (i >= this.jdField_b_of_type_JavaUtilList.size()) {
          break label255;
        }
        ReadInJoySrtUtils.SRTInfo localSRTInfo = (ReadInJoySrtUtils.SRTInfo)this.jdField_b_of_type_JavaUtilList.get(i);
        int j = RIJFeedsType.a(paramBaseArticleInfo);
        QLog.d("ReadInJoySrtUtils", 1, "startJudge feedsType:" + j + " clickTimes: " + this.jdField_a_of_type_Int + " position" + i);
        if (a(localSRTInfo, j))
        {
          paramBaseArticleInfo = a(localSRTInfo, paramBaseArticleInfo, paramTemplateBean, paramViewBase);
          if (TextUtils.isEmpty(paramBaseArticleInfo)) {
            break;
          }
          this.jdField_a_of_type_JavaLangString = paramBaseArticleInfo;
          a(localSRTInfo, j, this.jdField_a_of_type_Int, i);
          QLog.d("ReadInJoySrtUtils", 1, "hitSrtRules feedsType:" + j + " clickTimes: " + this.jdField_a_of_type_Int + " position" + i);
          return true;
        }
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.common.ReadInJoySrtUtils
 * JD-Core Version:    0.7.0.1
 */