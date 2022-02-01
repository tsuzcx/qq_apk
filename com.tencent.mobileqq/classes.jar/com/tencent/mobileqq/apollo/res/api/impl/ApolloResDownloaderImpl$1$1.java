package com.tencent.mobileqq.apollo.res.api.impl;

import com.tencent.biz.common.util.ZipUtils.ZipFilenameFilter;
import java.io.File;
import java.util.zip.ZipEntry;

class ApolloResDownloaderImpl$1$1
  implements ZipUtils.ZipFilenameFilter
{
  ApolloResDownloaderImpl$1$1(ApolloResDownloaderImpl.1 param1, StringBuilder paramStringBuilder, String paramString) {}
  
  public boolean accept(ZipEntry paramZipEntry)
  {
    if (!paramZipEntry.isDirectory()) {
      return true;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqApolloResApiImplApolloResDownloaderImpl$1.a != null) && (this.jdField_a_of_type_ComTencentMobileqqApolloResApiImplApolloResDownloaderImpl$1.a.length > 0))
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqApolloResApiImplApolloResDownloaderImpl$1.a;
      int j = localObject.length;
      int i = 0;
      while (i < j)
      {
        int k = localObject[i];
        if (paramZipEntry.getName().equals(Integer.valueOf(k + File.separatorChar)))
        {
          localObject = this.jdField_a_of_type_JavaLangStringBuilder;
          ((StringBuilder)localObject).append(paramZipEntry.getName());
          ((StringBuilder)localObject).append(" download, ");
          return false;
        }
        i += 1;
      }
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaLangString);
    ((StringBuilder)localObject).append(paramZipEntry.getName());
    localObject = new File(((StringBuilder)localObject).toString());
    if ((((File)localObject).isDirectory()) && (((File)localObject).list().length >= 3))
    {
      localObject = this.jdField_a_of_type_JavaLangStringBuilder;
      ((StringBuilder)localObject).append(paramZipEntry.getName());
      ((StringBuilder)localObject).append(" exist, ");
      return false;
    }
    localObject = this.jdField_a_of_type_JavaLangStringBuilder;
    ((StringBuilder)localObject).append(paramZipEntry.getName());
    ((StringBuilder)localObject).append(" copy, ");
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.res.api.impl.ApolloResDownloaderImpl.1.1
 * JD-Core Version:    0.7.0.1
 */