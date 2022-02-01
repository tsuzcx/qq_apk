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
  private static final String jdField_b_of_type_JavaLangString = "com.tencent.mobileqq.activity.contact.addcontact.SearchBaseFragment";
  private AccountSearchPb.record jdField_a_of_type_AddcontactsAccountSearchPb$record;
  protected Handler a;
  protected BaseAdapter a;
  LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  protected ContactSearchFacade.ISearchListener a;
  protected ContactSearchFacade a;
  CustomerLoadingDialog jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactCustomerLoadingDialog;
  protected BaseActivity a;
  private FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new SearchBaseFragment.4(this);
  protected QQAppInterface a;
  IFaceDecoder jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder;
  protected IIconListener a;
  protected StatusManager a;
  XListView jdField_a_of_type_ComTencentWidgetXListView;
  protected String a;
  public Map<String, SpannableString> a;
  private Handler jdField_b_of_type_AndroidOsHandler;
  protected boolean b;
  public final int c = 64;
  protected boolean c;
  protected int d = 0;
  int e = 0;
  protected int f;
  
  public SearchBaseFragment()
  {
    this.jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap();
    this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactContactSearchFacade$ISearchListener = new SearchBaseFragment.1(this);
    this.jdField_a_of_type_AndroidOsHandler = new SearchBaseFragment.2(this);
    this.jdField_a_of_type_ComTencentMobileqqRichstatusIIconListener = new SearchBaseFragment.3(this);
  }
  
  public static int a()
  {
    if ("1103".equals(ThemeUtil.curThemeId)) {
      return -16760704;
    }
    return -16734752;
  }
  
  public static int a(String paramString)
  {
    int i;
    try
    {
      i = Color.parseColor(paramString);
      return i;
    }
    catch (Exception paramString)
    {
      i = a();
      if (QLog.isColorLevel())
      {
        String str = jdField_b_of_type_JavaLangString;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("pretty_account color parse:");
        localStringBuilder.append(paramString);
        QLog.d(str, 2, localStringBuilder.toString());
      }
    }
    return i;
  }
  
  private static int a(String paramString1, String paramString2)
  {
    int i = paramString2.indexOf(paramString1);
    if (i >= 0) {
      return i;
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
    int i = paramString2.length();
    Object localObject = paramList.iterator();
    int j;
    while (((Iterator)localObject).hasNext())
    {
      j = a((String)((Iterator)localObject).next(), paramString2);
      if ((j >= 0) && (j < i)) {
        i = j;
      }
    }
    localObject = paramString2;
    if (i > 8)
    {
      localObject = paramString2;
      if (i != paramString2.length())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("…");
        ((StringBuilder)localObject).append(paramString2.substring(i - 8));
        localObject = ((StringBuilder)localObject).toString();
      }
    }
    paramString2 = new SpannableString((CharSequence)localObject);
    if (TextUtils.isEmpty(paramString1)) {
      j = a();
    } else {
      j = a(paramString1);
    }
    paramList = paramList.iterator();
    if (paramList.hasNext())
    {
      String str = (String)paramList.next();
      paramString1 = (String)localObject;
      int k;
      for (i = 0;; i = k)
      {
        int m = a(str, paramString1);
        if (m < 0) {
          break;
        }
        int n = str.length() + m;
        ForegroundColorSpan localForegroundColorSpan = new ForegroundColorSpan(j);
        k = i + n;
        paramString2.setSpan(localForegroundColorSpan, m + i, k, 33);
        paramString1 = paramString1.substring(n);
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
    int i = paramString.length();
    Object localObject1 = paramList.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      j = a((String)((Iterator)localObject1).next(), paramString);
      if ((j >= 0) && (j < i)) {
        i = j;
      }
    }
    int j = paramString.length();
    int k;
    if ((i >= 0) && (j > paramInt))
    {
      localObject1 = a(paramString, paramList);
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        k = ((String)localObject1).length();
        if (k < paramInt)
        {
          i += k;
          k = i - paramInt;
          localObject2 = paramString;
          if (k > 0)
          {
            localObject2 = paramString;
            if (i < paramString.length())
            {
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append("…");
              ((StringBuilder)localObject1).append(paramString.substring(k, i));
              ((StringBuilder)localObject1).append("…");
              localObject2 = ((StringBuilder)localObject1).toString();
            }
          }
          if ((k > 0) && (i >= j))
          {
            paramString = new StringBuilder();
            paramString.append("…");
            paramString.append(((String)localObject2).substring(((String)localObject2).length() - paramInt, ((String)localObject2).length()));
            localObject1 = paramString.toString();
          }
          else
          {
            localObject1 = localObject2;
            if (k <= 0)
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
      if (j > paramInt)
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
        j = a(str, paramString);
        if (j < 0) {
          break;
        }
        k = str.length() + j;
        ForegroundColorSpan localForegroundColorSpan = new ForegroundColorSpan(a());
        i = paramInt + k;
        ((SpannableString)localObject2).setSpan(localForegroundColorSpan, j + paramInt, i, 33);
        paramString = paramString.substring(k);
        paramInt = i;
      }
    }
    return localObject2;
  }
  
  private static String a(String paramString, List<String> paramList)
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
  
  protected int a(TextView paramTextView, BaseActivity paramBaseActivity)
  {
    paramTextView.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
    int i = paramTextView.getMeasuredHeight();
    float f1 = paramTextView.getMeasuredWidth();
    int j = AIOUtils.b(18.0F, paramBaseActivity.getResources());
    float f2 = AIOUtils.b(260.0F, paramBaseActivity.getResources());
    float f3 = FontSettingManager.getFontLevel() / 16.0F;
    return i / j + (int)(f1 * f3 / f2);
  }
  
  public SpannableString a(int paramInt, String paramString)
  {
    Object localObject1 = this.jdField_a_of_type_JavaUtilMap;
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
    Map localMap = this.jdField_a_of_type_JavaUtilMap;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramInt);
    localStringBuilder.append(":");
    localStringBuilder.append(paramString);
    return (SpannableString)localMap.put(localStringBuilder.toString(), paramSpannableString);
  }
  
  public BaseActivity a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
  }
  
  protected String a(SearchBaseFragment.ItemViewHolder paramItemViewHolder, AccountSearchPb.record paramrecord)
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    int j = paramrecord.age.get();
    int k = paramrecord.sex.get();
    int i = 1;
    if (k != 1)
    {
      if (k != 2) {
        i = -1;
      }
    }
    else {
      i = 0;
    }
    ((INewFriendApi)QRoute.api(INewFriendApi.class)).showGenderAge(paramItemViewHolder.c, i, j, localStringBuilder1);
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
    paramItemViewHolder.d.setText(localStringBuilder2.toString());
    localStringBuilder1.append(localStringBuilder2.toString());
    a(paramItemViewHolder, paramrecord.richStatus);
    return localStringBuilder1.toString();
  }
  
  protected void a() {}
  
  protected void a(int paramInt1, AccountSearchPb.record paramrecord, int paramInt2)
  {
    if (a() == null) {
      return;
    }
    boolean bool = true;
    long l;
    switch (paramInt1)
    {
    default: 
      return;
    case 80000002: 
      paramInt1 = paramrecord.account_flag.get();
      PublicView.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, a(), paramrecord.class_index.get(), String.valueOf(paramrecord.uin.get()), String.valueOf(paramrecord.uin.get()), paramInt1, paramrecord.name.get(), 4);
      IPublicAccountSearchRecommendManager localIPublicAccountSearchRecommendManager = (IPublicAccountSearchRecommendManager)QRoute.api(IPublicAccountSearchRecommendManager.class);
      QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      l = paramrecord.uin.get();
      String str = paramrecord.name.get();
      if (paramrecord.class_index.get() == 1) {
        bool = false;
      }
      localIPublicAccountSearchRecommendManager.updatePublicAccountSearchHistoryItem(localQQAppInterface, String.valueOf(l), str, bool);
      return;
    case 80000001: 
      l = paramrecord.code.get();
      if (paramInt2 <= 0) {
        paramInt2 = 2;
      }
      paramrecord = TroopInfoUIUtil.a(String.valueOf(l), paramInt2);
      paramrecord.putInt("exposureSource", 3);
      paramrecord.putString("keyword", this.jdField_a_of_type_JavaLangString);
      paramrecord.putBoolean("isFromNative", true);
      paramrecord.putInt("t_s_f", 1000);
      TroopUtils.a(a(), paramrecord, 2);
      return;
    }
    a(paramrecord);
  }
  
  protected void a(int paramInt1, Object paramObject, int paramInt2, String paramString)
  {
    paramObject = this.jdField_a_of_type_AndroidOsHandler;
    if (paramObject != null) {
      paramObject.sendMessage(paramObject.obtainMessage(1, paramString));
    }
  }
  
  protected void a(AccountSearchPb.record paramrecord)
  {
    this.jdField_a_of_type_AddcontactsAccountSearchPb$record = paramrecord;
    AddFriendActivity.a(a(), new SearchResultItem(paramrecord), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, true, 2);
  }
  
  @Deprecated
  public void a(Handler paramHandler)
  {
    this.jdField_b_of_type_AndroidOsHandler = paramHandler;
  }
  
  protected void a(View paramView)
  {
    if (paramView != null)
    {
      if (paramView.getParent() != null) {
        ((ViewGroup)paramView.getParent()).removeView(paramView);
      }
      this.jdField_a_of_type_AndroidWidgetLinearLayout.removeAllViews();
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(paramView);
    }
  }
  
  protected void a(SearchBaseFragment.ItemViewHolder paramItemViewHolder, RichStatus paramRichStatus)
  {
    paramItemViewHolder.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus = paramRichStatus;
    if ((paramRichStatus != null) && (!paramRichStatus.isEmpty()))
    {
      if (!TextUtils.isEmpty(paramRichStatus.actionText))
      {
        paramItemViewHolder.jdField_a_of_type_Int = paramRichStatus.actionId;
        return;
      }
      paramItemViewHolder.jdField_a_of_type_Int = 0;
      return;
    }
    paramItemViewHolder.jdField_a_of_type_Int = 0;
  }
  
  protected void a(String paramString)
  {
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = HardCodeUtil.a(2131713528);
    }
    QQToast.a(BaseApplicationImpl.getContext(), str, 0).b(b());
  }
  
  public void a(String paramString, boolean paramBoolean) {}
  
  public void a(ArrayList<SearchResult> paramArrayList)
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
        int i;
        if (localIterator.hasNext())
        {
          localSearchResult = (SearchResult)localIterator.next();
          localList = localSearchResult.jdField_a_of_type_JavaUtilList;
          localObject2 = localSearchResult.b.iterator();
          if (((Iterator)localObject2).hasNext())
          {
            localObject3 = (AccountSearchPb.record)((Iterator)localObject2).next();
            localObject1 = ((AccountSearchPb.record)localObject3).name.get();
            if (localSearchResult.jdField_a_of_type_Int == 80000003) {
              paramArrayList = SpannableString.valueOf(SearchUtils.a((String)localObject1, (ArrayList)localList, 255));
            } else {
              paramArrayList = a((String)localObject1, localList);
            }
            a(localSearchResult.jdField_a_of_type_Int, (String)localObject1, paramArrayList);
            i = localSearchResult.jdField_a_of_type_Int;
            localObject1 = null;
          }
        }
        switch (i)
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
            a(localSearchResult.jdField_a_of_type_Int, paramArrayList, (SpannableString)localObject1);
          }
          if ((localSearchResult.jdField_a_of_type_Int != 80000000) || (TextUtils.isEmpty(((AccountSearchPb.record)localObject3).mobile.get()))) {
            continue;
          }
          paramArrayList = ((AccountSearchPb.record)localObject3).mobile.get();
          localObject1 = a(paramArrayList, localList);
          a(localSearchResult.jdField_a_of_type_Int, paramArrayList, (SpannableString)localObject1);
          continue;
          paramArrayList = localSearchResult.jdField_a_of_type_AddcontactsAccountSearchPb$hotwordrecord;
          if ((paramArrayList != null) && (paramArrayList.hotword.has()))
          {
            paramArrayList = paramArrayList.hotword.get();
            localObject1 = SpannableString.valueOf(SearchUtils.a(paramArrayList, (ArrayList)localList, 255));
            a(localSearchResult.jdField_a_of_type_Int, paramArrayList, (SpannableString)localObject1);
          }
          paramArrayList = localSearchResult.c;
          if ((paramArrayList == null) || (paramArrayList.size() <= 0)) {
            continue;
          }
          localObject1 = paramArrayList.iterator();
          if (!((Iterator)localObject1).hasNext()) {
            continue;
          }
          localObject2 = (AccountSearchPb.ResultItem)((Iterator)localObject1).next();
          paramArrayList = ((FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).e(String.valueOf(((AccountSearchPb.ResultItem)localObject2).uin.get()));
          if (paramArrayList == null) {
            break label705;
          }
          paramArrayList = paramArrayList.name;
          if (!TextUtils.isEmpty(paramArrayList))
          {
            localObject3 = a(paramArrayList, localList);
            a(localSearchResult.jdField_a_of_type_Int, paramArrayList, (SpannableString)localObject3);
          }
          localObject3 = ((AccountSearchPb.ResultItem)localObject2).name.get().toStringUtf8();
          if (!TextUtils.isEmpty((CharSequence)localObject3))
          {
            localObject4 = a((String)localObject3, localList, 18);
            a(localSearchResult.jdField_a_of_type_Int, (String)localObject3, (SpannableString)localObject4);
          }
          localObject3 = ((AccountSearchPb.ResultItem)localObject2).nick_name.get().toStringUtf8();
          if (!TextUtils.isEmpty(paramArrayList))
          {
            paramArrayList = a((String)localObject3, localList);
            a(localSearchResult.jdField_a_of_type_Int, (String)localObject3, paramArrayList);
          }
          paramArrayList = ((AccountSearchPb.ResultItem)localObject2).summary.get().toStringUtf8();
          if (!TextUtils.isEmpty(paramArrayList))
          {
            localObject3 = a(paramArrayList, localList);
            a(localSearchResult.jdField_a_of_type_Int, paramArrayList, (SpannableString)localObject3);
          }
          paramArrayList = ((AccountSearchPb.ResultItem)localObject2).phtot_update.get().toStringUtf8();
          if (TextUtils.isEmpty(paramArrayList)) {
            continue;
          }
          localObject2 = a(paramArrayList, localList, 18);
          a(localSearchResult.jdField_a_of_type_Int, paramArrayList, (SpannableString)localObject2);
          continue;
          return;
        }
      }
      catch (Exception paramArrayList)
      {
        if (QLog.isColorLevel()) {
          QLog.d(jdField_b_of_type_JavaLangString, 2, "", paramArrayList);
        }
      }
      paramArrayList = null;
      continue;
      label705:
      paramArrayList = "";
    }
  }
  
  protected void a(List<ISearchResultGroupModel> paramList)
  {
    if (a() != null) {
      a(ViewFactory.a().a(80000008, a(), true, this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder, paramList));
    }
  }
  
  protected boolean a(ArrayList<SearchResult> paramArrayList)
  {
    return true;
  }
  
  protected int b()
  {
    return BaseApplicationImpl.getContext().getResources().getDimensionPixelSize(2131299168);
  }
  
  protected String b(SearchBaseFragment.ItemViewHolder paramItemViewHolder, AccountSearchPb.record paramrecord)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    paramItemViewHolder.c.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
    paramItemViewHolder.c.setCompoundDrawablePadding(0);
    paramItemViewHolder.c.setBackgroundResource(0);
    Drawable localDrawable;
    if ((paramrecord.video_account.has()) && (paramrecord.video_account.get() == 1))
    {
      localDrawable = getResources().getDrawable(2130841861);
      ThemeUtil.setThemeFilter(localDrawable, ThemeUtil.curThemeId);
      paramItemViewHolder.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(null, null, localDrawable, null);
      paramItemViewHolder.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablePadding((int)DisplayUtils.a(BaseApplicationImpl.getContext(), 6.0F));
    }
    else if ((paramrecord.flag.has()) && (paramrecord.flag.get() == 1L))
    {
      localDrawable = getResources().getDrawable(2130841838);
      ThemeUtil.setThemeFilter(localDrawable, ThemeUtil.curThemeId);
      paramItemViewHolder.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(null, null, localDrawable, null);
      paramItemViewHolder.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablePadding((int)DisplayUtils.a(BaseApplicationImpl.getContext(), 6.0F));
    }
    else
    {
      paramItemViewHolder.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
    }
    if ((paramrecord.class_index.has()) && (paramrecord.class_index.get() == 1))
    {
      if (paramrecord.class_name.has())
      {
        paramItemViewHolder.c.setText(paramrecord.class_name.get());
        localStringBuilder.append(paramrecord.class_name.get());
      }
      if (paramrecord.brief.has())
      {
        paramItemViewHolder.d.setText(a(80000002, paramrecord.brief.get()));
        localStringBuilder.append(paramrecord.brief.get());
      }
    }
    else if (paramrecord.class_index.has())
    {
      paramItemViewHolder.c.setVisibility(8);
      if (paramrecord.brief.has())
      {
        paramItemViewHolder.d.setText(a(80000002, paramrecord.brief.get()));
        localStringBuilder.append(paramItemViewHolder.d.getText());
      }
    }
    int i = BaseApplicationImpl.getContext().getResources().getColor(2131167138);
    paramItemViewHolder.c.setTextColor(i);
    return localStringBuilder.toString();
  }
  
  protected int c()
  {
    int i = this.d;
    if ((i != 0) && (i != 3) && (i != 4))
    {
      if (i == 2) {
        return 80000002;
      }
      if (i == 5) {
        return 80000003;
      }
      return 80000001;
    }
    return 80000000;
  }
  
  protected void c()
  {
    Handler localHandler = this.jdField_a_of_type_AndroidOsHandler;
    if (localHandler != null) {
      localHandler.sendEmptyMessage(2);
    }
  }
  
  public void d()
  {
    LinearLayout localLinearLayout = this.jdField_a_of_type_AndroidWidgetLinearLayout;
    if (localLinearLayout != null) {
      localLinearLayout.removeAllViews();
    }
  }
  
  public void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_b_of_type_JavaLangString, 2, "clearHighLightString");
    }
    this.jdField_a_of_type_JavaUtilMap.clear();
  }
  
  protected void f()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactContactSearchFacade = new ContactSearchFacade(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactContactSearchFacade.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactContactSearchFacade$ISearchListener);
    this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder = ((IQQAvatarService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IQQAvatarService.class, "")).getInstance(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.setDecodeTaskCompletionListener(this);
    this.f = ((int)DisplayUtils.a(BaseApplicationImpl.getContext(), 12.0F));
    this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager = ((StatusManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.STATUS_MANAGER));
    StatusManager localStatusManager = this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager;
    if (localStatusManager != null) {
      localStatusManager.a(this.jdField_a_of_type_ComTencentMobileqqRichstatusIIconListener);
    }
  }
  
  protected void g()
  {
    if (a() != null) {
      a(ViewFactory.a().a(80000006, a(), true, this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder, null));
    }
  }
  
  public View getView()
  {
    return this.jdField_a_of_type_AndroidWidgetLinearLayout;
  }
  
  protected void h()
  {
    if (a() != null) {
      a(ViewFactory.a().a(80000007, a(), true, this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder, null));
    }
  }
  
  protected void i()
  {
    if (a() != null)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactCustomerLoadingDialog == null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactCustomerLoadingDialog = new CustomerLoadingDialog(a());
      }
      if (!a().isFinishing()) {
        this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactCustomerLoadingDialog.show();
      }
    }
  }
  
  protected void j()
  {
    CustomerLoadingDialog localCustomerLoadingDialog = this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactCustomerLoadingDialog;
    if (localCustomerLoadingDialog != null) {
      localCustomerLoadingDialog.dismiss();
    }
  }
  
  @Deprecated
  public void k()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)a().getAppRuntime());
    Bundle localBundle = getArguments();
    if (localBundle != null)
    {
      this.d = localBundle.getInt("from_key", 0);
      this.jdField_a_of_type_JavaLangString = localBundle.getString("last_key_words");
    }
    f();
    if ((localBundle != null) && (!TextUtils.isEmpty(localBundle.getString("start_search_key"))) && (!localBundle.getBoolean("auto_add_and_prohibit_auto_search", false))) {
      a(localBundle.getString("start_search_key"), false);
    }
  }
  
  @Deprecated
  public void l()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactCustomerLoadingDialog = null;
    this.jdField_a_of_type_AndroidOsHandler = null;
    ViewFactory.a().a();
    this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactContactSearchFacade.d();
    this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactContactSearchFacade = null;
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder;
    if (localObject != null) {
      ((IFaceDecoder)localObject).destory();
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager;
    if (localObject != null) {
      ((StatusManager)localObject).b(this.jdField_a_of_type_ComTencentMobileqqRichstatusIIconListener);
    }
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = ((BaseActivity)paramActivity);
  }
  
  public void onClick(View paramView) {}
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    k();
    a().addObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout = new LinearLayout(a());
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setOrientation(1);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setClickable(true);
    this.jdField_a_of_type_ComTencentWidgetXListView = new XListView(a());
    this.jdField_a_of_type_ComTencentWidgetXListView.setCacheColorHint(0);
    this.jdField_a_of_type_ComTencentWidgetXListView.setDivider(null);
    this.jdField_a_of_type_ComTencentWidgetXListView.setSelector(2130851081);
    this.jdField_a_of_type_ComTencentWidgetXListView.setOnScrollListener(this);
    this.jdField_a_of_type_ComTencentWidgetXListView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    paramLayoutInflater = this.jdField_a_of_type_AndroidWidgetLinearLayout;
    AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = jdField_b_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onDecodeTaskCompleted type = ");
      localStringBuilder.append(paramInt2);
      localStringBuilder.append(", uin = ");
      localStringBuilder.append(paramString);
      QLog.d((String)localObject, 2, localStringBuilder.toString());
    }
    if ((paramBitmap != null) && (this.e == 0))
    {
      int i = this.jdField_a_of_type_ComTencentWidgetXListView.getChildCount();
      paramInt1 = 0;
      while (paramInt1 < i)
      {
        localObject = this.jdField_a_of_type_ComTencentWidgetXListView.getChildAt(paramInt1).getTag();
        if ((localObject != null) && ((localObject instanceof SearchBaseFragment.ItemViewHolder)))
        {
          localObject = (SearchBaseFragment.ItemViewHolder)localObject;
          if ((((SearchBaseFragment.ItemViewHolder)localObject).jdField_a_of_type_JavaLangString.equals(paramString)) || (paramString.equals(((SearchBaseFragment.ItemViewHolder)localObject).jdField_b_of_type_JavaLangString))) {
            if (paramInt2 == 4)
            {
              if (80000001 == ((SearchBaseFragment.ItemViewHolder)localObject).jdField_b_of_type_Int) {
                ((SearchBaseFragment.ItemViewHolder)localObject).jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(paramBitmap);
              }
            }
            else
            {
              ((SearchBaseFragment.ItemViewHolder)localObject).jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(paramBitmap);
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
    l();
    a().removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
  }
  
  public void onDetach()
  {
    super.onDetach();
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = null;
  }
  
  public void onResume()
  {
    super.onResume();
    if (this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.isPausing()) {
      this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.resume();
    }
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    this.e = paramInt;
    if (this.e != 0)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.cancelPendingRequests();
      this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.pause();
    }
    else if (this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.isPausing())
    {
      this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.resume();
      paramAbsListView = this.jdField_a_of_type_AndroidWidgetBaseAdapter;
      if (paramAbsListView != null) {
        paramAbsListView.notifyDataSetChanged();
      }
    }
    if (a() != null)
    {
      paramAbsListView = (InputMethodManager)a().getSystemService("input_method");
      if (paramAbsListView.isActive()) {
        paramAbsListView.hideSoftInputFromWindow(a().getWindow().getDecorView().getWindowToken(), 0);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.addcontact.SearchBaseFragment
 * JD-Core Version:    0.7.0.1
 */