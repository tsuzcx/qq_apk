package com.tencent.aelight.camera.education.api.impl;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import com.tencent.aelight.camera.aioeditor.takevideo.EditPicActivity;
import com.tencent.aelight.camera.aioeditor.takevideo.EditVideoPartManager;
import com.tencent.aelight.camera.aioeditor.takevideo.publish.GenerateContext;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.education.api.IAnswerSearchApi;
import com.tencent.mobileqq.education.api.IEducationUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.os.MqqHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/aelight/camera/education/api/impl/AnswerSearchEditPictureActivity;", "Lcom/tencent/aelight/camera/aioeditor/takevideo/EditPicActivity;", "()V", "editManager", "Lcom/tencent/aelight/camera/education/api/impl/AnswerSearchEditPictureManager;", "checkCropBitmapValid", "", "bitmap", "Landroid/graphics/Bitmap;", "doOnBackPressed", "", "doOnCreate", "savedInstanceState", "Landroid/os/Bundle;", "getPublishIntent", "Landroid/content/Intent;", "generateContext", "Lcom/tencent/aelight/camera/aioeditor/takevideo/publish/GenerateContext;", "goToSearchResult", "saveBitmapToFile", "", "showAnswerSearchResult", "filePath", "aelight_impl_release"}, k=1, mv={1, 1, 16})
public final class AnswerSearchEditPictureActivity
  extends EditPicActivity
{
  private AnswerSearchEditPictureManager a;
  
  private final void a(String paramString)
  {
    ((IAnswerSearchApi)QRoute.api(IAnswerSearchApi.class)).showAnswerSearchResultByFile((Activity)this, paramString, 0);
    finish();
  }
  
  private final boolean b(Bitmap paramBitmap)
  {
    QRouteApi localQRouteApi = QRoute.api(IEducationUtils.class);
    Intrinsics.checkExpressionValueIsNotNull(localQRouteApi, "QRoute.api(IEducationUtils::class.java)");
    paramBitmap = ((IEducationUtils)localQRouteApi).checkBitmapValidSize(paramBitmap, 30, 30);
    Intrinsics.checkExpressionValueIsNotNull(paramBitmap, "bitmapUtils.checkBitmapV…map, minWidth, minHeight)");
    return paramBitmap.booleanValue();
  }
  
  private final String c(Bitmap paramBitmap)
  {
    Object localObject1 = QRoute.api(IEducationUtils.class);
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "QRoute.api(IEducationUtils::class.java)");
    localObject1 = (IEducationUtils)localObject1;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(((IEducationUtils)localObject1).getStudyFileSaveRootPath());
    ((StringBuilder)localObject2).append("answer_search/corp_pic_temp.jpg");
    localObject2 = ((StringBuilder)localObject2).toString();
    paramBitmap = ((IEducationUtils)localObject1).saveBitmapToFile(paramBitmap, (String)localObject2);
    Intrinsics.checkExpressionValueIsNotNull(paramBitmap, "saveResult");
    if (paramBitmap.booleanValue()) {
      return localObject2;
    }
    return "";
  }
  
  public final void a(@NotNull Bitmap paramBitmap)
  {
    Intrinsics.checkParameterIsNotNull(paramBitmap, "bitmap");
    ((IAnswerSearchApi)QRoute.api(IAnswerSearchApi.class)).reportEvent("click#photo_edit_page#confirm_btn", null);
    if (!b(paramBitmap)) {
      return;
    }
    ThreadManager.getSubThreadHandler().post((Runnable)new AnswerSearchEditPictureActivity.goToSearchResult.1(this, paramBitmap));
  }
  
  public void doOnBackPressed()
  {
    finish();
  }
  
  protected boolean doOnCreate(@Nullable Bundle paramBundle)
  {
    this.a = new AnswerSearchEditPictureManager();
    AnswerSearchEditPictureManager localAnswerSearchEditPictureManager = this.a;
    if (localAnswerSearchEditPictureManager == null) {
      Intrinsics.throwUninitializedPropertyAccessException("editManager");
    }
    setEditVideoPartManager((EditVideoPartManager)localAnswerSearchEditPictureManager);
    boolean bool = super.doOnCreate(paramBundle);
    paramBundle = this.a;
    if (paramBundle == null) {
      Intrinsics.throwUninitializedPropertyAccessException("editManager");
    }
    paramBundle.a(this);
    ((IAnswerSearchApi)QRoute.api(IAnswerSearchApi.class)).reportEvent("expose#photo_edit_page#view", null);
    return bool;
  }
  
  @NotNull
  public Intent getPublishIntent(@Nullable GenerateContext paramGenerateContext)
  {
    paramGenerateContext = super.getPublishIntent(paramGenerateContext);
    Intrinsics.checkExpressionValueIsNotNull(paramGenerateContext, "super.getPublishIntent(generateContext)");
    return paramGenerateContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.education.api.impl.AnswerSearchEditPictureActivity
 * JD-Core Version:    0.7.0.1
 */