package com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.face.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.aelight.camera.aioeditor.capture.data.IFaceSelectedListener;
import com.tencent.aelight.camera.aioeditor.capture.util.PasterUtil;
import com.tencent.aelight.camera.aioeditor.capture.util.PasterUtil.Position;
import com.tencent.aelight.camera.aioeditor.doodle.ui.face.LocationFacePackage;
import com.tencent.aelight.camera.aioeditor.doodle.ui.face.LocationFacePackage.Item;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.face.FaceListPage;
import com.tencent.biz.qqstory.support.logging.SLog;
import java.util.List;

public class LocationFaceAdapter
  extends BaseFaceListAdapter<LocationFacePackage>
  implements View.OnClickListener
{
  public LocationFaceAdapter(Context paramContext, FaceListPage paramFaceListPage)
  {
    super(paramContext, paramFaceListPage);
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (this.b == null) {
      return paramView;
    }
    if (paramView == null) {
      paramView = new LocationFaceAdapter.LocationItemLayout(this.a, paramViewGroup.getWidth(), ((LocationFacePackage)this.b).a(), ((LocationFacePackage)this.b).b(), this);
    } else {
      paramView = (LocationFaceAdapter.LocationItemLayout)paramView;
    }
    paramView.a((LocationFacePackage)this.b, paramInt, getCount(), a());
    return paramView;
  }
  
  public void onClick(View paramView)
  {
    Object localObject1 = (ImageView)paramView.findViewById(2131437692);
    int i = ((Integer)((ImageView)localObject1).getTag(2131446820)).intValue();
    paramView = (LocationFacePackage.Item)((LocationFacePackage)this.b).k.get(i);
    Object localObject2 = (Boolean)((ImageView)localObject1).getTag(2131446799);
    if ((localObject2 != null) && (((Boolean)localObject2).booleanValue()))
    {
      paramView.e = ((ImageView)localObject1).getDrawable();
      localObject2 = paramView.e;
      if (localObject2 != null)
      {
        ((Drawable)localObject2).setBounds(0, 0, ((Drawable)localObject2).getIntrinsicWidth(), ((Drawable)localObject2).getIntrinsicHeight());
        i = ((Drawable)localObject2).getIntrinsicWidth();
        int j = ((ImageView)localObject1).getWidth();
        int k = ((ImageView)localObject1).getPaddingLeft();
        if (j > i) {
          f = ((j - i) / 2 - k) * 2 + i;
        } else {
          f = i - ((i - j) / 2 + k) * 2;
        }
        double d1 = f / i;
        double d2 = ((LocationFacePackage)this.b).h;
        Double.isNaN(d1);
        float f = (float)(d1 * d2);
        localObject1 = PasterUtil.a();
        this.c.a(paramView, ((PasterUtil.Position)localObject1).a, ((PasterUtil.Position)localObject1).b, f);
      }
    }
    else
    {
      SLog.b("LocationFaceAdapter", "ImageView drawable has not been downloaded.");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.face.adapter.LocationFaceAdapter
 * JD-Core Version:    0.7.0.1
 */