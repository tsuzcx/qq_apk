package com.tencent.biz.qqstory.storyHome.memory.view.segment;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.base.StoryDispatcher;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.UserManager;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.playmode.util.PlayModeUtils;
import com.tencent.biz.qqstory.storyHome.memory.StoryMemoriesFragment;
import com.tencent.biz.qqstory.storyHome.memory.controller.MemoriesVideoCollectionPresenter;
import com.tencent.biz.qqstory.storyHome.memory.controller.MemoriesVideoCollectionPresenter.VideoCollectionPresenterEventListener;
import com.tencent.biz.qqstory.storyHome.memory.model.VideoCollectionItem;
import com.tencent.biz.qqstory.storyHome.memory.model.VideoCollectionItem.FakeVideoUIItem;
import com.tencent.biz.qqstory.storyHome.memory.view.MemoriesInnerListView;
import com.tencent.biz.qqstory.storyHome.memory.view.MemoriesInnerListView.OnInnerListRefreshListener;
import com.tencent.biz.qqstory.storyHome.memory.view.adapter.MemoriesInnerListAdapter;
import com.tencent.biz.qqstory.storyHome.memory.view.adapter.MemoriesInnerListAdapter.MemoriesInnerListEventListener;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.BaseViewHolder;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.qqstory.utils.DateUtils;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.biz.qqstory.view.segment.SegmentList;
import com.tencent.biz.qqstory.view.segment.SegmentView;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tribe.async.async.Boss;
import com.tribe.async.async.Bosses;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.IEventReceiver;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;

public class MemoriesVideoListSegment
  extends SegmentView
  implements MemoriesVideoCollectionPresenter.VideoCollectionPresenterEventListener, MemoriesInnerListView.OnInnerListRefreshListener, MemoriesInnerListAdapter.MemoriesInnerListEventListener, IEventReceiver
{
  public static final String KEY = "MemoriesVideoListSegment";
  public int a;
  public String b;
  public String c;
  private final MemoriesVideoListSegment.PlayVideoChangeReceiver d;
  private HashMap<String, WeakReference<MemoriesInnerListAdapter>> e = new HashMap();
  private MemoriesVideoCollectionPresenter f;
  private boolean g = false;
  private boolean h = true;
  
  public MemoriesVideoListSegment(Context paramContext, int paramInt, String paramString)
  {
    super(paramContext);
    this.a = paramInt;
    this.f = new MemoriesVideoCollectionPresenter(paramString, this);
    this.f.a();
    this.d = new MemoriesVideoListSegment.PlayVideoChangeReceiver(this);
    StoryDispatcher.a().registerSubscriber(this.d);
  }
  
  private void a(int paramInt, VideoCollectionItem paramVideoCollectionItem, String paramString, boolean paramBoolean)
  {
    Object localObject = f(paramInt);
    if (localObject == null)
    {
      SLog.a("Q.qqstory.memories.MemoriesVideoListSegment", "doScrollHorizal, findViewHolder, null, waiting...  %s", Boolean.valueOf(paramBoolean));
      if (!paramBoolean) {
        ThreadManager.getUIHandler().postDelayed(new MemoriesVideoListSegment.3(this, paramInt, paramVideoCollectionItem, paramString), 300L);
      }
      return;
    }
    localObject = (MemoriesInnerListView)((BaseViewHolder)localObject).a(2131435804);
    if (localObject == null) {
      return;
    }
    int i = 0;
    Iterator localIterator = paramVideoCollectionItem.collectionVideoUIItemList.iterator();
    while ((localIterator.hasNext()) && (!TextUtils.equals(((VideoCollectionItem.FakeVideoUIItem)localIterator.next()).a, paramString))) {
      i += 1;
    }
    if (paramVideoCollectionItem.collectionVideoUIItemList.size() <= 2)
    {
      ThreadManager.getUIHandler().post(new MemoriesVideoListSegment.4(this, (MemoriesInnerListView)localObject, i, paramString));
      return;
    }
    if (!paramBoolean)
    {
      SLog.a("Q.qqstory.memories.MemoriesVideoListSegment", "feedPosition:%d do scroll data pos:%d", Integer.valueOf(paramInt), Integer.valueOf(i));
      int j = UIUtils.a(this.l, 80.0F) * i;
      ((MemoriesInnerListView)localObject).resetCurrentX(j);
      ((MemoriesInnerListView)localObject).getAdapter().notifyDataSetChanged();
      SLog.a("Q.qqstory.memories.MemoriesVideoListSegment", "feedPosition:%d do scroll data pos:%d, scrollx:%d", Integer.valueOf(paramInt), Integer.valueOf(i), Integer.valueOf(j));
    }
    ThreadManager.getUIHandler().postDelayed(new MemoriesVideoListSegment.5(this, (MemoriesInnerListView)localObject, i, paramString), 400L);
  }
  
  private void c(int paramInt)
  {
    g(paramInt);
    SLog.a("Q.qqstory.memories.MemoriesVideoListSegment", "doScrollVertical,position:%d", Integer.valueOf(paramInt));
  }
  
  private String m()
  {
    return String.valueOf(hashCode());
  }
  
  public int a()
  {
    if (this.m)
    {
      if (!this.f.b) {
        return 1;
      }
      return this.f.d.size();
    }
    return 0;
  }
  
  public View a(int paramInt, BaseViewHolder paramBaseViewHolder)
  {
    TextView localTextView = (TextView)paramBaseViewHolder.a(2131437659);
    if ((this.f.c != null) && (this.f.c.errorCode == 11111)) {
      localTextView.setText(HardCodeUtil.a(2131904427));
    } else {
      localTextView.setText(HardCodeUtil.a(2131904426));
    }
    return paramBaseViewHolder.a();
  }
  
  public View a(int paramInt, BaseViewHolder paramBaseViewHolder, ViewGroup paramViewGroup)
  {
    int i = g_(paramInt);
    if (i == 0) {
      return b(paramInt, paramBaseViewHolder, paramViewGroup);
    }
    if (i == 1) {
      return c(paramInt, paramBaseViewHolder, paramViewGroup);
    }
    if (i == 2) {
      return d(paramInt, paramBaseViewHolder, paramViewGroup);
    }
    if (i == 3) {
      return a(paramInt, paramBaseViewHolder);
    }
    paramBaseViewHolder = new StringBuilder();
    paramBaseViewHolder.append("bind view error because unknown view type:");
    paramBaseViewHolder.append(i);
    throw new IllegalStateException(paramBaseViewHolder.toString());
  }
  
  public BaseViewHolder a(int paramInt, ViewGroup paramViewGroup)
  {
    paramInt = g_(paramInt);
    if (paramInt == 0) {
      return new BaseViewHolder(LayoutInflater.from(this.l).inflate(2131628087, paramViewGroup, false));
    }
    if (paramInt == 1) {
      return new BaseViewHolder(LayoutInflater.from(this.l).inflate(2131628077, paramViewGroup, false));
    }
    if (paramInt == 2) {
      return new BaseViewHolder(LayoutInflater.from(this.l).inflate(2131628085, paramViewGroup, false));
    }
    if (paramInt == 3) {
      return new BaseViewHolder(LayoutInflater.from(this.l).inflate(2131628082, paramViewGroup, false));
    }
    paramViewGroup = new StringBuilder();
    paramViewGroup.append("create view error because unknown view type:");
    paramViewGroup.append(paramInt);
    throw new IllegalStateException(paramViewGroup.toString());
  }
  
  public void a(String paramString)
  {
    SLog.a("Q.qqstory.memories.MemoriesVideoListSegment", "onInnerListRefresh collectionId=%s", paramString);
    this.f.a(paramString);
    paramString = ((UserManager)SuperManager.a(2)).b(this.f.a);
    int i = StoryMemoriesFragment.a(this.a);
    if ((paramString != null) && (paramString.isMe())) {
      paramString = "1";
    } else {
      paramString = "2";
    }
    StoryReportor.a("memory", "left_right", i, 0, new String[] { paramString, "", "", "" });
  }
  
  public void a(String paramString1, int paramInt, View paramView, String paramString2)
  {
    Bosses.get().postJob(new MemoriesVideoListSegment.2(this, "Q.qqstory.memories.MemoriesVideoListSegment", paramString1, paramString2, paramInt, paramView));
  }
  
  public void a(String paramString1, String paramString2, boolean paramBoolean)
  {
    Iterator localIterator = this.f.d.iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      VideoCollectionItem localVideoCollectionItem = (VideoCollectionItem)localIterator.next();
      if (paramString1.equals(localVideoCollectionItem.feedId))
      {
        this.b = null;
        this.c = null;
        c(i);
        a(i, localVideoCollectionItem, paramString2, false);
        return;
      }
      i += 1;
    }
    if (paramBoolean)
    {
      SLog.b("Q.qqstory.memories.MemoriesVideoListSegment", "scroll2NewGroup, loadmore");
      this.b = paramString1;
      this.c = paramString2;
      j();
    }
  }
  
  public void a(String paramString, List<VideoCollectionItem.FakeVideoUIItem> paramList)
  {
    SLog.d("Q.qqstory.memories.MemoriesVideoListSegment", "updateCollectionData. collectionId=%s", new Object[] { paramString });
    WeakReference localWeakReference = (WeakReference)this.e.get(paramString);
    if ((localWeakReference != null) && (localWeakReference.get() != null)) {
      ((MemoriesInnerListAdapter)localWeakReference.get()).b(paramList, paramString);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean) {
      e(true);
    } else {
      e(false);
    }
    w().setLoadMoreComplete(b(), paramBoolean, true ^ bt_());
    String str1 = this.b;
    if (str1 != null)
    {
      String str2 = this.c;
      if (str2 != null)
      {
        a(str1, str2, false);
        this.b = null;
        this.c = null;
      }
    }
  }
  
  public View b(int paramInt, BaseViewHolder paramBaseViewHolder, ViewGroup paramViewGroup)
  {
    paramViewGroup = (VideoCollectionItem)this.f.d.get(paramInt);
    TextView localTextView1 = (TextView)paramBaseViewHolder.a(2131450358);
    TextView localTextView2 = (TextView)paramBaseViewHolder.a(2131449519);
    View localView = paramBaseViewHolder.a(2131437206);
    if (ThemeUtil.isInNightMode(PlayModeUtils.b()))
    {
      localTextView2.setTextColor(Color.parseColor("#44608a"));
      localTextView1.setTextColor(Color.parseColor("#6991b8"));
      localView.setBackgroundColor(Color.parseColor("#0c284e"));
    }
    localTextView1.setText(DateUtils.d(paramViewGroup.collectionTime));
    int j = paramViewGroup.collectionCount;
    int i = 0;
    if (j <= 0) {
      localTextView2.setText("");
    } else {
      localTextView2.setText(this.l.getString(2131897393, new Object[] { Integer.valueOf(paramViewGroup.collectionCount) }));
    }
    if (paramInt == 0) {
      i = 4;
    }
    localView.setVisibility(i);
    return paramBaseViewHolder.a();
  }
  
  public String b()
  {
    return "MemoriesVideoListSegment";
  }
  
  public boolean bt_()
  {
    if (t()) {
      return this.f.f;
    }
    return true;
  }
  
  protected void bz_()
  {
    super.bz_();
    this.g = false;
  }
  
  public View c(int paramInt, BaseViewHolder paramBaseViewHolder, ViewGroup paramViewGroup)
  {
    Object localObject3 = (RelativeLayout)paramBaseViewHolder.a(2131447345);
    Object localObject4 = (TextView)paramBaseViewHolder.a(2131430927);
    Object localObject5 = (TextView)paramBaseViewHolder.a(2131430929);
    TextView localTextView1 = (TextView)paramBaseViewHolder.a(2131430930);
    paramViewGroup = (MemoriesInnerListView)paramBaseViewHolder.a(2131435804);
    Object localObject1 = paramBaseViewHolder.a(2131437207);
    Object localObject2 = (ImageView)paramBaseViewHolder.a(2131440482);
    TextView localTextView2 = (TextView)paramBaseViewHolder.a(2131427835);
    if (ThemeUtil.isInNightMode(PlayModeUtils.b()))
    {
      ((View)localObject1).setBackgroundColor(Color.parseColor("#0c284e"));
      ((ImageView)localObject2).setBackgroundResource(2130848398);
      localTextView1.setTextColor(Color.parseColor("#44608a"));
      ((TextView)localObject4).setTextColor(Color.parseColor("#6991b8"));
      ((TextView)localObject5).setTextColor(Color.parseColor("#6991b8"));
    }
    localObject2 = (VideoCollectionItem)this.f.d.get(paramInt);
    paramViewGroup.setSelection(0);
    AccessibilityUtil.a(paramViewGroup, false);
    paramViewGroup.setFocusable(false);
    String[] arrayOfString = DateUtils.a(((VideoCollectionItem)localObject2).collectionTime);
    ((TextView)localObject4).setText(arrayOfString[1]);
    if (!TextUtils.isEmpty(arrayOfString[0]))
    {
      ((TextView)localObject5).setText(arrayOfString[0]);
      ((TextView)localObject5).setVisibility(0);
      ((TextView)localObject4).setTextSize(1, 32.0F);
      localObject5 = (LinearLayout.LayoutParams)((TextView)localObject4).getLayoutParams();
      ((LinearLayout.LayoutParams)localObject5).setMargins(0, UIUtils.a(this.l, -8.0F), 0, 0);
      ((TextView)localObject4).setLayoutParams((ViewGroup.LayoutParams)localObject5);
      localObject4 = (RelativeLayout.LayoutParams)((RelativeLayout)localObject3).getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject4).setMargins(0, 0, 0, 0);
      ((RelativeLayout)localObject3).setLayoutParams((ViewGroup.LayoutParams)localObject4);
    }
    else
    {
      ((TextView)localObject5).setVisibility(8);
      ((TextView)localObject4).setTextSize(1, 20.0F);
      localObject5 = (LinearLayout.LayoutParams)((TextView)localObject4).getLayoutParams();
      ((LinearLayout.LayoutParams)localObject5).setMargins(0, 0, 0, 0);
      ((TextView)localObject4).setLayoutParams((ViewGroup.LayoutParams)localObject5);
      localObject4 = (RelativeLayout.LayoutParams)((RelativeLayout)localObject3).getLayoutParams();
      if (TextUtils.equals(arrayOfString[1], HardCodeUtil.a(2131904424))) {
        ((RelativeLayout.LayoutParams)localObject4).setMargins(0, UIUtils.a(this.l, 10.0F), 0, UIUtils.a(this.l, 7.0F));
      } else {
        ((RelativeLayout.LayoutParams)localObject4).setMargins(0, 0, 0, UIUtils.a(this.l, 7.0F));
      }
      ((RelativeLayout)localObject3).setLayoutParams((ViewGroup.LayoutParams)localObject4);
    }
    localTextView1.setText(this.l.getString(2131897379, new Object[] { Integer.valueOf(((VideoCollectionItem)localObject2).collectionCount) }));
    if (TextUtils.isEmpty(((VideoCollectionItem)localObject2).address))
    {
      localTextView2.setVisibility(4);
    }
    else
    {
      ((VideoCollectionItem)localObject2).address = ((VideoCollectionItem)localObject2).address.replace(65292, '‧');
      localTextView2.setText(((VideoCollectionItem)localObject2).address);
      localTextView2.setVisibility(0);
    }
    localObject3 = (RelativeLayout.LayoutParams)((View)localObject1).getLayoutParams();
    if (paramInt == 1) {
      ((RelativeLayout.LayoutParams)localObject3).height = UIUtils.a(this.l, 150.0F);
    } else if (TextUtils.equals(arrayOfString[1], HardCodeUtil.a(2131904417))) {
      ((RelativeLayout.LayoutParams)localObject3).height = UIUtils.a(this.l, 172.0F);
    } else {
      ((RelativeLayout.LayoutParams)localObject3).height = UIUtils.a(this.l, 176.0F);
    }
    ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject3);
    paramViewGroup.a = this;
    localObject1 = (MemoriesInnerListAdapter)paramViewGroup.getAdapter();
    ((MemoriesInnerListAdapter)localObject1).a(this.f.a);
    ((MemoriesInnerListAdapter)localObject1).a(this);
    paramViewGroup.setSelection(0);
    paramViewGroup.resetCurrentX(0);
    paramViewGroup.setDate(((VideoCollectionItem)localObject2).collectionVideoUIItemList, ((VideoCollectionItem)localObject2).collectionId);
    this.e.put(((VideoCollectionItem)localObject2).collectionId, new WeakReference(localObject1));
    return paramBaseViewHolder.a();
  }
  
  public void c(boolean paramBoolean)
  {
    super.c(paramBoolean);
    if (this.m) {
      k();
    }
  }
  
  public View d(int paramInt, BaseViewHolder paramBaseViewHolder, ViewGroup paramViewGroup)
  {
    return paramBaseViewHolder.a();
  }
  
  protected boolean d(boolean paramBoolean)
  {
    this.f.a(false);
    return true;
  }
  
  protected int f()
  {
    return 4;
  }
  
  protected void g()
  {
    this.f.a(true);
    k();
  }
  
  protected int g_(int paramInt)
  {
    if (this.f.b)
    {
      VideoCollectionItem localVideoCollectionItem = (VideoCollectionItem)this.f.d.get(paramInt);
      if (localVideoCollectionItem.collectionType == 0) {
        return 0;
      }
      if (localVideoCollectionItem.collectionType == 1) {
        return 1;
      }
      if (localVideoCollectionItem.collectionType == 8) {
        return 2;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("get view type error because unknown view type:");
      localStringBuilder.append(localVideoCollectionItem.collectionType);
      throw new IllegalStateException(localStringBuilder.toString());
    }
    return 3;
  }
  
  protected void h()
  {
    super.h();
    this.f.b();
    this.h = false;
    StoryDispatcher.a().unRegisterSubscriber(this.d);
  }
  
  public boolean isValidate()
  {
    return this.h;
  }
  
  protected boolean j()
  {
    this.f.c();
    return true;
  }
  
  public void k()
  {
    w().setOnLoadMoreListener(b(), new MemoriesVideoListSegment.1(this));
    w().setLoadMoreComplete(b(), true, bt_() ^ true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.memory.view.segment.MemoriesVideoListSegment
 * JD-Core Version:    0.7.0.1
 */