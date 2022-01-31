package com.tencent.mobileqq.activity.selectmember;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.ProtoUtils;
import com.tencent.biz.ProtoUtils.TroopProtocolObserver;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.adapter.FacePreloadBaseAdapter;
import com.tencent.mobileqq.app.DiscussionManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.TroopObserver;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.CommonlyUsedTroop;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import tencent.im.oidb.cmd0x88d.oidb_0x88d.GroupInfo;
import tencent.im.oidb.cmd0x88d.oidb_0x88d.ReqBody;
import tencent.im.oidb.cmd0x88d.oidb_0x88d.ReqGroupInfo;
import yim;
import yip;

public class TroopListAdapter
  extends FacePreloadBaseAdapter
{
  public int a;
  protected Context a;
  protected LayoutInflater a;
  protected View.OnClickListener a;
  private ProtoUtils.TroopProtocolObserver jdField_a_of_type_ComTencentBizProtoUtils$TroopProtocolObserver = new yim(this);
  protected DiscussionManager a;
  public QQAppInterface a;
  TroopObserver jdField_a_of_type_ComTencentMobileqqAppTroopObserver = new yip(this);
  protected XListView a;
  protected List a;
  public int b;
  public int c;
  public int d;
  public int e;
  private int f;
  private int g;
  private int h;
  
  public TroopListAdapter(Context paramContext, QQAppInterface paramQQAppInterface, XListView paramXListView, int paramInt, boolean paramBoolean, View.OnClickListener paramOnClickListener)
  {
    super(paramContext, paramQQAppInterface, paramXListView, paramInt, paramBoolean);
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(paramContext);
    this.jdField_a_of_type_ComTencentWidgetXListView = paramXListView;
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
    this.g = paramContext.getResources().getColor(2131494220);
    this.h = Color.parseColor("#808080");
    this.jdField_a_of_type_ComTencentMobileqqAppDiscussionManager = ((DiscussionManager)paramQQAppInterface.getManager(52));
    paramQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, ProtoUtils.TroopProtocolObserver paramTroopProtocolObserver, ArrayList paramArrayList)
  {
    oidb_0x88d.ReqBody localReqBody = new oidb_0x88d.ReqBody();
    localReqBody.uint32_appid.set(AppSetting.jdField_a_of_type_Int);
    Object localObject = paramArrayList.iterator();
    int i = 0;
    int j;
    do
    {
      if (!((Iterator)localObject).hasNext()) {
        break;
      }
      String str = (String)((Iterator)localObject).next();
      j = i + 1;
      oidb_0x88d.GroupInfo localGroupInfo = new oidb_0x88d.GroupInfo();
      localGroupInfo.uint32_app_privilege_flag.set(0);
      oidb_0x88d.ReqGroupInfo localReqGroupInfo = new oidb_0x88d.ReqGroupInfo();
      localReqGroupInfo.uint64_group_code.set(Long.parseLong(str));
      localReqGroupInfo.stgroupinfo.set(localGroupInfo);
      localReqBody.stzreqgroupinfo.add(localReqGroupInfo);
      i = j;
    } while (j != 49);
    localObject = new Bundle();
    if (paramArrayList.size() > 50)
    {
      i = 0;
      while (i < 50)
      {
        paramArrayList.remove(0);
        i += 1;
      }
      ((Bundle)localObject).putStringArrayList("TroopList", paramArrayList);
    }
    ProtoUtils.b(paramQQAppInterface, paramTroopProtocolObserver, localReqBody.toByteArray(), "OidbSvc.0x88d_0", 2189, 0, (Bundle)localObject);
  }
  
  public void Z_()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver);
    super.Z_();
  }
  
  public int a(int paramInt)
  {
    switch (paramInt)
    {
    case 1: 
    default: 
      return 1;
    case 4: 
      return 2;
    case 2: 
      return 3;
    }
    return 4;
  }
  
  public void a(QQAppInterface paramQQAppInterface, ArrayList paramArrayList)
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    Object localObject1 = (TroopManager)paramQQAppInterface.getManager(51);
    Object localObject6 = new ArrayList();
    Object localObject2 = ((TroopManager)localObject1).a();
    if (localObject2 != null)
    {
      Collections.sort((List)localObject2, new TroopListAdapter.CommonlyUsedTroopCompator(this));
      localObject2 = ((List)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = ((TroopManager)localObject1).a(((CommonlyUsedTroop)((Iterator)localObject2).next()).troopUin);
        if ((localObject3 != null) && (!((TroopInfo)localObject3).isQidianPrivateTroop())) {
          ((List)localObject6).add(localObject3);
        }
      }
      this.d = ((List)localObject6).size();
    }
    Object localObject4 = new ArrayList();
    Object localObject3 = new ArrayList();
    localObject1 = new ArrayList();
    Object localObject7 = new ArrayList();
    localObject2 = paramArrayList.iterator();
    label334:
    while (((Iterator)localObject2).hasNext())
    {
      localObject5 = (TroopInfo)((Iterator)localObject2).next();
      if (!((TroopInfo)localObject5).isQidianPrivateTroop())
      {
        int i = a(paramQQAppInterface.b(((TroopInfo)localObject5).troopuin));
        if ((((TroopInfo)localObject5).dwAdditionalFlag & 1L) == 1L) {
          ((List)localObject4).add(new TroopListAdapter.TroopListItemWithMask(this, i, (Entity)localObject5));
        }
        for (;;)
        {
          if (((TroopInfo)localObject5).hasSetTroopName()) {
            break label334;
          }
          ((List)localObject7).add(new TroopListAdapter.TroopListItemWithMask(this, i, (Entity)localObject5));
          break;
          if ((((TroopInfo)localObject5).dwCmdUinUinFlag & 1L) == 1L) {
            ((List)localObject3).add(new TroopListAdapter.TroopListItemWithMask(this, i, (Entity)localObject5));
          } else {
            ((List)localObject1).add(new TroopListAdapter.TroopListItemWithMask(this, i, (Entity)localObject5));
          }
        }
      }
    }
    localObject2 = new TroopListAdapter.TroopCompator(this);
    Collections.sort((List)localObject4, (Comparator)localObject2);
    Collections.sort((List)localObject3, (Comparator)localObject2);
    Collections.sort((List)localObject1, (Comparator)localObject2);
    Collections.sort((List)localObject7, (Comparator)localObject2);
    Object localObject10 = ((DiscussionManager)paramQQAppInterface.getManager(52)).a();
    Object localObject8 = new ArrayList();
    Object localObject5 = new ArrayList();
    localObject2 = new ArrayList();
    ArrayList localArrayList = new ArrayList();
    Object localObject9 = paramQQAppInterface.a().a();
    localObject10 = ((List)localObject10).iterator();
    label552:
    while (((Iterator)localObject10).hasNext())
    {
      DiscussionInfo localDiscussionInfo = (DiscussionInfo)((Iterator)localObject10).next();
      if (((RecentUserProxy)localObject9).a(localDiscussionInfo.uin, 3000).showUpTime != 0L) {
        ((List)localObject8).add(localDiscussionInfo);
      }
      if (paramQQAppInterface.c().equals(localDiscussionInfo.ownerUin)) {
        ((List)localObject5).add(localDiscussionInfo);
      }
      for (;;)
      {
        if (localDiscussionInfo.hasRenamed()) {
          break label552;
        }
        localArrayList.add(localDiscussionInfo);
        break;
        ((List)localObject2).add(localDiscussionInfo);
      }
    }
    this.d += ((List)localObject8).size();
    if (this.d > 0)
    {
      this.jdField_a_of_type_JavaUtilList.add(new TroopListAdapter.TroopListItem(this, 0, null));
      localObject6 = ((List)localObject6).iterator();
      while (((Iterator)localObject6).hasNext())
      {
        localObject9 = (Entity)((Iterator)localObject6).next();
        this.jdField_a_of_type_JavaUtilList.add(new TroopListAdapter.TroopListItem(this, 1, (Entity)localObject9));
      }
      localObject6 = ((List)localObject8).iterator();
      while (((Iterator)localObject6).hasNext())
      {
        localObject8 = (DiscussionInfo)((Iterator)localObject6).next();
        this.jdField_a_of_type_JavaUtilList.add(new TroopListAdapter.TroopListItem(this, 1, (DiscussionInfo)localObject8));
      }
    }
    this.e = (((List)localObject7).size() + localArrayList.size());
    if (this.e > 0)
    {
      this.jdField_a_of_type_JavaUtilList.add(new TroopListAdapter.TroopListItem(this, 8, null));
      localObject6 = ((List)localObject7).iterator();
      while (((Iterator)localObject6).hasNext())
      {
        localObject7 = (TroopListAdapter.TroopListItemWithMask)((Iterator)localObject6).next();
        this.jdField_a_of_type_JavaUtilList.add(new TroopListAdapter.TroopListItem(this, 9, ((TroopListAdapter.TroopListItemWithMask)localObject7).a));
      }
      localObject6 = localArrayList.iterator();
      while (((Iterator)localObject6).hasNext())
      {
        localObject7 = (DiscussionInfo)((Iterator)localObject6).next();
        this.jdField_a_of_type_JavaUtilList.add(new TroopListAdapter.TroopListItem(this, 9, (DiscussionInfo)localObject7));
      }
    }
    this.jdField_a_of_type_Int = (((List)localObject4).size() + ((List)localObject5).size());
    if (this.jdField_a_of_type_Int > 0)
    {
      this.jdField_a_of_type_JavaUtilList.add(new TroopListAdapter.TroopListItem(this, 4, null));
      localObject4 = ((List)localObject4).iterator();
      while (((Iterator)localObject4).hasNext())
      {
        localObject6 = (TroopListAdapter.TroopListItemWithMask)((Iterator)localObject4).next();
        this.jdField_a_of_type_JavaUtilList.add(new TroopListAdapter.TroopListItem(this, 5, ((TroopListAdapter.TroopListItemWithMask)localObject6).a));
      }
      localObject4 = ((List)localObject5).iterator();
      while (((Iterator)localObject4).hasNext())
      {
        localObject5 = (DiscussionInfo)((Iterator)localObject4).next();
        this.jdField_a_of_type_JavaUtilList.add(new TroopListAdapter.TroopListItem(this, 5, (DiscussionInfo)localObject5));
      }
    }
    this.b = ((List)localObject3).size();
    if (this.b > 0)
    {
      this.jdField_a_of_type_JavaUtilList.add(new TroopListAdapter.TroopListItem(this, 6, null));
      localObject3 = ((List)localObject3).iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localObject4 = (TroopListAdapter.TroopListItemWithMask)((Iterator)localObject3).next();
        this.jdField_a_of_type_JavaUtilList.add(new TroopListAdapter.TroopListItem(this, 7, ((TroopListAdapter.TroopListItemWithMask)localObject4).a));
      }
    }
    this.c = (((List)localObject1).size() + ((List)localObject2).size());
    if (this.c > 0)
    {
      this.jdField_a_of_type_JavaUtilList.add(new TroopListAdapter.TroopListItem(this, 2, null));
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject3 = (TroopListAdapter.TroopListItemWithMask)((Iterator)localObject1).next();
        this.jdField_a_of_type_JavaUtilList.add(new TroopListAdapter.TroopListItem(this, 3, ((TroopListAdapter.TroopListItemWithMask)localObject3).a));
      }
      localObject1 = ((List)localObject2).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (DiscussionInfo)((Iterator)localObject1).next();
        this.jdField_a_of_type_JavaUtilList.add(new TroopListAdapter.TroopListItem(this, 3, (DiscussionInfo)localObject2));
      }
    }
    if ((this.jdField_a_of_type_AndroidContentContext instanceof SelectMemberActivity))
    {
      this.f = ((SelectMemberActivity)this.jdField_a_of_type_AndroidContentContext).c();
      if (this.f == 3000)
      {
        localObject1 = new ArrayList();
        paramArrayList = paramArrayList.iterator();
        while (paramArrayList.hasNext()) {
          ((ArrayList)localObject1).add(((TroopInfo)paramArrayList.next()).troopuin);
        }
        a(paramQQAppInterface, this.jdField_a_of_type_ComTencentBizProtoUtils$TroopProtocolObserver, (ArrayList)localObject1);
      }
    }
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      return 0;
    }
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public Object getItem(int paramInt)
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (paramInt >= 0) && (paramInt < this.jdField_a_of_type_JavaUtilList.size())) {
      return this.jdField_a_of_type_JavaUtilList.get(paramInt);
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  @TargetApi(16)
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    TroopListAdapter.TroopListItem localTroopListItem = (TroopListAdapter.TroopListItem)getItem(paramInt);
    if (localTroopListItem == null) {
      localObject1 = paramView;
    }
    View localView;
    Object localObject2;
    label584:
    do
    {
      return localObject1;
      if ((paramView != null) && (paramView.getTag() != null)) {
        paramViewGroup = (TroopListAdapter.TroopViewHolder)paramView.getTag();
      }
      for (;;)
      {
        localView = paramView.findViewById(2131366539);
        localObject2 = (TextView)paramView.findViewById(2131366490);
        if (localTroopListItem.jdField_a_of_type_Int != 0) {
          break;
        }
        localView.setVisibility(8);
        ((TextView)localObject2).setVisibility(0);
        ((TextView)localObject2).setText(this.jdField_a_of_type_AndroidContentContext.getString(2131429839, new Object[] { String.valueOf(this.d) }));
        return paramView;
        paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130971594, this.jdField_a_of_type_ComTencentWidgetXListView, false);
        paramViewGroup = new TroopListAdapter.TroopViewHolder(this);
        paramViewGroup.c = ((ImageView)paramView.findViewById(2131362744));
        paramViewGroup.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131375138));
        paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131363713));
        paramViewGroup.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131375139));
        paramViewGroup.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131363462));
        paramView.setTag(paramViewGroup);
      }
      if (localTroopListItem.jdField_a_of_type_Int == 2)
      {
        localView.setVisibility(8);
        ((TextView)localObject2).setVisibility(0);
        ((TextView)localObject2).setText(this.jdField_a_of_type_AndroidContentContext.getString(2131429832, new Object[] { String.valueOf(this.c) }));
        return paramView;
      }
      if (localTroopListItem.jdField_a_of_type_Int == 4)
      {
        localView.setVisibility(8);
        ((TextView)localObject2).setVisibility(0);
        ((TextView)localObject2).setText(this.jdField_a_of_type_AndroidContentContext.getString(2131429830, new Object[] { String.valueOf(this.jdField_a_of_type_Int) }));
        return paramView;
      }
      if (localTroopListItem.jdField_a_of_type_Int == 6)
      {
        localView.setVisibility(8);
        ((TextView)localObject2).setVisibility(0);
        ((TextView)localObject2).setText(this.jdField_a_of_type_AndroidContentContext.getString(2131429831, new Object[] { String.valueOf(this.b) }));
        return paramView;
      }
      if (localTroopListItem.jdField_a_of_type_Int == 8)
      {
        localView.setVisibility(8);
        ((TextView)localObject2).setVisibility(0);
        ((TextView)localObject2).setText(this.jdField_a_of_type_AndroidContentContext.getString(2131429833, new Object[] { String.valueOf(this.e) }));
        return paramView;
      }
      if (localTroopListItem.jdField_a_of_type_ComTencentMobileqqDataTroopInfo != null)
      {
        localView.setVisibility(0);
        ((TextView)localObject2).setVisibility(8);
        localObject2 = localTroopListItem.jdField_a_of_type_ComTencentMobileqqDataTroopInfo;
        paramViewGroup.jdField_a_of_type_JavaLangString = ((TroopInfo)localObject2).troopuin;
        TextView localTextView = paramViewGroup.jdField_a_of_type_AndroidWidgetTextView;
        if (((TroopInfo)localObject2).getTroopName() != null)
        {
          localObject1 = ((TroopInfo)localObject2).getTroopName();
          localTextView.setText((CharSequence)localObject1);
          paramViewGroup.c.setImageBitmap(a(4, ((TroopInfo)localObject2).troopuin));
          paramViewGroup.jdField_a_of_type_ComTencentMobileqqDataTroopInfo = ((TroopInfo)localObject2);
          paramViewGroup.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo = null;
          paramViewGroup.jdField_a_of_type_Int = localTroopListItem.jdField_a_of_type_Int;
          if ((((TroopInfo)localObject2).hasSetTroopName()) || (((TroopInfo)localObject2).wMemberNumClient <= 0)) {
            break label676;
          }
          paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
          paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setText(String.format("(%d)", new Object[] { Integer.valueOf(((TroopInfo)localObject2).wMemberNumClient) }));
          if ((((TroopInfo)localObject2).isAllowCreateDiscuss()) || (((TroopInfo)localObject2).isTroopOwner(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())) || (((TroopInfo)localObject2).isTroopAdmin(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()))) {
            break label688;
          }
          localView.setEnabled(false);
          paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
          paramViewGroup.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
          paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.h);
        }
        for (;;)
        {
          paramView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
          return paramView;
          localObject1 = ((TroopInfo)localObject2).troopcode;
          break;
          paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
          break label584;
          paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
          paramViewGroup.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
          paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.g);
        }
      }
      localObject1 = paramView;
    } while (localTroopListItem.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo == null);
    label676:
    label688:
    localView.setVisibility(0);
    ((TextView)localObject2).setVisibility(8);
    Object localObject1 = localTroopListItem.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo;
    paramViewGroup.jdField_a_of_type_JavaLangString = ((DiscussionInfo)localObject1).uin;
    paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(ContactUtils.a(this.jdField_a_of_type_AndroidContentContext, (DiscussionInfo)localObject1));
    paramViewGroup.c.setImageBitmap(a(101, ((DiscussionInfo)localObject1).uin));
    if (!((DiscussionInfo)localObject1).hasRenamed())
    {
      paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setText(String.format("(%d)", new Object[] { Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqAppDiscussionManager.a(((DiscussionInfo)localObject1).uin)) }));
    }
    paramViewGroup.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo = ((DiscussionInfo)localObject1);
    paramViewGroup.jdField_a_of_type_ComTencentMobileqqDataTroopInfo = null;
    paramViewGroup.jdField_a_of_type_Int = localTroopListItem.jdField_a_of_type_Int;
    paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    paramViewGroup.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
    paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.g);
    paramView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    return paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.selectmember.TroopListAdapter
 * JD-Core Version:    0.7.0.1
 */