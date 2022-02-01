package com.tencent.biz.qqstory.album.strategy;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.album.StoryScanManager;
import com.tencent.biz.qqstory.album.model.StoryAlbum;
import com.tencent.biz.qqstory.album.model.StoryAlbum.PicInfo;
import com.tencent.biz.qqstory.album.model.strategy.BaseSplitConfig;
import com.tencent.biz.qqstory.album.segment.ScanInfo;
import com.tencent.biz.qqstory.album.tools.kmeans.DateKmeans;
import com.tencent.biz.qqstory.model.StoryConfigManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.utils.AssertUtils;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.List<Lcom.tencent.biz.qqstory.album.model.StoryAlbum.PicInfo;>;

public class KMeansSplitStrategy
  extends AbstractSplitStrategy<BaseSplitConfig>
{
  static SimpleDateFormat jdField_a_of_type_JavaTextSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
  private int jdField_a_of_type_Int = 1;
  private ScanInfo jdField_a_of_type_ComTencentBizQqstoryAlbumSegmentScanInfo;
  
  private int a(List<StoryAlbum.PicInfo> paramList)
  {
    new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    long l2 = -1L;
    int m = 0;
    int i = 1;
    while (m < paramList.size())
    {
      if (l2 < 0L) {
        j = i;
      }
      try
      {
        l1 = a(((StoryAlbum.PicInfo)paramList.get(m)).b);
        k = i;
      }
      catch (ParseException localParseException)
      {
        localParseException.printStackTrace();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("we found the error time pic:");
        localStringBuilder.append(paramList.get(m));
        AssertUtils.fail(localStringBuilder.toString(), new Object[0]);
        l1 = l2;
        k = j;
      }
      int j = i;
      int k = i;
      long l1 = l2;
      if (((StoryAlbum.PicInfo)paramList.get(m)).b - l2 > 86400L)
      {
        k = i + 1;
        j = k;
        l1 = a(((StoryAlbum.PicInfo)paramList.get(m)).b);
      }
      m += 1;
      i = k;
      l2 = l1;
    }
    paramList = new StringBuilder();
    paramList.append("caculatePictureDistribution=");
    paramList.append(i);
    SLog.d("Q.qqstory.recommendAlbum.logic.StoryScanManager.KMeansSplitStrategy", paramList.toString());
    return i;
  }
  
  private long a(long paramLong)
  {
    SimpleDateFormat localSimpleDateFormat = jdField_a_of_type_JavaTextSimpleDateFormat;
    return localSimpleDateFormat.parse(localSimpleDateFormat.format(Long.valueOf(paramLong * 1000L))).getTime() / 1000L;
  }
  
  protected List<StoryAlbum> a(@NonNull List<StoryAlbum.PicInfo> paramList)
  {
    Object localObject1 = new DateKmeans();
    paramList = new ArrayList(paramList);
    StoryScanManager.b(paramList);
    int i = a(paramList) / this.jdField_a_of_type_Int;
    String[] arrayOfString = new String[1];
    ((DateKmeans)localObject1).a(i + 1);
    paramList = ((DateKmeans)localObject1).a(paramList, arrayOfString);
    ArrayList localArrayList = new ArrayList();
    i = 0;
    while (i < paramList.size())
    {
      localObject1 = (List)paramList.get(i);
      Collections.sort((List)localObject1, new KMeansSplitStrategy.1(this));
      localObject2 = new StoryAlbum(this.jdField_a_of_type_ComTencentBizQqstoryAlbumModelStoryAlbum.jdField_a_of_type_Int, (List)localObject1);
      ((StoryAlbum)localObject2).a(((StoryAlbum.PicInfo)((List)localObject1).get(0)).b, ((StoryAlbum.PicInfo)((List)localObject1).get(((List)localObject1).size() - 1)).b);
      localArrayList.add(localObject2);
      i += 1;
    }
    paramList = new StringBuilder();
    paramList.append("k means split : k=");
    paramList.append(localArrayList.size());
    paramList = paramList.toString();
    Collections.sort(localArrayList, new KMeansSplitStrategy.2(this));
    localObject1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    Object localObject2 = localArrayList.iterator();
    Object localObject3;
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (StoryAlbum)((Iterator)localObject2).next();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramList);
      localStringBuilder.append("[ s=");
      localStringBuilder.append(((SimpleDateFormat)localObject1).format(Long.valueOf(((StoryAlbum)localObject3).e() * 1000L)));
      localStringBuilder.append(" e=");
      localStringBuilder.append(((SimpleDateFormat)localObject1).format(Long.valueOf(((StoryAlbum)localObject3).f() * 1000L)));
      localStringBuilder.append(" c=");
      localStringBuilder.append(((StoryAlbum)localObject3).b());
      localStringBuilder.append("]");
      paramList = localStringBuilder.toString();
    }
    SLog.d("Q.qqstory.recommendAlbum.logic.StoryScanManager.KMeansSplitStrategy", paramList);
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("(k=");
    ((StringBuilder)localObject1).append(localArrayList.size());
    ((StringBuilder)localObject1).append(" ");
    ((StringBuilder)localObject1).append(paramList);
    ((StringBuilder)localObject1).append(");");
    localObject2 = ((StringBuilder)localObject1).toString();
    localObject1 = (String)((StoryConfigManager)SuperManager.a(10)).b("key_album_debug_k", "");
    paramList = (List<StoryAlbum.PicInfo>)localObject2;
    if (!TextUtils.isEmpty((CharSequence)localObject1))
    {
      localObject3 = ((String)localObject1).split(";");
      paramList = "";
      i = 0;
      for (;;)
      {
        localObject1 = paramList;
        if (i >= localObject3.length) {
          break;
        }
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(localObject3[i]);
        ((StringBuilder)localObject1).append(paramList);
        paramList = ((StringBuilder)localObject1).toString();
        if (i == 8)
        {
          localObject1 = paramList;
          break;
        }
        i += 1;
      }
      paramList = new StringBuilder();
      paramList.append((String)localObject2);
      paramList.append((String)localObject1);
      paramList = paramList.toString();
    }
    localObject1 = this.jdField_a_of_type_ComTencentBizQqstoryAlbumSegmentScanInfo;
    ((ScanInfo)localObject1).a = paramList;
    ((ScanInfo)localObject1).b = arrayOfString[0];
    return localArrayList;
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(ScanInfo paramScanInfo)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryAlbumSegmentScanInfo = paramScanInfo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.album.strategy.KMeansSplitStrategy
 * JD-Core Version:    0.7.0.1
 */