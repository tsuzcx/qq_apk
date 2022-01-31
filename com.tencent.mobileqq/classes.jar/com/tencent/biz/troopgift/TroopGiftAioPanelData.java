package com.tencent.biz.troopgift;

import android.content.Context;
import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.mobileqq.troop.utils.TroopGiftManager.GiveGift;
import com.tencent.mobileqq.util.SharePreferenceUtils;
import com.tencent.qphone.base.util.QLog;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class TroopGiftAioPanelData
{
  public int a;
  public long a;
  public SparseArray a;
  public TroopGiftAioPanelData.CoinInfo a;
  public TroopGiftAioPanelData.OperationInfo a;
  public String a;
  public ArrayList a;
  public boolean a;
  public int b;
  public String b;
  public ArrayList b;
  public int c;
  public String c;
  public int d = -1;
  
  public TroopGiftAioPanelData(JSONObject paramJSONObject)
  {
    this.jdField_c_of_type_Int = -1;
    this.jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
    if (paramJSONObject == null) {}
    for (;;)
    {
      return;
      this.jdField_c_of_type_JavaLangString = paramJSONObject.toString();
      try
      {
        Object localObject1 = paramJSONObject.optString("date");
        this.jdField_a_of_type_Long = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse((String)localObject1).getTime();
        label69:
        this.jdField_a_of_type_Boolean = paramJSONObject.optBoolean("isShowRedDot");
        this.jdField_a_of_type_JavaLangString = paramJSONObject.optString("defaultPackageID");
        this.jdField_a_of_type_Int = paramJSONObject.optInt("defaultPersonalID");
        this.jdField_b_of_type_Int = paramJSONObject.optInt("defaultPublicID");
        this.jdField_b_of_type_JavaLangString = paramJSONObject.optString("defaultQuantity");
        Object localObject3 = paramJSONObject.optJSONArray("items_personal");
        localObject1 = paramJSONObject.optJSONArray("items_public");
        Object localObject4 = paramJSONObject.optJSONArray("items_custom");
        Object localObject2 = paramJSONObject.optJSONArray("items_interact");
        JSONObject localJSONObject = paramJSONObject.optJSONObject("operationInfo");
        paramJSONObject = paramJSONObject.optJSONObject("coinInfo");
        int k;
        int i;
        if ((localObject4 != null) && (localObject3 != null))
        {
          k = ((JSONArray)localObject4).length();
          this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
          i = 0;
          if (i < k)
          {
            Object localObject5 = ((JSONArray)localObject4).optJSONObject(i);
            if (localObject5 != null)
            {
              localObject5 = new TroopGiftAioItemData((JSONObject)localObject5, i);
              if (((TroopGiftAioItemData)localObject5).jdField_c_of_type_Int <= 4) {
                break label243;
              }
            }
            for (;;)
            {
              i += 1;
              break;
              label243:
              this.jdField_a_of_type_JavaUtilArrayList.add(localObject5);
            }
          }
          k = ((JSONArray)localObject3).length();
          i = 0;
          if (i < k)
          {
            localObject4 = ((JSONArray)localObject3).optJSONObject(i);
            if (localObject4 != null)
            {
              localObject4 = new TroopGiftAioItemData((JSONObject)localObject4, this.jdField_a_of_type_JavaUtilArrayList.size());
              if (((TroopGiftAioItemData)localObject4).jdField_c_of_type_Int <= 4) {
                break label318;
              }
            }
            for (;;)
            {
              i += 1;
              break;
              label318:
              if (((TroopGiftAioItemData)localObject4).jdField_b_of_type_Int != 0) {
                this.jdField_a_of_type_JavaUtilArrayList.add(localObject4);
              }
            }
          }
        }
        else if (localObject3 != null)
        {
          k = ((JSONArray)localObject3).length();
          this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
          i = 0;
          if (i < k)
          {
            localObject4 = ((JSONArray)localObject3).optJSONObject(i);
            if (localObject4 != null)
            {
              localObject4 = new TroopGiftAioItemData((JSONObject)localObject4, this.jdField_a_of_type_JavaUtilArrayList.size());
              if (((TroopGiftAioItemData)localObject4).jdField_c_of_type_Int <= 4) {
                break label417;
              }
            }
            for (;;)
            {
              i += 1;
              break;
              label417:
              this.jdField_a_of_type_JavaUtilArrayList.add(localObject4);
            }
          }
        }
        if (localObject2 != null)
        {
          k = ((JSONArray)localObject2).length();
          this.jdField_b_of_type_JavaUtilArrayList = new ArrayList(k);
          i = 0;
          if (i < k)
          {
            localObject3 = ((JSONArray)localObject2).optJSONObject(i);
            if (localObject3 != null)
            {
              localObject3 = new TroopGiftAioItemData((JSONObject)localObject3, i);
              if (((TroopGiftAioItemData)localObject3).jdField_c_of_type_Int <= 4) {
                break label504;
              }
            }
            for (;;)
            {
              i += 1;
              break;
              label504:
              ((TroopGiftAioItemData)localObject3).jdField_b_of_type_Boolean = true;
              this.jdField_b_of_type_JavaUtilArrayList.add(localObject3);
            }
          }
        }
        if (localObject1 != null)
        {
          k = ((JSONArray)localObject1).length();
          i = j;
          if (this.jdField_b_of_type_JavaUtilArrayList == null)
          {
            this.jdField_b_of_type_JavaUtilArrayList = new ArrayList(k);
            i = j;
          }
          if (i < k)
          {
            localObject2 = ((JSONArray)localObject1).optJSONObject(i);
            if (localObject2 != null)
            {
              localObject2 = new TroopGiftAioItemData((JSONObject)localObject2, this.jdField_b_of_type_JavaUtilArrayList.size());
              if (((TroopGiftAioItemData)localObject2).jdField_c_of_type_Int <= 2) {
                break label612;
              }
            }
            for (;;)
            {
              i += 1;
              break;
              label612:
              this.jdField_b_of_type_JavaUtilArrayList.add(localObject2);
            }
          }
        }
        if (localJSONObject != null) {
          this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData$OperationInfo = new TroopGiftAioPanelData.OperationInfo(localJSONObject);
        }
        if (paramJSONObject == null) {
          continue;
        }
        this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData$CoinInfo = new TroopGiftAioPanelData.CoinInfo(paramJSONObject);
        return;
      }
      catch (ParseException localParseException)
      {
        break label69;
      }
    }
  }
  
  public static TroopGiftAioPanelData a(Context paramContext, int paramInt)
  {
    paramContext = SharePreferenceUtils.a(paramContext, "troop_gift_aio_panel_data_" + paramInt);
    if (!TextUtils.isEmpty(paramContext)) {
      try
      {
        paramContext = new TroopGiftAioPanelData(new JSONObject(paramContext));
        return paramContext;
      }
      catch (JSONException paramContext)
      {
        if (QLog.isColorLevel()) {
          QLog.d("zivonchen", 2, QLog.getStackTraceString(paramContext));
        }
      }
    }
    return null;
  }
  
  public void a(Context paramContext, int paramInt)
  {
    if (!TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)) {
      SharePreferenceUtils.a(paramContext, "troop_gift_aio_panel_data_" + paramInt, this.jdField_c_of_type_JavaLangString);
    }
  }
  
  public void a(List paramList)
  {
    this.jdField_a_of_type_AndroidUtilSparseArray.clear();
    int i = 0;
    while (i < paramList.size())
    {
      TroopGiftManager.GiveGift localGiveGift = (TroopGiftManager.GiveGift)paramList.get(i);
      this.jdField_a_of_type_AndroidUtilSparseArray.put(localGiveGift.jdField_a_of_type_Int, localGiveGift);
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.troopgift.TroopGiftAioPanelData
 * JD-Core Version:    0.7.0.1
 */