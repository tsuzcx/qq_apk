package com.tencent.component.network.downloader.impl.ipc;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.tencent.component.network.downloader.Downloader.DownloadListener;
import com.tencent.component.network.downloader.Downloader.DownloadMode;
import java.util.ArrayList;
import java.util.List;

public class Const$SimpleRequest
  implements Parcelable
{
  public static final Parcelable.Creator<SimpleRequest> CREATOR = new Const.SimpleRequest.1();
  public int content_type;
  public Downloader.DownloadListener listener;
  public Downloader.DownloadMode mode;
  public List<String> pathList;
  public String url;
  
  public Const$SimpleRequest() {}
  
  public Const$SimpleRequest(Parcel paramParcel)
  {
    if (paramParcel == null) {
      return;
    }
    this.url = paramParcel.readString();
    this.pathList = new ArrayList();
    paramParcel.readStringList(this.pathList);
    this.content_type = paramParcel.readInt();
    if (paramParcel.readInt() == 0) {
      paramParcel = Downloader.DownloadMode.FastMode;
    } else {
      paramParcel = Downloader.DownloadMode.StrictMode;
    }
    this.mode = paramParcel;
  }
  
  public void addDstPath(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    if (this.pathList == null) {
      this.pathList = new ArrayList();
    }
    if (!this.pathList.contains(paramString)) {
      this.pathList.add(paramString);
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (paramObject != null)
    {
      if (!(paramObject instanceof SimpleRequest)) {
        return false;
      }
      paramObject = (SimpleRequest)paramObject;
      return (this.url.equalsIgnoreCase(paramObject.url)) && (Const.access$000(this.listener, paramObject.listener));
    }
    return false;
  }
  
  public String[] getPaths()
  {
    Object localObject = this.pathList;
    if (localObject == null) {
      return null;
    }
    localObject = new String[((List)localObject).size()];
    int i = 0;
    while (i < this.pathList.size())
    {
      localObject[i] = ((String)this.pathList.get(i));
      i += 1;
    }
    return localObject;
  }
  
  public String toString()
  {
    List localList = this.pathList;
    Object localObject1 = "";
    Object localObject2 = localObject1;
    if (localList != null)
    {
      int i = 0;
      for (;;)
      {
        localObject2 = localObject1;
        if (i >= this.pathList.size()) {
          break;
        }
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append((String)this.pathList.get(i));
        ((StringBuilder)localObject2).append(";");
        localObject1 = ((StringBuilder)localObject2).toString();
        i += 1;
      }
    }
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("Download SimpleRequest: ");
    ((StringBuilder)localObject1).append(this.url);
    ((StringBuilder)localObject1).append(", Path:");
    ((StringBuilder)localObject1).append((String)localObject2);
    ((StringBuilder)localObject1).append(", content_type:");
    ((StringBuilder)localObject1).append(this.content_type);
    return new String(((StringBuilder)localObject1).toString());
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    if (paramParcel == null) {
      return;
    }
    paramParcel.writeString(this.url);
    paramParcel.writeStringList(this.pathList);
    paramParcel.writeInt(this.content_type);
    if (this.mode == Downloader.DownloadMode.FastMode) {
      paramInt = 0;
    } else {
      paramInt = 1;
    }
    paramParcel.writeInt(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.component.network.downloader.impl.ipc.Const.SimpleRequest
 * JD-Core Version:    0.7.0.1
 */