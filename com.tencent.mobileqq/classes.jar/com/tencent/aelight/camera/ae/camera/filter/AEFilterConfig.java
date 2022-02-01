package com.tencent.aelight.camera.ae.camera.filter;

import androidx.annotation.NonNull;
import com.tencent.aelight.camera.download.api.AEResInfo;
import com.tencent.ttpic.openapi.config.BeautyRealConfig.TYPE;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AEFilterConfig
{
  private String a;
  private boolean b;
  private boolean c;
  private boolean d;
  private boolean e;
  private final Map<BeautyRealConfig.TYPE, Integer> f = new HashMap();
  private List<AEResInfo> g;
  
  private void i()
  {
    if (this.g == null) {
      this.g = new ArrayList();
    }
  }
  
  @NonNull
  public String a()
  {
    String str2 = this.a;
    String str1 = str2;
    if (str2 == null) {
      str1 = "defaultBeautyV6.json";
    }
    return str1;
  }
  
  public boolean b()
  {
    return this.b;
  }
  
  public boolean c()
  {
    return this.c;
  }
  
  public boolean d()
  {
    return this.d;
  }
  
  public boolean e()
  {
    return this.e;
  }
  
  @NonNull
  public Map<BeautyRealConfig.TYPE, Integer> f()
  {
    return Collections.unmodifiableMap(this.f);
  }
  
  public void g()
  {
    if (c())
    {
      i();
      this.g.add(AEResInfo.LIGHT_RES_BUNDLE_GENDER);
    }
    if (d())
    {
      i();
      this.g.add(AEResInfo.LIGHT_RES_BUNDLE_AGE);
    }
  }
  
  public List<AEResInfo> h()
  {
    return this.g;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.filter.AEFilterConfig
 * JD-Core Version:    0.7.0.1
 */