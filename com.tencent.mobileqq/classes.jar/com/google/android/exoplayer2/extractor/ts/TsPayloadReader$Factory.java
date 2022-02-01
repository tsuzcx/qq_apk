package com.google.android.exoplayer2.extractor.ts;

import android.util.SparseArray;

public abstract interface TsPayloadReader$Factory
{
  public abstract SparseArray<TsPayloadReader> createInitialPayloadReaders();
  
  public abstract TsPayloadReader createPayloadReader(int paramInt, TsPayloadReader.EsInfo paramEsInfo);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.exoplayer2.extractor.ts.TsPayloadReader.Factory
 * JD-Core Version:    0.7.0.1
 */