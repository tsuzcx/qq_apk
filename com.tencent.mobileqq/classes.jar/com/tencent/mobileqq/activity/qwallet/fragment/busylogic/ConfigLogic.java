package com.tencent.mobileqq.activity.qwallet.fragment.busylogic;

import android.util.SparseArray;
import com.tencent.mobileqq.activity.qwallet.config.QWalletConfigManager;
import com.tencent.mobileqq.activity.qwallet.fragment.WordChainHbFragment.WordChainTypeLabel;
import com.tencent.mobileqq.activity.qwallet.redpacket.PanelData;
import com.tencent.mobileqq.activity.qwallet.utils.QWalletTools;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.qphone.base.util.QLog;
import cooperation.qwallet.QwUtils;
import cooperation.qwallet.pluginshare.HbInfo.BundleInfo;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ConfigLogic
{
  private SparseArray<PanelData> a = new SparseArray();
  
  public ConfigLogic()
  {
    localObject = QWalletTools.a();
    JSONArray localJSONArray;
    if (localObject != null)
    {
      localJSONArray = ((QWalletConfigManager)((QQAppInterface)localObject).getManager(QQManagerFactory.QWALLET_CONFIG_MANAGER)).a("redPackPanel", new String[] { "panelRedPkgList" });
      if (localJSONArray != null) {
        break label63;
      }
      QLog.i("ConfigLogic", 2, "no pkg list...");
    }
    for (;;)
    {
      return;
      label63:
      localObject = null;
      int i = 0;
      while (i < localJSONArray.length())
      {
        try
        {
          JSONObject localJSONObject = localJSONArray.getJSONObject(i);
          localObject = localJSONObject;
        }
        catch (JSONException localJSONException)
        {
          for (;;)
          {
            localJSONException.printStackTrace();
            continue;
            PanelData localPanelData = new PanelData();
            localPanelData.jdField_a_of_type_JavaLangString = ((JSONObject)localObject).optString("id", "");
            localPanelData.jdField_a_of_type_Int = ((JSONObject)localObject).optInt("type", -1);
            localPanelData.jdField_b_of_type_JavaLangString = ((JSONObject)localObject).optString("name", "");
            localPanelData.c = ((JSONObject)localObject).optString("icon_pic", "");
            localPanelData.jdField_a_of_type_OrgJsonJSONObject = ((JSONObject)localObject).optJSONObject("params");
            if (QLog.isColorLevel()) {
              QLog.i("ConfigLogic", 2, "panelData = " + localPanelData);
            }
            this.a.put(localPanelData.jdField_a_of_type_Int, localPanelData);
          }
        }
        if (localObject != null) {
          break label104;
        }
        i += 1;
      }
    }
  }
  
  public PanelData a(int paramInt1, int paramInt2)
  {
    paramInt2 = HbBusiUtils.a(paramInt1, paramInt2);
    QLog.i("ConfigLogic", 2, "channel: " + paramInt1 + ", type = " + paramInt2);
    return (PanelData)this.a.get(paramInt2);
  }
  
  public String a(int paramInt1, int paramInt2, String paramString)
  {
    Object localObject = a(paramInt1, paramInt2);
    String str = paramString;
    if (localObject != null)
    {
      str = paramString;
      if (((PanelData)localObject).jdField_a_of_type_OrgJsonJSONObject != null)
      {
        localObject = ((PanelData)localObject).jdField_a_of_type_OrgJsonJSONObject.optJSONArray("hint");
        QLog.i("ConfigLogic", 2, "channel: " + paramInt1 + ", hint array: " + localObject);
        str = paramString;
        if (localObject != null)
        {
          str = paramString;
          if (((JSONArray)localObject).length() > 0) {
            str = ((JSONArray)localObject).optString(0, paramString);
          }
        }
      }
    }
    return str;
  }
  
  public ArrayList<WordChainHbFragment.WordChainTypeLabel> a(int paramInt, HbInfo.BundleInfo paramBundleInfo)
  {
    int i = 2;
    if (paramBundleInfo != null) {
      i = QwUtils.a(paramBundleInfo.bus_type, 2);
    }
    paramBundleInfo = new ArrayList();
    Object localObject = a(paramInt, i);
    if ((localObject != null) && (((PanelData)localObject).jdField_a_of_type_OrgJsonJSONObject != null))
    {
      localObject = ((PanelData)localObject).jdField_a_of_type_OrgJsonJSONObject.optJSONArray("labels");
      if ((localObject != null) && (((JSONArray)localObject).length() > 0))
      {
        paramInt = 0;
        while (paramInt < ((JSONArray)localObject).length())
        {
          JSONObject localJSONObject = ((JSONArray)localObject).optJSONObject(paramInt);
          WordChainHbFragment.WordChainTypeLabel localWordChainTypeLabel = new WordChainHbFragment.WordChainTypeLabel();
          localWordChainTypeLabel.jdField_a_of_type_JavaLangString = localJSONObject.optString("name");
          localWordChainTypeLabel.jdField_a_of_type_Int = localJSONObject.optInt("sub_channel");
          localWordChainTypeLabel.jdField_b_of_type_Int = localJSONObject.optInt("max_length", 0);
          localWordChainTypeLabel.jdField_b_of_type_JavaLangString = localJSONObject.optString("hint");
          paramBundleInfo.add(localWordChainTypeLabel);
          paramInt += 1;
        }
      }
    }
    return paramBundleInfo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.fragment.busylogic.ConfigLogic
 * JD-Core Version:    0.7.0.1
 */