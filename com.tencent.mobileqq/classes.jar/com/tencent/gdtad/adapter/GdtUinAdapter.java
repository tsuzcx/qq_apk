package com.tencent.gdtad.adapter;

import com.tencent.ad.tangram.analysis.AdUinAdapter;
import com.tencent.common.app.BaseApplicationImpl;
import mqq.app.AppRuntime;

public class GdtUinAdapter
  implements AdUinAdapter
{
  public String getUIN()
  {
    Object localObject = BaseApplicationImpl.getApplication();
    if (localObject != null)
    {
      localObject = ((BaseApplicationImpl)localObject).getRuntime();
      if (localObject != null) {}
    }
    else
    {
      return null;
    }
    return ((AppRuntime)localObject).getAccount();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.gdtad.adapter.GdtUinAdapter
 * JD-Core Version:    0.7.0.1
 */