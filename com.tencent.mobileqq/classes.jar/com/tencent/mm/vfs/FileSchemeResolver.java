package com.tencent.mm.vfs;

import android.net.Uri;
import android.net.Uri.Builder;
import android.util.Pair;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

public class FileSchemeResolver
  extends SchemeResolver.Base
{
  public static final FileSchemeResolver.SingletonCreator CREATOR = new FileSchemeResolver.SingletonCreator(null);
  private static final String TAG = "VFS.FileSchemeResolver";
  
  private static String canonicalizePath(String paramString)
  {
    paramString = new File(paramString);
    try
    {
      String str = paramString.getCanonicalPath();
      return str;
    }
    catch (IOException localIOException)
    {
      label16:
      break label16;
    }
    return paramString.getAbsolutePath();
  }
  
  public static FileSchemeResolver instance()
  {
    return FileSchemeResolver.SingletonCreator.INSTANCE;
  }
  
  private Pair<ResolverState.MountPointEntry, String> resolveMountPoint(SchemeResolver.ResolverContext paramResolverContext, Uri paramUri)
  {
    paramResolverContext = ((ResolverState)paramResolverContext).mActiveMountPoints;
    Object localObject = paramUri.getPath();
    if ((localObject != null) && (!((String)localObject).isEmpty()))
    {
      String str = canonicalizePath((String)localObject);
      int i = Collections.binarySearch(paramResolverContext, str);
      if (i >= 0)
      {
        localObject = (ResolverState.MountPointEntry)paramResolverContext.get(i);
        paramResolverContext = "";
      }
      for (i = -i - 2;; i = paramUri.fallbackIndex)
      {
        if (i < 0)
        {
          paramUri = null;
        }
        else
        {
          paramUri = (ResolverState.MountPointEntry)paramResolverContext.get(i);
          if ((!str.startsWith(paramUri.basePath)) || (str.charAt(paramUri.basePath.length()) != '/')) {
            continue;
          }
        }
        if (i >= 0)
        {
          paramResolverContext = str.substring(paramUri.basePath.length() + 1);
          localObject = paramUri;
        }
        else
        {
          paramResolverContext = str;
          localObject = paramUri;
          if (!str.isEmpty())
          {
            paramResolverContext = str;
            localObject = paramUri;
            if (str.charAt(0) == '/')
            {
              paramResolverContext = str.substring(1);
              localObject = paramUri;
            }
          }
        }
        return new Pair(localObject, paramResolverContext);
      }
    }
    paramResolverContext = new StringBuilder();
    paramResolverContext.append("resolveMountPoint is wrong! ");
    paramResolverContext.append(paramUri.toString());
    QLog.e("VFS.FileSchemeResolver", 1, paramResolverContext.toString());
    return null;
  }
  
  public Uri exportUri(SchemeResolver.ResolverContext paramResolverContext, Uri paramUri)
  {
    paramResolverContext = resolveMountPoint(paramResolverContext, paramUri);
    if ((paramResolverContext != null) && (paramResolverContext.first != null)) {
      return new Uri.Builder().scheme("wcf").authority(((ResolverState.MountPointEntry)paramResolverContext.first).fileSystemName).path((String)paramResolverContext.second).build();
    }
    return null;
  }
  
  public Pair<FileSystem, String> resolve(SchemeResolver.ResolverContext paramResolverContext, Uri paramUri)
  {
    paramUri = resolveMountPoint(paramResolverContext, paramUri);
    if (paramUri == null) {
      return null;
    }
    if (paramUri.first == null) {
      paramResolverContext = paramResolverContext.root();
    } else {
      paramResolverContext = ((ResolverState.MountPointEntry)paramUri.first).fileSystem;
    }
    return new Pair(paramResolverContext, paramUri.second);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mm.vfs.FileSchemeResolver
 * JD-Core Version:    0.7.0.1
 */