package com.tencent.biz.pubaccount.weishi_new.follow.joinGroup;

import UserGrowth.stFeed;
import UserGrowth.stQQGroupInfo;
import UserGrowth.stSimpleMetaFeed;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.weishi_new.baseui.AbsWsUIGroup;
import com.tencent.biz.pubaccount.weishi_new.holder.WSFollowFeedHolder;
import com.tencent.biz.pubaccount.weishi_new.image.WSPicLoader;
import com.tencent.biz.pubaccount.weishi_new.view.RoundImageView;
import com.tencent.mobileqq.utils.ViewUtils;
import java.util.ArrayList;
import java.util.List;

public class WSJoinGroupController
  extends AbsWsUIGroup
{
  private static final int d = ViewUtils.b(1.0F);
  private static final int e = ViewUtils.b(14.0F);
  private Activity jdField_a_of_type_AndroidAppActivity = null;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private WSFollowFeedHolder jdField_a_of_type_ComTencentBizPubaccountWeishi_newHolderWSFollowFeedHolder;
  private RoundImageView jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRoundImageView;
  
  public WSJoinGroupController(Context paramContext, WSFollowFeedHolder paramWSFollowFeedHolder)
  {
    super(paramContext);
    if ((paramContext instanceof Activity)) {
      this.jdField_a_of_type_AndroidAppActivity = ((Activity)paramContext);
    }
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newHolderWSFollowFeedHolder = paramWSFollowFeedHolder;
  }
  
  private void g()
  {
    if (this.jdField_a_of_type_AndroidAppActivity != null)
    {
      Object localObject = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newHolderWSFollowFeedHolder;
      if (localObject == null) {
        return;
      }
      ((WSFollowFeedHolder)localObject).b();
      localObject = new BottomDialog(this.jdField_a_of_type_AndroidAppActivity);
      GroupDlgView localGroupDlgView = new GroupDlgView(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newHolderWSFollowFeedHolder);
      ((BottomDialog)localObject).setContentView(localGroupDlgView);
      localGroupDlgView.a(a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newHolderWSFollowFeedHolder.a()));
      ((BottomDialog)localObject).show();
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newHolderWSFollowFeedHolder.a();
    }
  }
  
  public List<GroupEntity> a(stFeed paramstFeed)
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramstFeed != null) && (paramstFeed.feed != null) && (paramstFeed.feed.qqGroups != null) && (paramstFeed.feed.qqGroups.size() > 0))
    {
      int i = 0;
      while (i < paramstFeed.feed.qqGroups.size())
      {
        stQQGroupInfo localstQQGroupInfo = (stQQGroupInfo)paramstFeed.feed.qqGroups.get(i);
        localArrayList.add(new GroupEntity(localstQQGroupInfo.groupAvatar, localstQQGroupInfo.groupName, localstQQGroupInfo.groupCode, localstQQGroupInfo.groupAuth));
        i += 1;
      }
    }
    return localArrayList;
  }
  
  protected void a() {}
  
  protected int b()
  {
    return 2131560416;
  }
  
  protected void b() {}
  
  protected void c() {}
  
  protected void e()
  {
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)a(2131369063));
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRoundImageView = ((RoundImageView)a(2131369061));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)a(2131369062));
    Drawable localDrawable = a().getDrawable(2130842771);
    int i = e;
    localDrawable.setBounds(new Rect(0, 0, i, i));
    this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(d);
    this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawables(null, null, localDrawable, null);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(new WSJoinGroupController.1(this));
  }
  
  public void f()
  {
    stFeed localstFeed = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newHolderWSFollowFeedHolder.a();
    Activity localActivity = this.jdField_a_of_type_AndroidAppActivity;
    if ((localActivity != null) && (!localActivity.isFinishing()) && (localstFeed != null) && (localstFeed.feed != null) && (localstFeed.feed.qqGroups != null) && (localstFeed.feed.qqGroups.size() > 0)) {
      WSPicLoader.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRoundImageView, ((stQQGroupInfo)localstFeed.feed.qqGroups.get(0)).groupAvatar);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.follow.joinGroup.WSJoinGroupController
 * JD-Core Version:    0.7.0.1
 */