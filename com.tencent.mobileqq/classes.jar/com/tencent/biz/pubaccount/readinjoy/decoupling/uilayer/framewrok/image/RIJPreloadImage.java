package com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.image;

import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.VisibleForTesting;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyDisplayUtils;
import com.tencent.biz.pubaccount.readinjoy.decoupling.accesslayer.data.RIJDataManager;
import com.tencent.biz.pubaccount.readinjoy.decoupling.accesslayer.data.RIJDataManager.Builder;
import com.tencent.biz.pubaccount.readinjoy.decoupling.accesslayer.util.RIJQQAppInterfaceUtil;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.PrefetchListener;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.preparse.RIJPreParseData;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util.RIJFeedsType;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngine;
import com.tencent.biz.pubaccount.readinjoy.imageopt.RIJImageTypeOptHelper;
import com.tencent.biz.pubaccount.readinjoy.model.FastWebModule;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter;
import com.tencent.biz.pubaccount.readinjoy.view.imageloader.ImageManager;
import com.tencent.biz.pubaccount.readinjoy.view.imageloader.ImageRequest;
import com.tencent.biz.pubaccount.readinjoy.webarticle.DataPreloadModule;
import com.tencent.biz.pubaccount.readinjoy.webarticle.DataPreloadModule.Companion;
import com.tencent.biz.pubaccount.readinjoy.webarticle.RIJWebArticlePreloadUtil;
import com.tencent.biz.pubaccount.readinjoy.webarticle.RIJWebArticleUtil;
import com.tencent.biz.pubaccount.util.PreloadManager;
import com.tencent.biz.publicAccountImageCollection.PublicAccountImageCollectionPreloadManager;
import com.tencent.biz.webviewplugin.PubAccountPreloadPlugin;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import cooperation.readinjoy.ReadInJoyHelper;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RIJPreloadImage
{
  private static int jdField_a_of_type_Int = 10;
  private static int b;
  private long jdField_a_of_type_Long = 0L;
  
  static
  {
    jdField_b_of_type_Int = 10;
  }
  
  private List<PreloadImgInfo> a(BaseArticleInfo paramBaseArticleInfo)
  {
    ArrayList localArrayList = new ArrayList();
    URL localURL;
    if (paramBaseArticleInfo.mVideoCoverUrl != null)
    {
      localURL = paramBaseArticleInfo.mVideoCoverUrl;
      localArrayList.add(PreloadImgInfo.a(localURL, ReadInJoyDisplayUtils.g()));
      if ((paramBaseArticleInfo.mSubArtilceList != null) && (paramBaseArticleInfo.mSubArtilceList.size() > 0))
      {
        paramBaseArticleInfo = (ArticleInfo)paramBaseArticleInfo.mSubArtilceList.get(0);
        if (paramBaseArticleInfo.mVideoCoverUrl == null) {
          break label121;
        }
        paramBaseArticleInfo = paramBaseArticleInfo.mVideoCoverUrl;
      }
    }
    for (;;)
    {
      localArrayList.add(PreloadImgInfo.a(paramBaseArticleInfo, ReadInJoyDisplayUtils.g()));
      return localArrayList;
      if (paramBaseArticleInfo.mSinglePicture != null)
      {
        localURL = paramBaseArticleInfo.mSinglePicture;
        break;
      }
      localURL = RIJPreParseData.a(paramBaseArticleInfo.mFirstPagePicUrl);
      break;
      label121:
      if (paramBaseArticleInfo.mSinglePicture != null) {
        paramBaseArticleInfo = paramBaseArticleInfo.mSinglePicture;
      } else {
        paramBaseArticleInfo = RIJPreParseData.a(paramBaseArticleInfo.mFirstPagePicUrl);
      }
    }
  }
  
  private void a(List<PreloadImgInfo> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      PreloadImgInfo localPreloadImgInfo = (PreloadImgInfo)paramList.next();
      if ((localPreloadImgInfo != null) && (localPreloadImgInfo.jdField_a_of_type_JavaNetURL != null))
      {
        if (TextUtils.equals("pubaccountimage", localPreloadImgInfo.jdField_a_of_type_JavaNetURL.getProtocol())) {
          localPreloadImgInfo.jdField_a_of_type_JavaNetURL = RIJPreParseData.a(localPreloadImgInfo.jdField_a_of_type_JavaNetURL.getFile(), false);
        }
        if (localPreloadImgInfo.jdField_a_of_type_JavaNetURL != null)
        {
          ImageRequest localImageRequest = new ImageRequest();
          RIJImageTypeOptHelper.a.a(localImageRequest, localPreloadImgInfo.jdField_a_of_type_JavaNetURL.toString());
          localImageRequest.jdField_a_of_type_Int = ((Integer)localPreloadImgInfo.jdField_a_of_type_AndroidUtilPair.first).intValue();
          localImageRequest.jdField_b_of_type_Int = ((Integer)localPreloadImgInfo.jdField_a_of_type_AndroidUtilPair.second).intValue();
          localImageRequest.jdField_b_of_type_Boolean = true;
          ImageManager.a().a(localImageRequest, null);
        }
      }
    }
  }
  
  private List<PreloadImgInfo> b(BaseArticleInfo paramBaseArticleInfo)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramBaseArticleInfo.mPictures != null)
    {
      paramBaseArticleInfo = paramBaseArticleInfo.mPictures;
      int j = paramBaseArticleInfo.length;
      int i = 0;
      while (i < j)
      {
        localArrayList.add(PreloadImgInfo.a(paramBaseArticleInfo[i], ReadInJoyDisplayUtils.a()));
        i += 1;
      }
    }
    return localArrayList;
  }
  
  public int a()
  {
    return jdField_a_of_type_Int;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("RIJPreloadImage", 2, "cpu:" + DeviceInfoUtil.b() + " mem:" + DeviceInfoUtil.a() + " fre:" + DeviceInfoUtil.b());
    }
    int i = DeviceInfoUtil.b();
    long l = DeviceInfoUtil.a();
    if ((i >= 4) && (l >= 1610612736.0D))
    {
      jdField_a_of_type_Int = 6;
      return;
    }
    jdField_a_of_type_Int = 4;
  }
  
  public void a(int paramInt1, int paramInt2, RIJDataManager paramRIJDataManager)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RIJPreloadImage", 2, "preloadImg start:" + paramInt1 + " count:" + paramInt2);
    }
    long l = System.currentTimeMillis();
    if (!NetworkUtil.h(paramRIJDataManager.a().a())) {
      return;
    }
    ArrayList localArrayList = new ArrayList(paramRIJDataManager.a());
    ThreadManager.post(new RIJPreloadImage.1(this, this.jdField_a_of_type_Long, localArrayList, paramInt1, paramInt2, paramRIJDataManager, l), 5, null, true);
  }
  
  public void a(int paramInt1, int paramInt2, ReadInJoyBaseAdapter paramReadInJoyBaseAdapter)
  {
    if (!PreloadManager.a().a()) {}
    for (;;)
    {
      return;
      PreloadManager.a().e();
      int i = paramReadInJoyBaseAdapter.a();
      while (paramInt1 <= paramInt2)
      {
        Object localObject = paramReadInJoyBaseAdapter.getItem(paramInt1);
        if ((localObject instanceof BaseArticleInfo))
        {
          localObject = (BaseArticleInfo)localObject;
          if ((!RIJFeedsType.a(((BaseArticleInfo)localObject).mArticleContentUrl, ((BaseArticleInfo)localObject).mChannelID, (ArticleInfo)localObject)) && (!RIJFeedsType.a((BaseArticleInfo)localObject)) && (!paramReadInJoyBaseAdapter.a(i, ((BaseArticleInfo)localObject).mArticleID)))
          {
            localObject = ((BaseArticleInfo)localObject).mArticleContentUrl;
            if (PubAccountPreloadPlugin.a((String)localObject)) {
              PreloadManager.a().a((String)localObject);
            }
          }
        }
        paramInt1 += 1;
      }
    }
  }
  
  public void a(long paramLong)
  {
    this.jdField_a_of_type_Long = paramLong;
  }
  
  @VisibleForTesting
  void a(List<PreloadImgInfo> paramList, int paramInt, BaseArticleInfo paramBaseArticleInfo, RIJDataManager paramRIJDataManager)
  {
    paramInt = paramRIJDataManager.a().a().getItemViewType(paramInt);
    if (paramInt == 4) {
      if (paramBaseArticleInfo.mVideoCoverUrl != null)
      {
        paramBaseArticleInfo = paramBaseArticleInfo.mVideoCoverUrl;
        paramList.add(PreloadImgInfo.a(paramBaseArticleInfo, ReadInJoyDisplayUtils.f()));
      }
    }
    do
    {
      return;
      if (paramBaseArticleInfo.mSinglePicture != null)
      {
        paramBaseArticleInfo = paramBaseArticleInfo.mSinglePicture;
        break;
      }
      paramBaseArticleInfo = RIJPreParseData.a(paramBaseArticleInfo.mFirstPagePicUrl);
      break;
      if ((paramInt == 70) || (paramInt == 46))
      {
        paramList.addAll(a(paramBaseArticleInfo));
        return;
      }
      if ((paramInt == 3) || (paramInt == 14) || (paramInt == 105))
      {
        paramList.addAll(b(paramBaseArticleInfo));
        return;
      }
      if ((paramInt == 2) || (paramInt == 6) || (paramInt == 66) || (paramInt == 115))
      {
        paramList.add(PreloadImgInfo.a(paramBaseArticleInfo.mSinglePicture, ReadInJoyDisplayUtils.e()));
        return;
      }
    } while ((paramInt != 1) && (paramInt != 5) && (paramInt != 104) && (paramInt != 106));
    paramList.add(PreloadImgInfo.a(paramBaseArticleInfo.mSinglePicture, ReadInJoyDisplayUtils.a()));
  }
  
  public void a(boolean paramBoolean, int paramInt1, int paramInt2, PrefetchListener paramPrefetchListener, RIJDataManager paramRIJDataManager)
  {
    ImageManager.a().c();
    if (QLog.isColorLevel()) {
      QLog.d("RIJPreloadImage", 2, "resume image onScrollStateChanged idle");
    }
    if (paramBoolean) {
      a(paramInt2, jdField_a_of_type_Int, paramRIJDataManager);
    }
    for (;;)
    {
      if ((paramInt1 - paramInt2 < jdField_b_of_type_Int) && (paramPrefetchListener != null)) {
        paramPrefetchListener.a();
      }
      return;
      a(paramInt2 - jdField_a_of_type_Int, jdField_a_of_type_Int, paramRIJDataManager);
    }
  }
  
  public void b(int paramInt1, int paramInt2, ReadInJoyBaseAdapter paramReadInJoyBaseAdapter)
  {
    if (!PublicAccountImageCollectionPreloadManager.a().a()) {}
    for (;;)
    {
      return;
      PublicAccountImageCollectionPreloadManager.a().c();
      while (paramInt1 <= paramInt2)
      {
        Object localObject = paramReadInJoyBaseAdapter.getItem(paramInt1);
        if (localObject != null)
        {
          localObject = (BaseArticleInfo)localObject;
          int i = paramReadInJoyBaseAdapter.a(paramInt1);
          if ((i == 8) || (i == 7)) {
            PublicAccountImageCollectionPreloadManager.a().a(String.valueOf(((BaseArticleInfo)localObject).innerUniqueID));
          }
        }
        paramInt1 += 1;
      }
    }
  }
  
  public void c(int paramInt1, int paramInt2, ReadInJoyBaseAdapter paramReadInJoyBaseAdapter)
  {
    if ((!ReadInJoyHelper.C(RIJQQAppInterfaceUtil.b())) || (!ReadInJoyHelper.D(RIJQQAppInterfaceUtil.b()))) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    while (paramInt1 <= paramInt2)
    {
      Object localObject = paramReadInJoyBaseAdapter.getItem(paramInt1);
      if (localObject != null)
      {
        localObject = (BaseArticleInfo)localObject;
        if (!RIJFeedsType.a((BaseArticleInfo)localObject)) {
          localArrayList.add((ArticleInfo)localObject);
        }
      }
      paramInt1 += 1;
    }
    ReadInJoyLogicEngine.a().a().a(localArrayList);
  }
  
  public void d(int paramInt1, int paramInt2, ReadInJoyBaseAdapter paramReadInJoyBaseAdapter)
  {
    if (!RIJWebArticleUtil.a.a()) {}
    for (;;)
    {
      return;
      while (paramInt1 <= paramInt2)
      {
        Object localObject = paramReadInJoyBaseAdapter.getItem(paramInt1);
        if (localObject != null)
        {
          RIJWebArticlePreloadUtil.a.a((BaseArticleInfo)localObject);
          DataPreloadModule.a.a((BaseArticleInfo)localObject);
        }
        paramInt1 += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.image.RIJPreloadImage
 * JD-Core Version:    0.7.0.1
 */