package com.tencent.aelight.camera.aioeditor;

import NS_QQ_STORY_META.META.StMusic;
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

public class SmartMusicAdapter
  extends RecyclerView.Adapter<SmartMusicAdapter.SmartMusicVH>
  implements Handler.Callback
{
  private EditVideoSmartMusicPart.onSmartMusicViewListener jdField_a_of_type_ComTencentAelightCameraAioeditorEditVideoSmartMusicPart$onSmartMusicViewListener;
  private SmartMusicRecyclerView jdField_a_of_type_ComTencentAelightCameraAioeditorSmartMusicRecyclerView;
  private CircleLayoutManager jdField_a_of_type_ComTencentBizVideostoryWidgetViewSmartmusicviewCircleLayoutManager;
  private WeakReferenceHandler jdField_a_of_type_ComTencentUtilWeakReferenceHandler;
  private HashMap<String, Integer> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private List<VsMusicItemInfo> jdField_a_of_type_JavaUtilList = new ArrayList();
  
  private int a(int paramInt)
  {
    if (a() == 0) {
      return 0;
    }
    return paramInt % a();
  }
  
  private void b(List<VsMusicItemInfo> paramList)
  {
    int i = 0;
    while (i < a())
    {
      this.jdField_a_of_type_JavaUtilHashMap.put(((VsMusicItemInfo)paramList.get(i)).mSongMid, Integer.valueOf(i));
      i += 1;
    }
  }
  
  public int a()
  {
    List localList = this.jdField_a_of_type_JavaUtilList;
    if (localList == null) {
      return 0;
    }
    return localList.size();
  }
  
  public int a(String paramString)
  {
    return ((Integer)this.jdField_a_of_type_JavaUtilHashMap.get(paramString)).intValue();
  }
  
  public SmartMusicAdapter.SmartMusicVH a(ViewGroup paramViewGroup, int paramInt)
  {
    return new SmartMusicAdapter.SmartMusicVH(this, LayoutInflater.from(paramViewGroup.getContext()).inflate(2064318697, null));
  }
  
  public VsMusicItemInfo a(int paramInt)
  {
    int i = paramInt;
    if (paramInt >= a()) {
      i = a(paramInt);
    }
    List localList = this.jdField_a_of_type_JavaUtilList;
    if ((localList != null) && (i >= 0) && (i < localList.size())) {
      return (VsMusicItemInfo)this.jdField_a_of_type_JavaUtilList.get(i);
    }
    return null;
  }
  
  public WeakReferenceHandler a()
  {
    if (this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler == null) {
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler = new WeakReferenceHandler(Looper.getMainLooper(), this);
    }
    return this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler;
  }
  
  public List<VsMusicItemInfo> a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public void a(EditVideoSmartMusicPart.onSmartMusicViewListener paramonSmartMusicViewListener)
  {
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorEditVideoSmartMusicPart$onSmartMusicViewListener = paramonSmartMusicViewListener;
  }
  
  public void a(SmartMusicAdapter.SmartMusicVH paramSmartMusicVH, int paramInt)
  {
    if (a() == 0) {
      return;
    }
    int i;
    if (paramInt < a()) {
      i = paramInt;
    } else {
      i = a(paramInt);
    }
    VsMusicItemInfo localVsMusicItemInfo = (VsMusicItemInfo)this.jdField_a_of_type_JavaUtilList.get(i);
    if (localVsMusicItemInfo != null)
    {
      if (localVsMusicItemInfo.isDownloading()) {
        paramSmartMusicVH.c();
      } else {
        paramSmartMusicVH.b(false);
      }
      UIUtils.a(SmartMusicAdapter.SmartMusicVH.a(paramSmartMusicVH), localVsMusicItemInfo.mAlbumUrl, UIUtils.a(paramSmartMusicVH.itemView.getContext(), 60.0F), UIUtils.a(paramSmartMusicVH.itemView.getContext(), 60.0F), UIUtils.a(paramSmartMusicVH.itemView.getContext(), 30.0F), paramSmartMusicVH.itemView.getContext().getResources().getDrawable(2130838766), null);
      paramSmartMusicVH.itemView.setOnClickListener(new SmartMusicAdapter.1(this, paramInt, localVsMusicItemInfo));
    }
  }
  
  public void a(ArrayList<VsMusicItemInfo> paramArrayList)
  {
    this.jdField_a_of_type_JavaUtilList = paramArrayList;
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < paramArrayList.size())
    {
      this.jdField_a_of_type_JavaUtilHashMap.put(((VsMusicItemInfo)paramArrayList.get(i)).mSongMid, Integer.valueOf(i));
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
  
  public void a(List<META.StMusic> paramList)
  {
    if (a() == 0) {
      localObject = new ArrayList();
    } else {
      localObject = this.jdField_a_of_type_JavaUtilList;
    }
    this.jdField_a_of_type_JavaUtilList = ((List)localObject);
    Object localObject = new ArrayList();
    int k = a();
    int i = 0;
    while (i < paramList.size())
    {
      int j;
      if (k == 0) {
        j = i;
      } else {
        j = a() + i;
      }
      this.jdField_a_of_type_JavaUtilHashMap.put(((META.StMusic)paramList.get(i)).strSongMid.get(), Integer.valueOf(j));
      this.jdField_a_of_type_JavaUtilList.add(new VsMusicItemInfo((META.StMusic)paramList.get(i)));
      ((ArrayList)localObject).add(((META.StMusic)paramList.get(i)).strSongMid.get());
      i += 1;
    }
    b((ArrayList)localObject);
    notifyDataSetChanged();
  }
  
  public boolean a(int paramInt, VsMusicItemInfo paramVsMusicItemInfo)
  {
    if (this.jdField_a_of_type_JavaUtilHashMap.get(paramVsMusicItemInfo.mSongMid) == null)
    {
      paramInt = a(paramInt);
      this.jdField_a_of_type_JavaUtilHashMap.put(paramVsMusicItemInfo.mSongMid, Integer.valueOf(paramInt));
      this.jdField_a_of_type_JavaUtilList.add(paramInt, paramVsMusicItemInfo);
      b(this.jdField_a_of_type_JavaUtilList);
      notifyDataSetChanged();
      return true;
    }
    return false;
  }
  
  public void b(ArrayList<String> paramArrayList)
  {
    a(paramArrayList, false);
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
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorSmartMusicRecyclerView = ((SmartMusicRecyclerView)paramRecyclerView);
    this.jdField_a_of_type_ComTencentBizVideostoryWidgetViewSmartmusicviewCircleLayoutManager = this.jdField_a_of_type_ComTencentAelightCameraAioeditorSmartMusicRecyclerView.a();
  }
  
  public void onDetachedFromRecyclerView(RecyclerView paramRecyclerView)
  {
    super.onDetachedFromRecyclerView(paramRecyclerView);
    a().removeCallbacks(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.SmartMusicAdapter
 * JD-Core Version:    0.7.0.1
 */