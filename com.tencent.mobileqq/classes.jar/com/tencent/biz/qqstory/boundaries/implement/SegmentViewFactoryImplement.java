package com.tencent.biz.qqstory.boundaries.implement;

import android.content.Context;
import android.util.SparseArray;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.segment.LocalVideoPushSegment;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.segment.MessageNotifySegment;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.segment.NullSegmentView;
import com.tencent.biz.qqstory.view.segment.SegmentView;
import com.tencent.mobileqq.app.HardCodeUtil;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class SegmentViewFactoryImplement
{
  public static SparseArray<Class<? extends SegmentView>> a = new SparseArray();
  public static SparseArray<Boolean> b = new SparseArray();
  
  static
  {
    SparseArray localSparseArray = a;
    Boolean localBoolean = Boolean.valueOf(true);
    localSparseArray.put(1, LocalVideoPushSegment.class);
    b.put(1, localBoolean);
    a.put(5, MessageNotifySegment.class);
    b.put(5, localBoolean);
  }
  
  public static SegmentView a(Context paramContext, int paramInt)
  {
    Object localObject = (Class)a.get(paramInt, null);
    Boolean localBoolean = (Boolean)b.get(paramInt, Boolean.valueOf(true));
    if (localObject != null)
    {
      if (localBoolean.booleanValue()) {
        try
        {
          paramContext = (SegmentView)((Class)localObject).getConstructor(new Class[] { Context.class }).newInstance(new Object[] { paramContext });
          return paramContext;
        }
        catch (InvocationTargetException paramContext)
        {
          throw new IllegalArgumentException(HardCodeUtil.a(2131713610), paramContext);
        }
        catch (InstantiationException paramContext)
        {
          throw new IllegalStateException(HardCodeUtil.a(2131713614), paramContext);
        }
        catch (IllegalAccessException paramContext)
        {
          throw new IllegalStateException(HardCodeUtil.a(2131713611), paramContext);
        }
        catch (NoSuchMethodException paramContext)
        {
          throw new IllegalStateException(HardCodeUtil.a(2131713608), paramContext);
        }
      }
      try
      {
        localObject = (String)((Class)localObject).getDeclaredField("KEY").get(null);
        return new NullSegmentView(paramContext, (String)localObject);
      }
      catch (IllegalAccessException paramContext)
      {
        throw new IllegalStateException(HardCodeUtil.a(2131713609), paramContext);
      }
      catch (NoSuchFieldException paramContext)
      {
        throw new IllegalStateException(HardCodeUtil.a(2131713615), paramContext);
      }
    }
    throw new IllegalArgumentException(HardCodeUtil.a(2131713612));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.boundaries.implement.SegmentViewFactoryImplement
 * JD-Core Version:    0.7.0.1
 */