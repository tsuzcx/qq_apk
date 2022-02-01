package com.tencent.biz.qqcircle.fragments;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import androidx.fragment.app.FragmentActivity;
import com.tencent.biz.qqcircle.QCirclePluginGlobalInfo;
import com.tencent.biz.qqcircle.adapter.QCircleInsFeedAdapter;
import com.tencent.biz.qqcircle.adapter.QCircleTagPageHeaderBlock;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.bizparts.QCircleCertifiedPart;
import com.tencent.biz.qqcircle.bizparts.QCircleCommentPanelPart;
import com.tencent.biz.qqcircle.bizparts.QCircleLightInteractListPart;
import com.tencent.biz.qqcircle.bizparts.QCirclePublishFeedPart;
import com.tencent.biz.qqcircle.bizparts.QCircleRichMediaDownLoadPart;
import com.tencent.biz.qqcircle.bizparts.QCircleSharePartV2;
import com.tencent.biz.qqcircle.bizparts.QCircleTagPageBodyPart;
import com.tencent.biz.qqcircle.bizparts.QCircleTagPageTitleBarPart;
import com.tencent.biz.richframework.part.Part;
import cooperation.qqcircle.report.QCircleLpReportDc05504;
import cooperation.qqcircle.report.QCircleLpReportDc05504.DataBuilder;
import cooperation.qqcircle.report.QCircleReportHelper;
import java.util.ArrayList;
import java.util.List;

public class QCircleTagPageFragment
  extends QCircleBaseFragment
{
  private List<Part> c;
  private QCircleInitBean d;
  
  private void u()
  {
    if (getActivity() == null) {
      return;
    }
    Intent localIntent = getActivity().getIntent();
    if ((localIntent != null) && (localIntent.hasExtra("key_bundle_common_init_bean"))) {
      this.d = ((QCircleInitBean)localIntent.getSerializableExtra("key_bundle_common_init_bean"));
    }
  }
  
  public int a()
  {
    return 31;
  }
  
  public String b()
  {
    return "QCircleTagPageFragment";
  }
  
  protected int c()
  {
    return 2131626970;
  }
  
  protected List<Part> d()
  {
    u();
    if (this.c == null)
    {
      this.c = new ArrayList();
      this.c.add(new QCircleTagPageTitleBarPart(this.d));
      Object localObject1 = new ArrayList();
      Object localObject2 = new QCircleTagPageHeaderBlock(null);
      ((QCircleTagPageHeaderBlock)localObject2).a(n());
      ((List)localObject1).add(localObject2);
      localObject2 = new QCircleInsFeedAdapter(new Bundle());
      ((QCircleInsFeedAdapter)localObject2).setReportBean(n());
      ((List)localObject1).add(localObject2);
      localObject1 = new QCircleTagPageBodyPart((List)localObject1, 3, 1);
      ((QCircleTagPageBodyPart)localObject1).a(this.d);
      this.c.add(localObject1);
      localObject1 = new QCircleSharePartV2();
      ((QCircleSharePartV2)localObject1).a(n());
      this.c.add(localObject1);
      localObject1 = new QCirclePublishFeedPart(QCirclePluginGlobalInfo.c());
      ((QCirclePublishFeedPart)localObject1).a(n());
      localObject2 = this.d;
      if ((localObject2 != null) && (((QCircleInitBean)localObject2).getTagInfo() != null)) {
        ((QCirclePublishFeedPart)localObject1).a(this.d.getTagInfo());
      }
      ((QCirclePublishFeedPart)localObject1).a(5);
      this.c.add(localObject1);
      localObject1 = new QCircleCertifiedPart();
      this.c.add(localObject1);
      ((QCircleCertifiedPart)localObject1).a(true);
      localObject1 = new QCircleLightInteractListPart();
      ((QCircleLightInteractListPart)localObject1).a(n());
      this.c.add(localObject1);
      localObject1 = new QCircleCommentPanelPart();
      ((QCircleCommentPanelPart)localObject1).a(n());
      this.c.add(localObject1);
      this.c.add(new QCircleRichMediaDownLoadPart());
    }
    return this.c;
  }
  
  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    getActivity().getWindow().setSoftInputMode(32);
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    QCircleLpReportDc05504.report(new QCircleLpReportDc05504.DataBuilder().setActionType(6).setSubActionType(1));
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
 * Qualified Name:     com.tencent.biz.qqcircle.fragments.QCircleTagPageFragment
 * JD-Core Version:    0.7.0.1
 */