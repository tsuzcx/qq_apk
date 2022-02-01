package com.tencent.aelight.camera.aioeditor;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.request.BatchGetMusicInfoRequest;
import com.tencent.biz.videostory.widget.view.smartmusicview.CircleLayoutManager;
import com.tencent.biz.videostory.widget.view.smartmusicview.VsMusicItemInfo;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.util.WeakReferenceHandler;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import qqcircle.QQCircleSmartMatchMusic.LyricInfo;
import qqcircle.QQCircleSmartMatchMusic.MusicInfo;

public class SmartMusicAdapter
  extends RecyclerView.Adapter<SmartMusicAdapter.SmartMusicVH>
  implements Handler.Callback
{
  private List<VsMusicItemInfo> a = new ArrayList();
  private EditVideoSmartMusicPart.onSmartMusicViewListener b;
  private HashMap<String, Integer> c = new HashMap();
  private SmartMusicRecyclerView d;
  private CircleLayoutManager e;
  private WeakReferenceHandler f;
  
  private int b(int paramInt)
  {
    if (b() == 0) {
      return 0;
    }
    return paramInt % b();
  }
  
  private void b(List<VsMusicItemInfo> paramList)
  {
    int i = 0;
    while (i < b())
    {
      this.c.put(((VsMusicItemInfo)paramList.get(i)).mSongMid, Integer.valueOf(i));
      i += 1;
    }
  }
  
  public int a(String paramString)
  {
    return ((Integer)this.c.get(paramString)).intValue();
  }
  
  public SmartMusicAdapter.SmartMusicVH a(ViewGroup paramViewGroup, int paramInt)
  {
    return new SmartMusicAdapter.SmartMusicVH(this, LayoutInflater.from(paramViewGroup.getContext()).inflate(2064056514, null));
  }
  
  public VsMusicItemInfo a(int paramInt)
  {
    int i = paramInt;
    if (paramInt >= b()) {
      i = b(paramInt);
    }
    List localList = this.a;
    if ((localList != null) && (i >= 0) && (i < localList.size())) {
      return (VsMusicItemInfo)this.a.get(i);
    }
    return null;
  }
  
  public List<VsMusicItemInfo> a()
  {
    return this.a;
  }
  
  public void a(EditVideoSmartMusicPart.onSmartMusicViewListener paramonSmartMusicViewListener)
  {
    this.b = paramonSmartMusicViewListener;
  }
  
  public void a(SmartMusicAdapter.SmartMusicVH paramSmartMusicVH, int paramInt)
  {
    if (b() == 0) {
      return;
    }
    int i;
    if (paramInt < b()) {
      i = paramInt;
    } else {
      i = b(paramInt);
    }
    VsMusicItemInfo localVsMusicItemInfo = (VsMusicItemInfo)this.a.get(i);
    if (localVsMusicItemInfo != null)
    {
      if (localVsMusicItemInfo.isDownloading()) {
        paramSmartMusicVH.c();
      } else {
        paramSmartMusicVH.b(false);
      }
      UIUtils.a(SmartMusicAdapter.SmartMusicVH.a(paramSmartMusicVH), localVsMusicItemInfo.mAlbumUrl, UIUtils.a(paramSmartMusicVH.itemView.getContext(), 60.0F), UIUtils.a(paramSmartMusicVH.itemView.getContext(), 60.0F), UIUtils.a(paramSmartMusicVH.itemView.getContext(), 30.0F), paramSmartMusicVH.itemView.getContext().getResources().getDrawable(2130838988), null);
      paramSmartMusicVH.itemView.setOnClickListener(new SmartMusicAdapter.1(this, paramInt, localVsMusicItemInfo));
    }
  }
  
  public void a(ArrayList<VsMusicItemInfo> paramArrayList)
  {
    this.a = paramArrayList;
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < paramArrayList.size())
    {
      this.c.put(((VsMusicItemInfo)paramArrayList.get(i)).mSongMid, Integer.valueOf(i));
      localArrayList.add(((VsMusicItemInfo)paramArrayList.get(i)).mSongMid);
      i += 1;
    }
    b(localArrayList);
    notifyDataSetChanged();
  }
  
  public void a(ArrayList<String> paramArrayList, boolean paramBoolean)
  {
    VSNetworkHelper.getInstance().sendRequest(new BatchGetMusicInfoRequest(paramArrayList), new SmartMusicAdapter.2(this, paramBoolean));
  }
  
  public void a(List<QQCircleSmartMatchMusic.MusicInfo> paramList)
  {
    if (b() == 0) {
      localObject = new ArrayList();
    } else {
      localObject = this.a;
    }
    this.a = ((List)localObject);
    Object localObject = new ArrayList();
    int k = b();
    int i = 0;
    while (i < paramList.size())
    {
      int j;
      if (k == 0) {
        j = i;
      } else {
        j = b() + i;
      }
      this.c.put(((QQCircleSmartMatchMusic.MusicInfo)paramList.get(i)).lyricInfo.strSongMid.get(), Integer.valueOf(j));
      this.a.add(new VsMusicItemInfo((QQCircleSmartMatchMusic.MusicInfo)paramList.get(i)));
      ((ArrayList)localObject).add(((QQCircleSmartMatchMusic.MusicInfo)paramList.get(i)).lyricInfo.strSongMid.get());
      i += 1;
    }
    b((ArrayList)localObject);
    notifyDataSetChanged();
  }
  
  public boolean a(int paramInt, VsMusicItemInfo paramVsMusicItemInfo)
  {
    if (this.c.get(paramVsMusicItemInfo.mSongMid) == null)
    {
      paramInt = b(paramInt);
      this.c.put(paramVsMusicItemInfo.mSongMid, Integer.valueOf(paramInt));
      this.a.add(paramInt, paramVsMusicItemInfo);
      b(this.a);
      notifyDataSetChanged();
      return true;
    }
    return false;
  }
  
  public int b()
  {
    List localList = this.a;
    if (localList == null) {
      return 0;
    }
    return localList.size();
  }
  
  public void b(ArrayList<String> paramArrayList)
  {
    a(paramArrayList, false);
  }
  
  public WeakReferenceHandler c()
  {
    if (this.f == null) {
      this.f = new WeakReferenceHandler(Looper.getMainLooper(), this);
    }
    return this.f;
  }
  
  public int getItemCount()
  {
    return 1000;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    return false;
  }
  
  public void onAttachedToRecyclerView(RecyclerView paramRecyclerView)
  {
    super.onAttachedToRecyclerView(paramRecyclerView);
    this.d = ((SmartMusicRecyclerView)paramRecyclerView);
    this.e = this.d.getCircleLayoutManager();
  }
  
  public void onDetachedFromRecyclerView(RecyclerView paramRecyclerView)
  {
    super.onDetachedFromRecyclerView(paramRecyclerView);
    c().removeCallbacks(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.SmartMusicAdapter
 * JD-Core Version:    0.7.0.1
 */