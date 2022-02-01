package com.tencent.aelight.camera.ae.camera.ui.poi;

import com.tencent.biz.qqstory.model.lbs.LbsManager.POIListRequestCallback;
import com.tencent.biz.qqstory.model.lbs.LbsManager.POIListRequestSession;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.tribe.data.TroopBarPOI;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;

class AESelectLocationFragment$4$1
  implements LbsManager.POIListRequestCallback
{
  AESelectLocationFragment$4$1(AESelectLocationFragment.4 param4) {}
  
  public void a(int paramInt, LbsManager.POIListRequestSession paramPOIListRequestSession, List<TroopBarPOI> paramList)
  {
    paramPOIListRequestSession = new ArrayList();
    if ((paramInt == 0) && (paramList != null))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        TroopBarPOI localTroopBarPOI = (TroopBarPOI)paramList.next();
        if (localTroopBarPOI != null) {
          paramPOIListRequestSession.add(new AESelectionLocationAdapter.LocationData(localTroopBarPOI.c, 0));
        }
      }
    }
    ThreadManager.getUIHandler().post(new AESelectLocationFragment.4.1.1(this, paramInt, paramPOIListRequestSession));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.poi.AESelectLocationFragment.4.1
 * JD-Core Version:    0.7.0.1
 */