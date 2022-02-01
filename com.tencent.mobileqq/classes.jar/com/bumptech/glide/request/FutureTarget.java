package com.bumptech.glide.request;

import com.bumptech.glide.request.target.Target;
import java.util.concurrent.Future;

public abstract interface FutureTarget<R>
  extends Target<R>, Future<R>
{}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.request.FutureTarget
 * JD-Core Version:    0.7.0.1
 */