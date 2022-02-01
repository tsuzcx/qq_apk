package com.tencent.biz.pubaccount.readinjoy.srtUtils.longcontentinfoupdater;

import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.ArticleBasicInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.LongContentInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.PGCFeedsInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import kotlin.Metadata;
import tencent.im.oidb.articlesummary.articlesummary.PGCPicInfo;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/srtUtils/longcontentinfoupdater/LongContentInfoUpdaterArticleOnePic;", "Lcom/tencent/biz/pubaccount/readinjoy/srtUtils/longcontentinfoupdater/LongContentInfoUpdater;", "()V", "process", "", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class LongContentInfoUpdaterArticleOnePic
  extends LongContentInfoUpdater
{
  protected void a()
  {
    Object localObject2 = null;
    Object localObject1 = a();
    if (localObject1 != null) {
      ((SocializeFeedsInfo)localObject1).a = 1;
    }
    Object localObject3 = a();
    localObject1 = a();
    if (localObject1 != null)
    {
      localObject1 = ((SocializeFeedsInfo.LongContentInfo)localObject1).a;
      if (localObject1 == null) {}
    }
    for (localObject1 = ((SocializeFeedsInfo.ArticleBasicInfo)localObject1).b;; localObject1 = null)
    {
      ((BaseArticleInfo)localObject3).mTitle = ((String)localObject1);
      localObject1 = a();
      if (localObject1 != null) {
        ((SocializeFeedsInfo.PGCFeedsInfo)localObject1).a = true;
      }
      try
      {
        localObject3 = a();
        localObject1 = localObject2;
        if (localObject3 != null)
        {
          localObject3 = ((SocializeFeedsInfo.LongContentInfo)localObject3).a;
          localObject1 = localObject2;
          if (localObject3 != null)
          {
            localObject3 = ((SocializeFeedsInfo.ArticleBasicInfo)localObject3).a;
            localObject1 = localObject2;
            if (localObject3 != null)
            {
              localObject3 = (articlesummary.PGCPicInfo)((ArrayList)localObject3).get(0);
              localObject1 = localObject2;
              if (localObject3 != null)
              {
                localObject3 = ((articlesummary.PGCPicInfo)localObject3).bytes_pic_url;
                localObject1 = localObject2;
                if (localObject3 != null)
                {
                  localObject3 = ((PBBytesField)localObject3).get();
                  localObject1 = localObject2;
                  if (localObject3 != null) {
                    localObject1 = ((ByteStringMicro)localObject3).toStringUtf8();
                  }
                }
              }
            }
          }
        }
        if (localObject1 != null) {
          a().mSinglePicture = new URL((String)localObject1);
        }
        return;
      }
      catch (MalformedURLException localMalformedURLException)
      {
        localMalformedURLException.printStackTrace();
        return;
      }
      catch (IndexOutOfBoundsException localIndexOutOfBoundsException)
      {
        localIndexOutOfBoundsException.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.srtUtils.longcontentinfoupdater.LongContentInfoUpdaterArticleOnePic
 * JD-Core Version:    0.7.0.1
 */