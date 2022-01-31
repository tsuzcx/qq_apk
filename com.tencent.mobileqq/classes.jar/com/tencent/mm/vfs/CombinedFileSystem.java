package com.tencent.mm.vfs;

import android.os.Parcel;
import android.os.ParcelFormatException;
import android.os.Parcelable.Creator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class CombinedFileSystem
  extends DelegateFileSystem
{
  public static final Parcelable.Creator<CombinedFileSystem> CREATOR = new CombinedFileSystem.1();
  private static final String GLOB_META_CHARS = "\\*?[{";
  private static final String REGEX_META_CHARS = ".^$+{[]|()";
  private static final int VERSION = 1;
  private final int mCaps;
  private final FileSystem[] mFSList;
  private final CombinedFileSystem.PatternEntry[] mPatternList;
  
  private CombinedFileSystem(Parcel paramParcel)
  {
    VFSUtils.checkFileSystemVersion(paramParcel, CombinedFileSystem.class, 1);
    int m = paramParcel.readInt();
    this.mFSList = new FileSystem[m];
    int i = 0;
    int j = 0;
    Object localObject;
    while (i < m)
    {
      localObject = (FileSystem)paramParcel.readParcelable(getClass().getClassLoader());
      if (localObject == null) {
        throw new ParcelFormatException();
      }
      this.mFSList[i] = localObject;
      j |= ((FileSystem)localObject).capabilityFlags();
      i += 1;
    }
    this.mCaps = j;
    j = paramParcel.readInt();
    this.mPatternList = new CombinedFileSystem.PatternEntry[j];
    i = k;
    if (i < j)
    {
      localObject = paramParcel.readString();
      if (localObject == null) {}
      for (localObject = null;; localObject = Pattern.compile((String)localObject))
      {
        k = paramParcel.readInt();
        this.mPatternList[i] = new CombinedFileSystem.PatternEntry((Pattern)localObject, k, this.mFSList[k]);
        i += 1;
        break;
      }
    }
  }
  
  public CombinedFileSystem(FileSystem[] paramArrayOfFileSystem, String[] paramArrayOfString)
  {
    if ((paramArrayOfFileSystem == null) || (paramArrayOfString == null) || (paramArrayOfFileSystem.length == 0) || (paramArrayOfString.length == 0)) {
      throw new IllegalArgumentException("fs and/or globPatterns is null");
    }
    if (paramArrayOfFileSystem.length != paramArrayOfString.length) {
      throw new IllegalArgumentException("fs and globPattern must have the same length");
    }
    this.mFSList = new FileSystem[paramArrayOfFileSystem.length];
    int i = 0;
    int j = 0;
    while (i < paramArrayOfFileSystem.length)
    {
      if (paramArrayOfFileSystem[i] == null) {
        throw new IllegalArgumentException("Wrong wrapped filesystem.");
      }
      this.mFSList[i] = paramArrayOfFileSystem[i];
      j |= paramArrayOfFileSystem[i].capabilityFlags();
      i += 1;
    }
    this.mCaps = j;
    paramArrayOfFileSystem = new ArrayList();
    i = k;
    if (i < paramArrayOfString.length)
    {
      if (paramArrayOfString[i] == null) {
        paramArrayOfFileSystem.add(new CombinedFileSystem.PatternEntry(null, i, this.mFSList[i]));
      }
      for (;;)
      {
        i += 1;
        break;
        Iterator localIterator = zeroSplit(paramArrayOfString[i]).iterator();
        while (localIterator.hasNext()) {
          paramArrayOfFileSystem.add(new CombinedFileSystem.PatternEntry(globToRegexPattern((String)localIterator.next()), i, this.mFSList[i]));
        }
      }
    }
    this.mPatternList = new CombinedFileSystem.PatternEntry[paramArrayOfFileSystem.size()];
    paramArrayOfFileSystem.toArray(this.mPatternList);
  }
  
  private static Pattern globToRegexPattern(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder("^");
    int j;
    int m;
    if (paramString.startsWith("**/"))
    {
      localStringBuilder.append("(?:.*/)?");
      j = 3;
      m = 0;
    }
    for (;;)
    {
      int k;
      int i;
      label245:
      char c1;
      label253:
      int n;
      if (j < paramString.length())
      {
        k = j + 1;
        i = paramString.charAt(j);
        switch (i)
        {
        default: 
          if (isRegexMeta(i)) {
            localStringBuilder.append('\\');
          }
          localStringBuilder.append(i);
          j = k;
          break;
        case 92: 
          if (k == paramString.length()) {
            throw new PatternSyntaxException("No character to escape", paramString, k - 1);
          }
          j = k + 1;
          i = paramString.charAt(k);
          if ((isGlobMeta(i)) || (isRegexMeta(i))) {
            localStringBuilder.append('\\');
          }
          localStringBuilder.append(i);
          break;
        case 91: 
          localStringBuilder.append("[[^/]&&[");
          if (nextChar(paramString, k) == '^')
          {
            localStringBuilder.append("\\^");
            j = k + 1;
            char c2 = i;
            c1 = '\000';
            k = 0;
            if (j >= paramString.length()) {
              break label718;
            }
            n = j + 1;
            i = paramString.charAt(j);
            if (i == 93)
            {
              k = i;
              j = n;
              label283:
              if (k == 93) {
                break label518;
              }
              throw new PatternSyntaxException("Missing ']", paramString, j - 1);
            }
          }
          else
          {
            if (nextChar(paramString, k) != '!') {
              break label724;
            }
            localStringBuilder.append('^');
            k += 1;
          }
          break;
        }
      }
      else
      {
        label518:
        label713:
        label718:
        label724:
        for (;;)
        {
          j = k;
          if (nextChar(paramString, k) != '-') {
            break label245;
          }
          localStringBuilder.append('-');
          j = k + 1;
          break label245;
          if (i == 47) {
            throw new PatternSyntaxException("Explicit 'name separator' in class", paramString, n - 1);
          }
          if ((i == 92) || (i == 91) || ((i == 38) && (nextChar(paramString, n) == '&'))) {
            localStringBuilder.append('\\');
          }
          localStringBuilder.append(i);
          if (i == 45)
          {
            if (k == 0) {
              throw new PatternSyntaxException("Invalid range", paramString, n - 1);
            }
            j = n + 1;
            i = nextChar(paramString, n);
            if (i == 0) {
              break label713;
            }
            if (i == 93)
            {
              k = i;
              break label283;
            }
            if (i < c1) {
              throw new PatternSyntaxException("Invalid range", paramString, j - 3);
            }
            localStringBuilder.append(i);
            k = 0;
            n = i;
            break label253;
          }
          c1 = i;
          k = 1;
          j = n;
          n = i;
          break label253;
          localStringBuilder.append("]]");
          break;
          if (m != 0) {
            throw new PatternSyntaxException("Cannot nest groups", paramString, k - 1);
          }
          localStringBuilder.append("(?:(?:");
          j = k;
          m = 1;
          break;
          if (m != 0)
          {
            localStringBuilder.append("))");
            j = k;
            m = 0;
            break;
          }
          localStringBuilder.append('}');
          j = k;
          break;
          if (m != 0)
          {
            localStringBuilder.append(")|(?:");
            j = k;
            break;
          }
          localStringBuilder.append(',');
          j = k;
          break;
          if (nextChar(paramString, k) == '*')
          {
            localStringBuilder.append(".*");
            j = k + 1;
            break;
          }
          localStringBuilder.append("[^/]*");
          j = k;
          break;
          localStringBuilder.append("[^/]");
          j = k;
          break;
          if (m != 0) {
            throw new PatternSyntaxException("Missing '}", paramString, j - 1);
          }
          return Pattern.compile('$');
          k = i;
          break label283;
          k = n;
          break label283;
        }
        j = 0;
        m = 0;
      }
    }
  }
  
  private static boolean isGlobMeta(char paramChar)
  {
    return "\\*?[{".indexOf(paramChar) != -1;
  }
  
  private static boolean isRegexMeta(char paramChar)
  {
    return ".^$+{[]|()".indexOf(paramChar) != -1;
  }
  
  private static char nextChar(String paramString, int paramInt)
  {
    if (paramInt < paramString.length()) {
      return paramString.charAt(paramInt);
    }
    return '\000';
  }
  
  private static List<String> zeroSplit(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    paramString = new StringTokenizer(paramString, "");
    while (paramString.hasMoreTokens()) {
      localArrayList.add(paramString.nextToken());
    }
    return localArrayList;
  }
  
  protected Iterable<FileSystem> allFileSystems()
  {
    return Arrays.asList(this.mFSList);
  }
  
  public int capabilityFlags()
  {
    return this.mCaps;
  }
  
  protected FileSystem delegate(String paramString, int paramInt)
  {
    CombinedFileSystem.PatternEntry[] arrayOfPatternEntry = this.mPatternList;
    int i = arrayOfPatternEntry.length;
    paramInt = 0;
    while (paramInt < i)
    {
      CombinedFileSystem.PatternEntry localPatternEntry = arrayOfPatternEntry[paramInt];
      if ((localPatternEntry.pattern == null) || (localPatternEntry.pattern.matcher(paramString).matches())) {
        return localPatternEntry.fs;
      }
      paramInt += 1;
    }
    return null;
  }
  
  public FileSystem.FsStat fileSystemStat(String paramString)
  {
    return this.mFSList[(this.mFSList.length - 1)].fileSystemStat(paramString);
  }
  
  public boolean mkdirs(String paramString)
  {
    int i = 0;
    FileSystem[] arrayOfFileSystem = this.mFSList;
    int j = arrayOfFileSystem.length;
    boolean bool = false;
    while (i < j)
    {
      bool |= arrayOfFileSystem[i].mkdirs(paramString);
      i += 1;
    }
    return bool;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("CombinedFS [");
    FileSystem[] arrayOfFileSystem = this.mFSList;
    int j = arrayOfFileSystem.length;
    int i = 0;
    while (i < j)
    {
      localStringBuilder.append(arrayOfFileSystem[i].toString()).append(", ");
      i += 1;
    }
    localStringBuilder.setLength(localStringBuilder.length() - 2);
    return ']';
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    VFSUtils.writeFileSystemVersion(paramParcel, CombinedFileSystem.class, 1);
    paramParcel.writeInt(this.mFSList.length);
    Object localObject = this.mFSList;
    int j = localObject.length;
    int i = 0;
    while (i < j)
    {
      paramParcel.writeParcelable(localObject[i], paramInt);
      i += 1;
    }
    paramParcel.writeInt(this.mPatternList.length);
    CombinedFileSystem.PatternEntry[] arrayOfPatternEntry = this.mPatternList;
    i = arrayOfPatternEntry.length;
    paramInt = 0;
    if (paramInt < i)
    {
      CombinedFileSystem.PatternEntry localPatternEntry = arrayOfPatternEntry[paramInt];
      if (localPatternEntry.pattern == null) {}
      for (localObject = null;; localObject = localPatternEntry.pattern.pattern())
      {
        paramParcel.writeString((String)localObject);
        paramParcel.writeInt(localPatternEntry.fsIdx);
        paramInt += 1;
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mm.vfs.CombinedFileSystem
 * JD-Core Version:    0.7.0.1
 */