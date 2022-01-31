package com.tencent.mobileqq.apollo;

import android.view.View;
import java.lang.ref.WeakReference;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicBoolean;

public class ApolloTicker$NativeDrawTask
  extends TimerTask
{
  private int jdField_a_of_type_Int;
  private final long jdField_a_of_type_Long;
  private StringBuilder jdField_a_of_type_JavaLangStringBuilder;
  private WeakReference<View> jdField_a_of_type_JavaLangRefWeakReference;
  private final long b;
  private long c;
  private long d;
  private long e;
  
  ApolloTicker$NativeDrawTask(ApolloTicker paramApolloTicker, View paramView, long paramLong1, long paramLong2)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramView);
    this.jdField_a_of_type_Long = paramLong1;
    this.b = paramLong2;
    this.jdField_a_of_type_Int = -1;
    paramLong1 = System.currentTimeMillis();
    this.c = paramLong1;
    this.d = paramLong1;
    this.jdField_a_of_type_JavaLangStringBuilder = new StringBuilder();
  }
  
  public String a()
  {
    long l = 0L;
    if (this.jdField_a_of_type_Int > 0) {
      l = (this.e - this.c) / this.jdField_a_of_type_Int;
    }
    this.jdField_a_of_type_JavaLangStringBuilder.append("[mspf:").append(l).append("]");
    String str = this.jdField_a_of_type_JavaLangStringBuilder.toString();
    this.jdField_a_of_type_JavaLangStringBuilder.delete(0, this.jdField_a_of_type_JavaLangStringBuilder.length());
    return str;
  }
  
  public void a(View paramView)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramView);
  }
  
  public void run()
  {
    if (this.jdField_a_of_type_JavaLangRefWeakReference == null) {}
    Object localObject;
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              return;
              localObject = (View)this.jdField_a_of_type_JavaLangRefWeakReference.get();
            } while (localObject == null);
            if (!(localObject instanceof ApolloSurfaceView)) {
              break;
            }
            localObject = (ApolloSurfaceView)localObject;
          } while ((((ApolloSurfaceView)localObject).mIsDestroy == null) || (((ApolloSurfaceView)localObject).mIsDestroy.get()));
          if (((ApolloSurfaceView)localObject).mRenderMode == 0)
          {
            ((ApolloSurfaceView)localObject).requestRender();
            return;
          }
        } while (((ApolloSurfaceView)localObject).mRenderMode != 1);
        this.this$0.pauseTicker(this.this$0.ticker);
        return;
      } while (!(localObject instanceof ApolloTextureView));
      localObject = (ApolloTextureView)localObject;
    } while ((((ApolloTextureView)localObject).mIsDestroy == null) || (((ApolloTextureView)localObject).mIsDestroy.get()));
    System.currentTimeMillis();
    ((ApolloTextureView)localObject).requestRender();
    System.currentTimeMillis();
    this.jdField_a_of_type_Int += 1;
    this.e = System.currentTimeMillis();
    this.d = this.e;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.ApolloTicker.NativeDrawTask
 * JD-Core Version:    0.7.0.1
 */