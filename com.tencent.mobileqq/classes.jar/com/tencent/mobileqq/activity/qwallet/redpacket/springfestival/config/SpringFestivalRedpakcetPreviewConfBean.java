package com.tencent.mobileqq.activity.qwallet.redpacket.springfestival.config;

import ahfn;
import bbjw;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public class SpringFestivalRedpakcetPreviewConfBean
{
  public int a;
  public String a;
  public ArrayList<SpringFestivalRedpakcetPreviewConfBean.PreviewInfo> a;
  public int b;
  public ArrayList<SpringFestivalRedpakcetPreviewConfBean.BreathLight> b;
  public ArrayList<SpringFestivalRedpacketConfBean.TimeInfo> c = new ArrayList();
  
  public SpringFestivalRedpakcetPreviewConfBean()
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
  }
  
  public static SpringFestivalRedpakcetPreviewConfBean a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("springHb_SpringFestivalRedpakcetPreviewConfBean", 2, "SpringFestivalRedpakcetPreviewConfBean parse: " + paramString);
    }
    if (bbjw.a(paramString)) {
      return null;
    }
    SpringFestivalRedpakcetPreviewConfBean localSpringFestivalRedpakcetPreviewConfBean = new SpringFestivalRedpakcetPreviewConfBean();
    paramString = new JSONObject(paramString);
    localSpringFestivalRedpakcetPreviewConfBean.jdField_a_of_type_Int = paramString.optInt("use_stagger_peak");
    localSpringFestivalRedpakcetPreviewConfBean.jdField_a_of_type_JavaLangString = paramString.optString("breath_light_resource_url");
    localSpringFestivalRedpakcetPreviewConfBean.jdField_a_of_type_JavaUtilArrayList = a(paramString);
    localSpringFestivalRedpakcetPreviewConfBean.jdField_b_of_type_JavaUtilArrayList = c(paramString);
    localSpringFestivalRedpakcetPreviewConfBean.c = b(paramString);
    localSpringFestivalRedpakcetPreviewConfBean.jdField_b_of_type_Int = paramString.optInt("forbid_refresh_interval", 300);
    if (localSpringFestivalRedpakcetPreviewConfBean.jdField_b_of_type_Int > 3600) {
      localSpringFestivalRedpakcetPreviewConfBean.jdField_b_of_type_Int = 3600;
    }
    for (;;)
    {
      localSpringFestivalRedpakcetPreviewConfBean.jdField_b_of_type_Int *= 1000;
      return localSpringFestivalRedpakcetPreviewConfBean;
      if (localSpringFestivalRedpakcetPreviewConfBean.jdField_b_of_type_Int < 0) {
        localSpringFestivalRedpakcetPreviewConfBean.jdField_b_of_type_Int = 300;
      }
    }
  }
  
  private static ArrayList<SpringFestivalRedpakcetPreviewConfBean.PreviewInfo> a(JSONObject paramJSONObject)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramJSONObject == null) {
      return localArrayList;
    }
    paramJSONObject = paramJSONObject.optJSONArray("activity_preview");
    if ((paramJSONObject == null) || (paramJSONObject.length() == 0)) {
      return localArrayList;
    }
    int i = 0;
    while (i < paramJSONObject.length())
    {
      JSONObject localJSONObject = paramJSONObject.optJSONObject(i);
      if (localJSONObject != null)
      {
        SpringFestivalRedpakcetPreviewConfBean.PreviewInfo localPreviewInfo = new SpringFestivalRedpakcetPreviewConfBean.PreviewInfo();
        SpringFestivalRedpacketConfBean.TimeInfo localTimeInfo = new SpringFestivalRedpacketConfBean.TimeInfo();
        localTimeInfo.beginTime = ahfn.a(localJSONObject.optString("start_time"));
        localTimeInfo.endTime = ahfn.a(localJSONObject.optString("end_time"));
        localPreviewInfo.prewTimeInfo = localTimeInfo;
        localPreviewInfo.activityId = localJSONObject.optString("activity_id");
        localPreviewInfo.resourceUrl = localJSONObject.optString("resource_url");
        localPreviewInfo.actionUrl = localJSONObject.optString("action_url");
        localPreviewInfo.matchRule = localJSONObject.optString("match_rule");
        localArrayList.add(localPreviewInfo);
      }
      i += 1;
    }
    return localArrayList;
  }
  
  private static ArrayList<SpringFestivalRedpacketConfBean.TimeInfo> b(JSONObject paramJSONObject)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramJSONObject == null) {
      return localArrayList;
    }
    paramJSONObject = paramJSONObject.optJSONArray("breath_light_switch_show");
    if ((paramJSONObject == null) || (paramJSONObject.length() == 0)) {
      return localArrayList;
    }
    int i = 0;
    while (i < paramJSONObject.length())
    {
      JSONObject localJSONObject = paramJSONObject.optJSONObject(i);
      if (localJSONObject != null)
      {
        SpringFestivalRedpacketConfBean.TimeInfo localTimeInfo = new SpringFestivalRedpacketConfBean.TimeInfo();
        localTimeInfo.beginTime = ahfn.a(localJSONObject.optString("start_time"));
        localTimeInfo.endTime = ahfn.a(localJSONObject.optString("end_time"));
        localArrayList.add(localTimeInfo);
      }
      i += 1;
    }
    return localArrayList;
  }
  
  private static ArrayList<SpringFestivalRedpakcetPreviewConfBean.BreathLight> c(JSONObject paramJSONObject)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramJSONObject == null) {
      return localArrayList;
    }
    paramJSONObject = paramJSONObject.optJSONArray("breath_light");
    if ((paramJSONObject == null) || (paramJSONObject.length() == 0)) {
      return localArrayList;
    }
    int i = 0;
    while (i < paramJSONObject.length())
    {
      JSONObject localJSONObject = paramJSONObject.optJSONObject(i);
      if (localJSONObject != null)
      {
        SpringFestivalRedpakcetPreviewConfBean.BreathLight localBreathLight = new SpringFestivalRedpakcetPreviewConfBean.BreathLight();
        SpringFestivalRedpacketConfBean.TimeInfo localTimeInfo = new SpringFestivalRedpacketConfBean.TimeInfo();
        localTimeInfo.beginTime = ahfn.a(localJSONObject.optString("start_time"));
        localTimeInfo.endTime = ahfn.a(localJSONObject.optString("end_time"));
        localBreathLight.breathTimeInfo = localTimeInfo;
        localBreathLight.type = localJSONObject.optInt("type");
        localArrayList.add(localBreathLight);
      }
      i += 1;
    }
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.redpacket.springfestival.config.SpringFestivalRedpakcetPreviewConfBean
 * JD-Core Version:    0.7.0.1
 */