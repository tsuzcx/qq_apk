package com.tencent.biz.pubaccount.readinjoy.view;

import android.text.TextUtils;
import android.util.Pair;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import oar;
import omr;
import onh;
import ram;
import rbt;
import rpg;
import rph;

public class ReadInJoyBaseAdapter$4
  implements Runnable
{
  public ReadInJoyBaseAdapter$4(ram paramram, long paramLong1, List paramList, int paramInt1, int paramInt2, long paramLong2) {}
  
  public void run()
  {
    if (ram.a(this.this$0) != this.jdField_a_of_type_Long) {
      return;
    }
    int i;
    label25:
    LinkedList localLinkedList;
    int j;
    if (this.jdField_a_of_type_JavaUtilList == null)
    {
      i = 0;
      localLinkedList = new LinkedList();
      j = this.jdField_a_of_type_Int;
      label39:
      if (j >= this.jdField_a_of_type_Int + this.jdField_b_of_type_Int) {
        break label563;
      }
      if ((j < i) && (j >= 0)) {
        break label81;
      }
      label60:
      break label474;
      break label377;
    }
    label61:
    label81:
    Object localObject2;
    int k;
    label182:
    Object localObject1;
    label430:
    for (;;)
    {
      j += 1;
      break label39;
      i = this.jdField_a_of_type_JavaUtilList.size();
      break label25;
      if (ram.a(this.this$0) != this.jdField_a_of_type_Long) {
        break;
      }
      for (;;)
      {
        try
        {
          localObject2 = (BaseArticleInfo)this.jdField_a_of_type_JavaUtilList.get(j);
          k = this.this$0.getItemViewType(j);
          if (k != 4) {
            break label784;
          }
          if (((BaseArticleInfo)localObject2).mVideoCoverUrl == null) {
            break label182;
          }
          URL localURL = ((BaseArticleInfo)localObject2).mVideoCoverUrl;
          localLinkedList.add(rbt.a(localURL, omr.f()));
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
        }
        if (ram.a(this.this$0) == this.jdField_a_of_type_Long) {
          break;
        }
        return;
        if (((BaseArticleInfo)localObject2).mSinglePicture != null) {
          localObject1 = ((BaseArticleInfo)localObject2).mSinglePicture;
        } else {
          localObject1 = onh.a(((BaseArticleInfo)localObject2).mFirstPagePicUrl);
        }
      }
      label213:
      if (((BaseArticleInfo)localObject2).mVideoCoverUrl != null)
      {
        localObject1 = ((BaseArticleInfo)localObject2).mVideoCoverUrl;
        label228:
        localLinkedList.add(rbt.a((URL)localObject1, omr.g()));
        if ((((BaseArticleInfo)localObject2).mSubArtilceList == null) || (((BaseArticleInfo)localObject2).mSubArtilceList.size() <= 0)) {
          continue;
        }
        localObject1 = (ArticleInfo)((BaseArticleInfo)localObject2).mSubArtilceList.get(0);
        if (((ArticleInfo)localObject1).mVideoCoverUrl == null) {
          break label346;
        }
        localObject1 = ((ArticleInfo)localObject1).mVideoCoverUrl;
      }
      for (;;)
      {
        localLinkedList.add(rbt.a((URL)localObject1, omr.g()));
        break;
        if (((BaseArticleInfo)localObject2).mSinglePicture != null)
        {
          localObject1 = ((BaseArticleInfo)localObject2).mSinglePicture;
          break label228;
        }
        localObject1 = onh.a(((BaseArticleInfo)localObject2).mFirstPagePicUrl);
        break label228;
        label346:
        if (((ArticleInfo)localObject1).mSinglePicture != null) {
          localObject1 = ((ArticleInfo)localObject1).mSinglePicture;
        } else {
          localObject1 = onh.a(((ArticleInfo)localObject1).mFirstPagePicUrl);
        }
      }
      label377:
      if (((BaseArticleInfo)localObject2).mPictures != null)
      {
        localObject1 = ((BaseArticleInfo)localObject2).mPictures;
        int m = localObject1.length;
        k = 0;
        while (k < m)
        {
          localLinkedList.add(rbt.a(localObject1[k], omr.a()));
          k += 1;
        }
        continue;
        localLinkedList.add(rbt.a(((BaseArticleInfo)localObject2).mSinglePicture, omr.e()));
      }
    }
    for (;;)
    {
      localLinkedList.add(rbt.a(((BaseArticleInfo)localObject2).mSinglePicture, omr.a()));
      break label61;
      label474:
      if ((k != 122) || (!AdvertisementInfo.isAdvertisementInfo((BaseArticleInfo)localObject2)) || (!oar.l((AdvertisementInfo)localObject2)) || (((AdvertisementInfo)localObject2).mAdImgList == null)) {
        break label61;
      }
      localObject1 = ((AdvertisementInfo)localObject2).mAdImgList.iterator();
      while (((Iterator)localObject1).hasNext()) {
        localLinkedList.add(rbt.a(onh.a((String)((Iterator)localObject1).next()), omr.e()));
      }
      break label61;
      label563:
      if (ram.a(this.this$0) != this.jdField_a_of_type_Long) {
        break;
      }
      localObject1 = localLinkedList.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (rbt)((Iterator)localObject1).next();
        if ((localObject2 != null) && (((rbt)localObject2).jdField_a_of_type_JavaNetURL != null))
        {
          if (TextUtils.equals("pubaccountimage", ((rbt)localObject2).jdField_a_of_type_JavaNetURL.getProtocol())) {
            ((rbt)localObject2).jdField_a_of_type_JavaNetURL = onh.a(((rbt)localObject2).jdField_a_of_type_JavaNetURL.getFile(), false);
          }
          rph localrph = new rph();
          localrph.jdField_a_of_type_JavaNetURL = ((rbt)localObject2).jdField_a_of_type_JavaNetURL;
          localrph.jdField_a_of_type_Int = ((Integer)((rbt)localObject2).jdField_a_of_type_AndroidUtilPair.first).intValue();
          localrph.jdField_b_of_type_Int = ((Integer)((rbt)localObject2).jdField_a_of_type_AndroidUtilPair.second).intValue();
          localrph.jdField_b_of_type_Boolean = true;
          rpg.a().a(localrph, null);
        }
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("ReadInJoyBaseAdapter", 2, "preloadImg size:" + localLinkedList.size() + " cost:" + (System.currentTimeMillis() - this.jdField_b_of_type_Long));
      return;
      label784:
      if ((k == 70) || (k == 46)) {
        break label213;
      }
      if ((k == 3) || (k == 14) || (k == 105)) {
        break label60;
      }
      if ((k == 2) || (k == 6) || (k == 66) || (k == 115)) {
        break label430;
      }
      if ((k != 1) && (k != 5) && (k != 104)) {
        if (k != 106) {
          break label60;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter.4
 * JD-Core Version:    0.7.0.1
 */