package com.tencent.biz.qqstory.storyHome.detail.view;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.boundaries.StoryApi;
import com.tencent.biz.qqstory.comment.StoryQQTextCacher;
import com.tencent.biz.qqstory.database.CommentEntry;
import com.tencent.biz.qqstory.model.QQStoryActivityManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.item.IFeedOwner;
import com.tencent.biz.qqstory.storyHome.QQStoryBaseActivity;
import com.tencent.biz.qqstory.storyHome.QQStoryMainActivity;
import com.tencent.biz.qqstory.storyHome.RequestDataListener;
import com.tencent.biz.qqstory.storyHome.atvideo.model.AtVideoTextWatcher;
import com.tencent.biz.qqstory.storyHome.detail.model.DetailFeedItem;
import com.tencent.biz.qqstory.storyHome.detail.model.cmment.DetailCommentHelper;
import com.tencent.biz.qqstory.storyHome.detail.view.segment.BannerProfileSegment;
import com.tencent.biz.qqstory.storyHome.detail.view.segment.DetailCommentSegment;
import com.tencent.biz.qqstory.storyHome.detail.view.segment.DetailDoubleTabSegment;
import com.tencent.biz.qqstory.storyHome.detail.view.segment.DetailInteractSegment;
import com.tencent.biz.qqstory.storyHome.detail.view.segment.DetailLikeListSegment;
import com.tencent.biz.qqstory.storyHome.detail.view.segment.DetailTagListSegment;
import com.tencent.biz.qqstory.storyHome.detail.view.segment.GeneralFeedProfileSegment;
import com.tencent.biz.qqstory.storyHome.detail.view.segment.ShareGroupFeedProfileSegment;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;
import com.tencent.biz.qqstory.storyHome.model.FeedManager;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.qqstory.troop.activity.TroopStoryMainActivity;
import com.tencent.biz.qqstory.utils.DateUtils;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.InputLinearLayout;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BaseFragment;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemClickListener;
import com.tencent.widget.AdapterView.OnItemLongClickListener;
import com.tencent.widget.XEditTextEx;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import mqq.os.MqqHandler;

public class StoryDetailFragment
  extends BaseFragment
  implements View.OnTouchListener, RequestDataListener, AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener
{
  public StoryDetailListView a;
  public DetailCommentHelper b;
  public FeedManager c;
  private String d;
  private int e;
  private boolean f;
  private int g;
  private String h;
  private int i;
  private int j;
  private DetailFeedItem k;
  private StoryDetailPresenter l;
  private RelativeLayout m;
  private TextView n;
  
  public static StoryDetailFragment a(String paramString1, int paramInt1, boolean paramBoolean, int paramInt2, String paramString2, int paramInt3, int paramInt4)
  {
    StoryDetailFragment localStoryDetailFragment = new StoryDetailFragment();
    Bundle localBundle = new Bundle();
    localBundle.putString("feed_id", paramString1);
    localBundle.putInt("source", paramInt1);
    localBundle.putBoolean("should_up_keyboard", paramBoolean);
    localBundle.putInt("focus_comment_id", paramInt2);
    localBundle.putString("focus_video_id", paramString2);
    localBundle.putInt("play_source", paramInt3);
    localBundle.putInt("focus_tab", paramInt4);
    localStoryDetailFragment.setArguments(localBundle);
    return localStoryDetailFragment;
  }
  
  private void a(String paramString, boolean paramBoolean)
  {
    if (StoryApi.a())
    {
      localIntent = new Intent(getBaseActivity(), SplashActivity.class);
      localIntent.putExtra("fragment_id", 1);
      localIntent.putExtra("main_tab_id", 6);
      localIntent.putExtra("open_now_tab_fragment", true);
      localIntent.putExtra("extra_from_share", true);
      localIntent.putExtra("new_video_extra_info", paramString);
      localIntent.setFlags(335544320);
      startActivity(localIntent);
      return;
    }
    Intent localIntent = new Intent(getBaseActivity(), QQStoryMainActivity.class);
    localIntent.putExtra("new_video_extra_info", paramString);
    if (paramBoolean) {
      localIntent.putExtra("selfSet_leftViewText", getBaseActivity().getString(2131887625));
    }
    startActivity(localIntent);
  }
  
  public void a()
  {
    this.h = null;
    this.g = -1;
    Map localMap = this.c.g;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("2_");
    localStringBuilder.append(this.d);
    localMap.remove(localStringBuilder.toString());
    this.l.a(false);
  }
  
  public void a(int paramInt)
  {
    StoryDetailListView localStoryDetailListView = this.a;
    localStoryDetailListView.setSelectionFromBottom(localStoryDetailListView.getCommentSegmentIndex() + paramInt, 0);
    SLog.b("Q.qqstory.detail.StoryDetailFragment", "scoll to the comment. position is %d.", Integer.valueOf(this.a.getCommentSegmentIndex() + paramInt));
  }
  
  public void a(DetailFeedItem paramDetailFeedItem, boolean paramBoolean)
  {
    SLog.b("Q.qqstory.detail.StoryDetailFragment", "update feed all info. %s.", paramDetailFeedItem.toString());
    this.k = paramDetailFeedItem;
    this.n.setVisibility(8);
    this.a.setVisibility(0);
    this.m.setVisibility(0);
    if (getBaseActivity() != null) {
      getBaseActivity().setTitle(b(paramDetailFeedItem.a.date));
    }
    if (this.b == null) {
      this.b = new DetailCommentHelper(getBaseActivity(), getView(), paramDetailFeedItem, true, this.e, this.l);
    }
    Object localObject = (GeneralFeedProfileSegment)this.a.b("GeneralFeedProfileSegment");
    ((GeneralFeedProfileSegment)localObject).a(paramDetailFeedItem);
    ((GeneralFeedProfileSegment)localObject).a(this.h);
    ((GeneralFeedProfileSegment)localObject).c(true);
    localObject = (ShareGroupFeedProfileSegment)this.a.b("ShareGroupFeedProfileSegment");
    ((ShareGroupFeedProfileSegment)localObject).a(paramDetailFeedItem);
    ((ShareGroupFeedProfileSegment)localObject).a(this.h);
    ((ShareGroupFeedProfileSegment)localObject).c(true);
    localObject = (BannerProfileSegment)this.a.b("BannerProfileSegment");
    ((BannerProfileSegment)localObject).a(paramDetailFeedItem);
    ((BannerProfileSegment)localObject).c(true);
    ((DetailInteractSegment)this.a.b("DetailInteractSegment")).a(paramDetailFeedItem, this.e, this.j);
    ((DetailDoubleTabSegment)this.a.b("DetailDoubleTabSegment")).a(paramDetailFeedItem, paramBoolean);
    ((DetailLikeListSegment)this.a.b("DetailLikeListSegment")).a(paramDetailFeedItem, paramBoolean);
    ((DetailCommentSegment)this.a.b("DetailCommentSegment")).a(paramDetailFeedItem, paramBoolean);
    ((DetailTagListSegment)this.a.b("DetailTagListSegment")).a(paramDetailFeedItem);
    this.a.q();
    localObject = paramDetailFeedItem.a(paramBoolean);
    if ((this.g != -1) && (localObject != null))
    {
      int i1 = 0;
      while (i1 < ((List)localObject).size())
      {
        if (((CommentEntry)((List)localObject).get(i1)).commentId == this.g)
        {
          a(i1);
          break;
        }
        i1 += 1;
      }
    }
    if (this.f)
    {
      this.f = false;
      getView().postDelayed(new StoryDetailFragment.2(this), 100);
      StoryReportor.a("home_page", "auto_reply", StoryReportor.a(paramDetailFeedItem.a), 0, new String[0]);
    }
  }
  
  public void a(String paramString)
  {
    this.h = paramString;
    ((GeneralFeedProfileSegment)this.a.b("GeneralFeedProfileSegment")).a(this.h);
    this.a.q();
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.a.a(paramBoolean1);
    this.a.setLoadMoreComplete("StoryDetailFragment", paramBoolean1, paramBoolean2 ^ true);
  }
  
  public String b(String paramString)
  {
    paramString = DateUtils.b(paramString);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString[1]);
    localStringBuilder.append(HardCodeUtil.a(2131911727));
    localStringBuilder.append(paramString[2]);
    localStringBuilder.append(HardCodeUtil.a(2131911726));
    return localStringBuilder.toString();
  }
  
  public void b()
  {
    SLog.c("Q.qqstory.detail.StoryDetailFragment", "show empty page.");
    this.n.setVisibility(8);
    this.m.setVisibility(8);
    this.a.setVisibility(0);
    this.a.setProfileSegmentDisplay(false);
    this.a.q();
  }
  
  public void b(DetailFeedItem paramDetailFeedItem, boolean paramBoolean)
  {
    ((DetailDoubleTabSegment)this.a.b("DetailDoubleTabSegment")).a(paramDetailFeedItem, paramBoolean);
    ((DetailLikeListSegment)this.a.b("DetailLikeListSegment")).a(paramDetailFeedItem, paramBoolean);
    ((DetailCommentSegment)this.a.b("DetailCommentSegment")).a(paramDetailFeedItem, paramBoolean);
    paramBoolean = c(paramDetailFeedItem, paramBoolean);
    this.a.setOnLoadMoreListener("StoryDetailFragment", new StoryDetailFragment.3(this));
    this.a.setLoadMoreComplete("StoryDetailFragment", true, paramBoolean ^ true);
    this.a.q();
  }
  
  public void c()
  {
    this.a.q();
  }
  
  public boolean c(DetailFeedItem paramDetailFeedItem, boolean paramBoolean)
  {
    boolean bool3 = this.a.b();
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (bool3)
    {
      bool1 = bool2;
      if (paramDetailFeedItem != null)
      {
        bool1 = bool2;
        if (!paramDetailFeedItem.b(paramBoolean))
        {
          if (paramDetailFeedItem.h(paramBoolean) != null) {
            return true;
          }
          bool1 = false;
        }
      }
    }
    return bool1;
  }
  
  public void d()
  {
    this.l.bo_();
  }
  
  public void e()
  {
    int i1 = this.a.getLastCommentPoi();
    this.a.setSelectionFromBottom(i1, 0);
    SLog.b("Q.qqstory.detail.StoryDetailFragment", "scoll to last comment. position is %d.", Integer.valueOf(i1));
  }
  
  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    paramBundle = this.c.g;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("2_");
    localStringBuilder.append(this.d);
    paramBundle.remove(localStringBuilder.toString());
    this.a.a(getBaseActivity());
    this.a.k();
    this.a.setRequestDataListener(this);
    this.a.setOnTouchListener(this);
    this.a.setOnLoadMoreListener("StoryDetailFragment", new StoryDetailFragment.1(this));
    this.a.setLoadMoreComplete("StoryDetailFragment", true, false);
    this.l = new StoryDetailPresenter(this, this.d, this.e, this.j);
    this.l.e();
    if (this.i != 0) {
      this.l.c(2);
    }
    this.l.a(true);
    this.a.setCallback(this.l);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt2 == -1)
    {
      if (paramInt1 != 1300) {
        if (paramInt1 != 10000)
        {
          if ((paramInt1 != 20000) && (paramInt1 != 20003)) {
            break label320;
          }
        }
        else
        {
          localObject1 = this.b;
          if (localObject1 == null) {
            break label320;
          }
          AtVideoTextWatcher.a(((DetailCommentHelper)localObject1).a, paramIntent);
          ThreadManager.getUIHandler().postDelayed(new StoryDetailFragment.4(this), 100L);
          break label320;
        }
      }
      localObject1 = paramIntent.getStringExtra("new_video_extra_info");
      int i1 = this.e;
      Object localObject2;
      if ((i1 != 211) && (i1 != 221))
      {
        if (this.j == 106)
        {
          localObject2 = (QQStoryActivityManager)SuperManager.a(18);
          if ((((QQStoryActivityManager)localObject2).c) && (((QQStoryActivityManager)localObject2).b != null))
          {
            Iterator localIterator = ((QQStoryActivityManager)localObject2).b.keySet().iterator();
            while (localIterator.hasNext())
            {
              Object localObject3 = (String)localIterator.next();
              localObject3 = (QQStoryBaseActivity)((WeakReference)((QQStoryActivityManager)localObject2).b.get(localObject3)).get();
              if ((localObject3 != null) && (getBaseActivity() != localObject3) && (!((QQStoryBaseActivity)localObject3).isFinishing())) {
                ((QQStoryBaseActivity)localObject3).finish();
              }
            }
          }
          a((String)localObject1, true);
        }
        else
        {
          a((String)localObject1, false);
        }
      }
      else
      {
        localObject2 = new Intent(getBaseActivity(), TroopStoryMainActivity.class);
        ((Intent)localObject2).putExtra("new_video_extra_info", (String)localObject1);
        ((Intent)localObject2).setFlags(335544320);
        startActivity((Intent)localObject2);
      }
      getBaseActivity().finish();
      getBaseActivity().overridePendingTransition(0, 0);
    }
    label320:
    Object localObject1 = this.a;
    if (localObject1 != null) {
      ((StoryDetailListView)localObject1).a(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = getArguments();
    if (paramBundle == null) {
      return;
    }
    this.d = paramBundle.getString("feed_id");
    this.e = paramBundle.getInt("source");
    this.j = paramBundle.getInt("play_source");
    this.f = paramBundle.getBoolean("should_up_keyboard");
    this.g = paramBundle.getInt("focus_comment_id", -1);
    this.h = paramBundle.getString("focus_video_id");
    this.i = paramBundle.getInt("focus_tab");
    this.c = ((FeedManager)SuperManager.a(11));
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramViewGroup = paramLayoutInflater.inflate(2131628023, paramViewGroup, false);
    this.m = ((RelativeLayout)paramViewGroup.findViewById(2131431280));
    if (QQStoryContext.e())
    {
      ((InputLinearLayout)paramViewGroup.findViewById(2131444638)).setBackgroundColor(paramLayoutInflater.getContext().getResources().getColor(2131167384));
      ((LinearLayout)paramViewGroup.findViewById(2131429671)).setBackgroundColor(paramLayoutInflater.getContext().getResources().getColor(2131167383));
      ((XEditTextEx)paramViewGroup.findViewById(2131432617)).setHintTextColor(paramLayoutInflater.getContext().getResources().getColor(2131167385));
      paramViewGroup.findViewById(2131432003).setBackgroundColor(paramLayoutInflater.getContext().getResources().getColor(2131167384));
    }
    this.n = ((TextView)paramViewGroup.findViewById(2131437664));
    this.a = ((StoryDetailListView)paramViewGroup.findViewById(2131431788));
    paramLayoutInflater = this.a;
    paramLayoutInflater.a = this.e;
    paramLayoutInflater.b = 0;
    AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, paramViewGroup);
    return paramViewGroup;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    Object localObject = this.a;
    if (localObject != null)
    {
      ((StoryDetailListView)localObject).m();
      this.a = null;
    }
    localObject = this.l;
    if (localObject != null)
    {
      ((StoryDetailPresenter)localObject).f();
      this.l = null;
    }
    localObject = this.b;
    if (localObject != null) {
      ((DetailCommentHelper)localObject).g();
    }
    localObject = this.c;
    if (localObject != null)
    {
      localObject = ((FeedManager)localObject).g;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("2_");
      localStringBuilder.append(this.d);
      ((Map)localObject).remove(localStringBuilder.toString());
    }
    StoryReportor.a("home_page-comment_suc-d1", null);
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (this.b == null) {
      return;
    }
    if (paramInt < this.a.getCommentSegmentIndex()) {
      return;
    }
    paramInt -= this.a.getCommentSegmentIndex();
    paramAdapterView = ((DetailCommentSegment)this.a.b("DetailCommentSegment")).a(paramInt);
    if (paramAdapterView == null)
    {
      SLog.e("Q.qqstory.detail.StoryDetailFragment", "the clicked comment is null. position is %d.", new Object[] { Integer.valueOf(paramInt) });
      return;
    }
    if (paramAdapterView.type == 1)
    {
      this.l.bo_();
      return;
    }
    this.b.a(paramAdapterView, paramInt, this.l.h());
  }
  
  public boolean onItemLongClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (this.b == null) {
      return false;
    }
    if (paramInt < this.a.getCommentSegmentIndex()) {
      return false;
    }
    paramInt -= this.a.getCommentSegmentIndex();
    paramView = ((DetailCommentSegment)this.a.b("DetailCommentSegment")).a(paramInt);
    if (paramView == null)
    {
      SLog.e("Q.qqstory.detail.StoryDetailFragment", "the clicked comment is null. position is %d.", new Object[] { Integer.valueOf(paramInt) });
      return false;
    }
    paramAdapterView = this.k;
    if ((paramAdapterView != null) && (paramAdapterView.a != null))
    {
      if (this.k.a.getOwner().isMe()) {
        paramAdapterView = "2";
      } else {
        paramAdapterView = "1";
      }
      StoryReportor.a("home_page", "press_reply", 0, 0, new String[] { paramAdapterView, StoryReportor.b(this.e) });
    }
    if (paramView.type == 1)
    {
      this.l.bo_();
      return true;
    }
    this.b.b(paramView, paramInt, this.l.h());
    return true;
  }
  
  public void onPause()
  {
    super.onPause();
    this.a.l();
  }
  
  public void onResume()
  {
    super.onResume();
    int i1 = this.j;
    String str;
    if ((i1 != 106) && (i1 != 108)) {
      str = null;
    } else {
      str = String.valueOf(this.j);
    }
    StoryReportor.a("home_page-comment_suc-d1", str);
    this.l.i();
    this.a.p();
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    paramView = this.b;
    boolean bool2 = true;
    boolean bool1;
    if ((paramView != null) && (paramView.c()))
    {
      bool1 = bool2;
      if (paramMotionEvent.getAction() == 1)
      {
        this.b.d();
        if (this.k != null)
        {
          paramMotionEvent = StoryQQTextCacher.a().a;
          int i1 = StoryReportor.a(this.k.a);
          if (this.k.a.getOwner().isMe()) {
            paramView = "1";
          } else {
            paramView = "2";
          }
          StoryReportor.a("home_page", "cancel_reply", i1, 0, new String[] { paramView, StoryReportor.b(this.e), paramMotionEvent, this.d });
        }
        bool1 = bool2;
        if (QLog.isColorLevel())
        {
          QLog.d("Q.qqstory.detail.StoryDetailFragment", 2, "touch list while keyboard is showing, so hide the keyboard");
          return true;
        }
      }
    }
    else
    {
      bool1 = false;
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.detail.view.StoryDetailFragment
 * JD-Core Version:    0.7.0.1
 */