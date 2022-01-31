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
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.Nullable;
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
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.album.PhotoListBaseData;
import com.tencent.mobileqq.activity.photo.album.QAlbumCustomAlbumConstants;
import com.tencent.mobileqq.activity.photo.album.QAlbumUtil;
import com.tencent.mobileqq.data.QQAlbumInfo;
import com.tencent.mobileqq.widget.NumberCheckBox;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.ae.album.AEAlbumLinearLayout;
import dov.com.qq.im.ae.album.AEAlbumPreviewMaskLayout;
import dov.com.qq.im.ae.album.fragment.AEAbstractPhotoListFragment.2;
import dov.com.qq.im.ae.album.nocropper.AECropperView;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public abstract class bkme
  extends Fragment
  implements View.OnClickListener, CompoundButton.OnCheckedChangeListener, bklv, bkmd
{
  public int a;
  Dialog jdField_a_of_type_AndroidAppDialog;
  SharedPreferences jdField_a_of_type_AndroidContentSharedPreferences;
  public AsyncTask<Object, Object, List<LocalMediaInfo>> a;
  public GridLayoutManager a;
  public RecyclerView a;
  public View a;
  public Button a;
  FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  public ImageView a;
  LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  public TextView a;
  public bklz a;
  public bkmg a;
  public bkmu a;
  PhotoListBaseData jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoListBaseData;
  public AEAlbumLinearLayout a;
  public AEAlbumPreviewMaskLayout a;
  public AECropperView a;
  public int b;
  public View b;
  public Button b;
  TextView b;
  int jdField_c_of_type_Int;
  View jdField_c_of_type_AndroidViewView;
  public int d;
  View d;
  
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
    return new Dialog(getActivity());
  }
  
  public abstract bklz a();
  
  protected abstract bkmu a();
  
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
    this.jdField_a_of_type_Bkmu.g();
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    ArrayList localArrayList = this.jdField_a_of_type_Bkmu.jdField_a_of_type_Aimj.selectedPhotoList;
    int j = ((GridLayoutManager)this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getLayoutManager()).findFirstVisibleItemPosition();
    int k = ((GridLayoutManager)this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getLayoutManager()).findLastVisibleItemPosition();
    int i = j;
    if (i <= k)
    {
      if ((paramBoolean) && (paramInt != i)) {}
      label390:
      for (;;)
      {
        i += 1;
        break;
        Object localObject = this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getChildAt(i - j);
        LocalMediaInfo localLocalMediaInfo = this.jdField_a_of_type_Bkmg.a(i);
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
          bkmi localbkmi;
          if (paramInt != i)
          {
            m = localArrayList.indexOf(localLocalMediaInfo.path);
            if (m >= 0)
            {
              localbkmi = (bkmi)this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getChildViewHolder((View)localObject);
              if ((localbkmi != null) && (localbkmi.a != null)) {
                localbkmi.a.setCheckedNumber(m + 1);
              }
            }
          }
          else
          {
            m = QAlbumUtil.getMediaType(localLocalMediaInfo);
            if ((m == 0) || (m == 1))
            {
              localbkmi = (bkmi)this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getChildViewHolder((View)localObject);
              int n = localLocalMediaInfo.selectStatus;
              if (n == 1)
              {
                localbkmi.a.setCheckedNumber(localArrayList.indexOf(localLocalMediaInfo.path) + 1);
                if (((View)localObject).getBackground() != null) {
                  ((View)localObject).setBackgroundDrawable(null);
                }
              }
              for (;;)
              {
                if (!AppSetting.c) {
                  break label390;
                }
                localObject = QAlbumUtil.createContentDescriptionWithCheckBox(m, localLocalMediaInfo, i, localbkmi.a.isChecked());
                localbkmi.a.setContentDescription((CharSequence)localObject);
                break;
                if (n == 3)
                {
                  localbkmi.a.setChecked(false);
                }
                else
                {
                  localbkmi.a.setChecked(false);
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
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)paramView.findViewById(2131362467));
    this.jdField_c_of_type_AndroidViewView = paramView.findViewById(2131368613);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131368644));
    this.jdField_c_of_type_AndroidViewView.setVisibility(0);
    this.jdField_c_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131368659));
    String str;
    if (this.jdField_a_of_type_Bkmu.jdField_a_of_type_Aimj.albumName != null) {
      str = this.jdField_a_of_type_Bkmu.jdField_a_of_type_Aimj.albumName;
    }
    for (;;)
    {
      a(str);
      this.d = paramView.findViewById(2131368656);
      this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131368606));
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetButton = ((Button)paramView.findViewById(2131372229));
      this.jdField_b_of_type_AndroidWidgetButton = ((Button)paramView.findViewById(2131376341));
      this.jdField_b_of_type_AndroidViewView = paramView.findViewById(2131378081);
      this.jdField_a_of_type_DovComQqImAeAlbumAEAlbumLinearLayout = ((AEAlbumLinearLayout)paramView.findViewById(2131362205));
      this.jdField_a_of_type_DovComQqImAeAlbumAEAlbumLinearLayout.setScrollListener(new bkmf(this));
      this.jdField_a_of_type_DovComQqImAeAlbumNocropperAECropperView = ((AECropperView)paramView.findViewById(2131362206));
      this.jdField_a_of_type_DovComQqImAeAlbumNocropperAECropperView.setMaxZoom(5.0F);
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131368840));
      this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
      this.jdField_a_of_type_DovComQqImAeAlbumAEAlbumPreviewMaskLayout = ((AEAlbumPreviewMaskLayout)paramView.findViewById(2131366441));
      this.jdField_a_of_type_DovComQqImAeAlbumAEAlbumPreviewMaskLayout.setOnTouchCallback(this);
      this.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131378848);
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = ((RecyclerView)paramView.findViewById(2131371834));
      ((DefaultItemAnimator)this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getItemAnimator()).setSupportsChangeAnimations(false);
      this.jdField_a_of_type_AndroidSupportV7WidgetGridLayoutManager = new GridLayoutManager(getActivity(), 3);
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setLayoutManager(this.jdField_a_of_type_AndroidSupportV7WidgetGridLayoutManager);
      this.jdField_a_of_type_Bkmg = new bkmg(this);
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setAdapter(this.jdField_a_of_type_Bkmg);
      this.jdField_a_of_type_Bkmu.c();
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoListBaseData.showMediaType == 2) {
        str = QAlbumCustomAlbumConstants.RECENT_ALBUM_NAME_VIDEO;
      } else {
        str = QAlbumCustomAlbumConstants.RECENT_ALBUM_NAME;
      }
    }
  }
  
  public void a(View paramView, int paramInt)
  {
    aimj localaimj = this.jdField_a_of_type_Bkmu.jdField_a_of_type_Aimj;
    int i = this.jdField_a_of_type_Bkmg.getItemViewType(paramInt);
    if (this.jdField_a_of_type_Bkmu.jdField_a_of_type_Bkmx != null) {}
    switch (i)
    {
    default: 
      return;
    case 0: 
      if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoListBaseData.isSingleMode)
      {
        this.jdField_a_of_type_Bkmu.jdField_a_of_type_Bkmx.a(paramView, paramInt);
        return;
      }
      paramView = this.jdField_a_of_type_Bkmu.jdField_a_of_type_Bkmx.a(paramView, paramInt);
      this.jdField_a_of_type_Bkmu.c(paramView);
      QAlbumUtil.anim(getActivity(), true, true);
      return;
    case 1: 
      this.jdField_a_of_type_Bkmu.jdField_a_of_type_Bkmx.b(paramView, paramInt);
      return;
    }
    this.jdField_a_of_type_Bkmu.jdField_a_of_type_Bkmx.c(paramView, paramInt);
  }
  
  public void a(QQAlbumInfo paramQQAlbumInfo, int paramInt, boolean paramBoolean)
  {
    if (paramBoolean) {
      if (this.jdField_a_of_type_Bkmu.jdField_a_of_type_Aimj.albumName == null) {
        break label62;
      }
    }
    label62:
    for (paramQQAlbumInfo = this.jdField_a_of_type_Bkmu.jdField_a_of_type_Aimj.albumName;; paramQQAlbumInfo = QAlbumCustomAlbumConstants.RECENT_ALBUM_NAME)
    {
      a(paramQQAlbumInfo);
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoListBaseData.firstResume = true;
      getActivity().runOnUiThread(new AEAbstractPhotoListFragment.2(this));
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
      QAlbumUtil.sLastAlbumPhotoCountMap.put(this.jdField_a_of_type_Bkmu.jdField_a_of_type_Aimj.albumId, Integer.valueOf(this.jdField_a_of_type_Bkmg.getItemCount()));
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
    if (this.jdField_a_of_type_Bklz == null)
    {
      if (paramBoolean)
      {
        this.jdField_a_of_type_Bklz = a();
        this.jdField_a_of_type_Bklz.a(this);
      }
    }
    else
    {
      localFragmentTransaction = getFragmentManager().beginTransaction();
      localFragmentTransaction.setTransition(4097);
      if ((!paramBoolean) || (this.jdField_a_of_type_Bklz.isAdded())) {
        break label166;
      }
      localObjectAnimator = ObjectAnimator.ofInt(this.jdField_a_of_type_AndroidWidgetFrameLayout, "backgroundColor", new int[] { getResources().getColor(2131165449), getResources().getColor(2131165460) });
      a(this.d, false);
      localFragmentTransaction.add(2131362467, this.jdField_a_of_type_Bklz, null);
    }
    for (;;)
    {
      localFragmentTransaction.addToBackStack(null);
      localFragmentTransaction.commit();
      localObjectAnimator.setDuration(300L);
      localObjectAnimator.setEvaluator(new ArgbEvaluator());
      localObjectAnimator.setRepeatMode(2);
      localObjectAnimator.start();
      this.jdField_a_of_type_Bkmu.a(paramBoolean);
      return;
      label166:
      localObjectAnimator = ObjectAnimator.ofInt(this.jdField_a_of_type_AndroidWidgetFrameLayout, "backgroundColor", new int[] { getResources().getColor(2131165460), getResources().getColor(2131165449) });
      a(this.d, true);
      localFragmentTransaction.remove(this.jdField_a_of_type_Bklz);
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
    int i = this.jdField_a_of_type_Bkmu.jdField_a_of_type_Aimj.selectedPhotoList.size();
    int j;
    if (((i == this.jdField_a_of_type_Bkmu.jdField_a_of_type_Aimj.maxSelectNum) && (!paramBoolean)) || ((i == this.jdField_a_of_type_Bkmu.jdField_a_of_type_Aimj.maxSelectNum - 1) && (paramBoolean)))
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
      if (this.jdField_a_of_type_Bkmg.getItemViewType(i) != 2) {
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
      LocalMediaInfo localLocalMediaInfo = this.jdField_a_of_type_Bkmg.a(i);
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
        localObject = (bkmi)this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getChildViewHolder((View)localObject);
        if ((paramBoolean) || (localLocalMediaInfo.selectStatus == 1)) {
          ((bkmi)localObject).b.setAlpha(1.0F);
        } else {
          ((bkmi)localObject).b.setAlpha(0.3F);
        }
      }
    }
  }
  
  public void c()
  {
    try
    {
      if (this.jdField_a_of_type_AndroidAppDialog != null) {
        d();
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
  
  public void d()
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
  
  public void e()
  {
    this.jdField_a_of_type_AndroidOsAsyncTask = new bkmj(this);
    this.jdField_a_of_type_AndroidOsAsyncTask.execute(new Object[0]);
  }
  
  public void f()
  {
    int j = ((GridLayoutManager)this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getLayoutManager()).findFirstVisibleItemPosition();
    int k = ((GridLayoutManager)this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getLayoutManager()).findLastVisibleItemPosition();
    int i = j;
    if (i <= k)
    {
      Object localObject = this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getChildAt(i - j);
      LocalMediaInfo localLocalMediaInfo = this.jdField_a_of_type_Bkmg.a(i);
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
          int m = this.jdField_a_of_type_Bkmu.jdField_a_of_type_Aimj.selectedPhotoList.indexOf(localLocalMediaInfo.path);
          if (m >= 0)
          {
            localObject = (bkmi)this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getChildViewHolder((View)localObject);
            if ((localObject != null) && (((bkmi)localObject).a != null)) {
              ((bkmi)localObject).a.setCheckedNumber(m + 1);
            }
          }
        }
      }
    }
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    aimj localaimj = this.jdField_a_of_type_Bkmu.jdField_a_of_type_Aimj;
    if (paramCompoundButton.getId() == 2131373917) {
      this.jdField_a_of_type_Bkmu.a(paramCompoundButton, paramBoolean);
    }
  }
  
  @TargetApi(9)
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_Bkmu == null) {}
    int i;
    do
    {
      do
      {
        return;
        i = paramView.getId();
        if (i == 2131368613)
        {
          this.jdField_a_of_type_Bkmu.a(paramView);
          return;
        }
        if (i == 2131372229)
        {
          this.jdField_a_of_type_Bkmu.b(paramView);
          return;
        }
        if (i == 2131376341)
        {
          this.jdField_a_of_type_Bkmu.c(paramView);
          return;
        }
        if (i == 2131368606)
        {
          if ((this.jdField_a_of_type_Bklz == null) || (!this.jdField_a_of_type_Bklz.isAdded())) {}
          for (boolean bool = true;; bool = false)
          {
            if (bool) {
              this.jdField_a_of_type_Bkmu.b(getActivity().getIntent());
            }
            a(bool);
            return;
          }
        }
        if (i != 2131368644) {
          break;
        }
        this.jdField_a_of_type_Bkmu.e(paramView);
      } while ((this.jdField_a_of_type_Bkmu.jdField_a_of_type_Aimj == null) || (this.jdField_a_of_type_Bkmu.jdField_a_of_type_Aimj.selectedPhotoList == null));
      bler.a().a().b = bler.d.longValue();
      bler.a().a().a = bler.a().a();
      blen.a().a(this.jdField_a_of_type_Bkmu.jdField_a_of_type_Aimj.selectedPhotoList.size());
      return;
    } while (i != 2131368840);
    this.jdField_a_of_type_Bkmu.d(paramView);
  }
  
  public void onCreate(@Nullable Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (Build.VERSION.SDK_INT > 23) {
      getActivity().getWindow().setBackgroundDrawable(null);
    }
    this.jdField_a_of_type_Bkmu = a();
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoListBaseData = this.jdField_a_of_type_Bkmu.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoListBaseData;
    this.jdField_a_of_type_AndroidContentSharedPreferences = BaseApplication.getContext().getSharedPreferences("share", 4);
    paramBundle = getResources();
    int i = paramBundle.getDisplayMetrics().widthPixels;
    this.jdField_c_of_type_Int = paramBundle.getDimensionPixelSize(2131296582);
    this.jdField_a_of_type_Int = ((i - this.jdField_c_of_type_Int * 2) / 3);
    this.jdField_b_of_type_Int = this.jdField_a_of_type_Int;
    paramBundle = getActivity().getIntent();
    this.jdField_a_of_type_Bkmu.a(paramBundle);
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
    return paramLayoutInflater.inflate(2131558479, paramViewGroup, false);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.jdField_a_of_type_Bkmu.f();
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
  }
  
  public void onResume()
  {
    super.onResume();
    this.jdField_a_of_type_Bkmu.e();
  }
  
  public void onViewCreated(View paramView, @Nullable Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    a(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkme
 * JD-Core Version:    0.7.0.1
 */