package com.tencent.biz.pubaccount.readinjoy.popup;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.RecommendFollowInfos;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebPTSDataConverter;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.os.MqqHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/popup/RIJPopupWindowUtil;", "", "()V", "TAG", "", "setCloseBtnListener", "", "bottomDialog", "Lcom/tencent/biz/pubaccount/readinjoy/popup/RIJBottomDialog;", "setRecommendTitle", "articleInfo", "Lcom/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo;", "showFollowRecommendPopup", "context", "Landroid/content/Context;", "activityHashCode", "", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class RIJPopupWindowUtil
{
  public static final RIJPopupWindowUtil a = new RIJPopupWindowUtil();
  
  private final void a(RIJBottomDialog paramRIJBottomDialog)
  {
    Object localObject = paramRIJBottomDialog.a();
    if (localObject != null) {}
    for (localObject = (ImageView)((View)localObject).findViewById(2131363965);; localObject = null)
    {
      if (localObject != null) {
        ((ImageView)localObject).setOnClickListener((View.OnClickListener)new RIJPopupWindowUtil.setCloseBtnListener..inlined.let.lambda.1(paramRIJBottomDialog));
      }
      return;
    }
  }
  
  private final void a(ArticleInfo paramArticleInfo, RIJBottomDialog paramRIJBottomDialog)
  {
    paramRIJBottomDialog = paramRIJBottomDialog.a();
    Object localObject;
    if (paramRIJBottomDialog != null)
    {
      paramRIJBottomDialog = (TextView)paramRIJBottomDialog.findViewById(2131380651);
      StringBuilder localStringBuilder = new StringBuilder().append("[setRecommendTitle] recommendTitle = ");
      localObject = paramArticleInfo.mRecommendFollowInfos;
      if (localObject == null) {
        break label118;
      }
      localObject = ((RecommendFollowInfos)localObject).a;
      label47:
      QLog.i("RIJPopupWindowUtil", 1, (String)localObject);
      localObject = paramArticleInfo.mRecommendFollowInfos;
      if (localObject == null) {
        break label123;
      }
      localObject = ((RecommendFollowInfos)localObject).a;
      label76:
      if ((!TextUtils.isEmpty((CharSequence)localObject)) && (paramRIJBottomDialog != null))
      {
        paramArticleInfo = paramArticleInfo.mRecommendFollowInfos;
        if (paramArticleInfo == null) {
          break label128;
        }
      }
    }
    label128:
    for (paramArticleInfo = paramArticleInfo.a;; paramArticleInfo = null)
    {
      paramRIJBottomDialog.setText((CharSequence)paramArticleInfo);
      return;
      paramRIJBottomDialog = null;
      break;
      label118:
      localObject = null;
      break label47;
      label123:
      localObject = null;
      break label76;
    }
  }
  
  public final void a(@Nullable Context paramContext, @NotNull ArticleInfo paramArticleInfo, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramArticleInfo, "articleInfo");
    if (!FastWebPTSDataConverter.a(paramArticleInfo))
    {
      QLog.i("RIJPopupWindowUtil", 1, "showFollowRecommendPopup error! no recommend data!");
      return;
    }
    if ((paramContext == null) || (paramInt != paramContext.hashCode()) || (((paramContext instanceof Activity)) && (((Activity)paramContext).isFinishing())))
    {
      QLog.i("RIJPopupWindowUtil", 1, "showFollowRecommendPopup error! activity changed or finishing!");
      return;
    }
    ThreadManager.getUIHandler().post((Runnable)new RIJPopupWindowUtil.showFollowRecommendPopup.1(paramContext, paramArticleInfo));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.popup.RIJPopupWindowUtil
 * JD-Core Version:    0.7.0.1
 */