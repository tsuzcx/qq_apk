package com.tencent.biz.qqcircle.fragments.feeddetail;

import aaak;
import aabe;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.tencent.biz.qqcircle.events.QCircleAtUpdateEvent;
import com.tencent.biz.qqcircle.fragments.QCircleBaseFragment;
import java.util.ArrayList;
import java.util.List;
import vbr;
import vdj;
import vfg;
import vfi;
import vgg;
import vnp;

public class QCircleFeedDetailFragment
  extends QCircleBaseFragment
{
  public int a()
  {
    return 2131560707;
  }
  
  public List<aabe> a()
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = new vnp(2131363344);
    ((vnp)localObject).a(a());
    localArrayList.add(localObject);
    localObject = new vdj();
    ((vdj)localObject).a(a());
    localArrayList.add(localObject);
    localObject = new vbr();
    ((vbr)localObject).a(a());
    localArrayList.add(localObject);
    localObject = new vgg();
    ((vgg)localObject).a(a());
    localArrayList.add(localObject);
    localObject = new vfi();
    ((vfi)localObject).a(a());
    localArrayList.add(localObject);
    localArrayList.add(new vfg());
    return localArrayList;
  }
  
  public void a(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.a(paramLayoutInflater, paramViewGroup, paramBundle);
  }
  
  public int c()
  {
    return 69;
  }
  
  public String c()
  {
    return "QCircleFeedDetailFragment";
  }
  
  public String d()
  {
    return null;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (37858 == paramInt1) {
      aaak.a().a(new QCircleAtUpdateEvent(paramIntent));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqcircle.fragments.feeddetail.QCircleFeedDetailFragment
 * JD-Core Version:    0.7.0.1
 */