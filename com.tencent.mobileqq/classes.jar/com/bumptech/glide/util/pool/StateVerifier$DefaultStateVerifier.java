package com.bumptech.glide.util.pool;

class StateVerifier$DefaultStateVerifier
  extends StateVerifier
{
  private volatile boolean a;
  
  StateVerifier$DefaultStateVerifier()
  {
    super(null);
  }
  
  public void a(boolean paramBoolean)
  {
    this.a = paramBoolean;
  }
  
  public void b()
  {
    if (!this.a) {
      return;
    }
    throw new IllegalStateException("Already released");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.util.pool.StateVerifier.DefaultStateVerifier
 * JD-Core Version:    0.7.0.1
 */