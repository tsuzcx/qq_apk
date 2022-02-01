package com.tencent.aelight.camera.ae.album.fragment;

import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Dialog;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.Window;
import android.view.animation.RotateAnimation;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.MainThread;
import com.tencent.aelight.camera.ae.album.AEAlbumLinearLayout;
import com.tencent.aelight.camera.ae.album.AEAlbumPreviewMaskLayout;
import com.tencent.aelight.camera.ae.album.AEAlbumPreviewMaskLayout.OnTouchCallback;
import com.tencent.aelight.camera.ae.album.data.AEAlbumLogicData;
import com.tencent.aelight.camera.ae.album.logic.AEPhotoListLogic;
import com.tencent.aelight.camera.ae.album.nocropper.AECropperView;
import com.tencent.aelight.camera.ae.biz.circle.AECircleMultiUnit;
import com.tencent.aelight.camera.ae.report.AEBaseDataReporter;
import com.tencent.aelight.camera.ae.report.AEBaseReportParam;
import com.tencent.aelight.camera.ae.util.AECameraPrefsUtil;
import com.tencent.aelight.camera.ae.util.AEThemeUtil;
import com.tencent.aelight.camera.aebase.AEReportUtils;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.biz.qqstory.view.widget.bubble.BubbleTextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.album.PhotoCommonBaseData;
import com.tencent.mobileqq.activity.photo.album.QAlbumCustomAlbumConstants;
import com.tencent.mobileqq.activity.photo.album.QAlbumUtil;
import com.tencent.mobileqq.activity.photo.album.photolist.PhotoListBaseData;
import com.tencent.mobileqq.data.QQAlbumInfo;
import com.tencent.mobileqq.dinifly.LottieComposition.Factory;
import com.tencent.mobileqq.dinifly.LottieDrawable;
import com.tencent.mobileqq.qqvideoplatform.api.QQVideoViewFactory;
import com.tencent.mobileqq.videoplatform.view.BaseVideoView;
import com.tencent.mobileqq.widget.NumberCheckBox;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public abstract class AEAbstractPhotoListFragment
  extends Fragment
  implements View.OnClickListener, CompoundButton.OnCheckedChangeListener, AEAlbumPreviewMaskLayout.OnTouchCallback, AEAbstractAlbumListFragment.IAlbumListBack
{
  public int a;
  Dialog jdField_a_of_type_AndroidAppDialog;
  SharedPreferences jdField_a_of_type_AndroidContentSharedPreferences;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  public AsyncTask<Object, Object, List<LocalMediaInfo>> a;
  public GridLayoutManager a;
  public RecyclerView a;
  View jdField_a_of_type_AndroidViewView;
  public ViewGroup a;
  FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  public ImageView a;
  LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  public TextView a;
  public AEAlbumLinearLayout a;
  public AEAlbumPreviewMaskLayout a;
  public AEAbstractAlbumListFragment a;
  public AEAbstractPhotoListFragment.PhotoGridAdapter a;
  public AEPhotoListLogic a;
  public AECropperView a;
  private BubbleTextView jdField_a_of_type_ComTencentBizQqstoryViewWidgetBubbleBubbleTextView;
  PhotoListBaseData jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListBaseData;
  private LottieDrawable jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable;
  public BaseVideoView a;
  private Runnable jdField_a_of_type_JavaLangRunnable;
  public final boolean a;
  public int b;
  private Drawable jdField_b_of_type_AndroidGraphicsDrawableDrawable;
  View jdField_b_of_type_AndroidViewView;
  private FrameLayout jdField_b_of_type_AndroidWidgetFrameLayout;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  public TextView b;
  private LottieDrawable jdField_b_of_type_ComTencentMobileqqDiniflyLottieDrawable;
  private boolean jdField_b_of_type_Boolean = false;
  int jdField_c_of_type_Int;
  private FrameLayout jdField_c_of_type_AndroidWidgetFrameLayout;
  public TextView c;
  private boolean jdField_c_of_type_Boolean;
  public int d;
  TextView d;
  private TextView e;
  
  public AEAbstractPhotoListFragment()
  {
    this.jdField_a_of_type_ComTencentAelightCameraAeAlbumFragmentAEAbstractPhotoListFragment$PhotoGridAdapter = null;
    this.jdField_a_of_type_Boolean = AEThemeUtil.a();
  }
  
  @Nullable
  private LocalMediaInfo a(Object paramObject)
  {
    LocalMediaInfo localLocalMediaInfo1;
    if ((this.jdField_a_of_type_ComTencentAelightCameraAeAlbumLogicAEPhotoListLogic.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData != null) && (this.jdField_a_of_type_ComTencentAelightCameraAeAlbumLogicAEPhotoListLogic.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedMediaInfoHashMap != null)) {
      localLocalMediaInfo1 = (LocalMediaInfo)this.jdField_a_of_type_ComTencentAelightCameraAeAlbumLogicAEPhotoListLogic.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedMediaInfoHashMap.get(paramObject);
    } else {
      localLocalMediaInfo1 = null;
    }
    LocalMediaInfo localLocalMediaInfo2 = localLocalMediaInfo1;
    if (localLocalMediaInfo1 == null)
    {
      localLocalMediaInfo2 = localLocalMediaInfo1;
      if (this.jdField_a_of_type_ComTencentAelightCameraAeAlbumLogicAEPhotoListLogic.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData != null)
      {
        localLocalMediaInfo2 = localLocalMediaInfo1;
        if (this.jdField_a_of_type_ComTencentAelightCameraAeAlbumLogicAEPhotoListLogic.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.allMediaInfoHashMap != null) {
          localLocalMediaInfo2 = (LocalMediaInfo)this.jdField_a_of_type_ComTencentAelightCameraAeAlbumLogicAEPhotoListLogic.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.allMediaInfoHashMap.get(paramObject);
        }
      }
    }
    return localLocalMediaInfo2;
  }
  
  public static void a(View paramView, boolean paramBoolean)
  {
    float f1;
    if (paramBoolean) {
      f1 = 180.0F;
    } else {
      f1 = 0.0F;
    }
    float f2;
    if (paramBoolean) {
      f2 = 360.0F;
    } else {
      f2 = 180.0F;
    }
    RotateAnimation localRotateAnimation = new RotateAnimation(f1, f2, 1, 0.5F, 1, 0.5F);
    localRotateAnimation.setDuration(300L);
    localRotateAnimation.setFillAfter(true);
    paramView.startAnimation(localRotateAnimation);
  }
  
  private void b(View paramView)
  {
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2064122293));
    this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView = ((BaseVideoView)QQVideoViewFactory.b(getActivity(), 113L, null, null));
    this.jdField_c_of_type_AndroidWidgetFrameLayout.post(new AEAbstractPhotoListFragment.5(this));
    this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView.setOnClickListener(new AEAbstractPhotoListFragment.6(this));
  }
  
  private void b(boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject = this.e;
    if (localObject == null) {
      return;
    }
    if (paramBoolean1)
    {
      ((TextView)localObject).setVisibility(0);
      localObject = this.jdField_a_of_type_ComTencentAelightCameraAeAlbumNocropperAECropperView;
      int i;
      if (localObject != null) {
        i = ((AECropperView)localObject).a();
      } else {
        i = 1;
      }
      if (i == 1)
      {
        localObject = this.jdField_b_of_type_ComTencentMobileqqDiniflyLottieDrawable;
        if (localObject == null)
        {
          LottieComposition.Factory.fromAssetFileName(getActivity(), "imageselector_scale_expand.json", new AEAbstractPhotoListFragment.ScaleLottieCompositionLoaderListener(this, paramBoolean2, true));
          return;
        }
        if (paramBoolean2) {
          ((LottieDrawable)localObject).playAnimation();
        } else {
          ((LottieDrawable)localObject).setProgress(1.0F);
        }
        this.e.setCompoundDrawables(this.jdField_b_of_type_ComTencentMobileqqDiniflyLottieDrawable, null, null, null);
      }
      else if (i == 2)
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable;
        if (localObject == null)
        {
          LottieComposition.Factory.fromAssetFileName(getActivity(), "imageselector_scale_shrink.json", new AEAbstractPhotoListFragment.ScaleLottieCompositionLoaderListener(this, paramBoolean2, false));
          return;
        }
        if (paramBoolean2) {
          ((LottieDrawable)localObject).playAnimation();
        } else {
          ((LottieDrawable)localObject).setProgress(1.0F);
        }
        this.e.setCompoundDrawables(this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable, null, null, null);
      }
      this.e.setCompoundDrawablePadding(ImmersiveUtils.dpToPx(4.0F));
      return;
    }
    ((TextView)localObject).setVisibility(8);
  }
  
  private void e(boolean paramBoolean)
  {
    AECircleMultiUnit.a(paramBoolean ^ true, getActivity());
    int i;
    if (paramBoolean) {
      i = 0;
    } else {
      i = getResources().getDimensionPixelSize(2063990790);
    }
    ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)this.jdField_b_of_type_AndroidWidgetFrameLayout.getLayoutParams();
    localMarginLayoutParams.bottomMargin = i;
    this.jdField_b_of_type_AndroidWidgetFrameLayout.setLayoutParams(localMarginLayoutParams);
  }
  
  private void f(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null)
      {
        this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(2064056621);
        this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setBounds(0, 0, ImmersiveUtils.dpToPx(30.0F), ImmersiveUtils.dpToPx(30.0F));
      }
      this.jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawables(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable, null, null, null);
      this.jdField_b_of_type_AndroidWidgetTextView.setText(2064515110);
    }
    else
    {
      if (this.jdField_b_of_type_AndroidGraphicsDrawableDrawable == null)
      {
        this.jdField_b_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(2064056620);
        this.jdField_b_of_type_AndroidGraphicsDrawableDrawable.setBounds(0, 0, ImmersiveUtils.dpToPx(30.0F), ImmersiveUtils.dpToPx(30.0F));
      }
      this.jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawables(this.jdField_b_of_type_AndroidGraphicsDrawableDrawable, null, null, null);
      this.jdField_b_of_type_AndroidWidgetTextView.setText(2064515111);
    }
    this.jdField_b_of_type_AndroidWidgetTextView.setPadding(0, 0, ImmersiveUtils.dpToPx(10.0F), 0);
  }
  
  protected Dialog a()
  {
    return new Dialog(getActivity());
  }
  
  public abstract AEAbstractAlbumListFragment a();
  
  protected abstract AEPhotoListLogic a();
  
  public abstract Class a();
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentAelightCameraAeAlbumLogicAEPhotoListLogic.g();
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    ArrayList localArrayList = this.jdField_a_of_type_ComTencentAelightCameraAeAlbumLogicAEPhotoListLogic.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList;
    int j = ((GridLayoutManager)this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getLayoutManager()).findFirstVisibleItemPosition();
    int k = ((GridLayoutManager)this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getLayoutManager()).findLastVisibleItemPosition();
    int i = j;
    while (i <= k)
    {
      if ((!paramBoolean) || (paramInt == i))
      {
        Object localObject2 = this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getChildAt(i - j);
        LocalMediaInfo localLocalMediaInfo = this.jdField_a_of_type_ComTencentAelightCameraAeAlbumFragmentAEAbstractPhotoListFragment$PhotoGridAdapter.a(i);
        Object localObject1;
        if (localObject2 == null)
        {
          if (QLog.isColorLevel())
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("updateCheckbox view = null at ");
            ((StringBuilder)localObject1).append(i);
            QLog.d("PhotoListActivity", 2, ((StringBuilder)localObject1).toString());
          }
        }
        else if (localLocalMediaInfo == null)
        {
          if (QLog.isColorLevel())
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("updateCheckbox info = null at ");
            ((StringBuilder)localObject1).append(i);
            QLog.d("PhotoListActivity", 2, ((StringBuilder)localObject1).toString());
          }
        }
        else
        {
          int m;
          if (paramInt != i)
          {
            m = localArrayList.indexOf(localLocalMediaInfo.path);
            if (m >= 0)
            {
              localObject1 = (AEAbstractPhotoListFragment.PhotoVH)this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getChildViewHolder((View)localObject2);
              if ((localObject1 != null) && (((AEAbstractPhotoListFragment.PhotoVH)localObject1).a != null)) {
                ((AEAbstractPhotoListFragment.PhotoVH)localObject1).a.setCheckedNumber(m + 1 + this.jdField_a_of_type_ComTencentAelightCameraAeAlbumLogicAEPhotoListLogic.jdField_a_of_type_ComTencentAelightCameraAeAlbumDataAEAlbumLogicData.initialHasPickedNum);
              }
            }
          }
          else
          {
            m = QAlbumUtil.getMediaType(localLocalMediaInfo);
            if ((m == 0) || (m == 1))
            {
              localObject1 = (AEAbstractPhotoListFragment.PhotoVH)this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getChildViewHolder((View)localObject2);
              int n = localLocalMediaInfo.selectStatus;
              if (n == 1)
              {
                ((AEAbstractPhotoListFragment.PhotoVH)localObject1).a.setCheckedNumber(localArrayList.indexOf(localLocalMediaInfo.path) + 1 + this.jdField_a_of_type_ComTencentAelightCameraAeAlbumLogicAEPhotoListLogic.jdField_a_of_type_ComTencentAelightCameraAeAlbumDataAEAlbumLogicData.initialHasPickedNum);
                if (((View)localObject2).getBackground() != null) {
                  ((View)localObject2).setBackgroundDrawable(null);
                }
              }
              else if (n == 3)
              {
                ((AEAbstractPhotoListFragment.PhotoVH)localObject1).a.setChecked(false);
              }
              else
              {
                ((AEAbstractPhotoListFragment.PhotoVH)localObject1).a.setChecked(false);
                if (((View)localObject2).getBackground() != null) {
                  ((View)localObject2).setBackgroundDrawable(null);
                }
              }
              if (AppSetting.d)
              {
                localObject2 = QAlbumUtil.createContentDescriptionWithCheckBox(m, localLocalMediaInfo, i, ((AEAbstractPhotoListFragment.PhotoVH)localObject1).a.isChecked());
                ((AEAbstractPhotoListFragment.PhotoVH)localObject1).a.setContentDescription((CharSequence)localObject2);
              }
            }
          }
        }
      }
      i += 1;
    }
  }
  
  protected void a(View paramView)
  {
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)paramView.findViewById(2064121942));
    this.jdField_a_of_type_AndroidViewView = paramView.findViewById(2064122287);
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2064122288));
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.d = ((TextView)paramView.findViewById(2064122290));
    String str;
    if (this.jdField_a_of_type_ComTencentAelightCameraAeAlbumLogicAEPhotoListLogic.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.albumName != null) {
      str = this.jdField_a_of_type_ComTencentAelightCameraAeAlbumLogicAEPhotoListLogic.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.albumName;
    } else if (this.jdField_a_of_type_ComTencentAelightCameraAeAlbumLogicAEPhotoListLogic.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.showMediaType == 2) {
      str = QAlbumCustomAlbumConstants.RECENT_ALBUM_NAME_VIDEO;
    } else {
      str = QAlbumCustomAlbumConstants.RECENT_ALBUM_NAME;
    }
    a(str);
    this.jdField_b_of_type_AndroidViewView = paramView.findViewById(2064122289);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2064122286));
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetFrameLayout = ((FrameLayout)paramView.findViewById(2064122211));
    this.jdField_a_of_type_ComTencentAelightCameraAeAlbumAEAlbumLinearLayout = ((AEAlbumLinearLayout)paramView.findViewById(2064121929));
    this.jdField_a_of_type_ComTencentAelightCameraAeAlbumAEAlbumLinearLayout.setScrollListener(new AEAbstractPhotoListFragment.3(this));
    this.jdField_a_of_type_ComTencentAelightCameraAeAlbumNocropperAECropperView = ((AECropperView)paramView.findViewById(2064121930));
    this.jdField_a_of_type_ComTencentAelightCameraAeAlbumNocropperAECropperView.setMaxZoom(5.0F);
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetBubbleBubbleTextView = ((BubbleTextView)paramView.findViewById(2064122666));
    this.jdField_a_of_type_ComTencentAelightCameraAeAlbumAEAlbumPreviewMaskLayout = ((AEAlbumPreviewMaskLayout)paramView.findViewById(2064122212));
    this.jdField_a_of_type_ComTencentAelightCameraAeAlbumAEAlbumPreviewMaskLayout.setOnTouchCallback(this);
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)paramView.findViewById(2064122363));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2064122319));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2064122778));
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = ((RecyclerView)paramView.findViewById(2064122484));
    ((DefaultItemAnimator)this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getItemAnimator()).setSupportsChangeAnimations(false);
    this.jdField_a_of_type_AndroidSupportV7WidgetGridLayoutManager = new GridLayoutManager(getActivity(), 3);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setLayoutManager(this.jdField_a_of_type_AndroidSupportV7WidgetGridLayoutManager);
    this.jdField_a_of_type_ComTencentAelightCameraAeAlbumFragmentAEAbstractPhotoListFragment$PhotoGridAdapter = new AEAbstractPhotoListFragment.PhotoGridAdapter(this);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setAdapter(this.jdField_a_of_type_ComTencentAelightCameraAeAlbumFragmentAEAbstractPhotoListFragment$PhotoGridAdapter);
    this.jdField_c_of_type_AndroidWidgetFrameLayout = ((FrameLayout)paramView.findViewById(2064122509));
    b(paramView);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2064122768));
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(new AEAbstractPhotoListFragment.4(this));
    this.e = ((TextView)paramView.findViewById(2064122782));
    this.e.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentAelightCameraAeAlbumLogicAEPhotoListLogic.c();
  }
  
  public void a(QQAlbumInfo paramQQAlbumInfo, int paramInt, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onAlbumListChoose--albumId=");
      localStringBuilder.append(paramQQAlbumInfo.id);
      AEQLog.b("PhotoListActivity", localStringBuilder.toString());
      this.jdField_a_of_type_ComTencentAelightCameraAeAlbumLogicAEPhotoListLogic.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.albumName = paramQQAlbumInfo.name;
      this.jdField_a_of_type_ComTencentAelightCameraAeAlbumLogicAEPhotoListLogic.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.albumId = paramQQAlbumInfo.id;
      if (this.jdField_a_of_type_ComTencentAelightCameraAeAlbumLogicAEPhotoListLogic.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.albumName != null) {
        paramQQAlbumInfo = this.jdField_a_of_type_ComTencentAelightCameraAeAlbumLogicAEPhotoListLogic.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.albumName;
      } else {
        paramQQAlbumInfo = QAlbumCustomAlbumConstants.RECENT_ALBUM_NAME;
      }
      a(paramQQAlbumInfo);
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListBaseData.l = true;
      getActivity().runOnUiThread(new AEAbstractPhotoListFragment.8(this));
    }
    c(false);
  }
  
  public void a(CharSequence paramCharSequence)
  {
    getActivity().setTitle(paramCharSequence);
    this.d.setText(paramCharSequence);
  }
  
  public void a(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListBaseData.q)
    {
      QAlbumUtil.sLastAlbumRecordTime = System.currentTimeMillis();
      QAlbumUtil.sLastAlbumPhotoCountMap.put(this.jdField_a_of_type_ComTencentAelightCameraAeAlbumLogicAEPhotoListLogic.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.albumId, Integer.valueOf(this.jdField_a_of_type_ComTencentAelightCameraAeAlbumFragmentAEAbstractPhotoListFragment$PhotoGridAdapter.getItemCount()));
      if (!TextUtils.isEmpty(paramString))
      {
        QAlbumUtil.sLastAlbumPath = paramString;
        HashMap localHashMap = QAlbumUtil.sSelectItemAlbum;
        if (localHashMap.containsKey(paramString))
        {
          paramString = (Pair)localHashMap.get(paramString);
          QAlbumUtil.sLastAlbumId = (String)paramString.first;
          QAlbumUtil.sLastAlbumName = (String)paramString.second;
          QAlbumUtil.putLastAlbumInfo(getActivity(), QAlbumUtil.sLastAlbumId, QAlbumUtil.sLastAlbumName);
        }
      }
    }
    QAlbumUtil.clearSelectItemInfo();
  }
  
  public void a(boolean paramBoolean)
  {
    ImageView localImageView = this.jdField_b_of_type_AndroidWidgetImageView;
    int i;
    if (paramBoolean) {
      i = 0;
    } else {
      i = 8;
    }
    localImageView.setVisibility(i);
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.jdField_a_of_type_AndroidOsAsyncTask = new AEAbstractPhotoListFragment.QueryPhotoTask(this, paramBoolean1, paramBoolean2);
    this.jdField_a_of_type_AndroidOsAsyncTask.execute(new Object[0]);
  }
  
  public boolean a(LocalMediaInfo paramLocalMediaInfo)
  {
    return (paramLocalMediaInfo != null) && ("image/gif".equals(paramLocalMediaInfo.mMimeType));
  }
  
  public void b()
  {
    c(false);
  }
  
  @MainThread
  public void b(boolean paramBoolean)
  {
    f(paramBoolean);
    e(paramBoolean);
  }
  
  public void c()
  {
    b(true, false);
    e();
  }
  
  public void c(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentAelightCameraAeAlbumFragmentAEAbstractAlbumListFragment == null) {
      if (paramBoolean)
      {
        this.jdField_a_of_type_ComTencentAelightCameraAeAlbumFragmentAEAbstractAlbumListFragment = a();
        this.jdField_a_of_type_ComTencentAelightCameraAeAlbumFragmentAEAbstractAlbumListFragment.a(this);
      }
      else
      {
        return;
      }
    }
    FragmentTransaction localFragmentTransaction = getFragmentManager().beginTransaction();
    localFragmentTransaction.setTransition(4097);
    ObjectAnimator localObjectAnimator;
    if ((paramBoolean) && (!this.jdField_a_of_type_ComTencentAelightCameraAeAlbumFragmentAEAbstractAlbumListFragment.isAdded()))
    {
      localObjectAnimator = ObjectAnimator.ofInt(this.jdField_a_of_type_AndroidWidgetFrameLayout, "backgroundColor", new int[] { getResources().getColor(2131165474), getResources().getColor(2131165485) });
      a(this.jdField_b_of_type_AndroidViewView, false);
      localFragmentTransaction.add(2064121942, this.jdField_a_of_type_ComTencentAelightCameraAeAlbumFragmentAEAbstractAlbumListFragment, null);
    }
    else
    {
      localObjectAnimator = ObjectAnimator.ofInt(this.jdField_a_of_type_AndroidWidgetFrameLayout, "backgroundColor", new int[] { getResources().getColor(2131165485), getResources().getColor(2131165474) });
      a(this.jdField_b_of_type_AndroidViewView, true);
      localFragmentTransaction.remove(this.jdField_a_of_type_ComTencentAelightCameraAeAlbumFragmentAEAbstractAlbumListFragment);
    }
    localFragmentTransaction.addToBackStack(null);
    localFragmentTransaction.commit();
    localObjectAnimator.setDuration(300L);
    localObjectAnimator.setEvaluator(new ArgbEvaluator());
    localObjectAnimator.setRepeatMode(2);
    localObjectAnimator.start();
    this.jdField_a_of_type_ComTencentAelightCameraAeAlbumLogicAEPhotoListLogic.b(paramBoolean);
  }
  
  public void d()
  {
    b(false, false);
    f();
  }
  
  public void d(boolean paramBoolean)
  {
    int i = this.jdField_a_of_type_ComTencentAelightCameraAeAlbumLogicAEPhotoListLogic.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList.size() + this.jdField_a_of_type_ComTencentAelightCameraAeAlbumLogicAEPhotoListLogic.jdField_a_of_type_ComTencentAelightCameraAeAlbumDataAEAlbumLogicData.initialHasPickedNum;
    if (((i == this.jdField_a_of_type_ComTencentAelightCameraAeAlbumLogicAEPhotoListLogic.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.maxSelectNum) && (!paramBoolean)) || ((i == this.jdField_a_of_type_ComTencentAelightCameraAeAlbumLogicAEPhotoListLogic.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.maxSelectNum - 1) && (paramBoolean))) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      int j = ((GridLayoutManager)this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getLayoutManager()).findFirstVisibleItemPosition();
      int k = ((GridLayoutManager)this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getLayoutManager()).findLastVisibleItemPosition();
      i = j;
      while (i <= k)
      {
        if (this.jdField_a_of_type_ComTencentAelightCameraAeAlbumFragmentAEAbstractPhotoListFragment$PhotoGridAdapter.getItemViewType(i) != 2)
        {
          Object localObject2 = this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getChildAt(i - j);
          Object localObject1 = this.jdField_a_of_type_ComTencentAelightCameraAeAlbumFragmentAEAbstractPhotoListFragment$PhotoGridAdapter.a(i);
          if (localObject2 == null)
          {
            if (QLog.isColorLevel())
            {
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append("updateCheckbox view = null at ");
              ((StringBuilder)localObject1).append(i);
              QLog.d("PhotoListActivity", 2, ((StringBuilder)localObject1).toString());
            }
          }
          else if (localObject1 == null)
          {
            if (QLog.isColorLevel())
            {
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append("updateCheckbox info = null at ");
              ((StringBuilder)localObject1).append(i);
              QLog.d("PhotoListActivity", 2, ((StringBuilder)localObject1).toString());
            }
          }
          else
          {
            localObject2 = (AEAbstractPhotoListFragment.PhotoVH)this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getChildViewHolder((View)localObject2);
            if ((!paramBoolean) && (((LocalMediaInfo)localObject1).selectStatus != 1)) {
              ((AEAbstractPhotoListFragment.PhotoVH)localObject2).jdField_b_of_type_AndroidWidgetImageView.setAlpha(0.3F);
            } else {
              ((AEAbstractPhotoListFragment.PhotoVH)localObject2).jdField_b_of_type_AndroidWidgetImageView.setAlpha(1.0F);
            }
          }
        }
        i += 1;
      }
    }
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetBubbleBubbleTextView.getVisibility() != 0)
    {
      if (AECameraPrefsUtil.a().a("sp_key_ae_photo_switch_ratio_tips", false, 0)) {
        return;
      }
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetBubbleBubbleTextView.setIncludeFontPadding(false);
      int i = UIUtils.a(getActivity(), 8.0F);
      int j = UIUtils.a(getActivity(), 6.0F);
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetBubbleBubbleTextView.setPadding(i, j, i, j);
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetBubbleBubbleTextView.setTextSize(1, 14.0F);
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetBubbleBubbleTextView.setTextColor(-1);
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetBubbleBubbleTextView.jdField_a_of_type_Int = Color.parseColor("#252525");
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetBubbleBubbleTextView.b = UIUtils.a(getActivity(), 6.0F);
      Object localObject = this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetBubbleBubbleTextView;
      ((BubbleTextView)localObject).jdField_a_of_type_Boolean = false;
      ((BubbleTextView)localObject).d = UIUtils.a(getActivity(), 6.0F);
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetBubbleBubbleTextView.setText(getActivity().getString(2064515102));
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetBubbleBubbleTextView.a();
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetBubbleBubbleTextView.setVisibility(0);
      boolean bool = AECameraPrefsUtil.a().a("sp_key_ae_photo_switch_ratio_tips_should_auto_disappear", true, 0);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("checkShowSwitchRatioTips--shouldAutoDisappear=");
      ((StringBuilder)localObject).append(bool);
      AEQLog.a("PhotoListActivity", ((StringBuilder)localObject).toString());
      if (bool)
      {
        this.jdField_a_of_type_JavaLangRunnable = new AEAbstractPhotoListFragment.7(this);
        this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetBubbleBubbleTextView.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 5000L);
      }
    }
  }
  
  public void f()
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetBubbleBubbleTextView.getVisibility() == 0)
    {
      Runnable localRunnable = this.jdField_a_of_type_JavaLangRunnable;
      if (localRunnable != null) {
        this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetBubbleBubbleTextView.removeCallbacks(localRunnable);
      }
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetBubbleBubbleTextView.setVisibility(8);
      AECameraPrefsUtil.a().a("sp_key_ae_photo_switch_ratio_tips", true, 0);
    }
  }
  
  public void g()
  {
    try
    {
      if (this.jdField_a_of_type_AndroidAppDialog != null)
      {
        h();
      }
      else
      {
        this.jdField_a_of_type_AndroidAppDialog = a();
        this.jdField_a_of_type_AndroidAppDialog.setCancelable(true);
        this.jdField_a_of_type_AndroidAppDialog.show();
      }
      if (!this.jdField_a_of_type_AndroidAppDialog.isShowing())
      {
        this.jdField_a_of_type_AndroidAppDialog.show();
        return;
      }
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.e("PhotoListActivity", 2, "show dialog error", localException);
      }
      this.jdField_a_of_type_AndroidAppDialog = null;
    }
  }
  
  public void h()
  {
    Dialog localDialog = this.jdField_a_of_type_AndroidAppDialog;
    if (localDialog != null) {
      try
      {
        localDialog.cancel();
        return;
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        if (QLog.isColorLevel()) {
          QLog.e("PhotoListActivity", 2, "cancel dialog error", localIllegalArgumentException);
        }
      }
    }
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (paramCompoundButton.getId() == 2131374724) {
      this.jdField_a_of_type_ComTencentAelightCameraAeAlbumLogicAEPhotoListLogic.a(paramCompoundButton, paramBoolean);
    }
  }
  
  @TargetApi(9)
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_ComTencentAelightCameraAeAlbumLogicAEPhotoListLogic == null) {
      return;
    }
    int i = paramView.getId();
    if (i == 2064122287)
    {
      this.jdField_a_of_type_ComTencentAelightCameraAeAlbumLogicAEPhotoListLogic.a(paramView);
      return;
    }
    if (i == 2131373035)
    {
      this.jdField_a_of_type_ComTencentAelightCameraAeAlbumLogicAEPhotoListLogic.b(paramView);
      return;
    }
    if (i == 2131377197)
    {
      this.jdField_a_of_type_ComTencentAelightCameraAeAlbumLogicAEPhotoListLogic.c(paramView);
      return;
    }
    boolean bool2 = false;
    boolean bool1 = false;
    if (i == 2064122286)
    {
      paramView = this.jdField_a_of_type_ComTencentAelightCameraAeAlbumFragmentAEAbstractAlbumListFragment;
      if ((paramView == null) || (!paramView.isAdded())) {
        bool1 = true;
      }
      if (bool1) {
        this.jdField_a_of_type_ComTencentAelightCameraAeAlbumLogicAEPhotoListLogic.b(getActivity().getIntent());
      }
      c(bool1);
      return;
    }
    if (i == 2064122288)
    {
      this.jdField_a_of_type_ComTencentAelightCameraAeAlbumLogicAEPhotoListLogic.e(paramView);
      if ((this.jdField_a_of_type_ComTencentAelightCameraAeAlbumLogicAEPhotoListLogic.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData != null) && (this.jdField_a_of_type_ComTencentAelightCameraAeAlbumLogicAEPhotoListLogic.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList != null))
      {
        int j = this.jdField_a_of_type_ComTencentAelightCameraAeAlbumLogicAEPhotoListLogic.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList.size();
        AEBaseReportParam.a().a().a = AEBaseReportParam.a().b();
        if (this.jdField_a_of_type_ComTencentAelightCameraAeAlbumLogicAEPhotoListLogic.jdField_a_of_type_ComTencentAelightCameraAeAlbumDataAEAlbumLogicData.canMixPhotoAndVideo)
        {
          AEBaseReportParam.a().a().b = AEBaseReportParam.g.longValue();
          paramView = this.jdField_a_of_type_ComTencentAelightCameraAeAlbumLogicAEPhotoListLogic.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList.iterator();
          long l = 0L;
          i = 0;
          while (paramView.hasNext())
          {
            LocalMediaInfo localLocalMediaInfo = a(paramView.next());
            if ((localLocalMediaInfo != null) && (QAlbumUtil.getMediaType(localLocalMediaInfo) == 1))
            {
              i += 1;
              l += localLocalMediaInfo.mDuration / 1000L;
            }
          }
          AEBaseReportParam.a().a().f = i;
          AEBaseReportParam.a().a().c = l;
          j -= i;
        }
        else
        {
          AEBaseReportParam.a().a().b = AEBaseReportParam.d.longValue();
          i = 0;
        }
        AEBaseDataReporter.a().a(j);
        bool1 = bool2;
        if (this.jdField_a_of_type_ComTencentAelightCameraAeAlbumLogicAEPhotoListLogic.jdField_a_of_type_ComTencentAelightCameraAeAlbumDataAEAlbumLogicData.initialHasPickedNum > 0) {
          bool1 = true;
        }
        AEReportUtils.a(bool1, j, i);
      }
    }
    else if (i == 2064122782)
    {
      this.jdField_a_of_type_ComTencentAelightCameraAeAlbumLogicAEPhotoListLogic.d(paramView);
      f();
      b(true, true);
    }
  }
  
  public void onCreate(@Nullable Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (Build.VERSION.SDK_INT > 23) {
      getActivity().getWindow().setBackgroundDrawable(null);
    }
    this.jdField_a_of_type_ComTencentAelightCameraAeAlbumLogicAEPhotoListLogic = a();
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListBaseData = this.jdField_a_of_type_ComTencentAelightCameraAeAlbumLogicAEPhotoListLogic.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListBaseData;
    this.jdField_a_of_type_AndroidContentSharedPreferences = BaseApplication.getContext().getSharedPreferences("share", 4);
    paramBundle = getResources();
    int i = paramBundle.getDisplayMetrics().widthPixels;
    this.jdField_c_of_type_Int = paramBundle.getDimensionPixelSize(2131296692);
    this.jdField_a_of_type_Int = ((i - this.jdField_c_of_type_Int * 2) / 3);
    this.jdField_b_of_type_Int = this.jdField_a_of_type_Int;
    paramBundle = getActivity().getIntent();
    this.jdField_a_of_type_ComTencentAelightCameraAeAlbumLogicAEPhotoListLogic.a(paramBundle);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("PhotoListActivity onCreate(),extra is:");
      localStringBuilder.append(paramBundle.getExtras());
      QLog.d("SelectPhotoTrace", 2, localStringBuilder.toString());
    }
    if (QLog.isColorLevel())
    {
      paramBundle = new StringBuilder();
      paramBundle.append("PhotoListActivity,hashCode is:");
      paramBundle.append(System.identityHashCode(this));
      QLog.d("SelectPhotoTrace", 2, paramBundle.toString());
    }
  }
  
  @Nullable
  public View onCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2064318493, paramViewGroup, false);
    ViewCompat.setOnApplyWindowInsetsListener(paramLayoutInflater, new AEAbstractPhotoListFragment.1(this));
    if (paramLayoutInflater != null) {
      paramLayoutInflater.post(new AEAbstractPhotoListFragment.2(this, paramLayoutInflater));
    }
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.jdField_a_of_type_ComTencentAelightCameraAeAlbumLogicAEPhotoListLogic.f();
    Object localObject = this.jdField_a_of_type_ComTencentAelightCameraAeAlbumAEAlbumLinearLayout;
    if (localObject != null) {
      ((AEAlbumLinearLayout)localObject).setScrollListener(null);
    }
    localObject = this.jdField_a_of_type_ComTencentAelightCameraAeAlbumAEAlbumPreviewMaskLayout;
    if (localObject != null) {
      ((AEAlbumPreviewMaskLayout)localObject).setOnTouchCallback(null);
    }
  }
  
  public void onPause()
  {
    AEQLog.b("PhotoListActivity", "onPause---");
    super.onPause();
    this.jdField_a_of_type_AndroidOsAsyncTask = null;
    f();
    BaseVideoView localBaseVideoView = this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView;
    if ((localBaseVideoView != null) && (localBaseVideoView.isPlaying()))
    {
      this.jdField_b_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView.pause();
    }
  }
  
  public void onResume()
  {
    AEQLog.b("PhotoListActivity", "onResume---");
    super.onResume();
    this.jdField_a_of_type_ComTencentAelightCameraAeAlbumLogicAEPhotoListLogic.e();
    BaseVideoView localBaseVideoView = this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView;
    if ((localBaseVideoView != null) && (this.jdField_b_of_type_Boolean))
    {
      this.jdField_b_of_type_Boolean = false;
      localBaseVideoView.resume();
    }
  }
  
  public void onViewCreated(View paramView, @Nullable Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    a(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.album.fragment.AEAbstractPhotoListFragment
 * JD-Core Version:    0.7.0.1
 */