package com.tencent.biz.pubaccount.readinjoy.view.fastweb.data;

import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import org.json.JSONObject;
import rpr;

public class TitleData
  extends ProteusItemData
{
  public String a;
  
  public TitleData()
  {
    super(0);
  }
  
  public void a()
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("style_ID", "ReadInjoy_article_title_cell");
      localJSONObject.put("id_attribute_text", this.jdField_a_of_type_JavaLangString);
      Object localObject1 = this.V;
      if (localObject1 != null) {
        try
        {
          localObject1 = new JSONObject(this.V);
          Iterator localIterator = ((JSONObject)localObject1).keys();
          if (localIterator == null) {
            break label131;
          }
          while (localIterator.hasNext())
          {
            String str = (String)localIterator.next();
            localJSONObject.put(str, ((JSONObject)localObject1).opt(str));
          }
          localObject2 = rpr.a("native_article", true);
        }
        catch (Exception localException1)
        {
          localException1.printStackTrace();
        }
      } else {
        if (localObject2 == null) {
          break label162;
        }
      }
      label131:
      label162:
      for (Object localObject2 = ((rpr)localObject2).getTemplateBean(localJSONObject);; localObject2 = null)
      {
        if (localObject2 != null)
        {
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusBeanTemplateBean = ((TemplateBean)localObject2);
          this.b = localJSONObject;
        }
        return;
        QLog.d("TitleData", 2, "merge result: " + localJSONObject.toString());
        break;
      }
      return;
    }
    catch (Exception localException2)
    {
      localException2.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.TitleData
 * JD-Core Version:    0.7.0.1
 */