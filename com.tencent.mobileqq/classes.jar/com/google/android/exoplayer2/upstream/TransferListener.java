package com.google.android.exoplayer2.upstream;

public abstract interface TransferListener<S>
{
  public abstract void onBytesTransferred(S paramS, int paramInt);
  
  public abstract void onTransferEnd(S paramS);
  
  public abstract void onTransferStart(S paramS, DataSpec paramDataSpec);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.upstream.TransferListener
 * JD-Core Version:    0.7.0.1
 */