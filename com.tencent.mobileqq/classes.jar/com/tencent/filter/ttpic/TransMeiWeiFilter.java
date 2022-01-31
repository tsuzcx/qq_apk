package com.tencent.filter.ttpic;

import android.graphics.Bitmap;
import com.tencent.filter.BaseFilter;
import com.tencent.filter.GLSLRender;
import com.tencent.filter.Param.TextureBitmapParam;
import com.tencent.filter.art.BaibianFilter;
import com.tencent.view.FilterDefault;
import java.util.HashMap;
import java.util.Map;

public class TransMeiWeiFilter
  extends BaseFilter
{
  public TransMeiWeiFilter()
  {
    super(GLSLRender.FILTER_SHADER_NONE);
  }
  
  public void ApplyGLSLFilter(boolean paramBoolean, float paramFloat1, float paramFloat2)
  {
    BaibianFilter localBaibianFilter = new BaibianFilter(GLSLRender.FILTER_SHADER_NONE, null, 0.3F, 0.5F, 0.0F, 0.12F, 0.02F);
    Object localObject = new HashMap();
    ((Map)localObject).put("intensity", Float.valueOf(0.65F));
    localBaibianFilter.setParameterDic((Map)localObject);
    setNextFilter(localBaibianFilter, null);
    localObject = new GPUImageLookupFilter();
    boolean bool = FilterDefault.ENABLE＿ASSERT;
    FilterDefault.ENABLE＿ASSERT = true;
    Bitmap localBitmap = FilterDefault.decodeBitmap("filter/egWeizhidao/eftMeiwei/meiwei_lf.png");
    FilterDefault.ENABLE＿ASSERT = bool;
    ((BaseFilter)localObject).addParam(new Param.TextureBitmapParam("inputImageTexture2", localBitmap, 33986, true));
    localBaibianFilter.setNextFilter((BaseFilter)localObject, null);
    super.ApplyGLSLFilter(paramBoolean, paramFloat1, paramFloat2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.filter.ttpic.TransMeiWeiFilter
 * JD-Core Version:    0.7.0.1
 */