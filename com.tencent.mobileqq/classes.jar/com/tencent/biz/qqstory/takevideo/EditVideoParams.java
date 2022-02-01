package com.tencent.biz.qqstory.takevideo;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class EditVideoParams
  implements Parcelable
{
  public static final int BUSINESS_BLESS = 5;
  public static final int BUSINESS_EMOJI_REDPACK = 13;
  public static final int BUSINESS_NOW_SMALLVIDEO = 9;
  public static final int BUSINESS_QQ = 2;
  public static final int BUSINESS_QQSTORY = 1;
  public static final int BUSINESS_QZONE = 3;
  public static final int BUSINESS_READENJOY = 4;
  public static final int BUSINESS_READENJOY_UGC = 8;
  public static final int BUSINESS_READINJOY_VIDEO = 12;
  public static final int BUSINESS_TRIBE = 10;
  public static final int BUSINESS_TROOP_ARITHMETIC = 11;
  public static final int BUSINESS_VIDEO_STORY = 14;
  public static final int BUSINESS_WEB = 6;
  public static final Parcelable.Creator<EditVideoParams> CREATOR = new EditVideoParams.1();
  public static final int ENABLE_AIO_SYNC_TO_STORY_KEY = -2147483648;
  public static final int ENABLE_ART_FILTER = 16;
  public static final int ENABLE_EDIT_PIC_CROP = 2;
  public static final int ENABLE_FACE = 8;
  public static final int ENABLE_FILTER = 64;
  public static final int ENABLE_FILTER_PACK = 1048576;
  public static final int ENABLE_GENERATE_GIF = 8192;
  public static final int ENABLE_GIF_ANTISHAKE = 65536;
  public static final int ENABLE_GIF_SPEED = 4096;
  public static final int ENABLE_GUIDE = 256;
  public static final int ENABLE_JUMPTO_PITU = 262144;
  public static final int ENABLE_LABEL = 128;
  public static final int ENABLE_LINE = 1;
  public static final int ENABLE_MASK_BIT_COUNT = 23;
  public static final int ENABLE_MULTI_VIDEO_FRAGMENT = 32768;
  public static final int ENABLE_MUSIC = 32;
  public static final int ENABLE_PERMISSION_SETTING = 16384;
  public static final int ENABLE_SAVE = 1024;
  public static final int ENABLE_SHARE_GROUP = 2097152;
  public static final int ENABLE_SHARE_TO_GROUP = 131072;
  public static final int ENABLE_SPEED_FILTER = 524288;
  public static final int ENABLE_SYNC_STORY_SHOW = 2048;
  public static final int ENABLE_TAG = 4194304;
  public static final int ENABLE_TEXT = 4;
  public static final int ENABLE_VOICE_CHANGE = 512;
  public static final String EXPECT_FRAGMENT_COUNT = "expect_fragment_count";
  public static final String EXTRA_BLESS_H5_LATITUDE = "extra_bless_latitude";
  public static final String EXTRA_BLESS_H5_LONGITUDE = "extra_bless_longitude";
  public static final String EXTRA_BLESS_H5_SOURDIR = "extra_bless_source_dir";
  public static final String EXTRA_ENABLE_EDIT_BUTTON = "extra_enable_edit_button";
  public static final String EXTRA_ENABLE_HW_ENCODE = "enable_hw_encode";
  public static final String EXTRA_ENABLE_REVERT = "extra_enable_revert";
  public static final String EXTRA_ENABLE_SLOW = "extra_enable_slow";
  public static final String EXTRA_LOCAL_ADDRESS_CITY_NAME = "extra_local_address_city_name";
  public static final String EXTRA_PUBLISH_TEXT = "extra_publish_text";
  public static final String EXTRA_TRANS_SRC_FROM = "extra_transiton_src_from";
  public static final String EXTRA_UPLOAD_TEMP_DIRECTORY = "extra_upload_temp_directory";
  public static final String EXTRA_VIDEO_REDBAG_GET = "video_redbag_get";
  public static final int GIF_DEFAULT_ENABLE_MASKS = 4109;
  public static final String PARAM_EDIT_SOURCE = "param_edit_source";
  public static final String PIC_ENTRANCE_TYPE = "pic_entrance_type";
  public static final int QQSTORY_DEFAULT_ENABLE_MASKS = 4374893;
  public static final String QQ_SUB_BUSINESS_ID = "qq_sub_business_id";
  public static final int QQ_SUB_BUSINESS_OCR = 103;
  public static final int QQ_SUB_BUSINESS_OCR_SEARCHQUESTION = 105;
  public static final int QQ_SUB_BUSINESS_PRE_GUIDE = 104;
  public static final long VIDEO_BLOCK_DURATION = 10000L;
  public static final int VIDEO_BLOCK_MAX_COUNT = 6;
  public int mBusinessId;
  public EditVideoParams.EditSource mEditSource;
  public final int mEnableMasks;
  public final Bundle mExtra;
  
  public EditVideoParams(int paramInt1, int paramInt2, EditVideoParams.EditSource paramEditSource, Bundle paramBundle)
  {
    this.mBusinessId = paramInt1;
    this.mEnableMasks = paramInt2;
    this.mEditSource = paramEditSource;
    if (paramBundle == null)
    {
      this.mExtra = new Bundle();
      return;
    }
    this.mExtra = paramBundle;
  }
  
  protected EditVideoParams(Parcel paramParcel)
  {
    this.mBusinessId = paramParcel.readInt();
    this.mEnableMasks = paramParcel.readInt();
    this.mEditSource = ((EditVideoParams.EditSource)paramParcel.readParcelable(EditVideoParams.EditSource.class.getClassLoader()));
    this.mExtra = paramParcel.readBundle(getClass().getClassLoader());
  }
  
  public static Bundle setBundleForBusiness(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 104: 
    case 10010: 
      localBundle = new Bundle();
      localBundle.putInt("qq_sub_business_id", 104);
      return localBundle;
    case 103: 
      localBundle = new Bundle();
      localBundle.putInt("qq_sub_business_id", 103);
      return localBundle;
    }
    Bundle localBundle = new Bundle();
    localBundle.putInt("qq_sub_business_id", 11);
    return localBundle;
  }
  
  public String checkParams()
  {
    Object localObject;
    switch (this.mBusinessId)
    {
    case 7: 
    case 8: 
    case 9: 
    default: 
      localObject = "Unknown Business id " + this.mBusinessId;
    }
    String str;
    do
    {
      return localObject;
      if (this.mEditSource == null) {
        return "Can not find edit source";
      }
      str = this.mEditSource.checkParam();
      localObject = str;
    } while (str != null);
    return null;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean getBooleanExtra(String paramString, boolean paramBoolean)
  {
    boolean bool = paramBoolean;
    if (this.mExtra != null) {
      bool = this.mExtra.getBoolean(paramString, paramBoolean);
    }
    return bool;
  }
  
  public int getBussinessId()
  {
    int j = 6;
    int k = this.mBusinessId;
    int i = k;
    if (this.mExtra != null)
    {
      if (k == 2) {
        i = this.mExtra.getInt("qq_sub_business_id");
      }
      do
      {
        return i;
        i = k;
        if (k != 6) {
          break;
        }
        k = this.mExtra.getInt("qq_sub_business_id", -999);
        i = j;
      } while (k == -999);
      i = k;
    }
    return i;
  }
  
  public byte[] getBytesExtra(String paramString)
  {
    if (this.mExtra != null) {
      return this.mExtra.getByteArray(paramString);
    }
    return null;
  }
  
  public double getDoubleExtra(String paramString, double paramDouble)
  {
    double d = paramDouble;
    if (this.mExtra != null) {
      d = this.mExtra.getDouble(paramString, paramDouble);
    }
    return d;
  }
  
  public boolean getEnableHWEncode()
  {
    if (this.mExtra == null) {
      return false;
    }
    return this.mExtra.getBoolean("enable_hw_encode");
  }
  
  public boolean getEnableRevert()
  {
    if (this.mExtra == null) {
      return true;
    }
    return this.mExtra.getBoolean("extra_enable_revert", true);
  }
  
  public boolean getEnableSlow()
  {
    if (this.mExtra == null) {
      return true;
    }
    return this.mExtra.getBoolean("extra_enable_slow", true);
  }
  
  public int getEntranceType()
  {
    if (this.mExtra == null) {
      return 99;
    }
    return this.mExtra.getInt("entrance_type", 99);
  }
  
  public int getExpectFragmentCount()
  {
    if (this.mExtra == null) {
      return 1;
    }
    return this.mExtra.getInt("expect_fragment_count", 1);
  }
  
  public int getIntExtra(String paramString, int paramInt)
  {
    int i = paramInt;
    if (this.mExtra != null) {
      i = this.mExtra.getInt(paramString, paramInt);
    }
    return i;
  }
  
  public long getLongExtra(String paramString, long paramLong)
  {
    long l = paramLong;
    if (this.mExtra != null) {
      l = this.mExtra.getLong(paramString, paramLong);
    }
    return l;
  }
  
  public String getStringExtra(String paramString)
  {
    if (this.mExtra != null) {
      return this.mExtra.getString(paramString);
    }
    return null;
  }
  
  public boolean isEditCamera()
  {
    return ((this.mEditSource instanceof EditRecordVideoSource)) || ((this.mEditSource instanceof EditTakePhotoSource)) || ((this.mEditSource instanceof EditTakeVideoSource));
  }
  
  public boolean isEditLocal()
  {
    return ((this.mEditSource instanceof EditLocalVideoSource)) || ((this.mEditSource instanceof EditLocalPhotoSource));
  }
  
  public boolean isEditLocalGif()
  {
    return this.mEditSource instanceof EditLocalGifSource;
  }
  
  public boolean isEditPhoto()
  {
    return ((this.mEditSource instanceof EditTakePhotoSource)) || ((this.mEditSource instanceof EditLocalPhotoSource));
  }
  
  public boolean isEditTakeGif()
  {
    return this.mEditSource instanceof EditTakeGifSource;
  }
  
  public boolean isEditVideo()
  {
    return ((this.mEditSource instanceof EditRecordVideoSource)) || ((this.mEditSource instanceof EditLocalVideoSource)) || ((this.mEditSource instanceof EditTakeVideoSource));
  }
  
  public String toString()
  {
    return "EditVideoParams{mBusinessId=" + this.mBusinessId + ", mEnableMasks=" + this.mEnableMasks + ", mEditSource=" + this.mEditSource + ", entranceType=" + getEntranceType() + ", mExtra=" + this.mExtra + '}';
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.mBusinessId);
    paramParcel.writeInt(this.mEnableMasks);
    paramParcel.writeParcelable(this.mEditSource, paramInt);
    paramParcel.writeBundle(this.mExtra);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.EditVideoParams
 * JD-Core Version:    0.7.0.1
 */