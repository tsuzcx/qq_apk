package androidx.appcompat.widget;

import android.content.ComponentName;
import java.math.BigDecimal;

public final class ActivityChooserModel$HistoricalRecord
{
  public final ComponentName activity;
  public final long time;
  public final float weight;
  
  public ActivityChooserModel$HistoricalRecord(ComponentName paramComponentName, long paramLong, float paramFloat)
  {
    this.activity = paramComponentName;
    this.time = paramLong;
    this.weight = paramFloat;
  }
  
  public ActivityChooserModel$HistoricalRecord(String paramString, long paramLong, float paramFloat)
  {
    this(ComponentName.unflattenFromString(paramString), paramLong, paramFloat);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (paramObject == null) {
      return false;
    }
    if (getClass() != paramObject.getClass()) {
      return false;
    }
    paramObject = (HistoricalRecord)paramObject;
    ComponentName localComponentName = this.activity;
    if (localComponentName == null)
    {
      if (paramObject.activity != null) {
        return false;
      }
    }
    else if (!localComponentName.equals(paramObject.activity)) {
      return false;
    }
    if (this.time != paramObject.time) {
      return false;
    }
    return Float.floatToIntBits(this.weight) == Float.floatToIntBits(paramObject.weight);
  }
  
  public int hashCode()
  {
    ComponentName localComponentName = this.activity;
    int i;
    if (localComponentName == null) {
      i = 0;
    } else {
      i = localComponentName.hashCode();
    }
    long l = this.time;
    return ((i + 31) * 31 + (int)(l ^ l >>> 32)) * 31 + Float.floatToIntBits(this.weight);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[");
    localStringBuilder.append("; activity:");
    localStringBuilder.append(this.activity);
    localStringBuilder.append("; time:");
    localStringBuilder.append(this.time);
    localStringBuilder.append("; weight:");
    localStringBuilder.append(new BigDecimal(this.weight));
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.appcompat.widget.ActivityChooserModel.HistoricalRecord
 * JD-Core Version:    0.7.0.1
 */