package com.tencent.biz.qqstory.view.asyncImageLoader;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.support.v4.util.LruCache;
import android.widget.ImageView;
import com.tencent.biz.qqstory.storyHome.qqstorylist.common.InfoPrinter;
import com.tencent.biz.qqstory.storyHome.qqstorylist.common.TaskQueue;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.WeakHashMap;

public abstract class ImageLoader<T>
  implements Handler.Callback, Task.TaskStateListener
{
  private int jdField_a_of_type_Int = 1;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private HandlerThread jdField_a_of_type_AndroidOsHandlerThread;
  private TaskQueue jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistCommonTaskQueue;
  private WeakHashMap<ImageView, Drawable> jdField_a_of_type_JavaUtilWeakHashMap;
  private boolean jdField_a_of_type_Boolean = false;
  private Handler b;
  
  public ImageLoader()
  {
    this.jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.getSubThreadLooper(), this);
    this.b = new Handler(Looper.getMainLooper(), this);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistCommonTaskQueue = new TaskQueue();
    this.jdField_a_of_type_JavaUtilWeakHashMap = new WeakHashMap();
  }
  
  public ImageLoader(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ImageLoader_");
    localStringBuilder.append(paramString);
    this.jdField_a_of_type_AndroidOsHandlerThread = new HandlerThread(localStringBuilder.toString());
    this.b = new Handler(Looper.getMainLooper(), this);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistCommonTaskQueue = new TaskQueue();
    this.jdField_a_of_type_JavaUtilWeakHashMap = new WeakHashMap();
  }
  
  private void a(int paramInt, Task paramTask)
  {
    int i = this.jdField_a_of_type_Int;
    Handler localHandler;
    if (i == 0)
    {
      localHandler = this.jdField_a_of_type_AndroidOsHandler;
      localHandler.sendMessageAtFrontOfQueue(localHandler.obtainMessage(paramInt, paramTask));
      return;
    }
    if (i == 1)
    {
      localHandler = this.jdField_a_of_type_AndroidOsHandler;
      localHandler.sendMessage(localHandler.obtainMessage(paramInt, paramTask));
    }
  }
  
  public abstract LruCache<T, Drawable> a();
  
  public abstract Task a(ImageView paramImageView, T paramT);
  
  public void a()
  {
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    HandlerThread localHandlerThread = this.jdField_a_of_type_AndroidOsHandlerThread;
    if (localHandlerThread != null) {}
    try
    {
      localHandlerThread.quit();
      return;
    }
    catch (Exception localException) {}
  }
  
  public void a(ImageView paramImageView)
  {
    Task localTask = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistCommonTaskQueue.a(paramImageView);
    this.jdField_a_of_type_JavaUtilWeakHashMap.remove(paramImageView);
    if (localTask != null)
    {
      InfoPrinter.b("Q.qqstory.newImageLoader", new Object[] { "ImageView have been set,cancal task for this:", Integer.valueOf(paramImageView.hashCode()), " source:", localTask.jdField_a_of_type_JavaLangObject });
      localTask.b();
    }
  }
  
  public void a(ImageView paramImageView, T paramT)
  {
    a(paramImageView, paramT, new ColorDrawable(-3289651), 0);
  }
  
  public void a(ImageView paramImageView, T paramT, Drawable paramDrawable, int paramInt)
  {
    InfoPrinter.b("Q.qqstory.newImageLoader", new Object[] { "attachView:", paramT, " ----hash:", Integer.valueOf(paramImageView.hashCode()) });
    this.jdField_a_of_type_JavaUtilWeakHashMap.remove(paramImageView);
    if (paramT.toString().equals(paramImageView.getTag(2131369674)))
    {
      InfoPrinter.b("Q.qqstory.newImageLoader", new Object[] { "target have been set view,so dont need attach view" });
      return;
    }
    Object localObject1 = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistCommonTaskQueue.b(paramImageView);
    if (localObject1 != null)
    {
      if (paramT.equals(((Task)localObject1).jdField_a_of_type_JavaLangObject))
      {
        InfoPrinter.b("Q.qqstory.newImageLoader", new Object[] { "task running no need to do again:", ((Task)localObject1).jdField_a_of_type_JavaLangObject });
        return;
      }
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistCommonTaskQueue.a(paramImageView);
      InfoPrinter.b("Q.qqstory.newImageLoader", new Object[] { "cancel: ", ((Task)localObject1).jdField_a_of_type_JavaLangObject });
      ((Task)localObject1).b();
    }
    localObject1 = (Drawable)a().get(paramT);
    if (localObject1 != null)
    {
      InfoPrinter.b("Q.qqstory.newImageLoader", new Object[] { "hit the cache:", paramT });
      if ((localObject1 instanceof BitmapDrawable))
      {
        localObject2 = ((BitmapDrawable)localObject1).getBitmap();
        if (localObject2 != null) {
          InfoPrinter.b("Q.qqstory.newImageLoader", new Object[] { "cache size=", Integer.valueOf(((Bitmap)localObject2).getRowBytes() * ((Bitmap)localObject2).getHeight()), ",h=", Integer.valueOf(((Bitmap)localObject2).getHeight()), ",w=", Integer.valueOf(((Bitmap)localObject2).getWidth()), ",key=", paramT });
        }
      }
      else
      {
        InfoPrinter.b("Q.qqstory.newImageLoader", new Object[] { "cache size=", Integer.valueOf(1024), ",key= ", paramT });
      }
      if ((this.jdField_a_of_type_Boolean) && (paramInt == 0))
      {
        InfoPrinter.b("Q.qqstory.newImageLoader", new Object[] { "save to waiting queue:", paramT });
        paramImageView.setImageDrawable(paramDrawable);
        paramDrawable = paramImageView.getTag(2131369674);
        paramT = paramT.toString();
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(" view hash:");
        ((StringBuilder)localObject2).append(paramImageView.hashCode());
        InfoPrinter.b("Q.qqstory.newImageLoader", new Object[] { "postToUI def o= ", paramDrawable, " and change to: ", paramT, ((StringBuilder)localObject2).toString() });
        paramImageView.setTag(2131369674, null);
        this.jdField_a_of_type_JavaUtilWeakHashMap.put(paramImageView, localObject1);
        return;
      }
      paramImageView.setImageDrawable((Drawable)localObject1);
      paramDrawable = paramImageView.getTag(2131369674);
      localObject1 = paramT.toString();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(" view hash:");
      ((StringBuilder)localObject2).append(paramImageView.hashCode());
      InfoPrinter.b("Q.qqstory.newImageLoader", new Object[] { "postToUI cache o= ", paramDrawable, " and change to: ", localObject1, ((StringBuilder)localObject2).toString() });
      paramImageView.setTag(2131369674, paramT.toString());
      return;
    }
    paramImageView.setImageDrawable(paramDrawable);
    localObject1 = paramImageView.getTag(2131369674);
    Object localObject2 = paramT.toString();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(" view hash:");
    localStringBuilder.append(paramImageView.hashCode());
    InfoPrinter.b("Q.qqstory.newImageLoader", new Object[] { "postToUI def 2 o= ", localObject1, " and change to: ", localObject2, localStringBuilder.toString() });
    paramImageView.setTag(2131369674, null);
    localObject1 = a(paramImageView, paramT);
    if (localObject1 == null)
    {
      InfoPrinter.a("Q.qqstory.newImageLoader", new Object[] { "generateTask failed!!" });
      return;
    }
    ((Task)localObject1).jdField_a_of_type_ComTencentBizQqstoryViewAsyncImageLoaderImageLoader = this;
    ((Task)localObject1).b = paramDrawable;
    ((Task)localObject1).jdField_a_of_type_Int = paramInt;
    ((Task)localObject1).a(this);
    ((Task)localObject1).jdField_a_of_type_JavaLangObject = paramT;
    InfoPrinter.c("Q.qqstory.newImageLoader", new Object[] { "this need request hash:", Integer.valueOf(paramImageView.hashCode()) });
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistCommonTaskQueue.a(paramImageView, (Task)localObject1);
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistCommonTaskQueue.a((Task)localObject1);
    a(1, (Task)localObject1);
  }
  
  public void a(Task paramTask)
  {
    Handler localHandler = this.b;
    localHandler.sendMessage(localHandler.obtainMessage(3, paramTask));
  }
  
  public void a(Task paramTask, String paramString)
  {
    InfoPrinter.a("Q.qqstory.newImageLoader", new Object[] { "EXECUTE_TASK_ERROR:,case:", paramTask.a(), paramString });
    paramString = this.b;
    paramString.sendMessage(paramString.obtainMessage(2, paramTask));
  }
  
  public void b()
  {
    this.jdField_a_of_type_JavaUtilWeakHashMap.clear();
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistCommonTaskQueue.a();
  }
  
  public void c()
  {
    this.jdField_a_of_type_AndroidOsHandlerThread.start();
    this.jdField_a_of_type_AndroidOsHandler = new Handler(this.jdField_a_of_type_AndroidOsHandlerThread.getLooper(), this);
  }
  
  public void d()
  {
    this.jdField_a_of_type_Boolean = true;
    InfoPrinter.b("Q.qqstory.newImageLoader", new Object[] { "pause ui task" });
    this.b.removeMessages(4);
  }
  
  public void e()
  {
    this.jdField_a_of_type_Boolean = false;
    InfoPrinter.b("Q.qqstory.newImageLoader", new Object[] { "resume ui task" });
    this.b.removeMessages(4);
    Object localObject;
    if (this.jdField_a_of_type_JavaUtilWeakHashMap.size() > 0)
    {
      localObject = this.b;
      ((Handler)localObject).sendMessage(((Handler)localObject).obtainMessage(4));
    }
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistCommonTaskQueue.a() > 0)
    {
      localObject = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistCommonTaskQueue.a();
      int i = 2;
      while ((((ListIterator)localObject).hasPrevious()) && (i > 0))
      {
        Map.Entry localEntry = (Map.Entry)((ListIterator)localObject).previous();
        ((ListIterator)localObject).remove();
        if (((WeakReference)localEntry.getValue()).get() != null) {
          this.b.sendMessage(this.jdField_a_of_type_AndroidOsHandler.obtainMessage(1, localEntry.getKey()));
        } else {
          ((Task)localEntry.getKey()).b();
        }
        i -= 1;
      }
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int j = paramMessage.what;
    int i = 2;
    if (j != 1) {
      if (j != 2) {
        if (j != 3) {
          if (j != 4) {
            if (j == 5) {}
          }
        }
      }
    }
    for (;;)
    {
      return true;
      if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistCommonTaskQueue.a() > 0)
      {
        paramMessage = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistCommonTaskQueue.a();
        Object localObject1;
        while ((paramMessage.hasPrevious()) && (i > 0))
        {
          localObject1 = (Map.Entry)paramMessage.previous();
          paramMessage.remove();
          if (((WeakReference)((Map.Entry)localObject1).getValue()).get() != null) {
            this.b.sendMessage(this.jdField_a_of_type_AndroidOsHandler.obtainMessage(1, ((Map.Entry)localObject1).getKey()));
          } else {
            ((Task)((Map.Entry)localObject1).getKey()).b();
          }
          i -= 1;
        }
        continue;
        InfoPrinter.b("Q.qqstory.newImageLoader", new Object[] { "HANDLE_WAITING_UI_TASK" });
        if (this.jdField_a_of_type_Boolean) {
          return true;
        }
        paramMessage = this.jdField_a_of_type_JavaUtilWeakHashMap.entrySet().iterator();
        i = 3;
        Object localObject2;
        StringBuilder localStringBuilder;
        while (paramMessage.hasNext())
        {
          localObject2 = (Map.Entry)paramMessage.next();
          localObject1 = (ImageView)((Map.Entry)localObject2).getKey();
          if (localObject1 != null)
          {
            ((ImageView)localObject1).setImageDrawable((Drawable)((Map.Entry)localObject2).getValue());
            localObject2 = ((ImageView)localObject1).getTag(2131369674);
            localStringBuilder = new StringBuilder();
            localStringBuilder.append(" view hash:");
            localStringBuilder.append(localObject1.hashCode());
            InfoPrinter.b("Q.qqstory.newImageLoader", new Object[] { "postToUI o= ", localObject2, " and change to: wait", localStringBuilder.toString() });
            ((ImageView)localObject1).setTag(2131369674, null);
            paramMessage.remove();
          }
          i -= 1;
          if (i <= 0) {
            break;
          }
        }
        if (this.jdField_a_of_type_JavaUtilWeakHashMap.size() > 0)
        {
          paramMessage = this.b;
          paramMessage.sendMessageDelayed(paramMessage.obtainMessage(4), 16L);
          continue;
          paramMessage = (Task)paramMessage.obj;
          InfoPrinter.a("Q.qqstory.newImageLoader", new Object[] { "EXECUTE_TASK_COMPLETED:", paramMessage.a() });
          if (!paramMessage.a())
          {
            InfoPrinter.a("Q.qqstory.newImageLoader", new Object[] { "EXECUTE_TASK_COMPLETED post ui:", paramMessage.a() });
            paramMessage.a(this.jdField_a_of_type_JavaUtilWeakHashMap, this.jdField_a_of_type_Boolean);
            localObject1 = (ImageView)paramMessage.jdField_a_of_type_JavaLangRefWeakReference.get();
            if (localObject1 != null)
            {
              InfoPrinter.a("Q.qqstory.newImageLoader", new Object[] { "completed the request,hash: ", Integer.valueOf(localObject1.hashCode()) });
              this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistCommonTaskQueue.a((ImageView)localObject1);
            }
            if (paramMessage.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null) {
              a().put(paramMessage.jdField_a_of_type_JavaLangObject, paramMessage.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
            }
          }
          else
          {
            InfoPrinter.c("Q.qqstory.newImageLoader", new Object[] { "EXECUTE_TASK_COMPLETED have been cancel:", paramMessage.a() });
          }
          paramMessage.c();
          if (!this.jdField_a_of_type_Boolean)
          {
            paramMessage = this.b;
            paramMessage.sendMessage(paramMessage.obtainMessage(5));
            continue;
            paramMessage = (Task)paramMessage.obj;
            InfoPrinter.a("Q.qqstory.newImageLoader", new Object[] { "EXECUTE_TASK_ERROR:", paramMessage.a() });
            localObject1 = (ImageView)paramMessage.jdField_a_of_type_JavaLangRefWeakReference.get();
            if (localObject1 != null)
            {
              this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistCommonTaskQueue.a((ImageView)localObject1);
              ((ImageView)localObject1).setImageDrawable(paramMessage.b);
              localObject2 = ((ImageView)localObject1).getTag(2131369674);
              localStringBuilder = new StringBuilder();
              localStringBuilder.append(" view hash:");
              localStringBuilder.append(localObject1.hashCode());
              InfoPrinter.b("Q.qqstory.newImageLoader", new Object[] { "postToUI o= ", localObject2, " and change to: default", localStringBuilder.toString() });
              ((ImageView)localObject1).setTag(2131369674, null);
            }
            paramMessage.c();
            continue;
            paramMessage = (Task)paramMessage.obj;
            if (paramMessage.a()) {
              break;
            }
            paramMessage.a();
          }
        }
      }
    }
    InfoPrinter.c("Q.qqstory.newImageLoader", new Object[] { HardCodeUtil.a(2131705818), paramMessage.a() });
    paramMessage.c();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.view.asyncImageLoader.ImageLoader
 * JD-Core Version:    0.7.0.1
 */