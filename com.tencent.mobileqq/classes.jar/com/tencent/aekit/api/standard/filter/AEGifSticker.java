package com.tencent.aekit.api.standard.filter;

import android.graphics.PointF;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.aekit.plugin.core.AIAttr;
import com.tencent.aekit.plugin.core.AIAttrProvider;
import com.tencent.ttpic.openapi.PTFaceParam;
import java.util.List;
import java.util.Set;

public class AEGifSticker
{
  private AESimpleSticker aeSticker = null;
  
  public AEGifSticker(String paramString)
  {
    if (this.aeSticker != null) {
      this.aeSticker.clear();
    }
    this.aeSticker = new AESimpleSticker(paramString);
  }
  
  public void apply()
  {
    if (this.aeSticker != null) {
      this.aeSticker.apply();
    }
  }
  
  public void changeMaterial(String paramString)
  {
    if (this.aeSticker != null) {
      this.aeSticker.clear();
    }
    this.aeSticker = new AESimpleSticker(paramString);
    this.aeSticker.apply();
  }
  
  public void clear()
  {
    if (this.aeSticker != null) {
      this.aeSticker.clear();
    }
  }
  
  public Frame render(Frame paramFrame)
  {
    if (this.aeSticker == null) {
      return paramFrame;
    }
    Frame localFrame = this.aeSticker.render(paramFrame);
    if ((paramFrame != localFrame) && (!paramFrame.unlock())) {
      paramFrame.clear();
    }
    return localFrame;
  }
  
  public void updateFaceParams(List<List<PointF>> paramList, List<float[]> paramList1, Set<Integer> paramSet)
  {
    paramList = PTFaceParam.getEmptyFaceAttr(paramList, paramList1, paramSet);
    paramList1 = new AIAttr(new AIAttrProvider(null));
    paramList1.setFaceAttr(paramList);
    this.aeSticker.setFaceAttr(paramList);
    this.aeSticker.setAIAttr(paramList1);
  }
  
  public void updateVideoSize(int paramInt1, int paramInt2, double paramDouble)
  {
    if (this.aeSticker != null) {
      this.aeSticker.updateVideoSize(paramInt1, paramInt2, paramDouble);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.aekit.api.standard.filter.AEGifSticker
 * JD-Core Version:    0.7.0.1
 */