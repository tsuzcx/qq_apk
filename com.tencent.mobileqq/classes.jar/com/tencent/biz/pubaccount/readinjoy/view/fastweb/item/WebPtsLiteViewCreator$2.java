package com.tencent.biz.pubaccount.readinjoy.view.fastweb.item;

import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util.RIJJumpUtils;
import com.tencent.biz.pubaccount.readinjoy.pts.lite.PTSLiteEventTypeHandler;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.BaseData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.ProteusRecommendItemData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.ReportUtil;
import com.tencent.pts.core.PTSComposer;
import com.tencent.pts.core.lite.DefaultPTSLiteEventListener;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

class WebPtsLiteViewCreator$2
  extends DefaultPTSLiteEventListener
{
  WebPtsLiteViewCreator$2(WebPtsLiteViewCreator paramWebPtsLiteViewCreator) {}
  
  public void onTapEventTriggered(String paramString, HashMap<String, String> paramHashMap, View paramView, PTSComposer paramPTSComposer)
  {
    if (QLog.isColorLevel())
    {
      paramView = new StringBuilder();
      paramView.append("identifier = ").append(paramString).append("\n");
      if (paramHashMap != null)
      {
        Iterator localIterator = paramHashMap.entrySet().iterator();
        while (localIterator.hasNext())
        {
          Map.Entry localEntry = (Map.Entry)localIterator.next();
          paramView.append("dataSet [ ").append((String)localEntry.getKey()).append(" ] = ").append((String)localEntry.getValue()).append("\n");
        }
      }
      QLog.i("WebPtsLiteViewCreator", 2, "[onTapEventTriggered], " + paramView.toString());
    }
    PTSLiteEventTypeHandler.a.a(paramPTSComposer, paramHashMap);
    if ((paramHashMap == null) || (TextUtils.isEmpty(paramString))) {}
    do
    {
      do
      {
        return;
        paramString = (BaseData)WebPtsLiteViewCreator.a(this.a).get(paramString);
      } while (!(paramString instanceof ProteusRecommendItemData));
      paramString = (ProteusRecommendItemData)paramString;
      ReportUtil.a("id_native_recommend_small_container", paramString, null);
    } while (TextUtils.isEmpty((CharSequence)paramHashMap.get("jumpUrl")));
    paramString = RIJJumpUtils.a((String)paramHashMap.get("jumpUrl"), paramString.c);
    RIJJumpUtils.a(WebPtsLiteViewCreator.a(this.a), paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.fastweb.item.WebPtsLiteViewCreator.2
 * JD-Core Version:    0.7.0.1
 */