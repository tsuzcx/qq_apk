package com.tencent.biz.pubaccount.weishi_new.recommendfollow;

import UserGrowth.stFeed;
import UserGrowth.stSimpleMetaPerson;
import android.content.Context;
import android.view.ViewGroup;
import com.tencent.biz.pubaccount.weishi_new.WSFollowAdapter;
import com.tencent.biz.pubaccount.weishi_new.WSFollowFragment;
import com.tencent.biz.pubaccount.weishi_new.data.WSUserBusiness;
import com.tencent.biz.pubaccount.weishi_new.util.WSFeedUtils;
import com.tencent.open.base.ToastUtil;
import com.tencent.widget.pull2refresh.BaseAdapter;
import com.tencent.widget.pull2refresh.BaseViewHolder;
import java.util.List;

public class WSRecommendFollowAdapter
  extends BaseAdapter<stSimpleMetaPerson, BaseViewHolder<stSimpleMetaPerson>>
  implements WSRecommendFollowListener
{
  private WSFollowAdapter a;
  private stFeed b;
  
  public WSRecommendFollowAdapter(Context paramContext, WSFollowAdapter paramWSFollowAdapter)
  {
    super(paramContext);
    this.a = paramWSFollowAdapter;
  }
  
  public void a(stFeed paramstFeed)
  {
    this.b = paramstFeed;
  }
  
  public void a(stSimpleMetaPerson paramstSimpleMetaPerson)
  {
    WSUserBusiness.a().a(paramstSimpleMetaPerson.id);
    removeItem(paramstSimpleMetaPerson);
    paramstSimpleMetaPerson = getDataList();
    if ((paramstSimpleMetaPerson == null) || (paramstSimpleMetaPerson.size() == 0)) {
      this.a.removeItem(this.b);
    }
    ToastUtil.a().a(2131918101);
  }
  
  public void a(BaseViewHolder<stSimpleMetaPerson> paramBaseViewHolder)
  {
    super.onViewAttachedToWindow(paramBaseViewHolder);
    if ((paramBaseViewHolder instanceof WSRecommendFollowHolder))
    {
      WSFollowAdapter localWSFollowAdapter = this.a;
      if ((localWSFollowAdapter != null) && (localWSFollowAdapter.g().getUserVisibleHint())) {
        ((WSRecommendFollowHolder)paramBaseViewHolder).c();
      }
    }
  }
  
  public void b(stSimpleMetaPerson paramstSimpleMetaPerson)
  {
    WSFeedUtils.a(this.a.f(), paramstSimpleMetaPerson.avatarSchema, 702, paramstSimpleMetaPerson);
  }
  
  public int getCustomItemViewType(int paramInt)
  {
    return 0;
  }
  
  public void onBindCustomViewHolder(BaseViewHolder<stSimpleMetaPerson> paramBaseViewHolder, int paramInt)
  {
    stSimpleMetaPerson localstSimpleMetaPerson = (stSimpleMetaPerson)getItem(paramInt);
    if (localstSimpleMetaPerson == null) {
      return;
    }
    if ((paramBaseViewHolder instanceof WSRecommendFollowHolder)) {
      ((WSRecommendFollowHolder)paramBaseViewHolder).a(localstSimpleMetaPerson, paramInt);
    }
  }
  
  public BaseViewHolder<stSimpleMetaPerson> onCreateCustomViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    return WSRecommendFollowHolder.a(paramViewGroup, this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.recommendfollow.WSRecommendFollowAdapter
 * JD-Core Version:    0.7.0.1
 */