package com.tencent.biz.qqcircle.immersive;

import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.beans.QCircleLayerBean;
import com.tencent.biz.qqcircle.bizparts.QCircleCommentPanelPart;
import com.tencent.biz.qqcircle.bizparts.QCircleLightInteractListPart;
import com.tencent.biz.qqcircle.bizparts.QCircleRichMediaDownLoadPart;
import com.tencent.biz.qqcircle.bizparts.QCircleSharePartV2;
import com.tencent.biz.qqcircle.immersive.part.QFSLayerBasePart;
import com.tencent.biz.qqcircle.immersive.part.QFSLayerPageBottomPart;
import com.tencent.biz.qqcircle.immersive.part.QFSLayerPageDetailPart;
import com.tencent.biz.qqcircle.immersive.part.QFSLayerPageListPart;
import com.tencent.biz.qqcircle.immersive.part.QFSLayerPageTitleViewPart;
import com.tencent.biz.richframework.part.Part;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class QFSLayerPageFragment
  extends QFSBaseFragment
{
  private QCircleLayerBean c;
  private QFSLayerBasePart d;
  private QFSLayerPageBottomPart e;
  private QFSLayerPageTitleViewPart f;
  private QCircleSharePartV2 g;
  private QCircleCommentPanelPart h;
  private QCircleLightInteractListPart i;
  private QCircleRichMediaDownLoadPart j;
  
  private QFSLayerBasePart u()
  {
    Object localObject = this.c;
    if (localObject == null)
    {
      QLog.e("QFSLayerPageFragment", 1, "initLayerPagePart  mInitBean == null");
      return null;
    }
    if (((QCircleLayerBean)localObject).isSingleFeed()) {
      localObject = new QFSLayerPageDetailPart(this.c);
    } else {
      localObject = new QFSLayerPageListPart(this.c);
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("initLayerPagePart  isSingleFeed = ");
    localStringBuilder.append(this.c.isSingleFeed());
    QLog.i("QFSLayerPageFragment", 1, localStringBuilder.toString());
    return localObject;
  }
  
  private void w()
  {
    if (getActivity() == null) {
      return;
    }
    Object localObject = getActivity().getIntent();
    if ((localObject != null) && (((Intent)localObject).hasExtra("key_bundle_common_init_bean")))
    {
      localObject = ((Intent)localObject).getSerializableExtra("key_bundle_common_init_bean");
      if ((localObject instanceof QCircleInitBean)) {
        this.c = ((QCircleLayerBean)localObject);
      }
    }
  }
  
  public int a()
  {
    return 57;
  }
  
  public String b()
  {
    return "QFSLayerPageFragment";
  }
  
  protected boolean bh_()
  {
    return true;
  }
  
  protected int c()
  {
    return 2131627141;
  }
  
  protected List<Part> d()
  {
    w();
    ArrayList localArrayList = new ArrayList();
    this.f = new QFSLayerPageTitleViewPart();
    localArrayList.add(this.f);
    this.e = new QFSLayerPageBottomPart();
    localArrayList.add(this.e);
    this.h = new QCircleCommentPanelPart();
    localArrayList.add(this.h);
    this.g = new QCircleSharePartV2();
    localArrayList.add(this.g);
    this.h.a(this);
    this.i = new QCircleLightInteractListPart();
    localArrayList.add(this.i);
    this.j = new QCircleRichMediaDownLoadPart();
    localArrayList.add(this.j);
    this.d = u();
    QFSLayerBasePart localQFSLayerBasePart = this.d;
    if (localQFSLayerBasePart != null) {
      localArrayList.add(localQFSLayerBasePart);
    }
    return localArrayList;
  }
  
  protected String f()
  {
    return "pg_xsj_layer_page";
  }
  
  protected int j()
  {
    return 0;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.immersive.QFSLayerPageFragment
 * JD-Core Version:    0.7.0.1
 */