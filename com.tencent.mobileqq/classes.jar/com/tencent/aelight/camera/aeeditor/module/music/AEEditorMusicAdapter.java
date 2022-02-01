package com.tencent.aelight.camera.aeeditor.module.music;

import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.tencent.aelight.camera.ae.util.AEThemeUtil;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.ttpic.baseutils.collection.CollectionUtils;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class AEEditorMusicAdapter
  extends RecyclerView.Adapter<AEEditorMusicAdapter.AEEditorMusicViewHolder>
{
  private Context a;
  private List<AEEditorMusicAdapter.AEEditorMusicInfo> b = new LinkedList();
  private AEEditorMusicAdapter.ClickCallback c;
  private final int d;
  private boolean e = false;
  private Set<AEEditorMusicAdapter.AEEditorMusicViewHolder> f = new HashSet();
  private int g;
  private int h;
  private int i;
  
  public AEEditorMusicAdapter(@NonNull Context paramContext, @Nullable AEEditorMusicAdapter.ClickCallback paramClickCallback)
  {
    this.a = paramContext;
    this.c = paramClickCallback;
    this.d = paramContext.getResources().getDimensionPixelSize(2063859798);
    this.e = AEThemeUtil.b();
    this.g = AIOUtils.b(6.0F, paramContext.getResources());
    this.h = AIOUtils.b(2.0F, paramContext.getResources());
    this.i = AIOUtils.b(16.0F, paramContext.getResources());
  }
  
  @NonNull
  public AEEditorMusicAdapter.AEEditorMusicViewHolder a(@NonNull ViewGroup paramViewGroup, int paramInt)
  {
    paramViewGroup = new AEEditorMusicAdapter.AEEditorMusicViewHolder(LayoutInflater.from(this.a).inflate(2064056444, paramViewGroup, false), this.c, this.d);
    AEEditorMusicAdapter.AEEditorMusicViewHolder.a(paramViewGroup, this.g, this.h, this.i);
    return paramViewGroup;
  }
  
  public List<AEEditorMusicAdapter.AEEditorMusicInfo> a()
  {
    return new LinkedList(this.b);
  }
  
  public void a(AEEditorMusicAdapter.AEEditorMusicViewHolder paramAEEditorMusicViewHolder)
  {
    super.onViewAttachedToWindow(paramAEEditorMusicViewHolder);
    this.f.add(paramAEEditorMusicViewHolder);
  }
  
  public void a(@NonNull AEEditorMusicAdapter.AEEditorMusicViewHolder paramAEEditorMusicViewHolder, int paramInt)
  {
    paramAEEditorMusicViewHolder.a((AEEditorMusicAdapter.AEEditorMusicInfo)this.b.get(paramInt), paramInt, this.b.size());
  }
  
  public void a(@NonNull List<AEEditorMusicAdapter.AEEditorMusicInfo> paramList)
  {
    this.b.clear();
    this.b.addAll(paramList);
    notifyDataSetChanged();
  }
  
  public void b()
  {
    if (CollectionUtils.isEmpty(this.f)) {
      return;
    }
    Iterator localIterator = this.f.iterator();
    while (localIterator.hasNext()) {
      ((AEEditorMusicAdapter.AEEditorMusicViewHolder)localIterator.next()).a();
    }
  }
  
  public void b(AEEditorMusicAdapter.AEEditorMusicViewHolder paramAEEditorMusicViewHolder)
  {
    super.onViewDetachedFromWindow(paramAEEditorMusicViewHolder);
    this.f.remove(paramAEEditorMusicViewHolder);
  }
  
  public void c()
  {
    Set localSet = this.f;
    if (localSet != null) {
      localSet.clear();
    }
  }
  
  public void d()
  {
    Object localObject = this.b;
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        AEEditorMusicAdapter.AEEditorMusicInfo localAEEditorMusicInfo = (AEEditorMusicAdapter.AEEditorMusicInfo)((Iterator)localObject).next();
        if (localAEEditorMusicInfo != null) {
          localAEEditorMusicInfo.c = false;
        }
      }
    }
  }
  
  public int getItemCount()
  {
    return this.b.size();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.module.music.AEEditorMusicAdapter
 * JD-Core Version:    0.7.0.1
 */