package com.tencent.featuretoggle.hltxkg.common.b.a;

import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.featuretoggle.hltxkg.common.a.c.c;
import com.tencent.featuretoggle.hltxkg.common.a.e;
import com.tencent.featuretoggle.hltxkg.common.a.i;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class b
{
  private int jdField_a_of_type_Int;
  public String a;
  private URL jdField_a_of_type_JavaNetURL;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean;
  
  public b(URL paramURL, String paramString)
  {
    boolean bool2 = false;
    if (i.a("direct_access_use_schedule", 0, 1, 1) == 1) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.jdField_a_of_type_Boolean = bool1;
    boolean bool1 = bool2;
    if (i.a("direct_https_use_sche", 0, 1, 1) == 1) {
      bool1 = true;
    }
    this.jdField_b_of_type_Boolean = bool1;
    this.jdField_a_of_type_Int = i.a("direct_access_domain_try_times", 1, 8, 2);
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_JavaNetURL = paramURL;
    this.jdField_b_of_type_JavaLangString = paramString;
  }
  
  public final String a(com.tencent.featuretoggle.hltxkg.common.a.a parama)
  {
    if (parama.e()) {
      return this.jdField_b_of_type_JavaLangString;
    }
    int i;
    if (!this.jdField_a_of_type_JavaNetURL.getProtocol().startsWith("https"))
    {
      localObject = new StringBuilder("http://");
      ((StringBuilder)localObject).append(parama.a());
      ((StringBuilder)localObject).append(":");
      i = parama.c();
      parama = (com.tencent.featuretoggle.hltxkg.common.a.a)localObject;
      parama.append(i);
    }
    for (;;)
    {
      localObject = parama.toString();
      break label148;
      if (this.jdField_b_of_type_Int != 0)
      {
        localObject = new StringBuilder("https://");
        ((StringBuilder)localObject).append(parama.a());
        ((StringBuilder)localObject).append(":");
        i = this.jdField_b_of_type_Int;
        parama = (com.tencent.featuretoggle.hltxkg.common.a.a)localObject;
        break;
      }
      localObject = new StringBuilder("https://");
      ((StringBuilder)localObject).append(parama.a());
      ((StringBuilder)localObject).append(":443");
      parama = (com.tencent.featuretoggle.hltxkg.common.a.a)localObject;
    }
    label148:
    String str = this.jdField_a_of_type_JavaNetURL.getFile();
    parama = (com.tencent.featuretoggle.hltxkg.common.a.a)localObject;
    if (!TextUtils.isEmpty(str)) {
      if (str.startsWith("/"))
      {
        parama = new StringBuilder();
        parama.append((String)localObject);
        parama.append(str);
        parama = parama.toString();
      }
      else
      {
        parama = new StringBuilder();
        parama.append((String)localObject);
        parama.append("/");
        parama.append(str);
        parama = parama.toString();
      }
    }
    str = this.jdField_a_of_type_JavaNetURL.getRef();
    Object localObject = parama;
    if (!TextUtils.isEmpty(str))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(parama);
      ((StringBuilder)localObject).append("#");
      ((StringBuilder)localObject).append(str);
      localObject = ((StringBuilder)localObject).toString();
    }
    return localObject;
  }
  
  public final List<com.tencent.featuretoggle.hltxkg.common.a.a> a(com.tencent.featuretoggle.hltxkg.common.b.a parama, boolean paramBoolean1, boolean paramBoolean2)
  {
    parama = new com.tencent.featuretoggle.hltxkg.common.a.a(this.jdField_a_of_type_JavaNetURL.getHost(), -1);
    int k = 3;
    parama.a((byte)3);
    int j = 0;
    for (;;)
    {
      try
      {
        localObject = new ArrayList();
        if (!paramBoolean1)
        {
          ((List)localObject).add(parama);
          parama.jdField_a_of_type_Int = 1;
          return localObject;
        }
        if ((e.h()) || (!this.jdField_a_of_type_Boolean) || ((paramBoolean2) && (!this.jdField_b_of_type_Boolean))) {
          continue;
        }
        if ((paramBoolean2) && (Build.VERSION.SDK_INT <= 18))
        {
          i = 0;
          if (i < this.jdField_a_of_type_Int)
          {
            ((List)localObject).add(parama);
            i += 1;
            continue;
          }
          parama.jdField_a_of_type_Int = 10;
          return localObject;
        }
        localObject = com.tencent.featuretoggle.hltxkg.common.b.a.a(this.jdField_a_of_type_JavaNetURL.getHost());
        List localList = ((c)localObject).c;
        this.jdField_b_of_type_Int = ((c)localObject).d;
        this.jdField_a_of_type_JavaLangString = ((c)localObject).jdField_b_of_type_JavaLangString;
        return localList;
      }
      catch (Exception localException)
      {
        Object localObject;
        continue;
        int i = 0;
        continue;
        i = 4;
        continue;
      }
      if (i >= this.jdField_a_of_type_Int) {
        continue;
      }
      ((List)localObject).add(parama);
      i += 1;
    }
    if (e.h())
    {
      i = 2;
    }
    else
    {
      if (this.jdField_a_of_type_Boolean) {
        break label297;
      }
      i = k;
    }
    parama.jdField_a_of_type_Int = i;
    return localObject;
    localObject = new ArrayList();
    i = j;
    while (i < this.jdField_a_of_type_Int)
    {
      ((List)localObject).add(parama);
      i += 1;
    }
    parama.jdField_a_of_type_Int = 8;
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.featuretoggle.hltxkg.common.b.a.b
 * JD-Core Version:    0.7.0.1
 */