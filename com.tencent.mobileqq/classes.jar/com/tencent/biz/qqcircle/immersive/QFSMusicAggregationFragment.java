package com.tencent.biz.qqcircle.immersive;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.MutableLiveData;
import com.tencent.biz.qqcircle.datacenter.QCircleFeedDataCenter;
import com.tencent.biz.qqcircle.immersive.aggregation.QFSMusicAggregationViewModel;
import com.tencent.biz.qqcircle.immersive.aggregation.adapter.QFSAggregationBottomBlock;
import com.tencent.biz.qqcircle.immersive.aggregation.adapter.QFSAggregationHeadMusicBlock;
import com.tencent.biz.qqcircle.immersive.aggregation.bean.QFSMusicAggregationInitBean;
import com.tencent.biz.qqcircle.immersive.aggregation.part.QFSAggregationPublishPart;
import com.tencent.biz.qqcircle.immersive.aggregation.part.QFSAggregationTitleViewPart;
import com.tencent.biz.qqcircle.immersive.part.QFSBaseBlockPart;
import com.tencent.biz.richframework.part.Part;
import com.tencent.biz.richframework.part.block.BlockContainer;
import com.tencent.biz.richframework.part.block.MultiViewBlock;
import com.tencent.biz.richframework.part.block.base.NestScrollRecyclerView;
import com.tencent.biz.richframework.util.RFWCompactUtil;
import com.tencent.mobileqq.pb.PBStringField;
import feedcloud.FeedCloudMeta.StFeedMusic;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class QFSMusicAggregationFragment
  extends QFSBaseFragment
{
  private QFSBaseBlockPart c;
  private QFSAggregationHeadMusicBlock d;
  private QFSAggregationTitleViewPart e;
  private QFSAggregationPublishPart f;
  private QFSMusicAggregationInitBean g;
  private QFSMusicAggregationViewModel h;
  private QFSAggregationBottomBlock i;
  
  private void a(Bundle paramBundle)
  {
    this.i = new QFSAggregationBottomBlock(paramBundle, this.g);
  }
  
  private void b(Bundle paramBundle)
  {
    this.d = new QFSAggregationHeadMusicBlock(paramBundle);
  }
  
  private void u()
  {
    if (getActivity() == null) {
      return;
    }
    Intent localIntent = getActivity().getIntent();
    if ((localIntent != null) && (localIntent.hasExtra("key_bundle_common_init_bean"))) {
      this.g = ((QFSMusicAggregationInitBean)localIntent.getSerializableExtra("key_bundle_common_init_bean"));
    }
  }
  
  private List<MultiViewBlock> w()
  {
    ArrayList localArrayList = new ArrayList();
    Bundle localBundle = new Bundle();
    b(localBundle);
    a(localBundle);
    localArrayList.add(this.d);
    localArrayList.add(this.i);
    return localArrayList;
  }
  
  private void x()
  {
    this.h = ((QFSMusicAggregationViewModel)a(QFSMusicAggregationViewModel.class));
    QCircleFeedDataCenter.a().a(this.h.f(), this.h);
    this.h.a(this.g);
    this.h.d().observe(this, new QFSMusicAggregationFragment.1(this));
    this.h.a(true);
  }
  
  private void y()
  {
    BlockContainer localBlockContainer = this.c.i();
    localBlockContainer.getRecyclerView().setTransDispatchDelegate(RFWCompactUtil.a());
    localBlockContainer.setParentFragment(this);
    localBlockContainer.setEnableRefresh(false);
    localBlockContainer.setEnableLoadMore(false);
  }
  
  public int a()
  {
    return 0;
  }
  
  protected void a(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.a(paramLayoutInflater, paramViewGroup, paramBundle);
    y();
  }
  
  public String b()
  {
    return "QFSAggregationFragment";
  }
  
  protected int c()
  {
    return 2131627112;
  }
  
  protected List<Part> d()
  {
    ArrayList localArrayList = new ArrayList();
    this.c = new QFSBaseBlockPart(2131433845, w(), 1, 1);
    localArrayList.add(this.c);
    this.e = new QFSAggregationTitleViewPart();
    localArrayList.add(this.e);
    this.f = new QFSAggregationPublishPart();
    localArrayList.add(this.f);
    return localArrayList;
  }
  
  protected Map<String, Object> e()
  {
    HashMap localHashMap = new HashMap();
    QFSMusicAggregationInitBean localQFSMusicAggregationInitBean = this.g;
    if ((localQFSMusicAggregationInitBean != null) && (localQFSMusicAggregationInitBean.getFeedMusic() != null))
    {
      localHashMap.put("xsj_material_type", "music");
      localHashMap.put("xsj_material_id", this.g.getFeedMusic().MID.get());
    }
    return localHashMap;
  }
  
  protected String f()
  {
    return "pg_xsj_music_agg_page";
  }
  
  public void onAttach(@NonNull Context paramContext)
  {
    super.onAttach(paramContext);
    u();
    x();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.immersive.QFSMusicAggregationFragment
 * JD-Core Version:    0.7.0.1
 */