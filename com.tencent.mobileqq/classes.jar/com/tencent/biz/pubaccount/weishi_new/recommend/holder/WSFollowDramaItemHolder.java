package com.tencent.biz.pubaccount.weishi_new.recommend.holder;

import android.support.annotation.NonNull;
import android.view.View;
import android.widget.TextView;
import com.tencent.biz.pubaccount.weishi_new.drama.data.WSFollowDramaItemData;
import com.tencent.biz.pubaccount.weishi_new.image.WSPicLoader;
import com.tencent.biz.pubaccount.weishi_new.util.WSFeedUtils;
import com.tencent.biz.pubaccount.weishi_new.util.WeishiUIUtil;
import com.tencent.biz.pubaccount.weishi_new.view.RoundCornerImageView;
import com.tencent.widget.pull2refresh.BaseViewHolder;

public class WSFollowDramaItemHolder
  extends BaseViewHolder<WSFollowDramaItemData>
{
  private View jdField_a_of_type_AndroidViewView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private RoundCornerImageView jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRoundCornerImageView;
  private TextView b;
  private TextView c;
  
  public WSFollowDramaItemHolder(View paramView)
  {
    super(paramView);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRoundCornerImageView = ((RoundCornerImageView)paramView.findViewById(2131376624));
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRoundCornerImageView.setCorner(WeishiUIUtil.s, 0);
    this.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131379641);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131379640));
    this.b = ((TextView)paramView.findViewById(2131379639));
    this.c = ((TextView)paramView.findViewById(2131379642));
  }
  
  @NonNull
  private static String a(@NonNull WSFollowDramaItemData paramWSFollowDramaItemData)
  {
    int i = paramWSFollowDramaItemData.a();
    if (i == 0) {
      return WSFeedUtils.b(2131720428);
    }
    return WSFeedUtils.a(2131720430, new Object[] { Integer.valueOf(i) });
  }
  
  @NonNull
  private static String b(@NonNull WSFollowDramaItemData paramWSFollowDramaItemData)
  {
    if (paramWSFollowDramaItemData.b()) {
      return WSFeedUtils.a(2131720426, new Object[] { Integer.valueOf(paramWSFollowDramaItemData.b()) });
    }
    return WSFeedUtils.a(2131720429, new Object[] { Integer.valueOf(paramWSFollowDramaItemData.b()) });
  }
  
  public void a(WSFollowDramaItemData paramWSFollowDramaItemData)
  {
    WSPicLoader.a(getContext(), this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRoundCornerImageView, paramWSFollowDramaItemData.b(), null);
    View localView = this.jdField_a_of_type_AndroidViewView;
    int i;
    if (paramWSFollowDramaItemData.a()) {
      i = 0;
    } else {
      i = 8;
    }
    localView.setVisibility(i);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramWSFollowDramaItemData.c());
    this.b.setText(b(paramWSFollowDramaItemData));
    this.c.setText(a(paramWSFollowDramaItemData));
    this.itemView.setTag(paramWSFollowDramaItemData.a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.recommend.holder.WSFollowDramaItemHolder
 * JD-Core Version:    0.7.0.1
 */