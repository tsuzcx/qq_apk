package com.tencent.biz.troopgift;

import android.content.Context;
import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.troop.utils.TroopGiftManager.GiveGift;
import com.tencent.mobileqq.troop.utils.TroopGiftManager.PackGift;
import com.tencent.mobileqq.util.SharePreferenceUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.oidb.cmd0x6c3.oidb_0x6c3.ExclusiveGiftItem;

public class TroopGiftAioPanelData
{
  public int a;
  public long a;
  public SparseArray<TroopGiftManager.GiveGift> a;
  public GiftConfigManager.ActivityTabInfo a;
  public GiftConfigManager.ImgEntryItem a;
  public GiftConfigManager.TextEntryItem a;
  public TroopGiftAioPanelData.CoinInfo a;
  public TroopGiftAioPanelData.EmptyPackagePage a;
  public TroopGiftAioPanelData.OperationInfo a;
  public String a;
  public ArrayList<Object> a;
  public boolean a;
  public int b;
  public SparseArray<TroopGiftManager.PackGift> b;
  public String b;
  public ArrayList<Object> b;
  public int c;
  public String c;
  public ArrayList<Object> c;
  public int d;
  public ArrayList<Object> d;
  public int e;
  public ArrayList<Object> e;
  public ArrayList<TroopGiftAioPanelData.WebPanelItemInfo> f;
  
  public TroopGiftAioPanelData(JSONObject paramJSONObject, String paramString)
  {
    this.jdField_c_of_type_Int = -1;
    this.jdField_d_of_type_Int = -1;
    this.jdField_e_of_type_Int = 0;
    this.jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
    this.jdField_b_of_type_AndroidUtilSparseArray = new SparseArray();
    if (paramJSONObject == null) {
      return;
    }
    this.jdField_c_of_type_JavaLangString = paramJSONObject.toString();
    try
    {
      Object localObject1 = paramJSONObject.optString("date");
      this.jdField_a_of_type_Long = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse((String)localObject1).getTime();
      label83:
      this.jdField_a_of_type_Boolean = paramJSONObject.optBoolean("isShowRedDot");
      this.jdField_a_of_type_JavaLangString = paramJSONObject.optString("defaultPackageID");
      this.jdField_a_of_type_Int = paramJSONObject.optInt("defaultPersonalID");
      this.jdField_b_of_type_Int = paramJSONObject.optInt("defaultPublicID");
      this.jdField_b_of_type_JavaLangString = paramJSONObject.optString("defaultQuantity");
      JSONArray localJSONArray5 = paramJSONObject.optJSONArray("items_personal");
      JSONArray localJSONArray3 = paramJSONObject.optJSONArray("items_public");
      Object localObject2 = paramJSONObject.optJSONArray("items_custom");
      JSONArray localJSONArray4 = paramJSONObject.optJSONArray("items_interact");
      JSONArray localJSONArray1 = paramJSONObject.optJSONArray("items_exclusive_lib");
      Object localObject4 = paramJSONObject.optJSONArray("items_package_lib");
      JSONArray localJSONArray2 = paramJSONObject.optJSONArray("items_personal_tab");
      Object localObject3 = paramJSONObject.optJSONArray("items_personal_free_tab");
      localObject1 = paramJSONObject.optJSONArray("web_panel_tab");
      JSONObject localJSONObject1 = paramJSONObject.optJSONObject("operationInfo");
      JSONObject localJSONObject2 = paramJSONObject.optJSONObject("coinInfo");
      int i;
      int j;
      if ((localObject2 != null) && (localJSONArray5 != null))
      {
        i = ((JSONArray)localObject2).length();
        this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
        j = 0;
        while (j < i)
        {
          Object localObject5 = ((JSONArray)localObject2).optJSONObject(j);
          if (localObject5 != null)
          {
            localObject5 = new TroopGiftAioItemData((JSONObject)localObject5, j);
            if (((TroopGiftAioItemData)localObject5).jdField_c_of_type_Int <= 4) {
              this.jdField_a_of_type_JavaUtilArrayList.add(localObject5);
            }
          }
          j += 1;
        }
        localObject2 = localObject1;
        i = localJSONArray5.length();
        j = 0;
        for (;;)
        {
          localObject1 = localObject2;
          if (j >= i) {
            break;
          }
          localObject1 = localJSONArray5.optJSONObject(j);
          if (localObject1 != null)
          {
            localObject1 = new TroopGiftAioItemData((JSONObject)localObject1, this.jdField_a_of_type_JavaUtilArrayList.size());
            if ((((TroopGiftAioItemData)localObject1).jdField_c_of_type_Int <= 4) && (((TroopGiftAioItemData)localObject1).jdField_b_of_type_Int != 0)) {
              this.jdField_a_of_type_JavaUtilArrayList.add(localObject1);
            }
          }
          j += 1;
        }
      }
      localObject2 = localObject1;
      localObject1 = localObject2;
      if (localJSONArray5 != null)
      {
        i = localJSONArray5.length();
        this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
        j = 0;
        for (;;)
        {
          localObject1 = localObject2;
          if (j >= i) {
            break;
          }
          localObject1 = localJSONArray5.optJSONObject(j);
          if (localObject1 != null)
          {
            localObject1 = new TroopGiftAioItemData((JSONObject)localObject1, this.jdField_a_of_type_JavaUtilArrayList.size());
            if (((TroopGiftAioItemData)localObject1).jdField_c_of_type_Int <= 4) {
              this.jdField_a_of_type_JavaUtilArrayList.add(localObject1);
            }
          }
          j += 1;
        }
      }
      if (localJSONArray4 != null)
      {
        j = localJSONArray4.length();
        this.jdField_d_of_type_JavaUtilArrayList = new ArrayList(j);
        i = 0;
        while (i < j)
        {
          localObject2 = localJSONArray4.optJSONObject(i);
          if (localObject2 != null)
          {
            localObject2 = new TroopGiftAioItemData((JSONObject)localObject2, i);
            if (((TroopGiftAioItemData)localObject2).jdField_c_of_type_Int <= 4)
            {
              ((TroopGiftAioItemData)localObject2).jdField_b_of_type_Boolean = true;
              this.jdField_d_of_type_JavaUtilArrayList.add(localObject2);
            }
          }
          i += 1;
        }
      }
      if (localJSONArray3 != null)
      {
        j = localJSONArray3.length();
        if (this.jdField_d_of_type_JavaUtilArrayList == null) {
          this.jdField_d_of_type_JavaUtilArrayList = new ArrayList(j);
        }
        i = 0;
        while (i < j)
        {
          localObject2 = localJSONArray3.optJSONObject(i);
          if (localObject2 != null)
          {
            localObject2 = new TroopGiftAioItemData((JSONObject)localObject2, this.jdField_d_of_type_JavaUtilArrayList.size());
            if (((TroopGiftAioItemData)localObject2).jdField_c_of_type_Int <= 2) {
              this.jdField_d_of_type_JavaUtilArrayList.add(localObject2);
            }
          }
          i += 1;
        }
      }
      if (localJSONObject1 != null) {
        this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData$OperationInfo = new TroopGiftAioPanelData.OperationInfo(localJSONObject1);
      }
      if (localJSONObject2 != null) {
        this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData$CoinInfo = new TroopGiftAioPanelData.CoinInfo(localJSONObject2);
      }
      a(localJSONArray1, paramString);
      if (localObject4 != null)
      {
        j = ((JSONArray)localObject4).length();
        if (this.jdField_e_of_type_JavaUtilArrayList == null) {
          this.jdField_e_of_type_JavaUtilArrayList = new ArrayList(j);
        }
        i = 0;
        while (i < j)
        {
          localObject2 = ((JSONArray)localObject4).optJSONObject(i);
          if (localObject2 != null)
          {
            localObject2 = new TroopGiftAioItemData((JSONObject)localObject2, i);
            if (((TroopGiftAioItemData)localObject2).jdField_c_of_type_Int <= 4)
            {
              ((TroopGiftAioItemData)localObject2).jdField_c_of_type_Int = 5;
              ((TroopGiftAioItemData)localObject2).d = true;
              this.jdField_e_of_type_JavaUtilArrayList.add(localObject2);
            }
          }
          i += 1;
        }
      }
      this.jdField_a_of_type_ComTencentBizTroopgiftGiftConfigManager$ActivityTabInfo = GiftConfigManager.a(paramJSONObject.optJSONObject("activityInfo"));
      localObject2 = paramJSONObject.optJSONObject("profileCard");
      if (localObject2 != null) {
        this.jdField_a_of_type_ComTencentBizTroopgiftGiftConfigManager$TextEntryItem = GiftConfigManager.a(((JSONObject)localObject2).optJSONObject("giftItem"));
      }
      this.jdField_a_of_type_ComTencentBizTroopgiftGiftConfigManager$ImgEntryItem = GiftConfigManager.a(paramJSONObject.optJSONObject("panelEntry"));
      paramJSONObject = new HashMap();
      localObject2 = this.jdField_a_of_type_JavaUtilArrayList;
      if ((localObject2 != null) && (((ArrayList)localObject2).size() > 0))
      {
        localObject2 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject4 = ((Iterator)localObject2).next();
          if ((localObject4 instanceof TroopGiftAioItemData))
          {
            localObject4 = (TroopGiftAioItemData)localObject4;
            paramJSONObject.put(Integer.valueOf(((TroopGiftAioItemData)localObject4).jdField_a_of_type_Int), localObject4);
          }
        }
      }
      int k;
      if ((localObject3 != null) && (((JSONArray)localObject3).length() > 0))
      {
        j = ((JSONArray)localObject3).length();
        this.jdField_c_of_type_JavaUtilArrayList = new ArrayList(j);
        i = 0;
        while (i < j)
        {
          localObject2 = ((JSONArray)localObject3).optJSONObject(i);
          if (localObject2 != null)
          {
            localObject2 = new TroopGiftAioPanelData.PersonalTabItemInfo((JSONObject)localObject2);
            this.jdField_c_of_type_JavaUtilArrayList.add(localObject2);
            localObject4 = ((TroopGiftAioPanelData.PersonalTabItemInfo)localObject2).jdField_a_of_type_JavaUtilArrayList.iterator();
            while (((Iterator)localObject4).hasNext())
            {
              k = ((Integer)((Iterator)localObject4).next()).intValue();
              if (paramJSONObject.containsKey(Integer.valueOf(k))) {
                ((TroopGiftAioPanelData.PersonalTabItemInfo)localObject2).jdField_b_of_type_JavaUtilArrayList.add(paramJSONObject.get(Integer.valueOf(k)));
              }
            }
          }
          i += 1;
        }
      }
      if (localJSONArray2 != null)
      {
        k = localJSONArray2.length();
        if (this.jdField_b_of_type_JavaUtilArrayList == null) {
          this.jdField_b_of_type_JavaUtilArrayList = new ArrayList(k);
        }
        i = 0;
        while (i < k)
        {
          localObject2 = localJSONArray2.optJSONObject(i);
          if (localObject2 != null)
          {
            localObject2 = new TroopGiftAioPanelData.PersonalTabItemInfo((JSONObject)localObject2);
            if ((!TextUtils.isEmpty(((TroopGiftAioPanelData.PersonalTabItemInfo)localObject2).jdField_a_of_type_JavaLangString)) && (((TroopGiftAioPanelData.PersonalTabItemInfo)localObject2).jdField_a_of_type_JavaUtilArrayList != null) && (((TroopGiftAioPanelData.PersonalTabItemInfo)localObject2).jdField_b_of_type_JavaUtilArrayList != null))
            {
              localObject3 = ((TroopGiftAioPanelData.PersonalTabItemInfo)localObject2).jdField_a_of_type_JavaUtilArrayList.iterator();
              while (((Iterator)localObject3).hasNext())
              {
                int m = ((Integer)((Iterator)localObject3).next()).intValue();
                if (paramJSONObject.containsKey(Integer.valueOf(m)))
                {
                  if (localJSONArray1 != null)
                  {
                    int i1 = localJSONArray1.length();
                    j = 0;
                    while (j < i1)
                    {
                      localObject4 = localJSONArray1.optJSONObject(j);
                      if (localObject4 != null)
                      {
                        int n = ((JSONObject)localObject4).optInt("packageID");
                        if ((((JSONObject)localObject4).optInt("giftType") == 0) && (n == m)) {
                          try
                          {
                            localObject4 = new JSONArray(paramString);
                            j = 0;
                            while (j < ((JSONArray)localObject4).length())
                            {
                              i1 = ((Integer)((JSONArray)localObject4).get(j)).intValue();
                              if (i1 == n) {
                                break label1460;
                              }
                              j += 1;
                            }
                            j += 1;
                          }
                          catch (Exception localException)
                          {
                            if (QLog.isColorLevel()) {
                              QLog.e("TroopGiftAioPanelData", 2, "mergeExclusiveGift search exp:", localException);
                            }
                            j = 0;
                          }
                        }
                      }
                    }
                  }
                  label1460:
                  j = 1;
                  if (j != 0) {
                    ((TroopGiftAioPanelData.PersonalTabItemInfo)localObject2).jdField_b_of_type_JavaUtilArrayList.add(paramJSONObject.get(Integer.valueOf(m)));
                  }
                }
              }
              this.jdField_b_of_type_JavaUtilArrayList.add(localObject2);
            }
          }
          i += 1;
        }
      }
      paramJSONObject = this.jdField_c_of_type_JavaUtilArrayList;
      if ((paramJSONObject != null) && (paramJSONObject.size() > 0))
      {
        if (this.jdField_b_of_type_JavaUtilArrayList == null) {
          this.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
        }
        paramJSONObject = this.jdField_c_of_type_JavaUtilArrayList.iterator();
        i = 0;
        while (paramJSONObject.hasNext())
        {
          paramString = paramJSONObject.next();
          this.jdField_b_of_type_JavaUtilArrayList.add(i, paramString);
          i += 1;
        }
      }
      if (localObject1 != null)
      {
        j = ((JSONArray)localObject1).length();
        if (this.f == null) {
          this.f = new ArrayList(j);
        }
        i = 0;
        while (i < j)
        {
          paramJSONObject = ((JSONArray)localObject1).optJSONObject(i);
          if (paramJSONObject != null)
          {
            paramJSONObject = new TroopGiftAioPanelData.WebPanelItemInfo(paramJSONObject);
            this.f.add(paramJSONObject);
          }
          i += 1;
        }
      }
      return;
    }
    catch (ParseException localParseException)
    {
      break label83;
    }
  }
  
  public static TroopGiftAioPanelData a(Context paramContext, int paramInt)
  {
    return a(paramContext, paramInt, "");
  }
  
  public static TroopGiftAioPanelData a(Context paramContext, int paramInt, String paramString)
  {
    long l = System.currentTimeMillis();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("troop_gift_aio_panel_data_v2_");
    ((StringBuilder)localObject).append(paramInt);
    localObject = SharePreferenceUtils.a(paramContext, ((StringBuilder)localObject).toString());
    if (!TextUtils.isEmpty((CharSequence)localObject)) {}
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject((String)localObject);
        paramContext = "";
        if (paramInt != 5) {
          break label174;
        }
        paramContext = a();
        continue;
        paramContext = a(paramString);
        paramContext = new TroopGiftAioPanelData(localJSONObject, paramContext);
        if (QLog.isColorLevel())
        {
          paramString = new StringBuilder();
          paramString.append("getLocalGiftData, time=");
          paramString.append(System.currentTimeMillis() - l);
          paramString.append(", data.len=");
          paramString.append(((String)localObject).length());
          QLog.d("TroopGiftPanel.time", 2, paramString.toString());
        }
        return paramContext;
      }
      catch (JSONException paramContext)
      {
        if (QLog.isColorLevel()) {
          QLog.d("zivonchen", 2, QLog.getStackTraceString(paramContext));
        }
      }
      return null;
      label174:
      if ((paramInt != 1) && (paramInt != 6)) {
        if (paramInt != 4) {}
      }
    }
  }
  
  public static String a()
  {
    Object localObject = BaseApplication.getContext();
    String str = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("exclusive_gift_ids_c2c_");
    localStringBuilder.append(str);
    str = localStringBuilder.toString();
    localObject = SharePreferenceUtils.a((Context)localObject, str);
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("getC2CExclusiveGiftIds, key=");
      localStringBuilder.append(str);
      localStringBuilder.append(", data=");
      localStringBuilder.append((String)localObject);
      QLog.d("TroopGiftAioPanelData", 2, localStringBuilder.toString());
    }
    return localObject;
  }
  
  public static String a(String paramString)
  {
    Object localObject1 = BaseApplication.getContext();
    Object localObject2 = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("exclusive_gift_ids_troop_");
    localStringBuilder.append((String)localObject2);
    localStringBuilder.append("_");
    localStringBuilder.append(paramString);
    paramString = localStringBuilder.toString();
    localObject1 = SharePreferenceUtils.a((Context)localObject1, paramString);
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("getTroopExclusiveGiftIds, key=");
      ((StringBuilder)localObject2).append(paramString);
      ((StringBuilder)localObject2).append(", data=");
      ((StringBuilder)localObject2).append((String)localObject1);
      QLog.d("TroopGiftAioPanelData", 2, ((StringBuilder)localObject2).toString());
    }
    return localObject1;
  }
  
  public static String a(List<oidb_0x6c3.ExclusiveGiftItem> paramList)
  {
    JSONArray localJSONArray = new JSONArray();
    if (paramList != null)
    {
      int i = 0;
      while (i < paramList.size())
      {
        localJSONArray.put(((oidb_0x6c3.ExclusiveGiftItem)paramList.get(i)).gift_id.get());
        i += 1;
      }
    }
    return localJSONArray.toString();
  }
  
  public static void a(String paramString)
  {
    Object localObject = BaseApplication.getContext();
    String str = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("exclusive_gift_ids_c2c_");
    localStringBuilder.append(str);
    str = localStringBuilder.toString();
    SharePreferenceUtils.a((Context)localObject, str, paramString);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("saveC2CExclusiveGiftIds, key=");
      ((StringBuilder)localObject).append(str);
      ((StringBuilder)localObject).append(", data=");
      ((StringBuilder)localObject).append(paramString);
      QLog.d("TroopGiftAioPanelData", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  public static void a(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString2)) {
      return;
    }
    Object localObject = BaseApplication.getContext();
    String str = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("exclusive_gift_ids_troop_");
    localStringBuilder.append(str);
    localStringBuilder.append("_");
    localStringBuilder.append(paramString2);
    paramString2 = localStringBuilder.toString();
    SharePreferenceUtils.a((Context)localObject, paramString2, paramString1);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("saveTroopExclusiveGiftIds, key=");
      ((StringBuilder)localObject).append(paramString2);
      ((StringBuilder)localObject).append(", data=");
      ((StringBuilder)localObject).append(paramString1);
      QLog.d("TroopGiftAioPanelData", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  public static String b(String paramString)
  {
    BaseApplication localBaseApplication = BaseApplication.getContext();
    String str = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("troop_gift_last_receiver_");
    localStringBuilder.append(str);
    localStringBuilder.append("_");
    localStringBuilder.append(paramString);
    return SharePreferenceUtils.a(localBaseApplication, localStringBuilder.toString());
  }
  
  public static void b(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return;
    }
    Object localObject = BaseApplication.getContext();
    String str = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("troop_gift_last_receiver_");
    localStringBuilder.append(str);
    localStringBuilder.append("_");
    localStringBuilder.append(paramString1);
    paramString1 = localStringBuilder.toString();
    SharePreferenceUtils.a((Context)localObject, paramString1, paramString2);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("saveLastGiftReceiver, key=");
      ((StringBuilder)localObject).append(paramString1);
      ((StringBuilder)localObject).append(", data=");
      ((StringBuilder)localObject).append(paramString2);
      QLog.d("TroopGiftAioPanelData", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  public void a(Context paramContext, int paramInt)
  {
    if (!TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("troop_gift_aio_panel_data_v2_");
      localStringBuilder.append(paramInt);
      SharePreferenceUtils.a(paramContext, localStringBuilder.toString(), this.jdField_c_of_type_JavaLangString);
    }
  }
  
  public void a(TroopGiftAioPanelData.EmptyPackagePage paramEmptyPackagePage)
  {
    this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData$EmptyPackagePage = paramEmptyPackagePage;
  }
  
  public void a(List<TroopGiftManager.GiveGift> paramList)
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
  
  protected void a(JSONArray paramJSONArray, String paramString)
  {
    ArrayList localArrayList2;
    ArrayList localArrayList1;
    int k;
    int i;
    if ((paramJSONArray != null) && (paramJSONArray.length() != 0))
    {
      if (TextUtils.isEmpty(paramString))
      {
        if (QLog.isColorLevel()) {
          QLog.d("TroopGiftAioPanelData", 2, "mergeExclusiveGift exclusiveGiftIds is empty");
        }
        return;
      }
      localArrayList2 = new ArrayList();
      localArrayList1 = new ArrayList();
      k = 0;
      try
      {
        paramString = new JSONArray(paramString);
        int j;
        if ((paramString.length() > 0) && (paramJSONArray.length() > 0))
        {
          i = 0;
          while (i < paramString.length())
          {
            int m = ((Integer)paramString.get(i)).intValue();
            j = 0;
            while (j < paramJSONArray.length())
            {
              JSONObject localJSONObject = paramJSONArray.optJSONObject(j);
              int n = localJSONObject.optInt("packageID");
              int i1 = localJSONObject.optInt("giftType");
              if (m == n)
              {
                if (i1 == 0)
                {
                  localArrayList2.add(new TroopGiftAioItemData(localJSONObject, localArrayList2.size()));
                  break;
                }
                if (i1 != 1) {
                  break;
                }
                localArrayList1.add(new TroopGiftAioItemData(localJSONObject, localArrayList1.size()));
                break;
              }
              j += 1;
            }
            i += 1;
          }
        }
        try
        {
          if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (localArrayList2.size() > 0)) {
            i = localArrayList2.size() - 1;
          }
          while (i >= 0)
          {
            paramJSONArray = localArrayList2.get(i);
            this.jdField_a_of_type_JavaUtilArrayList.add(0, paramJSONArray);
            i -= 1;
            continue;
            while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
            {
              ((TroopGiftAioItemData)this.jdField_a_of_type_JavaUtilArrayList.get(i)).g = i;
              i += 1;
            }
            if ((this.jdField_d_of_type_JavaUtilArrayList != null) && (localArrayList1.size() > 0))
            {
              i = localArrayList1.size() - 1;
              for (;;)
              {
                j = k;
                if (i < 0) {
                  break;
                }
                paramJSONArray = localArrayList1.get(i);
                this.jdField_d_of_type_JavaUtilArrayList.add(0, paramJSONArray);
                i -= 1;
              }
              while (j < this.jdField_d_of_type_JavaUtilArrayList.size())
              {
                ((TroopGiftAioItemData)this.jdField_d_of_type_JavaUtilArrayList.get(j)).g = j;
                j += 1;
              }
            }
            return;
          }
        }
        catch (Exception paramJSONArray)
        {
          if (QLog.isColorLevel()) {
            QLog.e("TroopGiftAioPanelData", 2, "mergeExclusiveGift merge exp:", paramJSONArray);
          }
        }
      }
      catch (Exception paramJSONArray)
      {
        if (QLog.isColorLevel()) {
          QLog.e("TroopGiftAioPanelData", 2, "mergeExclusiveGift search exp:", paramJSONArray);
        }
        if (QLog.isColorLevel())
        {
          paramJSONArray = new StringBuilder();
          paramJSONArray.append("mergeExclusiveGift, persional.size=");
          paramJSONArray.append(localArrayList2.size());
          paramJSONArray.append(", public.size=");
          paramJSONArray.append(localArrayList1.size());
          QLog.d("TroopGiftAioPanelData", 2, paramJSONArray.toString());
        }
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopGiftAioPanelData", 2, "mergeExclusiveGift jsonArrayExclusive is empty");
      }
      return;
      i = 0;
    }
  }
  
  public boolean a(int paramInt)
  {
    Object localObject = this.jdField_b_of_type_JavaUtilArrayList;
    if ((localObject != null) && (this.jdField_c_of_type_JavaUtilArrayList != null) && (paramInt >= 0) && (paramInt < ((ArrayList)localObject).size()) && (paramInt < this.jdField_c_of_type_JavaUtilArrayList.size()) && ((this.jdField_b_of_type_JavaUtilArrayList.get(paramInt) instanceof TroopGiftAioPanelData.PersonalTabItemInfo)))
    {
      localObject = (TroopGiftAioPanelData.PersonalTabItemInfo)this.jdField_b_of_type_JavaUtilArrayList.get(paramInt);
      if ((this.jdField_c_of_type_JavaUtilArrayList.get(paramInt) instanceof TroopGiftAioPanelData.PersonalTabItemInfo))
      {
        TroopGiftAioPanelData.PersonalTabItemInfo localPersonalTabItemInfo = (TroopGiftAioPanelData.PersonalTabItemInfo)this.jdField_c_of_type_JavaUtilArrayList.get(paramInt);
        if ((localPersonalTabItemInfo.jdField_a_of_type_JavaLangString != null) && (localPersonalTabItemInfo.jdField_a_of_type_JavaLangString.equals(((TroopGiftAioPanelData.PersonalTabItemInfo)localObject).jdField_a_of_type_JavaLangString))) {
          return true;
        }
      }
    }
    return false;
  }
  
  public void b(List<TroopGiftManager.PackGift> paramList)
  {
    this.jdField_b_of_type_AndroidUtilSparseArray.clear();
    int j = 0;
    int i = 0;
    Object localObject;
    while (i < paramList.size())
    {
      localObject = (TroopGiftManager.PackGift)paramList.get(i);
      this.jdField_b_of_type_AndroidUtilSparseArray.put(((TroopGiftManager.PackGift)localObject).jdField_a_of_type_Int, localObject);
      i += 1;
    }
    if (this.jdField_e_of_type_JavaUtilArrayList != null)
    {
      paramList = new ArrayList();
      localObject = this.jdField_e_of_type_JavaUtilArrayList;
      i = j;
      if (localObject != null)
      {
        i = j;
        if (((ArrayList)localObject).size() > 0)
        {
          i = 0;
          while (i < this.jdField_e_of_type_JavaUtilArrayList.size())
          {
            localObject = (TroopGiftAioItemData)this.jdField_e_of_type_JavaUtilArrayList.get(i);
            if (this.jdField_b_of_type_AndroidUtilSparseArray.get(((TroopGiftAioItemData)localObject).jdField_a_of_type_Int) != null)
            {
              ((TroopGiftAioItemData)localObject).g = i;
              paramList.add(localObject);
            }
            i += 1;
          }
          this.jdField_e_of_type_JavaUtilArrayList.clear();
          this.jdField_e_of_type_JavaUtilArrayList.addAll(paramList);
          paramList.clear();
          i = j;
        }
      }
      while (i < this.jdField_e_of_type_JavaUtilArrayList.size())
      {
        ((TroopGiftAioItemData)this.jdField_e_of_type_JavaUtilArrayList.get(i)).g = i;
        i += 1;
      }
      i = this.jdField_e_of_type_JavaUtilArrayList.size();
      j = this.jdField_e_of_type_Int;
      if (i > j) {
        ((TroopGiftAioItemData)this.jdField_e_of_type_JavaUtilArrayList.get(j)).jdField_a_of_type_Boolean = true;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.troopgift.TroopGiftAioPanelData
 * JD-Core Version:    0.7.0.1
 */