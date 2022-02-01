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
  public final List<NormalFacePackage.PackageInfo> a;
  public boolean b;
  public int c;
  public int d = 0;
  public String f;
  public String g;
  
  public NormalFacePackage(@NonNull String paramString)
  {
    super(paramString);
    this.jdField_c_of_type_Int = 100;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  public int a(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.jdField_a_of_type_JavaUtilList.size())) {
      return ((NormalFacePackage.PackageInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt)).jdField_a_of_type_Int;
    }
    return 0;
  }
  
  public int a(String paramString)
  {
    if (!StringUtil.a(paramString))
    {
      Object localObject = this.jdField_a_of_type_JavaUtilList;
      if (localObject != null)
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          NormalFacePackage.PackageInfo localPackageInfo = (NormalFacePackage.PackageInfo)((Iterator)localObject).next();
          if (paramString.equals(localPackageInfo.jdField_a_of_type_JavaLangString)) {
            return localPackageInfo.jdField_a_of_type_Int;
          }
        }
      }
    }
    return 0;
  }
  
  public String a()
  {
    return "NormalFacePackage";
  }
  
  public String a(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.jdField_a_of_type_JavaUtilList.size())) {
      return ((NormalFacePackage.PackageInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt)).b;
    }
    return null;
  }
  
  public String a(String paramString)
  {
    if (!StringUtil.a(paramString))
    {
      Object localObject = this.jdField_a_of_type_JavaUtilList;
      if (localObject != null)
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          NormalFacePackage.PackageInfo localPackageInfo = (NormalFacePackage.PackageInfo)((Iterator)localObject).next();
          if (paramString.equals(localPackageInfo.jdField_a_of_type_JavaLangString)) {
            return localPackageInfo.b;
          }
        }
      }
    }
    return null;
  }
  
  public List<NormalFacePackage.PackageInfo> a()
  {
    ArrayList localArrayList = new ArrayList();
    if (TextUtils.isEmpty(this.g)) {
      return null;
    }
    Object localObject1 = new File(this.g);
    if (!((File)localObject1).exists()) {
      return null;
    }
    if (((File)localObject1).isDirectory())
    {
      File[] arrayOfFile = ((File)localObject1).listFiles(new NormalFacePackage.1(this));
      if (arrayOfFile != null)
      {
        int k = arrayOfFile.length;
        int j = 0;
        while (j < k)
        {
          File localFile = arrayOfFile[j];
          if (this.jdField_a_of_type_JavaUtilList.size() >= 100) {
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
  
  public void a(List<NormalFacePackage.PackageInfo> paramList)
  {
    if (paramList == null) {
      return;
    }
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaUtilList.addAll(paramList);
  }
  
  public int b()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public String b(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.jdField_a_of_type_JavaUtilList.size())) {
      return ((NormalFacePackage.PackageInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt)).jdField_c_of_type_JavaLangString;
    }
    return null;
  }
  
  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer("NormalFacePackage{");
    localStringBuffer.append("id='");
    localStringBuffer.append(this.jdField_a_of_type_JavaLangString);
    localStringBuffer.append('\'');
    localStringBuffer.append("logoUrl='");
    localStringBuffer.append(this.jdField_c_of_type_JavaLangString);
    localStringBuffer.append('\'');
    localStringBuffer.append("logoDrawable='");
    localStringBuffer.append(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
    localStringBuffer.append('\'');
    localStringBuffer.append(", zipDownloadUrl='");
    localStringBuffer.append(this.f);
    localStringBuffer.append('\'');
    localStringBuffer.append(", facePkgPath='");
    localStringBuffer.append(this.g);
    localStringBuffer.append('\'');
    localStringBuffer.append(", isDownloading=");
    localStringBuffer.append(this.b);
    localStringBuffer.append(", maxProgress=");
    localStringBuffer.append(this.jdField_c_of_type_Int);
    localStringBuffer.append(", currentProgress=");
    localStringBuffer.append(this.d);
    localStringBuffer.append('}');
    return localStringBuffer.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.doodle.ui.face.NormalFacePackage
 * JD-Core Version:    0.7.0.1
 */