import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.common.config.AppSetting;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class bnqu
{
  private static final List<Pair<String, Integer>> a = new LinkedList();
  
  static
  {
    a.add(new Pair("AEKIT_CAMERA_FIRST_LAUNCH", Integer.valueOf(0)));
    a.add(new Pair("CameraModuleSvc.GetCompressedCategoryMaterialMqStoryCamera", Integer.valueOf(4)));
    a.add(new Pair("CameraModuleSvc.GetCompressedCategoryMaterialMqEmoCamera", Integer.valueOf(4)));
    a.add(new Pair("CameraModuleSvc.GetPlayShowCatMatTree", Integer.valueOf(4)));
  }
  
  private bnqu()
  {
    Object localObject = bnqx.a("key_app_version", "");
    if ((TextUtils.isEmpty((CharSequence)localObject)) || (!AppSetting.a().equals(localObject)))
    {
      localObject = a.iterator();
      while (((Iterator)localObject).hasNext())
      {
        Pair localPair = (Pair)((Iterator)localObject).next();
        if (4 == ((Integer)localPair.second).intValue()) {
          bnqx.a((String)localPair.first);
        } else {
          bnqw.a((String)localPair.first);
        }
      }
      bnqx.a("key_app_version", AppSetting.a());
    }
  }
  
  public static bnqu a()
  {
    return bnqy.a();
  }
  
  public float a(@NonNull String paramString, float paramFloat, int paramInt)
  {
    if (4 == paramInt) {
      return bnqx.a(paramString, paramFloat);
    }
    return bnqw.a(paramString, paramFloat);
  }
  
  public int a(@NonNull String paramString, int paramInt1, int paramInt2)
  {
    if (4 == paramInt2) {
      return bnqx.a(paramString, paramInt1);
    }
    return bnqw.a(paramString, paramInt1);
  }
  
  public long a(@NonNull String paramString, long paramLong, int paramInt)
  {
    if (4 == paramInt) {
      return bnqx.a(paramString, paramLong);
    }
    return bnqw.a(paramString, paramLong);
  }
  
  @NonNull
  public SharedPreferences a()
  {
    return bnqw.a();
  }
  
  @Nullable
  public String a(@NonNull String paramString1, String paramString2, int paramInt)
  {
    if (4 == paramInt) {
      return bnqx.a(paramString1, paramString2);
    }
    return bnqw.a(paramString1, paramString2);
  }
  
  public void a(@NonNull String paramString, float paramFloat, int paramInt)
  {
    if (4 == paramInt)
    {
      bnqx.a(paramString, paramFloat);
      return;
    }
    bnqw.a(paramString, paramFloat);
  }
  
  public void a(@NonNull String paramString, int paramInt)
  {
    if (4 == paramInt)
    {
      bnqx.a(paramString);
      return;
    }
    bnqw.a(paramString);
  }
  
  public void a(@NonNull String paramString, int paramInt1, int paramInt2)
  {
    if (4 == paramInt2)
    {
      bnqx.a(paramString, paramInt1);
      return;
    }
    bnqw.a(paramString, paramInt1);
  }
  
  public void a(@NonNull String paramString, long paramLong, int paramInt)
  {
    if (4 == paramInt)
    {
      bnqx.a(paramString, paramLong);
      return;
    }
    bnqw.a(paramString, paramLong);
  }
  
  public void a(@NonNull String paramString1, String paramString2, int paramInt)
  {
    if (4 == paramInt)
    {
      bnqx.a(paramString1, paramString2);
      return;
    }
    bnqw.a(paramString1, paramString2);
  }
  
  public void a(@NonNull String paramString, boolean paramBoolean, int paramInt)
  {
    if (4 == paramInt)
    {
      bnqx.a(paramString, paramBoolean);
      return;
    }
    bnqw.a(paramString, paramBoolean);
  }
  
  public boolean a(@NonNull String paramString, int paramInt)
  {
    if (4 == paramInt) {
      return bnqx.a(paramString);
    }
    return bnqw.a(paramString);
  }
  
  public boolean a(@NonNull String paramString, boolean paramBoolean, int paramInt)
  {
    if (4 == paramInt) {
      return bnqx.a(paramString, paramBoolean);
    }
    return bnqw.a(paramString, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnqu
 * JD-Core Version:    0.7.0.1
 */