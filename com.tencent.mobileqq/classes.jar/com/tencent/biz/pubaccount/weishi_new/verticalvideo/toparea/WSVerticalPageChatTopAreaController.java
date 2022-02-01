package com.tencent.biz.pubaccount.weishi_new.verticalvideo.toparea;

import UserGrowth.stSimpleMetaFeed;
import android.content.Context;
import android.view.View;
import android.widget.RelativeLayout;
import com.tencent.biz.pubaccount.weishi_new.baseui.AbsWsUIGroup;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageFragment;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.utils.WSVerticalUtils;

public class WSVerticalPageChatTopAreaController
  extends AbsWsUIGroup<Object>
{
  private stSimpleMetaFeed jdField_a_of_type_UserGrowthStSimpleMetaFeed;
  private WSVerticalPageFragment jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment;
  
  public WSVerticalPageChatTopAreaController(Context paramContext, WSVerticalPageFragment paramWSVerticalPageFragment)
  {
    super(paramContext);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment = paramWSVerticalPageFragment;
  }
  
  public void a()
  {
    if ((a() != null) && ((a() instanceof stSimpleMetaFeed))) {
      this.jdField_a_of_type_UserGrowthStSimpleMetaFeed = ((stSimpleMetaFeed)a());
    }
  }
  
  public int b()
  {
    return 2131560127;
  }
  
  public void b() {}
  
  public void c() {}
  
  public void e()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment == null) {
      return;
    }
    RelativeLayout localRelativeLayout = (RelativeLayout)a(2131381213);
    WSVerticalUtils.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.getActivity(), localRelativeLayout);
    a(2131381214).setOnClickListener(new WSVerticalPageChatTopAreaController.1(this));
    a(2131381215).setOnClickListener(new WSVerticalPageChatTopAreaController.2(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.toparea.WSVerticalPageChatTopAreaController
 * JD-Core Version:    0.7.0.1
 */