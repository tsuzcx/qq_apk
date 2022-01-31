import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.common.config.AppSetting;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class bgxb
{
  private static final List<Pair<String, Integer>> a = new LinkedList();
  
  static
  {
    a.add(new Pair("AEKIT_CAMERA_FIRST_LAUNCH", Integer.valueOf(0)));
  }
  
  private bgxb()
  {
    Object localObject = bgxe.a("key_app_version", "");
    if ((TextUtils.isEmpty((CharSequence)localObject)) || (!AppSetting.a().equals(localObject)))
    {
      localObject = a.iterator();
      while (((Iterator)localObject).hasNext())
      {
        Pair localPair = (Pair)((Iterator)localObject).next();
        if (4 == ((Integer)localPair.second).intValue()) {
          bgxe.a((String)localPair.first);
        } else {
          bgxd.a((String)localPair.first);
        }
      }
      bgxe.a("key_app_version", AppSetting.a());
    }
  }
  
  public static bgxb a()
  {
    return bgxf.a();
  }
  
  public int a(@NonNull String paramString, int paramInt1, int paramInt2)
  {
    if (4 == paramInt2) {
      return bgxe.a(paramString, paramInt1);
    }
    return bgxd.a(paramString, paramInt1);
  }
  
  public long a(@NonNull String paramString, long paramLong, int paramInt)
  {
    if (4 == paramInt) {
      return bgxe.a(paramString, paramLong);
    }
    return bgxd.a(paramString, paramLong);
  }
  
  @NonNull
  public SharedPreferences a()
  {
    return bgxd.a();
  }
  
  @Nullable
  public String a(@NonNull String paramString1, String paramString2, int paramInt)
  {
    if (4 == paramInt) {
      return bgxe.a(paramString1, paramString2);
    }
    return bgxd.a(paramString1, paramString2);
  }
  
  public void a(@NonNull String paramString, int paramInt)
  {
    if (4 == paramInt)
    {
      bgxe.a(paramString);
      return;
    }
    bgxd.a(paramString);
  }
  
  public void a(@NonNull String paramString, int paramInt1, int paramInt2)
  {
    if (4 == paramInt2)
    {
      bgxe.a(paramString, paramInt1);
      return;
    }
    bgxd.a(paramString, paramInt1);
  }
  
  public void a(@NonNull String paramString, long paramLong, int paramInt)
  {
    if (4 == paramInt)
    {
      bgxe.a(paramString, paramLong);
      return;
    }
    bgxd.a(paramString, paramLong);
  }
  
  public void a(@NonNull String paramString1, String paramString2, int paramInt)
  {
    if (4 == paramInt)
    {
      bgxe.a(paramString1, paramString2);
      return;
    }
    bgxd.a(paramString1, paramString2);
  }
  
  public void a(@NonNull String paramString, boolean paramBoolean, int paramInt)
  {
    if (4 == paramInt)
    {
      bgxe.a(paramString, paramBoolean);
      return;
    }
    bgxd.a(paramString, paramBoolean);
  }
  
  public boolean a(@NonNull String paramString, int paramInt)
  {
    if (4 == paramInt) {
      return bgxe.a(paramString);
    }
    return bgxd.a(paramString);
  }
  
  public boolean a(@NonNull String paramString, boolean paramBoolean, int paramInt)
  {
    if (4 == paramInt) {
      return bgxe.a(paramString, paramBoolean);
    }
    return bgxd.a(paramString, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bgxb
 * JD-Core Version:    0.7.0.1
 */