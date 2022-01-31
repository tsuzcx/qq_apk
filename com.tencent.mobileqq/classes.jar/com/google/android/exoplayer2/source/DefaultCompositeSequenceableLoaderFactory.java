package com.google.android.exoplayer2.source;

public final class DefaultCompositeSequenceableLoaderFactory
  implements CompositeSequenceableLoaderFactory
{
  public SequenceableLoader createCompositeSequenceableLoader(SequenceableLoader... paramVarArgs)
  {
    return new CompositeSequenceableLoader(paramVarArgs);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.source.DefaultCompositeSequenceableLoaderFactory
 * JD-Core Version:    0.7.0.1
 */