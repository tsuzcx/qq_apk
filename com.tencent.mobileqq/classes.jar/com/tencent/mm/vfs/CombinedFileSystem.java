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
    int k = 0;
    int i = 0;
    int j = 0;
    Object localObject;
    while (i < m)
    {
      localObject = (FileSystem)paramParcel.readParcelable(getClass().getClassLoader());
      if (localObject != null)
      {
        this.mFSList[i] = localObject;
        j |= ((FileSystem)localObject).capabilityFlags();
        i += 1;
      }
      else
      {
        throw new ParcelFormatException();
      }
    }
    this.mCaps = j;
    j = paramParcel.readInt();
    this.mPatternList = new CombinedFileSystem.PatternEntry[j];
    i = k;
    while (i < j)
    {
      localObject = paramParcel.readString();
      if (localObject == null) {
        localObject = null;
      } else {
        localObject = Pattern.compile((String)localObject);
      }
      k = paramParcel.readInt();
      this.mPatternList[i] = new CombinedFileSystem.PatternEntry((Pattern)localObject, k, this.mFSList[k]);
      i += 1;
    }
  }
  
  public CombinedFileSystem(FileSystem[] paramArrayOfFileSystem, String[] paramArrayOfString)
  {
    if ((paramArrayOfFileSystem != null) && (paramArrayOfString != null) && (paramArrayOfFileSystem.length != 0) && (paramArrayOfString.length != 0))
    {
      if (paramArrayOfFileSystem.length == paramArrayOfString.length)
      {
        this.mFSList = new FileSystem[paramArrayOfFileSystem.length];
        int k = 0;
        int i = 0;
        int j = 0;
        while (i < paramArrayOfFileSystem.length) {
          if (paramArrayOfFileSystem[i] != null)
          {
            this.mFSList[i] = paramArrayOfFileSystem[i];
            j |= paramArrayOfFileSystem[i].capabilityFlags();
            i += 1;
          }
          else
          {
            throw new IllegalArgumentException("Wrong wrapped filesystem.");
          }
        }
        this.mCaps = j;
        paramArrayOfFileSystem = new ArrayList();
        i = k;
        while (i < paramArrayOfString.length)
        {
          if (paramArrayOfString[i] == null)
          {
            paramArrayOfFileSystem.add(new CombinedFileSystem.PatternEntry(null, i, this.mFSList[i]));
          }
          else
          {
            Iterator localIterator = zeroSplit(paramArrayOfString[i]).iterator();
            while (localIterator.hasNext()) {
              paramArrayOfFileSystem.add(new CombinedFileSystem.PatternEntry(globToRegexPattern((String)localIterator.next()), i, this.mFSList[i]));
            }
          }
          i += 1;
        }
        this.mPatternList = new CombinedFileSystem.PatternEntry[paramArrayOfFileSystem.size()];
        paramArrayOfFileSystem.toArray(this.mPatternList);
        return;
      }
      throw new IllegalArgumentException("fs and globPattern must have the same length");
    }
    paramArrayOfFileSystem = new IllegalArgumentException("fs and/or globPatterns is null");
    for (;;)
    {
      throw paramArrayOfFileSystem;
    }
  }
  
  private static Pattern globToRegexPattern(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder("^");
    int k;
    if (paramString.startsWith("**/"))
    {
      localStringBuilder.append("(?:.*/)?");
      k = 3;
    }
    else
    {
      k = 0;
    }
    int n = 0;
    for (;;)
    {
      if (k >= paramString.length()) {
        break label666;
      }
      int j = k + 1;
      int i = paramString.charAt(k);
      if (i != 42)
      {
        if (i != 44)
        {
          if (i != 63)
          {
            if (i != 123)
            {
              if (i != 125)
              {
                if (i != 91)
                {
                  if (i != 92)
                  {
                    if (isRegexMeta(i)) {
                      localStringBuilder.append('\\');
                    }
                    localStringBuilder.append(i);
                    break label661;
                  }
                  if (j != paramString.length())
                  {
                    k = j + 1;
                    i = paramString.charAt(j);
                    if ((isGlobMeta(i)) || (isRegexMeta(i))) {
                      localStringBuilder.append('\\');
                    }
                    localStringBuilder.append(i);
                    continue;
                  }
                  throw new PatternSyntaxException("No character to escape", paramString, j - 1);
                }
                localStringBuilder.append("[[^/]&&[");
                if (nextChar(paramString, j) == '^') {
                  localStringBuilder.append("\\^");
                }
                for (;;)
                {
                  j += 1;
                  break;
                  k = j;
                  if (nextChar(paramString, j) == '!')
                  {
                    localStringBuilder.append('^');
                    k = j + 1;
                  }
                  j = k;
                  if (nextChar(paramString, k) != '-') {
                    break;
                  }
                  localStringBuilder.append('-');
                  j = k;
                }
                char c = i;
                k = 0;
                int i1 = 0;
                int m;
                while (j < paramString.length())
                {
                  m = j + 1;
                  i = paramString.charAt(j);
                  if (i == 93)
                  {
                    k = m;
                    m = i;
                    break label494;
                  }
                  if (i != 47)
                  {
                    if ((i == 92) || (i == 91) || ((i == 38) && (nextChar(paramString, m) == '&'))) {
                      localStringBuilder.append('\\');
                    }
                    localStringBuilder.append(i);
                    if (i == 45)
                    {
                      if (k != 0)
                      {
                        j = m + 1;
                        i = nextChar(paramString, m);
                        k = j;
                        m = i;
                        if (i == 0) {
                          break label494;
                        }
                        if (i == 93)
                        {
                          k = j;
                          m = i;
                          break label494;
                        }
                        if (i >= i1)
                        {
                          localStringBuilder.append(i);
                          k = 0;
                          m = i;
                        }
                        else
                        {
                          throw new PatternSyntaxException("Invalid range", paramString, j - 3);
                        }
                      }
                      else
                      {
                        throw new PatternSyntaxException("Invalid range", paramString, m - 1);
                      }
                    }
                    else
                    {
                      i1 = i;
                      k = 1;
                      j = m;
                      m = i1;
                    }
                  }
                  else
                  {
                    throw new PatternSyntaxException("Explicit 'name separator' in class", paramString, m - 1);
                  }
                }
                k = j;
                label494:
                if (m == 93)
                {
                  localStringBuilder.append("]]");
                  continue;
                }
                throw new PatternSyntaxException("Missing ']", paramString, k - 1);
              }
              if (n != 0)
              {
                localStringBuilder.append("))");
                k = j;
                break;
              }
              localStringBuilder.append('}');
              break label661;
            }
            if (n == 0)
            {
              localStringBuilder.append("(?:(?:");
              n = 1;
              k = j;
              continue;
            }
            throw new PatternSyntaxException("Cannot nest groups", paramString, j - 1);
          }
          localStringBuilder.append("[^/]");
          break label661;
        }
        if (n != 0)
        {
          localStringBuilder.append(")|(?:");
          break label661;
        }
        localStringBuilder.append(',');
        break label661;
      }
      if (nextChar(paramString, j) == '*')
      {
        localStringBuilder.append(".*");
        j += 1;
      }
      else
      {
        localStringBuilder.append("[^/]*");
      }
      label661:
      k = j;
    }
    label666:
    if (n == 0)
    {
      localStringBuilder.append('$');
      return Pattern.compile(localStringBuilder.toString());
    }
    paramString = new PatternSyntaxException("Missing '}", paramString, k - 1);
    for (;;)
    {
      throw paramString;
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
      if ((localPatternEntry.pattern != null) && (!localPatternEntry.pattern.matcher(paramString).matches())) {
        paramInt += 1;
      } else {
        return localPatternEntry.fs;
      }
    }
    return null;
  }
  
  public FileSystem.FsStat fileSystemStat(String paramString)
  {
    FileSystem[] arrayOfFileSystem = this.mFSList;
    return arrayOfFileSystem[(arrayOfFileSystem.length - 1)].fileSystemStat(paramString);
  }
  
  public boolean mkdirs(String paramString)
  {
    FileSystem[] arrayOfFileSystem = this.mFSList;
    int j = arrayOfFileSystem.length;
    int i = 0;
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
      localStringBuilder.append(arrayOfFileSystem[i].toString());
      localStringBuilder.append(", ");
      i += 1;
    }
    localStringBuilder.setLength(localStringBuilder.length() - 2);
    localStringBuilder.append(']');
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    VFSUtils.writeFileSystemVersion(paramParcel, CombinedFileSystem.class, 1);
    paramParcel.writeInt(this.mFSList.length);
    Object localObject = this.mFSList;
    int k = localObject.length;
    int j = 0;
    int i = 0;
    while (i < k)
    {
      paramParcel.writeParcelable(localObject[i], paramInt);
      i += 1;
    }
    paramParcel.writeInt(this.mPatternList.length);
    CombinedFileSystem.PatternEntry[] arrayOfPatternEntry = this.mPatternList;
    i = arrayOfPatternEntry.length;
    paramInt = j;
    while (paramInt < i)
    {
      CombinedFileSystem.PatternEntry localPatternEntry = arrayOfPatternEntry[paramInt];
      if (localPatternEntry.pattern == null) {
        localObject = null;
      } else {
        localObject = localPatternEntry.pattern.pattern();
      }
      paramParcel.writeString((String)localObject);
      paramParcel.writeInt(localPatternEntry.fsIdx);
      paramInt += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mm.vfs.CombinedFileSystem
 * JD-Core Version:    0.7.0.1
 */