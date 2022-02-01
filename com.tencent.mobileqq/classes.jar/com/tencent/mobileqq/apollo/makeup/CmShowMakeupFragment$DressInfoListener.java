package com.tencent.mobileqq.apollo.makeup;

import com.tencent.TMG.utils.QLog;
import com.tencent.aelight.camera.cmsshow.api.CmShowAssetsData;
import com.tencent.aelight.camera.cmsshow.api.CmShowDataWrapper;
import com.tencent.mobileqq.apollo.res.api.IApolloResManager.ApolloDressInfoListener;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class CmShowMakeupFragment$DressInfoListener
  implements IApolloResManager.ApolloDressInfoListener
{
  private final CmShowAssetsData jdField_a_of_type_ComTencentAelightCameraCmsshowApiCmShowAssetsData;
  private final CmShowDataWrapper jdField_a_of_type_ComTencentAelightCameraCmsshowApiCmShowDataWrapper;
  private final WeakReference<CmShowMakeupFragment> jdField_a_of_type_JavaLangRefWeakReference;
  
  private CmShowMakeupFragment$DressInfoListener(CmShowMakeupFragment paramCmShowMakeupFragment, CmShowAssetsData paramCmShowAssetsData, CmShowDataWrapper paramCmShowDataWrapper)
  {
    this.jdField_a_of_type_ComTencentAelightCameraCmsshowApiCmShowAssetsData = paramCmShowAssetsData;
    this.jdField_a_of_type_ComTencentAelightCameraCmsshowApiCmShowDataWrapper = paramCmShowDataWrapper;
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramCmShowMakeupFragment);
  }
  
  public void a(HashMap<Integer, String> paramHashMap, String paramString, int paramInt)
  {
    if (paramHashMap == null)
    {
      QLog.e("[cmshow]CmShowMakeupFragment", 1, "[updateCmsCameraDressList] onGetApolloDressInfo apolloDressInfo is null! ");
      return;
    }
    paramString = this.jdField_a_of_type_ComTencentAelightCameraCmsshowApiCmShowAssetsData;
    if (paramString != null)
    {
      paramString.b = this.jdField_a_of_type_ComTencentAelightCameraCmsshowApiCmShowDataWrapper.cmJsonString;
      paramString = this.jdField_a_of_type_ComTencentAelightCameraCmsshowApiCmShowDataWrapper.dressidMaps.entrySet().iterator();
      while (paramString.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)paramString.next();
        this.jdField_a_of_type_ComTencentAelightCameraCmsshowApiCmShowAssetsData.a.put(localEntry.getKey(), paramHashMap.get(localEntry.getValue()));
      }
      paramHashMap = (CmShowMakeupFragment)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (paramHashMap != null) {
        paramHashMap.a(this.jdField_a_of_type_ComTencentAelightCameraCmsshowApiCmShowAssetsData, 0);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.makeup.CmShowMakeupFragment.DressInfoListener
 * JD-Core Version:    0.7.0.1
 */