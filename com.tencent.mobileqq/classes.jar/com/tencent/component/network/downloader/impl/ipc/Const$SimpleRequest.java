package com.tencent.component.network.downloader.impl.ipc;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.tencent.component.network.downloader.Downloader.DownloadListener;
import com.tencent.component.network.downloader.Downloader.DownloadMode;
import java.util.ArrayList;
import java.util.List;
import pic;

public class Const$SimpleRequest
  implements Parcelable
{
  public static final Parcelable.Creator CREATOR = new pic();
  public int a;
  public Downloader.DownloadListener a;
  public Downloader.DownloadMode a;
  public String a;
  public List a;
  
  public Const$SimpleRequest() {}
  
  public Const$SimpleRequest(Parcel paramParcel)
  {
    if (paramParcel == null) {
      return;
    }
    this.jdField_a_of_type_JavaLangString = paramParcel.readString();
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    paramParcel.readStringList(this.jdField_a_of_type_JavaUtilList);
    this.jdField_a_of_type_Int = paramParcel.readInt();
    if (paramParcel.readInt() == 0) {}
    for (paramParcel = Downloader.DownloadMode.FastMode;; paramParcel = Downloader.DownloadMode.StrictMode)
    {
      this.jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader$DownloadMode = paramParcel;
      return;
    }
  }
  
  public void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return;
      if (this.jdField_a_of_type_JavaUtilList == null) {
        this.jdField_a_of_type_JavaUtilList = new ArrayList();
      }
    } while (this.jdField_a_of_type_JavaUtilList.contains(paramString));
    this.jdField_a_of_type_JavaUtilList.add(paramString);
  }
  
  public String[] a()
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      return null;
    }
    String[] arrayOfString = new String[this.jdField_a_of_type_JavaUtilList.size()];
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilList.size())
    {
      arrayOfString[i] = ((String)this.jdField_a_of_type_JavaUtilList.get(i));
      i += 1;
    }
    return arrayOfString;
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
    } while ((this.jdField_a_of_type_JavaLangString.equalsIgnoreCase(paramObject.jdField_a_of_type_JavaLangString)) && (Const.a(this.jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader$DownloadListener, paramObject.jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader$DownloadListener)));
    return false;
  }
  
  public String toString()
  {
    if (this.jdField_a_of_type_JavaUtilList != null)
    {
      String str1 = "";
      int i = 0;
      for (;;)
      {
        str2 = str1;
        if (i >= this.jdField_a_of_type_JavaUtilList.size()) {
          break;
        }
        str1 = str1 + (String)this.jdField_a_of_type_JavaUtilList.get(i) + ";";
        i += 1;
      }
    }
    String str2 = "";
    return new String("Download SimpleRequest: " + this.jdField_a_of_type_JavaLangString + ", Path:" + str2 + ", content_type:" + this.jdField_a_of_type_Int);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    if (paramParcel == null) {
      return;
    }
    paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
    paramParcel.writeStringList(this.jdField_a_of_type_JavaUtilList);
    paramParcel.writeInt(this.jdField_a_of_type_Int);
    if (this.jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader$DownloadMode == Downloader.DownloadMode.FastMode) {}
    for (paramInt = 0;; paramInt = 1)
    {
      paramParcel.writeInt(paramInt);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.component.network.downloader.impl.ipc.Const.SimpleRequest
 * JD-Core Version:    0.7.0.1
 */