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
  public final int a;
  private SharedPreferences jdField_a_of_type_AndroidContentSharedPreferences;
  public DoodleEmojiItem a;
  DoodleEmojiManager.POIPostersRequestCallback jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleModelDoodleEmojiManager$POIPostersRequestCallback = null;
  LbsManager.LbsUpdateListener jdField_a_of_type_ComTencentBizQqstoryModelLbsLbsManager$LbsUpdateListener = new DoodleEmojiManager.4(this);
  public final Object a;
  public final List<DoodleEmojiItem> a;
  public final Queue<DoodleEmojiItem> a;
  public final ConcurrentHashMap<String, DoodleEmojiItem> a;
  public volatile AtomicInteger a;
  public String b;
  protected List<Location> b;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(QQStoryConstant.k);
    localStringBuilder.append("emoji");
    jdField_a_of_type_JavaLangString = localStringBuilder.toString();
    a(jdField_a_of_type_JavaLangString);
  }
  
  public DoodleEmojiManager()
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
    this.jdField_a_of_type_JavaLangObject = new Object[0];
    this.jdField_a_of_type_JavaUtilQueue = new LinkedList();
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleModelDoodleEmojiItem = null;
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_a_of_type_JavaUtilList = new CopyOnWriteArrayList();
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_a_of_type_Int = 50;
    this.jdField_b_of_type_JavaUtilList = new ArrayList();
    BaseApplicationImpl localBaseApplicationImpl = QQStoryContext.a().a();
    if (localBaseApplicationImpl != null)
    {
      this.jdField_a_of_type_AndroidContentSharedPreferences = localBaseApplicationImpl.getSharedPreferences("qqstory_emoji", 4);
      return;
    }
    throw new IllegalArgumentException("Context should not be null");
  }
  
  public static String a(DoodleEmojiManager paramDoodleEmojiManager, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("emoji_pack_url_");
    localStringBuilder.append(paramString);
    return paramDoodleEmojiManager.a(localStringBuilder.toString(), "");
  }
  
  private static String a(@NonNull File paramFile)
  {
    return paramFile.getName().substring(13);
  }
  
  protected static String a(@NonNull String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(jdField_a_of_type_JavaLangString);
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
  
  private static void a(String paramString)
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
  
  private boolean a()
  {
    return this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 2;
  }
  
  private static boolean a(File paramFile)
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
  
  public static String b(DoodleEmojiManager paramDoodleEmojiManager, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("emoji_pack_name_");
    localStringBuilder.append(paramString);
    return paramDoodleEmojiManager.a(localStringBuilder.toString(), "");
  }
  
  protected static String b(@NonNull String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(jdField_a_of_type_JavaLangString);
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
  
  public static String c(DoodleEmojiManager paramDoodleEmojiManager, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("emoji_pack_config_");
    localStringBuilder.append(paramString);
    return paramDoodleEmojiManager.a(localStringBuilder.toString(), "");
  }
  
  private static void c(DoodleEmojiManager paramDoodleEmojiManager, String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("emoji_pack_name_");
    localStringBuilder.append(paramString1);
    paramDoodleEmojiManager.a(localStringBuilder.toString(), paramString2);
  }
  
  public static String d(DoodleEmojiManager paramDoodleEmojiManager, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("emoji_pack_md5_");
    localStringBuilder.append(paramString);
    return paramDoodleEmojiManager.a(localStringBuilder.toString(), "");
  }
  
  private static void d(DoodleEmojiManager paramDoodleEmojiManager, String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("emoji_pack_config_");
    localStringBuilder.append(paramString1);
    paramDoodleEmojiManager.a(localStringBuilder.toString(), paramString2);
  }
  
  public String a(@NonNull String paramString1, @NonNull String paramString2)
  {
    return this.jdField_a_of_type_AndroidContentSharedPreferences.getString(paramString1, paramString2);
  }
  
  public List<DoodleEmojiItem> a()
  {
    if (!a())
    {
      SLog.b("DoodleEmojiManager", "getCurrentEmojiPackList but not init yet");
      return Collections.EMPTY_LIST;
    }
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public void a() {}
  
  public void a(int paramInt1, int paramInt2, DoodleEmojiManager.POIPostersRequestCallback paramPOIPostersRequestCallback)
  {
    paramPOIPostersRequestCallback = new WeakReference(paramPOIPostersRequestCallback);
    CmdTaskManger.a().a(new GetPoiFacesRequest(paramInt1, paramInt2), new DoodleEmojiManager.5(this, paramPOIPostersRequestCallback));
  }
  
  public void a(@NonNull String paramString1, @NonNull String paramString2)
  {
    this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putString(paramString1, paramString2).apply();
  }
  
  /* Error */
  public void a(List<DoodleEmojiItem> arg1)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull +4 -> 5
    //   4: return
    //   5: bipush 14
    //   7: invokestatic 271	com/tencent/aelight/camera/aioeditor/capture/QIMManager:a	(I)Lcom/tencent/aelight/camera/aioeditor/capture/IQIMManager;
    //   10: checkcast 2	com/tencent/aelight/camera/aioeditor/takevideo/doodle/model/DoodleEmojiManager
    //   13: astore 4
    //   15: new 89	java/util/ArrayList
    //   18: dup
    //   19: aload_1
    //   20: invokeinterface 276 1 0
    //   25: invokespecial 277	java/util/ArrayList:<init>	(I)V
    //   28: astore_3
    //   29: aload_1
    //   30: invokeinterface 281 1 0
    //   35: astore 5
    //   37: aload 5
    //   39: invokeinterface 286 1 0
    //   44: ifeq +256 -> 300
    //   47: aload 5
    //   49: invokeinterface 290 1 0
    //   54: checkcast 292	com/tencent/aelight/camera/aioeditor/takevideo/doodle/model/DoodleEmojiItem
    //   57: astore 6
    //   59: aload 6
    //   61: getfield 295	com/tencent/aelight/camera/aioeditor/takevideo/doodle/model/DoodleEmojiItem:type	I
    //   64: iconst_1
    //   65: if_icmpne +129 -> 194
    //   68: aload_0
    //   69: getfield 76	com/tencent/aelight/camera/aioeditor/takevideo/doodle/model/DoodleEmojiManager:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   72: aload 6
    //   74: getfield 298	com/tencent/aelight/camera/aioeditor/takevideo/doodle/model/DoodleEmojiItem:pack_id	Ljava/lang/String;
    //   77: invokevirtual 301	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   80: checkcast 292	com/tencent/aelight/camera/aioeditor/takevideo/doodle/model/DoodleEmojiItem
    //   83: astore_1
    //   84: aload_1
    //   85: ifnull +109 -> 194
    //   88: aload_1
    //   89: invokevirtual 304	com/tencent/aelight/camera/aioeditor/takevideo/doodle/model/DoodleEmojiItem:getLocalEmojiFolderPath	()Ljava/lang/String;
    //   92: astore_2
    //   93: aload_1
    //   94: getfield 307	com/tencent/aelight/camera/aioeditor/takevideo/doodle/model/DoodleEmojiItem:md5	Ljava/lang/String;
    //   97: aload 6
    //   99: getfield 307	com/tencent/aelight/camera/aioeditor/takevideo/doodle/model/DoodleEmojiItem:md5	Ljava/lang/String;
    //   102: invokestatic 313	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   105: ifne +84 -> 189
    //   108: ldc 172
    //   110: ldc_w 315
    //   113: aload_1
    //   114: getfield 307	com/tencent/aelight/camera/aioeditor/takevideo/doodle/model/DoodleEmojiItem:md5	Ljava/lang/String;
    //   117: aload 6
    //   119: getfield 307	com/tencent/aelight/camera/aioeditor/takevideo/doodle/model/DoodleEmojiItem:md5	Ljava/lang/String;
    //   122: invokestatic 318	com/tencent/biz/qqstory/support/logging/SLog:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V
    //   125: aload_2
    //   126: invokestatic 323	com/tencent/biz/qqstory/utils/FileUtils:d	(Ljava/lang/String;)Z
    //   129: pop
    //   130: new 325	com/tencent/aelight/camera/aioeditor/takevideo/doodle/model/DoodleEmojiManager$DoodleEmojiDownloadEvent
    //   133: dup
    //   134: aload 6
    //   136: iconst_0
    //   137: iconst_0
    //   138: lconst_0
    //   139: lconst_0
    //   140: invokespecial 328	com/tencent/aelight/camera/aioeditor/takevideo/doodle/model/DoodleEmojiManager$DoodleEmojiDownloadEvent:<init>	(Lcom/tencent/aelight/camera/aioeditor/takevideo/doodle/model/DoodleEmojiItem;IZJJ)V
    //   143: astore_1
    //   144: aload_1
    //   145: iconst_1
    //   146: putfield 331	com/tencent/aelight/camera/aioeditor/takevideo/doodle/model/DoodleEmojiManager$DoodleEmojiDownloadEvent:b	Z
    //   149: invokestatic 336	com/tencent/biz/qqstory/base/StoryDispatcher:a	()Lcom/tribe/async/dispatch/Dispatcher;
    //   152: aload_1
    //   153: invokeinterface 342 2 0
    //   158: goto +36 -> 194
    //   161: astore_1
    //   162: goto +4 -> 166
    //   165: astore_1
    //   166: ldc 172
    //   168: ldc_w 344
    //   171: iconst_2
    //   172: anewarray 62	java/lang/Object
    //   175: dup
    //   176: iconst_0
    //   177: aload_2
    //   178: aastore
    //   179: dup
    //   180: iconst_1
    //   181: aload_1
    //   182: aastore
    //   183: invokestatic 347	com/tencent/biz/qqstory/support/logging/SLog:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   186: goto +8 -> 194
    //   189: aload_2
    //   190: astore_1
    //   191: goto +5 -> 196
    //   194: aconst_null
    //   195: astore_1
    //   196: aload 6
    //   198: aload_1
    //   199: invokevirtual 350	com/tencent/aelight/camera/aioeditor/takevideo/doodle/model/DoodleEmojiItem:setLocalEmojiFolderPath	(Ljava/lang/String;)V
    //   202: aload 4
    //   204: aload 6
    //   206: getfield 298	com/tencent/aelight/camera/aioeditor/takevideo/doodle/model/DoodleEmojiItem:pack_id	Ljava/lang/String;
    //   209: aload 6
    //   211: getfield 353	com/tencent/aelight/camera/aioeditor/takevideo/doodle/model/DoodleEmojiItem:icon	Ljava/lang/String;
    //   214: invokestatic 355	com/tencent/aelight/camera/aioeditor/takevideo/doodle/model/DoodleEmojiManager:b	(Lcom/tencent/aelight/camera/aioeditor/takevideo/doodle/model/DoodleEmojiManager;Ljava/lang/String;Ljava/lang/String;)V
    //   217: aload 4
    //   219: aload 6
    //   221: getfield 298	com/tencent/aelight/camera/aioeditor/takevideo/doodle/model/DoodleEmojiItem:pack_id	Ljava/lang/String;
    //   224: aload 6
    //   226: getfield 358	com/tencent/aelight/camera/aioeditor/takevideo/doodle/model/DoodleEmojiItem:name	Ljava/lang/String;
    //   229: invokestatic 360	com/tencent/aelight/camera/aioeditor/takevideo/doodle/model/DoodleEmojiManager:c	(Lcom/tencent/aelight/camera/aioeditor/takevideo/doodle/model/DoodleEmojiManager;Ljava/lang/String;Ljava/lang/String;)V
    //   232: aload 4
    //   234: aload 6
    //   236: getfield 298	com/tencent/aelight/camera/aioeditor/takevideo/doodle/model/DoodleEmojiItem:pack_id	Ljava/lang/String;
    //   239: aload 6
    //   241: getfield 363	com/tencent/aelight/camera/aioeditor/takevideo/doodle/model/DoodleEmojiItem:config	Ljava/lang/String;
    //   244: invokestatic 365	com/tencent/aelight/camera/aioeditor/takevideo/doodle/model/DoodleEmojiManager:d	(Lcom/tencent/aelight/camera/aioeditor/takevideo/doodle/model/DoodleEmojiManager;Ljava/lang/String;Ljava/lang/String;)V
    //   247: aload 4
    //   249: aload 6
    //   251: getfield 298	com/tencent/aelight/camera/aioeditor/takevideo/doodle/model/DoodleEmojiItem:pack_id	Ljava/lang/String;
    //   254: aload 6
    //   256: getfield 307	com/tencent/aelight/camera/aioeditor/takevideo/doodle/model/DoodleEmojiItem:md5	Ljava/lang/String;
    //   259: invokestatic 367	com/tencent/aelight/camera/aioeditor/takevideo/doodle/model/DoodleEmojiManager:a	(Lcom/tencent/aelight/camera/aioeditor/takevideo/doodle/model/DoodleEmojiManager;Ljava/lang/String;Ljava/lang/String;)V
    //   262: aload_0
    //   263: getfield 76	com/tencent/aelight/camera/aioeditor/takevideo/doodle/model/DoodleEmojiManager:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   266: aload 6
    //   268: getfield 298	com/tencent/aelight/camera/aioeditor/takevideo/doodle/model/DoodleEmojiItem:pack_id	Ljava/lang/String;
    //   271: aload 6
    //   273: invokevirtual 371	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   276: pop
    //   277: aload_3
    //   278: aload 6
    //   280: invokeinterface 375 2 0
    //   285: ifne -248 -> 37
    //   288: aload_3
    //   289: aload 6
    //   291: invokeinterface 378 2 0
    //   296: pop
    //   297: goto -260 -> 37
    //   300: aload_0
    //   301: getfield 81	com/tencent/aelight/camera/aioeditor/takevideo/doodle/model/DoodleEmojiManager:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   304: astore_1
    //   305: aload_1
    //   306: monitorenter
    //   307: aload_0
    //   308: getfield 81	com/tencent/aelight/camera/aioeditor/takevideo/doodle/model/DoodleEmojiManager:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   311: invokeinterface 381 1 0
    //   316: aload_0
    //   317: getfield 81	com/tencent/aelight/camera/aioeditor/takevideo/doodle/model/DoodleEmojiManager:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   320: aload_3
    //   321: invokeinterface 385 2 0
    //   326: pop
    //   327: aload_1
    //   328: monitorexit
    //   329: invokestatic 390	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   332: ifeq +43 -> 375
    //   335: new 28	java/lang/StringBuilder
    //   338: dup
    //   339: invokespecial 31	java/lang/StringBuilder:<init>	()V
    //   342: astore_1
    //   343: aload_1
    //   344: ldc_w 392
    //   347: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   350: pop
    //   351: aload_1
    //   352: aload_0
    //   353: getfield 81	com/tencent/aelight/camera/aioeditor/takevideo/doodle/model/DoodleEmojiManager:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   356: invokeinterface 276 1 0
    //   361: invokevirtual 395	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   364: pop
    //   365: ldc 172
    //   367: iconst_2
    //   368: aload_1
    //   369: invokevirtual 46	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   372: invokestatic 399	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   375: aload_3
    //   376: invokeinterface 276 1 0
    //   381: ifle +65 -> 446
    //   384: new 28	java/lang/StringBuilder
    //   387: dup
    //   388: invokespecial 31	java/lang/StringBuilder:<init>	()V
    //   391: astore_1
    //   392: aload_1
    //   393: ldc_w 401
    //   396: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   399: pop
    //   400: aload_1
    //   401: aload_3
    //   402: iconst_0
    //   403: invokeinterface 404 2 0
    //   408: checkcast 292	com/tencent/aelight/camera/aioeditor/takevideo/doodle/model/DoodleEmojiItem
    //   411: getfield 298	com/tencent/aelight/camera/aioeditor/takevideo/doodle/model/DoodleEmojiItem:pack_id	Ljava/lang/String;
    //   414: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   417: pop
    //   418: ldc 172
    //   420: aload_1
    //   421: invokevirtual 46	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   424: invokestatic 219	com/tencent/biz/qqstory/support/logging/SLog:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   427: aload_0
    //   428: aload_3
    //   429: iconst_0
    //   430: invokeinterface 404 2 0
    //   435: checkcast 292	com/tencent/aelight/camera/aioeditor/takevideo/doodle/model/DoodleEmojiItem
    //   438: getfield 298	com/tencent/aelight/camera/aioeditor/takevideo/doodle/model/DoodleEmojiItem:pack_id	Ljava/lang/String;
    //   441: iconst_0
    //   442: invokevirtual 407	com/tencent/aelight/camera/aioeditor/takevideo/doodle/model/DoodleEmojiManager:a	(Ljava/lang/String;Z)Z
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
    if (!a()) {
      SLog.d("DoodleEmojiManager", "downloadEmojiPack init state = %d", new Object[] { Integer.valueOf(this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get()) });
    }
    if (paramString != null)
    {
      Object localObject2 = (DoodleEmojiItem)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
      if (localObject2 == null)
      {
        ??? = new StringBuilder();
        ((StringBuilder)???).append("can not find pack item by id ");
        ((StringBuilder)???).append(paramString);
        SLog.d("DoodleEmojiManager", ((StringBuilder)???).toString());
        return false;
      }
      ??? = new File(b(((DoodleEmojiItem)localObject2).pack_id));
      if ((a((File)???)) && (!paramBoolean))
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
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        if (!this.jdField_a_of_type_JavaUtilQueue.contains(localObject2))
        {
          this.jdField_a_of_type_JavaUtilQueue.offer(localObject2);
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
        d();
        return true;
      }
    }
    throw new IllegalArgumentException("pack id should not be null");
  }
  
  public void b()
  {
    LbsManager localLbsManager = (LbsManager)SuperManager.a(9);
    if (localLbsManager != null)
    {
      LbsManager.LbsUpdateListener localLbsUpdateListener = this.jdField_a_of_type_ComTencentBizQqstoryModelLbsLbsManager$LbsUpdateListener;
      if (localLbsUpdateListener != null) {
        localLbsManager.b(localLbsUpdateListener);
      }
    }
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleModelDoodleEmojiManager$POIPostersRequestCallback = null;
  }
  
  public void c()
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("initLocalPackages, doodle emoji path : ");
    ((StringBuilder)localObject1).append(jdField_a_of_type_JavaLangString);
    SLog.b("DoodleEmojiManager", ((StringBuilder)localObject1).toString());
    localObject1 = this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger;
    int i = 0;
    if (((AtomicInteger)localObject1).compareAndSet(0, 1))
    {
      localObject1 = (DoodleEmojiManager)QIMManager.a(14);
      Object localObject2 = new File(jdField_a_of_type_JavaLangString);
      int j;
      if ((((File)localObject2).exists()) && (((File)localObject2).isDirectory()))
      {
        localObject2 = ((File)localObject2).listFiles(new DoodleEmojiManager.1(this));
        if (localObject2 != null) {
          j = localObject2.length;
        }
      }
      else
      {
        while (i < j)
        {
          Object localObject3 = localObject2[i];
          Object localObject4 = ((File)localObject3).listFiles(new DoodleEmojiManager.2(this));
          Object localObject5;
          if ((localObject4 != null) && (localObject4.length > 0))
          {
            localObject4 = a((File)localObject3);
            localObject5 = b((DoodleEmojiManager)localObject1, (String)localObject4);
            localObject5 = new DoodleEmojiItem((String)localObject4, a((DoodleEmojiManager)localObject1, (String)localObject4), (String)localObject5, null, c((DoodleEmojiManager)localObject1, (String)localObject4), d((DoodleEmojiManager)localObject1, (String)localObject4));
            ((DoodleEmojiItem)localObject5).setLocalEmojiFolderPath(((File)localObject3).getPath());
            this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(localObject4, localObject5);
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("load local emoji pack : ");
            ((StringBuilder)localObject3).append(localObject5);
            SLog.b("DoodleEmojiManager", ((StringBuilder)localObject3).toString());
          }
          else
          {
            try
            {
              FileUtils.d(((File)localObject3).getPath());
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
          i += 1;
          continue;
          SLog.d("DoodleEmojiManager", "local emoji folder is empty");
        }
      }
      a(((QIMPasterConfigManager)QIMManager.a(1)).a());
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(2);
    }
  }
  
  protected void d()
  {
    SLog.b("DoodleEmojiManager", "startDownload");
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      StringBuilder localStringBuilder;
      if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleModelDoodleEmojiItem == null)
      {
        this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleModelDoodleEmojiItem = ((DoodleEmojiItem)this.jdField_a_of_type_JavaUtilQueue.poll());
        if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleModelDoodleEmojiItem != null)
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("downloader startDownload : ");
          localStringBuilder.append(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleModelDoodleEmojiItem);
          SLog.b("DoodleEmojiManager", localStringBuilder.toString());
          Bosses.get().postJob(new DoodleEmojiManager.3(this, this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleModelDoodleEmojiItem));
        }
      }
      else
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("can not start download because find one is still downloading : ");
        localStringBuilder.append(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleModelDoodleEmojiItem);
        SLog.b("DoodleEmojiManager", localStringBuilder.toString());
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.doodle.model.DoodleEmojiManager
 * JD-Core Version:    0.7.0.1
 */