import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.graphics.drawable.LayerDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.biz.lebasearch.Utils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivityForTool;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.activateFriend.ActivateFriendActivity;
import com.tencent.mobileqq.activity.contact.newfriend.NewFriendActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.confess.ConfessMsgListFragment;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.dating.MsgBoxListActivity;
import com.tencent.mobileqq.forward.ForwardShareCardOption;
import com.tencent.mobileqq.search.activity.UniteSearchActivity;
import com.tencent.mobileqq.search.fragment.searchresult.KDSearchResultFragment;
import com.tencent.mobileqq.search.util.SearchConfigManager;
import com.tencent.mobileqq.search.util.SearchUtils.1;
import com.tencent.mobileqq.search.util.SearchUtils.2;
import com.tencent.mobileqq.search.util.SearchUtils.3;
import com.tencent.mobileqq.search.util.VADHelper;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.utils.ChnToSpell;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.SkinnableBitmapDrawable;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Array;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.List<Ljava.lang.String;>;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import mqq.app.AppRuntime;
import org.json.JSONArray;
import org.json.JSONObject;

public class bbup
{
  public static int a;
  public static long a;
  public static Paint a;
  private static HashMap<String, String> a;
  public static boolean a;
  public static char[] a;
  public static int b;
  public static long b;
  public static boolean b;
  private static int jdField_c_of_type_Int;
  private static boolean jdField_c_of_type_Boolean;
  
  static
  {
    jdField_a_of_type_Long = -1L;
    jdField_c_of_type_Boolean = true;
    jdField_a_of_type_JavaUtilHashMap = new HashMap();
    jdField_b_of_type_Long = 0L;
    jdField_a_of_type_Int = 11;
    jdField_b_of_type_Int = 2;
    jdField_a_of_type_ArrayOfChar = new char[] { 44, 46, 8230, -244, 12290, -225, -255, -162, 35, -230, 12289, 8220, 8221, 8216, 8217, -248, -247, 45, 8212, -229, 64, 64, 35, 215, 37, 37, 46, 183, 47, 92, 12298, 12299, 12304, 12305, 60, 62 };
  }
  
  public static float a(TextView paramTextView, CharSequence paramCharSequence)
  {
    if ((paramTextView == null) || (TextUtils.isEmpty(paramCharSequence))) {
      return 0.0F;
    }
    return paramTextView.getPaint().measureText(paramCharSequence.toString());
  }
  
  public static int a()
  {
    int i = BaseApplicationImpl.sApplication.getResources().getColor(2131166909);
    if (ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, "")) {
      i = BaseApplicationImpl.sApplication.getResources().getColor(2131166911);
    }
    return i;
  }
  
  public static int a(String paramString1, String paramString2)
  {
    int k = paramString1.length();
    int m = paramString2.length();
    int[][] arrayOfInt = (int[][])Array.newInstance(Integer.TYPE, new int[] { k + 1, m + 1 });
    int i = 0;
    while (i < m + 1)
    {
      arrayOfInt[0][i] = i;
      i += 1;
    }
    i = 0;
    while (i < k + 1)
    {
      arrayOfInt[i][0] = i;
      i += 1;
    }
    i = 1;
    while (i < k + 1)
    {
      int j = 1;
      if (j < m + 1)
      {
        if (paramString1.charAt(i - 1) == paramString2.charAt(j - 1)) {
          arrayOfInt[i][j] = arrayOfInt[(i - 1)][(j - 1)];
        }
        for (;;)
        {
          j += 1;
          break;
          arrayOfInt[i][j] = (Math.min(arrayOfInt[(i - 1)][(j - 1)], Math.min(arrayOfInt[(i - 1)][j], arrayOfInt[i][(j - 1)])) + 1);
        }
      }
      i += 1;
    }
    return arrayOfInt[k][m];
  }
  
  private static long a(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean1, boolean paramBoolean2)
  {
    long l2 = -9223372036854775808L;
    long l1 = l2;
    if (paramInt1 >= 0)
    {
      if (paramInt2 != paramInt3) {
        break label35;
      }
      if (!paramBoolean2) {
        break label31;
      }
      l1 = bbgl.w;
    }
    label31:
    label35:
    do
    {
      return l1;
      return bbgl.u;
      if (paramInt1 == 0)
      {
        if (paramBoolean2) {
          return bbgl.w;
        }
        return bbgl.v;
      }
      l1 = l2;
    } while (paramBoolean1);
    return bbgl.w;
  }
  
  private static long a(String paramString, bgla parambgla, boolean paramBoolean)
  {
    paramString = a(parambgla, paramString);
    return a(paramString[0], paramString[1], parambgla.jdField_a_of_type_JavaUtilList.size(), false, paramBoolean);
  }
  
  public static long a(String paramString1, String paramString2, long paramLong)
  {
    return a(paramString1, paramString2, paramLong, true, false, true);
  }
  
  public static long a(String paramString1, String paramString2, long paramLong, boolean paramBoolean)
  {
    return a(paramString1, paramString2, paramLong, paramBoolean, false, false);
  }
  
  public static long a(String paramString1, String paramString2, long paramLong, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    int i = 1;
    if ((TextUtils.isEmpty(paramString2)) || (TextUtils.isEmpty(paramString1))) {}
    long l;
    label123:
    do
    {
      for (;;)
      {
        return -9223372036854775808L;
        paramString1 = paramString1.toLowerCase();
        paramString2 = paramString2.toLowerCase();
        l = a(paramString1, paramString2, paramBoolean2, paramBoolean3);
        if (l != -9223372036854775808L) {
          return bbgl.r + l + paramLong;
        }
        if (paramBoolean1)
        {
          bgla localbgla = ChnToSpell.a(paramString2, 1);
          if (!paramString2.equals(localbgla.jdField_a_of_type_JavaLangString)) {}
          while (i != 0)
          {
            l = a(paramString1, localbgla, paramBoolean3);
            if (l == -9223372036854775808L) {
              break label123;
            }
            return bbgl.s + l + paramLong;
            i = 0;
          }
        }
      }
      l = a(paramString1, ChnToSpell.a(paramString2, 2), paramBoolean3);
    } while (l == -9223372036854775808L);
    return bbgl.s + l + paramLong;
  }
  
  public static long a(String paramString1, String paramString2, bgla parambgla1, bgla parambgla2, long paramLong)
  {
    if ((TextUtils.isEmpty(paramString2)) || (TextUtils.isEmpty(paramString1))) {}
    long l;
    label116:
    do
    {
      for (;;)
      {
        return -9223372036854775808L;
        paramString1 = paramString1.toLowerCase();
        paramString2 = paramString2.toLowerCase();
        l = a(paramString1, paramString2, false, false);
        if (l != -9223372036854775808L) {
          return bbgl.r + l + paramLong;
        }
        if ((parambgla1 != null) && (parambgla2 != null))
        {
          if (!paramString2.equals(parambgla1.jdField_a_of_type_JavaLangString)) {}
          for (int i = 1; i != 0; i = 0)
          {
            l = a(paramString1, parambgla1, false);
            if (l == -9223372036854775808L) {
              break label116;
            }
            return bbgl.s + l + paramLong;
          }
        }
      }
      l = a(paramString1, parambgla2, false);
    } while (l == -9223372036854775808L);
    return bbgl.s + l + paramLong;
  }
  
  private static long a(String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2)
  {
    return a(paramString2.indexOf(paramString1), paramString1.length(), paramString2.length(), paramBoolean1, paramBoolean2);
  }
  
  public static Drawable a(Bitmap paramBitmap)
  {
    Drawable localDrawable = BaseApplicationImpl.sApplication.getResources().getDrawable(2130840344);
    if ((localDrawable instanceof SkinnableBitmapDrawable)) {
      ((SkinnableBitmapDrawable)localDrawable).setGravity(81);
    }
    if ((localDrawable instanceof BitmapDrawable)) {
      ((BitmapDrawable)localDrawable).setGravity(81);
    }
    localDrawable.setBounds(0, 0, localDrawable.getIntrinsicWidth(), localDrawable.getIntrinsicHeight());
    return new LayerDrawable(new Drawable[] { new BitmapDrawable(paramBitmap), localDrawable });
  }
  
  public static Drawable a(aobu paramaobu, bbmv parambbmv)
  {
    return a(paramaobu, parambbmv.b(), parambbmv.c());
  }
  
  public static Drawable a(aobu paramaobu, String paramString, int paramInt)
  {
    if (paramInt == 103) {}
    for (int i = 1;; i = paramInt)
    {
      Bitmap localBitmap = paramaobu.a(i, paramString);
      if (localBitmap != null)
      {
        if (paramInt == 103) {
          return a(localBitmap);
        }
        return new BitmapDrawable(localBitmap);
      }
      if (!paramaobu.a()) {
        paramaobu.a(paramString, i, true, (byte)1);
      }
      if (paramInt == 1) {
        return bgmo.b();
      }
      if (paramInt == 101) {
        return bgmo.e();
      }
      if (paramInt == 4) {
        return bgmo.c();
      }
      if (paramInt == 11) {
        return new BitmapDrawable(bgmo.b());
      }
      if (paramInt == 102) {
        return BaseApplicationImpl.sApplication.getResources().getDrawable(2130844220);
      }
      if (paramInt == 106) {
        return BaseApplicationImpl.sApplication.getResources().getDrawable(2130847025);
      }
      if (paramInt == 105)
      {
        paramaobu = tyg.a((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime(), com.tencent.mobileqq.mqsafeedit.BaseApplication.getContext(), 1);
        if ((paramaobu != null) && (paramaobu.a() != null)) {
          return paramaobu.a();
        }
        return tyg.a(BaseApplicationImpl.sApplication, 1);
      }
      if (String.valueOf(9999L).equals(paramString)) {
        return BaseApplicationImpl.sApplication.getResources().getDrawable(2130840353);
      }
      if (String.valueOf(9994L).equals(paramString)) {
        return BaseApplicationImpl.sApplication.getResources().getDrawable(2130840360);
      }
      if (String.valueOf(9992L).equals(paramString)) {
        return BaseApplicationImpl.sApplication.getResources().getDrawable(2130840358);
      }
      if (anhk.aB.equals(paramString)) {
        return tue.a();
      }
      if (String.valueOf(9980L).equals(paramString)) {
        return BaseApplicationImpl.sApplication.getResources().getDrawable(2130840359);
      }
      if (String.valueOf(9973L).equals(paramString)) {
        return BaseApplicationImpl.sApplication.getResources().getDrawable(2130844732);
      }
      if (paramInt == 9889987) {
        return BaseApplicationImpl.sApplication.getResources().getDrawable(2130842503);
      }
      if (paramInt == 108)
      {
        paramaobu = BaseApplicationImpl.sApplication.getRuntime();
        if (paramaobu != null) {
          return ((aipe)paramaobu.getManager(138)).a();
        }
      }
      else
      {
        if (String.valueOf(anhk.D).equals(paramString)) {
          return BaseApplicationImpl.sApplication.getResources().getDrawable(2130840349);
        }
        if (paramInt == 110)
        {
          paramaobu = tyg.a((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime(), BaseApplicationImpl.sApplication, 2);
          if ((paramaobu != null) && (paramaobu.a() != null)) {
            return paramaobu.a().getConstantState().newDrawable();
          }
          return tyg.a(BaseApplicationImpl.sApplication, 2).getConstantState().newDrawable();
        }
        if (paramInt == 111)
        {
          paramaobu = tyg.a((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime(), BaseApplicationImpl.sApplication, 3);
          if ((paramaobu != null) && (paramaobu.a() != null)) {
            return paramaobu.a().getConstantState().newDrawable();
          }
          return tyg.a(BaseApplicationImpl.sApplication, 3).getConstantState().newDrawable();
        }
      }
      return bgmo.b();
    }
  }
  
  public static bbun a(String paramString1, bglb parambglb1, String paramString2, bglb parambglb2, long paramLong)
  {
    if ((TextUtils.isEmpty(paramString2)) || (TextUtils.isEmpty(paramString1)) || (paramString2.contains(paramString1))) {
      return null;
    }
    if ((parambglb1 == null) || (parambglb2 == null)) {
      return null;
    }
    if (bbuv.a(paramString1) == 0) {
      return null;
    }
    String str1 = paramString1.toLowerCase();
    paramString2 = paramString2.toLowerCase();
    if (paramString2.contains(str1)) {
      return null;
    }
    bbun localbbun = new bbun();
    String str2 = parambglb1.jdField_b_of_type_JavaLangString;
    String str4 = parambglb1.jdField_c_of_type_JavaLangString;
    parambglb1 = parambglb1.jdField_d_of_type_JavaLangString;
    String str3 = parambglb2.jdField_b_of_type_JavaLangString;
    String str5 = parambglb2.jdField_c_of_type_JavaLangString;
    paramString1 = parambglb2.jdField_d_of_type_JavaLangString;
    int i5 = bbuv.a(paramString2);
    int i1 = 0;
    int i4 = (int)(paramLong >> SearchConfigManager.contactSearchFieldBaseBit);
    VADHelper.a("voice_search_distance_cost");
    int k = a(str2, str3);
    VADHelper.b("voice_search_distance_cost");
    int i2 = 0;
    int m = 0;
    int j = 0;
    int i3 = 0;
    int n = 0;
    int i = 0;
    switch (i5)
    {
    default: 
      n = i1;
      m = k;
    case 0: 
      for (;;)
      {
        localbbun.jdField_d_of_type_Int = m;
        localbbun.jdField_a_of_type_Boolean = true;
        localbbun.jdField_a_of_type_JavaLangString = str1;
        localbbun.jdField_b_of_type_JavaLangString = str2;
        localbbun.jdField_c_of_type_JavaLangString = paramString2;
        localbbun.jdField_d_of_type_JavaLangString = str3;
        k = j;
        if (paramString2.length() < j) {
          k = 0;
        }
        localbbun.jdField_a_of_type_Int = k;
        j = i;
        if (paramString2.length() - localbbun.jdField_a_of_type_Int < i) {
          j = paramString2.length() - localbbun.jdField_a_of_type_Int;
        }
        localbbun.jdField_b_of_type_Int = j;
        localbbun.jdField_c_of_type_Int = ((100 - m << 8) + (n << 4) + i4);
        return localbbun;
        if (str3.contains(str2))
        {
          j = str3.indexOf(str2);
          i = str2.length();
          m = 0;
          n = i1;
        }
        else
        {
          m = k;
          n = i1;
          if (k < 1)
          {
            j = 0;
            i = paramString2.length();
            m = k;
            n = i1;
          }
        }
      }
    case 1: 
      if (str3.contains(str2))
      {
        i = str3.indexOf(str2);
        if (paramString2.length() <= i) {
          break label1021;
        }
        if (bbuv.a(paramString2.charAt(i)))
        {
          if (str1.length() + i > paramString2.length()) {
            break label1021;
          }
          m = ((Integer)parambglb2.jdField_b_of_type_JavaUtilList.get(i)).intValue();
          if (str1.length() + i + 1 < parambglb2.jdField_b_of_type_JavaUtilList.size())
          {
            j = ((Integer)parambglb2.jdField_b_of_type_JavaUtilList.get(str1.length() + i + 1)).intValue();
            label518:
            if (!str2.equalsIgnoreCase(str3.substring(m, j))) {
              break label1021;
            }
            m = str1.length();
            k = 0;
            j = i;
            i = m;
          }
        }
      }
      break;
    }
    for (;;)
    {
      m = k;
      n = i1;
      break;
      j = str3.length();
      break label518;
      m = str2.length();
      j = i;
      k = 0;
      i = m;
      continue;
      m = k;
      n = i1;
      if (!str5.contains(str4)) {
        break;
      }
      j = str5.indexOf(str4);
      if (j > -1)
      {
        m = str1.length();
        n = ((Integer)parambglb2.jdField_b_of_type_JavaUtilList.get(j)).intValue();
        if (j + m + 1 < parambglb2.jdField_b_of_type_JavaUtilList.size())
        {
          i = ((Integer)parambglb2.jdField_b_of_type_JavaUtilList.get(str1.length() + j + 1)).intValue();
          label700:
          parambglb2 = str3.substring(n, i);
          paramString1 = paramString1.substring(n, i);
          VADHelper.a("voice_search_distance_cost");
          n = a(str2, parambglb2);
          VADHelper.b("voice_search_distance_cost");
          i = k;
          if (n < k) {
            i = n;
          }
          n = b(parambglb1, paramString1);
          k = i;
          i = m;
          m = n;
        }
      }
      for (;;)
      {
        n = m;
        m = k;
        break;
        i = str3.length();
        break label700;
        if (str5.contains(str4))
        {
          i = str5.indexOf(str4);
          if (i > -1)
          {
            m = str1.length();
            n = ((Integer)parambglb2.jdField_b_of_type_JavaUtilList.get(i)).intValue();
            if (i + m + 1 < parambglb2.jdField_b_of_type_JavaUtilList.size())
            {
              j = ((Integer)parambglb2.jdField_b_of_type_JavaUtilList.get(str1.length() + i + 1)).intValue();
              label891:
              parambglb2 = str3.substring(n, j);
              paramString1 = paramString1.substring(n, j);
              VADHelper.a("voice_search_distance_cost");
              j = a(str2, parambglb2);
              VADHelper.b("voice_search_distance_cost");
              if (j >= k) {
                break label985;
              }
              k = j;
              j = i;
              i = m;
            }
          }
        }
        for (;;)
        {
          VADHelper.a("voice_search_sy_cost");
          n = b(parambglb1, paramString1);
          VADHelper.b("voice_search_sy_cost");
          m = k;
          break;
          j = str3.length();
          break label891;
          label985:
          j = i;
          i = m;
          continue;
          i = n;
          j = m;
        }
        m = 0;
        i = i3;
        j = i2;
      }
      label1021:
      i = 0;
      j = 0;
    }
  }
  
  public static bbur a(CharSequence paramCharSequence, String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.uniteSearch.SearchUtils", 2, "getHighLightMatchedMessage" + paramCharSequence + "|" + paramString);
    }
    if ((TextUtils.isEmpty(paramCharSequence)) || (TextUtils.isEmpty(paramString))) {
      return new bbur(paramCharSequence);
    }
    String str = paramCharSequence.toString().toLowerCase();
    int m = str.indexOf(paramString);
    int k = paramString.length();
    int j = k;
    int i = m;
    Object localObject = paramString;
    if (m < 0)
    {
      paramString = paramString.toLowerCase();
      m = str.indexOf(paramString);
      j = k;
      i = m;
      localObject = paramString;
      if (m < 0)
      {
        if (!paramBoolean) {
          break label293;
        }
        localObject = a(str, paramString, 1);
        if (localObject[0] < 0) {
          break label251;
        }
        i = localObject[0];
        j = localObject[1];
      }
    }
    for (localObject = paramString;; localObject = paramString)
    {
      paramCharSequence = new SpannableStringBuilder(paramCharSequence);
      for (k = i; (k >= 0) && (k < paramCharSequence.length()) && (k + j <= paramCharSequence.length()) && (j > 0); k = str.indexOf((String)localObject, k + j)) {
        paramCharSequence.setSpan(new ForegroundColorSpan(b()), k, k + j, 17);
      }
      label251:
      localObject = a(str, paramString, 2);
      if (localObject[0] < 0) {
        break;
      }
      i = localObject[0];
      j = localObject[1];
    }
    return new bbur(paramCharSequence);
    label293:
    return new bbur(paramCharSequence);
    return new bbur(paramCharSequence, i, j);
  }
  
  public static CharSequence a(TextView paramTextView, float paramFloat, int paramInt, CharSequence paramCharSequence, List<String> paramList, boolean paramBoolean1, boolean paramBoolean2)
  {
    return a(paramTextView, paramFloat, paramInt, paramCharSequence, paramList, paramBoolean1, paramBoolean2, false);
  }
  
  public static CharSequence a(TextView paramTextView, float paramFloat, int paramInt, CharSequence paramCharSequence, List<String> paramList, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.uniteSearch.SearchUtils", 2, "getHighLightMatchedMessageWithWidth" + paramCharSequence);
    }
    float f1 = a(paramTextView, anni.a(2131712443));
    f1 = paramInt * paramFloat - f1 * (paramInt - 1);
    if ((TextUtils.isEmpty(paramCharSequence)) || (paramTextView == null) || (f1 <= 0.0F)) {
      paramList = "";
    }
    int i;
    int j;
    label124:
    float f2;
    label368:
    do
    {
      do
      {
        do
        {
          return paramList;
          if ((paramList != null) && (paramList.size() != 0)) {
            break;
          }
          paramList = paramCharSequence;
        } while (!paramBoolean3);
        return a(paramTextView, f1, paramCharSequence);
        i = -1;
        j = 0;
        k = 0;
        int n;
        int m;
        if (k < paramList.size())
        {
          localObject = (String)paramList.get(k);
          if (TextUtils.isEmpty((CharSequence)localObject))
          {
            n = i;
            m = j;
          }
        }
        for (;;)
        {
          k += 1;
          j = m;
          i = n;
          break label124;
          if ((i >= 0) && (j > 1) && (((String)localObject).length() == 1))
          {
            paramList = paramCharSequence;
            if (a(paramTextView, paramCharSequence) <= f1) {
              break;
            }
            if ((!TextUtils.isEmpty(paramCharSequence)) && (i >= 0) && (i + j <= paramCharSequence.length())) {
              break label368;
            }
            paramList = paramCharSequence;
            if (!paramBoolean3) {
              break;
            }
            return a(paramTextView, f1, paramCharSequence);
          }
          bbur localbbur = a(paramCharSequence, (String)localObject, paramBoolean1);
          localObject = localbbur.jdField_a_of_type_JavaLangCharSequence;
          m = j;
          n = i;
          paramCharSequence = (CharSequence)localObject;
          if (i == -1)
          {
            m = j;
            n = i;
            paramCharSequence = (CharSequence)localObject;
            if (j == 0)
            {
              m = j;
              n = i;
              paramCharSequence = (CharSequence)localObject;
              if (localbbur.jdField_a_of_type_Int != -1)
              {
                m = j;
                n = i;
                paramCharSequence = (CharSequence)localObject;
                if (localbbur.jdField_b_of_type_Int > 0)
                {
                  n = localbbur.jdField_a_of_type_Int;
                  m = localbbur.jdField_b_of_type_Int;
                  paramCharSequence = (CharSequence)localObject;
                }
              }
            }
          }
        }
        localObject = paramCharSequence.subSequence(0, i + j);
        paramList = (List<String>)localObject;
        if (i + j < paramCharSequence.length()) {
          paramList = localObject + "…";
        }
        if (a(paramTextView, paramList) > f1) {
          break;
        }
        paramList = paramCharSequence;
      } while (!paramBoolean3);
      return a(paramTextView, f1, paramCharSequence);
      if ((paramInt == 1) || (!paramBoolean2)) {
        return a(paramTextView, f1, paramCharSequence, i, j);
      }
      f2 = paramFloat / 2.0F;
      paramList = paramCharSequence;
    } while (f2 > a(paramTextView, paramCharSequence));
    Object localObject = new StringBuilder();
    paramInt = 0;
    paramFloat = 0.0F;
    int k = paramInt;
    if (paramFloat < f2)
    {
      k = paramInt;
      if (paramInt < paramCharSequence.length())
      {
        ((StringBuilder)localObject).append(paramCharSequence.charAt(paramInt));
        paramFloat = a(paramTextView, ((StringBuilder)localObject).toString());
        if (paramFloat <= f2) {
          break label708;
        }
        ((StringBuilder)localObject).deleteCharAt(paramInt);
        k = paramInt - 1;
      }
    }
    label570:
    paramList = new SpannableStringBuilder(paramCharSequence.subSequence(0, k + 1));
    paramInt = k + 1;
    paramFloat = f1 - a(paramTextView, ((StringBuilder)localObject).toString());
    if (paramInt < paramCharSequence.length())
    {
      paramCharSequence = paramCharSequence.subSequence(paramInt, paramCharSequence.length());
      if (paramInt < i) {
        break label735;
      }
      paramTextView = a(paramTextView, paramFloat, paramCharSequence);
      if (paramInt >= i + j) {
        break label725;
      }
      paramInt = Math.min(paramTextView.length(), j - (paramInt - i));
      paramTextView = new SpannableStringBuilder(paramTextView);
      paramTextView.setSpan(new ForegroundColorSpan(b()), 0, paramInt, 17);
      paramList.append(paramTextView);
    }
    for (;;)
    {
      return paramList;
      label708:
      k = paramInt;
      if (paramFloat == f2) {
        break label570;
      }
      paramInt += 1;
      break;
      label725:
      paramList.append(paramTextView);
      continue;
      label735:
      paramList.append(a(paramTextView, paramFloat, paramCharSequence, i - paramInt, j));
    }
  }
  
  public static CharSequence a(TextView paramTextView, float paramFloat, int paramInt, String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    ArrayList localArrayList = new ArrayList();
    if (!TextUtils.isEmpty(paramString2)) {
      localArrayList.add(paramString2);
    }
    return a(paramTextView, paramFloat, paramInt, paramString1, localArrayList, paramBoolean1, paramBoolean2, paramBoolean3);
  }
  
  public static CharSequence a(TextView paramTextView, float paramFloat, CharSequence paramCharSequence)
  {
    if ((TextUtils.isEmpty(paramCharSequence)) || (paramTextView == null) || (paramFloat <= 0.0F)) {
      localObject = "";
    }
    do
    {
      return localObject;
      localObject = paramCharSequence;
    } while (paramFloat > a(paramTextView, paramCharSequence));
    Object localObject = new StringBuilder();
    float f = 0.0F;
    int i = 0;
    int j = i;
    if (f < paramFloat)
    {
      j = i;
      if (i < paramCharSequence.length())
      {
        ((StringBuilder)localObject).append(paramCharSequence.charAt(i));
        f = a(paramTextView, ((StringBuilder)localObject).toString());
        if (f <= paramFloat) {
          break label179;
        }
        ((StringBuilder)localObject).deleteCharAt(i);
        j = i - 1;
      }
    }
    label120:
    localObject = paramCharSequence.subSequence(0, j + 1);
    paramTextView = new SpannableStringBuilder((CharSequence)localObject);
    if (j < paramCharSequence.length() - 1)
    {
      paramTextView.delete(j, j + 1);
      paramTextView.append("…", 0, 1);
    }
    for (;;)
    {
      return paramTextView;
      label179:
      j = i;
      if (f == paramFloat) {
        break label120;
      }
      i += 1;
      break;
      paramTextView = new SpannableStringBuilder((CharSequence)localObject);
    }
  }
  
  public static CharSequence a(TextView paramTextView, float paramFloat, CharSequence paramCharSequence, int paramInt1, int paramInt2)
  {
    if ((TextUtils.isEmpty(paramCharSequence)) || (paramTextView == null) || (paramFloat <= 0.0F))
    {
      localObject = "";
      return localObject;
    }
    if ((paramInt1 < 0) || (paramInt1 + paramInt2 > paramCharSequence.length())) {
      return a(paramTextView, paramFloat, paramCharSequence);
    }
    Object localObject = paramCharSequence.subSequence(paramInt1, paramInt1 + paramInt2);
    float f1 = a(paramTextView, ((CharSequence)localObject).toString());
    paramInt2 = paramInt1 + paramInt2;
    localObject = new StringBuilder((CharSequence)localObject);
    float f2 = f1;
    int j = paramInt2;
    int k;
    int i;
    if (f1 < paramFloat)
    {
      k = 0;
      i = paramInt1;
      paramInt1 = paramInt2;
      f2 = f1;
      label119:
      paramInt2 = i;
      j = paramInt1;
      if (f2 < paramFloat) {
        if (i <= 0)
        {
          paramInt2 = i;
          j = paramInt1;
          if (paramInt1 >= paramCharSequence.length()) {}
        }
        else
        {
          paramInt2 = i;
          f1 = f2;
          if (k % 2 != 0) {
            break label347;
          }
          paramInt2 = i;
          f1 = f2;
          if (i <= 0) {
            break label347;
          }
          i -= 1;
          ((StringBuilder)localObject).insert(0, paramCharSequence.charAt(i));
          f2 = a(paramTextView, ((StringBuilder)localObject).toString());
          paramInt2 = i;
          f1 = f2;
          if (f2 <= paramFloat) {
            break label347;
          }
          paramInt2 = i + 1;
          ((StringBuilder)localObject).deleteCharAt(0);
          j = paramInt1;
        }
      }
    }
    for (;;)
    {
      label246:
      paramTextView = new SpannableStringBuilder(paramCharSequence.subSequence(paramInt2, j));
      if ((paramInt2 > 0) && (!TextUtils.isEmpty(paramTextView)))
      {
        paramTextView.delete(0, 1);
        paramTextView = new SpannableStringBuilder("…").append(paramTextView);
      }
      for (;;)
      {
        localObject = paramTextView;
        if (j >= paramCharSequence.length()) {
          break;
        }
        localObject = paramTextView;
        if (TextUtils.isEmpty(paramTextView)) {
          break;
        }
        paramTextView.delete(paramTextView.length() - 1, paramTextView.length());
        paramTextView.append("…");
        return paramTextView;
        label347:
        if ((k % 2 != 0) && (paramInt1 < paramCharSequence.length()))
        {
          i = paramInt1 + 1;
          ((StringBuilder)localObject).insert(((StringBuilder)localObject).length(), paramCharSequence.charAt(i - 1));
          f2 = a(paramTextView, ((StringBuilder)localObject).toString());
          paramInt1 = i;
          f1 = f2;
          if (f2 > paramFloat)
          {
            ((StringBuilder)localObject).deleteCharAt(((StringBuilder)localObject).length() - 1);
            j = i - 1;
            break label246;
          }
        }
        k += 1;
        i = paramInt2;
        f2 = f1;
        break label119;
        while ((f2 > paramFloat) && (j > paramInt1))
        {
          ((StringBuilder)localObject).deleteCharAt(j - paramInt1 - 1);
          j -= 1;
          f2 = a(paramTextView, ((StringBuilder)localObject).toString());
        }
      }
      paramInt2 = paramInt1;
    }
  }
  
  public static CharSequence a(TextView paramTextView, String paramString1, String paramString2, boolean paramBoolean)
  {
    int k = 0;
    String str = paramString1.toLowerCase();
    int n = str.indexOf(paramString2);
    int m = paramString2.length();
    int j = m;
    int i = n;
    Object localObject = paramString2;
    if (n < 0)
    {
      paramString2 = paramString2.toLowerCase();
      n = str.indexOf(paramString2);
      j = m;
      i = n;
      localObject = paramString2;
      if (n < 0)
      {
        if (!paramBoolean) {
          break label330;
        }
        localObject = a(str, paramString2, 1);
        if (localObject[0] < 0) {
          break label287;
        }
        i = localObject[0];
        j = localObject[1];
        localObject = paramString2;
      }
    }
    n = paramTextView.getWidth();
    paramString2 = paramTextView.getPaint();
    if ((paramString2.measureText(paramString1) > n) && (i + j > 10)) {
      while (i - k > 4)
      {
        paramTextView = paramString1.substring(i - k);
        m = k + 1;
        k = m;
        if (paramString2.measureText(paramTextView) + 70.0F > n)
        {
          paramString1 = "…" + paramTextView;
          paramTextView = "…" + paramTextView;
          i = m;
        }
      }
    }
    for (;;)
    {
      label227:
      paramString1 = new SpannableStringBuilder(paramString1);
      for (;;)
      {
        if (i >= 0)
        {
          paramString1.setSpan(new ForegroundColorSpan(b()), i, i + j, 17);
          i = paramTextView.indexOf((String)localObject, j + i);
          j = ((String)localObject).length();
          continue;
          label287:
          localObject = a(str, paramString2, 2);
          if (localObject[0] >= 0)
          {
            i = localObject[0];
            j = localObject[1];
            localObject = paramString2;
            break;
          }
          return new SpannableStringBuilder(paramString1);
          label330:
          return new SpannableStringBuilder(paramString1);
          paramTextView = str;
          break label227;
        }
      }
      return paramString1;
      i = k;
      paramTextView = str;
    }
  }
  
  public static CharSequence a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, int paramInt)
  {
    int n = 0;
    if (jdField_a_of_type_AndroidGraphicsPaint == null)
    {
      jdField_a_of_type_AndroidGraphicsPaint = ((TextView)LayoutInflater.from(paramQQAppInterface.getApp()).inflate(2131562839, null).findViewById(2131378776)).getPaint();
      if (jdField_c_of_type_Int == 0) {
        jdField_c_of_type_Int = paramQQAppInterface.getApp().getResources().getDimensionPixelOffset(2131298294);
      }
    }
    String str = paramString1.toLowerCase();
    int m = str.indexOf(paramString2);
    int k = paramString2.length();
    int j = k;
    int i = m;
    paramQQAppInterface = paramString2;
    if (m < 0)
    {
      paramString2 = paramString2.toLowerCase();
      m = str.indexOf(paramString2);
      j = k;
      i = m;
      paramQQAppInterface = paramString2;
      if (m < 0)
      {
        paramQQAppInterface = a(str, paramString2, 1);
        if (paramQQAppInterface[0] < 0) {
          break label416;
        }
        i = paramQQAppInterface[0];
        j = paramQQAppInterface[1];
        paramQQAppInterface = paramString2;
      }
    }
    float f1 = jdField_a_of_type_AndroidGraphicsPaint.measureText(paramString1);
    float f2 = jdField_a_of_type_AndroidGraphicsPaint.measureText(paramQQAppInterface);
    label294:
    if ((f1 >= jdField_c_of_type_Int) && (i > 0))
    {
      f1 = Math.min(f2 + jdField_a_of_type_AndroidGraphicsPaint.measureText("…"), f1);
      f2 = jdField_c_of_type_Int - f1;
      paramString2 = paramString1.substring(0, i);
      float[] arrayOfFloat = new float[paramString2.length()];
      jdField_a_of_type_AndroidGraphicsPaint.getTextWidths(paramString2, arrayOfFloat);
      k = arrayOfFloat.length - 1;
      f1 = 0.0F;
      m = 0;
      label249:
      if (k >= 0)
      {
        m += 1;
        f1 += arrayOfFloat[k];
        if ((f1 > f2) || (m >= paramInt))
        {
          if (f2 > 0.0F) {
            break label465;
          }
          paramInt = n;
          paramString1 = "…" + paramString1.substring(i - paramInt);
          paramString2 = "…" + str.substring(i - paramInt);
          i = paramInt + 1;
        }
      }
    }
    for (;;)
    {
      paramString1 = new SpannableStringBuilder(paramString1);
      paramInt = b();
      for (;;)
      {
        if (i >= 0)
        {
          paramString1.setSpan(new ForegroundColorSpan(paramInt), i, i + j, 17);
          i = paramString2.indexOf(paramQQAppInterface, j + i);
          j = paramQQAppInterface.length();
          continue;
          label416:
          paramQQAppInterface = a(str, paramString2, 2);
          if (paramQQAppInterface[0] >= 0)
          {
            i = paramQQAppInterface[0];
            j = paramQQAppInterface[1];
            paramQQAppInterface = paramString2;
            break;
          }
          return new SpannableStringBuilder(paramString1);
          k -= 1;
          break label249;
        }
      }
      return paramString1;
      label465:
      paramInt = m;
      break label294;
      paramString2 = str;
    }
  }
  
  public static CharSequence a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, int paramInt, bbun parambbun)
  {
    if (parambbun == null) {
      return new SpannableStringBuilder(paramString1);
    }
    if (jdField_a_of_type_AndroidGraphicsPaint == null)
    {
      jdField_a_of_type_AndroidGraphicsPaint = ((TextView)LayoutInflater.from(paramQQAppInterface.getApp()).inflate(2131562839, null).findViewById(2131378776)).getPaint();
      if (jdField_c_of_type_Int == 0) {
        jdField_c_of_type_Int = paramQQAppInterface.getApp().getResources().getDimensionPixelOffset(2131298294);
      }
    }
    paramQQAppInterface = paramString1.toLowerCase();
    int k = parambbun.jdField_a_of_type_Int;
    int m = parambbun.jdField_b_of_type_Int;
    if ((k < 0) || (k > paramString1.length()) || (!paramString1.equalsIgnoreCase(parambbun.jdField_c_of_type_JavaLangString)) || (parambbun.jdField_d_of_type_Int > 1)) {
      return new SpannableStringBuilder(paramString1);
    }
    float f1 = jdField_a_of_type_AndroidGraphicsPaint.measureText(paramString1);
    float f2 = jdField_a_of_type_AndroidGraphicsPaint.measureText(paramString2);
    int i;
    int j;
    if ((f1 >= jdField_c_of_type_Int) && (k >= 0))
    {
      f1 = Math.min(f2 + jdField_a_of_type_AndroidGraphicsPaint.measureText("…"), f1);
      f2 = jdField_c_of_type_Int - f1;
      paramString2 = paramString1.substring(0, k);
      parambbun = new float[paramString2.length()];
      jdField_a_of_type_AndroidGraphicsPaint.getTextWidths(paramString2, parambbun);
      i = parambbun.length - 1;
      f1 = 0.0F;
      j = 0;
      if (i >= 0)
      {
        j += 1;
        f1 += parambbun[i];
        if ((f1 > f2) || (j >= paramInt))
        {
          if (f2 <= 0.0F) {
            j = 0;
          }
          paramString1 = "…" + paramString1.substring(k - j);
          new StringBuilder().append("…").append(paramQQAppInterface.substring(k - j)).toString();
        }
      }
    }
    for (paramInt = j + 1;; paramInt = k)
    {
      paramQQAppInterface = new SpannableStringBuilder(paramString1);
      if (paramInt + m <= paramString1.length()) {
        paramQQAppInterface.setSpan(new ForegroundColorSpan(b()), paramInt, paramInt + m, 17);
      }
      return paramQQAppInterface;
      i -= 1;
      break;
    }
  }
  
  public static CharSequence a(CharSequence paramCharSequence)
  {
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    localSpannableStringBuilder.append("(").append(paramCharSequence).append(")");
    return localSpannableStringBuilder;
  }
  
  public static CharSequence a(CharSequence paramCharSequence, String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.uniteSearch.SearchUtils", 2, "getHighLightMatchedMessage" + paramCharSequence + "|" + paramString);
    }
    if ((TextUtils.isEmpty(paramCharSequence)) || (TextUtils.isEmpty(paramString))) {}
    String str;
    int j;
    int i;
    do
    {
      return paramCharSequence;
      str = paramCharSequence.toString().toLowerCase();
      int m = str.indexOf(paramString);
      int k = paramString.length();
      j = k;
      i = m;
      localObject = paramString;
      if (m >= 0) {
        break;
      }
      paramString = paramString.toLowerCase();
      m = str.indexOf(paramString);
      j = k;
      i = m;
      localObject = paramString;
      if (m >= 0) {
        break;
      }
    } while (!paramBoolean);
    Object localObject = a(str, paramString, 1);
    if (localObject[0] >= 0)
    {
      i = localObject[0];
      j = localObject[1];
    }
    for (localObject = paramString;; localObject = paramString)
    {
      paramCharSequence = new SpannableStringBuilder(paramCharSequence);
      while ((i >= 0) && (i < paramCharSequence.length()) && (i + j <= paramCharSequence.length()) && (j > 0))
      {
        paramCharSequence.setSpan(new ForegroundColorSpan(a()), i, i + j, 17);
        i = str.indexOf((String)localObject, i + j);
      }
      localObject = a(str, paramString, 2);
      if (localObject[0] < 0) {
        break;
      }
      i = localObject[0];
      j = localObject[1];
    }
    return paramCharSequence;
  }
  
  public static CharSequence a(String paramString, int paramInt, ArrayList<String> paramArrayList)
  {
    int j = 0;
    if (paramString == null) {
      return null;
    }
    if ((paramInt < 0) || (paramArrayList == null) || (paramArrayList.isEmpty())) {
      return new SpannableStringBuilder(paramString);
    }
    Object localObject1 = paramString.getBytes();
    if (paramInt >= localObject1.length) {
      return new SpannableStringBuilder(paramString);
    }
    Object localObject2;
    if (paramInt > 0)
    {
      localObject2 = new byte[paramInt];
      System.arraycopy(localObject1, 0, localObject2, 0, localObject2.length);
    }
    for (paramInt = new String((byte[])localObject2).length();; paramInt = 0)
    {
      localObject1 = paramArrayList.iterator();
      do
      {
        i = j;
        if (!((Iterator)localObject1).hasNext()) {
          break;
        }
        localObject2 = (String)((Iterator)localObject1).next();
      } while (paramString.toLowerCase().indexOf(((String)localObject2).toLowerCase()) != paramInt);
      int i = ((String)localObject2).length();
      if (paramInt <= 10)
      {
        localObject1 = paramString;
        if (paramInt > 6)
        {
          localObject1 = paramString;
          if (paramInt + i <= 10) {}
        }
      }
      else
      {
        localObject1 = "…" + paramString.substring(paramInt - 6);
      }
      paramString = new SpannableStringBuilder((CharSequence)localObject1);
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        localObject2 = (String)paramArrayList.next();
        paramInt = ((String)localObject1).toLowerCase().indexOf(((String)localObject2).toLowerCase());
        if (paramInt >= 0)
        {
          i = ((String)localObject2).length();
          while (paramInt >= 0)
          {
            paramString.setSpan(new ForegroundColorSpan(b()), paramInt, paramInt + i, 17);
            paramInt = ((String)localObject1).toLowerCase().indexOf(((String)localObject2).toLowerCase(), paramInt + i);
          }
        }
      }
      return paramString;
    }
  }
  
  public static CharSequence a(String paramString1, String paramString2)
  {
    return a(paramString1, paramString2, 10);
  }
  
  public static CharSequence a(String paramString1, String paramString2, int paramInt)
  {
    return a(paramString1, paramString2, paramInt, true);
  }
  
  public static CharSequence a(String paramString1, String paramString2, int paramInt, boolean paramBoolean)
  {
    String str = paramString1.toLowerCase();
    int m = str.indexOf(paramString2);
    int k = paramString2.length();
    int i = m;
    int j = k;
    Object localObject = paramString2;
    if (m < 0)
    {
      paramString2 = paramString2.toLowerCase();
      m = str.indexOf(paramString2);
      i = m;
      j = k;
      localObject = paramString2;
      if (m < 0)
      {
        if (!paramBoolean) {
          break label281;
        }
        localObject = a(str, paramString2, 1);
        if (localObject[0] < 0) {
          break label241;
        }
        i = localObject[0];
        j = localObject[1];
        localObject = paramString2;
      }
    }
    if ((i > paramInt) || ((i > 4) && (i + j > paramInt)))
    {
      paramString1 = "…" + paramString1.substring(i - 4);
      paramString2 = "…" + str.substring(i - 4);
      i = 5;
    }
    for (;;)
    {
      paramString1 = new SpannableStringBuilder(paramString1);
      for (;;)
      {
        if (i >= 0)
        {
          paramString1.setSpan(new ForegroundColorSpan(b()), i, i + j, 17);
          i = paramString2.indexOf((String)localObject, i + j);
          j = ((String)localObject).length();
          continue;
          label241:
          localObject = a(str, paramString2, 2);
          if (localObject[0] >= 0)
          {
            i = localObject[0];
            j = localObject[1];
            break;
          }
          return new SpannableStringBuilder(paramString1);
          label281:
          return new SpannableStringBuilder(paramString1);
        }
      }
      return paramString1;
      paramString2 = str;
    }
  }
  
  public static CharSequence a(String paramString1, String paramString2, boolean paramBoolean)
  {
    String str = paramString1.toLowerCase();
    paramString2 = paramString2.toLowerCase();
    int j = str.indexOf(paramString2);
    int i = paramString2.length();
    int[] arrayOfInt;
    int k;
    if (j < 0) {
      if (paramBoolean)
      {
        arrayOfInt = a(str, paramString2, 1);
        if (arrayOfInt[0] >= 0)
        {
          j = arrayOfInt[0];
          i = arrayOfInt[1];
          k = 0;
          label63:
          paramString1 = new SpannableStringBuilder(paramString1);
        }
      }
    }
    for (;;)
    {
      paramString1.setSpan(new ForegroundColorSpan(b()), j, j + i, 17);
      if (k != 0)
      {
        j = str.indexOf(paramString2, j + i);
        i = paramString2.length();
        if (j >= 0)
        {
          k = 1;
          continue;
          arrayOfInt = a(str, paramString2, 2);
          if (arrayOfInt[0] >= 0)
          {
            j = arrayOfInt[0];
            i = arrayOfInt[1];
            break;
          }
          return new SpannableStringBuilder(paramString1);
          return new SpannableStringBuilder(paramString1);
          k = 1;
          break label63;
        }
        return paramString1;
      }
      arrayOfInt = a(str.substring(j + i), paramString2, 1);
      if (arrayOfInt[0] >= 0)
      {
        j = j + arrayOfInt[0] + i;
        i = arrayOfInt[1];
      }
      else
      {
        arrayOfInt = a(str.substring(j + i), paramString2, 2);
        if (arrayOfInt[0] < 0) {
          return paramString1;
        }
        j = j + arrayOfInt[0] + i;
        i = arrayOfInt[1];
      }
    }
    return paramString1;
  }
  
  public static CharSequence a(String paramString, ArrayList<String> paramArrayList, int paramInt)
  {
    int i = 0;
    Object localObject = paramArrayList.iterator();
    int j = 0;
    String str1;
    String str2;
    int k;
    if (((Iterator)localObject).hasNext())
    {
      str1 = (String)((Iterator)localObject).next();
      str2 = paramString.toLowerCase();
      i = str2.indexOf(str1);
      j = str1.length();
      if (i >= 0) {
        k = j;
      }
    }
    for (;;)
    {
      if (i < 0)
      {
        return new SpannableStringBuilder(paramString);
        int m = str2.indexOf(str1.toLowerCase());
        i = m;
        k = j;
        if (m >= 0) {
          continue;
        }
        i = j;
        j = m;
        break;
      }
      if (i <= paramInt)
      {
        localObject = paramString;
        if (i > 6)
        {
          localObject = paramString;
          if (k + i <= paramInt) {}
        }
      }
      else
      {
        localObject = "…" + paramString.substring(i - 6);
      }
      paramString = new SpannableStringBuilder((CharSequence)localObject);
      paramArrayList = paramArrayList.iterator();
      do
      {
        if (!paramArrayList.hasNext()) {
          break;
        }
        str1 = (String)paramArrayList.next();
        str2 = ((String)localObject).toLowerCase();
        paramInt = str2.indexOf(str1);
        i = str1.length();
        if (paramInt >= 0) {
          break label263;
        }
        paramInt = str2.indexOf(str1.toLowerCase());
      } while (paramInt < 0);
      label263:
      for (;;)
      {
        paramString.setSpan(new ForegroundColorSpan(b()), paramInt, paramInt + i, 17);
        break;
        return paramString;
      }
      k = i;
      i = j;
    }
  }
  
  public static CharSequence a(JSONArray paramJSONArray)
  {
    int i = 0;
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    for (;;)
    {
      if ((paramJSONArray != null) && (i < paramJSONArray.length()))
      {
        Object localObject = paramJSONArray.optJSONObject(i);
        String str = ((JSONObject)localObject).optString("word");
        localObject = ((JSONObject)localObject).optString("color");
        SpannableString localSpannableString;
        if (!TextUtils.isEmpty(str)) {
          localSpannableString = new SpannableString(str);
        }
        try
        {
          if (!TextUtils.isEmpty((CharSequence)localObject)) {
            localSpannableString.setSpan(new ForegroundColorSpan(Color.parseColor((String)localObject)), 0, str.length(), 17);
          }
          localSpannableStringBuilder.append(localSpannableString);
          i += 1;
        }
        catch (IllegalArgumentException localIllegalArgumentException)
        {
          for (;;)
          {
            QLog.e("Q.uniteSearch.SearchUtils", 1, " color value is not valid. colorStr = " + (String)localObject);
          }
        }
      }
    }
    return localSpannableStringBuilder;
  }
  
  public static String a(int paramInt)
  {
    if (paramInt == 1) {
      return "1";
    }
    if (paramInt == 2) {
      return "2";
    }
    if (paramInt == 21) {
      return "3";
    }
    return "-1";
  }
  
  public static String a(CharSequence paramCharSequence)
  {
    if (paramCharSequence == null) {
      return null;
    }
    return Pattern.compile("[\\s|\\t|\\r|\\n]+").matcher(paramCharSequence).replaceAll("");
  }
  
  public static String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      paramString = "";
    }
    String str;
    do
    {
      return paramString;
      if (!paramString.startsWith("https://so.html5.qq.com/page/real/kd_result")) {
        return "";
      }
      paramString = bkgj.a(paramString);
      if ((paramString == null) || (!paramString.containsKey("q"))) {
        break;
      }
      str = (String)paramString.get("q");
      paramString = str;
    } while (!TextUtils.isEmpty(str));
    return "";
  }
  
  public static String a(String paramString, List<Long> paramList)
  {
    return a(paramString, a(paramList));
  }
  
  public static String a(String paramString, long[] paramArrayOfLong)
  {
    try
    {
      paramArrayOfLong = (String)jdField_a_of_type_JavaUtilHashMap.get(b(paramString, paramArrayOfLong));
      paramString = paramArrayOfLong;
      if (paramArrayOfLong == null) {
        paramString = "";
      }
      return paramString;
    }
    catch (RuntimeException paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.d("searchUtils getReportVersion", 2, paramString.toString());
      }
    }
    return "";
  }
  
  public static String a(List<Long> paramList)
  {
    return a(a(paramList), "::");
  }
  
  public static String a(long[] paramArrayOfLong)
  {
    return a(paramArrayOfLong, "::");
  }
  
  public static String a(long[] paramArrayOfLong, String paramString)
  {
    if (paramArrayOfLong == null) {
      throw new RuntimeException("generateMaskString. masks can not be null.");
    }
    StringBuilder localStringBuilder = new StringBuilder();
    int j = paramArrayOfLong.length;
    int i = 0;
    while (i < j)
    {
      localStringBuilder.append(paramArrayOfLong[i]).append(paramString);
      i += 1;
    }
    if (localStringBuilder.length() > 0) {
      return localStringBuilder.substring(0, localStringBuilder.length() - paramString.length());
    }
    return "";
  }
  
  public static String a(String... paramVarArgs)
  {
    if (paramVarArgs == null) {
      return null;
    }
    int i = 0;
    while (i < paramVarArgs.length)
    {
      if (!TextUtils.isEmpty(paramVarArgs[i])) {
        return paramVarArgs[i];
      }
      i += 1;
    }
    return null;
  }
  
  public static HashMap<String, String> a(HashMap<String, String> paramHashMap)
  {
    Object localObject = paramHashMap;
    if (paramHashMap == null) {
      localObject = new HashMap();
    }
    ((HashMap)localObject).put("input_type", String.valueOf(jdField_b_of_type_Long));
    ((HashMap)localObject).put("support_sougou_ime", String.valueOf(jdField_b_of_type_Boolean));
    return localObject;
  }
  
  public static List<Long> a(long[] paramArrayOfLong)
  {
    if (paramArrayOfLong == null) {
      throw new RuntimeException("convertIntArrayToLongList. array can not be null.");
    }
    ArrayList localArrayList = new ArrayList(paramArrayOfLong.length);
    int i = 0;
    while (i < paramArrayOfLong.length)
    {
      localArrayList.add(Long.valueOf(paramArrayOfLong[i]));
      i += 1;
    }
    return localArrayList;
  }
  
  public static void a()
  {
    int i = 70;
    int k = 1;
    int j;
    if (bbuo.a(70) != 0)
    {
      j = 1;
      if (bbuo.a(80) == 0) {
        break label71;
      }
      label23:
      if ((j == 0) || (k == 0)) {
        break label76;
      }
      i = 90;
    }
    for (;;)
    {
      if (i != 0) {
        bcst.b(null, "CliOper", "", "", "0X8005ECF", "0X8005ECF", i, 0, "", "", "", "");
      }
      return;
      j = 0;
      break;
      label71:
      k = 0;
      break label23;
      label76:
      if (j == 0) {
        if (k != 0) {
          i = 80;
        } else {
          i = 0;
        }
      }
    }
  }
  
  public static void a(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, String paramString1, String paramString2, int paramInt4)
  {
    int i = -1;
    HashMap localHashMap;
    switch (paramInt1)
    {
    default: 
      if (QLog.isColorLevel()) {
        QLog.d("searchUtils", 2, "moduleType:" + i + " moduleIndex:" + paramInt2 + " itemLinePosition:" + paramInt3 + " isGroupSearch:" + paramBoolean);
      }
      if (paramBoolean)
      {
        localHashMap = new HashMap();
        localHashMap.put("moduleType", Integer.toString(i));
        localHashMap.put("moduleIndex", Integer.toString(paramInt2));
        localHashMap.put("itemLinePosition", Integer.toString(paramInt3));
        localHashMap.put("toUin", paramString1);
        localHashMap.put("keyword", paramString2);
        if (paramInt4 == 12)
        {
          localHashMap.put("isFolder", "1");
          label190:
          bctj.a(com.tencent.mobileqq.mqsafeedit.BaseApplication.getContext()).a(null, "NetGroupSearchItemClick", true, 0L, 0L, localHashMap, null);
          paramString1 = "";
          switch (paramInt1)
          {
          }
        }
      }
      break;
    }
    for (;;)
    {
      bcst.b(null, "CliOper", "", "", paramString1, paramString1, 0, 0, String.valueOf(paramInt3), "", "", "");
      return;
      i = 70;
      break;
      i = 80;
      break;
      i = 90;
      break;
      localHashMap.put("isFolder", "0");
      break label190;
      localHashMap = new HashMap();
      localHashMap.put("moduleType", Integer.toString(i));
      localHashMap.put("itemLinePosition", Integer.toString(paramInt3));
      localHashMap.put("toUin", paramString1);
      localHashMap.put("keyword", paramString2);
      if (paramInt4 == 12) {
        localHashMap.put("isFolder", "1");
      }
      for (;;)
      {
        bctj.a(com.tencent.mobileqq.mqsafeedit.BaseApplication.getContext()).a(null, "NetModelSearchItemClick", true, 0L, 0L, localHashMap, null);
        break;
        localHashMap.put("isFolder", "0");
      }
      if (paramInt3 == 0)
      {
        paramString1 = "0X80061BA";
      }
      else
      {
        paramString1 = "0X80061B9";
        continue;
        if (paramInt3 == 0)
        {
          paramString1 = "0X80061BD";
        }
        else
        {
          paramString1 = "0X80061BC";
          continue;
          if (paramInt3 == 0)
          {
            paramString1 = "0X80061C0";
          }
          else
          {
            paramString1 = "0X80061BF";
            continue;
            if (paramInt3 == 0) {
              paramString1 = "0X80061C3";
            } else {
              paramString1 = "0X80061C2";
            }
          }
        }
      }
    }
  }
  
  public static void a(Context paramContext, int paramInt1, int paramInt2)
  {
    Object localObject = new HashMap();
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    switch (paramInt1)
    {
    case 3: 
    case 7: 
    case 11: 
    case 12: 
    case 13: 
    case 16: 
    case 19: 
    case 20: 
    case 21: 
    case 22: 
    case 23: 
    case 24: 
    case 25: 
    case 26: 
    case 29: 
    case 34: 
    case 39: 
    case 45: 
    case 46: 
    case 47: 
    case 48: 
    case 49: 
    case 50: 
    case 51: 
    case 52: 
    case 53: 
    case 54: 
    case 55: 
    case 56: 
    case 57: 
    case 58: 
    default: 
    case 2: 
    case 4: 
    case 5: 
    case 6: 
    case 8: 
    case 9: 
    case 10: 
    case 14: 
    case 15: 
    case 17: 
    case 18: 
    case 27: 
    case 28: 
    case 31: 
    case 32: 
    case 33: 
    case 35: 
    case 36: 
    case 37: 
    case 38: 
    case 30: 
    case 40: 
    case 41: 
    case 42: 
    case 43: 
    case 44: 
      do
      {
        do
        {
          return;
          ((HashMap)localObject).put("newtask", Boolean.valueOf(false));
          ((HashMap)localObject).put("fid", Integer.valueOf(paramInt1));
          Utils.gotoFunctionActivity(paramContext, (HashMap)localObject);
          return;
          Utils.gotoFaceToFaceSend(paramContext, (HashMap)localObject);
          return;
          bddx.a(localQQAppInterface, paramContext, String.valueOf(9992L));
          localQQAppInterface.a().c(String.valueOf(9992L), 7000);
          return;
          NewFriendActivity.a(paramContext, null, 0);
          return;
          MsgBoxListActivity.a(paramContext, 1001, String.valueOf(9999L));
          return;
          aaae.a(paramContext, 9005, null);
        } while (!QLog.isColorLevel());
        QLog.d("ContactSearchModelTool", 2, "enterServiceAccountFolderActivityFromSearch");
        return;
        localObject = new Intent(paramContext, ActivateFriendActivity.class);
        ((Intent)localObject).putExtra("af_key_from", 5);
        paramContext.startActivity((Intent)localObject);
      } while ((paramInt2 != 2) && (paramInt2 != 1));
      bcst.b(localQQAppInterface, "CliOper", "", "", "0X8006477", "0X8006477", paramInt2, 0, "", "", "", "");
      return;
    }
    ConfessMsgListFragment.a(paramContext, 2);
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2)
  {
    if ((paramContext == null) || (TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)))
    {
      if (QLog.isColorLevel()) {
        QLog.e("Q.uniteSearch.SearchUtils", 2, "argument is empty");
      }
      return;
    }
    if (paramString2.contains("searchbox=$SEARCHBOX$")) {}
    for (paramString2 = paramString2.replace("$SEARCHBOX$", "native");; paramString2 = bkgj.a(paramString2, "searchbox", "native"))
    {
      paramString1 = KDSearchResultFragment.a(paramContext, paramString1, bkgj.a(bkgj.a(paramString2, "q"), "q", paramString1));
      paramString2 = Aladdin.getConfig(313);
      if (paramString2 != null) {
        paramString1.putExtra("searchbox_style", paramString2.getIntegerFromString("SearchBox_SearchStyle", -1));
      }
      paramString2 = Aladdin.getConfig(337);
      if (paramString2 != null)
      {
        int i = paramString2.getIntegerFromString("search_ajax_switch", 0);
        paramString2 = paramString2.getString("url_prefix", "https://so.html5.qq.com/page/real").replaceAll("\\s*", "").split(",");
        paramString1.putExtra("search_ajax_switch", i);
        paramString1.putExtra("url_prefix", paramString2);
      }
      PublicFragmentActivityForTool.b(paramContext, paramString1, KDSearchResultFragment.class);
      ((Activity)paramContext).overridePendingTransition(0, 0);
      return;
    }
  }
  
  public static void a(Intent paramIntent, aufz paramaufz)
  {
    int j = 1006;
    boolean bool2 = false;
    String str1;
    String str2;
    int k;
    String str3;
    int i;
    int m;
    boolean bool1;
    if ((paramIntent != null) && (paramaufz != null))
    {
      str1 = paramIntent.getStringExtra("contactSearchResultUin");
      str2 = paramIntent.getStringExtra("contactSearchResultTroopUin");
      k = paramIntent.getIntExtra("contactSearchResultUinType", 0);
      str3 = paramIntent.getStringExtra("contactSearchResultName");
      i = aufw.a.intValue();
      m = paramIntent.getIntExtra("chooseFriendFrom", 0);
      if (k == 56938) {
        break label329;
      }
      bool1 = true;
      if ((!(paramaufz instanceof ForwardShareCardOption)) || (!paramIntent.hasExtra("contactSearchResultPhoneContactMobileCode")) || (k == 1006)) {
        break label395;
      }
      str1 = paramIntent.getStringExtra("contactSearchResultPhoneContactMobileCode");
    }
    for (;;)
    {
      switch (j)
      {
      }
      for (;;)
      {
        if (!bgsp.a(str1))
        {
          Bundle localBundle = new Bundle();
          localBundle.putString("uin", str1);
          localBundle.putInt("uintype", j);
          localBundle.putString("uinname", str3);
          localBundle.putString("troop_uin", str2);
          localBundle.putInt("chooseFriendFrom", m);
          localBundle.putBoolean("bindContact", bool1);
          bool1 = bool2;
          if (paramIntent != null) {
            bool1 = paramIntent.getBooleanExtra("choose_friend_needConfirm", false);
          }
          if (bool1)
          {
            str1 = paramIntent.getStringExtra("choose_friend_confirmTitle");
            paramIntent = paramIntent.getStringExtra("choose_friend_confirmContent");
            localBundle.putBoolean("choose_friend_needConfirm", bool1);
            localBundle.putString("choose_friend_confirmTitle", str1);
            localBundle.putString("choose_friend_confirmContent", paramIntent);
          }
          paramaufz.a(i, localBundle);
          paramaufz.g();
        }
        return;
        label329:
        bool1 = false;
        break;
        i = aufw.b.intValue();
        continue;
        i = aufw.c.intValue();
        continue;
        i = aufw.d.intValue();
        continue;
        i = aufw.h.intValue();
        continue;
        i = aufw.h.intValue();
        continue;
        i = aufw.i.intValue();
      }
      label395:
      j = k;
    }
  }
  
  public static void a(View paramView, bbmu parambbmu)
  {
    Activity localActivity = (Activity)paramView.getContext();
    Intent localIntent = new Intent();
    localIntent.putExtra("contactSearchResultUin", parambbmu.b());
    localIntent.putExtra("contactSearchResultUinType", parambbmu.d());
    localIntent.putExtra("contactSearchResultName", parambbmu.c());
    localIntent.putExtra("contactSearchResultNick", parambbmu.d());
    if (((parambbmu instanceof bblg)) || ((parambbmu instanceof bblt)) || ((parambbmu instanceof bblo))) {
      paramView = parambbmu.b();
    }
    for (;;)
    {
      String str;
      if ((parambbmu instanceof bblq))
      {
        localIntent.putExtra("contactSearchResultPhoneContactOriginBinder", ((bblq)parambbmu).a.originBinder);
        bblq localbblq = (bblq)parambbmu;
        str = localbblq.a.mobileCode;
        if (!TextUtils.isEmpty(str)) {
          break label282;
        }
        str = localbblq.a.mobileNo;
      }
      label282:
      for (;;)
      {
        localIntent.putExtra("contactSearchResultPhoneContactMobileCode", str);
        localIntent.putExtra("contactSearchResultPhoneContactNationCode", ((bblq)parambbmu).a.nationCode);
        localIntent.putExtra("contactSearchResultPhoneContactAbility", ((bblq)parambbmu).a.ability);
        localIntent.putExtra("contactSearchResultTroopUin", paramView);
        localActivity.setResult(-1, localIntent);
        localActivity.finish();
        localActivity.overridePendingTransition(0, 0);
        return;
        if ((parambbmu instanceof bbli))
        {
          paramView = ((bbli)parambbmu).e();
          break;
        }
        if ((parambbmu instanceof bblp))
        {
          paramView = ((bblp)parambbmu).jdField_a_of_type_JavaLangString;
          break;
        }
        if (!(parambbmu instanceof bblr)) {
          break label285;
        }
        paramView = ((bblr)parambbmu).e();
        break;
      }
      label285:
      paramView = "";
    }
  }
  
  public static void a(bbmu parambbmu, View paramView)
  {
    ThreadManager.postImmediately(new SearchUtils.2(paramView, parambbmu), null, true);
  }
  
  public static void a(AppInterface paramAppInterface, String paramString1, String paramString2, List<String> paramList, String paramString3, Rect paramRect, bbuq parambbuq)
  {
    ThreadManager.post(new SearchUtils.3(paramString1, paramString2, paramList, paramString3, paramRect, paramAppInterface, parambbuq), 8, null, true);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Activity paramActivity, String paramString, int paramInt)
  {
    if (paramQQAppInterface == null) {
      paramQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    }
    for (;;)
    {
      if ((paramQQAppInterface == null) || (paramActivity == null) || (TextUtils.isEmpty(paramString)))
      {
        if (QLog.isColorLevel()) {
          QLog.e("Q.uniteSearch.SearchUtils", 2, "jumpUtilargument is empty");
        }
        return;
      }
      if ((paramString.startsWith("http://")) || (paramString.startsWith("https://")))
      {
        if (d(paramString))
        {
          a(paramActivity, a(paramString), paramString);
          return;
        }
        paramQQAppInterface = new Intent(paramActivity, QQBrowserActivity.class);
        paramQQAppInterface.putExtra("url", paramString);
        paramActivity.startActivityForResult(paramQQAppInterface, paramInt);
        return;
      }
      if (paramString.startsWith("tel://"))
      {
        paramActivity.startActivityForResult(new Intent("android.intent.action.DIAL", Uri.parse("tel:" + paramString.substring(6))), paramInt);
        return;
      }
      if ((paramActivity instanceof BaseActivity))
      {
        paramQQAppInterface = bgng.a(paramQQAppInterface, paramActivity, paramString);
        if (paramQQAppInterface != null)
        {
          paramQQAppInterface.a();
          return;
        }
        paramActivity.startActivityForResult(new Intent(paramActivity, JumpActivity.class).setData(Uri.parse(paramString)), paramInt);
        return;
      }
      paramActivity.startActivityForResult(new Intent(paramActivity, JumpActivity.class).setData(Uri.parse(paramString)), paramInt);
      return;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, String paramString)
  {
    if (paramQQAppInterface == null) {
      paramQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    }
    for (;;)
    {
      if ((paramQQAppInterface == null) || (paramContext == null) || (TextUtils.isEmpty(paramString)))
      {
        if (QLog.isColorLevel()) {
          QLog.e("Q.uniteSearch.SearchUtils", 2, "jumpUtilargument is empty");
        }
        return;
      }
      if ((paramString.startsWith("http://")) || (paramString.startsWith("https://")))
      {
        if (d(paramString))
        {
          a(paramContext, a(paramString), paramString);
          return;
        }
        paramQQAppInterface = new Intent(paramContext, QQBrowserActivity.class);
        paramQQAppInterface.putExtra("url", paramString);
        paramContext.startActivity(paramQQAppInterface);
        return;
      }
      if (paramString.startsWith("tel://"))
      {
        paramContext.startActivity(new Intent("android.intent.action.DIAL", Uri.parse("tel:" + paramString.substring(6))));
        return;
      }
      if ((paramContext instanceof BaseActivity))
      {
        paramQQAppInterface = bgng.a(paramQQAppInterface, paramContext, paramString);
        if (paramQQAppInterface != null)
        {
          paramQQAppInterface.a();
          return;
        }
        paramContext.startActivity(new Intent(paramContext, JumpActivity.class).setData(Uri.parse(paramString)));
        return;
      }
      paramContext.startActivity(new Intent(paramContext, JumpActivity.class).setData(Uri.parse(paramString)));
      return;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3, int paramInt)
  {
    ThreadManager.postImmediately(new SearchUtils.1(paramString1, paramInt, paramString2, paramString3, paramQQAppInterface), null, false);
  }
  
  public static void a(String paramString)
  {
    String[] arrayOfString;
    if (!TextUtils.isEmpty(paramString))
    {
      arrayOfString = paramString.split(" ");
      if (arrayOfString == null) {}
    }
    for (int i = arrayOfString.length;; i = 0)
    {
      if (i > 1)
      {
        if (QLog.isColorLevel()) {
          QLog.d("searchUtils", 2, "discuss -searchKey:" + paramString + " count:" + i);
        }
        bcst.b(null, "CliOper", "", "", "0X8005E0F", "0X8005E0F", 0, 0, "" + i, "", "", "");
      }
      return;
    }
  }
  
  public static void a(String paramString, int paramInt1, int paramInt2, int paramInt3, View paramView)
  {
    boolean bool = a(paramView.getContext());
    paramInt3 += 1;
    if (QLog.isColorLevel()) {
      QLog.d("searchUtils", 2, "moduleType:" + paramInt1 + " itemLinePosition:" + paramInt3);
    }
    if (bool)
    {
      int i = bbuo.a(paramInt1);
      if (QLog.isColorLevel()) {
        QLog.d("searchUtils", 2, "moduleIndex:" + i + " searchKey:" + paramString);
      }
      bcst.b(null, "CliOper", "", "", "0X8005E10", "0X8005E10", paramInt1, 0, String.valueOf(i), String.valueOf(paramInt3), String.valueOf(paramInt2), "");
      paramView = new HashMap();
      paramView.put("moduleType", Integer.toString(paramInt1));
      paramView.put("moduleIndex", Integer.toString(i));
      paramView.put("moduleChildType", Integer.toString(paramInt2));
      paramView.put("itemLinePosition", Integer.toString(paramInt3));
      paramView.put("keyword", paramString);
      if (UniteSearchActivity.jdField_b_of_type_Long != -1L) {
        paramView.put("stay_time", String.valueOf(System.currentTimeMillis() - UniteSearchActivity.jdField_b_of_type_Long));
      }
      bctj.a(com.tencent.mobileqq.mqsafeedit.BaseApplication.getContext()).a(null, "GroupSearchItemClick", true, 0L, 0L, a(paramView), null);
      return;
    }
    bcst.b(null, "CliOper", "", "", "0X8005E11", "0X8005E11", paramInt1, 0, "", String.valueOf(paramInt3), String.valueOf(paramInt2), "");
    paramView = new HashMap();
    paramView.put("moduleType", Integer.toString(paramInt1));
    paramView.put("moduleChildType", Integer.toString(paramInt2));
    paramView.put("itemLinePosition", Integer.toString(paramInt3));
    paramView.put("keyword", paramString);
    bctj.a(com.tencent.mobileqq.mqsafeedit.BaseApplication.getContext()).a(null, "ModelSearchItemClick", true, 0L, 0L, paramView, null);
  }
  
  public static void a(String paramString, int paramInt1, int paramInt2, View paramView)
  {
    boolean bool = a(paramView.getContext());
    int i = ((Integer)paramView.getTag(2131380930)).intValue() + 1;
    if (QLog.isColorLevel()) {
      QLog.d("searchUtils", 2, "moduleType:" + paramInt1 + " itemLinePosition:" + i);
    }
    if (bool)
    {
      int j = bbuo.a(paramInt1);
      if (QLog.isColorLevel()) {
        QLog.d("searchUtils", 2, "moduleIndex:" + j + " searchKey:" + paramString);
      }
      bcst.b(null, "CliOper", "", "", "0X8005E10", "0X8005E10", paramInt1, 0, String.valueOf(j), String.valueOf(i), String.valueOf(paramInt2), "");
      paramView = new HashMap();
      paramView.put("moduleType", Integer.toString(paramInt1));
      paramView.put("moduleIndex", Integer.toString(j));
      paramView.put("moduleChildType", Integer.toString(paramInt2));
      paramView.put("itemLinePosition", Integer.toString(i));
      paramView.put("keyword", paramString);
      if (UniteSearchActivity.jdField_b_of_type_Long != -1L) {
        paramView.put("stay_time", String.valueOf(System.currentTimeMillis() - UniteSearchActivity.jdField_b_of_type_Long));
      }
      bctj.a(com.tencent.mobileqq.mqsafeedit.BaseApplication.getContext()).a(null, "GroupSearchItemClick", true, 0L, 0L, a(paramView), null);
      return;
    }
    bcst.b(null, "CliOper", "", "", "0X8005E11", "0X8005E11", paramInt1, 0, "", String.valueOf(i), String.valueOf(paramInt2), "");
    paramView = new HashMap();
    paramView.put("moduleType", Integer.toString(paramInt1));
    paramView.put("moduleChildType", Integer.toString(paramInt2));
    paramView.put("itemLinePosition", Integer.toString(i));
    paramView.put("keyword", paramString);
    bctj.a(com.tencent.mobileqq.mqsafeedit.BaseApplication.getContext()).a(null, "ModelSearchItemClick", true, 0L, 0L, paramView, null);
  }
  
  public static void a(String paramString1, int paramInt1, int paramInt2, View paramView, String paramString2, boolean paramBoolean, int paramInt3)
  {
    boolean bool = a(paramView.getContext());
    int i = ((Integer)paramView.getTag(2131380930)).intValue() + 1;
    if (QLog.isColorLevel()) {
      QLog.d("searchUtils", 2, "moduleType:" + paramInt1 + " itemLinePosition:" + i);
    }
    if (bool)
    {
      int j = bbuo.a(paramInt1);
      if (QLog.isColorLevel()) {
        QLog.d("searchUtils", 2, "moduleIndex:" + j + " searchKey:" + paramString1);
      }
      bcst.b(null, "CliOper", "", "", "0X8005E10", "0X8005E10", paramInt1, 0, String.valueOf(j), String.valueOf(i), String.valueOf(paramInt2), "");
      paramView = new HashMap();
      paramView.put("moduleType", Integer.toString(paramInt1));
      paramView.put("moduleIndex", Integer.toString(j));
      paramView.put("moduleChildType", Integer.toString(paramInt2));
      paramView.put("itemLinePosition", Integer.toString(i));
      paramView.put("toUin", paramString2);
      paramView.put("keyword", paramString1);
      if (paramBoolean)
      {
        paramString1 = "1";
        paramView.put("sFrom", paramString1);
        if (paramInt3 != 12) {
          break label330;
        }
        paramView.put("isFolder", "1");
      }
      for (;;)
      {
        if (UniteSearchActivity.jdField_b_of_type_Long != -1L) {
          paramView.put("stay_time", String.valueOf(System.currentTimeMillis() - UniteSearchActivity.jdField_b_of_type_Long));
        }
        bctj.a(com.tencent.mobileqq.mqsafeedit.BaseApplication.getContext()).a(null, "GroupSearchItemClick", true, 0L, 0L, a(paramView), null);
        return;
        paramString1 = "0";
        break;
        label330:
        paramView.put("isFolder", "0");
      }
    }
    bcst.b(null, "CliOper", "", "", "0X8005E11", "0X8005E11", paramInt1, 0, "", String.valueOf(i), String.valueOf(paramInt2), "");
    paramView = new HashMap();
    paramView.put("moduleType", Integer.toString(paramInt1));
    paramView.put("moduleChildType", Integer.toString(paramInt2));
    paramView.put("itemLinePosition", Integer.toString(i));
    paramView.put("keyword", paramString1);
    paramView.put("toUin", paramString2);
    if (paramBoolean)
    {
      paramString1 = "1";
      paramView.put("sFrom", paramString1);
      if (paramInt3 != 12) {
        break label502;
      }
      paramView.put("isFolder", "1");
    }
    for (;;)
    {
      bctj.a(com.tencent.mobileqq.mqsafeedit.BaseApplication.getContext()).a(null, "ModelSearchItemClick", true, 0L, 0L, paramView, null);
      return;
      paramString1 = "0";
      break;
      label502:
      paramView.put("isFolder", "0");
    }
  }
  
  public static void a(String paramString, int paramInt, View paramView, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d("searchUtils", 2, "moduleType:40 -3 searchKey:" + "");
      }
      bcst.b(null, "CliOper", "", "", "0X8005E12", "0X8005E12", 40, 0, "3", "", "", "");
    }
    do
    {
      return;
      if (!a(paramView.getContext())) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.d("searchUtils", 2, "moduleType:" + paramInt + " -1 searchKey:" + "");
      }
      bcst.b(null, "CliOper", "", "", "0X8005E12", "0X8005E12", paramInt, 0, "1", "", "", "");
    } while (!UniteSearchActivity.jdField_b_of_type_Boolean);
    if (UniteSearchActivity.e == -1)
    {
      bcst.b(null, "CliOper", "", "", "0X8007E2E", "0X8007E2E", 2, 0, "", "" + UniteSearchActivity.jdField_b_of_type_Int, UniteSearchActivity.jdField_a_of_type_JavaLangString, "");
      return;
    }
    bcst.b(null, "CliOper", "", "", "0X8007E2E", "0X8007E2E", 1, 0, "", "" + UniteSearchActivity.jdField_b_of_type_Int, UniteSearchActivity.jdField_a_of_type_JavaLangString, "");
    return;
    if (QLog.isColorLevel()) {
      QLog.d("searchUtils", 2, "moduleType:" + paramInt + " -2 searchKey:" + "");
    }
    bcst.b(null, "CliOper", "", "", "0X8005E12", "0X8005E12", paramInt, 0, "2", "", "", "");
  }
  
  public static void a(String paramString1, String paramString2, int paramInt1, int paramInt2, String... paramVarArgs)
  {
    new bcsy(null).a("dc00899").b("Grp_all_search").c(paramString1).d(paramString2).a(paramInt1).b(paramInt2).a(paramVarArgs).a();
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, String... paramVarArgs)
  {
    new bcsy(null).a("dc00899").b(paramString1).c(paramString2).d(paramString3).a(paramInt1).b(paramInt2).a(paramVarArgs).a();
  }
  
  public static void a(String paramString1, String paramString2, String... paramVarArgs)
  {
    a(paramString1, paramString2, 0, 0, paramVarArgs);
  }
  
  public static void a(String paramString1, long[] paramArrayOfLong, String paramString2)
  {
    try
    {
      jdField_a_of_type_JavaUtilHashMap.put(b(paramString1, paramArrayOfLong), paramString2);
      return;
    }
    catch (RuntimeException paramString1)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("searchUtils updateReportVersion", 2, paramString1.toString());
    }
  }
  
  public static boolean a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return false;
    }
    return true;
  }
  
  public static boolean a(long paramLong)
  {
    if (paramLong <= 0L) {}
    while ((paramLong == 1073745984L) || (paramLong == 2049L) || (paramLong == 1004L) || (paramLong == 64L) || (paramLong == 4097L)) {
      return false;
    }
    return true;
  }
  
  private static boolean a(Context paramContext)
  {
    return ((Activity)paramContext instanceof UniteSearchActivity);
  }
  
  public static boolean a(bbmy parambbmy)
  {
    return ((parambbmy instanceof bblg)) || ((parambbmy instanceof bblk)) || ((parambbmy instanceof bblo)) || ((parambbmy instanceof bblt));
  }
  
  public static boolean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    paramString = paramString.trim();
    int i = 0;
    for (;;)
    {
      if (i >= paramString.length()) {
        break label51;
      }
      if ((paramString.charAt(i) < '0') && (paramString.charAt(i) > '9')) {
        break;
      }
      i += 1;
    }
    label51:
    return true;
  }
  
  public static int[] a(bgla parambgla, String paramString)
  {
    int[] arrayOfInt = new int[2];
    int[] tmp7_5 = arrayOfInt;
    tmp7_5[0] = -1;
    int[] tmp11_7 = tmp7_5;
    tmp11_7[1] = 0;
    tmp11_7;
    int j = parambgla.jdField_a_of_type_JavaLangString.indexOf(paramString);
    if (j < 0) {
      return arrayOfInt;
    }
    int i = 0;
    int k;
    if (i < parambgla.jdField_a_of_type_JavaUtilList.size())
    {
      if (j == ((Integer)parambgla.jdField_a_of_type_JavaUtilList.get(i)).intValue())
      {
        arrayOfInt[0] = i;
        k = i + 1;
        for (;;)
        {
          if ((k >= parambgla.jdField_a_of_type_JavaUtilList.size()) || (j + paramString.length() <= ((Integer)parambgla.jdField_a_of_type_JavaUtilList.get(k)).intValue()))
          {
            arrayOfInt[1] = (k - i);
            return arrayOfInt;
          }
          k += 1;
        }
      }
      if (j >= ((Integer)parambgla.jdField_a_of_type_JavaUtilList.get(i)).intValue()) {
        break label214;
      }
      k = parambgla.jdField_a_of_type_JavaLangString.indexOf(paramString, ((Integer)parambgla.jdField_a_of_type_JavaUtilList.get(i)).intValue());
      if (k < 0) {
        return arrayOfInt;
      }
      j = i - 1;
    }
    for (i = k;; i = k)
    {
      k = i;
      i = j + 1;
      j = k;
      break;
      return arrayOfInt;
      label214:
      k = j;
      j = i;
    }
  }
  
  public static int[] a(String paramString1, String paramString2, int paramInt)
  {
    return a(ChnToSpell.a(paramString1, paramInt), paramString2);
  }
  
  public static int[] a(String paramString1, String paramString2, boolean paramBoolean)
  {
    int[] arrayOfInt = new int[3];
    arrayOfInt[0] = -1;
    arrayOfInt[1] = 0;
    arrayOfInt[2] = 0;
    if ((TextUtils.isEmpty(paramString2)) || (TextUtils.isEmpty(paramString1))) {}
    label154:
    do
    {
      for (;;)
      {
        return arrayOfInt;
        paramString1 = paramString1.toLowerCase();
        paramString2 = paramString2.toLowerCase();
        arrayOfInt[0] = paramString2.indexOf(paramString1);
        if (arrayOfInt[0] != -1)
        {
          arrayOfInt[1] = paramString1.length();
          arrayOfInt[2] = 3;
          return arrayOfInt;
        }
        if (paramBoolean)
        {
          Object localObject = ChnToSpell.a(paramString2, 1);
          if (!paramString2.equals(((bgla)localObject).jdField_a_of_type_JavaLangString)) {}
          for (int i = 1; i != 0; i = 0)
          {
            localObject = a((bgla)localObject, paramString1);
            arrayOfInt[0] = localObject[0];
            arrayOfInt[1] = localObject[1];
            if (arrayOfInt[0] == -1) {
              break label154;
            }
            arrayOfInt[2] = 2;
            return arrayOfInt;
          }
        }
      }
      paramString1 = a(ChnToSpell.a(paramString2, 2), paramString1);
      arrayOfInt[0] = paramString1[0];
      arrayOfInt[1] = paramString1[1];
    } while (arrayOfInt[0] == -1);
    arrayOfInt[2] = 1;
    return arrayOfInt;
  }
  
  public static long[] a(List<Long> paramList)
  {
    if (paramList == null) {
      throw new RuntimeException("convertLongList2longArray. list can not be null.");
    }
    long[] arrayOfLong = new long[paramList.size()];
    int i = 0;
    while (i < paramList.size())
    {
      arrayOfLong[i] = ((Long)paramList.get(i)).longValue();
      i += 1;
    }
    return arrayOfLong;
  }
  
  public static int b()
  {
    int i = BaseApplicationImpl.sApplication.getResources().getColor(2131166908);
    if (ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, "")) {
      i = BaseApplicationImpl.sApplication.getResources().getColor(2131166910);
    }
    return i;
  }
  
  public static int b(String paramString1, String paramString2)
  {
    int i = 0;
    paramString1 = paramString1.split("#");
    bbuv.a();
    paramString2 = paramString2.split("#");
    bbuv.a();
    if (paramString1.length == paramString2.length)
    {
      float f3 = 14.0F / (paramString1.length * 2);
      float f2 = 0.0F;
      i = 0;
      while (i < paramString1.length)
      {
        float f1 = f2;
        if (!paramString1[i].equalsIgnoreCase(paramString2[i]))
        {
          String[] arrayOfString1 = paramString1[i].split("-");
          String[] arrayOfString2 = paramString2[i].split("-");
          f1 = f2;
          if (arrayOfString1 != null)
          {
            f1 = f2;
            if (arrayOfString1.length == arrayOfString2.length)
            {
              f1 = f2;
              if (bbuv.a(arrayOfString1[0], arrayOfString2[0]))
              {
                f1 = f2;
                if (arrayOfString1.length > 1)
                {
                  f2 += f3;
                  f1 = f2;
                  if (bbuv.b(arrayOfString1[1], arrayOfString2[1])) {
                    f1 = f2 + f3;
                  }
                }
              }
            }
          }
        }
        i += 1;
        f2 = f1;
      }
      i = (int)f2;
    }
    return i;
  }
  
  public static long b(String paramString1, String paramString2, long paramLong)
  {
    return a(paramString1, paramString2, paramLong, true);
  }
  
  public static CharSequence b(String paramString1, String paramString2, int paramInt, boolean paramBoolean)
  {
    String str = paramString1.toLowerCase();
    Object localObject = paramString2.toLowerCase();
    int k = str.indexOf((String)localObject);
    int i = ((String)localObject).length();
    int j = k;
    if (k < 0)
    {
      if (!paramBoolean) {
        break label268;
      }
      int[] arrayOfInt = a(str, (String)localObject, 1);
      if (arrayOfInt[0] >= 0)
      {
        i = arrayOfInt[0];
        j = arrayOfInt[1];
        k = i;
        i = j;
        j = k;
      }
    }
    else
    {
      if ((j <= paramInt) && ((j <= 6) || (j + i <= paramInt))) {
        break label279;
      }
      paramString1 = "…" + paramString1.substring(j - 6);
      str = "…" + str.substring(j - 6);
      j = 7;
    }
    label268:
    label279:
    for (;;)
    {
      paramString1 = new SpannableStringBuilder(paramString1);
      for (;;)
      {
        if (j >= 0)
        {
          paramString1.setSpan(new ForegroundColorSpan(b()), j, j + i, 17);
          j = str.indexOf(paramString2, j + i);
          i = paramString2.length();
          continue;
          localObject = a(str, (String)localObject, 2);
          if (localObject[0] >= 0)
          {
            i = localObject[0];
            j = localObject[1];
            break;
          }
          return new SpannableStringBuilder(paramString1);
          return new SpannableStringBuilder(paramString1);
        }
      }
      return paramString1;
    }
  }
  
  public static String b(String paramString)
  {
    try
    {
      String str = URLEncoder.encode(paramString, "UTF-8").replaceAll("\\+", "%20").replaceAll("\\%21", "!").replaceAll("\\%27", "'").replaceAll("\\%28", "(").replaceAll("\\%29", ")").replaceAll("\\%7E", "~");
      return str;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException) {}
    return paramString;
  }
  
  private static String b(String paramString, long[] paramArrayOfLong)
  {
    String str = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    return str + "#" + paramString + "#" + b(paramArrayOfLong);
  }
  
  private static String b(long[] paramArrayOfLong)
  {
    return a(paramArrayOfLong, ":");
  }
  
  public static void b(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3, int paramInt)
  {
    ((bbop)paramQQAppInterface.getManager(318)).a(paramString1, paramString2, paramString3, paramInt);
  }
  
  public static boolean b(int paramInt)
  {
    return (paramInt == 1) || (paramInt == 2) || (paramInt == 3);
  }
  
  public static boolean b(long paramLong)
  {
    boolean bool2 = false;
    long[] arrayOfLong = anxu.c;
    int j = arrayOfLong.length;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < j)
      {
        if (arrayOfLong[i] == paramLong) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  public static boolean b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    paramString = paramString.toLowerCase().trim();
    int i = 0;
    for (;;)
    {
      if (i >= paramString.length()) {
        break label54;
      }
      if ((paramString.charAt(i) < 'a') && (paramString.charAt(i) > 'z')) {
        break;
      }
      i += 1;
    }
    label54:
    return true;
  }
  
  public static CharSequence c(String paramString1, String paramString2, int paramInt, boolean paramBoolean)
  {
    Object localObject2 = paramString1.toLowerCase();
    Object localObject1 = paramString2.toLowerCase();
    int k = ((String)localObject2).indexOf((String)localObject1);
    int i = ((String)localObject1).length();
    int j;
    if (k < 0) {
      if (paramBoolean)
      {
        int[] arrayOfInt = a((String)localObject2, (String)localObject1, 1);
        if (arrayOfInt[0] >= 0)
        {
          i = arrayOfInt[0];
          j = arrayOfInt[1];
          k = i;
          i = j;
        }
      }
    }
    for (;;)
    {
      if ((k > paramInt) || ((k > 6) && (k + i > paramInt)))
      {
        localObject1 = "(…" + paramString1.substring(k - 6) + ")";
        paramString1 = "(…" + ((String)localObject2).substring(k - 6) + ")";
      }
      for (paramInt = 8;; paramInt = k + 1)
      {
        localObject2 = new SpannableStringBuilder((CharSequence)localObject1);
        ((SpannableStringBuilder)localObject2).setSpan(new ForegroundColorSpan(BaseApplicationImpl.sApplication.getResources().getColor(2131167061)), 0, ((String)localObject1).length(), 17);
        while (paramInt >= 0)
        {
          ((SpannableStringBuilder)localObject2).setSpan(new ForegroundColorSpan(b()), paramInt, paramInt + i, 17);
          paramInt = paramString1.indexOf(paramString2, paramInt + i);
          i = paramString2.length();
        }
        localObject1 = a((String)localObject2, (String)localObject1, 2);
        if (localObject1[0] >= 0)
        {
          i = localObject1[0];
          j = localObject1[1];
          break;
        }
        return new SpannableStringBuilder(paramString1);
        return new SpannableStringBuilder(paramString1);
        localObject1 = "(" + paramString1 + ")";
        paramString1 = "(" + (String)localObject2 + ")";
      }
      return localObject2;
    }
  }
  
  public static boolean c(int paramInt)
  {
    return (paramInt == 1) || (paramInt == 2) || (paramInt == 21);
  }
  
  public static boolean c(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return false;
      paramString = paramString.split(" ");
    } while ((paramString == null) || (paramString.length <= 1));
    return true;
  }
  
  public static boolean d(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    if (!paramString.startsWith("https://so.html5.qq.com/page/real/kd_result")) {
      return false;
    }
    paramString = bkgj.a(paramString);
    return (paramString != null) && (paramString.containsKey("q")) && (!TextUtils.isEmpty((String)paramString.get("q")));
  }
  
  public static boolean e(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return false;
      paramString = paramString.trim();
    } while (!Pattern.compile("^#[0-9a-fA-F]{3}|^#[0-9a-fA-F]{6}$|^#[0-9a-fA-F]{8}$").matcher(paramString).matches());
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbup
 * JD-Core Version:    0.7.0.1
 */