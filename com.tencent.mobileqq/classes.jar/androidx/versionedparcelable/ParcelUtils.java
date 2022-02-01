package androidx.versionedparcelable;

import android.os.Bundle;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ParcelUtils
{
  private static final String INNER_BUNDLE_KEY = "a";
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  public static <T extends VersionedParcelable> T fromInputStream(InputStream paramInputStream)
  {
    return new VersionedParcelStream(paramInputStream, null).readVersionedParcelable();
  }
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  public static <T extends VersionedParcelable> T fromParcelable(Parcelable paramParcelable)
  {
    if (!(paramParcelable instanceof ParcelImpl)) {
      throw new IllegalArgumentException("Invalid parcel");
    }
    return ((ParcelImpl)paramParcelable).getVersionedParcel();
  }
  
  @Nullable
  public static <T extends VersionedParcelable> T getVersionedParcelable(@NonNull Bundle paramBundle, @NonNull String paramString)
  {
    try
    {
      paramBundle = (Bundle)paramBundle.getParcelable(paramString);
      if (paramBundle == null) {
        return null;
      }
      paramBundle.setClassLoader(ParcelUtils.class.getClassLoader());
      paramBundle = fromParcelable(paramBundle.getParcelable("a"));
      return paramBundle;
    }
    catch (RuntimeException paramBundle) {}
    return null;
  }
  
  @Nullable
  public static <T extends VersionedParcelable> List<T> getVersionedParcelableList(Bundle paramBundle, String paramString)
  {
    localArrayList = new ArrayList();
    try
    {
      paramBundle = (Bundle)paramBundle.getParcelable(paramString);
      paramBundle.setClassLoader(ParcelUtils.class.getClassLoader());
      paramBundle = paramBundle.getParcelableArrayList("a").iterator();
      while (paramBundle.hasNext()) {
        localArrayList.add(fromParcelable((Parcelable)paramBundle.next()));
      }
      return localArrayList;
    }
    catch (RuntimeException paramBundle)
    {
      return null;
    }
  }
  
  public static void putVersionedParcelable(@NonNull Bundle paramBundle, @NonNull String paramString, @Nullable VersionedParcelable paramVersionedParcelable)
  {
    if (paramVersionedParcelable == null) {
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("a", toParcelable(paramVersionedParcelable));
    paramBundle.putParcelable(paramString, localBundle);
  }
  
  public static void putVersionedParcelableList(@NonNull Bundle paramBundle, @NonNull String paramString, @NonNull List<? extends VersionedParcelable> paramList)
  {
    Bundle localBundle = new Bundle();
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      localArrayList.add(toParcelable((VersionedParcelable)paramList.next()));
    }
    localBundle.putParcelableArrayList("a", localArrayList);
    paramBundle.putParcelable(paramString, localBundle);
  }
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  public static void toOutputStream(VersionedParcelable paramVersionedParcelable, OutputStream paramOutputStream)
  {
    paramOutputStream = new VersionedParcelStream(null, paramOutputStream);
    paramOutputStream.writeVersionedParcelable(paramVersionedParcelable);
    paramOutputStream.closeField();
  }
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  public static Parcelable toParcelable(VersionedParcelable paramVersionedParcelable)
  {
    return new ParcelImpl(paramVersionedParcelable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     androidx.versionedparcelable.ParcelUtils
 * JD-Core Version:    0.7.0.1
 */