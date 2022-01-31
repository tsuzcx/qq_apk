package com.tencent.biz.qqstory.takevideo.artfilter;

import android.text.TextUtils;
import bdcs;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import wyk;
import wym;

class ArtFilterManager$UpdateTask
  implements Runnable
{
  private List<wyk> jdField_a_of_type_JavaUtilList;
  private wym jdField_a_of_type_Wym;
  private boolean jdField_a_of_type_Boolean;
  
  public ArtFilterManager$UpdateTask(List<wyk> paramList, boolean paramBoolean, wym paramwym)
  {
    if (paramBoolean != null) {
      this.jdField_a_of_type_JavaUtilList = new ArrayList(paramBoolean);
    }
    Object localObject;
    if (localObject != null) {}
    try
    {
      this.jdField_a_of_type_Wym = ((wym)localObject.clone());
      this.jdField_a_of_type_Boolean = paramwym;
      return;
    }
    catch (CloneNotSupportedException paramList)
    {
      for (;;)
      {
        paramList.printStackTrace();
        this.jdField_a_of_type_Wym = null;
      }
    }
  }
  
  public void run()
  {
    int i;
    Object localObject2;
    Object localObject3;
    boolean bool;
    try
    {
      if (this.jdField_a_of_type_Boolean) {
        ArtFilterManager.a(this.this$0, this.jdField_a_of_type_JavaUtilList, this.jdField_a_of_type_Wym);
      }
      if (this.jdField_a_of_type_JavaUtilList != null) {
        break label827;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ArtFilterManager", 2, "[updateFilterResource] saved filters = null");
      }
      return;
    }
    finally {}
    String str;
    if (i < this.jdField_a_of_type_JavaUtilList.size())
    {
      wyk localwyk = (wyk)this.jdField_a_of_type_JavaUtilList.get(i);
      if (QLog.isColorLevel()) {
        QLog.d("ArtFilterManager", 2, "[updateFilterResource] saved artFilter:" + localwyk);
      }
      localObject2 = ArtFilterManager.b + localwyk.a();
      localObject3 = new File((String)localObject2);
      if (!((File)localObject3).exists())
      {
        File localFile = new File(ArtFilterManager.a + localwyk.a());
        if (localFile.exists())
        {
          bool = bdcs.d(localFile.getAbsolutePath(), ((File)localObject3).getAbsolutePath());
          if (bool) {
            bdcs.a(localFile.getParentFile().getAbsolutePath());
          }
          if (QLog.isColorLevel()) {
            QLog.e("ArtFilterManager", 2, "copy artfilter resource result:" + bool);
          }
        }
      }
      if (!((File)localObject3).exists())
      {
        ArtFilterManager.a(this.this$0, localwyk.b, (String)localObject2, localwyk.d);
      }
      else
      {
        localObject3 = localwyk.b();
        if (!new File(ArtFilterManager.b + (String)localObject3 + localwyk.c()).exists())
        {
          if (QLog.isColorLevel()) {
            QLog.e("ArtFilterManager", 2, "[updateFilterResource] zip exist but resource not exist:" + localwyk.a());
          }
          if (TextUtils.isEmpty(localwyk.d))
          {
            this.this$0.a((String)localObject2);
          }
          else
          {
            localObject3 = this.this$0.a((String)localObject2);
            if (localObject1.d.equalsIgnoreCase((String)localObject3))
            {
              this.this$0.a((String)localObject2);
            }
            else
            {
              if (QLog.isColorLevel()) {
                QLog.d("ArtFilterManager", 2, "[updateFilterResource] checkMd5 failed: " + (String)localObject2);
              }
              bdcs.d((String)localObject2);
            }
          }
        }
      }
    }
    else if (this.jdField_a_of_type_Wym != null)
    {
      str = this.jdField_a_of_type_Wym.b();
      localObject2 = new File(str);
      if (!((File)localObject2).exists())
      {
        localObject3 = new File(ArtFilterManager.a + this.jdField_a_of_type_Wym.d());
        if (((File)localObject3).exists())
        {
          bool = bdcs.d(((File)localObject3).getAbsolutePath(), ((File)localObject2).getAbsolutePath());
          if (bool) {
            bdcs.a(((File)localObject3).getParentFile().getAbsolutePath());
          }
          if (QLog.isColorLevel()) {
            QLog.e("ArtFilterManager", 2, "copy loading resource result:" + bool);
          }
        }
      }
      if (((File)localObject2).exists()) {
        break label635;
      }
      ArtFilterManager.a(this.this$0, this.jdField_a_of_type_Wym.c, str, this.jdField_a_of_type_Wym.b);
    }
    label822:
    label827:
    label839:
    label844:
    label847:
    for (;;)
    {
      label631:
      return;
      label635:
      localObject2 = new File(this.jdField_a_of_type_Wym.c());
      if ((!((File)localObject2).exists()) || (!((File)localObject2).isDirectory()))
      {
        if (!QLog.isColorLevel()) {
          break label839;
        }
        QLog.e("ArtFilterManager", 2, "[updateFilterResource] loading zip exist but loading resource not exist:" + str);
      }
      for (;;)
      {
        if (i == 0) {
          break label847;
        }
        localObject2 = this.this$0.a(str);
        if (this.jdField_a_of_type_Wym.b.equalsIgnoreCase((String)localObject2))
        {
          this.this$0.a(str);
          break label631;
          localObject2 = ((File)localObject2).listFiles();
          if ((localObject2 != null) && (localObject2.length == this.jdField_a_of_type_Wym.a)) {
            break label822;
          }
          if (!QLog.isColorLevel()) {
            break label844;
          }
          QLog.e("ArtFilterManager", 2, "[updateFilterResource] loading resource null or count is wrong");
          break label844;
        }
        if (QLog.isColorLevel()) {
          QLog.d("ArtFilterManager", 2, "[updateFilterResource] check loading Md5 failed: " + str);
        }
        bdcs.d(str);
        break label631;
        i = 0;
        continue;
        i = 0;
        break;
        i += 1;
        break;
        i = 1;
        continue;
        i = 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.artfilter.ArtFilterManager.UpdateTask
 * JD-Core Version:    0.7.0.1
 */