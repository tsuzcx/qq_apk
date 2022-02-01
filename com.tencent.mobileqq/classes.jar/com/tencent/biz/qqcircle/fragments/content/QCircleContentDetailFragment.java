package com.tencent.biz.qqcircle.fragments.content;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;
import com.tencent.biz.qqcircle.beans.QCircleExtraTypeInfo;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.bizparts.QCircleCommentPanelPart;
import com.tencent.biz.qqcircle.bizparts.QCircleContentDetailPublishFeedPart;
import com.tencent.biz.qqcircle.bizparts.QCircleRichMediaDownLoadPart;
import com.tencent.biz.qqcircle.bizparts.QCircleSharePartV2;
import com.tencent.biz.qqcircle.bizparts.QCircleTagHeaderPart;
import com.tencent.biz.qqcircle.bizparts.QCircleTaskCenterPart;
import com.tencent.biz.qqcircle.bizparts.danmaku.QCircleNewDanmakuPart;
import com.tencent.biz.qqcircle.fragments.QCircleBaseFragment;
import com.tencent.biz.qqcircle.utils.QCircleThemeUtil;
import com.tencent.biz.richframework.part.Part;
import com.tencent.qcircle.cooperation.config.QCircleConfigHelper;
import cooperation.qqcircle.helpers.QCircleSkinHelper;
import cooperation.qqcircle.report.QCircleReportBean;
import cooperation.qqcircle.report.QCircleReportHelper;
import feedcloud.FeedCloudMeta.StTagInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class QCircleContentDetailFragment
  extends QCircleBaseFragment
{
  private static final HashMap<Integer, Integer> d = new HashMap();
  private QCircleContentPart c;
  
  static
  {
    HashMap localHashMap = d;
    Integer localInteger = Integer.valueOf(1);
    localHashMap.put(localInteger, localInteger);
    d.put(Integer.valueOf(10), Integer.valueOf(3));
    d.put(Integer.valueOf(5), Integer.valueOf(91));
    d.put(Integer.valueOf(7), Integer.valueOf(71));
    localHashMap = d;
    localInteger = Integer.valueOf(32);
    localHashMap.put(Integer.valueOf(8), localInteger);
    d.put(Integer.valueOf(9), localInteger);
    d.put(Integer.valueOf(11), localInteger);
    d.put(Integer.valueOf(1002), Integer.valueOf(59));
    localHashMap = d;
    localInteger = Integer.valueOf(69);
    localHashMap.put(localInteger, localInteger);
    d.put(Integer.valueOf(12), Integer.valueOf(73));
    d.put(Integer.valueOf(13), Integer.valueOf(72));
  }
  
  private void u()
  {
    QCircleInitBean localQCircleInitBean = k();
    if (localQCircleInitBean != null)
    {
      Object localObject = localQCircleInitBean.getExtraTypeInfo();
      int j = 0;
      int i = j;
      if (localObject != null)
      {
        localObject = (Integer)d.get(Integer.valueOf(((QCircleExtraTypeInfo)localObject).sourceType));
        i = j;
        if (localObject != null) {
          i = ((Integer)localObject).intValue();
        }
      }
      if (localQCircleInitBean.getTagInfo().has()) {
        i = 71;
      }
      a(new QCircleReportBean().setPageId(57).setFromPageId(i));
    }
  }
  
  public int a()
  {
    return 57;
  }
  
  protected void a(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.a(paramLayoutInflater, paramViewGroup, paramBundle);
    QCircleThemeUtil.a(getActivity(), QCircleSkinHelper.getInstance().getColor(2131167060));
  }
  
  public String b()
  {
    return "QCircleContentDetailFragment";
  }
  
  public boolean bh_()
  {
    return false;
  }
  
  protected int c()
  {
    return 2131626781;
  }
  
  protected List<Part> d()
  {
    ArrayList localArrayList = new ArrayList();
    this.c = new QCircleContentPart();
    this.c.a(n());
    localArrayList.add(this.c);
    Object localObject = new QCircleSharePartV2();
    ((QCircleSharePartV2)localObject).a(n());
    localArrayList.add(localObject);
    localArrayList.add(new QCircleRichMediaDownLoadPart());
    if (QCircleConfigHelper.s())
    {
      localObject = new QCircleNewDanmakuPart();
      ((QCircleNewDanmakuPart)localObject).a(n());
      localArrayList.add(localObject);
    }
    localObject = new QCircleTaskCenterPart();
    ((QCircleTaskCenterPart)localObject).a(n());
    localArrayList.add(localObject);
    localObject = new QCircleCommentPanelPart();
    ((QCircleCommentPanelPart)localObject).a(n());
    localArrayList.add(localObject);
    localObject = (QCircleInitBean)getActivity().getIntent().getSerializableExtra("key_bundle_common_init_bean");
    if ((localObject != null) && (((QCircleInitBean)localObject).getTagInfo().has()))
    {
      localObject = new QCircleTagHeaderPart();
      ((QCircleTagHeaderPart)localObject).a(n());
      localArrayList.add(localObject);
    }
    localObject = new QCircleContentDetailPublishFeedPart();
    ((QCircleContentDetailPublishFeedPart)localObject).a(n());
    localArrayList.add(localObject);
    return localArrayList;
  }
  
  protected String f()
  {
    return "pg_xsj_layer_page";
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  protected int j()
  {
    return getResources().getColor(2131168376);
  }
  
  public void m() {}
  
  public QCircleReportBean n()
  {
    if (this.a == null)
    {
      this.a = new QCircleReportBean();
      this.a.setPageId(a()).setFromPageId(-1);
    }
    o();
    return this.a;
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    u();
  }
  
  public boolean onBackEvent()
  {
    if (super.onBackEvent()) {
      return true;
    }
    QCircleContentPart localQCircleContentPart = this.c;
    if (localQCircleContentPart != null) {
      localQCircleContentPart.a(0.0F, 0.0F);
    }
    return true;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
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
    QCircleThemeUtil.a(getActivity(), QCircleSkinHelper.getInstance().getColor(2131167060));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.fragments.content.QCircleContentDetailFragment
 * JD-Core Version:    0.7.0.1
 */