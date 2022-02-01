package com.tencent.mobileqq.apollo.game;

import android.text.TextUtils;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.export.external.interfaces.WebResourceResponse;
import java.io.ByteArrayInputStream;
import java.io.FileInputStream;

public class ApolloGameResManager$ApolloGameRes
{
  public String a;
  public boolean a;
  public byte[] a;
  public String b;
  
  public WebResourceResponse a()
  {
    try
    {
      if (this.b != null)
      {
        Object localObject = this.jdField_a_of_type_ArrayOfByte;
        if ((localObject != null) && (!this.jdField_a_of_type_Boolean)) {
          return new WebResourceResponse(this.jdField_a_of_type_JavaLangString, "utf-8", new ByteArrayInputStream(this.jdField_a_of_type_ArrayOfByte));
        }
        if (FileUtils.fileExists(this.b))
        {
          localObject = new WebResourceResponse(this.jdField_a_of_type_JavaLangString, "utf-8", new FileInputStream(this.b));
          return localObject;
        }
        return null;
      }
    }
    catch (Throwable localThrowable)
    {
      QLog.e("[cmshow]ApolloGameResManager", 1, localThrowable, new Object[] { "[getResponse]" });
    }
    return null;
  }
  
  public void a()
  {
    try
    {
      if ((!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (!TextUtils.isEmpty(this.b)) && (FileUtils.fileExists(this.b))) {
        if (FileUtils.getFileOrFolderSize(this.b) > 8388608L) {
          this.jdField_a_of_type_Boolean = true;
        } else {
          this.jdField_a_of_type_ArrayOfByte = FileUtils.readFile(this.b);
        }
      }
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("[initData] ");
        localStringBuilder.append(this.b);
        QLog.d("[cmshow]ApolloGameResManager", 2, localStringBuilder.toString());
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      QLog.e("[cmshow]ApolloGameResManager", 1, localThrowable, new Object[] { "[initData]" });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.game.ApolloGameResManager.ApolloGameRes
 * JD-Core Version:    0.7.0.1
 */