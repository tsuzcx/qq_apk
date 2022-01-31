package com.tencent.mobileqq.activity.contact.addcontact;

import aciy;
import aeup;
import aeur;
import aeus;
import aevk;
import aevl;
import aevm;
import aevn;
import aevp;
import aewb;
import aeyf;
import ajia;
import ajjh;
import ajjj;
import ajjy;
import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
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
import avck;
import avev;
import avwf;
import azlj;
import azwg;
import azwh;
import bacc;
import bbmy;
import begh;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.AddFriendActivity;
import com.tencent.mobileqq.activity.TroopInfoActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.pb.addcontacts.AccountSearchPb.ResultItem;
import com.tencent.pb.addcontacts.AccountSearchPb.hotwordrecord;
import com.tencent.pb.addcontacts.AccountSearchPb.record;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import ndo;

public class SearchBaseFragment
  extends Fragment
  implements View.OnClickListener, azwh, begh
{
  private static final String jdField_b_of_type_JavaLangString = SearchBaseFragment.class.getName();
  protected aeup a;
  protected aeur a;
  aeus jdField_a_of_type_Aeus;
  private ajjh jdField_a_of_type_Ajjh = new aevn(this);
  public Handler a;
  protected BaseAdapter a;
  LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  protected avck a;
  protected avev a;
  azwg jdField_a_of_type_Azwg;
  protected BaseActivity a;
  public QQAppInterface a;
  private AccountSearchPb.record jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record;
  public XListView a;
  public String a;
  public Map<String, SpannableString> a;
  private Handler jdField_b_of_type_AndroidOsHandler;
  public boolean b;
  public final int c = 64;
  protected boolean c;
  public int d = 0;
  public int e = 0;
  protected int f;
  
  public SearchBaseFragment()
  {
    this.jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap();
    this.jdField_a_of_type_Aeur = new aevk(this);
    this.jdField_a_of_type_AndroidOsHandler = new aevl(this);
    this.jdField_a_of_type_Avck = new aevm(this);
  }
  
  public static int a()
  {
    int i = -16734752;
    if ("1103".equals(ThemeUtil.curThemeId)) {
      i = -16760704;
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
  
  public static SpannableString a(String paramString, List<String> paramList)
  {
    if (paramString == null) {
      return null;
    }
    if (paramList == null) {
      return new SpannableString(paramString);
    }
    int i = paramString.length();
    Object localObject = paramList.iterator();
    int j;
    if (((Iterator)localObject).hasNext())
    {
      j = a((String)((Iterator)localObject).next(), paramString);
      if ((j < 0) || (j >= i)) {
        break label224;
      }
      i = j;
    }
    label224:
    for (;;)
    {
      break;
      localObject = paramString;
      if (i > 8)
      {
        localObject = paramString;
        if (i != paramString.length()) {
          localObject = "…" + paramString.substring(i - 8);
        }
      }
      SpannableString localSpannableString = new SpannableString((CharSequence)localObject);
      paramList = paramList.iterator();
      if (paramList.hasNext())
      {
        String str = (String)paramList.next();
        i = 0;
        for (paramString = (String)localObject;; paramString = paramString.substring(j))
        {
          int k = a(str, paramString);
          if (k < 0) {
            break;
          }
          j = str.length() + k;
          localSpannableString.setSpan(new ForegroundColorSpan(a()), k + i, i + j, 33);
          i += j;
        }
      }
      return localSpannableString;
    }
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
    Object localObject = paramList.iterator();
    int j;
    if (((Iterator)localObject).hasNext())
    {
      j = a((String)((Iterator)localObject).next(), paramString);
      if ((j < 0) || (j >= i)) {
        break label466;
      }
      i = j;
    }
    label457:
    label460:
    label466:
    for (;;)
    {
      break;
      j = paramString.length();
      int k;
      if ((i >= 0) && (j > paramInt))
      {
        localObject = a(paramString, paramList);
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          k = ((String)localObject).length();
          if (k < paramInt)
          {
            i += k;
            k = i - paramInt;
            if ((k <= 0) || (i >= paramString.length())) {
              break label460;
            }
          }
        }
      }
      for (localObject = "…" + paramString.substring(k, i) + "…";; localObject = paramString)
      {
        if ((k > 0) && (i >= j))
        {
          paramString = "…" + ((String)localObject).substring(((String)localObject).length() - paramInt, ((String)localObject).length());
          localObject = paramString;
        }
        SpannableString localSpannableString;
        for (;;)
        {
          localSpannableString = new SpannableString((CharSequence)localObject);
          paramList = paramList.iterator();
          if (!paramList.hasNext()) {
            break label457;
          }
          String str = (String)paramList.next();
          paramString = (String)localObject;
          paramInt = 0;
          for (;;)
          {
            j = a(str, paramString);
            if (j < 0) {
              break;
            }
            i = str.length() + j;
            localSpannableString.setSpan(new ForegroundColorSpan(a()), j + paramInt, paramInt + i, 33);
            paramInt += i;
            paramString = paramString.substring(i);
          }
          paramString = (String)localObject;
          if (k > 0) {
            break;
          }
          paramString = ((String)localObject).substring(0, paramInt) + "…";
          break;
          paramString = paramString.substring(0, paramInt) + "…";
          break;
          paramString = paramString.substring(0, paramInt) + "…";
          break;
          localObject = paramString;
          if (j > paramInt) {
            localObject = paramString.substring(0, paramInt) + "…";
          }
        }
        return localSpannableString;
      }
    }
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
  
  public int a(TextView paramTextView, BaseActivity paramBaseActivity)
  {
    paramTextView.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
    int i = paramTextView.getMeasuredHeight();
    float f1 = paramTextView.getMeasuredWidth();
    int j = aciy.a(18.0F, paramBaseActivity.getResources());
    float f2 = aciy.a(260.0F, paramBaseActivity.getResources());
    float f3 = ajia.a() / 16.0F;
    return i / j + (int)(f1 * f3 / f2);
  }
  
  public SpannableString a(int paramInt, String paramString)
  {
    SpannableString localSpannableString2 = (SpannableString)this.jdField_a_of_type_JavaUtilMap.get(paramInt + ":" + paramString);
    SpannableString localSpannableString1 = localSpannableString2;
    if (localSpannableString2 == null) {
      localSpannableString1 = new SpannableString(paramString);
    }
    return localSpannableString1;
  }
  
  public SpannableString a(int paramInt, String paramString, SpannableString paramSpannableString)
  {
    return (SpannableString)this.jdField_a_of_type_JavaUtilMap.put(paramInt + ":" + paramString, paramSpannableString);
  }
  
  public BaseActivity a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
  }
  
  protected String a(aevp paramaevp, AccountSearchPb.record paramrecord)
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    int j = paramrecord.age.get();
    int i;
    switch (paramrecord.sex.get())
    {
    default: 
      i = -1;
    }
    for (;;)
    {
      aeyf.a(paramaevp.c, i, j, localStringBuilder1);
      StringBuilder localStringBuilder2 = new StringBuilder();
      if (!TextUtils.isEmpty(paramrecord.province_name.get())) {
        localStringBuilder2.append(paramrecord.province_name.get()).append(" ");
      }
      if (!TextUtils.isEmpty(paramrecord.city_name.get())) {
        localStringBuilder2.append(paramrecord.city_name.get());
      }
      if ((localStringBuilder2.length() == 0) && (!TextUtils.isEmpty(paramrecord.country_name.get()))) {
        localStringBuilder2.append(paramrecord.country_name.get());
      }
      paramaevp.d.setText(localStringBuilder2.toString());
      localStringBuilder1.append(localStringBuilder2.toString());
      a(paramaevp, paramrecord.richStatus);
      return localStringBuilder1.toString();
      i = 0;
      continue;
      i = 1;
    }
  }
  
  public void a() {}
  
  protected void a(int paramInt, AccountSearchPb.record paramrecord)
  {
    if (a() == null) {
      return;
    }
    switch (paramInt)
    {
    default: 
      return;
    case 80000000: 
      a(paramrecord);
      return;
    case 80000001: 
      paramrecord = TroopInfoActivity.a(String.valueOf(paramrecord.code.get()), 2);
      paramrecord.putInt("exposureSource", 3);
      paramrecord.putInt("t_s_f", 1000);
      azlj.a(a(), paramrecord, 2);
      return;
    }
    paramInt = paramrecord.account_flag.get();
    PublicView.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, a(), paramrecord.class_index.get(), String.valueOf(paramrecord.uin.get()), String.valueOf(paramrecord.uin.get()), paramInt, paramrecord.name.get(), 4);
    ndo localndo = ndo.a();
    QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    long l = paramrecord.uin.get();
    String str = paramrecord.name.get();
    if (paramrecord.class_index.get() != 1) {}
    for (boolean bool = true;; bool = false)
    {
      localndo.a(localQQAppInterface, String.valueOf(l), str, bool);
      return;
    }
  }
  
  public void a(int paramInt1, Object paramObject, int paramInt2, String paramString)
  {
    if (this.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_AndroidOsHandler.sendMessage(this.jdField_a_of_type_AndroidOsHandler.obtainMessage(1, paramString));
    }
  }
  
  public void a(aevp paramaevp, RichStatus paramRichStatus)
  {
    paramaevp.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus = paramRichStatus;
    if ((paramRichStatus != null) && (!paramRichStatus.isEmpty()))
    {
      if (!TextUtils.isEmpty(paramRichStatus.actionText))
      {
        paramaevp.jdField_a_of_type_Int = paramRichStatus.actionId;
        return;
      }
      paramaevp.jdField_a_of_type_Int = 0;
      return;
    }
    paramaevp.jdField_a_of_type_Int = 0;
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
  
  protected void a(AccountSearchPb.record paramrecord)
  {
    this.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record = paramrecord;
    AddFriendActivity.a(a(), new SearchResultItem(paramrecord), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, true, 2);
  }
  
  public void a(String paramString)
  {
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = ajjy.a(2131647816);
    }
    bbmy.a(BaseApplicationImpl.getContext(), str, 0).b(b());
  }
  
  public void a(String paramString, boolean paramBoolean) {}
  
  public void a(ArrayList<aewb> paramArrayList)
  {
    for (;;)
    {
      aewb localaewb;
      List localList;
      Object localObject1;
      Object localObject2;
      Object localObject3;
      try
      {
        Iterator localIterator = paramArrayList.iterator();
        if (localIterator.hasNext())
        {
          localaewb = (aewb)localIterator.next();
          localList = localaewb.jdField_a_of_type_JavaUtilList;
          localObject1 = localaewb.b.iterator();
          if (!((Iterator)localObject1).hasNext()) {
            break label306;
          }
          localObject2 = (AccountSearchPb.record)((Iterator)localObject1).next();
          localObject3 = ((AccountSearchPb.record)localObject2).name.get();
          if (localaewb.jdField_a_of_type_Int == 80000003)
          {
            paramArrayList = SpannableString.valueOf(avwf.a((String)localObject3, (ArrayList)localList, 255));
            a(localaewb.jdField_a_of_type_Int, (String)localObject3, paramArrayList);
            paramArrayList = null;
          }
        }
        else
        {
          switch (localaewb.jdField_a_of_type_Int)
          {
          case 80000001: 
            if (!TextUtils.isEmpty(paramArrayList))
            {
              localObject3 = a(paramArrayList, localList);
              a(localaewb.jdField_a_of_type_Int, paramArrayList, (SpannableString)localObject3);
            }
            if ((localaewb.jdField_a_of_type_Int != 80000000) || (TextUtils.isEmpty(((AccountSearchPb.record)localObject2).mobile.get()))) {
              continue;
            }
            paramArrayList = ((AccountSearchPb.record)localObject2).mobile.get();
            localObject2 = a(paramArrayList, localList);
            a(localaewb.jdField_a_of_type_Int, paramArrayList, (SpannableString)localObject2);
            continue;
            return;
          }
        }
      }
      catch (Exception paramArrayList)
      {
        if (QLog.isColorLevel()) {
          QLog.d(jdField_b_of_type_JavaLangString, 2, "", paramArrayList);
        }
      }
      paramArrayList = a((String)localObject3, localList);
      continue;
      paramArrayList = String.valueOf(((AccountSearchPb.record)localObject2).code.get());
      continue;
      paramArrayList = String.valueOf(((AccountSearchPb.record)localObject2).uin.get());
      continue;
      paramArrayList = String.valueOf(((AccountSearchPb.record)localObject2).brief.get());
      continue;
      label306:
      paramArrayList = localaewb.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$hotwordrecord;
      if ((paramArrayList != null) && (paramArrayList.hotword.has()))
      {
        paramArrayList = paramArrayList.hotword.get();
        localObject1 = SpannableString.valueOf(avwf.a(paramArrayList, (ArrayList)localList, 255));
        a(localaewb.jdField_a_of_type_Int, paramArrayList, (SpannableString)localObject1);
      }
      paramArrayList = localaewb.c;
      if ((paramArrayList != null) && (paramArrayList.size() > 0))
      {
        localObject1 = paramArrayList.iterator();
        if (((Iterator)localObject1).hasNext())
        {
          localObject2 = (AccountSearchPb.ResultItem)((Iterator)localObject1).next();
          localObject3 = ((ajjj)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51)).e(String.valueOf(((AccountSearchPb.ResultItem)localObject2).uin.get()));
          paramArrayList = "";
          if (localObject3 != null) {
            paramArrayList = ((Friends)localObject3).name;
          }
          if (!TextUtils.isEmpty(paramArrayList))
          {
            localObject3 = a(paramArrayList, localList);
            a(localaewb.jdField_a_of_type_Int, paramArrayList, (SpannableString)localObject3);
          }
          localObject3 = ((AccountSearchPb.ResultItem)localObject2).name.get().toStringUtf8();
          if (!TextUtils.isEmpty((CharSequence)localObject3))
          {
            localObject4 = a((String)localObject3, localList, 18);
            a(localaewb.jdField_a_of_type_Int, (String)localObject3, (SpannableString)localObject4);
          }
          Object localObject4 = ((AccountSearchPb.ResultItem)localObject2).nick_name.get().toStringUtf8();
          if (!TextUtils.isEmpty(paramArrayList))
          {
            paramArrayList = a((String)localObject4, localList);
            a(localaewb.jdField_a_of_type_Int, (String)localObject4, paramArrayList);
          }
          localObject4 = ((AccountSearchPb.ResultItem)localObject2).summary.get().toStringUtf8();
          if (!TextUtils.isEmpty((CharSequence)localObject4)) {
            if (!TextUtils.isEmpty((CharSequence)localObject3)) {
              break label658;
            }
          }
          label658:
          for (paramArrayList = a((String)localObject4, localList);; paramArrayList = a((String)localObject4, localList))
          {
            a(localaewb.jdField_a_of_type_Int, (String)localObject4, paramArrayList);
            paramArrayList = ((AccountSearchPb.ResultItem)localObject2).phtot_update.get().toStringUtf8();
            if (TextUtils.isEmpty(paramArrayList)) {
              break;
            }
            localObject2 = a(paramArrayList, localList, 18);
            a(localaewb.jdField_a_of_type_Int, paramArrayList, (SpannableString)localObject2);
            break;
          }
        }
      }
    }
  }
  
  public boolean a(ArrayList<aewb> paramArrayList)
  {
    return true;
  }
  
  protected int b()
  {
    return BaseApplicationImpl.getContext().getResources().getDimensionPixelSize(2131167766);
  }
  
  protected String b(aevp paramaevp, AccountSearchPb.record paramrecord)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    paramaevp.c.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
    paramaevp.c.setCompoundDrawablePadding(0);
    paramaevp.c.setBackgroundResource(0);
    Drawable localDrawable;
    if ((paramrecord.video_account.has()) && (paramrecord.video_account.get() == 1))
    {
      localDrawable = getResources().getDrawable(2130841254);
      ThemeUtil.setThemeFilter(localDrawable, ThemeUtil.curThemeId);
      paramaevp.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(null, null, localDrawable, null);
      paramaevp.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablePadding((int)bacc.a(BaseApplicationImpl.getContext(), 6.0F));
      if ((!paramrecord.class_index.has()) || (paramrecord.class_index.get() != 1)) {
        break label323;
      }
      if (paramrecord.class_name.has())
      {
        paramaevp.c.setText(paramrecord.class_name.get());
        localStringBuilder.append(paramrecord.class_name.get());
      }
      if (paramrecord.brief.has())
      {
        paramaevp.d.setText(a(80000002, paramrecord.brief.get()));
        localStringBuilder.append(paramrecord.brief.get());
      }
    }
    for (;;)
    {
      int i = BaseApplicationImpl.getContext().getResources().getColor(2131101333);
      paramaevp.c.setTextColor(i);
      return localStringBuilder.toString();
      if ((paramrecord.flag.has()) && (paramrecord.flag.get() == 1L))
      {
        localDrawable = getResources().getDrawable(2130841234);
        ThemeUtil.setThemeFilter(localDrawable, ThemeUtil.curThemeId);
        paramaevp.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(null, null, localDrawable, null);
        paramaevp.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablePadding((int)bacc.a(BaseApplicationImpl.getContext(), 6.0F));
        break;
      }
      paramaevp.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
      break;
      label323:
      if (paramrecord.class_index.has())
      {
        paramaevp.c.setVisibility(8);
        if (paramrecord.brief.has())
        {
          paramaevp.d.setText(a(80000002, paramrecord.brief.get()));
          localStringBuilder.append(paramaevp.d.getText());
        }
      }
    }
  }
  
  protected int c()
  {
    if ((this.d == 0) || (this.d == 3) || (this.d == 4)) {
      return 80000000;
    }
    if (this.d == 2) {
      return 80000002;
    }
    if (this.d == 5) {
      return 80000003;
    }
    return 80000001;
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(2);
    }
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_AndroidWidgetLinearLayout != null) {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.removeAllViews();
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
    this.jdField_a_of_type_Aeup = new aeup(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_a_of_type_Aeup.a(this.jdField_a_of_type_Aeur);
    this.jdField_a_of_type_Azwg = new azwg(BaseApplicationImpl.getContext(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_a_of_type_Azwg.a(this);
    this.f = ((int)bacc.a(BaseApplicationImpl.getContext(), 12.0F));
    this.jdField_a_of_type_Avev = ((avev)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(15));
    if (this.jdField_a_of_type_Avev != null) {
      this.jdField_a_of_type_Avev.a(this.jdField_a_of_type_Avck);
    }
  }
  
  public void g()
  {
    if (a() != null) {
      a(ViewFactory.a().a(80000006, a(), true));
    }
  }
  
  public View getView()
  {
    return this.jdField_a_of_type_AndroidWidgetLinearLayout;
  }
  
  protected void h()
  {
    if (a() != null)
    {
      if (this.jdField_a_of_type_Aeus == null) {
        this.jdField_a_of_type_Aeus = new aeus(a());
      }
      if (!a().isFinishing()) {
        this.jdField_a_of_type_Aeus.show();
      }
    }
  }
  
  public void i()
  {
    if (this.jdField_a_of_type_Aeus != null) {
      this.jdField_a_of_type_Aeus.dismiss();
    }
  }
  
  @Deprecated
  public void j()
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
  public void k()
  {
    this.jdField_a_of_type_Aeus = null;
    this.jdField_a_of_type_AndroidOsHandler = null;
    ViewFactory.a().a();
    this.jdField_a_of_type_Aeup.d();
    this.jdField_a_of_type_Aeup = null;
    if (this.jdField_a_of_type_Azwg != null) {
      this.jdField_a_of_type_Azwg.d();
    }
    if (this.jdField_a_of_type_Avev != null) {
      this.jdField_a_of_type_Avev.b(this.jdField_a_of_type_Avck);
    }
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = ((FragmentActivity)paramActivity);
  }
  
  public void onClick(View paramView) {}
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    j();
    a().addObserver(this.jdField_a_of_type_Ajjh);
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
    this.jdField_a_of_type_ComTencentWidgetXListView.setSelector(2130849317);
    this.jdField_a_of_type_ComTencentWidgetXListView.setOnScrollListener(this);
    this.jdField_a_of_type_ComTencentWidgetXListView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    return this.jdField_a_of_type_AndroidWidgetLinearLayout;
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_b_of_type_JavaLangString, 2, "onDecodeTaskCompleted type = " + paramInt2 + ", uin = " + paramString);
    }
    int i;
    if ((paramBitmap != null) && (this.e == 0))
    {
      i = this.jdField_a_of_type_ComTencentWidgetXListView.getChildCount();
      paramInt1 = 0;
    }
    for (;;)
    {
      Object localObject;
      if (paramInt1 < i)
      {
        localObject = this.jdField_a_of_type_ComTencentWidgetXListView.getChildAt(paramInt1).getTag();
        if ((localObject == null) || (!(localObject instanceof aevp))) {
          break label167;
        }
        localObject = (aevp)localObject;
        if ((!((aevp)localObject).jdField_a_of_type_JavaLangString.equals(paramString)) && (!paramString.equals(((aevp)localObject).jdField_b_of_type_JavaLangString))) {
          break label167;
        }
        if (paramInt2 == 4)
        {
          if (80000001 != ((aevp)localObject).jdField_b_of_type_Int) {
            break label167;
          }
          ((aevp)localObject).jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(paramBitmap);
        }
      }
      else
      {
        return;
      }
      ((aevp)localObject).jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(paramBitmap);
      return;
      label167:
      paramInt1 += 1;
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    k();
    a().removeObserver(this.jdField_a_of_type_Ajjh);
  }
  
  public void onDetach()
  {
    super.onDetach();
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = null;
  }
  
  public void onResume()
  {
    super.onResume();
    if (this.jdField_a_of_type_Azwg.a()) {
      this.jdField_a_of_type_Azwg.b();
    }
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    this.e = paramInt;
    if (this.e != 0)
    {
      this.jdField_a_of_type_Azwg.a();
      this.jdField_a_of_type_Azwg.c();
    }
    for (;;)
    {
      if (a() != null)
      {
        paramAbsListView = (InputMethodManager)a().getSystemService("input_method");
        if (paramAbsListView.isActive()) {
          paramAbsListView.hideSoftInputFromWindow(a().getWindow().getDecorView().getWindowToken(), 0);
        }
      }
      return;
      if (this.jdField_a_of_type_Azwg.a())
      {
        this.jdField_a_of_type_Azwg.b();
        if (this.jdField_a_of_type_AndroidWidgetBaseAdapter != null) {
          this.jdField_a_of_type_AndroidWidgetBaseAdapter.notifyDataSetChanged();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.addcontact.SearchBaseFragment
 * JD-Core Version:    0.7.0.1
 */