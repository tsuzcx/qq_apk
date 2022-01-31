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

public class blxf
{
  private static final String jdField_a_of_type_JavaLangString = blxf.class.getSimpleName();
  private static final Map<Integer, List<String>> jdField_a_of_type_JavaUtilMap = new HashMap();
  private DynamicTextConfigManager jdField_a_of_type_DovComQqImCaptureTextDynamicTextConfigManager;
  private ConcurrentHashMap<String, Typeface> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private ConcurrentHashMap<Integer, Bitmap> b = new ConcurrentHashMap();
  
  static
  {
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(0), Collections.singletonList(alud.a(2131703978)));
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(1), Collections.singletonList("Hi (•ω•)"));
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(3), Collections.singletonList(alud.a(2131703988)));
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(4), Collections.singletonList(alud.a(2131704001)));
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(5), Arrays.asList(new String[] { alud.a(2131703976), "MY JOURNEY" }));
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(7), Collections.singletonList(alud.a(2131703975)));
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(8), Collections.singletonList(alud.a(2131703998)));
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(11), Collections.singletonList(alud.a(2131703993)));
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(15), Collections.singletonList(alud.a(2131703994)));
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(16), Collections.singletonList(alud.a(2131703980)));
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(17), Collections.singletonList(alud.a(2131704004)));
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(19), Collections.singletonList(alud.a(2131703999)));
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(20), Collections.singletonList("superich"));
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(21), Collections.singletonList(alud.a(2131703989)));
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(24), Collections.singletonList("街头，\n艺术家。"));
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(26), Collections.singletonList(alud.a(2131703981)));
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(27), Arrays.asList(new String[] { "悠闲的\n下午。", "jenny" }));
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(28), Collections.singletonList(alud.a(2131704002)));
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
      return 2130844116;
    case 28: 
      return 2130844095;
    case 1: 
      return 2130844104;
    case 3: 
      return 2130844106;
    case 4: 
      return 2130844108;
    case 5: 
      return 2130844107;
    case 7: 
      return 2130844121;
    case 8: 
      return 2130844105;
    case 11: 
      return 2130844096;
    case 15: 
      return 2130844110;
    case 16: 
      return 2130844114;
    case 17: 
      return 2130844111;
    case 19: 
      return 2130844102;
    case 20: 
      return 2130844123;
    case 26: 
      return 2130844112;
    case 24: 
      return 2130844118;
    case 27: 
      return 2130844119;
    }
    return 2130844117;
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
      return alud.a(2131703991);
    case 1: 
      return "Hi";
    case 3: 
      return alud.a(2131703990);
    case 4: 
      return alud.a(2131703997);
    case 5: 
      return alud.a(2131703992);
    case 7: 
      return alud.a(2131703996);
    case 8: 
      return alud.a(2131703995);
    case 11: 
      return alud.a(2131703982);
    case 15: 
      return alud.a(2131703979);
    case 16: 
      return alud.a(2131704003);
    case 17: 
      return alud.a(2131703977);
    case 19: 
      return alud.a(2131703985);
    case 20: 
      return "superich";
    case 21: 
      return alud.a(2131703984);
    case 24: 
      return alud.a(2131703986);
    case 26: 
      return alud.a(2131704000);
    }
    return alud.a(2131703983);
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
    if (blyg.class.isInstance(paramDynamicTextItem)) {
      if ((paramDynamicTextItem instanceof blyf)) {
        i = 28;
      }
    }
    do
    {
      return i;
      if (blxb.class.isInstance(paramDynamicTextItem)) {
        return 1;
      }
      if (blxu.class.isInstance(paramDynamicTextItem)) {
        return 3;
      }
      if (blym.class.isInstance(paramDynamicTextItem)) {
        return 4;
      }
      if (blxx.class.isInstance(paramDynamicTextItem)) {
        return 5;
      }
      if (blyr.class.isInstance(paramDynamicTextItem)) {
        return 7;
      }
      if (blxo.class.isInstance(paramDynamicTextItem)) {
        return 8;
      }
      if (blwp.class.isInstance(paramDynamicTextItem)) {
        return 11;
      }
      if (blxv.class.isInstance(paramDynamicTextItem)) {
        return 17;
      }
      if (blxr.class.isInstance(paramDynamicTextItem)) {
        return 15;
      }
      if (blyb.class.isInstance(paramDynamicTextItem)) {
        return 16;
      }
      if (blxa.class.isInstance(paramDynamicTextItem)) {
        return 19;
      }
      if (blxw.class.isInstance(paramDynamicTextItem)) {
        return 26;
      }
      if (blyv.class.isInstance(paramDynamicTextItem)) {
        return 20;
      }
      if (blyl.class.isInstance(paramDynamicTextItem)) {
        return 24;
      }
      if (blyp.class.isInstance(paramDynamicTextItem)) {
        return 27;
      }
    } while (!blwx.class.isInstance(paramDynamicTextItem));
    return ((blwx)paramDynamicTextItem).c();
  }
  
  public <T extends DynamicTextItem> T a(int paramInt, @NonNull List<String> paramList)
  {
    Object localObject11 = null;
    if (this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextConfigManager == null) {
      this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextConfigManager = ((DynamicTextConfigManager)blqr.a(7));
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
          localObject1 = new blyg(paramInt, (List)localObject10);
        case 0: 
        case 28: 
        case 1: 
          for (;;)
          {
            if ((paramList != null) && (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(paramInt)) == null) && (localList != null)) {
              this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(localList.c, paramList);
            }
            return localObject1;
            paramList = (blxg)((DynamicTextConfigManager.DynamicTextConfigBean)localObject14).fontInfos.get(0);
            break;
            localObject1 = new blyg(paramInt, (List)localObject10);
            continue;
            localObject1 = new blyf(paramInt, (List)localObject10);
            continue;
            localObject11 = (Bitmap)this.b.get(Integer.valueOf(2130844256));
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
            localObject1 = BitmapFactory.decodeResource(BaseApplicationImpl.getContext().getResources(), 2130844256);
            this.b.put(Integer.valueOf(2130844256), localObject1);
            localObject8 = paramList;
            localObject1 = new blxb(paramInt, (List)localObject10, (Typeface)localObject8, (Bitmap)localObject1);
            paramList = (List<String>)localObject8;
          }
        case 3: 
          localObject8 = (Bitmap)this.b.get(Integer.valueOf(2130844124));
          localObject2 = (Bitmap)this.b.get(Integer.valueOf(2130844125));
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
            localObject8 = BitmapFactory.decodeResource(BaseApplicationImpl.getContext().getResources(), 2130844124);
            localObject2 = BitmapFactory.decodeResource(BaseApplicationImpl.getContext().getResources(), 2130844125);
            this.b.put(Integer.valueOf(2130844124), localObject8);
            this.b.put(Integer.valueOf(2130844125), localObject2);
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
                localObject2 = new blxu(paramInt, (List)localObject10, paramList, (Bitmap)localObject8, (Bitmap)localObject2);
                break;
                localObject8 = paramList;
                if (paramList == null) {}
                try
                {
                  localObject8 = Typeface.createFromFile(this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextConfigManager.b(localList) + "dynamic_text.ttf");
                  blym localblym = new blym(BaseApplicationImpl.getContext(), paramInt, (List)localObject10, (Typeface)localObject8);
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
              localObject11 = (Bitmap)this.b.get(Integer.valueOf(2130844163));
              localObject8 = (Bitmap)this.b.get(Integer.valueOf(2130844162));
              Object localObject3 = localObject11;
              if (localObject11 == null)
              {
                localObject3 = BitmapFactory.decodeResource(BaseApplicationImpl.getContext().getResources(), 2130844163);
                localObject8 = BitmapFactory.decodeResource(BaseApplicationImpl.getContext().getResources(), 2130844162);
              }
              localObject3 = new blxx(paramInt, (List)localObject10, (Bitmap)localObject3, (Bitmap)localObject8);
              break;
              localObject8 = (Bitmap)this.b.get(Integer.valueOf(2130844262));
              localObject3 = localObject8;
              if (localObject8 == null)
              {
                localObject3 = BitmapFactory.decodeResource(BaseApplicationImpl.getContext().getResources(), 2130844262);
                this.b.put(Integer.valueOf(2130844262), localObject3);
              }
              localObject11 = (Bitmap)this.b.get(Integer.valueOf(2130844263));
              localObject8 = localObject11;
              if (localObject11 == null)
              {
                localObject8 = BitmapFactory.decodeResource(BaseApplicationImpl.getContext().getResources(), 2130844263);
                this.b.put(Integer.valueOf(2130844263), localObject8);
              }
              localObject14 = (Bitmap)this.b.get(Integer.valueOf(2130844264));
              localObject11 = localObject14;
              if (localObject14 == null)
              {
                localObject11 = BitmapFactory.decodeResource(BaseApplicationImpl.getContext().getResources(), 2130844264);
                this.b.put(Integer.valueOf(2130844264), localObject11);
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
                localObject3 = new blyr(paramInt, (Typeface)localObject8, (List)localObject10, (List)localObject14);
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
            localObject8 = (Bitmap)this.b.get(Integer.valueOf(2130844156));
            localObject4 = localObject8;
            if (localObject8 == null)
            {
              localObject4 = BitmapFactory.decodeResource(BaseApplicationImpl.getContext().getResources(), 2130844156);
              this.b.put(Integer.valueOf(2130844156), localObject4);
            }
            localObject8 = paramList;
            if (paramList == null) {}
            try
            {
              localObject8 = Typeface.createFromFile(this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextConfigManager.b(localList) + "dynamic_text.ttf");
              localObject4 = new blxo(paramInt, (List)localObject10, (Typeface)localObject8, (Bitmap)localObject4);
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
          Object localObject4 = (Bitmap)this.b.get(Integer.valueOf(2130844097));
          localObject8 = (Bitmap)this.b.get(Integer.valueOf(2130844099));
          Object localObject12 = (Bitmap)this.b.get(Integer.valueOf(2130844098));
          if (localObject4 == null)
          {
            localObject4 = BitmapFactory.decodeResource(BaseApplicationImpl.getContext().getResources(), 2130844097);
            localObject8 = BitmapFactory.decodeResource(BaseApplicationImpl.getContext().getResources(), 2130844099);
            localObject12 = BitmapFactory.decodeResource(BaseApplicationImpl.getContext().getResources(), 2130844098);
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
                    localObject4 = new blwp(paramInt, (List)localObject10, paramList, (Bitmap)localObject4, (Bitmap)localObject8, (Bitmap)localObject12);
                  }
                  catch (Exception localException14)
                  {
                    QLog.i(jdField_a_of_type_JavaLangString, 2, Log.getStackTraceString(localException14));
                  }
                }
                localObject8 = (Bitmap)this.b.get(Integer.valueOf(2130844257));
                localObject4 = localObject8;
                if (localObject8 == null)
                {
                  localObject4 = BitmapFactory.decodeResource(BaseApplicationImpl.getContext().getResources(), 2130844257);
                  this.b.put(Integer.valueOf(2130844257), localObject4);
                }
                localObject12 = (Bitmap)this.b.get(Integer.valueOf(2130844258));
                localObject8 = localObject12;
                if (localObject12 == null)
                {
                  localObject8 = BitmapFactory.decodeResource(BaseApplicationImpl.getContext().getResources(), 2130844258);
                  this.b.put(Integer.valueOf(2130844258), localObject8);
                }
                localObject12 = new ArrayList(3);
                ((List)localObject12).add(localObject4);
                ((List)localObject12).add(localObject8);
                localObject8 = paramList;
                if (paramList == null) {}
                try
                {
                  localObject8 = Typeface.createFromFile(this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextConfigManager.b(localList) + "dynamic_text.ttf");
                  localObject4 = new blxv(paramInt, (List)localObject10, (Typeface)localObject8, (List)localObject12);
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
              localObject8 = (Bitmap)this.b.get(Integer.valueOf(2130844109));
              localObject5 = localObject8;
              if (localObject8 == null)
              {
                localObject5 = BitmapFactory.decodeResource(BaseApplicationImpl.getContext().getResources(), 2130844109);
                this.b.put(Integer.valueOf(2130844109), localObject5);
              }
              localObject8 = paramList;
              if (paramList == null) {}
              try
              {
                localObject8 = Typeface.createFromFile(this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextConfigManager.b(localList) + "dynamic_text.ttf");
                localObject5 = new blxr(paramInt, (List)localObject10, (Typeface)localObject8, (Bitmap)localObject5);
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
            Object localObject9 = (Bitmap)this.b.get(Integer.valueOf(2130844113));
            if (localObject9 == null)
            {
              localObject9 = BitmapFactory.decodeResource(BaseApplicationImpl.getContext().getResources(), 2130844113);
              this.b.put(Integer.valueOf(2130844113), localObject9);
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
                            if (!TextUtils.isEmpty(((blxg)localException14.fontInfos.get(1)).c))
                            {
                              localObject5 = (Typeface)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(((blxg)localException14.fontInfos.get(1)).c);
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
                        localObject12 = Typeface.createFromFile(this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextConfigManager.b((blxg)localException14.fontInfos.get(1)) + "dynamic_text.ttf");
                        localObject5 = localObject12;
                        localObject5 = new blyb(paramInt, (List)localObject10, paramList, (Typeface)localObject5, (Bitmap)localObject9);
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
                    if (!arso.a(this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextConfigManager.b(localList) + "dynamic_text.ttf")) {}
                  }
                  try
                  {
                    localObject9 = Typeface.createFromFile(this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextConfigManager.b(localList) + "dynamic_text.ttf");
                    blxa localblxa = new blxa(paramInt, (List)localObject10, (Typeface)localObject9);
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
                  if (!arso.a(this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextConfigManager.b(localList) + "dynamic_text.ttf")) {}
                }
                try
                {
                  localObject9 = Typeface.createFromFile(this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextConfigManager.b(localList) + "dynamic_text.ttf");
                  if (QLog.isColorLevel()) {
                    QLog.i(jdField_a_of_type_JavaLangString, 2, "added new rich super : ");
                  }
                  blyv localblyv = new blyv(paramInt, (List)localObject10, (Typeface)localObject9);
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
              Object localObject6 = (Bitmap)this.b.get(Integer.valueOf(2130844101));
              if (localObject6 == null)
              {
                localObject6 = BitmapFactory.decodeResource(BaseApplicationImpl.getContext().getResources(), 2130844101);
                this.b.put(Integer.valueOf(2130844101), localObject6);
              }
              for (;;)
              {
                localObject9 = (Bitmap)this.b.get(Integer.valueOf(2130844100));
                if (localObject9 == null)
                {
                  localObject9 = BitmapFactory.decodeResource(BaseApplicationImpl.getContext().getResources(), 2130844100);
                  this.b.put(Integer.valueOf(2130844100), localObject9);
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
                            localObject6 = new blxw(paramInt, (List)localObject10, (Bitmap)localObject9, (Bitmap)localObject6, paramList);
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
                          localObject6 = new blyl(paramInt, (List)localObject10, (Typeface)localObject9);
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
                        if (!arso.a(this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextConfigManager.b(localList) + "dynamic_text.ttf")) {}
                      }
                      try
                      {
                        localObject9 = Typeface.createFromFile(this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextConfigManager.b(localList) + "dynamic_text.ttf");
                        if (QLog.isColorLevel()) {
                          QLog.i(jdField_a_of_type_JavaLangString, 2, "added new rich super : ");
                        }
                        blyp localblyp = new blyp(paramInt, (List)localObject10, (Typeface)localObject9);
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
                    localObject9 = (Bitmap)this.b.get(Integer.valueOf(2130844259));
                    Object localObject7 = localObject9;
                    if (localObject9 == null)
                    {
                      localObject7 = BitmapFactory.decodeResource(BaseApplicationImpl.getContext().getResources(), 2130844259);
                      this.b.put(Integer.valueOf(2130844259), localObject7);
                    }
                    localObject9 = (Bitmap)this.b.get(Integer.valueOf(2130844260));
                    Object localObject13 = localObject9;
                    if (localObject9 == null)
                    {
                      localObject13 = BitmapFactory.decodeResource(BaseApplicationImpl.getContext().getResources(), 2130844260);
                      this.b.put(Integer.valueOf(2130844260), localObject13);
                    }
                    localObject9 = (Bitmap)this.b.get(Integer.valueOf(2130844261));
                    Object localObject15 = localObject9;
                    if (localObject9 == null)
                    {
                      localObject15 = BitmapFactory.decodeResource(BaseApplicationImpl.getContext().getResources(), 2130844261);
                      this.b.put(Integer.valueOf(2130844261), localObject15);
                    }
                    localObject9 = paramList;
                    if (paramList == null) {}
                    try
                    {
                      localObject9 = Typeface.createFromFile(this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextConfigManager.b(localList) + "dynamic_text.ttf");
                      paramList = new blww().a(10.0F, 12.0F).a((Bitmap)localObject7).a(41.0F, 36.0F, 1, 1).a((Typeface)localObject9).a();
                      localObject7 = new blww().a(12.0F, 21.0F).a((Bitmap)localObject13).a(123.0F, 33.0F, 7, 2).a((Typeface)localObject9).a();
                      localObject13 = new blww().a(10.0F, 27.0F).a((Bitmap)localObject15).a(192.0F, 43.0F, 10, 8).a((Typeface)localObject9).a();
                      localObject15 = new blwz();
                      ((blwz)localObject15).a(paramList);
                      ((blwz)localObject15).a((blwv)localObject7);
                      ((blwz)localObject15).a((blwv)localObject13);
                      ((blwz)localObject15).a((Typeface)localObject9);
                      ((blwz)localObject15).a(-16777216);
                      localObject7 = ((blwz)localObject15).a(paramInt, (List)localObject10);
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
 * Qualified Name:     blxf
 * JD-Core Version:    0.7.0.1
 */