package com.tencent.mobileqq.apollo.makeup;

import com.tencent.TMG.utils.QLog;
import com.tencent.mobileqq.apollo.api.res.IApolloResManager.ApolloDressInfoListener;
import dov.com.qq.im.ae.cmshow.AECMShowRequestController.CmShowDataWrapper;
import dov.com.qq.im.ae.sink.CmShowAssetsData;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class CmShowMakeupHybirdFragment$DressInfoListener
  implements IApolloResManager.ApolloDressInfoListener
{
  private final AECMShowRequestController.CmShowDataWrapper jdField_a_of_type_DovComQqImAeCmshowAECMShowRequestController$CmShowDataWrapper;
  private final CmShowAssetsData jdField_a_of_type_DovComQqImAeSinkCmShowAssetsData;
  private final WeakReference<CmShowMakeupHybirdFragment> jdField_a_of_type_JavaLangRefWeakReference;
  
  private CmShowMakeupHybirdFragment$DressInfoListener(CmShowMakeupHybirdFragment paramCmShowMakeupHybirdFragment, CmShowAssetsData paramCmShowAssetsData, AECMShowRequestController.CmShowDataWrapper paramCmShowDataWrapper)
  {
    this.jdField_a_of_type_DovComQqImAeSinkCmShowAssetsData = paramCmShowAssetsData;
    this.jdField_a_of_type_DovComQqImAeCmshowAECMShowRequestController$CmShowDataWrapper = paramCmShowDataWrapper;
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramCmShowMakeupHybirdFragment);
  }
  
  public void a(HashMap<Integer, String> paramHashMap, String paramString, int paramInt)
  {
    if (paramHashMap == null) {
      QLog.e("CmShowMakeupHybirdFragment", 1, "[updateCmsCameraDressList] onGetApolloDressInfo apolloDressInfo is null! ");
    }
    do
    {
      do
      {
        return;
      } while (this.jdField_a_of_type_DovComQqImAeSinkCmShowAssetsData == null);
      this.jdField_a_of_type_DovComQqImAeSinkCmShowAssetsData.b = this.jdField_a_of_type_DovComQqImAeCmshowAECMShowRequestController$CmShowDataWrapper.cmJsonString;
      paramString = this.jdField_a_of_type_DovComQqImAeCmshowAECMShowRequestController$CmShowDataWrapper.dressidMaps.entrySet().iterator();
      while (paramString.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)paramString.next();
        this.jdField_a_of_type_DovComQqImAeSinkCmShowAssetsData.a.put(localEntry.getKey(), paramHashMap.get(localEntry.getValue()));
      }
      paramHashMap = (CmShowMakeupHybirdFragment)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    } while (paramHashMap == null);
    paramHashMap.a(this.jdField_a_of_type_DovComQqImAeSinkCmShowAssetsData, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.makeup.CmShowMakeupHybirdFragment.DressInfoListener
 * JD-Core Version:    0.7.0.1
 */