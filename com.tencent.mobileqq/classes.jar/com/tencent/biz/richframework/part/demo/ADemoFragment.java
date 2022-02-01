package com.tencent.biz.richframework.part.demo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.tencent.biz.qqcircle.fragments.QCircleBaseFragment;
import com.tencent.biz.qqcircle.fragments.QCircleBlockContainer;
import com.tencent.biz.subscribe.baseUI.ExtraTypeInfo;
import java.util.ArrayList;
import java.util.List;
import zxi;
import zxj;
import zym;
import zyn;
import zyp;
import zyq;

public class ADemoFragment
  extends QCircleBaseFragment
{
  private zxi a()
  {
    Object localObject = new ArrayList();
    ((ArrayList)localObject).add(new zyn(new Bundle()));
    ((ArrayList)localObject).add(new zyp(new Bundle()));
    ((ArrayList)localObject).add(new zyq(new Bundle()));
    localObject = new zxi(0, (List)localObject, 3, 2);
    ((zxi)localObject).a().setEnableLoadMore(true);
    ((zxi)localObject).a().setEnableRefresh(true);
    ExtraTypeInfo localExtraTypeInfo = new ExtraTypeInfo();
    ((zxi)localObject).a().setExtraTypeInfo(localExtraTypeInfo);
    return localObject;
  }
  
  public int a()
  {
    return 0;
  }
  
  public List<zxj> a()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new zym());
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