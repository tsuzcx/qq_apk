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
    StringBuilder localStringBuilder = new StringBuilder();
    char[] arrayOfChar = paramString.toCharArray();
    int k = arrayOfChar.length;
    int j = 0;
    int i = 0;
    paramString = localStringBuilder;
    char c;
    if (j < k)
    {
      c = arrayOfChar[j];
      if (c == '\'') {
        if (i == 0)
        {
          i = 1;
          label60:
          paramString.append(c);
        }
      }
      for (;;)
      {
        j += 1;
        break;
        i = 0;
        break label60;
        if ((c != ' ') || (i != 0)) {
          break label118;
        }
        if (paramString.length() == 0) {
          break label181;
        }
        localArrayList.add(paramString.toString());
        paramString = new StringBuilder();
      }
      label118:
      if ((c == '?') || (c == ':'))
      {
        if (paramString.length() == 0) {
          break label206;
        }
        localArrayList.add(paramString.toString());
        paramString = new StringBuilder();
      }
    }
    label181:
    label206:
    for (;;)
    {
      localArrayList.add(Character.valueOf(c).toString());
      break;
      paramString.append(c);
      break;
      if (paramString.length() != 0) {
        localArrayList.add(paramString.toString());
      }
      return localArrayList;
    }
  }
  
  public static DittoValue parse(String paramString)
  {
    Object localObject1 = getTokens(paramString);
    Object localObject2 = paramString.replace(" ", "");
    localObject2 = formulaPattern.matcher((CharSequence)localObject2);
    if (((Matcher)localObject2).matches()) {
      return new DittoFormulaField(((Matcher)localObject2).group(1), ((Matcher)localObject2).group(2), ((Matcher)localObject2).group(3), ((Matcher)localObject2).group(4), ((Matcher)localObject2).group(5), paramString);
    }
    Iterator localIterator = ((List)localObject1).iterator();
    localObject1 = null;
    paramString = null;
    if (localIterator.hasNext())
    {
      localObject2 = (String)localIterator.next();
      if ("?".equals(localObject2))
      {
        if (localObject1 == null) {
          throw new RuntimeException("mustache should not be started with ?");
        }
        paramString = new DittoConditionOperatorValue();
        paramString.conditionValue = ((DittoValue)localObject1);
        localObject1 = paramString;
        paramString = null;
      }
    }
    for (;;)
    {
      localObject2 = localObject1;
      localObject1 = paramString;
      paramString = (String)localObject2;
      break;
      if (":".equals(localObject2))
      {
        if (paramString != null)
        {
          if (localObject1 == null)
          {
            paramString.trueValue = paramString.conditionValue;
            localObject2 = paramString;
            paramString = (String)localObject1;
            localObject1 = localObject2;
            continue;
          }
          paramString.trueValue = ((DittoValue)localObject1);
          localObject2 = null;
          localObject1 = paramString;
          paramString = (String)localObject2;
        }
      }
      else
      {
        if (((String)localObject2).startsWith("'"))
        {
          localObject1 = new DittoStringValue();
          ((DittoStringValue)localObject1).mString = ((String)localObject2).substring(1, ((String)localObject2).length() - 1);
          localObject2 = paramString;
          paramString = (String)localObject1;
          localObject1 = localObject2;
          continue;
        }
        localObject1 = new DittoFieldValue();
        ((DittoFieldValue)localObject1).fieldName = ((String)localObject2);
        localObject2 = paramString;
        paramString = (String)localObject1;
        localObject1 = localObject2;
        continue;
        if (paramString != null)
        {
          if (localObject1 == null) {
            throw new RuntimeException("there must be a string | field name after ':'");
          }
          paramString.falseValue = ((DittoValue)localObject1);
        }
        if (paramString == null) {}
        for (;;)
        {
          return localObject1;
          localObject1 = paramString;
        }
      }
      localObject2 = paramString;
      paramString = (String)localObject1;
      localObject1 = localObject2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ditto.reflect.MustacheParser
 * JD-Core Version:    0.7.0.1
 */