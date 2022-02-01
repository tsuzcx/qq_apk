package com.tencent.hippy.qq.module;

import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.vas.api.IVasService;
import com.tencent.mobileqq.vas.hippy.VasHippyUtils;
import com.tencent.mobileqq.vas.treasurecard.VasFtCard;
import com.tencent.mobileqq.vas.treasurecard.api.IVasFTManager;
import com.tencent.mobileqq.vas.util.VasUtil;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.annotation.HippyMethod;
import com.tencent.mtt.hippy.annotation.HippyNativeModule;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.modules.Promise;
import mqq.app.AppRuntime;
import org.json.JSONObject;

@HippyNativeModule(name="QQTreasureCardModule")
public class QQTreasureCardModule
  extends QQBaseModule
{
  public static final String CLASSNAME = "QQTreasureCardModule";
  private static final String METHOD_FREE_TRAFFIC_CARD_MODEL = "freeTrafficCardModel";
  
  public QQTreasureCardModule(HippyEngineContext paramHippyEngineContext)
  {
    super(paramHippyEngineContext);
  }
  
  @HippyMethod(name="freeTrafficCardModel")
  public void freeTrafficCardModel(HippyMap paramHippyMap, Promise paramPromise)
  {
    paramHippyMap = paramHippyMap.getString("from");
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject != null) && (!TextUtils.isEmpty(paramHippyMap))) {}
    try
    {
      localObject = VasUtil.a((AppRuntime)localObject).getVasFtManager();
      JSONObject localJSONObject = ((IVasFTManager)localObject).obtainCardInfo(paramHippyMap).toJson();
      localJSONObject.put("cardStates", ((IVasFTManager)localObject).obtainCardState(paramHippyMap));
      paramPromise.resolve(VasHippyUtils.a(0, "success", localJSONObject).get("data"));
      return;
    }
    catch (Exception paramHippyMap)
    {
      label85:
      break label85;
    }
    paramPromise.reject(VasHippyUtils.a(-1, "handle json Exception", null));
    return;
    paramPromise.reject(VasHippyUtils.a(-1, "appRuntime is null", null));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.hippy.qq.module.QQTreasureCardModule
 * JD-Core Version:    0.7.0.1
 */