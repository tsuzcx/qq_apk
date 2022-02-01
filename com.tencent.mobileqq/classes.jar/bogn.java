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
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Environment;
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
import android.view.Window;
import android.view.animation.RotateAnimation;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.biz.qqstory.view.widget.bubble.BubbleTextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.album.PhotoCommonBaseData;
import com.tencent.mobileqq.activity.photo.album.PhotoListBaseData;
import com.tencent.mobileqq.activity.photo.album.QAlbumCustomAlbumConstants;
import com.tencent.mobileqq.activity.photo.album.QAlbumUtil;
import com.tencent.mobileqq.data.QQAlbumInfo;
import com.tencent.mobileqq.widget.NumberCheckBox;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.qqlive.module.videoreport.inject.fragment.FragmentCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.ReportFragment;
import dov.com.qq.im.ae.album.AEAlbumLinearLayout;
import dov.com.qq.im.ae.album.AEAlbumPreviewMaskLayout;
import dov.com.qq.im.ae.album.fragment.AEAbstractPhotoListFragment.3;
import dov.com.qq.im.ae.album.fragment.AEAbstractPhotoListFragment.4;
import dov.com.qq.im.ae.album.nocropper.AECropperView;
import dov.com.qq.im.ae.view.AECompoundButton;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public abstract class bogn
  extends ReportFragment
  implements View.OnClickListener, CompoundButton.OnCheckedChangeListener, boge, bogm
{
  public int a;
  Dialog jdField_a_of_type_AndroidAppDialog;
  SharedPreferences jdField_a_of_type_AndroidContentSharedPreferences;
  public AsyncTask<Object, Object, List<LocalMediaInfo>> a;
  public GridLayoutManager a;
  public RecyclerView a;
  View jdField_a_of_type_AndroidViewView;
  FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  public ImageView a;
  public LinearLayout a;
  public TextView a;
  public bogi a;
  public bogq a;
  public bohc a;
  private BubbleTextView jdField_a_of_type_ComTencentBizQqstoryViewWidgetBubbleBubbleTextView;
  PhotoListBaseData jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoListBaseData;
  public AEAlbumLinearLayout a;
  public AEAlbumPreviewMaskLayout a;
  public AECropperView a;
  public AECompoundButton a;
  private Runnable jdField_a_of_type_JavaLangRunnable;
  public final boolean a;
  public int b;
  View jdField_b_of_type_AndroidViewView;
  LinearLayout jdField_b_of_type_AndroidWidgetLinearLayout;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  int c;
  public int d;
  
  public bogn()
  {
    this.jdField_a_of_type_Boolean = bpan.a();
  }
  
  public static void a(View paramView, boolean paramBoolean)
  {
    float f2 = 180.0F;
    if (paramBoolean) {}
    for (float f1 = 180.0F;; f1 = 0.0F)
    {
      if (paramBoolean) {
        f2 = 360.0F;
      }
      RotateAnimation localRotateAnimation = new RotateAnimation(f1, f2, 1, 0.5F, 1, 0.5F);
      localRotateAnimation.setDuration(300L);
      localRotateAnimation.setFillAfter(true);
      paramView.startAnimation(localRotateAnimation);
      return;
    }
  }
  
  protected Dialog a()
  {
    return new ReportDialog(getActivity());
  }
  
  public abstract bogi a();
  
  protected abstract bohc a();
  
  @TargetApi(8)
  File a()
  {
    Object localObject = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
    String str = "JPEG_" + (String)localObject + "_";
    if ("mounted".equals(Environment.getExternalStorageState()))
    {
      boolean bool = false;
      if (Build.VERSION.SDK_INT > 7)
      {
        localObject = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM);
        bool = true;
      }
      while (bool)
      {
        localObject = File.createTempFile(str, ".jpg", (File)localObject);
        this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoListBaseData.currentPhotoPath = ((File)localObject).getAbsolutePath();
        return localObject;
        File localFile = new File(Environment.getExternalStorageDirectory(), "DCIM");
        localObject = localFile;
        if (!localFile.exists())
        {
          bool = localFile.mkdirs();
          localObject = localFile;
        }
      }
    }
    return null;
  }
  
  public abstract Class a();
  
  public void a()
  {
    this.jdField_a_of_type_Bohc.g();
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    ArrayList localArrayList = this.jdField_a_of_type_Bohc.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList;
    int j = ((GridLayoutManager)this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getLayoutManager()).findFirstVisibleItemPosition();
    int k = ((GridLayoutManager)this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getLayoutManager()).findLastVisibleItemPosition();
    int i = j;
    if (i <= k)
    {
      if ((paramBoolean) && (paramInt != i)) {}
      label406:
      for (;;)
      {
        i += 1;
        break;
        Object localObject = this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getChildAt(i - j);
        LocalMediaInfo localLocalMediaInfo = this.jdField_a_of_type_Bogq.a(i);
        if (localObject == null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("PhotoListActivity", 2, "updateCheckbox view = null at " + i);
          }
        }
        else if (localLocalMediaInfo == null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("PhotoListActivity", 2, "updateCheckbox info = null at " + i);
          }
        }
        else
        {
          int m;
          bogs localbogs;
          if (paramInt != i)
          {
            m = localArrayList.indexOf(localLocalMediaInfo.path);
            if (m >= 0)
            {
              localbogs = (bogs)this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getChildViewHolder((View)localObject);
              if ((localbogs != null) && (localbogs.a != null)) {
                localbogs.a.setCheckedNumber(m + 1 + this.jdField_a_of_type_Bohc.a());
              }
            }
          }
          else
          {
            m = QAlbumUtil.getMediaType(localLocalMediaInfo);
            if ((m == 0) || (m == 1))
            {
              localbogs = (bogs)this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getChildViewHolder((View)localObject);
              int n = localLocalMediaInfo.selectStatus;
              if (n == 1)
              {
                localbogs.a.setCheckedNumber(localArrayList.indexOf(localLocalMediaInfo.path) + 1 + this.jdField_a_of_type_Bohc.a());
                if (((View)localObject).getBackground() != null) {
                  ((View)localObject).setBackgroundDrawable(null);
                }
              }
              for (;;)
              {
                if (!AppSetting.c) {
                  break label406;
                }
                localObject = QAlbumUtil.createContentDescriptionWithCheckBox(m, localLocalMediaInfo, i, localbogs.a.isChecked());
                localbogs.a.setContentDescription((CharSequence)localObject);
                break;
                if (n == 3)
                {
                  localbogs.a.setChecked(false);
                }
                else
                {
                  localbogs.a.setChecked(false);
                  if (((View)localObject).getBackground() != null) {
                    ((View)localObject).setBackgroundDrawable(null);
                  }
                }
              }
            }
          }
        }
      }
    }
  }
  
  protected void a(View paramView)
  {
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)paramView.findViewById(2131362570));
    this.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131369042);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131369073));
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131369088));
    String str;
    if (this.jdField_a_of_type_Bohc.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.albumName != null) {
      str = this.jdField_a_of_type_Bohc.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.albumName;
    }
    for (;;)
    {
      a(str);
      this.jdField_b_of_type_AndroidViewView = paramView.findViewById(2131369085);
      this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131369036));
      this.jdField_b_of_type_AndroidWidgetLinearLayout.setOnClickListener(this);
      this.jdField_a_of_type_DovComQqImAeAlbumAEAlbumLinearLayout = ((AEAlbumLinearLayout)paramView.findViewById(2131362287));
      this.jdField_a_of_type_DovComQqImAeAlbumAEAlbumLinearLayout.setScrollListener(new bogp(this));
      this.jdField_a_of_type_DovComQqImAeAlbumNocropperAECropperView = ((AECropperView)paramView.findViewById(2131362288));
      this.jdField_a_of_type_DovComQqImAeAlbumNocropperAECropperView.setMaxZoom(5.0F);
      this.jdField_a_of_type_DovComQqImAeViewAECompoundButton = ((AECompoundButton)paramView.findViewById(2131366755));
      this.jdField_a_of_type_DovComQqImAeViewAECompoundButton.setOnClickListener(this);
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetBubbleBubbleTextView = ((BubbleTextView)paramView.findViewById(2131378294));
      this.jdField_a_of_type_DovComQqImAeAlbumAEAlbumPreviewMaskLayout = ((AEAlbumPreviewMaskLayout)paramView.findViewById(2131366758));
      this.jdField_a_of_type_DovComQqImAeAlbumAEAlbumPreviewMaskLayout.setOnTouchCallback(this);
      this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131370209));
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131369298));
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = ((RecyclerView)paramView.findViewById(2131372538));
      ((DefaultItemAnimator)this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getItemAnimator()).setSupportsChangeAnimations(false);
      this.jdField_a_of_type_AndroidSupportV7WidgetGridLayoutManager = new GridLayoutManager(getActivity(), 3);
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setLayoutManager(this.jdField_a_of_type_AndroidSupportV7WidgetGridLayoutManager);
      this.jdField_a_of_type_Bogq = new bogq(this);
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setAdapter(this.jdField_a_of_type_Bogq);
      this.jdField_a_of_type_Bohc.c();
      return;
      if (this.jdField_a_of_type_Bohc.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.showMediaType == 2) {
        str = QAlbumCustomAlbumConstants.RECENT_ALBUM_NAME_VIDEO;
      } else {
        str = QAlbumCustomAlbumConstants.RECENT_ALBUM_NAME;
      }
    }
  }
  
  public void a(View paramView, int paramInt)
  {
    int i = this.jdField_a_of_type_Bogq.getItemViewType(paramInt);
    if (this.jdField_a_of_type_Bohc.jdField_a_of_type_Bohf != null) {}
    switch (i)
    {
    default: 
      return;
    case 0: 
      if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoListBaseData.isSingleMode)
      {
        this.jdField_a_of_type_Bohc.jdField_a_of_type_Bohf.a(paramView, paramInt);
        return;
      }
      paramView = this.jdField_a_of_type_Bohc.jdField_a_of_type_Bohf.a(paramView, paramInt);
      this.jdField_a_of_type_Bohc.c(paramView);
      QAlbumUtil.anim(getActivity(), true, true);
      return;
    case 1: 
      this.jdField_a_of_type_Bohc.jdField_a_of_type_Bohf.b(paramView, paramInt);
      return;
    }
    this.jdField_a_of_type_Bohc.jdField_a_of_type_Bohf.c(paramView, paramInt);
  }
  
  public void a(QQAlbumInfo paramQQAlbumInfo, int paramInt, boolean paramBoolean)
  {
    if (paramBoolean) {
      if (this.jdField_a_of_type_Bohc.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.albumName == null) {
        break label62;
      }
    }
    label62:
    for (paramQQAlbumInfo = this.jdField_a_of_type_Bohc.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.albumName;; paramQQAlbumInfo = QAlbumCustomAlbumConstants.RECENT_ALBUM_NAME)
    {
      a(paramQQAlbumInfo);
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoListBaseData.firstResume = true;
      getActivity().runOnUiThread(new AEAbstractPhotoListFragment.4(this));
      a(false);
      return;
    }
  }
  
  public void a(CharSequence paramCharSequence)
  {
    getActivity().setTitle(paramCharSequence);
    this.jdField_b_of_type_AndroidWidgetTextView.setText(paramCharSequence);
  }
  
  public void a(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoListBaseData.isRecodeLastAlbumPath)
    {
      QAlbumUtil.sLastAlbumRecordTime = System.currentTimeMillis();
      QAlbumUtil.sLastAlbumPhotoCountMap.put(this.jdField_a_of_type_Bohc.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.albumId, Integer.valueOf(this.jdField_a_of_type_Bogq.getItemCount()));
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
    FragmentTransaction localFragmentTransaction;
    ObjectAnimator localObjectAnimator;
    if (this.jdField_a_of_type_Bogi == null)
    {
      if (paramBoolean)
      {
        this.jdField_a_of_type_Bogi = a();
        this.jdField_a_of_type_Bogi.a(this);
      }
    }
    else
    {
      localFragmentTransaction = getFragmentManager().beginTransaction();
      localFragmentTransaction.setTransition(4097);
      if ((!paramBoolean) || (this.jdField_a_of_type_Bogi.isAdded())) {
        break label166;
      }
      localObjectAnimator = ObjectAnimator.ofInt(this.jdField_a_of_type_AndroidWidgetFrameLayout, "backgroundColor", new int[] { getResources().getColor(2131165484), getResources().getColor(2131165495) });
      a(this.jdField_b_of_type_AndroidViewView, false);
      localFragmentTransaction.add(2131362570, this.jdField_a_of_type_Bogi, null);
    }
    for (;;)
    {
      localFragmentTransaction.addToBackStack(null);
      localFragmentTransaction.commit();
      localObjectAnimator.setDuration(300L);
      localObjectAnimator.setEvaluator(new ArgbEvaluator());
      localObjectAnimator.setRepeatMode(2);
      localObjectAnimator.start();
      this.jdField_a_of_type_Bohc.a(paramBoolean);
      return;
      label166:
      localObjectAnimator = ObjectAnimator.ofInt(this.jdField_a_of_type_AndroidWidgetFrameLayout, "backgroundColor", new int[] { getResources().getColor(2131165495), getResources().getColor(2131165484) });
      a(this.jdField_b_of_type_AndroidViewView, true);
      localFragmentTransaction.remove(this.jdField_a_of_type_Bogi);
    }
  }
  
  public boolean a(LocalMediaInfo paramLocalMediaInfo)
  {
    return (paramLocalMediaInfo != null) && ("image/gif".equals(paramLocalMediaInfo.mMimeType));
  }
  
  public void b()
  {
    a(false);
  }
  
  public void b(boolean paramBoolean)
  {
    int i = this.jdField_a_of_type_Bohc.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList.size();
    int j;
    if (((i == this.jdField_a_of_type_Bohc.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.maxSelectNum) && (!paramBoolean)) || ((i == this.jdField_a_of_type_Bohc.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.maxSelectNum - 1) && (paramBoolean)))
    {
      i = 1;
      if (i == 0) {
        return;
      }
      j = ((GridLayoutManager)this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getLayoutManager()).findFirstVisibleItemPosition();
      int k = ((GridLayoutManager)this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getLayoutManager()).findLastVisibleItemPosition();
      i = j;
      label89:
      if (i > k) {
        return;
      }
      if (this.jdField_a_of_type_Bogq.getItemViewType(i) != 2) {
        break label119;
      }
    }
    for (;;)
    {
      i += 1;
      break label89;
      i = 0;
      break;
      label119:
      Object localObject = this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getChildAt(i - j);
      LocalMediaInfo localLocalMediaInfo = this.jdField_a_of_type_Bogq.a(i);
      if (localObject == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("PhotoListActivity", 2, "updateCheckbox view = null at " + i);
        }
      }
      else if (localLocalMediaInfo == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("PhotoListActivity", 2, "updateCheckbox info = null at " + i);
        }
      }
      else
      {
        localObject = (bogs)this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getChildViewHolder((View)localObject);
        if ((paramBoolean) || (localLocalMediaInfo.selectStatus == 1)) {
          ((bogs)localObject).b.setAlpha(1.0F);
        } else {
          ((bogs)localObject).b.setAlpha(0.3F);
        }
      }
    }
  }
  
  public void c()
  {
    if ((this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetBubbleBubbleTextView.getVisibility() == 0) || (bozz.a().a("sp_key_ae_photo_switch_ratio_tips", false, 0))) {}
    boolean bool;
    do
    {
      return;
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetBubbleBubbleTextView.setIncludeFontPadding(false);
      int i = zps.a(getActivity(), 8.0F);
      int j = zps.a(getActivity(), 6.0F);
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetBubbleBubbleTextView.setPadding(i, j, i, j);
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetBubbleBubbleTextView.setTextSize(1, 14.0F);
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetBubbleBubbleTextView.setTextColor(-1);
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetBubbleBubbleTextView.jdField_a_of_type_Int = Color.parseColor("#252525");
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetBubbleBubbleTextView.b = zps.a(getActivity(), 6.0F);
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetBubbleBubbleTextView.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetBubbleBubbleTextView.d = zps.a(getActivity(), 6.0F);
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetBubbleBubbleTextView.setText(getActivity().getString(2131689682));
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetBubbleBubbleTextView.a();
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetBubbleBubbleTextView.setVisibility(0);
      bool = bozz.a().a("sp_key_ae_photo_switch_ratio_tips_should_auto_disappear", true, 0);
      bpam.a("PhotoListActivity", "checkShowSwitchRatioTips--shouldAutoDisappear=" + bool);
    } while (!bool);
    this.jdField_a_of_type_JavaLangRunnable = new AEAbstractPhotoListFragment.3(this);
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetBubbleBubbleTextView.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 5000L);
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetBubbleBubbleTextView.getVisibility() == 0)
    {
      if (this.jdField_a_of_type_JavaLangRunnable != null) {
        this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetBubbleBubbleTextView.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      }
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetBubbleBubbleTextView.setVisibility(8);
      bozz.a().a("sp_key_ae_photo_switch_ratio_tips", true, 0);
    }
  }
  
  public void e()
  {
    try
    {
      if (this.jdField_a_of_type_AndroidAppDialog != null) {
        f();
      }
      while (!this.jdField_a_of_type_AndroidAppDialog.isShowing())
      {
        this.jdField_a_of_type_AndroidAppDialog.show();
        return;
        this.jdField_a_of_type_AndroidAppDialog = a();
        this.jdField_a_of_type_AndroidAppDialog.setCancelable(true);
        this.jdField_a_of_type_AndroidAppDialog.show();
      }
      return;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.e("PhotoListActivity", 2, "show dialog error", localException);
      }
      this.jdField_a_of_type_AndroidAppDialog = null;
    }
  }
  
  public void f()
  {
    if (this.jdField_a_of_type_AndroidAppDialog != null) {}
    try
    {
      this.jdField_a_of_type_AndroidAppDialog.cancel();
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("PhotoListActivity", 2, "cancel dialog error", localIllegalArgumentException);
    }
  }
  
  public void g()
  {
    this.jdField_a_of_type_AndroidOsAsyncTask = new bogt(this);
    this.jdField_a_of_type_AndroidOsAsyncTask.execute(new Object[0]);
  }
  
  public void h()
  {
    int j = ((GridLayoutManager)this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getLayoutManager()).findFirstVisibleItemPosition();
    int k = ((GridLayoutManager)this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getLayoutManager()).findLastVisibleItemPosition();
    int i = j;
    if (i <= k)
    {
      Object localObject = this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getChildAt(i - j);
      LocalMediaInfo localLocalMediaInfo = this.jdField_a_of_type_Bogq.a(i);
      if (localObject == null) {
        if (QLog.isColorLevel()) {
          QLog.d("PhotoListActivity", 2, "updateCheckbox view = null at " + i);
        }
      }
      for (;;)
      {
        i += 1;
        break;
        if (localLocalMediaInfo == null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("PhotoListActivity", 2, "updateCheckbox info = null at " + i);
          }
        }
        else
        {
          int m = this.jdField_a_of_type_Bohc.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList.indexOf(localLocalMediaInfo.path);
          if (m >= 0)
          {
            localObject = (bogs)this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getChildViewHolder((View)localObject);
            if ((localObject != null) && (((bogs)localObject).a != null)) {
              ((bogs)localObject).a.setCheckedNumber(m + 1 + this.jdField_a_of_type_Bohc.a());
            }
          }
        }
      }
    }
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (paramCompoundButton.getId() == 2131374827) {
      this.jdField_a_of_type_Bohc.a(paramCompoundButton, paramBoolean);
    }
    EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
  }
  
  @TargetApi(9)
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_Bohc == null) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      int i = paramView.getId();
      if (i == 2131369042)
      {
        this.jdField_a_of_type_Bohc.a(paramView);
      }
      else if (i == 2131372952)
      {
        this.jdField_a_of_type_Bohc.b(paramView);
      }
      else if (i == 2131377324)
      {
        this.jdField_a_of_type_Bohc.c(paramView);
      }
      else
      {
        if (i == 2131369036)
        {
          if ((this.jdField_a_of_type_Bogi == null) || (!this.jdField_a_of_type_Bogi.isAdded())) {}
          for (boolean bool = true;; bool = false)
          {
            if (bool) {
              this.jdField_a_of_type_Bohc.b(getActivity().getIntent());
            }
            a(bool);
            break;
          }
        }
        if (i == 2131369073)
        {
          this.jdField_a_of_type_Bohc.e(paramView);
          if ((this.jdField_a_of_type_Bohc.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData != null) && (this.jdField_a_of_type_Bohc.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList != null))
          {
            bozv.a().a().b = bozv.d.longValue();
            bozv.a().a().a = bozv.a().b();
            bozr.a().a(this.jdField_a_of_type_Bohc.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList.size());
          }
        }
        else if (i == 2131366755)
        {
          bpvq.a(this.jdField_a_of_type_DovComQqImAeViewAECompoundButton.a(), 200L, null);
          this.jdField_a_of_type_Bohc.d(paramView);
          d();
        }
      }
    }
  }
  
  public void onCreate(@Nullable Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (Build.VERSION.SDK_INT > 23) {
      getActivity().getWindow().setBackgroundDrawable(null);
    }
    this.jdField_a_of_type_Bohc = a();
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoListBaseData = this.jdField_a_of_type_Bohc.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoListBaseData;
    this.jdField_a_of_type_AndroidContentSharedPreferences = BaseApplication.getContext().getSharedPreferences("share", 4);
    paramBundle = getResources();
    int i = paramBundle.getDisplayMetrics().widthPixels;
    this.c = paramBundle.getDimensionPixelSize(2131296637);
    this.jdField_a_of_type_Int = ((i - this.c * 2) / 3);
    this.jdField_b_of_type_Int = this.jdField_a_of_type_Int;
    paramBundle = getActivity().getIntent();
    this.jdField_a_of_type_Bohc.a(paramBundle);
    if (QLog.isColorLevel()) {
      QLog.d("SelectPhotoTrace", 2, "PhotoListActivity onCreate(),extra is:" + paramBundle.getExtras());
    }
    if (QLog.isColorLevel()) {
      QLog.d("SelectPhotoTrace", 2, "PhotoListActivity,hashCode is:" + System.identityHashCode(this));
    }
  }
  
  @Nullable
  public View onCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2131558492, paramViewGroup, false);
    ViewCompat.setOnApplyWindowInsetsListener(paramLayoutInflater, new bogo(this));
    ViewCompat.requestApplyInsets(paramLayoutInflater);
    FragmentCollector.onFragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.jdField_a_of_type_Bohc.f();
    if (this.jdField_a_of_type_DovComQqImAeAlbumAEAlbumLinearLayout != null) {
      this.jdField_a_of_type_DovComQqImAeAlbumAEAlbumLinearLayout.setScrollListener(null);
    }
    if (this.jdField_a_of_type_DovComQqImAeAlbumAEAlbumPreviewMaskLayout != null) {
      this.jdField_a_of_type_DovComQqImAeAlbumAEAlbumPreviewMaskLayout.setOnTouchCallback(null);
    }
  }
  
  public void onPause()
  {
    super.onPause();
    this.jdField_a_of_type_AndroidOsAsyncTask = null;
    d();
  }
  
  public void onResume()
  {
    super.onResume();
    this.jdField_a_of_type_Bohc.e();
  }
  
  public void onViewCreated(View paramView, @Nullable Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    a(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bogn
 * JD-Core Version:    0.7.0.1
 */