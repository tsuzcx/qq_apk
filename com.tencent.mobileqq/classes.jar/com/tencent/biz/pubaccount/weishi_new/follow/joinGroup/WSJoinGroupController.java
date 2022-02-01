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
  private static final int g = ViewUtils.dpToPx(1.0F);
  private static final int h = ViewUtils.dpToPx(14.0F);
  private RelativeLayout i;
  private RoundImageView j;
  private TextView k;
  private WSFollowFeedHolder l;
  private Activity m = null;
  
  public WSJoinGroupController(Context paramContext, WSFollowFeedHolder paramWSFollowFeedHolder)
  {
    super(paramContext);
    if ((paramContext instanceof Activity)) {
      this.m = ((Activity)paramContext);
    }
    this.l = paramWSFollowFeedHolder;
  }
  
  private void m()
  {
    if (this.m != null)
    {
      Object localObject = this.l;
      if (localObject == null) {
        return;
      }
      ((WSFollowFeedHolder)localObject).b();
      localObject = new BottomDialog(this.m);
      GroupDlgView localGroupDlgView = new GroupDlgView(this.m, this.l);
      ((BottomDialog)localObject).setContentView(localGroupDlgView);
      localGroupDlgView.a(a(this.l.i()));
      ((BottomDialog)localObject).show();
      this.l.a();
    }
  }
  
  public List<GroupEntity> a(stFeed paramstFeed)
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramstFeed != null) && (paramstFeed.feed != null) && (paramstFeed.feed.qqGroups != null) && (paramstFeed.feed.qqGroups.size() > 0))
    {
      int n = 0;
      while (n < paramstFeed.feed.qqGroups.size())
      {
        stQQGroupInfo localstQQGroupInfo = (stQQGroupInfo)paramstFeed.feed.qqGroups.get(n);
        localArrayList.add(new GroupEntity(localstQQGroupInfo.groupAvatar, localstQQGroupInfo.groupName, localstQQGroupInfo.groupCode, localstQQGroupInfo.groupAuth));
        n += 1;
      }
    }
    return localArrayList;
  }
  
  protected void a() {}
  
  protected void b() {}
  
  protected void f() {}
  
  protected int i()
  {
    return 2131626461;
  }
  
  protected void j()
  {
    this.i = ((RelativeLayout)c(2131436026));
    this.j = ((RoundImageView)c(2131436024));
    this.k = ((TextView)c(2131436025));
    Drawable localDrawable = e().getDrawable(2130843724);
    int n = h;
    localDrawable.setBounds(new Rect(0, 0, n, n));
    this.k.setCompoundDrawablePadding(g);
    this.k.setCompoundDrawables(null, null, localDrawable, null);
    this.i.setOnClickListener(new WSJoinGroupController.1(this));
  }
  
  public void l()
  {
    stFeed localstFeed = this.l.i();
    Activity localActivity = this.m;
    if ((localActivity != null) && (!localActivity.isFinishing()) && (localstFeed != null) && (localstFeed.feed != null) && (localstFeed.feed.qqGroups != null) && (localstFeed.feed.qqGroups.size() > 0)) {
      WSPicLoader.a().a(this.m, this.j, ((stQQGroupInfo)localstFeed.feed.qqGroups.get(0)).groupAvatar);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.follow.joinGroup.WSJoinGroupController
 * JD-Core Version:    0.7.0.1
 */