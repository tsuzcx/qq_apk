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
  public static final DateFormat a;
  public int a;
  private long a;
  public String a;
  public List<String> a;
  public int b;
  private long jdField_b_of_type_Long;
  public String b;
  private List<StoryAlbum.PicInfo> jdField_b_of_type_JavaUtilList = new ArrayList();
  public int c;
  private long c;
  public String c;
  public int d;
  public String d;
  public int e;
  private String e;
  private int f;
  
  static
  {
    jdField_a_of_type_JavaTextDateFormat = new SimpleDateFormat("yyyy年M月d日");
  }
  
  @Deprecated
  public StoryAlbum(int paramInt)
  {
    this.jdField_a_of_type_Long = -1L;
    this.jdField_c_of_type_Int = 6;
    this.jdField_d_of_type_Int = 0;
    this.jdField_e_of_type_Int = 0;
    this.jdField_e_of_type_JavaLangString = "new";
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public StoryAlbum(int paramInt, List<StoryAlbum.PicInfo> paramList)
  {
    this.jdField_a_of_type_Long = -1L;
    this.jdField_c_of_type_Int = 6;
    this.jdField_d_of_type_Int = 0;
    this.jdField_e_of_type_Int = 0;
    this.jdField_e_of_type_JavaLangString = "new";
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      b(paramList);
      this.jdField_b_of_type_JavaUtilList.addAll(paramList);
    }
    else
    {
      AssertUtils.fail("It not allowed to new the story album by null picList", new Object[0]);
    }
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public static StoryAlbum a(StoryAlbumEntry paramStoryAlbumEntry)
  {
    StoryAlbum localStoryAlbum = new StoryAlbum(paramStoryAlbumEntry.albumType);
    localStoryAlbum.jdField_b_of_type_Long = paramStoryAlbumEntry.startTime;
    localStoryAlbum.jdField_c_of_type_Long = paramStoryAlbumEntry.endTime;
    localStoryAlbum.jdField_b_of_type_JavaLangString = paramStoryAlbumEntry.albumName;
    localStoryAlbum.jdField_a_of_type_JavaLangString = paramStoryAlbumEntry.transId;
    localStoryAlbum.jdField_b_of_type_Int = paramStoryAlbumEntry.textId;
    localStoryAlbum.jdField_c_of_type_JavaLangString = paramStoryAlbumEntry.albumDesc;
    localStoryAlbum.jdField_d_of_type_JavaLangString = paramStoryAlbumEntry.geoHashStr;
    localStoryAlbum.f = paramStoryAlbumEntry.state;
    localStoryAlbum.jdField_c_of_type_Int = paramStoryAlbumEntry.minCount;
    localStoryAlbum.jdField_e_of_type_JavaLangString = paramStoryAlbumEntry.debugInfo;
    localStoryAlbum.jdField_a_of_type_Long = paramStoryAlbumEntry.getId();
    localStoryAlbum.a(paramStoryAlbumEntry.extraInfo);
    return localStoryAlbum;
  }
  
  private void a(byte[] paramArrayOfByte)
  {
    Object localObject = new SerializationPB.StoryAlbum();
    ((SerializationPB.StoryAlbum)localObject).mergeFrom(paramArrayOfByte);
    this.jdField_a_of_type_JavaUtilList = ((SerializationPB.StoryAlbum)localObject).geo_hash_list.get();
    paramArrayOfByte = ((SerializationPB.StoryAlbum)localObject).pic_list.get();
    localObject = new ArrayList();
    int i = 0;
    while (i < paramArrayOfByte.size())
    {
      StoryAlbum.PicInfo localPicInfo = new StoryAlbum.PicInfo();
      localPicInfo.a((SerializationPB.PicInfo)paramArrayOfByte.get(i));
      ((List)localObject).add(localPicInfo);
      i += 1;
    }
    this.jdField_b_of_type_JavaUtilList = ((List)localObject);
  }
  
  private boolean a(String paramString1, String paramString2)
  {
    return TextUtils.equals(paramString1.substring(0, paramString1.indexOf(HardCodeUtil.a(2131720489))), paramString2.substring(0, paramString2.indexOf(HardCodeUtil.a(2131720489))));
  }
  
  private byte[] a()
  {
    SerializationPB.StoryAlbum localStoryAlbum = new SerializationPB.StoryAlbum();
    Object localObject = this.jdField_a_of_type_JavaUtilList;
    if ((localObject != null) && (!((List)localObject).isEmpty())) {
      localStoryAlbum.geo_hash_list.set(this.jdField_a_of_type_JavaUtilList);
    }
    localObject = this.jdField_b_of_type_JavaUtilList;
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      localObject = new ArrayList();
      int i = 0;
      while (i < this.jdField_b_of_type_JavaUtilList.size())
      {
        ((List)localObject).add(((StoryAlbum.PicInfo)this.jdField_b_of_type_JavaUtilList.get(i)).a());
        i += 1;
      }
      localStoryAlbum.pic_list.set((List)localObject);
    }
    return localStoryAlbum.toByteArray();
  }
  
  public static void b(@NonNull List<StoryAlbum.PicInfo> paramList)
  {
    Collections.sort(paramList, new StoryAlbum.1());
  }
  
  public int a()
  {
    return this.f;
  }
  
  public long a()
  {
    return this.jdField_b_of_type_Long;
  }
  
  public StoryAlbumEntry a()
  {
    StoryAlbumEntry localStoryAlbumEntry = new StoryAlbumEntry();
    localStoryAlbumEntry.albumType = this.jdField_a_of_type_Int;
    localStoryAlbumEntry.startTime = e();
    localStoryAlbumEntry.endTime = f();
    localStoryAlbumEntry.albumName = this.jdField_b_of_type_JavaLangString;
    localStoryAlbumEntry.transId = this.jdField_a_of_type_JavaLangString;
    localStoryAlbumEntry.textId = this.jdField_b_of_type_Int;
    localStoryAlbumEntry.albumDesc = this.jdField_c_of_type_JavaLangString;
    localStoryAlbumEntry.geoHashStr = this.jdField_d_of_type_JavaLangString;
    localStoryAlbumEntry.state = this.f;
    localStoryAlbumEntry.minCount = this.jdField_c_of_type_Int;
    localStoryAlbumEntry.debugInfo = this.jdField_e_of_type_JavaLangString;
    localStoryAlbumEntry.extraInfo = a();
    long l = this.jdField_a_of_type_Long;
    if (l >= 0L) {
      localStoryAlbumEntry.setId(l);
    }
    return localStoryAlbumEntry;
  }
  
  public String a()
  {
    Object localObject1 = this.jdField_b_of_type_JavaUtilList;
    if ((localObject1 != null) && (!((List)localObject1).isEmpty()))
    {
      long l2 = ((StoryAlbum.PicInfo)this.jdField_b_of_type_JavaUtilList.get(0)).jdField_b_of_type_Long;
      localObject1 = this.jdField_b_of_type_JavaUtilList;
      long l1 = ((StoryAlbum.PicInfo)((List)localObject1).get(((List)localObject1).size() - 1)).jdField_b_of_type_Long;
      l2 *= 1000L;
      localObject1 = new Date(l2);
      Object localObject2 = jdField_a_of_type_JavaTextDateFormat.format((Date)localObject1);
      localObject1 = new Date(l1 * 1000L);
      String str = jdField_a_of_type_JavaTextDateFormat.format((Date)localObject1);
      boolean bool = DateUtils.a(l2);
      if (bool) {
        localObject1 = ((String)localObject2).substring(((String)localObject2).indexOf(HardCodeUtil.a(2131720489)) + 1);
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
      if (TextUtils.equals(((String)localObject2).substring(0, ((String)localObject2).indexOf(HardCodeUtil.a(2131694201))), str.substring(0, str.indexOf(HardCodeUtil.a(2131694201)))))
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append("-");
        ((StringBuilder)localObject2).append(str.substring(str.indexOf(HardCodeUtil.a(2131694201)) + 1));
        return ((StringBuilder)localObject2).toString();
      }
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append("-");
      ((StringBuilder)localObject2).append(str.substring(str.indexOf(HardCodeUtil.a(2131720489)) + 1));
      return ((StringBuilder)localObject2).toString();
    }
    return "";
  }
  
  public String a(int paramInt)
  {
    if (TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)) {
      return "";
    }
    String str = this.jdField_c_of_type_JavaLangString.replace("[$album_name]", this.jdField_b_of_type_JavaLangString);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramInt);
    localStringBuilder.append("");
    return str.replace("[$select_count]", localStringBuilder.toString());
  }
  
  public List<StoryAlbum.PicInfo> a()
  {
    return Collections.unmodifiableList(new ArrayList(this.jdField_b_of_type_JavaUtilList));
  }
  
  public void a(long paramLong)
  {
    this.jdField_a_of_type_Long = paramLong;
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    this.jdField_b_of_type_Long = paramLong1;
    this.jdField_c_of_type_Long = paramLong2;
  }
  
  public void a(StoryAlbum paramStoryAlbum)
  {
    a(paramStoryAlbum.a(), paramStoryAlbum.b());
    if (!TextUtils.isEmpty(paramStoryAlbum.jdField_d_of_type_JavaLangString)) {
      this.jdField_d_of_type_JavaLangString = paramStoryAlbum.jdField_d_of_type_JavaLangString;
    }
    paramStoryAlbum = paramStoryAlbum.jdField_a_of_type_JavaUtilList;
    if (paramStoryAlbum != null) {
      this.jdField_a_of_type_JavaUtilList = paramStoryAlbum;
    }
  }
  
  public void a(BaseSplitConfig paramBaseSplitConfig)
  {
    if (paramBaseSplitConfig != null)
    {
      if ((paramBaseSplitConfig.jdField_a_of_type_JavaUtilList != null) && (paramBaseSplitConfig.jdField_a_of_type_JavaUtilList.size() > 0))
      {
        int i = new Random().nextInt(paramBaseSplitConfig.jdField_a_of_type_JavaUtilList.size());
        this.jdField_a_of_type_JavaLangString = ((String)paramBaseSplitConfig.jdField_a_of_type_JavaUtilList.get(i));
      }
      else
      {
        this.jdField_a_of_type_JavaLangString = paramBaseSplitConfig.jdField_b_of_type_JavaLangString;
      }
      this.jdField_c_of_type_JavaLangString = paramBaseSplitConfig.jdField_a_of_type_JavaLangString;
      this.jdField_c_of_type_Int = paramBaseSplitConfig.jdField_b_of_type_Int;
      this.jdField_b_of_type_Int = paramBaseSplitConfig.jdField_c_of_type_Int;
    }
  }
  
  public void a(String paramString)
  {
    this.jdField_e_of_type_JavaLangString = paramString;
  }
  
  public void a(List<StoryAlbum.PicInfo> paramList)
  {
    this.jdField_b_of_type_JavaUtilList.clear();
    this.jdField_b_of_type_JavaUtilList.addAll(paramList);
    b(this.jdField_b_of_type_JavaUtilList);
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Int == -1;
  }
  
  public int b()
  {
    return this.jdField_b_of_type_JavaUtilList.size();
  }
  
  public long b()
  {
    return this.jdField_c_of_type_Long;
  }
  
  public void b(StoryAlbum paramStoryAlbum)
  {
    AssertUtils.checkNotNull(paramStoryAlbum);
    SLog.a("Q.qqstory.recommendAlbum.logic.StoryAlbum", "%s merge album %s", this, paramStoryAlbum);
    this.f = 0;
    paramStoryAlbum = paramStoryAlbum.jdField_b_of_type_JavaUtilList.iterator();
    while (paramStoryAlbum.hasNext())
    {
      StoryAlbum.PicInfo localPicInfo = (StoryAlbum.PicInfo)paramStoryAlbum.next();
      if (!this.jdField_b_of_type_JavaUtilList.contains(localPicInfo)) {
        this.jdField_b_of_type_JavaUtilList.add(localPicInfo);
      }
    }
    b(this.jdField_b_of_type_JavaUtilList);
  }
  
  public boolean b()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.jdField_b_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      StoryAlbum.PicInfo localPicInfo = (StoryAlbum.PicInfo)localIterator.next();
      if (new File(localPicInfo.jdField_a_of_type_JavaLangString).exists()) {
        localArrayList.add(localPicInfo);
      }
    }
    this.jdField_b_of_type_JavaUtilList = localArrayList;
    return localArrayList.size() >= 4;
  }
  
  public int c()
  {
    int j = this.jdField_a_of_type_Int;
    int i = 1;
    if (j != 1)
    {
      i = 3;
      if (j != 2)
      {
        if (j != 3)
        {
          if (j != 4)
          {
            if (j != 6) {
              return 0;
            }
            return 2;
          }
          return 4;
        }
        return 5;
      }
    }
    return i;
  }
  
  public long c()
  {
    List localList = this.jdField_b_of_type_JavaUtilList;
    if ((localList != null) && (!localList.isEmpty())) {
      return ((StoryAlbum.PicInfo)this.jdField_b_of_type_JavaUtilList.get(0)).jdField_b_of_type_Long;
    }
    return 0L;
  }
  
  public long d()
  {
    List localList = this.jdField_b_of_type_JavaUtilList;
    if ((localList != null) && (!localList.isEmpty()))
    {
      localList = this.jdField_b_of_type_JavaUtilList;
      return ((StoryAlbum.PicInfo)localList.get(localList.size() - 1)).d;
    }
    return 0L;
  }
  
  public long e()
  {
    if (this.jdField_b_of_type_JavaUtilList.isEmpty()) {
      return -1L;
    }
    return ((StoryAlbum.PicInfo)this.jdField_b_of_type_JavaUtilList.get(0)).jdField_b_of_type_Long;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool4 = paramObject instanceof StoryAlbum;
    boolean bool3 = false;
    boolean bool2 = false;
    boolean bool1 = bool3;
    if (bool4)
    {
      if (a())
      {
        StoryAlbum localStoryAlbum = (StoryAlbum)paramObject;
        if (localStoryAlbum.a())
        {
          bool1 = bool2;
          if (this.jdField_d_of_type_Int == localStoryAlbum.jdField_d_of_type_Int) {
            bool1 = true;
          }
          return bool1;
        }
      }
      bool1 = bool3;
      if (this.jdField_a_of_type_Long == ((StoryAlbum)paramObject).jdField_a_of_type_Long) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public long f()
  {
    if (this.jdField_b_of_type_JavaUtilList.isEmpty()) {
      return -1L;
    }
    List localList = this.jdField_b_of_type_JavaUtilList;
    return ((StoryAlbum.PicInfo)localList.get(localList.size() - 1)).jdField_b_of_type_Long;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("StoryAlbum=[");
    localStringBuilder.append(" mId:");
    localStringBuilder.append(this.jdField_a_of_type_Long);
    localStringBuilder.append(" ;isHomeAlbum:");
    boolean bool;
    if (this.jdField_a_of_type_Int == 2) {
      bool = true;
    } else {
      bool = false;
    }
    localStringBuilder.append(bool);
    localStringBuilder.append(" ;mAlbumType:");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append(" ;mAlbumName:");
    localStringBuilder.append(this.jdField_b_of_type_JavaLangString);
    localStringBuilder.append(" ;mAlbumTime:");
    localStringBuilder.append(a());
    localStringBuilder.append(" ;StartTime:");
    localStringBuilder.append(e());
    localStringBuilder.append(" ;EndTime:");
    localStringBuilder.append(f());
    localStringBuilder.append(" ;mUIAlbumType:");
    localStringBuilder.append(this.jdField_d_of_type_Int);
    localStringBuilder.append(" ;mTransId:");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append(" ;mTextId:");
    localStringBuilder.append(this.jdField_b_of_type_Int);
    localStringBuilder.append(" ;count:");
    localStringBuilder.append(this.jdField_b_of_type_JavaUtilList.size());
    localStringBuilder.append(" ;mAlbumDesc:");
    localStringBuilder.append(this.jdField_c_of_type_JavaLangString);
    localStringBuilder.append(" ;kmeansTime1:");
    localStringBuilder.append(this.jdField_b_of_type_Long);
    localStringBuilder.append(" ;kmeansTime2:");
    localStringBuilder.append(this.jdField_c_of_type_Long);
    localStringBuilder.append(" ;mGeoHashHead:");
    localStringBuilder.append(this.jdField_d_of_type_JavaLangString);
    localStringBuilder.append(" ;mGeoHashStringList:");
    localStringBuilder.append(this.jdField_a_of_type_JavaUtilList);
    localStringBuilder.append(" ;debugInfo:");
    localStringBuilder.append(this.jdField_e_of_type_JavaLangString);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.album.model.StoryAlbum
 * JD-Core Version:    0.7.0.1
 */