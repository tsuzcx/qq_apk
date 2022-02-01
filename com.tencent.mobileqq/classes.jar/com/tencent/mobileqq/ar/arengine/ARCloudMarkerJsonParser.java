package com.tencent.mobileqq.ar.arengine;

import android.annotation.TargetApi;
import android.hardware.SensorManager;
import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.mobileqq.ar.ARPromotion.ARTransferDoorConfigInfo;
import com.tencent.mobileqq.ar.ARRenderModel.SensorTrackManager;
import com.tencent.mobileqq.ar.aidl.ArCloudConfigInfo;
import com.tencent.mobileqq.ar.model.ARRelationShip;
import com.tencent.mobileqq.ar.model.ArAwardInfo;
import com.tencent.mobileqq.ar.model.ArFeatureInfo;
import com.tencent.mobileqq.ar.model.ArLBSActivity;
import com.tencent.mobileqq.ar.model.ArModelResource;
import com.tencent.mobileqq.ar.model.ArVideoResourceInfo;
import com.tencent.mobileqq.ar.model.ArWebInfo;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ARCloudMarkerJsonParser
{
  @TargetApi(9)
  public static ArCloudConfigInfo a(String paramString)
  {
    if (paramString != null) {
      if (paramString.isEmpty()) {
        return null;
      }
    }
    for (;;)
    {
      try
      {
        localObject1 = new JSONObject(paramString);
        paramString = new ArCloudConfigInfo();
        if (((JSONObject)localObject1).has("BusinessId")) {
          paramString.jdField_a_of_type_Int = Integer.parseInt(((JSONObject)localObject1).getString("BusinessId"));
        }
        if (((JSONObject)localObject1).has("SDKVersion")) {
          paramString.jdField_a_of_type_JavaLangString = ((JSONObject)localObject1).getString("SDKVersion");
        }
        if (((JSONObject)localObject1).has("CloseCache")) {
          paramString.jdField_b_of_type_Int = ((JSONObject)localObject1).getInt("CloseCache");
        }
        if (((JSONObject)localObject1).has("Type")) {
          paramString.jdField_d_of_type_Int = ((JSONObject)localObject1).getInt("Type");
        }
        Object localObject3;
        Object localObject2;
        if (((JSONObject)localObject1).has("TrackMode"))
        {
          paramString.jdField_c_of_type_Int = ((JSONObject)localObject1).getInt("TrackMode");
          if (paramString.jdField_c_of_type_Int == 4) {
            paramString.jdField_c_of_type_Int = 1;
          }
          if (paramString.jdField_c_of_type_Int == 1)
          {
            localObject3 = (SensorManager)BaseApplication.getContext().getSystemService("sensor");
            if (!SensorTrackManager.a()) {
              break label1968;
            }
            i = 15;
            localObject2 = ((SensorManager)localObject3).getSensorList(i);
            localObject3 = ((SensorManager)localObject3).getDefaultSensor(4);
            if ((((List)localObject2).size() > 0) && (localObject3 != null) && (!Build.MODEL.equalsIgnoreCase("GT-I9500")))
            {
              paramString.jdField_c_of_type_Int = 1;
            }
            else
            {
              paramString.jdField_c_of_type_Int = 2;
              QLog.i("AREngine_MarkerJsonParser", 1, "no support sensor or GT-I9500. make trackmode 1 to 2");
              localObject2 = new HashMap();
              ((HashMap)localObject2).put("ar_model", Build.MODEL);
              ((HashMap)localObject2).put("ar_type", "1");
              ((HashMap)localObject2).put("ar_reason", "1");
              StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance("", "AndroidARException", true, 0L, 0L, (HashMap)localObject2, "", true);
            }
          }
          if (paramString.jdField_d_of_type_Int == 8) {
            paramString.jdField_c_of_type_Int = 2;
          }
        }
        if (((JSONObject)localObject1).has("PicId")) {
          paramString.jdField_b_of_type_JavaLangString = ((JSONObject)localObject1).getString("PicId");
        }
        if (((JSONObject)localObject1).has("LotterySet")) {
          paramString.e = ((JSONObject)localObject1).getInt("LotterySet");
        }
        bool = ((JSONObject)localObject1).has("Award");
        i = 0;
        if (bool)
        {
          localObject2 = ((JSONObject)localObject1).getJSONObject("Award");
          localObject3 = new ArAwardInfo();
          if (((JSONObject)localObject2).has("AwardDistance")) {
            ((ArAwardInfo)localObject3).jdField_a_of_type_Int = ((JSONObject)localObject1).getInt("AwardDistance");
          }
          if (((JSONObject)localObject2).has("BusinessBanner")) {
            ((ArAwardInfo)localObject3).jdField_a_of_type_JavaLangString = ((JSONObject)localObject1).getString("BusinessBanner");
          }
          if (((JSONObject)localObject2).has("BusinessLogo")) {
            ((ArAwardInfo)localObject3).jdField_b_of_type_JavaLangString = ((JSONObject)localObject1).getString("BusinessLogo");
          }
          if (((JSONObject)localObject2).has("BusinessName")) {
            ((ArAwardInfo)localObject3).f = ((JSONObject)localObject1).getString("BusinessName");
          }
          if (((JSONObject)localObject2).has("BusinessWishing")) {
            ((ArAwardInfo)localObject3).jdField_d_of_type_JavaLangString = ((JSONObject)localObject1).getString("BusinessWishing");
          }
          if (((JSONObject)localObject2).has("NotPlayModel")) {
            if (((JSONObject)localObject1).getInt("NotPlayModel") == 1) {
              ((ArAwardInfo)localObject3).jdField_b_of_type_Int = 0;
            } else {
              ((ArAwardInfo)localObject3).jdField_b_of_type_Int = 1;
            }
          }
          paramString.jdField_a_of_type_ComTencentMobileqqArModelArAwardInfo = ((ArAwardInfo)localObject3);
        }
        if (((JSONObject)localObject1).has("Feature"))
        {
          localObject2 = ((JSONObject)localObject1).getJSONObject("Feature");
          localObject3 = new ArFeatureInfo();
          if (((JSONObject)localObject2).has("FeatureMD5")) {
            ((ArFeatureInfo)localObject3).jdField_a_of_type_JavaLangString = ((JSONObject)localObject2).getString("FeatureMD5");
          }
          if (((JSONObject)localObject2).has("FeatureSize")) {
            ((ArFeatureInfo)localObject3).jdField_a_of_type_Long = ((JSONObject)localObject2).getLong("FeatureSize");
          }
          if (((JSONObject)localObject2).has("FeatureUrl")) {
            ((ArFeatureInfo)localObject3).jdField_b_of_type_JavaLangString = ((JSONObject)localObject2).getString("FeatureUrl");
          }
          paramString.jdField_a_of_type_ComTencentMobileqqArModelArFeatureInfo = ((ArFeatureInfo)localObject3);
        }
        if (((JSONObject)localObject1).has("ModelResource"))
        {
          localObject2 = ((JSONObject)localObject1).getJSONObject("ModelResource");
          localObject3 = new ArModelResource();
          if (((JSONObject)localObject2).has("ModelResourceSize")) {
            ((ArModelResource)localObject3).jdField_a_of_type_Long = ((JSONObject)localObject2).getLong("ModelResourceSize");
          }
          if (((JSONObject)localObject2).has("ModelResourceMD5")) {
            ((ArModelResource)localObject3).jdField_a_of_type_JavaLangString = ((JSONObject)localObject2).getString("ModelResourceMD5");
          }
          if (((JSONObject)localObject2).has("ModelResourceUrl")) {
            ((ArModelResource)localObject3).jdField_b_of_type_JavaLangString = ((JSONObject)localObject2).getString("ModelResourceUrl");
          }
          if (((JSONObject)localObject2).has("ModelResourceBgMusic")) {
            ((ArModelResource)localObject3).jdField_c_of_type_JavaLangString = ((JSONObject)localObject2).getString("ModelResourceBgMusic");
          }
          if (((JSONObject)localObject2).has("ModelConfigFile")) {
            ((ArModelResource)localObject3).jdField_d_of_type_JavaLangString = ((JSONObject)localObject2).getString("ModelConfigFile");
          }
          if (((JSONObject)localObject2).has("ModelRepeatTimes")) {
            ((ArModelResource)localObject3).jdField_a_of_type_Int = ((JSONObject)localObject2).getInt("ModelRepeatTimes");
          }
          if (((JSONObject)localObject2).has("ModelLayout")) {
            ((ArModelResource)localObject3).e = ((JSONObject)localObject2).getString("ModelLayout");
          }
          paramString.jdField_a_of_type_ComTencentMobileqqArModelArModelResource = ((ArModelResource)localObject3);
        }
        if (((JSONObject)localObject1).has("Web"))
        {
          localObject2 = ((JSONObject)localObject1).getJSONObject("Web");
          localObject3 = new ArWebInfo();
          if (((JSONObject)localObject2).has("IsUrlAutoJump"))
          {
            if (((JSONObject)localObject2).getInt("IsUrlAutoJump") != 1) {
              break label1974;
            }
            bool = true;
            ((ArWebInfo)localObject3).jdField_a_of_type_Boolean = bool;
          }
          if (((JSONObject)localObject2).has("IsUrlTransparent"))
          {
            if (((JSONObject)localObject2).getInt("IsUrlTransparent") != 1) {
              break label1979;
            }
            bool = true;
            ((ArWebInfo)localObject3).jdField_b_of_type_Boolean = bool;
          }
          if (((JSONObject)localObject2).has("WebJumpUrl")) {
            ((ArWebInfo)localObject3).jdField_a_of_type_JavaLangString = ((JSONObject)localObject2).getString("WebJumpUrl");
          }
          if (((JSONObject)localObject2).has("HtmlOfflineBid")) {
            ((ArWebInfo)localObject3).jdField_b_of_type_JavaLangString = ((JSONObject)localObject2).getString("HtmlOfflineBid");
          }
          if ((Build.VERSION.SDK_INT < 16) && (((ArWebInfo)localObject3).jdField_b_of_type_Boolean))
          {
            QLog.i("AREngine_MarkerJsonParser", 1, "isUrlTransparent isUrlTransparent forse to  false");
            ((ArWebInfo)localObject3).jdField_b_of_type_Boolean = false;
            ((ArWebInfo)localObject3).jdField_a_of_type_JavaLangString = "";
            ((ArWebInfo)localObject3).jdField_a_of_type_Boolean = false;
          }
          paramString.jdField_a_of_type_ComTencentMobileqqArModelArWebInfo = ((ArWebInfo)localObject3);
        }
        if (((JSONObject)localObject1).has("VideoResource"))
        {
          localObject2 = ((JSONObject)localObject1).getJSONArray("VideoResource");
          localObject3 = new ArrayList();
          if (i < ((JSONArray)localObject2).length())
          {
            JSONObject localJSONObject = ((JSONArray)localObject2).getJSONObject(i);
            ArVideoResourceInfo localArVideoResourceInfo = new ArVideoResourceInfo();
            if (localJSONObject.has("VideoConnectType")) {
              localArVideoResourceInfo.jdField_a_of_type_Int = localJSONObject.getInt("VideoConnectType");
            }
            if (localJSONObject.has("VideoKeyingConfig")) {
              localArVideoResourceInfo.jdField_a_of_type_JavaLangString = localJSONObject.getString("VideoKeyingConfig");
            }
            if (localJSONObject.has("VideoSize")) {
              localArVideoResourceInfo.jdField_a_of_type_Long = localJSONObject.getLong("VideoSize");
            }
            if (localJSONObject.has("VideoLayout")) {
              localArVideoResourceInfo.jdField_b_of_type_JavaLangString = localJSONObject.getString("VideoLayout");
            }
            if (localJSONObject.has("VideoMD5")) {
              localArVideoResourceInfo.jdField_c_of_type_JavaLangString = localJSONObject.getString("VideoMD5");
            }
            if (localJSONObject.has("VideoRepeatTimes")) {
              localArVideoResourceInfo.jdField_b_of_type_Int = localJSONObject.getInt("VideoRepeatTimes");
            }
            if (localJSONObject.has("VideoTrackMode")) {
              localArVideoResourceInfo.jdField_c_of_type_Int = localJSONObject.getInt("VideoTrackMode");
            }
            if (localJSONObject.has("VideoType")) {
              localArVideoResourceInfo.jdField_d_of_type_Int = localJSONObject.getInt("VideoType");
            }
            if (localJSONObject.has("VideoUrl")) {
              localArVideoResourceInfo.jdField_d_of_type_JavaLangString = localJSONObject.getString("VideoUrl");
            }
            ((ArrayList)localObject3).add(localArVideoResourceInfo);
            i += 1;
            continue;
          }
          paramString.jdField_a_of_type_JavaUtilArrayList = ((ArrayList)localObject3);
        }
        if (((JSONObject)localObject1).has("IsRelationShip")) {
          paramString.g = ((JSONObject)localObject1).getInt("IsRelationShip");
        }
        if (((JSONObject)localObject1).has("traversing360")) {
          paramString.jdField_a_of_type_ComTencentMobileqqArARPromotionARTransferDoorConfigInfo = ARTransferDoorConfigInfo.a(((JSONObject)localObject1).getJSONObject("traversing360"));
        }
        if (((JSONObject)localObject1).has("ARRelationShip"))
        {
          localObject2 = ((JSONObject)localObject1).getJSONObject("ARRelationShip");
          localObject3 = new ARRelationShip();
          if (((JSONObject)localObject2).has("TaskId"))
          {
            paramString.jdField_b_of_type_Int = 1;
            paramString.jdField_d_of_type_Int = 7;
            ((ARRelationShip)localObject3).jdField_a_of_type_JavaLangString = ((JSONObject)localObject2).getString("TaskId");
          }
          if (((JSONObject)localObject2).has("ARRelationShipResourceUrl")) {
            ((ARRelationShip)localObject3).jdField_b_of_type_JavaLangString = ((JSONObject)localObject2).getString("ARRelationShipResourceUrl");
          }
          if (((JSONObject)localObject2).has("ARRelationShipResourceMd5")) {
            ((ARRelationShip)localObject3).jdField_c_of_type_JavaLangString = ((JSONObject)localObject2).getString("ARRelationShipResourceMd5");
          }
          if (((JSONObject)localObject2).has("AIOMsgImageUrl")) {
            ((ARRelationShip)localObject3).k = ((JSONObject)localObject2).getString("AIOMsgImageUrl");
          }
          if (((JSONObject)localObject2).has("AIOMsgJumpUrl")) {
            ((ARRelationShip)localObject3).j = ((JSONObject)localObject2).getString("AIOMsgJumpUrl");
          }
          if (((JSONObject)localObject2).has("AIOMsgSummary")) {
            ((ARRelationShip)localObject3).i = ((JSONObject)localObject2).getString("AIOMsgSummary");
          }
          if (((JSONObject)localObject2).has("AIOMsgTitle")) {
            ((ARRelationShip)localObject3).h = ((JSONObject)localObject2).getString("AIOMsgTitle");
          }
          if (((JSONObject)localObject2).has("ARRelationShipResourceSize")) {
            ((ARRelationShip)localObject3).jdField_a_of_type_Long = ((JSONObject)localObject2).getLong("ARRelationShipResourceSize");
          }
          if (((JSONObject)localObject2).has("GuideWebPageUrl")) {
            ((ARRelationShip)localObject3).g = ((JSONObject)localObject2).getString("GuideWebPageUrl");
          }
          if (((JSONObject)localObject2).has("SendMsgSuccessUrl")) {
            ((ARRelationShip)localObject3).f = ((JSONObject)localObject2).getString("SendMsgSuccessUrl");
          }
          if (((JSONObject)localObject2).has("ShareTopicUrl")) {
            ((ARRelationShip)localObject3).e = ((JSONObject)localObject2).getString("ShareTopicUrl");
          }
          if (((JSONObject)localObject2).has("CardDefaultText")) {
            ((ARRelationShip)localObject3).l = ((JSONObject)localObject2).getString("CardDefaultText");
          }
          if (((JSONObject)localObject2).has("StarUin")) {
            ((ARRelationShip)localObject3).m = ((JSONObject)localObject2).getString("StarUin");
          }
          if (((JSONObject)localObject2).has("StarNickName")) {
            ((ARRelationShip)localObject3).n = ((JSONObject)localObject2).getString("StarNickName");
          }
          paramString.jdField_a_of_type_ComTencentMobileqqArModelARRelationShip = ((ARRelationShip)localObject3);
        }
        if (((JSONObject)localObject1).has("LbsActivity"))
        {
          localObject1 = ((JSONObject)localObject1).getJSONObject("LbsActivity");
          localObject2 = new ArLBSActivity();
          if (((JSONObject)localObject1).has("ActivityName")) {
            ((ArLBSActivity)localObject2).jdField_a_of_type_JavaLangString = ((JSONObject)localObject1).getString("ActivityName");
          }
          if (((JSONObject)localObject1).has("Logo")) {
            ((ArLBSActivity)localObject2).jdField_b_of_type_JavaLangString = ((JSONObject)localObject1).getString("Logo");
          }
          if (((JSONObject)localObject1).has("MapBackground")) {
            ((ArLBSActivity)localObject2).jdField_c_of_type_JavaLangString = ((JSONObject)localObject1).getString("MapBackground");
          }
          if (((JSONObject)localObject1).has("PrizeImage")) {
            ((ArLBSActivity)localObject2).jdField_d_of_type_JavaLangString = ((JSONObject)localObject1).getString("PrizeImage");
          }
          if (((JSONObject)localObject1).has("PrizeName")) {
            ((ArLBSActivity)localObject2).e = ((JSONObject)localObject1).getString("PrizeName");
          }
          if (((JSONObject)localObject1).has("TipsForOutsideLBSLocation")) {
            ((ArLBSActivity)localObject2).f = ((JSONObject)localObject1).getString("TipsForOutsideLBSLocation");
          }
          if (((JSONObject)localObject1).has("TipsTitleForNoLBSLocation")) {
            ((ArLBSActivity)localObject2).g = ((JSONObject)localObject1).getString("TipsTitleForNoLBSLocation");
          }
          if (((JSONObject)localObject1).has("TipsContentForNoLBSLocation")) {
            ((ArLBSActivity)localObject2).h = ((JSONObject)localObject1).getString("TipsContentForNoLBSLocation");
          }
          paramString.jdField_a_of_type_ComTencentMobileqqArModelArLBSActivity = ((ArLBSActivity)localObject2);
        }
        return paramString;
      }
      catch (JSONException paramString)
      {
        Object localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("parseCloudInfo parse json failed. error msg = ");
        ((StringBuilder)localObject1).append(paramString.getMessage());
        QLog.i("AREngine_MarkerJsonParser", 1, ((StringBuilder)localObject1).toString());
      }
      return null;
      label1968:
      int i = 11;
      continue;
      label1974:
      boolean bool = false;
      continue;
      label1979:
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ar.arengine.ARCloudMarkerJsonParser
 * JD-Core Version:    0.7.0.1
 */