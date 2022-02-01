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
  public long a;
  public String b;
  public int c;
  public int d;
  public String e;
  public ArrayList<Object> f;
  public ArrayList<Object> g;
  public ArrayList<Object> h;
  public ArrayList<Object> i;
  public ArrayList<Object> j;
  public ArrayList<TroopGiftAioPanelData.WebPanelItemInfo> k;
  public TroopGiftAioPanelData.OperationInfo l;
  public TroopGiftAioPanelData.CoinInfo m;
  public boolean n;
  public int o = -1;
  public int p = -1;
  public int q = 0;
  public String r;
  public SparseArray<TroopGiftManager.GiveGift> s = new SparseArray();
  public GiftConfigManager.ActivityTabInfo t;
  public GiftConfigManager.TextEntryItem u;
  public GiftConfigManager.ImgEntryItem v;
  public SparseArray<TroopGiftManager.PackGift> w = new SparseArray();
  public TroopGiftAioPanelData.EmptyPackagePage x;
  
  public TroopGiftAioPanelData(JSONObject paramJSONObject, String paramString)
  {
    if (paramJSONObject == null) {
      return;
    }
    this.r = paramJSONObject.toString();
    try
    {
      Object localObject1 = paramJSONObject.optString("date");
      this.a = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse((String)localObject1).getTime();
      label83:
      this.n = paramJSONObject.optBoolean("isShowRedDot");
      this.b = paramJSONObject.optString("defaultPackageID");
      this.c = paramJSONObject.optInt("defaultPersonalID");
      this.d = paramJSONObject.optInt("defaultPublicID");
      this.e = paramJSONObject.optString("defaultQuantity");
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
      int i1;
      int i2;
      if ((localObject2 != null) && (localJSONArray5 != null))
      {
        i1 = ((JSONArray)localObject2).length();
        this.f = new ArrayList();
        i2 = 0;
        while (i2 < i1)
        {
          Object localObject5 = ((JSONArray)localObject2).optJSONObject(i2);
          if (localObject5 != null)
          {
            localObject5 = new TroopGiftAioItemData((JSONObject)localObject5, i2);
            if (((TroopGiftAioItemData)localObject5).f <= 4) {
              this.f.add(localObject5);
            }
          }
          i2 += 1;
        }
        localObject2 = localObject1;
        i1 = localJSONArray5.length();
        i2 = 0;
        for (;;)
        {
          localObject1 = localObject2;
          if (i2 >= i1) {
            break;
          }
          localObject1 = localJSONArray5.optJSONObject(i2);
          if (localObject1 != null)
          {
            localObject1 = new TroopGiftAioItemData((JSONObject)localObject1, this.f.size());
            if ((((TroopGiftAioItemData)localObject1).f <= 4) && (((TroopGiftAioItemData)localObject1).e != 0)) {
              this.f.add(localObject1);
            }
          }
          i2 += 1;
        }
      }
      localObject2 = localObject1;
      localObject1 = localObject2;
      if (localJSONArray5 != null)
      {
        i1 = localJSONArray5.length();
        this.f = new ArrayList();
        i2 = 0;
        for (;;)
        {
          localObject1 = localObject2;
          if (i2 >= i1) {
            break;
          }
          localObject1 = localJSONArray5.optJSONObject(i2);
          if (localObject1 != null)
          {
            localObject1 = new TroopGiftAioItemData((JSONObject)localObject1, this.f.size());
            if (((TroopGiftAioItemData)localObject1).f <= 4) {
              this.f.add(localObject1);
            }
          }
          i2 += 1;
        }
      }
      if (localJSONArray4 != null)
      {
        i2 = localJSONArray4.length();
        this.i = new ArrayList(i2);
        i1 = 0;
        while (i1 < i2)
        {
          localObject2 = localJSONArray4.optJSONObject(i1);
          if (localObject2 != null)
          {
            localObject2 = new TroopGiftAioItemData((JSONObject)localObject2, i1);
            if (((TroopGiftAioItemData)localObject2).f <= 4)
            {
              ((TroopGiftAioItemData)localObject2).m = true;
              this.i.add(localObject2);
            }
          }
          i1 += 1;
        }
      }
      if (localJSONArray3 != null)
      {
        i2 = localJSONArray3.length();
        if (this.i == null) {
          this.i = new ArrayList(i2);
        }
        i1 = 0;
        while (i1 < i2)
        {
          localObject2 = localJSONArray3.optJSONObject(i1);
          if (localObject2 != null)
          {
            localObject2 = new TroopGiftAioItemData((JSONObject)localObject2, this.i.size());
            if (((TroopGiftAioItemData)localObject2).f <= 2) {
              this.i.add(localObject2);
            }
          }
          i1 += 1;
        }
      }
      if (localJSONObject1 != null) {
        this.l = new TroopGiftAioPanelData.OperationInfo(localJSONObject1);
      }
      if (localJSONObject2 != null) {
        this.m = new TroopGiftAioPanelData.CoinInfo(localJSONObject2);
      }
      a(localJSONArray1, paramString);
      if (localObject4 != null)
      {
        i2 = ((JSONArray)localObject4).length();
        if (this.j == null) {
          this.j = new ArrayList(i2);
        }
        i1 = 0;
        while (i1 < i2)
        {
          localObject2 = ((JSONArray)localObject4).optJSONObject(i1);
          if (localObject2 != null)
          {
            localObject2 = new TroopGiftAioItemData((JSONObject)localObject2, i1);
            if (((TroopGiftAioItemData)localObject2).f <= 4)
            {
              ((TroopGiftAioItemData)localObject2).f = 5;
              ((TroopGiftAioItemData)localObject2).q = true;
              this.j.add(localObject2);
            }
          }
          i1 += 1;
        }
      }
      this.t = GiftConfigManager.a(paramJSONObject.optJSONObject("activityInfo"));
      localObject2 = paramJSONObject.optJSONObject("profileCard");
      if (localObject2 != null) {
        this.u = GiftConfigManager.b(((JSONObject)localObject2).optJSONObject("giftItem"));
      }
      this.v = GiftConfigManager.c(paramJSONObject.optJSONObject("panelEntry"));
      paramJSONObject = new HashMap();
      localObject2 = this.f;
      if ((localObject2 != null) && (((ArrayList)localObject2).size() > 0))
      {
        localObject2 = this.f.iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject4 = ((Iterator)localObject2).next();
          if ((localObject4 instanceof TroopGiftAioItemData))
          {
            localObject4 = (TroopGiftAioItemData)localObject4;
            paramJSONObject.put(Integer.valueOf(((TroopGiftAioItemData)localObject4).d), localObject4);
          }
        }
      }
      int i3;
      if ((localObject3 != null) && (((JSONArray)localObject3).length() > 0))
      {
        i2 = ((JSONArray)localObject3).length();
        this.h = new ArrayList(i2);
        i1 = 0;
        while (i1 < i2)
        {
          localObject2 = ((JSONArray)localObject3).optJSONObject(i1);
          if (localObject2 != null)
          {
            localObject2 = new TroopGiftAioPanelData.PersonalTabItemInfo((JSONObject)localObject2);
            this.h.add(localObject2);
            localObject4 = ((TroopGiftAioPanelData.PersonalTabItemInfo)localObject2).b.iterator();
            while (((Iterator)localObject4).hasNext())
            {
              i3 = ((Integer)((Iterator)localObject4).next()).intValue();
              if (paramJSONObject.containsKey(Integer.valueOf(i3))) {
                ((TroopGiftAioPanelData.PersonalTabItemInfo)localObject2).c.add(paramJSONObject.get(Integer.valueOf(i3)));
              }
            }
          }
          i1 += 1;
        }
      }
      if (localJSONArray2 != null)
      {
        i3 = localJSONArray2.length();
        if (this.g == null) {
          this.g = new ArrayList(i3);
        }
        i1 = 0;
        while (i1 < i3)
        {
          localObject2 = localJSONArray2.optJSONObject(i1);
          if (localObject2 != null)
          {
            localObject2 = new TroopGiftAioPanelData.PersonalTabItemInfo((JSONObject)localObject2);
            if ((!TextUtils.isEmpty(((TroopGiftAioPanelData.PersonalTabItemInfo)localObject2).a)) && (((TroopGiftAioPanelData.PersonalTabItemInfo)localObject2).b != null) && (((TroopGiftAioPanelData.PersonalTabItemInfo)localObject2).c != null))
            {
              localObject3 = ((TroopGiftAioPanelData.PersonalTabItemInfo)localObject2).b.iterator();
              while (((Iterator)localObject3).hasNext())
              {
                int i4 = ((Integer)((Iterator)localObject3).next()).intValue();
                if (paramJSONObject.containsKey(Integer.valueOf(i4)))
                {
                  if (localJSONArray1 != null)
                  {
                    int i6 = localJSONArray1.length();
                    i2 = 0;
                    while (i2 < i6)
                    {
                      localObject4 = localJSONArray1.optJSONObject(i2);
                      if (localObject4 != null)
                      {
                        int i5 = ((JSONObject)localObject4).optInt("packageID");
                        if ((((JSONObject)localObject4).optInt("giftType") == 0) && (i5 == i4)) {
                          try
                          {
                            localObject4 = new JSONArray(paramString);
                            i2 = 0;
                            while (i2 < ((JSONArray)localObject4).length())
                            {
                              i6 = ((Integer)((JSONArray)localObject4).get(i2)).intValue();
                              if (i6 == i5) {
                                break label1460;
                              }
                              i2 += 1;
                            }
                            i2 += 1;
                          }
                          catch (Exception localException)
                          {
                            if (QLog.isColorLevel()) {
                              QLog.e("TroopGiftAioPanelData", 2, "mergeExclusiveGift search exp:", localException);
                            }
                            i2 = 0;
                          }
                        }
                      }
                    }
                  }
                  label1460:
                  i2 = 1;
                  if (i2 != 0) {
                    ((TroopGiftAioPanelData.PersonalTabItemInfo)localObject2).c.add(paramJSONObject.get(Integer.valueOf(i4)));
                  }
                }
              }
              this.g.add(localObject2);
            }
          }
          i1 += 1;
        }
      }
      paramJSONObject = this.h;
      if ((paramJSONObject != null) && (paramJSONObject.size() > 0))
      {
        if (this.g == null) {
          this.g = new ArrayList();
        }
        paramJSONObject = this.h.iterator();
        i1 = 0;
        while (paramJSONObject.hasNext())
        {
          paramString = paramJSONObject.next();
          this.g.add(i1, paramString);
          i1 += 1;
        }
      }
      if (localObject1 != null)
      {
        i2 = ((JSONArray)localObject1).length();
        if (this.k == null) {
          this.k = new ArrayList(i2);
        }
        i1 = 0;
        while (i1 < i2)
        {
          paramJSONObject = ((JSONArray)localObject1).optJSONObject(i1);
          if (paramJSONObject != null)
          {
            paramJSONObject = new TroopGiftAioPanelData.WebPanelItemInfo(paramJSONObject);
            this.k.add(paramJSONObject);
          }
          i1 += 1;
        }
      }
      return;
    }
    catch (ParseException localParseException)
    {
      break label83;
    }
  }
  
  public static TroopGiftAioPanelData a(Context paramContext, int paramInt, String paramString)
  {
    long l1 = System.currentTimeMillis();
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
        paramContext = b(paramString);
        paramContext = new TroopGiftAioPanelData(localJSONObject, paramContext);
        if (QLog.isColorLevel())
        {
          paramString = new StringBuilder();
          paramString.append("getLocalGiftData, time=");
          paramString.append(System.currentTimeMillis() - l1);
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
  
  public static TroopGiftAioPanelData b(Context paramContext, int paramInt)
  {
    return a(paramContext, paramInt, "");
  }
  
  public static String b(String paramString)
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
  
  public static String b(List<oidb_0x6c3.ExclusiveGiftItem> paramList)
  {
    JSONArray localJSONArray = new JSONArray();
    if (paramList != null)
    {
      int i1 = 0;
      while (i1 < paramList.size())
      {
        localJSONArray.put(((oidb_0x6c3.ExclusiveGiftItem)paramList.get(i1)).gift_id.get());
        i1 += 1;
      }
    }
    return localJSONArray.toString();
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
  
  public static String c(String paramString)
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
  
  public void a(Context paramContext, int paramInt)
  {
    if (!TextUtils.isEmpty(this.r))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("troop_gift_aio_panel_data_v2_");
      localStringBuilder.append(paramInt);
      SharePreferenceUtils.a(paramContext, localStringBuilder.toString(), this.r);
    }
  }
  
  public void a(TroopGiftAioPanelData.EmptyPackagePage paramEmptyPackagePage)
  {
    this.x = paramEmptyPackagePage;
  }
  
  public void a(List<TroopGiftManager.GiveGift> paramList)
  {
    this.s.clear();
    int i1 = 0;
    while (i1 < paramList.size())
    {
      TroopGiftManager.GiveGift localGiveGift = (TroopGiftManager.GiveGift)paramList.get(i1);
      this.s.put(localGiveGift.a, localGiveGift);
      i1 += 1;
    }
  }
  
  protected void a(JSONArray paramJSONArray, String paramString)
  {
    ArrayList localArrayList2;
    ArrayList localArrayList1;
    int i3;
    int i1;
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
      i3 = 0;
      try
      {
        paramString = new JSONArray(paramString);
        int i2;
        if ((paramString.length() > 0) && (paramJSONArray.length() > 0))
        {
          i1 = 0;
          while (i1 < paramString.length())
          {
            int i4 = ((Integer)paramString.get(i1)).intValue();
            i2 = 0;
            while (i2 < paramJSONArray.length())
            {
              JSONObject localJSONObject = paramJSONArray.optJSONObject(i2);
              int i5 = localJSONObject.optInt("packageID");
              int i6 = localJSONObject.optInt("giftType");
              if (i4 == i5)
              {
                if (i6 == 0)
                {
                  localArrayList2.add(new TroopGiftAioItemData(localJSONObject, localArrayList2.size()));
                  break;
                }
                if (i6 != 1) {
                  break;
                }
                localArrayList1.add(new TroopGiftAioItemData(localJSONObject, localArrayList1.size()));
                break;
              }
              i2 += 1;
            }
            i1 += 1;
          }
        }
        try
        {
          if ((this.f != null) && (localArrayList2.size() > 0)) {
            i1 = localArrayList2.size() - 1;
          }
          while (i1 >= 0)
          {
            paramJSONArray = localArrayList2.get(i1);
            this.f.add(0, paramJSONArray);
            i1 -= 1;
            continue;
            while (i1 < this.f.size())
            {
              ((TroopGiftAioItemData)this.f.get(i1)).l = i1;
              i1 += 1;
            }
            if ((this.i != null) && (localArrayList1.size() > 0))
            {
              i1 = localArrayList1.size() - 1;
              for (;;)
              {
                i2 = i3;
                if (i1 < 0) {
                  break;
                }
                paramJSONArray = localArrayList1.get(i1);
                this.i.add(0, paramJSONArray);
                i1 -= 1;
              }
              while (i2 < this.i.size())
              {
                ((TroopGiftAioItemData)this.i.get(i2)).l = i2;
                i2 += 1;
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
      i1 = 0;
    }
  }
  
  public boolean a(int paramInt)
  {
    Object localObject = this.g;
    if ((localObject != null) && (this.h != null) && (paramInt >= 0) && (paramInt < ((ArrayList)localObject).size()) && (paramInt < this.h.size()) && ((this.g.get(paramInt) instanceof TroopGiftAioPanelData.PersonalTabItemInfo)))
    {
      localObject = (TroopGiftAioPanelData.PersonalTabItemInfo)this.g.get(paramInt);
      if ((this.h.get(paramInt) instanceof TroopGiftAioPanelData.PersonalTabItemInfo))
      {
        TroopGiftAioPanelData.PersonalTabItemInfo localPersonalTabItemInfo = (TroopGiftAioPanelData.PersonalTabItemInfo)this.h.get(paramInt);
        if ((localPersonalTabItemInfo.a != null) && (localPersonalTabItemInfo.a.equals(((TroopGiftAioPanelData.PersonalTabItemInfo)localObject).a))) {
          return true;
        }
      }
    }
    return false;
  }
  
  public void c(List<TroopGiftManager.PackGift> paramList)
  {
    this.w.clear();
    int i2 = 0;
    int i1 = 0;
    Object localObject;
    while (i1 < paramList.size())
    {
      localObject = (TroopGiftManager.PackGift)paramList.get(i1);
      this.w.put(((TroopGiftManager.PackGift)localObject).a, localObject);
      i1 += 1;
    }
    if (this.j != null)
    {
      paramList = new ArrayList();
      localObject = this.j;
      i1 = i2;
      if (localObject != null)
      {
        i1 = i2;
        if (((ArrayList)localObject).size() > 0)
        {
          i1 = 0;
          while (i1 < this.j.size())
          {
            localObject = (TroopGiftAioItemData)this.j.get(i1);
            if (this.w.get(((TroopGiftAioItemData)localObject).d) != null)
            {
              ((TroopGiftAioItemData)localObject).l = i1;
              paramList.add(localObject);
            }
            i1 += 1;
          }
          this.j.clear();
          this.j.addAll(paramList);
          paramList.clear();
          i1 = i2;
        }
      }
      while (i1 < this.j.size())
      {
        ((TroopGiftAioItemData)this.j.get(i1)).l = i1;
        i1 += 1;
      }
      i1 = this.j.size();
      i2 = this.q;
      if (i1 > i2) {
        ((TroopGiftAioItemData)this.j.get(i2)).k = true;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.troopgift.TroopGiftAioPanelData
 * JD-Core Version:    0.7.0.1
 */