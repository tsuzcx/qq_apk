import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.filemanager.util.FileUtil;
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

public class bolc
{
  private static final String jdField_a_of_type_JavaLangString = bolc.class.getSimpleName();
  private static final Map<Integer, List<String>> jdField_a_of_type_JavaUtilMap = new HashMap();
  private DynamicTextConfigManager jdField_a_of_type_DovComQqImCaptureTextDynamicTextConfigManager;
  private ConcurrentHashMap<String, Typeface> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private ConcurrentHashMap<Integer, Bitmap> b = new ConcurrentHashMap();
  
  static
  {
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(0), Collections.singletonList(anvx.a(2131703068)));
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(1), Collections.singletonList("Hi (•ω•)"));
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(3), Collections.singletonList(anvx.a(2131703078)));
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(4), Collections.singletonList(anvx.a(2131703091)));
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(5), Arrays.asList(new String[] { anvx.a(2131703066), "MY JOURNEY" }));
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(7), Collections.singletonList(anvx.a(2131703065)));
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(8), Collections.singletonList(anvx.a(2131703088)));
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(11), Collections.singletonList(anvx.a(2131703083)));
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(15), Collections.singletonList(anvx.a(2131703084)));
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(16), Collections.singletonList(anvx.a(2131703070)));
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(17), Collections.singletonList(anvx.a(2131703094)));
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(19), Collections.singletonList(anvx.a(2131703089)));
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(20), Collections.singletonList("superich"));
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(21), Collections.singletonList(anvx.a(2131703079)));
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(24), Collections.singletonList("街头，\n艺术家。"));
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(26), Collections.singletonList(anvx.a(2131703071)));
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(27), Arrays.asList(new String[] { "悠闲的\n下午。", "jenny" }));
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(28), Collections.singletonList(anvx.a(2131703092)));
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
      return 2130844465;
    case 28: 
      return 2130844444;
    case 1: 
      return 2130844453;
    case 3: 
      return 2130844455;
    case 4: 
      return 2130844457;
    case 5: 
      return 2130844456;
    case 7: 
      return 2130844470;
    case 8: 
      return 2130844454;
    case 11: 
      return 2130844445;
    case 15: 
      return 2130844459;
    case 16: 
      return 2130844463;
    case 17: 
      return 2130844460;
    case 19: 
      return 2130844451;
    case 20: 
      return 2130844472;
    case 26: 
      return 2130844461;
    case 24: 
      return 2130844467;
    case 27: 
      return 2130844468;
    }
    return 2130844466;
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
      return anvx.a(2131703081);
    case 1: 
      return "Hi";
    case 3: 
      return anvx.a(2131703080);
    case 4: 
      return anvx.a(2131703087);
    case 5: 
      return anvx.a(2131703082);
    case 7: 
      return anvx.a(2131703086);
    case 8: 
      return anvx.a(2131703085);
    case 11: 
      return anvx.a(2131703072);
    case 15: 
      return anvx.a(2131703069);
    case 16: 
      return anvx.a(2131703093);
    case 17: 
      return anvx.a(2131703067);
    case 19: 
      return anvx.a(2131703075);
    case 20: 
      return "superich";
    case 21: 
      return anvx.a(2131703074);
    case 24: 
      return anvx.a(2131703076);
    case 26: 
      return anvx.a(2131703090);
    }
    return anvx.a(2131703073);
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
  
  public int a(DynamicTextItem paramDynamicTextItem)
  {
    int i = 0;
    if (bomd.class.isInstance(paramDynamicTextItem)) {
      if ((paramDynamicTextItem instanceof bomc)) {
        i = 28;
      }
    }
    do
    {
      return i;
      if (boky.class.isInstance(paramDynamicTextItem)) {
        return 1;
      }
      if (bolr.class.isInstance(paramDynamicTextItem)) {
        return 3;
      }
      if (bomj.class.isInstance(paramDynamicTextItem)) {
        return 4;
      }
      if (bolu.class.isInstance(paramDynamicTextItem)) {
        return 5;
      }
      if (bomo.class.isInstance(paramDynamicTextItem)) {
        return 7;
      }
      if (boll.class.isInstance(paramDynamicTextItem)) {
        return 8;
      }
      if (bokm.class.isInstance(paramDynamicTextItem)) {
        return 11;
      }
      if (bols.class.isInstance(paramDynamicTextItem)) {
        return 17;
      }
      if (bolo.class.isInstance(paramDynamicTextItem)) {
        return 15;
      }
      if (boly.class.isInstance(paramDynamicTextItem)) {
        return 16;
      }
      if (bokx.class.isInstance(paramDynamicTextItem)) {
        return 19;
      }
      if (bolt.class.isInstance(paramDynamicTextItem)) {
        return 26;
      }
      if (boms.class.isInstance(paramDynamicTextItem)) {
        return 20;
      }
      if (bomi.class.isInstance(paramDynamicTextItem)) {
        return 24;
      }
      if (bomm.class.isInstance(paramDynamicTextItem)) {
        return 27;
      }
    } while (!boku.class.isInstance(paramDynamicTextItem));
    return ((boku)paramDynamicTextItem).c();
  }
  
  public <T extends DynamicTextItem> T a(int paramInt, @NonNull List<String> paramList)
  {
    Object localObject11 = null;
    if (this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextConfigManager == null) {
      this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextConfigManager = ((DynamicTextConfigManager)bogd.a(7));
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
          localObject1 = new bomd(paramInt, (List)localObject10);
        case 0: 
        case 28: 
        case 1: 
          for (;;)
          {
            if ((paramList != null) && (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(paramInt)) == null) && (localList != null)) {
              this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(localList.c, paramList);
            }
            return localObject1;
            paramList = (bold)((DynamicTextConfigManager.DynamicTextConfigBean)localObject14).fontInfos.get(0);
            break;
            localObject1 = new bomd(paramInt, (List)localObject10);
            continue;
            localObject1 = new bomc(paramInt, (List)localObject10);
            continue;
            localObject11 = (Bitmap)this.b.get(Integer.valueOf(2130844605));
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
            localObject1 = BitmapFactory.decodeResource(BaseApplicationImpl.getContext().getResources(), 2130844605);
            this.b.put(Integer.valueOf(2130844605), localObject1);
            localObject8 = paramList;
            localObject1 = new boky(paramInt, (List)localObject10, (Typeface)localObject8, (Bitmap)localObject1);
            paramList = (List<String>)localObject8;
          }
        case 3: 
          localObject8 = (Bitmap)this.b.get(Integer.valueOf(2130844473));
          localObject2 = (Bitmap)this.b.get(Integer.valueOf(2130844474));
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
            localObject8 = BitmapFactory.decodeResource(BaseApplicationImpl.getContext().getResources(), 2130844473);
            localObject2 = BitmapFactory.decodeResource(BaseApplicationImpl.getContext().getResources(), 2130844474);
            this.b.put(Integer.valueOf(2130844473), localObject8);
            this.b.put(Integer.valueOf(2130844474), localObject2);
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
                localObject2 = new bolr(paramInt, (List)localObject10, paramList, (Bitmap)localObject8, (Bitmap)localObject2);
                break;
                localObject8 = paramList;
                if (paramList == null) {}
                try
                {
                  localObject8 = Typeface.createFromFile(this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextConfigManager.b(localList) + "dynamic_text.ttf");
                  bomj localbomj = new bomj(BaseApplicationImpl.getContext(), paramInt, (List)localObject10, (Typeface)localObject8);
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
              localObject11 = (Bitmap)this.b.get(Integer.valueOf(2130844511));
              localObject8 = (Bitmap)this.b.get(Integer.valueOf(2130844510));
              Object localObject3 = localObject11;
              if (localObject11 == null)
              {
                localObject3 = BitmapFactory.decodeResource(BaseApplicationImpl.getContext().getResources(), 2130844511);
                localObject8 = BitmapFactory.decodeResource(BaseApplicationImpl.getContext().getResources(), 2130844510);
              }
              localObject3 = new bolu(paramInt, (List)localObject10, (Bitmap)localObject3, (Bitmap)localObject8);
              break;
              localObject8 = (Bitmap)this.b.get(Integer.valueOf(2130844611));
              localObject3 = localObject8;
              if (localObject8 == null)
              {
                localObject3 = BitmapFactory.decodeResource(BaseApplicationImpl.getContext().getResources(), 2130844611);
                this.b.put(Integer.valueOf(2130844611), localObject3);
              }
              localObject11 = (Bitmap)this.b.get(Integer.valueOf(2130844612));
              localObject8 = localObject11;
              if (localObject11 == null)
              {
                localObject8 = BitmapFactory.decodeResource(BaseApplicationImpl.getContext().getResources(), 2130844612);
                this.b.put(Integer.valueOf(2130844612), localObject8);
              }
              localObject14 = (Bitmap)this.b.get(Integer.valueOf(2130844613));
              localObject11 = localObject14;
              if (localObject14 == null)
              {
                localObject11 = BitmapFactory.decodeResource(BaseApplicationImpl.getContext().getResources(), 2130844613);
                this.b.put(Integer.valueOf(2130844613), localObject11);
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
                localObject3 = new bomo(paramInt, (Typeface)localObject8, (List)localObject10, (List)localObject14);
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
            localObject8 = (Bitmap)this.b.get(Integer.valueOf(2130844504));
            localObject4 = localObject8;
            if (localObject8 == null)
            {
              localObject4 = BitmapFactory.decodeResource(BaseApplicationImpl.getContext().getResources(), 2130844504);
              this.b.put(Integer.valueOf(2130844504), localObject4);
            }
            localObject8 = paramList;
            if (paramList == null) {}
            try
            {
              localObject8 = Typeface.createFromFile(this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextConfigManager.b(localList) + "dynamic_text.ttf");
              localObject4 = new boll(paramInt, (List)localObject10, (Typeface)localObject8, (Bitmap)localObject4);
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
          Object localObject4 = (Bitmap)this.b.get(Integer.valueOf(2130844446));
          localObject8 = (Bitmap)this.b.get(Integer.valueOf(2130844448));
          Object localObject12 = (Bitmap)this.b.get(Integer.valueOf(2130844447));
          if (localObject4 == null)
          {
            localObject4 = BitmapFactory.decodeResource(BaseApplicationImpl.getContext().getResources(), 2130844446);
            localObject8 = BitmapFactory.decodeResource(BaseApplicationImpl.getContext().getResources(), 2130844448);
            localObject12 = BitmapFactory.decodeResource(BaseApplicationImpl.getContext().getResources(), 2130844447);
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
                    localObject4 = new bokm(paramInt, (List)localObject10, paramList, (Bitmap)localObject4, (Bitmap)localObject8, (Bitmap)localObject12);
                  }
                  catch (Exception localException14)
                  {
                    QLog.i(jdField_a_of_type_JavaLangString, 2, Log.getStackTraceString(localException14));
                  }
                }
                localObject8 = (Bitmap)this.b.get(Integer.valueOf(2130844606));
                localObject4 = localObject8;
                if (localObject8 == null)
                {
                  localObject4 = BitmapFactory.decodeResource(BaseApplicationImpl.getContext().getResources(), 2130844606);
                  this.b.put(Integer.valueOf(2130844606), localObject4);
                }
                localObject12 = (Bitmap)this.b.get(Integer.valueOf(2130844607));
                localObject8 = localObject12;
                if (localObject12 == null)
                {
                  localObject8 = BitmapFactory.decodeResource(BaseApplicationImpl.getContext().getResources(), 2130844607);
                  this.b.put(Integer.valueOf(2130844607), localObject8);
                }
                localObject12 = new ArrayList(3);
                ((List)localObject12).add(localObject4);
                ((List)localObject12).add(localObject8);
                localObject8 = paramList;
                if (paramList == null) {}
                try
                {
                  localObject8 = Typeface.createFromFile(this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextConfigManager.b(localList) + "dynamic_text.ttf");
                  localObject4 = new bols(paramInt, (List)localObject10, (Typeface)localObject8, (List)localObject12);
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
              localObject8 = (Bitmap)this.b.get(Integer.valueOf(2130844458));
              localObject5 = localObject8;
              if (localObject8 == null)
              {
                localObject5 = BitmapFactory.decodeResource(BaseApplicationImpl.getContext().getResources(), 2130844458);
                this.b.put(Integer.valueOf(2130844458), localObject5);
              }
              localObject8 = paramList;
              if (paramList == null) {}
              try
              {
                localObject8 = Typeface.createFromFile(this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextConfigManager.b(localList) + "dynamic_text.ttf");
                localObject5 = new bolo(paramInt, (List)localObject10, (Typeface)localObject8, (Bitmap)localObject5);
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
            Object localObject9 = (Bitmap)this.b.get(Integer.valueOf(2130844462));
            if (localObject9 == null)
            {
              localObject9 = BitmapFactory.decodeResource(BaseApplicationImpl.getContext().getResources(), 2130844462);
              this.b.put(Integer.valueOf(2130844462), localObject9);
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
                            if (!TextUtils.isEmpty(((bold)localException14.fontInfos.get(1)).c))
                            {
                              localObject5 = (Typeface)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(((bold)localException14.fontInfos.get(1)).c);
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
                        localObject12 = Typeface.createFromFile(this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextConfigManager.b((bold)localException14.fontInfos.get(1)) + "dynamic_text.ttf");
                        localObject5 = localObject12;
                        localObject5 = new boly(paramInt, (List)localObject10, paramList, (Typeface)localObject5, (Bitmap)localObject9);
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
                    if (!FileUtil.isFileExists(this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextConfigManager.b(localList) + "dynamic_text.ttf")) {}
                  }
                  try
                  {
                    localObject9 = Typeface.createFromFile(this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextConfigManager.b(localList) + "dynamic_text.ttf");
                    bokx localbokx = new bokx(paramInt, (List)localObject10, (Typeface)localObject9);
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
                  if (!FileUtil.isFileExists(this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextConfigManager.b(localList) + "dynamic_text.ttf")) {}
                }
                try
                {
                  localObject9 = Typeface.createFromFile(this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextConfigManager.b(localList) + "dynamic_text.ttf");
                  if (QLog.isColorLevel()) {
                    QLog.i(jdField_a_of_type_JavaLangString, 2, "added new rich super : ");
                  }
                  boms localboms = new boms(paramInt, (List)localObject10, (Typeface)localObject9);
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
              Object localObject6 = (Bitmap)this.b.get(Integer.valueOf(2130844450));
              if (localObject6 == null)
              {
                localObject6 = BitmapFactory.decodeResource(BaseApplicationImpl.getContext().getResources(), 2130844450);
                this.b.put(Integer.valueOf(2130844450), localObject6);
              }
              for (;;)
              {
                localObject9 = (Bitmap)this.b.get(Integer.valueOf(2130844449));
                if (localObject9 == null)
                {
                  localObject9 = BitmapFactory.decodeResource(BaseApplicationImpl.getContext().getResources(), 2130844449);
                  this.b.put(Integer.valueOf(2130844449), localObject9);
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
                            localObject6 = new bolt(paramInt, (List)localObject10, (Bitmap)localObject9, (Bitmap)localObject6, paramList);
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
                          localObject6 = new bomi(paramInt, (List)localObject10, (Typeface)localObject9);
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
                        if (!FileUtil.isFileExists(this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextConfigManager.b(localList) + "dynamic_text.ttf")) {}
                      }
                      try
                      {
                        localObject9 = Typeface.createFromFile(this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextConfigManager.b(localList) + "dynamic_text.ttf");
                        if (QLog.isColorLevel()) {
                          QLog.i(jdField_a_of_type_JavaLangString, 2, "added new rich super : ");
                        }
                        bomm localbomm = new bomm(paramInt, (List)localObject10, (Typeface)localObject9);
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
                    localObject9 = (Bitmap)this.b.get(Integer.valueOf(2130844608));
                    Object localObject7 = localObject9;
                    if (localObject9 == null)
                    {
                      localObject7 = BitmapFactory.decodeResource(BaseApplicationImpl.getContext().getResources(), 2130844608);
                      this.b.put(Integer.valueOf(2130844608), localObject7);
                    }
                    localObject9 = (Bitmap)this.b.get(Integer.valueOf(2130844609));
                    Object localObject13 = localObject9;
                    if (localObject9 == null)
                    {
                      localObject13 = BitmapFactory.decodeResource(BaseApplicationImpl.getContext().getResources(), 2130844609);
                      this.b.put(Integer.valueOf(2130844609), localObject13);
                    }
                    localObject9 = (Bitmap)this.b.get(Integer.valueOf(2130844610));
                    Object localObject15 = localObject9;
                    if (localObject9 == null)
                    {
                      localObject15 = BitmapFactory.decodeResource(BaseApplicationImpl.getContext().getResources(), 2130844610);
                      this.b.put(Integer.valueOf(2130844610), localObject15);
                    }
                    localObject9 = paramList;
                    if (paramList == null) {}
                    try
                    {
                      localObject9 = Typeface.createFromFile(this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextConfigManager.b(localList) + "dynamic_text.ttf");
                      paramList = new bokt().a(10.0F, 12.0F).a((Bitmap)localObject7).a(41.0F, 36.0F, 1, 1).a((Typeface)localObject9).a();
                      localObject7 = new bokt().a(12.0F, 21.0F).a((Bitmap)localObject13).a(123.0F, 33.0F, 7, 2).a((Typeface)localObject9).a();
                      localObject13 = new bokt().a(10.0F, 27.0F).a((Bitmap)localObject15).a(192.0F, 43.0F, 10, 8).a((Typeface)localObject9).a();
                      localObject15 = new bokw();
                      ((bokw)localObject15).a(paramList);
                      ((bokw)localObject15).a((boks)localObject7);
                      ((bokw)localObject15).a((boks)localObject13);
                      ((bokw)localObject15).a((Typeface)localObject9);
                      ((bokw)localObject15).a(-16777216);
                      localObject7 = ((bokw)localObject15).a(paramInt, (List)localObject10);
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
 * Qualified Name:     bolc
 * JD-Core Version:    0.7.0.1
 */