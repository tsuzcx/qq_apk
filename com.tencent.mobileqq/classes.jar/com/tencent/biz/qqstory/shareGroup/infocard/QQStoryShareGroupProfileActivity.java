package com.tencent.biz.qqstory.shareGroup.infocard;

import Override;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import anvx;
import bkzi;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.network.pb.qqstory_service.ReqLoadMoreVideoList;
import com.tencent.biz.qqstory.shareGroup.infocard.view.ShareGroupsListView;
import com.tencent.biz.qqstory.shareGroup.model.ShareGroupItem;
import com.tencent.biz.qqstory.storyHome.QQStoryBaseActivity;
import com.tencent.biz.qqstory.storyHome.StoryTransitionActivity;
import com.tencent.biz.qqstory.storyHome.memory.model.VideoCollectionItem;
import com.tencent.biz.qqstory.troop.activity.TroopStoryMainActivity;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.biz.qqstory.view.widget.LoadMoreLayout;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.immersive.ImmersiveTitleBar2;
import com.tribe.async.dispatch.Subscriber;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import ntb;
import vzh;
import weg;
import wiz;
import wjs;
import wqc;
import wqi;
import wql;
import wqm;
import wqn;
import wqs;
import wvu;
import xqs;
import xrs;
import xrt;
import xru;
import xrv;
import xrw;
import xrx;
import xry;
import xrz;
import xsa;
import xsb;
import xsc;
import xsd;
import xse;
import xsf;
import xsh;
import xsi;
import xsj;
import xsk;
import xsw;
import xti;
import yau;
import ykv;
import zdu;
import zff;

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
  wqi jdField_a_of_type_Wqi;
  public wvu a;
  xrs jdField_a_of_type_Xrs;
  public xsk a;
  public xsw a;
  public zff a;
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
      if (!zdu.b(paramList.collectionTime)) {
        localArrayList.add(1, localVideoCollectionItem3);
      }
      for (;;)
      {
        return localArrayList;
        paramList.collectionVideoUIItemList.add(0, new yau());
      }
    }
    if (zdu.a(paramList.collectionTime)) {
      if (zdu.b(localVideoCollectionItem1.collectionTime)) {
        localVideoCollectionItem1.collectionVideoUIItemList.add(0, new yau());
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
      ykv.a("share_story", "clk_add_suc", j, m, new String[] { paramString, String.valueOf(n), String.valueOf(i) });
      if ((this.jdField_a_of_type_Int != 8) || (this.jdField_d_of_type_Int != 0)) {
        break label241;
      }
      paramIntent = AIOUtils.setOpenAIOIntent(new Intent(this, SplashActivity.class), new int[] { 2 });
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
        this.jdField_b_of_type_AndroidWidgetTextView.setText(2131699203);
        this.jdField_a_of_type_AndroidViewView.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetTextView.setText(paramShareGroupItem.name);
        this.jdField_a_of_type_Zff.a(true, false);
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
        this.jdField_a_of_type_AndroidWidgetTextView.setText(vzh.jdField_a_of_type_JavaLangString);
        this.jdField_a_of_type_Zff.a(true, false);
        this.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(8);
      }
      for (;;)
      {
        if (this.f) {
          break label338;
        }
        this.f = true;
        ykv.a("share_story", "exp_data", paramShareGroupItem.getReportGroupProp(), weg.a(2131427362), new String[] { paramShareGroupItem.getReportUserType(), this.jdField_a_of_type_Int + "" });
        return;
        i = 0;
        break;
        bool = false;
        break label148;
        this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListView.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(0);
        this.jdField_a_of_type_Zff.a(false, false);
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
    xqs localxqs;
    if (this.jdField_c_of_type_Int == 1)
    {
      i = 3;
      if (this.jdField_c_of_type_Int != 1) {
        break label122;
      }
      j = 2;
      ykv.a("share_story", "clk_add_entry", i, j, new String[] { paramString });
      localxqs = new xqs(this.app);
      if (!"2".equals(paramString)) {
        break label128;
      }
      i = 2;
    }
    for (;;)
    {
      localxqs.a(this, this.jdField_a_of_type_ComTencentBizQqstoryShareGroupModelShareGroupItem.type, this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_ComTencentBizQqstoryShareGroupModelShareGroupItem.name, this.jdField_a_of_type_ComTencentBizQqstoryShareGroupModelShareGroupItem.groupUin, paramInt, i);
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
  
  private void a(wqc paramwqc)
  {
    List localList = a(paramwqc.jdField_a_of_type_JavaUtilList, paramwqc.jdField_c_of_type_Boolean);
    if (paramwqc.jdField_c_of_type_Boolean)
    {
      if ((paramwqc.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess()) && (paramwqc.e))
      {
        this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListView.jdField_a_of_type_Xsw.a(localList, paramwqc.jdField_a_of_type_Boolean);
        if (!paramwqc.jdField_b_of_type_Boolean) {
          this.jdField_a_of_type_Boolean = true;
        }
        this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListView.setLoadMoreState(true, paramwqc.jdField_a_of_type_Boolean);
      }
      this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListView.a(paramwqc.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess(), paramwqc.jdField_a_of_type_Boolean);
      if (!paramwqc.jdField_b_of_type_Boolean) {
        if (this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListView.jdField_a_of_type_Xsw.isEmpty())
        {
          this.jdField_a_of_type_AndroidViewView.setVisibility(0);
          this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListView.setEnabled(false);
          this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetLoadMoreLayout.a(0);
        }
      }
      while (this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListView.jdField_a_of_type_Xsw.isEmpty()) {
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
    if ((paramwqc.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess()) && (paramwqc.e)) {
      this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListView.jdField_a_of_type_Xsw.c(localList, paramwqc.jdField_a_of_type_Boolean);
    }
    this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListView.setLoadMoreState(paramwqc.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess(), paramwqc.jdField_a_of_type_Boolean);
  }
  
  private void a(wql paramwql)
  {
    if (paramwql.jdField_c_of_type_Boolean) {}
    for (;;)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetLoadMoreLayout.a(0);
      this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListView.setLoadMoreState(true, paramwql.jdField_a_of_type_Boolean);
      this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListView.a(paramwql.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess(), paramwql.jdField_a_of_type_Boolean);
      return;
      if ((paramwql.jdField_a_of_type_JavaUtilArrayList != null) && (paramwql.jdField_a_of_type_JavaUtilArrayList.size() > 0))
      {
        if (paramwql.jdField_b_of_type_Boolean) {
          this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListView.jdField_a_of_type_Xsw.f(paramwql.jdField_a_of_type_JavaUtilArrayList, paramwql.jdField_a_of_type_Boolean);
        } else {
          this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListView.jdField_a_of_type_Xsw.e(paramwql.jdField_a_of_type_JavaUtilArrayList, paramwql.jdField_a_of_type_Boolean);
        }
      }
      else if (!paramwql.jdField_b_of_type_Boolean)
      {
        this.jdField_a_of_type_AndroidViewView.setVisibility(0);
        this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListView.setEnabled(false);
        this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListView.jdField_a_of_type_Xsw.a();
      }
    }
  }
  
  private void a(wqn paramwqn)
  {
    QQToast.a(this, 1, anvx.a(2131710499), 1).a();
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
      this.jdField_a_of_type_Xsw.a(paramShareGroupItem);
      return;
      label54:
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
    }
  }
  
  private void c(boolean paramBoolean)
  {
    ShareGroupItem localShareGroupItem = ((xti)wjs.a(7)).a(this.jdField_b_of_type_JavaLangString);
    if ((localShareGroupItem != null) && (!paramBoolean)) {
      a(localShareGroupItem);
    }
    if (this.jdField_c_of_type_Int == 1)
    {
      new wqm(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString).a();
      return;
    }
    localShareGroupItem = new ShareGroupItem();
    localShareGroupItem.type = 2;
    a(localShareGroupItem);
  }
  
  private void d()
  {
    View localView = LayoutInflater.from(this).inflate(2131561791, null, false);
    super.setContentViewNoTitle(localView);
    this.jdField_a_of_type_Zff.a(localView);
    this.jdField_a_of_type_Zff.a(false, false);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)super.findViewById(2131379056));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131369278));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131369231));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131369245));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131369262));
    this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2 = ((ImmersiveTitleBar2)super.findViewById(2131379099));
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetLoadMoreLayout = ((LoadMoreLayout)super.findViewById(2131369869));
    this.jdField_a_of_type_AndroidViewView = super.findViewById(2131366179);
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    this.jdField_a_of_type_AndroidViewView.setBackgroundResource(2130839453);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131366159));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131366170));
    this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListView = ((ShareGroupsListView)super.findViewById(2131377593));
    this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListView.setContentBackground(2130839453);
    this.jdField_a_of_type_AndroidWidgetImageButton = ((ImageButton)super.findViewById(2131374674));
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetLoadMoreLayout.a(1);
    this.jdField_a_of_type_Xrs.a(this, this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListView.getRootView());
    e();
  }
  
  private void d(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Xsk == null) {
      this.jdField_a_of_type_Xsk = new xsk(this.jdField_b_of_type_JavaLangString, this.jdField_c_of_type_Int, this.jdField_a_of_type_JavaLangString);
    }
    this.jdField_a_of_type_Xsk.a();
    if (this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListView.jdField_a_of_type_Xsw.isEmpty()) {
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetLoadMoreLayout.a(1);
    }
    if (paramBoolean)
    {
      this.jdField_a_of_type_Xsk.c();
      return;
    }
    this.jdField_a_of_type_Xsk.d();
  }
  
  private void e()
  {
    this.jdField_a_of_type_Xsw = ((xsw)weg.a(xsw.class, new Object[] { this, Boolean.valueOf(this.g) }));
    this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListView.setListAdapter(this.jdField_a_of_type_Xsw);
    xsf localxsf = new xsf(this);
    this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListView.setUIEventListener(localxsf);
    this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListView.setOnScrollChangeListener(localxsf);
    this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListView.setOnScrollListener(localxsf);
    this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListView.setLoadMoreState(true, true);
    this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(localxsf);
    this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(localxsf);
    this.jdField_a_of_type_AndroidWidgetImageButton.setOnClickListener(localxsf);
  }
  
  private void f()
  {
    bkzi localbkzi = bkzi.a(this);
    if (this.jdField_c_of_type_Int == 1) {
      localbkzi.a(anvx.a(2131710472), 5);
    }
    localbkzi.c(2131690697);
    localbkzi.a(new xrt(this, localbkzi));
    if (!localbkzi.isShowing()) {
      localbkzi.show();
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
    if (this.jdField_a_of_type_Wqi == null) {
      this.jdField_a_of_type_Wqi = new wqi(this.jdField_b_of_type_JavaLangString);
    }
    this.jdField_a_of_type_Wqi.b();
  }
  
  public void a(String paramString)
  {
    Iterator localIterator = this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListView.jdField_a_of_type_Xsw.a().iterator();
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
    paramMap.put(new xrx(this), "");
    paramMap.put(new xrz(this), "");
    paramMap.put(new xry(this), "");
    paramMap.put(new xsh(this), "");
    paramMap.put(new xsa(this), "");
    paramMap.put(new xrv(this), "");
    paramMap.put(new xsi(this), "");
    paramMap.put(new xsb(this), "");
    paramMap.put(new xsd(this), "");
    paramMap.put(new xse(this), "");
    paramMap.put(new xsj(this), "");
    paramMap.put(new xrw(this), "");
    paramMap.put(new xsc(this), "");
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListView.jdField_a_of_type_Xsw.jdField_a_of_type_JavaUtilList.size() <= 0) {
        break label95;
      }
      this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListView.jdField_a_of_type_Xsw.e(this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListView.jdField_a_of_type_Xsw.jdField_a_of_type_JavaUtilList, false);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Wqi == null) {
        this.jdField_a_of_type_Wqi = new wqi(this.jdField_b_of_type_JavaLangString);
      }
      if (this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListView.jdField_a_of_type_Xsw.isEmpty()) {
        this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetLoadMoreLayout.a(1);
      }
      this.jdField_a_of_type_Wqi.a();
      return;
      label95:
      List localList = ((wiz)wjs.a(25)).a(this.jdField_b_of_type_JavaLangString);
      this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListView.jdField_a_of_type_Xsw.e(localList, false);
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
      ntb.a(this.app, new xru(this), localReqLoadMoreVideoList.toByteArray(), weg.a("StoryGroupSvc.datacard_load_more_video"), (Bundle)localObject);
      return true;
      i = 1;
    }
  }
  
  public void b(boolean paramBoolean)
  {
    if (this.g)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListView.setPadding(this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListView.getListPaddingLeft(), this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListView.getListPaddingTop(), this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListView.getListPaddingRight(), UIUtils.dip2px(this, 76.0F));
      a(paramBoolean);
      return;
    }
    this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListView.setPadding(this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListView.getListPaddingLeft(), this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListView.getListPaddingTop(), this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListView.getListPaddingRight(), UIUtils.dip2px(this, 89.0F));
    d(paramBoolean);
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt2 == -1) {}
    switch (paramInt1)
    {
    default: 
      if (this.jdField_a_of_type_Wvu != null) {
        this.jdField_a_of_type_Wvu.a(paramInt1, paramInt2, paramIntent);
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
    this.jdField_a_of_type_Zff = new zff(this, 20);
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
    this.jdField_a_of_type_Xrs = ((xrs)weg.a(xrs.class, new Object[0]));
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
      new wqs(this.jdField_c_of_type_JavaLangString).a();
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
    this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListView.jdField_a_of_type_Xsw.notifyDataSetChanged();
  }
  
  public boolean isWrapContent()
  {
    return true;
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.shareGroup.infocard.QQStoryShareGroupProfileActivity
 * JD-Core Version:    0.7.0.1
 */