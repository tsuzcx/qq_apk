package com.tencent.biz.pubaccount.readinjoy.ugc.coverselect;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.biz.pubaccount.readinjoy.ugc.coverselect.capture.CaptureTask;
import com.tencent.widget.pull2refresh.BaseAdapter;
import java.util.List;

public class PreviewImageAdapter
  extends BaseAdapter<CaptureTask, PreviewImageAdapter.PreviewHolder>
{
  public PreviewImageAdapter(Context paramContext, List<CaptureTask> paramList)
  {
    super(paramContext, paramList);
  }
  
  public int a(int paramInt)
  {
    return 0;
  }
  
  public PreviewImageAdapter.PreviewHolder a(ViewGroup paramViewGroup, int paramInt)
  {
    ImageView localImageView = new ImageView(this.a);
    paramInt = paramViewGroup.getLayoutParams().height;
    localImageView.setLayoutParams(new ViewGroup.LayoutParams(paramInt, paramInt));
    localImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
    return new PreviewImageAdapter.PreviewHolder(this, localImageView);
  }
  
  public void a(PreviewImageAdapter.PreviewHolder paramPreviewHolder, int paramInt)
  {
    Bitmap localBitmap = ((CaptureTask)a(paramInt)).a();
    if (localBitmap != null) {
      ((ImageView)paramPreviewHolder.itemView).setImageBitmap(localBitmap);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ugc.coverselect.PreviewImageAdapter
 * JD-Core Version:    0.7.0.1
 */