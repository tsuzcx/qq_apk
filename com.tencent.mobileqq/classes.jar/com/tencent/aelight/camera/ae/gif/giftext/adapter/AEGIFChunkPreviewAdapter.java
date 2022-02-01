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
  private Context a;
  private AEGIFTextEditViewModel b;
  private LifecycleOwner c;
  private List<AEGIFPreviewWrapper> d;
  private String e;
  private AEGIFChunkPreviewAdapter.OnTextClickListener f;
  private Set<Integer> g;
  private View h;
  private int i;
  private HashMap<String, SoftReference<AEAnimationDrawable>> j = new HashMap();
  
  public AEGIFChunkPreviewAdapter(Context paramContext, List<AEGIFPreviewWrapper> paramList, String paramString)
  {
    this.a = paramContext;
    this.d = paramList;
    this.e = paramString;
    this.g = new HashSet();
    this.i = ((int)(LightDeviceUtils.getScreenWidth(paramContext) * 0.44F) + 1);
    paramContext = this.d;
    if ((paramContext != null) && (paramContext.size() != 0))
    {
      ((AEGIFPreviewWrapper)this.d.get(0)).a(true);
      this.g.add(Integer.valueOf(0));
    }
  }
  
  private void a(ImageView paramImageView, String paramString, int paramInt)
  {
    Object localObject1 = (SoftReference)this.j.get(paramString);
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
            int k = 0;
            while (k < localObject2.length)
            {
              Object localObject3 = new StringBuilder();
              ((StringBuilder)localObject3).append(paramString);
              ((StringBuilder)localObject3).append("/frame_%03d.png");
              localObject3 = String.format(((StringBuilder)localObject3).toString(), new Object[] { Integer.valueOf(k) });
              if (new File((String)localObject3).exists()) {
                ((ArrayList)localObject1).add(localObject3);
              }
              k += 1;
            }
          }
        }
      }
      localObject2 = new AEAnimationDrawable(this.a, (ArrayList)localObject1, 55L);
      ((AEAnimationDrawable)localObject2).a(false);
      this.j.put(paramString, new SoftReference(localObject2));
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
    AEGIFTextEditViewModel localAEGIFTextEditViewModel = this.b;
    if (localAEGIFTextEditViewModel != null)
    {
      localAEGIFTextEditViewModel.a().observe(this.c, new AEGIFChunkPreviewAdapter.2(this, paramAEGIFOutlineTextView));
      this.b.b().observe(this.c, new AEGIFChunkPreviewAdapter.3(this, paramAEGIFOutlineTextView));
    }
    paramAEGIFOutlineTextView.setOnClickListener(new AEGIFChunkPreviewAdapter.4(this));
    paramAEGIFOutlineTextView.setVisibility(0);
  }
  
  private void a(boolean paramBoolean)
  {
    View localView = this.h;
    if (localView != null)
    {
      localView.setEnabled(paramBoolean);
      if (paramBoolean)
      {
        ((TextView)this.h).setText(HardCodeUtil.a(2131898228));
        return;
      }
      ((TextView)this.h).setText(HardCodeUtil.a(2131898238));
    }
  }
  
  public AEGIFChunkPreviewAdapter.ViewHolder a(ViewGroup paramViewGroup, int paramInt)
  {
    return new AEGIFChunkPreviewAdapter.ViewHolder(this, LayoutInflater.from(paramViewGroup.getContext()).inflate(2064056476, paramViewGroup, false), this.e);
  }
  
  public Set<Integer> a()
  {
    return this.g;
  }
  
  public void a(View paramView)
  {
    this.h = paramView;
  }
  
  public void a(AEGIFChunkPreviewAdapter.OnTextClickListener paramOnTextClickListener)
  {
    this.f = paramOnTextClickListener;
  }
  
  public void a(AEGIFChunkPreviewAdapter.ViewHolder paramViewHolder)
  {
    super.onViewRecycled(paramViewHolder);
    if ((AEGIFChunkPreviewAdapter.ViewHolder.d(paramViewHolder) != null) && (AEGIFChunkPreviewAdapter.ViewHolder.d(paramViewHolder).getDrawable() != null) && ((AEGIFChunkPreviewAdapter.ViewHolder.d(paramViewHolder).getDrawable() instanceof AEAnimationDrawable)))
    {
      ((AEAnimationDrawable)AEGIFChunkPreviewAdapter.ViewHolder.d(paramViewHolder).getDrawable()).stop();
      AEGIFChunkPreviewAdapter.ViewHolder.d(paramViewHolder).setImageDrawable(null);
    }
  }
  
  public void a(AEGIFChunkPreviewAdapter.ViewHolder paramViewHolder, int paramInt)
  {
    AEGIFPreviewWrapper localAEGIFPreviewWrapper = (AEGIFPreviewWrapper)this.d.get(paramInt);
    Object localObject = this.a.getResources().getDrawable(2063925583);
    localObject = VasApngUtil.getApngURLDrawable("https://qd.myapp.com/myapp/qqteam/QIM/ae_gif_loading.png", new int[] { 0 }, (Drawable)localObject);
    AEGIFChunkPreviewAdapter.ViewHolder.a(paramViewHolder).setImageDrawable((Drawable)localObject);
    AEGIFChunkPreviewAdapter.ViewHolder.b(paramViewHolder).setVisibility(4);
    paramViewHolder.a(localAEGIFPreviewWrapper.a());
    switch (localAEGIFPreviewWrapper.a)
    {
    default: 
      break;
    case 13: 
      AEGIFChunkPreviewAdapter.ViewHolder.a(paramViewHolder).setVisibility(8);
      if (paramInt == 0)
      {
        a(AEGIFChunkPreviewAdapter.ViewHolder.b(paramViewHolder));
        AEGIFChunkPreviewAdapter.ViewHolder.b(paramViewHolder).setVisibility(0);
      }
      AEGIFChunkPreviewAdapter.ViewHolder.c(paramViewHolder).setVisibility(0);
      if (this.g.contains(Integer.valueOf(paramInt)))
      {
        paramViewHolder.a(true);
        a(true);
      }
      else
      {
        paramViewHolder.a(false);
      }
      localObject = localAEGIFPreviewWrapper.f;
      a(AEGIFChunkPreviewAdapter.ViewHolder.d(paramViewHolder), (String)localObject, paramInt);
      break;
    case 10: 
    case 11: 
    case 12: 
      AEGIFChunkPreviewAdapter.ViewHolder.c(paramViewHolder).setVisibility(4);
      AEGIFChunkPreviewAdapter.ViewHolder.a(paramViewHolder).setVisibility(0);
    }
    localObject = paramViewHolder.itemView.getLayoutParams();
    ((ViewGroup.LayoutParams)localObject).width = -1;
    ((ViewGroup.LayoutParams)localObject).height = this.i;
    paramViewHolder.itemView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    paramViewHolder.itemView.setOnClickListener(new AEGIFChunkPreviewAdapter.1(this, localAEGIFPreviewWrapper, paramInt, paramViewHolder));
  }
  
  public void a(AEGIFTextEditViewModel paramAEGIFTextEditViewModel, LifecycleOwner paramLifecycleOwner)
  {
    this.b = paramAEGIFTextEditViewModel;
    this.c = paramLifecycleOwner;
  }
  
  public int getItemCount()
  {
    return this.d.size();
  }
  
  public void onAttachedToRecyclerView(RecyclerView paramRecyclerView)
  {
    super.onAttachedToRecyclerView(paramRecyclerView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.gif.giftext.adapter.AEGIFChunkPreviewAdapter
 * JD-Core Version:    0.7.0.1
 */