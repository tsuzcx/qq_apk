import android.text.TextUtils;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.ae.data.AEMaterialConfigParser;
import dov.com.qq.im.ae.data.AEMaterialConfigParser.AEMaterialConfigParseException;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public final class bnki
{
  private final ArrayList<bnkl> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private final CopyOnWriteArrayList<bnka> jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList = new CopyOnWriteArrayList();
  private volatile boolean jdField_a_of_type_Boolean;
  
  public static bnki a()
  {
    return bnkk.a();
  }
  
  private List<bnka> a(File paramFile)
  {
    ArrayList localArrayList = new ArrayList();
    paramFile = bpqs.a(paramFile);
    if (TextUtils.isEmpty(paramFile)) {}
    do
    {
      return localArrayList;
      paramFile = AEMaterialConfigParser.a(paramFile);
    } while ((paramFile == null) || (paramFile.isEmpty()));
    return paramFile;
  }
  
  private List<bnka> a(File paramFile1, File paramFile2)
  {
    paramFile1 = a(paramFile1);
    List localList = a(paramFile2);
    if ((localList == null) || (localList.isEmpty())) {
      return paramFile1;
    }
    Iterator localIterator1 = paramFile1.iterator();
    Iterator localIterator2;
    if (localIterator1.hasNext())
    {
      paramFile2 = (bnka)localIterator1.next();
      localIterator2 = localList.iterator();
      do
      {
        if (!localIterator2.hasNext()) {
          break;
        }
        paramFile1 = (bnka)localIterator2.next();
      } while (!paramFile1.b.equals(paramFile2.b));
    }
    for (;;)
    {
      if (paramFile1 == null)
      {
        paramFile1 = paramFile2.a.iterator();
        while (paramFile1.hasNext()) {
          a((bnke)paramFile1.next());
        }
        break;
      }
      localIterator2 = paramFile2.a.iterator();
      label149:
      bnke localbnke;
      if (localIterator2.hasNext())
      {
        localbnke = (bnke)localIterator2.next();
        Iterator localIterator3 = paramFile1.a.iterator();
        do
        {
          if (!localIterator3.hasNext()) {
            break;
          }
          paramFile2 = (bnke)localIterator3.next();
        } while (!localbnke.a.equals(paramFile2.a));
      }
      for (;;)
      {
        if (paramFile2 == null)
        {
          a(localbnke);
          break label149;
        }
        if (localbnke.jdField_e_of_type_JavaLangString.equals(paramFile2.jdField_e_of_type_JavaLangString)) {
          break label149;
        }
        a(localbnke);
        break label149;
        break;
        return localList;
        paramFile2 = null;
      }
      paramFile1 = null;
    }
  }
  
  private void a(bnke parambnke)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AEWatermarkMaterialManager", 2, "deleteMaterialFolder: " + parambnke.a);
    }
    File localFile = new File(bmwk.jdField_e_of_type_JavaLangString, parambnke.a);
    if (localFile.exists()) {
      FileUtils.deleteDirectory(localFile.getPath());
    }
    parambnke = new File(bmwk.d, parambnke.a);
    if (parambnke.exists()) {
      FileUtils.deleteDirectory(parambnke.getPath());
    }
  }
  
  private void a(List<bnka> paramList)
  {
    if (paramList == null) {
      label4:
      return;
    } else {
      paramList = paramList.iterator();
    }
    for (;;)
    {
      if (!paramList.hasNext()) {
        break label4;
      }
      Object localObject = (bnka)paramList.next();
      if ((localObject == null) || (((bnka)localObject).a == null)) {
        break;
      }
      localObject = ((bnka)localObject).a.iterator();
      while (((Iterator)localObject).hasNext())
      {
        bnke localbnke = (bnke)((Iterator)localObject).next();
        if (localbnke != null) {
          localbnke.jdField_e_of_type_Boolean = bnkb.a(localbnke);
        }
      }
    }
  }
  
  private List<bnka> b()
  {
    Object localObject2 = new File(bmwu.b);
    Object localObject1 = new File(bmwu.a);
    if (!((File)localObject2).exists())
    {
      if (!((File)localObject1).exists())
      {
        localObject1 = new ArrayList();
        bnrh.a("AEWatermarkMaterialManager", "readAndParseConfigFile -> oldJson not exist, newJson not exist, use Json from assets ");
        b();
        return localObject1;
      }
      try
      {
        localObject2 = a((File)localObject1);
        bnrh.a("AEWatermarkMaterialManager", "readAndParseConfigFile -> oldJson exists, newJson not exist, use oldJson");
        return localObject2;
      }
      catch (AEMaterialConfigParser.AEMaterialConfigParseException localAEMaterialConfigParseException3)
      {
        FileUtils.deleteFile(((File)localObject1).getPath());
        localObject1 = new ArrayList();
        bnrh.d("AEWatermarkMaterialManager", "readAndParseConfigFile -> oldJson exists, newJson not exist, exception:" + localAEMaterialConfigParseException3.toString());
        b();
        return localObject1;
      }
    }
    List localList;
    ArrayList localArrayList;
    if (!((File)localObject1).exists()) {
      try
      {
        localList = a(localAEMaterialConfigParseException3);
        FileUtils.moveFile(localAEMaterialConfigParseException3.getPath(), ((File)localObject1).getPath());
        bnrh.a("AEWatermarkMaterialManager", "readAndParseConfigFile -> oldJson not exist, use newJson ");
        return localList;
      }
      catch (AEMaterialConfigParser.AEMaterialConfigParseException localAEMaterialConfigParseException1)
      {
        FileUtils.deleteFile(localAEMaterialConfigParseException3.getPath());
        localArrayList = new ArrayList();
        bnrh.d("AEWatermarkMaterialManager", "readAndParseConfigFile -> oldJson not exists: exception:" + localAEMaterialConfigParseException1.toString());
        b();
        return localArrayList;
      }
    }
    try
    {
      localList = a(localAEMaterialConfigParseException1, localArrayList);
      FileUtils.deleteFile(localAEMaterialConfigParseException1.getPath());
      FileUtils.moveFile(localArrayList.getPath(), localAEMaterialConfigParseException1.getPath());
      bnrh.a("AEWatermarkMaterialManager", "readAndParseConfigFile -> try check update ");
      return localList;
    }
    catch (AEMaterialConfigParser.AEMaterialConfigParseException localAEMaterialConfigParseException2)
    {
      localArrayList = new ArrayList();
      bnrh.d("AEWatermarkMaterialManager", "loadMaterialListFromAssets  -> oldJson exists: exception:" + localAEMaterialConfigParseException2.toString());
      b();
    }
    return localArrayList;
  }
  
  private void b()
  {
    bnqu.a().a("CameraModuleSvc.GetCompressedCategoryMaterialMqCircleWatermark", 4);
    try
    {
      this.jdField_a_of_type_Boolean = false;
      return;
    }
    finally {}
  }
  
  /* Error */
  @android.support.annotation.WorkerThread
  public List<bnka> a()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 106
    //   4: new 108	java/lang/StringBuilder
    //   7: dup
    //   8: invokespecial 109	java/lang/StringBuilder:<init>	()V
    //   11: ldc 212
    //   13: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16: aload_0
    //   17: getfield 209	bnki:jdField_a_of_type_Boolean	Z
    //   20: invokevirtual 215	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   23: invokevirtual 119	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   26: invokestatic 217	bnrh:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   29: aload_0
    //   30: getfield 209	bnki:jdField_a_of_type_Boolean	Z
    //   33: ifeq +19 -> 52
    //   36: new 21	java/util/ArrayList
    //   39: dup
    //   40: aload_0
    //   41: getfield 19	bnki:jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList	Ljava/util/concurrent/CopyOnWriteArrayList;
    //   44: invokespecial 220	java/util/ArrayList:<init>	(Ljava/util/Collection;)V
    //   47: astore_1
    //   48: aload_0
    //   49: monitorexit
    //   50: aload_1
    //   51: areturn
    //   52: aload_0
    //   53: invokespecial 222	bnki:b	()Ljava/util/List;
    //   56: astore_1
    //   57: aload_0
    //   58: aload_1
    //   59: invokespecial 224	bnki:a	(Ljava/util/List;)V
    //   62: aload_0
    //   63: getfield 19	bnki:jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList	Ljava/util/concurrent/CopyOnWriteArrayList;
    //   66: invokevirtual 227	java/util/concurrent/CopyOnWriteArrayList:clear	()V
    //   69: aload_0
    //   70: getfield 19	bnki:jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList	Ljava/util/concurrent/CopyOnWriteArrayList;
    //   73: aload_1
    //   74: invokevirtual 231	java/util/concurrent/CopyOnWriteArrayList:addAll	(Ljava/util/Collection;)Z
    //   77: pop
    //   78: aload_0
    //   79: iconst_1
    //   80: putfield 209	bnki:jdField_a_of_type_Boolean	Z
    //   83: new 21	java/util/ArrayList
    //   86: dup
    //   87: aload_0
    //   88: getfield 19	bnki:jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList	Ljava/util/concurrent/CopyOnWriteArrayList;
    //   91: invokespecial 220	java/util/ArrayList:<init>	(Ljava/util/Collection;)V
    //   94: astore_1
    //   95: goto -47 -> 48
    //   98: astore_1
    //   99: aload_0
    //   100: monitorexit
    //   101: aload_1
    //   102: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	103	0	this	bnki
    //   47	48	1	localObject1	Object
    //   98	4	1	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   2	48	98	finally
    //   52	95	98	finally
  }
  
  public void a()
  {
    try
    {
      bnrh.b("AEWatermarkMaterialManager", "onConfigUpdated---");
      this.jdField_a_of_type_Boolean = false;
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext()) {
        ((bnkl)localIterator.next()).a();
      }
    }
    finally {}
  }
  
  public void a(bnkl parambnkl)
  {
    if (parambnkl == null) {
      bnrh.d("AEWatermarkMaterialManager", "registerListener---the listener param is null");
    }
    while (this.jdField_a_of_type_JavaUtilArrayList.contains(parambnkl)) {
      return;
    }
    this.jdField_a_of_type_JavaUtilArrayList.add(parambnkl);
  }
  
  public void b(bnkl parambnkl)
  {
    this.jdField_a_of_type_JavaUtilArrayList.remove(parambnkl);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnki
 * JD-Core Version:    0.7.0.1
 */