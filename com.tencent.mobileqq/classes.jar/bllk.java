import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.tavcut.bean.Size;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

public class bllk
{
  public static void a(int paramInt, @Nullable Activity paramActivity, @Nullable aimj paramaimj, @Nullable String paramString, boolean paramBoolean)
  {
    if ((paramActivity == null) || (paramaimj == null)) {
      return;
    }
    ArrayList localArrayList = new ArrayList(paramaimj.selectedPhotoList);
    if ((Build.VERSION.SDK_INT >= 21) && (paramBoolean))
    {
      a(paramInt, paramaimj.albumName, paramaimj.albumId, paramActivity, localArrayList, paramaimj.selectedMediaInfoHashMap, paramString);
      return;
    }
    if (paramInt == 1)
    {
      a(paramActivity, localArrayList, paramaimj.selectedMediaInfoHashMap, bkwm.y.a());
      return;
    }
    a(paramActivity, localArrayList, paramaimj.selectedMediaInfoHashMap, bkwm.y.a());
  }
  
  public static void a(int paramInt, @Nullable String paramString1, @Nullable String paramString2, @Nullable Activity paramActivity, @Nullable ArrayList<String> paramArrayList, @Nullable HashMap<String, LocalMediaInfo> paramHashMap, @Nullable String paramString3)
  {
    if ((paramActivity == null) || (paramArrayList == null) || (paramHashMap == null) || (paramString3 == null)) {}
    Bundle localBundle;
    do
    {
      return;
      localBundle = new Bundle();
      localBundle.putStringArrayList("PhotoConst.SELECTED_PATHS", paramArrayList);
      localBundle.putString("res_path", paramString3);
      localBundle.putString("albumName", paramString1);
      localBundle.putString("albumId", paramString2);
      localBundle.putSerializable("PeakConstants.selectedMediaInfoHashMap", paramHashMap);
      if (paramInt == 0)
      {
        blfq.a(paramActivity, 0, localBundle, bkwm.y.a());
        return;
      }
    } while (paramInt != 1);
    blfq.a(paramActivity, 1, localBundle, bkwm.y.a());
  }
  
  public static void a(@Nullable Activity paramActivity, @Nullable ArrayList<String> paramArrayList, @Nullable HashMap<String, LocalMediaInfo> paramHashMap, int paramInt)
  {
    if ((paramActivity == null) || (paramArrayList == null) || (paramHashMap == null)) {
      return;
    }
    Intent localIntent = new Intent();
    localIntent.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", paramArrayList);
    localIntent.putExtra("PeakConstants.selectedMediaInfoHashMap", paramHashMap);
    localIntent.putExtra("video_photo_from", paramInt);
    bizm.a(paramActivity, localIntent);
  }
  
  public static void a(@Nullable Context paramContext, @Nullable String paramString, @Nullable LocalMediaInfo paramLocalMediaInfo, int paramInt)
  {
    if ((paramContext == null) || (paramString == null) || (paramLocalMediaInfo == null)) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramString);
    HashMap localHashMap = new HashMap();
    localHashMap.put(paramString, paramLocalMediaInfo);
    paramString = new Intent();
    paramString.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", localArrayList);
    paramString.putExtra("PeakConstants.selectedMediaInfoHashMap", localHashMap);
    paramString.putExtra("video_photo_from", paramInt);
    bizm.a(paramContext, paramString);
  }
  
  public static void a(@Nullable Context paramContext, @Nullable String paramString1, @Nullable String paramString2, @Nullable String paramString3, @Nullable Size paramSize, @Nullable ArrayList paramArrayList, int paramInt)
  {
    if ((paramContext == null) || (paramString2 == null) || (paramString1 == null) || (paramSize == null)) {}
    while (!new File(paramString2).exists()) {
      return;
    }
    paramString2 = blll.a(paramSize.getHeight(), paramSize.getWidth(), paramString1, paramString2, paramString3);
    if (paramArrayList != null) {
      paramString2.aiTextLabel = paramArrayList;
    }
    a(paramContext, paramString1, paramString2, paramInt);
  }
  
  public static void a(@Nullable Context paramContext, @Nullable ArrayList<String> paramArrayList, @Nullable HashMap<String, LocalMediaInfo> paramHashMap, int paramInt)
  {
    if ((paramContext == null) || (paramArrayList == null) || (paramHashMap == null)) {
      return;
    }
    Intent localIntent = new Intent();
    localIntent.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", paramArrayList);
    localIntent.putExtra("PeakConstants.selectedMediaInfoHashMap", paramHashMap);
    localIntent.putExtra("video_photo_from", paramInt);
    bizm.a(paramContext, localIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bllk
 * JD-Core Version:    0.7.0.1
 */