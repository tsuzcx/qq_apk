package com.tencent.biz.qqstory.storyHome.memory.view.segment;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.UserManager;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.playmode.util.PlayModeUtils;
import com.tencent.biz.qqstory.storyHome.memory.StoryMemoriesFragment;
import com.tencent.biz.qqstory.storyHome.memory.controller.MemoriesVideoCollectionPresenter;
import com.tencent.biz.qqstory.storyHome.memory.controller.MemoriesVideoCollectionPresenter.VideoCollectionPresenterEventListener;
import com.tencent.biz.qqstory.storyHome.memory.model.VideoCollectionItem;
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
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tribe.async.async.Boss;
import com.tribe.async.async.Bosses;
import com.tribe.async.dispatch.IEventReceiver;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import ocg;
import och;

public class MemoriesVideoListSegment
  extends SegmentView
  implements MemoriesVideoCollectionPresenter.VideoCollectionPresenterEventListener, MemoriesInnerListView.OnInnerListRefreshListener, MemoriesInnerListAdapter.MemoriesInnerListEventListener, IEventReceiver
{
  public static final String KEY = "MemoriesVideoListSegment";
  public int a;
  private MemoriesVideoCollectionPresenter jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryControllerMemoriesVideoCollectionPresenter;
  private HashMap jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private boolean b;
  private boolean c = true;
  
  public MemoriesVideoListSegment(Context paramContext, int paramInt, String paramString)
  {
    super(paramContext);
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryControllerMemoriesVideoCollectionPresenter = new MemoriesVideoCollectionPresenter(paramString, this);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryControllerMemoriesVideoCollectionPresenter.a();
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      if (!this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryControllerMemoriesVideoCollectionPresenter.jdField_a_of_type_Boolean) {
        return 1;
      }
      return this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryControllerMemoriesVideoCollectionPresenter.jdField_a_of_type_JavaUtilArrayList.size();
    }
    return 0;
  }
  
  protected int a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryControllerMemoriesVideoCollectionPresenter.jdField_a_of_type_Boolean)
    {
      VideoCollectionItem localVideoCollectionItem = (VideoCollectionItem)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryControllerMemoriesVideoCollectionPresenter.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
      if (localVideoCollectionItem.collectionType == 0) {
        return 0;
      }
      if (localVideoCollectionItem.collectionType == 1) {
        return 1;
      }
      if (localVideoCollectionItem.collectionType == 8) {
        return 2;
      }
      throw new IllegalStateException("get view type error because unknown view type:" + localVideoCollectionItem.collectionType);
    }
    return 3;
  }
  
  public View a(int paramInt, BaseViewHolder paramBaseViewHolder, ViewGroup paramViewGroup)
  {
    int i = a(paramInt);
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
      return paramBaseViewHolder.a();
    }
    throw new IllegalStateException("bind view error because unknown view type:" + i);
  }
  
  public BaseViewHolder a(int paramInt, ViewGroup paramViewGroup)
  {
    paramInt = a(paramInt);
    if (paramInt == 0) {
      return new BaseViewHolder(LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130970792, paramViewGroup, false));
    }
    if (paramInt == 1) {
      return new BaseViewHolder(LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130970782, paramViewGroup, false));
    }
    if (paramInt == 2) {
      return new BaseViewHolder(LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130970790, paramViewGroup, false));
    }
    if (paramInt == 3) {
      return new BaseViewHolder(LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130970787, paramViewGroup, false));
    }
    throw new IllegalStateException("create view error because unknown view type:" + paramInt);
  }
  
  public String a()
  {
    return "MemoriesVideoListSegment";
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryControllerMemoriesVideoCollectionPresenter.a(paramString);
    paramString = ((UserManager)SuperManager.a(2)).b(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryControllerMemoriesVideoCollectionPresenter.jdField_a_of_type_JavaLangString);
    int i = StoryMemoriesFragment.a(this.jdField_a_of_type_Int);
    if ((paramString != null) && (paramString.isMe())) {}
    for (paramString = "1";; paramString = "2")
    {
      StoryReportor.a("memory", "left_right", i, 0, new String[] { paramString, "", "", "" });
      return;
    }
  }
  
  public void a(String paramString1, int paramInt, View paramView, String paramString2)
  {
    Bosses.get().postJob(new och(this, paramString1, paramInt, paramView, paramString2));
  }
  
  public void a(String paramString, List paramList)
  {
    SLog.d("Q.qqstory.memories.MemoriesVideoListSegment", "updateCollectionData. collectionId=%s", new Object[] { paramString });
    WeakReference localWeakReference = (WeakReference)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
    if ((localWeakReference != null) && (localWeakReference.get() != null)) {
      ((MemoriesInnerListAdapter)localWeakReference.get()).b(paramList, paramString);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    boolean bool = true;
    SegmentList localSegmentList;
    String str;
    if (paramBoolean)
    {
      c(true);
      localSegmentList = a();
      str = a();
      if (a()) {
        break label46;
      }
    }
    for (;;)
    {
      localSegmentList.setLoadMoreComplete(str, paramBoolean, bool);
      return;
      c(false);
      break;
      label46:
      bool = false;
    }
  }
  
  public boolean a()
  {
    if (c()) {
      return this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryControllerMemoriesVideoCollectionPresenter.b;
    }
    return true;
  }
  
  protected boolean a_(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryControllerMemoriesVideoCollectionPresenter.a(false);
    return true;
  }
  
  public View b(int paramInt, BaseViewHolder paramBaseViewHolder, ViewGroup paramViewGroup)
  {
    paramViewGroup = (VideoCollectionItem)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryControllerMemoriesVideoCollectionPresenter.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
    TextView localTextView1 = (TextView)paramBaseViewHolder.a(2131369117);
    TextView localTextView2 = (TextView)paramBaseViewHolder.a(2131369118);
    View localView = paramBaseViewHolder.a(2131371861);
    if (ThemeUtil.isInNightMode(PlayModeUtils.a()))
    {
      localTextView2.setTextColor(Color.parseColor("#44608a"));
      localTextView1.setTextColor(Color.parseColor("#6991b8"));
      localView.setBackgroundColor(Color.parseColor("#0c284e"));
    }
    localTextView1.setText(DateUtils.b(paramViewGroup.collectionTime));
    if (paramViewGroup.collectionCount <= 0)
    {
      localTextView2.setText("");
      if (paramInt != 0) {
        break label162;
      }
    }
    label162:
    for (paramInt = 4;; paramInt = 0)
    {
      localView.setVisibility(paramInt);
      return paramBaseViewHolder.a();
      localTextView2.setText(this.jdField_a_of_type_AndroidContentContext.getString(2131438734, new Object[] { Integer.valueOf(paramViewGroup.collectionCount) }));
      break;
    }
  }
  
  public boolean b()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryControllerMemoriesVideoCollectionPresenter.c();
    return true;
  }
  
  public View c(int paramInt, BaseViewHolder paramBaseViewHolder, ViewGroup paramViewGroup)
  {
    Object localObject3 = (RelativeLayout)paramBaseViewHolder.a(2131366702);
    Object localObject4 = (TextView)paramBaseViewHolder.a(2131371863);
    Object localObject5 = (TextView)paramBaseViewHolder.a(2131371864);
    TextView localTextView1 = (TextView)paramBaseViewHolder.a(2131371867);
    paramViewGroup = (MemoriesInnerListView)paramBaseViewHolder.a(2131371870);
    Object localObject1 = paramBaseViewHolder.a(2131371862);
    Object localObject2 = (ImageView)paramBaseViewHolder.a(2131371865);
    TextView localTextView2 = (TextView)paramBaseViewHolder.a(2131371869);
    if (ThemeUtil.isInNightMode(PlayModeUtils.a()))
    {
      ((View)localObject1).setBackgroundColor(Color.parseColor("#0c284e"));
      ((ImageView)localObject2).setBackgroundResource(2130843590);
      localTextView1.setTextColor(Color.parseColor("#44608a"));
      ((TextView)localObject4).setTextColor(Color.parseColor("#6991b8"));
      ((TextView)localObject5).setTextColor(Color.parseColor("#6991b8"));
    }
    localObject2 = (VideoCollectionItem)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryControllerMemoriesVideoCollectionPresenter.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
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
      ((LinearLayout.LayoutParams)localObject5).setMargins(0, UIUtils.a(this.jdField_a_of_type_AndroidContentContext, -8.0F), 0, 0);
      ((TextView)localObject4).setLayoutParams((ViewGroup.LayoutParams)localObject5);
      localObject4 = (RelativeLayout.LayoutParams)((RelativeLayout)localObject3).getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject4).setMargins(0, 0, 0, 0);
      ((RelativeLayout)localObject3).setLayoutParams((ViewGroup.LayoutParams)localObject4);
      localTextView1.setText(this.jdField_a_of_type_AndroidContentContext.getString(2131438732, new Object[] { Integer.valueOf(((VideoCollectionItem)localObject2).collectionCount) }));
      if (!TextUtils.isEmpty(((VideoCollectionItem)localObject2).address)) {
        break label588;
      }
      localTextView2.setVisibility(4);
      label345:
      localObject3 = (RelativeLayout.LayoutParams)((View)localObject1).getLayoutParams();
      if (paramInt != 1) {
        break label626;
      }
      ((RelativeLayout.LayoutParams)localObject3).height = UIUtils.a(this.jdField_a_of_type_AndroidContentContext, 150.0F);
    }
    for (;;)
    {
      ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject3);
      paramViewGroup.a = this;
      localObject1 = (MemoriesInnerListAdapter)paramViewGroup.a();
      ((MemoriesInnerListAdapter)localObject1).a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryControllerMemoriesVideoCollectionPresenter.jdField_a_of_type_JavaLangString);
      ((MemoriesInnerListAdapter)localObject1).a(this);
      paramViewGroup.setSelection(0);
      paramViewGroup.a(0);
      paramViewGroup.setDate(((VideoCollectionItem)localObject2).collectionVideoUIItemList, ((VideoCollectionItem)localObject2).collectionId);
      this.jdField_a_of_type_JavaUtilHashMap.put(((VideoCollectionItem)localObject2).collectionId, new WeakReference(localObject1));
      return paramBaseViewHolder.a();
      ((TextView)localObject5).setVisibility(8);
      ((TextView)localObject4).setTextSize(1, 20.0F);
      localObject5 = (LinearLayout.LayoutParams)((TextView)localObject4).getLayoutParams();
      ((LinearLayout.LayoutParams)localObject5).setMargins(0, 0, 0, 0);
      ((TextView)localObject4).setLayoutParams((ViewGroup.LayoutParams)localObject5);
      localObject4 = (RelativeLayout.LayoutParams)((RelativeLayout)localObject3).getLayoutParams();
      if (TextUtils.equals(arrayOfString[1], "昨天")) {
        ((RelativeLayout.LayoutParams)localObject4).setMargins(0, UIUtils.a(this.jdField_a_of_type_AndroidContentContext, 10.0F), 0, UIUtils.a(this.jdField_a_of_type_AndroidContentContext, 7.0F));
      }
      for (;;)
      {
        ((RelativeLayout)localObject3).setLayoutParams((ViewGroup.LayoutParams)localObject4);
        break;
        ((RelativeLayout.LayoutParams)localObject4).setMargins(0, 0, 0, UIUtils.a(this.jdField_a_of_type_AndroidContentContext, 7.0F));
      }
      label588:
      ((VideoCollectionItem)localObject2).address = ((VideoCollectionItem)localObject2).address.replace(65292, '‧');
      localTextView2.setText(((VideoCollectionItem)localObject2).address);
      localTextView2.setVisibility(0);
      break label345;
      label626:
      if (TextUtils.equals(arrayOfString[1], "昨天")) {
        ((RelativeLayout.LayoutParams)localObject3).height = UIUtils.a(this.jdField_a_of_type_AndroidContentContext, 172.0F);
      } else {
        ((RelativeLayout.LayoutParams)localObject3).height = UIUtils.a(this.jdField_a_of_type_AndroidContentContext, 176.0F);
      }
    }
  }
  
  protected void c()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryControllerMemoriesVideoCollectionPresenter.a(true);
    f();
  }
  
  public View d(int paramInt, BaseViewHolder paramBaseViewHolder, ViewGroup paramViewGroup)
  {
    return paramBaseViewHolder.a();
  }
  
  protected void d()
  {
    super.d();
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryControllerMemoriesVideoCollectionPresenter.b();
    this.c = false;
  }
  
  protected int d_()
  {
    return 4;
  }
  
  public void e_(boolean paramBoolean)
  {
    super.e_(paramBoolean);
    if (this.jdField_a_of_type_Boolean) {
      f();
    }
  }
  
  public void f()
  {
    a().setOnLoadMoreListener(a(), new ocg(this));
    SegmentList localSegmentList = a();
    String str = a();
    if (!a()) {}
    for (boolean bool = true;; bool = false)
    {
      localSegmentList.setLoadMoreComplete(str, true, bool);
      return;
    }
  }
  
  protected void g()
  {
    super.g();
    this.b = false;
  }
  
  public boolean isValidate()
  {
    return this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.memory.view.segment.MemoriesVideoListSegment
 * JD-Core Version:    0.7.0.1
 */