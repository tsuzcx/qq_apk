package com.tencent.filter;

import com.tencent.aekit.openrender.UniformParam.FloatParam;
import com.tencent.aekit.openrender.UniformParam.FloatsParam;
import com.tencent.aekit.openrender.UniformParam.Int1sParam;
import com.tencent.aekit.openrender.UniformParam.IntParam;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class ParamHelper
{
  private HashMap<String, ParamHelper.ParamGenerator> mCustom = new HashMap();
  private BaseFilter mFilter;
  private HashMap<String, ParamHelper.ParamInfo> mParams = new HashMap();
  
  public ParamHelper(BaseFilter paramBaseFilter)
  {
    this.mFilter = paramBaseFilter;
  }
  
  public ParamHelper addCustom(String paramString, ParamHelper.ParamGenerator paramParamGenerator)
  {
    this.mCustom.put(paramString, paramParamGenerator);
    return this;
  }
  
  public ParamHelper addParam(String paramString, ParamHelper.ParamType paramParamType)
  {
    return addParam(paramString, paramString, paramParamType);
  }
  
  public ParamHelper addParam(String paramString1, String paramString2, ParamHelper.ParamType paramParamType)
  {
    this.mParams.put(paramString1, new ParamHelper.ParamInfo(this, paramString2, paramParamType));
    return this;
  }
  
  public ParamHelper addParam(ArrayList<String> paramArrayList, ParamHelper.ParamType paramParamType)
  {
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      String str = (String)paramArrayList.next();
      this.mParams.put(str, new ParamHelper.ParamInfo(this, str, paramParamType));
    }
    return this;
  }
  
  public void processParams(HashMap<String, String> paramHashMap)
  {
    paramHashMap = paramHashMap.entrySet().iterator();
    while (paramHashMap.hasNext())
    {
      Object localObject2 = (Map.Entry)paramHashMap.next();
      Object localObject1;
      if (this.mCustom.keySet().contains(((Map.Entry)localObject2).getKey()))
      {
        localObject1 = (ParamHelper.ParamGenerator)this.mCustom.get(((Map.Entry)localObject2).getKey());
        if (localObject1 != null) {
          this.mFilter.addParam(((ParamHelper.ParamGenerator)localObject1).gen((String)((Map.Entry)localObject2).getKey()));
        }
      }
      else if (this.mParams.keySet().contains(((Map.Entry)localObject2).getKey()))
      {
        localObject1 = (ParamHelper.ParamInfo)this.mParams.get(((Map.Entry)localObject2).getKey());
        if (localObject1 != null)
        {
          int k = ParamHelper.1.$SwitchMap$com$tencent$filter$ParamHelper$ParamType[ParamHelper.ParamInfo.access$000(localObject1).ordinal()];
          if (k != 1)
          {
            if (k != 2)
            {
              int j = 0;
              int i = 0;
              Object localObject3;
              if (k != 3)
              {
                if (k == 4)
                {
                  localObject2 = ((String)((Map.Entry)localObject2).getValue()).split(",");
                  localObject3 = new int[localObject2.length];
                  while (i < localObject2.length)
                  {
                    localObject3[i] = Integer.parseInt(localObject2[i]);
                    i += 1;
                  }
                  this.mFilter.addParam(new UniformParam.Int1sParam(ParamHelper.ParamInfo.access$100((ParamHelper.ParamInfo)localObject1), (int[])localObject3));
                }
              }
              else
              {
                localObject2 = ((String)((Map.Entry)localObject2).getValue()).split(",");
                localObject3 = new float[localObject2.length];
                i = j;
                while (i < localObject2.length)
                {
                  localObject3[i] = Float.parseFloat(localObject2[i]);
                  i += 1;
                }
                this.mFilter.addParam(new UniformParam.FloatsParam(ParamHelper.ParamInfo.access$100((ParamHelper.ParamInfo)localObject1), (float[])localObject3));
              }
            }
            else
            {
              this.mFilter.addParam(new UniformParam.IntParam(ParamHelper.ParamInfo.access$100((ParamHelper.ParamInfo)localObject1), Integer.parseInt((String)((Map.Entry)localObject2).getValue())));
            }
          }
          else {
            this.mFilter.addParam(new UniformParam.FloatParam(ParamHelper.ParamInfo.access$100((ParamHelper.ParamInfo)localObject1), Float.parseFloat((String)((Map.Entry)localObject2).getValue())));
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.filter.ParamHelper
 * JD-Core Version:    0.7.0.1
 */