package com.tencent.biz.pubaccount.readinjoy.pts.lite;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Pair;
import bhnv;
import bnrf;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyBaseFragment;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ocd;
import org.json.JSONException;
import org.json.JSONObject;
import ozs;
import pay;
import pbd;
import qgl;
import qia;
import sel;
import ubg;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
public final class PTSLiteSwiperEventDispatcher$handleSwiperItemExposure$1
  implements Runnable
{
  public PTSLiteSwiperEventDispatcher$handleSwiperItemExposure$1(qgl paramqgl, String paramString1, String paramString2, HashMap paramHashMap) {}
  
  public final void run()
  {
    if (TextUtils.isEmpty((CharSequence)this.jdField_a_of_type_JavaLangString)) {
      QLog.i("PTSLiteSwiperEventDispatcher", 1, "[handleSwiperItemExposure] identifier is null.");
    }
    ArticleInfo localArticleInfo = (ArticleInfo)((Map)qgl.a(this.this$0)).get(this.jdField_a_of_type_JavaLangString);
    if (localArticleInfo == null)
    {
      QLog.i("PTSLiteSwiperEventDispatcher", 1, "[handleSwiperItemExposure] error, articleInfo is null.");
      return;
    }
    long l1 = localArticleInfo.mChannelID;
    Object localObject2 = qgl.a(this.this$0, (int)l1);
    if (localObject2 == null) {
      Intrinsics.throwNpe();
    }
    Object localObject1 = (Long)((Pair)localObject2).second;
    localObject2 = (Integer)((Pair)localObject2).first;
    long l2 = localArticleInfo.mAlgorithmID;
    int k = localArticleInfo.mArticleType;
    int m = (int)l1;
    label138:
    int j;
    label154:
    Object localObject3;
    if (localArticleInfo.hasChannelInfo())
    {
      i = localArticleInfo.mChannelInfoId;
      if (!TextUtils.isEmpty((CharSequence)localArticleInfo.mArticleFriendLikeText)) {
        break label522;
      }
      j = 0;
      boolean bool = bhnv.h(null);
      localObject3 = ozs.d((BaseArticleInfo)localArticleInfo);
      String str2 = localArticleInfo.mStrCircleId;
      String str3 = localArticleInfo.innerUniqueID;
      String str4 = ozs.f((BaseArticleInfo)localArticleInfo);
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "totalTimeMillis");
      long l3 = ((Long)localObject1).longValue();
      Intrinsics.checkExpressionValueIsNotNull(localObject2, "behaviorType");
      localObject2 = ozs.a(l2, k, m, i, j, bool, (String)localObject3, str2, str3, str4, localArticleInfo, l3, ((Integer)localObject2).intValue(), ozs.d(), ozs.e(), 0, false, localArticleInfo.mVideoAdsJumpType, localArticleInfo.mVideoAdsSource, ReadInJoyBaseFragment.a((int)l1));
    }
    for (;;)
    {
      try
      {
        localObject3 = new JSONObject((String)localObject2);
        ((JSONObject)localObject3).put("folder_status", this.b);
        ((JSONObject)localObject3).put("is_change", pay.a(ozs.a(), (int)l1));
        localObject1 = qgl.a(this.this$0);
        if (localObject1 == null) {
          continue;
        }
        localObject1 = ((sel)localObject1).a();
        if (localObject1 == null) {
          continue;
        }
        localObject1 = ((Activity)localObject1).getIntent();
        if (localObject1 == null) {
          continue;
        }
        if (((Intent)localObject1).getIntExtra("launch_from", 0) != 15) {
          continue;
        }
        i = 1;
      }
      catch (JSONException localJSONException)
      {
        label522:
        QLog.i("PTSLiteSwiperEventDispatcher", 1, "[handleSwiperItemExposure] e = " + localJSONException);
        continue;
        String str1 = "0X8007626";
        continue;
        continue;
        if (i == 0) {
          continue;
        }
        i = 1;
        continue;
      }
      ((JSONObject)localObject3).put("from_aio", i);
      localObject1 = ((JSONObject)localObject3).toString();
      localObject2 = localObject1;
      if (!ubg.a(l1)) {
        continue;
      }
      localObject1 = "0X8009354";
      if ((!pbd.a((int)l1)) && (!bnrf.a(l1))) {
        continue;
      }
      localObject1 = "0X8009CC8";
      localObject2 = qia.a((String)localObject2, this.jdField_a_of_type_JavaUtilHashMap);
      ocd.a(null, localArticleInfo.mSubscribeID, (String)localObject1, (String)localObject1, 0, 0, String.valueOf(localArticleInfo.mFeedId), String.valueOf(localArticleInfo.mArticleID), String.valueOf(localArticleInfo.mStrategyId), (String)localObject2, false);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.i("PTSLiteSwiperEventDispatcher", 2, "[handleSwiperItemExposure] reportActionName = " + (String)localObject1 + ", r5Str = " + (String)localObject2);
      return;
      i = 0;
      break label138;
      j = 1;
      break label154;
      localObject1 = null;
      continue;
      i = 0;
      continue;
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.pts.lite.PTSLiteSwiperEventDispatcher.handleSwiperItemExposure.1
 * JD-Core Version:    0.7.0.1
 */