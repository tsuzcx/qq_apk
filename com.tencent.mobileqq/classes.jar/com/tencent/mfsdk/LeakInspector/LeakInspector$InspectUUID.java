package com.tencent.mfsdk.LeakInspector;

import android.text.TextUtils;
import com.tencent.commonsdk.pool.RecyclablePool.Recyclable;
import java.lang.ref.WeakReference;

public class LeakInspector$InspectUUID
  extends RecyclablePool.Recyclable
{
  public String classname = "";
  public String digest = "";
  String toString = "";
  char[] uuid = null;
  public WeakReference<Object> weakObj;
  
  public void recycle()
  {
    this.weakObj = null;
    this.digest = "";
    this.uuid = null;
    this.classname = "";
    this.toString = "";
  }
  
  public String toString()
  {
    if (TextUtils.isEmpty(this.toString))
    {
      StringBuilder localStringBuilder = new StringBuilder(64);
      localStringBuilder.append(this.classname);
      localStringBuilder.append("@");
      if (this.uuid != null) {
        localStringBuilder.append(this.uuid);
      }
      if (!TextUtils.isEmpty(this.digest))
      {
        localStringBuilder.append("_");
        localStringBuilder.append(this.digest);
      }
      this.toString = localStringBuilder.toString();
    }
    return this.toString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mfsdk.LeakInspector.LeakInspector.InspectUUID
 * JD-Core Version:    0.7.0.1
 */