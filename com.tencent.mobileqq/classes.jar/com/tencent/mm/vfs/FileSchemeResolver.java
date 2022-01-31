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
    catch (IOException localIOException) {}
    return paramString.getAbsolutePath();
  }
  
  public static FileSchemeResolver instance()
  {
    return FileSchemeResolver.SingletonCreator.INSTANCE;
  }
  
  private Pair<ResolverState.MountPointEntry, String> resolveMountPoint(SchemeResolver.ResolverContext paramResolverContext, Uri paramUri)
  {
    Object localObject = null;
    List localList = ((ResolverState)paramResolverContext).mActiveMountPoints;
    paramResolverContext = paramUri.getPath();
    if ((paramResolverContext == null) || (paramResolverContext.isEmpty()))
    {
      QLog.e("VFS.FileSchemeResolver", 1, "resolveMountPoint is wrong! " + paramUri.toString());
      return null;
    }
    paramUri = canonicalizePath(paramResolverContext);
    int i = Collections.binarySearch(localList, paramUri);
    if (i >= 0)
    {
      paramUri = (ResolverState.MountPointEntry)localList.get(i);
      paramResolverContext = "";
    }
    for (;;)
    {
      return new Pair(paramUri, paramResolverContext);
      for (i = -i - 2;; i = paramResolverContext.fallbackIndex)
      {
        if (i < 0) {
          paramResolverContext = (SchemeResolver.ResolverContext)localObject;
        }
        do
        {
          if (i < 0) {
            break label188;
          }
          localObject = paramUri.substring(paramResolverContext.basePath.length() + 1);
          paramUri = paramResolverContext;
          paramResolverContext = (SchemeResolver.ResolverContext)localObject;
          break;
          paramResolverContext = (ResolverState.MountPointEntry)localList.get(i);
        } while ((paramUri.startsWith(paramResolverContext.basePath)) && (paramUri.charAt(paramResolverContext.basePath.length()) == '/'));
      }
      label188:
      if ((!paramUri.isEmpty()) && (paramUri.charAt(0) == '/'))
      {
        localObject = paramUri.substring(1);
        paramUri = paramResolverContext;
        paramResolverContext = (SchemeResolver.ResolverContext)localObject;
      }
      else
      {
        localObject = paramResolverContext;
        paramResolverContext = paramUri;
        paramUri = (Uri)localObject;
      }
    }
  }
  
  public Uri exportUri(SchemeResolver.ResolverContext paramResolverContext, Uri paramUri)
  {
    paramResolverContext = resolveMountPoint(paramResolverContext, paramUri);
    if ((paramResolverContext == null) || (paramResolverContext.first == null)) {
      return null;
    }
    return new Uri.Builder().scheme("wcf").authority(((ResolverState.MountPointEntry)paramResolverContext.first).fileSystemName).path((String)paramResolverContext.second).build();
  }
  
  public Pair<FileSystem, String> resolve(SchemeResolver.ResolverContext paramResolverContext, Uri paramUri)
  {
    paramUri = resolveMountPoint(paramResolverContext, paramUri);
    if (paramUri == null) {
      return null;
    }
    if (paramUri.first == null) {}
    for (paramResolverContext = paramResolverContext.root();; paramResolverContext = ((ResolverState.MountPointEntry)paramUri.first).fileSystem) {
      return new Pair(paramResolverContext, paramUri.second);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mm.vfs.FileSchemeResolver
 * JD-Core Version:    0.7.0.1
 */