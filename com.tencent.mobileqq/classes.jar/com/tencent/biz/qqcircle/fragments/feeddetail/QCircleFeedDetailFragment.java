package com.tencent.biz.qqcircle.fragments.feeddetail;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.Window;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;
import com.tencent.biz.qqcircle.bizparts.QCircleCommentPanelPart;
import com.tencent.biz.qqcircle.bizparts.QCircleGoHomeButtonPart;
import com.tencent.biz.qqcircle.bizparts.QCircleLightInteractListPart;
import com.tencent.biz.qqcircle.bizparts.QCircleRichMediaDownLoadPart;
import com.tencent.biz.qqcircle.bizparts.QCircleSharePartV2;
import com.tencent.biz.qqcircle.bizparts.QCircleSplashTransitionPart;
import com.tencent.biz.qqcircle.bizparts.QCircleTaskCenterPart;
import com.tencent.biz.qqcircle.events.QCircleAtUpdateEvent;
import com.tencent.biz.qqcircle.fragments.QCircleBaseFragment;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.part.Part;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.report.QCircleReportHelper;
import java.util.ArrayList;
import java.util.List;

public class QCircleFeedDetailFragment
  extends QCircleBaseFragment
{
  public int a()
  {
    return 69;
  }
  
  protected void a(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.a(paramLayoutInflater, paramViewGroup, paramBundle);
    QLog.d("QCircleFeedDetailFragment", 1, new Object[] { "[doOnCreateView] hash code:", Integer.valueOf(hashCode()) });
  }
  
  public String b()
  {
    return "QCircleFeedDetailFragment";
  }
  
  protected int c()
  {
    return 2131626800;
  }
  
  protected List<Part> d()
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = new QCircleFeedDetailBodyPart(2131429353);
    ((QCircleFeedDetailBodyPart)localObject).a(n());
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
    localArrayList.add(new QCircleGoHomeButtonPart());
    localObject = new QCircleSplashTransitionPart();
    ((QCircleSplashTransitionPart)localObject).a(n());
    localArrayList.add(localObject);
    localObject = new QCircleSharePartV2();
    ((QCircleSharePartV2)localObject).a(n());
    localArrayList.add(localObject);
    localArrayList.add(new QCircleRichMediaDownLoadPart());
    return localArrayList;
  }
  
  protected String f()
  {
    return "pg_xsj_feed_details_and_rec";
  }
  
  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    getActivity().getWindow().setSoftInputMode(32);
    QLog.d("QCircleFeedDetailFragment", 1, new Object[] { "[onActivityCreated] hash code:", Integer.valueOf(hashCode()) });
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (257 == paramInt1)
    {
      paramIntent = new QCircleAtUpdateEvent(getContext(), paramIntent);
      SimpleEventBus.getInstance().dispatchEvent(paramIntent);
    }
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    QLog.d("QCircleFeedDetailFragment", 1, new Object[] { "[onAttach] hash code:", Integer.valueOf(hashCode()) });
  }
  
  public void onDetach()
  {
    super.onDetach();
    QLog.d("QCircleFeedDetailFragment", 1, new Object[] { "[onDetach] hash code:", Integer.valueOf(hashCode()) });
  }
  
  public void onPause()
  {
    super.onPause();
    QLog.d("QCircleFeedDetailFragment", 1, new Object[] { "[onPause] hash code:", Integer.valueOf(hashCode()) });
    QCircleReportHelper.getInstance().recordPageEndShow(a(), g());
  }
  
  public void onResume()
  {
    super.onResume();
    QLog.d("QCircleFeedDetailFragment", 1, new Object[] { "[onResume] hash code:", Integer.valueOf(hashCode()) });
    QCircleReportHelper.getInstance().recordPageStartShow(a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.fragments.feeddetail.QCircleFeedDetailFragment
 * JD-Core Version:    0.7.0.1
 */