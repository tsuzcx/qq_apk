package com.tencent.biz.qqstory.album.model;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.album.model.strategy.BaseSplitConfig;
import com.tencent.biz.qqstory.base.SerializationPB.PicInfo;
import com.tencent.biz.qqstory.base.SerializationPB.StoryAlbum;
import com.tencent.biz.qqstory.database.StoryAlbumEntry;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.utils.AssertUtils;
import com.tencent.biz.qqstory.utils.DateUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class StoryAlbum
{
  public static final DateFormat a = new SimpleDateFormat("yyyy年M月d日");
  public int b;
  public String c;
  public int d;
  public int e = 6;
  public String f;
  public String g;
  public int h = 0;
  public String i;
  public List<String> j;
  public int k = 0;
  private long l = -1L;
  private List<StoryAlbum.PicInfo> m = new ArrayList();
  private int n;
  private long o;
  private long p;
  private String q = "new";
  
  @Deprecated
  public StoryAlbum(int paramInt)
  {
    this.b = paramInt;
  }
  
  public StoryAlbum(int paramInt, List<StoryAlbum.PicInfo> paramList)
  {
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      b(paramList);
      this.m.addAll(paramList);
    }
    else
    {
      AssertUtils.fail("It not allowed to new the story album by null picList", new Object[0]);
    }
    this.b = paramInt;
  }
  
  public static StoryAlbum a(StoryAlbumEntry paramStoryAlbumEntry)
  {
    StoryAlbum localStoryAlbum = new StoryAlbum(paramStoryAlbumEntry.albumType);
    localStoryAlbum.o = paramStoryAlbumEntry.startTime;
    localStoryAlbum.p = paramStoryAlbumEntry.endTime;
    localStoryAlbum.f = paramStoryAlbumEntry.albumName;
    localStoryAlbum.c = paramStoryAlbumEntry.transId;
    localStoryAlbum.d = paramStoryAlbumEntry.textId;
    localStoryAlbum.g = paramStoryAlbumEntry.albumDesc;
    localStoryAlbum.i = paramStoryAlbumEntry.geoHashStr;
    localStoryAlbum.n = paramStoryAlbumEntry.state;
    localStoryAlbum.e = paramStoryAlbumEntry.minCount;
    localStoryAlbum.q = paramStoryAlbumEntry.debugInfo;
    localStoryAlbum.l = paramStoryAlbumEntry.getId();
    localStoryAlbum.a(paramStoryAlbumEntry.extraInfo);
    return localStoryAlbum;
  }
  
  private void a(byte[] paramArrayOfByte)
  {
    Object localObject = new SerializationPB.StoryAlbum();
    ((SerializationPB.StoryAlbum)localObject).mergeFrom(paramArrayOfByte);
    this.j = ((SerializationPB.StoryAlbum)localObject).geo_hash_list.get();
    paramArrayOfByte = ((SerializationPB.StoryAlbum)localObject).pic_list.get();
    localObject = new ArrayList();
    int i1 = 0;
    while (i1 < paramArrayOfByte.size())
    {
      StoryAlbum.PicInfo localPicInfo = new StoryAlbum.PicInfo();
      localPicInfo.a((SerializationPB.PicInfo)paramArrayOfByte.get(i1));
      ((List)localObject).add(localPicInfo);
      i1 += 1;
    }
    this.m = ((List)localObject);
  }
  
  private boolean a(String paramString1, String paramString2)
  {
    return TextUtils.equals(paramString1.substring(0, paramString1.indexOf(HardCodeUtil.a(2131918206))), paramString2.substring(0, paramString2.indexOf(HardCodeUtil.a(2131918206))));
  }
  
  public static void b(@NonNull List<StoryAlbum.PicInfo> paramList)
  {
    Collections.sort(paramList, new StoryAlbum.1());
  }
  
  private byte[] o()
  {
    SerializationPB.StoryAlbum localStoryAlbum = new SerializationPB.StoryAlbum();
    Object localObject = this.j;
    if ((localObject != null) && (!((List)localObject).isEmpty())) {
      localStoryAlbum.geo_hash_list.set(this.j);
    }
    localObject = this.m;
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      localObject = new ArrayList();
      int i1 = 0;
      while (i1 < this.m.size())
      {
        ((List)localObject).add(((StoryAlbum.PicInfo)this.m.get(i1)).c());
        i1 += 1;
      }
      localStoryAlbum.pic_list.set((List)localObject);
    }
    return localStoryAlbum.toByteArray();
  }
  
  public String a(int paramInt)
  {
    if (TextUtils.isEmpty(this.g)) {
      return "";
    }
    String str = this.g.replace("[$album_name]", this.f);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramInt);
    localStringBuilder.append("");
    return str.replace("[$select_count]", localStringBuilder.toString());
  }
  
  public List<StoryAlbum.PicInfo> a()
  {
    return Collections.unmodifiableList(new ArrayList(this.m));
  }
  
  public void a(long paramLong)
  {
    this.l = paramLong;
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    this.o = paramLong1;
    this.p = paramLong2;
  }
  
  public void a(StoryAlbum paramStoryAlbum)
  {
    a(paramStoryAlbum.f(), paramStoryAlbum.g());
    if (!TextUtils.isEmpty(paramStoryAlbum.i)) {
      this.i = paramStoryAlbum.i;
    }
    paramStoryAlbum = paramStoryAlbum.j;
    if (paramStoryAlbum != null) {
      this.j = paramStoryAlbum;
    }
  }
  
  public void a(BaseSplitConfig paramBaseSplitConfig)
  {
    if (paramBaseSplitConfig != null)
    {
      if ((paramBaseSplitConfig.f != null) && (paramBaseSplitConfig.f.size() > 0))
      {
        int i1 = new Random().nextInt(paramBaseSplitConfig.f.size());
        this.c = ((String)paramBaseSplitConfig.f.get(i1));
      }
      else
      {
        this.c = paramBaseSplitConfig.d;
      }
      this.g = paramBaseSplitConfig.c;
      this.e = paramBaseSplitConfig.b;
      this.d = paramBaseSplitConfig.e;
    }
  }
  
  public void a(String paramString)
  {
    this.q = paramString;
  }
  
  public void a(List<StoryAlbum.PicInfo> paramList)
  {
    this.m.clear();
    this.m.addAll(paramList);
    b(this.m);
  }
  
  public int b()
  {
    return this.n;
  }
  
  public void b(StoryAlbum paramStoryAlbum)
  {
    AssertUtils.checkNotNull(paramStoryAlbum);
    SLog.a("Q.qqstory.recommendAlbum.logic.StoryAlbum", "%s merge album %s", this, paramStoryAlbum);
    this.n = 0;
    paramStoryAlbum = paramStoryAlbum.m.iterator();
    while (paramStoryAlbum.hasNext())
    {
      StoryAlbum.PicInfo localPicInfo = (StoryAlbum.PicInfo)paramStoryAlbum.next();
      if (!this.m.contains(localPicInfo)) {
        this.m.add(localPicInfo);
      }
    }
    b(this.m);
  }
  
  public int c()
  {
    return this.m.size();
  }
  
  public boolean d()
  {
    return this.b == -1;
  }
  
  public StoryAlbumEntry e()
  {
    StoryAlbumEntry localStoryAlbumEntry = new StoryAlbumEntry();
    localStoryAlbumEntry.albumType = this.b;
    localStoryAlbumEntry.startTime = l();
    localStoryAlbumEntry.endTime = m();
    localStoryAlbumEntry.albumName = this.f;
    localStoryAlbumEntry.transId = this.c;
    localStoryAlbumEntry.textId = this.d;
    localStoryAlbumEntry.albumDesc = this.g;
    localStoryAlbumEntry.geoHashStr = this.i;
    localStoryAlbumEntry.state = this.n;
    localStoryAlbumEntry.minCount = this.e;
    localStoryAlbumEntry.debugInfo = this.q;
    localStoryAlbumEntry.extraInfo = o();
    long l1 = this.l;
    if (l1 >= 0L) {
      localStoryAlbumEntry.setId(l1);
    }
    return localStoryAlbumEntry;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool4 = paramObject instanceof StoryAlbum;
    boolean bool3 = false;
    boolean bool2 = false;
    boolean bool1 = bool3;
    if (bool4)
    {
      if (d())
      {
        StoryAlbum localStoryAlbum = (StoryAlbum)paramObject;
        if (localStoryAlbum.d())
        {
          bool1 = bool2;
          if (this.h == localStoryAlbum.h) {
            bool1 = true;
          }
          return bool1;
        }
      }
      bool1 = bool3;
      if (this.l == ((StoryAlbum)paramObject).l) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public long f()
  {
    return this.o;
  }
  
  public long g()
  {
    return this.p;
  }
  
  public long h()
  {
    List localList = this.m;
    if ((localList != null) && (!localList.isEmpty())) {
      return ((StoryAlbum.PicInfo)this.m.get(0)).g;
    }
    return 0L;
  }
  
  public long i()
  {
    List localList = this.m;
    if ((localList != null) && (!localList.isEmpty()))
    {
      localList = this.m;
      return ((StoryAlbum.PicInfo)localList.get(localList.size() - 1)).i;
    }
    return 0L;
  }
  
  public String j()
  {
    Object localObject1 = this.m;
    if ((localObject1 != null) && (!((List)localObject1).isEmpty()))
    {
      long l2 = ((StoryAlbum.PicInfo)this.m.get(0)).g;
      localObject1 = this.m;
      long l1 = ((StoryAlbum.PicInfo)((List)localObject1).get(((List)localObject1).size() - 1)).g;
      l2 *= 1000L;
      localObject1 = new Date(l2);
      Object localObject2 = a.format((Date)localObject1);
      localObject1 = new Date(l1 * 1000L);
      String str = a.format((Date)localObject1);
      boolean bool = DateUtils.f(l2);
      if (bool) {
        localObject1 = ((String)localObject2).substring(((String)localObject2).indexOf(HardCodeUtil.a(2131918206)) + 1);
      } else {
        localObject1 = localObject2;
      }
      if (TextUtils.equals((CharSequence)localObject2, str)) {
        return localObject1;
      }
      if ((!bool) && (!a((String)localObject2, str)))
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append("-");
        ((StringBuilder)localObject2).append(str);
        return ((StringBuilder)localObject2).toString();
      }
      if (TextUtils.equals(((String)localObject2).substring(0, ((String)localObject2).indexOf(HardCodeUtil.a(2131891839))), str.substring(0, str.indexOf(HardCodeUtil.a(2131891839)))))
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append("-");
        ((StringBuilder)localObject2).append(str.substring(str.indexOf(HardCodeUtil.a(2131891839)) + 1));
        return ((StringBuilder)localObject2).toString();
      }
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append("-");
      ((StringBuilder)localObject2).append(str.substring(str.indexOf(HardCodeUtil.a(2131918206)) + 1));
      return ((StringBuilder)localObject2).toString();
    }
    return "";
  }
  
  public boolean k()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.m.iterator();
    while (localIterator.hasNext())
    {
      StoryAlbum.PicInfo localPicInfo = (StoryAlbum.PicInfo)localIterator.next();
      if (new File(localPicInfo.b).exists()) {
        localArrayList.add(localPicInfo);
      }
    }
    this.m = localArrayList;
    return localArrayList.size() >= 4;
  }
  
  public long l()
  {
    if (this.m.isEmpty()) {
      return -1L;
    }
    return ((StoryAlbum.PicInfo)this.m.get(0)).g;
  }
  
  public long m()
  {
    if (this.m.isEmpty()) {
      return -1L;
    }
    List localList = this.m;
    return ((StoryAlbum.PicInfo)localList.get(localList.size() - 1)).g;
  }
  
  public int n()
  {
    int i2 = this.b;
    int i1 = 1;
    if (i2 != 1)
    {
      i1 = 3;
      if (i2 != 2)
      {
        if (i2 != 3)
        {
          if (i2 != 4)
          {
            if (i2 != 6) {
              return 0;
            }
            return 2;
          }
          return 4;
        }
        return 5;
      }
    }
    return i1;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("StoryAlbum=[");
    localStringBuilder.append(" mId:");
    localStringBuilder.append(this.l);
    localStringBuilder.append(" ;isHomeAlbum:");
    boolean bool;
    if (this.b == 2) {
      bool = true;
    } else {
      bool = false;
    }
    localStringBuilder.append(bool);
    localStringBuilder.append(" ;mAlbumType:");
    localStringBuilder.append(this.b);
    localStringBuilder.append(" ;mAlbumName:");
    localStringBuilder.append(this.f);
    localStringBuilder.append(" ;mAlbumTime:");
    localStringBuilder.append(j());
    localStringBuilder.append(" ;StartTime:");
    localStringBuilder.append(l());
    localStringBuilder.append(" ;EndTime:");
    localStringBuilder.append(m());
    localStringBuilder.append(" ;mUIAlbumType:");
    localStringBuilder.append(this.h);
    localStringBuilder.append(" ;mTransId:");
    localStringBuilder.append(this.c);
    localStringBuilder.append(" ;mTextId:");
    localStringBuilder.append(this.d);
    localStringBuilder.append(" ;count:");
    localStringBuilder.append(this.m.size());
    localStringBuilder.append(" ;mAlbumDesc:");
    localStringBuilder.append(this.g);
    localStringBuilder.append(" ;kmeansTime1:");
    localStringBuilder.append(this.o);
    localStringBuilder.append(" ;kmeansTime2:");
    localStringBuilder.append(this.p);
    localStringBuilder.append(" ;mGeoHashHead:");
    localStringBuilder.append(this.i);
    localStringBuilder.append(" ;mGeoHashStringList:");
    localStringBuilder.append(this.j);
    localStringBuilder.append(" ;debugInfo:");
    localStringBuilder.append(this.q);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.album.model.StoryAlbum
 * JD-Core Version:    0.7.0.1
 */