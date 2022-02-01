package com.tencent.mobileqq.activity.contacts.alphabet;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.image.ApngImage;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.contacts.base.BuddyItemBuilder;
import com.tencent.mobileqq.activity.contacts.base.BuddyListItem;
import com.tencent.mobileqq.activity.contacts.base.BuddyListItem.BuddyListCallback;
import com.tencent.mobileqq.activity.contacts.base.BuddyListItem.ViewTag;
import com.tencent.mobileqq.activity.contacts.friend.BuddyListFriends;
import com.tencent.mobileqq.activity.contacts.friend.BuddyListFriends.BuddyChildTag;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.SpecialCareInfo;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.richstatus.ExtensionRichStatus;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.richstatus.StatusManager;
import com.tencent.mobileqq.util.QQStoryCoverImageViewHelper;
import com.tencent.mobileqq.utils.ChnToSpell;
import com.tencent.mobileqq.utils.DisplayUtils;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.theme.SkinEngine;
import com.tencent.widget.AbsListView;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import com.tencent.widget.SingleLineTextView;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;
import mqq.os.MqqHandler;

public class AlphabetFriendAdapter
  extends AlphabetFriendPreloadAdapter
  implements View.OnLongClickListener, BuddyListItem.BuddyListCallback
{
  public LinkedHashMap<String, List<AlphabetFriendAdapter.AlphabetFriend>> a = new LinkedHashMap();
  public int[] b = new int[0];
  public String[] c = new String[0];
  private QQAppInterface g;
  private Context h;
  private final StatusManager i;
  private final FriendsManager j;
  private int k = 0;
  private final View.OnClickListener l;
  private final int m;
  private IndexBar n;
  private View o;
  private AlphabetFriendAdapter.ItemLongClickListener p;
  private boolean q = true;
  private int r = 0;
  private Comparator<AlphabetFriendAdapter.AlphabetFriend> s = new AlphabetFriendAdapter.5(this);
  
  public AlphabetFriendAdapter(Context paramContext, QQAppInterface paramQQAppInterface, XListView paramXListView, IndexBar paramIndexBar, View.OnClickListener paramOnClickListener)
  {
    super(paramContext, paramQQAppInterface, paramXListView, true);
    this.g = paramQQAppInterface;
    this.h = paramContext;
    this.l = paramOnClickListener;
    this.n = paramIndexBar;
    this.i = ((StatusManager)paramQQAppInterface.getManager(QQManagerFactory.STATUS_MANAGER));
    this.j = ((FriendsManager)paramQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER));
    this.m = ((int)DisplayUtils.a(this.h, 12.0F));
    this.p = new AlphabetFriendAdapter.ItemLongClickListener(this);
  }
  
  private String a(Friends paramFriends, BuddyListFriends.BuddyChildTag paramBuddyChildTag)
  {
    if (this.i != null)
    {
      Object localObject = this.j;
      if (localObject != null)
      {
        if (this.h == null) {
          return null;
        }
        ExtensionInfo localExtensionInfo = ((FriendsManager)localObject).x(paramFriends.uin);
        int i4 = 0;
        int i1;
        if ((localExtensionInfo != null) && (!TextUtils.isEmpty(localExtensionInfo.feedContent))) {
          i1 = 1;
        } else {
          i1 = 0;
        }
        if (localExtensionInfo != null)
        {
          boolean bool;
          if (this.k != 0) {
            bool = true;
          } else {
            bool = false;
          }
          localObject = ExtensionRichStatus.a(localExtensionInfo, bool);
        }
        else
        {
          localObject = null;
        }
        int i2;
        if ((localObject != null) && (localObject != RichStatus.getEmptyStatus()) && (!((RichStatus)localObject).isEmpty())) {
          i2 = 1;
        } else {
          i2 = 0;
        }
        int i3;
        if ((i2 != 0) && (!TextUtils.isEmpty(((RichStatus)localObject).actionText))) {
          i3 = 1;
        } else {
          i3 = 0;
        }
        if ((i1 != 0) && ((localExtensionInfo.feedTime > localExtensionInfo.richTime) || (i2 == 0)))
        {
          paramFriends = new String(localExtensionInfo.feedContent);
          paramBuddyChildTag.b.setCompoundDrawables(null, null);
          if (localExtensionInfo.feedType == 2)
          {
            paramBuddyChildTag.e.setVisibility(0);
            if (!TextUtils.isEmpty(localExtensionInfo.feedPhotoUrl)) {
              QQStoryCoverImageViewHelper.a(paramBuddyChildTag.e, localExtensionInfo.feedPhotoUrl, this.h.getResources().getDrawable(2130852411));
            } else {
              paramBuddyChildTag.e.setImageDrawable(SkinEngine.getInstances().getDefaultThemeDrawable(2130852411));
            }
            paramBuddyChildTag.f.setVisibility(8);
            paramBuddyChildTag.g.setVisibility(8);
          }
          else
          {
            paramBuddyChildTag.f.setVisibility(0);
            localObject = paramBuddyChildTag.f;
            if (localExtensionInfo.feedType == 1) {
              i1 = 2130851613;
            } else {
              i1 = 2130851611;
            }
            ((ImageView)localObject).setBackgroundResource(i1);
            localObject = paramBuddyChildTag.g;
            if (localExtensionInfo.feedHasPhoto) {
              i1 = i4;
            } else {
              i1 = 8;
            }
            ((URLImageView)localObject).setVisibility(i1);
            paramBuddyChildTag.e.setVisibility(8);
            paramBuddyChildTag.e.setImageDrawable(null);
          }
          localObject = null;
        }
        else
        {
          if (i3 != 0)
          {
            ((RichStatus)localObject).enableSummaryCached = paramFriends.isFriend();
            paramFriends = this.i.a(((RichStatus)localObject).actionId, 200);
            paramFriends = new BitmapDrawable(this.h.getResources(), paramFriends);
            i1 = this.m;
            paramFriends.setBounds(0, 0, Math.round(paramFriends.getIntrinsicWidth() * 1.0F / paramFriends.getIntrinsicHeight() * i1), i1);
            paramBuddyChildTag.b.setCompoundDrawables(paramFriends, null);
          }
          else if (i2 == 0)
          {
            localObject = RichStatus.getEmptyStatus();
            paramBuddyChildTag.b.setCompoundDrawables(null, null);
          }
          paramFriends = ((RichStatus)localObject).getActionAndData();
          String str = ((RichStatus)localObject).getPlainText();
          paramBuddyChildTag.g.setVisibility(8);
          paramBuddyChildTag.f.setVisibility(8);
          paramBuddyChildTag.e.setVisibility(8);
          paramBuddyChildTag.e.setImageDrawable(null);
          localObject = paramFriends;
          paramFriends = str;
        }
        if (localExtensionInfo == null)
        {
          paramBuddyChildTag.g.setVisibility(8);
          paramBuddyChildTag.f.setVisibility(8);
        }
        paramBuddyChildTag.b.setExtendText((String)localObject, 1);
        paramBuddyChildTag.b.setText(paramFriends);
        return paramFriends;
      }
    }
    return null;
  }
  
  private void a(AlphabetFriendAdapter.AlphabetFriend paramAlphabetFriend, LinkedHashMap<String, List<AlphabetFriendAdapter.AlphabetFriend>> paramLinkedHashMap)
  {
    String str1 = paramAlphabetFriend.c;
    String str3 = "#";
    if ((str1 != null) && (paramAlphabetFriend.c.length() != 0)) {
      str1 = paramAlphabetFriend.c.substring(0, 1);
    } else {
      str1 = "#";
    }
    int i1 = str1.charAt(0);
    String str2;
    if ((65 > i1) || (i1 > 90))
    {
      str2 = str3;
      if (97 <= i1)
      {
        str2 = str3;
        if (i1 > 122) {}
      }
    }
    else
    {
      str2 = str1.toUpperCase();
    }
    if (paramLinkedHashMap.get(str2) == null) {
      paramLinkedHashMap.put(str2, new ArrayList());
    }
    ((List)paramLinkedHashMap.get(str2)).add(paramAlphabetFriend);
    if (paramAlphabetFriend.g)
    {
      if (paramLinkedHashMap.get("★") == null) {
        paramLinkedHashMap.put("★", new ArrayList());
      }
      ((List)paramLinkedHashMap.get("★")).add(paramAlphabetFriend);
    }
  }
  
  private Object[] a(List<AlphabetFriendAdapter.AlphabetFriend> paramList, Comparator<AlphabetFriendAdapter.AlphabetFriend> paramComparator)
  {
    Object localObject1 = new LinkedHashMap();
    if (paramList != null)
    {
      if (paramList.isEmpty()) {
        return null;
      }
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        a((AlphabetFriendAdapter.AlphabetFriend)paramList.next(), (LinkedHashMap)localObject1);
      }
      paramList = new LinkedHashMap();
      StringBuilder localStringBuilder2;
      if (((LinkedHashMap)localObject1).get("★") != null)
      {
        localObject2 = (List)((LinkedHashMap)localObject1).get("★");
        try
        {
          Collections.sort((List)localObject2, paramComparator);
        }
        catch (IllegalArgumentException localIllegalArgumentException1)
        {
          if (QLog.isColorLevel())
          {
            localStringBuilder2 = new StringBuilder();
            localStringBuilder2.append("INDEX_STAR sort error ");
            localStringBuilder2.append(localIllegalArgumentException1.toString());
            QLog.e("AlphabetFriendAdapter", 2, localStringBuilder2.toString());
          }
        }
        paramList.put("★", localObject2);
      }
      for (char c1 = 'A'; c1 <= 'Z'; c1 = (char)(c1 + '\001')) {
        if (((LinkedHashMap)localObject1).get(String.valueOf(c1)) != null)
        {
          localObject2 = (List)((LinkedHashMap)localObject1).get(String.valueOf(c1));
          try
          {
            Collections.sort((List)localObject2, paramComparator);
          }
          catch (IllegalArgumentException localIllegalArgumentException2)
          {
            if (QLog.isColorLevel())
            {
              localStringBuilder2 = new StringBuilder();
              localStringBuilder2.append("A Z sort error ");
              localStringBuilder2.append(localIllegalArgumentException2.toString());
              QLog.e("AlphabetFriendAdapter", 2, localStringBuilder2.toString());
            }
          }
          paramList.put(String.valueOf(c1), localObject2);
        }
      }
      if (((LinkedHashMap)localObject1).get("#") != null)
      {
        localObject2 = (List)((LinkedHashMap)localObject1).get("#");
        try
        {
          Collections.sort((List)localObject2, paramComparator);
        }
        catch (IllegalArgumentException paramComparator)
        {
          if (QLog.isColorLevel())
          {
            StringBuilder localStringBuilder1 = new StringBuilder();
            localStringBuilder1.append("# sort error ");
            localStringBuilder1.append(paramComparator.toString());
            localStringBuilder1.append(",list = ");
            localStringBuilder1.append(localObject2);
            QLog.e("AlphabetFriendAdapter", 2, localStringBuilder1.toString());
          }
        }
        paramList.put("#", localObject2);
      }
      ((LinkedHashMap)localObject1).clear();
      paramComparator = new int[paramList.keySet().size()];
      localObject1 = new String[paramComparator.length];
      Object localObject2 = paramList.keySet().iterator();
      if (paramComparator.length == 0) {
        return null;
      }
      paramComparator[0] = 0;
      int i1 = 1;
      while (i1 < paramComparator.length)
      {
        paramComparator[i1] += paramComparator[(i1 - 1)] + ((List)paramList.get(((Iterator)localObject2).next())).size() + 1;
        i1 += 1;
      }
      localObject2 = paramList.keySet().iterator();
      i1 = 0;
      while (((Iterator)localObject2).hasNext())
      {
        localObject1[i1] = ((String)((Iterator)localObject2).next());
        i1 += 1;
      }
      return new Object[] { paramList, paramComparator, localObject1 };
    }
    return null;
  }
  
  private void i()
  {
    if (this.n != null)
    {
      if (d() >= 5)
      {
        this.n.setLetters(this.c);
        return;
      }
      this.n.setLetters(null);
    }
  }
  
  private void j()
  {
    if (this.d == null) {
      return;
    }
    int i2 = this.d.getChildCount();
    int i1 = 0;
    while (i1 < i2)
    {
      Object localObject = this.d.getChildAt(i1).getTag();
      if ((localObject != null) && ((localObject instanceof BuddyListFriends.BuddyChildTag)))
      {
        localObject = (BuddyListFriends.BuddyChildTag)localObject;
        if ((TextUtils.isEmpty(((BuddyListFriends.BuddyChildTag)localObject).b.getText().toString())) && ((((BuddyListFriends.BuddyChildTag)localObject).c instanceof Friends))) {
          a((Friends)((BuddyListFriends.BuddyChildTag)localObject).c, (BuddyListFriends.BuddyChildTag)localObject);
        }
      }
      i1 += 1;
    }
  }
  
  private List<AlphabetFriendAdapter.AlphabetFriend> k()
  {
    ArrayList localArrayList = new ArrayList();
    if (this.g != null)
    {
      Object localObject1 = this.h;
      if (localObject1 == null) {
        return localArrayList;
      }
      if (((localObject1 instanceof Activity)) && (((Activity)localObject1).isFinishing()))
      {
        if (QLog.isColorLevel()) {
          QLog.e("AlphabetFriendAdapter", 2, "getAlphabetFriend Activity is finishing ");
        }
        return localArrayList;
      }
      localObject1 = (FriendsManager)this.g.getManager(QQManagerFactory.FRIENDS_MANAGER);
      if (localObject1 == null)
      {
        if (QLog.isColorLevel()) {
          QLog.e("AlphabetFriendAdapter", 2, "FriendManager is null");
        }
        return localArrayList;
      }
      localObject1 = ((FriendsManager)localObject1).j();
      if (localObject1 == null) {
        return localArrayList;
      }
      Iterator localIterator = ((List)localObject1).iterator();
      while (localIterator.hasNext())
      {
        Object localObject2 = (Entity)localIterator.next();
        if (this.g == null)
        {
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.e("AlphabetFriendAdapter", 2, "getAlphabetFriend mApp is null ");
          return localArrayList;
        }
        localObject1 = this.h;
        if (((localObject1 instanceof Activity)) && (((Activity)localObject1).isFinishing()))
        {
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.e("AlphabetFriendAdapter", 2, "getAlphabetFriend Activity is finishing ");
          return localArrayList;
        }
        localObject1 = null;
        BuddyListItem localBuddyListItem = BuddyItemBuilder.a(0, (Entity)localObject2, this.g, this.h);
        if (localBuddyListItem != null)
        {
          localBuddyListItem.a(this);
          localObject2 = a((BuddyListFriends)localBuddyListItem);
          localObject1 = localObject2;
          if (localObject2 != null)
          {
            localObject1 = localObject2;
            if ((localBuddyListItem.f() & 0x1) == 1)
            {
              ((AlphabetFriendAdapter.AlphabetFriend)localObject2).g = true;
              localObject1 = localObject2;
            }
          }
        }
        if (localObject1 != null) {
          localArrayList.add(localObject1);
        }
      }
    }
    return localArrayList;
  }
  
  public int a()
  {
    return 2131625258;
  }
  
  public int a(String paramString)
  {
    if (paramString == null) {
      return -1;
    }
    int i2 = paramString.charAt(0);
    if (this.c != null)
    {
      int i1 = 0;
      for (;;)
      {
        paramString = this.c;
        if (i1 >= paramString.length) {
          break;
        }
        int i3 = paramString[i1].charAt(0);
        if (i3 != "★".charAt(0)) {
          if (i2 == 35) {
            i1 = this.c.length - 1;
          } else if (i2 <= i3) {}
        }
        i1 += 1;
      }
      i1 = -1;
      if (i1 >= 0) {
        return this.b[i1];
      }
    }
    return -1;
  }
  
  public AlphabetFriendAdapter.AlphabetFriend a(BuddyListFriends paramBuddyListFriends)
  {
    if ((paramBuddyListFriends != null) && (paramBuddyListFriends.f != null))
    {
      AlphabetFriendAdapter.AlphabetFriend localAlphabetFriend = new AlphabetFriendAdapter.AlphabetFriend(paramBuddyListFriends);
      paramBuddyListFriends = (Friends)paramBuddyListFriends.f;
      String str = paramBuddyListFriends.getFriendNickWithAlias();
      localAlphabetFriend.a = paramBuddyListFriends.uin;
      localAlphabetFriend.b = str;
      localAlphabetFriend.c = ChnToSpell.b(str, 2);
      return localAlphabetFriend;
    }
    return null;
  }
  
  public void a(View paramView)
  {
    this.o = paramView;
  }
  
  public void a(View paramView, int paramInt)
  {
    int i1 = Arrays.binarySearch(this.b, paramInt);
    paramInt = i1;
    if (i1 < 0) {
      paramInt = -(i1 + 1) - 1;
    }
    if (paramInt < this.c.length)
    {
      if (paramInt < 0) {
        return;
      }
      if ((paramView instanceof TextView))
      {
        TextView localTextView = (TextView)paramView;
        localTextView.setPadding(localTextView.getPaddingLeft(), 0, 0, 0);
        paramView = this.c[paramInt];
        if (paramView.equals("★")) {
          localTextView.setText(HardCodeUtil.a(2131898483));
        } else {
          localTextView.setText(paramView);
        }
        paramView = this.h.getResources().getColorStateList(2131168149);
        if (ThemeUtil.isNowThemeIsNight(this.g, false, null)) {
          paramView = this.h.getResources().getColorStateList(2131167905);
        }
        localTextView.setTextColor(paramView);
        paramView = this.n;
        if (paramView != null) {
          paramView.setChooseIndex(paramInt);
        }
        localTextView.setTypeface(Typeface.SANS_SERIF);
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.q = paramBoolean;
  }
  
  public boolean a(int paramInt)
  {
    return Arrays.binarySearch(this.b, paramInt) >= 0;
  }
  
  public void b()
  {
    ThreadManagerV2.excute(new AlphabetFriendAdapter.1(this), 16, null, true);
  }
  
  public void b(int paramInt)
  {
    this.r = paramInt;
  }
  
  public boolean b(View paramView, int paramInt)
  {
    return this.c.length <= 0;
  }
  
  public void c()
  {
    ArrayList localArrayList = new ArrayList();
    try
    {
      localArrayList.addAll(k());
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("loadData Exception = ");
        localStringBuilder.append(localException.toString());
        QLog.e("AlphabetFriendAdapter", 2, localStringBuilder.toString());
      }
    }
    Object[] arrayOfObject = a(localArrayList, this.s);
    ThreadManager.getUIHandler().post(new AlphabetFriendAdapter.2(this, localArrayList));
    if ((arrayOfObject != null) && (arrayOfObject.length >= 3))
    {
      if (arrayOfObject.length >= 3) {
        ThreadManager.getUIHandler().post(new AlphabetFriendAdapter.4(this, arrayOfObject));
      }
    }
    else
    {
      if (QLog.isColorLevel()) {
        QLog.d("AlphabetFriendAdapter", 2, "constructHashStruct result == null!");
      }
      ThreadManager.getUIHandler().post(new AlphabetFriendAdapter.3(this));
    }
  }
  
  public int d()
  {
    return this.r;
  }
  
  public void e()
  {
    if (this.d != null)
    {
      if (this.h == null) {
        return;
      }
      if (this.d.getFooterViewsCount() <= 0) {
        return;
      }
      Object localObject = this.o;
      if (localObject == null) {
        return;
      }
      localObject = (TextView)((View)localObject).findViewById(2131428288);
      if (d() > 0)
      {
        int i1 = d();
        ((TextView)localObject).setText(this.h.getResources().getString(2131888050, new Object[] { Integer.valueOf(i1) }));
        return;
      }
      ((TextView)localObject).setText("");
    }
  }
  
  public void f()
  {
    b(0);
    this.a.clear();
    this.b = new int[0];
    this.c = new String[0];
  }
  
  public int g()
  {
    return this.k;
  }
  
  public int getCount()
  {
    int i3 = this.b.length;
    int i2 = 0;
    int i1 = i2;
    if (i3 != 0)
    {
      i1 = i2;
      if (this.a.size() != 0)
      {
        Object localObject = this.c;
        if (localObject.length == 0) {
          return 0;
        }
        localObject = (List)this.a.get(localObject[(localObject.length - 1)]);
        i1 = i2;
        if (localObject != null)
        {
          int[] arrayOfInt = this.b;
          i1 = arrayOfInt[(arrayOfInt.length - 1)] + ((List)localObject).size() + 1;
        }
      }
    }
    return i1;
  }
  
  public Object getItem(int paramInt)
  {
    int i1 = Arrays.binarySearch(this.b, paramInt);
    if (i1 >= 0) {
      return null;
    }
    i1 = -(i1 + 1) - 1;
    return (AlphabetFriendAdapter.AlphabetFriend)((List)this.a.get(this.c[i1])).get(paramInt - this.b[i1] - 1);
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public int getItemViewType(int paramInt)
  {
    if (Arrays.binarySearch(this.b, paramInt) < 0) {
      return 1;
    }
    return 0;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int i1 = Arrays.binarySearch(this.b, paramInt);
    Object localObject2;
    Object localObject1;
    if (getItemViewType(paramInt) == 1)
    {
      i1 = -(i1 + 1) - 1;
      localObject2 = (List)this.a.get(this.c[i1]);
      i1 = paramInt - this.b[i1] - 1;
      localObject1 = paramView;
      if (localObject2 != null)
      {
        localObject1 = paramView;
        if (i1 < ((List)localObject2).size())
        {
          localObject1 = ((AlphabetFriendAdapter.AlphabetFriend)((List)localObject2).get(i1)).h;
          boolean bool = localObject1 instanceof BuddyListFriends;
          if (bool) {
            ((BuddyListFriends)localObject1).a(1);
          }
          if (localObject1 == null) {
            localObject2 = null;
          } else {
            localObject2 = ((BuddyListItem)localObject1).a(0, paramInt, paramView, paramViewGroup, this.l);
          }
          localObject1 = paramView;
          if (localObject2 != null)
          {
            localObject1 = paramView;
            if (bool)
            {
              a((BuddyListFriends.BuddyChildTag)((View)localObject2).getTag(), null);
              paramView = this.l;
              if (paramView != null) {
                ((View)localObject2).setOnClickListener(paramView);
              }
              ((View)localObject2).setOnLongClickListener(this.p);
              localObject1 = localObject2;
            }
          }
        }
      }
    }
    else
    {
      localObject1 = paramView;
      if (paramView == null)
      {
        localObject1 = LayoutInflater.from(this.h).inflate(2131624552, paramViewGroup, false);
        ((View)localObject1).setTag(new AlphabetFriendAdapter.FriendViewHolder((View)localObject1));
      }
      paramView = (View)localObject1;
      if (!(((View)localObject1).getTag() instanceof AlphabetFriendAdapter.FriendViewHolder))
      {
        paramView = LayoutInflater.from(this.h).inflate(2131624552, paramViewGroup, false);
        paramView.setTag(new AlphabetFriendAdapter.FriendViewHolder(paramView));
      }
      localObject2 = (AlphabetFriendAdapter.FriendViewHolder)paramView.getTag();
      String str = String.valueOf(this.c[i1]);
      if (!TextUtils.isEmpty(str)) {
        if (str.equals("★")) {
          ((AlphabetFriendAdapter.FriendViewHolder)localObject2).b.setText(HardCodeUtil.a(2131898483));
        } else {
          ((AlphabetFriendAdapter.FriendViewHolder)localObject2).b.setText(str);
        }
      }
      localObject1 = paramView;
      if (AppSetting.e)
      {
        ((AlphabetFriendAdapter.FriendViewHolder)localObject2).b.setContentDescription(String.format(this.h.getString(2131888769), new Object[] { str.toLowerCase() }));
        localObject1 = paramView;
      }
    }
    EventCollector.getInstance().onListGetView(paramInt, (View)localObject1, paramViewGroup, getItemId(paramInt));
    return localObject1;
  }
  
  public int getViewTypeCount()
  {
    return 2;
  }
  
  public void h()
  {
    super.h();
    this.h = null;
    this.g = null;
  }
  
  public boolean onLongClick(View paramView)
  {
    boolean bool1 = this.q;
    boolean bool2 = false;
    if (!bool1) {
      return false;
    }
    paramView = paramView.getTag();
    if (paramView == null) {
      return false;
    }
    if ((paramView instanceof BuddyListItem.ViewTag))
    {
      Object localObject2 = ((BuddyListItem.ViewTag)paramView).c;
      if ((localObject2 != null) && ((localObject2 instanceof Friends)))
      {
        paramView = (ActionSheet)ActionSheetHelper.b(this.h, null);
        Object localObject1 = (FriendsManager)this.g.getManager(QQManagerFactory.FRIENDS_MANAGER);
        localObject2 = (Friends)localObject2;
        localObject1 = ((FriendsManager)localObject1).y(((Friends)localObject2).uin);
        if (this.g.getCurrentUin().equals(((Friends)localObject2).uin)) {
          return false;
        }
        bool1 = bool2;
        if (localObject1 != null) {
          if (((SpecialCareInfo)localObject1).globalSwitch == 0) {
            bool1 = bool2;
          } else {
            bool1 = true;
          }
        }
        int i1;
        if (bool1) {
          i1 = 2131888035;
        } else {
          i1 = 2131888036;
        }
        paramView.addButton(i1);
        paramView.addCancelButton(2131887648);
        paramView.setOnButtonClickListener(new AlphabetFriendAdapter.6(this, bool1, (Friends)localObject2, paramView));
      }
    }
    try
    {
      paramView.show();
      return true;
    }
    catch (Exception paramView) {}
    return true;
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    this.k = paramInt;
    super.onScrollStateChanged(paramAbsListView, paramInt);
    if (paramInt == 0) {
      j();
    }
    if (paramInt != 0) {
      ApngImage.pauseByTag(3);
    }
    if (paramInt == 0) {
      ApngImage.playByTag(3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.alphabet.AlphabetFriendAdapter
 * JD-Core Version:    0.7.0.1
 */