package com.tencent.component.network.utils.thread;

import java.util.concurrent.Callable;

abstract class AsyncTask$WorkerRunnable<Params, Result>
  implements Callable<Result>
{
  Params[] mParams;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.component.network.utils.thread.AsyncTask.WorkerRunnable
 * JD-Core Version:    0.7.0.1
 */