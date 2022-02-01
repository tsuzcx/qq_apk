package com.tencent.aelight.camera.ae.gif;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import android.widget.TextView;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelProvider;
import com.tencent.aelight.camera.ae.AEPituCameraUnit;
import com.tencent.aelight.camera.ae.AEViewModelProviders;
import com.tencent.aelight.camera.ae.config.CameraOperationHelper;
import com.tencent.aelight.camera.ae.data.AEGifCategoryWrapper;
import com.tencent.aelight.camera.ae.data.AEGifMaterialManager;
import com.tencent.aelight.camera.ae.data.AEMaterialWrapper;
import com.tencent.aelight.camera.ae.font.AEFontManager;
import com.tencent.aelight.camera.ae.gif.giftext.adapter.AEGIFStickerAdapter;
import com.tencent.aelight.camera.ae.mode.AECaptureMode;
import com.tencent.aelight.camera.ae.mode.AEVideoStoryCaptureModeViewModel;
import com.tencent.aelight.camera.ae.part.AEVideoStoryStateViewModel;
import com.tencent.aelight.camera.ae.part.VideoStoryBasePart;
import com.tencent.aelight.camera.ae.part.VideoStoryCapturePartManager;
import com.tencent.aelight.camera.ae.report.AEBaseDataReporter;
import com.tencent.aelight.camera.ae.report.AEBaseReportParam;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.biz.videostory.animator.AnimationBuilder;
import com.tencent.biz.videostory.animator.ViewAnimator;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.widget.AbsSlidingIndicator.OnTabListener;
import com.tencent.mobileqq.widget.SimpleSlidingIndicator;
import com.tencent.ttpic.baseutils.collection.CollectionUtils;
import java.util.LinkedList;
import java.util.List;

public class AEGIFStickerListPart
  extends VideoStoryBasePart
  implements AbsSlidingIndicator.OnTabListener
{
  private Context a;
  private AEPituCameraUnit b;
  private AEVideoStoryCaptureModeViewModel c;
  private AEVideoStoryStateViewModel d;
  private AEVideoStoryGIFTplViewModel e;
  private SimpleSlidingIndicator f;
  private Pair<String[], int[]> g;
  private List<AEGifCategoryWrapper> h;
  private RecyclerView i;
  private LinearLayoutManager j;
  private AEGIFStickerAdapter k;
  private List<AEMaterialWrapper> l;
  private String m;
  private String n;
  private String o;
  private Dialog p;
  private boolean q = false;
  private boolean r = false;
  
  public AEGIFStickerListPart(Activity paramActivity, View paramView, VideoStoryCapturePartManager paramVideoStoryCapturePartManager)
  {
    super(paramActivity, paramView, paramVideoStoryCapturePartManager);
    this.a = paramView.getContext();
    this.b = ((AEPituCameraUnit)paramVideoStoryCapturePartManager.a(65537, new Object[0]));
  }
  
  @Nullable
  private Pair<Integer, Integer> a(@NonNull List<AEGifCategoryWrapper> paramList)
  {
    if (paramList.size() == 0) {
      return null;
    }
    Object localObject = (AEGifCategoryWrapper)paramList.get(0);
    if (CollectionUtils.isEmpty(((AEGifCategoryWrapper)localObject).materialWrapperList)) {
      return null;
    }
    if ((((AEGifCategoryWrapper)localObject).materialWrapperList.get(0) != null) && (((AEMaterialWrapper)((AEGifCategoryWrapper)localObject).materialWrapperList.get(0)).g != 1))
    {
      AEMaterialWrapper localAEMaterialWrapper = new AEMaterialWrapper();
      localAEMaterialWrapper.g = 1;
      localAEMaterialWrapper.a = "none";
      ((AEGifCategoryWrapper)localObject).materialWrapperList.add(0, localAEMaterialWrapper);
    }
    localObject = b(paramList);
    if ((localObject != null) && (((Pair)localObject).first != null) && (((Pair)localObject).second != null))
    {
      ((AEGifCategoryWrapper)paramList.get(((Integer)((Pair)localObject).first).intValue())).selected = true;
      return localObject;
    }
    ((AEGifCategoryWrapper)paramList.get(0)).selected = true;
    return localObject;
  }
  
  private void a()
  {
    this.c = ((AEVideoStoryCaptureModeViewModel)AEViewModelProviders.a(this.b).get(AEVideoStoryCaptureModeViewModel.class));
    this.c.a.observe(this.b, new AEGIFStickerListPart.2(this));
    this.c.c.observe(this.b, new AEGIFStickerListPart.3(this));
    this.d = ((AEVideoStoryStateViewModel)AEViewModelProviders.a(this.b).get(AEVideoStoryStateViewModel.class));
    this.d.a().observe(this.b, new AEGIFStickerListPart.4(this));
    this.e = ((AEVideoStoryGIFTplViewModel)AEViewModelProviders.a(this.b).get(AEVideoStoryGIFTplViewModel.class));
    this.e.a().observe(this.b, new AEGIFStickerListPart.5(this));
    CameraOperationHelper.c().observe(this.b, new AEGIFStickerListPart.6(this));
    CameraOperationHelper.e().observe(this.b, new AEGIFStickerListPart.7(this));
    if (!this.q) {
      AEGifMaterialManager.a().b();
    }
  }
  
  private void a(@NonNull Intent paramIntent)
  {
    String str = paramIntent.getStringExtra("KEY_CURRENT_SELECT_ID");
    paramIntent = paramIntent.getStringExtra("KEY_CURRENT_TAB");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[initTakeSame], bottomTab=");
    localStringBuilder.append(paramIntent);
    localStringBuilder.append(", materialId=");
    localStringBuilder.append(str);
    AEQLog.a("AEGIFStickerListPart", localStringBuilder.toString());
    this.q = a(paramIntent, str);
    if (this.q)
    {
      this.o = str;
      c();
    }
  }
  
  private void a(@Nullable AEMaterialWrapper paramAEMaterialWrapper)
  {
    this.e.c(paramAEMaterialWrapper);
    if (paramAEMaterialWrapper == null)
    {
      this.e.b(null);
      this.o = null;
      return;
    }
    this.o = paramAEMaterialWrapper.a;
    int i1 = paramAEMaterialWrapper.f;
    if (i1 != 0)
    {
      if (i1 != 2) {
        return;
      }
      this.e.b(paramAEMaterialWrapper);
      return;
    }
    this.e.a(paramAEMaterialWrapper);
  }
  
  private void a(@Nullable String paramString)
  {
    AEVideoStoryGIFTplViewModel localAEVideoStoryGIFTplViewModel = this.e;
    if (localAEVideoStoryGIFTplViewModel != null) {
      localAEVideoStoryGIFTplViewModel.d().postValue(paramString);
    }
    if (!TextUtils.isEmpty(paramString))
    {
      if (AEFontManager.a().a(paramString) != Typeface.DEFAULT) {
        return;
      }
      ThreadManager.excute(new AEGIFStickerListPart.9(this, paramString), 64, null, false);
    }
  }
  
  private boolean a(@Nullable String paramString1, @Nullable String paramString2)
  {
    return (!TextUtils.isEmpty(paramString1)) && (AECaptureMode.GIF.name.equals(paramString1)) && (!TextUtils.isEmpty(paramString2));
  }
  
  @Nullable
  private Pair<Integer, Integer> b(@NonNull List<AEGifCategoryWrapper> paramList)
  {
    if (TextUtils.isEmpty(this.o))
    {
      AEQLog.b("AEGIFStickerListPart", "[findLastSelectedPosition] mPendingApplyGIFId is empty");
      return null;
    }
    boolean bool = TextUtils.isEmpty(this.m);
    int i3 = -1;
    if (!bool)
    {
      i1 = 0;
      while (i1 < paramList.size())
      {
        localObject1 = (AEGifCategoryWrapper)paramList.get(i1);
        if ((localObject1 != null) && (!TextUtils.isEmpty(((AEGifCategoryWrapper)localObject1).categoryId)) && (((AEGifCategoryWrapper)localObject1).categoryId.equals(this.m))) {
          break label110;
        }
        i1 += 1;
      }
    }
    Object localObject1 = null;
    int i1 = -1;
    label110:
    if ((localObject1 != null) && (!CollectionUtils.isEmpty(((AEGifCategoryWrapper)localObject1).materialWrapperList)))
    {
      i2 = 0;
      while (i2 < ((AEGifCategoryWrapper)localObject1).materialWrapperList.size())
      {
        localObject2 = (AEMaterialWrapper)((AEGifCategoryWrapper)localObject1).materialWrapperList.get(i2);
        if ((localObject2 != null) && (!TextUtils.isEmpty(((AEMaterialWrapper)localObject2).a)) && (((AEMaterialWrapper)localObject2).a.equals(this.o)))
        {
          localObject1 = localObject2;
          break label212;
        }
        i2 += 1;
      }
    }
    localObject1 = null;
    int i2 = i3;
    label212:
    if (localObject1 == null)
    {
      i3 = i1;
      int i5 = 0;
      i1 = i2;
      i2 = i3;
      for (;;)
      {
        i3 = i2;
        i4 = i1;
        localObject2 = localObject1;
        if (i5 >= paramList.size()) {
          break;
        }
        AEGifCategoryWrapper localAEGifCategoryWrapper = (AEGifCategoryWrapper)paramList.get(i5);
        int i6 = i2;
        int i7 = i1;
        Object localObject3 = localObject1;
        if (localAEGifCategoryWrapper != null) {
          if (CollectionUtils.isEmpty(localAEGifCategoryWrapper.materialWrapperList))
          {
            i6 = i2;
            i7 = i1;
            localObject3 = localObject1;
          }
          else
          {
            i6 = 0;
            for (;;)
            {
              i3 = i2;
              i4 = i1;
              localObject2 = localObject1;
              if (i6 >= localAEGifCategoryWrapper.materialWrapperList.size()) {
                break;
              }
              localObject2 = (AEMaterialWrapper)localAEGifCategoryWrapper.materialWrapperList.get(i6);
              if ((localObject2 != null) && (!TextUtils.isEmpty(((AEMaterialWrapper)localObject2).a)) && (((AEMaterialWrapper)localObject2).a.equals(this.o)))
              {
                i3 = i5;
                i4 = i6;
                break;
              }
              i6 += 1;
            }
            i6 = i3;
            i7 = i4;
            localObject3 = localObject2;
            if (localObject2 != null) {
              break;
            }
          }
        }
        i5 += 1;
        i2 = i6;
        i1 = i7;
        localObject1 = localObject3;
      }
    }
    Object localObject2 = localObject1;
    int i4 = i2;
    i3 = i1;
    if (localObject2 != null)
    {
      paramList = new StringBuilder();
      paramList.append("[findLastSelectedPosition] found tabPosition=");
      paramList.append(i3);
      paramList.append(", itemPosition=");
      paramList.append(i4);
      AEQLog.b("AEGIFStickerListPart", paramList.toString());
      return new Pair(Integer.valueOf(i3), Integer.valueOf(i4));
    }
    AEQLog.b("AEGIFStickerListPart", "[findLastSelectedPosition] not found");
    return null;
  }
  
  private void b()
  {
    ViewAnimator.a(new View[] { this.f, this.i }).d(new float[] { 0.0F, 1.0F }).a(300L).a(new AEGIFStickerListPart.8(this)).d();
  }
  
  private Pair<String[], int[]> c(@NonNull List<AEGifCategoryWrapper> paramList)
  {
    boolean bool = CollectionUtils.isEmpty(paramList);
    int i1 = 0;
    if (bool) {
      return new Pair(new String[0], new int[0]);
    }
    String[] arrayOfString = new String[paramList.size()];
    int[] arrayOfInt = new int[paramList.size()];
    while (i1 < paramList.size())
    {
      Object localObject = (AEGifCategoryWrapper)paramList.get(i1);
      if ((localObject != null) && (!TextUtils.isEmpty(((AEGifCategoryWrapper)localObject).categoryName))) {
        localObject = ((AEGifCategoryWrapper)localObject).categoryName;
      } else {
        localObject = "";
      }
      arrayOfString[i1] = localObject;
      arrayOfInt[i1] = i1;
      i1 += 1;
    }
    return new Pair(arrayOfString, arrayOfInt);
  }
  
  private void c()
  {
    if ((this.mActivity != null) && (!this.mActivity.isFinishing()))
    {
      if (this.p == null)
      {
        this.p = new Dialog(this.mActivity, 2131953338);
        this.p.setCancelable(true);
        this.p.setCanceledOnTouchOutside(true);
        this.p.setContentView(2131625585);
        ((TextView)this.p.findViewById(2131440191)).setText(2064187671);
        this.p.setOnCancelListener(new AEGIFStickerListPart.10(this));
      }
      if (!this.p.isShowing())
      {
        AEQLog.a("AEGIFStickerListPart", "[showTakeSameLoading], show dialog");
        this.p.show();
      }
    }
  }
  
  private void d()
  {
    if ((this.mActivity != null) && (!this.mActivity.isFinishing()))
    {
      Dialog localDialog = this.p;
      if ((localDialog != null) && (localDialog.isShowing()))
      {
        AEQLog.a("AEGIFStickerListPart", "[hideTakeSameLoading], dismiss dialog");
        this.p.dismiss();
      }
    }
  }
  
  private boolean e()
  {
    Object localObject = this.d;
    if (localObject == null) {
      return false;
    }
    localObject = (Boolean)((AEVideoStoryStateViewModel)localObject).e().getValue();
    if (localObject == null) {
      return false;
    }
    return ((Boolean)localObject).booleanValue();
  }
  
  public int a(int paramInt, boolean paramBoolean)
  {
    Object localObject1 = (AEGifCategoryWrapper)this.h.get(paramInt);
    if ((TextUtils.isEmpty(this.n)) || (!this.n.equals(((AEGifCategoryWrapper)localObject1).categoryId)))
    {
      this.n = ((AEGifCategoryWrapper)localObject1).categoryId;
      AEBaseReportParam.a().D(this.n);
      AEBaseDataReporter.a().ar();
    }
    if (!paramBoolean) {
      return 0;
    }
    this.m = ((AEGifCategoryWrapper)localObject1).categoryId;
    a(((AEGifCategoryWrapper)localObject1).fontId);
    this.l.clear();
    this.l.addAll(((AEGifCategoryWrapper)localObject1).materialWrapperList);
    this.k.a();
    this.k.notifyDataSetChanged();
    this.j.scrollToPositionWithOffset(0, 0);
    if (CollectionUtils.isEmpty(((AEGifCategoryWrapper)localObject1).materialWrapperList)) {
      localObject1 = null;
    } else {
      localObject1 = (AEMaterialWrapper)((AEGifCategoryWrapper)localObject1).materialWrapperList.get(0);
    }
    Object localObject2 = localObject1;
    if (localObject1 != null)
    {
      localObject2 = localObject1;
      if (((AEMaterialWrapper)localObject1).g == 1) {
        localObject2 = null;
      }
    }
    a(localObject2);
    return 0;
  }
  
  protected void initView()
  {
    if (this.mRootView == null) {
      return;
    }
    this.h = new LinkedList();
    this.g = new Pair(new String[0], new int[0]);
    this.l = new LinkedList();
    this.f = ((SimpleSlidingIndicator)this.mRootView.findViewById(2063990838));
    this.f.setOnTabListener(this);
    this.i = ((RecyclerView)this.mRootView.findViewById(2063990839));
    this.j = new LinearLayoutManager(this.a, 0, false);
    this.i.setLayoutManager(this.j);
    this.i.setItemAnimator(null);
    this.k = new AEGIFStickerAdapter(this.mRootView.getContext(), this.l);
    this.k.a(new AEGIFStickerListPart.1(this));
    this.i.setAdapter(this.k);
    this.f.setVisibility(8);
    this.i.setVisibility(8);
    a(this.mActivity.getIntent());
    a();
  }
  
  public void onActivityResume()
  {
    super.onActivityResume();
    AEVideoStoryCaptureModeViewModel localAEVideoStoryCaptureModeViewModel = this.c;
    if ((localAEVideoStoryCaptureModeViewModel != null) && (localAEVideoStoryCaptureModeViewModel.a())) {
      AEBaseDataReporter.a().ao();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.gif.AEGIFStickerListPart
 * JD-Core Version:    0.7.0.1
 */