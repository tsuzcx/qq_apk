package com.tencent.biz.pubaccount.readinjoy.webarticle;

import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util.RIJFeedsType;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngine;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicManager;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import mqq.os.MqqHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/webarticle/RIJWebArticlePreloadUtil;", "", "()V", "BUNDLE_KEY_ARTICLE_URL", "", "TAG", "preloadList", "Ljava/util/LinkedList;", "Lcom/tencent/biz/pubaccount/readinjoy/webarticle/RIJWebArticlePreloadUtil$PreloadData;", "isInPreloadList", "", "url", "preload", "", "articleInfo", "Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;", "preloadImpInWebProcess", "warmUpTemplateInWebProcess", "PreloadData", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class RIJWebArticlePreloadUtil
{
  public static final RIJWebArticlePreloadUtil a;
  private static final LinkedList<RIJWebArticlePreloadUtil.PreloadData> a;
  
  static
  {
    jdField_a_of_type_ComTencentBizPubaccountReadinjoyWebarticleRIJWebArticlePreloadUtil = new RIJWebArticlePreloadUtil();
    jdField_a_of_type_JavaUtilLinkedList = new LinkedList();
  }
  
  private final boolean a(String paramString)
  {
    if ((TextUtils.isEmpty((CharSequence)paramString)) || (jdField_a_of_type_JavaUtilLinkedList.size() <= 0)) {
      return false;
    }
    Iterator localIterator = jdField_a_of_type_JavaUtilLinkedList.iterator();
    while (localIterator.hasNext())
    {
      RIJWebArticlePreloadUtil.PreloadData localPreloadData = (RIJWebArticlePreloadUtil.PreloadData)localIterator.next();
      if (TextUtils.equals((CharSequence)paramString, (CharSequence)localPreloadData.a())) {
        return true;
      }
    }
    return false;
  }
  
  public final void a()
  {
    if (!RIJWebArticleUtil.a.f())
    {
      QLog.i("RIJWebArticlePreloadUtil", 1, "[warmUpTemplateInWebProcess] warm up template switch is off.");
      return;
    }
    Runnable localRunnable = (Runnable)RIJWebArticlePreloadUtil.warmUpTemplateInWebProcess.runnable.1.a;
    ThreadManager.getSubThreadHandler().post(localRunnable);
  }
  
  public final void a(@NotNull BaseArticleInfo paramBaseArticleInfo)
  {
    Intrinsics.checkParameterIsNotNull(paramBaseArticleInfo, "articleInfo");
    if (!RIJWebArticleUtil.a.e())
    {
      QLog.i("RIJWebArticlePreloadUtil", 2, "[preload] web article preload switch is off.");
      return;
    }
    if ((RIJFeedsType.a(paramBaseArticleInfo)) || (TextUtils.isEmpty((CharSequence)paramBaseArticleInfo.mArticleContentUrl)))
    {
      QLog.i("RIJWebArticlePreloadUtil", 2, "[preload] article is video or url is empty.");
      return;
    }
    Object localObject = ReadInJoyUtils.a();
    if (localObject == null) {
      throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
    }
    localObject = (ReadInJoyLogicManager)((QQAppInterface)localObject).getManager(QQManagerFactory.READINJOY_LOGIC_MANAGER);
    if (localObject != null)
    {
      localObject = ((ReadInJoyLogicManager)localObject).a();
      if ((localObject != null) && (((ReadInJoyLogicEngine)localObject).a(paramBaseArticleInfo.mArticleID) == true))
      {
        QLog.i("RIJWebArticlePreloadUtil", 1, "[preload] article has been read, do not preload.");
        return;
      }
    }
    paramBaseArticleInfo = (Runnable)new RIJWebArticlePreloadUtil.preload.runnable.1(RIJWebArticleOptimizeUtil.a.a(paramBaseArticleInfo.mArticleContentUrl));
    ThreadManager.getSubThreadHandler().post(paramBaseArticleInfo);
  }
  
  public final void a(@Nullable String paramString)
  {
    paramString = (Runnable)new RIJWebArticlePreloadUtil.preloadImpInWebProcess.runnable.1(paramString);
    ThreadManager.getSubThreadHandler().post(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.webarticle.RIJWebArticlePreloadUtil
 * JD-Core Version:    0.7.0.1
 */