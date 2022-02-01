package com.tencent.biz.richframework.part.demo;

import aabd;
import aabe;
import aaci;
import aacj;
import aacl;
import aacm;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.tencent.biz.qqcircle.fragments.QCircleBaseFragment;
import com.tencent.biz.qqcircle.fragments.QCircleBlockContainer;
import com.tencent.biz.subscribe.baseUI.ExtraTypeInfo;
import java.util.ArrayList;
import java.util.List;

public class ADemoFragment
  extends QCircleBaseFragment
{
  private aabd a()
  {
    Object localObject = new ArrayList();
    ((ArrayList)localObject).add(new aacj(new Bundle()));
    ((ArrayList)localObject).add(new aacl(new Bundle()));
    ((ArrayList)localObject).add(new aacm(new Bundle()));
    localObject = new aabd(0, (List)localObject, 3, 2);
    ((aabd)localObject).a().setEnableLoadMore(true);
    ((aabd)localObject).a().setEnableRefresh(true);
    ExtraTypeInfo localExtraTypeInfo = new ExtraTypeInfo();
    ((aabd)localObject).a().setExtraTypeInfo(localExtraTypeInfo);
    return localObject;
  }
  
  public int a()
  {
    return 0;
  }
  
  public List<aabe> a()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new aaci());
    localArrayList.add(a());
    return localArrayList;
  }
  
  public void a(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.a(paramLayoutInflater, paramViewGroup, paramBundle);
  }
  
  public int c()
  {
    return 0;
  }
  
  public String c()
  {
    return "Demo";
  }
  
  public String d()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.richframework.part.demo.ADemoFragment
 * JD-Core Version:    0.7.0.1
 */