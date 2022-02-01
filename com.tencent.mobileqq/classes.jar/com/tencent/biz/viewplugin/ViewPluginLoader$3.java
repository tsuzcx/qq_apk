package com.tencent.biz.viewplugin;

import android.text.TextUtils;
import com.tencent.biz.common.offline.AsyncBack;
import com.tencent.biz.common.offline.OfflineEnvHelper;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONArray;
import org.json.JSONObject;

class ViewPluginLoader$3
  implements AsyncBack
{
  ViewPluginLoader$3(ViewPluginLoader paramViewPluginLoader, QQAppInterface paramQQAppInterface) {}
  
  public void loaded(String paramString, int paramInt)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("checkUp loaded json = ");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(" code = ");
      ((StringBuilder)localObject).append(paramInt);
      QLog.d("ViewPluginLoader", 2, ((StringBuilder)localObject).toString());
    }
    if (paramInt == 0) {
      try
      {
        paramString = new JSONObject(paramString).optJSONArray("data").optJSONObject(0);
        localObject = paramString.optString("url");
        paramInt = paramString.optInt("filesize");
        if ((localObject != null) && (((String)localObject).endsWith("patch")))
        {
          paramString = new StringBuilder();
          paramString.append(OfflineEnvHelper.a(this.jdField_a_of_type_ComTencentBizViewpluginViewPluginLoader.a));
          paramString.append(this.jdField_a_of_type_ComTencentBizViewpluginViewPluginLoader.a);
          FileUtils.deleteDirectory(paramString.toString());
          this.jdField_a_of_type_ComTencentBizViewpluginViewPluginLoader.b();
          return;
        }
        if ((!TextUtils.isEmpty((CharSequence)localObject)) && (paramInt != 0))
        {
          this.jdField_a_of_type_ComTencentBizViewpluginViewPluginLoader.a(paramString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
          return;
        }
        this.jdField_a_of_type_ComTencentBizViewpluginViewPluginLoader.a();
        return;
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        this.jdField_a_of_type_ComTencentBizViewpluginViewPluginLoader.a();
        return;
      }
    }
    this.jdField_a_of_type_ComTencentBizViewpluginViewPluginLoader.a();
  }
  
  public void progress(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.viewplugin.ViewPluginLoader.3
 * JD-Core Version:    0.7.0.1
 */