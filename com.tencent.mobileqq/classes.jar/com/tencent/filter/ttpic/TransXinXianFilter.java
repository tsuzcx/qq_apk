package com.tencent.filter.ttpic;

import com.tencent.aekit.openrender.UniformParam.TextureBitmapParam;
import com.tencent.filter.BaseFilter;
import com.tencent.filter.art.BaibianFilter;
import com.tencent.ttpic.baseutils.bitmap.BitmapUtils;
import java.util.HashMap;
import java.util.Map;

public class TransXinXianFilter
  extends BaseFilter
{
  public TransXinXianFilter()
  {
    super("precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\ngl_FragColor = texture2D (inputImageTexture, textureCoordinate);\n}\n");
  }
  
  public void applyFilterChain(boolean paramBoolean, float paramFloat1, float paramFloat2)
  {
    BaibianFilter localBaibianFilter = new BaibianFilter(0, null, 0.3F, 0.5F, 0.0F, 0.12F, 0.02F);
    Object localObject = new HashMap();
    ((Map)localObject).put("intensity", Float.valueOf(0.65F));
    localBaibianFilter.setParameterDic((Map)localObject);
    setNextFilter(localBaibianFilter, null);
    localObject = new GPUImageLookupFilter();
    ((BaseFilter)localObject).addParam(new UniformParam.TextureBitmapParam("inputImageTexture2", BitmapUtils.decodeBitmap("filter/egWeizhidao1/eftXinxian/xinxian_lf.png"), 33986, true));
    localBaibianFilter.setNextFilter((BaseFilter)localObject, null);
    super.applyFilterChain(paramBoolean, paramFloat1, paramFloat2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.filter.ttpic.TransXinXianFilter
 * JD-Core Version:    0.7.0.1
 */