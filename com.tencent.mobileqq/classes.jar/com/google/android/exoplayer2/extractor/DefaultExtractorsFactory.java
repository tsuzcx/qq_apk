package com.google.android.exoplayer2.extractor;

import com.google.android.exoplayer2.extractor.flv.FlvExtractor;
import com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor;
import com.google.android.exoplayer2.extractor.mp3.Mp3Extractor;
import com.google.android.exoplayer2.extractor.mp4.FragmentedMp4Extractor;
import com.google.android.exoplayer2.extractor.mp4.Mp4Extractor;
import com.google.android.exoplayer2.extractor.ogg.OggExtractor;
import com.google.android.exoplayer2.extractor.ts.Ac3Extractor;
import com.google.android.exoplayer2.extractor.ts.AdtsExtractor;
import com.google.android.exoplayer2.extractor.ts.PsExtractor;
import com.google.android.exoplayer2.extractor.ts.TsExtractor;
import com.google.android.exoplayer2.extractor.wav.WavExtractor;
import java.lang.reflect.Constructor;

public final class DefaultExtractorsFactory
  implements ExtractorsFactory
{
  private static final Constructor<? extends Extractor> FLAC_EXTRACTOR_CONSTRUCTOR;
  private int fragmentedMp4Flags;
  private int matroskaFlags;
  private int mp3Flags;
  private int mp4Flags;
  private int tsFlags;
  private int tsMode = 1;
  
  static
  {
    try
    {
      try
      {
        Constructor localConstructor = Class.forName("com.google.android.exoplayer2.ext.flac.FlacExtractor").asSubclass(Extractor.class).getConstructor(new Class[0]);
      }
      catch (Exception localException)
      {
        throw new RuntimeException("Error instantiating FLAC extension", localException);
      }
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      label33:
      Object localObject;
      break label33;
    }
    localObject = null;
    FLAC_EXTRACTOR_CONSTRUCTOR = localObject;
  }
  
  public Extractor[] createExtractors()
  {
    for (;;)
    {
      try
      {
        if (FLAC_EXTRACTOR_CONSTRUCTOR == null)
        {
          i = 11;
          Extractor[] arrayOfExtractor = new Extractor[i];
          arrayOfExtractor[0] = new Mp4Extractor(this.mp4Flags);
          arrayOfExtractor[1] = new TsExtractor(this.tsMode, this.tsFlags);
          arrayOfExtractor[2] = new Mp3Extractor(this.mp3Flags);
          arrayOfExtractor[3] = new FragmentedMp4Extractor(this.fragmentedMp4Flags);
          arrayOfExtractor[4] = new MatroskaExtractor(this.matroskaFlags);
          arrayOfExtractor[5] = new AdtsExtractor();
          arrayOfExtractor[6] = new Ac3Extractor();
          arrayOfExtractor[7] = new FlvExtractor();
          arrayOfExtractor[8] = new OggExtractor();
          arrayOfExtractor[9] = new PsExtractor();
          arrayOfExtractor[10] = new WavExtractor();
          Constructor localConstructor = FLAC_EXTRACTOR_CONSTRUCTOR;
          if (localConstructor != null) {
            try
            {
              arrayOfExtractor[11] = ((Extractor)FLAC_EXTRACTOR_CONSTRUCTOR.newInstance(new Object[0]));
            }
            catch (Exception localException)
            {
              throw new IllegalStateException("Unexpected error creating FLAC extractor", localException);
            }
          }
          return localException;
        }
      }
      finally {}
      int i = 12;
    }
  }
  
  public DefaultExtractorsFactory setFragmentedMp4ExtractorFlags(int paramInt)
  {
    try
    {
      this.fragmentedMp4Flags = paramInt;
      return this;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public DefaultExtractorsFactory setMatroskaExtractorFlags(int paramInt)
  {
    try
    {
      this.matroskaFlags = paramInt;
      return this;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public DefaultExtractorsFactory setMp3ExtractorFlags(int paramInt)
  {
    try
    {
      this.mp3Flags = paramInt;
      return this;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public DefaultExtractorsFactory setMp4ExtractorFlags(int paramInt)
  {
    try
    {
      this.mp4Flags = paramInt;
      return this;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public DefaultExtractorsFactory setTsExtractorFlags(int paramInt)
  {
    try
    {
      this.tsFlags = paramInt;
      return this;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public DefaultExtractorsFactory setTsExtractorMode(int paramInt)
  {
    try
    {
      this.tsMode = paramInt;
      return this;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.exoplayer2.extractor.DefaultExtractorsFactory
 * JD-Core Version:    0.7.0.1
 */