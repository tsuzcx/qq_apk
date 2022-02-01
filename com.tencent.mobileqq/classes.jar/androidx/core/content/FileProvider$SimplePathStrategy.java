package androidx.core.content;

import android.net.Uri;
import android.net.Uri.Builder;
import android.text.TextUtils;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

class FileProvider$SimplePathStrategy
  implements FileProvider.PathStrategy
{
  private final String mAuthority;
  private final HashMap<String, File> mRoots = new HashMap();
  
  FileProvider$SimplePathStrategy(String paramString)
  {
    this.mAuthority = paramString;
  }
  
  void addRoot(String paramString, File paramFile)
  {
    if (!TextUtils.isEmpty(paramString)) {
      try
      {
        localObject = paramFile.getCanonicalFile();
        this.mRoots.put(paramString, localObject);
        return;
      }
      catch (IOException paramString)
      {
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append("Failed to resolve canonical path for ");
        ((StringBuilder)localObject).append(paramFile);
        throw new IllegalArgumentException(((StringBuilder)localObject).toString(), paramString);
      }
    }
    throw new IllegalArgumentException("Name must not be empty");
  }
  
  public File getFileForUri(Uri paramUri)
  {
    Object localObject2 = paramUri.getEncodedPath();
    int i = ((String)localObject2).indexOf('/', 1);
    Object localObject1 = Uri.decode(((String)localObject2).substring(1, i));
    localObject2 = Uri.decode(((String)localObject2).substring(i + 1));
    localObject1 = (File)this.mRoots.get(localObject1);
    if (localObject1 != null) {
      paramUri = new File((File)localObject1, (String)localObject2);
    }
    try
    {
      localObject2 = paramUri.getCanonicalFile();
      if (((File)localObject2).getPath().startsWith(((File)localObject1).getPath())) {
        return localObject2;
      }
      throw new SecurityException("Resolved path jumped beyond configured root");
    }
    catch (IOException localIOException)
    {
      label100:
      break label100;
    }
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("Failed to resolve canonical path for ");
    ((StringBuilder)localObject1).append(paramUri);
    throw new IllegalArgumentException(((StringBuilder)localObject1).toString());
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("Unable to find configured root for ");
    ((StringBuilder)localObject1).append(paramUri);
    throw new IllegalArgumentException(((StringBuilder)localObject1).toString());
  }
  
  public Uri getUriForFile(File paramFile)
  {
    try
    {
      Object localObject2 = paramFile.getCanonicalPath();
      paramFile = null;
      Iterator localIterator = this.mRoots.entrySet().iterator();
      while (localIterator.hasNext())
      {
        localObject1 = (Map.Entry)localIterator.next();
        String str = ((File)((Map.Entry)localObject1).getValue()).getPath();
        if ((((String)localObject2).startsWith(str)) && ((paramFile == null) || (str.length() > ((File)paramFile.getValue()).getPath().length()))) {
          paramFile = (File)localObject1;
        }
      }
      if (paramFile != null)
      {
        localObject1 = ((File)paramFile.getValue()).getPath();
        if (((String)localObject1).endsWith("/")) {
          localObject1 = ((String)localObject2).substring(((String)localObject1).length());
        } else {
          localObject1 = ((String)localObject2).substring(((String)localObject1).length() + 1);
        }
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(Uri.encode((String)paramFile.getKey()));
        ((StringBuilder)localObject2).append('/');
        ((StringBuilder)localObject2).append(Uri.encode((String)localObject1, "/"));
        paramFile = ((StringBuilder)localObject2).toString();
        return new Uri.Builder().scheme("content").authority(this.mAuthority).encodedPath(paramFile).build();
      }
      paramFile = new StringBuilder();
      paramFile.append("Failed to find configured root that contains ");
      paramFile.append((String)localObject2);
      throw new IllegalArgumentException(paramFile.toString());
    }
    catch (IOException localIOException)
    {
      Object localObject1;
      label254:
      break label254;
    }
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("Failed to resolve canonical path for ");
    ((StringBuilder)localObject1).append(paramFile);
    paramFile = new IllegalArgumentException(((StringBuilder)localObject1).toString());
    for (;;)
    {
      throw paramFile;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.core.content.FileProvider.SimplePathStrategy
 * JD-Core Version:    0.7.0.1
 */