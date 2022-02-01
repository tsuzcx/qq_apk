import android.content.Context;
import android.net.Uri;
import android.net.Uri.Builder;
import android.view.View;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class aqoq
{
  private static final List<String> a = new LinkedList();
  private static final List<String> b = new ArrayList();
  private static final List<String> c = new ArrayList();
  
  static
  {
    a.add("buluo.qq.com");
    a.add("null");
    a.add("unregistered service sub type");
    a.add("captcha.qq.com");
    a.add("oauth.youzan.com");
    if (BaseApplicationImpl.getApplication() != null)
    {
      a.add("https://zb.vip.qq.com/sonic/funcall?_wv=16778243&asyncMode=3&_sonic_id=42898&_preload=1&from=call_process&_wwv=4");
      c.add("https://zb.vip.qq.com/sonic/funcall?_wv=16778243&asyncMode=3&_sonic_id=42898&_preload=1&from=call_process&_wwv=4");
    }
  }
  
  public static int a(int paramInt)
  {
    return 0x7FFFFFFF & paramInt;
  }
  
  public static int a(String paramString)
  {
    int i = 0;
    int j = 0;
    if (StringUtil.isEmpty(paramString)) {}
    for (;;)
    {
      return j;
      paramString = Uri.parse(paramString);
      try
      {
        paramString = paramString.getQueryParameter("_wwv");
        if (!StringUtil.isEmpty(paramString))
        {
          long l = Long.parseLong(paramString);
          if ((0x20000 & l) != 0L) {
            i = 1;
          }
          j = i;
          if ((0x10000 & l) != 0L) {
            return i + 2;
          }
        }
      }
      catch (Exception paramString)
      {
        QLog.e("ColorNoteUtils", 1, "parse long error: ", paramString);
      }
    }
    return 0;
  }
  
  public static ColorNote a(ColorNote paramColorNote)
  {
    if (paramColorNote == null) {
      return null;
    }
    String str = BaseApplicationImpl.getContext().getString(2131690892);
    int i = paramColorNote.getServiceType();
    return new aqoi().a(i | 0x80000000).a(paramColorNote.getSubType()).b(0).b(paramColorNote.getMainTitle()).c(str).d(paramColorNote.getPicUrl()).a(paramColorNote.getReserve()).a();
  }
  
  public static String a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    StackTraceElement[] arrayOfStackTraceElement = new Throwable().getStackTrace();
    localStringBuilder.append("").append(arrayOfStackTraceElement[2].getClassName()).append(".").append(arrayOfStackTraceElement[2].getMethodName()).append(": ").append(arrayOfStackTraceElement[2].getLineNumber());
    return localStringBuilder.toString();
  }
  
  public static String a(ColorNote paramColorNote)
  {
    if (paramColorNote == null) {
      return "";
    }
    return paramColorNote.getMainTitle() + ", " + paramColorNote.getSubTitle() + ". ";
  }
  
  public static String a(String paramString)
  {
    if (StringUtil.isEmpty(paramString)) {
      return "";
    }
    try
    {
      paramString = new Uri.Builder().scheme("webcover").authority(paramString).build().toString();
      return paramString;
    }
    catch (RuntimeException paramString)
    {
      QLog.e("ColorNoteUtils", 1, paramString, new Object[0]);
    }
    return "";
  }
  
  public static String a(List<ColorNote> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      return "";
    }
    Object localObject = new ArrayList(paramList);
    paramList = new StringBuilder();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      paramList.append(a((ColorNote)((Iterator)localObject).next()));
    }
    return paramList.toString();
  }
  
  public static void a(Context paramContext)
  {
    QQCustomDialog localQQCustomDialog = new QQCustomDialog(paramContext, 2131755829);
    localQQCustomDialog.setContentView(2131559043);
    localQQCustomDialog.dismissMessage();
    ((RelativeLayout.LayoutParams)localQQCustomDialog.getTitleTextView().getLayoutParams()).bottomMargin = ViewUtils.dip2px(26.0F);
    localQQCustomDialog.setCanceledOnTouchOutside(false);
    localQQCustomDialog.setTitle(paramContext.getString(2131690884));
    localQQCustomDialog.setNegativeButton(paramContext.getString(2131690883), new aqor(localQQCustomDialog, paramContext));
    if (localQQCustomDialog.isShowing()) {
      localQQCustomDialog.dismiss();
    }
    localQQCustomDialog.show();
    paramContext = localQQCustomDialog.getTitleTextView();
    paramContext.setClickable(true);
    paramContext.setFocusable(true);
    paramContext.setFocusableInTouchMode(true);
    bgyd.a(paramContext, true);
  }
  
  public static void a(ColorNote paramColorNote)
  {
    int j = 1;
    int i;
    if (!e(paramColorNote.mMainTitle))
    {
      i = 1;
      if (e(paramColorNote.mSubTitle)) {
        break label48;
      }
    }
    for (;;)
    {
      if ((j ^ i) != 0)
      {
        if (i == 0) {
          break label53;
        }
        paramColorNote.mSubTitle = paramColorNote.mMainTitle;
      }
      return;
      i = 0;
      break;
      label48:
      j = 0;
    }
    label53:
    paramColorNote.mMainTitle = paramColorNote.mSubTitle;
  }
  
  public static void a(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(paramString1, 2, paramString2);
    }
  }
  
  public static boolean a(int paramInt)
  {
    return (paramInt & 0x2) != 0;
  }
  
  public static boolean a(ColorNote paramColorNote)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramColorNote != null) {
      if (StringUtil.isEmpty(paramColorNote.mMainTitle))
      {
        bool1 = bool2;
        if (StringUtil.isEmpty(paramColorNote.mSubTitle)) {}
      }
      else
      {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public static boolean a(ColorNote paramColorNote1, ColorNote paramColorNote2)
  {
    if ((paramColorNote1 == null) || (paramColorNote2 == null)) {
      if ((paramColorNote1 != null) || (paramColorNote2 != null)) {}
    }
    while ((paramColorNote1.mServiceType == paramColorNote2.getServiceType()) && (a(paramColorNote1.mSubType, paramColorNote2.getSubType())) && (a(paramColorNote1.mMainTitle, paramColorNote2.getMainTitle())) && (a(paramColorNote1.mSubTitle, paramColorNote2.getSubTitle())))
    {
      return true;
      return false;
    }
    return false;
  }
  
  public static boolean a(String paramString)
  {
    if ((a == null) || (a.size() == 0) || (StringUtil.isEmpty(paramString))) {}
    for (;;)
    {
      return false;
      int i = 0;
      while (i < a.size())
      {
        String str = (String)a.get(i);
        if ((str.length() <= paramString.length()) && (paramString.contains(str))) {
          return true;
        }
        i += 1;
      }
    }
  }
  
  public static boolean a(String paramString1, String paramString2)
  {
    int i;
    if (!StringUtil.isEmpty(paramString1))
    {
      i = 1;
      if (StringUtil.isEmpty(paramString2)) {
        break label31;
      }
    }
    label31:
    for (int j = 1;; j = 0)
    {
      if ((i ^ j) == 0) {
        break label36;
      }
      return false;
      i = 0;
      break;
    }
    label36:
    if (paramString1 == null) {
      return true;
    }
    return paramString1.equals(paramString2);
  }
  
  public static boolean a(List<ColorNote> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      return false;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      if (c((ColorNote)paramList.next())) {
        return true;
      }
    }
    return false;
  }
  
  public static boolean a(List<ColorNote> paramList1, List<ColorNote> paramList2)
  {
    if ((paramList1 == null) && (paramList2 == null)) {
      return true;
    }
    if ((paramList1 == null) || (paramList2 == null)) {
      return false;
    }
    if (paramList1.size() != paramList2.size()) {
      return false;
    }
    int j = paramList1.size();
    int i = 0;
    while (i < j)
    {
      if (!paramList2.contains((ColorNote)paramList1.get(i))) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  public static int b(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return 0;
    case 17039360: 
      return 1;
    case 17104896: 
      return 2;
    case 16908289: 
      return 3;
    }
    return 4;
  }
  
  public static ColorNote b(ColorNote paramColorNote)
  {
    if (paramColorNote == null) {
      return null;
    }
    int i = a(paramColorNote.getServiceType());
    return new aqoi().a(i).a(paramColorNote.getSubType()).b(paramColorNote.getMainTitle()).c(paramColorNote.getSubTitle()).a(paramColorNote.getReserve()).a();
  }
  
  public static String b(List<ColorNote> paramList)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      localStringBuilder.append(((ColorNote)paramList.next()).toString());
    }
    return localStringBuilder.toString();
  }
  
  public static boolean b(int paramInt)
  {
    return (paramInt & 0x1) != 0;
  }
  
  public static boolean b(ColorNote paramColorNote)
  {
    if (paramColorNote == null) {}
    while ((paramColorNote.getServiceType() & 0x80000000) == 0) {
      return false;
    }
    return true;
  }
  
  public static boolean b(String paramString)
  {
    if ((b.size() == 0) || (StringUtil.isEmpty(paramString))) {}
    for (;;)
    {
      return false;
      int i = 0;
      while (i < b.size())
      {
        String str = (String)b.get(i);
        if ((str.length() <= paramString.length()) && (paramString.contains(str))) {
          return true;
        }
        i += 1;
      }
    }
  }
  
  public static ColorNote c(ColorNote paramColorNote)
  {
    if (paramColorNote == null) {
      return new aqoi().a();
    }
    return new aqoi().a(paramColorNote.getServiceType()).a(paramColorNote.getSubType()).b(paramColorNote.getMainTitle()).c(paramColorNote.getSubTitle()).d(paramColorNote.getPicUrl()).a(paramColorNote.getReserve()).b(paramColorNote.mExtra).a();
  }
  
  public static boolean c(ColorNote paramColorNote)
  {
    if (paramColorNote == null) {}
    while ((!d(paramColorNote)) || ((paramColorNote.mExtLong & 1L) != 1L)) {
      return false;
    }
    return true;
  }
  
  public static boolean c(String paramString)
  {
    if ((c.size() == 0) || (StringUtil.isEmpty(paramString))) {}
    for (;;)
    {
      return false;
      int i = 0;
      while (i < c.size())
      {
        String str = (String)c.get(i);
        if ((str.length() <= paramString.length()) && (paramString.contains(str))) {
          return true;
        }
        i += 1;
      }
    }
  }
  
  public static boolean d(ColorNote paramColorNote)
  {
    return paramColorNote.getServiceType() == 17235968;
  }
  
  public static boolean d(String paramString)
  {
    boolean bool = true;
    if (StringUtil.isEmpty(paramString)) {}
    for (;;)
    {
      return false;
      if (blsr.a(paramString))
      {
        if (QLog.isColorLevel()) {
          QLog.d("ColorNoteUtils", 2, "This is boodo url ,disable swipe.");
        }
        return true;
      }
      paramString = Uri.parse(paramString);
      try
      {
        paramString = paramString.getQueryParameter("_wv");
        if (StringUtil.isEmpty(paramString)) {
          continue;
        }
        long l = Long.parseLong(paramString);
        if ((l & 0x1000) != 0L) {}
        for (;;)
        {
          return bool;
          bool = false;
        }
        return false;
      }
      catch (Exception paramString)
      {
        QLog.e("ColorNoteUtils", 1, "parse long error: ", paramString);
      }
    }
  }
  
  public static boolean e(String paramString)
  {
    boolean bool2 = false;
    boolean bool1;
    if (StringUtil.isEmpty(paramString))
    {
      bool1 = true;
      return bool1;
    }
    int i = 0;
    for (;;)
    {
      if (i >= paramString.length()) {
        break label43;
      }
      bool1 = bool2;
      if (!Character.isWhitespace(paramString.charAt(i))) {
        break;
      }
      i += 1;
    }
    label43:
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqoq
 * JD-Core Version:    0.7.0.1
 */