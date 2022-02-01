package androidx.appcompat.widget;

import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

final class ActivityChooserModel$DefaultSorter
  implements ActivityChooserModel.ActivitySorter
{
  private static final float WEIGHT_DECAY_COEFFICIENT = 0.95F;
  private final Map<ComponentName, ActivityChooserModel.ActivityResolveInfo> mPackageNameToActivityMap = new HashMap();
  
  public void sort(Intent paramIntent, List<ActivityChooserModel.ActivityResolveInfo> paramList, List<ActivityChooserModel.HistoricalRecord> paramList1)
  {
    paramIntent = this.mPackageNameToActivityMap;
    paramIntent.clear();
    int j = paramList.size();
    int i = 0;
    Object localObject;
    while (i < j)
    {
      localObject = (ActivityChooserModel.ActivityResolveInfo)paramList.get(i);
      ((ActivityChooserModel.ActivityResolveInfo)localObject).weight = 0.0F;
      paramIntent.put(new ComponentName(((ActivityChooserModel.ActivityResolveInfo)localObject).resolveInfo.activityInfo.packageName, ((ActivityChooserModel.ActivityResolveInfo)localObject).resolveInfo.activityInfo.name), localObject);
      i += 1;
    }
    i = paramList1.size() - 1;
    float f2;
    for (float f1 = 1.0F; i >= 0; f1 = f2)
    {
      localObject = (ActivityChooserModel.HistoricalRecord)paramList1.get(i);
      ActivityChooserModel.ActivityResolveInfo localActivityResolveInfo = (ActivityChooserModel.ActivityResolveInfo)paramIntent.get(((ActivityChooserModel.HistoricalRecord)localObject).activity);
      f2 = f1;
      if (localActivityResolveInfo != null)
      {
        localActivityResolveInfo.weight += ((ActivityChooserModel.HistoricalRecord)localObject).weight * f1;
        f2 = f1 * 0.95F;
      }
      i -= 1;
    }
    Collections.sort(paramList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.appcompat.widget.ActivityChooserModel.DefaultSorter
 * JD-Core Version:    0.7.0.1
 */