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
  public long a;
  public String b;
  @Deprecated
  public String c;
  public int d;
  public int e;
  public int f;
  public long g;
  public long h;
  public long i;
  public double j;
  public double k;
  public String l;
  public long m;
  public String n;
  public AddressItem o;
  private int p;
  private LocalMediaInfo q;
  
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
    return MediaStore.Images.Thumbnails.getThumbnail(paramContext.getContentResolver(), this.a, paramInt, paramOptions);
  }
  
  public void a(SerializationPB.PicInfo paramPicInfo)
  {
    this.a = paramPicInfo.id.get();
    this.b = paramPicInfo.path.get();
    this.c = paramPicInfo.thumb.get();
    this.d = paramPicInfo.width.get();
    this.e = paramPicInfo.height.get();
    this.f = paramPicInfo.orientation.get();
    this.g = paramPicInfo.create_time.get();
    this.j = paramPicInfo.lat.get();
    this.k = paramPicInfo.lng.get();
    this.l = paramPicInfo.geo_hash.get();
    this.p = paramPicInfo.state.get();
    this.n = paramPicInfo.mime.get();
    this.m = paramPicInfo.size.get();
    this.i = paramPicInfo.db_create_time.get();
  }
  
  public void a(boolean paramBoolean)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public boolean a()
  {
    return this.p == 1;
  }
  
  public StoryAlbumPicEntry b()
  {
    StoryAlbumPicEntry localStoryAlbumPicEntry = new StoryAlbumPicEntry();
    localStoryAlbumPicEntry.path = this.b;
    localStoryAlbumPicEntry.thumbPath = this.c;
    localStoryAlbumPicEntry.width = this.d;
    localStoryAlbumPicEntry.height = this.e;
    localStoryAlbumPicEntry.orientation = this.f;
    localStoryAlbumPicEntry.createTime = this.g;
    localStoryAlbumPicEntry.gpsLat = this.j;
    localStoryAlbumPicEntry.gpsLng = this.k;
    localStoryAlbumPicEntry.geohashString = this.l;
    localStoryAlbumPicEntry.state = this.p;
    localStoryAlbumPicEntry.mime = this.n;
    localStoryAlbumPicEntry.size = this.m;
    return localStoryAlbumPicEntry;
  }
  
  public SerializationPB.PicInfo c()
  {
    SerializationPB.PicInfo localPicInfo = new SerializationPB.PicInfo();
    localPicInfo.id.set(this.a);
    PBStringField localPBStringField = localPicInfo.path;
    boolean bool = TextUtils.isEmpty(this.b);
    String str2 = "";
    String str1;
    if (bool) {
      str1 = "";
    } else {
      str1 = this.b;
    }
    localPBStringField.set(str1);
    localPBStringField = localPicInfo.thumb;
    if (TextUtils.isEmpty(this.c)) {
      str1 = str2;
    } else {
      str1 = this.c;
    }
    localPBStringField.set(str1);
    localPicInfo.width.set(this.d);
    localPicInfo.height.set(this.e);
    localPicInfo.orientation.set(this.f);
    localPicInfo.create_time.set(this.g);
    localPicInfo.lat.set(this.j);
    localPicInfo.lng.set(this.k);
    localPicInfo.geo_hash.set(this.l);
    localPicInfo.state.set(this.p);
    localPicInfo.mime.set(this.n);
    localPicInfo.size.set(this.m);
    localPicInfo.db_create_time.set(this.i);
    return localPicInfo;
  }
  
  public LocalMediaInfo d()
  {
    if (this.q == null)
    {
      this.q = new LocalMediaInfo();
      LocalMediaInfo localLocalMediaInfo = this.q;
      localLocalMediaInfo._id = this.a;
      localLocalMediaInfo.path = this.b;
      localLocalMediaInfo.orientation = this.f;
      localLocalMediaInfo.mediaWidth = this.d;
      localLocalMediaInfo.mediaHeight = this.e;
      localLocalMediaInfo.mMimeType = this.n;
      localLocalMediaInfo.fileSize = this.m;
      int i1 = AlbumThumbDownloader.THUMB_WIDHT;
      localLocalMediaInfo.thumbHeight = i1;
      localLocalMediaInfo.thumbWidth = i1;
    }
    return this.q;
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject instanceof PicInfo)) {
      return this.b.equals(((PicInfo)paramObject).b);
    }
    return false;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("PicInfo=[");
    localStringBuilder.append(" mId:");
    localStringBuilder.append(this.a);
    localStringBuilder.append(" mPath:");
    localStringBuilder.append(this.b);
    localStringBuilder.append(" mThumbPath:");
    localStringBuilder.append(this.c);
    localStringBuilder.append(" width:");
    localStringBuilder.append(this.d);
    localStringBuilder.append(" height:");
    localStringBuilder.append(this.e);
    localStringBuilder.append(" orientation:");
    localStringBuilder.append(this.f);
    localStringBuilder.append(" mCreateTime:");
    localStringBuilder.append(this.g);
    localStringBuilder.append(" mDBCreateTime:");
    localStringBuilder.append(this.i);
    localStringBuilder.append(" mGpsLat:");
    localStringBuilder.append(this.j);
    localStringBuilder.append(" mGpsLng:");
    localStringBuilder.append(this.k);
    localStringBuilder.append(" mGeohashString:");
    localStringBuilder.append(this.l);
    localStringBuilder.append(" mState:");
    localStringBuilder.append(this.p);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.album.model.StoryAlbum.PicInfo
 * JD-Core Version:    0.7.0.1
 */