import com.tencent.mobileqq.apollo.makeup.CmShowMakeupHybirdFragment;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.filament.CmShowAssetsData;
import dov.com.qq.im.ae.cmshow.AECMShowRequestController.CmShowDataWrapper;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class amvc
  implements amod
{
  public amvc(CmShowMakeupHybirdFragment paramCmShowMakeupHybirdFragment, AECMShowRequestController.CmShowDataWrapper paramCmShowDataWrapper) {}
  
  public void onGetApolloDressInfo(HashMap<Integer, String> paramHashMap, String paramString, int paramInt)
  {
    if (paramHashMap == null) {
      QLog.e("CmShowMakeupHybirdFragment", 1, "[updateCmsCameraDressList] onGetApolloDressInfo apolloDressInfo is null! ");
    }
    while (CmShowMakeupHybirdFragment.a(this.jdField_a_of_type_ComTencentMobileqqApolloMakeupCmShowMakeupHybirdFragment) == null) {
      return;
    }
    CmShowMakeupHybirdFragment.a(this.jdField_a_of_type_ComTencentMobileqqApolloMakeupCmShowMakeupHybirdFragment).faceDataJsonStr = this.jdField_a_of_type_DovComQqImAeCmshowAECMShowRequestController$CmShowDataWrapper.cmJsonString;
    paramString = this.jdField_a_of_type_DovComQqImAeCmshowAECMShowRequestController$CmShowDataWrapper.dressidMaps.entrySet().iterator();
    while (paramString.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramString.next();
      CmShowMakeupHybirdFragment.a(this.jdField_a_of_type_ComTencentMobileqqApolloMakeupCmShowMakeupHybirdFragment).dressResMap.put(localEntry.getKey(), paramHashMap.get(localEntry.getValue()));
    }
    this.jdField_a_of_type_ComTencentMobileqqApolloMakeupCmShowMakeupHybirdFragment.a(CmShowMakeupHybirdFragment.a(this.jdField_a_of_type_ComTencentMobileqqApolloMakeupCmShowMakeupHybirdFragment), 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amvc
 * JD-Core Version:    0.7.0.1
 */