package com.tencent.biz.qqstory.shareGroup.infocard;

import aekt;
import alpo;
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
import bhpy;
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
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveTitleBar2;
import com.tribe.async.dispatch.Subscriber;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mzy;
import ugx;
import ume;
import uqy;
import urr;
import uyb;
import uyh;
import uyk;
import uyl;
import uym;
import uyr;
import vdt;
import vyx;
import vzx;
import vzy;
import vzz;
import waa;
import wab;
import wac;
import wad;
import wae;
import waf;
import wag;
import wah;
import wai;
import waj;
import wak;
import wam;
import wan;
import wao;
import wap;
import wbb;
import wbn;
import wiz;
import wta;
import xmq;
import xob;
import xod;

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
  uyh jdField_a_of_type_Uyh;
  public vdt a;
  vzx jdField_a_of_type_Vzx;
  public wap a;
  public wbb a;
  public xob a;
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
      if (!xmq.b(paramList.collectionTime)) {
        localArrayList.add(1, localVideoCollectionItem3);
      }
      for (;;)
      {
        return localArrayList;
        paramList.collectionVideoUIItemList.add(0, new wiz());
      }
    }
    if (xmq.a(paramList.collectionTime)) {
      if (xmq.b(localVideoCollectionItem1.collectionTime)) {
        localVideoCollectionItem1.collectionVideoUIItemList.add(0, new wiz());
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
      wta.a("share_story", "clk_add_suc", j, m, new String[] { paramString, String.valueOf(n), String.valueOf(i) });
      if ((this.jdField_a_of_type_Int != 8) || (this.jdField_d_of_type_Int != 0)) {
        break label241;
      }
      paramIntent = aekt.a(new Intent(this, SplashActivity.class), new int[] { 2 });
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
        this.jdField_b_of_type_AndroidWidgetTextView.setText(2131700072);
        this.jdField_a_of_type_AndroidViewView.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetTextView.setText(paramShareGroupItem.name);
        this.jdField_a_of_type_Xob.a(true, false);
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
        this.jdField_a_of_type_AndroidWidgetTextView.setText(ugx.jdField_a_of_type_JavaLangString);
        this.jdField_a_of_type_Xob.a(true, false);
        this.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(8);
      }
      for (;;)
      {
        if (this.f) {
          break label338;
        }
        this.f = true;
        wta.a("share_story", "exp_data", paramShareGroupItem.getReportGroupProp(), ume.a(2131427362), new String[] { paramShareGroupItem.getReportUserType(), this.jdField_a_of_type_Int + "" });
        return;
        i = 0;
        break;
        bool = false;
        break label148;
        this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListView.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(0);
        this.jdField_a_of_type_Xob.a(false, false);
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
    vyx localvyx;
    if (this.jdField_c_of_type_Int == 1)
    {
      i = 3;
      if (this.jdField_c_of_type_Int != 1) {
        break label122;
      }
      j = 2;
      wta.a("share_story", "clk_add_entry", i, j, new String[] { paramString });
      localvyx = new vyx(this.app);
      if (!"2".equals(paramString)) {
        break label128;
      }
      i = 2;
    }
    for (;;)
    {
      localvyx.a(this, this.jdField_a_of_type_ComTencentBizQqstoryShareGroupModelShareGroupItem.type, this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_ComTencentBizQqstoryShareGroupModelShareGroupItem.name, this.jdField_a_of_type_ComTencentBizQqstoryShareGroupModelShareGroupItem.groupUin, paramInt, i);
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
  
  private void a(uyb paramuyb)
  {
    List localList = a(paramuyb.jdField_a_of_type_JavaUtilList, paramuyb.jdField_c_of_type_Boolean);
    if (paramuyb.jdField_c_of_type_Boolean)
    {
      if ((paramuyb.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess()) && (paramuyb.e))
      {
        this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListView.jdField_a_of_type_Wbb.a(localList, paramuyb.jdField_a_of_type_Boolean);
        if (!paramuyb.jdField_b_of_type_Boolean) {
          this.jdField_a_of_type_Boolean = true;
        }
        this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListView.setLoadMoreState(true, paramuyb.jdField_a_of_type_Boolean);
      }
      this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListView.a(paramuyb.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess(), paramuyb.jdField_a_of_type_Boolean);
      if (!paramuyb.jdField_b_of_type_Boolean) {
        if (this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListView.jdField_a_of_type_Wbb.isEmpty())
        {
          this.jdField_a_of_type_AndroidViewView.setVisibility(0);
          this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListView.setEnabled(false);
          this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetLoadMoreLayout.a(0);
        }
      }
      while (this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListView.jdField_a_of_type_Wbb.isEmpty()) {
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
    if ((paramuyb.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess()) && (paramuyb.e)) {
      this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListView.jdField_a_of_type_Wbb.c(localList, paramuyb.jdField_a_of_type_Boolean);
    }
    this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListView.setLoadMoreState(paramuyb.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess(), paramuyb.jdField_a_of_type_Boolean);
  }
  
  private void a(uyk paramuyk)
  {
    if (paramuyk.jdField_c_of_type_Boolean) {}
    for (;;)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetLoadMoreLayout.a(0);
      this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListView.setLoadMoreState(true, paramuyk.jdField_a_of_type_Boolean);
      this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListView.a(paramuyk.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess(), paramuyk.jdField_a_of_type_Boolean);
      return;
      if ((paramuyk.jdField_a_of_type_JavaUtilArrayList != null) && (paramuyk.jdField_a_of_type_JavaUtilArrayList.size() > 0))
      {
        if (paramuyk.jdField_b_of_type_Boolean) {
          this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListView.jdField_a_of_type_Wbb.f(paramuyk.jdField_a_of_type_JavaUtilArrayList, paramuyk.jdField_a_of_type_Boolean);
        } else {
          this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListView.jdField_a_of_type_Wbb.e(paramuyk.jdField_a_of_type_JavaUtilArrayList, paramuyk.jdField_a_of_type_Boolean);
        }
      }
      else if (!paramuyk.jdField_b_of_type_Boolean)
      {
        this.jdField_a_of_type_AndroidViewView.setVisibility(0);
        this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListView.setEnabled(false);
        this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListView.jdField_a_of_type_Wbb.a();
      }
    }
  }
  
  private void a(uym paramuym)
  {
    QQToast.a(this, 1, alpo.a(2131711423), 1).a();
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
      this.jdField_a_of_type_Wbb.a(paramShareGroupItem);
      return;
      label54:
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
    }
  }
  
  private void c(boolean paramBoolean)
  {
    ShareGroupItem localShareGroupItem = ((wbn)urr.a(7)).a(this.jdField_b_of_type_JavaLangString);
    if ((localShareGroupItem != null) && (!paramBoolean)) {
      a(localShareGroupItem);
    }
    if (this.jdField_c_of_type_Int == 1)
    {
      new uyl(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString).a();
      return;
    }
    localShareGroupItem = new ShareGroupItem();
    localShareGroupItem.type = 2;
    a(localShareGroupItem);
  }
  
  private void d()
  {
    View localView = LayoutInflater.from(this).inflate(2131561551, null, false);
    super.setContentViewNoTitle(localView);
    this.jdField_a_of_type_Xob.a(localView);
    this.jdField_a_of_type_Xob.a(false, false);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)super.findViewById(2131377935));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131368659));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131368613));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131368627));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131368644));
    this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2 = ((ImmersiveTitleBar2)super.findViewById(2131377976));
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetLoadMoreLayout = ((LoadMoreLayout)super.findViewById(2131369210));
    this.jdField_a_of_type_AndroidViewView = super.findViewById(2131365759);
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    this.jdField_a_of_type_AndroidViewView.setBackgroundResource(2130839211);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131365738));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131365750));
    this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListView = ((ShareGroupsListView)super.findViewById(2131376554));
    this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListView.setContentBackground(2130839211);
    this.jdField_a_of_type_AndroidWidgetImageButton = ((ImageButton)super.findViewById(2131373778));
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetLoadMoreLayout.a(1);
    this.jdField_a_of_type_Vzx.a(this, this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListView.getRootView());
    e();
  }
  
  private void d(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Wap == null) {
      this.jdField_a_of_type_Wap = new wap(this.jdField_b_of_type_JavaLangString, this.jdField_c_of_type_Int, this.jdField_a_of_type_JavaLangString);
    }
    this.jdField_a_of_type_Wap.a();
    if (this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListView.jdField_a_of_type_Wbb.isEmpty()) {
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetLoadMoreLayout.a(1);
    }
    if (paramBoolean)
    {
      this.jdField_a_of_type_Wap.c();
      return;
    }
    this.jdField_a_of_type_Wap.d();
  }
  
  private void e()
  {
    this.jdField_a_of_type_Wbb = ((wbb)ume.a(wbb.class, new Object[] { this, Boolean.valueOf(this.g) }));
    this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListView.setListAdapter(this.jdField_a_of_type_Wbb);
    wak localwak = new wak(this);
    this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListView.setUIEventListener(localwak);
    this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListView.setOnScrollChangeListener(localwak);
    this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListView.setOnScrollListener(localwak);
    this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListView.setLoadMoreState(true, true);
    this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(localwak);
    this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(localwak);
    this.jdField_a_of_type_AndroidWidgetImageButton.setOnClickListener(localwak);
  }
  
  private void f()
  {
    bhpy localbhpy = bhpy.a(this);
    if (this.jdField_c_of_type_Int == 1) {
      localbhpy.a(alpo.a(2131711396), 5);
    }
    localbhpy.c(2131690648);
    localbhpy.a(new vzy(this, localbhpy));
    if (!localbhpy.isShowing()) {
      localbhpy.show();
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
    if (this.jdField_a_of_type_Uyh == null) {
      this.jdField_a_of_type_Uyh = new uyh(this.jdField_b_of_type_JavaLangString);
    }
    this.jdField_a_of_type_Uyh.b();
  }
  
  public void a(String paramString)
  {
    Iterator localIterator = this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListView.jdField_a_of_type_Wbb.a().iterator();
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
    paramMap.put(new wac(this), "");
    paramMap.put(new wae(this), "");
    paramMap.put(new wad(this), "");
    paramMap.put(new wam(this), "");
    paramMap.put(new waf(this), "");
    paramMap.put(new waa(this), "");
    paramMap.put(new wan(this), "");
    paramMap.put(new wag(this), "");
    paramMap.put(new wai(this), "");
    paramMap.put(new waj(this), "");
    paramMap.put(new wao(this), "");
    paramMap.put(new wab(this), "");
    paramMap.put(new wah(this), "");
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListView.jdField_a_of_type_Wbb.jdField_a_of_type_JavaUtilList.size() <= 0) {
        break label95;
      }
      this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListView.jdField_a_of_type_Wbb.e(this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListView.jdField_a_of_type_Wbb.jdField_a_of_type_JavaUtilList, false);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Uyh == null) {
        this.jdField_a_of_type_Uyh = new uyh(this.jdField_b_of_type_JavaLangString);
      }
      if (this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListView.jdField_a_of_type_Wbb.isEmpty()) {
        this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetLoadMoreLayout.a(1);
      }
      this.jdField_a_of_type_Uyh.a();
      return;
      label95:
      List localList = ((uqy)urr.a(25)).a(this.jdField_b_of_type_JavaLangString);
      this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListView.jdField_a_of_type_Wbb.e(localList, false);
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
      mzy.a(this.app, new vzz(this), localReqLoadMoreVideoList.toByteArray(), ume.a("StoryGroupSvc.datacard_load_more_video"), (Bundle)localObject);
      return true;
      i = 1;
    }
  }
  
  public void b(boolean paramBoolean)
  {
    if (this.g)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListView.setPadding(this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListView.getListPaddingLeft(), this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListView.getListPaddingTop(), this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListView.getListPaddingRight(), xod.a(this, 76.0F));
      a(paramBoolean);
      return;
    }
    this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListView.setPadding(this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListView.getListPaddingLeft(), this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListView.getListPaddingTop(), this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListView.getListPaddingRight(), xod.a(this, 89.0F));
    d(paramBoolean);
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt2 == -1) {}
    switch (paramInt1)
    {
    default: 
      if (this.jdField_a_of_type_Vdt != null) {
        this.jdField_a_of_type_Vdt.a(paramInt1, paramInt2, paramIntent);
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
    this.jdField_a_of_type_Xob = new xob(this, 20);
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
    this.jdField_a_of_type_Vzx = ((vzx)ume.a(vzx.class, new Object[0]));
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
      new uyr(this.jdField_c_of_type_JavaLangString).a();
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
    this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListView.jdField_a_of_type_Wbb.notifyDataSetChanged();
  }
  
  public boolean isWrapContent()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.shareGroup.infocard.QQStoryShareGroupProfileActivity
 * JD-Core Version:    0.7.0.1
 */