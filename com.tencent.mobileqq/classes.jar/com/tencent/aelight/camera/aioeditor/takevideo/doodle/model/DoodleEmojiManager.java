package com.tencent.aelight.camera.aioeditor.takevideo.doodle.model;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.location.Location;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.aelight.camera.aioeditor.capture.IQIMManager;
import com.tencent.aelight.camera.aioeditor.capture.QIMManager;
import com.tencent.aelight.camera.aioeditor.capture.paster.QIMPasterConfigManager;
import com.tencent.biz.qqstory.app.QQStoryConstant;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.base.StoryDispatcher;
import com.tencent.biz.qqstory.channel.CmdTaskManger;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.lbs.LbsManager;
import com.tencent.biz.qqstory.model.lbs.LbsManager.LbsUpdateListener;
import com.tencent.biz.qqstory.network.request.GetPoiFacesRequest;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.utils.FileUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tribe.async.async.Boss;
import com.tribe.async.async.Bosses;
import com.tribe.async.dispatch.Dispatcher;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

@TargetApi(9)
public class DoodleEmojiManager
  extends IQIMManager
{
  public static final String a;
  public volatile AtomicInteger b = new AtomicInteger(0);
  public final Object c = new Object[0];
  public final Queue<DoodleEmojiItem> d = new LinkedList();
  public DoodleEmojiItem e = null;
  public final ConcurrentHashMap<String, DoodleEmojiItem> f = new ConcurrentHashMap();
  public final List<DoodleEmojiItem> g = new CopyOnWriteArrayList();
  public String h = "";
  public final int i = 50;
  protected List<Location> j = new ArrayList();
  DoodleEmojiManager.POIPostersRequestCallback k = null;
  LbsManager.LbsUpdateListener l = new DoodleEmojiManager.4(this);
  private SharedPreferences m;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(QQStoryConstant.l);
    localStringBuilder.append("emoji");
    a = localStringBuilder.toString();
    c(a);
  }
  
  public DoodleEmojiManager()
  {
    BaseApplicationImpl localBaseApplicationImpl = QQStoryContext.a().c();
    if (localBaseApplicationImpl != null)
    {
      this.m = localBaseApplicationImpl.getSharedPreferences("qqstory_emoji", 4);
      return;
    }
    throw new IllegalArgumentException("Context should not be null");
  }
  
  public static String a(DoodleEmojiManager paramDoodleEmojiManager, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("emoji_pack_url_");
    localStringBuilder.append(paramString);
    return paramDoodleEmojiManager.b(localStringBuilder.toString(), "");
  }
  
  private static String a(@NonNull File paramFile)
  {
    return paramFile.getName().substring(13);
  }
  
  protected static String a(@NonNull String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(a);
    localStringBuilder.append(File.separator);
    localStringBuilder.append("emoji_zip_");
    localStringBuilder.append(paramString);
    return localStringBuilder.toString();
  }
  
  public static void a(DoodleEmojiManager paramDoodleEmojiManager, String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("emoji_pack_md5_");
    localStringBuilder.append(paramString1);
    paramDoodleEmojiManager.a(localStringBuilder.toString(), paramString2);
  }
  
  public static String b(DoodleEmojiManager paramDoodleEmojiManager, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("emoji_pack_name_");
    localStringBuilder.append(paramString);
    return paramDoodleEmojiManager.b(localStringBuilder.toString(), "");
  }
  
  protected static String b(@NonNull String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(a);
    localStringBuilder.append(File.separator);
    localStringBuilder.append("emoji_folder_");
    localStringBuilder.append(paramString);
    return localStringBuilder.toString();
  }
  
  private static void b(DoodleEmojiManager paramDoodleEmojiManager, String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("emoji_pack_url_");
    localStringBuilder.append(paramString1);
    paramDoodleEmojiManager.a(localStringBuilder.toString(), paramString2);
  }
  
  private static boolean b(File paramFile)
  {
    if ((paramFile != null) && (paramFile.exists()))
    {
      if (!paramFile.isDirectory()) {
        return false;
      }
      paramFile = paramFile.listFiles(new DoodleEmojiManager.6());
      if ((paramFile != null) && (paramFile.length > 0)) {
        return true;
      }
    }
    return false;
  }
  
  public static String c(DoodleEmojiManager paramDoodleEmojiManager, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("emoji_pack_config_");
    localStringBuilder.append(paramString);
    return paramDoodleEmojiManager.b(localStringBuilder.toString(), "");
  }
  
  private static void c(DoodleEmojiManager paramDoodleEmojiManager, String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("emoji_pack_name_");
    localStringBuilder.append(paramString1);
    paramDoodleEmojiManager.a(localStringBuilder.toString(), paramString2);
  }
  
  private static void c(String paramString)
  {
    paramString = new File(paramString);
    boolean bool;
    if (paramString.isFile())
    {
      bool = paramString.delete();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("delete file : ");
      localStringBuilder.append(bool);
      SLog.d("DoodleEmojiManager", localStringBuilder.toString());
    }
    if (!paramString.exists())
    {
      bool = paramString.mkdirs();
      paramString = new StringBuilder();
      paramString.append("create folder : ");
      paramString.append(bool);
      SLog.d("DoodleEmojiManager", paramString.toString());
    }
  }
  
  public static String d(DoodleEmojiManager paramDoodleEmojiManager, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("emoji_pack_md5_");
    localStringBuilder.append(paramString);
    return paramDoodleEmojiManager.b(localStringBuilder.toString(), "");
  }
  
  private static void d(DoodleEmojiManager paramDoodleEmojiManager, String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("emoji_pack_config_");
    localStringBuilder.append(paramString1);
    paramDoodleEmojiManager.a(localStringBuilder.toString(), paramString2);
  }
  
  private boolean f()
  {
    return this.b.get() == 2;
  }
  
  public void a()
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("initLocalPackages, doodle emoji path : ");
    ((StringBuilder)localObject1).append(a);
    SLog.b("DoodleEmojiManager", ((StringBuilder)localObject1).toString());
    localObject1 = this.b;
    int n = 0;
    if (((AtomicInteger)localObject1).compareAndSet(0, 1))
    {
      localObject1 = (DoodleEmojiManager)QIMManager.a(14);
      Object localObject2 = new File(a);
      int i1;
      if ((((File)localObject2).exists()) && (((File)localObject2).isDirectory()))
      {
        localObject2 = ((File)localObject2).listFiles(new DoodleEmojiManager.1(this));
        if (localObject2 != null) {
          i1 = localObject2.length;
        }
      }
      else
      {
        while (n < i1)
        {
          Object localObject3 = localObject2[n];
          Object localObject4 = ((File)localObject3).listFiles(new DoodleEmojiManager.2(this));
          Object localObject5;
          if ((localObject4 != null) && (localObject4.length > 0))
          {
            localObject4 = a((File)localObject3);
            localObject5 = b((DoodleEmojiManager)localObject1, (String)localObject4);
            localObject5 = new DoodleEmojiItem((String)localObject4, a((DoodleEmojiManager)localObject1, (String)localObject4), (String)localObject5, null, c((DoodleEmojiManager)localObject1, (String)localObject4), d((DoodleEmojiManager)localObject1, (String)localObject4));
            ((DoodleEmojiItem)localObject5).setLocalEmojiFolderPath(((File)localObject3).getPath());
            this.f.put(localObject4, localObject5);
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("load local emoji pack : ");
            ((StringBuilder)localObject3).append(localObject5);
            SLog.b("DoodleEmojiManager", ((StringBuilder)localObject3).toString());
          }
          else
          {
            try
            {
              FileUtils.e(((File)localObject3).getPath());
              localObject4 = new StringBuilder();
              ((StringBuilder)localObject4).append("find empty local emoji folder : ");
              ((StringBuilder)localObject4).append(((File)localObject3).getName());
              ((StringBuilder)localObject4).append(", delete it");
              SLog.d("DoodleEmojiManager", ((StringBuilder)localObject4).toString());
            }
            catch (Exception localException)
            {
              localObject5 = new StringBuilder();
              ((StringBuilder)localObject5).append("find empty local emoji folder : ");
              ((StringBuilder)localObject5).append(((File)localObject3).getName());
              ((StringBuilder)localObject5).append(", delete failed : ");
              ((StringBuilder)localObject5).append(localException);
              SLog.d("DoodleEmojiManager", ((StringBuilder)localObject5).toString());
            }
          }
          n += 1;
          continue;
          SLog.d("DoodleEmojiManager", "local emoji folder is empty");
        }
      }
      a(((QIMPasterConfigManager)QIMManager.a(1)).a());
      this.b.set(2);
    }
  }
  
  public void a(int paramInt1, int paramInt2, DoodleEmojiManager.POIPostersRequestCallback paramPOIPostersRequestCallback)
  {
    paramPOIPostersRequestCallback = new WeakReference(paramPOIPostersRequestCallback);
    CmdTaskManger.a().a(new GetPoiFacesRequest(paramInt1, paramInt2), new DoodleEmojiManager.5(this, paramPOIPostersRequestCallback));
  }
  
  public void a(@NonNull String paramString1, @NonNull String paramString2)
  {
    this.m.edit().putString(paramString1, paramString2).apply();
  }
  
  /* Error */
  public void a(List<DoodleEmojiItem> arg1)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull +4 -> 5
    //   4: return
    //   5: bipush 14
    //   7: invokestatic 230	com/tencent/aelight/camera/aioeditor/capture/QIMManager:a	(I)Lcom/tencent/aelight/camera/aioeditor/capture/IQIMManager;
    //   10: checkcast 2	com/tencent/aelight/camera/aioeditor/takevideo/doodle/model/DoodleEmojiManager
    //   13: astore 4
    //   15: new 99	java/util/ArrayList
    //   18: dup
    //   19: aload_1
    //   20: invokeinterface 337 1 0
    //   25: invokespecial 338	java/util/ArrayList:<init>	(I)V
    //   28: astore_3
    //   29: aload_1
    //   30: invokeinterface 342 1 0
    //   35: astore 5
    //   37: aload 5
    //   39: invokeinterface 347 1 0
    //   44: ifeq +256 -> 300
    //   47: aload 5
    //   49: invokeinterface 351 1 0
    //   54: checkcast 245	com/tencent/aelight/camera/aioeditor/takevideo/doodle/model/DoodleEmojiItem
    //   57: astore 6
    //   59: aload 6
    //   61: getfield 354	com/tencent/aelight/camera/aioeditor/takevideo/doodle/model/DoodleEmojiItem:type	I
    //   64: iconst_1
    //   65: if_icmpne +129 -> 194
    //   68: aload_0
    //   69: getfield 86	com/tencent/aelight/camera/aioeditor/takevideo/doodle/model/DoodleEmojiManager:f	Ljava/util/concurrent/ConcurrentHashMap;
    //   72: aload 6
    //   74: getfield 357	com/tencent/aelight/camera/aioeditor/takevideo/doodle/model/DoodleEmojiItem:pack_id	Ljava/lang/String;
    //   77: invokevirtual 360	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   80: checkcast 245	com/tencent/aelight/camera/aioeditor/takevideo/doodle/model/DoodleEmojiItem
    //   83: astore_1
    //   84: aload_1
    //   85: ifnull +109 -> 194
    //   88: aload_1
    //   89: invokevirtual 363	com/tencent/aelight/camera/aioeditor/takevideo/doodle/model/DoodleEmojiItem:getLocalEmojiFolderPath	()Ljava/lang/String;
    //   92: astore_2
    //   93: aload_1
    //   94: getfield 366	com/tencent/aelight/camera/aioeditor/takevideo/doodle/model/DoodleEmojiItem:md5	Ljava/lang/String;
    //   97: aload 6
    //   99: getfield 366	com/tencent/aelight/camera/aioeditor/takevideo/doodle/model/DoodleEmojiItem:md5	Ljava/lang/String;
    //   102: invokestatic 372	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   105: ifne +84 -> 189
    //   108: ldc 202
    //   110: ldc_w 374
    //   113: aload_1
    //   114: getfield 366	com/tencent/aelight/camera/aioeditor/takevideo/doodle/model/DoodleEmojiItem:md5	Ljava/lang/String;
    //   117: aload 6
    //   119: getfield 366	com/tencent/aelight/camera/aioeditor/takevideo/doodle/model/DoodleEmojiItem:md5	Ljava/lang/String;
    //   122: invokestatic 377	com/tencent/biz/qqstory/support/logging/SLog:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V
    //   125: aload_2
    //   126: invokestatic 274	com/tencent/biz/qqstory/utils/FileUtils:e	(Ljava/lang/String;)Z
    //   129: pop
    //   130: new 379	com/tencent/aelight/camera/aioeditor/takevideo/doodle/model/DoodleEmojiManager$DoodleEmojiDownloadEvent
    //   133: dup
    //   134: aload 6
    //   136: iconst_0
    //   137: iconst_0
    //   138: lconst_0
    //   139: lconst_0
    //   140: invokespecial 382	com/tencent/aelight/camera/aioeditor/takevideo/doodle/model/DoodleEmojiManager$DoodleEmojiDownloadEvent:<init>	(Lcom/tencent/aelight/camera/aioeditor/takevideo/doodle/model/DoodleEmojiItem;IZJJ)V
    //   143: astore_1
    //   144: aload_1
    //   145: iconst_1
    //   146: putfield 385	com/tencent/aelight/camera/aioeditor/takevideo/doodle/model/DoodleEmojiManager$DoodleEmojiDownloadEvent:d	Z
    //   149: invokestatic 390	com/tencent/biz/qqstory/base/StoryDispatcher:a	()Lcom/tribe/async/dispatch/Dispatcher;
    //   152: aload_1
    //   153: invokeinterface 396 2 0
    //   158: goto +36 -> 194
    //   161: astore_1
    //   162: goto +4 -> 166
    //   165: astore_1
    //   166: ldc 202
    //   168: ldc_w 398
    //   171: iconst_2
    //   172: anewarray 72	java/lang/Object
    //   175: dup
    //   176: iconst_0
    //   177: aload_2
    //   178: aastore
    //   179: dup
    //   180: iconst_1
    //   181: aload_1
    //   182: aastore
    //   183: invokestatic 401	com/tencent/biz/qqstory/support/logging/SLog:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   186: goto +8 -> 194
    //   189: aload_2
    //   190: astore_1
    //   191: goto +5 -> 196
    //   194: aconst_null
    //   195: astore_1
    //   196: aload 6
    //   198: aload_1
    //   199: invokevirtual 260	com/tencent/aelight/camera/aioeditor/takevideo/doodle/model/DoodleEmojiItem:setLocalEmojiFolderPath	(Ljava/lang/String;)V
    //   202: aload 4
    //   204: aload 6
    //   206: getfield 357	com/tencent/aelight/camera/aioeditor/takevideo/doodle/model/DoodleEmojiItem:pack_id	Ljava/lang/String;
    //   209: aload 6
    //   211: getfield 404	com/tencent/aelight/camera/aioeditor/takevideo/doodle/model/DoodleEmojiItem:icon	Ljava/lang/String;
    //   214: invokestatic 406	com/tencent/aelight/camera/aioeditor/takevideo/doodle/model/DoodleEmojiManager:b	(Lcom/tencent/aelight/camera/aioeditor/takevideo/doodle/model/DoodleEmojiManager;Ljava/lang/String;Ljava/lang/String;)V
    //   217: aload 4
    //   219: aload 6
    //   221: getfield 357	com/tencent/aelight/camera/aioeditor/takevideo/doodle/model/DoodleEmojiItem:pack_id	Ljava/lang/String;
    //   224: aload 6
    //   226: getfield 409	com/tencent/aelight/camera/aioeditor/takevideo/doodle/model/DoodleEmojiItem:name	Ljava/lang/String;
    //   229: invokestatic 411	com/tencent/aelight/camera/aioeditor/takevideo/doodle/model/DoodleEmojiManager:c	(Lcom/tencent/aelight/camera/aioeditor/takevideo/doodle/model/DoodleEmojiManager;Ljava/lang/String;Ljava/lang/String;)V
    //   232: aload 4
    //   234: aload 6
    //   236: getfield 357	com/tencent/aelight/camera/aioeditor/takevideo/doodle/model/DoodleEmojiItem:pack_id	Ljava/lang/String;
    //   239: aload 6
    //   241: getfield 414	com/tencent/aelight/camera/aioeditor/takevideo/doodle/model/DoodleEmojiItem:config	Ljava/lang/String;
    //   244: invokestatic 416	com/tencent/aelight/camera/aioeditor/takevideo/doodle/model/DoodleEmojiManager:d	(Lcom/tencent/aelight/camera/aioeditor/takevideo/doodle/model/DoodleEmojiManager;Ljava/lang/String;Ljava/lang/String;)V
    //   247: aload 4
    //   249: aload 6
    //   251: getfield 357	com/tencent/aelight/camera/aioeditor/takevideo/doodle/model/DoodleEmojiItem:pack_id	Ljava/lang/String;
    //   254: aload 6
    //   256: getfield 366	com/tencent/aelight/camera/aioeditor/takevideo/doodle/model/DoodleEmojiItem:md5	Ljava/lang/String;
    //   259: invokestatic 418	com/tencent/aelight/camera/aioeditor/takevideo/doodle/model/DoodleEmojiManager:a	(Lcom/tencent/aelight/camera/aioeditor/takevideo/doodle/model/DoodleEmojiManager;Ljava/lang/String;Ljava/lang/String;)V
    //   262: aload_0
    //   263: getfield 86	com/tencent/aelight/camera/aioeditor/takevideo/doodle/model/DoodleEmojiManager:f	Ljava/util/concurrent/ConcurrentHashMap;
    //   266: aload 6
    //   268: getfield 357	com/tencent/aelight/camera/aioeditor/takevideo/doodle/model/DoodleEmojiItem:pack_id	Ljava/lang/String;
    //   271: aload 6
    //   273: invokevirtual 264	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   276: pop
    //   277: aload_3
    //   278: aload 6
    //   280: invokeinterface 422 2 0
    //   285: ifne -248 -> 37
    //   288: aload_3
    //   289: aload 6
    //   291: invokeinterface 425 2 0
    //   296: pop
    //   297: goto -260 -> 37
    //   300: aload_0
    //   301: getfield 91	com/tencent/aelight/camera/aioeditor/takevideo/doodle/model/DoodleEmojiManager:g	Ljava/util/List;
    //   304: astore_1
    //   305: aload_1
    //   306: monitorenter
    //   307: aload_0
    //   308: getfield 91	com/tencent/aelight/camera/aioeditor/takevideo/doodle/model/DoodleEmojiManager:g	Ljava/util/List;
    //   311: invokeinterface 428 1 0
    //   316: aload_0
    //   317: getfield 91	com/tencent/aelight/camera/aioeditor/takevideo/doodle/model/DoodleEmojiManager:g	Ljava/util/List;
    //   320: aload_3
    //   321: invokeinterface 432 2 0
    //   326: pop
    //   327: aload_1
    //   328: monitorexit
    //   329: invokestatic 437	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   332: ifeq +43 -> 375
    //   335: new 39	java/lang/StringBuilder
    //   338: dup
    //   339: invokespecial 42	java/lang/StringBuilder:<init>	()V
    //   342: astore_1
    //   343: aload_1
    //   344: ldc_w 439
    //   347: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   350: pop
    //   351: aload_1
    //   352: aload_0
    //   353: getfield 91	com/tencent/aelight/camera/aioeditor/takevideo/doodle/model/DoodleEmojiManager:g	Ljava/util/List;
    //   356: invokeinterface 337 1 0
    //   361: invokevirtual 442	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   364: pop
    //   365: ldc 202
    //   367: iconst_2
    //   368: aload_1
    //   369: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   372: invokestatic 445	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   375: aload_3
    //   376: invokeinterface 337 1 0
    //   381: ifle +65 -> 446
    //   384: new 39	java/lang/StringBuilder
    //   387: dup
    //   388: invokespecial 42	java/lang/StringBuilder:<init>	()V
    //   391: astore_1
    //   392: aload_1
    //   393: ldc_w 447
    //   396: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   399: pop
    //   400: aload_1
    //   401: aload_3
    //   402: iconst_0
    //   403: invokeinterface 450 2 0
    //   408: checkcast 245	com/tencent/aelight/camera/aioeditor/takevideo/doodle/model/DoodleEmojiItem
    //   411: getfield 357	com/tencent/aelight/camera/aioeditor/takevideo/doodle/model/DoodleEmojiItem:pack_id	Ljava/lang/String;
    //   414: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   417: pop
    //   418: ldc 202
    //   420: aload_1
    //   421: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   424: invokestatic 221	com/tencent/biz/qqstory/support/logging/SLog:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   427: aload_0
    //   428: aload_3
    //   429: iconst_0
    //   430: invokeinterface 450 2 0
    //   435: checkcast 245	com/tencent/aelight/camera/aioeditor/takevideo/doodle/model/DoodleEmojiItem
    //   438: getfield 357	com/tencent/aelight/camera/aioeditor/takevideo/doodle/model/DoodleEmojiItem:pack_id	Ljava/lang/String;
    //   441: iconst_0
    //   442: invokevirtual 453	com/tencent/aelight/camera/aioeditor/takevideo/doodle/model/DoodleEmojiManager:a	(Ljava/lang/String;Z)Z
    //   445: pop
    //   446: return
    //   447: astore_2
    //   448: aload_1
    //   449: monitorexit
    //   450: goto +5 -> 455
    //   453: aload_2
    //   454: athrow
    //   455: goto -2 -> 453
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	458	0	this	DoodleEmojiManager
    //   92	98	2	str	String
    //   447	7	2	localObject	Object
    //   28	401	3	localArrayList	ArrayList
    //   13	235	4	localDoodleEmojiManager	DoodleEmojiManager
    //   35	13	5	localIterator	java.util.Iterator
    //   57	233	6	localDoodleEmojiItem	DoodleEmojiItem
    // Exception table:
    //   from	to	target	type
    //   130	158	161	java/lang/Exception
    //   125	130	165	java/lang/Exception
    //   307	329	447	finally
    //   448	450	447	finally
  }
  
  public boolean a(String paramString, boolean paramBoolean)
  {
    if (!f()) {
      SLog.d("DoodleEmojiManager", "downloadEmojiPack init state = %d", new Object[] { Integer.valueOf(this.b.get()) });
    }
    if (paramString != null)
    {
      Object localObject2 = (DoodleEmojiItem)this.f.get(paramString);
      if (localObject2 == null)
      {
        ??? = new StringBuilder();
        ((StringBuilder)???).append("can not find pack item by id ");
        ((StringBuilder)???).append(paramString);
        SLog.d("DoodleEmojiManager", ((StringBuilder)???).toString());
        return false;
      }
      ??? = new File(b(((DoodleEmojiItem)localObject2).pack_id));
      if ((b((File)???)) && (!paramBoolean))
      {
        SLog.d("DoodleEmojiManager", "already has local emoji folder, notify download success directly");
        ((DoodleEmojiItem)localObject2).setLocalEmojiFolderPath(((File)???).getPath());
        StoryDispatcher.a().dispatch(new DoodleEmojiManager.DoodleEmojiDownloadEvent((DoodleEmojiItem)localObject2, 0, true, 0L, 0L));
        return true;
      }
      if (!TextUtils.isEmpty(((DoodleEmojiItem)localObject2).getLocalEmojiFolderPath()))
      {
        SLog.d("DoodleEmojiManager", "local emoji folder is missing");
        ((DoodleEmojiItem)localObject2).setLocalEmojiFolderPath(null);
      }
      if (TextUtils.isEmpty(((DoodleEmojiItem)localObject2).download_url))
      {
        SLog.d("DoodleEmojiManager", "can not start download because of empty download-url is found");
        return false;
      }
      synchronized (this.c)
      {
        if (!this.d.contains(localObject2))
        {
          this.d.offer(localObject2);
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("downloadEmojiPack pack ");
          ((StringBuilder)localObject2).append(paramString);
          ((StringBuilder)localObject2).append(" enqueue");
          SLog.b("DoodleEmojiManager", ((StringBuilder)localObject2).toString());
        }
        else
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("downloadEmojiPack pack ");
          ((StringBuilder)localObject2).append(paramString);
          ((StringBuilder)localObject2).append(" is already in pending list");
          SLog.b("DoodleEmojiManager", ((StringBuilder)localObject2).toString());
        }
        b();
        return true;
      }
    }
    throw new IllegalArgumentException("pack id should not be null");
  }
  
  public String b(@NonNull String paramString1, @NonNull String paramString2)
  {
    return this.m.getString(paramString1, paramString2);
  }
  
  protected void b()
  {
    SLog.b("DoodleEmojiManager", "startDownload");
    synchronized (this.c)
    {
      StringBuilder localStringBuilder;
      if (this.e == null)
      {
        this.e = ((DoodleEmojiItem)this.d.poll());
        if (this.e != null)
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("downloader startDownload : ");
          localStringBuilder.append(this.e);
          SLog.b("DoodleEmojiManager", localStringBuilder.toString());
          Bosses.get().postJob(new DoodleEmojiManager.3(this, this.e));
        }
      }
      else
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("can not start download because find one is still downloading : ");
        localStringBuilder.append(this.e);
        SLog.b("DoodleEmojiManager", localStringBuilder.toString());
      }
      return;
    }
  }
  
  public void c() {}
  
  public void d()
  {
    LbsManager localLbsManager = (LbsManager)SuperManager.a(9);
    if (localLbsManager != null)
    {
      LbsManager.LbsUpdateListener localLbsUpdateListener = this.l;
      if (localLbsUpdateListener != null) {
        localLbsManager.b(localLbsUpdateListener);
      }
    }
    this.k = null;
  }
  
  public List<DoodleEmojiItem> e()
  {
    if (!f())
    {
      SLog.b("DoodleEmojiManager", "getCurrentEmojiPackList but not init yet");
      return Collections.EMPTY_LIST;
    }
    return this.g;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.doodle.model.DoodleEmojiManager
 * JD-Core Version:    0.7.0.1
 */