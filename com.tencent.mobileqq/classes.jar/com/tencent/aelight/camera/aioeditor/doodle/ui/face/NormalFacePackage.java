package com.tencent.aelight.camera.aioeditor.doodle.ui.face;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.net.URI;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class NormalFacePackage
  extends FacePackage
{
  public String k;
  public String l;
  public final List<NormalFacePackage.PackageInfo> m = new ArrayList();
  public boolean n;
  public int o = 100;
  public int p = 0;
  
  public NormalFacePackage(@NonNull String paramString)
  {
    super(paramString);
  }
  
  public String a(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.m.size())) {
      return ((NormalFacePackage.PackageInfo)this.m.get(paramInt)).b;
    }
    return null;
  }
  
  public void a(List<NormalFacePackage.PackageInfo> paramList)
  {
    if (paramList == null) {
      return;
    }
    this.m.clear();
    this.m.addAll(paramList);
  }
  
  public String b(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.m.size())) {
      return ((NormalFacePackage.PackageInfo)this.m.get(paramInt)).d;
    }
    return null;
  }
  
  public String b(String paramString)
  {
    if (!StringUtil.isEmpty(paramString))
    {
      Object localObject = this.m;
      if (localObject != null)
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          NormalFacePackage.PackageInfo localPackageInfo = (NormalFacePackage.PackageInfo)((Iterator)localObject).next();
          if (paramString.equals(localPackageInfo.a)) {
            return localPackageInfo.b;
          }
        }
      }
    }
    return null;
  }
  
  public int c(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.m.size())) {
      return ((NormalFacePackage.PackageInfo)this.m.get(paramInt)).c;
    }
    return 0;
  }
  
  public int c(String paramString)
  {
    if (!StringUtil.isEmpty(paramString))
    {
      Object localObject = this.m;
      if (localObject != null)
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          NormalFacePackage.PackageInfo localPackageInfo = (NormalFacePackage.PackageInfo)((Iterator)localObject).next();
          if (paramString.equals(localPackageInfo.a)) {
            return localPackageInfo.c;
          }
        }
      }
    }
    return 0;
  }
  
  public String c()
  {
    return "NormalFacePackage";
  }
  
  public int d()
  {
    return this.m.size();
  }
  
  public List<NormalFacePackage.PackageInfo> e()
  {
    ArrayList localArrayList = new ArrayList();
    if (TextUtils.isEmpty(this.l)) {
      return null;
    }
    Object localObject1 = new File(this.l);
    if (!((File)localObject1).exists()) {
      return null;
    }
    if (((File)localObject1).isDirectory())
    {
      File[] arrayOfFile = ((File)localObject1).listFiles(new NormalFacePackage.1(this));
      if (arrayOfFile != null)
      {
        int i1 = arrayOfFile.length;
        int j = 0;
        while (j < i1)
        {
          File localFile = arrayOfFile[j];
          if (this.m.size() >= 100) {
            return localArrayList;
          }
          String str = localFile.getName();
          int i;
          if (str.endsWith(".apng")) {
            i = 1;
          } else if (str.endsWith(".gif")) {
            i = 2;
          } else {
            i = 0;
          }
          if (i == 1)
          {
            localObject1 = localFile.getAbsolutePath();
            Object localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append(((String)localObject1).substring(0, ((String)localObject1).length() - 5));
            ((StringBuilder)localObject2).append(".bpng");
            localObject1 = ((StringBuilder)localObject2).toString();
            localObject2 = new File((String)localObject1);
            if ((((File)localObject2).isFile()) && (((File)localObject2).exists()))
            {
              localObject1 = ((File)localObject2).toURI().toString();
              break label285;
            }
            if (QLog.isColorLevel())
            {
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("dynamicStatic thumbFile not exist ");
              ((StringBuilder)localObject2).append((String)localObject1);
              QLog.d("FacePackage", 2, ((StringBuilder)localObject2).toString());
            }
          }
          localObject1 = null;
          label285:
          localArrayList.add(new NormalFacePackage.PackageInfo(str, localFile.toURI().toString(), i, (String)localObject1));
          j += 1;
        }
      }
    }
    return localArrayList;
  }
  
  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer("NormalFacePackage{");
    localStringBuffer.append("id='");
    localStringBuffer.append(this.a);
    localStringBuffer.append('\'');
    localStringBuffer.append("logoUrl='");
    localStringBuffer.append(this.c);
    localStringBuffer.append('\'');
    localStringBuffer.append("logoDrawable='");
    localStringBuffer.append(this.e);
    localStringBuffer.append('\'');
    localStringBuffer.append(", zipDownloadUrl='");
    localStringBuffer.append(this.k);
    localStringBuffer.append('\'');
    localStringBuffer.append(", facePkgPath='");
    localStringBuffer.append(this.l);
    localStringBuffer.append('\'');
    localStringBuffer.append(", isDownloading=");
    localStringBuffer.append(this.n);
    localStringBuffer.append(", maxProgress=");
    localStringBuffer.append(this.o);
    localStringBuffer.append(", currentProgress=");
    localStringBuffer.append(this.p);
    localStringBuffer.append('}');
    return localStringBuffer.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.doodle.ui.face.NormalFacePackage
 * JD-Core Version:    0.7.0.1
 */