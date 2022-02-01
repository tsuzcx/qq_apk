package com.tencent.biz.qqstory.album.model;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.provider.MediaStore.Images.Thumbnails;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.SerializationPB.PicInfo;
import com.tencent.biz.qqstory.database.StoryAlbumPicEntry;
import com.tencent.biz.qqstory.model.item.AddressItem;
import com.tencent.biz.qqstory.utils.AssertUtils;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.pb.PBDoubleField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.transfile.AlbumThumbDownloader;

public class StoryAlbum$PicInfo
{
  public double a;
  public int a;
  public long a;
  public AddressItem a;
  private LocalMediaInfo a;
  public String a;
  public double b;
  public int b;
  public long b;
  @Deprecated
  public String b;
  public int c;
  public long c;
  public String c;
  private int d;
  public long d;
  public String d;
  public long e;
  
  public Bitmap a(Context paramContext, int paramInt, BitmapFactory.Options paramOptions)
  {
    
    if (paramContext == null)
    {
      AssertUtils.fail("Need the context to get thumbnail!", new Object[0]);
      return null;
    }
    if ((paramInt != 1) && (paramInt != 3))
    {
      AssertUtils.fail("kind is illegal", new Object[0]);
      return null;
    }
    return MediaStore.Images.Thumbnails.getThumbnail(paramContext.getContentResolver(), this.jdField_a_of_type_Long, paramInt, paramOptions);
  }
  
  public SerializationPB.PicInfo a()
  {
    SerializationPB.PicInfo localPicInfo = new SerializationPB.PicInfo();
    localPicInfo.id.set(this.jdField_a_of_type_Long);
    PBStringField localPBStringField = localPicInfo.path;
    boolean bool = TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString);
    String str2 = "";
    String str1;
    if (bool) {
      str1 = "";
    } else {
      str1 = this.jdField_a_of_type_JavaLangString;
    }
    localPBStringField.set(str1);
    localPBStringField = localPicInfo.thumb;
    if (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {
      str1 = str2;
    } else {
      str1 = this.jdField_b_of_type_JavaLangString;
    }
    localPBStringField.set(str1);
    localPicInfo.width.set(this.jdField_a_of_type_Int);
    localPicInfo.height.set(this.jdField_b_of_type_Int);
    localPicInfo.orientation.set(this.jdField_c_of_type_Int);
    localPicInfo.create_time.set(this.jdField_b_of_type_Long);
    localPicInfo.lat.set(this.jdField_a_of_type_Double);
    localPicInfo.lng.set(this.jdField_b_of_type_Double);
    localPicInfo.geo_hash.set(this.jdField_c_of_type_JavaLangString);
    localPicInfo.state.set(this.jdField_d_of_type_Int);
    localPicInfo.mime.set(this.jdField_d_of_type_JavaLangString);
    localPicInfo.size.set(this.e);
    localPicInfo.db_create_time.set(this.jdField_d_of_type_Long);
    return localPicInfo;
  }
  
  public StoryAlbumPicEntry a()
  {
    StoryAlbumPicEntry localStoryAlbumPicEntry = new StoryAlbumPicEntry();
    localStoryAlbumPicEntry.path = this.jdField_a_of_type_JavaLangString;
    localStoryAlbumPicEntry.thumbPath = this.jdField_b_of_type_JavaLangString;
    localStoryAlbumPicEntry.width = this.jdField_a_of_type_Int;
    localStoryAlbumPicEntry.height = this.jdField_b_of_type_Int;
    localStoryAlbumPicEntry.orientation = this.jdField_c_of_type_Int;
    localStoryAlbumPicEntry.createTime = this.jdField_b_of_type_Long;
    localStoryAlbumPicEntry.gpsLat = this.jdField_a_of_type_Double;
    localStoryAlbumPicEntry.gpsLng = this.jdField_b_of_type_Double;
    localStoryAlbumPicEntry.geohashString = this.jdField_c_of_type_JavaLangString;
    localStoryAlbumPicEntry.state = this.jdField_d_of_type_Int;
    localStoryAlbumPicEntry.mime = this.jdField_d_of_type_JavaLangString;
    localStoryAlbumPicEntry.size = this.e;
    return localStoryAlbumPicEntry;
  }
  
  public LocalMediaInfo a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo = new LocalMediaInfo();
      LocalMediaInfo localLocalMediaInfo = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo;
      localLocalMediaInfo._id = this.jdField_a_of_type_Long;
      localLocalMediaInfo.path = this.jdField_a_of_type_JavaLangString;
      localLocalMediaInfo.orientation = this.jdField_c_of_type_Int;
      localLocalMediaInfo.mediaWidth = this.jdField_a_of_type_Int;
      localLocalMediaInfo.mediaHeight = this.jdField_b_of_type_Int;
      localLocalMediaInfo.mMimeType = this.jdField_d_of_type_JavaLangString;
      localLocalMediaInfo.fileSize = this.e;
      int i = AlbumThumbDownloader.THUMB_WIDHT;
      localLocalMediaInfo.thumbHeight = i;
      localLocalMediaInfo.thumbWidth = i;
    }
    return this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo;
  }
  
  public void a(SerializationPB.PicInfo paramPicInfo)
  {
    this.jdField_a_of_type_Long = paramPicInfo.id.get();
    this.jdField_a_of_type_JavaLangString = paramPicInfo.path.get();
    this.jdField_b_of_type_JavaLangString = paramPicInfo.thumb.get();
    this.jdField_a_of_type_Int = paramPicInfo.width.get();
    this.jdField_b_of_type_Int = paramPicInfo.height.get();
    this.jdField_c_of_type_Int = paramPicInfo.orientation.get();
    this.jdField_b_of_type_Long = paramPicInfo.create_time.get();
    this.jdField_a_of_type_Double = paramPicInfo.lat.get();
    this.jdField_b_of_type_Double = paramPicInfo.lng.get();
    this.jdField_c_of_type_JavaLangString = paramPicInfo.geo_hash.get();
    this.jdField_d_of_type_Int = paramPicInfo.state.get();
    this.jdField_d_of_type_JavaLangString = paramPicInfo.mime.get();
    this.e = paramPicInfo.size.get();
    this.jdField_d_of_type_Long = paramPicInfo.db_create_time.get();
  }
  
  public void a(boolean paramBoolean)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public boolean a()
  {
    return this.jdField_d_of_type_Int == 1;
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject instanceof PicInfo)) {
      return this.jdField_a_of_type_JavaLangString.equals(((PicInfo)paramObject).jdField_a_of_type_JavaLangString);
    }
    return false;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("PicInfo=[");
    localStringBuilder.append(" mId:");
    localStringBuilder.append(this.jdField_a_of_type_Long);
    localStringBuilder.append(" mPath:");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append(" mThumbPath:");
    localStringBuilder.append(this.jdField_b_of_type_JavaLangString);
    localStringBuilder.append(" width:");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append(" height:");
    localStringBuilder.append(this.jdField_b_of_type_Int);
    localStringBuilder.append(" orientation:");
    localStringBuilder.append(this.jdField_c_of_type_Int);
    localStringBuilder.append(" mCreateTime:");
    localStringBuilder.append(this.jdField_b_of_type_Long);
    localStringBuilder.append(" mDBCreateTime:");
    localStringBuilder.append(this.jdField_d_of_type_Long);
    localStringBuilder.append(" mGpsLat:");
    localStringBuilder.append(this.jdField_a_of_type_Double);
    localStringBuilder.append(" mGpsLng:");
    localStringBuilder.append(this.jdField_b_of_type_Double);
    localStringBuilder.append(" mGeohashString:");
    localStringBuilder.append(this.jdField_c_of_type_JavaLangString);
    localStringBuilder.append(" mState:");
    localStringBuilder.append(this.jdField_d_of_type_Int);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.album.model.StoryAlbum.PicInfo
 * JD-Core Version:    0.7.0.1
 */