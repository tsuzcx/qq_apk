package com.tencent.biz.qqstory.album.model;

import android.text.TextUtils;
import com.tencent.biz.qqstory.album.StoryScanManager;
import com.tencent.biz.qqstory.album.segment.ScanInfo;
import com.tencent.biz.qqstory.album.strategy.SplitConfig.BaseSplitConfig;
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
    if ((paramList == null) || (paramList.isEmpty())) {
      AssertUtils.a("It not allowed to new the story album by null picList", new Object[0]);
    }
    for (;;)
    {
      this.jdField_a_of_type_Int = paramInt;
      return;
      StoryScanManager.b(paramList);
      this.jdField_b_of_type_JavaUtilList.addAll(paramList);
    }
  }
  
  public static StoryAlbum a(int paramInt)
  {
    StoryAlbum localStoryAlbum = new StoryAlbum(-1);
    localStoryAlbum.jdField_d_of_type_Int = paramInt;
    return localStoryAlbum;
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
    return TextUtils.equals(paramString1.substring(0, paramString1.indexOf(HardCodeUtil.a(2131714276))), paramString2.substring(0, paramString2.indexOf(HardCodeUtil.a(2131714273))));
  }
  
  private byte[] a()
  {
    SerializationPB.StoryAlbum localStoryAlbum = new SerializationPB.StoryAlbum();
    if ((this.jdField_a_of_type_JavaUtilList != null) && (!this.jdField_a_of_type_JavaUtilList.isEmpty())) {
      localStoryAlbum.geo_hash_list.set(this.jdField_a_of_type_JavaUtilList);
    }
    if ((this.jdField_b_of_type_JavaUtilList != null) && (this.jdField_b_of_type_JavaUtilList.size() > 0))
    {
      ArrayList localArrayList = new ArrayList();
      int i = 0;
      while (i < this.jdField_b_of_type_JavaUtilList.size())
      {
        localArrayList.add(((StoryAlbum.PicInfo)this.jdField_b_of_type_JavaUtilList.get(i)).a());
        i += 1;
      }
      localStoryAlbum.pic_list.set(localArrayList);
    }
    return localStoryAlbum.toByteArray();
  }
  
  public int a()
  {
    return this.f;
  }
  
  public long a()
  {
    return this.jdField_a_of_type_Long;
  }
  
  public StoryAlbumEntry a()
  {
    StoryAlbumEntry localStoryAlbumEntry = new StoryAlbumEntry();
    localStoryAlbumEntry.albumType = this.jdField_a_of_type_Int;
    localStoryAlbumEntry.startTime = f();
    localStoryAlbumEntry.endTime = g();
    localStoryAlbumEntry.albumName = this.jdField_b_of_type_JavaLangString;
    localStoryAlbumEntry.transId = this.jdField_a_of_type_JavaLangString;
    localStoryAlbumEntry.textId = this.jdField_b_of_type_Int;
    localStoryAlbumEntry.albumDesc = this.jdField_c_of_type_JavaLangString;
    localStoryAlbumEntry.geoHashStr = this.jdField_d_of_type_JavaLangString;
    localStoryAlbumEntry.state = this.f;
    localStoryAlbumEntry.minCount = this.jdField_c_of_type_Int;
    localStoryAlbumEntry.debugInfo = this.jdField_e_of_type_JavaLangString;
    localStoryAlbumEntry.extraInfo = a();
    if (this.jdField_a_of_type_Long >= 0L) {
      localStoryAlbumEntry.setId(this.jdField_a_of_type_Long);
    }
    return localStoryAlbumEntry;
  }
  
  public String a()
  {
    Object localObject2;
    if ((this.jdField_b_of_type_JavaUtilList == null) || (this.jdField_b_of_type_JavaUtilList.isEmpty()))
    {
      localObject2 = "";
      return localObject2;
    }
    long l1 = ((StoryAlbum.PicInfo)this.jdField_b_of_type_JavaUtilList.get(0)).jdField_b_of_type_Long;
    long l2 = ((StoryAlbum.PicInfo)this.jdField_b_of_type_JavaUtilList.get(this.jdField_b_of_type_JavaUtilList.size() - 1)).jdField_b_of_type_Long;
    Object localObject1 = new Date(l1 * 1000L);
    String str1 = jdField_a_of_type_JavaTextDateFormat.format((Date)localObject1);
    localObject1 = new Date(l2 * 1000L);
    String str2 = jdField_a_of_type_JavaTextDateFormat.format((Date)localObject1);
    boolean bool = DateUtils.a(l1 * 1000L);
    if (bool) {}
    for (localObject1 = str1.substring(str1.indexOf(HardCodeUtil.a(2131714270)) + 1);; localObject1 = str1)
    {
      localObject2 = localObject1;
      if (TextUtils.equals(str1, str2)) {
        break;
      }
      if ((!bool) && (!a(str1, str2))) {
        break label316;
      }
      if (!TextUtils.equals(str1.substring(0, str1.indexOf(HardCodeUtil.a(2131714272))), str2.substring(0, str2.indexOf(HardCodeUtil.a(2131714275))))) {
        break label273;
      }
      return (String)localObject1 + "-" + str2.substring(str2.indexOf(HardCodeUtil.a(2131714271)) + 1);
    }
    label273:
    return (String)localObject1 + "-" + str2.substring(str2.indexOf(HardCodeUtil.a(2131714274)) + 1);
    label316:
    return (String)localObject1 + "-" + str2;
  }
  
  public String a(int paramInt)
  {
    if (TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)) {
      return "";
    }
    return this.jdField_c_of_type_JavaLangString.replace("[$album_name]", this.jdField_b_of_type_JavaLangString).replace("[$select_count]", paramInt + "");
  }
  
  public List<StoryAlbum.PicInfo> a()
  {
    return Collections.unmodifiableList(new ArrayList(this.jdField_b_of_type_JavaUtilList));
  }
  
  public void a(int paramInt)
  {
    SLog.d("Q.qqstory.recommendAlbum.logic.StoryAlbum", "setState:" + paramInt);
    this.f = paramInt;
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
    a(paramStoryAlbum.b(), paramStoryAlbum.c());
    if (!TextUtils.isEmpty(paramStoryAlbum.jdField_d_of_type_JavaLangString)) {
      this.jdField_d_of_type_JavaLangString = paramStoryAlbum.jdField_d_of_type_JavaLangString;
    }
    if (paramStoryAlbum.jdField_a_of_type_JavaUtilList != null) {
      this.jdField_a_of_type_JavaUtilList = paramStoryAlbum.jdField_a_of_type_JavaUtilList;
    }
  }
  
  public void a(ScanInfo paramScanInfo)
  {
    this.jdField_e_of_type_JavaLangString = paramScanInfo.toString();
  }
  
  public void a(SplitConfig.BaseSplitConfig paramBaseSplitConfig)
  {
    int i;
    if (paramBaseSplitConfig != null)
    {
      if ((paramBaseSplitConfig.jdField_a_of_type_JavaUtilList == null) || (paramBaseSplitConfig.jdField_a_of_type_JavaUtilList.size() <= 0)) {
        break label85;
      }
      i = new Random().nextInt(paramBaseSplitConfig.jdField_a_of_type_JavaUtilList.size());
    }
    label85:
    for (this.jdField_a_of_type_JavaLangString = ((String)paramBaseSplitConfig.jdField_a_of_type_JavaUtilList.get(i));; this.jdField_a_of_type_JavaLangString = paramBaseSplitConfig.jdField_b_of_type_JavaLangString)
    {
      this.jdField_c_of_type_JavaLangString = paramBaseSplitConfig.jdField_a_of_type_JavaLangString;
      this.jdField_c_of_type_Int = paramBaseSplitConfig.jdField_b_of_type_Int;
      this.jdField_b_of_type_Int = paramBaseSplitConfig.jdField_c_of_type_Int;
      return;
    }
  }
  
  public void a(List<StoryAlbum.PicInfo> paramList)
  {
    this.jdField_b_of_type_JavaUtilList.clear();
    this.jdField_b_of_type_JavaUtilList.addAll(paramList);
    StoryScanManager.b(this.jdField_b_of_type_JavaUtilList);
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
    return this.jdField_b_of_type_Long;
  }
  
  public void b(StoryAlbum paramStoryAlbum)
  {
    AssertUtils.a(paramStoryAlbum);
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
    StoryScanManager.b(this.jdField_b_of_type_JavaUtilList);
  }
  
  public boolean b()
  {
    return (this.jdField_a_of_type_Int == -1) && (this.jdField_d_of_type_Int != 1);
  }
  
  public int c()
  {
    Iterator localIterator = this.jdField_b_of_type_JavaUtilList.iterator();
    int i = 0;
    if (localIterator.hasNext())
    {
      if (!((StoryAlbum.PicInfo)localIterator.next()).a()) {
        break label45;
      }
      i += 1;
    }
    label45:
    for (;;)
    {
      break;
      return i;
    }
  }
  
  public long c()
  {
    return this.jdField_c_of_type_Long;
  }
  
  public boolean c()
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
  
  public int d()
  {
    switch (this.jdField_a_of_type_Int)
    {
    case 5: 
    default: 
      return 0;
    case 1: 
      return 1;
    case 6: 
      return 2;
    case 2: 
      return 3;
    case 4: 
      return 4;
    }
    return 5;
  }
  
  public long d()
  {
    if ((this.jdField_b_of_type_JavaUtilList == null) || (this.jdField_b_of_type_JavaUtilList.isEmpty())) {
      return 0L;
    }
    return ((StoryAlbum.PicInfo)this.jdField_b_of_type_JavaUtilList.get(0)).jdField_b_of_type_Long;
  }
  
  public long e()
  {
    if ((this.jdField_b_of_type_JavaUtilList == null) || (this.jdField_b_of_type_JavaUtilList.isEmpty())) {
      return 0L;
    }
    return ((StoryAlbum.PicInfo)this.jdField_b_of_type_JavaUtilList.get(this.jdField_b_of_type_JavaUtilList.size() - 1)).d;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool = true;
    if ((paramObject instanceof StoryAlbum))
    {
      if ((a()) && (((StoryAlbum)paramObject).a())) {
        return this.jdField_d_of_type_Int == ((StoryAlbum)paramObject).jdField_d_of_type_Int;
      }
      if (this.jdField_a_of_type_Long == ((StoryAlbum)paramObject).jdField_a_of_type_Long) {}
      for (;;)
      {
        return bool;
        bool = false;
      }
    }
    return false;
  }
  
  public long f()
  {
    if (this.jdField_b_of_type_JavaUtilList.isEmpty()) {
      return -1L;
    }
    return ((StoryAlbum.PicInfo)this.jdField_b_of_type_JavaUtilList.get(0)).jdField_b_of_type_Long;
  }
  
  public long g()
  {
    if (this.jdField_b_of_type_JavaUtilList.isEmpty()) {
      return -1L;
    }
    return ((StoryAlbum.PicInfo)this.jdField_b_of_type_JavaUtilList.get(this.jdField_b_of_type_JavaUtilList.size() - 1)).jdField_b_of_type_Long;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder1 = new StringBuilder("StoryAlbum=[");
    localStringBuilder1.append(" mId:").append(this.jdField_a_of_type_Long);
    StringBuilder localStringBuilder2 = localStringBuilder1.append(" ;isHomeAlbum:");
    if (this.jdField_a_of_type_Int == 2) {}
    for (boolean bool = true;; bool = false)
    {
      localStringBuilder2.append(bool);
      localStringBuilder1.append(" ;mAlbumType:").append(this.jdField_a_of_type_Int);
      localStringBuilder1.append(" ;mAlbumName:").append(this.jdField_b_of_type_JavaLangString);
      localStringBuilder1.append(" ;mAlbumTime:").append(a());
      localStringBuilder1.append(" ;StartTime:").append(f());
      localStringBuilder1.append(" ;EndTime:").append(g());
      localStringBuilder1.append(" ;mUIAlbumType:").append(this.jdField_d_of_type_Int);
      localStringBuilder1.append(" ;mTransId:").append(this.jdField_a_of_type_JavaLangString);
      localStringBuilder1.append(" ;mTextId:").append(this.jdField_b_of_type_Int);
      localStringBuilder1.append(" ;count:").append(this.jdField_b_of_type_JavaUtilList.size());
      localStringBuilder1.append(" ;mAlbumDesc:").append(this.jdField_c_of_type_JavaLangString);
      localStringBuilder1.append(" ;kmeansTime1:").append(this.jdField_b_of_type_Long);
      localStringBuilder1.append(" ;kmeansTime2:").append(this.jdField_c_of_type_Long);
      localStringBuilder1.append(" ;mGeoHashHead:").append(this.jdField_d_of_type_JavaLangString);
      localStringBuilder1.append(" ;mGeoHashStringList:").append(this.jdField_a_of_type_JavaUtilList);
      localStringBuilder1.append(" ;debugInfo:").append(this.jdField_e_of_type_JavaLangString);
      localStringBuilder1.append("]");
      return localStringBuilder1.toString();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.album.model.StoryAlbum
 * JD-Core Version:    0.7.0.1
 */