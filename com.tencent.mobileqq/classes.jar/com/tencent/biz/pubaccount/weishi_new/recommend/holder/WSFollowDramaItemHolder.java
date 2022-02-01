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
  private RoundCornerImageView a;
  private View b;
  private TextView c;
  private TextView d;
  private TextView e;
  
  public WSFollowDramaItemHolder(View paramView)
  {
    super(paramView);
    this.a = ((RoundCornerImageView)paramView.findViewById(2131444884));
    this.a.setCorner(WeishiUIUtil.u, 0);
    this.b = paramView.findViewById(2131448413);
    this.c = ((TextView)paramView.findViewById(2131448412));
    this.d = ((TextView)paramView.findViewById(2131448411));
    this.e = ((TextView)paramView.findViewById(2131448414));
  }
  
  @NonNull
  private static String b(@NonNull WSFollowDramaItemData paramWSFollowDramaItemData)
  {
    int i = paramWSFollowDramaItemData.e();
    if (i == 0) {
      return WSFeedUtils.e(2131918104);
    }
    return WSFeedUtils.a(2131918106, new Object[] { Integer.valueOf(i) });
  }
  
  @NonNull
  private static String c(@NonNull WSFollowDramaItemData paramWSFollowDramaItemData)
  {
    if (paramWSFollowDramaItemData.g()) {
      return WSFeedUtils.a(2131918102, new Object[] { Integer.valueOf(paramWSFollowDramaItemData.f()) });
    }
    return WSFeedUtils.a(2131918105, new Object[] { Integer.valueOf(paramWSFollowDramaItemData.f()) });
  }
  
  public void a(WSFollowDramaItemData paramWSFollowDramaItemData)
  {
    WSPicLoader.a().a(getContext(), this.a, paramWSFollowDramaItemData.b(), null);
    View localView = this.b;
    int i;
    if (paramWSFollowDramaItemData.c()) {
      i = 0;
    } else {
      i = 8;
    }
    localView.setVisibility(i);
    this.c.setText(paramWSFollowDramaItemData.d());
    this.d.setText(c(paramWSFollowDramaItemData));
    this.e.setText(b(paramWSFollowDramaItemData));
    this.itemView.setTag(paramWSFollowDramaItemData.a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.recommend.holder.WSFollowDramaItemHolder
 * JD-Core Version:    0.7.0.1
 */