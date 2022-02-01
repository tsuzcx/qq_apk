package com.tencent.mobileqq.activity.contact.addcontact;

import MQQ.LhLogoResources;
import addcontacts.AccountSearchPb.ResultItem;
import addcontacts.AccountSearchPb.hotwordrecord;
import addcontacts.AccountSearchPb.record;
import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.api.IPublicAccountSearchRecommendManager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.AddFriendActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.contact.addcontact.publicaccount.PublicView;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BaseFragment;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.avatar.api.IQQAvatarService;
import com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.newfriend.api.INewFriendApi;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.richstatus.IIconListener;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.richstatus.StatusManager;
import com.tencent.mobileqq.search.business.addcontact.model.SearchResult;
import com.tencent.mobileqq.search.model.ISearchResultGroupModel;
import com.tencent.mobileqq.search.model.SearchResultItem;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.troop.utils.TroopInfoUIUtil;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.utils.DisplayUtils;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.vas.util.PrettyAccountUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class SearchBaseFragment
  extends BaseFragment
  implements View.OnClickListener, DecodeTaskCompletionListener, AbsListView.OnScrollListener
{
  private static final String a = "com.tencent.mobileqq.activity.contact.addcontact.SearchBaseFragment";
  private Handler b;
  private AccountSearchPb.record c;
  public final int d = 64;
  protected String e;
  protected int f = 0;
  protected boolean g;
  protected boolean h;
  protected BaseAdapter i;
  LinearLayout j;
  XListView k;
  CustomerLoadingDialog l;
  IFaceDecoder m;
  int n = 0;
  protected StatusManager o;
  protected int p;
  public Map<String, SpannableString> q = new ConcurrentHashMap();
  protected QQAppInterface r;
  protected BaseActivity s;
  protected ContactSearchFacade t;
  protected ContactSearchFacade.ISearchListener u = new SearchBaseFragment.1(this);
  protected Handler v = new SearchBaseFragment.2(this);
  protected IIconListener w = new SearchBaseFragment.3(this);
  private FriendListObserver x = new SearchBaseFragment.4(this);
  
  private static int a(String paramString1, String paramString2)
  {
    int i1 = paramString2.indexOf(paramString1);
    if (i1 >= 0) {
      return i1;
    }
    return paramString2.toLowerCase().indexOf(paramString1.toLowerCase());
  }
  
  public static SpannableString a(String paramString1, String paramString2, List<String> paramList)
  {
    if (paramString2 == null) {
      return null;
    }
    if (paramList == null) {
      return new SpannableString(paramString2);
    }
    int i1 = paramString2.length();
    Object localObject = paramList.iterator();
    int i2;
    while (((Iterator)localObject).hasNext())
    {
      i2 = a((String)((Iterator)localObject).next(), paramString2);
      if ((i2 >= 0) && (i2 < i1)) {
        i1 = i2;
      }
    }
    localObject = paramString2;
    if (i1 > 8)
    {
      localObject = paramString2;
      if (i1 != paramString2.length())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("…");
        ((StringBuilder)localObject).append(paramString2.substring(i1 - 8));
        localObject = ((StringBuilder)localObject).toString();
      }
    }
    paramString2 = new SpannableString((CharSequence)localObject);
    if (TextUtils.isEmpty(paramString1)) {
      i2 = f();
    } else {
      i2 = b(paramString1);
    }
    paramList = paramList.iterator();
    if (paramList.hasNext())
    {
      String str = (String)paramList.next();
      paramString1 = (String)localObject;
      int i3;
      for (i1 = 0;; i1 = i3)
      {
        int i4 = a(str, paramString1);
        if (i4 < 0) {
          break;
        }
        int i5 = str.length() + i4;
        ForegroundColorSpan localForegroundColorSpan = new ForegroundColorSpan(i2);
        i3 = i1 + i5;
        paramString2.setSpan(localForegroundColorSpan, i4 + i1, i3, 33);
        paramString1 = paramString1.substring(i5);
      }
    }
    return paramString2;
  }
  
  public static SpannableString a(String paramString, List<String> paramList)
  {
    return a(null, paramString, paramList);
  }
  
  public static SpannableString a(String paramString, List<String> paramList, int paramInt)
  {
    if (paramString == null) {
      return null;
    }
    if (paramList == null) {
      return new SpannableString(paramString);
    }
    int i1 = paramString.length();
    Object localObject1 = paramList.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      i2 = a((String)((Iterator)localObject1).next(), paramString);
      if ((i2 >= 0) && (i2 < i1)) {
        i1 = i2;
      }
    }
    int i2 = paramString.length();
    int i3;
    if ((i1 >= 0) && (i2 > paramInt))
    {
      localObject1 = b(paramString, paramList);
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        i3 = ((String)localObject1).length();
        if (i3 < paramInt)
        {
          i1 += i3;
          i3 = i1 - paramInt;
          localObject2 = paramString;
          if (i3 > 0)
          {
            localObject2 = paramString;
            if (i1 < paramString.length())
            {
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append("…");
              ((StringBuilder)localObject1).append(paramString.substring(i3, i1));
              ((StringBuilder)localObject1).append("…");
              localObject2 = ((StringBuilder)localObject1).toString();
            }
          }
          if ((i3 > 0) && (i1 >= i2))
          {
            paramString = new StringBuilder();
            paramString.append("…");
            paramString.append(((String)localObject2).substring(((String)localObject2).length() - paramInt, ((String)localObject2).length()));
            localObject1 = paramString.toString();
          }
          else
          {
            localObject1 = localObject2;
            if (i3 <= 0)
            {
              paramString = new StringBuilder();
              paramString.append(((String)localObject2).substring(0, paramInt));
              paramString.append("…");
              localObject1 = paramString.toString();
            }
          }
        }
        else
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append(paramString.substring(0, paramInt));
          ((StringBuilder)localObject1).append("…");
          localObject1 = ((StringBuilder)localObject1).toString();
        }
      }
      else
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(paramString.substring(0, paramInt));
        ((StringBuilder)localObject1).append("…");
        localObject1 = ((StringBuilder)localObject1).toString();
      }
    }
    else
    {
      localObject1 = paramString;
      if (i2 > paramInt)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(paramString.substring(0, paramInt));
        ((StringBuilder)localObject1).append("…");
        localObject1 = ((StringBuilder)localObject1).toString();
      }
    }
    Object localObject2 = new SpannableString((CharSequence)localObject1);
    paramList = paramList.iterator();
    if (paramList.hasNext())
    {
      String str = (String)paramList.next();
      paramInt = 0;
      paramString = (String)localObject1;
      for (;;)
      {
        i2 = a(str, paramString);
        if (i2 < 0) {
          break;
        }
        i3 = str.length() + i2;
        ForegroundColorSpan localForegroundColorSpan = new ForegroundColorSpan(f());
        i1 = paramInt + i3;
        ((SpannableString)localObject2).setSpan(localForegroundColorSpan, i2 + paramInt, i1, 33);
        paramString = paramString.substring(i3);
        paramInt = i1;
      }
    }
    return localObject2;
  }
  
  public static int b(String paramString)
  {
    int i1;
    try
    {
      i1 = Color.parseColor(paramString);
      return i1;
    }
    catch (Exception paramString)
    {
      i1 = f();
      if (QLog.isColorLevel())
      {
        String str = a;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("pretty_account color parse:");
        localStringBuilder.append(paramString);
        QLog.d(str, 2, localStringBuilder.toString());
      }
    }
    return i1;
  }
  
  private static String b(String paramString, List<String> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      String str = (String)paramList.next();
      if (paramString.indexOf(str) >= 0) {
        return str;
      }
      if (str.toLowerCase().indexOf(str.toLowerCase()) > 0) {
        return str;
      }
    }
    return null;
  }
  
  public static int f()
  {
    if ("1103".equals(ThemeUtil.curThemeId)) {
      return -16760704;
    }
    return -16734752;
  }
  
  protected int a(TextView paramTextView, BaseActivity paramBaseActivity)
  {
    paramTextView.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
    int i1 = paramTextView.getMeasuredHeight();
    float f1 = paramTextView.getMeasuredWidth();
    int i2 = AIOUtils.b(18.0F, paramBaseActivity.getResources());
    float f2 = AIOUtils.b(260.0F, paramBaseActivity.getResources());
    float f3 = FontSettingManager.getFontLevel() / 16.0F;
    return i1 / i2 + (int)(f1 * f3 / f2);
  }
  
  public SpannableString a(int paramInt, String paramString)
  {
    Object localObject1 = this.q;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(paramInt);
    ((StringBuilder)localObject2).append(":");
    ((StringBuilder)localObject2).append(paramString);
    localObject2 = (SpannableString)((Map)localObject1).get(((StringBuilder)localObject2).toString());
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = new SpannableString(paramString);
    }
    return localObject1;
  }
  
  public SpannableString a(int paramInt, String paramString, SpannableString paramSpannableString)
  {
    Map localMap = this.q;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramInt);
    localStringBuilder.append(":");
    localStringBuilder.append(paramString);
    return (SpannableString)localMap.put(localStringBuilder.toString(), paramSpannableString);
  }
  
  protected String a(SearchBaseFragment.ItemViewHolder paramItemViewHolder, AccountSearchPb.record paramrecord)
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    int i2 = paramrecord.age.get();
    int i3 = paramrecord.sex.get();
    int i1 = 1;
    if (i3 != 1)
    {
      if (i3 != 2) {
        i1 = -1;
      }
    }
    else {
      i1 = 0;
    }
    ((INewFriendApi)QRoute.api(INewFriendApi.class)).showGenderAge(paramItemViewHolder.d, i1, i2, localStringBuilder1);
    StringBuilder localStringBuilder2 = new StringBuilder();
    if (!TextUtils.isEmpty(paramrecord.province_name.get()))
    {
      localStringBuilder2.append(paramrecord.province_name.get());
      localStringBuilder2.append(" ");
    }
    if (!TextUtils.isEmpty(paramrecord.city_name.get())) {
      localStringBuilder2.append(paramrecord.city_name.get());
    }
    if ((localStringBuilder2.length() == 0) && (!TextUtils.isEmpty(paramrecord.country_name.get()))) {
      localStringBuilder2.append(paramrecord.country_name.get());
    }
    paramItemViewHolder.e.setText(localStringBuilder2.toString());
    localStringBuilder1.append(localStringBuilder2.toString());
    a(paramItemViewHolder, paramrecord.richStatus);
    return localStringBuilder1.toString();
  }
  
  protected void a() {}
  
  protected void a(int paramInt1, AccountSearchPb.record paramrecord, int paramInt2)
  {
    if (o() == null) {
      return;
    }
    boolean bool = true;
    long l1;
    switch (paramInt1)
    {
    default: 
      return;
    case 80000002: 
      paramInt1 = paramrecord.account_flag.get();
      PublicView.a(this.r, o(), paramrecord.class_index.get(), String.valueOf(paramrecord.uin.get()), String.valueOf(paramrecord.uin.get()), paramInt1, paramrecord.name.get(), 4);
      IPublicAccountSearchRecommendManager localIPublicAccountSearchRecommendManager = (IPublicAccountSearchRecommendManager)QRoute.api(IPublicAccountSearchRecommendManager.class);
      QQAppInterface localQQAppInterface = this.r;
      l1 = paramrecord.uin.get();
      String str = paramrecord.name.get();
      if (paramrecord.class_index.get() == 1) {
        bool = false;
      }
      localIPublicAccountSearchRecommendManager.updatePublicAccountSearchHistoryItem(localQQAppInterface, String.valueOf(l1), str, bool);
      return;
    case 80000001: 
      l1 = paramrecord.code.get();
      if (paramInt2 <= 0) {
        paramInt2 = 2;
      }
      paramrecord = TroopInfoUIUtil.a(String.valueOf(l1), paramInt2);
      paramrecord.putInt("exposureSource", 3);
      paramrecord.putString("keyword", this.e);
      paramrecord.putBoolean("isFromNative", true);
      paramrecord.putInt("t_s_f", 1000);
      TroopUtils.a(o(), paramrecord, 2);
      return;
    }
    a(paramrecord);
  }
  
  protected void a(int paramInt1, Object paramObject, int paramInt2, String paramString)
  {
    paramObject = this.v;
    if (paramObject != null) {
      paramObject.sendMessage(paramObject.obtainMessage(1, paramString));
    }
  }
  
  protected void a(AccountSearchPb.record paramrecord)
  {
    this.c = paramrecord;
    AddFriendActivity.startProfileCardActivity(o(), new SearchResultItem(paramrecord), this.r, true, 2);
  }
  
  @Deprecated
  public void a(Handler paramHandler)
  {
    this.b = paramHandler;
  }
  
  protected void a(View paramView)
  {
    if (paramView != null)
    {
      if (paramView.getParent() != null) {
        ((ViewGroup)paramView.getParent()).removeView(paramView);
      }
      this.j.removeAllViews();
      this.j.addView(paramView);
    }
  }
  
  protected void a(SearchBaseFragment.ItemViewHolder paramItemViewHolder, RichStatus paramRichStatus)
  {
    paramItemViewHolder.l = paramRichStatus;
    if ((paramRichStatus != null) && (!paramRichStatus.isEmpty()))
    {
      if (!TextUtils.isEmpty(paramRichStatus.actionText))
      {
        paramItemViewHolder.i = paramRichStatus.actionId;
        return;
      }
      paramItemViewHolder.i = 0;
      return;
    }
    paramItemViewHolder.i = 0;
  }
  
  protected void a(String paramString)
  {
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = HardCodeUtil.a(2131911075);
    }
    QQToast.makeText(BaseApplicationImpl.getContext(), str, 0).show(i());
  }
  
  public void a(String paramString, boolean paramBoolean) {}
  
  protected void a(List<ISearchResultGroupModel> paramList)
  {
    if (o() != null) {
      a(ViewFactory.a().a(80000008, o(), true, this.m, paramList));
    }
  }
  
  protected boolean a(ArrayList<SearchResult> paramArrayList)
  {
    return true;
  }
  
  protected String b(SearchBaseFragment.ItemViewHolder paramItemViewHolder, AccountSearchPb.record paramrecord)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    paramItemViewHolder.d.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
    paramItemViewHolder.d.setCompoundDrawablePadding(0);
    paramItemViewHolder.d.setBackgroundResource(0);
    Drawable localDrawable;
    if ((paramrecord.video_account.has()) && (paramrecord.video_account.get() == 1))
    {
      localDrawable = getResources().getDrawable(2130842778);
      ThemeUtil.setThemeFilter(localDrawable, ThemeUtil.curThemeId);
      paramItemViewHolder.b.setCompoundDrawablesWithIntrinsicBounds(null, null, localDrawable, null);
      paramItemViewHolder.b.setCompoundDrawablePadding((int)DisplayUtils.a(BaseApplicationImpl.getContext(), 6.0F));
    }
    else if ((paramrecord.flag.has()) && (paramrecord.flag.get() == 1L))
    {
      localDrawable = getResources().getDrawable(2130842755);
      ThemeUtil.setThemeFilter(localDrawable, ThemeUtil.curThemeId);
      paramItemViewHolder.b.setCompoundDrawablesWithIntrinsicBounds(null, null, localDrawable, null);
      paramItemViewHolder.b.setCompoundDrawablePadding((int)DisplayUtils.a(BaseApplicationImpl.getContext(), 6.0F));
    }
    else
    {
      paramItemViewHolder.b.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
    }
    if ((paramrecord.class_index.has()) && (paramrecord.class_index.get() == 1))
    {
      if (paramrecord.class_name.has())
      {
        paramItemViewHolder.d.setText(paramrecord.class_name.get());
        localStringBuilder.append(paramrecord.class_name.get());
      }
      if (paramrecord.brief.has())
      {
        paramItemViewHolder.e.setText(a(80000002, paramrecord.brief.get()));
        localStringBuilder.append(paramrecord.brief.get());
      }
    }
    else if (paramrecord.class_index.has())
    {
      paramItemViewHolder.d.setVisibility(8);
      if (paramrecord.brief.has())
      {
        paramItemViewHolder.e.setText(a(80000002, paramrecord.brief.get()));
        localStringBuilder.append(paramItemViewHolder.e.getText());
      }
    }
    int i1 = BaseApplicationImpl.getContext().getResources().getColor(2131168118);
    paramItemViewHolder.d.setTextColor(i1);
    return localStringBuilder.toString();
  }
  
  public void b(ArrayList<SearchResult> paramArrayList)
  {
    for (;;)
    {
      try
      {
        Iterator localIterator = paramArrayList.iterator();
        SearchResult localSearchResult;
        List localList;
        Object localObject2;
        Object localObject3;
        Object localObject1;
        int i1;
        if (localIterator.hasNext())
        {
          localSearchResult = (SearchResult)localIterator.next();
          localList = localSearchResult.d;
          localObject2 = localSearchResult.e.iterator();
          if (((Iterator)localObject2).hasNext())
          {
            localObject3 = (AccountSearchPb.record)((Iterator)localObject2).next();
            localObject1 = ((AccountSearchPb.record)localObject3).name.get();
            if (localSearchResult.a == 80000003) {
              paramArrayList = SpannableString.valueOf(SearchUtils.a((String)localObject1, (ArrayList)localList, 255));
            } else {
              paramArrayList = a((String)localObject1, localList);
            }
            a(localSearchResult.a, (String)localObject1, paramArrayList);
            i1 = localSearchResult.a;
            localObject1 = null;
          }
        }
        switch (i1)
        {
        case 80000002: 
        case 80000003: 
          paramArrayList = String.valueOf(((AccountSearchPb.record)localObject3).brief.get());
          break;
        case 80000001: 
          paramArrayList = String.valueOf(((AccountSearchPb.record)localObject3).code.get());
          break;
        case 80000000: 
          paramArrayList = String.valueOf(((AccountSearchPb.record)localObject3).uin.get());
          Object localObject4;
          if (!TextUtils.isEmpty(paramArrayList))
          {
            if (((AccountSearchPb.record)localObject3).uint32_richflag1_59.get() == 1)
            {
              localObject4 = PrettyAccountUtil.a(((AccountSearchPb.record)localObject3).uint32_richflag4_409.get());
              if (localObject4 != null) {
                localObject1 = ((LhLogoResources)localObject4).lightColor;
              }
              localObject1 = a((String)localObject1, paramArrayList, localList);
            }
            else
            {
              localObject1 = a(paramArrayList, localList);
            }
            a(localSearchResult.a, paramArrayList, (SpannableString)localObject1);
          }
          if ((localSearchResult.a != 80000000) || (TextUtils.isEmpty(((AccountSearchPb.record)localObject3).mobile.get()))) {
            continue;
          }
          paramArrayList = ((AccountSearchPb.record)localObject3).mobile.get();
          localObject1 = a(paramArrayList, localList);
          a(localSearchResult.a, paramArrayList, (SpannableString)localObject1);
          continue;
          paramArrayList = localSearchResult.f;
          if ((paramArrayList != null) && (paramArrayList.hotword.has()))
          {
            paramArrayList = paramArrayList.hotword.get();
            localObject1 = SpannableString.valueOf(SearchUtils.a(paramArrayList, (ArrayList)localList, 255));
            a(localSearchResult.a, paramArrayList, (SpannableString)localObject1);
          }
          paramArrayList = localSearchResult.i;
          if ((paramArrayList == null) || (paramArrayList.size() <= 0)) {
            continue;
          }
          localObject1 = paramArrayList.iterator();
          if (!((Iterator)localObject1).hasNext()) {
            continue;
          }
          localObject2 = (AccountSearchPb.ResultItem)((Iterator)localObject1).next();
          paramArrayList = ((FriendsManager)this.r.getManager(QQManagerFactory.FRIENDS_MANAGER)).m(String.valueOf(((AccountSearchPb.ResultItem)localObject2).uin.get()));
          if (paramArrayList == null) {
            break label705;
          }
          paramArrayList = paramArrayList.name;
          if (!TextUtils.isEmpty(paramArrayList))
          {
            localObject3 = a(paramArrayList, localList);
            a(localSearchResult.a, paramArrayList, (SpannableString)localObject3);
          }
          localObject3 = ((AccountSearchPb.ResultItem)localObject2).name.get().toStringUtf8();
          if (!TextUtils.isEmpty((CharSequence)localObject3))
          {
            localObject4 = a((String)localObject3, localList, 18);
            a(localSearchResult.a, (String)localObject3, (SpannableString)localObject4);
          }
          localObject3 = ((AccountSearchPb.ResultItem)localObject2).nick_name.get().toStringUtf8();
          if (!TextUtils.isEmpty(paramArrayList))
          {
            paramArrayList = a((String)localObject3, localList);
            a(localSearchResult.a, (String)localObject3, paramArrayList);
          }
          paramArrayList = ((AccountSearchPb.ResultItem)localObject2).summary.get().toStringUtf8();
          if (!TextUtils.isEmpty(paramArrayList))
          {
            localObject3 = a(paramArrayList, localList);
            a(localSearchResult.a, paramArrayList, (SpannableString)localObject3);
          }
          paramArrayList = ((AccountSearchPb.ResultItem)localObject2).phtot_update.get().toStringUtf8();
          if (TextUtils.isEmpty(paramArrayList)) {
            continue;
          }
          localObject2 = a(paramArrayList, localList, 18);
          a(localSearchResult.a, paramArrayList, (SpannableString)localObject2);
          continue;
          return;
        }
      }
      catch (Exception paramArrayList)
      {
        if (QLog.isColorLevel()) {
          QLog.d(a, 2, "", paramArrayList);
        }
      }
      paramArrayList = null;
      continue;
      label705:
      paramArrayList = "";
    }
  }
  
  protected void c()
  {
    Handler localHandler = this.v;
    if (localHandler != null) {
      localHandler.sendEmptyMessage(2);
    }
  }
  
  public void e()
  {
    LinearLayout localLinearLayout = this.j;
    if (localLinearLayout != null) {
      localLinearLayout.removeAllViews();
    }
  }
  
  public void g()
  {
    if (QLog.isColorLevel()) {
      QLog.d(a, 2, "clearHighLightString");
    }
    this.q.clear();
  }
  
  public View getView()
  {
    return this.j;
  }
  
  protected void h()
  {
    this.t = new ContactSearchFacade(this.r);
    this.t.a(this.u);
    this.m = ((IQQAvatarService)this.r.getRuntimeService(IQQAvatarService.class, "")).getInstance(this.r);
    this.m.setDecodeTaskCompletionListener(this);
    this.p = ((int)DisplayUtils.a(BaseApplicationImpl.getContext(), 12.0F));
    this.o = ((StatusManager)this.r.getManager(QQManagerFactory.STATUS_MANAGER));
    StatusManager localStatusManager = this.o;
    if (localStatusManager != null) {
      localStatusManager.a(this.w);
    }
  }
  
  protected int i()
  {
    return BaseApplicationImpl.getContext().getResources().getDimensionPixelSize(2131299920);
  }
  
  protected void j()
  {
    if (o() != null) {
      a(ViewFactory.a().a(80000006, o(), true, this.m, null));
    }
  }
  
  protected void k()
  {
    if (o() != null) {
      a(ViewFactory.a().a(80000007, o(), true, this.m, null));
    }
  }
  
  protected void l()
  {
    if (o() != null)
    {
      if (this.l == null) {
        this.l = new CustomerLoadingDialog(o());
      }
      if (!o().isFinishing()) {
        this.l.show();
      }
    }
  }
  
  protected void m()
  {
    CustomerLoadingDialog localCustomerLoadingDialog = this.l;
    if (localCustomerLoadingDialog != null) {
      localCustomerLoadingDialog.dismiss();
    }
  }
  
  protected int n()
  {
    int i1 = this.f;
    if ((i1 != 0) && (i1 != 3) && (i1 != 4))
    {
      if (i1 == 2) {
        return 80000002;
      }
      if (i1 == 5) {
        return 80000003;
      }
      return 80000001;
    }
    return 80000000;
  }
  
  public BaseActivity o()
  {
    return this.s;
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    this.s = ((BaseActivity)paramActivity);
  }
  
  public void onClick(View paramView) {}
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    p();
    o().addObserver(this.x);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.j = new LinearLayout(o());
    this.j.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    this.j.setOrientation(1);
    this.j.setClickable(true);
    this.k = new XListView(o());
    this.k.setCacheColorHint(0);
    this.k.setDivider(null);
    this.k.setSelector(2130853313);
    this.k.setOnScrollListener(this);
    this.k.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    paramLayoutInflater = this.j;
    AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onDecodeTaskCompleted type = ");
      localStringBuilder.append(paramInt2);
      localStringBuilder.append(", uin = ");
      localStringBuilder.append(paramString);
      QLog.d((String)localObject, 2, localStringBuilder.toString());
    }
    if ((paramBitmap != null) && (this.n == 0))
    {
      int i1 = this.k.getChildCount();
      paramInt1 = 0;
      while (paramInt1 < i1)
      {
        localObject = this.k.getChildAt(paramInt1).getTag();
        if ((localObject != null) && ((localObject instanceof SearchBaseFragment.ItemViewHolder)))
        {
          localObject = (SearchBaseFragment.ItemViewHolder)localObject;
          if ((((SearchBaseFragment.ItemViewHolder)localObject).f.equals(paramString)) || (paramString.equals(((SearchBaseFragment.ItemViewHolder)localObject).g))) {
            if (paramInt2 == 4)
            {
              if (80000001 == ((SearchBaseFragment.ItemViewHolder)localObject).j) {
                ((SearchBaseFragment.ItemViewHolder)localObject).a.setImageBitmap(paramBitmap);
              }
            }
            else
            {
              ((SearchBaseFragment.ItemViewHolder)localObject).a.setImageBitmap(paramBitmap);
              return;
            }
          }
        }
        paramInt1 += 1;
      }
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    q();
    o().removeObserver(this.x);
  }
  
  public void onDetach()
  {
    super.onDetach();
    this.s = null;
  }
  
  public void onResume()
  {
    super.onResume();
    if (this.m.isPausing()) {
      this.m.resume();
    }
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    this.n = paramInt;
    if (this.n != 0)
    {
      this.m.cancelPendingRequests();
      this.m.pause();
    }
    else if (this.m.isPausing())
    {
      this.m.resume();
      paramAbsListView = this.i;
      if (paramAbsListView != null) {
        paramAbsListView.notifyDataSetChanged();
      }
    }
    if (o() != null)
    {
      paramAbsListView = (InputMethodManager)o().getSystemService("input_method");
      if (paramAbsListView.isActive()) {
        paramAbsListView.hideSoftInputFromWindow(o().getWindow().getDecorView().getWindowToken(), 0);
      }
    }
  }
  
  @Deprecated
  public void p()
  {
    this.r = ((QQAppInterface)o().getAppRuntime());
    Bundle localBundle = getArguments();
    if (localBundle != null)
    {
      this.f = localBundle.getInt("from_key", 0);
      this.e = localBundle.getString("last_key_words");
    }
    h();
    if ((localBundle != null) && (!TextUtils.isEmpty(localBundle.getString("start_search_key"))) && (!localBundle.getBoolean("auto_add_and_prohibit_auto_search", false))) {
      a(localBundle.getString("start_search_key"), false);
    }
  }
  
  @Deprecated
  public void q()
  {
    this.l = null;
    this.v = null;
    ViewFactory.a().b();
    this.t.e();
    this.t = null;
    Object localObject = this.m;
    if (localObject != null) {
      ((IFaceDecoder)localObject).destory();
    }
    localObject = this.o;
    if (localObject != null) {
      ((StatusManager)localObject).b(this.w);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.addcontact.SearchBaseFragment
 * JD-Core Version:    0.7.0.1
 */