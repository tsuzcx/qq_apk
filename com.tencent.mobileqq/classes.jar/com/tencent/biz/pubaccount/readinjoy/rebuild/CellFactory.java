package com.tencent.biz.pubaccount.readinjoy.rebuild;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.common.ApiCompatibilityUtils;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.UtilsForComponent;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter;
import com.tencent.mobileqq.util.FaceDecoder;

public class CellFactory
{
  public static View a(int paramInt1, Object paramObject, int paramInt2, View paramView, Context paramContext, ReadInJoyBaseAdapter paramReadInJoyBaseAdapter, FaceDecoder paramFaceDecoder)
  {
    if ((paramView != null) && ((paramView.getTag() instanceof FeedItemCell))) {}
    for (paramContext = (FeedItemCell)paramView.getTag();; paramContext = paramReadInJoyBaseAdapter)
    {
      if (paramContext != null)
      {
        paramContext.a(paramInt1).a(paramObject);
        paramContext.o();
        paramContext.p();
      }
      return paramView;
      paramReadInJoyBaseAdapter = a(paramInt2, paramContext, paramObject, paramFaceDecoder, paramReadInJoyBaseAdapter);
      if (paramReadInJoyBaseAdapter != null) {
        try
        {
          paramView = paramReadInJoyBaseAdapter.a();
          paramView.setTag(paramReadInJoyBaseAdapter);
          if (!UtilsForComponent.c(paramInt2)) {
            ApiCompatibilityUtils.a(paramView, paramContext.getResources().getDrawable(2130839738));
          } else {
            ApiCompatibilityUtils.a(paramView, paramContext.getResources().getDrawable(2131493472));
          }
        }
        catch (Exception paramObject)
        {
          paramObject.printStackTrace();
          return null;
        }
      }
    }
  }
  
  private static FeedItemCell a(int paramInt, Context paramContext, Object paramObject, FaceDecoder paramFaceDecoder, ReadInJoyBaseAdapter paramReadInJoyBaseAdapter)
  {
    switch (paramInt)
    {
    case 13: 
    case 38: 
    case 46: 
    case 70: 
    default: 
      paramContext = null;
    }
    for (;;)
    {
      if (paramContext != null) {}
      try
      {
        paramContext.a(paramObject);
        paramContext.a();
        paramContext.d();
        return paramContext;
      }
      catch (Exception paramContext)
      {
        paramContext.printStackTrace();
      }
      paramContext = new FeedItemCellTypeNoImage(paramContext, paramFaceDecoder, paramReadInJoyBaseAdapter);
      continue;
      paramContext = new FeedItemCellTypeSmallImage(paramContext, paramFaceDecoder, paramReadInJoyBaseAdapter);
      continue;
      paramContext = new FeedItemCellTypeBigImage(paramContext, paramFaceDecoder, paramReadInJoyBaseAdapter);
      continue;
      paramContext = new FeedItemCellTypeThreeImage(paramContext, paramFaceDecoder, paramReadInJoyBaseAdapter);
      continue;
      paramContext = new FeedItemCellTypeThreeImage(paramContext, paramFaceDecoder, paramReadInJoyBaseAdapter);
      continue;
      paramContext = null;
      continue;
      paramContext = new FeedItemCellTypeSmallVideo(paramContext, paramFaceDecoder, paramReadInJoyBaseAdapter);
      continue;
      paramContext = new FeedItemCellTypeBigImageVideo(paramContext, paramFaceDecoder, paramReadInJoyBaseAdapter);
      continue;
      paramContext = new FeedItemCellTypeSmallGallery(paramContext, paramFaceDecoder, paramReadInJoyBaseAdapter);
      continue;
      paramContext = new FeedItemCellTypeBigGallery(paramContext, paramFaceDecoder, paramReadInJoyBaseAdapter);
      continue;
      paramContext = new FeedItemCellTypeSpecialTopic(paramContext, paramFaceDecoder, paramReadInJoyBaseAdapter);
      continue;
      paramContext = new FeedItemCellTypeSmallSocial(paramContext, paramFaceDecoder, paramReadInJoyBaseAdapter);
      continue;
      paramContext = new FeedItemCellTypeCommonPgcVideoSocial(paramContext, paramFaceDecoder, paramReadInJoyBaseAdapter);
      continue;
      paramContext = new FeedItemCellTypeNoImageSocial(paramContext, paramFaceDecoder, paramReadInJoyBaseAdapter);
      continue;
      paramContext = new FeedItemCellTypeBigSocial(paramContext, paramFaceDecoder, paramReadInJoyBaseAdapter);
      continue;
      paramContext = new FeedItemCellTypeCommonPgcVideoSocial(paramContext, paramFaceDecoder, paramReadInJoyBaseAdapter);
      continue;
      paramContext = new FeedItemCellTypeNow(paramContext, paramFaceDecoder, paramReadInJoyBaseAdapter);
      continue;
      paramContext = new FeedItemCellTypePgcBig(paramContext, paramFaceDecoder, paramReadInJoyBaseAdapter);
      continue;
      paramContext = new FeedItemCellTypeCommonPgcVideo(paramContext, paramFaceDecoder, paramReadInJoyBaseAdapter);
      continue;
      paramContext = new FeedItemCellTypePgcSmall(paramContext, paramFaceDecoder, paramReadInJoyBaseAdapter);
      continue;
      paramContext = new FeedItemCellTypeCommonPgcVideo(paramContext, paramFaceDecoder, paramReadInJoyBaseAdapter);
      continue;
      paramContext = new FeedItemCellTypePgcPlain(paramContext, paramFaceDecoder, paramReadInJoyBaseAdapter);
      continue;
      paramContext = new FeedItemCellTypeUgcPlain(paramContext, paramFaceDecoder, paramReadInJoyBaseAdapter);
      continue;
      paramContext = new FeedItemCellTypeUgcImage(paramContext, paramFaceDecoder, paramReadInJoyBaseAdapter);
      continue;
      paramContext = new FeedItemCellTypeUgcGridImage(paramContext, paramFaceDecoder, paramReadInJoyBaseAdapter);
      continue;
      paramContext = new FeedItemCellTypeUgcVideo(paramContext, paramFaceDecoder, paramReadInJoyBaseAdapter);
      continue;
      paramContext = new FeedItemCellTypeUgcImageSocial(paramContext, paramFaceDecoder, paramReadInJoyBaseAdapter);
      continue;
      paramContext = new FeedItemCellTypeUgcGridImageSocial(paramContext, paramFaceDecoder, paramReadInJoyBaseAdapter);
      continue;
      paramContext = new FeedItemCellTypeUgcVideoSocial(paramContext, paramFaceDecoder, paramReadInJoyBaseAdapter);
      continue;
      paramContext = new FeedItemCellTypeUgcPlainSocial(paramContext, paramFaceDecoder, paramReadInJoyBaseAdapter);
      continue;
      paramContext = new FeedItemCellTypeTopicSingle(paramContext, paramFaceDecoder, paramReadInJoyBaseAdapter);
      continue;
      paramContext = new FeedItemCellTypeTopicMulti(paramContext, paramFaceDecoder, paramReadInJoyBaseAdapter);
      continue;
      paramContext = new FeedItemCellTypeRecommendBig(paramContext, paramFaceDecoder, paramReadInJoyBaseAdapter);
      continue;
      paramContext = new FeedItemCellTypeRecommendBigVideo(paramContext, paramFaceDecoder, paramReadInJoyBaseAdapter);
      continue;
      paramContext = new FeedItemCellTypeTopicSocial(paramContext, paramFaceDecoder, paramReadInJoyBaseAdapter);
      continue;
      paramContext = new FeedItemCellTypePgcGrid(paramContext, paramFaceDecoder, paramReadInJoyBaseAdapter);
      continue;
      paramContext = new FeedItemCellTypePgcGridSocial(paramContext, paramFaceDecoder, paramReadInJoyBaseAdapter);
      continue;
      paramContext = new FeedItemCellTypeTopicRecommendBig(paramContext, paramFaceDecoder, paramReadInJoyBaseAdapter);
      continue;
      paramContext = new FeedItemCellTypeTopicRecommendSmall(paramContext, paramFaceDecoder, paramReadInJoyBaseAdapter);
      continue;
      paramContext = new FeedItemCellTypeTopicRecommendGrid(paramContext, paramFaceDecoder, paramReadInJoyBaseAdapter);
      continue;
      paramContext = new FeedItemCellTypeBigSocial(paramContext, paramFaceDecoder, paramReadInJoyBaseAdapter);
      continue;
      paramContext = new FeedItemCellTypePgcGridSocial(paramContext, paramFaceDecoder, paramReadInJoyBaseAdapter);
      continue;
      paramContext = new FeedItemCellTypeSmallSocial(paramContext, paramFaceDecoder, paramReadInJoyBaseAdapter);
      continue;
      paramContext = new FeedItemCellTypeGallery(paramContext, paramFaceDecoder, paramReadInJoyBaseAdapter);
      continue;
      paramContext = new FeedItemCellTypeGalleryPGC(paramContext, paramFaceDecoder, paramReadInJoyBaseAdapter);
      continue;
      paramContext = new FeedItemCellTypeGalleryBiu(paramContext, paramFaceDecoder, paramReadInJoyBaseAdapter);
      continue;
      paramContext = new FeedItemCellTypeTopicRecommendUgcPlain(paramContext, paramFaceDecoder, paramReadInJoyBaseAdapter);
      continue;
      paramContext = new FeedItemCellTypeTopicRecommendUgcImage(paramContext, paramFaceDecoder, paramReadInJoyBaseAdapter);
      continue;
      paramContext = new FeedItemCellTypeTopicRecommendUgcVideo(paramContext, paramFaceDecoder, paramReadInJoyBaseAdapter);
      continue;
      paramContext = new FeedItemCellTypeUgcPlainSocial(paramContext, paramFaceDecoder, paramReadInJoyBaseAdapter);
      continue;
      paramContext = new FeedItemCellTypeUgcImageSocial(paramContext, paramFaceDecoder, paramReadInJoyBaseAdapter);
      continue;
      paramContext = new FeedItemCellTypeUgcVideoSocial(paramContext, paramFaceDecoder, paramReadInJoyBaseAdapter);
      continue;
      paramContext = new FeedItemCellTypePolymeric(paramContext, paramFaceDecoder, paramReadInJoyBaseAdapter);
      continue;
      paramContext = new FeedItemCellTypePolymericBigImage(paramContext, paramFaceDecoder, paramReadInJoyBaseAdapter);
      continue;
      paramContext = new FeedItemCellTypePolymericImageGallery(paramContext, paramFaceDecoder, paramReadInJoyBaseAdapter);
      continue;
      paramContext = new FeedItemCellTypePolymericVideo(paramContext, paramFaceDecoder, paramReadInJoyBaseAdapter);
      continue;
      paramContext = new FeedItemCellTypePolymericSmallVideo(paramContext, paramFaceDecoder, paramReadInJoyBaseAdapter);
    }
    return null;
  }
  
  public static boolean a(int paramInt)
  {
    boolean bool = true;
    switch (paramInt)
    {
    case 4: 
    case 13: 
    case 38: 
    case 46: 
    case 50: 
    case 51: 
    case 52: 
    case 70: 
    default: 
      bool = false;
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.rebuild.CellFactory
 * JD-Core Version:    0.7.0.1
 */