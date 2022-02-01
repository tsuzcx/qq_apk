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
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class LogoIconAdapter
  extends BaseAdapter
{
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private SparseArray<ImageView> jdField_a_of_type_AndroidUtilSparseArray;
  private FacePanelAdapter jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiFaceAdapterFacePanelAdapter;
  private int b;
  private int c;
  private int d;
  private int e;
  private int f;
  
  public LogoIconAdapter(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.b = DisplayUtil.b(this.jdField_a_of_type_AndroidContentContext, 30.0F);
    this.c = DisplayUtil.b(this.jdField_a_of_type_AndroidContentContext, 50.0F);
    this.d = DisplayUtil.b(this.jdField_a_of_type_AndroidContentContext, 45.0F);
    this.e = DisplayUtil.b(this.jdField_a_of_type_AndroidContentContext, 10.0F);
    this.f = DisplayUtil.b(this.jdField_a_of_type_AndroidContentContext, 7.5F);
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
    Object localObject;
    if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiFaceAdapterFacePanelAdapter == null)
    {
      localObject = paramView;
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return localObject;
    }
    label38:
    label83:
    FacePackage localFacePackage;
    if (paramView == null)
    {
      localObject = a(false);
      this.jdField_a_of_type_AndroidUtilSparseArray.put(paramInt, localObject);
      if (paramInt == this.jdField_a_of_type_Int) {
        ViewCompat.a((View)localObject, 1.0F);
      }
      ((ImageView)localObject).setContentDescription("");
      if (paramInt != 0) {
        break label142;
      }
      ((ImageView)localObject).setContentDescription(HardCodeUtil.a(2131706385));
      localFacePackage = (FacePackage)getItem(paramInt);
      if (localFacePackage != null)
      {
        if (localFacePackage.a == null) {
          break label160;
        }
        SLog.b("LogoIconAdapter", "logo is already load. ");
        ((ImageView)localObject).setImageDrawable(localFacePackage.a);
      }
    }
    for (;;)
    {
      break;
      localObject = (ImageView)paramView;
      ViewCompat.a((View)localObject, 0.5F);
      break label38;
      label142:
      if (paramInt != 1) {
        break label83;
      }
      ((ImageView)localObject).setContentDescription(HardCodeUtil.a(2131706384));
      break label83;
      label160:
      String str = (String)((ImageView)localObject).getTag(2131378926);
      if ((TextUtils.isEmpty(str)) || (!str.equals(localFacePackage.c)))
      {
        ((ImageView)localObject).setTag(2131378926, localFacePackage.c);
        ImageLoader.a().a(this.jdField_a_of_type_AndroidContentContext, (ImageView)localObject, localFacePackage.c, this.b, this.b, null);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.doodle.ui.face.adapter.LogoIconAdapter
 * JD-Core Version:    0.7.0.1
 */