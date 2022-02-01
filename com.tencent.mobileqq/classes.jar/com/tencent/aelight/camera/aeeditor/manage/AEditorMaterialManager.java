package com.tencent.aelight.camera.aeeditor.manage;

import android.text.TextUtils;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaCategory;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.google.gson.Gson;
import com.tencent.aelight.camera.ae.AEPath.Editor.FILES;
import com.tencent.aelight.camera.ae.util.AECameraPrefsUtil;
import com.tencent.aelight.camera.aioeditor.shortvideo.QIMPtvTemplateManager;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.mobileqq.utils.FileUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import mqq.util.WeakReference;

public class AEditorMaterialManager
{
  private static volatile AEditorMaterialManager jdField_a_of_type_ComTencentAelightCameraAeeditorManageAEditorMaterialManager;
  private final Object jdField_a_of_type_JavaLangObject = new Object();
  public ArrayList<MetaMaterial> a;
  private WeakReference<AEditorMaterialManager.RecommendListener> jdField_a_of_type_MqqUtilWeakReference;
  public ArrayList<String> b;
  
  public static AEditorMaterialManager a()
  {
    if (jdField_a_of_type_ComTencentAelightCameraAeeditorManageAEditorMaterialManager == null) {
      try
      {
        if (jdField_a_of_type_ComTencentAelightCameraAeeditorManageAEditorMaterialManager == null) {
          jdField_a_of_type_ComTencentAelightCameraAeeditorManageAEditorMaterialManager = new AEditorMaterialManager();
        }
      }
      finally {}
    }
    return jdField_a_of_type_ComTencentAelightCameraAeeditorManageAEditorMaterialManager;
  }
  
  /* Error */
  public static String a(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aconst_null
    //   3: astore_1
    //   4: invokestatic 35	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   7: invokevirtual 41	com/tencent/qphone/base/util/BaseApplication:getAssets	()Landroid/content/res/AssetManager;
    //   10: aload_0
    //   11: invokevirtual 47	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   14: astore_3
    //   15: aload_3
    //   16: astore_1
    //   17: aload_3
    //   18: astore_2
    //   19: aload_3
    //   20: invokestatic 52	com/tencent/biz/common/util/Util:a	(Ljava/io/InputStream;)Ljava/lang/String;
    //   23: astore 4
    //   25: aload 4
    //   27: astore_0
    //   28: aload_3
    //   29: ifnull +91 -> 120
    //   32: aload_3
    //   33: invokevirtual 57	java/io/InputStream:close	()V
    //   36: aload 4
    //   38: areturn
    //   39: astore_0
    //   40: aload_0
    //   41: invokevirtual 60	java/io/IOException:printStackTrace	()V
    //   44: aload 4
    //   46: areturn
    //   47: astore_0
    //   48: goto +74 -> 122
    //   51: astore_3
    //   52: aload_2
    //   53: astore_1
    //   54: new 62	java/lang/StringBuilder
    //   57: dup
    //   58: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   61: astore 4
    //   63: aload_2
    //   64: astore_1
    //   65: aload 4
    //   67: ldc 65
    //   69: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   72: pop
    //   73: aload_2
    //   74: astore_1
    //   75: aload 4
    //   77: aload_0
    //   78: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   81: pop
    //   82: aload_2
    //   83: astore_1
    //   84: ldc 71
    //   86: aload 4
    //   88: invokevirtual 75	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   91: aload_3
    //   92: invokestatic 80	com/tencent/aelight/camera/log/AEQLog:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   95: aload_2
    //   96: astore_1
    //   97: aload_3
    //   98: invokevirtual 81	java/lang/Throwable:printStackTrace	()V
    //   101: aload_2
    //   102: ifnull +15 -> 117
    //   105: aload_2
    //   106: invokevirtual 57	java/io/InputStream:close	()V
    //   109: goto +8 -> 117
    //   112: astore_0
    //   113: aload_0
    //   114: invokevirtual 60	java/io/IOException:printStackTrace	()V
    //   117: ldc 83
    //   119: astore_0
    //   120: aload_0
    //   121: areturn
    //   122: aload_1
    //   123: ifnull +15 -> 138
    //   126: aload_1
    //   127: invokevirtual 57	java/io/InputStream:close	()V
    //   130: goto +8 -> 138
    //   133: astore_1
    //   134: aload_1
    //   135: invokevirtual 60	java/io/IOException:printStackTrace	()V
    //   138: aload_0
    //   139: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	140	0	paramString	String
    //   3	124	1	localObject1	Object
    //   133	2	1	localIOException	java.io.IOException
    //   1	105	2	localObject2	Object
    //   14	19	3	localInputStream	java.io.InputStream
    //   51	47	3	localThrowable	java.lang.Throwable
    //   23	64	4	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   32	36	39	java/io/IOException
    //   4	15	47	finally
    //   19	25	47	finally
    //   54	63	47	finally
    //   65	73	47	finally
    //   75	82	47	finally
    //   84	95	47	finally
    //   97	101	47	finally
    //   4	15	51	java/lang/Throwable
    //   19	25	51	java/lang/Throwable
    //   105	109	112	java/io/IOException
    //   126	130	133	java/io/IOException
  }
  
  private static List<MetaCategory> a(File paramFile)
  {
    ArrayList localArrayList = new ArrayList();
    paramFile = QIMPtvTemplateManager.a(paramFile);
    if (TextUtils.isEmpty(paramFile)) {
      return localArrayList;
    }
    paramFile = (ArrayList)new Gson().fromJson(paramFile, new AEditorMaterialManager.3().getType());
    if (paramFile != null)
    {
      if (paramFile.isEmpty()) {
        return localArrayList;
      }
      localArrayList.clear();
      localArrayList.addAll(paramFile);
    }
    return localArrayList;
  }
  
  private static List<MetaCategory> a(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    paramString = a(paramString);
    if (TextUtils.isEmpty(paramString)) {
      return localArrayList;
    }
    paramString = (ArrayList)new Gson().fromJson(paramString, new AEditorMaterialManager.1().getType());
    if (paramString != null)
    {
      if (paramString.isEmpty()) {
        return localArrayList;
      }
      localArrayList.clear();
      localArrayList.addAll(paramString);
    }
    return localArrayList;
  }
  
  private static List<MetaCategory> b()
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = a("camera/ae_camera_editor_auto_template.json");
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      return localArrayList;
    }
    localObject = (ArrayList)new Gson().fromJson((String)localObject, new AEditorMaterialManager.4().getType());
    if (localObject != null)
    {
      if (((ArrayList)localObject).isEmpty()) {
        return localArrayList;
      }
      localArrayList.clear();
      localArrayList.addAll((Collection)localObject);
    }
    return localArrayList;
  }
  
  public String a(String paramString1, String paramString2)
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      paramString1 = new File(paramString1);
      if (!paramString1.exists()) {
        paramString1.mkdirs();
      }
      paramString1 = new File(paramString1.getPath(), paramString2).getPath();
      return paramString1;
    }
  }
  
  public List<MetaCategory> a()
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      new ArrayList();
      File localFile = new File(AEPath.Editor.FILES.c, "editor_auto_template_update_template.json");
      Object localObject3 = new File(AEPath.Editor.FILES.c, "editor_auto_template_default.json");
      List localList2;
      List localList3;
      if (!localFile.exists())
      {
        List localList1;
        if (!((File)localObject3).exists())
        {
          AEQLog.a("[AEEditor2]AEditorMaterialManager", "readAndParseTextStickerConfigFile -> oldJson not exist, newJson not exist ");
          localList1 = b();
        }
        else
        {
          try
          {
            localList1 = a((File)localObject3);
            AEQLog.a("[AEEditor2]AEditorMaterialManager", "readAndParseTextStickerConfigFile -> oldJson exists, newJson not exist, use oldJson");
          }
          catch (Exception localException1)
          {
            FileUtils.deleteFile(((File)localObject3).getPath());
            AECameraPrefsUtil.a().a("ShadowBackendSvc.GetCircleCatMatTreeMqCircleEditor", 4);
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("readAndParseTextStickerConfigFile -> oldJson exists, newJson not exist, exception:");
            ((StringBuilder)localObject3).append(localException1.toString());
            AEQLog.d("[AEEditor2]AEditorMaterialManager", ((StringBuilder)localObject3).toString());
            localList2 = b();
          }
        }
      }
      else
      {
        try
        {
          localList2 = a(localFile);
          FileUtils.moveFile(localFile.getPath(), ((File)localObject3).getPath());
          AEQLog.a("[AEEditor2]AEditorMaterialManager", "readAndParseTextStickerConfigFile -> oldJson not exist, use newJson ");
        }
        catch (Exception localException2)
        {
          FileUtils.deleteFile(localFile.getPath());
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("readAndParseTextStickerConfigFile -> oldJson not exists: exception:");
          ((StringBuilder)localObject3).append(localException2.toString());
          AEQLog.d("[AEEditor2]AEditorMaterialManager", ((StringBuilder)localObject3).toString());
          AECameraPrefsUtil.a().a("ShadowBackendSvc.GetCircleCatMatTreeMqCircleEditor", 4);
          localList3 = b();
        }
      }
      if (this.jdField_a_of_type_JavaUtilArrayList == null) {
        this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
      }
      if (this.jdField_a_of_type_JavaUtilArrayList.isEmpty())
      {
        int i = 0;
        while (i < 5)
        {
          this.jdField_a_of_type_JavaUtilArrayList.add(new MetaMaterial());
          i += 1;
        }
      }
      localObject3 = new MetaCategory();
      ((MetaCategory)localObject3).name = "推荐";
      ((MetaCategory)localObject3).id = "recommend";
      localList3.add(0, localObject3);
      return localList3;
    }
    for (;;)
    {
      throw localObject1;
    }
  }
  
  public List<MetaCategory> a(String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("readAndParseConfigFile... parent:");
    ((StringBuilder)localObject1).append(paramString1);
    ((StringBuilder)localObject1).append(" newjson:");
    ((StringBuilder)localObject1).append(paramString2);
    ((StringBuilder)localObject1).append(" oldjson:");
    ((StringBuilder)localObject1).append(paramString3);
    AEQLog.a("[AEEditor2]AEditorMaterialManager", ((StringBuilder)localObject1).toString());
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      localObject1 = new ArrayList();
      File localFile1 = new File(paramString1, paramString2);
      File localFile2 = new File(paramString1, paramString3);
      if (!localFile1.exists())
      {
        if (!localFile2.exists())
        {
          AEQLog.a("[AEEditor2]AEditorMaterialManager", "readAndParseConfigFile -> oldJson not exist, newJson not exist ");
          paramString1 = a(paramString3);
        }
        else
        {
          paramString1 = (String)localObject1;
          try
          {
            paramString2 = a(localFile2);
            paramString1 = paramString2;
            AEQLog.a("[AEEditor2]AEditorMaterialManager", "readAndParseConfigFile -> oldJson exists, newJson not exist, use oldJson");
            paramString1 = paramString2;
          }
          catch (Exception paramString2)
          {
            FileUtils.deleteFile(localFile2.getPath());
            AECameraPrefsUtil.a().a("ShadowBackendSvc.GetCircleCatMatTreeMqCircleEditor", 4);
            paramString3 = new StringBuilder();
            paramString3.append("readAndParseConfigFile -> oldJson exists, newJson not exist, exception:");
            paramString3.append(paramString2.toString());
            AEQLog.d("[AEEditor2]AEditorMaterialManager", paramString3.toString());
          }
        }
      }
      else
      {
        paramString1 = (String)localObject1;
        try
        {
          paramString2 = a(localFile1);
          if (paramBoolean)
          {
            paramString1 = paramString2;
            FileUtils.moveFile(localFile1.getPath(), localFile2.getPath());
          }
          paramString1 = paramString2;
          paramString3 = new StringBuilder();
          paramString1 = paramString2;
          paramString3.append("readAndParseConfigFile -> oldJson not exist, use newJson isNeedMove:");
          paramString1 = paramString2;
          paramString3.append(paramBoolean);
          paramString1 = paramString2;
          AEQLog.a("[AEEditor2]AEditorMaterialManager", paramString3.toString());
          paramString1 = paramString2;
        }
        catch (Exception paramString2)
        {
          FileUtils.deleteFile(localFile1.getPath());
          paramString3 = new StringBuilder();
          paramString3.append("readAndParseConfigFile -> oldJson not exists: exception:");
          paramString3.append(paramString2.toString());
          AEQLog.d("[AEEditor2]AEditorMaterialManager", paramString3.toString());
          AECameraPrefsUtil.a().a("ShadowBackendSvc.GetCircleCatMatTreeMqCircleEditor", 4);
        }
      }
      return paramString1;
    }
  }
  
  public void a()
  {
    WeakReference localWeakReference = this.jdField_a_of_type_MqqUtilWeakReference;
    if ((localWeakReference != null) && (localWeakReference.get() != null)) {
      ((AEditorMaterialManager.RecommendListener)this.jdField_a_of_type_MqqUtilWeakReference.get()).b();
    }
  }
  
  public void a(ArrayList<MetaMaterial> paramArrayList, ArrayList<String> paramArrayList1)
  {
    this.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
    this.b = paramArrayList1;
    paramArrayList = this.jdField_a_of_type_MqqUtilWeakReference;
    if ((paramArrayList != null) && (paramArrayList.get() != null)) {
      ((AEditorMaterialManager.RecommendListener)this.jdField_a_of_type_MqqUtilWeakReference.get()).a();
    }
  }
  
  public void a(WeakReference<AEditorMaterialManager.RecommendListener> paramWeakReference)
  {
    this.jdField_a_of_type_MqqUtilWeakReference = paramWeakReference;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.manage.AEditorMaterialManager
 * JD-Core Version:    0.7.0.1
 */