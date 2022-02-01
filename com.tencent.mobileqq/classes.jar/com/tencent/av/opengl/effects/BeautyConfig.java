package com.tencent.av.opengl.effects;

import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.config.BeautyRealConfig.TYPE;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

public class BeautyConfig
{
  private static final SparseArray<String> a = new SparseArray(13);
  private final LinkedHashMap<String, BeautyConfig.Beauty> b = new LinkedHashMap(12);
  private boolean c = false;
  private boolean d = true;
  
  static
  {
    a.put(BeautyRealConfig.TYPE.COLOR_TONE.value, "COLOR_TONE");
    a.put(BeautyRealConfig.TYPE.EYE_LIGHTEN.value, "EYE_LIGHTEN");
    a.put(BeautyRealConfig.TYPE.TOOTH_WHITEN.value, "TOOTH_WHITEN");
    a.put(BeautyRealConfig.TYPE.EYE.value, "ENLARGE_EYE");
    a.put(BeautyRealConfig.TYPE.MOUTH_SHAPE.value, "MOUTH_SHAPE");
    a.put(BeautyRealConfig.TYPE.CHIN.value, "CHIN");
    a.put(BeautyRealConfig.TYPE.FACE_THIN.value, "FACE_THIN");
    a.put(BeautyRealConfig.TYPE.FACE_V.value, "FACE_V");
    a.put(BeautyRealConfig.TYPE.BASIC4.value, "FACE_SHAPE_4");
    a.put(BeautyRealConfig.TYPE.FACE_SHORTEN.value, "FACE_SHORTEN");
    a.put(BeautyRealConfig.TYPE.NOSE.value, "NOSE_THIN");
  }
  
  public BeautyConfig()
  {
    g();
  }
  
  public static String a(int paramInt)
  {
    return (String)a.get(paramInt);
  }
  
  private void g()
  {
    if (AEFilterSupport.a() >= 7) {
      this.d = false;
    }
    this.b.clear();
    this.b.put("BEAUTY_SKIN", new BeautyConfig.Beauty(null, 1, 50, 0));
    if (this.d)
    {
      this.b.put("COLOR_TONE", new BeautyConfig.Beauty(BeautyRealConfig.TYPE.COLOR_TONE, 2, 50, 50));
      this.b.put("EYE_LIGHTEN", new BeautyConfig.Beauty(BeautyRealConfig.TYPE.EYE_LIGHTEN, 2, 0, 0));
      this.b.put("TOOTH_WHITEN", new BeautyConfig.Beauty(BeautyRealConfig.TYPE.TOOTH_WHITEN, 2, 0, 0));
      this.b.put("ENLARGE_EYE", new BeautyConfig.Beauty(BeautyRealConfig.TYPE.EYE, 3, 0, 0));
      this.b.put("MOUTH_SHAPE", new BeautyConfig.Beauty(BeautyRealConfig.TYPE.MOUTH_SHAPE, 3, 50, 50));
      this.b.put("CHIN", new BeautyConfig.Beauty(BeautyRealConfig.TYPE.CHIN, 3, 50, 50));
      this.b.put("FACE_THIN", new BeautyConfig.Beauty(BeautyRealConfig.TYPE.FACE_THIN, 3, 0, 0));
      this.b.put("FACE_V", new BeautyConfig.Beauty(BeautyRealConfig.TYPE.FACE_V, 3, 0, 0));
      this.b.put("FACE_SHAPE_4", new BeautyConfig.Beauty(BeautyRealConfig.TYPE.BASIC4, 3, 0, 0));
      this.b.put("FACE_SHORTEN", new BeautyConfig.Beauty(BeautyRealConfig.TYPE.FACE_SHORTEN, 3, 0, 0));
      this.b.put("NOSE_THIN", new BeautyConfig.Beauty(BeautyRealConfig.TYPE.NOSE, 3, 0, 0));
      return;
    }
    this.b.put("COLOR_TONE", new BeautyConfig.Beauty(BeautyRealConfig.TYPE.COLOR_TONE, 2, 50, 50));
    this.b.put("EYE_LIGHTEN", new BeautyConfig.Beauty(BeautyRealConfig.TYPE.EYE_LIGHTEN, 2, 0, 0));
    this.b.put("TOOTH_WHITEN", new BeautyConfig.Beauty(BeautyRealConfig.TYPE.TOOTH_WHITEN, 2, 0, 0));
    this.b.put("ENLARGE_EYE", new BeautyConfig.Beauty(BeautyRealConfig.TYPE.EYE, 3, 0, 0));
    this.b.put("MOUTH_SHAPE", new BeautyConfig.Beauty(BeautyRealConfig.TYPE.MOUTH_SHAPE, 3, 50, 50));
    this.b.put("CHIN", new BeautyConfig.Beauty(BeautyRealConfig.TYPE.CHIN, 3, 50, 50));
    this.b.put("FACE_THIN", new BeautyConfig.Beauty(BeautyRealConfig.TYPE.FACE_THIN, 3, 0, 0));
    this.b.put("FACE_V", new BeautyConfig.Beauty(BeautyRealConfig.TYPE.FACE_V, 3, 0, 0));
    this.b.put("FACE_SHAPE_4", new BeautyConfig.Beauty(BeautyRealConfig.TYPE.BASIC4, 3, 40, 0));
    this.b.put("FACE_SHORTEN", new BeautyConfig.Beauty(BeautyRealConfig.TYPE.FACE_SHORTEN, 3, 0, 0));
    this.b.put("NOSE_THIN", new BeautyConfig.Beauty(BeautyRealConfig.TYPE.NOSE, 3, 0, 0));
  }
  
  public String a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Object localObject = new ArrayList(this.b.keySet());
    Collections.sort((List)localObject);
    localStringBuilder.append("VERSION");
    localStringBuilder.append(":");
    localStringBuilder.append(1);
    int i = 0;
    while (i < ((List)localObject).size())
    {
      String str = (String)((List)localObject).get(i);
      BeautyConfig.Beauty localBeauty = (BeautyConfig.Beauty)this.b.get(str);
      if ((localBeauty != null) && (localBeauty.e != localBeauty.c))
      {
        localStringBuilder.append(",");
        localStringBuilder.append(str);
        localStringBuilder.append(":");
        localStringBuilder.append(localBeauty.e);
      }
      i += 1;
    }
    if (QLog.isDevelopLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getConfigStr, config[");
      ((StringBuilder)localObject).append(localStringBuilder.toString());
      ((StringBuilder)localObject).append("]");
      QLog.i("BeautyConfig", 4, ((StringBuilder)localObject).toString());
    }
    return localStringBuilder.toString();
  }
  
  void a(int paramInt, List<BeautyConfig.Beauty> paramList)
  {
    if (paramList == null) {
      return;
    }
    Iterator localIterator = this.b.entrySet().iterator();
    while (localIterator.hasNext())
    {
      BeautyConfig.Beauty localBeauty = (BeautyConfig.Beauty)((Map.Entry)localIterator.next()).getValue();
      if ((localBeauty != null) && ((paramInt == 0) || (localBeauty.a == paramInt))) {
        paramList.add(localBeauty);
      }
    }
  }
  
  public void a(BeautyConfig paramBeautyConfig)
  {
    if (paramBeautyConfig == null) {
      return;
    }
    Iterator localIterator = paramBeautyConfig.b.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      BeautyConfig.Beauty localBeauty = (BeautyConfig.Beauty)this.b.get(str);
      if (localBeauty != null) {
        localBeauty.e = paramBeautyConfig.b(str);
      }
    }
  }
  
  public void a(String paramString)
  {
    if (paramString != null)
    {
      if (paramString.length() == 0) {
        return;
      }
      Object localObject1 = paramString.split(",");
      int n = localObject1.length;
      int i = 0;
      int k;
      for (int j = -1; i < n; j = k)
      {
        Object localObject2 = localObject1[i];
        if (localObject2 == null)
        {
          k = j;
        }
        else
        {
          localObject2 = ((String)localObject2).split(":");
          k = j;
          if (localObject2.length == 2)
          {
            CharSequence localCharSequence = localObject2[0];
            try
            {
              int m = Integer.parseInt(localObject2[1]);
              if (TextUtils.equals(localCharSequence, "VERSION"))
              {
                k = m;
              }
              else
              {
                localObject2 = (BeautyConfig.Beauty)this.b.get(localCharSequence);
                k = j;
                if (localObject2 != null)
                {
                  ((BeautyConfig.Beauty)localObject2).e = m;
                  k = j;
                }
              }
            }
            catch (NumberFormatException localNumberFormatException)
            {
              localNumberFormatException.printStackTrace();
              k = j;
            }
          }
        }
        i += 1;
      }
      if ((j < 1) && (this.d))
      {
        localObject1 = this.b.entrySet().iterator();
        for (i = 1; ((Iterator)localObject1).hasNext(); i = 0)
        {
          label186:
          BeautyConfig.Beauty localBeauty = (BeautyConfig.Beauty)((Map.Entry)((Iterator)localObject1).next()).getValue();
          if ((localBeauty == null) || (localBeauty.a == 1) || (localBeauty.b == BeautyRealConfig.TYPE.BASIC4) || (localBeauty.e == localBeauty.c)) {
            break label186;
          }
        }
        j = i;
        if (i != 0)
        {
          j = i;
          if (b("FACE_SHAPE_4") != 40) {
            j = 0;
          }
        }
        if (j != 0) {
          a("FACE_SHAPE_4", 0);
        }
      }
      if (QLog.isDevelopLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("parseConfig, config[");
        ((StringBuilder)localObject1).append(paramString);
        ((StringBuilder)localObject1).append("]");
        QLog.i("BeautyConfig", 4, ((StringBuilder)localObject1).toString());
      }
    }
  }
  
  public void a(String paramString, int paramInt)
  {
    paramString = (BeautyConfig.Beauty)this.b.get(paramString);
    if ((paramString != null) && (paramString.e != paramInt))
    {
      paramString.e = paramInt;
      this.c = true;
    }
  }
  
  public int b(String paramString)
  {
    paramString = (BeautyConfig.Beauty)this.b.get(paramString);
    if (paramString != null) {
      return paramString.e;
    }
    return 0;
  }
  
  public void b()
  {
    this.c = false;
  }
  
  public int c(String paramString)
  {
    paramString = (BeautyConfig.Beauty)this.b.get(paramString);
    if (paramString != null) {
      return paramString.d;
    }
    return 0;
  }
  
  public boolean c()
  {
    return this.c;
  }
  
  public void d()
  {
    Iterator localIterator = this.b.entrySet().iterator();
    while (localIterator.hasNext())
    {
      BeautyConfig.Beauty localBeauty = (BeautyConfig.Beauty)((Map.Entry)localIterator.next()).getValue();
      if ((localBeauty != null) && (localBeauty.e != localBeauty.c))
      {
        localBeauty.e = localBeauty.c;
        this.c = true;
      }
    }
  }
  
  public void e()
  {
    Iterator localIterator = this.b.entrySet().iterator();
    while (localIterator.hasNext())
    {
      BeautyConfig.Beauty localBeauty = (BeautyConfig.Beauty)((Map.Entry)localIterator.next()).getValue();
      if ((localBeauty != null) && (localBeauty.e != localBeauty.d))
      {
        localBeauty.e = localBeauty.d;
        this.c = true;
      }
    }
  }
  
  public boolean f()
  {
    Iterator localIterator = this.b.entrySet().iterator();
    while (localIterator.hasNext())
    {
      BeautyConfig.Beauty localBeauty = (BeautyConfig.Beauty)((Map.Entry)localIterator.next()).getValue();
      if ((localBeauty != null) && (localBeauty.e != localBeauty.d)) {
        return true;
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.opengl.effects.BeautyConfig
 * JD-Core Version:    0.7.0.1
 */