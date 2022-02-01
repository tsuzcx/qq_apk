package com.tencent.av.opengl.multiplevideos.renderbase;

import android.util.Log;
import android.util.Pair;
import com.tencent.aekit.openrender.internal.Frame;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;
import org.jetbrains.annotations.NotNull;

public abstract class Filter
  extends RenderObject
{
  private ImageSource.OnInitedCallback jdField_a_of_type_ComTencentAvOpenglMultiplevideosRenderbaseImageSource$OnInitedCallback;
  private String jdField_a_of_type_JavaLangString = getClass().getSimpleName() + "-" + Integer.toHexString(hashCode());
  private List<Pair<Filter, Integer>> jdField_a_of_type_JavaUtilList = new LinkedList();
  private Vector<RefFrame> jdField_a_of_type_JavaUtilVector;
  private boolean jdField_a_of_type_Boolean = false;
  
  public Filter(int paramInt)
  {
    this.jdField_a_of_type_JavaUtilVector = new Vector(paramInt);
    this.jdField_a_of_type_JavaUtilVector.setSize(paramInt);
  }
  
  private void a(RefFrame paramRefFrame, int paramInt, long paramLong)
  {
    if (a(paramRefFrame, paramInt))
    {
      a(this.jdField_a_of_type_JavaUtilVector, paramLong);
      this.jdField_a_of_type_JavaUtilVector.clear();
      this.jdField_a_of_type_JavaUtilVector.setSize(this.jdField_a_of_type_JavaUtilVector.capacity());
    }
  }
  
  private boolean a(RefFrame paramRefFrame, int paramInt)
  {
    this.jdField_a_of_type_JavaUtilVector.set(paramInt, paramRefFrame);
    paramInt = 0;
    while (paramInt < this.jdField_a_of_type_JavaUtilVector.size())
    {
      if (this.jdField_a_of_type_JavaUtilVector.get(paramInt) == null) {
        return false;
      }
      paramInt += 1;
    }
    return true;
  }
  
  @NotNull
  protected abstract Frame a(List<RefFrame> paramList, long paramLong);
  
  public Filter a()
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaUtilVector.clear();
    this.jdField_a_of_type_JavaUtilVector.setSize(this.jdField_a_of_type_JavaUtilVector.capacity());
    return this;
  }
  
  public Filter a(Filter paramFilter, int paramInt)
  {
    Log.d(this.jdField_a_of_type_JavaLangString, "addTarget: " + paramFilter);
    if (paramInt >= paramFilter.jdField_a_of_type_JavaUtilVector.size())
    {
      Log.e(this.jdField_a_of_type_JavaLangString, "addTarget: targetIndex=" + paramInt + ", target inputCount=" + this.jdField_a_of_type_JavaUtilVector.size() + ", out of bounds");
      return this;
    }
    this.jdField_a_of_type_JavaUtilList.add(new Pair(paramFilter, Integer.valueOf(paramInt)));
    paramFilter.a(this.jdField_a_of_type_ComTencentAvOpenglMultiplevideosRenderbaseRenderContext);
    return this;
  }
  
  protected abstract void a();
  
  public void a(RenderContext paramRenderContext)
  {
    super.a(paramRenderContext);
    if (!this.jdField_a_of_type_Boolean)
    {
      Log.d(this.jdField_a_of_type_JavaLangString, "init: ");
      a();
      if (this.jdField_a_of_type_ComTencentAvOpenglMultiplevideosRenderbaseImageSource$OnInitedCallback != null)
      {
        this.jdField_a_of_type_ComTencentAvOpenglMultiplevideosRenderbaseImageSource$OnInitedCallback.a();
        this.jdField_a_of_type_ComTencentAvOpenglMultiplevideosRenderbaseImageSource$OnInitedCallback = null;
      }
      this.jdField_a_of_type_Boolean = true;
    }
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilList.size())
    {
      ((Filter)((Pair)this.jdField_a_of_type_JavaUtilList.get(i)).first).a(this.jdField_a_of_type_ComTencentAvOpenglMultiplevideosRenderbaseRenderContext);
      i += 1;
    }
  }
  
  public void a(List<RefFrame> paramList, long paramLong)
  {
    int j = 0;
    Object localObject = a(paramList, paramLong);
    RefFrame localRefFrame = null;
    int i = 0;
    if (i < paramList.size())
    {
      if (((RefFrame)paramList.get(i)).jdField_a_of_type_ComTencentAekitOpenrenderInternalFrame == localObject) {
        localRefFrame = (RefFrame)paramList.get(i);
      }
      for (;;)
      {
        i += 1;
        break;
        ((RefFrame)paramList.get(i)).a();
      }
    }
    if (this.jdField_a_of_type_JavaUtilList.isEmpty()) {
      if (this.jdField_a_of_type_ComTencentAvOpenglMultiplevideosRenderbaseRenderContext.a.a != null) {
        this.jdField_a_of_type_ComTencentAvOpenglMultiplevideosRenderbaseRenderContext.a.a.a((Frame)localObject, this);
      }
    }
    for (;;)
    {
      return;
      if (localRefFrame != null)
      {
        localRefFrame.a();
        return;
        if (localRefFrame == null)
        {
          localRefFrame = RefFrame.a((Frame)localObject);
          localRefFrame.a(this.jdField_a_of_type_JavaUtilList.size());
        }
        for (;;)
        {
          localObject = new ArrayList();
          i = j;
          while (i < paramList.size())
          {
            if (((RefFrame)paramList.get(i)).jdField_a_of_type_JavaUtilList != null) {
              ((List)localObject).addAll(((RefFrame)paramList.get(i)).jdField_a_of_type_JavaUtilList);
            }
            i += 1;
          }
          localRefFrame.a(this.jdField_a_of_type_JavaUtilList.size());
          localRefFrame.a();
        }
        localRefFrame.jdField_a_of_type_JavaUtilList = ((List)localObject);
        paramList = this.jdField_a_of_type_JavaUtilList.iterator();
        while (paramList.hasNext())
        {
          localObject = (Pair)paramList.next();
          ((Filter)((Pair)localObject).first).a(localRefFrame, ((Integer)((Pair)localObject).second).intValue(), paramLong);
        }
      }
    }
  }
  
  protected abstract void b();
  
  public void c()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      Log.d(this.jdField_a_of_type_JavaLangString, "destroy: ");
      b();
      this.jdField_a_of_type_Boolean = false;
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((Filter)((Pair)localIterator.next()).first).c();
    }
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaUtilVector.clear();
    this.jdField_a_of_type_JavaUtilVector.setSize(this.jdField_a_of_type_JavaUtilVector.capacity());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.opengl.multiplevideos.renderbase.Filter
 * JD-Core Version:    0.7.0.1
 */