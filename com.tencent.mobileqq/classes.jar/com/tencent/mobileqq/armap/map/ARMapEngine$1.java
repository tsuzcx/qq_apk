package com.tencent.mobileqq.armap.map;

import com.tencent.mobileqq.armap.ARGLSurfaceView;
import com.tencent.mobileqq.armap.ARMapActivity;
import com.tencent.mobileqq.armap.ARMapCityData.IGetCityDataVersionCallback;

class ARMapEngine$1
  implements ARMapCityData.IGetCityDataVersionCallback
{
  ARMapEngine$1(ARMapEngine paramARMapEngine) {}
  
  public void onGetCityVerData(boolean paramBoolean, int[] paramArrayOfInt1, int[] paramArrayOfInt2, int paramInt)
  {
    if (paramBoolean) {
      this.this$0.mMapEngineCallback.mActivity.a.queueEvent(new ARMapEngine.1.1(this, paramArrayOfInt1, paramArrayOfInt2, paramInt));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.armap.map.ARMapEngine.1
 * JD-Core Version:    0.7.0.1
 */