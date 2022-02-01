package com.tencent.hippy.qq.view.tkd.fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyChannelActivity.SerializableMap;
import com.tencent.biz.pubaccount.readinjoy.comment.ReadInJoyCommentListFragment.HippyCommentPageListener;
import com.tencent.biz.pubaccount.readinjoy.comment.ReadInJoyCommentTopGestureLayout;
import com.tencent.biz.pubaccount.readinjoy.comment.ReadInJoyCommentUtils;
import com.tencent.biz.pubaccount.readinjoy.comment.data.AnchorData;
import com.tencent.biz.pubaccount.readinjoy.comment.topic.RIJCommentTopicUtil;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebPTSUtils;
import com.tencent.biz.pubaccount.readinjoy.viola.ViolaFragment;
import com.tencent.biz.pubaccount.readinjoy.viola.delegate.ViolaUiDelegate;
import com.tencent.hippy.qq.app.HippyQQEngine;
import com.tencent.hippy.qq.app.TKDHippyEngine;
import com.tencent.hippy.qq.fragment.HippyActivityLifecycleDispatcher;
import com.tencent.hippy.qq.fragment.HippyActivityLifecycleOwner;
import com.tencent.hippy.qq.utils.tkd.TKDCommentDispatcher;
import com.tencent.hippy.qq.utils.tkd.TKDCommentDispatcher.HippyCommentEvent;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.views.list.HippyListView;
import com.tencent.mtt.supportui.views.recyclerview.RecyclerView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/hippy/qq/view/tkd/fragment/TKDCommentFragment;", "Lcom/tencent/biz/pubaccount/readinjoy/viola/ViolaFragment;", "Lcom/tencent/hippy/qq/fragment/HippyActivityLifecycleOwner;", "()V", "adTag", "", "getAdTag", "()I", "setAdTag", "(I)V", "anchorData", "Lcom/tencent/biz/pubaccount/readinjoy/comment/data/AnchorData;", "getAnchorData", "()Lcom/tencent/biz/pubaccount/readinjoy/comment/data/AnchorData;", "setAnchorData", "(Lcom/tencent/biz/pubaccount/readinjoy/comment/data/AnchorData;)V", "articleInfo", "Lcom/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo;", "getArticleInfo", "()Lcom/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo;", "setArticleInfo", "(Lcom/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo;)V", "biuType", "getBiuType", "setBiuType", "commentEventListener", "Lcom/tencent/hippy/qq/utils/tkd/TKDCommentDispatcher$HippyCommentEvent;", "getCommentEventListener", "()Lcom/tencent/hippy/qq/utils/tkd/TKDCommentDispatcher$HippyCommentEvent;", "commentState", "getCommentState", "setCommentState", "commentTopGestureLayout", "Lcom/tencent/biz/pubaccount/readinjoy/comment/ReadInJoyCommentTopGestureLayout;", "getCommentTopGestureLayout", "()Lcom/tencent/biz/pubaccount/readinjoy/comment/ReadInJoyCommentTopGestureLayout;", "setCommentTopGestureLayout", "(Lcom/tencent/biz/pubaccount/readinjoy/comment/ReadInJoyCommentTopGestureLayout;)V", "container", "Landroid/view/ViewGroup;", "getContainer", "()Landroid/view/ViewGroup;", "setContainer", "(Landroid/view/ViewGroup;)V", "contentSrc", "getContentSrc", "setContentSrc", "dispatcher", "Lcom/tencent/hippy/qq/fragment/HippyActivityLifecycleDispatcher;", "hippyCommentPageListener", "Lcom/tencent/biz/pubaccount/readinjoy/comment/ReadInJoyCommentListFragment$HippyCommentPageListener;", "getHippyCommentPageListener", "()Lcom/tencent/biz/pubaccount/readinjoy/comment/ReadInJoyCommentListFragment$HippyCommentPageListener;", "setHippyCommentPageListener", "(Lcom/tencent/biz/pubaccount/readinjoy/comment/ReadInJoyCommentListFragment$HippyCommentPageListener;)V", "isEdit", "", "()Z", "setEdit", "(Z)V", "createHippyQQEngine", "Lcom/tencent/hippy/qq/app/HippyQQEngine;", "moduleName", "", "getDispatcher", "getHippyListView", "Lcom/tencent/mtt/hippy/views/list/HippyListView;", "viewGroup", "getJsPropsMap", "Lcom/tencent/mtt/hippy/common/HippyMap;", "getPropsMap", "initAfterVisible", "", "bundle", "Landroid/os/Bundle;", "contentView", "onActivityCreated", "savedInstanceState", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onBackPress", "onCreateFragment", "onDestroy", "onDestroyView", "onHippyPageLoad", "isSuccess", "errMsg", "onPause", "onResume", "onSaveInstanceState", "outState", "onStart", "onStop", "setGestureLayout", "shouldFinishActivity", "Companion", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class TKDCommentFragment
  extends ViolaFragment
  implements HippyActivityLifecycleOwner
{
  public static final TKDCommentFragment.Companion Companion = new TKDCommentFragment.Companion(null);
  private static final int FLAG_COMMENT_FIRST = 0;
  private static final int FLAG_COMMENT_OTHER = -1;
  private static final int FLAG_COMMENT_SECOND = 1;
  @NotNull
  private static final String MODULE_NAME = "TKDComment";
  @NotNull
  private static final String TAG = "TKDCommentFragment";
  private HashMap _$_findViewCache;
  private int adTag;
  @Nullable
  private AnchorData anchorData;
  @Nullable
  private ArticleInfo articleInfo;
  private int biuType;
  @NotNull
  private final TKDCommentDispatcher.HippyCommentEvent commentEventListener = (TKDCommentDispatcher.HippyCommentEvent)new TKDCommentFragment.commentEventListener.1(this);
  private int commentState = FLAG_COMMENT_FIRST;
  @Nullable
  private ReadInJoyCommentTopGestureLayout commentTopGestureLayout;
  @Nullable
  private ViewGroup container;
  private int contentSrc;
  private final HippyActivityLifecycleDispatcher dispatcher = new HippyActivityLifecycleDispatcher();
  @Nullable
  private ReadInJoyCommentListFragment.HippyCommentPageListener hippyCommentPageListener;
  private boolean isEdit;
  
  static
  {
    MODULE_NAME = "TKDComment";
  }
  
  @JvmStatic
  @NotNull
  public static final TKDCommentFragment create(@Nullable String paramString, @Nullable ReadInJoyChannelActivity.SerializableMap paramSerializableMap, boolean paramBoolean)
  {
    return Companion.create(paramString, paramSerializableMap, paramBoolean);
  }
  
  @JvmStatic
  private static final TKDCommentFragment newInstance(Bundle paramBundle)
  {
    return TKDCommentFragment.Companion.access$newInstance(Companion, paramBundle);
  }
  
  public void _$_clearFindViewByIdCache()
  {
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
  }
  
  public View _$_findCachedViewById(int paramInt)
  {
    if (this._$_findViewCache == null) {
      this._$_findViewCache = new HashMap();
    }
    View localView2 = (View)this._$_findViewCache.get(Integer.valueOf(paramInt));
    View localView1 = localView2;
    if (localView2 == null)
    {
      localView1 = getView();
      if (localView1 == null) {
        localView1 = null;
      }
    }
    else
    {
      return localView1;
    }
    localView1 = localView1.findViewById(paramInt);
    this._$_findViewCache.put(Integer.valueOf(paramInt), localView1);
    return localView1;
  }
  
  @NotNull
  public HippyQQEngine createHippyQQEngine(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "moduleName");
    return (HippyQQEngine)new TKDHippyEngine((Fragment)this, paramString, getUrl());
  }
  
  public final int getAdTag()
  {
    return this.adTag;
  }
  
  @Nullable
  public final AnchorData getAnchorData()
  {
    return this.anchorData;
  }
  
  @Nullable
  public final ArticleInfo getArticleInfo()
  {
    return this.articleInfo;
  }
  
  public final int getBiuType()
  {
    return this.biuType;
  }
  
  @NotNull
  public final TKDCommentDispatcher.HippyCommentEvent getCommentEventListener()
  {
    return this.commentEventListener;
  }
  
  public final int getCommentState()
  {
    return this.commentState;
  }
  
  @Nullable
  public final ReadInJoyCommentTopGestureLayout getCommentTopGestureLayout()
  {
    return this.commentTopGestureLayout;
  }
  
  @Nullable
  public final ViewGroup getContainer()
  {
    return this.container;
  }
  
  public final int getContentSrc()
  {
    return this.contentSrc;
  }
  
  @NotNull
  public HippyActivityLifecycleDispatcher getDispatcher()
  {
    return this.dispatcher;
  }
  
  @Nullable
  public final ReadInJoyCommentListFragment.HippyCommentPageListener getHippyCommentPageListener()
  {
    return this.hippyCommentPageListener;
  }
  
  @Nullable
  public final HippyListView getHippyListView(@Nullable ViewGroup paramViewGroup)
  {
    if (paramViewGroup != null)
    {
      int j = paramViewGroup.getChildCount();
      int i = 0;
      while (i < j)
      {
        Object localObject = paramViewGroup.getChildAt(i);
        if ((localObject instanceof HippyListView)) {
          localObject = (HippyListView)localObject;
        }
        HippyListView localHippyListView;
        do
        {
          return localObject;
          if (!(localObject instanceof ViewGroup)) {
            break;
          }
          localHippyListView = getHippyListView((ViewGroup)localObject);
          localObject = localHippyListView;
        } while ((localHippyListView instanceof HippyListView));
        i += 1;
      }
    }
    return null;
  }
  
  @NotNull
  public final HippyMap getJsPropsMap()
  {
    return getPropsMap();
  }
  
  @NotNull
  public HippyMap getPropsMap()
  {
    int j = 0;
    Object localObject2 = null;
    HippyMap localHippyMap = new HippyMap();
    Object localObject1;
    if (this.articleInfo != null)
    {
      localObject1 = ReadInJoyCommentUtils.a(this.articleInfo, null);
      Object localObject3 = ((Pair)localObject1).first;
      Intrinsics.checkExpressionValueIsNotNull(localObject3, "biuTypeAndAdTag.first");
      this.biuType = ((Number)localObject3).intValue();
      localObject1 = ((Pair)localObject1).second;
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "biuTypeAndAdTag.second");
      this.adTag = ((Number)localObject1).intValue();
      localObject1 = this.articleInfo;
      if (localObject1 == null) {
        break label345;
      }
      localObject1 = ((ArticleInfo)localObject1).innerUniqueID;
      localHippyMap.pushString("rowkey", (String)localObject1);
      localObject1 = this.articleInfo;
      if (localObject1 == null) {
        break label350;
      }
      localObject1 = Long.valueOf(((ArticleInfo)localObject1).mArticleID);
      label119:
      localHippyMap.pushString("articleId", String.valueOf(localObject1));
      localHippyMap.pushInt("contentSrcType", this.contentSrc);
      localHippyMap.pushString("reportData", "{1," + this.contentSrc + '}');
      localObject3 = this.anchorData;
      localObject1 = localObject2;
      if (localObject3 != null) {
        localObject1 = ((AnchorData)localObject3).jdField_a_of_type_JavaLangString;
      }
      localHippyMap.pushString("anchorFirstCommentId", (String)localObject1);
      localHippyMap.pushDouble("fontScale", FastWebPTSUtils.a().floatValue());
      if (!this.isEdit) {
        break label355;
      }
      i = 1;
      label232:
      localHippyMap.pushInt("isEdit", i);
      localHippyMap.pushBoolean("topicSwitch", RIJCommentTopicUtil.a());
      localObject1 = this.anchorData;
      if (localObject1 != null)
      {
        localHippyMap.pushString("anchorSubCommentId", ((AnchorData)localObject1).jdField_b_of_type_JavaLangString);
        if (!((AnchorData)localObject1).jdField_b_of_type_Boolean) {
          break label360;
        }
      }
    }
    label345:
    label350:
    label355:
    label360:
    for (int i = 0;; i = 1)
    {
      localHippyMap.pushInt("defaultCommentType", i);
      i = j;
      if (((AnchorData)localObject1).jdField_a_of_type_Boolean) {
        i = 1;
      }
      localHippyMap.pushInt("isAwesome", i);
      QLog.d(TAG, 1, "pros: " + localHippyMap.toString());
      return localHippyMap;
      localObject1 = null;
      break;
      localObject1 = null;
      break label119;
      i = 0;
      break label232;
    }
  }
  
  public void initAfterVisible(@Nullable Bundle paramBundle, @Nullable ViewGroup paramViewGroup)
  {
    ViolaUiDelegate localViolaUiDelegate = this.mViolaUiDelegate;
    if (localViolaUiDelegate != null) {
      localViolaUiDelegate.a(false);
    }
    super.initAfterVisible(paramBundle, paramViewGroup);
    if (paramViewGroup != null) {
      paramViewGroup.setBackgroundColor(0);
    }
  }
  
  public final boolean isEdit()
  {
    return this.isEdit;
  }
  
  public void onActivityCreated(@Nullable Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    TKDCommentDispatcher.INSTANCE.addEventListener(this.commentEventListener);
    this.dispatcher.onActivityCreated((Activity)getActivity(), paramBundle);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, @Nullable Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    this.dispatcher.onActivityResult((Activity)getActivity(), paramInt1, paramInt2, paramIntent);
  }
  
  public final boolean onBackPress()
  {
    TKDCommentDispatcher.INSTANCE.getEvent().jScloseComment();
    return this.commentState == FLAG_COMMENT_SECOND;
  }
  
  public void onCreateFragment(@NotNull ViewGroup paramViewGroup)
  {
    Intrinsics.checkParameterIsNotNull(paramViewGroup, "container");
    this.container = paramViewGroup;
    super.onCreateFragment(paramViewGroup);
    setGestureLayout();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    TKDCommentDispatcher.INSTANCE.removeEventListener(this.commentEventListener);
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    this.dispatcher.onActivityDestroyed((Activity)getActivity());
    _$_clearFindViewByIdCache();
  }
  
  public boolean onHippyPageLoad(boolean paramBoolean, @Nullable String paramString)
  {
    QLog.d(TAG, 1, "[onHippyPageLoad] isSuccess:" + paramBoolean + ", errMsg:" + paramString);
    paramString = this.hippyCommentPageListener;
    if (paramString != null) {
      paramString.a(paramBoolean);
    }
    return !paramBoolean;
  }
  
  public void onPause()
  {
    super.onPause();
    this.dispatcher.onActivityPaused((Activity)getActivity());
  }
  
  public void onResume()
  {
    super.onResume();
    this.dispatcher.onActivityResumed((Activity)getActivity());
  }
  
  public void onSaveInstanceState(@Nullable Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    this.dispatcher.onActivitySaveInstanceState((Activity)getActivity(), paramBundle);
  }
  
  public void onStart()
  {
    super.onStart();
    this.dispatcher.onActivityStarted((Activity)getActivity());
  }
  
  public void onStop()
  {
    super.onStop();
    this.dispatcher.onActivityStopped((Activity)getActivity());
  }
  
  public final void setAdTag(int paramInt)
  {
    this.adTag = paramInt;
  }
  
  public final void setAnchorData(@Nullable AnchorData paramAnchorData)
  {
    this.anchorData = paramAnchorData;
  }
  
  public final void setArticleInfo(@Nullable ArticleInfo paramArticleInfo)
  {
    this.articleInfo = paramArticleInfo;
  }
  
  public final void setBiuType(int paramInt)
  {
    this.biuType = paramInt;
  }
  
  public final void setCommentState(int paramInt)
  {
    this.commentState = paramInt;
  }
  
  public final void setCommentTopGestureLayout(@Nullable ReadInJoyCommentTopGestureLayout paramReadInJoyCommentTopGestureLayout)
  {
    this.commentTopGestureLayout = paramReadInJoyCommentTopGestureLayout;
  }
  
  public final void setContainer(@Nullable ViewGroup paramViewGroup)
  {
    this.container = paramViewGroup;
  }
  
  public final void setContentSrc(int paramInt)
  {
    this.contentSrc = paramInt;
  }
  
  public final void setEdit(boolean paramBoolean)
  {
    this.isEdit = paramBoolean;
  }
  
  public final void setGestureLayout()
  {
    ReadInJoyCommentTopGestureLayout localReadInJoyCommentTopGestureLayout = this.commentTopGestureLayout;
    if (localReadInJoyCommentTopGestureLayout != null) {
      if (this.commentState != FLAG_COMMENT_FIRST) {
        break label64;
      }
    }
    label64:
    for (boolean bool = true;; bool = false)
    {
      localReadInJoyCommentTopGestureLayout.setIsFirstCommentView(bool);
      if (this.commentState == FLAG_COMMENT_FIRST)
      {
        localReadInJoyCommentTopGestureLayout = this.commentTopGestureLayout;
        if (localReadInJoyCommentTopGestureLayout != null) {
          localReadInJoyCommentTopGestureLayout.setRecyclerView((RecyclerView)getHippyListView((ViewGroup)this.commentTopGestureLayout));
        }
      }
      return;
    }
  }
  
  public final void setHippyCommentPageListener(@Nullable ReadInJoyCommentListFragment.HippyCommentPageListener paramHippyCommentPageListener)
  {
    this.hippyCommentPageListener = paramHippyCommentPageListener;
  }
  
  public boolean shouldFinishActivity()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.hippy.qq.view.tkd.fragment.TKDCommentFragment
 * JD-Core Version:    0.7.0.1
 */