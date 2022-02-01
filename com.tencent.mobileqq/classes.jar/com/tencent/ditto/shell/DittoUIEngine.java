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
  private Map<String, String> mJsonContentMap;
  private Map<String, String> mJsonMd5Map;
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
    //   3: getstatic 49	com/tencent/ditto/shell/DittoUIEngine:sInstance	Lcom/tencent/ditto/shell/DittoUIEngine;
    //   6: ifnonnull +27 -> 33
    //   9: getstatic 51	com/tencent/ditto/shell/DittoUIEngine:INSTANCE_LOCK	[B
    //   12: astore_0
    //   13: aload_0
    //   14: monitorenter
    //   15: getstatic 49	com/tencent/ditto/shell/DittoUIEngine:sInstance	Lcom/tencent/ditto/shell/DittoUIEngine;
    //   18: ifnonnull +13 -> 31
    //   21: new 2	com/tencent/ditto/shell/DittoUIEngine
    //   24: dup
    //   25: invokespecial 161	com/tencent/ditto/shell/DittoUIEngine:<init>	()V
    //   28: putstatic 49	com/tencent/ditto/shell/DittoUIEngine:sInstance	Lcom/tencent/ditto/shell/DittoUIEngine;
    //   31: aload_0
    //   32: monitorexit
    //   33: getstatic 49	com/tencent/ditto/shell/DittoUIEngine:sInstance	Lcom/tencent/ditto/shell/DittoUIEngine;
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
                break label288;
              }
              localConcurrentHashMap.put(((File)localObject2).getName(), localObject3);
              break label288;
            }
          }
        }
        localObject1 = this.mJsonMd5Map;
        if (localObject1 != null)
        {
          localObject1 = ((Map)localObject1).entrySet().iterator();
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
        }
        return localConcurrentHashMap;
      }
      catch (Exception localException)
      {
        DittoLog.e("DITTO_UI", "", localException);
      }
      label288:
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
    //   1: getfield 66	com/tencent/ditto/shell/DittoUIEngine:jsonCache	Ljava/util/HashMap;
    //   4: aload_1
    //   5: invokevirtual 371	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   8: checkcast 165	org/json/JSONObject
    //   11: astore_2
    //   12: aload_2
    //   13: astore_3
    //   14: aload_2
    //   15: ifnonnull +37 -> 52
    //   18: aload_0
    //   19: aload_1
    //   20: invokespecial 374	com/tencent/ditto/shell/DittoUIEngine:loadLayoutContent	(Ljava/lang/String;)Ljava/lang/String;
    //   23: astore 4
    //   25: aload_2
    //   26: astore_3
    //   27: aload 4
    //   29: ifnull +23 -> 52
    //   32: new 165	org/json/JSONObject
    //   35: dup
    //   36: aload 4
    //   38: invokespecial 167	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   41: astore_3
    //   42: aload_0
    //   43: getfield 66	com/tencent/ditto/shell/DittoUIEngine:jsonCache	Ljava/util/HashMap;
    //   46: aload_1
    //   47: aload_3
    //   48: invokevirtual 375	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   51: pop
    //   52: aload_3
    //   53: areturn
    //   54: astore_3
    //   55: aconst_null
    //   56: astore_2
    //   57: ldc 155
    //   59: new 106	java/lang/StringBuilder
    //   62: dup
    //   63: invokespecial 107	java/lang/StringBuilder:<init>	()V
    //   66: aload_1
    //   67: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   70: ldc_w 377
    //   73: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   76: invokevirtual 126	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   79: aload_3
    //   80: invokestatic 158	com/tencent/ditto/utils/DittoLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
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
    //   3: aconst_null
    //   4: astore_2
    //   5: new 104	java/io/File
    //   8: dup
    //   9: new 106	java/lang/StringBuilder
    //   12: dup
    //   13: invokespecial 107	java/lang/StringBuilder:<init>	()V
    //   16: invokestatic 207	com/tencent/ditto/shell/DittoUIEngine:g	()Lcom/tencent/ditto/shell/DittoUIEngine;
    //   19: getfield 93	com/tencent/ditto/shell/DittoUIEngine:mContext	Landroid/content/Context;
    //   22: invokevirtual 113	android/content/Context:getFilesDir	()Ljava/io/File;
    //   25: invokevirtual 116	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   28: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   31: getstatic 123	java/io/File:separator	Ljava/lang/String;
    //   34: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: aload_0
    //   38: getfield 61	com/tencent/ditto/shell/DittoUIEngine:subDirectoryPath	Ljava/lang/String;
    //   41: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   44: getstatic 123	java/io/File:separator	Ljava/lang/String;
    //   47: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   50: invokevirtual 126	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   53: aload_1
    //   54: invokespecial 129	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   57: astore_3
    //   58: aload_3
    //   59: invokevirtual 136	java/io/File:exists	()Z
    //   62: ifeq +170 -> 232
    //   65: aload_3
    //   66: invokevirtual 380	java/io/File:isFile	()Z
    //   69: ifeq +163 -> 232
    //   72: new 106	java/lang/StringBuilder
    //   75: dup
    //   76: invokespecial 107	java/lang/StringBuilder:<init>	()V
    //   79: astore 5
    //   81: new 382	java/io/FileInputStream
    //   84: dup
    //   85: aload_3
    //   86: invokespecial 385	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   89: astore_1
    //   90: new 387	java/io/BufferedReader
    //   93: dup
    //   94: new 389	java/io/InputStreamReader
    //   97: dup
    //   98: aload_1
    //   99: invokespecial 392	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   102: invokespecial 395	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   105: astore_2
    //   106: aload_2
    //   107: astore 4
    //   109: aload_1
    //   110: astore_3
    //   111: aload_2
    //   112: invokevirtual 398	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   115: astore 6
    //   117: aload 6
    //   119: ifnull +55 -> 174
    //   122: aload_2
    //   123: astore 4
    //   125: aload_1
    //   126: astore_3
    //   127: aload 5
    //   129: aload 6
    //   131: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   134: pop
    //   135: goto -29 -> 106
    //   138: astore 5
    //   140: aload_2
    //   141: astore 4
    //   143: aload_1
    //   144: astore_3
    //   145: ldc 155
    //   147: ldc 59
    //   149: aload 5
    //   151: invokestatic 158	com/tencent/ditto/utils/DittoLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   154: aload_2
    //   155: ifnull +7 -> 162
    //   158: aload_2
    //   159: invokevirtual 401	java/io/BufferedReader:close	()V
    //   162: aload_1
    //   163: ifnull +7 -> 170
    //   166: aload_1
    //   167: invokevirtual 404	java/io/InputStream:close	()V
    //   170: aconst_null
    //   171: astore_3
    //   172: aload_3
    //   173: areturn
    //   174: aload_2
    //   175: astore 4
    //   177: aload_1
    //   178: astore_3
    //   179: aload 5
    //   181: invokevirtual 126	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   184: invokevirtual 407	java/lang/String:trim	()Ljava/lang/String;
    //   187: astore 5
    //   189: aload 5
    //   191: astore_3
    //   192: aload_2
    //   193: astore 4
    //   195: aload_1
    //   196: astore_2
    //   197: aload_3
    //   198: astore_1
    //   199: aload 4
    //   201: ifnull +8 -> 209
    //   204: aload 4
    //   206: invokevirtual 401	java/io/BufferedReader:close	()V
    //   209: aload_1
    //   210: astore_3
    //   211: aload_2
    //   212: ifnull -40 -> 172
    //   215: aload_2
    //   216: invokevirtual 404	java/io/InputStream:close	()V
    //   219: aload_1
    //   220: areturn
    //   221: astore_2
    //   222: ldc 155
    //   224: ldc 59
    //   226: aload_2
    //   227: invokestatic 158	com/tencent/ditto/utils/DittoLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   230: aload_1
    //   231: areturn
    //   232: aload_0
    //   233: getfield 409	com/tencent/ditto/shell/DittoUIEngine:mJsonContentMap	Ljava/util/Map;
    //   236: astore_3
    //   237: aload_3
    //   238: ifnull +96 -> 334
    //   241: aload_3
    //   242: aload_1
    //   243: invokeinterface 410 2 0
    //   248: checkcast 143	java/lang/String
    //   251: astore_1
    //   252: aconst_null
    //   253: astore_3
    //   254: aload_2
    //   255: astore 4
    //   257: aload_3
    //   258: astore_2
    //   259: goto -60 -> 199
    //   262: astore_1
    //   263: ldc 155
    //   265: ldc 59
    //   267: aload_1
    //   268: invokestatic 158	com/tencent/ditto/utils/DittoLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   271: aconst_null
    //   272: areturn
    //   273: astore_2
    //   274: aconst_null
    //   275: astore_1
    //   276: aload 4
    //   278: ifnull +8 -> 286
    //   281: aload 4
    //   283: invokevirtual 401	java/io/BufferedReader:close	()V
    //   286: aload_1
    //   287: ifnull +7 -> 294
    //   290: aload_1
    //   291: invokevirtual 404	java/io/InputStream:close	()V
    //   294: aload_2
    //   295: athrow
    //   296: astore_1
    //   297: ldc 155
    //   299: ldc 59
    //   301: aload_1
    //   302: invokestatic 158	com/tencent/ditto/utils/DittoLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   305: goto -11 -> 294
    //   308: astore_2
    //   309: goto -33 -> 276
    //   312: astore_2
    //   313: aload_3
    //   314: astore_1
    //   315: goto -39 -> 276
    //   318: astore 5
    //   320: aconst_null
    //   321: astore_2
    //   322: aconst_null
    //   323: astore_1
    //   324: goto -184 -> 140
    //   327: astore 5
    //   329: aconst_null
    //   330: astore_2
    //   331: goto -191 -> 140
    //   334: aconst_null
    //   335: astore_3
    //   336: aconst_null
    //   337: astore_1
    //   338: aload_2
    //   339: astore 4
    //   341: aload_3
    //   342: astore_2
    //   343: goto -144 -> 199
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	346	0	this	DittoUIEngine
    //   0	346	1	paramString	String
    //   4	212	2	localObject1	Object
    //   221	34	2	localException	Exception
    //   258	1	2	localObject2	Object
    //   273	22	2	localObject3	Object
    //   308	1	2	localObject4	Object
    //   312	1	2	localObject5	Object
    //   321	22	2	localObject6	Object
    //   57	285	3	localObject7	Object
    //   1	339	4	localObject8	Object
    //   79	49	5	localStringBuilder	java.lang.StringBuilder
    //   138	42	5	localIOException1	IOException
    //   187	3	5	str1	String
    //   318	1	5	localIOException2	IOException
    //   327	1	5	localIOException3	IOException
    //   115	15	6	str2	String
    // Exception table:
    //   from	to	target	type
    //   111	117	138	java/io/IOException
    //   127	135	138	java/io/IOException
    //   179	189	138	java/io/IOException
    //   204	209	221	java/lang/Exception
    //   215	219	221	java/lang/Exception
    //   158	162	262	java/lang/Exception
    //   166	170	262	java/lang/Exception
    //   5	90	273	finally
    //   232	237	273	finally
    //   241	252	273	finally
    //   281	286	296	java/lang/Exception
    //   290	294	296	java/lang/Exception
    //   90	106	308	finally
    //   111	117	312	finally
    //   127	135	312	finally
    //   145	154	312	finally
    //   179	189	312	finally
    //   5	90	318	java/io/IOException
    //   232	237	318	java/io/IOException
    //   241	252	318	java/io/IOException
    //   90	106	327	java/io/IOException
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
  
  public void clearAllAreaCache()
  {
    new DittoArea(new DittoUIEngine.FakeHost(this), null).clearAllAreaCache();
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
  
  public void initExtra(DittoResources paramDittoResources, DittoUIEngine.IReporter paramIReporter, String paramString1, String paramString2, Class paramClass, Map<String, String> paramMap1, Map<String, String> paramMap2)
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
    this.mJsonContentMap = paramMap1;
    this.mJsonMd5Map = paramMap2;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ditto.shell.DittoUIEngine
 * JD-Core Version:    0.7.0.1
 */