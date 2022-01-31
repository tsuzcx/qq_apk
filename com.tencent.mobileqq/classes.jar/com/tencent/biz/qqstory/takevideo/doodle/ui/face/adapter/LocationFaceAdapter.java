package com.tencent.biz.qqstory.takevideo.doodle.ui.face.adapter;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.takevideo.doodle.ui.face.FacePanel.OnFaceSelectedListener;
import com.tencent.biz.qqstory.takevideo.doodle.ui.face.LocationFacePackage;
import com.tencent.biz.qqstory.takevideo.doodle.ui.face.LocationFacePackage.Item;
import java.util.List;
import okh;

public class LocationFaceAdapter
  extends BaseFaceListAdapter
  implements View.OnClickListener
{
  public LocationFaceAdapter(Context paramContext)
  {
    super(paramContext);
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiFaceFacePackage == null) {
      return paramView;
    }
    if (paramView == null) {}
    for (paramView = new okh(this.jdField_a_of_type_AndroidContentContext, paramViewGroup.getWidth(), ((LocationFacePackage)this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiFaceFacePackage).a(), ((LocationFacePackage)this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiFaceFacePackage).a(), this);; paramView = (okh)paramView)
    {
      paramView.a((LocationFacePackage)this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiFaceFacePackage, paramInt, getCount());
      return paramView;
    }
  }
  
  public void onClick(View paramView)
  {
    int i = ((Integer)paramView.getTag(2131362359)).intValue();
    LocationFacePackage.Item localItem = (LocationFacePackage.Item)((LocationFacePackage)this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiFaceFacePackage).a.get(i);
    paramView = (ImageView)paramView;
    Boolean localBoolean = (Boolean)paramView.getTag(2131362361);
    if ((localBoolean != null) && (localBoolean.booleanValue()))
    {
      localItem.a = paramView.getDrawable();
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiFaceFacePanel$OnFaceSelectedListener.a(localItem);
      return;
    }
    SLog.b("LocationFaceAdapter", "ImageView drawable has not been downloaded.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.doodle.ui.face.adapter.LocationFaceAdapter
 * JD-Core Version:    0.7.0.1
 */