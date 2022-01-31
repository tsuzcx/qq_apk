package com.facebook.soloader;

import android.content.Context;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collection;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class ExtractFromZipSoSource
  extends UnpackingSoSource
{
  protected final File mZipFileName;
  protected final String mZipSearchPattern;
  
  public ExtractFromZipSoSource(Context paramContext, String paramString1, File paramFile, String paramString2)
  {
    super(paramContext, paramString1);
    this.mZipFileName = paramFile;
    this.mZipSearchPattern = paramString2;
  }
  
  protected UnpackingSoSource.Unpacker makeUnpacker()
    throws IOException
  {
    return new ZipUnpacker(this);
  }
  
  private static final class ZipDso
    extends UnpackingSoSource.Dso
    implements Comparable
  {
    final int abiScore;
    final ZipEntry backingEntry;
    
    ZipDso(String paramString, ZipEntry paramZipEntry, int paramInt)
    {
      super(makePseudoHash(paramZipEntry));
      this.backingEntry = paramZipEntry;
      this.abiScore = paramInt;
    }
    
    private static String makePseudoHash(ZipEntry paramZipEntry)
    {
      return String.format("pseudo-zip-hash-1-%s-%s-%s-%s", new Object[] { paramZipEntry.getName(), Long.valueOf(paramZipEntry.getSize()), Long.valueOf(paramZipEntry.getCompressedSize()), Long.valueOf(paramZipEntry.getCrc()) });
    }
    
    public int compareTo(Object paramObject)
    {
      return this.name.compareTo(((ZipDso)paramObject).name);
    }
  }
  
  protected class ZipUnpacker
    extends UnpackingSoSource.Unpacker
  {
    private ExtractFromZipSoSource.ZipDso[] mDsos;
    private final UnpackingSoSource mSoSource;
    private final ZipFile mZipFile = new ZipFile(ExtractFromZipSoSource.this.mZipFileName);
    
    ZipUnpacker(UnpackingSoSource paramUnpackingSoSource)
      throws IOException
    {
      this.mSoSource = paramUnpackingSoSource;
    }
    
    public void close()
      throws IOException
    {
      this.mZipFile.close();
    }
    
    final ExtractFromZipSoSource.ZipDso[] ensureDsos()
    {
      if (this.mDsos == null)
      {
        Object localObject1 = new LinkedHashSet();
        Object localObject2 = new HashMap();
        Pattern localPattern = Pattern.compile(ExtractFromZipSoSource.this.mZipSearchPattern);
        String[] arrayOfString = SysUtil.getSupportedAbis();
        Enumeration localEnumeration = this.mZipFile.entries();
        while (localEnumeration.hasMoreElements())
        {
          ZipEntry localZipEntry = (ZipEntry)localEnumeration.nextElement();
          Object localObject4 = localPattern.matcher(localZipEntry.getName());
          if (((Matcher)localObject4).matches())
          {
            Object localObject3 = ((Matcher)localObject4).group(1);
            localObject4 = ((Matcher)localObject4).group(2);
            i = SysUtil.findAbiScore(arrayOfString, (String)localObject3);
            if (i >= 0)
            {
              ((Set)localObject1).add(localObject3);
              localObject3 = (ExtractFromZipSoSource.ZipDso)((HashMap)localObject2).get(localObject4);
              if ((localObject3 == null) || (i < ((ExtractFromZipSoSource.ZipDso)localObject3).abiScore)) {
                ((HashMap)localObject2).put(localObject4, new ExtractFromZipSoSource.ZipDso((String)localObject4, localZipEntry, i));
              }
            }
          }
        }
        this.mSoSource.setSoSourceAbis((String[])((Set)localObject1).toArray(new String[((Set)localObject1).size()]));
        localObject1 = (ExtractFromZipSoSource.ZipDso[])((HashMap)localObject2).values().toArray(new ExtractFromZipSoSource.ZipDso[((HashMap)localObject2).size()]);
        Arrays.sort((Object[])localObject1);
        int j = 0;
        int i = 0;
        if (i < localObject1.length)
        {
          localObject2 = localObject1[i];
          if (shouldExtract(((ExtractFromZipSoSource.ZipDso)localObject2).backingEntry, ((ExtractFromZipSoSource.ZipDso)localObject2).name)) {
            j += 1;
          }
          for (;;)
          {
            i += 1;
            break;
            localObject1[i] = null;
          }
        }
        localObject2 = new ExtractFromZipSoSource.ZipDso[j];
        i = 0;
        int k;
        for (j = 0; i < localObject1.length; j = k)
        {
          localPattern = localObject1[i];
          k = j;
          if (localPattern != null)
          {
            localObject2[j] = localPattern;
            k = j + 1;
          }
          i += 1;
        }
        this.mDsos = ((ExtractFromZipSoSource.ZipDso[])localObject2);
      }
      return this.mDsos;
    }
    
    protected final UnpackingSoSource.DsoManifest getDsoManifest()
      throws IOException
    {
      return new UnpackingSoSource.DsoManifest(ensureDsos());
    }
    
    protected final UnpackingSoSource.InputDsoIterator openDsoIterator()
      throws IOException
    {
      return new ZipBackedInputDsoIterator(null);
    }
    
    protected boolean shouldExtract(ZipEntry paramZipEntry, String paramString)
    {
      return true;
    }
    
    private final class ZipBackedInputDsoIterator
      extends UnpackingSoSource.InputDsoIterator
    {
      private int mCurrentDso;
      
      private ZipBackedInputDsoIterator() {}
      
      public boolean hasNext()
      {
        ExtractFromZipSoSource.ZipUnpacker.this.ensureDsos();
        return this.mCurrentDso < ExtractFromZipSoSource.ZipUnpacker.this.mDsos.length;
      }
      
      public UnpackingSoSource.InputDso next()
        throws IOException
      {
        ExtractFromZipSoSource.ZipUnpacker.this.ensureDsos();
        Object localObject1 = ExtractFromZipSoSource.ZipUnpacker.this.mDsos;
        int i = this.mCurrentDso;
        this.mCurrentDso = (i + 1);
        Object localObject2 = localObject1[i];
        localObject1 = ExtractFromZipSoSource.ZipUnpacker.this.mZipFile.getInputStream(((ExtractFromZipSoSource.ZipDso)localObject2).backingEntry);
        try
        {
          localObject2 = new UnpackingSoSource.InputDso((UnpackingSoSource.Dso)localObject2, (InputStream)localObject1);
          if (0 != 0) {
            throw new NullPointerException();
          }
          return localObject2;
        }
        finally
        {
          if (localObject1 != null) {
            ((InputStream)localObject1).close();
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.facebook.soloader.ExtractFromZipSoSource
 * JD-Core Version:    0.7.0.1
 */