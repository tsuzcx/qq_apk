package com.tencent.luggage.wxa.na;

import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.qz.w;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/live/AppBrandResCacheChecker;", "", "()V", "INVALID_LAST_MODIFIED", "", "MMKV_KEY_PREFIX_META_DATA_DIR", "", "MMKV_KEY_PREFIX_META_DATA_FILE", "MMKV_NAME_RES_CACHE_META", "getDirMeta", "file", "Lcom/tencent/mm/vfs/VFSFile;", "getFileLastModified", "isValid", "", "cacheFile", "record", "recordDir", "cacheDir", "recordFile", "saveDirMeta", "", "dir", "dirMeta", "saveFileLastModified", "validateDir", "validateFile", "validateMeta", "metaData", "Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/live/FileMetaData;", "parentDir", "luggage-xweb-ext_release"}, k=1, mv={1, 1, 16})
public final class d
{
  public static final d a = new d();
  
  private final void a(com.tencent.luggage.wxa.rt.i parami, String paramString)
  {
    w localw = w.a("AppBrandResCacheMeta");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("metaData_dir_");
    localStringBuilder.append(parami.l());
    parami = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("saveDirMeta, key: ");
    localStringBuilder.append(parami);
    o.e("MicroMsg.AppBrand.AppBrandResCacheChecker", localStringBuilder.toString());
    localw.putString(parami, paramString);
  }
  
  private final boolean a(i parami, com.tencent.luggage.wxa.rt.i parami1)
  {
    parami1 = new com.tencent.luggage.wxa.rt.i(parami1, parami.c());
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("validateMeta, unzipFile: ");
    ((StringBuilder)localObject).append(parami1);
    o.e("MicroMsg.AppBrand.AppBrandResCacheChecker", ((StringBuilder)localObject).toString());
    boolean bool1 = parami instanceof h;
    boolean bool2 = true;
    if (bool1)
    {
      parami = (Iterable)((h)parami).b();
      if (((parami instanceof Collection)) && (((Collection)parami).isEmpty())) {
        return true;
      }
      parami = parami.iterator();
      do
      {
        bool1 = bool2;
        if (!parami.hasNext()) {
          break;
        }
        localObject = (i)parami.next();
      } while (a.a((i)localObject, parami1));
      bool1 = false;
      return bool1;
    }
    if ((parami1.j()) && (parami1.o())) {
      return parami.d() == parami1.p();
    }
    return false;
  }
  
  private final boolean c(com.tencent.luggage.wxa.rt.i parami)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("recordDir, cacheDir: ");
    ((StringBuilder)localObject).append(parami);
    o.e("MicroMsg.AppBrand.AppBrandResCacheChecker", ((StringBuilder)localObject).toString());
    localObject = h.a.a(parami);
    if (localObject == null)
    {
      o.c("MicroMsg.AppBrand.AppBrandResCacheChecker", "recordDir, metaData is null");
      return false;
    }
    localObject = ((h)localObject).a();
    if (localObject != null) {
      localObject = ((JSONObject)localObject).toString();
    } else {
      localObject = null;
    }
    CharSequence localCharSequence = (CharSequence)localObject;
    int i;
    if ((localCharSequence != null) && (localCharSequence.length() != 0)) {
      i = 0;
    } else {
      i = 1;
    }
    if (i != 0)
    {
      o.c("MicroMsg.AppBrand.AppBrandResCacheChecker", "recordDir, metaDataStr is empty");
      return false;
    }
    a(parami, (String)localObject);
    return true;
  }
  
  private final boolean d(com.tencent.luggage.wxa.rt.i parami)
  {
    h(parami);
    return true;
  }
  
  private final boolean e(com.tencent.luggage.wxa.rt.i parami)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("validateDir, cacheDir: ");
    ((StringBuilder)localObject1).append(parami);
    o.e("MicroMsg.AppBrand.AppBrandResCacheChecker", ((StringBuilder)localObject1).toString());
    localObject1 = g(parami);
    Object localObject2 = (CharSequence)localObject1;
    int i;
    if ((localObject2 != null) && (((CharSequence)localObject2).length() != 0)) {
      i = 0;
    } else {
      i = 1;
    }
    if (i != 0)
    {
      o.c("MicroMsg.AppBrand.AppBrandResCacheChecker", "validateDir, metaDataStr is empty");
      return false;
    }
    i locali;
    try
    {
      localObject1 = i.b.a(new JSONObject((String)localObject1));
    }
    catch (Exception localException)
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("validateDir, get metaData fail since ");
      ((StringBuilder)localObject2).append(localException);
      o.e("MicroMsg.AppBrand.AppBrandResCacheChecker", ((StringBuilder)localObject2).toString());
      locali = null;
    }
    if (locali == null)
    {
      o.c("MicroMsg.AppBrand.AppBrandResCacheChecker", "validateDir, metaData is null");
      return false;
    }
    parami = parami.g();
    Intrinsics.checkExpressionValueIsNotNull(parami, "parentDir");
    if (!a(locali, parami))
    {
      o.c("MicroMsg.AppBrand.AppBrandResCacheChecker", "validateDir, validateMeta fail");
      return false;
    }
    return true;
  }
  
  private final boolean f(com.tencent.luggage.wxa.rt.i parami)
  {
    long l1 = i(parami);
    long l2 = parami.p();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("validateFile, cacheFile: ");
    localStringBuilder.append(parami);
    localStringBuilder.append(", savedLastModified: ");
    localStringBuilder.append(l1);
    localStringBuilder.append(", realLastModified: ");
    localStringBuilder.append(l2);
    o.e("MicroMsg.AppBrand.AppBrandResCacheChecker", localStringBuilder.toString());
    return l1 == l2;
  }
  
  private final String g(com.tencent.luggage.wxa.rt.i parami)
  {
    w localw = w.a("AppBrandResCacheMeta");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("metaData_dir_");
    localStringBuilder.append(parami.l());
    parami = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("getDirMeta, key: ");
    localStringBuilder.append(parami);
    o.e("MicroMsg.AppBrand.AppBrandResCacheChecker", localStringBuilder.toString());
    return localw.getString(parami, null);
  }
  
  private final void h(com.tencent.luggage.wxa.rt.i parami)
  {
    w localw = w.a("AppBrandResCacheMeta");
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("metaData_file_");
    ((StringBuilder)localObject).append(parami.l());
    localObject = ((StringBuilder)localObject).toString();
    long l = parami.p();
    parami = new StringBuilder();
    parami.append("saveFileLastModified, key: ");
    parami.append((String)localObject);
    parami.append(", lastModified: ");
    parami.append(l);
    o.e("MicroMsg.AppBrand.AppBrandResCacheChecker", parami.toString());
    localw.putLong((String)localObject, l);
  }
  
  private final long i(com.tencent.luggage.wxa.rt.i parami)
  {
    w localw = w.a("AppBrandResCacheMeta");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("metaData_file_");
    localStringBuilder.append(parami.l());
    parami = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("getFileLastModified, key: ");
    localStringBuilder.append(parami);
    o.e("MicroMsg.AppBrand.AppBrandResCacheChecker", localStringBuilder.toString());
    return localw.getLong(parami, -1L);
  }
  
  public final boolean a(@NotNull com.tencent.luggage.wxa.rt.i parami)
  {
    Intrinsics.checkParameterIsNotNull(parami, "cacheFile");
    if (parami.n()) {
      return c(parami);
    }
    return d(parami);
  }
  
  public final boolean b(@NotNull com.tencent.luggage.wxa.rt.i parami)
  {
    Intrinsics.checkParameterIsNotNull(parami, "cacheFile");
    if (parami.n()) {
      return e(parami);
    }
    return f(parami);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.na.d
 * JD-Core Version:    0.7.0.1
 */