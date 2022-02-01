package com.tencent.mobileqq.apollo.handler;

import android.util.SparseArray;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileFilter;
import org.json.JSONObject;

class ApolloContentUpdateHandler$1
  implements FileFilter
{
  ApolloContentUpdateHandler$1(ApolloContentUpdateHandler paramApolloContentUpdateHandler, SparseArray paramSparseArray) {}
  
  public boolean accept(File paramFile)
  {
    Object localObject = new File(paramFile, "config.json");
    if ((((File)localObject).exists()) && (((File)localObject).isFile())) {
      localObject = FileUtils.readFileContent((File)localObject);
    }
    try
    {
      int i = Integer.parseInt(paramFile.getName());
      long l = new JSONObject((String)localObject).optLong("version");
      this.a.append(i, Long.valueOf(l));
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getApolloRoleReqInfo roleId: ");
      ((StringBuilder)localObject).append(i);
      ((StringBuilder)localObject).append(", ver: ");
      ((StringBuilder)localObject).append(l / 1000L);
      QLog.i("[cmshow]ApolloContentUpdateHandler", 1, ((StringBuilder)localObject).toString());
    }
    catch (Exception localException)
    {
      label127:
      break label127;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getApolloRoleReqInfo failed role: ");
      ((StringBuilder)localObject).append(paramFile.getAbsolutePath());
      QLog.e("[cmshow]ApolloContentUpdateHandler", 1, ((StringBuilder)localObject).toString());
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.handler.ApolloContentUpdateHandler.1
 * JD-Core Version:    0.7.0.1
 */