package com.tencent.av.business.manager.zimu;

import android.graphics.PointF;
import android.graphics.Typeface;
import android.text.TextUtils;
import com.tencent.av.AVLog;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.business.handler.SentenceInfo;
import com.tencent.av.business.manager.EffectConfigBase.ItemBase;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;
import jhe;

public abstract class ARZimuTask
{
  private static ARZimuTask.DoubleScreenLocationInfo a;
  protected Typeface a;
  protected VideoAppInterface a;
  protected ARZimuTask.IARZimuShowPlayer a;
  protected EffectZimuManager a;
  protected final List a;
  protected jhe a;
  
  public ARZimuTask(VideoAppInterface paramVideoAppInterface)
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = paramVideoAppInterface;
    this.jdField_a_of_type_ComTencentAvBusinessManagerZimuEffectZimuManager = ((EffectZimuManager)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(0));
    paramVideoAppInterface = d();
    this.jdField_a_of_type_ComTencentAvBusinessManagerZimuEffectZimuManager.b(paramVideoAppInterface);
  }
  
  public static PointF a(PointF paramPointF)
  {
    if (jdField_a_of_type_ComTencentAvBusinessManagerZimuARZimuTask$DoubleScreenLocationInfo == null) {
      jdField_a_of_type_ComTencentAvBusinessManagerZimuARZimuTask$DoubleScreenLocationInfo = new ARZimuTask.DoubleScreenLocationInfo();
    }
    a("static getSmallPointInBigScreen: " + paramPointF.x + "|" + paramPointF.y);
    return jdField_a_of_type_ComTencentAvBusinessManagerZimuARZimuTask$DoubleScreenLocationInfo.a(paramPointF);
  }
  
  public static String a()
  {
    if (jdField_a_of_type_ComTencentAvBusinessManagerZimuARZimuTask$DoubleScreenLocationInfo == null) {
      jdField_a_of_type_ComTencentAvBusinessManagerZimuARZimuTask$DoubleScreenLocationInfo = new ARZimuTask.DoubleScreenLocationInfo();
    }
    return jdField_a_of_type_ComTencentAvBusinessManagerZimuARZimuTask$DoubleScreenLocationInfo.a();
  }
  
  public static void a(int paramInt)
  {
    if (jdField_a_of_type_ComTencentAvBusinessManagerZimuARZimuTask$DoubleScreenLocationInfo == null) {
      jdField_a_of_type_ComTencentAvBusinessManagerZimuARZimuTask$DoubleScreenLocationInfo = new ARZimuTask.DoubleScreenLocationInfo();
    }
    a("getSmallScreenPositionType: " + paramInt);
    jdField_a_of_type_ComTencentAvBusinessManagerZimuARZimuTask$DoubleScreenLocationInfo.a(paramInt);
  }
  
  public static void a(int paramInt1, int paramInt2)
  {
    if (jdField_a_of_type_ComTencentAvBusinessManagerZimuARZimuTask$DoubleScreenLocationInfo == null) {
      jdField_a_of_type_ComTencentAvBusinessManagerZimuARZimuTask$DoubleScreenLocationInfo = new ARZimuTask.DoubleScreenLocationInfo();
    }
    a("UpdateSmallScreenPosition: " + paramInt1 + "|" + paramInt2);
    jdField_a_of_type_ComTencentAvBusinessManagerZimuARZimuTask$DoubleScreenLocationInfo.a(paramInt1, paramInt2);
  }
  
  private void a(SentenceInfo paramSentenceInfo, boolean paramBoolean)
  {
    Object localObject1 = null;
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    int i = 0;
    Object localObject3;
    while (localIterator.hasNext())
    {
      localObject3 = (ARZimuItemTask)localIterator.next();
      localObject2 = localObject1;
      int j = i;
      if (!((ARZimuItemTask)localObject3).a.a())
      {
        localObject2 = localObject1;
        j = i;
        if (((ARZimuItemTask)localObject3).a.jdField_a_of_type_JavaLangString.equals(paramSentenceInfo.jdField_a_of_type_JavaLangString))
        {
          j = 1;
          localObject2 = localObject1;
          if (localObject1 == null) {
            localObject2 = localObject3;
          }
          ((ARZimuItemTask)localObject3).a(paramSentenceInfo);
          AVLog.c("ARZimuTask", "updateTextInner " + paramSentenceInfo.jdField_a_of_type_JavaLangString + " onTextChanged info:" + paramSentenceInfo.jdField_a_of_type_JavaLangCharSequence);
        }
      }
      i = j;
      localObject1 = localObject2;
    }
    Object localObject2 = localObject1;
    if (i == 0)
    {
      localObject3 = a(paramSentenceInfo, paramBoolean);
      localObject2 = localObject1;
      if (localObject3 != null)
      {
        localObject2 = localObject1;
        if (localObject1 == null)
        {
          localObject2 = localObject1;
          if (((List)localObject3).size() > 0) {
            localObject2 = (ARZimuItemTask)((List)localObject3).get(0);
          }
        }
        this.jdField_a_of_type_JavaUtilList.addAll((Collection)localObject3);
        AVLog.c("ARZimuTask", "updateTextInner " + paramSentenceInfo.jdField_a_of_type_JavaLangString + " addinfo:" + paramSentenceInfo.jdField_a_of_type_JavaLangCharSequence);
      }
    }
    a((ARZimuItemTask)localObject2);
  }
  
  public static void a(String paramString)
  {
    if (paramString == null) {}
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("ARZimuTask", 2, paramString);
  }
  
  public static void a(String paramString1, String paramString2)
  {
    if (jdField_a_of_type_ComTencentAvBusinessManagerZimuARZimuTask$DoubleScreenLocationInfo == null) {
      jdField_a_of_type_ComTencentAvBusinessManagerZimuARZimuTask$DoubleScreenLocationInfo = new ARZimuTask.DoubleScreenLocationInfo();
    }
    jdField_a_of_type_ComTencentAvBusinessManagerZimuARZimuTask$DoubleScreenLocationInfo.a(paramString1, paramString2);
  }
  
  public static void a(boolean paramBoolean)
  {
    if (jdField_a_of_type_ComTencentAvBusinessManagerZimuARZimuTask$DoubleScreenLocationInfo == null) {
      jdField_a_of_type_ComTencentAvBusinessManagerZimuARZimuTask$DoubleScreenLocationInfo = new ARZimuTask.DoubleScreenLocationInfo();
    }
    jdField_a_of_type_ComTencentAvBusinessManagerZimuARZimuTask$DoubleScreenLocationInfo.a(paramBoolean);
  }
  
  public static String b()
  {
    if (jdField_a_of_type_ComTencentAvBusinessManagerZimuARZimuTask$DoubleScreenLocationInfo == null) {
      jdField_a_of_type_ComTencentAvBusinessManagerZimuARZimuTask$DoubleScreenLocationInfo = new ARZimuTask.DoubleScreenLocationInfo();
    }
    return jdField_a_of_type_ComTencentAvBusinessManagerZimuARZimuTask$DoubleScreenLocationInfo.b();
  }
  
  public static void b(int paramInt1, int paramInt2)
  {
    if (jdField_a_of_type_ComTencentAvBusinessManagerZimuARZimuTask$DoubleScreenLocationInfo == null) {
      jdField_a_of_type_ComTencentAvBusinessManagerZimuARZimuTask$DoubleScreenLocationInfo = new ARZimuTask.DoubleScreenLocationInfo();
    }
    a("setSmallScreenSize: " + paramInt1 + "|" + paramInt2);
    jdField_a_of_type_ComTencentAvBusinessManagerZimuARZimuTask$DoubleScreenLocationInfo.b(paramInt1, paramInt2);
  }
  
  private void b(Observable paramObservable, Object paramObject)
  {
    ((Integer)((Object[])(Object[])paramObject)[0]).intValue();
    a(paramObservable, paramObject);
  }
  
  public static void c(int paramInt1, int paramInt2)
  {
    if (jdField_a_of_type_ComTencentAvBusinessManagerZimuARZimuTask$DoubleScreenLocationInfo == null) {
      jdField_a_of_type_ComTencentAvBusinessManagerZimuARZimuTask$DoubleScreenLocationInfo = new ARZimuTask.DoubleScreenLocationInfo();
    }
    a("setBigScreenSize: " + paramInt1 + "|" + paramInt2);
    jdField_a_of_type_ComTencentAvBusinessManagerZimuARZimuTask$DoubleScreenLocationInfo.c(paramInt1, paramInt2);
  }
  
  public abstract int a();
  
  public ARZimuTask.IARZimuShowPlayer a()
  {
    return this.jdField_a_of_type_ComTencentAvBusinessManagerZimuARZimuTask$IARZimuShowPlayer;
  }
  
  protected abstract List a(SentenceInfo paramSentenceInfo, boolean paramBoolean);
  
  public void a()
  {
    this.jdField_a_of_type_Jhe = new jhe(this);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.jdField_a_of_type_Jhe);
  }
  
  public void a(SentenceInfo paramSentenceInfo)
  {
    if ((paramSentenceInfo == null) || (TextUtils.isEmpty(paramSentenceInfo.jdField_a_of_type_JavaLangCharSequence)) || (TextUtils.isEmpty(paramSentenceInfo.jdField_a_of_type_JavaLangString)))
    {
      StringBuilder localStringBuilder = new StringBuilder().append("updateText error:");
      if (paramSentenceInfo == null) {}
      for (paramSentenceInfo = null;; paramSentenceInfo = paramSentenceInfo.toString())
      {
        AVLog.e("ARZimuTask", paramSentenceInfo);
        return;
      }
    }
    AVLog.c("ARZimuTask", "updateText :" + paramSentenceInfo.toString());
    if (!this.jdField_a_of_type_ComTencentAvBusinessManagerZimuEffectZimuManager.a()) {
      this.jdField_a_of_type_ComTencentAvBusinessManagerZimuEffectZimuManager.b(true);
    }
    a(paramSentenceInfo, false);
  }
  
  abstract void a(ARZimuItemTask paramARZimuItemTask);
  
  public void a(ARZimuTask.IARZimuShowPlayer paramIARZimuShowPlayer)
  {
    this.jdField_a_of_type_ComTencentAvBusinessManagerZimuARZimuTask$IARZimuShowPlayer = paramIARZimuShowPlayer;
  }
  
  protected void a(Observable paramObservable, Object paramObject) {}
  
  public void b()
  {
    if (this.jdField_a_of_type_Jhe != null) {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.b(this.jdField_a_of_type_Jhe);
    }
  }
  
  public String c()
  {
    Object localObject = d();
    localObject = (ZimuItem)this.jdField_a_of_type_ComTencentAvBusinessManagerZimuEffectZimuManager.a((String)localObject);
    if (localObject != null) {}
    for (localObject = this.jdField_a_of_type_ComTencentAvBusinessManagerZimuEffectZimuManager.b((EffectConfigBase.ItemBase)localObject);; localObject = "")
    {
      AVLog.c("ARZimuTask", "getGamePlayResoucePath path = " + (String)localObject);
      return localObject;
    }
  }
  
  protected void c()
  {
    File localFile;
    if ((this.jdField_a_of_type_AndroidGraphicsTypeface == null) && (this.jdField_a_of_type_ComTencentAvBusinessManagerZimuEffectZimuManager != null))
    {
      Object localObject = d();
      localObject = (ZimuItem)this.jdField_a_of_type_ComTencentAvBusinessManagerZimuEffectZimuManager.a((String)localObject);
      if (localObject != null)
      {
        localObject = this.jdField_a_of_type_ComTencentAvBusinessManagerZimuEffectZimuManager.b((EffectConfigBase.ItemBase)localObject);
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          localFile = new File((String)localObject + "font.ttf");
          if (!localFile.exists()) {
            break label101;
          }
        }
      }
    }
    try
    {
      this.jdField_a_of_type_AndroidGraphicsTypeface = Typeface.createFromFile(localFile);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      return;
    }
    label101:
    AVLog.c("ARZimuTask", "createTypeface error, font is not found path = " + localException);
  }
  
  public abstract String d();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.av.business.manager.zimu.ARZimuTask
 * JD-Core Version:    0.7.0.1
 */