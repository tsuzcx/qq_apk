package androidx.loader.content;

class ModernAsyncTask$2
  extends ModernAsyncTask.WorkerRunnable<Params, Result>
{
  ModernAsyncTask$2(ModernAsyncTask paramModernAsyncTask) {}
  
  /* Error */
  public Result call()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 11	androidx/loader/content/ModernAsyncTask$2:this$0	Landroidx/loader/content/ModernAsyncTask;
    //   4: getfield 25	androidx/loader/content/ModernAsyncTask:mTaskInvoked	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   7: iconst_1
    //   8: invokevirtual 31	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   11: aconst_null
    //   12: astore 4
    //   14: aconst_null
    //   15: astore_3
    //   16: aload_3
    //   17: astore_1
    //   18: aload 4
    //   20: astore_2
    //   21: bipush 10
    //   23: invokestatic 37	android/os/Process:setThreadPriority	(I)V
    //   26: aload_3
    //   27: astore_1
    //   28: aload 4
    //   30: astore_2
    //   31: aload_0
    //   32: getfield 11	androidx/loader/content/ModernAsyncTask$2:this$0	Landroidx/loader/content/ModernAsyncTask;
    //   35: aload_0
    //   36: getfield 41	androidx/loader/content/ModernAsyncTask$2:mParams	[Ljava/lang/Object;
    //   39: invokevirtual 45	androidx/loader/content/ModernAsyncTask:doInBackground	([Ljava/lang/Object;)Ljava/lang/Object;
    //   42: astore_3
    //   43: aload_3
    //   44: astore_1
    //   45: aload_3
    //   46: astore_2
    //   47: invokestatic 50	android/os/Binder:flushPendingCommands	()V
    //   50: aload_0
    //   51: getfield 11	androidx/loader/content/ModernAsyncTask$2:this$0	Landroidx/loader/content/ModernAsyncTask;
    //   54: aload_3
    //   55: invokevirtual 54	androidx/loader/content/ModernAsyncTask:postResult	(Ljava/lang/Object;)Ljava/lang/Object;
    //   58: pop
    //   59: aload_3
    //   60: areturn
    //   61: astore_2
    //   62: goto +21 -> 83
    //   65: astore_3
    //   66: aload_2
    //   67: astore_1
    //   68: aload_0
    //   69: getfield 11	androidx/loader/content/ModernAsyncTask$2:this$0	Landroidx/loader/content/ModernAsyncTask;
    //   72: getfield 57	androidx/loader/content/ModernAsyncTask:mCancelled	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   75: iconst_1
    //   76: invokevirtual 31	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   79: aload_2
    //   80: astore_1
    //   81: aload_3
    //   82: athrow
    //   83: aload_0
    //   84: getfield 11	androidx/loader/content/ModernAsyncTask$2:this$0	Landroidx/loader/content/ModernAsyncTask;
    //   87: aload_1
    //   88: invokevirtual 54	androidx/loader/content/ModernAsyncTask:postResult	(Ljava/lang/Object;)Ljava/lang/Object;
    //   91: pop
    //   92: aload_2
    //   93: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	94	0	this	2
    //   17	71	1	localObject1	java.lang.Object
    //   20	27	2	localObject2	java.lang.Object
    //   61	32	2	localObject3	java.lang.Object
    //   15	45	3	localObject4	java.lang.Object
    //   65	17	3	localThrowable	java.lang.Throwable
    //   12	17	4	localObject5	java.lang.Object
    // Exception table:
    //   from	to	target	type
    //   21	26	61	finally
    //   31	43	61	finally
    //   47	50	61	finally
    //   68	79	61	finally
    //   81	83	61	finally
    //   21	26	65	java/lang/Throwable
    //   31	43	65	java/lang/Throwable
    //   47	50	65	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.loader.content.ModernAsyncTask.2
 * JD-Core Version:    0.7.0.1
 */