package com.tencent.mobileqq.apollo.api.res.impl;

import com.tencent.biz.common.util.ZipUtils.ZipFilenameFilter;
import java.io.File;
import java.util.zip.ZipEntry;

class ApolloResDownloaderImpl$1$1
  implements ZipUtils.ZipFilenameFilter
{
  ApolloResDownloaderImpl$1$1(ApolloResDownloaderImpl.1 param1, StringBuilder paramStringBuilder, String paramString) {}
  
  public boolean accept(ZipEntry paramZipEntry)
  {
    if (paramZipEntry.isDirectory())
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqApolloApiResImplApolloResDownloaderImpl$1.a != null) && (this.jdField_a_of_type_ComTencentMobileqqApolloApiResImplApolloResDownloaderImpl$1.a.length > 0))
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqApolloApiResImplApolloResDownloaderImpl$1.a;
        int j = localObject.length;
        int i = 0;
        while (i < j)
        {
          int k = localObject[i];
          if (paramZipEntry.getName().equals(Integer.valueOf(k + File.separatorChar)))
          {
            this.jdField_a_of_type_JavaLangStringBuilder.append(paramZipEntry.getName()).append(" download, ");
            return false;
          }
          i += 1;
        }
      }
      Object localObject = new File(this.jdField_a_of_type_JavaLangString + paramZipEntry.getName());
      if ((localObject != null) && (((File)localObject).isDirectory()) && (((File)localObject).list().length >= 3))
      {
        this.jdField_a_of_type_JavaLangStringBuilder.append(paramZipEntry.getName()).append(" exist, ");
        return false;
      }
      this.jdField_a_of_type_JavaLangStringBuilder.append(paramZipEntry.getName()).append(" copy, ");
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.api.res.impl.ApolloResDownloaderImpl.1.1
 * JD-Core Version:    0.7.0.1
 */