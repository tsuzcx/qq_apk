import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.common.config.AppSetting;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class blev
{
  private static final List<Pair<String, Integer>> a = new LinkedList();
  
  static
  {
    a.add(new Pair("AEKIT_CAMERA_FIRST_LAUNCH", Integer.valueOf(0)));
    a.add(new Pair("CameraModuleSvc.GetCompressedCategoryMaterialMqStoryCamera", Integer.valueOf(4)));
    a.add(new Pair("CameraModuleSvc.GetCompressedCategoryMaterialMqEmoCamera", Integer.valueOf(4)));
    a.add(new Pair("CameraModuleSvc.GetPlayShowCatMatTree", Integer.valueOf(4)));
  }
  
  private blev()
  {
    Object localObject = bley.a("key_app_version", "");
    if ((TextUtils.isEmpty((CharSequence)localObject)) || (!AppSetting.a().equals(localObject)))
    {
      localObject = a.iterator();
      while (((Iterator)localObject).hasNext())
      {
        Pair localPair = (Pair)((Iterator)localObject).next();
        if (4 == ((Integer)localPair.second).intValue()) {
          bley.a((String)localPair.first);
        } else {
          blex.a((String)localPair.first);
        }
      }
      bley.a("key_app_version", AppSetting.a());
    }
  }
  
  public static blev a()
  {
    return blez.a();
  }
  
  public int a(@NonNull String paramString, int paramInt1, int paramInt2)
  {
    if (4 == paramInt2) {
      return bley.a(paramString, paramInt1);
    }
    return blex.a(paramString, paramInt1);
  }
  
  public long a(@NonNull String paramString, long paramLong, int paramInt)
  {
    if (4 == paramInt) {
      return bley.a(paramString, paramLong);
    }
    return blex.a(paramString, paramLong);
  }
  
  @NonNull
  public SharedPreferences a()
  {
    return blex.a();
  }
  
  @Nullable
  public String a(@NonNull String paramString1, String paramString2, int paramInt)
  {
    if (4 == paramInt) {
      return bley.a(paramString1, paramString2);
    }
    return blex.a(paramString1, paramString2);
  }
  
  public void a(@NonNull String paramString, int paramInt)
  {
    if (4 == paramInt)
    {
      bley.a(paramString);
      return;
    }
    blex.a(paramString);
  }
  
  public void a(@NonNull String paramString, int paramInt1, int paramInt2)
  {
    if (4 == paramInt2)
    {
      bley.a(paramString, paramInt1);
      return;
    }
    blex.a(paramString, paramInt1);
  }
  
  public void a(@NonNull String paramString, long paramLong, int paramInt)
  {
    if (4 == paramInt)
    {
      bley.a(paramString, paramLong);
      return;
    }
    blex.a(paramString, paramLong);
  }
  
  public void a(@NonNull String paramString1, String paramString2, int paramInt)
  {
    if (4 == paramInt)
    {
      bley.a(paramString1, paramString2);
      return;
    }
    blex.a(paramString1, paramString2);
  }
  
  public void a(@NonNull String paramString, boolean paramBoolean, int paramInt)
  {
    if (4 == paramInt)
    {
      bley.a(paramString, paramBoolean);
      return;
    }
    blex.a(paramString, paramBoolean);
  }
  
  public boolean a(@NonNull String paramString, int paramInt)
  {
    if (4 == paramInt) {
      return bley.a(paramString);
    }
    return blex.a(paramString);
  }
  
  public boolean a(@NonNull String paramString, boolean paramBoolean, int paramInt)
  {
    if (4 == paramInt) {
      return bley.a(paramString, paramBoolean);
    }
    return blex.a(paramString, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blev
 * JD-Core Version:    0.7.0.1
 */