import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.capture.text.DynamicTextBuilder.1;
import dov.com.qq.im.capture.text.DynamicTextConfigManager;
import dov.com.qq.im.capture.text.DynamicTextConfigManager.DynamicTextConfigBean;
import dov.com.qq.im.capture.text.DynamicTextItem;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.List<Ljava.lang.String;>;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class bpse
{
  private static final String jdField_a_of_type_JavaLangString = bpse.class.getSimpleName();
  private static final Map<Integer, List<String>> jdField_a_of_type_JavaUtilMap = new HashMap();
  private DynamicTextConfigManager jdField_a_of_type_DovComQqImCaptureTextDynamicTextConfigManager;
  private ConcurrentHashMap<String, Typeface> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private ConcurrentHashMap<Integer, Bitmap> b = new ConcurrentHashMap();
  
  static
  {
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(0), Collections.singletonList(anzj.a(2131702482)));
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(1), Collections.singletonList("Hi (•ω•)"));
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(3), Collections.singletonList(anzj.a(2131702492)));
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(4), Collections.singletonList(anzj.a(2131702505)));
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(5), Arrays.asList(new String[] { anzj.a(2131702480), "MY JOURNEY" }));
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(7), Collections.singletonList(anzj.a(2131702479)));
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(8), Collections.singletonList(anzj.a(2131702502)));
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(11), Collections.singletonList(anzj.a(2131702497)));
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(15), Collections.singletonList(anzj.a(2131702498)));
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(16), Collections.singletonList(anzj.a(2131702484)));
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(17), Collections.singletonList(anzj.a(2131702508)));
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(19), Collections.singletonList(anzj.a(2131702503)));
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(20), Collections.singletonList("superich"));
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(21), Collections.singletonList(anzj.a(2131702493)));
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(24), Collections.singletonList("街头，\n艺术家。"));
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(26), Collections.singletonList(anzj.a(2131702485)));
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(27), Arrays.asList(new String[] { "悠闲的\n下午。", "jenny" }));
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(28), Collections.singletonList(anzj.a(2131702506)));
    ThreadManager.post(new DynamicTextBuilder.1(), 5, null, false);
  }
  
  public static int a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("DText", 2, "getIconDrawable type is: " + paramInt);
    }
    switch (paramInt)
    {
    case 0: 
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
      return 2130844527;
    case 28: 
      return 2130844506;
    case 1: 
      return 2130844515;
    case 3: 
      return 2130844517;
    case 4: 
      return 2130844519;
    case 5: 
      return 2130844518;
    case 7: 
      return 2130844532;
    case 8: 
      return 2130844516;
    case 11: 
      return 2130844507;
    case 15: 
      return 2130844521;
    case 16: 
      return 2130844525;
    case 17: 
      return 2130844522;
    case 19: 
      return 2130844513;
    case 20: 
      return 2130844534;
    case 26: 
      return 2130844523;
    case 24: 
      return 2130844529;
    case 27: 
      return 2130844530;
    }
    return 2130844528;
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
    case 0: 
      return anzj.a(2131702495);
    case 1: 
      return "Hi";
    case 3: 
      return anzj.a(2131702494);
    case 4: 
      return anzj.a(2131702501);
    case 5: 
      return anzj.a(2131702496);
    case 7: 
      return anzj.a(2131702500);
    case 8: 
      return anzj.a(2131702499);
    case 11: 
      return anzj.a(2131702486);
    case 15: 
      return anzj.a(2131702483);
    case 16: 
      return anzj.a(2131702507);
    case 17: 
      return anzj.a(2131702481);
    case 19: 
      return anzj.a(2131702489);
    case 20: 
      return "superich";
    case 21: 
      return anzj.a(2131702488);
    case 24: 
      return anzj.a(2131702490);
    case 26: 
      return anzj.a(2131702504);
    }
    return anzj.a(2131702487);
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
    List localList = null;
    if (jdField_a_of_type_JavaUtilMap.containsKey(Integer.valueOf(paramInt))) {
      localList = (List)jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(paramInt));
    }
    return localList;
  }
  
  public static List<String> a(List<String> paramList, @NonNull DynamicTextItem paramDynamicTextItem)
  {
    int j = 0;
    ArrayList localArrayList = paramDynamicTextItem.a();
    if ((localArrayList.isEmpty()) || (TextUtils.isEmpty((CharSequence)localArrayList.get(0)))) {
      return paramList;
    }
    Iterator localIterator = localArrayList.iterator();
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
    if ((paramList == null) || (paramList.isEmpty())) {
      return localArrayList;
    }
    int i = localArrayList.size();
    int m = paramList.size();
    int k = Math.min(i, paramDynamicTextItem.a());
    i = j;
    for (;;)
    {
      if ((i >= k) || (i >= m))
      {
        i = k;
        while (i < m)
        {
          localArrayList.add(paramList.get(i));
          i += 1;
        }
      }
      if (((String)localArrayList.get(i)).equals(a(paramDynamicTextItem.c(), i))) {
        localArrayList.set(i, paramList.get(i));
      }
      i += 1;
    }
    return localArrayList;
  }
  
  public static void a(int paramInt, List<String> paramList)
  {
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(paramInt), paramList);
  }
  
  public int a(DynamicTextItem paramDynamicTextItem)
  {
    int i = 0;
    if (bptf.class.isInstance(paramDynamicTextItem)) {
      if ((paramDynamicTextItem instanceof bpte)) {
        i = 28;
      }
    }
    do
    {
      return i;
      if (bpsa.class.isInstance(paramDynamicTextItem)) {
        return 1;
      }
      if (bpst.class.isInstance(paramDynamicTextItem)) {
        return 3;
      }
      if (bptl.class.isInstance(paramDynamicTextItem)) {
        return 4;
      }
      if (bpsw.class.isInstance(paramDynamicTextItem)) {
        return 5;
      }
      if (bptq.class.isInstance(paramDynamicTextItem)) {
        return 7;
      }
      if (bpsn.class.isInstance(paramDynamicTextItem)) {
        return 8;
      }
      if (bpro.class.isInstance(paramDynamicTextItem)) {
        return 11;
      }
      if (bpsu.class.isInstance(paramDynamicTextItem)) {
        return 17;
      }
      if (bpsq.class.isInstance(paramDynamicTextItem)) {
        return 15;
      }
      if (bpta.class.isInstance(paramDynamicTextItem)) {
        return 16;
      }
      if (bprz.class.isInstance(paramDynamicTextItem)) {
        return 19;
      }
      if (bpsv.class.isInstance(paramDynamicTextItem)) {
        return 26;
      }
      if (bptu.class.isInstance(paramDynamicTextItem)) {
        return 20;
      }
      if (bptk.class.isInstance(paramDynamicTextItem)) {
        return 24;
      }
      if (bpto.class.isInstance(paramDynamicTextItem)) {
        return 27;
      }
    } while (!bprw.class.isInstance(paramDynamicTextItem));
    return ((bprw)paramDynamicTextItem).c();
  }
  
  public <T extends DynamicTextItem> T a(int paramInt, @NonNull List<String> paramList)
  {
    Object localObject11 = null;
    if (this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextConfigManager == null) {
      this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextConfigManager = ((DynamicTextConfigManager)bplq.a(7));
    }
    Object localObject10 = new ArrayList();
    if (paramList != null)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        ((List)localObject10).add((String)paramList.next());
      }
    }
    if (((List)localObject10).isEmpty())
    {
      paramList = a(paramInt);
      if (paramList != null) {
        localObject10 = paramList;
      }
    }
    for (;;)
    {
      Object localObject14 = this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextConfigManager.a(String.valueOf(paramInt));
      Object localObject1;
      List<String> localList;
      if (localObject14 != null) {
        if (((DynamicTextConfigManager.DynamicTextConfigBean)localObject14).fontInfos.isEmpty())
        {
          paramList = null;
          if (paramList == null) {
            break label3241;
          }
          localObject1 = (Typeface)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramList.c);
          localList = paramList;
          paramList = (List<String>)localObject1;
        }
      }
      for (;;)
      {
        Object localObject8;
        label526:
        Object localObject2;
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
          localObject1 = "invalid text type" + paramInt;
          if (QLog.isColorLevel()) {
            QLog.i(jdField_a_of_type_JavaLangString, 2, "DynamicTextBuilder : " + (String)localObject1);
          }
          localObject1 = new bptf(paramInt, (List)localObject10);
        case 0: 
        case 28: 
        case 1: 
          for (;;)
          {
            if ((paramList != null) && (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(paramInt)) == null) && (localList != null)) {
              this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(localList.c, paramList);
            }
            return localObject1;
            paramList = (bpsf)((DynamicTextConfigManager.DynamicTextConfigBean)localObject14).fontInfos.get(0);
            break;
            localObject1 = new bptf(paramInt, (List)localObject10);
            continue;
            localObject1 = new bpte(paramInt, (List)localObject10);
            continue;
            localObject11 = (Bitmap)this.b.get(Integer.valueOf(2130844663));
            if (paramList != null)
            {
              localObject1 = localObject11;
              localObject8 = paramList;
              if (localObject11 != null) {
                break label526;
              }
            }
            try
            {
              localObject1 = Typeface.createFromFile(this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextConfigManager.b(localList) + "dynamic_text.ttf");
              paramList = (List<String>)localObject1;
            }
            catch (Exception localException1)
            {
              for (;;)
              {
                QLog.i(jdField_a_of_type_JavaLangString, 2, Log.getStackTraceString(localException1));
              }
            }
            localObject1 = BitmapFactory.decodeResource(BaseApplicationImpl.getContext().getResources(), 2130844663);
            this.b.put(Integer.valueOf(2130844663), localObject1);
            localObject8 = paramList;
            localObject1 = new bpsa(paramInt, (List)localObject10, (Typeface)localObject8, (Bitmap)localObject1);
            paramList = (List<String>)localObject8;
          }
        case 3: 
          localObject8 = (Bitmap)this.b.get(Integer.valueOf(2130844535));
          localObject2 = (Bitmap)this.b.get(Integer.valueOf(2130844536));
          if (paramList == null)
          {
            try
            {
              localObject2 = Typeface.createFromFile(this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextConfigManager.b(localList) + "dynamic_text.ttf");
              paramList = (List<String>)localObject2;
            }
            catch (Exception localException2)
            {
              for (;;)
              {
                QLog.i(jdField_a_of_type_JavaLangString, 2, Log.getStackTraceString(localException2));
              }
            }
            localObject8 = BitmapFactory.decodeResource(BaseApplicationImpl.getContext().getResources(), 2130844535);
            localObject2 = BitmapFactory.decodeResource(BaseApplicationImpl.getContext().getResources(), 2130844536);
            this.b.put(Integer.valueOf(2130844535), localObject8);
            this.b.put(Integer.valueOf(2130844536), localObject2);
          }
          break;
        }
        for (;;)
        {
          for (;;)
          {
            for (;;)
            {
              for (;;)
              {
                localObject2 = new bpst(paramInt, (List)localObject10, paramList, (Bitmap)localObject8, (Bitmap)localObject2);
                break;
                localObject8 = paramList;
                if (paramList == null) {}
                try
                {
                  localObject8 = Typeface.createFromFile(this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextConfigManager.b(localList) + "dynamic_text.ttf");
                  bptl localbptl = new bptl(BaseApplicationImpl.getContext(), paramInt, (List)localObject10, (Typeface)localObject8);
                  paramList = (List<String>)localObject8;
                }
                catch (Exception localException3)
                {
                  for (;;)
                  {
                    QLog.i(jdField_a_of_type_JavaLangString, 2, Log.getStackTraceString(localException3));
                    localObject8 = paramList;
                  }
                }
              }
              localObject11 = (Bitmap)this.b.get(Integer.valueOf(2130844574));
              localObject8 = (Bitmap)this.b.get(Integer.valueOf(2130844573));
              Object localObject3 = localObject11;
              if (localObject11 == null)
              {
                localObject3 = BitmapFactory.decodeResource(BaseApplicationImpl.getContext().getResources(), 2130844574);
                localObject8 = BitmapFactory.decodeResource(BaseApplicationImpl.getContext().getResources(), 2130844573);
              }
              localObject3 = new bpsw(paramInt, (List)localObject10, (Bitmap)localObject3, (Bitmap)localObject8);
              break;
              localObject8 = (Bitmap)this.b.get(Integer.valueOf(2130844669));
              localObject3 = localObject8;
              if (localObject8 == null)
              {
                localObject3 = BitmapFactory.decodeResource(BaseApplicationImpl.getContext().getResources(), 2130844669);
                this.b.put(Integer.valueOf(2130844669), localObject3);
              }
              localObject11 = (Bitmap)this.b.get(Integer.valueOf(2130844670));
              localObject8 = localObject11;
              if (localObject11 == null)
              {
                localObject8 = BitmapFactory.decodeResource(BaseApplicationImpl.getContext().getResources(), 2130844670);
                this.b.put(Integer.valueOf(2130844670), localObject8);
              }
              localObject14 = (Bitmap)this.b.get(Integer.valueOf(2130844671));
              localObject11 = localObject14;
              if (localObject14 == null)
              {
                localObject11 = BitmapFactory.decodeResource(BaseApplicationImpl.getContext().getResources(), 2130844671);
                this.b.put(Integer.valueOf(2130844671), localObject11);
              }
              localObject14 = new ArrayList(3);
              ((List)localObject14).add(localObject3);
              ((List)localObject14).add(localObject8);
              ((List)localObject14).add(localObject11);
              localObject8 = paramList;
              if (paramList == null) {}
              try
              {
                localObject8 = Typeface.createFromFile(this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextConfigManager.b(localList) + "dynamic_text.ttf");
                localObject3 = new bptq(paramInt, (Typeface)localObject8, (List)localObject10, (List)localObject14);
                paramList = (List<String>)localObject8;
              }
              catch (Exception localException4)
              {
                for (;;)
                {
                  localObject8 = paramList;
                  if (QLog.isColorLevel())
                  {
                    QLog.i(jdField_a_of_type_JavaLangString, 2, localException4.getMessage(), localException4);
                    localObject8 = paramList;
                  }
                }
              }
            }
            localObject8 = (Bitmap)this.b.get(Integer.valueOf(2130844567));
            localObject4 = localObject8;
            if (localObject8 == null)
            {
              localObject4 = BitmapFactory.decodeResource(BaseApplicationImpl.getContext().getResources(), 2130844567);
              this.b.put(Integer.valueOf(2130844567), localObject4);
            }
            localObject8 = paramList;
            if (paramList == null) {}
            try
            {
              localObject8 = Typeface.createFromFile(this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextConfigManager.b(localList) + "dynamic_text.ttf");
              localObject4 = new bpsn(paramInt, (List)localObject10, (Typeface)localObject8, (Bitmap)localObject4);
              paramList = (List<String>)localObject8;
            }
            catch (RuntimeException localRuntimeException)
            {
              for (;;)
              {
                localObject8 = paramList;
                if (QLog.isColorLevel())
                {
                  QLog.e(jdField_a_of_type_JavaLangString, 2, Log.getStackTraceString(localRuntimeException));
                  localObject8 = paramList;
                }
              }
            }
          }
          Object localObject4 = (Bitmap)this.b.get(Integer.valueOf(2130844508));
          localObject8 = (Bitmap)this.b.get(Integer.valueOf(2130844510));
          Object localObject12 = (Bitmap)this.b.get(Integer.valueOf(2130844509));
          if (localObject4 == null)
          {
            localObject4 = BitmapFactory.decodeResource(BaseApplicationImpl.getContext().getResources(), 2130844508);
            localObject8 = BitmapFactory.decodeResource(BaseApplicationImpl.getContext().getResources(), 2130844510);
            localObject12 = BitmapFactory.decodeResource(BaseApplicationImpl.getContext().getResources(), 2130844509);
          }
          for (;;)
          {
            Object localObject5;
            for (;;)
            {
              for (;;)
              {
                if (paramList == null) {}
                for (;;)
                {
                  try
                  {
                    localObject14 = Typeface.createFromFile(this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextConfigManager.b(localList) + "dynamic_text.ttf");
                    paramList = (List<String>)localObject14;
                    localObject4 = new bpro(paramInt, (List)localObject10, paramList, (Bitmap)localObject4, (Bitmap)localObject8, (Bitmap)localObject12);
                  }
                  catch (Exception localException14)
                  {
                    QLog.i(jdField_a_of_type_JavaLangString, 2, Log.getStackTraceString(localException14));
                  }
                }
                localObject8 = (Bitmap)this.b.get(Integer.valueOf(2130844664));
                localObject4 = localObject8;
                if (localObject8 == null)
                {
                  localObject4 = BitmapFactory.decodeResource(BaseApplicationImpl.getContext().getResources(), 2130844664);
                  this.b.put(Integer.valueOf(2130844664), localObject4);
                }
                localObject12 = (Bitmap)this.b.get(Integer.valueOf(2130844665));
                localObject8 = localObject12;
                if (localObject12 == null)
                {
                  localObject8 = BitmapFactory.decodeResource(BaseApplicationImpl.getContext().getResources(), 2130844665);
                  this.b.put(Integer.valueOf(2130844665), localObject8);
                }
                localObject12 = new ArrayList(3);
                ((List)localObject12).add(localObject4);
                ((List)localObject12).add(localObject8);
                localObject8 = paramList;
                if (paramList == null) {}
                try
                {
                  localObject8 = Typeface.createFromFile(this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextConfigManager.b(localList) + "dynamic_text.ttf");
                  localObject4 = new bpsu(paramInt, (List)localObject10, (Typeface)localObject8, (List)localObject12);
                  paramList = (List<String>)localObject8;
                }
                catch (Exception localException5)
                {
                  for (;;)
                  {
                    QLog.i(jdField_a_of_type_JavaLangString, 2, Log.getStackTraceString(localException5));
                    localObject8 = paramList;
                  }
                }
              }
              localObject8 = (Bitmap)this.b.get(Integer.valueOf(2130844520));
              localObject5 = localObject8;
              if (localObject8 == null)
              {
                localObject5 = BitmapFactory.decodeResource(BaseApplicationImpl.getContext().getResources(), 2130844520);
                this.b.put(Integer.valueOf(2130844520), localObject5);
              }
              localObject8 = paramList;
              if (paramList == null) {}
              try
              {
                localObject8 = Typeface.createFromFile(this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextConfigManager.b(localList) + "dynamic_text.ttf");
                localObject5 = new bpsq(paramInt, (List)localObject10, (Typeface)localObject8, (Bitmap)localObject5);
                paramList = (List<String>)localObject8;
              }
              catch (Exception localException11)
              {
                for (;;)
                {
                  QLog.i(jdField_a_of_type_JavaLangString, 2, Log.getStackTraceString(localException11));
                  localObject9 = paramList;
                }
              }
            }
            Object localObject9 = (Bitmap)this.b.get(Integer.valueOf(2130844524));
            if (localObject9 == null)
            {
              localObject9 = BitmapFactory.decodeResource(BaseApplicationImpl.getContext().getResources(), 2130844524);
              this.b.put(Integer.valueOf(2130844524), localObject9);
            }
            for (;;)
            {
              for (;;)
              {
                for (;;)
                {
                  if (paramList == null) {}
                  label2136:
                  for (;;)
                  {
                    try
                    {
                      localObject5 = Typeface.createFromFile(this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextConfigManager.b(localList) + "dynamic_text.ttf");
                      paramList = (List<String>)localObject5;
                      localObject5 = localObject12;
                      if (localException14 != null)
                      {
                        localObject5 = localObject12;
                        if (localException14.fontInfos.size() > 1)
                        {
                          localObject5 = localObject12;
                          if (localException14.fontInfos.get(1) != null)
                          {
                            localObject5 = localObject12;
                            if (!TextUtils.isEmpty(((bpsf)localException14.fontInfos.get(1)).c))
                            {
                              localObject5 = (Typeface)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(((bpsf)localException14.fontInfos.get(1)).c);
                              if (localObject5 != null) {
                                break label2136;
                              }
                            }
                          }
                        }
                      }
                    }
                    catch (Exception localException6)
                    {
                      try
                      {
                        localObject12 = Typeface.createFromFile(this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextConfigManager.b((bpsf)localException14.fontInfos.get(1)) + "dynamic_text.ttf");
                        localObject5 = localObject12;
                        localObject5 = new bpta(paramInt, (List)localObject10, paramList, (Typeface)localObject5, (Bitmap)localObject9);
                      }
                      catch (Exception localException12)
                      {
                        QLog.i(jdField_a_of_type_JavaLangString, 2, Log.getStackTraceString(localException12));
                      }
                      localException6 = localException6;
                      QLog.i(jdField_a_of_type_JavaLangString, 2, Log.getStackTraceString(localException6));
                    }
                  }
                  localObject9 = paramList;
                  if (paramList == null)
                  {
                    localObject9 = paramList;
                    if (!auog.a(this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextConfigManager.b(localList) + "dynamic_text.ttf")) {}
                  }
                  try
                  {
                    localObject9 = Typeface.createFromFile(this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextConfigManager.b(localList) + "dynamic_text.ttf");
                    bprz localbprz = new bprz(paramInt, (List)localObject10, (Typeface)localObject9);
                    paramList = (List<String>)localObject9;
                  }
                  catch (Exception localException7)
                  {
                    for (;;)
                    {
                      QLog.i(jdField_a_of_type_JavaLangString, 2, Log.getStackTraceString(localException7));
                      localObject9 = paramList;
                    }
                  }
                }
                localObject9 = paramList;
                if (paramList == null)
                {
                  localObject9 = paramList;
                  if (!auog.a(this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextConfigManager.b(localList) + "dynamic_text.ttf")) {}
                }
                try
                {
                  localObject9 = Typeface.createFromFile(this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextConfigManager.b(localList) + "dynamic_text.ttf");
                  if (QLog.isColorLevel()) {
                    QLog.i(jdField_a_of_type_JavaLangString, 2, "added new rich super : ");
                  }
                  bptu localbptu = new bptu(paramInt, (List)localObject10, (Typeface)localObject9);
                  paramList = (List<String>)localObject9;
                }
                catch (Exception localException8)
                {
                  for (;;)
                  {
                    localObject9 = paramList;
                    if (QLog.isColorLevel())
                    {
                      QLog.i(jdField_a_of_type_JavaLangString, 2, localException8.toString());
                      localObject9 = paramList;
                    }
                  }
                }
              }
              Object localObject6 = (Bitmap)this.b.get(Integer.valueOf(2130844512));
              if (localObject6 == null)
              {
                localObject6 = BitmapFactory.decodeResource(BaseApplicationImpl.getContext().getResources(), 2130844512);
                this.b.put(Integer.valueOf(2130844512), localObject6);
              }
              for (;;)
              {
                localObject9 = (Bitmap)this.b.get(Integer.valueOf(2130844511));
                if (localObject9 == null)
                {
                  localObject9 = BitmapFactory.decodeResource(BaseApplicationImpl.getContext().getResources(), 2130844511);
                  this.b.put(Integer.valueOf(2130844511), localObject9);
                }
                for (;;)
                {
                  for (;;)
                  {
                    for (;;)
                    {
                      for (;;)
                      {
                        if (paramList == null) {}
                        for (;;)
                        {
                          try
                          {
                            Typeface localTypeface = Typeface.createFromFile(this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextConfigManager.b(localList) + "dynamic_text.ttf");
                            paramList = localTypeface;
                            localObject6 = new bpsv(paramInt, (List)localObject10, (Bitmap)localObject9, (Bitmap)localObject6, paramList);
                          }
                          catch (Exception localException13)
                          {
                            if (QLog.isColorLevel()) {
                              QLog.i(jdField_a_of_type_JavaLangString, 2, localException13.getMessage(), localException13);
                            }
                          }
                        }
                        localObject9 = paramList;
                        if (paramList == null) {}
                        try
                        {
                          localObject9 = Typeface.createFromFile(this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextConfigManager.b(localList) + "dynamic_text.ttf");
                          localObject6 = new bptk(paramInt, (List)localObject10, (Typeface)localObject9);
                          paramList = (List<String>)localObject9;
                        }
                        catch (Exception localException9)
                        {
                          for (;;)
                          {
                            localObject9 = paramList;
                            if (QLog.isColorLevel())
                            {
                              QLog.i(jdField_a_of_type_JavaLangString, 2, localException9.getMessage(), localException9);
                              localObject9 = paramList;
                            }
                          }
                        }
                      }
                      localObject9 = paramList;
                      if (paramList == null)
                      {
                        localObject9 = paramList;
                        if (!auog.a(this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextConfigManager.b(localList) + "dynamic_text.ttf")) {}
                      }
                      try
                      {
                        localObject9 = Typeface.createFromFile(this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextConfigManager.b(localList) + "dynamic_text.ttf");
                        if (QLog.isColorLevel()) {
                          QLog.i(jdField_a_of_type_JavaLangString, 2, "added new rich super : ");
                        }
                        bpto localbpto = new bpto(paramInt, (List)localObject10, (Typeface)localObject9);
                        paramList = (List<String>)localObject9;
                      }
                      catch (Exception localException10)
                      {
                        for (;;)
                        {
                          localObject9 = paramList;
                          if (QLog.isColorLevel())
                          {
                            QLog.i(jdField_a_of_type_JavaLangString, 2, localException10.toString());
                            localObject9 = paramList;
                          }
                        }
                      }
                    }
                    localObject9 = (Bitmap)this.b.get(Integer.valueOf(2130844666));
                    Object localObject7 = localObject9;
                    if (localObject9 == null)
                    {
                      localObject7 = BitmapFactory.decodeResource(BaseApplicationImpl.getContext().getResources(), 2130844666);
                      this.b.put(Integer.valueOf(2130844666), localObject7);
                    }
                    localObject9 = (Bitmap)this.b.get(Integer.valueOf(2130844667));
                    Object localObject13 = localObject9;
                    if (localObject9 == null)
                    {
                      localObject13 = BitmapFactory.decodeResource(BaseApplicationImpl.getContext().getResources(), 2130844667);
                      this.b.put(Integer.valueOf(2130844667), localObject13);
                    }
                    localObject9 = (Bitmap)this.b.get(Integer.valueOf(2130844668));
                    Object localObject15 = localObject9;
                    if (localObject9 == null)
                    {
                      localObject15 = BitmapFactory.decodeResource(BaseApplicationImpl.getContext().getResources(), 2130844668);
                      this.b.put(Integer.valueOf(2130844668), localObject15);
                    }
                    localObject9 = paramList;
                    if (paramList == null) {}
                    try
                    {
                      localObject9 = Typeface.createFromFile(this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextConfigManager.b(localList) + "dynamic_text.ttf");
                      paramList = new bprv().a(10.0F, 12.0F).a((Bitmap)localObject7).a(41.0F, 36.0F, 1, 1).a((Typeface)localObject9).a();
                      localObject7 = new bprv().a(12.0F, 21.0F).a((Bitmap)localObject13).a(123.0F, 33.0F, 7, 2).a((Typeface)localObject9).a();
                      localObject13 = new bprv().a(10.0F, 27.0F).a((Bitmap)localObject15).a(192.0F, 43.0F, 10, 8).a((Typeface)localObject9).a();
                      localObject15 = new bpry();
                      ((bpry)localObject15).a(paramList);
                      ((bpry)localObject15).a((bpru)localObject7);
                      ((bpry)localObject15).a((bpru)localObject13);
                      ((bpry)localObject15).a((Typeface)localObject9);
                      ((bpry)localObject15).a(-16777216);
                      localObject7 = ((bpry)localObject15).a(paramInt, (List)localObject10);
                      paramList = (List<String>)localObject9;
                    }
                    catch (Exception localException15)
                    {
                      for (;;)
                      {
                        localObject9 = paramList;
                        if (QLog.isColorLevel())
                        {
                          QLog.i(jdField_a_of_type_JavaLangString, 2, localException15.getMessage(), localException15);
                          localObject9 = paramList;
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
        label3241:
        localList = paramList;
        paramList = null;
        continue;
        localList = null;
        paramList = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bpse
 * JD-Core Version:    0.7.0.1
 */