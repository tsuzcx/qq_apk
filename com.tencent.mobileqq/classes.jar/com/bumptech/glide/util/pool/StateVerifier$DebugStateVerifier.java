package com.bumptech.glide.util.pool;

class StateVerifier$DebugStateVerifier
  extends StateVerifier
{
  private volatile RuntimeException a;
  
  StateVerifier$DebugStateVerifier()
  {
    super(null);
  }
  
  void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.a = new RuntimeException("Released");
      return;
    }
    this.a = null;
  }
  
  public void b()
  {
    if (this.a == null) {
      return;
    }
    throw new IllegalStateException("Already released", this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.util.pool.StateVerifier.DebugStateVerifier
 * JD-Core Version:    0.7.0.1
 */