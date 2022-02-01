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
  private HandlerThread a;
  private Handler b;
  private Handler c;
  private int d = 1;
  private boolean e = false;
  private TaskQueue f;
  private WeakHashMap<ImageView, Drawable> g;
  
  public ImageLoader()
  {
    this.b = new Handler(ThreadManager.getSubThreadLooper(), this);
    this.c = new Handler(Looper.getMainLooper(), this);
    this.f = new TaskQueue();
    this.g = new WeakHashMap();
  }
  
  public ImageLoader(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ImageLoader_");
    localStringBuilder.append(paramString);
    this.a = new HandlerThread(localStringBuilder.toString());
    this.c = new Handler(Looper.getMainLooper(), this);
    this.f = new TaskQueue();
    this.g = new WeakHashMap();
  }
  
  private void a(int paramInt, Task paramTask)
  {
    int i = this.d;
    Handler localHandler;
    if (i == 0)
    {
      localHandler = this.b;
      localHandler.sendMessageAtFrontOfQueue(localHandler.obtainMessage(paramInt, paramTask));
      return;
    }
    if (i == 1)
    {
      localHandler = this.b;
      localHandler.sendMessage(localHandler.obtainMessage(paramInt, paramTask));
    }
  }
  
  public abstract LruCache<T, Drawable> a();
  
  public abstract Task a(ImageView paramImageView, T paramT);
  
  public void a(ImageView paramImageView)
  {
    Task localTask = this.f.a(paramImageView);
    this.g.remove(paramImageView);
    if (localTask != null)
    {
      InfoPrinter.b("Q.qqstory.newImageLoader", new Object[] { "ImageView have been set,cancal task for this:", Integer.valueOf(paramImageView.hashCode()), " source:", localTask.b });
      localTask.c();
    }
  }
  
  public void a(ImageView paramImageView, T paramT, Drawable paramDrawable, int paramInt)
  {
    InfoPrinter.b("Q.qqstory.newImageLoader", new Object[] { "attachView:", paramT, " ----hash:", Integer.valueOf(paramImageView.hashCode()) });
    this.g.remove(paramImageView);
    if (paramT.toString().equals(paramImageView.getTag(2131436784)))
    {
      InfoPrinter.b("Q.qqstory.newImageLoader", new Object[] { "target have been set view,so dont need attach view" });
      return;
    }
    Object localObject1 = this.f.b(paramImageView);
    if (localObject1 != null)
    {
      if (paramT.equals(((Task)localObject1).b))
      {
        InfoPrinter.b("Q.qqstory.newImageLoader", new Object[] { "task running no need to do again:", ((Task)localObject1).b });
        return;
      }
      this.f.a(paramImageView);
      InfoPrinter.b("Q.qqstory.newImageLoader", new Object[] { "cancel: ", ((Task)localObject1).b });
      ((Task)localObject1).c();
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
      if ((this.e) && (paramInt == 0))
      {
        InfoPrinter.b("Q.qqstory.newImageLoader", new Object[] { "save to waiting queue:", paramT });
        paramImageView.setImageDrawable(paramDrawable);
        paramDrawable = paramImageView.getTag(2131436784);
        paramT = paramT.toString();
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(" view hash:");
        ((StringBuilder)localObject2).append(paramImageView.hashCode());
        InfoPrinter.b("Q.qqstory.newImageLoader", new Object[] { "postToUI def o= ", paramDrawable, " and change to: ", paramT, ((StringBuilder)localObject2).toString() });
        paramImageView.setTag(2131436784, null);
        this.g.put(paramImageView, localObject1);
        return;
      }
      paramImageView.setImageDrawable((Drawable)localObject1);
      paramDrawable = paramImageView.getTag(2131436784);
      localObject1 = paramT.toString();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(" view hash:");
      ((StringBuilder)localObject2).append(paramImageView.hashCode());
      InfoPrinter.b("Q.qqstory.newImageLoader", new Object[] { "postToUI cache o= ", paramDrawable, " and change to: ", localObject1, ((StringBuilder)localObject2).toString() });
      paramImageView.setTag(2131436784, paramT.toString());
      return;
    }
    paramImageView.setImageDrawable(paramDrawable);
    localObject1 = paramImageView.getTag(2131436784);
    Object localObject2 = paramT.toString();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(" view hash:");
    localStringBuilder.append(paramImageView.hashCode());
    InfoPrinter.b("Q.qqstory.newImageLoader", new Object[] { "postToUI def 2 o= ", localObject1, " and change to: ", localObject2, localStringBuilder.toString() });
    paramImageView.setTag(2131436784, null);
    localObject1 = a(paramImageView, paramT);
    if (localObject1 == null)
    {
      InfoPrinter.a("Q.qqstory.newImageLoader", new Object[] { "generateTask failed!!" });
      return;
    }
    ((Task)localObject1).a = this;
    ((Task)localObject1).f = paramDrawable;
    ((Task)localObject1).c = paramInt;
    ((Task)localObject1).a(this);
    ((Task)localObject1).b = paramT;
    InfoPrinter.c("Q.qqstory.newImageLoader", new Object[] { "this need request hash:", Integer.valueOf(paramImageView.hashCode()) });
    this.f.a(paramImageView, (Task)localObject1);
    if (this.e) {
      return;
    }
    this.f.a((Task)localObject1);
    a(1, (Task)localObject1);
  }
  
  public void a(Task paramTask)
  {
    Handler localHandler = this.c;
    localHandler.sendMessage(localHandler.obtainMessage(3, paramTask));
  }
  
  public void a(Task paramTask, String paramString)
  {
    InfoPrinter.a("Q.qqstory.newImageLoader", new Object[] { "EXECUTE_TASK_ERROR:,case:", paramTask.b(), paramString });
    paramString = this.c;
    paramString.sendMessage(paramString.obtainMessage(2, paramTask));
  }
  
  public void b()
  {
    this.b.removeCallbacksAndMessages(null);
    HandlerThread localHandlerThread = this.a;
    if (localHandlerThread != null) {}
    try
    {
      localHandlerThread.quit();
      return;
    }
    catch (Exception localException) {}
  }
  
  public void b(ImageView paramImageView, T paramT)
  {
    a(paramImageView, paramT, new ColorDrawable(-3289651), 0);
  }
  
  public void c()
  {
    this.g.clear();
    this.f.a();
  }
  
  public void d()
  {
    this.a.start();
    this.b = new Handler(this.a.getLooper(), this);
  }
  
  public void e()
  {
    this.e = true;
    InfoPrinter.b("Q.qqstory.newImageLoader", new Object[] { "pause ui task" });
    this.c.removeMessages(4);
  }
  
  public void f()
  {
    this.e = false;
    InfoPrinter.b("Q.qqstory.newImageLoader", new Object[] { "resume ui task" });
    this.c.removeMessages(4);
    Object localObject;
    if (this.g.size() > 0)
    {
      localObject = this.c;
      ((Handler)localObject).sendMessage(((Handler)localObject).obtainMessage(4));
    }
    if (this.f.c() > 0)
    {
      localObject = this.f.b();
      int i = 2;
      while ((((ListIterator)localObject).hasPrevious()) && (i > 0))
      {
        Map.Entry localEntry = (Map.Entry)((ListIterator)localObject).previous();
        ((ListIterator)localObject).remove();
        if (((WeakReference)localEntry.getValue()).get() != null) {
          this.c.sendMessage(this.b.obtainMessage(1, localEntry.getKey()));
        } else {
          ((Task)localEntry.getKey()).c();
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
      if (this.f.c() > 0)
      {
        paramMessage = this.f.b();
        Object localObject1;
        while ((paramMessage.hasPrevious()) && (i > 0))
        {
          localObject1 = (Map.Entry)paramMessage.previous();
          paramMessage.remove();
          if (((WeakReference)((Map.Entry)localObject1).getValue()).get() != null) {
            this.c.sendMessage(this.b.obtainMessage(1, ((Map.Entry)localObject1).getKey()));
          } else {
            ((Task)((Map.Entry)localObject1).getKey()).c();
          }
          i -= 1;
        }
        continue;
        InfoPrinter.b("Q.qqstory.newImageLoader", new Object[] { "HANDLE_WAITING_UI_TASK" });
        if (this.e) {
          return true;
        }
        paramMessage = this.g.entrySet().iterator();
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
            localObject2 = ((ImageView)localObject1).getTag(2131436784);
            localStringBuilder = new StringBuilder();
            localStringBuilder.append(" view hash:");
            localStringBuilder.append(localObject1.hashCode());
            InfoPrinter.b("Q.qqstory.newImageLoader", new Object[] { "postToUI o= ", localObject2, " and change to: wait", localStringBuilder.toString() });
            ((ImageView)localObject1).setTag(2131436784, null);
            paramMessage.remove();
          }
          i -= 1;
          if (i <= 0) {
            break;
          }
        }
        if (this.g.size() > 0)
        {
          paramMessage = this.c;
          paramMessage.sendMessageDelayed(paramMessage.obtainMessage(4), 16L);
          continue;
          paramMessage = (Task)paramMessage.obj;
          InfoPrinter.a("Q.qqstory.newImageLoader", new Object[] { "EXECUTE_TASK_COMPLETED:", paramMessage.b() });
          if (!paramMessage.d())
          {
            InfoPrinter.a("Q.qqstory.newImageLoader", new Object[] { "EXECUTE_TASK_COMPLETED post ui:", paramMessage.b() });
            paramMessage.a(this.g, this.e);
            localObject1 = (ImageView)paramMessage.d.get();
            if (localObject1 != null)
            {
              InfoPrinter.a("Q.qqstory.newImageLoader", new Object[] { "completed the request,hash: ", Integer.valueOf(localObject1.hashCode()) });
              this.f.a((ImageView)localObject1);
            }
            if (paramMessage.e != null) {
              a().put(paramMessage.b, paramMessage.e);
            }
          }
          else
          {
            InfoPrinter.c("Q.qqstory.newImageLoader", new Object[] { "EXECUTE_TASK_COMPLETED have been cancel:", paramMessage.b() });
          }
          paramMessage.e();
          if (!this.e)
          {
            paramMessage = this.c;
            paramMessage.sendMessage(paramMessage.obtainMessage(5));
            continue;
            paramMessage = (Task)paramMessage.obj;
            InfoPrinter.a("Q.qqstory.newImageLoader", new Object[] { "EXECUTE_TASK_ERROR:", paramMessage.b() });
            localObject1 = (ImageView)paramMessage.d.get();
            if (localObject1 != null)
            {
              this.f.a((ImageView)localObject1);
              ((ImageView)localObject1).setImageDrawable(paramMessage.f);
              localObject2 = ((ImageView)localObject1).getTag(2131436784);
              localStringBuilder = new StringBuilder();
              localStringBuilder.append(" view hash:");
              localStringBuilder.append(localObject1.hashCode());
              InfoPrinter.b("Q.qqstory.newImageLoader", new Object[] { "postToUI o= ", localObject2, " and change to: default", localStringBuilder.toString() });
              ((ImageView)localObject1).setTag(2131436784, null);
            }
            paramMessage.e();
            continue;
            paramMessage = (Task)paramMessage.obj;
            if (paramMessage.d()) {
              break;
            }
            paramMessage.a();
          }
        }
      }
    }
    InfoPrinter.c("Q.qqstory.newImageLoader", new Object[] { HardCodeUtil.a(2131903703), paramMessage.b() });
    paramMessage.e();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.view.asyncImageLoader.ImageLoader
 * JD-Core Version:    0.7.0.1
 */