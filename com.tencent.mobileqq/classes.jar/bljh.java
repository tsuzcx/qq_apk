import android.content.res.AssetManager;
import android.support.annotation.WorkerThread;
import android.text.TextUtils;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.BaseApplication;
import dov.com.qq.im.aeeditor.data.AEEditorDownloadResBean;
import dov.com.qq.im.aeeditor.module.filter.AEEditorFilterBean;
import dov.com.qq.im.aeeditor.module.filter.AEEditorFiltersManager.1;
import dov.com.qq.im.aeeditor.module.filter.AEEditorFiltersManager.4;
import dov.com.qq.im.aeeditor.module.filter.AEEditorFiltersManager.5;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class bljh
{
  private static volatile bljh jdField_a_of_type_Bljh;
  private static final String jdField_a_of_type_JavaLangString = blfx.b;
  private final bmab<List<AEEditorFilterBean>> jdField_a_of_type_Bmab = new bmab();
  private final Map<String, AEEditorDownloadResBean> jdField_a_of_type_JavaUtilMap = new LinkedHashMap();
  private volatile boolean jdField_a_of_type_Boolean;
  private final Map<String, AtomicBoolean> jdField_b_of_type_JavaUtilMap = new HashMap();
  private volatile boolean jdField_b_of_type_Boolean;
  private final Map<String, List<bljm>> c = new HashMap();
  
  private bljh()
  {
    b();
  }
  
  public static bljh a()
  {
    if (jdField_a_of_type_Bljh == null) {}
    try
    {
      if (jdField_a_of_type_Bljh == null) {
        jdField_a_of_type_Bljh = new bljh();
      }
      return jdField_a_of_type_Bljh;
    }
    finally {}
  }
  
  @NotNull
  private String a(AEEditorDownloadResBean paramAEEditorDownloadResBean)
  {
    return jdField_a_of_type_JavaLangString + File.separator + paramAEEditorDownloadResBean.getId() + File.separator + paramAEEditorDownloadResBean.getMd5();
  }
  
  private void a(@NotNull AEEditorDownloadResBean paramAEEditorDownloadResBean, bljm parambljm)
  {
    blfg.b("AEEditorFiltersManager", "downLoadOneResInternal---BEGIN: id=" + paramAEEditorDownloadResBean.getId());
    String str = paramAEEditorDownloadResBean.getMd5();
    AtomicBoolean localAtomicBoolean;
    synchronized (this.jdField_b_of_type_JavaUtilMap)
    {
      if ((AtomicBoolean)this.jdField_b_of_type_JavaUtilMap.get(str) == null) {
        this.jdField_b_of_type_JavaUtilMap.put(str, new AtomicBoolean(false));
      }
      localAtomicBoolean = (AtomicBoolean)this.jdField_b_of_type_JavaUtilMap.get(str);
    }
    try
    {
      if (localAtomicBoolean.get())
      {
        localObject2 = (List)this.c.get(str);
        ??? = localObject2;
        if (localObject2 == null)
        {
          ??? = new ArrayList();
          this.c.put(str, ???);
        }
        if (parambljm != null) {
          ((List)???).add(parambljm);
        }
        blfg.b("AEEditorFiltersManager", "downLoadOneResInternal---is DOWNLOADING: id=" + paramAEEditorDownloadResBean.getId());
        return;
        paramAEEditorDownloadResBean = finally;
        throw paramAEEditorDownloadResBean;
      }
      localAtomicBoolean.compareAndSet(false, true);
      if (a(paramAEEditorDownloadResBean))
      {
        if (parambljm != null) {
          parambljm.a(true);
        }
        a(str, true);
        blfg.b("AEEditorFiltersManager", "downLoadOneResInternal---is DOWNLOADED by other: id=" + paramAEEditorDownloadResBean.getId());
        return;
      }
    }
    finally {}
    ??? = jdField_a_of_type_JavaLangString + File.separator + paramAEEditorDownloadResBean.getId() + File.separator;
    bdcs.a((String)???);
    Object localObject2 = (String)??? + str + ".zip";
    blfb.a().a(paramAEEditorDownloadResBean.getUrl(), (String)localObject2, new bljl(this, parambljm, str, paramAEEditorDownloadResBean, (String)localObject2, (String)???));
  }
  
  private void a(String paramString, boolean paramBoolean)
  {
    AtomicBoolean localAtomicBoolean = (AtomicBoolean)this.jdField_b_of_type_JavaUtilMap.get(paramString);
    if (localAtomicBoolean == null) {
      return;
    }
    try
    {
      localAtomicBoolean.compareAndSet(true, false);
      paramString = (List)this.c.get(paramString);
      if (paramString != null)
      {
        Iterator localIterator = paramString.iterator();
        while (localIterator.hasNext())
        {
          bljm localbljm = (bljm)localIterator.next();
          if (localbljm != null) {
            localbljm.a(paramBoolean);
          }
        }
        paramString.clear();
      }
    }
    finally {}
  }
  
  private boolean a(@NotNull AEEditorDownloadResBean paramAEEditorDownloadResBean)
  {
    return new File(a(paramAEEditorDownloadResBean)).exists();
  }
  
  private boolean a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    for (;;)
    {
      int i;
      try
      {
        ndr.a(new File(paramString1), paramString2);
        paramString1 = new File(paramString2);
        if ((paramString1.exists()) && (paramString1.isDirectory()))
        {
          paramString1 = paramString1.listFiles();
          if ((paramString1 == null) || (paramString1.length <= 0)) {
            break label225;
          }
          int j = paramString1.length;
          i = 0;
          if (i < j)
          {
            Object localObject = paramString1[i];
            if (!localObject.getName().equals(paramString3)) {
              break label227;
            }
            blfg.b("AEEditorFiltersManager", "begin rename zip folder---from: " + localObject.getName() + ", to: " + paramString4);
            return bdcs.c(paramString2 + paramString3, paramString2 + paramString4);
          }
          blfg.d("AEEditorFiltersManager", "unZipAndRenameSpecificFolder--NOT found folder named " + paramString3);
          return false;
        }
      }
      catch (Exception paramString1)
      {
        blfg.a("AEEditorFiltersManager", "unZipAndRenameSpecificFolder--exception ", paramString1);
        paramString1.printStackTrace();
        return false;
      }
      blfg.d("AEEditorFiltersManager", "unZipAndRenameSpecificFolder--toDir not exists or not a directory: " + paramString1);
      label225:
      return false;
      label227:
      i += 1;
    }
  }
  
  @WorkerThread
  private String b(String paramString)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    String str1 = "";
    for (;;)
    {
      try
      {
        localInputStream = BaseApplicationImpl.getContext().getAssets().open(paramString);
        localObject1 = localInputStream;
        localObject2 = localInputStream;
        String str2 = ndq.a(localInputStream);
        paramString = str2;
        localObject2 = paramString;
      }
      catch (Throwable localThrowable)
      {
        InputStream localInputStream;
        localObject2 = localIOException1;
        blfg.a("AEEditorFiltersManager", "readAssetsFileContent---read assets json exception: fileName=" + paramString, localThrowable);
        localObject2 = localIOException1;
        localThrowable.printStackTrace();
        localObject2 = str1;
        if (localIOException1 == null) {
          continue;
        }
        try
        {
          localIOException1.close();
          return "";
        }
        catch (IOException paramString)
        {
          paramString.printStackTrace();
          return "";
        }
      }
      finally
      {
        if (localObject2 == null) {
          break label128;
        }
      }
      try
      {
        localInputStream.close();
        localObject2 = paramString;
        return localObject2;
      }
      catch (IOException localIOException1)
      {
        localIOException1.printStackTrace();
        return paramString;
      }
    }
    try
    {
      ((InputStream)localObject2).close();
      label128:
      throw paramString;
    }
    catch (IOException localIOException2)
    {
      for (;;)
      {
        localIOException2.printStackTrace();
      }
    }
  }
  
  private void b()
  {
    blfg.b("AEEditorFiltersManager", "loadAssets");
    ThreadManager.excute(new AEEditorFiltersManager.1(this), 64, null, true);
  }
  
  @WorkerThread
  private void c()
  {
    blfg.b("AEEditorFiltersManager", "setupDisplayFilterList--BEGIN");
    Object localObject1 = b("camera/ae_camera_editor_display_filters.json");
    if (TextUtils.isEmpty((CharSequence)localObject1))
    {
      blfg.d("AEEditorFiltersManager", "setupDisplayFilterList---read assets json content empty");
      return;
    }
    Object localObject3 = new Gson();
    try
    {
      localObject1 = (List)((Gson)localObject3).fromJson((String)localObject1, new blji(this).getType());
      StringBuilder localStringBuilder = new StringBuilder().append("setupDisplayFilterList---filters size = ");
      if (localObject1 == null)
      {
        localObject3 = "null";
        blfg.b("AEEditorFiltersManager", localObject3);
        this.jdField_a_of_type_Bmab.a(localObject1);
        return;
      }
    }
    catch (JsonSyntaxException localJsonSyntaxException)
    {
      for (;;)
      {
        blfg.a("AEEditorFiltersManager", "setupDisplayFilterList---parse json exception: ", localJsonSyntaxException);
        localJsonSyntaxException.printStackTrace();
        Object localObject2 = null;
        continue;
        localObject3 = Integer.valueOf(localObject2.size());
      }
    }
  }
  
  @WorkerThread
  private void d()
  {
    Object localObject3;
    synchronized (this.jdField_a_of_type_JavaUtilMap)
    {
      if (this.jdField_a_of_type_Boolean) {
        return;
      }
      this.jdField_a_of_type_Boolean = true;
      blfg.b("AEEditorFiltersManager", "ensureSetupDownloadConfig--BEGIN");
      localObject3 = b("camera/ae_camera_editor_download_resources.json");
      if (TextUtils.isEmpty((CharSequence)localObject3))
      {
        blfg.d("AEEditorFiltersManager", "ensureSetupDownloadConfig---read assets json content empty");
        return;
      }
    }
    Object localObject4 = new Gson();
    Object localObject2 = null;
    try
    {
      localObject3 = (List)((Gson)localObject4).fromJson((String)localObject3, new bljj(this).getType());
      localObject2 = localObject3;
    }
    catch (JsonSyntaxException localJsonSyntaxException)
    {
      for (;;)
      {
        blfg.a("AEEditorFiltersManager", "ensureSetupDownloadConfig---parse json exception: ", localJsonSyntaxException);
        localJsonSyntaxException.printStackTrace();
        continue;
        Integer localInteger = Integer.valueOf(((List)localObject2).size());
      }
    }
    localObject4 = new StringBuilder().append("ensureSetupDownloadConfig---size = ");
    if (localObject2 == null)
    {
      localObject3 = "null";
      blfg.b("AEEditorFiltersManager", localObject3);
      if (localObject2 == null) {
        break label210;
      }
      localObject2 = ((List)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (AEEditorDownloadResBean)((Iterator)localObject2).next();
        this.jdField_a_of_type_JavaUtilMap.put(((AEEditorDownloadResBean)localObject3).getId(), localObject3);
      }
    }
    label210:
  }
  
  public bmab<List<AEEditorFilterBean>> a()
  {
    return this.jdField_a_of_type_Bmab;
  }
  
  public String a()
  {
    d();
    return a((AEEditorDownloadResBean)this.jdField_a_of_type_JavaUtilMap.get("AIPhotoConfig"));
  }
  
  @Nullable
  public String a(AEEditorFilterBean paramAEEditorFilterBean)
  {
    if (paramAEEditorFilterBean == null) {
      return null;
    }
    d();
    AEEditorDownloadResBean localAEEditorDownloadResBean = (AEEditorDownloadResBean)this.jdField_a_of_type_JavaUtilMap.get(paramAEEditorFilterBean.getSid());
    if (localAEEditorDownloadResBean == null) {
      return null;
    }
    return a(localAEEditorDownloadResBean) + File.separator + paramAEEditorFilterBean.getLutName();
  }
  
  @Nullable
  public String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    d();
    AEEditorDownloadResBean localAEEditorDownloadResBean = (AEEditorDownloadResBean)this.jdField_a_of_type_JavaUtilMap.get(paramString);
    if (localAEEditorDownloadResBean == null) {
      return null;
    }
    return a(localAEEditorDownloadResBean) + File.separator + paramString + ".png";
  }
  
  public void a()
  {
    if (this.jdField_b_of_type_Boolean) {
      return;
    }
    this.jdField_b_of_type_Boolean = true;
    ThreadManager.excute(new AEEditorFiltersManager.4(this), 128, null, false);
  }
  
  public void a(String paramString, bljm parambljm)
  {
    if (TextUtils.isEmpty(paramString))
    {
      if (parambljm != null) {
        parambljm.a(false);
      }
      return;
    }
    ThreadManager.excute(new AEEditorFiltersManager.5(this, paramString, parambljm), 128, null, false);
  }
  
  public boolean a()
  {
    return new File(a()).exists();
  }
  
  public String b()
  {
    d();
    return a((AEEditorDownloadResBean)this.jdField_a_of_type_JavaUtilMap.get("AIVideoConfig"));
  }
  
  public boolean b()
  {
    return new File(b()).exists();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bljh
 * JD-Core Version:    0.7.0.1
 */