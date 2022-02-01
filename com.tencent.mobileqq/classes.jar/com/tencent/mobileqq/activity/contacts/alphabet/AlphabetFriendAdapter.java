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
  private int jdField_a_of_type_Int = 0;
  private final View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  private View jdField_a_of_type_AndroidViewView;
  private AlphabetFriendAdapter.ItemLongClickListener jdField_a_of_type_ComTencentMobileqqActivityContactsAlphabetAlphabetFriendAdapter$ItemLongClickListener;
  private IndexBar jdField_a_of_type_ComTencentMobileqqActivityContactsAlphabetIndexBar;
  private final FriendsManager jdField_a_of_type_ComTencentMobileqqAppFriendsManager;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private final StatusManager jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager;
  private Comparator<AlphabetFriendAdapter.AlphabetFriend> jdField_a_of_type_JavaUtilComparator = new AlphabetFriendAdapter.5(this);
  public LinkedHashMap<String, List<AlphabetFriendAdapter.AlphabetFriend>> a;
  private boolean jdField_a_of_type_Boolean = true;
  public int[] a;
  public String[] a;
  private final int jdField_b_of_type_Int;
  private Context jdField_b_of_type_AndroidContentContext;
  private int c = 0;
  
  public AlphabetFriendAdapter(Context paramContext, QQAppInterface paramQQAppInterface, XListView paramXListView, IndexBar paramIndexBar, View.OnClickListener paramOnClickListener)
  {
    super(paramContext, paramQQAppInterface, paramXListView, true);
    this.jdField_a_of_type_JavaUtilLinkedHashMap = new LinkedHashMap();
    this.jdField_a_of_type_ArrayOfInt = new int[0];
    this.jdField_a_of_type_ArrayOfJavaLangString = new String[0];
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_b_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsAlphabetIndexBar = paramIndexBar;
    this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager = ((StatusManager)paramQQAppInterface.getManager(QQManagerFactory.STATUS_MANAGER));
    this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager = ((FriendsManager)paramQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER));
    this.jdField_b_of_type_Int = ((int)DisplayUtils.a(this.jdField_b_of_type_AndroidContentContext, 12.0F));
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsAlphabetAlphabetFriendAdapter$ItemLongClickListener = new AlphabetFriendAdapter.ItemLongClickListener(this);
  }
  
  private String a(Friends paramFriends, BuddyListFriends.BuddyChildTag paramBuddyChildTag)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager != null)
    {
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager;
      if (localObject != null)
      {
        if (this.jdField_b_of_type_AndroidContentContext == null) {
          return null;
        }
        ExtensionInfo localExtensionInfo = ((FriendsManager)localObject).a(paramFriends.uin);
        int m = 0;
        int i;
        if ((localExtensionInfo != null) && (!TextUtils.isEmpty(localExtensionInfo.feedContent))) {
          i = 1;
        } else {
          i = 0;
        }
        if (localExtensionInfo != null)
        {
          boolean bool;
          if (this.jdField_a_of_type_Int != 0) {
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
        int j;
        if ((localObject != null) && (localObject != RichStatus.getEmptyStatus()) && (!((RichStatus)localObject).isEmpty())) {
          j = 1;
        } else {
          j = 0;
        }
        int k;
        if ((j != 0) && (!TextUtils.isEmpty(((RichStatus)localObject).actionText))) {
          k = 1;
        } else {
          k = 0;
        }
        if ((i != 0) && ((localExtensionInfo.feedTime > localExtensionInfo.richTime) || (j == 0)))
        {
          paramFriends = new String(localExtensionInfo.feedContent);
          paramBuddyChildTag.jdField_b_of_type_ComTencentWidgetSingleLineTextView.setCompoundDrawables(null, null);
          if (localExtensionInfo.feedType == 2)
          {
            paramBuddyChildTag.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
            if (!TextUtils.isEmpty(localExtensionInfo.feedPhotoUrl)) {
              QQStoryCoverImageViewHelper.a(paramBuddyChildTag.jdField_a_of_type_AndroidWidgetImageView, localExtensionInfo.feedPhotoUrl, this.jdField_b_of_type_AndroidContentContext.getResources().getDrawable(2130850613));
            } else {
              paramBuddyChildTag.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(SkinEngine.getInstances().getDefaultThemeDrawable(2130850613));
            }
            paramBuddyChildTag.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
            paramBuddyChildTag.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(8);
          }
          else
          {
            paramBuddyChildTag.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
            localObject = paramBuddyChildTag.jdField_b_of_type_AndroidWidgetImageView;
            if (localExtensionInfo.feedType == 1) {
              i = 2130849885;
            } else {
              i = 2130849883;
            }
            ((ImageView)localObject).setBackgroundResource(i);
            localObject = paramBuddyChildTag.jdField_a_of_type_ComTencentImageURLImageView;
            if (localExtensionInfo.feedHasPhoto) {
              i = m;
            } else {
              i = 8;
            }
            ((URLImageView)localObject).setVisibility(i);
            paramBuddyChildTag.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
            paramBuddyChildTag.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(null);
          }
          localObject = null;
        }
        else
        {
          if (k != 0)
          {
            ((RichStatus)localObject).enableSummaryCached = paramFriends.isFriend();
            paramFriends = this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager.a(((RichStatus)localObject).actionId, 200);
            paramFriends = new BitmapDrawable(this.jdField_b_of_type_AndroidContentContext.getResources(), paramFriends);
            i = this.jdField_b_of_type_Int;
            paramFriends.setBounds(0, 0, Math.round(paramFriends.getIntrinsicWidth() * 1.0F / paramFriends.getIntrinsicHeight() * i), i);
            paramBuddyChildTag.jdField_b_of_type_ComTencentWidgetSingleLineTextView.setCompoundDrawables(paramFriends, null);
          }
          else if (j == 0)
          {
            localObject = RichStatus.getEmptyStatus();
            paramBuddyChildTag.jdField_b_of_type_ComTencentWidgetSingleLineTextView.setCompoundDrawables(null, null);
          }
          paramFriends = ((RichStatus)localObject).getActionAndData();
          String str = ((RichStatus)localObject).getPlainText();
          paramBuddyChildTag.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(8);
          paramBuddyChildTag.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
          paramBuddyChildTag.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
          paramBuddyChildTag.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(null);
          localObject = paramFriends;
          paramFriends = str;
        }
        if (localExtensionInfo == null)
        {
          paramBuddyChildTag.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(8);
          paramBuddyChildTag.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
        }
        paramBuddyChildTag.jdField_b_of_type_ComTencentWidgetSingleLineTextView.setExtendText((String)localObject, 1);
        paramBuddyChildTag.jdField_b_of_type_ComTencentWidgetSingleLineTextView.setText(paramFriends);
        return paramFriends;
      }
    }
    return null;
  }
  
  private List<AlphabetFriendAdapter.AlphabetFriend> a()
  {
    ArrayList localArrayList = new ArrayList();
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      Object localObject1 = this.jdField_b_of_type_AndroidContentContext;
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
      localObject1 = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
      if (localObject1 == null)
      {
        if (QLog.isColorLevel()) {
          QLog.e("AlphabetFriendAdapter", 2, "FriendManager is null");
        }
        return localArrayList;
      }
      localObject1 = ((FriendsManager)localObject1).c();
      if (localObject1 == null) {
        return localArrayList;
      }
      Iterator localIterator = ((List)localObject1).iterator();
      while (localIterator.hasNext())
      {
        Object localObject2 = (Entity)localIterator.next();
        if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)
        {
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.e("AlphabetFriendAdapter", 2, "getAlphabetFriend mApp is null ");
          return localArrayList;
        }
        localObject1 = this.jdField_b_of_type_AndroidContentContext;
        if (((localObject1 instanceof Activity)) && (((Activity)localObject1).isFinishing()))
        {
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.e("AlphabetFriendAdapter", 2, "getAlphabetFriend Activity is finishing ");
          return localArrayList;
        }
        localObject1 = null;
        BuddyListItem localBuddyListItem = BuddyItemBuilder.a(0, (Entity)localObject2, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_AndroidContentContext);
        if (localBuddyListItem != null)
        {
          localBuddyListItem.a(this);
          localObject2 = a((BuddyListFriends)localBuddyListItem);
          localObject1 = localObject2;
          if (localObject2 != null)
          {
            localObject1 = localObject2;
            if ((localBuddyListItem.c() & 0x1) == 1)
            {
              ((AlphabetFriendAdapter.AlphabetFriend)localObject2).jdField_a_of_type_Boolean = true;
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
  
  private void a(AlphabetFriendAdapter.AlphabetFriend paramAlphabetFriend, LinkedHashMap<String, List<AlphabetFriendAdapter.AlphabetFriend>> paramLinkedHashMap)
  {
    String str1 = paramAlphabetFriend.c;
    String str3 = "#";
    if ((str1 != null) && (paramAlphabetFriend.c.length() != 0)) {
      str1 = paramAlphabetFriend.c.substring(0, 1);
    } else {
      str1 = "#";
    }
    int i = str1.charAt(0);
    String str2;
    if ((65 > i) || (i > 90))
    {
      str2 = str3;
      if (97 <= i)
      {
        str2 = str3;
        if (i > 122) {}
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
    if (paramAlphabetFriend.jdField_a_of_type_Boolean)
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
      int i = 1;
      while (i < paramComparator.length)
      {
        paramComparator[i] += paramComparator[(i - 1)] + ((List)paramList.get(((Iterator)localObject2).next())).size() + 1;
        i += 1;
      }
      localObject2 = paramList.keySet().iterator();
      i = 0;
      while (((Iterator)localObject2).hasNext())
      {
        localObject1[i] = ((String)((Iterator)localObject2).next());
        i += 1;
      }
      return new Object[] { paramList, paramComparator, localObject1 };
    }
    return null;
  }
  
  private void f()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactsAlphabetIndexBar != null)
    {
      if (b() >= 5)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityContactsAlphabetIndexBar.setLetters(this.jdField_a_of_type_ArrayOfJavaLangString);
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsAlphabetIndexBar.setLetters(null);
    }
  }
  
  private void g()
  {
    if (this.jdField_a_of_type_ComTencentWidgetXListView == null) {
      return;
    }
    int j = this.jdField_a_of_type_ComTencentWidgetXListView.getChildCount();
    int i = 0;
    while (i < j)
    {
      Object localObject = this.jdField_a_of_type_ComTencentWidgetXListView.getChildAt(i).getTag();
      if ((localObject != null) && ((localObject instanceof BuddyListFriends.BuddyChildTag)))
      {
        localObject = (BuddyListFriends.BuddyChildTag)localObject;
        if ((TextUtils.isEmpty(((BuddyListFriends.BuddyChildTag)localObject).jdField_b_of_type_ComTencentWidgetSingleLineTextView.getText().toString())) && ((((BuddyListFriends.BuddyChildTag)localObject).jdField_a_of_type_JavaLangObject instanceof Friends))) {
          a((Friends)((BuddyListFriends.BuddyChildTag)localObject).jdField_a_of_type_JavaLangObject, (BuddyListFriends.BuddyChildTag)localObject);
        }
      }
      i += 1;
    }
  }
  
  public int a()
  {
    return 2131559309;
  }
  
  public int a(String paramString)
  {
    if (paramString == null) {
      return -1;
    }
    int j = paramString.charAt(0);
    if (this.jdField_a_of_type_ArrayOfJavaLangString != null)
    {
      int i = 0;
      for (;;)
      {
        paramString = this.jdField_a_of_type_ArrayOfJavaLangString;
        if (i >= paramString.length) {
          break;
        }
        int k = paramString[i].charAt(0);
        if (k != "★".charAt(0)) {
          if (j == 35) {
            i = this.jdField_a_of_type_ArrayOfJavaLangString.length - 1;
          } else if (j <= k) {}
        }
        i += 1;
      }
      i = -1;
      if (i >= 0) {
        return this.jdField_a_of_type_ArrayOfInt[i];
      }
    }
    return -1;
  }
  
  public AlphabetFriendAdapter.AlphabetFriend a(BuddyListFriends paramBuddyListFriends)
  {
    if ((paramBuddyListFriends != null) && (paramBuddyListFriends.a != null))
    {
      AlphabetFriendAdapter.AlphabetFriend localAlphabetFriend = new AlphabetFriendAdapter.AlphabetFriend(paramBuddyListFriends);
      paramBuddyListFriends = (Friends)paramBuddyListFriends.a;
      String str = paramBuddyListFriends.getFriendNickWithAlias();
      localAlphabetFriend.jdField_a_of_type_JavaLangString = paramBuddyListFriends.uin;
      localAlphabetFriend.b = str;
      localAlphabetFriend.c = ChnToSpell.a(str, 2);
      return localAlphabetFriend;
    }
    return null;
  }
  
  public void a()
  {
    ThreadManagerV2.excute(new AlphabetFriendAdapter.1(this), 16, null, true);
  }
  
  public void a(int paramInt)
  {
    this.c = paramInt;
  }
  
  public void a(View paramView)
  {
    this.jdField_a_of_type_AndroidViewView = paramView;
  }
  
  public void a(View paramView, int paramInt)
  {
    int i = Arrays.binarySearch(this.jdField_a_of_type_ArrayOfInt, paramInt);
    paramInt = i;
    if (i < 0) {
      paramInt = -(i + 1) - 1;
    }
    if (paramInt < this.jdField_a_of_type_ArrayOfJavaLangString.length)
    {
      if (paramInt < 0) {
        return;
      }
      if ((paramView instanceof TextView))
      {
        TextView localTextView = (TextView)paramView;
        localTextView.setPadding(localTextView.getPaddingLeft(), 0, 0, 0);
        paramView = this.jdField_a_of_type_ArrayOfJavaLangString[paramInt];
        if (paramView.equals("★")) {
          localTextView.setText(HardCodeUtil.a(2131700449));
        } else {
          localTextView.setText(paramView);
        }
        paramView = this.jdField_b_of_type_AndroidContentContext.getResources().getColorStateList(2131165574);
        if (ThemeUtil.isNowThemeIsNight(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false, null)) {
          paramView = this.jdField_b_of_type_AndroidContentContext.getResources().getColorStateList(2131166971);
        }
        localTextView.setTextColor(paramView);
        paramView = this.jdField_a_of_type_ComTencentMobileqqActivityContactsAlphabetIndexBar;
        if (paramView != null) {
          paramView.setChooseIndex(paramInt);
        }
        localTextView.setTypeface(Typeface.SANS_SERIF);
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public boolean a(int paramInt)
  {
    return Arrays.binarySearch(this.jdField_a_of_type_ArrayOfInt, paramInt) >= 0;
  }
  
  public boolean a(View paramView, int paramInt)
  {
    return this.jdField_a_of_type_ArrayOfJavaLangString.length <= 0;
  }
  
  public int b()
  {
    return this.c;
  }
  
  public void b()
  {
    ArrayList localArrayList = new ArrayList();
    try
    {
      localArrayList.addAll(a());
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
    Object[] arrayOfObject = a(localArrayList, this.jdField_a_of_type_JavaUtilComparator);
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
  
  public int c()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_ComTencentWidgetXListView != null)
    {
      if (this.jdField_b_of_type_AndroidContentContext == null) {
        return;
      }
      if (this.jdField_a_of_type_ComTencentWidgetXListView.getFooterViewsCount() <= 0) {
        return;
      }
      Object localObject = this.jdField_a_of_type_AndroidViewView;
      if (localObject == null) {
        return;
      }
      localObject = (TextView)((View)localObject).findViewById(2131362665);
      if (b() > 0)
      {
        int i = b();
        ((TextView)localObject).setText(this.jdField_b_of_type_AndroidContentContext.getResources().getString(2131691104, new Object[] { Integer.valueOf(i) }));
        return;
      }
      ((TextView)localObject).setText("");
    }
  }
  
  public void d()
  {
    a(0);
    this.jdField_a_of_type_JavaUtilLinkedHashMap.clear();
    this.jdField_a_of_type_ArrayOfInt = new int[0];
    this.jdField_a_of_type_ArrayOfJavaLangString = new String[0];
  }
  
  public void e()
  {
    super.e();
    this.jdField_b_of_type_AndroidContentContext = null;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
  }
  
  public int getCount()
  {
    int k = this.jdField_a_of_type_ArrayOfInt.length;
    int j = 0;
    int i = j;
    if (k != 0)
    {
      i = j;
      if (this.jdField_a_of_type_JavaUtilLinkedHashMap.size() != 0)
      {
        Object localObject = this.jdField_a_of_type_ArrayOfJavaLangString;
        if (localObject.length == 0) {
          return 0;
        }
        localObject = (List)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(localObject[(localObject.length - 1)]);
        i = j;
        if (localObject != null)
        {
          int[] arrayOfInt = this.jdField_a_of_type_ArrayOfInt;
          i = arrayOfInt[(arrayOfInt.length - 1)] + ((List)localObject).size() + 1;
        }
      }
    }
    return i;
  }
  
  public Object getItem(int paramInt)
  {
    int i = Arrays.binarySearch(this.jdField_a_of_type_ArrayOfInt, paramInt);
    if (i >= 0) {
      return null;
    }
    i = -(i + 1) - 1;
    return (AlphabetFriendAdapter.AlphabetFriend)((List)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(this.jdField_a_of_type_ArrayOfJavaLangString[i])).get(paramInt - this.jdField_a_of_type_ArrayOfInt[i] - 1);
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public int getItemViewType(int paramInt)
  {
    if (Arrays.binarySearch(this.jdField_a_of_type_ArrayOfInt, paramInt) < 0) {
      return 1;
    }
    return 0;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int i = Arrays.binarySearch(this.jdField_a_of_type_ArrayOfInt, paramInt);
    Object localObject2;
    Object localObject1;
    if (getItemViewType(paramInt) == 1)
    {
      i = -(i + 1) - 1;
      localObject2 = (List)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(this.jdField_a_of_type_ArrayOfJavaLangString[i]);
      i = paramInt - this.jdField_a_of_type_ArrayOfInt[i] - 1;
      localObject1 = paramView;
      if (localObject2 != null)
      {
        localObject1 = paramView;
        if (i < ((List)localObject2).size())
        {
          localObject1 = ((AlphabetFriendAdapter.AlphabetFriend)((List)localObject2).get(i)).jdField_a_of_type_ComTencentMobileqqActivityContactsFriendBuddyListFriends;
          boolean bool = localObject1 instanceof BuddyListFriends;
          if (bool) {
            ((BuddyListFriends)localObject1).a(1);
          }
          if (localObject1 == null) {
            localObject2 = null;
          } else {
            localObject2 = ((BuddyListItem)localObject1).a(0, paramInt, paramView, paramViewGroup, this.jdField_a_of_type_AndroidViewView$OnClickListener);
          }
          localObject1 = paramView;
          if (localObject2 != null)
          {
            localObject1 = paramView;
            if (bool)
            {
              a((BuddyListFriends.BuddyChildTag)((View)localObject2).getTag(), null);
              paramView = this.jdField_a_of_type_AndroidViewView$OnClickListener;
              if (paramView != null) {
                ((View)localObject2).setOnClickListener(paramView);
              }
              ((View)localObject2).setOnLongClickListener(this.jdField_a_of_type_ComTencentMobileqqActivityContactsAlphabetAlphabetFriendAdapter$ItemLongClickListener);
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
        localObject1 = LayoutInflater.from(this.jdField_b_of_type_AndroidContentContext).inflate(2131558922, paramViewGroup, false);
        ((View)localObject1).setTag(new AlphabetFriendAdapter.FriendViewHolder((View)localObject1));
      }
      paramView = (View)localObject1;
      if (!(((View)localObject1).getTag() instanceof AlphabetFriendAdapter.FriendViewHolder))
      {
        paramView = LayoutInflater.from(this.jdField_b_of_type_AndroidContentContext).inflate(2131558922, paramViewGroup, false);
        paramView.setTag(new AlphabetFriendAdapter.FriendViewHolder(paramView));
      }
      localObject2 = (AlphabetFriendAdapter.FriendViewHolder)paramView.getTag();
      String str = String.valueOf(this.jdField_a_of_type_ArrayOfJavaLangString[i]);
      if (!TextUtils.isEmpty(str)) {
        if (str.equals("★")) {
          ((AlphabetFriendAdapter.FriendViewHolder)localObject2).a.setText(HardCodeUtil.a(2131700449));
        } else {
          ((AlphabetFriendAdapter.FriendViewHolder)localObject2).a.setText(str);
        }
      }
      localObject1 = paramView;
      if (AppSetting.d)
      {
        ((AlphabetFriendAdapter.FriendViewHolder)localObject2).a.setContentDescription(String.format(this.jdField_b_of_type_AndroidContentContext.getString(2131691806), new Object[] { str.toLowerCase() }));
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
  
  public boolean onLongClick(View paramView)
  {
    boolean bool1 = this.jdField_a_of_type_Boolean;
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
      Object localObject2 = ((BuddyListItem.ViewTag)paramView).jdField_a_of_type_JavaLangObject;
      if ((localObject2 != null) && ((localObject2 instanceof Friends)))
      {
        paramView = (ActionSheet)ActionSheetHelper.a(this.jdField_b_of_type_AndroidContentContext, null);
        Object localObject1 = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
        localObject2 = (Friends)localObject2;
        localObject1 = ((FriendsManager)localObject1).a(((Friends)localObject2).uin);
        if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin().equals(((Friends)localObject2).uin)) {
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
        int i;
        if (bool1) {
          i = 2131691089;
        } else {
          i = 2131691090;
        }
        paramView.addButton(i);
        paramView.addCancelButton(2131690728);
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
    this.jdField_a_of_type_Int = paramInt;
    super.onScrollStateChanged(paramAbsListView, paramInt);
    if (paramInt == 0) {
      g();
    }
    if (paramInt != 0) {
      ApngImage.pauseByTag(3);
    }
    if (paramInt == 0) {
      ApngImage.playByTag(3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.alphabet.AlphabetFriendAdapter
 * JD-Core Version:    0.7.0.1
 */