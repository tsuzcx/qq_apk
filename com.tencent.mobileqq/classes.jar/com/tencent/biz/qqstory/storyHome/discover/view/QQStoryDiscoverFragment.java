package com.tencent.biz.qqstory.storyHome.discover.view;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.UserManager;
import com.tencent.biz.qqstory.model.item.HotTopicInfoItem;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.playmode.child.DiscoverPlayMode.PlayVideoEvent;
import com.tencent.biz.qqstory.storyHome.discover.model.CardItem;
import com.tencent.biz.qqstory.storyHome.discover.model.CardItem.ActivityCardInfo;
import com.tencent.biz.qqstory.storyHome.discover.model.CardItem.CardVideoInfo;
import com.tencent.biz.qqstory.storyHome.discover.model.CardItem.NormalCardInfo;
import com.tencent.biz.qqstory.storyHome.discover.model.DiscoverPagerLoader.GetDiscoverCardsEvent;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.qqstory.utils.NetworkUtils;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.biz.qqstory.view.pull2refresh.PullToRefreshListener;
import com.tencent.biz.qqstory.view.pull2refresh.XRecyclerView;
import com.tencent.biz.qqstory.view.widget.LoadingMoreHelper;
import com.tencent.biz.qqstory.view.xrecyclerview.RecyclerViewWithHeaderFooter;
import com.tencent.mobileqq.mqsafeedit.BaseApplication;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.widget.PullRefreshHeader;
import com.tencent.mobileqq.widget.QQToast;
import com.tribe.async.dispatch.IEventReceiver;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import nur;

public class QQStoryDiscoverFragment
  extends Fragment
  implements IDiscoverView, PullToRefreshListener, IEventReceiver
{
  private int jdField_a_of_type_Int = 0;
  private long jdField_a_of_type_Long;
  public StaggeredGridLayoutManager a;
  private HotTopicInfoItem jdField_a_of_type_ComTencentBizQqstoryModelItemHotTopicInfoItem;
  private CardItem.ActivityCardInfo jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverModelCardItem$ActivityCardInfo;
  private CardItem jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverModelCardItem;
  private DiscoverPresenter jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverViewDiscoverPresenter;
  private StoryDiscoverAdapter jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverViewStoryDiscoverAdapter;
  private XRecyclerView jdField_a_of_type_ComTencentBizQqstoryViewPull2refreshXRecyclerView;
  public RecyclerViewWithHeaderFooter a;
  private boolean jdField_a_of_type_Boolean = true;
  private int b;
  
  public static QQStoryDiscoverFragment a(int paramInt)
  {
    QQStoryDiscoverFragment localQQStoryDiscoverFragment = new QQStoryDiscoverFragment();
    Bundle localBundle = new Bundle();
    localBundle.putInt("source", paramInt);
    localQQStoryDiscoverFragment.setArguments(localBundle);
    return localQQStoryDiscoverFragment;
  }
  
  public static QQStoryDiscoverFragment a(long paramLong, byte[] paramArrayOfByte, int paramInt)
  {
    QQStoryDiscoverFragment localQQStoryDiscoverFragment = new QQStoryDiscoverFragment();
    Bundle localBundle = new Bundle();
    localBundle.putInt("type", 2);
    localBundle.putLong("topic_id", paramLong);
    localBundle.putByteArray("topic_info_pb", paramArrayOfByte);
    localBundle.putInt("source", paramInt);
    localQQStoryDiscoverFragment.setArguments(localBundle);
    return localQQStoryDiscoverFragment;
  }
  
  public static QQStoryDiscoverFragment a(String paramString1, String paramString2, ArrayList paramArrayList, int paramInt)
  {
    QQStoryDiscoverFragment localQQStoryDiscoverFragment = new QQStoryDiscoverFragment();
    Bundle localBundle = new Bundle();
    localBundle.putInt("type", 0);
    localBundle.putString("feedid", paramString1);
    localBundle.putString("coverurl", paramString2);
    localBundle.putStringArrayList("vidlist", paramArrayList);
    localBundle.putInt("source", paramInt);
    localQQStoryDiscoverFragment.setArguments(localBundle);
    return localQQStoryDiscoverFragment;
  }
  
  public HotTopicInfoItem a()
  {
    return this.jdField_a_of_type_ComTencentBizQqstoryModelItemHotTopicInfoItem;
  }
  
  public void a(View paramView)
  {
    ((PullRefreshHeader)paramView).c(0L);
  }
  
  public void a(View paramView, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      ((PullRefreshHeader)paramView).a(0);
      return;
    }
    ((PullRefreshHeader)paramView).a(1);
  }
  
  public void a(HotTopicInfoItem paramHotTopicInfoItem)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryModelItemHotTopicInfoItem = paramHotTopicInfoItem;
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverViewStoryDiscoverAdapter.a(this.jdField_a_of_type_ComTencentBizQqstoryModelItemHotTopicInfoItem);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverViewStoryDiscoverAdapter.a(paramHotTopicInfoItem.mSubjectName, paramHotTopicInfoItem.mJoinCount, paramHotTopicInfoItem.mJoinDesc, paramHotTopicInfoItem.mBackgroundUrl);
  }
  
  public void a(DiscoverPlayMode.PlayVideoEvent paramPlayVideoEvent)
  {
    int j = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverViewStoryDiscoverAdapter.a(paramPlayVideoEvent);
    if (this.jdField_a_of_type_Int == 2) {}
    for (int i = j + 1;; i = j)
    {
      SLog.a("Q.qqstory.discover.QQStoryDiscoverFragment", "updateScrollByPlayEvent(%s, %d), card position = %d, scrollPosition = %d", paramPlayVideoEvent.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVid, Integer.valueOf(paramPlayVideoEvent.jdField_a_of_type_Int), Integer.valueOf(j), Integer.valueOf(i));
      if (j >= 0) {
        this.jdField_a_of_type_AndroidSupportV7WidgetStaggeredGridLayoutManager.smoothScrollToPosition(this.jdField_a_of_type_ComTencentBizQqstoryViewPull2refreshXRecyclerView.a(), null, i);
      }
      return;
    }
  }
  
  public void a(CardItem paramCardItem)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverViewStoryDiscoverAdapter.notifyDataSetChanged();
  }
  
  public void a(List paramList, DiscoverPagerLoader.GetDiscoverCardsEvent paramGetDiscoverCardsEvent)
  {
    if (paramGetDiscoverCardsEvent.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess())
    {
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverViewStoryDiscoverAdapter.a(paramList);
      this.jdField_a_of_type_AndroidSupportV7WidgetStaggeredGridLayoutManager.invalidateSpanAssignments();
    }
    boolean bool1;
    if (!paramGetDiscoverCardsEvent.b)
    {
      paramList = this.jdField_a_of_type_ComTencentBizQqstoryViewPull2refreshXRecyclerView.a();
      boolean bool2 = paramGetDiscoverCardsEvent.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess();
      if (paramGetDiscoverCardsEvent.jdField_a_of_type_Boolean) {
        break label111;
      }
      bool1 = true;
      paramList.a(bool2, bool1);
      this.jdField_a_of_type_ComTencentBizQqstoryViewPull2refreshXRecyclerView.a(true);
      if (this.jdField_a_of_type_Int != 0) {
        break label137;
      }
      if (!this.jdField_a_of_type_Boolean) {
        break label116;
      }
      StoryReportor.a("content_flow", "refresh", 0, 0, new String[] { "2" });
    }
    label111:
    label116:
    while (this.jdField_a_of_type_Int != 2) {
      for (;;)
      {
        this.jdField_a_of_type_Boolean = false;
        return;
        bool1 = false;
        break;
        StoryReportor.a("content_flow", "refresh", 0, 0, new String[] { "1" });
      }
    }
    label137:
    if (this.jdField_a_of_type_ComTencentBizQqstoryModelItemHotTopicInfoItem != null)
    {
      paramList = String.valueOf(this.jdField_a_of_type_ComTencentBizQqstoryModelItemHotTopicInfoItem.mTopicId);
      label163:
      if (this.jdField_a_of_type_ComTencentBizQqstoryModelItemHotTopicInfoItem == null) {
        break label213;
      }
    }
    label213:
    for (paramGetDiscoverCardsEvent = this.jdField_a_of_type_ComTencentBizQqstoryModelItemHotTopicInfoItem.mSubjectName;; paramGetDiscoverCardsEvent = "")
    {
      StoryReportor.a("content_flow", "refresh_page", 0, 0, new String[] { paramList, "", paramGetDiscoverCardsEvent });
      break;
      paramList = "";
      break label163;
    }
  }
  
  public boolean a(View paramView)
  {
    ((PullRefreshHeader)paramView).a(0L);
    if (NetworkUtils.a(getActivity()))
    {
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverViewDiscoverPresenter.a(false, true);
      return false;
    }
    this.jdField_a_of_type_ComTencentBizQqstoryViewPull2refreshXRecyclerView.a(false);
    QQToast.a(BaseApplication.getContext(), 1, "当前网络不可用，请检查你的网络设置", 0).a();
    return false;
  }
  
  public void b(View paramView)
  {
    ((PullRefreshHeader)paramView).b(0L);
  }
  
  public boolean isValidate()
  {
    return true;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = getArguments();
    if (paramBundle == null) {}
    String str1;
    String str2;
    do
    {
      do
      {
        do
        {
          return;
          this.b = paramBundle.getInt("source", 1);
          this.jdField_a_of_type_Int = paramBundle.getInt("type");
          localObject = paramBundle.getByteArray("topic_info_pb");
          if (this.jdField_a_of_type_Int != 2) {
            break;
          }
          this.jdField_a_of_type_Long = paramBundle.getLong("topic_id");
          SLog.b("Q.qqstory.discover.QQStoryDiscoverFragment", "view topic id: %d", Long.valueOf(this.jdField_a_of_type_Long));
        } while (localObject == null);
        try
        {
          this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverModelCardItem$ActivityCardInfo = new CardItem.ActivityCardInfo((byte[])localObject);
          return;
        }
        catch (Exception paramBundle)
        {
          SLog.c("Q.qqstory.discover.QQStoryDiscoverFragment", "parse pb error", paramBundle);
          return;
        }
      } while (this.jdField_a_of_type_Int != 0);
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverModelCardItem = null;
      str1 = paramBundle.getString("feedid");
      str2 = paramBundle.getString("coverurl");
      localObject = paramBundle.getStringArrayList("vidlist");
      paramBundle = (Bundle)localObject;
      if (localObject == null) {
        paramBundle = Collections.emptyList();
      }
    } while ((TextUtils.isEmpty(str1)) || (TextUtils.isEmpty(str2)));
    paramBundle = new CardItem.CardVideoInfo(str1, str2, paramBundle);
    Object localObject = ((UserManager)SuperManager.a(2)).a();
    if (localObject != null)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverModelCardItem = new CardItem("share_to_discover_fake_item", new CardItem.NormalCardInfo(paramBundle, (QQUserUIItem)localObject));
      SLog.d("Q.qqstory.discover.QQStoryDiscoverFragment", "Create a fake item ok. feedId=%s", new Object[] { str1 });
      return;
    }
    SLog.e("Q.qqstory.discover.QQStoryDiscoverFragment", "UserManager.getMySelfItem return null, should not create a fake item. feedId=%s", new Object[] { str1 });
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramViewGroup = paramLayoutInflater.inflate(2130970701, paramViewGroup, false);
    this.jdField_a_of_type_ComTencentBizQqstoryViewPull2refreshXRecyclerView = ((XRecyclerView)paramViewGroup.findViewById(2131371635));
    this.jdField_a_of_type_ComTencentBizQqstoryViewPull2refreshXRecyclerView.setPullToRefreshListener(this);
    this.jdField_a_of_type_ComTencentBizQqstoryViewXrecyclerviewRecyclerViewWithHeaderFooter = this.jdField_a_of_type_ComTencentBizQqstoryViewPull2refreshXRecyclerView.a();
    this.jdField_a_of_type_AndroidSupportV7WidgetStaggeredGridLayoutManager = new StaggeredGridLayoutManager(2, 1);
    this.jdField_a_of_type_AndroidSupportV7WidgetStaggeredGridLayoutManager.mClearSpanOnItemsChanged = false;
    this.jdField_a_of_type_ComTencentBizQqstoryViewXrecyclerviewRecyclerViewWithHeaderFooter.setLayoutManager(this.jdField_a_of_type_AndroidSupportV7WidgetStaggeredGridLayoutManager);
    this.jdField_a_of_type_ComTencentBizQqstoryViewXrecyclerviewRecyclerViewWithHeaderFooter.setItemAnimator(null);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverViewStoryDiscoverAdapter = new StoryDiscoverAdapter(this.jdField_a_of_type_ComTencentBizQqstoryViewXrecyclerviewRecyclerViewWithHeaderFooter, this.jdField_a_of_type_Int, this.b);
    if (this.jdField_a_of_type_Int == 2)
    {
      paramLayoutInflater = paramLayoutInflater.inflate(2130970702, null, false);
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverViewStoryDiscoverAdapter.a(paramLayoutInflater);
    }
    this.jdField_a_of_type_ComTencentBizQqstoryViewXrecyclerviewRecyclerViewWithHeaderFooter.setAdapter(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverViewStoryDiscoverAdapter);
    paramLayoutInflater = this.jdField_a_of_type_ComTencentBizQqstoryViewPull2refreshXRecyclerView.a();
    paramLayoutInflater.a(15);
    paramLayoutInflater.a(new nur(this));
    paramLayoutInflater.a(true, false);
    this.jdField_a_of_type_ComTencentBizQqstoryViewXrecyclerviewRecyclerViewWithHeaderFooter.setPadding(UIUtils.a(this.jdField_a_of_type_ComTencentBizQqstoryViewXrecyclerviewRecyclerViewWithHeaderFooter.getContext(), 2.5F), 0, UIUtils.a(this.jdField_a_of_type_ComTencentBizQqstoryViewXrecyclerviewRecyclerViewWithHeaderFooter.getContext(), 2.5F), UIUtils.a(this.jdField_a_of_type_ComTencentBizQqstoryViewXrecyclerviewRecyclerViewWithHeaderFooter.getContext(), 100.0F));
    this.jdField_a_of_type_ComTencentBizQqstoryViewXrecyclerviewRecyclerViewWithHeaderFooter.setClipToPadding(false);
    this.jdField_a_of_type_ComTencentBizQqstoryViewXrecyclerviewRecyclerViewWithHeaderFooter.setClipChildren(false);
    int i = -1184275;
    QQStoryContext.a();
    if (ThemeUtil.isNowThemeIsNight(QQStoryContext.a(), false, null)) {
      i = -15983304;
    }
    this.jdField_a_of_type_ComTencentBizQqstoryViewXrecyclerviewRecyclerViewWithHeaderFooter.setBackgroundColor(i);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverViewDiscoverPresenter = new DiscoverPresenter(this.jdField_a_of_type_Int, this.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverModelCardItem$ActivityCardInfo, this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverModelCardItem, this);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverViewDiscoverPresenter.a();
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverViewDiscoverPresenter.a(true, false);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverViewDiscoverPresenter.a(false, false);
    this.jdField_a_of_type_Boolean = true;
    StoryReportor.a("content_flow", "exp", this.b, 1, new String[0]);
    return paramViewGroup;
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverViewDiscoverPresenter.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.discover.view.QQStoryDiscoverFragment
 * JD-Core Version:    0.7.0.1
 */