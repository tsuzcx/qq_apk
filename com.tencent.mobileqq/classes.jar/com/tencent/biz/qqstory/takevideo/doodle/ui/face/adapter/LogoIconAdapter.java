package com.tencent.biz.qqstory.takevideo.doodle.ui.face.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.takevideo.doodle.compat.ViewCompat;
import com.tencent.biz.qqstory.takevideo.doodle.loader.ImageLoader;
import com.tencent.biz.qqstory.takevideo.doodle.ui.face.FacePackage;
import com.tencent.biz.qqstory.takevideo.doodle.util.DisplayUtil;

public class LogoIconAdapter
  extends BaseAdapter
{
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private SparseArray jdField_a_of_type_AndroidUtilSparseArray;
  private FacePanelAdapter jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiFaceAdapterFacePanelAdapter;
  private int b;
  private int c;
  private int d;
  private int e;
  private int f;
  
  public LogoIconAdapter(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.b = DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 30.0F);
    this.c = DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 50.0F);
    this.d = DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 45.0F);
    this.e = DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 10.0F);
    this.f = DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 7.5F);
    this.jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  }
  
  private ImageView a(boolean paramBoolean)
  {
    ImageView localImageView = new ImageView(this.jdField_a_of_type_AndroidContentContext);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(this.c, this.d);
    localImageView.setPadding(this.e, this.f, this.e, this.f);
    localImageView.setLayoutParams(localLayoutParams);
    localImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
    if (paramBoolean) {}
    for (float f1 = 1.0F;; f1 = 0.5F)
    {
      ViewCompat.a(localImageView, f1);
      return localImageView;
    }
  }
  
  public int a()
  {
    return this.c;
  }
  
  public void a()
  {
    super.notifyDataSetChanged();
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(FacePanelAdapter paramFacePanelAdapter)
  {
    if (paramFacePanelAdapter == null) {
      SLog.b("LogoIconAdapter", "setFacePanelAdapter: null.");
    }
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiFaceAdapterFacePanelAdapter = paramFacePanelAdapter;
    super.notifyDataSetChanged();
  }
  
  public void b(int paramInt)
  {
    ImageView localImageView = (ImageView)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    if (localImageView == null) {
      SLog.e("LogoIconAdapter", "position is illegal:" + paramInt + ", the array size: " + this.jdField_a_of_type_AndroidUtilSparseArray.size());
    }
    FacePackage localFacePackage;
    String str;
    do
    {
      return;
      if ((this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiFaceAdapterFacePanelAdapter == null) || (paramInt < 0) || (paramInt >= this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiFaceAdapterFacePanelAdapter.a()))
      {
        SLog.e("LogoIconAdapter", "position is illegal or Adapter is null, position:" + paramInt);
        return;
      }
      localFacePackage = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiFaceAdapterFacePanelAdapter.a(paramInt);
      if (localFacePackage == null)
      {
        SLog.e("LogoIconAdapter", "FacePackage is null.");
        return;
      }
      str = (String)localImageView.getTag(2131362360);
    } while ((!TextUtils.isEmpty(str)) && (str.equals(localFacePackage.c)));
    localImageView.setTag(2131362360, localFacePackage.c);
    ImageLoader.a().a(this.jdField_a_of_type_AndroidContentContext, localImageView, localFacePackage.c, this.b, this.b, null);
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiFaceAdapterFacePanelAdapter == null) {
      return 0;
    }
    return this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiFaceAdapterFacePanelAdapter.a();
  }
  
  public Object getItem(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiFaceAdapterFacePanelAdapter == null) {
      return null;
    }
    return this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiFaceAdapterFacePanelAdapter.a(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiFaceAdapterFacePanelAdapter == null) {
      return paramView;
    }
    if (paramView == null)
    {
      paramView = a(false);
      this.jdField_a_of_type_AndroidUtilSparseArray.put(paramInt, paramView);
      if (paramInt == this.jdField_a_of_type_Int) {
        ViewCompat.a(paramView, 1.0F);
      }
      paramView.setContentDescription("");
      if (paramInt != 0) {
        break label108;
      }
      paramView.setContentDescription("表情贴纸");
      label57:
      paramViewGroup = (FacePackage)getItem(paramInt);
      if (paramViewGroup != null)
      {
        if (paramViewGroup.a == null) {
          break label122;
        }
        SLog.b("LogoIconAdapter", "logo is already load. ");
        paramView.setImageDrawable(paramViewGroup.a);
      }
    }
    for (;;)
    {
      return paramView;
      paramView = (ImageView)paramView;
      ViewCompat.a(paramView, 0.5F);
      break;
      label108:
      if (paramInt != 1) {
        break label57;
      }
      paramView.setContentDescription("地点贴纸");
      break label57;
      label122:
      String str = (String)paramView.getTag(2131362360);
      if ((TextUtils.isEmpty(str)) || (!str.equals(paramViewGroup.c)))
      {
        paramView.setTag(2131362360, paramViewGroup.c);
        ImageLoader.a().a(this.jdField_a_of_type_AndroidContentContext, paramView, paramViewGroup.c, this.b, this.b, null);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.doodle.ui.face.adapter.LogoIconAdapter
 * JD-Core Version:    0.7.0.1
 */