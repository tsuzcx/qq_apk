package com.tencent.aelight.camera.ae.camera.ui.bottom;

import com.tencent.aelight.camera.ae.data.AEMaterialMetaData;
import java.util.Map;

class AEBottomListAdapter$4$2
  implements Runnable
{
  AEBottomListAdapter$4$2(AEBottomListAdapter.4 param4, AEMaterialMetaData paramAEMaterialMetaData) {}
  
  public void run()
  {
    this.b.a.notifyDataSetChanged();
    if (AEBottomListAdapter.h(this.b.a).get(this.a.m) != null) {
      ((AEBottomListAdapter.ViewHolder)AEBottomListAdapter.h(this.b.a).get(this.a.m)).a(2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.bottom.AEBottomListAdapter.4.2
 * JD-Core Version:    0.7.0.1
 */