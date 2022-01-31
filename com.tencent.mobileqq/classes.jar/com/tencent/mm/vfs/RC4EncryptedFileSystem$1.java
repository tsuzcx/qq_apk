package com.tencent.mm.vfs;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class RC4EncryptedFileSystem$1
  implements Parcelable.Creator<RC4EncryptedFileSystem>
{
  public RC4EncryptedFileSystem createFromParcel(Parcel paramParcel)
  {
    return new RC4EncryptedFileSystem(paramParcel, null);
  }
  
  public RC4EncryptedFileSystem[] newArray(int paramInt)
  {
    return new RC4EncryptedFileSystem[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mm.vfs.RC4EncryptedFileSystem.1
 * JD-Core Version:    0.7.0.1
 */