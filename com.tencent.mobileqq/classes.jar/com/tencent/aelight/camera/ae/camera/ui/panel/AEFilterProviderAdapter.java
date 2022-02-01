package com.tencent.aelight.camera.ae.camera.ui.panel;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView.Adapter;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.aelight.camera.ae.camera.core.AEFilterManagerHolder;
import com.tencent.aelight.camera.ae.camera.filter.AEFilterProcessTex;
import com.tencent.aelight.camera.aioeditor.activity.richmedia.VideoFilterTools;
import com.tencent.aelight.camera.aioeditor.capture.data.QIMFilterCategoryItem;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import java.util.ArrayList;
import java.util.List;

public class AEFilterProviderAdapter
  extends RecyclerView.Adapter<AEFilterProviderAdapter.ViewHolder>
{
  List<QIMFilterCategoryItem> a = new ArrayList();
  int b;
  private Context c;
  private AEFilterProviderAdapter.OnItemClickListener d;
  
  public AEFilterProviderAdapter(Context paramContext, int paramInt)
  {
    this.c = paramContext;
    this.b = paramInt;
  }
  
  private boolean a()
  {
    AEFilterProcessTex localAEFilterProcessTex = AEFilterManagerHolder.getAEFilterManager();
    if (localAEFilterProcessTex == null) {
      return true;
    }
    return localAEFilterProcessTex.a;
  }
  
  public AEFilterProviderAdapter.ViewHolder a(ViewGroup paramViewGroup, int paramInt)
  {
    return new AEFilterProviderAdapter.ViewHolder(LayoutInflater.from(paramViewGroup.getContext()).inflate(2064056328, paramViewGroup, false));
  }
  
  public void a(AEFilterProviderAdapter.OnItemClickListener paramOnItemClickListener)
  {
    this.d = paramOnItemClickListener;
  }
  
  public void a(AEFilterProviderAdapter.ViewHolder paramViewHolder, int paramInt)
  {
    Object localObject1 = (QIMFilterCategoryItem)this.a.get(paramInt);
    if (localObject1 != null)
    {
      QIMFilterCategoryItem localQIMFilterCategoryItem = (QIMFilterCategoryItem)this.a.get(paramInt);
      Object localObject2 = VideoFilterTools.a().c(this.b);
      boolean bool1;
      if (localObject2 != null) {
        bool1 = TextUtils.equals(((QIMFilterCategoryItem)localObject2).a, localQIMFilterCategoryItem.a);
      } else {
        bool1 = false;
      }
      boolean bool2 = bool1;
      if (!bool1) {
        if (((localObject2 == null) || (((QIMFilterCategoryItem)localObject2).d())) && (localQIMFilterCategoryItem.d())) {
          bool2 = true;
        } else {
          bool2 = false;
        }
      }
      if ((bool2) && (a())) {
        AEFilterProviderAdapter.ViewHolder.a(paramViewHolder).setVisibility(0);
      } else {
        AEFilterProviderAdapter.ViewHolder.a(paramViewHolder).setVisibility(8);
      }
      localObject2 = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = this.c.getResources().getDrawable(2130845946);
      ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = this.c.getResources().getDrawable(2130845946);
      if (paramInt == 0) {
        localObject1 = "https://qd.myapp.com/myapp/qqteam/QIM/fliters-QIM/other/none2.png";
      } else {
        localObject1 = ((QIMFilterCategoryItem)localObject1).d;
      }
      localObject1 = URLDrawable.getDrawable((String)localObject1, (URLDrawable.URLDrawableOptions)localObject2);
      if (((URLDrawable)localObject1).getStatus() == 2) {
        ((URLDrawable)localObject1).restartDownload();
      }
      AEFilterProviderAdapter.ViewHolder.b(paramViewHolder).setImageDrawable((Drawable)localObject1);
      AEFilterProviderAdapter.ViewHolder.c(paramViewHolder).setText(localQIMFilterCategoryItem.b);
      if (this.d != null) {
        paramViewHolder.itemView.setOnClickListener(new AEFilterProviderAdapter.1(this, paramViewHolder));
      }
      paramViewHolder.itemView.setTag(localQIMFilterCategoryItem);
    }
  }
  
  public void a(List<QIMFilterCategoryItem> paramList)
  {
    this.a.clear();
    this.a.addAll(paramList);
  }
  
  public int getItemCount()
  {
    return this.a.size();
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.panel.AEFilterProviderAdapter
 * JD-Core Version:    0.7.0.1
 */