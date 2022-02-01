package com.tencent.aelight.camera.ae.play;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView.Adapter;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.ttpic.baseutils.bitmap.BitmapUtils;
import com.tencent.ttpic.videoshelf.model.edit.ShelfNode;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class VideoListAdapter
  extends RecyclerView.Adapter<VideoListAdapter.ViewHolder>
{
  private static final int MIN_CLICK_DELAY_TIME = 200;
  private static final String TAG = "VideoListAdapter";
  private static long lastClickTime;
  private Context context;
  private VideoListAdapter.OnVideoNodeClickedListener listener;
  private double mAspectRatio;
  private String mAssetsPath = "";
  private HashMap<Integer, Bitmap> mBitmaps;
  private boolean mIsHorizontal;
  private List<ShelfNode> mNodeGroupList;
  private ArrayList<String> mSelectedPhotoList;
  private int mSelectedPosition;
  private int mVideoHeight;
  private int mVideoWidth;
  
  public VideoListAdapter(Context paramContext, List<ShelfNode> paramList)
  {
    this.mSelectedPosition = 0;
    this.mBitmaps = new HashMap();
    this.mIsHorizontal = false;
    this.mAspectRatio = 0.0D;
    this.context = paramContext;
    this.mNodeGroupList = paramList;
  }
  
  public VideoListAdapter(Context paramContext, List<ShelfNode> paramList, int paramInt1, int paramInt2)
  {
    boolean bool = false;
    this.mSelectedPosition = 0;
    this.mBitmaps = new HashMap();
    this.mIsHorizontal = false;
    this.mAspectRatio = 0.0D;
    this.context = paramContext;
    this.mNodeGroupList = paramList;
    this.mVideoWidth = paramInt1;
    this.mVideoHeight = paramInt2;
    paramInt1 = this.mVideoHeight;
    if (paramInt1 != 0)
    {
      double d1 = this.mVideoWidth;
      double d2 = paramInt1;
      Double.isNaN(d1);
      Double.isNaN(d2);
      this.mAspectRatio = (d1 / d2);
      if (this.mAspectRatio >= 1.0D) {
        bool = true;
      }
      this.mIsHorizontal = bool;
    }
  }
  
  public static boolean isFastClick()
  {
    long l = System.currentTimeMillis();
    boolean bool;
    if (l - lastClickTime >= 200L) {
      bool = true;
    } else {
      bool = false;
    }
    lastClickTime = l;
    return bool;
  }
  
  public void clearBitmaps()
  {
    Iterator localIterator = this.mBitmaps.keySet().iterator();
    while (localIterator.hasNext())
    {
      int i = ((Integer)localIterator.next()).intValue();
      Bitmap localBitmap = (Bitmap)this.mBitmaps.get(Integer.valueOf(i));
      if ((localBitmap != null) && (!localBitmap.isRecycled())) {
        localBitmap.recycle();
      }
    }
  }
  
  public int getItemCount()
  {
    return this.mNodeGroupList.size();
  }
  
  @TargetApi(21)
  public void onBindViewHolder(@NonNull VideoListAdapter.ViewHolder paramViewHolder, int paramInt)
  {
    Object localObject = (ShelfNode)this.mNodeGroupList.get(paramInt);
    if (localObject == null)
    {
      Log.e(TAG, "onBindViewHolder contain null data item");
      return;
    }
    if (!this.mBitmaps.containsKey(Integer.valueOf(paramInt)))
    {
      Context localContext = this.context;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.mAssetsPath);
      localStringBuilder.append(File.separator);
      localStringBuilder.append(((ShelfNode)localObject).getCoverUri());
      localObject = BitmapUtils.decodeSampleBitmap(localContext, localStringBuilder.toString(), 1);
      this.mBitmaps.put(Integer.valueOf(paramInt), localObject);
    }
    paramViewHolder.thumb.setImageBitmap((Bitmap)this.mBitmaps.get(Integer.valueOf(paramInt)));
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("0");
    ((StringBuilder)localObject).append(paramInt + 1);
    localObject = ((StringBuilder)localObject).toString();
    paramViewHolder.index.setText((CharSequence)localObject);
    paramViewHolder.index_selected.setText((CharSequence)localObject);
    if (this.mSelectedPosition == paramInt)
    {
      paramViewHolder.hover.setVisibility(8);
      paramViewHolder.hover_selected.setVisibility(0);
      paramViewHolder.index.setVisibility(8);
      paramViewHolder.index_selected.setVisibility(0);
    }
    else
    {
      paramViewHolder.hover.setVisibility(0);
      paramViewHolder.hover_selected.setVisibility(8);
      paramViewHolder.index.setVisibility(0);
      paramViewHolder.index_selected.setVisibility(8);
    }
    paramViewHolder.itemView.setOnClickListener(new VideoListAdapter.1(this, paramInt));
  }
  
  public VideoListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup paramViewGroup, int paramInt)
  {
    return new VideoListAdapter.ViewHolder(this, LayoutInflater.from(this.context).inflate(2064056369, paramViewGroup, false));
  }
  
  public void setMaterialPath(String paramString)
  {
    this.mAssetsPath = paramString;
  }
  
  public void setOnVideoNodeClickedListener(VideoListAdapter.OnVideoNodeClickedListener paramOnVideoNodeClickedListener)
  {
    this.listener = paramOnVideoNodeClickedListener;
  }
  
  public void setThumbBackground(int paramInt, Bitmap paramBitmap)
  {
    if (!this.mBitmaps.containsKey(Integer.valueOf(paramInt)))
    {
      if (BitmapUtils.isLegal(paramBitmap)) {
        this.mBitmaps.put(Integer.valueOf(paramInt), paramBitmap);
      }
    }
    else
    {
      Bitmap localBitmap = (Bitmap)this.mBitmaps.get(Integer.valueOf(paramInt));
      if (BitmapUtils.isLegal(paramBitmap))
      {
        this.mBitmaps.put(Integer.valueOf(paramInt), paramBitmap);
        if ((BitmapUtils.isLegal(localBitmap)) && (localBitmap != paramBitmap)) {
          localBitmap.recycle();
        }
      }
    }
  }
  
  public void updateThumbBackground()
  {
    notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.play.VideoListAdapter
 * JD-Core Version:    0.7.0.1
 */