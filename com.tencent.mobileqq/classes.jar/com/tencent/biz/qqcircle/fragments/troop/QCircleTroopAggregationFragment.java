package com.tencent.biz.qqcircle.fragments.troop;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import com.tencent.biz.qqcircle.bizparts.QCircleCommentPanelPart;
import com.tencent.biz.qqcircle.bizparts.QCircleLightInteractListPart;
import com.tencent.biz.qqcircle.bizparts.QCircleRichMediaDownLoadPart;
import com.tencent.biz.qqcircle.bizparts.QCircleSharePartV2;
import com.tencent.biz.qqcircle.bizparts.QCircleTaskCenterPart;
import com.tencent.biz.qqcircle.events.QCircleAtUpdateEvent;
import com.tencent.biz.qqcircle.fragments.QCircleBaseFragment;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.part.Part;
import cooperation.qqcircle.report.QCircleReportHelper;
import java.util.ArrayList;
import java.util.List;

public class QCircleTroopAggregationFragment
  extends QCircleBaseFragment
{
  public int a()
  {
    return 70;
  }
  
  protected void a(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.a(paramLayoutInflater, paramViewGroup, paramBundle);
  }
  
  public String b()
  {
    return "QCircleTroopAggregationFragment";
  }
  
  protected int c()
  {
    return 2131626981;
  }
  
  protected List<Part> d()
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = new QCircleTroopAggregationBodyPart(2131429353);
    ((QCircleTroopAggregationBodyPart)localObject).a(n());
    localArrayList.add(localObject);
    localObject = new QCircleLightInteractListPart();
    ((QCircleLightInteractListPart)localObject).a(n());
    localArrayList.add(localObject);
    localObject = new QCircleCommentPanelPart();
    ((QCircleCommentPanelPart)localObject).a(n());
    localArrayList.add(localObject);
    localObject = new QCircleTaskCenterPart();
    ((QCircleTaskCenterPart)localObject).a(n());
    localArrayList.add(localObject);
    localObject = new QCircleSharePartV2();
    ((QCircleSharePartV2)localObject).a(n());
    localArrayList.add(localObject);
    localArrayList.add(new QCircleRichMediaDownLoadPart());
    return localArrayList;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (257 == paramInt1) {
      SimpleEventBus.getInstance().dispatchEvent(new QCircleAtUpdateEvent(getContext(), paramIntent));
    }
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
  }
  
  public void onDetach()
  {
    super.onDetach();
  }
  
  public void onPause()
  {
    super.onPause();
    QCircleReportHelper.getInstance().recordPageEndShow(a(), g());
  }
  
  public void onResume()
  {
    super.onResume();
    QCircleReportHelper.getInstance().recordPageStartShow(a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.fragments.troop.QCircleTroopAggregationFragment
 * JD-Core Version:    0.7.0.1
 */