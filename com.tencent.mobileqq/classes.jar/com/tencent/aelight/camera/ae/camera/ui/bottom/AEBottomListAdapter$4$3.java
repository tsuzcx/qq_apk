package com.tencent.aelight.camera.ae.camera.ui.bottom;

import com.tencent.aelight.camera.ae.data.AEMaterialMetaData;
import java.util.Map;

class AEBottomListAdapter$4$3
  implements Runnable
{
  AEBottomListAdapter$4$3(AEBottomListAdapter.4 param4, AEMaterialMetaData paramAEMaterialMetaData, int paramInt) {}
  
  public void run()
  {
    if (AEBottomListAdapter.h(this.c.a).get(this.a.m) != null)
    {
      if ((this.b < 100) && (!this.a.A) && (this.a.B))
      {
        ((AEBottomListAdapter.ViewHolder)AEBottomListAdapter.h(this.c.a).get(this.a.m)).a(1);
        return;
      }
      ((AEBottomListAdapter.ViewHolder)AEBottomListAdapter.h(this.c.a).get(this.a.m)).a(2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.bottom.AEBottomListAdapter.4.3
 * JD-Core Version:    0.7.0.1
 */