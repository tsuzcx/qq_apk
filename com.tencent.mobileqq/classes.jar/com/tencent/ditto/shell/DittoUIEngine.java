package com.tencent.ditto.shell;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.support.v4.util.ArrayMap;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewStub;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.ditto.area.DittoArea;
import com.tencent.ditto.area.DittoAreaGroup;
import com.tencent.ditto.area.DittoHost;
import com.tencent.ditto.content.res.DittoResources;
import com.tencent.ditto.reflect.DittoValue.GLOBAL;
import com.tencent.ditto.utils.DittoLog;
import com.tencent.ditto.utils.FileUtils;
import com.tencent.ditto.utils.Log;
import com.tencent.ditto.widget.DittoButtonArea;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Map<Ljava.lang.String;Ljava.lang.String;>;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class DittoUIEngine
{
  private static float DENSITY = 0.0F;
  private static final String HABO_UPDATE_JSON_FILE_CMD = "tencent.ditto.updateLayoutFile";
  private static final byte[] INSTANCE_LOCK = new byte[0];
  private static float SCREEN_HEIGHT = 0.0F;
  private static float SCREEN_WIDTH = 0.0F;
  private static final String TAG = "DittoUIEngine";
  private static boolean needLoadFromSdcard = true;
  private static volatile DittoValue.GLOBAL outerGlobalData;
  private static volatile DittoUIEngine sInstance = null;
  private Map<String, String> fileMd5 = null;
  private final Map<String, List<DittoArea>> inflatedAreaBuffer = new HashMap();
  private final HashMap<String, JSONObject> jsonCache = new HashMap();
  private Context mContext;
  private DittoResources mDittoResources;
  private Class mRClass;
  private DittoUIEngine.IReporter mReporter;
  private final Map<String, Integer> resourceIdCache = new ConcurrentHashMap();
  private String subDirectoryPath = "";
  
  public DittoUIEngine()
  {
    DittoLog.v(DittoButtonArea.class.toString());
  }
  
  private void clearCanvasUIFileInfo()
  {
    try
    {
      Map localMap = this.fileMd5;
      if (localMap != null) {
        localMap.clear();
      }
      return;
    }
    finally {}
  }
  
  private void createVersionFile(String paramString)
  {
    File localFile1 = new File(this.mContext.getFilesDir().getAbsolutePath() + File.separator + this.subDirectoryPath + File.separator + "version", paramString);
    File localFile2 = localFile1.getParentFile();
    if ((localFile2 != null) && (!localFile2.exists()) && (!localFile2.mkdirs())) {
      DittoLog.e(String.format("create version file:%s failed", new Object[] { paramString }));
    }
    for (;;)
    {
      return;
      try
      {
        if (!localFile1.createNewFile())
        {
          DittoLog.e(String.format("create version file:%s failed", new Object[] { paramString }));
          return;
        }
      }
      catch (IOException localIOException)
      {
        DittoLog.e("DITTO_UI", String.format("create version file:%s failed", new Object[] { paramString }), localIOException);
      }
    }
  }
  
  /* Error */
  public static DittoUIEngine g()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 47	com/tencent/ditto/shell/DittoUIEngine:sInstance	Lcom/tencent/ditto/shell/DittoUIEngine;
    //   6: ifnonnull +27 -> 33
    //   9: getstatic 49	com/tencent/ditto/shell/DittoUIEngine:INSTANCE_LOCK	[B
    //   12: astore_0
    //   13: aload_0
    //   14: monitorenter
    //   15: getstatic 47	com/tencent/ditto/shell/DittoUIEngine:sInstance	Lcom/tencent/ditto/shell/DittoUIEngine;
    //   18: ifnonnull +13 -> 31
    //   21: new 2	com/tencent/ditto/shell/DittoUIEngine
    //   24: dup
    //   25: invokespecial 159	com/tencent/ditto/shell/DittoUIEngine:<init>	()V
    //   28: putstatic 47	com/tencent/ditto/shell/DittoUIEngine:sInstance	Lcom/tencent/ditto/shell/DittoUIEngine;
    //   31: aload_0
    //   32: monitorexit
    //   33: getstatic 47	com/tencent/ditto/shell/DittoUIEngine:sInstance	Lcom/tencent/ditto/shell/DittoUIEngine;
    //   36: astore_0
    //   37: ldc 2
    //   39: monitorexit
    //   40: aload_0
    //   41: areturn
    //   42: astore_1
    //   43: aload_0
    //   44: monitorexit
    //   45: aload_1
    //   46: athrow
    //   47: astore_0
    //   48: ldc 2
    //   50: monitorexit
    //   51: aload_0
    //   52: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   47	5	0	localObject2	Object
    //   42	4	1	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   15	31	42	finally
    //   31	33	42	finally
    //   43	45	42	finally
    //   3	15	47	finally
    //   33	37	47	finally
    //   45	47	47	finally
  }
  
  private JSONObject generateBuffer(String paramString1, String arg2)
  {
    JSONObject localJSONObject = new JSONObject(???);
    synchronized (this.inflatedAreaBuffer)
    {
      if (this.inflatedAreaBuffer.containsKey(paramString1)) {
        this.inflatedAreaBuffer.remove(paramString1);
      }
      ArrayList localArrayList = new ArrayList();
      this.inflatedAreaBuffer.put(paramString1, localArrayList);
      DittoUIEngine.FakeHost localFakeHost = new DittoUIEngine.FakeHost(this);
      int i = 0;
      while (i < 6)
      {
        localArrayList.add(inflateDittoArea(localFakeHost, localJSONObject, null));
        i += 1;
      }
      DittoLog.i("generated area buffer:" + paramString1);
      return localJSONObject;
    }
  }
  
  private Map<String, String> generateFileMd5()
  {
    ConcurrentHashMap localConcurrentHashMap = new ConcurrentHashMap();
    for (;;)
    {
      int i;
      try
      {
        Object localObject1 = new File(g().mContext.getFilesDir().getAbsolutePath() + File.separator + this.subDirectoryPath + File.separator);
        Object localObject2;
        Object localObject3;
        if (((File)localObject1).exists())
        {
          localObject1 = ((File)localObject1).listFiles();
          if ((localObject1 != null) && (localObject1.length > 0))
          {
            int j = localObject1.length;
            i = 0;
            if (i < j)
            {
              localObject2 = localObject1[i];
              localObject3 = FileUtils.getMd5ByFile((File)localObject2);
              DittoLog.w("DITTO_UI", "Layout File from sd card:" + ((File)localObject2).getName() + " md5:" + (String)localObject3);
              if (TextUtils.isEmpty((CharSequence)localObject3)) {
                break label278;
              }
              localConcurrentHashMap.put(((File)localObject2).getName(), localObject3);
              break label278;
            }
          }
        }
        localObject1 = DittoConfig.jsonMd5Map.entrySet().iterator();
        if (((Iterator)localObject1).hasNext())
        {
          localObject3 = (Map.Entry)((Iterator)localObject1).next();
          localObject2 = (String)((Map.Entry)localObject3).getKey();
          localObject3 = (String)((Map.Entry)localObject3).getValue();
          if ((TextUtils.isEmpty((CharSequence)localObject2)) || (TextUtils.isEmpty((CharSequence)localObject3))) {
            continue;
          }
          localConcurrentHashMap.put(localObject2, localObject3);
          continue;
        }
        return localConcurrentHashMap;
      }
      catch (Exception localException)
      {
        DittoLog.e("DITTO_UI", "", localException);
      }
      label278:
      i += 1;
    }
  }
  
  public static DittoValue.GLOBAL getOuterGlobalData()
  {
    return outerGlobalData;
  }
  
  public static float getScreenHeight()
  {
    return SCREEN_HEIGHT;
  }
  
  public static float getScreenWidth()
  {
    return SCREEN_WIDTH;
  }
  
  private DittoArea inflateDittoArea(DittoHost paramDittoHost, JSONObject paramJSONObject, DittoUIEngine.DittoUIEngineInflateListener paramDittoUIEngineInflateListener)
  {
    int i = 0;
    if (paramJSONObject == null) {
      paramDittoHost = null;
    }
    Object localObject1;
    ArrayMap localArrayMap;
    do
    {
      do
      {
        return paramDittoHost;
        localObject1 = DittoAreaEnv.findAreaClass(paramJSONObject.getString("class"));
        Object localObject2 = paramJSONObject.getJSONObject("shell");
        localArrayMap = new ArrayMap();
        localObject2 = LayoutAttrSet.createFrom((JSONObject)localObject2, new DittoUIEngine.1(this, localArrayMap));
        localObject1 = (DittoArea)((Class)localObject1).getConstructor(new Class[] { DittoHost.class, LayoutAttrSet.class }).newInstance(new Object[] { paramDittoHost, localObject2 });
        ((DittoArea)localObject1).doneInflate();
        if ((((DittoArea)localObject1).getId() != null) && (paramDittoUIEngineInflateListener != null)) {
          paramDittoUIEngineInflateListener.didInflatedArea((DittoArea)localObject1, ((DittoArea)localObject1).getId());
        }
        if (paramJSONObject.has("children"))
        {
          paramJSONObject = paramJSONObject.getJSONArray("children");
          if (paramJSONObject != null)
          {
            localObject2 = (DittoAreaGroup)localObject1;
            int j = paramJSONObject.length();
            while (i < j)
            {
              DittoArea localDittoArea = inflateDittoArea(paramDittoHost, paramJSONObject.getJSONObject(i), paramDittoUIEngineInflateListener);
              if (localDittoArea != null) {
                ((DittoAreaGroup)localObject2).addChild(localDittoArea);
              }
              i += 1;
            }
          }
        }
        paramDittoHost = (DittoHost)localObject1;
      } while (paramDittoUIEngineInflateListener == null);
      paramDittoHost = (DittoHost)localObject1;
    } while (localArrayMap.size() == 0);
    paramDittoUIEngineInflateListener.setOutKVCSet((DittoArea)localObject1, localArrayMap);
    return localObject1;
  }
  
  private boolean isFirstBoot(String paramString)
  {
    return !new File(this.mContext.getFilesDir().getAbsolutePath() + File.separator + this.subDirectoryPath + File.separator + "version", paramString).exists();
  }
  
  /* Error */
  private JSONObject loadJsonObject(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 64	com/tencent/ditto/shell/DittoUIEngine:jsonCache	Ljava/util/HashMap;
    //   4: aload_1
    //   5: invokevirtual 372	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   8: checkcast 163	org/json/JSONObject
    //   11: astore_2
    //   12: aload_2
    //   13: astore_3
    //   14: aload_2
    //   15: ifnonnull +37 -> 52
    //   18: aload_0
    //   19: aload_1
    //   20: invokespecial 375	com/tencent/ditto/shell/DittoUIEngine:loadLayoutContent	(Ljava/lang/String;)Ljava/lang/String;
    //   23: astore 4
    //   25: aload_2
    //   26: astore_3
    //   27: aload 4
    //   29: ifnull +23 -> 52
    //   32: new 163	org/json/JSONObject
    //   35: dup
    //   36: aload 4
    //   38: invokespecial 165	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   41: astore_3
    //   42: aload_0
    //   43: getfield 64	com/tencent/ditto/shell/DittoUIEngine:jsonCache	Ljava/util/HashMap;
    //   46: aload_1
    //   47: aload_3
    //   48: invokevirtual 376	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   51: pop
    //   52: aload_3
    //   53: areturn
    //   54: astore_3
    //   55: aconst_null
    //   56: astore_2
    //   57: ldc 153
    //   59: new 104	java/lang/StringBuilder
    //   62: dup
    //   63: invokespecial 105	java/lang/StringBuilder:<init>	()V
    //   66: aload_1
    //   67: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   70: ldc_w 378
    //   73: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   76: invokevirtual 124	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   79: aload_3
    //   80: invokestatic 156	com/tencent/ditto/utils/DittoLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   83: aload_2
    //   84: areturn
    //   85: astore_3
    //   86: goto -29 -> 57
    //   89: astore 4
    //   91: aload_3
    //   92: astore_2
    //   93: aload 4
    //   95: astore_3
    //   96: goto -39 -> 57
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	99	0	this	DittoUIEngine
    //   0	99	1	paramString	String
    //   11	82	2	localObject1	Object
    //   13	40	3	localObject2	Object
    //   54	26	3	localException1	Exception
    //   85	7	3	localException2	Exception
    //   95	1	3	localObject3	Object
    //   23	14	4	str	String
    //   89	5	4	localException3	Exception
    // Exception table:
    //   from	to	target	type
    //   0	12	54	java/lang/Exception
    //   18	25	85	java/lang/Exception
    //   32	42	85	java/lang/Exception
    //   42	52	89	java/lang/Exception
  }
  
  /* Error */
  private String loadLayoutContent(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: new 102	java/io/File
    //   6: dup
    //   7: new 104	java/lang/StringBuilder
    //   10: dup
    //   11: invokespecial 105	java/lang/StringBuilder:<init>	()V
    //   14: invokestatic 205	com/tencent/ditto/shell/DittoUIEngine:g	()Lcom/tencent/ditto/shell/DittoUIEngine;
    //   17: getfield 91	com/tencent/ditto/shell/DittoUIEngine:mContext	Landroid/content/Context;
    //   20: invokevirtual 111	android/content/Context:getFilesDir	()Ljava/io/File;
    //   23: invokevirtual 114	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   26: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: getstatic 121	java/io/File:separator	Ljava/lang/String;
    //   32: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: aload_0
    //   36: getfield 59	com/tencent/ditto/shell/DittoUIEngine:subDirectoryPath	Ljava/lang/String;
    //   39: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: getstatic 121	java/io/File:separator	Ljava/lang/String;
    //   45: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   48: invokevirtual 124	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   51: aload_1
    //   52: invokespecial 127	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   55: astore_2
    //   56: aload_2
    //   57: invokevirtual 134	java/io/File:exists	()Z
    //   60: ifeq +167 -> 227
    //   63: aload_2
    //   64: invokevirtual 381	java/io/File:isFile	()Z
    //   67: ifeq +160 -> 227
    //   70: new 104	java/lang/StringBuilder
    //   73: dup
    //   74: invokespecial 105	java/lang/StringBuilder:<init>	()V
    //   77: astore 5
    //   79: new 383	java/io/FileInputStream
    //   82: dup
    //   83: aload_2
    //   84: invokespecial 386	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   87: astore_1
    //   88: new 388	java/io/BufferedReader
    //   91: dup
    //   92: new 390	java/io/InputStreamReader
    //   95: dup
    //   96: aload_1
    //   97: invokespecial 393	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   100: invokespecial 396	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   103: astore_2
    //   104: aload_2
    //   105: astore 4
    //   107: aload_1
    //   108: astore_3
    //   109: aload_2
    //   110: invokevirtual 399	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   113: astore 6
    //   115: aload 6
    //   117: ifnull +55 -> 172
    //   120: aload_2
    //   121: astore 4
    //   123: aload_1
    //   124: astore_3
    //   125: aload 5
    //   127: aload 6
    //   129: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   132: pop
    //   133: goto -29 -> 104
    //   136: astore 5
    //   138: aload_2
    //   139: astore 4
    //   141: aload_1
    //   142: astore_3
    //   143: ldc 153
    //   145: ldc 57
    //   147: aload 5
    //   149: invokestatic 156	com/tencent/ditto/utils/DittoLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   152: aload_2
    //   153: ifnull +7 -> 160
    //   156: aload_2
    //   157: invokevirtual 402	java/io/BufferedReader:close	()V
    //   160: aload_1
    //   161: ifnull +7 -> 168
    //   164: aload_1
    //   165: invokevirtual 405	java/io/InputStream:close	()V
    //   168: aconst_null
    //   169: astore_2
    //   170: aload_2
    //   171: areturn
    //   172: aload_2
    //   173: astore 4
    //   175: aload_1
    //   176: astore_3
    //   177: aload 5
    //   179: invokevirtual 124	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   182: invokevirtual 408	java/lang/String:trim	()Ljava/lang/String;
    //   185: astore 5
    //   187: aload 5
    //   189: astore 4
    //   191: aload_1
    //   192: astore_3
    //   193: aload 4
    //   195: astore_1
    //   196: aload_2
    //   197: ifnull +7 -> 204
    //   200: aload_2
    //   201: invokevirtual 402	java/io/BufferedReader:close	()V
    //   204: aload_1
    //   205: astore_2
    //   206: aload_3
    //   207: ifnull -37 -> 170
    //   210: aload_3
    //   211: invokevirtual 405	java/io/InputStream:close	()V
    //   214: aload_1
    //   215: areturn
    //   216: astore_2
    //   217: ldc 153
    //   219: ldc 57
    //   221: aload_2
    //   222: invokestatic 156	com/tencent/ditto/utils/DittoLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   225: aload_1
    //   226: areturn
    //   227: getstatic 411	com/tencent/ditto/shell/DittoConfig:jsonContentMap	Ljava/util/Map;
    //   230: aload_1
    //   231: invokeinterface 412 2 0
    //   236: checkcast 141	java/lang/String
    //   239: astore_1
    //   240: aconst_null
    //   241: astore_2
    //   242: aconst_null
    //   243: astore_3
    //   244: goto -48 -> 196
    //   247: astore_1
    //   248: ldc 153
    //   250: ldc 57
    //   252: aload_1
    //   253: invokestatic 156	com/tencent/ditto/utils/DittoLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   256: aconst_null
    //   257: areturn
    //   258: astore_2
    //   259: aconst_null
    //   260: astore_1
    //   261: aload 4
    //   263: ifnull +8 -> 271
    //   266: aload 4
    //   268: invokevirtual 402	java/io/BufferedReader:close	()V
    //   271: aload_1
    //   272: ifnull +7 -> 279
    //   275: aload_1
    //   276: invokevirtual 405	java/io/InputStream:close	()V
    //   279: aload_2
    //   280: athrow
    //   281: astore_1
    //   282: ldc 153
    //   284: ldc 57
    //   286: aload_1
    //   287: invokestatic 156	com/tencent/ditto/utils/DittoLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   290: goto -11 -> 279
    //   293: astore_2
    //   294: goto -33 -> 261
    //   297: astore_2
    //   298: aload_3
    //   299: astore_1
    //   300: goto -39 -> 261
    //   303: astore 5
    //   305: aconst_null
    //   306: astore_2
    //   307: aconst_null
    //   308: astore_1
    //   309: goto -171 -> 138
    //   312: astore 5
    //   314: aconst_null
    //   315: astore_2
    //   316: goto -178 -> 138
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	319	0	this	DittoUIEngine
    //   0	319	1	paramString	String
    //   55	151	2	localObject1	Object
    //   216	6	2	localException	Exception
    //   241	1	2	localObject2	Object
    //   258	22	2	localObject3	Object
    //   293	1	2	localObject4	Object
    //   297	1	2	localObject5	Object
    //   306	10	2	localObject6	Object
    //   108	191	3	str1	String
    //   1	266	4	localObject7	Object
    //   77	49	5	localStringBuilder	java.lang.StringBuilder
    //   136	42	5	localIOException1	IOException
    //   185	3	5	str2	String
    //   303	1	5	localIOException2	IOException
    //   312	1	5	localIOException3	IOException
    //   113	15	6	str3	String
    // Exception table:
    //   from	to	target	type
    //   109	115	136	java/io/IOException
    //   125	133	136	java/io/IOException
    //   177	187	136	java/io/IOException
    //   200	204	216	java/lang/Exception
    //   210	214	216	java/lang/Exception
    //   156	160	247	java/lang/Exception
    //   164	168	247	java/lang/Exception
    //   3	88	258	finally
    //   227	240	258	finally
    //   266	271	281	java/lang/Exception
    //   275	279	281	java/lang/Exception
    //   88	104	293	finally
    //   109	115	297	finally
    //   125	133	297	finally
    //   143	152	297	finally
    //   177	187	297	finally
    //   3	88	303	java/io/IOException
    //   227	240	303	java/io/IOException
    //   88	104	312	java/io/IOException
  }
  
  private void modifyInflatedArea(DittoArea paramDittoArea, DittoHost paramDittoHost, DittoUIEngine.DittoUIEngineInflateListener paramDittoUIEngineInflateListener)
  {
    paramDittoArea.setHost(paramDittoHost);
    if (paramDittoUIEngineInflateListener != null) {
      paramDittoUIEngineInflateListener.didInflatedArea(paramDittoArea, paramDittoArea.getId());
    }
    if ((paramDittoArea instanceof DittoAreaGroup))
    {
      paramDittoArea = (DittoAreaGroup)paramDittoArea;
      int j = paramDittoArea.getChildCount();
      int i = 0;
      while (i < j)
      {
        modifyInflatedArea(paramDittoArea.getChildAt(i), paramDittoHost, paramDittoUIEngineInflateListener);
        i += 1;
      }
    }
  }
  
  private void preloadJsonObjects()
  {
    loadJsonObject("qzone_canvas_ui_titleview.json");
    loadJsonObject("qzone_canvas_ui_feedcontent.json");
  }
  
  public static void setOuterGlobalData(DittoValue.GLOBAL paramGLOBAL)
  {
    outerGlobalData = paramGLOBAL;
  }
  
  public void addResourceIdCache(String paramString, int paramInt)
  {
    this.resourceIdCache.put(paramString, Integer.valueOf(paramInt));
  }
  
  public void clearCache()
  {
    clearCanvasUIFileInfo();
    clearRichTextAreaCache();
  }
  
  public void clearRichTextAreaCache()
  {
    new DittoArea(new DittoUIEngine.FakeHost(this), null).clearRichTextAreaCache();
  }
  
  public Context getContext()
  {
    return this.mContext;
  }
  
  public float getDensity()
  {
    return DENSITY;
  }
  
  public DittoResources getDittoResources()
  {
    return this.mDittoResources;
  }
  
  public Map<String, String> getDittoUIFileInfo()
  {
    try
    {
      if (this.fileMd5 == null) {
        this.fileMd5 = generateFileMd5();
      }
      return this.fileMd5;
    }
    finally {}
  }
  
  public String getFileMd5(String paramString)
  {
    getDittoUIFileInfo();
    synchronized (this.fileMd5)
    {
      if (this.fileMd5.containsKey(paramString))
      {
        paramString = (String)this.fileMd5.get(paramString);
        return paramString;
      }
      return null;
    }
  }
  
  public DittoUIEngine.IReporter getReporter()
  {
    return this.mReporter;
  }
  
  public int getResourceId(String paramString)
  {
    int j = 0;
    int i;
    if (this.resourceIdCache.containsKey(paramString)) {
      i = ((Integer)this.resourceIdCache.get(paramString)).intValue();
    }
    do
    {
      do
      {
        return i;
        i = j;
      } while (this.mRClass == null);
      i = j;
    } while (TextUtils.isEmpty(paramString));
    String[] arrayOfString = paramString.split("/");
    if (arrayOfString.length != 2)
    {
      DittoLog.e(String.format("reference string:%s of incorrect format", new Object[] { paramString }));
      return 0;
    }
    try
    {
      String str = arrayOfString[0].substring(1, arrayOfString[0].length());
      i = Class.forName(this.mRClass.getName() + "$" + str).getDeclaredField(arrayOfString[1]).getInt(null);
      this.resourceIdCache.put(paramString, Integer.valueOf(i));
      return i;
    }
    catch (Exception localException)
    {
      DittoLog.e("DITTO_UI", "get resource id err:" + localException.getMessage() + "  idString:" + paramString, localException);
    }
    return 0;
  }
  
  public DittoArea inflateDittoArea(DittoHost paramDittoHost, String paramString, DittoUIEngine.DittoUIEngineInflateListener paramDittoUIEngineInflateListener)
  {
    return inflateDittoArea(paramDittoHost, paramString, paramDittoUIEngineInflateListener, false);
  }
  
  public DittoArea inflateDittoArea(DittoHost paramDittoHost, String paramString, DittoUIEngine.DittoUIEngineInflateListener paramDittoUIEngineInflateListener, boolean paramBoolean)
  {
    if (!paramBoolean) {}
    for (;;)
    {
      synchronized (this.inflatedAreaBuffer)
      {
        if (!this.inflatedAreaBuffer.containsKey(paramString)) {
          break label266;
        }
        List localList = (List)this.inflatedAreaBuffer.get(paramString);
        if (localList.size() == 0) {
          break label266;
        }
        localDittoArea = (DittoArea)localList.get(0);
        localList.remove(0);
        if (localList.size() == 0) {
          this.inflatedAreaBuffer.remove(paramString);
        }
        DittoLog.i("area buffer used:" + paramString + "buffer remained:" + localList.size());
        if (localDittoArea != null)
        {
          modifyInflatedArea(localDittoArea, paramDittoHost, paramDittoUIEngineInflateListener);
          return localDittoArea;
        }
      }
      if ((localDittoArea != null) || (paramBoolean)) {}
      for (;;)
      {
        try
        {
          paramString = new JSONObject(paramString);
          return inflateDittoArea(paramDittoHost, paramString, paramDittoUIEngineInflateListener);
        }
        catch (InvocationTargetException paramDittoHost)
        {
          DittoLog.e("DITTO_UI", "inflate err:" + paramDittoHost.getTargetException().getMessage(), paramDittoHost.getTargetException());
          return null;
        }
        catch (Exception paramDittoHost)
        {
          DittoLog.e("DITTO_UI", "inflate err:" + paramDittoHost.getMessage(), paramDittoHost);
          continue;
        }
        paramString = loadJsonObject(paramString);
      }
      label266:
      DittoArea localDittoArea = null;
      continue;
      localDittoArea = null;
    }
  }
  
  public View inflateView(Context paramContext, String paramString, ViewGroup paramViewGroup)
  {
    try
    {
      paramContext = inflateView(paramContext, loadJsonObject(paramString), paramViewGroup);
      return paramContext;
    }
    catch (InvocationTargetException paramContext)
    {
      DittoLog.e("DITTO_UI", "inflate err:" + paramContext.getTargetException().getMessage(), paramContext.getTargetException());
      return null;
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        DittoLog.e("DITTO_UI", "inflate err:" + paramContext.getMessage(), paramContext);
      }
    }
  }
  
  public View inflateView(Context paramContext, JSONObject paramJSONObject, ViewGroup paramViewGroup)
  {
    if (paramJSONObject == null) {
      return null;
    }
    Object localObject1 = paramJSONObject.getString("View");
    Object localObject2;
    int j;
    int i;
    Object localObject3;
    Object localObject4;
    if ("merge".equals(localObject1))
    {
      if ((paramJSONObject.has("children")) && ((paramViewGroup instanceof ViewGroup)))
      {
        localObject1 = paramJSONObject.getJSONArray("children");
        if (localObject1 != null)
        {
          localObject2 = (ViewGroup)paramViewGroup;
          j = ((JSONArray)localObject1).length();
          i = 0;
          for (;;)
          {
            if (i >= j) {
              break label854;
            }
            localObject3 = inflateView(paramContext, ((JSONArray)localObject1).getJSONObject(i), (ViewGroup)localObject2);
            if ((localObject3 != null) && (((View)localObject3).getParent() == null))
            {
              localObject4 = (ViewGroup.MarginLayoutParams)((View)localObject3).getLayoutParams();
              if (localObject4 == null) {
                break label844;
              }
              if (!(localObject2 instanceof LinearLayout)) {
                break;
              }
              paramJSONObject = new LinearLayout.LayoutParams(((ViewGroup.MarginLayoutParams)localObject4).width, ((ViewGroup.MarginLayoutParams)localObject4).height);
              paramJSONObject.leftMargin = ((ViewGroup.MarginLayoutParams)localObject4).leftMargin;
              paramJSONObject.topMargin = ((ViewGroup.MarginLayoutParams)localObject4).topMargin;
              paramJSONObject.rightMargin = ((ViewGroup.MarginLayoutParams)localObject4).rightMargin;
              paramJSONObject.bottomMargin = ((ViewGroup.MarginLayoutParams)localObject4).bottomMargin;
              label186:
              if (paramJSONObject != null) {
                ((ViewGroup)localObject2).addView((View)localObject3, paramJSONObject);
              }
            }
            label198:
            i += 1;
          }
        }
      }
    }
    else if ("include".equals(localObject1))
    {
      localObject2 = LayoutAttrSet.createFrom(paramJSONObject.getJSONObject("shell"));
      localObject1 = ((LayoutAttrSet)localObject2).getAttr("layout", "");
      localObject2 = ((LayoutAttrSet)localObject2).getAttr("id", "");
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        break label879;
      }
      i = getResourceId((String)localObject1);
      LayoutInflater.from(paramContext).inflate(i, paramViewGroup);
      if (paramViewGroup == null) {
        break label879;
      }
      localObject1 = paramViewGroup.getChildAt(paramViewGroup.getChildCount() - 1);
      paramViewGroup = (ViewGroup)localObject1;
      if (!TextUtils.isEmpty((CharSequence)localObject2))
      {
        paramViewGroup = (ViewGroup)localObject1;
        if (localObject1 != null) {
          ((View)localObject1).setId(getResourceId((String)localObject2));
        }
      }
    }
    label844:
    label854:
    label873:
    label879:
    for (paramViewGroup = (ViewGroup)localObject1;; paramViewGroup = null)
    {
      break;
      paramViewGroup = DittoAreaEnv.findAreaClass((String)localObject1);
      DittoLog.i("DITTO_UI", "inflateView name:" + (String)localObject1);
      localObject2 = LayoutAttrSet.createFrom(paramJSONObject.getJSONObject("shell"));
      paramViewGroup = paramViewGroup.getConstructor(new Class[] { Context.class, AttributeSet.class }).newInstance(new Object[] { paramContext, null });
      String str;
      if ((paramViewGroup instanceof ViewStub))
      {
        localObject1 = (View)paramViewGroup;
        paramViewGroup = (ViewStub)paramViewGroup;
        localObject3 = ((LayoutAttrSet)localObject2).getAttr("id", "");
        localObject4 = ((LayoutAttrSet)localObject2).getAttr("inflatedId", "");
        str = ((LayoutAttrSet)localObject2).getAttr("layout", "");
        if (TextUtils.isEmpty((CharSequence)localObject3)) {
          break label873;
        }
      }
      for (i = getResourceId((String)localObject3);; i = 0)
      {
        if (!TextUtils.isEmpty((CharSequence)localObject4)) {}
        for (j = getResourceId((String)localObject4);; j = 0)
        {
          if (!TextUtils.isEmpty(str)) {}
          for (int k = getResourceId(str);; k = 0)
          {
            paramViewGroup.setId(i);
            paramViewGroup.setInflatedId(j);
            paramViewGroup.setLayoutResource(k);
            for (;;)
            {
              paramViewGroup = new ViewGroup.MarginLayoutParams(((LayoutAttrSet)localObject2).width, ((LayoutAttrSet)localObject2).height);
              paramViewGroup.leftMargin = ((LayoutAttrSet)localObject2).leftMargin;
              paramViewGroup.topMargin = ((LayoutAttrSet)localObject2).topMargin;
              paramViewGroup.rightMargin = ((LayoutAttrSet)localObject2).rightMargin;
              paramViewGroup.bottomMargin = ((LayoutAttrSet)localObject2).bottomMargin;
              ((View)localObject1).setLayoutParams(paramViewGroup);
              ((View)localObject1).setPadding(((LayoutAttrSet)localObject2).leftPadding, ((LayoutAttrSet)localObject2).topPadding, ((LayoutAttrSet)localObject2).rightPadding, ((LayoutAttrSet)localObject2).bottomPadding);
              paramViewGroup = (ViewGroup)localObject1;
              if (!(localObject1 instanceof LinearLayout)) {
                break;
              }
              ((LinearLayout)localObject1).setOrientation(((LayoutAttrSet)localObject2).orientation);
              paramViewGroup = (ViewGroup)localObject1;
              break;
              paramViewGroup = (View)paramViewGroup;
              localObject1 = ((LayoutAttrSet)localObject2).id;
              if (!TextUtils.isEmpty((CharSequence)localObject1)) {
                paramViewGroup.setId(getResourceId((String)localObject1));
              }
              localObject1 = paramViewGroup;
              if (((LayoutAttrSet)localObject2).mAttrs.containsKey("visibility"))
              {
                localObject3 = ((LayoutAttrSet)localObject2).getAttr("visibility", "visible");
                if (TextUtils.equals("visible", (CharSequence)localObject3))
                {
                  paramViewGroup.setVisibility(0);
                  localObject1 = paramViewGroup;
                }
                else if (TextUtils.equals("gone", (CharSequence)localObject3))
                {
                  paramViewGroup.setVisibility(8);
                  localObject1 = paramViewGroup;
                }
                else
                {
                  localObject1 = paramViewGroup;
                  if (TextUtils.equals("invisible", (CharSequence)localObject3))
                  {
                    paramViewGroup.setVisibility(4);
                    localObject1 = paramViewGroup;
                  }
                }
              }
            }
            if ((localObject2 instanceof RelativeLayout))
            {
              paramJSONObject = new RelativeLayout.LayoutParams(((ViewGroup.MarginLayoutParams)localObject4).width, ((ViewGroup.MarginLayoutParams)localObject4).height);
              paramJSONObject.leftMargin = ((ViewGroup.MarginLayoutParams)localObject4).leftMargin;
              paramJSONObject.topMargin = ((ViewGroup.MarginLayoutParams)localObject4).topMargin;
              paramJSONObject.rightMargin = ((ViewGroup.MarginLayoutParams)localObject4).rightMargin;
              paramJSONObject.bottomMargin = ((ViewGroup.MarginLayoutParams)localObject4).bottomMargin;
              break label186;
              ((ViewGroup)localObject2).addView((View)localObject3);
              break label198;
              return paramViewGroup;
            }
            paramJSONObject = null;
            break label186;
          }
        }
      }
    }
  }
  
  public void init(Context paramContext, Log paramLog)
  {
    this.mContext = paramContext;
    DittoLog.setLog(paramLog);
    paramContext = this.mContext.getResources().getDisplayMetrics();
    DENSITY = paramContext.density;
    SCREEN_WIDTH = paramContext.widthPixels;
    SCREEN_HEIGHT = paramContext.heightPixels;
  }
  
  public void initExtra(DittoResources paramDittoResources, DittoUIEngine.IReporter paramIReporter, String paramString1, String paramString2, Class paramClass)
  {
    Context localContext = this.mContext;
    if (localContext == null)
    {
      DittoLog.e("DittoUIEngine", "initExtra error! context is null!");
      return;
    }
    this.mDittoResources = paramDittoResources;
    this.mReporter = paramIReporter;
    this.subDirectoryPath = paramString2;
    if ((!TextUtils.isEmpty(paramString1)) && (isFirstBoot(paramString1)))
    {
      paramDittoResources = localContext.getFilesDir().getAbsolutePath() + File.separator + paramString2 + File.separator;
      if (paramDittoResources != null) {
        FileUtils.deleteFile(new File(paramDittoResources));
      }
      DittoLog.i("Clean the storage field when updated:" + paramDittoResources);
      createVersionFile(paramString1);
    }
    this.mRClass = paramClass;
    preloadJsonObjects();
  }
  
  public void updateLayoutFile(Map<String, String> arg1)
  {
    if ((??? == null) || (???.size() <= 0)) {}
    for (;;)
    {
      return;
      try
      {
        File localFile = new File(g().mContext.getFilesDir().getAbsolutePath() + File.separator + this.subDirectoryPath + File.separator);
        if (!localFile.exists()) {
          localFile.mkdirs();
        }
        ??? = null;
        Iterator localIterator = ???.entrySet().iterator();
        ??? = (Map<String, String>)???;
        while (localIterator.hasNext())
        {
          ??? = (Map.Entry)localIterator.next();
          String str1 = (String)((Map.Entry)???).getKey();
          String str2 = (String)((Map.Entry)???).getValue();
          try
          {
            if ((!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty(str2)))
            {
              localObject3 = generateBuffer(str1, str2);
              synchronized (this.jsonCache)
              {
                this.jsonCache.put(str1, localObject3);
                localObject3 = new File(localFile.getPath(), str1);
                if (((File)localObject3).exists()) {
                  ((File)localObject3).delete();
                }
                ((File)localObject3).createNewFile();
                ??? = new FileOutputStream((File)localObject3);
              }
            }
          }
          catch (Exception localException1)
          {
            try
            {
              ((FileOutputStream)???).write(str2.getBytes());
              ((FileOutputStream)???).close();
              localObject3 = FileUtils.getMd5ByFile((File)localObject3);
            }
            catch (Exception localException3)
            {
              for (;;)
              {
                Object localObject3;
                int j;
                ??? = localException1;
                Object localObject2 = localException3;
                continue;
                int i = j;
                if (Build.VERSION.SDK_INT >= 19)
                {
                  boolean bool = localObject2 instanceof ReflectiveOperationException;
                  i = j;
                  if (bool) {
                    i = -61441;
                  }
                }
              }
            }
            synchronized (this.fileMd5)
            {
              this.fileMd5.put(str1, localObject3);
              ??? = "update Layout File:" + str1 + " md5:" + (String)localObject3;
              DittoLog.i(???);
              getReporter().haboReport("tencent.ditto.updateLayoutFile", 0, ???, 1);
              ??? = (Map<String, String>)???;
              continue;
              localObject4 = finally;
              throw localObject4;
              localException1 = localException1;
              j = -1;
              if ((localException1 instanceof JSONException))
              {
                i = -61442;
                DittoLog.e("DITTO_UI", "update file error! " + str1 + " -- " + str2 + "Exception:" + localException1.getMessage(), localException1);
                getReporter().haboReport("tencent.ditto.updateLayoutFile", i, DittoLog.getTraceString(localException1), 1);
                if (??? == null) {}
              }
            }
          }
        }
        return;
      }
      catch (Exception ???)
      {
        DittoLog.e("DITTO_UI", "updateLayoutFile error!", ???);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ditto.shell.DittoUIEngine
 * JD-Core Version:    0.7.0.1
 */