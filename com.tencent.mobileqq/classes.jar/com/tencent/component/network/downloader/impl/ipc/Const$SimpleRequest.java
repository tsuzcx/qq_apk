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
    if (paramParcel.readInt() == 0) {}
    for (paramParcel = Downloader.DownloadMode.FastMode;; paramParcel = Downloader.DownloadMode.StrictMode)
    {
      this.mode = paramParcel;
      return;
    }
  }
  
  public void addDstPath(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return;
      if (this.pathList == null) {
        this.pathList = new ArrayList();
      }
    } while (this.pathList.contains(paramString));
    this.pathList.add(paramString);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if ((paramObject == null) || (!(paramObject instanceof SimpleRequest))) {
        return false;
      }
      paramObject = (SimpleRequest)paramObject;
    } while ((this.url.equalsIgnoreCase(paramObject.url)) && (Const.access$000(this.listener, paramObject.listener)));
    return false;
  }
  
  public String[] getPaths()
  {
    if (this.pathList == null) {
      return null;
    }
    String[] arrayOfString = new String[this.pathList.size()];
    int i = 0;
    while (i < this.pathList.size())
    {
      arrayOfString[i] = ((String)this.pathList.get(i));
      i += 1;
    }
    return arrayOfString;
  }
  
  public String toString()
  {
    if (this.pathList != null)
    {
      String str1 = "";
      int i = 0;
      for (;;)
      {
        str2 = str1;
        if (i >= this.pathList.size()) {
          break;
        }
        str1 = str1 + (String)this.pathList.get(i) + ";";
        i += 1;
      }
    }
    String str2 = "";
    return new String("Download SimpleRequest: " + this.url + ", Path:" + str2 + ", content_type:" + this.content_type);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    if (paramParcel == null) {
      return;
    }
    paramParcel.writeString(this.url);
    paramParcel.writeStringList(this.pathList);
    paramParcel.writeInt(this.content_type);
    if (this.mode == Downloader.DownloadMode.FastMode) {}
    for (paramInt = 0;; paramInt = 1)
    {
      paramParcel.writeInt(paramInt);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.component.network.downloader.impl.ipc.Const.SimpleRequest
 * JD-Core Version:    0.7.0.1
 */