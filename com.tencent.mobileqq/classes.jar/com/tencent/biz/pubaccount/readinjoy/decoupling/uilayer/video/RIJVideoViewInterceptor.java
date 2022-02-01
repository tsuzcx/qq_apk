package com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.video;

import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.RIJViewInterceptor;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util.RIJFeedsType;
import com.tencent.biz.pubaccount.readinjoy.imageopt.RIJImageTypeOptHelper;
import com.tencent.biz.pubaccount.readinjoy.model.FollowListInfoModule;
import com.tencent.biz.pubaccount.readinjoy.model.FollowListInfoModule.FollowStatusObserver;
import com.tencent.biz.pubaccount.readinjoy.model.ReadInJoyUserInfoModule;
import com.tencent.biz.pubaccount.readinjoy.model.ReadInJoyUserInfoModule.RefreshUserInfoCallBack;
import com.tencent.biz.pubaccount.readinjoy.model.UserOperationModule;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ReadInJoyUserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.imageloader.IBitmapCallback;
import com.tencent.biz.pubaccount.readinjoy.view.imageloader.ImageManager;
import com.tencent.biz.pubaccount.readinjoy.view.imageloader.ImageRequest;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.os.MqqHandler;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/decoupling/uilayer/video/RIJVideoViewInterceptor;", "Lcom/tencent/biz/pubaccount/readinjoy/decoupling/uilayer/framewrok/RIJViewInterceptor;", "()V", "fetchFollowStatus", "", "articleInfo", "Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;", "innerPreloadAvatar", "onBindView", "position", "", "preloadAvatarByImageManager", "avatarUrl", "", "preloadData", "userInfo", "Lcom/tencent/biz/pubaccount/readinjoy/struct/ReadInJoyUserInfo;", "shouldIntercept", "", "Companion", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class RIJVideoViewInterceptor
  implements RIJViewInterceptor
{
  public static final RIJVideoViewInterceptor.Companion a = new RIJVideoViewInterceptor.Companion(null);
  
  private final void a(BaseArticleInfo paramBaseArticleInfo)
  {
    ThreadManager.getUIHandler().post((Runnable)new RIJVideoViewInterceptor.preloadData.1(this, paramBaseArticleInfo));
  }
  
  private final void a(ReadInJoyUserInfo paramReadInJoyUserInfo, BaseArticleInfo paramBaseArticleInfo)
  {
    paramReadInJoyUserInfo = ReadInJoyUserInfoModule.a(paramReadInJoyUserInfo);
    Intrinsics.checkExpressionValueIsNotNull(paramReadInJoyUserInfo, "headUrl");
    a(paramReadInJoyUserInfo);
    paramBaseArticleInfo.preloadAvatarUrl = paramReadInJoyUserInfo;
    if (QLog.isColorLevel()) {
      QLog.d("RIJVideoViewInterceptor", 2, "preloadAvatarByImageManager url:" + paramBaseArticleInfo.preloadAvatarUrl + " title:" + paramBaseArticleInfo.mTitle);
    }
  }
  
  private final void a(String paramString)
  {
    if (!TextUtils.isEmpty((CharSequence)paramString)) {}
    try
    {
      ImageRequest localImageRequest = new ImageRequest();
      localImageRequest.b = true;
      RIJImageTypeOptHelper.a.a(localImageRequest, paramString);
      ImageManager.a().a(localImageRequest, (IBitmapCallback)new RIJVideoViewInterceptor.preloadAvatarByImageManager.1(paramString));
      return;
    }
    catch (Exception paramString)
    {
      QLog.e("RIJVideoViewInterceptor", 1, "preloadAvatarByImageManager exception", (Throwable)paramString);
    }
  }
  
  private final void b(BaseArticleInfo paramBaseArticleInfo)
  {
    Object localObject = paramBaseArticleInfo.getSubscribeUin();
    if (TextUtils.isEmpty((CharSequence)localObject)) {}
    do
    {
      ReadInJoyUserInfoModule localReadInJoyUserInfoModule;
      do
      {
        return;
        localReadInJoyUserInfoModule = UserOperationModule.a();
      } while (localReadInJoyUserInfoModule == null);
      List localList = (List)new ArrayList();
      Intrinsics.checkExpressionValueIsNotNull(localObject, "uin");
      localList.add(localObject);
      localObject = localReadInJoyUserInfoModule.a(localList, (ReadInJoyUserInfoModule.RefreshUserInfoCallBack)new RIJVideoViewInterceptor.innerPreloadAvatar.userInfo.1(this, paramBaseArticleInfo));
    } while (!(localObject instanceof ReadInJoyUserInfo));
    a((ReadInJoyUserInfo)localObject, paramBaseArticleInfo);
  }
  
  private final void c(BaseArticleInfo paramBaseArticleInfo)
  {
    if (paramBaseArticleInfo.hasRequestFollowStatus) {
      return;
    }
    FollowListInfoModule.a(paramBaseArticleInfo.getSubscribeUin(), (FollowListInfoModule.FollowStatusObserver)new RIJVideoViewInterceptor.fetchFollowStatus.1(paramBaseArticleInfo));
  }
  
  public void a(@NotNull BaseArticleInfo paramBaseArticleInfo, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramBaseArticleInfo, "articleInfo");
    a(paramBaseArticleInfo);
    if (paramBaseArticleInfo.mSubArtilceList != null)
    {
      Object localObject = paramBaseArticleInfo.mSubArtilceList;
      Intrinsics.checkExpressionValueIsNotNull(localObject, "articleInfo.mSubArtilceList");
      if (!((Collection)localObject).isEmpty()) {}
      for (paramInt = 1; paramInt != 0; paramInt = 0)
      {
        paramBaseArticleInfo = paramBaseArticleInfo.mSubArtilceList.iterator();
        while (paramBaseArticleInfo.hasNext())
        {
          localObject = (ArticleInfo)paramBaseArticleInfo.next();
          Intrinsics.checkExpressionValueIsNotNull(localObject, "info");
          a((BaseArticleInfo)localObject);
        }
      }
    }
  }
  
  public boolean a(@NotNull BaseArticleInfo paramBaseArticleInfo)
  {
    Intrinsics.checkParameterIsNotNull(paramBaseArticleInfo, "articleInfo");
    return RIJFeedsType.v(paramBaseArticleInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.video.RIJVideoViewInterceptor
 * JD-Core Version:    0.7.0.1
 */