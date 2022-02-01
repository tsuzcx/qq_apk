package com.tencent.mobileqq.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.ContactBindedActivity;
import com.tencent.mobileqq.addfriend.api.IAddFriendApi;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.newfriend.api.INewFriendApi;
import com.tencent.mobileqq.phonecontact.api.IPhoneContactService;
import com.tencent.mobileqq.phonecontact.data.ContactBindedData;
import com.tencent.mobileqq.phonecontact.util.ContactBindUtils;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.utils.ProfileUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.widget.IndexView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ThemeImageView;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;

public class ContactBindedAdapter
  extends CharDividedFacePreloadBaseAdapter
  implements View.OnClickListener
{
  public List<PhoneContact> a = new ArrayList();
  boolean b = false;
  int c = 0;
  int d = 0;
  public IndexView e = null;
  public ContactBindedAdapter.SelectedListener f = null;
  PhoneContact g = null;
  private List<PhoneContact> h = new ArrayList();
  private Context i;
  private QQAppInterface j;
  private FriendsManager k;
  private LinkedHashMap<String, List<PhoneContact>> l = new LinkedHashMap();
  private int[] m = new int[0];
  private String[] p = new String[0];
  private List<PhoneContact> q = new ArrayList();
  
  public ContactBindedAdapter(Context paramContext, QQAppInterface paramQQAppInterface, XListView paramXListView, List<PhoneContact> paramList)
  {
    super(paramContext, paramQQAppInterface, paramXListView, true);
    this.i = paramContext;
    this.j = paramQQAppInterface;
    this.k = ((FriendsManager)paramQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER));
    this.c = paramContext.getResources().getDimensionPixelOffset(2131298918);
    this.d = paramContext.getResources().getDimensionPixelOffset(2131298919);
    a(paramList);
  }
  
  private boolean a(PhoneContact paramPhoneContact)
  {
    int n = 0;
    while (n < this.a.size())
    {
      PhoneContact localPhoneContact = (PhoneContact)this.a.get(n);
      if (TextUtils.equals(paramPhoneContact.unifiedCode, localPhoneContact.unifiedCode)) {
        return true;
      }
      n += 1;
    }
    return false;
  }
  
  public int a()
  {
    if (this.p.length > 0) {
      return 2131625258;
    }
    return 0;
  }
  
  public void a(View paramView, int paramInt)
  {
    int n = Arrays.binarySearch(this.m, paramInt);
    paramInt = n;
    if (n < 0) {
      paramInt = -(n + 1) - 1;
    }
    String[] arrayOfString = this.p;
    if ((paramInt < arrayOfString.length) && (paramInt >= 0)) {
      ((TextView)paramView).setText(arrayOfString[paramInt]);
    }
  }
  
  public void a(PhoneContact paramPhoneContact, boolean paramBoolean)
  {
    int n = 0;
    while (n < this.a.size())
    {
      PhoneContact localPhoneContact = (PhoneContact)this.a.get(n);
      if (TextUtils.equals(paramPhoneContact.unifiedCode, localPhoneContact.unifiedCode)) {
        break label57;
      }
      n += 1;
    }
    n = -1;
    label57:
    if (paramBoolean)
    {
      if (n == -1)
      {
        this.a.add(paramPhoneContact);
        notifyDataSetChanged();
      }
    }
    else if (n != -1)
    {
      this.a.remove(n);
      notifyDataSetChanged();
    }
  }
  
  public void a(ContactBindedData paramContactBindedData)
  {
    this.h = paramContactBindedData.d;
    this.m = paramContactBindedData.b;
    this.l = paramContactBindedData.a;
    this.p = paramContactBindedData.c;
    this.q = paramContactBindedData.e;
  }
  
  public void a(List<PhoneContact> paramList)
  {
    a(ContactBindUtils.a(paramList, null, true));
  }
  
  public void a(boolean paramBoolean)
  {
    this.b = paramBoolean;
    notifyDataSetChanged();
  }
  
  public boolean a(int paramInt)
  {
    return Arrays.binarySearch(this.m, paramInt) >= 0;
  }
  
  public int b(String paramString)
  {
    if (this.p != null)
    {
      int n = 0;
      for (;;)
      {
        String[] arrayOfString = this.p;
        if (n >= arrayOfString.length) {
          break;
        }
        if (arrayOfString[n].equals(paramString)) {
          break label42;
        }
        n += 1;
      }
      n = -1;
      label42:
      if (n >= 0) {
        return this.m[n];
      }
    }
    return -1;
  }
  
  public void d()
  {
    if (this.o != null) {
      this.o.destory();
    }
  }
  
  public int getCount()
  {
    Object localObject = this.m;
    if (localObject.length == 0) {
      return 0;
    }
    int n = localObject[(localObject.length - 1)];
    localObject = this.l;
    String[] arrayOfString = this.p;
    return n + ((List)((LinkedHashMap)localObject).get(arrayOfString[(arrayOfString.length - 1)])).size() + 1;
  }
  
  public Object getItem(int paramInt)
  {
    int n = Arrays.binarySearch(this.m, paramInt);
    if (n >= 0) {
      return null;
    }
    n = -(n + 1) - 1;
    return (PhoneContact)((List)this.l.get(this.p[n])).get(paramInt - this.m[n] - 1);
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int n = Arrays.binarySearch(this.m, paramInt);
    View localView;
    if (paramView == null)
    {
      paramView = new ContactBindedAdapter.ConactBindedHolder();
      localView = LayoutInflater.from(this.i).inflate(2131627367, null);
      paramView.a = ((TextView)localView.findViewById(2131439320));
      paramView.A = ((ImageView)localView.findViewById(2131427337));
      paramView.b = ((TextView)localView.findViewById(2131444728));
      paramView.c = ((TextView)localView.findViewById(2131446184));
      paramView.d = ((Button)localView.findViewById(2131444718));
      paramView.e = ((TextView)localView.findViewById(2131444726));
      paramView.g = ((CheckBox)localView.findViewById(2131430682));
      paramView.i = ((TextView)localView.findViewById(2131448537));
      paramView.h = localView.findViewById(2131442295);
      localView.setBackgroundDrawable(null);
      localView.setTag(paramView);
      if ((paramView.A instanceof ThemeImageView)) {
        ((ThemeImageView)paramView.A).setSupportMaskView(false);
      }
    }
    else
    {
      localObject1 = (ContactBindedAdapter.ConactBindedHolder)paramView.getTag();
      localView = paramView;
      paramView = (View)localObject1;
    }
    Object localObject1 = this.e;
    if ((localObject1 != null) && (((IndexView)localObject1).getVisibility() == 0)) {
      localView.findViewById(2131444724).setPadding(0, 0, this.c, 0);
    } else {
      localView.findViewById(2131444724).setPadding(0, 0, this.d, 0);
    }
    if (n < 0)
    {
      n = -(n + 1) - 1;
      localObject1 = (PhoneContact)((List)this.l.get(this.p[n])).get(paramInt - this.m[n] - 1);
      paramView.f = ((PhoneContact)localObject1);
      if ((!this.q.isEmpty()) && (!"★".equals(this.p[n])) && (((PhoneContact)localObject1).isNewRecommend))
      {
        ((INewFriendApi)QRoute.api(INewFriendApi.class)).updateItemBg(localView, true);
        ((INewFriendApi)QRoute.api(INewFriendApi.class)).updateItemBgKeepPadding(paramView.h, true);
      }
      else
      {
        ((INewFriendApi)QRoute.api(INewFriendApi.class)).updateItemBg(localView, false);
        ((INewFriendApi)QRoute.api(INewFriendApi.class)).updateItemBgKeepPadding(paramView.h, false);
      }
      StringBuilder localStringBuilder = new StringBuilder(256);
      if (!TextUtils.isEmpty(((PhoneContact)localObject1).name))
      {
        paramView.a.setVisibility(0);
        paramView.a.setText(((PhoneContact)localObject1).name);
        if (AppSetting.e)
        {
          AccessibilityUtil.a(paramView.a, false);
          localStringBuilder.append(((PhoneContact)localObject1).name);
        }
      }
      else
      {
        paramView.a.setVisibility(8);
      }
      paramView.b.setVisibility(8);
      if (((PhoneContact)localObject1).samFriend > 0)
      {
        paramView.c.setVisibility(0);
        localObject2 = String.format(this.i.getResources().getString(2131888039), new Object[] { Integer.valueOf(((PhoneContact)localObject1).samFriend) });
        paramView.c.setText((CharSequence)localObject2);
        paramView.c.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        if (AppSetting.e)
        {
          localStringBuilder.append(",");
          localStringBuilder.append((String)localObject2);
        }
      }
      else
      {
        paramView.c.setVisibility(8);
      }
      if ((!TextUtils.isEmpty(((PhoneContact)localObject1).uin)) && (!((PhoneContact)localObject1).uin.equals("0")))
      {
        paramView.d.setVisibility(8);
        paramView.e.setVisibility(0);
        paramView.e.setText(HardCodeUtil.a(2131900627));
        if (this.b)
        {
          paramView.h.setEnabled(false);
          paramView.g.setEnabled(false);
          paramView.g.setChecked(false);
        }
        if (AppSetting.e) {
          paramView.e.setContentDescription(HardCodeUtil.a(2131900622));
        }
      }
      else if (this.k.b(((PhoneContact)localObject1).unifiedCode, true))
      {
        paramView.d.setVisibility(8);
        paramView.e.setVisibility(0);
        paramView.e.setText(HardCodeUtil.a(2131900625));
        if (this.b)
        {
          paramView.h.setEnabled(false);
          paramView.g.setEnabled(false);
          paramView.g.setChecked(false);
        }
        if (AppSetting.e) {
          paramView.e.setContentDescription(HardCodeUtil.a(2131900630));
        }
      }
      else
      {
        if (this.b)
        {
          paramView.d.setVisibility(8);
          paramView.g.setEnabled(true);
          paramView.g.setChecked(a((PhoneContact)localObject1));
          paramView.g.setTag(paramView);
        }
        else
        {
          paramView.d.setVisibility(0);
          paramView.d.setText(HardCodeUtil.a(2131886199));
          paramView.d.setTag(localObject1);
          paramView.d.setOnClickListener(this);
          if (AppSetting.e) {
            paramView.d.setContentDescription(HardCodeUtil.a(2131886199));
          }
        }
        paramView.h.setEnabled(true);
        paramView.e.setVisibility(8);
      }
      Object localObject2 = paramView.g;
      if (this.b) {
        n = 0;
      } else {
        n = 8;
      }
      ((CheckBox)localObject2).setVisibility(n);
      if (AppSetting.e) {
        localView.setContentDescription(localStringBuilder.toString());
      }
      paramView.i.setVisibility(8);
      paramView.h.setVisibility(0);
      paramView.y = ((PhoneContact)localObject1).unifiedCode;
      paramView.A.setImageBitmap(a(((PhoneContact)localObject1).unifiedCode, 11, (byte)0));
      paramView.h.setOnClickListener(this);
      paramView.h.setTag(paramView);
    }
    else
    {
      paramView.h.setTag(null);
      paramView.h.setOnClickListener(null);
      paramView.h.setVisibility(8);
      paramView.i.setVisibility(0);
      paramView.i.setText(String.valueOf(this.p[n]));
    }
    EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
    return localView;
  }
  
  public void onClick(View paramView)
  {
    Object localObject1 = paramView.getTag();
    if (localObject1 != null)
    {
      Object localObject2 = this.i;
      if ((localObject2 instanceof ContactBindedActivity)) {
        ((ContactBindedActivity)localObject2).d();
      }
      int i1 = paramView.getId();
      int n = 1;
      if (i1 != 2131442295)
      {
        if (i1 == 2131444718)
        {
          localObject2 = (PhoneContact)localObject1;
          localObject1 = (IPhoneContactService)this.j.getRuntimeService(IPhoneContactService.class, "");
          if (((Activity)this.i).getIntent().getBooleanExtra("from_babyq", false))
          {
            i1 = 3084;
          }
          else
          {
            i1 = 3006;
            n = 13;
          }
          if (!((IPhoneContactService)localObject1).isBindedIgnoreUpload())
          {
            if (this.q.contains(localObject2)) {
              ReportController.b(this.j, "dc00898", "", "", "0X80077CD", "0X80077CD", 1, 0, "", "", "", "");
            } else {
              ReportController.b(this.j, "dc00898", "", "", "0X80077CD", "0X80077CD", 2, 0, "", "", "", "");
            }
            ReportController.b(this.j, "dc00898", "", "", "0X80077CD", "0X80077CD", 0, 0, "", "", "", "");
            i1 = 3006;
            n = 16;
          }
          else if (this.q.isEmpty())
          {
            ReportController.b(this.j, "dc00898", "", "", "0X80077D0", "0X80077D0", 0, 0, "", "", "", "");
          }
          else
          {
            if (this.q.contains(localObject2)) {
              ReportController.b(this.j, "dc00898", "", "", "0X80077D3", "0X80077D3", 1, 0, "", "", "", "");
            } else {
              ReportController.b(this.j, "dc00898", "", "", "0X80077D3", "0X80077D3", 2, 0, "", "", "", "");
            }
            ReportController.b(this.j, "dc00898", "", "", "0X80077D3", "0X80077D3", 0, 0, "", "", "", "");
          }
          ((PhoneContact)localObject2).isNewRecommend = false;
          localObject1 = this.i;
          if ((localObject1 instanceof ContactBindedActivity))
          {
            ContactBindedActivity localContactBindedActivity = (ContactBindedActivity)localObject1;
            if (TextUtils.isEmpty(((PhoneContact)localObject2).pinyinFirst)) {
              localObject1 = "#";
            } else {
              localObject1 = String.valueOf(((PhoneContact)localObject2).pinyinFirst.charAt(0)).toUpperCase();
            }
            localObject1 = (List)this.l.get(localObject1);
            if ((localObject1 != null) && (!((List)localObject1).isEmpty()))
            {
              localContactBindedActivity.g = ((List)localObject1).indexOf(localObject2);
              if (localContactBindedActivity.g != -1) {
                localContactBindedActivity.f = ((PhoneContact)localObject2);
              }
            }
          }
          localObject1 = ((IAddFriendApi)QRoute.api(IAddFriendApi.class)).startAddFriend(this.i, 2, ((PhoneContact)localObject2).unifiedCode, null, i1, n, ((PhoneContact)localObject2).name, null, null, HardCodeUtil.a(2131898212), null);
          ((IAddFriendApi)QRoute.api(IAddFriendApi.class)).launchAddFriend((Activity)this.i, (Intent)localObject1);
          ReportController.b(this.j, "CliOper", "", "", "0X8006A75", "0X8006A75", 0, 0, "", "", "", "");
          notifyDataSetChanged();
        }
      }
      else if (this.b)
      {
        localObject1 = (ContactBindedAdapter.ConactBindedHolder)localObject1;
        boolean bool = a(((ContactBindedAdapter.ConactBindedHolder)localObject1).f);
        a(((ContactBindedAdapter.ConactBindedHolder)localObject1).f, bool ^ true);
        localObject2 = this.f;
        if (localObject2 != null) {
          ((ContactBindedAdapter.SelectedListener)localObject2).a(((ContactBindedAdapter.ConactBindedHolder)localObject1).f, bool ^ true);
        }
      }
      else
      {
        this.g = ((ContactBindedAdapter.ConactBindedHolder)localObject1).f;
        localObject1 = this.g;
        if (localObject1 != null)
        {
          ((PhoneContact)localObject1).isNewRecommend = false;
          localObject2 = (IPhoneContactService)this.j.getRuntimeService(IPhoneContactService.class, "");
          if ((!TextUtils.isEmpty(this.g.uin)) && (!"0".equals(this.g.uin)))
          {
            localObject1 = new AllInOne(this.g.uin, 30);
            ((AllInOne)localObject1).contactName = this.g.name;
          }
          else if (((IPhoneContactService)localObject2).isBindedIgnoreUpload())
          {
            localObject1 = new AllInOne(this.g.unifiedCode, 34);
          }
          else
          {
            localObject1 = new AllInOne(this.g.unifiedCode, 29);
            ((AllInOne)localObject1).subSourceId = 16;
          }
          ((AllInOne)localObject1).nickname = this.g.name;
          if ((((IPhoneContactService)localObject2).isBindedIgnoreUpload()) && (this.q.isEmpty())) {
            ((AllInOne)localObject1).profileEntryType = 104;
          } else if (this.q.contains(this.g)) {
            ((AllInOne)localObject1).profileEntryType = 101;
          } else {
            ((AllInOne)localObject1).profileEntryType = 102;
          }
          ProfileUtils.openProfileCard(this.i, (AllInOne)localObject1);
        }
        notifyDataSetChanged();
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.adapter.ContactBindedAdapter
 * JD-Core Version:    0.7.0.1
 */