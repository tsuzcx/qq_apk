package androidx.core.provider;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ProviderInfo;
import android.content.pm.Signature;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Typeface;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Build.VERSION;
import android.os.CancellationSignal;
import android.os.Handler;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.collection.LruCache;
import androidx.collection.SimpleArrayMap;
import androidx.core.content.res.FontResourcesParserCompat;
import androidx.core.content.res.ResourcesCompat.FontCallback;
import androidx.core.graphics.TypefaceCompat;
import androidx.core.graphics.TypefaceCompatUtil;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FontsContractCompat
{
  private static final int BACKGROUND_THREAD_KEEP_ALIVE_DURATION_MS = 10000;
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  public static final String PARCEL_FONT_RESULTS = "font_results";
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  static final int RESULT_CODE_PROVIDER_NOT_FOUND = -1;
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  static final int RESULT_CODE_WRONG_CERTIFICATES = -2;
  private static final SelfDestructiveThread sBackgroundThread;
  private static final Comparator<byte[]> sByteArrayComparator = new FontsContractCompat.5();
  static final Object sLock;
  @GuardedBy("sLock")
  static final SimpleArrayMap<String, ArrayList<SelfDestructiveThread.ReplyCallback<FontsContractCompat.TypefaceResult>>> sPendingReplies;
  static final LruCache<String, Typeface> sTypefaceCache = new LruCache(16);
  
  static
  {
    sBackgroundThread = new SelfDestructiveThread("fonts", 10, 10000);
    sLock = new Object();
    sPendingReplies = new SimpleArrayMap();
  }
  
  @Nullable
  public static Typeface buildTypeface(@NonNull Context paramContext, @Nullable CancellationSignal paramCancellationSignal, @NonNull FontsContractCompat.FontInfo[] paramArrayOfFontInfo)
  {
    return TypefaceCompat.createFromFontInfo(paramContext, paramCancellationSignal, paramArrayOfFontInfo, 0);
  }
  
  private static List<byte[]> convertToByteArrayList(Signature[] paramArrayOfSignature)
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < paramArrayOfSignature.length)
    {
      localArrayList.add(paramArrayOfSignature[i].toByteArray());
      i += 1;
    }
    return localArrayList;
  }
  
  private static boolean equalsByteArrayList(List<byte[]> paramList1, List<byte[]> paramList2)
  {
    if (paramList1.size() != paramList2.size()) {
      return false;
    }
    int i = 0;
    while (i < paramList1.size())
    {
      if (!Arrays.equals((byte[])paramList1.get(i), (byte[])paramList2.get(i))) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  @NonNull
  public static FontsContractCompat.FontFamilyResult fetchFonts(@NonNull Context paramContext, @Nullable CancellationSignal paramCancellationSignal, @NonNull FontRequest paramFontRequest)
  {
    ProviderInfo localProviderInfo = getProvider(paramContext.getPackageManager(), paramFontRequest, paramContext.getResources());
    if (localProviderInfo == null) {
      return new FontsContractCompat.FontFamilyResult(1, null);
    }
    return new FontsContractCompat.FontFamilyResult(0, getFontFromProvider(paramContext, paramFontRequest, localProviderInfo.authority, paramCancellationSignal));
  }
  
  private static List<List<byte[]>> getCertificates(FontRequest paramFontRequest, Resources paramResources)
  {
    if (paramFontRequest.getCertificates() != null) {
      return paramFontRequest.getCertificates();
    }
    return FontResourcesParserCompat.readCerts(paramResources, paramFontRequest.getCertificatesArrayResId());
  }
  
  @NonNull
  @VisibleForTesting
  static FontsContractCompat.FontInfo[] getFontFromProvider(Context paramContext, FontRequest paramFontRequest, String paramString, CancellationSignal paramCancellationSignal)
  {
    ArrayList localArrayList = new ArrayList();
    Uri localUri1 = new Uri.Builder().scheme("content").authority(paramString).build();
    Uri localUri2 = new Uri.Builder().scheme("content").authority(paramString).appendPath("file").build();
    for (;;)
    {
      try
      {
        i = Build.VERSION.SDK_INT;
        if (i > 16)
        {
          paramContext = paramContext.getContentResolver();
          paramFontRequest = paramFontRequest.getQuery();
          paramContext = paramContext.query(localUri1, new String[] { "_id", "file_id", "font_ttc_index", "font_variation_settings", "font_weight", "font_italic", "result_code" }, "query = ?", new String[] { paramFontRequest }, null, paramCancellationSignal);
        }
        else
        {
          paramContext = paramContext.getContentResolver();
          paramFontRequest = paramFontRequest.getQuery();
          paramContext = paramContext.query(localUri1, new String[] { "_id", "file_id", "font_ttc_index", "font_variation_settings", "font_weight", "font_italic", "result_code" }, "query = ?", new String[] { paramFontRequest }, null);
        }
        if (paramContext == null) {
          continue;
        }
      }
      finally
      {
        paramContext = null;
        if (paramContext == null) {
          continue;
        }
        paramContext.close();
        continue;
        throw paramFontRequest;
        continue;
        int i = 0;
        continue;
        int j = 0;
        continue;
        int k = 400;
        continue;
        boolean bool = false;
        continue;
      }
      try
      {
        if (paramContext.getCount() > 0)
        {
          int m = paramContext.getColumnIndex("result_code");
          paramString = new ArrayList();
          int n = paramContext.getColumnIndex("_id");
          int i1 = paramContext.getColumnIndex("file_id");
          int i2 = paramContext.getColumnIndex("font_ttc_index");
          int i3 = paramContext.getColumnIndex("font_weight");
          int i4 = paramContext.getColumnIndex("font_italic");
          paramFontRequest = paramString;
          if (paramContext.moveToNext())
          {
            if (m == -1) {
              continue;
            }
            i = paramContext.getInt(m);
            if (i2 == -1) {
              continue;
            }
            j = paramContext.getInt(i2);
            if (i1 == -1) {
              paramFontRequest = ContentUris.withAppendedId(localUri1, paramContext.getLong(n));
            } else {
              paramFontRequest = ContentUris.withAppendedId(localUri2, paramContext.getLong(i1));
            }
            if (i3 == -1) {
              continue;
            }
            k = paramContext.getInt(i3);
            if ((i4 == -1) || (paramContext.getInt(i4) != 1)) {
              continue;
            }
            bool = true;
            paramString.add(new FontsContractCompat.FontInfo(paramFontRequest, j, k, bool, i));
            continue;
          }
        }
        else
        {
          paramFontRequest = localArrayList;
        }
      }
      finally {}
    }
    if (paramContext != null) {
      paramContext.close();
    }
    return (FontsContractCompat.FontInfo[])paramFontRequest.toArray(new FontsContractCompat.FontInfo[0]);
  }
  
  @NonNull
  static FontsContractCompat.TypefaceResult getFontInternal(Context paramContext, FontRequest paramFontRequest, int paramInt)
  {
    try
    {
      paramFontRequest = fetchFonts(paramContext, null, paramFontRequest);
      int j = paramFontRequest.getStatusCode();
      int i = -3;
      if (j == 0)
      {
        paramContext = TypefaceCompat.createFromFontInfo(paramContext, null, paramFontRequest.getFonts(), paramInt);
        if (paramContext != null) {
          i = 0;
        }
        return new FontsContractCompat.TypefaceResult(paramContext, i);
      }
      if (paramFontRequest.getStatusCode() == 1) {
        i = -2;
      }
      return new FontsContractCompat.TypefaceResult(null, i);
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      label69:
      break label69;
    }
    return new FontsContractCompat.TypefaceResult(null, -1);
  }
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  public static Typeface getFontSync(Context paramContext, FontRequest paramFontRequest, @Nullable ResourcesCompat.FontCallback arg2, @Nullable Handler paramHandler, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramFontRequest.getIdentifier());
    ((StringBuilder)localObject).append("-");
    ((StringBuilder)localObject).append(paramInt2);
    localObject = ((StringBuilder)localObject).toString();
    Typeface localTypeface = (Typeface)sTypefaceCache.get(localObject);
    if (localTypeface != null)
    {
      if (??? != null) {
        ???.onFontRetrieved(localTypeface);
      }
      return localTypeface;
    }
    if ((paramBoolean) && (paramInt1 == -1))
    {
      paramContext = getFontInternal(paramContext, paramFontRequest, paramInt2);
      if (??? != null) {
        if (paramContext.mResult == 0) {
          ???.callbackSuccessAsync(paramContext.mTypeface, paramHandler);
        } else {
          ???.callbackFailAsync(paramContext.mResult, paramHandler);
        }
      }
      return paramContext.mTypeface;
    }
    paramFontRequest = new FontsContractCompat.1(paramContext, paramFontRequest, paramInt2, (String)localObject);
    if (paramBoolean) {}
    try
    {
      paramContext = ((FontsContractCompat.TypefaceResult)sBackgroundThread.postAndWait(paramFontRequest, paramInt1)).mTypeface;
      return paramContext;
    }
    catch (InterruptedException paramContext) {}
    if (??? == null) {
      paramContext = null;
    } else {
      paramContext = new FontsContractCompat.2(???, paramHandler);
    }
    synchronized (sLock)
    {
      paramHandler = (ArrayList)sPendingReplies.get(localObject);
      if (paramHandler != null)
      {
        if (paramContext != null) {
          paramHandler.add(paramContext);
        }
        return null;
      }
      if (paramContext != null)
      {
        paramHandler = new ArrayList();
        paramHandler.add(paramContext);
        sPendingReplies.put(localObject, paramHandler);
      }
      sBackgroundThread.postAndReply(paramFontRequest, new FontsContractCompat.3((String)localObject));
      return null;
    }
    return null;
  }
  
  @Nullable
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  @VisibleForTesting
  public static ProviderInfo getProvider(@NonNull PackageManager paramPackageManager, @NonNull FontRequest paramFontRequest, @Nullable Resources paramResources)
  {
    String str = paramFontRequest.getProviderAuthority();
    int i = 0;
    ProviderInfo localProviderInfo = paramPackageManager.resolveContentProvider(str, 0);
    if (localProviderInfo != null)
    {
      if (localProviderInfo.packageName.equals(paramFontRequest.getProviderPackage()))
      {
        paramPackageManager = convertToByteArrayList(paramPackageManager.getPackageInfo(localProviderInfo.packageName, 64).signatures);
        Collections.sort(paramPackageManager, sByteArrayComparator);
        paramFontRequest = getCertificates(paramFontRequest, paramResources);
        while (i < paramFontRequest.size())
        {
          paramResources = new ArrayList((Collection)paramFontRequest.get(i));
          Collections.sort(paramResources, sByteArrayComparator);
          if (equalsByteArrayList(paramPackageManager, paramResources)) {
            return localProviderInfo;
          }
          i += 1;
        }
        return null;
      }
      paramPackageManager = new StringBuilder();
      paramPackageManager.append("Found content provider ");
      paramPackageManager.append(str);
      paramPackageManager.append(", but package was not ");
      paramPackageManager.append(paramFontRequest.getProviderPackage());
      throw new PackageManager.NameNotFoundException(paramPackageManager.toString());
    }
    paramPackageManager = new StringBuilder();
    paramPackageManager.append("No package found for authority: ");
    paramPackageManager.append(str);
    paramPackageManager = new PackageManager.NameNotFoundException(paramPackageManager.toString());
    for (;;)
    {
      throw paramPackageManager;
    }
  }
  
  @RequiresApi(19)
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  public static Map<Uri, ByteBuffer> prepareFontData(Context paramContext, FontsContractCompat.FontInfo[] paramArrayOfFontInfo, CancellationSignal paramCancellationSignal)
  {
    HashMap localHashMap = new HashMap();
    int j = paramArrayOfFontInfo.length;
    int i = 0;
    while (i < j)
    {
      Object localObject = paramArrayOfFontInfo[i];
      if (((FontsContractCompat.FontInfo)localObject).getResultCode() == 0)
      {
        localObject = ((FontsContractCompat.FontInfo)localObject).getUri();
        if (!localHashMap.containsKey(localObject)) {
          localHashMap.put(localObject, TypefaceCompatUtil.mmap(paramContext, paramCancellationSignal, (Uri)localObject));
        }
      }
      i += 1;
    }
    return Collections.unmodifiableMap(localHashMap);
  }
  
  public static void requestFont(@NonNull Context paramContext, @NonNull FontRequest paramFontRequest, @NonNull FontsContractCompat.FontRequestCallback paramFontRequestCallback, @NonNull Handler paramHandler)
  {
    requestFontInternal(paramContext.getApplicationContext(), paramFontRequest, paramFontRequestCallback, paramHandler);
  }
  
  private static void requestFontInternal(@NonNull Context paramContext, @NonNull FontRequest paramFontRequest, @NonNull FontsContractCompat.FontRequestCallback paramFontRequestCallback, @NonNull Handler paramHandler)
  {
    paramHandler.post(new FontsContractCompat.4(paramContext, paramFontRequest, new Handler(), paramFontRequestCallback));
  }
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  public static void resetCache()
  {
    sTypefaceCache.evictAll();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.core.provider.FontsContractCompat
 * JD-Core Version:    0.7.0.1
 */