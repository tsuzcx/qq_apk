package com.tencent.aelight.camera.aioeditor.capture.text;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.aelight.camera.aioeditor.capture.QIMManager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.List<Ljava.lang.String;>;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class DynamicTextBuilder
{
  private static final String jdField_a_of_type_JavaLangString = "DynamicTextBuilder";
  private static final Map<Integer, List<String>> jdField_a_of_type_JavaUtilMap = new HashMap();
  private DynamicTextConfigManager jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureTextDynamicTextConfigManager;
  private ConcurrentHashMap<String, Typeface> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private ConcurrentHashMap<Integer, Bitmap> b = new ConcurrentHashMap();
  
  static
  {
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(0), Collections.singletonList(HardCodeUtil.a(2131689718)));
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(1), Collections.singletonList("Hi (•ω•)"));
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(3), Collections.singletonList(HardCodeUtil.a(2131703757)));
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(4), Collections.singletonList(HardCodeUtil.a(2131703770)));
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(5), Arrays.asList(new String[] { HardCodeUtil.a(2131703745), "MY JOURNEY" }));
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(7), Collections.singletonList(HardCodeUtil.a(2131703744)));
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(8), Collections.singletonList(HardCodeUtil.a(2131703767)));
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(11), Collections.singletonList(HardCodeUtil.a(2131703762)));
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(15), Collections.singletonList(HardCodeUtil.a(2131703763)));
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(16), Collections.singletonList(HardCodeUtil.a(2131703749)));
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(17), Collections.singletonList(HardCodeUtil.a(2131703773)));
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(19), Collections.singletonList(HardCodeUtil.a(2131703768)));
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(20), Collections.singletonList("superich"));
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(21), Collections.singletonList(HardCodeUtil.a(2131703758)));
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(24), Collections.singletonList("街头，\n艺术家。"));
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(26), Collections.singletonList(HardCodeUtil.a(2131703750)));
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(27), Arrays.asList(new String[] { "悠闲的\n下午。", "jenny" }));
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(31), Collections.singletonList(HardCodeUtil.a(2131689721)));
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(30), Collections.singletonList(HardCodeUtil.a(2131689717)));
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(32), Collections.singletonList(HardCodeUtil.a(2131689720)));
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(33), Collections.singletonList(HardCodeUtil.a(2131689719)));
    ThreadManager.post(new DynamicTextBuilder.1(), 5, null, false);
  }
  
  public static int a(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getIconDrawable type is: ");
      localStringBuilder.append(paramInt);
      QLog.i("DText", 2, localStringBuilder.toString());
    }
    int i = 2130844556;
    switch (paramInt)
    {
    case 2: 
    case 6: 
    case 9: 
    case 10: 
    case 12: 
    case 13: 
    case 14: 
    case 18: 
    case 22: 
    case 23: 
    case 25: 
    case 28: 
    case 29: 
    default: 
      return 2130844556;
    case 33: 
      return 2130844551;
    case 32: 
      return 2130844564;
    case 31: 
      return 2130844565;
    case 30: 
      return 2130844539;
    case 27: 
      return 2130844559;
    case 26: 
      return 2130844552;
    case 24: 
      return 2130844558;
    case 21: 
      return 2130844557;
    case 20: 
      return 2130844563;
    case 19: 
      return 2130844542;
    case 17: 
      return 2130844550;
    case 16: 
      return 2130844554;
    case 15: 
      return 2130844549;
    case 11: 
      return 2130844535;
    case 8: 
      return 2130844544;
    case 7: 
      return 2130844561;
    case 5: 
      return 2130844546;
    case 4: 
      return 2130844547;
    case 3: 
      return 2130844545;
    case 1: 
      i = 2130844543;
    }
    return i;
  }
  
  public static String a(int paramInt)
  {
    switch (paramInt)
    {
    case 2: 
    case 6: 
    case 9: 
    case 10: 
    case 12: 
    case 13: 
    case 14: 
    case 18: 
    case 22: 
    case 23: 
    case 25: 
    default: 
      return null;
    case 27: 
      return HardCodeUtil.a(2131703752);
    case 26: 
      return HardCodeUtil.a(2131703769);
    case 24: 
      return HardCodeUtil.a(2131703755);
    case 21: 
      return HardCodeUtil.a(2131703753);
    case 20: 
      return "superich";
    case 19: 
      return HardCodeUtil.a(2131703754);
    case 17: 
      return HardCodeUtil.a(2131703746);
    case 16: 
      return HardCodeUtil.a(2131703772);
    case 15: 
      return HardCodeUtil.a(2131703748);
    case 11: 
      return HardCodeUtil.a(2131703751);
    case 8: 
      return HardCodeUtil.a(2131703764);
    case 7: 
      return HardCodeUtil.a(2131703765);
    case 5: 
      return HardCodeUtil.a(2131703761);
    case 4: 
      return HardCodeUtil.a(2131703766);
    case 3: 
      return HardCodeUtil.a(2131703759);
    case 1: 
      return "Hi";
    }
    return HardCodeUtil.a(2131703760);
  }
  
  public static String a(int paramInt1, int paramInt2)
  {
    List localList = a(paramInt1);
    if ((localList != null) && (paramInt2 >= 0) && (paramInt2 < localList.size())) {
      return (String)localList.get(paramInt2);
    }
    return "";
  }
  
  public static List<String> a(int paramInt)
  {
    if (jdField_a_of_type_JavaUtilMap.containsKey(Integer.valueOf(paramInt))) {
      return (List)jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(paramInt));
    }
    return null;
  }
  
  public static List<String> a(List<String> paramList, @NonNull DynamicTextItem paramDynamicTextItem)
  {
    ArrayList localArrayList = paramDynamicTextItem.a();
    if (!localArrayList.isEmpty())
    {
      int j = 0;
      if (TextUtils.isEmpty((CharSequence)localArrayList.get(0))) {
        return paramList;
      }
      Iterator localIterator = localArrayList.iterator();
      int i;
      if (localIterator.hasNext())
      {
        localIterator.next();
        i = 1;
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          if ((str != null) && (str.equals(a(paramDynamicTextItem.c(), i)))) {
            localIterator.remove();
          }
          i += 1;
        }
      }
      if (paramList != null)
      {
        if (paramList.isEmpty()) {
          return localArrayList;
        }
        i = localArrayList.size();
        int m = paramList.size();
        int k = Math.min(i, paramDynamicTextItem.a());
        i = j;
        for (;;)
        {
          j = k;
          if (i >= k) {
            break;
          }
          if (i >= m)
          {
            j = k;
            break;
          }
          if (((String)localArrayList.get(i)).equals(a(paramDynamicTextItem.c(), i))) {
            localArrayList.set(i, paramList.get(i));
          }
          i += 1;
        }
        while (j < m)
        {
          localArrayList.add(paramList.get(j));
          j += 1;
        }
      }
      return localArrayList;
    }
    return paramList;
  }
  
  public int a(DynamicTextItem paramDynamicTextItem)
  {
    if (NormalTextItem.class.isInstance(paramDynamicTextItem))
    {
      if ((paramDynamicTextItem instanceof NormalChangeTextItem)) {
        return 31;
      }
      if ((paramDynamicTextItem instanceof NormalRectTagTextItem)) {
        return 32;
      }
      if ((paramDynamicTextItem instanceof NormalBigTextItem)) {
        return 30;
      }
      if (NormalHighLightTextItem.class.isInstance(paramDynamicTextItem)) {
        return 33;
      }
    }
    else
    {
      if (BubbleTextItem.class.isInstance(paramDynamicTextItem)) {
        return 1;
      }
      if (FringesTextItems.class.isInstance(paramDynamicTextItem)) {
        return 3;
      }
      if (RandomSizeTextItem.class.isInstance(paramDynamicTextItem)) {
        return 4;
      }
      if (JourneyTextItem.class.isInstance(paramDynamicTextItem)) {
        return 5;
      }
      if (ShadowBubbleTextItem.class.isInstance(paramDynamicTextItem)) {
        return 7;
      }
      if (FoldOverTextItem.class.isInstance(paramDynamicTextItem)) {
        return 8;
      }
      if (ApathyTextItem.class.isInstance(paramDynamicTextItem)) {
        return 11;
      }
      if (GridTextItem.class.isInstance(paramDynamicTextItem)) {
        return 17;
      }
      if (FoodAloneTextItem.class.isInstance(paramDynamicTextItem)) {
        return 15;
      }
      if (LangTextItem.class.isInstance(paramDynamicTextItem)) {
        return 16;
      }
      if (BoldTextItem.class.isInstance(paramDynamicTextItem)) {
        return 19;
      }
      if (IDonotCareTextItem.class.isInstance(paramDynamicTextItem)) {
        return 26;
      }
      if (SuperRichTextItem.class.isInstance(paramDynamicTextItem)) {
        return 20;
      }
      if (RailSakuraTextItem.class.isInstance(paramDynamicTextItem)) {
        return 24;
      }
      if (RelaxedAfternoon.class.isInstance(paramDynamicTextItem)) {
        return 27;
      }
      if (BasicTextRegionTextItem.class.isInstance(paramDynamicTextItem)) {
        return ((BasicTextRegionTextItem)paramDynamicTextItem).c();
      }
    }
    return 0;
  }
  
  public <T extends DynamicTextItem> T a(int paramInt, @NonNull List<String> paramList)
  {
    if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureTextDynamicTextConfigManager == null) {
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureTextDynamicTextConfigManager = ((DynamicTextConfigManager)QIMManager.a(7));
    }
    Object localObject4 = new ArrayList();
    if (paramList != null)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        ((List)localObject4).add((String)paramList.next());
      }
    }
    if (((List)localObject4).isEmpty())
    {
      paramList = a(paramInt);
      if (paramList != null) {
        localObject4 = paramList;
      }
    }
    Object localObject12 = this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureTextDynamicTextConfigManager.a(String.valueOf(paramInt));
    Object localObject10 = null;
    Object localObject1;
    Object localObject3;
    if (localObject12 != null)
    {
      if (((DynamicTextConfigManager.DynamicTextConfigBean)localObject12).fontInfos.isEmpty()) {
        paramList = null;
      } else {
        paramList = (DynamicTextConfigManager.DynamicTextConfigBean.DynamicTextFontInfo)((DynamicTextConfigManager.DynamicTextConfigBean)localObject12).fontInfos.get(0);
      }
      if (paramList != null) {
        localObject1 = (Typeface)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramList.c);
      } else {
        localObject1 = null;
      }
      localObject3 = paramList;
    }
    else
    {
      localObject1 = null;
      localObject3 = localObject1;
    }
    Object localObject5;
    Object localObject7;
    Object localObject8;
    Object localObject2;
    Object localObject11;
    Object localObject9;
    switch (paramInt)
    {
    case 2: 
    case 6: 
    case 9: 
    case 10: 
    case 12: 
    case 13: 
    case 14: 
    case 18: 
    case 22: 
    case 23: 
    case 25: 
    case 28: 
    case 29: 
    default: 
      paramList = new StringBuilder();
      paramList.append("invalid text type");
      paramList.append(paramInt);
      paramList = paramList.toString();
      if (QLog.isColorLevel())
      {
        localObject5 = jdField_a_of_type_JavaLangString;
        localObject10 = new StringBuilder();
        ((StringBuilder)localObject10).append("DynamicTextBuilder : ");
        ((StringBuilder)localObject10).append(paramList);
        QLog.i((String)localObject5, 2, ((StringBuilder)localObject10).toString());
      }
      break;
    case 33: 
      paramList = new NormalHighLightTextItem(paramInt, (List)localObject4);
      break;
    case 32: 
      paramList = new NormalRectTagTextItem(paramInt, (List)localObject4);
      break;
    case 31: 
      paramList = new NormalChangeTextItem(paramInt, (List)localObject4);
      break;
    case 30: 
      paramList = new NormalBigTextItem(paramInt, (List)localObject4);
      break;
    case 27: 
      paramList = (List<String>)localObject1;
      if (localObject1 == null)
      {
        localObject5 = new StringBuilder();
        ((StringBuilder)localObject5).append(this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureTextDynamicTextConfigManager.b((DynamicTextConfigManager.DynamicTextConfigBean.DynamicTextFontInfo)localObject3));
        ((StringBuilder)localObject5).append("dynamic_text.ttf");
        paramList = (List<String>)localObject1;
        if (FileUtil.b(((StringBuilder)localObject5).toString())) {
          try
          {
            paramList = new StringBuilder();
            paramList.append(this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureTextDynamicTextConfigManager.b((DynamicTextConfigManager.DynamicTextConfigBean.DynamicTextFontInfo)localObject3));
            paramList.append("dynamic_text.ttf");
            paramList = Typeface.createFromFile(paramList.toString());
          }
          catch (Exception localException2)
          {
            paramList = (List<String>)localObject1;
            if (QLog.isColorLevel())
            {
              QLog.i(jdField_a_of_type_JavaLangString, 2, localException2.toString());
              paramList = (List<String>)localObject1;
            }
          }
        }
      }
      if (QLog.isColorLevel()) {
        QLog.i(jdField_a_of_type_JavaLangString, 2, "added new rich super : ");
      }
      localObject4 = new RelaxedAfternoon(paramInt, (List)localObject4, paramList);
      localObject1 = paramList;
      paramList = (List<String>)localObject4;
      break;
    case 26: 
      paramList = (Bitmap)this.b.get(Integer.valueOf(2130844541));
      Object localObject6 = paramList;
      if (paramList == null)
      {
        localObject6 = BitmapFactory.decodeResource(BaseApplicationImpl.getContext().getResources(), 2130844541);
        this.b.put(Integer.valueOf(2130844541), localObject6);
      }
      paramList = (Bitmap)this.b.get(Integer.valueOf(2130844540));
      localObject10 = paramList;
      if (paramList == null)
      {
        localObject10 = BitmapFactory.decodeResource(BaseApplicationImpl.getContext().getResources(), 2130844540);
        this.b.put(Integer.valueOf(2130844540), localObject10);
      }
      if (localObject1 == null) {
        try
        {
          paramList = new StringBuilder();
          paramList.append(this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureTextDynamicTextConfigManager.b((DynamicTextConfigManager.DynamicTextConfigBean.DynamicTextFontInfo)localObject3));
          paramList.append("dynamic_text.ttf");
          paramList = Typeface.createFromFile(paramList.toString());
        }
        catch (Exception paramList)
        {
          if (QLog.isColorLevel()) {
            QLog.i(jdField_a_of_type_JavaLangString, 2, paramList.getMessage(), paramList);
          }
        }
      } else {
        paramList = (List<String>)localObject1;
      }
      localObject4 = new IDonotCareTextItem(paramInt, (List)localObject4, (Bitmap)localObject10, (Bitmap)localObject6, paramList);
      localObject1 = paramList;
      paramList = (List<String>)localObject4;
      break;
    case 24: 
      paramList = (List<String>)localObject1;
      if (localObject1 == null) {
        try
        {
          paramList = new StringBuilder();
          paramList.append(this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureTextDynamicTextConfigManager.b((DynamicTextConfigManager.DynamicTextConfigBean.DynamicTextFontInfo)localObject3));
          paramList.append("dynamic_text.ttf");
          paramList = Typeface.createFromFile(paramList.toString());
        }
        catch (Exception localException3)
        {
          paramList = (List<String>)localObject1;
          if (QLog.isColorLevel())
          {
            QLog.i(jdField_a_of_type_JavaLangString, 2, localException3.getMessage(), localException3);
            paramList = (List<String>)localObject1;
          }
        }
      }
      localObject4 = new RailSakuraTextItem(paramInt, (List)localObject4, paramList);
      localObject1 = paramList;
      paramList = (List<String>)localObject4;
      break;
    case 21: 
      paramList = (Bitmap)this.b.get(Integer.valueOf(2130844646));
      localObject7 = paramList;
      if (paramList == null)
      {
        localObject7 = BitmapFactory.decodeResource(BaseApplicationImpl.getContext().getResources(), 2130844646);
        this.b.put(Integer.valueOf(2130844646), localObject7);
      }
      paramList = (Bitmap)this.b.get(Integer.valueOf(2130844647));
      localObject10 = paramList;
      if (paramList == null)
      {
        localObject10 = BitmapFactory.decodeResource(BaseApplicationImpl.getContext().getResources(), 2130844647);
        this.b.put(Integer.valueOf(2130844647), localObject10);
      }
      paramList = (Bitmap)this.b.get(Integer.valueOf(2130844648));
      localObject12 = paramList;
      if (paramList == null)
      {
        localObject12 = BitmapFactory.decodeResource(BaseApplicationImpl.getContext().getResources(), 2130844648);
        this.b.put(Integer.valueOf(2130844648), localObject12);
      }
      paramList = (List<String>)localObject1;
      if (localObject1 == null) {
        try
        {
          paramList = new StringBuilder();
          paramList.append(this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureTextDynamicTextConfigManager.b((DynamicTextConfigManager.DynamicTextConfigBean.DynamicTextFontInfo)localObject3));
          paramList.append("dynamic_text.ttf");
          paramList = Typeface.createFromFile(paramList.toString());
        }
        catch (Exception localException6)
        {
          paramList = (List<String>)localObject1;
          if (QLog.isColorLevel())
          {
            QLog.i(jdField_a_of_type_JavaLangString, 2, localException6.getMessage(), localException6);
            paramList = (List<String>)localObject1;
          }
        }
      }
      localObject1 = new BaseTextRegion.Builder().a(10.0F, 12.0F).a((Bitmap)localObject7).a(41.0F, 36.0F, 1, 1).a(paramList).a();
      localObject7 = new BaseTextRegion.Builder().a(12.0F, 21.0F).a((Bitmap)localObject10).a(123.0F, 33.0F, 7, 2).a(paramList).a();
      localObject10 = new BaseTextRegion.Builder().a(10.0F, 27.0F).a((Bitmap)localObject12).a(192.0F, 43.0F, 10, 8).a(paramList).a();
      localObject12 = new BasicTextRegionTextItem.Builder();
      ((BasicTextRegionTextItem.Builder)localObject12).a((BaseTextRegion)localObject1);
      ((BasicTextRegionTextItem.Builder)localObject12).a((BaseTextRegion)localObject7);
      ((BasicTextRegionTextItem.Builder)localObject12).a((BaseTextRegion)localObject10);
      ((BasicTextRegionTextItem.Builder)localObject12).a(paramList);
      ((BasicTextRegionTextItem.Builder)localObject12).a(-16777216);
      localObject4 = ((BasicTextRegionTextItem.Builder)localObject12).a(paramInt, (List)localObject4);
      localObject1 = paramList;
      paramList = (List<String>)localObject4;
      break;
    case 20: 
      paramList = (List<String>)localObject1;
      if (localObject1 == null)
      {
        localObject7 = new StringBuilder();
        ((StringBuilder)localObject7).append(this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureTextDynamicTextConfigManager.b((DynamicTextConfigManager.DynamicTextConfigBean.DynamicTextFontInfo)localObject3));
        ((StringBuilder)localObject7).append("dynamic_text.ttf");
        paramList = (List<String>)localObject1;
        if (FileUtil.b(((StringBuilder)localObject7).toString())) {
          try
          {
            paramList = new StringBuilder();
            paramList.append(this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureTextDynamicTextConfigManager.b((DynamicTextConfigManager.DynamicTextConfigBean.DynamicTextFontInfo)localObject3));
            paramList.append("dynamic_text.ttf");
            paramList = Typeface.createFromFile(paramList.toString());
          }
          catch (Exception localException4)
          {
            paramList = (List<String>)localObject1;
            if (QLog.isColorLevel())
            {
              QLog.i(jdField_a_of_type_JavaLangString, 2, localException4.toString());
              paramList = (List<String>)localObject1;
            }
          }
        }
      }
      if (QLog.isColorLevel()) {
        QLog.i(jdField_a_of_type_JavaLangString, 2, "added new rich super : ");
      }
      localObject4 = new SuperRichTextItem(paramInt, (List)localObject4, paramList);
      localObject1 = paramList;
      paramList = (List<String>)localObject4;
      break;
    case 19: 
      paramList = (List<String>)localObject1;
      if (localObject1 == null)
      {
        localObject8 = new StringBuilder();
        ((StringBuilder)localObject8).append(this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureTextDynamicTextConfigManager.b((DynamicTextConfigManager.DynamicTextConfigBean.DynamicTextFontInfo)localObject3));
        ((StringBuilder)localObject8).append("dynamic_text.ttf");
        paramList = (List<String>)localObject1;
        if (FileUtil.b(((StringBuilder)localObject8).toString())) {
          try
          {
            paramList = new StringBuilder();
            paramList.append(this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureTextDynamicTextConfigManager.b((DynamicTextConfigManager.DynamicTextConfigBean.DynamicTextFontInfo)localObject3));
            paramList.append("dynamic_text.ttf");
            paramList = Typeface.createFromFile(paramList.toString());
          }
          catch (Exception paramList)
          {
            QLog.i(jdField_a_of_type_JavaLangString, 2, Log.getStackTraceString(paramList));
            paramList = (List<String>)localObject1;
          }
        }
      }
      localObject4 = new BoldTextItem(paramInt, (List)localObject4, paramList);
      localObject1 = paramList;
      paramList = (List<String>)localObject4;
      break;
    case 17: 
      localObject8 = (Bitmap)this.b.get(Integer.valueOf(2130844644));
      paramList = (List<String>)localObject8;
      if (localObject8 == null)
      {
        paramList = BitmapFactory.decodeResource(BaseApplicationImpl.getContext().getResources(), 2130844644);
        this.b.put(Integer.valueOf(2130844644), paramList);
      }
      localObject10 = (Bitmap)this.b.get(Integer.valueOf(2130844645));
      localObject8 = localObject10;
      if (localObject10 == null)
      {
        localObject8 = BitmapFactory.decodeResource(BaseApplicationImpl.getContext().getResources(), 2130844645);
        this.b.put(Integer.valueOf(2130844645), localObject8);
      }
      localObject10 = new ArrayList(3);
      ((List)localObject10).add(paramList);
      ((List)localObject10).add(localObject8);
      paramList = (List<String>)localObject1;
      if (localObject1 == null) {
        try
        {
          paramList = new StringBuilder();
          paramList.append(this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureTextDynamicTextConfigManager.b((DynamicTextConfigManager.DynamicTextConfigBean.DynamicTextFontInfo)localObject3));
          paramList.append("dynamic_text.ttf");
          paramList = Typeface.createFromFile(paramList.toString());
        }
        catch (Exception paramList)
        {
          QLog.i(jdField_a_of_type_JavaLangString, 2, Log.getStackTraceString(paramList));
          paramList = (List<String>)localObject1;
        }
      }
      localObject4 = new GridTextItem(paramInt, (List)localObject4, paramList, (List)localObject10);
      localObject1 = paramList;
      paramList = (List<String>)localObject4;
      break;
    case 16: 
      paramList = (Bitmap)this.b.get(Integer.valueOf(2130844553));
      localObject8 = paramList;
      if (paramList == null)
      {
        localObject8 = BitmapFactory.decodeResource(BaseApplicationImpl.getContext().getResources(), 2130844553);
        this.b.put(Integer.valueOf(2130844553), localObject8);
      }
      paramList = (List<String>)localObject1;
      if (localObject1 == null) {
        try
        {
          paramList = new StringBuilder();
          paramList.append(this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureTextDynamicTextConfigManager.b((DynamicTextConfigManager.DynamicTextConfigBean.DynamicTextFontInfo)localObject3));
          paramList.append("dynamic_text.ttf");
          paramList = Typeface.createFromFile(paramList.toString());
        }
        catch (Exception paramList)
        {
          QLog.i(jdField_a_of_type_JavaLangString, 2, Log.getStackTraceString(paramList));
          paramList = (List<String>)localObject1;
        }
      }
      localObject1 = localObject10;
      if (localObject12 != null)
      {
        localObject1 = localObject10;
        if (((DynamicTextConfigManager.DynamicTextConfigBean)localObject12).fontInfos.size() > 1)
        {
          localObject1 = localObject10;
          if (((DynamicTextConfigManager.DynamicTextConfigBean)localObject12).fontInfos.get(1) != null)
          {
            localObject1 = localObject10;
            if (!TextUtils.isEmpty(((DynamicTextConfigManager.DynamicTextConfigBean.DynamicTextFontInfo)((DynamicTextConfigManager.DynamicTextConfigBean)localObject12).fontInfos.get(1)).c))
            {
              localObject10 = (Typeface)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(((DynamicTextConfigManager.DynamicTextConfigBean.DynamicTextFontInfo)((DynamicTextConfigManager.DynamicTextConfigBean)localObject12).fontInfos.get(1)).c);
              localObject1 = localObject10;
              if (localObject10 == null) {
                try
                {
                  localObject1 = new StringBuilder();
                  ((StringBuilder)localObject1).append(this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureTextDynamicTextConfigManager.b((DynamicTextConfigManager.DynamicTextConfigBean.DynamicTextFontInfo)((DynamicTextConfigManager.DynamicTextConfigBean)localObject12).fontInfos.get(1)));
                  ((StringBuilder)localObject1).append("dynamic_text.ttf");
                  localObject1 = Typeface.createFromFile(((StringBuilder)localObject1).toString());
                }
                catch (Exception localException1)
                {
                  QLog.i(jdField_a_of_type_JavaLangString, 2, Log.getStackTraceString(localException1));
                  localObject2 = localObject10;
                }
              }
            }
          }
        }
      }
      localObject4 = new LangTextItem(paramInt, (List)localObject4, paramList, (Typeface)localObject2, (Bitmap)localObject8);
      localObject2 = paramList;
      paramList = (List<String>)localObject4;
      break;
    case 15: 
      paramList = (Bitmap)this.b.get(Integer.valueOf(2130844548));
      localObject8 = paramList;
      if (paramList == null)
      {
        localObject8 = BitmapFactory.decodeResource(BaseApplicationImpl.getContext().getResources(), 2130844548);
        this.b.put(Integer.valueOf(2130844548), localObject8);
      }
      paramList = (List<String>)localObject2;
      if (localObject2 == null) {
        try
        {
          paramList = new StringBuilder();
          paramList.append(this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureTextDynamicTextConfigManager.b((DynamicTextConfigManager.DynamicTextConfigBean.DynamicTextFontInfo)localObject3));
          paramList.append("dynamic_text.ttf");
          paramList = Typeface.createFromFile(paramList.toString());
        }
        catch (Exception paramList)
        {
          QLog.i(jdField_a_of_type_JavaLangString, 2, Log.getStackTraceString(paramList));
          paramList = (List<String>)localObject2;
        }
      }
      localObject4 = new FoodAloneTextItem(paramInt, (List)localObject4, paramList, (Bitmap)localObject8);
      localObject2 = paramList;
      paramList = (List<String>)localObject4;
      break;
    case 11: 
      paramList = (Bitmap)this.b.get(Integer.valueOf(2130844536));
      localObject10 = (Bitmap)this.b.get(Integer.valueOf(2130844538));
      localObject12 = (Bitmap)this.b.get(Integer.valueOf(2130844537));
      localObject8 = paramList;
      if (paramList == null)
      {
        localObject8 = BitmapFactory.decodeResource(BaseApplicationImpl.getContext().getResources(), 2130844536);
        localObject10 = BitmapFactory.decodeResource(BaseApplicationImpl.getContext().getResources(), 2130844538);
        localObject12 = BitmapFactory.decodeResource(BaseApplicationImpl.getContext().getResources(), 2130844537);
      }
      if (localObject2 == null) {
        try
        {
          paramList = new StringBuilder();
          paramList.append(this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureTextDynamicTextConfigManager.b((DynamicTextConfigManager.DynamicTextConfigBean.DynamicTextFontInfo)localObject3));
          paramList.append("dynamic_text.ttf");
          paramList = Typeface.createFromFile(paramList.toString());
        }
        catch (Exception paramList)
        {
          QLog.i(jdField_a_of_type_JavaLangString, 2, Log.getStackTraceString(paramList));
        }
      } else {
        paramList = (List<String>)localObject2;
      }
      localObject4 = new ApathyTextItem(paramInt, (List)localObject4, paramList, (Bitmap)localObject8, (Bitmap)localObject10, (Bitmap)localObject12);
      localObject2 = paramList;
      paramList = (List<String>)localObject4;
      break;
    case 8: 
      paramList = (Bitmap)this.b.get(Integer.valueOf(2130844580));
      localObject8 = paramList;
      if (paramList == null)
      {
        localObject8 = BitmapFactory.decodeResource(BaseApplicationImpl.getContext().getResources(), 2130844580);
        this.b.put(Integer.valueOf(2130844580), localObject8);
      }
      paramList = (List<String>)localObject2;
      if (localObject2 == null) {
        try
        {
          paramList = new StringBuilder();
          paramList.append(this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureTextDynamicTextConfigManager.b((DynamicTextConfigManager.DynamicTextConfigBean.DynamicTextFontInfo)localObject3));
          paramList.append("dynamic_text.ttf");
          paramList = Typeface.createFromFile(paramList.toString());
        }
        catch (RuntimeException localRuntimeException)
        {
          paramList = (List<String>)localObject2;
          if (QLog.isColorLevel())
          {
            QLog.e(jdField_a_of_type_JavaLangString, 2, Log.getStackTraceString(localRuntimeException));
            paramList = (List<String>)localObject2;
          }
        }
      }
      localObject4 = new FoldOverTextItem(paramInt, (List)localObject4, paramList, (Bitmap)localObject8);
      localObject2 = paramList;
      paramList = (List<String>)localObject4;
      break;
    case 7: 
      localObject8 = (Bitmap)this.b.get(Integer.valueOf(2130844649));
      paramList = (List<String>)localObject8;
      if (localObject8 == null)
      {
        paramList = BitmapFactory.decodeResource(BaseApplicationImpl.getContext().getResources(), 2130844649);
        this.b.put(Integer.valueOf(2130844649), paramList);
      }
      localObject11 = (Bitmap)this.b.get(Integer.valueOf(2130844650));
      localObject8 = localObject11;
      if (localObject11 == null)
      {
        localObject8 = BitmapFactory.decodeResource(BaseApplicationImpl.getContext().getResources(), 2130844650);
        this.b.put(Integer.valueOf(2130844650), localObject8);
      }
      localObject12 = (Bitmap)this.b.get(Integer.valueOf(2130844651));
      localObject11 = localObject12;
      if (localObject12 == null)
      {
        localObject11 = BitmapFactory.decodeResource(BaseApplicationImpl.getContext().getResources(), 2130844651);
        this.b.put(Integer.valueOf(2130844651), localObject11);
      }
      localObject12 = new ArrayList(3);
      ((List)localObject12).add(paramList);
      ((List)localObject12).add(localObject8);
      ((List)localObject12).add(localObject11);
      paramList = (List<String>)localObject2;
      if (localObject2 == null) {
        try
        {
          paramList = new StringBuilder();
          paramList.append(this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureTextDynamicTextConfigManager.b((DynamicTextConfigManager.DynamicTextConfigBean.DynamicTextFontInfo)localObject3));
          paramList.append("dynamic_text.ttf");
          paramList = Typeface.createFromFile(paramList.toString());
        }
        catch (Exception localException5)
        {
          paramList = (List<String>)localObject2;
          if (QLog.isColorLevel())
          {
            QLog.i(jdField_a_of_type_JavaLangString, 2, localException5.getMessage(), localException5);
            paramList = (List<String>)localObject2;
          }
        }
      }
      localObject4 = new ShadowBubbleTextItem(paramInt, paramList, (List)localObject4, (List)localObject12);
      localObject2 = paramList;
      paramList = (List<String>)localObject4;
      break;
    case 5: 
      localObject11 = (Bitmap)this.b.get(Integer.valueOf(2130844587));
      localObject9 = (Bitmap)this.b.get(Integer.valueOf(2130844586));
      paramList = (List<String>)localObject11;
      if (localObject11 == null)
      {
        paramList = BitmapFactory.decodeResource(BaseApplicationImpl.getContext().getResources(), 2130844587);
        localObject9 = BitmapFactory.decodeResource(BaseApplicationImpl.getContext().getResources(), 2130844586);
      }
      paramList = new JourneyTextItem(paramInt, (List)localObject4, paramList, (Bitmap)localObject9);
      break;
    case 4: 
      paramList = (List<String>)localObject2;
      if (localObject2 == null) {
        try
        {
          paramList = new StringBuilder();
          paramList.append(this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureTextDynamicTextConfigManager.b((DynamicTextConfigManager.DynamicTextConfigBean.DynamicTextFontInfo)localObject3));
          paramList.append("dynamic_text.ttf");
          paramList = Typeface.createFromFile(paramList.toString());
        }
        catch (Exception paramList)
        {
          QLog.i(jdField_a_of_type_JavaLangString, 2, Log.getStackTraceString(paramList));
          paramList = (List<String>)localObject2;
        }
      }
      localObject4 = new RandomSizeTextItem(BaseApplicationImpl.getContext(), paramInt, (List)localObject4, paramList);
      localObject2 = paramList;
      paramList = (List<String>)localObject4;
      break;
    case 3: 
      paramList = (Bitmap)this.b.get(Integer.valueOf(2130844566));
      localObject9 = (Bitmap)this.b.get(Integer.valueOf(2130844567));
      if (localObject2 == null)
      {
        try
        {
          paramList = new StringBuilder();
          paramList.append(this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureTextDynamicTextConfigManager.b((DynamicTextConfigManager.DynamicTextConfigBean.DynamicTextFontInfo)localObject3));
          paramList.append("dynamic_text.ttf");
          paramList = Typeface.createFromFile(paramList.toString());
          localObject2 = paramList;
        }
        catch (Exception paramList)
        {
          QLog.i(jdField_a_of_type_JavaLangString, 2, Log.getStackTraceString(paramList));
        }
        paramList = BitmapFactory.decodeResource(BaseApplicationImpl.getContext().getResources(), 2130844566);
        localObject9 = BitmapFactory.decodeResource(BaseApplicationImpl.getContext().getResources(), 2130844567);
        this.b.put(Integer.valueOf(2130844566), paramList);
        this.b.put(Integer.valueOf(2130844567), localObject9);
      }
      paramList = new FringesTextItems(paramInt, (List)localObject4, (Typeface)localObject2, paramList, (Bitmap)localObject9);
      break;
    case 1: 
      localObject11 = (Bitmap)this.b.get(Integer.valueOf(2130844643));
      if (localObject2 != null)
      {
        localObject9 = localObject11;
        paramList = (List<String>)localObject2;
        if (localObject11 != null) {}
      }
      else
      {
        try
        {
          paramList = new StringBuilder();
          paramList.append(this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureTextDynamicTextConfigManager.b((DynamicTextConfigManager.DynamicTextConfigBean.DynamicTextFontInfo)localObject3));
          paramList.append("dynamic_text.ttf");
          paramList = Typeface.createFromFile(paramList.toString());
        }
        catch (Exception paramList)
        {
          QLog.i(jdField_a_of_type_JavaLangString, 2, Log.getStackTraceString(paramList));
          paramList = (List<String>)localObject2;
        }
        localObject9 = BitmapFactory.decodeResource(BaseApplicationImpl.getContext().getResources(), 2130844643);
        this.b.put(Integer.valueOf(2130844643), localObject9);
      }
      localObject4 = new BubbleTextItem(paramInt, (List)localObject4, paramList, (Bitmap)localObject9);
      localObject2 = paramList;
      paramList = (List<String>)localObject4;
      break;
    case 0: 
      paramList = new NormalTextItem(paramInt, (List)localObject4);
      break;
    }
    paramList = new NormalTextItem(paramInt, (List)localObject4);
    if ((localObject2 != null) && (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(paramInt)) == null) && (localObject3 != null)) {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(((DynamicTextConfigManager.DynamicTextConfigBean.DynamicTextFontInfo)localObject3).c, localObject2);
    }
    return paramList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.capture.text.DynamicTextBuilder
 * JD-Core Version:    0.7.0.1
 */