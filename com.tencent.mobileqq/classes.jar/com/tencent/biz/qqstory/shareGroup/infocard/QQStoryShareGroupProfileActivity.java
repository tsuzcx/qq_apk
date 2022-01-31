package com.tencent.biz.qqstory.shareGroup.infocard;

import actj;
import ajya;
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
import bcql;
import bfpc;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.network.pb.qqstory_service.ReqLoadMoreVideoList;
import com.tencent.biz.qqstory.shareGroup.infocard.view.ShareGroupsListView;
import com.tencent.biz.qqstory.shareGroup.model.ShareGroupItem;
import com.tencent.biz.qqstory.storyHome.QQStoryBaseActivity;
import com.tencent.biz.qqstory.storyHome.StoryTransitionActivity;
import com.tencent.biz.qqstory.storyHome.memory.model.VideoCollectionItem;
import com.tencent.biz.qqstory.troop.activity.TroopStoryMainActivity;
import com.tencent.biz.qqstory.view.widget.LoadMoreLayout;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveTitleBar2;
import com.tribe.async.dispatch.Subscriber;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mxf;
import ssf;
import sxm;
import tcg;
import tcz;
import tjj;
import tjp;
import tjs;
import tjt;
import tju;
import tjz;
import tpb;
import ukf;
import ulf;
import ulg;
import ulh;
import uli;
import ulj;
import ulk;
import ull;
import ulm;
import uln;
import ulo;
import ulp;
import ulq;
import ulr;
import uls;
import ulu;
import ulv;
import ulw;
import ulx;
import umj;
import umv;
import uuh;
import vei;
import vxy;
import vzj;
import vzl;

public class QQStoryShareGroupProfileActivity
  extends QQStoryBaseActivity
{
  public int a;
  View jdField_a_of_type_AndroidViewView;
  ImageButton jdField_a_of_type_AndroidWidgetImageButton;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  public ShareGroupsListView a;
  public ShareGroupItem a;
  LoadMoreLayout jdField_a_of_type_ComTencentBizQqstoryViewWidgetLoadMoreLayout;
  ImmersiveTitleBar2 jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2;
  public String a;
  tjp jdField_a_of_type_Tjp;
  public tpb a;
  ulf jdField_a_of_type_Ulf;
  public ulx a;
  public umj a;
  public vzj a;
  public boolean a;
  int jdField_b_of_type_Int;
  ImageView jdField_b_of_type_AndroidWidgetImageView;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  public String b;
  public boolean b;
  public int c;
  TextView c;
  public String c;
  public boolean c;
  int jdField_d_of_type_Int = 0;
  TextView jdField_d_of_type_AndroidWidgetTextView;
  public String d;
  public boolean d;
  boolean e = false;
  boolean f = false;
  public boolean g = false;
  private boolean k;
  
  public QQStoryShareGroupProfileActivity()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_d_of_type_Boolean = false;
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
  
  private List<VideoCollectionItem> a(List<VideoCollectionItem> paramList, boolean paramBoolean)
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
      if (!vxy.b(paramList.collectionTime)) {
        localArrayList.add(1, localVideoCollectionItem3);
      }
      for (;;)
      {
        return localArrayList;
        paramList.collectionVideoUIItemList.add(0, new uuh());
      }
    }
    if (vxy.a(paramList.collectionTime)) {
      if (vxy.b(localVideoCollectionItem1.collectionTime)) {
        localVideoCollectionItem1.collectionVideoUIItemList.add(0, new uuh());
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
  
  private void a(int paramInt)
  {
    if (this.k) {
      this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListView.setSelection(paramInt);
    }
    while ((paramInt >= this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListView.getFirstVisiblePosition()) && (paramInt <= this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListView.getLastVisiblePosition())) {
      return;
    }
    this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListView.setSelection(paramInt);
    this.k = true;
  }
  
  public static void a(Context paramContext, int paramInt1, String paramString1, String paramString2, int paramInt2, int paramInt3)
  {
    paramContext.startActivity(a(paramContext, paramInt1, paramString1, paramString2, paramInt2, paramInt3));
  }
  
  private void a(Intent paramIntent, String paramString)
  {
    int j;
    int m;
    label22:
    int n;
    boolean bool1;
    boolean bool2;
    int i;
    if (this.jdField_c_of_type_Int == 1)
    {
      j = 3;
      if (this.jdField_c_of_type_Int != 1) {
        break label200;
      }
      m = 2;
      n = paramIntent.getIntExtra("totalPublishVideoCount", 1);
      bool1 = paramIntent.getBooleanExtra("isLocalPublish", false);
      bool2 = paramIntent.getBooleanExtra("isTakePhoto", false);
      if (!paramIntent.getBooleanExtra("isAddFromExist", false)) {
        break label206;
      }
      i = 5;
    }
    for (;;)
    {
      vei.a("share_story", "clk_add_suc", j, m, new String[] { paramString, String.valueOf(n), String.valueOf(i) });
      if ((this.jdField_a_of_type_Int != 8) || (this.jdField_d_of_type_Int != 0)) {
        break label241;
      }
      paramIntent = actj.a(new Intent(this, SplashActivity.class), new int[] { 2 });
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
      m = 1;
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
        this.jdField_b_of_type_AndroidWidgetTextView.setText(2131699703);
        this.jdField_a_of_type_AndroidViewView.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetTextView.setText(paramShareGroupItem.name);
        this.jdField_a_of_type_Vzj.a(true, false);
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
        this.jdField_a_of_type_AndroidWidgetTextView.setText(ssf.jdField_a_of_type_JavaLangString);
        this.jdField_a_of_type_Vzj.a(true, false);
        this.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(8);
      }
      for (;;)
      {
        if (this.f) {
          break label338;
        }
        this.f = true;
        vei.a("share_story", "exp_data", paramShareGroupItem.getReportGroupProp(), sxm.a(2131427362), new String[] { paramShareGroupItem.getReportUserType(), this.jdField_a_of_type_Int + "" });
        return;
        i = 0;
        break;
        bool = false;
        break label148;
        this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListView.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(0);
        this.jdField_a_of_type_Vzj.a(false, false);
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
    int m = 0;
    int i;
    int j;
    label24:
    ukf localukf;
    if (this.jdField_c_of_type_Int == 1)
    {
      i = 3;
      if (this.jdField_c_of_type_Int != 1) {
        break label122;
      }
      j = 2;
      vei.a("share_story", "clk_add_entry", i, j, new String[] { paramString });
      localukf = new ukf(this.app);
      if (!"2".equals(paramString)) {
        break label128;
      }
      i = 2;
    }
    for (;;)
    {
      localukf.a(this, this.jdField_a_of_type_ComTencentBizQqstoryShareGroupModelShareGroupItem.type, this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_ComTencentBizQqstoryShareGroupModelShareGroupItem.name, this.jdField_a_of_type_ComTencentBizQqstoryShareGroupModelShareGroupItem.groupUin, paramInt, i);
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
      i = m;
      if ("5".equals(paramString)) {
        i = 5;
      }
    }
  }
  
  private void a(tjj paramtjj)
  {
    List localList = a(paramtjj.jdField_a_of_type_JavaUtilList, paramtjj.jdField_c_of_type_Boolean);
    if (paramtjj.jdField_c_of_type_Boolean)
    {
      if ((paramtjj.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess()) && (paramtjj.e))
      {
        this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListView.jdField_a_of_type_Umj.a(localList, paramtjj.jdField_a_of_type_Boolean);
        if (!paramtjj.jdField_b_of_type_Boolean) {
          this.jdField_a_of_type_Boolean = true;
        }
        this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListView.setLoadMoreState(true, paramtjj.jdField_a_of_type_Boolean);
      }
      this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListView.a(paramtjj.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess(), paramtjj.jdField_a_of_type_Boolean);
      if (!paramtjj.jdField_b_of_type_Boolean) {
        if (this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListView.jdField_a_of_type_Umj.isEmpty())
        {
          this.jdField_a_of_type_AndroidViewView.setVisibility(0);
          this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListView.setEnabled(false);
          this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetLoadMoreLayout.a(0);
        }
      }
      while (this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListView.jdField_a_of_type_Umj.isEmpty()) {
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
    if ((paramtjj.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess()) && (paramtjj.e)) {
      this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListView.jdField_a_of_type_Umj.c(localList, paramtjj.jdField_a_of_type_Boolean);
    }
    this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListView.setLoadMoreState(paramtjj.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess(), paramtjj.jdField_a_of_type_Boolean);
  }
  
  private void a(tjs paramtjs)
  {
    if (paramtjs.jdField_c_of_type_Boolean) {}
    for (;;)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetLoadMoreLayout.a(0);
      this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListView.setLoadMoreState(true, paramtjs.jdField_a_of_type_Boolean);
      this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListView.a(paramtjs.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess(), paramtjs.jdField_a_of_type_Boolean);
      return;
      if ((paramtjs.jdField_a_of_type_JavaUtilArrayList != null) && (paramtjs.jdField_a_of_type_JavaUtilArrayList.size() > 0))
      {
        if (paramtjs.jdField_b_of_type_Boolean) {
          this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListView.jdField_a_of_type_Umj.f(paramtjs.jdField_a_of_type_JavaUtilArrayList, paramtjs.jdField_a_of_type_Boolean);
        } else {
          this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListView.jdField_a_of_type_Umj.e(paramtjs.jdField_a_of_type_JavaUtilArrayList, paramtjs.jdField_a_of_type_Boolean);
        }
      }
      else if (!paramtjs.jdField_b_of_type_Boolean)
      {
        this.jdField_a_of_type_AndroidViewView.setVisibility(0);
        this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListView.setEnabled(false);
        this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListView.jdField_a_of_type_Umj.a();
      }
    }
  }
  
  private void a(tju paramtju)
  {
    bcql.a(this, 1, ajya.a(2131711051), 1).a();
  }
  
  private boolean a()
  {
    return this.jdField_c_of_type_Int == 1;
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
      this.jdField_a_of_type_Umj.a(paramShareGroupItem);
      return;
      label54:
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
    }
  }
  
  private void c(boolean paramBoolean)
  {
    ShareGroupItem localShareGroupItem = ((umv)tcz.a(7)).a(this.jdField_b_of_type_JavaLangString);
    if ((localShareGroupItem != null) && (!paramBoolean)) {
      a(localShareGroupItem);
    }
    if (this.jdField_c_of_type_Int == 1)
    {
      new tjt(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString).a();
      return;
    }
    localShareGroupItem = new ShareGroupItem();
    localShareGroupItem.type = 2;
    a(localShareGroupItem);
  }
  
  private void d()
  {
    View localView = LayoutInflater.from(this).inflate(2131561361, null, false);
    super.setContentViewNoTitle(localView);
    this.jdField_a_of_type_Vzj.a(localView);
    this.jdField_a_of_type_Vzj.a(false, false);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)super.findViewById(2131377400));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131368472));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131368429));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131368441));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131368457));
    this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2 = ((ImmersiveTitleBar2)super.findViewById(2131377439));
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetLoadMoreLayout = ((LoadMoreLayout)super.findViewById(2131368980));
    this.jdField_a_of_type_AndroidViewView = super.findViewById(2131365675);
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    this.jdField_a_of_type_AndroidViewView.setBackgroundResource(2130839127);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131365654));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131365666));
    this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListView = ((ShareGroupsListView)super.findViewById(2131376055));
    this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListView.setContentBackground(2130839127);
    this.jdField_a_of_type_AndroidWidgetImageButton = ((ImageButton)super.findViewById(2131373329));
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetLoadMoreLayout.a(1);
    this.jdField_a_of_type_Ulf.a(this, this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListView.getRootView());
    e();
  }
  
  private void d(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Ulx == null) {
      this.jdField_a_of_type_Ulx = new ulx(this.jdField_b_of_type_JavaLangString, this.jdField_c_of_type_Int, this.jdField_a_of_type_JavaLangString);
    }
    this.jdField_a_of_type_Ulx.a();
    if (this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListView.jdField_a_of_type_Umj.isEmpty()) {
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetLoadMoreLayout.a(1);
    }
    if (paramBoolean)
    {
      this.jdField_a_of_type_Ulx.c();
      return;
    }
    this.jdField_a_of_type_Ulx.d();
  }
  
  private void e()
  {
    this.jdField_a_of_type_Umj = ((umj)sxm.a(umj.class, new Object[] { this, Boolean.valueOf(this.g) }));
    this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListView.setListAdapter(this.jdField_a_of_type_Umj);
    uls localuls = new uls(this);
    this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListView.setUIEventListener(localuls);
    this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListView.setOnScrollChangeListener(localuls);
    this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListView.setOnScrollListener(localuls);
    this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListView.setLoadMoreState(true, true);
    this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(localuls);
    this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(localuls);
    this.jdField_a_of_type_AndroidWidgetImageButton.setOnClickListener(localuls);
  }
  
  private void f()
  {
    bfpc localbfpc = bfpc.a(this);
    if (this.jdField_c_of_type_Int == 1) {
      localbfpc.a(ajya.a(2131711024), 5);
    }
    localbfpc.c(2131690596);
    localbfpc.a(new ulg(this, localbfpc));
    if (!localbfpc.isShowing()) {
      localbfpc.show();
    }
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
  
  @NonNull
  public String a()
  {
    return String.valueOf(hashCode());
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Tjp == null) {
      this.jdField_a_of_type_Tjp = new tjp(this.jdField_b_of_type_JavaLangString);
    }
    this.jdField_a_of_type_Tjp.b();
  }
  
  public void a(String paramString)
  {
    Iterator localIterator = this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListView.jdField_a_of_type_Umj.a().iterator();
    int i = 0;
    for (;;)
    {
      if (localIterator.hasNext())
      {
        if (paramString.equals(((VideoCollectionItem)localIterator.next()).feedId)) {
          a(i);
        }
      }
      else {
        return;
      }
      i += 1;
    }
  }
  
  public void a(@NonNull Map<Subscriber, String> paramMap)
  {
    super.a(paramMap);
    paramMap.put(new ulk(this), "");
    paramMap.put(new ulm(this), "");
    paramMap.put(new ull(this), "");
    paramMap.put(new ulu(this), "");
    paramMap.put(new uln(this), "");
    paramMap.put(new uli(this), "");
    paramMap.put(new ulv(this), "");
    paramMap.put(new ulo(this), "");
    paramMap.put(new ulq(this), "");
    paramMap.put(new ulr(this), "");
    paramMap.put(new ulw(this), "");
    paramMap.put(new ulj(this), "");
    paramMap.put(new ulp(this), "");
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListView.jdField_a_of_type_Umj.jdField_a_of_type_JavaUtilList.size() <= 0) {
        break label95;
      }
      this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListView.jdField_a_of_type_Umj.e(this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListView.jdField_a_of_type_Umj.jdField_a_of_type_JavaUtilList, false);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Tjp == null) {
        this.jdField_a_of_type_Tjp = new tjp(this.jdField_b_of_type_JavaLangString);
      }
      if (this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListView.jdField_a_of_type_Umj.isEmpty()) {
        this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetLoadMoreLayout.a(1);
      }
      this.jdField_a_of_type_Tjp.a();
      return;
      label95:
      List localList = ((tcg)tcz.a(25)).a(this.jdField_b_of_type_JavaLangString);
      this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListView.jdField_a_of_type_Umj.e(localList, false);
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
      mxf.a(this.app, new ulh(this), localReqLoadMoreVideoList.toByteArray(), sxm.a("StoryGroupSvc.datacard_load_more_video"), (Bundle)localObject);
      return true;
      i = 1;
    }
  }
  
  public void b(boolean paramBoolean)
  {
    if (this.g)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListView.setPadding(this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListView.getListPaddingLeft(), this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListView.getListPaddingTop(), this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListView.getListPaddingRight(), vzl.a(this, 76.0F));
      a(paramBoolean);
      return;
    }
    this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListView.setPadding(this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListView.getListPaddingLeft(), this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListView.getListPaddingTop(), this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListView.getListPaddingRight(), vzl.a(this, 89.0F));
    d(paramBoolean);
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt2 == -1) {}
    switch (paramInt1)
    {
    default: 
      if (this.jdField_a_of_type_Tpb != null) {
        this.jdField_a_of_type_Tpb.a(paramInt1, paramInt2, paramIntent);
      }
      return;
    case 1003: 
      a(paramIntent, "2");
      return;
    }
    a(paramIntent, "5");
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    this.jdField_a_of_type_Vzj = new vzj(this, 20);
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
    this.jdField_a_of_type_Ulf = ((ulf)sxm.a(ulf.class, new Object[0]));
    d();
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
      new tjz(this.jdField_c_of_type_JavaLangString).a();
      if (this.jdField_a_of_type_Int == 5) {
        new Handler(Looper.getMainLooper()).postDelayed(new QQStoryShareGroupProfileActivity.1(this), 200L);
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
  
  public void doOnResume()
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
    this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListView.jdField_a_of_type_Umj.notifyDataSetChanged();
  }
  
  public boolean isWrapContent()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.biz.qqstory.shareGroup.infocard.QQStoryShareGroupProfileActivity
 * JD-Core Version:    0.7.0.1
 */