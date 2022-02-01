package com.tencent.comic.hippy.module;

import android.content.ActivityNotFoundException;
import android.text.TextUtils;
import androidx.collection.ArraySet;
import com.tencent.comic.utils.AppHelper;
import com.tencent.hippy.qq.module.QQBaseModule;
import com.tencent.mobileqq.bigbrother.TeleScreen;
import com.tencent.mobileqq.utils.PackageUtil;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.annotation.HippyMethod;
import com.tencent.mtt.hippy.annotation.HippyNativeModule;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.modules.Promise;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import org.json.JSONObject;

@HippyNativeModule(name="QQGdtModule")
public class QQGdtModule
  extends QQBaseModule
{
  static final String TAG = "QQGdtModule";
  private ArraySet<Integer> jumpCallbackIds = new ArraySet();
  
  public QQGdtModule(HippyEngineContext paramHippyEngineContext)
  {
    super(paramHippyEngineContext);
  }
  
  public void destroy()
  {
    super.destroy();
    Object localObject = this.jumpCallbackIds;
    if ((localObject != null) && (((ArraySet)localObject).size() > 0))
    {
      localObject = this.jumpCallbackIds.iterator();
      while (((Iterator)localObject).hasNext())
      {
        int i = ((Integer)((Iterator)localObject).next()).intValue();
        TeleScreen.a().a(i);
      }
      this.jumpCallbackIds.clear();
    }
  }
  
  @HippyMethod(name="Openlink")
  public void openLink(HippyMap paramHippyMap, Promise paramPromise)
  {
    if (paramHippyMap != null) {}
    try
    {
      paramHippyMap = paramHippyMap.toJSONObject();
      break label20;
      paramHippyMap = new JSONObject();
      label20:
      str1 = paramHippyMap.optString("businessId");
      str2 = paramHippyMap.optString("openlink");
      paramHippyMap = paramHippyMap.optString("packageName");
      QQGdtModule.1 local1 = new QQGdtModule.1(this, paramPromise);
      i = TeleScreen.a().a(local1);
      this.jumpCallbackIds.add(Integer.valueOf(i));
    }
    catch (Exception paramHippyMap)
    {
      String str1;
      String str2;
      int i;
      label117:
      QLog.e("QQGdtModule", 1, paramHippyMap, new Object[0]);
    }
    try
    {
      if (!TextUtils.isEmpty(str2))
      {
        AppHelper.a(getActivity(), str2, str1, i);
        return;
      }
      if (TextUtils.isEmpty(paramHippyMap)) {
        break label145;
      }
      PackageUtil.a(getActivity(), paramHippyMap, null, str1, i);
      return;
    }
    catch (ActivityNotFoundException paramHippyMap)
    {
      break label117;
    }
    paramPromise.resolve("{\"openresult\":-3}");
    TeleScreen.a().a(i);
    return;
    label145:
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.comic.hippy.module.QQGdtModule
 * JD-Core Version:    0.7.0.1
 */