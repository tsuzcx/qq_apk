package com.tencent.biz.qqstory.shareGroup.infocard;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.ProtoUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.boundaries.StoryApi;
import com.tencent.biz.qqstory.model.HotSortVideoManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.network.handler.DateCollectionListPageLoader.GetCollectionListEvent;
import com.tencent.biz.qqstory.network.handler.GetHotSortVideoHandler;
import com.tencent.biz.qqstory.network.handler.GetHotSortVideoHandler.GetVideoByHotSortEvent;
import com.tencent.biz.qqstory.network.handler.GetShareGroupInfoHandler;
import com.tencent.biz.qqstory.network.handler.GetShareGroupInfoHandler.GetShareGroupInfoEvent;
import com.tencent.biz.qqstory.network.handler.GetUserGroupUnionIDHandler;
import com.tencent.biz.qqstory.network.pb.qqstory_service.ReqLoadMoreVideoList;
import com.tencent.biz.qqstory.newshare.StoryShare;
import com.tencent.biz.qqstory.shareGroup.addvideo.AddVideoController;
import com.tencent.biz.qqstory.shareGroup.infocard.model.ShareGroupDataPuller;
import com.tencent.biz.qqstory.shareGroup.infocard.view.ShareGroupsListAdapter;
import com.tencent.biz.qqstory.shareGroup.infocard.view.ShareGroupsListView;
import com.tencent.biz.qqstory.shareGroup.model.ShareGroupItem;
import com.tencent.biz.qqstory.shareGroup.model.ShareGroupManager;
import com.tencent.biz.qqstory.storyHome.QQStoryBaseActivity;
import com.tencent.biz.qqstory.storyHome.StoryTransitionActivity;
import com.tencent.biz.qqstory.storyHome.memory.model.VideoCollectionItem;
import com.tencent.biz.qqstory.storyHome.memory.view.adapter.MemoriesInnerListAdapter.PublishVideoItem;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.qqstory.troop.activity.TroopStoryMainActivity;
import com.tencent.biz.qqstory.utils.DateUtils;
import com.tencent.biz.qqstory.utils.TranslucentTitleBarHelper;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.biz.qqstory.view.widget.LoadMoreLayout;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.immersive.ImmersiveTitleBar2;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import nry;
import nrz;
import nsa;
import nsb;
import nsd;
import nse;
import nsf;
import nsg;
import nsi;

public class QQStoryShareGroupProfileActivity
  extends QQStoryBaseActivity
{
  public int a;
  View jdField_a_of_type_AndroidViewView;
  ImageButton jdField_a_of_type_AndroidWidgetImageButton;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  GetHotSortVideoHandler jdField_a_of_type_ComTencentBizQqstoryNetworkHandlerGetHotSortVideoHandler;
  public StoryShare a;
  QQStoryShareGroupHelper jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardQQStoryShareGroupHelper;
  ShareGroupDataPuller jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardModelShareGroupDataPuller;
  ShareGroupsListAdapter jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListAdapter;
  public ShareGroupsListView a;
  public ShareGroupItem a;
  TranslucentTitleBarHelper jdField_a_of_type_ComTencentBizQqstoryUtilsTranslucentTitleBarHelper;
  LoadMoreLayout jdField_a_of_type_ComTencentBizQqstoryViewWidgetLoadMoreLayout;
  ImmersiveTitleBar2 jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2;
  public String a;
  public boolean a;
  int jdField_b_of_type_Int;
  ImageView jdField_b_of_type_AndroidWidgetImageView;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  public String b;
  public boolean b;
  int jdField_c_of_type_Int;
  TextView jdField_c_of_type_AndroidWidgetTextView;
  public String c;
  public boolean c;
  int jdField_d_of_type_Int = 0;
  TextView jdField_d_of_type_AndroidWidgetTextView;
  public String d;
  boolean jdField_d_of_type_Boolean = false;
  boolean e = false;
  boolean f = false;
  public boolean g = false;
  
  public QQStoryShareGroupProfileActivity()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
  }
  
  public static Intent a(Context paramContext, int paramInt1, String paramString1, String paramString2, int paramInt2, int paramInt3)
  {
    paramContext = new Intent(paramContext, QQStoryShareGroupProfileActivity.class);
    paramContext.putExtra("extra_share_group_id", paramString1);
    paramContext.putExtra("extra_share_group_type", paramInt1);
    paramContext.putExtra("extra_share_group_from", paramInt2);
    paramContext.putExtra("extra_share_group_play_from", paramInt3);
    paramContext.putExtra("extra_user_group_uin", paramString2);
    return paramContext;
  }
  
  private List a(List paramList, boolean paramBoolean)
  {
    ArrayList localArrayList = new ArrayList(paramList.size());
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      localVideoCollectionItem1 = (VideoCollectionItem)paramList.next();
      if (localVideoCollectionItem1.collectionCount > 0)
      {
        localVideoCollectionItem2 = new VideoCollectionItem();
        localVideoCollectionItem2.copy(localVideoCollectionItem1);
        localArrayList.add(localVideoCollectionItem2);
      }
    }
    if (!paramBoolean) {
      return localArrayList;
    }
    if (localArrayList.size() < 2) {
      return localArrayList;
    }
    paramList = (VideoCollectionItem)localArrayList.get(0);
    VideoCollectionItem localVideoCollectionItem1 = (VideoCollectionItem)localArrayList.get(1);
    VideoCollectionItem localVideoCollectionItem2 = VideoCollectionItem.getCurrentYearFakeItem(this.jdField_b_of_type_JavaLangString);
    VideoCollectionItem localVideoCollectionItem3 = VideoCollectionItem.getTodayFakeItem(this.jdField_b_of_type_JavaLangString);
    if (paramList.collectionType != 0)
    {
      localArrayList.add(0, localVideoCollectionItem2);
      if (!DateUtils.b(paramList.collectionTime)) {
        localArrayList.add(1, localVideoCollectionItem3);
      }
      for (;;)
      {
        return localArrayList;
        paramList.collectionVideoUIItemList.add(0, new MemoriesInnerListAdapter.PublishVideoItem());
      }
    }
    if (DateUtils.a(paramList.collectionTime)) {
      if (DateUtils.b(localVideoCollectionItem1.collectionTime)) {
        localVideoCollectionItem1.collectionVideoUIItemList.add(0, new MemoriesInnerListAdapter.PublishVideoItem());
      }
    }
    for (;;)
    {
      return localArrayList;
      localArrayList.add(1, localVideoCollectionItem3);
      continue;
      localArrayList.add(0, localVideoCollectionItem2);
      localArrayList.add(1, localVideoCollectionItem3);
    }
  }
  
  public static void a(Context paramContext, int paramInt1, String paramString1, String paramString2, int paramInt2, int paramInt3)
  {
    paramContext.startActivity(a(paramContext, paramInt1, paramString1, paramString2, paramInt2, paramInt3));
  }
  
  private void a(Intent paramIntent, String paramString)
  {
    int j;
    int k;
    label22:
    int m;
    boolean bool1;
    boolean bool2;
    int i;
    if (this.jdField_c_of_type_Int == 1)
    {
      j = 3;
      if (this.jdField_c_of_type_Int != 1) {
        break label200;
      }
      k = 2;
      m = paramIntent.getIntExtra("totalPublishVideoCount", 1);
      bool1 = paramIntent.getBooleanExtra("isLocalPublish", false);
      bool2 = paramIntent.getBooleanExtra("isTakePhoto", false);
      if (!paramIntent.getBooleanExtra("isAddFromExist", false)) {
        break label206;
      }
      i = 5;
    }
    for (;;)
    {
      StoryReportor.a("share_story", "clk_add_suc", j, k, new String[] { paramString, String.valueOf(m), String.valueOf(i) });
      if ((this.jdField_a_of_type_Int != 8) || (this.jdField_d_of_type_Int != 0)) {
        break label241;
      }
      paramIntent = AIOUtils.a(new Intent(this, SplashActivity.class), new int[] { 2 });
      paramIntent.putExtra("uin", this.jdField_c_of_type_JavaLangString);
      paramIntent.putExtra("uintype", 1);
      paramIntent.putExtra("uinname", this.jdField_a_of_type_ComTencentBizQqstoryShareGroupModelShareGroupItem.name);
      paramIntent.addFlags(71303168);
      super.startActivity(paramIntent);
      return;
      if (this.jdField_a_of_type_ComTencentBizQqstoryShareGroupModelShareGroupItem.isPublic())
      {
        j = 2;
        break;
      }
      j = 1;
      break;
      label200:
      k = 1;
      break label22;
      label206:
      if (bool1)
      {
        if (bool2) {
          i = 2;
        } else {
          i = 1;
        }
      }
      else if (bool2) {
        i = 4;
      } else {
        i = 3;
      }
    }
    label241:
    if ((this.jdField_a_of_type_Int == 9) || (this.jdField_d_of_type_Int == 9))
    {
      paramIntent = new Intent(this, TroopStoryMainActivity.class);
      paramIntent.addFlags(71303168);
      startActivity(paramIntent);
      return;
    }
    paramIntent = StoryTransitionActivity.a(this);
    paramIntent.addFlags(71303168);
    super.startActivity(paramIntent);
  }
  
  private void a(DateCollectionListPageLoader.GetCollectionListEvent paramGetCollectionListEvent)
  {
    List localList = a(paramGetCollectionListEvent.jdField_a_of_type_JavaUtilList, paramGetCollectionListEvent.jdField_c_of_type_Boolean);
    if (paramGetCollectionListEvent.jdField_c_of_type_Boolean)
    {
      if ((paramGetCollectionListEvent.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess()) && (paramGetCollectionListEvent.e))
      {
        this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListView.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListAdapter.a(localList, paramGetCollectionListEvent.jdField_a_of_type_Boolean);
        if (!paramGetCollectionListEvent.jdField_b_of_type_Boolean) {
          this.jdField_a_of_type_Boolean = true;
        }
        this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListView.setLoadMoreState(true, paramGetCollectionListEvent.jdField_a_of_type_Boolean);
      }
      this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListView.a(paramGetCollectionListEvent.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess(), paramGetCollectionListEvent.jdField_a_of_type_Boolean);
      if (!paramGetCollectionListEvent.jdField_b_of_type_Boolean) {
        if (this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListView.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListAdapter.isEmpty())
        {
          this.jdField_a_of_type_AndroidViewView.setVisibility(0);
          this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListView.setEnabled(false);
          this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetLoadMoreLayout.a(0);
        }
      }
      while (this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListView.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListAdapter.isEmpty()) {
        for (;;)
        {
          return;
          this.jdField_a_of_type_AndroidViewView.setVisibility(8);
          this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListView.setEnabled(true);
        }
      }
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetLoadMoreLayout.a(0);
      return;
    }
    if ((paramGetCollectionListEvent.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess()) && (paramGetCollectionListEvent.e)) {
      this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListView.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListAdapter.c(localList, paramGetCollectionListEvent.jdField_a_of_type_Boolean);
    }
    this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListView.setLoadMoreState(paramGetCollectionListEvent.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess(), paramGetCollectionListEvent.jdField_a_of_type_Boolean);
  }
  
  private void a(GetHotSortVideoHandler.GetVideoByHotSortEvent paramGetVideoByHotSortEvent)
  {
    if (paramGetVideoByHotSortEvent.jdField_c_of_type_Boolean) {}
    for (;;)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetLoadMoreLayout.a(0);
      this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListView.setLoadMoreState(true, paramGetVideoByHotSortEvent.jdField_a_of_type_Boolean);
      this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListView.a(paramGetVideoByHotSortEvent.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess(), paramGetVideoByHotSortEvent.jdField_a_of_type_Boolean);
      return;
      if ((paramGetVideoByHotSortEvent.jdField_a_of_type_JavaUtilArrayList != null) && (paramGetVideoByHotSortEvent.jdField_a_of_type_JavaUtilArrayList.size() > 0))
      {
        if (paramGetVideoByHotSortEvent.jdField_b_of_type_Boolean) {
          this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListView.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListAdapter.f(paramGetVideoByHotSortEvent.jdField_a_of_type_JavaUtilArrayList, paramGetVideoByHotSortEvent.jdField_a_of_type_Boolean);
        } else {
          this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListView.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListAdapter.e(paramGetVideoByHotSortEvent.jdField_a_of_type_JavaUtilArrayList, paramGetVideoByHotSortEvent.jdField_a_of_type_Boolean);
        }
      }
      else if (!paramGetVideoByHotSortEvent.jdField_b_of_type_Boolean)
      {
        this.jdField_a_of_type_AndroidViewView.setVisibility(0);
        this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListView.setEnabled(false);
        this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListView.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListAdapter.a();
      }
    }
  }
  
  private void a(GetShareGroupInfoHandler.GetShareGroupInfoEvent paramGetShareGroupInfoEvent)
  {
    QQToast.a(this, 1, "请求异常，请稍后重试。", 1).a();
  }
  
  private void a(ShareGroupItem paramShareGroupItem)
  {
    if (paramShareGroupItem == null) {}
    label148:
    label285:
    label290:
    label338:
    for (;;)
    {
      return;
      this.jdField_a_of_type_ComTencentBizQqstoryShareGroupModelShareGroupItem = paramShareGroupItem;
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetLoadMoreLayout.a(0);
      if ((paramShareGroupItem.isInvalid()) || (paramShareGroupItem.type == 2))
      {
        RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidViewView.getLayoutParams();
        localLayoutParams.topMargin = 0;
        this.jdField_a_of_type_AndroidViewView.setLayoutParams(localLayoutParams);
        this.jdField_b_of_type_AndroidWidgetTextView.setText(2131432105);
        this.jdField_a_of_type_AndroidViewView.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetTextView.setText(paramShareGroupItem.name);
        this.jdField_a_of_type_ComTencentBizQqstoryUtilsTranslucentTitleBarHelper.a(true, false);
        return;
      }
      int i;
      boolean bool;
      if ((paramShareGroupItem.type == 2) && (!paramShareGroupItem.isPublic()) && (!paramShareGroupItem.isSubscribe()))
      {
        i = 1;
        if (!this.e)
        {
          if ((paramShareGroupItem.type != 2) || (!paramShareGroupItem.isPublic())) {
            break label285;
          }
          bool = true;
          this.g = bool;
        }
        if (i == 0) {
          break label290;
        }
        this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListView.setVisibility(8);
        this.jdField_a_of_type_AndroidViewView.setVisibility(8);
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
        this.jdField_a_of_type_AndroidWidgetTextView.setText("日迹");
        this.jdField_a_of_type_ComTencentBizQqstoryUtilsTranslucentTitleBarHelper.a(true, false);
        this.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(8);
      }
      for (;;)
      {
        if (this.f) {
          break label338;
        }
        this.f = true;
        StoryReportor.a("share_story", "exp_data", paramShareGroupItem.getReportGroupProp(), StoryApi.a(2131689488), new String[] { paramShareGroupItem.getReportUserType(), this.jdField_a_of_type_Int + "" });
        return;
        i = 0;
        break;
        bool = false;
        break label148;
        this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListView.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(0);
        this.jdField_a_of_type_ComTencentBizQqstoryUtilsTranslucentTitleBarHelper.a(false, false);
        if (!this.e)
        {
          this.e = true;
          b(true);
        }
        b(paramShareGroupItem);
      }
    }
  }
  
  private void a(String paramString, int paramInt)
  {
    int k = 0;
    int i;
    int j;
    label24:
    AddVideoController localAddVideoController;
    if (this.jdField_c_of_type_Int == 1)
    {
      i = 3;
      if (this.jdField_c_of_type_Int != 1) {
        break label122;
      }
      j = 2;
      StoryReportor.a("share_story", "clk_add_entry", i, j, new String[] { paramString });
      localAddVideoController = new AddVideoController(this.app);
      if (!"2".equals(paramString)) {
        break label128;
      }
      i = 2;
    }
    for (;;)
    {
      localAddVideoController.a(this, this.jdField_a_of_type_ComTencentBizQqstoryShareGroupModelShareGroupItem.type, this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_ComTencentBizQqstoryShareGroupModelShareGroupItem.name, this.jdField_a_of_type_ComTencentBizQqstoryShareGroupModelShareGroupItem.groupUin, paramInt, i);
      return;
      if (this.jdField_a_of_type_ComTencentBizQqstoryShareGroupModelShareGroupItem.isPublic())
      {
        i = 2;
        break;
      }
      i = 1;
      break;
      label122:
      j = 1;
      break label24;
      label128:
      i = k;
      if ("5".equals(paramString)) {
        i = 5;
      }
    }
  }
  
  private boolean a()
  {
    return this.jdField_c_of_type_Int == 1;
  }
  
  private void b()
  {
    View localView = LayoutInflater.from(this).inflate(2130970834, null, false);
    super.setContentViewNoTitle(localView);
    this.jdField_a_of_type_ComTencentBizQqstoryUtilsTranslucentTitleBarHelper.a(localView);
    this.jdField_a_of_type_ComTencentBizQqstoryUtilsTranslucentTitleBarHelper.a(false, false);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)super.findViewById(2131363380));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131363381));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131363245));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131363474));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131363428));
    this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2 = ((ImmersiveTitleBar2)super.findViewById(2131363379));
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetLoadMoreLayout = ((LoadMoreLayout)super.findViewById(2131371882));
    this.jdField_a_of_type_AndroidViewView = super.findViewById(2131363116);
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    this.jdField_a_of_type_AndroidViewView.setBackgroundResource(2130838583);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131365687));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131366675));
    this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListView = ((ShareGroupsListView)super.findViewById(2131371995));
    this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListView.setContentBackground(2130838583);
    this.jdField_a_of_type_AndroidWidgetImageButton = ((ImageButton)super.findViewById(2131371825));
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetLoadMoreLayout.a(1);
    this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardQQStoryShareGroupHelper.a(this, this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListView.getRootView());
    c();
  }
  
  private void b(ShareGroupItem paramShareGroupItem)
  {
    if (paramShareGroupItem != null)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryShareGroupModelShareGroupItem = paramShareGroupItem;
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramShareGroupItem.name);
      if ((paramShareGroupItem.videoCount != 0) && (this.jdField_a_of_type_Int != 8)) {
        break label54;
      }
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListAdapter.a(paramShareGroupItem);
      return;
      label54:
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
    }
  }
  
  private void c()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListAdapter = ((ShareGroupsListAdapter)StoryApi.a(ShareGroupsListAdapter.class, new Object[] { this, Boolean.valueOf(this.g) }));
    this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListView.setListAdapter(this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListAdapter);
    QQStoryShareGroupProfileActivity.UIEventListenerImpl localUIEventListenerImpl = new QQStoryShareGroupProfileActivity.UIEventListenerImpl(this);
    this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListView.setUIEventListener(localUIEventListenerImpl);
    this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListView.setOnScrollChangeListener(localUIEventListenerImpl);
    this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListView.setOnScrollListener(localUIEventListenerImpl);
    this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListView.setLoadMoreState(true, true);
    this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(localUIEventListenerImpl);
    this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(localUIEventListenerImpl);
    this.jdField_a_of_type_AndroidWidgetImageButton.setOnClickListener(localUIEventListenerImpl);
  }
  
  private void c(boolean paramBoolean)
  {
    ShareGroupItem localShareGroupItem = ((ShareGroupManager)SuperManager.a(7)).a(this.jdField_b_of_type_JavaLangString);
    if ((localShareGroupItem != null) && (!paramBoolean)) {
      a(localShareGroupItem);
    }
    if (this.jdField_c_of_type_Int == 1)
    {
      new GetShareGroupInfoHandler(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString).a();
      return;
    }
    localShareGroupItem = new ShareGroupItem();
    localShareGroupItem.type = 2;
    a(localShareGroupItem);
  }
  
  private void d()
  {
    ActionSheet localActionSheet = ActionSheet.a(this);
    if (this.jdField_c_of_type_Int == 1) {
      localActionSheet.a("查看群资料卡", 5);
    }
    localActionSheet.c(2131433015);
    localActionSheet.a(new nrz(this, localActionSheet));
    if (!localActionSheet.isShowing()) {
      localActionSheet.show();
    }
  }
  
  private void d(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardModelShareGroupDataPuller == null) {
      this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardModelShareGroupDataPuller = new ShareGroupDataPuller(this.jdField_b_of_type_JavaLangString, this.jdField_c_of_type_Int, this.jdField_a_of_type_JavaLangString);
    }
    this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardModelShareGroupDataPuller.a();
    if (this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListView.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListAdapter.isEmpty()) {
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetLoadMoreLayout.a(1);
    }
    if (paramBoolean)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardModelShareGroupDataPuller.c();
      return;
    }
    this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardModelShareGroupDataPuller.d();
  }
  
  public int a()
  {
    if (this.jdField_b_of_type_Int > 0) {
      return this.jdField_b_of_type_Int;
    }
    if (this.jdField_c_of_type_Int == 1) {
      return 88;
    }
    return 87;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryNetworkHandlerGetHotSortVideoHandler == null) {
      this.jdField_a_of_type_ComTencentBizQqstoryNetworkHandlerGetHotSortVideoHandler = new GetHotSortVideoHandler(this.jdField_b_of_type_JavaLangString);
    }
    this.jdField_a_of_type_ComTencentBizQqstoryNetworkHandlerGetHotSortVideoHandler.b();
  }
  
  protected void a(@NonNull Map paramMap)
  {
    super.a(paramMap);
    paramMap.put(new nsd(this), "");
    paramMap.put(new nsf(this), "");
    paramMap.put(new nse(this), "");
    paramMap.put(new nsi(this), "");
    paramMap.put(new nsg(this), "");
    paramMap.put(new nsb(this), "");
    paramMap.put(new QQStoryShareGroupProfileActivity.VideoSortEventReceiver(this), "");
    paramMap.put(new QQStoryShareGroupProfileActivity.GetVideoByHotSortEventReceiver(this), "");
    paramMap.put(new QQStoryShareGroupProfileActivity.ReportVideoReceiver(this), "");
    paramMap.put(new QQStoryShareGroupProfileActivity.StoryVideoPublishStatusReceiver(this), "");
    paramMap.put(new QQStoryShareGroupProfileActivity.WatchVideoReceiver(this), "");
    paramMap.put(new QQStoryShareGroupProfileActivity.FeedInfoUpdateReceiver(this), "");
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListView.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListAdapter.jdField_a_of_type_JavaUtilList.size() <= 0) {
        break label95;
      }
      this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListView.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListAdapter.e(this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListView.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListAdapter.jdField_a_of_type_JavaUtilList, false);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentBizQqstoryNetworkHandlerGetHotSortVideoHandler == null) {
        this.jdField_a_of_type_ComTencentBizQqstoryNetworkHandlerGetHotSortVideoHandler = new GetHotSortVideoHandler(this.jdField_b_of_type_JavaLangString);
      }
      if (this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListView.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListAdapter.isEmpty()) {
        this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetLoadMoreLayout.a(1);
      }
      this.jdField_a_of_type_ComTencentBizQqstoryNetworkHandlerGetHotSortVideoHandler.a();
      return;
      label95:
      List localList = ((HotSortVideoManager)SuperManager.a(25)).a(this.jdField_b_of_type_JavaLangString);
      this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListView.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListAdapter.e(localList, false);
    }
  }
  
  public boolean a(VideoCollectionItem paramVideoCollectionItem)
  {
    int i = 2;
    if (paramVideoCollectionItem.collectionCount <= paramVideoCollectionItem.collectionVideoUIItemList.size()) {
      return false;
    }
    qqstory_service.ReqLoadMoreVideoList localReqLoadMoreVideoList = new qqstory_service.ReqLoadMoreVideoList();
    localReqLoadMoreVideoList.feed_id.set(ByteStringMicro.copyFromUtf8(paramVideoCollectionItem.feedId));
    Object localObject = localReqLoadMoreVideoList.from;
    if (this.jdField_c_of_type_Int == 2) {}
    for (;;)
    {
      ((PBUInt32Field)localObject).set(i);
      localReqLoadMoreVideoList.start_cookie.set(ByteStringMicro.copyFromUtf8(paramVideoCollectionItem.nextCookie));
      localReqLoadMoreVideoList.video_count.set(10);
      localObject = new Bundle();
      ((Bundle)localObject).putString("extra_feedid", paramVideoCollectionItem.feedId);
      ProtoUtils.a(this.app, new nsa(this), localReqLoadMoreVideoList.toByteArray(), StoryApi.a("StoryGroupSvc.datacard_load_more_video"), (Bundle)localObject);
      return true;
      i = 1;
    }
  }
  
  public void b(boolean paramBoolean)
  {
    if (this.g)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListView.setPadding(this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListView.getListPaddingLeft(), this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListView.getListPaddingTop(), this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListView.getListPaddingRight(), UIUtils.a(this, 76.0F));
      a(paramBoolean);
      return;
    }
    this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListView.setPadding(this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListView.getListPaddingLeft(), this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListView.getListPaddingTop(), this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListView.getListPaddingRight(), UIUtils.a(this, 89.0F));
    d(paramBoolean);
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt2 == -1) {}
    switch (paramInt1)
    {
    default: 
      if (this.jdField_a_of_type_ComTencentBizQqstoryNewshareStoryShare != null) {
        this.jdField_a_of_type_ComTencentBizQqstoryNewshareStoryShare.a(paramInt1, paramInt2, paramIntent);
      }
      return;
    case 1003: 
      a(paramIntent, "2");
      return;
    }
    a(paramIntent, "5");
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryUtilsTranslucentTitleBarHelper = new TranslucentTitleBarHelper(this, 20);
    super.doOnCreate(paramBundle);
    paramBundle = getIntent();
    this.jdField_b_of_type_JavaLangString = paramBundle.getStringExtra("extra_share_group_id");
    this.jdField_c_of_type_Int = paramBundle.getIntExtra("extra_share_group_type", 1);
    this.jdField_c_of_type_JavaLangString = paramBundle.getStringExtra("extra_user_group_uin");
    this.jdField_a_of_type_Int = paramBundle.getIntExtra("extra_share_group_from", 0);
    this.jdField_d_of_type_JavaLangString = paramBundle.getStringExtra("extra_share_from_user_uid");
    this.jdField_b_of_type_Int = paramBundle.getIntExtra("extra_share_group_play_from", 0);
    this.jdField_d_of_type_Int = paramBundle.getIntExtra("extra_last_open_from", 0);
    this.jdField_a_of_type_JavaLangString = String.valueOf(System.currentTimeMillis());
    this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardQQStoryShareGroupHelper = ((QQStoryShareGroupHelper)StoryApi.a(QQStoryShareGroupHelper.class, new Object[0]));
    b();
    if ((this.jdField_c_of_type_Int == 1) && (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)))
    {
      if (TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString))
      {
        if (QLog.isColorLevel()) {
          QLog.e("Q.qqstory.shareGroup.QQStoryShareGroupProfileActivity", 2, "extra_user_group_uin must not be empty!");
        }
        super.finish();
        return false;
      }
      new GetUserGroupUnionIDHandler(this.jdField_c_of_type_JavaLangString).a();
      if (this.jdField_a_of_type_Int == 5) {
        new Handler(Looper.getMainLooper()).postDelayed(new nry(this), 200L);
      }
      return true;
    }
    if (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString))
    {
      if (QLog.isColorLevel()) {
        QLog.e("Q.qqstory.shareGroup.QQStoryShareGroupProfileActivity", 2, "extra_share_group_id must not be empty!");
      }
      super.finish();
      return false;
    }
    if (!a()) {}
    for (boolean bool = true;; bool = false)
    {
      c(bool);
      break;
    }
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    if (this.jdField_c_of_type_Boolean)
    {
      this.jdField_c_of_type_Boolean = false;
      c(true);
    }
    if (this.jdField_b_of_type_Boolean)
    {
      this.jdField_b_of_type_Boolean = false;
      b(false);
    }
    while (!this.jdField_d_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListView.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListAdapter.notifyDataSetChanged();
  }
  
  protected boolean isWrapContent()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.shareGroup.infocard.QQStoryShareGroupProfileActivity
 * JD-Core Version:    0.7.0.1
 */