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
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.biz.qqstory.view.widget.bubble.BubbleTextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.album.PhotoCommonBaseData;
import com.tencent.mobileqq.activity.photo.album.PhotoListBaseData;
import com.tencent.mobileqq.activity.photo.album.QAlbumCustomAlbumConstants;
import com.tencent.mobileqq.activity.photo.album.QAlbumUtil;
import com.tencent.mobileqq.data.QQAlbumInfo;
import com.tencent.mobileqq.videoplatform.view.BaseVideoView;
import com.tencent.mobileqq.widget.NumberCheckBox;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.qqlive.module.videoreport.inject.fragment.FragmentCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.ReportFragment;
import dov.com.qq.im.ae.album.AEAlbumLinearLayout;
import dov.com.qq.im.ae.album.AEAlbumPreviewMaskLayout;
import dov.com.qq.im.ae.album.data.AEAlbumLogicData;
import dov.com.qq.im.ae.album.fragment.AEAbstractPhotoListFragment.4;
import dov.com.qq.im.ae.album.fragment.AEAbstractPhotoListFragment.6;
import dov.com.qq.im.ae.album.fragment.AEAbstractPhotoListFragment.7;
import dov.com.qq.im.ae.album.nocropper.AECropperView;
import dov.com.qq.im.ae.view.AECompoundButton;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public abstract class bmyq
  extends ReportFragment
  implements View.OnClickListener, CompoundButton.OnCheckedChangeListener, bmyg, bmyp
{
  public int a;
  Dialog jdField_a_of_type_AndroidAppDialog;
  SharedPreferences jdField_a_of_type_AndroidContentSharedPreferences;
  public AsyncTask<Object, Object, List<LocalMediaInfo>> a;
  public GridLayoutManager a;
  public RecyclerView a;
  View jdField_a_of_type_AndroidViewView;
  public ViewGroup a;
  FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  public ImageView a;
  LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  public TextView a;
  public bmyl a;
  public bmyv a;
  public bmzh a;
  private BubbleTextView jdField_a_of_type_ComTencentBizQqstoryViewWidgetBubbleBubbleTextView;
  PhotoListBaseData jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoListBaseData;
  public BaseVideoView a;
  public AEAlbumLinearLayout a;
  public AEAlbumPreviewMaskLayout a;
  public AECropperView a;
  public AECompoundButton a;
  private Runnable jdField_a_of_type_JavaLangRunnable;
  public final boolean a;
  public int b;
  View jdField_b_of_type_AndroidViewView;
  private FrameLayout jdField_b_of_type_AndroidWidgetFrameLayout;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  public TextView b;
  private boolean jdField_b_of_type_Boolean;
  int jdField_c_of_type_Int;
  private FrameLayout jdField_c_of_type_AndroidWidgetFrameLayout;
  public TextView c;
  public int d;
  TextView d;
  
  public bmyq()
  {
    this.jdField_a_of_type_Boolean = bnri.a();
  }
  
  @Nullable
  private LocalMediaInfo a(Object paramObject)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (this.jdField_a_of_type_Bmzh.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData != null)
    {
      localObject1 = localObject2;
      if (this.jdField_a_of_type_Bmzh.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedMediaInfoHashMap != null) {
        localObject1 = (LocalMediaInfo)this.jdField_a_of_type_Bmzh.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedMediaInfoHashMap.get(paramObject);
      }
    }
    localObject2 = localObject1;
    if (localObject1 == null)
    {
      localObject2 = localObject1;
      if (this.jdField_a_of_type_Bmzh.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData != null)
      {
        localObject2 = localObject1;
        if (this.jdField_a_of_type_Bmzh.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.allMediaInfoHashMap != null) {
          localObject2 = (LocalMediaInfo)this.jdField_a_of_type_Bmzh.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.allMediaInfoHashMap.get(paramObject);
        }
      }
    }
    return localObject2;
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
  
  private void b(View paramView)
  {
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131369307));
    this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView = ((BaseVideoView)bapu.b(getActivity(), 113L, null, null));
    this.jdField_c_of_type_AndroidWidgetFrameLayout.post(new AEAbstractPhotoListFragment.4(this));
    this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView.setOnClickListener(new bmyu(this));
  }
  
  private void e(boolean paramBoolean)
  {
    int i = 0;
    boolean bool;
    if (!paramBoolean)
    {
      bool = true;
      bmvv.a(bool, getActivity());
      if (!paramBoolean) {
        break label53;
      }
    }
    for (;;)
    {
      ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)this.jdField_b_of_type_AndroidWidgetFrameLayout.getLayoutParams();
      localMarginLayoutParams.bottomMargin = i;
      this.jdField_b_of_type_AndroidWidgetFrameLayout.setLayoutParams(localMarginLayoutParams);
      return;
      bool = false;
      break;
      label53:
      i = getResources().getDimensionPixelSize(2131296273);
    }
  }
  
  private void f(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(getResources().getDrawable(2130837717), null, null, null);
      this.jdField_b_of_type_AndroidWidgetTextView.setBackgroundResource(2130837715);
      this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#4183FC"));
      this.jdField_b_of_type_AndroidWidgetTextView.setText(2131689693);
      return;
    }
    this.jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(getResources().getDrawable(2130837716), null, null, null);
    this.jdField_b_of_type_AndroidWidgetTextView.setBackgroundResource(2130837715);
    this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(-16777216);
    this.jdField_b_of_type_AndroidWidgetTextView.setText(2131689694);
  }
  
  protected Dialog a()
  {
    return new ReportDialog(getActivity());
  }
  
  public abstract bmyl a();
  
  protected abstract bmzh a();
  
  public abstract Class a();
  
  public void a()
  {
    this.jdField_a_of_type_Bmzh.h();
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    ArrayList localArrayList = this.jdField_a_of_type_Bmzh.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList;
    int j = ((GridLayoutManager)this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getLayoutManager()).findFirstVisibleItemPosition();
    int k = ((GridLayoutManager)this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getLayoutManager()).findLastVisibleItemPosition();
    int i = j;
    if (i <= k)
    {
      if ((paramBoolean) && (paramInt != i)) {}
      label416:
      for (;;)
      {
        i += 1;
        break;
        Object localObject = this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getChildAt(i - j);
        LocalMediaInfo localLocalMediaInfo = this.jdField_a_of_type_Bmyv.a(i);
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
          bmyx localbmyx;
          if (paramInt != i)
          {
            m = localArrayList.indexOf(localLocalMediaInfo.path);
            if (m >= 0)
            {
              localbmyx = (bmyx)this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getChildViewHolder((View)localObject);
              if ((localbmyx != null) && (localbmyx.a != null)) {
                localbmyx.a.setCheckedNumber(m + 1 + this.jdField_a_of_type_Bmzh.jdField_a_of_type_DovComQqImAeAlbumDataAEAlbumLogicData.initialHasPickedNum);
              }
            }
          }
          else
          {
            m = QAlbumUtil.getMediaType(localLocalMediaInfo);
            if ((m == 0) || (m == 1))
            {
              localbmyx = (bmyx)this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getChildViewHolder((View)localObject);
              int n = localLocalMediaInfo.selectStatus;
              if (n == 1)
              {
                localbmyx.a.setCheckedNumber(localArrayList.indexOf(localLocalMediaInfo.path) + 1 + this.jdField_a_of_type_Bmzh.jdField_a_of_type_DovComQqImAeAlbumDataAEAlbumLogicData.initialHasPickedNum);
                if (((View)localObject).getBackground() != null) {
                  ((View)localObject).setBackgroundDrawable(null);
                }
              }
              for (;;)
              {
                if (!AppSetting.c) {
                  break label416;
                }
                localObject = QAlbumUtil.createContentDescriptionWithCheckBox(m, localLocalMediaInfo, i, localbmyx.a.isChecked());
                localbmyx.a.setContentDescription((CharSequence)localObject);
                break;
                if (n == 3)
                {
                  localbmyx.a.setChecked(false);
                }
                else
                {
                  localbmyx.a.setChecked(false);
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
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)paramView.findViewById(2131362588));
    this.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131369231);
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131369262));
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.d = ((TextView)paramView.findViewById(2131369278));
    String str;
    if (this.jdField_a_of_type_Bmzh.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.albumName != null) {
      str = this.jdField_a_of_type_Bmzh.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.albumName;
    }
    for (;;)
    {
      a(str);
      this.jdField_b_of_type_AndroidViewView = paramView.findViewById(2131369274);
      this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131369225));
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener(this);
      this.jdField_b_of_type_AndroidWidgetFrameLayout = ((FrameLayout)paramView.findViewById(2131366901));
      this.jdField_a_of_type_DovComQqImAeAlbumAEAlbumLinearLayout = ((AEAlbumLinearLayout)paramView.findViewById(2131362295));
      this.jdField_a_of_type_DovComQqImAeAlbumAEAlbumLinearLayout.setScrollListener(new bmys(this));
      this.jdField_a_of_type_DovComQqImAeAlbumNocropperAECropperView = ((AECropperView)paramView.findViewById(2131362296));
      this.jdField_a_of_type_DovComQqImAeAlbumNocropperAECropperView.setMaxZoom(5.0F);
      this.jdField_a_of_type_DovComQqImAeViewAECompoundButton = ((AECompoundButton)paramView.findViewById(2131366899));
      this.jdField_a_of_type_DovComQqImAeViewAECompoundButton.setOnClickListener(this);
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetBubbleBubbleTextView = ((BubbleTextView)paramView.findViewById(2131378351));
      this.jdField_a_of_type_DovComQqImAeAlbumAEAlbumPreviewMaskLayout = ((AEAlbumPreviewMaskLayout)paramView.findViewById(2131366902));
      this.jdField_a_of_type_DovComQqImAeAlbumAEAlbumPreviewMaskLayout.setOnTouchCallback(this);
      this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)paramView.findViewById(2131370361));
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131369479));
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131380048));
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = ((RecyclerView)paramView.findViewById(2131372700));
      ((DefaultItemAnimator)this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getItemAnimator()).setSupportsChangeAnimations(false);
      this.jdField_a_of_type_AndroidSupportV7WidgetGridLayoutManager = new GridLayoutManager(getActivity(), 3);
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setLayoutManager(this.jdField_a_of_type_AndroidSupportV7WidgetGridLayoutManager);
      this.jdField_a_of_type_Bmyv = new bmyv(this);
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setAdapter(this.jdField_a_of_type_Bmyv);
      this.jdField_c_of_type_AndroidWidgetFrameLayout = ((FrameLayout)paramView.findViewById(2131373133));
      b(paramView);
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131380031));
      this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(new bmyt(this));
      this.jdField_a_of_type_Bmzh.d();
      return;
      if (this.jdField_a_of_type_Bmzh.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.showMediaType == 2) {
        str = QAlbumCustomAlbumConstants.RECENT_ALBUM_NAME_VIDEO;
      } else {
        str = QAlbumCustomAlbumConstants.RECENT_ALBUM_NAME;
      }
    }
  }
  
  public void a(QQAlbumInfo paramQQAlbumInfo, int paramInt, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      bnrh.b("PhotoListActivity", "onAlbumListChoose--albumId=" + paramQQAlbumInfo._id);
      this.jdField_a_of_type_Bmzh.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.albumName = paramQQAlbumInfo.name;
      this.jdField_a_of_type_Bmzh.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.albumId = paramQQAlbumInfo._id;
      if (this.jdField_a_of_type_Bmzh.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.albumName == null) {
        break label119;
      }
    }
    label119:
    for (paramQQAlbumInfo = this.jdField_a_of_type_Bmzh.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.albumName;; paramQQAlbumInfo = QAlbumCustomAlbumConstants.RECENT_ALBUM_NAME)
    {
      a(paramQQAlbumInfo);
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoListBaseData.firstResume = true;
      getActivity().runOnUiThread(new AEAbstractPhotoListFragment.7(this));
      c(false);
      return;
    }
  }
  
  public void a(CharSequence paramCharSequence)
  {
    getActivity().setTitle(paramCharSequence);
    this.d.setText(paramCharSequence);
  }
  
  public void a(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoListBaseData.isRecodeLastAlbumPath)
    {
      QAlbumUtil.sLastAlbumRecordTime = System.currentTimeMillis();
      QAlbumUtil.sLastAlbumPhotoCountMap.put(this.jdField_a_of_type_Bmzh.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.albumId, Integer.valueOf(this.jdField_a_of_type_Bmyv.getItemCount()));
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
    if (paramBoolean) {}
    for (int i = 0;; i = 8)
    {
      localImageView.setVisibility(i);
      return;
    }
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
    this.jdField_a_of_type_DovComQqImAeViewAECompoundButton.setVisibility(0);
    e();
  }
  
  public void c(boolean paramBoolean)
  {
    FragmentTransaction localFragmentTransaction;
    ObjectAnimator localObjectAnimator;
    if (this.jdField_a_of_type_Bmyl == null)
    {
      if (paramBoolean)
      {
        this.jdField_a_of_type_Bmyl = a();
        this.jdField_a_of_type_Bmyl.a(this);
      }
    }
    else
    {
      localFragmentTransaction = getFragmentManager().beginTransaction();
      localFragmentTransaction.setTransition(4097);
      if ((!paramBoolean) || (this.jdField_a_of_type_Bmyl.isAdded())) {
        break label166;
      }
      localObjectAnimator = ObjectAnimator.ofInt(this.jdField_a_of_type_AndroidWidgetFrameLayout, "backgroundColor", new int[] { getResources().getColor(2131165498), getResources().getColor(2131165509) });
      a(this.jdField_b_of_type_AndroidViewView, false);
      localFragmentTransaction.add(2131362588, this.jdField_a_of_type_Bmyl, null);
    }
    for (;;)
    {
      localFragmentTransaction.addToBackStack(null);
      localFragmentTransaction.commit();
      localObjectAnimator.setDuration(300L);
      localObjectAnimator.setEvaluator(new ArgbEvaluator());
      localObjectAnimator.setRepeatMode(2);
      localObjectAnimator.start();
      this.jdField_a_of_type_Bmzh.b(paramBoolean);
      return;
      label166:
      localObjectAnimator = ObjectAnimator.ofInt(this.jdField_a_of_type_AndroidWidgetFrameLayout, "backgroundColor", new int[] { getResources().getColor(2131165509), getResources().getColor(2131165498) });
      a(this.jdField_b_of_type_AndroidViewView, true);
      localFragmentTransaction.remove(this.jdField_a_of_type_Bmyl);
    }
  }
  
  public void d()
  {
    this.jdField_a_of_type_DovComQqImAeViewAECompoundButton.setVisibility(8);
    f();
  }
  
  public void d(boolean paramBoolean)
  {
    int i = this.jdField_a_of_type_Bmzh.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList.size() + this.jdField_a_of_type_Bmzh.jdField_a_of_type_DovComQqImAeAlbumDataAEAlbumLogicData.initialHasPickedNum;
    int j;
    if (((i == this.jdField_a_of_type_Bmzh.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.maxSelectNum) && (!paramBoolean)) || ((i == this.jdField_a_of_type_Bmzh.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.maxSelectNum - 1) && (paramBoolean)))
    {
      i = 1;
      if (i == 0) {
        return;
      }
      j = ((GridLayoutManager)this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getLayoutManager()).findFirstVisibleItemPosition();
      int k = ((GridLayoutManager)this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getLayoutManager()).findLastVisibleItemPosition();
      i = j;
      label100:
      if (i > k) {
        return;
      }
      if (this.jdField_a_of_type_Bmyv.getItemViewType(i) != 2) {
        break label130;
      }
    }
    for (;;)
    {
      i += 1;
      break label100;
      i = 0;
      break;
      label130:
      Object localObject = this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getChildAt(i - j);
      LocalMediaInfo localLocalMediaInfo = this.jdField_a_of_type_Bmyv.a(i);
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
        localObject = (bmyx)this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getChildViewHolder((View)localObject);
        if ((paramBoolean) || (localLocalMediaInfo.selectStatus == 1)) {
          ((bmyx)localObject).jdField_b_of_type_AndroidWidgetImageView.setAlpha(1.0F);
        } else {
          ((bmyx)localObject).jdField_b_of_type_AndroidWidgetImageView.setAlpha(0.3F);
        }
      }
    }
  }
  
  public void e()
  {
    if ((this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetBubbleBubbleTextView.getVisibility() == 0) || (bnqu.a().a("sp_key_ae_photo_switch_ratio_tips", false, 0))) {}
    boolean bool;
    do
    {
      return;
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetBubbleBubbleTextView.setIncludeFontPadding(false);
      int i = UIUtils.dip2px(getActivity(), 8.0F);
      int j = UIUtils.dip2px(getActivity(), 6.0F);
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetBubbleBubbleTextView.setPadding(i, j, i, j);
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetBubbleBubbleTextView.setTextSize(1, 14.0F);
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetBubbleBubbleTextView.setTextColor(-1);
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetBubbleBubbleTextView.jdField_a_of_type_Int = Color.parseColor("#252525");
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetBubbleBubbleTextView.b = UIUtils.dip2px(getActivity(), 6.0F);
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetBubbleBubbleTextView.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetBubbleBubbleTextView.d = UIUtils.dip2px(getActivity(), 6.0F);
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetBubbleBubbleTextView.setText(getActivity().getString(2131689689));
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetBubbleBubbleTextView.a();
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetBubbleBubbleTextView.setVisibility(0);
      bool = bnqu.a().a("sp_key_ae_photo_switch_ratio_tips_should_auto_disappear", true, 0);
      bnrh.a("PhotoListActivity", "checkShowSwitchRatioTips--shouldAutoDisappear=" + bool);
    } while (!bool);
    this.jdField_a_of_type_JavaLangRunnable = new AEAbstractPhotoListFragment.6(this);
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetBubbleBubbleTextView.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 5000L);
  }
  
  public void f()
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetBubbleBubbleTextView.getVisibility() == 0)
    {
      if (this.jdField_a_of_type_JavaLangRunnable != null) {
        this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetBubbleBubbleTextView.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      }
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetBubbleBubbleTextView.setVisibility(8);
      bnqu.a().a("sp_key_ae_photo_switch_ratio_tips", true, 0);
    }
  }
  
  public void g()
  {
    try
    {
      if (this.jdField_a_of_type_AndroidAppDialog != null) {
        h();
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
  
  public void h()
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
  
  public void i()
  {
    this.jdField_a_of_type_AndroidOsAsyncTask = new bmyy(this);
    this.jdField_a_of_type_AndroidOsAsyncTask.execute(new Object[0]);
  }
  
  public void j()
  {
    int j = ((GridLayoutManager)this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getLayoutManager()).findFirstVisibleItemPosition();
    int k = ((GridLayoutManager)this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getLayoutManager()).findLastVisibleItemPosition();
    int i = j;
    if (i <= k)
    {
      Object localObject = this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getChildAt(i - j);
      LocalMediaInfo localLocalMediaInfo = this.jdField_a_of_type_Bmyv.a(i);
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
          int m = this.jdField_a_of_type_Bmzh.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList.indexOf(localLocalMediaInfo.path);
          if (m >= 0)
          {
            localObject = (bmyx)this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getChildViewHolder((View)localObject);
            if ((localObject != null) && (((bmyx)localObject).a != null)) {
              ((bmyx)localObject).a.setCheckedNumber(m + 1 + this.jdField_a_of_type_Bmzh.jdField_a_of_type_DovComQqImAeAlbumDataAEAlbumLogicData.initialHasPickedNum);
            }
          }
        }
      }
    }
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (paramCompoundButton.getId() == 2131374832) {
      this.jdField_a_of_type_Bmzh.a(paramCompoundButton, paramBoolean);
    }
    EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
  }
  
  @TargetApi(9)
  public void onClick(View paramView)
  {
    int i = 0;
    boolean bool = false;
    if (this.jdField_a_of_type_Bmzh == null) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      int j = paramView.getId();
      if (j == 2131369231)
      {
        this.jdField_a_of_type_Bmzh.a(paramView);
      }
      else if (j == 2131373132)
      {
        this.jdField_a_of_type_Bmzh.b(paramView);
      }
      else if (j == 2131377349)
      {
        this.jdField_a_of_type_Bmzh.c(paramView);
      }
      else if (j == 2131369225)
      {
        if ((this.jdField_a_of_type_Bmyl == null) || (!this.jdField_a_of_type_Bmyl.isAdded())) {
          bool = true;
        }
        if (bool) {
          this.jdField_a_of_type_Bmzh.b(getActivity().getIntent());
        }
        c(bool);
      }
      else if (j == 2131369262)
      {
        this.jdField_a_of_type_Bmzh.e(paramView);
        if ((this.jdField_a_of_type_Bmzh.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData != null) && (this.jdField_a_of_type_Bmzh.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList != null))
        {
          j = this.jdField_a_of_type_Bmzh.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList.size();
          bnqq.a().a().a = bnqq.a().b();
          if (this.jdField_a_of_type_Bmzh.jdField_a_of_type_DovComQqImAeAlbumDataAEAlbumLogicData.canMixPhotoAndVideo)
          {
            bnqq.a().a().b = bnqq.g.longValue();
            long l = 0L;
            Iterator localIterator = this.jdField_a_of_type_Bmzh.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList.iterator();
            while (localIterator.hasNext())
            {
              LocalMediaInfo localLocalMediaInfo = a(localIterator.next());
              if ((localLocalMediaInfo != null) && (QAlbumUtil.getMediaType(localLocalMediaInfo) == 1))
              {
                i += 1;
                l += localLocalMediaInfo.mDuration / 1000L;
              }
            }
            bnqq.a().a().f = i;
            bnqq.a().a().c = l;
          }
          for (i = j - i;; i = j)
          {
            bnqm.a().a(i);
            break;
            bnqq.a().a().b = bnqq.d.longValue();
          }
        }
      }
      else if (j == 2131366899)
      {
        book.a(this.jdField_a_of_type_DovComQqImAeViewAECompoundButton.a(), 200L, null);
        this.jdField_a_of_type_Bmzh.d(paramView);
        f();
      }
    }
  }
  
  public void onCreate(@Nullable Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (Build.VERSION.SDK_INT > 23) {
      getActivity().getWindow().setBackgroundDrawable(null);
    }
    this.jdField_a_of_type_Bmzh = a();
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoListBaseData = this.jdField_a_of_type_Bmzh.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoListBaseData;
    this.jdField_a_of_type_AndroidContentSharedPreferences = BaseApplication.getContext().getSharedPreferences("share", 4);
    paramBundle = getResources();
    int i = paramBundle.getDisplayMetrics().widthPixels;
    this.jdField_c_of_type_Int = paramBundle.getDimensionPixelSize(2131296693);
    this.jdField_a_of_type_Int = ((i - this.jdField_c_of_type_Int * 2) / 3);
    this.jdField_b_of_type_Int = this.jdField_a_of_type_Int;
    paramBundle = getActivity().getIntent();
    this.jdField_a_of_type_Bmzh.a(paramBundle);
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
    paramLayoutInflater = paramLayoutInflater.inflate(2131558502, paramViewGroup, false);
    ViewCompat.setOnApplyWindowInsetsListener(paramLayoutInflater, new bmyr(this));
    ViewCompat.requestApplyInsets(paramLayoutInflater);
    FragmentCollector.onFragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.jdField_a_of_type_Bmzh.g();
    if (this.jdField_a_of_type_DovComQqImAeAlbumAEAlbumLinearLayout != null) {
      this.jdField_a_of_type_DovComQqImAeAlbumAEAlbumLinearLayout.setScrollListener(null);
    }
    if (this.jdField_a_of_type_DovComQqImAeAlbumAEAlbumPreviewMaskLayout != null) {
      this.jdField_a_of_type_DovComQqImAeAlbumAEAlbumPreviewMaskLayout.setOnTouchCallback(null);
    }
  }
  
  public void onPause()
  {
    bnrh.b("PhotoListActivity", "onPause---");
    super.onPause();
    this.jdField_a_of_type_AndroidOsAsyncTask = null;
    f();
    if ((this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView != null) && (this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView.isPlaying()))
    {
      this.jdField_b_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView.pause();
    }
  }
  
  public void onResume()
  {
    bnrh.b("PhotoListActivity", "onResume---");
    super.onResume();
    this.jdField_a_of_type_Bmzh.f();
    if ((this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView != null) && (this.jdField_b_of_type_Boolean))
    {
      this.jdField_b_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView.resume();
    }
  }
  
  public void onViewCreated(View paramView, @Nullable Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    a(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmyq
 * JD-Core Version:    0.7.0.1
 */