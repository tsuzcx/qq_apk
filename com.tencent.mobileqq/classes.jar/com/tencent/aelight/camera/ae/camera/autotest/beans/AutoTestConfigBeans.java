package com.tencent.aelight.camera.ae.camera.autotest.beans;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.config.BeautyRealConfig.TYPE;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

public class AutoTestConfigBeans
{
  private static HashMap<String, BeautyRealConfig.TYPE> g;
  public int a;
  public String b;
  public int c;
  public List<AutoTestConfigBeans.AutoTestNode> d;
  public List<AutoTestConfigBeans.ImageTest> e;
  public HashMap<String, List<AutoTestConfigBeans.AutoTestNode>> f;
  
  private void a(AutoTestConfigBeans.AutoTestNode paramAutoTestNode)
  {
    if (paramAutoTestNode == null) {
      return;
    }
    if (paramAutoTestNode.g == null) {
      paramAutoTestNode.g = new HashMap();
    }
    if (paramAutoTestNode.b) {
      return;
    }
    AutoTestConfigBeans.AutoTestNode.a(paramAutoTestNode, f());
    Object localObject1 = paramAutoTestNode.g.entrySet().iterator();
    Object localObject2;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (Map.Entry)((Iterator)localObject1).next();
      Object localObject3 = (BeautyRealConfig.TYPE)g.get(((Map.Entry)localObject2).getKey());
      if (localObject3 == null)
      {
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("can not find related TYPE for param key: ");
        ((StringBuilder)localObject3).append((String)((Map.Entry)localObject2).getKey());
        QLog.e("AutoTestConfigBeans", 4, ((StringBuilder)localObject3).toString());
      }
      else
      {
        AutoTestConfigBeans.AutoTestNode.a(paramAutoTestNode).put(localObject3, ((Map.Entry)localObject2).getValue());
      }
    }
    if (paramAutoTestNode.k == null)
    {
      paramAutoTestNode.k = d();
    }
    else if (!TextUtils.isEmpty(paramAutoTestNode.k.a))
    {
      localObject1 = paramAutoTestNode.k;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("/sdcard/qq_img_auto_test/materials/");
      ((StringBuilder)localObject2).append(paramAutoTestNode.k.a);
      ((AutoTestConfigBeans.SpecialConfig)localObject1).a = ((StringBuilder)localObject2).toString();
    }
    if (paramAutoTestNode.m == null)
    {
      paramAutoTestNode.m = d();
    }
    else if (!TextUtils.isEmpty(paramAutoTestNode.m.a))
    {
      localObject1 = paramAutoTestNode.m;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("/sdcard/qq_img_auto_test/lut_res/");
      ((StringBuilder)localObject2).append(paramAutoTestNode.m.a);
      ((AutoTestConfigBeans.SpecialConfig)localObject1).a = ((StringBuilder)localObject2).toString();
    }
    if (paramAutoTestNode.i == null) {
      paramAutoTestNode.i = d();
    }
    if (paramAutoTestNode.j == null) {
      paramAutoTestNode.j = d();
    }
    if (paramAutoTestNode.h == null) {
      paramAutoTestNode.h = e();
    }
  }
  
  private void a(AutoTestConfigBeans.ImageTest paramImageTest)
  {
    if (paramImageTest == null) {
      return;
    }
    if (!paramImageTest.d) {
      return;
    }
    if (!TextUtils.isEmpty(paramImageTest.a))
    {
      AutoTestConfigBeans.ImageTest.a(paramImageTest);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("/sdcard/qq_img_auto_test/test_imgs/");
      localStringBuilder.append(paramImageTest.a);
      paramImageTest.a = localStringBuilder.toString();
    }
  }
  
  private void a(List<AutoTestConfigBeans.ImageTest> paramList)
  {
    if ((paramList != null) && (paramList.size() > 0))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        a((AutoTestConfigBeans.ImageTest)paramList.next());
      }
    }
  }
  
  private void b(List<AutoTestConfigBeans.AutoTestNode> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      a((AutoTestConfigBeans.AutoTestNode)paramList.next());
    }
  }
  
  private boolean b()
  {
    Object localObject = this.e;
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      localObject = this.f;
      if ((localObject != null) && (((HashMap)localObject).size() > 0)) {
        return true;
      }
    }
    return false;
  }
  
  private List<AutoTestConfigBeans.AutoTestNode> c()
  {
    if (!b())
    {
      QLog.i("AutoTestConfigBeans", 4, "createNodeFromImageSet | 无需创建新的autoTestNode");
      return null;
    }
    Object localObject1 = new Date();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("");
    ((StringBuilder)localObject2).append(((Date)localObject1).getYear() + 1900);
    ((StringBuilder)localObject2).append("_");
    ((StringBuilder)localObject2).append(((Date)localObject1).getMonth() + 1);
    ((StringBuilder)localObject2).append("_");
    ((StringBuilder)localObject2).append(((Date)localObject1).getDate());
    ((StringBuilder)localObject2).append(File.separator);
    localObject1 = ((StringBuilder)localObject2).toString();
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("createNodeFromImageSet | parentFolder:");
    ((StringBuilder)localObject2).append((String)localObject1);
    QLog.i("AutoTestConfigBeans", 4, ((StringBuilder)localObject2).toString());
    localObject2 = new ArrayList();
    Iterator localIterator = this.e.iterator();
    while (localIterator.hasNext())
    {
      AutoTestConfigBeans.ImageTest localImageTest = (AutoTestConfigBeans.ImageTest)localIterator.next();
      Object localObject3 = (List)this.f.get(localImageTest.e);
      if ((localObject3 != null) && (((List)localObject3).size() != 0))
      {
        localObject3 = ((List)localObject3).iterator();
        while (((Iterator)localObject3).hasNext()) {
          ((ArrayList)localObject2).add(localImageTest.a((AutoTestConfigBeans.AutoTestNode)((Iterator)localObject3).next(), (String)localObject1));
        }
      }
      else
      {
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("can not found test cases for ");
        ((StringBuilder)localObject3).append(localImageTest.e);
        QLog.e("AutoTestConfigBeans", 4, ((StringBuilder)localObject3).toString());
      }
    }
    return localObject2;
  }
  
  private AutoTestConfigBeans.SpecialConfig d()
  {
    AutoTestConfigBeans.SpecialConfig localSpecialConfig = new AutoTestConfigBeans.SpecialConfig(this);
    localSpecialConfig.a = null;
    localSpecialConfig.b = 0;
    return localSpecialConfig;
  }
  
  private AutoTestConfigBeans.LipsLUTConfig e()
  {
    AutoTestConfigBeans.LipsLUTConfig localLipsLUTConfig = new AutoTestConfigBeans.LipsLUTConfig(this);
    localLipsLUTConfig.a = null;
    localLipsLUTConfig.b = 0;
    localLipsLUTConfig.c = 0;
    return localLipsLUTConfig;
  }
  
  private HashMap<BeautyRealConfig.TYPE, Integer> f()
  {
    if (g == null) {
      g();
    }
    HashMap localHashMap = new HashMap();
    BeautyRealConfig.TYPE[] arrayOfTYPE = BeautyRealConfig.TYPE.values();
    int j = arrayOfTYPE.length;
    int i = 0;
    while (i < j)
    {
      localHashMap.put(arrayOfTYPE[i], Integer.valueOf(0));
      i += 1;
    }
    return localHashMap;
  }
  
  private void g()
  {
    g = new HashMap();
    h();
  }
  
  private void h()
  {
    g.put("无", BeautyRealConfig.TYPE.NONE);
    g.put("美白", BeautyRealConfig.TYPE.LUT_FOUNDATION_ALPHA);
    g.put("小脸", BeautyRealConfig.TYPE.FACTOR_SMALL_NEW);
    g.put("嘴形", BeautyRealConfig.TYPE.MOUTH_SHAPE);
    g.put("腮红", BeautyRealConfig.TYPE.FACE_FEATURE_REDCHEEK);
    g.put("额头", BeautyRealConfig.TYPE.FOREHEAD);
    g.put("清晰", BeautyRealConfig.TYPE.LUT_CLERA_ALPHA);
    g.put("立体", BeautyRealConfig.TYPE.FACE_FEATURE_SOFT);
    g.put("法令纹", BeautyRealConfig.TYPE.REMOVE_WRINKLES2);
    g.put("磨皮", BeautyRealConfig.TYPE.BEAUTY);
    g.put("瘦颧骨", BeautyRealConfig.TYPE.CHEEKBONE_THIN);
    g.put("白牙", BeautyRealConfig.TYPE.TOOTH_WHITEN);
    g.put("口红", BeautyRealConfig.TYPE.FACE_FEATURE_LIPS_LUT_ALPHA);
    g.put("窄脸", BeautyRealConfig.TYPE.FACE_THIN);
    g.put("瘦鼻", BeautyRealConfig.TYPE.NOSE);
    g.put("瘦脸", BeautyRealConfig.TYPE.FACTOR_THIN_NEW);
    g.put("大眼", BeautyRealConfig.TYPE.EYE);
    g.put("黑眼圈", BeautyRealConfig.TYPE.REMOVE_POUNCH);
  }
  
  public void a()
  {
    Object localObject = this.d;
    if ((localObject != null) && (((List)localObject).size() > 0)) {
      b(this.d);
    }
    if (!b()) {
      return;
    }
    localObject = this.f.entrySet().iterator();
    while (((Iterator)localObject).hasNext()) {
      b((List)((Map.Entry)((Iterator)localObject).next()).getValue());
    }
    a(this.e);
    localObject = this.d;
    if (localObject != null) {
      ((List)localObject).addAll(c());
    } else {
      this.d = c();
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("checkBeans | autoTestNode size:");
    ((StringBuilder)localObject).append(this.d.size());
    QLog.i("AutoTestConfigBeans", 4, ((StringBuilder)localObject).toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.autotest.beans.AutoTestConfigBeans
 * JD-Core Version:    0.7.0.1
 */