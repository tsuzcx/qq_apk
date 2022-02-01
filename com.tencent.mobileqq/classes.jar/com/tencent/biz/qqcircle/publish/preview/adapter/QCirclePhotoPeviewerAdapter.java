package com.tencent.biz.qqcircle.publish.preview.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import com.tencent.biz.qqcircle.widgets.multitouchimg.QCircleMultiTouchImageView;
import com.tencent.biz.richframework.part.block.base.QCirclePagerSnapHelper;
import com.tencent.mobileqq.qcircle.api.data.Option;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import java.util.ArrayList;

public class QCirclePhotoPeviewerAdapter
  extends RecyclerView.Adapter<QCirclePhotoPeviewerAdapter.PhotoViewHolder>
{
  private ArrayList<String> a;
  private QCirclePagerSnapHelper b;
  
  public QCirclePhotoPeviewerAdapter(ArrayList<String> paramArrayList, QCirclePagerSnapHelper paramQCirclePagerSnapHelper)
  {
    this.a = paramArrayList;
    this.b = paramQCirclePagerSnapHelper;
  }
  
  public QCirclePhotoPeviewerAdapter.PhotoViewHolder a(ViewGroup paramViewGroup, int paramInt)
  {
    return new QCirclePhotoPeviewerAdapter.PhotoViewHolder(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131626929, paramViewGroup, false));
  }
  
  public void a(QCirclePhotoPeviewerAdapter.PhotoViewHolder paramPhotoViewHolder, int paramInt)
  {
    paramPhotoViewHolder.b = paramInt;
    Option localOption = new Option();
    localOption.setUrl((String)this.a.get(paramInt)).setTargetView(paramPhotoViewHolder.a).setFromPreLoad(true).setPredecode(true).setRequestWidth(paramPhotoViewHolder.a.getLayoutParams().width).setRequestHeight(paramPhotoViewHolder.a.getLayoutParams().height);
    QCircleFeedPicLoader.g().loadImage(localOption, null);
  }
  
  public int getItemCount()
  {
    ArrayList localArrayList = this.a;
    if (localArrayList == null) {
      return 0;
    }
    return localArrayList.size();
  }
  
  public void onDetachedFromRecyclerView(RecyclerView paramRecyclerView)
  {
    super.onDetachedFromRecyclerView(paramRecyclerView);
    paramRecyclerView = this.b;
    if (paramRecyclerView != null) {
      paramRecyclerView.a(null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.publish.preview.adapter.QCirclePhotoPeviewerAdapter
 * JD-Core Version:    0.7.0.1
 */