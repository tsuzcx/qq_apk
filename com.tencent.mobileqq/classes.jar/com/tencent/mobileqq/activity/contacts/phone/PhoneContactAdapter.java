package com.tencent.mobileqq.activity.contacts.phone;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.os.SystemClock;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.Button;
import android.widget.ImageView;
import com.tencent.image.ApngImage;
import com.tencent.mobileqq.activity.contacts.base.BuddyItemBuilder;
import com.tencent.mobileqq.activity.contacts.base.BuddyListItem;
import com.tencent.mobileqq.activity.contacts.base.BuddyListItem.ViewTag;
import com.tencent.mobileqq.activity.contacts.friend.SimpleTextView;
import com.tencent.mobileqq.adapter.FacePreloadBaseAdapter;
import com.tencent.mobileqq.addfriend.api.IAddFriendApi;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.phonecontact.api.IPhoneContactService;
import com.tencent.mobileqq.phonecontact.permission.PermissionChecker;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.utils.ProfileUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AbsListView;
import com.tencent.widget.ListView;
import com.tencent.widget.SingleLineTextView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PhoneContactAdapter
  extends FacePreloadBaseAdapter
  implements View.OnClickListener
{
  private IPhoneContactService a;
  private QQAppInterface b;
  private Context c;
  private List<BuddyListItem> d;
  private View e;
  private PhoneContactFragment f;
  private boolean g = false;
  private long h = 0L;
  
  public PhoneContactAdapter(Context paramContext, QQAppInterface paramQQAppInterface, ListView paramListView, int paramInt, boolean paramBoolean, PhoneContactFragment paramPhoneContactFragment)
  {
    super(paramContext, paramQQAppInterface, paramListView, paramInt, paramBoolean);
    this.b = paramQQAppInterface;
    this.c = paramContext;
    this.a = ((IPhoneContactService)paramQQAppInterface.getRuntimeService(IPhoneContactService.class));
    this.f = paramPhoneContactFragment;
  }
  
  private boolean b()
  {
    List localList = this.d;
    if (localList == null) {
      return true;
    }
    return localList.isEmpty();
  }
  
  private void d()
  {
    Object localObject1 = this.d;
    if (localObject1 == null) {
      this.d = new ArrayList();
    } else {
      ((List)localObject1).clear();
    }
    int i = this.a.getSelfBindState();
    if ((i == 9) || (i == 8) || (i == 4) || (i == 2))
    {
      if (!PermissionChecker.a().e())
      {
        if (QLog.isColorLevel()) {
          QLog.d("contacts.PhoneContactAdapter", 2, "load data: no permission");
        }
        return;
      }
      Object localObject2 = this.a.getBindNonfriendList(new int[] { 7, 2, 3, 4 });
      if (localObject2 != null)
      {
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("load data:");
          ((StringBuilder)localObject1).append(((List)localObject2).size());
          QLog.d("contacts.PhoneContactAdapter", 2, ((StringBuilder)localObject1).toString());
        }
        localObject1 = new ArrayList(((List)localObject2).size());
        localObject2 = ((List)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          PhoneContact localPhoneContact = (PhoneContact)((Iterator)localObject2).next();
          if (!localPhoneContact.isHiden) {
            ((List)localObject1).add(BuddyItemBuilder.a(1, localPhoneContact, this.b, this.c));
          }
        }
        this.d = ((List)localObject1);
        long l1 = SystemClock.uptimeMillis();
        if ((this.g) && (this.d.size() == 0))
        {
          long l2 = this.h;
          if (l1 - l2 > 180000L)
          {
            QLog.d("contacts.PhoneContactAdapter", 1, String.format("needDoubleCheck onAppRunForeground interval=%d", new Object[] { Long.valueOf(l1 - l2) }));
            localObject1 = (IPhoneContactService)this.b.getRuntimeService(IPhoneContactService.class, "");
            if (localObject1 != null) {
              ((IPhoneContactService)localObject1).checkUpdateLocalContact(true, 1);
            }
            this.g = false;
            this.h = l1;
          }
        }
      }
    }
  }
  
  public void a()
  {
    List localList = this.d;
    if (localList != null) {
      localList.clear();
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface != this.b)
    {
      if (QLog.isColorLevel()) {
        QLog.i("contacts.PhoneContactAdapter", 2, "checkResetApp, need change app!");
      }
      this.b = paramQQAppInterface;
      this.a = ((IPhoneContactService)this.b.getRuntimeService(IPhoneContactService.class, ""));
      b(this.b);
    }
  }
  
  public void c()
  {
    super.c();
    this.a = null;
    this.b = null;
    this.c = null;
    this.f = null;
  }
  
  public int getCount()
  {
    if ((this.d != null) && (b()) && (!this.f.j())) {
      return 1;
    }
    List localList = this.d;
    if (localList == null) {
      return 0;
    }
    return localList.size();
  }
  
  public Object getItem(int paramInt)
  {
    return Integer.valueOf(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject1;
    Object localObject2;
    if (b())
    {
      if (this.e == null)
      {
        this.e = View.inflate(this.c, 2131624548, null);
        this.e.setBackgroundResource(2130839577);
        this.e.findViewById(2131436369).setVisibility(8);
        this.e.findViewById(2131436506).setVisibility(8);
        localObject1 = (SingleLineTextView)this.e.findViewById(2131434435);
        ((SingleLineTextView)localObject1).setText(HardCodeUtil.a(2131905808));
        localObject2 = (ViewGroup.MarginLayoutParams)((SingleLineTextView)localObject1).getLayoutParams();
        ((ViewGroup.MarginLayoutParams)localObject2).leftMargin /= 2;
        ((SingleLineTextView)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
        ((SimpleTextView)this.e.findViewById(2131431254)).setText("0");
      }
      localObject1 = this.e;
    }
    else
    {
      localObject2 = ((BuddyListItem)this.d.get(paramInt)).a(0, paramInt, paramView, paramViewGroup, this);
      localObject1 = localObject2;
      if (localObject2 != null)
      {
        BuddyListItem.ViewTag localViewTag = (BuddyListItem.ViewTag)((View)localObject2).getTag();
        if (localViewTag.r != null) {
          localViewTag.r.setBackgroundDrawable(new BitmapDrawable(a(localViewTag.q, localViewTag.p)));
        }
        ((View)localObject2).setOnClickListener(this);
        localObject1 = localObject2;
        if ((localViewTag instanceof BuddyListPhone.PhoneContactChildTag))
        {
          ((BuddyListPhone.PhoneContactChildTag)localViewTag).g.setOnClickListener(this);
          localObject1 = localObject2;
        }
      }
    }
    EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
    return localObject1;
  }
  
  public void notifyDataSetChanged()
  {
    this.g = true;
    d();
    super.notifyDataSetChanged();
  }
  
  public void onClick(View paramView)
  {
    Object localObject;
    if ((paramView != null) && (paramView.getId() == 2131444718) && ((paramView.getTag() instanceof PhoneContact)))
    {
      localObject = (PhoneContact)paramView.getTag();
      int i;
      if (!this.a.isBindedIgnoreUpload()) {
        i = 17;
      } else {
        i = 15;
      }
      ((PhoneContact)localObject).isNewRecommend = false;
      localObject = ((IAddFriendApi)QRoute.api(IAddFriendApi.class)).startAddFriend(this.c, 2, ((PhoneContact)localObject).unifiedCode, null, 3006, i, ((PhoneContact)localObject).name, null, null, HardCodeUtil.a(2131898212), null);
      ((IAddFriendApi)QRoute.api(IAddFriendApi.class)).launchAddFriend(this.c, (Intent)localObject);
      ReportController.b(this.b, "dc00899", "contact", "", "addbook", "add_friend", 0, 0, "", "", "", "");
    }
    else if ((paramView != null) && ((paramView.getTag() instanceof BuddyListItem.ViewTag)))
    {
      localObject = (BuddyListItem.ViewTag)paramView.getTag();
      if ((((BuddyListItem.ViewTag)localObject).c instanceof PhoneContact))
      {
        PhoneContact localPhoneContact = (PhoneContact)((BuddyListItem.ViewTag)localObject).c;
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("onItemClick:");
          ((StringBuilder)localObject).append(localPhoneContact.name);
          ((StringBuilder)localObject).append(localPhoneContact.mobileCode);
          ((StringBuilder)localObject).append("--[");
          ((StringBuilder)localObject).append(localPhoneContact.detalStatusFlag);
          ((StringBuilder)localObject).append("] [");
          ((StringBuilder)localObject).append(localPhoneContact.iTermType);
          ((StringBuilder)localObject).append("]");
          QLog.d("contacts.PhoneContactAdapter", 2, ((StringBuilder)localObject).toString());
        }
        if (this.a.isBindedIgnoreUpload())
        {
          localObject = new AllInOne(localPhoneContact.unifiedCode, 34);
        }
        else
        {
          localObject = new AllInOne(localPhoneContact.unifiedCode, 29);
          ((AllInOne)localObject).subSourceId = 17;
        }
        ((AllInOne)localObject).profileEntryType = 59;
        ((AllInOne)localObject).nickname = localPhoneContact.name;
        ((AllInOne)localObject).chatEntrance = 2;
        ProfileUtils.openProfileCard(this.c, (AllInOne)localObject);
        ReportController.b(this.b, "CliOper", "", "", "0X80053DF", "0X80053DF", 0, 0, "1", "", "", "");
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    super.onScrollStateChanged(paramAbsListView, paramInt);
    if (paramInt != 0) {
      ApngImage.pauseByTag(3);
    }
    if (paramInt == 0) {
      ApngImage.playByTag(3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.phone.PhoneContactAdapter
 * JD-Core Version:    0.7.0.1
 */