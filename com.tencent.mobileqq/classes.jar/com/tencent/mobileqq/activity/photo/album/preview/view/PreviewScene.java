package com.tencent.mobileqq.activity.photo.album.preview.view;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.photo.PeakFragmentActivity;
import com.tencent.mobileqq.activity.photo.album.OtherCommonData;
import com.tencent.mobileqq.activity.photo.album.PhotoCommonBaseData;
import com.tencent.mobileqq.activity.photo.album.QAlbumCommonUtil;
import com.tencent.mobileqq.activity.photo.album.preview.AlbumItemDecoration;
import com.tencent.mobileqq.activity.photo.album.preview.PhotoPreviewBaseData;
import com.tencent.mobileqq.activity.photo.album.preview.presenter.PreviewPresenter;
import com.tencent.mobileqq.widget.NumberCheckBox;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.richmediabrowser.model.RichMediaBaseData;
import com.tencent.richmediabrowser.model.RichMediaBrowserInfo;
import com.tencent.richmediabrowser.view.MainBrowserScene;
import com.tencent.richmediabrowser.view.recyclerview.BrowserRecyclerView;
import java.util.ArrayList;

public class PreviewScene
  extends MainBrowserScene
  implements CompoundButton.OnCheckedChangeListener
{
  float jdField_a_of_type_Float = 13.0F;
  public int a;
  public View a;
  public ViewGroup a;
  public Button a;
  public CheckBox a;
  public RelativeLayout a;
  public TextView a;
  public PeakFragmentActivity a;
  private PreviewPresenter<? extends OtherCommonData> jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPreviewPresenterPreviewPresenter;
  public ISceneCallback a;
  public NumberCheckBox a;
  float b;
  public int b;
  public View b;
  public CheckBox b;
  public TextView b;
  public View c;
  public TextView c;
  public TextView d;
  public TextView e;
  
  public PreviewScene(PeakFragmentActivity paramPeakFragmentActivity, PreviewPresenter paramPreviewPresenter)
  {
    super(paramPeakFragmentActivity, paramPreviewPresenter);
    this.jdField_b_of_type_Float = 9.0F;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPeakFragmentActivity = paramPeakFragmentActivity;
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPreviewPresenterPreviewPresenter = paramPreviewPresenter;
  }
  
  public int a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPreviewPresenterPreviewPresenter.getCurrentPosition();
  }
  
  public View a()
  {
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = new RelativeLayout(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPeakFragmentActivity);
    Object localObject = new RelativeLayout.LayoutParams(-1, -1);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundColor(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPeakFragmentActivity.getResources().getColor(2131167333));
    this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPreviewViewISceneCallback.a();
    localObject = this.jdField_a_of_type_AndroidViewView;
    if (localObject != null)
    {
      ((View)localObject).setId(View.generateViewId());
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPreviewViewISceneCallback.a();
      if (localObject != null) {
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_AndroidViewView, (ViewGroup.LayoutParams)localObject);
      } else {
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_AndroidViewView);
      }
    }
    this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPreviewViewISceneCallback.b();
    localObject = this.jdField_b_of_type_AndroidViewView;
    if (localObject != null)
    {
      ((View)localObject).setId(View.generateViewId());
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPreviewViewISceneCallback.b();
      if (localObject != null) {
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_b_of_type_AndroidViewView, (ViewGroup.LayoutParams)localObject);
      } else {
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_AndroidViewView);
      }
    }
    return this.jdField_a_of_type_AndroidWidgetRelativeLayout;
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
  
  public String a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPeakFragmentActivity.getResources().getString(2131694856, new Object[] { Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPreviewPresenterPreviewPresenter.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.maxSelectNum) });
  }
  
  public ArrayList<String> a()
  {
    ArrayList localArrayList = new ArrayList();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPreviewPresenterPreviewPresenter.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList.isEmpty())
    {
      int i = a();
      if ((i < this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPreviewPresenterPreviewPresenter.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPreviewPhotoPreviewBaseData.jdField_a_of_type_JavaUtilArrayList.size()) && (i != -1))
      {
        localArrayList.add(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPreviewPresenterPreviewPresenter.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPreviewPhotoPreviewBaseData.jdField_a_of_type_JavaUtilArrayList.get(i));
        return localArrayList;
      }
    }
    else
    {
      localArrayList.addAll(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPreviewPresenterPreviewPresenter.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList);
    }
    return localArrayList;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPreviewPresenterPreviewPresenter.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPreviewPhotoPreviewBaseData.m) {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
    } else {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(4);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPreviewPresenterPreviewPresenter.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPreviewPhotoPreviewBaseData.n)
    {
      localObject = this.e;
      if (localObject != null) {
        ((TextView)localObject).setVisibility(8);
      }
    }
    Object localObject = this.jdField_c_of_type_AndroidViewView;
    if (localObject != null) {
      ((View)localObject).setOnClickListener(new PreviewScene.1(this));
    }
    localObject = this.d;
    if (localObject != null) {
      ((TextView)localObject).setOnClickListener(new PreviewScene.2(this));
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPreviewViewISceneCallback.b();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPreviewPresenterPreviewPresenter.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.isSingleMode)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox;
      if (localObject != null) {
        ((NumberCheckBox)localObject).setVisibility(8);
      }
      localObject = this.jdField_c_of_type_AndroidViewView;
      if (localObject != null) {
        ((View)localObject).setVisibility(8);
      }
    }
  }
  
  public void a(int paramInt)
  {
    String str = getItem(paramInt).baseData.filePath;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPreviewPresenterPreviewPresenter.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedIndex.contains(Integer.valueOf(paramInt)))
    {
      if (str != null) {
        a(str);
      } else {
        this.jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox.setChecked(false);
      }
    }
    else {
      this.jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox.setChecked(false);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPreviewViewISceneCallback.b();
    if (!this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPreviewPresenterPreviewPresenter.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPreviewPhotoPreviewBaseData.n) {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPreviewPresenterPreviewPresenter.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPreviewPhotoPreviewBaseData.jdField_a_of_type_JavaUtilArrayList.size() > 1)
      {
        TextView localTextView = this.e;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramInt + 1);
        localStringBuilder.append(" / ");
        localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPreviewPresenterPreviewPresenter.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPreviewPhotoPreviewBaseData.jdField_a_of_type_JavaUtilArrayList.size());
        localTextView.setText(localStringBuilder.toString());
      }
      else
      {
        this.e.setText(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPeakFragmentActivity.getResources().getString(2131694994));
      }
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPreviewPresenterPreviewPresenter.a(str) == 1) && (!this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPreviewPresenterPreviewPresenter.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPreviewPhotoPreviewBaseData.m)) {
      e();
    }
  }
  
  public void a(View paramView)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPeakFragmentActivity.getResources();
    int i = a();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPreviewPresenterPreviewPresenter.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedIndex.contains(Integer.valueOf(i)))
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox.setChecked(false);
      int j = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPreviewPresenterPreviewPresenter.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedIndex.indexOf(Integer.valueOf(i));
      if (j >= 0)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPreviewPresenterPreviewPresenter.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedIndex.remove(j);
        if (i != -1) {
          this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPreviewPresenterPreviewPresenter.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList.remove(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPreviewPresenterPreviewPresenter.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPreviewPhotoPreviewBaseData.jdField_a_of_type_JavaUtilArrayList.get(i));
        }
      }
    }
    else
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPreviewPresenterPreviewPresenter.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList.size() >= this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPreviewPresenterPreviewPresenter.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.maxSelectNum)
      {
        long l = System.currentTimeMillis();
        if (l - this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPreviewPresenterPreviewPresenter.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPreviewPhotoPreviewBaseData.jdField_a_of_type_Long >= 700L)
        {
          QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPeakFragmentActivity, a(), 1000).a();
          this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPreviewPresenterPreviewPresenter.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPreviewPhotoPreviewBaseData.jdField_a_of_type_Long = l;
        }
        this.jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox.setChecked(false);
        return;
      }
      if (i != -1)
      {
        paramView = (String)this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPreviewPresenterPreviewPresenter.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPreviewPhotoPreviewBaseData.jdField_a_of_type_JavaUtilArrayList.get(i);
        this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPreviewPresenterPreviewPresenter.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList.add(paramView);
        this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPreviewPresenterPreviewPresenter.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedIndex.add(Integer.valueOf(i));
        a(paramView);
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPreviewViewISceneCallback.b();
  }
  
  public void a(ISceneCallback paramISceneCallback)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPreviewViewISceneCallback = paramISceneCallback;
  }
  
  public void a(String paramString)
  {
    a(paramString, -1);
  }
  
  public void a(String paramString, int paramInt)
  {
    if (paramInt >= 0)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox.setCheckedNumber(paramInt);
      return;
    }
    paramInt = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPreviewPresenterPreviewPresenter.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList.indexOf(paramString) + 1;
    if (paramInt <= 0)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox.setChecked(false);
      return;
    }
    if (paramInt >= 100) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox.setTextSize(this.jdField_b_of_type_Float);
    } else {
      this.jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox.setTextSize(this.jdField_a_of_type_Float);
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox.setCheckedNumber(paramInt);
  }
  
  public View b()
  {
    LayoutInflater localLayoutInflater = (LayoutInflater)this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPeakFragmentActivity.getSystemService("layout_inflater");
    View localView = null;
    if (localLayoutInflater != null) {
      localView = localLayoutInflater.inflate(2131561290, null);
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
  
  public void b()
  {
    Intent localIntent = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPeakFragmentActivity.getIntent();
    if ("FROM_PHOTO_LIST".equals(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPreviewPresenterPreviewPresenter.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPreviewPhotoPreviewBaseData.d))
    {
      localIntent.setClass(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPeakFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPreviewViewISceneCallback.a());
      if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPreviewPresenterPreviewPresenter.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.isSingleMode)
      {
        localIntent.removeExtra("PhotoConst.PHOTO_PATHS");
      }
      else
      {
        localIntent.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPreviewPresenterPreviewPresenter.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList);
        localIntent.putExtra("PhotoConst.editPathMap", this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPreviewPresenterPreviewPresenter.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPreviewPhotoPreviewBaseData.f);
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPeakFragmentActivity.startActivity(localIntent);
    }
    if (localIntent.getBooleanExtra("keep_selected_status_after_finish", false))
    {
      localIntent = new Intent();
      localIntent.putStringArrayListExtra("PhotoConst.SELECTED_PATHS", this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPreviewPresenterPreviewPresenter.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList);
      localIntent.putIntegerArrayListExtra("PhotoConst.SELECTED_INDEXS", this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPreviewPresenterPreviewPresenter.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedIndex);
      localIntent.putExtra("PhotoConst.editPathMap", this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPreviewPresenterPreviewPresenter.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPreviewPhotoPreviewBaseData.f);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPeakFragmentActivity.setResult(-1, localIntent);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPeakFragmentActivity.finish();
  }
  
  public View c()
  {
    LayoutInflater localLayoutInflater = (LayoutInflater)this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPeakFragmentActivity.getSystemService("layout_inflater");
    View localView = null;
    if (localLayoutInflater != null) {
      localView = localLayoutInflater.inflate(2131561289, null);
    }
    return localView;
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_AndroidWidgetButton != null)
    {
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPeakFragmentActivity.getResources();
      if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPreviewPresenterPreviewPresenter.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.customSendBtnText != null) {
        localObject = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPreviewPresenterPreviewPresenter.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.customSendBtnText;
      } else {
        localObject = ((Resources)localObject).getString(2131694839);
      }
      int i;
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPreviewPresenterPreviewPresenter.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPreviewPresenterPreviewPresenter.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList.size() > 0)) {
        i = 1;
      } else {
        i = 0;
      }
      if (i != 0)
      {
        this.jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
        if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPreviewPresenterPreviewPresenter.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.isSingleMode)
        {
          this.jdField_a_of_type_AndroidWidgetButton.setText((CharSequence)localObject);
        }
        else
        {
          Button localButton = this.jdField_a_of_type_AndroidWidgetButton;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append((String)localObject);
          localStringBuilder.append("(");
          localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPreviewPresenterPreviewPresenter.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList.size());
          localStringBuilder.append(")");
          localButton.setText(localStringBuilder.toString());
        }
      }
      else
      {
        this.jdField_a_of_type_AndroidWidgetButton.setText((CharSequence)localObject);
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox != null)
    {
      if ((!this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPreviewPresenterPreviewPresenter.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedIndex.contains(Integer.valueOf(a()))) && (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPreviewPresenterPreviewPresenter.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList.size() >= this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPreviewPresenterPreviewPresenter.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.maxSelectNum))
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox.setActivated(true);
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox.setActivated(false);
    }
  }
  
  public void d()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPreviewPresenterPreviewPresenter.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPreviewPhotoPreviewBaseData.m = false;
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(4);
  }
  
  public void e()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPreviewPresenterPreviewPresenter.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPreviewPhotoPreviewBaseData.m = true;
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
  }
  
  public void initView()
  {
    super.initView();
    a();
    Object localObject = this.jdField_b_of_type_AndroidViewView;
    if (localObject != null)
    {
      this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)((View)localObject).findViewById(2131363712));
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131370603));
      this.jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)this.jdField_b_of_type_AndroidViewView.findViewById(2131366959));
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131366960));
      this.jdField_b_of_type_AndroidWidgetCheckBox = ((CheckBox)this.jdField_b_of_type_AndroidViewView.findViewById(2131374724));
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131374730));
      this.jdField_a_of_type_AndroidWidgetButton = ((Button)this.jdField_b_of_type_AndroidViewView.findViewById(2131377197));
    }
    localObject = this.jdField_a_of_type_AndroidViewView;
    if (localObject != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox = ((NumberCheckBox)((View)localObject).findViewById(2131377175));
      this.jdField_c_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131377151);
      this.e = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131378784));
      this.d = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131363346));
    }
    localObject = this.jdField_a_of_type_AndroidWidgetCheckBox;
    if (localObject != null) {
      ((CheckBox)localObject).setVisibility(8);
    }
    localObject = this.jdField_b_of_type_AndroidWidgetTextView;
    if (localObject != null) {
      ((TextView)localObject).setVisibility(8);
    }
    localObject = this.jdField_b_of_type_AndroidWidgetCheckBox;
    if (localObject != null) {
      ((CheckBox)localObject).setVisibility(8);
    }
    localObject = this.jdField_c_of_type_AndroidWidgetTextView;
    if (localObject != null) {
      ((TextView)localObject).setVisibility(8);
    }
    localObject = this.jdField_a_of_type_AndroidWidgetTextView;
    if (localObject != null) {
      ((TextView)localObject).setVisibility(8);
    }
    getContentView().addView(this.jdField_a_of_type_AndroidWidgetRelativeLayout);
    if (this.recyclerView != null) {
      this.recyclerView.addItemDecoration(new AlbumItemDecoration(QAlbumCommonUtil.dp2px(2.5F, this.mContext.getResources())));
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPreviewViewISceneCallback.a();
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    int i = paramCompoundButton.getId();
    if (i == 2131374724) {
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPreviewViewISceneCallback.a(paramCompoundButton, paramBoolean);
    } else if (i == 2131366959) {
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPreviewViewISceneCallback.a(paramBoolean);
    }
    if ((!this.jdField_b_of_type_AndroidWidgetCheckBox.isChecked()) && (!this.jdField_a_of_type_AndroidWidgetCheckBox.isChecked()))
    {
      this.jdField_c_of_type_AndroidWidgetTextView.setTextColor(-1);
      this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(-1);
    }
    EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
  }
  
  public void onClickDragView()
  {
    super.onClickDragView();
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPreviewViewISceneCallback.onClickDragView();
  }
  
  public void onContentMove(float paramFloat)
  {
    super.onContentMove(paramFloat);
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPreviewViewISceneCallback.onContentMove(paramFloat);
  }
  
  public void onGestureFinish()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPreviewViewISceneCallback.onGestureFinish();
  }
  
  public void onItemSelected(int paramInt)
  {
    super.onItemSelected(paramInt);
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPreviewViewISceneCallback.a(paramInt);
  }
  
  public void onResetPosition()
  {
    super.onResetPosition();
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPreviewViewISceneCallback.onResetPosition();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.album.preview.view.PreviewScene
 * JD-Core Version:    0.7.0.1
 */