package com.tencent.aelight.camera.ae.gif.giftext.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.aelight.camera.ae.data.AEMaterialWrapper;
import com.tencent.aelight.camera.ae.report.AEBaseDataReporter;
import com.tencent.aelight.camera.ae.report.AEBaseReportParam;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.util.DisplayUtil;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.mobileqq.vas.VasApngUtil;
import java.util.List;

public class AEGIFStickerAdapter
  extends RecyclerView.Adapter<AEGIFStickerAdapter.ViewHolder>
{
  private Context a;
  private List<AEMaterialWrapper> b;
  private int c = 0;
  private int d = 0;
  private AEGIFStickerAdapter.OnMaterialClickCallback e;
  private RecyclerView f;
  
  public AEGIFStickerAdapter(Context paramContext, List<AEMaterialWrapper> paramList)
  {
    this.a = paramContext;
    this.b = paramList;
  }
  
  private void b(int paramInt)
  {
    Object localObject = this.f;
    if (localObject != null)
    {
      localObject = (LinearLayoutManager)((RecyclerView)localObject).getLayoutManager();
      int i = ((LinearLayoutManager)localObject).findFirstVisibleItemPosition();
      i += (((LinearLayoutManager)localObject).findLastVisibleItemPosition() - i + 1) / 2;
      if (paramInt > i)
      {
        localObject = this.f;
        ((RecyclerView)localObject).smoothScrollBy(DisplayUtil.b(((RecyclerView)localObject).getContext(), 70.0F), 0);
        return;
      }
      if (paramInt < i)
      {
        localObject = this.f;
        ((RecyclerView)localObject).smoothScrollBy(-DisplayUtil.b(((RecyclerView)localObject).getContext(), 70.0F), 0);
      }
    }
  }
  
  private void c(int paramInt)
  {
    Object localObject = this.f;
    if (localObject != null)
    {
      localObject = (LinearLayoutManager)((RecyclerView)localObject).getLayoutManager();
      int i = ((LinearLayoutManager)localObject).findFirstVisibleItemPosition();
      int j = (((LinearLayoutManager)localObject).findLastVisibleItemPosition() - i + 1) / 2 + i;
      if ((paramInt >= i) && (paramInt <= j))
      {
        if (paramInt > j)
        {
          localObject = this.f;
          ((RecyclerView)localObject).smoothScrollBy(DisplayUtil.b(((RecyclerView)localObject).getContext(), 70.0F), 0);
          return;
        }
        if (paramInt < j)
        {
          localObject = this.f;
          ((RecyclerView)localObject).smoothScrollBy(-DisplayUtil.b(((RecyclerView)localObject).getContext(), 70.0F), 0);
        }
      }
      else
      {
        this.f.scrollToPosition(paramInt);
      }
    }
  }
  
  public AEGIFStickerAdapter.ViewHolder a(ViewGroup paramViewGroup, int paramInt)
  {
    if (this.a == null) {
      this.a = paramViewGroup.getContext();
    }
    return new AEGIFStickerAdapter.ViewHolder(LayoutInflater.from(this.a).inflate(2064056479, paramViewGroup, false));
  }
  
  public void a()
  {
    this.c = 0;
    this.d = 0;
  }
  
  public void a(int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[onItemSelectedFromOutside], position=");
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append(", mClickedPos=");
    ((StringBuilder)localObject).append(this.c);
    ((StringBuilder)localObject).append(", mActivatedPos=");
    ((StringBuilder)localObject).append(this.d);
    AEQLog.b("AEGIFStickerAdapter", ((StringBuilder)localObject).toString());
    localObject = (AEMaterialWrapper)this.b.get(paramInt);
    this.c = paramInt;
    if ((((AEMaterialWrapper)localObject).f != 2) && (((AEMaterialWrapper)localObject).g != 1))
    {
      AEQLog.b("AEGIFStickerAdapter", "[onItemSelectedFromOutside] materialWrapper.state != STATE_DOWNLOADED");
      return;
    }
    AEQLog.b("AEGIFStickerAdapter", "[onItemSelectedFromOutside] materialWrapper.state == STATE_DOWNLOADED || materialWrapper.type == AEMaterialWrapper.TYPE_PLACEHOLDER");
    if (paramInt != this.d)
    {
      localObject = this.f;
      if (localObject != null) {
        ((RecyclerView)localObject).scrollToPosition(paramInt);
      }
      int i = this.d;
      this.d = paramInt;
      notifyItemChanged(paramInt);
      notifyItemChanged(i);
    }
  }
  
  public void a(@NonNull AEMaterialWrapper paramAEMaterialWrapper, boolean paramBoolean)
  {
    int i = this.b.indexOf(paramAEMaterialWrapper);
    if (paramBoolean)
    {
      this.c = this.d;
      notifyItemChanged(i);
      return;
    }
    if (paramAEMaterialWrapper.f == 2)
    {
      if (i == this.c)
      {
        c(i);
        int j = this.d;
        this.d = i;
        notifyItemChanged(i);
        notifyItemChanged(j);
        AEBaseReportParam.a().C(paramAEMaterialWrapper.a);
        AEBaseDataReporter.a().aq();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("[notifyDownloadStateChanged], gifMaterialDownloaded, id=");
        localStringBuilder.append(paramAEMaterialWrapper.a);
        AEQLog.b("AEGIFStickerAdapter", localStringBuilder.toString());
      }
    }
    else {
      notifyItemChanged(i);
    }
  }
  
  public void a(AEGIFStickerAdapter.OnMaterialClickCallback paramOnMaterialClickCallback)
  {
    this.e = paramOnMaterialClickCallback;
  }
  
  public void a(AEGIFStickerAdapter.ViewHolder paramViewHolder, int paramInt)
  {
    Object localObject1 = (AEMaterialWrapper)this.b.get(paramInt);
    if (((AEMaterialWrapper)localObject1).g == 1)
    {
      paramViewHolder.a.setImageResource(2063925559);
      paramViewHolder.d.setVisibility(8);
    }
    else
    {
      Object localObject2 = this.a.getResources().getDrawable(2063925583);
      localObject2 = VasApngUtil.getApngURLDrawable(((AEMaterialWrapper)localObject1).b.thumbUrl, new int[] { 0 }, (Drawable)localObject2);
      paramViewHolder.a.setImageDrawable((Drawable)localObject2);
      int i = ((AEMaterialWrapper)localObject1).f;
      if (i != 0) {
        if (i != 1)
        {
          if (i != 2) {
            break label133;
          }
        }
        else
        {
          paramViewHolder.d.setVisibility(0);
          break label133;
        }
      }
      paramViewHolder.d.setVisibility(8);
    }
    label133:
    paramViewHolder.itemView.setOnClickListener(new AEGIFStickerAdapter.1(this, paramInt, (AEMaterialWrapper)localObject1));
    if (paramInt == this.d)
    {
      AEBaseReportParam.a().C(((AEMaterialWrapper)localObject1).a);
      localObject1 = paramViewHolder.c.getLayoutParams();
      ((ViewGroup.LayoutParams)localObject1).width = DisplayUtil.b(this.a, 75.0F);
      ((ViewGroup.LayoutParams)localObject1).height = DisplayUtil.b(this.a, 75.0F);
      paramViewHolder.c.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      paramViewHolder.c.setBackgroundResource(2063925580);
      paramViewHolder.b.setVisibility(0);
      return;
    }
    localObject1 = paramViewHolder.c.getLayoutParams();
    ((ViewGroup.LayoutParams)localObject1).width = DisplayUtil.b(this.a, 60.0F);
    ((ViewGroup.LayoutParams)localObject1).height = DisplayUtil.b(this.a, 60.0F);
    paramViewHolder.c.setLayoutParams((ViewGroup.LayoutParams)localObject1);
    paramViewHolder.c.setBackgroundResource(2063925579);
    paramViewHolder.b.setVisibility(4);
  }
  
  public int getItemCount()
  {
    return this.b.size();
  }
  
  public void onAttachedToRecyclerView(RecyclerView paramRecyclerView)
  {
    super.onAttachedToRecyclerView(paramRecyclerView);
    this.f = paramRecyclerView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.gif.giftext.adapter.AEGIFStickerAdapter
 * JD-Core Version:    0.7.0.1
 */