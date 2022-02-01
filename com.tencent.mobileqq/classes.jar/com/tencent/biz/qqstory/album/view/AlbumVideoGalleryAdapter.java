package com.tencent.biz.qqstory.album.view;

import android.app.Activity;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.tencent.biz.qqstory.album.StoryScanManager;
import com.tencent.biz.qqstory.album.model.StoryAlbum;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tribe.async.dispatch.IEventReceiver;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class AlbumVideoGalleryAdapter
  extends RecyclerView.Adapter<AlbumGalleryAdapterHolder>
  implements AlbumGalleryAdapterHolder.OnHolderItemClickListener, IEventReceiver
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private StoryScanManager jdField_a_of_type_ComTencentBizQqstoryAlbumStoryScanManager;
  private AlbumVideoGalleryAdapter.IOnAlbumGalleryAdapterCallback jdField_a_of_type_ComTencentBizQqstoryAlbumViewAlbumVideoGalleryAdapter$IOnAlbumGalleryAdapterCallback;
  private List<StoryAlbum> jdField_a_of_type_JavaUtilList;
  private boolean jdField_a_of_type_Boolean;
  private int b;
  private int c;
  private int d;
  private int e;
  
  private void a(List<StoryAlbum> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty())) {
      return;
    }
    StoryReportor.a("video_shoot_slides", "number_smartalbum", 0, 0, new String[] { "", paramList.size() + "" });
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      StoryAlbum localStoryAlbum = (StoryAlbum)paramList.next();
      if (localStoryAlbum.a() == 1) {
        localArrayList1.add(localStoryAlbum);
      } else {
        localArrayList2.add(localStoryAlbum);
      }
    }
    StoryReportor.a("video_shoot_slides", "read_smartalbum", 0, 0, new String[] { StoryScanManager.a(localArrayList1) + "", localArrayList1.size() + "" });
    StoryReportor.a("video_shoot_slides", "unread_smartalbum", 0, 0, new String[] { StoryScanManager.a(localArrayList2) + "", localArrayList2.size() + "" });
  }
  
  private boolean a()
  {
    if (this.jdField_a_of_type_JavaUtilList.size() > 0)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext()) {
        if (!((StoryAlbum)localIterator.next()).a()) {
          return true;
        }
      }
    }
    return false;
  }
  
  public int a()
  {
    return this.e;
  }
  
  public int a(StoryAlbum paramStoryAlbum)
  {
    return this.jdField_a_of_type_JavaUtilList.indexOf(paramStoryAlbum);
  }
  
  public StoryAlbum a()
  {
    if ((this.e >= 0) && (this.e < getItemCount())) {
      return (StoryAlbum)this.jdField_a_of_type_JavaUtilList.get(this.e);
    }
    return null;
  }
  
  public AlbumGalleryAdapterHolder a(ViewGroup paramViewGroup, int paramInt)
  {
    paramViewGroup = LayoutInflater.from(this.jdField_a_of_type_AndroidAppActivity).inflate(2131561766, paramViewGroup, false);
    return new AlbumGalleryAdapterHolder(this.jdField_a_of_type_AndroidAppActivity, paramViewGroup, this.jdField_a_of_type_Int, this.b, this);
  }
  
  public List<StoryAlbum> a()
  {
    return Collections.unmodifiableList(this.jdField_a_of_type_JavaUtilList);
  }
  
  public void a()
  {
    if (a()) {
      return;
    }
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaUtilList.add(StoryAlbum.a(1));
    this.jdField_a_of_type_JavaUtilList.add(StoryAlbum.a(2));
    notifyDataSetChanged();
    this.jdField_a_of_type_ComTencentBizQqstoryAlbumViewAlbumVideoGalleryAdapter$IOnAlbumGalleryAdapterCallback.b();
  }
  
  public void a(RecyclerView paramRecyclerView, int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < getItemCount()))
    {
      int i = this.e;
      this.e = paramInt;
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqstory.recommendAlbum.ui.AlbumVideoGalleryAdapter", 2, "setSelectPos " + paramInt + " oldPos:" + i);
      }
      b(paramRecyclerView, i);
      b(paramRecyclerView, paramInt);
      b(paramRecyclerView, paramInt - 1);
      b(paramRecyclerView, paramInt + 1);
    }
  }
  
  public void a(StoryAlbum paramStoryAlbum)
  {
    long l = SystemClock.uptimeMillis();
    if (l - this.jdField_a_of_type_Long > 500L) {
      if ((!paramStoryAlbum.b()) && (this.jdField_a_of_type_JavaUtilList.indexOf(paramStoryAlbum) >= 0) && (paramStoryAlbum == a()) && (this.jdField_a_of_type_ComTencentBizQqstoryAlbumViewAlbumVideoGalleryAdapter$IOnAlbumGalleryAdapterCallback != null)) {
        this.jdField_a_of_type_ComTencentBizQqstoryAlbumViewAlbumVideoGalleryAdapter$IOnAlbumGalleryAdapterCallback.a(paramStoryAlbum);
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Long = l;
      return;
      SLog.d("Q.qqstory.recommendAlbum.ui.AlbumVideoGalleryAdapter", "you click too fast, wait...");
    }
  }
  
  public void a(AlbumGalleryAdapterHolder paramAlbumGalleryAdapterHolder, int paramInt)
  {
    if (paramInt >= this.jdField_a_of_type_JavaUtilList.size()) {}
    for (;;)
    {
      EventCollector.getInstance().onRecyclerBindViewHolder(paramAlbumGalleryAdapterHolder, paramInt, getItemId(paramInt));
      return;
      paramAlbumGalleryAdapterHolder.a((StoryAlbum)this.jdField_a_of_type_JavaUtilList.get(paramInt));
      if (((this.e == -1) && (paramInt != 0)) || (this.e != paramInt)) {
        AlbumGalleryCapturePart.a(paramAlbumGalleryAdapterHolder, this.c, this.jdField_a_of_type_Int, this.d, this.b, 0.0F, paramInt);
      }
    }
  }
  
  public boolean a(@NonNull List<StoryAlbum> paramList)
  {
    if (this.jdField_a_of_type_JavaUtilList.size() > 0)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext()) {
        if (!((StoryAlbum)localIterator.next()).a()) {
          return false;
        }
      }
    }
    if (paramList.size() > 0)
    {
      this.jdField_a_of_type_JavaUtilList = new ArrayList();
      this.jdField_a_of_type_JavaUtilList.add(StoryAlbum.a(1));
      this.jdField_a_of_type_JavaUtilList.addAll(paramList);
      notifyDataSetChanged();
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryAlbumViewAlbumVideoGalleryAdapter$IOnAlbumGalleryAdapterCallback.b();
      a(paramList);
      return true;
      this.jdField_a_of_type_JavaUtilList = new ArrayList();
      this.jdField_a_of_type_JavaUtilList.add(StoryAlbum.a(1));
      this.jdField_a_of_type_JavaUtilList.add(StoryAlbum.a(4));
      notifyDataSetChanged();
    }
  }
  
  public void b()
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaUtilList.add(StoryAlbum.a(1));
    this.jdField_a_of_type_JavaUtilList.add(StoryAlbum.a(3));
    notifyDataSetChanged();
    this.jdField_a_of_type_ComTencentBizQqstoryAlbumViewAlbumVideoGalleryAdapter$IOnAlbumGalleryAdapterCallback.b();
  }
  
  public void b(RecyclerView paramRecyclerView, int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < getItemCount()))
    {
      paramRecyclerView = (AlbumGalleryAdapterHolder)paramRecyclerView.findViewHolderForAdapterPosition(paramInt);
      if (paramRecyclerView != null) {
        paramRecyclerView.a();
      }
    }
  }
  
  public void b(StoryAlbum paramStoryAlbum)
  {
    int j = a(paramStoryAlbum);
    if (j >= 0)
    {
      this.jdField_a_of_type_JavaUtilList.remove(paramStoryAlbum);
      if (this.jdField_a_of_type_JavaUtilList.size() <= 0) {
        break label188;
      }
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
      } while (((StoryAlbum)localIterator.next()).a());
    }
    label188:
    for (int i = 0;; i = 1)
    {
      if (i != 0)
      {
        SLog.b("Q.qqstory.recommendAlbum.ui.AlbumVideoGalleryAdapter", "album delete all , show empty page");
        this.jdField_a_of_type_JavaUtilList = new ArrayList();
        this.jdField_a_of_type_JavaUtilList.add(StoryAlbum.a(1));
        this.jdField_a_of_type_JavaUtilList.add(StoryAlbum.a(4));
      }
      notifyItemRemoved(j);
      if (j < this.jdField_a_of_type_JavaUtilList.size()) {
        notifyItemRangeChanged(j, this.jdField_a_of_type_JavaUtilList.size() - j);
      }
      if (this.jdField_a_of_type_ComTencentBizQqstoryAlbumViewAlbumVideoGalleryAdapter$IOnAlbumGalleryAdapterCallback != null) {
        this.jdField_a_of_type_ComTencentBizQqstoryAlbumViewAlbumVideoGalleryAdapter$IOnAlbumGalleryAdapterCallback.a(paramStoryAlbum, j);
      }
      this.jdField_a_of_type_ComTencentBizQqstoryAlbumStoryScanManager.a(paramStoryAlbum.a());
      return;
    }
  }
  
  public void c()
  {
    if (a()) {
      return;
    }
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaUtilList.add(StoryAlbum.a(1));
    this.jdField_a_of_type_JavaUtilList.add(StoryAlbum.a(5));
    notifyDataSetChanged();
    this.jdField_a_of_type_ComTencentBizQqstoryAlbumViewAlbumVideoGalleryAdapter$IOnAlbumGalleryAdapterCallback.b();
  }
  
  public void c(StoryAlbum paramStoryAlbum)
  {
    b(paramStoryAlbum);
    StoryReportor.a("video_shoot_slides", "delete_smartalbum", 0, 0, new String[] { String.valueOf(paramStoryAlbum.d()), "2" });
  }
  
  public int getItemCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public boolean isValidate()
  {
    return this.jdField_a_of_type_Boolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.album.view.AlbumVideoGalleryAdapter
 * JD-Core Version:    0.7.0.1
 */