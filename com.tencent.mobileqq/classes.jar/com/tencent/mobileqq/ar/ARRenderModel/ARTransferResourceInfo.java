package com.tencent.mobileqq.ar.ARRenderModel;

import com.tencent.mobileqq.ar.ARPromotion.ARTransferDoorConfigInfo.FragmentInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.Random;

public class ARTransferResourceInfo
  extends ARRenderResourceInfo
{
  public Boolean i;
  public Boolean j;
  public int k;
  public int l;
  public ArrayList<ARTransferDoorConfigInfo.FragmentInfo> m;
  public String n;
  public String o;
  
  public ARTransferResourceInfo(String paramString1, int paramInt1, int paramInt2, int paramInt3, float paramFloat1, float paramFloat2, float paramFloat3, String paramString2, String paramString3, ArrayList<ARTransferDoorConfigInfo.FragmentInfo> paramArrayList, Boolean paramBoolean1, Boolean paramBoolean2, int paramInt4, int paramInt5)
  {
    super(paramString1, paramInt1, 2, paramInt3, paramFloat1, paramFloat2, paramFloat3);
    paramString1 = Boolean.valueOf(false);
    this.i = paramString1;
    this.j = paramString1;
    this.k = 3;
    this.l = 1;
    this.m = new ArrayList();
    this.n = "";
    this.i = paramBoolean1;
    this.j = paramBoolean2;
    this.l = paramInt4;
    this.k = paramInt5;
    this.m = paramArrayList;
    this.n = paramString2;
    this.o = paramString3;
  }
  
  public ARTransferDoorConfigInfo.FragmentInfo a()
  {
    QLog.i("ARTransferResourceInfo", 2, "getTriggleUrlFromRandFunction");
    if (this.m.isEmpty()) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.m.iterator();
    while (localIterator.hasNext())
    {
      ARTransferDoorConfigInfo.FragmentInfo localFragmentInfo = (ARTransferDoorConfigInfo.FragmentInfo)localIterator.next();
      if (localFragmentInfo.e == 3) {
        localArrayList.add(localFragmentInfo);
      }
    }
    if (localArrayList.isEmpty()) {
      return null;
    }
    return (ARTransferDoorConfigInfo.FragmentInfo)localArrayList.get(new Random().nextInt(localArrayList.size()));
  }
  
  public boolean a(int paramInt)
  {
    if (this.m.isEmpty()) {
      return false;
    }
    Iterator localIterator = this.m.iterator();
    while (localIterator.hasNext()) {
      if (((ARTransferDoorConfigInfo.FragmentInfo)localIterator.next()).e == paramInt) {
        return true;
      }
    }
    return false;
  }
  
  public ARTransferDoorConfigInfo.FragmentInfo b(int paramInt)
  {
    QLog.i("ARTransferResourceInfo", 2, "getTriggleUrlFromClickOperation");
    if (this.m.isEmpty()) {
      return null;
    }
    Iterator localIterator = this.m.iterator();
    while (localIterator.hasNext())
    {
      ARTransferDoorConfigInfo.FragmentInfo localFragmentInfo = (ARTransferDoorConfigInfo.FragmentInfo)localIterator.next();
      if ((paramInt <= localFragmentInfo.g) && (paramInt >= localFragmentInfo.f) && (localFragmentInfo.e == 1)) {
        return localFragmentInfo;
      }
    }
    return null;
  }
  
  public String b()
  {
    if ((!this.m.isEmpty()) && (this.m.size() <= 1)) {
      return ((ARTransferDoorConfigInfo.FragmentInfo)this.m.get(0)).c;
    }
    return null;
  }
  
  public ARTransferDoorConfigInfo.FragmentInfo c()
  {
    QLog.i("ARTransferResourceInfo", 2, "getTriggleUrlFromTime");
    if (this.m.isEmpty()) {
      return null;
    }
    int i1 = Calendar.getInstance().get(11);
    Iterator localIterator = this.m.iterator();
    while (localIterator.hasNext())
    {
      ARTransferDoorConfigInfo.FragmentInfo localFragmentInfo = (ARTransferDoorConfigInfo.FragmentInfo)localIterator.next();
      if ((i1 < localFragmentInfo.g) && (i1 >= localFragmentInfo.f) && (localFragmentInfo.e == 2)) {
        return localFragmentInfo;
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARRenderModel.ARTransferResourceInfo
 * JD-Core Version:    0.7.0.1
 */