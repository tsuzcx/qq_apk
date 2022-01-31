package com.tencent.biz.qqstory.takevideo.doodle.ui.face.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.takevideo.doodle.compat.ViewCompat;
import com.tencent.biz.qqstory.takevideo.doodle.layer.model.SelectedItem;
import com.tencent.biz.qqstory.takevideo.doodle.ui.face.FacePanel.OnFaceSelectedListener;
import com.tencent.biz.qqstory.takevideo.doodle.ui.face.NormalFacePackage;
import java.io.File;
import okj;

public class NormalFaceAdapter
  extends BaseFaceListAdapter
  implements View.OnClickListener
{
  public NormalFaceAdapter(Context paramContext)
  {
    super(paramContext);
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiFaceFacePackage == null) {
      return paramView;
    }
    if (paramView == null) {}
    for (paramView = new okj(this.jdField_a_of_type_AndroidContentContext, paramViewGroup.getWidth(), ((NormalFacePackage)this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiFaceFacePackage).a(), ((NormalFacePackage)this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiFaceFacePackage).a(), this);; paramView = (okj)paramView)
    {
      paramView.a((NormalFacePackage)this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiFaceFacePackage, paramInt, getCount());
      return paramView;
    }
  }
  
  public void onClick(View paramView)
  {
    int i = 0;
    ImageView localImageView = (ImageView)paramView;
    int j = ((Integer)localImageView.getTag(2131362359)).intValue();
    NormalFacePackage localNormalFacePackage = (NormalFacePackage)this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiFaceFacePackage;
    Object localObject3 = Uri.parse(localNormalFacePackage.a(j));
    Object localObject1 = ((Uri)localObject3).getPath();
    String str = new File((String)localObject1).getName();
    try
    {
      localObject1 = Drawable.createFromPath((String)localObject1);
      if (localObject1 != null)
      {
        ((Drawable)localObject1).setBounds(0, 0, ((Drawable)localObject1).getIntrinsicWidth(), ((Drawable)localObject1).getIntrinsicHeight());
        try
        {
          j = ((RelativeLayout.LayoutParams)((ListView)paramView.getParent().getParent()).getLayoutParams()).leftMargin;
          i = j;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            float f2;
            float f3;
            float f4;
            float f5;
            int k;
            Object localObject2;
            SLog.c("NormalFaceAdapter", "get marginLeft error : %s", localException);
            continue;
            float f1 = (i - (k + (i - j) / 2) * 2) / i;
          }
        }
        localObject3 = (okj)paramView.getParent();
        j = (int)ViewCompat.b((View)localObject3);
        f2 = ViewCompat.a(paramView);
        f3 = paramView.getWidth() / 2;
        f4 = i;
        f5 = ((okj)localObject3).getHeight() / 2 + j;
        i = ((Drawable)localObject1).getIntrinsicWidth();
        j = localImageView.getWidth();
        k = localImageView.getPaddingLeft();
        if (j > i)
        {
          f1 = (((j - i) / 2 - k) * 2 + i) / i;
          paramView = new SelectedItem(localNormalFacePackage.b, str, (Drawable)localObject1);
          this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiFaceFacePanel$OnFaceSelectedListener.a(paramView, f4 + (f2 + f3), f5, f1 * 1.2F);
          return;
        }
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      for (;;)
      {
        SLog.c("NormalFaceAdapter", "createFromPath error", localOutOfMemoryError);
        localObject2 = null;
      }
      SLog.e("NormalFaceAdapter", "can create drawable from uri:" + localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.doodle.ui.face.adapter.NormalFaceAdapter
 * JD-Core Version:    0.7.0.1
 */