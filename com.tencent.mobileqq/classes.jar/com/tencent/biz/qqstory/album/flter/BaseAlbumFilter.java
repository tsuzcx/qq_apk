package com.tencent.biz.qqstory.album.flter;

import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.album.model.StoryAlbum;
import com.tencent.biz.qqstory.album.model.StoryAlbum.PicInfo;
import com.tencent.biz.qqstory.album.strategy.AbstractSplitStrategy;
import com.tencent.biz.qqstory.support.logging.SLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BaseAlbumFilter
  implements IAlbumFilter
{
  public int a;
  protected IAlbumFilter.IAlbumFilterListener a;
  protected String a;
  protected List<AbstractSplitStrategy> a;
  protected boolean a;
  private List<StoryAlbum.PicInfo> b;
  private List<StoryAlbum.PicInfo> c = new ArrayList();
  
  public BaseAlbumFilter(int paramInt)
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangString = "Q.qqstory.recommendAlbum.logic_BaseAlbumFilter";
  }
  
  private void a(List<StoryAlbum> paramList, String paramString) {}
  
  @NonNull
  protected List<StoryAlbum.PicInfo> a()
  {
    List localList = this.b;
    Object localObject = localList;
    if (localList == null) {
      localObject = new ArrayList();
    }
    return localObject;
  }
  
  public void a(IAlbumFilter.IAlbumFilterListener paramIAlbumFilterListener)
  {
    SLog.b(this.jdField_a_of_type_JavaLangString, "start");
    this.jdField_a_of_type_ComTencentBizQqstoryAlbumFlterIAlbumFilter$IAlbumFilterListener = paramIAlbumFilterListener;
    paramIAlbumFilterListener = a();
    if ((paramIAlbumFilterListener != null) && (!paramIAlbumFilterListener.isEmpty()))
    {
      if (this.jdField_a_of_type_JavaUtilList == null)
      {
        SLog.e(this.jdField_a_of_type_JavaLangString, "must set split strategy");
        b(null);
        return;
      }
      Object localObject1 = new StoryAlbum(this.jdField_a_of_type_Int, paramIAlbumFilterListener);
      paramIAlbumFilterListener = new LinkedList();
      paramIAlbumFilterListener.offer(localObject1);
      localObject1 = new LinkedList();
      ArrayList localArrayList = new ArrayList();
      int i = 0;
      while (i < this.jdField_a_of_type_JavaUtilList.size())
      {
        Object localObject2 = (AbstractSplitStrategy)this.jdField_a_of_type_JavaUtilList.get(i);
        while (paramIAlbumFilterListener.size() > 0)
        {
          Object localObject3 = (StoryAlbum)paramIAlbumFilterListener.poll();
          if (localObject3 != null)
          {
            SLog.b(this.jdField_a_of_type_JavaLangString, "to split StoryAlbum=%s", ((StoryAlbum)localObject3).toString());
            ((AbstractSplitStrategy)localObject2).a((StoryAlbum)localObject3);
            localObject3 = ((AbstractSplitStrategy)localObject2).b();
            Object localObject4;
            if ((localObject3 != null) && (((List)localObject3).size() != 0))
            {
              a((List)localObject3, localObject2.toString());
              SLog.b(this.jdField_a_of_type_JavaLangString, "split strategy=%s, result=%s", localObject2.toString(), localObject3.toString());
              localObject3 = ((List)localObject3).iterator();
              while (((Iterator)localObject3).hasNext())
              {
                localObject4 = (StoryAlbum)((Iterator)localObject3).next();
                if (i == this.jdField_a_of_type_JavaUtilList.size() - 1) {
                  localArrayList.add(localObject4);
                } else {
                  ((Queue)localObject1).add(localObject4);
                }
              }
            }
            else
            {
              localObject3 = this.jdField_a_of_type_JavaLangString;
              localObject4 = new StringBuilder();
              ((StringBuilder)localObject4).append("find no album strategy=");
              ((StringBuilder)localObject4).append(localObject2.toString());
              SLog.d((String)localObject3, ((StringBuilder)localObject4).toString());
            }
          }
        }
        if (((Queue)localObject1).size() <= 0) {
          break;
        }
        i += 1;
        localObject2 = localObject1;
        localObject1 = paramIAlbumFilterListener;
        paramIAlbumFilterListener = (IAlbumFilter.IAlbumFilterListener)localObject2;
      }
      b(localArrayList);
      return;
    }
    SLog.e(this.jdField_a_of_type_JavaLangString, "can't find enough pic");
    b(null);
  }
  
  public void a(AbstractSplitStrategy paramAbstractSplitStrategy)
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      this.jdField_a_of_type_JavaUtilList = new ArrayList();
    }
    this.jdField_a_of_type_JavaUtilList.add(paramAbstractSplitStrategy);
  }
  
  public void a(List<StoryAlbum.PicInfo> paramList)
  {
    this.b = new ArrayList();
    this.b.addAll(paramList);
  }
  
  protected void b(List<StoryAlbum> paramList)
  {
    this.c = new ArrayList();
    this.c.addAll(this.b);
    if ((paramList != null) && (paramList.size() > 0))
    {
      c(paramList);
      if (!this.jdField_a_of_type_Boolean)
      {
        localObject = paramList.iterator();
        while (((Iterator)localObject).hasNext())
        {
          Iterator localIterator = ((StoryAlbum)((Iterator)localObject).next()).a().iterator();
          while (localIterator.hasNext())
          {
            StoryAlbum.PicInfo localPicInfo = (StoryAlbum.PicInfo)localIterator.next();
            this.c.remove(localPicInfo);
          }
        }
      }
    }
    Object localObject = this.jdField_a_of_type_JavaLangString;
    int i;
    if (paramList == null) {
      i = 0;
    } else {
      i = paramList.size();
    }
    SLog.a((String)localObject, "handleResult, find album count=%d, leaving pic count=%d", Integer.valueOf(i), Integer.valueOf(this.c.size()));
    this.jdField_a_of_type_ComTencentBizQqstoryAlbumFlterIAlbumFilter$IAlbumFilterListener.a(paramList, this.c);
  }
  
  protected void c(List<StoryAlbum> paramList) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.album.flter.BaseAlbumFilter
 * JD-Core Version:    0.7.0.1
 */