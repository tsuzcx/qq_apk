package com.tencent.ditto.reflect;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MustacheParser
{
  private static final Pattern formulaPattern = Pattern.compile("^([0-9.]*)\\*\\(([a-zA-Z0-9\\[\\].']*)([+\\-])([0-9.]*)(|px|dp)\\)$");
  
  private static List<String> getTokens(String paramString)
  {
    ArrayList localArrayList = new ArrayList(3);
    Object localObject = new StringBuilder();
    char[] arrayOfChar = paramString.toCharArray();
    int m = arrayOfChar.length;
    int i = 0;
    int j = 0;
    paramString = (String)localObject;
    while (i < m)
    {
      char c = arrayOfChar[i];
      int k;
      if (c == '\'')
      {
        k = j ^ 0x1;
        paramString.append(c);
        localObject = paramString;
      }
      else if ((c == ' ') && (j == 0))
      {
        localObject = paramString;
        k = j;
        if (paramString.length() != 0)
        {
          localArrayList.add(paramString.toString());
          localObject = new StringBuilder();
          k = j;
        }
      }
      else if ((c != '?') && (c != ':'))
      {
        paramString.append(c);
        localObject = paramString;
        k = j;
      }
      else
      {
        localObject = paramString;
        if (paramString.length() != 0)
        {
          localArrayList.add(paramString.toString());
          localObject = new StringBuilder();
        }
        localArrayList.add(Character.valueOf(c).toString());
        k = j;
      }
      i += 1;
      paramString = (String)localObject;
      j = k;
    }
    if (paramString.length() != 0) {
      localArrayList.add(paramString.toString());
    }
    return localArrayList;
  }
  
  public static DittoValue parse(String paramString)
  {
    Object localObject1 = getTokens(paramString);
    Object localObject2 = paramString.replace(" ", "");
    localObject2 = formulaPattern.matcher((CharSequence)localObject2);
    if (((Matcher)localObject2).matches()) {
      return new DittoFormulaField(((Matcher)localObject2).group(1), ((Matcher)localObject2).group(2), ((Matcher)localObject2).group(3), ((Matcher)localObject2).group(4), ((Matcher)localObject2).group(5), paramString);
    }
    localObject2 = ((List)localObject1).iterator();
    localObject1 = null;
    paramString = (String)localObject1;
    while (((Iterator)localObject2).hasNext())
    {
      String str = (String)((Iterator)localObject2).next();
      if ("?".equals(str)) {
        if (paramString != null)
        {
          localObject1 = new DittoConditionOperatorValue();
          ((DittoConditionOperatorValue)localObject1).conditionValue = paramString;
        }
      }
      for (;;)
      {
        paramString = null;
        break;
        throw new RuntimeException("mustache should not be started with ?");
        if (!":".equals(str)) {
          break label170;
        }
        if (localObject1 == null) {
          break;
        }
        if (paramString == null)
        {
          ((DittoConditionOperatorValue)localObject1).trueValue = ((DittoConditionOperatorValue)localObject1).conditionValue;
          break;
        }
        ((DittoConditionOperatorValue)localObject1).trueValue = paramString;
      }
      label170:
      if (str.startsWith("'"))
      {
        paramString = new DittoStringValue();
        paramString.mString = str.substring(1, str.length() - 1);
      }
      else
      {
        paramString = new DittoFieldValue();
        paramString.fieldName = str;
      }
    }
    if (localObject1 != null) {
      if (paramString != null) {
        ((DittoConditionOperatorValue)localObject1).falseValue = paramString;
      } else {
        throw new RuntimeException("there must be a string | field name after ':'");
      }
    }
    localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = paramString;
    }
    return localObject2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ditto.reflect.MustacheParser
 * JD-Core Version:    0.7.0.1
 */