import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.common.config.AppSetting;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class bjaa
{
  private static final List<Pair<String, Integer>> a = new LinkedList();
  
  static
  {
    a.add(new Pair("AEKIT_CAMERA_FIRST_LAUNCH", Integer.valueOf(0)));
    a.add(new Pair("CameraModuleSvc.GetCompressedCategoryMaterialMqStoryCamera", Integer.valueOf(4)));
    a.add(new Pair("CameraModuleSvc.GetCompressedCategoryMaterialMqEmoCamera", Integer.valueOf(4)));
    a.add(new Pair("CameraModuleSvc.GetPlayShowCatMatTree", Integer.valueOf(4)));
  }
  
  private bjaa()
  {
    Object localObject = bjad.a("key_app_version", "");
    if ((TextUtils.isEmpty((CharSequence)localObject)) || (!AppSetting.a().equals(localObject)))
    {
      localObject = a.iterator();
      while (((Iterator)localObject).hasNext())
      {
        Pair localPair = (Pair)((Iterator)localObject).next();
        if (4 == ((Integer)localPair.second).intValue()) {
          bjad.a((String)localPair.first);
        } else {
          bjac.a((String)localPair.first);
        }
      }
      bjad.a("key_app_version", AppSetting.a());
    }
  }
  
  public static bjaa a()
  {
    return bjae.a();
  }
  
  public int a(@NonNull String paramString, int paramInt1, int paramInt2)
  {
    if (4 == paramInt2) {
      return bjad.a(paramString, paramInt1);
    }
    return bjac.a(paramString, paramInt1);
  }
  
  public long a(@NonNull String paramString, long paramLong, int paramInt)
  {
    if (4 == paramInt) {
      return bjad.a(paramString, paramLong);
    }
    return bjac.a(paramString, paramLong);
  }
  
  @NonNull
  public SharedPreferences a()
  {
    return bjac.a();
  }
  
  @Nullable
  public String a(@NonNull String paramString1, String paramString2, int paramInt)
  {
    if (4 == paramInt) {
      return bjad.a(paramString1, paramString2);
    }
    return bjac.a(paramString1, paramString2);
  }
  
  public void a(@NonNull String paramString, int paramInt)
  {
    if (4 == paramInt)
    {
      bjad.a(paramString);
      return;
    }
    bjac.a(paramString);
  }
  
  public void a(@NonNull String paramString, int paramInt1, int paramInt2)
  {
    if (4 == paramInt2)
    {
      bjad.a(paramString, paramInt1);
      return;
    }
    bjac.a(paramString, paramInt1);
  }
  
  public void a(@NonNull String paramString, long paramLong, int paramInt)
  {
    if (4 == paramInt)
    {
      bjad.a(paramString, paramLong);
      return;
    }
    bjac.a(paramString, paramLong);
  }
  
  public void a(@NonNull String paramString1, String paramString2, int paramInt)
  {
    if (4 == paramInt)
    {
      bjad.a(paramString1, paramString2);
      return;
    }
    bjac.a(paramString1, paramString2);
  }
  
  public void a(@NonNull String paramString, boolean paramBoolean, int paramInt)
  {
    if (4 == paramInt)
    {
      bjad.a(paramString, paramBoolean);
      return;
    }
    bjac.a(paramString, paramBoolean);
  }
  
  public boolean a(@NonNull String paramString, int paramInt)
  {
    if (4 == paramInt) {
      return bjad.a(paramString);
    }
    return bjac.a(paramString);
  }
  
  public boolean a(@NonNull String paramString, boolean paramBoolean, int paramInt)
  {
    if (4 == paramInt) {
      return bjad.a(paramString, paramBoolean);
    }
    return bjac.a(paramString, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bjaa
 * JD-Core Version:    0.7.0.1
 */