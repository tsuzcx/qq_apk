import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.common.config.AppSetting;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class bozz
{
  private static final List<Pair<String, Integer>> a = new LinkedList();
  
  static
  {
    a.add(new Pair("AEKIT_CAMERA_FIRST_LAUNCH", Integer.valueOf(0)));
    a.add(new Pair("CameraModuleSvc.GetCompressedCategoryMaterialMqStoryCamera", Integer.valueOf(4)));
    a.add(new Pair("CameraModuleSvc.GetCompressedCategoryMaterialMqEmoCamera", Integer.valueOf(4)));
    a.add(new Pair("CameraModuleSvc.GetPlayShowCatMatTree", Integer.valueOf(4)));
  }
  
  private bozz()
  {
    Object localObject = bpac.a("key_app_version", "");
    if ((TextUtils.isEmpty((CharSequence)localObject)) || (!AppSetting.a().equals(localObject)))
    {
      localObject = a.iterator();
      while (((Iterator)localObject).hasNext())
      {
        Pair localPair = (Pair)((Iterator)localObject).next();
        if (4 == ((Integer)localPair.second).intValue()) {
          bpac.a((String)localPair.first);
        } else {
          bpab.a((String)localPair.first);
        }
      }
      bpac.a("key_app_version", AppSetting.a());
    }
  }
  
  public static bozz a()
  {
    return bpad.a();
  }
  
  public int a(@NonNull String paramString, int paramInt1, int paramInt2)
  {
    if (4 == paramInt2) {
      return bpac.a(paramString, paramInt1);
    }
    return bpab.a(paramString, paramInt1);
  }
  
  public long a(@NonNull String paramString, long paramLong, int paramInt)
  {
    if (4 == paramInt) {
      return bpac.a(paramString, paramLong);
    }
    return bpab.a(paramString, paramLong);
  }
  
  @NonNull
  public SharedPreferences a()
  {
    return bpab.a();
  }
  
  @Nullable
  public String a(@NonNull String paramString1, String paramString2, int paramInt)
  {
    if (4 == paramInt) {
      return bpac.a(paramString1, paramString2);
    }
    return bpab.a(paramString1, paramString2);
  }
  
  public void a(@NonNull String paramString, int paramInt)
  {
    if (4 == paramInt)
    {
      bpac.a(paramString);
      return;
    }
    bpab.a(paramString);
  }
  
  public void a(@NonNull String paramString, int paramInt1, int paramInt2)
  {
    if (4 == paramInt2)
    {
      bpac.a(paramString, paramInt1);
      return;
    }
    bpab.a(paramString, paramInt1);
  }
  
  public void a(@NonNull String paramString, long paramLong, int paramInt)
  {
    if (4 == paramInt)
    {
      bpac.a(paramString, paramLong);
      return;
    }
    bpab.a(paramString, paramLong);
  }
  
  public void a(@NonNull String paramString1, String paramString2, int paramInt)
  {
    if (4 == paramInt)
    {
      bpac.a(paramString1, paramString2);
      return;
    }
    bpab.a(paramString1, paramString2);
  }
  
  public void a(@NonNull String paramString, boolean paramBoolean, int paramInt)
  {
    if (4 == paramInt)
    {
      bpac.a(paramString, paramBoolean);
      return;
    }
    bpab.a(paramString, paramBoolean);
  }
  
  public boolean a(@NonNull String paramString, int paramInt)
  {
    if (4 == paramInt) {
      return bpac.a(paramString);
    }
    return bpab.a(paramString);
  }
  
  public boolean a(@NonNull String paramString, boolean paramBoolean, int paramInt)
  {
    if (4 == paramInt) {
      return bpac.a(paramString, paramBoolean);
    }
    return bpab.a(paramString, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bozz
 * JD-Core Version:    0.7.0.1
 */