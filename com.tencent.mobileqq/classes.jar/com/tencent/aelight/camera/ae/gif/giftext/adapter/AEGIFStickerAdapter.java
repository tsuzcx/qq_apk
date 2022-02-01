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
  private int jdField_a_of_type_Int = 0;
  private Context jdField_a_of_type_AndroidContentContext;
  private RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  private AEGIFStickerAdapter.OnMaterialClickCallback jdField_a_of_type_ComTencentAelightCameraAeGifGiftextAdapterAEGIFStickerAdapter$OnMaterialClickCallback;
  private List<AEMaterialWrapper> jdField_a_of_type_JavaUtilList;
  private int b = 0;
  
  public AEGIFStickerAdapter(Context paramContext, List<AEMaterialWrapper> paramList)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaUtilList = paramList;
  }
  
  private void b(int paramInt)
  {
    Object localObject = this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
    if (localObject != null)
    {
      localObject = (LinearLayoutManager)((RecyclerView)localObject).getLayoutManager();
      int i = ((LinearLayoutManager)localObject).findFirstVisibleItemPosition();
      i += (((LinearLayoutManager)localObject).findLastVisibleItemPosition() - i + 1) / 2;
      if (paramInt > i)
      {
        localObject = this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
        ((RecyclerView)localObject).smoothScrollBy(DisplayUtil.b(((RecyclerView)localObject).getContext(), 70.0F), 0);
        return;
      }
      if (paramInt < i)
      {
        localObject = this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
        ((RecyclerView)localObject).smoothScrollBy(-DisplayUtil.b(((RecyclerView)localObject).getContext(), 70.0F), 0);
      }
    }
  }
  
  private void c(int paramInt)
  {
    Object localObject = this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
    if (localObject != null)
    {
      localObject = (LinearLayoutManager)((RecyclerView)localObject).getLayoutManager();
      int i = ((LinearLayoutManager)localObject).findFirstVisibleItemPosition();
      int j = (((LinearLayoutManager)localObject).findLastVisibleItemPosition() - i + 1) / 2 + i;
      if ((paramInt >= i) && (paramInt <= j))
      {
        if (paramInt > j)
        {
          localObject = this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
          ((RecyclerView)localObject).smoothScrollBy(DisplayUtil.b(((RecyclerView)localObject).getContext(), 70.0F), 0);
          return;
        }
        if (paramInt < j)
        {
          localObject = this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
          ((RecyclerView)localObject).smoothScrollBy(-DisplayUtil.b(((RecyclerView)localObject).getContext(), 70.0F), 0);
        }
      }
      else
      {
        this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.scrollToPosition(paramInt);
      }
    }
  }
  
  public AEGIFStickerAdapter.ViewHolder a(ViewGroup paramViewGroup, int paramInt)
  {
    if (this.jdField_a_of_type_AndroidContentContext == null) {
      this.jdField_a_of_type_AndroidContentContext = paramViewGroup.getContext();
    }
    return new AEGIFStickerAdapter.ViewHolder(LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2064318601, paramViewGroup, false));
  }
  
  public void a()
  {
    this.jdField_a_of_type_Int = 0;
    this.b = 0;
  }
  
  public void a(int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[onItemSelectedFromOutside], position=");
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append(", mClickedPos=");
    ((StringBuilder)localObject).append(this.jdField_a_of_type_Int);
    ((StringBuilder)localObject).append(", mActivatedPos=");
    ((StringBuilder)localObject).append(this.b);
    AEQLog.b("AEGIFStickerAdapter", ((StringBuilder)localObject).toString());
    localObject = (AEMaterialWrapper)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    this.jdField_a_of_type_Int = paramInt;
    if ((((AEMaterialWrapper)localObject).jdField_a_of_type_Int != 2) && (((AEMaterialWrapper)localObject).b != 1))
    {
      AEQLog.b("AEGIFStickerAdapter", "[onItemSelectedFromOutside] materialWrapper.state != STATE_DOWNLOADED");
      return;
    }
    AEQLog.b("AEGIFStickerAdapter", "[onItemSelectedFromOutside] materialWrapper.state == STATE_DOWNLOADED || materialWrapper.type == AEMaterialWrapper.TYPE_PLACEHOLDER");
    if (paramInt != this.b)
    {
      localObject = this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
      if (localObject != null) {
        ((RecyclerView)localObject).scrollToPosition(paramInt);
      }
      int i = this.b;
      this.b = paramInt;
      notifyItemChanged(paramInt);
      notifyItemChanged(i);
    }
  }
  
  public void a(@NonNull AEMaterialWrapper paramAEMaterialWrapper, boolean paramBoolean)
  {
    int i = this.jdField_a_of_type_JavaUtilList.indexOf(paramAEMaterialWrapper);
    if (paramBoolean)
    {
      this.jdField_a_of_type_Int = this.b;
      notifyItemChanged(i);
      return;
    }
    if (paramAEMaterialWrapper.jdField_a_of_type_Int == 2)
    {
      if (i == this.jdField_a_of_type_Int)
      {
        c(i);
        int j = this.b;
        this.b = i;
        notifyItemChanged(i);
        notifyItemChanged(j);
        AEBaseReportParam.a().r(paramAEMaterialWrapper.jdField_a_of_type_JavaLangString);
        AEBaseDataReporter.a().al();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("[notifyDownloadStateChanged], gifMaterialDownloaded, id=");
        localStringBuilder.append(paramAEMaterialWrapper.jdField_a_of_type_JavaLangString);
        AEQLog.b("AEGIFStickerAdapter", localStringBuilder.toString());
      }
    }
    else {
      notifyItemChanged(i);
    }
  }
  
  public void a(AEGIFStickerAdapter.OnMaterialClickCallback paramOnMaterialClickCallback)
  {
    this.jdField_a_of_type_ComTencentAelightCameraAeGifGiftextAdapterAEGIFStickerAdapter$OnMaterialClickCallback = paramOnMaterialClickCallback;
  }
  
  public void a(AEGIFStickerAdapter.ViewHolder paramViewHolder, int paramInt)
  {
    Object localObject1 = (AEMaterialWrapper)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    if (((AEMaterialWrapper)localObject1).b == 1)
    {
      paramViewHolder.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2064056589);
      paramViewHolder.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
    }
    else
    {
      Object localObject2 = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2064056613);
      localObject2 = VasApngUtil.getApngURLDrawable(((AEMaterialWrapper)localObject1).jdField_a_of_type_CameraXEFFECT_MATERIALS_GENERAL_DATASTRUCTMetaMaterial.thumbUrl, new int[] { 0 }, (Drawable)localObject2);
      paramViewHolder.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject2);
      int i = ((AEMaterialWrapper)localObject1).jdField_a_of_type_Int;
      if (i != 0) {
        if (i != 1)
        {
          if (i != 2) {
            break label133;
          }
        }
        else
        {
          paramViewHolder.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
          break label133;
        }
      }
      paramViewHolder.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
    }
    label133:
    paramViewHolder.itemView.setOnClickListener(new AEGIFStickerAdapter.1(this, paramInt, (AEMaterialWrapper)localObject1));
    if (paramInt == this.b)
    {
      AEBaseReportParam.a().r(((AEMaterialWrapper)localObject1).jdField_a_of_type_JavaLangString);
      localObject1 = paramViewHolder.jdField_a_of_type_AndroidWidgetFrameLayout.getLayoutParams();
      ((ViewGroup.LayoutParams)localObject1).width = DisplayUtil.b(this.jdField_a_of_type_AndroidContentContext, 75.0F);
      ((ViewGroup.LayoutParams)localObject1).height = DisplayUtil.b(this.jdField_a_of_type_AndroidContentContext, 75.0F);
      paramViewHolder.jdField_a_of_type_AndroidWidgetFrameLayout.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      paramViewHolder.jdField_a_of_type_AndroidWidgetFrameLayout.setBackgroundResource(2064056610);
      paramViewHolder.b.setVisibility(0);
      return;
    }
    localObject1 = paramViewHolder.jdField_a_of_type_AndroidWidgetFrameLayout.getLayoutParams();
    ((ViewGroup.LayoutParams)localObject1).width = DisplayUtil.b(this.jdField_a_of_type_AndroidContentContext, 60.0F);
    ((ViewGroup.LayoutParams)localObject1).height = DisplayUtil.b(this.jdField_a_of_type_AndroidContentContext, 60.0F);
    paramViewHolder.jdField_a_of_type_AndroidWidgetFrameLayout.setLayoutParams((ViewGroup.LayoutParams)localObject1);
    paramViewHolder.jdField_a_of_type_AndroidWidgetFrameLayout.setBackgroundResource(2064056609);
    paramViewHolder.b.setVisibility(4);
  }
  
  public int getItemCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public void onAttachedToRecyclerView(RecyclerView paramRecyclerView)
  {
    super.onAttachedToRecyclerView(paramRecyclerView);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = paramRecyclerView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.gif.giftext.adapter.AEGIFStickerAdapter
 * JD-Core Version:    0.7.0.1
 */