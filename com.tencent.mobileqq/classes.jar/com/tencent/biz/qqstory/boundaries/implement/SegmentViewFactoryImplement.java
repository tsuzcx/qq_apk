package com.tencent.biz.qqstory.boundaries.implement;

import android.content.Context;
import android.util.SparseArray;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.segment.LocalVideoPushSegment;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.segment.MessageNotifySegment;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.segment.NullSegmentView;
import com.tencent.biz.qqstory.view.segment.SegmentView;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class SegmentViewFactoryImplement
{
  public static SparseArray a = new SparseArray();
  public static SparseArray b = new SparseArray();
  
  static
  {
    a.put(1, LocalVideoPushSegment.class);
    b.put(1, Boolean.valueOf(true));
    a.put(5, MessageNotifySegment.class);
    b.put(5, Boolean.valueOf(true));
  }
  
  public static SegmentView a(Context paramContext, int paramInt)
  {
    Object localObject = (Class)a.get(paramInt, null);
    Boolean localBoolean = (Boolean)b.get(paramInt, Boolean.valueOf(true));
    if (localObject == null) {
      throw new IllegalArgumentException("找不到对应的 SegmentView 类型");
    }
    if (localBoolean.booleanValue()) {
      try
      {
        paramContext = (SegmentView)((Class)localObject).getConstructor(new Class[] { Context.class }).newInstance(new Object[] { paramContext });
        return paramContext;
      }
      catch (NoSuchMethodException paramContext)
      {
        throw new IllegalStateException("找不到对应类型 SegmentView 的构造函数", paramContext);
      }
      catch (IllegalAccessException paramContext)
      {
        throw new IllegalStateException("对应类型 SegmentView 的构造函数无法访问", paramContext);
      }
      catch (InstantiationException paramContext)
      {
        throw new IllegalStateException("对应类型 SegmentView 的构造函数执行异常", paramContext);
      }
      catch (InvocationTargetException paramContext)
      {
        throw new IllegalArgumentException("构造函数调用 InvocationTargetException", paramContext);
      }
    }
    try
    {
      localObject = (String)((Class)localObject).getDeclaredField("KEY").get(null);
      return new NullSegmentView(paramContext, (String)localObject);
    }
    catch (NoSuchFieldException paramContext)
    {
      throw new IllegalStateException("找不到对应类型 SegmentView 的相关字段", paramContext);
    }
    catch (IllegalAccessException paramContext)
    {
      throw new IllegalStateException("访问不到 SegmentView 的相关字段", paramContext);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.boundaries.implement.SegmentViewFactoryImplement
 * JD-Core Version:    0.7.0.1
 */