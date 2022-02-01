package com.tencent.luggage.wxa.ak;

import android.text.Layout.Alignment;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.AlignmentSpan.Standard;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.TypefaceSpan;
import android.text.style.UnderlineSpan;
import android.util.Log;
import com.tencent.luggage.wxa.ao.m;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

final class f
{
  public static final Pattern a = Pattern.compile("^(\\S+)\\s+-->\\s+(\\S+)(.*)?$");
  private static final Pattern b = Pattern.compile("(\\S+?):(\\S+)");
  private final StringBuilder c = new StringBuilder();
  
  private static int a(String paramString)
  {
    switch (paramString.hashCode())
    {
    default: 
      break;
    case 109757538: 
      if (paramString.equals("start")) {
        i = 0;
      }
      break;
    case 100571: 
      if (paramString.equals("end")) {
        i = 3;
      }
      break;
    case -1074341483: 
      if (paramString.equals("middle")) {
        i = 2;
      }
      break;
    case -1364013995: 
      if (paramString.equals("center")) {
        i = 1;
      }
      break;
    }
    int i = -1;
    if (i != 0)
    {
      if ((i != 1) && (i != 2))
      {
        if (i != 3)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("Invalid anchor value: ");
          localStringBuilder.append(paramString);
          Log.w("WebvttCueParser", localStringBuilder.toString());
          return -2147483648;
        }
        return 2;
      }
      return 1;
    }
    return 0;
  }
  
  private static int a(String paramString, int paramInt)
  {
    paramInt = paramString.indexOf('>', paramInt);
    if (paramInt == -1) {
      return paramString.length();
    }
    return paramInt + 1;
  }
  
  private static void a(SpannableStringBuilder paramSpannableStringBuilder, d paramd, int paramInt1, int paramInt2)
  {
    if (paramd == null) {
      return;
    }
    if (paramd.b() != -1) {
      paramSpannableStringBuilder.setSpan(new StyleSpan(paramd.b()), paramInt1, paramInt2, 33);
    }
    if (paramd.c()) {
      paramSpannableStringBuilder.setSpan(new StrikethroughSpan(), paramInt1, paramInt2, 33);
    }
    if (paramd.d()) {
      paramSpannableStringBuilder.setSpan(new UnderlineSpan(), paramInt1, paramInt2, 33);
    }
    if (paramd.g()) {
      paramSpannableStringBuilder.setSpan(new ForegroundColorSpan(paramd.f()), paramInt1, paramInt2, 33);
    }
    if (paramd.i()) {
      paramSpannableStringBuilder.setSpan(new BackgroundColorSpan(paramd.h()), paramInt1, paramInt2, 33);
    }
    if (paramd.e() != null) {
      paramSpannableStringBuilder.setSpan(new TypefaceSpan(paramd.e()), paramInt1, paramInt2, 33);
    }
    if (paramd.j() != null) {
      paramSpannableStringBuilder.setSpan(new AlignmentSpan.Standard(paramd.j()), paramInt1, paramInt2, 33);
    }
    int i = paramd.k();
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3) {
          return;
        }
        paramSpannableStringBuilder.setSpan(new RelativeSizeSpan(paramd.l() / 100.0F), paramInt1, paramInt2, 33);
        return;
      }
      paramSpannableStringBuilder.setSpan(new RelativeSizeSpan(paramd.l()), paramInt1, paramInt2, 33);
      return;
    }
    paramSpannableStringBuilder.setSpan(new AbsoluteSizeSpan((int)paramd.l(), true), paramInt1, paramInt2, 33);
  }
  
  private static void a(String paramString, SpannableStringBuilder paramSpannableStringBuilder)
  {
    int i = paramString.hashCode();
    if (i != 3309)
    {
      if (i != 3464)
      {
        if (i != 96708)
        {
          if ((i == 3374865) && (paramString.equals("nbsp")))
          {
            i = 2;
            break label92;
          }
        }
        else if (paramString.equals("amp"))
        {
          i = 3;
          break label92;
        }
      }
      else if (paramString.equals("lt"))
      {
        i = 0;
        break label92;
      }
    }
    else if (paramString.equals("gt"))
    {
      i = 1;
      break label92;
    }
    i = -1;
    label92:
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2)
        {
          if (i != 3)
          {
            paramSpannableStringBuilder = new StringBuilder();
            paramSpannableStringBuilder.append("ignoring unsupported entity: '&");
            paramSpannableStringBuilder.append(paramString);
            paramSpannableStringBuilder.append(";'");
            Log.w("WebvttCueParser", paramSpannableStringBuilder.toString());
            return;
          }
          paramSpannableStringBuilder.append('&');
          return;
        }
        paramSpannableStringBuilder.append(' ');
        return;
      }
      paramSpannableStringBuilder.append('>');
      return;
    }
    paramSpannableStringBuilder.append('<');
  }
  
  static void a(String paramString, e.a parama)
  {
    paramString = b.matcher(paramString);
    while (paramString.find())
    {
      Object localObject = paramString.group(1);
      String str = paramString.group(2);
      try
      {
        if ("line".equals(localObject))
        {
          b(str, parama);
          continue;
        }
        if ("align".equals(localObject))
        {
          parama.a(b(str));
          continue;
        }
        if ("position".equals(localObject))
        {
          c(str, parama);
          continue;
        }
        if ("size".equals(localObject))
        {
          parama.c(h.b(str));
          continue;
        }
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Unknown cue setting ");
        localStringBuilder.append((String)localObject);
        localStringBuilder.append(":");
        localStringBuilder.append(str);
        Log.w("WebvttCueParser", localStringBuilder.toString());
      }
      catch (NumberFormatException localNumberFormatException)
      {
        label156:
        break label156;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Skipping bad cue setting: ");
      ((StringBuilder)localObject).append(paramString.group());
      Log.w("WebvttCueParser", ((StringBuilder)localObject).toString());
    }
  }
  
  private static void a(String paramString, f.a parama, SpannableStringBuilder paramSpannableStringBuilder, List<d> paramList, List<f.b> paramList1)
  {
    int k = parama.b;
    int m = paramSpannableStringBuilder.length();
    String str = parama.a;
    int i = str.hashCode();
    int j = 0;
    if (i != 0)
    {
      if (i != 105)
      {
        if (i != 3314158)
        {
          if (i != 98)
          {
            if (i != 99)
            {
              if (i != 117)
              {
                if ((i == 118) && (str.equals("v")))
                {
                  i = 5;
                  break label194;
                }
              }
              else if (str.equals("u"))
              {
                i = 2;
                break label194;
              }
            }
            else if (str.equals("c"))
            {
              i = 3;
              break label194;
            }
          }
          else if (str.equals("b"))
          {
            i = 0;
            break label194;
          }
        }
        else if (str.equals("lang"))
        {
          i = 4;
          break label194;
        }
      }
      else if (str.equals("i"))
      {
        i = 1;
        break label194;
      }
    }
    else if (str.equals(""))
    {
      i = 6;
      break label194;
    }
    i = -1;
    switch (i)
    {
    default: 
      return;
    case 2: 
      paramSpannableStringBuilder.setSpan(new UnderlineSpan(), k, m, 33);
      break;
    case 1: 
      paramSpannableStringBuilder.setSpan(new StyleSpan(2), k, m, 33);
      break;
    case 0: 
      label194:
      paramSpannableStringBuilder.setSpan(new StyleSpan(1), k, m, 33);
    }
    paramList1.clear();
    a(paramList, paramString, parama, paramList1);
    int n = paramList1.size();
    i = j;
    while (i < n)
    {
      a(paramSpannableStringBuilder, ((f.b)paramList1.get(i)).b, k, m);
      i += 1;
    }
  }
  
  static void a(String paramString1, String paramString2, e.a parama, List<d> paramList)
  {
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    Stack localStack = new Stack();
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < paramString2.length())
    {
      char c1 = paramString2.charAt(i);
      int k;
      int j;
      if (c1 != '&')
      {
        if (c1 != '<')
        {
          localSpannableStringBuilder.append(c1);
          i += 1;
        }
        else
        {
          k = i + 1;
          if (k >= paramString2.length())
          {
            i = k;
          }
          else
          {
            j = paramString2.charAt(k);
            int m = 1;
            if (j == 47) {
              j = 1;
            } else {
              j = 0;
            }
            int i1 = a(paramString2, k);
            int n = i1 - 2;
            if (paramString2.charAt(n) == '/') {
              k = 1;
            } else {
              k = 0;
            }
            if (j != 0) {
              m = 2;
            }
            if (k == 0) {
              n = i1 - 1;
            }
            Object localObject = paramString2.substring(i + m, n);
            String str = d((String)localObject);
            i = i1;
            if (str != null) {
              if (!c(str))
              {
                i = i1;
              }
              else if (j != 0)
              {
                do
                {
                  if (localStack.isEmpty())
                  {
                    i = i1;
                    break;
                  }
                  localObject = (f.a)localStack.pop();
                  a(paramString1, (f.a)localObject, localSpannableStringBuilder, paramList, localArrayList);
                } while (!((f.a)localObject).a.equals(str));
                i = i1;
              }
              else
              {
                i = i1;
                if (k == 0)
                {
                  localStack.push(f.a.a((String)localObject, localSpannableStringBuilder.length()));
                  i = i1;
                }
              }
            }
          }
        }
      }
      else
      {
        j = i + 1;
        i = paramString2.indexOf(';', j);
        k = paramString2.indexOf(' ', j);
        if (i == -1) {
          i = k;
        } else if (k != -1) {
          i = Math.min(i, k);
        }
        if (i != -1)
        {
          a(paramString2.substring(j, i), localSpannableStringBuilder);
          if (i == k) {
            localSpannableStringBuilder.append(" ");
          }
          i += 1;
        }
        else
        {
          localSpannableStringBuilder.append(c1);
          i = j;
        }
      }
    }
    while (!localStack.isEmpty()) {
      a(paramString1, (f.a)localStack.pop(), localSpannableStringBuilder, paramList, localArrayList);
    }
    a(paramString1, f.a.a(), localSpannableStringBuilder, paramList, localArrayList);
    parama.a(localSpannableStringBuilder);
  }
  
  private static void a(List<d> paramList, String paramString, f.a parama, List<f.b> paramList1)
  {
    int j = paramList.size();
    int i = 0;
    while (i < j)
    {
      d locald = (d)paramList.get(i);
      int k = locald.a(paramString, parama.a, parama.d, parama.c);
      if (k > 0) {
        paramList1.add(new f.b(k, locald));
      }
      i += 1;
    }
    Collections.sort(paramList1);
  }
  
  private static boolean a(String paramString, Matcher paramMatcher, m paramm, e.a parama, StringBuilder paramStringBuilder, List<d> paramList)
  {
    try
    {
      parama.a(h.a(paramMatcher.group(1))).b(h.a(paramMatcher.group(2)));
      a(paramMatcher.group(3), parama);
      paramStringBuilder.setLength(0);
      for (;;)
      {
        paramMatcher = paramm.y();
        if (TextUtils.isEmpty(paramMatcher)) {
          break;
        }
        if (paramStringBuilder.length() > 0) {
          paramStringBuilder.append("\n");
        }
        paramStringBuilder.append(paramMatcher.trim());
      }
      a(paramString, paramStringBuilder.toString(), parama, paramList);
      return true;
    }
    catch (NumberFormatException paramString)
    {
      label95:
      break label95;
    }
    paramString = new StringBuilder();
    paramString.append("Skipping cue with bad header: ");
    paramString.append(paramMatcher.group());
    Log.w("WebvttCueParser", paramString.toString());
    return false;
  }
  
  private static Layout.Alignment b(String paramString)
  {
    switch (paramString.hashCode())
    {
    default: 
      break;
    case 109757538: 
      if (paramString.equals("start")) {
        i = 0;
      }
      break;
    case 108511772: 
      if (paramString.equals("right")) {
        i = 5;
      }
      break;
    case 3317767: 
      if (paramString.equals("left")) {
        i = 1;
      }
      break;
    case 100571: 
      if (paramString.equals("end")) {
        i = 4;
      }
      break;
    case -1074341483: 
      if (paramString.equals("middle")) {
        i = 3;
      }
      break;
    case -1364013995: 
      if (paramString.equals("center")) {
        i = 2;
      }
      break;
    }
    int i = -1;
    if ((i != 0) && (i != 1))
    {
      if ((i != 2) && (i != 3))
      {
        if ((i != 4) && (i != 5))
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("Invalid alignment value: ");
          localStringBuilder.append(paramString);
          Log.w("WebvttCueParser", localStringBuilder.toString());
          return null;
        }
        return Layout.Alignment.ALIGN_OPPOSITE;
      }
      return Layout.Alignment.ALIGN_CENTER;
    }
    return Layout.Alignment.ALIGN_NORMAL;
  }
  
  private static void b(String paramString, e.a parama)
  {
    int i = paramString.indexOf(',');
    if (i != -1)
    {
      parama.b(a(paramString.substring(i + 1)));
      paramString = paramString.substring(0, i);
    }
    else
    {
      parama.b(-2147483648);
    }
    if (paramString.endsWith("%"))
    {
      parama.a(h.b(paramString)).a(0);
      return;
    }
    int j = Integer.parseInt(paramString);
    i = j;
    if (j < 0) {
      i = j - 1;
    }
    parama.a(i).a(1);
  }
  
  private static void c(String paramString, e.a parama)
  {
    int i = paramString.indexOf(',');
    if (i != -1)
    {
      parama.c(a(paramString.substring(i + 1)));
      paramString = paramString.substring(0, i);
    }
    else
    {
      parama.c(-2147483648);
    }
    parama.b(h.b(paramString));
  }
  
  private static boolean c(String paramString)
  {
    int i = paramString.hashCode();
    if (i != 98)
    {
      if (i != 99)
      {
        if (i != 105)
        {
          if (i != 3314158)
          {
            if (i != 117)
            {
              if ((i == 118) && (paramString.equals("v")))
              {
                i = 5;
                break label130;
              }
            }
            else if (paramString.equals("u"))
            {
              i = 4;
              break label130;
            }
          }
          else if (paramString.equals("lang"))
          {
            i = 3;
            break label130;
          }
        }
        else if (paramString.equals("i"))
        {
          i = 2;
          break label130;
        }
      }
      else if (paramString.equals("c"))
      {
        i = 1;
        break label130;
      }
    }
    else if (paramString.equals("b"))
    {
      i = 0;
      break label130;
    }
    i = -1;
    label130:
    return (i == 0) || (i == 1) || (i == 2) || (i == 3) || (i == 4) || (i == 5);
  }
  
  private static String d(String paramString)
  {
    paramString = paramString.trim();
    if (paramString.isEmpty()) {
      return null;
    }
    return paramString.split("[ \\.]")[0];
  }
  
  boolean a(m paramm, e.a parama, List<d> paramList)
  {
    String str = paramm.y();
    if (str == null) {
      return false;
    }
    Object localObject = a.matcher(str);
    if (((Matcher)localObject).matches()) {
      return a(null, (Matcher)localObject, paramm, parama, this.c, paramList);
    }
    localObject = paramm.y();
    if (localObject == null) {
      return false;
    }
    localObject = a.matcher((CharSequence)localObject);
    if (((Matcher)localObject).matches()) {
      return a(str.trim(), (Matcher)localObject, paramm, parama, this.c, paramList);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ak.f
 * JD-Core Version:    0.7.0.1
 */