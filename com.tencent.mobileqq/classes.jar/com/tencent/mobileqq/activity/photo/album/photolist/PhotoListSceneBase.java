package com.tencent.mobileqq.activity.photo.album.photolist;

import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.content.res.Resources;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.os.Environment;
import android.support.v7.widget.GridLayoutManager;
import android.text.TextUtils;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.aio.photo.PeakFragmentActivity;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.album.OtherCommonData;
import com.tencent.mobileqq.activity.photo.album.PhotoCommonBaseData;
import com.tencent.mobileqq.activity.photo.album.QAlbumCustomAlbumConstants;
import com.tencent.mobileqq.activity.photo.album.QAlbumUtil;
import com.tencent.mobileqq.activity.photo.album.albumlist.AbstractAlbumListFragment;
import com.tencent.mobileqq.activity.photo.album.albumlist.IAlbumListChoose;
import com.tencent.mobileqq.activity.photo.album.querymedia.MediaQueryHelper;
import com.tencent.mobileqq.data.QQAlbumInfo;
import com.tencent.mobileqq.widget.NumberCheckBox;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.PhotoGridView;
import com.tencent.widget.PhotoGridView.OnSelectListener;
import com.tencent.widget.TriangleView;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class PhotoListSceneBase
  implements View.OnClickListener, CompoundButton.OnCheckedChangeListener, IAlbumListChoose, ISceneCallBack
{
  public AsyncTask<Object, Object, List<LocalMediaInfo>> a;
  public GridLayoutManager a;
  public View a;
  public Button a;
  public FrameLayout a;
  public LinearLayout a;
  public RelativeLayout a;
  public TextView a;
  public PeakFragmentActivity a;
  public AbstractAlbumListFragment a;
  public PhotoListAdapter a;
  public PhotoListBaseData a;
  public PhotoListCustomization<? extends OtherCommonData> a;
  PhotoGridView.OnSelectListener a;
  public PhotoGridView a;
  public TriangleView a;
  public View b;
  public TextView b;
  public View c;
  public TextView c;
  
  public PhotoListSceneBase(PhotoListCustomization<? extends OtherCommonData> paramPhotoListCustomization)
  {
    this.jdField_a_of_type_ComTencentWidgetPhotoGridView$OnSelectListener = new GridSelectListener(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListAdapter = null;
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListCustomization = paramPhotoListCustomization;
    if (paramPhotoListCustomization != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPeakFragmentActivity = paramPhotoListCustomization.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPeakFragmentActivity;
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListBaseData = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListCustomization.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListBaseData;
      this.jdField_a_of_type_ComTencentWidgetPhotoGridView$OnSelectListener = new GridSelectListener(this);
    }
  }
  
  private void a(int paramInt1, ArrayList<String> paramArrayList, int paramInt2, View paramView, LocalMediaInfo paramLocalMediaInfo)
  {
    if (paramInt1 != paramInt2)
    {
      paramInt1 = paramArrayList.indexOf(paramLocalMediaInfo.path);
      if (paramInt1 >= 0)
      {
        paramArrayList = (Holder)paramView.getTag();
        if ((paramArrayList != null) && (paramArrayList.a != null)) {
          paramArrayList.a.setCheckedNumber(paramInt1 + 1);
        }
      }
    }
    else
    {
      paramInt1 = QAlbumUtil.getMediaType(paramLocalMediaInfo);
      if ((paramInt1 == 0) || (paramInt1 == 1))
      {
        Holder localHolder = (Holder)paramView.getTag();
        int i = paramLocalMediaInfo.selectStatus;
        if (i == 1)
        {
          if (localHolder.a != null) {
            localHolder.a.setCheckedNumber(paramArrayList.indexOf(paramLocalMediaInfo.path) + 1);
          }
          if (paramView.getBackground() != null) {
            paramView.setBackgroundDrawable(null);
          }
        }
        else if (i == 3)
        {
          if (localHolder.a != null) {
            localHolder.a.setChecked(false);
          }
        }
        else
        {
          if (localHolder.a != null) {
            localHolder.a.setChecked(false);
          }
          if (paramView.getBackground() != null) {
            paramView.setBackgroundDrawable(null);
          }
        }
        if ((AppSetting.d) && (localHolder.a != null))
        {
          paramArrayList = QAlbumUtil.createContentDescriptionWithCheckBox(paramInt1, paramLocalMediaInfo, paramInt2, localHolder.a.isChecked());
          localHolder.a.setContentDescription(paramArrayList);
        }
      }
    }
  }
  
  private boolean a(boolean paramBoolean, int paramInt)
  {
    int i = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListCustomization.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.maxSelectNum;
    boolean bool = true;
    if ((paramInt != i) || (paramBoolean))
    {
      if ((paramInt == this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListCustomization.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.maxSelectNum - 1) && (paramBoolean)) {
        return true;
      }
      bool = false;
    }
    return bool;
  }
  
  public View a()
  {
    LayoutInflater localLayoutInflater = (LayoutInflater)this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPeakFragmentActivity.getSystemService("layout_inflater");
    View localView = null;
    if (localLayoutInflater != null) {
      localView = localLayoutInflater.inflate(2131561287, null);
    }
    return localView;
  }
  
  public RelativeLayout.LayoutParams a()
  {
    Object localObject = this.jdField_a_of_type_AndroidViewView;
    if ((localObject != null) && (((View)localObject).getLayoutParams() != null)) {
      return new RelativeLayout.LayoutParams(this.jdField_a_of_type_AndroidViewView.getLayoutParams());
    }
    localObject = new RelativeLayout.LayoutParams(-1, (int)this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPeakFragmentActivity.getResources().getDimension(2131299168));
    ((RelativeLayout.LayoutParams)localObject).addRule(10);
    return localObject;
  }
  
  @TargetApi(8)
  public File a()
  {
    Object localObject1 = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("JPEG_");
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append("_");
    String str = ((StringBuilder)localObject2).toString();
    if ("mounted".equals(Environment.getExternalStorageState()))
    {
      boolean bool = false;
      if (Build.VERSION.SDK_INT > 7)
      {
        localObject1 = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM);
        bool = true;
      }
      else
      {
        localObject2 = new File(Environment.getExternalStorageDirectory(), "DCIM");
        localObject1 = localObject2;
        if (!((File)localObject2).exists())
        {
          bool = ((File)localObject2).mkdirs();
          localObject1 = localObject2;
        }
      }
      if (bool)
      {
        localObject1 = File.createTempFile(str, ".jpg", (File)localObject1);
        this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListBaseData.e = ((File)localObject1).getAbsolutePath();
        return localObject1;
      }
    }
    return null;
  }
  
  public void a()
  {
    View localView = this.jdField_a_of_type_AndroidViewView;
    if (localView != null)
    {
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131369202));
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131369249));
      this.jdField_a_of_type_ComTencentWidgetTriangleView = ((TriangleView)this.jdField_a_of_type_AndroidViewView.findViewById(2131369245));
      this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131369196));
    }
    localView = this.jdField_b_of_type_AndroidViewView;
    if (localView != null)
    {
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131373035));
      this.jdField_a_of_type_AndroidWidgetButton = ((Button)this.jdField_b_of_type_AndroidViewView.findViewById(2131377197));
    }
    localView = this.jdField_c_of_type_AndroidViewView;
    if (localView != null) {
      this.jdField_a_of_type_ComTencentWidgetPhotoGridView = ((PhotoGridView)localView.findViewById(2131372603));
    }
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    ArrayList localArrayList = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListCustomization.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList;
    int j = this.jdField_a_of_type_AndroidSupportV7WidgetGridLayoutManager.findFirstVisibleItemPosition();
    int k = this.jdField_a_of_type_AndroidSupportV7WidgetGridLayoutManager.findLastVisibleItemPosition();
    int i = j;
    while (i <= k)
    {
      if ((!paramBoolean) || (paramInt == i))
      {
        Object localObject = this.jdField_a_of_type_ComTencentWidgetPhotoGridView.getChildAt(i - j);
        LocalMediaInfo localLocalMediaInfo = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListAdapter.a(i);
        if (localObject == null)
        {
          if (QLog.isColorLevel())
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("updateCheckbox view = null at ");
            ((StringBuilder)localObject).append(i);
            QLog.d("QQAlbum", 2, ((StringBuilder)localObject).toString());
          }
        }
        else if (localLocalMediaInfo == null)
        {
          if (QLog.isColorLevel())
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("updateCheckbox info = null at ");
            ((StringBuilder)localObject).append(i);
            QLog.d("QQAlbum", 2, ((StringBuilder)localObject).toString());
          }
        }
        else {
          a(paramInt, localArrayList, i, (View)localObject, localLocalMediaInfo);
        }
      }
      i += 1;
    }
  }
  
  public void a(QQAlbumInfo paramQQAlbumInfo, int paramInt, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      TextView localTextView = this.jdField_c_of_type_AndroidWidgetTextView;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListCustomization.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.albumName != null) {
        paramQQAlbumInfo = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListCustomization.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.albumName;
      } else {
        paramQQAlbumInfo = QAlbumCustomAlbumConstants.RECENT_ALBUM_NAME;
      }
      localTextView.setText(paramQQAlbumInfo);
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListBaseData.l = true;
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListCustomization.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.createMediaQueryHelper(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPeakFragmentActivity);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPeakFragmentActivity.runOnUiThread(new PhotoListSceneBase.2(this));
    }
    a(false);
  }
  
  public void a(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListBaseData.q)
    {
      QAlbumUtil.sLastAlbumRecordTime = System.currentTimeMillis();
      QAlbumUtil.sLastAlbumPhotoCountMap.put(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListCustomization.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.albumId, Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListAdapter.getItemCount()));
      if (!TextUtils.isEmpty(paramString))
      {
        QAlbumUtil.sLastAlbumPath = paramString;
        HashMap localHashMap = QAlbumUtil.sSelectItemAlbum;
        if (localHashMap.containsKey(paramString))
        {
          paramString = (Pair)localHashMap.get(paramString);
          QAlbumUtil.sLastAlbumId = (String)paramString.first;
          QAlbumUtil.sLastAlbumName = (String)paramString.second;
          QAlbumUtil.putLastAlbumInfo(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPeakFragmentActivity, QAlbumUtil.sLastAlbumId, QAlbumUtil.sLastAlbumName);
        }
      }
    }
    QAlbumUtil.clearSelectItemInfo();
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumAlbumlistAbstractAlbumListFragment == null) {
      if (paramBoolean)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumAlbumlistAbstractAlbumListFragment = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListCustomization.a();
        this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumAlbumlistAbstractAlbumListFragment.a = this;
      }
      else
      {
        return;
      }
    }
    FragmentManager localFragmentManager = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPeakFragmentActivity.getSupportFragmentManager();
    FragmentTransaction localFragmentTransaction = localFragmentManager.beginTransaction();
    localFragmentTransaction.setTransition(4097);
    if (paramBoolean)
    {
      localObjectAnimator = ObjectAnimator.ofInt(this.jdField_a_of_type_AndroidWidgetFrameLayout, "backgroundColor", new int[] { this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPeakFragmentActivity.getResources().getColor(2131165474), this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPeakFragmentActivity.getResources().getColor(2131165485) });
      QAlbumUtil.rotate180Degrees(this.jdField_a_of_type_ComTencentWidgetTriangleView, false);
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumAlbumlistAbstractAlbumListFragment.isAdded()) || (localFragmentManager.findFragmentByTag(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumAlbumlistAbstractAlbumListFragment.toString()) != null)) {}
    }
    try
    {
      localFragmentTransaction.add(this.jdField_a_of_type_AndroidWidgetFrameLayout.getId(), this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumAlbumlistAbstractAlbumListFragment, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumAlbumlistAbstractAlbumListFragment.toString());
    }
    catch (IllegalStateException localIllegalStateException)
    {
      label166:
      break label166;
    }
    localFragmentTransaction.show(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumAlbumlistAbstractAlbumListFragment);
    break label253;
    localFragmentTransaction.show(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumAlbumlistAbstractAlbumListFragment);
    break label253;
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofInt(this.jdField_a_of_type_AndroidWidgetFrameLayout, "backgroundColor", new int[] { this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPeakFragmentActivity.getResources().getColor(2131165485), this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPeakFragmentActivity.getResources().getColor(2131165474) });
    QAlbumUtil.rotate180Degrees(this.jdField_a_of_type_ComTencentWidgetTriangleView, true);
    localFragmentTransaction.hide(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumAlbumlistAbstractAlbumListFragment);
    label253:
    localFragmentTransaction.commit();
    localObjectAnimator.setDuration(300L);
    localObjectAnimator.setEvaluator(new ArgbEvaluator());
    localObjectAnimator.setRepeatMode(2);
    localObjectAnimator.start();
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListCustomization.a(paramBoolean);
  }
  
  public View b()
  {
    LayoutInflater localLayoutInflater = (LayoutInflater)this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPeakFragmentActivity.getSystemService("layout_inflater");
    View localView = null;
    if (localLayoutInflater != null) {
      localView = localLayoutInflater.inflate(2131561283, null);
    }
    return localView;
  }
  
  public RelativeLayout.LayoutParams b()
  {
    Object localObject = this.jdField_b_of_type_AndroidViewView;
    if ((localObject != null) && (((View)localObject).getLayoutParams() != null)) {
      return new RelativeLayout.LayoutParams(this.jdField_b_of_type_AndroidViewView.getLayoutParams());
    }
    localObject = new RelativeLayout.LayoutParams(-1, -2);
    ((RelativeLayout.LayoutParams)localObject).addRule(12);
    return localObject;
  }
  
  protected void b()
  {
    a();
    Object localObject = this.jdField_b_of_type_AndroidWidgetTextView;
    if (localObject != null)
    {
      ((TextView)localObject).setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
    }
    TextView localTextView = this.jdField_c_of_type_AndroidWidgetTextView;
    if (localTextView != null)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListCustomization.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.albumName != null) {
        localObject = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListCustomization.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.albumName;
      } else if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListCustomization.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.showMediaType == 2) {
        localObject = QAlbumCustomAlbumConstants.RECENT_ALBUM_NAME_VIDEO;
      } else {
        localObject = QAlbumCustomAlbumConstants.RECENT_ALBUM_NAME;
      }
      localTextView.setText((CharSequence)localObject);
    }
    localObject = this.jdField_a_of_type_ComTencentWidgetTriangleView;
    if (localObject != null) {
      ((TriangleView)localObject).setColor(this.jdField_c_of_type_AndroidWidgetTextView.getCurrentTextColor());
    }
    localObject = this.jdField_a_of_type_AndroidWidgetLinearLayout;
    if (localObject != null) {
      ((LinearLayout)localObject).setOnClickListener(this);
    }
    this.jdField_a_of_type_AndroidSupportV7WidgetGridLayoutManager = new GridLayoutManager(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPeakFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListCustomization.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListBaseData.g);
    this.jdField_a_of_type_ComTencentWidgetPhotoGridView.setScrollBarStyle(0);
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListAdapter = new PhotoListAdapter(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListCustomization);
    localObject = this.jdField_a_of_type_ComTencentWidgetPhotoGridView;
    if (localObject != null)
    {
      ((PhotoGridView)localObject).setLayoutManager(this.jdField_a_of_type_AndroidSupportV7WidgetGridLayoutManager);
      this.jdField_a_of_type_ComTencentWidgetPhotoGridView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListAdapter);
      this.jdField_a_of_type_ComTencentWidgetPhotoGridView.setOnIndexChangedListener(this.jdField_a_of_type_ComTencentWidgetPhotoGridView$OnSelectListener);
      this.jdField_a_of_type_ComTencentWidgetPhotoGridView.addOnScrollListener(new PhotoListSceneBase.1(this));
    }
  }
  
  public void b(boolean paramBoolean)
  {
    if (a(paramBoolean, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListCustomization.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList.size()))
    {
      int j = this.jdField_a_of_type_AndroidSupportV7WidgetGridLayoutManager.findFirstVisibleItemPosition();
      int k = this.jdField_a_of_type_AndroidSupportV7WidgetGridLayoutManager.findLastVisibleItemPosition();
      int i = j;
      while (i <= k)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListAdapter.getItemViewType(i) != 2)
        {
          Object localObject2 = this.jdField_a_of_type_ComTencentWidgetPhotoGridView.getChildAt(i - j);
          Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListAdapter.a(i);
          if (localObject2 == null)
          {
            if (QLog.isColorLevel())
            {
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append("updateCheckbox view = null at ");
              ((StringBuilder)localObject1).append(i);
              QLog.d("QQAlbum", 2, ((StringBuilder)localObject1).toString());
            }
          }
          else if (localObject1 == null)
          {
            if (QLog.isColorLevel())
            {
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append("updateCheckbox info = null at ");
              ((StringBuilder)localObject1).append(i);
              QLog.d("QQAlbum", 2, ((StringBuilder)localObject1).toString());
            }
          }
          else
          {
            localObject2 = (Holder)((View)localObject2).getTag();
            if ((!paramBoolean) && (((LocalMediaInfo)localObject1).selectStatus != 1)) {
              ((Holder)localObject2).b.setAlpha(0.3F);
            } else {
              ((Holder)localObject2).b.setAlpha(1.0F);
            }
          }
        }
        i += 1;
      }
    }
  }
  
  public View c()
  {
    LayoutInflater localLayoutInflater = (LayoutInflater)this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPeakFragmentActivity.getSystemService("layout_inflater");
    View localView = null;
    if (localLayoutInflater != null) {
      localView = localLayoutInflater.inflate(2131561282, null);
    }
    return localView;
  }
  
  public RelativeLayout.LayoutParams c()
  {
    Object localObject = this.jdField_c_of_type_AndroidViewView;
    if ((localObject != null) && (((View)localObject).getLayoutParams() != null)) {
      localObject = new RelativeLayout.LayoutParams(this.jdField_c_of_type_AndroidViewView.getLayoutParams());
    } else {
      localObject = new RelativeLayout.LayoutParams(-1, -1);
    }
    View localView = this.jdField_a_of_type_AndroidViewView;
    if (localView != null) {
      ((RelativeLayout.LayoutParams)localObject).addRule(3, localView.getId());
    }
    localView = this.jdField_b_of_type_AndroidViewView;
    if (localView != null) {
      ((RelativeLayout.LayoutParams)localObject).addRule(2, localView.getId());
    }
    return localObject;
  }
  
  public void c()
  {
    int j = this.jdField_a_of_type_AndroidSupportV7WidgetGridLayoutManager.findFirstVisibleItemPosition();
    int k = this.jdField_a_of_type_AndroidSupportV7WidgetGridLayoutManager.findLastVisibleItemPosition();
    int i = j;
    while (i <= k)
    {
      Object localObject = this.jdField_a_of_type_ComTencentWidgetPhotoGridView.getChildAt(i - j);
      LocalMediaInfo localLocalMediaInfo = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListAdapter.a(i);
      if (localObject == null)
      {
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("updateCheckbox view = null at ");
          ((StringBuilder)localObject).append(i);
          QLog.d("QQAlbum", 2, ((StringBuilder)localObject).toString());
        }
      }
      else if (localLocalMediaInfo == null)
      {
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("updateCheckbox info = null at ");
          ((StringBuilder)localObject).append(i);
          QLog.d("QQAlbum", 2, ((StringBuilder)localObject).toString());
        }
      }
      else
      {
        int m = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListCustomization.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList.indexOf(localLocalMediaInfo.path);
        if (m >= 0)
        {
          localObject = (Holder)((View)localObject).getTag();
          if ((localObject != null) && (((Holder)localObject).a != null)) {
            ((Holder)localObject).a.setCheckedNumber(m + 1);
          }
        }
      }
      i += 1;
    }
  }
  
  public void c(boolean paramBoolean)
  {
    if ((paramBoolean) && (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListCustomization.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.mMediaQueryHelper != null))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListCustomization.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.mMediaQueryHelper.close();
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListCustomization.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.mMediaQueryHelper = null;
    }
    this.jdField_a_of_type_AndroidOsAsyncTask = new QueryPhotoTask(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListCustomization);
    this.jdField_a_of_type_AndroidOsAsyncTask.execute(new Object[0]);
  }
  
  public View d()
  {
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = new RelativeLayout(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPeakFragmentActivity);
    Object localObject = new RelativeLayout.LayoutParams(-1, -1);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListCustomization.a();
    localObject = this.jdField_a_of_type_AndroidViewView;
    if (localObject != null)
    {
      ((View)localObject).setId(View.generateViewId());
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListCustomization.a();
      if (localObject != null) {
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_AndroidViewView, (ViewGroup.LayoutParams)localObject);
      } else {
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_AndroidViewView);
      }
    }
    this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListCustomization.b();
    localObject = this.jdField_b_of_type_AndroidViewView;
    if (localObject != null)
    {
      ((View)localObject).setId(View.generateViewId());
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListCustomization.b();
      if (localObject != null) {
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_b_of_type_AndroidViewView, (ViewGroup.LayoutParams)localObject);
      } else {
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_AndroidViewView);
      }
    }
    this.jdField_c_of_type_AndroidViewView = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListCustomization.c();
    localObject = this.jdField_c_of_type_AndroidViewView;
    if (localObject != null)
    {
      ((View)localObject).setId(View.generateViewId());
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListCustomization.c();
      if (localObject != null) {
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_c_of_type_AndroidViewView, (ViewGroup.LayoutParams)localObject);
      } else {
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_c_of_type_AndroidViewView);
      }
    }
    this.jdField_a_of_type_AndroidWidgetFrameLayout = new FrameLayout(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPeakFragmentActivity);
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setId(View.generateViewId());
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setBackgroundColor(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPeakFragmentActivity.getResources().getColor(2131165474));
    localObject = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListCustomization.d();
    if (localObject != null) {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_AndroidWidgetFrameLayout, (ViewGroup.LayoutParams)localObject);
    } else {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_AndroidWidgetFrameLayout);
    }
    return this.jdField_a_of_type_AndroidWidgetRelativeLayout;
  }
  
  public RelativeLayout.LayoutParams d()
  {
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
    View localView = this.jdField_a_of_type_AndroidViewView;
    if (localView != null) {
      localLayoutParams.addRule(3, localView.getId());
    }
    return localLayoutParams;
  }
  
  public void d()
  {
    if (!this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListCustomization.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.mMediaQueryHelper.mTraversalDone) {
      new QueryNextTask(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListCustomization).execute(new Object[0]);
    }
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (paramCompoundButton.getId() == 2131374724) {
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListCustomization.a(paramCompoundButton, paramBoolean);
    }
    EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
  }
  
  @TargetApi(9)
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i == 2131369202)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListCustomization.b(paramView);
    }
    else if (i == 2131373035)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListCustomization.c(paramView);
    }
    else if (i == 2131377197)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListCustomization.a(paramView);
    }
    else if (i == 2131369196)
    {
      AbstractAlbumListFragment localAbstractAlbumListFragment = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumAlbumlistAbstractAlbumListFragment;
      boolean bool;
      if ((localAbstractAlbumListFragment != null) && (localAbstractAlbumListFragment.isAdded()) && (!this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumAlbumlistAbstractAlbumListFragment.isHidden())) {
        bool = false;
      } else {
        bool = true;
      }
      if (bool) {
        this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListCustomization.c(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPeakFragmentActivity.getIntent());
      }
      a(bool);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.album.photolist.PhotoListSceneBase
 * JD-Core Version:    0.7.0.1
 */