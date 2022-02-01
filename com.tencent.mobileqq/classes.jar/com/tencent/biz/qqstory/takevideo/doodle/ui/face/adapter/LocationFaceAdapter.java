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
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

public class LocationFaceAdapter
  extends BaseFaceListAdapter<LocationFacePackage>
  implements View.OnClickListener
{
  public LocationFaceAdapter(Context paramContext)
  {
    super(paramContext);
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiFaceFacePackage == null)
    {
      localObject = paramView;
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return localObject;
    }
    if (paramView == null) {}
    for (Object localObject = new LocationFaceAdapter.LocationItemLayout(this.jdField_a_of_type_AndroidContentContext, paramViewGroup.getWidth(), ((LocationFacePackage)this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiFaceFacePackage).a(), ((LocationFacePackage)this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiFaceFacePackage).a(), this);; localObject = (LocationFaceAdapter.LocationItemLayout)paramView)
    {
      ((LocationFaceAdapter.LocationItemLayout)localObject).a((LocationFacePackage)this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiFaceFacePackage, paramInt, getCount());
      break;
    }
  }
  
  public void onClick(View paramView)
  {
    int i = ((Integer)paramView.getTag(2131378913)).intValue();
    LocationFacePackage.Item localItem = (LocationFacePackage.Item)((LocationFacePackage)this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiFaceFacePackage).a.get(i);
    ImageView localImageView = (ImageView)paramView;
    Boolean localBoolean = (Boolean)localImageView.getTag(2131378891);
    if ((localBoolean != null) && (localBoolean.booleanValue()))
    {
      localItem.a = localImageView.getDrawable();
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiFaceFacePanel$OnFaceSelectedListener.a(localItem);
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      SLog.b("LocationFaceAdapter", "ImageView drawable has not been downloaded.");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.doodle.ui.face.adapter.LocationFaceAdapter
 * JD-Core Version:    0.7.0.1
 */