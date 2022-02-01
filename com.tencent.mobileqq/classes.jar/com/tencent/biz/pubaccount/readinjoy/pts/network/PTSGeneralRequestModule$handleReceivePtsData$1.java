package com.tencent.biz.pubaccount.readinjoy.pts.network;

import com.tencent.pts.core.PTSComposer;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class PTSGeneralRequestModule$handleReceivePtsData$1
  implements Runnable
{
  PTSGeneralRequestModule$handleReceivePtsData$1(PTSComposer paramPTSComposer, String paramString) {}
  
  public final void run()
  {
    PTSComposer localPTSComposer = this.jdField_a_of_type_ComTencentPtsCorePTSComposer;
    if (localPTSComposer != null) {
      localPTSComposer.updateData(this.jdField_a_of_type_JavaLangString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.pts.network.PTSGeneralRequestModule.handleReceivePtsData.1
 * JD-Core Version:    0.7.0.1
 */