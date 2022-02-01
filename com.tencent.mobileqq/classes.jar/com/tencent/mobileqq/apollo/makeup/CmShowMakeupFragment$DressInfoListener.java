package com.tencent.mobileqq.apollo.makeup;

import com.tencent.TMG.utils.QLog;
import com.tencent.aelight.camera.cmsshow.api.CmShowAssetsData;
import com.tencent.aelight.camera.cmsshow.api.CmShowDataWrapper;
import com.tencent.mobileqq.cmshow.engine.resource.IApolloResManager.ApolloDressInfoListener;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class CmShowMakeupFragment$DressInfoListener
  implements IApolloResManager.ApolloDressInfoListener
{
  private final CmShowAssetsData a;
  private final CmShowDataWrapper b;
  private final WeakReference<CmShowMakeupFragment> c;
  
  private CmShowMakeupFragment$DressInfoListener(CmShowMakeupFragment paramCmShowMakeupFragment, CmShowAssetsData paramCmShowAssetsData, CmShowDataWrapper paramCmShowDataWrapper)
  {
    this.a = paramCmShowAssetsData;
    this.b = paramCmShowDataWrapper;
    this.c = new WeakReference(paramCmShowMakeupFragment);
  }
  
  public void a(HashMap<Integer, String> paramHashMap, String paramString, int paramInt)
  {
    if (paramHashMap == null)
    {
      QLog.e("[cmshow]CmShowMakeupFragment", 1, "[updateCmsCameraDressList] onGetApolloDressInfo apolloDressInfo is null! ");
      return;
    }
    paramString = this.a;
    if (paramString != null)
    {
      paramString.c = this.b.cmJsonString;
      paramString = this.b.dressidMaps.entrySet().iterator();
      while (paramString.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)paramString.next();
        this.a.b.put(localEntry.getKey(), paramHashMap.get(localEntry.getValue()));
      }
      paramHashMap = (CmShowMakeupFragment)this.c.get();
      if (paramHashMap != null) {
        paramHashMap.a(this.a, 0);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.makeup.CmShowMakeupFragment.DressInfoListener
 * JD-Core Version:    0.7.0.1
 */