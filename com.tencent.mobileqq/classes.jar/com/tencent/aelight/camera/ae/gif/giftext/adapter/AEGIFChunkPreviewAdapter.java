package com.tencent.aelight.camera.ae.gif.giftext.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import com.tencent.aelight.camera.ae.gif.giftext.AEGIFOutlineTextView;
import com.tencent.aelight.camera.ae.gif.giftext.AEGIFPreviewWrapper;
import com.tencent.aelight.camera.ae.gif.giftext.DrawableImageView;
import com.tencent.aelight.camera.ae.gif.giftext.view.AEAnimationDrawable;
import com.tencent.aelight.camera.ae.gif.giftext.viewmodel.AEGIFTextEditViewModel;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.vas.VasApngUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.light.device.LightDeviceUtils;

public class AEGIFChunkPreviewAdapter
  extends RecyclerView.Adapter<AEGIFChunkPreviewAdapter.ViewHolder>
{
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private View jdField_a_of_type_AndroidViewView;
  private LifecycleOwner jdField_a_of_type_AndroidxLifecycleLifecycleOwner;
  private AEGIFChunkPreviewAdapter.OnTextClickListener jdField_a_of_type_ComTencentAelightCameraAeGifGiftextAdapterAEGIFChunkPreviewAdapter$OnTextClickListener;
  private AEGIFTextEditViewModel jdField_a_of_type_ComTencentAelightCameraAeGifGiftextViewmodelAEGIFTextEditViewModel;
  private String jdField_a_of_type_JavaLangString;
  private HashMap<String, SoftReference<AEAnimationDrawable>> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private List<AEGIFPreviewWrapper> jdField_a_of_type_JavaUtilList;
  private Set<Integer> jdField_a_of_type_JavaUtilSet;
  
  public AEGIFChunkPreviewAdapter(Context paramContext, List<AEGIFPreviewWrapper> paramList, String paramString)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_JavaUtilSet = new HashSet();
    this.jdField_a_of_type_Int = ((int)(LightDeviceUtils.getScreenWidth(paramContext) * 0.44F) + 1);
    paramContext = this.jdField_a_of_type_JavaUtilList;
    if ((paramContext != null) && (paramContext.size() != 0))
    {
      ((AEGIFPreviewWrapper)this.jdField_a_of_type_JavaUtilList.get(0)).a(true);
      this.jdField_a_of_type_JavaUtilSet.add(Integer.valueOf(0));
    }
  }
  
  private void a(ImageView paramImageView, String paramString, int paramInt)
  {
    Object localObject1 = (SoftReference)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
    if (localObject1 != null) {
      localObject1 = (AEAnimationDrawable)((SoftReference)localObject1).get();
    } else {
      localObject1 = null;
    }
    Object localObject2 = localObject1;
    if (localObject1 == null)
    {
      localObject1 = new ArrayList();
      if (!TextUtils.isEmpty(paramString))
      {
        localObject2 = new File(paramString);
        if (((File)localObject2).exists())
        {
          localObject2 = ((File)localObject2).listFiles();
          if (localObject2.length > 0)
          {
            int i = 0;
            while (i < localObject2.length)
            {
              Object localObject3 = new StringBuilder();
              ((StringBuilder)localObject3).append(paramString);
              ((StringBuilder)localObject3).append("/frame_%03d.png");
              localObject3 = String.format(((StringBuilder)localObject3).toString(), new Object[] { Integer.valueOf(i) });
              if (new File((String)localObject3).exists()) {
                ((ArrayList)localObject1).add(localObject3);
              }
              i += 1;
            }
          }
        }
      }
      localObject2 = new AEAnimationDrawable(this.jdField_a_of_type_AndroidContentContext, (ArrayList)localObject1, 55L);
      ((AEAnimationDrawable)localObject2).a(false);
      this.jdField_a_of_type_JavaUtilHashMap.put(paramString, new SoftReference(localObject2));
    }
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder();
      paramString.append("playAnimationDrawable, position = ");
      paramString.append(paramInt);
      QLog.d("zswp20pro", 2, paramString.toString());
    }
    if ((paramImageView.getDrawable() != null) && (paramImageView.getDrawable() != localObject2) && ((paramImageView.getDrawable() instanceof AEAnimationDrawable)))
    {
      ((AEAnimationDrawable)paramImageView.getDrawable()).stop();
      paramImageView.setImageDrawable(null);
    }
    paramImageView.setImageDrawable((Drawable)localObject2);
    ((AEAnimationDrawable)localObject2).start();
  }
  
  private void a(AEGIFOutlineTextView paramAEGIFOutlineTextView)
  {
    AEGIFTextEditViewModel localAEGIFTextEditViewModel = this.jdField_a_of_type_ComTencentAelightCameraAeGifGiftextViewmodelAEGIFTextEditViewModel;
    if (localAEGIFTextEditViewModel != null)
    {
      localAEGIFTextEditViewModel.a().observe(this.jdField_a_of_type_AndroidxLifecycleLifecycleOwner, new AEGIFChunkPreviewAdapter.2(this, paramAEGIFOutlineTextView));
      this.jdField_a_of_type_ComTencentAelightCameraAeGifGiftextViewmodelAEGIFTextEditViewModel.b().observe(this.jdField_a_of_type_AndroidxLifecycleLifecycleOwner, new AEGIFChunkPreviewAdapter.3(this, paramAEGIFOutlineTextView));
    }
    paramAEGIFOutlineTextView.setOnClickListener(new AEGIFChunkPreviewAdapter.4(this));
    paramAEGIFOutlineTextView.setVisibility(0);
  }
  
  private void a(boolean paramBoolean)
  {
    View localView = this.jdField_a_of_type_AndroidViewView;
    if (localView != null)
    {
      localView.setEnabled(paramBoolean);
      if (paramBoolean)
      {
        ((TextView)this.jdField_a_of_type_AndroidViewView).setText(HardCodeUtil.a(2131700184));
        return;
      }
      ((TextView)this.jdField_a_of_type_AndroidViewView).setText(HardCodeUtil.a(2131700194));
    }
  }
  
  public AEGIFChunkPreviewAdapter.ViewHolder a(ViewGroup paramViewGroup, int paramInt)
  {
    return new AEGIFChunkPreviewAdapter.ViewHolder(this, LayoutInflater.from(paramViewGroup.getContext()).inflate(2064318598, paramViewGroup, false), this.jdField_a_of_type_JavaLangString);
  }
  
  public Set<Integer> a()
  {
    return this.jdField_a_of_type_JavaUtilSet;
  }
  
  public void a(View paramView)
  {
    this.jdField_a_of_type_AndroidViewView = paramView;
  }
  
  public void a(AEGIFChunkPreviewAdapter.OnTextClickListener paramOnTextClickListener)
  {
    this.jdField_a_of_type_ComTencentAelightCameraAeGifGiftextAdapterAEGIFChunkPreviewAdapter$OnTextClickListener = paramOnTextClickListener;
  }
  
  public void a(AEGIFChunkPreviewAdapter.ViewHolder paramViewHolder)
  {
    super.onViewRecycled(paramViewHolder);
    if ((AEGIFChunkPreviewAdapter.ViewHolder.a(paramViewHolder) != null) && (AEGIFChunkPreviewAdapter.ViewHolder.a(paramViewHolder).getDrawable() != null) && ((AEGIFChunkPreviewAdapter.ViewHolder.a(paramViewHolder).getDrawable() instanceof AEAnimationDrawable)))
    {
      ((AEAnimationDrawable)AEGIFChunkPreviewAdapter.ViewHolder.a(paramViewHolder).getDrawable()).stop();
      AEGIFChunkPreviewAdapter.ViewHolder.a(paramViewHolder).setImageDrawable(null);
    }
  }
  
  public void a(AEGIFChunkPreviewAdapter.ViewHolder paramViewHolder, int paramInt)
  {
    AEGIFPreviewWrapper localAEGIFPreviewWrapper = (AEGIFPreviewWrapper)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    Object localObject = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2064056613);
    localObject = VasApngUtil.getApngURLDrawable("https://qd.myapp.com/myapp/qqteam/QIM/ae_gif_loading.png", new int[] { 0 }, (Drawable)localObject);
    AEGIFChunkPreviewAdapter.ViewHolder.a(paramViewHolder).setImageDrawable((Drawable)localObject);
    AEGIFChunkPreviewAdapter.ViewHolder.a(paramViewHolder).setVisibility(4);
    paramViewHolder.a(localAEGIFPreviewWrapper.a());
    switch (localAEGIFPreviewWrapper.jdField_a_of_type_Int)
    {
    default: 
      break;
    case 13: 
      AEGIFChunkPreviewAdapter.ViewHolder.a(paramViewHolder).setVisibility(8);
      if (paramInt == 0)
      {
        a(AEGIFChunkPreviewAdapter.ViewHolder.a(paramViewHolder));
        AEGIFChunkPreviewAdapter.ViewHolder.a(paramViewHolder).setVisibility(0);
      }
      AEGIFChunkPreviewAdapter.ViewHolder.b(paramViewHolder).setVisibility(0);
      if (this.jdField_a_of_type_JavaUtilSet.contains(Integer.valueOf(paramInt)))
      {
        paramViewHolder.a(true);
        a(true);
      }
      else
      {
        paramViewHolder.a(false);
      }
      localObject = localAEGIFPreviewWrapper.c;
      a(AEGIFChunkPreviewAdapter.ViewHolder.a(paramViewHolder), (String)localObject, paramInt);
      break;
    case 10: 
    case 11: 
    case 12: 
      AEGIFChunkPreviewAdapter.ViewHolder.b(paramViewHolder).setVisibility(4);
      AEGIFChunkPreviewAdapter.ViewHolder.a(paramViewHolder).setVisibility(0);
    }
    localObject = paramViewHolder.itemView.getLayoutParams();
    ((ViewGroup.LayoutParams)localObject).width = -1;
    ((ViewGroup.LayoutParams)localObject).height = this.jdField_a_of_type_Int;
    paramViewHolder.itemView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    paramViewHolder.itemView.setOnClickListener(new AEGIFChunkPreviewAdapter.1(this, localAEGIFPreviewWrapper, paramInt, paramViewHolder));
  }
  
  public void a(AEGIFTextEditViewModel paramAEGIFTextEditViewModel, LifecycleOwner paramLifecycleOwner)
  {
    this.jdField_a_of_type_ComTencentAelightCameraAeGifGiftextViewmodelAEGIFTextEditViewModel = paramAEGIFTextEditViewModel;
    this.jdField_a_of_type_AndroidxLifecycleLifecycleOwner = paramLifecycleOwner;
  }
  
  public int getItemCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public void onAttachedToRecyclerView(RecyclerView paramRecyclerView)
  {
    super.onAttachedToRecyclerView(paramRecyclerView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.gif.giftext.adapter.AEGIFChunkPreviewAdapter
 * JD-Core Version:    0.7.0.1
 */