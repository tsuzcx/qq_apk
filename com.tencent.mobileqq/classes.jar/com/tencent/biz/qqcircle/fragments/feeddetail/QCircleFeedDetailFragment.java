package com.tencent.biz.qqcircle.fragments.feeddetail;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.tencent.biz.qqcircle.events.QCircleAtUpdateEvent;
import com.tencent.biz.qqcircle.fragments.QCircleBaseFragment;
import java.util.ArrayList;
import java.util.List;
import vab;
import vbt;
import vdc;
import vde;
import vec;
import vll;
import zwp;
import zxj;

public class QCircleFeedDetailFragment
  extends QCircleBaseFragment
{
  public int a()
  {
    return 2131560690;
  }
  
  public List<zxj> a()
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = new vll(2131363320);
    ((vll)localObject).a(a());
    localArrayList.add(localObject);
    localObject = new vbt();
    ((vbt)localObject).a(a());
    localArrayList.add(localObject);
    localObject = new vab();
    ((vab)localObject).a(a());
    localArrayList.add(localObject);
    localObject = new vec();
    ((vec)localObject).a(a());
    localArrayList.add(localObject);
    localObject = new vde();
    ((vde)localObject).a(a());
    localArrayList.add(localObject);
    localArrayList.add(new vdc());
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
      zwp.a().a(new QCircleAtUpdateEvent(paramIntent));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqcircle.fragments.feeddetail.QCircleFeedDetailFragment
 * JD-Core Version:    0.7.0.1
 */